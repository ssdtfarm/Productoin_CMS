<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@include file="/i18n/language.jsp"%>
<%
/*******************************************************************************
 * <p>Title: Lis 6.0</p> 
 * <p>Description: 中科软人寿保险核心业务管理系统</p>
 * <p>Copyright: Copyright (c) 2005 Sinosoft, Co.,Ltd. All Rights Reserved</p>
 * <p>Company: 中科软科技股份有限公司</p>
 * <p>WebSite: http://www.sinosoft.com.cn</p>
 *
 * @author   : 张荣 <ZhangRong@sinosoft.com.cn>, 辛玉强 <XinYQ@sinosoft.com.cn>
 * @version  : 1.00, 1.01
 * @date     : 2004-12-15, 2006-11-24
 * @direction: 系统任务服务管理主框架
 ******************************************************************************/
%>

<%@ include file="../common/jsp/UsrCheck.jsp" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=bundle.getString("B_Systemtaskservicingmanagement")%></title>
    <!-- 公共引用样式 -->
    <link href="../common/css/Project.css" type="text/css" rel="stylesheet">
    <link href="../common/css/mulLine.css" type="text/css" rel="stylesheet">
    <!-- 公共引用脚本 -->
    <script language="JavaScript" src="../common/javascript/Common.js"></script>
    <script language="JavaScript" src="../common/cvar/CCodeOperate.js"></script>
    <script language="JavaScript" src="../common/javascript/MulLine.js"></script>
    <script language="JavaScript" src="../common/javascript/EasyQuery.js"></script>
    <script language="JavaScript" src="../common/easyQueryVer3/EasyQueryVer3.js"></script>
    <script language="JavaScript" src="../common/easyQueryVer3/EasyQueryCache.js"></script>
    <script language="JavaScript" src="../common/javascript/VerifyInput.js"></script>
    <script language="JavaScript" src="../common/Calendar/Calendar.js"></script>
    <!-- 私有引用脚本 -->
    <script language="JavaScript" src="TaskService.js"></script>
    <%@ include file="TaskServiceInit.jsp" %>
</head>
<body onload="initForm()">
    <form action="./TaskServiceChk.jsp" method=post name=fm target="fraSubmit">
        <Div id="divTaskPlan" style="display: ''">
            <table class=common>
                <TR class=common>
                    <td class="titleImg"><%=bundle.getString("B_Taskplaninformation")%></td>
                </TR>
                <TR class=common>
                    <TD class=title><%=bundle.getString("B_Taskplancode")%></TD>
                    <TD class=input>
                        <Input class=common readonly name=TaskPlanCode >
                    </TD>
                    <TD class=title><%=bundle.getString("B_Basictaskcode")%></TD>
                    <TD class=code>
                        <Input class=codeno name=TaskCode CodeData="" ondblclick="showCodeListEx('TaskCode',[this, TaskCodeName],[0,1],null,null,null,1,150);" onkeyup="showCodeListKeyEx('TaskCode',[this,TaskCodeName],[0,1],null,null,null,1,150);"><input class=codename name=TaskCodeName readonly>
                    </TD>
                </TR>
                <TR class=common>
                    <TD class=title><%=bundle.getString("B_Activestatus")%></TD>
                    <TD class=input>
                        <Input class=codeno name=RunFlag ondblclick="return showCodeList('runflag1',[this,RunFlagName],[0,1],null,null,null,1,150);" onkeyup="return showCodeListKey('runflag1',[this,RunFlagName],[0,1]);"><input class=codename name=RunFlagName readonly>
                         <!--Input class="codeno" name="AppntIDType"   ondblclick="return showCodeList('IDType',[this,AppntIDTypeName],[0,1]);" onkeyup="return showCodeListKey('IDType',[this,AppntIDTypeName],[0,1]);"><input class=codename name=AppntIDTypeName readonly elementtype=nacessary-->
                    </TD>
                    <TD class=title><%=bundle.getString("B_Circulationtype")%></TD>
                    <TD class=input>
                        <Input class=codeno name=RecycleType ondblclick="return showCodeList('recycletype1',[this, RecycleTypeName],[0,1],null,null,null,1,150);" onkeyup="return showCodeListKey('recycletype1',[this, RecycleTypeName],[0,1]);"><input class=codename name=RecycleTypeName readonly>
                    </TD>
                </TR>
                <TR class=common>
                    <TD class=title><%=bundle.getString("B_Starttime(YYYY-MM-DDHH:MM:SS)")%></TD>
                    <TD class=input>
                        <Input class=common name=StartTime >
                    </TD>
                    <TD class=title><%=bundle.getString("B_Endtime(YYYY-MM-DDHH:MM:SS)")%></TD>
                    <TD class=input>
                        <Input class=common name=EndTime >
                    </TD>
                </TR>
                <TR class=common>
                    <TD class=title><%=bundle.getString("B_Cyclefrequency")%></TD>
                    <TD class=input>
                        <Input class=common name=Interval >
                    </TD>
                    <TD class=title><%=bundle.getString("B_Cyclecount")%></TD>
                    <TD class=input>
                        <Input class=common name=Times >
                    </TD>
                </TR>
            </table>
            <table class=common>
                <TR>
                    <TD><span id="spanTaskPlanGrid"></span></TD>
                </TR>
            </table>
      <div id="divTurnPageTaskPlanGrid" align="center" style= "display:'none'">
          <input type="button" class="cssButton" value="<%=bundle.getString("Btn_FirstPage") %>" onclick="turnPageTaskPlanGrid.firstPage()">
          <input type="button" class="cssButton" value="<%=bundle.getString("Btn_PreviousPage") %>" onclick="turnPageTaskPlanGrid.previousPage()">
          <input type="button" class="cssButton" value="<%=bundle.getString("Btn_NextPage") %>" onclick="turnPageTaskPlanGrid.nextPage()">
          <input type="button" class="cssButton" value="<%=bundle.getString("Btn_LastPage") %>" onclick="turnPageTaskPlanGrid.lastPage()">
      </div>
            <table class=common>
                <TR>
                    <td class="titleImg"><%=bundle.getString("B_Parameterinformation")%></td>
                    <td class=common><font color = red><%=bundle.getString("B_Remark")%></font></td>
                </TR>
            </table>
            <table class=common>
                <TR>
                    <TD><span id="spanParamGrid"></span></TD>
                </TR>
            </table>
        </Div>
        <br>
        <input type="hidden" name="fmAction" value="">
        <Div id="divTaskPlanButton">
            <INPUT VALUE="<%=bundle.getString("B_Addtask")%>" class=cssButton TYPE=button name=addbutton onclick="appendOne();">
            <INPUT VALUE="<%=bundle.getString("B_Deletetask")%>" class=cssButton TYPE=button name=delbutton onclick="deleteOne();">
            <INPUT VALUE="<%=bundle.getString("B_Activetask")%>" class=cssButton TYPE=button name=addbutton onclick="activateOne();">
            <INPUT VALUE="<%=bundle.getString("B_Suspendtask")%>" class=cssButton TYPE=button name=delbutton onclick="deactivateOne();">
            <INPUT VALUE="<%=bundle.getString("B_Activeservice")%>" class=cssButton TYPE=button name=addbutton onclick="startEngine();">
            <INPUT VALUE="<%=bundle.getString("B_Suspendservice")%>" class=cssButton TYPE=button name=delbutton onclick="stopEngine();">
            <INPUT VALUE="<%=bundle.getString("B_Taskrefresh")%>" class=cssButton TYPE=button name=delbutton onclick="refreshTask();">
            <INPUT VALUE="<%=bundle.getString("B_Basictaskmanagement")%>" class=cssButton TYPE=button name=delbutton onclick="taskManage();">
            <INPUT type=hidden VALUE="<%=bundle.getString("B_Queuetaskmanagement")%>" class=cssButton TYPE=button name=taskbutton onclick="location.href='QueueBatchSignTime.jsp';">
        </Div>
        <Div id="divTask" style="display: ''">
            <table class=common>
                <TR>
                    <td class="titleImg"><%=bundle.getString("B_Taskinformation")%></td>
                </TR>
                <TR class=common>
                    <TD class=title8><%=bundle.getString("B_Basictaskcode")%></TD>
                    <TD class=common>
                        <Input class=common readonly name=BaseTaskCode >
                    </TD>
                </TR>
                <TR class=common>
                    <TD class=title8><%=bundle.getString("B_Taskdescription")%></TD>
                    <TD class=code8>
                        <Input class=common name=TaskDescribe >
                    </TD>
                </TR>
                <TR class=common>
                    <TD class=title><%=bundle.getString("B_Taskprocesstype")%></TD>
                    <TD class=code8>
                        <Input class=common name=TaskClass >
                    </TD>
                </TR>
            </table>
            <table class=common>
                <TR>
                    <TD><span id="spanTaskGrid"></span></TD>
                </TR>
            </table>
        </Div>
        <br>
        <Div id="divTaskButton">
            <INPUT VALUE="<%=bundle.getString("B_Addtask")%>" class=cssButton TYPE=button name=addbutton onclick="appendTask()">
            <INPUT VALUE="<%=bundle.getString("B_Deletetask")%>" class=cssButton TYPE=button name=delbutton onclick="deleteTask()">
            <INPUT VALUE="<%=bundle.getString("B_Taskplanmanagement")%>" class=cssButton TYPE=button name=delbutton onclick="taskPlanManage()">
        </Div>
    </form>
    <span id="spanCode" style="display: none; position:absolute; slategray"></span>
</body>
</html>