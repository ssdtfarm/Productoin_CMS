<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<%@include file="/i18n/language.jsp"%>
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
    <script type="text/javascript" src="../common/artDialog4.1.4/artDialog.js?skin=default"></script>
<script type="text/javascript" src="../common/artDialog4.1.4/plugins/iframeTools.js"></script>
  <script src="./LRBomInput.js" charset="UTF-8"></script>
  <%@include file="./LRBomInit.jsp"%>
</head>
<body  onload="initElementtype();">
    <form action="./LRBomSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("C_BOMenquiry")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='3'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_BOMCode")%></td>
                    <td class=input><input name='ID' class='common'  /></td>
                    <td class=title><%=bundle.getString("BOM_BOMName")%></td>
                    <td class=input><input name='Name' class='common'  /></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td><input name="BranchType" class="codeno" onkeyup="return showCodeListKey('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" verify="展业类型|code:BranchType"/><input name="BranchTypeName" class="codename" readOnly=""/></td>
                    <td class=title><%=bundle.getString("BOM_Status")%></td>
                    <td><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);"/><input name="EndFlagName" class="codename" readOnly=""  value=""/></td>
                </tr>
            </table>
        </div>
       
        <div id='div2' style='width:100%'>
        	
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='queryagent' value="<%=bundle.getString("BOM_Enquiry")%>" type="button" onclick="return QueryAgent();"/>
                <input class="cssButton" buttonname='AddAgent' value="<%=bundle.getString("BOM_AddBOM")%>" type="button" onclick="return AddAgent();"/>
            </div>
        </div>
            <div id="divBOMGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanBOMGird" ></span>
                        </td>
                    </tr>
                </table>
            </div>
        </div><br/>
        <div id="term" style="display:none">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div4);"></td>
                <td class=titleImg><%=bundle.getString("BOM_Itemlist")%></td>
            </tr>
        </table>
        <div id='div4' style='width:100%' >
        	
        <div id='div3' style='width:100%'>
            <div style="float:left;padding-right:10px">
                <input  class="cssButton" buttonname='AddTerm' value="<%=bundle.getString("BOM_Additem")%>" type="button" onclick="return AddTerm();"/>
            </div>
            </div>
        
            <div id="divTermGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanTermGird" ></span>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <!-- TAGNYUJING增加的删除的参数 -->
                <input type="hidden" name="bomid" />
        
                <input type="hidden" name="termid" />
        
        <input type="hidden" name="tSQL" />
        <input type="hidden" name="lang" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>