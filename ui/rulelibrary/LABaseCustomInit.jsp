<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
//程序名称：LABankTree.jsp
//程序功能：
//创建日期：2004-03-31 15:39:06
//创建人  ：CrtHtml程序创建
//更新记录：  更新人    更新日期     更新原因/内容
%>
<SCRIPT src="../common/javascript/Common.js"></SCRIPT>
                          

<script language="JavaScript">
<%
String basecode=request.getParameter("basecode");
basecode=ESAPI.encoder().encodeForJavaScript(basecode);
System.out.println("ddddddddddddddddddddddddddddddddddddd"+basecode);
%>
function initInpBox()
{ 
  try
  {      
                        
    fm.all('RuleCode').value = '';
    fm.all('RuleName').value = '';      
    fm.all('BranchType').value = '';
    fm.all('BranchTypeName').value = '';
    fm.all('Remark').value = '';   
    fm.all('Status').value = '01';
    //fm.all('hideStatus').value = '01';
   // showOneCodeName('status', 'Status', 'StatusName');
    fm.BranchType.disabled = false;
  }
  catch(ex)
  {
	  alert("LABaseRuleInit.jsp-->initInpBox"+I18NMsg('Alert_InitJspError'));
  }      
}


function initForm()
{
  try
  {
    initInpBox();       
  }
  catch(re)
  {
	  alert("LABaseRuleInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
  }
}

	function updatedata()
	{
		var basecode="<%=basecode%>";
		var arrSelected = null;
		
		
		arrSelected = new Array();
		
		var strSQL = "";
		strSQL = "select BaseCode,Name,BranchType,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),Remark,status  from LRBase where 1=1"
			+"and BaseCode='"+basecode+"'" ;
		
		turnPage.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);  
	  //判断是否查询成功
	  if (!turnPage.strQueryResult) {
	    alert("没有查询到数据！");
	    return false;
	    }
	//查询成功则拆分字符串，返回二维数组

	    arrSelected = decodeEasyQueryResult(turnPage.strQueryResult);
	    fm.all('RuleCode').value = arrSelected[0][0];
	    fm.all('RuleName').value = arrSelected[0][1];
	    fm.all('BranchType').value = arrSelected[0][2];
	    fm.all('BranchTypeName').value = arrSelected[0][3];
	    fm.all('Remark').value = arrSelected[0][4];
	    fm.all('Status').value =arrSelected[0][5];
	  
	   showTree(basecode);
		return arrSelected;
		
	}
	function showTree(basecode) {
		
		
		fm.BaseCode.value = basecode;
		//fm.State.value = AgentGrid.getRowColData(tRow - 1, 8);
		fm.HideBranchType.value =fm.all('BranchType').value;
		document.getElementById('tree').style.display = "";
		document.getElementById('detail').style.display = "none";
		// document.getElementById('frame').style.display="";
		var settingMenu = {
			checkable : false,
			async : true,
			keepParent : true,
			keepLeaf : true,
			editable : false,
			edit_renameBtn : false,
			edit_removeBtn : false,
			open : true,
			asyncUrl : 'LAIndexDefLoad.jsp', // 获取节点数据的URL地址
			asyncParam : [ "code", "type", "indextype", "agentgrade" ], // 获取节点数据时，必须的数据名称，例如：id、name
			asyncParamOther : [ "tree", "menu", "basecode", fm.BaseCode.value ], 
			callback : {
				beforeClick : zTreeBeforeClick,
				click : zTreeOnClick
//				beforeRightClick:zTreeBeforeRightClick,
//				rightClick:zTreeOnRightClick
				// confirmRename:zTPackageconfirmRename,
				// beforeRemove:zTPackagebeforeRemove,
//				asyncSuccess : function(event, treeId, treeNode, msg) {
//				}
			}
		};
		refreshTreeMenu(settingMenu, zNodesMenu);
		$("#container").show();
	}
	

</script>
