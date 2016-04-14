/************************************************
 *
 *	程序名称: MulLine.js
 *	程序功能: 多记录输入
 *
 *************************************************/
/************************************************
 *	类：多行输入类
 *************************************************/

function MulLineEnter( iFormName , iInstanceName )
{
	//以下属性需要用户初始化
	this.formName = iFormName || "fm";	//表单控件名称
	this.instanceName = iInstanceName || "";	//实例名称
	this.mulLineCount = 0;	//行输入对象的行数
	this.canAdd = 1;	//是否可以允许增加，删除1表示可以，0表示不可以
	this.canSel = 0;	//是否可以选择，1表示可以，0表示不可以
	this.displayTitle = 1;	//是否显示标题，1表示显示，0表示不显示
	this.locked = 0;	//是否锁定，1表示锁定，0表示可编辑
	this.canChk = 0;	//是否需要多行选择,1表示可以多行选择，0表示不可以
	this.colCount = 0;	//新增，列的数目
	this.hiddenPlus = 0;	//新增,是否隐藏添加一行的标志：0为显示，1为隐藏
	this.hiddenSubtraction=0;	//新增,是否隐藏删除一行的标志：0为显示，1为隐藏
	this.recordNo = 0;	//新增,如果分页显示多条纪录，那么显示前将该值赋为基数,那么第2页显示的序号会接着上页的序号
	this.checkFlag = 0;	//新增,和checkAll函数配合用
	this.state = 0;	//新增,此参数对外部无任何实际意义,和_ResumeState函数一起使用
	this.arraySave = new Array();	//新增，保存传入的列数组
	this.arraySave2 = new Array();	//新增，保存参数的数组--用于是否显示中文
	this.chkBoxEventFuncName = "";	//新增，保存外部单击CheckBox框时响应的外部函数名
	this.chkBoxEventFuncParm = " ";	//新增，保存外部单击CheckBox框时响应的外部函数传入的参数
	this.chkBoxAllEventFuncName = "";	//新增，保存外部单击标题栏全选CheckBox框时响应的外部函数名
	this.selBoxEventFuncName = "";	//新增，保存外部单击RadioBox框时响应的外部函数名
	this.selBoxEventFuncParm = " ";	//新增，保存外部单击RadioBox框时响应的外部函数传入的参数
	this.addEventFuncName = "";	//新增，保存外部单击+按钮时响应的外部函数名
	this.addEventFuncParm = " ";	//新增，保存外部单击+按钮框时响应的外部函数传入的参数
	this.delEventFuncName = "";	//新增，保存外部单击-按钮时响应的外部函数名
	this.delEventFuncParm = " ";	//新增，保存外部单击-按钮框时响应的外部函数传入的参数
	this.AllowSort="";	//排序
	this.SortPage="";	//排序中Grid对应的turnpage
	this.allowsort="AllowSortFun";	//Grid的排序函数通过它调用turnpage中的函数
	this.windowWidth=window.document.body.clientWidth;
	this.windowHeight=window.document.body.clientHeight;
	this.mulLineNum = 1;	//新增,设置同一行的MulLine的个数，默认是1
	this.detailInfo ="";	//如果支持单击，则在此处设置提示信息
	this.tableWidth ="";	//设置table的宽度

	//以下属性不需要用户初始化
	this.mulLineText = "";	//行输入对象的一行模版的内容(内部使用）
	this.mulLineTextTitle = "";	//行输入对象的标题（内部使用）

	//初始化添加一行隐藏行，spanID由-1 改成-2
	this.maxSpanID = -1;	//行输入对象的最大SpanID的值
	this.errorString = "";	//该变量为当执行发生错误时，提示的错误信息

	//方法
	this.loadPage = _LoadPage;
	this.setFieldValue =_SetFieldValue;
	this.clearData = _ClearData;
	this.findSpanID = _FindSpanID;
	this.delBlankLine = _DelBlankLine;
	this.delCheckTrueLine =_DelCheckTrueLine;	//删除选中的CheckBox行
	this.delRadioTrueLine =_DelRadioTrueLine;	//删除选中的RadioBox行
	this.lock = _Lock;
	this.unLock = _UnLock;
	this.getSelNo = _GetSelNo;
	this.getChkNo = _GetChkNo;
	this.checkAll = _CheckAll;
	this.checkBoxAll = _CheckBoxAll;
	this.checkBoxAllNot= _CheckBoxAllNot;
	this.checkBoxSel = _CheckBoxSel;
	this.loadMulLine = _LoadMulLine;
	this.loadMulLineArr = _LoadMulLineArr;
	this.addOne = _AddOne;
	this.deleteOne = _DeleteOne;
	this.keyUp = _KeyUp;
	this.getErrStr = _GetErrStr;
	this.setRowColData = _SetRowColData;
	this.getRowColData = _GetRowColData;
	this.getRowData = _GetRowData;
	this.detailClick = _detailClick;
	this.checkBoxClick = _CheckBoxClick;
	this.radioClick = _radioClick;
	this.resumeState = _ResumeState;
	this.checkValue = _CheckValue;
	this.checkValue2 = _CheckValue2;
	this.setFocus = _SetFocus;
	this.getFocus = _GetFocus;
	this.moveFocus = _MoveFocus;
	this.setPageMark = _SetPageMark;
}

function _detailClick(cObj)
{}

function _Lock(iTObj)
{
	var tObj = iTObj || this;
	if(tObj.locked!=1)
	{
		//如果没有锁定，执行锁定
		try
	       {
			tObj.locked=1;
			//注意：这里和_SetFieldValue函数中"请注意"的说明部分紧密相关
			//因为这里是将_SetFieldValue函数中模板部分的文本替换字符串，
			//如果_SetFieldValue()中，这部分的文本格式变了，这里也要相应变化
			eval( tObj.formName + ".all('" + tObj.instanceName + "addOne').disabled=true");
	        	tObj.mulLineText=replace(tObj.mulLineText,"type=button value='-'","type=button disabled value='-'");
			if (tObj.mulLineCount>0)
			{
				if(tObj.mulLineCount==1)
				{
					_ResumeState();
					try
					{
						eval( tObj.formName + ".all('" + tObj.instanceName + "Del').disabled=true");
					}
					catch(ex)
					{
						eval( tObj.formName + ".all('" + tObj.instanceName + "Del')[0].disabled=true");
					}
				}
				else
				{
					for(i=0;i<tObj.mulLineCount;i++)
					{
						eval( tObj.formName + ".all('" + tObj.instanceName + "Del')[" + i + "].disabled=true");
					}
				}
			}
		}
		catch(ex)
		{
			_DisplayError("在MulLine.js-->_Lock函数中发生异常:" + ex,tObj);
		}
	}
}

function _UnLock(iTObj)
{
    var tObj = iTObj || this;
    if(tObj.locked!=0)
    {
            //如果锁定，执行解锁
        try
        {
              tObj.locked=0;
              //注意：这里和_SetFieldValue函数中"请注意"的说明部分紧密相关
              //因为这里是将_SetFieldValue函数中模板部分的文本替换字符串，
              //如果_SetFieldValue()中，这部分的文本格式变了，这里也要相应变化
              eval( tObj.formName + ".all('" + tObj.instanceName + "addOne').disabled=false");
              tObj.mulLineText=replace(tObj.mulLineText,"type=button disabled value='-'","type=button value='-'");
              if (tObj.mulLineCount>0)
              {
                  if(tObj.mulLineCount==1)
                  {
                      _ResumeState();
                      try
                      {
                              eval( tObj.formName + ".all('" + tObj.instanceName + "Del').disabled=false");
                      }
                      catch(ex)
                      {
                              eval( tObj.formName + ".all('" + tObj.instanceName + "Del')[0].disabled=false");
                      }
                  }
                  else
                  {
                      for(i=0;i<tObj.mulLineCount;i++)
                      {
                              eval( tObj.formName + ".all('" + tObj.instanceName + "Del')[" + i + "].disabled=false");
                      }
                  }
              }
        }
        catch(ex)
        {
                _DisplayError("在MulLine.js-->_UnLock函数中发生异常:" + ex,tObj);
        }
    }
}

/************************************************
 *方法：提供选中的行数，条件是canSel设置为1
 *输入：	无
 *输出：	选择的行数
 ************************************************
 */

function _GetSelNo(ObjInstance)
{
	var tObjInstance=ObjInstance||this;
	var i=0;
	try
	{
		if (tObjInstance.mulLineCount>0)
		{
			if(tObjInstance.mulLineCount==1)
			{
				_ResumeState();
				try
				{
        				if (eval( tObjInstance.formName + ".all('" + tObjInstance.instanceName + "Sel').checked"))
					{
						return 1;
					}
				}
				catch(ex)
				{
					if (eval( tObjInstance.formName + ".all('" + tObjInstance.instanceName + "Sel')[0].checked"))
					{
						return 1;
					}
				}
			}
			else
			{
				for(i=0;i<tObjInstance.mulLineCount;i++)
				{
					if (eval( tObjInstance.formName + ".all('" + tObjInstance.instanceName + "Sel')[" + i + "].checked"))
          				{
						return i+1;
					}
				}
	        	}
		}
		else
		{
			return 0;
		}
	}
	catch(ex)
	{
		_DisplayError("在MulLine.js-->_GetSelNo函数中发生异常:" + ex,tObjInstance);
	}
	return 0;
}

/************************************************
 *方法：判断指定行是否选中，条件是canSel设置为1
 *输入：	无
 *输出：	如果选中，返回true，否则返回false
 ************************************************
 */

function _radioClick(cObj,colcount)

{

	var ele = document.getElementById("span"+this.instanceName);

	var oldPageNo = ele.getAttribute("PageNo");

	var pageNo;

	var iMax=0;

	iMax=this.mulLineCount;

	try

	{

		for(i=0;i<iMax;i++)

		{

			if(iMax==1)

			{

				pageNo = "0";

			}

			else

			{

				if (eval( this.formName + ".all('" + this.instanceName + "Sel')[" + i + "].checked"))

				{

					pageNo = i;

					break;

				}

			}

		}

		if(pageNo!=null&&pageNo!=undefined)

		{

			ele.setAttribute("PageNo",pageNo);

		}

	}

	catch(ex)

	{

		alert("_radioClick "+ex.message);

	}

	var fieldCount=colcount;

	var i=0;

	try

	{

		if(this.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				if (eval( this.formName + ".all('" + this.instanceName + "Sel').checked"))

				{

					eval( this.formName + ".all('Inp" + this.instanceName + "Sel').value='1'")

					eval( this.formName + ".all('" + this.instanceName +"Sel').className='mulnotreadonlyt'");

					eval( this.formName + ".all('" + this.instanceName +"No').className='mulnotreadonlyt'");

					for(j=1;j<fieldCount;j++)

					{

						eval( this.formName + ".all('" + this.instanceName +j+"').className='mulnotreadonlyt'");

					}

				}

				else

				{

					eval( this.formName + ".all('Inp" + this.instanceName + "Sel').value=0")

					eval( this.formName + ".all('" + this.instanceName +"Sel').className='mulreadonlyt'");

					eval( this.formName + ".all('" + this.instanceName +"No').className='mulreadonlyt'");

					for(j=1;j<fieldCount;j++)

					{

						eval( this.formName + ".all('" + this.instanceName +j+"').className='mulreadonlyt'");

					}

				}

			}

			catch(ex)

			{

				if (eval( this.formName + ".all('" + this.instanceName + "Sel')[0].checked"))

				{

					eval( this.formName + ".all('Inp" + this.instanceName + "Sel')[0].value='1'")

				}

				else

				{

					eval( this.formName + ".all('Inp" + this.instanceName + "Sel')[0].value=0")

				}

			}

		}

		else

		{

			//oldPageNo为0＆为空的时候，脚本判定的结果是一致的

			if((oldPageNo!=undefined&&oldPageNo!=null&&oldPageNo!="")||oldPageNo=="0")

			{

				eval(this.formName + ".all('Inp" + this.instanceName + "Sel')[" + oldPageNo + "].value=0");

				eval(this.formName + ".all('" + this.instanceName +"Sel')[" + oldPageNo + "].className='mulreadonlyt'");

				eval(this.formName + ".all('" + this.instanceName +"No')[" + oldPageNo + "].className='mulreadonlyt'");

				for(j=1;j<fieldCount;j++)

				{

					var tObj = this.formName + ".all('" + this.instanceName +j+"')[" + oldPageNo + "].className";

					if( eval(tObj+"=='code8'")||eval(tObj+"=='codeselect'"))

					{

						eval(tObj+"='code8'");

					}

					else

					{

						eval(tObj+"='mulreadonlyt'");

					}

				}

			}

			eval(this.formName + ".all('Inp" + this.instanceName + "Sel')[" + pageNo + "].value='1'")

			eval(this.formName + ".all('" + this.instanceName +"Sel')[" + pageNo + "].className='mulnotreadonlyt'");

			eval(this.formName + ".all('" + this.instanceName +"No')[" + pageNo + "].className='mulnotreadonlyt'");

			for(j=1;j<fieldCount;j++)

			{

				var tObj = this.formName + ".all('" + this.instanceName +j+"')[" + pageNo + "].className";

				if( eval(tObj+"=='code8'")||eval(tObj+"=='codeselect'"))

				{

					eval(tObj+"='codeselect'");

				}

				else

				{

					eval(tObj+"='mulnotreadonlyt'");

				}

			}

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_radioClick函数中发生异常:" + ex.message,this);

	}

}



/************************************************

 *方法：判断指定行是否选中，条件是canChk设置为1

 *输入：	无

 *输出：	如果选中，返回true，否则返回false

 ************************************************

 */

function _GetChkNo(cIndex,cObj)

{

	var tObj = cObj || this;

	var i=0;

	i=cIndex;

	var tReturn;

	var tStr;

	if(tObj.canChk==0)

	{

		alert("no checkBox!");

		return false;

	}

	if(cIndex<0||cIndex>=tObj.mulLineCount)

	{

		alert("在MulLine.js-->getChkNo函数中指定了错误的行:"+cIndex);

		return false;

	}

	try

	{

		if (tObj.mulLineCount>0&&i<tObj.mulLineCount)

		{

			if(tObj.mulLineCount==1)

			{

				_ResumeState();

				tStr=tObj.formName + ".all('" + tObj.instanceName + "Chk').checked";

				tReturn=eval(tStr);

				//如果得到的值为null，说明当行数为1时，有下面的可能：

				//如果是从多行删除到一行，那么可能会继续认为这个单独行是数组的一个元素，所以还要加下标

				//除上述外，可能在javaScript中还有其它因素，因此，下面可以看作对各种情况的修正：

				try

				{

					//把undefined单独提出来，是因为有的JS不支持undefined，所以要捕获例外

					if(tReturn==undefined)

					{

						try

						{

							tStr=tObj.formName + ".all('" + tObj.instanceName + "Chk')[0].checked";

							tReturn=eval(tStr);

						}

						catch(ex)

						{

							tStr=tObj.formName + ".all('" + tObj.instanceName + "Chk').checked";

							tReturn=eval(tStr);

						}

					}

				}

				catch(ex)

				{};

				if(tReturn==null)

				{

					try

					{

						tStr=tObj.formName + ".all('" + tObj.instanceName + "Chk')[0].checked";

						tReturn=eval(tStr);

					}

					catch(ex)

					{

						tStr=tObj.formName + ".all('" + tObj.instanceName + "Chk').checked";

						tReturn=eval(tStr);

					}

				}

				return tReturn;

			}

			else

			{

				if (eval( tObj.formName + ".all('" + tObj.instanceName + "Chk')[" + i + "].checked"))

				{

					return true;

				}

			}

		}

		else

		{

			return false;

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_GetChkNo函数中发生异常:" + ex,tObj);

	}

	return false;

}





/************************************************

 *方法：判断指定行是否选中，条件是canChk设置为1

 *输入：	无

 *输出：	如果选中，返回true，否则返回false

 ************************************************

 */

function _CheckBoxClick(cObj,colcount)

{

	var ele = document.getElementById("span"+this.instanceName);

	var oldPageNo = ele.getAttribute("PageNo");

	var pageNo="";

	var realNo;

	var iMax=0;

	iMax=this.mulLineCount;

	try

	{

//		alert("旧"+oldPageNo+"新"+pageNo);

		for(i=0;i<iMax;i++)

		{

			if(iMax==1)

			{

				pageNo = ",0,";

			}

			else

			{

				if (eval( this.formName + ".all('" + this.instanceName + "Chk')[" + i + "].checked"))

				{

					pageNo += ","+i+",";

					if(oldPageNo!=null&&oldPageNo!=undefined)

					{

						if(oldPageNo.indexOf(","+i+",")==-1)

						{

							realNo=i;

						}

					}

					else

					{

						realNo=i;

						break;

					}

				}

				else

				{

					if(oldPageNo!=null&&oldPageNo!=undefined)

					{

						if(oldPageNo.indexOf(","+i+",")>=0)

						{

							realNo=i;

						}

					}

				}

			}

		}

		if(pageNo!=null&&pageNo!=undefined)

		{

			ele.setAttribute("PageNo",pageNo);

		}

	}

	catch(ex)

	{

		alert("_CheckBoxClick"+ex.message);

	}

//	alert(realNo);

	var i=0;

	var fieldCount=colcount;

	try

	{

		if(this.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				if (eval( this.formName + ".all('" + this.instanceName + "Chk').checked"))

				{

					eval( this.formName + ".all('Inp" + this.instanceName + "Chk').value='1'")

					eval( this.formName + ".all('" + this.instanceName +"Chk').className='mulnotreadonlyt'");

					eval( this.formName + ".all('" + this.instanceName +"No').className='mulnotreadonlyt'");

					for(j=1;j<fieldCount;j++)

					{

						if( eval( this.formName + ".all('" + this.instanceName +j+"').className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"').className=='codeselect'"))

						{

							eval( this.formName + ".all('" + this.instanceName +j+"').className='codeselect'");

						}

						else

						{

							eval( this.formName + ".all('" + this.instanceName +j+"').className='mulnotreadonlyt'");

						}

					}

				}

				else

				{

					eval( this.formName + ".all('Inp" + this.instanceName + "Chk').value=0")

					eval( this.formName + ".all('" + this.instanceName +"Chk').className='mulreadonlyt'");

					eval( this.formName + ".all('" + this.instanceName +"No').className='mulreadonlyt'");

					for(j=1;j<fieldCount;j++)

					{

						if( eval( this.formName + ".all('" + this.instanceName +j+"').className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"').className=='codeselect'"))

						{

							eval( this.formName + ".all('" + this.instanceName +j+"').className='code8'");

						}

						else

						{

							eval( this.formName + ".all('" + this.instanceName +j+"').className='mulreadonlyt'");

						}

					}

				}

			}

			catch(ex)

			{

				if (eval( this.formName + ".all('" + this.instanceName + "Chk')[0].checked"))

				{

					eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[0].value='1'")

				}

				else

				{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[0].value=0")

				}

			}

		}

		else

		{

			if (eval( this.formName + ".all('" + this.instanceName + "Chk')[" + realNo + "].checked") & eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[" + realNo + "].value!='1'"))

            {

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[" + realNo + "].value='1'")

				eval( this.formName + ".all('" + this.instanceName +"Chk')[" + realNo + "].className='mulnotreadonlyt'");

				eval( this.formName + ".all('" + this.instanceName +"No')[" + realNo + "].className='mulnotreadonlyt'");

				for(j=1;j<fieldCount;j++)

				{

					if( eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className=='codeselect'"))

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className='codeselect'");

					}

					else

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className='mulnotreadonlyt'");

					}

				}

			}

			else if (eval( this.formName + ".all('" + this.instanceName + "Chk')[" + realNo + "].checked==false")

                    & eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[" + realNo + "].value!='0'"))

             {

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[" + realNo + "].value=0")

				eval( this.formName + ".all('" + this.instanceName +"Chk')[" + realNo + "].className='mulreadonlyt'");

				eval( this.formName + ".all('" + this.instanceName +"No')[" + realNo + "].className='mulreadonlyt'");

				for(j=1;j<fieldCount;j++)

				{

					if( eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className=='codeselect'"))

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className='code8'");

					}

					else

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + realNo + "].className='mulreadonlyt'");

					}

				}

			}

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_checkBoxClick函数中发生异常:" + ex,this);

	}

}



/************************************************

 *方法： 使所有行的checkBox变成选中的状态

 *输入：	无

 *输出：	如果选中，返回true，否则返回false

 ************************************************

 */

function _CheckBoxAll(cObj,colcount)

{

	var ele = document.getElementById("span"+this.instanceName);

	var oldPageNo = ele.getAttribute("PageNo");

	var pageNo="";

	var realNo;

	var iMax=0;

	iMax=this.mulLineCount;

	try

	{

		for(i=0;i<iMax;i++)

		{

			pageNo += ","+i+",";

		}

		if(pageNo!=null&&pageNo!=undefined)

		{

			ele.setAttribute("PageNo",pageNo);

		}

	}

	catch(ex)

	{

		alert("_CheckBoxAll"+ex.message);

	}

	var fieldCount=colcount;

	if(this.canChk==0)

	{

		alert("no checkBox!");

		return;

	}

	var i=0;

	try

	{

		try

		{

			eval( this.formName + ".all('checkAll"+this.instanceName+"').value=1");

			eval( this.formName + ".all('checkAll"+this.instanceName+"').checked=true");

		}

		catch(ex)

		{

			alert("error->_CheckBoxAll");

		}

		if(this.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk').value=1");

				eval( this.formName + ".all('" + this.instanceName + "Chk').checked=true");

				eval( this.formName + ".all('" + this.instanceName +"Chk').className='mulnotreadonlyt'");

				eval( this.formName + ".all('" + this.instanceName +"No').className='mulnotreadonlyt'");

				for(j=1;j<fieldCount;j++)

				{

					if( eval( this.formName + ".all('" + this.instanceName +j+"').className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"').className=='codeselect'"))

					{

						eval( this.formName + ".all('" + this.instanceName +j+"').className='codeselect'");

					}

					else

					{

						eval( this.formName + ".all('" + this.instanceName +j+"').className='mulnotreadonlyt'");

					}

				}

			}

			catch(ex)

			{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[0].value=1");

				eval( this.formName + ".all('" + this.instanceName + "Chk')[0].checked=true");

			}

		}

		else

		{

			for(i=0;i<iMax;i++)

			{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[" + i + "].value=1");

				eval( this.formName + ".all('" + this.instanceName + "Chk')[" + i + "].checked=true");

				eval( this.formName + ".all('" + this.instanceName +"Chk')[" + i + "].className='mulnotreadonlyt'");

				eval( this.formName + ".all('" + this.instanceName +"No')[" + i + "].className='mulnotreadonlyt'");

				for(j=1;j<fieldCount;j++)

				{

					if( eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className=='codeselect'"))

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className='codeselect'");

					}

					else

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className='mulnotreadonlyt'");

					}

				}

			}

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_checkBoxAll函数中发生异常:" + ex,this);

	}

}



/************************************************

 *方法： 使选择的行的checkBox变成选中的状态

 *输入：	行号，从1开始

 *输出：	如果选中，返回true，否则返回false

 ************************************************

 */

function _CheckBoxSel(row,cObj)

{

	if(this.canChk==0)

	{

		alert("no checkBox!");

		return;

	}

	var i=0,iMax=0;

	var rowNo=row;

	iMax=this.mulLineCount;

	if(rowNo>iMax||rowNo<=0)

	{

		alert("输入行号超出范围");

		return;

	}

	try

	{

		if(this.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk').value=1");

				eval( this.formName + ".all('" + this.instanceName + "Chk').checked=true");

			}

			catch(ex)

			{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[0].value=1");

				eval( this.formName + ".all('" + this.instanceName + "Chk')[0].checked=true");

			}

		}

		else

		{

			eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[" + (rowNo-1) + "].value=1");

			eval( this.formName + ".all('" + this.instanceName + "Chk')[" + (rowNo-1) + "].checked=true");

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_CheckBoxSel函数中发生异常:" + ex,this);

	}

}



/************************************************

 *方法：	选中所有checkBox框 和canChk属性配合用。

 *内部用:	根据checkFlag属性判断是选中所有行还是撤销所有选中。

 ************************************************

*/

function _CheckAll(cObjInstance,fieldCount)

{

	var tObjInstance;

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	if(tObjInstance.canChk==0)

	{

		alert("no checkBox!");

		return;

	}

	if(eval(this.formName + ".all('checkAll"+this.instanceName+"').checked==true"))

	{

		this.checkBoxAll(this,fieldCount);

		this.checkFlag=1;

	}

	else

	{

		this.checkBoxAllNot(this,fieldCount);

		this.checkFlag=0;

	}

}



/************************************************

 *方法： 使所有行的checkBox变成没有选中的状态

 *输入：	无

 *输出：	如果选中，返回true，否则返回false

 ************************************************

 */

function _CheckBoxAllNot(cObj,colcount)

{

	var fieldCount=colcount;

	if(this.canChk==0)

	{

		alert("no checkBox!");

		return;

	}

	var i=0,iMax=0;

	iMax=this.mulLineCount;

	var ele = document.getElementById("span"+this.instanceName);

	ele.setAttribute("PageNo","");

	try

	{

		try

		{

			eval( this.formName + ".all('checkAll"+this.instanceName+"').value=0");

			eval( this.formName + ".all('checkAll"+this.instanceName+"').checked=false");

		}

		catch(ex)

		{

			alert("error->_CheckBoxAllNot");

		}

		if(this.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk').value=0");

				eval( this.formName + ".all('" + this.instanceName + "Chk').checked=false");

				eval( this.formName + ".all('" + this.instanceName +"Chk').className='mulreadonlyt'");

				eval( this.formName + ".all('" + this.instanceName +"No').className='mulreadonlyt'");

				for(j=1;j<fieldCount;j++)

				{

					if( eval( this.formName + ".all('" + this.instanceName +j+"').className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"').className=='codeselect'"))

					{

						eval( this.formName + ".all('" + this.instanceName +j+"').className='code8'");

					}

					else

					{

						eval( this.formName + ".all('" + this.instanceName +j+"').className='mulreadonlyt'");

					}

				}

			}

			catch(ex){

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[0].value=0");

				eval( this.formName + ".all('" + this.instanceName + "Chk')[0].checked=false");

			}

		}

		else

		{

			for(i=0;i<iMax;i++)

			{

				eval( this.formName + ".all('Inp" + this.instanceName + "Chk')[" + i + "].value=0");

				eval( this.formName + ".all('" + this.instanceName + "Chk')[" + i + "].checked=false");

				eval( this.formName + ".all('" + this.instanceName +"Chk')[" + i + "].className='mulreadonlyt'");

				eval( this.formName + ".all('" + this.instanceName +"No')[" + i + "].className='mulreadonlyt'");

				for(j=1;j<fieldCount;j++)

				{

					if( eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className=='code8'")||eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className=='codeselect'"))

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className='code8'");

					}

					else

					{

						eval( this.formName + ".all('" + this.instanceName +j+"')[" + i + "].className='mulreadonlyt'");

					}

				}

			}

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_checkBoxAllNot函数中发生异常:" + ex,this);

	}

}



/************************************************

 *方法： 显示多行输入对象

 *输入：	列描述数组

 *输出：	没有

 *************************************************/

function _LoadMulLine(arrCols)

{

	//设置行模版到this.mulLineText中

	//设置标题到this.mulLineTextTitle中

	this.arraySave=arrCols;	//描述的数组信息

	_SetFieldValue(this.instanceName,arrCols,this);

	_LoadPage(this.instanceName,this);

}



/************************************************

 *方法： 显示多行输入对象

 *输入：	列描述数组

 *输出：	没有

 *************************************************/

function _LoadMulLineArr(arrCols,cData)

{

	//设置行模版到this.mulLineText中

	//设置标题到this.mulLineTextTitle中

	this.arraySave=arrCols;	//描述的数组信息

	_SetFieldValue(this.instanceName,arrCols,this);

	_LoadPageArr(this.instanceName,this,cData);

}



/************************************************
 *方法：根据传入的数组，形成每行输入域的模版
 *二维数组格式：列名，列宽，列最大值，列是否能够输入
 *************************************************/

function _SetFieldValue( strPageName, iArray,cObjInstance)
{
	var text="";
	var textTitle = "";
	cObjInstance.errorString = "";
	var boxWidth=20; //radioBox 和checkBox 定义的宽度
	var userWidth=0; //用户定义的列宽总和
	var rate=1/cObjInstance.mulLineNum;	//窗口body宽度和用户定义宽度的比率
	var fieldCount = iArray.length;
	//设置列的数目
	cObjInstance.colCount = fieldCount;
	var i =0;
	var status="";
	//判断是否禁用删除/增加 button
	//如果用户初始化选择禁用,那么模板中也随之变化
	if(cObjInstance.locked==1)
	{
		status="disabled";
	}
	try
	{
		if ( fieldCount > 0 )
		{
			//设置索引列

			var tempText0 = iArray[0][0];	//索引列的名称
			var tempText1 = iArray[0][1];	//索引列宽
			var tempText2 = iArray[0][2];	//索引列最大允许值
			var tempText4 = iArray[0][3];	//索引列是否允许输入
			var tempText5 = "";
        		var tempText6 = "";
			var tempText7 = "";
			var tempText8 = "";
			var tempText9 = "";
			var tempText10= "";
			var tempText11= "";
			var tempText12= "";
			var tempText13= "";
			var tempText14= "";
			var tempText15= "";
			var tempText16= "";
			var tempText17= "";
			var tempText18= "";
			var tempText19= "";
			var tempText20= "";
			var tempText21= "";//设置当前列是否显示时调用编码转汉字的函数，用在setRowColData函数
                        var tempText22= "";

			text="";
			if (cObjInstance.tableWidth=="")
			{
				text = text + "<table class=muline border=0 CELLSPACING=0 CELLPADDING=0>";
				textTitle = textTitle + "<table class=muline border=0 CELLSPACING=0 CELLPADDING=0>";
			}
			else
			{
				text = text + "<table class=muline ALIGN=center border=0 CELLSPACING=0 CELLPADDING=0 width='"+cObjInstance.tableWidth+"'>";
				textTitle = textTitle + "<table class=muline ALIGN=center border=0 CELLSPACING=0 CELLPADDING=1 width='"+cObjInstance.tableWidth+"'>";
			}
			text = text + "<tr>";
			textTitle = textTitle + "<tr>";

			if (cObjInstance.canSel==1)
			{
				//加上radioBox宽
				userWidth = userWidth + parseInt(boxWidth);
				if(cObjInstance.selBoxEventFuncName!=null&&cObjInstance.selBoxEventFuncName!="")
				{
//					text = text + "<td class=muline width='"+boxWidth+"'>";
					text = text + "<td class=muline>";
        				text = text + "<input type=hidden name='Inp"+ strPageName +"Sel' value=0><input class=mulcommon style='width:"+boxWidth+"' type=radio name=" + strPageName + "Sel onclick=\" " + cObjInstance.instanceName + ".radioClick(this,"+fieldCount+");" +cObjInstance.selBoxEventFuncName+"('span$PageName$$SpanId$','"+cObjInstance.selBoxEventFuncParm+"');\"";
					text = text + "</td>";
//					textTitle = textTitle + "<td class=mulinetitle style='width:"+boxWidth+"'>";
					textTitle = textTitle + "<td class=mulinetitle>";
					textTitle = textTitle + "<input class=mulinetitle readonly style='width:"+boxWidth+"'>";
					textTitle = textTitle + "</td>";
				}
				else
				{
//					text = text + "<td class=muline width='"+boxWidth+"'>";
					text = text + "<td class=muline>";
					text = text + "<input type=hidden name='Inp"+ strPageName +"Sel' value=0><input class=mulcommon style='width:"+boxWidth+"' type=radio name=" + strPageName + "Sel onclick=\"return " + cObjInstance.instanceName + ".radioClick(this,"+fieldCount+");\"";
					text = text + "</td>";
//					textTitle = textTitle + "<td class=mulinetitle width='"+boxWidth+"'>";
					textTitle = textTitle + "<td class=mulinetitle>";
					textTitle = textTitle + "<input class=mulinetitle readonly style='width:"+boxWidth+"'>";
					textTitle = textTitle + "</td>";
				}
			}
			if (cObjInstance.canChk==1)
			{
				//加上checkBox宽
				userWidth = userWidth + parseInt(boxWidth);
				if(cObjInstance.chkBoxAllEventFuncName!=null&&cObjInstance.chkBoxAllEventFuncName!="")
				{
//					textTitle = textTitle + "<td class=mulinetitle width='"+boxWidth+"'>";
			        	textTitle = textTitle + "<td class=mulinetitle>";
					textTitle = textTitle + "<input class=title type=checkbox name='checkAll"+cObjInstance.instanceName+"' onclick=\" " + cObjInstance.instanceName +".checkAll(this,"+fieldCount+");"+cObjInstance.chkBoxAllEventFuncName+"(this.checked,this);\""+" style='width:"+boxWidth+"'>";
					textTitle = textTitle + "</td>";
				}
				else
				{
//					textTitle = textTitle + "<td class=mulinetitle width='"+boxWidth+"'>";
					textTitle = textTitle + "<td class=mulinetitle>";
					textTitle = textTitle + "<input class=title type=checkbox name='checkAll"+cObjInstance.instanceName+"' onclick=\" " + cObjInstance.instanceName +".checkAll(this,"+fieldCount+");\" style='width:"+boxWidth+"'>";
				        textTitle = textTitle + "</td>";
				}
				if(cObjInstance.chkBoxEventFuncName!=null&&cObjInstance.chkBoxEventFuncName!="")
				{
//					text = text + "<td class=muline width='"+boxWidth+"'>";
				        text = text + "<td class=muline>";
					text = text + "<input type=hidden name='Inp"+ strPageName +"Chk' value=0><input class=mulcommon style='width:"+boxWidth+"' type=checkbox name=" + strPageName + "Chk onclick=\""+ cObjInstance.instanceName + ".checkBoxClick(this,"+fieldCount+");" +cObjInstance.chkBoxEventFuncName+"('span$PageName$$SpanId$','"+cObjInstance.chkBoxEventFuncParm+"');\"";
					text = text + "</td>";
				}
				else
				{
					//CheckBox不响应外部的函数
//					text = text + "<td class=muline width='"+boxWidth+"'>";
					text = text + "<td class=muline>";
					text = text + "<input type=hidden name='Inp"+ strPageName +"Chk' value=0><input class=mulcommon style='width:"+boxWidth+"' type=checkbox name=" + strPageName + "Chk onclick=\"return " + cObjInstance.instanceName + ".checkBoxClick(this,"+fieldCount+");\"";
					text = text + "</td>";
				}
			}
			tempText1 = tempText1.substr(0,tempText1.toLowerCase().indexOf("px"));
			userWidth = userWidth + parseInt(tempText1);//加上索引列宽

			text = text + "<td class=muline width='" + tempText1 + "'>";

		//	text = text + "<td class=muline>";
		//	textTitle = textTitle + "<td class=mulinetitle width='" + tempText1 + "'>"+tempText0;
			textTitle = textTitle + "<td class=mulinetitle><input class=mulinetitle readonly value='" + tempText0 + "' style='width:" + tempText1 + "'>";

			text = text + "<input class=mulreadonly name=" + strPageName + "No "+isReadOnly(tempText4)+" maxlength="
				+ tempText2 + " style='width:" + tempText1 + "' onclick=\"return " + cObjInstance.instanceName + ".detailClick(this);\" title='"+cObjInstance.detailInfo+"'>";
			text = text + "</td>";
			textTitle = textTitle + "</td>";

			for(i =1; i<fieldCount; i++)
			{
				tempText1 = iArray[i][1];	//索引列宽
				//感觉上使用javascript自带的函数效率上会好些
				tempText1 = tempText1.substr(0,tempText1.toLowerCase().indexOf("px"));
				userWidth = userWidth + parseInt(tempText1);//加上各个列宽
			}

			userWidth = userWidth + 40;	//增加宽度，没有感觉到这40px的分量
			if(userWidth<cObjInstance.windowWidth)
			{
				rate=(cObjInstance.windowWidth/userWidth)/cObjInstance.mulLineNum;
			}

			for ( i =1; i<fieldCount; i++)
			{
				tempText0 = iArray[i][0];	//索引列的名称
				tempText1 = iArray[i][1];	//索引列宽
				tempText2 = iArray[i][2];	//索引列最大允许值
				tempText4 = iArray[i][3];	//索引列是否允许输入,隐藏，代码选择
				tempText5 = iArray[i][4];	//代码引用(数据从后台数据库取)--代码名
				tempText6 = iArray[i][5];	//代码引用对应的多列 (数据从后台数据库取)
				tempText7 = iArray[i][6];	//代码引用对应的多列的内部值(数据从后台数据库取)
				tempText8 = iArray[i][7];	//对应的外部的js函数（参数是当前行的spanID,你传入的数组）
				tempText9 = iArray[i][8];	//对应的外部的js函数的第2个参数
				tempText10= iArray[i][9];	//格式校验
				tempText11= iArray[i][10];	//代码引用(数据从前台传入)--代码名
				tempText12= iArray[i][11];	//代码引用(数据从前台传入)
				tempText13= iArray[i][12];	//代码引用(数据从前台传入)--排列多列
				tempText14= iArray[i][13];	//代码引用(数据从前台传入)
				tempText15= iArray[i][14];	//用户设置该列常量
				tempText16= iArray[i][15];	//设置当前列的双击下拉显示依赖于其它控件或列的名字
				tempText17= iArray[i][16];	//设置当前列的双击下拉显示依赖于其它控件的值
				tempText18= iArray[i][17];	//设置当前列的双击下拉显示依赖于其它列的值
				tempText19= iArray[i][18];	//设置当前列的双击下调整弹出下拉框的宽度（专为codeSelect度身打造:第8个参数）
				tempText20= iArray[i][19];	//设置当前列的双击下强制刷新codeSelect数据源（专为codeSelect度身打造:第7个参数）
				tempText21= iArray[i][20];	//此处不用，用于setRowColData函数（判断该参数，是否将编码转为中文）。
                                tempText22= iArray[i][21];

                             //   if(tempText0.indexOf("*")>0){
				//	 tempText0 = tempText0.replace("(*)"," <font color=red>*</font>");
				//}

				try
				{
					if(tempText19==undefined)
					{
						tempText19=null;
					}
					if(tempText20==undefined)
					{
						tempText20=null;
					}
					if(tempText21==undefined)
					{
						tempText21=null;
					}
				}
				catch(ex)
				{
					tempText19=null;
					tempText20=null;
					tempText21=null;
				}
				if(tempText15==null)
				{
					tempText15="";
				}

				tempText1 = tempText1.substr(0,tempText1.toLowerCase().indexOf("px"));
				tempText1 = parseInt(tempText1)*rate; //用实际宽度扩充用户填充的宽度


				if(tempText4=='3')
				{
					textTitle = textTitle + "<td class=mulinetitle style=\"display:'none'\">";
					text = text + "<td class=mulinetitle style=\"display:'none'\"><input type=hidden name=" + strPageName + i + " value='"+tempText15+"' maxlength=" + tempText2 + "";
				}
				else
				{
                                    if(cObjInstance.AllowSort==true)
					{
						//textTitle = textTitle + "<td class=mulinetitle width='" + tempText1 + "'>"+tempText0;
						textTitle = textTitle + "<td class=mulinetitle><input class=mulinetitle readonly value="
							+ tempText0 + " style='cursor:hand;width :" + tempText1 + "' onclick='"+cObjInstance.allowsort+"("+strPageName+","+i+");'>";
					}
					else
					{
						//textTitle = textTitle + "<td class=mulinetitle width='" + tempText1 + "' onmouseover=_showtitle(this);>"+tempText0;
						textTitle = textTitle + "<td class=mulinetitle><input class=mulinetitle readonly value="
						+ tempText0 + " style='width :" + tempText1 + "' onmouseover=_showtitle(this);>";
					}

					text = text + "<td class=muline width='"+ tempText1 + "'><input name="

	//				text = text + "<td class=muline><input name="

						+ strPageName + i + " value='"+tempText15+"' "

						+ isReadOnly(tempText4)+" class=" + isReadOnlyClass(tempText4)

						+ " maxlength=" + tempText2 + " onmouseover=_showtitle(this); ";

				}

				if (tempText5==null)

				{

					if(tempText8!=null&&tempText8!="")

					{

						//如果引用，那么就使用自己编写的javaScript函数在.js文件中 ,（传入参数是当前行的spanID）

						text = text +" ondblclick=\""+tempText8+"('span$PageName$$SpanId$',"+tempText9+")"+";\"";

						//update-Liuliang-205-08-17

						//响应键盘回车事件调用.js文件中自己编写的javaScript函数

						text = text +" onkeyup=\"if(event.keyCode=='13'){"+tempText8+"('span$PageName$$SpanId$',"+tempText9+")"+"};\"";

					}

						if(tempText22!=null&&tempText22!="")

					{

						//如果引用，那么就使用自己编写的javaScript函数在.js文件中 ,（传入参数是当前行的spanID）

						text = text +" onchange=\""+tempText22+"('span$PageName$$SpanId$',"+tempText9+")"+";\"";

						//update-Liuliang-205-08-17

						//响应键盘回车事件调用.js文件中自己编写的javaScript函数

						text = text +" onkeyup=\"if(event.keyCode=='13'){"+tempText22+"('span$PageName$$SpanId$',"+tempText9+")"+"};\"";

					}

				}

				else

				{

					if(tempText6==null||tempText7==null)

					{

						//如果代码引用只应用在1列上

						if(tempText16==null)

						{

							//如果不根据其它控件或列做判断

							if(tempText20==null&&tempText19==null)

							{

								text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this]);\"";

								text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this]);\"";

							}

							else

							{

								if(tempText19==null)

								{

									text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,null,null,"+tempText20+");\"";

									text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,null,null,"+tempText20+");\"";

								}

								else

								{

									text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,null,null,"+tempText20+","+tempText19+");\"";

									text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,null,null,"+tempText20+","+tempText19+");\"";

								}

							}

						}

						else

						{

							if(tempText17!=null&&tempText17!="")

							{

								//如果根据其它空间的值做判断

								if(tempText20==null&&tempText19==null)

								{

									text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,'"+tempText17+"','"+tempText16+"');\"";

									text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,'"+tempText17+"','"+tempText16+"');\"";

								}

								else

								{

									if(tempText19==null)

									{

										text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,'"+tempText17+"','"+tempText16+"',"+tempText20+");\"";

										text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,'"+tempText17+"','"+tempText16+"',"+tempText20+");\"";

									}

									else

									{

										text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,'"+tempText17+"','"+tempText16+"',"+tempText20+","+tempText19+");\"";

										text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,'"+tempText17+"','"+tempText16+"',"+tempText20+","+tempText19+");\"";

									}

								}

							}

							else

							{

								if(tempText18!=null&&tempText18!="")

								{

									//如果根据其它列的值做判断

									var tempValue="[";

									arrText18=tempText18.split(FIELDDELIMITER);

									for(var m=0;m<arrText18.length;m++)

									{

										tempValue=tempValue+cObjInstance.formName+".all('span$PageName$$SpanId$')"+".all('"+"$PageName$"+arrText18[m]+"').value";

										if(m!=arrText18.length-1)

										{

											tempValue=tempValue+",";

										}

									}

									tempValue=tempValue+"]";



									if(tempText20==null&&tempText19==null)

									{

										text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,"+tempValue+",'"+tempText16+"');\"";

										text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,"+tempValue+",'"+tempText16+"');\"";

									}

									else

									{

										if(tempText19==null)

										{

											text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,"+tempValue+",'"+tempText16+"',"+tempText20+");\"";

											text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,"+tempValue+",'"+tempText16+"',"+tempText20+");\"";

										}

										else

										{

											text = text +" ondblclick=\"return showCodeList('"+tempText5+"',[this],null,null,"+tempValue+",'"+tempText16+"',"+tempText20+","+tempText19+");\"";

											text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',[this],null,null,"+tempValue+",'"+tempText16+"',"+tempText20+","+tempText19+");\"";

										}

									}

								}

							}

						}

					}

					else

					{

						//如果代码引用应用在多列上，次方法目前好像行不通

						var arrColName="["; //对应列的集合的格式

						var arrCodeName="["; //对应代码选择的项的名称

						//分割数组，得到对应列数的数组

						var arrayField=tempText6.split(FIELDDELIMITER);

						var arrayCode =tempText7.split(FIELDDELIMITER);

						//格式化代码选择数组 从 0|1 转到[0,1]

						for(var m=0;m<arrayCode.length;m++)

						{

							arrCodeName=arrCodeName+arrayCode[m];

							if(m!=arrayCode.length-1)

							{

								arrCodeName=arrCodeName+",";

							}

						}

						arrCodeName=arrCodeName+"]";

						//格式化列对象数组 从0|1 转到[列对象，列对象]

						for(var n=0;n<arrayField.length;n++)

						{

							//arrColName=fm.all('spanXXXID').all('XXX+Col') 即对应spanID的列对象

							arrColName=arrColName+cObjInstance.formName+".all('span$PageName$$SpanId$')"+".all('"+"$PageName$"+ arrayField[n]+"')";

							if(n!=arrayField.length-1)

							{

								arrColName=arrColName+",";

							}

						}

						arrColName=arrColName+"]";

						if(tempText16==null|| tempText16=="")

						{

							//如果不根据其它控件或列做判断

							text = text +" ondblclick=\"return showCodeList('"+tempText5+"',"+arrColName+","+arrCodeName+",null,null,null,"+tempText20+","+tempText19+");\"";

							text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',"+arrColName+","+arrCodeName+",null,null,null,"+tempText20+","+tempText19+");\"";

						}

						else

						{

							if(tempText17!=null&&tempText17!="")

							{

								//如果根据其它空间的值做判断

								text = text +" ondblclick=\"return showCodeList('"+tempText5+"',"+arrColName+","+arrCodeName+",null,'"+tempText17+"','"+tempText16+"',"+tempText20+","+tempText19+");\"";

								text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',"+arrColName+","+arrCodeName+",null,'"+tempText17+"','"+tempText16+"',"+tempText20+","+tempText19+");\"";

							}

							else

							{

								if(tempText18!=null&&tempText18!="")

								{

									//如果根据其它列的值做判断

									var tempValue="[";

									arrText18=tempText18.split(FIELDDELIMITER);

									for(var m=0;m<arrText18.length;m++)

									{

										tempValue=tempValue+cObjInstance.formName+".all('span$PageName$$SpanId$')"+".all('"+"$PageName$"+arrText18[m]+"').value";

										if(m!=arrText18.length-1)

										{

											tempValue=tempValue+",";

										}

									}

									tempValue=tempValue+"]";

									text = text +" ondblclick=\"return showCodeList('"+tempText5+"',"+arrColName+","+arrCodeName+",null,"+tempValue+",'"+tempText16+"',"+tempText20+","+tempText19+");\"";

									text = text +" onkeyup=\"return showCodeListKey('"+tempText5+"',"+arrColName+","+arrCodeName+",null,"+tempValue+",'"+tempText16+"',"+tempText20+","+tempText19+");\"";

								}

							}

						}

					}

				}

				//如果前面的数组第5,6,7,8,9项是空，那么判断第10项即代码引用是否可用

				if(tempText5==null&&tempText6==null&&tempText7==null&&tempText8==null&&tempText9==null)

				{

					if(tempText12!=null&& tempText12!=""&&tempText11!=null&&tempText11!="")

					{

						if(tempText13==null||tempText14==null)

						{

							//只对应当前单列代码选择

							if(tempText20==null&&tempText19==null)

							{

								text = text +"CodeData='"+tempText12+"' ondblClick=\"showCodeListEx('"+tempText11+"',[this]);\" ";

								text = text +"onkeyup=\"showCodeListKeyEx('"+tempText11+"',[this]);\" ";

							}

							else

							{

								if(tempText19==null)

								{

									text = text +"CodeData='"+tempText12+"' ondblClick=\"showCodeListEx('"+tempText11+"',[this],null,null,null,null,"+tempText20+");\" ";

									text = text +"onkeyup=\"showCodeListKeyEx('"+tempText11+"',[this],null,null,null,null,"+tempText20+");\" ";

								}

								else

								{

									text = text +"CodeData='"+tempText12+"' ondblClick=\"showCodeListEx('"+tempText11+"',[this],null,null,null,null,"+tempText20+","+tempText19+");\" ";

									text = text +"onkeyup=\"showCodeListKeyEx('"+tempText11+"',[this],null,null,null,null,"+tempText20+","+tempText19+");\" ";

								}

							}

						}

						else

						{

							//对应多列或者不是当前列代码选择

							var arrColName="["; //对应列的集合的格式

							var arrCodeName="["; //对应代码选择的项的名称

							//分割数组，得到对应列数的数组

							var arrayField=tempText13.split(FIELDDELIMITER);

							var arrayCode =tempText14.split(FIELDDELIMITER);

							//格式化代码选择数组 从 0|1 转到[0,1]

							for(var m=0;m<arrayCode.length;m++)

							{

								arrCodeName=arrCodeName+arrayCode[m];

								if(m!=arrayCode.length-1)

								{

									arrCodeName=arrCodeName+",";

								}

							}

							arrCodeName=arrCodeName+"]";

							//格式化列对象数组 从0|1 转到[列对象，列对象]

							for(var n=0;n<arrayField.length;n++)

							{

								//arrColName=fm.all('spanXXXID').all('XXX+Col') 即对应spanID的列对象

								arrColName=arrColName+cObjInstance.formName+".all('span$PageName$$SpanId$')"+".all('"+"$PageName$"+ arrayField[n]+"')";

								if(n!=arrayField.length-1)

								{

									arrColName=arrColName+",";

								}

							}

							arrColName=arrColName+"]";

							text = text +"CodeData='"+tempText12+"' ondblclick=\"return showCodeListEx('" + tempText11 + "',"+arrColName+","+arrCodeName+",null,null,null,"+tempText20+","+tempText19+");\" ";

							text = text +"onkeyup=\"return showCodeListKeyEx('" + tempText11 + "',"+arrColName+","+arrCodeName+",null,null,null,"+tempText20+","+tempText19+");\"";

						}

					}

				}

				if(tempText10!=null && tempText10!="")

				{

					//如果需要校验

					textTitle = textTitle + "<input type=hidden name="+strPageName+"verify"+i+" value='" + tempText10 + "'>";

					text = text + " verify='" + tempText10 + "'";

				}

				else

				{

					textTitle = textTitle + "<input type=hidden name="+strPageName+"verify"+i+" value=''>";

				}

//				text = text + " onkeyup='return " + cObjInstance.instanceName + ".keyUp(\"$PageName$\");'";

				text = text + " style='width:" + tempText1 + "'>";

				text = text + "</td>";

				textTitle = textTitle + "</td>";

			}

			if(cObjInstance.hiddenSubtraction==0)

			{

				//如果隐藏减号"-"的标志=0，那么显示，否则隐藏

				text = text + "<td class=muline>";

				textTitle = textTitle + "<td class=mulinetitle width=15><input class=mulinetitle disabled readonly value='-' style='width :15'></td>";

				//请注意，下面这行的格式是不能随意改动的，它和_Lock(),UnLock()函数密切相关

				//如果改动下面这行，则必须修改_Lock(),UnLock()函数的相关部分

				text = text + "<input class=button type=button "+status+" value='-' name='$PageName$Del' ";

				//如果需要点击-号响应外部函数

				if(cObjInstance.delEventFuncName!=null&&cObjInstance.delEventFuncName!="")
				{

                                        text = text + " onclick=' return "
                                        	+cObjInstance.delEventFuncName+"(\"span$PageName$$SpanId$\",\""+cObjInstance.delEventFuncParm+"\");"
                                                 + cObjInstance.instanceName + ".deleteOne(\"$PageName$\",span$PageName$$SpanId$);"
                                                +"'>";
                                       // alert(text1)
   				}

				else

				{

					text = text + " onclick='return " + cObjInstance.instanceName + ".deleteOne(\"$PageName$\",span$PageName$$SpanId$);'>";

				}

				text = text + "<input type=hidden name=$PageName$SpanID value=span$PageName$$SpanId$>";

				text = text + "</td>";

			}

			else

			{

				text = text + "<td class=muline style='display:none'>";

				textTitle = textTitle + "<td class=mulinetitle width=15 style='display:none'><input class=mulinetitle type=hidden readonly value='-' style='width :15'></td>";

				//请注意，下面这行的格式是不能随意改动的，它和_Lock(),UnLock()函数密切相关

				//如果改动下面这行，则必须修改_Lock(),UnLock()函数的相关部分0

				text = text + "<input class=button type=button "+status+" value='-' name='$PageName$Del' style='display:none'";

				text = text + " onclick='return " + cObjInstance.instanceName + ".deleteOne(\"$PageName$\",span$PageName$$SpanId$);'>";

				text = text + "<input type=hidden name=$PageName$SpanID value=span$PageName$$SpanId$>";

				text = text + "</td>";

			}

			text = text + "</tr>";

			textTitle = textTitle + "</tr>";

			text = text + "</table>";

			textTitle = textTitle + "</table>";

		}

		cObjInstance.mulLineText=text;	//行内容

//		fm.all('tt').value = text;

		cObjInstance.mulLineTextTitle = textTitle;	//行标题

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_SetFieldValue函数中发生异常:" + ex,cObjInstance);

	}

}



/************************************************

 *方法：多行输入区的初始化

 *************************************************/

function _LoadPage(strPageName,cObjInstance)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

//	var innerHTML="";

	var tHTML="";

	cObjInstance.errorString="";



//	var status="";

	var tStatus="";

	//判断是否禁用删除/增加 button

	//如果用户初始化选择禁用,那么模板中也随之变化

	if(cObjInstance.locked==1)

	{

		tStatus="disabled";

	}



	if (cObjInstance.displayTitle==1)

	{

		tHTML = tHTML + cObjInstance.mulLineTextTitle;

	}

	tHTML = tHTML + "<span id='span"+t_StrPageName+"Field'></span>";



	if(cObjInstance.hiddenPlus==0)

	{

		//如果添加一行标志"+"不隐藏

		tHTML = tHTML + "<div align=left>";

		if(cObjInstance.addEventFuncName!=null&&cObjInstance.addEventFuncName!="")

		{

			tHTML = tHTML + "<input class=button type=button name='"+t_StrPageName + "addOne' value='+' "+tStatus+" onclick=\" " + cObjInstance.instanceName + ".addOne('" + t_StrPageName + "'); "+cObjInstance.instanceName+".moveFocus(); "

				+cObjInstance.addEventFuncName+"('span$PageName$$SpanId$','"+cObjInstance.addEventFuncParm+"');\">";

		}

		else

		{

			tHTML = tHTML + "<input type=button class=button name='"+t_StrPageName + "addOne' value='+' "+tStatus+" onclick=\" " + cObjInstance.instanceName + ".addOne('" + t_StrPageName + "'); "+cObjInstance.instanceName+".moveFocus();\">";

		}

		tHTML = tHTML + "</div>";

	}

	else

	{

		//隐藏添加一行标志"+"

		tHTML = tHTML + "<div align=left>";

		tHTML = tHTML + "<input type=button class=button style='display:none' name='" + t_StrPageName + "addOne' value='+' "+tStatus+" onclick=\" " + cObjInstance.instanceName + ".addOne('" + t_StrPageName + "');"+cObjInstance.instanceName+".moveFocus();\">";

		tHTML = tHTML + "</div>";

	}



	try

	{

		document.all("span"+t_StrPageName).innerHTML=tHTML;

//		fm.all('tt').value = tHTML;

		_AddOne(cObjInstance.instanceName,cObjInstance.mulLineCount,cObjInstance);

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_LoadPage函数中发生异常:" + ex,cObjInstance);

	}

}



/************************************************

 *方法：多行输入区的初始化

 *************************************************/

function _LoadPageArr(strPageName,cObjInstance,cData)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

//	var innerHTML="";

	var tHTML="";

	cObjInstance.errorString="";



//	var status="";

	var tStatus="";

	//判断是否禁用删除/增加 button

	//如果用户初始化选择禁用,那么模板中也随之变化

	if(cObjInstance.locked==1)

	{

		tStatus="disabled";

	}



	if (cObjInstance.displayTitle==1)

	{

		tHTML = tHTML + cObjInstance.mulLineTextTitle;

	}

	tHTML = tHTML + "<span id='span"+t_StrPageName+"Field'></span>";



	if(cObjInstance.hiddenPlus==0)

	{

		//如果添加一行标志"+"不隐藏

		tHTML = tHTML + "<div align=left>";

		if(cObjInstance.addEventFuncName!=null&&cObjInstance.addEventFuncName!="")

		{

			tHTML = tHTML + "<input class=button type=button name='"+t_StrPageName + "addOne' value='+' "+tStatus+" onclick=\" " + cObjInstance.instanceName + ".addOne('" + t_StrPageName + "'); "+cObjInstance.instanceName+".moveFocus(); "

				+cObjInstance.addEventFuncName+"('span$PageName$$SpanId$','"+cObjInstance.addEventFuncParm+"');\">";

		}

		else

		{

			tHTML = tHTML + "<input type=button class=button name='"+t_StrPageName + "addOne' value='+' "+tStatus+" onclick=\" " + cObjInstance.instanceName + ".addOne('" + t_StrPageName + "'); "+cObjInstance.instanceName+".moveFocus();\">";

		}

		tHTML = tHTML + "</div>";

	}

	else

	{

		//隐藏添加一行标志"+"

		tHTML = tHTML + "<div align=left>";

		tHTML = tHTML + "<input type=button class=button style='display:none' name='" + t_StrPageName + "addOne' value='+' "+tStatus+" onclick=\" " + cObjInstance.instanceName + ".addOne('" + t_StrPageName + "');"+cObjInstance.instanceName+".moveFocus();\">";

		tHTML = tHTML + "</div>";

	}



	try

	{

		document.all("span"+t_StrPageName).innerHTML=tHTML;

//		fm.all('tt').value = tHTML;

		_AddOneArr(cObjInstance.instanceName,cObjInstance.mulLineCount,cObjInstance,cData);

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_LoadPage函数中发生异常:" + ex,cObjInstance);

	}

}



/************************************************

 *方法：添加一行(外部/内部调用)

 ************************************************

 */

function _AddOne(strPageName,intNumber,cObjInstance)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	var i,j;

	var strText;	//每行内容

	var strFunctionName="";	//在执行完addone后调用的函数名

	var spanID=-1;	//spanID序号

	var intCount;	//添加的行个数

	var tObjInstance;	//对象指针

	var isInit;	//判断是否是在初始化过程中



	if (cObjInstance==null)

	{

		tObjInstance=this;

		isInit = false;

	}

	else

	{

		tObjInstance=cObjInstance;

		isInit = true;

	}



	tObjInstance.errorString="";



	(intNumber==null)?intCount=1:intCount=intNumber;	//得到行的个数



	//对变量赋值

	strText = tObjInstance.mulLineText;

	spanID = tObjInstance.maxSpanID;

	try

	{

		//得到原来的内容

		var strOldText=document.all("span"+t_StrPageName+"Field").innerHTML;



		//添加intCount行

		for(i=1;i<=intCount;i++)

		{

			spanID++;

			tObjInstance.maxSpanID=spanID;

			strText = tObjInstance.mulLineText;

//			strText = replace(strText,"$PageName$",t_StrPageName);

//			strText = replace(strText,"$SpanId$",spanID);

			strText = strText.replace(/\$PageName\$/g,t_StrPageName);

			strText = strText.replace(/\$SpanId\$/g,spanID);

			//strText = replace(strText,"$i$",tObjInstance.mulLineCount+1);

			strText = "<span id='span"+t_StrPageName+spanID+"'>"+strText+"</span>";

			strOldText=strOldText+strText;

		}

		if (!isInit)

		{

			//如果是初始化，行数已经指定

			tObjInstance.mulLineCount =tObjInstance.mulLineCount + intCount;

		}

		//加载变化后的文本

		document.all("span"+t_StrPageName+"Field").innerHTML=strOldText;

		_ModifyCount(tObjInstance.formName,t_StrPageName,tObjInstance.mulLineCount,tObjInstance);	//调用函数名为strFunctionName的函数

//		fm.all('tt').value=strOldText;

		//注意顺序，必须是在加载变化后的文本后指定焦点

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_AddOne函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *方法：添加一行(外部/内部调用)

 ************************************************

 */

function _AddOneArr(strPageName,intNumber,cObjInstance,cData)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	var i,j;

	var strText;	//每行内容

	var strFunctionName="";	//在执行完addone后调用的函数名

	var spanID=-1;	//spanID序号

	var intCount;	//添加的行个数

	var tObjInstance;	//对象指针

	var isInit;	//判断是否是在初始化过程中



	if (cObjInstance==null)

	{

		tObjInstance=this;

		isInit = false;

	}

	else

	{

		tObjInstance=cObjInstance;

		isInit = true;

	}



	tObjInstance.errorString="";



	(intNumber==null)?intCount=1:intCount=intNumber;	//得到行的个数



	//对变量赋值

	strText = tObjInstance.mulLineText;

	spanID = tObjInstance.maxSpanID;

	try

	{

		//得到原来的内容

		var strOldText=document.all("span"+t_StrPageName+"Field").innerHTML;



		//添加intCount行

		for(i=1;i<=intCount;i++)

		{

			spanID++;

			tObjInstance.maxSpanID=spanID;

			strText = tObjInstance.mulLineText;

//			strText = replace(strText,"$PageName$",t_StrPageName);

//			strText = replace(strText,"$SpanId$",spanID);

			strText = strText.replace(/\$PageName\$/g,t_StrPageName);

			strText = strText.replace(/\$SpanId\$/g,spanID);

			for(j=0;j<cData[i-1].length;j++)

			{

//				if(cData[i-1][j]=="")

//				{

//					cData[i-1][j]=" ";

//				}

				k=j+1;

				strText = strText.replace(t_StrPageName + k + " value=''",t_StrPageName + k + " value='"+cData[i-1][j]+"'");

			}

			//strText = replace(strText,"$i$",tObjInstance.mulLineCount+1);

			strText = "<span id='span"+t_StrPageName+spanID+"'>"+strText+"</span>";

			strOldText=strOldText+strText;

		}

		if (!isInit)

		{

			//如果是初始化，行数已经指定

			tObjInstance.mulLineCount =tObjInstance.mulLineCount + intCount;

		}

		//加载变化后的文本

		document.all("span"+t_StrPageName+"Field").innerHTML=strOldText;

		_ModifyCount(tObjInstance.formName,t_StrPageName,tObjInstance.mulLineCount,tObjInstance);	//调用函数名为strFunctionName的函数

//		fm.all('tt').value=strOldText;

		//注意顺序，必须是在加载变化后的文本后指定焦点

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_AddOne函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *方法：删除一行(外部/内部调用)

 ************************************************

 */

function _DeleteOne(strPageName,spanID,cObjInstance)

{

	var tStr;

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	var tObjInstance;	//对象指针

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

		var spanName=spanID;

		spanID=eval(tObjInstance.formName+".all('" + spanName + "')");


	}

	tObjInstance.errorString="";

	var spanObj=eval(tObjInstance.formName+".all('span" + t_StrPageName + "')");

	try

	{

		spanID.innerHTML="";

		tObjInstance.errorString="";

		tObjInstance.mulLineCount = tObjInstance.mulLineCount - 1;

		tStr="<SPAN id="+spanID.id+"></SPAN>";

//		spanObj.innerHTML=replace(spanObj.innerHTML,tStr,"");

		spanObj.innerHTML=spanObj.innerHTML.replace(tStr,"");

		_ModifyCount(tObjInstance.formName,t_StrPageName ,tObjInstance.mulLineCount,tObjInstance);

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_DeleteOne函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *方法：按Enter或↓添加一行

 ************************************************

 */

function _KeyUp(strPageName)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	if (( window.event.keyCode==40 ) || ( window.event.keyCode==13 ))

	{}

}



/************************************************

 *方法：移动焦点到新增行

 ************************************************

 */

function _MoveFocus(Col,cObjInstance)

{

	var cCol;

	var tObjInstance;	//对象指针

	if (cObjInstance==null||cObjInstance=='')

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";

	cRow=tObjInstance.mulLineCount-1;	//行号从0开始

	if(Col==""||Col==null)

	{

		cCol = 1;

	}

	else

	{

		cCol=Col;

	}

	try

	{

		tObjInstance.setFocus(cRow,cCol,tObjInstance);

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_MoveFocus函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *方法：得到错误信息

 ************************************************

 */

function _GetErrStr()

{

	return this.errorString;

}



/************************************************

 *方法：修改索引信息(内部调用)

 ************************************************

 */

function _ModifyCount(iFormName,iStrPageName,iCount,cObjInstance)

{

	var t_StrPageName = iStrPageName||this.instanceName;	//实例名称

	//每次初始化数据完毕的时候，需要对PageNo对象进行初始化，呵呵，这样比较好的说

	var ele = document.getElementById("span"+t_StrPageName);

	ele.setAttribute("PageNo","");

	var tObjInstance;	//对象指针

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	var i;

	var len = iCount;

	var No;

	try

	{

		//注意，这里对应_SetRowColData函数的行为

		if (iCount==1)

		{

			No=tObjInstance.recordNo+1;

			try

			{

				eval( iFormName + ".all('" + t_StrPageName + "No').value="+No );

			}

			catch(ex)

			{

				eval( iFormName + ".all('" + t_StrPageName + "No')[0].value="+No );

			}

			//如果下面这样，将会出现异常：参见_SetRowColData函数的行为。

		}

		else

		{

			if(!isNaN(len))

			{

				for(i=1;i<=len;i++)

				{

					No=tObjInstance.recordNo+i;

					eval( iFormName + ".all('" + t_StrPageName + "No')[i-1].value="+No );

					//这里可以用下标引用，可能是行数iCount>1，所以看作数组，=1的时候，不能用下标，当作普通类型

				}

			}

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_ModifyCount函数中发生异常:" + ex,cObjInstance);

	}

}



/************************************************

 *方法：判断是否是只读属性

 *输入：如果参数为0，函数返回"readonly",否则返回""

 ************************************************

 */

function isReadOnly(strReadOnly)

{

	var tempText;

	if (strReadOnly=="0")

	{

		tempText = "readonly";

	}

	else

	{

		tempText = "";

	}

	return tempText;

}



/************************************************

 *方法：判断显示属性

 *输入：如果参数为0，函数返回"readonly",否则返回""

 ************************************************

 */

function isReadOnlyClass(strReadOnly)

{

	var tempText;

	if (strReadOnly=="0" )

	{

		tempText = "mulreadonly";

	}

	else if (strReadOnly=="2")

		{

			tempText = "code8";

		}

		else

		{

			tempText = "mulcommon";

		}

	return tempText;

}



/************************************************

 *方法：显示多行输入的错误信息

 *输入：	strError 需要显示的错误信息

 *			cObj	实例指针

 *输出：	没有

 ************************************************

 */

function _DisplayError(strError,cObj)

{

	cObj.errorString=strError;

	alert(strError);

}



/************************************************

 *得到指定行列的数据(外部/内部调用)

 *输入：	cRow:  行

 *			cCol:  列

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用子函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	指定行，列的值

 ************************************************

 */

function _GetRowColData(cRow,cCol,cObjInstance)

{

	var tStr,tReturn;

	var tObjInstance;	//对象指针

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";

	if(cRow<0||cRow>=tObjInstance.mulLineCount)

	{

		alert("在MulLine.js-->getRowColData() 中指定了错误的行："+cRow);

		tReturn="";

		return trim(tReturn);

	}



	if(cCol<0||cCol>=tObjInstance.colCount)

	{

		alert("在MulLine.js-->getRowColData() 中指定了错误的列："+cCol);

		tReturn="";

		return trim(tReturn);

	}



	try

	{

		//注意：必须添加下面的判断条件，否则在初始化为0行时，会出现异常

		if(tObjInstance.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"').value";

				tReturn=eval(tStr);

			}

			catch(ex)

			{

				tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')[0].value";

				tReturn=eval(tStr);

			}

			//如果得到的值为null或者undefined，说明当行数为1时，有下面的可能：

			//如果是从多行删除到一行，那么可能会继续认为是数组的一个元素，所以还要加下标

			//除上述外，可能在javaScript中还有其它因素，因此，可以看作对各种情况的修正：

			try

			{

				//把undefined单独提出来，是因为有的JS不支持undefined，所以要捕获例外

				if(tReturn==undefined)

				{

					try

					{

						tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')[0].value";

						tReturn=eval(tStr);

					}

					catch(ex)

					{

						tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"').value";

						tReturn=eval(tStr);

					}

				}

			}

			catch(ex)

			{}

			if(tReturn==null)

			{

				try

				{

					tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')[0].value";

					tReturn=eval(tStr);

				}

				catch(ex)

				{

					tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"').value";

					tReturn=eval(tStr);

				}

			}

			//即使通过上面的转换，还是存在漏洞，返回值依然可能是null或者undefined

			//因此对传出去的值应该先判断是否null或者undefined

		}

	}

	catch(ex)

	{}



	try

	{

		if(tObjInstance.mulLineCount>1)

		{

			tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')["+cRow+"].value";

			tReturn=eval(tStr);

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_GetRowColData函数中发生异常:" + ex,tObjInstance);

	}



	//通过转换后，依然会有特殊值。对javascript的这个特点尚不清楚，为安全性必须加以验证

	try

	{

		//把undefined单独提出来，是因为有的JS不支持undefined，所以要捕获例外

		if(tReturn==undefined)

		{

			tReturn="";

		}

	}

	catch(ex)

	{}



	try

	{

		if(tReturn==null)

		{

			tReturn="";

		}

	}

	catch(ex)

	{

		tReturn="";

	}



	return trim(tReturn);

}



/************************************************

 *得到指定行的数据(外部/内部调用)

 *输入：	cRow:  行

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用子函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	返回该行的输组

 ************************************************

 */

function _GetRowData(cRow,cObjInstance)

{

	var tStr,tReturn,n,cCol;

	var tObjInstance;	//对象指针

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";

	if(cRow<0||cRow>=tObjInstance.mulLineCount)

	{

		alert("在MulLine.js-->getRowColData() 中指定了错误的行："+cRow);

		tReturn="";

		return trim(tReturn);

	}

	var iArray = new Array();//返回的数组

	for(n=1;n<tObjInstance.colCount;n++)

	{

		cCol=n;

		try

		{

			//注意：必须添加下面的判断条件，否则在初始化为0行时，会出现异常

			if(tObjInstance.mulLineCount==1)

			{

				_ResumeState();

				try

				{

					tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"').value";

					tReturn=eval(tStr);

				}

				catch(ex)

				{

					tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')[0].value";

					tReturn=eval(tStr);

				}

				//如果得到的值为null或者undefined，说明当行数为1时，有下面的可能：

				//如果是从多行删除到一行，那么可能会继续认为是数组的一个元素，所以还要加下标

				//除上述外，可能在javaScript中还有其它因素，因此，可以看作对各种情况的修正：

				try

				{

					//把undefined单独提出来，是因为有的JS不支持undefined，所以要捕获例外

					if(tReturn==undefined)

					{

						try

						{

							tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')[0].value";

							tReturn=eval(tStr);

						}

						catch(ex)

						{

							tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"').value";

							tReturn=eval(tStr);

						}

					}

				}

				catch(ex)

				{}

				if(tReturn==null)

				{

					try

					{

						tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')[0].value";

						tReturn=eval(tStr);

					}

					catch(ex)

					{

						tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"').value";

						tReturn=eval(tStr);

					}

				}

				//即使通过上面的转换，还是存在漏洞，返回值依然可能是null或者undefined

				//因此对传出去的值应该先判断是否null或者undefined

			}

		}

		catch(ex)

		{}

		try{

			if(tObjInstance.mulLineCount>1)

			{

				tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+cCol+"')["+cRow+"].value";

				tReturn=eval(tStr);

			}

		}

		catch(ex)

		{

			_DisplayError("在MulLine.js-->_GetRowColData函数中发生异常:" + ex,tObjInstance);

			return;

		}

		//通过转换后，依然会有特殊值。对javascript的这个特点尚不清楚，为安全性必须加以验证

		try

		{

			//把undefined单独提出来，是因为有的JS不支持undefined，所以要捕获例外

			if(tReturn==undefined)

			{

				tReturn="";

			}

		}

		catch(ex)

		{}



		try{

			if(tReturn==null)

			{

				tReturn="";

			}

		}

		catch(ex)

		{

			tReturn="";

		}

		iArray[n-1]=trim(tReturn);

	}

	return iArray;

}



/************************************************

 *设置指定行列的数据(外部/内部调用)

 *输入：	cRow:  行

 *			cCol:  列

 *			cData: 数据

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用子函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	没有

 ************************************************

 */

function _SetRowColData(cRow,cCol,cData,cObjInstance)

{

	var tStr;

	var tObj;

	var tReturn=false;

	var tObjInstance;	//对象指针

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";

	if(cData==null)

	{

		cData="";

	}

	if(cRow<0||cRow>=tObjInstance.mulLineCount)

	{

		alert("在MulLine.js-->setRowColData() 时指定了错误的行:"+cRow);

		return tReturn;

	}

	if(cCol<0||cCol>=tObjInstance.colCount)

	{

		alert("在MulLine.js-->setRowColData() 时指定了错误的列:"+cCol);

		return tReturn;

	}

	try

	{

//		var newData=replace(cData,"\r\n","");

		//好像是初始化行数用

		var newData=cData.replace("\r\n","");

		//注意：必须添加下面的判断条件，否则在初始化为0行时，会出现异常

		if(tObjInstance.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				tStr=tObjInstance.formName + ".all('" + tObjInstance.instanceName+cCol + "').value='"+newData +"'";

			}

			catch(ex)

			{

				tStr=tObjInstance.formName + ".all('" + tObjInstance.instanceName+cCol + "')[0].value='"+newData +"'";

			}

		}

		else

		{

			if(tObjInstance.mulLineCount>1)

			{

				tStr=tObjInstance.formName + ".all('" + tObjInstance.instanceName+cCol + "')["+cRow+"].value='"+newData +"'";

			}

		}

		eval(tStr);

		tReturn=true;

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_SetRowColData函数中发生异常:" + ex,tObjInstance);

	}

	return tReturn;

}



/************************************************

 *清空Muline的数据(可外部/内部调用)

 *输入：	strPageName:  页面上span后面所跟的字符串

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用字函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	没有

 ************************************************

 */

function _ClearData(strPageName,cObjInstance)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	var strNewText="";

	var tObjInstance;	//对象指针

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";

	try

	{

		document.all("span"+t_StrPageName+"Field").innerHTML=strNewText;

		tObjInstance.mulLineCount = 0;

		tObjInstance.maxSpanID = -1;

		try

		{

			if(tObjInstance.checkFlag==1&&tObjInstance.canChk==1)

			{

				tObjInstance.checkFlag=0;

				eval( tObjInstance.formName + ".all('checkAll"+tObjInstance.instanceName+"').checked=false");

			}

		}

		catch(ex)

		{}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_clearData函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *将Muline的空白行清处(可以外部/内部调用)

 *输入：	strPageName:页面上Muline的对象名，不能为空

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用字函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	没有

 ************************************************

 */

function _DelBlankLine(strPageName,cObjInstance)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称



	var tObjInstance;

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}



	tObjInstance.errorString="";



	var rowCount = tObjInstance.mulLineCount;	//行数

	var colCount = tObjInstance.colCount;	//列数



	var i,j;

	var blankFlag=true;	//空行标志

	var lineSpanID;	//行的spanID

	var data="";

	try

	{

		//循环查询每一行是否为空行,即该行的每一列都为空，除了0列（序号列）

		for(i=0;i<rowCount;i++)//从行开始循环,0行开始

		{

			for(j=1;j<colCount;j++)

			{

				//从列开始循环，1列开始

				data = _GetRowColData(i,j,tObjInstance);

				if(data!=null&&data!="")

				{

					//如果不为空，空行标志设为false

					blankFlag=false;

					break;

				}

			}

			if(blankFlag)

			{

				lineSpanID=_FindSpanID(i,tObjInstance);  //得到该行的spanID

				_DeleteOne(t_StrPageName,lineSpanID,tObjInstance); //删除这一行

				//删除一行，循环减一

				rowCount=rowCount-1;

				//回退一行检查

				i=i-1;

			}

			blankFlag=true;

		}

		try

		{

			if(tObjInstance.checkFlag==1&&tObjInstance.canChk==1)

			{

				tObjInstance.checkFlag=0;

				eval( tObjInstance.formName + ".all('checkAll"+tObjInstance.instanceName+"').checked=false");

			}

		}

		catch(ex)

		{}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_DelBlankLine函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *将Muline的选中行清空(可以外部/内部调用)

 *输入：	strPageName:页面上Muline的对象名，不能为空

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用字函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	没有

 ************************************************

 */

function _DelCheckTrueLine(strPageName,cObjInstance)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称



	var tObjInstance;

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";

	var rowCount = tObjInstance.mulLineCount;	//行数

	var i;

	var checkTrueFlag=true;	//选中行标志

	var lineSpanID;	//行的spanID



	if(tObjInstance.canChk==0)

	{

		alert("no checkBox!");

		return;

	}

	try

	{

		//循环查询每一行是否为空行,即该行的每一列都为空，除了0列（序号列）

		for(i=0;i<rowCount;i++)

		{

			//从行开始循环,0行开始

			checkTrueFlag= _GetChkNo(i,tObjInstance);

			if(checkTrueFlag)

			{

				lineSpanID=_FindSpanID(i,tObjInstance);	//得到该行的spanID

				_DeleteOne(t_StrPageName,lineSpanID,tObjInstance);	//删除这一行

				//删除一行，循环减一

				rowCount=rowCount-1;

				//回退一行检查

				i=i-1;

			}

		}

		try

		{

			if(tObjInstance.checkFlag==1)

			{

				tObjInstance.checkFlag=0;

				eval( tObjInstance.formName + ".all('checkAll"+tObjInstance.instanceName+"').checked=false");

			}

		}

		catch(ex)

		{}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_DelBlankLine函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *将Muline的选中的radiobox行清空(可以外部/内部调用)

 *输入：	strPageName:页面上Muline的对象名，不能为空

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用字函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	没有

 ************************************************

 */

function _DelRadioTrueLine(strPageName,cObjInstance){

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	var tObjInstance;

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}



	tObjInstance.errorString="";

	var rowCount = tObjInstance.mulLineCount;	//行数

	var selno=0;	//选中的行数

	var lineSpanID;	//行的spanID



	if(tObjInstance.canSel==0)

	{

		alert("no radioBox!");

		return;

	}



	try

	{

		selno= _GetSelNo(tObjInstance);

		if(selno==0)

		{

			selno=1;

		}

		lineSpanID=_FindSpanID(selno-1,tObjInstance);	//得到该行的spanID

		_DeleteOne(t_StrPageName,lineSpanID,tObjInstance);	//删除这一行

	}

	catch(ex)

	{

	_DisplayError("在MulLine.js-->_DelRadioTrueLine函数中发生异常:" + ex,tObjInstance);

	}

}



/************************************************

 *返回指定行的SpanID(可外部/内部调用)

 *输入：	cRow:  指定的行数

 *			cObjInstance Muline对象，外部调用时为空；内部调用时不能为空

 *			顶级函数一般是外部调用，则cObjInstance为空，内部tObjInstance=this;

 *			则调用字函数时，将当前对象this作为cObjInstance参数传入调用子函数

 *输出：	tReturn：指定行的span值

 *简要说明：在行模板中删除一行的标志"-"后面，添加隐藏的INPUT域，其name为

 *			this.instanceName+"SpanID'，其value为对应该行的span值

 *			得到该行的span值后，传给_DeleteOne()函数，即将该行删除

 *			目的是为了动态删除多个符合条件的行，通过循环实现

 ************************************************

 */

function _FindSpanID(cRow,cObjInstance)

{

	var tStr;

	var tReturn="";

	var tObjInstance;

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}



	tObjInstance.errorString="";



	if(cRow<0||cRow>=tObjInstance.mulLineCount)

	{

		alert("在MulLine.js-->findSpanID() 时指定了错误的行:"+cRow);

		return tReturn;

	}

	try

	{

		//注意：必须添加下面的判断条件，否则在初始化为0行时，会出现异常

		if(tObjInstance.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+"SpanID').value";

				tReturn=eval(tStr);

			}

			catch(ex)

			{

				tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+"SpanID')[0].value";

				tReturn=eval(tStr);

			}

			//如果得到的值为null，说明当行数为1时，有下面的可能：

			//如果是从多行删除到一行，那么可能会继续认为这个单独行是数组的一个元素，所以还要加下标

			//除上述外，可能在javaScript中还有其它因素，因此，下面可以看作对各种情况的修正：

			try

			{

				//把undefined单独提出来，是因为有的JS不支持undefined，所以要捕获例外

				if(tReturn==undefined)

				{

					try

					{

						tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+"SpanID')[0].value";

						tReturn=eval(tStr);

					}

					catch(ex)

					{

						tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+"SpanID').value";

						tReturn=eval(tStr);

					}

				}

			}

			catch(ex)

			{}



			if(tReturn==null)

			{

				try

				{

					tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+"SpanID')[0].value";

					tReturn=eval(tStr);

				}

				catch(ex)

				{

					tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+"SpanID').value";

					tReturn=eval(tStr);

				}

			}

		}

		else

		{

			if(tObjInstance.mulLineCount>1)

			{

				tStr=tObjInstance.formName+".all('" +tObjInstance.instanceName+"SpanID')["+cRow+"].value";

				tReturn=eval(tStr);

			}

		}

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_FindSpanID函数中发生异常:" + ex,tObjInstance);

	}

	return tReturn;

}



/************************************************

 *检验表格中输入的值是否符合规范

 *输入：	可以为空，或对象名

 *输出：	没有

 interpreting right by yuanaq

 ************************************************/

function _CheckValue2(strPageName,cObjInstance)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	var tObj = cObjInstance||this;

	_DelBlankLine(t_StrPageName,tObj);	//清除空行



	var tRule="";

	var strInfo="";

	var rowNo=0;

	var tReturn;

	if(tObj.mulLineCount==0)

	{

		return true;

	}

	else if(tObj.mulLineCount==1)

		{

			for(var i=1;i<tObj.colCount;i++)

			{

				//从第1列开始，第0列是序列，不检验

				tRule=eval(tObj.formName+".all('"+t_StrPageName+"verify"+i+"').value");

				if(tRule==null||tRule=="")

				{

					continue;

				}

				else

				{

					try

					{

						strInfo="第一行的"+tRule;

						var dd=tObj.formName+"."+t_StrPageName+i;

						if(!verifyElementWrap2(strInfo, _GetRowColData(n,i,tObj),dd))

						return false;//如果错误，返回

					}

					catch(ex)

					{

						alert("请确认verifyInput.js 文件被包含或数据库连接正常");

						return false;

					}

				}

			}

		}

		else

		{

			for(var i=1;i<tObj.colCount;i++)

			{

				//从第1列开始，第0列是序列，不检验

				try

				{

					//注意:初始化时，如果不检验该列，在textTitle中设置verify=''

					tRule=eval(tObj.formName+".all('"+t_StrPageName+"verify"+i+"').value");

					if(tRule==null||tRule=="")

					{

						continue;

					}

					else

					{

						for(var n=0;n<tObj.mulLineCount;n++)

						{

							// 外部函数，请察看verifyInput.js parm1:位置|检验规则 parm2: 要检验的值(即第N行i列的值)

							try

							{

								rowNo=n+1;

								strInfo="第"+rowNo+"行的"+tRule;	//提示信息中确定第几行

								var dd=tObj.formName+"."+t_StrPageName+i+"["+n+"]";

								if(!verifyElementWrap2(strInfo, _GetRowColData(n,i,tObj),dd))

								{

									return false;	//如果错误，返回

								}

							}

							catch(ex)

							{

								alert("请确认verifyInput.js 文件被包含或数据库连接正常");

								return false;

							}

						}

					}

				}

				catch(ex)

				{

					alert("_CheckValue函数出错");

					return false;

				}

			}

		}

	return true;

}



/************************************************

 *检验表格中输入的值是否符合规范

 *输入：	可以为空，或对象名

 *输出：	没有

 ************************************************/

function _CheckValue(strPageName,cObjInstance)

{

	var t_StrPageName = strPageName||this.instanceName;	//实例名称

	var tObj = cObjInstance||this;

	_DelBlankLine(t_StrPageName,tObj);	//清除空行



	var tRule="";

	var strInfo="";

	var rowNo=0;

	var tReturn;

	if(tObj.mulLineCount==0)

	{

		return true;

	}

	for(var i=1;i<tObj.colCount;i++) //从第1列开始，第0列是序列，不检验

	{

		try

		{

			//注意:初始化时，如果不检验该列，在textTitle中设置verify=''

			tRule=eval(tObj.formName+".all('"+t_StrPageName+"verify"+i+"').value");

			if(tRule==null||tRule=="")

			{

				continue; //即不校验

			}

			else

			{

				for(var n=0;n<tObj.mulLineCount;n++)

				{

					// 外部函数，请察看verifyInput.js parm1:位置|检验规则 parm2: 要检验的值(即第N行i列的值)

					try

					{

						rowNo=n+1;

						strInfo="第"+rowNo+"行的"+tRule;   //提示信息中确定第几行

						if(!verifyElement(strInfo,_GetRowColData(n,i,tObj)))

						{

							return false;//如果错误，返回

						}

					}

					catch(ex)

					{

						alert("请确认verifyInput.js 文件被包含或数据库连接正常");

						return false;

					}

				}

			}

		}

		catch(ex)

		{

			alert("_CheckValue函数出错");

			return false;

		}

	}

	return true;

}



/************************************************

 *辅助函数(内部调用):该函数可以去掉，或者扩展成其它附加的功能

 *当MulLine从多行减少至一行时，再调用内部函数

 *是会出错的。可能的原因是：多行是数组形式，单行是一个变量形式

 *当由多行编成单行后又接着调用内部函数，其剩下的单列还保持数组的

 *形式，即[0]，而我们在内部判断时，当行数=1，则直接用变量形式调用

 *会出现错误。该函数放在xxx.mulLineCount==1后。即调用该对象的内部

 *函数，以便再调用相关函数时。该单行形式成为变量形式

 *输入：	可以为空，或对象名

 *输出：	没有

 ************************************************/

function _ResumeState(cObjInstance)

{

	var tObjInstance;

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";

	tObjInstance.state=0;

}



/************************************************

 *检验MulLine中某行某列是否得到焦点

 *输入：	row 行 不能为空

			col 列 可以为空（缺省设为1，即排在序号后的第一列）

			cObjInstance MulLine对象可以为空

 *输出：	true or false

 ************************************************/

function _GetFocus(Row,Col,cObjInstance)

{

	//待做

	var tReturn = false;

	return tReturn;

}



/************************************************

 *设置MulLine中某行某列得到焦点

 *输入：	row 行 不能为空(可以设为最后一行的行数)

			col 列 可以为空（缺省设为1，即排在序号后的第一列）

			cObjInstance (MulLine对象可以为空 )

 *输出：	true or false

 ************************************************/

function _SetFocus(Row,Col,cObjInstance)

{

	var tStr;

	var tObj;

	var tReturn=false;

	var cRow;

	var cCol;

	var tObjInstance;	//对象指针

	if (cObjInstance==null)

	{

		tObjInstance=this;

	}

	else

	{

		tObjInstance=cObjInstance;

	}

	tObjInstance.errorString="";



	cRow=Row;

	if(cRow<0||cRow>=tObjInstance.mulLineCount)

	{

		return tReturn;

	}

	if(Col==""||Col==null)

	{

		cCol = 1;

	}

	else

	{

		cCol=Col;

	}



	if(cCol<0||cCol>=tObjInstance.colCount)

	{

		return tReturn;

	}



	try

	{

		//注意：必须添加下面的判断条件，否则在初始化为0行时，会出现异常

		if(tObjInstance.mulLineCount==1)

		{

			_ResumeState();

			try

			{

				tStr=tObjInstance.formName + ".all('" + tObjInstance.instanceName+cCol + "').focus()";

			}

			catch(ex)

			{

				tStr=tObjInstance.formName + ".all('" + tObjInstance.instanceName+cCol + "')[0].focus()";

			}

		}

		else if(tObjInstance.mulLineCount>1)

			{

				tStr=tObjInstance.formName + ".all('" + tObjInstance.instanceName+cCol + "')["+cRow+"].focus()";

			}

		eval(tStr);

		tReturn=true;

	}

	catch(ex)

	{

		_DisplayError("在MulLine.js-->_SetFocus函数中发生异常:" + ex,tObjInstance);

	}

	return tReturn;

}



/************************************************

 *如果MulLine中某行文字超出显示范围，则显示title

 *输入：	控件实体

 *输出：	title

 ************************************************/

function _showtitle(obj){

	obj.title =obj.innerHTML;

}



function AllowSortFun(obj,i)

{

	var sortturnpage=obj.SortPage;

	if(sortturnpage==null||sortturnpage=="")

	{

		alert("请先查询！");

		return false;

	}

	sortturnpage.allowsort(obj,i);

}



/************************************************************

*	方法：	增加页数显示，根据页号跳转到相应页

*************************************************************/

function _SetPageMark(cTurnPage)

{
	var tStrPageName = this.instanceName;


	try

	{

		if(this.SortPage==null||this.SortPage=="")

		{
			return false;

		}

	}

	catch(ex)

	{

		alert(ex.message);

		return false;

	}

	var tTotalPageNum = Math.ceil(cTurnPage.queryAllRecordCount/cTurnPage.pageLineNum);

	var tPageIndex = cTurnPage.pageIndex+1;

 
	var tHTML = document.all("span"+tStrPageName ).innerHTML;

	if(tHTML==""||tHTML==null)

	{

		return;

	}

	tHTML += "<div align=right>";

	tHTML += "第&nbsp;"+tPageIndex+"/"+tTotalPageNum+"&nbsp;页&nbsp;&nbsp;";

	tHTML += "转到&nbsp;<input type='common' style='{border: 1px #9999CC solid;height: 18px}' name='GotoPage"+tStrPageName+"' size='3'>&nbsp;页";

	tHTML += "<input type='button' class=cssbutton value='->' onclick='"+tStrPageName+".SortPage.gotoPage(document.all.GotoPage"+tStrPageName+".value);' name=btnchangepage>";

	tHTML += "</div>";

	document.all("span"+tStrPageName ).innerHTML=tHTML;

}
