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
  <script src="./LRProUpdateInput.js" charset="UTF-8"></script>
  <%@include file="./LRProUpdateInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LRProUpdateSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_Itemmodify")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_WageName")%></td>
                    <td class=input><input name='WageName' class='common' verify='<%=bundle.getString("BOM_WageName")%>|notnull'  elementtype=nacessary/></td>                    
                    <td class=title><%=bundle.getString("BOM_WageType")%></td>
                    <td class=input><input class='codeno' name='WageType' verify='<%=bundle.getString("BOM_WageType")%>|notnull&code:indexflg' ondblclick="return showCodeList('indexflg',[this,indexflgName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('indexflg',[this,indexflgName],[0,1],null,null,null,null,null,1)"/><input class=codename elementtype="nacessary" name='indexflgName'  readonly/></td>
                </tr>
                <tr>
                	<td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td class=input><input name="BranchType1" class="codeno" onkeyup="return showCodeListKey('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" verify="展业类型|code:BranchType"/><input name="BranchTypeName" class="codename" readOnly=""/></td>
                    <td class=title><%=bundle.getString("BOM_Status")%></td>
                    <td class=input><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);" verify="<%=bundle.getString("BOM_Status")%>|notnull&code:yesno" value="Y"/><input name="EndFlagName" class="codename" readOnly="" elementtype="nacessary" value="是"/></td>
                </tr>
                <tr>                    
                    <td class=title><%=bundle.getString("BOM_Description")%></td>
                    <td colspan="3" class='sql'><textarea class = 'common' name="Description"  rows="3" style='width:90%;'></textarea> </td>
                    <!-- <td class=input><input class='codeno' name='BranchType2' type="hidden" value ='1' verify='<%=bundle.getString("BOM_Channel")%>|code:BranchType   ' ondblclick="return showCodeList('BranchType',[this,BranchTypeName1],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"/><input class=codename   type="hidden"  name='BranchTypeName1'  readonly/></td>
                     <!-- td class=title>系列</td> -->
                    <!-- <td class=input><input class='codeno' name='IndexSerise' type="hidden" value='01' verify='系列|code:Serise' ondblclick="return showCodeList('Serise',[this,SeriseName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('Serise',[this,],[0,1],null,null,null,null,null,1)"/><input class=codename name='SeriseName'  type="hidden" readonly/></td>-->
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='saveButton' value="<%=bundle.getString("C_Save")%>" type="button" onclick="return save();"/>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="WageCode" />
         <input type="hidden" name="BranchType" />
        <input type="hidden" name="tSQL" />
         <input class='codeno' name='BranchType2' type="hidden" value ='1'  /><input class=codename   type="hidden"  name='BranchTypeName1'  readonly/>
                     <!-- td class=title>系列</td> -->
                   <input class='codeno' name='IndexSerise' type="hidden" value='01'/><input class=codename name='SeriseName'  type="hidden" readonly/>
               
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>