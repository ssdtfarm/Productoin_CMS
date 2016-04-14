package com.sinosoft.Resource;

import com.sinosoft.Resource.bundle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import sun.io.CharToByteConverter;


public class ResourceInput {
		
	/** 导入的文件地址以及文件名 */
	private String mPathAndFileName = System.getProperty("user.dir")+"\\input\\"+bundle.getString("waitForTran")+".xls";
	private String mPath = System.getProperty("user.dir")+"\\src\\com\\sinosoft\\Resource\\";
	private String mPathAndFileName_en = mPath+ "LocalStrings_EN.properties";
	private String mPathAndFileName_cn = mPath+ "LocalStrings_zh_CN.properties";
	private String mPathAndFileName_zh = mPath+ "LocalStrings_zh_TW.properties";
	
	//导入excel 转化为/中、英、繁体
	
	public boolean inputResource(){

		HSSFWorkbook workbook = null;
		try
		{
			workbook = new HSSFWorkbook(new FileInputStream(mPathAndFileName));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		int sheetNo = 0;
		HSSFSheet sheet = workbook.getSheetAt(sheetNo); // 取第N个sheet
		if (sheetNo == 0)//只取第一个sheet
		{
			int rownum = sheet.getLastRowNum();
			for (int rowid = 0; rowid <= rownum; rowid++) {
				HSSFRow row = sheet.getRow(rowid);
				if(row!=null&&rowid==0){
						String option = getCellValue(row.getCell((short)0));
						String option_en = getCellValue(row.getCell((short)1));
						String option_cn = getCellValue(row.getCell((short)2));
						String option_zh = getCellValue(row.getCell((short)3));
						if(isEmpty(option)||isEmpty(option_en)||isEmpty(option_en)||isEmpty(option_zh)){
							System.out.println("导入文件模板错误或导入类型错误！");
							return false;
						}
				}
				if (row != null && rowid > 0) {//Excel第一行为标题不取，从第二行开始取数
					
					insertValue(row);//导入数据
					
				}
			}
		}
	
		return true;
	}
	private void insertValue(HSSFRow row){
			String option=getCellValue(row.getCell((short) 0)).trim();
			String option_en=getCellValue(row.getCell((short) 1)).trim();
			String option_cn=getCellValue(row.getCell((short) 2)).trim();
			String option_zh=getCellValue(row.getCell((short) 3)).trim();
			
			PropertiesManage Pm = new PropertiesManage();
			Pm.readValue(mPathAndFileName_en, option_en);   
			Pm.writeProperties(mPathAndFileName_en,option,option_en);  
			Pm.writeProperties(mPathAndFileName_cn,option,option_cn); 
			Pm.writeProperties(mPathAndFileName_zh,option,option_zh); 
	        System.out.println("操作完成");  
	}
	

	
	private String getCellValue(HSSFCell cell)
	{
		String strCell = "";
		if (null != cell)
		{
			int cellType = cell.getCellType();
			switch (cellType)
			{
			case HSSFCell.CELL_TYPE_NUMERIC:
				strCell = String.valueOf((int) cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_STRING:
				strCell = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_FORMULA:
				strCell = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				strCell = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				strCell = cell.getStringCellValue();
				break;
			default:
				strCell = cell.getStringCellValue();
			}
		}
		else
		{
			strCell = "";
		}
		return strCell;
	}
	/** 
	 *   判断是否为空串 " " 
	 */
	public static boolean isEmpty(String sValue)
	{
		if (sValue == null)
			return true;
		return sValue.trim().equals("") ? true : false;
	}
	
//	public static void main(String[] args)
//	{
//		ResourceInput ri = new ResourceInput();
//		ri.inputResource();
//		
//
//	}
}
