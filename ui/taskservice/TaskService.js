//程序名称：TaskService.js
//程序功能：
//创建日期：2004-12-15
//创建人  ：ZhangRong
//更新记录：  更新人    更新日期     更新原因/内容
var showInfo;
var arrResult;
var mDebug = "0";
var mOperate = "";
var mAction = "";
var mSwitch = parent.VD.gVSwitch;
var turnPage = new turnPageClass();
var turnPageTaskPlanGrid = new turnPageClass();

/*********************************************************************
 *  提交
 *  参数  ：  无
 *  返回值：  无
 *********************************************************************
 */
function submitForm()
{
    var showStr=I18NMsg("Saving,pleasedonoteditanyinformationorlinktootherscreen");
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr ;
    if( mAction == "")
    {
        return;
    }
    urlStr=encodeURI(encodeURI(urlStr));
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    fm.submit(); //提交
}

function appendOne()
{
    mAction = "INSERT";
    if (fm.all("TaskCode").value == '' || fm.all("RunFlag").value == '' || fm.all("RecycleType").value == '')
    {
//        alert("请输入任务编码，是否启动和循环类型信息！");
    	 alert(I18NMsg("B_W1"));
        return;
    }
  
    if(!countCheck()){
    	return false;
    }
    
    fm.all('fmAction').value = mAction;
    submitForm();
}
function countCheck() {
    var mCount = ParamGrid.mulLineCount;
    if ((ParamGrid.getRowColData(0, 1, ParamGrid) == null || ParamGrid.getRowColData(0, 1, ParamGrid) == "") && (ParamGrid.getRowColData(0, 2, ParamGrid) == null || ParamGrid.getRowColData(0, 2, ParamGrid) == "" && (mCount == 1 || mCount == 0))) {
//        alert("请至少配置一条参数信息。");
    	 alert(I18NMsg("B_W2"));
        return false;
    }
    for (var i = 0; i < mCount; i++) {
        if (ParamGrid.getRowColData(i, 1, ParamGrid) == null || ParamGrid.getRowColData(i, 1, ParamGrid) == "") {
//            alert("参数信息中第" + (i + 1) + "行参数名称不能为空");
        	 alert(I18NMsg("B_R1_1") + (i + 1) + I18NMsg("B_R1_2"));
            return false;
        }
        if (ParamGrid.getRowColData(i, 2, ParamGrid) == null || ParamGrid.getRowColData(i, 2, ParamGrid) == "") {
//            alert("参数信息中第" + (i + 1) + "行参数值不能为空");
        	alert(I18NMsg("B_R1_1") + (i + 1) + I18NMsg("B_R1_3"));
            return false;
        }
    }
    var t = 0;
    for (var j = 0; j < mCount; j++) {
        if (ParamGrid.getRowColData(j, 1, ParamGrid) == "IP:PORT") {
            //t++;
            var ipport = ParamGrid.getRowColData(j, 2, ParamGrid);
            var m = ipport.indexOf(":");
            if (m == -1) {
//                alert("参数信息中对于参数名称为IP:PORT的第" + (j + 1) + "行参数值不合法，缺少冒号");
            	alert(I18NMsg("B_R2_1") + (j + 1) + I18NMsg("B_R2_2"));
                return false;
            }
            var n = ipport.indexOf(":", m + 1);
            if (n != -1) {
//                alert("参数信息中对于参数名称为IP:PORT的第" + (j + 1) + "行参数值不合法，有且只能有一个冒号");
            	alert(I18NMsg("B_R2_1") + (j + 1) + I18NMsg("B_R3_2"));
                return false;
            }
            var ip = ipport.substr(0, m);
            if (!f_check_IP(ip, j)) {
                return false;
            }
            var port = ipport.substr(m+1,ipport.length);
            if(port == null || port == ""){
//            	alert("参数信息中对于参数名称为IP:PORT的第" + (j + 1) + "行参数值不合法，端口不能为空");
            	alert(I18NMsg("B_R2_1") + (j + 1) + I18NMsg("B_R4_2"));
            	return false;
            }
            if(!f_check_number(port,j)){
            	return false;
            }
            t++;
        }
    }
    if (t == 0) {
//        alert("参数信息中请至少配置一条参数名为IP:PORT,参数值为参数名称类型的数据");
    	 alert(I18NMsg("B_R5"));
        return false;
    }   
    return true;
}
// 对IP进行合法校验
function f_check_IP(ip,n)    
{  
   var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/;//正则表达式   
   if(re.test(ip))   
   {   
       if( RegExp.$1<256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256 ) 
       return true;   
   }   
//   alert("参数信息中对与参数名称为IP:PORT的第"+(n+1)+"行参数值的IP有误！");   
   alert(I18NMsg("B_R6_1")+(n+1)+I18NMsg("B_R6_2"));   
   return false;    
}
//判断端口是不是都为数字
function f_check_number(obj,n)   
{          
    if (/^\d+$/.test(obj))   
    {   
       return true;   
    }      
//    alert("参数信息中对与参数名称为IP:PORT的第"+(n+1)+"行参数值的PORT有误,必须为数字！");   
    alert(I18NMsg("B_R7_1")+(n+1)+I18NMsg("B_R7_2"));   
    return false;     
}
function deleteOne()
{
    mAction = "DELETE";
    if (fm.all("TaskPlanCode").value == '')
    {
//        alert("请选择一条任务计划！");
    	alert(I18NMsg("B_Pleaseselectataskplan!"));
        return;
    }
    fm.all('fmAction').value = mAction;
    submitForm();
}

function activateOne()
{
    mAction = "ACTIVATE";
    if (fm.all("TaskPlanCode").value == '')
    {
//    	  alert("请选择一条任务计划！");
      	alert(I18NMsg("B_Pleaseselectataskplan!"));
        return;
    }
    fm.all('fmAction').value = mAction;
    submitForm();
}

function deactivateOne()
{
    mAction = "DEACTIVATE";
    if (fm.all("TaskPlanCode").value == '')
    {
//    	  alert("请选择一条任务计划！");
      	alert(I18NMsg("B_Pleaseselectataskplan!"));
        return;
    }
    fm.all( 'fmAction' ).value = mAction;
    submitForm();
}

function startEngine()
{
    mAction = "START";
    fm.all( 'fmAction' ).value = mAction;
    submitForm();
}

function stopEngine()
{
    mAction = "STOP";
    fm.all('fmAction').value = mAction;
    submitForm();
}

function appendTask()
{
    mAction = "INSERTTASK";
    if (fm.all("TaskDescribe").value == '' || fm.all("TaskClass").value == '')
    {
//        alert("请输入任务描述和任务处理类");
    	 alert(I18NMsg("B_Pleaseinputtaskdescriptionandtaskprocesstype"));
        return;
    }
    fm.all('fmAction').value = mAction;
    submitForm();
}

function deleteTask()
{
    mAction = "DELETETASK";
    if (fm.all("BaseTaskCode").value == '')
    {
//        alert("请选择一条任务！");
    	 alert(I18NMsg("B_Pleaseselectatask!"));
        return;
    }
    fm.all('fmAction').value = mAction;
    submitForm();
}

/**
 * 提交后操作, 服务器数据返回后执行的操作
 */
function afterSubmit(DealFlag, MsgContent)
{
    try { showInfo.close(); } catch (ex) {}
    DealFlag = DealFlag.toLowerCase();
    var MsgPageURL = "../common/jsp/MessagePage.jsp?picture=";
    switch (DealFlag)
    {
        case "fail":
            MsgPageURL = MsgPageURL + "F&content=" + encodeURI(encodeURI(MsgContent));
            showInfo = showModalDialog(MsgPageURL, window, "status=0; help=0; close=0; dialogWidth=550px; dialogHeight=250px");
            break;
        case "succ":
        case "success":
            MsgPageURL = MsgPageURL + "S&content=" + encodeURI(encodeURI(MsgContent));
            showInfo = showModalDialog(MsgPageURL, window, "status=0; help=0; close=0; dialogWidth=550px; dialogHeight=350px");
            break;
        default:
            MsgPageURL = MsgPageURL + "C&content=" + encodeURI(encodeURI(MsgContent));
            showInfo = showModalDialog(MsgPageURL, window, "status=0; help=0; close=0; dialogWidth=550px; dialogHeight=300px");
            break;
    }
    //本文件的特殊处理
    if (DealFlag == "succ" || DealFlag == "success")
    {
        try
        {
            mAction = "";
            queryTaskPlanInfo();
            queryTaskInfo();
        }
        catch (ex) {}
    }
}

/*********************************************************************
 *  显示任务计划
 *  参数  ：
 *  返回值：  无
 *********************************************************************
 */
var mySql=new SqlClass();
mySql.setJspName("../../taskservice/TaskServiceSql.jsp");
function queryTaskPlanInfo()
{
	//改动----------------QueryTask------------------------------
	mySql.setSqlId("QueryTask");  
	//改动----------------QueryTask------------------------------end
//    var strSQL = "select a.TaskPlanCode, a.TaskCode, b.TaskDescribe, a.RunFlag, a.RecycleType, a.StartTime, a.EndTime, a.Interval, a.Times, a.RunState from LDTaskPlan a, LDTask b where a.TaskCode = b.TaskCode order by a.TaskPlanCode";
    //turnPage.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
  //
    //if (!turnPage.strQueryResult)
    //{
    //  return;
  //  }
  //
    ////查询成功则拆分字符串，返回二维数组
    //turnPage.arrDataCacheSet = decodeEasyQueryResult(turnPage.strQueryResult);
    ////设置初始化过的MULTILINE对象，VarGrid为在初始化页中定义的全局变量
    //turnPage.pageDisplayGrid = TaskPlanGrid;
    ////保存SQL语句
    //turnPage.strQuerySql = strSQL;
    ////设置查询起始位置
    //turnPage.pageIndex = 0;
    ////在查询结果数组中取出符合页面显示大小设置的数组
    ////调用MULTILINE对象显示查询结果
    //displayMultiline(turnPage.arrDataCacheSet, turnPage.pageDisplayGrid);

    try
    {
        turnPageTaskPlanGrid.pageDivName = "divTurnPageTaskPlanGrid";
        turnPageTaskPlanGrid.queryModal(mySql.getString(), TaskPlanGrid);
    }
    catch (ex) {}
}

function queryTaskInfo()
{
	//改动----------------queryTaskInfo------------------------------
	mySql.setSqlId("queryTaskInfo");  
	//改动----------------queryTaskInfo------------------------------end
//    var strSQL = "select TaskCode, TaskDescribe, TaskClass from LDTask order by TaskCode ";
    turnPage.strQueryResult  = easyQueryVer3(mySql.getString(), 1, 0, 1);
    fm.TaskCode.CodeData = turnPage.strQueryResult;

    if (!turnPage.strQueryResult)
    {
        return;
    }

    //查询成功则拆分字符串，返回二维数组
    turnPage.arrDataCacheSet = decodeEasyQueryResult(turnPage.strQueryResult);
    //设置初始化过的MULTILINE对象，VarGrid为在初始化页中定义的全局变量
    turnPage.pageDisplayGrid = TaskGrid;
    //保存SQL语句
    turnPage.strQuerySql = mySql.getString();
    //设置查询起始位置
    turnPage.pageIndex = 0;
    //在查询结果数组中取出符合页面显示大小设置的数组
    //调用MULTILINE对象显示查询结果
    displayMultiline(turnPage.arrDataCacheSet, turnPage.pageDisplayGrid);
}

/*********************************************************************
 *  选择任务计划后的响应事件
 *  参数  ：
 *  返回值：  无
 *********************************************************************
 */
function onTaskPlanSelected(parm1,parm2)
{
    fm.all("TaskPlanCode").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 1);
    fm.all("TaskCode").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 2);
    fm.all("TaskCodeName").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 3);
    fm.all("RunFlag").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 4);
    fm.all("RecycleType").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 5);
    fm.all("StartTime").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 6);
    fm.all("EndTime").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 7);
    fm.all("Interval").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 8);
    fm.all("Times").value = TaskPlanGrid.getRowColData(TaskPlanGrid.getSelNo() - 1, 9);
    showTaskcodeName();
  //改动----------------onTaskPlanSelected------------------------------
	mySql.setSqlId("onTaskPlanSelected");  
	mySql.setValue("p_TaskPlanCode",fm.all("TaskPlanCode").value);
	mySql.setValue("p_TaskCode",fm.all("TaskCode").value);
	//改动----------------onTaskPlanSelected------------------------------end
//    var strSQL = "select ParamName, ParamValue from LDTaskParam where TaskPlanCode = '" + fm.all("TaskPlanCode").value + "' and TaskCode = '" + fm.all("TaskCode").value + "' order by (case paramname when 'IP:PORT' then '000000' else taskplancode end)";
//    turnPage.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
	 turnPage.strQueryResult  = easyQueryVer3(mySql.getString(), 1, 0, 1);

    if (!turnPage.strQueryResult)
    {
        return;
    }
    //查询成功则拆分字符串，返回二维数组
    turnPage.arrDataCacheSet = decodeEasyQueryResult(turnPage.strQueryResult);
    //设置初始化过的MULTILINE对象，VarGrid为在初始化页中定义的全局变量
    turnPage.pageDisplayGrid = ParamGrid;
    //保存SQL语句
//    turnPage.strQuerySql = strSQL;
    turnPage.strQuerySql = mySql.getString();
    //设置查询起始位置
    turnPage.pageIndex = 0;
    //在查询结果数组中取出符合页面显示大小设置的数组
    //调用MULTILINE对象显示查询结果
    displayMultiline(turnPage.arrDataCacheSet, turnPage.pageDisplayGrid);


}

function onTaskSelected(parm1,parm2)
{
    fm.all("BaseTaskCode").value = TaskGrid.getRowColData(TaskGrid.getSelNo() - 1, 1);
    fm.all("TaskDescribe").value = TaskGrid.getRowColData(TaskGrid.getSelNo() - 1, 2);
    fm.all("TaskClass").value = TaskGrid.getRowColData(TaskGrid.getSelNo() - 1, 3);
}

function resetForm()
{
    fm.all("TaskPlanCode").value = "";
    fm.all("TaskCode").value = "";
    fm.all("TaskCodeName").value = "";
    fm.all("RunFlag").value = "";
    fm.all("RunFlagName").value = "";
    fm.all("RecycleType").value = "";
    fm.all("RecycleTypeName").value = "";
    fm.all("StartTime").value = "";
    fm.all("EndTime").value = "";
    fm.all("Interval").value = "";
    fm.all("Times").value = "";
    fm.all("BaseTaskCode").value = "";
    fm.all("TaskDescribe").value = "";
    fm.all("TaskClass").value = "";
}

function refreshTask()
{
    initForm();
}

/**
 * XinYQ rewrote on 2006-11-24 : 避免窗体出现空白
 */
function taskPlanManage()
{
    try
    {
        document.all("divTaskPlan").style.display = "";
        document.all("divTaskPlanButton").style.display = "";
        document.all("divTask").style.display = "none";
        document.all("divTaskButton").style.display = "none";
        window.scroll(0, 0);
    }
    catch (ex) {}
}

/**
 * XinYQ rewrote on 2006-11-24 : 避免窗体出现空白
 */
function taskManage()
{
    try
    {
        document.all("divTaskPlan").style.display = "none";
        document.all("divTaskPlanButton").style.display = "none";
        document.all("divTask").style.display = "";
        document.all("divTaskButton").style.display = "";
        window.scroll(0, 0);
    }
    catch (ex) {}
}

/*********************************************************************
 *  任务计划代码框汉化
 *  参数  ：  无
 *  返回值：  无
 **********************************************************************/
function showTaskcodeName()
{
    showOneCodeName('TaskCode','TaskCode','TaskCodeName');
    showOneCodeName('runflag1','RunFlag','RunFlagName');
    showOneCodeName('recycletype1','RecycleType','RecycleTypeName');
}
