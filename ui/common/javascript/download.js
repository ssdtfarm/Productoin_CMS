/*******************************************************************************
 * <p>Title: Lis</p>
 * <p>Description: 中科软人寿保险销售管理系统</p>
 * <p>Copyright: Copyright (c) 2008 Sinosoft, Co.,Ltd. All Rights Reserved</p>
 * <p>Company: 中科软科技股份有限公司</p>
 * <p>WebSite: http://www.sinosoft.com.cn</p>
 *
 * @author   : wangwei, Luochg
 * @version  : 1.00, 1.01
 * @date     : 2008-3-20
 * @direction: 下载相关函数
 ******************************************************************************/
/*============================================================================*/

var showInfo = null;
var buttons = new Array();

/*============================================================================*/

/**
 * 弹出信息框，如果有参数，则使参数disable
 */
function dl_disable() 
{
	var showStr="正在处理数据，请您稍候并且不要修改屏幕上的值或链接其他页面";
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	if (arguments.length > 0) 
	{
		buttons = arguments;
		for(var i = 0; i < arguments.length; i++)
		{
			arguments[i].disabled=true;
		}
	}
}

function dl_doDisable() 
{
	for(var i = 0; i < buttons.length; i++) 
	{
		buttons[i].disabled=true;
	}
}

function dl_enable() 
{
	
	showInfo.close();
	for(var i = 0; i < buttons.length; i++) 
	{
		buttons[i].disabled=false;
	}
}

function dl_afterSubmit( FlagStr, content, serverFileName, dFileName, modifyTime)
{

	window.focus();
	dl_enable();
	
  if (FlagStr == "Fail" )
  {             
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
    urlStr=encodeURI(encodeURI(urlStr));
    showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
  }
  else
  { 
  if (modifyTime)
  {
  	var m = "服务器上存在这个报表，它生成的时间是 ";
		m = m + modifyTime;
		m = m + "\n你想直接下载请点击确定\n如果你想重新生成新报表请点击取消";
		var c=confirm(m);
		//直接下载
	
		if (c == true)
		{
			//parent.fraInterface.dl_afterSubmit("<%=FlagStr%>","<%=Content%>","<%=serverFileName%>","<%=fileName%>", false);
			dl_download(serverFileName, dFileName);
		}
		//重新生成
		if (c == false)
		{
			//alert("请再次生成报表！")
			dl_remove(serverFileName);			
		}
	}
	else 
	{
		alert(content);
		dl_download(serverFileName, dFileName);
	}
  
  }
}


//add by Maqingyu
//用于修改报表默认下载位置，即修改为以功能名+日期的路径下
function dl_afterSubmit( FlagStr, content, serverFileName, dFileName, sysvar, funName, modifyTime)
{

	window.focus();
	dl_enable();
	
  if (FlagStr == "Fail" )
  {             
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
    urlStr=encodeURI(encodeURI(urlStr));
    showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
  }
  else
  { 
  if (modifyTime)
  {
	  //此版报表基类不会走到这个位置，因为生成的报表名包含时分秒，故新产生的报表绝不会在服务器上存在
  	var m = "服务器上存在这个报表，它生成的时间是 ";
		m = m + modifyTime;
		m = m + "\n你想直接下载请点击确定\n如果你想重新生成新报表请点击取消";
		var c=confirm(m);
		//直接下载
		
		if (c == true)
		{
			dl_download(serverFileName, dFileName, sysvar, funName);
		}
		//重新生成
		if (c == false)
		{
			dl_remove(serverFileName);			
		}
	}
	else 
	{
		alert(content);
		dl_download(serverFileName, dFileName, sysvar, funName);
	}
  
  }
}

function dl_download(serverFileName, dFileName) {
	
	document.getElementById('downloadframe').src="../common/jsp/Download.jsp?serverFileName=" + serverFileName + "&fileName=" + dFileName + "&operation=download";
}

//add by Maqingyu
function dl_download(serverFileName, dFileName, sysvar, funName) {
//	alert("new download");
	 document.getElementById('downloadframe').src="../common/jsp/Download.jsp?serverFileName=" + serverFileName + "&fileName=" + dFileName + "&sysvar=" + sysvar + "&funName=" + funName + "&operation=download";
}

function dl_remove(serverFileName) 
{
	//alert("fm.action="+fm.action);
	fm.action="../common/jsp/Download.jsp?serverFileName=" + serverFileName + "&operation=remove";
	fm.submit();
	//alert("开始调用函数resetAction()");
	resetAction();
	//alert("调用函数resetAction()结束");
	var showStr="正在准备打印数据，请您稍候并且不要修改屏幕上的值或链接其他页面";
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	dl_doDisable();
	fm.submit();
	resetAction();
}

