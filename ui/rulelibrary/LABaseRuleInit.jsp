<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
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
%>
function initInpBox()
{ 
  try
  {      
                        
    fm.all('RuleCode').value = '';
    fm.all('RuleName').value = '';      
    fm.all('BranchType').value = '';
    fm.all('BranchTypeName').value = '';
    //fm.all('Remark').value = '';   
    fm.all('Status').value = '';
    fm.all('hideStatus').value = '01';
    showOneCodeName('status', 'Status', 'StatusName');
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
	    alert('<%=bundle.getString("BOM_Nodatafittingfortheenquiryconditions")%>');
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
		return arrSelected;
	}
	
	

</script>
