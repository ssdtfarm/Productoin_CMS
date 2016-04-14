package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpLoginException;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpProtocolException;

/**
 * <p>Title:FTP功能函数 </p>
 * <p>Description: FTP功能增强版 增加文件夹批量上传下载</p>
 * <p>Copyright: sinosoft Copyright (c) 2009</p>
 * <p>Date: 2009-10-22
 * @author yanxing
 * @version 1.1
 */
public class FtpFunEX {

    private FtpClient mFtpClient = null;
    private OutputStream upOS = null; 
    private FileInputStream upIS = null; 
    private OutputStream downOS = null; 
    private FileInputStream downIS = null; 
    private String upFileFullName = "";//需要上传的目录
    private String defPath = "";//批量上载默认路径
    private String downFileFullName = "";//需要下载的目录
    private List FileList = new ArrayList();
    public  boolean downFileIsEmpty = true;//文件夹下载 是否为空文件夹的标志位
    

    public FtpFunEX()
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

    /**
     * 下载文件(单个) 旧方法
     * @param ftppath FTP文件路径 为""表示根目录 后不加"/"
     * @param ftpname FTP文件名
     * @param aimpath 目标路径 后不加"/"
     * @param ainname 目标文件名 为""表示不改变文件名
     */
    public void downloadFile(String ftppath,String ftpname,String aimpath,String aimname)
    {
        try
        {
            if(ftppath.length() != 0)
            {
                mFtpClient.cd(ftppath);
            }
            mFtpClient.binary();
            TelnetInputStream tis = mFtpClient.get(ftppath+"/"+ftpname);
            if(aimname.length() ==0)
            {
            	aimname = ftpname;
            }
            File outFile = new File(aimpath +"/"+ aimname);
            
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

    /**
     * 上载文件(单个) 旧实现方法
     * @param inPath
     * @param inFilename
     * @param outPath
     * @param outFilename
     * @return
     */
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

    /**
     * 获取FTP系统信息
     * @return
     */
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
    
    /**
     * ftp上传文件夹下所有的文件(包括子目录文件夹) 批量
     * @param upFileFullName   本地全路径 末尾不用加"/"
     * @param folderName       文件夹名 末尾不用加"/"
     * @param aimPath          相对于FTP根目录的路径 末尾不用加"/"
     * @return
     */
	public boolean uploadFolder(String upFileFullName,String folderName,String aimPath) {
		this.upFileFullName = upFileFullName;
		try {
			String savefilename = new String(this.upFileFullName.getBytes("ISO-8859-1"), "UTF-8");
			// 打开本地待长传的文件
			File file_in = new File(savefilename);
//			createFolder(folderName,mFtpClient);
//			mFtpClient.cd(folderName);
			mFtpClient.cd(aimPath);
			mFtpClient.list();
			processUpFile(file_in, mFtpClient);
			if (upIS != null) {
				upIS.close();
			}
			if (upOS != null) {
				upOS.close();
			}
//			if (mFtpClient != null) {
//				mFtpClient.closeServer();
//			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception e in Ftp upload(): " + e.toString());
			return false;
		}

	} 
	 
    
    /**
	 * 上传文件进程 递归批量
	 * 
	 * @param source
	 * @param ftpClient
	 * @throws Exception
	 */
	private void processUpFile(File source, FtpClient ftpClient) {
		try {
			if (source.exists()) {
				if (source.isDirectory()) {
//					System.out.println(ftpClient.pwd());
					String tempPaht = source.getPath().substring(upFileFullName.length()).replace("\\", "/");
					if (!isFolderExist(tempPaht,ftpClient)) {
						createFolder(tempPaht,ftpClient);
//						ftpClient.list();
//						System.out.println(ftpClient.pwd());
					}else{
//						System.out.println(ftpClient.pwd());
						String[] xxx = tempPaht.split("/");
						for(int n = 0; n < xxx.length;n++)
						{
							if(!xxx[n].equals(""))
							{
								ftpClient.cdUp();
							}
						}
					}
					
					File sourceFile[] = source.listFiles();
					for (int i = 0; i < sourceFile.length; i++) {
						if (sourceFile[i].exists()) {
							if (sourceFile[i].isDirectory()) {
								this.processUpFile(sourceFile[i], ftpClient);
							} else {
								String cdPath = cheangPath(sourceFile[i].getPath(),upFileFullName);
								//测试用
//								System.out.println(ftpClient.pwd());
								ftpClient.cd(cdPath);
								
								ftpClient.binary();
								upOS = ftpClient.put(sourceFile[i].getName());
								byte[] bytes = new byte[5*1024];//修改为5×1024 应该能加快上载速度
								upIS = new FileInputStream(sourceFile[i]);
								// 开始复制
								int c;
								// 暂未考虑中途终止的情况
								while ((c = upIS.read(bytes)) != -1) {
									upOS.write(bytes, 0, c);
								}
								upIS.close();
								upOS.close();
								String[] mmm = cdPath.split("/");
								for(int n = 0; n < mmm.length;n++)
								{
									if(!mmm[n].equals(""))
									{
										ftpClient.cdUp();
									}
								}
							}
						}
					}
				} else {
					ftpClient.cd(cheangPath(source.getPath(),upFileFullName));
					ftpClient.binary();
					upOS = ftpClient.put(source.getName());
					byte[] bytes = new byte[5*1024]; //修改为5×1024 应该能加快上载速度
					upIS = new FileInputStream(source);
					// 开始复制
					int c;
					// 暂未考虑中途终止的情况
					while ((c = upIS.read(bytes)) != -1) {
						upOS.write(bytes, 0, c);
					}
					upIS.close();
					upOS.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    

	/**
	 * ftp下载文件夹下所有的文件(包括子目录文件夹) 批量
	 * @param downFileFullName   FTP目录文件夹 不用加"/" 为空表示下载根目录
	 * @param toAimPath   存放文件目录文件夹 不用加"/"
	 * @return
	 */
	public boolean downFolder(String downFileFullName,String toAimPath) {
		this.downFileFullName = downFileFullName;
		try {
//			String savefilename = new String(toAimPath.getBytes("ISO-8859-1"), "GBK");
			// 进入FTP待下载的目录
//			mFtpClient.cd(downFileFullName);
			// 将要写到本地的目录
//			File file_down = new File(savefilename);
			makeFolder(toAimPath+"/"+downFileFullName);
			processDownFile(downFileFullName,toAimPath+"/"+downFileFullName, mFtpClient);
//			if (downIS != null) {
//				downIS.close();
//			}
//			if (downOS != null) {
//				downOS.close();
//			}
//			if (mFtpClient != null) {
//				mFtpClient.closeServer();
//			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception e in Ftp download(): " + e.toString());
			return false;
		}

	}
	
	/**
	 * 下载文件进程 批量 
	 * @param source  FTP上的文件夹路径名 末尾不用加“/”
	 * @param toAimPath  目标目录 存放下载下来的文件夹 末尾不用加“/”
	 * @param ftpClient
	 */
	public void processDownFile(String source,String toAimPath, FtpClient ftpClient)
	{
		try {
			ftpClient.cd(source);
			DataInputStream tDataInputStream = new DataInputStream(ftpClient.list());
			String filename = "";
			String [] temp = null;
			while((filename = tDataInputStream.readLine())!= null)
			{
				filename = new String(filename.getBytes("ISO-8859-1"),"gbk");
				temp = filename.split("[ ]+");
				if (temp[8].equals("."))
				{
					//无操作
				} else if (temp[8].equals("..")) 
				{
					//无操作
//				} else if ((temp[8].indexOf("."))==-1&&(temp[4].equals("0"))) {
				} else if ((temp[8].indexOf("."))==-1) {	
					//这种是文件夹
//					System.out.println(temp[8]);
					//同时记录下目录
					FileList.add("/"+temp[8]);					
//					makeFolder(toAimPath+"/"+temp[8]);//创建文件夹路径
					//递归继续往下写
					processDownFile(temp[8],toAimPath,ftpClient);
				} else 
				{
					//修改状态
					downFileIsEmpty = false;//说明文件夹不为空
					//这种是文件
//					System.out.println(temp[8]);
					//写文件
					ftpClient.binary();
					String temppath = getWritePath(FileList);
					makeFolder(toAimPath+temppath);//创建文件夹路径
		            TelnetInputStream tis = ftpClient.get(temp[8]);
		            File outFile = new File(toAimPath +temppath+ "/"+temp[8]);
		            FileOutputStream fos = new FileOutputStream(outFile);
		            byte[] bytes = new byte[5*1024]; //修改为5×1024 应该能加快下载速度
		            int c;
		            while((c = tis.read(bytes)) != -1)
		            {
		                fos.write(bytes,0,c);
		            }
		            tis.close();
		            fos.close();
				}
			}
			if(!FileList.isEmpty())
			{
				FileList.remove(FileList.size()-1);
			}
			ftpClient.cdUp();
			tDataInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    /**
	 * 重命名文件或者文件夹
	 * 
	 * @param oldname
	 * @param newname
	 * @return
	 */
    public boolean renameFolder(String oldname,String newname)
    {
    	try {
			mFtpClient.rename(oldname, newname);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    	return true;
    }
    
    /**
     * 移动文件或者文件夹
     * @param oldname
     * @param newname
     * @return
     */
    public boolean moveFile(String oldname,String newname)
    {
    	try {
			mFtpClient.rename(oldname, newname);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    	return true;
    }

    /**
     * FTP上传创建文件夹
     * @param folder
     */
    private boolean createFolder(String folder,FtpClient ftpClient) {

		try {
			ftpClient.ascii();
			StringTokenizer s = new StringTokenizer(folder, "/"); // sign
			s.countTokens();
			String pathName = "";
			while (s.hasMoreElements()) {
				pathName = pathName + "/" + (String) s.nextElement();
				if(pathName.substring(0, 1).equals("/"))
				{
					pathName = pathName.substring(1);
				}
				ftpClient.sendServer("MKD " + pathName + "\r\n");
				ftpClient.readServerResponse();
			}
			ftpClient.binary();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} 
    
    /**
     * FTP在根目录创建文件夹
     * @param folder
     * @return
     */
    public boolean createFolder(String folder)
    {
		try {
			mFtpClient.ascii();
			StringTokenizer s = new StringTokenizer(folder, "/"); // sign
			s.countTokens();
			String pathName = "";
			while (s.hasMoreElements()) {
				pathName = pathName + "/" + (String) s.nextElement();
				if(pathName.substring(0, 1).equals("/"))
				{
					pathName = pathName.substring(1);
				}
				mFtpClient.sendServer("MKD " + pathName + "\r\n");
				mFtpClient.readServerResponse();
			}
			mFtpClient.binary();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }

    /**
     * 检查文件夹是否存在
     * @param dir
     * @param ftpClient
     * @return
     */
    private boolean isFolderExist(String dir,FtpClient ftpClient) {
		try {
			ftpClient.cd(dir);
		} catch (Exception e) {
			return false;
		}
		return true;
	} 
     
    /**
	 * 进入指定文件夹
	 * 
	 * @param path
	 * @return
	 */
    public boolean cdFolderIn(String path) {
		try {
			mFtpClient.cd(path);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
    
	/**
	 * 后退一层文件夹
	 * @return
	 */
    public boolean cdFolderUp(){
		try {
			mFtpClient.cdUp();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
    /**
	 * 关闭FTP链接
	 * 
	 * @return
	 */
    public boolean closeConnect()
    {
    	try {
			mFtpClient.closeServer();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    	return true;
    }
    
    /**
     * 返回递归时嵌套的路径
     * @param list
     * @return
     */
    private String getWritePath(List list)
    {
    	StringBuffer temp = new StringBuffer();
    	for(int i=0;i<list.size();i++)
    	{
    		temp.append(list.get(i).toString());
    	}
    	return temp.toString();
    }
    
    /**
     * 
     * @param path 需要返回的路径
     * @param path2 上传或下载目录路径
     * @return
     */
	private String cheangPath(String path,String path2) {
		path = path.substring(path2.length()).replace("\\", "/");
		if ("".equals(path)) {
			path = "/";
		} else {
			path = path.substring(0, path.lastIndexOf("/") + 1);
		}
		
		if(path.substring(0, 1).equals("/"))
		{
			path = path.substring(1);
		}
		return path;
	}
    
	/**
	 * 用于下载到本地创建文件夹的方法
	 * @param mkdirName
	 */
	private void makeFolder(String folderPath)
	{
		try
		{
			StringTokenizer s = new StringTokenizer(folderPath, "/");
			s.countTokens();
			String pathName = "";
			while (s.hasMoreElements()) {
				pathName = pathName + "/" + (String) s.nextElement();
				File folder = new File(pathName);
				if(!folder.exists()){
					if(!folder.mkdir())
					{
						System.err.println("ERROR:FtpFunEX.java类中出现严重的问题。需要解决！！！");
						System.err.println(" 文件夹创建失败，清确认磁盘没有写保护并且空件足够");
						//System.exit(1);
						return;
					}
				}
			}
		}
		catch (Exception err)
		{
			System.err.println(""+bundle.getString("waitForTran")+"");
			err.printStackTrace();
		}
	}

	
	private static boolean test2()
	{
		String tPath = "D:/lis3.txt";
		File file = new File(tPath);
		if(file.isDirectory())
		{
			System.out.println("这是文件夹");
		}
		if(file.isFile())
		{
			System.out.println("这是文件");
		}
		if(file.exists())
		{
			System.out.println("这路径或者文件存在");
			return true;
		}else{
			System.out.println("找不到路径或者文件");
		}
		return true;
	}
	
//    public static void main(String[] args)
//    {
//    	FtpFunEX tFtpFun = new FtpFunEX();
//    	FtpClient tFtpClient = tFtpFun.connectFtpServer("10.2.6.101",21,"kangzhong","kangzhong");
//
//        if(tFtpClient != null)
//        {
//            System.out.println("已经连接上ftp server" + tFtpFun.getSystemInfo());
////            tFtpFun.downloadFile("/app/uploadfile/lisfile/","DE2007-01-03_Mov.txt");
////            tFtpFun.uploadFile("/app/uploadfile/lisfile","DE2007-01-03_Mov.txt");
////            tFtpFun.moveFile("/ReturnData", "/ReturnDataBackup/2009-11-21");
////            tFtpFun.createDir("/yanx_test");
////              tFtpFun.cdFolderIn("KangZhong");
////             tFtpFun.uploadFolder("D:/lis","","");
////             tFtpFun.downloadFile("NewMissions", "KZ_BQ_200910200000.xml");
////              tFtpFun.tprocessDownFile();
//            tFtpFun.downFolder("ReturnDataBackup/2009-12-03_131301", "D:/ftp");
////            tFtpFun.test();
//
//        }
////    	test2();
//    }
}
