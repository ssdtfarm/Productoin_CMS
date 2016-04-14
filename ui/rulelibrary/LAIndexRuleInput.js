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
        easyQueryRuleGrid();
        fm.IndexCode.value=fm.hideCalCode.value;
        fm.Description.value=fm.hideDescription.value;
        returnParent();
        
    }
}
function itemQuery(){
	easyQueryRuleGrid();
}
var turnPageRuleGrid = new turnPageClass();
function easyQueryRuleGrid(){
    initRuleGrid();
    // 书写SQL语句
    var statement = " ";
    if(fm.IndexType.value=='23'){
    	statement  = " and datatype = 'S' ";
    }
	var strSQL = "select indexCode,indexname,description from LRAssessIndexLibrary a where  state = 'Y' and wagecode='"+fm.all('WageCode').value+"' "+ statement +" and branchtype=(select branchType from lrbase where basecode = '"+fm.BaseCode.value+"') "
	+" and  not exists(select 1 from lrindexvscommp where a.indexcode=indexcode and wagecode=a.wagecode and baseCode='"+fm.all('BaseCode').value+"' and agentgrade='"+fm.all('AgentGrade').value+"' and branchtype=a.branchtype　and　indextype='"+fm.IndexType.value+"') and a.json is not null"
	//+ getWherePart('IndexSerise','IndexSerise')
	+" order by a.indexcode";
	turnPage.strQueryResult  = easyQueryVer3(strSQL, 1, 1, 1);
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPageRuleGrid.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageRuleGrid.strQueryResult) {
    	initRuleGrid();
        //alert(I18NMsg("BOM_Nodatafittingfortheenquiryconditions"));
        return false;
    }
    turnPageRuleGrid.queryModal(strSQL,RuleGrid);
}
//定制参数
function queryPara(){
    fm.hideOperate.value='queryPara';
    if(!verifyForm('fm')){
        return false;
    }
    if(fm.IndexCode.value==null||fm.IndexCode.value==''){
    	alert(I18NMsg("BOM_Thisitemhasnotbeensetrule!"));
    	return false;
    }
    window.open("./editor/indexpara.jsp?BaseCode="+fm.BaseCode.value+"&IndexCode="+fm.IndexCode.value + "&EditMode=para");
    return true;
}
//保存
function saveClick(){
    fm.hideOperate.value='saveClick';
    if(!verifyForm('fm')){
        return false;
    }
    //TODO 处理逻辑放到这里
	var count1 = RuleGrid.getSelNo();// 获取选中的行
	if(count1>0){
	  var calcode = RuleGrid.getRowColData(count1-1,1);
	  fm.hideDescription.value=RuleGrid.getRowColData(count1-1,2);
	  if(calcode!=null && calcode!=''){
	      fm.all('hideCalCode').value = calcode;	      
	  }else{
	    alert(I18NMsg("BOM_Donothavecorrespondingrulealgorithm!"));
	    return false;	
	  }
	}else{
	   alert(I18NMsg("BOM_Pleaseselcetarulealgorithm!"));
	   return false;
	}
    submitfm();
    //fm.hideOperate.value="";
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
    RuleGrid.delBlankLine();
    fm.submit(); //提交
   // fm.hideOperate.value="";
}

function returnParent()
{
	try{
		window.parent.parent.afterOption();
	}
	catch(ex)
	{
//		alert( ""+I18NMsg("G0000028472")+"" + ex );
	}
//	top.close();
		
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边

        /*
         fm.all('BranchType').value = arrQueryResult[0][0];
         fm.all('BaseCode').value = arrQueryResult[0][1];
         fm.all('IndexType').value = arrQueryResult[0][2];
         fm.all('AgentGrade').value = arrQueryResult[0][3];
         fm.all('IndexSerise').value = arrQueryResult[0][4];
         fm.all('IndexCode').value = arrQueryResult[0][5];
        */
        showCodeName();
        //查询MulLine
        easyQueryItemGrid();
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