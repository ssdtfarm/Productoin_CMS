<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="com.sinosoft.lis.pubfun.*" %>
<%@page import="com.sinosoft.utility.*" %>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
    String gToday = PubFun.getCurrentDate();
    GlobalInput tG=(GlobalInput)session.getValue("GI");
    String Termid = request.getParameter("Termid");
    String name = request.getParameter("name");
  String type = request.getParameter("type");
  String BomId = request.getParameter("BomId");


  
    //String tOperator = tG.Operator;
    //String tManageCom = tG.ManageCom;
    String tname = "";
	String remark = "";
	String remarkName = "";
	String textarea = "";
	String calculate = "";
	String calculateName = "";
	String attribute = "";
	String state = "";
    ExeSQL exe = new ExeSQL();
    String query = "select '','','','','','','','' from dual";
    query = "select name,DataType,(select codename from ldcode where codetype='ibrmscommandtype' and code =a.datatype),Convert(Text,CalSQL),CalType,(select codename from ldcode where codetype='calculate' and code =a.CalType),Attribute,state from lrterm a where id ='"+Termid+"'";
		SSRS tSSRS = exe.execSQL(query);
		if(tSSRS.MaxRow > 0) {
			 tname = tSSRS.GetText(1, 1);
			 remark = tSSRS.GetText(1, 2);
			 remarkName = tSSRS.GetText(1, 3);
			 textarea = tSSRS.GetText(1, 4).trim().replaceAll("\n", "").replaceAll("\r","");
; 
			 calculate = tSSRS.GetText(1, 5);
			 calculateName = tSSRS.GetText(1, 6);
			 attribute = tSSRS.GetText(1, 7);
			 state = tSSRS.GetText(1, 8);
		}
		System.out.println(textarea);
	
	  gToday=ESAPI.encoder().encodeForJavaScript(gToday);
	  Termid=ESAPI.encoder().encodeForJavaScript(Termid);
	  name=ESAPI.encoder().encodeForJavaScript(name);
	  type=ESAPI.encoder().encodeForJavaScript(type);
	  BomId=ESAPI.encoder().encodeForJavaScript(BomId);
	  
	tname = ESAPI.encoder().encodeForJavaScript(tname);
	remark = ESAPI.encoder().encodeForJavaScript(remark);
	remarkName = ESAPI.encoder().encodeForJavaScript(remarkName);
	textarea = ESAPI.encoder().encodeForJavaScript(textarea);
	calculate = ESAPI.encoder().encodeForJavaScript(calculate);
	calculateName = ESAPI.encoder().encodeForJavaScript(calculateName);
	attribute = ESAPI.encoder().encodeForJavaScript(attribute);
	state = ESAPI.encoder().encodeForJavaScript(state);
		
%>
<script type="text/javascript">
function initForms(){
    try{
        initfm();
        fm.all("BomId").value = '<%=BomId%>';  
            
        fm.all("TermId").value='<%=Termid%>';    
        //var strSQL = "select name,DataType,(select codename from ldcode where codetype='ibrmscommandtype' and code =a.remark),CalSQL,CalType,(select codename from ldcode where codetype='calculate' and code =a.CalType),Attribute from lrterm a where id ='"+fm.all("TermId").value+"'";        
				//var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
				//var s=decodeEasyQueryResult(strQueryResult);
        fm.all("Name").value='<%=tname%>';//s[0][0];
        fm.all("Remark").value='<%=remark%>';//s[0][1];     
        fm.all("RemarkName").value='<%=remarkName%>';//s[0][2];        
        fm.all("Calculate").value='<%=calculate%>';//s[0][4];       
        fm.all("CalculateName").value='<%=calculateName%>';//s[0][5]; 
        fm.all("State").value='<%=state%>';//s[0][4];       
        if(fm.all("Calculate").value=='01'){        
        	  $('.sql').show();	
        		fm.all("textarea").value = "<%=textarea%>";//s[0][3]; 
        }else if(fm.all("Calculate").value=='02'){         
        	  $('.att').show();
          	fm.all("Attribute").value='<%=attribute%>';//s[0][6];   
        }
        strSQL  = "select 1 from lrassessindexp where indexcode = '"+ fm.all("TermId").value+"'";
		var strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);
		var s=decodeEasyQueryResult(strQueryResult);
		if(s){
			fm.Remark.disabled=true;
		    fm.Calculate.disabled=true;
		}
       
        showOneCodeName('yesno', 'State', 'EndFlagName');
        //easyQueryParaGird();
        //easyQueryPhraseGird();
    }catch(ex){
        alert("LAAgentInputInit.jsp-->initForm"+I18NMsg('Alert_InitJspError'));
    }
}//initForm()
function initInpBoxfm(){
    try{
        fm.reset();
        //TODO- 这里写初始化页面的代码
    }catch(ex){
        alert("LRTermUpdateInit.jsp-->InitInpBoxfm"+I18NMsg('Alert_InitJspError'));
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
