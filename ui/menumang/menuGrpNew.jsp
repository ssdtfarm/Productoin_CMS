<%@include file="/i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
GlobalInput tG1 =new GlobalInput();
tG1=(GlobalInput)session.getValue("GI");
String Operator =tG1.Operator;
String ComCode = tG1.ComCode;
Operator=ESAPI.encoder().encodeForHTML(Operator);
ComCode=ESAPI.encoder().encodeForHTML(ComCode);
%>
<%
//程序名称：menuGrpNew.jsp
//程序功能：菜单组的输入
//创建日期：2002-10-10
//创建人  ：
//更新记录：  更新人    更新日期     更新原因/内容
%>
<html>
<head>
<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
<SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
<SCRIPT src="menuGrpNew.js"></SCRIPT>
<script src="treeMenu.js"></script>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
<LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<%@include file="menuGrpInitNew.jsp"%>
</head>
<body onload="initForm();">
	<form action="./menuGrpManNew.jsp" method=post name=fm target="fraSubmit">
		<table class= common border=0 width=100%>
    	<tr>
			<td class= titleImg align= center>请输入查询条件：</td>
		</tr>
	</table>
		<Table class="common">
			<TR class=common style="display:none">
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=Operator value="<%=Operator%>">
				</TD>
				<TD class=title><%=bundle.getString("RegistrationOrganization")%></TD>
				<TD class=input>
					<Input class=common name=ComCode value="<%=ComCode%>">
			</TR>
			<TR  class=common>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=UserCode >
				</TD>
				 <!--td  class=title></td>
          <td  class=common ></td>
				</TD-->
			</TR>
		</Table>
		<INPUT VALUE="<%=bundle.getString("waitForTran")%>" TYPE=button onclick="queryClick()" class="cssButton">
		<!--<Div id=divCmdButton style="display: ''">-->
		<table>
			<tr>
				<td class=common>
					<IMG  src="../common/images/butExpand.gif" style="cursor:hand;" OnClick="showPage(this,divQueryGrp);">
				</td>
				<td class=titleImg><%=bundle.getString("waitForTran")%></td>
			</tr>
		</table>			
		
		<Div  id="divQueryGrp" style="display: ''" align=center>
			<table class=common>
				<tr>
					<td text-align: left colSpan=1>
						<span id="spanQueryGrpGrid"></span>
					</td>
				</tr>
			</table>
						
      <INPUT VALUE="首  页" class=cssButton TYPE=button onclick="turnPage.firstPage();">
			<INPUT VALUE="<%=bundle.getString("PreviousPage")%>" class=cssButton TYPE=button onclick="turnPage.previousPage();">
			<INPUT VALUE="<%=bundle.getString("NextPage")%>" class=cssButton TYPE=button onclick="turnPage.nextPage();">
			<INPUT VALUE="尾  页" class=cssButton TYPE=button onclick="turnPage.lastPage();">
    </div>
    
    
	<Table class="common">
	<TR class=common>
		
			<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=MenuGrpCode>
			</TD>
		
			<TD class=title><%=bundle.getString("GroupName")%></TD>
				<TD class=input>
					<Input class=common name=MenuGrpName>
				</TD>
			</TR>
			<TR class =common>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=MenuGrpDescription>
				</TD>
				<TD class=title><%=bundle.getString("waitForTran")%></TD>
				<TD class=input>
					<Input class=common name=MenuSign>
				</TD>
			</TR>
			<tr>
					<TD class=input style="display: none">
						<Input class="code" name=Action>
					</TD>
			</tr>
		</Table>		
	<p>
		<input type=button value="<%=bundle.getString("waitForTran")%>"  onclick="DataCopy()" class="cssButton" >
	</form>
</body>
</html>
