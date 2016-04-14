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
}
function nameonly(){
	var name=fm.WageName.value;
	var branch=fm.BranchType.value;
	var WageType=fm.WageType.value;
	
	var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LRProAddInput.js_SearchWageName");
    mySql.setValue("p_WageName", name);
    mySql.setValue("p_branchtype", branch);
    mySql.setValue("p_WageType",WageType);
    var result = easyQueryVer3(mySql.getString(), 1, 0, 1);
	var array=decodeEasyQueryResult(result);
	if(array>0)
	{
	  alert(I18NMsg("BOM_Thisitemnamehasbeenexisted"));
	  return false;
	}
}
/********************* 表单：fm *********************/
//保存
function save(){    
    fm.hideOperate.value='saveButton';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"saveButton")){
    //    return false;
    //} 
    //TODO 处理逻辑放到这里    
    var tname=fm.WageName.value;
    var sname="输入值";
    var validNum=tname.indexOf(sname);
    if(validNum!=-1){
    	alert(I18NMsg("BOM_Itennameshouldnotincludethewords'Inputvalue',pleaseinputagain!"));
    	fm.WageName.value="";
    	return false;
    }     
    if(nameonly()==false)return false;
    if(!confirm(I18NMsg("BOM_Suretoaddanewrecord?"))) return false;
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//重置
function resetForm(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    initfm();
    return true;
}
//提交表单fm
function submitfm(){
    var i = 0;
    var showStr=I18NMsg("Saving,pleasedonoteditanyinformationorlinktootherscreen");
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
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边
        /*
         fm.all('WageName').value = arrQueryResult[0][0];
         fm.all('BranchType').value = arrQueryResult[0][1];
         fm.all('BranchType2').value = arrQueryResult[0][2];
         fm.all('Description').value = arrQueryResult[0][3];
         fm.all('IndexSerise').value = arrQueryResult[0][4];
         fm.all('WageType').value = arrQueryResult[0][5];
        */
        showCodeName();
        //查询MulLine
    }
    return true;
}