<%@include file="/i18n/language.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>

<head>
  <script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
  <script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
  <script src="../common/javascript/Common.js" charset="UTF-8"></script>
  <script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <script src="./MenuSettingInput.js" charset="UTF-8"></script>
  <%@include file="./MenuSettingInit.jsp"%>
</head>

<body onload="initForms();initElementtype();">
    
    <form action="../common/jsp/ExcelDataImportSave.jsp?uiPath=com.sinosoft.lis.AgentManagement.AlertListManagementImportBL" method=post name=fm_import target="fraSubmit">
    <%--说明1：  uiPath=com.sinosoft.lis.sys.LACampaignCfgImportBL   这个根据实际情况来调整，来设定save页面需要提交到的后台java --%>
    	<table>
    		<tr>
    			<td><IMG src="../common/images/butExpand.gif" style="cursor:hand;" 
    				OnClick="showPage(this,divCom2);"></td>
    			<td class=titleImg><%=bundle.getString("Text_FileImport")%></td>
    		</tr>
    	</table>
    	<Div id="divCom2" style="display: ''">
    		<table class=common border=0>
    			<TR class=common>
    				<TD width=60><%=bundle.getString("Text_ImportFile")%>:</TD>
    				<TD class=common align=left>
    					<input type=hidden name=ImportPath value='upload/'> 
    					<Input type="file" name=FileName size=30> 
    					<INPUT class=cssButton VALUE="<%=bundle.getString("Btn_Upload")%>" TYPE=button onclick="submitImport();">
    					&nbsp;&nbsp;&nbsp;&nbsp; 
    					<a href='../common/jsp/ExcelTmpDownLoad.jsp?downloadPath=AlertListImport.xlsx'>
    <%--说明2：  template=bank/LACampaignImport_templet   这个根据实际情况来调整下载模板，默认 ui/template/+template --%>
    						<%=bundle.getString("Btn_DownloadTemplet")%> <img src='../common/css/excelicon.gif' border=1></a>
    					&nbsp;&nbsp;&nbsp;&nbsp;</TD>
    			</TR>
    		</table>
    	</Div>
    </form>
    	<div id="errorMsgList"></div>
    <%--说明3：  id="errorMsgList"   默认，若导入失败，用来在前台页面展示错误信息，不需要修改 --%>
    
    <form name=fm method=post target="fraSubmit" action="./MenuSettingSave.jsp">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div1);"></td>
                <td class=titleImg>Menu Setting</td>
            </tr>
        </table>
        <div id='div1' style="display: ''">
            <table class=common name='table1' colNum='2'>
                <tr>
                <input class="cssButton" buttonname='btn_Refresh' value="Refresh" type="button" onclick="return Refresh();"/>
                <input class="cssButton" buttonname='btn_Export' value="Export" type="button" onclick="return Export();"/>
                <input class="cssButton" buttonname='btn_Backup' value="Backup" type="button" onclick="return Backup();"/>
                <input class="cssButton" buttonname='btn_BackupQuery' value="Backup Query" type="button" onclick="return BackupQuery();"/>
                </tr>
            </table>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
        <input type="hidden" name="lang" />
    	<span id="spanCode"  style="display: none; position:absolute; slategray"></span>
    </form>
    
</body>
</html>