/***************************************************************/
var app = {};
var bomContainer=[];
var itemContainer={};
if(!editMode){
	editMode = "edit";//para--配置参数模式,edit--编辑规则模式
}
$.ajax({
	type: "GET",
	url: "./ruleeditorload.jsp",
	async: false,
	data: {oper:'loadbom',wagecode:wageCode,indexcode:indexCode,t:(new Date()).getTime()},
	success: function(msg){
	 eval("bomContainer="+msg);
	}
});
$.ajax({
	type: "GET",
	url: "./ruleeditorload.jsp",
	async: false,
	data: {oper:'loaditem',wagecode:wageCode,indexcode:indexCode,t:(new Date()).getTime()},
	success: function(msg){
	 eval("itemContainer="+msg);
	}
});
//alert(bomContainer);
//alert($.toJSON(itemContainer));
/***************************************************************/
App = SC.Application.create();

/*

  Model

*/

var wageName;
var indexName;
for(var i = 0; i < bomContainer.length; i++){
	if(bomContainer[i].id == wageCode){
		wageName = bomContainer[i].name;
		var item = null;
		eval("item =itemContainer." + wageCode);
		for(var j = 0; j < item.length; j++){
			if(item[j].id == indexCode){
				indexName = item[j].name;
				break;
			}
		}
		break;
	}
}

App.Item = SC.Object.extend({
	id:'',
	name:'',
	dataType:''
});
App.Bom = SC.Object.extend({
	id:'',
	leftP:'',
	name:'',
	type:'',//input--输入框
	boms:function(){
		var result = [];
		for(var i = 0; i < bomContainer.length; i++){
			result.push(SC.Object.create(bomContainer[i]));
		}
		return result;
	}.property(),
	itemId:'',
	itemName:'',
	items:function(){
		var result = [];
		var its = null;
		eval("its = itemContainer."+ id);
		for(var i = 0; i < its; i++){
			result.push(App.Item.create({id:its[i].id,name:its[i].name,dataType:its[i].datatype}));
		}
		return result;
	}.property('id'),
	rightP:'',
	oper:'',
	opers:function(){
		var result = [];
		result.push(SC.Object.create({id:'o1', name:'+'}));
		result.push(SC.Object.create({id:'o2', name:'-'}));
		result.push(SC.Object.create({id:'o3', name:'*'}));
		result.push(SC.Object.create({id:'o4', name:'/'}));
		result.push(SC.Object.create({id:'o5', name:'='}));
		result.push(SC.Object.create({id:'oe', name:''+I18NMsg("G0000036936")+''}));
		return result;
	}.property()
});
App.testController = SC.Object.create({
	content:App.Bom.create()
});
App.Statement = SC.Object.extend({
	conn:'',
	boms:[] //Bom
});
App.IfThen = SC.Object.extend({
	_If:[],//Statements
	_then:''//Statement
});
App.Model = SC.Object.extend({
	ifThen:[], //IfThen,
	_else:'', //Statement
	_table:function(){
		var ths = [];
		for(var i = 0; i < ifThens.length; i++){
			for(var j = 0; j < ifThens[i].length; j++){
				for(var m = 0; m < tfThens[i]._if.length; m++){
					var _if =itfThens[i]._if;
					for(var n = 0; n < _if.length; n++){
						if(_if[n].type=='input'){
							ths.push(_if[n].value);
						}
					}
				}
				for(var m = 0; m <itfThens[i]._else.length; m++){
					var _else =itfThens[i]._else;
					for(var n = 0; n < _else.length; n++){
						if(_else[n].type=='input'){
							ths.push(_else[n].value);
						}
					}
				}
			}
		}
	}.property('ifThens._if.@each')
});
App.bomsController = SC.Object.create({
  // The array of Bom objects that backs the array controller.
  //ifThen: [], //[{_if:[{conn:'and',bom[{type:'',name:''},{},{}]},{conn:'or',bom[]},{conn:'or',bom[]}],_then:[{type:'',name:''},{type:'',name:''}]}]
  //_else:[], //[{type:'',name:''},{type:'',name:''}]
  content:App.Model.create({}),

  // Adds a new bom to the list.
  addIfThen: function() {
    this.get('ifThen').pushObject({_if:[],_then:[]});
  },
  addbom: function(bom) {
    this.pushObject(bom);
  },

  remove: function(bom) {
    this.removeObject(bom);
  },

  bomDidChange: function(contact) {
    this.remove(contact);
    this.add(contact);
  },

  // Creates a new, empty Contact object and adds it to the
  // array controller.
  newBom: function() {
    var firstName = Math.floor(Math.random()*names.length),
        lastName = Math.floor(Math.random()*names.length),
        hasLastName = Math.random();

    this.add(App.Bom.create({
      firstName: names[firstName],
      lastName: hasLastName < 0.9 ? names[lastName] : null,
      phoneNumbers: []
    }));
  },

  loadData: function() {
    var self = this;
    $.ajax({
      url: '/contacts.json',
      dataType: 'json',
      success: function(data) {
      },

      error: function() {
      }
    });
    if(self.get('content').get('ifThen').length == 0){
    	var ifThen = App.IfThen.create();
    	self.get('content').get('ifThen').pushObject(ifThen);
    	//alert(self.get('content').get('ifThen').length);
    	//var _if = SC.Object.create([{conn:'',bom:[{type:'',name:''}]}]);
    	//var _then = SC.Object.create([{conn:'',bom:[{type:'',name:''}]}]);
    	//self.get('ifThen').pushObject(SC.Object.create({_if:_if,_then:_then}));
    	//alert(_if.get('bom'));
    }
  },

  createBomFromJSON: function(json) {
  }
});
App.bomsController.loadData();
App.IfThenView = SC.View.extend({
	ifThenBinding:'App.bomsController.ifThen'
});
App.StatementView = SC.View.extend({
	//ifThenBinding:'App.bomsController.ifThen'
	ifThenBinding:'App.bomsController.ifThen', //[{_if:[{conn:'and',bom[{type:'',name:''},{},{}]},{conn:'or',bom[]},{conn:'or',bom[]}],_then:[{type:'',name:''},{type:'',name:''}]}]
  _elseBinding:'App.bomsController._else'
});
App.statementController = SC.Object.create({
  // The array of Bom objects that backs the array controller.
  content: [],

  // Adds a new bom to the list.
  add: function(bom) {
    this.pushObject(bom);
  },

  remove: function(bom) {
    this.removeObject(bom);
  },

  bomDidChange: function(contact) {
    this.remove(contact);
    this.add(contact);
  },

  // Creates a new, empty Contact object and adds it to the
  // array controller.
  newBom: function() {
    var firstName = Math.floor(Math.random()*names.length),
        lastName = Math.floor(Math.random()*names.length),
        hasLastName = Math.random();

    this.add(App.Bom.create({
      firstName: names[firstName],
      lastName: hasLastName < 0.9 ? names[lastName] : null,
      phoneNumbers: []
    }));
  },

  loadContacts: function() {
    var self = this;
    $.ajax({
      url: '/contacts.json',
      dataType: 'json',
      success: function(data) {
      },

      error: function() {
      }
    });
  },

  createBomFromJSON: function(json) {
  }
});
/*
App.statment = SC.Object.extend({});
App.ifThen = SC.Object.extend({});
App._else = SC.Object.extend({});
App.deciTable = SC.Object.extend({});
App.editor = content: SC.Object.extend({
	isEditMode:editMode=='edit',
	isCommon:ruleType=='common',
	isDeci:ruleType=='deci',
	ifExpr:ruleType=='expr',
	baseCode:baseCode,
	wageCode:wageCode,
	indexCode:indexCode,
	wageName:wageName,
	indexName:indexName,
	ifThens:[_if:[],_then:[]],
	_else:Ember.Object.create({}),
	deciTable:function(){
		var ths = [];
		for(var i = 0; i < ifThens.length; i++){
			for(var j = 0; j < ifThens[i].length; j++){
				for(var m = 0; m < tfThens[i]._if.length; m++){
					var _if = tfThens[i]._if;
					for(var n = 0; n < _if.length; n++){
						if(_if[n].type=='input'){
							ths.push(_if[n].value);
						}
					}
				}
				for(var m = 0; m < tfThens[i]._else.length; m++){
					var _else = tfThens[i]._else;
					for(var n = 0; n < _else.length; n++){
						if(_else[n].type=='input'){
							ths.push(_else[n].value);
						}
					}
				}
			}
		}
	}.property('ifThens._if.@each')
});
*/
//
App.ItermListView = SC.View.extend({
  click: function() {
    var content = this.get('content');
    var bomContent = this.getPath('bomView.content');
    bomContent.setValue(content.getValue());
  },

  touchEnd: function() {
    this.click();
  }
});
App.BomListView = SC.View.extend({
  click: function() {
    var content = this.get('content');
    var bomContent = this.getPath('bomView.content');
    bomContent.setId(content.getId());
    bomContent.setName(content.getName());
    bomContent.setValue('');
    bomContent.setType(content.getType());
  },

  touchEnd: function() {
    this.click();
  }
});


////////////////////////////////////////
App.EditField = SC.View.extend({
  tagName: 'span',
  templateName: 'edit-field',

  doubleClick: function() {
    this.set('isEditing', true);
    return false;
  },

  touchEnd: function() {
    // Rudimentary double tap support, could be improved
    var touchTime = new Date();
    if (this._lastTouchTime && touchTime - this._lastTouchTime < 250) {
      this.doubleClick();
      this._lastTouchTime = null;
    } else {
      this._lastTouchTime = touchTime;
    }

    // Prevent zooming
    return false;
  },

  focusOut: function() {
    this.set('isEditing', false);
  },

  keyUp: function(evt) {
    if (evt.keyCode === 13) {
      this.set('isEditing', false);
    }
  }
});

App.TextField = SC.TextField.extend({
  didInsertElement: function() {
    this.$().focus();
  }
});
App.ItemView = SC.View.extend({});
App.BomView = SC.View.extend({
  templateName: 'bom',
  showBoms:false,
  showItems:false,
  showOpers:false,
  clickBom: function() {
    this.set('showBoms', !this.get('showBoms'));
    return false;
  },
  clickItem: function() {
    this.set('showItems', !this.get('showItems'));
    return false;
  },
  clickOper: function() {
    this.set('showOpers', !this.get('showOpers'));
    return false;
  },
  selectBom: function(){
  	var id = event.view.get("id");
  	var name = event.view.get("name");
  	var type = event.view.get("type");
  	if(id == 'addP'){
  		this.setRightP(this.get('leftP') + '(');
  	}else if(id == 'delP'){
  		var p = this.get('leftP');
  		if(p.length > 0) {
  			p = p.substring(1);
  		}
  		this.setRightP(p);
  	} else{
  		this.setId(id);
			this.setName(name);
			this.setType(type);
			this.setItemId('');
			this.setItemName('');
  	}
  	this.set('showBoms', false);
  },
  selectItem: function(){
  	var id = event.view.get("id");
  	var name = event.view.get("name");
  	if(id == 'addP'){
  		this.setRightP(this.get('rightP') + ')');
  	}else if(id == 'delP'){
  		var p = this.get('rightP');
  		if(p.length > 0) {
  			p = p.substring(1);
  		}
  		this.setRightP(p);
  	}else{
  		this.setItemName(name);
	  	this.setItemId(id);
  	}
  	this.set('showItems', false);
  },
  selectOper: function(){
  	var id = event.view.get("id");
  	var name = event.view.get("name");
  	if(id == 'o1'){
  		this.setOper('+');
  	}else if(id == 'o2'){
  		this.setOper('-');
  	}else if(id == 'o3'){
  		this.setOper('*');
  	}else if(id == 'o4'){
  		this.setOper('/');
  	}else if(id == 'o5'){
  		this.setOper('=');
  	}else if(id == 'o6'){
  		this.setOper('');
  	}
  	this.set('showOpers', false);
  }
});

SC.Handlebars.registerHelper('editable', function(path, options) {
  options.hash.valueBinding = path;
  return SC.Handlebars.helpers.view.call(this, App.EditField, options);
});
SC.Handlebars.registerHelper('bom', function(options) {
	alert(4);
  //options.hash.valueBinding = path;
  return SC.Handlebars.helpers.view.call(this, App.BomView, options);
});
Handlebars.registerHelper('highlight', function(property) {
  //var value = Ember.getPath(this, property);
  return new Handlebars.SafeString('<span class="highlight">'+property+'</span>');
});
SC.Handlebars.registerHelper('button', function(options) {
  var hash = options.hash;
  if (!hash.target) {
    //hash.target = "App.contactsController";
  }
  //hash.abc='111';
  return SC.Handlebars.helpers.view.call(this, SC.Button, options);
});
