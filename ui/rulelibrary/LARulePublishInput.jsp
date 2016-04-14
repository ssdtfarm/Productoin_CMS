<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
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
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <script src="./LARulePublishInput.js" charset="UTF-8"></script>
  <%@include file="./LARulePublishInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LARulePublishSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_EnquiryCondition")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_CompensationLawCode")%></td>
                    <td class=input><input name='BaseCode' class='common'  /></td>
                    <td class=title><%=bundle.getString("BOM_CompensationLawName")%></td>
                    <td class=input><input name='Name' class='common'  /></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td class=input><input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_Channel")%>|code:branchtype' ondblclick="return showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"/><input class=codename name='BranchTypeName'  readonly/></td>
                    <td class=title><%=bundle.getString("BOM_CompensationLawStatus")%></td>
                    <td class=input><input class='codeno' name='Status' value = '02'"/><input class=codename name='StatusName' value = 'Waiting for Confirm' readonly/></td>
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='query' value="<%=bundle.getString("BOM_Enquiry")%>" type="button" onclick="return queryClick();"/>
                <input class="cssButton" buttonname='reset' value="<%=bundle.getString("BOM_Reset")%>" type="button" onclick="return resetClick();"/>
            </div>
        </div>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg><%=bundle.getString("InquiryResult")%></td>
            </tr>
        </table>
        <div id='div2' style='width:100%'>
            <div id="divRuleGrid">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanRuleGrid" ></span>
                        </td>
                    </tr>
                </table>
                <%-- <input value="<%=bundle.getString("Btn_FirstPage")%>" type=button onclick="turnPageRuleGrid.firstPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_PreviousPage")%>" type=button onclick="turnPageRuleGrid.previousPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_NextPage")%>" type=button onclick="turnPageRuleGrid.nextPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_LastPage")%>" type=button onclick="turnPageRuleGrid.lastPage();" class="cssButton"/> --%>
            </div>
        </div><br/>
         	<!-- <td class=common>生效日期</td><td class=input><input name='EffectiveDate' class='coolDatePicker' /></td> -->
         <table>
         <tr class=common>
         	<td class=common><%=bundle.getString("BOM_RejectedReason")%></td>
         	<td colspan = '3'>
         		<textarea name="Reason" cols="60" rows="4" style='width:900px'></textarea>
         	</td>
         </tr>
        </table>
        <div id='div3' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='RulePublish' value="<%=bundle.getString("BOM_Accepted")%>" type="button" onclick="return RulePublish();"/>
                <input class="cssButton" buttonname='RuleNPublish' value="<%=bundle.getString("BOM_Rejected")%>" type="button" onclick="return RuleNPublish();"/>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
         <input type="hidden" name="hideStatus" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>