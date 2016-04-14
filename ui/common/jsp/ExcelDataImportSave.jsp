<%@include file="../jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%
//程序名称：ProposalCopyInput.jsp
//程序功能：
//创建日期：2002-08-21 09:25:18
//创建人  ：CrtHtml程序创建
//更新记录：  更新人    更新日期     更新原因/内容
%>
<!--用户校验类-->
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.Resource.bundle"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
String tPathName = request.getParameter("uiPath");
System.out.println(tPathName);

int count=0;
String path = application.getRealPath("").replace('\\','/');
if(!path.endsWith("/")){
	path += "/";
}
System.out.println(path);

DiskFileUpload fu = new DiskFileUpload();
// 设置允许用户上传文件大小,单位:字节
fu.setSizeMax(10000000);
// maximum size that will be stored in memory?
// 设置最多只允许在内存中存储的数据,单位:字节
fu.setSizeThreshold(4096);
// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
fu.setRepositoryPath(path+"/temp");
//开始读取上传信息
List fileItems = fu.parseRequest(request);

//System.out.println(path);
String ImportPath = "";
String FileName = "";
String[] tarray;

// 依次处理每个上传的文件
Iterator iter = fileItems.iterator();

while (iter.hasNext())
{
	
	FileItem item = (FileItem) iter.next();
	if (item.getFieldName().compareTo("ImportPath")==0)
	{
		ImportPath = item.getString();
		System.out.println("上传路径:"+ImportPath);
	}
	//忽略其他不是文件域的所有表单信息
	if (!item.isFormField())
	{
		String name = item.getName();
		
		if(name.endsWith(".xlsx")){
			name=name.replace(".xlsx", "_"+PubFun.getCurrentDate()+"_"+PubFun.getCurrentTime().replace(":", "")+".xlsx");
		}else{
			name=name.replace(".xls", "_"+PubFun.getCurrentDate()+"_"+PubFun.getCurrentTime().replace(":", "")+".xls");
		}
		
		System.out.println(name);
		long size = item.getSize();
		if((name==null||name.equals("")) && size==0)
			continue;
		ImportPath= path + ImportPath;
		FileName = name.replace('\\','/');
		FileName = FileName.substring(FileName.lastIndexOf("/") + 1);
		System.out.println(ImportPath+FileName);
		//保存上传的文件到指定的目录
		try
		{
			item.write(new File(ImportPath + FileName));
			count = 1;
		}
		catch(Exception e){
			System.out.println("upload file error ..."+e.getMessage());
		}
	}
}

//输出参数
CErrors tError = null;
String FlagStr = "Fail";
String Content = "";
String ErrContent = "";
String Result="";

TransferData tTransferData = new TransferData();
System.out.println("----FileName:"+FileName);
boolean res = true;

ExcelDataImportUI tUI   = new ExcelDataImportUI();

if (count >0)
{
	GlobalInput tG = new GlobalInput();
	tG=(GlobalInput)session.getValue("GI");
	// 准备传输数据 VData
	VData tVData = new VData();
	FlagStr="";
	tTransferData.setNameAndValue("FileName",ImportPath+FileName);
	//tVData.add(tTransferData);
	tVData.add(tG);
	tVData.add(ImportPath+FileName);
	try
	{
		res= tUI.submitData(tVData,tPathName);
		//Content = " 导入完毕，请查看导入结果! ";
		Content = bundle.getString("Importsucessful");
		FlagStr = "Succ";
		tError = tUI.mErrors;
		if(tError.getErrorCount()>0){
			tarray = new String[tError.getErrorCount()];
			for(int i=0;i<tError.getErrorCount();i++){
				tarray[i] = tError.getError(i).errorMessage;
				ErrContent += tarray[i] + "#";
			}
			System.out.println("content:"+tError.getErrContent());
		}else{
			//Content="导入成功";
			Content=bundle.getString("Theimportissuccessful!");
			
			//ErrContent="全部数据导入成功";
			ErrContent=bundle.getString("Theimportissuccessful!");
		}
	}
	catch(Exception ex)
	{
		//Content = "保存失败，原因是:" + ex.toString();
		Content =  bundle.getString("SaveFailed")+bundle.getString("reason")+ ex.toString();
		FlagStr = "Fail";
	}
}
else
{
	//Content = "上载文件失败! ";
	Content = bundle.getString("Uploadfailed");
	FlagStr = "Fail";
}
FlagStr=ESAPI.encoder().encodeForJavaScript(FlagStr);
Content=ESAPI.encoder().encodeForJavaScript(Content);
ErrContent=ESAPI.encoder().encodeForJavaScript(ErrContent);
//添加各种预处理
%>
<script language="javascript">
parent.fraInterface.afterImportSubmit("<%=FlagStr%>","<%=Content%>","<%=ErrContent%>");
</script>