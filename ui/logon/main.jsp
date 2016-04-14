<%@include file="/i18n/language.jsp"%>
<%@page pageEncoding="UTF-8" contentType='text/html;charset=utf-8' %>
<%@page import="com.sinosoft.lis.pubfun.GlobalInput"%>
<%@page import="java.util.List,java.util.ArrayList,java.util.*,java.util.Date,java.text.*"%>
<%@page import="java.util.Enumeration"%>
<%
    Calendar cal = Calendar.getInstance();
    String time ="";
    String date="";
    String[] strArray;

	Enumeration e=session.getAttributeNames(); 
	while(e.hasMoreElements()){ 
		String sessionName=(String)e.nextElement(); 
		System.out.print("存在的session有："+sessionName); 
		session.removeAttribute(sessionName); 
		System.out.println("----已清除"); 
	}
    session.invalidate();
    
    DecimalFormat df = new DecimalFormat("00");
   	time=cal.get(Calendar.YEAR)+"";
   	time+=df.format(cal.get(Calendar.MONTH)+1);
   	time+=df.format(cal.get(Calendar.DAY_OF_MONTH));
    String str="";
    if(str.equals("")){
        str=bundle.getString("waitForTran");
        date=time;
        strArray=str.split("；");
    }
    else{
     	date = str.substring(0,str.indexOf('\n'));
     	strArray= str.substring(str.indexOf('\n')+1).split("；");
    }
 %>
<html>
<head>
<title>
Sinosoft
</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../common/javascript/Common.js"></script>
<script src="inform.js"></script>
<SCRIPT src="../common/cvar/CCodeOperate.js"></SCRIPT>
<SCRIPT src="../common/ajax/prototype.js"></SCRIPT>
<SCRIPT src="../common/easyQueryVer3/EasyQueryVer3.js"></SCRIPT>

<link rel='stylesheet' type='text/css' href='../common/css/other.css'>
<style type="text/css">
img{
	vertical-align: bottom;
	height: 21px;
	cursor: hand;
}

</style>
<script language=javascript>
function submitForm(){
	if (!achieveInit()) return false;

	if(fm.language.value.length == 0){
		myAlert("Please input language!");
		return false;
	}

	if(fm.UserCode.value.length == 0){
		myAlert(I18NMsg("Pleaseinputusername!"));
		return false;
	}

	if (fm.ComCode.value.length == 0){
		myAlert(I18NMsg("Pleaseselectamanagementorganiaszation!") );
		return false;
	}

	fm.ClientURL.value = document.location;
	fm.submit();
	return true;
}

function achieveInit() {
	try {
		var tVD = top.achieveVD;
		var tEX = top.achieveEX;

		if (!(tVD && tEX)) {
			//alert("tVD:" + tVD + "\ntEX:" + tEX + "\nmCs:" + typeof(mCs));
			top.window.location = "../indexlis.jsp";
			myAlert(bundle.getString("initFaild"));
			return false;
		}
	}
	catch(ex) {
		myAlert(""+bundle.getString("initFaild")+"!\ntop.window.location = '../indexlis.jsp'");
		return false;
	}
	return true;
}

function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
</script>

</head>

<body bgcolor="#cccccc" text="#000000" background="" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="showOpenWindow();">
<form name="fm" action="./LogonSubmit.jsp" method="post">

	<div class="login">
		<table class="common" style='position:relative;'>
		<tr>
		<td class="userClass"><span class="enClass"></span></td><td>
			<input class="input" name=language size="14" maxlength="14" id="language" value='en' onDblClick="return showCodeList('language1',[this],[0]);"/></td>
		</tr>
		<tr>
		<td class="userClass"><span class="enClass"></span></td><td><input class="input" value='' type='text'name=UserCode id="UserCode"  size="15"  maxlength="20" ></td>
		</tr>
		<tr>
		<td class="userClass"><span class="enClass"></span></td><td><input class="input_pw" value=''  type="Password" autocomplete="off" name=PWD  id="PWD" size="15"  maxlength="20" ></td>
		</tr>
		<tr>
		<td ><span class="enClass"></span></td><td>
			<Input name=ComCode class='input' value='2'
						ondblclick="return showCodeList('comcode',[this,BranchType2QName],[0,1]);" 
						onkeyup="return showCodeListKey('comcode',[this,BranchType2QName],[0,1]);"><input name=BranchType2QName  class='codename' readonly=true style='display:none;'>
			</td>
		</tr>
		</table>
		<table class="btnTable">
		<tr><td colspan="2"  class="userClass">
			<input type='submit' value='' class="btlogin" onclick="return submitForm();"  onmouseover="this.className='btloginover'" onmouseout="this.className='btlogin'">
		<input type='button' value='' class="btcancle" onclick="fm.reset();return false;" onmouseover="this.className='btcancleover'" onmouseout="this.className='btcancle'"> </td></tr>
		</table>
<!--		<div class='copyright'>
<%=bundle.getString("waitForTran")%><br>
			Copyright 2010 China Sinosoft Co.Ltd All Rights Reserved.	
		</div>-->
	</div>
	<input TYPE="hidden" name="ClientURL" value="">
	<input TYPE="hidden" name="FormURL" value="./InitUserSave.jsp">
<span id="spanCode"  style="display: none; position:absolute; slategray; left:0px; top:0px; width: 150px; height:10px;"></span>
</form>
</body>
</html>
<script language=javascript>
	fm.UserCode.focus();
</script>
<script language="JavaScript">
	try
	{
		if(fm.all('language').value!='null' && fm.all('language').value!="") {
			document.getElementsByName("language")[0].value=fm.all('language').value
		}
	    document.getElementsByName("UserCode")[0].focus();
	    showOneCodeName('language', 'language1', 'language');
	}
	catch (ex) {}
</script>

