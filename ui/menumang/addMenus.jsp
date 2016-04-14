
<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.schema.*"%>
<%@page import="com.sinosoft.lis.vschema.*"%>
<%@page import="com.sinosoft.lis.tb.*"%>
<%@page import="com.sinosoft.lis.menumang.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<SCRIPT src="menuGrp.js"></SCRIPT>
                         
<html>
<body>                                      


<script language="javascript">    
       
            parent.fraInterface.SelectMenuGrpGrid.setRowColData(<%=0%>,1,<%=0%>);
            parent.fraInterface.SelectMenuGrpGrid.setRowColData(<%=0%>,2,<%=439%>);               
</script> 	    
<%
  int index=0;
  int TempCount=0;    
  String tTempClassNum1[] = request.getParameterValues("unSelectMenuGrpGrid_tempNo");
  String tTempClassNum2[] = request.getParameterValues("SelectMenuGrpGridNo");
  String tNodeCode[] = request.getParameterValues("unSelectMenuGrpGrid_temp2");
  String tNodeName[] = request.getParameterValues("unSelectMenuGrpGrid_temp1");
  
//得到check列的数组
  String tChk[] = request.getParameterValues("InpunSelectMenuGrpGridChk");

  System.out.println("start adding..");
  
  if(tTempClassNum1==null)
      System.out.println("really start adding..");  
      
  if(tTempClassNum1!=null)//如果不是空纪录	
  {
   
   TempCount = tTempClassNum1.length; //记录数      
   int selectMenuNum = tTempClassNum2.length;
   System.out.println("Start Save Count="+TempCount);   
   while(index<TempCount)
    {
    	if(!tChk[index].equals("1")) {
    	    index++;
    	    continue;
    	}
    	int tCount=selectMenuNum-1;
    	String tNodeName=tNodeName[index];
    	String tNodeCode=tNodeCode[index];
    	tCount=ESAPI.encoder().encodeForJavaScript(Integer.toString(tCount));
    	tNodeName=ESAPI.encoder().encodeForJavaScript(tNodeName);
    	tNodeCode=ESAPI.encoder().encodeForJavaScript(tNodeCode);
//	System.out.println("Grid="+tTempClassNum1[index]);
//	System.out.println("Grid 1="+'tNodeName[index]');
//	System.out.println("Grid 2="+'tNodeCode[index]'); %>
<script language="javascript">    
            parent.fraInterface.selectMenuGrpGrid.addOne("SelectMenuGrpGrid");
            parent.fraInterface.selectMenuGrpGrid.setRowColData(<%=tCount%>,1,'<%=tNodeName%>');
            parent.fraInterface.selectMenuGrpGrid.setRowColData(<%=tCount%>,2,<%=tNodeCode%>);               
</script> 	    

	    
<%	selectMenuNum++;
	index=index+1;          
    }
   }
   
%>  

</html>
</body>