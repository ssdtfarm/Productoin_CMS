<%@include file="../common/jsp/UsrCheck.jsp"%>
<%
//程序名称：LABankTreeQuery.jsp
//程序功能：
//创建日期：2004-04-1 15:31:08
//创建人  ：CrtHtml程序创建
//更新记录：  更新人    更新日期     更新原因/内容
%>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <SCRIPT src="../common/easyQueryVer3/EasyQueryCache.js"></SCRIPT>
  <SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>
  <SCRIPT src="../common/javascript/Common.js" ></SCRIPT>
  <SCRIPT src="../common/javascript/MulLine.js"></SCRIPT>
  <SCRIPT src="../common/cvar/CCodeOperate.js"></SCRIPT>
  <SCRIPT src="./LABaseRuleQueryR.js"></SCRIPT>
  <LINK href="../common/css/Project.css" rel=stylesheet type=text/css>
  <LINK href="../common/css/mulLine.css" rel=stylesheet type=text/css>
  <link rel="stylesheet" href="./iCandy/zTreeIcons.css" type="text/css" charset='UTF-8'/>
  <link rel="stylesheet" href="./iCandy/zTreeStyle.css" type="text/css"/>
  <script type="text/javascript" src="../common/javascript/jquery.js"></script>
  <script type="text/javascript" src="../common/javascript/jquery-ui.js"></script>
  <script type="text/javascript" src="../common/javascript/jquery.ztree.js" charset='UTF-8'></script>
  <script type="text/javascript" src="./LAIndexDefInputR.js" charset='UTF-8'></script>
  <%@include file="./LABaseRuleQuerInitR.jsp"%>
  <%@include file="../common/jsp/ManageComLimit.jsp"%>
  <title><%=bundle.getString("BOM_BasicLawCustomization")%></title>
</head>
<link rel="stylesheet" href="./iCandy/demo.css" type="text/css"/>
<body  onload="initForm();" >
  <form  method=post name=fm target="fraSubmit">
    <table>
    	<tr>
            <td class=common>
                <IMG  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,divLAAgent);" />
            </td>
            <td class= titleImg><%=bundle.getString("BOM_CompensationLawEnquireCondition")%>
            </td>
    	</tr>
     </table>
  <Div  id= "divLAAgent" style= "display: ''">
  <table  class= common>
      <TR  class= common> 
        <TD class= title><%=bundle.getString("BOM_CompensationLawCode")%></TD>
        <TD  class= input><Input class=common  name=RuleCode ></TD>               
	      <TD  class= title><%=bundle.getString("BOM_CompensationLawName")%></TD>
        <TD  class= input>
          <Input name=RuleName class=common>
        </TD> 
      </TR>
      <tr>
           <td class=title><%=bundle.getString("BOM_Channel")%></td>
			<td><input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_Channel")%>|code:branchtype'
              ondblclick="return showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" 
              onkeyup="return showCodeListKey('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"/><input class=codename name='BranchTypeName'  readonly/>
             </td>

        <TD class= title><%=bundle.getString("BOM_CompensationLawStatus")%>
        </TD>
 		<TD class=input>
			<Input class='codeno' name=Status verify="<%=bundle.getString("BOM_CompensationLawStatus")%>|notnull" 
								ondblClick="showCodeList('status',[this,StatusName],[0,1],null,null,null,1);"
								onkeyup="showCodeListKey('status',[this,StatusName],[0,1],null,null,null,1);"><Input class='codename' 
								name=StatusName readonly=true>
		</TD>
      </tr>
      
    </table>
          <INPUT VALUE="<%=bundle.getString("BOM_Enquiry")%>" class="cssButton" TYPE=button onclick="easyQueryClick();"> 
          <!-- input value="导出" class="cssButton" Type=button onclick="return Exp();"/> -->	
          <!-- INPUT VALUE="导入" class="cssButton" TYPE=button onclick="Imp();"> -->
          <INPUT VALUE="<%=bundle.getString("BOM_Reset")%>" class="cssButton" TYPE=button onclick="return resetForm();"> 	
          <!-- input value="历史查询" class="cssButton" Type=button onclick="return QueryHistory();"/>  -->
    </Div>      
          				
    <table>
    	<tr>
        	<td class=common>
		<IMG  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,divAgentGrid);">
    		</td>
    		<td class= titleImg>
				<%=bundle.getString("BOM_CompensationLawEnquireResult")%>
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
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>      
 	<div id='container' border="1px" style="width:100%;border-top:2px gray solid;margin-top:5px; display:none;">
 	<div style="width:250px; overflow:auto; position:absolute;margin-top:0px;border-right:1px gray solid;height:738px;">
 			<div id='tree' style='display:none;' >
	   			<ul id="menu"   class="tree"></ul>
 			</div>
 	</div>
 	<div id='detail' style="overflow:auto; position:absolute; left:290px;border-left:0px gray solid;margin-top:0px;z-index:5;display:none;">
 			<iframe  id='detailTarget' src="" style = "width:1010;height:738px;margin-right:1px; scrolling='auto'"></iframe>
 	</div>
 	</div>	
    <div id='info' style='display:none;' title="Message"><%=bundle.getString("BOM_Processing,pleasewait…")%></div>
    <input type="hidden" name="BaseCode" value ='B00055'/>
    <input type="hidden" name="HideBranchType" value =''/>
    <input type="hidden" name="State" value =''/>
  </form>
  <div id="rMenu" style="position:absolute; visibility:hidden;" class="demo.css">
	<li>
		<ul id="m_wages" onclick="Calculate();"><li>Spreadsheet</li></ul>
	</li>
  </div>
</body>
</html>
