<%@include file="../jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/easyQueryVer3/EasyQueryFunc.jsp"%>
<%
//程序名称：.jsp
//程序功能：sql编辑页面模版
//          SQLID和SQL是保留字
//创建日期：2006-04-25
//创建人  ：常亮
%>

<%
//必须在以下部分编辑SQL
if(SQLID.equals("CommonInput_1"))
{
	SQL="select Sysvarvalue from LDSysVar where Sysvar='CheckNewType'" ;
}

if(SQLID.equals("CommonInput_2"))
{
	SQL="select CertifyCode from LZCardTrack where Startno<='?TempFeeNo?' "
	     +"and Endno>='?TempFeeNo?' and Receivecom = concat('D','?Receivecom?') and StateFlag='0'"
	     +" and CertifyCode in(select CertifyCode from LMCertifyDes where CertifyClass2 = '0')";
}

if(SQLID.equals("CommonInput_3"))
{
	SQL="select Sysvarvalue from LDSysVar where Sysvar='CheckNewType'";
}

if(SQLID.equals("CommonInput_4"))
{
	SQL="select CertifyCode from LZCardTrack where Startno<='?PrtNo?' and Endno>='?PrtNo?' and Receivecom = concat('D','?Receivecom?') and StateFlag='0'";
}
%>

<%
System.out.println("InputSQL===:"+SQL);
request.setAttribute("EASYQUERYSQL",SQL);
%>