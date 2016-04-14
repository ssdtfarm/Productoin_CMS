package com.sinosoft.exceltopdf;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfBuilder {
	private OutputStream os;
	private String OpType;
	private Document doc;
	private PdfWriter writer;
	private List<PdfPTable> tables = new ArrayList<PdfPTable>();
	private PdfPageSetting setting = new PdfPageSetting();;
	
	public PdfBuilder(OutputStream os, String OpType) {
		if(os == null){
			throw new RuntimeException("OutputStream os can not be blank!");
		}
		this.os = os;
		this.OpType = OpType;
	}
	
	public PdfBuilder buildDocument(){
		doc = new Document();
		try {
			writer = PdfWriter.getInstance(doc, os);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public PdfBuilder buildTable(SheetStruct sheet){
		int colNum = sheet.colNum()+1;
		float[] ratio = new float[colNum];
		for(int i = 0; i < ratio.length; i++){
			ratio[i]=1f/colNum;
		}
		ratio[colNum-1]=0.01f;
		PdfPTable table = new PdfPTable(ratio);
		int cellNum = colNum*sheet.rowNum();
		for(int i =0 ;i<cellNum;i++){
			PdfPCell pdfcell = null;
			if("Normal".equals(this.OpType)){
				pdfcell = new PdfPCell(ParaFactory.size8(" "));
			}else{
				pdfcell = new PdfPCell(ParaFactory.size8_B(" "));
			}
			pdfcell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(pdfcell);
		}
		Iterator<Row> rows = sheet.getSheet().rowIterator();
		while(rows.hasNext()){
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			// 2015-07-08日添加
			// 作用:用于截取保留小数为控制使用
			int tempNum = 0;
			while(cells.hasNext()){
				// 增加变量
				tempNum ++;
				Cell cell = cells.next();
				if(sheet.isBeMeger(cell)){
					table.getRow(cell.getRowIndex()).getCells()[cell.getColumnIndex()]=null;
					continue;
				}
				CellCoordinate index = new CellCoordinate(cell.getRowIndex(),cell.getColumnIndex());
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if(sheet.getMergeCell().containsKey(index)){
					CellRangeAddress cra = sheet.getMergeCell().get(index);
					int colSpan = cra.getLastColumn()-cra.getFirstColumn()+1;
					int rowSpan = cra.getLastRow()-cra.getFirstRow()+1;
					PdfPCell pdfcell = table.getRow(cra.getFirstRow()).getCells()[cra.getFirstColumn()];
					pdfcell.setColspan(colSpan);
					pdfcell.setRowspan(rowSpan);
					pdfcell.setBorder(PdfPCell.NO_BORDER);
				}
				String val = cell.getStringCellValue();
				// 新添加处理
				if(val != null && !"".equals(val)){
					if(tempNum > 2){
						// 处理货币形式的数据
						val = dealCoin(val);
					}
				}
				PdfPCell pdfcell = table.getRow(cell.getRowIndex()).getCells()[cell.getColumnIndex()];
				if("Normal".equals(this.OpType)){
					pdfcell.setPhrase(ParaFactory.size8(val));
				}else{
					pdfcell.setPhrase(ParaFactory.size8_B(val));
				}
				pdfcell.setBorder(PdfPCell.NO_BORDER);
				StyleSyncer.syncStyle(cell, pdfcell);
			}
		}
		for(PdfPRow row : table.getRows()){
			PdfPCell pdfcell = row.getCells()[table.getNumberOfColumns()-1];
			pdfcell.setBorder(PdfPCell.NO_BORDER);
		}
		table.setWidthPercentage(95);
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);    
		tables.add(table);
		return this;
	}
	
	public PdfBuilder buildPageSetting(float marginLeft, float marginRight, float marginTop, float marginBottom){
		setting.setMarginLeft(marginLeft);
		setting.setMarginRight(marginRight);
		setting.setMarginTop(marginTop);
		setting.setMarginBottom(marginBottom);
		return this;
	}
	
	public PdfBuilder buildPageSetting(Rectangle pageSize){
		setting.setPageSize(pageSize);
		return this;
	}
	
	public PdfBuilder build(){
		doc.setPageSize(setting.getPageSize());
		//将多出的一行多出的0.3毫米转化为像素
//		float left = (float) (0.3*72/2.54);
//		doc.setMargins(setting.getMarginLeft(), 
//				setting.getMarginRight()-left, 
//				setting.getMarginTop(), 
//				setting.getMarginBottom());
		try {
			this.setFooter(writer);
			writer.setFullCompression();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		doc.open();
		// Set pdf version to 1.4
		PdfContentByte cb = writer.getDirectContent();
		ColumnText ct=new ColumnText(cb);
		try {
			for(PdfPTable table:tables){
				doc.add(table);
				doc.newPage();
				//writer.setPageEmpty(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		doc.close();
		return this;
	}

	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public PdfWriter getWriter() {
		return writer;
	}

	public void setWriter(PdfWriter writer) {
		this.writer = writer;
	}

	public List<PdfPTable> getTables() {
		return tables;
	}

	public void setTables(List<PdfPTable> tables) {
		this.tables = tables;
	}

	public PdfPageSetting getSetting() {
		return setting;
	}

	public void setSetting(PdfPageSetting setting) {
		this.setting = setting;
	}
	// 20150627新添加
	private void setFooter(PdfWriter writer) throws Exception {
		PdfReportM1HeaderFooter headerFooter = new PdfReportM1HeaderFooter();
		writer.setBoxSize("art",PageSize.A4);
		writer.setPageEvent(headerFooter);
	}
	// 判断书否为数值
	public boolean isNum(String str){		
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");	
	}
	// 处理货币数值
	public String dealCoin(String strCoin){
		// 声明一个返回的字符串
		String strReturn = null;
		// 判断是否为空
		if(strCoin == null){
			return strReturn;
		}
		// 判断字符串货币是否含有小数位, 如果不含有则保留两位小数位
		if("0".equals(strCoin.trim()) || "0.0".equals(strCoin.trim()) || "0.00".equals(strCoin.trim())){
			// 如果为0,格式化为0.00
			strReturn = "0.00";
		}else{
			// 处理只保留以为小数的数
			if(isNum(strCoin.trim())){
				// 判断正负数的标志
				boolean flag = false;
				// 判断是正数还是负数
				if(strCoin.trim().startsWith("-")){
					// 把负数位替换掉
					strCoin = strCoin.trim().replaceAll("-", "");
					// 添加一个标志
					flag = true;
				}
				// 判断为数值的进行处理
				DecimalFormat df = new DecimalFormat("0.00");
				// 格式化为保留两位小数位
				strCoin = df.format(Double.parseDouble(strCoin.trim())) + "";
				// 转化为货币形式表示
				// 1.获取小数点的位置
				int decimalPoint = strCoin.lastIndexOf('.');
				// 小数点之前的字符数字
				String beforedecimalPoint = strCoin.substring(0, decimalPoint);
				// 获取长度
				int decimalLen = beforedecimalPoint.length();
				// 根据长度进行判断
				String strTemp = "";
				while(decimalLen > 3){
					// 截取倒数三位
					strTemp =  "," + beforedecimalPoint.substring(beforedecimalPoint.length() - 3) + strTemp;
					// 剩余的字符数值
					beforedecimalPoint = beforedecimalPoint.substring(0, beforedecimalPoint.length() - 3);
					// 剩余的长度
					decimalLen = decimalLen - 3;
				}
				// 对不够3位的长度进行处理, 并返回货币结果数值
				strReturn = beforedecimalPoint + strTemp + strCoin.substring(strCoin.lastIndexOf('.'));
				// 如果是负数
				if(flag){
					// 把负号添加上
					strReturn = "-" + strReturn;
				}
			}else{
				// 如果不是数值, 直接返回
				strReturn = strCoin;
			}
		}
		// 返回
		return strReturn;
	}
}
