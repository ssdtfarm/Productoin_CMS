<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@page import="java.util.Date"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.Resource.bundle"%>
<%@page contentType="text/xml;charset=UTF-8" pageEncoding='UTF-8'%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	GlobalInput gi = (GlobalInput) session.getValue("GI");
	String tCode = request.getParameter("code");
	String tType = request.getParameter("type");
	String tTree = request.getParameter("tree");
	String BaseCode = request.getParameter("basecode");	
	String newName = request.getParameter("newName");		
	String oper = request.getParameter("oper");	
	String tIndextype =request.getParameter("indextype");	
	String name = "";
	String isparent = "";
	String icon="icon:'./iCandy/img/remove.png',";
	SSRS ssrs;
	ExeSQL exe = new ExeSQL();
	
	tCode=ESAPI.encoder().encodeForJavaScript(tCode);
	tType=ESAPI.encoder().encodeForJavaScript(tType);
	tTree=ESAPI.encoder().encodeForJavaScript(tTree);
	BaseCode=ESAPI.encoder().encodeForJavaScript(BaseCode);
	newName=ESAPI.encoder().encodeForJavaScript(newName);
	oper=ESAPI.encoder().encodeForJavaScript(oper);
	tIndextype=ESAPI.encoder().encodeForJavaScript(tIndextype);
	
	StringBuffer result = new StringBuffer();
	System.out.println("Basecode"+BaseCode);
	if("menu".equals(tTree)){
	  if(tCode == null) {
		    String sql = "";					
	        sql = "select basecode,Name from LRBase where 1=1 and basecode='"+BaseCode+"' order by basecode desc";		      	       	      	       
			ssrs = exe.execSQL(sql);
			sql="select count(1) from laagentgrade where gradecode not in(select agentgrade from LRIndexVsCommP where branchtype ='1' and basecode='"+BaseCode+"')";
			String noRule = exe.getOneValue(sql);	
			if(Integer.parseInt(noRule)>0)
				icon="icon:'./iCandy/img/oper.png',";
			sql = "select count(1) from LRIndexVsCommP where basecode = '"+BaseCode+"' and branchtype='1' and indexcode is null";		      	       	      	       
			noRule = exe.getOneValue(sql);
			if(Integer.parseInt(noRule)>0){
				icon="icon:'./iCandy/img/remove.png',";
			}
			result.append("[{code:'"+ssrs.GetText(1, 1)+"',name:'"+ssrs.GetText(1, 2)+"',"+icon+"type:'root',isParent:true,treeid:"+tTree+",indextype:''}]");						 
		}else if(tCode.equals("0")){			
			String sql = "";					
	        sql = "select basecode,Name from LRBase where 1=1 and basecode='"+BaseCode+"' order by basecode desc";		      	       	      	       
				 ssrs = exe.execSQL(sql);				
				result.append("[");
				for(int i = 1; i <= ssrs.MaxRow; i++) {
					if(i > 1) {
						result.append(",");
					}
					result.append("{");
					result.append("code:'").append(ssrs.GetText(i, 1)).append("',");				
					result.append("name:'").append(ssrs.GetText(i, 2)).append("',");					
					result.append("parent:null,");
					sql="select count(1) from laagentgrade where gradecode not in(select agentgrade from LRIndexVsCommP where branchtype ='1' and basecode='"+BaseCode+"')";
					String noRule = exe.getOneValue(sql);	
					if(Integer.parseInt(noRule)>0)
						result.append("icon:'./iCandy/img/oper.png',");
					sql = "select count(1) from LRIndexVsCommP where basecode = '"+BaseCode+"' and branchtype='1' and indexcode is null";		      	       	      	       
					noRule = exe.getOneValue(sql);
					if(Integer.parseInt(noRule)>0){
						result.append(icon);
					}
					result.append("isParent:true,");
					result.append("indextype:''");
					result.append("}");
				}				 
				result.append("]");
		}else if(tCode.substring(0,1).equals("B")){
			String sql1 = "select count(1) from LRIndexVsCommP where basecode = '"+BaseCode+"' and branchtype='1' and indexcode is null and indextype = '01'";		      	       	      	       
			String sql2 = "select count(1) from LRIndexVsCommP where basecode = '"+BaseCode+"' and branchtype='1' and indexcode is null and indextype = '02'";
			String sql3 = "select count(1) from laagentgrade where gradecode not in(select agentgrade from LRIndexVsCommP where branchtype ='1' and basecode='"+BaseCode+"' and indextype = '01')";
			String sql4 = "select count(1) from laagentgrade where gradecode not in(select agentgrade from LRIndexVsCommP where branchtype ='1' and basecode='"+BaseCode+"' and indextype = '02')";
			String noRule1 = exe.getOneValue(sql1);
			String noRule2 = exe.getOneValue(sql2);
			String noRule3 = exe.getOneValue(sql3);
			String noRule4 = exe.getOneValue(sql4);
			String icon1="";
			String icon2="";
			if(Integer.parseInt(noRule3)>0){
				icon1="icon:'./iCandy/img/oper.png',";
			}
			if(Integer.parseInt(noRule4)>0){
				icon2="icon:'./iCandy/img/oper.png',";
			}
			if(Integer.parseInt(noRule1)>0){
				icon1=icon;
			}if(Integer.parseInt(noRule2)>0){
				icon2=icon;
			}
			String compensation=bundle.getString("C_Compensation");
			String Assessment=bundle.getString("C_Assessment");
			
			result.append("[{code:'01',name:'"+compensation+"',isParent:true,parent:'"+tCode+"',"+icon1+"indextype:'01'},{code:'02',name:'"+Assessment+"',isParent:true,parent:'"+tCode+"',"+icon2+"indextype:'02'}]");
		}else if(tCode.equals("01")){			
			String sql = "";					
	        sql = "select gradecode,gradename from laagentgrade order by gradeid desc";		      	       	      	       
				ssrs = exe.execSQL(sql);				
				result.append("[");
				for(int i = 1; i <= ssrs.MaxRow; i++) {
					if(i > 1) {
						result.append(",");
					}
					result.append("{");
					result.append("code:'").append(ssrs.GetText(i, 1)).append("',");				
					result.append("name:'").append(ssrs.GetText(i, 2)).append("',");					
					result.append("parent:'"+tCode+"',");
					sql="select count(1) from LRIndexVsCommP where indextype='01' and branchtype = '1' and basecode = '"+BaseCode+"' and agentgrade='"+ssrs.GetText(i, 1)+"'";
					String noRule = exe.getOneValue(sql);	
					if(Integer.parseInt(noRule)==0)
						result.append("icon:'./iCandy/img/oper.png',");
					sql="select count(1) from LRIndexVsCommP where branchtype ='1' and basecode='"+BaseCode+"' and indextype='01' and indexcode is null and agentgrade='"+ssrs.GetText(i, 1)+"'";
					noRule = exe.getOneValue(sql);	
					if(Integer.parseInt(noRule)>0)
						result.append("icon:'./iCandy/img/remove.png',");
					result.append("isParent:true,");
					result.append("indextype:'01'");
					result.append("}");
				}				 
				result.append("]");
		}else if(tCode.equals("02")){			
			String sql = "";					
	        sql = "select gradecode,gradename from laagentgrade order by gradeid desc";		      	       	      	       
				 ssrs = exe.execSQL(sql);				
				result.append("[");
				for(int i = 1; i <= ssrs.MaxRow; i++) {
					if(i > 1) {
						result.append(",");
					}
					result.append("{");
					result.append("code:'").append(ssrs.GetText(i, 1)).append("',");				
					result.append("name:'").append(ssrs.GetText(i, 2)).append("',");					
					result.append("parent:'"+tCode+"',");	
					sql="select count(1) from LRIndexVsCommP where indextype='02' and branchtype = '1' and basecode = '"+BaseCode+"' and agentgrade='"+ssrs.GetText(i, 1)+"'";
					String noRule = exe.getOneValue(sql);	
					if(Integer.parseInt(noRule)==0)
						result.append("icon:'./iCandy/img/oper.png',");
					sql="select count(1) from LRIndexVsCommP where branchtype ='1' and basecode='"+BaseCode+"' and indextype='02' and indexcode is null and agentgrade='"+ssrs.GetText(i, 1)+"'";
					noRule = exe.getOneValue(sql);	
					if(Integer.parseInt(noRule)>0)
						result.append("icon:'./iCandy/img/remove.png',");
					result.append("isParent:true,");
					result.append("indextype:'02'");
					result.append("}");
				}				 
				result.append("]");
		}else if(tCode.substring(0,1).equals("T")){	
			String sql ="";
	        sql = "select wagename,wagecode,indexcode from LRIndexVsCommP where branchtype ='1' and basecode='"+BaseCode+"' and agentgrade='"+tCode+"' and indextype='"+tIndextype+"' order by wageorder asc";		      	       	      	       
				 ssrs = exe.execSQL(sql);				
				result.append("[");
				for(int i = 1; i <= ssrs.MaxRow; i++) {
					if(i > 1) {
						result.append(",");
					}
					result.append("{");
					result.append("code:'").append(ssrs.GetText(i, 2)).append("',");				
					result.append("name:'").append(ssrs.GetText(i, 1)).append("',");	
					if(null==ssrs.GetText(i, 3)||"".equals(ssrs.GetText(i, 3)))
					{
						System.out.println(icon);
						result.append(icon);
					}
					result.append("parent:'"+tCode+"',");
					result.append("indextype:'"+tIndextype+"'");
					result.append("}");
				}				 
				result.append("]");
		}
	}
	System.out.println(result.toString());	
	out.clear();
	String result1 = ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(result.toString()));
	out.write(result1);
%>