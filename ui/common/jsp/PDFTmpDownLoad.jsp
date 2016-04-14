<%@include file="../jsp/UsrCheck.jsp"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun"%>
<%	

	String attachName = URLDecoder.decode(request.getParameter("filename"),"UTF-8");
	String path = URLDecoder.decode(request.getParameter("filepath"),"UTF-8");
	
	response.setContentType("application/octet-stream");
  	response.setHeader("Content-Disposition","attachment; filename="+new String(attachName.getBytes("GB2312"),"ISO-8859-1"));

	out.clear();
	out = pageContext.pushBody();
	try {
		OutputStream os = response.getOutputStream();		
		//FileInputStream fis = new FileInputStream(application.getRealPath("/")+path);
		FileInputStream fis = PubFun.createFileInputStream(path);
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
