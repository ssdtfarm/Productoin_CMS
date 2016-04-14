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
System.out.println("sssssssssssssssssssss"+request.getParameter("TermId"));

    String FlagStr = "";
    String Content = "";
    CErrors tError = new CErrors();
    GlobalInput tG = (GlobalInput)session.getValue("GI");
    TransferData transferData = new TransferData();
    VData tVData = new VData();
    VData mResult = new VData();
    LRTermUpdateUI tLRTermUpdateUI = new LRTermUpdateUI();

    String tOperate=request.getParameter("hideOperate");
    
    transferData.setNameAndValue("Calculate",request.getParameter("Calculate"));
    transferData.setNameAndValue("Attribute",request.getParameter("Attribute"));
	transferData.setNameAndValue("TextArea",request.getParameter("textarea"));
    transferData.setNameAndValue("Name",request.getParameter("Name"));
    transferData.setNameAndValue("Remark",request.getParameter("Remark"));
    transferData.setNameAndValue("TermId",request.getParameter("TermId"));
    transferData.setNameAndValue("State",request.getParameter("State"));
    System.out.println("sssssssssssssssssssss"+request.getParameter("TermId"));
    //
    /**
    String tPhraseGird1[] = request.getParameterValues("PhraseGird1");//短语类型
    String tPhraseGird3[] = request.getParameterValues("PhraseGird3");//描述
    String tPhraseGird4[] = request.getParameterValues("PhraseGird4");//模板
    List mulPhraseGird = new ArrayList();
    if(request.getParameterValues("PhraseGirdNo") != null) {
        int PhraseGirdLineCount = request.getParameterValues("PhraseGirdNo").length;
        for(int m=0;m<PhraseGirdLineCount;m++){
            String[] aRow = new String[5];
            aRow[0] = "-1";
            aRow[1] = tPhraseGird1[m];
            aRow[3] = tPhraseGird3[m];
            aRow[4] = tPhraseGird4[m];
            mulPhraseGird.add(aRow);
        }
    }
    transferData.setNameAndValue("mulPhraseGird",mulPhraseGird);
    String tParaGird1[] = request.getParameterValues("ParaGird1");//参数名称
    String tParaGird2[] = request.getParameterValues("ParaGird2");//参数类型
    List mulParaGird = new ArrayList();
    if(request.getParameterValues("ParaGirdNo") != null) {
        int ParaGirdLineCount = request.getParameterValues("ParaGirdNo").length;
        for(int m=0;m<ParaGirdLineCount;m++){
            String[] aRow = new String[3];
            aRow[0] = "-1";
            aRow[1] = tParaGird1[m];
            aRow[2] = tParaGird2[m];
            mulParaGird.add(aRow);
        }
    }
    transferData.setNameAndValue("mulParaGird",mulParaGird);
	**/
    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLRTermUpdateUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = bundle.getString("Savefailed,reason:") + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLRTermUpdateUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLRTermUpdateUI.getResult(); //获取返回值
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
