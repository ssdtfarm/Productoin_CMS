<%@include file="/i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="com.jspsmart.upload.*"%>
<%@page import="java.io.*"%>
<%
	SmartUpload su = new SmartUpload();
	su.initialize(pageContext);
	su.setContentDisposition(null);
	out.clear();
	out = pageContext.pushBody();
	System.out.println("filePath---"+request.getParameter("filePath"));
	su.downloadFile(request.getParameter("filePath"));
	java.io.File tFile=new java.io.File(request.getParameter("filePath"));
%>
<html>
</html>