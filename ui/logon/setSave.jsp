
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.hxlife.update.UpdateLog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>

<%
  String time= new String(request.getParameter("time").getBytes("iso8859_1"),"UTF-8");
  String str= new String(request.getParameter("ta").getBytes("iso8859_1"),"UTF-8");
  str.trim();
  //System.out.println(str);
 // str+=time;
  
  if(new UpdateLog().fileWrite(str,time))
  {
%><script type="text/javascript">
         myAlert("<%=bundle.getString("G0000025805")%>");
       </script>
       <%
  }
  else{
       %><script type="text/javascript">
         myAlert("<%=bundle.getString("G0000025806")%>");
       </script>
       <%
  }
%>
<body>
 <script type="text/javascript">
   window.location.href="main.jsp";
 </script>
</body>
</html>