//该文件中包含客户端需要处理的函数和事件
var mDebug="0";
var mOperate="";
var showInfo;
//控制界面上mulLine的显示条数
var mulLineShowCount = 5;
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
//var mySql=new SqlClass();
//mySql.setJspName("../../userMan/UserAddSql.jsp");

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
//		alert("这还有呢");
		UserGrid.addOne("UserGrid");
	}
	for (var i = 0; i < mulLineShowCount; i++)
	{
//		alert("这还有呢");
//		UserGrid.addOne("UserGrid");
//		alert("这就没了");
		var offset = i  + userCurPage*mulLineShowCount;
		if (offset < userArrayLen)
		{
//			alert("offset："+offset+"  i:"+i+"  "+userArray[offset][2]);
			UserGrid.setRowColData(i,1,userArray[offset][1]);
			UserGrid.setRowColData(i,2,userArray[offset][2]);
			UserGrid.setRowColData(i,3,userArray[offset][3]);
			UserGrid.setRowColData(i,4,userArray[offset][4]);
			UserGrid.setRowColData(i,5,userArray[offset][5]);
			UserGrid.setRowColData(i,6,userArray[offset][18]);
			if (userArray[offset][0] == 0)
			{
				UnselectMenuGrpGrid.checkBoxSel(i+1);
//				alert("这是啥意思");
			}
//			alert("mulLineCount:"+UserGrid.mulLineCount);
//			alert("offset："+offset+"  i:"+i+"  "+userArray[offset][2]);
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
   }
   for (var i = 0; i < mulLineShowCount; i++) {

//       UnselectMenuGrpGrid.addOne("UnselectMenuGrpGrid");
   	   var offset = i  + unselectCurPage*mulLineShowCount;

   	   if (offset < unselectArrayLen) {

   	       UnselectMenuGrpGrid.setRowColData(i,1,unselectArray[offset][1]);
   	       UnselectMenuGrpGrid.setRowColData(i,2,unselectArray[offset][2]);
   	       UnselectMenuGrpGrid.setRowColData(i,3,I18NMsg("DetailMenu"));
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
   }
   for (var i = 0; i < mulLineShowCount; i++) {
//   	  SelectMenuGrpGrid.addOne("SelectMenuGrpGrid");
   	  var offset = i  + selectCurPage*mulLineShowCount;
   	  if (offset < selectArrayLen) {
   	      SelectMenuGrpGrid.setRowColData(i,1,selectArray[offset][1]);
   	      SelectMenuGrpGrid.setRowColData(i,2,selectArray[offset][2]);
   	      SelectMenuGrpGrid.setRowColData(i,3,I18NMsg("DetailMenu"));
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
//	initAddGrid();
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
		alert(I18NMsg("Youhavebeeninlastpage!") );
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
		alert(I18NMsg("Youhavebeeninfirstpage!"));
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
		alert(I18NMsg("Youhavebeeninlastpage!") );
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
		alert(I18NMsg("Youhavebeeninfirstpage!"));
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
		alert(I18NMsg("Youhavebeeninlastpage!") );
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
		alert(I18NMsg("Youhavebeeninfirstpage!"));
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
	var showStr=I18NMsg("IsSavingData,PleaseWaitandNotChangeValueo");
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
    urlStr=encodeURI(encodeURI(urlStr));
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	fm.submit(); //提交
}

//提交后操作,服务器数据返回后执行的操作
function afterSubmit(FlagStr,Result)
{
	showInfo.close();
	var action = fm.all("Action").value;
	if (action == "query")
	{
		if (FlagStr == "true")
		{
			queryDetailProcess(Result);
			strResult = Result;
		}
		else
		{
			alert(I18NMsg("EnquiryUserfailed!") );
			 location.reload();
		}
	}
	if (action == "update")
	{
		if (FlagStr == "true")
			alert(I18NMsg("ModifyUsersucceeded!"));
		else
			alert(I18NMsg("ModifyUserfailed!"));
	}
	if (action == "insert")
	{
		if (FlagStr == "true")
			alert(I18NMsg("AddUsersucceeded!"));
		else
			alert(I18NMsg("AddUserfailed!"));
	}
	if (action == "delete")
	{
		if (FlagStr == "true")
			alert(I18NMsg("DeleteUsersucceeded!"));
		else
			alert(I18NMsg("DeleteUserfailed!"));
	}
}
var mySql=new SqlClass();
mySql.setJspName("../../userMan/UserAddSql.jsp");
function queryDetailProcess(Result)
{
	var tempArray = decodeEasyQueryResult(Result);
	if (tempArray == null)
	{
//		alert(""+I18NMsg("Alert_SearchJsMsg3")+"");
		return false;
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
//	mySql.setSqlId("SearchResult");
//	mySql.setValue("p_UserCode",trim(fm.all('UserCode').value));
//	mySql.setValue("p_UserName",trim(fm.all('UserName').value));
//	mySql.setValue("p_ComCode",trim(fm.all('ComCode').value));
//	mySql.setValue("p_ValidStartDate",trim(fm.all('ValidStartDate').value));
//	mySql.setValue("p_ValidEndDate",trim(fm.all('ValidEndDate').value));
//	turnPage.strQueryResult  = easyQueryVer3(mySql.getString(), 1, 1, 1);
//	if (!turnPage.strQueryResult) {// 判断是否查询成功
////		alert(I18NMsg("Alert_SearchJsMsg4"));
//		return false;
//	}
//	turnPage.pageLineNum = 10;
//	turnPage.queryModal(mySql.getString(), UserGrid);	
//	return true;
}

//提交前的校验、计算
function beforeSubmit()
{
	if (fm.all("Action").value == "query")
		return true;
	if (fm.all("UserCode").value == "")
	{
		alert(I18NMsg("Usernamecannotbeblank!"));
		return false;
	}
	if (fm.all("Action").value == "delete")
		return true;
	//增加和更新操作必须机构编码非空
	var comcode = fm.all("ComCode").value;
	if (comcode == null || comcode == "")
	{
		alert(I18NMsg("OrganizationCodecannotbeblank!"));
		return false;
	}
	if (fm.all("Action").value == "update")
		return true;
	return true;
}

//Click事件，当点击“删除”按钮时触发该函数
function deleteClick()
{
	//下面增加相应的删除代码
	var selUserNo = UserGrid.getSelNo();
	if (selUserNo == 0)
	{
		alert(I18NMsg("User_Pleaseselectarecord!"));
		return;
	}
	var offset = mulLineShowCount * userCurPage + selUserNo - 1;
	var curOperator = fm.all("OperatorCode").value;
	if (curOperator == "")
	{
		alert(I18NMsg("Cannotgettheinformationofoperator!") );
		return;
	}
	//当前操作员不是选中用户的创建者
	if (curOperator != userArray[offset][11])
	{
		alert(I18NMsg("Currentoperatorisnotthecreateroftheuserbeenselected!"));
		return;
	}
	if (confirm(I18NMsg("Alert_DeleteConfirm")))
	{
		fm.all("Action").value = "delete";
		submitForm();
	}
	else
	{
		mOperate="";
	}
}

//Click事件，当点击增加按钮时触发该函数
function insertClick()
{
	//下面增加相应的代码
	divUserGrid.style.display = "none";
	divCmdButton.style.display = "none";
	divSubCmdButton.style.display = "";
	divMenuGrpGrid.style.display= "";
	divHideInput.style.display= "";
	initAddGrid();
	fm.all("Action").value = "insert";
}

//用户点击更新按钮时触发该函数
function updateClick()
{
	//下面增加相应的代码
	var selUserNo = UserGrid.getSelNo();
	if (selUserNo == 0)
	{
		alert(I18NMsg("User_Pleaseselectarecord!"));
		return;
	}
	//将选择的用户信息拷贝到各个信息输入框内
	var offset = userCurPage * mulLineShowCount + selUserNo -1;
	fm.all("UserName").value = userArray[offset][1];
	fm.all("UserNameReadOnly").value = userArray[offset][1];
	fm.all("UserCodeReadOnly").value = userArray[offset][2];
	fm.all("UserState").value = userArray[offset][3];
	//fm.all("UserDescription").value = userArray[offset][4];
	fm.all("ComCode").value = userArray[offset][5];
	fm.all("MakeDate").value = userArray[offset][6];
	fm.all("MakeTime").value = userArray[offset][7];
	fm.all("ValidStartDate").value = userArray[offset][8];
	fm.all("ValidEndDate").value = userArray[offset][9];
	fm.all("SuperPopedomFlag").value = userArray[offset][10];
	fm.all("Operator").value = userArray[offset][11];
	fm.all("ClaimPopedom").value = userArray[offset][12];
	fm.all("OtherPopedom").value = userArray[offset][13];
	fm.all("PopUWFlag").value = userArray[offset][14];
	fm.all("UWPopedom").value = userArray[offset][15];
	fm.all("EdorPopedom").value = userArray[offset][17];
//	var tPassword = userArray[offset][16];
//	//补齐8位，使所有的密码看起来一样
//	for (var i = tPassword.length + 1; i <= 8; i++)
//	{
//		tPassword += " ";
//	}
//	fm.all("Password").value = tPassword;
//	fm.all("PasswordConfirm").value = tPassword;
	//判断当前操作员是否是选中用户的创建者
	var curOperator = fm.all("OperatorCode").value;
	var crtOperator = fm.all("Operator").value;
	if (curOperator == crtOperator)
	{
		//隐现需要的元素
		divUserGrid.style.display = "none";
		divCmdButton.style.display = "none";
		divSubCmdButton.style.display = "";
		divMenuGrpGrid.style.display= "";
		divHideInput.style.display= "";
		tdUserCode.style.display = "none";
		tdUserCodeReadOnly.style.display = "";
	}
	else
	{
		divUserGrid.style.display = "none";
		divCmdButton.style.display = "none";
		divSubCmdButton.style.display = "";
		divMenuGrpGrid.style.display= "";
		tdUserCode.style.display = "none";
		tdUserCodeReadOnly.style.display = "";
		tdUserName.style.display = "none";
		tdUserNameReadOnly.style.display = "";
		validTR.style.display = "none";
	}
	//取得选中用户对应的菜单组
	showMenuGrp();
	fm.all("Action").value = "update";
}

//增加状态下点击确定按钮触发该函数
function insert()
{
	if(!beforeSubmit()) return;
	var UserCode = fm.all("UserCode").value;
	HideMenuGrpGrid1.clearData("HideMenuGrpGrid1");
	for (var i = 0; i < selectArrayLen; i++)
	{
		HideMenuGrpGrid1.addOne("HideMenuGrpGrid1");
		HideMenuGrpGrid1.setRowColData(i,1,UserCode);
		HideMenuGrpGrid1.setRowColData(i,2,selectArray[i][1]);
	}
	submitForm();
}

//更新状态下点击确定按钮触发该函数
function update()
{
	fm.all("UserCode").value = fm.all("UserCodeReadOnly").value;
	var curOperator = fm.all("OperatorCode").value;
	var crtOperator = fm.all("Operator").value;
	if (curOperator == crtOperator)
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
	fm.all("Action").value = "query";
	if (!beforeSubmit())
		return;
	var showStr=I18NMsg("Enquiringdata,pleasewaitanddonotedittheinformationonscreenorjumptoanyotherpage");
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
    urlStr=encodeURI(encodeURI(urlStr));
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	var showStr="";
	fm.submit();
}
//将sql存入jsp
var mySql=new SqlClass();
mySql.setJspName("../../userMan/UserAddSql.jsp");
function showMenuGrp()
{
	var selUserNo = UserGrid.getSelNo();
	if (selUserNo == 0)
	{
		alert(I18NMsg("User_Pleaseselectarecord!"));
		return;
	}
	var offset = userCurPage * mulLineShowCount + selUserNo - 1;
	var userCode = userArray[offset][2];
	var operator = fm.all("OperatorCode").value;
	//改动1----------------tempSelectArray------------------------------
	mySql.setSqlId("tempSelectArray");  
	mySql.setValue("p_userCode",userCode);
	mySql.setValue("p_operator",operator);
	var Result =easyQueryVer3(mySql.getString(), 1, 1, 1);
	var tempSelectArray = decodeEasyQueryResult(Result);
	//改动1----------------tempSelectArray------------------------------end
	//改动2----------------tempUnselectArray------------------------------
	mySql.setSqlId("tempUnselectArray");  
	mySql.setValue("p_userCode",userCode);
	mySql.setValue("p_operator",operator);
	var Result1 =easyQueryVer3(mySql.getString(), 1, 1, 1);
	var tempUnselectArray = decodeEasyQueryResult(Result1);
	//改动2----------------tempUnselectArray------------------------------end
	
//	var sqlStr = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp "
//		+ " where Operator = '" + operator + "' and "
//		+ "MenuGrpCode in  ( select MenuGrpCode from LDUserToMenuGrp "
//		+ "where UserCode = '"+ userCode + "')";
//	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
//	//查询成功则拆分字符串，返回二维数组
//	var tempSelectArray = decodeEasyQueryResult(strTemp);
//	var sqlStr = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp "
//		+ "where Operator = '" + operator + "' and "
//		+ "MenuGrpCode not in  ( select MenuGrpCode from LDUserToMenuGrp "
//		+ "where UserCode = '" + userCode + "')";
//	strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
//	var tempUnselectArray = decodeEasyQueryResult(strTemp);
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
	//改动3----------------MenuList------------------------------
	mySql.setSqlId("MenuList");  
	mySql.setValue("p_MenuGrpCode",MenuGrpCode);
	var Result =easyQueryVer3(mySql.getString(), 1, 1, 1);
	var tempSelectArray = decodeEasyQueryResult(Result);
	//改动3----------------MenuList------------------------------end
//	var sqlStr = "select ParentNodeCode,ChildFlag,nodename,nodecode from LDMenu "
//		+ "where NodeCode in (select NodeCode from LDMenuGrpToMenu "
//		+ "where MenuGrpCode = '" + MenuGrpCode + "') order by nodeorder";
//	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
//	//查询成功则拆分字符串，返回二维数组
//	var tempSelectArray = decodeEasyQueryResult(strTemp);
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
	//改动4----------------UnMenuList------------------------------
	mySql.setSqlId("UnMenuList");  
	mySql.setValue("p_MenuGrpCode",MenuGrpCode);
	var Result =easyQueryVer3(mySql.getString(), 1, 1, 1);
	var tempUnselectArray = decodeEasyQueryResult(Result);
	//改动4----------------UnMenuList------------------------------end
//	var sqlStr = "select ParentNodeCode,ChildFlag,nodename,nodecode from LDMenu  "
//		+ "where NodeCode in (select NodeCode from LDMenuGrpToMenu "
//		+ "where MenuGrpCode = '" + MenuGrpCode + "') order by nodeorder";
//	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
//	//查询成功则拆分字符串，返回二维数组
//	var tempUnselectArray = decodeEasyQueryResult(strTemp);
	if (tempUnselectArray == null)
	{
		alert(I18NMsg("Thisroledoesnothavemenu!"));
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

function cancelClick()
{
	divSubCmdButton.style.display = "none";
	divCmdButton.style.display = "";
	divUserGrid.style.display = "";
	divMenuGrpGrid.style.display = "none";
	divHideInput.style.display= "none";
	validTR.style.display = "";
	tdUserCode.style.display = "";
	tdUserCodeReadOnly.style.display = "none";
	tdUserName.style.display = "";
	tdUserNameReadOnly.style.display = "none";
	clearTree("spanMenuTree");
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

function initAddGrid()
{
	initSelectArray();
	initUnselectArray();
	//查询成功则拆分字符串，返回二维数组
	var Operator = fm.all('Operator').value; //增加和更新处理不一样
	
	//改动5----------------------------------------------
	mySql.setSqlId("Init");  
	mySql.setValue("p_Operator",Operator);
	var Result =easyQueryVer3(mySql.getString(), 1, 1, 1);
	var tempUnselectArray = decodeEasyQueryResult(Result);
	//改动5----------------------------------------------end
	
//	sqlStr = "select MenuGrpCode,MenuGrpDescription from LDMenuGrp where  Operator = '" + Operator + "'";
//	var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
//	var tempUnselectArray = decodeEasyQueryResult(strTemp);
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
//	turnPage.arrDataCacheSet = tempUnselectArray;
//	turnPage.pageDisplayGrid = UnselectMenuGrpGrid; // 设置初始化过的MULTILINE对象，VarGrid为在初始化页中定义的全局变量
//	turnPage.pageIndex = 0; // 设置查询起始位置
//	var tArr = new Array();
//	tArr = turnPage.getData(turnPage.arrDataCacheSet, turnPage.pageIndex,
//			MAXSCREENLINES);// 在查询结果数组中取出符合页面显示大小设置的数组
//	displayMultiline(tArr, turnPage.pageDisplayGrid);
	
	
	fillUnselectGrid();
	fillSelectGrid();
}
