<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>

<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.schema.LDUserSchema"%>
<%@page import="com.sinosoft.lis.schema.LDUserTOMenuGrpSchema"%>
<%@page import="com.sinosoft.lis.vschema.LDUserTOMenuGrpSet"%>
<%@page import="com.sinosoft.lis.userMan.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
String FlagStr = "false";
String action = request.getParameter("Action");
System.out.println(action);
String Result = "";

if (action.compareTo("query") == 0)
{
	LDUserSchema userSchema = new LDUserSchema();
	String tComCode=request.getParameter("ComCode");
	userSchema.setUserCode(request.getParameter("UserCode"));
	userSchema.setComCode(request.getParameter("OperatorComCode"));
	if(!tComCode.equals(""))
	{
	userSchema.setComCode(tComCode);
	}
	userSchema.setAgentCom(request.getParameter("AgentCom"));
	userSchema.setUserName(request.getParameter("UserName"));
	VData tData = new VData();
	tData.add(userSchema);
	LDUserManUI tLDUserManUI = new LDUserManUI();
	if (tLDUserManUI.submitData(tData,action))
	{
		FlagStr = "true";
		Result = (String)tLDUserManUI.getResult().get(0);
	}
	else
	{
		FlagStr = "false";
	}
}
if (action.compareTo("update") == 0 || action.compareTo("insert") == 0)
{
	LDUserSchema userSchema = new LDUserSchema();
	userSchema.setUserCode(request.getParameter("UserCode"));
	userSchema.setUserName(request.getParameter("UserName"));
	// this must be encrypted
	userSchema.setPassword(request.getParameter("Password"));
	userSchema.setComCode(request.getParameter("ComCode"));
	userSchema.setMakeDate(request.getParameter("MakeDate"));
	userSchema.setMakeTime(request.getParameter("MakeTime"));
	userSchema.setUserDescription(request.getParameter("UserDescription"));
	userSchema.setUserState(request.getParameter("UserState"));
	userSchema.setUWPopedom(request.getParameter("UWPopedom"));
	userSchema.setEdorPopedom(request.getParameter("EdorPopedom"));
	userSchema.setClaimPopedom(request.getParameter("ClaimPopedom"));
	userSchema.setOtherPopedom(request.getParameter("OtherPopedom"));
	userSchema.setPopUWFlag(request.getParameter("PopUWFlag"));
	userSchema.setSuperPopedomFlag(request.getParameter("SuperPopedomFlag"));
	userSchema.setOperator(request.getParameter("Operator"));
	userSchema.setValidStartDate(request.getParameter("ValidStartDate"));
	userSchema.setValidEndDate(request.getParameter("ValidEndDate"));
	userSchema.setAgentCom(request.getParameter("AgentCom"));
	LDUserTOMenuGrpSchema userToMenuGrpSchema = new LDUserTOMenuGrpSchema();
	String tGrid1[] = request.getParameterValues("HideMenuGrpGrid11");
	String tGrid2[] = request.getParameterValues("HideMenuGrpGrid12");
	String tGridNo[] = request.getParameterValues("HideMenuGrpGrid1No");
	LDUserTOMenuGrpSet tSet = new LDUserTOMenuGrpSet();
	//新增的用户有菜单组
	if (tGridNo != null)
	{
		int Count = tGridNo.length; //得到接受到的记录数
		LDUserTOMenuGrpSchema tSchema;
		String UserCode = request.getParameter("UserCode");
		for(int index=0;index< Count;index++)
		{
			tSchema = new LDUserTOMenuGrpSchema();
			tSchema.setUserCode(tGrid1[index]);
			tSchema.setMenuGrpCode(tGrid2[index]);
			tSet.add(tSchema);
		}
	}
	String operator = request.getParameter("OperatorCode"); //得到正在操作的操作员
	VData tData = new VData();
	tData.add(tSet);
	tData.add(userSchema);
	tData.add(operator);
	LDUserManUI tLDUserManUI = new LDUserManUI();
	if (tLDUserManUI.submitData(tData,action))
		FlagStr = "true";
}
if (action.compareTo("delete") == 0)
{
	LDUserSchema tUserSchema = new LDUserSchema();
	//取得指定的的待删除用户
	String tRadio[] = request.getParameterValues("InpUserGridSel");
	String tUserCode[] = request.getParameterValues("UserGrid2");
	int index = 0;
	for (; index< tRadio.length;index++)
	{
		if(tRadio[index].equals("1"))
			break;
	}
	//没有选中对象
	if (index == tRadio.length)
	{
		System.out.println("未找到选中对象");
	}
	else
	{
		String userCode = tUserCode[index];
		//删除者编码
		String deletor = request.getParameter("OperatorCode");
		tUserSchema.setUserCode(userCode);
		VData tData = new VData();
		tData.add(tUserSchema);
		tData.add(deletor);
		LDUserManUI tLDUserManUI = new LDUserManUI();
		if (tLDUserManUI.submitData(tData,action))
			FlagStr = "true";
	}
}
FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
Result=ESAPI.encoder().encodeForJavaScript(Result);
%>
<script>
	parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Result%>");
</script>