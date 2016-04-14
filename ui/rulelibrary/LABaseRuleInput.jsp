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
  <script src="./LABaseRuleInput.js" charset="UTF-8"></script>
  
    <script type="text/javascript" src="../common/artDialog4.1.4/artDialog.js?skin=default"></script>
<script type="text/javascript" src="../common/artDialog4.1.4/plugins/iframeTools.js"></script>
  <%@include file="./LABaseRuleInit.jsp"%>
    <%@include file="./LABaseRuleQuerInit.jsp"%>
  

</head>

<body  onload="initForm();initElementtype();">
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
		        <TD  class= input><Input name='RuleCode'  class='common'  ></TD>       
			    <TD  class= title><%=bundle.getString("BOM_CompensationLawName")%> </TD>
		        <TD  class= input><Input name='RuleName' class= 'common' verify="<%=bundle.getString("BOM_CompensationLawName")%>|notnull" ></TD> 
		      </tr> 
		      <TR>
		        <td class=title><%=bundle.getString("BOM_Channel")%></td>
		        <td class=input><input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_Channel")%>|notnull&code:branchtype'  ondblclick="return showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);"  onkeyup="return showCodeListKey('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"/><input class=codename name='BranchTypeName' readonly/></td>
		        <TD class= title><%=bundle.getString("BOM_CompensationLawStatus")%> </TD>
		 		<TD class=input><Input class='codeno' name=Status verify="<%=bundle.getString("BOM_CompensationLawStatus")%>|notnull" ondblClick="return myShowCodeList(this,StatusName);" onkeyup="return myShowCodeListKey(this,StatusName);"/><Input class='codename' name=StatusName readonly></TD>
		      </TR>
		   
            </table>
				<INPUT class=cssButton name="querybutton" VALUE="<%=bundle.getString("BOM_Enquiry")%>"  TYPE=button onclick="return easyQueryClick();" style='margin-right:20px;'>
           
            <INPUT class=cssButton name="addbutton" VALUE="<%=bundle.getString("BOM_AddCompensationLaw")%>"  TYPE=button onclick="return addbase();" style='margin-right:20px;'>
                   <INPUT class=cssButton name="addbutton" VALUE="<%=bundle.getString("Btn_Reset")%>"  TYPE=button onclick="return resetForm();" style='margin-right:20px;'>
       
        </div>
                <div id='div1' style='width:100%'>
        </br>
         <table style="display:none" id="result">
    	<tr>
        	<td class=common>
		<IMG  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,divAgentGrid);">
    		</td>
    		<td class= titleImg>
				<%=bundle.getString("InquiryResult")%>
    		</td>
    	</tr>
    </table>
  	<Div  id= "divAgentGrid" style= "display: ''">
      	<table  class= common>
       		<tr  class= common>
      	  		<td text-align: left colSpan=1>
  					<span id="spanAgentGrid" >
  					</span> 
  			  	</td>
  			</tr>
    	</table>
  	</div>
        <div id='div1' style='width:100%'>
        </div>
        <Input type=hidden name=Operator >
	    <input type="hidden" name="hideOperate" />
	    <input type="hidden" name="hideStatus" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>