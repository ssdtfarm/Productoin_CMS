<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    String WageCode= request.getParameter("WageCode");
    
    WageCode=ESAPI.encoder().encodeForJavaScript(WageCode);
    
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();            
        var strSQL = "select branchtype,wagetype,branchtype2 from lrindex where wagecode = '<%=WageCode%>'";        
				var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
				var s=decodeEasyQueryResult(strQueryResult);
				fm.all("BranchType").value = s[0][0];
				fm.all("BranchType2").value = s[0][2];
				fm.all("IndexType").value = s[0][1];
        fm.all("WageCode").value='<%=WageCode%>';
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LRRuleAddInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
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
