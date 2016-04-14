<%@include file="/i18n/language.jsp"%>

<%@ page  pageEncoding="UTF-8" contentType='text/html;charset=utf-8'  %>
<!--*******************************************************
* 程序名称：Title.jsp
* 程序功能：系统标题页面

* 最近更新人：朱向峰
* 最近更新日期：2002-08-21
* 				2004-11-3 16:58
*******************************************************-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 页面样式  -->
<link rel='stylesheet' type='text/css' href='../common/css/Project.css'>
<link type="text/css" rel="StyleSheet" href="../common/css/menubar.css" />
<SCRIPT src="../common/javascript/Common.js" ></SCRIPT>
<style type="text/css">
.top{
	width:100%;
}
table{
	height: 82px;
	width:100%;
	margin:0px;
	padding:0px;
	background: url('../common/uimages/banner_m.gif');
}
tr td{
	margin:0px;
	padding:0px;
	border: 0;
}
.left{
	background: url('<%=bundle.getString("BANNER_LEFT")%>') no-repeat;
	width: 455px;
}
.right{
	padding:40px 10 0 0;
	margin:0px;
	height:100%;
	background: url('../common/uimages/banner_right.gif') no-repeat;
	width:558px;
}
img{
	cursor: hand;
	margin-right: 20px;
}
.switchmenu{
	width: 20px;
	height: 37px;
	line-height:30px;
	cursor: pointer;
	color:#666;
 	text-align: center;
}
.btsel{
	background-color:red;
}
</style>	
<script language="JavaScript">
function showTitle(){
	parent.fraMain.rows = "0,0,0,118,*,30";
	parent.fraTalk.rows = "30,*";
}
function showHideFrame(){
	try{
		if(parent.fraSet.cols==	"0%,*,0%"){
			parent.fraSet.cols = "250,*,0%";
			menuPowerImage.src = "../common/images/butHide.gif";
		}
		else if(parent.fraSet.cols=="250,*,0%"){
			parent.fraSet.cols = "0%,*,0%";
			menuPowerImage.src = "../common/images/butShow.gif";
			}
		}
		catch(re){}
	}
function viewPage(nodeId,obj)
{
	if(obj){
		var children = obj.parentNode.children;
		for(var i = 1; i < children.length; i++)
		{
			children[i].className='menuBtn';
		}
		obj.className='menuBtn menuNow';
	}
	showMenu(true);
	parent.document.frames('fraMenu').view(nodeId);
}
function showMenu(f){
	if(f){
		parent.fraSet.cols = "250,*";
		document.getElementById("menu").innerHTML="<<<";
	}else{
		if(parent.fraSet.cols == "0,*"){
			parent.fraSet.cols = "250,*";
			document.getElementById("menu").innerHTML="<<<";
		}else{
			parent.fraSet.cols = "0,*";
			document.getElementById("menu").innerHTML=">>";
		}
	}
}
function initMenuBar(htmlText){
	document.getElementById("menuBar").innerHTML=htmlText;
}
</script>
</head>
<style type="text/css">
<!--
	body {FONT-FAMILY: sadasdasd;font-size:9pt;FONT-WEIGHT: bold}
	td {FONT-FAMILY: <%=bundle.getString("waitForTran")%>;font-size:9pt;FONT-WEIGHT: bold}
	input {FONT-FAMILY: <%=bundle.getString("waitForTran")%>;font-size:9pt;FONT-WEIGHT: bold}
-->
</style>
<body text="#000000" leftmargin="0" topmargin="0" bottommargin="0"
	rightmargin="0" marginwidth="0" onselectstart="return false">
<div>
<table cellpadding="0" border="0" cellspacing="0">
<tr class="up">
<td class="left"></td>
<td align="right"><div class="right">
<img alt='<%=bundle.getString("login_Exit") %>' src="../common/uimages/logout.gif" onclick="top.location='../logon/logout.jsp'">
</div></td>
</tr>
</table>
</div>	
<div id="menuContainer">
    <div id="menuZone">
    <UL id='menuBar'></UL>
</div>
</div>

</body>
</html>
