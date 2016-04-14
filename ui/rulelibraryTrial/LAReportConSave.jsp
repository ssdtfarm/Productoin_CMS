<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.schema.*"%>
<%@page import="com.sinosoft.lis.vschema.*"%>
<%@page import="com.sinosoft.lis.db.*"%>
<%@page import="com.sinosoft.lis.rulelibuaryTrial.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<head>
</head>

<%
	String FlagStr = "";
	String Content = "";
	int ColNum;
	ExeSQL exe = new ExeSQL();
	CErrors tError = new CErrors();
	GlobalInput tG = (GlobalInput) session.getValue("GI");
	String tOperator = tG.Operator;
	TransferData transferData = new TransferData();
	VData tVData = new VData();
	VData mResult = new VData();
	LAReportConUI tLAReportConUI = new LAReportConUI();

	String tOperate = request.getParameter("hideOperate");
	//String tReport = request.getParameter("Report");

	String branchType = request.getParameter("BranchType");
	String manageCom = "86";
			request.getParameter("ManageCom");
	String reportType = request.getParameter("ReportType");
	String baseVersion = request.getParameter("BaseVersion");
	String wageNo = request.getParameter("WageNo");
	String agentGrade = request.getParameter("AgentGrade");
	String branchAttr = request.getParameter("BranchAttr");
	String agentCode = request.getParameter("AgentCode");
	String reportID = request.getParameter("ReportID");
	String operatorCode = tG.Operator;
	
	String tChk[] = request.getParameterValues("InpSelectedIndexChk");//1:该行被选中；0:该行未被选中
	String tSelectedIndex1[] = request
			.getParameterValues("SelectedIndex1");//指标名称
	String tSelectedIndex2[] = request
			.getParameterValues("SelectedIndex2");//指标说明
	String tSelectedIndex3[] = request
			.getParameterValues("SelectedIndex3");//ColOrder
	/*List mulSelectedIndex = new ArrayList();
	if (request.getParameterValues("SelectedIndexNo") != null) {
		int SelectedIndexLineCount = request
				.getParameterValues("SelectedIndexNo").length;
		for (int m = 0; m < SelectedIndexLineCount; m++) {
			String[] aRow = new String[4];
			aRow[0] = tChk[m];
			aRow[1] = tSelectedIndex1[m];
			aRow[2] = tSelectedIndex2[m];
			aRow[3] = tSelectedIndex3[m];
			mulSelectedIndex.add(aRow);
		}
	}
	transferData.setNameAndValue("mulSelectedIndex", mulSelectedIndex);*/
	
	String tChk1[] = request.getParameterValues("InpAvailableIndexChk");//1:该行被选中；0:该行未被选中
	String tAvailableIndex1[] = request
			.getParameterValues("AvailableIndex1");//指标名称
	String tAvailableIndex2[] = request
			.getParameterValues("AvailableIndex2");//指标说明
	String tAvailableIndex3[] = request
			.getParameterValues("AvailableIndex3");//ColOrder
	/*List mulAvailableIndex = new ArrayList();
	if (request.getParameterValues("AvailableIndexNo") != null) {
		int AvailableIndexLineCount = request
				.getParameterValues("AvailableIndexNo").length;
		for (int m = 0; m < AvailableIndexLineCount; m++) {
			String[] aRow = new String[4];
			aRow[0] = tChk1[m];
			aRow[1] = tAvailableIndex1[m];
			aRow[2] = tAvailableIndex2[m];
			aRow[3] = tAvailableIndex3[m];
			mulAvailableIndex.add(aRow);
		}
	}
	transferData.setNameAndValue("mulAvailableIndex", mulAvailableIndex);*/
	
	try{
	if (tOperate.equals("addIndex")) {
		if (request.getParameterValues("AvailableIndexNo") != null) {
			int AvailableLineCount1 = request.getParameterValues("AvailableIndexNo").length;
			for (int m = 0; m < AvailableLineCount1; m++) {
				if (tChk1[m].equals("1")) {
					ColNum=Integer.parseInt(PubFun1.CreateMaxNo("LRReportCol2", 20));
					String sql = "insert into LRReportCol values('"
							+ reportID + "','" + tAvailableIndex1[m]
							+ "','" + ColNum + "','" + tAvailableIndex2[m]
							+ "')";
					exe.execUpdateSQL(sql);
				}
			}
		}
	} else if (tOperate.equals("removeIndex")) {
	    //System.out.println("remove function called");
		if (request.getParameterValues("SelectedIndexNo") != null) {
			int SelectedLineCount1 = request
					.getParameterValues("SelectedIndexNo").length;
			for (int m = 0; m < SelectedLineCount1; m++) {
				if (tChk[m].equals("1")) {
					String sql1 = "delete from LRReportCol where IndexCode='"
							+ tSelectedIndex1[m]
							+ "' and IndexName = '"
							+ tSelectedIndex2[m]
							+ "' and ColOrder = '"
							+ tSelectedIndex3[m] +"'";
					exe.execUpdateSQL(sql1);
				}
			}
		}
	} else if (tOperate.equals("printReport")){
		if(request.getParameterValues("SelectedIndexNo") != null){
			int ReportNum=Integer.parseInt(PubFun1.CreateMaxNo("LRReportCol1", 5));
			String time=PubFun.getCurrentDate();
			String sql2 = "insert into LRReport values('"
					+reportID+"','"+reportID+"','"+manageCom+"','"
					+branchType+"','"+reportType+"','"+baseVersion+"','"
					+wageNo+"','"+agentGrade+"','"+agentCode+"','"+branchAttr+"','"
					+tOperator+"','" +time+"','','','"+time+"')";
			exe.execUpdateSQL(sql2);
			%>
			<html>
			<script language="javascript">
					parent.fraInterface.showInfo.close();
			</script>
			</html>
			<%		
					String mFileName = "../temp/" + reportID + ".xls";
			        //System.out.println("-----------------" + mFileName); 
			        //java.io.File file = new java.io.File(mFileName);
			       // response.setContentType("application/ms-excel");   
			       // response.setHeader("Content-Disposition","inline;filename=data");
			        response.sendRedirect(mFileName);
			       // System.out.println("-----------------2" + mFileName); 
				}
		}else{
			System.out.println("no selected index!");
		}
	Content = bundle.getString("Savesuccessful!");
	}catch(Exception e){
	e.printStackTrace();
	Content = bundle.getString("C_Savefailed,reason:updatedatafailed!");
	}
	/*
	//开始提交
	tVData.add(tG);
	tVData.add(transferData);
	try {
		tLAReportConUI.submitData(tVData, tOperate);
	} catch (Exception ex) {
		Content = bundle.getString("Alert_SaveJspFail") + ex.toString();
		FlagStr = "Fail";
	}
	
	if (!FlagStr.equals("Fail")) {
		tError = tLAReportConUI.mErrors;
		if (!tError.needDealError()) {
			mResult = tLAReportConUI.getResult(); //获取返回值
			Content = bundle.getString("Savesuccessful!");
			FlagStr = "Succ";
		} else {
			Content = bundle.getString("Alert_SaveJspFail") + tError.getFirstError();
			FlagStr = "Fail";
		}
	}*/
	FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
	Content=ESAPI.encoder().encodeForJavaScript(Content);
	
%>
<html>
	<script language="javascript">
    parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
	</script>
</html>
