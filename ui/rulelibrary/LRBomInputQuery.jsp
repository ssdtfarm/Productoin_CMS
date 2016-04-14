<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<head>

  
  
  
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
  <script type="text/javascript" src="../common/artDialog4.1.4/artDialog.js?skin=default"></script>
<script type="text/javascript" src="../common/artDialog4.1.4/plugins/iframeTools.js"></script>
  <script src="./LRBomInputQuery.js" charset="UTF-8"></script>
  <%@include file="./LRBomInitQuery.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LRBomSaveReport.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_BOMObjectiveInformationEnquiry")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='3'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_Channel")%></td>
                    <td><input name="BranchType" class="codeno" onkeyup="return showCodeListKey('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('BranchType',[this,BranchTypeName],[0,1],null,null,null,null,null,1);" verify="展业类型|code:BranchType"/><input name="BranchTypeName" class="codename" readOnly=""/></td>
                    <td class=title><%=bundle.getString("BOM_BOMStatus")%></td>
                    <td><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);"/><input name="EndFlagName" class="codename" readOnly=""  value=""/></td>

                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_BOMCode")%></td>
                    <td class=input><input name='ID' class='common'  /></td>
                    <td class=title><%=bundle.getString("BOM_BOMName")%></td>
                    <td class=input><input name='Name' class='common'  /></td>

                </tr>
                  <tr>
                  
                    <td class=title><%=bundle.getString("BOM_ItemCode")%></td>
                    <td class=input><input name='IDTerm' class='common'  /></td>
                    <td class=title><%=bundle.getString("BOM_ItemName")%></td>
                    <td class=input><input name='NameTerm' class='common'  /></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_ItemStatus")%></td>
                    <td><input name="StateTerm" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagNameTerm],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagNameTerm],[0,1],null,null,null,1);"/><input name="EndFlagNameTerm" class="codename" readOnly=""  value=""/></td>
                </tr>
            </table>
        </div>
       
        <div id='div2' style='width:100%'>
        	
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='queryagent' value="<%=bundle.getString("BOM_Enquiry")%>" type="button" onclick="return QueryAgent();"/>
                <input class="cssButton" buttonname='AddAgent' value="<%=bundle.getString("BOM_Reset")%>" type="button" onclick="return resetForm();"/>
                <input class="cssButton"  value="<%=bundle.getString("Btn_ExportToExcel")%>" type="button" onclick="return formprint();"/>
               
              
            </div>
        </div>
         <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg><%=bundle.getString("BOM_BOMObjectiveInformationList")%></td>
            </tr>
        </table>
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
       <table class=common name='table1' colNum='3'>
         <TR>
				   <TD  class= title align="center" valign="middle"><%=bundle.getString("BOM_CalculationSQL")%></TD>
		           <td colspan="3"><textarea class = 'common' name="sql"  rows="3" style='width:90%'></textarea> </td>
		      </TR>
		      </table>
      
     
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
     <iframe id='downloadframe' height=0,width=0 />
</body>
</html>