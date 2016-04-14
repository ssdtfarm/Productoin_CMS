
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%
//程序名称：LABankTreeSave.jsp
//程序功能：
//创建日期：2004-04-1 15:12:33
//创建人  ：CrtHtml程序创建
//更新记录：  更新人    更新日期     更新原因/内容
%>
<!--用户校验类-->
  <%@page import="com.sinosoft.utility.*"%>
  <%@page import="com.sinosoft.lis.rulelibrary.*"%>
  <%@page import="com.sinosoft.lis.pubfun.*"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%


  //接收信息，并作校验处理。
  //输入参数  
  System.out.println("begin tLABaseRuleUI...");
  LABaseRuleUI tLABaseRuleUI   = new LABaseRuleUI();

  //输出参数
  CErrors tError = null;
  String FlagStr = "Fail";
  String Content = "";

  GlobalInput tG = new GlobalInput();
  TransferData transferData = new TransferData();
  VData tVData = new VData();
  
  tG=(GlobalInput)session.getValue("GI");

  String tOperate=request.getParameter("hideOperate");

  transferData.setNameAndValue("BaseCode",request.getParameter("RuleCode"));
  transferData.setNameAndValue("Name",request.getParameter("RuleName"));
  transferData.setNameAndValue("BranchType",request.getParameter("BranchType"));
  transferData.setNameAndValue("BranchTypeName",request.getParameter("BranchTypeName"));
  transferData.setNameAndValue("Remark",request.getParameter("Remark"));
  transferData.setNameAndValue("Status",request.getParameter("Status"));
  // 准备传输数据 VData
   FlagStr="";  
   tVData.add(tG);
   tVData.add(transferData);
  try
  {
    System.out.println("this will save the data!!!");
    tLABaseRuleUI.submitData(tVData,tOperate);
  }
  catch(Exception ex)
  {
    Content = bundle.getString("Savefailed,reason:") + ex.toString();
    FlagStr = "Fail";
  }

  if (!FlagStr.equals("Fail"))
  {
    tError = tLABaseRuleUI.mErrors;
    if (!tError.needDealError())
    {        
    	Content = bundle.getString("Savesuccessful!");
    	FlagStr = "Succ";
    }
    else
    {
    	Content = bundle.getString("Savefailed,reason:") + tError.getFirstError();
    	FlagStr = "Fail";
    }
  }
  FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
  Content=ESAPI.encoder().encodeForJavaScript(Content);

  //添加各种预处理

%>
<html>
<script language="javascript">  
	parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
</script>
</html>

