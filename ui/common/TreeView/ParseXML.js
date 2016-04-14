function ParseXML(){}
//属性
ParseXML.prototype.xml;
ParseXML.prototype.loadFinish;
ParseXML.prototype.nodeProperties = new Array();
ParseXML.prototype.key = "key";
ParseXML.prototype.value="value";
ParseXML.prototype.color="color";
ParseXML.prototype.nodeList;
ParseXML.prototype.rootName;
ParseXML.prototype.level;

ParseXML.XML_NULL=-1;

/**
 * 这个方法用于从字符串解析XML，
 * luochg 
 * 2010-2-2
 */
ParseXML.prototype.loadXMLFromString = function(xmlText){
	var newXML;
	var obj = this;
	try //Internet Explorer
	{
		newXML=new ActiveXObject("Microsoft.XMLDOM");
		newXML.async="false";
		newXML.loadXML(xmlText);
	}catch(e){
	  try //Firefox, Mozilla, Opera, etc.
	  {
	    var parser=new DOMParser();
	    newXML=parser.parseFromString(xmlText,"text/xml");
	  } catch(e){
		  alert(e.message);
	  }
	}
	this.xml=  newXML;
	this.rootName=newXML.documentElement.tagName;
}

ParseXML.prototype.loadXML = function(url)
{
	var newXML;
	var obj = this;
	if(document.implementation&&document.implementation.createDocument)
	{
		newXML = document.implementation.createDocument("","",null);
		newXML.async=false;
		newXML.load(url);
	}
	else
	{
		newXML= new ActiveXObject("Microsoft.XMLDOM");
		newXML.async=false;
		newXML.load(url);
	}
	this.xml=  newXML;
	this.rootName=newXML.documentElement.tagName;
}
ParseXML.prototype.praseXML = function()
{
	if(!this.xml)
	{
		alert("XML未加载!");
		return ParseXML.XML_NULL;
	}
	var rootNode=this.xml.documentElement;
	this.rootName=rootNode.tagName;
	this.nodeList = new ChildNodeList();
	this.level = this.iteratorNode(this.nodeList,rootNode,1);
	return this.level;
}

ParseXML.prototype.iteratorNode = function(list,node,level)
{
	if(!isNaN(level)&&level>0)
	{
		list.nodeLevel = level;
	}
	var result = list.nodeLevel;
	var flag = true;
	for(var child = node.firstChild;child!=null;child = child.nextSibling)
	{
		if(document.implementation&&document.implementation.createDocument&&!child.getAttribute)
		{
			continue;
		}
		flag = false;
		if(!list.nodeName||list.nodeName=="")
		{
			list.nodeName=child.tagName;
		}
		if(list.nodeName==child.tagName)
		{
			var nodeInfo = new NodeInfo();
			nodeInfo.nodeLevel = list.nodeLevel;
			nodeInfo.nodeName = list.nodeName;
			nodeInfo.key = child.getAttribute(this.key);
			nodeInfo.value=child.getAttribute(this.value);
			nodeInfo.color=child.getAttribute(this.color);
			for(var index=0;index<this.nodeProperties.length;index++)
			{
				nodeInfo[this.nodeProperties[index]] = child.getAttibute(this.nodeProperties[index]);
			}
			list.addElement(nodeInfo.key,nodeInfo);
			var n = this.iteratorNode(nodeInfo.childNodeList,child,list.nodeLevel+1);
			if(n>result)
			{
				result=n;
			}
		}
	}
	if(flag)
	{
		result = result-1;
	}
	return result;
}

ChildNodeList.prototype.nodeLevel=1;
ChildNodeList.prototype.nodeName;
ChildNodeList.prototype.keyArray;
ChildNodeList.prototype.ELEMENT_NULL=-1;
ChildNodeList.prototype.ELEMENT_EXIST=-2;
ChildNodeList.prototype.ELEMENT_NOT_EXIST=-3;
ChildNodeList.prototype.INDEX_OUT=-4;
ChildNodeList.prototype.ERROR_DELETE=-5;
function ChildNodeList()
{
	this.keyArray = new Array();
}
ChildNodeList.prototype.addElement = function(key,element){
	if(!key||!element){
		return ChildNodeList.ELEMENT_NULL;
	}
	if(this[key]){
		return ChildNodeList.ELEMENT_EXIST;
	}
	var index = this.keyArray.length;
	this.keyArray[index] = key;
	this[key] = element;
	return index;
}

ChildNodeList.prototype.addElementbyIndex=function(index,key,element)
{
	for(var i=this.keyArray.length-1;i>=index;i--)
	{
		this.keyArray[i+1]=this.keyArray[i];
		this[this.keyArray[i+1]]=this[this.keyArray[i]];
	}
	//this.keyArray.length=this.keyArray.length+1;
	this.keyArray[index]= key;
	this[key]=element;
	return index;
}
ChildNodeList.prototype.deleteElementbyIndex = function(index)
{
	if(index>this.keyArray.length)
	{
		return ChildNodeList.INDEX_OUT;
	}
	var key = this.keyArray[index];
	for(var i=index;i<this.keyArray.length;i++)
	{
		this.keyArray[i] = this.keyArray[i+1];
	}
	this.keyArray.length=this.keyArray.length-1;
	delete this[key];
	return index;
}
ChildNodeList.prototype.deleteElementbyKey = function(key)
{
//	alert(this["610003003"]);
	if(!this[key])
	{
		return ChildNodeList.ELEMENT_NOT_EXIST;
	}
	for(var index = 0;index<this.keyArray.length;index++)
	{
		if(this.keyArray[index]==key)
		{
			alert("找到:"+index);
			return this.deleteElementbyIndex(index);
		}
	}
	return ChildNodeList.ERROR_DELETE;
}
ChildNodeList.prototype.getElementbyKey = function(key)
{
	return this[key];
}
ChildNodeList.prototype.getElementbyIndex=function(index)
{
	return this.getElementbyKey(this.keyArray[index]);
}
ChildNodeList.prototype.size = function()
{
	return this.keyArray.length;
}

NodeInfo.prototype.nodeLevel;
NodeInfo.prototype.nodeName;
NodeInfo.prototype.key;
NodeInfo.prototype.value;
NodeInfo.prototype.color;
NodeInfo.prototype.childNodeList;
NodeInfo.prototype.openImg="";
NodeInfo.prototype.closeImg="";
function NodeInfo()
{
	this.childNodeList = new ChildNodeList();
}












