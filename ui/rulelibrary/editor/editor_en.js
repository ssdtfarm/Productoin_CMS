var app = {};
var bomContainer=[];
var itemContainer={};
if(!editMode){
	editMode = "edit";//para--Configuration parameters mode,edit--Rules of editing mode 
}
$.ajax({
	type: "GET",
	url: "./load.jsp",
	async: false,
	data: {oper:'loadbom',wagecode:wagecode,indexcode:indexcode,t:(new Date()).getTime()},
	success: function(msg){
	 eval("bomContainer="+msg);
	}
});
$.ajax({
	type: "GET",
	url: "./load.jsp",
	async: false,
	data: {oper:'loaditem',wagecode:wagecode,indexcode:indexcode,t:(new Date()).getTime()},
	success: function(msg){
	 eval("itemContainer="+msg);
	}
});
//alert(bomContainer);
//alert($.toJSON(itemContainer));
/***************************************************************/
var item = $$({
	model: {objType:'item'},
  view: {
    format: '<li style="list-style-image: url(x.png)"><span data-bind="nam"/><span data-bind="val" style="display:none;"/></li>', 
    style: '& span { cursor:pointer;}'+
    			 '& li{list-style-type:none;margin:0;padding:0;float:left;}'
  },
  controller: {
    'click span': function(){
    	//alert("span");
    	if(editMode == 'para'){
  			return;
  		}
    	this.model.get('pModel').view.$('ul.list').hide();
    	//this.model.get('pModel').view.$('ul.attrlist').hide();
    	//this.model.get('pModel').view.$('ul.oplist').hide();
    	//this.model.get('pModel').view.$('ul.vallist').hide();
    	
    	//this.model.get('pModel').view.$('ul.connlist').hide();
    	var val = this.model.get('val');
    	var nam = this.model.get('nam');
    	//删除之后的bom
    	var listType = this.model.get('listType');
    	if((listType == 'bom' || listType == 'attr' || listType == 'op' || listType == 'val')
    		&& val!='(' && val!='del('){
//	    	if(this.model.get('listType'))
	    	var objid = this.model.get('pModel').model.get('objid');
	    	var f = false;
	    	this.model.get('pModel').model.get('statement').view.$('.bomdiv').each(function(){
	    		if(f){
	    			$(this).remove();
	    		}
	    		if($(this).attr('objid')==objid){
	    			f = true;
	    		}
	    	});
	    }
    	if(this.model.get('listType')=='bom') {                 //bom List
    		if(val=='('){
    			var currpreop = this.model.get('pModel').model.get('currpreop');
    			currpreop = currpreop ? val+currpreop : val;
    			this.model.get('pModel').model.set({currpreop:currpreop});
    		} else if(val=='del('){
    			var currpreop = this.model.get('pModel').model.get('currpreop');
    			currpreop = currpreop ? currpreop.substring(1) : currpreop;
    			this.model.get('pModel').model.set({currpreop:currpreop});
    		} else{
    			this.model.get('pModel').model.set({currbom:nam});
	    		this.model.get('pModel').model.set({currattr:'property'});
	    		this.model.get('pModel').model.set({currop:''});
	    		this.model.get('pModel').model.set({currval:''});
	    		//this.model.get('pModel').view.$('span.attr').show();
	    		//this.model.get('pModel').view.$('span.op').hide();
	    		//this.model.get('pModel').view.$('span.val').hide();
	    		//this.model.get('pModel').view.$('input.val').hide();
	    		//初始化item
	    		this.model.get('pModel').view.$('ul.attrlist').empty();
	    		var rightB = $$(item,{nam:')',val:')',pModel:this.model.get('pModel'),listType:'attr',itemid:''});
				var drB = $$(item,{nam:'Remove a bracket',val:'del)',pModel:this.model.get('pModel'),listType:'attr'});
		  		this.model.get('pModel').append(rightB,'.attrlist');
		  		this.model.get('pModel').append(drB,'.attrlist');
		  		var items = null;
		  		//alert("items=itemContainer."+this.model.get('bomid'));
		  		eval("items=itemContainer."+this.model.get('bomid'));
		  		for(var i in items){
		  			var newItem = $$(item,{nam:items[i].name,val:items[i].name,pModel:this.model.get('pModel'),listType:'attr',itemid:items[i].id});
  		  		this.model.get('pModel').append(newItem,'.attrlist');
		  		}
    		}
    	} else if(this.model.get('listType')=='attr'){          //Item List
    		var itemid = this.model.get('itemid');
    		if(val==')'){
    			var currsufop = this.model.get('pModel').model.get('currsufop');
    			currsufop = currsufop ? val+currsufop : val;
    			this.model.get('pModel').model.set({currsufop:currsufop});
    		} else if(val=='del)'){
    			var currsufop = this.model.get('pModel').model.get('currsufop');
    			currsufop = currsufop ? currsufop.substring(1) : currsufop;
    			this.model.get('pModel').model.set({currsufop:currsufop});
    		} else{
	    		this.model.get('pModel').model.set({currattr:nam});
	    		this.model.get('pModel').model.set({itemid:itemid});
	    		this.model.get('pModel').model.set({currop:'Operator'});
	    		//this.model.get('pModel').model.set({currval:'Please select'});
	    		this.model.get('pModel').view.$('span.op').show();
	    		//this.model.get('pModel').view.$('span.val').hide();
	    		//this.model.get('pModel').view.$('input.val').hide();
	    	}
    	}	else if(this.model.get('listType')=='op'){            //operate List
    		//
    		if(val=='end'){
    			this.model.get('pModel').model.set({currop:''});
    		} else {
    			this.model.get('pModel').model.set({currval:'Please select'});
    			this.model.get('pModel').model.set({currop:val});
    			this.model.get('pModel').view.$('span.val').show();
    		}
    	} else if(this.model.get('listType')=='op2'){
    		this.model.get('pModel').model.set({currval2:'Please select'});
    		if(val=='end'){
    			this.model.get('pModel').model.set({currop2:''});
    			this.model.get('pModel').model.set({currval2:''});
    		} else {
    			this.model.get('pModel').model.set({currop2:val});
    			this.model.get('pModel').view.$('span.val2').show();
    		}
    	}	else if(this.model.get('listType')=='val'){
    		var valType = this.model.get('valType');
    		this.model.get('pModel').model.set({valType:valType});
    		//alert(valType);
    		if(valType == 'input'){
    			this.model.get('pModel').model.set({currval:val});
    			//
    			this.model.get('pModel').model.set({currop2:'Operator'});
    			this.model.get('pModel').view.$('span.op2').show();
    		} else if(valType == 'add'){
    			var currsufop2 = this.model.get('pModel').model.get('currsufop2');
    			currsufop2 = currsufop2 ? val+currsufop2 : val;
    			this.model.get('pModel').model.set({currsufop2:currsufop2});
    		} else if(valType == 'del'){
    			var currsufop2 = this.model.get('pModel').model.get('currsufop2');
    			currsufop2 = currsufop2 ? currsufop2.substring(1) : currsufop2;
    			this.model.get('pModel').model.set({currsufop2:currsufop2});
    		} else {
    			this.model.get('pModel').model.set({currval:''});
    			var stat = this.model.get('pModel').model.get('statement');
    			var tBom = $$(bom, {statement:stat,finished:false,objid:(new Date()).getTime()});
  				stat.append(tBom,'.boms');
  				//////////
  				tBom.model.set({currbom:val});
	    		tBom.model.set({currattr:'property'});
	    		//tBom.model.set({currop:'Operator'});
	    		//tBom.model.set({currval:'Please select'});
	    		tBom.view.$('span.attr').show();
	    		//tBom.view.$('span.op').hide();
	    		//tBom.view.$('span.val').hide();
	    		//tBom.view.$('input.val').hide();
	    		//初始化item
	    		tBom.view.$('ul.attrlist').empty();
	    		var rightB = $$(item,{nam:')',val:')',pModel:tBom,listType:'attr',itemid:''});
					var drB = $$(item,{nam:'Remove a bracket',val:'del)',pModel:tBom,listType:'attr'});
		  		tBom.append(rightB,'.attrlist');
		  		tBom.append(drB,'.attrlist');
		  		var items = null;
		  		//alert("items=itemContainer."+this.model.get('bomid'))
		  		eval("items=itemContainer."+this.model.get('bomid'));
		  		for(var i in items){
		  			var newItem = $$(item,{nam:items[i].name,val:items[i].name,pModel:tBom,listType:'attr',itemid:items[i].id});
  		  		tBom.append(newItem,'.attrlist');
		  		}
    		}
    	}else if(this.model.get('listType')=='val2'){
    		//var valType = this.model.get('valType');
    		//this.model.get('pModel').model.set({valType2:valType});
    		//alert(valType);
    		if(val == 'Value'){
    			this.model.get('pModel').model.set({currval2:val});
    			return;
    		}else if(val == 'Value(Number)'){
    			this.model.get('pModel').model.set({currval2:val});
    			return;
    		}else if(val == 'Value(String)'){
    			this.model.get('pModel').model.set({currval2:val});
    			return;
    		}else if(val == 'Value(Date)'){
    			this.model.get('pModel').model.set({currval2:val});
    			return;
    		}
  			this.model.get('pModel').model.set({currval2:''});
  			var stat = this.model.get('pModel').model.get('statement');
  			var tBom = $$(bom, {statement:stat,finished:false,objid:(new Date()).getTime()});
				stat.append(tBom,'.boms');
				//////////
				tBom.model.set({currbom:val});
    		tBom.model.set({currattr:'property'});
    		//tBom.model.set({currop:'Operator'});
    		//tBom.model.set({currval:'Please select'});
    		tBom.view.$('span.attr').show();
    		//tBom.view.$('span.op').hide();
    		//tBom.view.$('span.val').hide();
    		//tBom.view.$('input.val').hide();
    		//initialization item
    		tBom.view.$('ul.attrlist').empty();
    		var rightB = $$(item,{nam:')',val:')',pModel:tBom,listType:'attr',itemid:''});
				var drB = $$(item,{nam:'Remove a bracket',val:'del)',pModel:tBom,listType:'attr'});
	  		tBom.append(rightB,'.attrlist');
	  		tBom.append(drB,'.attrlist');
	  		var items = null;
	  		//alert("items=itemContainer."+this.model.get('bomid'))
	  		eval("items=itemContainer."+this.model.get('bomid'));
	  		for(var i in items){
	  			var newItem = $$(item,{nam:items[i].name,val:items[i].name,pModel:tBom,listType:'attr',itemid:items[i].id});
		  		tBom.append(newItem,'.attrlist');
	  		}
    	}	else if(this.model.get('listType')=='conn'){         //Conjunction（Or/And）
    		this.model.get('pModel').model.set({currconn:nam});
    	}
    	
      return false;
    }
	}
});

////////////////////////////////////////////////////////////////////////////////////////
//
//    Bom
//
////////////////////////////////////////////////////////////////////////////////////////
function initBom(tObject){
	if(editMode == 'para'){
	}
	var leftB = $$(item,{nam:'(',val:'(',pModel:tObject,listType:'bom'});
	var dB = $$(item,{nam:'Remove a bracket',val:'del(',pModel:tObject,listType:'bom'});
	tObject.append(leftB,'.bomlist');
	tObject.append(dB,'.bomlist');
	for(var i in bomContainer){
		var newItem = $$(item,{nam:bomContainer[i].name,val:bomContainer[i].name,bomid:bomContainer[i].bomid,pModel:tObject,listType:'bom'});
		tObject.append(newItem,'.bomlist');
	}
	//Init Operator
	var newItem1 = $$(item,{nam:'+',val:'+',pModel:tObject,listType:'op'});
	var newItem2 = $$(item,{nam:'-',val:'-',pModel:tObject,listType:'op'});
	var newItem3 = $$(item,{nam:'*',val:'*',pModel:tObject,listType:'op'});
	var newItem4 = $$(item,{nam:'/',val:'/',pModel:tObject,listType:'op'});
	var newItem5 = $$(item,{nam:'<',val:'<',pModel:tObject,listType:'op'});
	var newItem6 = $$(item,{nam:'<=',val:'<=',pModel:tObject,listType:'op'});
	var newItem7 = $$(item,{nam:'=',val:'=',pModel:tObject,listType:'op'});
	var newItem8 = $$(item,{nam:'>=',val:'>=',pModel:tObject,listType:'op'});
	var newItem9 = $$(item,{nam:'>',val:'>',pModel:tObject,listType:'op'});
	var newItem10 = $$(item,{nam:'<>',val:'<>',pModel:tObject,listType:'op'});
	var newItem11 = $$(item,{nam:'End',val:'end',pModel:tObject,listType:'op'});
	tObject.append(newItem1,'.oplist');
	tObject.append(newItem2,'.oplist');
	tObject.append(newItem3,'.oplist');
	tObject.append(newItem4,'.oplist');
	tObject.append(newItem5,'.oplist');
	tObject.append(newItem6,'.oplist');
	tObject.append(newItem7,'.oplist');
	tObject.append(newItem8,'.oplist');
	tObject.append(newItem9,'.oplist');
	tObject.append(newItem10,'.oplist');
	tObject.append(newItem11,'.oplist');
	var new2Item1 = $$(item,{nam:'+',val:'+',pModel:tObject,listType:'op2'});
	var new2Item2 = $$(item,{nam:'-',val:'-',pModel:tObject,listType:'op2'});
	var new2Item3 = $$(item,{nam:'*',val:'*',pModel:tObject,listType:'op2'});
	var new2Item4 = $$(item,{nam:'/',val:'/',pModel:tObject,listType:'op2'});
	var new2Item5 = $$(item,{nam:'<',val:'<',pModel:tObject,listType:'op2'});
	var new2Item6 = $$(item,{nam:'<=',val:'<=',pModel:tObject,listType:'op2'});
	var new2Item7 = $$(item,{nam:'=',val:'=',pModel:tObject,listType:'op2'});
	var new2Item8 = $$(item,{nam:'>=',val:'>=',pModel:tObject,listType:'op2'});
	var new2Item9 = $$(item,{nam:'>',val:'>',pModel:tObject,listType:'op2'});
	var new2Item10 = $$(item,{nam:'<>',val:'<>',pModel:tObject,listType:'op2'});
	var new2Item11 = $$(item,{nam:'End',val:'end',pModel:tObject,listType:'op2'});
	tObject.append(new2Item1,'.oplist2');
	tObject.append(new2Item2,'.oplist2');
	tObject.append(new2Item3,'.oplist2');
	tObject.append(new2Item4,'.oplist2');
	tObject.append(new2Item5,'.oplist2');
	tObject.append(new2Item6,'.oplist2');
	tObject.append(new2Item7,'.oplist2');
	tObject.append(new2Item8,'.oplist2');
	tObject.append(new2Item9,'.oplist2');
	tObject.append(new2Item10,'.oplist2');
	tObject.append(new2Item11,'.oplist2');
	//initialization val
	var mitem = $$(item,{nam:'Value(Number)',val:'Value(Number)',pModel:tObject,listType:'val',valType:'input'});
	var mitem2 = $$(item,{nam:'Value(String)',val:'Value(String)',pModel:tObject,listType:'val',valType:'input'});
	var mitem3 = $$(item,{nam:'Value(Date)',val:'Value(Date)',pModel:tObject,listType:'val',valType:'input'});
	tObject.append(mitem3,'.vallist');
	tObject.append(mitem2,'.vallist');
	tObject.append(mitem,'.vallist');
	
	var ip = $$(item,{nam:')',val:')',pModel:tObject,listType:'val',valType:'add'});
	var dip = $$(item,{nam:'Remove a bracket',val:'Remove a bracket',pModel:tObject,listType:'val',valType:'del'});
	tObject.append(ip,'.vallist');
	tObject.append(dip,'.vallist');
	for(var i in bomContainer){
		var newItem = $$(item,{nam:bomContainer[i].name,val:bomContainer[i].name,bomid:bomContainer[i].bomid,pModel:tObject,listType:'val',valType:'bom'});
		tObject.append(newItem,'.vallist');
	}
	var mitem2 = $$(item,{nam:'Value（String）',val:'Value（String）',pModel:tObject,listType:'val2',valType:'input'});
	tObject.append(mitem2,'.vallist2');
	var mitem3 = $$(item,{nam:'Value(Date)',val:'Value(Date)',pModel:tObject,listType:'val2',valType:'input'});
	tObject.append(mitem3,'.vallist2');
	//initialization val2
	var mitem = $$(item,{nam:'Value(Number)',val:'Value(Number)',pModel:tObject,listType:'val2',valType:'input'});
	tObject.append(mitem,'.vallist2');
	//var ip = $$(item,{nam:')',val:')',pModel:tObject,listType:'val2',valType:'add'});
	//var dip = $$(item,{nam:'Remove a bracket',val:'Remove a bracket',pModel:tObject,listType:'val2',valType:'del'});
	//tObject.append(ip,'.vallist2');
	//tObject.append(dip,'.vallist2');
	for(var i in bomContainer){
		var newItem = $$(item,{nam:bomContainer[i].name,val:bomContainer[i].name,bomid:bomContainer[i].bomid,pModel:tObject,listType:'val2',valType:'bom'});
		tObject.append(newItem,'.vallist2');
	}
	tObject.model.set({finished:true});
}
var bom = $$({
	//model:{objType:'bom',currbom:'Please select',currattr:'property',currop:'Operator',currval:'Please select'}, 
	model:{objType:'bom',currbom:'Please select',currattr:'',currop:'',currval:''}, 
	view:{
		format:'<div class="bomdiv" data-bind="objid=objid" data-bind="bomid=bomid" style="position:relative;"><div>'+
								'<span class="preop" data-bind="currpreop"/>'+
								'<span class="bom" data-bind="currbom"/>'+
								'<ul class="bomlist list"/>'+
							'</div><div>'+
								'<span class="attr" data-bind="currattr"/>'+
								'<span class="sufop" data-bind="currsufop"/>'+
								'<ul class="attrlist list"/>'+
							'</div><div>'+
								'<span class="op" data-bind="currop"/>'+
								'<ul class="oplist list"/>'+
							'</div><div>'+
								'<span class="itemid" data-bind="itemid" style="display:none;"/>'+
								'<span class="val" data-bind="currval"/>'+
								'<span class="sufop2" data-bind="currsufop2"/>'+
								'<ul class="vallist list"/>'+
							'</div><div>'+
								'<span class="op2" data-bind="currop2"/>'+
								'<ul class="oplist2 list"/>'+
							'</div><div>'+
								'<span class="val2" data-bind="currval2"/>'+
								'<ul class="vallist2 list"/>'+
							'</div></div>',
		style:'& {float:left;}'+
					'& div {position:relative;float:left;margin-left:5px;}'+
					'& span {cursor:pointer;}'+
					//'& span.preop {display:block;}'+
					'& ul {position:absolute;border:1px gray solid;top:16px;background-color:#f7f6e5;width:400px;height:200px;overflow:auto;margin:0;padding:5px;display:none;z-index:999}'+
					'& span.attr {color:gray;}'+
					//'& span.op {display:none;}'+
					//'& .val {display:none;}'+
					'& span.val {color:blue;}'+
					'& span.val2 {color:blue;}'
		},
	controller:{
		'create':function(){
			if(!_fresh)return false;
			//initialization bomlist
			/*var leftB = $$(item,{nam:'(',val:'(',pModel:this,listType:'bom'});
			var dB = $$(item,{nam:'Remove a bracket',val:'del(',pModel:this,listType:'bom'});
  		this.append(leftB,'.bomlist');
  		this.append(dB,'.bomlist');
  		//this.append(leftB,'.bomlist');
  		//this.append(dB,'.bomlist');
  		for(var i in bomContainer){
				var newItem = $$(item,{nam:bomContainer[i].name,val:bomContainer[i].name,bomid:bomContainer[i].bomid,pModel:this,listType:'bom'});
				this.append(newItem,'.bomlist');
			}*/
  		
			//for(var i = 0; i < 20; i++){
  		//	var newItem = $$(item,{nam:'Bom ' + i,val:'Bom ' + i,pModel:this,listType:'bom'});
  		//	this.append(newItem,'.bomlist');
  		//}
  		
  		//initialization attrlist
  		//var rightB = $$(item,{nam:')',val:')',pModel:this,listType:'attr',itemid:''});
			//var drB = $$(item,{nam:'Remove a bracket',val:'del)',pModel:this,listType:'attr'});
  		//this.append(rightB,'.attrlist');
  		//this.append(drB,'.attrlist');
  		//$.get( "./load.jsp" ,{oper:'loaditem',t:(new Date()).getTime()} , function(data){
  		//	var boms = null;
			//	eval("boms="+data);
			//	for(var i in boms){
			//		var newItem = $$(item,{nam:boms[i].name,val:boms[i].name,bomid:boms[i].bomid,pModel:this,listType:'bom'});
  		//		this.append(newItem,'.bomlist');
			//	}
			//});
  		//for(var i = 0; i < 10; i++){
  		//	var newItem = $$(item,{nam:'Item ' + i,val:'Item ' + i,pModel:this,listType:'attr',itemid:'i'+i});
  		//	this.append(newItem,'.attrlist');
  		//}
  		
  		//initialize Operator
  		/*var newItem1 = $$(item,{nam:'+',val:'+',pModel:this,listType:'op'});
  		var newItem2 = $$(item,{nam:'-',val:'-',pModel:this,listType:'op'});
  		var newItem3 = $$(item,{nam:'*',val:'*',pModel:this,listType:'op'});
  		var newItem4 = $$(item,{nam:'/',val:'/',pModel:this,listType:'op'});
  		var newItem5 = $$(item,{nam:'<',val:'<',pModel:this,listType:'op'});
  		var newItem6 = $$(item,{nam:'<=',val:'<=',pModel:this,listType:'op'});
  		var newItem7 = $$(item,{nam:'=',val:'=',pModel:this,listType:'op'});
  		var newItem8 = $$(item,{nam:'>=',val:'>=',pModel:this,listType:'op'});
  		var newItem9 = $$(item,{nam:'>',val:'>',pModel:this,listType:'op'});
  		var newItem10 = $$(item,{nam:'<>',val:'<>',pModel:this,listType:'op'});
  		var newItem11 = $$(item,{nam:'End',val:'end',pModel:this,listType:'op'});
  		this.append(newItem1,'.oplist');
  		this.append(newItem2,'.oplist');
  		this.append(newItem3,'.oplist');
  		this.append(newItem4,'.oplist');
  		this.append(newItem5,'.oplist');
  		this.append(newItem6,'.oplist');
  		this.append(newItem7,'.oplist');
  		this.append(newItem8,'.oplist');
  		this.append(newItem9,'.oplist');
  		this.append(newItem10,'.oplist');
  		this.append(newItem11,'.oplist');
  		var new2Item1 = $$(item,{nam:'+',val:'+',pModel:this,listType:'op2'});
  		var new2Item2 = $$(item,{nam:'-',val:'-',pModel:this,listType:'op2'});
  		var new2Item3 = $$(item,{nam:'*',val:'*',pModel:this,listType:'op2'});
  		var new2Item4 = $$(item,{nam:'/',val:'/',pModel:this,listType:'op2'});
  		var new2Item5 = $$(item,{nam:'<',val:'<',pModel:this,listType:'op2'});
  		var new2Item6 = $$(item,{nam:'<=',val:'<=',pModel:this,listType:'op2'});
  		var new2Item7 = $$(item,{nam:'=',val:'=',pModel:this,listType:'op2'});
  		var new2Item8 = $$(item,{nam:'>=',val:'>=',pModel:this,listType:'op2'});
  		var new2Item9 = $$(item,{nam:'>',val:'>',pModel:this,listType:'op2'});
  		var new2Item10 = $$(item,{nam:'<>',val:'<>',pModel:this,listType:'op2'});
  		var new2Item11 = $$(item,{nam:'End',val:'end',pModel:this,listType:'op2'});
  		this.append(new2Item1,'.oplist2');
  		this.append(new2Item2,'.oplist2');
  		this.append(new2Item3,'.oplist2');
  		this.append(new2Item4,'.oplist2');
  		this.append(new2Item5,'.oplist2');
  		this.append(new2Item6,'.oplist2');
  		this.append(new2Item7,'.oplist2');
  		this.append(new2Item8,'.oplist2');
  		this.append(new2Item9,'.oplist2');
  		this.append(new2Item10,'.oplist2');
  		this.append(new2Item11,'.oplist2');*/
  		
  		//初始化val
  		/*var mitem = $$(item,{nam:'Value',val:'Value',pModel:this,listType:'val',valType:'input'});
  		this.append(mitem,'.vallist');
  		var ip = $$(item,{nam:')',val:')',pModel:this,listType:'val',valType:'add'});
			var dip = $$(item,{nam:'Remove a bracket',val:'Remove a bracket',pModel:this,listType:'val',valType:'del'});
  		this.append(ip,'.vallist');
  		this.append(dip,'.vallist');
  		for(var i in bomContainer){
				var newItem = $$(item,{nam:bomContainer[i].name,val:bomContainer[i].name,bomid:bomContainer[i].bomid,pModel:this,listType:'val',valType:'bom'});
				this.append(newItem,'.vallist');
			}
			//initialize val2
  		var mitem = $$(item,{nam:'Value',val:'Value',pModel:this,listType:'val2',valType:'input'});
  		this.append(mitem,'.vallist2');
  		//var ip = $$(item,{nam:')',val:')',pModel:this,listType:'val2',valType:'add'});
			//var dip = $$(item,{nam:'Remove a bracket',val:'Remove a bracket',pModel:this,listType:'val2',valType:'del'});
  		//this.append(ip,'.vallist2');
  		//this.append(dip,'.vallist2');
  		for(var i in bomContainer){
				var newItem = $$(item,{nam:bomContainer[i].name,val:bomContainer[i].name,bomid:bomContainer[i].bomid,pModel:this,listType:'val2',valType:'bom'});
				this.append(newItem,'.vallist2');
			}*/
		},
  	'click span.bom': function(){
  		//alert("bom");
  		if(!this.model.get('finished')){
	  		initBom(this);
			}
  		if(editMode == 'para'){
  			return;
  		}
  		var isb = $("ul.bomlist").is(":visible");
  		$('.list').hide();
  		this.view.$('ul.bomlist').toggle(!isb);
  	},
  	'click span.attr': function(){
  		//alert("term");
  		if(!this.model.get('finished')){
	  		initBom(this);
			}
  		if(editMode == 'para'){
  			return;
  		}
  		var isb = $("ul.attrlist").is(":visible");
  		$('.list').hide();
	    this.view.$('ul.attrlist').toggle(!isb);
  	},
  	'click span.op': function(){
  		//alert("span.op");
  		if(!this.model.get('finished')){
	  		initBom(this);
			}
  		if(editMode == 'para'){
  			return;
  		}
  		var isb = $("ul.oplist").is(":visible");
  		$('.list').hide();
	    this.view.$('ul.oplist').toggle(!isb);
  	},
  	'click span.op2': function(){
  		//alert("span.op2");
  		if(!this.model.get('finished')){
	  		initBom(this);
			}
  		if(editMode == 'para'){
  			return;
  		}
  		var isb = $("ul.oplist2").is(":visible");
  		$('.list').hide();
	    this.view.$('ul.oplist2').toggle(!isb);
  	},
  	'click span.val': function(){
  		//alert("span.val");
  		if(!this.model.get('finished')){
	  		initBom(this);
			}
  		if(editMode == 'para'){
  			return;
  		}
  		var isb = $("ul.vallist").is(":visible");
  		$('.list').hide();
	    this.view.$('ul.vallist').toggle(!isb);
  	},
  	'click span.val2': function(){
  		//alert("span.val2");
  		if(!this.model.get('finished')){
	  		initBom(this);
			}
  		if(editMode == 'para'){
  			return;
  		}
  		var isb = $("ul.vallist").is(":visible");
  		$('.list').hide();
	    this.view.$('ul.vallist').toggle(!isb);
	    //alert('end');
  	}
  }
});

////////////////////////////////////////////////////////////////////////////////////////
//
//    Statement
//
////////////////////////////////////////////////////////////////////////////////////////
var statement = $$({
	model:{objType:'statement'}, 
	view:{
		format:'<div class="statement">'+
							'<span class="conn" data-bind="currconn" style="font-size:75%;font-style:italic;"/>'+
							'<ul class="connlist list"/>'+
							'<div class="boms" />'+
							'<span title="Delete rule" class="dels edit">X</span>'+
					'</div><br/>',
		style:'& {position:relative;}'+
					'& span {cursor:pointer;float:left;}'+
					'& ul {position:absolute;border:1px gray solid;top:16px;background-color:#f7f6e5;width:400px;height:200px;overflow:auto;margin:0;padding:5px;display:none;z-index:999}'+
					'& div {float:left;}'+
					'& .dels {cursor:pointer;font-weight:normal;font-family:arial;font-size:90%;margin-left:20px;color:lightseagreen;}'
		},
	controller:{
		'create': function(){
			var item1 = $$(item,{nam:'And',val:'and',pModel:this,listType:'conn'});
  		var item2 = $$(item,{nam:'Or',val:'or',pModel:this,listType:'conn'});
  		this.append(item1,'.connlist');
  		this.append(item2,'.connlist');
  		var tBom = $$(bom, {statement:this,finished:false,objid:(new Date()).getTime()});
  		this.append(tBom,'.boms');
  	},
  	'click span.conn': function(){
  		//alert("span.conn");
  		if(editMode == 'para'){
  			return;
  		}
  		this.view.$('ul.connlist').show();
  		return false;
  	},
  	'click span.dels': function(){
  		//alert("span.dels");
  		if(confirm('Sure to delete?')){
  			//delete or remove
  			this.destroy();
  			//if you delete the first statement, the currconn of the second statement need to blank.
  			//if(!pStat){
				var found = false;
				this.model.get('block').each(function(){
					if(!found && this.model.get('objType')=='statement'){
						found = true;
						this.model.set({currconn:''});
					}
				});//each
  			//}
  		}
  	},
  	'addbom': function(model){
  		model.statement = this;
  		var names;
  		$.ajax({
  			type: "GET",
  			url: "./load.jsp",
  			async: false,
  			data: {oper:'loadNames',indexcode:model.itemid,t:(new Date()).getTime()},
  			success: function(msg){
  			eval("names="+msg);
  			model.currbom = names.currbom;
  			model.currattr = names.currattr;
  			}
  		});
  		var tBom = $$(bom, model);
  		tBom.model.set({finished:false});
  		this.append(tBom,'.boms');
  		//tBom.view.$('span.preop').show();
  		tBom.view.$('span.bom').show();
  		if(model.currbom != 'Please select'){
  			if(model.currattr != 'property' ){
  				tBom.view.$('span.attr').show();
					//tBom.view.$('span.sufop').show();
					if(!model.currop != 'Operator' ){
						tBom.view.$('span.op').show();
						tBom.view.$('span.val').show();
					}
  			}
  		}
			
  		return tBom;
  	}
  	
  }//controller
});
var block = $$({
	model:{objType:'block'}, 
	view:{
		format:'<div>'+
							'<span class="block;" data-bind="currblock"/>'+
							'<div class="statements"/>'+
							'<div style="clear:both;"/>'+
							'<div class="addb edit"><a title="Add Rule" href="javascript:void(0);">+</a></div>'+
					'</div>',
		style:'& {position:relative;}'+
					'& span.block {cursor:pointer;font-size:75%;font-weight:bold;font-style:italic;}'+
					'& .addb a {text-decoration:none;font-size:20px;font-weight:bold;}'
		},
	controller:{
		'create': function(){
			//alert('block create');
		},
  	'click a': function(){
  		//alert("a");
  		if(editMode == 'para'){
  			return;
  		}
  		var stat;
  		if(this.size()>0){
  			stat = $$(statement,{currconn:'And',block:this,objid:(new Date()).getTime()});
  		} else {
  			stat = $$(statement,{block:this,objid:(new Date()).getTime()});
  		}
  		//alert(this.model.get('objType'));
  		this.append(stat,'.statements');
	  	return false;
  	},
  	'addstatement': function(model){
  		model.block = this;
  		var stat = $$(statement,model);
  		/*if(this.size()>0){
  			stat = $$(statement,{currconn:'And',block:this});
  		} else {
  			stat = $$(statement,{block:this});
  		}*/
  		//alert(this.model.get('objType'));
  		this.append(stat,'.statements');
	  	return stat;
  	}
  }
});

////////////////////////////////////////////////////////////////////////////////////////
//
//    If-Then
//
////////////////////////////////////////////////////////////////////////////////////////
var decith = $$({objType:'decith'}, '<th style="border:1px #c9c9c9 solid;padding:2px 10px 2px 10px;font-size:80%;"><span data-bind="itemnam"/><span style="display:none;" data-bind="itemid"/></th>');
var decitd = $$({objType:'decitd'}, '<td style="border:1px #c9c9c9 solid;padding:2px 10px 2px 10px;font-size:80%;background-color:white;"><input data-bind="itemval" type="text" style="border:none;width:100%;text-align:right;"/></td>');
var decirm = $$({objType:'decirm'}, '<td style="border:1px #c9c9c9 solid;padding:0px;font-size:80%;background-color:white;"><button class="rm">-</button></td>',{
	"click .rm": function(){
		//alert("rm");
		this.model.get('tr').destroy();
	}
});
var decitr = $$({objType:'decitr'}, '<tr class="data"/>');
var ifthen = $$({
	model:{}, 
	view:{
		format:'<div style="background-color:#F5F5DC;margin-bottom:5px;" class="ifthen">'+
							'<div class="ifblock"/>'+
							'<div class="thenblock"/>'+
							'<div id="deciblock" class="deciblock"><table style="border-collapse:collapse;margin-top:5px;" class="dstable"><tr class="head" style="background-color:wheat;"/></table><button class="addrow" id="addrowbutton" style="display:none;">+</button></div>'+
							'<div class="delit edit"><a title="Delete The Rule Block" href="javascript:void(0);">X</a></div>'+
					'</div>',
		style:'& .ifblock {margin-bottom:10px;}'+
					'& .delit a {text-decoration:none;font-size:100%;font-weight:bold;font-family:arial;}'
		},
	controller:{
  	'create': function(){
  		var ifb = $$(block,{currblock:'If',objType:'if',objid:(new Date()).getTime()});
  		var thenb = $$(block,{currblock:'Then',objType:'then',objid:(new Date()).getTime()});
  		this.append(ifb,'.ifblock');
	  	this.append(thenb,'.thenblock');
  	},
  	'click div.delit a': function(){
  		//alert("div.delit a");
  		if(editMode == 'para'){
  			return;
  		}
  		if(confirm('Sure to delete?')){
  			this.destroy();
  		}
  		return false;
  	},
  	'displaytitle': function(){
  		//first delete table
  		var topObj = this;
  		//$('tr.head').empty();
  		this.each(function(){
  			var objType = this.model.get('objType');
  			if(objType == 'decith' || objType == 'decitr'){
  				this.destroy();
  			}
  		});
  		//generate a table
  		var deci = this.model.get('deci');
			for(var i in deci){
			$("#deciblock").show();
  			var t = $$(decith,deci[i]);
				this.append(t,'tr.head');
  		}
  		var t = $$(decith,{itemnam:'-',itemid:'-'});
			this.append(t,'tr.head');
			if(deci.length > 0){
				this.view.$('.addrow').show();
			}else {
				this.view.$('.addrow').hide();
			}
  	},
  	'addrow': function(aRow){
  		if(aRow){
  			//alert(aRow.length + "|" + this.model.get('deci').length)
  			//alert(this.model);
  			if(aRow.length != this.model.get('deci').length) {
	  			alert('An error occurred because the title does not match with its parameter while initializing decision table!');
	  			return false;
	  		}
  		}
  		var deci = this.model.get('deci');
  		var tr = $$(decitr,{});
  		for(var i = 0; i < deci.length; i++){
  			var itemval = '';
  			if(aRow){
  				itemval = aRow[i];
  			}
				var ite = $$(decitd,{decitr:tr,objType:'decitd',itemval:itemval});
				tr.append(ite);
			}
			var t = $$(decirm,{tr:tr});
			tr.append(t);
  		this.append(tr,'table.dstable');
  	},
  	'click button.addrow': function(){
  		this.controller.addrow();
	  	return false;
  	}
  }
});

////////////////////////////////////////////////////////////////////////////////////////
//
//    If-Then-Else
//
////////////////////////////////////////////////////////////////////////////////////////
var ifthenelse = $$({
	model:{currblock:'',objType:'ifthenelse'}, 
	view:{
		format:'<div style="border:3px #F5F5DC solid;margin-bottom:5px;">'+
							'<div class="ifthens"/>'+
							'<div class="add edit" style="border-bottom:3px #F5F5DC solid;"><a class="addb" title="Add Rule Block" href="javascript:void(0);">+</a></div>'+
							'<div class="elseblock"/>'+
							'<div class="deciblock2"><table style="border-collapse:collapse;margin-top:5px;" class="dstable"><tr class="head" style="background-color:wheat;"/></table><button class="addrow" id="addrowbutton" style="display:none;">+</button></div>'+
					'</div>',
		style:'& a.addb {text-decoration:none;font-size:150%;font-weight:bold;font-family:arial;}'
		},
	controller:{
		'create': function(){
  		//var it = $$(ifthen,{ifthenelse:this,objType:'ifthen',objid:(new Date()).getTime()});
  		var elseb = $$(block,{currblock:'Else',objType:'else',objid:(new Date()).getTime()});
  		//this.append(it,'div.ifthens');
	  	this.append(elseb,'.elseblock');
  	},
  	'click a': function(){
  		if(editMode == 'para'){
  			return;
  		}
  		var it = $$(ifthen,{ifthenelse:this,objType:'ifthen',objid:(new Date()).getTime()});
	  	this.append(it,'div.ifthens');
	  	return false;
  	},
  	'addifthen': function(ifthenmodel){
  		//alert(1);
  		ifthenmodel.ifthenelse=this;
  		ifthenmodel.objType='ifthen';
  		var it = $$(ifthen, ifthenmodel);
	  	this.append(it,'div.ifthens');
	  	return it;
  	},
  	'displaytitle': function(){
  		//先删除表格
  		var topObj = this;
  		//$('tr.head').empty();
  		this.each(function(){
  			var objType = this.model.get('objType');
  			if(objType == 'decith' || objType == 'decitr'){
  				this.destroy();
  			}
  		});
  		//生成表格
  		var deci = this.model.get('deci');
			for(var i in deci){
  			var t = $$(decith,deci[i]);
				this.append(t,'.deciblock2 tr.head');
  		}
  		//var t = $$(decith,{itemnam:'-',itemid:'-'});
			//this.append(t,'.deciblock2 tr.head');
  	},
  	'addrow': function(aRow){
  		if(aRow){
  			//alert(aRow.length + "||" + this.model.get('deci').length)
  			if(aRow.length != this.model.get('deci').length) {
	  			alert('An error occurred because the title does not match with its parameter while initializing decision table!');
	  			return false;
	  		}
  		}
  		var deci = this.model.get('deci');
  		var tr = $$(decitr,{});
  		for(var i = 0; i < deci.length; i++){
  			var itemval = '';
  			if(aRow){
  				itemval = aRow[i];
  			}
				var ite = $$(decitd,{decitr:tr,objType:'decitd',itemval:itemval});
				tr.append(ite);
			}
			//var t = $$(decirm,{tr:tr});
			//tr.append(t);
  		this.append(tr,'.deciblock2 table.dstable');
  	},
  	'click button.addrow': function(){
  		if(editMode == 'para'){
  			return;
  		}
  		this.controller.addrow();
	  	return false;
  	}
  }
});

////////////////////////////////////////////////////////////////////////////////////////
//
//    If-Then-Else-决策表 
//
////////////////////////////////////////////////////////////////////////////////////////
var ifthenelsetable = $$({
	model:{currblock:'',objType:'ifthenelsetable'}, 
	view:{
		format:'<div>'+
							'<div class="ifthenelse"/>'+
							'<div id="ebutton" style="display:none;float:left">'+
							'<button class="save">Save Rule</button>'+
							'</div>'+
							'<div id="sbutton" style="display:none;float:left">'+
							'<button  style="display:none" class="sflag" >Set Personalized Tag</button>'+
							'</div>'+
							'<div id="qbutton" style="display:none;float:left">'+
							'<button style="display:none" class="qflag" >Cancel Personalized Tag</button>  '+
							'</div>'+
							'<div id="pbutton" style="display:none;float:left">'+
							'<button class="savepara" >Save Parameter</button>'+
							'</div>'+
					'</div>',
		style:'& a.addb {text-decoration:none;font-size:150%;font-weight:bold;font-family:arial;}'
		},
	controller:{
		'create': function(){
  		var ite = $$(ifthenelse,{ifthenelsetable:this,objType:'ifthenelse'});
  		this.append(ite,'div.ifthenelse');
  	},
  	'click a': function(){
  		if(editMode == 'para'){
  			return;
  		}
  		var it = $$(ifthen,{ifthenelse:this,objType:'ifthen'});
	  	this.append(it,'div.ifthen');
	  	return false;
  	},
  	'click button.sflag': function(){
  		$("#ebutton").hide();
		$("#pbutton").show();
		$("#sbutton").hide();
		$("#qbutton").show();
		$.post( "./save.jsp" ,{basecode:basecode,agentgrade:agentgrade,indextype:indextype,indexcode:indexcode,t:(new Date()).getTime(),oper:'sflag'} , function(data){
			alert(data);
		});
  	},'click button.qflag': function(){
  		$("#ebutton").hide();
		$("#pbutton").hide();
		$("#sbutton").show();
		$("#qbutton").hide();
		$.post( "./save.jsp" ,{basecode:basecode,agentgrade:agentgrade,indextype:indextype,indexcode:indexcode,t:(new Date()).getTime(),oper:'qflag'} , function(data){
			alert(data);
		});
  	},
  	'click button.save': function(){
  		app = getObj();
  		if(app.sql=="#ELSE##/ELSE#"){
  			alert("Rule has not been configured, please configure it then save!");
  			return false;
  		}
  		//$.post( "./save.jsp" ,{indexcode:indexcode,indexset:app.indexset.join(),json:$.toJSON(app),t:(new Date()).getTime()} , function(data){
  		var tmp = [];
  		for(var item in app.ths){
  			tmp.push(app.ths[item].itemid);
  		}
  		if(!confirm("Sure to submit?")){ return; }
  		$.post("./save.jsp" ,{oper:'saverule',indexcode:indexcode,ths:tmp.join(),indexset:app.indexset.join(),sql:app.sql,json:$.toJSON(app),t:(new Date()).getTime()} , function(data){
				alert(data);
			});
  	},
  	'click button.savepara': function(){
  		app = getObj();
  		/*var tt = "";
  		for(var t in app.ths){
  			tt?tt=tt+",'"+app.ths[t].itemid+"'":tt="'"+app.ths[t].itemid+"'";
  		}
  		var para = "";
  		$('tr.data').each(function(i){
  			var aRow="";
  			$('input',this).each(function(j){
  				j==0?aRow=$(this).val():aRow=aRow+","+$(this).val();
  			});
  			i==0?para=aRow:para=para+"@"+aRow;
  		});*/
  		//app = getObj();
  		//alert(app.ifthensql + app.elsesql);
  		//$.post( "./save.jsp" ,{indexcode:indexcode,indexset:app.indexset.join(),json:$.toJSON(app),t:(new Date()).getTime()} , function(data){
  		
  		//alert(app.ifthenelse.ifthen[0].datas.join())
  		//准备参数
  		//ifthen
  		var ifthenpara = [];
  		var arr= new Array();
  		var arr2= new Array();
  		for(var i = 0; i < app.ifthenelse.ifthen.length; i++){
  			var dArray = app.ifthenelse.ifthen[i].datas;
  			var count  = dArray.toString().split(",").length ;
  			var sql = app.sql.toString().split("#ELSE#")[0];
  			var sql2 = app.sql.toString().split("#ELSE#")[1];
  			var tp = sql.slice(sql.indexOf("Value(")+6,sql.indexOf("Value(")+10);
  			var tp2 = sql2.slice(sql2.indexOf("Value(")+6,sql2.indexOf("Value(")+10);
  			while(sql.indexOf("Value(")!=-1){
  				if(tp=="Numb"){
  					arr.push("N");
  				}else if(tp=="Date"){
  					arr.push("D");
  				}else if(tp="Stri"){
  					arr.push("S");
  				}
  				sql = sql.replace("Value","");
  				tp = sql.slice(sql.indexOf("Value(")+6,sql.indexOf("Value(")+10);
  			}
  			
  			while(sql2.indexOf("Value(")!=-1){
  				if(tp2=="Numb"){
  					arr2.push("N");
  				}else if(tp2=="Date"){
  					arr2.push("D");
  				}else if(tp2="Stri"){
  					arr2.push("S");
  				}
  				sql2 = sql2.replace("Value","");
  				tp2 = sql2.slice(sql2.indexOf("Value(")+6,sql2.indexOf("Value(")+10);
  			}
  			
  			var aTable = [];
  			for(var j = 0; j < dArray.length; j++){
  				aTable.push(dArray[j].join());
  			}
  			ifthenpara.push(aTable.join('|'));
  		}
  		
  	   var mm = true;
  	   var tt = 0;
  		//新增参数中含“Value”不能为空的校验
  	   $('.deciblock table input').each(function(){
  		   var len = arr.length;
          if($(this).val()== ''){
              alert("Parameter value cannot be blank, please reconfigure it!");
              mm = false;
              return false;
           }else{
              if(arr[tt%len]=='N'){
//            	  var patrn=/^[0-9]{1,20}$/;   //只能录入正整数
            	  var patrn=/^\d+(\.\d+)?$/; 
            	  if (!patrn.test($(this).val())){
            		  alert("Parameter value type does not match!");
            		  mm = false;
            		  return false;
            	  } 
              }else if(arr[tt%len]=='D'){
            	  var a = /^(\d{4})-(\d{2})-(\d{2})$/;
        		  if (!a.test($(this).val())) { 
        		  alert("Parameter data format is incorrect!"); 
        		  mm = false;
        		  return false;
        		  } 
              }
              tt++;
          }
       });
  	   
  	 $('.deciblock2 table input').each(function(){
		var len = arr2.length;
        if($(this).val()== ''){
            alert("Parameter value cannot be blank, please reconfigure it!");
            mm = false;
            return false;
         }else{
            if(arr2[tt%len]=='N'){
//          	  var patrn=/^[0-9]{1,20}$/;  //只能录入正整数
          	  var patrn=/^\d+(\.\d+)?$/; 
          	  if (!patrn.test($(this).val())){
          		  alert("Parameter value type does not match!");
          		  mm = false;
          		  return false;
          	  } 
            }else if(arr2[tt%len]=='D'){
          	  var a = /^(\d{4})-(\d{2})-(\d{2})$/;
      		  if (!a.test($(this).val())) { 
      		  alert("Parameter data format is incorrect!"); 
      		  mm = false;
      		  return false;
      		  } 
            }
            tt++;
        }
     });
  	 
  	   if(!mm){
  		 return false;
  	   }
  		ifthenstr = ifthenpara.join("@");
  		//elsesql
  		elsestr = app.ifthenelse._else.datas.join();
  		if(!confirm("Sure to submit?")){ return; }
  		$.post( "./save.jsp" ,{basecode:basecode,wagecode:wagecode,agentgrade:agentgrade,indextype:indextype,indexcode:indexcode,ifthenpara:ifthenstr,elsepara:elsestr,json:$.toJSON(app),t:(new Date()).getTime(),oper:'savepara'} , function(data){
				alert(data);
			});
  	},
  	'initRule': function(){
  		//var ite = $$(ifthenelse,{ifthenelsetable:this,objType:'ifthenelse'});
  		//this.append(ite,'div.ifthenelse');
  		var t = this;
			if(indexcode){
					$.get( "./load.jsp" ,{indexcode:indexcode,oper:'rule',agentgrade:agentgrade,indextype:indextype,editmode:editMode,basecode:basecode,t:(new Date()).getTime()} , function(data){
						eval("app="+data);
						if(app){
							t.empty();
							initApp();
						}else{
							app = {};
						}
						if(editMode == 'para'&basecode == 'null'){
							$(".edit").hide();
							$(".list").hide();
							$("#ebutton").hide();
							$("#pbutton").show();
							$("#sbutton").hide();
							$("#qbutton").hide();
							if(state=='06'||state=='04'||state=='02'){
								$("#ebutton").hide();
								$("#pbutton").hide();
								$("#sbutton").hide();
								$("#qbutton").hide();
							}
							//$("#deciblock").hide();
							//$("#addrowbutton").show();
						}else if(editMode == 'para'){
							$(".edit").hide();
							$(".list").hide();
							$("#ebutton").hide();
							$("#pbutton").hide();
							$("#sbutton").show();
							var calprpty;
							$.get( "./load.jsp" ,{oper:'calprpty',indexcode:indexcode,indextype:indextype,agentgrade:agentgrade,basecode:basecode,t:(new Date()).getTime()} , function(data){
								eval("calprpty="+data);
								if(calprpty.flag=="Y"){
									$("#ebutton").hide();
									$("#pbutton").show();
									$("#sbutton").hide();
									$("#qbutton").show();
								}
							})
							if(state=='06'||state=='04'||state=='02'){
								$("#ebutton").hide();
								$("#pbutton").hide();
								$("#sbutton").hide();
								$("#qbutton").hide();
							}
							//$("#deciblock").hide();
							//$("#addrowbutton").show();
						}else if(editMode == 'edit'){
							$("#pbutton").hide();
							$("#addrowbutton").hide();
							$("#ebutton").show();
							$("#sbutton").hide();
							$("#qbutton").hide();
						}
//						alert($(".data input").length);
						if($(".data input").length<1){
							$("#pbutton").hide();
							$("#sbutton").hide();
							$("#qbutton").hide();
						}
					});
			}
  	}
  }
});

$$.document.append(ifthenelsetable);
ifthenelsetable.controller.initRule();

/**************************************************************
*/

function initApp(){
	//If--Then--Else
	//app = getObj();
			if(app.ifthenelse){
				var ite = $$(ifthenelse, app.ifthenelse.model);
  			ifthenelsetable.append(ite,'div.ifthenelse');
  			var elsea;
  			ite.each(function(){
  				if(this.model.get('objType')=='ifthen'){
  					this.destroy();
  				}else if(this.model.get('objType')=='else'){
  					elsea = this;
  				}
  			});
  			//ifthen
				if(app.ifthenelse.ifthen){
					for(var i in app.ifthenelse.ifthen){
						var it = app.ifthenelse.ifthen[i];
						var ito = ite.controller.addifthen(it.model);
						ito.each(function(){
							if(this.model.get('objType')=='if'){
								for(var s in it._if.statement){
									var statement = it._if.statement[s];
									var stato = this.controller.addstatement(statement.model);
									stato.empty();
									if(statement.bom.length == 0){
										stato.view.$('span.dels').hide();
									}
									for(var b in statement.bom){
										stato.controller.addbom(statement.bom[b]);
									}
								}
							}else if(this.model.get('objType')=='then'){
								for(var s in it._then.statement){
									var statement = it._then.statement[s];
									var stato = this.controller.addstatement(statement.model);
									stato.empty();
									if(statement.bom.length == 0){
										stato.view.$('span.dels').hide();
									}
									for(var b in statement.bom){
										stato.controller.addbom(statement.bom[b]);
									}
								}
							}
						});
						//决策表
						ito.model.set({deci:it.deci});
						if(editMode == 'para'){
							ito.controller.displaytitle();
							/*$.get( "./load.jsp" ,{basecode:basecode,indexcode:indexcode,oper:'loadParaData',t:(new Date()).getTime()} , function(data){
								var datas = null;
								eval("datas="+data);
								if(!datas || datas.length == 0){
									ito.controller.addrow();
								}else{
									for(var i = 0; i < datas.length; i++){
										ito.controller.addrow(datas[i]);
									}
								}
							});*/
							if(it.datas.length > 0){
								for(var d in it.datas){
									ito.controller.addrow(it.datas[d]);
								}
							}else {
								ito.controller.addrow();
							}
						}
					}
				}
				//else
				if(app.ifthenelse._else){
					for(var s in app.ifthenelse._else.statement){
						var statement = app.ifthenelse._else.statement[s];
						var stato = elsea.controller.addstatement(statement.model);
								
						stato.empty();
						if(statement.bom.length == 0){
							stato.view.$('span.dels').hide();
						}
						for(var b in statement.bom){
							stato.controller.addbom(statement.bom[b]);
						}
					}
					//决策表
					ite.model.set({deci:app.ifthenelse._else.deci});
					if(editMode == 'para'){
						ite.controller.displaytitle();
						/*$.get( "./load.jsp" ,{basecode:basecode,indexcode:indexcode,oper:'loadParaData',t:(new Date()).getTime()} , function(data){
							var datas = null;
							eval("datas="+data);
							if(!datas || datas.length == 0){
								ite.controller.addrow();
							}else{
								for(var i = 0; i < datas.length; i++){
									ite.controller.addrow(datas[i]);
								}
							}
						});*/
						if(app.ifthenelse._else.datas.length > 0){
							for(var d in app.ifthenelse._else.datas){
								ite.controller.addrow(app.ifthenelse._else.datas[d]);
							}
						}else {
							ite.controller.addrow();
						}
						
					}
				}
			}
			/*//决策表
			if(app.ths){
			}
			//alert(editMode)
			if(editMode == 'para'){
				$(".edit").hide();
				$(".list").hide();
				$("#ebutton").hide();
				ifthenelsetable.controller.displaytitle();
				$.get( "./load.jsp" ,{basecode:basecode,indexcode:indexcode,oper:'loadParaData',t:(new Date()).getTime()} , function(data){
					var datas = null;
					eval("datas="+data);
					if(!datas){
						ifthenelsetable.controller.addrow();
					}else{
						//app = {};
						for(var i = 0; i < datas.length; i++){
							ifthenelsetable.controller.addrow(datas[i]);
						}
					}
				});
				$("#pbutton").show();
				$("#addrowbutton").show();
			}else {
				$("#pbutton").hide();
				$("#addrowbutton").hide();
				$("#ebutton").show();
			}*/
			_fresh = true;
}

function getObj(){
	//var mThis = obj;
	app = {ths:[],indexset:[],ifthensql:'',elsesql:'',ifs:[],thens:[]};
	//var ifO = {};
	$(".ifthen").each(function(){
		var count = 1;
		$('.ifblock .bomdiv', this).each(function(){
			if($('.val',$(this)).text() == 'Value'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value:"+(count++)+" (If)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}else if($('.val',$(this)).text() == 'Value(Number)'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value-Number:"+(count++)+" (If)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}else if($('.val',$(this)).text() == 'Value(String)'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value-String:"+(count++)+" (If)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}if($('.val',$(this)).text() == 'Value(Date)'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value-Date:"+(count++)+" (If)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}
			
		});
		//var thenO = {};
		count = 1;
		$('.thenblock .bomdiv', this).each(function(){
			if($('.val',$(this)).text() == 'Value'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value:"+(count++)+" (Then)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}else if($('.val',$(this)).text() == 'Value(Number)'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value-Number:"+(count++)+" (Then)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}else if($('.val',$(this)).text() == 'Value(String)'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value-String:"+(count++)+" (Then)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}if($('.val',$(this)).text() == 'Value(Date)'){
				var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
				//var id = $('.itemid',$(this)).text();
				//if(!eval("ifO."+id)){
				//	eval("ifO."+id + "=true");
					t.itemnam = "Value-Date:"+(count++)+" (Then)";
					app.ths.push(t);
					app.ifs.push(t);
				//}
			}
			
		});
	});
	//var elseO = {};
	count = 1;
	$('.elseblock .bomdiv').each(function(){
		if($('.val',$(this)).text() == 'Value'){
			var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
			//var id = $('.itemid',$(this)).text();
			//if(!eval("ifO."+id)){
			//	eval("ifO."+id + "=true");
				t.itemnam = "Value:"+(count++)+" (Else)";
				app.ths.push(t);
				app.ifs.push(t);
			//}
		}else if($('.val',$(this)).text() == 'Value(Number)'){
			var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
			//var id = $('.itemid',$(this)).text();
			//if(!eval("ifO."+id)){
			//	eval("ifO."+id + "=true");
				t.itemnam = "Value-Number:"+(count++)+" (Else)";
				app.ths.push(t);
				app.ifs.push(t);
			//}
		}else if($('.val',$(this)).text() == 'Value(String)'){
			var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
			//var id = $('.itemid',$(this)).text();
			//if(!eval("ifO."+id)){
			//	eval("ifO."+id + "=true");
				t.itemnam = "Value-String:"+(count++)+" (Else)";
				app.ths.push(t);
				app.ifs.push(t);
			//}
		}if($('.val',$(this)).text() == 'Value(Date)'){
			var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
			//var id = $('.itemid',$(this)).text();
			//if(!eval("ifO."+id)){
			//	eval("ifO."+id + "=true");
				t.itemnam = "Value-Date:"+(count++)+" (Else)";
				app.ths.push(t);
				app.ifs.push(t);
			//}
		}
		
	});
	//////////////////
	//$('.bomdiv').each(function(){
	//	if($('.val',$(this)).text() == 'Value'){
	//		var t = {itemid:$('.itemid',$(this)).text(),itemnam:$('.attr',$(this)).text(),objType:'decith'};
	//		app.ths.push(t);
	//	}
	//});
	
	//查找IndexSet
	$('.itemid').each(function(){
		var tmp = $(this).text();
		if(tmp != indexcode){
			var found = false;
			for(var i = 0; i < app.indexset.length; i++){
				if(app.indexset[i] == tmp){
					found = true;
					break;
				}
			}
			if(!found){
				app.indexset.push(tmp);
			}
		}
	});
	
	///////////////////////
	//'</div><div>'+
	//							'<span class="op" data-bind="currop"/>'+
	//							'<ul class="oplist list"/>'+
	//						'</div><div>'+
	//							'<span class="itemid" style="display:none;" data-bind="itemid"/>'+
	//							'<span class="val" data-bind="currval"/>'+
	//							'<span class="sufop2" data-bind="currsufop2"/>'+
	//							'<ul class="vallist list"/>'+
	//						'</div><div>'+
	//							'<span class="op2" data-bind="currop2"/>'+
	//							'<ul class="oplist2 list"/>'+
	//						'</div><div>'+
	//							'<span class="val2" data-bind="currval2"/>'+
	//							'<ul class="vallist2 list"/>'+
								
	//拼接SQL			
	var sql = "";
	$(".ifthen").each(function(){
		sql = sql + '#IFTHEN#';
		$('.ifblock',this).each(function(){
			sql = sql + '#IF#';
			//sql = sql + ' case when';
			$(".statement",this).each(function(){
				sql = sql + " " + $('.conn', this).text();
				$('.bomdiv',this).each(function(){
					sql = sql + " " + $('.preop', this).text();
					sql = sql + " @" + $('.itemid', this).text() + "@";
					sql = sql + " " + $('.sufop', this).text();
					
					var mop = $('.op', this).text();
					//var termid =  $('.itemid', this).text();
					var v = $('.val', this).text();
					var sop2 = $('.sufop2', this).text();
					var mop2 = $('.op2', this).text();
					var v2 = $('.val2', this).text();
					sql = sql + " " + mop;
					//sql = sql + " @" + termid + "@";
					sql = sql + " " + v;
					sql = sql + " " + sop2;
					sql = sql + " " + mop2;
					sql = sql + " " + v2;
				});
			});
			sql = sql + '#/IF#';
		});
		$('.thenblock',this).each(function(){
			sql = sql + '#THEN#';
			//sql = sql + ' then';
			var i = 1;
			$('.bomdiv',this).each(function(){
				if(i > 0){
					sql = sql + " " + $('.preop', this).text();
					sql = sql + " @" + $('.itemid', this).text() + "@";
					sql = sql + " " + $('.sufop', this).text();
					
					var mop = $('.op', this).text();
					//var termid =  $('.itemid', this).text();
					var v = $('.val', this).text();
					var sop2 = $('.sufop2', this).text();
					var mop2 = $('.op2', this).text();
					var v2 = $('.val2', this).text();
					sql = sql + " " + mop;
					//sql = sql + " @" + termid + "@";
					sql = sql + " " + v;
					sql = sql + " " + sop2;
					sql = sql + " " + mop2;
					sql = sql + " " + v2;
				} else {
					var v = $('.val', this).text();
					if(v){
						sql = sql + " " + v;
					}
				}
					
				i++;
			});
			sql = sql + '#/THEN#';
		});
		sql = sql + '#/IFTHEN#';
	});
	$('.elseblock').each(function(){
		sql = sql + '#ELSE#';
		//sql = sql + ' else';
		var i = 1;
		$('.bomdiv',this).each(function(){
			if(i > 0){
				sql = sql + " " + $('.preop', this).text();
				sql = sql + " @" + $('.itemid', this).text() + "@";
				sql = sql + " " + $('.sufop', this).text();
				
				var mop = $('.op', this).text();
				//var termid =  $('.itemid', this).text();
				var v = $('.val', this).text();
				var sop2 = $('.sufop2', this).text();
				var mop2 = $('.op2', this).text();
				var v2 = $('.val2', this).text();
				sql = sql + " " + mop;
				//sql = sql + " @" + termid + "@";
				sql = sql + " " + v;
				sql = sql + " " + sop2;
				sql = sql + " " + mop2;
				sql = sql + " " + v2;
			} else {
				var v = $('.val', this).text();
				if(v){
					sql = sql + " " + v;
				}
			}
			
			i++;
		});
		sql = sql + '#/ELSE#';
	});
	app.sql = sql;
	//var app = {};
	ifthenelsetable.each(function(){
  			var objType = this.model.get('objType');
  			if(objType == 'ifthenelse')	{
  				//alert($.toJSON(createModel(this.model)));
  				app.ifthenelse = {model:createModel(this.model),ifthen:[]};
  				//app.ifthenelse.model = this.model;
  				this.each(function(){
  					var objType2 = this.model.get('objType');
  					if(objType2 == 'ifthen'){
  						var ifthen = {model:createModel(this.model),_if:{},_then:{},deci:[]};
  						app.ifthenelse.ifthen.push(ifthen);
  						//查找决策表“If”
  						var count = 1;
  						this.view.$('.ifblock .bomdiv').each(function(){
  							if($('.val',$(this)).text() == 'Value'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value:"+(count++)+" (If)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(Number)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-Number:"+(count++)+" (If)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(String)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-String:"+(count++)+" (If)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(Date)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-Date(YYYY-MM-DD):"+(count++)+" (If)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}
  							if($('.val2',$(this)).text() == 'Value'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value:"+(count++)+" (If)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(Number)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-Number:"+(count++)+" (If)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(String)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-String:"+(count++)+" (If)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(Date)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-Date(YYYY-MM-DD):"+(count++)+" (If)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}
  						});
  						//查找决策表“Then”
  						count = 1;
							this.view.$('.thenblock .bomdiv').each(function(){    
								if($('.val',$(this)).text() == 'Value'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value:"+(count++)+" (Then)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(Number)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-Number:"+(count++)+" (Then)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(String)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-String:"+(count++)+" (Then)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(Date)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-Date(YYYY-MM-DD):"+(count++)+" (Then)";
									ifthen.deci.push(t);
									//alert(ifthen.deci.length);
								}
  							if($('.val2',$(this)).text() == 'Value'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value:"+(count++)+" (Then)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(Number)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-Number:"+(count++)+" (Then)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(String)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-String:"+(count++)+" (Then)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(Date)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-Date(YYYY-MM-DD):"+(count++)+" (Then)";
								ifthen.deci.push(t);
								//alert(ifthen.deci.length);
							}});
							//数据
							var datas = [];
							var theEnd = false;
				  		this.view.$('tr.data').each(function(i){
				  			if($('input', this).length>0){
				  				if($('input', this)[0].value && !theEnd) {
					  				var aRow=[];
						  			$('input',this).each(function(j){
						  				//j==0?aRow=$(this).val():aRow=aRow+","+$(this).val();
						  				aRow.push($(this).val());
						  			});
						  			datas.push(aRow);
					  			}else{
					  				theEnd = true;
					  			}
				  			}
				  			
				  		});
				  		ifthen.datas = datas;
				  		//alert(app.ifthenelse.ifthen[0].datas.join());
							//this.model.set({deci:ifthen.deci});
							//
  						this.each(function(){
  							var objType3 = this.model.get('objType');
  							if(objType3 == 'if'){
  								ifthen._if = {model:createModel(this.model),statement:[]};
  								//app.ifthensql += " case when";
		  						this.each(function(){
		  							var objType4 = this.model.get('objType');
		  							if(objType4 == 'statement'){
		  								var statement = {model:createModel(this.model),bom:[]};
		  								ifthen._if.statement.push(statement);
				  						this.each(function(){
				  							var objType5 = this.model.get('objType');
				  							if(objType5 == 'bom'){
				  								statement.bom.push(createModel(this.model));
						  					}
				  						});
				  					}
		  						});
		  					}else if(objType3 == 'then'){
		  						ifthen._then = {model:createModel(this.model),statement:[]};
		  						this.each(function(){
		  							var objType4 = this.model.get('objType');
		  							if(objType4 == 'statement'){
		  								var statement = {model:createModel(this.model),bom:[]};
		  								ifthen._then.statement.push(statement);
				  						this.each(function(){
				  							var objType5 = this.model.get('objType');
				  							if(objType5 == 'bom'){
				  								statement.bom.push(createModel(this.model));
				  								//ifthen._then.statement.bom.push(this.model);
						  					}
				  						});
				  					}
		  						});
		  					}
  						});
  					}else if(objType2 == 'else'){
  						app.ifthenelse._else = {model:createModel(this.model),statement:[],deci:[]};
  						//查找决策表“Else”
  						var count = 1;
							this.view.$('.bomdiv').each(function(){                 
								if($('.val',$(this)).text() == 'Value'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value:"+(count++);
									app.ifthenelse._else.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(Number)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-Number:"+(count++);
									app.ifthenelse._else.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(String)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-String:"+(count++);
									app.ifthenelse._else.deci.push(t);
									//alert(ifthen.deci.length);
								}else if($('.val',$(this)).text() == 'Value(Date)'){
  									var t = {};
									t.objType='decith';
									t.itemnam = "Value-Date(YYYY-MM-DD):"+(count++);
									app.ifthenelse._else.deci.push(t);
									//alert(ifthen.deci.length);
								}
  							if($('.val2',$(this)).text() == 'Value'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value:"+(count++);
								app.ifthenelse._else.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(Number)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-Number:"+(count++);
								app.ifthenelse._else.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(String)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-String:"+(count++);
								app.ifthenelse._else.deci.push(t);
								//alert(ifthen.deci.length);
							}else if($('.val2',$(this)).text() == 'Value(Date)'){
									var t = {};
								t.objType='decith';
								t.itemnam = "Value-Date(YYYY-MM-DD):"+(count++);
								app.ifthenelse._else.deci.push(t);
								//alert(ifthen.deci.length);
							}});
							//数据
							var datas = [];
							var theEnd = false;
				  		$('.deciblock2 tr.data').each(function(i){
				  			if($('input', this).length>0){
				  				if($('input', this) && $('input', this)[0] && $('input', this)[0].value && !theEnd) {
					  				var aRow=[];
						  			$('input',this).each(function(j){
						  				aRow.push($(this).val());
						  			});
						  			datas.push(aRow);
					  			}else{
					  				theEnd = true;
					  			}
				  			}
				  		});
				  		app.ifthenelse._else.datas = datas;
							//this.model.set({deci:app.ifthenelse._else.deci});
  						this.each(function(){
  							var objType4 = this.model.get('objType');
  							if(objType4 == 'statement'){
  								var statement = {model:createModel(this.model),bom:[]};
		  						app.ifthenelse._else.statement.push(statement);
		  						this.each(function(){
		  							var objType5 = this.model.get('objType');
		  							if(objType5 == 'bom'){
		  								statement.bom.push(createModel(this.model));
				  					}
		  						});
		  					}
  						});
  					}
  				});
  			}
  		});	
  		return app;
}

function createModel(m){
	var tmp = {};
	m.each(function(k,v){
		eval("tmp." + k + "='" + v + "'");
	});
	return tmp;
}