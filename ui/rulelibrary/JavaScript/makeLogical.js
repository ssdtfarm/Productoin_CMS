
var rowCount = 0; // 定制逻辑中行的数量

var reStr = "";
var isMenuUnfolded = false; // "如果"是否在被点击之后展开下拉菜单
var isMenuUnfolded1 = false;

var preEventNode = null; // 触发产生下拉框事件的节点
var spanNodeEnabled = true;// 节点能否响应鼠标点击事件的标志
var InputNodeEnabled = false;
// 用于标识相应节点所要携带的数据结构
var BOMIndex = new Array('id', 'EnName', 'ChName');
var BOMItemIndex = new Array('id', 'EnName', 'ChName', 'MatchType', 'Source','isHierarchical');
var OperatorIndex = new Array('id', 'EnName', 'ChName', 'MatchType','ResultType', 'ParaType', 'IsNextOperator');
var LinkIndex = new Array('id', 'EnName', 'ChName');
var ParenIndex = new Array('id', 'EnName', 'ChName');
var InputIndex = new Array('id', 'EnName', 'ChName');
// //连接型运算符数组
var LinkArray = new Array();

// 表示"when"后面是否有规则
var hasRule = false;
// 表示 then 后面是否有输出
var hasRule1 = false;

//var hasRule4 = false;
// 后台查询缓存
var queryCache = new Array();

var SQLStatement;// 存储规则的SQL
var countcase;
var CreateTable;// 存储建表语句的SQL
var ViewPara;// 存储规则反显示所需要的参数
var BOMSArray = new Array();// 存储规则所用的BOM
var SQLParaArray = new Array();// 存储规则反解析的参数
var RuleDesInCh;// 存储规则的中文名
var ColumnHeadArray = new Array();// 存储决策表列头所要显示的中文名
var ColumnMetasChArray = new Array();// 存储单列规则中文的的数组
var ColumnMetasChArray1 = new Array();// 存储单列规则中文的的数组
var ColumnDataTypeArray = new Array();// 存储决策表列的数据类型
var TableColumnNameArray = new Array();// 存储DT表中的列明，在决策表中用于列的Index
var ColumnMultipleArray = new Array();// 存储决策表所的运算符是否为“其中之一”
var BaseColumnArray = new Array();// 存储决策表的列是否为基础词条
var MetaNodeChNameArray = new Array();// 存储扫描到节点的中文名
var MetaNodeChNameArray1 = new Array();// 存储扫描到节点的中文名
var spanNodeArray = new Array();// 存储规则拼写中扫描到的节点
var spanNodeArray1 = new Array();// 存储规则拼写中扫描到的节点
var InputNodeArray = new Array();// 存储规则定制逻辑中Input节点
var BaseBOMItemSourceArray = new Array();
var InputNodes = new Array();
var DTColumnRecurArray = new Array();// 存储建表过程中列名重复的次数

function initI18n()
{
	LinkArray[0] = new Array("and", I18NMsg("M0000072381"));
	LinkArray[1] = new Array("or", I18NMsg("M0000072382"));
}
function hightLight() {
	// 节点在数据输入时不响应操作
	if (!spanNodeEnabled) {
		return;
	}
	// 节点字体变成斜体，鼠标变成手型，字体闪烁。
	else {
		var ob = event.srcElement;
		ob.style.fontStyle = "italic";
		ob.style.cursor = 'hand';
		ob.style.textDecoration = 'blink';
	}
}

function normalLight() {
	// 节点在数据输入时不响应操作
	if (!spanNodeEnabled) {
		return;
	}
	// 节点字体变成正常体，鼠标变成默认型，不闪烁。
	else {
		var ob = event.srcElement;
		ob.style.fontStyle = "normal";
		ob.style.cursor = 'default';
		ob.style.textDecoration = '';
	}
}

function showOrHideMenu() {
	
	if (spanNodeEnabled) {
		//alert("----isMenuUnfolded----"+isMenuUnfolded);
		if (!isMenuUnfolded)// 菜单未打开
		{
			unFoldMenu(); // 展开菜单
			isMenuUnfolded = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu1() {

	if (spanNodeEnabled) {
		if (!isMenuUnfolded1)// 菜单未打开
		{
			unFoldMenu1(); // 展开菜单

			isMenuUnfolded1 = true;// 设置记录标识为打开状态

		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded1 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点

	var nextNode = document.getElementById("conditions").nextSibling;
	if (hasRule) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone");
		var newLine = createNewAditionLine();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		//alert(divNode.innerHTML)
		//write(divNode.innerHTML);
		// 将form节点插入到当前节点之后
		//alert(nextNode.innerHTML);
		pareNode.insertBefore(divNode, nextNode);
		hasRule = true;
	}
}


function unFoldMenu1() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//wengf---
	var nextNode = document.getElementById("conditions1").nextSibling;
	if (hasRule1) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone1");
		var newLine = createNewAditionLine1();
		var buttonNode = createAddLineButton();
		buttonNode.style.display = 'none';
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后
		
		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule1 = true;
	}
}

// 折叠菜单函数
function foldMenu() {
	// 获取当前节点的父节点和下一个兄弟节点
	var nextNode = event.srcElement.nextSibling;
	nextNode.style.display = 'none';
}

// 创建新条件函数
function createNewAditionLine() {
	//alert("flag --"+flag);
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
	// 当条件不是第一个条件的时候，添加连接词
	if (rowCount != 0) {
		var linkNode = createOriginSpanNode('Link', false);
		divNode.appendChild(linkNode);
	} else {
		var spanNode = createOriginSpanNode('Spacer');
		divNode.appendChild(spanNode);
		spanNode = createOriginSpanNode('Spacer');
		divNode.appendChild(spanNode);
		spanNode = createOriginSpanNode('Spacer');
		divNode.appendChild(spanNode);
	}
	// 创建非库中节点
	var spacerNode = createOriginSpanNode('Spacer');
	divNode.appendChild(spacerNode);
	var spanNode = createOriginSpanNode('BOM', false);
	divNode.appendChild(spanNode);

	var spacerNode = createOriginSpanNode('Spacer');
	divNode.appendChild(spacerNode);
  var inputvalue = addInput();
	divNode.appendChild(spacerNode);
	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount++;
	return divNode;
}

// 创建新条件函数
function createNewAditionLine1() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
	// 当条件不是第一个条件的时候，添加连接词
	//if (rowCount1 != 0) {
	//	var linkNode = createOriginSpanNode('Link', false);
	//	divNode.appendChild(linkNode);
	//} else 
	//{
		var spanNode = createOriginSpanNode('Spacer');
		divNode.appendChild(spanNode);
		spanNode = createOriginSpanNode('Spacer');
		divNode.appendChild(spanNode);
		spanNode = createOriginSpanNode('Spacer');
		divNode.appendChild(spanNode);
	//}
	// 创建非库中节点
	var spacerNode = createOriginSpanNode('Spacer');
	divNode.appendChild(spacerNode);
	var spanNode = createOriginSpanNode('BOM', false);
	divNode.appendChild(spanNode);

	var spacerNode = createOriginSpanNode('Spacer');
	divNode.appendChild(spacerNode);

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	//rowCount1++;
	return divNode;
}
//
 //创建一个删除本条件的按钮
function createDeleteButtonNode() {
	var buttonNode = document.createElement("input");
	// 添加Button节点的鼠标响应事件
	buttonNode.setAttribute("type", "button");
	buttonNode.setAttribute("id", "DelButton");
	buttonNode.onclick = function() {
		deleteLine();
	}
	buttonNode.style.background = 'url(./resources/img/delete.jpg)';
	buttonNode.style.width = '35';
	buttonNode.style.height = '32';
	return buttonNode;
}

function deleteLine() {
	if (!spanNodeEnabled) {
		return;
	}
	if(event.srcElement.parentNode.parentNode.id == 'RuleZone1' || event.srcElement.parentNode.parentNode.id == 'RuleZone4'
	  || event.srcElement.parentNode.parentNode.id == 'RuleZone6' || event.srcElement.parentNode.parentNode.id == 'RuleZone8' 
	  || event.srcElement.parentNode.parentNode.id == 'RuleZone10' || event.srcElement.parentNode.parentNode.id == 'RuleZone12'
	  || event.srcElement.parentNode.parentNode.id == 'RuleZone14' || event.srcElement.parentNode.parentNode.id == 'RuleZone16'
	  || event.srcElement.parentNode.parentNode.id == 'RuleZone18' || event.srcElement.parentNode.parentNode.id == 'RuleZone20')
	{
		  
			var fatherNode = event.srcElement.parentNode;

			var uncleNode = fatherNode.nextSibling;
			var grandNode = fatherNode.parentNode;

			destroyMenu();
			grandNode.removeChild(fatherNode);
			if(event.srcElement.parentNode.parentNode.id == 'RuleZone1')
			   hasRule1 = false;//add by jiahy 20100921 使得点击过删除按钮后，再点击“计算”按钮时可以重新生成一行
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone4')
				 hasRule4 = false;
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone6')
				 hasRule6 = false;
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone8')
				 hasRule8 = false;
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone10')
				 hasRule10 = false; 
      else if(event.srcElement.parentNode.parentNode.id == 'RuleZone12')
				 hasRule12 = false;
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone14')
				 hasRule14 = false;
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone16')
				 hasRule16 = false;
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone18')
				 hasRule18 = false;
			else if(event.srcElement.parentNode.parentNode.id == 'RuleZone20')
				 hasRule20 = false;
	}
else
	{
				var fatherNode = event.srcElement.parentNode;

				var uncleNode = fatherNode.nextSibling;
				var grandNode = fatherNode.parentNode;
			
				destroyMenu();
			
				grandNode.removeChild(fatherNode);
				rowCount--;
				/*
				if (rowCount > 0) {
					var firstLine = grandNode.firstChild;
					var linkNode = firstLine.firstChild;
					if (linkNode.id == 'Link') {
						var spanNode = createOriginSpanNode("Spacer");
						firstLine.replaceChild(spanNode, linkNode);
					}
				}
				*/
	}
	

}
// 创建一个能够增加一个新条件的按钮
function createAddLineButton() {
	var buttonNode = document.createElement("input");
	// 添加Button节点的鼠标响应事件
	buttonNode.setAttribute("type", "button");
	buttonNode.setAttribute("id", "AddButton");
	buttonNode.onclick = function() {
		addNewLine();
	}
	buttonNode.style.background = 'url(./resources/img/add.jpg)'; //每行下面的“+”号按钮
	buttonNode.style.width = '35';
	buttonNode.style.height = '32';
	return buttonNode;
}

// 增加一个新条件
function addNewLine() {
	if (!spanNodeEnabled) {
		return;
	}
	var divNode = createNewAditionLine();
	var ob = event.srcElement;
	var fatherNode = ob.parentNode;
	fatherNode.insertBefore(divNode, ob);
}
function disableInputNodes() {
	InputNodeEnabled = false;
}

function disableSpanNodes() {
	spanNodeEnabled = false;// 节点能否响应鼠标点击事件的标志

}

function enableInputNodes() {
	InputNodeEnabled = true;
}

function enableSpanNodes() {
	spanNodeEnabled = true;// 节点能否响应鼠标点击事件的标志

}
/*
 * 创建Span节点的函数是本组件的重点 Span节点的数据结构如下： id:
 * 用于标识节点的类型，例如BOM，BOMItem，Operator，Pathesis，Input，Link EnName：用于记录节点的英文名
 * ChName: 用于记录节点的中文名 MatchType: 用于记录运算符与词条的匹配类型， ParaType: 用于记录运算符后携带的参数类型，
 * Source：用于记录基础词条的取值来源， ResultType：用于记录运算符的运算结果类型
 * IsNextOperator：用于记录运算符后面能否接运算符的标志 isMenu是节点是否为下拉菜单中节点的标志，true表示“是”，false表示“否”
 */
function createSpanNode(paraArray, isMenu) {
	var spanNode = document.createElement("span");
	//spanNode.style.float = "left";

	var nodeType = '';
	var displayText = '';

	// 添加"spanNode"节点的属性,比如鼠标响应事件
	if (!(!!paraArray)) {
		alert(I18NMsg("M0000072383"));//创建节点传递的参数出错！
		return;
	}
	for ( var i = 0, length = paraArray.length; i < length; i++) {		
		spanNode.setAttribute(paraArray[i].attribute, paraArray[i].value);
		if (paraArray[i].attribute == 'id')
			nodeType = paraArray[i].value;
		if (paraArray[i].attribute == 'ChName') {
			displayText = paraArray[i].value;
		}		
		 // displayText = paraArray[1].value;    
	}

	if (!isMenu) // 判断
	{//如果传送的false，进入这里
		// 如果是
		if (nodeType != 'Input' && nodeType != 'AddInput'
				&& nodeType != "Delete") {
			spanNode.onmousedown = function() {
				popMenu();
			}
		} else if (nodeType == 'Input') {
			spanNode.onmousedown = function() {
				changeToInput();
			}
		} else if (nodeType == 'AddInput') {
			spanNode.onclick = function() {
				addInput();
			}
		} else if (nodeType == "Delete") {
			spanNode.onclick = function() {
				deleteInput();
			}
		}
	} else {
		spanNode.onmousedown = function() {//鼠标按下
			handleClick();
		}
	}
	// 创建并添加"Text"内容
	if (spanNode.id == "Spacer") {
		spanNode.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp';
	} else {
		spanNode.onmouseout = function() {//移开鼠标
			normalLight();
		}
		spanNode.onmouseover = function() {
			hightLight();
		}
		spanNode.innerHTML = displayText;
	}
	return spanNode;
}

function addInput() {
	if (!InputNodeEnabled)
		return;
	var srcNode = event.srcElement;
	var pareNode = srcNode.parentNode;

	if (pareNode && pareNode.id) {
		if (pareNode.id == "InputNodes") {
			var spanNode = createOriginSpanNode("comma");
			pareNode.insertBefore(spanNode, srcNode);
			spanNode = createOriginSpanNode("Input");
			pareNode.insertBefore(spanNode, srcNode);
		}
	}

}
function deleteInput() {
	var obNode = preEventNode;
	var pareNode = obNode.parentNode;
	if (pareNode && pareNode.id == "InputNodes") {
		var firstInput = pareNode.firstChild;

		while (firstInput.id != "Input") {
			firstInput = firstInput.nextSibling;
		}
		if (firstInput == obNode) {
			alert(I18NMsg("M0000072384"));
			return;
		} else {
			pareNode.removeChild(obNode.previousSibling);
			pareNode.removeChild(obNode);
		}
	}
}
function popMenu() {
	// 记录被点击的源节点
	preEventNode = event.srcElement;
	var spanArray = new Array();
	var clickedNode = event.srcElement;
	// 判断鼠标被点击的左右键
	var mouseButton = event.button;
	// 判断被点击节点的类型
	var Id = clickedNode.id;
	if (!Id || Id == 'Spacer') {
		return;
	}
	// 处于数据输入状态，不响应鼠标事件
	if (!spanNodeEnabled) {
		if (Id == "Input" && mouseButton == 2) {
			var pareNode = preEventNode.parentNode;
			var firstInputNode = pareNode.firstChild;
			while (firstInputNode.id != "Input"){
				firstInputNode = firstInputNode.nextSibling;
			}
			if (firstInputNode == preEventNode) {
				return;
			}
			var spanNode = createOriginSpanNode("Delete");
			spanArray[spanArray.length] = spanNode;
		} else
			return;
	} else {
		if (mouseButton == 1)// 鼠标左击
		{
			if (Id == 'BOM') {
				spanArray = prepareMenu_Left('BOM');
			} else if (Id == 'BOMItem')
				spanArray = prepareMenu_Left('BOMItem');
			else if (Id == 'Operator')
				spanArray = prepareMenu_Left('Operator');
			else if (Id == 'Link')
				spanArray = prepareMenu_Left('Link');
		} else if (mouseButton == 2)// 鼠标右击
		{
			if (Id == 'BOM')
				spanArray = prepareMenu_Right('BOM');
			else if (Id == 'BOMItem')
				spanArray = prepareMenu_Right('BOMItem');
			else if (Id == 'Operator') {//modify by jiahy 20100924
				//if (preEventNode.EnName == "is null"
				//		|| preEventNode.EnName == "is not null") {
				//	spanArray = prepareMenu_Right('Operator');
				//} 
				spanArray = prepareMenu_Right('Operator');
			} else if (Id == 'Input')
				spanArray = prepareMenu_Right('Input');
			else if (Id == 'Left_Paren')
				spanArray = prepareMenu_Right('Left_Paren');
			else if (Id == 'Right_Paren')
				spanArray = prepareMenu_Right('Right_Paren');
			else if (Id == 'Link')
				spanArray = prepareMenu_Right('Link');
			else if (Id == 'InputRightScope')
				spanArray = prepareMenu_Right('InputRightScope');
		}
	}
	displayMenu(spanArray);
	document.oncontextmenu = function() {
		if (event.srcElement == preEventNode)		
			{
				return false;
				}
	}
}

function displayMenu(spanArray) {
	if (spanArray == null || spanArray.length == 0) {
		return;
	}
	var position_x = preEventNode.offsetLeft;
	var position_y = preEventNode.offsetTop + preEventNode.offsetHeight;

	var disNode = document.getElementById("display");

	while (disNode.firstChild) {
		disNode.removeChild(disNode.firstChild);
	}

	for ( var i = 0; i < spanArray.length; i++) {

		disNode.appendChild(spanArray[i]);

		var brNode = document.createElement('br');
		disNode.appendChild(brNode);
	}
	disNode.style.left = position_x;
	disNode.style.top = position_y+10;
	disNode.style.zIndex = "10";
	disNode.style.display = "";
	document.onclick = function() {		
		var srcNode = event.srcElement;
		if (srcNode != preEventNode && srcNode != disNode) {
			destroyMenu();
		}
	}
}

function changeToInput() {
	var DISPLAYINPUT = this;

	preEventNode = event.srcElement;
	var clickedNode = event.srcElement;
	var mouseButton = event.button;
	// 将其它Input节点转化成Span节点
	convertInputsToSpans();
	var Id = clickedNode.id;
	if (mouseButton == 1) {
		if (!InputNodeEnabled)// '请输入一个值'节点在规则逻辑定制过程中不响应鼠标左击操作
		{
			return;
		} else // '请输入一个值'节点在数据录入过程中响应鼠标左击事件
		{
			var BOMItemNode = null;
			var OperatorNode = null;
			var currNode = clickedNode;
			if (!!currNode.parentNode.id
					&& currNode.parentNode.id == "InputNodes") {
				currNode = currNode.parentNode;
			}
			while (!!currNode) {
				if (currNode.id == "BOMItem") {
					BOMItemNode = currNode;
					break;
				} else if (currNode.id == "Operator"
						&& currNode.ResultType == "Boolean") {
					OperatorNode = currNode;
				}
				currNode = currNode.previousSibling;
			}

			if (!!BOMItemNode) {
				// 如果输入值是基础词条
				if (!!BOMItemNode.Source) {
					var InputMenu = new Array();
					var strSQL = BOMItemNode.Source;
					InputMenu = getInputSource(strSQL);
					var spanArray = prepareBaseMenu(InputMenu);
					displayMenu(spanArray);
				}
				// 如果输入值不是基础词条
				else {
					var dataType = OperatorNode.ParaType;
					displayInput(clickedNode, dataType);
					/*
					 * preEventNode.innerHTML=""; field =new
					 * Ext.form.DateField({renderTo:preEventNode , format:
					 * 'Y-m-d H:i:s',width:150 });
					 */
				}
			}
		}
	} else {
		popMenu();
	}
}

function displayInput(obNode, dataType) {

	var fatherNode = obNode.parentNode;

	var first = true;

	var spanNode = document.createElement("span");
	spanNode.id = "Input";

	var inputNode = document.createElement('input');
	inputNode.setAttribute('type', 'input');
	inputNode.setAttribute('id', 'Input');
	inputNode.setAttribute('Editable', 'Yes');
	inputNode.setAttribute('size', '18');

	if (!!obNode.EnName) {
		inputNode.value = obNode.EnName;
	}
	inputNode.onkeydown = function() {
		handleKey(this);
	}
	fatherNode.replaceChild(inputNode, obNode);
	inputNode.focus();
	inputNode.select();

	document.onclick = function() {
		convertInputsToSpans();
	}
}
function handleKey(inputNode) {
	getInputNodes();

	if (event.keyCode == 13) {
		convertInputsToSpans();
	}
}
function getIndexOf(inputNode) {
	for ( var i = 0; i < InputNodes.length; i++) {
		if (InputNodes[i] == inputNode) {
			return i;
		}
	}
}
function convertInputsToSpans() {
	var spanNode;
	var type;
	getInputNodes();
	for ( var i = 0; i < InputNodes.length; i++) {
		spanNode = InputNodes[i];
		type = ColumnDataTypeArray[i];
		if (spanNode.id == "Input") {
			changInputToSpan(spanNode, type);
		} else {
			var childNode = spanNode.firstChild;
			while (childNode) {
				if (childNode.id == "Input", type) {
					changInputToSpan(childNode);
				}
				childNode = childNode.nextSibling;
			}
		}
	}

}
function changInputToSpan(inputNode, type) {
	if (!!inputNode.Editable) {
		if (inputNode.Editable == "Yes") {

			var numRegExp = /^(([1-9][0-9]*)|(0)|((([1-9][0-9]*)|[0-9])\.[0-9]+))$/;
			var dateRegExp = /^\d{4}-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|31) (([01][0-9])|(2[0-3])):([0-5][0-9]):([0-5][0-9])$/
			var spanNode = null;
			if (inputNode.value != '') {
				if (type == "Number") {
					if (!numRegExp.test(inputNode.value)) {
						alert(I18NMsg("M0000072385"));
						return;
					}

				} else if (type == "Date") {
					if (!dateRegExp.test(inputNode.value)) {
						alert(I18NMsg("M0000053880"));
						return;
					}
				}
				var paraArray = new Array();
				paraArray[0] = {
					attribute :'id',
					value :'Input'
				};
				paraArray[1] = {
					attribute :'EnName',
					value :inputNode.value
				};
				paraArray[2] = {
					attribute :'ChName',
					value :inputNode.value
				};
				spanNode = createSpanNode(paraArray, false);
			} else {
				spanNode = createOriginSpanNode('Input');
			}
			try {
				var fatherNode = inputNode.parentNode;  
				fatherNode.replaceChild(spanNode, inputNode);
			} catch (e) {

			}
		}
	}
}

function handleClick()// 用下拉框中的节点取代事件源节点，并在必要时生成一些新节点
{
	var srcNode = event.srcElement;
	if (srcNode.EnName != preEventNode.EnName) {
		// 将新节点信息取代原事件节点信息
		var fatherNode = preEventNode.parentNode;
		if (srcNode.id == "BOM") {
			deleteNodesAfter(preEventNode);			
			appendNewNodes('BOM', preEventNode, srcNode);
		} else if (srcNode.id == "BOMItem") {
			deleteNodesAfter(preEventNode);
			appendNewNodes('BOMItem', preEventNode, srcNode);
		} else if (srcNode.id == "Operator") {
			deleteNodesAfter(preEventNode);
			appendNewNodes('Operator', preEventNode, srcNode);//srcNode 所选的运算符节点，preEventNode 所选运算符节点的“请选择运算符节点”
		} else if (srcNode.id == 'Link') {
		}
		if (srcNode.id == 'Input') {
			srcNode.onmousedown = function() {
				changeToInput();
			}
		} else {
			srcNode.onmousedown = function() {
				popMenu();
			}
		}
		//alert(srcNode.ChName+"---"+srcNode.EnName);
		srcNode.innerHTML=srcNode.EnName;		
		//alert(srcNode.ChName+"---"+srcNode.EnName);
					
		fatherNode.replaceChild(srcNode, preEventNode);
		//alert(srcNode.ChName+"---"+srcNode.EnName);
		destroyMenu();
	}
}

function destroyMenu() {
	var disNode = document.getElementById("display");
	if (disNode.style.display != 'none') {
		while (disNode.firstChild) {
			disNode.removeChild(disNode.firstChild);
		}		
		disNode.style.display = "none";
	}
}
function deleteNodesAfter(ob) {
	var fromNode = ob;
	var fatherNode = fromNode.parentNode;
	var lastNode = fatherNode.lastChild;
	// 需要针对实际情况进行修正
	while (fromNode.nextSibling != lastNode
			&& fromNode.nextSibling.id != 'Link'
			&& fromNode.nextSibling.id != 'Left_Paren'
			&& fromNode.nextSibling.id != 'Right_Paren') {
		fatherNode.removeChild(fromNode.nextSibling);
	}
}

function appendNewNodes(id, preEventNode, srcNode) {
	var Id = id;
	var obNode = preEventNode;//
	var srNode = srcNode;//
	if (Id == 'BOM') {
		if (preEventNode.nextSibling.id != 'BOMItem') {
			var fatherNode = preEventNode.parentNode;
			// 创建一个BOMItem节点
			var spanNode = null;
			spanNode = createOriginSpanNode('BOMItem');
			fatherNode.insertBefore(spanNode, preEventNode.nextSibling);

			spanNode = createOriginSpanNode('Spacer');
			fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
		}
	} else if (Id == 'BOMItem') {
		var fatherNode = preEventNode.parentNode;
		var preNode = preEventNode.previousSibling;

		var isFirstBOMItem = true;
		var createNext = true;
		while (preNode && preNode.id != 'Link') {
//			if (preNode.id == 'Operator' && preNode.ResultType == 'Boolean') {
//				createNext = false;
//				break;
//			}
//modify by jiahy 20100921
      if(preNode.id=='Operator' && (preNode.EnName=='>=' || preNode.EnName=='<=')){
			  
		  }else if (preNode.id == 'Operator' && preNode.ResultType == 'Boolean') {
				  createNext = false;
				  break;
			}
			preNode = preNode.previousSibling;
		}
		// 创建一个BOMItem节点
		if (createNext) {
			var spanNode = null;
			spanNode = createOriginSpanNode('Operator');
			fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
			spanNode = createOriginSpanNode('Spacer');
			fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
		}
	} else if (Id == 'Operator') {
		var spanNode = null;
		var fatherNode = preEventNode.parentNode;
		if (srNode.IsNextOperator == 0) {
			return;
		}
		else if (srNode.IsNextOperator == 1) {  //IsNextOperator 对应表LRCommand.ParaNum jiahy 20100920
			spanNode = createOriginSpanNode('Operator');
			fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
			spanNode = createOriginSpanNode('Spacer');
			fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
		} else if (srNode.IsNextOperator == 2) {
			     //'EnName',    'ChName', 'MatchType','ResultType', 'ParaType', 'IsNextOperator'
//lrcommand.(Implenmation,Display,   CommandType,ResultType,   ParaType,    ParaNum)
//上面为变量和lrcommand表中字段的对应关系 jiahy 20100920
			if (srNode.ResultType == 'Boolean') {
				if (srNode.EnName == "instrExt(@,#,$)>0"
						|| srNode.EnName == "instrExt(@,#,$)=0") {
					var InputNodes = createInputNodes();
					fatherNode.insertBefore(InputNodes,
							preEventNode.nextSibling);
					//spanNode = createOriginSpanNode('Spacer');
					//fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
				}
				else if(srNode.EnName=='>=' || srNode.EnName=='<=' || srNode.EnName=='='){//jiahy add 20100921 
					spanNode = createOriginSpanNode('BOM');
				  fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
				  spanNode = createOriginSpanNode('Spacer');
				  fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
				}
				else{
					
					spanNode = create_input(); 
					fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
					spanNode = createOriginSpanNode('Spacer');
					fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
				}
			}
			else if(srNode.ResultType == 'String' && (srNode.EnName=='+' || srNode.EnName=='-')){//jiahy add 为处理indexcalno>=?indexcalno?-2这种形式
				spanNode = create_input(); 
					fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
					spanNode = createOriginSpanNode('Input');
					fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
					spanNode = createOriginSpanNode('Spacer');
					fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
			} 
			else {
				
				spanNode = createOriginSpanNode('BOM');
				fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
				spanNode = createOriginSpanNode('Spacer');
				fatherNode.insertBefore(spanNode, preEventNode.nextSibling);
			}
		}

	}
}

function createInputNodes() {

	var InputNodes = createOriginSpanNode('InputNodes');

	var spanNode = createOriginSpanNode('InputLeftScope');
	InputNodes.appendChild(spanNode);
	spanNode = createOriginSpanNode('Spacer');
	InputNodes.appendChild(spanNode);
	spanNode = createOriginSpanNode('Input');
	InputNodes.appendChild(spanNode);
	spanNode = createOriginSpanNode("AddInput");
	InputNodes.appendChild(spanNode);
	spanNode = createOriginSpanNode('Spacer');
	InputNodes.appendChild(spanNode);
	spanNode = createOriginSpanNode('InputRightScope');

	InputNodes.appendChild(spanNode);
	return InputNodes;

}
function createOriginSpanNode(id) {
	var reSpanNode = null;
	var paraArray = new Array();
	if (id == 'BOM') {
		paraArray[0] = {
			attribute :'id',
			value :'BOM'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :I18NMsg("M0000072386")//请选择对象
		};
	} else if (id == 'BOMItem') {
		paraArray[0] = {
			attribute :'id',
			value :'BOMItem'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :I18NMsg("M0000072387")//M0000072387:的
		};
	} else if (id == 'Operator') {
		paraArray[0] = {
			attribute :'id',
			value :'Operator'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :I18NMsg("M0000072388")//请选择操作符
		};
	} else if (id == 'Input') {
		paraArray[0] = {
			attribute :'id',
			value :'Input'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :I18NMsg("M0000072389")//请输入值
		};
		paraArray[2] = {
			attribute :'EnName',
			value :''
		};
	}else if (id == 'Link') {
		paraArray[0] = {
			attribute :'id',
			value :'Link'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :I18NMsg("M0000072381")
		};
		paraArray[2] = {
			attribute :'EnName',
			value :'and'
		};
	} else if (id == 'Left_Paren') {
		paraArray[0] = {
			attribute :'id',
			value :'Left_Paren'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :'('
		};
		paraArray[2] = {
			attribute :'EnName',
			value :'('
		};
	} else if (id == 'Right_Paren') {
		paraArray[0] = {
			attribute :'id',
			value :'Right_Paren'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :')'
		};
		paraArray[2] = {
			attribute :'EnName',
			value :')'
		};
	} else if (id == 'Spacer') {
		paraArray[0] = {
			attribute :'id',
			value :'Spacer'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :''
		};
	} else if (id == 'InputRightScope') {
		paraArray[0] = {
			attribute :'id',
			value :'InputRightScope'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :'}'
		};
		paraArray[2] = {
			attribute :'EnName',
			value :'}'
		};
	} else if (id == 'InputLeftScope') {
		paraArray[0] = {
			attribute :'id',
			value :'InputLeftScope'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :'{'
		};
		paraArray[2] = {
			attribute :'EnName',
			value :'{'
		};
	} else if (id == 'InputNodes') {
		paraArray[0] = {
			attribute :'id',
			value :'InputNodes'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :''
		};
		paraArray[2] = {
			attribute :'EnName',
			value :''
		};
	} else if (id == "AddInput") {
		paraArray[0] = {
			attribute :'id',
			value :'AddInput'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :'&nbsp;&nbsp;+&nbsp;&nbsp;'
		};
		paraArray[2] = {
			attribute :'EnName',
			value :'+'
		};
	} else if (id == "comma") {
		paraArray[0] = {
			attribute :'id',
			value :'comma'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :'&nbsp;&nbsp;;&nbsp;&nbsp;'
		};
		paraArray[2] = {
			attribute :'EnName',
			value :';'
		};
	} else if (id == "Delete") {
		paraArray[0] = {
			attribute :'id',
			value :'Delete'
		};
		paraArray[1] = {
			attribute :'ChName',
			value :I18NMsg("M0000047091")
		};
		paraArray[2] = {
			attribute :'EnName',
			value :'Delete'
		};
	}

	reSpanNode = createSpanNode(paraArray, false);
	return reSpanNode;
}

function create_input()
{
    var wt = document.createElement("input");
		wt.name = "eneter";
		return wt;
		}

function prepareMenu_Left(id) {
	var Id = id;
	var reSpanArray = new Array();
	var spanNode = null;

	if (Id == 'BOM') {
		var BOMArray = getBOMArray();
		var paraArray = new Array();
		if (BOMArray != null) {
		//	var str = '';
			paraArray[0] = {
				attribute :'id',
				value :'BOM'
			};
			for ( var i = 0, length = BOMArray.length; i < length; i++) {
				for ( var j = 0, len = BOMArray[i].length; j < len; j++) {
					paraArray[j + 1] = {
						attribute :BOMIndex[j + 1],
						value :BOMArray[i][j]
					};
				}
				spanNode = createSpanNode(paraArray, true);//生成下一个节点 jiahy
				reSpanArray[reSpanArray.length] = spanNode;
			}
		} else {
			alert(I18NMsg("M0000072390"));
		}
	}else if (Id == 'Link') {//2010-09-01 jiahaiyan     将“and” 改为下拉框“and”、“or”
		var LinkArray = getANDORArray();
		var paraArray = new Array();
		if (LinkArray != null) {
				paraArray[0] = {
					attribute :'id',
					value :'Link'
				};
				for ( var i = 0, length = LinkArray.length; i < length; i++) {
					for ( var j = 0, len = LinkArray[i].length; j < len; j++) {
						paraArray[j + 1] = {
							attribute :LinkIndex[j + 1],
							value :LinkArray[i][j]
						};
					}
					spanNode = createSpanNode(paraArray, true);
					reSpanArray[reSpanArray.length] = spanNode;
				}
		}
	}else if (Id == 'BOMItem') {
		var infArray = new Array();
		var infArray = getNodeInformation(preEventNode, 'BOMItem');//获取运算符节点之前节点的信息

		var BOMItemArray = new Array();
		BOMItemArray = getBOMItemArray(infArray);
		var paraArray = new Array();
		if (BOMItemArray != null) {
			paraArray[0] = {
				attribute :'id',
				value :'BOMItem'
			};
			for ( var i = 0, length = BOMItemArray.length; i < length; i++) {
				for ( var j = 0, len = BOMItemArray[i].length; j < len; j++) {
					paraArray[j + 1] = {
						attribute :BOMItemIndex[j + 1],
						value :BOMItemArray[i][j]
					};
				}
				spanNode = createSpanNode(paraArray, true);
				reSpanArray[reSpanArray.length] = spanNode;
			}
		}
	} else if (Id == 'Operator') {
		var infArray = new Array();
		var infArray = getNodeInformation(preEventNode, 'Operator');
		var OperatorArray = new Array();
		OperatorArray = getOperatorArray(infArray);//获得运算符		
		var paraArray = new Array();

		if (OperatorArray != null) {
			paraArray[0] = {
				attribute :'id',
				value :'Operator'
			};
			for ( var i = 0, length = OperatorArray.length; i < length; i++) {
				//alert("11");
				for ( var j = 0, len = OperatorArray[i].length; j < len; j++) {
				//	alert("22");
					paraArray[j + 1] = {
						attribute :OperatorIndex[j + 1],
						value :OperatorArray[i][j]
					};
				//	alert("OperatorIndex[j + 1]--"+j+1+"---"+OperatorIndex[j + 1]);
				}
				spanNode = createSpanNode(paraArray, true);
				reSpanArray[reSpanArray.length] = spanNode;
			}
		}
	} 
//	else if (Id == 'Link') {//2010-09-01 jiahaiyan 
//		var paraArray = new Array();
//		if (LinkArray != null) {
//			for ( var i = 0, length = LinkArray.length; i < length; i++) {
//				paraArray[0] = {
//					attribute :'id',
//					value :'Link'
//				};
//				for ( var i = 0, length = LinkArray.length; i < length; i++) {
//					for ( var j = 0, len = LinkArray[i].length; j < len; j++) {
//						paraArray[j + 1] = {
//							attribute :LinkIndex[j + 1],
//							value :LinkArray[i][j]
//						};
//					}
//					spanNode = createSpanNode(paraArray, true);
//					reSpanArray[reSpanArray.length] = spanNode;
//				}
//			}
//		}
//
//	}
	return reSpanArray;

}
/*
 * 01代表增加左括号， 02代表增加右括号， 03代表删除节点本身 04代表将BOM转换成Input 05代表将Input转换成BOM 06代表增加运算符
 * 07代表增加条件 08代表增加Input节点 09增加BOM
 */
function prepareMenu_Right(id) {
	var Id = id;
	var reArray = new Array();
	var menuOption = null;

	var obNode = preEventNode;

	if (Id == 'BOM') {
		// 添加'('
		menuOption = createMenuOption('01');
		reArray[reArray.length] = menuOption;
		// 删除BOM、将BOM转换成Input
		var preNode = obNode.previousSibling;
		var isFirstBOM = true;
		while (preNode && preNode.id != 'Link') {
			if (preNode.id == 'BOM') {
				isFirstBOM = false;
				break;
			}
			preNode = preNode.previousSibling;
		}
		if (!isFirstBOM) {
			menuOption = createMenuOption('03');
			reArray[reArray.length] = menuOption;
			menuOption = createMenuOption('04');
			reArray[reArray.length] = menuOption;
		}
	} else if (Id == 'BOMItem') {
		// 添加‘(’
		menuOption = createMenuOption('02');
		reArray[reArray.length] = menuOption;
		// 增加运算符和增加条件
		var nextNode = obNode.nextSibling;
		if (nextNode == obNode.parentNode.lastNode || nextNode.id != 'Operator') {
			menuOption = createMenuOption('06');
			reArray[reArray.length] = menuOption;

			menuOption = createMenuOption('07');
			reArray[reArray.length] = menuOption;
		}
	} else if (Id == 'Operator') {//modify by jiahy 20100924
		//menuOption = createMenuOption('02');
		//reArray[reArray.length] = menuOption;
		//menuOption = createMenuOption('07');
		//reArray[reArray.length] = menuOption;
		alert(03);
			menuOption = createMenuOption('03');
			reArray[reArray.length] = menuOption;
	} else if (Id == 'Link') {
		menuOption = createMenuOption('01');
		reArray[reArray.length] = menuOption;
	} else if (Id == 'Input') {
		menuOption = createMenuOption('02');
		reArray[reArray.length] = menuOption;

		menuOption = createMenuOption('05');
		reArray[reArray.length] = menuOption;
		menuOption = createMenuOption('07');
		reArray[reArray.length] = menuOption;
	} else if (Id == 'Left_Paren' || Id == 'Right_Paren') {
		menuOption = createMenuOption('03');
		reArray[reArray.length] = menuOption;
	} else if (Id == 'InputRightScope') {
		menuOption = createMenuOption('02');
		reArray[reArray.length] = menuOption;
		menuOption = createMenuOption('07');
		reArray[reArray.length] = menuOption;
	}
	return reArray;
}

function prepareBaseMenu(inforArray) {
	var spanArray = new Array();

	for ( var i = 0, len = inforArray.length; i < len; i++) {
		var paraArray = new Array();

		paraArray[0] = {
			attribute :'id',
			value :'Input'
		};
		paraArray[1] = {
			attribute :'EnName',
			value :inforArray[i][0] + '-' + inforArray[i][1]
		};
		paraArray[2] = {
			attribute :'ChName',
			value :inforArray[i][0] + '-' + inforArray[i][1]
		};

		spanArray[spanArray.length] = createSpanNode(paraArray, true);
	}

	return spanArray;
}

/*
 * 01代表增加左括号， 02代表增加右括号， 03代表删除节点本身 04代表将BOM转换成Input 05代表将Input转换成BOM 06代表增加运算符
 * 07代表增加条件 08代表增加Input节点 09增加BOM
 */
function createMenuOption(menuIndex) {
	var spanNode = document.createElement("span");
	spanNode.style.cursor = 'hand';
	spanNode.style.textDecoration = 'blink';

	if (menuIndex == '01') {
		spanNode.innerHTML = ''+I18NMsg("G0000035224")+'"("';
		spanNode.onclick = function() {

			var spanN = createOriginSpanNode('Left_Paren');
			var fatherNode = preEventNode.parentNode;
			if (preEventNode.id == 'Link') {
				fatherNode.insertBefore(spanN, preEventNode.nextSibling);

				spanN = createOriginSpanNode('Spacer');
				fatherNode.insertBefore(spanN, preEventNode.nextSibling);
			} else {
				fatherNode.insertBefore(spanN, preEventNode);
				spanN = createOriginSpanNode('Spacer');
				fatherNode.insertBefore(spanN, preEventNode);
			}
		}
	}

	else if (menuIndex == '02') {
		spanNode.innerHTML = ''+I18NMsg("G0000035224")+'")"';
		spanNode.onclick = function() {
			var spanN = createOriginSpanNode('Right_Paren');
			var fatherNode = preEventNode.parentNode;
			if (fatherNode.id == "InputNodes") {
				var obNode = fatherNode;
				var parNode = fatherNode.parentNode;
				parNode.insertBefore(spanN, obNode.nextSibling);
				spanN = createOriginSpanNode('Spacer');
				fatherNode.insertBefore(spanN, obNode.nextSibling);
			} else {
				fatherNode.insertBefore(spanN, preEventNode.nextSibling);
				spanN = createOriginSpanNode('Spacer');
				fatherNode.insertBefore(spanN, preEventNode.nextSibling);
			}

		}

	}

	else if (menuIndex == '03') {

		spanNode.innerHTML = I18NMsg("M0000072393");

		spanNode.onclick = function() {
			var fatherNode = preEventNode.parentNode;
			if (preEventNode.id == 'BOM') {
				
				var nextNode = preEventNode.nextSibling;
				if (preEventNode.previousSibling.id == 'Operator'
						&& preEventNode.previousSibling.ResultType != 'Boolean')
					fatherNode.removeChild(preEventNode.previousSibling);
				fatherNode.removeChild(nextNode);
				fatherNode.removeChild(preEventNode);
			} else if (preEventNode.id == 'BOMItem') {
				var preNode = preEventNode.previousSibling;
				if (preNode.previousSibling.id == 'Operator'
						&& preNode.previousSibling.ResultType != 'Boolean')
					fatherNode.removeChild(preNode.previousSibling);
				fatherNode.removeChild(preNode);
				fatherNode.removeChild(preEventNode);
			} else if (preEventNode.id == 'Operator') {
				var nextNode = preEventNode.nextSibling;
				//modify by jaihy 20100924
				if(nextNode.id != 'DelButton'){
				  if (nextNode.nextSibling.id == 'BOMItem') {
					  fatherNode.removeChild(nextNode.nextSibling);
				  }
				  fatherNode.removeChild(nextNode);
				  fatherNode.removeChild(preEventNode);
			  }else{
			  	fatherNode.removeChild(preEventNode);
			  }
				
				
			} else if (preEventNode.id == 'Input') {

			} else if (preEventNode.id == 'Left_Paren'
					|| preEventNode.id == 'Right_Paren') {
				fatherNode.removeChild(preEventNode);
			}
		}
	} else if (menuIndex == '04') {
		spanNode.innerHTML = I18NMsg("M0000072394");

		spanNode.onclick = function() {
			var spanN = createOriginSpanNode('Input');
			var fatherNode = preEventNode.parentNode;
			deleteNodesAfter(preEventNode);
			spanN = create_input();
			fatherNode.replaceChild(spanN, preEventNode);
		}
	} else if (menuIndex == '05') {
		spanNode.innerHTML = I18NMsg("M0000072395");
		spanNode.onclick = function() {
			var spanN = createOriginSpanNode('BOM');
			var fatherNode = preEventNode.parentNode;
			fatherNode.replaceChild(spanN, preEventNode);
		}

	} else if (menuIndex == '06') {
		spanNode.innerHTML = I18NMsg("M0000072396");
		spanNode.onclick = function() {
			var spanNOp = createOriginSpanNode('Operator');
			var spanNBOM = createOriginSpanNode('BOM');
			var fatherNode = preEventNode.parentNode;

			fatherNode.insertBefore(spanNBOM, preEventNode.nextSibling);
			var spanN = createOriginSpanNode('Spacer');
			fatherNode.insertBefore(spanN, preEventNode.nextSibling);

			fatherNode.insertBefore(spanNOp, preEventNode.nextSibling);
			spanN = createOriginSpanNode('Spacer');
			fatherNode.insertBefore(spanN, preEventNode.nextSibling);
		}
	}

	else if (menuIndex == '07') {
		spanNode.innerHTML = ''+I18NMsg("G0000035224")+'"<%=bundle.getString("G0000036542")%>""+I18NMsg("G0000036543")+""<%=bundle.getString("G0000036543")%>"';

		spanNode.onclick = function() {
			var spanNodeLink = createOriginSpanNode('Link');
			var spanNodeBOM = createOriginSpanNode('BOM');
			var fatherNode = preEventNode.parentNode;

			if (fatherNode.id == "InputNodes") {
				var obNode = fatherNode;
				var parNode = fatherNode.parentNode;
				parNode.insertBefore(spanNodeBOM, obNode.nextSibling);

				var spanN = createOriginSpanNode('Spacer');
				parNode.insertBefore(spanN, obNode.nextSibling);

				parNode.insertBefore(spanNodeLink, obNode.nextSibling);

				spanN = createOriginSpanNode('Spacer');
				parNode.insertBefore(spanN, obNode.nextSibling);
			} else {
				fatherNode.insertBefore(spanNodeBOM, preEventNode.nextSibling);

				var spanN = createOriginSpanNode('Spacer');
				fatherNode.insertBefore(spanN, preEventNode.nextSibling);

				fatherNode.insertBefore(spanNodeLink, preEventNode.nextSibling);

				spanN = createOriginSpanNode('Spacer');
				fatherNode.insertBefore(spanN, preEventNode.nextSibling);
			}
		}
	}

	else if (menuIndex == '08') {
		spanNode.innerHTML = I18NMsg("M0000072398");
		spanNode.onclick = function() {
			var spanN = createOriginSpanNode('Input');
			var fatherNode = preEventNode.parentNode;
			fatherNode.insertBefore(spanN, preEventNode.nextSibling);
			spanN = createOriginSpanNode('Spacer');
			fatherNode.insertBefore(spanN, preEventNode.nextSibling);
		}
	}

	else if (menuIndex == '09') {
		spanNode.innerHTML = I18NMsg("M0000072259");
		spanNode.onclick = function() {
			var spanN = createOriginSpanNode('BOM');
			var fatherNode = preEventNode.parentNode;
			fatherNode.insertBefore(spanN, preEventNode.nextSibling);
			spanN = createOriginSpanNode('Spacer');
			fatherNode.insertBefore(spanN, preEventNode.nextSibling);
		}
	}
	return spanNode;
}

function getNodeInformation(node, id) {
	// 将传入的参数进行函数内部存储，避免在使用过程对参数的修改
	var startNode = node;
	var nodeId = id;
	var fatherNode = node.parentNode;
	var reArray = new Array();
if (nodeId == 'BOMItem') {
		var BOMFinished = false;
		var OperatorFinished = false;

		var BOMName = '', opParameter = '';

		var preNode = startNode.previousSibling;
		while (preNode && preNode.id != 'Link') {
			if (!BOMFinished && preNode.id == 'BOM') {
				BOMName = preNode.EnName;
				BOMFinished = true;
			}
			if (!OperatorFinished && preNode.id == 'Operator') {
				opParameter = preNode.ParaType;
				OperatorFinished = true;
			}
			preNode = preNode.previousSibling;
		}
		reArray[0] = BOMName;
		reArray[1] = opParameter;
	} else if (nodeId == 'Operator') {
		var BOMItemFinished = false;
		var OperatorFinished = false;
		var hasBoolean = false;
		var firstOperator = true;
		var CommandType = '', opParaType = '';
		var isHierarchical = 0;
		var preNode = startNode.previousSibling;
		while (preNode && preNode.id != 'Link') {
			if (preNode.id != 'Spacer') {
				if (firstOperator) {;
					if (preNode.id == 'Operator') {
						// CommandType = preNode.ParaType;
						CommandType = preNode.ResultType;
						if(CommandType=="Number"||CommandType=="String"||CommandType=="Date")
						{
							break;
						}
					}
				} else
					firstOperator = false;
			}
			if (!BOMItemFinished && preNode.id == 'BOMItem') {
				CommandType = preNode.MatchType;
				isHierarchical = preNode.isHierarchical;
				BOMFinished = true;
			}
			if (!OperatorFinished && preNode.id == 'Operator') {

				opParameter = preNode.ParaType;
				OperatorFinished = true;
			}
			if (preNode.id == 'Operator' && preNode.ResultType == 'Boolean') {
				hasBoolean = true;
			}
			preNode = preNode.previousSibling;
		}
		reArray[0] = CommandType;
		reArray[1] = opParameter;
		reArray[2] = hasBoolean;
		reArray[3] = isHierarchical;
	}
	return reArray;
}
// 获取后台BOM数据
function getBOMArray() {
	var BOMArray = new Array();
	
	//---wengf---
	var sql = "select Name,Name from LRBom";
	//var sql = "select Name,CNName from LRBOM where valid='1' union all "
	//		+ "select rulename,rulename from LRTemplateT where id ='00000000000000000066'";

	// 条件
	BOMArray = getAndPrepareData(sql);

	return BOMArray;
}

function getANDORArray() {
	var ANDORArray = new Array();
	
	//---jiahaiyan---2010-09-01
	var sql = "select msg_en,msg_cn from msg_mapping where '1283323742000'='1283323742000' and  msg_id in ('M0000072381','M0010091809')";
	ANDORArray = getAndPrepareData(sql);

	return ANDORArray;
}
// 包含对查询的缓存
function getAndPrepareData(sql) {
	var reArray = new Array();

	for ( var i = 0; i < queryCache.length; i++) {
		if (queryCache[i][0] == sql) {
			return queryCache[i][1];
		}
	}
	var str = easyQueryVer3(sql);
	reArray = decodeEasyQueryResult(str);

	var len = queryCache.length;
	queryCache[len] = new Array();
	queryCache[len][0] = sql;
	queryCache[len][1] = reArray;

	return reArray;

}
// 根据BOM获取后台BOMItem
function getBOMItemArray(paraArray) {
	var BOMItemArray = new Array();
	var sql = ''
	var str = null;
	if (paraArray[0] == null || paraArray[0] == '') {
		alert(I18NMsg("M0000072399"));
	} else {
		if (paraArray[1] != null && paraArray[1] != '') {
			if (paraArray[1] == "INT") {
				paraArray[1] = "Number";
			}
			sql = "select Template,Discription,remark from lrterm,LRTermPhrase where bomid in (select id from lrbom where name= '"+paraArray[0]+"') and LRTermPhrase.termid = lrterm.id";
					//+ paraArray[0] + "' and CommandType='" + paraArray[1] + "'";
		} else {
			sql = "select Template,Discription,remark from lrterm,LRTermPhrase where bomid in (select id from lrbom where name= '"+paraArray[0]+"') and LRTermPhrase.termid = lrterm.id";
					//+ paraArray[0] + "'";
		}
		BOMItemArray = getAndPrepareData(sql);
	}
	return BOMItemArray;
}

// 根据BOMItem类型获取运算符
// 'id','EnName','ChName','MatchType','ResultType','ParaType','IsNextOperator'
function getOperatorArray(paraArray) {
	var OperatorArray = new Array();
	var commandtype = '';
	if (paraArray[0] == "INT") {
		commandtype = 'Number';
	} else {
		commandtype = paraArray[0];
	}
	
	if(commandtype=="N0"||commandtype=="N2"||commandtype=="N4"||commandtype=="N6")
	{
		commandtype="Number"
		}else if(commandtype=="D"){
			commandtype="Date"
			}else if (commandtype=="S"){
				commandtype="String";
			}
	var sql = "select Implenmation,Display,CommandType,ResultType,ParaType,ParaNum from LRCommand where CommandType='"
			+ commandtype + "'";
	if (paraArray[0] == null || paraArray[0] == '') {
		alert(I18NMsg("M0000072400"));
		return null;
	} else {
		if (paraArray[1] != null && paraArray[1] != '') {
			sql += " and ParaType='" + paraArray[1] + "'";
		}
		if (paraArray[2]) {
			sql += " and ResultType!='Boolean'";
		}
		if (paraArray[3] == 1) {
			sql += " and (implenmation='instrExt(@,#,$)>0' or implenmation='instrExt(@,#,$)=0' or implenmation='strEquals(@,#,$)>0' or implenmation='strEquals(@,#,$)=0' or implenmation='is not null' or implenmation='is null')";
		} else {
			sql += " and (implenmation!='strEquals(@,#,$)>0' and implenmation!='strEquals(@,#,$)=0')";
		}
	}
	OperatorArray = getAndPrepareData(sql);
	try {
		for ( var i = 0, len = OperatorArray.length; i < len; i++) {
			for ( var j = 0, len1 = OperatorArray[i].length; j < len1; j++) {
				OperatorArray[i][j] = OperatorArray[i][j].replace(new RegExp(
						'@@SinQuot', 'gm'), "'");
			}
		}
	} catch (e) {
		alert(I18NMsg("M0000072401"));
	}
	return OperatorArray;
}

function getInputSource(sql) {
	var reArray = new Array();
	sql = sql.replace(new RegExp('@@SinQuot', 'gm'), "'");
	var str = easyQueryVer3(sql);
	reArray = decodeEasyQueryResult(str);
	return reArray;
}

/*
 * 
 * 
 * 
 * 
 */
// 用于扫描节点过程中对数据进行暂存
var stack = new Array();
// 用于生成DT表中的列名中处理重复列名问题
var reCurArray = new Array();
// 用于生成决策表表头信息时对信息进行缓存
var disCol = new Array();
// 用于记录定制逻辑中所有Input节点，以减少决策表数据与定制逻辑中数据的交互问题

var RuleChArray = new Array();

//jiahaiyan-----2010-09-01---原函数是按如果条件里的每行条件左右括号相抵消进行判断，在此改成按整个条件域的左右括号相抵消进行判断
function checkOutRule() {
	var ruleNodes = document.getElementById('RuleZone');
	if (!ruleNodes) {
		alert(I18NMsg("M0000072402"));//您还没有定制规则，请定制完整后再检测规则定制的完整性
		return;
	}
	var ruleNode = ruleNodes.firstChild;
	var endNode = ruleNodes.lastChild;
	if (!ruleNode || ruleNode == endNode) {
		alert(I18NMsg("M0000072402"));//您还没有定制规则，请定制完整后再检测规则定制的完整性
		return;
	}
	var row = 0;
	var errorMessage = '';
	var paren = 0;
	while (ruleNode != endNode) {
		row++;
		var BoolOpNum = 0;
		//var paren = 0;
		var oppar = true;
		var spanNode = ruleNode.firstChild;
		var firstnode = ruleNode.firstChild;
		if (!spanNode) {
			continue;
		}
		var lastNode = ruleNode.lastChild;
		var endnode = endNode.lastChild;
		while(firstnode != endnode){
			if (firstnode.id == "Left_Paren") {
				paren++;
			}
			if (firstnode.id == "Right_Paren") {
				paren--;
			}
	    firstnode = firstnode.nextSibling;		
		}
		
		var i = 0;
		while (spanNode != lastNode) {
			i++;
			if (spanNode.id == "Link") {
				BoolOpNum = 0;
			}
//			if (spanNode.id == "Left_Paren") {
//				paren++;
//			}
//			if (spanNode.id == "Right_Paren") {
//				paren--;
//			}
			// 对运算符类型的判断
			if (spanNode.id == "Operator") { // 逻辑型运算符的个数
				if (spanNode.ResultType == 'Boolean') {
					BoolOpNum++;
				}
				var opParaNum = spanNode.ParaNum;
				// 看连接运算符左右的参数是否正确
				// 一元运算符只能是：前一个是词条，后一个是“删除本条件”
				// 二元运算符只能是：前后两个都是完整的词条，或者其中一个是词条另一个Input，或者是前一个是必须接运算符的运算符后一个是Input或者是BOM
				// 变态运算符只能是：前一个是完整的词条，后一个是运算符
				if (opParaNum == 0) {
					// 找到往前第一个不是Spacer的节点
					var BOMItemNode = null;
					var startNode = spanNode;
					while (startNode.id == 'Spacer') {
						startNode = startNode.previousSibling;
					}
					BOMItemNode = startNode;
					// 往后找，找到第一个id不是Spacer的节点
					startNode = spanNode;
					while (startNode.id == 'Spacer') {
						startNode = startNode.previousSibling;
					}
					var lastNode = startNode;

					if (!(BOMItemNode.id == 'BOMItem' && (lastNode.id == 'link'
							|| lastNode.id == undefined || lastNode.id == 'Parentheses')))
						errorMessage += I18NMsg("M0000053193") + row + I18NMsg("M0000072403");//行的运算符连接的参数不正确\n
				} else if (opParaNum == 1) {

				} else if (opParaNum == 2) {

				}
			}
			spanNode = spanNode.nextSibling;
		}
		if (BoolOpNum != 1) {
			errorMessage += I18NMsg("M0000053193") + row + I18NMsg("M0000072404") + BoolOpNum + I18NMsg("M0000072405");
		}//行row含有BoolOpNum个运算结果为逻辑型的运算符!\n
//		if (paren != 0) {
//			//errorMessage += I18NMsg("M0000053193") + row + I18NMsg("M0000072406");  
//			errorMessage += I18NMsg("M0000072406"); 
//		}//行row的括号不匹配！\n
		ruleNode = ruleNode.nextSibling;
	}
	
	 if (paren != 0) {
			//errorMessage += I18NMsg("M0000053193") + row + I18NMsg("M0000072406");  
			errorMessage += I18NMsg("M0000072406"); 
		}//行row的括号不匹配！\n
	
	if (errorMessage != '') {
		alert(errorMessage);
		return false;
	} else
		return true;
}

///*
// * 函数传入参数为空 函数返回值：函数的返回值是一个数组（reArray） reArray[0]携带拼写好的SQLStatement
// * reArray[1]携带拼写好的createTable reArray[2]携带拼写好的决策表的表头
// */
//function composeSQL() {
//	// 获取规则区域的节点
//	var ruleNodes = document.getElementById('RuleZone');	
//	var ruleNodes1 = document.getElementById('RuleZone1');
//  var ruleNodes3 = document.getElementById("RuleZone3");//jiahy
//	var ruleNodes4 = document.getElementById("RuleZone4");//jiahy
//	// 获取规则的第一个条件
//	var ruleNode = ruleNodes.firstChild;	
//	// 获取规则的最后一个条件
//	var endNode = ruleNodes.lastChild;	
//	// 对拼SQL过程中需要使用到的变量进行初始化
//	initParaBeforeComposeSQL();
//	
//
//	if(ruleNodes1!=null && ruleNodes4!=null)
//	{
//		//SQLStatement = "select RuleId,UWLevel,Result from #DTTable# where ";
//		SQLStatement = "select case when xx0 then RuleId,UWLevel,Result case when xx1 then Result1 end from #DTTable# ";
//	}else if(ruleNodes1!=null && ruleNodes4==null){
//		SQLStatement = "select case when xx0 then RuleId,UWLevel,Result end from #DTTable# ";
//	}else {
//	 alert("条件域输入有误！")	
//	 return false;
//	}
//	
//  var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//	var xmlRule = xmlDoc.createElement("Rule");
//	xmlDoc.appendChild(xmlRule);
//	var xmlCondition = xmlDoc.createElement("Condition");
//	var MetaNode;
//
// // reStr = "";
//	while (ruleNode != endNode) {
//		countcase = 0;
//		// 获取条件的第一个节点和最后一个节点
//		var spanNode = ruleNode.firstChild;
//		var lastNode = ruleNode.lastChild;
//		// 用于记录规则中一个条件的sql字符串
//
//		xmlCondition = xmlDoc.createElement("Condition");
//
//		MetaNodeChNameArray.length = 0;
//
//		while (spanNode != lastNode) {
//			if (spanNode.id == 'Spacer') {
//				spanNode = spanNode.nextSibling;
//				continue;
//			}
//			MetaNodeChNameArray[MetaNodeChNameArray.length] = spanNode;
//			// 有优化的余地
//			MetaNode = composeXML(xmlDoc, spanNode);
//			xmlCondition.appendChild(MetaNode);
//
//			if (spanNode.id == "BOM") {
//				if (spanNodeArray.length != 0) {
//					comASQL();
//				}
//				spanNodeArray.push(spanNode);
//			}
//
//			else if (spanNode.id == "BOMItem") {
//				spanNodeArray.push(spanNode);
//			} else if (spanNode.id == "Operator") {
//				spanNodeArray.push(spanNode);
//				if(spanNode.EnName == "is null"||spanNode.EnName == "is not null"  )
//				{
//					comASQL();
//				}
//			} else if (spanNode.id == "Link") {
//				if (spanNodeArray.length != 0) {
//					comASQL();
//				}
//				spanNodeArray.push(spanNode);
//				ColumnMetasChArray.length = 0;
//			} else if (spanNode.id == "Left_Paren") {
//				spanNodeArray.push(spanNode);
//			} else if (spanNode.id == "Right_Paren") {
//				spanNodeArray.push(spanNode);
//			} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
//				spanNodeArray.push(spanNode);
//				comASQL();
//			}
//			spanNode = spanNode.nextSibling;
//		}
//		if (spanNodeArray.length != 0) {
//			comASQL();
//		}
//
//		xmlRule.appendChild(xmlCondition);
//		composeRuleDesInCh();
//		ruleNode = ruleNode.nextSibling;
//	}
//	alert("SQLStatement--00--"+SQLStatement);
//	//wengf----
//
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
//	SQLStatement = SQLStatement.replace('xx0',''+reStr);
//alert("SQLStatement--11--"+SQLStatement);
////alert("111---reStr--0---"+reStr);  
////上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//	   //add by efeng
//	   //modify by wengf
//	 reStr = "";
//	 ruleNodes = document.getElementById('RuleZone');
//	 ruleNodes1 = document.getElementById('RuleZone1');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//	   if(ruleNodes!=null && ruleNodes1!=null)
//			{
//				var sqlresult ="";				
//				var ruleNode = ruleNodes1.firstChild;
//				var endNode = ruleNodes1.lastChild;
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
//					SQLStatement = SQLStatement.replace('RuleId,UWLevel,Result',''+sqlresult);
//			}
//  alert("SQLStatement-22--"+SQLStatement);
//  //add by jiahy 20100914
//	if(ruleNodes3!=null && ruleNodes4!=null){
//        var ruleNode3 = ruleNodes3.firstChild;	
//       	var endNode3 = ruleNodes3.lastChild;	
//        var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.3.0");
//       	var xmlRule = xmlDoc.createElement("Rule");
//       	xmlDoc.appendChild(xmlRule);
//       	var xmlCondition = xmlDoc.createElement("Condition3");
//       	var MetaNode;
//       
//         reStr = "";//重要
//       	while (ruleNode3 != endNode3) {		
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode3.firstChild;
//       		var lastNode = ruleNode3.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
//       
//       		xmlCondition = xmlDoc.createElement("Condition3");
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
//       		ruleNode3 = ruleNode3.nextSibling;
//       	}
//       	//alert("SQLStatement--33--"+SQLStatement);
//       	var ruleNode4 = ruleNodes4.firstChild;
//       	var endNode4 = ruleNodes4.lastChild;	
//       	xmlCondition = xmlDoc.createElement("Condition4");	
//       	while (ruleNode4 != endNode4) {
//       		// 获取条件的第一个节点和最后一个节点
//       		var spanNode = ruleNode4.firstChild;
//       		var lastNode = ruleNode4.lastChild;
//       		// 用于记录规则中一个条件的sql字符串
//       
//       		xmlCondition = xmlDoc.createElement("Condition1");
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
//       		ruleNode4 = ruleNode4.nextSibling;
//       	} 
//       	SQLStatement = SQLStatement.replace('xx1',''+reStr);
//       //alert("SQLStatement--44--"+SQLStatement);
//       //alert("111---reStr--0---"+reStr);  
//       //上面的程序为处理 case when 和then 之间的内容（where 后面的内容）
//       	   //add by efeng
//       	   //modify by wengf
//       	 reStr = "";
//       	 ruleNodes3 = document.getElementById('RuleZone3');
//       	 ruleNodes4 = document.getElementById('RuleZone4');//处理then后面的内容（ SELECT 与WHERE 之间的内容）
//       	   if(ruleNodes3!=null && ruleNodes4!=null)
//       			{
//       				var sqlresult ="";				
//       				var ruleNode = ruleNodes4.firstChild;
//       				var endNode = ruleNodes4.lastChild;
//       					// 获取条件的第一个节点和最后一个节点
//       					var spanNode = ruleNode.firstChild;
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
////  alert("SQLStatement-55--"+SQLStatement);
//	ViewPara = xmlRule.xml;
//	return completeParaAfterCompose();
//}
function comASQL1() {
	//var reStr = '';//jiahy  20100914
	var str = '';
	var spanNode = null;
	var outCol = '';
	var op = '';
	var finished = false;
	// 用于记录扫描到节点的英文名
	var linkStr = '';
	var lparenStr = '';
	var rparenStr = '';
	var BOMStr = '';
	var BOMItemStr = '';
	var opStr = '';
	var opStr1 = '';
	// 用于记录扫描到节点的中文名
	var linkStrCh = '';
	var lparenStrCh = '';
	var rparenStrCh = '';
	var BOMStrCh = '';
	var BOMItemStrCh = '';
	var opStrCh = '';

	var disColCh = '';
	var BOMItemType = "";
	var InputType = "";
	var reCreateTable = '';

	var BOMNode = '';
	var BOMItemNode = '';

	var pareNumber = 0;
	// aler("堆栈stack的长度是："+stack.length);
	for ( var i = 0, len = spanNodeArray.length; i < len; i++) {
		var spanNode = spanNodeArray[i];
		if (!(!!spanNode))
			continue;
			//alert("spanNode.getAttribute('EnName')---"+i+"--"+spanNode.getAttribute('EnName'));
		if (spanNode.id == "Link") {
			com(lparenStr, outCol, rparenStr, opStr, opStr1, 'isBOM',
					InputType, BOMItemType);
			reStr += " " + spanNode.getAttribute('EnName');
			
		//	alert("EnName---reStr--"+reStr);
		//	SQLStatement += ' ' + spanNode.getAttribute('EnName') + ' '; //处理 and 与 or jiahy
			
		} else if (spanNode.id == "Left_Paren") {
			if (lparenStr != '') {
				SQLStatement += spanNode.getAttribute('EnName');
			}
			lparenStr = spanNode.getAttribute('EnName');
			pareNumber += 1;
		} else if (spanNode.id == "Right_Paren") {
			rparenStr = spanNode.getAttribute('EnName');
			pareNumber -= 1;
		} else if (spanNode.id == "BOM") {
			outCol += spanNode.getAttribute('EnName');
			BOMNode = spanNode.getAttribute('EnName');
			ColumnMetasChArray[ColumnMetasChArray.length] = spanNode.ChName;
		} else if (spanNode.id == "BOMItem") {
			outCol += '_' + spanNode.getAttribute('EnName');
			BOMItemNode = spanNode.getAttribute('EnName');
			BOMItemType = spanNode.MatchType;

			ColumnMetasChArray[ColumnMetasChArray.length] = spanNode.ChName;
		} else if (spanNode.id == "Operator") {
			//alert("is null");
			if(spanNode.getAttribute('EnName')!=null){
			 // alert("not null");
			if (opStr == '') {
				opStr = spanNode.getAttribute('EnName');
			} else {
				opStr1 = spanNode.getAttribute('EnName');
			}
			InputType = spanNode.ParaType;
			ColumnMetasChArray[ColumnMetasChArray.length] = spanNode.ChName;
		 }
		} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
			var rArray = com(lparenStr, outCol, rparenStr, opStr, opStr1,
					'isInput', InputType, BOMItemType);
			finished = true;
			for ( var j = 0; j < ColumnMetasChArray.length; j++) {
				disColCh += ColumnMetasChArray[j];
			}
			ColumnMetasChArray.length = 0;
		}
	}
	if (!finished) {
		com(lparenStr, outCol, rparenStr, opStr, opStr1, 'isBOM', InputType,
				BOMItemType);
	}
	spanNodeArray.length = 0;
	/*
	 * if (reCreateTable != '') { CreateTable+= reCreateTable; }
	 */
	if (disColCh != '') {
		ColumnHeadArray[ColumnHeadArray.length] = disColCh;
		ColumnDataTypeArray[ColumnDataTypeArray.length] = InputType;
	}

}

function comASQL() {
	//var reStr = '';//jiahy  20100914
	var str = '';
	var spanNode = null;
	var outCol = '';
	var op = '';
	var finished = false;
	// 用于记录扫描到节点的英文名
	var linkStr = '';
	var lparenStr = '';
	var rparenStr = '';
	var BOMStr = '';
	var BOMItemStr = '';
	var opStr = '';
	var opStr1 = '';
	// 用于记录扫描到节点的中文名
	var linkStrCh = '';
	var lparenStrCh = '';
	var rparenStrCh = '';
	var BOMStrCh = '';
	var BOMItemStrCh = '';
	var opStrCh = '';

	var disColCh = '';
	var BOMItemType = "";
	var InputType = "";
	var reCreateTable = '';

	var BOMNode = '';
	var BOMItemNode = '';

	var pareNumber = 0;
	// aler("堆栈stack的长度是："+stack.length);
	for ( var i = 0, len = spanNodeArray.length; i < len; i++) {
		var spanNode = spanNodeArray[i];
		if (!(!!spanNode))
			continue;
			//alert("spanNode.getAttribute('EnName')---"+i+"--"+spanNode.getAttribute('EnName'));
			//alert("spanNode.id----"+spanNode.id);
		if (spanNode.id == "Link") {
			com(lparenStr, outCol, rparenStr, opStr, opStr1, 'isBOM',
					InputType, BOMItemType);
			reStr += " " + spanNode.getAttribute('EnName');
			
		//	alert("EnName---reStr--"+reStr);
		//	SQLStatement += ' ' + spanNode.getAttribute('EnName') + ' '; //处理 and 与 or jiahy
			
		} else if (spanNode.id == "Left_Paren") {
			if (lparenStr != '') {
				//SQLStatement += spanNode.getAttribute('EnName');//jiahy modify 20100921
				//reStr += " " + spanNode.getAttribute('EnName');
			}
			lparenStr = spanNode.getAttribute('EnName');
			pareNumber += 1;
		} else if (spanNode.id == "Right_Paren") {
			rparenStr = spanNode.getAttribute('EnName');
			pareNumber -= 1;
		} else if (spanNode.id == "BOM") {
			outCol += spanNode.getAttribute('EnName');
			BOMNode = spanNode.getAttribute('EnName');
			ColumnMetasChArray[ColumnMetasChArray.length] = spanNode.ChName;
		} else if (spanNode.id == "BOMItem") {
			outCol += '_' + spanNode.getAttribute('EnName');
			BOMItemNode = spanNode.getAttribute('EnName');
			BOMItemType = spanNode.MatchType;

			ColumnMetasChArray[ColumnMetasChArray.length] = spanNode.ChName;
		} else if (spanNode.id == "Operator") {
			if (opStr == '') {
				opStr = spanNode.getAttribute('EnName');
			} else {
				opStr1 = spanNode.getAttribute('EnName');
			}
			InputType = spanNode.ParaType;
			ColumnMetasChArray[ColumnMetasChArray.length] = spanNode.ChName;
		} else if (spanNode.id == "Input" || spanNode.id == "InputNodes") {
			var rArray = com(lparenStr, outCol, rparenStr, opStr, opStr1,
					'isInput', InputType, BOMItemType);
			finished = true;
			for ( var j = 0; j < ColumnMetasChArray.length; j++) {
				disColCh += ColumnMetasChArray[j];
			}
			ColumnMetasChArray.length = 0;
		}
	}
	if (!finished) {
		com(lparenStr, outCol, rparenStr, opStr, opStr1, 'isBOM', InputType,
				BOMItemType);
	}
	spanNodeArray.length = 0;
	/*
	 * if (reCreateTable != '') { CreateTable+= reCreateTable; }
	 */
	if (disColCh != '') {
		ColumnHeadArray[ColumnHeadArray.length] = disColCh;
		ColumnDataTypeArray[ColumnDataTypeArray.length] = InputType;
	}

}

/*
 * 函数传入参数分别是： lparenStr：左括号的英文名 outCol： 格式为BOM.BOMItem rparenStr：右括号的英文名 opStr：
 * 运算符的英文名 flag： 是否需要生成决策表中的一列的标识，Input表示要，BOM表示不要 dataType：
 * BOM.BOMItem中BOMItem的数据类型，用于falg为Input时需要创建决策条表的情况 函数返回值：函数的返回值是一个数组（reArray）
 * reArray[0]携带拼写好的SQLStatement reArray[1]携带拼写好的createTable
 */

function com(lparenStr, outCol, rparenStr, opStr, opStr1, flag, InputType,
		BOMItemType) {
//	var reStr = '';//jiahy
	var reCreateTable = '';
	var temp = '';

	if (outCol != '') {
		getBOMAndBOMItem(outCol);
	}

	if (lparenStr != '' && rparenStr != '') {
		lparenStr = '';
		rparenStr = '';
	}
	
	if (outCol != '') {
		if (BOMItemType == 'Date') {
			//temp = lparenStr + "to_date(?" + outCol.replace('_', '.')
				//	+ "?,'yyyy-mm-dd hh24:mi:ss')" + rparenStr; //jiahy 20100921
					temp =  "to_date(?" + outCol.replace('_', '.')
					+ "?,'yyyy-mm-dd hh24:mi:ss')" + rparenStr;
		} else {
			//temp = lparenStr + '?' + outCol.replace('_', '.') + '?' + rparenStr; //jiahy 20100921
			temp =  '?' + outCol.replace('_', '.') + '?' + rparenStr;
		}

	} else {
		//reStr += lparenStr + rparenStr; //modify by jiahy 20100921
		reStr += rparenStr;
	}
  
	var indexLeft = opStr.indexOf('#');
	var indexRight = opStr.indexOf('@');
	if (flag == 'isInput') {
		var i = getRecur(outCol);

		if (opStr.indexOf('$' >= 0)) {
			if (outCol.indexOf('ManageCom') >= 0) {
				opStr = opStr.replace('$', 1);
			} else {
				opStr = opStr.replace('$', 0);
			}
		}
	//	alert("opStr---"+opStr);
		//alert("temp--"+temp);
		//alert("opStr-1--"+opStr1);
		var hasTwo = false;
		if (indexLeft >= 0 && temp != '') {
			opStr = opStr.replace('#', temp);
			if (opStr1 != '') {
				hasTwo = true;
			}

			if (indexRight >= 0) {
				opStr = opStr.replace('@', outCol + i);
       
				  reStr += opStr + " ";
			} else {
				 
				  reStr += opStr + opStr1 + " " + outCol + i + ' ';
			}
		} else {
			//reStr += temp + " " + opStr + " " + outCol + i + ' ';      //jiahy 20100921
			   if(opStr=='sum' || opStr=='count'){
			   	  if(opStr1!==''){
			   	     reStr += opStr + "("+temp+")" +" "+ opStr1 +" "+ lparenStr + " " + outCol + i + ' ';
			   	  }else{
			   	     reStr += opStr + temp +" "+ lparenStr + " " + outCol + i + ' ';
			   	  }
         }else{
		    	  reStr += temp + " " + opStr  + lparenStr + " " + outCol + i + ' ';
		     }
		}
		if (InputType != '') {
        // alert("outCol---"+outCol);
			if (InputType == 'Date') {
				reCreateTable = outCol + i + ' Date';
			} else if (InputType == 'INT' || InputType == 'Number') {
				reCreateTable = outCol + i + ' Number';
			} else if (InputType == 'String') {
				reCreateTable = outCol + i + ' varchar2(1000)';
			}
			TableColumnNameArray[TableColumnNameArray.length] = (outCol + i)
					.toUpperCase();
		}
	} else {
		//alert("opStr1--"+opStr1);
		//alert("opStr--"+opStr);
		if (indexLeft < 0 && indexRight < 0 && opStr1 == '') {
			//reStr += temp + " " + opStr;        //jiahy 20100921 modify
			 if(opStr=='sum' || opStr=='count'){//add jiahy 20100921
			    reStr += " "+ opStr+"("+ temp + ")" + lparenStr;
		   }else{
			    reStr += temp + " " + opStr + lparenStr;
			 }
		}else {
			if (indexLeft >= 0 && temp != '') {
				temp = opStr.replace('#', temp);
			}
			//reStr += temp + " " + opStr1;         //jiahy 20100921
			if(opStr=='sum' || opStr=='count'){
				reStr += opStr + "("+ temp + ")" + " " + opStr1 + lparenStr;
			}else{
			   reStr += temp + " " + opStr1 + lparenStr;
			}
		}

	}
	//alert("com--restr-222222222-"+reStr);
//	if (countcase ==0)
//	   SQLStatement = SQLStatement.replace('xx0',''+reStr);
//	else
//	   SQLStatement = SQLStatement.replace('xx1',''+reStr);
//	SQLStatement += reStr;   //jiahy 20100913
 // alert("com--SQLStatement-=-"+SQLStatement);
	if (reCreateTable != "") {
		CreateTable += reCreateTable + ",";
	}
	//alert("CreateTable---"+CreateTable);
}

function initParaBeforeComposeSQL() {
	// 存储规则的SQL
	SQLStatement = "select RuleId,UWLevel,Result from #DTTable# where ";
	// 创建DT表的语句
	CreateTable = "create table #DTTable# (";

	// 存储规则反显示所需要的参数
	ViewPara = "";
	// 存储规则所用的BOM
	BOMSArray.length = 0;
	// 存储规则反解析的参数
	SQLParaArray.length = 0;
	// 存储规则的中文名
	RuleDesInCh = I18NMsg("M0000072407");//如果，
	// 存储决策表列头所要显示的中文名
	ColumnHeadArray.length = 0;
	// 存储决策表列的数据类型
	ColumnDataTypeArray.length = 0;
	// 存储DT表中列名。
	TableColumnNameArray.length = 0;
	// 存储决策表所的运算符是否为“其中之一”
	ColumnMultipleArray.length = 0;
	// 存储决策表的列是否为基础词条
	BaseColumnArray.length = 0;
	// 存储扫描到节点的中文名
	MetaNodeChNameArray.length = 0;
	// 存储扫描节点的数组
	spanNodeArray.length = 0;
}

function completeParaAfterCompose() {
	// 创建DT表的语句
	CreateTable += 'Result varchar2(4000),UWLevel varchar2(4000),RuleId varchar2(20))';

	RuleDesInCh += I18NMsg("M0000072408"); //M0000072408:那么
//wengf
	//ColumnHeadArray[ColumnHeadArray.length] = "比率系数";
	ColumnHeadArray[ColumnHeadArray.length] = ""+I18NMsg("G0000028306")+"";

	ColumnDataTypeArray[ColumnDataTypeArray.length] = "String";
	TableColumnNameArray[TableColumnNameArray.length] = "Result";

	ColumnDataTypeArray[ColumnDataTypeArray.length] = "String";
	TableColumnNameArray[TableColumnNameArray.length] = "UWLevel";

	return checkColumnLength();
}

function checkColumnLength() {
	var message = '';
	if (Length(SQLStatement) > 4000 || Length(BOMSArray.toString()) > 1000
			|| Length(SQLParaArray.toString()) > 4000
			|| Length(RuleDesInCh) > 4000) {
		message = I18NMsg("M0000072411");//定制的规则太长，请对规则进行精简！
	}
	if (message != '') {
		alert(message);
		return false;
	} else {
		return true;
	}

}

function Length(str) {
	var i, sum;
	sum = 0;
	for (i = 0; i < str.length; i++) {
		if ((str.charCodeAt(i) >= 0) && (str.charCodeAt(i) <= 255))
			sum = sum + 1;
		else
			sum = sum + 2;
	}
	return sum;
}

function compactBOMArray(BOMEnName) {
	var i = 0;
	var len = BOMSArray.length;
	for (i = 0; i < len; i++) {
		if (BOMSArray[i] == BOMEnName)
			break;
	}
	if (i >= len) {
		BOMSArray[len] = BOMEnName;
	}
}

function compactSQLParaArray(SQLPara) {
	var i = 0;
	var len = SQLParaArray.length;
	for (i = 0; i < len; i++) {
		if (SQLParaArray[i] == SQLPara)
			break;
	}
	if (i >= len) {
		SQLParaArray[len] = SQLPara;
	}
}
function getBOMAndBOMItem(BOMAndBOMItem) {
	var result = BOMAndBOMItem.split("_");
	var BOMStr = result[0];
	var BOMItemStr = result[1];

	if (BOMStr != '') {
		compactBOMArray(BOMStr);
		if (BOMItemStr != '') {
			compactSQLParaArray(BOMStr + "." + BOMItemStr);
		}
	}
}
function getRecur(str) {
	var i = 0;
	var index = 0;
	for (i = 0, len = reCurArray.length; i < len; i++) {

		if (reCurArray[i][0] == str) {

			reCurArray[i][1]++;
			index = reCurArray[i][1]
			break;
		}
	}
	if (i == reCurArray.length) {
		reCurArray[i] = new Array();
		reCurArray[i][0] = str;
		reCurArray[i][1] = 0;
		index = reCurArray[i][1];
	}
	return index;
}

function composeXML(xmlDoc, spanNode) {
	var xmlNode = xmlDoc.createElement("MetaNode");
	if (spanNode.id == 'BOM') {
		for ( var i = 0; i < BOMIndex.length; i++) {
			var att = spanNode.getAttribute(BOMIndex[i]);
			xmlNode.setAttribute(BOMIndex[i], att);
		}
	} else if (spanNode.id == 'BOMItem') {
		for ( var i = 0; i < BOMItemIndex.length; i++) {
			var att = spanNode.getAttribute(BOMItemIndex[i]);
			att = att.replace(new RegExp("'", "gm"), "''");
			xmlNode.setAttribute(BOMItemIndex[i], att);
		}
	} else if (spanNode.id == 'Operator') {
//wengf---
		for ( var i = 0; i < OperatorIndex.length; i++) {
			var att = spanNode.getAttribute(OperatorIndex[i]);
			if(att == null)
			{
				//alert('nouse');
				return null;}
			xmlNode.setAttribute(OperatorIndex[i], att);
		}
	} else if (spanNode.id == 'Link') {
		for ( var i = 0; i < LinkIndex.length; i++) {
			var att = spanNode.getAttribute(LinkIndex[i]);
			xmlNode.setAttribute(LinkIndex[i], att);
		}
	} else if (spanNode.id == 'Left_Paren' || spanNode.id == 'Right_Paren') {
		for ( var i = 0; i < ParenIndex.length; i++) {
			var att = spanNode.getAttribute(ParenIndex[i]);
			xmlNode.setAttribute(ParenIndex[i], att);
		}
	} else if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
		for ( var i = 0; i < InputIndex.length; i++) {
			var att = spanNode.getAttribute(InputIndex[i]);
			xmlNode.setAttribute(InputIndex[i], att);
		}
	}
	return xmlNode;
}

function composeXML1(xmlDoc, spanNode) {//jiahy
	var xmlNode = xmlDoc.createElement("MetaNode");
	if (spanNode.id == 'BOM') {
		for ( var i = 0; i < BOMIndex.length; i++) {
			var att = spanNode.getAttribute(BOMIndex[i]);
			xmlNode.setAttribute(BOMIndex[i], att);
		}
	} else if (spanNode.id == 'BOMItem') {
		for ( var i = 0; i < BOMItemIndex.length; i++) {
			var att = spanNode.getAttribute(BOMItemIndex[i]);
			att = att.replace(new RegExp("'", "gm"), "''");
			xmlNode.setAttribute(BOMItemIndex[i], att);
		}
	} else if (spanNode.id == 'Operator') {
		for ( var i = 0; i < OperatorIndex.length; i++) {
			var att = spanNode.getAttribute(OperatorIndex[i]);
			xmlNode.setAttribute(OperatorIndex[i], att);
		}
	} else if (spanNode.id == 'Link') {
		for ( var i = 0; i < LinkIndex.length; i++) {
			var att = spanNode.getAttribute(LinkIndex[i]);
			xmlNode.setAttribute(LinkIndex[i], att);
		}
	} else if (spanNode.id == 'Left_Paren' || spanNode.id == 'Right_Paren') {
		for ( var i = 0; i < ParenIndex.length; i++) {
			var att = spanNode.getAttribute(ParenIndex[i]);
			xmlNode.setAttribute(ParenIndex[i], att);
		}
	} else if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
		for ( var i = 0; i < InputIndex.length; i++) {
			var att = spanNode.getAttribute(InputIndex[i]);
			xmlNode.setAttribute(InputIndex[i], att);
		}
	}
	return xmlNode;
}
function composeRuleDesInCh() {
	var spanNode;
	for ( var i = 0, len = MetaNodeChNameArray.length; i < len; i++) {
		spanNode = MetaNodeChNameArray[i];
		if (spanNode.id != "Input" && spanNode.id != "InputNodes") {
			RuleDesInCh += spanNode.ChName;
		} else {
			RuleDesInCh += "#"+I18NMsg("G0000036544")+"";
		}
	}
}

// 审核规则定制的接口
function comfirmLogic() {
	// 审核规则是否定制完整

	if (checkOutRule()) {
		var fm = document.getElementById('fm');
		if (composeSQL()) {
			initDataArray();
			displayDicTable();
			var submitData = document.getElementById('submitData');
			submitData.disabled = false;
			var logicToTable = document.getElementById('logicToTable');
			logicToTable.disabled = false;
			var modifyLogic = document.getElementById('modifyLogic');
			modifyLogic.disabled = false;
			var displayDisicionTable = document
					.getElementById('displayDisicionTable');
			displayDisicionTable.disabled = true;
		}

		else {

			return;
		}

	}
}
//
//function getInputNodes() {
//	var ruleNodes = document.getElementById('RuleZone');
//	// 获取规则的第一个条件
//	var ruleNode = ruleNodes.firstChild;
//	// 获取规则的最后一个条件
//	var endNode = ruleNodes.lastChild;
//	InputNodes.length = 0;
//	while (ruleNode != endNode) {
//		var spanNode = ruleNode.firstChild;
//		var lastNode = ruleNode.lastChild;
//
//		while (spanNode != lastNode) {
//			if (spanNode.id == 'Input' || spanNode.id == 'InputNodes') {
//				InputNodes[InputNodes.length] = spanNode;
//			}
//			spanNode = spanNode.nextSibling;
//		}
//		ruleNode = ruleNode.nextSibling;
//	}
//	InputNodes[InputNodes.length] = document.getElementById('Result');
//}

function getBaseBomItems() {

	getInputNodes();

	BaseColumnArray.length = 0;
	BaseBOMItemSourceArray.length = 0;
	ColumnMultipleArray.length = 0;
	var inputNode;
	var firstBomItem;
	for ( var i = 0; i < InputNodes.length - 1; i++) {
		inputNode = InputNodes[i];
		while (inputNode.id != 'BOMItem') {
			inputNode = inputNode.previousSibling;
		}
		firstBomItem = inputNode;
		if (!!firstBomItem.Source) {
			BaseColumnArray[i] = true;

			inputNode = InputNodes[i];
			while (inputNode.id != 'Operator') {
				inputNode = inputNode.previousSibling;
			}
			if (inputNode.EnName == "instrExt(@,#,$)>0"
					|| inputNode.EnName == "instrExt(@,#,$)=0") {
				ColumnMultipleArray[i] = true;
			} else {
				ColumnMultipleArray[i] = false;
			}
		} else {
			BaseColumnArray[i] = false;
			ColumnMultipleArray[i] = false;
		}
		BaseBOMItemSourceArray[BaseBOMItemSourceArray.length] = firstBomItem.Source;
	}
//	alert("BaseBOMItemSourceArray.length--"+BaseBOMItemSourceArray.length);
	// 用于记录自核结论那一列
	//BaseColumnArray[BaseColumnArray.length] = false;
	ColumnMultipleArray[ColumnMultipleArray.length] = false;
	BaseBOMItemSourceArray[BaseBOMItemSourceArray.length] = "";
	var sql = "select sysvarvalue from ldsysvar  where sysvar='ibrmsUWLevel'";
	var reArray = getAndPrepareData(sql);
	var UWSource = reArray[0][0];
	BaseColumnArray[BaseColumnArray.length] = true;
	ColumnMultipleArray[ColumnMultipleArray.length] = false;
	BaseBOMItemSourceArray[BaseBOMItemSourceArray.length] = "";
//  alert("BaseBOMItemSourceArray.length--"+BaseBOMItemSourceArray.length);
}

function dataToTable() {
	getInputNodes();
	var dataD = new Array();
	if (InputNodes.length != 0) {
		for ( var i = 0; i < InputNodes.length - 1; i++) {
			if (InputNodes[i].id != "InputNodes") {
				if (!!InputNodes[i].EnName) {
					if (ColumnDataTypeArray[i] == 'Date') {
						var dt = new Date(InputNodes[i].EnName);
						dataD[i] = dt.format('Y-m-d H:i:s');
					} else {
						dataD[i] = InputNodes[i].EnName;
					}
				}
			} else {
				var firstNode = InputNodes[i].firstChild;
				var first = true;
				while (firstNode) {
					if (firstNode.id == "Input") {
						if (first) {
							dataD[i] = firstNode.EnName;
							first = false;
						} else {
							dataD[i] += ";" + firstNode.EnName;
						}
					}
					firstNode = firstNode.nextSibling;
				}
			}
		}
		if (!!InputNodes[InputNodes.length - 1].value) {
			dataD[InputNodes.length - 1] = InputNodes[InputNodes.length - 1].value;
		}

	}
	var dataArray = sm.getSelections();
	if (dataArray.length > 1) {
		alert(I18NMsg("M0000072374"));
	} else if (dataArray.length == 0) {
		alert(I18NMsg("M0000072375"));

	} else {

		// dataD[dataD.length]=dataArray[0].get(dataId[dataId.length-1].name);
		var dIndex = grid.getStore().indexOf(dataArray[0]);
		data = getData();
		data[dIndex] = dataD;
		ds = new Ext.data.Store( {
			proxy :new Ext.data.MemoryProxy(data),
			reader :new Ext.data.ArrayReader( {}, dataId)
		});
		ds.load();
		grid.reconfigure(ds, cm);

	}

}
function troggleData(tData) {
	if (InputNodes.length == tData.length) {
		for ( var i = 0; i < tData.length - 1; i++) {
			if (InputNodes[i].id != "InputNodes") {
				if (!!tData[i]) {
					InputNodes[i].EnName = tData[i];
					InputNodes[i].innerHTML = tData[i];
				}
			} else {
				if (!!tData[i]) {
					var strArray = tData[i].split(";");
					j = 0;
					var firstNode = InputNodes[i].firstChild;
					while (firstNode) {
						if (firstNode.id == "Input") {
							if (!!strArray[j]) {
								firstNode.EnName = strArray[j];
								firstNode.innerHTML = strArray[j];
							} else {
								firstNode.EnName = "";
								firstNode.innerHTML = I18NMsg("M0000072413");
							}
							j++;
						}
						firstNode = firstNode.nextSibling;
					}

				}
			}
		}
		InputNodes[InputNodes.length - 1].value = tData[tData.length - 1];
	} else {
		alert(I18NMsg("M0000072414"));
	}
}
function dataToLogic() {
	getInputNodes();
	var tData = getSelectedDatas();
	troggleData(tData); 
}

function RowToLogic(sm, rowIndex, r) {
	if (!InputNodeEnabled) {
		return;
	}
	getInputNodes();
	var len = dataId.length - 1;
	var da = null;
	if (InputNodes.length == len) {
		for ( var i = 0; i < len - 1; i++) {
			da = r.get(dataId[i].name);
			singleDataToLogic(da, i);
		}
		InputNodes[len - 1].value = r.get(dataId[len - 1].name);
	}
}
function CellToLogic(e) {
	if (!InputNodeEnabled) {
		return;
	}

	var nowValue = e.value;
	var orgValue = e.originalValue;
	if (nowValue != orgValue) {
		var col = e.column - 2;
		getInputNodes();
		if (col == InputNodes.length) {
			return;
		}
		if (col != InputNodes.length - 1) {
			singleDataToLogic(nowValue, col);
		} else {
			InputNodes[InputNodes.length - 1].value = nowValue;
		}
	}
}

function InitLogic(e) {
	if (!InputNodeEnabled) {
		return;
	}
	var r = e.record;
	getInputNodes();
	var len = dataId.length - 1;
	var da = null;
	if (InputNodes.length == len) {
		for ( var i = 0; i < len - 1; i++) {
			da = r.get(dataId[i].name);
			singleDataToLogic(da, i);
		}
		InputNodes[len - 1].value = r.get(dataId[len - 1].name);
	}
}

function singleDataToLogic(da, i) {
	if (InputNodes[i].id != "InputNodes") {

		InputNodes[i].EnName = da;
		if (da != "" && da != undefined && da != null) {
			if (ColumnDataTypeArray[i] == "Date") {
				var dt = new Date(da);
				da = dt.format('Y-m-d H:i:s');
			}
			InputNodes[i].innerHTML = da;
			InputNodes[i].ChName = da;
			InputNodes[i].EnName = da;
		} else {
			InputNodes[i].innerHTML = I18NMsg("M0000072413");
		}
	} else {
		if (da != "" && da != undefined && da != null) {
			var strArray = da.split(";");
			var len = strArray.length;
			j = 0;
			var firstNode = InputNodes[i].firstChild;
			while (firstNode) {
				if (j >= len) {
					while (firstNode.nextSibling.id == "Input"
							|| firstNode.nextSibling.id == "comma") {
						InputNodes[i].removeChild(firstNode.nextSibling);
					}
				} else if (firstNode.id == "Input") {
					j++;
					if (j == len) {
						continue;
					}

				}
				if (firstNode.id == "AddInput") {
					break;
				}
				firstNode = firstNode.nextSibling;
			}
			if (j < len) {
				for (; j < len; j++) {
					var spanNode = createOriginSpanNode("comma");
					InputNodes[i].insertBefore(spanNode, firstNode);
					spanNode = createOriginSpanNode("Input");
					InputNodes[i].insertBefore(spanNode, firstNode);
				}
			}
			j = 0;
			firstNode = InputNodes[i].firstChild;
			while (firstNode) {
				if (firstNode.id == "Input") {
					firstNode.EnName = strArray[j];
					if (!!strArray[j]) {
						firstNode.innerHTML = strArray[j];
					} else {
						firstNode.innerHTML = I18NMsg("M0000072413");
					}
					j++;
				}
				firstNode = firstNode.nextSibling;
			}
		} else {
			var firstNode = InputNodes[i].firstChild;

			while (firstNode) {
				if (firstNode.id == "Input") {
					firstNode.EnName = "";
					firstNode.innerHTML = I18NMsg("M0000072413");
					break;
				} else {
					firstNode = firstNode.nextSibling;
				}
			}
			while (firstNode.nextSibling.id != "AddInput") {
				InputNodes[i].removeChild(firstNode.nextSibling);
			}
		}
	}
}

function showButtons() {
	setButtonsState('Enable','RuleZone');
	setButtonsState('Enable','RuleZone1');
	var ruleNodes = document.getElementById("RuleZone3");	
	var ruleNode = ruleNodes.firstChild;
	if(ruleNode.id != "AddButton"){
	  setButtonsState('Enable','RuleZone3');
	  setButtonsState('Enable','RuleZone4');
  }
  var ruleNodes = document.getElementById("RuleZone5");	
	var ruleNode = ruleNodes.firstChild;
	if(ruleNode.id != "AddButton"){
	  setButtonsState('Enable','RuleZone5');
	  setButtonsState('Enable','RuleZone6');
	}
//	 
//	var ruleNodes = document.getElementById("RuleZone7");	
//	var ruleNode = ruleNodes.firstChild;
//	if(ruleNode.id != "AddButton"){
//	  setButtonsState('Enable','RuleZone7');
//	  setButtonsState('Enable','RuleZone8');
//	}
//	var ruleNodes = document.getElementById("RuleZone9");	
//	var ruleNode = ruleNodes.firstChild;
//	if(ruleNode.id != "AddButton"){
//	  setButtonsState('Enable','RuleZone9');
//	  setButtonsState('Enable','RuleZone10');
//	}
//	var ruleNodes = document.getElementById("RuleZone11");	
//	var ruleNode = ruleNodes.firstChild;
//	if(ruleNode.id != "AddButton"){
//	  setButtonsState('Enable','RuleZone11');
//	  setButtonsState('Enable','RuleZone12');
//	}
//	var ruleNodes = document.getElementById("RuleZone13");	
//	var ruleNode = ruleNodes.firstChild;
//	if(ruleNode.id != "AddButton"){
//	  setButtonsState('Enable','RuleZone13');
//	  setButtonsState('Enable','RuleZone14');
//	}
//	var ruleNodes = document.getElementById("RuleZone15");	
//	var ruleNode = ruleNodes.firstChild;
//	if(ruleNode.id != "AddButton"){
//	 setButtonsState('Enable','RuleZone15');
//	  setButtonsState('Enable','RuleZone16');
//	}
//	var ruleNodes = document.getElementById("RuleZone17");	
//	var ruleNode = ruleNodes.firstChild;
//	if(ruleNode.id != "AddButton"){
//	  setButtonsState('Enable','RuleZone17');
//	  setButtonsState('Enable','RuleZone18');
//	}
//	var ruleNodes = document.getElementById("RuleZone19");	
//	var ruleNode = ruleNodes.firstChild;
//	if(ruleNode.id != "AddButton"){
//	  setButtonsState('Enable','RuleZone19');
//	  setButtonsState('Enable','RuleZone20');
//  }
//   
}
function hideButtons() {
	setButtonsState('Disable','RuleZone');
	setButtonsState('Disable','RuleZone1');
	var ruleNodes = document.getElementById("RuleZone3");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone3');
	  setButtonsState('Disable','RuleZone4');
  }
  var ruleNodes = document.getElementById("RuleZone5");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone5');
	  setButtonsState('Disable','RuleZone6');
  }
	var ruleNodes = document.getElementById("RuleZone7");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone7');
	  setButtonsState('Disable','RuleZone8');
	}
	var ruleNodes = document.getElementById("RuleZone9");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone9');
	  setButtonsState('Disable','RuleZone10');
	}
	var ruleNodes = document.getElementById("RuleZone11");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone11');
	  setButtonsState('Disable','RuleZone12');
	}
	var ruleNodes = document.getElementById("RuleZone13");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone13');
	  setButtonsState('Disable','RuleZone14');
	}
	var ruleNodes = document.getElementById("RuleZone15");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone15');
	  setButtonsState('Disable','RuleZone16');
	}
	var ruleNodes = document.getElementById("RuleZone17");
	if(ruleNodes!=null){
	  setButtonsState('Disable','RuleZone17');
	  setButtonsState('Disable','RuleZone18');
	}
	var ruleNodes = document.getElementById("RuleZone19");
	if(ruleNodes!=null){
	  etButtonsState('Disable','RuleZone19');
	  setButtonsState('Disable','RuleZone20');	
	}
}

function setButtonsState(displayType,ZoneName) {	
	// 获取规则区域的节点
	var ruleNodes = document.getElementById(ZoneName);	
	// 获取规则的第一个条件
	var ruleNode = ruleNodes.firstChild;
	// 获取规则的最后一个条件
	var endNode = ruleNodes.lastChild;

	var buttonNode = null;
	if (displayType == 'Enable') {
		  state = '';
	} else {
		state = 'none';
	}
	
	
	while (ruleNode != endNode) {
		buttonNode = ruleNode.lastChild;
		if (buttonNode.id == "AddButton" || buttonNode.id == "DelButton") {  
			buttonNode.style.display = state;
		}
		ruleNode = ruleNode.nextSibling;
	} 
	
	if(displayType == 'Enable')
	{
							if(ZoneName == 'RuleZone1' || ZoneName == 'RuleZone4' || ZoneName == 'RuleZone6'
							   || ZoneName == 'RuleZone8' || ZoneName == 'RuleZone10' || ZoneName == 'RuleZone12' || ZoneName == 'RuleZone14'
							   || ZoneName == 'RuleZone16' || ZoneName == 'RuleZone18' || ZoneName == 'RuleZone20')
							{
								if(ruleNode !=null){
									  if(endNode.id == "AddButton"){
					 	             endNode.style.display = 'none';
					          }else{
					 	             endNode.lastChild.style.display = state;
					          }
								 }
							}
							else
							{
									endNode.style.display = state;							
							}			   		
	}
	else{
				if(ZoneName == 'RuleZone' || ZoneName == 'RuleZone3' || ZoneName == 'RuleZone5' || ZoneName == 'RuleZone7' 
				   || ZoneName == 'RuleZone9' || ZoneName == 'RuleZone11' || ZoneName == 'RuleZone13' || ZoneName == 'RuleZone15' 
				   || ZoneName == 'RuleZone17' || ZoneName == 'RuleZone19')
				{
					endNode.style.display = state;
				}else{
					    if(ruleNode !=null){
					       if(endNode.id == "AddButton"){
					 	         endNode.style.display = 'none';
					       }else{
					 	         endNode.lastChild.style.display = state;
					       }
				      }
			  }
	}

}


function createIntegritySpanNode(xmlNode) {
	var nodeId = xmlNode.getAttribute("id");
	var reSpanNode;
	var paraArray = new Array();

	if (nodeId == "BOM") {
		paraArray = prepareParaArray(xmlNode, BOMIndex);
		reSpanNode = createSpanNode(paraArray, false);
	} else if (nodeId == "BOMItem") {
		paraArray = prepareParaArray(xmlNode, BOMItemIndex);
		reSpanNode = createSpanNode(paraArray, false);
	} else if (nodeId == "Operator") {
		paraArray = prepareParaArray(xmlNode, OperatorIndex);
		reSpanNode = createSpanNode(paraArray, false);
	} else if (nodeId == "Link") {
		paraArray = prepareParaArray(xmlNode, LinkIndex);
		reSpanNode = createSpanNode(paraArray, false);
	} else if (nodeId == "Left_Paren") {
		paraArray = prepareParaArray(xmlNode, ParenIndex);
		reSpanNode = createSpanNode(paraArray, false);
	} else if (nodeId == "Right_Paren") {
		paraArray = prepareParaArray(xmlNode, ParenIndex);
		reSpanNode = createSpanNode(paraArray, false);
	} else if (nodeId == "Input") {
		paraArray = prepareParaArray(xmlNode, InputIndex);
		reSpanNode = createSpanNode(paraArray, false);
	} else if (nodeId == "InputNodes") {
		reSpanNode = createInputNodes();
	}
	return reSpanNode;
}
function prepareParaArray(xmlNode, IndexArray) {
	var reArray = new Array();

	var i = 0;
	var len = 0;
	var att = '';
	for (i = 0, len = IndexArray.length; i < len; i++) {

		att = xmlNode.getAttribute(IndexArray[i]);
		if (IndexArray[i] == "Source") {
			att = att.replace(new RegExp("''", "gm"), "'");
		}
		reArray[i] = {
			attribute :IndexArray[i],
			value :att
		};
	}
	return reArray;
}

function composeDTHeader(DTHeader) {

	var reArray = new Array();

	var head = '';
	var dataType = '';

	var i = 0;
	for (i = 0; i < DTHeader.length - 1; i++) {
		head += DTHeader[i].getAttribute("ChName");
	}
//	alert(head);
	ColumnHeadArray[ColumnHeadArray.length] = head;
	ColumnDataTypeArray[ColumnDataTypeArray.length] = DTHeader[i - 1].getAttribute("MatchType");
}

function initDataArray() {
	for ( var i = 0; i < 10; i++) {
		data[i] = [];
	}
}
