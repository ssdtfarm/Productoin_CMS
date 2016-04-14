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
    }
    else{
        var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + content ;
        urlStr=encodeURI(encodeURI(urlStr));
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
    }
    //fm.reset();
}
/********************* 表单：fm *********************/
//计算
function saveClick(){
    fm.hideOperate.value='calculate';
    if(!verifyForm('fm')){
        return false;
    }
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//提交前的校验、计算
function beforeSubmit()
{
	if( verifyInput() == false ) 
	    return false;
 	if ((trim(fm.ManageCom.value)=='')||(fm.ManageCom.value==null))
 	{
	  	alert("Plase enter the Governing Hierarchy:");
			fm.ManageCom.focus();
	 		return false;
	}
 	if ((trim(fm.BranchType.value)=='')||(fm.BranchType.value==null))
 	{
	  	alert("Plase enter the channels！");
			fm.BranchType.focus();
	 		return false;
	}
 	if ((trim(fm.BaseCode.value)=='')||(fm.BaseCode.value==null))
 	{
	  	alert("Plase enter the Sales Management Policy Version");
			fm.BaseCode.focus();
	 		return false;
	}
 	if ((trim(fm.WageNo.value)=='')||(fm.WageNo.value==null))
 	{
	  	    alert("Plase enter the Calculation Month/Year");
			fm.WageNo.focus();
	 		return false;
	}else if(fm.WageNo.value.length!=6)
	{
			alert("The length of the input Calculation Month/Year is incorrect");
			return false;
	}else
	{
		var wageno=fm.WageNo.value;
		for(var i=1;i<=4;i++)
		{
			if(!(wageno.substring(i,1)>=0 && wageno.substring(i,1)<=9))
			{
				alert("Years in Calculation Month/Year should be a number between 0-9!");
			    return false;
			}
			return true;
		}
		if(!(wageno.substring(1,4)>1900 && wageno.substring(1,4)<2099))
		{
			alert("Years in Calculation Month/Year should  between 1900-2099 Year!");
		    return false;
		}
		if(!(wageno.substring(4,6)>0 && wageno.substring(4,6)<13))	
		{
				alert("Month in Calculation Month/Year should between January to December!");
				fm.WageNo.value='';
				fm.WageNo.focus();
				return false;
		}
	}	
	
 	
}
//提交表单fm
function submitfm(){
	if(!beforeSubmit())
		return false;
    var i = 0;
    //var showStr="Saving data, please wait and you do not modify the value on the screen or links to other pages";
    var showStr=I18NMsg("Saving,pleasedonoteditanyinformationorlinktootherscreen");
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
    urlStr=encodeURI(encodeURI(urlStr));
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    if (fm.hideOperate.value==""){
        alert("Operation control data loss!");
        return false;
    }
    fm.submit(); //提交
    fm.hideOperate.value="";
}
function initEdorType(cObj1,cObj2)
{
	mEdorType = " #1# and length(trim(ComCode))=4 ";
	showCodeList('ComCode',[cObj1,cObj2],[0,1], null, mEdorType, "1");
}

function actionKeyUp(cObj1,cObj2)
{	
	mEdorType = " #1# and length(trim(ComCode))=4 ";
	showCodeListKey('ComCode',[cObj1,cObj2],[0,1], null, mEdorType, "1");
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边
        /*
         fm.all('ManageCom').value = arrQueryResult[0][0];
         fm.all('BranchType').value = arrQueryResult[0][1];
         fm.all('BaseCode').value = arrQueryResult[0][2];
         fm.all('WageNo').value = arrQueryResult[0][3];
        */
        showCodeName();
        //查询MulLine
    }
    return true;
}