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
  <SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
  <SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
  <SCRIPT src="../common/javascript/VerifyInput.js"></SCRIPT>
  <SCRIPT src="../common/javascript/Common.js" ></SCRIPT>
  <SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
  <SCRIPT src="../common/cvar/CCodeOperate.js"></SCRIPT>
	<SCRIPT src="../common/Calendar/Calendar.js"></SCRIPT>
<SCRIPT src="./LDUserAddInput.js"></SCRIPT>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<%@ include file="./LDUserAddInit.jsp" %>
<title><%=bundle.getString("titleInfo")%> </title>
</head>
<body onload="initForm(); initElementtype() " >
	<form action="./LDUserAddSave.jsp" method=post name=fm target="fraSubmit">
		<table class="common">
			<TR class=common>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input id="tdUserCode">
					<Input class=common name=UserCode maxlength="20" elementtype=nacessary>
				</TD>
				<TD class=title>用户姓名I18NMsg("Username/Password")</TD>
				<TD class=input id="tdUserName">
					<Input class=common name=UserName elementtype=nacessary>
				</TD>
			</TR>
			<TR class=common>
				<TD class=title><%=bundle.getString("OrganizationCode")%></TD>
					<TD class=input>
						<input class=codeno name=ComCode ondblclick=" showCodeList('ComCode',[this,ComCodeName],[0,1]);" onkeyup="return showCodeListKey('ComCode',[this,ComCodeName],[0,1]);"><input class=codename name=ComCodeName readonly=true elementtype=nacessary>
					</TD>
	           <TD  class= title><%=bundle.getString("OfProfessionalAgencies")%></TD>
	           <TD  class= input>
	            <Input class="code" name=AgentCom  ondblclick="return showCodeList('AgentCom',[this],null,null, fm.all('ComCode').value, 'ManageCom');" onkeyup="return showCodeListKey('AgentCom',[this],null,null, fm.all('ComCode').value, 'ComCode');">
	          </TD>
			</TR>
		</table>
		<div id="divHideInput", style="display:none">
			<table class="common">
				<TR class=common id=passwordTR style="display:''">
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<td class=input>
						<input class=common type="Password" name=Password maxlength="8" elementtype=nacessary>
					</TD>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=common type="Password" name=PasswordConfirm maxlength="8" elementtype=nacessary>
					</TD>
				</TR>
				<TR class=common>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=codeno name=UserState ondblclick=" showCodeList('UserState',[this,UserStateName],[0,1]);" onkeyup="return showCodeListKey('UserState',[this,UserStateName],[0,1]);"><input class=codename name=UserStateName readonly=true elementtype=nacessary>
					</TD>
				</TR>
				<tr>
					<td class=title><%=bundle.getString("waitForTran")%></td>
					<td class=input>
						<Input class=common name=UserDescription>
					</td>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=codeno name=EdorPopedom ondblclick=" showCodeList('bqedorpopedom',[this,EdorPopedomName],[0,1]);" onkeyup="return showCodeListKey('bqedorpopedom',[this,EdorPopedomName],[0,1]);"><input class=codename name=EdorPopedomName readonly=true>
					</TD>
				</tr>
				<TR class=common>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=codeno name=UWPopedom ondblclick=" showCodeList('UWPopedom',[this,UWPopedomName],[0,1]);" onkeyup="return showCodeListKey('UWPopedom',[this,UWPopedomName],[0,1]);"><input class=codename name=UWPopedomName readonly=true>
					</TD>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=codeno name=ClaimPopedom ondblclick=" showCodeList('ClaimPopedom',[this,ClaimPopedomName],[0,1]);" onkeyup="return showCodeListKey('ClaimPopedom',[this,ClaimPopedomName],[0,1]);"><input class=codename name=ClaimPopedomName readonly=true>
					</TD>
				</TR>
				<TR class=common>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=codeno name=OtherPopedom ondblclick=" showCodeList('OtherPopedom',[this,OtherPopedomName],[0,1]);" onkeyup="return showCodeListKey('OtherPopedom',[this,OtherPopedomName],[0,1]);"><input class=codename name=OtherPopedomName readonly=true>
					</TD>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=common name=PopUWFlag>
					</TD>
				</TR>
				<TR class=common>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=codeno name=SuperPopedomFlag ondblclick=" showCodeList('SuperPopedomFlag',[this,SuperPopedomFlagName],[0,1]);" onkeyup="return showCodeListKey('SuperPopedomFlag',[this,SuperPopedomFlagName],[0,1]);"><input class=codename name=SuperPopedomFlagName readonly=true>
					</TD>
					<TD class=title><%=bundle.getString("waitForTran")%></TD>
					<TD class=input>
						<Input class=common name=Operator readonly>
					</TD>
					<TD class=input style="display:none">
						<Input class=common value=<%=operatorComCode%> name=OperatorComCode style="display:none">
					</TD>
					<TD class=input style="display:none">
						<Input class=common value=<%=Operator%> name=OperatorCode style="display:none">
					</TD>
				</TR>
			</table>
		</div>
		<div id="divDateShow" style="display:''" >
		<table class="common">
			<TR class=common style="display:none">
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class="readonly" name=MakeDate>
				</TD>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class="readonly" name=MakeTime>
				</TD>
			</TR>
			<TR class=common >
				<TD class=title>有效开始日期</TD>
				<TD class=input>
					<Input class="coolDatePicker"  dateFormat="short" name=ValidStartDate elementtype=nacessary >
				</TD>
				<TD class=title>有效结束日期</TD>
				<TD class=input>
					<Input class="coolDatePicker"  dateFormat="short" name=ValidEndDate >
				</TD>
				<TD class=input style="display: none">
					<Input class=common name=HideInitTag>
				</TD>
			</TR>
		</table>
		</div>
		<div id="divCmdButton", style="display:''">
			<input value="<%=bundle.getString("waitForTran")%>" type=button onclick="queryClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="insertClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="updateClick()" class="cssButton">
			<!--20110310 heyj 用户管理需求优化，去掉用户删除功能 <INPUT VALUE="用户删除" TYPE=button onclick="deleteClick()" class="cssButton"> -->
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
		<div id="divSubCmdButton" style="display: none">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="okClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="cancelClick()" class="cssButton">
		</div>
	</form>
	<span id="spanCode" style="display: none; position:absolute; slategray"></span>
</body>
</html>
