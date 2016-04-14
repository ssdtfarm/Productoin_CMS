<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.lis.rulelibrary.LRAssessIndexLibraryUtil.Result"%>
<%@include file="/i18n/language.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="net.sf.json.JSONFunction"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="com.sinosoft.lis.rulelibrary.LRAssessIndexLibraryUtil"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String oper=request.getParameter("oper");
    ExeSQL exe = new ExeSQL();
    if("rule".equals(oper)){
	    String indexcode=request.getParameter("indexcode");
	    String editmode=request.getParameter("editmode");
	    String basecode=request.getParameter("basecode");
	    String agentgrade=request.getParameter("agentgrade");
	    String indextype=request.getParameter("indextype");
	    
	    indexcode=ESAPI.encoder().encodeForJavaScript(indexcode);
	    editmode=ESAPI.encoder().encodeForJavaScript(editmode);
	    basecode=ESAPI.encoder().encodeForJavaScript(basecode);
	    agentgrade=ESAPI.encoder().encodeForJavaScript(agentgrade);
	    indextype=ESAPI.encoder().encodeForJavaScript(indextype);
	    
	    System.out.println("oper -----> "+oper);
	    System.out.println("indexcode -----> "+indexcode);
	    System.out.println("editmode -----> "+editmode);
	    System.out.println("AgentGrade -----> "+agentgrade);
	    System.out.println("indextype -----> "+indextype);
	    String sql = null;
	    if("para".equals(editmode)&&!basecode.equals("")&&!"null".equals(basecode)){	    	
	    	sql = "select isnull(json,'null') from LRAssessIndexp where indexcode='"+indexcode+"' and basecode = '"+basecode+"' and agentgrade = '"+agentgrade+"' and indextype = '"+indextype+"' ";
	    }else {
	    	sql = "select isnull(json,'null') from LRAssessIndexLibrary where indexcode='"+indexcode+"'";
	    }
	    System.out.println("sql--->"+sql);
			SSRS ssrs = exe.execSQL(sql);
			String json = null;
			if(ssrs.MaxRow == 1){
				json = ssrs.GetText(1, 1);
			}
			System.out.println("json:"+json);
			if(json == null || json.trim().equals("")){
				json = "null";
			}
			
			//json = JSON.parse(json);
			//JSONFunction jsonFunction = new JSONFunction(json);
			//System.out.println(jsonFunction.toString());
			
			System.out.println("json:"+json);
			//String cou = "CN";
			String lang = session.getAttribute("locale").toString();
			if("zh_CN".equals(lang)){
				json = json.replaceAll("If", "如果");
				json = json.replaceAll("Number", "数字");
				json = json.replaceAll("String", "字符串");
				json = json.replaceAll("Else", "否则");
				json = json.replaceAll("Then", "那么");
				json = json.replaceAll("Input Value", "输入值");
				json = json.replaceAll("Value", "输入值");
				json = json.replaceAll("And", "并且");
				json = json.replaceAll("Or", "或者");
				//json = json.replaceAll("輸入值", "输入值");
				//json = json.replaceAll("並且", "并且");
			}else if("zh_TW".equals(lang)){
				json = json.replaceAll("If", "如果");
				json = json.replaceAll("Number", "數字");
				json = json.replaceAll("String", "字符串");
				json = json.replaceAll("Else", "否則");
				json = json.replaceAll("Then", "那麼");
				json = json.replaceAll("Input Value", "输入值");
				json = json.replaceAll("Value", "输入值");
				json = json.replaceAll("And", "並且");
				json = json.replaceAll("Or", "或者");
				
				json = json.replaceAll("数字", "數字");
				json = json.replaceAll("那么", "那麼");
				json = json.replaceAll("否则", "否則");
				json = json.replaceAll("输入值", "輸入值");
				json = json.replaceAll("并且", "並且");
				
				json = json.replaceAll("\\\\u8f93\\\\u5165\\\\u503c", "輸入值");
				json = json.replaceAll("\\\\u6570\\\\u5b57", "數字");
				json = json.replaceAll("\\\\u5426\\\\u5219", "否則");
				json = json.replaceAll("\\\\u90a3\\\\u4e48", "那麼");
			}else if("en".equals(lang)){
				json = json.replaceAll("\\\\u5982\\\\u679c", "If");
				json = json.replaceAll("\\\\u8f93\\\\u5165\\\\u503c", "Value");
				json = json.replaceAll("\\\\u6570\\\\u5b57", "Number");
				json = json.replaceAll("\\\\u5b57\\\\u7b26\\\\u4e32", "String");
				json = json.replaceAll("\\\\u5426\\\\u5219", "Else");
				json = json.replaceAll("\\\\u90a3\\\\u4e48", "Then");
				json = json.replaceAll("\\\\u5e76\\\\u4e14", "And");
				json = json.replaceAll("\\\\u6216\\\\u8005", "Or");
				json = json.replaceAll("数字", "Number");
				json = json.replaceAll("字符串", "String");
				json = json.replaceAll("日期", "Date");
				json = json.replaceAll("如果", "If");
				json = json.replaceAll("那么", "Then");
				json = json.replaceAll("否则", "Else");
				json = json.replaceAll("输入值", "Value");
				json = json.replaceAll("并且", "And");
				json = json.replaceAll("或者", "Or");
				
				
				json = json.replaceAll("\\\\u8f38\\\\u5165\\\\u503c", "Value");
				json = json.replaceAll("\\\\u6578\\\\u5b57", "Number");
				json = json.replaceAll("\\\\u5426\\\\u5219", "Else");
				json = json.replaceAll("\\\\u90a3\\\\u4e48", "Then");
				json = json.replaceAll("\\\\u4e26\\\\u4e14", "And");
				
				json = json.replaceAll("輸入值", "Value");
				json = json.replaceAll("數字", "Number");
				json = json.replaceAll("否則", "Else");
				json = json.replaceAll("那麼", "Then");
				json = json.replaceAll("並且", "And");
			}
			
			//Locale locale = (Locale)session.getAttribute("locale");
	    	//String cou = locale.getCountry();
			
			
			System.out.println("rule's json is : "+json);
			json=ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(json));
			out.clear();
			out.write(json.trim());
    } else if("loadbom".equals(oper)){
    	String indexcode =request.getParameter("indexcode");
    	String wagecode  =request.getParameter("wagecode");  
    	
    	indexcode=ESAPI.encoder().encodeForJavaScript(indexcode);
    	wagecode=ESAPI.encoder().encodeForJavaScript(wagecode);
    	
    	String sql = "select id,name from LRBom where state = 'Y' and branchtype = (select branchtype from lrindex where wagecode = '"+wagecode+"') order by name";
    	SSRS ssrs = exe.execSQL(sql);
    	StringBuffer sb = new StringBuffer("[");
    	boolean existsboms = ssrs.MaxRow > 0;
			for(int i = 1; i <= ssrs.MaxRow; i++) {
				String id = ssrs.GetText(i, 1);
				String name = ssrs.GetText(i, 2);
				if(i > 1) {
					sb.append(",");
				}
				sb.append("{bomid:'").append(id).append("',name:'").append(name).append("'}");
			}
			sql = "select wagecode,wagename from lrindex where state = 'Y' and branchtype = (select branchtype from lrindex where wagecode = '"+wagecode+"') and wagetype = (select wagetype from lrindex where wagecode = '"+wagecode+"') order by wagename";
			System.out.println("sql ------>"+sql);
			ssrs = exe.execSQL(sql);
			for(int i = 1; i <= ssrs.MaxRow; i++) {
				String id = ssrs.GetText(i, 1);
				String name = ssrs.GetText(i, 2);
				if(!existsboms && i == 1) {
					sb.append("{bomid:'").append(id).append("',name:'").append(name).append("'}");
				}else{
					sb.append(",{bomid:'").append(id).append("',name:'").append(name).append("'}");
				}
			}
			sb.append("]");
			String sb1 = ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(sb.toString()));
			out.clear();
			out.write(sb1);
    } else if("loaditem".equals(oper)){
    	String indexcode=request.getParameter("indexcode");
    	String wagecode=request.getParameter("wagecode");
    	
    	indexcode=ESAPI.encoder().encodeForJavaScript(indexcode);
    	wagecode=ESAPI.encoder().encodeForJavaScript(wagecode);
    	
    	String sql = "select bomid,id,name,datatype from LRTerm where state = 'Y' order by bomid,name";
			SSRS ssrs = exe.execSQL(sql);
			StringBuffer sb = new StringBuffer("{");
			String currBomid = null;
			boolean startbom = false;
			boolean existsboms = ssrs.MaxRow > 0;
			for(int i = 1; i <= ssrs.MaxRow; i++) {
				String bomid = ssrs.GetText(i, 1);
				String id = ssrs.GetText(i, 2);
				String name = ssrs.GetText(i, 3);
				String datatype = ssrs.GetText(i, 4);
				
				if(!bomid.equals(currBomid)) {
					currBomid = bomid;
					if(i > 1) {
						sb.append("],");
					}
					sb.append(currBomid).append(":[");
					startbom = true;
				}
				if(startbom) {
					startbom = false;
				} else {
					sb.append(",");				
				}
				sb.append("{id:'").append(id).append("',name:'").append(name).append("',datatype:'").append(datatype).append("'}");
				if(i == ssrs.MaxRow) {
					sb.append("]");
				}
			}
			String sb1  = LRAssessIndexLibraryUtil.getRefRules(indexcode);
			System.out.println("sb1----------------------------"+sb1.toString());
			sql = "select wagecode,indexcode,indexname,DataType from LRAssessIndexLibrary where state = 'Y' and indexcode not in (' '"+sb1+") order by wagecode,indexname";
			ssrs = exe.execSQL(sql);
			startbom = false;
			currBomid = null;
			for(int i = 1; i <= ssrs.MaxRow; i++) {
				String bomid = ssrs.GetText(i, 1);
				String id = ssrs.GetText(i, 2);
				String name = ssrs.GetText(i, 3);
				String datatype = ssrs.GetText(i, 4);
				if(existsboms) {
					sb.append(",");
				//	sb.append(bomid+":[{id:'").append(id).append("',name:'").append(name).append("',datatype:'").append(datatype).append("'}]");
				//}else{
				//	sb.append(","+bomid+":[{id:'").append(id).append("',name:'").append(name).append("',datatype:'").append(datatype).append("'}]");
				}
				if(!bomid.equals(currBomid)) {
					currBomid = bomid;
					if(i > 1) {
						sb.append("],");
					}
					sb.append(currBomid).append(":[");
					startbom = true;
				}
				if(startbom) {
					startbom = false;
				} else {
					sb.append(",");				
				}
				sb.append("{id:'").append(id).append("',name:'").append(name).append("',datatype:'").append(datatype).append("'}");
				if(i == ssrs.MaxRow) {
					sb.append("]");
				}
			}
			sb.append("}");
			sb1 = ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(sb.toString()));
			out.clear();
			out.write(sb1);
    }else if("loadParaData".equals(oper)){
    	System.out.println("loadParaData");
	    String indexcode=request.getParameter("indexcode");
	    String basecode=request.getParameter("basecode");
	    
	    indexcode=ESAPI.encoder().encodeForJavaScript(indexcode);
	    basecode=ESAPI.encoder().encodeForJavaScript(basecode);
	    
	    String sql = "select * from "+indexcode+" where basecode='"+basecode+"'";
		SSRS ssrs = exe.execSQL(sql);
		StringBuffer sb = new StringBuffer("[");
		for(int i = 1; i <= ssrs.MaxRow; i++) {
			if(i > 1) {
				sb.append(",");
			}
			sb.append("[");
			for(int j = 4; j <= ssrs.MaxCol; j++){
				if(j > 4) {
					sb.append(",");
				}
				sb.append("'").append(ssrs.GetText(i, j)).append("'");
			}
			sb.append("]");
		}
		sb.append("]");
		String sb1 = ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(sb.toString()));
		out.clear();
		out.write(sb1);
    }else if("loadNames".equals(oper)){
    	System.out.println("loadNames------------------------------********************************");
	    String indexcode=request.getParameter("indexcode");
	    
	    indexcode=ESAPI.encoder().encodeForJavaScript(indexcode);
	    
	    String sql = "select b.wagename,a.indexname from lrassessindexlibrary a ,lrindex b where a.wagecode = b.wagecode and a.indexcode = '"+indexcode+"'"+" union "+"select b.name,a.name from lrterm a,lrbom b where a.bomid=b.id and a.id = '"+indexcode+"'";
		SSRS ssrs = exe.execSQL(sql);
		StringBuffer sb = new StringBuffer("{");
		for(int i = 1; i <= ssrs.MaxRow; i++) {
				sb.append("currbom:'").append(ssrs.GetText(1, 1)).append("',").append("currattr:'").append(ssrs.GetText(1, 2)).append("'");
			}
		sb.append("}");
		out.clear();
		System.out.println("sb:"+sb);
		String sb1 = ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(sb.toString()));
		out.write(sb1);
    }else if("calprpty".equals(oper)){
    	String basecode=request.getParameter("basecode");
		String indexcode=request.getParameter("indexcode");
		String agentgrade=request.getParameter("agentgrade");
		String indextype =  request.getParameter("indextype");
		
		basecode=ESAPI.encoder().encodeForJavaScript(basecode);
		indexcode=ESAPI.encoder().encodeForJavaScript(indexcode);
		agentgrade=ESAPI.encoder().encodeForJavaScript(agentgrade);
		indextype=ESAPI.encoder().encodeForJavaScript(indextype);
		
	    String sql = "select calprpty  from lrassessindexp where  basecode = '"+basecode+"' and agentgrade='"+agentgrade+"' and indexcode = '"+indexcode+"' and indextype = '"+indextype+"'";
	    String flag = "";
		SSRS ssrs = exe.execSQL(sql);
		if(ssrs.getMaxRow()>0){
			flag = ssrs.GetText(1, 1);
		}
		System.out.println(flag);
		flag=ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(flag));
		out.write("{flag:'"+flag.trim()+"'}");
    }  
    
%>
