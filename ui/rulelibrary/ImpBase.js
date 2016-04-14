//               该文件中包含客户端需要处理的函数和事件

var showInfo;
var mDebug="0";
var arrDataSet; 
var turnPage = new turnPageClass();

//提交，保存按钮对应操作
function submitForm()
{
  var i = 0;
  var showStr=I18NMsg("Enquiringdata,pleasewaitanddonotedittheinformationonscreenorjumptoanyotherpage");
  var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
  urlStr=encodeURI(encodeURI(urlStr));
  showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");   

  //  initPolGrid();
  //showSubmitFrame(mDebug);
  fm.submit(); //提交
}
	//下载excel文件
function afterSubmit(FlagStr,Content)
{
	showInfo.close();
	window.focus();
    if (FlagStr == "Fail" )
    {
        var urlStr="../common/jsp/MessagePage.jsp?picture=F&content=" + Content ;
        urlStr=encodeURI(encodeURI(urlStr));
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    }
    else
    {
        var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + Content ;
        urlStr=encodeURI(encodeURI(urlStr));
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
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
	  	alert("ImpBase.jsp-->resetForm"+I18NMsg('Alert_InitJspError'));
  }
} 


function Import()
{ 
	var i = 0;
	filename=fm.FileName.value;
	if(filename==null||filename==""){
		alert(I18NMsg('BOM_PleaseuploadXMLfile!'));
		return false;
	}
	var flag = filename.substring(filename.lastIndexOf(".")+1).toUpperCase();
	if(flag!="XML"){
		alert(I18NMsg('BOM_Thefileshouldbe.xmlfile!'));
		return false;
	}
	var showStr=I18NMsg("Saving,pleasedonoteditanyinformationorlinktootherscreen");
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
	urlStr=encodeURI(encodeURI(urlStr));
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	fm.all('ImportPath').value = "/upload/";
	fm.submit(); //提交	
}

function getImportPath ()
{
	// 书写SQL语句
	var strSQL = "";
	strSQL = "select SysvarValue from ldsysvar where sysvar ='XmlPath'";
	turnPage.strQueryResult  = easyQueryVer3(strSQL, 1, 1, 1);
	//判断是否查询成功
	if (!turnPage.strQueryResult) {
		alert(I18NMsg('BOM_Cannotfindthefilepath!'));
		return;
	}
	//清空数据容器，两个不同查询共用一个turnPage对象时必须使用，最好加上，容错
	turnPage.arrDataCacheSet = clearArrayElements(turnPage.arrDataCacheSet);
	//查询成功则拆分字符串，返回二维数组
	turnPage.arrDataCacheSet = decodeEasyQueryResult(turnPage.strQueryResult);
	return turnPage.arrDataCacheSet[0][0];
}