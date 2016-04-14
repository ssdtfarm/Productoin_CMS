<%@include file="../common/jsp/UsrCheck.jsp"%>
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
		fm.all('MenuGrpCode').value = "";
		fm.all('MenuGrpName').value = "";
		fm.all('MenuGrpDescription').value = "";
		fm.all('MenuSign').value = "";
		fm.all('UserCode').value="";
		fm.all('DepPartMent').value="";
		fm.all('Team').value="";
		fm.all('DepManager').value="";
		fm.all('DepManagerName').value="";
		
	}
	catch(ex)
	{
		alert("<%=bundle.getString("initFaild")%>!");
	}
}
function initHiddenDep()
{
	try
	{
		fm.all("DepCode").value = "";
		fm.all("DepName").value = "";
		fm.all("DepLevel").value = "";
		fm.all("DepLevelName").value = "";
		fm.all("UpDepCode").value = "";
		fm.all("DepManager1").value = "";
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
		initHiddenDep();
		initQueryGrpGrid();
		initHideMenuGrpGrid1();
		initHideMenuGrpGrid2();
		initDepConfigGrid();//部组信息
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
		iArray[0][0]="<%=bundle.getString("Sequence")%>";	//列名（此列为顺序号，列名无意义，而且不显示）
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
												//单击选中触发的函数，并处理
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
		iArray[0][0]="<%=bundle.getString("Sequence")%>";
		iArray[0][1]="30px";
		iArray[0][2]=10;
		iArray[0][3]=0;

		iArray[1]=new Array();
		iArray[1][0]="<%=bundle.getString("waitForTran")%>";
		iArray[1][1]="150px";
		iArray[1][2]=10;
		iArray[1][3]=0;

		iArray[2]=new Array();
		iArray[2][0]="<%=bundle.getString("waitForTran")%>";
		iArray[2][1]="100px";
		iArray[2][2]=100;
		iArray[2][3]=0;

		iArray[3]=new Array();
		iArray[3][0]="<%=bundle.getString("waitForTran")%>";
		iArray[3][1]="100px";
		iArray[3][2]=100;
		iArray[3][3]=0;


		iArray[4]=new Array();
		iArray[4][0]="<%=bundle.getString("waitForTran")%>";
		iArray[4][1]="200px";
		iArray[4][2]=100;
		iArray[4][3]=0;

		iArray[5]=new Array();
		iArray[5][0]="<%=bundle.getString("waitForTran")%>";
		iArray[5][1]="100px";
		iArray[5][2]=100;
		iArray[5][3]=0;

		iArray[6]=new Array();
		iArray[6][0]="<%=bundle.getString("waitForTran")%>";
		iArray[6][1]="100px";
		iArray[6][2]=100;
		iArray[6][3]=0;

		iArray[7]=new Array();
		iArray[7][0]="<%=bundle.getString("waitForTran")%>";
		iArray[7][1]="100px";
		iArray[7][2]=100;
		iArray[7][3]=0;

		iArray[8]=new Array();
		iArray[8][0]="<%=bundle.getString("waitForTran")%>";
		iArray[8][1]="100px";
		iArray[8][2]=100;
		iArray[8][3]=0;

		iArray[9]=new Array();
		iArray[9][0]="<%=bundle.getString("GroupName")%>";
		iArray[9][1]="100px";
		iArray[9][2]=100;
		iArray[9][3]=0;

		iArray[10]=new Array();
		iArray[10][0]="<%=bundle.getString("waitForTran")%>";
		iArray[10][1]="100px";
		iArray[10][2]=100;
		iArray[10][3]=0;

		iArray[11]=new Array();
		iArray[11][0]="权限管理员姓名";
		iArray[11][1]="100px";
		iArray[11][2]=100;
		iArray[11][3]=0;
		
		QueryGrpGrid = new MulLineEnter( "fm" , "QueryGrpGrid" );
		QueryGrpGrid.mulLineCount = 0;
		QueryGrpGrid.displayTitle = 1;
		QueryGrpGrid.canChk =0;
		QueryGrpGrid.canSel =1;
		QueryGrpGrid.locked =1;
		QueryGrpGrid.hiddenPlus=1;
		QueryGrpGrid.hiddenSubtraction=1;
		QueryGrpGrid.recordNo=0;
		//单击触发需要处理的函数
		QueryGrpGrid.selBoxEventFuncName ="BackToInputBox";//点击触发动作
		QueryGrpGrid.loadMulLine(iArray);
	}
	catch(ex)
	{
		alert(ex);
	}
}

function initDepConfigGrid()
{
	var iArray = new Array();
	try
	{
		iArray[0]=new Array();
		iArray[0][0]="<%=bundle.getString("Sequence")%>";	//列名（此列为顺序号，列名无意义，而且不显示）
		iArray[0][1]="30px";	//列宽
		iArray[0][2]=10;		//列最大值
		iArray[0][3]=0;

		iArray[1]=new Array();
		iArray[1][0]="<%=bundle.getString("waitForTran")%>";
		iArray[1][1]="90px";
		iArray[1][2]=10;
		iArray[1][3]=0;

		iArray[2]=new Array();
		iArray[2][0]="<%=bundle.getString("waitForTran")%>";
		iArray[2][1]="150px";
		iArray[2][2]=100;
		iArray[2][3]=0;

		iArray[3]=new Array();
		iArray[3][0]="<%=bundle.getString("waitForTran")%>";
		iArray[3][1]="60px";
		iArray[3][2]=100;
		iArray[3][3]=3;

		iArray[4]=new Array();
		iArray[4][0]="<%=bundle.getString("waitForTran")%>";
		iArray[4][1]="60px";
		iArray[4][2]=100;
		iArray[4][3]=0;

		iArray[5]=new Array();
		iArray[5][0]="<%=bundle.getString("ParentBodiesofCode")%>";
		iArray[5][1]="80px";
		iArray[5][2]=100;
		iArray[5][3]=0;
		
		iArray[6]=new Array();
		iArray[6][0]="<%=bundle.getString("UpperLevelBankName")%>";
		iArray[6][1]="150px";
		iArray[6][2]=100;
		iArray[6][3]=0;

		iArray[7]=new Array();
		iArray[7][0]="<%=bundle.getString("waitForTran")%>";
		iArray[7][1]="100px";
		iArray[7][2]=100;
		iArray[7][3]=0;

		iArray[8]=new Array();
		iArray[8][0]="权限管理员姓名";
		iArray[8][1]="100px";
		iArray[8][2]=100;
		iArray[8][3]=3;

		iArray[9]=new Array();
		iArray[9][0]="<%=bundle.getString("waitForTran")%>";
		iArray[9][1]="100px";
		iArray[9][2]=100;
		iArray[9][3]=0;

		iArray[10]=new Array();
		iArray[10][0]="<%=bundle.getString("defaultDate")%>";
		iArray[10][1]="100px";
		iArray[10][2]=100;
		iArray[10][3]=0;

		DepConfigGrid = new MulLineEnter( "fm" , "DepConfigGrid" );
		//这些属性必须在loadMulLine前
		DepConfigGrid.mulLineCount = 0;
		DepConfigGrid.displayTitle = 1;
		DepConfigGrid.canChk =0;
		DepConfigGrid.canSel =1;
		DepConfigGrid.locked =1;				//是否锁定：1为锁定 0为不锁定
		DepConfigGrid.hiddenPlus=1;			//是否隐藏"+"添加一行标志：1为隐藏；0为不隐藏
		DepConfigGrid.hiddenSubtraction=1;	//是否隐藏"-"添加一行标志：1为隐藏；0为不隐藏
		DepConfigGrid.recordNo=0;			//设置序号起始基数为10，如果要分页显示数据有用
		//DepConfigGrid.selBoxEventFuncName ="BackToInputBox";//点击触发动作
		DepConfigGrid.loadMulLine(iArray);
	}
	catch(ex)
	{
		alert(ex);
	}
}
</script>
