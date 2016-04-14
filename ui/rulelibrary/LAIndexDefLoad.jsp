<%@page contentType="text/xml;charset=UTF-8" pageEncoding='UTF-8'%>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.Resource.bundle"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.sys.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.LRAssessIndexLibraryUtil.Result"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	String tCode = request.getParameter("code");
	String tType = request.getParameter("type");
	String tTree = request.getParameter("tree");
	String BaseCode = request.getParameter("basecode");	
	String newName = request.getParameter("newName");		
	String agentgrade = request.getParameter("agentgrade");
	String oper = request.getParameter("oper");	
	String tIndextype =request.getParameter("indextype");
	String compensation=bundle.getString("C_Compensation");
	String Assessment=bundle.getString("C_Assessment");
	String name = "";
	String isparent = "";
	int k = 0;
	SSRS ssrs;
	ExeSQL exe = new ExeSQL();
	
	tCode=ESAPI.encoder().encodeForJavaScript(tCode);
	tType=ESAPI.encoder().encodeForJavaScript(tType);
	tTree=ESAPI.encoder().encodeForJavaScript(tTree);
	BaseCode=ESAPI.encoder().encodeForJavaScript(BaseCode);
	newName=ESAPI.encoder().encodeForJavaScript(newName);
	agentgrade=ESAPI.encoder().encodeForJavaScript(agentgrade);
	oper=ESAPI.encoder().encodeForJavaScript(oper);
	tIndextype=ESAPI.encoder().encodeForJavaScript(tIndextype);
	compensation=ESAPI.encoder().encodeForJavaScript(compensation);
	Assessment=ESAPI.encoder().encodeForJavaScript(Assessment);
	
	StringBuffer result = new StringBuffer();
	if("menu".equals(tTree)&&BaseCode!=null&&!BaseCode.equals("")){
	  if(tCode == null) {
			String icon="icon:'./iCandy/img/Base.png',";
		    String sql = "";					
	        sql = "select basecode,Name from LRBase where 1=1 and basecode='"+BaseCode+"' order by basecode desc";		      	       	      	       
			ssrs = exe.execSQL(sql);
			if( 1 <= ssrs.MaxRow){
			 	result.append("[{code:'"+ssrs.GetText(1, 1)+"',name:'"+ssrs.GetText(1, 2)+"',"+icon+"type:'root',isParent:true,treeid:"+tTree+",indextype:'',agentgrade:''}]");
			 }						 
		//by fengfei 2014-9-28 CCMB职级编码也是以B开头，也是6位，所以在此判断过不去
		// 修改判断
// 		}else if(tCode.substring(0,1).equals("B")&&tCode.length()==6){
		}else if(tCode.substring(0,2).equals("B0")&&tCode.length()==6){
		    String icon1="icon:'./iCandy/img/Kind.png',";
			result.append("[{code:'01',name:'"+compensation+"',isParent:true,parent:'"+tCode+"',"+icon1+"indextype:'01',agentgrade:''},{code:'02',name:'"+Assessment+"',isParent:true,parent:'"+tCode+"',"+icon1+"indextype:'02',agentgrade:''}]");
		}else if(tCode.equals("01")||tCode.equals("21")||tCode.equals("22")||tCode.equals("23")){			
			String sql = "";		
	        sql = "select gradecode, gradename, isnull(x.m1, 0)  from laagentgrade t  left join (select isnull(min(case  when indexcode is null then   1  else  -1 end), 0) m1,agentgrade   from LRIndexVsCommP  where indextype = '"+tCode+"' and basecode = '"+BaseCode+"'  group by agentgrade) x on t.gradecode = x.agentgrade where branchtype in   (select branchtype from LRBase where basecode = '"+BaseCode+"') order by gradeid desc";
				ssrs = exe.execSQL(sql);				
				result.append("[");
				for(int i = 1; i <= ssrs.MaxRow; i++) {
					String icon="./iCandy/img/ok.png";
					if(i > 1) {
						result.append(","); 
					}
					result.append("{");
					result.append("code:'").append(ssrs.GetText(i, 1)).append("',");				
					result.append("name:'").append(ssrs.GetText(i, 2)).append("',");
					result.append("agentgrade:'").append(ssrs.GetText(i,1)).append("',");					
					result.append("parent:'"+tCode+"',");
					String noRule = ssrs.GetText(i, 3);
					if(Integer.parseInt(noRule)==0){
						icon="./iCandy/img/oper.png";
					}else if(Integer.parseInt(noRule)>0){
						icon="./iCandy/img/remove.png";
					}
					result.append("icon:'"+icon+"',");
					result.append("isParent:true,");
					result.append("indextype:'"+tCode+"'");
					result.append("}");
				}				 
				result.append("]");
		}else if(tCode.equals("02")){
			String maintainAssessment=bundle.getString("C_MaintainAssessment");
			String promotionAssessment=bundle.getString("C_PromotionAssessment");
			String assessmentResult=bundle.getString("C_AssessmentResult");
		    String icon1="icon:'./iCandy/img/Kind.png',";
			result.append("[{code:'21',name:'"+maintainAssessment+"',isParent:true,parent:'"+tCode+"',"+icon1+"indextype:'21',agentgrade:''},{code:'22',name:'"+promotionAssessment+"',isParent:true,parent:'"+tCode+"',"+icon1+"indextype:'22',agentgrade:''},{code:'23',name:'"+assessmentResult+"',isParent:true,parent:'"+tCode+"',"+icon1+"indextype:'23',agentgrade:''}]");
		}else if (tCode.substring(0,1).equals("W")){
			String sql = "select indexcode,(select indexname from LRAssessIndexLibrary where indexcode=a.indexcode) from LRIndexVsCommP a where  basecode='"+BaseCode+"' and wagecode='"+tCode+"'and  Indextype='"+tIndextype+"' and agentgrade ='"+agentgrade+"' order by wageorder asc";		      	       	      	       
			ssrs = exe.execSQL(sql);
			if(1<=ssrs.MaxRow){
				if(!ssrs.GetText(1,1).equals("")&&ssrs.GetText(1,1)!=null){
				result.append("[");
			    result.append("{");
			    result.append("code:'").append(ssrs.GetText(1,1)).append("',");				
			    result.append("name:'").append(ssrs.GetText(1,2)).append("',");	
			    result.append("agentgrade:'").append(agentgrade).append("',");		
			    result.append("parent:'"+tCode+"',");
			    result.append("isParent:'true',");
				result.append("nocheck :true,");
				sql="select calprpty from LRAssessIndexP where indexcode='"+ssrs.GetText(1,1)+"' and agentgrade = '"+agentgrade+"'  and basecode = '"+BaseCode+"' and indextype = '"+tIndextype+"'";
				ssrs = exe.execSQL(sql);
				if(ssrs.GetText(1,1).equals("Y")){
					result.append("icon:'./iCandy/img/srule.png',");
					result.append("calprpty:'Y',");
				}else{
					result.append("icon:'./iCandy/img/rule.png',");
				}
			    result.append("indextype:'"+tIndextype+"'");
			    result.append("}");
		        result.append("]");
			}
		  }
		}else if (tCode.substring(0,1).equals("R")){
				String [] result1 = LRAssessIndexLibraryUtil.getChildren(tCode);
				result.append("[");
				for(int i=0;i<result1.length;i++)
				if(result1[i].startsWith("R")) {
						k++;
						if(k > 1) {
							result.append(",");
						}
						result.append("{");
						result.append("code:'").append(result1[i]).append("',");	
						String sql="select max(indexname),max(calprpty) from LRAssessIndexP where indexcode='"+result1[i]+"' and basecode = '"+BaseCode+"' and agentgrade = '"+agentgrade+"' and indextype = '"+tIndextype+"' ";
						ssrs = exe.execSQL(sql);
						result.append("name:'").append(ssrs.GetText(1,1)).append("',");	
						result.append("agentgrade:'").append(agentgrade).append("',");	
						result.append("parent:'"+tCode+"',");
						result.append("nocheck :true,");
						String[] r=LRAssessIndexLibraryUtil.getChildren(result1[i]);
						for(int j=1;j<r.length;j++){
							if(r[j].startsWith("R")){
								result.append("isParent:'true',");
							}
						}
						if(ssrs.GetText(1,2).equals("Y")){
							result.append("icon:'./iCandy/img/srule.png',");
						}else{
							result.append("icon:'./iCandy/img/rule.png',");
						}
						result.append("indextype:'"+tIndextype+"'");
						result.append("}");
					}				 
					result.append("]");
				}else{	
				 String sql ="";
	        	 sql = "select wagename,wagecode,indexcode from LRIndexVsCommP where  basecode='"+BaseCode+"' and agentgrade='"+tCode+"' and indextype='"+tIndextype+"' order by wageorder asc";		      	       	      	       
				 ssrs = exe.execSQL(sql);				
				 result.append("[");
				 for(int i = 1; i <= ssrs.MaxRow; i++) {
				  String icon="icon:'./iCandy/img/term.png',";
					if(i > 1) {
						result.append(",");
					}
					result.append("{");
					result.append("code:'").append(ssrs.GetText(i, 2)).append("',");				
					result.append("name:'").append(ssrs.GetText(i, 1)).append("',");
					result.append("agentgrade:'").append(agentgrade).append("',");	
					if(null==ssrs.GetText(i, 3)||"".equals(ssrs.GetText(i, 3)))
					{
					    icon="icon:'./iCandy/img/norule.png',";
					}
					result.append(icon);
					result.append("parent:'"+tCode+"',");
					result.append("isParent:'true',");
					result.append("indextype:'"+tIndextype+"'");
					result.append("}");
				}				 
				result.append("]");
		}
	}
	
	System.out.println(result.toString()+"-------------------");	
	out.clear();
	out.write(ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(result.toString())));
%>