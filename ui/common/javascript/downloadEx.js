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
	var showStr=""G0000025531"";
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

function dl_afterSubmitEx( FlagStr, content, serverFileName, dFileName, modifyTime)
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
  	var m = ""G0000025534" ";
		m = m + modifyTime;
		m = m + ""G0000025535"";
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
			dl_remove(serverFileName);
			//alert("请再次生成模板！")
		}
	}
	else 
	{
		myAlert(content);
		dl_download(serverFileName, dFileName);
	}
  
  }
}

function dl_download(serverFileName, dFileName) {
	//window.focus();
	//fm.action="./MonProDownload.jsp?serverFilePath="+serverFilePath + "&fileName=" + dFileName;
	fm.action="../common/jsp/Download.jsp?serverFileName=" + serverFileName + "&fileName=" + dFileName + "&operation=download";
	fm.submit();
	resetAction();
}

function dl_remove(serverFileName) 
{
	fm.action="../common/jsp/Download.jsp?serverFileName=" + serverFileName + "&operation=remove";
	fm.submit();
	resetAction();
	
	var showStr=""G0000025531"";
	var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
	showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
	dl_doDisable();
	fm.submit();
	resetAction();
}

