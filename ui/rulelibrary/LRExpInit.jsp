<%@include file="../common/jsp/UsrCheck.jsp"%>

<%
//程序名称：LABankTreeQueryInit.jsp
//程序功能：
//创建日期：2004-04-1 15:31:09
//创建人  ：CrtHtml程序创建
//更新记录：  更新人    更新日期     更新原因/内容
%>
<%
     //添加页面控件的初始化。
%>                            
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="/i18n/language.jsp"%>
<script language="JavaScript">

// 输入框的初始化（单记录部分）
function initInpBox()
{ 

  try
  {      
    fm.all('RuleCode').value = '';
    fm.all('RuleName').value = '';
    fm.all('Status').value = '04';
    fm.all('StatusName').value = 'Published';
    fm.all('BranchType').value = '';
    fm.all('BranchTypeName').value = '';
  }
  catch(ex)
  {
	  alert("LABaseRuleQueryInit.jsp-->initInpBox"+I18NMsg('Alert_InitJspError'));
  }      
}
function initForm()
{
  try
  {
    initInpBox();    
    initAgentGrid();
//     easyQueryClick();
  }
  catch(re)
  {
	  alert("LABaseRuleQueryInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
  }
}
/************************************************************
 *               
 *输入：          没有
 *输出：          没有
 *功能：          初始化AgentGrid
 ************************************************************
 */
function initAgentGrid()
  {                               
    var iArray = new Array();
      
      try
      {
        iArray[0]=new Array();
        iArray[0][0]="<%=bundle.getString("Text_MutLineSeqNo")%>";         //列名
        iArray[0][1]="30px";         //列名
        iArray[0][2]=100;         //列名
        iArray[0][3]=0;         //列名

        iArray[1]=new Array();
        iArray[1][0]="<%=bundle.getString("BOM_CompensationLawCode")%>";         //列名
        iArray[1][1]="50px";         //宽度
        iArray[1][2]=100;         //最大长度        iArray[1][3]=0;         //是否允许录入，0--不能，1--允许

        iArray[2]=new Array();
        iArray[2][0]="<%=bundle.getString("BOM_CompensationLawName")%>";         //列名
        iArray[2][1]="50px";         //宽度
        iArray[2][2]=100;         //最大长度        iArray[2][3]=0;         //是否允许录入，0--不能，1--允许
        
        iArray[3]=new Array();
        iArray[3][0]="<%=bundle.getString("BOM_Channel")%>";         //列名
        iArray[3][1]="50px";         //宽度
        iArray[3][2]=100;         //最大长度        iArray[3][3]=0;         //是否允许录入，0--不能，1--允许
        
        iArray[4]=new Array();
        iArray[4][0]="<%=bundle.getString("BOM_CompensationLawStatus")%>";         //列名
        iArray[4][1]="50px";         //宽度
        iArray[4][2]=100;         //最大长度        iArray[4][3]=0;         //是否允许录入，0--不能，1--允许


        iArray[5]=new Array();
        iArray[5][0]="<%=bundle.getString("BOM_Remarks")%>";         //列名
        iArray[5][1]="50px";         //宽度
        iArray[5][2]=100;         //最大长度
        iArray[5][3]=0;         //是否允许录入，0--不能，1--允许
        
        iArray[6]=new Array();
        iArray[6][0]="<%=bundle.getString("BOM_Creater")%>";         //列名
        iArray[6][1]="50px";         //宽度
        iArray[6][2]=100;         //最大长度
        iArray[6][3]=0;         //是否允许录入，0--不能，1--允许
 
        iArray[7]=new Array();
        iArray[7][0]="<%=bundle.getString("BOM_CreationDate")%>";         //列名
        iArray[7][1]="50px";         //宽度
        iArray[7][2]=100;         //最大长度
        iArray[7][3]=0;         //是否允许录入，0--不能，1--允许
 
  
        AgentGrid = new MulLineEnter( "fm" , "AgentGrid" ); 

        //这些属性必须在loadMulLine前
        AgentGrid.mulLineCount = 5;   
        AgentGrid.displayTitle = 1;
        AgentGrid.hiddenPlus = 1;
        AgentGrid.hiddenSubtraction = 1;
        AgentGrid.canSel=1;
        AgentGrid.canChk=0;
        AgentGrid.locked=1;
        AgentGrid.loadMulLine(iArray);  
      }
      catch(ex)
      {
    	  alert(ex);
      }
    }


</script>
