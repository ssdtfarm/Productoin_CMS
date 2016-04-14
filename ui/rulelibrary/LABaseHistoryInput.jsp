<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<head>
  <script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
  <script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
  <script src="../common/javascript/Common.js" charset="UTF-8"></script>
  <script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
  <script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <script src="./LABaseHistoryInput.js" charset="UTF-8"></script>
  <%@include file="./LABaseHistoryInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LABaseHistorySave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg>历史查询</td>
            </tr>
        </table>
        <div id='div0' style='width:100%'>
            <div id="divAgentGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanAgentGird" ></span>
                        </td>
                    </tr>
                </table>
                <input value="<%=bundle.getString("Btn_FirstPage")%>" type=button onclick="turnPageAgentGird.firstPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_PreviousPage")%>" type=button onclick="turnPageAgentGird.previousPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_NextPage")%>" type=button onclick="turnPageAgentGird.nextPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_LastPage")%>" type=button onclick="turnPageAgentGird.lastPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_ExportToExcel")%>" type=button class="cssbutton" onclick = "makeExcel(fm,AgentGird)">
                <input class="cssButton" buttonname='query' value="查看明细" type="button" onclick="return query();"/>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>