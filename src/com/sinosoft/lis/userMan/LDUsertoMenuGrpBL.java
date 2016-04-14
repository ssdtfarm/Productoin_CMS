/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.userMan;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LDUserDB;
import com.sinosoft.lis.db.LDUserTOMenuGrpDB;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubFun1;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.lis.schema.LDUserSchema;
import com.sinosoft.lis.schema.LDUserTOMenuGrpSchema;
import com.sinosoft.lis.schema.LDUserTOMenuGrpbSchema;
import com.sinosoft.lis.vschema.LDTaskRunLogSet;
import com.sinosoft.lis.vschema.LDUserSet;
import com.sinosoft.lis.vschema.LDUserTOMenuGrpSet;
import com.sinosoft.lis.vschema.LDUserTOMenuGrpbSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.Reflections;
import com.sinosoft.utility.VData;

/**
 * <p>Title: Web业务系统</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author Dingzhong
 * @version 1.0
 */

public class LDUsertoMenuGrpBL
{
    //错误处理类，每个需要错误处理的类中都放置该类
    public CErrors mErrors = new CErrors();
    /** 数据操作字符串 */
    private String mOperate;
	/** 往后面传输数据的容器 */
	private VData mInputData = new VData();
	private MMap map = new MMap();
    /**定义系统变量*/
    private LDUserTOMenuGrpbSet mLDUserTOMenuGrpbSet = new LDUserTOMenuGrpbSet();
    private LDUserSchema mLDUserSchema = new LDUserSchema();
    private LDUserTOMenuGrpSet mLDUserTOMenuGrpSet = new LDUserTOMenuGrpSet();
    private LDUserTOMenuGrpSet mILDUserTOMenuGrpSet = new LDUserTOMenuGrpSet();
    private LDUserTOMenuGrpSet mDLDUserTOMenuGrpSet = new LDUserTOMenuGrpSet();
    private LDUserTOMenuGrpSet mTempLDUserTOMenuGrpSet = new LDUserTOMenuGrpSet();
    /**当前系统时间*/
    private String mCurrentDate = PubFun.getCurrentDate();
    private String mCurrentTime = PubFun.getCurrentTime();
    /**获取登录用户信息*/
    private GlobalInput mGlobalInput = new GlobalInput();
    
    public LDUsertoMenuGrpBL()
    {
    }

    //传输数据的公共方法
    public boolean submitData(VData cInputData, String cOperate)
    {
        //将操作数据拷贝到本类中
        this.mOperate = cOperate;
        
        //获取前台数据
        if(!getInputData(cInputData)){
        	return false;
        }
        //校验数据
        if(!checkData()){
        	return false;
        }
        //核心业务逻辑处理
        if(!dealData()){
        	return false;
        }
        // 准备往后台的数据
		if (!prepareOutputData()) {
			return false;
		}
		//提交后台处理
		PubSubmit tPubSubmit = new PubSubmit();
		System.out.println("Start LDUsertoMenuGrpBL Submit...");
		if (!tPubSubmit.submitData(this.mInputData, mOperate)) {
			// @@错误处理
			this.mErrors.copyAllErrors(tPubSubmit.mErrors);
			this.buildError("submitData", ""+bundle.getString("DatasubmitFaild")+"!");
			return false;
		}
		return true;
    }
    
    /**
     * 获取其他传入参数
     * @param cInputData
     * @return
     */
    private boolean getInputData(VData cInputData) {
		// 获取用户信息
		this.mLDUserSchema.setSchema((LDUserSchema) cInputData
				.getObjectByObjectName("LDUserSchema", 0));
		// 获取用户授权信息
		this.mLDUserTOMenuGrpSet.set((LDUserTOMenuGrpSet) cInputData
				.getObjectByObjectName("LDUserTOMenuGrpSet", 0));
		// 获得用户登陆信息
		this.mGlobalInput.setSchema((GlobalInput) cInputData
				.getObjectByObjectName("GlobalInput", 0));
		
		if (this.mLDUserSchema == null || this.mGlobalInput == null) {
			this.buildError("getInputData", ""+bundle.getString("ErrorMsg")+"");
			return false;
		}
		
		return true;
	}
	
    /**
     * 校验前台传入参数
     * @return
     */
	private boolean checkData() {
		//校验操作类型
		if (this.mOperate == null || this.mOperate.equals("")) {
			this.buildError("checkData", ""+bundle.getString("ErrorMsg")+"");
			return false;
		} else if (!this.mOperate.equals("update")) {
			this.buildError("checkData", ""+bundle.getString("ErrorMsg")+"");
			return false;
		}
		String usercode = this.mLDUserSchema.getUserCode();
    	if(usercode.equals("")||usercode==null){
    		this.buildError("checkData", ""+bundle.getString("ErrorMsg")+"");
    		return false;
    	}
    	LDUserDB tLDUserDB = new LDUserDB();
    	LDUserSchema kLDUserSchema = new LDUserSchema();
    	kLDUserSchema.setUserCode(usercode);
    	tLDUserDB.setSchema(kLDUserSchema);
    	LDUserSet tLDUserSet = new LDUserSet();
    	//String sql = "select * from lduser where usercode='"+usercode+"'";
    	tLDUserSet = tLDUserDB.query();
    	if(tLDUserDB.mErrors.needDealError()){
    		this.buildError("checkData", ""+bundle.getString("ErrorMsg")+"");
    		return false;
    	}
    	if(tLDUserSet.size()<=0 || tLDUserSet==null){
    		this.buildError("checkData", ""+bundle.getString("ErrorMsg")+"");
    		return false;
    	}
		return true;
	}
	/**
	 * 核心业务系统操作
	 * @return
	 */
	private boolean dealData() {
		String tEdorno = PubFun1.CreateMaxNo("DepEdorNo", 20);
		/*1、核心处理流程，先将用户现有的菜单组备份并删除；
		 * 2、将页面上重新授权的菜单组重新分配给用户
		 * 3、每次重新维护时，其分配时间和备份的结束时间都是当前系统时间*/
		LDUserTOMenuGrpSet tLDUserTOMenuGrpSet = new LDUserTOMenuGrpSet();
		LDUserTOMenuGrpDB tLDUserTOMenuGrpDB = new LDUserTOMenuGrpDB();
//		String sql = "select * from ldusertomenugrp where usercode='"+this.mLDUserSchema.getUserCode()+"' and MenuGrpCode in(" 
//					+ "select a.menugrpcode from ldmenugrp a,lddeptadminconfig b " 
//					+ "where a.team=b.depno and b.deplevel='02' and b.depmanager='"+this.mGlobalInput.Operator+"')";
//		tLDUserTOMenuGrpSet = tLDUserTOMenuGrpDB.executeQuery(sql);
		
        String powerSql = "select * from ldusertomenugrp where usercode=? and MenuGrpCode in(select a.menugrpcode from ldmenugrp a,lddeptadminconfig b where a.team=b.depno and b.deplevel=? and b.depmanager=?) "; 
        List paraList =new ArrayList();
        paraList.add(this.mLDUserSchema.getUserCode());
        paraList.add("02");
        paraList.add(this.mGlobalInput.Operator);
        tLDUserTOMenuGrpSet = tLDUserTOMenuGrpDB.executeQuery(powerSql,PubFun.getFormatBV(paraList)); 
        
		if(tLDUserTOMenuGrpDB.mErrors.needDealError()){
			this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
			return false;
		}
		//当前台用户授权没有赋给用户任何权限时
		if(this.mLDUserTOMenuGrpSet.size()<=0){
			//查询后台数据库中客户是否存在系统角色，如果存在，则删除
			if (tLDUserTOMenuGrpSet.size() > 0) {
				//删除原有的用户授权信息
				for (int i = 1; i <= tLDUserTOMenuGrpSet.size(); i++) {
					LDUserTOMenuGrpSchema tLDUserToMenuGrpSchema = new LDUserTOMenuGrpSchema();
					LDUserTOMenuGrpbSchema tLDUserToMenuGrpbSchema = new LDUserTOMenuGrpbSchema();
					tLDUserToMenuGrpSchema = tLDUserTOMenuGrpSet.get(i);
					// 备份
					Reflections tReflections = new Reflections();
					tReflections.transFields(tLDUserToMenuGrpbSchema,
							tLDUserToMenuGrpSchema);
					tLDUserToMenuGrpbSchema.setEdorNo(tEdorno);
					tLDUserToMenuGrpbSchema.setEdorType("01");// 用户授权备份
					tLDUserToMenuGrpbSchema.setEndDate(this.mCurrentDate);
					tLDUserToMenuGrpbSchema.setEndTime(this.mCurrentTime);
					this.mLDUserTOMenuGrpbSet.add(tLDUserToMenuGrpbSchema);
				}
				this.map.put(mLDUserTOMenuGrpbSet, "DELETE&INSERT");
				this.map.put(tLDUserTOMenuGrpSet, "DELETE");
			}
		}else{
			//将新的	用户授权信息插入到系统中
			for (int j=1;j<=mLDUserTOMenuGrpSet.size();j++){
				LDUserTOMenuGrpSchema tLDUserTOMenuGrpSchema = new LDUserTOMenuGrpSchema();
				LDUserTOMenuGrpDB iLDUserTOMenuGrpDB = new LDUserTOMenuGrpDB();
				tLDUserTOMenuGrpSchema = this.mLDUserTOMenuGrpSet.get(j);
				if (tLDUserTOMenuGrpSchema.getUserCode() == null
						|| tLDUserTOMenuGrpSchema.getUserCode().equals("")
						|| tLDUserTOMenuGrpSchema.getMenuGrpCode() == null
						|| tLDUserTOMenuGrpSchema.getMenuGrpCode().equals("")) {
					this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
					return false;
				}else{
					iLDUserTOMenuGrpDB.setUserCode(tLDUserTOMenuGrpSchema.getUserCode());
					iLDUserTOMenuGrpDB.setMenuGrpCode(tLDUserTOMenuGrpSchema.getMenuGrpCode());
					//如果系统中没有的话，则直接插入系统
					if(!iLDUserTOMenuGrpDB.getInfo()){
						iLDUserTOMenuGrpDB.setStartDate(this.mCurrentDate);
						iLDUserTOMenuGrpDB.setStartTime(this.mCurrentTime);
						this.mILDUserTOMenuGrpSet.add(iLDUserTOMenuGrpDB.getSchema());
					}else{
						//如果系统中存在，则不再处理其原来的授权菜单
						iLDUserTOMenuGrpDB.setStartDate(this.mCurrentDate);
						iLDUserTOMenuGrpDB.setStartTime(this.mCurrentTime);
						this.mTempLDUserTOMenuGrpSet.add(iLDUserTOMenuGrpDB.getSchema());
					}
				}
			}
			//原来没有用户授权的系统角色时
			if(tLDUserTOMenuGrpSet.size()<=0){
				this.mDLDUserTOMenuGrpSet.clear();
				this.mLDUserTOMenuGrpbSet.clear();
			}else{
				if(mTempLDUserTOMenuGrpSet.size()<=0){
					for(int x=1 ;x<=tLDUserTOMenuGrpSet.size();x++){
						Reflections tReflections = new Reflections();
						LDUserTOMenuGrpbSchema tLDUserToMenuGrpbSchema1 = new LDUserTOMenuGrpbSchema();
						tReflections.transFields(tLDUserToMenuGrpbSchema1, tLDUserTOMenuGrpSet.get(x).getSchema());
						tLDUserToMenuGrpbSchema1.setEdorNo(tEdorno);
						tLDUserToMenuGrpbSchema1.setEdorType("01");
						tLDUserToMenuGrpbSchema1.setEndDate(this.mCurrentDate);
						tLDUserToMenuGrpbSchema1.setEndTime(this.mCurrentTime);
						this.mLDUserTOMenuGrpbSet.add(tLDUserToMenuGrpbSchema1);
						this.mDLDUserTOMenuGrpSet.add(tLDUserTOMenuGrpSet.get(x).getSchema());
					}
				}else{
					String tempString = "";
					for (int y = 1; y <= mTempLDUserTOMenuGrpSet.size(); y++) {
						if (y == 1) {
							tempString = "'"
									+ mTempLDUserTOMenuGrpSet.get(y)
											.getMenuGrpCode();
						} else {
							tempString = tempString
									+ "','"
									+ mTempLDUserTOMenuGrpSet.get(y)
											.getMenuGrpCode();
						}
						if (y == mTempLDUserTOMenuGrpSet.size()) {
							tempString = tempString + "'";
						}
					}
					if(tempString==null || tempString.equals("")){
						tempString = "''";
					}
					//查询不属于授权给用户的所有授权记录
					LDUserTOMenuGrpSet tLDUserTOMenuGrpSet1 = new LDUserTOMenuGrpSet();
					LDUserTOMenuGrpDB tLDUserTOMenuGrpDB1 = new LDUserTOMenuGrpDB();
//					String sql1 = "select * from ldusertomenugrp where usercode='"+this.mLDUserSchema.getUserCode()+"' and MenuGrpCode in(" 
//								+ "select a.menugrpcode from ldmenugrp a,lddeptadminconfig b " 
//								+ "where a.team=b.depno and b.deplevel='02' and b.depmanager='"+this.mGlobalInput.Operator+"') " 
//								+ "and MenuGrpCode not in("+tempString+")";
//					tLDUserTOMenuGrpSet1 = tLDUserTOMenuGrpDB1.executeQuery(sql1);
					
			        powerSql = "select * from ldusertomenugrp where usercode=? and MenuGrpCode in(select a.menugrpcode from ldmenugrp a,lddeptadminconfig b where a.team=b.depno and b.deplevel=? and b.depmanager=? and MenuGrpCode not in(?) "; 
			        paraList =new ArrayList(); 
			        paraList.add(this.mLDUserSchema.getUserCode());
			        paraList.add("02");
			        paraList.add(this.mGlobalInput.Operator);
			        if(tempString.startsWith("'") && tempString.endsWith("'")){
			        	tempString=tempString.substring(1).substring(0, tempString.length()-1);
			        }
			        paraList.add(tempString);
			        
			        tLDUserTOMenuGrpSet1 = tLDUserTOMenuGrpDB1.executeQuery(powerSql,PubFun.getFormatBV(paraList)); 
			        
					if(tLDUserTOMenuGrpDB1.mErrors.needDealError()){
						this.buildError("dealData", ""+bundle.getString("ErrorMsg")+"");
						return false;
					}
					if(tLDUserTOMenuGrpSet1.size()<=0){
						//没有不做处理
					}else{
						for(int x=1 ;x<=tLDUserTOMenuGrpSet1.size();x++){
							Reflections tReflections = new Reflections();
							LDUserTOMenuGrpbSchema tLDUserToMenuGrpbSchema1 = new LDUserTOMenuGrpbSchema();
							tReflections.transFields(tLDUserToMenuGrpbSchema1, tLDUserTOMenuGrpSet1.get(x).getSchema());
							tLDUserToMenuGrpbSchema1.setEdorNo(tEdorno);
							tLDUserToMenuGrpbSchema1.setEdorType("01");
							tLDUserToMenuGrpbSchema1.setEndDate(this.mCurrentDate);
							tLDUserToMenuGrpbSchema1.setEndTime(this.mCurrentTime);
							this.mLDUserTOMenuGrpbSet.add(tLDUserToMenuGrpbSchema1);
							this.mDLDUserTOMenuGrpSet.add(tLDUserTOMenuGrpSet1.get(x).getSchema());
						}
					}
				}
			}
			//先备份需要删除的授权信息
			this.map.put(mLDUserTOMenuGrpbSet, "DELETE&INSERT");
			//删除原来的授权在新的不存在的记录
			this.map.put(mDLDUserTOMenuGrpSet, "DELETE");
			//插入新的授权信息
			this.map.put(this.mILDUserTOMenuGrpSet, "INSERT");
		}
		return true;
	}
	/**
	 * 往后台传输数据
	 * @return
	 */
    private boolean prepareOutputData() {
		try {
			this.mInputData.add(this.map);
		} catch (Exception e) {
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
