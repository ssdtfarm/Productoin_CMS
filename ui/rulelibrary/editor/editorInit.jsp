<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();
    }catch(ex){
        alert("<%=bundle.getString("G0000028403")%>-->"+"<%=bundle.getString("G0000032793")%>");
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("<%=bundle.getString("G0000035921")%>-->"+"<%=bundle.getString("G0000035680")%>");
    }
}
function initfm(){
    try{
        initInpBoxfm();
    }catch(re){
        alert("LAAgentInputInit.jsp-->"+"<%=bundle.getString("G0000035681")%>");
    }
}

</script>
