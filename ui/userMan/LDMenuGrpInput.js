//更新记录： showAllMenuInUnselect()，showMenuGrp()
//更新人:  周磊  马龙
//更新日期:  2005-5-4     2006-03-08  
//更新原因/内容：增加页面权限菜单    重写MulLine的查询显示

var showInfo;
//控制界面上的mulLine的显示条数
var mulLineShowCount = 15;
var sqlcount = 0;
var selectArray = new Array();
var unselectArray = new Array();
var userArray = new Array();
var userArrayLen = 0;
var userCurPage = 0;
var removeArray = new Array() //更新系统角色中的删除纪录
var showDiv = "false";
var turnPage = new turnPageClass();
var dturnPage = new turnPageClass();
var qturnPage = new turnPageClass();

function change()
{
	if(!document.all)
		return;
	if (event.srcElement.type=="checkbox") {
		tArray = searchArray(event.srcElement.id);
       		tagInArray(tArray,event.srcElement.id);
	}
	if (event.srcElement.name=="foldheader") {
		tArray = searchArray(event.srcElement.id);
		var srcIndex = event.srcElement.sourceIndex;
		var nested = document.all[srcIndex+1];
		if (nested.style.display=="none") {
			nested.style.display='';
		} else {
			nested.style.display="none";
		}
		nested = document.all[srcIndex+2];
		if (nested.style.display=="none") {
			nested.style.display='';
		} else {
			nested.style.display="none";
		}
		tagShowlistInArray(tArray,event.srcElement.id);
	}
}

document.onclick=change;

function initUserArray()
{
	var userArray = new Array();
	var userArrayLen = 0;
	var userCurPage = 0;
}

//function fillUserGrid()
//{
//	QueryGrpGrid.clearData("QueryGrpGrid");
//	for (var i = 0; i < mulLineShowCount; i++)
//	{
//		QueryGrpGrid.addOne("QueryGrpGrid");
//		var offset = i  + userCurPage*mulLineShowCount;
//		if (offset < userArrayLen)
//		{
//			QueryGrpGrid.setRowColData(i,1,userArray[offset][0]);
//			QueryGrpGrid.setRowColData(i,2,userArray[offset][1]);
//			QueryGrpGrid.setRowColData(i,3,userArray[offset][3]);
//			QueryGrpGrid.setRowColData(i,4,userArray[offset][2]);
//			QueryGrpGrid.setRowColData(i,5,userArray[offset][4]);
//		}
//		else
//		{
//			QueryGrpGrid.setRowColData(i,1,"");
//			QueryGrpGrid.setRowColData(i,2,"");
//			QueryGrpGrid.setRowColData(i,3,"");
//			QueryGrpGrid.setRowColData(i,4,"");
//			QueryGrpGrid.setRowColData(i,5,"");
//		}
//	}
//	//下面的代码是为了使翻页时序号能正确显示
//	for (var i = 0; i < mulLineShowCount; i++)
//	{
//		var offset = i  + userCurPage*mulLineShowCount;
//		fm.all("QueryGrpGridNo")[i].value = offset + 1;
//	}
//}

//function userFirstPage()
//{
//	if (userArrayLen == 0) return;
//	userCurPage = 0;
//	fillUserGrid();
//}

//function userLastPage()
//{
//	if (userArrayLen == 0) return;
//	while ((userCurPage + 1)*mulLineShowCount < userArrayLen) userCurPage++;
//	fillUserGrid();
//}

//function userPageDown()
//{
//	if (userArrayLen == 0) return;
//	if (userArrayLen <= (userCurPage + 1) * mulLineShowCount)
//	{
//		alert("已达尾页");
//	}
//	else
//	{
//		userCurPage++;
//		fillUserGrid();
//	}
//}

//function userPageUp()
//{
//	if (userArrayLen == 0) return;
//	if (userCurPage == 0)
//	{
//		alert("已到首页");
//	}
//	else
//	{
//		userCurPage--;
//		fillUserGrid();
//	}
//}

function searchArray(id)
{
	for (var i = 0; i < selectArray.length; i++)
	{
		var aryId1 = "chk_" + selectArray[i][8];
		var aryId2 = "fld_" + selectArray[i][8];
		if (aryId1 == id || aryId2 == id)
			return selectArray;
	}
	for (var i = 0; i < unselectArray.length; i++)
	{
		var aryId1 = "chk_" + unselectArray[i][8];
		var aryId2 = "fld_" + unselectArray[i][8];
		if (aryId1 == id || aryId2 == id)
			return unselectArray;
	}
}

//提交前进行必要的检查
function beforeSubmit()
{
    if (fm.all('MenuGrpCode').value =="") {
        alert(""+I18NMsg("alertMsg")+"");
        return false;
    }
    return true;
}

function resetForm()
{
	fm.all('MenuGrpCode').value = "";
	fm.all('MenuGrpName').value = "";
	fm.all('MenuGrpDescription').value = "";
	fm.all('MenuSign').value = "";
}

function deleteClick()
{
	var selMenuGrpNo = QueryGrpGrid.getSelNo();
        if (selMenuGrpNo == 0) {
	  alert(""+I18NMsg("alertMsg")+"");
	  return;
	}
//20110323号，不在需要这个校验了，只要能登陆这个菜单就可以操作。
//        var Operator = QueryGrpGrid.getRowColData(selMenuGrpNo - 1,5);
//        var thisOperator = fm.all("Operator").value;
//        if (thisOperator != Operator) {
//  	    alert("您无权删除此系统角色");
//  	    return;
//        }

	if (!confirm(""+I18NMsg("ConfirmMsg")+""))
	  return;

	fm.all("Action").value = "delete";

    submitForm();
}


function queryClick()
{
    QueryGrpGrid.clearData();
    userCurPage = 0;

    var MenuGrpName = fm.all("MenuGrpName").value;
    var MenuGrpCode = fm.all("MenuGrpCode").value;
    var MenuGrpDescription = fm.all("MenuGrpDescription").value;
    var MenuSign = fm.all("MenuSign").value;
    var Usercode = fm.all("Usercode").value;
	var DepartMent = fm.all('DepPartMent').value;
	var Team = fm.all('Team').value;
	
	// 书写SQL语句
    //sqlcount++;
    var sqlStr = "select MenuGrpName,MenuGrpCode,MenuSign,MenuGrpDescription,Operator," 
    	+ "a.department,(select depname from lddeptadminconfig where depno=a.department)," 
    	+ "a.team,(select depname from lddeptadminconfig where depno=a.team),(select depmanager " 
    	+ "from lddeptadminconfig where depno=a.team),(select depmanagername from lddeptadminconfig " 
    	+ "where depno=a.team) from LDMenuGrp a where " + sqlcount + "=" + sqlcount + " " 
    	+ getWherePart('a.MenuGrpName','MenuGrpName','like')
    	+ getWherePart('a.MenuGrpCode','MenuGrpCode','like')
    	+ getWherePart('a.MenuGrpDescription','MenuGrpDescription','like')
    	+ getWherePart('a.MenuSign','MenuSign','like')
    	+ getWherePart('a.Operator','Usercode')
    	+ getWherePart('a.department','DepPartMent')
    	+ getWherePart('a.Team','Team')
    	+ " order by a.menugrpcode ";
//    if (MenuGrpName != "")
//    	sqlStr += "and MenuGrpName = '" + MenuGrpName + "'";
//    if (MenuGrpCode != "")
//    	sqlStr += "and MenuGrpCode = '" + MenuGrpCode + "'";
//    if (MenuGrpDescription != "")
//    	sqlStr += "and MenuGrpDescription = '" + MenuGrpDescription + "'";
//    if (MenuSign != "")
//    	sqlStr += "and MenuSign = '" + MenuSign + "'";
//	if (Usercode != "")
//		sqlStr += "and Operator = '" + Usercode + "'";
//	if(DepartMent!="")
//		sqlStr += "and department = '" + DepartMent + "'";	
//	if(Team!="")
//		sqlStr += "and team = '" + Team + "'";	
	
    qturnPage.queryModal(sqlStr, QueryGrpGrid);
    if(!qturnPage.strQueryResult){
    	alert(""+I18NMsg("alertMsg")+"");
		return false;
    }
    	
    //var strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
    //var tempArray = new Array;
    //userArray = decodeEasyQueryResult(strTemp);
    //if (userArray == null) {
    //	alert("没有找到您指定的系统角色。");
    //	return;
    //}
    //userArrayLen = userArray.length;
    //fillUserGrid();
}

function insertClick()
{
	resetForm();
	//校验部组
	if(fm.all('DepManager').value==""||fm.all('DepManager').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	//当选择增删改时，界面上的操作人员直接赋值成系统操作人员
	fm.all('Usercode').value = fm.all('Operator').value;
	fm.all("Action").value = "insert";
	//隐去需要的元素
	divQueryGrp.style.display = "none";
	divCmdButton.style.display = "none";
	//初始化时，新建系统角色时，需要显示其系统角色
	showAllMenuInUnselect();
	//显示需要的元素
	divSubCmdButton.style.display = "";
	divmenuGrid2.style.display= "";

}

function showAllMenuInUnselect(){
	//四级菜单检索多一个NodeSign字段（1为3级叶子，2为四级叶子）2005
	var sqlStr = "select ParentNodeCode,ChildFlag,nodename,nodecode,NodeSign from LDMenu order by nodeorder";
	//使用模拟数据源，必须写在拆分之前
	turnPage.useSimulation   = 1;
	//取得前200条节点
	var strTemp = easyQueryVer3(sqlStr, 1, 0, 1);
	var tempArray = new Array;
	tempArray = decodeEasyQueryResult(strTemp);
	var times = 1;
	while (times * 200 < turnPage.queryAllRecordCount)
	times = times + 1;
	for ( var i = 2; i <= times; i++) {
		var strTemp1 = easyQueryVer3(sqlStr,1,0, (i-1)*200 + 1);
		//去除头部的o|xxx^
		var sss = strTemp1.substring(6,strTemp1.length);
		strTemp = strTemp + '^' + sss;
	}
	tempArray = decodeEasyQueryResult(strTemp);
	//alert("tempArray="+tempArray);//2005
	if (tempArray == null) return;
	//初始化selectArray
	for (var i = 0; i < tempArray.length ; i++) {
		selectArray[i] = new Array();
		// 0:viste 1:parent 2:childnum; 3 nodeName 4 nodecode
		// 5 hide 6 showlist 7 check 8 id
		selectArray[i][0] = 0;
		selectArray[i][1] = tempArray[i][0];
		selectArray[i][2] = 0;
		selectArray[i][3] = tempArray[i][2];
		selectArray[i][4] = tempArray[i][3];
		selectArray[i][5] = 1;//1-隐藏，0-显示
		selectArray[i][6] = 0;
		selectArray[i][7] = 0;
		selectArray[i][8] = "sel_" + tempArray[i][3];
		if (tempArray[i][1] > 0)
			selectArray[i][9] = 0; //不是一般菜单叶子
		else
			selectArray[i][9] = 1;
		//判断是否页面权限节点 2005
		if (tempArray[i][4] == 1)
			selectArray[i][9] = 0; 
	}
    //初始化unselectArray
    for (var i = 0; i < tempArray.length ; i++) {
    	unselectArray[i] = new Array();
    	unselectArray[i][0] = 0;
    	unselectArray[i][1] = tempArray[i][0];
    	unselectArray[i][2] = 0;
    	unselectArray[i][3] = tempArray[i][2];
    	unselectArray[i][4] = tempArray[i][3];
    	unselectArray[i][5] = 1;//1-隐藏；0-显示
    	unselectArray[i][6] = 0;
    	unselectArray[i][7] = 0;
    	unselectArray[i][8] = "unsel_" + tempArray[i][3];
		  if (tempArray[i][1] > 0)
			  unselectArray[i][9] = 0; //不是一般菜单叶子
		  else
			  unselectArray[i][9] = 1;
		  //判断是否页面权限节点 2005
		  if (tempArray[i][4] == 1)
			  unselectArray[i][9] = 0; 
    }
//    var Operator = fm.all("Operator").value;
//    var sqlStr = "select nodecode from LDMenu " ;
//        sqlStr += " where nodecode in (select nodecode from ldmenugrptomenu ";
//        sqlStr += " where menuGrpCode in (select menuGrpCode from ldusertomenugrp ";
//        sqlStr += " where usercode = '" +fm.all('DepManager').value+ "' ) )";//这里替换Operator
//        sqlStr += " order by nodeorder";
//
//    strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
//    tempArray = new Array;
//    tempArray = decodeEasyQueryResult(strTemp);
//    times = 1;
//    if(strTemp!="" && strTemp!=null){
//	    while (times * 200 < turnPage.queryAllRecordCount) //不在使用此方法，而换成其他的东西
//	//    while (times * 200 < allCount) 
//	        times = times + 1;
//	    for ( var i = 2; i <= times; i++) {
//	    	var strTemp1 = easyQueryVer3(sqlStr,1,0, (i-1)*200 + 1);
//			//去除头部的o|xxx^
//			var sss = strTemp1.substring(6,strTemp1.length);
//	        strTemp = strTemp + '^' + sss;
//	    }
//    }
//    tempArray = decodeEasyQueryResult(strTemp);
    if (tempArray != null) {
      for (var i = 0; i < tempArray.length; i++) {
	    	var nodecode = tempArray[i][3];
	    	for (var j = 0; j < unselectArray.length; j++) {
	    		if (unselectArray[j][4] == nodecode)
	    		    break;
	        }
	        addNode(unselectArray,j);
	    }
	}
	  //alert("menuGrp.js:showAllMenuInUnselect():selectArray(input for treeMenu.js:paintTree)="+selectArray);//2005已经查出4级菜单值
    paintTree(selectArray,"spanSelectMenuGrpTree");
    paintTree(unselectArray,"spanUnselectMenuGrpTree");
}

function updateClick()
{
	//alert("menuGrp.js:updateClick");//2005
  var selMenuGrpNo = QueryGrpGrid.getSelNo();
  if (selMenuGrpNo == 0) {
  	alert(""+I18NMsg("alertMsg")+"");
  	return;
  }
  //不再校验此处，只要能操作此功能的用户均可以操作后台
//  var Operator = QueryGrpGrid.getRowColData(selMenuGrpNo - 1,5);
//  var thisOperator = fm.all("Operator").value;
//  if (thisOperator != Operator) {
//  	alert("您无权修改此系统角色");
//  	return;
//  }
  //隐去需要的元素
  divQueryGrp.style.display = "none";
  divCmdButton.style.display = "none";
  //将选择的用户信息拷贝到各个信息输入框内
  var offset = selMenuGrpNo -1;
  fm.all("MenuGrpName").value = QueryGrpGrid.getRowColData(offset,1);
  fm.all("MenuGrpCode").value = QueryGrpGrid.getRowColData(offset,2);
  fm.all("MenuSign").value = QueryGrpGrid.getRowColData(offset,3);
  fm.all("MenuGrpDescription").value =  QueryGrpGrid.getRowColData(offset,4);
  //取得选中用户对应的系统角色
  showMenuGrp();
  //显示需要显示的元素
  divSubCmdButton.style.display = "";
  divmenuGrid2.style.display= "";
  fm.all("Action").value = "update";
  
}

function showMenuGrp()
{
//	  	alert("menuGrp.js:showMenuGrp");//2005
    var selMenuGrpNo = QueryGrpGrid.getSelNo();
    if (selMenuGrpNo == 0)
        return;
    var menuGrpCode = QueryGrpGrid.getRowColData(selMenuGrpNo - 1,2);
    var sqlStr = "select ParentNodeCode,ChildFlag,nodename,nodecode,NodeSign from LDMenu order by nodeorder";
    //使用模拟数据源，必须写在拆分之前
    turnPage.useSimulation   = 1;
    var tempArray = new Array;
    //取得前200条节点
    var strTemp = easyQueryVer3(sqlStr, 1, 0, 1);
    tempArray = decodeEasyQueryResult(strTemp);
    var times = 1;
    while (times * 200 < turnPage.queryAllRecordCount)
        times = times + 1;
    for ( var i = 2; i <= times; i++) {
    	var strTemp1 = easyQueryVer3(sqlStr,1,0, (i-1)*200 + 1);
		//去除头部的o|xxx^
		var sss = strTemp1.substring(6,strTemp1.length);
		strTemp = strTemp + '^' + sss;
    }
    tempArray = decodeEasyQueryResult(strTemp);
    if (tempArray != null) {
	    //初始化selectArray
	    for (var i = 0; i < tempArray.length ; i++) {

	    	selectArray[i] = new Array();
	    	selectArray[i][0] = 0;
	    	selectArray[i][1] = tempArray[i][0];
	    	selectArray[i][2] = 0;
	    	selectArray[i][3] = tempArray[i][2];
	    	selectArray[i][4] = tempArray[i][3];
	    	selectArray[i][5] = 1;//1-隐藏；0-显示
	    	selectArray[i][6] = 0;
	    	selectArray[i][7] = 0;
	    	selectArray[i][8] = "sel_" + tempArray[i][3];

			if (tempArray[i][1] > 0)
				selectArray[i][9] = 0; //不是一般菜单叶子
			else
				selectArray[i][9] = 1;
			//判断是否页面权限节点 2005
			if (tempArray[i][4] == 1)
				selectArray[i][9] = 0; 
	    }
     }
     
     
     
    //初始化unselectArray
    for (var i = 0; i < tempArray.length ; i++) {
    	unselectArray[i] = new Array();
    	unselectArray[i][0] = 0;
    	unselectArray[i][1] = tempArray[i][0];
    	unselectArray[i][2] = 0;
    	unselectArray[i][3] = tempArray[i][2];
    	unselectArray[i][4] = tempArray[i][3];
    	unselectArray[i][5] = 1;
    	unselectArray[i][6] = 0;
    	unselectArray[i][7] = 0; // check
    	unselectArray[i][8] = "unsel_" + tempArray[i][3];
    	if (tempArray[i][1] > 0)
			  unselectArray[i][9] = 0; //不是一般菜单叶子
		  else
			  unselectArray[i][9] = 1;
	   //判断更改页面权限菜单节点 2005
	   if (tempArray[i][4] == 1)
		  unselectArray[i][9] = 0; //不是页面权限菜单
    }
  
    //系统查询用户的角色
    var Operator = fm.all("MenuGrpCode").value;
//    alert(Operator);
//    var sqlStr = "select nodecode from LDMenu ";
//        sqlStr += " where nodecode in (select nodecode from ldmenugrptomenu ";
//        sqlStr += " where menuGrpCode ='"+Operator+"' )";
//        sqlStr += " order by nodeorder";
    var sqlStr = "select nodecode from ldmenu order by nodeorder ";
    
    strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
    tempArray = decodeEasyQueryResult(strTemp);
    times = 1;
    while (times * 200 < turnPage.queryAllRecordCount)
        times = times + 1;
    for ( var i = 2; i <= times; i++) {
    	var strTemp1 = easyQueryVer3(sqlStr,1,0, (i-1)*200 + 1);
    	//去除头部的o|xxx^
    	var sss = strTemp1.substring(6,strTemp1.length);
    	strTemp = strTemp + '^' + sss;
    }
     
    tempArray = new Array;
    tempArray = decodeEasyQueryResult(strTemp);
    
   if (tempArray != null) {
             
    
     for (var i = 0; i < tempArray.length; i++) {
     	var nodecode = tempArray[i][0];
     
     	for (var j=0; j < unselectArray.length; j++) {
     		if (unselectArray[j][4] == nodecode){
     	
     		  break;
     		  }
         }
         addNode(unselectArray,j);
       // removeNode(selectArray,j);
     }
 }

    var sqlStr = "select nodecode from LDMenu where nodecode in "
	    sqlStr +="(select nodecode from ldmenuGrpTomenu where menuGrpCode ='" + menuGrpCode + "') and " +  sqlcount + " = " + sqlcount;
	    sqlcount++;

    strTemp =  easyQueryVer3(sqlStr, 1, 0, 1);
    tempArray = decodeEasyQueryResult(strTemp);

    times = 1;
    while (times * 200 < turnPage.queryAllRecordCount)
        times = times + 1;

    for ( var i = 2; i <= times; i++) {
    	var strTemp1 = easyQueryVer3(sqlStr,1,0, (i-1)*200 + 1);
	//去除头部的o|xxx^
	var sss = strTemp1.substring(6,strTemp1.length);
       strTemp = strTemp + '^' + sss;
    }
    var tempArray = new Array;

    tempArray = decodeEasyQueryResult(strTemp);
    
   

    if (tempArray != null) {
	    for (var i = 0; i < tempArray.length; i++) {
	    	var nodecode = tempArray[i][0];
	    	for (var j = 0; j < selectArray.length; j++) {
	    		if (selectArray[j][4] == nodecode)
	    		    break;
	        }
	      
	        addNode(selectArray,j);
	        removeNode(unselectArray,j);
	    }
    }

    //拷贝原始选择菜单到removeArray中
    removeArray = new Array();
    var index = 0;
    for (var i = 0; i < selectArray.length; i++) {
    	if (selectArray[i][5] == 1)
    	    continue;
    	removeArray[index] = selectArray[i][4];
    	index++;
    }
   
     
    paintTree(selectArray,"spanSelectMenuGrpTree");
    paintTree(unselectArray,"spanunSelectMenuGrpTree");
}

function update()
{
	//alert("menuGrp.js:update");//2005
	if (!beforeSubmit())
		return;
	//计算出需要更新删除的removeArray,然后编成字符串放入hideRemoveString中
	fm.all("hideRemoveString").value = "";
	var hideRemoveStr = "";
	var count = 0;
	for (var i = 0; i < removeArray.length; i++)
	{
		var nodecode = removeArray[i];
		var j = 0;
		for (; j < selectArray.length; j++)
		{
			if (selectArray[j][5] == 1)
				continue;
			if (selectArray[j][4] == nodecode)
				break;
		}
		if (j == selectArray.length)
		{
			//此节点被删除了
			hideRemoveStr = hideRemoveStr + " |" + nodecode + "|^";
		}
	}
	fm.all("hideRemoveString").value = hideRemoveStr;
	var menuGrpCode = fm.all("MenuGrpCode").value;
	fm.all("hideString").value = arrayToString(selectArray);
	HideMenuGrpGrid1.clearData("HideMenuGrpGrid1");
	checkDepAndTeam();
	submitForm();
}

function remove()
{
	//alert("menuGrp.js:remove");//2005
	submitForm();
}

function insert()
{
	//alert("menuGrp.js:insert");//2005
	if (!beforeSubmit())
		return false;
	var menuGrpCode = fm.all("MenuGrpCode").value;
	// 将SelectArray里面的数据拷贝到HideMenuGrpGrid中
	HideMenuGrpGrid1.clearData("HideMenuGrpGrid1");
	fm.all("hideString").value = arrayToString(selectArray);
	//新建系统角色时，增加系统校验
	if(fm.all('MenuGrpCode').value=="" || fm.all('MenuGrpCode').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}else{
		var strSQL = "select * from ldmenugrp where menugrpcode='"+fm.all('MenuGrpCode').value+"'";
		var arr = easyExecSql(strSQL);
		if(arr){
			alert(""+I18NMsg("alertMsg")+"");
			return false;
		}
	}
	if(fm.all('MenuGrpName').value=="" || fm.all('MenuGrpName').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}if(fm.all('DepPartMent').value=="" || fm.all('DepPartMent').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}if(fm.all('Team').value=="" || fm.all('Team').value==null){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	checkDepAndTeam();
	submitForm();
}

function arrayToString(tArray)
{
	//alert("menuGrp.js:arrayToString");//2005
	var menuGrpCode = fm.all("MenuGrpCode").value;
	var resultString = "";
	for (var i = 0; i < tArray.length; i++)
	{
		if (tArray[i][5]== 1)
			continue;
		resultString += menuGrpCode + "|";
		resultString += tArray[i][4] + "|^";
	}
	return resultString;
}

//提交，保存按钮对应操作
function submitForm()
{
	var i = 0;
	var showStr="正在提交数据，请您稍候并且不要修改屏幕上的值或链接其他页面";
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
    urlStr=encodeURI(encodeURI(urlStr));
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	fm.submit(); //提交
}

function afterSubmit(FlagStr)
{
    showInfo.close();
    if (fm.all('action').value == "insert") {
        if (FlagStr == "success")
            alert(""+I18NMsg("alertMsg")+"");
        else
            alert(""+I18NMsg("AddFailed")+"");
    }

    if (fm.all('action').value == "update") {
        if (FlagStr == "success")
            alert(""+I18NMsg("alertMsg")+"");
        else
            alert(""+I18NMsg("Dataprocessingfailed")+"");
    }

    if (fm.all('action').value == "delete") {
        if (FlagStr == "success")
            alert(""+I18NMsg("alertMsg")+"");
        else
            alert(""+I18NMsg("deleteFaild")+"");
    }
}

function addMenus()
{
	for (var i = 0; i < unselectArray.length; i++)
	{
		if (unselectArray[i][5] == 1)
			continue;
		if (unselectArray[i][7] == 1)
		{
			removeNode(unselectArray,i);
			addNode(selectArray,i);
		}
	}
	paintTree(selectArray,"spanSelectMenuGrpTree");
	paintTree(unselectArray,"spanunSelectMenuGrpTree");
}

function removeMenus()
{
	for (var i = 0; i < selectArray.length; i++)
	{
		if (selectArray[i][2] != 0)
			continue;
		if (selectArray[i][5] == 1)
			continue;
		if (selectArray[i][7] == 1)
		{
			removeNode(selectArray,i);
			addNode(unselectArray,i);
		}
	}
	paintTree(selectArray,"spanSelectMenuGrpTree");
	paintTree(unselectArray,"spanunSelectMenuGrpTree");
}

function initGrid()
{
	initmenuGrpGrid();
	initunSelectMenuGrpGrid();
}

function showDiv()
{
	divmenuGrid2.style.display="";
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
	if (fm.all("Action").value == "delete")
	{
		remove();
	}
}

function cancelClick()
{
	divQueryGrp.style.display = '';
	divmenuGrid2.style.display="none";
	divCmdButton.style.display='';
	divSubCmdButton.style.display="none";
	fm.all('MenuGrpCode').readOnly = false;
	fm.all('Usercode').readOnly = false;
	initForm();
}
//退回操作，走自定义的
function cancelClick1(){
	divGrpInfo.style.display = "";
	divHiddenDep.style.display ="none";
	divCmdButton.style.display ="";
	divDepCmdButton.style.display ="none";
	divQueryGrp.style.display ="";
	divDepConfigGrid.style.display ="none";
	divSubCmdButton.style.display ="none";
	divmenuGrid2.style.display ="none";
}
//双击选择查询对应的部门（组）信息
function QueryDepClick(str){
	initHiddenDep();
	if(str=='02'){
		if(fm.all('DepPartMent').value!="" && fm.all('DepPartMent').value!=null){
			fm.all('UpDepCode').value= fm.all('DepPartMent').value;
		}else{
			alert(""+I18NMsg("alertMsg")+"");
			return false;
		}
		fm.all('DepLevel').value="02";
		fm.all('DepLevelName').value=""+I18NMsg("waitForTran")+"";
	}else if(str=='01'){
		fm.all('DepLevel').value="01";
		fm.all('DepLevelName').value=""+I18NMsg("waitForTran")+"";
	}
	divGrpInfo.style.display = "none";
	divHiddenDep.style.display ="";
	divCmdButton.style.display ="none";
	divDepCmdButton.style.display ="";
	divQueryGrp.style.display ="none";
	divDepConfigGrid.style.display ="";
	divSubCmdButton.style.display ="none";
	divmenuGrid2.style.display ="none";
}
//手工录入触发校验
function GetDepCheck(str){
	var strSQL = "";
	//校验部
	if(str=='01'){
		if(fm.all('DepPartMent').value!="" && fm.all('DepPartMent').value!=null){
			strSQL = "select * from lddeptadminconfig where deplevel='01' and depno='"+fm.all('DepPartMent').value+"'";
			var attr = easyExecSql(strSQL);
			if(!attr){
				alert(""+I18NMsg("alertMsg")+"");
				return false;
			}
		}
	}
	//校验组
	if(str=='02'){
		if(fm.all('DepPartMent').value==""||fm.all('DepPartMent').value==null){
			alert(""+I18NMsg("alertMsg")+"");
			return false;
		}
		if(fm.all('Team').value!="" && fm.all('Team').value!=null){
			strSQL = "select depno,depname,updepno,depmanager,depmanagername from lddeptadminconfig where deplevel='02' and depno='"+fm.all('Team').value+"' and updepno='"+fm.all('DepPartMent').value+"'";
			var attr = easyExecSql(strSQL);
			if(!attr){
				alert(""+I18NMsg("alertMsg")+"");
				return false;
			}else{
				fm.all('DepManager').value=attr[0][3];
				fm.all('DepManagerName').value=attr[0][4];
			}
		}
	}
}
//查询部组信息
function queryDepClick(){
//	var strSQL = "select depno,depname,deplevel,decode(deplevel,'01','"+I18NMsg("SQLResult")+"'),updepno,(select depname from lddeptadminconfig where depno=a.updepno),depmanager,depmanagername,operator,makedate "
	var strSQL = "select depno,depname,deplevel,(case when deplevel='01' then '"+I18NMsg("SQLResult")+"' end),updepno,(select depname from lddeptadminconfig where depno=a.updepno),depmanager,depmanagername,operator,makedate "
		+"from lddeptadminconfig a where 1=1 "
		+getWherePart('a.depno','DepCode','like')
		+getWherePart('a.depname','DepName','like')
		+getWherePart('a.deplevel','DepLevel')
		+getWherePart('a.updepno','UpDepCode','like')
		+getWherePart('a.depmanager','DepManager1','like')
		+"order by depno";
	
	dturnPage.queryModal(strSQL,DepConfigGrid);
	// 判断是否查询成功
	if (!dturnPage.strQueryResult) {
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
}
//返回选中的部组信息
function returnDepClick(){
	  var tSel = DepConfigGrid.getSelNo();
	  
	  if( tSel == 0 || tSel == null ){
			alert( ""+I18NMsg("Please Select an Information First")+"" );
	  		return false;
	  	}else{
	  		//直接将选中的值赋值给上级机关
	  		if(fm.all('DepLevel').value=='01'){
	  			fm.all('DepPartMent').value=DepConfigGrid.getRowColData(tSel-1,1);
	  		}else if(fm.all('DepLevel').value=='02'){
	  			fm.all('Team').value=DepConfigGrid.getRowColData(tSel-1,1);
		  		fm.all('DepManager').value=DepConfigGrid.getRowColData(tSel-1,7);
		  		fm.all('DepManagerName').value=DepConfigGrid.getRowColData(tSel-1,8);	
	  		}else{
	  			alert(""+I18NMsg("alertMsg")+"");
	  			return false;
	  		}
	  		//同时清空MULLINE，并将按钮隐藏
	  		initDepConfigGrid();
	  		initHiddenDep();
	  		cancelClick1();
		}
	  return true;
}

/*单击触发函数，并且在页面上返回选中的数据*/
function BackToInputBox(){

	//点击返回数据
	var tSel = QueryGrpGrid.getSelNo();
	
	 if( tSel == 0 || tSel == null ){
			alert( ""+I18NMsg("Please Select an Information First")+"" );
	  		return false;
	 }else{
	  		//直接将选中的值赋值给上级机关
	  		fm.all('MenuGrpCode').value=QueryGrpGrid.getRowColData(tSel-1,2);
	  		fm.all('MenuGrpCode').readOnly = true;  
	  		fm.all('MenuGrpName').value=QueryGrpGrid.getRowColData(tSel-1,1);
	  		fm.all('MenuGrpDescription').value=QueryGrpGrid.getRowColData(tSel-1,4);
	  		fm.all('MenuSign').value=QueryGrpGrid.getRowColData(tSel-1,3);
	  		fm.all('Usercode').value=QueryGrpGrid.getRowColData(tSel-1,5);
	  		fm.all('Usercode').readOnly = true;  
	  		fm.all('DepPartMent').value=QueryGrpGrid.getRowColData(tSel-1,6);
	  		fm.all('Team').value=QueryGrpGrid.getRowColData(tSel-1,8);
	  		fm.all('DepManager').value=QueryGrpGrid.getRowColData(tSel-1,10);
	  		fm.all('DepManagerName').value=QueryGrpGrid.getRowColData(tSel-1,11);
		}
	  return true;
}

/*提交前先校验部组信息是否一致*/
function checkDepAndTeam()
{
	var dep = fm.all('DepPartMent').value;
	var team = fm.all('Team').value;
	if(dep==null ||dep==""){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	if(team==null || team==""){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	var sql = "select * from lddeptadminconfig where depno='"+team+"' and updepno='"+dep+"'";
	var arr = easyExecSql(sql);
	if(!arr){
		alert(""+I18NMsg("alertMsg")+"");
		return false;
	}
	return true;
}
