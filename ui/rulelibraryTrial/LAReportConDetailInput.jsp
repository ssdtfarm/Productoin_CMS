<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<head>
<script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
<script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
<script src="../common/javascript/jquery.js" charset="UTF-8"></script>
<script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
<script src="../common/javascript/Common.js" charset="UTF-8"></script>
<script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
<script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
<script src="../common/javascript/MulLine_demo.js" charset="UTF-8"></script>
<link href="../common/css/Project.css" rel=stylesheet type=text/css>
<link href="../common/css/mulLine.css" rel=stylesheet type=text/css>
<script src="./LAReportConDetailInput.js" charset="UTF-8"></script>
<%@include file="./LAReportConDetailInit.jsp"%>
</head>
<body onload="initForms();initElementtype();" style="width: 2000px;">
	<form action="./LAReportConDetailSave.jsp" method=post name=fm target="fraSubmit">
		<table>
			<tr class=common>
				<td class=common><img src="../common/images/butExpand.gif"	style="cursor: hand;" OnClick="showPage(this,div0);"></td>
				<td class=titleImg><%=bundle.getString("BOM_StatisticStandard")%></td>
			</tr>
		</table>
		<div id='div0' style="display:''">
		<table class=common name='table1'>
			<tr>
				<td class=title><%=bundle.getString("CompanyHierachy")%></td>
				<td class=input><input class='codeno' name='ManageCom' verify='<%=bundle.getString("CompanyHierachy")%>|code:comcode' ondblclick="return showCodeList('comcode',[this,ManageComName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('comcode',[this,ManageComName],[0,1],null,null,null,null,null,1)"'/><input class=codename name='ManageComName'  readonly/></td>
				<td class=title><%=bundle.getString("BOM_ChannelInformation")%></td>
				<td class=input><input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_ChannelInformation")%>|notnull&code:branchtype' ondblclick=" fm.BaseVersion.value='';fm.BaseVersionName.value='';return showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" onkeyup=" fm.BaseVersion.value='';fm.BaseVersionName.value='';return showCodeListKey('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"'/><input class=codename name='BranchTypeName' elementtype=nacessary readonly/></td>
			</tr>
			<tr>
				<td class=title><%=bundle.getString("BOM_ReportType")%></td>
				<td class=input><input class='codeno' name='ReportType' verify='<%=bundle.getString("BOM_ReportType")%>|notnull&code:indexflg1' ondblclick="return showCodeList('indexflg1',[this,ReportTypeName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('indexflg1',[this,ReportTypeName],[0,1],null,null,null,null,null,1)"'/><input class=codename name='ReportTypeName' elementtype=nacessary  readonly/></td>
				<td class=title><%=bundle.getString("BOM_CompensationLawVersions")%></td>
				<td class=input><input class='codeno' name='BaseVersion' verify='<%=bundle.getString("BOM_BasicLaw")%>|notnull' ondblclick="return myShowCodeList1(this,BaseVersionName);" onkeyup="return myShowCodeListKey1(this,BaseVersionName);"/><input class=codename name='BaseVersionName' readonly elementtype=nacessary/></td>
			</tr>
			<tr>
				<td class=title><%=bundle.getString("BOM_StatisticMonth/Year")%></td>
				<td class=input><input class='common' name='WageNo'/></td>
				<td class=title><%=bundle.getString("Text_AgentGrade")%></td>
				<td class=input><input class='codeno' name='AgentGrade' verify='<%=bundle.getString("Text_AgentGrade")%>|code:agentgrade' ondblclick="return myShowCodeList(this,AgentGradeName);" onkeyup="return myShowCodeListKey(this,AgentGradeName);"/><input class=codename name='AgentGradeName' readonly/></td>
			</tr>
			<tr>
				<td class=title><%=bundle.getString("Text_AgentCode")%></td>
				<td class=input><input class='common' name='AgentCode'/></td>
			</tr>
		</table>
			<div style="float: left; padding-right: 10px;">
				<input class="cssButton" buttonname='printReport'	value="<%=bundle.getString("BOM_Pre-caldetailsenquiry")%>" type="button" onclick="  if(!verifyInput2())	return false;easyQueryBOMGird();" /><br>
			</div>
		</div><br/><br/>
		<div id='divresult' style="display:none">
		<table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg><%=bundle.getString("InquiryResult")%></td>
            </tr>
        </table>
         <div id='div2' style='width:100%'>      
            <div id="divBOMGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanBOMGird" ></span>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
		</div>
        <input type="hidden" name="hideOperate" />
		<input type="hidden" name="tSQL" /> 
		<input type="hidden" name="ReportID" />
		<input type='hidden' name="FilePath" />
	</form>
	<span id="spanCode" style="display: none; position: absolute;"></span>
</body>
</html>
