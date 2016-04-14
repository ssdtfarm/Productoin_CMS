<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%!
public String upload(javax.servlet.http.HttpServletRequest request, String path) {
	int count=0;
	String filePath = null;
	
	DiskFileUpload fu = new DiskFileUpload();
	// 设置允许用户上传文件大小,单位:字节
	fu.setSizeMax(10000000);
	// maximum size that will be stored in memory?
	// 设置最多只允许在内存中存储的数据,单位:字节
	fu.setSizeThreshold(4096);
	// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
	fu.setRepositoryPath(path+"/temp");

//begin 异常捕获 ——刘富学
	try{
//end  异常捕获  ——刘富学

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
			System.out.println(name);
			long size = item.getSize();
			if(((name==null) || (name.equals(""))) && size==0)
				continue;
//			ImportPath= path + ImportPath;
			ImportPath= path + "\\temp\\" + ImportPath;
			FileName = name.replace('\\','/');
			FileName = FileName.substring(FileName.lastIndexOf("/") + 1);
			System.out.println(ImportPath+FileName);
			//保存上传的文件到指定的目录
			try
			{
				item.write(new File(ImportPath + FileName));
				count = 1;
				filePath = ImportPath + FileName;
			}
			catch(Exception e){
				System.out.println("upload file error ..."+e.getMessage());
				return null;
			}
		}
	}
	
//begin 异常处理 ——刘富学	
	}
	catch (FileUploadException e) {  
		// TODO Auto-generated catch block  
		e.printStackTrace();  
	}
	catch (Exception e) {  
		// TODO Auto-generated catch block  
		e.printStackTrace();  
	}
//end 异常处理 ——刘富学	

	return filePath;
}
%>
