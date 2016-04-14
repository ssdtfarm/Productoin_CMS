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
  <script src="./LRProAddInput.js" charset="UTF-8"></script>
  <%@include file="./LRProAddInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LRProAddSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_Additem")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_WageName")%></td>
                    <td class=input><input name='WageName' class='common' verify='WageName|notnull'  elementtype=nacessary/></td>                    
                    <td class=title><%=bundle.getString("BOM_WageType")%></td>
                    <td class=input><input class='codeno' name='WageType' verify='WageType|notnull&code:indexflg' ondblclick="return showCodeList('indexflg',[this,indexflgName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('indexflg',[this,],[0,1],null,null,null,null,null,1)"/><input class=codename name='indexflgName'  elementtype="nacessary" readonly/></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td class=input><input class='codeno' name='BranchType' verify='Channel|notnull&code:branchtype' ondblclick="return showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"/><input class=codename  elementtype="nacessary" name='BranchTypeName'  readonly/></td>
                    <td class=title><%=bundle.getString("BOM_Status")%></td>
                    <td class=input><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);" verify="Status|notnull&code:yesno" value="Y"/><input name="EndFlagName" class="codename" readOnly="" elementtype="nacessary" value="Yes"/></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_Description")%></td>
                    <td colspan="3" class='sql'><textarea class = 'common' name="Description"  rows="3" style='width:90%'></textarea> </td>
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='saveButton' value="<%=bundle.getString("C_Save")%>" type="button" onclick="return save();"/>                
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="IndexSerise" value = '01' />
        <input type="hidden" name="tSQL" />
       <td class=input><input class='codeno' name='BranchType2' type="hidden" value ='01' "/><input class=codename   type="hidden"  name='BranchTypeName1'  readonly/></td>
        
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>