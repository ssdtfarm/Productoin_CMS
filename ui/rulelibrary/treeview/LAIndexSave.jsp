<%@include file="../../common/jsp/UsrCheck.jsp"%>
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
    LAIndexUI tLAIndexUI = new LAIndexUI();

    String tOperate=request.getParameter("hideOperate");

    transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
    transferData.setNameAndValue("BaseCode",request.getParameter("BaseCode"));
    transferData.setNameAndValue("IndexType",request.getParameter("IndexType"));
    transferData.setNameAndValue("AgentGrade",request.getParameter("AgentGrade"));
    transferData.setNameAndValue("IndexSerise",request.getParameter("IndexSerise"));
    //        
    String tChk[] = request.getParameterValues("InpIndexGridChk");//1:该行被选中；0:该行未被选中
    String tIndexGrid1[] = request.getParameterValues("IndexGrid1");//项目名称
    String tIndexGrid2[] = request.getParameterValues("IndexGrid2");//项目编码
    List mulIndexGrid = new ArrayList();
    if(request.getParameterValues("IndexGridNo") != null) {
        for(int m=0;m<tChk.length;m++){
        	if(tChk[m].equals("1")){
            String[] aRow = new String[3];
            aRow[0] = tChk[m];
            aRow[1] = tIndexGrid1[m];
            aRow[2] = tIndexGrid2[m];
            mulIndexGrid.add(aRow);
        	}
        }
    }
    transferData.setNameAndValue("mulIndexGrid",mulIndexGrid);        
    String tChk1[] = request.getParameterValues("InpRuleGridChk");//1:该行被选中；0:该行未被选中
    String tRuleGrid1[] = request.getParameterValues("RuleGrid1");//项目名称
    String tRuleGrid2[] = request.getParameterValues("RuleGrid2");//项目编码
    List mulRuleGrid = new ArrayList();
    if(request.getParameterValues("RuleGridNo") != null) {
        for(int m=0;m<tChk1.length;m++){
        	if(tChk1[m].equals("1")){
            String[] aRow = new String[3];
            aRow[0] = tChk1[m];
            aRow[1] = tRuleGrid1[m];
            aRow[2] = tRuleGrid2[m];
            mulRuleGrid.add(aRow);
        	}
        }
    }
    transferData.setNameAndValue("mulRuleGrid",mulRuleGrid);

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
    FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
    Content=ESAPI.encoder().encodeForJavaScript(Content);
    
    System.out.println("helloo");
%>
<html>
<script language="javascript">
    parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
</script>
</html>
