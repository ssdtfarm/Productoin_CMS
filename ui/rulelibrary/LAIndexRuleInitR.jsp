<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@include file="/i18n/language.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    
    String AgentGrade = request.getParameter("AgentGrade");
    String WageCode = request.getParameter("WageCode");
    String BaseCode = request.getParameter("BaseCode");
    String IndexType = request.getParameter("IndexType");
    
    AgentGrade=ESAPI.encoder().encodeForJavaScript(AgentGrade);
    WageCode=ESAPI.encoder().encodeForJavaScript(WageCode);
	BaseCode=ESAPI.encoder().encodeForJavaScript(BaseCode);
    IndexType=ESAPI.encoder().encodeForJavaScript(IndexType);
	
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();   
        fm.AgentGrade.value='<%=AgentGrade%>';
        fm.WageCode.value='<%=WageCode%>';
		fm.IndexType.value='<%=IndexType%>'; 
		fm.BaseCode.value='<%=BaseCode%>';
        var strSQL = "select agentgrade,(select c.gradename from laagentgrade c where c.gradecode=b.agentgrade),wagecode,wagename, indexcode,(select max(indexname) from  lrassessindexp a where a.indexcode = b.indexcode) from LRIndexVsCommP b where WageCode ='"+fm.WageCode.value+"' and basecode='"+fm.BaseCode.value+"'and branchtype=(select branchType from lrbase where basecode = '"+fm.BaseCode.value+"') and agentgrade='"+fm.AgentGrade.value+"'　and indextype='"+fm.IndexType.value+"'";
		var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
		var s=decodeEasyQueryResult(strQueryResult);
		if(s){
			fm.all('AgentGrade').value=s[0][0];
			fm.all('AgentName').value=s[0][1];
			fm.all('WageCode').value=s[0][2];
			fm.all('WageName').value=s[0][3];
			fm.all('IndexCode').value=s[0][4];
			fm.all('Description').value=s[0][5];			
		}
		//添加基本法以下状态不能处理规则信息
        var sql = "select basecode,status from lrbase where basecode='"+trim(fm.BaseCode.value)+"'";
		var arr = easyExecSql(sql);
		if(arr){
			//已经审核发布、停用、提请审核的基本法是不允许调整规则定制
			//alert(arr[0][1]);
			if(arr[0][1]=="02" || arr[0][1]=="04" || arr[0][1]=="06" ){
				fm.all("DivSaveClickInfo").style.display= "none";
			}else{
				fm.all("DivSaveClickInfo").style.display= "";
			}
		}else{
			alert("未查询到基本法编码为"+trim(fm.BaseCode.value)+"的相关信息！");
			return false;
		}
        itemQuery();
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LAIndexRuleInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initfm(){
    try{
        initInpBoxfm();
        initRuleGrid();
    }catch(re){
        alert("LAAgentInputInit.jsp-->InitFormfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initRuleGrid(){
    var iArray = new Array();
    var i = 0;
    try{
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("Text_MutLineSeqNo")%>"; //列名
        iArray[i][1]="30px"; //列宽
        iArray[i][2]=100; //列最大值
        iArray[i][3]=0; //是否允许输入，0表示不允许，1表示允许，2表示代码选择，3表示隐藏
        iArray[i][4]=''; //是否引用代码: null或者" "为不引用
        iArray[i][5]=i+"|"+0; //上面的列中放置引用代码中第几位值
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_RuleCode")%>";
        iArray[i][1]="20px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_RuleName")%>";
        iArray[i][1]="20px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("C_RuleDescription")%>";
        iArray[i][1]="20px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        RuleGrid = new MulLineEnter( "fm" , "RuleGrid" );
        //这些属性必须在loadMulLine前
        RuleGrid.mulLineCount = 0;
        RuleGrid.displayTitle = 1;
        RuleGrid.hiddenPlus = 1;
        RuleGrid.hiddenSubtraction = 1;
        RuleGrid.canChk = 0;
        RuleGrid.canSel = 0;
        RuleGrid.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}

</script>
