//该文件中包含客户端需要处理的函数和事件
var mDebug="0";
var mOperate="";
var showInfo;
//控制界面上mulLine的显示条数
var mulLineShowCount = 15;
//为了消除tomcat等的缓存机制设置的where语句永真式数字
var sqlcount = 1;
var selectCurPage = 0;
var unselectCurPage = 0;
var userCurPage = 0;
var menuCurPage = 0;
var selectArrayLen = 0;
var unselectArrayLen = 0;
var userArrayLen = 0;
var menuArrayLen = 0;
var selectArray;
var unselectArray;
var userArray;
var menuArray;
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
//初始化用户已选菜单组数组
function initSelectArray()
{
    selectArray = new Array();
    selectArrayLen = 0;
    selectCurPage = 0;
}

//初始化用户未选菜单组数组
function initUnselectArray()
{
    unselectArray = new Array();
    unselectArrayLen = 0;
    unselectCurPage = 0;
}

//初始化用户组
function initUserArray()
{
    userArray = new Array();
    userArrayLen = 0;
    userCurPage = 0;
}

function initMenuArray()
{
	menuArray = new Array();
	menuArrayLen = 0;
	menuCurPage = 0;
}

//填充用户组的multiLine
function fillUserGrid()
{
	UserGrid.clearData("UserGrid");
	for (var i = 0; i < mulLineShowCount; i++)
	{
		UserGrid.addOne("UserGrid");
		var offset = i  + userCurPage*mulLineShowCount;
		if (offset < userArrayLen)
		{
			UserGrid.setRowColData(i,1,userArray[offset][1]);
			UserGrid.setRowColData(i,2,userArray[offset][2]);
			UserGrid.setRowColData(i,3,userArray[offset][3]);
			UserGrid.setRowColData(i,4,userArray[offset][4]);
			UserGrid.setRowColData(i,5,userArray[offset][5]);
			UserGrid.setRowColData(i,6,userArray[offset][18]);
			if (userArray[offset][0] == 0)
				UnselectMenuGrpGrid.checkBoxSel(i+1);
		}
		else
		{
			UserGrid.setRowColData(i,1,"");
			UserGrid.setRowColData(i,2,"");
			UserGrid.setRowColData(i,3,"");
			UserGrid.setRowColData(i,4,"");
		}
	}
	//下面的代码是为了使翻页时序号能正确显示
	for (var i = 0; i < mulLineShowCount; i++)
	{
		var offset = i  + userCurPage*mulLineShowCount;
		fm.all("UserGridNo")[i].value = offset + 1;
	}
}

//填充显示未选菜单组的multiline
function fillUnselectGrid()
{
   UnselectMenuGrpGrid.clearData("UnselectMenuGrpGrid");

   for (var i = 0; i < mulLineShowCount; i++) {

       UnselectMenuGrpGrid.addOne("UnselectMenuGrpGrid");
   	   var offset = i  + unselectCurPage*mulLineShowCount;

   	   if (offset < unselectArrayLen) {

   	       UnselectMenuGrpGrid.setRowColData(i,1,unselectArray[offset][1]);
   	       UnselectMenuGrpGrid.setRowColData(i,2,unselectArray[offset][2]);
   	       UnselectMenuGrpGrid.setRowColData(i,3,""+I18NMsg("waitForTran")+"");
   	       if (unselectArray[offset][0] == 0)
   	           UnselectMenuGrpGrid.checkBoxSel(i+1);
   	   } else {

   	       UnselectMenuGrpGrid.setRowColData(i,1,"");
   	       UnselectMenuGrpGrid.setRowColData(i,2,"");
   	   }
   }

   //下面的代码是为了使翻页时序号能正确显示
   for (var i = 0; i < mulLineShowCount; i++) {
		var offset = i  + unselectCurPage*mulLineShowCount;
        fm.all("UnselectMenuGrpGridNo")[i].value = offset + 1;
   }

}

//填充显示以选选菜单组的multiline
function fillSelectGrid()
{
   SelectMenuGrpGrid.clearData("SelectMenuGrpGrid");
   for (var i = 0; i < mulLineShowCount; i++) {
   	  SelectMenuGrpGrid.addOne("SelectMenuGrpGrid");
   	  var offset = i  + selectCurPage*mulLineShowCount;
   	  if (offset < selectArrayLen) {
   	      SelectMenuGrpGrid.setRowColData(i,1,selectArray[offset][1]);
   	      SelectMenuGrpGrid.setRowColData(i,2,selectArray[offset][2]);
   	      SelectMenuGrpGrid.setRowColData(i,3,""+I18NMsg("waitForTran")+"");
		  if (selectArray[offset][0] == 0)
   	          SelectMenuGrpGrid.checkBoxSel(i+1);
   	  } else {
   	      SelectMenuGrpGrid.setRowColData(i,1,"");
   	      SelectMenuGrpGrid.setRowColData(i,2,"");
   	  }
   }

   //下面的代码是为了使翻页时序号能正确显示
   for (var i = 0; i < mulLineShowCount; i++) {
		var offset = i  + selectCurPage*mulLineShowCount;
        fm.all("SelectMenuGrpGridNo")[i].value = offset + 1;
   }
}

//将未选菜单组中的选中菜单组加入用户以选菜单组
function addMenus()
{
	markSelectChk();
	markUnselectChk();
	unselectToSelectArray();
	fillSelectGrid();
	fillUnselectGrid();
}

//将已选菜单组中的选中菜单组加入用户未选菜单组
function removeMenus()
{
	markSelectChk();
	markUnselectChk();
	selectToUnselectArray();
	fillSelectGrid();
	fillUnselectGrid();
}

function userFirstPage()
{
	if (userArrayLen == 0) return;
	userCurPage = 0;
	fillUserGrid();
}

function userLastPage()
{
	if (userArrayLen == 0) return;
	while ((userCurPage + 1)*mulLineShowCount < userArrayLen) userCurPage++;
	fillUserGrid();
}

function userPageDown()
{
	if (userArrayLen == 0) return;
	if (userArrayLen <= (userCurPage + 1) * mulLineShowCount)
	{
		alert(""+I18NMsg("alertMsg")+"");
	}
	else
	{
		userCurPage++;
		fillUserGrid();
	}
}

function userPageUp()
{
	if (userArrayLen == 0) return;
	if (userCurPage == 0)
	{
		alert(""+I18NMsg("alertMsg")+"");
	}
	else
	{
		userCurPage--;
		fillUserGrid();
	}
}

function selectFirstPage()
{
	if (selectArrayLen == 0) return;
	selectCurPage = 0;
	fillSelectGrid();
}

function selectLastPage()
{
	if (selectArrayLen == 0) return;
	while ((selectCurPage + 1)*mulLineShowCount < selectArrayLen) selectCurPage++;
	fillSelectGrid();
}

function selectPageDown()
{
	if (selectArrayLen == 0) return;
	if (selectArrayLen <= (selectCurPage + 1) * mulLineShowCount)
	{
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	//将此页的选中信息保存到array中去
	for (var i = 0; i< mulLineShowCount; i++) {
		var offset = i + selectCurPage * mulLineShowCount;
		if (offset >= selectArrayLen) continue;
		if (SelectMenuGrpGrid.getChkNo(i))
			selectArray[offset][0] = 0;
		else
			selectArray[offset][0] = 1;
	}
	selectCurPage++;
	fillSelectGrid();
}

function selectPageUp()
{
	if (selectArrayLen == 0) return;
	if (selectCurPage == 0)
	{
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	//将此页的选中信息保存到array中去
	for (var i = 0; i< mulLineShowCount; i++)
	{
		var offset = i + selectCurPage * mulLineShowCount;
		if (offset >= selectArrayLen) continue;
		if (SelectMenuGrpGrid.getChkNo(i))
			selectArray[offset][0] = 0;
		else
			selectArray[offset][0] = 1;
	}
	selectCurPage--;
	fillSelectGrid();
}

function unselectFirstPage()
{
	if (unselectArrayLen == 0) return;
	unselectCurPage = 0;
	fillUnselectGrid();
}

function unselectLastPage()
{
	if (unselectArrayLen == 0) return;
	while ((unselectCurPage + 1)*mulLineShowCount < unselectArrayLen) unselectCurPage++;
	fillUnselectGrid();
}

function unselectPageDown()
{
	if (unselectArrayLen == 0) return;
	if (unselectArrayLen <= (unselectCurPage + 1) * mulLineShowCount) {
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	markUnselectChk();
	unselectCurPage++;
	fillUnselectGrid();
}

function unselectPageUp()
{
	if (unselectArrayLen == 0) return;
	if (unselectCurPage == 0) {
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	markUnselectChk();
	unselectCurPage--;
	fillUnselectGrid();
}

//将选中的菜单在selectArray中进行标记
function markSelectChk()
{
    var gridCount = SelectMenuGrpGrid.mulLineCount;
    for (var i = 0; i< gridCount; i++) {
    	var offset = i + selectCurPage * mulLineShowCount;

    	if (offset >= selectArrayLen)
    	    continue;

    	if (SelectMenuGrpGrid.getChkNo(i))
    	    selectArray[offset][0] = 0;
    	 else
    	    selectArray[offset][0] = 1;
    }
}

function markUnselectChk()
{
    var gridCount = UnselectMenuGrpGrid.mulLineCount;
    for (var i = 0; i< gridCount; i++) {
    	var offset = i + unselectCurPage * mulLineShowCount;

    	if (offset >= unselectArrayLen)
    	    continue;

    	if (UnselectMenuGrpGrid.getChkNo(i)) {
    	    unselectArray[offset][0] = 0;
    	} else {
    	    unselectArray[offset][0] = 1;
    	}
    }

}

function unselectToSelectArray()
{
	var index = 0;
	while (index < unselectArrayLen)
	{
		if (unselectArray[index][0] == 1)
		{
			index++;
			continue;
		}
		// 加入selectArray中
		selectArray[selectArrayLen] = new Array();
		selectArray[selectArrayLen][0] = 1;
		selectArray[selectArrayLen][1] = unselectArray[index][1];
		selectArray[selectArrayLen][2] = unselectArray[index][2];
		selectArrayLen++;
		//在未选菜单集合中去除此菜单节点
		for (var i = index+1; i < unselectArrayLen; i++)
			unselectArray[i-1] = unselectArray[i];
		unselectArrayLen--;
	}
}

function selectToUnselectArray()
{
	var index = 0;
	while (index < selectArrayLen)
	{
		if (selectArray[index][0] == 1)
		{
			index++;
			continue;
		}
		// 加入unselectArray中
		unselectArray[unselectArrayLen] = new Array();
		unselectArray[unselectArrayLen][0] = 1;
		unselectArray[unselectArrayLen][1] = selectArray[index][1];
		unselectArray[unselectArrayLen][2] = selectArray[index][2];
		unselectArrayLen++;
		//在已选菜单集合中去除此菜单节点
		for (var i = index+1; i < selectArrayLen; i++)
			selectArray[i-1] = selectArray[i];
		selectArrayLen--;
	}
}

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
}

function queryDetailProcess(Result)
{
	var tempArray = decodeEasyQueryResult(Result);
	if (tempArray == null)
	{
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	initUserArray();
	userArrayLen = tempArray.length;
	for (var i = 0; i < tempArray.length; i++)
	{
		userArray[i] = new Array();
		userArray[i][0] = 1;
		userArray[i][1] = tempArray[i][1];
		userArray[i][2] = tempArray[i][0];
		userArray[i][3] = tempArray[i][5];
		userArray[i][4] = tempArray[i][4];
		userArray[i][5] = tempArray[i][2];
		userArray[i][6] = tempArray[i][12];
		userArray[i][7] = tempArray[i][13];
		userArray[i][8] = tempArray[i][14];
		userArray[i][9] = tempArray[i][15];
		userArray[i][10] = tempArray[i][10];
		userArray[i][11] = tempArray[i][11];
		userArray[i][12] = tempArray[i][7];
		userArray[i][13] = tempArray[i][8];
		userArray[i][14] = tempArray[i][9];
		userArray[i][15] = tempArray[i][6];
		userArray[i][16] = tempArray[i][3];
		userArray[i][17] = tempArray[i][17];
		userArray[i][18] = tempArray[i][18];
	}
	fillUserGrid();
}

//提交前的校验、计算
function beforeSubmit()
{
	if (fm.all("Action").value == "query")
		return true;
	if (fm.all("Action").value == "delete")
		return true;
	if (fm.all("UserCode").value == "")
	{
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	//增加和更新操作必须机构编码非空
	var comcode = fm.all("ComCode").value;
	if (comcode == null || comcode == "")
	{
		alert(""+I18NMsg("alertMsg")+"!");
		return false;
	}
	if (fm.all("Action").value == "update")
		return true;
	return true;
}

//用户点击更新按钮时触发该函数
function updateClick()
{
	var selUserNo = UserGrid.getSelNo();
	if (selUserNo == 0) {
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	var sql = "select usercode,username,comcode,agentcom,(select name from ldcom where comcode=lduser.comcode) "
			+ "from lduser where usercode='"
			+ UserGrid.getRowColData(selUserNo - 1, 2) + "' ";

	turnPage.strQueryResult = easyQueryVer3(sql, 1, 0, 1);
	// 判断是否查询成功
	if (!turnPage.strQueryResult) {
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	// 查询成功则拆分字符串，返回二维数组
	arrSelected = decodeEasyQueryResult(turnPage.strQueryResult);
	if (arrSelected != null) {
		var arrResult = arrSelected;
		// 将选择的用户信息拷贝到各个信息输入框内
		fm.all("UserCode").value = arrResult[0][0];
		fm.all("UserCode").readonly;
		fm.all("UserName").value = arrResult[0][1];
		fm.all("UserName").readonly;
		fm.all("ComCode").value = arrResult[0][2];
		fm.all("ComCode").readonly;
		fm.all("ComCodeName").value = arrResult[0][4];
		fm.all("AgentCom").value = arrResult[0][3];
		fm.all("AgentCom").readonly;
	}
	// 隐现需要的元素
	divUserGrid.style.display = "none";
	divCmdButton.style.display = "none";
	divSubCmdButton.style.display = "";
	divMenuGrpGrid.style.display= "";

	//取得选中用户对应的菜单组
	showMenuGrp();
	fm.all("Action").value = "update";
}

//更新状态下点击确定按钮触发该函数
function update()
{
    //保存用户的菜单组信息
	if (!beforeSubmit()) return;
	var UserCode = fm.all("UserCode").value;
	HideMenuGrpGrid1.clearData("HideMenuGrpGrid1");
	for (var i = 0; i < selectArrayLen; i++)
	{
		HideMenuGrpGrid1.addOne("HideMenuGrpGrid1");
		HideMenuGrpGrid1.setRowColData(i,1,UserCode);
		HideMenuGrpGrid1.setRowColData(i,2,selectArray[i][1]);
	}
	fm.all("Action").value = "update";
	submitForm();
}

function saveSubmit()
{
	submitForm ();
}

function queryClick()
{
	//查询用户信息
//	var strSQL = "select username,usercode,decode(userstate,'1','"+I18NMsg("SQLResult")+"'),userdescription,comcode,agentcom from lduser where " 
	var strSQL = "select username,usercode,(case when userstate='1' then '"+I18NMsg("SQLResult")+"' end),userdescription,comcode,agentcom from lduser where " 
		+"(userstate='0' or userstate is null) and comcode like '"+mComCode+"%' "
		+getWherePart('usercode','UserCode','like')
		+getWherePart('username','UserName','like')
		+getWherePart('comcode','ComCode','like')
		+getWherePart('agentcom','AgentCom','like')
		+" order by comcode,usercode ";
	//每行显示15行
	userTurnPage.pageLineNum=15;
	userTurnPage.queryModal(strSQL, UserGrid);
	if (UserGrid.mulLineCount == 0) {
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
}

function showMenuGrp()
{
	var selUserNo = UserGrid.getSelNo();
	if (selUserNo == 0)
	{
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	//获得选中的用户编码信息
	var userCode = UserGrid.getRowColData(selUserNo - 1, 2);
	var sqlStr = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp "
		+ " where 1=1 and "
		+ "MenuGrpCode in  ( select MenuGrpCode from LDUserToMenuGrp "
		+ "where UserCode = '"+ userCode + "' and MenuGrpCode in(" 
		+ "select a.menugrpcode from ldmenugrp a,lddeptadminconfig b " 
		+ "where a.team=b.depno and b.deplevel='02' and b.depmanager='"+fm.all('operatorComCode').value+"'))";
	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
	//查询成功则拆分字符串，返回二维数组
	var tempSelectArray = decodeEasyQueryResult(strTemp);
	sqlStr = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp "
		+ "where 1=1 and MenuGrpCode not in  ( select MenuGrpCode from LDUserToMenuGrp "
		+ "where UserCode = '" + userCode + "' ) " 
		+ "and MenuGrpCode in (select a.menugrpcode from ldmenugrp a,lddeptadminconfig b " 
		+ "where a.team=b.depno and b.deplevel='02' and b.depmanager='"+fm.all('operatorComCode').value+"')";
	strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
	var tempUnselectArray = decodeEasyQueryResult(strTemp);
	initSelectArray();
	initUnselectArray();
	if (tempSelectArray != null)
	{
		selectArrayLen = tempSelectArray.length;
		for (var i = 0; i < tempSelectArray.length; i++)
		{
			selectArray[i] = new Array;
			selectArray[i][0] = 1;
			selectArray[i][1] = tempSelectArray[i][0];
			selectArray[i][2] = tempSelectArray[i][1];
		}
	}
	if (tempUnselectArray != null) {
		unselectArrayLen = tempUnselectArray.length;
		for (var i = 0; i < tempUnselectArray.length; i++)
		{
			unselectArray[i] = new Array;
			unselectArray[i][0] = 1;
			unselectArray[i][1] = tempUnselectArray[i][0];
			unselectArray[i][2] = tempUnselectArray[i][1];
		}
	}
	fillUnselectGrid();
	fillSelectGrid();
}

function addSqlcount()
{
	sqlcount++;
	if (sqlcount >= 100)
		sqlcount = 0;
}

//显示用户具有的菜单组的菜单
function showSelectGridMenus(param1)
{
	var MenuGrpCode = fm.all(param1).all('SelectMenuGrpGrid1').value;
	var row = fm.all(param1).all('SelectMenuGrpGridNo').value;
	if (row  > selectArrayLen)
		return;
	// 查询出此菜单组对应的菜单集合
	var sqlStr = "select ParentNodeCode,ChildFlag,nodename,nodecode from LDMenu "
		+ "where NodeCode in (select NodeCode from LDMenuGrpToMenu "
		+ "where MenuGrpCode = '" + MenuGrpCode + "') order by nodeorder";
	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
	//查询成功则拆分字符串，返回二维数组
	var tempSelectArray = decodeEasyQueryResult(strTemp);
	initMenuArray();
	if (tempSelectArray != null)
	{
		//初始化selectArray
		for (var i = 0; i < tempSelectArray.length ; i++)
		{
			menuArray[i] = new Array();
			menuArray[i][0] = 0;
			menuArray[i][1] = tempSelectArray[i][0];
			menuArray[i][2] = tempSelectArray[i][1];
			menuArray[i][3] = tempSelectArray[i][2];
			menuArray[i][4] = tempSelectArray[i][3];
			menuArray[i][5] = 0;
			menuArray[i][6] = 0;
			menuArray[i][7] = 0;
			menuArray[i][8] = "sel_" + tempSelectArray[i][3];
		}
	}
	paintTree_ReadOnly(menuArray,"spanMenuTree");
}

//显示用户不具有的菜单组的菜单
function showUnselectGridMenus(param1)
{
	var row = fm.all(param1).all('UnselectMenuGrpGridNo').value;
	if (row > unselectArrayLen)
		return;
	var MenuGrpCode = fm.all(param1).all('UnselectMenuGrpGrid1').value;
	// 查询出此菜单组对应的菜单集合
	var sqlStr = "select ParentNodeCode,ChildFlag,nodename,nodecode from LDMenu  "
		+ "where NodeCode in (select NodeCode from LDMenuGrpToMenu "
		+ "where MenuGrpCode = '" + MenuGrpCode + "') order by nodeorder";
	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
	//查询成功则拆分字符串，返回二维数组
	var tempUnselectArray = decodeEasyQueryResult(strTemp);
	if (tempUnselectArray == null)
	{
		alert(""+I18NMsg("alertMsg")+"!");
		return;
	}
	initMenuArray();
	if (tempUnselectArray != null) {
		//初始化selectArray
		for (var i = 0; i < tempUnselectArray.length ; i++)
		{
			menuArray[i] = new Array();
			menuArray[i][0] = 0;
			menuArray[i][1] = tempUnselectArray[i][0];
			menuArray[i][2] = tempUnselectArray[i][1];
			menuArray[i][3] = tempUnselectArray[i][2];
			menuArray[i][4] = tempUnselectArray[i][3];
			menuArray[i][5] = 0;
			menuArray[i][6] = 0;
			menuArray[i][7] = 0;
			menuArray[i][8] = "unsel_" + tempUnselectArray[i][3];
		}
	}
	paintTree_ReadOnly(menuArray,"spanMenuTree");
}
//退出取消命令
function cancelClick()
{
	divSubCmdButton.style.display = "none";
	divCmdButton.style.display = "";
	divUserGrid.style.display = "";
	divMenuGrpGrid.style.display = "none";
	tdUserCode.style.display = "";
	tdUserName.style.display = "";
	clearTree("spanMenuTree");
	initForm();
}
//确认命令
function okClick()
{
	//用户授权只有update，没有其他类型的操作了
	if (fm.all("Action").value == "update")
	{
		update();
	}
}

function initAddGrid()
{
	initSelectArray();
	initUnselectArray();
	//查询成功则拆分字符串，返回二维数组
	var Operator = fm.all('Operator').value; //增加和更新处理不一样
	sqlStr = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp where  Operator = '" + Operator + "'";
	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
	var tempUnselectArray = decodeEasyQueryResult(strTemp);
	if (tempUnselectArray != null)
	{
		unselectArrayLen = tempUnselectArray.length;
		for (var i = 0; i < tempUnselectArray.length; i++)
		{
			unselectArray[i] = new Array;
			unselectArray[i][0] = 1;
			unselectArray[i][1] = tempUnselectArray[i][0];
			unselectArray[i][2] = tempUnselectArray[i][1];
		}
	}
	fillUnselectGrid();
	fillSelectGrid();
}
