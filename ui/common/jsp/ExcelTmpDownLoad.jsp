<%@include file="../jsp/UsrCheck.jsp"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun"%>
<%	
	response.reset();
    String attachName = request.getParameter("downloadPath");
    //String path ="/template/" + attachName;
    ExeSQL tExeSQL=new ExeSQL();
    String path =("/"+tExeSQL.getOneValue("select SysvarValue from ldsysvar where sysvar = 'ImportPath'")+"/").replace("//", "/") + attachName;
	response.setContentType("application/octet-stream");
	//String attachName = "PerAdd.xls";
  	response.setHeader("Content-Disposition","attachment; filename="+ new String(attachName.getBytes(),"ISO8859-1"));      

	out.clear();
	out = pageContext.pushBody();
	try {
		OutputStream os = response.getOutputStream();		
		FileInputStream fis = PubFun.createFileInputStream(application.getRealPath("/")+path);
		byte[] b = new byte[1024];
		int i = 0;
		while ((i = fis.read(b)) > 0) {
			os.write(b, 0, i);
		}
		fis.close();
		os.flush();
		os.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
