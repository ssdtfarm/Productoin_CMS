<%@include file="../jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../easyQueryVer3/EasyQueryFunc.jsp"%>
<%
//程序名称：.jsp
//程序功能：sql编辑页面模版
//          SQLID和SQL是保留字
//创建日期：
//创建人  ：
%>

<%
//必须在以下部分编辑SQL
System.out.println("ExcSQL");

if(SQLID.equals("InputJsImport"))
{
		SQL = "select SysvarValue from ldsysvar where sysvar = 'ImportFilePath' ";
}

%>
<%
System.out.println("InputSQL===:"+SQL);
request.setAttribute("EASYQUERYSQL",SQL);
%>