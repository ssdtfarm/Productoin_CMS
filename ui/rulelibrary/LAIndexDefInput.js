/**
 * 
 */
var zTMenu;
var settingMenu;
var zNodesMenu =[];
var currNode ; 
var BaseCode="";
var indexType;

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
			alert("Background error occurred (Press Esc to return to the state before editing)!");
			return false;
		}
	});
}
 function zTreeBeforeClick(treeId, treeNode){
 	 var tmp;
	 if(treeNode.code.substring(0,1)=='W'){//选定规则
		 tmp = "./LAindexRule.jsp?IndexType="+treeNode.parentNode.parentNode.code+"&AgentGrade="+treeNode.parentNode.code+"&WageCode="+treeNode.code+"&BaseCode="+fm.BaseCode.value;
	 }else if(treeNode.code.substring(0,1)=='R'){//参数定制
		 tmp = "./editor/index.jsp?IndexType="+treeNode.indextype+"&State="+fm.State.value+"&BaseCode="+fm.BaseCode.value+"&IndexCode="+treeNode.code+"&EditMode=para&AgentGrade="+treeNode.agentgrade;
	 }else if(treeNode.code.substring(0,1)=='2') {
		 $("#detailTarget")[0].src = "";
		 $("#detail").hide();
		 return true;
	 }else if(treeNode.code.substring(0,1)!='0'&&treeNode.indextype=='23'){//项目定制
		 tmp = "./LAindexResult.jsp?IndexType="+treeNode.indextype+"&AgentGrade="+treeNode.code+"&BaseCode="+fm.BaseCode.value+"&BranchType="+fm.HideBranchType.value;

	//by fengfei 2014-9-28 CCMB职级编码也是以B开头，也是6位，所以在此判断过不去
	// 修改判断
//	 } else if(treeNode.code.substring(0,1)!='0'&&treeNode.code.substring(0,1)!='B'){//加入对根节点的特殊处理tangyj20130917
	 } else if(treeNode.code.substring(0,1)!='0'&&treeNode.code.substring(0,2)!='B0'){
		 //else if(treeNode.code.substring(0,1)!='0'){//项目定制
		 tmp = "./LAindex.jsp?IndexType="+treeNode.indextype+"&AgentGrade="+treeNode.code+"&BaseCode="+fm.BaseCode.value;
	 }else{
		 $("#detailTarget")[0].src = "";
		 $("#detail").hide();
		 return true;
	 }
	 $("#detailTarget")[0].src = tmp;
	 $("#detail").show();
	 return true;
}

 function zTreeOnRightClick(event, treeId, treeNode) {
	 currNode = treeNode;
	 showRMenu("node", event.clientX, event.clientY);
}
 
 function showRMenu(type, x, y) {
		$("#rMenu").show();
		if (type=="root") {
			$("#m_del").hide();
			$("#m_check").hide();
			$("#m_unCheck").hide();
		}
		$("#rMenu").css({"top":y+"px", "left":x+"px", "visibility":"visible"});
	}
 
 function zTreeBeforeRightClick(treeId, treeNode) {
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
			checkable: false,
			async: true,
			keepParent: true,
			keepLeaf: true,
			editable: false,
			edit_renameBtn: true,
			edit_removeBtn: true,
			open : true,
			asyncUrl: getAsyncUrl,  			//获取节点数据的URL地址
			asyncParam: ["code","type","indextype","agentgrade"],    //获取节点数据时，必须的数据名称，例如：id、name
			asyncParamOther: ["tree","menu","basecode",fm.BaseCode.value], //其它参数 ( key, value 键值对格式)
			callback:{
				beforeClick:zTreeBeforeClick,
				click:zTreeOnClick,		
				beforeRightClick:zTreeBeforeRightClick,
				rightClick:zTreeOnRightClick
				//confirmRename:zTPackageconfirmRename,
				//beforeRemove:zTPackagebeforeRemove,
				//asyncSuccess:function (event, treeId, treeNode, msg) {
				//zTMenu.expandAll(true);
				//}
			}
		};
	var rMenu = document.getElementById("rMenu");
	$("body").bind("mousedown", 
		function(event){
			if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
				rMenu.style.visibility = "hidden";
			}
		});
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
	strSQL = "select isnull(min(case when indexcode is null then 1 else -1 end),0) from LRIndexVsCommP where indextype='"+currNode.indextype+"' and basecode = '"+fm.BaseCode.value+"' and agentgrade='"+currNode.code+"'";
	var strResult1  = easyQueryVer3(strSQL, 1, 0, 1);  
	//查询成功则拆分字符串，返回二维数组
	var arrDataSet1 = decodeEasyQueryResult(strResult1);
	currNode.icon='./iCandy/img/ok.png';
	if(arrDataSet1[0][0]==0)
		currNode.icon='./iCandy/img/oper.png';
	if(arrDataSet1[0][0]>0)
		currNode.icon='./iCandy/img/remove.png';
	zTMenu.updateNode(currNode,true);
}
