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
  <script src="./RuleInforInput.js" charset="UTF-8"></script>
  <%@include file="./RuleInforInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./RuleInforSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg>薪资项查询</td>
            </tr>
        </table>
        <div id='div0' style='width:100%'>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_WageCode")%></td>
                    <td class=input><input name='WageCode' class='common'  /></td>
                    <td class=title><%=bundle.getString("BOM_WageName")%></td>
                    <td class=input><input name='WageName' class='common'  /></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_WageType")%></td>
                    <td class=input><input class='codeno' name='WageType' verify='<%=bundle.getString("BOM_WageType")%>|code:indexflg' ondblclick="return showCodeList('indexflg',[this,],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('indexflg',[this,],[0,1],null,null,null,null,null,1)"/><input class=codename name=''  readonly/></td>
                    <td class=title>项目系列</td>
                    <td class=input><input class='codeno' name='IndexSerise' verify='项目系列|code:Serise' ondblclick="return showCodeList('Serise',[this,],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('Serise',[this,],[0,1],null,null,null,null,null,1)"/><input class=codename name=''  readonly/></td>
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='queryagent' value="<%=bundle.getString("BOM_Enquiry")%>" type="button" onclick="return QueryAgent();"/>
                <input class="cssButton" buttonname='AddPro' value="增加" type="button" onclick="return Add();"/>
                <input class="cssButton" buttonname='Delete' value="删除" type="button" onclick="return Delete();"/>
                <input class="cssButton" buttonname='UpdateAgent' value="修改" type="button" onclick="return UpdateAgent();"/>
            </div>
        </div>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg>薪资列表</td>
            </tr>
        </table>
        <div id='div2' style='width:100%'>
            <div id="divProGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanProGird" ></span>
                        </td>
                    </tr>
                </table>
                <input value="<%=bundle.getString("Btn_FirstPage")%>" type=button onclick="turnPageProGird.firstPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_PreviousPage")%>" type=button onclick="turnPageProGird.previousPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_NextPage")%>" type=button onclick="turnPageProGird.nextPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_LastPage")%>" type=button onclick="turnPageProGird.lastPage();" class="cssButton"/>
            </div>
        </div>
        <div id='div3' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='Add' value="增加" type="button" onclick="return AddRule();"/>
                <input class="cssButton" buttonname='Delete' value="删除" type="button" onclick="return DeleteRule();"/>
                <input class="cssButton" buttonname='Update' value="修改" type="button" onclick="return UpdateRule();"/>
            </div>
        </div>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div4);"></td>
                <td class=titleImg><%=bundle.getString("C_Rulelist")%></td>
            </tr>
        </table>
        <div id='div4' style='width:100%'>
            <div id="divRuleGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanRuleGird" ></span>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>