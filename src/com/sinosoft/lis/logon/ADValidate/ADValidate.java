package com.sinosoft.lis.logon.ADValidate;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;

public class ADValidate {
	
	private static DirContext ctx;
	
	public ADUser CheckUser(ADUser aduser)
	  {
		ADUser resultADUser = new ADUser();
		
		DirContext ctx = null;
	    try
	    {

	      LdapHelper tLdapHelper = new LdapHelper();
	      ctx = tLdapHelper.getCtx(aduser.getUserCode(),aduser.getPassWord());
	      
	      if(ctx != null)
	      {
	    	  System.out.println("认证成功-----1");
	    	  SearchControls constraints = new SearchControls();
	          constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
	          String cnStr = "cn=" + aduser.getUserCode();
	          ExeSQL exeSQL = new ExeSQL();
	  		  SSRS ssrs1 = new SSRS();
	  		  String ldapsearchSql = "select sysvarvalue from ldsysvar where sysvar = 'ldapsearch'";
	  		  ssrs1 = exeSQL.execSQL(ldapsearchSql);
	  		  NamingEnumeration en = ctx.search(ssrs1.GetText(1,1), "objectclass=*", constraints); // 查询所有用户
	          while (en != null && en.hasMoreElements()){
	                Object obj = en.nextElement();
	                if (obj instanceof SearchResult) {
	                    SearchResult si = (SearchResult) obj;
	                    Attributes attrs = si.getAttributes();
	                    if (attrs == null) {
 	                        System.out.println("No   attributes");
 	                        return null;
 	                    }else{
	                    	resultADUser.setUserCode(aduser.getUserCode());
	                    	resultADUser.setLogin(true);
	                    	return resultADUser;
	                    }
	                }else {
	                	return null;
	                }
	          }
	          ctx.close();
	    	  
	      }
	      else
	    	  return null;

	    }
	    catch (Exception ex){
	    	ex.printStackTrace();
	    	return null;
	    }
	    return null;
	  }
	
	public String ChangePassWord(ADUser adUser)
	{
		LdapHelper tLdapHelper = new LdapHelper();
		String result = tLdapHelper.updatePwdLdap(adUser.getUserCode(), adUser.getPassWord(), adUser.getNewPassWord());
		if(result != null){
			return result;
		}else{
			return "3";//未知错误
		}
	}
}
