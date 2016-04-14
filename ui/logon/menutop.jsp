<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>

<%@ page  pageEncoding="UTF-8" contentType='text/html;charset=utf-8'  %>
<html>
<head>
<script language="JavaScript">
function hidemenu(){
	if(parent.fraSet.cols=="250,*,0%"){
		parent.fraSet.cols = "0%,*,0%";
		parent.fraQuick.document.all("menushow").style.display = "";
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 椤甸潰鏍峰紡  -->
<link rel='stylesheet' type='text/css' href='../common/css/other.css'>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0" oncontextmenu=self.event.returnValue=false>
<table width="100%" height="25" cellspacing="0">
  <tr>
    <th width="79%" align=center><font color="#FFFFFF">欢迎登陆</font></th>
    <th width="21%" align="left"><img  src="../common/images/t_close.gif" width="70" height="13" id="imgHideToc" style="cursor:hand" title="<%=bundle.getString("waitForTran")%>" onclick="hidemenu();" /></th>
	</tr>
	</table>
</body>
</html>
