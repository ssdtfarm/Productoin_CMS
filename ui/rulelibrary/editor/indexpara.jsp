<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.agentcalculate.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<html>
<head>
<title id=indexTitle><%=bundle.getString("ParameterCustomisation")%></title>
</head>
<frameset cols='20%,*'>
<%
	//String BaseCode=request.getParameter("BaseCode");
	String IndexCode=request.getParameter("IndexCode");
	String EditMode=request.getParameter("EditMode");
	
	IndexCode=ESAPI.encoder().encodeForJavaScript(IndexCode);
	EditMode=ESAPI.encoder().encodeForJavaScript(EditMode);
	System.out.println(IndexCode+EditMode);
	out.write("<frame name='rulelist' src='rulelist.jsp?IndexCode="+IndexCode+"&EditMode="+EditMode+"' scrolling='auto'/>");
	out.write("<frame name='editor' src='index.jsp?IndexCode="+IndexCode+"&EditMode="+EditMode+"' scrolling='auto'/>");
	
%>
</frameset>
</html>
