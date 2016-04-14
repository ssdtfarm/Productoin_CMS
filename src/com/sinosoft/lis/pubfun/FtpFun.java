package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpLoginException;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpProtocolException;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: sinosoft</p>
 *
 * @author zhaohw
 * @version 1.0
 */
public class FtpFun
{
    private FtpClient mFtpClient = null;

    public FtpFun()
    {

    }

    /**
     * 建立FtpClient对象
     * @param hostname String
     * @param port int
     * @param username String
     * @param password String
     * @return FtpClient
     */
    public FtpClient connectFtpServer(String hostname,int port,String username,String password)
    {

        try
        {
            mFtpClient = new FtpClient(hostname,port);
            mFtpClient.login(username,password);
        } catch(FtpLoginException e1)
        {
            System.out.print("...... 用户名密码错误 ......");
            e1.printStackTrace();
            return null;
        } catch(IOException e2)
        {
            System.out.println("...... 未知错误 ......");
            e2.printStackTrace();
            return null;
        } catch(SecurityException e3)
        {
            System.out.print("...... 权限不足 ......");
            e3.printStackTrace();
            return null;
        }
        return mFtpClient;

    }

    public void downloadFile(String path,String filename)
    {
        try
        {
            if(path.length() != 0)
            {
                mFtpClient.cd(path);
            }
            mFtpClient.binary();
            TelnetInputStream tis = mFtpClient.get(filename);
            File outFile = new File("d:\\" + filename);
            FileOutputStream fos = new FileOutputStream(outFile);
            byte[] bytes = new byte[2048];
            int c;
            while((c = tis.read(bytes)) != -1)
            {
                fos.write(bytes,0,c);
            }
            tis.close();
            fos.close();
            mFtpClient.closeServer();
        } catch(IOException ex)
        {
            System.out.println("...... 下载文件失败 ......");
            ex.printStackTrace();
        }

    }

    public boolean uploadFile(String inPath,String inFilename,String outPath,String outFilename)
    {

        try
        {
            if(outPath.length() != 0)
            {
                mFtpClient.cd(outPath);
            }
            mFtpClient.binary();
            TelnetOutputStream tos = mFtpClient.put(outFilename);
            File inFile = new File(inPath + inFilename);
            System.out.println("...... 上载文件大小:" + inFile.length() / 1024 + "K ......");
            FileInputStream fis = new FileInputStream(inFile);
            byte[] bytes = new byte[2048];
            int c;
            while((c = fis.read(bytes)) != -1)
            {
                tos.write(bytes,0,c);
            }
            fis.close();
            tos.close();
            mFtpClient.closeServer();
        }

        catch(FtpProtocolException ex1)
        {
            System.out.println("...... 不能在该目录下创建文件 ......");
            ex1.printStackTrace();
            return false;
        } catch(IOException ex2)
        {
            System.out.println("...... 未知错误 ......");
            ex2.printStackTrace();
            return false;
        }

        return true;
    }


    public String getSystemInfo()
    {
        String systemInfo = null;
        try
        {
            systemInfo = mFtpClient.system();
        } catch(IOException ex)
        {
            System.out.println("......得到系统信息出错......");
            ex.printStackTrace();
        }

        return systemInfo;
    }

//    public static void main(String[] args)
//    {
//        FtpFun tFtpFun = new FtpFun();
//        FtpClient tFtpClient = tFtpFun.connectFtpServer("172.19.1.43",21,"oracle","oracle");
//
//        if(tFtpClient != null)
//        {
//            System.out.println("已经连接上ftp server" + tFtpFun.getSystemInfo());
//            tFtpFun.downloadFile("/app/uploadfile/lisfile/","DE2007-01-03_Mov.txt");
//            //tFtpFun.uploadFile("/app/uploadfile/lisfile","DE2007-01-03_Mov.txt");
//
//
//        }
//
//    }
}
