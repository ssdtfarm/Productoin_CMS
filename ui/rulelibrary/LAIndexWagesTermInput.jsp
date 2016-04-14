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
  <script src="./LAWageInputB.js" charset="UTF-8"></script>
  <%@include file="./LAWageInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LAWageTermSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg>Basic Info.</td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>                    
                    <td class=title>Governing Hierarchy</td>
                    <td class=input><Input class="codeno" name='ManageCom' verify="Governing Hierarchy|notnull&code:comcode" ondblclick="initEdorType(this,ManageComName);" onkeyup="actionKeyUp(this,ManageComName);"><input class=codename name='ManageComName' elementtype=nacessary readonly=true></td> 
                    <td class=title>Sales Management Policy Version</td>
                    <td class=input><input class='codeno' name='BaseCode' verify='Sales Management Policy Version|notnull&code:baseversion2' ondblclick="if(!fm.BranchType.value){alert('Please select the channels !');return false;} showCodeList('baseversion2',[this,BaseCodeName],[0,1],null,null,null,1,null,1);" onkeyup="if(!fm.BranchType.value){alert('Please select the channels !');return false;} showCodeListKey('baseversion2',[this,BaseCodeName],[0,1],null,null,null,1,null,1)" readonly/><input class=codename name='BaseCodeName' elementtype=nacessary readonly/></td>
                </tr>
                 <tr>
                 	<td class=title>Ranking</td>
                    <td class=input><input class='codeno' name='AgentGrade' verify='Ranking|code:agentgrade' ondblclick="if(!fm.BranchType.value){alert('Please select the channels !');return false;} showCodeList('agentgrade',[this,AgentGradeName],[0,1],null,null,null,null,null,1);" onkeyup="if(!fm.BranchType.value){alert('Please select the channels !');return false;} showCodeListKey('agentgrade',[this,AgentGradeName],[0,1],null,null,null,null,null,1)" readonly /><input class=codename name='AgentGradeName' readonly/></td>
                 	<td class=title>WageCode</td>
                    <td class=input><input class='common' name='WageCode'  readonly/></td>
                </tr>
                <tr>
                    
                    <td class=title>Type of calculation</td>
                    <td class=input><input class='codeno' name='IndexType' verify='Type of calculation|notnull&code:indexflg' ondblclick="if(!fm.BaseCode.value){alert('请选择基本法版本！');return false;} showCodeList('indexflg',[this,IndexTypeName],[0,1],null,null,null,null,null,1);" onkeyup="if(!fm.BaseCode.value){alert('请选择基本法版本！');return false;} showCodeListKey('indexflg',[this,IndexTypeName],[0,1],null,null,null,null,null,1)" readonly /><input class=codename name='IndexTypeName' elementtype=nacessary readonly/></td>
                	<td class=title>Calculation Month/Year</td>
                    <td class=input><input class='common' name='WageNo' verify='Calculation Month/Year|notnull&len=6'  elementtype=nacessary/></td>
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname=' calculate' value="Calculated" type="button" onclick="return saveClick();"/>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
        <input type="hidden" name="BranchType" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>