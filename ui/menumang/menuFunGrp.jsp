<%@include file="/i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.lis.pubfun.GlobalInput"%>
<%
	//程序名称：menuGrp.jsp
	//程序功能：菜单组的输入
	//创建日期：2002-10-10
	//创建人  ：
	//更新记录：  更新人    更新日期     更新原因/内容
%>

<%
	GlobalInput tG1 = new GlobalInput();
	tG1 = (GlobalInput) session.getValue("GI");
	String Operator = tG1.Operator;
	;
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
		<SCRIPT src="../common/cvar/CCodeOperate.js"></SCRIPT>
		<SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
		<SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
		<SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
		<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
		<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>

		<SCRIPT src="menuFunGrp.js"></SCRIPT>
		<script src="treeMenu.js">
</script>
		<%@include file="menuFunInit.jsp"%>

	</head>
	<body onload="initForm();">

		<form action="./menuFunMan.jsp" method=post name=fm target="fraSubmit">
			<table class=common>
				<tr>
					<TD class=input style="display: none">
						<Input class="code" name=Action>
						class= input style= "display: none">
						<Input class="code" name=isChild>
						class= input style= "display: none">
						<Input class="code" name=isChild2>
						//2005
					</TD>
				</tr>
				<TR class=common>
					<TD class=title>
						<%=bundle.getString("waitForTran")%>
					</TD>
					<TD class=input>
						<Input class=common name=NodeName> <Input class=common name=selIndex>
					</TD>
					<TD class=title>
						<%=bundle.getString("waitForTran")%>
					</TD>
					<TD class=input>
						<Input class=common name=RunScript>
					</TD>
				</TR>
			</Table>
			<input type="checkbox" name="checkbox1" value="1">
			<b><%=bundle.getString("waitForTran")%>)</b> &nbsp;&nbsp;
			<input type="hidden" name="checkbox2" value="1">
			<!--  <b>作为页面权限菜单插入</b>-->
			<p>
				<Div id=divCmdButton style="display: ''">
					<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button class="cssButton"
						onclick="queryClick()">
					<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button class="cssButton"
						onclick="insertClick()">
					<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button class="cssButton"
						onclick="deleteClick()">
				</Div>

				<Div id="divQueryGrp" style="display: ''">
					<table>
						<td class=titleImg>
							<%=bundle.getString("waitForTran")%>
						</td>

					</table>

					<table class=common>
						<tr>
							<td>
								<span id="spanQueryGrpGrid"></span>
							</td>
						</tr>
					</table>

					<!-- XinYQ rewrote on 2007-04-23 -->
					<br>
					<!-- 查询结果翻页按钮 -->
					<div id="divTurnPageMenuGrid" align="center" style="display: ''">
						<input type="button" class="cssButton" value="首  页"
							onclick="userFirstPage()">
						<input type="button" class="cssButton" value="<%=bundle.getString("PreviousPage")%>"
							onclick="userPageUp()">
						<input type="button" class="cssButton" value="<%=bundle.getString("NextPage")%>"
							onclick="userPageDown()">
						<input type="button" class="cssButton" value="尾  页"
							onclick="userLastPage()">
					</div>
				</div>
		</form>

		<span id="spanCode" style="display: none; position: absolute;"></span>
	</body>
</html>
