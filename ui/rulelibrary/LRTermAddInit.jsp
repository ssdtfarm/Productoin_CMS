<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@include file="/i18n/language.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");    
   String id= request.getParameter("id");
   
   id=ESAPI.encoder().encodeForJavaScript(id);
   
   System.out.println(id);
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();
        fm.all("BomId").value = '<%=id%>';
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LRTermAddInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initfm(){
    try{
        initInpBoxfm();
        //initPhraseGird();
        //initParaGird();
    }catch(re){
        alert("LAAgentInputInit.jsp-->InitFormfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initPhraseGird(){
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
        iArray[i][0]="短语类型";
        iArray[i][1]="10px";
        iArray[i][2]=100;
        iArray[i][3]=2;
        iArray[i][4]='phrase';
        iArray[i][5]=i+"|"+2;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="短语类型名称";
        iArray[i][1]="15px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Description")%>";
        iArray[i][1]="25px";
        iArray[i][2]=100;
        iArray[i][3]=1;
        i++;
        iArray[i]=new Array();
        iArray[i][0]="模板";
        iArray[i][1]="25px";
        iArray[i][2]=100;
        iArray[i][3]=1;
        i++;
        PhraseGird = new MulLineEnter( "fm" , "PhraseGird" );
        //这些属性必须在loadMulLine前
        PhraseGird.mulLineCount = 3;
        PhraseGird.displayTitle = 1;
        PhraseGird.hiddenPlus = 0;
        PhraseGird.hiddenSubtraction = 0;
        PhraseGird.canChk = 0;
        PhraseGird.canSel = 0;
        PhraseGird.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}
function initParaGird(){
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
        iArray[i][0]="参数名称";
        iArray[i][1]="20px";
        iArray[i][2]=100;
        iArray[i][3]=1;
        i++;
        iArray[i]=new Array();
        iArray[i][0]="参数类型";
        iArray[i][1]="20px";
        iArray[i][2]=100;
        iArray[i][3]=2;
        iArray[i][4]='ibrmscommandtype';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        ParaGird = new MulLineEnter( "fm" , "ParaGird" );
        //这些属性必须在loadMulLine前
        ParaGird.selBoxEventFuncName ="easyQueryPhraseGird";
        ParaGird.mulLineCount = 3;
        ParaGird.displayTitle = 1;
        ParaGird.hiddenPlus = 0;
        ParaGird.hiddenSubtraction = 0;
        ParaGird.canChk = 0;
        ParaGird.canSel = 0;
        ParaGird.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}

</script>
