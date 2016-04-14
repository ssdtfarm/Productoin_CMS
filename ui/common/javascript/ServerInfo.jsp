<%@include file="../jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%><%@page import="com.sinosoft.lis.pubfun.*"%><%String serverDate =  PubFun.getCurrentDate();  String serverTime = PubFun.getCurrentTime();
      out.print(serverDate+"|"+serverTime);%>