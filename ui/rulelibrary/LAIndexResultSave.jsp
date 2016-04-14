<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
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
    LAIndexResultUI tLAIndexUI = new LAIndexResultUI();

    String tOperate=request.getParameter("hideOperate");

    transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
    transferData.setNameAndValue("BaseCode",request.getParameter("BaseCode"));
    transferData.setNameAndValue("IndexType",request.getParameter("IndexType"));
    transferData.setNameAndValue("AgentGrade",request.getParameter("AgentGrade"));
    transferData.setNameAndValue("IndexSerise",request.getParameter("IndexSerise"));
    transferData.setNameAndValue("WageCode",request.getParameter("WageCode"));
    
    System.out.println("开始提交");
    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLAIndexUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = bundle.getString("Savefailed,reason:") + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLAIndexUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLAIndexUI.getResult(); //获取返回值
            Content = bundle.getString("Savesuccessful!");
            FlagStr = "Succ";
        } else {
            Content = bundle.getString("Savefailed,reason:") + tError.getFirstError();
            FlagStr = "Fail";
        }
    }
    tOperate=ESAPI.encoder().encodeForJavaScript(tOperate);
    FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
    Content=ESAPI.encoder().encodeForJavaScript(Content);
    
    System.out.println("helloo");
%>
<html>
<script language="javascript">
    var mOperator='<%=tOperate%>';
    parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>",mOperator);
</script>
</html>
