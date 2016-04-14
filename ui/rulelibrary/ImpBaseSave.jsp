

<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	//程序名称：AirTempFeeSave.jsp
	//程序功能：
	//创建日期：2007-11-24
	//创建人  ：
	//更新记录：  更新人    更新日期     更新原因/内容
%>

<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String path = application.getRealPath("").replace('\\', '/');
	if (!path.endsWith("/")) {
		path += "/";
	}	
	DiskFileUpload fu = new DiskFileUpload();
	fu.setSizeMax(20000000);
	fu.setSizeThreshold(4096);
	fu.setRepositoryPath(path + "/upload");
	List fileItems = fu.parseRequest(request);

	String ImportPath = "";
	String FileName = "";

	Iterator iter = fileItems.iterator();
	while (iter.hasNext()) {
		FileItem item = (FileItem) iter.next();
		System.out.println("*****"+item.getFieldName());
		if (item.getFieldName().compareTo("ImportPath") == 0) {
			ImportPath = item.getString();
			System.out.println("aaa");
		}
		//忽略其他不是文件域的所有表单信息
		if (!item.isFormField()) {
			String name = item.getName();
			long size = item.getSize();
			if ((name == null || name.equals("")) && size == 0){
		     		continue;
		     	}
				ImportPath = path + ImportPath;
				FileName = name.replace('\\', '/');
				FileName = FileName.substring(FileName.lastIndexOf("/") + 1);
			try {
				item.write(new File(ImportPath + FileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//输出参数
	String FlagStr = "Fail";
	String Content = "";

	GlobalInput tG = new GlobalInput();
	tG = (GlobalInput) session.getAttribute("GI");

	TransferData tTransferData = new TransferData();
	System.out.println("FileName---"+FileName);
	System.out.println("FilePath---"+path);
	tTransferData.setNameAndValue("FileName", FileName);
	tTransferData.setNameAndValue("FilePath", path);
	VData tVData = new VData();
	tVData.add(tTransferData);
	tVData.add(tG);

	BaseImpUI aaUI = new BaseImpUI();
	try {
		System.out.println("sava ---");
		if (aaUI.submitData(tVData, "IMPORT")) {
			Content = bundle.getString("Theimportissuccessful!");;
			FlagStr = "Succ";
		} else {
			//Content="导入失败，原因如下：<br>";
			Content=bundle.getString("SaveFailed")+bundle.getString("reason") +"<br>";
			int count=aaUI.mErrors.getErrorCount()>10?10:aaUI.mErrors.getErrorCount();
			for (int i = 0; i < count; i++) {
				Content += (i+1)+"、"+aaUI.mErrors.getError(i).errorMessage+"<br>";
			}
			FlagStr = "Fail";
		}
	} catch (Exception ex) {
		Content = bundle.getString("Uploadfailed");
		FlagStr = "Fail";
	}
	FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
	Content=ESAPI.encoder().encodeForJavaScript(Content);
	System.out.println("End "+FlagStr+Content);
%>
<html>
<script language="javascript">
    parent.fraInterface.afterSubmit('<%=FlagStr%>','<%=Content%>');
</script>
</html>
    
