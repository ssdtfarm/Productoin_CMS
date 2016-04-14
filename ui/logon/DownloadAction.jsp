<%@include file="/i18n/language.jsp"%>

<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.net.URLEncoder"/>
<jsp:directive.page import="java.io.File"/>
<jsp:directive.page import="java.io.OutputStream"/>
<jsp:directive.page import="java.io.FileInputStream"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head> 
     <title><%=bundle.getString("G0000025647")%></title>
     <script src="inform.js"></script>
    
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<!--
	<%=bundle.getString("waitForTran")%>

-->
	<script language="JavaScript">
		function say(info)
		{
			myAlert(info);
		}
	</script>

   </head>
  
   <body>
     <%

      //    System.out.println("path="+request.getRealPath("/filedownload/鐗堟湰鍙戝竷娴佺▼鍒跺害.zip").toString());
      int i = 0;
      byte[] b = new byte[1024];
      OutputStream out1 = null;
      FileInputStream fis = null;
      File file=null;
      String fileName=null;
     
      
	  String url = request.getParameter("url");
	  if(url.equalsIgnoreCase("operation"))
	  		{
	  			//if(request.getRealPath("/filedownload/绯荤粺浣跨敤鎵嬪�?rar").)
	  			file = new File(request.getRealPath(""+bundle.getString("G0000025648")+"").toString());
	  			fileName=""+bundle.getString("G0000025649")+"";
	  		}
	  else
	  if(url.equalsIgnoreCase("filetemplete"))
	  		{
	  			file = new File(request.getRealPath(""+bundle.getString("G0000025650")+"").toString());
	  			if(file.isFile())
	  				fileName=""+bundle.getString("G0000025651")+"";
	  		}
	  else
	  
	  if(url.equalsIgnoreCase("manager"))
	  		{
	  			file = new File(request.getRealPath(""+bundle.getString("G0000025652")+"").toString());
	  			fileName=""+bundle.getString("G0000025653")+"";
	  		}
	  else
	  	   fileName=""+bundle.getString("G0000025654")+"";

	  if(!file.isFile())
	  {
	  	%>
	  	   <script>alert("<%=bundle.getString("G0000025655")%>
	  	   			showOpenWindow();
	  	   </script><%=bundle.getString("G0000025656")%>
	  	<%
	  }
	  else
	 	{ response.setContentType("application/x-download");
	  		fileName = URLEncoder.encode(fileName,"UTF-8");
			response.setHeader("content-disposition", "attachment;filename=\""
					+ new String(fileName
							.getBytes(), response.getCharacterEncoding())
					+ "\"");

      
      try{
       fis = new FileInputStream(file);
       out1 = response.getOutputStream();
       while((i = fis.read(b)) > 0){
        out1.write(b, 0, i);
       }
      }catch(Exception e){
       e.printStackTrace();
      } finally {
       try{
        fis.close();
        out1.flush();
        out1.close();
       }catch(Exception e){}
      }
      }
     %>
   </body>
</html>

