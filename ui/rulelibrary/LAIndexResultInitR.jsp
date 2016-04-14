<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@include file="/i18n/language.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    String AgentGrade = request.getParameter("AgentGrade");    
	String IndexType = request.getParameter("IndexType");
	String BaseCode = request.getParameter("BaseCode");
	String BranchType = request.getParameter("BranchType");
	
	AgentGrade=ESAPI.encoder().encodeForJavaScript(AgentGrade);
	IndexType=ESAPI.encoder().encodeForJavaScript(IndexType);
	BaseCode=ESAPI.encoder().encodeForJavaScript(BaseCode);
	BranchType=ESAPI.encoder().encodeForJavaScript(BranchType);
	
    System.out.println("la--->"+AgentGrade);
    System.out.println("branchtype--->" + BranchType);
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();
        fm.AgentGrade.value='<%=AgentGrade%>';
		fm.IndexType.value='<%=IndexType%>';
		fm.BaseCode.value='<%=BaseCode%>'; 
		fm.BranchType.value = '<%=BranchType%>';
        var sql = "select basecode,status from lrbase where basecode='"+trim(fm.BaseCode.value)+"'";
		var arr = easyExecSql(sql);
		if(arr){
			//已经审核发布、停用、提请审核的基本法是不允许调整规则定制
			//alert(arr[0][1]);
			if(arr[0][1]=="02" || arr[0][1]=="04" || arr[0][1]=="06" ){
				fm.remove.disabled = true;
				fm.add.disabled = true;
			}else{
				fm.remove.disabled = false;
				fm.add.disabled = false;
			}
		}else{
			alert("未查询到基本法编码为"+trim(fm.BaseCode.value)+"的相关信息！");
			return false;
		}
        easyQueryRuleGrid();
        easyQueryIndexGrid();        
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LAIndexInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initfm(){
    try{
        initInpBoxfm();
        initIndexGrid();
        initRuleGrid();
    }catch(re){
        alert("LAAgentInputInit.jsp-->InitFormfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initIndexGrid(){
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
        iArray[i][0]="<%=bundle.getString("BOM_WageName")%>";
        iArray[i][1]="13px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_WageCode")%>";
        iArray[i][1]="13px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
      
        IndexGrid = new MulLineEnter( "fm" , "IndexGrid" );
        //这些属性必须在loadMulLine前
        IndexGrid.mulLineCount = 10;
        IndexGrid.displayTitle = 1;
        IndexGrid.hiddenPlus = 1;
        IndexGrid.hiddenSubtraction = 1;
        IndexGrid.canChk = 0;
        IndexGrid.canSel = 0;
        IndexGrid.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
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
        iArray[i][0]="<%=bundle.getString("BOM_WageName")%>";
        iArray[i][1]="13px";
        iArray[i][2]=100;
        iArray[i][3]=1;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_WageCode")%>";
        iArray[i][1]="13px";
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
