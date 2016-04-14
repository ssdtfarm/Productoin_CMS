<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
	String remark = request.getParameter("remark");
	
	id=ESAPI.encoder().encodeForJavaScript(id);
	name=ESAPI.encoder().encodeForJavaScript(name);
	remark=ESAPI.encoder().encodeForJavaScript(remark);
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();        
        //alert('<%=id%>');
        fm.all('ID').value='<%=id%>';        
        var strSQL = "select name,remark,BranchType,state from lrbom where id ='"+fm.all("ID").value+"'";        
		var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
		var s=decodeEasyQueryResult(strQueryResult);
		if(s){

	        fm.all('Name').value=s[0][0];
	        fm.all('Remark').value=s[0][1];
	        fm.all('BranchType').value=s[0][2];
	        fm.all('BranchType1').value=s[0][2];
	        fm.all('State').value=s[0][3];
		}
        fm.all('BranchType1').disabled=true;
        showOneCodeName('BranchType', 'BranchType1', 'BranchTypeName');
        showOneCodeName('yesno', 'State', 'EndFlagName');
        //alert(fm.all('ID').value);
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LRBomUpdateInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
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
