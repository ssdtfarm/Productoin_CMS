<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<head>
  <script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
  <script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/jsp/LACommon.js" charset="UTF-8"></script>
  <script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
  <script src="../common/javascript/Common.js" charset="UTF-8"></script>
  <script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
  <script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <script src="./LABaseUpdateInput.js" charset="UTF-8"></script>
  
  <%@include file="./LABaseRuleInit.jsp"%>
</head>

<body  onload="updatedata();">
    <form action="./LABaseRuleSave.jsp" method=post name=fm target="fraSubmit">
            <div id='div2' style='width:100%'>
           
        </div>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_CompensationLawInformation")%></td>
            </tr>
        </table>
        <div id='div0' style=''>
            <table class=common name='table1' colNum='2'>
               <TR>
		        <TD class= title><%=bundle.getString("BOM_CompensationLawCode")%></TD>
		        <TD  class= input><Input name='RuleCode'  class='common' elementtype="nacessary" ></TD>       
			    <TD  class= title><%=bundle.getString("BOM_CompensationLawName")%> </TD>
		        <TD  class= input><Input name='RuleName' class= 'common' verify="<%=bundle.getString("BOM_CompensationLawName")%>|notnull" elementtype="nacessary"></TD> 
		      </tr> 
		      <TR>
		        <td class=title><%=bundle.getString("BOM_Channel")%></td>
		        <td class=input><input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_Channel")%>|notnull&code:branchtype'  ondblclick="return showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);"  onkeyup="return showCodeListKey('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"/><input class=codename name='BranchTypeName' elementtype="nacessary" readonly/></td>
		        <TD class= title><%=bundle.getString("BOM_CompensationLawStatus")%> </TD>
		 		<TD class=input><Input class='codeno' name=Status verify="<%=bundle.getString("BOM_CompensationLawStatus")%>|notnull" ondblClick="return myShowCodeList(this,StatusName);" onkeyup="return myShowCodeListKey(this,StatusName);"/><Input class='codename' name=StatusName elementtype="nacessary" readonly=true></TD>
		      </TR>
		      <TR>
				   <TD  class= title><%=bundle.getString("BOM_Remarks")%> </TD>
		           <td colspan="3"><textarea class = 'common' name="Remark"  rows="3" style='width:90%'></textarea> </td>
		      </TR>
            </table>
            <INPUT class=cssButton name="addbutton" VALUE="<%=bundle.getString("C_Save")%>"  TYPE=button onclick="return updateClick();" style='margin-right:20px;'>
        </div>
                <div id='div1' style='width:100%'>
       

        <div id='div1' style='width:100%'>
        </div>
        <Input type=hidden name=Operator >
	    <input type="hidden" name="hideOperate" />
	    <input type="hidden" name="hideStatus" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>