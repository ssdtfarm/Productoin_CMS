Tree.prototype.nodeArrayList;
Tree.prototype.isAddonChangeEvent=false;
Tree.prototype.SELECTLIST_NULL=-1;
Tree.prototype.SELECTLIST_TYPE_NOT_ARRAY=-2;
Tree.prototype.SELECTLIST_EMPTY=-3;
Tree.prototype.SELECTLIST_LENGTH_OUT=-4;
Tree.prototype.NODELIST_EMPTY=-5;
Tree.prototype.EVENT_NULL=-6;
Tree.prototype.rootId;
Tree.prototype.blueURL;
Tree.prototype.isUseDataURL;
Tree.prototype.rootName;
Tree.prototype.imageURL;
Tree.prototype.rootImage;
Tree.prototype.firstOpenImg;
Tree.prototype.firstCloseImg;
Tree.prototype.folderImg;
Tree.prototype.folderOpenImg;
Tree.prototype.fileImg;
Tree.prototype.openImg;
Tree.prototype.closeImg;
Tree.prototype.elementLineImg;
Tree.prototype.lineImg;
Tree.prototype.endFolderOpenImg;
Tree.prototype.endFolderCloseImg;
Tree.prototype.noneImg;
Tree.prototype.isFolderURL;
Tree.prototype.rootURL;
Tree.prototype.target;
Tree.prototype.linkClass;
Tree.prototype.styleClass;
Tree.prototype.imgClass;
Tree.prototype.useDataImg;
Tree.prototype.onMouseOver;
Tree.prototype.onMouseOut;
Tree.prototype.isCheckBox;
Tree.prototype.checkBoxName;
function Tree(nodeList)
{
	if(nodeList)
	{
		this.nodeArrayList = nodeList;
	}
	else
	{
		this.nodeArrayList=new ChildNodeList();
	}
	this.rootId = "0";
	this.blueURL="javascript:void(0);";
	this.isUseDataURL="false";
	this.rootName="";//根节点
	this.rootImage="root.png";
	this.imageURL="../common/TreeView/images/";
	this.folderImg="users--plus.png";
	this.folderOpenImg="users--minus.png";
	this.fileImg="user-black.png";
	this.openImg="M1.gif";
	this.closeImg="P1.gif";
	this.elementLineImg="L1.gif";
	this.lineImg ="L4.gif";
	this.endLineImg="L2.gif";
	this.endFolderOpenImg="M2.gif";
	this.endFolderCloseImg="P2.gif";
	this.noneImg="L5.gif";
	this.isFolderURL="false";
	this.rootRUL="javascript:void(0);";
	this.target="_blank";
	this.linkClass="";
	this.imgClass="";
	this.styleClass="common";
	this.useDataImg="no";
	this.onMouseOver="#CCCCCC";
	this.onMouseOut="";
	this.isCheckBox="false";
	this.checkBoxName="checkbox";
	var ni = new NodeInfo();
	ni.key="root";
	ni.value=this.rootName;
	ni.nodeName=this.rootName;
	ni.nodeLevel=1;
	ni.openImg="root.png";
	ni.closeImg="M0.gif";
	nodeList.addElementbyIndex(0,ni.key,ni);
	var _this = this;
 this.DragStart = function(e)

 {

  e = e || window.event;

  this.DragObj = e.target || e.srcElement;
  if(this.DragObj.tagName=="A"){
	  key = this.DragObj.id;
	  alert("key:"+key);
	  alert(nodeList.deleteElementbyKey(key));
  }
  //this.tmpNode = document.getElementById('dragDiv');
  //this.tmpNode.innerHTML = this.DragObj.lastChild.nodeValue;
  this.indrag = true;
  
//  this.x = e.pageX || (e.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft));
//
//     this.y = e.pageY || (e.clientY + (document.documentElement.scrollTop || document.body.scrollTop));
//
//  this.left = parseInt(this.tmpNode.offsetLeft);
//
//  this.top = parseInt(this.tmpNode.offsetTop);

  return false;

 }

 this.DragStop = function(e)

 {
  if(!this.indrag)return;

  this.indrag = false;

  this.tmpNode.style.display = 'none';

  e = e || window.event;

  var target = e.target || e.srcElement;

  //if(target.className != 'title')return;

  try{

   target.parentNode.appendChild(this.DragObj);

  }

  catch(e)

  {

   alert('出错啦!');

  }

  return true;

 }

 this.Draging = function(e)

 {

  if(!this.indrag)return;

  e = e || window.event;

  //_this.autoScroll(e);

  var x = e.pageX || (e.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft));

     var y = e.pageY || (e.clientY + (document.documentElement.scrollTop || document.body.scrollTop));

     

  this.tmpNode.style.left = x+2+'px';

  this.tmpNode.style.top = y+2+'px';

  this.tmpNode.style.display = 'block';

  //这里也要return false啊

  return false;

 }
 this.init = function()
 {

     document.onmousedown = _this.DragStart;

     document.onmouseup = _this.DragStop;

     document.onmousemove = _this.Draging;

    }
}

Tree.prototype.createTree=function(parentObject,nodeList)
{
	parentObject.innerHTML="";
	if(!nodeList)
	{
		nodeList=  this.nodeArrayList;
	}
	var level=1;
	var tableNode=document.createElement("table");
	tableNode.className=this["styleClass"];
	tableNode.style.cssText="border-collapse:collapse;border:0px solid;padding:0px;margin:0px;"; 
	tableNode.border=0;
	tableNode.cellPadding=0; 
    tableNode.cellSpacing=0;
    for(var i=0;i<nodeList.size();i++)
    { 
        var nodeInfo=nodeList.getElementbyIndex(i); 
        var n_id="",name="",url="",ischild="false",openimg="",closeimg="",color=""; 
        if(nodeInfo.key){ 
            n_id=nodeInfo.key; 
        } 
        if(nodeInfo.value){ 
            name=nodeInfo.value; 
        } 
        if(nodeInfo.url){ 
            url=nodeInfo.url; 
        } 
        if(nodeInfo.color){ 
            color=nodeInfo.color; 
        }
        if(nodeInfo.childNodeList.size()>0){ 
            ischild="true"; 
        } 
        if(nodeInfo.openImg!=""){ 
            this.elementLineImg=nodeInfo.openImg; 
        }
        else{
        	this.elementLineImg="L1.gif";
        } 
        if(nodeInfo.nodeLevel && nodeInfo.nodeLevel!=level){ 
            level=nodeInfo.nodeLevel; 
        } 
         
        //添加行 
        var row=tableNode.insertRow(tableNode.rows.length); 
        addEvent(row,"mouseover",mouseOverNode); 
        addEvent(row,"mouseout",mouseOutNode); 
        //添加单元格 
        var cell=row.insertCell(row.length); 
        cell.style.cssText="white-space:nowrap;"; 
        //根据节点级别加递进线图片 
        var previousNodes; 
        try
        { 
            previousNodes=parentObject.parentNode.previousSibling.firstChild.childNodes; 
            for(var j=1;j<level;j++){ 
                var img=document.createElement("img"); 
        		img.setAttribute("align","absmiddle"); 
                /** 
                 * 判断是否是最后一级节点，如果是，递进线为空白 
                 */ 
                if(j+1==level){ 
                    if(previousNodes[j-1].firstChild.src.indexOf(this["endFolderOpenImg"])>0){ 
                        img.src=this["imageURL"]+this["noneImg"]; 
                    }else{ 
                        img.src=this["imageURL"]+this["lineImg"]; 
                    } 
                }else{ 
                    img.src=previousNodes[j-1].src; 
                } 

                img.className=this["imgClass"]; 
                cell.appendChild(img); 
            } 
        }catch(e){ 
	        alert("error-------"+e.message);
        } 
        //添加节点事件区域 
        var eventArea=document.createElement("span"); 
        eventArea.style.cssText="cursor:pointer;"; 
         
        //加节点展开关闭图片 
        var imgOpenOrClose=document.createElement("img"); 
        imgOpenOrClose.setAttribute("align","absmiddle"); 
        imgOpenOrClose.className=this["imgClass"]; 
        imgOpenOrClose.setAttribute("id","sign_img_"+level+"_"+n_id); 
        if((i+1)!=nodeList.size()){ 
            if(ischild && ischild.trim()=="true"){ 
                imgOpenOrClose.src=this["imageURL"]+this["closeImg"]; 
            }else{ 
                imgOpenOrClose.src=this["imageURL"]+this["elementLineImg"]; 
            } 
        }else{ 
            if(ischild && ischild.trim()=="true"){ 
                imgOpenOrClose.src=this["imageURL"]+this["endFolderCloseImg"]; 
            }else{ 
                imgOpenOrClose.src=this["imageURL"]+this["endLineImg"]; 
            } 
        } 
        eventArea.appendChild(imgOpenOrClose); 
        //添加节点图片 
        var imgNodeOpenOrClose=document.createElement("img"); 
        imgNodeOpenOrClose.setAttribute("align","absmiddle"); 
        imgNodeOpenOrClose.className=this["imgClass"]; 
        imgNodeOpenOrClose.setAttribute("id","node_img_"+level+"_"+n_id); 
        if(this["useDataImg"].toLowerCase()=="all"){ 
            imgNodeOpenOrClose.src=this["imageURL"]+openimg; 
        }else{ 
            if(ischild && ischild.trim()=="true"){ 
                imgNodeOpenOrClose.src=this["imageURL"]+this["folderImg"]; 
            }else{ 
                imgNodeOpenOrClose.src=this["imageURL"]+this["fileImg"]; 
            } 
        } 
        eventArea.appendChild(imgNodeOpenOrClose); 
        //节点事件参数 
        var file_image_param=null,node_img_open_param=null,node_img_colse_param=null; 
        if(this["useDataImg"].toLowerCase()=="all"){ 
            file_image_param=openimg; 
            node_img_open_param=openimg; 
            node_img_colse_param=closeimg; 
        }else{ 
            file_image_param=this["fileImg"]; 
            node_img_open_param=this["folderOpenImg"]; 
            node_img_colse_param=this["folderImg"]; 
        } 
        var img_open_param=null,img_close_param=null; 
        if((i+1)!=nodeList.size()){ 
            img_open_param=this["openImg"]; 
            img_close_param=this["closeImg"]; 
        }else{ 
            img_open_param=this["endFolderOpenImg"]; 
            img_close_param=this["endFolderCloseImg"]; 
        } 
     
        //添加节点单击事件 
        if(ischild && ischild.trim()=="true"){ 
            addEvent(eventArea,"click",delegateLink(clickTreeNode,n_id,level,file_image_param,img_open_param, 
                img_close_param,node_img_open_param,node_img_colse_param,nodeInfo.childNodeList,this)); 
        } 
        cell.appendChild(eventArea); 
        
        //添加连接 
        var link=document.createElement("a"); 
        //link.className=this["linkClass"]; 
         link.id = n_id;
        var link_href=""; 
        if((ischild && ischild.trim()=="true" && this["isFolderURL"].trim()=="true") 
            || ischild.trim()=="false"){ 
            if(this["isUseDataURL"]=="true"){ 
                link_href=url; 
            }else{ 
                link_href=this["blueURL"]; 
            } 
            /** 
             * 判断连接是否带参数 
             */ 
            if(link_href && link_href!=null && link_href!="null"){ 
                if(link_href.indexOf("?")==-1){ 
                    link_href+="?"; 
                }else{ 
                    link_href+="&"; 
                } 
                link_href+="node="+n_id+"&level="+level; 
            }else{ 
                link_href="javascript:void(0);"; 
            } 
        }else{ 
            link_href="javascript:void(0);"; 
        } 
        if(url!=""){
        	link.href=link_href;         
        	link.target=this["target"]; 
        }
        cell.appendChild(link); 
        if(color==""){
        	color="black";
        }
        link.style.color=color;
        //添加节点名称 
        var nodeName=document.createTextNode(" "+name); 
        link.appendChild(nodeName); 
         
        //加下一级节点空间 
        if(ischild && ischild.trim()=="true"){ 
            var newrow=tableNode.insertRow(tableNode.rows.length); 
            var newcell=newrow.insertCell(newrow.length); 
            newcell.setAttribute("id","tree_"+level+"_"+n_id); 
            newcell.style.cssText="white-space:nowrap;"; 
            newcell.style.display="none"; 
        } 
    } 
    parentObject.appendChild(tableNode); 
} 
 /** 
  * 单击树节点 
  * @param node_id 单击节点的ID 
  * @param level 单击节点的级别 
  * @param fileImg 文件图片 
  * @param sign_img_open 展开节点图片 
  * @param sign_img_close 关闭节点图片 
  * @param node_img_open 节点展开时图片 
  * @param node_img_close 节点关闭时图片 
  * @param node_childs 子节点集合 
  * @param blue_tree 树对象 
  */ 
 function clickTreeNode(node_id,level,fileImg,sign_img_open,sign_img_close,node_img_open,node_img_close,node_childs,blue_tree){ 
    var node="tree_"+level+"_"+node_id; 
    var openNode=document.getElementById(node); 
    if(openNode.style.display=="none"){ 
        document.getElementById("sign_img_"+level+"_"+node_id).src=blue_tree["imageURL"]+sign_img_open; 
        document.getElementById("node_img_"+level+"_"+node_id).src=blue_tree["imageURL"]+node_img_open; 
        //根据节点级别加递进线图片 
        var line=""; 
        var previousNodes=openNode.parentNode.previousSibling.firstChild.childNodes; 
        for(var i=0;i<level;i++){ 
            var imgurl; 
            if(i+1==level){ 
                if(previousNodes[i].firstChild.src.indexOf(blue_tree["endFolderOpenImg"])>0){ 
                    imgurl=blue_tree["imageURL"]+blue_tree["noneImg"]; 
                }else{ 
                    imgurl=blue_tree["imageURL"]+blue_tree["lineImg"]; 
                } 
            }else{ 
                imgurl=previousNodes[i].src; 
            } 
            line=line+"<img align=\"absmiddle\" class=\""+blue_tree["imgClass"]+"\" src=\""+imgurl+"\">"; 
        } 

        //添加加载中提示 
        openNode.innerHTML="<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"" 
                    +blue_tree["styleClass"]+"\"><tr class=common><td class=common>"+line+"<img align=\"absmiddle\" class=\""+blue_tree["imgClass"]+"\" src=\"" 
                    +blue_tree["imageURL"]+blue_tree["endLineImg"]+"\"><img align=\"absmiddle\" class=\""+blue_tree["imgClass"]+"\" src=\"" 
                    +blue_tree["imageURL"]+fileImg+"\">加载中...</td></tr></table>"; 
        openNode.style.display=""; 
        blue_tree.createTree(openNode,node_childs); 
    }else{ 
        openNode.style.display="none"; 
        document.getElementById("sign_img_"+level+"_"+node_id).src=blue_tree["imageURL"]+sign_img_close; 
        document.getElementById("node_img_"+level+"_"+node_id).src=blue_tree["imageURL"]+node_img_close; 
    } 
 } 
/** 
 * 鼠标移上节点 <br> 
 * Author：陈伟 <br> 
 * CreateDate：2009-4-21 <br> 
 * Modifier：陈伟 <br> 
 * ModifyDate：2009-4-21 <br> 
 * Version:1.1<br> 
 * Copyright(c)2008 Sinosoft<br> 
 * All right reserved.<br> 
 * 
 */ 
 function mouseOverNode(){ 
    var sourceObject=getEventSource(); 
    if(sourceObject && sourceObject.tagName.toLowerCase()=="a"){ 
        //sourceObject.parentNode.className=this["onMouseOver"]; 
        sourceObject.style.backgroundColor=this["onMouseOver"]; 
    }else if(sourceObject && sourceObject.parentNode && sourceObject.parentNode.tagName.toLowerCase()=="a"){ 
        sourceObject.parentNode.style.backgroundColor=this["onMouseOver"]; 
    } 
 } 
/** 
 * 鼠标离开节点 <br> 
 * Author：陈伟 <br> 
 * CreateDate：2009-4-21 <br> 
 * Modifier：陈伟 <br> 
 * ModifyDate：2009-4-21 <br> 
 * Version:1.1<br> 
 * Copyright(c)2008 Sinosoft<br> 
 * All right reserved.<br> 
 * 
 */ 
 function mouseOutNode(){ 
    var sourceObject=getEventSource(); 
    if(sourceObject && sourceObject.tagName.toLowerCase()=="a"){ 
        //sourceObject.parentNode.className=this["onMouseOut"]; 
        sourceObject.style.backgroundColor=this["onMouseOut"]; 
    }else if(sourceObject && sourceObject.parentNode && sourceObject.parentNode.tagName.toLowerCase()=="a"){ 
        sourceObject.parentNode.style.backgroundColor=this["onMouseOut"]; 
    } 
 } 
/** 
 * 函数代理，用来解决循环添加事件时参数问题 <br> 
 * Author：陈伟 <br> 
 * CreateDate：2009-4-21 <br> 
 * Modifier：陈伟 <br> 
 * ModifyDate：2009-4-21 <br> 
 * Version:1.1<br> 
 * Copyright(c)2008 Sinosoft<br> 
 * All right reserved.<br> 
 * 
 */ 
 function delegateLink(fun,node_id,level,fileImg,sign_open,sign_close,node_open,node_close,node_childs,blue_tree){ 
    return function(){ 
        fun.call(window,node_id,level,fileImg,sign_open,sign_close,node_open,node_close,node_childs,blue_tree); 
    } 
 } 
 var selectedCheckBox=new ChildNodeList(); 
 var signSelectAll=new ChildNodeList(); 
 function selectCheckBox(){ 
    var eventSource=getEventSource(); 
     
    if(eventSource.checked){ 
        selectedCheckBox.addElement(eventSource.getAttribute("id"),eventSource.getAttribute("id")); 
        try{ 
            var obj=eventSource; 
            while(true){ 
                obj=obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.previousSibling.firstChild.getElementsByTagName("input")[0]; 
                obj.checked=true; 
                selectedCheckBox.addElement(obj.getAttribute("id"),obj.getAttribute("id")); 
            } 
        }catch(e){ 
        } 
    }else{ 
        selectedCheckBox.deleteElementByKey(eventSource.getAttribute("id")); 
    } 
 } 
    /** 
     * 给对象添加事件，兼容各种浏览器 <br> 
     * Author：陈伟 <br> 
     * CreateDate：2009-4-21 <br> 
     * Modifier：陈伟 <br> 
     * ModifyDate：2009-4-21 <br> 
     * Version:2.0<br> 
     * 
     */ 
    function addEvent(object,eventType,eventHandler){ 
        if(object.addEventListener){//2级DOM 
            object.addEventListener(eventType,eventHandler,true); 
        }else if(document.attachEvent){//IE5+ 
            object.attachEvent("on"+eventType,eventHandler); 
        }else{//IE4 
            object["on"+eventType]=eventHandler; 
        } 
    } 
    //扩展String对象，增加trim方法去掉字符串前后空格 
    String.prototype.trim=function(){        
        return this.replace(/^\s*/g,"").replace(/\s*$/g,""); 
    } 
/** 
 * 获取事件源对象 <br> 
 * Author：陈伟 <br> 
 * CreateDate：2009-4-21 <br> 
 * Modifier：陈伟 <br> 
 * ModifyDate：2009-4-21 <br> 
 * Version:1.1<br> 
 * 
 */ 
function getEventSource(){ 
    var event=null; 
    var source=null; 
    if(document.all){//IE 
        event=window.event; 
    }else{ 
        //获取调用者 
        var func=SearchEvent.caller; 
        while(func!=null){ 
            var arg0=func.arguments[0]; 
            if(arg0){ 
                if((arg0.constructor==Event || arg0.constructor ==MouseEvent) 
                     || (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation)){   
                    event = arg0; 
                } 
            } 
            func=func.caller; 
        } 
    } 

    if(event && event.srcElement){ 
        source=event.srcElement; 
    }else{ 
        source=event.target; 
    } 
    return source; 
}
 


















