<%@include file="/i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
GlobalInput tG1 =new GlobalInput();
tG1=(GlobalInput)session.getValue("GI");
String Operator =tG1.Operator;;
Operator=ESAPI.encoder().encodeForHTML(Operator);
%>
<%
//程序名称：menuGrp.jsp
//程序功能：菜单组的输入
//创建日期：2002-10-10
//创建人  ：
//更新记录： ml    2006-03-08     无法显示所有的查询信息/对MulLine的查询显示进行重写
%>
<html>
<head>
<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
<SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
<SCRIPT src="menuGrp.js"></SCRIPT>
<script src="treeMenu.js"></script>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<%@include file="menuGrpInit.jsp"%>
</head>
<body onload="initForm();">
	<form action="./menuGrpMan.jsp" method=post name=fm target="fraSubmit">
		<Table class="common">
			<TR class=common style="display:none">
				<TD class=title>Operator</TD>
				<TD class=input>
					<Input class=common name=Operator value="<%=Operator%>">
				</TD>
			</TR>
			<TR  class=common>
				<TD class=title><%=bundle.getString("RoleCode") %></TD>
				<TD class=input>
					<Input class=common name=MenuGrpCode maxlength="5">
				</TD>
				<TD class=title><%=bundle.getString("RoleName") %></TD>
				<TD class=input>
					<Input class=common name=MenuGrpName>
				</TD>
				<TD class=title><%=bundle.getString("RoleDescription") %></TD>
				<TD class=input>
					<Input class=common name=MenuGrpDescription>
				</TD>
			</TR>
			</Table>
			<Div id=divSubCmdButton1 style="display: none">
			<TR class =common >				
				<TD class=title>MenuSign</TD>
				<TD class=input>
					<Input class=common name=MenuSign>
				</TD>
				<TD class=title>Usercode</TD>
				<TD class=Input>
					<Input class=common name=Usercode>
				</TD>
			</TR>
			</Div>
		<Div id=divCmdButton style="display: ''">
			<INPUT VALUE="<%=bundle.getString("Btn_EnquiryRole")%>" TYPE=button onclick="queryClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_AddRole")%>" TYPE=button onclick="insertClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_ModifyRole")%>" TYPE=button onclick="updateClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_DeleteRole")%>" TYPE=button onclick="deleteClick()" class="cssButton">
		</Div>
		<Div  id="divQueryGrp" style="display: ''">
			<table>
				<td class=titleImg><%=bundle.getString("Rolelist") %></td>
			</table>
			<table class=common>
				<tr>
					<td text-align: left colSpan=1>
						<span id="spanQueryGrpGrid"></span>
					</td>
				</tr>
			</table>
		</div>
		<Div id=divSubCmdButton style="display: none">
			<INPUT VALUE="<%=bundle.getString("Btn_OK")%>" TYPE=button  onclick="okClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_Exit")%>" TYPE=button  onclick="cancelClick()" class="cssButton">
		</Div>
		<Div id="divmenuGrid2" style="display: none">
			<table class=common>
				<tr>
					<td class=titleImg><%=bundle.getString("MenuOwnedbyRole") %></td>
					<td class=titleImg><%=bundle.getString("MenuDonotOwnedbyRole") %></td>
				</tr>
			</table>
			<table class=common>
				<tr>
				<td text-align: left colSpan=1 style='width:28%'>
				<span id="spanSelectMenuGrpTree" style="display: ''; position:absolute; slategray"></span>
				</td>
				<td text-align: left colSpan=1 style='width:22%'>
				<input VALUE="<-" TYPE=button onclick="addMenus()" class="cssButton">
					<input value="->" type=button onclick="removeMenus()" class="cssButton">
				</td>
				<td text-align: left colSpan=1 style='width:50%'>
				<span id="spanunSelectMenuGrpTree" style="display: ''; position:absolute; slategray"></span>
				</td>
					<td text-align: left colSpan=1">
						<span id="spanHideMenuGrpGrid1" style="display: none"></span>
						<span id="spanHideMenuGrpGrid2" style="display: none"></span>
						<Input class=common name=hideString style="display:none">
						<Input class=common name=hideRemoveString style="display:none">
					</td>
				</tr>
				<tr>
					<TD class=input style="display: none">
						<Input class="code" name=hide1>
						<Input class="code" name=hide2>
						<Input class="code" name=Action>
					</TD>
				</tr>
			</table>
		</Div>
	</form>
	<span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>
