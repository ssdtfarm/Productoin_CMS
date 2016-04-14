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
//参数规则查看
function editClick(spanid){
	var a;
	
	 a = fm.all(spanid).all('ProGird5').value;
	
	 link="./editor/indexparaR.jsp?EditMode=para&IndexCode="+a;
	showFormPage(link, I18NMsg("C_Ruleandparameterinformation")+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',800,300);
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
			//document.frames('mainframe').location.reload();
		}
	});
	
}
//生成报表
function formprint(){
	
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
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
	 initProGird();
}
var turnPageProGird = new turnPageClass();
function easyQueryProGird(){
	
  initProGird();

  var mySql = new SqlClass();
  mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
  mySql.setSqlId("LRRuleInforInputQuery.js_SearchWage");
  mySql.setValue("p_WageCode", trim(fm.all('WageCode').value));
  mySql.setValue("p_WageName", trim(fm.all('WageName').value));
  mySql.setValue("p_BranchType", trim(fm.all('BranchType').value));
  mySql.setValue("p_IndexCode", trim(fm.all('IndexCode').value));
  mySql.setValue("p_IndexName", trim(fm.all('IndexName').value));
  mySql.setValue("p_WageState", trim(fm.all('State').value));
  mySql.setValue("p_RuleState", trim(fm.all('StateRule').value));
  
  turnPageProGird.pageLineNum = 5;
  turnPageProGird.queryModal(mySql.getString(),ProGird);
}
//0910 单选按钮触发事件
function ruleparam(){
	var rownum = ProGird.getSelNo();
	var rowdata = ProGird.getRowColData(rownum-1,5);
	 var mySql = new SqlClass();
	  mySql.setJspName("../../rulelibrary/RuleManagementSql.jsp");
	  mySql.setSqlId("LRRuleInforInputQuery.js_ruleparam");
	  mySql.setValue("p_indexcode", rowdata);
	  turnPageProGird.strQueryResult = easyQueryVer3(mySql.getString(), 1, 0, 1);
    
	  var arrSelected=new Array();
	  arrSelected = decodeEasyQueryResult(turnPageProGird.strQueryResult);
	  
	  var sql=arrSelected[0][0];
	
	  fm.all("sql").value=sql;
	  
	  
	  //测试规则引擎参数的得到
	  var rowNo = ProGird.getSelNo();
	  
	    if( rowNo == 0 || rowNo == null )        
	   		 {
	    	alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
	   		 	return false;
	   		 	}
	   //	var Data = RuleGird.getRowData(rNo-1);
	    var Data = ProGird.getRowData(rowNo-1);
//	    showInfo=window.open("./editor/index.jsp?WageCode="+rowData[0]+"&IndexCode="+Data[0]);
	   // showInfo=window.open("./editor/indexpara.jsp?EditMode=para&IndexCode="+Data[0]);
	   // return true;
	    
	 $("<frame name='editor' src='../editor/indexR.jsp?EditMode=para&IndexCode="+Data[4]+"'> </frame>").appendTo('p');
	
	
}


function queryAgent(){
 
   fm.hideOperate.value='queryagent';
   if(!verifyForm('fm')){
       return false;
   }
 
   easyQueryProGird();
   
   return true;
}





/********************* 表单：fm *********************/

function editorPara(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    var rowNo = ProGird.getSelNo();
    var rNo = RuleGird.getSelNo();
    if( rowNo == 0 || rowNo == null )        
   		 {
    		alert(I18NMsg("BOM_Pleaseenquiryfirstthenselectarecord!"));
   		 	return false;
   		 	}else if(rNo== 0||rNo==null)  
   		 		{
   		 			
   		 			alert(I18NMsg("BOM_Pleaseselectarecord!"));
   		 			return false;
   		 		} 
   	var Data = RuleGird.getRowData(rNo-1);
    var rowData = ProGird.getRowData(rowNo-1);
//    showInfo=window.open("./editor/index.jsp?WageCode="+rowData[0]+"&IndexCode="+Data[0]);
    showInfo=window.open("./editor/indexpara.jsp?EditMode=para&IndexCode="+Data[0]);
    return true;
}


