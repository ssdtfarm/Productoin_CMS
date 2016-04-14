/**
 * Copyright (c) 2002 sinosof
 * All right reserved.
 * 本类用于BPO从中取出前置服务器共享文件路径
 */
package com.sinosoft.utility;

import java.util.Properties;
import java.util.Hashtable;
import java.io.FileInputStream;
import java.net.URL;


public class BPOShareFilePath
{
    private Properties sharefileprop = new Properties();
    //private Hashtable sharefileTable = new Hashtable();

    public BPOShareFilePath()
    {
        super();
    }

    /** * 在类中取得当前文件所在的相对路径与绝对路径 *
     *  * @return String
     * */
    private String getCurrentClassPath()
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
    private  void readShareProperties()
    {
//        try
//        {
//            String propPath = getCurrentClassPath() + "BPOShareFilePath.properties";
//            FileInputStream in = new FileInputStream(propPath);
//            sharefileprop.load(in);
//            in.close();
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//            sharefileprop = null;
//        }
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
            readShareProperties();
            BPOPath = sharefileprop.getProperty(BPOID);
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




    /**主函数
     * **/
//    public static void main(String[] args)
//    {
//        BPOShareFilePath tBPOShareFilePath = new BPOShareFilePath();
//        try
//        {
//          String sharepath_sunyard =  tBPOShareFilePath.getShareFilePath("sunyard");
//
//          String sharepath_cpi =  tBPOShareFilePath.getShareFilePath("compupacific");
//
//          System.out.println("sharepath_sunyard==" + sharepath_sunyard);
//
//          System.out.println("sharepath_cpi==" + sharepath_cpi);
//        }
//        catch (Exception e)
//        {
//            System.out.print(e.getMessage());
//        }
//    }


}
