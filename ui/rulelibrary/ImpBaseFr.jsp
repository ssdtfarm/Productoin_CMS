<head>
<title><%=bundle.getString("BOM_BasicLawImport")%></title>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%
	 String Termid= request.getParameter("Termid");
   String name= request.getParameter("name");   
   String type= request.getParameter("type");
   System.out.println("========"+Termid+"========="+name+"||"+type);
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
        <frame id="fraInterface" name="fraInterface" scrolling="auto" src="ImpBase.jsp">
        <!--下一步页面区域-->
        <frame id="fraNext" name="fraNext" scrolling="auto" src="about:blank">
    </frameset>
</frameset>
<noframes>
    <body bgcolor="#ffffff">
    </body>
</noframes>
</html>
