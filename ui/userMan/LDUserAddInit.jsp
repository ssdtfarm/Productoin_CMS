<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%
//程序名称：OLDUserInput.jsp
//程序功能：
//创建日期：2002-08-16 17:44:42
//创建人  ：CrtHtml程序创建
//更新记录：  更新人    更新日期     更新原因/内容
%>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
//添加页面控件的初始化。
GlobalInput tG1 = new GlobalInput();
tG1=(GlobalInput)session.getValue("GI");
String gToday = PubFun.getCurrentDate(); 
System.out.println("gToday:"+gToday);
String tOperator=tG1.Operator;
String tComCode=tG1.ComCode;
tOperator=ESAPI.encoder().encodeForJavaScript(tOperator);
tComCode=ESAPI.encoder().encodeForJavaScript(tComCode);
%>
<script src="./LDUserAdd.js"></script>
<script language="JavaScript">
var gToDay = '<%=gToday%>';
function initInpBox()
{
	try
	{
		fm.all('UserCode').value = '';
		fm.all('UserName').value = '';
		fm.all('ComCode').value = '<%=tComCode%>';
		fm.all('ComCodeName').value = '';
		fm.all('Password').value = '';
		fm.all('PasswordConfirm').value = '';
		fm.all('UserDescription').value = '';
		fm.all('UserState').value = '0';
		fm.all('UserStateName').value = '<%=bundle.getString("waitForTran")%>';
		fm.all('UWPopedom').value = '';
		fm.all('ClaimPopedom').value = '';
		fm.all('OtherPopedom').value = '';
		fm.all('EdorPopedom').value = '';
		fm.all('UWPopedomName').value = '';
		fm.all('ClaimPopedomName').value = '';
		fm.all('OtherPopedomName').value = '';
		fm.all('EdorPopedomName').value = '';
		fm.all('PopUWFlag').value = '';
		fm.all('SuperPopedomFlag').value = '';
		fm.all('SuperPopedomFlagName').value = '';
		fm.all('Operator').value = '<%=tOperator%>';
		fm.all('ValidStartDate').value = '';
		fm.all('ValidEndDate').value = '';
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
		initUserGrid();
	}
	catch(re)
	{
		alert("OLDUserInputInit.jsp-->InitForm<%=bundle.getString("initFaild")%>!");
	}
}

function initUserGrid()
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
		iArray[1][0]="用户姓名";
		iArray[1][1]="100px";
		iArray[1][2]=10;
		iArray[1][3]=0;

		iArray[2]=new Array();
		iArray[2][0]="<%=bundle.getString("waitForTran")%>";
		iArray[2][1]="100px";
		iArray[2][2]=100;
		iArray[2][3]=0;

		iArray[3]=new Array();
		iArray[3][0]="<%=bundle.getString("waitForTran")%>";
		iArray[3][1]="60px";
		iArray[3][2]=100;
		iArray[3][3]=0;

		iArray[4]=new Array();
		iArray[4][0]="<%=bundle.getString("waitForTran")%>";
		iArray[4][1]="200px";
		iArray[4][2]=100;
		iArray[4][3]=0;
		
		
		iArray[5]=new Array();
		iArray[5][0]="<%=bundle.getString("OrganizationCode")%>";
		iArray[5][1]="100px";
		iArray[5][2]=100;
		iArray[5][3]=0;

		iArray[6]=new Array();
		iArray[6][0]="<%=bundle.getString("OfProfessionalAgencies")%>";
		iArray[6][1]="100px";
		iArray[6][2]=100;
		iArray[6][3]=0;
		
		iArray[7]=new Array();
		iArray[7][0]="有效开始日期";
		iArray[7][1]="100px";
		iArray[7][2]=100;
		iArray[7][3]=0;

		iArray[8]=new Array();
		iArray[8][0]="有效结束日期";
		iArray[8][1]="100px";
		iArray[8][2]=100;
		iArray[8][3]=0;

		UserGrid = new MulLineEnter( "fm" , "UserGrid" );
		//这些属性必须在loadMulLine前
		UserGrid.mulLineCount = 0;
		UserGrid.displayTitle = 1;
		UserGrid.canChk =0;
		UserGrid.canSel =1;
		UserGrid.locked =1;				//是否锁定：1为锁定 0为不锁定
		UserGrid.hiddenPlus=1;			//是否隐藏"+"添加一行标志：1为隐藏；0为不隐藏
		UserGrid.hiddenSubtraction=1;	//是否隐藏"-"添加一行标志：1为隐藏；0为不隐藏
		UserGrid.recordNo=0;			//设置序号起始基数为10，如果要分页显示数据有用
		UserGrid.loadMulLine(iArray);
	}
	catch(ex)
	{
		alert(ex);
	}
}

</script>
