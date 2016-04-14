/**
 * Copyright (c) 2002 sinosof
 * All right reserved.
 * 本类用于BPO从中取出前置服务器共享文件路径
 */
package com.sinosoft.utility;

import java.util.Properties;
import java.io.FileInputStream;
import java.net.URL;
import java.net.InetAddress;


public class BPOParameterCache
{
    private static Properties sharefileprop = new Properties();
    private static BPOParameterCache mBPOParameterCache =null;
    private static String[] mBPONames = null;
    private static String mIP = null;
    private static String mSocketPwd = null;
    private static int mPort = 0;
    //private Hashtable sharefileTable = new Hashtable();

    private BPOParameterCache()
    {
        if(!readShareProperties()){
            System.out.println("读取BPOShareFilePath.properties文件失败");
        }
        if(!getBPOIds()){
            System.out.println("读取可用外包商ID失败");
        }
        if(!getIP()){
            System.out.println("本地IP获取失败");
        }
//        if(!getSocketPwd("socketpwd")){
//            System.out.println("服务密码获取失败");
//        }
    }
/**
* 2009-5-12 guomy 修改此类为单例模式
 */
    synchronized public static BPOParameterCache getInstance(){
        if(mBPOParameterCache==null){
            mBPOParameterCache=new BPOParameterCache();
        }
        return mBPOParameterCache;
    }

    /** * 在类中取得当前文件所在的相对路径与绝对路径 *
     *  * @return String
     * */
    private  String getCurrentClassPath()
    {
        String strClassName = getClass().getName();
        String strPackageName = "";
        if (getClass().getPackage() != null)
        {
            strPackageName = getClass().getPackage().getName();
        }
        System.out.println("ClassName:" + strClassName);
        System.out.println("PackageName:" + strPackageName);
        String strClassFileName = "";
        if (!"".equals(strPackageName))
        {
            strClassFileName = strClassName.substring(strPackageName.length() + 1, strClassName.length());
        }
        else
        {
            strClassFileName = strClassName;
        }
        System.out.println("ClassFileName:" + strClassFileName);
        URL url = null;
        url = getClass().getResource(strClassFileName + ".class");
        String strURL = url.toString();
        strURL = strURL.substring(strURL.indexOf('/') + 1,strURL.lastIndexOf('/'));
        strURL = strURL + (strURL.endsWith("/") ? "":"/" );
        //得到系统平台目录的分隔符(windows:“\”； linux：“/”)
        String  SysFileSeparator = System.getProperty("file.separator");
        String  SysPathSeparator = System.getProperty("path.separator");
        System.out.println("SysFileSeparator==" + SysFileSeparator);
        //System.out.println("SysPathSeparator==" + SysPathSeparator);
        //如果系统平台为linux,由于其根路径为“/”， 需要在获得的路径前加上反斜杠“/”
        if( SysFileSeparator != null && SysFileSeparator.equals("/"))
        {
            strURL =  (strURL.startsWith("/") ? "":"/" ) + strURL;
        }
        return strURL;
    }

    /*************************************************
     * 读取本类路径下的文件“BPOShareFilePath.properties”
     * 该文件路径与本类路径相同
     * ***********************************************/
    private  boolean readShareProperties()
    {
    	//return true;
        try
        {
//            String propPath = getCurrentClassPath() + "BPOShareFilePath.properties";
//            FileInputStream in = new FileInputStream(propPath);
//            sharefileprop.load(in);
//            in.close();
            return true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            sharefileprop = null;
            return false;
        }
    }

    /*************************************************
     * 该文件路径与本类路径相同
     * smb://administrator:sunyard@192.168.167.129/nclbpo/sunyard/
     * 以上字串为 smb 共享协议用法,其中:
     * (1)、[ smb:// ]  为 smb 共享协议
     * (2)、[ administrator ] 为共享用户；[ sunyard] 为用户共享密码
     *     用户密码之间用 [ : ] 隔开
     * (3)、[ 192.168.167.129/nclbpo/sunyard/ ] 为共享IP及其路径
     *    这段与前面的用户密码用 [ @ ] 隔开
     * 注意：如果要修改以上共享路径字符串， 尽量不要用中文字符，否则可能出现识别问题
     * ***********************************************/
//    private  void setSharefileTable()
//    {
//        try
//        {
//            //sharefileTable.put("sunyard","smb://administrator:sunyard@192.168.167.129/nclbpo/sunyard/");
//            //sharefileTable.put("compupacific","smb://administrator:sunyard@192.168.167.129/nclbpo/compupacific/");
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }


    /******
     * 获取BPOShareFilePath，传入参数
     * ****/
    public String getShareFilePath(String BPOID)
    {
        String BPOPath = "";
        try
        {
            BPOPath = sharefileprop.getProperty(BPOID.trim().toLowerCase());
            //setSharefileTable();
            //BPOPath = (String) sharefileTable.get(BPOID);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            BPOPath = null;
        }
        if( BPOPath == null  || ("").equals(BPOPath)) { BPOPath = ""; }
        return BPOPath;
    }

    /******
     * 获取备份目录路径，传入参数
     * ****/
    public String getBakFilePath(String BPOID)
    {
        String BPOBakPath = "";
        try
        {
            BPOBakPath = sharefileprop.getProperty(BPOID.trim().toLowerCase()+"bak");
            //setSharefileTable();
            //BPOPath = (String) sharefileTable.get(BPOID);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            BPOBakPath = null;
        }
        if( BPOBakPath == null  || ("").equals(BPOBakPath)) { BPOBakPath = ""; }
        return BPOBakPath;
    }

    /******
     * 获取BPOShareFilePath，传入参数
     * ****/
    public String getCrtlFilePath(String CrtlFile)
    {
        String CrtlFilePath = "";
        try
        {
            CrtlFilePath = sharefileprop.getProperty(CrtlFile.trim());
            //setSharefileTable();
            //BPOPath = (String) sharefileTable.get(BPOID);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            CrtlFilePath = null;
        }
        if( CrtlFilePath == null  || ("").equals(CrtlFilePath)) { CrtlFilePath = ""; }
        return CrtlFilePath;
    }

    /******
     * 获取服务端口校验密文
     * ****/
    private boolean getSocketPwd(String tSocketPwd)
    {
        try
        {
            mSocketPwd = sharefileprop.getProperty(tSocketPwd.trim());
            if( mSocketPwd == null  || ("").equals(mSocketPwd))
            {
                return false;
            }
            else
                return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    /******
     * 返回服务端口校验密文
     * ****/
    public String getSocketPwd()
    {
        return mSocketPwd;
    }

    /**
     * 2009-5-12  created by guomy
     * @return String[]
     */
    private boolean getBPOIds(){
        try{
            ExeSQL tExeSQL = new ExeSQL();
            SSRS tSSRS = tExeSQL.execSQL("select distinct trim(bpoid) from bpoallotrate where allottype='00' and  validflag='1'");
            int tMaxRow = tSSRS.getMaxRow();
            if(tSSRS != null && tMaxRow >= 1){
                mBPONames = new String[tMaxRow];
                for(int i=1;i<=tMaxRow;i++){
                    mBPONames[i-1]=tSSRS.GetText(i,1);
                }
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public String[] getBPONames(){
        return mBPONames;
    }

    private boolean getIP()
    {
        try{
           InetAddress tInetAddress = InetAddress.getLocalHost();
           mIP = tInetAddress.getHostAddress().toString();
           return true;
       }
       catch(Exception e){
           return false;
       }
    }

    public String getLocalIP()
    {
        return mIP;
    }

    public void setPort(int tPort)
    {
        mPort = tPort;
    }

    public int getPort()
    {
        return mPort;
    }


    /**主函数
     * **/
//    public static void main(String[] args)
//    {
//        BPOParameterCache tBPOShareFilePath = BPOParameterCache.getInstance();
//        try
//        {
//          String sharepath_sunyard =  tBPOShareFilePath.getShareFilePath("sunyard");
//
//          String sharepath_cpi =  tBPOShareFilePath.getShareFilePath("compupacific");
//
//          String bakpath_sunyard =  tBPOShareFilePath.getBakFilePath("sunyard");
//
//          String bakpath_cpi =  tBPOShareFilePath.getBakFilePath("compupacific");
//
//          String[] BPOIds = tBPOShareFilePath.getBPONames();
//
//          String IP = tBPOShareFilePath.getLocalIP();
//
//          String Pwd = tBPOShareFilePath.getSocketPwd();
//
//
//          System.out.println("sharepath_sunyard==" + sharepath_sunyard);
//
//          System.out.println("sharepath_cpi==" + sharepath_cpi);
//
//          System.out.println("bakpath_sunyard==" + bakpath_sunyard);
//
//          System.out.println("bakpath_cpi==" + bakpath_cpi);
//
//          System.out.println("IP==" + IP);
//
//          System.out.println("socketpwd==" + Pwd);
//
//        }
//        catch (Exception e)
//        {
//            System.out.print(e.getMessage());
//        }
//    }


}
