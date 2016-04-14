<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.LRAssessIndexLibraryUtil.Result"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<html>
<head>
<title id=indexTitle><%=bundle.getString("ParameterCustomisation")%></title>
</head>
<style type="text/css">
	ul{
		margin:5px;
		}
	li{
		list-style:none;
		}
	a{text-decoration:none; font-size:80%;}
	a:hover {color:#CC3300;text-decoration:underline;}
	a:visited{color:#AA7700;}
</style>
<script type="text/javascript">
	function openEditor(basecode, indexcode,editmode){
		parent.editor.window.location.href='indexR.jsp?BaseCode='+basecode+'&IndexCode='+indexcode+'&EditMode=' + editmode;
	}
</script>
<body>
	<ul>	
<%
	String BaseCode=request.getParameter("BaseCode");
	String IndexCode=request.getParameter("IndexCode");
	String EditMode=request.getParameter("EditMode");
	
	BaseCode = ESAPI.encoder().encodeForJavaScript(BaseCode);
	IndexCode = ESAPI.encoder().encodeForJavaScript(IndexCode);
	EditMode = ESAPI.encoder().encodeForJavaScript(EditMode);
	
	Result result = LRAssessIndexLibraryUtil.getAllRules(IndexCode, null);
	Iterator<String> keys = result.keys.iterator();
	while(keys.hasNext()) {
		System.out.println("dddeeewerwr");
		String code = keys.next();
		String name = result.contaner.get(code);
		
		code = ESAPI.encoder().encodeForJavaScript(code);
		name = ESAPI.encoder().encodeForJavaScript(name);
		out.write("<li><a href='#' onclick=\"openEditor('"+BaseCode+"','"+code+"','"+EditMode+"')\">"+name+"</a></li>");
	}
%>
</ul>
</body>
</html>
