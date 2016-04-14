package com.sinosoft.lis.logon.ADValidate;

import java.io.Serializable;



public class LoginModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userType;          // 用户类型：LP、SysUser
    private String userCode;          // 用户代码
    private String password;    // 用户密码
    
    private String manageCom; //用管理机构
    private String branchType; //展业机构
    private String userState ; // 用户状态(01－增员，02－二次增员，03－离职,04-二次离职,05-清退）
    
    private boolean verifyResult;
    private boolean verifyPwd;
    
    private String pwdLastSetDate;//密码最后一次设置时间
    
    
    
    private boolean isLogin;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getManageCom() {
		return manageCom;
	}

	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public boolean isVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(boolean verifyResult) {
		this.verifyResult = verifyResult;
	}

	public String getPwdLastSetDate() {
		return pwdLastSetDate;
	}

	public void setPwdLastSetDate(String pwdLastSetDate) {
		this.pwdLastSetDate = pwdLastSetDate;
	}

	public boolean isVerifyPwd() {
		return verifyPwd;
	}

	public void setVerifyPwd(boolean verifyPwd) {
		this.verifyPwd = verifyPwd;
	}

	

}
