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
function afterReturn( FlagStr, content ){	
	easyQueryProGird();
    easyQueryRuleGird();
}
function updateReturn( FlagStr, content ){	
    easyQueryRuleGird();
}
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
        if(fm.hideOperate.value=="DeleteRule")
        { 
    				easyQueryRuleGird();
        	}else{        		
    			easyQueryProGird();
    			easyQueryRuleGird();}
    }
}
/********************* 表单：fm *********************/
var turnPageProGird = new turnPageClass();
function easyQueryProGird(){
    initProGird();
    initRuleGird();
    var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LRRuleInforInput.js_SearchWage");
    mySql.setValue("p_WageCode", trim(fm.WageCode.value));
    mySql.setValue("p_WageName", trim(fm.all('WageName').value));
    mySql.setValue("p_WageType", trim(fm.all('WageType').value));
    mySql.setValue("p_BranchType", trim(fm.all('BranchType').value));
    mySql.setValue("p_State", trim(fm.State.value));
    turnPageProGird.pageLineNum = 5;
    turnPageProGird.queryModal(mySql.getString(),ProGird);
}

var turnPageRuleGird = new turnPageClass();
function easyQueryRuleGird(){
	$("#rule").css("display","");
    initRuleGird();
    // 书写SQL语句
    //var tReturn = getManageComLimitlike("managecom");    
    var rownum = ProGird.getSelNo();// 获取选中的行
	if(rownum>0){
	var rowdata = ProGird.getRowColData(rownum-1,1);// 获取选中行的数据
    
    var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("LRRuleInforInput.js_SearchRule");
    mySql.setValue("p_WageCode", rowdata);
    
    turnPageRuleGird.pageLineNum = 5;
    turnPageRuleGird.queryModal(mySql.getString(),RuleGird);
    }
}


//查询
function QueryTerm(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='queryagent';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"queryagent")){
    //    return false;
    //} 
    easyQueryProGird();
    //easyQueryRuleGird();
    fm.hideOperate.value="";
    return true;
}
//增加

function Add(){
   
	 link="./LRProAdd.jsp";
		showFormPage(link, I18NMsg("C_Itemaddition")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);

	
    return true;
}
//模态弹出框
function showFormPage(link,title,width,height){
	if(width==null){
		width = "auto";
		height="auto";
	}
	art.dialog.open(link, {
		title: title,
		// background: '#600', // 背景色 
		opacity: 0.20,	// 透明度
		button: [
					{name: I18NMsg("C_Back"),
						callback: function () {
							return true;
						}	,
						focus: true

					}],
		//lock: true,
		width:width,
		height:height,
		close:function (){
		//easyQueryProGird();
		}
	});
	
}
//删除
function Delete(spanid){	
	//tangyj0927
	var wagecode=fm.all(spanid).all('ProGird1').value;
	fm.wagecode.value=wagecode;
	
    fm.hideOperate.value='Delete';  
    
	//var rowNo = ProGird.getSelNo();
   // if( rowNo == 0 || rowNo == null ){
   		// 	alert("请查询并选中一条数据！");
   		// 	return false;
   // }   		 	
    if(!verifyForm('fm')){
        return false;
    }
    var name = fm.all(spanid).all('ProGird2').value;

    var message=I18NMsg("BOM_Comfirmtodeleteitem:")+name+"";
    if(!confirm(message)) return false;
    //if (!beforeSubmitVerify(fm,"Delete")){
    //    return false;
    //} 
    submitfm();    
    easyQueryProGird();
    easyQueryRuleGird();
    //fm.hideOperate.value="";
    return true;
}
//修改
function UpdateAgent(spanid){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    //var rowNo = ProGird.getSelNo();
    //if( rowNo == 0 || rowNo == null )        
   		 //{
   		 //	alert("请查询并选中一条数据！");
   		 	//return false;
   		 	//}    		 	
    //var rowData = ProGird.getRowData(rowNo-1);
	var wagecode=fm.all(spanid).all('ProGird1').value;
    //showInfo=window.open("./LRProUpdate.jsp?id="+rowData[0]);
    //showInfo=window.open("./LRProUpdate.jsp?id="+wagecode);
     var link="./LRProUpdate.jsp?id="+wagecode;
		showFormPage1(link, I18NMsg("BOM_Itemmodify")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);

    return true;
}
//模态弹出框
function showFormPage1(link,title,width,height){
	if(width==null){
		width = "auto";
		height="auto";
	}
	art.dialog.open(link, {
		title: title,
		// background: '#600', // 背景色 
		opacity: 0.20,	// 透明度
		button: [
					{name: I18NMsg("C_Back"),
						callback: function () {
							return true;
						}	,
						focus: true

					}],
		//lock: true,
		width:width,
		height:height,
		close:function (){
		easyQueryProGird();
		}
	});
	
}
//增加
function AddRule(){
	  var rowNo = ProGird.getSelNo();
    if( rowNo == 0 || rowNo == null )        
   		 {
   		 	alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 	return false;
   		 	}
   		 	var rowData = ProGird.getRowData(rowNo-1);   		 	
    //window.open("./LRRuleAdd.jsp?WageCode="+rowData[0]);
    var link="./LRRuleAdd.jsp?WageCode="+rowData[0];
	showFormPage2(link, I18NMsg("C_Ruleaddition")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);

    return true;
}
//模态弹出框
function showFormPage2(link,title,width,height){
	if(width==null){
		width = "auto";
		height="auto";
	}
	art.dialog.open(link, {
		title: title,
		// background: '#600', // 背景色 
		opacity: 0.20,	// 透明度
		button: [
					{name: I18NMsg("C_Back"),
						callback: function () {
							return true;
						}	,
						focus: true

					}],
		//lock: true,
		width:width,
		height:height,
		close:function (){
		easyQueryRuleGird();
		}
	});
	
}
//删除
function DeleteRule(spanid){
	

    fm.hideOperate.value='DeleteRule';
    var rowNo = ProGird.getSelNo();
    //var rNo = RuleGird.getSelNo();
    
  //tangyj0927增加
	var indexcode=fm.all(spanid).all('RuleGird1').value;
    var wagecode=ProGird.getRowColData(rowNo-1,1,ProGird);
     fm.wagecode.value=wagecode;
     fm.indexcode.value=indexcode;
    if( rowNo == 0 || rowNo == null )        
   		 {
    	alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 	return false;
   		 	}
    //else if(rNo== 0||rNo==null)  
   		 	//	{
   		 			
   		 		//	alert("请选中一条规则！");
   		 		//	return false;
   		 		//}
    if(!verifyForm('fm')){
        return false;
    }
    var name = fm.all(spanid).all('RuleGird2').value;

    var message=I18NMsg("BOM_Suretodelete?")+name+"";
    if(!confirm(message)) return false;
    //if (!beforeSubmitVerify(fm,"Delete")){
    //    return false;
    //} 
    submitfm();
    //fm.hideOperate.value="";
    return true;
}
//修改
function UpdateRule(spanid){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
     var rowNo = ProGird.getSelNo();
   // var rNo = RuleGird.getSelNo();
    if( rowNo == 0 || rowNo == null )        
   		 {
    		alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 	return false;
   		 	}
    //else if(rNo== 0||rNo==null)  
   		 		//{
   		 			
   		 			//alert("请选中一条规则！");
   		 			//return false;
   		 		//} 
   	//var Data = RuleGird.getRowData(rNo-1);
    //var rowData = ProGird.getRowData(rowNo-1);
    //927替换
    var indexcode=fm.all(spanid).all('RuleGird1').value;
    var wagecode=ProGird.getRowColData(rowNo-1,1,ProGird);
    //showInfo=window.open("./LRRuleUpdate.jsp?WageCode="+wagecode+"&IndexCode="+indexcode);
    var link="./LRRuleUpdate.jsp?WageCode="+wagecode+"&IndexCode="+indexcode;
    showFormPage3(link, I18NMsg("C_Rulemodify")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);

    return true;
}


//模态弹出框
function showFormPage3(link,title,width,height){
if(width==null){
	width = "auto";
	height="auto";
}
art.dialog.open(link, {
	title: title,
	// background: '#600', // 背景色 
	opacity: 0.20,	// 透明度
	button: [
				{name: I18NMsg("C_Back"),
					callback: function () {
						return true;
					}	,
					focus: true

				}],
	//lock: true,
	width:width,
	height:height,
	close:function (){
	easyQueryRuleGird();
	}
});

}
//修改
function editorRule(spanid){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
     var rowNo = ProGird.getSelNo();
   // var rNo = RuleGird.getSelNo();
    if( rowNo == 0 || rowNo == null )        
   		 {
    		alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 	return false;
   		 	}
    //else if(rNo== 0||rNo==null)  
   		 		//{
   		 		//	
   		 			//alert("请选中一条规则！");
   		 			//return false;
   		 		//} 
   //	var Data = RuleGird.getRowData(rNo-1);
   // var rowData = ProGird.getRowData(rowNo-1);
  //927替换
    var indexcode=fm.all(spanid).all('RuleGird1').value;
    var wagecode=ProGird.getRowColData(rowNo-1,1,ProGird);
    //showInfo=window.open("./editor/index.jsp?WageCode="+rowData[0]+"&IndexCode="+Data[0]);
    showInfo=window.open("./editor/index.jsp?WageCode="+wagecode+"&IndexCode="+indexcode);

    return true;
}


function editorPara(spanid){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    var rowNo = ProGird.getSelNo();
    //var rNo = RuleGird.getSelNo();
    if( rowNo == 0 || rowNo == null )        
   		 {
    	alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 	return false;
   		 	}
    //else if(rNo== 0||rNo==null)  
   		 		//{
   		 			
   		 		//	alert("请选中一条规则！");
   		 			//return false;
   		 		//} 
   //	var Data = RuleGird.getRowData(rNo-1);
  //  var rowData = ProGird.getRowData(rowNo-1);
  //927替换
    var indexcode=fm.all(spanid).all('RuleGird1').value;
//    showInfo=window.open("./editor/index.jsp?WageCode="+rowData[0]+"&IndexCode="+Data[0]);
    showInfo=window.open("./editor/indexpara.jsp?EditMode=para&IndexCode="+indexcode);
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
    //fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
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