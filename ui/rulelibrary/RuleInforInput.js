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
/********************* 表单：fm *********************/
var turnPageProGird = new turnPageClass();
function easyQueryProGird(){
    initProGird();
    // 书写SQL语句
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = " "
        //+ tReturn
    ;
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPageProGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageProGird.strQueryResult) {
        alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
        return false;
    }
    turnPageProGird.queryModal(strSQL,ProGird);
}//function easyQueryProGird
var turnPageRuleGird = new turnPageClass();
function easyQueryRuleGird(){
    initRuleGird();
    // 书写SQL语句
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = " "
        //+ tReturn
    ;
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPageRuleGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageRuleGird.strQueryResult) {
        alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
        return false;
    }
    turnPageRuleGird.queryModal(strSQL,RuleGird);
}//function easyQueryRuleGird
//查询
function QueryAgent(){
    if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='queryagent';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"queryagent")){
    //    return false;
    //} 
    //TODO 这里一般会调用上边的easyQuery方法，请选择下边一个合适的方法
    //easyQueryProGird();
    //easyQueryRuleGird();
    fm.hideOperate.value="";
    return true;
}
//增加
function Add(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    showInfo=window.open("./LRProAdd.jsp");
    return true;
}
//删除
function Delete(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='Delete';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"Delete")){
    //    return false;
    //} 
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//修改
function UpdateAgent(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    showInfo=window.open("./LRProUpdate.jsp");
    return true;
}
//增加
function AddRule(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    showInfo=window.open("./LRRuleAdd.jsp");
    return true;
}
//删除
function DeleteRule(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='Delete';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"Delete")){
    //    return false;
    //} 
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//修改
function UpdateRule(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    showInfo=window.open("./LRRuleUpdate.jsp");
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
    ProGird.delBlankLine();
    RuleGird.delBlankLine();
    fm.submit(); //提交
    fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边
        /*
         fm.all('WageCode').value = arrQueryResult[0][0];
         fm.all('WageName').value = arrQueryResult[0][1];
         fm.all('WageType').value = arrQueryResult[0][2];
         fm.all('IndexSerise').value = arrQueryResult[0][3];
        */
        showCodeName();
        //查询MulLine
        easyQueryProGird();
        easyQueryRuleGird();
    }
    return true;
}
function getQueryResult(){
    var arrSelected = null;
    var rowNo = RuleGird.getSelNo();
    if( rowNo == 0 || rowNo == null )
        return arrSelected;
    //var rowData = RuleGird.getRowData(rowNo-1); //这是被选中的那行数据，返回这个数组应该会更方便       
    arrSelected = new Array();
    //TODO 把SQL写到这里
    var strSQL = "";
    var vResult = easyQueryVer3(strSQL, 1, 1, 1);

    //判断是否查询成功
    if (!vResult) {
        alert(I18NMsg("BOM_Norecordfitstheenquirycondition!"));
        return false;
    }
    //查询成功则拆分字符串，返回二维数组
    arrSelected = decodeEasyQueryResult(vResult);
    return arrSelected;
}