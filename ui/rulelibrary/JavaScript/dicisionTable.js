var needD = true;
var length = 2;
var fm = Ext.form;
var sm = new Ext.grid.CheckboxSelectionModel();
var rowId = new Ext.grid.RowNumberer();
var strJson = [ rowId, sm ];
var dataId = new Array();
var data = [ [], [], [], [], [], [], [], [], [], [] ];
var cm = null;
var grid = null;
var ds = null;
var rowDisable=false;
/*var dataType = new Array();

var modDisType = new Array();*/

function displayDicTable(destination,jsonData) {
	// 隐藏相关按钮
	length = 2;
	strJson = [ rowId, sm ];
	needD = true;
	dataId.length=0;
	getBaseBomItems();
//ColumnDataTypeArray 存放的是参数的数据类型
//
	var width=40;
//alert('ColumnHeadArray.length:'+ColumnHeadArray.length);
//alert(ColumnHeadArray);
	for ( var i = 0; i < ColumnHeadArray.length; i++) {
		var newJson = null;
		width+=200;
		//alert("ColumnDataTypeArray[i]--"+i+"--"+ColumnDataTypeArray[i]);
		if (ColumnDataTypeArray[i]== "String") {
		
			var editor;
			//alert("BaseBOMItemSourceArray[i]--"+i+"--"+BaseBOMItemSourceArray[i]);
	//		if(BaseBOMItemSourceArray[i]!="")//BaseBOMItemSourceArray[]来自于makelogical.js的getBaseBomItems()函数 
	//		{
	//		  alert("不为空");
	//			var store = new Ext.data.JsonStore({
	//	            fields: ['code', 'name'],
	//	            root: "rows",
	//	            url   : "getComboxData.jsp?sql="+BaseBOMItemSourceArray[i]
	//	           });
	//	      alert("ColumnMultipleArray[i]--"+i+"--"+ColumnMultipleArray[i]);
	//			if(!ColumnMultipleArray[i])
	//			{
	//				editor= new Ext.form.ComboBox({
	//			    	  store: store,
	//			    	  width:100,
	//			    	  valueField : "name",
	//			    	  displayField:'name',
	//			     	  typeAhead: true,
	//			     	  mode: 'remote',
	//			          lazyInit: true,
	//			         // forceSelection: true,//如果输入了非侯选值，输入框会被清空
	//			         forceSelection: false,
	//			         // triggerAction: 'all',
	//			         triggerAction: '',
	//			          emptyText:'',
	//			          listClass: 'x-combo-list-small'
	//			       });
	//			}
	//			else
	//			{
	//				editor= new Ext.form.MultiComboBox({
	//					width : 200,
	//					store : store,
	//					valueField : "name",
	//					displayField : "name",
	//					labelSeparator : '：',
	//					displaySeparator : ';',
	//					valueSeparator : ';',
	//					maxHeight : 100,
	//					mode : 'remote',
	//					value : '1,2',
	//					//forceSelection : true,
	//					forceSelection: false,
	//					hiddenName : 'test',
	//					editable : true,
	//					//triggerAction : 'all',
	//					triggerAction: '',
	//					//allowBlank : false //jiahy
	//					allowBlank : true
	//				});
	//			}
	//		}
	//		else 
	//		{
         //alert("为空");
				editor=new fm.TextField({
					   blankText:"",
					   allowBlank:false
				   });
	//		}
			newJson = {
				//alert("ColumnHeadArray[i]--"+i+"--"+ColumnHeadArray[i]);
			//	alert("TableColumnNameArray[i]--"+i+"--"+TableColumnNameArray[i]);
				header :ColumnHeadArray[i],
				dataIndex :TableColumnNameArray[i],
				width :200,
				align :'center',
				editor :editor
			};
		} else if (ColumnDataTypeArray[i]== "Date") {
			newJson = {
				header :ColumnHeadArray[i],
				dataIndex :TableColumnNameArray[i],
				width :200,
				align :'center',
				renderer :Ext.util.Format.dateRenderer('Y-m-d H:i:s'),
				editor :new fm.DateField( {
					format :'Y-m-d H:i:s'
				})
			};
		} else if (ColumnDataTypeArray[i] == "Number" || ColumnDataTypeArray[i]== "INT") {
			newJson = {
				header :ColumnHeadArray[i],
				dataIndex :TableColumnNameArray[i],
				width :200,
				allowDecimals :false,
				align :'center',
				editor :new fm.NumberField( {
					allowBlank :true,
					allowNegative :true,
					style :'text-align:left'
				})
			};
		}
		strJson[strJson.length] = newJson;
		dataId[i] = {
			name :TableColumnNameArray[i]
		};
	}
	cm = new Ext.grid.ColumnModel(strJson);

	var Plant = Ext.data.Record.create(dataId);
	if(destination=="init")
	{
		var resultReader = new Ext.data.JsonReader({
		                                        totalProperty: "totalProperty",
		                                        root: "rows",
		                                        id  : "id"
		                                    }, Plant);
	   
		   ds = new Ext.data.Store({
			    reader: resultReader,
		        proxy:  new Ext.data.MemoryProxy(jsonData)
		    });
	}
	else
	{
		ds=new Ext.data.Store( {
			proxy :new Ext.data.MemoryProxy(data),
			reader :new Ext.data.ArrayReader( {}, dataId)
		});
	}
	
	grid = new Ext.grid.EditorGridPanel( {
		ds :ds,
		cm :cm,
		sm :sm,
		autoHeight :true,
		autoScroll :true,
		stripeRows :true,
		width :width,
		clicksToEdit:1,
		tbar : [ {
			text :I18NMsg("M0000072368"),
			handler : function()
		{
			if(rowDisable)
			{
				return;
			}
			var recordId={};
			
			var p = new Plant(recordId);
			
			for(var j=0;j<TableColumnNameArray.length;j++)
			{
				p.set(TableColumnNameArray[j],"");
			}
			grid.stopEditing();
			ds.insert(0, p);
			grid.reconfigure(ds, cm);
			grid.startEditing(0, 2);
		}
		}, {
			text :I18NMsg("M0000072369"),
			handler : function() {
			if(rowDisable)
			{
				return;
			}
			    if(!confirm(I18NMsg("M0000072370")))
			    {
			    	return ;
			    }
				grid.stopEditing();
				var selctions = sm.getSelections();
				for ( var i = 0; i < selctions.length; i++) {
					ds.remove(selctions[i]);
				}
				grid.reconfigure(ds, cm);
			}
		} ],
		 bbar: new Ext.PagingToolbar({
		        pageSize: 10,
		        store: ds,
		        displayInfo: true,
		        displayMsg: I18NMsg("M0000072371"),
		        emptyMsg: I18NMsg("M0000072372")
		    })

	});
	ds.load();
	sm.addListener("rowselect", RowToLogic);
	grid.addListener("afteredit", CellToLogic);
	grid.addListener("beforeedit", InitLogic);

	var gridNode = document.getElementById('grid-example');
	while (gridNode.firstChild)
		gridNode.removeChild(gridNode.firstChild);

	grid.render('grid-example');
    checkNodesState(flag);
    if(flag==0)
    {
    	disableEditable();
    }
	
}

function disableEditable()
{
	try{
		for(var i=2;i<cm.getColumnCount();i++)
		{
		    cm.setEditable(i,false);
		}
	}catch(e)
	{
        alert(I18NMsg("M0000072373"))
		}
	

	}


function checkNodesState(flag)
{
   switch(flag)
   {
   case 0:
   {
	   disableInputNodes();
	   disableSpanNodes();
	   hideButtons();
	   break;
   }
   case 1:
   {

	   disableSpanNodes();
	   enableInputNodes();
	   hideButtons();
	   break;
   }
   case 2:
   {
	   enableSpanNodes();
	   disableInputNodes();
	   showButtons();
	   break;
   }
   case 4:
   {
	   disableSpanNodes();
	   enableInputNodes();
	   hideButtons();
	   break;
   }
   }
}
function prepareStore(destination)
{
	var reStore =null;
	if(destination=="init")
	{
		reStore= new Ext.data.Store( {
			proxy :new Ext.data.MemoryProxy(data),
			reader :new Ext.data.ArrayReader( {}, dataId)
		});
		
	}else
	{
		reStore= new Ext.data.Store( {
			proxy :new Ext.data.MemoryProxy(data),
			reader :new Ext.data.ArrayReader( {}, dataId)
		});
		
	}
	
}

function getSelectedDatas() {
	var dataArray = sm.getSelections();
	var reData = new Array();
	if (dataArray.length > 1) {
		alert(I18NMsg("M0000072374"));
	} else if (dataArray.length == 0) {
		alert(I18NMsg("M0000072375"));

	} else {
		for ( var i = 0; i < dataId.length; i++) {
			var tmp = dataArray[0].get(dataId[i].name);
			if (dataType[i] == 'Date') {
				var dt = new Date(tmp);
				reData[i] = dt.format('Y-m-d H:i:s');
			} else {
				reData[i] = tmp;
			}
		}

	}
	return reData;
}

function getData() {
	getBaseBomItems();
	var data = new Array();
	if (needD) {
		var store = grid.getStore();
		var record = null;
		var message = '';
		for ( var i = 0, length = store.getCount(); i < length; i++) {
			
			var da = new Array();
			record = store.getAt(i);
			var Integrity = true;
			var rowNull = true;
			for (j = 0, len = dataId.length; j < len; j++) {
				var dad = record.get(dataId[j].name);
				 if(j==len-1)
				 {
					 if(Integrity)
					 {
						 da[j]=dad;//.substring(0,dad.indexOf("-"));
						 data[data.length] = da;
					 }
					 
				 }
				 else
				 {
					 var notNull=false;
					 if(dad!=undefined&&dad!=null)
					 {
						 var val=new String(dad);
						 if(val!="")
						 {
							 notNull=true;
						 }
					 }
					 
					 if (notNull) {						 
							if (BaseColumnArray[j]) {//来自于makelogical.js getBaseBomItems()
								var disData = new Array();
								disData=dad.split(";");
								if(ColumnMultipleArray[j])
								{
									da[j]=";";
								}
								else
								{
									da[j]="";
								}
								for ( var k = 0; k < disData.length; k++) {
									var obStr=disData[k]
									var index=obStr.indexOf("-");
											da[j] +=  obStr.substring(0,index);
											if(ColumnMultipleArray[j])
											{
												da[j] +=";" ;
											}
								}
							} else {
								if (ColumnDataTypeArray[j] == 'Date') {
									var dt = new Date(dad);
									da[j] = dt.format('Y-m-d H:i:s');
								} else {
									da[j] = dad;
								}
							}
							rowNull = false;
						} else {
								Integrity = false;
						}
				 }
			 }
			if (Integrity) {
				
			} else if (!rowNull) {
				message += I18NMsg("M0000072376") + eval(i + 1) + I18NMsg("M0000072377");
			}//M0000072376:\n行    的数据 不完整！
		  }
		if (!!message) {
			var discision = confirm(message + I18NMsg("M0000072378"));//\n如果提交将丢失以上数据
			if (!discision) {
				return false;
			}
		}
		if (data.length == 0) {
			alert(I18NMsg("M0000072379"));//您在决策表中还没有输入数据,请继续完成!
			return false;
		}
		return data;
  }else
  {
	  alert(I18NMsg("M0000072380"));//请先生成决策表！
	  return false;
  }
	alert("----over need()------");
}

function dataArrayToJson(dataArray)
{
   	var rowCount=dataArray.length;
   	var columnCount=dataArray[0].length;
   	
   	var json=[];
   	
   	for(var i=0;i<rowCount;i++)
   	{
   		json[i]={};
   		for(var j=0;j<columnCount;j++)
   		{
   			json[i][TableColumnNameArray[j]]=dataArray[i][j];
   		}
   	}
   	return json;
}

