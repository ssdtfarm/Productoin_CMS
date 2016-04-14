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
var turnPageAgentGird = new turnPageClass();
function easyQueryAgentGird(){
    initAgentGird();
    // 书写SQL语句
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = "select basecode,name,branchtype,operator,modifydate,modifytime,remark from lrbaseh order by modifydate desc,modifytime desc";
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPageAgentGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageAgentGird.strQueryResult) {
        alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
        return false;
    }
    turnPageAgentGird.queryModal(strSQL,AgentGird);
}//function easyQueryAgentGird
//查看明细
function query(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    var tRow = AgentGird.getSelNo();
    if( tRow == 0 || tRow == null ) {
		//top.close();
		alert( ""+I18NMsg("G0000028284")+"" );
	} else {
	    showInfo=window.open("./treeview/LAIndexInput.jsp?BaseCode=" + AgentGird.getRowColData(tRow-1,1) );
	}
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
    AgentGird.delBlankLine();
    fm.submit(); //提交
    fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边
        /*
        */
        showCodeName();
        //查询MulLine
        easyQueryAgentGird();
    }
    return true;
}