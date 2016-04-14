/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;
public class LAIndexResultBL {
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    private String mOperate;// 数据操作字符串
    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
    private MMap mMap = new MMap();
    private VData mResult = new VData();// 存放返回数据的容器

    private String mBranchType = "";
    private String mBaseCode = "";
    private String mIndexSerise = "";
    private String mAgentGrade = "";
    private String mWageType="";
    private String mIndexType="";
    private String mWageCode="";
    private ExeSQL exe = new ExeSQL();
    
    List mIndexGrid = new ArrayList();//职级已有项目列表
    List mRuleGrid = new ArrayList();//职级未有项目列表

    private String currentDate = PubFun.getCurrentDate();
    private String currentTime = PubFun.getCurrentTime();

    public LAIndexResultBL() {
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
        mBranchType = (String)transferData.getValueByName("BranchType");
        mBaseCode = (String)transferData.getValueByName("BaseCode");
        mWageType = (String)transferData.getValueByName("WageType");
        mIndexType = (String)transferData.getValueByName("IndexType");
        mAgentGrade = (String)transferData.getValueByName("AgentGrade");
        mIndexSerise = (String)transferData.getValueByName("IndexSerise");
        mWageCode = (String)transferData.getValueByName("WageCode");
        mRuleGrid = (List)transferData.getValueByName("mulRuleGrid");//职级未有项目列表

        if (mGlobalInput == null) {
            CError.buildErr(this, bundle.getString("Src_UI_getInputDataErr"));
            return false;
        }
        return true;
    }

    /**
     * 业务处理主函数
     *
     * @return boolean
     */   
    public boolean dealData() {
    	if(mOperate.equals("remove")){    		
    		String del_sql = "delete from LRIndexVsCommP where  basecode='"+mBaseCode+"' and branchtype=(select branchtype from LRBase where basecode='"+mBaseCode+"') and agentgrade='"+mAgentGrade+"' and indextype = '"+mIndexType+"'";
    		del();
        	mMap.put(del_sql, "DELETE");
    	}else if(mOperate.equals("add")){
    		String sql = "select indexcode from LRIndexVsCommP where  basecode='"+mBaseCode+"' and branchtype=(select branchtype from LRBase where basecode='"+mBaseCode+"') and agentgrade='"+mAgentGrade+"' and indextype = '"+mIndexType+"'";
    		SSRS ssrs = exe.execSQL(sql);
    		if(ssrs.getMaxRow()>0){
    			//CError.buildErr(this, "考核结果只能选择一个项目！");
    			CError.buildErr(this, bundle.getString("ExaminationResultcannotselectmorethanonewage!"));
				return false;
    		}
    		String ins= "insert into LRIndexVsCommP (agentgrade,wagecode,wagename,branchtype,basecode,IndexType,managecom,indexserise,wageorder,description) select '"+mAgentGrade+"',wagecode,wagename,branchtype,'"+mBaseCode+"','"+mIndexType+"','"+mGlobalInput.ManageCom+"',indexserise,(select case when max(wageorder) >=0 then max(wageorder)+1 else 1 end from lrindexvscommp where basecode='"+mBaseCode+"' and agentgrade='"+mAgentGrade+"' and indextype='"+mIndexType+"'),description  from LRIndex Where wageCode='"+mWageCode+"' and branchtype='"+mBranchType+"'";
    		mMap.put(ins, "INSERT");
    	}
        return true;
    }

    public boolean del(){
    	String sql_IndexCode = "select isnull(b.allset,'null') from LRIndexVsCommP a,lrassessindexP b where a.wagecode='"+mWageCode+"'  and a.basecode='"+mBaseCode+"' and a.agentgrade='"+mAgentGrade+"' and a.indextype = '"+mIndexType+"' and a.indexcode = b.indexcode and a.basecode=b.basecode and a.agentgrade=b.agentgrade";
    	String allset = "";
		SSRS ssrs = exe.execSQL(sql_IndexCode);
		if(ssrs.getMaxRow()>0){
			allset =  ssrs.GetText(1, 1);
		}
		System.out.print("allset ------ >"+allset);
		if(!"".equals(allset)&&!"null".equals(allset)){
			 StringBuffer sb = new StringBuffer("(");
			 String[]  arr = allset.split(",");
			 for(int j=0;j<arr.length;j++){
				 if(j>0){
					 sb.append(",");
				 }
				 sb.append("'"+arr[j]+"'");
			 }
			 sb.append(")");
			 String del_lassessindexp = "delete from lrassessindexp where basecode='"+mBaseCode+"' and indextype = '"+mIndexType+"' and agentgrade = '"+mAgentGrade+"' and indexcode in "+sb.toString();
			 mMap.put(del_lassessindexp, "DELETE");
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
