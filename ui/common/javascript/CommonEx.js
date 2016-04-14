
//小写转成大写
function toUpperCase(obj)
{
  var str=obj.value;
  obj.value=str.toUpperCase();
}

//日期格式检测,只允许按yyyy-mm-dd格式输入
function isDateEx(obj,name)
{
  var value=obj.value;
  if(value=='') return true;
  var newPar1=/^(19|20)\d{2}-(0?\d|1[012])-(0?\d|[12]\d|3[01])$/; 
  var newPar2=/^(19|20)\d{2}(0?\d|1[012])(0?\d|[12]\d|3[01])$/; 
  var isSuc = newPar1.test(value)||newPar2.test(value);

  if(!isSuc)
  {
    myAlert(name+""G0000025522","G0000025523"-mm-"G0000025524"")
    obj.value='';
    return false;
  }
}

/******************************
*校验是否是字母或数字的组合
*obj    -- 传入的文本框对象
*name   -- 名称
*len    -- 规定的长度
*创建人 : 张红发
******************************/
function isNumORChar(obj,name,length)
{
  var value=obj.value;
  if(value=='') return true;
  var str="^[0-9a-zA-Z]{"+length+"}$";
  var objRegExp=new RegExp(str);

  if(!objRegExp.test(value))
  {
    myAlert(name+""G0000025525""+length+""G0000025526"")
    obj.value='';
    return false;
  }
}

/******************************
*校验是否是字母或数字的组合
*obj    -- 传入的文本框对象
*name   -- 名称
*start  -- 最短长度
*end    -- 最长长度
*创建人 : 张红发
******************************/
function isNumORChar1(obj,name,start,end)
{
  var value=obj.value;
  if(value=='') return true;
  var str="^[0-9a-zA-Z]{"+start+","+end+"}$";
  var objRegExp=new RegExp(str);

  if(!objRegExp.test(value))
  {
    myAlert(name+""G0000025525""+start+""G0000025527""+end+""G0000025526"")
    obj.value='';
    return false;
  }
}
//小数点位数检测
function checkDecimal(obj,length,name)
{
  var value=obj.value;
  var str="^\\d*(\\.\\d{0,"+length+"})?$";
  var objRegExp=new RegExp(str);

   if(!objRegExp.test(value))
   {
      myAlert(name+""G0000025528""+length+""G0000025529"");
      obj.value='';
      return false;
   }
   return true;
}


//将yyyymmdd转为yyyy-mm-dd 同时有把日期格式转换为长日期格式功能
//但没有作日期交验请确保传入参数是日期类型
function setDate(component,backStr)
{ 
	if(component=='0'){
		component=''
	}
	if(component!=null&&component!=''&&!isCheckInputDateHis(component)){
		myAlert(backStr+""G0000025530"");
		component='';
	}
	var sd = component;
	if (sd.length == 8 && sd.substr(4, 1) != '-') {
		component = sd.substr(0,4) + '-' + sd.substr(4,2) + '-' + sd.substr(6, 2);
	} else if (sd.indexOf('-') > 0){
		var i1 = sd.indexOf('-');
		var i2 = sd.substr(sd.indexOf('-') + 1).indexOf('-');
		var ty = sd.substr(0, 4);
		var tm = sd.substr(i1 + 1, 2);
		if (tm.indexOf('-') > 0) {
			tm = tm.substr(0, 1);
			tm = '0' + tm;
		}
		var td = sd.substr(sd.indexOf('-') + 1).substr(i2 + 1);
		if (td.length == 1) {
			td = '0' + td;
		}
		component= ty + '-' + tm + '-' + td;
	}
	return component;
}

//日期校验yyyy-mm-dd，yyyymmdd
function isCheckInputDateHis(strNumber)
{ 
		var newPar2=/^(19|20)\d{2}(0?\d|1[012])(0?\d|[12]\d|3[01])$/;
		var newPar1=/^(19|20)\d{2}-(0?\d|1[012])-(0?\d|[12]\d|3[01])$/;
  	var isSuc = newPar1.test(strNumber)||newPar2.test(strNumber);
  	return isSuc; 
} 

