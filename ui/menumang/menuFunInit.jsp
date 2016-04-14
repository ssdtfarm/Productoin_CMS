<%@include file="/i18n/language.jsp"%>
<%
//程序名称：menuFunInit.jsp
//程序功能：
//创建日期：2002-10-10
//创建人  ：
//更新记录：  更新人    更新日期     更新原因/内容
%>
<%@page import="com.sinosoft.lis.pubfun.GlobalInput"%>
<SCRIPT src="Common.js"></SCRIPT>
<%
     //添加页面控件的初始化。

%>

<script language="JavaScript">
function initInpBox()
{
  try
  {
      fm.all("NodeName").value = "";
      fm.all("RunScript").value = "";
  }
  catch(ex)
  {
    alert("<%=bundle.getString("initFaild")%>!");
  }
}

function initSelBox()
{
  try
  {

  }
  catch(ex)
  {
    alert("<%=bundle.getString("initFaild")%>!");
  }
}

function initForm()
{
  try
  {
    initInpBox();
    initSelBox();
    initQueryGrpGrid();
  }
  catch(re)
  {
    alert("menuFunInit.jsp-->InitForm<%=bundle.getString("initFaild")%>!");
  }
}

function initQueryGrpGrid()
{

    var iArray = new Array();

      try
      {
      iArray[0]=new Array();
      iArray[0][0]="<%=bundle.getString("Sequence")%>";         			//列名（此列为顺序号，列名无意义，而且不显示）
      iArray[0][1]="30px";         			//列宽
      iArray[0][2]=10;          			//列最大值
      iArray[0][3]=0;

      iArray[1]=new Array();
      iArray[1][0]="<%=bundle.getString("waitForTran")%>ID";         			//列名（此列为顺序号，列名无意义，而且不显示）
      iArray[1][1]="40px";         			//列宽
      iArray[1][2]=10;          			//列最大值
      iArray[1][3]=0;              			//是否允许输入,1表示允许，0表示不允许

      iArray[2]=new Array();
      iArray[2][0]="<%=bundle.getString("waitForTran")%>";    	                //列名
      iArray[2][1]="45px";            		        //列宽
      iArray[2][2]=100;            			//列最大值
      iArray[2][3]=0;             //是否允许输入,1表示允许，0表示不允许,2表示代码选择，3表示该列是隐藏的
      
      iArray[3]=new Array();
      iArray[3][0]="<%=bundle.getString("waitForTran")%>ID";    	                //列名
      iArray[3][1]="45px";            		        //列宽
      iArray[3][2]=100;            			//列最大值
      iArray[3][3]=0;             //是否允许输入,1表示允许，0表示不允许,2表示代码选择，3表示该列是隐藏的

      iArray[4]=new Array();
      iArray[4][0]="<%=bundle.getString("waitForTran")%>";    	                //列名
      iArray[4][1]="120px";            		        //列宽
      iArray[4][2]=100;            			//列最大值
      iArray[4][3]=0;             //是否允许输入,1表示允许，0表示不允许,2表示代码选择，3表示该列是隐藏的


      iArray[5]=new Array();
      iArray[5][0]="<%=bundle.getString("waitForTran")%>";    	                //列名
      iArray[5][1]="240px";            		        //列宽
      iArray[5][2]=100;            			//列最大值
      iArray[5][3]=0;             //是否允许输入,1表示允许，0表示不允许,2表示代码选择，3表示该列是隐藏的

      iArray[6]=new Array();
      iArray[6][0]="<%=bundle.getString("waitForTran")%>";    	                //列名
      iArray[6][1]="50px";            		        //列宽
      iArray[6][2]=100;            			//列最大值
      iArray[6][3]=0;             //是否允许输入,1表示允许，0表示不允许,2表示代码选择，3表示该列是隐藏的
      
      iArray[7]=new Array();
      iArray[7][0]="<%=bundle.getString("waitForTran")%>";    	                //列名
      iArray[7][1]="50px";            		        //列宽
      iArray[7][2]=100;            			//列最大值
      iArray[7][3]=0;            //是否允许输入,1表示允许，0表示不允许,2表示代码选择，3表示该列是隐藏的

      QueryGrpGrid = new MulLineEnter( "fm" , "QueryGrpGrid" );

      //这些属性必须在loadMulLine前
      QueryGrpGrid.mulLineCount = 3;
      QueryGrpGrid.displayTitle = 1;
      QueryGrpGrid.canChk =0;           //1 checkbox会显示，0 checkbox不会显示
      QueryGrpGrid.canSel =1;           //1 radio会显示，1 radio不会显示
      QueryGrpGrid.locked =1;            //是否锁定：1为锁定 0为不锁定
      QueryGrpGrid.hiddenPlus=1;        //是否隐藏"+"添加一行标志：1为隐藏；0为不隐藏
      QueryGrpGrid.hiddenSubtraction=1; //是否隐藏"-"添加一行标志：1为隐藏；0为不隐藏
      QueryGrpGrid.recordNo=0;         //设置序号起始基数为10，如果要分页显示数据有用

      QueryGrpGrid.loadMulLine(iArray);
      }
      catch(ex)
      {
        alert(ex);
      }
  }
</script>
