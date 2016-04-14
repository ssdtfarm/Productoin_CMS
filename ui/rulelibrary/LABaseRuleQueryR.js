//该文件中包含客户端需要处理的函数和事件

var showInfo;
var mDebug="0";
var arrDataSet;
var turnPage = new turnPageClass();

function initEdorType(cObj)
{
	mEdorType = " #1# and codealias=#3# ";
	showCodeList('agentkind',[cObj], null, null, mEdorType, "1");
}

function actionKeyUp(cObj)
{	
	mEdorType = " #1# and codealias=#3#";
	showCodeListKey('agentkind',[cObj], null, null, mEdorType, "1");
}

//提交，保存按钮对应操作
function submitForm()
{
  var i = 0;
  var showStr=I18NMsg("Enquiringdata,pleasewaitanddonotedittheinformationonscreenorjumptoanyotherpage");
  var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
  showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");   

  //showSubmitFrame(mDebug);
  fm.submit(); //提交
}

function resetForm(){
//提交后操作,服务器数据返回后执行的操作
function afterSubmit( FlagStr, content )
{
  showInfo.close();
  if (FlagStr == "Fail" )
  {             
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
    showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");   
  }
  else
  { 
    var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + content ;
    showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");   

    //执行下一步操作
  }
}

//提交前的校验、计算  
function beforeSubmit()
{
  //添加操作	
}           

//显示div，第一个参数为一个div的引用，第二个参数为是否显示，如果为"true"则显示，否则不显示
function showDiv(cDiv,cShow)
{
  if (cShow=="true")
  {
    cDiv.style.display="";
  }
  else
  {
    cDiv.style.display="none";  
  }
}

//显示frmSubmit框架，用来调试
function showSubmitFrame(cDebug)
{
  if(cDebug=="1")
  {
			parent.fraMain.rows = "0,0,50,82,*";
  }
 	else {
  		parent.fraMain.rows = "0,0,0,82,*";
 	}
}

function returnParent()
{
  var arrReturn = new Array();
	var tSel = AgentGrid.getSelNo();	
		
	if( tSel == 0 || tSel == null )
		alert( I18NMsg("BOM_Pleaseselectarecord!") );
	else{
		try
			{	
				arrReturn = getQueryResult();
				top.opener.afterQuery( arrReturn );
			}
			catch(ex)
			{
			}
			top.close();
		
	}
}
function getQueryResult()
{
	var arrSelected = null;
	tRow = AgentGrid.getSelNo();	
	if( tRow == 0 || tRow == null || arrDataSet == null )
	  return arrSelected;
	
	arrSelected = new Array();
	
	 var mySql = new SqlClass();
	turnPage.strQueryResult  = easyQueryVer3(mySql.getString(), 1, 0, 1);  
  //判断是否查询成功
  if (!turnPage.strQueryResult) {
    alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
    return false;
    }
//查询成功则拆分字符串，返回二维数组
  arrSelected = decodeEasyQueryResult(turnPage.strQueryResult);
	
	return arrSelected;
}

// 查询按钮
function easyQueryClick()
{	
	
	// 初始化表格
	document.getElementById('tree').style.display = "none";
	
  
  //判断是否查询成功
  if (!turnPage.strQueryResult) {
	  alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
    return false;
    }
//查询成功则拆分字符串，返回二维数组
  arrDataSet = decodeEasyQueryResult(turnPage.strQueryResult);
  //tArr = decodeEasyQueryResult(turnPage.strQueryResult);
  turnPage.arrDataCacheSet = arrDataSet;
  //设置初始化过的MULTILINE对象，VarGrid为在初始化页中定义的全局变量
  turnPage.pageDisplayGrid = AgentGrid;    
          
  //保存SQL语句
  turnPage.strQuerySql     = mySql.getString(); 
  
  //设置查询起始位置
  turnPage.pageIndex       = 0;  
  
  //在查询结果数组中取出符合页面显示大小设置的数组
  //arrDataSet           = turnPage.getData(turnPage.arrDataCacheSet, turnPage.pageIndex, MAXSCREENLINES);
  var tArr = new Array();
  tArr = turnPage.getData(turnPage.arrDataCacheSet, turnPage.pageIndex, 5);
  //调用MULTILINE对象显示查询结果
  
  //displayMultiline(arrDataSet, turnPage.pageDisplayGrid);
  displayMultiline(tArr, turnPage.pageDisplayGrid);
}
	}
//the end modify majl 20130711