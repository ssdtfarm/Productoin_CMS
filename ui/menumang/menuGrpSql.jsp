<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../common/easyQueryVer3/EasyQueryFunc.jsp"%>
  <%@include file="/i18n/language.jsp"%>	
<%
	//必须在以下部分编辑SQL			
	System.out.println("ExcSQL");
	if (SQLID.equals("SearchMenu")) {
		SQL = "select MenuGrpName,MenuGrpCode,MenuSign,MenuGrpDescription,Operator from LDMenuGrp where 1=1"
			+ getWherePart(request, "MenuGrpName", "p_MenuGrpName")
			+ getWherePart(request, "MenuGrpCode", "p_MenuGrpCode")
			+ getWherePart(request, "MenuGrpDescription", "p_MenuGrpDescription")
			+ getWherePart(request, "MenuSign", "p_MenuSign")
			+ getWherePart(request, "Operator", "p_Usercode");

	}
	
	if (SQLID.equals("showAllMenuInUnselect")) {
		SQL = "select ParentNodeCode,ChildFlag,nodename,nodecode,NodeSign from LDMenu where 1=1 order by nodeorder ";

	}
	
	if (SQLID.equals("SQL_001")) {
		if("001".equals(getValue2(request,"p_Operator"))){
			SQL = "select nodecode from LDMenu order by nodeorder";
		}else{
			SQL = "select nodecode from LDMenu where nodecode in (select nodecode from ldmenugrptomenu "
				+" where menuGrpCode in (select menuGrpCode from ldusertomenugrp where 1=1"
				//+ getWherePart(request, "usercode", "p_Operator")
				+" )) order by nodeorder";
		}
	}
	if (SQLID.equals("showMenuGrp")) {
		SQL = "select ParentNodeCode,ChildFlag,nodename,nodecode,NodeSign from LDMenu order by nodeorder";

	}
	if (SQLID.equals("queryAllRecord")) {
		SQL = "select nodecode from LDMenu where nodecode in "
			+" (select nodecode from ldmenuGrpTomenu where 1=1 "
			+ getWherePart(request, "menuGrpCode", "p_menuGrpCode")
			+" ) and 1=1";

	}
%>
<%
	System.out.println("InputSQL===:" + SQL);
	request.setAttribute("EASYQUERYSQL", SQL);
%>

