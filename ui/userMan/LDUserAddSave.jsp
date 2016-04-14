<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>

<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.schema.LDUserSchema"%>
<%@page import="com.sinosoft.lis.schema.LDUserTOMenuGrpSchema"%>
<%@page import="com.sinosoft.lis.vschema.LDUserTOMenuGrpSet"%>
<%@page import="com.sinosoft.lis.userMan.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String FlagStr = "Fail";
	String Content = "";
	String action = request.getParameter("Action");
	System.out.println(action);
	String Result = "";
	//20110311号，现在只处理用户信息，不处理其他信息
	if (action.compareTo("update") == 0
			|| action.compareTo("insert") == 0) {
		LDUserSchema userSchema = new LDUserSchema();
		userSchema.setUserCode(request.getParameter("UserCode"));
		userSchema.setUserName(request.getParameter("UserName"));
		// this must be encrypted
		userSchema.setPassword(request.getParameter("Password").trim());
		userSchema.setComCode(request.getParameter("ComCode"));
		userSchema.setMakeDate(request.getParameter("MakeDate"));
		userSchema.setMakeTime(request.getParameter("MakeTime"));
		userSchema.setUserDescription(request
				.getParameter("UserDescription"));
		userSchema.setUserState(request.getParameter("UserState"));
		userSchema.setUWPopedom(request.getParameter("UWPopedom"));
		userSchema.setEdorPopedom(request.getParameter("EdorPopedom"));
		userSchema
				.setClaimPopedom(request.getParameter("ClaimPopedom"));
		userSchema
				.setOtherPopedom(request.getParameter("OtherPopedom"));
		userSchema.setPopUWFlag(request.getParameter("PopUWFlag"));
		userSchema.setSuperPopedomFlag(request
				.getParameter("SuperPopedomFlag"));
		userSchema.setOperator(request.getParameter("Operator"));
		userSchema.setValidStartDate(request
				.getParameter("ValidStartDate"));
		userSchema
				.setValidEndDate(request.getParameter("ValidEndDate"));
		userSchema.setAgentCom(request.getParameter("AgentCom"));
		String operator = request.getParameter("OperatorCode"); //得到正在操作的操作员
		VData tData = new VData();
		tData.add(userSchema);
		tData.add(operator);
		LDUserOpeUI tLDUserOpeUI = new LDUserOpeUI();
		if (!tLDUserOpeUI.submitData(tData, action)) {
			Content = " "+bundle.getString("saveFaild")+":"
					+ tLDUserOpeUI.mErrors.getFirstError();
			FlagStr = "Fail";
		} else {
			Content = bundle.getString("saveSucc");
			FlagStr = "Succ";
		}
	} else {
		FlagStr = "Fail";
		Content = ""+bundle.getString("waitForTran")+"";
	}
	FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
	Content=ESAPI.encoder().encodeForJavaScript(Content);
%>
<script>
parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
</script>
