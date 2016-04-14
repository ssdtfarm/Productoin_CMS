<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
    String BaseCode = request.getParameter("BaseCode");
    String AgentGrade = request.getParameter("AgentGrade");
    String WageCode = request.getParameter("WageCode");
    String IndexType = request.getParameter("IndexType");
	String BranchType = request.getParameter("BranchType");
	
	BaseCode=ESAPI.encoder().encodeForJavaScript(BaseCode);
	AgentGrade=ESAPI.encoder().encodeForJavaScript(AgentGrade);
	WageCode=ESAPI.encoder().encodeForJavaScript(WageCode);
	IndexType=ESAPI.encoder().encodeForJavaScript(IndexType);
	BranchType=ESAPI.encoder().encodeForJavaScript(BranchType);
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();
        fm.BaseCode.value = '<%=BaseCode%>';  
        fm.IndexType.value = '<%=IndexType%>';
        fm.BranchType.value = '<%=BranchType%>';
        if('null'!='<%=AgentGrade%>'){
        	fm.AgentGrade.value = '<%=AgentGrade%>'; 
        }
        if('null'!='<%=WageCode%>'){
        	fm.WageCode.value = '<%=WageCode%>';
        }
        showCodeName("indexflg","IndexTypeName");
        showCodeName("baseversion","BaseCode");
        showCodeName("agentgrade","AgentGrade");
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LAWageInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
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
