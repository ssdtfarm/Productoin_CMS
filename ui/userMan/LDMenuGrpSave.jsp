<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.schema.LDMenuGrpSchema"%>
<%@page import="com.sinosoft.lis.userMan.*"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun"%>
<%
//获取登录信息
GlobalInput tG = new GlobalInput();
tG=(GlobalInput)session.getValue("GI");
//System.out.println("start jsp");
//输入参数
String FlagStr = "Fail";
String Content = "";
String actionStr = request.getParameter("Action");
//System.out.println("actionStr:" + actionStr);
int action = -1;
if (actionStr.compareTo("query") == 0)
	action = 2;
if (actionStr.compareTo("insert") == 0)
	action = 0;
if (actionStr.compareTo("update") == 0)
	action = 1;
if (actionStr.compareTo("delete") == 0)
	action = 3;
//System.out.println("action num: " + action);

switch (action)
{
	case 1:
	
	case 0:  
		//insert
		String Operator = request.getParameter("Operator");
		String MenuGrpCode = request.getParameter("MenuGrpCode");
		String MenuGrpName = request.getParameter("MenuGrpName");
		String MenuSign = request.getParameter("MenuSign");
		String MenuGrpDescription = request.getParameter("MenuGrpDescription");
		String DepartMent = request.getParameter("DepPartMent");
		String Team = request.getParameter("Team");

		String menuSetString = request.getParameter("hideString");
//		System.out.println("menuSetString : " + menuSetString);
		String removeSetString = request.getParameter("hideRemoveString");
//		System.out.println("hideRemoveString is " + removeSetString);
		//保存到schema中，供下次使用
		LDMenuGrpSchema tGrpSchema = new LDMenuGrpSchema();
		tGrpSchema.setMenuGrpCode(MenuGrpCode);
		tGrpSchema.setMenuGrpName(MenuGrpName);
		tGrpSchema.setMenuGrpDescription(MenuGrpDescription);
		tGrpSchema.setMenuSign(MenuSign);
		tGrpSchema.setOperator(Operator);
		tGrpSchema.setDepartMent(DepartMent);
		tGrpSchema.setTeam(Team);
		String curDate = PubFun.getCurrentDate();
		String curTime = PubFun.getCurrentTime();
		tGrpSchema.setMakeTime(curTime);
		tGrpSchema.setMakeDate(curDate);

		LDMenuGrpUI tLDMenuGrpUI = new LDMenuGrpUI();
		VData tData = new VData();
		tData.add(menuSetString);
		tData.add(removeSetString);
		tData.add(tGrpSchema);
		tData.add(tG);
		if (tLDMenuGrpUI.submitData(tData,actionStr))
			FlagStr = "success";
		else
			FlagStr = "fail";
//		System.out.println("FlagStr : " + FlagStr);
		break;

	case 2:
		FlagStr = "success";
		break;

	case 3:
//		System.out.println("here");
		LDMenuGrpSchema dGrpSchema = new LDMenuGrpSchema();
		//获取前台数据
		String menuGrpCode = request.getParameter("MenuGrpCode");
		String menuGrpName = request.getParameter("MenuGrpName");
		String menuGrpSign = request.getParameter("MenuSign");
		String menuGrpDes = request.getParameter("MenuGrpDescription");
		String departMent = request.getParameter("DepPartMent");
		String team = request.getParameter("Team");
		//赋值
		dGrpSchema.setMenuGrpCode(menuGrpCode);
		dGrpSchema.setMenuGrpName(menuGrpName);
		dGrpSchema.setMenuGrpDescription(menuGrpDes);
		dGrpSchema.setMenuSign(menuGrpSign);
		dGrpSchema.setDepartMent(departMent);
		dGrpSchema.setTeam(team);
		//调用处理的UI处理
		LDMenuGrpUI dLDMenuGrpUI = new LDMenuGrpUI();
		tData = new VData();
		tData.add(dGrpSchema);
		tData.add(tG);
		//处理删除的数据
		if (dLDMenuGrpUI.submitData(tData,actionStr))
			FlagStr = "success";
		else
			FlagStr = "fail";
		break;
}
//System.out.println(FlagStr);
//System.out.println("end of jsp");
%>
<script>
parent.fraInterface.afterSubmit("<%=FlagStr%>");
</script>