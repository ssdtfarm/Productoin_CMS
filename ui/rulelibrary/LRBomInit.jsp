<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@include file="/i18n/language.jsp"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
    String lang = session.getAttribute("locale").toString();
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
        alert("LRBomInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initfm(){
    try{
        initInpBoxfm();
        initBOMGird();
        initTermGird();
        fm.all("lang").value = '<%=lang%>';
    }catch(re){
        alert("LAAgentInputInit.jsp-->InitFormfm"+I18NMsg('Alert_InitJspError'));
    }
}
function initBOMGird(){
    var iArray = new Array();
    var i = 0;
    try{
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("Text_MutLineSeqNo")%>"; //列名
        iArray[i][1]="50px"; //列宽
        iArray[i][2]=100; //列最大值
        iArray[i][3]=0; //是否允许输入，0表示不允许，1表示允许，2表示代码选择，3表示隐藏
        iArray[i][4]=''; //是否引用代码: null或者" "为不引用
        iArray[i][5]=i+"|"+0; //上面的列中放置引用代码中第几位值
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_BOMCode")%>";
        iArray[i][1]="60px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_BOMName")%>";
        iArray[i][1]="65px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Channel")%>";
        iArray[i][1]="65px";
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
        iArray[i][25]="UpdateBom|<%=bundle.getString("C_Modify")%>";
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
        BOMGird = new MulLineEnter( "fm" , "BOMGird" );
        //这些属性必须在loadMulLine前
        
        BOMGird.selBoxEventFuncName ="easyQueryTermGird";
        BOMGird.mulLineCount = 0;
        BOMGird.displayTitle = 1;
        BOMGird.hiddenPlus = 1;
        BOMGird.hiddenSubtraction = 1;
        BOMGird.canChk = 0;
        BOMGird.canSel = 1;
        BOMGird.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}
function initTermGird(){
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
        iArray[i][0]="<%=bundle.getString("BOM_ItemCode")%>";
        iArray[i][1]="60px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_ItemName")%>";
        iArray[i][1]="100px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_DataType")%>";
        iArray[i][1]="80px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Status")%>";
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
        iArray[i][25]="UpdateTerm|<%=bundle.getString("C_Modify")%>";
        i++;
        iArray[i]=new Array();
        iArray[i][0]="<%=bundle.getString("BOM_Operation")%>";
        iArray[i][1]="30px";
        iArray[i][2]=100;
        iArray[i][3]=0;
        iArray[i][4]='';
        iArray[i][5]=i+"|"+0;
        iArray[i][6]='0|1';
        iArray[i][25]="DeleteTerm|<%=bundle.getString("C_Delete")%>";
        TermGird = new MulLineEnter( "fm" , "TermGird" );
        //这些属性必须在loadMulLine前
        TermGird.mulLineCount = 0;
        TermGird.displayTitle = 1;
        TermGird.hiddenPlus = 1;
        TermGird.hiddenSubtraction = 1;
        TermGird.canChk = 0;
        TermGird.canSel = 0;
        TermGird.loadMulLine(iArray);
    }catch(ex){
        alert(ex);
    }
}

</script>
