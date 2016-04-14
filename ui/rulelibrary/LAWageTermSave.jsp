<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.schema.*"%>
<%@page import="com.sinosoft.lis.vschema.*"%>
<%@page import="com.sinosoft.lis.db.*"%>
<%@page import="com.sinosoft.lis.agentwages.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String FlagStr = "";
    String Content = "";
    CErrors tError = new CErrors();
    GlobalInput tG = (GlobalInput)session.getValue("GI");
    TransferData transferData = new TransferData();
    VData tVData = new VData();
    VData mResult = new VData();
    LAWageTermUI tLAWageUI = new LAWageTermUI();

    String tOperate=request.getParameter("hideOperate");

    transferData.setNameAndValue("ManageCom",request.getParameter("ManageCom"));
    transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
    transferData.setNameAndValue("BaseCode",request.getParameter("BaseCode"));
    transferData.setNameAndValue("WageNo",request.getParameter("WageNo"));
    transferData.setNameAndValue("WageCode",request.getParameter("WageCode"));
    transferData.setNameAndValue("IndexType",request.getParameter("IndexType"));
    transferData.setNameAndValue("AgentGrade",request.getParameter("AgentGrade"));

    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLAWageUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = "The save fails, the reason is that:" + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLAWageUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLAWageUI.getResult(); //获取返回值
            Content = " Saved successfully! ";
            FlagStr = "Succ";
        } else {
            Content = " The save fails, the reason is that:" + tError.getFirstError();
            FlagStr = "Fail";
        }
    }
    FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
    Content=ESAPI.encoder().encodeForJavaScript(Content);
    
%>
<html>
<script language="javascript">
    parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
</script>
</html>
