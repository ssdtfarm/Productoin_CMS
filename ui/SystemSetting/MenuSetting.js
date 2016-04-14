Ext.BLANK_IMAGE_URL = 'images/public/s.gif"';
Ext.QuickTips.init();// 加载快速提示框
Ext.namespace('ExtApp.tree');
ExtApp.tree.advancedTree01 = function(){

};


Ext.extend(ExtApp.tree.advancedTree01,Ext.util.Observable,{

  //树形的右键菜单

  treeRightMenu: new Ext.menu.Menu({
    id: 'theContextMenu',
    height :600,
    width :160,
    items:[{
        id:'addNode',
        text:'新建',iconCls: 'icon-new ',
        menu:[
          {
            id:'insertNode',
            text:'新建同级菜单',iconCls: 'icon-add '
          },
          {
            id:'appendNode',
            text:'新建子菜单',iconCls: 'icon-add '
          }
        ]
      },{
        id:'delNode',
        text:'删除',iconCls: 'icon-del'
      },{
        id:'modifNode',
        text:'修改',iconCls: 'icon-edit'
      },{
        id:'veiwNode',
        text:'查看',iconCls: 'icon-search'
      },'-',
      {id:'reload',text:'刷新菜单',iconCls: 'icon-refresh',
         handler: function(){
           var tree = Ext.getCmp('menumanagetree');
             tree.root.reload();
          }
        },
      {id:'expand',text:'展开',iconCls: 'icon-expand-all',
         handler: function(){
           var tree = Ext.getCmp('menumanagetree');
           var selectedNode = tree.getSelectionModel().getSelectedNode();
             selectedNode.expand(true,true);
             //tree.root.reload();
          }},
      {id:'collapse',text:'收起',iconCls: 'icon-collapse-all',
         handler: function(){
           var tree = Ext.getCmp('menumanagetree');
           var selectedNode = tree.getSelectionModel().getSelectedNode();
             selectedNode.collapse(true,true);
          }}]
  }),

  //树形面板
  tree:new Ext.tree.TreePanel({
    title : '菜单管理',
    id:'menumanagetree',
    region:'west',
        iconCls : 'icon-nav',
    autoScroll:true,
    rootVisible : false,// 是否显示跟节点
    containerScroll:true,
      border:false,
      bodyBorder:false,
        split : true,
        width : 180,
        //maskDisabled:false,
        minSize : 175,
        maxSize : 300,
        rootVisible : false,// 是否显示跟节点
        collapsible : true,//收起菜单树

      loader:new Ext.tree.TreeLoader({
        dataUrl:'menuaction.jsp?action=selectall'
    }),
        tools : [{
                   id : 'refresh',
                   handler : function() {
                   var tree = Ext.getCmp('menumanagetree');
                   tree.body.mask('菜单加载中……', 'x-mask-loading');//给tree的body加上蒙版
                   tree.root.reload();
                   setTimeout(function() {
                   tree.body.unmask();
                  },500);
               }
                //tree.body.unmask();//全部展开之后让蒙版消失
            }],
         tbar :  new Ext.Toolbar({
            cls:'top-toolbar',
            items:[ ' ',
        new Ext.form.TextField({
        width: 140,
        emptyText:'查找菜单',
        listeners:{
          render: function(f){

                  var api = Ext.getCmp('menumanagetree');
                  var filter = new Ext.tree.TreeFilter(api, {
                    clearBlank: true,
                    autoClear: true
                  });

            var hiddenPkgs = [];
            f.el.on('keydown', function(e)
            {

                  var text = e.target.value;
                  //alert(text);
                  Ext.each(hiddenPkgs, function(n){
                    n.ui.show();
                  });
                  if(!text){
                    filter.clear();
                    return;
                  }
                  api.expandAll();

                  var re = new RegExp('^' + Ext.escapeRe(text), 'i');
                  //alert(re);
                  filter.filterBy(function(n){
                    //if(re.test(n.text))
                    //{
                      //alert(n.text)
                      //}
                    //return !n.isLeaf() || (n.text.indexOf(text)>-1);只要包含过滤的字符就显示
                    return !n.isLeaf() || re.test(n.text);//以过滤开始的现实
                  });

                  // hide empty packages that weren't filtered
                  hiddenPkgs = [];
                  api.root.cascade(function(n){
                    if(!n.isLeaf() && n.ui.ctNode.offsetHeight < 3){
                      n.ui.hide();
                      hiddenPkgs.push(n);
                    }
                  });
            }, f, {buffer: 350});
          }
        }

      }), '-',
      {
          iconCls: 'icon-expand-all',
               tooltip: '展开菜单',//Expand All
                handler: function(){
                  var tree = Ext.getCmp('menumanagetree');
                  tree.root.expand(true);
                  }
            }, '-', {
                iconCls: 'icon-collapse-all',
                tooltip: '收起菜单',//Collapse All
                handler: function(){
                  var tree = Ext.getCmp('menumanagetree');
                  tree.root.collapse(true);
                  }
            },'->', {
                iconCls: 'icon-config',
                tooltip: '重新设置',//Collapse All
                handler: function(){
                  Ext.Msg.confirm('操作提示', '您确定要重新进行排序吗?', function(btn) {
            if ('yes' == btn) {
            var tree = Ext.getCmp('menumanagetree');
              Ext.Ajax.request({
                url : 'menuaction.jsp?action=resort',
                success : function() {
                  Ext.Msg.show({
                    title : '操作提示',
                    msg : '处理成功！',
                    icon : Ext.Msg.INFO,
                    buttons : Ext.Msg.OK
                  });
                  tree.root.reload();
                },
                failure : function() {
                  Ext.Msg.show({
                    title : '错误提示',
                    msg : '重新排序失败!',
                    icon : Ext.Msg.ERROR,
                    buttons : Ext.Msg.OK
                  });
                }
              });
            }
          });
//                  parent.fraInterface.window.location="menuaction.jsp?action=resort";
//                  parent.fraInterface.window.location="menu.jsp";
                }
            }
            //,'-', {
            //    iconCls: 'icon-help',
            //    tooltip: '文档帮助',//Collapse All
            //    handler: function(){
                      //var winhelp = this.winhelp;//得到弹出窗口组建
                      //winhelp.show();
            //      }
            //}
            ]
        }),
    enableDD:true//是否支持拖拽效果

  }),
  //根节点
  root : new Ext.tree.AsyncTreeNode({
    text:'菜单列表',
    draggable:false,//是否可以拖拽
    NodeCode:'0',
    id:'0'
  }),

  //树形编辑器
  //treeEditer : new Ext.tree.TreeEditor(
    //Ext.getCmp('menumanagetree'),//将tree组建的实例放入
    //{
    //  id:'tree-advancedTree01-treeEditor',
    //  allowBlank: false//输入的值不可以为空
    //}
//  ),


  //弹出窗口
  win: new Ext.Window({//创建弹出岗位的window容器
    maskDisabled:false,
    id:'tree-advancedTree01-win',
    modal : true,//是否为模式窗口
    constrain:true,//窗口只能在viewport指定的范围
    closable:true,//窗口是否可以关闭
    closeAction:'hide',
    //autoDestroy:true,
    layout:'fit',
    width:360,
    height:150,
    plain:true,
    items:[
      {
        id:'tree-advancedTree01-win-view',
        border:false
      }
    ]
  }),

 window_add_modify: new Ext.Window({
  title : '添加菜单',
  width : 400,
  id:'window_add_modify',
  height : 500,
  resizable : false,
  autoHeight : true,
  modal : true,
  closeAction : 'hide',
  listeners : {
    'hide' : function() {
      this.setTitle('添加菜单');
      this.findById('menu.name').ownerCt.form.reset();
    }
  },
  items : [new Ext.FormPanel({
    id:'addform',
    labelWidth : 70,
    labelAlign : 'right',
    border : false,
    baseCls : 'x-plain',
    bodyStyle : 'padding:5px 5px 0',
    anchor : '100%',
    defaults : {
      width : 260,
      msgTarget : 'side' // 验证信息显示右边
    },
    defaultType : 'textfield',
    items : [{
      fieldLabel : '菜单名称',
      id : 'menu.name',
      name : 'menu.name',
      allowBlank : false,
      maxLength : 50
    },{
      fieldLabel : '父节点名称',
      id : 'menu.parentname',
      name : 'menu.parentname',
      allowBlank : false,
      maxLength : 50
    }, {
      fieldLabel : 'URL',
      name : 'menu.url',
      maxLength : 70
    }, {
      fieldLabel : '功能描述',
      xtype:'textarea',
      name : 'menu.des',
      maxLength : 100
    },{
      //fieldLabel : '父节点ID',
      xtype:'hidden',
      name : 'menu.parentID'
      //hidden : true,
      //hideLabel:true,
      //maxLength : 20
    },{
      //fieldLabel : '选中的ID',
      name : 'menu.selectedID',
      xtype:'hidden'
      //hidden : true,
      //hideLabel:true,
      //maxLength : 20
    },{
      fieldLabel : '操作标识',
      name : 'menu.action',//0:修改;1:添加同级菜单;2:添加子菜单
      hidden : true,
      hideLabel:true,
      maxLength : 20
    }],
    buttonAlign : 'center',
    minButtonWidth : 60,
    buttons : [{
      text : '提交',
      handler : function(btn) {
        var frm = this.ownerCt.form;
        if (frm.isValid()) {
          var tree=Ext.getCmp('menumanagetree');

          var parentnode = tree.getNodeById(frm.findField('menu.parentID').getValue());
          var selectedIDnode = tree.getNodeById(frm.findField('menu.selectedID').getValue());
          var nodename=frm.findField("menu.name").getValue();
          var des=frm.findField('menu.des').getValue();
          var link=frm.findField('menu.url').getValue();
         // alert(frm.url);

          if(frm.findField('menu.action').getValue()=="1")//同级增加
          {
            //alert(frm.findField("menu.name").getValue());
              //frm.url="menuaction.jsp?action=insertmenu";

//start
                       Ext.MessageBox.show({
                           msg:"数据保存中,请等待...",
                           progress:true,
                           progressText: '保存中...',
                           width:300,
                           wait:true,
                           waitConfig:{
                                 interval:100,
                                 duration:1000,
                                 fn:function(){
                                      Ext.Ajax.request({
                                      url : 'menuaction.jsp?action=insertmenu',
                                      params : {
                                        parentnode : parentnode.attributes.NodeCode,
                                        selectedIDnode : selectedIDnode.attributes.NodeCode,
                                        nodename:encodeURI(Ext.util.JSON.encode(nodename)),
                                        des:encodeURI(Ext.util.JSON.encode(des)),
                                        link:link
                                      },
                                        success : function(a) {
                                            tree.root.reload();

                                            Ext.Msg.show({
                                            title : '信息提示',
                                            msg : a.responseText,
                                            buttons : Ext.Msg.OK,
                                            icon : Ext.Msg.INFO
                                          });
                                        },
                                        failure : function(aa) {
                                          Ext.Msg.show({
                                            title : '错误提示',
                                            msg : '删除失败，与服务器交互失败!',
                                            buttons : Ext.Msg.OK,
                                            fn : function() {
                                              btn.enable();
                                            },
                                            icon : Ext.Msg.ERROR
                                          });
                                        }
                                      });

                                     Ext.MessageBox.hide();
                           }},
                           closable:true
                       });

//end

          }
          else if(frm.findField('menu.action').getValue()=="2")
          {

//start
                       Ext.MessageBox.show({
                           msg:"数据保存中,请等待...",
                           progress:true,
                           progressText: '保存中...',
                           width:300,
                           wait:true,
                           waitConfig:{
                                 interval:100,
                                 duration:1000,
                                 fn:function(){
                                      Ext.Ajax.request({
                                        url : 'menuaction.jsp?action=insertmenu',
                                        params : {
                                          parentnode : selectedIDnode.attributes.NodeCode,
                                          selectedIDnode : selectedIDnode.attributes.NodeCode,
                                          nodename:encodeURI(Ext.util.JSON.encode(nodename)),
                                          des:encodeURI(Ext.util.JSON.encode(des)),
                                          link:link
                                        },
                                        success : function(a) {
                                            tree.root.reload();

                                            Ext.Msg.show({
                                            title : '信息提示',
                                            msg : a.responseText,
                                            buttons : Ext.Msg.OK,
                                            icon : Ext.Msg.INFO
                                          });
                                        },
                                        failure : function(aa) {
                                          Ext.Msg.show({
                                            title : '错误提示',
                                            msg : '删除失败，与服务器交互失败!',
                                            buttons : Ext.Msg.OK,
                                            fn : function() {
                                            },
                                            icon : Ext.Msg.ERROR
                                          });
                                        }
                                      });

                                     Ext.MessageBox.hide();
                           }},
                           closable:true
                       });

//end
              //tree.getSelectionModel().select(newNode);
          }
          else//修改
          {
            var nodename=frm.findField('menu.name').getValue();
            var urllink=frm.findField('menu.url').getValue();
            var desc=frm.findField('menu.des').getValue();
            var nodeid=selectedIDnode.attributes.NodeCode;

      //start
               Ext.Msg.confirm("提示框","您确认要提交对菜单的修改吗?",function(button){
                   if (button == "yes")
                   {
                       Ext.MessageBox.show({
                           msg:"数据提交中,请等待...",
                           progress:true,
                           progressText: '提交中...',
                           width:300,
                           wait:true,
                           waitConfig:{
                                 interval:100,
                                 duration:1000,
                                 fn:function(){
                                      Ext.Ajax.request({
                                        url : 'menuaction.jsp?action=modifymenu',
                                        params : {
                                          selectedIDnode : nodeid,
                                          nodename:encodeURI(Ext.util.JSON.encode(nodename)),
                                          des:encodeURI(Ext.util.JSON.encode(desc)),
                                          link:urllink
                                        },
                                        success : function(a) {
                                            tree.root.reload();

                                            Ext.Msg.show({
                                            title : '信息提示',
                                            msg : a.responseText,
                                            buttons : Ext.Msg.OK,
                                            icon : Ext.Msg.INFO
                                          });
                                        },
                                        failure : function(aa) {
                                          Ext.Msg.show({
                                            title : '错误提示',
                                            msg : '删除失败，与服务器交互失败!',
                                            buttons : Ext.Msg.OK,
                                            fn : function() {
                                            },
                                            icon : Ext.Msg.ERROR
                                          });
                                        }
                                      });

                                     Ext.MessageBox.hide();
                           }},
                           closable:true
                       });
                   }//ee
               });
      //end


          };
          this.ownerCt.form.reset();
          this.ownerCt.ownerCt.hide();
        }
      }
    }, {
      text : '重置',
      handler : function() {
        this.ownerCt.form.reset();
      }
    }, {
      text : '取消',
      handler : function() {
        this.ownerCt.ownerCt.hide();
      }
    }]
  })]
}),


  init:function(){

     var topInfoPanel = new Ext.Panel({
      region:'north',
      height:100,
      split:true,
      border:false,
      minSize:2,
      maxSize:200,
      autoScroll:true,
      containerScroll:true,
      collapseMode:'mini',//在分割线处出现按钮
      contentEl:'tree-advancedTree01-info'
    });
    //本例的主角，TreePanel-----------------------------------

    this.tree.setRootNode(this.root);
    //this.root.expand(true,false);

      this.root.expand();
    //给tree添加事件
    this.tree.on('contextmenu',this.treeRightKeyAction,this);

    //****开始绑定右键菜单事件*************
    Ext.getCmp('insertNode').on('click',this.insertNodeAction,this);
    Ext.getCmp('appendNode').on('click',this.appendNodeAction,this);
    Ext.getCmp('delNode').on('click',this.delNodeAction,this);
    Ext.getCmp('modifNode').on('click',this.modifNodeAction,this);
    Ext.getCmp('veiwNode').on('click',this.veiwNodeAction,this);
    Ext.getCmp('menumanagetree').on('nodedrop',this.treeNodeDrop,this);

    //--开始组装面板-----------------------------------------------------------
    var centerMainPanel = new Ext.Panel({
      region:'center',
      layout:'fit',
      contentEl:'tree-advancedTree01-center',
      border:false,
      bodyBorder:false,
      height:540,
      items:[this.tree]
    });

    //创建例子的整体面板
    var mainPanel = new Ext.Panel({
      renderTo:'tree-advancedTree01-main',
      id:'tree-advancedTree01-mainPanel',
      layout:'border',
      border:false,
      bodyBorder:false,
      height:540,
      items:[topInfoPanel,centerMainPanel]
    });

  },


  //-----------------模块销毁函数---------------------------
  destroy:function(){
    this.win.destroy();//将win窗口销毁，否则在IE中会报错
  },


  //右键弹出菜单事件
  treeRightKeyAction:function(node,e){
    e.preventDefault();
    node.select();
    this.treeRightMenu.showAt(e.getXY());
  },

  //添加兄弟节点事件实现
  insertNodeAction:function(){

    var tree = this.tree;
    var selectedNode = tree.getSelectionModel().getSelectedNode();
    var selectedParentNode = selectedNode.parentNode;

    this.window_add_modify.show();
    this.window_add_modify.setTitle("给菜单【"+selectedNode.text+"】添加同级菜单");
    var frm = Ext.getCmp('addform').form;


    frm.findField('menu.parentname').setValue(selectedParentNode.text);
    frm.findField('menu.parentname').disable();
    frm.findField('menu.parentID').setValue(selectedParentNode.id);
    frm.findField('menu.selectedID').setValue(selectedNode.id);
    frm.findField('menu.action').setValue("1");//操作标识

  },
  //添加孩子节点事件实现
  appendNodeAction:function(){
    var tree = this.tree;//得到树形面板
    var selectedNode = tree.getSelectionModel().getSelectedNode();
    if(selectedNode.isLeaf()){
      selectedNode.leaf = false;
    }


    var tree = this.tree;
    var selectedNode = tree.getSelectionModel().getSelectedNode();

    this.window_add_modify.show();
    this.window_add_modify.setTitle("给菜单【"+selectedNode.text+"】添加子菜单");
    var frm = Ext.getCmp('addform').form;


    frm.findField('menu.parentname').setValue(selectedNode.text);
    frm.findField('menu.parentname').disable();
    frm.findField('menu.parentID').setValue(selectedNode.id);
    frm.findField('menu.selectedID').setValue(selectedNode.id);

    frm.findField('menu.action').setValue("2");//操作标识
  },
  //删除节点事件实现
  delNodeAction:function(){
    var tree = this.tree;//得到树形面板
    var selectedNode = tree.getSelectionModel().getSelectedNode();//得到选中的节点
    var parentNode =selectedNode.parentNode;
    var parentNodeid=parentNode.id;
    //alert(selectedNode.id);
    if(!selectedNode.attributes.leaf)
    {
            Ext.Msg.show({
              title : '不允许删除',
              msg : '菜单[' + selectedNode.text + '] ' + '下有子菜单，不允许删除！',
              buttons : Ext.Msg.OK,
              fn : function() {
              },
              icon : Ext.Msg.ERROR
            });
    }
    else  //叶子菜单
    {
      //start
               Ext.Msg.confirm("提示框","你确认删除所选菜单["+selectedNode.text+"]吗?",function(button){
                   if (button == "yes")
                   {
                       Ext.MessageBox.show({
                           msg:"删除中,请等待...",
                           progress:true,
                           progressText: '删除中...',
                           width:300,
                           wait:true,
                           waitConfig:{
                                 interval:100,
                                 duration:1000,
                                 fn:function(){
                                      Ext.Ajax.request({
                                        url : 'menuaction.jsp?action=deletenode',
                                        params : {
                                          parentnode : parentNode.attributes.NodeCode,
                                          selectedIDnode : selectedNode.attributes.NodeCode
                                        },
                                        success : function(a) {
                                            //tree.root.reload();
                                            tree.root.reload();

                                            prNode.expand(true,true);
                                            Ext.Msg.show({
                                            title : '信息提示',
                                            msg : a.responseText,
                                            buttons : Ext.Msg.OK,
                                            icon : Ext.Msg.INFO
                                          });
                                        },
                                        failure : function(aa) {
                                          Ext.Msg.show({
                                            title : '错误提示',
                                            msg : '删除失败，与服务器交互失败!',
                                            buttons : Ext.Msg.OK,
                                            fn : function() {
                                              btn.enable();
                                            },
                                            icon : Ext.Msg.ERROR
                                          });
                                        }
                                      });

                                     Ext.MessageBox.hide();
                           }},
                           closable:true
                       });
                   }//ee
               });
      //end

    }

  },
  //修改节点事件实现
  modifNodeAction:function(){
    var tree = this.tree;
    var selectedNode = tree.getSelectionModel().getSelectedNode();
    var selectedParentNode = selectedNode.parentNode;
    this.window_add_modify.show();

    this.window_add_modify.setTitle("修改菜单【"+selectedNode.text+"】");

    var frm = Ext.getCmp('addform').form;
    frm.findField('menu.parentname').setValue(selectedParentNode.text);
    frm.findField('menu.parentname').disable();
    frm.findField('menu.parentID').setValue(selectedParentNode.id);
    frm.findField('menu.selectedID').setValue(selectedNode.id);
    frm.findField('menu.name').setValue(selectedNode.text);
    frm.findField('menu.url').setValue(selectedNode.attributes.link);
     frm.findField('menu.des').setValue(selectedNode.attributes.des);
    frm.findField('menu.action').setValue("0");//操作标识

  },
  //查看事件实现
  veiwNodeAction:function(){
    var tree = this.tree;//得到树形面板
    var win = this.win;//得到弹出窗口组建
    var viewPanel = Ext.getCmp('tree-advancedTree01-win-view');
    var selectedNode = tree.getSelectionModel().getSelectedNode();//得到选中的节点
    var tmpid = selectedNode.attributes.NodeCode;
    var tmpname = selectedNode.attributes.text;
    var tmpdes = selectedNode.attributes.des;
    var URLlike= selectedNode.attributes.link;

    win.setTitle(tmpname+'的介绍');
    win.show();

    var dataObj = {
      id: tmpid,
      name: tmpname,
      link:URLlike,
      des:tmpdes
    }
    var tmpTpl = new Ext.Template([
      '<div style="margin:10px"><div style="margin:10px">菜单节点编号:{id}</div>',
      '<div style="margin:10px">菜单节点名称:{name}</div>',
      '<div style="margin:10px">菜单文件路径:{link}</div>',
      '<div style="margin:10px">菜单描述:{des}</div></div>'
    ]);
    tmpTpl.overwrite(viewPanel.body, dataObj);
  },

  treeNodeDrop:function(e){
    var curTree = e.tree;//得到当前的tree
    var tmpDropNode = e.dropNode;
    var tmpDropedNode = e.target;
    var dropType = e.point;

    //var parentNodeID =selectedNode.parentNode;
   //alert(dropType);
   //alert(tmpDropedNode.text);
    Ext.Ajax.request({
      url:'menuaction.jsp?action=nodeDD',
      method:'post',
      params:{begin:tmpDropNode.attributes.NodeCode,end:tmpDropedNode.attributes.NodeCode,type:dropType},
      success: function(response, option) {
	  	  var result = response.responseText;
          curTree.root.reload();
          Ext.Msg.show({
          title : '信息提示',
          msg : result,
          buttons : Ext.Msg.OK,
          icon : Ext.Msg.INFO
         });
      },
      failure: function(response, option) {
	      Ext.Msg.show({
	      title : '发生错误',
	      msg : '异步通讯失败,请与管理员联系！',
	      buttons : Ext.Msg.OK,
	      icon : Ext.Msg.ERROR
	     });
      }

    });
  }

});
Ext.onReady(function() {
      var menutrees = new ExtApp.tree.advancedTree01();
      menutrees.init();
    });