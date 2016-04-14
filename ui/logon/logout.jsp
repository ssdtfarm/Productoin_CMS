
<%@page pageEncoding="UTF-8" contentType='text/html;charset=utf-8'  %>
<%@page import="com.sinosoft.lis.pubfun.GlobalInput"%>
<%@page import="com.sinosoft.utility.VData"%>
<%@page import="com.sinosoft.lis.logon.logoutUI"%>
<%@page import="java.util.Enumeration"%>
<%
try {
	GlobalInput tG1 = new GlobalInput();
	tG1 = (GlobalInput)session.getValue("GI");
	VData inputData = new VData();
	inputData.addElement(tG1);
	logoutUI tlogoutUI = new logoutUI(); 
	tlogoutUI.submitData(inputData,"LogOutProcess");
	Enumeration e=session.getAttributeNames(); 
	while(e.hasMoreElements()){ 
		String sessionName=(String)e.nextElement(); 
		System.out.print("存在的session有："+sessionName); 
		session.removeAttribute(sessionName); 
		System.out.println("----已清除"); 
	}
    session.invalidate();
    System.out.println("销毁 session, 退出系统 ****************************************");
}
catch (Exception exception)
{
	System.out.println("Log out error ...");
}
%>
<script language=javascript>
session = null;
top.window.location ="../indexlis.jsp";
</script>  