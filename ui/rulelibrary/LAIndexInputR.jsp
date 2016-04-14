<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<%
	String BaseCode = request.getParameter("BaseCode");
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
	<script type="text/javascript" src="./LAIndexDefInputR.js" charset='UTF-8'></script>
</head>
<body  onload="">
			<div >
			   <ul id="menu" class="tree"></ul>
			</div>	
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
    <div id='info' style='display:none;' title="<%=bundle.getString("Promptmessage")%>"><%=bundle.getString("BOM_Processing,pleasewait…")%></div>
    <form name=fm>
    	<input type="hidden" name="BaseCode" value ='B00040'/>
    </form>
</body>
</html>