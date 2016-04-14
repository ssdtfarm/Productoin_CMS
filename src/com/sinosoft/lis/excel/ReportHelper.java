package com.sinosoft.lis.excel;

import java.io.OutputStream;

/**
 * 
 * @version 1.0 2008-2-25
 * @author WangWei 
 * @author Evan
 *
 */
public class ReportHelper {
	private SimpleWorkbook workbook = null;

	private MultiWorkbook multiWorkbook = null;
	
	private ExcelInfo result = null;

	private String templetPath; // 模板

	// 秒钟之前(小于usefullLifeSec秒)生成的同名报表为有效报表,无须查数据库重新生成

//	private String rvFNStartWith; // 删除服务器上缓存的文件名以rvFNStartWith开头的报表
//
//	private long invalidationSec;

	/**
	 * 
	 * @param templetFileName 模板的名字
	 * @param reportFileName 要生成的报表的名字
	 * @param usefullLifeSec 有效时间（单位是秒
	 * @param rvFNStartWith 要删除的 报表名字的 前缀
	 * @param invalidationSec 要删除的报表的 生成时间 限制 
	 */
	public ReportHelper(String templetFileName, String reportFileName,
			long usefullLifeSec, String rvFNStartWith, long invalidationSec) {
		result = ExcelUtil.prepare(reportFileName, usefullLifeSec);
		result.excelName = reportFileName;
		templetPath = ExcelUtil.getTempletPath(templetFileName);
		// this.usefullLifeSec = usefullLifeSec;
//		this.rvFNStartWith = rvFNStartWith;
//		this.invalidationSec = invalidationSec;
		ExcelUtil.removeStartWithExcept(rvFNStartWith, result.excelPath,
				invalidationSec);

	}
	
	
	//add by maqingyu
	public ReportHelper(String templetFileName, String reportFileName,
			long usefullLifeSec, String rvFNStartWith, long invalidationSec, String sysvar, String funName) {
		result = ExcelUtil.prepare(reportFileName, usefullLifeSec, sysvar, funName);
		result.excelName = reportFileName;
		templetPath = ExcelUtil.getTempletPath(templetFileName);
		// this.usefullLifeSec = usefullLifeSec;
//		this.rvFNStartWith = rvFNStartWith;
//		this.invalidationSec = invalidationSec;
		if(sysvar.equals("OnwerExportFilePath"))
		{
			ExcelUtil.removeStartWithExcept(rvFNStartWith, result.excelPath, invalidationSec, sysvar, funName);
		}
		if(sysvar.equals("AutoExportFilePath"))
		{
			ExcelUtil.removeStartWithExcept_Auto(rvFNStartWith, result.excelPath, invalidationSec, sysvar, funName);
		}

	}

	/**
	 * 
	 * @param templetFileName 模板的名字
	 * @param reportFileName 要生成的报表的名字
	 * @param usefullLifeSec 有效时间（单位是秒）
	 * @param rvFNStartWith 要删除的 报表名字的 前缀
	 */
	public ReportHelper(String templetFileName, String reportFileName,
			long usefullLifeSec, String rvFNStartWith) {
		this(templetFileName, reportFileName, usefullLifeSec, rvFNStartWith,
				usefullLifeSec * 2);

	}

	public ExcelInfo getInfo() {
		return result;
	}

	public SimpleWorkbook createWorkbook() {
		try {
			workbook = new SimpleWorkbook(result.excelPath, templetPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}
	
	public MultiWorkbook getMultiWorkbook(){
		try {
			multiWorkbook = new MultiWorkbook(result.excelPath, templetPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return multiWorkbook;
	
	}
	
	public static boolean remove(String reportName) {
		return ExcelUtil.remove(reportName);
	}
	
	//add by Maqingyu
	public static boolean remove(String reportName, String sysvar, String funName) {
		return ExcelUtil.remove(reportName, sysvar, funName);
	}
	
	public static String getReportPath(String fileName) {
		return ExcelUtil.getExcelPath(fileName);
	}
	
	//add by maqingyu
	public static String getReportPath(String fileName, String sysvar, String funName) {
		return ExcelUtil.getExcelPath(fileName, sysvar, funName);
	}
	
	
	/**
	 * 将指定的文件写到指定的输出流中
	 * 
	 * @param out
	 * @param filePath
	 */
	public static void download(OutputStream out, String filePath) {
		DownloadUtil.writeTo(out, filePath);
	}
}
