<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<head>
<script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
  <script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
  <script src="../common/javascript/Common.js" charset="UTF-8"></script>
    <script src="../common/javascript/download.js" charset="UTF-8"></script>
  
  <script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
  <script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <script src="./LRRuleInforInputQuery.js" charset="UTF-8"></script>
  <script type="text/javascript" src="../common/artDialog4.1.4/artDialog.js?skin=default"></script>
<script type="text/javascript" src="../common/artDialog4.1.4/plugins/iframeTools.js"></script>
  <%@include file="./LRRuleInforInitQuery.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LRRuleInforSaveReport.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_WageEnquiry")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                     <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td class=input><input class='codeno' name='BranchType' verify='展业类型|code:BranchType   ' ondblclick="return showCodeList('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1)" value=""/><input class=codename name='BranchTypeName'  readonly/></td>
                                    <td class=title><%=bundle.getString("BOM_WageStatus")%></td>
                    <td><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);"  value=""/><input name="EndFlagName" class="codename" readOnly=""  value=""/></td>
                
                
                
                
                </tr>
                <tr>
                
                    <td class=title><%=bundle.getString("BOM_WageCode")%></td>
                    <td class=input><input name='WageCode' class='common' value="" /></td>
                    <td class=title><%=bundle.getString("BOM_WageName")%></td>
                    <td class=input><input name='WageName' class='common' value="" /></td>
                
                
                </tr>                
                <tr>
                
                    <td class=title><%=bundle.getString("BOM_RuleCode")%></td>
                    <td class=input><input name='IndexCode' class='common'  value=""/></td>
                    <td class=title><%=bundle.getString("BOM_RuleName")%></td>
                    <td class=input><input name='IndexName' class='common'  value=""/></td>
                
                
                </tr>
                        
                <tr>
                    <td class=title><%=bundle.getString("BOM_RuleStatus")%></td>
                    <td><input name="StateRule" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagNameRule],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagNameRule],[0,1],null,null,null,1);"  value=""/><input name="EndFlagNameRule" class="codename" readOnly=""  value=""/></td>
                </tr>
            </table>
        </div>
       
        <div id='div2' style='width:100%'>
        	
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='queryagent' value="<%=bundle.getString("BOM_Enquiry")%>" type="button" onclick="return queryAgent();"/>
                <input class="cssButton" buttonname='AddAgent' value="<%=bundle.getString("BOM_Reset")%>" type="button" onclick="return resetForm();"/>
                <input class="cssButton" buttonname='Delete' value="<%=bundle.getString("Btn_ExportToExcel")%>" type="button" onclick="return formprint();"/>
              
            </div>
        </div>
         <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg><%=bundle.getString("BOM_RuleStandardInformationList")%></td>
            </tr>
        </table>
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
      
      
     
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
     <iframe id='downloadframe' height=0,width=0 />
</body>
</html>