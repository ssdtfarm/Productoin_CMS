<%@include file="../common/jsp/UsrCheck.jsp"%>
<!--Root="../../" -->
<html>
<head>
<title>Sinosoft</title>
<script language="javascript">
	var intPageWidth=screen.availWidth;
	var intPageHeight=screen.availHeight;
	window.resizeTo(intPageWidth,intPageHeight);
	window.focus();
</script>
</head>
<!--<frameset rows="0,0,0,65,*" frameborder="no" border="1" framespacing="0" cols="*"> -->
<frameset name="fraMain" rows="0,0,0,0,*" frameborder="no" border="1" framespacing="0" cols="*">
<!--忙聽聡茅垄聵盲赂聨莽聤露忙聙聛氓聦潞氓聼聼-->
	<!--盲驴聺氓颅聵氓庐垄忙聢路莽芦炉氓聫聵茅聡聫莽職聞氓聦潞氓聼聼茂录聦猫炉楼氓聦潞氓聼聼氓驴聟茅隆禄忙聹聣-->
	<frame name="VD" src="../common/cvar/CVarData.html">
	
	<!--盲驴聺氓颅聵氓庐垄忙聢路莽芦炉氓聫聵茅聡聫氓聮聦WebServer氓庐聻莽聨掳盲潞陇忙聢路莽職聞氓聦潞氓聼聼茂录聦猫炉楼氓聦潞氓聼聼氓驴聟茅隆禄忙聹聣-->
	<frame name="EX" src="../common/cvar/CExec.jsp">
	
	<frame name="fraSubmit"  scrolling="yes" noresize src="about:blank" >
	<frame name="fraTitle"  scrolling="no" noresize src="" >
	<frameset name="fraSet" cols="0%,*,0%" frameborder="no" border="1" framespacing="0" rows="*">
		<!--猫聫聹氓聧聲氓聦潞氓聼聼-->
		<frame name="fraMenu" scrolling="yes" noresize src="">
		<!--盲潞陇盲潞聮氓聦潞氓聼聼-->
		<frame id="fraInterface" name="fraInterface" scrolling="auto" src="./LABaseRuleQuery.jsp">
    <!--盲赂聥盲赂聙忙颅楼茅隆碌茅聺垄氓聦潞氓聼聼-->
    <frame id="fraNext" name="fraNext" scrolling="auto" src="about:blank">
	</frameset>
</frameset>
<noframes>
	<body bgcolor="#ffffff">
	</body>
</noframes>
</html>
