/**
 * 
 */
var zTMenu;
var settingMenu;
var zNodesMenu =[];
var currNode ; 
var BaseCode="";

$(function() {

	/************** 树控件 *************/
	settingMenu = {    
		checkable: false,
		async: true,
		keepParent: true,
		keepLeaf: true,
		editable: true,
		edit_renameBtn: false,
		edit_removeBtn: false,
		open : true,
		asyncUrl: getAsyncUrl,  			//获取节点数据的URL地址
		asyncParam: ["code","type","indextype"],    //获取节点数据时，必须的数据名称，例如：id、name
		asyncParamOther: ["tree","menu","basecode",fm.BaseCode.value],          		//其它参数 ( key, value 键值对格式)
		callback:{
			beforeClick: zTreeBeforeClick,
//			click:zTreeOnClick,		
//			confirmRename:zTPackageconfirmRename,
//			beforeRemove:zTPackagebeforeRemove,
			asyncSuccess:	function (event, treeId, treeNode, msg) {}
		}
	};
	refreshTreeMenu(settingMenu, zNodesMenu);
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
				alert("后台发生错误(按Esc键返回编辑之前的状态)！");
				return false;
			}
		});
	}
	 function zTreeBeforeClick(treeId, treeNode){ 	 	  			
		 if(treeNode.code.substring(0,1)=='T')
			 window.open("./LAindex.jsp?IndexType="+treeNode.parentNode.code+"&AgentGrade="+treeNode.code+"&BaseCode="+fm.BaseCode.value+"","_blank"); 
		 if(treeNode.code.substring(0,1)=='W')
			 window.open("./LAindexRule.jsp?IndexType="+treeNode.parentNode.parentNode.code+"&AgentGrade="+treeNode.parentNode.code+"&WageCode="+treeNode.code+"&BaseCode="+fm.BaseCode.value+"","_blank");
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
});

function afterModified(){
	 var currNode = zTMenu.getSelectedNode();
	 zTMenu.reAsyncChildNodes(currNode, "refresh");
	 nodeState(currNode);
	 zTMenu.expandAll(true);
}
function afterOption(){
	 var currNode = zTMenu.getSelectedNode();
	 var parentNode = currNode.parentNode;
	 zTMenu.reAsyncChildNodes(parentNode, "refresh");
	 nodeState(parentNode);
	 zTMenu.expandAll(true);
}

function nodeState(currNode){
	strSQL = "select count(1) from LRIndexVsCommP where indextype='"+currNode.indextype+"' and branchtype = '1' and basecode = '"+fm.BaseCode.value+"' and agentgrade='"+currNode.code+"'";
	sql="select count(1) from LRIndexVsCommP where branchtype ='1' and basecode='"+fm.BaseCode.value+"' and indextype='"+currNode.indextype+"' and indexcode is null and agentgrade='"+currNode.code+"'";
	var strResult1  = easyQueryVer3(strSQL, 1, 0, 1);  
	var strResult2  = easyQueryVer3(sql, 1, 0, 1);  
	//查询成功则拆分字符串，返回二维数组
	var arrDataSet1 = decodeEasyQueryResult(strResult1);
	var arrDataSet2 = decodeEasyQueryResult(strResult2);
	currNode.icon='';
	if(arrDataSet1[0][0]==0)
		currNode.icon='./iCandy/img/oper.png';
	if(arrDataSet2[0][0]>0)
		currNode.icon='./iCandy/img/remove.png';
	zTMenu.updateNode(currNode,true);

	var parentNo = currNode.parentNode;//薪资、考核
	var grandfatherNode = parentNo.parentNode;//基本法
		parentNo.icon='';
	if(currNode.icon=='./iCandy/img/oper.png'){
		parentNo.icon='./iCandy/img/oper.png';
	}
	if(currNode.icon=='./iCandy/img/remove.png'){
		parentNo.icon='./iCandy/img/remove.png';
	}
	zTMenu.updateNode(parentNo,true);
	var node1 = zTMenu.getNodeByParam("code",'01');
	var node2 = zTMenu.getNodeByParam("code",'02');
	grandfatherNode.icon='';
	if(node1.icon=='./iCandy/img/remove.png'||node2.icon=='./iCandy/img/remove.png'){
		grandfatherNode.icon='./iCandy/img/remove.png';
	}else if(node1.icon=='./iCandy/img/oper.png'||node2.icon=='./iCandy/img/oper.png'){
		grandfatherNode.icon='./iCandy/img/oper.png';
	}
	zTMenu.updateNode(grandfatherNode,true);

}