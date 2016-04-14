/*
 * 函数传入参数为空 函数返回值：函数的返回值是一个数组（reArray） reArray[0]携带拼写好的SQLStatement
 * reArray[1]携带拼写好的createTable reArray[2]携带拼写好的决策表的表头
 */
function composeSQL() {
	//alert("成功！");
	// 获取规则区域的节点
	var ruleNodes = document.getElementById('RuleZone');	
	var ruleNodes1 = document.getElementById('RuleZone1');
	// 获取规则的第一个条件
	var ruleNode = ruleNodes.firstChild;	
	// 获取规则的最后一个条件
	var endNode = ruleNodes.lastChild;	
	// 对拼SQL过程中需要使用到的变量进行初始化
	initParaBeforeComposeSQL();
	

	if(ruleNodes1!=null)
	{
		//SQLStatement = "select RuleId,UWLevel,Result from #DTTable# where ";
		SQLStatement = "select case when xx0 then RuleId,UWLevel,Result ";
	}
	else {
	 alert(""+I18NMsg("G0000036541")+"");
	 return false;
	}
	
  var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
	var xmlRule = xmlDoc.createElement("Rule");
	xmlDoc.appendChild(xmlRule);
	var xmlCondition = xmlDoc.createElement("Condition");
	var MetaNode;
 
 // reStr = "";
	while (ruleNode != endNode) {
		countcase = 0;
		// 获取条件的第一个节点和最后一个节点
		var spanNode = ruleNode.firstChild;
		var lastNode = ruleNode.lastChild;
		// 用于记录规则中一个条件的sql字符串

		xmlCondition = xmlDoc.createElement("Condition");

		MetaNodeChNameArray.length = 0;

		while (spanNode != lastNode) {
			if (spanNode.id == 'Spacer') {
				spanNode = spanNode.nextSibling;
				continue;
			}
			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
			// 有优化的余地
			MetaNode = composeXML(xmlDoc, spanNode);
			xmlCondition.appendChild(MetaNode);

			if (spanNode.id == "BOM") {
				if (spanNodeArray.length != 0) {
					comASQL();
				}
				spanNodeArray.push(spanNode);
			}

			else if (spanNode.id == "BOMItem") {
				spanNodeArray.push(spanNode);
			} else if (spanNode.id == "Operator") {
				spanNodeArray.push(spanNode);
				//alert("spanNode.EnName--"+spanNode.EnName);
				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
				{
					comASQL();
				}
			} else if (spanNode.id == "Link") {
				if (spanNodeArray.length != 0) {
					comASQL();
				}
				spanNodeArray.push(spanNode);
				ColumnMetasChArray.length = 0;
			} else if (spanNode.id == "Left_Paren") {
				spanNodeArray.push(spanNode);
			} else if (spanNode.id == "Right_Paren") {
				spanNodeArray.push(spanNode);
			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
				spanNodeArray.push(spanNode);
				comASQL();
			}
			spanNode = spanNode.nextSibling;
		}
		//alert("SQLStatement--222--"+SQLStatement);
		if (spanNodeArray.length != 0) {
			comASQL();
		}

		xmlRule.appendChild(xmlCondition);
		composeRuleDesInCh();
		ruleNode = ruleNode.nextSibling;
	}
	
	
	//alert("SQLStatement--00--"+SQLStatement);
	//wengf----

//	var ruleNode1 = ruleNodes1.firstChild;
//	var endNode1 = ruleNodes1.lastChild;	
//	xmlCondition = xmlDoc.createElement("Condition1");	
//	while (ruleNode1 != endNode1) {
//		// 获取条件的第一个节点和最后一个节点
//		var spanNode = ruleNode1.firstChild;
//		var lastNode = ruleNode1.lastChild;
//		// 用于记录规则中一个条件的sql字符串
//
//		xmlCondition = xmlDoc.createElement("Condition1");
//		MetaNodeChNameArray.length = 0;
//		while (spanNode != lastNode) {
//			
//			if (spanNode.id == 'Spacer') {
//				spanNode = spanNode.nextSibling;
//				continue;
//			}
//
//			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//			// 有优化的余地
//			MetaNode = composeXML(xmlDoc, spanNode);
//			if(MetaNode == null)
//			{
//				spanNode = spanNode.nextSibling;
//				continue;
//				}
//			xmlCondition.appendChild(MetaNode);
//
//			if (spanNode.id == "BOM") {
//				if (spanNodeArray.length != 0) {
//					comASQL();
//				}
//			}
//
//			else if (spanNode.id == "BOMItem") {
//			} else if (spanNode.id == "Operator") {
//				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//				{
//					comASQL();
//				}
//			} else if (spanNode.id == "Link") {
//				if (spanNodeArray.length != 0) {
//					comASQL();
//				}
//				ColumnMetasChArray.length = 0;
//			} else if (spanNode.id == "Left_Paren") {
//			} else if (spanNode.id == "Right_Paren") {
//			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//				comASQL();
//			}
//
//			spanNode = spanNode.nextSibling;
//
//		}
//
//		if (spanNodeArray.length != 0) {
//			comASQL();
//		}
//
//		xmlRule.appendChild(xmlCondition);
//		composeRuleDesInCh();
//
//		ruleNode1 = ruleNode1.nextSibling;
//	}
	SQLStatement = SQLStatement.replace('xx0',''+reStr);

//alert("SQLStatement---"+SQLStatement);  
//上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
	   //add by efeng
	   //modify by wengf
	// reStr = "";
	// ruleNodes = document.getElementById('RuleZone');
	// ruleNodes1 = document.getElementById('RuleZone1');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
	//   if(ruleNodes!=null && ruleNodes1!=null)
	//		{
	//			var sqlresult ="";				
	//			var ruleNode = ruleNodes1.firstChild;
	//			var endNode = ruleNodes1.lastChild;
	//				// 获取条件的第一个节点和最后一个节点
	//				var spanNode = ruleNode.firstChild;
	//				var lastNode = ruleNode.lastChild;
  //
	//				while(spanNode!=lastNode)
	//				{
	//					alert("spanNode.id--"+spanNode.id);
	//					alert("spanNode.getAttribute('EnName')--"+spanNode.getAttribute('EnName'));
	//					if(spanNode.id=="BOM")
	//					{
	//						if(spanNode.getAttribute('EnName') == "RateSet")
	//						{
	//								var spanNodeTemp = spanNode.nextSibling
	//								spanNodeTemp = spanNodeTemp.nextSibling
	//								var rate = spanNodeTemp.getAttribute('EnName');
	//								sqlresult += "result";
	//								spanNode = spanNodeTemp.nextSibling;
	//						}
	//					else
	//						{
	//							sqlresult += "?"+spanNode.getAttribute('EnName')+".";
	//							}
	//					}
	//					
	//					if(spanNode.id=="BOMItem")
	//					{
	//						sqlresult += spanNode.getAttribute('EnName')+"?";
	//						
	//					}
	//					
	//					if(spanNode.id=="Operator")
	//					{
	//						if(spanNode.getAttribute('EnName') != null)
	//						{
	//							sqlresult += spanNode.getAttribute('EnName');
	//						}
	//						else
	//					{sqlresult+= "";}
	//						
	//					}
	//					if(spanNode.id=="Input")
	//					{
	//						if(spanNode.getAttribute('EnName') != null)
	//						{
	//							sqlresult += spanNode.getAttribute('EnName');
	//						}
	//						else
	//					{sqlresult+= "";}
	//						
	//					}
	//				
	//					spanNode = spanNode.nextSibling;
	//				}
	//				SQLStatement = SQLStatement.replace('RuleId,UWLevel,Result',''+sqlresult);
	//		}
		 reStr = "";
	   ruleNodes = document.getElementById('RuleZone');
	   ruleNodes1 = document.getElementById('RuleZone1');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
	   var xmlCondition = xmlDoc.createElement("Condition1");
	   	var ruleNode = ruleNodes1.firstChild;	
	   var endNode = ruleNodes1.lastChild;	
	while (ruleNode != endNode) {
		// 获取条件的第一个节点和最后一个节点
		var spanNode = ruleNode.firstChild;
		var lastNode = ruleNode.lastChild;
		// 用于记录规则中一个条件的sql字符串
		xmlCondition = xmlDoc.createElement("Condition1");

		MetaNodeChNameArray.length = 0;

		while (spanNode != lastNode) {

			if (spanNode.id == 'Spacer') {
				spanNode = spanNode.nextSibling;
				continue;
			}
		  //alert("spanNode.id--"+spanNode.id);
			//alert("spanNode.getAttribute('EnName')-----"+spanNode.getAttribute('EnName'));
			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
			// 有优化的余地
			if(spanNode.id=="Operator" && spanNode.getAttribute('EnName')==null){
			  
		  }else{
		  	MetaNode = composeXML1(xmlDoc, spanNode);
			  xmlCondition.appendChild(MetaNode);
		  }
			if (spanNode.id == "BOM") {
				if (spanNodeArray.length != 0) {
					comASQL1();
				}
				spanNodeArray.push(spanNode);
			}else if (spanNode.id == "BOMItem") {
				spanNodeArray.push(spanNode);
			}else if (spanNode.id == "Operator") {
				spanNodeArray.push(spanNode);
				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
				{
					comASQL1();
				}
			} else if (spanNode.id == "Link") {
				if (spanNodeArray.length != 0) {
					comASQL1();
				}
				spanNodeArray.push(spanNode);
				ColumnMetasChArray.length = 0;
			} else if (spanNode.id == "Left_Paren") {
				spanNodeArray.push(spanNode);
			} else if (spanNode.id == "Right_Paren") {
				spanNodeArray.push(spanNode);
			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
				spanNodeArray.push(spanNode);
				comASQL1();
			}
			spanNode = spanNode.nextSibling;
		}
		if (spanNodeArray.length != 0) {
			comASQL1();
		}

		xmlRule.appendChild(xmlCondition);
		composeRuleDesInCh();
		ruleNode = ruleNode.nextSibling;
	}
	SQLStatement = SQLStatement.replace('RuleId,UWLevel,Result',''+reStr);
	
	 
  //alert("SQLStatement-22--"+SQLStatement);
  //alert("-------00----------"+SQLStatement);
  //add by jiahy 20100914
  	     reStr = "";
         var ruleNodes3 = document.getElementById("RuleZone3");//jiahy
	       var ruleNodes4 = document.getElementById("RuleZone4");
	if(ruleNodes3!=null && ruleNodes4!=null && ruleNodes3.firstChild.id!="AddButton"){
	//	alert("-------11----------");
		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
        var ruleNode3 = ruleNodes3.firstChild;	
       	var endNode3 = ruleNodes3.lastChild;	
        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
       //	var xmlRule = xmlDoc.createElement("Rule"); //jiahy 
       	xmlDoc.appendChild(xmlRule);
       	var xmlCondition = xmlDoc.createElement("Condition3");
       	var MetaNode;
       
         reStr = "";//重要
       	while (ruleNode3 != endNode3) {		
       		// 获取条件的第一个节点和最后一个节点
       		var spanNode = ruleNode3.firstChild;
       		var lastNode = ruleNode3.lastChild;
       		// 用于记录规则中一个条件的sql字符串
       
       		xmlCondition = xmlDoc.createElement("Condition3");
       
       		MetaNodeChNameArray.length = 0;
       
       		while (spanNode != lastNode) {
       			if (spanNode.id == 'Spacer') {
       				spanNode = spanNode.nextSibling;
       				continue;
       			}
       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
       			// 有优化的余地
       			MetaNode = composeXML(xmlDoc, spanNode);
       			xmlCondition.appendChild(MetaNode);
       
       			if (spanNode.id == "BOM") {
       				if (spanNodeArray.length != 0) {
       					comASQL();
       				}
       				spanNodeArray.push(spanNode);
       			}
       
       			else if (spanNode.id == "BOMItem") {
       				spanNodeArray.push(spanNode);
       			} else if (spanNode.id == "Operator") {
       				spanNodeArray.push(spanNode);
       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
       				{
       					comASQL();
       				}
       			} else if (spanNode.id == "Link") {
       				if (spanNodeArray.length != 0) {
       					comASQL();
       				}
       				spanNodeArray.push(spanNode);
       				ColumnMetasChArray.length = 0;
       			} else if (spanNode.id == "Left_Paren") {
       				spanNodeArray.push(spanNode);
       			} else if (spanNode.id == "Right_Paren") {
       				spanNodeArray.push(spanNode);
       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
       				spanNodeArray.push(spanNode);
       				comASQL();
       			}
       			spanNode = spanNode.nextSibling;
       		}
       		if (spanNodeArray.length != 0) {
       			comASQL();
       		}
       
       		xmlRule.appendChild(xmlCondition);
       		composeRuleDesInCh();
       		ruleNode3 = ruleNode3.nextSibling;
       	}
       	//alert("SQLStatement--33--"+SQLStatement);
  //     	var ruleNode4 = ruleNodes4.firstChild;
  //     	var endNode4 = ruleNodes4.lastChild;	
  //     	xmlCondition = xmlDoc.createElement("Condition4");	
  //     	while (ruleNode4 != endNode4) {
  //     		// 获取条件的第一个节点和最后一个节点
  //     		var spanNode = ruleNode4.firstChild;
  //     		var lastNode = ruleNode4.lastChild;
  //     		// 用于记录规则中一个条件的sql字符串
  //     
  //     		xmlCondition = xmlDoc.createElement("Condition4");
  //     		MetaNodeChNameArray.length = 0;
  //     		while (spanNode != lastNode) {
  //     			
  //     			if (spanNode.id == 'Spacer') {
  //     				spanNode = spanNode.nextSibling;
  //     				continue;
  //     			}
  //     
  //     			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
  //     			// 有优化的余地
  //     			MetaNode = composeXML(xmlDoc, spanNode);
  //     			if(MetaNode == null)
  //     			{
  //     				spanNode = spanNode.nextSibling;
  //     				continue;
  //     				}
  //     			xmlCondition.appendChild(MetaNode);
  //     
  //     			if (spanNode.id == "BOM") {
  //     				if (spanNodeArray.length != 0) {
  //     					comASQL();
  //     				}
  //     			}
  //     
  //     			else if (spanNode.id == "BOMItem") {
  //     			} else if (spanNode.id == "Operator") {
  //     				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
  //     				{
  //     					comASQL();
  //     				}
  //     			} else if (spanNode.id == "Link") {
  //     				if (spanNodeArray.length != 0) {
  //     					comASQL();
  //     				}
  //     				ColumnMetasChArray.length = 0;
  //     			} else if (spanNode.id == "Left_Paren") {
  //     			} else if (spanNode.id == "Right_Paren") {
  //     			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
  //     				comASQL();
  //     			}
  //     
  //     			spanNode = spanNode.nextSibling;
  //     
  //     		}
  //     
  //     		if (spanNodeArray.length != 0) {
  //     			comASQL();
  //     		}
  //     
  //     		xmlRule.appendChild(xmlCondition);
  //     		composeRuleDesInCh();
  //     
  //     		ruleNode4 = ruleNode4.nextSibling;
  //     	} 
       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
       //	 reStr = "";
       //	 var ruleNodes3 = document.getElementById("RuleZone3");//jiahy
	     //  var ruleNodes4 = document.getElementById("RuleZone4");//处理then后面的内容（ SELECT 与WHERE 之间的内容）
       //	   if(ruleNodes3!=null && ruleNodes4!=null)
       //			{
       //				var sqlresult ="";				
       //				var ruleNode = ruleNodes4.firstChild;
       //				var endNode = ruleNodes4.lastChild;
       //					// 获取条件的第一个节点和最后一个节点
       //					var spanNode = ruleNode.firstChild;
       //					var lastNode = ruleNode.lastChild;
       //    
       //					while(spanNode!=lastNode)
       //					{
       //						
       //						if(spanNode.id=="BOM")
       //						{
       //							if(spanNode.getAttribute('EnName') == "RateSet")
       //							{
       //									var spanNodeTemp = spanNode.nextSibling
       //									spanNodeTemp = spanNodeTemp.nextSibling
       //									var rate = spanNodeTemp.getAttribute('EnName');
       //									sqlresult += "result";
       //									spanNode = spanNodeTemp.nextSibling;
       //							}
       //						else
       //							{
       //								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
       //								}
       //						}
       //						
       //						if(spanNode.id=="BOMItem")
       //						{
       //							sqlresult += spanNode.getAttribute('EnName')+"?";
       //							
       //						}
       //						
       //						if(spanNode.id=="Operator")
       //						{
       //							if(spanNode.getAttribute('EnName') != null)
       //							{
       //								sqlresult += spanNode.getAttribute('EnName');
       //							}
       //							else
       //						{sqlresult+= "";}
       //							
       //						}
       //					
       //						spanNode = spanNode.nextSibling;
       //					}
       //					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
       //			}

      		 		 reStr = "";
	   ruleNodes3 = document.getElementById('RuleZone3');
	   ruleNodes4 = document.getElementById('RuleZone4');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
	   var xmlCondition = xmlDoc.createElement("Condition4");
	   	var ruleNode = ruleNodes4.firstChild;	
	   var endNode = ruleNodes4.lastChild;	
	while (ruleNode != endNode) {
		// 获取条件的第一个节点和最后一个节点
		var spanNode = ruleNode.firstChild;
		var lastNode = ruleNode.lastChild;
		// 用于记录规则中一个条件的sql字符串
		xmlCondition = xmlDoc.createElement("Condition4");

		MetaNodeChNameArray.length = 0;

		while (spanNode != lastNode) {

			if (spanNode.id == 'Spacer') {
				spanNode = spanNode.nextSibling;
				continue;
			}
		  //alert("spanNode.id--"+spanNode.id);
			//alert("spanNode.getAttribute('EnName')-----"+spanNode.getAttribute('EnName'));
			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
			// 有优化的余地
			if(spanNode.id=="Operator" && spanNode.getAttribute('EnName')==null){
			  
		  }else{
		  	MetaNode = composeXML1(xmlDoc, spanNode);
			  xmlCondition.appendChild(MetaNode);
		  }
			if (spanNode.id == "BOM") {
				if (spanNodeArray.length != 0) {
					comASQL1();
				}
				spanNodeArray.push(spanNode);
			}else if (spanNode.id == "BOMItem") {
				spanNodeArray.push(spanNode);
			}else if (spanNode.id == "Operator") {
				spanNodeArray.push(spanNode);
				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
				{
					comASQL1();
				}
			} else if (spanNode.id == "Link") {
				if (spanNodeArray.length != 0) {
					comASQL1();
				}
				spanNodeArray.push(spanNode);
				ColumnMetasChArray.length = 0;
			} else if (spanNode.id == "Left_Paren") {
				spanNodeArray.push(spanNode);
			} else if (spanNode.id == "Right_Paren") {
				spanNodeArray.push(spanNode);
			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
				spanNodeArray.push(spanNode);
				comASQL1();
			}
			spanNode = spanNode.nextSibling;
		}
		if (spanNodeArray.length != 0) {
			comASQL1();
		}

		xmlRule.appendChild(xmlCondition);
		composeRuleDesInCh();
		ruleNode = ruleNode.nextSibling;
	}
	SQLStatement = SQLStatement.replace('Result1',''+reStr);
}
   //   alert("-------11----------"+SQLStatement);
//--------------------------------------------------------------------------------------------------
  //add by jiahy 20100914
 
         	 reStr = "";
       	 var ruleNodes5 = document.getElementById("RuleZone5");//jiahy
	       var ruleNodes6 = document.getElementById("RuleZone6");
	if(ruleNodes5!=null && ruleNodes6!=null && ruleNodes5.firstChild.id!="AddButton"){
		//alert("-------22----------");
		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
        var ruleNode5 = ruleNodes5.firstChild;	
       	var endNode5 = ruleNodes5.lastChild;	
        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
       //	var xmlRule = xmlDoc.createElement("Rule");
       	xmlDoc.appendChild(xmlRule);
       	var xmlCondition = xmlDoc.createElement("Condition5");
       	var MetaNode;
       
         reStr = "";//重要
       	while (ruleNode5 != endNode5) {		
       		// 获取条件的第一个节点和最后一个节点
       		var spanNode = ruleNode5.firstChild;
       		var lastNode = ruleNode5.lastChild;
       		// 用于记录规则中一个条件的sql字符串
       
       		xmlCondition = xmlDoc.createElement("Condition5");
       
       		MetaNodeChNameArray.length = 0;
       
       		while (spanNode != lastNode) {
       			if (spanNode.id == 'Spacer') {
       				spanNode = spanNode.nextSibling;
       				continue;
       			}
       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
       			// 有优化的余地
       			MetaNode = composeXML(xmlDoc, spanNode);
       			xmlCondition.appendChild(MetaNode);
       
       			if (spanNode.id == "BOM") {
       				if (spanNodeArray.length != 0) {
       					comASQL();
       				}
       				spanNodeArray.push(spanNode);
       			}
       
       			else if (spanNode.id == "BOMItem") {
       				spanNodeArray.push(spanNode);
       			} else if (spanNode.id == "Operator") {
       				spanNodeArray.push(spanNode);
       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
       				{
       					comASQL();
       				}
       			} else if (spanNode.id == "Link") {
       				if (spanNodeArray.length != 0) {
       					comASQL();
       				}
       				spanNodeArray.push(spanNode);
       				ColumnMetasChArray.length = 0;
       			} else if (spanNode.id == "Left_Paren") {
       				spanNodeArray.push(spanNode);
       			} else if (spanNode.id == "Right_Paren") {
       				spanNodeArray.push(spanNode);
       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
       				spanNodeArray.push(spanNode);
       				comASQL();
       			}
       			spanNode = spanNode.nextSibling;
       		}
       		if (spanNodeArray.length != 0) {
       			comASQL();
       		}
       
       		xmlRule.appendChild(xmlCondition);
       		composeRuleDesInCh();
       		ruleNode5 = ruleNode5.nextSibling;
       	}
       	//alert("SQLStatement--33--"+SQLStatement);
       	var ruleNode6 = ruleNodes6.firstChild;
       	var endNode6 = ruleNodes6.lastChild;	
       	xmlCondition = xmlDoc.createElement("Condition6");	
       	while (ruleNode6 != endNode6) {
       		// 获取条件的第一个节点和最后一个节点
       		var spanNode = ruleNode6.firstChild;
       		var lastNode = ruleNode6.lastChild;
       		// 用于记录规则中一个条件的sql字符串
       
       		xmlCondition = xmlDoc.createElement("Condition6");
       		MetaNodeChNameArray.length = 0;
       		while (spanNode != lastNode) {
       			
       			if (spanNode.id == 'Spacer') {
       				spanNode = spanNode.nextSibling;
       				continue;
       			}
       
       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
       			// 有优化的余地
       			MetaNode = composeXML(xmlDoc, spanNode);
       			if(MetaNode == null)
       			{
       				spanNode = spanNode.nextSibling;
       				continue;
       				}
       			xmlCondition.appendChild(MetaNode);
       
       			if (spanNode.id == "BOM") {
       				if (spanNodeArray.length != 0) {
       					comASQL();
       				}
       			}
       
       			else if (spanNode.id == "BOMItem") {
       			} else if (spanNode.id == "Operator") {
       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
       				{
       					comASQL();
       				}
       			} else if (spanNode.id == "Link") {
       				if (spanNodeArray.length != 0) {
       					comASQL();
       				}
       				ColumnMetasChArray.length = 0;
       			} else if (spanNode.id == "Left_Paren") {
       			} else if (spanNode.id == "Right_Paren") {
       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
       				comASQL();
       			}
       
       			spanNode = spanNode.nextSibling;
       
       		}
       
       		if (spanNodeArray.length != 0) {
       			comASQL();
       		}
       
       		xmlRule.appendChild(xmlCondition);
       		composeRuleDesInCh();
       
       		ruleNode6 = ruleNode6.nextSibling;
       	} 
       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
       //alert("SQLStatement--44--"+SQLStatement);
       //alert("111---reStr--0---"+reStr);  
       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
       	   //add by efeng
       	   //modify by wengf
       	 reStr = "";
       	 ruleNodes5 = document.getElementById('RuleZone5');
       	 ruleNodes6 = document.getElementById('RuleZone6');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
       	   if(ruleNodes5!=null && ruleNodes6!=null)
       			{
       				var sqlresult ="";				
       				var ruleNode = ruleNodes6.firstChild;
       				var endNode = ruleNodes6.lastChild;
       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
       					var lastNode = ruleNode.lastChild;
           
       					while(spanNode!=lastNode)
       					{
       						
       						if(spanNode.id=="BOM")
       						{
       							if(spanNode.getAttribute('EnName') == "RateSet")
       							{
       									var spanNodeTemp = spanNode.nextSibling
       									spanNodeTemp = spanNodeTemp.nextSibling
       									var rate = spanNodeTemp.getAttribute('EnName');
       									sqlresult += "result";
       									spanNode = spanNodeTemp.nextSibling;
       							}
       						else
       							{
       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
       								}
       						}
       						
       						if(spanNode.id=="BOMItem")
       						{
       							sqlresult += spanNode.getAttribute('EnName')+"?";
       							
       						}
       						
       						if(spanNode.id=="Operator")
       						{
       							if(spanNode.getAttribute('EnName') != null)
       							{
       								sqlresult += spanNode.getAttribute('EnName');
       							}
       							else
       						{sqlresult+= "";}
       							
       						}
       					
       						spanNode = spanNode.nextSibling;
       					}
       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
       			}
      }
   //   alert("-------22----------"+SQLStatement);
//---------------------------------------------------------------------------------------------------------
  //add by jiahy 20100914
//   
//         	 reStr = "";
//       	 var ruleNodes7 = document.getElementById("RuleZone7");//jiahy
//	       var ruleNodes8 = document.getElementById("RuleZone8");
//	if(ruleNodes7!=null && ruleNodes8!=null && ruleNodes7.firstChild.id!="AddButton"){
//	//	alert("-------33----------");
//		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
//        var ruleNode7 = ruleNodes7.firstChild;	
//       	var endNode7 = ruleNodes7.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	//var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition7");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode7 != endNode7) {		
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode7.firstChild;//2012-2-24 
//       		var lastNode = ruleNode7.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition7");
//       
//       		MetaNodeChNameArray.length = 0;
//       
//       		while (spanNode != lastNode) {
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Operator") {
//       				spanNodeArray.push(spanNode);
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Right_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				spanNodeArray.push(spanNode);
//       				comASQL();
//       			}
//       			spanNode = spanNode.nextSibling;
//       		}
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       		ruleNode7 = ruleNode7.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode8 = ruleNodes8.firstChild;
//       	var endNode8 = ruleNodes8.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition8");	
//       	while (ruleNode8 != endNode8) {
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode8.firstChild;//2012-2-24
//       		var lastNode = ruleNode8.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition8");
//       		MetaNodeChNameArray.length = 0;
//       		while (spanNode != lastNode) {
//       			
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			if(MetaNode == null)
//       			{
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       				}
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       			} else if (spanNode.id == "Operator") {
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       			} else if (spanNode.id == "Right_Paren") {
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				comASQL();
//       			}
//       
//       			spanNode = spanNode.nextSibling;
//       
//       		}
//       
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       
//       		ruleNode8 = ruleNode8.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes7 = document.getElementById('RuleZone7');
//       	 ruleNodes8 = document.getElementById('RuleZone8');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes7!=null && ruleNodes8!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes8.firstChild;
//       				var endNode = ruleNodes8.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
//       					var lastNode = ruleNode.lastChild;
//           
//       					while(spanNode!=lastNode)
//       					{
//       						
//       						if(spanNode.id=="BOM")
//       						{
//       							if(spanNode.getAttribute('EnName') == "RateSet")
//       							{
//       									var spanNodeTemp = spanNode.nextSibling
//       									spanNodeTemp = spanNodeTemp.nextSibling
//       									var rate = spanNodeTemp.getAttribute('EnName');
//       									sqlresult += "result";
//       									spanNode = spanNodeTemp.nextSibling;
//       							}
//       						else
//       							{
//       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
//       								}
//       						}
//       						
//       						if(spanNode.id=="BOMItem")
//       						{
//       							sqlresult += spanNode.getAttribute('EnName')+"?";
//       							
//       						}
//       						
//       						if(spanNode.id=="Operator")
//       						{
//       							if(spanNode.getAttribute('EnName') != null)
//       							{
//       								sqlresult += spanNode.getAttribute('EnName');
//       							}
//       							else
//       						{sqlresult+= "";}
//       							
//       						}
//       					
//       						spanNode = spanNode.nextSibling;
//       					}
//       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
//       			}
//      }
////      alert("-------33----------"+SQLStatement);
// //----------------------------------------------------------------------------------------------------------------
// //add by jiahy 20100914
//         	 reStr = "";
//       	 var ruleNodes9 = document.getElementById("RuleZone9");//jiahy
//	       var ruleNodes10 = document.getElementById("RuleZone10");
//	if(ruleNodes9!=null && ruleNodes10!=null && ruleNodes9.firstChild.id!="AddButton"){
//	//	alert("-------44----------");
//		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
//        var ruleNode9 = ruleNodes9.firstChild;	
//       	var endNode9 = ruleNodes9.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	//var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition9");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode9 != endNode9) {		
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode9.firstChild;//2012-2-24
//       		var lastNode = ruleNode9.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition9");
//       
//       		MetaNodeChNameArray.length = 0;
//       
//       		while (spanNode != lastNode) {
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Operator") {
//       				spanNodeArray.push(spanNode);
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Right_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				spanNodeArray.push(spanNode);
//       				comASQL();
//       			}
//       			spanNode = spanNode.nextSibling;
//       		}
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       		ruleNode9 = ruleNode9.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode10 = ruleNodes10.firstChild;
//       	var endNode10 = ruleNodes10.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition10");	
//       	while (ruleNode10 != endNode10) {
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode10.firstChild;//2012-2-24
//       		var lastNode = ruleNode10.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition10");
//       		MetaNodeChNameArray.length = 0;
//       		while (spanNode != lastNode) {
//       			
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			if(MetaNode == null)
//       			{
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       				}
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       			} else if (spanNode.id == "Operator") {
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       			} else if (spanNode.id == "Right_Paren") {
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				comASQL();
//       			}
//       
//       			spanNode = spanNode.nextSibling;
//       
//       		}
//       
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       
//       		ruleNode10 = ruleNode10.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes9 = document.getElementById('RuleZone9');
//       	 ruleNodes10 = document.getElementById('RuleZone10');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes9!=null && ruleNodes10!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes10.firstChild;
//       				var endNode = ruleNodes10.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
//       					var lastNode = ruleNode.lastChild;
//           
//       					while(spanNode!=lastNode)
//       					{
//       						
//       						if(spanNode.id=="BOM")
//       						{
//       							if(spanNode.getAttribute('EnName') == "RateSet")
//       							{
//       									var spanNodeTemp = spanNode.nextSibling
//       									spanNodeTemp = spanNodeTemp.nextSibling
//       									var rate = spanNodeTemp.getAttribute('EnName');
//       									sqlresult += "result";
//       									spanNode = spanNodeTemp.nextSibling;
//       							}
//       						else
//       							{
//       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
//       								}
//       						}
//       						
//       						if(spanNode.id=="BOMItem")
//       						{
//       							sqlresult += spanNode.getAttribute('EnName')+"?";
//       							
//       						}
//       						
//       						if(spanNode.id=="Operator")
//       						{
//       							if(spanNode.getAttribute('EnName') != null)
//       							{
//       								sqlresult += spanNode.getAttribute('EnName');
//       							}
//       							else
//       						{sqlresult+= "";}
//       							
//       						}
//       					
//       						spanNode = spanNode.nextSibling;
//       					}
//       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
//       			}
//      }
//    //  alert("-------44----------"+SQLStatement);
////------------------------------------------------------------------------------------------------------------
////add by jiahy 20100914
//         	 reStr = "";
//       	 var ruleNodes11 = document.getElementById("RuleZone11");//jiahy
//	       var ruleNodes12 = document.getElementById("RuleZone12");
//	if(ruleNodes11!=null && ruleNodes12!=null && ruleNodes11.firstChild.id!="AddButton"){
//		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
//        var ruleNode11 = ruleNodes11.firstChild;	
//       	var endNode11 = ruleNodes11.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	//var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition11");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode11 != endNode11) {		
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode11.firstChild;//2012-2-24
//       		var lastNode = ruleNode11.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition11");
//       
//       		MetaNodeChNameArray.length = 0;
//       
//       		while (spanNode != lastNode) {
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Operator") {
//       				spanNodeArray.push(spanNode);
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Right_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				spanNodeArray.push(spanNode);
//       				comASQL();
//       			}
//       			spanNode = spanNode.nextSibling;
//       		}
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       		ruleNode11 = ruleNode11.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode12 = ruleNodes12.firstChild;
//       	var endNode12 = ruleNodes12.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition12");	
//       	while (ruleNode12 != endNode12) {
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode12.firstChild;//2012-2-24
//       		var lastNode = ruleNode12.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition12");
//       		MetaNodeChNameArray.length = 0;
//       		while (spanNode != lastNode) {
//       			
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			if(MetaNode == null)
//       			{
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       				}
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       			} else if (spanNode.id == "Operator") {
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       			} else if (spanNode.id == "Right_Paren") {
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				comASQL();
//       			}
//       
//       			spanNode = spanNode.nextSibling;
//       
//       		}
//       
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       
//       		ruleNode12 = ruleNode12.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       	
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes11 = document.getElementById('RuleZone11');
//       	 ruleNodes12 = document.getElementById('RuleZone12');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes11!=null && ruleNodes12!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes12.firstChild;
//       				var endNode = ruleNodes12.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
//       					var lastNode = ruleNode.lastChild;
//           
//       					while(spanNode!=lastNode)
//       					{
//       						
//       						if(spanNode.id=="BOM")
//       						{
//       							if(spanNode.getAttribute('EnName') == "RateSet")
//       							{
//       									var spanNodeTemp = spanNode.nextSibling
//       									spanNodeTemp = spanNodeTemp.nextSibling
//       									var rate = spanNodeTemp.getAttribute('EnName');
//       									sqlresult += "result";
//       									spanNode = spanNodeTemp.nextSibling;
//       							}
//       						else
//       							{
//       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
//       								}
//       						}
//       						
//       						if(spanNode.id=="BOMItem")
//       						{
//       							sqlresult += spanNode.getAttribute('EnName')+"?";
//       							
//       						}
//       						
//       						if(spanNode.id=="Operator")
//       						{
//       							if(spanNode.getAttribute('EnName') != null)
//       							{
//       								sqlresult += spanNode.getAttribute('EnName');
//       							}
//       							else
//       						{sqlresult+= "";}
//       							
//       						}
//       					
//       						spanNode = spanNode.nextSibling;
//       					}
//       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
//       			}
//      }
////---------------------------------------------------------------------------------------------
//
//      //add by jiahy 20100914
//         	 reStr = "";
//       	 var ruleNodes13 = document.getElementById("RuleZone13");//jiahy
//	       var ruleNodes14 = document.getElementById("RuleZone14");
//	if(ruleNodes13!=null && ruleNodes14!=null && ruleNodes13.firstChild.id!="AddButton"){
//		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
//        var ruleNode13 = ruleNodes13.firstChild;	
//       	var endNode13 = ruleNodes13.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	//var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition13");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode13 != endNode13) {		
//       		// 获取条件的第一个节点和最后一个节点
  //     		var spanNode = ruleNode13.firstChild;2012-2-24
//       		var lastNode = ruleNode13.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition13");
//       
//       		MetaNodeChNameArray.length = 0;
//       
//       		while (spanNode != lastNode) {
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Operator") {
//       				spanNodeArray.push(spanNode);
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Right_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				spanNodeArray.push(spanNode);
//       				comASQL();
//       			}
//       			spanNode = spanNode.nextSibling;
//       		}
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       		ruleNode13 = ruleNode13.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode14 = ruleNodes14.firstChild;
//       	var endNode14 = ruleNodes14.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition14");	
//       	while (ruleNode14 != endNode14) {
//       		// 获取条件的第一个节点和最后一个节点
 //      		var spanNode = ruleNode14.firstChild;//2012-2-24
//       		var lastNode = ruleNode14.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition14");
//       		MetaNodeChNameArray.length = 0;
//       		while (spanNode != lastNode) {
//       			
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			if(MetaNode == null)
//       			{
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       				}
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       			} else if (spanNode.id == "Operator") {
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       			} else if (spanNode.id == "Right_Paren") {
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				comASQL();
//       			}
//       
//       			spanNode = spanNode.nextSibling;
//       
//       		}
//       
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       
//       		ruleNode14 = ruleNode14.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes13 = document.getElementById('RuleZone13');
//       	 ruleNodes14 = document.getElementById('RuleZone14');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes13!=null && ruleNodes14!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes14.firstChild;
//       				var endNode = ruleNodes14.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
//       					var lastNode = ruleNode.lastChild;
//           
//       					while(spanNode!=lastNode)
//       					{
//       						
//       						if(spanNode.id=="BOM")
//       						{
//       							if(spanNode.getAttribute('EnName') == "RateSet")
//       							{
//       									var spanNodeTemp = spanNode.nextSibling
//       									spanNodeTemp = spanNodeTemp.nextSibling
//       									var rate = spanNodeTemp.getAttribute('EnName');
//       									sqlresult += "result";
//       									spanNode = spanNodeTemp.nextSibling;
//       							}
//       						else
//       							{
//       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
//       								}
//       						}
//       						
//       						if(spanNode.id=="BOMItem")
//       						{
//       							sqlresult += spanNode.getAttribute('EnName')+"?";
//       							
//       						}
//       						
//       						if(spanNode.id=="Operator")
//       						{
//       							if(spanNode.getAttribute('EnName') != null)
//       							{
//       								sqlresult += spanNode.getAttribute('EnName');
//       							}
//       							else
//       						{sqlresult+= "";}
//       							
//       						}
//       					
//       						spanNode = spanNode.nextSibling;
//       					}
//       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
//       			}
//      }
////--------------------------------------------------------------------------------------------------------------------
//  //add by jiahy 20100914
//         	 reStr = "";
//       	 var ruleNodes15 = document.getElementById("RuleZone15");//jiahy
//	       var ruleNodes16 = document.getElementById("RuleZone16");
//	if(ruleNodes15!=null && ruleNodes16!=null && ruleNodes15.firstChild.id!="AddButton"){
//		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
//        var ruleNode15 = ruleNodes15.firstChild;	
//       	var endNode15 = ruleNodes15.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	//var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition15");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode15 != endNode15) {		
//       		// 获取条件的第一个节点和最后一个节点
//2012-2-24       		var spanNode = ruleNode15.firstChild;
//       		var lastNode = ruleNode15.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition15");
//       
//       		MetaNodeChNameArray.length = 0;
//       
//       		while (spanNode != lastNode) {
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Operator") {
//       				spanNodeArray.push(spanNode);
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Right_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				spanNodeArray.push(spanNode);
//       				comASQL();
//       			}
//       			spanNode = spanNode.nextSibling;
//       		}
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       		ruleNode15 = ruleNode15.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode16 = ruleNodes16.firstChild;
//       	var endNode16 = ruleNodes16.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition16");	
//       	while (ruleNode16 != endNode16) {
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode16.firstChild;//2012-2-24
//       		var lastNode = ruleNode16.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition16");
//       		MetaNodeChNameArray.length = 0;
//       		while (spanNode != lastNode) {
//       			
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			if(MetaNode == null)
//       			{
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       				}
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       			} else if (spanNode.id == "Operator") {
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       			} else if (spanNode.id == "Right_Paren") {
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				comASQL();
//       			}
//       
//       			spanNode = spanNode.nextSibling;
//       
//       		}
//       
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       
//       		ruleNode16 = ruleNode16.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes15 = document.getElementById('RuleZone15');
//       	 ruleNodes16 = document.getElementById('RuleZone16');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes15!=null && ruleNodes16!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes16.firstChild;
//       				var endNode = ruleNodes16.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
//       					var lastNode = ruleNode.lastChild;
//           
//       					while(spanNode!=lastNode)
//       					{
//       						
//       						if(spanNode.id=="BOM")
//       						{
//       							if(spanNode.getAttribute('EnName') == "RateSet")
//       							{
//       									var spanNodeTemp = spanNode.nextSibling
//       									spanNodeTemp = spanNodeTemp.nextSibling
//       									var rate = spanNodeTemp.getAttribute('EnName');
//       									sqlresult += "result";
//       									spanNode = spanNodeTemp.nextSibling;
//       							}
//       						else
//       							{
//       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
//       								}
//       						}
//       						
//       						if(spanNode.id=="BOMItem")
//       						{
//       							sqlresult += spanNode.getAttribute('EnName')+"?";
//       							
//       						}
//       						
//       						if(spanNode.id=="Operator")
//       						{
//       							if(spanNode.getAttribute('EnName') != null)
//       							{
//       								sqlresult += spanNode.getAttribute('EnName');
//       							}
//       							else
//       						{sqlresult+= "";}
//       							
//       						}
//       					
//       						spanNode = spanNode.nextSibling;
//       					}
//       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
//       			}
//      }
////----------------------------------------------------------------------------------------------------------------
// //add by jiahy 20100914
//         	 reStr = "";
//       	 var ruleNodes17 = document.getElementById("RuleZone17");//jiahy
//	       var ruleNodes18 = document.getElementById("RuleZone18");
//	if(ruleNodes17!=null && ruleNodes18!=null && ruleNodes17.firstChild.id!="AddButton"){
//		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
//        var ruleNode17 = ruleNodes15.firstChild;	
//       	var endNode17 = ruleNodes15.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	//var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition17");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode17 != endNode17) {		
//       		// 获取条件的第一个节点和最后一个节点
 //      		var spanNode = ruleNode17.firstChild;//2012-2-24
//       		var lastNode = ruleNode17.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition17");
//       
//       		MetaNodeChNameArray.length = 0;
//       
//       		while (spanNode != lastNode) {
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Operator") {
//       				spanNodeArray.push(spanNode);
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Right_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				spanNodeArray.push(spanNode);
//       				comASQL();
//       			}
//       			spanNode = spanNode.nextSibling;
//       		}
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       		ruleNode17 = ruleNode17.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode18 = ruleNodes18.firstChild;
//       	var endNode18 = ruleNodes18.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition18");	
//       	while (ruleNode18 != endNode18) {
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode18.firstChild;//2012-2-24
//       		var lastNode = ruleNode18.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition18");
//       		MetaNodeChNameArray.length = 0;
//       		while (spanNode != lastNode) {
//       			
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			if(MetaNode == null)
//       			{
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       				}
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       			} else if (spanNode.id == "Operator") {
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       			} else if (spanNode.id == "Right_Paren") {
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				comASQL();
//       			}
//       
//       			spanNode = spanNode.nextSibling;
//       
//       		}
//       
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       
//       		ruleNode18 = ruleNode18.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes17 = document.getElementById('RuleZone17');
//       	 ruleNodes18 = document.getElementById('RuleZone18');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes17!=null && ruleNodes18!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes18.firstChild;
//       				var endNode = ruleNodes18.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
//       					var lastNode = ruleNode.lastChild;
//           
//       					while(spanNode!=lastNode)
//       					{
//       						
//       						if(spanNode.id=="BOM")
//       						{
//       							if(spanNode.getAttribute('EnName') == "RateSet")
//       							{
//       									var spanNodeTemp = spanNode.nextSibling
//       									spanNodeTemp = spanNodeTemp.nextSibling
//       									var rate = spanNodeTemp.getAttribute('EnName');
//       									sqlresult += "result";
//       									spanNode = spanNodeTemp.nextSibling;
//       							}
//       						else
//       							{
//       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
//       								}
//       						}
//       						
//       						if(spanNode.id=="BOMItem")
//       						{
//       							sqlresult += spanNode.getAttribute('EnName')+"?";
//       							
//       						}
//       						
//       						if(spanNode.id=="Operator")
//       						{
//       							if(spanNode.getAttribute('EnName') != null)
//       							{
//       								sqlresult += spanNode.getAttribute('EnName');
//       							}
//       							else
//       						{sqlresult+= "";}
//       							
//       						}
//       					
//       						spanNode = spanNode.nextSibling;
//       					}
//       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
//       			}
//      }
//  //---------------------------------------------------------------------------------------------------
//      //add by jiahy 20100914
//         	 reStr = "";
//       	 var ruleNodes19 = document.getElementById("RuleZone19");//jiahy
//	       var ruleNodes20 = document.getElementById("RuleZone20");
//	if(ruleNodes19!=null && ruleNodes20!=null && ruleNodes19.firstChild.id!="AddButton"){
//		    SQLStatement = SQLStatement + " case when xx1 then Result1 ";
//        var ruleNode19 = ruleNodes19.firstChild;	
//       	var endNode19 = ruleNodes19.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	//var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition19");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode19 != endNode19) {		
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode19.firstChild;//2012-2-24
//       		var lastNode = ruleNode19.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition19");
//       
//       		MetaNodeChNameArray.length = 0;
//       
//       		while (spanNode != lastNode) {
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Operator") {
//       				spanNodeArray.push(spanNode);
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				spanNodeArray.push(spanNode);
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Right_Paren") {
//       				spanNodeArray.push(spanNode);
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				spanNodeArray.push(spanNode);
//       				comASQL();
//       			}
//       			spanNode = spanNode.nextSibling;
//       		}
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       		ruleNode19 = ruleNode19.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode20 = ruleNodes20.firstChild;
//       	var endNode20 = ruleNodes20.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition20");	
//       	while (ruleNode20 != endNode20) {
//       		// 获取条件的第一个节点和最后一个节点
//2012-2-24       		var spanNode = ruleNode20.firstChild;
//       		var lastNode = ruleNode20.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
       
//       		xmlCondition = xmlDoc.createElement("Condition20");
//       		MetaNodeChNameArray.length = 0;
//       		while (spanNode != lastNode) {
//       			
//       			if (spanNode.id == 'Spacer') {
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       			}
//       
//       			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//       			// 有优化的余地
//       			MetaNode = composeXML(xmlDoc, spanNode);
//       			if(MetaNode == null)
//       			{
//       				spanNode = spanNode.nextSibling;
//       				continue;
//       				}
//       			xmlCondition.appendChild(MetaNode);
//       
//       			if (spanNode.id == "BOM") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       			}
//       
//       			else if (spanNode.id == "BOMItem") {
//       			} else if (spanNode.id == "Operator") {
//       				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//       				{
//       					comASQL();
//       				}
//       			} else if (spanNode.id == "Link") {
//       				if (spanNodeArray.length != 0) {
//       					comASQL();
//       				}
//       				ColumnMetasChArray.length = 0;
//       			} else if (spanNode.id == "Left_Paren") {
//       			} else if (spanNode.id == "Right_Paren") {
//       			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//       				comASQL();
//       			}
//       
//       			spanNode = spanNode.nextSibling;
//       
//       		}
//       
//       		if (spanNodeArray.length != 0) {
//       			comASQL();
//       		}
//       
//       		xmlRule.appendChild(xmlCondition);
//       		composeRuleDesInCh();
//       
//       		ruleNode20 = ruleNode20.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes19 = document.getElementById('RuleZone19');
//       	 ruleNodes20 = document.getElementById('RuleZone20');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes19!=null && ruleNodes20!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes20.firstChild;
//       				var endNode = ruleNodes20.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
       					var spanNode = ruleNode.firstChild;
//       					var lastNode = ruleNode.lastChild;
//           
//       					while(spanNode!=lastNode)
//       					{
//       						
//       						if(spanNode.id=="BOM")
//       						{
//       							if(spanNode.getAttribute('EnName') == "RateSet")
//       							{
//       									var spanNodeTemp = spanNode.nextSibling
//       									spanNodeTemp = spanNodeTemp.nextSibling
//       									var rate = spanNodeTemp.getAttribute('EnName');
//       									sqlresult += "result";
//       									spanNode = spanNodeTemp.nextSibling;
//       							}
//       						else
//       							{
//       								sqlresult += "?"+spanNode.getAttribute('EnName')+".";
//       								}
//       						}
//       						
//       						if(spanNode.id=="BOMItem")
//       						{
//       							sqlresult += spanNode.getAttribute('EnName')+"?";
//       							
//       						}
//       						
//       						if(spanNode.id=="Operator")
//       						{
//       							if(spanNode.getAttribute('EnName') != null)
//       							{
//       								sqlresult += spanNode.getAttribute('EnName');
//       							}
//       							else
//       						{sqlresult+= "";}
//       							
//       						}
//       					
//       						spanNode = spanNode.nextSibling;
//       					}
//       					SQLStatement = SQLStatement.replace('Result1',''+sqlresult);
//       			}
//      }
//      
//      
      SQLStatement = SQLStatement + " end from #DTTable# ";
 // alert("SQLStatement-55--"+SQLStatement);
  // alert("CreateTable---"+CreateTable);
	ViewPara = xmlRule.xml;
	//alert("ViewPara---"+ViewPara);
	return completeParaAfterCompose();
}


function convertXMLToRule(xmlFile) {
	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");

		xmlDoc.async = false;
		xmlDoc.loadXML(xmlFile);
	} catch (e) {
		alert(I18NMsg("M0000072415"));
		return;
	}
	if (xmlDoc == null) {
		alert(I18NMsg("M0000072415"));
		return;
	}
	// 创建条件DIV区域
	var RuleZone = document.createElement("div");
	RuleZone.setAttribute('id', 'RuleZone');
	var IfNode = document.getElementById("conditions");
	IfNode.parentNode.insertBefore(RuleZone, IfNode.nextSibling);
	//wengf=====
	// 创建一条规则
	
	var ruleNode = xmlDoc.getElementsByTagName("Condition");
	var ruleDiv = null;
	var ruleMetaNodes = null;
	var ruleMetaNode = null;
	var spanNode = null;
	/* var disCol = new Array(); */
	var DTHeader = new Array();
	ColumnHeadArray.length = 0;
	ColumnDataTypeArray.length = 0;
	rowCount = 0;
	for ( var i = 0, len = ruleNode.length; i < len; i++) {
		ruleDiv = document.createElement("div");
		try {
			ruleMetaNodes = ruleNode[i].childNodes;
			DTHeader.length = 0;
			for ( var j = 0; j < ruleMetaNodes.length; j++) {
				ruleMetaNode = ruleMetaNodes[j];
				if (ruleMetaNode.getAttribute('id') == "Link") {
					DTHeader.length = 0;
				} else {
					DTHeader[DTHeader.length] = ruleMetaNode;

					if (ruleMetaNode.getAttribute('id') == "Input"
							|| ruleMetaNode.getAttribute('id') == "InputNodes") {

						composeDTHeader(DTHeader);
					}
				}
				spanNode = createIntegritySpanNode(ruleMetaNode);
				ruleDiv.appendChild(spanNode);
				spanNode = createOriginSpanNode("Spacer");
				ruleDiv.appendChild(spanNode);
			}
			spanNode = createDeleteButtonNode();
			ruleDiv.appendChild(spanNode);
		} catch (e) {
			alert(I18NMsg("M0000072416"));
		}
		RuleZone.appendChild(ruleDiv);
		rowCount++;
	}
	
	//alert(ruleNode1.length);
	//jiahy====
	  var RuleZone1 = document.createElement("div");
	  RuleZone1.setAttribute('id', 'RuleZone1');
	  var IfNode1 = document.getElementById("conditions1");
	  IfNode1.parentNode.insertBefore(RuleZone1, IfNode1.nextSibling);
	  var ruleNode1 = xmlDoc.getElementsByTagName("Condition1");
    var ruleDiv = null;
	  var ruleMetaNodes = null;
	  var ruleMetaNode = null;
	  var spanNode = null;
	  var DTHeader = new Array();
	 // ColumnHeadArray.length = 0;
	//  ColumnDataTypeArray.length = 0;
	 // rowCount = 0;
		for ( var i = 0, len = ruleNode1.length; i < len; i++) {
		ruleDiv = document.createElement("div");
		try {
			ruleMetaNodes = ruleNode1[i].childNodes;
			DTHeader.length = 0;
			for ( var j = 0; j < ruleMetaNodes.length; j++) {
				ruleMetaNode = ruleMetaNodes[j];
				if (ruleMetaNode.getAttribute('id') == "Link") {
					DTHeader.length = 0;
				} else {
					DTHeader[DTHeader.length] = ruleMetaNode;

					if (ruleMetaNode.getAttribute('id') == "Input"
							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
              composeDTHeader(DTHeader);
					}
				}
				spanNode = createIntegritySpanNode(ruleMetaNode);
				ruleDiv.appendChild(spanNode);
				spanNode = createOriginSpanNode("Spacer");
				ruleDiv.appendChild(spanNode);
			}
			spanNode = createDeleteButtonNode();
			ruleDiv.appendChild(spanNode);
		} catch (e) {
			alert(I18NMsg("M0000072416"));
		}
		RuleZone1.appendChild(ruleDiv);
		rowCount++;
	}
	//jiahy
	  var RuleZone3 = document.createElement("div");
	  RuleZone3.setAttribute('id', 'RuleZone3');
	  var IfNode3 = document.getElementById("conditions3");
	  IfNode3.parentNode.insertBefore(RuleZone3, IfNode3.nextSibling);
	  var ruleNode3 = xmlDoc.getElementsByTagName("Condition3");
	  var ruleDiv = null;
	  var ruleMetaNodes = null;
	  var ruleMetaNode = null;
	  var spanNode = null;
	  var DTHeader = new Array();
	//  ColumnHeadArray.length = 0;
	//  ColumnDataTypeArray.length = 0;
	 // rowCount = 0;
		for ( var i = 0, len = ruleNode3.length; i < len; i++) {
		ruleDiv = document.createElement("div");
		try {
			ruleMetaNodes = ruleNode3[i].childNodes;
			DTHeader.length = 0;
			for ( var j = 0; j < ruleMetaNodes.length; j++) {
				ruleMetaNode = ruleMetaNodes[j];
				if (ruleMetaNode.getAttribute('id') == "Link") {
					DTHeader.length = 0;
				} else {
					DTHeader[DTHeader.length] = ruleMetaNode;
  
					if (ruleMetaNode.getAttribute('id') == "Input"
							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
              composeDTHeader(DTHeader);
					}
				}
				spanNode = createIntegritySpanNode(ruleMetaNode);
				ruleDiv.appendChild(spanNode);
				spanNode = createOriginSpanNode("Spacer");
				ruleDiv.appendChild(spanNode);
			}
			spanNode = createDeleteButtonNode();
			ruleDiv.appendChild(spanNode);
		} catch (e) {
			alert(I18NMsg("M0000072416"));
		}
		RuleZone3.appendChild(ruleDiv);
		rowCount++;
	}
	  var buttonNode = createAddLineButton();
	  buttonNode.style.display = 'none';
	  RuleZone3.appendChild(buttonNode);

	 
	var RuleZone4 = document.createElement("div");
	RuleZone4.setAttribute('id', 'RuleZone4');
	var IfNode4 = document.getElementById("conditions4");
	IfNode4.parentNode.insertBefore(RuleZone4, IfNode4.nextSibling);
	var ruleNode4 = xmlDoc.getElementsByTagName("Condition4");         
	var ruleDiv = null;
	  var ruleMetaNodes = null;
	  var ruleMetaNode = null;
	  var spanNode = null;
	  var DTHeader = new Array();
	//  ColumnHeadArray.length = 0;
	//  ColumnDataTypeArray.length = 0;
	 // rowCount = 0;
	for ( var i = 0, len = ruleNode4.length; i < len; i++) {
		ruleDiv = document.createElement("div");
		try {
			ruleMetaNodes = ruleNode4[i].childNodes;
			DTHeader.length = 0;
			for ( var j = 0; j < ruleMetaNodes.length; j++) {
				ruleMetaNode = ruleMetaNodes[j];
				if (ruleMetaNode.getAttribute('id') == "Link") {
					DTHeader.length = 0;
				} else {
					DTHeader[DTHeader.length] = ruleMetaNode;

					if (ruleMetaNode.getAttribute('id') == "Input"
							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
             composeDTHeader(DTHeader);
					}
				}
				spanNode = createIntegritySpanNode(ruleMetaNode);
				ruleDiv.appendChild(spanNode);
				spanNode = createOriginSpanNode("Spacer");
				ruleDiv.appendChild(spanNode);
			}
			spanNode = createDeleteButtonNode();
			ruleDiv.appendChild(spanNode);
		} catch (e) {
			alert(I18NMsg("M0000072416"));
		}
		RuleZone4.appendChild(ruleDiv);
		rowCount++;
	}
	  
	  
	  var RuleZone5 = document.createElement("div");
	  RuleZone5.setAttribute('id', 'RuleZone5');
	  var IfNode5 = document.getElementById("conditions5");
	  IfNode5.parentNode.insertBefore(RuleZone5, IfNode5.nextSibling);
	  var ruleNode5 = xmlDoc.getElementsByTagName("Condition5");
	  var ruleDiv = null;
	  var ruleMetaNodes = null;
	  var ruleMetaNode = null;
	  var spanNode = null;
	  var DTHeader = new Array();
	 // ColumnHeadArray.length = 0;
	 // ColumnDataTypeArray.length = 0;
	 // rowCount = 0;
		for ( var i = 0, len = ruleNode5.length; i < len; i++) {
		ruleDiv = document.createElement("div");
		try {
			ruleMetaNodes = ruleNode5[i].childNodes;
			DTHeader.length = 0;
			for ( var j = 0; j < ruleMetaNodes.length; j++) {
				ruleMetaNode = ruleMetaNodes[j];
				if (ruleMetaNode.getAttribute('id') == "Link") {
					DTHeader.length = 0;
				} else {
					DTHeader[DTHeader.length] = ruleMetaNode;

					if (ruleMetaNode.getAttribute('id') == "Input"
							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
              composeDTHeader(DTHeader);
					}
				}
				spanNode = createIntegritySpanNode(ruleMetaNode);
				ruleDiv.appendChild(spanNode);
				spanNode = createOriginSpanNode("Spacer");
				ruleDiv.appendChild(spanNode);
			}
			spanNode = createDeleteButtonNode();
			ruleDiv.appendChild(spanNode);
		} catch (e) {
			alert(I18NMsg("M0000072416"));
		}
		RuleZone5.appendChild(ruleDiv);
		rowCount++;
	}
	   var buttonNode = createAddLineButton();
	   buttonNode.style.display = 'none';
	   RuleZone5.appendChild(buttonNode);

	  var RuleZone6 = document.createElement("div");
	  RuleZone6.setAttribute('id', 'RuleZone6');
	  var IfNode6 = document.getElementById("conditions6");
	  IfNode6.parentNode.insertBefore(RuleZone6, IfNode6.nextSibling);
	  var ruleNode6 = xmlDoc.getElementsByTagName("Condition6");
	  var ruleDiv = null;
	  var ruleMetaNodes = null;
	  var ruleMetaNode = null;
	  var spanNode = null;
	  var DTHeader = new Array();
	//  ColumnHeadArray.length = 0;
	//  ColumnDataTypeArray.length = 0;
	 // rowCount = 0;
		for ( var i = 0, len = ruleNode6.length; i < len; i++) {
		ruleDiv = document.createElement("div");
		try {
			ruleMetaNodes = ruleNode6[i].childNodes;
			DTHeader.length = 0;
			for ( var j = 0; j < ruleMetaNodes.length; j++) {
				ruleMetaNode = ruleMetaNodes[j];
				if (ruleMetaNode.getAttribute('id') == "Link") {
					DTHeader.length = 0;
				} else {
					DTHeader[DTHeader.length] = ruleMetaNode;

					if (ruleMetaNode.getAttribute('id') == "Input"
							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
               composeDTHeader(DTHeader);
					}
				}
				spanNode = createIntegritySpanNode(ruleMetaNode);
				ruleDiv.appendChild(spanNode);
				spanNode = createOriginSpanNode("Spacer");
				ruleDiv.appendChild(spanNode);
			}
			spanNode = createDeleteButtonNode();
			ruleDiv.appendChild(spanNode);
		} catch (e) {
			alert(I18NMsg("M0000072416"));
		}
		RuleZone6.appendChild(ruleDiv);
		rowCount++;
	}
	
//	  
//	  var RuleZone7 = document.createElement("div");
//	  RuleZone7.setAttribute('id', 'RuleZone7');
//	  var IfNode7 = document.getElementById("conditions7");
//	  IfNode7.parentNode.insertBefore(RuleZone7, IfNode7.nextSibling);
//	  var ruleNode7 = xmlDoc.getElementsByTagName("Condition7");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
////	  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode7.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode7[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//               composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone7.appendChild(ruleDiv);
//		rowCount++;
//	}
//	  var buttonNode = createAddLineButton();
//	  buttonNode.style.display = 'none';
//	  RuleZone7.appendChild(buttonNode);
//
//	  var RuleZone8 = document.createElement("div");
//	  RuleZone8.setAttribute('id', 'RuleZone8');
//	  var IfNode8 = document.getElementById("conditions8");
//	  IfNode8.parentNode.insertBefore(RuleZone8, IfNode8.nextSibling);
//	  var ruleNode8 = xmlDoc.getElementsByTagName("Condition8");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode8.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode8[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//            composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone8.appendChild(ruleDiv);
//		rowCount++;
//	}
//	
//	  
//	  var RuleZone9 = document.createElement("div");
//	  RuleZone9.setAttribute('id', 'RuleZone9');
//	  var IfNode9 = document.getElementById("conditions9");
//	  IfNode9.parentNode.insertBefore(RuleZone9, IfNode9.nextSibling);
//	  var ruleNode9 = xmlDoc.getElementsByTagName("Condition9");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	 // ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	  //rowCount = 0;
//		for ( var i = 0, len = ruleNode9.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode9[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//             composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone9.appendChild(ruleDiv);
//		rowCount++;
//	}
//	   var buttonNode = createAddLineButton();
//	   buttonNode.style.display = 'none';
//	   RuleZone9.appendChild(buttonNode);
//
//	  var RuleZone10 = document.createElement("div");
//	  RuleZone10.setAttribute('id', 'RuleZone10');
//	  var IfNode10 = document.getElementById("conditions10");
//	  IfNode10.parentNode.insertBefore(RuleZone10, IfNode10.nextSibling);
//	  var ruleNode10 = xmlDoc.getElementsByTagName("Condition10");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	//  rowCount = 0;
//		for ( var i = 0, len = ruleNode10.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode10[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//             composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone10.appendChild(ruleDiv);
//		rowCount++;
//	}
//	
//	  
//	  var RuleZone11 = document.createElement("div");
//	  RuleZone11.setAttribute('id', 'RuleZone11');
//	  var IfNode11 = document.getElementById("conditions11");
//	  IfNode11.parentNode.insertBefore(RuleZone11, IfNode11.nextSibling);
//	  var ruleNode11 = xmlDoc.getElementsByTagName("Condition11");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode11.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode11[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//              composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone11.appendChild(ruleDiv);
//		rowCount++;
//	}
//	   var buttonNode = createAddLineButton();
//	   buttonNode.style.display = 'none';
//	   RuleZone11.appendChild(buttonNode);
//
//	  var RuleZone12 = document.createElement("div");
//	  RuleZone12.setAttribute('id', 'RuleZone12');
//	  var IfNode12 = document.getElementById("conditions12");
//	  IfNode12.parentNode.insertBefore(RuleZone12, IfNode12.nextSibling);
//	  var ruleNode12 = xmlDoc.getElementsByTagName("Condition12");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode12.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode12[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//             composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone12.appendChild(ruleDiv);
//		rowCount++;
//	}
//	
//	  
//	  var RuleZone13 = document.createElement("div");
//	  RuleZone13.setAttribute('id', 'RuleZone13');
//	  var IfNode13 = document.getElementById("conditions13");
//	  IfNode13.parentNode.insertBefore(RuleZone13, IfNode13.nextSibling);
//	  var ruleNode13 = xmlDoc.getElementsByTagName("Condition13");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	 // ColumnHeadArray.length = 0;
//	 // ColumnDataTypeArray.length = 0;
//	  //rowCount = 0;
//		for ( var i = 0, len = ruleNode13.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode13[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//             composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone13.appendChild(ruleDiv);
//		rowCount++;
//	}
//	   var buttonNode = createAddLineButton();
//	   buttonNode.style.display = 'none';
//	   RuleZone13.appendChild(buttonNode);
//
//	
//	  var RuleZone14 = document.createElement("div");
//	  RuleZone14.setAttribute('id', 'RuleZone14');
//	  var IfNode14 = document.getElementById("conditions14");
//    IfNode14.parentNode.insertBefore(RuleZone14, IfNode14.nextSibling);
//	  var ruleNode14 = xmlDoc.getElementsByTagName("Condition14");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode14.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode14[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//            composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone14.appendChild(ruleDiv);
//		rowCount++;
//	}
//	
//	  
//	  var RuleZone15 = document.createElement("div");
//	  RuleZone15.setAttribute('id', 'RuleZone15');
//	  var IfNode15 = document.getElementById("conditions15");
//	  IfNode15.parentNode.insertBefore(RuleZone15, IfNode15.nextSibling);
//	  var ruleNode15 = xmlDoc.getElementsByTagName("Condition15");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	//  rowCount = 0;
//		for ( var i = 0, len = ruleNode15.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode15[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//             composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone15.appendChild(ruleDiv);
//		rowCount++;
//	}
//	   var buttonNode = createAddLineButton();
//	   buttonNode.style.display = 'none';
//	   RuleZone15.appendChild(buttonNode);
//
//	  var RuleZone16 = document.createElement("div");
//	  RuleZone16.setAttribute('id', 'RuleZone16');
//	  var IfNode16 = document.getElementById("conditions16");
//	  IfNode16.parentNode.insertBefore(RuleZone16, IfNode16.nextSibling);
//	  var ruleNode16 = xmlDoc.getElementsByTagName("Condition16");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode16.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode16[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//             composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone16.appendChild(ruleDiv);
//		rowCount++;
//	}
//	
//	  
//	  var RuleZone17 = document.createElement("div");
//	  RuleZone17.setAttribute('id', 'RuleZone17');
//	  var IfNode17 = document.getElementById("conditions17");
//	  IfNode17.parentNode.insertBefore(RuleZone17, IfNode17.nextSibling);
//	  var ruleNode17 = xmlDoc.getElementsByTagName("Condition17");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	//  rowCount = 0;
//		for ( var i = 0, len = ruleNode17.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode17[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//             composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone17.appendChild(ruleDiv);
//		rowCount++;
//	}
//	   var buttonNode = createAddLineButton();
//	   buttonNode.style.display = 'none';
//	   RuleZone17.appendChild(buttonNode);
//
//	  var RuleZone18 = document.createElement("div");
//	  RuleZone18.setAttribute('id', 'RuleZone18');
//	  var IfNode18 = document.getElementById("conditions18");
//	  IfNode18.parentNode.insertBefore(RuleZone18, IfNode18.nextSibling);
//	  var ruleNode18 = xmlDoc.getElementsByTagName("Condition18");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode18.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode18[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//              composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone18.appendChild(ruleDiv);
//		rowCount++;
//	}
//	
//	  
//	  var RuleZone19 = document.createElement("div");
//	  RuleZone19.setAttribute('id', 'RuleZone19');
//	  var IfNode19 = document.getElementById("conditions19");
//	  IfNode19.parentNode.insertBefore(RuleZone19, IfNode19.nextSibling);
//	  var ruleNode19 = xmlDoc.getElementsByTagName("Condition19");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	//  rowCount = 0;
//		for ( var i = 0, len = ruleNode19.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode19[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//              composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone19.appendChild(ruleDiv);
//		rowCount++;
//	}
//	   var spanNode = createAddLineButton();
//	   spanNode.style.display = 'none';
//	   RuleZone19.appendChild(spanNode);
//	   
//	  var RuleZone20 = document.createElement("div");
//	  RuleZone20.setAttribute('id', 'RuleZone20');
//	  var IfNode20 = document.getElementById("conditions20");
//	  IfNode20.parentNode.insertBefore(RuleZone20, IfNode16.nextSibling);
//	  var ruleNode20 = xmlDoc.getElementsByTagName("Condition20");
//	  var ruleDiv = null;
//	  var ruleMetaNodes = null;
//	  var ruleMetaNode = null;
//	  var spanNode = null;
//	  var DTHeader = new Array();
//	//  ColumnHeadArray.length = 0;
//	//  ColumnDataTypeArray.length = 0;
//	 // rowCount = 0;
//		for ( var i = 0, len = ruleNode20.length; i < len; i++) {
//		ruleDiv = document.createElement("div");
//		try {
//			ruleMetaNodes = ruleNode20[i].childNodes;
//			DTHeader.length = 0;
//			for ( var j = 0; j < ruleMetaNodes.length; j++) {
//				ruleMetaNode = ruleMetaNodes[j];
//				if (ruleMetaNode.getAttribute('id') == "Link") {
//					DTHeader.length = 0;
//				} else {
//					DTHeader[DTHeader.length] = ruleMetaNode;
//
//					if (ruleMetaNode.getAttribute('id') == "Input"
//							|| ruleMetaNode.getAttribute('id') == "InputNodes") {
//              composeDTHeader(DTHeader);
//					}
//				}
//				spanNode = createIntegritySpanNode(ruleMetaNode);
//				ruleDiv.appendChild(spanNode);
//				spanNode = createOriginSpanNode("Spacer");
//				ruleDiv.appendChild(spanNode);
//			}
//			spanNode = createDeleteButtonNode();
//			ruleDiv.appendChild(spanNode);
//		} catch (e) {
//			alert(I18NMsg("M0000072416"));
//		}
//		RuleZone20.appendChild(ruleDiv);
//		rowCount++;
//	}
	spanNode = createAddLineButton();
	spanNode.style.display = 'none';
	RuleZone.appendChild(spanNode);
	spanNode = createAddLineButton();
	spanNode.style.display = 'none';
	RuleZone1.appendChild(spanNode);	
	
//	spanNode = createAddLineButton();
//	spanNode.style.display = 'none';
//	RuleZone4.appendChild(spanNode);	
	
	//ColumnHeadArray[ColumnHeadArray.length] = "比率参数";
	ColumnDataTypeArray[ColumnDataTypeArray.length] = "String";

	ColumnHeadArray[ColumnHeadArray.length] = ""+I18NMsg("M0000069893")+"";
	ColumnDataTypeArray[ColumnDataTypeArray.length] = "String";
}



function getInputNodes() {
	var ruleNodes = document.getElementById('RuleZone');
	// 获取规则的第一个条件
	var ruleNode = ruleNodes.firstChild;
	// 获取规则的最后一个条件
	var endNode = ruleNodes.lastChild;
	InputNodes.length = 0;
	while (ruleNode != endNode) {
		var spanNode = ruleNode.firstChild;
		var lastNode = ruleNode.lastChild;

		while (spanNode != lastNode) {
			if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
				InputNodes[InputNodes.length] = spanNode;
			}
			spanNode = spanNode.nextSibling;
		}
		ruleNode = ruleNode.nextSibling;
	}
	//add by jiahy 20100925
//	alert(111);
	var ruleNodes = document.getElementById('RuleZone1');
	if(ruleNodes != null){
	     var ruleNode = ruleNodes.firstChild;
	     var endNode = ruleNodes.lastChild;
	     while (ruleNode != endNode) {
	     	var spanNode = ruleNode.firstChild;
	     	var lastNode = ruleNode.lastChild;
       
	     	while (spanNode != lastNode) {
	     		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
	     			InputNodes[InputNodes.length] = spanNode;
	     		}
	     		spanNode = spanNode.nextSibling;
	     	}
	     	ruleNode = ruleNode.nextSibling;
	     }
	  }
//	  alert(222);
		var ruleNodes = document.getElementById('RuleZone3');
		if(ruleNodes != null){			
	      var ruleNode = ruleNodes.firstChild;
	      var endNode = ruleNodes.lastChild;
	      while (ruleNode != endNode) {
	      	document.getElementById("conditions3").style.visibility="visible"; 
	      	var spanNode = ruleNode.firstChild;
	      	var lastNode = ruleNode.lastChild;
        
	      	while (spanNode != lastNode) {
	      		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
	      			InputNodes[InputNodes.length] = spanNode;
	      		}
	      		spanNode = spanNode.nextSibling;
	      	}
	      	ruleNode = ruleNode.nextSibling;
	      }
	  }
//	alert(333);
		var ruleNodes = document.getElementById('RuleZone4');
	if(ruleNodes!=null){
		if(ruleNodes.firstChild != null){
			document.getElementById("conditions4").style.visibility="visible";
			  var ruleNode = ruleNodes.firstChild;
	      var endNode = ruleNodes.lastChild;
	      while (ruleNode != endNode) {	      	
	      	var spanNode = ruleNode.firstChild;
	      	var lastNode = ruleNode.lastChild;
	      	while (spanNode != lastNode) {
	      		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
	      			InputNodes[InputNodes.length] = spanNode;
	      		}
	      		spanNode = spanNode.nextSibling;
	      	}
	      	ruleNode = ruleNode.nextSibling;
	      }
	   }
	 }
//	  alert(444);
	var ruleNodes = document.getElementById('RuleZone5');
	if(ruleNodes != null){
	      var ruleNode = ruleNodes.firstChild;
	      var endNode = ruleNodes.lastChild;
	      while (ruleNode != endNode) {
	      	document.getElementById("conditions5").style.visibility="visible";
	      	var spanNode = ruleNode.firstChild;
	      	var lastNode = ruleNode.lastChild;
        
	      	while (spanNode != lastNode) {
	      		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
	      			InputNodes[InputNodes.length] = spanNode;
	      		}
	      		spanNode = spanNode.nextSibling;
	      	}
	      	ruleNode = ruleNode.nextSibling;
	      } 
	  }
//	  alert(555);
		var ruleNodes = document.getElementById('RuleZone6');
	if(ruleNodes!=null){
		if(ruleNodes.firstChild != null){
			  document.getElementById("conditions6").style.visibility="visible";
			  var ruleNode = ruleNodes.firstChild;
	      var endNode = ruleNodes.lastChild;
	      while (ruleNode != endNode) {	      	
	      	var spanNode = ruleNode.firstChild;
	      	var lastNode = ruleNode.lastChild;
	      	while (spanNode != lastNode) {
	      		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
	      			InputNodes[InputNodes.length] = spanNode;
	      		}
	      		spanNode = spanNode.nextSibling;
	      	}
	      	ruleNode = ruleNode.nextSibling;
	      }
	   }
	 }
//	 alert(666);
//	    
//	   var ruleNodes = document.getElementById('RuleZone7');
//	   if(ruleNodes != null){
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	document.getElementById("conditions7").style.visibility="visible";
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	    }
//	    
//	   var ruleNodes = document.getElementById('RuleZone8');
//	 if(ruleNodes!=null){
//	   if(ruleNodes.firstChild != null){
//	   	document.getElementById("conditions8").style.visibility="visible"; 
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	    }
//	  }
//	
//	var ruleNodes = document.getElementById('RuleZone9');
//	if(ruleNodes != null){
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	document.getElementById("conditions9").style.visibility="visible";
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	  }
//	  
//	var ruleNodes = document.getElementById('RuleZone10');
//if(ruleNodes!=null){
//	if(ruleNodes.firstChild != null){
//		document.getElementById("conditions10").style.visibility="visible"; 
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	  }
//	}
//	
//		var ruleNodes = document.getElementById('RuleZone11');
//		if(ruleNodes != null){
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	document.getElementById("conditions11").style.visibility="visible"; 
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	   }
//	   
//		var ruleNodes = document.getElementById('RuleZone12');
//	if(ruleNodes!=null){
//		if(ruleNodes.firstChild != null){
//			 document.getElementById("conditions12").style.visibility="visible";
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	   }
//	 }
//	
//		var ruleNodes = document.getElementById('RuleZone13');
//		if(ruleNodes != null){
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	document.getElementById("conditions13").style.visibility="visible";
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	   }
//	   
//		var ruleNodes = document.getElementById('RuleZone14');
//	if(ruleNodes!=null){
//		if(ruleNodes.firstChild != null){
//			   document.getElementById("conditions14").style.visibility="visible"; 
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {	       	
//	       var spanNode = ruleNode.firstChild;
//	       var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	   }
//	 }
//	
//		var ruleNodes = document.getElementById('RuleZone15');
//		if(ruleNodes != null){
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	document.getElementById("conditions15").style.visibility="visible"; 
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	   }
//	   
//		var ruleNodes = document.getElementById('RuleZone16');
//	if(ruleNodes!=null){
//		if(ruleNodes.firstChild != null){
//	       document.getElementById("conditions16").style.visibility="visible";
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	  var spanNode = ruleNode.firstChild;
//	       	  var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	   }
//	 }
//	   
//		var ruleNodes = document.getElementById('RuleZone17');
//		if(ruleNodes != null){
//	       var ruleNode = ruleNodes.firstChild;
//	       var endNode = ruleNodes.lastChild;
//	       while (ruleNode != endNode) {
//	       	document.getElementById("conditions17").style.visibility="visible";
//	       	var spanNode = ruleNode.firstChild;
//	       	var lastNode = ruleNode.lastChild;
//         
//	       	while (spanNode != lastNode) {
//	       		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	       			InputNodes[InputNodes.length] = spanNode;
//	       		}
//	       		spanNode = spanNode.nextSibling;
//	       	}
//	       	ruleNode = ruleNode.nextSibling;
//	       }
//	   }
//	   
//	  var ruleNodes = document.getElementById('RuleZone18');
//	 if(ruleNodes!=null){
//	  if(ruleNodes.firstChild != null){
//	  	  document.getElementById("conditions18").style.visibility="visible";
//	      var ruleNode = ruleNodes.firstChild;
//	      var endNode = ruleNodes.lastChild;
//	      while (ruleNode != endNode) {
//	      	var spanNode = ruleNode.firstChild;
//	      	var lastNode = ruleNode.lastChild;
//        
//	      	while (spanNode != lastNode) {
//	      		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	      			InputNodes[InputNodes.length] = spanNode;
//	      		}
//	      		spanNode = spanNode.nextSibling;
//	      	}
//	      	ruleNode = ruleNode.nextSibling;
//	      }
//	  }
//	}
//	  
//	var ruleNodes = document.getElementById('RuleZone19');
//	if(ruleNodes != null){
//	      var ruleNode = ruleNodes.firstChild;
//	      var endNode = ruleNodes.lastChild;
//	      while (ruleNode != endNode) {
//	      	document.getElementById("conditions19").style.visibility="visible"; 
//	      	var spanNode = ruleNode.firstChild;
//	      	var lastNode = ruleNode.lastChild;
//        
//	      	while (spanNode != lastNode) {
//	      		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	      			InputNodes[InputNodes.length] = spanNode;
//	      		}
//	      		spanNode = spanNode.nextSibling;
//	      	}
//	      	ruleNode = ruleNode.nextSibling;
//	      }
//	  }
//	  
//		var ruleNodes = document.getElementById('RuleZone20');
//	if(ruleNodes!=null){
//		if(ruleNodes.firstChild != null){
//			  document.getElementById("conditions20").style.visibility="visible"; 
//	      var ruleNode = ruleNodes.firstChild;
//	      var endNode = ruleNodes.lastChild;
//	      while (ruleNode != endNode) {
//	      	var spanNode = ruleNode.firstChild;
//	      	var lastNode = ruleNode.lastChild;
//        
//	      	while (spanNode != lastNode) {
//	      		if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//	      			InputNodes[InputNodes.length] = spanNode;
//	      		}
//	      		spanNode = spanNode.nextSibling;
//	      	}
//	      	ruleNode = ruleNode.nextSibling;
//	      }
//	   }
//	 }
//	//add by jiahy 20100925
	
	InputNodes[InputNodes.length] = document.getElementById('Result');
}
