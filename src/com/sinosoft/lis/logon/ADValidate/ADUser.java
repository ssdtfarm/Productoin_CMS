package com.sinosoft.lis.logon.ADValidate;

import java.util.Date;

import com.sinosoft.lis.logon.ADValidate.LoginModel;


public class ADUser {
	
	private String userCode;
	
	private String passWord;
	
	private String pwdLastSetDate;//
	
	private boolean isLogin;
	
	private String newPassWord;

	
	

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public String getPwdLastSetDate() {
		return pwdLastSetDate;
	}

	public void setPwdLastSetDate(String pwdLastSetDate) {
		this.pwdLastSetDate = pwdLastSetDate;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	
//	public static void main(String[] args) {
//		
//		LoginModel user = new LoginModel();
//		
//		ADUser tADUser = new ADUser();
//		tADUser.setUserCode("hk_test");
//		tADUser.setPassWord("Metlife01");
//		ADValidate tADValidate = new ADValidate();
//		
//		tADUser = tADValidate.CheckUser(tADUser);
//		
//		if(tADUser != null && tADUser.isLogin())
//		{
//			user.setVerifyResult(true);
//
//
//			user.setPwdLastSetDate(tADUser.getPwdLastSetDate());
//			
//		}
//		else
//		{
//			user.setVerifyResult(false);
//			
//		}
//	}
}


