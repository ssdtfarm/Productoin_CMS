/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.userMan;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LDDeptAdminConfigDB;
import com.sinosoft.lis.db.LDUserDB;
import com.sinosoft.lis.encrypt.LisIDEA;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.lis.schema.LDDeptAdminConfigSchema;
import com.sinosoft.lis.schema.LDUserSchema;
import com.sinosoft.lis.vschema.LDDeptAdminConfigSet;
import com.sinosoft.lis.vschema.LDUserTOMenuGrpSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.VData;

/**
 * <p>Title: Web业务系统</p>
 * <p>Description: 用户查询业务逻辑处理类</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author DingZhong
 * @version 1.0
 */
public class LDUserOpeBL
{
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    /** 往后面传输数据的容器 */
    private VData mResult = new VData();
    private VData mInputData = new VData();
    private MMap map = new MMap();
    /** 数据操作字符串 */
    private String mOperate;
//    private String mDeletor;

    /** 业务处理相关变量 */
    /** 用户的相关信息*/
    LDUserSchema mLDUserSchema = new LDUserSchema();
    LDUserTOMenuGrpSet mLDUserToMenuGrpSet = new LDUserTOMenuGrpSet();
    String mOperator; //指示进行本操作的操作员
    
    String mResultStr = "";
    int mResultNum = 0;

    public LDUserOpeBL()
    {
        // just for debug
    }

    /**
     * 传输数据的公共方法
     * @param cInputData VData
     * @param cOperate String
     * @return boolean
     */
    public boolean submitData(VData cInputData, String cOperate)
    {

        // 判断操作是不是查询
        if (cOperate.compareTo("insert") != 0
            && cOperate.compareTo("update") != 0)
        {
        	this.buildError("submitData", ""+bundle.getString("ErrorMsg")+"");
            return false;
        }

        System.out.println("start BL submit...");

        //将操作数据拷贝到本类中
        this.mOperate = cOperate;
        
        //得到外部传入的数据,将数据备份到本类中
        if (!getInputData(cInputData))
        {
            return false;
        }
        
        //进行业务处理
        if (!dealData())
        {
            return false;
        }
        
        //准备往后台的数据
        if (!prepareOutputData())
        {
            return false;
        }
        
        //提交后台操作
		PubSubmit tPubSubmit = new PubSubmit();
		if (!tPubSubmit.submitData(mInputData, "")) {
			// @@错误处理
			this.mErrors.copyAllErrors(tPubSubmit.mErrors);
			this.buildError("submitData", ""+bundle.getString("DatasubmitFaild")+"");
			return false;
		}
		mInputData = null;
        return true;
    }

    private boolean dealData()
    {
    	//校验语句
    	String strSQL = "select * from lduser where usercode='"+this.mLDUserSchema.getUserCode()+"'";
    	ExeSQL tExeSQL = new ExeSQL();
    	SSRS tSSRS = new SSRS();
    	tSSRS = tExeSQL.execSQL(strSQL);
    	//当操作是增加用户时，需要判断其用户在系统中不存在，而更新正好相反
    	if(tSSRS.getMaxRow()>0 && this.mOperate.equals("insert") ){
    		this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
    		return false;
    	}
    	if(tSSRS.getMaxRow()<=0 && this.mOperate.equals("update")){
    		this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
    		return false;
    	}
    	//密码加密处理，当前台出入的密码为空时，系统自动分配密码统一定义成9999999
    	String plainPwd = mLDUserSchema.getPassword().trim();
    	if(plainPwd.equals("")|| plainPwd==null){
    		plainPwd = "999999";
    	}
        LisIDEA tIdea = new LisIDEA();
        
        //保存操作数据
        if(this.mOperate.equals("insert")){
            String encryptPwd = tIdea.encryptString(plainPwd);
            mLDUserSchema.setPassword(encryptPwd);
        	this.map.put(this.mLDUserSchema, "INSERT");
        }else if(this.mOperate.equals("update")){
        	LDUserDB tLDUserDB = new LDUserDB();
        	if(this.mLDUserSchema.getUserCode()==null || this.mLDUserSchema.getUserCode().equals("")){
        		this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
        		return false;
        	}
        	tLDUserDB.setUserCode(this.mLDUserSchema.getUserCode());
        	if(!tLDUserDB.getInfo()){
        		this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
        		return false;
        	}
        	if(tLDUserDB.mErrors.needDealError()){
        		this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDUserDB.mErrors.getFirstError());
        		return false;
        	}
        	//当改变密码时，才需要重新加密密码，不然会有问题
        	if(!this.mLDUserSchema.getPassword().equals(tLDUserDB.getPassword())){
        		String encryptPwd = tIdea.encryptString(plainPwd);
                mLDUserSchema.setPassword(encryptPwd);       		
        	}
        	this.map.put(this.mLDUserSchema, "UPDATE");
        	//同时更新lddeptadminconfig中depmanager是该用户的的depmanagername用户姓名
        	LDDeptAdminConfigSet tLDDeptAdminConfigSet = new LDDeptAdminConfigSet();
        	LDDeptAdminConfigDB tLDDeptAdminConfigDB = new LDDeptAdminConfigDB();
        	LDDeptAdminConfigSchema kLDDeptAdminConfigSchema = new LDDeptAdminConfigSchema();
        	//String strtempSQL  ="select * from lddeptadminconfig where depmanager='"+this.mLDUserSchema.getUserCode()+"'";
        	kLDDeptAdminConfigSchema.setDepManager(this.mLDUserSchema.getUserCode());
        	tLDDeptAdminConfigDB.setSchema(kLDDeptAdminConfigSchema);
        	tLDDeptAdminConfigSet = tLDDeptAdminConfigDB.query();
        	if(tLDDeptAdminConfigDB.mErrors.needDealError()){
        		this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDDeptAdminConfigDB.mErrors.getFirstError());
        		return false;
        	}
        	//如果存在用户的系统角色信息
        	if(tLDDeptAdminConfigSet.size()>0){
        		for(int i=1;i<=tLDDeptAdminConfigSet.size();i++){
        			tLDDeptAdminConfigSet.get(i).setDepManagerName(this.mLDUserSchema.getUserName());
        		}
        		this.map.put(tLDDeptAdminConfigSet, "UPDATE");
        	}
        }
        return true;
    }

    public VData getResult()
    {
        return mResult;
    }

    public int getResultNum()
    {
        return mResultNum;
    }

    public String getResultStr()
    {
        String resultStr = "";
//        for (int i = 1; i <= mResultNum; i++)
//        {
//
//        }
        return resultStr;
    }


    /**
     * 从输入数据中得到所有对象
     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
     * @param cInputData VData
     * @return boolean
     */
    private boolean getInputData(VData cInputData)
    {
        //得到增加更新时的操作员或删除时的当前操作员
        mOperator = (String) cInputData.getObjectByObjectName("String", 0);

        // 检验查询条件
        mLDUserSchema = (LDUserSchema) cInputData.getObjectByObjectName(
                "LDUserSchema", 0);

        if (mLDUserSchema == null)
        {
        	this.buildError("getInputData", ""+bundle.getString("ErrorMsg")+"");
            return false;
        }

        String curDate = PubFun.getCurrentDate();
        String curTime = PubFun.getCurrentTime();

        if (mOperate.compareTo("insert") == 0)
        {
            mLDUserSchema.setMakeTime(curTime);
            mLDUserSchema.setMakeDate(curDate);
        }
        
        
//        mLDUserToMenuGrpSet = (LDUserTOMenuGrpSet) cInputData.
//                              getObjectByObjectName("LDUserTOMenuGrpSet", 0);
//        System.out.println("completed get input data");
        return true;
    }

    /**
     * 准备往后层输出所需要的数据
     * 输出：如果准备数据时发生错误则返回false,否则返回true
     * @return boolean
     */
    private boolean prepareOutputData()
    {
        mResult.clear();
        mInputData.clear();
        try
        {
            mInputData.add(map);
        }
        catch (Exception ex)
        {
            // @@错误处理
        	this.buildError("prepareOutputData", ""+bundle.getString("ErrorMsg")+"");
            return false;
        }
        return true;
    }
    
	/**
	 * 错误日志信息综合处理
	 * @param FucName
	 * @param Msg
	 */
	private void buildError(String FucName,String Msg){
		CError tError = new CError();
		tError.moduleName = this.getClass().getName();
		tError.functionName = FucName;
		tError.errorMessage = Msg;
		this.mErrors.addOneError(tError);
	}
}
