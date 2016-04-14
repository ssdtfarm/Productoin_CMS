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
function formprint(){
	
    fm.hideOperate.value='PRINT';
  
    var showStr=I18NMsg("Enquiringdata,pleasewaitanddonotedittheinformationonscreenorjumptoanyotherpage");
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
    urlStr=encodeURI(encodeURI(urlStr));
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    fm.submit();
  
    fm.hideOperate.value="";
    return true;
}                                                                                       
function resetForm(){
	
	fm.reset();
	 initBOMGird();
}

var turnPageBOMGird = new turnPageClass();
function easyQueryBOMGird(){
	
   initBOMGird();
   var mySql = new SqlClass();
   mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
   mySql.setSqlId("LRBomInputQuery.js_SearchBOM");
   mySql.setValue("p_ID", trim(fm.all('ID').value));
   mySql.setValue("p_name", trim(fm.all('Name').value));
   mySql.setValue("p_BranchType", trim(fm.all('BranchType').value));
   mySql.setValue("p_state", trim(fm.all('State').value));
   mySql.setValue("p_IDTerm", trim(fm.all('IDTerm').value));
   mySql.setValue("p_NameTerm", trim(fm.all('NameTerm').value));
   mySql.setValue("p_StateTerm", trim(fm.all('StateTerm').value));
   
   turnPageBOMGird.strQueryResult = easyQueryVer3(mySql.getString(), 1, 0, 1);
   if(!turnPageBOMGird.strQueryResult){
	   alert(I18NMsg("Sorry,cannotfindanyeligiblerecords!"));
   }
   turnPageBOMGird.pageLineNum = 5;
   turnPageBOMGird.queryModal(mySql.getString(),BOMGird);
}
function easytermsql(){
	var rownum = BOMGird.getSelNo();
	var rowdata = BOMGird.getRowColData(rownum-1,5);
	
   var mySql = new SqlClass();
   mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
   mySql.setSqlId("LRBomInputQuery.js_SearchItem");
   mySql.setValue("p_id", rowdata);
   turnPageBOMGird.strQueryResult = easyQueryVer3(mySql.getString(), 1, 0, 1);

   var arrSelected=new Array();
   arrSelected = decodeEasyQueryResult(turnPageBOMGird.strQueryResult);
   var sql=arrSelected[0][0];
  fm.all("sql").value=sql;
	
}


function QueryAgent(){
	
	  fm.sql.value='';
    fm.hideOperate.value='queryagent';
    if(!verifyForm('fm')){
        return false;
    }
  
    easyQueryBOMGird();
    
    return true;
}


