<%@include file="../jsp/UsrCheck.jsp"%>
<%@page contentType="application/msexcel;charset=UTF-8" %>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.OutputStream"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="com.sinosoft.service.SqlParse"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	boolean debug = true;
	String jspName = null;
	String e_strSql = null;
	String[] e_head = null;
	String[] e_Vision = null;
	String e_sql = null;
	SSRS ssrs = null;
	ExeSQL exe =  new ExeSQL();
	VData tSQL =null;
	
	ArrayList new_head = new ArrayList();
	
	int mulLineCount = 0;
	response.reset();
	try {
		response.reset();
		response.resetBuffer();
		response.setHeader("Content-disposition", "attachment;filename="+ new Date().getTime() + ".xls");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setLocale(request.getLocale());
		OutputStream os = response.getOutputStream();
		e_strSql = request.getParameter("tSQL");
		e_strSql = StrTool.unicodeToGBK(request.getParameter("tSQL"));
		System.out.println(e_strSql);
		//e_strSql = new String(e_strSql.getBytes("GBK"), "GBK");
		String[] tmpStr = e_strSql.split("\\[@\\]");
		String mulLineName = tmpStr[0];
		e_head = tmpStr[1].split(",");
		e_Vision = tmpStr[2].split(",");
		e_sql = tmpStr[3];
		String[] new_Vision = new String[e_Vision.length-1];
		for (int i=1;i<e_Vision.length;i++){
			new_Vision[i-1] = e_Vision[i];
		}
		System.out.println("head: " + tmpStr[1]);
		System.out.println("Vision: " + tmpStr[2]);
		System.out.println("e_sql: " + tmpStr[3]);
		int len = e_Vision.length;
		for (int i=1;i<len;i++){
			if(!e_Vision[i].equals("3")){
				new_head.add(e_head[i]);
			}
		}
		if(e_sql.toLowerCase().indexOf(";")>0){
			 tSQL = new SqlParse().parseSQLPropertis(e_sql);		
			ssrs = exe.execSQL(tSQL);	
		}else{
			System.out.println(e_sql);
			ssrs = exe.execSQL(e_sql);
		}
		
		System.out.println("tSQL:"+tSQL);
		System.out.println("new_Vision"+new_Vision.length);
		System.out.println("head: " + e_head.length);
		System.out.println("newhead: " + new_head);
		System.out.println("newhead: " + new_head.size());
		System.out.println("----------------ExcelExport------------------");
		///////////////////////////////////////////////////////////////////////////tmp start
		ExeSQL exeSQL = new ExeSQL();
		ExportToExcel2 expToExcel = new ExportToExcel2();
		HSSFWorkbook book = expToExcel.createFixationSheet(ssrs, new_head , new_Vision);
		book.write(os);
		os.flush();
		os.close();
		out.clear(); 
		out = pageContext.pushBody();
		
	} catch (Exception e) {
		e.printStackTrace();
		out.clear(); 
		out = pageContext.pushBody();
	}finally{
		out.clear(); 
		out = pageContext.pushBody();
	}
%>