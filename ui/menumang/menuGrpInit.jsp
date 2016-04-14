<%@include file="/i18n/language.jsp"%>
<%
//程序名称：menuInit.jsp
//程序功能：
//创建日期：2002-10-10
//创建人  ：
//更新记录：  更新人    更新日期     更新原因/内容
%>
<script language="JavaScript">
function initInpBox()
{
	try
	{
		fm.all("MenuGrpCode").value = "";
		fm.all("MenuGrpName").value = "";
		fm.all("MenuGrpDescription").value = "";
		fm.all("MenuSign").value = "";
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
		initQueryGrpGrid();
		initHideMenuGrpGrid1();
		initHideMenuGrpGrid2();
	}
	catch(re)
	{
		alert("menuGrpInputInit.jsp-->InitForm<%=bundle.getString("initFaild")%>!");
	}
}

function  initHideMenuGrpGrid1()
{
	var iArray = new Array();
	try
	{
		iArray[0]=new Array();
		iArray[0][0]="<%=bundle.getString("No.")%>";	//列名（此列为顺序号，列名无意义，而且不显示）
		iArray[0][1]="30px";	//列宽
		iArray[0][2]=10;		//列最大值
		iArray[0][3]=0;

		iArray[1]=new Array();
		iArray[1][0]="<%=bundle.getString("waitForTran")%>";
		iArray[1][1]="140px";
		iArray[1][2]=10;
		iArray[1][3]=0;

		iArray[2]=new Array();
		iArray[2][0]="<%=bundle.getString("waitForTran")%>";
		iArray[2][1]="120px";
		iArray[2][2]=100;
		iArray[2][3]=0;

		HideMenuGrpGrid1 = new MulLineEnter( "fm" , "HideMenuGrpGrid1" );
		//这些属性必须在loadMulLine前
		HideMenuGrpGrid1.mulLineCount = 0;
		HideMenuGrpGrid1.displayTitle = 1;
		HideMenuGrpGrid1.canChk =1;
		HideMenuGrpGrid1.canSel =0;
		HideMenuGrpGrid1.locked =1;				//是否锁定：1为锁定 0为不锁定
		HideMenuGrpGrid1.hiddenPlus=1;			//是否隐藏"+"添加一行标志：1为隐藏；0为不隐藏
		HideMenuGrpGrid1.hiddenSubtraction=0;	//是否隐藏"-"添加一行标志：1为隐藏；0为不隐藏
		HideMenuGrpGrid1.recordNo=0;			//设置序号起始基数为10，如果要分页显示数据有用
		HideMenuGrpGrid1.loadMulLine(iArray);
	}
	catch(ex)
	{
		alert(ex);
	}
}

function initHideMenuGrpGrid2()
{
	var iArray = new Array();
	try
	{
		iArray[0]=new Array();
		iArray[0][0]="<%=bundle.getString("Sequence")%>";
		iArray[0][1]="30px";
		iArray[0][2]=10;
		iArray[0][3]=0;

		iArray[1]=new Array();
		iArray[1][0]="<%=bundle.getString("waitForTran")%>";
		iArray[1][1]="140px";
		iArray[1][2]=10;
		iArray[1][3]=0;

		iArray[2]=new Array();
		iArray[2][0]="<%=bundle.getString("waitForTran")%>";
		iArray[2][1]="140px";
		iArray[2][2]=100;
		iArray[2][3]=0;

		HideMenuGrpGrid2 = new MulLineEnter( "fm" , "HideMenuGrpGrid2" );
		HideMenuGrpGrid2.mulLineCount = 0;
		HideMenuGrpGrid2.displayTitle = 1;
		HideMenuGrpGrid2.canChk =1;
		HideMenuGrpGrid2.canSel =0;
		HideMenuGrpGrid2.locked =1;
		HideMenuGrpGrid2.hiddenPlus=1;
		HideMenuGrpGrid2.hiddenSubtraction=0;
		HideMenuGrpGrid2.recordNo=0;
		HideMenuGrpGrid2.loadMulLine(iArray);
	}
	catch(ex)
	{
		alert(ex);
	}
}

function initQueryGrpGrid()
{
	var iArray = new Array();
	try
	{
		iArray[0]=new Array();
		iArray[0][0]="<%=bundle.getString("No.")%>";
		iArray[0][1]="30px";
		iArray[0][2]=10;
		iArray[0][3]=0;

		iArray[1]=new Array();
		iArray[1][0]="<%=bundle.getString("RoleName") %>";
		iArray[1][1]="150px";
		iArray[1][2]=10;
		iArray[1][3]=0;

		iArray[2]=new Array();
		iArray[2][0]="<%=bundle.getString("RoleCode") %>";
		iArray[2][1]="100px";
		iArray[2][2]=100;
		iArray[2][3]=0;

		iArray[3]=new Array();
		iArray[3][0]="MenuSign";
		iArray[3][1]="0px";
		iArray[3][2]=100;
		iArray[3][3]=0;


		iArray[4]=new Array();
		iArray[4][0]="<%=bundle.getString("RoleDescription") %>";
		iArray[4][1]="200px";
		iArray[4][2]=100;
		iArray[4][3]=0;

		iArray[5]=new Array();
		iArray[5][0]="<%=bundle.getString("Rolelist") %>";
		iArray[5][1]="100px";
		iArray[5][2]=100;
		iArray[5][3]=0;

		QueryGrpGrid = new MulLineEnter( "fm" , "QueryGrpGrid" );
		QueryGrpGrid.mulLineCount = 0;
		QueryGrpGrid.displayTitle = 1;
		QueryGrpGrid.canChk =0;
		QueryGrpGrid.canSel =1;
		QueryGrpGrid.locked =1;
		QueryGrpGrid.hiddenPlus=1;
		QueryGrpGrid.hiddenSubtraction=1;
		QueryGrpGrid.recordNo=0;
		QueryGrpGrid.loadMulLine(iArray);
	}
	catch(ex)
	{
		alert(ex);
	}
}
</script>
