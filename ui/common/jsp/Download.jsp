<%@include file="../jsp/UsrCheck.jsp"%>
<%@page contentType="application/vnd.ms-excel;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.excel.*"%>
<%@page import="java.io.*"%>
<%
	try {
		//System.out.println("开始下载文件...");
		String op = request.getParameter("operation");
		System.out.println("operation " + op);
		
		//得到要下载的文件
		String serverFileName = request.getParameter("serverFileName");
		String funName = request.getParameter("funName");
		String sysvar = request.getParameter("sysvar");
		
		System.out.println("sysvar:::::" + sysvar);
		//old code
		//ReportHelper.remove(serverFileName);
		
		//add by Maqingyu
		if (op.equals("remove"))
		{
			if(funName == null || funName.equals("")){
				ReportHelper.remove(serverFileName);
			}else{
				ReportHelper.remove(serverFileName, sysvar, funName);
			}
		}
		else
		{
		System.out.println("正在下载文件" + serverFileName + "...");
		//System.out.println("serverFileName:" + serverFileName);
		//得到文件下载后的名字
		String fileName = request.getParameter("fileName");	
		//下面的代码一般不用修改
		//old code
		//String filePath = ReportHelper.getReportPath(serverFileName);
		
		//add by Maqingyu
		String filePath = "";
		if(funName == null || funName.equals("")){
			filePath = ReportHelper.getReportPath(serverFileName);
		}else{
			filePath = ReportHelper.getReportPath(serverFileName, sysvar, funName);
		}
		System.out.println("filePath:::::" + filePath);
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");   
		out.clear();
		out = pageContext.pushBody();
		ReportHelper.download(response.getOutputStream(), filePath);
		System.out.println("下载结束");
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
<html>
</html>
