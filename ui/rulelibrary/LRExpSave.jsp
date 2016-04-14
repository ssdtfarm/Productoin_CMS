<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.schema.*"%>
<%@page import="com.sinosoft.lis.vschema.*"%>
<%@page import="com.sinosoft.lis.db.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String path = application.getRealPath("").replace('\\', '/');
	if (!path.endsWith("/")) {
		//path += "/temp";
		path += "/TempExcel/TempletFile/Export";
	}
	String FlagStr = "";
	String Content = "";
	ExeSQL exe = new ExeSQL();
	CErrors tError = new CErrors();
	GlobalInput tG = (GlobalInput) session.getValue("GI");
	String tOperator = tG.Operator;
	TransferData transferData = new TransferData();
	VData tVData = new VData();
	VData mResult = new VData();
	LRBaseExpUI tLRBaseExpUI = new LRBaseExpUI();
	String tOperate = request.getParameter("hideOperate");
	String BaseCode = request.getParameter("BaseCode");
	transferData.setNameAndValue("path",path);
	transferData.setNameAndValue("BaseCode",BaseCode);
	//开始提交
	tVData.add(tG);
	tVData.add(transferData);
	try {
		tLRBaseExpUI.submitData(tVData, tOperate);	
		Content = bundle.getString("Savesuccessful!");
		FlagStr = "Succ";
	} catch (Exception ex) {
		Content = bundle.getString("failed,reason:") + ex.toString();
		FlagStr = "Fail";
	}
	if (!FlagStr.equals("Fail")) {
		tError = tLRBaseExpUI.mErrors;
		if (!tError.needDealError()) {
			mResult = tLRBaseExpUI.getResult(); //获取返回值
			Content = bundle.getString("Savesuccessful!");
			FlagStr = "Succ";
		} else {
			Content = bundle.getString("failed,reason:") + tError.getFirstError();
			FlagStr = "Fail";
		}
	}
	Content = path+"/Base-"+BaseCode+".xml";
	FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
	Content=ESAPI.encoder().encodeForJavaScript(Content);
	
%>
<html>
	<script language="javascript">
		parent.fraInterface.afterExp("<%=FlagStr%>","<%=Content%>");
	</script>
</html>