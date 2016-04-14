<%@include file="/i18n/language.jsp"%>

<%@page  pageEncoding="UTF-8" contentType='text/html;charset=utf-8'  %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<!--*******************************************************
* 程序名称：station.jsp
* 程序功能：系统标题页面
* 最近更新人：朱向峰
* 最近更新日期：2005-3-21 14:45
*******************************************************-->
<%@page import="com.sinosoft.lis.logon.MenuShow"%>
<%@page import="com.sinosoft.lis.pubfun.GlobalInput"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun1"%>
<%@page import="com.sinosoft.utility.ExeSQL"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
String nodecode = request.getParameter("nodecode");
String Ip = request.getParameter("Ip");
//System.out.println(Ip);

String ls="";
if ((nodecode==null)||("".equals(nodecode)))
{
	//ls = bundle.getString("waitForTran");
	ls = bundle.getString("Location:HomePage");
}
else
{
	if (nodecode.equals("7777"))
	{
		ls = bundle.getString("Location:ModifyPassword");
	}
	else
	{
	GlobalInput tG1=(GlobalInput)session.getValue("GI");
		//MenuShow menuShow = new MenuShow(tG1.locale);
		MenuShow menuShow = new MenuShow();
		//menuShow.setLocationStart("现在的位置：");
//		System.out.println("Begin...");
		ls = menuShow.getStation(nodecode);
//		System.out.println("End...");
                ls = ls.substring(0,ls.length()-3);

//modify by liqian 20061110
try
		{
			GlobalInput tG = (GlobalInput)session.getValue("GI");
		}
		catch(Exception ex)
		{
			System.out.println("GlobalInput的值是空的！请重新登录");
			ex.printStackTrace();			
		}


		GlobalInput tG = (GlobalInput)session.getValue("GI");
		//闫少杰 2006-03-31 增加用户轨迹号码
        String userTraceNo = PubFun1.CreateMaxNo("USERTRACENO", 10);
		String tSql = "insert into LDUserTrace (TraceNo, ManageCom,Operator,TraceType,TraceContent,ClientIP,MakeDate,MakeTime ) " +
			"values ( '"+userTraceNo+"','"+tG.ComCode+"','"+tG.Operator+"','00','"+ls.substring(6)+"','"+Ip+"','"+PubFun.getCurrentDate()+"','"+PubFun.getCurrentTime()+"' )";
		ExeSQL tExeSQL = new ExeSQL();
		//执行用户轨迹操作
		try
		{
			tExeSQL.execUpdateSQL(tSql);
		}
		catch(Exception ex)
		{
			System.out.println("用户操作轨迹记录失败！");
			ex.printStackTrace();
		}
	}
}
String ls1=ESAPI.encoder().encodeForJavaScript(ls);
String ls2=ESAPI.encoder().encodeForHTML(ls);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function showmenu()
{
	if(parent.fraSet.cols=="0%,*,0%")
	{
		document.all("menushow").style.display = "none";
		parent.fraSet.cols = "250,*,0%";
	}
}
function changeJustColor(){
	if('<%=ls1%>'=='<%=bundle.getString("waitForTran")%>'){
		document.getElementById("clor").color="red";
	}
	else{
		document.getElementById("clor").color="#000000";
	}
}
</script>
<link rel='stylesheet' type='text/css' href='../common/css/other.css'>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0" oncontextmenu=self.event.returnValue=false onload="changeJustColor();"
	style="background-image:url('../common/uimages/station_bg.gif');">
	<table width=100% height="25" cellspacing="0">
		<tr>
    		<th align="left" id=menushow style="display:none" name=menushow>
    			<a href="#" onclick="showmenu();">
      			&nbsp;&nbsp;<img src="../common/images/t_open.gif" width="70" height="13" border="0" title="显示菜单栏">
				</a>
			</th>
			<th align=left style='padding-left:15px;'><font color='#000000' style="font-size:9pt" id='clor' ><%=ls2%></font></th>
		</tr>
	</table>
</body>
</html>
