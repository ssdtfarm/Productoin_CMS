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
  urlStr=encodeURI(encodeURI(urlStr));
  showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");   

  //showSubmitFrame(mDebug);
  fm.submit(); //提交
}


//提交后操作,服务器数据返回后执行的操作

function afterSubmit( FlagStr, content )
{
  showInfo.close();
  if (FlagStr == "Fail" )
  {             
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
    urlStr=encodeURI(encodeURI(urlStr));
    showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");   
  }
  else
  { 
    var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + content ;
    urlStr=encodeURI(encodeURI(urlStr));
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
	
	var strSQL = "";
	strSQL = "select BaseCode,Name,BranchType,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),Remark,status  from LRBase where 1=1"
		+"and BaseCode='"+AgentGrid.getRowColData(tRow-1,1)+"'" ;
	
	turnPage.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);  
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
	initAgentGrid();
	document.getElementById('tree').style.display = "none";
	document.getElementById('container').style.display = "none";
	document.getElementById('detail').style.display = "none";
	// 书写SQL语句
	var strSQL = "";
	strSQL = "select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),reason,Remark,branchtype,Status  from LRBase where 1=1"
        + getWherePart('BaseCode','RuleCode')	         
        + getWherePart('Name','RuleName')
        + getWherePart('BranchType','BranchType')	         
        + getWherePart('Status','Status')
        +" order by basecode desc";
	turnPage.strQueryResult  = easyQueryVer3(strSQL, 1, 1, 1);  
  
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
  turnPage.strQuerySql     = strSQL; 
  
  //设置查询起始位置
  turnPage.pageIndex       = 0;  
  
  //在查询结果数组中取出符合页面显示大小设置的数组

  //arrDataSet           = turnPage.getData(turnPage.arrDataCacheSet, turnPage.pageIndex, MAXSCREENLINES);
  var tArr = new Array();
  tArr = turnPage.getData(turnPage.arrDataCacheSet, turnPage.pageIndex, MAXSCREENLINES);
  //调用MULTILINE对象显示查询结果
  
  //displayMultiline(arrDataSet, turnPage.pageDisplayGrid);
  displayMultiline(tArr, turnPage.pageDisplayGrid);
}

function QueryHistory() {

	var arrReturn = new Array();
	// TODO 选择一条记录后，从数据库查询出必要的信息并返回
	var tGird = AgentGrid;// 注意这里可能需要修改这个MulLine
	var tTurnPage = turnPage;// 注意这里可能需要将turnPageGrade修改成该上边的MulLine使用的turnPage，这个turnPage在easyQuery方法上边。
	var tSel = tGird.getSelNo();
	if (!tTurnPage.strQueryResult) {
		alert(I18NMsg("BOM_Pleaseenquiryfirst!"));
	} else if (tSel == 0 || tSel == null) {
		alert(I18NMsg("BOM_Pleaseselectarecord!"));
	} else {
		window.open('./LABaseHistoryInput.jsp?BaseCode='
				+ AgentGrid.getRowColData(tSel - 1, 1));
	}
}

function showTree() {
	tRow = AgentGrid.getSelNo();
	fm.BaseCode.value = AgentGrid.getRowColData(tRow - 1, 1);
	fm.State.value = AgentGrid.getRowColData(tRow - 1, 8);
	fm.HideBranchType.value = AgentGrid.getRowColData(tRow - 1, 3);
	document.getElementById('tree').style.display = "";
	document.getElementById('detail').style.display = "none";
	// document.getElementById('frame').style.display="";
	var settingMenu = {
		checkable : false,
		async : true,
		keepParent : true,
		keepLeaf : true,
		editable : false,
		edit_renameBtn : false,
		edit_removeBtn : false,
		open : true,
		asyncUrl : 'LAIndexDefLoad.jsp', // 获取节点数据的URL地址
		asyncParam : [ "code", "type", "indextype", "agentgrade" ], // 获取节点数据时，必须的数据名称，例如：id、name
		asyncParamOther : [ "tree", "menu", "basecode", fm.BaseCode.value ], 
		callback : {
			beforeClick : zTreeBeforeClick,
			click : zTreeOnClick
//			beforeRightClick:zTreeBeforeRightClick,
//			rightClick:zTreeOnRightClick
			// confirmRename:zTPackageconfirmRename,
			// beforeRemove:zTPackagebeforeRemove,
//			asyncSuccess : function(event, treeId, treeNode, msg) {
//			}
		}
	};
	refreshTreeMenu(settingMenu, zNodesMenu);
	$("#container").show();
}

function Imp(){
	window.open('./ImpBaseFr.jsp');
}

function Exp() {
	var arrReturn = new Array();
	// TODO 选择一条记录后，从数据库查询出必要的信息并返回
	var tGird = AgentGrid;// 注意这里可能需要修改这个MulLine
	var tTurnPage = turnPage;// 注意这里可能需要将turnPageGrade修改成该上边的MulLine使用的turnPage，这个turnPage在easyQuery方法上边。
	var tSel = tGird.getSelNo();
	if (!tTurnPage.strQueryResult) {
		alert(I18NMsg("BOM_Pleaseenquiryfirst!"));
	} else if (tSel == 0 || tSel == null) {
		alert(I18NMsg("BOM_Pleaseselectarecord!"));
	} else {
		// 书写SQL语句
		var strSQL11 = "";
		strSQL11="select  a.status  from lrbase a where a.basecode='"+AgentGrid.getRowColData(tSel - 1, 1)+"'";		
		var strQueryResult = easyQueryVer3(strSQL11, 1, 0, 1); 
		var s=decodeEasyQueryResult(strQueryResult);		  
		  //判断是否查询成功
		  if (s[0][0]=='04') {			  
			  window.open('./LABaseExp.jsp?BaseCode='
						+ AgentGrid.getRowColData(tSel - 1, 1));
		    }else{
			  alert(I18NMsg("BOM_Basiclawstatusisnotapproved,cannotbeexport!"));
		  }

	}
}

//the end modify majl 20130711