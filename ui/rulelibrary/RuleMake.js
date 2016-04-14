var countcase = 0;
var countif = 0;

function submitData() {
//alert(SQLStatement);         
   var fm1 = document.getElementById('fm1');      //jiahy add 2010-09-03 获得默认值            
  if (flag == 1 || flag == 2) {
		var fm = document.getElementById('fm');
		var dataArray = getData();//此函数在 dicisionTable.js
		if (!dataArray)
			return;
		var Json=dataArrayToJson(dataArray);
    
		var realJson={"rows":Json};
		
		fm.DTData.value = Ext.util.JSON.encode(realJson);
		fm.SQLStatement.value =SQLStatement;
		fm.CreateTable.value =CreateTable;
		fm.ViewPara.value =ViewPara;
		fm.BOMS.value = BOMSArray;
		fm.SQLPara.value = SQLParaArray;
		fm.RuleCh.value = RuleDesInCh;
		fm.ColumnDataType.value=ColumnDataTypeArray;
		fm.TableColumnName.value=TableColumnNameArray;
		fm.Types.value = ColumnDataTypeArray;
		fm.WageYear1.value = fm1.WageYear.value;
		
		fm.submit();
	}
	if (flag == 4) {
		var fm = document.getElementById('fm');
		var op = fm.Operation.value;
		if ((op==null || op=='') && op != "Logic_Modification") {
			var dataArray = getData();
			if (!dataArray)
				return;
			
			var Json=dataArrayToJson(dataArray);
			
			var realJson={"rows":Json};
					
			fm.DTData.value = Ext.util.JSON.encode(realJson);
			
			fm.ColumnDataType.value = ColumnDataTypeArray;
			fm.TableColumnName.value=TableColumnNameArray;
			fm.WageYear1.value = fm1.WageYear.value;
			fm.submit();
		} else {
      var fm = document.getElementById('fm');
			var dataArray = getData();
			if (!dataArray)
				return;
			
			var Json=dataArrayToJson(dataArray);
			
			var realJson={"rows":Json};
					
			fm.DTData.value = Ext.util.JSON.encode(realJson);

			fm.SQLStatement.value =SQLStatement;
			fm.CreateTable.value =CreateTable;
			fm.ViewPara.value =ViewPara;
			fm.BOMS.value = BOMSArray;
			fm.SQLPara.value = SQLParaArray;
			fm.RuleCh.value = RuleDesInCh;
			fm.ColumnDataType.value=ColumnDataTypeArray;
			fm.TableColumnName.value=TableColumnNameArray;
      fm.WageYear1.value = fm1.WageYear.value;
			fm.submit();
		}
	}
}


//jiahy add 20100916
function addCase(){
	 if(countif==0 && flag==4){
	      var ruleNodes = document.getElementById("RuleZone");	
	      var firstNode = ruleNodes.firstChild;
	      var endNode = ruleNodes.lastChild;
	      var i=0;
	      while(firstNode != endNode) {
	       	i++;
	        firstNode = firstNode.nextSibling;
	      }
	      if(i>0){
	      	 countcase = 0;
	      } 
	      
	      var ruleNodes3 = document.getElementById("RuleZone3");	
	      var firstNode3 = ruleNodes3.firstChild;
	      var endNode3 = ruleNodes3.lastChild;
	      var i=0;
	      while(firstNode3 != endNode3) {
	       	i++;
	        firstNode3 = firstNode3.nextSibling;
	      }
	      if(i>0){
	      	 countcase = 1;
	      } 
	      
	      var ruleNodes5 = document.getElementById("RuleZone5");	
	      var firstNode5 = ruleNodes5.firstChild;
	      var endNode5 = ruleNodes5.lastChild;
	      var i=0;
	      while(firstNode5 != endNode5) {
	       	i++;
	        firstNode5 = firstNode5.nextSibling;
	      }
	      if(i>0){
	      	 countcase = 2;
	      }
//	      
//	      var ruleNodes7 = document.getElementById("RuleZone7");	
//	      var firstNode7 = ruleNodes7.firstChild;
//	      var endNode7 = ruleNodes7.lastChild;
//	      var i=0;
//	      while(firstNode7 != endNode7) {
//	       	i++;
//	        firstNode7 = firstNode7.nextSibling;
//	      }
//	      if(i>0){
//	      	 countcase = 3;
//	      }
//	      
//	      var ruleNodes9 = document.getElementById("RuleZone9");	
//	      var firstNode9 = ruleNodes9.firstChild;
//	      var endNode9 = ruleNodes9.lastChild;
//	      var i=0;
//	      while(firstNode9 != endNode9) {
//	       	i++;
//	        firstNode9 = firstNode9.nextSibling;
//	      }
//	      if(i>0){
//	      	 countcase = 4;
//	      }
//	      
//	      var ruleNodes11 = document.getElementById("RuleZone11");	
//	      var firstNode11 = ruleNodes11.firstChild;
//	      var endNode11 = ruleNodes11.lastChild;
//	      var i=0;
//	      while(firstNode11 != endNode11) {
//	       	i++;
//	        firstNode11 = firstNode11.nextSibling;
//	      }
//	      if(i>0){
//	      	 countcase = 5;
//	      }
//	      
//	      var ruleNodes13 = document.getElementById("RuleZone13");	
//	      var firstNode13 = ruleNodes13.firstChild;
//	      var endNode13 = ruleNodes13.lastChild;
//	      var i=0;
//	      while(firstNode13 != endNode13) {
//	       	i++;
//	        firstNode13 = firstNode13.nextSibling;
//	      }
//	      if(i>0){
//	      	 countcase = 6;
//	      }
//	      
//	      var ruleNodes15 = document.getElementById("RuleZone15");	
//	      var firstNode15 = ruleNodes15.firstChild;
//	      var endNode15 = ruleNodes15.lastChild;
//	      var i=0;
//	      while(firstNode15 != endNode15) {
//	       	i++;
//	        firstNode15 = firstNode15.nextSibling;
//	      }
//	      if(i>0){
//	      	 countcase = 7;
//	      }
//	      
//	      var ruleNodes17 = document.getElementById("RuleZone17");	
//	      var firstNode17 = ruleNodes17.firstChild;
//	      var endNode17 = ruleNodes17.lastChild;
//	      var i=0;
//	      while(firstNode17 != endNode17) {
//	       	i++;
//	        firstNode17 = firstNode17.nextSibling;
//	      }
//	      if(i>0){
//	      	 countcase = 8;
//	      }
//	      
//	      var ruleNodes19 = document.getElementById("RuleZone19");	
//	      var firstNode19 = ruleNodes19.firstChild;
//	      var endNode19 = ruleNodes19.lastChild;
//	      var i=0;
//	      while(firstNode19 != endNode19) {
//	       	i++;
//	        firstNode19 = firstNode19.nextSibling;
//	      }
//	      if(i>0){
//	      	 countcase = 9;
//	      }
	 }
	 countcase++;
	 //alert("countcase--"+countcase);
	 if(countcase==1){      
	 	  countif = 1;
	    document.getElementById("conditions3").style.display="block";  
	    document.getElementById("conditions4").style.display="block";//visible 为显示，hidden为隐藏
	  }else if(countcase==2){
	  	countif = 1;
	  	document.getElementById("conditions5").style.display="block";  
	    document.getElementById("conditions6").style.display="block";//visible 为显示，hidden为隐藏
	  }
//	  else if(countcase==3){
//	  	countif = 1;
//	  	document.getElementById("conditions7").style.visibility="visible";  
//	    document.getElementById("conditions8").style.visibility="visible";//visible 为显示，hidden为隐藏
//	  }else if(countcase==4){
//	  	countif = 1;
//	  	document.getElementById("conditions9").style.visibility="visible";  
//	    document.getElementById("conditions10").style.visibility="visible";//visible 为显示，hidden为隐藏
//	  }else if(countcase==5){
//	  	countif = 1;
//	  	document.getElementById("conditions11").style.visibility="visible";  
//	    document.getElementById("conditions12").style.visibility="visible";//visible 为显示，hidden为隐藏
//	  }else if(countcase==6){
//	  	countif = 1;
//	  	document.getElementById("conditions13").style.visibility="visible";  
//	    document.getElementById("conditions14").style.visibility="visible";//visible 为显示，hidden为隐藏
//	  }else if(countcase==7){
//	  	countif = 1;
//	  	document.getElementById("conditions15").style.visibility="visible";  
//	    document.getElementById("conditions16").style.visibility="visible";//visible 为显示，hidden为隐藏
//	  }else if(countcase==8){
//	  	countif = 1;
//	  	document.getElementById("conditions17").style.visibility="visible";  
//	    document.getElementById("conditions18").style.visibility="visible";//visible 为显示，hidden为隐藏
//	  }else if(countcase==9){
//	  	countif = 1;
//	  	document.getElementById("conditions19").style.visibility="visible";  
//	    document.getElementById("conditions20").style.visibility="visible";//visible 为显示，hidden为隐藏
//	  }
}

function modifyLogic() {
	showButtons();
	enableSpanNodes();
	disableInputNodes();
	
	var fm = document.getElementById('fm');
	fm.Operation.value = 'Logic_Modification';
	
	var displayDisicionTable=document.getElementById('displayDisicionTable');
	displayDisicionTable.disabled=false;
	var submitData=document.getElementById('submitData');
	submitData.disabled=true;
	var logicToTable=document.getElementById('logicToTable');
	logicToTable.disabled=true;
	var modifyLogic=document.getElementById('modifyLogic');
	modifyLogic.disabled=true;
	
}