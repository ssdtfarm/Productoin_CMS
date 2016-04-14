<%@include file="../common/jsp/UsrCheck.jsp"%>
<%
//程序名称：LABankTreeQuery.jsp
//程序功能：
//创建日期：2004-04-1 15:31:08
//创建人  ：CrtHtml程序创建
//更新记录：  更新人    更新日期     更新原因/内容
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
<SCRIPT src="./LRExpInput.js"></SCRIPT>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<%@include file="./LRExpInit.jsp"%>
<title><%=bundle.getString("BOM_BasicLawCustomization")%></title>
</head>
<body onload="initForm();">
	<form action="./LRExpSave.jsp" method=post name=fm target="fraSubmit">
		<table>
			<tr>
				<td class=common><IMG src="../common/images/butExpand.gif"
					style="cursor: hand;" OnClick="showPage(this,divLAAgent);">
				<td class=titleImg><%=bundle.getString("BOM_CompensationLawEnquireCondition")%></td>
				</td>
			</tr>
		</table>
		<Div id="divLAAgent" style="display: ''">
			<table class=common>
				<TR class=common>
					<TD class=title><%=bundle.getString("BOM_CompensationLawCode")%></TD>
					<TD class=input><Input class=common name=RuleCode></TD>
					<TD class=title><%=bundle.getString("BOM_CompensationLawName")%></TD>
					<TD class=input><Input name=RuleName class=common></TD>
				</TR>
				<tr>
					<td class=title><%=bundle.getString("BOM_Channel")%></td>
					<td>
						<input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_Channel")%>|code:branchtype' 	ondblclick="return showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);"	onkeyup="return showCodeListKey('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1)" /><input	class=codename name='BranchTypeName' readonly />
					</td>
					<TD class=title><%=bundle.getString("BOM_CompensationLawStatus")%></TD>
					<TD class=input><Input class='codeno' name=Status verify="<%=bundle.getString("BOM_CompensationLawStatus")%>|notnull" readonly=true><Input	class='codename' name=StatusName readonly=true></TD>
				</tr>

			</table>
			<INPUT VALUE="<%=bundle.getString("Btn_Search")%>" class="cssButton" TYPE=button 	onclick="easyQueryClick();"> 
			<input value="<%=bundle.getString("Btn_Export")%>" class="cssButton" Type=button onclick="return Exp();" /> 
			<!-- input value="历史查询" class="cssButton" Type=button onclick="return QueryHistory();"/>  -->
		</Div>

		<table>
			<tr>
				<td class=common><IMG src="../common/images/butExpand.gif" 	style="cursor: hand;" OnClick="showPage(this,divAgentGrid);"></td>
				<td class=titleImg><%=bundle.getString("BOM_CompensationLawEnquireResult")%></td>
			</tr>
		</table>
		<Div id="divAgentGrid" style="display: ''">
			<table class=common>
				<tr class=common>
					<td text-align: left colSpan=1><span id="spanAgentGrid"></span></td>
				</tr>
			</table>
		</Div>
		<div id='info' style='display: none;' title="Message"><%=bundle.getString("BOM_Processing,pleasewait…")%></div>
		<input type="hidden" name="BaseCode" value='B00055' />
	</form>
	<span id="spanCode" style="display: none; position: absolute;"></span>
</body>
</html>
