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
    var Termid = fm.all("hideTermid").value;
    var strSQL = "select edorno,id,name,(select codename from ldcode where codetype='ibrmscommandtype' and code =a.datatype),operator2,modifydate2,modifytime2 from lrTermb a where id ='"+Termid+"'"
        //+ tReturn
    +"order by modifydate2 desc, modifytime2 desc";
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPageAgentGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageAgentGird.strQueryResult) {
        myAlert(""+I18NMsg("G0000035686")+"");
        return false;
    }
    turnPageAgentGird.queryModal(strSQL,AgentGird);
}//function easyQueryAgentGird
//查看明细
function query(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
	tRow = AgentGird.getSelNo();	
    showInfo=window.open("./LAIndexInput.jsp?BaseCode=" + AgentGird.getRowColData(tRow-1,1));
    return true;
}
//提交表单fm
function submitfm(){
    var i = 0;
    //var showStr=""+I18NMsg("M0000050069")+"";
    var showStr=I18NMsg("Saving,pleasedonoteditanyinformationorlinktootherscreen");
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
    urlStr=encodeURI(encodeURI(urlStr));
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    if (fm.hideOperate.value==""){
        myAlert(""+I18NMsg("G0000028334")+"");
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
function detail(){
    var rNo = AgentGird.getSelNo();		
    if(rNo == null )        
   	{
   		 	return false;
   	}
    var Data = AgentGird.getRowData(rNo-1);
    var edorno = Data[0];
	
		var strSQL="select CalSQL from lrTermb a where edorno ='"+edorno+"'";
    var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
	  var s=decodeEasyQueryResult(strQueryResult);
	
	
		$("#sql").text(s[0]);
    
    
}
