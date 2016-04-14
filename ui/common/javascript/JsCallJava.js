function callJava(funStr)
	{
		//同步查询
		//add by wangyc 改为XMLHTTP方式
		var strURL = '../common/jsp/JsCallJava.jsp?function=' + funStr;
//		var strURL = "../common/jsp/ExeFunction.jsp?strStart=" + strStart + "&LargeFlag=" + LargeFlag;
		Request = new ActiveXObject("Microsoft.XMLHTTP");
		//alert(strURL);
		Request.open("GET", strURL, false);
//		Request.open("POST", strURL, false);
//		Request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		Request.send(null);
//		Request.send("strSql="+strSql);
		try
		{
			//strQueryResult = Request.responseText.trim();
			//alert(strQueryResult);
			return Request.responseText.trim();
		}
		catch(e1)
		{
			myAlert(""G0000025538""+e1.message);
		}
	}

