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
    LRRuleInforUI tLRRuleInforUI = new LRRuleInforUI();

    String tOperate=request.getParameter("hideOperate");
    transferData.setNameAndValue("WageCode",request.getParameter("wagecode"));
    transferData.setNameAndValue("IndexCode",request.getParameter("indexcode"));

    //transferData.setNameAndValue("WageCode",request.getParameter("WageCode"));
    //transferData.setNameAndValue("WageName",request.getParameter("WageName"));
    //transferData.setNameAndValue("WageType",request.getParameter("WageType"));
    //transferData.setNameAndValue("IndexSerise",request.getParameter("IndexSerise"));
    //        
    //String tRadio1[] = request.getParameterValues("InpProGirdSel");//1:该行被选中；0:该行未被选中
    //String tProGird1[] = request.getParameterValues("ProGird1");//项目编码
   // String tProGird2[] = request.getParameterValues("ProGird2");//项目名称
    //String tProGird3[] = request.getParameterValues("ProGird3");//项目类别
   // String tProGird4[] = request.getParameterValues("ProGird4");//项目系列
   // List mulProGird = new ArrayList();
   // if(request.getParameterValues("ProGirdNo") != null) {
       // int ProGirdLineCount = request.getParameterValues("ProGirdNo").length;
       // for(int m=0;m<ProGirdLineCount;m++){
         //   String[] aRow = new String[5];
         ////   aRow[0] = tRadio1[m];
          //  aRow[1] = tProGird1[m];
           // aRow[2] = tProGird2[m];
           // aRow[3] = tProGird3[m];
           // aRow[4] = tProGird4[m];
          //  mulProGird.add(aRow);
       // }
    //}
    //transferData.setNameAndValue("mulProGird",mulProGird);        
    //String tRadio[] = request.getParameterValues("InpRuleGirdSel");//1:该行被选中；0:该行未被选中
    //String tRuleGird1[] = request.getParameterValues("RuleGird1");//指标编码
    //String tRuleGird2[] = request.getParameterValues("RuleGird2");//指标名称
    //String tRuleGird3[] = request.getParameterValues("RuleGird3");//渠道
    //List mulRuleGird = new ArrayList();
   // if(request.getParameterValues("RuleGirdNo") != null) {
     //   int RuleGirdLineCount = request.getParameterValues("RuleGirdNo").length;
     //   for(int m=0;m<RuleGirdLineCount;m++){
            //String[] aRow = new String[4];
            //aRow[0] = tRadio[m];
            //aRow[1] = tRuleGird1[m];
            //aRow[2] = tRuleGird2[m];
           //// aRow[3] = tRuleGird3[m];
           // mulRuleGird.add(aRow);
       // }
   // }
   // transferData.setNameAndValue("mulRuleGird",mulRuleGird);

    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLRRuleInforUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = bundle.getString("Savefailed,reason:") + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLRRuleInforUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLRRuleInforUI.getResult(); //获取返回值
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
