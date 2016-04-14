<%@include file="../../common/jsp/UsrCheck.jsp"%>
<!DOCTYPE html>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String mEditMode = request.getParameter("EditMode");
	String mBaseCode = request.getParameter("BaseCode");
	String mWageCode = request.getParameter("WageCode");
	String mIndexCode = request.getParameter("IndexCode");
	String mAgentGrade = request.getParameter("AgentGrade");
	String mIndexType = request.getParameter("IndexType");
	String mState = request.getParameter("State");
	if(mEditMode == null || mEditMode.trim().equals("")){
		mEditMode = "edit";
	}
	if(mWageCode == null || mWageCode.trim().equals("")){
		mWageCode = "";
	}
	if(mIndexCode == null || mIndexCode.trim().equals("")){
		mIndexCode = "";
	}
	if(mAgentGrade == null || mAgentGrade.trim().equals("")){
		mAgentGrade = "";
	}
	if(mState == null || mState.trim().equals("")){
		mState = "";
	}
	if(mIndexType == null || mIndexType.trim().equals("")){
		mIndexType = "";
	}
	String fileName = "editor_enR.js";
	
	String lang = session.getAttribute("locale").toString();
	if("zh_CN".equals(lang)){
		fileName = "editor_cnR.js";
	}else if("zh_TW".equals(lang)){
		fileName = "editor_trR.js";
	}else if("en".equals(lang)){
		fileName = "editor_enR.js";
	}else{
		fileName = "editor_enR.js";
	}
	System.out.println("-----------------------12>"+mIndexType);
	mEditMode = ESAPI.encoder().encodeForJavaScript(mEditMode);
	mBaseCode = ESAPI.encoder().encodeForJavaScript(mBaseCode);
	mWageCode = ESAPI.encoder().encodeForJavaScript(mWageCode);
	mIndexCode = ESAPI.encoder().encodeForJavaScript(mIndexCode);
	mAgentGrade = ESAPI.encoder().encodeForJavaScript(mAgentGrade);
	mIndexType = ESAPI.encoder().encodeForJavaScript(mIndexType);
	mState = ESAPI.encoder().encodeForJavaScript(mState);
	fileName = ESAPI.encoder().encodeForJavaScript(fileName);
%>
<html>

<head>
	<script type="text/javascript">
  	var _fresh = false;
  </script>
  <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
  <title>editor</title>
  <script src="../../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="jquery.json.js" type="text/javascript" charset="UTF-8"></script>
  <script src="agility.js" type="text/javascript" charset="UTF-8"></script>
  <script type="text/javascript">
  	var editMode = '<%=mEditMode%>';
  	var basecode = '<%=mBaseCode%>';
  	var wagecode = '<%=mWageCode%>';
  	var indexcode = '<%=mIndexCode%>';
  	var agentgrade = '<%=mAgentGrade%>';
  	var indextype  = '<%=mIndexType%>';
  	var state = '<%=mState%>';
  </script>
</head>

<body>
  <script src=<%=fileName %> type="text/javascript" charset="UTF-8"></script>

</body>

</html>
