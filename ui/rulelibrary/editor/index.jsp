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
	System.out.println("-----------------------EditMode>"+mEditMode);
	System.out.println("-----------------------BaseCode>"+mBaseCode);
	System.out.println("-----------------------WageCode>"+mWageCode);
	System.out.println("-----------------------IndexCode>"+mIndexCode);
	System.out.println("-----------------------AgentGrade>"+mAgentGrade);
	System.out.println("-----------------------IndexType>"+mIndexType);
	System.out.println("-----------------------State>"+mState);
	String lang = session.getAttribute("locale").toString();
	String fileName ="";
	if("zh_CN".equals(lang)){
		fileName = "editor_cn.js";
	}else if("zh_TW".equals(lang)){
		fileName = "editor_tr.js";
	}else if("en".equals(lang)){
		fileName = "editor_en.js";
	}else{
		fileName = "editor_en.js";
	}
	//String fileName = "editor_tr.js";
	System.out.println("-----------------------12>"+lang);
	System.out.println("-----------------------12>"+mIndexType);
	System.out.println("-----------------------12>"+fileName);
	
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
