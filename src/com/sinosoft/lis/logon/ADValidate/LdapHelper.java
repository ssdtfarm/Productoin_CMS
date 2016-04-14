package com.sinosoft.lis.logon.ADValidate;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;




public class LdapHelper {

    private LdapContext ctx ;

    @SuppressWarnings(value = "unchecked")
    public DirContext getCtx(String usercode,String password) {
    	
//    	System.out.println("usercode-----"+usercode);
//    	System.out.println("password-----"+password);
    	
    	ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		SSRS ssrs2 = new SSRS();
		String ldapurlSql = "select sysvarvalue from ldsysvar where sysvar = 'ldapurl'";
		String ldapprincipalSql = "select sysvarvalue from ldsysvar where sysvar = 'ldapprincipal'";
		
		ssrs1 = exeSQL.execSQL(ldapurlSql);
		ssrs2 = exeSQL.execSQL(ldapprincipalSql);
		
		String ldapurl = ssrs1.GetText(1,1);
		String ldapprincipal = ssrs2.GetText(1,1);
		
    	System.out.println("=====================LDAP=============================");
//    	System.out.println(ldapurl);
//    	System.out.println(ldapprincipal);
    	
    	Hashtable env = new Hashtable(100);
        env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		//env.put("java.naming.provider.url", (new StringBuilder("ldap://")).append("10.164.252.92").append(":").append("389").toString());
		env.put("java.naming.provider.url", ldapurl);
		//env.put("java.naming.security.authentication", "simple");
		//env.put("java.naming.security.principal", (new StringBuilder(String.valueOf("8601000447"))).append("@").append("metcne2e.com.cn").toString());
		env.put("java.naming.security.principal", usercode + ldapprincipal);
		env.put("java.naming.security.credentials", password);
		env.put("java.naming.referral", "throw");
		//env.put("java.naming.security.protocol","ssl"); 
		
		
        try {
            // 链接ldap
            ctx = new InitialLdapContext(env,null);
        } catch (javax.naming.AuthenticationException e) {
            e.printStackTrace();
            ctx = null;
        } catch (Exception e) {
            e.printStackTrace();
            ctx = null;
        }
        return ((DirContext)ctx);
    }
    
    public DirContext getCtxSSL(String usercode,String password) {
    	
    	
    	ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		SSRS ssrs2 = new SSRS();
		String ldapurlSql = "select sysvarvalue from ldsysvar where sysvar = 'ldapsslurl'";
		String ldapprincipalSql = "select sysvarvalue from ldsysvar where sysvar = 'ldapprincipal'";
		
		ssrs1 = exeSQL.execSQL(ldapurlSql);
		ssrs2 = exeSQL.execSQL(ldapprincipalSql);
		
		String ldapurl = ssrs1.GetText(1,1);
		String ldapprincipal = ssrs2.GetText(1,1);
		
//    	System.out.println("=====================LDAP-SSL=============================");
//    	System.out.println(ldapurl);
//    	System.out.println(ldapprincipal);
    	
    	//String keystore = "/usr/java/jdk1.5.0_18/bin/securityad.keystore"; 
    	//String keystore = "/usr/java/jdk1.5.0_18/lib/security/cacerts";securityad92.keystore
    	String keystoreSql = "select sysvarvalue from ldsysvar where sysvar = 'keystore'";
    	ssrs1 = exeSQL.execSQL(keystoreSql);
    	String keystore = ssrs1.GetText(1,1);
    	File ff= new File(keystore);
    	if(ff.exists())
    	{
    		System.out.println("File OK1 ===========================");
    	}
    	
    	//String keystore = "\\usr\\java\\jdk1.5.0_18\\jre\\lib\\security\\cacerts";
        System.setProperty("javax.net.ssl.trustStore", keystore);   
    	
        Hashtable env = new Hashtable(100);
        
        env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		//env.put("java.naming.provider.url", (new StringBuilder("ldap://")).append("10.164.252.92").append(":").append("389").toString());
		env.put("java.naming.provider.url", ldapurl);
        //env.put("java.naming.provider.url", "ldap://cnidcapp55.metcne2e.com.cn:636");
		env.put("java.naming.security.authentication", "simple");
		//env.put("java.naming.security.principal", (new StringBuilder(String.valueOf("8601000447"))).append("@").append("metcne2e.com.cn").toString());
		env.put("java.naming.security.principal", usercode + ldapprincipal);
		env.put("java.naming.security.credentials", password);
		env.put("java.naming.referral", "throw");
		env.put("java.naming.security.protocol","ssl"); 
		
		
        try {
            // 链接ldap
            ctx = new InitialLdapContext(env,null);
            System.out.println("认证成功-------1");
        } catch (javax.naming.AuthenticationException e) {
            System.out.println("认证失败-------2");
            e.printStackTrace();
            ctx = null;
        } catch (Exception e) {
            System.out.println("认证出错：--------3");
            e.printStackTrace();
            ctx = null;
        }
        return ((DirContext)ctx);
    }
    
    /*
    @SuppressWarnings(value = "unchecked")
    public static boolean verifySHA(String ldappw, String inputpw)
            throws NoSuchAlgorithmException {

        // MessageDigest 提供了消息摘要算法，如 MD5 或 SHA，的功能，这里LDAP使用的是SHA-1
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        // 取出加密字符
        if (ldappw.startsWith("{SSHA}")) {
            ldappw = ldappw.substring(6);
        } else if (ldappw.startsWith("{SHA}")) {
            ldappw = ldappw.substring(5);
        }

        // 解码BASE64
        byte[] ldappwbyte = Base64.decode(ldappw);
        byte[] shacode;
        byte[] salt;

        // 前20位是SHA-1加密段，20位后是最初加密时的随机明文
        if (ldappwbyte.length <= 20) {
            shacode = ldappwbyte;
            salt = new byte[0];
        } else {
            shacode = new byte[20];
            salt = new byte[ldappwbyte.length - 20];
            System.arraycopy(ldappwbyte, 0, shacode, 0, 20);
            System.arraycopy(ldappwbyte, 20, salt, 0, salt.length);
        }

        // 把用户输入的密码添加到摘要计算信息
        md.update(inputpw.getBytes());
        // 把随机明文添加到摘要计算信息
        md.update(salt);

        // 按SSHA把当前用户密码进行计算
        byte[] inputpwbyte = md.digest();

        // 返回校验结果
        return MessageDigest.isEqual(shacode, inputpwbyte);
    }
*/
    /*
    //认证用户
    public static boolean authenticate(String usr, String pwd) {
        boolean success = false;
        DirContext ctx = null;
        try {
            ctx = LdapHelper.getCtx();
            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
            // constraints.setSearchScope(SearchControls.ONELEVEL_SCOPE);
            NamingEnumeration en = ctx.search("dc=metcne2e,dc=com,dc=cn", "cn=" + usr, constraints); // 查询所有用户
            //long t = (long) 128940324526036250.00;
            //System.out.println(new Date(t));
            
            while (en != null && en.hasMoreElements()) {
                Object obj = en.nextElement();
                if (obj instanceof SearchResult) {
                    SearchResult si = (SearchResult) obj;
                    System.out.println("name:   " + si.getName());
                    Attributes attrs = si.getAttributes();
                    if (attrs == null) {
                        System.out.println("No   attributes");
                    } else {
                        Attribute attr = attrs.get("userpassword");
                        NamingEnumeration en1=attrs.getAll();
                       
                        while (en1 != null && en1.hasMoreElements()) {
                            
                        	//Object obj1 = en.nextElement().toString();
                        	 System.out.println(en1.nextElement());
                            //System.out.println("getall======"+obj1.toString());
                        }
                        Object o = attr.get();
                        System.out.println("No   attributes----------------"+o.toString());
                        byte[] s = (byte[]) o;
                        String pwd2 = new String(s);
                        success = LdapHelper.verifySHA(pwd2, pwd);
                        return success;
                    }
                } else {
                    System.out.println(obj);
                }
                System.out.println();
            }
            ctx.close();
        } catch (NoSuchAlgorithmException ex) {
            try {
                if (ctx != null) {
                    ctx.close();
                }
            } catch (NamingException namingException) {
                namingException.printStackTrace();
            }
            
        } catch (NamingException ex) {
            try {
            	System.out.println(ex);
                if (ctx != null) {
                    ctx.close();
                }
            } catch (NamingException namingException) {
                namingException.printStackTrace();
            }
            
        }
        return false;
    }

    */
    
    //修改密码：
    public String updatePwdLdap(String usercode, String password, String newPassword) {
            
            DirContext ctx = null;
            LdapHelper tLdapHelper = new LdapHelper();
            
            try {
            	
                ctx = tLdapHelper.getCtxSSL(usercode,password);
                
                if(ctx != null)
                {
                	String newQuotedPassword = "\"" + newPassword + "\"";
                    String oldQuotedPassword = "\"" + password + "\"";
                    
                    byte[] newUnicodePassword = newQuotedPassword.getBytes("UTF-16LE");
                    byte[] oldUnicodePassword = oldQuotedPassword.getBytes("UTF-16LE");
                    
                    ExeSQL exeSQL = new ExeSQL();
            		SSRS ssrs1 = new SSRS();
            		String ldapnameSql = "select sysvarvalue from ldsysvar where sysvar = 'ldapname'";
            		ssrs1 = exeSQL.execSQL(ldapnameSql);
            		String ldapname = ssrs1.GetText(1,1);
            		
                    //String userName = usercode + ldapprincipal;
                    String userName = "CN="+ usercode +","+ ldapname ;
                    
                    
                    ModificationItem[] mods = new ModificationItem[2];

                    mods[0] = new ModificationItem(3, new BasicAttribute("unicodePwd", oldUnicodePassword));
                    mods[1] = new ModificationItem(1, new BasicAttribute("unicodePwd", newUnicodePassword));


                    ctx.modifyAttributes(userName, mods);
                    
                    ctx.close();
                    return "1";//成功

                }
                else
                {
                	return "2";//原密码错误
                }
          
            } catch (Exception ex) {
            	
            	ex.printStackTrace();
                try {
                    if (ctx != null) {
                        ctx.close();
                        return "3";//出现错误
                    }
                } catch (NamingException namingException) {
                    namingException.printStackTrace();
                    return "3";//出现错误
                }     
            }
            return "3";//出现错误
        }

   
    public static Calendar dateToCalendar(int date)
    {
      int day = date % 100;
      int month = date / 100 % 100 - 1;
      int year = date / 10000;
      Calendar cal = Calendar.getInstance();
      
      cal.set(year, month, day);
      
      //System.out.println(year+"---" + month + "---" + day);
      
      return cal;
    }

    public static int calendarToDate(Calendar cal) {
      int day = cal.get(5);

      int month = cal.get(2) + 2;
      int year = cal.get(1);
      
      return (year * 10000 + month * 100 + day);
    }
    
    public static String getCurrentDate()
    {
      
      Date today = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      String datenewformat = sdf.format(today);
      return datenewformat;
    }
    
    public static String getDate(Date today)
    {

      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      String datenewformat = sdf.format(today);
      return datenewformat;
    }
    
//    public static void main(String[] args) {
//        //getCtx();
//    	//LdapHelper.authenticate("maptest","Aa111111");
//        //System.out.println(LdapHelper.authenticate("maptest","Ss111111"));
//    	//LdapHelper.updatePwdLdap("8601000447","Met");
//    	long ll = Long.parseLong("128950056732968750");
//    	String qq = "128950056732968750";
//    	//long ll = (long) 128950056732968750.00;
//    	long DateInUserDefinedFormat = ll - -717324288L;
//        DateInUserDefinedFormat = DateInUserDefinedFormat / 10000L;
//        Date theDate = new Date(DateInUserDefinedFormat);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        String forDate1 = formatter.format(theDate);
//    	
//        int intFormatterValue = Integer.parseInt(forDate1);
//        Calendar cal = LdapHelper.dateToCalendar(intFormatterValue);
//        cal.add(5, 60);
//        int date2 = LdapHelper.calendarToDate(cal);
//        
//        System.out.println(theDate);
//    	
//        //2908915200
//    	//System.out.println(LdapHelper.getCurrentDate());
//    	
//    	int iYearsFrom1601to1970 = 1970 - 1601;
//    	int iDaysFrom1601to1970 = iYearsFrom1601to1970 * 365;
//    	iDaysFrom1601to1970 += iYearsFrom1601to1970 / 4; // leap years
//    	iDaysFrom1601to1970 -= 3; // non-leap centuries (1700,1800,1900).  2000 is a leap century
//    	long iSecondsFrom1601to1970 = iDaysFrom1601to1970 * 24 * 60 * 60;
//
//    	long iTotalSecondsSince1601 = (int)(138951231503433443L / 10000000);
//
//    	long iTotalSecondsSince1970 = iTotalSecondsSince1601 - iSecondsFrom1601to1970;
//    	Date oDate = new Date(iTotalSecondsSince1970 * 1000);
//    	System.out.println(oDate);
//    	
//    	
//    }
  
}