/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LRAssessIndexPDB;
import com.sinosoft.lis.db.LRIndexVsCommPDB;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubFun1;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.lis.schema.LRAssessIndexPSchema;
import com.sinosoft.lis.schema.LRIndexVsCommPSchema;
import com.sinosoft.lis.vschema.LRAssessIndexPSet;
import com.sinosoft.lis.vschema.LRIndexVsCommPSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class LARuleStatusBL {
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    private String mOperate;// 数据操作字符串
    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
    private MMap mMap = new MMap();
    private VData mResult = new VData();// 存放返回数据的容器

    private String mBaseCode = "";
    private String mName = "";
    private String mBranchType = "";
    private String mStatus = "";
    private String mReason="";
    List mRuleGrid = new ArrayList();//基本法审核结果
    ExeSQL exe = new ExeSQL(); 
    private String currentDate = PubFun.getCurrentDate();
    private String currentTime = PubFun.getCurrentTime();

    public LARuleStatusBL() {
    }

    /**
     * 传输数据的公共方法
     */
    public boolean check() {
        return true;
    }

    public boolean submitData(VData cInputData, String cOperate) {
        // 将操作数据拷贝到本类中
        this.mOperate = cOperate;
        // 得到外部传入的数据,将数据备份到本类中
        if (!getInputData(cInputData)) {
            return false;
        }
        if (!check()) {
            return false;
        }
        // 进行业务处理
        if (!dealData()) {
            if(!mErrors.needDealError()) {
                CError.buildErr(this, bundle.getString("Src_BL_dealDateErr"));
            }
            return false;
        }

        //开始提交
        VData tVData = new VData();
        tVData.add(mMap);
        PubSubmit tPubSubmit = new PubSubmit();
        if (!tPubSubmit.submitData(tVData, "")) {
            // @@错误处理
            CError.buildErr(this, bundle.getString("Src_pubSubmitErr"));
            return false;
        }
        return true;
    }

    /**
     * 从输入数据中得到所有对象
     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
     */
    public boolean getInputData(VData cInputData) {
        // 全局变量
        mGlobalInput = (GlobalInput) cInputData.get(0);
        TransferData transferData = (TransferData) cInputData.get(1);
        mBaseCode = (String)transferData.getValueByName("BaseCode");
        mName = (String)transferData.getValueByName("Name");
        mBranchType = (String)transferData.getValueByName("BranchType");
        mStatus = (String)transferData.getValueByName("Status");
        mReason = (String)transferData.getValueByName("Reason");
        mRuleGrid = (List)transferData.getValueByName("mulRuleGrid");//基本法审核结果

        if (mGlobalInput == null) {
            CError.buildErr(this, bundle.getString("Src_UI_getInputDataErr"));
            return false;
        }
        return true;
    }

    /**
     * by fengfei 2014-10-9
     * 在此一次性初始化LRAssessIndexP表，提高效率
     */
    public Map<String, LRAssessIndexPSchema> indexMap;
    public Map<String, String> sqlMap;
    public boolean initIndexMap(String basecode)
    {
    	if(this.indexMap == null)
    	{
    		this.indexMap = new HashMap<String, LRAssessIndexPSchema>();
    		this.sqlMap = new HashMap<String, String>();
    		LRAssessIndexPSchema tLRAssessIndexPSchema = new LRAssessIndexPSchema();
    		tLRAssessIndexPSchema.setBaseCode(basecode);
    		LRAssessIndexPDB db = new LRAssessIndexPDB();
    		db.setSchema(tLRAssessIndexPSchema);
    		LRAssessIndexPSet set = db.query();
    		for(int i = 1; i <= set.size(); i++)
    		{
    			LRAssessIndexPSchema schema = set.get(i);
    			String key = schema.getBaseCode()+schema.getAgentGrade()+schema.getIndexType()+schema.getIndexCode();
//    			System.out.println("schema.getCalSql()--->"+schema.getCalSql());
    			this.indexMap.put(key, schema);
    		}
    		
    		String querySql = "select BaseCode,agentgrade,indextype,IndexCode,isnull(calsql,'null') from lrassessindexp where basecode='"+basecode+"'";
    		SSRS sqlrs = exe.execSQL(querySql);
    		if(sqlrs.MaxRow < 1) {
    			return false;
    		}
			for(int i = 1; i <= sqlrs.MaxRow; i++)
    		{
    			String key = sqlrs.GetText(i, 1)+sqlrs.GetText(i, 2)+sqlrs.GetText(i, 3)+sqlrs.GetText(i, 4);
//    			System.out.println("sqlrs.GetText(i, 1)--->"+sqlrs.GetText(i, 5));
    			this.sqlMap.put(key, sqlrs.GetText(i, 5));
    		}
    	}
		return true;
    }
    /**
     * 业务处理主函数    
     *
     * @return boolean
     */
    public boolean dealData() {
        if (mOperate.equals("status")) {
            //提请审核
        	String[] str= new String[8]; 
        	str=(String[])mRuleGrid.get(0);
        	String EdorNo=PubFun1.CreateMaxNo("LRBaseB", 20);
    		String Operator2= mGlobalInput.Operator;
    		String MakeTime2=currentTime;
    		String MakeDate2=currentDate;
    		String ModifyTime2=currentTime;
    		String ModifyDate2=currentDate;
        	String tem="insert into LRBaseB(EdorNo,Operator2,MakeTime2,MakeDate2,ModifyTime2,ModifyDate2,BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,EDORTYPE) select '"+EdorNo+"','"+Operator2+"','"+MakeTime2+"','"+MakeDate2+"','"+ModifyTime2+"','"+ModifyDate2+"',BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,'04' from LRBase where BaseCode='"+str[1]+"'";
        	String sql1="update LRBase set status='"+mStatus+"' where baseCode='"+str[1]+"'";
//        	String sql = "select * from LRIndexVsCommp where basecode='"+str[1]+"' order by wageorder";
        	String t = "薪资配置中";
    		LRIndexVsCommPDB db = new LRIndexVsCommPDB();
//    		LRIndexVsCommPSet commSet = db.executeQuery(sql);
    		
    		String sql = "select * from LRIndexVsCommp where basecode=? order by wageorder "; 
    		List paraList =new ArrayList(); 
    		paraList.add(str[1]); 
    		LRIndexVsCommPSet commSet  = db.executeQuery(sql,PubFun.getFormatBV(paraList)); 
    		
    		for(int i = 1; i <= commSet.size(); i++) {
    			if (!this.initIndexMap(str[1])) {
					return false;
				}
				LRIndexVsCommPSchema commSchema = commSet.get(i);
    			String indexCode = commSchema.getIndexCode();
    			String indextype = commSchema.getIndexType();
//    			System.out.println("[*****计算项目*****]" + commSchema.getWageName() + ":(WageCode=" + commSchema.getWageCode() + ")");
//    			LRAssessIndexPDB indexDB = new LRAssessIndexPDB();
//    			indexDB.setBaseCode(str[1]);
//    			indexDB.setIndexCode(indexCode);
//    			indexDB.setIndexType(indextype);
//    			indexDB.setAgentGrade(commSchema.getAgentGrade());
    			String key = str[1]+commSchema.getAgentGrade()+indextype+indexCode;
    			switch(Integer.parseInt(commSchema.getIndexType())){
    		    case 1:
    			    t = "薪资配置中";
    			    break;
    			case 21:
    				t = "维持考核配置中";
    				break;
    			case 22:
    			    t = "晋升考核配置中";
    			    break;
    			case 23:
    				t = "考核结果配置中";
    				break;
    		}
        		if(!this.indexMap.containsKey(key)) {
//    			if(!indexDB.getInfo()) {
        			System.out.println("[*****计算项目*****]" + commSchema.getWageName() + ":(WageCode=" + commSchema.getWageCode() + ")");
					System.out.println("key ---->"+ key);
    				if(indexCode == null || indexCode.trim().equals("")){
    					//CError.buildErr(this, "还没有为"+t+"职级【"+commSchema.getAgentGrade()+"】-项目【"+commSchema.getWageCode()+commSchema.getWageName()+"】配置规则！");
    					CError.buildErr(this, bundle.getString("Rule_01_1")+t+bundle.getString("Title")+"【"+commSchema.getAgentGrade()+"】-"+bundle.getString("Rule_01_2")+"【"+commSchema.getWageCode()+commSchema.getWageName()+"】"+bundle.getString("Rule_01_3"));
    				}else{
    					CError.buildErr(this, bundle.getString("Rule_01_1")+t+bundle.getString("Title")+"【"+commSchema.getAgentGrade()+"】-"+bundle.getString("Rule_01_2")+"【"+commSchema.getWageCode()+commSchema.getWageName()+"】"+bundle.getString("Rule_02_3")+"【"+commSchema.getIndexCode()+"】"+bundle.getString("Rule_02_4"));
    				}
    				return false;
    			}
    			if(!checkPara(this.indexMap.get(key),t)){
//    			if(!checkPara(indexDB.getSchema(),t)){
        			System.out.println("[*****计算项目*****]" + commSchema.getWageName() + ":(WageCode=" + commSchema.getWageCode() + ")");
					System.out.println("key ---->"+ key);
        			return false;
    			}
    			
    		} 
        	mMap.put(tem,"INSERT");  
        	mMap.put(sql1,"UPDATE");   
        }
        return true;
    }
    
    public boolean checkPara(LRAssessIndexPSchema schema,String t){    	
    	String indexSet = schema.getIndexSet();
		String key = "";
		//计算子指标
		if(indexSet != null && !indexSet.trim().equals("")) {
			String[] sets = indexSet.trim().split(",");
			for(int i = 0; i < sets.length; i++) {
//				LRAssessIndexPDB indexDB = new LRAssessIndexPDB();
//				indexDB.setBaseCode(schema.getBaseCode());
//				indexDB.setIndexCode(sets[i]);
//    			indexDB.setAgentGrade(schema.getAgentGrade());
//    			indexDB.setIndexType(schema.getIndexType());
    			key = schema.getBaseCode()+schema.getAgentGrade()+schema.getIndexType()+sets[i];
				if(!this.indexMap.containsKey(key)) {
//				if(!indexDB.getInfo()) {
					System.out.println("key ---->"+ key);
					CError.buildErr(this, bundle.getString("Rule_03_1")+t+bundle.getString("Title")+"【"+schema.getAgentGrade()+"】-"+bundle.getString("Rule_03_2")+"【"+schema.getIndexCode()+"】");
					return false;
				}
				if(!checkPara(this.indexMap.get(key),t)){
//				if(!checkPara(indexDB.getSchema(),t)){
					System.out.println("key ---->"+ key);
					return false;
				}
			}
		}
//    	System.out.println("[计算指标]" + schema.getIndexName() + ":(IndexCode=" + schema.getIndexCode() + ")");
//		String querySql = "select isnull(calsql,'null') from lrassessindexp where agentgrade = '"+schema.getAgentGrade()+"' and  BaseCode='"+schema.getBaseCode()+"' and IndexCode='"+schema.getIndexCode()+"'";//计算基础指标
//		SSRS sqlrs = exe.execSQL(querySql);
//		if(sqlrs.MaxRow < 1) {
//			return false;
//		}
//		String calSQL = sqlrs.GetText(1, 1);
		key = schema.getBaseCode()+schema.getAgentGrade()+schema.getIndexType()+schema.getIndexCode();
		String calSQL = this.sqlMap.get(key);
		if(calSQL == null || calSQL.trim().equals("")|| calSQL.trim().equals("null")) {
	    	System.out.println("[计算指标]" + schema.getIndexName() + ":(IndexCode=" + schema.getIndexCode() + ")");
			System.out.println("calsql ---->"+ calSQL);
			CError.buildErr(this, "CALSQL"+bundle.getString("Rule_isblank")+"(IndexType:"+schema.getIndexType()+",AgentGrade:"+schema.getAgentGrade()+"IndexCode:" +schema.getIndexCode()+ ")");
			return false;
		}
		if(calSQL.indexOf("#") > -1) {
	    	System.out.println("[计算指标]" + schema.getIndexName() + ":(IndexCode=" + schema.getIndexCode() + ")");
			System.out.println("calsql ---->"+ calSQL);
			CError.buildErr(this, bundle.getString("Rule_01_1")+t+bundle.getString("Title")+"【"+schema.getAgentGrade()+"】-"+bundle.getString("Rule_04_2")+"【"+schema.getIndexCode()+"】"+bundle.getString("Rule_04_3"));
			return false;
		}
		while(calSQL.indexOf("@") != -1) {
			int begin = calSQL.indexOf("@");
			int end = calSQL.indexOf("@", begin+1);
			String indexcode = calSQL.substring(begin+1, end);
//			String sql = "select datatype  from LRAssessIndexp where  basecode ='"+schema.getBaseCode()+"' and agentgrade = '"+schema.getAgentGrade()+"' and indexcode='"+indexcode+"'";
//			SSRS ssrs = exe.execSQL(sql);
			key = schema.getBaseCode()+schema.getAgentGrade()+schema.getIndexType()+indexcode;
			if(!this.indexMap.containsKey(key)) {
//			if(ssrs.MaxRow <= 0) {
		    	System.out.println("[计算指标]" + schema.getIndexName() + ":(IndexCode=" + schema.getIndexCode() + ")");
				System.out.println("key ---->"+ key);
				CError.buildErr(this, bundle.getString("Rule_05_1")+t+bundle.getString("Title")+"【"+schema.getAgentGrade()+"】-"+bundle.getString("Rule_05_2")+"【"+schema.getIndexCode()+"】");
				return false;
			}
			calSQL = calSQL.replaceAll("@"+indexcode+"@", "(select 1 from dual)");
		}
		return true;
    }

    /**
     * 这个方法返回的结果中存放程序执行后的结果
     * 如果程序需要返回数据，可以通过这个方法实现
     *
     * @return 返回一个VData容器
     */
    public VData getResult() {
        return mResult;
    }

}
