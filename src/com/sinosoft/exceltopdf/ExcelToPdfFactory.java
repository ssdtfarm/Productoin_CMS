package com.sinosoft.exceltopdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.itextpdf.text.PageSize;

public class ExcelToPdfFactory implements ConvertFactory{
	
	public static void execute(String srcPath, OutputStream os, String OpType){
		new ExcelToPdfFactory().convert(srcPath, os, OpType);
	}
	
	@Override
	public void convert(String srcPath, OutputStream os, String OpType) {
		File file = new File(srcPath);
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			Workbook wb = createdWorkBook(is);
			WorkBookStruct wbStruct = new WorkBookStruct(wb);
			PdfBuilder builder = new PdfBuilder(os, OpType);
			builder.buildDocument().buildPageSetting(10, 10, 10, 10).buildPageSetting(PageSize.A4);
			for(Sheet sheet : wbStruct.getSheets()){
				SheetStruct sheetStruct = new SheetStruct(sheet);
				builder.buildTable(sheetStruct);
			}
			builder.build();
			if(is != null){
				is.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Workbook createdWorkBook(InputStream is){
		Workbook wb;
		try {
			wb = WorkbookFactory.create(is);
			return wb;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
