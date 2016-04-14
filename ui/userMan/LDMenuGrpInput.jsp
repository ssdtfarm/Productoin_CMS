<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
GlobalInput tG1 =new GlobalInput();
tG1=(GlobalInput)session.getValue("GI");
String Operator =tG1.Operator;;
Operator=ESAPI.encoder().encodeForHTML(Operator);
%>
<%
//程序名称：menuGrp.jsp
//程序功能：系统角色的输入
//创建日期：2002-10-10
//创建人  ：
//更新记录： ml    2006-03-08     无法显示所有的查询信息/对MulLine的查询显示进行重写
%>
<html>
<head>
<SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
<SCRIPT src="../common/javascript/VerifyInput.js"></SCRIPT>
<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
<SCRIPT src="../common/cvar/CCodeOperate.js"></SCRIPT>
<SCRIPT src="../common/Calendar/Calendar.js"></SCRIPT>
<SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
<SCRIPT src="LDMenuGrpInput.js"></SCRIPT>
<script src="../menumang/treeMenu.js"></script>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<%@include file="LDMenuGrpInit.jsp"%>
</head>
<body onload="initForm();">
	<form action="./LDMenuGrpSave.jsp" method=post name=fm target="fraSubmit">
		<Table class="common" id="divGrpInfo" style="display: ''">
			<TR class=common style="display:none">
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=Operator value="<%=Operator%>">
				</TD>
			</TR>
			<TR  class=common>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=MenuGrpCode maxlength="5">
				</TD>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=MenuGrpName>
				</TD>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=MenuGrpDescription>
				</TD>
			</TR>
			<TR class =common>				
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=MenuSign>
				</TD>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=Input>
					<Input class=common name=Usercode>
				</TD>
				<td class=title><%=bundle.getString("waitForTran")%></td>
				<td class=input><Input class="code" name=DepPartMent ondblclick="return QueryDepClick('01');" onblur="GetDepCheck('01');" ></td>
			</TR>
			<TR class =common>				
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class="code" name=Team ondblclick="return QueryDepClick('02');" onblur="GetDepCheck('02');" >
				</TD>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=Input><input class=readonly name=DepManager ></TD>
				<td class=title>部门权限管理员姓名</td>
				<td class=input><input class=readonly name=DepManagerName></td>
			</TR>
		</Table>
		<table class=common id="divHiddenDep" style="display: 'none'">
			<tr class=common>
				<td class=title><%=bundle.getString("waitForTran")%></td>
				<td class=input><input class=common name=DepCode ></td>
				<td class=title><%=bundle.getString("waitForTran")%></td>
				<td class=input><input class=common name=DepName ></td>
				<td class=title><%=bundle.getString("waitForTran")%></td>
				<td class=input><Input class="codeno" name=DepLevel	 CodeData="0|^01|<%=bundle.getString("CodeData")%>"
						ondblclick="return showCodeListEx('Type',[this,DepLevelName],[0,1]);"
						onkeyup="return showCodeListKeyEx('Type',[this,DepLevelName],[0,1]);"><input class=Codename name=DepLevelName readonly=true></td>
			</tr>
			<tr class=common>
				<td class=title>上级机构部门</td>
				<td class=input><input class=common name=UpDepCode ></td>
				<td class=title><%=bundle.getString("waitForTran")%></td>
				<td class=input><input class=common name=DepManager1 ></td>
				<td class=title></td><td class=input></td>
			</tr>
		</table>
		<Div id=divCmdButton style="display: ''">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="queryClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="insertClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="updateClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="deleteClick()" class="cssButton">
		</Div>
		<Div id=divDepCmdButton style="display: 'none'">
			<INPUT VALUE="<%=bundle.getString("Query")%>" TYPE=button onclick="queryDepClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="returnDepClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="cancelClick1()" class="cssButton">
		</Div>
		<Div  id="divQueryGrp" style="display: ''">
			<table>
				<td class=titleImg><%=bundle.getString("waitForTran")%></td>
			</table>
			<table class=common>
				<tr>
					<td text-align: left colSpan=1>
						<span id="spanQueryGrpGrid"></span>
					</td>
				</tr>
			</table>
			<INPUT VALUE="首  页" class=cssButton TYPE=button onclick="qturnPage.firstPage();">
			<INPUT VALUE="<%=bundle.getString("PreviousPage")%>" class=cssButton TYPE=button onclick="qturnPage.previousPage();">
			<INPUT VALUE="<%=bundle.getString("NextPage")%>" class=cssButton TYPE=button onclick="qturnPage.nextPage();">
			<INPUT VALUE="尾  页" class=cssButton TYPE=button onclick="qturnPage.lastPage();">
		</div>
		<Div  id="divDepConfigGrid" style="display: 'none'">
			<table>
				<td class=titleImg><%=bundle.getString("waitForTran")%></td>
			</table>
			<table class=common>
				<tr>
					<td text-align: left colSpan=1>
						<span id="spanDepConfigGrid"></span>
					</td>
				</tr>
			</table>
			<INPUT VALUE="首  页" class=cssButton TYPE=button onclick="dturnPage.firstPage();">
			<INPUT VALUE="<%=bundle.getString("PreviousPage")%>" class=cssButton TYPE=button onclick="dturnPage.previousPage();">
			<INPUT VALUE="<%=bundle.getString("NextPage")%>" class=cssButton TYPE=button onclick="dturnPage.nextPage();">
			<INPUT VALUE="尾  页" class=cssButton TYPE=button onclick="dturnPage.lastPage();">
		</div>
		<Div id=divSubCmdButton style="display: 'none'">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button  onclick="okClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button  onclick="cancelClick()" class="cssButton">
		</Div>
		<Div id="divmenuGrid2" style="display: none">
			<table class=common>
				<tr>
					<td class=titleImg><%=bundle.getString("waitForTran")%></td>
					<td class=titleImg><%=bundle.getString("waitForTran")%></td>
				</tr>
			</table>
			<table class=common>
				<tr>
					<span id="spanSelectMenuGrpTree" style="display: ''; position:absolute; slategray"></span>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input VALUE="<-" TYPE=button onclick="addMenus()" class="cssButton">
					<input value="->" type=button onclick="removeMenus()" class="cssButton">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span id="spanunSelectMenuGrpTree" style="display: ''; position:absolute; slategray"></span>
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
