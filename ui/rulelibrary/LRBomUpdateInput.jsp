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
  <script src="./LRBomUpdateInput.js" charset="UTF-8"></script>
  <%@include file="./LRBomUpdateInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LRBomUpdateSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_BOMinformationmodify")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
          
                <tr>
                    <td class=title><%=bundle.getString("BOM_BOMName")%></td>
                    <td class=input><input name='Name' class='common'  verify='BOMName|notnull' elementtype=nacessary/></td>
                    <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td td class=input><input name="BranchType1" class="codeno" onkeyup="return showCodeListKey('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" verify="BranchType|code:BranchType"/><input name="BranchTypeName" class="codename" readOnly=""/></td>
                 <tr>
                 	<td class=title><%=bundle.getString("BOM_Status")%></td>
                    <td><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);" verify="<%=bundle.getString("BOM_Status")%>|notnull&code:yesno" value="Y"/><input name="EndFlagName" class="codename" readOnly="" elementtype="nacessary" value="Yes"/></td>
                 </tr>
                 <tr>
                 	<td class=title><%=bundle.getString("BOM_Description")%></td>
                    <td colspan="3" class='sql'><textarea class = 'common' name="Remark"  rows="3" style='width:90%;'></textarea> </td>
                    <td class=title style='display:none;'>BOMID</td>
                    <td class=input style='display:none;'><input class='readonly' name='ID' type='hidden' readonly/></td>
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='saveButton' value="<%=bundle.getString("C_Save")%>" type="button" onclick="return save();"/>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="BranchType" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>