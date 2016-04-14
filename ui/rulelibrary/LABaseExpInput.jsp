<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String BaseCode = request.getParameter("BaseCode");
	String EdorNo = request.getParameter("EdorNo");
	
	BaseCode=ESAPI.encoder().encodeForJavaScript(BaseCode);
	EdorNo=ESAPI.encoder().encodeForJavaScript(EdorNo);
	
	System.out.println("history search---"+BaseCode);
	System.out.println("EdorNo---"+EdorNo);
%>
<head>
  <script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
  <script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
  <script src="../common/javascript/Common.js" charset="UTF-8"></script>
  <script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
  <script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <link rel="stylesheet" href="./iCandy/zTreeIcons.css" type="text/css" charset='UTF-8'/> 
  <link rel="stylesheet" href="./iCandy/zTreeStyle.css" type="text/css"/>
  <script type="text/javascript" src="../common/javascript/jquery.js"></script>
  <script type="text/javascript" src="../common/javascript/jquery-ui.js"></script>
  <script type="text/javascript" src="../common/javascript/jquery.ztree.js" charset='UTF-8'></script>
  <script type="text/javascript" src="./LAIndexDefExpInput.js" charset='UTF-8'></script>
</head>
<body  onload=""> 	
    <form name=fm action='./LAIndexExpSave.jsp'  method=post target="fraSubmit" >
    	<div style="width:300px; overflow:auto; position:absolute;margin-top:-1px;border-right:1px gray solid;height:738px;">
 			<div id='tree' style='' >
	   			<ul id="menu"   class="tree"></ul>	   			
 			</div>
 			<input  class="cssButton" style="margin-right: 5px;margin-left:150px;"  type="button" value="<%=bundle.getString("Btn_Export")%>" onclick="BaseExp();"/>
	 	</div>	 		
	 	<div id='detail' style="overflow:auto; position:absolute; left:315px;border-left:1px gray solid;z-index:5;display:none;">
	 			<iframe  id='detailTarget' src="" width="800"></iframe>
	 	</div>
	    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
	    <div id='info' style='display:none;' title="Message"><%=bundle.getString("BOM_Processing,pleasewait…")%></div>
    	<input type="hidden" name="BaseCode" value ='<%=BaseCode%>'/>
    	<input type="hidden" name="EdorNo" value ='<%=EdorNo%>'/>
    	<input type="hidden" name="NodeInfo" value =''/>
    </form>
</body>
</html>