<%@include file="../jsp/UsrCheck.jsp"%>

<%@page import="com.sinosoft.createxml.PubFunToCM"%>
<%@page import="com.sinosoft.utility.*"%><%
//程序名称：EasyScanQuery.jsp
//程序功能：扫描件显示
//创建日期：2002-09-28 17:06:57
//创建人  ：胡博
//更新：刘强 2005-03-27	修改查询接口
//更新记录：  更新人    更新日期     更新原因/内容
%>

<html>
<head>
<META   HTTP-EQUIV="imagetoolbar"   CONTENT="no"> 
<SCRIPT src="../javascript/Common.js" ></SCRIPT>
<%@include file="./EasyScanQueryKernel.jsp"%>

<%@include file="../../bq/PEdorAppFloatInput.jsp"%>
<SCRIPT src="../../bq/PEdorAppFloatInput.js"></SCRIPT>  
 

<LINK href="../css/Project.css" rel=stylesheet type=text/css>
<%@page contentType="text/html;charset=UTF-8" %>

<SCRIPT src="./ShowPicControl.js"></SCRIPT>
<SCRIPT>window.document.onkeydown = document_onkeydown;</SCRIPT>
<SCRIPT src="./DebugAutoMove.js"></SCRIPT>

</head>

<%

//增加分支：根据类型判断 "QueryType" 
//	QueryType=0 表示通过DocId查询        easyScanQueryKernel0()
//	QueryType=1 表示通过一个号码关联查询 easyScanQueryKernel()
//	QueryType=2 表示通过两个号码关联查询 easyScanQueryKernel2()

String queryType  = request.getParameter("QueryType");
String DocID      = request.getParameter("DocID");
System.out.println("#####################");
System.out.println("##########queryType###########====" + queryType);
System.out.println("#####################");
System.out.println("###########DocID##########=====" + DocID); 
System.out.println("#####################"); 

String BussNo     = request.getParameter("prtNo");
String BussNoType = request.getParameter("BussNoType");
String BussType   = request.getParameter("BussType");
String SubType    = request.getParameter("SubType");
System.out.println("ceshi by zhaopeng"+SubType);
String BussNo2     = request.getParameter("BussNo2");
String BussNoType2 = request.getParameter("BussNoType2");
String BussType2   = request.getParameter("BussType2");
String SubType2    = request.getParameter("SubType2");

String clientUrl = (String)session.getValue("ClientURL");	//LQ 2004-04-20
System.out.println("ClientUrl=" + clientUrl);			//LQ 2004-04-20
	
System.out.println("\n---EasyScanQuery Start--- queryType:" + queryType);
String[] arrPic = null;
if (queryType == null)
{
  System.out.println("ok");
	arrPic = easyScanQueryKernel1(BussNo,BussNoType,BussType,SubType,clientUrl);
}
else if (queryType.equals("0"))
{
	arrPic = easyScanQueryKernel0(DocID,clientUrl);
}else if (queryType.equals("1")) 
{
	arrPic = easyScanQueryKernel1(BussNo,BussNoType,BussType,SubType,clientUrl);
}else if (queryType.equals("2"))
{
	arrPic = easyScanQueryKernel2(BussType,BussNoType,BussType2,BussNoType2,BussType,SubType,clientUrl);
}else if (queryType.equals("3"))
{
	arrPic = easyScanQueryKernel3(BussNo,BussNoType,BussType,SubType,clientUrl);
}
else if (queryType.equals("4"))
{
	arrPic = easyScanQueryKernel4(BussNo,BussNoType,BussType,"",clientUrl);
}
//Added by niuzj 20060926,新华历史单证扫描影像查询
else if (queryType.equals("9999"))
{
	arrPic = easyScanQueryKernel9999(DocID,clientUrl);
}

System.out.println("---EasyScanQuery End---\n\n");

if (arrPic != null) {
%>

<body border="0">

<!-- 显示提示文字 -->
<font color=red style="font-size:9pt;"><center id="centerPic" class=common></center></font>

<!-- 使用该DIV类可以控制图片的显示方向 -->
<DIV ID="filterDIV" STYLE="position:absolute;
filter:progid:DXImageTransform.Microsoft.BasicImage(grayscale=0, xray=0, mirror=0, invert=0, opacity=1, rotation=0)">
<img galleryImg="no" border="0" id="service" src="">
</DIV>

<!---->
<span id="spanPosition"  style="display: 'none'; position:absolute; slategray">
  <img border="0" id="Rect" src="./frame.GIF" style="filter:alpha(opacity=40)">
  <br>
  <Input class= common6 name="RectCont"  readonly STYLE="display:'none'">
</span>

</body>
</html>

<script>

try { 
  //获取每个图片的完整URL信息
  var arrPicName = new Array();
  <%for (int i=0; i<arrPic.length; i++) {%>
    arrPicName[<%=i%>] = '<%=arrPic[i]%>';
  <%}%>
  //将存有文件路径的数组传递给图片控制的桢
  window.top.fraInterface.pic_name = arrPicName;
  //显示第一幅图片
  window.service.src = arrPicName[0]; 
  //显示文件路径和名称，也用于提示文件不存在
  window.centerPic.innerHTML = "PageDown:下一页 | PageUp:上一页 | Ctrl和+:放大图片 | Ctrl和-或/:缩小图片| End:旋转图片 | *:恢复原图 | Ctrl和方向键（数字键盘，NumLock）:控制图片窗口 | Alt和方向键:控制录入窗口";
  var prtNo = "<%=BussType%>"; 
  
  var BussNo = "<%=BussNo%>"; 
  //获取扫描图片类型
  //alert("queryScanType:" + top.queryScanType());
  if(prtNo == 'BQ'){
  
  <%
  	PubFunToCM pubFunToCM = new PubFunToCM();
  	String signurl = "";
  	String sql1= "select edortype,contno from lpedoritem where edoracceptno='"+BussNo+"'";
  	ExeSQL exeSQL = new ExeSQL();
  	SSRS ssrs1 = exeSQL.execSQL(sql1);
  	if(ssrs1!=null && ssrs1.getMaxRow()>0){
  		String edortype = ssrs1.GetText(1,1);
  		String contno =  ssrs1.GetText(1,2);
  		if(edortype.equals("BC")||edortype.equals("LA")||edortype.equals("MG")){
  			sql1 = "select contno,clientno,cutname,version from es_cut_save a where a.contno='"+contno+"' and version=(select max(version) from es_cut_save where contno=a.contno) and cutname='insuredno'";
  		}else{
  			sql1 = "select contno,clientno,cutname,version from es_cut_save a where a.contno='"+contno+"' and version=(select max(version) from es_cut_save where contno=a.contno) and cutname='appntno'";
  		}
  		ssrs1 = exeSQL.execSQL(sql1);
  		if(ssrs1!=null && ssrs1.getMaxRow()>0){
  			String clientno= ssrs1.GetText(1,2);
  			String cutname = ssrs1.GetText(1,3);
  			String version = ssrs1.GetText(1,4);
  			signurl = pubFunToCM.signSearch(contno,clientno,cutname,version); 
  		}
  		if(signurl!=null&&!signurl.equals("")){
  	%>
				
			document.getElementById("ImgUrl").src="<%=signurl%>";
			floater.style.display = "block";
	<%
  		}
  	}
  %>
  	//此处添加保全签名变更的图片 by cgn 2011-03-07
  	
  	
  	var arrEdorInfo = top.queryfloat(BussNo);
  	//var arrEdorInfo = top.easyExecSql("select 1 from dual");
  	//var arrEdorInfo = top.easyExecSql("select 1 from dual");
  	
  	
 
  	var signsql="";
  	if(arrEdorInfo!=null){
  	
  		if(arrEdorInfo[0][0]=="BC"||arrEdorInfo[0][0]=="LA"||arrEdorInfo[0][0]=="MG"){
  			signsql="select imgurl,version,cutname from es_cut_save a where a.contno='"+arrEdorInfo[0][1]+"' and version=(select max(version) from es_cut_save where contno=a.contno) and cutname='insuredno'";
  		}else{
  			signsql="select imgurl,version,cutname from es_cut_save a where a.contno='"+arrEdorInfo[0][1]+"' and version=(select max(version) from es_cut_save where contno=a.contno) and cutname='appntno'";
  		}
  		/*
  		var url=top.queryphoto(signsql);
  		if(url!=""){
  			document.getElementById("ImgUrl").src="<%=signurl%>";
			floater.style.display = "block";
  		}
  		*/
  		
		
  	}
 
  	
  	
  }
  else{
  var arrResult = top.queryScanType();
  //alert(5);
  for (i=0; i<arrResult.length; i++) {
    if (prtNo.substring(2,4) == arrResult[i][0]) { 
      goToPic(arrResult[i][1]);
      try { top.fraInterface.fm.all(arrResult[i][2]).focus(); } catch(e) {}
    }
  }
  }
  
  ////显示第二幅图片，先显示险种信息
  //if (prtNo.substring(2,4) == "11") { //个人
  //  goToPic(1);
  //  try { top.fraInterface.fm.all("RiskCode").focus(); } catch(e) {}
  //}
  //if (prtNo.substring(2,4) == "15") { //银行
  //  goToPic(0);
  //  top.fraPic.scrollTo(0, 1010);
  //}
  //if (prtNo.substring(2,4) == "12")   //团体
  //  try { top.fraInterface.fm.all("GrpProposalNo").focus(); } catch(e) {}
  
} catch(ex) { 
  //alert("EasyScanQuery.jsp:" + ex); 
  //alert(1111);
  window.centerPic.innerHTML = "该扫描件图片不存在";
}

	//window.focus();
</script>

<%
}
else {  
%>
<body border="0">
<center id="centerPic">该印刷号对应的扫描件图片不存在</center>
</body>

<%
}
%>

<script>
  try {
    if (top.fraInterface.LoadFlag == "99") {
      window.document.body.onmousemove = mouseMove;
      window.document.body.onmousedown = mouseDown;
    }
  } catch(e) {}
</script>