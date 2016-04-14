<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String oper=request.getParameter("oper");
	oper = ESAPI.encoder().encodeForJavaScript(oper);
    ExeSQL exe = new ExeSQL();
    if("rule".equals(oper)){
	    String indexcode=request.getParameter("indexcode");
	    indexcode = ESAPI.encoder().encodeForJavaScript(indexcode);
	    String sql = "select json from LRAssessIndexLibrary where indexcode='"+indexcode+"'";
			SSRS ssrs = exe.execSQL(sql);
			String json = null;
			if(ssrs.MaxRow == 1){
				json = ssrs.GetText(1, 1);
			}
			if(json == null || json.trim().equals("")){
				json = "null";
			}
			json = ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(json));
			out.clear();
			out.write(json.trim());
    } else if("loadbom".equals(oper)){
    	String indexcode=request.getParameter("indexcode");
    	String wagecode=request.getParameter("wagecode");
    	String branchtype=request.getParameter("branchtype");
    	
    	indexcode = ESAPI.encoder().encodeForJavaScript(indexcode);
    	wagecode = ESAPI.encoder().encodeForJavaScript(wagecode);
    	branchtype = ESAPI.encoder().encodeForJavaScript(branchtype);
    	
    	/*String sql = "select id,name from LRBom order by displayorder";
    	SSRS ssrs = exe.execSQL(sql);
    	StringBuffer sb = new StringBuffer("[");
    	boolean existsboms = ssrs.MaxRow > 0;
			for(int i = 1; i <= ssrs.MaxRow; i++) {
				String id = ssrs.GetText(i, 1);
				String name = ssrs.GetText(i, 2);
				if(i > 1) {
					sb.append(",");
				}
				sb.append("{id:'").append(id).append("',name:'").append(name).append("'}");
			}
			sql = "select wagecode,wagename from lrindex where wagecode='"+wagecode+"' and branchtype='"+branchtype+"'";
			ssrs = exe.execSQL(sql);
			for(int i = 1; i <= ssrs.MaxRow; i++) {
				String id = ssrs.GetText(i, 1);
				String name = ssrs.GetText(i, 2);
				if(!existsboms && i == 1) {
					sb.append("{id:'").append(id).append("',name:'").append(name).append("'}");
				}else{
					sb.append(",{id:'").append(id).append("',name:'").append(name).append("'}");
				}
			}
			sb.append("]");*/
			StringBuffer sb = new StringBuffer();
			sb.append("[{id:'b1',name:'bom1'},{id:'b2',name:'bom2'},{id:'b3',name:'bom3'},{id:'b4',name:'bom4'}]");//
			out.clear();
			out.write(sb.toString());
    } else if("loaditem".equals(oper)){
    	String indexcode=request.getParameter("indexcode");
    	String wagecode=request.getParameter("wagecode");
    	String branchtype=request.getParameter("branchtype");
    	
    	indexcode = ESAPI.encoder().encodeForJavaScript(indexcode);
    	wagecode = ESAPI.encoder().encodeForJavaScript(wagecode);
    	branchtype = ESAPI.encoder().encodeForJavaScript(branchtype);
    	String sql = "select bomid,id,name,datatype from LRTerm order by bomid";
			/*SSRS ssrs = exe.execSQL(sql);
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
			sql = "select wagecode,indexcode,indexname,DataType from LRAssessIndexLibrary where branchtype='"+branchtype+"' and indexcode='"+indexcode+"'";
			ssrs = exe.execSQL(sql);
			if(ssrs.MaxRow>0) {
				String bomid = ssrs.GetText(1, 1);
				String id = ssrs.GetText(1, 2);
				String name = ssrs.GetText(1, 3);
				String datatype = ssrs.GetText(1, 4);
				if(!existsboms) {
					sb.append(wagecode+":[{id:'").append(id).append("',name:'").append(name).append("',datatype:'").append(datatype).append("'}]");
				}else{
					sb.append(","+wagecode+":[{id:'").append(id).append("',name:'").append(name).append("',datatype:'").append(datatype).append("'}]");
				}
			}
			sb.append("}");
			System.out.println(sb.toString());*/
			StringBuffer sb = new StringBuffer();
			sb.append("{b1:[{id:'b1i1',name:'bom1item1',datatype:'N2'}],b2:[{id:'b2i2',name:'bom2item2',datatype:'N4'}],b3:[{id:'b3i3',name:'bom3item3',datatype:'N6'}],b4:[{id:'b4i4',name:'bom4item4',datatype:'N2'}]}");
			out.clear();
			out.write(sb.toString());
    }
    
%>
