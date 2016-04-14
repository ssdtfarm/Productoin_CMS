<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.Resource.bundle"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.rulelibrary.*"%>
<%
	String json1=request.getParameter("json");
	System.out.println("json---------------:"+json1);
	request.setCharacterEncoding("UTF-8");
	String oper=request.getParameter("oper");
//	String object;
//	String lang = session.getAttribute("locale").toString();
//	if("zh_CN".equals(lang)){
//		object = "Editor_cn";
//	}else if("zh_TW".equals(lang)){
//		object = "Editor_tr";
//	}else if("en".equals(lang)){
//		object = "Editor";
//	}else {
//		object = "Editor";
//	}
	
//	Class<?> demo=null;
//	demo=Class.forName("com.sinosoft.lis.rulelibrary."+object);
//    Object obj1 = demo.newInstance();
	
	if("saverule".equals(oper)){
		String indexcode=request.getParameter("indexcode");
	    String json=request.getParameter("json");
	    System.out.println("json---------------:"+json);
	    String indexset=request.getParameter("indexset");
	    String ths=request.getParameter("ths");
	    String sql=request.getParameter("sql");
	    //if(!Editor.createView(indexcode,ths)){
		  //  out.clear();
		  //  out.write("生成决策表时失败！");
		  //  return;
	  	//}
	  	
		if(!Editor_cn.saveRule(indexcode,indexset,json,sql)){
	  		out.clear();
		    out.write(bundle.getString("Datasavefailed!"));
		    return;
	    }
		
	   	  out.clear();
		  out.write(bundle.getString("Savesuccessful!"));
	} else if("savepara".equals(oper)){
		String basecode=request.getParameter("basecode");
		String wagecode=request.getParameter("wagecode");
		String indexcode=request.getParameter("indexcode");
		String agentgrade=request.getParameter("agentgrade");
		String indextype =  request.getParameter("indextype");
	   //String para=request.getParameter("para");
	   String json=request.getParameter("json");
	   String ifthenpara=request.getParameter("ifthenpara");
	   String elsepara=request.getParameter("elsepara");
	   boolean flag = true;
	   System.out.println("json----->"+json);
	   System.out.println("basecode----->"+basecode);
	   System.out.println("json----->"+json);
	   System.out.println("basecode----->"+basecode);
	   if(basecode.equals("")||null==basecode||basecode.equals("null")){
		   flag = Editor_cn.savePara(indexcode,ifthenpara,elsepara,json);
	   }else{
		   System.out.println("indextype----->"+indextype);
		   flag = Editor_cn.savePara(basecode,indexcode,ifthenpara,elsepara,json,agentgrade,indextype);
	   }
	   if(!flag){
		    out.clear();
		    out.write(bundle.getString("Parametersaveprocesshasanerror!"));
		    return;
	  } 
	  out.clear();
	  out.write(bundle.getString("Savesuccessful!"));
	}else if("sflag".equals(oper)||"qflag".equals(oper)){
		String basecode=request.getParameter("basecode");
		String indexcode=request.getParameter("indexcode");
		String agentgrade=request.getParameter("agentgrade");
		String indextype =  request.getParameter("indextype");
	    boolean flag = true;
		flag = Editor_cn.setFlag(basecode,indexcode,agentgrade,indextype,oper);
	    if(!flag){
		    out.clear();
		    out.write(bundle.getString("Parametersaveprocesshasanerror!"));
		    return;
	    } 
	   out.clear();
	   out.write(bundle.getString("Savesuccessful!"));
	}
%>
