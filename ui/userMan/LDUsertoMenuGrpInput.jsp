<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%

GlobalInput tG11 =new GlobalInput();
tG11=(GlobalInput)session.getValue("GI");
String Operator =tG11.Operator;
String operatorComCode =tG11.ComCode;
Operator=ESAPI.encoder().encodeForHTML(Operator);
operatorComCode=ESAPI.encoder().encodeForHTML(operatorComCode);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
<SCRIPT src="../common/cvar/CCodeOperate.js"></SCRIPT>
<SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
<SCRIPT src="./LDUsertoMenuGrpInput.js"></SCRIPT>
<SCRIPT src="../common/Calendar/Calendar.js"></SCRIPT>
<script src="../menumang/treeMenu.js"></script>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<%@include file="./LDUsertoMenuGrpInit.jsp"%>
<title><%=bundle.getString("titleInfo")%> </title>
</head>
<body onload="initForm();">
	<form action="./LDUsertoMenuGrpSave.jsp" method=post name=fm target="fraSubmit">
		<table class="common">
			<TR class=common>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input id="tdUserCode">
					<Input class=common name=UserCode maxlength="20">
				</TD>
				<TD class=input style="display:none" id="tdUserCodeReadOnly">
					<Input class=common name=UserCodeReadOnly readonly maxlength="20">
				</TD>
				<TD class=title>用户姓名</TD>
				<TD class=input id="tdUserName">
					<Input class=common name=UserName>
				</TD>
				<TD class=input style="display:none" id="tdUserNameReadOnly">
					<Input class=common name=UserNameReadOnly readonly maxlength="20">
				</TD>
			</TR>
			<TR class=common>
				<TD class=title><%=bundle.getString("OrganizationCode")%></TD>
					<TD class=input>
						<input class=codeno name=ComCode ondblclick=" showCodeList('ComCode',[this,ComCodeName],[0,1]);" onkeyup="return showCodeListKey('ComCode',[this,ComCodeName],[0,1]);"><input class=codename name=ComCodeName readonly=true>
					</TD>
           <TD  class= title>
            <%=bundle.getString("OfProfessionalAgencies")%>
          </TD>
          <TD  class= input>
            <Input class="code" name=AgentCom elementtype=nacessary  ondblclick="return showCodeList('AgentCom',[this],null,null, fm.all('ComCode').value, 'ManageCom');" onkeyup="return showCodeListKey('AgentCom',[this],null,null, fm.all('ComCode').value, 'ComCode');">
          </TD>
			</TR>
		</table>
		<div id="divCmdButton", style="display:''">
			<input value="<%=bundle.getString("waitForTran")%>" type=button onclick="queryClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="updateClick()" class="cssButton">
		</div>
		<Div id="divUserGrid" style="display: ''">
			<table>
				<tr>
					<td class=titleImg><%=bundle.getString("waitForTran")%></td>
				</tr>
			</table>
			<table class=common>
				<tr class=common>
					<td text-align: left colSpan=1>
						<span id="spanUserGrid"></span>
					</td>
				</tr>
			</table>
			<INPUT CLASS=cssbutton VALUE="首页" TYPE=button onclick="userTurnPage.firstPage();"> 
	      	<INPUT CLASS=cssbutton VALUE="<%=bundle.getString("PreviousPage")%>" TYPE=button onclick="userTurnPage.previousPage();"> 					
	      	<INPUT CLASS=cssbutton VALUE="<%=bundle.getString("NextPage")%>" TYPE=button onclick="userTurnPage.nextPage();"> 
	      	<INPUT CLASS=cssbutton VALUE="尾页" TYPE=button onclick="userTurnPage.lastPage();">
		</div>
		<div id="hide" style="display: none">
			<table class=common>
				<tr>
					<TD class=input>
						<Input class=common name=Action>
					</TD>
				</tr>
			</table>
		</div>
		<Div id="divMenuGrpGrid" style="display: none">
			<table class=common>
				<tr>
					<td class=titleImg><%=bundle.getString("waitForTran")%></td>
					<td class=titleImg><%=bundle.getString("waitForTran")%></td>
				</tr>
			</table>
			<input value="<%=bundle.getString("waitForTran")%>" type=button onclick="showMenuGrp()" style="display:none" class="cssButton">
			<table class=common>
				<tr class=common>
					<td text-align: left colSpan=1>
						<span id="spanSelectMenuGrpGrid"></span>
					</td>
					<td text-align: left colSpan=1>
						<span id="spanUnselectMenuGrpGrid"></span>
					</td>
					<td text-align: left colSpan=1>
						<span id="spanHideMenuGrpGrid1" style="display: none"></span>
					</td>
				</tr>
			</table>
			<INPUT VALUE="首  页" TYPE=button onclick="selectFirstPage()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("PreviousPage")%>" TYPE=button onclick="selectPageUp()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("NextPage")%>" TYPE=button onclick="selectPageDown()" class="cssButton">
			<INPUT VALUE="尾  页" TYPE=button onclick="selectLastPage()" class="cssButton">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT VALUE=">" TYPE=button onclick="removeMenus()" class="cssButton">
			<INPUT VALUE="<" TYPE=button onclick="addMenus()" class="cssButton">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT VALUE="首  页" TYPE=button onclick="unselectFirstPage()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("PreviousPage")%>" TYPE=button onclick="unselectPageUp()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("NextPage")%>" TYPE=button onclick="unselectPageDown()" class="cssButton">
			<INPUT VALUE="尾  页" TYPE=button onclick="unselectLastPage()" class="cssButton">
			<table class=common>
				<tr>
					<td class=titleImg><%=bundle.getString("waitForTran")%></td>
				</tr>
				<tr>
					<td text-align: left colSpan=1>
						<span id="spanMenuTree"></span>
					</td>
				</tr>
			</table>
		</div>
		<div id="divSubCmdButton" style="display: none">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="okClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="cancelClick()" class="cssButton">
		</div>
		<input type=hidden name='operatorComCode' value='<%=Operator %>' >
	</form>
	<span id="spanCode" style="display: none; position:absolute; slategray"></span>
</body>
</html>
