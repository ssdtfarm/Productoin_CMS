/**
 * 
 */
var zTMenu;
var settingMenu;
var zNodesMenu =[];
var currNode ; 
var BaseCode="";



/************** 树控件 *************/

//refreshTreeMenu(settingMenu, zNodesMenu);
////////////////////////// menu //////////////////////////////////
function refreshTreeMenu(settingMenu, zNodesMenu) {
	zTMenu = $("#menu").zTree(settingMenu, zNodesMenu);
}

function getAsyncUrl(treeNode) {
    var url = "LAIndexDefLoad.jsp";
    return url;
};


 function zTPackagebeforeRemove(treeId, treeNode, newName){
	$.ajax({
		async:false,
		type: "POST",
		url: 'LAIndexDefLoad.jsp',
		cache: false,
		data: {oper:"remove",code:treeNode.code},
		success:function(data){
		//var parentId= treeNode.parent;
		//var node = zTree.getNodeByParam("code", parentId);		
		//zTree.reAsyncChildNodes(null, "refresh");
			return true;
		},
		error:function(data,msg,ex){		
			alert(I18NMsg("BOM_Systemerror(pressESCtoreturntothescreenbeforemodify)!"));
			return false;
		}
	});
}
 function zTreeBeforeClick(treeId, treeNode){ 	
 	 var tmp;
	 if(treeNode.code.substring(0,1)=='W'){//选定规则
		 tmp = "./LAindexRule.jsp?IndexType="+treeNode.parentNode.parentNode.code+"&AgentGrade="+treeNode.parentNode.code+"&WageCode="+treeNode.code+"&BaseCode="+fm.BaseCode.value;
	 }else if(treeNode.code.substring(0,1)=='R'){//参数定制
		 tmp = "./editor/index.jsp?State=04&BaseCode="+fm.BaseCode.value+"&IndexCode="+treeNode.code+"&EditMode=para&AgentGrade="+treeNode.agentgrade;
	 }else if(treeNode.code.substring(0,1)=='2') {
		 $("#detailTarget")[0].src = "";
		 $("#detail").hide();
		 return true;
	 }else if(treeNode.code.substring(0,1)!='0'&&treeNode.indextype=='23'){//项目定制
		 tmp = "./LAindexResult.jsp?IndexType="
			 +treeNode.parentNode.code+"&AgentGrade="
			 +treeNode.code+"&BaseCode="
			 +fm.BaseCode.value+"&BranchType=";
	 }else if(treeNode.code.substring(0,1)!='0'){//项目定制
		 tmp = "./LAindex.jsp?IndexType="+treeNode.parentNode.code+"&AgentGrade="+treeNode.code+"&BaseCode="+fm.BaseCode.value;
	 }else {
		 $("#detailTarget")[0].src = "";
		 $("#detail").hide();
		 return true;
	 }
	 $("#detailTarget")[0].src = tmp;
	 $("#detail").show();
	 return true;
}
 
function zTreeOnClick(event, treeId, treeNode){
}			
$('#info').ajaxStart(function(){
$('#info').dialog({modal:true});
});
$('#info').ajaxStop(function(){
  $('#info').dialog('destroy');
});

$(function(){
	var settingMenu = {    
			checkable: true,
			async: true,
			keepParent: true,
			keepLeaf: true,
			editable: false,
			edit_renameBtn: false,
			edit_removeBtn: false,
			open : true,
			asyncUrl: getAsyncUrl,  			//获取节点数据的URL地址
			asyncParam: ["code","type","indextype","agentgrade"],    //获取节点数据时，必须的数据名称，例如：id、name
			asyncParamOther: ["tree","menu","basecode",fm.BaseCode.value], //其它参数 ( key, value 键值对格式)
			callback:{
				beforeClick: zTreeBeforeClick,
				click:zTreeOnClick,		
				//confirmRename:zTPackageconfirmRename,
				//beforeRemove:zTPackagebeforeRemove,
				asyncSuccess:	function (event, treeId, treeNode, msg) {
//					zTMenu.expandAll(true);
				}
			}
		};
	refreshTreeMenu(settingMenu, zNodesMenu);
});

function afterModified(){
	 var currNode = zTMenu.getSelectedNode();
	 zTMenu.reAsyncChildNodes(currNode, "refresh");
	 nodeState(currNode);
//	 zTMenu.expandAll(true);
}
function afterOption(){
	 var currNode = zTMenu.getSelectedNode();
	 var parentNode = currNode.parentNode;
	 zTMenu.reAsyncChildNodes(parentNode, "refresh");
	 nodeState(parentNode);
//	 zTMenu.expandAll(true);
}

function nodeState(currNode){
	strSQL = "select count(1) from LRIndexVsCommP where indextype='"+currNode.indextype+"' and branchtype = '1' and basecode = '"+fm.BaseCode.value+"' and agentgrade='"+currNode.code+"'";
	sql="select count(1) from LRIndexVsCommP where branchtype ='1' and basecode='"+fm.BaseCode.value+"' and indextype='"+currNode.indextype+"' and indexcode is null and agentgrade='"+currNode.code+"'";
	var strResult1  = easyQueryVer3(strSQL, 1, 0, 1);  
	var strResult2  = easyQueryVer3(sql, 1, 0, 1);  
	//查询成功则拆分字符串，返回二维数组
	var arrDataSet1 = decodeEasyQueryResult(strResult1);
	var arrDataSet2 = decodeEasyQueryResult(strResult2);
	currNode.icon='./iCandy/img/ok.png';
	if(arrDataSet1[0][0]==0)
		currNode.icon='./iCandy/img/oper.png';
	if(arrDataSet2[0][0]>0)
		currNode.icon='./iCandy/img/remove.png';
	zTMenu.updateNode(currNode,true);
}
function afterExp(FlagStr,Content){
	    showInfo.close();
	    if(FlagStr == "Succ"){
	   	 	fm.action="./down.jsp?filePath="+Content;   
	        fm.submit();
	        fm.action="./LAIndexExpSave.jsp";
	    }
}
function BaseExp(){
   var nodes = zTMenu.getCheckedNodes();
   var checkednodes = new Array(); 
   var BaseCode = fm.BaseCode.value;
   var NodeInfo = '';
   for(var i =0; i < nodes.length; i++) {
	   if(nodes[i].code.substring(0,1)=='B'&&nodes[i].check_True_Full == true ){
       		//基本法 basecode
		   	BaseCode = nodes[i].code;
       		checkednodes.push(BaseCode+','+','+','); 
       }else if(nodes[i].code.substring(0,1)=='0'&&nodes[i].check_True_Full == true ){
        	//薪资考核需要 basecode,indextype
        	checkednodes.push(BaseCode+','+nodes[i].code+','+','); 
        }else if(nodes[i].code.substring(0,1)=='T'&&nodes[i].check_True_Full == true ){
        	//职级      需要  basecode,indextype,agentgrade
        	checkednodes.push(BaseCode+','+nodes[i].indextype+','+nodes[i].code+',');
        }else if(nodes[i].code.substring(0,1)=='W'&&nodes[i].check_True_Full == true ){
        	//薪资项 需要basecode,indextype,agentgrade,wagecode
        	checkednodes.push(BaseCode+','+nodes[i].indextype+','+nodes[i].agentgrade+','+nodes[i].code);
        } 
      }
   for(var i=0;i < checkednodes.length; i++){
	   if(NodeInfo!=''){
		   NodeInfo +='|'+checkednodes[i];
	   }else{
		   NodeInfo +=checkednodes[i];
	   }
   }
   fm.NodeInfo.value=NodeInfo;
   var showStr=I18NMsg("Enquiringdata,pleasewaitanddonotedittheinformationonscreenorjumptoanyotherpage");
   var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
   urlStr=encodeURI(encodeURI(urlStr));
   showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
   fm.submit();   
}