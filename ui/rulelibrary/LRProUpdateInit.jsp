<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    String id=request.getParameter("id");
    
    id=ESAPI.encoder().encodeForJavaScript(id);
    gToday=ESAPI.encoder().encodeForJavaScript(gToday);
    
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();
        var strSQL="select WageCode,WageName,BranchType,BranchType2,Description,IndexSerise,WageType,(select codename from ldcode where LRIndex.WageType=code and codetype = 'indexflg' ),(select codename from ldcode where LRIndex.IndexSerise=code and codetype = 'serise' ),"
					+"(select codename from ldcode where LRIndex.BranchType=code and codetype = 'branchtype' ),state from LRIndex where wagecode='<%=id%>'";
        var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
		var s=decodeEasyQueryResult(strQueryResult);
		if(s){	
	        fm.all("WageCode").value=s[0][0];  					
	        fm.all("WageName").value=s[0][1];
	        fm.all("BranchType").value=s[0][2];
	        fm.all("BranchType1").value=s[0][2];
	        fm.all("BranchType2").value=s[0][3];
	        fm.all("IndexSerise").value=s[0][5];
	        fm.all("Description").value=s[0][4];
	        fm.all("WageType").value=s[0][6];
	        fm.all("indexflgName").value= s[0][7];
	        fm.all("SeriseName").value= s[0][8];
	        fm.all("BranchTypeName").value= s[0][9];
	        fm.all("State").value= s[0][10];
      }
		fm.all('BranchType1').disabled=true;
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
        alert("LRProUpdateInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
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
