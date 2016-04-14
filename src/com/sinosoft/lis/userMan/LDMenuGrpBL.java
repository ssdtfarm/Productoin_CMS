/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.userMan;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LDMenuGrpDB;
import com.sinosoft.lis.db.LDMenuGrpToMenuDB;
import com.sinosoft.lis.db.LDUserTOMenuGrpDB;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubFun1;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.lis.schema.LDMenuGrpSchema;
import com.sinosoft.lis.schema.LDMenuGrpToMenuSchema;
import com.sinosoft.lis.schema.LDUserTOMenuGrpSchema;
import com.sinosoft.lis.schema.LDUserTOMenuGrpbSchema;
import com.sinosoft.lis.vschema.LDMenuGrpToMenuSet;
import com.sinosoft.lis.vschema.LDUserTOMenuGrpSet;
import com.sinosoft.lis.vschema.LDUserTOMenuGrpbSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.Reflections;
import com.sinosoft.utility.StrTool;
import com.sinosoft.utility.VData;

/**
 * <p>Title: Web业务系统</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author Dingzhong
 * @version 1.0
 */

public class LDMenuGrpBL
{
    //错误处理类，每个需要错误处理的类中都放置该类
    public CErrors mErrors = new CErrors();
    private MMap map = new MMap();
    /** 数据操作字符串 */
    private String mOperate;
    public String mResult ;
    private String mCurrentDate = PubFun.getCurrentDate();
    private String mCurrentTime = PubFun.getCurrentTime();
    private GlobalInput mGlobalInput = new GlobalInput();
    private LDMenuGrpSchema mLDMenuGrpSchema = new LDMenuGrpSchema();
    //系统角色菜单组新增和移除的Str
    private String mLDMenuGrpToMenuSetStr = "";
    private String mRemoveLDMenuGrpToMenuSetStr = "";
    // 系统角色的set集合
    private LDMenuGrpToMenuSet mLDMenuGrpToMenuSet = new LDMenuGrpToMenuSet();
    private LDMenuGrpToMenuSet mRemoveSet = new LDMenuGrpToMenuSet();
	/** 往后面传输数据的容器 */
	private VData mInputData = new VData();
	
    public LDMenuGrpBL()
    {
    }

    //传输数据的公共方法
    public boolean submitData(VData cInputData, String cOperate)
    {
        //将操作数据拷贝到本类中
        this.mOperate = cOperate.toUpperCase();
        this.mResult="";
       
        //前台获取数据
        if(!getInputData(cInputData)){
        	return false;
        }
        //校验数据
        if(!checkData()){
        	return false;
        }
        //业务处理
        if(!dealData()){
        	return false;
        }
        // 准备往后台的数据
		if (!prepareOutputData()) {
			return false;
		}
		//提交后台处理
		PubSubmit tPubSubmit = new PubSubmit();
		System.out.println("Start LDMenuGrpBL Submit...");
		if (!tPubSubmit.submitData(this.mInputData, mOperate)) {
			// @@错误处理
			this.mErrors.copyAllErrors(tPubSubmit.mErrors);
			this.buildError("submitData", ""+bundle.getString("DatasubmitFaild")+"!");
			return false;
		}
		return true;
    }
    
    /**
     * 后台数据传输
     * @return
     */
    private boolean prepareOutputData() {
		try {
			this.mInputData.add(this.map);
		} catch (Exception e) {
			this.buildError("prepareOutputData", ""+bundle.getString("ErrorMsg")+"" + e.getMessage());
			return false;
		}
		return true;
	}

	/**
     * 核心业务逻辑处理
     * @return
     */
    private boolean dealData() {
		//新增系统角色配置
    	if(this.mOperate.equals("INSERT")){
			if (this.mLDMenuGrpSchema.getMenuGrpCode() == null
					|| this.mLDMenuGrpSchema.getMenuGrpCode().equals("")) {
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			//校验系统编码系统不重复
			LDMenuGrpDB tLDMenuGrpDB = new LDMenuGrpDB();
			tLDMenuGrpDB.setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
			if(tLDMenuGrpDB.getInfo()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			if(tLDMenuGrpDB.mErrors.needDealError()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDMenuGrpDB.mErrors.getFirstError());
				return false;
			}
			//如果不存在则将系统角色保存到数据库中
			if (this.mLDMenuGrpSchema.getMenuGrpName() == null
					|| this.mLDMenuGrpSchema.getMenuGrpName().equals("")) {
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			if (this.mLDMenuGrpSchema.getDepartMent() == null
					|| this.mLDMenuGrpSchema.getDepartMent().equals("")) {
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			if (this.mLDMenuGrpSchema.getTeam() == null
					|| this.mLDMenuGrpSchema.getTeam().equals("")) {
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			//插入到ldmenugrp
			this.map.put(this.mLDMenuGrpSchema, "INSERT");
			if(this.mLDMenuGrpToMenuSet.size()>0){
				for(int i=1;i<=mLDMenuGrpToMenuSet.size();i++){
					this.mLDMenuGrpToMenuSet.get(i).setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
				}
				//插入到ldmenugrptomenu
				this.map.put(this.mLDMenuGrpToMenuSet, "INSERT");
			}
    	}
    	//更新配置
    	if(this.mOperate.equals("UPDATE")){
			if (this.mLDMenuGrpSchema.getMenuGrpCode() == null
					|| this.mLDMenuGrpSchema.getMenuGrpCode().equals("")) {
				this.buildError("dealData", ""+bundle.getString("Data is empty, please check!")+"");
				return false;
			}
			//如果不存在则将系统角色保存到数据库中
			if (this.mLDMenuGrpSchema.getMenuGrpName() == null
					|| this.mLDMenuGrpSchema.getMenuGrpName().equals("")) {
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			if (this.mLDMenuGrpSchema.getDepartMent() == null
					|| this.mLDMenuGrpSchema.getDepartMent().equals("")) {
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			if (this.mLDMenuGrpSchema.getTeam() == null
					|| this.mLDMenuGrpSchema.getTeam().equals("")) {
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			//校验系统编码系统不重复
			LDMenuGrpDB tLDMenuGrpDB = new LDMenuGrpDB();
			tLDMenuGrpDB.setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
			if(!tLDMenuGrpDB.getInfo()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			if(tLDMenuGrpDB.mErrors.needDealError()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDMenuGrpDB.mErrors.getFirstError());
				return false;
			}
			//修改ldmenugrp的数据信息
			tLDMenuGrpDB.setDepartMent(this.mLDMenuGrpSchema.getDepartMent());
			tLDMenuGrpDB.setTeam(this.mLDMenuGrpSchema.getTeam());
			tLDMenuGrpDB.setMenuGrpName(this.mLDMenuGrpSchema.getMenuGrpName());
			tLDMenuGrpDB.setOperator(this.mLDMenuGrpSchema.getOperator());
			tLDMenuGrpDB.setMenuGrpDescription(this.mLDMenuGrpSchema.getMenuGrpDescription());
			tLDMenuGrpDB.setMenuSign(this.mLDMenuGrpSchema.getMenuSign());
			this.map.put(tLDMenuGrpDB.getSchema(), "UPDATE");
			//将原来的ldmenugrptomenu的数据删除，并且重新建立
			LDMenuGrpToMenuDB tLDMenuGrpToMenuDB = new LDMenuGrpToMenuDB();
			LDMenuGrpToMenuSet tLDMenuGrpToMenuSet = new LDMenuGrpToMenuSet();
			tLDMenuGrpToMenuDB.setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
			tLDMenuGrpToMenuSet = tLDMenuGrpToMenuDB.query();
			if(tLDMenuGrpToMenuDB.mErrors.needDealError()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDMenuGrpToMenuDB.mErrors.getFirstError());
				return false;
			}
			if(tLDMenuGrpToMenuSet.size()>0){
				this.map.put(tLDMenuGrpToMenuSet, "DELETE");
			}
			//重新将页面上的菜单保存到数据库中
			if(this.mLDMenuGrpToMenuSet.size()>0){
				for(int i=1;i<=mLDMenuGrpToMenuSet.size();i++){
					this.mLDMenuGrpToMenuSet.get(i).setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
				}
				//插入到ldmenugrptomenu
				this.map.put(this.mLDMenuGrpToMenuSet, "INSERT");
			}
    	}
    	//删除配置
    	if(this.mOperate.equals("DELETE")){
			if (this.mLDMenuGrpSchema.getMenuGrpCode() == null
					|| this.mLDMenuGrpSchema.getMenuGrpCode().equals("")) {
				this.buildError("dealData", ""+bundle.getString("Data is empty, please check!")+"");
				return false;
			}
			//查询LDMenuGrp中的数据;
			LDMenuGrpDB tLDMenuGrpDB = new LDMenuGrpDB();
			tLDMenuGrpDB.setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
			if(!tLDMenuGrpDB.getInfo()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
				return false;
			}
			if(tLDMenuGrpDB.mErrors.needDealError()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDMenuGrpDB.mErrors.getFirstError());
				return false;
			}
			this.map.put(tLDMenuGrpDB.getSchema(), "DELETE");
			//查询LDMenuGrpToMenu的数据
			LDMenuGrpToMenuSet tLDMenuGrpToMenuSet = new LDMenuGrpToMenuSet();
			LDMenuGrpToMenuDB tLDMenuGrpToMenuDB = new LDMenuGrpToMenuDB();
			LDMenuGrpToMenuSchema kLDMenuGrpToMenuSchema = new LDMenuGrpToMenuSchema();
			kLDMenuGrpToMenuSchema.setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
			tLDMenuGrpToMenuDB.setSchema(kLDMenuGrpToMenuSchema);
			tLDMenuGrpToMenuSet = tLDMenuGrpToMenuDB.query();
			if(tLDMenuGrpToMenuDB.mErrors.needDealError()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDMenuGrpToMenuDB.mErrors.getFirstError());
				return false;
			}
			if(tLDMenuGrpToMenuSet.size()>0){
				this.map.put(tLDMenuGrpToMenuSet, "DELETE");
			}
			//查询LDUserToMenuGrp（需确认是否需要调整），备份删除
			//String sql1= "select * from ldusertomenugrp where menugrpcode ='"+this.mLDMenuGrpSchema.getMenuGrpCode()+"'";
			LDUserTOMenuGrpDB tLDUserToMenuGrpDB = new LDUserTOMenuGrpDB();
			LDUserTOMenuGrpSchema kLDUserTOMenuGrpSchema = new LDUserTOMenuGrpSchema();
			kLDUserTOMenuGrpSchema.setMenuGrpCode(this.mLDMenuGrpSchema.getMenuGrpCode());
			tLDUserToMenuGrpDB.setSchema(kLDUserTOMenuGrpSchema);
			LDUserTOMenuGrpSet tLDUserToMenuGrpSet = new LDUserTOMenuGrpSet();
			LDUserTOMenuGrpbSet tLDUserToMenuGrpbSet = new LDUserTOMenuGrpbSet();
			tLDUserToMenuGrpSet = tLDUserToMenuGrpDB.query();
			if(tLDUserToMenuGrpDB.mErrors.needDealError()){
				this.buildError("dealData", ""+bundle.getString("ErrorMsg")+""+tLDUserToMenuGrpDB.mErrors.getFirstError());
				return false;
			}
			//先备份到B表中，方便以后查询
			if(tLDUserToMenuGrpSet.size()>0){
				String tEdorno = PubFun1.CreateMaxNo("DepEdorNo", 20);
				for (int i = 1; i <= tLDUserToMenuGrpSet.size(); i++) {
					LDUserTOMenuGrpSchema tLDUserToMenuGrpSchema = new LDUserTOMenuGrpSchema();
					LDUserTOMenuGrpbSchema tLDUserToMenuGrpbSchema = new LDUserTOMenuGrpbSchema();
					tLDUserToMenuGrpSchema = tLDUserToMenuGrpSet.get(i);
					// 备份
					Reflections tReflections = new Reflections();
					tReflections.transFields(tLDUserToMenuGrpbSchema,
							tLDUserToMenuGrpSchema);
					tLDUserToMenuGrpbSchema.setEdorNo(tEdorno);
					tLDUserToMenuGrpbSchema.setEdorType("02");// 系统角色删除导致的备份
					tLDUserToMenuGrpbSchema.setEndDate(this.mCurrentDate);
					tLDUserToMenuGrpbSchema.setEndTime(this.mCurrentTime);
					tLDUserToMenuGrpbSet.add(tLDUserToMenuGrpbSchema);
				}
				this.map.put(tLDUserToMenuGrpbSet, "DELETE&INSERT");
				this.map.put(tLDUserToMenuGrpSet, "DELETE");
			}
    	}
		return true;
	}
    
    /**
     * 数据校验
     * @return
     */
    private boolean checkData() {
		// 先校验操作类型是否存在
		if (this.mOperate.equals("") || this.mOperate == null) {
			this.buildError("checkData", ""+bundle.getString("ErrorMsg")+"");
			return false;
		}

		// 新增、更新和删除校验
		if ((this.mLDMenuGrpSchema.getMenuGrpCode() == null || this.mLDMenuGrpSchema
				.getMenuGrpCode().equals(""))) {
			this.buildError("checkData", ""+bundle.getString("ErrorMsg")+"");
			return false;
		}
		
		return true;
	}

    /**
     * 获取前台数据
     * @param cInputData
     * @return
     */
    private boolean getInputData(VData cInputData) {
		// 获取前台数据
		this.mGlobalInput.setSchema((GlobalInput) cInputData
				.getObjectByObjectName("GlobalInput", 0));
		this.mLDMenuGrpSchema.setSchema((LDMenuGrpSchema) cInputData
				.getObjectByObjectName("LDMenuGrpSchema", 0));
		//如果不是删除操作
		if(!this.mOperate.equals("DELETE")){
			this.mLDMenuGrpToMenuSetStr = (String) cInputData.getObjectByObjectName(
                    "String", 0);
			this.mRemoveLDMenuGrpToMenuSetStr = (String) cInputData.getObjectByObjectName(
                    "String", 1);
			//判断新增的ldemugrp是否有录入菜单，如果没有提示错误
			if (mLDMenuGrpToMenuSetStr == null || mLDMenuGrpToMenuSetStr.equals(""))
            {
				this.buildError("getInputData", ""+bundle.getString("ErrorMsg")+"");
                return false;
            }
			//解析将页面上的获取的str并且将保存到set中
			stringToSet(mLDMenuGrpToMenuSetStr, mLDMenuGrpToMenuSet);
			//移除的集合
            if (mRemoveLDMenuGrpToMenuSetStr != null && !mRemoveLDMenuGrpToMenuSetStr.equals(""))
            {
                stringToSet(mRemoveLDMenuGrpToMenuSetStr, mRemoveSet);
            }
		}
		// 提前校验数据
		if (this.mGlobalInput == null || this.mLDMenuGrpSchema == null) {
			this.buildError("getInputData", ""+bundle.getString("ErrorMsg")+"");
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
	
	//返回生成的对应号码
	public String getResult() {
		return this.mResult;
	}
	
	/*解析string 装换成对应的set集合*/
   public void stringToSet(String schemaString, LDMenuGrpToMenuSet stringSet)
    {
        stringSet.clear();

        int serialNo = 1;
        String schemaStr = StrTool.decodeStr(schemaString, "^", serialNo);
        while (!schemaStr.equals("") && serialNo < schemaString.length())
        {
            LDMenuGrpToMenuSchema tSchema = new LDMenuGrpToMenuSchema();

            String menuGrpCode = StrTool.decodeStr(schemaStr, "|", 1);
            String menuCode = StrTool.decodeStr(schemaStr, "|", 2);

            tSchema.setMenuGrpCode(menuGrpCode);
            tSchema.setNodeCode(menuCode);
            stringSet.add(tSchema);

            serialNo++;
            schemaStr = StrTool.decodeStr(schemaString, "^", serialNo);
        }
    }
}
