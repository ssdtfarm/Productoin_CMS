package com.sinosoft.lis.excel;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * 
 * @version 1.0 2008-2-22
 * @author Wang Wei
 * @author Evan
 * 
 */
public class ExcelInfo {
	// private static final Log logger = LogFactory.getLog("Result");
	// public String templetPath = null;
	String excelPath = null;

	boolean excelExists = false;

	long modifyTime = 0;

	String excelName = null;

	ExcelInfo() {
		// logger.info("new Result()");
	}

	public String getReportName() {
		return excelName;
	}

	public String getReportPath() {
		return excelPath;
	}

	public boolean exists() {
		return excelExists;
	}

	public long getModifyTime() {
		return modifyTime;
	}

}
