<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@include file="/i18n/language.jsp"%>
<%@page import="java.util.*" %>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
%>
<script type="text/javascript">
var sqlPart = " distinct(a.agentcode),isnull(b.SurName,'')+' '+isnull(b.GivenName,'')+' '+isnull(b.EnglishName,''),c.agentgrade,a.WageNo,'','',a.ManageCom,a.BaseCode,(case when indextype='01' then 'Compensation'  when indextype = '21' then 'Maintain Assessment' when indextype ='22' then 'Promotion Assessment' else 'Assessment Result' end)";
function initForms(){
    try{
        initfm();
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LAReportConInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initfm(){
    try{
        initInpBoxfm();
        //initBOMGird();
    }catch(re){
        alert("LAAgentInputInit.jsp-->InitFormfm"+I18NMsg('Alert_InitJspError'));
    }
}

var posIndex = {};
function initBOMGird(){
    var iArray = new Array();
    var i = 0;
    var IndexType = '01'; 
    var sql ;
    if(fm.ReportType.value != '01'){
    	  IndexType = '02';
    }
    var strSQL = "select wagename,wagecode,datatype  from lrindexinfo_test a where basecode = '"+fm.BaseVersion.value+"'"+ getWherePart('a.AgentGrade','AgentGrade')+getWherePart('a.WageNo','WageNo')+getWherePart('a.AgentCode','AgentCode')+getWherePart('a.ManageCom','ManageCom','like')+"  and indextype='"+IndexType+"' and mainindexflag ='Y' and indexcode  is not null group by wagecode,datatype,wagename order by wagecode";
    	if(IndexType=='02'){
    	strSQL = "select wagename,wagecode,datatype  from lrindexinfo_test a where basecode = '"+fm.BaseVersion.value+"'"+ getWherePart('a.AgentGrade','AgentGrade')+getWherePart('a.WageNo','WageNo')+getWherePart('a.AgentCode','AgentCode')+getWherePart('a.ManageCom','ManageCom','like')+" and indextype ='"+fm.ReportType.value+"' and mainindexflag ='Y' and indexcode  is not null group by wagecode,datatype,wagename order by wagecode";
    	}
   
	var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
	var s=decodeEasyQueryResult(strQueryResult);
	//20130916tangyj
	//判断不是主指标的项是规则还是词条
	var mainN;
	var sN;
	mainN = "select (select name from lrterm where id=a.indexcode union select indexname from lrassessindexlibrary  where indexcode=a.indexcode),indexcode,datatype  from lrindexinfo_test a where basecode = '"+fm.BaseVersion.value+"'"+ getWherePart('a.AgentGrade','AgentGrade')+getWherePart('a.WageNo','WageNo')+getWherePart('a.AgentCode','AgentCode')+getWherePart('a.ManageCom','ManageCom','like')+"  and indextype='"+IndexType+"' and mainindexflag ='N' and indexcode  is not null group by indexcode,datatype,wagename order by indexcode";

    var strQueryResultN= easyQueryVer3(mainN, 1, 0, 1);
	sN=decodeEasyQueryResult(strQueryResultN);
	
    try{
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("Text_MutLineSeqNo")%>"; //列名
        iArray[i][1]="30px"; //列宽
        iArray[i][2]=100; //列最大值
        iArray[i][3]=0; //是否允许输入，0表示不允许，1表示允许，2表示代码选择，3表示隐藏
        i++;
      	iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("Text_AgentCode")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("Text_AgentName")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        i++;
    	iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("Text_AgentGrade")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_StatisticMonth/Year")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("LeaderCode")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("LeaderName")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        i++
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("CompanyHierachy")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;  
        i++
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_BasicLaw")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;      
        i++
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_ReportType")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;     
        i++;    
        if(s!=null){
        	for(var k=0 ;k<s.length;k++){
                iArray[i]=new Array();
                iArray[i][0]=s[k][0];
                iArray[i][1]="60px";
                iArray[i][2]=100;
                iArray[i][3]=0;
                //eval("posIndex."+s[k][1]+"={pi:"+i+"}");
                //sqlPart+=",nvl(to_char(a."+s[k][1]+"),'')";
                i++;
                //sql = "select decode(a.datatype,'S',a.s,'N0',a.n0,'N2',a.n2,'N4',a.n4,'N6',a.n6,'D',a.d)  from lrindexinfo_test a where 1 = 1   and a.basecode = '"+fm.BaseVersion.value+"'"+ getWherePart('a.AgentGrade','AgentGrade')+getWherePart('a.WageNo','WageNo')+getWherePart('a.AgentCode','AgentCode')+getWherePart('a.ManageCom','ManageCom','like')+"  and a.indextype = '"+IndexType+"'   and a.indexcode = '"+s[k][1]+"' and agentcode = b.agentcode";
                //sql = "to_char(sum(case wagecode when '"+s[k][1]+"' then "+s[k][2]+" else null end)) "+s[k][1]+" /*"+s[k][0]+"*/";               
                sql = "CONVERT(varchar(100),sum(case wagecode when '"+s[k][1]+"' then "+s[k][2]+" else null end)) "+s[k][1];               
                sqlPart+=","+sql;
        	}
        }
//        	$.ajax({
//        		url:"./LAindexLoad.jsp",
//         		async:false,
//         		data:{basecode:BaseCode,indexcode:'',indextype:IndexType1,t:new Date().getTime()},
//         		success:function(data){
//         			alert("sussess");
// 		       		var obj = eval(data);
// 		           	for(var j=0;j<obj.length;j++){
// 		           	   var aCol = obj[j];
// 		           	   iArray[i]=new Array();
// 	                   iArray[i][0]=aCol.name;
// 	                   iArray[i][1]="60px";
// 	                   iArray[i][2]=100;
// 	                   iArray[i][3]=0;
// 	                   eval("posIndex."+aCol.code+"={pi:"+i+"}");
// 	                   sqlPart+=",nvl(to_char(a."+aCol.code+"),'')";
// 	                   i++;
// 	            	}
// 	            },
// 	            error: function (msg) { 
// 	            	alert("error");
// 	                alert(msg); 
//             }});
		
        if(sN!=null){
            
        	for(var k=0 ;k<sN.length;k++){
                iArray[i]=new Array();
                iArray[i][0]=sN[k][0];
                iArray[i][1]="60px";
                iArray[i][2]=100;
                iArray[i][3]=0;
                //eval("posIndex."+s[k][1]+"={pi:"+i+"}");
                //sqlPart+=",nvl(to_char(a."+s[k][1]+"),'')";
                i++;
                //sql = "select decode(a.datatype,'S',a.s,'N0',a.n0,'N2',a.n2,'N4',a.n4,'N6',a.n6,'D',a.d)  from lrindexinfo_test a where 1 = 1   and a.basecode = '"+fm.BaseVersion.value+"'"+ getWherePart('a.AgentGrade','AgentGrade')+getWherePart('a.WageNo','WageNo')+getWherePart('a.AgentCode','AgentCode')+getWherePart('a.ManageCom','ManageCom','like')+"  and a.indextype = '"+IndexType+"'   and a.indexcode = '"+s[k][1]+"' and agentcode = b.agentcode";
               //sql = "to_char(sum(case indexcode when '"+sN[k][1]+"' then "+sN[k][2]+" else null end))";
              //需要这样改才可以走通，具体原理，还不知道
               //sql = "(select to_char(sum(case indexcode when '"+sN[k][1]+"' then "+sN[k][2]+" else null end)) from lrindexinfo_test where 1=1 )"; 
               sql = "(select CONVERT(varchar(100),sum(case indexcode when '"+sN[k][1]+"' then "+sN[k][2]+" else null end)) from lrindexinfo_test where 1=1 )"; 
                       
                sqlPart+=","+sql;
        	}
        }
        if(IndexType=='02'){
        	iArray[i]=new Array();
            iArray[i][0]="<%=bundle.getString("C_AssessmentResult")%>";
            iArray[i][1]="40px";
            iArray[i][2]=100;
            iArray[i][3]=0;     
            i++; 
        }
        BOMGird = new MulLineEnter( "fm" , "BOMGird" );
        //这些属性必须在loadMulLine前
        BOMGird.mulLineCount = 3;
        BOMGird.displayTitle = 1;
        BOMGird.hiddenPlus = 1;
        BOMGird.hiddenSubtraction = 1;
        BOMGird.canChk = 0;
        BOMGird.canSel = 0;
        BOMGird.loadMulLine(iArray);
        count = i;
        
    }catch(ex){
        alert(ex);
    }
}

</script>
