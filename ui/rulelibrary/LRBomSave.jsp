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
    LRBomUI tLRBomUI = new LRBomUI();

    String tOperate=request.getParameter("hideOperate");
    System.out.println("tOperatetOperatetOperatetOperatetOperate="+tOperate);

    transferData.setNameAndValue("BomId",request.getParameter("bomid"));
    transferData.setNameAndValue("TermId",request.getParameter("termid"));
    //transferData.setNameAndValue("Name",request.getParameter("Name"));
       // System.out.println("tOperatetOperatetOperatetOperatetOperate="+request.getParameter("Name"));
      
    //String tRadio1[] = request.getParameterValues("InpBOMGirdSel");//1:该行被选中；0:该行未被选中
    //String tBOMGird1[] = request.getParameterValues("BOMGird1");//BOMID
    //String tBOMGird2[] = request.getParameterValues("BOMGird2");//BOM名称
    //String tBOMGird3[] = request.getParameterValues("BOMGird3");//描述
    //List mulBOMGird = new ArrayList();
   // if(request.getParameterValues("BOMGirdNo") != null) {
       // int BOMGirdLineCount = request.getParameterValues("BOMGirdNo").length;
       // for(int m=0;m<BOMGirdLineCount;m++){
       // //    String[] aRow = new String[4];
         //   aRow[0] = tRadio1[m];
         //   aRow[1] = tBOMGird1[m];
        //    aRow[2] = tBOMGird2[m];
         //   aRow[3] = tBOMGird3[m];
          //  mulBOMGird.add(aRow);
      //  }
    //}
    //transferData.setNameAndValue("mulBOMGird",mulBOMGird);        
    //String tRadio[] = request.getParameterValues("InpTermGirdSel");//1:该行被选中；0:该行未被选中
    //String tTermGird1[] = request.getParameterValues("TermGird1");//ID
    //String tTermGird2[] = request.getParameterValues("TermGird2");//名称
    //String tTermGird3[] = request.getParameterValues("TermGird3");//类型
    //List mulTermGird = new ArrayList();
   // if(request.getParameterValues("TermGirdNo") != null) {
      //  int TermGirdLineCount = request.getParameterValues("TermGirdNo").length;
      //  for(int m=0;m<TermGirdLineCount;m++){
          //  String[] aRow = new String[4];
           // aRow[0] = tRadio[m];
          //  aRow[1] = tTermGird1[m];
           // aRow[2] = tTermGird2[m];
           // aRow[3] = tTermGird3[m];
           // mulTermGird.add(aRow);
       // }
   // }
   // transferData.setNameAndValue("mulTermGird",mulTermGird);

    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tLRBomUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = bundle.getString("Savefailed,reason:") + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tLRBomUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tLRBomUI.getResult(); //获取返回值
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
