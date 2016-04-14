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
    LAIndexRuleUI tLAIndexRuleUI = new LAIndexRuleUI();

    String tOperate=request.getParameter("hideOperate");

    transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
    transferData.setNameAndValue("BaseCode",request.getParameter("BaseCode"));
    transferData.setNameAndValue("IndexType",request.getParameter("IndexType"));
    transferData.setNameAndValue("AgentGrade",request.getParameter("AgentGrade"));
    transferData.setNameAndValue("IndexSerise",request.getParameter("IndexSerise"));
    //transferData.setNameAndValue("IndexCode",request.getParameter("IndexCode"));
	transferData.setNameAndValue("Description",request.getParameter("Description"));
	transferData.setNameAndValue("WageCode",request.getParameter("WageCode"));
    
    
    String tRadio[] = request.getParameterValues("InpRuleGridSel");//1:该行被选中；0:该行未被选中
    String tRuleGrid1[] = request.getParameterValues("RuleGrid1");//规则编码
    String tRuleGrid2[] = request.getParameterValues("RuleGrid2");//规则简介
    List mulRuleGrid = new ArrayList();        
	    for (int i=0; i< tRadio.length;i++){
	        if(tRadio[i].equals("1")) {
	            String[] aRow = new String[3];
	            aRow[0] = tRadio[i];
	            aRow[1] = tRuleGrid1[i];
	            aRow[2] = tRuleGrid2[i];
	            mulRuleGrid.add(aRow);
		        break;
	        }
	     }
	    
    transferData.setNameAndValue("mulRuleGrid",mulRuleGrid);

    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLAIndexRuleUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = bundle.getString("Savefailed,reason:") + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLAIndexRuleUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLAIndexRuleUI.getResult(); //获取返回值
            Content = bundle.getString("Savesuccessful!");
            FlagStr = "Succ";
        } else {
            Content = bundle.getString("Savefailed,reason:") + tError.getFirstError();
            FlagStr = "Fail";
        }
    }
    
    FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
    Content=ESAPI.encoder().encodeForJavaScript(Content);
    
    System.out.println("Content"+Content);
%>
<html>
<script language="javascript">
    parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
</script>
</html>
