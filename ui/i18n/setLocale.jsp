<%@include file="../jsp/UsrCheck.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.Resource.bundle"%>
<%
String lang=request.getParameter("language");
String test=request.getParameter("test");
System.out.println("test:"+test);
System.out.println("language:"+lang);
Locale locale = Locale.getDefault();
String tLang="en";
if("zh".equals(lang))
{
	locale = Locale.SIMPLIFIED_CHINESE;
	tLang = "zh";
}else if("en".equals(lang))
{
	locale = Locale.ENGLISH;
	tLang = "en";
}else if("ja".equals(lang))
{
	locale = Locale.JAPANESE;
	tLang = "ja";
}else if("tr".equals(lang))
{
	locale = Locale.TAIWAN;
	tLang = "tr";
}
System.out.println("setLocalle.jsp:" + locale);
session.setAttribute("locale",locale);
//session.setAttribute("initLan",lang);
session.setAttribute("initLan",tLang);
bundle.initBundle();
String cookieName="lang";
Cookie cookie=new Cookie(cookieName, lang);
response.addCookie(cookie); 
System.out.println("select:"+locale.getLanguage());
%>


