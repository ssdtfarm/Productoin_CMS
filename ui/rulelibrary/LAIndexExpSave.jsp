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
		path += "/temp";
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
	LRBaseUI tLRBaseUI = new LRBaseUI();
	String tOperate = request.getParameter("hideOperate");
	String NodeInfo = request.getParameter("NodeInfo");	
	transferData.setNameAndValue("path",path);
	transferData.setNameAndValue("NodeInfo",request.getParameter("NodeInfo"));
	//开始提交
	tVData.add(tG);
	tVData.add(transferData);
	try {
		tLRBaseUI.submitData(tVData, tOperate);		
	} catch (Exception ex) {
		Content = "The save fails , the reason is that :" + ex.toString();
		FlagStr = "Fail";
	}
	if (!FlagStr.equals("Fail")) {
		tError = tLRBaseUI.mErrors;
		if (!tError.needDealError()) {
			mResult = tLRBaseUI.getResult(); //获取返回值
			Content = " Saved successfully!";
			FlagStr = "Succ";
		} else {
			Content = " The save fails , the reason is that :" + tError.getFirstError();
			FlagStr = "Fail";
		}
	}
	Content = path+"/Base.xml";
	FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
	Content=ESAPI.encoder().encodeForJavaScript(Content);
%>
<html>
	<script language="javascript">
		parent.fraInterface.afterExp("<%=FlagStr%>","<%=Content%>");
	</script>
</html>