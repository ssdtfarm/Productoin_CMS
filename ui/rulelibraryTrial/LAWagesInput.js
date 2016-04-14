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
// 	if ((trim(fm.ManageCom.value)=='')||(fm.ManageCom.value==null))
// 	{
//	  	alert("管理机构不能为空,请输入:");
//			fm.ManageCom.focus();
//	 		return false;
//	}
// 	if ((trim(fm.BranchType.value)=='')||(fm.BranchType.value==null))
// 	{
//	  	alert("渠道不能为空,请输入:");
//			fm.BranchType.focus();
//	 		return false;
//	}
// 	if ((trim(fm.BaseCode.value)=='')||(fm.BaseCode.value==null))
// 	{
//	  	alert("基本法版本不能为空,请输入:");
//			fm.BaseCode.focus();
//	 		return false;
//	}
// 	if ((trim(fm.WageNo.value)=='')||(fm.WageNo.value==null))
// 	{
//	  	    alert("薪资年月不能为空,请输入:");
//			fm.WageNo.focus();
//	 		return false;
//	}else if(fm.WageNo.value.length!=6)
//	{
//			alert("输入的薪资年月长度不正确");
//			return false;
//	}else
//	{
		var wageno=fm.WageNo.value;
//		alert(wageno);
//		alert(wageno.substr(4,6));
		if(!(wageno.substr(4,6)>0 && wageno.substr(4,6)<13))	
		{
				alert(I18NMsg("BOM_Compensationmonthshouldin1to12,pleaseinputagain!"));
				fm.WageNo.value='';
				fm.WageNo.focus();
				return false;
		}
//	}	
	return true;
 	
}
//提交表单fm
function submitfm(){
	if(!beforeSubmit())
		return false;
    var i = 0;
    var showStr=I18NMsg("BOM_Calculating…");
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
    urlStr=encodeURI(encodeURI(urlStr));
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    if (fm.hideOperate.value==""){
        alert(I18NMsg("C_Missingoperationtype,pleaseresubmittheoperation!"));
        return false;
    }
    fm.submit(); //提交
    fm.hideOperate.value="";
}
function initEdorType(cObj1,cObj2)
{
	mEdorType = " #1# ";
	showCodeList('ComCode',[cObj1,cObj2],[0,1], null, mEdorType, "1");
}

function actionKeyUp(cObj1,cObj2)
{	
	mEdorType = " #1# ";
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

function  save(){
    fm.hideOperate.value='calculate';
    if(!verifyForm('fm')){
        return false;
    }
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}

function  save1(){
    fm.hideOperate.value='calculate';
    fm.IndexType.value = '02';
    if(!verifyForm('fm')){
        return false;
    }
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}

function  save2(){
    fm.hideOperate.value='calculate';
    fm.IndexType.value = '03';
    if(!verifyForm('fm')){
        return false;
    }
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}

/**
 * 自定义双击查询
 * @param obj1
 * @param obj2
 * @returns {Boolean}
 */
function myShowCodeList(obj1,obj2){
	var tBranchType = trim(fm.BranchType.value);
	var tsql = "";
	if(tBranchType=="" || tBranchType==null){
		alert(I18NMsg("BOM_Pleaseselectchannelfirst,thenselectbasiclaw!"));
		return false;
	}else{
		tsql=" #1# and branchtype = #"+tBranchType+"# and status !=#06#";
	}
	showCodeList('baseversion3',[obj1,obj2],[0,1],null,tsql,'1',1);
}

function myShowCodeListKey(obj1,obj2){
	var tBranchType = trim(fm.BranchType.value);
	var tsql = "";
	if(tBranchType=="" || tBranchType==null){
		alert(I18NMsg("BOM_Pleaseselectchannelfirst,thenselectbasiclaw!"));
		return false;
	}else{
		tsql=" #1# and branchtype = #"+tBranchType+"# and status !=#06#";
	}
	showCodeListKey('baseversion3',[obj1,obj2],[0,1],null,tsql,'1',1);
}