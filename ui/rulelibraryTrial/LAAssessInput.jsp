<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>

<html>
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
  <script src="./LAWagesInput.js" charset="UTF-8"></script>
  <%@include file="./LAWagesInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LAWagesSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BasicInfo.")%></td>
            </tr>
        </table>
        <div id='div0' style='diaplay:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("CompanyHierachy")%></td>
                    <td class=input><Input class="codeno" name=ManageCom verify="<%=bundle.getString("CompanyHierachy")%>|notnull&code:comcode" ondblclick="initEdorType(this,ManageComName);" onkeyup="actionKeyUp(this,ManageComName);"><input class=codename name=ManageComName elementtype=nacessary readonly=true></td>
                    <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td class=input><input class='codeno' name='BranchType' verify='<%=bundle.getString("BOM_Channel")%>|notnull&code:branchtype' ondblclick="showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,1,null,1);" onkeyup="if(!fm.ManageCom.value){alert('Please select the management agency!');return false;} showCodeList('branchtype',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" /><input class=codename name='BranchTypeName' elementtype=nacessary readonly/></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_BasicLaw")%></td>
                    <td class=input><input class='codeno' name='BaseCode' verify='<%=bundle.getString("BOM_BasicLaw")%>|notnull' ondblclick="return myShowCodeList(this,BaseCodeName);" onkeyup="return myShowCodeListKey(this,BaseCodeName);"/><input class=codename name='BaseCodeName' elementtype=nacessary readonly/></td>
                    <td class=title><%=bundle.getString("BOM_ExamineMonth/Year")%></td>
                    <td class=input><input class='common' name='WageNo' verify='<%=bundle.getString("BOM_ExamineMonth/Year")%>|notnull&len=6'  elementtype=nacessary/></td>
                </tr>
            </table>
        </div><br>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
            	<!-- input class="cssButton" buttonname='CaculateBase' value="基础指标计算" type="button" onclick="return saveClick();"/>  -->
                <!--input class="cssButton"  value="薪资试算" type="button" onclick="return save();"/>  -->              
                <input class="cssButton"  value="<%=bundle.getString("BOM_ExamineTrial")%>" type="button" onclick="return save1();"/>
                <!--input class="cssButton"  value="晋升考核试算" type="button" onclick="return save2();"/-->
            </div>
        </div>
        <input type="hidden" name="IndexType" />
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>