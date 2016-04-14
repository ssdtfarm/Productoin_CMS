<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.schema.*"%>
<%@page import="com.sinosoft.lis.vschema.*"%>
<%@page import="com.sinosoft.lis.db.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String FlagStr = "";
    String Content = "";
    CErrors tError = new CErrors();
    GlobalInput tG = (GlobalInput)session.getValue("GI");
    TransferData transferData = new TransferData();
    VData tVData = new VData();
    VData mResult = new VData();
    LRProAddUI tLRProAddUI = new LRProAddUI();

    String tOperate=request.getParameter("hideOperate");
		System.out.println("======================");
    transferData.setNameAndValue("WageName",request.getParameter("WageName"));
    transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
    transferData.setNameAndValue("BranchType2",request.getParameter("BranchType2"));
    transferData.setNameAndValue("Description",request.getParameter("Description"));
    transferData.setNameAndValue("IndexSerise",request.getParameter("IndexSerise"));
    transferData.setNameAndValue("WageType",request.getParameter("WageType"));
    transferData.setNameAndValue("State",request.getParameter("State"));
    //

    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLRProAddUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = bundle.getString("Savefailed,reason:") + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLRProAddUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLRProAddUI.getResult(); //获取返回值
            Content = bundle.getString("Savesuccessful!");
            FlagStr = "Succ";
        } else {
            Content = bundle.getString("Savefailed,reason:") + tError.getFirstError();
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
