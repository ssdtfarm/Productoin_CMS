<%@include file="../common/jsp/UsrCheck.jsp"%>

<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
  String root2=request.getContextPath();
  String myInformHeight = "";
  String myInformWidth = "";
  String myInformLeft = "";
  String myInformTop =  "";
%>

<script type="text/javascript" charset="UTF-8">
	/* var myInformLeft=100;
        var myInformTop=100;*/

      <%
    
            myInformHeight = "550";
            myInformWidth = "400";
            myInformLeft = "20";
            myInformTop = "30";
        %>
        var myInformHeight=<%=myInformHeight%>;
        var myInformWidth=<%=myInformWidth%>;
        var myInformLeft=<%=myInformLeft%>;
        var myInformTop=<%=myInformTop%>;

	//var openKSty="toolbar=no,location=no,directories=no,status=no,menub ar=no,scrollbar=no,resizable=no,copyhistory=yes,left="+ myInformLeft +",top="+ myInformTop +",width="+ myInformWidth +",height="+myInformHeight;
        var openWindowSty="dialogLeft:"+myInformLeft+"px;dialogTop:"+myInformTop+"px;dialogWidth:"+myInformWidth+"px;dialogHeight:"+myInformHeight+"px;status:no";
        var openUrl="";
        winObj= showModalDialog(openUrl, window, openWindowSty);
          <%
      %>
</script>


