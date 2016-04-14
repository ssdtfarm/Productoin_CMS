//create by jiahy
var rowCount1 = 0;
var rowCount2 = 0;
var rowCount3 = 0;
var rowCount4 = 0;
var rowCount5 = 0;
var rowCount6 = 0;
var rowCount7 = 0;
var rowCount8 = 0;
var rowCount9 = 0;
var rowCount10 = 0;
var isMenuUnfolded3 = false;
var isMenuUnfolded4 = false;
var isMenuUnfolded5 = false;
var isMenuUnfolded6 = false;
var isMenuUnfolded7 = false;
var isMenuUnfolded8 = false;
var isMenuUnfolded9 = false;
var isMenuUnfolded10 = false;
var isMenuUnfolded11 = false;
var isMenuUnfolded12 = false;
var isMenuUnfolded13 = false;
var isMenuUnfolded14 = false;
var isMenuUnfolded15 = false;
var isMenuUnfolded16 = false;
var isMenuUnfolded17 = false;
var isMenuUnfolded18 = false;
var isMenuUnfolded19 = false;
var isMenuUnfolded20 = false;
var hasRule3 = false;
var hasRule4 = false;
var hasRule5 = false;
var hasRule6 = false;
var hasRule7 = false;
var hasRule8 = false;
var hasRule9 = false;
var hasRule10 = false;
var hasRule11 = false;
var hasRule12 = false;
var hasRule13 = false;
var hasRule14 = false;
var hasRule15 = false;
var hasRule16 = false;
var hasRule17 = false;
var hasRule18 = false;
var hasRule19 = false;
var hasRule20 = false;



function showOrHideMenu3() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded3)// 菜单未打开
		{
			unFoldMenu3(); // 展开菜单
			isMenuUnfolded3 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded3 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu4() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded4)// 菜单未打开
		{
			unFoldMenu4(); // 展开菜单
			isMenuUnfolded4 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded4 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu3() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions3").nextSibling;

	if (hasRule3) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone3");
		var newLine = createNewAditionLine3();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule3 = true;
	}
}


function unFoldMenu4() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions4").nextSibling;

	if (hasRule4) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone4");
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
		hasRule4 = true;
	}
}


// 创建新条件函数
function createNewAditionLine3() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount1 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount1++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
function showOrHideMenu5() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded5)// 菜单未打开
		{
			unFoldMenu5(); // 展开菜单
			isMenuUnfolded5 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded5 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu6() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded6)// 菜单未打开
		{
			unFoldMenu6(); // 展开菜单
			isMenuUnfolded6 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded6 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu5() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions5").nextSibling;

	if (hasRule5) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone5");
		var newLine = createNewAditionLine5();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule5 = true;
	}
}


function unFoldMenu6() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions6").nextSibling;

	if (hasRule6) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone6");
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
		hasRule6 = true;
	}
}


// 创建新条件函数
function createNewAditionLine5() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount2 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount2++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
function showOrHideMenu7() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded7)// 菜单未打开
		{
			unFoldMenu7(); // 展开菜单
			isMenuUnfolded7 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded7 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu8() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded8)// 菜单未打开
		{
			unFoldMenu8(); // 展开菜单
			isMenuUnfolded8 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded8 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu7() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions7").nextSibling;

	if (hasRule7) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone7");
		var newLine = createNewAditionLine7();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule7 = true;
	}
}


function unFoldMenu8() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions8").nextSibling;

	if (hasRule8) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone8");
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
		hasRule8 = true;
	}
}


// 创建新条件函数
function createNewAditionLine7() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount3 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount3++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
function showOrHideMenu9() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded9)// 菜单未打开
		{
			unFoldMenu9(); // 展开菜单
			isMenuUnfolded9 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded9 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu10() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded10)// 菜单未打开
		{
			unFoldMenu10(); // 展开菜单
			isMenuUnfolded10 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded10 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu9() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions9").nextSibling;

	if (hasRule9) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone9");
		var newLine = createNewAditionLine9();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule9 = true;
	}
}


function unFoldMenu10() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions10").nextSibling;

	if (hasRule10) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone10");
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
		hasRule10 = true;
	}
}


// 创建新条件函数
function createNewAditionLine9() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount4 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount4++;
	return divNode;
}
//--------------------------------------------------------------------------------------------9 10
function showOrHideMenu11() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded11)// 菜单未打开
		{
			unFoldMenu11(); // 展开菜单
			isMenuUnfolded11 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded11 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu12() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded12)// 菜单未打开
		{
			unFoldMenu12(); // 展开菜单
			isMenuUnfolded12 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded12 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu11() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions11").nextSibling;

	if (hasRule11) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone11");
		var newLine = createNewAditionLine11();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule11 = true;
	}
}


function unFoldMenu12() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions12").nextSibling;

	if (hasRule12) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone12");
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
		hasRule12 = true;
	}
}


// 创建新条件函数
function createNewAditionLine11() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount5 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount5++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
function showOrHideMenu13() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded13)// 菜单未打开
		{
			unFoldMenu13(); // 展开菜单
			isMenuUnfolded13 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded13 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu14() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded14)// 菜单未打开
		{
			unFoldMenu14(); // 展开菜单
			isMenuUnfolded14 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded14 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu13() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions13").nextSibling;

	if (hasRule13) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone13");
		var newLine = createNewAditionLine13();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule13 = true;
	}
}


function unFoldMenu14() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions14").nextSibling;

	if (hasRule14) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone14");
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
		hasRule14 = true;
	}
}


// 创建新条件函数
function createNewAditionLine13() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount6 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount6++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
function showOrHideMenu15() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded15)// 菜单未打开
		{
			unFoldMenu15(); // 展开菜单
			isMenuUnfolded15 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded15 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu16() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded16)// 菜单未打开
		{
			unFoldMenu16(); // 展开菜单
			isMenuUnfolded16 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded16 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu15() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions15").nextSibling;

	if (hasRule15) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone15");
		var newLine = createNewAditionLine15();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule15 = true;
	}
}


function unFoldMenu16() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions16").nextSibling;

	if (hasRule16) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone16");
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
		hasRule16 = true;
	}
}


// 创建新条件函数
function createNewAditionLine15() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount7 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount7++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
function showOrHideMenu17() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded17)// 菜单未打开
		{
			unFoldMenu17(); // 展开菜单
			isMenuUnfolded17 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded17 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu18() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded18)// 菜单未打开
		{
			unFoldMenu18(); // 展开菜单
			isMenuUnfolded18 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded18 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu17() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions17").nextSibling;

	if (hasRule17) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone17");
		var newLine = createNewAditionLine17();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule17 = true;
	}
}


function unFoldMenu18() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions18").nextSibling;

	if (hasRule18) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone18");
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
		hasRule18 = true;
	}
}


// 创建新条件函数
function createNewAditionLine17() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount8 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount8++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
function showOrHideMenu19() {	
	if (spanNodeEnabled) {
		if (!isMenuUnfolded19)// 菜单未打开
		{
			unFoldMenu19(); // 展开菜单
			isMenuUnfolded19 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded19 = false;// 设置记录标识为折叠状态
		}
	}
}

function showOrHideMenu20() {
	if (spanNodeEnabled) {
		if (!isMenuUnfolded20)// 菜单未打开
		{
			unFoldMenu20(); // 展开菜单
			isMenuUnfolded20 = true;// 设置记录标识为打开状态
		} else {
			foldMenu(); // 折叠菜单
			isMenuUnfolded20 = false;// 设置记录标识为折叠状态
		}
	}
}

function unFoldMenu19() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy
	var nextNode = document.getElementById("conditions19").nextSibling;

	if (hasRule19) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone19");
		var newLine = createNewAditionLine19();//创建一行
		var buttonNode = createAddLineButton();//增加每一行下面的“+”号按钮
		// 获取当前节点的父节点以及下一个兄弟节点
		var pareNode = event.srcElement.parentNode;
		var nextNode = event.srcElement.nextSibling;
		// 将“条件”节点以及“增加条件”节点插入到“form”节点之后

		divNode.appendChild(newLine);
		divNode.appendChild(buttonNode);
		// 将form节点插入到当前节点之后
		pareNode.insertBefore(divNode, nextNode);
		hasRule19 = true;
	}
}


function unFoldMenu20() {
	// 创建“DIV”节点、“新条件”节点、”增加条件“节点
//jiahy---
	var nextNode = document.getElementById("conditions20").nextSibling;

	if (hasRule20) {
		nextNode.style.display = '';
	} else {
		var divNode = document.createElement("div");
		divNode.setAttribute("id", "RuleZone20");
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
		hasRule20 = true;
	}
}


// 创建新条件函数
function createNewAditionLine19() {
	var divNode = document.createElement("div");// 创建一个"div"节点(一个条件就在一行中,以"div"标识)
		if (rowCount9 != 0) {
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

	var buttonNode = createDeleteButtonNode(); // 创建一个可以删除本条件的按钮节点
	divNode.appendChild(buttonNode);
	rowCount9++;
	return divNode;
}
//--------------------------------------------------------------------------------------------
