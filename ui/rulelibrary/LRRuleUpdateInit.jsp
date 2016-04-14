<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");    
	String WageCode = request.getParameter("WageCode");
	String IndexCode = request.getParameter("IndexCode");
	
	WageCode=ESAPI.encoder().encodeForJavaScript(WageCode);
	IndexCode=ESAPI.encoder().encodeForJavaScript(IndexCode);
	
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();
        var strSQL="select IndexCode,IndexName,BranchType,Description,DataType,(select codename from ldcode where LRAssessIndexLibrary.DataType=code and codetype = 'ibrmscommandtype' ),CalType,(select codename from ldcode where LRAssessIndexLibrary.CalType=code and codetype = 'logic' ),state from LRAssessIndexLibrary where IndexCode='<%=IndexCode%>' and WageCode ='<%=WageCode%>' ";
        var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
		var s=decodeEasyQueryResult(strQueryResult);
		if(s){
			fm.all("IndexCode").value=s[0][0];
	        fm.all("WageCode").value='<%=WageCode%>';
	        fm.all("IndexName").value=s[0][1];
	        fm.all("BranchType2").value=s[0][2];
	        fm.all("Description").value=s[0][3];
	        fm.all("DataType").value = s[0][4];    
	        fm.all("RemarkName").value = s[0][5]; 
	        fm.all("LogicType").value = s[0][6];
	        fm.all("LogicTypeName").value = s[0][7];
	        fm.all("State").value = s[0][8];
		}
		strSQL  = "select 1 from lrassessindexp where indexcode = '"+s[0][0]+"'";
		var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
		var s=decodeEasyQueryResult(strQueryResult);
		if(s){
			fm.DataType.disabled=true;
		    fm.LogicType.disabled=true;
		}
	    
		showOneCodeName('yesno', 'State', 'EndFlagName');
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LRRuleUpdateInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initfm(){
    try{
        initInpBoxfm();
    }catch(re){
        alert("LAAgentInputInit.jsp-->InitFormfm"+I18NMsg('Alert_InitJspError'));
    }
}

</script>
