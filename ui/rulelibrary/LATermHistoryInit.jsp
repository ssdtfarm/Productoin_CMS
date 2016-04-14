<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
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
        myAlert("<%=bundle.getString("G0000028403")%>-->"+"<%=bundle.getString("G0000032793")%>");
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        myAlert("<%=bundle.getString("G0000036922")%>-->"+"<%=bundle.getString("G0000035680")%>");
    }
}
function initfm(){
    try{
        initInpBoxfm();
        initAgentGird();
        easyQueryAgentGird();
    }catch(re){
        myAlert("LAAgentInputInit.jsp-->"+"<%=bundle.getString("G0000035681")%>");
    }
}
function initAgentGird(){
    var iArray = new Array();
    var i = 0;
    try{
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("M0000047081")%>"; //列名
        iArray[i][1]="30px"; //列宽
        iArray[i][2]=100; //列最大值
        iArray[i][3]=0; //是否允许输入，0表示不允许，1表示允许，2表示代码选择，3表示隐藏
        iArray[i][4]=''; //是否引用代码: null或者" "为不引用
        iArray[i][5]=i+"|"+0; //上面的列中放置引用代码中第几位值
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="edorno";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=3;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("G0000036048")%>";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("G0000036024")%>";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("M0000046723")%>";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("G0000031407")%>";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("G0000029804")%>";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="Effective Time";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        AgentGird = new MulLineEnter( "fm" , "AgentGird" );
        AgentGird.selBoxEventFuncName ="detail";
        //这些属性必须在loadMulLine前
        AgentGird.mulLineCount = 0;
        AgentGird.displayTitle = 1;
        AgentGird.hiddenPlus = 1;
        AgentGird.hiddenSubtraction = 1;
        AgentGird.canChk = 0;
        AgentGird.canSel = 1;
        AgentGird.loadMulLine(iArray);
    }catch(ex){
        myAlert(ex);
    }
}

</script>
