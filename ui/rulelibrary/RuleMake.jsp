<%@include file="../i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	//获取规则定制时传入的基本信息
	String RuleName = request.getParameter("RuleName");
	String RuleDes = request.getParameter("RuleDes");
	String Creator = request.getParameter("Creator");
	String RuleStartDate = request.getParameter("RuleStartDate");
	String RuleEndDate = request.getParameter("RuleEndDate");
	String TempalteLevel = request.getParameter("TempalteLevel");
	String Business = request.getParameter("Business");
	String State = request.getParameter("State");
	String Valid = request.getParameter("Valid");
	//获取操作类型标志
	String flag = (String) request.getParameter("flag");
	//获取规则表主键标志：主要用于规则的修改、复制和查看时用于查找规则的主键
	String LRTemplate_ID = (String) request.getParameter("LRTemplate_ID");
	//获取规则来源的表名：主要用于规则的修改、复制和查看时用于查找规则的表
    String Approver = (String) request.getParameter("Approver");
	String LRTemplateName = (String) request.getParameter("LRTemplateName");
	
	RuleName = ESAPI.encoder().encodeForJavaScript(RuleName);
	RuleDes = ESAPI.encoder().encodeForJavaScript(RuleDes);
	Creator = ESAPI.encoder().encodeForJavaScript(Creator);
	RuleStartDate = ESAPI.encoder().encodeForJavaScript(RuleStartDate);
	RuleEndDate = ESAPI.encoder().encodeForJavaScript(RuleEndDate);
	TempalteLevel = ESAPI.encoder().encodeForJavaScript(TempalteLevel);
	Business = ESAPI.encoder().encodeForJavaScript(Business);
	State = ESAPI.encoder().encodeForJavaScript(State);
	Valid = ESAPI.encoder().encodeForJavaScript(Valid);
	flag = ESAPI.encoder().encodeForJavaScript(flag);
	LRTemplate_ID = ESAPI.encoder().encodeForJavaScript(LRTemplate_ID);
	Approver = ESAPI.encoder().encodeForJavaScript(Approver);
	LRTemplateName = ESAPI.encoder().encodeForJavaScript(LRTemplateName);
	
	System.out.println("RuleName::" + RuleName);
	System.out.println("RuleDes::" + RuleDes);
	System.out.println("Creator::" + Creator);
	System.out.println("RuleStartDate::" + RuleStartDate);
	System.out.println("RuleEndDate::" + RuleEndDate);
	System.out.println("TempalteLevel::" + TempalteLevel);
	System.out.println("Business::" + Business);
	System.out.println("State::" + State);
	System.out.println("Valid::" + Valid);

	System.out.println("flag::" + flag);
	System.out.println("LTRemplate_ID::" + LRTemplate_ID);
	System.out.println("LRTemplateName::" + LRTemplateName);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><%=bundle.getString("M0000072444")%></title>
<link rel="stylesheet" type="text/css" href="./resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/rule.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/examples.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/grid-examples.css" />
<script type="text/javascript" src="./baseLib/ext-base.js"></script>
<script type="text/javascript" src="./baseLib/ext-all.js"></script>
<script type="text/javascript" src="./baseLib/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="./baseLib/multiSelectCbox.js"></script>
<script type="text/javascript" src="./JavaScript/write.js"></script>            
<script type="text/javascript" src="./JavaScript/initsql.js"></script> 
<script type="text/javascript" src="./JavaScript/makeLogical.js"></script>
<script type="text/javascript" src="./JavaScript/dicisionTable.js"></script>
<script type="text/javascript" src="./JavaScript/viewParameter.js"></script>


<script type="text/javascript" src="../common/easyQueryVer3/EasyQueryVer3.js"></script>
<LINK href="../common/css/Project.css" rel=stylesheet type=text/css />
<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
<script type="text/javascript">
       var flag=<%=flag%>;
       var LRTemplate_ID='<%=LRTemplate_ID%>';
       var State='1';
       var LRTemplateName='<%=LRTemplateName%>';
</script>
<script type="text/javascript" src="./RuleMake.js"></script>
<%@include file="./RuleMakeInit.jsp"%>

</head>
<body onload="initRule();initButtons()">

<div id="RuleDisplay" style="width:4000; overflow-y: auto; overflow-x: auto"><!--overflow-x:visible-->
    <div id="conditions"	style="width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions1"  style="position: ralative; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu1()"<%=bundle.getString("N0000074001")%></div>
    <br />

    <div id="conditions3" style="width: 100; height: 7; display:none; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu3()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions4"  style="position: ralative; display:none; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu4()"<%=bundle.getString("N0000074001")%></div>
     <br />

     <div id="conditions5" style="width: 100; height: 7; display:none; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu5()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions6"  style="position: ralative; display:none; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu6()"<%=bundle.getString("N0000074001")%></div>
     <br />
    <!-- <div id="conditions7" style="width: 100; height: 7; visibility: hidden; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu7()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions8"  style="position: ralative; visibility: hidden; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu8()"<%=bundle.getString("N0000074001")%></div>
     <br />
     <div id="conditions9" style="width: 100; height: 7; visibility: hidden; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu9()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions10"  style="position: ralative; visibility: hidden; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu10()"<%=bundle.getString("N0000074001")%></div>
     <br />
     <div id="conditions11" style="width: 100; height: 7; visibility: hidden; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu11()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions12"  style="position: ralative; visibility: hidden; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu12()"<%=bundle.getString("N0000074001")%></div>
     <div id="conditions13" style="width: 100; height: 7; visibility: hidden; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu13()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions14"  style="position: ralative; visibility: hidden; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu14()"<%=bundle.getString("N0000074001")%></div>
     <div id="conditions15" style="width: 100; height: 7; visibility: hidden; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu15()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions16"  style="position: ralative; visibility: hidden; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu16()"<%=bundle.getString("N0000074001")%></div>
     <div id="conditions17" style="width: 100; height: 7; visibility: hidden; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu17()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions18"  style="position: ralative; visibility: hidden; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu18()"<%=bundle.getString("N0000074001")%></div>
     <div id="conditions19" style="width: 100; height: 7; visibility: hidden; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()"
	       onclick="showOrHideMenu19()"<%=bundle.getString("N0000074000")%></div>
    <div id="conditions20"  style="position: ralative; visibility: hidden; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold; cursor: hand"	onmouseout="normalLight()" onmouseover="hightLight()" 
	     onclick="showOrHideMenu20()"<%=bundle.getString("N0000074001")%></div>-->
    <div id="conditions2" style="position: ralative; left: -20; width: 100; height: 7; color: #0754D4; font-size: 14; font-weight: bold;"	
	       <%=bundle.getString("M0010091810")%>
         <div style="width:3000;font-size: 14"><form method="post" name="fm1" action="./RuleMakeSave.jsp"><td >请输入默认值:<Input class=common  name=WageYear ><td></Form></div>
    </div>
   <div id="divadd" onclick="addCase()"  style="width: 200; height: 10; font-size: 15; font-weight: bold; cursor: hand">添加如果-那么</div>
   <div id="display" style="position: absolute; display: none; width: auto; height: 200; overflow-y: auto; overflow-x: auto; border: thin lightblue solid; background: #E7F2FB;"></div>
   <div id="display1"	style="position: absolute; display: none; width: auto; height: 200; overflow-y: auto; overflow-x: auto; border: thin lightblue solid; background: #E7F2FB;"></div>
   <input style="display:none" type="input" id="Result" name="Result" size='80' maxlength=40 value="" onfocus="if(this.value='请录入积分参数') this.value=''"/>
</div>
<form method="post" name="fm" action="./RuleMakeSave.jsp"><!-- 用于存储规则定制时基本信息的标识 -->  
<Input type="hidden" class=common  name=WageYear1 >
<input type="hidden" name="TableName"></input> 
<input type="hidden"	name="BOMS"></input> 
<input type="hidden" name="SQLPara"></input> 
<input	type="hidden" name="ViewPara"></input> 
<input type="hidden"	name="SQLStatement"></input> 
<input type="hidden" name="DTData" /> 
<input	type="hidden" name="CreateTable"></input> 
<input type="hidden"	name="RuleCh" value="RuleCh"></input> 
<input type="hidden" name="TableColumnName"></input>
<input type="hidden" name="ColumnDataType"></input>
<input type="hidden" name="RuleName" value=<%=RuleName%>></input> 
<input type="hidden" name="RuleDes" value=<%=RuleDes%>></input> 
<input type="hidden" name="Creator" value=<%=Creator%>></input> 
<input type="hidden" name="RuleStartDate" value=<%=RuleStartDate%>></input> 
<input type="hidden" name="RuleEndDate" value=<%=RuleEndDate%>></input> 
<input	type="hidden" name="TempalteLevel" value=<%=TempalteLevel%>></input> 
<input type="hidden" name="Business" value=<%=Business%>> 
<input type="hidden" name="State" value=<%=State%>></input> 
<input	type="hidden" name="Valid" value=<%=Valid%>></input> <!-- 用于存储规则定制时决策表数据类型的标识 -->
<input type="hidden" name="Types"></input> <!-- 用于存储规则定制时基本操作类型的标识 --> 
<input	type="hidden" name="flag" value=<%=flag%>></input> <!-- 用于存储规则定制时规则主键的标识 -->
<input type="hidden" name="LRTemplate_ID" value=<%=LRTemplate_ID%>></input><!-- 用于标识规则修改时的操作类型 --> 
<input type="hidden" name="Approver" value=<%=Approver%>></input>
<input type="hidden" name="Operation"></input>
<input type="hidden" name="CountCase"></input>
</form>
</body>
</html>
