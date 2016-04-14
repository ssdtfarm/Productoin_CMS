package com.sinosoft.utility;

/**
 * <p>ClassName: JdbcUrl </p>
 * <p>Description: 构建 Jdbc 的 url </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @author: HST
 * @version: 1.0
 * @date: 2002-05-31
 */
public class JdbcUrl {
  // @Constructor
  public JdbcUrl() {

      //WebSphere连接池
//    DBType = "WEBSPHERE";
//    DBName = "jdbc/CMS_HK";
	  
  DBType = "SQLSERVER";
  IP = "192.168.42.200";
  Port = "1433";
  DBName = "Production_CMS_International";
  UserName = "sa";
  PassWord = "sa@123";
	  
//	  DBType = "SQLSERVER";
//	  IP = "192.168.42.47";
//	  Port = "1433";
//	  DBName = "PCMSHIST_UAT";
//	  UserName = "sa";
//	  PassWord = "sa@123";
	  
//	  DBType = "SQLSERVER";
//	  IP = "192.168.42.200";
//	  Port = "1433";
//	  DBName = "MetLifeHK_CMS_DEV";
//	  UserName = "sa";
//	  PassWord = "sa@123";
	  
//	    DBType = "WEBSPHERE";
//	    DBName = "jdbc/CMS_HK_Dev";

//    DBType = "SQLSERVER";
//    IP = "10.175.60.92";
//    Port = "1433";
//    DBName = "PCMSHIST_UAT";
//    UserName = "metpcms_uat";
//    PassWord = "metpcms_uat";
  }
  
  public JdbcUrl(String dbType, String ip, String port, String dbName, String username, String password) {
	    DBType = dbType;
	    IP = ip;
	    Port = port;
	    DBName = dbName;
	    UserName = username;
	    PassWord = password;
  }

  // @Field
  private String DBType;
  private String IP;
  private String Port;
  private String DBName;
  private String ServerName;
  private String UserName;
  private String PassWord;

  // @Method
  public String getDBType() {
    return DBType;
  }

  public String getIP() {
    return IP;
  }

  public String getPort() {
    return Port;
  }

  public String getDBName() {
    return DBName;
  }

  public String getServerName() {
    return ServerName;
  }

  public String getUserName() {
    return UserName;
  }

  public String getPassWord() {
    return PassWord;
  }

  public void setDBType(String aDBType) {
    DBType = aDBType;
  }

  public void setIP(String aIP) {
    IP = aIP;
  }

  public void setPort(String aPort) {
    IP = aPort;
  }

  public void setDBName(String aDBName) {
    DBName = aDBName;
  }

  public void setServerName(String aServerName) {
    ServerName = aServerName;
  }

  public void setUser(String aUserName) {
    UserName = aUserName;
  }

  public void setPassWord(String aPassWord) {
    PassWord = aPassWord;
  }

  public String getJdbcUrl() {
    String sUrl = "";

    if (DBType.trim().toUpperCase().equals("ORACLE")) {
      sUrl = "jdbc:oracle:thin:@" + IP + ":"
          + Port + ":"
          + DBName;
    }

    if (DBType.trim().toUpperCase().equals("INFORMIX")) {
      sUrl = "jdbc:informix-sqli://" + IP + ":"
          + Port + "/"
          + DBName + ":"
          + "informixserver=" + ServerName + ";"
          + "user=" + UserName + ";"
          + "password=" + PassWord + ";";
    }

    if (DBType.trim().toUpperCase().equals("SQLSERVER")) {
      sUrl = "jdbc:sqlserver://" + IP + ":" + Port + ";DatabaseName=" + DBName;
    }
    if (DBType.trim().toUpperCase().equals("DB2")) {
      sUrl = "jdbc:db2://" + IP + ":"
          + Port + "/"
          + DBName;
    }
    return sUrl;
  }
}
