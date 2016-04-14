<%@include file="../jsp/UsrCheck.jsp"%>

<%@page contentType="application/msexcel;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.GlobalInput"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun"%>
<%@page import="com.sinosoft.utility.VData"%>
<%@page import="com.sinosoft.utility.SSRS"%>
<%@page import="com.sinosoft.utility.ExeSQL"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	response.setHeader("Content-disposition","attachment;filename=export.xls");
  GlobalInput tG = new GlobalInput();
  tG=(GlobalInput)session.getValue("GI");
  String tOperater=tG.Operator;
  String sql=(String)session.getValue("RESULT_SQL");
	ExeSQL eSQL = new ExeSQL();
	SSRS ssrs = (SSRS)eSQL.execSQL(sql);
	String[][] result = ssrs.getAllData();
	VData tConditionValue = (VData)session.getValue("RESULT_CONDITION_VALUE");

	int cols = 0;

  if(result!=null && result.length>0){
      cols = result[0].length;
  }
  //取得表头
	String[] tblHead = (String[])session.getValue("RESULT_HEAD");
	String[] tConditionName = (String[])session.getValue("RESULT_CONDITION_NAME");

	if(tConditionName.length != tConditionValue.size() ){
		System.out.println("页面输入域的名字与相应的输入域的值的个数不匹配，请检查js文件");
	}
	String tDate = (String)session.getValue("RESULT_DATE");
	String tUnit = (String)session.getValue("RESULT_UNIT");
  String title=  (String)session.getValue("RESULT_TITLE");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<%
StringBuffer sb=new StringBuffer();
sb.append("<table  cellpadding='0' cellspacing='0' width='100%' align='center'>");
sb.append("<tr><td><table  border=0 cellpadding=3 cellspacing=0 width='100%' align='center' style='border-collapse: collapse; border: medium none;font-size:12px'>");
sb.append("<tr valign='middle'>");
sb.append("<td align='center'  height='30' colspan="+ESAPI.encoder().encodeForHTML(Integer.toString(tblHead.length))+">");
sb.append("<font size=3><b>"+ESAPI.encoder().encodeForHTML(title)+"</b></font></td></tr> ");

sb.append("</table> </td> </tr>");
 sb.append("<tr><td>");
 sb.append("<table  border=1 cellpadding=3 cellspacing=0 width=100% align=center style='border-collapse: collapse; border: medium none;font-size:12px'>");
 if(tblHead != null && tblHead.length > 0){
   sb.append("<tr >");
   for(int col = 0;col<tblHead.length;col++){
     sb.append("<td colspan=1 >");
     sb.append("<div align='center'><strong>"+ ESAPI.encoder().encodeForHTML(tblHead[col])+"</strong></div></td>");
   }
   sb.append("</tr>");
 }
 // 打印
 out.print(sb);
 sb=null;
 //数据
 if(result != null){
   for(int row = 0;row<result.length;row++){
     sb=new StringBuffer();
      sb.append("<tr><td colspan=1 align=center>"+ESAPI.encoder().encodeForHTML(Integer.toString(row+1))+"</td>");
     for(int col = 0;col<result[row].length && col < tblHead.length;col++){
       String data = result[row][col];
       if(data == null || data.length() == 0||data.equals(" ")){
         data = "&nbsp;";
       }
        sb.append("<td colspan=1 style=\"mso-number-format:'\\@'\"");
       if(col>=0){
          sb.append(" align=center ");
       }
        sb.append(">"+ESAPI.encoder().encodeForHTML(data)+"</td>");
     }
      sb.append(" </tr>");
      out.print(sb);
      sb=null;
   }
 }
 tDate=ESAPI.encoder().encodeForHTML(tDate);
 tOperater=ESAPI.encoder().encodeForHTML(tOperater);
 %>
  </table>
  </td>
  <tr>
	</tr>	
 <table  border=0 cellpadding=3 cellspacing=0 width='100%' align='center' style='border-collapse: collapse; border: medium none;font-size:12px'>
				<tr valign=middle>
					<td align=left  height=20 colspan=1 ><b>制表日期</b>
					</td>
					<td align=left  height=20 colspan=1> <b><%=tDate%></b>
					</td>
				<tr valign=middle>
					<td align=left  height=20 colspan=1 ><b>制表人</b>
					</td>
					<td align=left  style="mso-number-format:'@'" height=20 colspan=1> <b><%=tOperater%></b>
					</td>
				</tr>
			</table> 
  </tr>
 </table>

<%
out.flush();
out.close();

  session.removeValue("RESULT_DATA");
  session.removeValue("RESULT_HEAD");
  session.removeValue("RESULT_TITLE");
  session.removeValue("RESULT_DATE");
  session.removeValue("RESULT_CONDITION_NAME");
  session.removeValue("RESULT_CONDITION_VALUE");
  session.removeValue("RESULT_SQL");
%>
