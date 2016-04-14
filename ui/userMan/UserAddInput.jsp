<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%
//程序名称：
//程序功能：
//创建日期：
//创建人 ：CrtHtml程序创建
//更新记录： 更新人  更新日期   更新原因/内容
%>
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
<SCRIPT src="UserAdd.js"></SCRIPT>
<SCRIPT src="../common/Calendar/Calendar.js"></SCRIPT>
<script src="../menumang/treeMenu.js"></script>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<%@include file="./UserAddInit.jsp"%>
<title>titleInfo </title>
</head>
<body onload="initForm();initElementtype();">
	<form action="./userAddMan.jsp" method=post name=fm target="fraSubmit">
		<table class="common">
			<TR class=common>
				<TD class=title><%=bundle.getString("UserCode")%>   </TD>
				<TD class=input id="tdUserCode">
					<Input class=common value=<%=Operator%> name=UserCode maxlength="20"  >
				</TD>
				<TD class=input style="display:none" id="tdUserCodeReadOnly">
					<Input class=common name=UserCodeReadOnly readonly maxlength="20">
				</TD>
				<TD class=title><%=bundle.getString("Username")%>   </TD>
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
						<input class=codeno name=ComCode ondblclick=" showCodeList('ComCode',[this,ComCodeName],[0,1]);" onkeyup="return showCodeListKey('ComCode',[this,ComCodeName],[0,1]);"><input class=codename name=ComCodeName readonly=true >
					</TD>
					<TD class=title><%=bundle.getString("UserStatus")%>  </TD>
					<TD class=input>
						<Input class=codeno name=UserState ondblclick=" showCodeList('UserState',[this,UserStateName],[0,1]);" onkeyup="return showCodeListKey('UserState',[this,UserStateName],[0,1]);"><input class=codename name=UserStateName readonly=true > 
					</TD>
<!--           <TD  class= title>-->
<!--            代理机构-->
<!--          </TD>-->
<!--          <TD  class= input>-->
<!--            <Input type=hidden class="code" name=AgentCom elementtype=nacessary  ondblclick="return showCodeList('AgentCom',[this],null,null, fm.all('ComCode').value, 'ManageCom');" onkeyup="return showCodeListKey('AgentCom',[this],null,null, fm.all('ComCode').value, 'ComCode');">-->
<!--          </TD>-->
          <Input type=hidden name=AgentCom></Input>
			</TR>
		</table>
		<div id="divHideInput", style="display:none">
			<table class="common">
				<tr>
<!--					<TD class=title>保全权限</TD>-->
<!--					<TD class=input>-->
<!--						<Input class=codeno name=EdorPopedom ondblclick=" showCodeList('bqedorpopedom',[this,EdorPopedomName],[0,1]);" onkeyup="return showCodeListKey('bqedorpopedom',[this,EdorPopedomName],[0,1]);"><input class=codename name=EdorPopedomName readonly=true>-->
<!--					</TD>-->
					<Input type=hidden name=EdorPopedom></Input>
					<Input type=hidden name=EdorPopedomName></Input>
				</tr>
				<TR class=common>
<!--					<TD class=title>核保权限</TD>-->
<!--					<TD class=input>-->
<!--						<Input class=codeno name=UWPopedom ondblclick=" showCodeList('UWPopedom',[this,UWPopedomName],[0,1]);" onkeyup="return showCodeListKey('UWPopedom',[this,UWPopedomName],[0,1]);"><input class=codename name=UWPopedomName readonly=true>-->
<!--					</TD>-->
					<Input type=hidden name=UWPopedom></Input>
					<Input type=hidden name=UWPopedomName></Input>
<!--					<TD class=title>核赔权限</TD>-->
<!--					<TD class=input>-->
<!--						<Input class=codeno name=ClaimPopedom ondblclick=" showCodeList('ClaimPopedom',[this,ClaimPopedomName],[0,1]);" onkeyup="return showCodeListKey('ClaimPopedom',[this,ClaimPopedomName],[0,1]);"><input class=codename name=ClaimPopedomName readonly=true>-->
<!--					</TD>-->
					<Input type=hidden name=ClaimPopedom></Input>
					<Input type=hidden name=ClaimPopedomName></Input>
				</TR>
				<TR class=common>
<!--					<TD class=title>其它权限</TD>-->
<!--					<TD class=input>-->
<!--						<Input class=codeno name=OtherPopedom ondblclick=" showCodeList('OtherPopedom',[this,OtherPopedomName],[0,1]);" onkeyup="return showCodeListKey('OtherPopedom',[this,OtherPopedomName],[0,1]);"><input class=codename name=OtherPopedomName readonly=true>-->
<!--					</TD>-->
					<Input type=hidden name=OtherPopedom></Input>
					<Input type=hidden name=OtherPopedomName></Input>
<!--					<TD class=title>首席核保标志</TD>-->
<!--					<TD class=input>-->
<!--						<Input class=common name=PopUWFlag>-->
<!--					</TD>-->
					<Input type=hidden name=PopUWFlag></Input>
				</TR>
				<TR class=common>
					<TD class=title><%=bundle.getString("User_SuperAuthorityFlag")%></TD>
					<TD class=input>
						<Input class=codeno name=SuperPopedomFlag ondblclick=" showCodeList('SuperPopedomFlag',[this,SuperPopedomFlagName],[0,1]);" onkeyup="return showCodeListKey('SuperPopedomFlag',[this,SuperPopedomFlagName],[0,1]);"><input class=codename name=SuperPopedomFlagName readonly=true >
					</TD>
					<TD class=title><%=bundle.getString("Operator")%>  </TD>
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
		<table class="common">
			<TR class=common style="display:none">
				<TD class=title>MakeDate</TD>
				<TD class=input>
					<Input class="readonly" name=MakeDate>
				</TD>
				<TD class=title>MakeTime</TD>
				<TD class=input>
					<Input class="readonly" name=MakeTime>
				</TD>
			</TR>
			<TR class=common id ="validTR">
				<TD class=title><%=bundle.getString("User_EffectiveStartDate")%></TD>
				<TD class=input>
					<Input class="coolDatePicker" verify="<%=bundle.getString("EffectiveStartDate")%>|DATE" dateFormat="short" name=ValidStartDate>
				</TD>
				<TD class=title><%=bundle.getString("User_EffectiveEndDate")%></TD>
				<TD class=input>
					<Input class="coolDatePicker" verify="<%=bundle.getString("EffectiveEndDate")%>|DATE" dateFormat="short" name=ValidEndDate>
				</TD>
				<TD class=input style="display: none">
					<Input class=common name=HideInitTag>
				</TD>
			</TR>
				</table>
		<div id="divCmdButton", style="display:''">
			<input value=" <%=bundle.getString("Btn_EnquiryUser")%>" type=button onclick="queryClick()" class="cssButton">
			<INPUT VALUE=" <%=bundle.getString("Btn_AddUser")%>" TYPE=button onclick="insertClick()" class="cssButton">
			<INPUT VALUE=" <%=bundle.getString("Btn_ModifyUser")%>" TYPE=button onclick="updateClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_DeleteUser")%>" TYPE=button onclick="deleteClick()" class="cssButton">
		</div>
		<Div id="divUserGrid" style="display: ''">
			<table>
				<tr>
					<td class=titleImg><%=bundle.getString("User_UserEnquiryResult")%></td>
				</tr>
			</table>
			<table class=common>
				<tr class=common>
					<td text-align: left colSpan=1>
						<span id="spanUserGrid"></span>
					</td>
				</tr>
			</table>
			<INPUT VALUE="<%=bundle.getString("Btn_FirstPage") %> " TYPE=button onclick="userFirstPage()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_PreviousPage") %> " TYPE=button onclick="userPageUp()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_NextPage") %>" TYPE=button onclick="userPageDown()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_LastPage") %>" TYPE=button onclick="userLastPage()" class="cssButton">
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
					<td class=titleImg style='width:50%'><%=bundle.getString("RolesOwnedbyUser")%></td>
					<td class=titleImg><%=bundle.getString("RolesDonotOwnedbyUser")%></td>
				</tr>
			</table>
			<input value="showMenuGrp" type=button onclick="showMenuGrp()" style="display:none" class="cssButton">
			<table class=common>
				<tr class=common>
					<td text-align: left colSpan=1 style='width:50%'>
						<span id="spanSelectMenuGrpGrid" ></span>
					</td>
					<td text-align: left colSpan=1 style='width:50%'>
						<span id="spanUnselectMenuGrpGrid" ></span>
					</td>
					<td text-align: left colSpan=1>
						<span id="spanHideMenuGrpGrid1" style="display: none"></span>
					</td>
				</tr>
			</table>
			<table class=common>
				<tr class=common>
					<td text-align: left colSpan=1 style='width:40%'>
					<INPUT VALUE="<%=bundle.getString("Btn_FirstPage") %> " TYPE=button onclick="selectFirstPage()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_PreviousPage") %> " TYPE=button onclick="selectPageUp()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_NextPage") %>" TYPE=button onclick="selectPageDown()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_LastPage") %>" TYPE=button onclick="selectLastPage()" class="cssButton">
					</td>
					<td text-align: left colSpan=1 style='width:10%'>
					&nbsp;&nbsp;&nbsp;
					<INPUT VALUE=">" TYPE=button onclick="removeMenus()" class="cssButton">
			<INPUT VALUE="<" TYPE=button onclick="addMenus()" class="cssButton">
					</td>
					<td text-align: left colSpan=1 style='width:50%'>
						<INPUT VALUE="<%=bundle.getString("Btn_FirstPage") %> " TYPE=button onclick="unselectFirstPage()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_PreviousPage") %> " TYPE=button onclick="unselectPageUp()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_NextPage") %>" TYPE=button onclick="unselectPageDown()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_LastPage") %>" TYPE=button onclick="unselectLastPage()" class="cssButton">
					</td>
				</tr>
			</table>
			<table class=common>
				<tr>
					<td class=titleImg><%=bundle.getString("RolesNodeDetailTable")%> </td>
				</tr>
				<tr>
					<td text-align: left colSpan=1>
						<span id="spanMenuTree"></span>
					</td>
				</tr>
			</table>
		</div>
		<div id="divSubCmdButton" style="display: none">
			<INPUT VALUE="<%=bundle.getString("Btn_OK")%>" TYPE=button onclick="okClick()" class="cssButton">
			<INPUT VALUE="<%=bundle.getString("Btn_Exit")%>" TYPE=button onclick="cancelClick()" class="cssButton">
		</div>
	</form>
	<span id="spanCode" style="display: none; position:absolute; slategray"></span>
</body>
</html>
