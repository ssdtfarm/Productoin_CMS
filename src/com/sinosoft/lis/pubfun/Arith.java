/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import java.math.BigDecimal;
import java.text.DecimalFormat;
/**
 * @version 1.2
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
 * Modified by hanxl2010年1月6日 11时07分18秒
 */
public class Arith {

	// 默认除法运算精度

	private static final int DEF_DIV_SCALE = 10;

	// 这个类不能实例化

	private Arith() {

	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.add(b2).doubleValue();

	}

	/**
	 * 提供精确的减法运算。
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();

	}

	/**
	 * 提供精确的乘法运算。
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
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {

		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 将数字格式化为保留两位小数的数字<br/>
	 * 如调用Arith.formatNumber(12)，则返回值为"12.00"<br/>
	 * 		调用Arith.formatNumber(12.345) 则返回值为"12.35"
	 * @param number
	 * 		要格式化的<b>数字</b>
	 * @return
	 * 		格式化后的字符串
	 */
	public static String formatNumber(Number number){
		//return (String)format(number,"##.00",2);
		DecimalFormat format=(DecimalFormat)DecimalFormat.getNumberInstance();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		format.setGroupingUsed(false);
		return format.format(number);
	}
	
	/**
	 * 将数字格式化为保留两位小数的数字，支持指定保留几位小数<br/>
	 * 如    调用Arith.formatNumber(12)，则返回值为"12.00"<br/>
	 * 		调用Arith.formatNumber(12.345,2) 则返回值为"12.35"
	 * @param number
	 * 		要格式化的<b>数字</b>
	 * @return
	 * 		格式化后的字符串
	 */
	public static String formatNumber(Number number,int scale){
//		String dfFormat="##";
//		for(int i=1;i<=scale;i++){
//			if (i==1) {
//				dfFormat +=".0";
//			}else {
//				dfFormat +="0";
//			}
//		}
		DecimalFormat format=(DecimalFormat)DecimalFormat.getNumberInstance();
		format.setMaximumFractionDigits(scale);
		format.setMinimumFractionDigits(scale);
		format.setGroupingUsed(false);
		return format.format(number);
		//return (String)format(number,dfFormat,scale);
	}

	/**
	 * 将数字格式化为带有“￥”单位的数字，保留两位小数<br/>
	 * 如调用Arith.formatMoney(12)，则返回值为"￥12.00"
	 * @param number
	 * 		要格式化的<b>数字</b>
	 * @return
	 * 		带有“￥”符号的字符串
	 */
	public static String formatMoney(Number number){
		return (String)format(number,"￥0.00",2);
	}
	
	/**
	 * 将数字格式化为带"￥"的形式，支持指定保留几位小数<br/>
	 * 如：调用Arith.formatMoney(12.2456,3),则返回值为 ￥12.246
	 * @param number
	 * 		要格式化的值
	 * @param scale
	 * 		要保留的小数位数
	 * @return
	 * 	带有“￥”符号的格式化后的字符串
	 */
	public static String formatMoney(Number number,int scale){
		String dfFormat="￥#0";
		for(int i=1;i<=scale;i++){
			if (i==1) {
				dfFormat +=".0";
			}else {
				dfFormat +="0";
			}
		}
		return (String)format(number,dfFormat,scale);
	}
	
	/**
	 * 将数字格式化为百分数形式,保留两位小数<br/>
	 * 如：调用Arith.formatPercent(0.254)，则返回值为25.40%
	 * @param number
	 * 	要格式化的数字
	 * @return
	 * 	一个数字的百分数形式
	 */
	public static String formatPercent(Number number){
		DecimalFormat percent=(DecimalFormat)DecimalFormat.getPercentInstance();
		percent.setMaximumFractionDigits(2);
		percent.setMinimumFractionDigits(2);
		percent.setGroupingUsed(false);
		return percent.format(number);
	}
	/**
	 * 将数字格式化为百分数形式，支持指定保留几位小数<br/>
	 * 如：调用Arith.formatPercent(0.254,3)，则返回值为25.400%
	 * @param number
	 * 	要格式化的数字
	 * @return
	 * 	一个数字的百分数形式
	 */
	public static String formatPercent(Number number,int scale){
		DecimalFormat percent=(DecimalFormat)DecimalFormat.getPercentInstance();
		percent.setMaximumFractionDigits(scale);
		percent.setMinimumFractionDigits(scale);
		percent.setGroupingUsed(false);
		return percent.format(number);
	}
	/**
	 * 将数字格式化为千分号隔开的形式，即每三位之间用逗号隔开,同时保留两位小数<br/>
	 * 如：调用Arith.formatThousandth(1234567)，则返回的字符串为“1,234,567.00"
	 * @param number
	 * @return
	 * 		从个位起，向前每三位用”,”隔开的字符串
	 */
	public static String formatThousandth(Number number){
		return (String)format(number,"###,##0.00",2);
	}
	
	/**
	 * 将数字格式化为千分号隔开的形式，即每三位之间用逗号隔开,同时保留两位小数<br/>
	 * 如：调用Arith.formatThousandth(1234567.3455,2)，则返回的字符串为“1,234,567.35"
	 * @param number
	 * 		要格式化的数字
	 * @param scale
	 * 		要保留的小数位数
	 * @return
	 * 	返回从个位起，向前每三位用”,”隔开的字符串，保留两位小数
	 */
	public static String formatThousandth(Number number,int scale){
		String dfFormat="###,##0";
		for(int i=1;i<=scale;i++){
			if (i==1) {
				dfFormat +=".0";
			}else {
				dfFormat +="0";
			}
		}
		return (String)format(number,dfFormat,scale);
	}
	
	/**
	 * 将数字保留两位小数后，格式化为正负号显示的形式，并以千分号隔开<br/>
	 * 如：调用Arith.formatSignWithThousandth(1234567)，则返回的字符串为“+1,234,567.00"<br/>
	 * 	   调用Arith.formatSignWithThousandth(-1234567)，则返回的字符串为“-1,234,567.00"
	 * @param nubmer
	 * 	要格式化的字符串
	 * @return
	 */
	public static String formatSignWithThousandth(Number number){
		return (String)format(number,"+###,###.00;-###,###.00",2);
	}
	
	/**
	 * 将数字保留两位小数后，格式化为正负号显示的形式，并以千分号隔开<br/>
	 * 如：调用Arith.formatSignWithThousandth(1234567)，则返回的字符串为“+1,234,567.00"<br/>
	 * 	   调用Arith.formatSignWithThousandth(-1234567)，则返回的字符串为“-1,234,567.00"
	 * @param nubmer
	 * 	要格式化的字符串
	 * @return
	 */
	public static String formatSignWithThousandth(Number number,int scale){
		String dfFormat="###,###";
		for(int i=1;i<=scale;i++){
			if (i==1) {
				dfFormat +=".0";
			}else {
				dfFormat +="0";
			}
		}
		dfFormat= "+" + dfFormat +";-"+dfFormat;
		return (String)format(number,dfFormat,2);
	}
	
	/**
	 * 将数字保留两位小数后，格式化为正负号显示的形式<br/>
	 * 如：调用Arith.formatSignWithThousandth(1234567)，则返回的字符串为“+1,234,567.00"<br/>
	 * 	   调用Arith.formatSignWithThousandth(-1234567)，则返回的字符串为“-1,234,567.00"
	 * @param nubmer
	 * 	要格式化的字符串
	 * @return
	 */
	public static String formatSign(Number number){
		return (String)format(number,"+###.00;-###.00",2);
	}
	
	/**
	 * 将数字保留两位小数后，格式化为正负号显示的形式<br/>
	 * 如：调用Arith.formatSignWithThousandth(1234567)，则返回的字符串为“+1,234,567.00"
	 * 	   调用Arith.formatSignWithThousandth(-1234567)，则返回的字符串为“-1,234,567.00"
	 * @param nubmer
	 * 	要格式化的字符串
	 * @return
	 */
	public static String formatSign(Number number,int scale){
		String dfFormat="###";
		for(int i=1;i<=scale;i++){
			if (i==1) {
				dfFormat +=".0";
			}else {
				dfFormat +="0";
			}
		}
		dfFormat= "+" + dfFormat +";-"+dfFormat;
		return (String)format(number,dfFormat,2);
	}
	/**
	 * 通过指定格式和精度，格式化某一字符串<b>[注释较长，请按F2查看完整版本]</b>
	 * @param number
	 * 		要格式化的数字
	 * @param pattern
	 * 	格式化字符串，此处应注意，格式化后涉及到保留小数位数的情况时，要保留的小数位数是由pattern中的<b>"."</b>之后的几个0决定和第三个参数scale共同决定的,比如要保留三位小数，则格式应为####.000（三个0）
	 *  同时第三个参数scale传入3，这时才会得到正确的结果。
	 * 常用的有如下格式：<br/>
	 * <p>	<b>①"###,###.000" </b>小数<br/>
	 * 		例:将1234.03455格式化为三位小数，请按如下方法方式调用：Arith.format(1234.03455,"###.000",3)，返回值为1234.035
	 * </p>
	 * <p>
	 *  <b>②"########E00"</b> 科学计数法<br/>
	 *  	例：将1234.03455保留三位小数后，再按科学计数法表示，请按如下方式调用：Arith.format(1234.03455,"###.000",3)，返回值为1234.034E00
	 *  <br/>
	 *  </p>
	 *  <p><b>③"#.############%"</b> 百分数</br>
	 *  	例：将0.003456按先保留5位小数后，再按百分数显示，请按如下方式调用：Arith.format(0.003456,"#.############%",5)，返回值为0.346%
	 *  		若要将百分数显示后的数字指定小数位数，请调用Arith.formatPercent(Number number,int scale)方法
	 *  </p>
	 *  <p>
	 *  	<b>④"###,##0.00"</b> 千分数<br/>
	 *  	例：将1234567.0034保留两位小数后，每三位用逗号隔开显示，请按如下方式调用：Arith.format(1234567.0034,"###,##0.00",2),返回值：1,234,567.00
	 *  </p>
	 *  <p>
	 *  	<b>⑤"\u00A4#.0000"</b>	本地货币符号</br>
	 *  	例：将1234.653保留两位小数后，再格式化为￥1234.65显示，请按如下方式调用：Arith.format(1234.653,"###,##0.00",2),返回值：￥1234.65
	 *  </p>
	 *  <p> 
	 *  	<b>⑥"+###,###.00;-###,###.00"</b> 分割正负号，正数增加正号，负数增加负号<br/>
	 *  	例：将12345.065保留两位小数后，再格式化为前面加正号显示，请按如下方式调用：Arith.format(12345.065,"+###,###.00;-###,###.00",2),返回值：+12345.06
	 *  </p>
	 * @param scale
	 *		要保留的小数位数
	 * @return
	 * 	pattern指定格式的字符串
	 */
	public static String format(Number number,String pattern,int scale){
		BigDecimal bd =new BigDecimal(String.valueOf(number));
		BigDecimal one = new BigDecimal("1");
		double d = bd.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		DecimalFormat df =(DecimalFormat)DecimalFormat.getInstance();
		df.applyPattern(pattern);
		String obj =df.format(d);
		return obj;
	}
	
//	public static void main(String[] args) {
////		System.out.println(Arith.round(12, 3));
////		System.out.println(Arith.formatNumber(0));
////		System.out.println(Arith.format(12345.065,"+###,###.00;-###,###.00",2));
//		System.out.println(Arith.formatPercent(33,3));
//		System.out.println(Arith.formatNumber(3333,1));
////		System.out.println(formatSignWithThousandth(123456,3));
////		System.out.println(formatSign(123456,3));
//	}
}
