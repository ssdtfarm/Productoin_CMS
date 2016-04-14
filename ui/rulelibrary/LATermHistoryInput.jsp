<%@include file="/i18n/language.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String Termid = request.getParameter("Termid");

	Termid=ESAPI.encoder().encodeForJavaScript(Termid);

%>
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
  <script src="./LATermHistoryInput.js" charset="UTF-8"></script>
  <%@include file="./LATermHistoryInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LATermHistorySave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("G0000034750")%></td>
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
                <input value="<%=bundle.getString("G0000028239")%>" type=button onclick="turnPageAgentGird.firstPage();" class="cssButton"/>
                <input value="<%=bundle.getString("M0000045908")%>" type=button onclick="turnPageAgentGird.previousPage();" class="cssButton"/>
                <input value="<%=bundle.getString("M0000045909")%>" type=button onclick="turnPageAgentGird.nextPage();" class="cssButton"/>
                <input value="<%=bundle.getString("G0000028242")%>" type=button onclick="turnPageAgentGird.lastPage();" class="cssButton"/>
            </div>
        </div>
        <div id='div1' style='width:100%;display:none;'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='query' value="<%=bundle.getString("M0000057362")%>" type="button" onclick="return query();"/>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
        <input type="hidden" name ="hideTermid" value="<%=Termid%>"/>
    </form>
    <div id='sql' style="border:1px solid gray;width:80%;height:80px;padding:10px;"></div>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>
