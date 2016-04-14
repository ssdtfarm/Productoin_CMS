/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
// import org.jdom.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Blob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinosoft.utility.*;


import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFun {
	private int starNum = 0;
	private int sendNum = 0;
	private int startNum = 0;
	private int lengthNum = 0;
	private static boolean firstLineFlag = true;

	public XmlFun() {
	}

	/**
	 * 返回年份加月份信息
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	public static String getYearMonth(String value) {
		String tYearMonth = "";
		tYearMonth = value.substring(2, 6);
		return tYearMonth;
	}

	/**
	 * 新增以[空格]截取字符串的方法
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	public static String getSplitString(String value) {
		String[] result = value.split("\\s");
		return result[1];
	}

	/**
	 * 返回截取字符串长度
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	public static String getSplitStringLength(String value) {
		String[] result = value.split("\\|");
		return Integer.toString(result.length);
	}

	/**
	 * 判断中文字符的个数，用于银行xml转换
	 * 
	 * @param value
	 *            String
	 * @param len
	 *            String
	 * @return String
	 */
	public static String getChinaLen(String value, String len) {
		int n = Integer.parseInt(len);
		char[] arr = value.toCharArray();
		int result = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] > 511) {
				System.out.println(arr[i]);
				result++;
			}
		}

		return result + "";
	}

	/**
	 * 获取同一批次中，客户账户流水号 add by sunhongyan 用于重庆工行制返盘格式
	 * 
	 * @param value
	 *            String
	 * @param value
	 *            String
	 * @return String
	 */
	public static String getAccNoSerNo(String tserialno, String taccno,
			String tserno) {
		String result = "";
		String tSql = "select a.serno,rownum from lysendtobank a where a.serialno='"
				+ tserialno
				+ "' and a.accno='"
				+ taccno
				+ "' order by a.serno asc";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSsrs = new SSRS();
		tSsrs = tExeSQL.execSQL(tSql);
		for (int i = 1; i <= tSsrs.MaxRow; i++) {
			if (tSsrs.GetText(i, 1).equals(tserno)) {
				result = tSsrs.GetText(i, 2);
				result = Integer.toString(Integer.parseInt(result) - 1);
			}
		}

		return result;
	}

	/**
	 * 过虑得到中文字符串
	 * 
	 * @param value
	 *            String
	 * @param len
	 *            String
	 * @return String
	 */
	public static String getChinaChar(String value) {

		char[] arr = value.toCharArray();
		String result = "";

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 511) {
				result += arr[i];
			}
		}

		return result;
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).doubleValue();

	}

	/**
	 * 
	 * @param t
	 * @param n
	 * @return
	 */
	public static String getAnHuiDataS(String t, String flag) {
		int a = t.indexOf("     ");

		// 业务号
		String c = t.substring(0, a - 1);
		// 标志
		String b = t.substring(a - 1, a);

		// System.out.println(c);
		// System.out.println(b);
		// 金额
		int d = t.length();
		String jine = t.substring(d - 12, d);
		// System.out.println("jine="+jine);
		// 账号
		int k = t.indexOf(" ", a + 5);
		// System.out.println(t.substring(a+5, k));
		String x = t.substring(a + 5, k);
		if (flag.equals("SerNo")) {
			c = Integer.toString(Integer.parseInt(c));
			return c;
		}
		if (flag.equals("BankSuccFlag")) {
			return b;
		}
		if (flag.equals("PayMoney")) {
			return jine;
		}
		if (flag.equals("AccNo")) {
			return x;
		}
		return "";
	}

	public static String getSERNO(String serialno, int start, int end) {

		String str = "";
		str = serialno.substring(start, end);

		str = Integer.toString(Integer.parseInt(str));
		return str;
	}

	public static String getSERNO1(String serialno, int start, int end) {

		String str = "";
		str = getShangHaiData(serialno, start, end);

		str = Integer.toString(Integer.parseInt(str));
		return str;
	}

	public static String getACCNO(String colnum, int start, int end) {

		String str = "";
		str = getShangHaiData(colnum, start, end);

		str = str.trim();
		return str;
	}

	public static String getcFullComName() {
		return ""+bundle.getString("waitForTran")+"      ";
	}

	public static String getcAbbComName() {
		return ""+bundle.getString("waitForTran")+"  ";
	}

	/**
	 * 取得指定位置对应的字符串
	 * 
	 * @param tStr：带“|”的字符串
	 * @param n：从0开始
	 * @return add by zhaopeng 20080714 针对银行接口-安徽的格式编写
	 */
	public static String getAnHuiData(String tStr, int n) {
		String b[] = PubFun.split(tStr, "|");
		if (b.length == n) {
			return "";
		}

		String c = b[n];
		if (n == 4 && !c.equals(""+bundle.getString("waitForTran")+"")) {
			return "N";
		}
		if (n == 4 && c.equals(""+bundle.getString("waitForTran")+"")) {
			return "Y";
		}
		return c;
	}

	/**
	 * 返回指定格式的日期字符串（无下划线）
	 * 
	 * @param tStr：带"-"的日期字符串
	 * @return dStr:无"-"的日期字符串 add by sunhongyan 20080805 针对银行接口-上海的格式编写
	 */
	public static String dateFormat(String tStr) {
		String date[] = tStr.split("-");
		String dStr = date[0] + date[1] + date[2];
		return dStr;
	}

	/**
	 * 返回指定格式的日期字符串（无下划线）
	 * 
	 * @param tStr：带"-"的日期字符串
	 * @return dStr:无"-"的日期字符串 add by sunhongyan 20080805 针对银行接口-上海的格式编写
	 */
	public static String dateFormat1(String tStr) {
		String date[] = tStr.split("-");
		String dStr = date[0].substring(2) + date[1] + date[2];
		return dStr;
	}

	/**
	 * 返回代理人名称
	 * 
	 * @param tStr：代理人编码
	 * @return dStr:代理人名称 add by sunhongyan 20080917 针对银行接口-沈阳的格式编写
	 */
	public static String getAgentName(String tStr) {
		String sql = "select name from laagent where agentcoce='" + tStr + "'";
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs = new SSRS();
		ssrs = exeSQL.execSQL(sql);
		String result = ssrs.GetText(1, 1);
		return result;
	}

	/**
	 * 返回金融联格式下银行代码
	 * 
	 * @param tStr：银行代码
	 * @return dStr:金融联格式下银行代码 add by sunhongyan 20081114 针对银行接口-深圳金融联格式编写
	 */
	public static String getJrlCode(String tBankcode) {
		String sql = "select code1 from ldcode1 where codetype='JRL' and code='"
				+ tBankcode + "'";
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs = new SSRS();
		ssrs = exeSQL.execSQL(sql);
		String result = ssrs.GetText(1, 1);
		return result;
	}

	/**
	 * 返回甘肃银联格式下银行代码
	 * 
	 * @param tStr：银行代码
	 * @return dStr:add by sunhongyan 20091118 针对银行接口-甘肃银联格式编写
	 */
	public static String getBankCode(String tBankcode, String tInBankCode) {
		String sql = "select code1 from ldcode1 where codetype='BankCode' and code='"
				+ tInBankCode + "' and codealias='" + tBankcode + "'";
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs = new SSRS();
		ssrs = exeSQL.execSQL(sql);
		String result = ssrs.GetText(1, 1);
		return result;
	}

	/**
	 * 返回记录行中指定长度的字段值
	 * 
	 * @param row：行变量名称
	 * @param start:
	 *            起始位置
	 * @param end:
	 *            结束位置
	 * @return Str: 返回记录行中指定长度的字段值 add by sunhongyan 20080805 针对银行接口-上海的格式编写
	 */
	public static String getShangHaiData(String row, int start, int end) {
		int a = getChinaLen(row);
		String Str = row.substring(start - a, end - a);
		return Str;
	}

	/**
	 * 返回记录行中指定长度的字段值
	 * 
	 * @param row：行变量名称
	 * @param start:
	 *            起始位置
	 * @param end:
	 *            结束位置
	 * @return Str: 返回记录行中指定长度的字段值 add by sunhongyan 20080805 针对银行接口-重庆中行格式编写
	 */
	public static String getChongQData(String row, int start, int end) {
		int a = getChinaLen(row);
		String Str = row.substring(start, end - a);
		return Str;
	}

	public static String getShangHaiData1(String row, int start, int end) {
		// int a=getChinaLen(row);
		String Str = row.substring(start, end);
		return Str;
	}

	/**
	 * 返回记录行中指定长度的客户姓名
	 * 
	 * @param row：行变量名称
	 * @param start:
	 *            起始位置
	 * @param end:
	 *            结束位置
	 * @return Str: 返回记录行中指定长度的客户姓名 add by sunhongyan 20091015
	 */
	public static String getAccName(String row, int start, int end) {

		int a = getChinaLen(row);
		String Str = row.substring(start, end - a);
		Str.trim();
		return Str;
	}

	/**
	 * 返回固定格式的金额字符串（不含小数点）
	 * 
	 * @param row：金额字符串
	 * @return Str: 返回固定格式的金额字符串 add by sunhongyan 20080805 针对银行接口-上海的格式编写
	 */
	public static String moneyFormat(String moneyString) {

		String Str = "";
		for (int i = 0; i <= moneyString.length() - 1; i++) {
			char chr = moneyString.charAt(i);
			String transfer = String.valueOf(chr);
			if (transfer.matches("\\.")) {
				String s[] = moneyString.split("\\.");
				Str = s[0] + s[1];
			}
		}
		return Str;
	}

	/**
	 * 返回固定格式的金额字符串（含小数点）
	 * 
	 * @param row：金额字符串
	 * @return Str: 返回固定格式的金额字符串 add by sunhongyan 20080805 针对银行接口-上海的格式编写
	 */
	public static String moneyFormat1(String moneyString, int start, int end) {
		String Str = "";
		Str = moneyString.substring(start, end);
		Str = Str.substring(0, 13) + "." + Str.substring(13);
		return Str;
	}

	/**
	 * 返回固定格式的金额字符串（含小数点）
	 * 
	 * @param row：金额字符串:-109.36
	 * @return Str: 返回固定格式的金额字符串-上海中行格式编写
	 */
	public static String moneyFormat3(String moneyString) {
		String Str = "";
		Str = "-" + moneyString;
		return Str;
	}

	/**
	 * 返回固定格式的金额字符串（含小数点）
	 * 
	 * @param row：金额字符串
	 * @return Str: 返回固定格式的金额字符串 add by sunhongyan 20091015 针对银行接口-北京工行格式编写
	 */
	public static String moneyFormat2(String moneyString, int start, int end) {
		String Str = "";

		Str = getShangHaiData(moneyString, start, end);
		Str = Double.toString((Double.parseDouble(Str) * 1.00));
		// Str = Double.toString((Double.parseDouble(Str)/100.00));
		return Str;
	}

	/**
	 * 返回卡折标记
	 * 
	 * @param AccNo：银行帐号
	 * @return flag:卡折标志 add by sunhongyan 20080805 针对银行接口-上海的格式编写
	 */
	public static String getFlagByAccNO(String AccNo) {
		String subAccNO = AccNo.substring(0, 3);
		String flag = "";
		if (subAccNO.equals("121")) {
			flag = "P";
		} else {
			flag = "C";
		}
		return flag;
	}

	/**
	 * 返回卡折标记
	 * @param BankCode：银行代码
	 * @param AccNo：银行帐号
	 * @return flag:卡折标志 add by sunhongyan 20100510 针对银行接口-陕西通联格式
	 */
	public static String getAccNoType(String BankCode,String AccNo) {
		//卡折标记
		String flag = "";
		//招商银行
		if(BankCode.equals("06")){
			flag = "00";
		}
		//工商银行
		else if (BankCode.equals("01")){
			if (AccNo.startsWith("95588")||AccNo.startsWith("62220")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}
		//农业银行
		else if (BankCode.equals("04")){
			if (AccNo.startsWith("622848")||AccNo.startsWith("95599")||AccNo.startsWith("103")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}
		//建设银行
		else if (BankCode.equals("03")){
			if (AccNo.startsWith("4367")||AccNo.startsWith("6222")||AccNo.startsWith("6227")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}
		//西安商业银行
		else if (BankCode.equals("05")){
			if (AccNo.startsWith("622136")||AccNo.startsWith("940059")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}else{
			flag="";	
		}
		return flag;
	}
	
	/**
	 * 返回卡折标记
	 * @param BankCode：银行代码
	 * @param AccNo：银行帐号
	 * @return flag:卡折标志 add by sunhongyan 20100510 针对银行接口-上海通联格式
	 */
	public static String getAccNoType2(String BankCode,String AccNo) {
		//卡折标记
		String flag = "";
		//招商银行
		if(BankCode.equals("06")){
			flag = "00";
		}
		//交通银行
		else if (BankCode.equals("10")){
			if ((AccNo.length()==19&&AccNo.startsWith("622260"))||(AccNo.length()==21&&(AccNo.startsWith("458123")||AccNo.startsWith("521899")))) {
				flag = "01";
			} else {
				flag = "00";
			}
		}
		//工商银行
		else if (BankCode.equals("01")){
			if ((AccNo.length()==19&&AccNo.startsWith("1001"))||(AccNo.length()==12&&AccNo.substring(3, 1).equals("7"))) {
				flag = "01";
			} else {
				flag = "00";
			}
		}
		//农业银行
		else if (BankCode.equals("04")){
			if (AccNo.length()==17&&AccNo.startsWith("09")) {
				flag = "01";
			} else {
				flag = "00";
			}
		}
		//建设银行
		else if (BankCode.equals("03")){
			if (AccNo.length()==19&&AccNo.startsWith("121")) {
				flag = "01";
			} else {
				flag = "00";
			}
		}
		//中国银行
		else if (BankCode.equals("02")){
			if (AccNo.startsWith("4563")||AccNo.startsWith("6013")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}
		//上海农村商业银行
		else if (BankCode.equals("17")){
			if (AccNo.startsWith("6224")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}
		//上海银行
		else if (BankCode.equals("05")){
			if (AccNo.startsWith("6224")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}else{
			flag="";	
		}
		return flag;
	}
	
	
	/**
	 * 返回卡折标记
	 * @param BankCode：银行代码
	 * @param AccNo：银行帐号
	 * @return flag:卡折标志 add by sunhongyan 20100625 针对银行接口-苏州通联格式
	 */
	public static String getAccNoType1(String BankCode,String AccNo) {
		//卡折标记
		String flag = "";
		//工商银行
		 if (BankCode.equals("01")){
			if (AccNo.startsWith("95588")||AccNo.startsWith("62")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}
		//建设银行
		else if (BankCode.equals("03")){
			if (AccNo.startsWith("4367")||AccNo.startsWith("62")) {
				flag = "00";
			} else {
				flag = "01";
			}
		}
		//其他银行
		else{
			flag="00";	
		}
		return flag;
	}
	
	/**
	 * 取得指定位置对应的字符串
	 * 
	 * @param tStr：带“|”的字符串
	 * @param n：从0开始
	 * @return add by zhaopeng 20080714 针对银行接口-西安的格式编写
	 */
	public static String getXiAnData(String tStr, int n) {
		String b[] = PubFun.split(tStr, "|");
		// edit by sunhongyan 20090619
		// if (b.length == n) {
		if (b.length <= n) {
			return "";
		}

		String c = b[n];
		return c;
	}

	/**
	 * 判断中文字符的个数，用于银行xml转换
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	public static int getChinaLen(String value) {
		char[] arr = value.toCharArray();
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 511) {
				// System.out.println(arr[i]);
				result++;
			}
		}

		return result;
	}

	/**
	 * 判断是否包含中文字符
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	public static String getChinaFlag(String value) {
		char[] arr = value.toCharArray();
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 511) {
				result = "Y";
				break;
			}
		}

		return result;
	}

	/**
	 * 进制转化
	 * 
	 * @param str
	 *            转化的字符串
	 * @param stafrom
	 *            原始进制
	 * @param endto
	 *            目的进制
	 * @return
	 */
	public static String getFormatString(String str, int stafrom, int endto) {
		java.math.BigInteger a = new java.math.BigInteger(str, stafrom);

		return a.toString(endto).toUpperCase();

	}

	/**
	 * 获取客户证件类型(上海建行)
	 * 
	 * @param str
	 *            获取客户证件类型(上海建行)
	 * @param stafrom
	 *            系统客户证件类型
	 * @param endto
	 *            上海建行客户证件类型-针对上海建行格式
	 * @return
	 */
	public static String getIDType(String str) {
		String result = "";
		String sql = "select code from ldcode1 where codetype = 'idtype' and code1 = '"
				+ str + "' and othersign like '%"+bundle.getString("waitForTran")+"%'";
		ExeSQL tExeSQL = new ExeSQL();
		result = tExeSQL.getOneValue(sql);

		return result;
	}

	/**
	 * 获取客户证件类型(上海建行)
	 * 
	 * @param str
	 *            获取客户证件类型(上海交行)
	 * @param stafrom
	 *            系统客户证件类型
	 * @param endto
	 *            上海交行客户证件类型-针对上海交行格式
	 * @return
	 */
	public static String getIDType1(String str) {
		String result = "";
		String sql = "select code from ldcode1 where codetype = 'idtype' and code1 = '"
				+ str + "' and othersign like '%"+bundle.getString("waitForTran")+"%'";
		ExeSQL tExeSQL = new ExeSQL();
		result = tExeSQL.getOneValue(sql);

		return result;
	}
	
	/**
	 * 获取客户证件类型(上海通联)
	 * 
	 * @param str
	 *            获取客户证件类型(上海通联)
	 * @param stafrom
	 *            系统客户证件类型
	 * @param endto
	 *            上海通联客户证件类型-针对上海通联格式
	 * @return
	 */
	public static String getIDType2(String str) {
		String result = "";
		String sql = "select code from ldcode1 where codetype = 'bankidtype' and code1 = '"
				+ str + "' ";
		ExeSQL tExeSQL = new ExeSQL();
		result = tExeSQL.getOneValue(sql);

		return result;
	}
	
	
	/**
	 * 获取开户行所在省
	 * add by lvliye 20110328
	 * 
	 * @param str
	 * @return
	 */
	public static String getProvinceCode(String str)
	{
		String result ="";
		String sql = "select shortname from ldaddress  where placetype ='01' and placecode ='"+str+"'";
		ExeSQL tExeSQL = new ExeSQL();
		result = tExeSQL.getOneValue(sql);
		if(result==null||"".equals(result))
		{
			result="";
		}
		return result ;
	}
	

	/**
	 * 编码
	 * 
	 * @param str
	 * @param stafrom
	 * @param endto
	 * @return
	 */
	public static String encodeString(String str, int stafrom, int endto,
			int tlength) {
		String a = XtoY("" + stafrom, str, "" + endto);
		String b = XtoY("" + stafrom, "" + str.length(), "" + endto);
		String c = a + b;
		while (c.length() < tlength) {
			c = "0" + c;
		}

		return c;
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @param stafrom
	 * @param endto
	 * @return
	 */
	public static String decodeString(String str, int stafrom, int endto,
			int tlength) {
		String a = str.substring(str.length() - 1);
		a = XtoY("" + stafrom, a, "" + endto);

		String b = str.substring(0, tlength - 1);
		b = XtoY("" + stafrom, b, "" + endto);

		if (b.length() > Integer.parseInt(a)) {
			b = b.substring(b.length() - Integer.parseInt(a), b.length());
		} else {
			while (b.length() < Integer.parseInt(a)) {
				b = "0" + b;
			}
		}

		return b;
	}

	/**
	 * 函数功能：数值由n进制转换为十进制数值 函数参数：n：原进制 ；m：数值（STRING型） 输出结果：返回输入数值（m）的十进制数值
	 */

	public static String Xtoshi(String n, String m) {
		String s = "";
		String ss = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_@";
		m = m.replaceAll("\\s", "");

		if (m.equals("") || m == null) {
			return s;
		}
		BigInteger g = new BigInteger("1", 10);
		BigInteger t = new BigInteger("0", 10);

		int i = Integer.parseInt(n);
		String a = ss.substring(0, i);
		for (int x = m.length() - 1; x > -1; x--) {
			t = t.add(g
					.multiply(new BigInteger(a.indexOf(m.charAt(x)) + "", 10)));
			g = g.multiply(new BigInteger(n, 10));

		}
		return t.toString() + "";
	}

	/**
	 * 函数功能：数值由X进制转换为Y进制数值 函数参数：n：原进制 ；m：数值； y：目标进制（STRING型）
	 * 输出结果：返回输入数值（m）的Y进制数值
	 */
	public static String XtoY(String n, String m, String y) {

		String a = Xtoshi(n, m);
		a = shiToX(y, a);
		return a;
	}

	/**
	 * 函数功能：数值由十进制转换为n进制数值 函数参数：n：目标进制 ；m：数值（STRING型） 输出结果：返回输入数值（m）的n进制数值
	 */
	public static String shiToX(String n, String m) {
		String sss = "";
		String t = "";
		String ss = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_@";

		m = m.replaceAll("\\s", "");

		if (m.equals("") || m == null) {
			return sss;
		}
		java.math.BigInteger c = new java.math.BigInteger(m, 10);
		java.math.BigInteger d = new java.math.BigInteger(n, 10);

		int i = d.intValue();
		String a = ss.substring(0, i);
		while (c.compareTo(BigInteger.ZERO) != 0) {

			BigInteger[] e = c.divideAndRemainder(d);
			int j = e[1].intValue();
			t = a.charAt(j) + t;
			c = (c.subtract(e[1])).divide(d);
		}
		return t;
	}

	/**
	 * 判断中文字符的个数，用于银行xml转换
	 * 
	 * @param value
	 *            String
	 * @return int
	 */
	public static int getChinaLength(String value) {
		char[] arr = value.toCharArray();
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 511) {
				result = result + 2;
			} else {
				result = result + 1;
			}
		}

		return result;
	}

	/**
	 * 按长度len取字符串value的值，不足的补空格
	 * 
	 * @param value
	 *            要进行处理的字符串
	 * @param len
	 *            需要显示的字符长度
	 * @param n
	 *            值为1代表在后面补空格，值不为1代表空格前置
	 * @return add by lvliye 20080122
	 */

	public static String getChina(String value, int len, int n) {

		char[] arr = value.toCharArray();
		byte[] bytes = value.getBytes();
		String str = "";
		int result = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 511) {

				result = result + 2;
			} else {

				result = result + 1;
			}
			if (result == len) {
				str = new String(bytes, 0, len);
				break;
			}
			if (result > len) {
				str = new String(bytes, 0, len - 1);
				if (n == 1) {
					str += " ";
				} else
					str = " " + str;
				break;
			}

		}
		if (result < len) {
			int l = len - result;
			String strempty = "";
			str = new String(bytes, 0, result);
			for (int i = 0; i < l; i++) {
				strempty += " ";
			}
			if (n == 1) {
				str += strempty;
			} else
				str = strempty + str;
		}
		return str;
	}

	/**
	 * 得到当前系统日期 author: YT
	 * 
	 * @return 当前日期的格式字符串,日期格式为"yyyy-MM-dd"
	 */
	public static String getCurrentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		return df.format(today);
	}

	/**
	 * 得到当前系统时间 author: YT
	 * 
	 * @return 当前时间的格式字符串，时间格式为"HH:mm:ss"
	 */
	public static String getCurrentTime() {
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		return df.format(today);
	}

	/**
	 * 标志第一行开始
	 */
	public static void setFirstLine() {
		firstLineFlag = true;
	}

	/**
	 * 判断是否是第一行
	 * 
	 * @return boolean
	 */
	public static boolean isFirstLine() {
		if (firstLineFlag) {
			firstLineFlag = false;
			return true;
		}

		return false;
	}

	public static int num = 0;

	/**
	 * 显示W3C的DOM模型对象，显示JDOM的函数在BQ目录下的changeXml类中
	 * 
	 * @param d
	 *            Node
	 */
	public static void displayDocument(Node d) {
		num += 2;

		if (d.hasChildNodes()) {
			NodeList nl = d.getChildNodes();

			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);

				for (int j = 0; j < num; j++) {
					System.out.print(" ");
				}
				if (n.getNodeValue() == null) {
					System.out.println("<" + n.getNodeName() + ">");
				} else {
					System.out.println(n.getNodeValue());
				}

				displayDocument(n);

				num -= 2;
				// System.out.println("num:" + num);

				if (n.getNodeValue() == null) {
					for (int j = 0; j < num; j++) {
						System.out.print(" ");
					}
					System.out.println("</" + n.getNodeName() + ">");
				}

			}

		}
	}

	/**
	 * 显示InputStream流对象
	 * 
	 * @param in
	 *            InputStream
	 */
	public static void displayStream(InputStream in) {
		try {
			// DataInputStream din = new DataInputStream(in);
			BufferedReader brin = new BufferedReader(new InputStreamReader(in));
			String s = "";

			System.out.println("");
			while ((s = brin.readLine()) != null) {
				System.out.println(s);
			}
			System.out.println("");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 显示Blob的内容
	 * 
	 * @param blob
	 *            Blob
	 */
	public static void displayBlob(Blob blob) {
		try {
			InputStream in = blob.getBinaryStream();

			displayStream(in);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static String getMaxCodeAlias(String BankCode) {
		String MaxCodeAlias = "";
		ExeSQL tExeSQL = new ExeSQL();
		String Sql = " select max(CodeAlias) from LDCode1 "
				+ "  where CodeType = 'cardtype' " + "    and Code = '"
				+ BankCode + "'" + "  order by CodeAlias ";
		SSRS tSSRS = tExeSQL.execSQL(Sql);
		MaxCodeAlias = tSSRS.GetText(1, 1);

		return MaxCodeAlias;
	}
	/**
	 * int n :需要得到n天后的日期
	 * @return 返回n天后的日期
	 * 上海银行手工制返盘格式用
	 */
	public static String getDate(String date,int n){
		String tSql = "select to_date('"+date+"','yyyy-mm-dd')+'"+n+"' from dual";
		String nDate = "";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(tSql);
		 nDate = tSSRS.GetText(1, 1);
		 return nDate;
	}

	/**
	 * 为getCardType解析进行服务
	 * 
	 * @param args
	 *            str1
	 */
	private void StrSplit(String str1) {
		String temp = str1;
		String[] str = temp.split(",");
		_subSplit1(str[0]);
		_subSplit2(str[1]);
		_subSplit3(str[2]);
		_subSplit4(str[3]);
		System.out.println(str[0]);
		System.out.println(str[1]);
		System.out.println(str[2]);
		System.out.println(str[3]);
	}

	public int starNum() {
		return starNum;
	}

	public int sendNum() {
		return sendNum;
	}

	public int startNum() {
		return startNum;
	}

	public int lengthNum() {
		return lengthNum;
	}

	private void _subSplit1(String str) {
		int temp = 0;
		try {
			temp = Integer.parseInt(str);
			starNum = temp;
		} catch (Exception ex) {
			System.out.println("获得起始位置时出错");
		}
	}

	private void _subSplit2(String str) {
		int temp = 0;
		try {
			temp = Integer.parseInt(str);
			sendNum = temp;
		} catch (Exception ex) {
			System.out.println("获得截取长度时出错");
		}
	}

	private void _subSplit3(String str) {
		int temp = 0;
		try {
			temp = Integer.parseInt(str);
			startNum = temp;
		} catch (Exception ex) {
			System.out.println("获得起始位置时出错");
		}
	}

	private void _subSplit4(String str) {
		int temp = 0;
		try {
			temp = Integer.parseInt(str);
			lengthNum = temp;
		} catch (Exception ex) {
			System.out.println("获得截取长度时出错");
		}
	}

//	public static String getLocationCode(String BankCode, String AccNo) {
//		String LocationCode = "";
//		LDCode1DB sLDCode1DB = new LDCode1DB();
//		LDCode1Set sLDCode1Set = new LDCode1Set();
//		LDCode1Schema sLDCode1Schema = new LDCode1Schema();
//		String AccNoHead = "";
//		int CTSP = 0;
//		int CTSL = 0;
//		int LCSP = 0;
//		int LCSL = 0;
//		String Privilege = getMaxCodeAlias(BankCode);
//		if (Privilege.equals("0") || Privilege.equals("")) {
//			LocationCode = "0000";
//		} else {
//			int t = 0;
//			t = Integer.parseInt(Privilege);
//			for (int i = 0; i <= t; i++) {
//				String SQL = " select * from LDCode1 "
//						+ "  where CodeType = 'cardtype' " + "    and Code = '"
//						+ BankCode + "'" + "    and CodeAlias = '" + i + "'";
//				sLDCode1Set = sLDCode1DB.executeQuery(SQL);
//				System.out.println("SQL===============" + SQL);
//				if (sLDCode1Set.size() <= 0) {
//					System.out.println("数据库中无相关银行数据。");
//					LocationCode = "0000";
//				} else {
//					for (int j = 1; j <= sLDCode1Set.size(); j++) {
//						sLDCode1Schema = sLDCode1Set.get(j);
//						String length = sLDCode1Schema.getOtherSign();
//
//						XmlFun tXmlFun = new XmlFun();
//						tXmlFun.StrSplit(length);
//
//						CTSP = tXmlFun.starNum();
//						System.out.println("起始位置CTSP：" + CTSP);
//						CTSL = tXmlFun.sendNum();
//						System.out.println("截取长度CTSL：" + CTSL);
//						AccNoHead = AccNo.substring(CTSP, CTSL);
//						System.out.println("账户头标志AccNoHead============"
//								+ AccNoHead);
//						if (sLDCode1Schema.getCode1().trim().equals(AccNoHead)) {
//							LCSP = tXmlFun.startNum();
//							System.out.println("地区代码起始位置LCSP：" + LCSP);
//							LCSL = tXmlFun.lengthNum();
//							System.out.println("地区代码截取长度LCSL：" + LCSL);
//							LocationCode = AccNo.substring(LCSP, LCSL);
//							return LocationCode;
//						}
//					}
//				}
//			}
//		}
//		System.out.println("LocationCode=================" + LocationCode);
//		if (LocationCode.equals("") || LocationCode.equals(null)
//				|| LocationCode.equals("null")) {
//			System.out.println("该账号" + AccNo + "不符合规则，请重新核实。");
//		}
//		return LocationCode;
//	}

	/**
	 * 上海招行金额字段格式输出 增加千位符号‘,’ add by zhaopeng 20090421
	 * 
	 */
	public static String getSHZHMoney(double tMoney) {
		double s = 0.0;
		s = tMoney;
		// tMoney
		String pattern = "###,###,###.00";
		DecimalFormat df = new DecimalFormat(pattern);
		System.out
				.println("***********= " + df.format(s) + " =***************");
		return df.format(s);
	}

	/**
	 * 取得指定位置对应的字符串
	 * 
	 * @param tStr：带“|”的字符串
	 * @param n：从0开始
	 * @return add by zhaopeng 20090421 针对银行接口-上海招商的格式编写
	 */
	public static String getSHZHData(String tStr, int n) {
		String b[] = PubFun.split(tStr, "|");
		if (b.length == n) {
			return "";
		}

		String c = b[n];
		String d = b[2];
		if (n >= 2 && d.equals("0.00")) {
			c = b[++n];
		}
		return c;
	}

	/**
	 * 取得指定位置对应的字符串
	 * 
	 * @param tStr：带“|”的字符串
	 * @param n：从0开始
	 * @return add by zhaopeng 20090422 针对银行接口-湖南农行格式
	 */
	public static String getHNNHData(String tStr, int n) {
		String b[] = PubFun.split(tStr, ",");
		if (b.length == n) {
			return "";
		}
		String c = b[n];
		return c;
	}

	public static String getSHZHSucFlag(String tStr, int n) {
		String b[] = PubFun.split(tStr, "|");
		if (b.length == n) {
			return "";
		}

		String c = b[n];
		if (n == 2 && c.equals("0.00")) {
			return "N";
		}
		if (n == 2 && !c.equals("0.00")) {
			return "Y";
		}
		return c;
	}

	/*
	 * 上海工行增加来盘批号功能 add by zhaopeng 20090421
	 * 
	 */
	public static String getSHGSSerialNo(String tBankcode, int tlength) {

		String str = "";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL
				.execSQL("select count(*) from lybanklog  where outfile is not null and bankcode= '"
						+ tBankcode + "'");
		str = tSSRS.GetText(1, 1);
		while (str.length() < 5) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * 取得指定位置对应的字符串
	 * 
	 * @param tStr：带“|”的字符串
	 * @param n：从0开始
	 * @return add by zhaopeng 20080714 针对银行接口-大连建设银行编写
	 */
	public static String getDLJSData(String tStr, int n) {
		String b[] = PubFun.split(tStr, "|");
		if (b.length == n) {
			return "";
		}
		String c = "";
		try {
			c = b[n];
		} catch (Exception e) {
		}

		return c;
	}

	/**
	 * 取得按规则转换后的客户账户-针对重庆中行格式
	 * 
	 * @param tStr
	 *            客户帐户
	 * @return add by 孙洪岩 20091030
	 */
	public static String getAccNO(String tStr) {
		String tResult = "";
		tResult = tStr;
		// UNIX2.0系统中，活期账号为18位，以2打头开始，系统处理时，在开头加上省行机构号“8642”，变成22位
		if (tStr.startsWith("2") && tStr.length() == 18) {
			tResult = "8642" + tStr;
		}
		if (tStr.startsWith("8642") && tStr.length() == 22) {
			tResult = tStr.substring(4);
		}

		// 借记卡号，是以“601382”打头的，须更换成“OD”,由19位卡号变成15位卡号
		if (tStr.startsWith("601382")) {
			tResult = "OD" + tStr.substring(6);
		}
		if (tStr.startsWith("OD")) {
			tResult = tStr.replace("OD", "601382");
		}
		return tResult;
	}

//	public static void main(String[] args) {
//
//		String str1 = "2067122670";
//		//String n = getXiAnData(str1, 1);
//		System.out.println("n:" + str1.substring(3, 1));
//	}
}
