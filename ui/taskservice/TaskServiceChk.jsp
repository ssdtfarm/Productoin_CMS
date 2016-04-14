<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>

<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.schema.LDTaskParamSchema"%>
<%@page import="com.sinosoft.lis.schema.LDTaskPlanSchema"%>
<%@page import="com.sinosoft.lis.schema.LDTaskSchema"%>
<%@page import="com.sinosoft.lis.taskservice.*"%>
<%@page import="com.sinosoft.lis.vschema.LDTaskParamSet"%>
<%@page import="com.sinosoft.lis.vschema.LDTaskPlanSet"%>
<%@page import="com.sinosoft.lis.vschema.LDTaskSet"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
String FlagStr="";      //操作结果
String Content = "";    //控制台信息
String tAction = "";    //操作类型：delete update insert
String tOperate = "";   //操作代码

VData tData = new VData();

GlobalInput tGI = new GlobalInput();

LDTaskPlanSchema tLDTaskPlanSchema = new LDTaskPlanSchema();
LDTaskPlanSet tLDTaskPlanSet = new LDTaskPlanSet();
LDTaskParamSchema tLDTaskParamSchema = new LDTaskParamSchema();
LDTaskParamSet tLDTaskParamSet = new LDTaskParamSet();
LDTaskSchema tLDTaskSchema = new LDTaskSchema();
LDTaskSet tLDTaskSet = new LDTaskSet(); 

tLDTaskPlanSchema.setTaskPlanCode(request.getParameter("TaskPlanCode"));
tLDTaskPlanSchema.setTaskCode(request.getParameter("TaskCode"));
tLDTaskPlanSchema.setRunFlag(request.getParameter("RunFlag"));
tLDTaskPlanSchema.setRecycleType(request.getParameter("RecycleType"));
tLDTaskPlanSchema.setStartTime(request.getParameter("StartTime"));
tLDTaskPlanSchema.setEndTime(request.getParameter("EndTime"));
tLDTaskPlanSchema.setInterval(request.getParameter("Interval"));
tLDTaskPlanSchema.setTimes(request.getParameter("Times"));
String tParamValue[] = request.getParameterValues("ParamGrid2");
String ipport = tParamValue[0]; 
int m = ipport.indexOf(":"); 
tLDTaskPlanSchema.setIPAddress(ipport==null||"".equals(ipport)?"":ipport.substring(0, m));
tLDTaskPlanSet.add(tLDTaskPlanSchema);

String tParamName[] = request.getParameterValues("ParamGrid1");
int n = tParamName.length;
for (int i = 0; i < n; i++)
{
	if (tParamName[i] != null && !tParamName[i].equals(""))
	{
		tLDTaskParamSchema = new LDTaskParamSchema();
		tLDTaskParamSchema.setParamName(tParamName[i]);
		tLDTaskParamSchema.setParamValue(tParamValue[i]);
		tLDTaskParamSet.add(tLDTaskParamSchema);
	}
}

tLDTaskSchema.setTaskCode(request.getParameter("BaseTaskCode"));
tLDTaskSchema.setTaskDescribe(request.getParameter("TaskDescribe"));
tLDTaskSchema.setTaskClass(request.getParameter("TaskClass"));
tLDTaskSet.add(tLDTaskSchema);

GlobalInput tG = new GlobalInput();
tG=(GlobalInput)session.getValue("GI");

tAction = request.getParameter( "fmAction" );

// 准备传输数据 VData
tData.add( tG );
tData.add(tLDTaskPlanSet);
tData.add(tLDTaskParamSet);
tData.add(tLDTaskSet);

TaskService tTaskService = new TaskService();
if( tTaskService.submitData( tData, tAction ) < 0 )
{
	 Content =  bundle.getString("Alert_SaveJspFail") +":"+ tTaskService.mErrors.getError(0).errorMessage;
	FlagStr = "Fail";
}
else
{
	 Content = bundle.getString("Alert_SaveJspSucc");
	FlagStr = "Succ";

	tData.clear();
}
FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
Content=ESAPI.encoder().encodeForJavaScript(Content);
%>
<script language="javascript">
parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
</script>