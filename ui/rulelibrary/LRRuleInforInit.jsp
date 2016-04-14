<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@include file="/i18n/language.jsp"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
%>
<script type="text/javascript">
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
        alert("LRRuleInforInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initfm(){
    try{
        initInpBoxfm();
        initProGird();
        initRuleGird();
    }catch(re){
        alert("LAAgentInputInit.jsp-->InitFormfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initProGird(){
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
        iArray[i][0]="<%=bundle.getString("BOM_WageCode")%>";
        iArray[i][1]="60px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_WageName")%>";
        iArray[i][1]="70px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("C_Itemtype")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="项目系列";
        iArray[i][1]="20px";
        iArray[i][2]=100;
        iArray[i][3]=3;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;        
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Channel")%>";
        iArray[i][1]="90px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Status")%>";
        iArray[i][1]="50px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Operation")%>";
        iArray[i][1]="30px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        iArray[i][25]="UpdateAgent|<%=bundle.getString("C_Modify")%>";
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Operation")%>";
        iArray[i][1]="30px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        iArray[i][25]="Delete|<%=bundle.getString("C_Delete")%>";
        i++;
        ProGird = new MulLineEnter( "fm" , "ProGird" );
        //这些属性必须在loadMulLine前
        ProGird.selBoxEventFuncName ="easyQueryRuleGird";
        ProGird.mulLineCount = 0;
        ProGird.displayTitle = 1;
        ProGird.hiddenPlus = 1;
        ProGird.hiddenSubtraction = 1;
        ProGird.canChk = 0;
        ProGird.canSel = 1;
        ProGird.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}
function initRuleGird(){
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
        iArray[i][1]="60px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_RuleName")%>";
        iArray[i][1]="60px"; 
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Status")%>";
        iArray[i][1]="40px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;        
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Description")%>";
        iArray[i][1]="60px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Operation")%>";
        iArray[i][1]="30px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        iArray[i][25]="UpdateRule|<%=bundle.getString("C_Modify")%>";
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Operation")%>";
        iArray[i][1]="70px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        iArray[i][25]="editorRule|<%=bundle.getString("BOM_ModifyRule")%>";
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Operation")%>";
        iArray[i][1]="70px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        iArray[i][25]="editorPara|<%=bundle.getString("BOM_MakeParameter")%>";
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Operation")%>";
        iArray[i][1]="30px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        iArray[i][25]="DeleteRule|<%=bundle.getString("C_Delete")%>";
        i++;
        RuleGird = new MulLineEnter( "fm" , "RuleGird" );
        //这些属性必须在loadMulLine前
        RuleGird.mulLineCount = 0;
        RuleGird.displayTitle = 1;
        RuleGird.hiddenPlus = 1;
        RuleGird.hiddenSubtraction = 1;
        RuleGird.canChk = 0;
        RuleGird.canSel = 0;
        RuleGird.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}

</script>
