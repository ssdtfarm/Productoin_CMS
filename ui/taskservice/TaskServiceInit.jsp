<%@ include file="../common/jsp/UsrCheck.jsp" %>
<%
//程序名称：TaskServiceInit.jsp
//程序功能：
//创建日期：2004-12-15
//创建人  ：ZhangRong
//更新记录：  更新人    更新日期     更新原因/内容
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<script language="JavaScript">

function initForm()
{
    try
    {
        initDivLayer();
        initTaskPlanGrid();
        initParamGrid();
        initTaskGrid();
        queryTaskInfo();
        queryTaskPlanInfo();
    }
    catch(re)
    {
        alert(" TaskServiceInit.jsp --> initForm"+I18NMsg("Exceptionoccursinthefunction:initializingerr"));
    }
}

function initDivLayer()
{
    try
    {
        document.all("divTaskPlan").style.display = "";
        document.all("divTaskPlanButton").style.display = "";
        document.all("divTask").style.display = "none";
        document.all("divTaskButton").style.display = "none";
    }
    catch (ex) {}
}

function initTaskPlanGrid()
{
    var iArray = new Array();

    try
    {
        iArray[0]=new Array();
        iArray[0][0]=I18NMsg("No.");
        iArray[0][1]="30px";
        iArray[0][2]=30;
        iArray[0][3]=0;

        iArray[1]=new Array();
        iArray[1][0]=I18NMsg("B_Taskplancode");
        iArray[1][1]="80px";
        iArray[1][2]=20;
        iArray[1][3]=0;

        iArray[2]=new Array();
        iArray[2][0]=I18NMsg("B_Taskcode");
        iArray[2][1]="60px";
        iArray[2][2]=20;
        iArray[2][3]=0;

        iArray[3]=new Array();
        iArray[3][0]=I18NMsg("B_Taskdescription");
        iArray[3][1]="100px";
        iArray[3][2]=20;
        iArray[3][3]=0;

        iArray[4]=new Array();
        iArray[4][0]=I18NMsg("B_Activestatus");
        iArray[4][1]="60px";
        iArray[4][2]=20;
        iArray[4][3]=2;
        iArray[4][10]="RunFlagList";
        iArray[4][11]="0|^0|"+I18NMsg("B_Suspend")+"^1|"+I18NMsg("B_Active");

        iArray[5]=new Array();
        iArray[5][0]=I18NMsg("B_Circulationtype");
        iArray[5][1]="60px";
        iArray[5][2]=20;
        iArray[5][3]=2;
        iArray[5][10]="RecycleTypeList";
        iArray[5][11]="0|^11|"+I18NMsg("B_Onetimeperminute")+"^21|"+I18NMsg("B_Onetimeperhour")+"^31|"+I18NMsg("B_Onetimeperday")+"^41|"+I18NMsg("B_Onetimeperweek")+"^51|"+I18NMsg("B_Onetimepermonth")+"^61|"+I18NMsg("B_Onetimeperyear")+"^71|"+I18NMsg("B_Onetime")+"^72|"+I18NMsg("B_Severaltimes");

        iArray[6]=new Array();
        iArray[6][0]=I18NMsg("B_StartTime");
        iArray[6][1]="140px";
        iArray[6][2]=20;
        iArray[6][3]=0;
        iArray[6][21]=3;

        iArray[7]=new Array();
        iArray[7][0]=I18NMsg("B_EndTime");
        iArray[7][1]="140px";
        iArray[7][2]=20;
        iArray[7][3]=0;
        iArray[7][21]=3;

        iArray[8]=new Array();
        iArray[8][0]=I18NMsg("B_Cyclefrequency");
        iArray[8][1]="60px";
        iArray[8][2]=20;
        iArray[8][3]=0;
        iArray[8][21]=3;

        iArray[9]=new Array();
        iArray[9][0]=I18NMsg("B_Cyclecount");
        iArray[9][1]="60px";
        iArray[9][2]=20;
        iArray[9][3]=0;
        iArray[9][21]=3;

        iArray[10]=new Array();
        iArray[10][0]=I18NMsg("B_Processingstatus");
        iArray[10][1]="80px";
        iArray[10][2]=20;
        iArray[10][3]=2;
        iArray[10][10]="RunStateList";
        iArray[10][11]="0|^0|"+I18NMsg("B_Wait")+"^1|"+I18NMsg("B_Active2")+"^2|"+I18NMsg("B_Supend")+"^3|"+I18NMsg("B_Propertermination")+"^4|"+I18NMsg("B_Forcetermination")+"^5|"+I18NMsg("B_Abnormaltermination");
				
        TaskPlanGrid = new MulLineEnter("fm", "TaskPlanGrid");
        //这些属性必须在loadMulLine前
        TaskPlanGrid.mulLineCount = 0;
        TaskPlanGrid.displayTitle = 1;
        TaskPlanGrid.canSel =1;
        TaskPlanGrid.hiddenPlus=1;   //是否隐藏"+"号标志：1为隐藏；0为不隐藏(缺省值)
        TaskPlanGrid.hiddenSubtraction=1;
        TaskPlanGrid.selBoxEventFuncName = "onTaskPlanSelected";
        TaskPlanGrid.loadMulLine(iArray);
    }
    catch(ex)
    {
        alert("TaskServiceInit.jsp --> initTaskPlanGrid"+I18NMsg("Exceptionoccursinthefunction:initializingerr"));
    }
}

function initParamGrid()
{
    var iArray = new Array();

    try
    {
        iArray[0]=new Array();
        iArray[0][0]=I18NMsg("No.");
        iArray[0][1]="30px";
        iArray[0][2]=30;
        iArray[0][3]=0;

        iArray[1]=new Array();
        iArray[1][0]=I18NMsg("B_Parametername");
        iArray[1][1]="200px";
        iArray[1][2]=20;
        iArray[1][3]=1;

        iArray[2]=new Array();
        iArray[2][0]=I18NMsg("B_Parametervalue");
        iArray[2][1]="200px";
        iArray[2][2]=20;
        iArray[2][3]=1;

        ParamGrid = new MulLineEnter("fm", "ParamGrid");
        ParamGrid.mulLineCount = 1;
        ParamGrid.displayTitle = 1;
        ParamGrid.canSel =0;
        ParamGrid.hiddenPlus=0;
        ParamGrid.hiddenSubtraction=0;
        ParamGrid.loadMulLine(iArray);
    }
    catch(ex)
    {
        alert("TaskServiceInit.jsp --> initParamGrid"+I18NMsg("Exceptionoccursinthefunction:initializingerr"));
    }
}

function initTaskGrid()
{
    var iArray = new Array();

    try
    {
        iArray[0]=new Array();
        iArray[0][0]=I18NMsg("No.");
        iArray[0][1]="30px";
        iArray[0][2]=30;
        iArray[0][3]=0;

        iArray[1]=new Array();
        iArray[1][0]=I18NMsg("B_Taskcode");
        iArray[1][1]="80px";
        iArray[1][2]=20;
        iArray[1][3]=0;

        iArray[2]=new Array();
        iArray[2][0]=I18NMsg("B_Taskdescription");
        iArray[2][1]="180px";
        iArray[2][2]=20;
        iArray[2][3]=0;

        iArray[3]=new Array();
        iArray[3][0]=I18NMsg("B_Taskprocesstype");
        iArray[3][1]="120px";
        iArray[3][2]=20;
        iArray[3][3]=0;

        TaskGrid = new MulLineEnter("fm", "TaskGrid");
        TaskGrid.mulLineCount = 1;
        TaskGrid.displayTitle = 1;
        TaskGrid.canSel =1;
        TaskGrid.hiddenPlus=1;
        TaskGrid.hiddenSubtraction=1;
        TaskGrid.selBoxEventFuncName = "onTaskSelected";
        TaskGrid.loadMulLine(iArray);
    }
    catch(ex)
    {
        alert(" TaskServiceInit.jsp --> initTaskGrid"+I18NMsg("Exceptionoccursinthefunction:initializingerr"));
    }
}

</script>
