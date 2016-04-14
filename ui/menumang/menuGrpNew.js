//更新记录： showAllMenuInUnselect()，showMenuGrp()
//更新人:  周磊
//更新日期:  2005-5-4  
//更新原因/内容：增加页面权限菜单

var turnPage = new turnPageClass();

function queryClick()
{
	var UserCode = fm.all("UserCode").value;
	var ComCode = fm.all("ComCode").value;
	if(UserCode=="") 
  {
  	alert(""+I18NMsg("alertMsg")+"");
   	return ;
  }
	
	
	// 书写SQL语句
	var sqlStr="select Operator,MenuGrpCode,MenuGrpName,MenuGrpDescription " +
						 " from LDMenuGrp where Operator = '" + UserCode + "' and MenuGrpCode in " +
						 " (select MenuGrpCode from LDUserTOMenuGrp where usercode in " +
						 " (select usercode from lduser where comcode like '" + ComCode + "%%'))";
	//alert(sqlStr);
						 
	turnPage.queryModal(sqlStr, QueryGrpGrid);
}


//提交前进行必要的检查
function DataCopy()
{
	//得到被选中的数据
	getInput();
	//alert("1111111111111");
	if(fm.all("MenuGrpCode").value == "" || fm.all("MenuGrpCode").value == null)
	{
		alert(""+I18NMsg("alertMsg")+"");
		return;
	}
	//向后台提交数据
  submitForm();
    
}


//提交，保存按钮对应操作
function submitForm()
{
	var i = 0;
	var showStr="正在复制数据，请您稍候并且不要修改屏幕上的值或链接其他页面";
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	fm.submit(); //提交
}

function afterSubmit(FlagStr)
{
    showInfo.close();
    
    if (FlagStr == "success")
    	alert(""+I18NMsg("alertMsg")+"");
    else
    	alert(""+I18NMsg("alertMsg")+"");  
    	
    clear();	
}

function getInput()
{
	var i = 0;
  var checkFlag = 0;
  var state = "0";
  
  for (i=0; i<QueryGrpGrid.mulLineCount; i++) 
  {
   if (QueryGrpGrid.getSelNo(i)) 
   { 
      checkFlag = QueryGrpGrid.getSelNo();
      break;
   }
  }
  
  if (checkFlag != 0) 
  { 
    var	Action = QueryGrpGrid.getRowColData(checkFlag - 1, 2); 	
    //alert("选中的菜单分组编码：" + Action);
    fm.all("Action").value = Action;
  }
  else 
  {
    alert(""+I18NMsg("Please Select an Information First")+""); 
  }
}
  
function clear()
{
	fm.all("MenuGrpName").value = "";
	fm.all("MenuGrpCode").value = "";
	fm.all("MenuGrpDescription").value = "";
	fm.all("MenuSign").value = "";
}










