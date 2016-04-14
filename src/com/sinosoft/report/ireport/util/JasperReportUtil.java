package com.sinosoft.report.ireport.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lowagie.text.Rectangle;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import javax.servlet.ServletOutputStream;
import org.apache.commons.beanutils.PropertyUtils;
import com.sinosoft.utility.*;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfObject;

/**
 * <p>
 * Description: JasperReports 工具类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002 - 2006 unihub.net. All Right Reserved
 * </p>
 * Created by Unihub GZ ODC Midified by ....
 */

public class JasperReportUtil {

	static {
		System.setProperty("java.awt.headless", "true");
	}
	
//	public static void main(String[] arg1){
//		System.out.println();
//	}

	/**
	 * 生成pdf
	 * 
	 * @param jasperFilePath
	 *            jasper文件所在的路径和文件名
	 * @param reportDataSource
	 *            数据源
	 * @return
	 * @throws Exception
	 */
	public static byte[] runReportToPdf(String jasperFilePath,
			IReportDataSource reportDataSource) throws Exception {
		Map parameters = null;
		if (reportDataSource != null) {
			Object paramObject = reportDataSource.getParamObject();
			parameters = paramObject != null ? PropertyUtils
					.describe(paramObject) : new HashMap();
		}

		byte[] reportBytes = null;

		try {
			if (reportDataSource != null
					&& reportDataSource.getDetailItems() != null)
				reportBytes = JasperRunManager.runReportToPdf(jasperFilePath,
						parameters, reportDataSource);
			else
				reportBytes = JasperRunManager.runReportToPdf(jasperFilePath,
						parameters, new JREmptyDataSource());
		} catch (Exception exp) {
			throw exp;
		}

		return reportBytes;
	}

	/**
	 * 生成excel
	 * 
	 * @param jasperFilePath
	 *            jasper文件所在的路径和文件名
	 * @param reportDataSource
	 *            数据源
	 * @return
	 * @throws Exception
	 */
	public static byte[] runReportToExcel(String jasperFilePath,
			IReportDataSource reportDataSource) throws Exception {
		Map parameters = null;
		List list = null;
		if (reportDataSource != null) {
			Object paramObject = reportDataSource.getParamObject();
			parameters = paramObject != null ? PropertyUtils
					.describe(paramObject) : new HashMap();
			list = reportDataSource.getDetailItems();
		}

		byte[] reportBytes = null;

		try {
			// 读取jasper
			JasperReport jr = (JasperReport) JRLoader
					.loadObjectFromLocation(jasperFilePath);

			// fill，目前模版字段说明不支持中文！！！
			JasperPrint jasperPrint = JasperFillManager.fillReport(jr,
					parameters, new JRBeanCollectionDataSource(list));

			// excel输出
			ByteArrayOutputStream oStream = new ByteArrayOutputStream();
			
			JRXlsExporter exporter = new JRXlsExporter();

			exporter
					.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, oStream);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE); // 删除记录最下面的空行
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.TRUE);// 显示白色背景
			//modify by lijin 20090530
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);// 每个页一个SHEET
			exporter.setParameter(
					JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE,
					Boolean.FALSE);//
  
			exporter.exportReport();
			
			reportBytes = oStream.toByteArray();
		} catch (Exception exp) {
			throw exp;
		}

		return reportBytes;
	}

	/**
	 * 单个输出，生成PDF/EXCEL文件,保存在设置好的文件下
	 * 
	 * @param content
	 * @param filePath
	 * @param sourcePdfFullPath
	 * @throws Exception
	 */
	public static void createReportFile(byte[] content, String filePath,
			String sourcePdfFullPath) throws Exception {
		File dir = new File(filePath);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		FileOutputStream out = new FileOutputStream(filePath
				+ sourcePdfFullPath);
		out.write(content);
		out.flush();
		out.close();

	}

	/**
	 * 单个输出，生成PDF文件,保存在设置好的目录下，并返回客户端
	 * 
	 * @param resp
	 *            输出
	 * @param content
	 *            输出文件流
	 * @param contentType
	 *            文件类型：PDF/EXCEL
	 * @param printType
	 *            打印方式
	 * @param limit
	 *            权限标识
	 * @throws Exception
	 */
	public void createPDFReportFileToResponse(HttpServletResponse resp,
			byte[] content) throws Exception {
		// 输出文档
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// Rectangle rect = new Rectangle(595, 842);// A4
		Rectangle rect = new Rectangle(642, 425);// 自定义发票
		Document document = new Document(rect);
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		// writer.setViewerPreferences(PdfWriter.HideMenubar
		// | PdfWriter.HideToolbar);
		// writer.setViewerPreferences(PdfWriter.HideWindowUI);
		document.open();
		writer.addJavaScript("this.print(true);", false);
		PdfReader reader1 = new PdfReader(content);
		int n1 = reader1.getNumberOfPages();
		if (n1 > 0) {
		for (int i = 0; i < n1; i++) {
				document.newPage();
				PdfImportedPage page = writer.getImportedPage(reader1, i + 1);
				PdfContentByte cb = writer.getDirectContent();
				cb.addTemplate(page, 0, 0);
			}
		}
		document.close();

		// 打印方式－直接预览/发送到打印机
		// if (printType.equals("1") || printType.equals("3")) {
		 resp.setHeader("Content-Disposition", "inline;filename=report.pdf");
		// }
		// 打印方式－附件
		// if (printType.equals("2")) {
//		 resp.setHeader("Content-Disposition",
//		 "attachment;filename=report.pdf");
		// }
		System.out.println("11111111111111111111111111111");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++"+baos.size());
		resp.setContentType("application/pdf");
		resp.setContentLength(baos.size());
		ServletOutputStream out = resp.getOutputStream();
		baos.writeTo(out);
		out.flush();

		// 输出到IE
		//
		// response.setContentLength(length);
		// response.getOutputStream().write(reportContent, 0, length);
		// response.flushBuffer();
		// }

		// 服务器端静默打印
		// try{
		// String pdfPath = "D:/workspace/aeonlife/lis/ui/student/report.pdf";
		// Runtime.getRuntime().exec("cmd.exe /C start acrord32 /P /h " +
		// pdfPath);
		// }catch(Exception e){
		// e.printStackTrace();
		// }
	}
	
	public void createPDFReportFileToResponse(HttpServletResponse resp,
			byte[] content,String pTemplateName) throws Exception {
		// 输出文档
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		String subTemplateName = pTemplateName.replace(".jasper", "");
		

		// Rectangle rect = new Rectangle(595, 842);// A4
		Rectangle rect;
		
		//默认以大连发票模板大小
		int tWidth = 642;
		
		int tHeight = 425;
		
		
		//对于与大连发票不同扫票查询ldsysvar
		ExeSQL tExeSQL=new ExeSQL();
		
		StringBuffer tWidthBuffer = new StringBuffer();
		
		tWidthBuffer.append("select sysvarvalue from ldsysvar where sysvar = '");
		tWidthBuffer.append(subTemplateName).append(",w'");
		
		String strWidth = tExeSQL.getOneValue(tWidthBuffer.toString());
		
		StringBuffer tHeightBuffer = new StringBuffer();
		tHeightBuffer.append("select sysvarvalue from ldsysvar where sysvar = '");
		tHeightBuffer.append(subTemplateName).append(",h'");
		
		String strHeight = tExeSQL.getOneValue(tHeightBuffer.toString());
	
		
		//当能查询到值的时候
		if(!strWidth.equals("") && !strHeight.equals(""))
		{
			tWidth = Integer.parseInt(strWidth);
			
			tHeight = Integer.parseInt(strHeight);		
			
			
		}	
			
		System.out.println("发票模板大小为："+tWidth+"*"+tHeight);
		
		
		rect= new Rectangle(tWidth,tHeight);
		
//		if("invoice.jasper".equals(pTemplateName))
//		{
//			rect= new Rectangle(642, 425);// 自定义发票
//		}
//		else
//		{
//			rect= new Rectangle(595, 842);// A4 湖北
//		}
		Document document = new Document(rect);
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		// writer.setViewerPreferences(PdfWriter.HideMenubar
		// | PdfWriter.HideToolbar);
		// writer.setViewerPreferences(PdfWriter.HideWindowUI);
		document.open();
		writer.addJavaScript("this.print(true);", false);
		PdfReader reader1 = new PdfReader(content);
		int n1 = reader1.getNumberOfPages();
		if (n1 > 0) {
		for (int i = 0; i < n1; i++) {
				document.newPage();
				PdfImportedPage page = writer.getImportedPage(reader1, i + 1);
				PdfContentByte cb = writer.getDirectContent();
				cb.addTemplate(page, 0, 0);
			}
		}
		document.close();

		// 打印方式－直接预览/发送到打印机
		// if (printType.equals("1") || printType.equals("3")) {
		 resp.setHeader("Content-Disposition", "inline;filename=report.pdf");
		// }
		// 打印方式－附件
		// if (printType.equals("2")) {
//		 resp.setHeader("Content-Disposition",
//		 "attachment;filename=report.pdf");
		// }
		System.out.println("11111111111111111111111111111");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++"+baos.size());
		resp.setContentType("application/pdf");
		resp.setContentLength(baos.size());
		ServletOutputStream out = resp.getOutputStream();
		baos.writeTo(out);
		out.flush();

		// 输出到IE
		//
		// response.setContentLength(length);
		// response.getOutputStream().write(reportContent, 0, length);
		// response.flushBuffer();
		// }

		// 服务器端静默打印
		// try{
		// String pdfPath = "D:/workspace/aeonlife/lis/ui/student/report.pdf";
		// Runtime.getRuntime().exec("cmd.exe /C start acrord32 /P /h " +
		// pdfPath);
		// }catch(Exception e){
		// e.printStackTrace();
		// }
	}

}
