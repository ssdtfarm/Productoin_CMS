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
   if (FlagStr == "Fail" ){
   			showInfo.close();   
        var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
        urlStr=encodeURI(encodeURI(urlStr));
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
    }
    else{
    	if(fm.hideOperate.value=='Delete')
        {
        		easyQueryBOMGird();
        		easyQueryTermGird();
        }else if(fm.hideOperate.value=='DeleteTerm')
        {        	
        	easyQueryTermGird();
        }
        showInfo.close();   
        var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + content ;
        urlStr=encodeURI(encodeURI(urlStr));
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
    }
}
function afterReturn( FlagStr, content ){
//    showInfo.close();    
    easyQueryBOMGird();
    easyQueryTermGird();
}
function afterUpdate(FlagStr,content){
   //showInfo.close();    
   //easyQueryBOMGird();
    easyQueryTermGird();
}
/********************* 表单：fm *********************/
var turnPageBOMGird = new turnPageClass();
/**
 * 查询BOM项
 * @returns {Boolean}
 */
function easyQueryBOMGird(){
    initBOMGird();
    initTermGird();
    
    var mySql = new SqlClass();
    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
    mySql.setSqlId("BOMObjectiveManagement_Enquiry");
    mySql.setValue("p_ID", trim(fm.all('ID').value));
    mySql.setValue("p_name", trim(fm.all('Name').value));
    mySql.setValue("p_BranchType", trim(fm.all('BranchType').value));
    mySql.setValue("p_state", trim(fm.all('State').value));
    turnPage.strQueryResult = easyQueryVer3(mySql.getString(), 1, 0, 1);
	if (!turnPage.strQueryResult) {
		alert(I18NMsg("Sorry,cannotfindanyeligiblerecords!"));
		return false;
	}
    turnPageBOMGird.pageLineNum = 5;
    turnPageBOMGird.queryModal(mySql.getString(),BOMGird);
}

var turnPageTermGird = new turnPageClass();
function easyQueryTermGird(){
	
	$("#term").css("display","");
    initTermGird();
    // 书写SQL语句
    var rownum = BOMGird.getSelNo();// 获取选中的行
	if(rownum>0){
		var rowdata = BOMGird.getRowColData(rownum-1,1);// 获取选中行的数据
		
		var mySql = new SqlClass();
	    mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
	    mySql.setSqlId("BOMObjectiveManagement_SearchItem");
	    mySql.setValue("p_bomid", rowdata);
//	    turnPage.strQueryResult = easyQueryVer3(mySql.getString(), 1, 0, 1);
//		if (!turnPage.strQueryResult) {
//			alert(I18NMsg("Sorry,cannotfindanyeligiblerecords!"));
//			return false;
//		}
		
	    turnPageTermGird.pageLineNum = 5;
	    turnPageTermGird.queryModal(mySql.getString(),TermGird);
	}
    
}
//查询
function QueryAgent(){
	//$("#sm").css("dispaly","block");
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='queryagent';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"queryagent")){
    //    return false;
    //} 
    easyQueryBOMGird();
    //easyQueryTermGird();
    //fm.hideOperate.value="";
    return true;
}
//增加
function AddAgent(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
   // window.open("./LRBomAdd.jsp");
	 link="./LRBomAdd.jsp";
		showFormPage4(link, I18NMsg("BOM_BOMinformationadd")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);

	
    return true;
}
//模态弹出框
function showFormPage4(link,title,width,height){
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
		//easyQueryBOMGird();
		}
	});
	
}
//删除
function Delete(spanid){
	
	 //这是测试能不能按照它原来的方式删除，测试结果失败，因为根据spanid得不到行号tangyj
	// eval(this.formName + ".all('Inp" + this.instanceName + "Chk')[" + (rowNo - 1) + "].value=1");
     //eval(this.formName + ".all('" + this.instanceName + "Chk')[" + (rowNo - 1) + "].checked=true");
   //fm.all('BOMGirdSel')[4].checked=true;
    // fm.all('InpBOMGirdSel')[4].value=1;
	 //var id = fm.all(spanid).all('BOMGird1').value;
//下面注释是之前的，需要选中的判断，现在不需要了tangyj
	//var rowNo = BOMGird.getSelNo();
   //if( rowNo == 0 || rowNo == null )        
   		// {
    	//alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		//	return false;
   		 //	} 
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
 //由于不能按之前那种删除方式走，所以修改后台删除和save页面的程序，只传id过去。tangyj20130927
	 var bomid = fm.all(spanid).all('BOMGird1').value;
	 var name = fm.all(spanid).all('BOMGird2').value;

var message=I18NMsg("BOM_SuretodeleteBOM?")+name+"";
//原来是通过sumbit提交，可以将页面的内容提交过去，现在改为js提交，需要传递operator   tangyj
    fm.hideOperate.value='Delete';
    fm.bomid.value=bomid;
    var operator='Delete';
    if(!verifyForm('fm')){
        return false;
    }
    if(!confirm(message)) return false;
    //if (!beforeSubmitVerify(fm,"Delete")){
    //    return false;
    //} 
    //页面提交
    //window.open("./LRBomSave.jsp?bomid="+bomid+"&operator="+operator);
   //原来的方式
     submitfm();
     
    return true;
}
//修改
function UpdateBom(spanid){
	 var id = fm.all(spanid).all('BOMGird1').value;
   
    //if(!confirm("该方法还没有实现，是否继续?")) return false;    
    //var rowNo = BOMGird.getSelNo();
    
   // if( rowNo == 0 || rowNo == null )        
   		 //{
   		 //	alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 //	return false;
   		 //	}   		 	
    //var rowData = BOMGird.getRowData(rowNo-1);
    var name = fm.all(spanid).all('BOMGird2').value;
    var remark = fm.all(spanid).all('BOMGird3').value;
   // window.open("./LRBomUpdate.jsp?id="+rowData[0]+"&name="+rowData[1]+"&remark="+rowData[2]);
    link="./LRBomUpdate.jsp?id="+id+"&name="+name+"&remark="+remark;
	showFormPage(link, I18NMsg("BOM_BOMinformationmodify")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);

   // window.open("./LRBomUpdate.jsp?id="+id+"&name="+name+"&remark="+remark);

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
		easyQueryBOMGird();
		}
	});
	
}



//增加
function AddTerm(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    var rowNo = BOMGird.getSelNo();
    if( rowNo == 0 || rowNo == null )        
   		 {
   		 	alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 	return false;
   		 	}   		 	
    var rowData = BOMGird.getRowData(rowNo-1);
   // showInfo=window.open("./LRTermAdd.jsp?id="+rowData[0]);
    link="./LRTermAdd.jsp?id="+rowData[0];
	showFormPage2(link, I18NMsg("C_Entryinformationaddition")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);
   

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
		//easyQueryBOMGird();
		easyQueryTermGird();
		}
	});
	
}
//删除
function DeleteTerm(spanid){	
	
	var rowNo = BOMGird.getSelNo();	
	//var rNo = TermGird.getSelNo();		
    if( rowNo == 0 || rowNo == null ){
	 	alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
	 	return false;
   	}
    //else if(rNo== 0||rNo==null){
	 //	alert("请选中一条词条数据！");
	 	//return false;
   	//}; 
    var bomid=BOMGird.getRowColData(rowNo-1,1,BOMGird);

 var termid = fm.all(spanid).all('TERMGird1').value;
 fm.bomid.value=bomid;
 fm.termid.value=termid;

    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='DeleteTerm';
    if(!verifyForm('fm')){
        return false;
    }
    var name = fm.all(spanid).all('TERMGird2').value;

    var message=I18NMsg("BOM_Suretodeleteitem?")+name+"";
    if(!confirm( message)) return false;
    //if (!beforeSubmitVerify(fm,"DeleteTerm")){
    //    return false;
    //} 
    submitfm();
    //easyQueryTermGird();    
    //fm.hideOperate.value="";
    return true;
}
//修改
function UpdateTerm(spanid){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;

      var rowNo = BOMGird.getSelNo();
     // var rNo = TermGird.getSelNo();		
    if( rowNo == 0 || rowNo == null )        
   		 {
   		 	alert(I18NMsg("BOM_Pleaseselectarecord!"));
   		 	return false;
   		 	}
  //  else if(rNo == 0 || rNo == null){   		 		  
   		// 	alert("请选择要修改的词条！");
   		 //	return false;
   		// }
    //var Data = TermGird.getRowData(rNo-1);
    var rowData = BOMGird.getRowData(rowNo-1);
 
    var termid=fm.all(spanid).all('TERMGird1').value;
    var name=fm.all(spanid).all('TERMGird2').value;
    var type=fm.all(spanid).all('TERMGird3').value;
    var bomid=BOMGird.getRowColData(rowNo-1,1,BOMGird);
   // showInfo=window.open("./LRTermUpdate.jsp?Termid="+termid+"&name="+name+"&type="+type+"&BomId="+bomid);
    link="./LRTermUpdate.jsp?Termid="+termid+"&name="+name+"&type="+type+"&BomId="+bomid;
	showFormPage1(link, I18NMsg("C_Entryinformationmodify")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);
     art.dialog.close();
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
		//easyQueryBOMGird();
		easyQueryTermGird();
		}
	});
	
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
    BOMGird.delBlankLine();
    TermGird.delBlankLine();
    fm.submit(); //提交
    //fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        /*
         fm.all('ID').value = arrQueryResult[0][0];
         fm.all('Name').value = arrQueryResult[0][1];
        */
        showCodeName();
        //查询MulLine
        easyQueryBOMGird();
        easyQueryTermGird();
    }
    return true;
}
function getQueryResult(){
    var arrSelected = null;
    var rowNo = TermGird.getSelNo();
    if( rowNo == 0 || rowNo == null )
        return arrSelected;
    //var rowData = TermGird.getRowData(rowNo-1); //这是被选中的那行数据，返回这个数组应该会更方便       
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