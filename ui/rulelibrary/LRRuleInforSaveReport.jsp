<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>

<%@page import="com.sinosoft.lis.db.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.LRRuleInforUIReport"%>
<%@page import="com.sinosoft.lis.excel.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String FlagStr = "";
	String Content = "";
	CErrors tError = new CErrors();
	GlobalInput tG = (GlobalInput)session.getValue("GI");
	TransferData transferData = new TransferData();
	VData tVData = new VData();
	VData mResult = new VData();
	boolean operFlag=true;
	LRRuleInforUIReport tLRBomUIReport = new LRRuleInforUIReport();
	
	String filePathString="LRRuleInfoReport";
	String sysvar = "OnwerExportFilePath"; 
	
	String tOperate=request.getParameter("hideOperate");
	
	transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
	transferData.setNameAndValue("WageCode",request.getParameter("WageCode"));
	transferData.setNameAndValue("WageName",request.getParameter("WageName"));
	transferData.setNameAndValue("State",request.getParameter("State"));
	transferData.setNameAndValue("IndexCode",request.getParameter("IndexCode"));
	transferData.setNameAndValue("IndexName",request.getParameter("IndexName"));
	transferData.setNameAndValue("StateRule",request.getParameter("StateRule"));
	
	
	//
	ExcelInfo info=null;
	String reportTime = PubFun.getCurrentTime().substring(0, 2)
			+ PubFun.getCurrentTime().substring(3, 5)
			+ PubFun.getCurrentTime().substring(6, 8);
	
	String modifyTime="";
		String serverFileName = "";
		String fileName="LRRuleInfoReport_" + tG.Operator + "_" + PubFun.getCurrentDate() + "_" + reportTime + ".xls";
	//开始提交
	tVData.add(tG);
	tVData.add(transferData);
	try {
	
		boolean t=tLRBomUIReport.submitData(tVData,tOperate);
	
	} catch(Exception ex) {
	    Content = bundle.getString("Savefailed,reason:") + ex.toString();
	    FlagStr = "Fail";
	}
	if (!FlagStr.equals("Fail")) {
	    tError = tLRBomUIReport.mErrors;
	    if (!tError.needDealError()) {
	        mResult = tLRBomUIReport.getResult(); //获取返回值
	        info=(ExcelInfo)mResult.getObjectByObjectName("ExcelInfo",0);
	        Content = bundle.getString("Savesuccessful!");
	        FlagStr = "Succ";
	
	        if(info.exists()){
	
	  	  		modifyTime=PubFun.getTime(info.getModifyTime());
				}
	        if (info != null) {
			 	Content = bundle.getString("Alert_Reportsuccessfullygenerated,downloadplease") + "!";
	
		 		serverFileName = info.getReportName();
			} else {
		 			Content = bundle.getString("Alert_FailReason:Donothaveenoughreportinformation") + "!";
		 			FlagStr = "Fail";
			}
	    } else {
	        Content = bundle.getString("Savefailed,reason:") + tError.getFirstError();
	        FlagStr = "Fail";
	    }
	}
	
	FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
	Content=ESAPI.encoder().encodeForJavaScript(Content);
	serverFileName = ESAPI.encoder().encodeForJavaScript(serverFileName);
	fileName = ESAPI.encoder().encodeForJavaScript(fileName);
	sysvar = ESAPI.encoder().encodeForJavaScript(sysvar);
	filePathString = ESAPI.encoder().encodeForJavaScript(filePathString);
	modifyTime = ESAPI.encoder().encodeForJavaScript(modifyTime);
	
%>
<html>
<script language="javascript">

parent.fraInterface.dl_afterSubmit("<%=FlagStr%>","<%=Content%>","<%=serverFileName%>","<%=fileName%>","<%=sysvar%>","<%=filePathString%>","<%=modifyTime%>");

</script>
</html>
