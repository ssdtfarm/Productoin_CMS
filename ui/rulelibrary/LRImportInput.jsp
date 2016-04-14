<%@include file="../common/jsp/UsrCheck.jsp"%>
<%
%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
<SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
<SCRIPT src="../common/cvar/CCodeOperate.js"></SCRIPT>
<SCRIPT src="../common/javascript/VerifyInput.js"></SCRIPT>
<SCRIPT src="./ImpBase.js"></SCRIPT>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<title><%=bundle.getString("BOM_BasicLawImport")%></title>
</head>
<body>
<table>
	<tr>
		<td class=common><IMG src="../common/images/butExpand.gif"
			style="cursor:hand;" OnClick="showPage(this,divLAAgentAdd);"></td>
		<td class=titleImg><%=bundle.getString("BOM_ImportCompensationLawFile")%></td>
	</tr>
</table>
<div id="divLAAgentAdd">
<form action="./ImpBaseSave.jsp" method="post"
	name="fm" ENCTYPE="multipart/form-data" target="fraSubmit"><input
	type=HIDDEN name=ImportPath>
<table class=common>
	<TR class=common>
		<TD class=common><%=bundle.getString("BOM_File:")%><Input class="common1" type="file" name=FileName><font color="red"><%=bundle.getString("BOM_(PleaseChooseXMLFile)")%></font></TD>
	</TR>
	<tr>
		<td><INPUT class=cssbutton VALUE="<%=bundle.getString("BOM_ImportFile")%>" TYPE=button
			onclick="Import();"></td>
	</tr>
</table>
<input type=hidden name=ImportFile>
<input type=hidden name='BranchType' value='1'>
</form>
</div>
<div id="addchargeDIV" style="font-size: 14;border: 1px;border-color: red;border-style: solid;width: 30%;display:none">
</div>
<br>
<span id="spanCode" style="display: none; position:absolute; slategray"></span>
</body>
</html>
