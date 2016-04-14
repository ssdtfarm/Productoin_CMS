<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
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
        var strSQL = "select indexcode,description from LRIndexVsCommP where WageCode ='"+fm.WageCode.value+"' and branchtype='1' and agentgrade='"+fm.AgentGrade.value+"'　and indextype='"+fm.IndexType.value+"'";
		var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
		var s=decodeEasyQueryResult(strQueryResult);
		fm.all('IndexCode').value=s[0][0];
		fm.all('Description').value=s[0][1];
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
        iArray[i][1]="50px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("C_RuleDescription")%>";
        iArray[i][1]="200px";
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
        RuleGrid.canSel = 1;
        RuleGrid.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}

</script>
