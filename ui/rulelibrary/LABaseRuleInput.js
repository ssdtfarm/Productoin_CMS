//               该文件中包含客户端需要处理的函数和事件


var mDebug="0";
var mOperate="";
var showInfo;
var arrDataSet;
var turnPage = new turnPageClass();
var mStatus="";
window.onfocus=myonfocus;
//使得从该窗口弹出的窗口能够聚焦

function myonfocus()
{
	if(showInfo!=null)
	{
	  try
	  {
	    showInfo.focus();  
	  }
	  catch(ex)
	  {
	    showInfo=null;
	  }
	}
}





//提交，保存按钮对应操作

function submitForm1()
{  
    if(!beforeSubmit())
    {
 	   return false;
    }
  var i = 0;
  var showStr=I18NMsg("Saving,pleasedonoteditanyinformationorlinktootherscreen");
  var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
  urlStr=encodeURI(encodeURI(urlStr));
  showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
  
  if (fm.hideOperate.value=="") {
	    alert(I18NMsg("C_Missingoperationtype,pleaseresubmittheoperation!"));
	  }

 fm.submit(); //提交  
 
  resetForm();
}
function addbase()
{
	 var link="./LABaseAdd.jsp";
		showFormPage(link, I18NMsg("BOM_Addbasiclaw")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);

}
//模态弹出框
function showFormPage(link,title,width,height){
	if(width==null){
		width = "auto";
		height="auto";
	}
	art.dialog.open(link, {
		title: title,
		// background: '#600', // 背景色 
		opacity: 0.20,	// 透明度
		button: [
					{name: I18NMsg("C_Back"),
						callback: function () {
							return true;
						}	,
						focus: true

					}],
		//lock: true,
		width:width,
		height:height,
		close:function (){
		easyQueryClick();
		}
	});
	
}
function updatebase(spanid)
{
	var basecode=fm.all(spanid).all('AgentGrid1').value;
	
	 var link="./LABaseUpdate.jsp?basecode="+basecode;
		showFormPage1(link, I18NMsg("BOM_Modifybasiclawinformation!")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);
       art.dialog.close();
}
//模态弹出框
function showFormPage1(link,title,width,height){
	if(width==null){
		width = "auto";
		height="auto";
	}
	art.dialog.open(link, {
		title: title,
		// background: '#600', // 背景色 
		opacity: 0.20,	// 透明度
		button: [
					{name: I18NMsg("C_Back"),
						callback: function () {
							return true;
						}	,
						focus: true

					}],
		//lock: true,
		width:width,
		height:height,
		close:function (){
		easyQueryClick();
		}
	});
	
}

function custom(spanid){
	//下面增加相应的代码
	var basecode=fm.all(spanid).all("AgentGrid1").value;
	  mOperate="QUERY||MAIN";
	  showInfo=window.open("./LABaseRuleQuery.jsp?basecode="+basecode);
}
//提交后操作,服务器数据返回后执行的操作

function afterSubmit( FlagStr, content )
{ 
  showInfo.close();  
  if (FlagStr == "Fail" )
  {             
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
    urlStr=encodeURI(encodeURI(urlStr));
    showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");   
  }
  else
  { 

    var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + content ;
    urlStr=encodeURI(encodeURI(urlStr));
  	//parent.fraInterface.initForm();
    showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px"); 
    resetForm();
  }
 

}



//重置按钮对应操作,Form的初始化函数在功能名+Init.jsp文件中实现，函数的名称为initForm()
function resetForm()
{
  try
  {
	  initForm();

  }
  catch(re)
  {
  	alert(re);
  }
} 


 
//提交前的校验、计算  
function beforeSubmit()
{
  //添加操作	
  if( verifyInput() == false )  {
	  return false;
  }
	 	if ((trim(fm.all('RuleName').value)=='')||(fm.all('RuleName').value==null)) {
	  	alert(I18NMsg('BOM_Basiclawnamecannotbeblank!'));
			fm.all('RuleName').focus();
	 		return false;
	 	}
	 	if ((trim(fm.all('BranchType').value)=='')||(fm.all('BranchType').value==null)) {
	  	alert(I18NMsg('BOM_Channelcannotbeblank!'));
	  	fm.all('BranchType').focus();
	  	return false;
	  }
	 	return true;  
}  

//显示frmSubmit框架，用来调试

function showSubmitFrame(cDebug)
{
  if(cDebug=="1")
  {
	parent.fraMain.rows = "0,0,50,82,*";
  }
 else 
 {
  	parent.fraMain.rows = "0,0,0,82,*";
 }
}

//查询按钮
function easyQueryClick()
{	
	
	// 初始化表格
	initAgentGrid();
	
	//document.getElementById('tree').style.display = "none";
	//document.getElementById('container').style.display = "none";
	//document.getElementById('detail').style.display = "none";
	
	 var mySql = new SqlClass();
	   mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
	   mySql.setSqlId("LABaseRuleInput.js_SearchBase");
	   mySql.setValue("p_BaseCode", trim(fm.all('RuleCode').value));
	   mySql.setValue("p_Name", trim(fm.all('RuleName').value));
	   mySql.setValue("p_BranchType", trim(fm.all('BranchType').value));
	   mySql.setValue("p_Status", trim(fm.all('Status').value));
	   
	turnPage.strQueryResult  = easyQueryVer3(mySql.getString(), 1, 1, 1);  
	

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
  turnPage.pageLineNum = 5;

  tArr = turnPage.getData(turnPage.arrDataCacheSet, turnPage.pageIndex, 5);
  //调用MULTILINE对象显示查询结果
  
  //displayMultiline(arrDataSet, turnPage.pageDisplayGrid);
  displayMultiline(tArr, turnPage.pageDisplayGrid);
}

//Click事件，当点击“增加”时触发该函数

function submitForm()
{

	       fm.hideOperate.value="INSERT||MAIN"; 
	   	   submitForm1();
}       


//Click事件，当点击“修改”时触发该函数

function updateClick()
{
	 fm.BranchType.disabled = false;

 	if ((trim(fm.all('RuleCode').value)=='')||(fm.all('RuleCode').value==null)) {
	  	alert(I18NMsg("BOM_Basiclawcodecannotbemodified!"));
	 		return false;
	 	}
    
    var mySql = new SqlClass();
	   mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
	   mySql.setSqlId("LABaseRuleInput.js_updateClick");
	   mySql.setValue("p_BaseCode", trim(fm.all('RuleCode').value));
    var strQueryResult = easyQueryVer3(mySql.getString(), 1, 0, 1);
  if (!strQueryResult)
  {
    alert(I18NMsg("BOM_Thisbasiccodedoesnotexist!"));    
  }else
  { 	if(!confirm(I18NMsg("BOM_Suretomodify?"))){
		return false;
	}
	  fm.hideOperate.value="UPDATE||MAIN";
	  submitForm1();
  }
  fm.BranchType.disabled = true;
}           

//Click事件，当点击“查询”图片时触发该函数

function queryClick()
{
  //下面增加相应的代码
  mOperate="QUERY||MAIN";
  showInfo=window.open("./LABaseRuleQueryH.jsp");
}           

//Click事件，当点击“删除”图片时触发该函数

function deleteClick()
{
	 fm.BranchType.disabled = false;

 	if ((trim(fm.all('RuleCode').value)=='')||(fm.all('RuleCode').value==null)) {
	  	alert(I18NMsg("BOM_Basiclawcodeisblank,cannotbedeleted!"));
	 		return false;
	 	}
 	if(!confirm(I18NMsg("BOM_Suretodelete?"))){
 		return false;
 	}
	fm.hideOperate.value="DELETE||MAIN";
	  submitForm1();
	
}
//Click事件，当点击“修改规则”图片时触发该函数

function modifyClick()
{
	 fm.BranchType.disabled = false;

 	if ((trim(fm.all('RuleCode').value)=='')||(fm.all('RuleCode').value==null)) {
	  	alert(I18NMsg("BOM_Basiclawcodeisblank,cannotbemodified!"));
	 		return false;
	 	}
 	if(mStatus=="04")
 	{
 	 	if(!confirm(I18NMsg("BOM_Suretomodifytherule?"))){
 	 		return false;
 	 	}
 		fm.hideOperate.value="MODIFY||MAIN";
 		  submitForm1();
 	}else{
 		alert(I18NMsg("BOM_Basiclawstatushasnotbeenpubliced,cannotprocessrulemodify!"));
 	}
 	fm.BranchType.disabled = true;
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



function afterQuery(arrQueryResult)
{	
	var arrResult = new Array();
	
	if( arrQueryResult != null )
	{
		arrResult = arrQueryResult;	
		fm.BranchType.disabled = true;

		fm.all('RuleCode').value = arrResult[0][0];
	    fm.all('RuleName').value = arrResult[0][1];
	    fm.all('BranchType').value = arrResult[0][2];
	    fm.all('BranchTypeName').value = arrResult[0][3];
	    fm.all('Remark').value = arrResult[0][4];
	    mStatus=arrResult[0][5];
	    fm.all('Status').value =arrResult[0][5];
	    showOneCodeName('status', 'Status', 'StatusName');
   }
}


function myShowCodeList(obj1,obj2){
	//var tStatus = trim(fm.Status.value);
	var tStatus="01";
	
	 var mySql = new SqlClass();
	   mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
	   mySql.setSqlId("LABaseRuleInput.js_myShowCodeList");
	   mySql.setValue("p_BaseCode", trim(fm.all('RuleCode').value));
  
	var strQueryResult  = easyQueryVer3(mySql.getString(), 1, 0, 1);
	    var s=decodeEasyQueryResult(strQueryResult);
	    if(s){
	    	tStatus=s[0][0];
	    }
	    
	var tsql = "";
	if(tStatus=="" || tStatus==null){
		alert(I18NMsg('BOM_BasicLawstatuscannotbeblank!'));
	}else if(tStatus=="04"){//如果是审核发布，可以改成停用
		tsql=" #1# and code in(#04#,#05#,#06#)";
	}else if (tStatus=="06"){//如果是停用状态，可以改成审核发布、修改规则
		tsql=" #1# and code in(#04#,#05#,#06#)";
	}else{
		tsql=" #1# and code = #"+tStatus+"#";
	}
	showCodeList('status',[obj1,obj2],[0,1],null,tsql,'1',1);
}

function myShowCodeListKey(obj1,obj2){
	var tStatus="01";
	
	var mySql = new SqlClass();
	   mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
	   mySql.setSqlId("LABaseRuleInput.js_myShowCodeList");
	   mySql.setValue("p_BaseCode", trim(fm.all('RuleCode').value));
	   
	var strQueryResult  = easyQueryVer3(mySql.getString(), 1, 0, 1);
	    var s=decodeEasyQueryResult(strQueryResult);
	    if(s){
	    	tStatus=s[0][0];
	    }
	var tsql = "";
	if(tStatus=="" || tStatus==null){
		alert(I18NMsg('BOM_BasicLawstatuscannotbeblank!'));
	}else if(tStatus=="04"){//如果是审核发布，可以改成停用
		tsql=" #1# and code in(#04#,#05#,#06#)";
	}else if (tStatus=="06"){//如果是停用状态，可以改成审核发布、修改规则
		tsql=" #1# and code in(#04#,#05#,#06#)";
	}else{
		tsql=" #1# and code = #"+tStatus+"#";
	}
	showCodeListKey('status',[obj1,obj2],[0,1],null,tsql,'1',1);
}