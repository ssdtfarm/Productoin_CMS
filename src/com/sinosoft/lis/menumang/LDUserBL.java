/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.menumang;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.*;
import com.sinosoft.lis.encrypt.LisIDEA;
import com.sinosoft.lis.logon.ADValidate.ADUser;
import com.sinosoft.lis.logon.ADValidate.ADValidate;
import com.sinosoft.lis.logon.ADValidate.LoginModel;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.lis.schema.*;
import com.sinosoft.lis.vschema.*;
import com.sinosoft.utility.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

/**
 * <p>
 * Title: Web业务系统
 * </p>
 * <p>
 * Description: 用户业务逻辑处理类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author DingZhong
 * @version 1.0
 */
public class LDUserBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();

	/** 往后面传输数据的容器 */
	private VData mResult = new VData();

	/** 数据操作字符串 */
	// private String mOperate;
	/** 业务处理相关变量 */
	/** 菜单组、菜单组到菜单的相关信息 */
	LDUserSchema mLDUserSchema = new LDUserSchema();
	LDUserDB mLDUserDB = new LDUserDB();
	LDUserSet mLDUserSet = new LDUserSet();
	String tKeyWord="";

	String mResultStr = "";
	int mResultNum = 0;

	public LDUserBL() {
		// just for debug
	}

	/**
	 * 传输数据的公共方法
	 * 
	 * @param cInputData
	 *            VData
	 * @param cOperate
	 *            String
	 * @return boolean
	 */
	public boolean submitData(VData cInputData, String cOperate) {
		// 判断操作是不是查询
		if (!cOperate.equals("query")) {
			return false;
		}

		// 得到外部传入的数据,将数据备份到本类中
		if (!getInputData(cInputData)) {
			return false;
		}

		// 校验用户名是否符合格式、是否存在、用户名和密码是否匹配
		if (!validateUser()) {
			return false;
		}
		return true;
	}

	public VData getResult() {
		return mResult;
	}

	public int getResultNum() {
		return mResultNum;
	}

	/**
	 * 从输入数据中得到所有对象 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
	 * 
	 * @param cInputData
	 *            VData
	 * @return boolean
	 */
	private boolean getInputData(VData cInputData) {
		// 检验查询条件
		mLDUserSchema = (LDUserSchema) cInputData.getObjectByObjectName(
				"LDUserSchema", 0);
		tKeyWord=mLDUserSchema.getPassword();
		if (mLDUserSchema == null) {
			return false;
		}

		return true;
	}

	/**
	 * 校验用户名是否符合格式、是否存在、用户名和密码是否匹配 否则返回false,是则返回true
	 * 
	 * @param cInputData
	 *            VData
	 * @return boolean
	 */
	private boolean validateUser() {
		try{
			//1 校验usercode在lduser是否存在
			LDUserDB gLDUserDB = new LDUserDB();
			gLDUserDB.setUserCode(mLDUserSchema.getUserCode());
			mLDUserSet = gLDUserDB.query();
			if(mLDUserSet.size()==0){
				CError tError = new CError();
				tError.moduleName = "LDUserBL";
				tError.functionName = "validateUser";
				tError.errorMessage = "UserCode does not exists in CMS!";
				this.mErrors.addOneError(tError);
				return false;
			}
			LDUserSchema kLDUserSchema = new LDUserSchema();
			kLDUserSchema=mLDUserSet.get(1);
			
			//2 校验usercode的state是否有效
			if(kLDUserSchema.getUserState()==null || !"0".equals(kLDUserSchema.getUserState())){
				CError tError = new CError();
				tError.moduleName = "LDUserBL";
				tError.functionName = "validateUser";
				tError.errorMessage = "UserCode does not valied in CMS!";
				this.mErrors.addOneError(tError);
				return false;
			}
			
			//3 校验登陆当天是否在usercode的有效区间内
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
			String tValiedStartDate=kLDUserSchema.getValidStartDate();
			String tValiedEndDate=kLDUserSchema.getValidEndDate();
			if((tValiedStartDate!=null && !"".equals(tValiedStartDate) && df.parse(tValiedStartDate).after(df.parse(PubFun.getCurrentDate()))) 
					|| (tValiedEndDate!=null && !"".equals(tValiedEndDate) && df.parse(tValiedEndDate).before(df.parse(PubFun.getCurrentDate())))){
				CError tError = new CError();
				tError.moduleName = "LDUserBL";
				tError.functionName = "validateUser";
				tError.errorMessage = "UserCode does not in effective date!";
				this.mErrors.addOneError(tError);
				return false;
			}
			
			//4 将password解密后传给ldap验证
//			LisIDEA tLisIDEA=new LisIDEA();
//			LoginModel user = new LoginModel();
//			ADUser tADUser = new ADUser();
//			ADValidate tADValidate = new ADValidate();
//			tADUser.setUserCode(mLDUserSchema.getUserCode());
//			tADUser.setPassWord(tLisIDEA.decryptStringNew(this.tKeyWord));
//			tADUser = tADValidate.CheckUser(tADUser);
//			if(tADUser != null && tADUser.isLogin()){
//				user.setVerifyResult(true);
//				user.setPwdLastSetDate(tADUser.getPwdLastSetDate());
//			}else{
//				return false;
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 查询符合条件的信息 输出：如果准备数据时发生错误则返回false,否则返回true
	 * 
	 * @return boolean
	 */
	private boolean queryUser() {
		String encryptPwd = mLDUserSchema.getPassword();
		
		LDUserDB tLDUserDB = new LDUserDB();
		tLDUserDB.setUserCode(mLDUserSchema.getUserCode());
		tLDUserDB.setPassword(encryptPwd);
		mLDUserSet=tLDUserDB.query();
		
		if (tLDUserDB.mErrors.needDealError()) {
			// @@错误处理
			this.mErrors.copyAllErrors(tLDUserDB.mErrors);
			CError tError = new CError();
			tError.moduleName = "LDUserBL";
			tError.functionName = "queryUser";
			tError.errorMessage = ""+bundle.getString("queryFaild")+"!";
			this.mErrors.addOneError(tError);
			mLDUserSet.clear();
			return false;
		}

		if (mLDUserSet == null || mLDUserSet.size() == 0) {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDUserBL";
			tError.functionName = "queryUser";
			tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
			this.mErrors.addOneError(tError);

			mLDUserSet.clear();
			return false;
		}

		// 判断用户的有效时间，包括开始时间和结束时间
		LDUserSchema tLDUserSchema = mLDUserSet.get(1);

		String strCurrentDate = PubFun.getCurrentDate();
		String strValidStartDate = tLDUserSchema.getValidStartDate();
		String strValidEndDate = tLDUserSchema.getValidEndDate();

		// 如果生效开始时间为空，则不做校验
		if (strValidStartDate != null && !strValidStartDate.equals("")) {

			if (strValidStartDate.compareTo(strCurrentDate) > 0) {
				CError tError = new CError();
				tError.moduleName = "LDUserBL";
				tError.functionName = "queryUser";
				tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
				this.mErrors.addOneError(tError);

				mLDUserSet.clear();
				return false;
			}
		}

		// 如果生效结束时间为空，则不做校验
		if (strValidEndDate != null && !strValidEndDate.equals("")) {

			if (strValidEndDate.compareTo(strCurrentDate) < 0) {
				CError tError = new CError();
				tError.moduleName = "LDUserBL";
				tError.functionName = "queryUser";
				tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
				this.mErrors.addOneError(tError);

				mLDUserSet.clear();
				return false;
			}
		}

		 System.out.println("here gose:");

		String ComCode = mLDUserSchema.getComCode();
//		tSBql = new StringBuffer(256);
//		tSBql.append("select * from ldcode where codetype = 'station' and code = '");
//		tSBql.append(ComCode);
//		tSBql.append("'");

		 System.out.println("ComCode:" + ComCode);
		int matchCount = 0;
		for (int i = 1; i <= mLDUserSet.size(); i++) {
			LDUserSchema tUserSchema = mLDUserSet.get(i);
			String getComCode = tUserSchema.getComCode();
			 System.out.println("getComCode:" + getComCode);
			 System.out.println("*************************");
			if (getComCode.length() > ComCode.length()) {
				continue;
			}
			int j = 0;
			for (; j < getComCode.length(); j++) {
				if (ComCode.charAt(j) != getComCode.charAt(j)) {
					break;
				}
			}

			if (j == getComCode.length()) {
				matchCount++;
			}
		}
		 System.out.println("matchCount:" + matchCount);
		if (matchCount == 0) {
			return false;
		}
		mResult.add(mLDUserSet);
		mResultNum = mLDUserSet.size();
		 System.out.println(mResult);
		 System.out.println("------------------------------------------------------------------------return true;");
		return true;
	}
}
