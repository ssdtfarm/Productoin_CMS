<%@include file="../jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@include file="./EasyQueryKernel.jsp"%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);


String strResult = "";
String IP = request.getRemoteAddr();
String tReferer = request.getHeader("Referer");//获得申请此页的url信息
//System.out.println(request.getHeader("Referer"));
String tHost = "http://" + request.getHeader("host");//获取应用的url信息
String tHost1 = "https://" + request.getHeader("host");//获取应用的url信息
//System.out.println(tHost);
String[] strParams = null;
String baoString = null;
try{
//校验请求此页面的url是否是应用框架内的页面
//System.out.println("tReferer:" + tReferer);
//System.out.println("tHost:" + tHost);
//System.out.println("tHost1:" + tHost1);
if(tReferer == null || (!tReferer.startsWith(tHost) && !tReferer.startsWith(tHost1)))
{
    System.out.println("不是一个地址的请求服务");
%>
<script language=javascript>
session = null;
try
{
    CollectGarbage();
}
catch(ex)
{
    alert(ex.message);
}
top.window.location ="../../indexlis.jsp";
</script>
<%
//  response.sendRedirect("../../indexlis.jsp");
}
else
{

    InputStream ins = request.getInputStream();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    int nChar = 0;

    nChar = ins.read();
    while( nChar != -1 ) {
        baos.write(nChar);
        nChar = ins.read();
    }
    // 关闭流
	ins.close();
    /* Kevin 2006-08-04
     * The default encoding used by XMLHTTP is UTF-8
     *
     * Pay attention, don't use getParameter().
     * Because that you have to encode the query string in application/x-www-form-urlencoded form in js
     * to make sure you can get the correct content here, and I can't find a method to encode Chinese
     * Character well in js, so I use getInputStream() instead.
     *
     * BTW: You can find VBScript that can perform this task in the internet.
     *
     */
    //String inString = ins.toString();
    baoString = baos.toString();
    
    strParams = new String(baos.toByteArray(), "UTF-8").split("&");
    // 关闭流
	baos.close();
	
    //设置request的接受字符集
    String strSql = strParams[0];
    String strStart =strParams[1];
    String strLargeFlag = strParams[2];
    String strLimitFlag = strParams[3];
    if(strSql.indexOf(".jsp")!=-1)
    {
    EasyQuerySql tEasyQuerySql=new EasyQuerySql();
    if (tEasyQuerySql.parsePara(strSql))
    {
    //System.out.println("EASYQUERY RAW SQL==="+strSql);
    String jspName=tEasyQuerySql.getJspName();
    //System.out.println("EASYQUERY JSP'S Name IS===="+jspName);
    request.setAttribute("EASYQUERYSQLID",tEasyQuerySql.getSqlId());
    for (int i = 0; i < tEasyQuerySql.getParaCount(); i++)
    {
        request.setAttribute(tEasyQuerySql.getParaName(i).toUpperCase(),tEasyQuerySql.getParaValue(i));
    }
  %>
  <jsp:include page="<%= jspName%>" />

  <%
    strSql=(String)request.getAttribute("EASYQUERYSQL");

    //System.out.println(strSql);
    strSql=tEasyQuerySql.convertToValue(strSql);
    //System.out.println("===EASYQUERY CONVERT SQL==="+strSql);
    }
    }
    try
    {
        strResult = easyQueryKernel(strSql, strStart, strLargeFlag, strLimitFlag);
    }
    catch(Exception ex)
    {
        System.out.println("easyQueryKernel throw Errors!\n" + "easyQuerySql:" + strSql +"\nStartRecord:" +strStart);
    }

    try
    {
        //做了一步特殊字符替换，可否考虑先判定是否含有特殊字符，然后再作处理
        //对于有回车的数据取出的可能性太小了
        if(strResult.indexOf("\"")!= -1 )
        {
            String strPath = application.getRealPath("config//Conversion.config");
            strResult = StrTool.Conversion(strResult, strPath);
        }
    }
    catch(Exception ex)
    {
        System.out.println("not found Conversion.config ");
    }
}
strResult=ESAPI.encoder().decodeForHTML(ESAPI.encoder().encodeForHTML(strResult));
%>
<%=strResult%>
<%}
catch(Exception e){
	e.printStackTrace();
	// 打印传入的参数
	//System.out.println("用户 "+IP+" 请求EasyQueryXML ——  "+tReferer+" —— "+inString);
	System.out.println("用户 "+IP+" 请求EasyQueryXML ——  "+tReferer+" —— 传递参数："+baoString);
	if(strParams != null){
		int len = strParams.length;
		for(int j = 0; j <len ; j ++){
			System.out.println("用户 "+IP+" 请求EasyQueryXML ——  "+tReferer+" ——  第 "+j+" 个参数 :"+strParams[j]);
		}
	}
}
%>