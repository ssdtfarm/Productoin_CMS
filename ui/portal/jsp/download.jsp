<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@page import="java.io.BufferedInputStream" %>
<%@page import="java.io.File" %>
<%@page import="java.io.FileInputStream" %>
<%@page import="java.io.IOException" %>
<%@page import="java.io.InputStream" %>
<%@page import="java.io.OutputStream" %>

<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpSession" %>

<%!
public void download(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession session = request.getSession();
	String filepath = (String) session.getAttribute("filepath");
	String filename = (String) session.getAttribute("filename");
	if (filepath == null || filepath.equals("")) {
		String msg = "********************** Filepath not exists! *****************************";
		return ;
	}
	if(filename == null || "".equals(filename)) {
		File file = new File(filepath);
		filename = file.getName();
	}
	File file = new File(filepath);
	if (!file.exists()) {
		String msg = "********************** File not exists! *****************************";
		return ;
	}
	OutputStream out = null;
	InputStream is = null;
	try {
		String contentType = "application/octet-stream;charset=utf-8";
		response.setContentType(contentType);
		StringBuffer contentDisposition = new StringBuffer();
		filename = java.net.URLEncoder.encode(filename, "UTF-8");
		contentDisposition.append("attachment;filename=");
		contentDisposition.append(filename);
		response.setHeader("Content-Disposition", new String(
		contentDisposition.toString().getBytes(
				System.getProperty("file.encoding")), "iso-8859-1"));
		//log.info("filepath=" + filepath);
		out = response.getOutputStream();
		out.flush();

		byte[] bytes = new byte[4 * 1024];
		is = new BufferedInputStream(new FileInputStream(filepath));
		int b = -1;
		while ((b = is.read(bytes)) > -1) {
			out.write(bytes, 0, b);
		}
		out.flush();
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "********************** IOException occured! *****************************";
	} finally {
		try {
			if (out != null)
				out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (is != null)
				is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//清空session中的文件信息，以免恶意刷新
	session.removeAttribute("filepath");
	session.removeAttribute("filename");
}
%>

