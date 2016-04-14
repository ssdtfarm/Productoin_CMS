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
	//alert(0);
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
	var name=fm.Name.value;
	var branch=fm.BranchType.value;
    var bomid=fm.ID.value;
    
    var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LRBomUpdateInput.js_ModifyBomName");
    mySql.setValue("p_name", name);
    mySql.setValue("p_branchtype",branch);
    mySql.setValue("p_id",bomid);
    result = easyQueryVer3(mySql.getString(), 1, 0, 1);
	var array=decodeEasyQueryResult(result);
	if(array>0)	{
	  alert(I18NMsg("BOM_ThisBOMnameisexisting"));
	  return false;
	}
}
/********************* 表单：fm *********************/
//保存
function save(){    

    fm.hideOperate.value='saveButton';
    //alert('123');
    if(!verifyForm('fm')){
        return false;
    }
    //alert('456');
    //if (!beforeSubmitVerify(fm,"saveButton")){
    //    return false;
    //} 
    //TODO 处理逻辑放到这里
    var tname=fm.Name.value;
    var sname="输入值";
    var snameen="Input value";
    var validNum=tname.indexOf(sname);
    var validNumen=tname.indexOf(snameen);
    if(validNum!=-1 && validNumen != -1){
    	alert(I18NMsg("BOM_BOMnameshouldnotincludethewords'Inputvalue',pleaseinputagain!"));
    	fm.Name.value="";
    	return false;
    }     
    if(nameonly()==false)return false;
    if(!confirm(I18NMsg("BOM_Suretosubmitmodify?"))) return false;
    submitfm();
    fm.hideOperate.value="";
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
         fm.all('Name').value = arrQueryResult[0][0];
         fm.all('Remark').value = arrQueryResult[0][1];
         fm.all('ID').value = arrQueryResult[0][2];
        */
        showCodeName();
        //查询MulLine
    }
    return true;
}