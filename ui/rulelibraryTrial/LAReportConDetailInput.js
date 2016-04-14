var showInfo;
var turnPage = new turnPageClass();
var passReport;//用于保存查询以往报表返回过来的ID
var flag;//当前是否查询以往报表的标志
window.onfocus=function (){
    if(showInfo!=null){
        try{
            showInfo.focus();
        }catch(ex){
            //showInfo=null;
        }
    }
};


/********************* 表单：fm *********************/
var turnPageBOMGird = new turnPageClass();
function easyQueryBOMGird(){
	
	initBOMGird();
	// 书写SQL语句
    var tReturn = getManageComLimitlike("a.managecom");
    var strSQL = "";
    if(fm.ReportType.value=='01'){
    	sqlPart += ",''";
    }else{
    	sqlPart +=",(select s from lrindexinfo_test  where basecode = a.basecode    and indextype = '23' and wageno = a.wageno  and agentcode = a.agentcode  and mainindexflag = 'Y')";
    }
    	
	strSQL = "select "+sqlPart+" from lrindexinfo_test a,laagent b,latree c where 1=1  and a.agentcode=b.agentcode " + " and a.agentcode=c.AgentCode and basecode='"+fm.BaseVersion.value+"' and mainindexflag = 'Y' "
	+ tReturn
	+ getWherePart('a.managecom','ManageCom','like')
	+ getWherePart('a.branchtype','BranchType')
	+ getWherePart('a.AgentCode','AgentCode')
	+ getWherePart('a.WageNo','WageNo')
	+ getWherePart('a.AgentGrade','AgentGrade')
	+ getWherePart('a.indextype','ReportType')
	+ " group by a.wageno,a.agentcode,b.agentcode,c.agentgrade,isnull(b.SurName,'')+' '+isnull(b.GivenName,'')+' '+isnull(b.EnglishName,''),a.managecom,a.basecode,a.indextype order by a.wageno,a.managecom,c.agentgrade,a.agentcode ";
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    
    //turnPageBOMGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
    turnPageBOMGird.pageLineNum = 10;
    turnPageBOMGird.queryModal(strSQL,BOMGird);
    //判断是否查询成功
    sqlPart = " distinct(a.agentcode),isnull(b.SurName,'')+' '+isnull(b.GivenName,'')+' '+isnull(b.EnglishName,''),c.agentgrade,a.WageNo,'','',a.ManageCom,a.BaseCode,(case when indextype='01' then 'Compensation'  when indextype = '21' then 'Maintain Assessment' when indextype ='22' then 'Promotion Assessment' else 'Assessment Result' end)";
    document.getElementById('divresult').style.display="";    
}//function easyQueryBOMGird

// 提交后操作,服务器数据返回后执行的操作
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
        //easyQueryClick();
        easyQuerySelectedIndex();
    }
}
// 提交表单fm
function submitfm(){
    var i = 0;
    var showStr=I18NMsg("Enquiringdata,pleasewaitanddonotedittheinformationonscreenorjumptoanyotherpage");
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
    urlStr=encodeURI(encodeURI(urlStr));
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    if (fm.hideOperate.value==""){
        //alert("操作控制数据丢失！");
        return false;
    }
    SelectedIndex.delBlankLine();
    // AvailableIndex.delBlankLine();
    fm.submit(); // 提交
    fm.hideOperate.value="";
}

function myShowCodeList(obj1,obj2){
	var branchtype = fm.BranchType.value.trim();
	if(branchtype==null||branchtype==''){
		alert(I18NMsg("BOM_Pleaseselect'channelinformation'!"));
		return false;
	}
	var tsql= "#1# and branchtype=#"+branchtype+"#";
	showCodeList('agentgrade',[obj1,obj2],[0,1],null,tsql,'1',1);
	

}


function myShowCodeListKey(obj1,obj2){
	var branchtype = fm.BranchType.value;
	if(branchtype==null||branchtype==''){
		alert(I18NMsg("BOM_Pleaseselect'channelinformation'!"));
		return false;
	}
	var tsql= "#1# and branchtype=#"+branchtype+"#";
	showCodeListKey('agentgrade',[obj1,obj2],[0,1],null,tsql,'1',1);
	}

function myShowCodeList1(obj1,obj2){
	var branchtype = fm.BranchType.value.trim();
	if(branchtype==null||branchtype==''){
		alert(I18NMsg("BOM_Pleaseselect'channelinformation'!"));
		return false;
	}
	var tsql= "#1# and branchtype=#"+branchtype+"#";
	showCodeList('baseversion3',[obj1,obj2],[0,1],null,tsql,'1',1);
}

function myShowCodeListKey1(obj1,obj2){
	var branchtype = fm.BranchType.value;
	if(branchtype==null||branchtype==''){
		alert(I18NMsg("BOM_Pleaseselect'channelinformation'!"));
		return false;
	}
	var tsql= "#1# and branchtype=#"+branchtype+"#";
	showCodeListKey('baseversion3',[obj1,obj2],[0,1],null,tsql,'1',1);
}

function afterCodeSelect(strCodeName,Field){
	if(strCodeName=='BranchType'){
		fm.BaseVersion.value = "";
	}
}

