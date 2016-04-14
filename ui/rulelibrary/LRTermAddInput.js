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
function afterCodeSelect(strCodeName,Field){
	if(strCodeName=='calculate'){
		if(fm.all("Calculate").value=='01'){
			$('.sql').show();
			$('.att').hide(); 
		}else if(fm.all("Calculate").value=='02' || fm.all("Calculate").value=='03'){
			  $('.sql').hide();
			  $('.att').show();
		}
	}
}
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
var turnPagePhraseGird = new turnPageClass();
function easyQueryPhraseGird(){

    // 书写SQL语句
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = ""
        //+ tReturn
    ;
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPagePhraseGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPagePhraseGird.strQueryResult) {
        alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
        return false;
    }
    turnPagePhraseGird.queryModal(strSQL,PhraseGird);
}


var turnPageParaGird = new turnPageClass();
function easyQueryParaGird(){
    initParaGird();
    // 书写SQL语句
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = " "
        //+ tReturn
    ;
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPageParaGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageParaGird.strQueryResult) {
        alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
        return false;
    }
    turnPageParaGird.queryModal(strSQL,ParaGird);
}

/**
 * search Item Name to sure The item name only one.
 * @returns {Boolean}
 */
function nameonly(){
	var name=fm.Name.value;
	var bomid=fm.BomId.value;
	
	var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LRTermAddInput.js_SearchItemName");
    mySql.setValue("p_name", name);
    mySql.setValue("p_bomid",bomid);
    result = easyQueryVer3(mySql.getString(), 1, 0, 1);
	var array=decodeEasyQueryResult(result);
	if(array>0)
	{
	  alert(I18NMsg("BOM_Thisentryhasbeenexisted"));
	  return false;
	}
}
/**
 * 保存
 */
function save(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='save';
    if(!verifyForm('fm')){
        return false;
    }
    
    var Remark = trim(fm.textarea.value).toLowerCase();
    var obj="select";
    if(Remark.substring(0,obj.length) != obj)
    {
    	alert("The inputed value should be start with the world 'select'!");
    	return false;
    }
    if(Remark.indexOf('create')!=-1 || Remark.indexOf('drop')!=-1 
    		|| Remark.indexOf('update')!=-1 || Remark.indexOf('delete')!=-1 || Remark.indexOf('\n')!=-1 
    		|| Remark.indexOf(';')!=-1){
    	alert('Noncompliance character!');
    	return false;
    	
    }
    //if (!beforeSubmitVerify(fm,"save")){
    //    return false;
    //} 
    
    var tname=fm.Name.value;
    var sname="输入值";
    var validNum=tname.indexOf(sname);
    if(validNum!=-1){
    	alert(I18NMsg("BOM_Entrynameshouldnotincludethewords'Inputvalue',pleaseinputagain!"));
    	fm.Name.value="";
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
//    PhraseGird.delBlankLine();
//    ParaGird.delBlankLine();
    fm.submit(); //提交
    fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        /*
         fm.all('Name').value = arrQueryResult[0][0];
         fm.all('Remark').value = arrQueryResult[0][1];
        */
        showCodeName();
        //查询MulLine
        easyQueryPhraseGird();
        easyQueryParaGird();
    }
    return true;
}
function getQueryResult(){
    var arrSelected = null;
    var rowNo = ParaGird.getSelNo();
    if( rowNo == 0 || rowNo == null )
        return arrSelected;
    //var rowData = ParaGird.getRowData(rowNo-1); //这是被选中的那行数据，返回这个数组应该会更方便       
    arrSelected = new Array();
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