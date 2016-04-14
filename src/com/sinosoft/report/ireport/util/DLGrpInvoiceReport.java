package com.sinosoft.report.ireport.util;

import com.sinosoft.Resource.bundle;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import javax.servlet.http.HttpServletResponse;
import com.sinosoft.report.ireport.dto.SfaSearchResultDTO;
import com.sinosoft.report.ireport.util.JasperReportUtil;
import com.sinosoft.report.ireport.util.ReportDataSource;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.lis.pubfun.PubFun;

/**
 * @author xujun
 * @category发票打印入口类
 */
public class DLGrpInvoiceReport {

//    public static void main(String[] args)
//    {
//    	DLGrpInvoiceReport invoiceReport = new DLGrpInvoiceReport();
//		byte[] reportContent = invoiceReport.generateReport("PDF","","D:\\yang-guang\\ui\\ireport\\","DLFP8688_1_Invoice.jasper","D:\\yang-guang\\ui\\invoice\\","86010000000000001888.pdf","D:\\yang-guang\\ui\\invoice\\INVOICE8601_86010000000000001888.xml","D:\\yang-guang\\ui\\invoice\\");		
//		
//    }

    private String mTemplateName;
    
	public DLGrpInvoiceReport() {
		
	}
	
	/**
	 * 调试标志
	 */
	private boolean DEBUG=true;
	/**
	 * 产生单张报表内容PDF/EXCEL文件流的列表
	 * 
	 * @param contentType
	 * @param limit
	 * @param templatePath
	 * @param templateName
	 * @param invoicePath
	 * @param invoiceName
	 * @param dataFileName
	 * @author xujun
	 * @return
	 */
	public byte[] generateReport(String contentType, String limit,
			String templatePath, String templateName, String invoicePath,
			String invoiceName, String dataFileName,String invoicePic) {
		
		mTemplateName = templateName;
		
		if(DEBUG)
		{
			System.out.println(contentType);
			System.out.println(limit);
			System.out.println(templatePath);
			System.out.println(templateName);
			System.out.println(invoicePath);
			System.out.println(invoiceName);
			System.out.println(dataFileName);
			System.out.println(invoicePic);
		}
		
		
		
		byte[] reportContent = null;// 发票导出文件流
		String reportName = templatePath + templateName;
		// String filePath = "D:/workspace/ReportTest/";

		try {
			// 从XML读取数据
			List list = this.getListFromXML(dataFileName);

			// 模拟数据
			// 构造后台数据
			SfaSearchResultDTO reportDto = new SfaSearchResultDTO();
			if(invoicePic != null  && !invoicePic.equals(""))
			{
//			System.out.println(this.getClass().getResourceAsStream("logo.bmp"));
//			InputStream is = this.getClass().getResourceAsStream("logo.bmp");
			
//			reportDto.setImagePath(invoicePic+"aeonlife.jpg");
			}
			// reportDto.setFilePath(filePath);

			// 构造数据源
			if(DEBUG)
			{
				System.out.println("Begin 构造数据源");
			}
			ReportDataSource dataSource = new ReportDataSource();
			dataSource.setParamObject(reportDto);
			dataSource.setDetailItems(list);

			// 生成数据流
			if ("PDF".equals(contentType)) {

				
				// 生成PDF
				reportContent = JasperReportUtil.runReportToPdf(reportName,
						dataSource);
				if(false)
				{
				// 生成PDF文件
					
//					System.out.println(reportContent.length);
//					System.out.println(invoicePath+invoiceName);
//					System.out.println(invoicePic+"aeonlife.jpg");
					
				JasperReportUtil.createReportFile(reportContent, invoicePath,
						invoiceName);
//				printPdf();
				}
			}

			if ("EXCEL".equals(contentType)) {
				// 生成EXCEL
				reportContent = JasperReportUtil.runReportToExcel(reportName,
						dataSource);
				// 生成EXCEL文件
				JasperReportUtil.createReportFile(reportContent, invoicePath,
						invoiceName);
			}

		} catch (Exception exp) {
			System.out.print(exp);
		}
		return reportContent;
	}

	/**
	 * 从XML文件读入数据
	 * 
	 * @param dataFileName
	 * @author xujun
	 * @return
	 */
	private List getListFromXML(String dataFileName) {
		List dataList = new ArrayList();
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(dataFileName);// 读取XML文件
			Element root = document.getRootElement();// 得到根节点
			for (Iterator i = root.elementIterator("DATASET"); i.hasNext();) {
				Element invoice = (Element) i.next();// 一张发票
				String appntName=invoice.element("appntName").getText();//
				String otherNo = invoice.element("otherNo").getText();// 保单合同号
	//			String AgentCode = invoice.element("AgentCode").getText();// 代理人代码
	//			String AgentName = invoice.element("AgentName").getText();// 代理人名称
				//String AgentGroup = invoice.element("AgentGroup").getText();// 
				//String AppntName = invoice.element("AppntName").getText();// 投保人姓名
				String operDate = invoice.element("operDate").getText();// 交费日期？？
//				String SignDate = invoice.element("SignDate").getText();// 
				//String Agenttag = invoice.element("Agenttag").getText();// 交费日期？？
				//String AgentGroupTag = invoice.element("AgentGroupTag").getText();// 				
//				String ComZipCode = invoice.element("ComZipCode").getText();// 
//				String ComAddress = invoice.element("ComAddress").getText();// 
				String printDate = invoice.element("printDate").getText();// 打印日期
  //   			String Operator = invoice.element("Operator").getText();// 操作人员
//				String OtherNo = invoice.element("OtherNo").getText();// 
//				String Drawer = invoice.element("Drawer").getText();// 
//				String ManageCom = invoice.element("ManageCom").getText();// 
//				String Type = invoice.element("Type").getText();// 
//				String YewName = invoice.element("YewName").getText();// 
//				String ZipCode = invoice.element("ZipCode").getText();// 
//				String Address = invoice.element("Address").getText();// 
//				String ComPhone = invoice.element("ComPhone").getText();// 
				String premLow = invoice.element("premLow").getText();// 保费小写
				String premCap = invoice.element("premCap").getText();// 保费大写
				String othernoName = invoice.element("othernoName").getText();// 其他号码类型			
//				String InsueName = invoice.element("InsueName").getText();// 被保人
//				String YWName = invoice.element("YWName").getText();// 保险费项目
//				String SJND = invoice.element("SJND").getText();// 
//				String JDQJ = invoice.element("JDQJ").getText();// 
//				String JDQZQ = invoice.element("JDQZQ").getText();// 
//				String Year = invoice.element("Year").getText();// 
//				String Month = invoice.element("Month").getText();// 
//				String Day = invoice.element("Day").getText();// 
//				String RiskName = invoice.element("RiskName").getText();// 
//				String PayMethod = invoice.element("PayMethod").getText();// 
//				String PayType = invoice.element("PayType").getText();// 
				
				String othernoType = invoice.element("othernoType").getText();
				String Checker = invoice.element("Checker").getText();//   -----modify by baidq-----2010-10-20
				


						// 构造报表数据
						// 设置发票信息
						System.out.println("contno"+otherNo);
						SfaSearchResultDTO reportInvoiceDto = new SfaSearchResultDTO();
						//reportInvoiceDto.setGroupno("221010732121");// 发票代码
						//reportInvoiceDto.setAgentName(AgentName);// 代理人姓名
						reportInvoiceDto.setAppntName(appntName);//投保人姓名					
						//reportInvoiceDto.setFamilyCount("00002452");// 发票号码
						reportInvoiceDto.setOtherNo(otherNo);// 保险合同号
						reportInvoiceDto.setPremCap(premCap);// 保险费金额（大写）
						reportInvoiceDto.setPremLow(premLow);// 保险费金额（小写）
						reportInvoiceDto.setOperDate(operDate);// 交费日期
						//reportInvoiceDto.setAgentName(AgentName);//代理人		
						//reportInvoiceDto.setAgentGroup(AgentGroup);
						//reportInvoiceDto.setAgentTag(AgentGroupTag);//代理人标签
						reportInvoiceDto.setOthernoName(othernoName);//其他号码
						//reportInvoiceDto.setSearchMonth("95555");
						//reportInvoiceDto.setAgentGroupTag(Agenttag);//代理人单位标签
						reportInvoiceDto.setPrintDate(printDate);//打印日期
		
						// 设置险种信息
						//reportInvoiceDto.setRiskCode(COL1);
						//reportInvoiceDto.setInsuredName(COL2);
						//reportInvoiceDto.setPrem(COL3);
						String tDate=PubFun.getCurrentDate();
						reportInvoiceDto.setPrintYear(tDate.substring(0,4));
						reportInvoiceDto.setPrintMonth(tDate.substring(5,7));
						reportInvoiceDto.setPrintDay(tDate.substring(8,10));	
						reportInvoiceDto.setChecker(Checker);//   -----modify by baidq-----2010-10-20
						if(mTemplateName.equals("FP8613_1_Invoice.jasper"))
						{
							String Operator = invoice.element("Operator").getText();// 
							reportInvoiceDto.setContNo(otherNo);
							reportInvoiceDto.setOperator(Operator);
							reportInvoiceDto.setPremLow("￥"+premLow);// 保险费金额（小写）
							
							if(othernoType.equals("10"))
							{
								String edorNo = invoice.element("edorNo").getText();
								reportInvoiceDto.setEdorNo(edorNo);
							}
							
						}					
						String Operator = invoice.element("Operator").getText();// 
						reportInvoiceDto.setOperator(Operator);

                          /**河南旧版发票-----2010-08-27-----*/
						if(mTemplateName.equals("YFP8641_1_Invoice1.jasper"))
						{
							reportInvoiceDto.setPremLow("￥"+premLow);// 保险费金额（小写）
							
							reportInvoiceDto.setPrintYear(operDate.substring(0, 4));//交费年
							reportInvoiceDto.setPrintMonth(operDate.substring(5, 7));//交费月
							reportInvoiceDto.setPrintDay(operDate.substring(8, 10));//交费日
							
							//新契约
							if(othernoType.equals("4"))
							{
								/**机打票号*/
								String prtseq="";
								String sql1=" select prtseq from  loprtmanager  where code='NBIV' and otherno='"+otherNo+"'";
								ExeSQL texesql1 = new ExeSQL();
						        SSRS tssrs1 = texesql1.execSQL(sql1);
								prtseq=tssrs1.GetText(1, 1);
								reportInvoiceDto.setPrtseq(prtseq);
								System.out.println("机打票号:"+prtseq);
								
								
								
								/**交费方式*/
								String payintv="";
								String codename="";
								String sql2=" select a.payintv ,b.codename from lcgrppol a,ldcode b, lmriskapp c where a.riskcode=c.riskcode and c.subriskflag='M' and b.code =a.payintv and b.codetype = 'payintv' and a.grpcontno='"+otherNo+"'";
								ExeSQL texesql2 = new ExeSQL();
						        SSRS tssrs2 = texesql2.execSQL(sql2);
						        payintv=tssrs2.GetText(1, 1);
						        codename=tssrs2.GetText(1, 2);
								reportInvoiceDto.setPayintv(codename);
								System.out.println("交费方式，编码:"+payintv);
								System.out.println("交费方式，名称:"+codename);
								
								 /**交费起止日期*/
								String cvalidate="";//险种生效日期
								String paytodate="";//交至日期
								String sql4=" select a.cvalidate,a.paytodate from lcgrppol a,lmriskapp b where  a.riskcode=b.riskcode and b.subriskflag='M' and a.grpcontno='"+otherNo+"'";
								ExeSQL texesql4 = new ExeSQL();
						        SSRS tssrs4 = texesql4.execSQL(sql4);
						        cvalidate=tssrs4.GetText(1, 1);
						        paytodate=tssrs4.GetText(1, 2);
						        System.out.println("交费起止日期:"+cvalidate+"与"+paytodate);
						        
								if(payintv.equals("-1"))
								{
								//	reportInvoiceDto.setPayYears("");	
									reportInvoiceDto.setCvalidate("");
									reportInvoiceDto.setStr("");
									reportInvoiceDto.setPaytodate("");
								}
								else{
									
								//	reportInvoiceDto.setPayYears(payyears);
									reportInvoiceDto.setCvalidate(cvalidate);
								//	reportInvoiceDto.setStr("到");
								//	reportInvoiceDto.setPaytodate(paytodate);
								}
								/**收费形式，收款员*/
								String paymode="";
								String operator="";
								String sql5="select distinct a.operator,a.paymode from ljtempfeeclass  a,lcgrpcont b where a.otherno=b.prtno and b.grpcontno='"+otherNo+"'";
								ExeSQL texesql5 = new ExeSQL();
						        SSRS tssrs5 = texesql5.execSQL(sql5);
						        operator=tssrs5.GetText(1, 1);
						        paymode=tssrs5.GetText(1, 2);
						        System.out.println("收费形式:"+paymode);
						        System.out.println("收款员:"+operator);
						        
						        if(paymode.equals("1"))
						        {
						        	reportInvoiceDto.setPaymode(""+bundle.getString("waitForTran")+"");
						        	reportInvoiceDto.setOperator(operator);
						        }
						        else if(paymode.equals("2"))
						        {
						        	reportInvoiceDto.setPaymode(""+bundle.getString("waitForTran")+"");
						        	reportInvoiceDto.setOperator(operator);
						        }
						        else if(paymode.equals("3"))
						        {
						        	reportInvoiceDto.setPaymode(""+bundle.getString("waitForTran")+"");
						        	reportInvoiceDto.setOperator(operator);
						        }
						        else if (paymode.equals("7"))
						        {
						        	reportInvoiceDto.setPaymode(""+bundle.getString("waitForTran")+"");
						        	reportInvoiceDto.setOperator(""+bundle.getString("waitForTran")+"");
						        }
						        else if (paymode.equals("A"))
						        {
						        	reportInvoiceDto.setPaymode(""+bundle.getString("waitForTran")+"");
						        	reportInvoiceDto.setOperator(operator);
						        }
						        else{
						        	reportInvoiceDto.setPaymode(""+bundle.getString("waitForTran")+"");
						        	reportInvoiceDto.setOperator(operator);
						        }
						
							}
							
						}

						dataList.add(reportInvoiceDto);
						if(DEBUG)
						{
							System.out.println("ENDGetXML");
						}
					}

			

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
	public void createReportFile(HttpServletResponse resp,
			byte[] reportContent,String mTemplate) throws Exception {
		JasperReportUtil reportUtil = new JasperReportUtil();
		// 生成报表文件
		reportUtil.createPDFReportFileToResponse(resp, reportContent,mTemplate);
	}
	
	private void printPdf()
	{
	       try{
	           String pdfPath = "D:/testPDF/1.pdf";
//	            Runtime.getRuntime().exec("cmd.exe /C start acrord32 /P /h " + pdfPath);
	            System.out.print("成功");
	        }catch(Exception e){   
	            e.printStackTrace(); 
	        }

	}
}
