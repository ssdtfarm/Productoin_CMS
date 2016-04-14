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
//接收数据
	GlobalInput tG = new GlobalInput();
	tG=(GlobalInput)session.getValue("GI");
	String FlagStr = "Fail";
	String action = request.getParameter("Action");
	System.out.println(action);
	String Result = "";
	//更新菜单组信息
	if (action.compareTo("update") == 0)
	{
		LDUserSchema userSchema = new LDUserSchema();
		userSchema.setUserCode(request.getParameter("UserCode"));
		userSchema.setUserName(request.getParameter("UserName"));
		// this must be encrypted
		userSchema.setComCode(request.getParameter("ComCode"));
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
	//		System.out.println("Count:" + Count);
			LDUserTOMenuGrpSchema tSchema;
			String UserCode = request.getParameter("UserCode");
	//		System.out.println("UserCode="+UserCode);
			for(int index=0;index< Count;index++)
			{
				tSchema = new LDUserTOMenuGrpSchema();
				tSchema.setUserCode(UserCode);
				tSchema.setMenuGrpCode(tGrid2[index]);
	//			System.out.println("UserCode" + tGrid1[index]);
	//			System.out.println("MenuGrpCode" + tGrid2[index]);
				tSet.add(tSchema);
			}
		}
		VData tData = new VData();
		tData.add(tSet);
		tData.add(userSchema);
		tData.add(tG);
		LDUsertoMenuGrpUI tLDUsertoMenuGrpUI = new LDUsertoMenuGrpUI();
		if (!tLDUsertoMenuGrpUI.submitData(tData,action)){
			Result = "保存失败！原因是："+tLDUsertoMenuGrpUI.mErrors.getFirstError();
			FlagStr = "Fail";
		}else{
			FlagStr = "Succ";
			Result = ""+bundle.getString("saveSucc")+"";
		}
	}
	FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
	Result=ESAPI.encoder().encodeForJavaScript(Result);
%>
<script>
parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Result%>");
</script>
