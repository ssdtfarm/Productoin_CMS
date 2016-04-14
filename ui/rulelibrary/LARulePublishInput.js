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
    easyQueryRuleGrid();
}
/********************* 表单：fm *********************/
var turnPageRuleGrid = new turnPageClass();
function easyQueryRuleGrid(){
    initRuleGrid();
    var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LARulePublishInput.js_SearchBase");
    mySql.setValue("p_BaseCode", trim(fm.all('BaseCode').value));
    mySql.setValue("p_Name", trim(fm.all('Name').value));
    mySql.setValue("p_BranchType", trim(fm.all('BranchType').value));
    if(fm.Status.value==""){
    	mySql.setValue("p_status", '02');
    }else{
    	mySql.setValue("p_status", trim(fm.Status.value));
    }
    
//    var strSQLexcel= strSQL;
//    fm.all("tSQL").value=strSQL;
    turnPageRuleGrid.strQueryResult  = easyQueryVer3(mySql.getString(), 1, 0, 1);

    //判断是否查询成功
    if (!turnPageRuleGrid.strQueryResult && fm.hideOperate.value=='query') {
        alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
        return false;
    }
    turnPageRuleGrid.queryModal(mySql.getString(),RuleGrid);
}//function easyQueryRuleGrid
//查询
function queryClick(){
    fm.hideOperate.value='query';
    if(!verifyForm('fm')){
        return false;
    }
    easyQueryRuleGrid();
    //fm.hideOperate.value="";
    return true;
}
//重置
function resetClick(){
    initfm();
    return true;
}
//审核通过
function RulePublish(){
    fm.hideOperate.value='RulePublish';
    if(!verifyForm('fm')){
        return false;
    }

    var rowNo = RuleGrid.getSelNo();
    if( rowNo == 0 || rowNo == null )
    {  alert(I18NMsg("BOM_Pleaseselectarecord!"));
       return false;
    }
    //alert(RuleGrid.getRowColData(rowNo-1,4));
    if(RuleGrid.getRowColData(rowNo-1,4)=="Waiting for Confirm" || RuleGrid.getRowColData(rowNo-1,4)=="Confirm"
		|| RuleGrid.getRowColData(rowNo-1,4)=="已提請審核" 
			|| RuleGrid.getRowColData(rowNo-1,4)=="已提请审核" )
	{
//    if(RuleGrid.getRowColData(rowNo-1,4)=="已提请审核")
//	{
		fm.all('hideStatus').value="04";
		if(fm.all('Reason').value!="")
		{
			alert(I18NMsg("BOM_Ifauditbeenapproved,therejectedreasondoesnotneedtoinputed!"));
			fm.all('Reason').value='';
		}
		
	}
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//审核不通过
function RuleNPublish(){
    fm.hideOperate.value='RuleNPublish';
    if(!verifyForm('fm')){
        return false;
    }
    var rowNo = RuleGrid.getSelNo();
    if( rowNo == 0 || rowNo == null )
    {  alert(I18NMsg("BOM_Pleaseselectarecord!"));
       return false;
    }
    if(RuleGrid.getRowColData(rowNo-1,4)=="已提请审核")
	{
		fm.all('hideStatus').value="03";
		if(fm.all('Reason').value=="")
		{
			alert(I18NMsg("Pleaseinputrejectedreason!"));
			return false;
		}
		
	}
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//提交前的校验、计算

function beforeSubmit()
{
  if( verifyInput() == false ) {
    return false;
   }
  var rowNo = RuleGrid.getSelNo();
  if( rowNo == 0 || rowNo == null )
  {  alert(I18NMsg("BOM_Pleaseselectarecord!"));
     return false;
  }
	if(RuleGrid.getRowColData(rowNo-1,4)=="新建")
	{
		 alert(I18NMsg("BOM_Thisrecordhasnotbeensendtoaudit!Pleaseselectagain"));
		 return false;
		 
	}else if(RuleGrid.getRowColData(rowNo-1,4)=="已审核通过"){
		alert(I18NMsg("BOM_Thisrecordhasbeenauditapproved!Pleaseselectagain"));
		return false;
	}else if(RuleGrid.getRowColData(rowNo-1,4)=="审核未通过")
	{
		 alert(I18NMsg("BOM_Thisrecordhasbeenauditrejected!Pleaseselectagain"));
		 return false;
	}
  
	return true;
}

//提交表单fm
function submitfm(){
	if (!beforeSubmit())
		return;
    var i = 0;
    var showStr=I18NMsg("Saving,pleasedonoteditanyinformationorlinktootherscreen");
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
    urlStr=encodeURI(encodeURI(urlStr));
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    if (fm.hideOperate.value==""){
        alert(I18NMsg("C_Missingoperationtype,pleaseresubmittheoperation!"));
        return false;
    }
    RuleGrid.delBlankLine();
    fm.submit(); //提交
    //fm.hideOperate.value="";
    fm.all('Reason').value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){

        /*
         fm.all('BaseCode').value = arrQueryResult[0][0];
         fm.all('Name').value = arrQueryResult[0][1];
         fm.all('BranchType').value = arrQueryResult[0][2];
         fm.all('Status').value = arrQueryResult[0][3];
        */
        showCodeName();
        //查询MulLine
        easyQueryRuleGrid();
    }
    return true;
}
function getQueryResult(){
    var arrSelected = null;
    var rowNo = RuleGrid.getSelNo();
    if( rowNo == 0 || rowNo == null )
        return arrSelected;
    //var rowData = RuleGrid.getRowData(rowNo-1); //这是被选中的那行数据，返回这个数组应该会更方便       
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