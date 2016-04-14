<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/easyQueryVer3/EasyQueryFunc.jsp"%>
  <%@include file="/i18n/language.jsp"%>	
<%
	//必须在以下部分编辑SQL			
	System.out.println("ExcSQL");
	if (SQLID.equals("SearchResult")) {
		SQL = "select  usercode,username,userstate,userdescription,comcode,(select count(1) from lduser where 1=1 ) from lduser a where 1=1 "
				+ getWherePart(request, "a.usercode", "p_UserCode")
				+ getWherePart(request, "a.username", "p_UserName")
				+ getWherePart(request, "a.comcode", "p_ComCode")
				+ getWherePart(request, "a.ValidStartDate", "p_ValidStartDate",">=")
				+ getWherePart(request, "a.ValidEndDate", "p_ValidEndDate","<=");

	}
	if (SQLID.equals("tempSelectArray")) {
		SQL = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp where 1=1"
				+ getWherePart(request, "operator", "p_operator")+"and "
				+" MenuGrpCode  in  ( select MenuGrpCode from LDUserToMenuGrp where 1=1 "
				+ getWherePart(request, "usercode", "p_userCode")+")";

	}
	if (SQLID.equals("tempUnselectArray")) {
		SQL = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp where 1=1"
				+ getWherePart(request, "operator", "p_operator")+"and "
				+" MenuGrpCode not in  ( select MenuGrpCode from LDUserToMenuGrp where 1=1 "
				+ getWherePart(request, "usercode", "p_userCode")+") ";

	}
	if (SQLID.equals("MenuList")) {
		SQL = "select ParentNodeCode,ChildFlag,nodename,nodecode from LDMenu "
				+" where NodeCode in (select NodeCode from LDMenuGrpToMenu where 1=1 "
				+ getWherePart(request, "MenuGrpCode", "p_MenuGrpCode")+")";

	}
	if (SQLID.equals("UnMenuList")) {
		SQL = "select ParentNodeCode,ChildFlag,nodename,nodecode from LDMenu "
				+" where NodeCode in (select NodeCode from LDMenuGrpToMenu where 1=1 "
				+ getWherePart(request, "MenuGrpCode", "p_MenuGrpCode")+")";

	}
	if (SQLID.equals("Init")) {
		SQL = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp where 1=1 "
				+ getWherePart(request, "operator", "p_operator");

	}
%>
<%
	System.out.println("InputSQL===:" + SQL);
	request.setAttribute("EASYQUERYSQL", SQL);
%>

