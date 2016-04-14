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
  <script src="./LRRuleAddInput.js" charset="UTF-8"></script>
  <%@include file="./LRRuleAddInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LRRuleAddSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("C_Addrule")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_RuleName")%></td>
                    <td class=input><input name='IndexName' class='common' verify='<%=bundle.getString("BOM_RuleName")%>|notnull&80&左对齐'  elementtype=nacessary/></td>                    
                	  <td class=title><%=bundle.getString("BOM_DataType")%></td>
                    <td class=input><input class='codeno' name='DataType' verify='<%=bundle.getString("BOM_DataType")%>|notnull&code:ibrmscommandtype' onDblClick="return showCodeList('ibrmscommandtype',[this,RemarkName],[0,1],null,null,null,null,null,1);" onKeyUp="return showCodeListKey('ibrmscommandtype',[this,Remark],[0,1],null,null,null,null,null,1)"/><input class=codename name='RemarkName' elementtype=nacessary readonly/></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_CalculationType")%></td>
                    <td class=input><input class='codeno' name='LogicType' verify='<%=bundle.getString("BOM_CalculationType")%>|notnull&code:logic' onDblClick="return showCodeList('logic',[this,LogicTypeName],[0,1],null,null,null,null,null,1);"><input class=codename name='LogicTypeName' elementtype=nacessary readonly/></td>
                    <td class=title><%=bundle.getString("BOM_Status")%></td>
                    <td><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);" verify="<%=bundle.getString("BOM_Status")%>|notnull&code:yesno" value="Y"/><input name="EndFlagName" class="codename" readOnly="" elementtype="nacessary" value="是"/></td>
                    <td class=input style="display:none;"><input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_Channel")%>|notnull&80&左对齐&code:BranchType' ondblclick="return showCodeList('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('BranchType',[this,],[0,1],null,null,null,null,null,1)"/><input class=codename name='BranchTypeName' elementtype=nacessary readonly/></td>
                </tr>                
                <tr>   
                	<td class=title><%=bundle.getString("BOM_Description")%></td>
                    <td colspan="3" class='sql'><textarea class = 'common' name="Description"  rows="3" style='width:90%;'></textarea> </td>
                </tr>								
            </table>
        </div>

        <div id='div2' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='save' value="<%=bundle.getString("C_Save")%>" type="button" onclick="return save();"/>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="WageCode" />
        <input type="hidden" name="tSQL" />        
        <input type="hidden" name="TestArea"/>
        <input type="hidden" name="Json" />
        <input type="hidden" name="IndexSet" />        
        <input type="hidden" name="IndexType" />            
        <input type="hidden" name="BranchType2"/>
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
    <div>
  </div>
</body>
</html>