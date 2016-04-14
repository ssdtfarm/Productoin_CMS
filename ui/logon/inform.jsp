<%@include file="/i18n/language.jsp"%>

<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=bundle.getString("G0000025657")%></title>
<link href="../common/css/windows.css" type="text/css" rel="stylesheet">
<script language="javascript">
function closeWindow(){
  window.opener=null;
  window.close();
}
</script>
<style type="text/css">
<!-- .STYLE1 { font-size: 18px; font-weight: bold; }
	.STYLE6 {color: #999999;font-size: 14px; font-weight: bold; }
	-->
</style>
</head>
<body>
<form name="form1" method="post" action="">
  <table width="150" height="200" border="1" align="center" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
    <tr>
      <td width="149" align="center"><img src="../common/images/inform/b_sy.jpg" width="290" height="36"></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="6" align="center"><img src="../common/images/inform/information.jpg" width="190" height="29" align="left"></td>
    </tr>
    <tr>
      <td height="6" align="center"><table width="290" border="0" bordercolor="#E6F5F0">
        <tr bgcolor="#E6F5F0">
          <td width="110" rowspan="2" align="left"><span class="style6"><%=bundle.getString("G0000025658")%></span></td>
          <td width="190" align="left"><span class="style6"><%=bundle.getString("G0000025659")%></span></td>
        </tr>
        <tr>
          <td bgcolor="#E6F5F0" align="left"><span class="style6"><%=bundle.getString("G0000025660")%></span></td>
        </tr>
        <tr bgcolor="#E6F5F0">
          <td align="left"><span class="style6"><%=bundle.getString("G0000025661")%></span></td>
          <td align="left"><span class="style6"><a target="_blank" href="http://10.0.1.1">http://10.0.1.1</href></span></td>
        </tr>
        <tr bgcolor="#E6F5F0">
          <td align="left"><span class="style6"><%=bundle.getString("G0000025662")%>/span></td>
          <td align="left"><span class="style6"><a target="_blank" href="http://10.0.3.71:8018">http://10.0.3.71:8018</href></span></td>
        </tr>
        <tr bgcolor="#E6F5F0">
          <td align="left"><span class="style6"><%=bundle.getString("G0000025663")%></span></td>
          <td align="left"><span class="style6"><a target="_blank" href="http://10.0.3.15:8080">http://10.0.3.15:8080</href></span></td>
        </tr>
      </table>
    </tr>
  
    <tr>
      <td align="center"><img src="../common/images/inform/fileupload.jpg" width="190" height="29" align="left"></td>
    </tr>
    <tr>
      <td align="center"><table width="290" border="0">
        <tr bgcolor="#E6F5F0">
          <td width="110" align="left"><span class="style6"><%=bundle.getString("G0000025664")%></span></td>
          <td width="190"><!-- <a href="DownloadAction.jsp?url=operation" ><%=bundle.getString("waitForTran")%>/a> --><span class="style6"><%=bundle.getString("G0000025665")%></span></td>
        </tr>
        <tr bgcolor="#E6F5F0">
          <td align="left"><span class="style6"><%=bundle.getString("G0000025666")%></span></td>
          <td><a href="DownloadAction.jsp?url=filetemplete" ><%=bundle.getString("G0000025647")%></a><span class="style6">(<%=bundle.getString("G0000025667")%></span></td>
        </tr>
        <tr bgcolor="#E6F5F0">
          <td align="left"><span class="style6"><%=bundle.getString("G0000025668")%></span></td>
          <td><a href="DownloadAction.jsp?url=manager" ><%=bundle.getString("G0000025647")%></a><span class="style6">(<%=bundle.getString("G0000025669")%>)</span></td>
        </tr>
      </table>
      </td>
    </tr>
     <tr>
        <td colspan="3" align="right" background="../common/images/inform/open_line.jpg" class="unnamed2"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="85%">&nbsp;</td>
              <td><input type="button" value="<%=bundle.getString("G0000025670")%>"onclick="closeWindow();" width="77" height="31" border="0"></td>
            </tr>
        </table></td>
      </tr>
  </table>
</form>
</body>
</html>

