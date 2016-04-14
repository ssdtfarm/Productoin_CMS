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
/********************* 表单：fm *********************/
function nameonly(){
	var name=fm.IndexName.value;
	var wagecode=fm.WageCode.value;
	var indexcode=fm.IndexCode.value;
	//var branch=fm.BranchType.value;
	var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LRRuleUpdateInput.js_SearchWageName");
    mySql.setValue("p_indexname", name);
    mySql.setValue("p_wagecode", wagecode);
    mySql.setValue("p_indexcode", indexcode);
    var result = easyQueryVer3(mySql.getString(), 1, 0, 1);
	var array=decodeEasyQueryResult(result);
	
	if(array>0)
	{
	  alert(I18NMsg("BOM_Thisrulenamehasbeenexisted"));
	  return false;
	}
}
//保存
function save(){	
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='save';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"save")){
    //    return false;
    //} 
    //TODO 处理逻辑放到这里    
    var tname=fm.IndexName.value;
    var sname="输入值";
    var validNum=tname.indexOf(sname);
    if(validNum!=-1){
    	alert(I18NMsg("BOM_Rulenameshouldnotincludethewords'Inputvalue',pleaseinputagain!"));
    	fm.IndexName.value="";
    	return false;
    } 
    
    var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LRRuleUpdateInput.js_SearchDataType");
    mySql.setValue("p_indexname", fm.all("IndexCode").value);
    var result = easyQueryVer3(mySql.getString(), 1, 0, 1);
	var s=decodeEasyQueryResult(result);
	if(s){
		if(s[0]!=fm.DataType.value){
			alert(I18NMsg("BOM_Thisruleisbeingquoting,'datatype'and'calculationtype'cannotbemodified!"));
			return false;
		}
	}
	if(nameonly()==false)return false;
    if(!confirm(I18NMsg("BOM_Suretomodify?"))) return false;
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
    fm.DataType.disabled=false;
    fm.LogicType.disabled=false;
    fm.submit(); //提交
    fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边
        /*
         fm.all('IndexCode').value = arrQueryResult[0][0];
         fm.all('IndexName').value = arrQueryResult[0][1];
         fm.all('BranchType2').value = arrQueryResult[0][2];
         fm.all('Description').value = arrQueryResult[0][3];
        */
        showCodeName();
        //查询MulLine
    }
    return true;
}