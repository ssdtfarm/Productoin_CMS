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
    easyQueryIndexGrid();
    returnParent();
}
/********************* 表单：fm *********************/
var turnPageIndexGrid = new turnPageClass();
function easyQueryIndexGrid(){
    initIndexGrid();
    // 书写SQL语句
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = "select wagename,wagecode from LRIndexVsCommP a where branchtype =(select branchType from lrbase where basecode = '"+fm.BaseCode.value+"') and basecode='"+fm.BaseCode.value+"' and agentgrade='"+fm.AgentGrade.value+"' and indextype='"+fm.IndexType.value+"'"
        + getWherePart('IndexSerise','IndexSerise')
        +"order by wageorder asc";
    var strSQLexcel= strSQL;
    fm.tSQL.value=strSQL;
    turnPageIndexGrid.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageIndexGrid.strQueryResult && fm.hideOperate.value=='query') {
    	initIndexGrid()
        return false;
    }
    turnPageIndexGrid.queryModal(strSQL,IndexGrid);
}
var turnPageRuleGrid = new turnPageClass();
function easyQueryRuleGrid(){
    initRuleGrid();
    // 书写SQL语句
    var statement =  getWherePart('wagetype','IndexType');
    if(fm.IndexType.value=='21'||fm.IndexType.value=='22'||fm.IndexType.value=='23'){
    	statement = " and wagetype = '02' "
    }
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = "select wagename,wagecode from LRIndex a where state = 'Y' and  branchtype =(select branchType from lrbase where basecode = '"+fm.BaseCode.value+"')  and not exists (select 1 from LRIndexVsCommP "
	       +"where branchtype=a.branchtype  and wagecode=a.wagecode and agentgrade='"+fm.AgentGrade.value+"' and basecode='"+fm.BaseCode.value+"' and indextype='"+fm.IndexType.value+"') "
	       + getWherePart('IndexSerise','IndexSerise')
	       + statement
	       +"order by wagecode";
    var strSQLexcel= strSQL;
    fm.tSQL.value=strSQL;
    turnPageRuleGrid.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageRuleGrid.strQueryResult && fm.hideOperate.value=='query') {
    	initRuleGrid();
        return false;
    }
    turnPageRuleGrid.queryModal(strSQL,RuleGrid);
    
}

function returnParent()
{	
	try{
		window.parent.parent.afterModified();
	}
	catch(ex)
	{
	}
}

//查 询
function queryClick(){
    fm.hideOperate.value='query';
    if(!verifyForm('fm')){
        return false;
    }

    //TODO 这里一般会调用上边的easyQuery方法，请选择下边一个合适的方法
    easyQueryRuleGrid();
    easyQueryIndexGrid();
    //fm.hideOperate.value="";
    return true;
}
//规则定制
function IndexRule(){
	location.href="./LAIndexRuleInput.jsp?BranchType='"+fm.BranchType.value+"'&BaseCode='"+fm.BaseCode.value+"'&IndexType='"+fm.IndexType.value+"'&AgentGrade='"+fm.AgentGrade.value+"'&BranchTypeName='"+fm.BranchTypeName.value+"'&BaseVersionName='"+fm.BaseVersionName.value+"'&IndexTypeName='"+fm.IndexTypeName.value+"'&AgentGradeName='"+fm.AgentGradeName .value+"'";
    return true;
}
//>
function removeClick(){
    fm.hideOperate.value='remove';
    if(!verifyForm('fm')){
        return false;
    }
    //TODO 处理逻辑放到这里
    var count=IndexGrid.mulLineCount;
    if(count==0){
    	alert(I18NMsg("Pleaseselectrecordfrom'Listaboutitemtitlehas'"));
        return false;
    }
    for(var i=0;i<count;i++)
    {
	    var rowNo = IndexGrid.getChkNo(i);
    	if(rowNo== true)
    	{
    		break;
    	}
	   if(i==count-1 &&  rowNo == false)
	    { 
		  	alert(I18NMsg("Pleaseselectrecordfrom'Listaboutitemtitlehas'"));
	        return false;
	    }
    }
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//<
function addClick(){
    fm.hideOperate.value='add';
    if(!verifyForm('fm')){
        return false;
    }

    //TODO 处理逻辑放到这里
    var count=RuleGrid.mulLineCount;
    if(count==0){
    	alert(I18NMsg("Pleaseselectrecordfrom'Listaboutitemtitledoesnothave'"));
        return false;
    }
    for(var i=0;i<count;i++)
    {
	    var rowNo = RuleGrid.getChkNo(i);
    	if(rowNo== true)
    	{
    		break;
    	}
	   if(i==count-1 &&  rowNo == false)
	    {
		  	alert(I18NMsg("Pleaseselectrecordfrom'Listaboutitemtitledoesnothave'"));
	        return false;
	    }
    }
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
    IndexGrid.delBlankLine();
    RuleGrid.delBlankLine();
    fm.submit(); //提交
    //fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边
        /*
         fm.all('BranchType').value = arrQueryResult[0][0];
         fm.all('BaseCode').value = arrQueryResult[0][1];
         fm.all('IndexSerise').value = arrQueryResult[0][2];
         fm.all('AgentGrade').value = arrQueryResult[0][3];
        */
        showCodeName();
        //查询MulLine
        easyQueryIndexGrid();
        easyQueryRuleGrid();
    }
    return true;
}