package com.sinosoft.lis.excel;

import java.io.File;
import java.util.Date;
import java.util.SimpleTimeZone;

import org.apache.poi.util.SystemOutLogger;

import com.sinosoft.lis.pubfun.PubFun;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * 
 * @version 1.0 2008-2-22
 * @author Wang Wei
 * @author Evan
 * 
 */
class ExcelUtil {
	// private static final Log logger = LogFactory.getLog("ExcelUtil");

	/**
	 * 
	 * @param name
	 *            Excel报表的名字, 例如:用户名_Excel模板名＿查询相关参数.xls．或者SQL.xls
	 *            名字最好跟用户名相关,要保证整个系统中不同用户之间的报表不会相互覆盖. 特别要注意生成报表条件（startDate,
	 *            endDate等）不同，名字也应该不相同， 否则发生错误
	 * @param usefulLifeSecs
	 *            设置有效报表的时间段,
	 *            即,如果存在同名报表，并且生成时间还没超过usefulLife秒，则直接可以使用,没有必要重新从数据库中查询生成
	 * @return 返回Result的一个对象
	 */
	public static ExcelInfo prepare(String name, long usefulLifeSecs) {
		// logger.info("getPath(String name, Long beforeSecond)");
		// logger.info("parameters:");
		// logger.info("name: " + name);
		// logger.info("usefulLife: " + usefulLifeSecs);
		ExcelInfo result = new ExcelInfo();

		// ---------------- retrieve the excel report path --------------
		StringBuffer sb = new StringBuffer();
		File file = PubFun.createFile(Config.getWorkPath());
		String workPath = file.getAbsolutePath();
//		System.out.println("getAbsolutePath==="+file.getAbsolutePath());
		// System.out.println(file.exists());///////////////
		if (!file.exists()) {
			file.mkdirs();
		}
		// System.out.println(file.lastModified());
		sb.append(workPath);
		sb.append(File.separator);
		sb.append(name);
		//
		File file2 = PubFun.createFile(sb.toString());
		if (file2.exists()) {
			long modifyTime = file2.lastModified();
			long now = System.currentTimeMillis();
			long diff = now - modifyTime;

			if (diff < usefulLifeSecs * 1000) {
				result.excelExists = true;
				result.modifyTime = modifyTime;
			} else {
				result.excelExists = false;
			}
		} else {
			result.excelExists = false;
		}
		result.excelPath = sb.toString();
		if (result.excelExists)
			System.out.println("找到有效的Excel文件----" + name);
		else
			System.out.println("没找到有效的Excel文件----" + name);
		// logger.info("Excel路径" + result.excelPath);

		return result;
	}
	
	//add by maqingyu
	public static ExcelInfo prepare(String name, long usefulLifeSecs, String sysvar, String funName) {
		// logger.info("getPath(String name, Long beforeSecond)");
		// logger.info("parameters:");
		// logger.info("name: " + name);
		// logger.info("usefulLife: " + usefulLifeSecs);
		ExcelInfo result = new ExcelInfo();

		// ---------------- retrieve the excel report path --------------
		StringBuffer sb = new StringBuffer();
		File file = PubFun.createFile(Config.getWorkPath(sysvar, funName));
		String workPath = file.getAbsolutePath();
		// System.out.println(file.exists());///////////////
		if (!file.exists()) {
			file.mkdirs();
			System.out.println("create file path==="+file);
		}
		sb.append(workPath);
		sb.append(File.separator);
		sb.append(name);
		
		System.out.println("sb==="+sb.toString());
		//
		File file2 = PubFun.createFile(sb.toString());
		if (file2.exists()) {
			long modifyTime = file2.lastModified();
			long now = System.currentTimeMillis();
			long diff = now - modifyTime;

			if (diff < usefulLifeSecs * 1000) {
				result.excelExists = true;
				result.modifyTime = modifyTime;
			} else {
				result.excelExists = false;
			}
		} else {
			result.excelExists = false;
		}
		result.excelPath = sb.toString();
		if (result.excelExists)
			System.out.println("To find effective Excel file----" + name);
		else
			System.out.println("Couldn't find effective Excel file----" + name);
		// logger.info("Excel路径" + result.excelPath);
		
		System.out.println("result====XXX"+PubFun.getTime(result.getModifyTime()));

		return result;
	}

	/**
	 * 
	 * @param templetName
	 *            要查找的模板的名字
	 * @return 模板的绝对路经
	 */
	public static String getTempletPath(String templetName) {
		StringBuffer path = new StringBuffer();

		// logger.debug("Config.TEMPLET_PATH" + Config.getTempletPath());
		File file = PubFun.createFile(Config.getTempletPath());
		// logger.debug("file " + file.getName());
		path.append(file.getAbsolutePath());
		path.append(File.separator);
		path.append(templetName);

		return path.toString();
	}
	

	public static String getExcelPath(String fileName) {
		StringBuffer path = new StringBuffer();

		// logger.debug("Config.WORK_PATH" + Config.getTempletPath());
		File file = PubFun.createFile(Config.getWorkPath());
		// logger.debug("file " + file.getName());
		path.append(file.getAbsolutePath());
		path.append(File.separator);
		path.append(fileName);
//		System.out.println("path.toString==="+path.toString());

		return path.toString();
	}
	
	//add by maqingyu
	public static String getExcelPath(String fileName, String sysvar, String funName) {
		StringBuffer path = new StringBuffer();

		// logger.debug("Config.WORK_PATH" + Config.getTempletPath());
		File file = PubFun.createFile(Config.getWorkPath(sysvar, funName));
		// logger.debug("file " + file.getName());
		path.append(file.getAbsolutePath());
		path.append(File.separator);
		path.append(fileName);
		
//		System.out.println("111+file.getAbsolutePath()==="+file.getAbsolutePath());
//		System.out.println("111+path.toString==="+path.toString());

		return path.toString();
	}


	/**
	 * 删除exceptedFileName以外的所有名字以startOfFileName开头并且生成时间超过beforeSecs秒的报表
	 * 
	 * @param startOfFileName
	 * @param exceptedFileName
	 * @param beforeSecs
	 */
	public static void removeStartWithExcept(String startOfFileName,
			String exceptedFileName, long beforeSecs) {
		// logger.info("removeStartWithExcept(String startOfFileName, "
		// + "String exceptedFileName, long beforeSecs)");
		// logger.info("parameter:");
		// logger.info("startOfFileName:" + startOfFileName);
		// logger.info("exceptedFileName:" + exceptedFileName);
		// logger.info("beforeSecs:" + beforeSecs);

		if (startOfFileName != null)
			startOfFileName = startOfFileName.trim();
		if (exceptedFileName != null)
			exceptedFileName = exceptedFileName.trim();
		File file = PubFun.createFile(Config.getWorkPath());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().trim().startsWith(startOfFileName)) {
					if (exceptedFileName != null
							&& exceptedFileName.equals(files[i].getName()
									.trim()))
						continue;
					if (beforeSecs * 1000 <= System.currentTimeMillis()
							- files[i].lastModified()) {
						boolean deleted = files[i].delete();
						// logger.info(files[i].getName() + " 被删除");
						if (deleted)
							System.out.println(files[i].getName() + " 被删除");
						else
							System.out.println(files[i].getName() + " 无法删除");
					}
				}
			}
		}
	}
	
	
	//add by Maqingyu
	//删除今天产生以外的文件(带有前台的报表)
	public static void removeStartWithExcept(String startOfFileName,
			String exceptedFileName, long beforeSecs,String sysvar, String funName) {

		if (startOfFileName != null)
			startOfFileName = startOfFileName.trim();
		if (exceptedFileName != null)
			exceptedFileName = exceptedFileName.trim();
		File file = PubFun.createFile(Config.getWorkPath(sysvar, funName));
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (!files[i].getName().trim().startsWith(startOfFileName)) {
					if (exceptedFileName != null
							&& exceptedFileName.equals(files[i].getName().trim()))
						continue;
					if (beforeSecs * 1000 <= System.currentTimeMillis()
							- files[i].lastModified()) {
						boolean deleted = files[i].delete();
						// logger.info(files[i].getName() + " 被删除");
						if (deleted)
							System.out.println(files[i].getName() + " have been deleted!");
						else
							System.out.println(files[i].getName() + " Can not delete!");
					}
				}
			}
		}
	}
	
	
	//add by Maqingyu
		//删除今天产生以外的文件(自动的报表)
		public static void removeStartWithExcept_Auto(String startOfFileName,
				String exceptedFileName, long beforeSecs,String sysvar, String funName) {

			if (startOfFileName != null)
				startOfFileName = startOfFileName.trim();
			if (exceptedFileName != null)
				exceptedFileName = exceptedFileName.trim();
			File file = PubFun.createFile(Config.getWorkPath(sysvar, funName));
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().trim().startsWith(startOfFileName)) {
						if (exceptedFileName != null
								&& exceptedFileName.equals(files[i].getName().trim()))
							continue;
						if (beforeSecs * 1000 <= System.currentTimeMillis()
								- files[i].lastModified()) {
							boolean deleted = files[i].delete();
							// logger.info(files[i].getName() + " 被删除");
							if (deleted)
								System.out.println(files[i].getName() + " have been deleted!");
							else
								System.out.println(files[i].getName() + " Can not delete!");
						}
					}
				}
			}
		}
	
	
	public static boolean remove(String fileName) {
		boolean flag = false;
		String path = Config.getWorkPath();
		path = path + File.separator + fileName;
		
//		System.out.println("remove==path=="+path);
		
		File f = PubFun.createFile(path);
		if (f.exists()) {
			flag = f.delete();
			if (!flag) {
				System.out.println("无法删除 " + fileName);
			} else {
				System.out.println("删除 " + fileName);
			}
		}
		return flag;
	}
	
	
	//add by Maqingyu
	public static boolean remove(String fileName, String sysvar, String funName) {
		boolean flag = false;
		String path = Config.getWorkPath(sysvar, funName);
		path = path + File.separator + fileName;
		
//		System.out.println("remove==path=="+path);
		
		File f = PubFun.createFile(path);
		if (f.exists()) {
			flag = f.delete();
			if (!flag) {
				System.out.println("无法删除 " + fileName);
			} else {
				System.out.println("删除 " + fileName);
			}
		}
		return flag;
	}
}
