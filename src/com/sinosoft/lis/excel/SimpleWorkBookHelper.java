package com.sinosoft.lis.excel;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.ListTable;
import com.sinosoft.utility.SSRS;

/**
 * 简单Excel报表生成工具
 * 根据二维数组（或SQL）、报表模板、变量HaspMap，生成报表，并返回生成的文件地址
 * @author lanruijin
 */
public class SimpleWorkBookHelper {
	
	public static String[][] getResultArray(String sql) {
		String[][] data = null;
		SSRS rs = new ExeSQL().execSQL(sql);
		if (rs == null || rs.getMaxRow() == 0)
			return null;
		data = rs.getAllData();
		return data;
	}

	// 通过sql、模板文件、变量key-value集合，生成Excel报表
	public static String makeXlsReport(String sql, String template,
			Map<String, String> varMap) {
		return makeXlsReport(getResultArray(sql), template, varMap);
	}

	// 通过二维数组、模板文件、变量key-value集合，生成Excel报表。
	// 每次都重新生成报表文件，生成的文件以模板名开头，后面加上随机数字。
	public static String makeXlsReport(String[][] data,
			String templateFileName, Map<String, String> varMap) {
		if(data==null){
			return "False";
		}
		String filePath = null;
		boolean flag = true;
		long usefullLifeSec = 60 * 0; // usefullLifeSec
		// 秒钟之前(小于usefullLifeSec秒)生成的同名报表为有效报表,无须查数据库重新生成
		String nameWithoutExt = templateFileName.substring(0,
				templateFileName.lastIndexOf("."));
		String tmpFileName = nameWithoutExt + "_"
				+ PubFun.getCurrentDate() + "_"
				+ System.currentTimeMillis() + ".xls";

		// 推荐设置
		String rvFNStartWith = nameWithoutExt; // 删除服务器上缓存的文件名以rvFNStartWith开头的报表
		long invalidationSec = 60 * 60 * 10; // 删除报表时(10 hours),
		// invalidationSec秒钟之内生成的报表不能删,该参数值必须比usefullLifeSec参数值大

		// -----------------------------------------------------------------
		ReportHelper helper = new ReportHelper(templateFileName, tmpFileName,
				usefullLifeSec, rvFNStartWith, invalidationSec);
		ExcelInfo info = helper.getInfo();

		if (!info.exists()) {
			SimpleWorkbook workbook = helper.createWorkbook();
			try {
				if (varMap != null && varMap.size() > 0) {
					Set<String> set = varMap.keySet();
					Iterator<String> it = set.iterator();
					while (it.hasNext()) {
						String key = it.next();
						workbook.set(key, varMap.get(key));
					}
				}
				if (data != null)
					workbook.add(data);
				else {
					workbook.write();
					workbook.close();
				}
				workbook = null;
			} catch (Exception e) {
				flag = false;
			} finally {
				if (workbook != null) {
					try {
						workbook.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		if (flag) {
			ExcelInfo info2 = helper.getInfo();
			String Excelpath = info2.getReportPath();
			filePath = Excelpath;
		}
		return filePath;
	}

	// 通过SSRS、模板文件、变量key-value集合，生成Excel报表。
	// 每次都重新生成报表文件，生成的文件以模板名开头，后面加上随机数字。
	public static String makeXlsReport(SSRS data, String templateFileName,
			Map<String, String> varMap) {
		if (data == null || data.getMaxRow() == 0) {
			return null;
		}
		return makeXlsReport(data.getAllData(), templateFileName, varMap);
	}

	// 通过ListTable、模板文件、变量key-value集合，生成Excel报表。
	// 每次都重新生成报表文件，生成的文件以模板名开头，后面加上随机数字。
	public static String makeXlsReport(ListTable data, String templateFileName,
			Map<String, String> varMap) {
		if (data == null || data.size() == 0) {
			return null;
		}
		String[][] dataStr = new String[data.size()][];
		for (int i = 0; i < dataStr.length; i++) {
			dataStr[i] = data.get(i);
		}
		return makeXlsReport(dataStr, templateFileName, varMap);
	}

	// 通过sql和模板文件，生成Excel报表
	public static String makeXlsReport(String sql, String template) {
		return makeXlsReport(getResultArray(sql), template, null);
	}

	// 通过二维数组、模板文件、变量key-value集合，生成Excel报表。
	public static String makeXlsReport(String[][] data, String template) {
		return makeXlsReport(data, template, null);
	}

}
