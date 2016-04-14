<%@include file="../common/jsp/UsrCheck.jsp"%>
<head>
<title></title>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String AgentGrade = request.getParameter("AgentGrade");
	String WageCode = request.getParameter("WageCode");
	String IndexType = request.getParameter("IndexType");
	String BaseCode = request.getParameter("BaseCode");
	
	AgentGrade=ESAPI.encoder().encodeForJavaScript(AgentGrade);
    WageCode=ESAPI.encoder().encodeForJavaScript(WageCode);
    IndexType=ESAPI.encoder().encodeForJavaScript(IndexType);
	BaseCode=ESAPI.encoder().encodeForJavaScript(BaseCode);
	
    System.out.println("AgentGrade-->"+AgentGrade);
    System.out.println("WageCode-->"+WageCode);
%>
<script language="javascript">
    var intPageWidth=screen.availWidth;
    var intPageHeight=screen.availHeight;
    window.resizeTo(intPageWidth,intPageHeight);
    window.focus();
</script>
</head>
<!--<frameset rows="35,0,0,65,*" frameborder="no" border="1" framespacing="0" cols="*"> -->
<frameset name="fraMain" rows="10,10,0,0,*" frameborder="no" border="1" framespacing="0" cols="*">
<!--标题与状态区域-->
    <!--保存客户端变量的区域，该区域必须有-->
    <frame name="VD" src="../common/cvar/CVarData.html">

    <!--保存客户端变量和WebServer实现交户的区域，该区域必须有-->
    <frame name="EX" src="../common/cvar/CExec.jsp">

    <frame name="fraSubmit"  scrolling="yes" noresize src="about:blank" >
    <frame name="fraTitle"  scrolling="no" noresize src="about:blank" >
    <frameset name="fraSet" cols="0%,*,0%" frameborder="no" border="1" framespacing="0" rows="*">
        <!--菜单区域-->
        <frame name="fraMenu" scrolling="yes" noresize src="about:blank">
        <!--交互区域-->
        <frame id="fraInterface" name="fraInterface" scrolling="auto" src="./LAIndexRuleInputR.jsp?AgentGrade=<%=AgentGrade%>&WageCode=<%=WageCode%>&IndexType=<%=IndexType%>&BaseCode=<%=BaseCode%>">
        <!--下一步页面区域-->
        <frame id="fraNext" name="fraNext" scrolling="auto" src="about:blank">
    </frameset>
</frameset>
<noframes>
    <body bgcolor="#ffffff">
    </body>
</noframes>
</html>

