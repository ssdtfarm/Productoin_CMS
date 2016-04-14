<%@include file="/i18n/language.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../common/jsp/UsrCheck.jsp"%>

<%@page import="java.util.*"%>
<%@page import="com.sinosoft.ibrms.*"%>
<%@ page import="com.sinosoft.utility.*"%>
<%@ page import="com.sinosoft.lis.pubfun.*"%>

<!--用户校验类-->
<%
	//接收信息，并作校验处理。

	//输入参数
	//操作类型；
	String flag = request.getParameter("flag");
	System.out.println("flag----------"+flag);
	String result = request.getParameter("WageYear1");
	System.out.println("result----------"+result);
	String Operation = request.getParameter("Operation");
	String TableName = request.getParameter("TableName");

	String BOMS = request.getParameter("BOMS");
	String SQLPara = request.getParameter("SQLPara");
	String ViewPara = request.getParameter("ViewPara");
	String SQLStatement = request.getParameter("SQLStatement");
	String CreateTable = request.getParameter("CreateTable");
	String RuleCh = request.getParameter("RuleCh");
	System.out.println("RuleCh::" + RuleCh);
	String RuleName = request.getParameter("RuleName");
	System.out.println("RuleName::" + RuleName);
	//String RuleDes = request.getParameter("RuleDes");
	
	String RuleDes = new String(request.getParameter("RuleDes").getBytes("iso-8859-1"),("GBK"));
//	System.out.println("RuleDes::" + RuleDes);
	String Creator = request.getParameter("Creator");
	String RuleStartDate = request.getParameter("RuleStartDate");
	String RuleEndDate = request.getParameter("RuleEndDate");
	String TempalteLevel = request.getParameter("TempalteLevel");
	String Business = request.getParameter("Business");
	//String State = request.getParameter("State");
	String State = "1";
	String Valid = request.getParameter("Valid");
	String ColumnDataType = request.getParameter("ColumnDataType");
	String TableColumnName = request.getParameter("TableColumnName");

	String[] TableColumnNameArray = TableColumnName.split(",");
	String[] ColumnDataTypeArray = ColumnDataType.split(",");

	Map DTColumnTypeMap = new HashMap();

	for (int i = 0; i < TableColumnNameArray.length; i++) {
		DTColumnTypeMap.put(TableColumnNameArray[i],
				ColumnDataTypeArray[i]);
	}

//	System.out.println("RuleName::" + RuleName);
//	System.out.println("RuleDes::" + RuleDes);

	String DTData = request.getParameter("DTData");
	String Types = request.getParameter("Types");
	String LRTemplate_ID = request.getParameter("LRTemplate_ID");
  String Approver = request.getParameter("Approver");
	System.out.println("Approver::---------------" + Approver);


	//String[] TypesArray = Types.split(",");

	//获取记录的最大条数

	TransferData tTransferData = new TransferData();
	tTransferData.setNameAndValue("flag", flag);
	tTransferData.setNameAndValue("Operation", Operation);
	tTransferData.setNameAndValue("TableName", TableName);
	tTransferData.setNameAndValue("LRTemplate_ID", LRTemplate_ID);

	tTransferData.setNameAndValue("BOMS", BOMS);
	tTransferData.setNameAndValue("SQLPara", SQLPara);
	tTransferData.setNameAndValue("ViewPara", ViewPara);
	tTransferData.setNameAndValue("SQLStatement", SQLStatement);
	tTransferData.setNameAndValue("CreateTable", CreateTable);
	tTransferData.setNameAndValue("RuleCh", RuleCh);

	tTransferData.setNameAndValue("RuleName", RuleName);
	tTransferData.setNameAndValue("RuleDes", RuleDes);
	tTransferData.setNameAndValue("Creator", Creator);
	tTransferData.setNameAndValue("RuleStartDate", RuleStartDate);
	tTransferData.setNameAndValue("RuleEndDate", RuleEndDate);
	tTransferData.setNameAndValue("TempalteLevel", TempalteLevel);
	tTransferData.setNameAndValue("Business", Business);
	tTransferData.setNameAndValue("State", State);
	tTransferData.setNameAndValue("Valid", Valid);
  tTransferData.setNameAndValue("Approver",Approver );

	tTransferData.setNameAndValue("DTData", DTData);
	tTransferData.setNameAndValue("DTColumnTypeMap", DTColumnTypeMap);

	//tTransferData.setNameAndValue("XMLSavePath", sXMLSavePath);
	// tTransferData.setNameAndValue("XMLSavePath", sXMLSavePath);
	tTransferData.setNameAndValue("Result1", result);
	GlobalInput tGlobalInput = new GlobalInput();
	tGlobalInput = (GlobalInput) session.getValue("GI");
	VData tVData = new VData();
	tVData.add(tGlobalInput);
	tVData.add(tTransferData);

	CErrors tErrors = new CErrors();

	RuleMakeUI tRuleMakeUI = new RuleMakeUI();
	System.out.println("save---------::");
	tRuleMakeUI.submitData(tVData);
  System.out.println("save-------over--::");
%>
<script language="javascript">
var flag=<%=flag%>;
var url="";
if(flag==1)
{
    url='RuleInfor.jsp?flag=';
	}
else
{
	url='RuleQuery.jsp?flag=';
	}
url+=flag;
	document.location.href = url;
</script>

<%@page import="org.jdom.input.SAXBuilder"%>
<%@page import="org.jdom.Document"%>
<%@page import="org.jdom.Element"%>
<%@page import="java.io.StringReader"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.jdom.JDOMException"%></html>