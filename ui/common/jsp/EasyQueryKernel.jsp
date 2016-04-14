<%@include file="../jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.lis.schema.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>

<%!
// 调用EasyQueryUI进行SQL语句提交和数据库查找，返回结果字符串strResult
public String easyQueryKernel(String strSql, String strStart) { 
  String strResult = "";
  String strError = "";
  Integer intStart = new Integer( String.valueOf( strStart ));
  //System.out.println("strSql:" + strSql +"|strStart:" +strStart);

  EasyQueryUI tEasyQueryUI = new EasyQueryUI();
  VData tVData = new VData();
  tVData.add( strSql );
  tVData.add( intStart );
  tEasyQueryUI.submitData( tVData, "QUERY||MAIN" );

  if( tEasyQueryUI.mErrors.needDealError()) {
	  strError = tEasyQueryUI.mErrors.getFirstError();
  } else {
	  tVData.clear() ;
	  tVData = tEasyQueryUI.getResult() ;
	  strResult = ( String )tVData.getObject( 0 );
	  System.out.println(strResult);
  }
  
  return strResult;
}
%>
