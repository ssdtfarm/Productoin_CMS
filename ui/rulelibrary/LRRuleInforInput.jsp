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
  <script src="./LRRuleInforInput.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../common/artDialog4.1.4/artDialog.js?skin=default"></script>
<script type="text/javascript" src="../common/artDialog4.1.4/plugins/iframeTools.js"></script>
  <%@include file="./LRRuleInforInit.jsp"%>
</head>
<body  onload="initElementtype();">
    <form action="./LRRuleInforSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_WageEnquiry")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_WageCode")%></td>
                    <td class=input><input name='WageCode' class='common' value='' /></td>
                    <td class=title><%=bundle.getString("BOM_WageName")%></td>
                    <td class=input><input name='WageName' class='common'  /></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_WageType")%></td>
                    <td class=input><input class='codeno' name='WageType' verify='<%=bundle.getString("BOM_WageType")%>|code:indexflg' ondblclick="return showCodeList('indexflg',[this,indexflgName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('indexflg',[this,],[0,1],null,null,null,null,null,1)"/><input class=codename name='indexflgName'  readonly/></td>
                    <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td class=input><input class='codeno' name='BranchType' verify='BranchType|code:BranchType   ' ondblclick="return showCodeList('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1)"/><input class=codename name='BranchTypeName'  readonly/></td>
                </tr>                
                <tr>
                    <td class=title><%=bundle.getString("BOM_Status")%></td>
                    <td><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);" value='' /><input name="EndFlagName" class="codename" readOnly=""  /></td>
                 <td class=title><%=bundle.getString("BOM_ShowMain-indicator")%></td>
                    <td><input name="State1" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName1],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName1],[0,1],null,null,null,1);" /><input name="EndFlagName1" class="codename" readOnly=""  /></td>
                </tr>
                </tr>
            </table>
        </div>
        
        <div id='div2' style='width:100%'>
        	
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='queryagent' value="<%=bundle.getString("BOM_Enquiry")%>" type="button" onclick="return QueryTerm();"/>
                <input class="cssButton" buttonname='AddPro' value="<%=bundle.getString("C_Additionitem")%>" type="button" onclick="return Add();"/>
            </div>
        </div>
            <div id="divProGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanProGird" ></span>
                        </td>
                    </tr>
                </table>
            </div>
        </div><br/>
        <div style="display:none" id="rule">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div4);"></td>
                <td class=titleImg><%=bundle.getString("C_Rulelist")%></td>
            </tr>
        </table>
        <div id='div4' style='width:100%'>
        	
        <div id='div3' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='Add' value="<%=bundle.getString("BOM_AddRule")%>" type="button" onclick="return AddRule();"/>
            </div>
        </div>
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
        </div>
        <input type="hidden" name="hideOperate" />
        <!-- tangyj20130927增加，用于传参 -->
                <input type="hidden" name="wagecode" />
        
                <input type="hidden" name="indexcode" />
        
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>