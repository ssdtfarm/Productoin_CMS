<%@ include file="../common/jsp/UsrCheck.jsp" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../common/easyQueryVer3/EasyQueryFunc.jsp"%>
  <%@include file="/i18n/language.jsp"%>	
<%
	//必须在以下部分编辑SQL			
	System.out.println("ExcSQL");
	if (SQLID.equals("QueryTask")) {
		SQL = "select a.TaskPlanCode, a.TaskCode, b.TaskDescribe, a.RunFlag, a.RecycleType, a.StartTime, a.EndTime, a.Interval, a.Times, a.RunState from LDTaskPlan a, LDTask b where a.TaskCode = b.TaskCode order by a.TaskPlanCode";

	}
	if (SQLID.equals("queryTaskInfo")) {
		SQL = "select TaskCode, TaskDescribe, TaskClass from LDTask order by TaskCode ";

	}
	if (SQLID.equals("onTaskPlanSelected")) {
		SQL = "select ParamName, ParamValue from LDTaskParam where 1=1 "
			+ getWherePart(request, "TaskPlanCode", "p_TaskPlanCode")
			+ getWherePart(request, "TaskCode", "p_TaskCode")
			+" order by (case paramname when 'IP:PORT' then '000000' else taskplancode end)";

	}
%>
<%
	System.out.println("InputSQL===:" + SQL);
	request.setAttribute("EASYQUERYSQL", SQL);
%>

