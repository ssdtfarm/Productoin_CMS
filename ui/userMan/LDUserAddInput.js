//该文件中包含客户端需要处理的函数和事件
var mDebug="0";
var mOperate="";
var showInfo;
//控制界面上mulLine的显示条数
var mulLineShowCount = 15;
//为了消除tomcat等的缓存机制设置的where语句永真式数字
var sqlcount = 1;
var strResult = "";
var turnPage = new turnPageClass();
var userTurnPage= new turnPageClass();
var arrSelected;

function change()
{
	if(!document.all)
		return;
	if (event.srcElement.name=="foldheader")
	{
		var srcIndex = event.srcElement.sourceIndex;
		var nested = document.all[srcIndex+1];
		if (nested.style.display=="none")
		{
			nested.style.display='';
		} else {
			nested.style.display="none";
		}
	}
}
document.onclick=change;

//提交，保存按钮对应操作
function submitForm()
{
	var i = 0;
	var showStr="正在保存数据，请您稍候并且不要修改屏幕上的值或链接其他页面";
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
    urlStr=encodeURI(encodeURI(urlStr));
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	fm.submit(); //提交
}

//提交后操作,服务器数据返回后执行的操作
function afterSubmit(FlagStr,Result)
{
	showInfo.close();
	if (FlagStr == "Fail") {
		var urlStr = "../common/jsp/MessagePage.jsp?picture=C&content="
				+ Result;
		showModalDialog(urlStr, window,
				"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
	} else {
		var urlStr = "../common/jsp/MessagePage.jsp?picture=S&content="
				+ Result;
		showModalDialog(urlStr, window,
				"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
	}
//	var action = fm.all("Action").value;
//	if (action == "update")
//	{
//		if (FlagStr == "true")
//			alert("更新用户成功!");
//		else
//			alert("更新用户失败!");
//	}
//	if (action == "insert")
//	{
//		if (FlagStr == "true")
//			alert("增加用户成功!");
//		else
//			alert("增加用户失败!");
//	}
}

//提交前的校验、计算
function beforeSubmit()
{
	if (fm.all("Action").value == "query")
		return true;
	if (fm.all("UserCode").value == "")
	{
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	if (fm.all("Action").value == "delete")
		return true;
	//增加和更新操作必须机构编码非空
	var comcode = fm.all("ComCode").value;
	if (comcode == null || comcode == "")
	{
		alert(""+I18NMsg("alertMsg")+"!");
		return false;
	}
	var pwd = fm.all("Password").value;
	if (pwd != fm.all("PasswordConfirm").value)
	{
		alert(""+I18NMsg("alertMsg")+"!");
		return false;
	}
	if (fm.all("Action").value == "update")
		return true;
	if (pwd == "")
	{
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	return true;
}

//Click事件，当点击增加按钮时触发该函数
function insertClick()
{
	//下面增加相应的代码
	divUserGrid.style.display = "none";
	divCmdButton.style.display = "none";
	divSubCmdButton.style.display = "";
	//20110310 heyj 用户管理需求优化，去掉对菜单组的处理，只处理用户信息
	//divMenuGrpGrid.style.display= "";
	divHideInput.style.display= "";
	//新增默认有效开始日期为当前系统日期
	fm.all('ValidStartDate').value = gToDay;
	//initAddGrid(); 20110310 heyj 用户管理需求优化，去掉对菜单组的处理，只处理用户信息
	fm.all("Action").value = "insert";
}

//用户点击更新按钮时触发该函数
function updateClick()
{
	//下面增加相应的代码
	var selUserNo = UserGrid.getSelNo();
	if (selUserNo == 0)
	{
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	var sql = "select usercode,username,comcode,password,userdescription,userstate,uwpopedom,claimpopedom," 
			+"otherpopedom,popuwflag,superpopedomflag,operator,makedate,maketime,validstartdate,validenddate," 
			+"certifyflag,edorpopedom,agentcom,(select name from ldcom where comcode=lduser.comcode) " 
			+"from lduser where usercode='"+UserGrid.getRowColData(selUserNo-1,2)+"' ";
	
	turnPage.strQueryResult  = easyQueryVer3(sql, 1, 0, 1);  
	  //判断是否查询成功
	  if (!turnPage.strQueryResult) {
	    alert(""+I18NMsg("alertMsg")+"");
	    return false;
	    }
	//查询成功则拆分字符串，返回二维数组
	  arrSelected = decodeEasyQueryResult(turnPage.strQueryResult);
	  if( arrSelected != null )
	  {
		var arrResult =arrSelected;
		//将选择的用户信息拷贝到各个信息输入框内
		fm.all("UserCode").value = arrResult[0][0];
		fm.all("UserCode").readonly;
		fm.all("UserName").value = arrResult[0][1];
//		fm.all("UserNameReadOnly").value = arrResult[0][1];
//		fm.all("UserCodeReadOnly").value = arrResult[0][0];
		fm.all("UserState").value = arrResult[0][5];
		if(arrResult[0][5]!=null && arrResult[0][5]!=""){
			if(arrResult[0][5]=="0") fm.all("UserStateName").value=""+I18NMsg("waitForTran")+"";
			if(arrResult[0][5]=="1") fm.all("UserStateName").value=""+I18NMsg("waitForTran")+"";
		}
		fm.all("AgentCom").value = "";
		fm.all("UserDescription").value = arrResult[0][4];
		fm.all("ComCode").value = arrResult[0][2];
		fm.all("ComCodeName").value = arrResult[0][19];
		fm.all("MakeDate").value = arrResult[0][12];
		fm.all("MakeTime").value = arrResult[0][13];
		fm.all("ValidStartDate").value = arrResult[0][14];
		fm.all("ValidEndDate").value = arrResult[0][15];
		fm.all("SuperPopedomFlag").value = arrResult[0][10];
		fm.all("Operator").value = arrResult[0][11];
		fm.all("ClaimPopedom").value = arrResult[0][7];
		fm.all("OtherPopedom").value = arrResult[0][8];
		fm.all("PopUWFlag").value = arrResult[0][9];
		fm.all("UWPopedom").value = arrResult[0][6];
		fm.all("EdorPopedom").value = arrResult[0][17];
		var tPassword = arrResult[0][3];
		//补齐8位，使所有的密码看起来一样
		for (var i = tPassword.length + 1; i <= 8; i++)
		{
			tPassword += " ";
		}
		fm.all("Password").value = tPassword;
		fm.all("PasswordConfirm").value = tPassword;
	}
	//判断当前操作员是否是选中用户的创建者
	var curOperator = fm.all("OperatorCode").value;
	var crtOperator = fm.all("Operator").value;
	//隐现需要的元素
	divUserGrid.style.display = "none";
	divCmdButton.style.display = "none";
	divSubCmdButton.style.display = "";
	//20110310 heyj 用户管理需求优化，只对用户进行处理，不在处理菜单组信息
	//divMenuGrpGrid.style.display= "";
	divHideInput.style.display= "";
	tdUserCode.style.display = "";
	tdUserName.style.display = "";
	//类型标志为修改
	fm.all("Action").value = "update";
}

//增加状态下点击确定按钮触发该函数
function insert()
{
	if(!beforeSubmit()) return;
	var UserCode = fm.all("UserCode").value;
	
	if(fm.all('UserName').value=="" || fm.all('UserName').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	if(fm.all('UserState').value=="" || fm.all('UserState').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}else{
		if(fm.all('UserState').value=="1" && (fm.all('ValidEndDate').value=="" || fm.all('ValidEndDate').value==null)){
			alert("用户状态为失效，有效结束日期不能为空！");
			return false;
		}
		if(fm.all('UserState').value=="0" && fm.all('ValidEndDate').value!="" && fm.all('ValidEndDate').value!=null){
			alert("用户状态为有效，有效结束日期应该为空！");
			return false;
		}
	}
	if(fm.all('ValidStartDate').value=="" || fm.all('ValidStartDate').value==null){
		alert("有效开始日期不能为空！");
		return false;
	}
	if((fm.all('PopUWFlag').value!="" && fm.all('PopUWFlag').value!=null) && fm.all('PopUWFlag').value.length>1 ){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	//校验用户是否唯一
//	var sql = "select * from lduser where usercode='"+UserCode+"' ";//此清单的参数信息，如果存在则回写到主页面显示
//    var arr = easyExecSql(sql);
//	if(arr){
//		alert("系统中存在"+UserCode+"用户信息！");
//		return false;
//    }
	submitForm();
}

//更新状态下点击确定按钮触发该函数
function update()
{
	fm.all("UserCode").value = fm.all("UserCode").value;
	if (!beforeSubmit()) return;
	var UserCode = fm.all("UserCode").value;
	fm.all("Action").value = "update";
	
	if(fm.all('UserName').value=="" || fm.all('UserName').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	if(fm.all('UserState').value=="" || fm.all('UserState').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}else{
		if(fm.all('UserState').value=="1" && (fm.all('ValidEndDate').value=="" || fm.all('ValidEndDate').value==null)){
			alert("用户状态为失效，有效结束日期不能为空！");
			return false;
		}
		if(fm.all('UserState').value=="0" && fm.all('ValidEndDate').value!="" && fm.all('ValidEndDate').value!=null){
			alert("用户状态为有效，有效结束日期应该为空！");
			return false;
		}
	}
	if(fm.all('ValidStartDate').value=="" || fm.all('ValidStartDate').value==null){
		alert("有效开始日期不能为空！");
		return false;
	}
	if((fm.all('PopUWFlag').value!="" && fm.all('PopUWFlag').value!=null) && fm.all('PopUWFlag').value.length>1 ){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	submitForm();
}

function saveSubmit()
{
	submitForm ();
}

function queryClick()
{
	//查询用户信息
//	var strSQL = "select username,usercode,decode(userstate,'1','"+I18NMsg("SQLResult")+"'),userdescription,comcode,agentcom,validstartdate,validenddate from lduser where 1=1 "
	var strSQL = "select username,usercode,(case when userstate='1' then '"+I18NMsg("SQLResult")+"' end),userdescription,comcode,agentcom,validstartdate,validenddate from lduser where 1=1 "
		+getWherePart('usercode','UserCode','like')
		+getWherePart('username','UserName','like')
		+getWherePart('comcode','ComCode','like')
		+getWherePart('comcode','OperatorComCode','like')
		+getWherePart('agentcom','AgentCom','like')
		+getWherePart('validstartdate','ValidStartDate','>=')
		+getWherePart('validenddate','ValidEndDate','<=')
		+" order by comcode,usercode ";
	//每行显示15行
	userTurnPage.pageLineNum=15;
	userTurnPage.queryModal(strSQL, UserGrid);
	if (UserGrid.mulLineCount == 0) {
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
}

function cancelClick()
{
	divSubCmdButton.style.display = "none";
	divCmdButton.style.display = "";
	divUserGrid.style.display = "";
	divHideInput.style.display= "none";
	tdUserCode.style.display = "";
	tdUserName.style.display = "";
	initForm();
}

function okClick()
{
	if (fm.all("Action").value == "insert")
	{
		insert();
	}
	if (fm.all("Action").value == "update")
	{
		update();
	}
}
