<%@page import="com.sinosoft.lis.db.LDSysVarDB"%>
<%@include file="/i18n/language.jsp"%>
<%@ page  pageEncoding="UTF-8" contentType='text/html;charset=utf-8'  %>
<%
//******************************************************
// 程序名称：LogonSubmit.jsp
// 程序功能:：处理用户登录提交
// 最近更新人：DingZhong
// 最近更新日期：2002-10-15
//******************************************************
%>
<%@page import="com.sinosoft.lis.db.LDUserLogDB"%>
<%@page import="com.sinosoft.lis.encrypt.LisIDEA"%>
<%@page import="com.sinosoft.lis.logon.logoutUI"%>
<%@page import="com.sinosoft.lis.menumang.LDUserUI"%>
<%@page import="com.sinosoft.lis.pubfun.GlobalInput"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun"%>
<%@page import="com.sinosoft.lis.pubfun.PubFun1"%>
<%@page import="com.sinosoft.lis.schema.LDUserSchema"%>
<%@page import="com.sinosoft.utility.VData"%>
<%@page import="com.sinosoft.Resource.bundle"%>
<%@page import="java.util.*"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	boolean bSuccess = false;
	//用户名称和密码
	String UserCode = request.getParameter("UserCode");
	String keyword = request.getParameter("PWD");
	String ComCode = request.getParameter("ComCode");
	String ClientURL = request.getParameter("ClientURL");
	String Ip = request.getRemoteAddr();
	String ls;
	String title = bundle.getString("Loading…"); 
	String language=request.getParameter("language");
	
	if (keyword.length() == 0 || UserCode.length() == 0){
		bSuccess = false;
	}
	
	LisIDEA tIdea = new LisIDEA();
	keyword = tIdea.encryptStringNew(keyword);
	
	VData tVData = new VData();
	LDUserSchema tLDUserSchema = new LDUserSchema();
	tLDUserSchema.setUserCode(UserCode);
	tLDUserSchema.setPassword(keyword);
	tLDUserSchema.setComCode(ComCode);
	tVData.add(tLDUserSchema);
	
	LDUserUI tLDUserUI = new LDUserUI();
	bSuccess=tLDUserUI.submitData(tVData,"query");
	
	
	if(bSuccess == true){
		Locale locale = Locale.getDefault();
		String tLang="en";
		if("zh".equals(language)){
			locale = Locale.SIMPLIFIED_CHINESE;
			tLang = "zh";
		}else if("tr".equals(language)){
			locale = Locale.TAIWAN;
			tLang = "tr";
		}else if("en".equals(language)){
			locale = Locale.ENGLISH;
			tLang = "en";
		}else{
			%>
			<script language=javascript>
				alert("Unknow language："+language);
				parent.window.location ="../indexlis.jsp";
			</script>
			<%
			return;
		}
		if(null==locale||"".equals(locale)){
			locale = Locale.getDefault();
		}
		String cookieName="lang";
		Cookie cookie=new Cookie(cookieName,language);
		response.addCookie(cookie); 
		
		GlobalInput tG = new GlobalInput();
		tG.Operator = UserCode;
		tG.ComCode  = ComCode;
		tG.ManageCom = ComCode;
		tG.locale = locale;
		
		session.setAttribute("locale",locale);
		session.setAttribute("initLan",language);
		session.setAttribute("GI",tG);
		session.setAttribute("ClientURL",ClientURL);
		com.sinosoft.Resource.bundle.initBundle();
		
		LDUserLogDB tLDUserLogDB = new LDUserLogDB();
		String maxno = PubFun1.CreateMaxNo("LOGNO",10);
		tLDUserLogDB.setLogNo(maxno);
		tLDUserLogDB.setManageCom(ComCode);
		tLDUserLogDB.setOperator(UserCode);
		tLDUserLogDB.setLogContent(locale.toString());
		tLDUserLogDB.setCientIP(Ip);
		tLDUserLogDB.setMakeDate(PubFun.getCurrentDate());
		tLDUserLogDB.setMakeTime(PubFun.getCurrentTime());
		tLDUserLogDB.insert();
		System.out.println("Current title is "+title);
		out.print(title);
		System.out.println("completed clear data");
		Ip=ESAPI.encoder().encodeForJavaScript(Ip);
		UserCode=ESAPI.encoder().encodeForJavaScript(UserCode);
		ComCode=ESAPI.encoder().encodeForJavaScript(ComCode);
		%>
		<script language=javascript>
		if(parent.fraMain.rows == "0,0,0,0,*,0") {	
		  parent.fraMenu.window.location.href="./menu.jsp?userCode=<%=UserCode%>&comcode=<%=ComCode%>&IP=<%=Ip%>&expireFlag=0";
		}
		</script>
	<%
	}
	else{
		System.out.println("用户名/密码/管理机构输入不正确!");
		if("en".equals(language)){
	%>
			<script language=javascript>
			alert(""+"Username/Password/Administration has an inputted error or Username is invalid!");
			</script>
		<%
		}else if("zh".equals(language)){
		%>
			<script language=javascript>
			alert(""+"用户名/密码/管理机构输入不正确或者用户名无效!");
			</script>
		<%
		}else if("tr".equals(language)){
		%>
			<script language=javascript>
			alert(""+"用戶名/密碼/管理機構輸入不正確或者用戶名無效!");
			</script>
		<%
		}
		%>
	<script language=javascript>
	parent.window.location ="../indexlis.jsp";
	</script>
	<%} 
%>