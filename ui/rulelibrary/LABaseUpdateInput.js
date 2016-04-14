var showInfo;
var turnPage = new turnPageClass();
window.onfocus=function (){
    if(showInfo!=null){
        try{
            showInfo.focus();
        }catch(ex){
            showInfo=null;
        }
    }
};
//提交后操作,服务器数据返回后执行的操作
function afterSubmit( FlagStr, content ){
    showInfo.close();
    if (FlagStr == "Fail" ){
        var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
        urlStr=encodeURI(encodeURI(urlStr));
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
    }else{
        var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + content ;
        urlStr=encodeURI(encodeURI(urlStr));
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
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







function submitForm()
{
	       fm.hideOperate.value="INSERT||MAIN"; 
	   	   submitForm1();
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
 

}
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
  }else{ 	if(!confirm(I18NMsg("BOM_Suretomodify?"))){
		return false;
	}
	  fm.hideOperate.value="UPDATE||MAIN";
	  submitForm1();
  }
  fm.BranchType.disabled = true;
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

