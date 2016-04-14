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
    LARulePublishUI tLARulePublishUI = new LARulePublishUI();

    String tOperate=request.getParameter("hideOperate");

    transferData.setNameAndValue("BaseCode",request.getParameter("BaseCode"));
    transferData.setNameAndValue("Name",request.getParameter("Name"));
    transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
    //transferData.setNameAndValue("Status",request.getParameter("Status"));
    transferData.setNameAndValue("Status",request.getParameter("hideStatus"));
    transferData.setNameAndValue("Reason",request.getParameter("Reason"));
    //        
    String tRadio[] = request.getParameterValues("InpRuleGridSel");//1:该行被选中；0:该行未被选中
    String tRuleGrid1[] = request.getParameterValues("RuleGrid1");//基本法编码
    String tRuleGrid2[] = request.getParameterValues("RuleGrid2");//基本法名称
    String tRuleGrid3[] = request.getParameterValues("RuleGrid3");//渠道
    String tRuleGrid4[] = request.getParameterValues("RuleGrid4");//审核状态
    String tRuleGrid5[] = request.getParameterValues("RuleGrid5");//备注
    String tRuleGrid6[] = request.getParameterValues("RuleGrid6");//创建人
    String tRuleGrid7[] = request.getParameterValues("RuleGrid7");//创建日期

    List mulRuleGrid = new ArrayList();
    
    for (int m=0; m< tRadio.length;m++){
        if(tRadio[m].equals("1")) {
            String[] aRow = new String[8];
            aRow[0] = tRadio[m];
            aRow[1] = tRuleGrid1[m];
            aRow[2] = tRuleGrid2[m];
            aRow[3] = tRuleGrid3[m];
            aRow[4] = tRuleGrid4[m];
            aRow[5] = tRuleGrid5[m];
            aRow[6] = tRuleGrid6[m];
            aRow[7] = tRuleGrid7[m];
            mulRuleGrid.add(aRow);
	        break;
        }
     }
    transferData.setNameAndValue("mulRuleGrid",mulRuleGrid);

    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLARulePublishUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = bundle.getString("Savefailed,reason:") + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLARulePublishUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLARulePublishUI.getResult(); //获取返回值
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
