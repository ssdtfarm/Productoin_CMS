<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page  pageEncoding="UTF-8" contentType='text/html;charset=utf-8'  %>
<!--
*******************************************************
* 绋嬪簭鍚嶇О锛歁enus.jsp
* 绋嬪簭鍔熻兘锛氱敤鎴风櫥褰曚俊鎭緭鍏ラ〉闈?
* 鍒涘缓鏃ユ湡锛?002-08-11
* 鏇存柊璁板綍锛? 鏇存柊浜?鏇存柊鏃ユ湡	鏇存柊鍘熷洜/鍐呭
*             鏈卞悜宄?2002-08-11	鏂板缓
              Dingzhong	2002-10-17	<%=bundle.getString("waitForTran")%>
              <%=bundle.getString("waitForTran")%>
*******************************************************
-->
<%@page import="com.sinosoft.utility.StrTool"%>
<%@page import="com.sinosoft.utility.SysConst"%>
<%@page import="com.sinosoft.utility.VData"%>
<%@page import="com.sinosoft.lis.logon.MenuShow"%>
<%@page import="com.sinosoft.lis.schema.LDUserSchema"%>
<%@page import="com.sinosoft.lis.menumang.LDMenuQueryUI"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="java.util.*"%>
<%
	String UserCode = request.getParameter("userCode");
	String Comcode = request.getParameter("comcode");

	//閲嶆柊璧嬩簣session
	GlobalInput tG1 = new GlobalInput();
	tG1 = (GlobalInput) session.getValue("GI");
	System.out.println("tG1----1-------" + tG1);
	tG1.Operator = UserCode;
	tG1.ManageCom = Comcode;
	tG1.ComCode = Comcode;
	session.putValue("GI", tG1);
	ExeSQL nExeSQL = new ExeSQL();
	String name = nExeSQL
			.getOneValue("select name from ldcom where comcode='"
					+ Comcode + "' ");

	//String title = "<b>" + UserCode + "</b>鎮ㄥソ锛屾杩庣櫥褰曟湰绯荤粺锛佹偍褰撳墠鐧诲綍鐨勬満鏋勬槸<b>"
	//		+ name + "</b><br>";
	//out.println(title);
%>

<script LANGUAGE="JavaScript">
defaultStatus='<%=bundle.getString("G0000025679")%>';
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
		var y="";	//缂╄繘璁剧疆鍊?
		var z=3;	//0鍩烘暟鍊硷紝浼氬鑷翠竴浜涜缃樊寮?
		var ls_WMnu = WMnu;
		//璇ョ敤涓嬪垪寰幆鏂瑰紡锛屾垨璁歌兘鎻愰珮鑿滃崟鐨勭敓鎴愭晥鐜?
		while(ls_WMnu.indexOf("_")!=-1)
		{
			//璁剧疆鏍煎紡锛屼互"_"鍒掑垎瀛愯彍鍗?
			ls_WMnu=ls_WMnu.slice(ls_WMnu.indexOf("_")+1);
			y += "&nbsp;&nbsp;";
			z += 1;
		}
		
		var nodecode = eval(WMnu+"[16]");	//鑺傜偣缂栫爜
		var nodesrc = eval(WMnu+"[1]");	//鑺傜偣杩炴帴
		var nodename = eval(WMnu+"[0]");	//鑺傜偣鍚?
		NOs = eval(WMnu+"[3]");	//鑺傜偣瀛愯妭鐐逛釜鏁?
		if(WMnu.indexOf && WMnu.indexOf("_")==-1){
			if(i == 1) {
				level1 += "<LI class='menuBtn menuNow' onclick=viewPage('" + WMnu + "',this)>" + nodename + "</LI>";
			} else {
				level1 += "<LI class='menuBtn' onclick=viewPage('" + WMnu + "',this)>" + nodename + "</LI>";
			}
		}
		if(NOs > 0)
		{
			//鎹鐢╫nMouseUp鏇挎崲onClick鏂规硶姣旇緝蹇嵎
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
	font: '<%=bundle.getString("G0000025503")%>', tahoma, verdana, arial, helvetica, sans-serif;
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
	overflow-x: auto;
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
	background: url('../common/uimages/yhxx.gif')
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
	font-family: '<%=bundle.getString("G0000025503")%>';
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
	background: url('../common/uimages/menutitle.gif')
}
</style>
</head>
<body bgcolor="#EFF1FA" leftmargin="0" topmargin="0">
<div class="left">
	<div class="userinfo">
		<div class="user">
			<div class="upic"><img alt="<%=bundle.getString("GG000034632")%>" src="../common/uimages/user.gif"></div>
			<div class="utip"><%=bundle.getString("GG000034633")%><%=UserCode%><br><%=bundle.getString("GG000034634")%></div>
		</div>
	</div>
	<div class="menu">
		<div class="menutitle"></div>
		<div class="treeDiv" id='treeMU'></div>
	</div>
</div>

<%
//System.out.println("start menu get ...");
int i = 0;
int[] menuCount = new int[1];
menuCount[0] = 0;
int node_count = 0;
String[][] node = null;	//寤虹珛涓?釜浜岀淮鏁扮粍


String userCode = request.getParameter("userCode");
String Ip = request.getParameter("Ip");

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
//璋冪敤鐢熸垚鑿滃崟鍑芥暟
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
	menustr.append("=new Array('"+bundle.getString("G0000025680")+"','../logon/logout.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','');");
	out.println(menustr.toString());

	menuCount[0]++;
	menustr = new StringBuffer(128);
	menustr.append("Menu");
	menustr.append(menuCount[0]);
	menustr.append("=new Array('"+bundle.getString("G0000025681")+"','../changePwd/PwdInput.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','7777');");
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
    //鏍规嵁鎺掑簭姝ｇ‘鐨勫瓧绗︿覆缁欐暟缁勯噸鏂拌祴鍊?
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
	MenuShow menuShow = new MenuShow(tG1.locale);
	//娣诲姞鏌ヨ鏀惰棌澶瑰姛鑳?
	String tFavorite = menuShow.getFavorite(userCode);
	//濡傛灉娌℃湁鏀惰棌澶逛俊鎭?
	if (tFavorite.trim().equals(""))
	{
		//鏌ヨ鐢ㄦ埛鑿滃崟淇℃伅
		out.println(menuShow.getMenu(node,0,node_count,menuCount,1));
	}
	else
	{
		out.println(tFavorite);
		//鏌ヨ鐢ㄦ埛鑿滃崟淇℃伅
		out.println(menuShow.getMenu(node,0,node_count,menuCount,2));
	}
	int totalMenu = menuCount[0];
	out.println("var NoOffFirstLineMenus=" + totalMenu + ";");

//	menuCount[0]++;
//	menustr = new StringBuffer(128);
//	menustr.append("Menu");
//	menustr.append(menuCount[0]);
//	menustr.append("=new Array('閲嶆柊鐧诲綍','../logon/logout.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','');");
//	menustr.append("=new Array('閲嶆柊鐧诲綍','../web/AgentGroupReportUI.jsp?ReportName=AgentGroup','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','');");
//	out.println(menustr.toString());

//	menuCount[0]++;
//	menustr = new StringBuffer(128);
//	menustr.append("Menu");
//	menustr.append(menuCount[0]);
//	menustr.append("=new Array('瀵嗙爜淇敼','../changePwd/PwdInput.jsp','',0,MenuHeight,120,'','','','','','',-1,1,-1,'','7777');");
//	out.println(menustr.toString());

	out.println("parent.fraQuick.window.location = '../logon/station.jsp';");
	out.println("</script>");
}
%>
<script language="JavaScript" type="text/JavaScript">
//var t = new Date();
//document.write(t);
var level1="<LI id=menu class=switchmenu onclick=showMenu();>&lt;&lt; </LI>";
CreateMenuMain("Menu",NoOffFirstLineMenus);
//alert(doc)
document.getElementById("treeMU").innerHTML=doc;
//document.write(doc)
//alert(document);
showMenu(Menu1s);
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
		if (divID.id.length<=7) closeMenu(divID);	//濡傛灉鏄竴绾х鐩墠鎵цcloseMenu
	}
}

//寰幆鍏抽棴闈炴墦寮?殑涓?骇鐩綍鑿滃崟锛屽鏋滆兘涓嶇敤鏈?ソ

function closeMenu(divID){
	var a;
	divColl = document.getElementById('treeMU').all.tags("DIV");	//鎵?湁div鐨勪釜鏁?
	for (i=0; i<divColl.length; i++){
		//鍒ゅ畾鏄惁涓烘墦寮?殑div锛屼笖鏄竴绾х洰褰曡彍鍗曪紝瀵硅妭鐐圭殑闀垮害鍋氫簡涓?畾鐨勯檺鍒讹紝涓嶆槸寰堝ソ

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
	var currElement=event.srcElement;//鎸夐挳鏁堟灉
	changeNode(currElement);//鎸夐挳鏁堟灉
	parent.fraInterface.window.location.href=nodesrc;	//杞崲杩炴帴锛屾瘮鐩存帴鐢╝鐨勬柟寮忓揩涓?簺

	if ((nodecode != null)&&(nodecode != ''))
	{
		parent.fraQuick.location.href="station.jsp?Ip=<%=Ip%>&nodecode="+nodecode;	//淇敼瀵艰埅鏍忕殑鏄剧ず淇℃伅
	}
}
function changeframeShort(nodecode,nodesrc)
{
	parent.fraInterface.window.location.href=nodesrc;	//杞崲杩炴帴锛屾瘮鐩存帴鐢╝鐨勬柟寮忓揩涓?簺

	top.fraQuick.location.href="../logon/station.jsp?Ip=<%=Ip%>&nodecode="+nodecode;	//淇敼瀵艰埅鏍忕殑鏄剧ず淇℃伅
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
