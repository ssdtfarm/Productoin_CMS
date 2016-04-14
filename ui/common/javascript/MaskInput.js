
function DoDocumentReady()
{		
	if(element.className=='codename' ||element.className=='readonly')
	{
		element.tabIndex=-1;
	}
	if(element.readOnly==true)
	{
		element.tabIndex=-1;
	}
	
	var strMaskType=element.getAttribute("MaskType");
	if(strMaskType!=null )
  {
		verifyDocumentReadyElement(strMaskType);
	}
	return true;
}

//校验元素strValue为元素值
function verifyDocumentReadyElement(strInfo)
{
	var vName;	//校验字段名称
	var vType;	//要进行的校验类型
	var vInfo;	//具体校验信息

	//分离出字段名称
	if(strInfo.indexOf("|")==-1)
	{
		vType=strInfo;
		vInfo="";
	}
	else
	{
		vType = strInfo.substring(0, strInfo.indexOf("|"));
		vInfo = strInfo.substring(strInfo.indexOf("|") + 1);
	}
	
	//校验声明的类型是否是系统已经定义的，如果不是提示修改
	if(vType.toLowerCase()!='mtdate'&&vType.toLowerCase()!='mtnumber'&&vType.toLowerCase()!='mtstring')
	{
		alert(element.name+"声明的类型"+vType+"不正确！");
		return false;
	}
	
	
	//对子类型进行输入法的设置，以及类型声明的校验//对一些特殊的类型设置是否在获得焦点或失去焦点时进行处理
	if(vType.toLowerCase()=='mtdate')//日期型
	{	
		element.style.imeMode="disabled";//关闭输入法
		element.attachEvent("onblur",maskDateBlur);
		element.attachEvent("onfocus",maskDateFocus);
		element.attachEvent("onkeypress",maskDate);
	}
	
	if(vType.toLowerCase()=='mtnumber')//数字形
	{
		element.style.imeMode="disabled";//关闭输入法
		if(vInfo==null)
		{
			element.attachEvent("onblur",maskIntegerBlur);
			element.attachEvent("onkeypress",maskInteger);
		}
		else if(vInfo.toLowerCase()=='mttinteger')//整形
		{
			element.attachEvent("onblur",maskIntegerBlur);
			element.attachEvent("onkeypress",maskInteger);
		}
		else if(vInfo.toLowerCase()=='mttdouble')//浮点型
		{
			element.attachEvent("onblur",maskDoubleBlur);
			element.attachEvent("onkeypress",maskDouble);
		}
		else
		{
			alert(element.name+"声明的子类型"+vInfo+"不正确！");
		}
	}
	
	if(vType.toLowerCase()=='mtstring')//字符串型
	{
		element.style.imeMode="disabled";//关闭输入法
		if(vInfo==null)
		{
			element.attachEvent("onkeypress",maskOnlyChar);
		}
		else if(vInfo.toLowerCase()=='mttupperchar')//大写字符
		{
			element.style.textTransform="uppercase";
			element.attachEvent("onkeypress",maskOnlyChar);
		}
		else if(vInfo.toLowerCase()=='mttlowerchar')//小写字符
		{	
			element.style.textTransform="lowercase";
			element.attachEvent("onkeypress",maskOnlyChar);
		}			
		else if(vInfo.toLowerCase()=='mttnumchar')//数字
		{
			element.attachEvent("onkeypress",maskNumChar);
		}
		else if(vInfo.toLowerCase()=='mttnumorchar')//数字字符混合
		{
			element.attachEvent("onkeypress",maskNumOrChar);
		}
		else if(vInfo.toLowerCase()=='mttonlychar')//字符
		{
			element.attachEvent("onkeypress",maskOnlyChar);
		}
		else
		{
			alert(element.name+"声明的子类型"+vInfo+"不正确！");
		}		
	}		
	return true;
}

//当keydown事件发生时的处理
function DoKeyDown()
{	 if(element.className.toLowerCase()=='codeno')
	{  
		if(event.keyCode == 13)
		{
			try{element.onkeyup();}catch(ee){}
			event.keyCode = 9;
		}
	}
	else if(element.className.toLowerCase()=='code')
	{
		if(event.keyCode == 13)
		{
			try{element.onkeyup();}catch(ee){}
			event.keyCode = 9;
		}
	}
	else if(element.className.toLowerCase()=='code8')
	{
		if(event.keyCode == 13)
		{
			try{element.onkeyup();}catch(ee){}
			event.keyCode = 9;
		}
	}
	
	//用于TAB转ENTER
	if(event.srcElement.type != 'button' && event.srcElement.type != 'textarea' && event.keyCode == 13)
	{
		event.keyCode = 9;
		//event.srcElement.blur();
	}
	return true;
}

//失去焦点时处理Date类型
function maskDateBlur()
{	//alert('in maskDateBlur');
	var strValue=event.srcElement.value;
	if(strValue!="")
	{
		if(strValue.length==8)
		{
				strValue=strValue.substr(0,4)+'-'+strValue.substr(4,2)+'-'+strValue.substr(6,2);
				//alert(strValue);
				if(IsDate(strValue))
				{
					//alert('isdate');
					event.srcElement.value=strValue;
				}
				else
				{ alert("日期格式不正确！");
					event.srcElement.focus();
				}
		}
		else{
			if(strValue.length==10)
			{
					if(IsDate(strValue))
					{//alert('isdate');
						event.srcElement.value=strValue;
					}
					else
					{ alert("日期格式不正确！");
						event.srcElement.focus();
					}
			}	
			else
			{
				alert("日期格式不正确！");
				event.srcElement.focus();
			}
		}
	}
}

//失去焦点时处理Double类型
function maskDoubleBlur()
{	//alert('in maskDateBlur');
	var strValue=event.srcElement.value;
	if(strValue!="")
	{
		if(strValue.substr(strValue.length-1,1)=='.')
		{
			event.srcElement.value=strValue.substr(0,strValue.length-1);
		}

		if(event.srcElement.value.substr(0,1)=='.')
		{
			event.srcElement.value='0'+event.srcElement.value;
		}
		
		while(event.srcElement.value.substr(0,1)=='0')
		{
			if(event.srcElement.value.indexOf('.')==1)
			{
				break;
			}
			else
			{
				event.srcElement.value=event.srcElement.value.substr(1);
			}
		}		
	}
}

//失去焦点时处理Integer类型
function maskIntegerBlur()
{	//alert('in maskDateBlur');
	var strValue=event.srcElement.value;
	if(strValue!="")
	{		
		while(event.srcElement.value.substr(0,1)=='0')
		{
			event.srcElement.value=event.srcElement.value.substr(1);
		}		
	}
}

//获得焦点时处理Date类型
function maskDateFocus()
{//alert('in maskDateFocus');
	
	var strValue=event.srcElement.value;
	if(strValue!="")
	{ var index;
		index=strValue.indexOf('-');
		while(index!=-1)
		{
			//alert('index');
				strValue=strValue.substr(0,index)+strValue.substr(index+1);
				//alert(strValue);
				index=strValue.indexOf('-');
		}
		event.srcElement.value=strValue;
	}
}

//处理Date类型
function maskDate()
{
	var strValue=event.srcElement.value;
	if(strValue!="")
	{
		if(strValue.length==8)
		{
			event.returnValue =false;
  	return;
  	}	
		
	}
	maskNumChar();	
}

//处理Double类型
function maskDouble()
{
	var char = String.fromCharCode(event.keyCode);
  var re = /[0123456789\.]/g;
  if(char.match(re) == null)
  {
  	event.returnValue =false;
  	return;
  }
  //alert('not null');
	//if(GetCursorPsn(event.srcElement)==0)
	//{ 
		//if(char=='0')
		//{	//alert('=0');
		//	event.returnValue=false;
		//	return;
		//}
		//if(char=='.')
		//{ 
		//	event.returnValue=false;
		//	return;
		//}
	//}
	//else
	//{
		if(char==".")
		{		
			if(event.srcElement.value.indexOf('.')!=-1)
			{
				event.returnValue=false;
				return;
			}
		}
	//}
}

//处理NumAndStr类型
function maskNumOrChar()
{
	var char = String.fromCharCode(event.keyCode);
    var re = /[0-9a-zA-Z]/g;
    event.returnValue = char.match(re) != null ? true : false;
}

//处理NumStr类型
function maskOnlyChar()
{
	var char = String.fromCharCode(event.keyCode);
    var re = /[a-zA-Z]/g;
    event.returnValue = char.match(re) != null ? true : false;
}

//处理NumStr类型
function maskNumChar()
{	
	var char = String.fromCharCode(event.keyCode);
    var re = /[0-9]/g;
    event.returnValue = char.match(re) != null ? true : false;
}

//处理Integer类型
function maskInteger()
{ 
	//if(GetCursorPsn(event.srcElement)==0)
	//{	
		//var char = String.fromCharCode(event.keyCode);
    //if (char=="0")
    //{
    	//event.returnValue = false;
    	//return;
    //}
	//}
	var char = String.fromCharCode(event.keyCode);
    var re = /[0-9]/g;
    event.returnValue = char.match(re) != null ? true : false;
}

//获得光标位置
function GetCursorPsn(txb) 
{ 	//alert(txb.name);
    var slct = document.selection; 
    var rng = slct.createRange(); 
    txb.select(); 
    rng.setEndPoint("StartToStart", slct.createRange()); 
    var psn = rng.text.length; 
    rng.collapse(false); 
    rng.select(); 
    return psn; 
} 

//校验是否是日期，格式必须是YYYY-MM-DD
function IsDate(str){ 
	var reg = /^(\d{1,4})(-)(\d{1})(\d{1})(-)(\d{1})(\d{1})$/;
	var r = str.match(reg); 
	if(r==null)return false;
	var mon=eval(r[3]+'*10+'+r[4]);
	var day=eval(r[6]+'*10+'+r[7]);
	var d= new Date(r[1], mon-1,day); 
	var mm;
	var dd;
	mon=d.getMonth()+1;
	if(mon<10) 
		mm="0"+mon;
	else
		mm=mon;
	day=d.getDate();
	if(day<10)
		dd="0"+day;
	else
		dd=day;
	var newStr=d.getFullYear()+r[2]+mm+r[2]+dd;
	return newStr==str 
}
