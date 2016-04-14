
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=bundle.getString("G0000025796")%></title>
</head>


<script type="text/javascript">

    function chec(){
         
         //alert(document.form1.ta.value);
      if(document.form1.ta.value=="" ||document.form1.time.value=="")
        {
          myAlert("<%=bundle.getString("G0000025797")%>");
          return false;
        }
          document.form1.submit();
    }
</script>

<body style="MARGIN: 0px; FONT: 16px Tahoma, Verdana; SCROLLBAR-ARROW-COLOR: #5aa8da; SCROLLBAR-BASE-COLOR: #f1f9fe; ">

<form  name="form1" method=post action="setSave.jsp" >
<table width=800 border=0 align=center>
  <tr><td width=50% align=left>
<%=bundle.getString("G0000025798")%>
      </td>
      <td> <input type=text size=8 name ="time"><%=bundle.getString("G0000025799")%></td>
  </tr>
  <tr>
     <td align=center  align=left><%=bundle.getString("G0000025800")%>"<%=bundle.getString("G0000025672")%>"<%=bundle.getString("G0000025801")%><br>
<%=bundle.getString("G0000025802")%></td>
     
  
     <td align=center > <textarea name ="ta" id="ta" cols="80" rows="15"/></textarea></td>
  </tr>
  <tr><td align=center colspan=2> <input type="button"  value="<%=bundle.getString("G0000025803")%>" onclick="chec()" >
      <input type="button"  value="<%=bundle.getString("G0000025804")%>" onclick="reset();"></td>
  </tr>
  
 </table>

 </form>
</body>
</html>