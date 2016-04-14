<%@page  pageEncoding="UTF-8" contentType='text/html;charset=utf-8'  %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>

<%@page import="com.sinosoft.utility.StrTool"%>
<%@page import="com.sinosoft.utility.SysConst"%>
<%@page import="com.sinosoft.utility.VData"%>
<%@page import="com.sinosoft.lis.logon.MenuShow"%>
<%@page import="com.sinosoft.lis.schema.LDUserSchema"%>
<%@page import="com.sinosoft.lis.menumang.LDMenuQueryUI"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="java.util.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String UserCode = request.getParameter("userCode");
	String Comcode = request.getParameter("comcode");

	//重新赋予session
	GlobalInput tG1 = new GlobalInput();
	tG1 = (GlobalInput) session.getValue("GI");
	System.out.println("tG1----1-------" + tG1);
	System.out.println("local----1-------" + tG1.locale);
	tG1.Operator = UserCode;
	tG1.ManageCom = Comcode;
	tG1.ComCode = Comcode;
	GlobalInput ttGl=new GlobalInput();
	if(null!=tG1){
		ttGl=tG1;
	}
	session.putValue("GI", ttGl);
	ExeSQL nExeSQL = new ExeSQL();
	String name = nExeSQL
			.getOneValue("select name from ldcom where comcode='"
					+ Comcode + "' ");

	String title = UserCode + " : "+bundle.getString("Hello,Welcometousethesystem!Yourcurrentloginorganizationis")+ name;
	//out.println(title);
	//hk_test:您好，欢迎登录本系统！您当前登录的机构是：Metlife Limited.
	title=ESAPI.encoder().encodeForHTML(title);
%>

<script LANGUAGE="JavaScript">
defaultStatus='<%=bundle.getString("waitForTran")%>';
var ls="";
var doc = "";
function CreateMenuMain(MNm,No)
{
	var i;
	for(i=1;i<No+1;i++)
	{
		WMnu=MNm+eval(i);
		if(i==1&&WMnu.indexOf("_")==-1){
			currNode = WMnu;
		}
		var y="";	//缩进设置值

		var z=3;	//0基数值，会导致一些设置差异

		var ls_WMnu = WMnu;
		//该用下列循环方式，或许能提高菜单的生成效率

		while(ls_WMnu.indexOf("_")!=-1)
		{
			//设置格式，以"_"划分子菜单

			ls_WMnu=ls_WMnu.slice(ls_WMnu.indexOf("_")+1);
			y += "&nbsp;&nbsp;";
			z += 1;
		}
		
		var nodecode = eval(WMnu+"[16]");	//节点编码
		var nodesrc = eval(WMnu+"[1]");	//节点连接
		var nodename = eval(WMnu+"[0]");	//节点名

		NOs = eval(WMnu+"[3]");	//节点子节点个数

		if(WMnu.indexOf && WMnu.indexOf("_")==-1){
			//alert("WMnu=" + WMnu); //横排菜单
			if(i == 1) {
				level1 += "<LI class='menuBtn menuNow' onclick=viewPage('" + WMnu + "',this)>" + nodename + "</LI>";
			} else {
				level1 += "<LI class='menuBtn' onclick=viewPage('" + WMnu + "',this)>" + nodename + "</LI>";
			}
		}
		if(NOs > 0)
		{
			//据说用onMouseUp替换onClick方法比较快捷
			if(WMnu.indexOf && WMnu.indexOf("_")==-1){
				ls_string = "<table id='"+WMnu+"_d' style='display:none;'>";
			} else {
				ls_string = "<table>";
			}
			ls_string += "<tr><td class='menu"+z+"' onMouseUp='showMenu("+WMnu+"s);'>"+y+"<img src='../common/images/butCollapse.gif' style='cursor:hand;' id='"+WMnu+"i'>&nbsp;";
			if(nodesrc!="")
			{
				ls_string += "<img src='../common/images/tree/file.png' style='vertical-align: middle;height:16px;'>&nbsp;<a onmousedown=this.className='down' onmouseout='shiftMouseOut()' onmouseover=this.className='over' onclick=changeframe('"+nodecode+"','"+nodesrc+"') style='cursor:hand'>"+nodename+"</a></td></tr></table><div id='"+WMnu+"s' style='display:none'>";
			}
			else
			{
				ls_string += "<img src='../common/images/tree/foldericon.png' style='vertical-align: middle;height:16px;'>&nbsp;" + nodename + "</td></tr></table><div id='"+WMnu+"s' style='display:none'>";
			}
			doc += ls_string;
//			document.write(ls_string);
			ls_string += CreateMenuMain(WMnu+"_",NOs);
			doc += "</div>";
//		document.write("</div>");
		}
		else
		{
			if(WMnu.indexOf && WMnu.indexOf("_")==-1){
				ls_string = "<table id='"+WMnu+"_d' style='display:none;'>";
			} else {
				ls_string = "<table>";
			}
			ls_string += "<tr><td class='menu"+z+"'>"+y+"<img src='../common/images/butNull.gif' id='"+WMnu+"i'>&nbsp;";
			if(nodesrc!="")
			{
				ls_string += "<img src='../common/images/tree/file.png' style='vertical-align: middle;height:16px;'>&nbsp;<a onmousedown=this.className='down' onmouseout='shiftMouseOut()' onmouseover=this.className='over' onclick=changeframe('"+nodecode+"','"+nodesrc+"') style='cursor:hand'>"+nodename+"</a></td></tr></table>";
			}
			else
			{
				ls_string += "<img src='../common/images/tree/foldericon.png' style='vertical-align: middle;height:16px;'>&nbsp;" + nodename + "</td></tr></table>";
			}
			doc += ls_string;
//			document.write(ls_string);
		}
	}
	return(ls_string);
//	document.close();
}
var MenuHeight=20;
//var MenuHeightChild=20;
//var MenuHeightBottom=20;
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="../common/css/otherM.css" rel=stylesheet type=text/css>
<base target="fraInterface">
<style>
body {
	margin: 0px;
	padding: 0px 5px;
	overflow:hidden;
}
.left{
	margin:0;
	padding:0;
	height: 100%;
	padding-bottom: 312px;
}
.link {
	font: '<%=bundle.getString("waitForTran")%>', tahoma, verdana, arial, helvetica, sans-serif;
	font-size: 12px;
	background: url(../common/skin/default/linkbg.gif);
	width: 246px;
	height: 118px;
	padding: 5px;
	margin: 5px 0 0 0;
}

.linktitle {
	width: 100%;
}

.friendlink ul {
	margin: 5px;
	padding: 0px;
}

.treeDiv {
	margin:0px;
	padding-top:8px;
	padding-bottom:8px;
	width: 100%;
	height:100%;
	border:#c9c9c9;
1px solid 	overflow: auto;
	text-align: left;
	padding-left: 5px;
	overflow: auto;
	color: black;
	background-color:#e9e9e9;
	scrollbar-face-color:#eeeeee;
 	scrollbar-highlight-color: black;
	scrollbar-shadow-color: black;
	scrollbar-3dlight-color:#eeeeee;
 	scrollbar-arrow-color: black;
	scrollbar-track-color:#eeeeee;
 	scrollbar-darkshadow-color:#eeeeee;
 	background-image:url('../common/uimages/menu_bg.png');
}

.userinfo {
	width: 236px;
	height: 112px;
	background: url('<%=bundle.getString("YHXX")%>')
}

.user {
	margin-top: 50px;
	margin-left: 15px;
}

.upic {
	float: left;
}

.utip {
	margin-left: 20px;
	float: left;
	font-family: '<%=bundle.getString("waitForTran")%>';
	font-size: 12px;
	line-height: 20px;
}
.menu{
	width: 236px;
	height: 100%;
}
.menutitle {
	height: 22px;
	width: 236px;
	background: url('<%=bundle.getString("MENUTITLE")%>')
}
</style>
</head>
<body bgcolor="#EFF1FA" leftmargin="0" topmargin="0">
<div class="left">
	<div class="userinfo" id='userinfoid'>
		<div class="user">
			<div class="upic"><img src="../common/uimages/user.gif"></div>
			<div class="utip"><%=title %></div>
		</div>
	</div>
	<div class="menu">
		<div class="menutitle" id='menutitleid'></div>
		<div class="treeDiv" id='treeMU'></div>
	</div>
</div>

<%
System.out.println("start menu get ...");
int i = 0;
int[] menuCount = new int[1];
menuCount[0] = 0;
int node_count = 0;
String[][] node = null;	//建立一个二维数组


String userCode = request.getParameter("userCode");
String Ip = request.getParameter("Ip");
Ip=ESAPI.encoder().encodeForJavaScript(Ip);
LDUserSchema tLDUserSchema = new LDUserSchema();
tLDUserSchema.setUserCode(userCode);

VData tData=new VData();
if ( userCode.compareTo("001") != 0)
{
	tData.add(tLDUserSchema);
}
//Locale tLocale=(Locale)session.getAttribute("locale");
//GlobalInput tG1=(GlobalInput)session.getValue("GI");
//tData.add(tG1);
LDMenuQueryUI tLDMenuQueryUI = new LDMenuQueryUI();
//调用生成菜单函数
tLDMenuQueryUI.submitData(tData,"query");
String expireFlag=request.getParameter("expireFlag");
StringBuffer menustr = null;
StringBuffer outBf = new StringBuffer();
if (tLDMenuQueryUI.mErrors.needDealError()||expireFlag.equals("1"))
{
	out.println("<script>");
	//outBf.append("<script>");

	int totalMenu = 2;
	out.println("var NoOffFirstLineMenus=" + totalMenu + ";");
	//outBf.append("var NoOffFirstLineMenus=" + totalMenu + ";");

	menuCount[0]++;
	menustr = new StringBuffer(128);
	menustr.append("Menu");
	menustr.append(menuCount[0]);
	menustr.append("=new Array('"+bundle.getString("waitForTran")+"','../logon/logout.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','');");
	out.println(menustr.toString());

	menuCount[0]++;
	menustr = new StringBuffer(128);
	menustr.append("Menu");
	menustr.append(menuCount[0]);
	menustr.append("=new Array('"+bundle.getString("waitForTran")+"','../changePwd/PwdInput.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','7777');");
	out.println(menustr.toString());

	out.println("parent.fraQuick.window.location = '../logon/station.jsp';");
	out.println("</script>");
}
else{
	node_count = tLDMenuQueryUI.getResultNum();
	node = new String[node_count][5];

    StringBuffer tStr = new StringBuffer(tLDMenuQueryUI.getResultStr());
    tStr.append(SysConst.RECORDSPLITER);

    StringBuffer str = null;
    //根据排序正确的字符串给数组重新赋值

    for (i = 0; i < node_count; i++)
    {
        str = new StringBuffer(tStr.substring(0, tStr.indexOf(SysConst.RECORDSPLITER)));
        str.append(SysConst.PACKAGESPILTER);
        for (int j = 0; j < 5; j++)
        {
            node[i][j] = str.substring(0, str.indexOf(SysConst.PACKAGESPILTER));
            str.delete(0, str.indexOf(SysConst.PACKAGESPILTER) + 1);
//            System.out.println(node[i][j]);
        }
        tStr.delete(0, tStr.indexOf(SysConst.RECORDSPLITER) + 1);
    }

	out.println("<script>");
	MenuShow menuShow = new MenuShow();
	//添加查询收藏夹功能

	//String tFavorite = menuShow.getFavorite(userCode);
	String tFavorite = "";
	//如果没有收藏夹信息
/*
	if (tFavorite.trim().equals(""))
	{
		//查询用户菜单信息
		out.println(menuShow.getMenu(node,0,node_count,menuCount,1));
	}
	else
	{
		out.println(tFavorite);
		//查询用户菜单信息
		out.println(menuShow.getMenu(node,0,node_count,menuCount,2));
	}
*/
	System.out.println("menuCount:"+menuCount[0]);
	out.println(menuShow.getMenu(node,0,node_count,menuCount));
	int totalMenu = menuCount[0];
	out.println("var NoOffFirstLineMenus=" + totalMenu + ";");

//	menuCount[0]++;
//	menustr = new StringBuffer(128);
//	menustr.append("Menu");
//	menustr.append(menuCount[0]);
//	menustr.append("=new Array('重新登录','../logon/logout.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','');");
//	menustr.append("=new Array('重新登录','../web/AgentGroupReportUI.jsp?ReportName=AgentGroup','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','');");
//	out.println(menustr.toString());

//	menuCount[0]++;
//	menustr = new StringBuffer(128);
//	menustr.append("Menu");
//	menustr.append(menuCount[0]);
//	menustr.append("=new Array('密码修改','../changePwd/PwdInput.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','7777');");
//	out.println(menustr.toString());

	out.println("parent.fraQuick.window.location = '../logon/station.jsp';");
	out.println("</script>");
}
%>
<script language="JavaScript" type="text/JavaScript">
//document.getElementById("userinfoid").style.background	="url('"+I18NMsg("M0000000033")+"');"
//document.getElementById("menutitleid").style.background	="url('"+I18NMsg("M0000000034")+"');"
//var t = new Date();
//document.write(t);
var level1="<LI id=menu class=switchmenu onclick=showMenu();>&lt;&lt; </LI>";
CreateMenuMain("Menu",NoOffFirstLineMenus);
document.getElementById("treeMU").innerHTML=doc;
//document.write(doc)
//alert(document);
try{
showMenu(Menu1s);
}catch(e){}
parent.document.frames('fraTitle').initMenuBar(level1);
//var s = new Date();
//document.write(s);

function showMenu(divID){
	var imgname;
	var a;
	if (divID.style.display == ""){
		divID.style.display="none";
		a = divID.id.replace('s','i');
		a = "document.all('"+a+"')";
		whichIm = eval(a);
		whichIm.src = "../common/images/butCollapse.gif";
	}
	else{
		divID.style.display="";
		a = divID.id.replace('s','i');
		a = "document.all('"+a+"')";
		whichIm = eval(a);
		whichIm.src = "../common/images/butExpand.gif";
		if (divID.id.length<=7) closeMenu(divID);	//如果是一级科目才执行closeMenu
	}
}

//循环关闭非打开的一级目录菜单，如果能不用最好

function closeMenu(divID){
	var a;
	divColl = document.getElementById('treeMU').all.tags("DIV");	//所有div的个数

	for (i=0; i<divColl.length; i++){
		//判定是否为打开的div，且是一级目录菜单，对节点的长度做了一定的限制，不是很好

		if ((divColl(i).id != divID.id)&&(divColl(i).id.length<=7)) {
			divColl(i).style.display="none";
			a = divColl(i).id.replace('s','i');
			a = "document.all('"+a+"')";
			whichIm = eval(a);
			whichIm.src = "../common/images/butCollapse.gif";
		}
	}
}

function changeframe(nodecode,nodesrc)
{
	var currElement=event.srcElement;//按钮效果
	changeNode(currElement);//按钮效果
	parent.fraInterface.window.location.href=nodesrc;	//转换连接，比直接用a的方式快一些

	if ((nodecode != null)&&(nodecode != ''))
	{
		parent.fraQuick.location.href="station.jsp?Ip=<%=Ip%>&nodecode="+nodecode;	//修改导航栏的显示信息
	}
}
function changeframeShort(nodecode,nodesrc)
{
	parent.fraInterface.window.location.href=nodesrc;	//转换连接，比直接用a的方式快一些

	top.fraQuick.location.href="../logon/station.jsp?Ip=<%=Ip%>&nodecode="+nodecode;	//修改导航栏的显示信息
}

var currNode;
function changeNode(nodeID)
{
	if(typeof(currNode)!="undefined")
	{
		currNode.className="out";
	}
	currNode=nodeID;
	currNode.className="up";
}

function shiftMouseOut()
{
	var x = event.srcElement;
	if(x!=currNode)
	{
		x.className="";
	}
	else
	{
		x.className="up"
	}
}
var currNode;
function view(nodeid){
	if(currNode==nodeid) {
		return true;
	}
	currNode=nodeid;
	showMenu(document.getElementById(nodeid + "s"))
}

 parent.document.frames('fraTitle').showTitle();
 parent.document.frames('fraTitle').showHideFrame();
 parent.fraInterface.window.location.href="./Welcome.jsp";
 
</script>
</body>
