/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.informix.util.dateUtil;
import com.sinosoft.lis.db.LDSysVarDB;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.JdbcUrl;
import com.sinosoft.utility.Reflections;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.Schema;
import com.sinosoft.utility.SchemaSet;
import com.sinosoft.utility.StrTool;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sinosoft.utility.SysLog;

/**
 * <p>
 * Title: Web业务系统
 * </p>
 * <p>
 * Description:业务系统的公共业务处理函数 该类包含所有业务处理中的公共函数，和以前系统中的funpub.4gl
 * 文件相对应。在这个类中，所有的函数都采用Static的类型，所有需要的数据都是 通过参数传入的，在本类中不采用通过属性传递数据的方法。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author YT
 * @version 1.0
 */
public class PubFun {
	private static Logger log4moreRec = SysLog.getLogger("DBQueryMonitor");

	public PubFun() {
	}

	/**
	 * 函数功能：数值由十进制转换为X进制数值 函数参数：hex：目标进制 （STRING型）；num：数值（STRING型）
	 * 输出结果：返回输入数值（num）的hex进制数值（STRING型）
	 */
	public static String metricationToX(String num, String hex) {
		String str = "";
		String rt = "";
		String regex = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_@";

		num = num.replaceAll("\\s", "");

		if (num.equals("") || num == null) {
			return str;
		}
		java.math.BigInteger bignum = new java.math.BigInteger(num, 10);
		java.math.BigInteger bighex = new java.math.BigInteger(hex, 10);

		int i = bighex.intValue();
		String a = regex.substring(0, i);
		while (bignum.compareTo(BigInteger.ZERO) != 0) {
			BigInteger[] e = bignum.divideAndRemainder(bighex);
			int j = e[1].intValue();
			rt = a.charAt(j) + rt;
			bignum = (bignum.subtract(e[1])).divide(bighex);
		}
		return rt;
	}

	/**
	 * 函数功能：数值由X进制转换为十进制数值 函数参数：hex：原数值进制 （STRING型）；num：数值（STRING型）
	 * 输出结果：返回输入数值（num）的十进制数值（STRING型）
	 */

	public static String xToMetrication(String num, String hex) {
		String str = "";
		String regex = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_@";
		num = num.replaceAll("\\s", "");

		if (num.equals("") || num == null) {
			return str;
		}
		BigInteger bigone = new BigInteger("1", 10);
		BigInteger bigzero = new BigInteger("0", 10);

		int i = Integer.parseInt(hex);
		String a = regex.substring(0, i);
		for (int x = num.length() - 1; x > -1; x--) {
			bigzero = bigzero.add(bigone.multiply(new BigInteger(a.indexOf(num
					.charAt(x)) + "", 10)));
			bigone = bigone.multiply(new BigInteger(hex, 10));

		}
		return bigzero.toString() + "";
	}

	/**
	 * 函数功能：数值由X进制转换为Y进制数值 函数参数：orihex：原进制 （STRING型）；num：数值（STRING型）；
	 * targerhex：目标进制（STRING型） 输出结果：返回输入数值（num）的Y进制数值（STRING型）
	 */
	public static String XtoY(String orihex, String num, String targerhex) {

		String resultstr = xToMetrication(orihex, num);
		resultstr = metricationToX(targerhex, resultstr);
		return resultstr;
	}

	/**
	 * 判断是否为闰年 XinYQ added on 2006-09-25
	 */
	public static boolean isLeapYear(int nYear) {
		boolean ResultLeap = false;
		ResultLeap = (nYear % 400 == 0) | (nYear % 100 != 0) & (nYear % 4 == 0);
		return ResultLeap;
	}

	/**
	 * 提供精确的小数位四舍五入处理,显示指定格式数字。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return (string型) 四舍五入后的结果
	 */
	public static String roundString(double d, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(d));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 提供精确的小数位四舍五入处理,显示指定格式数字。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return (double型) 四舍五入后的结果
	 */
	public static double roundDouble(double d, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(d));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 计算日期的函数 author: HST 参照日期指当按照年月进行日期的计算的时候，参考的日期，如下例，结果返回2002-03-31
	 * <p>
	 * <b>Example: </b>
	 * <p>
	 * <p>
	 * FDate tD=new FDate();
	 * <p>
	 * <p>
	 * Date baseDate =new Date();
	 * <p>
	 * <p>
	 * baseDate=tD.getDate("2000-02-29");
	 * <p>
	 * <p>
	 * Date comDate =new Date();
	 * <p>
	 * <p>
	 * comDate=tD.getDate("1999-12-31");
	 * <p>
	 * <p>
	 * int inteval=1;
	 * <p>
	 * <p>
	 * String tUnit="M";
	 * <p>
	 * <p>
	 * Date tDate =new Date();
	 * <p>
	 * <p>
	 * tDate=PubFun.calDate(baseDate,inteval,tUnit,comDate);
	 * <p>
	 * <p>
	 * System.out.println(tDate.toString());
	 * <p>
	 * 
	 * @param baseDate
	 *            起始日期
	 * @param interval
	 *            时间间隔
	 * @param unit
	 *            时间间隔单位
	 * @param compareDate
	 *            参照日期
	 * @return Date类型变量
	 */
	public static Date calDate(Date baseDate, int interval, String unit,
			Date compareDate) {
		Date returnDate = null;

		GregorianCalendar tBaseCalendar = new GregorianCalendar();
		tBaseCalendar.setTime(baseDate);

		if (unit.equals("Y")) {
			tBaseCalendar.add(Calendar.YEAR, interval);
		}
		if (unit.equals("M")) {
			tBaseCalendar.add(Calendar.MONTH, interval);
		}
		if (unit.equals("D")) {
			tBaseCalendar.add(Calendar.DATE, interval);
		}

		if (compareDate != null) {
			GregorianCalendar tCompCalendar = new GregorianCalendar();
			tCompCalendar.setTime(compareDate);
			int nBaseYears = tBaseCalendar.get(Calendar.YEAR);
			int nBaseMonths = tBaseCalendar.get(Calendar.MONTH);
			int nCompMonths = tCompCalendar.get(Calendar.MONTH);
			int nCompDays = tCompCalendar.get(Calendar.DATE);

			if (unit.equals("Y")) {
				tCompCalendar.set(nBaseYears, nCompMonths, nCompDays);
				if (tCompCalendar.before(tBaseCalendar)) {
					tBaseCalendar.set(nBaseYears + 1, nCompMonths, nCompDays);
					returnDate = tBaseCalendar.getTime();
				} else {
					returnDate = tCompCalendar.getTime();
				}
			}
			if (unit.equals("M")) {
				tCompCalendar.set(nBaseYears, nBaseMonths, nCompDays);
				if (tCompCalendar.before(tBaseCalendar)) {
					tBaseCalendar.set(nBaseYears, nBaseMonths + 1, nCompDays);
					returnDate = tBaseCalendar.getTime();
				} else {
					returnDate = tCompCalendar.getTime();
				}
			}
			if (unit.equals("D")) {
				returnDate = tBaseCalendar.getTime();
			}
			tCompCalendar = null;
		} else {
			returnDate = tBaseCalendar.getTime();

			// XinYQ added on 2006-09-25 : 修正闰年闰月和月底天数,和Oracle保持一致
			GregorianCalendar tLeapCalendar = new GregorianCalendar();
			tLeapCalendar.setTime(returnDate);
			int arrComnYearEndDate[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30,
					31, 30, 31 };
			int arrLeapYearEndDate[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30,
					31, 30, 31 };
			int nOldYear = 1900 + baseDate.getYear();
			int nOldMonth = baseDate.getMonth();
			int nOldDate = baseDate.getDate();
			int nNewYear = tLeapCalendar.get(Calendar.YEAR);
			int nNewMonth = tLeapCalendar.get(Calendar.MONTH);

			if ((isLeapYear(nOldYear) && nOldDate == arrLeapYearEndDate[nOldMonth])
					|| (!isLeapYear(nOldYear) && nOldDate == arrComnYearEndDate[nOldMonth])) {
				if (unit != null
						&& (unit.equalsIgnoreCase("Y") || unit
								.equalsIgnoreCase("M"))) {
					if (isLeapYear(nNewYear)) {
						returnDate.setDate(arrLeapYearEndDate[nNewMonth]);
					} else {
						returnDate.setDate(arrComnYearEndDate[nNewMonth]);
					}
				}
			}
			tLeapCalendar = null;
		}
		tBaseCalendar = null;

		return returnDate;
	}

	/**
	 * 重载计算日期，参数见楼上，add by Minim
	 * 
	 * @param baseDate
	 *            String
	 * @param interval
	 *            int
	 * @param unit
	 *            String
	 * @param compareDate
	 *            String
	 * @return String
	 */
	public static String calDate(String baseDate, int interval, String unit,
			String compareDate) {
		try {
			FDate tFDate = new FDate();
			Date bDate = tFDate.getDate(baseDate);
			Date cDate = tFDate.getDate(compareDate);
			return tFDate.getString(calDate(bDate, interval, unit, cDate));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String calOFDate(String baseDate, int interval, String unit,
			String compareDate) {
		try {
			FDate tFDate = new FDate();
			Date bDate = tFDate.getDate(baseDate);
			Date cDate = tFDate.getDate(compareDate);
			return tFDate.getString(calOFDate(bDate, interval, unit, cDate));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Date calOFDate(Date baseDate, int interval, String unit,
			Date compareDate) {
		Date returnDate = null;

		GregorianCalendar mCalendar = new GregorianCalendar();
		// 设置起始日期格式
		mCalendar.setTime(baseDate);
		if (unit.equals("Y")) {
			mCalendar.add(Calendar.YEAR, interval);
		}
		if (unit.equals("M")) {
			// 执行月份增减
			mCalendar.add(Calendar.MONTH, interval);
		}
		if (unit.equals("D")) {
			mCalendar.add(Calendar.DATE, interval);
		}

		if (compareDate != null) {
			GregorianCalendar cCalendar = new GregorianCalendar();
			// 设置坐标日期
			cCalendar.setTime(compareDate);

			int mYears = mCalendar.get(Calendar.YEAR);
			int mMonths = mCalendar.get(Calendar.MONTH);
			int cMonths = cCalendar.get(Calendar.MONTH);
			int cDays = cCalendar.get(Calendar.DATE);

			if (unit.equals("Y")) {
				cCalendar.set(mYears, cMonths, cDays);
				if (mMonths < cCalendar.get(Calendar.MONTH)) {
					cCalendar.set(mYears, mMonths + 1, 0);
				}
				if (cCalendar.before(mCalendar)) {
					mCalendar.set(mYears + 1, cMonths, cDays);
					returnDate = mCalendar.getTime();
				} else {
					returnDate = cCalendar.getTime();
				}
			}
			if (unit.equals("M")) {
				cCalendar.set(mYears, mMonths, cDays);

				if (mMonths < cCalendar.get(Calendar.MONTH)) {
					// 取当前月的最后一天日期
					cCalendar.set(mYears, mMonths + 1, 0);
				}
				if (cCalendar.before(mCalendar)) {
					mCalendar.set(mYears, mMonths + 1, cDays);
					returnDate = mCalendar.getTime();
				} else {
					returnDate = cCalendar.getTime();
				}
			}
			if (unit.equals("D")) {
				returnDate = mCalendar.getTime();
			}
		} else {
			returnDate = mCalendar.getTime();
		}

		return returnDate;
	}

	/**
	 * 生成付费方式，add by GaoHT
	 * 
	 * @param SSRS
	 *            nSSRS
	 * @return String 按收费方式生成该笔退费的退费方式
	 */

	public static String PayModeTransform(SSRS nSSRS) {
		try {
			int Cash = 0; // 现金
			int Cheque = 0; // 支票
			int Bank = 0; // 银行划款
			int Pos = 0; // Pos收款
			String tOutPayMode = "";
			for (int i = 1; i <= nSSRS.getMaxRow(); i++) {
				String tPayMode = nSSRS.GetText(i, 1);
				if (tPayMode.equals("3") || tPayMode.equals("4")) {
					Cheque++;
				} else if (tPayMode.equals("6")) {
					Pos++;
				} else if (tPayMode.equals("7")) {
					Bank++;
				} else {
					Cash++;
				}
			}
			System.out.println("临时付费方式中 现金:::::::::（" + Cash + "） 笔");
			System.out.println("临时付费方式中 支票:::::::::（" + Cheque + "） 笔");
			System.out.println("临时付费方式中 POS:::::::::（" + Pos + "） 笔");
			System.out.println("临时付费方式中 代收:::::::::（" + Bank + "） 笔");
			System.out
					.println("---------------------根据优先级决定付费方式--------------------");

			if (Cheque > 0) // 支票优先级最高
			{
				tOutPayMode = "3";
			} else if (Bank > 0) // 银行代付其次
			{
				tOutPayMode = "4";
			} else if (Cash > 0) // 其他为现金
			{
				tOutPayMode = "1";
			} else if (Pos > 0) // 只有一个pos
			{
				tOutPayMode = "6";
			}

			return tOutPayMode;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔 author: HST
	 * <p>
	 * <b>Example: </b>
	 * <p>
	 * <p>
	 * 参照calInterval(String cstartDate, String cendDate, String
	 * unit)，前两个变量改为日期型即可
	 * <p>
	 * 
	 * @param startDate
	 *            起始日期，Date变量
	 * @param endDate
	 *            终止日期，Date变量
	 * @param unit
	 *            时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
	 * @return 时间间隔,整形变量int
	 */
	public static int calInterval(Date startDate, Date endDate, String unit) {
		int interval = 0;

		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(Calendar.YEAR);
		int sMonths = sCalendar.get(Calendar.MONTH);
		int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		int eMonths = eCalendar.get(Calendar.MONTH);
		int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

		if (unit.equals("Y")) {
			interval = eYears - sYears;
			if (eMonths < sMonths) {
				interval--;
			} else {
				if (eMonths == sMonths && eDays < sDays) {
					interval--;
					if (eMonths == 1) { // 如果同是2月，校验润年问题
						if ((sYears % 4) == 0 && (eYears % 4) != 0) { // 如果起始年是润年，终止年不是润年
							if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么补一
								interval++;
							}
						}
					}
				}
			}
		}
		if (unit.equals("M")) {
			interval = eYears - sYears;
			// interval = interval * 12;
			interval *= 12;

			// interval = eMonths - sMonths + interval;
			interval += eMonths - sMonths;
			if (eDays < sDays) {
				interval--;
				// eDays如果是月末，则认为是满一个月
				int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
				if (eDays == maxDate) {
					interval++;
				}
			}
		}
		if (unit.equals("D")) {
			// ====del===liuxs===2006-09-09=====修改日期间隔计算漏洞================BGN=========
			// interval = eYears - sYears;
			// // interval = interval * 365;
			// interval *= 365;
			// // interval = eDaysOfYear - sDaysOfYear + interval;
			// interval += eDaysOfYear - sDaysOfYear;
			//
			// // 处理润年
			// int n = 0;
			// eYears--;
			// if (eYears > sYears)
			// {
			// int i = sYears % 4;
			// if (i == 0)
			// {
			// sYears++;
			// n++;
			// }
			// int j = (eYears) % 4;
			// if (j == 0)
			// {
			// eYears--;
			// n++;
			// }
			// n += (eYears - sYears) / 4;
			// }
			// if (eYears == sYears)
			// {
			// int i = sYears % 4;
			// if (i == 0)
			// {
			// n++;
			// }
			// }
			// interval += n;
			// ====del===liuxs===2006-09-09=====修改日期间隔计算漏洞================END=========
			// ====add===liuxs===2006-09-09=====修改日期间隔计算漏洞================BGN=========
			sCalendar.set(sYears, sMonths, sDays);
			eCalendar.set(eYears, eMonths, eDays);
			long lInterval = (eCalendar.getTime().getTime() - sCalendar
					.getTime().getTime()) / 86400000;
			interval = (int) lInterval;
			// ====add===liuxs===2006-09-09=====修改日期间隔计算漏洞================END=========
		}
		return interval;
	}

	/**
	 * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，舍弃法 author: HST
	 * 起始日期，(String,格式："YYYY-MM-DD")
	 * 
	 * @param cstartDate
	 *            String 终止日期，(String,格式："YYYY-MM-DD")
	 * @param cendDate
	 *            String 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
	 * @param unit
	 *            String 时间间隔,整形变量int
	 * @return int
	 */
	public static int calInterval(String cstartDate, String cendDate,
			String unit) {
		FDate fDate = new FDate();
		Date startDate = fDate.getDate(cstartDate);
		Date endDate = fDate.getDate(cendDate);
		if (fDate.mErrors.needDealError()) {
			return 0;
		}

		int interval = 0;

		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(Calendar.YEAR);
		int sMonths = sCalendar.get(Calendar.MONTH);
		int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		int eMonths = eCalendar.get(Calendar.MONTH);
		int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

		if (StrTool.cTrim(unit).equals("Y")) {
			interval = eYears - sYears;

			if (eMonths < sMonths) {
				interval--;
			} else {
				if (eMonths == sMonths && eDays < sDays) {
					interval--;
					if (eMonths == 1) { // 如果同是2月，校验润年问题
						if ((sYears % 4) == 0 && (eYears % 4) != 0) { // 如果起始年是润年，终止年不是润年
							if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么补一
								interval++;
							}
						}
					}
				}
			}
		}
		if (StrTool.cTrim(unit).equals("M")) {
			interval = eYears - sYears;
			// interval = interval * 12;
			interval *= 12;
			// interval = eMonths - sMonths + interval;
			interval += eMonths - sMonths;

			if (eDays < sDays) {
				interval--;
				// eDays如果是月末，则认为是满一个月
				int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
				if (eDays == maxDate) {
					interval++;
				}
			}
		}
		if (StrTool.cTrim(unit).equals("D")) {
			// ====del===liuxs===2006-09-09=====修改日期间隔计算漏洞================BGN=========
			// interval = eYears - sYears;
			// // interval = interval * 365;
			// interval *= 365;
			// // interval = eDaysOfYear - sDaysOfYear + interval;
			// interval += eDaysOfYear - sDaysOfYear;
			//
			// // 处理润年
			// int n = 0;
			// eYears--;
			// if (eYears > sYears)
			// {
			// int i = sYears % 4;
			// if (i == 0)
			// {
			// sYears++;
			// n++;
			// }
			// int j = (eYears) % 4;
			// if (j == 0)
			// {
			// eYears--;
			// n++;
			// }
			// n += (eYears - sYears) / 4;
			// }
			// if (eYears == sYears)
			// {
			// int i = sYears % 4;
			// if (i == 0)
			// {
			// n++;
			// }
			// }
			// interval += n;
			// ====del===liuxs===2006-09-09=====修改日期间隔计算漏洞================END=========
			// ====add===liuxs===2006-09-09=====修改日期间隔计算漏洞================BGN=========
			sCalendar.set(sYears, sMonths, sDays);
			eCalendar.set(eYears, eMonths, eDays);
			long lInterval = (eCalendar.getTime().getTime() - sCalendar
					.getTime().getTime()) / 86400000;
			interval = (int) lInterval;
			// ====add===liuxs===2006-09-09=====修改日期间隔计算漏洞================END=========

		}
		return interval;
	}

	/**
	 * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，约进法 author: YangZhao，Minim
	 * 起始日期，(String,格式："YYYY-MM-DD")
	 * 
	 * @param cstartDate
	 *            String 终止日期，(String,格式："YYYY-MM-DD")
	 * @param cendDate
	 *            String 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
	 * @param unit
	 *            String 时间间隔,整形变量int
	 * @return int
	 */
	public static int calInterval2(String cstartDate, String cendDate,
			String unit) {
		FDate fDate = new FDate();
		Date startDate = fDate.getDate(cstartDate);
		Date endDate = fDate.getDate(cendDate);
		if (fDate.mErrors.needDealError()) {
			return 0;
		}

		int interval = 0;

		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(Calendar.YEAR);
		int sMonths = sCalendar.get(Calendar.MONTH);
		int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		int eMonths = eCalendar.get(Calendar.MONTH);
		int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

		if (StrTool.cTrim(unit).equals("Y")) {
			interval = eYears - sYears;

			if (eMonths > sMonths) {
				interval++;
			} else {
				if (eMonths == sMonths && eDays > sDays) {
					interval++;
					if (eMonths == 1) { // 如果同是2月，校验润年问题
						if ((sYears % 4) == 0 && (eYears % 4) != 0) { // 如果起始年是润年，终止年不是润年
							if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么减一
								interval--;
							}
						}
					}
				}
			}
		}
		if (StrTool.cTrim(unit).equals("M")) {
			interval = eYears - sYears;
			// interval = interval * 12;
			interval *= 12;
			// interval = eMonths - sMonths + interval;
			interval += eMonths - sMonths;

			if (eDays > sDays) {
				interval++;
				// eDays如果是月末，则认为是满一个月 //eDays，改为sDays
				int maxDate = sCalendar.getActualMaximum(Calendar.DATE); // eCalendar，应该是sCalendar
				if (sDays == maxDate) { // eDays，应该是sDays
					interval--;
				}
			}
		}
		if (StrTool.cTrim(unit).equals("D")) {
			// ====del===liuxs===2006-09-09=====修改日期间隔计算漏洞================BGN=========
			// interval = eYears - sYears;
			// // interval = interval * 365;
			// interval *= 365;
			// // interval = eDaysOfYear - sDaysOfYear + interval;
			// interval += eDaysOfYear - sDaysOfYear;
			//
			// // 处理润年
			// int n = 0;
			// eYears--;
			// if (eYears > sYears)
			// {
			// int i = sYears % 4;
			// if (i == 0)
			// {
			// sYears++;
			// n++;
			// }
			// int j = (eYears) % 4;
			// if (j == 0)
			// {
			// eYears--;
			// n++;
			// }
			// n += (eYears - sYears) / 4;
			// }
			// if (eYears == sYears)
			// {
			// int i = sYears % 4;
			// if (i == 0)
			// {
			// n++;
			// }
			// }
			// interval += n;
			// ====del===liuxs===2006-09-09=====修改日期间隔计算漏洞================END=========
			// ====add===liuxs===2006-09-09=====修改日期间隔计算漏洞================BGN=========
			sCalendar.set(sYears, sMonths, sDays);
			eCalendar.set(eYears, eMonths, eDays);
			long lInterval = (eCalendar.getTime().getTime() - sCalendar
					.getTime().getTime()) / 86400000; // 24*60*60*1000
			// 一天对应的毫秒数
			interval = (int) lInterval;
			// ====add===liuxs===2006-09-09=====修改日期间隔计算漏洞================END=========
		}
		return interval;
	}

	/**
	 * 通过传入的日期可以得到所在月的第一天和最后一天的日期 author: LH 日期，(String,格式："YYYY-MM-DD")
	 * 
	 * @param tDate
	 *            String 本月开始和结束日期，返回String[2]
	 * @return String[]
	 */
	public static String[] calFLDate(String tDate) {
		String MonDate[] = new String[2];
		FDate fDate = new FDate();
		Date CurDate = fDate.getDate(tDate);
		GregorianCalendar mCalendar = new GregorianCalendar();
		mCalendar.setTime(CurDate);
		int Years = mCalendar.get(Calendar.YEAR);
		int Months = mCalendar.get(Calendar.MONTH);
		int FirstDay = mCalendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		int LastDay = mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		mCalendar.set(Years, Months, FirstDay);
		MonDate[0] = fDate.getString(mCalendar.getTime());
		mCalendar.set(Years, Months, LastDay);
		MonDate[1] = fDate.getString(mCalendar.getTime());
		return MonDate;
	}

	/**
	 * 通过传入的日期可以得到宽限期止期(包括延长宽限期) 起始日期，(String,格式："YYYY-MM-DD")
	 * 
	 * @param startDate
	 *            String
	 * @param strRiskCode
	 *            String
	 * @return String
	 */

	/**
	 * 得到默认的JDBCUrl
	 * 
	 * @return JDBCUrl
	 */
	public static JdbcUrl getDefaultUrl() {
		JdbcUrl tUrl = new JdbcUrl();
		return tUrl;
	}

	/**
	 * 将字符串补数,将sourString的<br>
	 * 后面</br>用cChar补足cLen长度的字符串,如果字符串超长，则不做处理
	 * <p>
	 * <b>Example: </b>
	 * <p>
	 * <p>
	 * RCh("Minim", "0", 10) returns "Minim00000"
	 * <p>
	 * 
	 * @param sourString
	 *            源字符串
	 * @param cChar
	 *            补数用的字符
	 * @param cLen
	 *            字符串的目标长度
	 * @return 字符串
	 */
	public static String RCh(String sourString, String cChar, int cLen) {
		int tLen = sourString.length();
		int i, iMax;
		String tReturn = "";
		if (tLen >= cLen) {
			return sourString;
		}
		iMax = cLen - tLen;
		for (i = 0; i < iMax; i++) {
			tReturn += cChar;
		}
		tReturn = sourString.trim() + tReturn.trim();
		return tReturn;
	}

	/**
	 * 将字符串补数,将sourString的<br>
	 * 前面</br>用cChar补足cLen长度的字符串,如果字符串超长，则不做处理
	 * <p>
	 * <b>Example: </b>
	 * <p>
	 * <p>
	 * LCh("Minim", "0", 10) returns "00000Minim"
	 * <p>
	 * 
	 * @param sourString
	 *            源字符串
	 * @param cChar
	 *            补数用的字符
	 * @param cLen
	 *            字符串的目标长度
	 * @return 字符串
	 */
	public static String LCh(String sourString, String cChar, int cLen) {
		int tLen = sourString.length();
		int i, iMax;
		String tReturn = "";
		if (tLen >= cLen) {
			return sourString;
		}
		iMax = cLen - tLen;
		for (i = 0; i < iMax; i++) {
			tReturn += cChar;
		}
		tReturn = tReturn.trim() + sourString.trim();
		return tReturn;
	}

	/**
	 * 比较获取两天中较后的一天
	 * 
	 * @param date1
	 *            String
	 * @param date2
	 *            String
	 * @return String
	 */
	public static String getLaterDate(String date1, String date2) {
		try {
			date1 = StrTool.cTrim(date1);
			date2 = StrTool.cTrim(date2);
			if (date1.equals("")) {
				return date2;
			}
			if (date2.equals("")) {
				return date1;
			}
			FDate fd = new FDate();
			Date d1 = fd.getDate(date1);
			Date d2 = fd.getDate(date2);
			if (d1.after(d2)) {
				return date1;
			}
			return date2;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * 比较获取两天中较早的一天
	 * 
	 * @param date1
	 *            String
	 * @param date2
	 *            String
	 * @return String
	 */
	public static String getBeforeDate(String date1, String date2) {
		try {
			date1 = StrTool.cTrim(date1);
			date2 = StrTool.cTrim(date2);
			if (date1.equals("")) {
				return date2;
			}
			if (date2.equals("")) {
				return date1;
			}
			FDate fd = new FDate();
			Date d1 = fd.getDate(date1);
			Date d2 = fd.getDate(date2);
			if (d1.before(d2)) {
				return date1;
			}
			return date2;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

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
		String tString = df.format(today);
		return tString;
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
		String tString = df.format(today);
		return tString;
	}

	/**
	 * 得到当前系统时间 author: YT
	 * 
	 * @return 当前时间的格式字符串，时间格式为"HH:mm:ss"
	 */
	public static String getCurrentDetailDateTime() {
		String pattern = "yyyyMMddhhmmssSSS";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	public static String getFormatString(String tString,int tLength,char tRepeat) {
		if(tString.length()>=tLength){
			return tString.substring(0,tLength);
		}else{
			return StringUtils.repeat(String.valueOf(tRepeat),tLength-tString.length())+tString;
		}
	}

	/**
	 * 获取明天信息
	 * 
	 * @return String
	 */
	public static String getTomorrow() {
		// 返回日期的格式化样式
		String tFormatDate = "yyyy-MM-dd";
		// 创建格式化对象
		SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
		// 获取当前日期
		Calendar tCalendar = Calendar.getInstance();
		// 取出“日月”数
		int tDay = tCalendar.get(Calendar.DAY_OF_MONTH);
		// 将“日”加一，即得到明天
		++tDay;
		// 将“日”数设置回去
		tCalendar.set(Calendar.DAY_OF_MONTH, tDay);
		return tSimpleDateFormat.format(tCalendar.getTime());
	}

	/*
	 * Function:获取系统昨天的日期 Author:wellhi Date:2006-07-06 Para:无
	 * Return:"yyyy-mm-dd"的日期字符串；
	 */
	public static String getYestoday() {
		// 返回日期的格式化样式
		String tFormatDate = "yyyy-MM-dd";
		// 创建格式化对象
		SimpleDateFormat tSimpleDateFormat = new SimpleDateFormat(tFormatDate);
		// 获取当前日期
		Calendar tCalendar = Calendar.getInstance();
		// 取出“日月”数
		int tDay = tCalendar.get(Calendar.DAY_OF_MONTH);
		// 将“日”加一，即得到明天
		--tDay;
		// 将“日”数设置回去
		tCalendar.set(Calendar.DAY_OF_MONTH, tDay);
		return tSimpleDateFormat.format(tCalendar.getTime());
	}

	/**
	 * 得到流水号前导 author: YT
	 * 
	 * @param comCode
	 *            机构代码
	 * @return 流水号的前导字符串
	 */
	public static String getNoLimit(String comCode) {
		comCode = comCode.trim();
		int tLen = comCode.length();
		if (tLen > 6) {
			comCode = comCode.substring(0, 6);
		}
		if (tLen < 6) {
			comCode = RCh(comCode, "0", 6);
		}
		String tString = "";
		tString = comCode + getCurrentDate().substring(0, 4);
		return tString;
	}

	/**
	 * picc获取管理机构，截取管理代码的第3-6位（二级机构+三级机构） 再加上日期编码的两位年两位月日日 052203
	 * 
	 * @param comCode
	 *            String
	 * @return String
	 */
	public static String getPiccNoLimit(String comCode) {
		comCode = comCode.trim();
		System.out.println("comCode :" + comCode);
		int tLen = comCode.length();
		if (tLen == 8) {
			comCode = comCode.substring(2, 6);
		}
		if (tLen == 4) {
			comCode = comCode.substring(2, 4) + "00";
		}
		System.out.println("SubComCode :" + comCode);
		String tString = "";
		tString = comCode + getCurrentDate().substring(2, 4)
				+ getCurrentDate().substring(5, 7)
				+ getCurrentDate().substring(8, 10);
		System.out.println("PubFun getPiccNoLimit : " + tString);
		return tString;
	}

	/**
	 * 该函数得到c_Str中的第c_i个以c_Split分割的字符串
	 * 
	 * @param c_Str
	 *            目标字符串
	 * @param c_i
	 *            位置
	 * @param c_Split
	 *            分割符
	 * @return 如果发生异常，则返回空
	 */
	public static String getStr(String c_Str, int c_i, String c_Split) {
		String t_Str1 = "", t_Str2 = "", t_strOld = "";
		int i = 0, i_Start = 0;
		// int j_End = 0;
		t_Str1 = c_Str;
		t_Str2 = c_Split;
		i = 0;
		try {
			while (i < c_i) {
				i_Start = t_Str1.indexOf(t_Str2, 0);
				if (i_Start >= 0) {
					i += 1;
					t_strOld = t_Str1;
					t_Str1 = t_Str1.substring(i_Start + t_Str2.length(),
							t_Str1.length());
				} else {
					if (i != c_i - 1) {
						t_Str1 = "";
					}
					break;
				}
			}

			if (i_Start >= 0) {
				t_Str1 = t_strOld.substring(0, i_Start);
			}
		} catch (Exception ex) {
			t_Str1 = "";
		}
		return t_Str1;
	}

	/**
	 * 把数字金额转换为中文大写金额 author: HST
	 * 
	 * @param money
	 *            数字金额(double)
	 * @return 中文大写金额(String)
	 */
	public static String getChnMoney(double money) {
		String ChnMoney = "";
		String s0 = "";

		// 在原来版本的程序中，getChnMoney(585.30)得到的数据是585.29。

		if (money == 0.0) {
			ChnMoney = "零元整";
			return ChnMoney;
		}

		if (money < 0) {
			s0 = "负";
			money *= (-1);
		}

		String sMoney = new DecimalFormat("0").format(money * 100);

		int nLen = sMoney.length();
		String sInteger;
		String sDot;
		if (nLen < 2) {
			// add by JL at 2004-9-14
			sInteger = "";
			if (nLen == 1) {
				sDot = "0" + sMoney.substring(nLen - 1, nLen);
			} else {
				sDot = "0";
			}
		} else {
			sInteger = sMoney.substring(0, nLen - 2);
			sDot = sMoney.substring(nLen - 2, nLen);
		}

		String sFormatStr = PubFun.formatStr(sInteger);

		String s1 = PubFun.getChnM(sFormatStr.substring(0, 4), "亿");

		String s2 = PubFun.getChnM(sFormatStr.substring(4, 8), "万");

		String s3 = PubFun.getChnM(sFormatStr.substring(8, 12), "");

		String s4 = PubFun.getDotM(sDot);

		if (s1.length() > 0 && s1.substring(0, 1).equals("0")) {
			s1 = s1.substring(1, s1.length());
		}
		if (s1.length() > 0
				&& s1.substring(s1.length() - 1, s1.length()).equals("0")
				&& s2.length() > 0 && s2.substring(0, 1).equals("0")) {
			s1 = s1.substring(0, s1.length() - 1);
		}
		if (s2.length() > 0
				&& s2.substring(s2.length() - 1, s2.length()).equals("0")
				&& s3.length() > 0 && s3.substring(0, 1).equals("0")) {
			s2 = s2.substring(0, s2.length() - 1);
		}
		if (s4.equals("00")) {
			s4 = "";
			if (s3.length() > 0
					&& s3.substring(s3.length() - 1, s3.length()).equals("0")) {
				s3 = s3.substring(0, s3.length() - 1);
			}
		}
		if (s3.length() > 0
				&& s3.substring(s3.length() - 1, s3.length()).equals("0")) {
			s3 = s3.substring(0, s3.length() - 1);
		}
		if (s4.length() > 0
				&& s4.substring(s4.length() - 1, s4.length()).equals("0")) {
			s4 = s4.substring(0, s4.length() - 1);
		}
		if (s3.equals("0")) {
			s3 = "";
			s4 = "0" + s4;
		}

		ChnMoney = s0 + s1 + s2 + s3 + "元" + s4;
		if (ChnMoney.substring(0, 1).equals("0")) {
			ChnMoney = ChnMoney.substring(1, ChnMoney.length());
		}
		for (int i = 0; i < ChnMoney.length(); i++) {
			if (ChnMoney.substring(i, i + 1).equals("0")) {
				ChnMoney = ChnMoney.substring(0, i) + "零"
						+ ChnMoney.substring(i + 1, ChnMoney.length());
			}
		}

		if (sDot.substring(1, 2).equals("0")) {
			ChnMoney += "整";
		}

		return ChnMoney;
	}

	/**
	 * 得到money的角分信息
	 * 
	 * @param sIn
	 *            String
	 * @return String
	 */
	private static String getDotM(String sIn) {
		String sMoney = "";
		if (!sIn.substring(0, 1).equals("0")) {
			sMoney += getNum(sIn.substring(0, 1)) + "角";
		} else {
			sMoney += "0";
		}
		if (!sIn.substring(1, 2).equals("0")) {
			sMoney += getNum(sIn.substring(1, 2)) + "分";
		} else {
			sMoney += "0";
		}

		return sMoney;
	}

	/**
	 * 添加仟、佰、拾等单位信息
	 * 
	 * @param strUnit
	 *            String
	 * @param digit
	 *            String
	 * @return String
	 */
	private static String getChnM(String strUnit, String digit) {
		String sMoney = "";
		boolean flag = false;

		if (strUnit.equals("0000")) {
			sMoney += "0";
			return sMoney;
		}
		if (!strUnit.substring(0, 1).equals("0")) {
			sMoney += getNum(strUnit.substring(0, 1)) + "仟";
		} else {
			sMoney += "0";
			flag = true;
		}
		if (!strUnit.substring(1, 2).equals("0")) {
			sMoney += getNum(strUnit.substring(1, 2)) + "佰";
			flag = false;
		} else {
			if (!flag) {
				sMoney += "0";
				flag = true;
			}
		}
		if (!strUnit.substring(2, 3).equals("0")) {
			sMoney += getNum(strUnit.substring(2, 3)) + "拾";
			flag = false;
		} else {
			if (!flag) {
				sMoney += "0";
				flag = true;
			}
		}
		if (!strUnit.substring(3, 4).equals("0")) {
			sMoney += getNum(strUnit.substring(3, 4));
		} else {
			if (!flag) {
				sMoney += "0";
				flag = true;
			}
		}

		if (sMoney.substring(sMoney.length() - 1, sMoney.length()).equals("0")) {
			sMoney = sMoney.substring(0, sMoney.length() - 1) + digit.trim()
					+ "0";
		} else {
			sMoney += digit.trim();
		}
		return sMoney;
	}

	/**
	 * 格式化字符
	 * 
	 * @param sIn
	 *            String
	 * @return String
	 */
	private static String formatStr(String sIn) {
		int n = sIn.length();
		String sOut = sIn;
		// int i = n % 4;

		for (int k = 1; k <= 12 - n; k++) {
			sOut = "0" + sOut;
		}
		return sOut;
	}

	/**
	 * 获取阿拉伯数字和中文数字的对应关系
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	private static String getNum(String value) {
		String sNum = "";
		Integer I = new Integer(value);
		int iValue = I.intValue();
		switch (iValue) {
		case 0:
			sNum = "零";
			break;
		case 1:
			sNum = "壹";
			break;
		case 2:
			sNum = "贰";
			break;
		case 3:
			sNum = "叁";
			break;
		case 4:
			sNum = "肆";
			break;
		case 5:
			sNum = "伍";
			break;
		case 6:
			sNum = "陆";
			break;
		case 7:
			sNum = "柒";
			break;
		case 8:
			sNum = "捌";
			break;
		case 9:
			sNum = "玖";
			break;
		}
		return sNum;
	}

	/**
	 * 如果一个字符串数字中小数点后全为零，则去掉小数点及零
	 * 
	 * @param Value
	 *            String
	 * @return String
	 */
	public static String getInt(String Value) {
		if (Value == null) {
			return null;
		}
		String result = "";
		boolean mflag = true;
		int m = 0;
		m = Value.lastIndexOf(".");
		if (m == -1) {
			result = Value;
		} else {
			for (int i = m + 1; i <= Value.length() - 1; i++) {
				if (Value.charAt(i) != '0') {
					result = Value;
					mflag = false;
					break;
				}
			}
			if (mflag) {
				result = Value.substring(0, m);
			}
		}
		return result;
	}

	/**
	 * 得到近似值
	 * 
	 * @param aValue
	 *            double
	 * @return double
	 */
	public static double getApproximation(double aValue) {
		if (java.lang.Math.abs(aValue) <= 0.01) {
			aValue = 0;
		}
		return aValue;
	}

	/**
	 * 根据输入标记为间隔符号，拆分字符串
	 * 
	 * @param strMain
	 *            String
	 * @param strDelimiters
	 *            String 失败返回NULL
	 * @return String[]
	 */
	public static String[] split(String strMain, String strDelimiters) {
		int i;
		int intIndex = 0; // 记录分隔符位置，以取出子串
		Vector vResult = new Vector(); // 存储子串的数组
		String strSub = ""; // 存放子串的中间变量

		strMain = strMain.trim();

		// 若主字符串比分隔符串还要短的话,则返回空字符串
		if (strMain.length() <= strDelimiters.length()) {
			System.out.println("分隔符串长度大于等于主字符串长度，不能进行拆分！");
			return null;
		}

		// 取出第一个分隔符在主串中的位置
		intIndex = strMain.indexOf(strDelimiters);

		// 在主串中找不到分隔符
		if (intIndex == -1) {
			String[] arrResult = { strMain };
			return arrResult;
		}

		// 分割主串到数组中
		while (intIndex != -1) {
			strSub = strMain.substring(0, intIndex);
			if (intIndex != 0) {
				vResult.add(strSub);
			} else {
				// break;
				vResult.add("");
			}

			strMain = strMain.substring(intIndex + strDelimiters.length())
					.trim();
			intIndex = strMain.indexOf(strDelimiters);
		}

		// 如果最末不是分隔符，取最后的字符串
		// if (!strMain.equals("") && strMain != null)
		if (!strMain.equals("")) {
			vResult.add(strMain);
		}

		String[] arrResult = new String[vResult.size()];
		for (i = 0; i < vResult.size(); i++) {
			arrResult[i] = (String) vResult.get(i);
		}

		return arrResult;
	}

	/**
	 * 设置数字精度 需要格式化的数据
	 * 
	 * @param value
	 *            float 精度描述（0.00表示精确到小数点后两位）
	 * @param precision
	 *            String
	 * @return double
	 */
	public static double setPrecision(float value, String precision) {
		// modified by hanxl,2008年11月19日 10时03分02秒
		// 原来代码：return Float.parseFloat(new
		// DecimalFormat(precision).format(value));
		// 这种四舍五入的方式并非传统意义上的四舍五入，而是一种“四舍六入奇靠偶”的方式，这是IEEE754中规定
		// 的一种四舍五入的方式之一。根据以往评审建议，此处修改为传统意义上的四舍五入
		return Float.parseFloat(new DecimalFormat(precision)
				.format(value + 0.000000001));
	}

	/**
	 * 设置数字精度 需要格式化的数据
	 * 
	 * @param value
	 *            double 精度描述（0.00表示精确到小数点后两位）
	 * @param precision
	 *            String
	 * @return double
	 */
	public static double setPrecision(double value, String precision) {
		// modified by hanxl,2008年11月19日 10时03分02秒
		// 原来代码：return Float.parseFloat(new
		// DecimalFormat(precision).format(value));
		// 这种四舍五入的方式并非传统意义上的四舍五入，而是一种“四舍六入奇靠偶”的方式，这是IEEE754中规定
		// 的一种四舍五入的方式之一。根据以往评审建议，此处修改为传统意义上的四舍五入
		return Double.parseDouble(new DecimalFormat(precision)
				.format(value + 0.000000001));
	}

	/**
	 * 将源 Schema 对象中的数据拷贝至目标 Schema 对象中 保全 C、P 互换时经常用到
	 * 
	 * @param Schema
	 * @param Schema
	 */
	public static void copySchema(Schema destSchema, Schema srcSchema) {
		if (destSchema != null && srcSchema != null) {
			try {
				Reflections tReflections = new Reflections();
				tReflections.transFields(destSchema, srcSchema);
				tReflections = null;
			} catch (Exception ex) {
				System.out
						.println("\t@> PubFun.copySchema() : Reflections 拷贝数据失败！");
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 把schemaset对象拷贝一份返回
	 * 
	 * @param srcSet
	 *            SchemaSet
	 * @return SchemaSet
	 */
	public static SchemaSet copySchemaSet(SchemaSet srcSet) {
		try {
			if (srcSet != null && srcSet.size() > 0) {
				if (srcSet.getObj(1) == null) {
					return null;
				}
				Class cls = srcSet.getClass();
				Schema schema = (Schema) srcSet.getObj(1).getClass()
						.newInstance();
				SchemaSet obj = (SchemaSet) cls.newInstance();
				obj.add(schema);
				Reflections tReflections = new Reflections();
				tReflections.transFields(obj, srcSet);
				tReflections = null;
				return obj;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 互换LP和LC表数据
	 * 
	 * @param source
	 *            Schema
	 * @param object
	 *            Schema
	 * @return boolean
	 */
	public static boolean exchangeSchema(Schema source, Schema object) {
		try {
			// 把LP表的数据传递到LC表
			Reflections tReflections = new Reflections();
			tReflections.transFields(object, source);

			// 获取一个数据库连接DB
			Method m = object.getClass().getMethod("getDB", null);
			Schema schemaDB = (Schema) m.invoke(object, null);
			// 因为LP表与LC表只有EdorNo和EdorType两个关键字的差别，所以可以唯一获取LC表对应记录
			m = schemaDB.getClass().getMethod("getInfo", null);
			m.invoke(schemaDB, null);
			m = schemaDB.getClass().getMethod("getSchema", null);
			object = (Schema) m.invoke(schemaDB, null);

			// 把LC表数据备份到临时表
			m = object.getClass().getMethod("getSchema", null);
			Schema tSchema = (Schema) m.invoke(object, null);

			// 互换LP和LC表数据
			tReflections.transFields(object, source);
			tReflections.transFields(source, tSchema);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * 生成更新的sql列表
	 * 
	 * @param tables
	 *            String[]
	 * @param condition
	 *            String
	 * @param wherepart
	 *            String
	 * @return Vector
	 */
	public static Vector formUpdateSql(String[] tables, String condition,
			String wherepart) {
		Vector sqlVec = new Vector();
		for (int i = 0; i < tables.length; i++) {
			sqlVec.add("update " + tables[i] + " set " + condition + " where "
					+ wherepart);
		}
		return sqlVec;
	}

	/**
	 * 将账号前的0去掉
	 * 
	 * @param sIn
	 *            String
	 * @return String
	 */
	public static String DeleteZero(String sIn) {
		int n = sIn.length();
		String sOut = sIn;

		while (sOut.substring(0, 1).equals("0") && n > 1) {
			sOut = sOut.substring(1, n);
			n = sOut.length();
			System.out.println(sOut);
		}

		if (sOut.equals("0")) {
			return "";
		} else {
			return sOut;
		}
	}

	/**
	 * 转换JavaScript解析不了的特殊字符
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String changForJavaScript(String s) {
		char[] arr = s.toCharArray();
		s = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '"' || arr[i] == '\'' || arr[i] == '\n') {
				s += "\\";
			}

			s += arr[i];
		}

		return s;
	}

	/**
	 * 转换JavaScript解析不了的特殊字符
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String changForHTML(String s) {
		char[] arr = s.toCharArray();
		s = "";

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '"' || arr[i] == '\'') {
				s += "\\";
			}

			if (arr[i] == '\n') {
				s += "<br>";
				continue;
			}

			s += arr[i];
		}

		return s;
	}

	public static String getClassFileName(Object o) {
		String fileName = o.getClass().getName();
		fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
		return fileName;
	}

	public static void out(Object o, String s) {
		System.out.println(PubFun.getClassFileName(o) + " : " + s);
	}

	/**
	 * 计算保单年度
	 * 
	 * @param cstartDate
	 *            String
	 * @param cendDate
	 *            String
	 * @return int
	 */
	public static int calPolYear(String cstartDate, String cendDate) {
		FDate fDate = new FDate();
		Date startDate = fDate.getDate(cstartDate);
		Date endDate = fDate.getDate(cendDate);
		if (fDate.mErrors.needDealError()) {
			return 0;
		}

		int interval = 0;

		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(Calendar.YEAR);
		// int sMonths = sCalendar.get(Calendar.MONTH);
		// int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);
		int sDaysOfYear = sCalendar.get(Calendar.DAY_OF_YEAR);

		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		// int eMonths = eCalendar.get(Calendar.MONTH);
		// int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);
		int eDaysOfYear = eCalendar.get(Calendar.DAY_OF_YEAR);

		interval = eYears - sYears;
		// interval = interval * 365;
		interval *= 365;
		// interval = eDaysOfYear - sDaysOfYear + interval;
		interval += eDaysOfYear - sDaysOfYear;

		// 处理润年
		int n = 0;
		eYears--;
		if (eYears > sYears) {
			int i = sYears % 4;
			if (i == 0) {
				sYears++;
				n++;
			}
			int j = (eYears) % 4;
			if (j == 0) {
				eYears--;
				n++;
			}
			n += (eYears - sYears) / 4;
		}
		if (eYears == sYears) {
			int i = sYears % 4;
			if (i == 0) {
				n++;
			}
		}
		interval += n;

		int x = 365;
		int PolYear = 1;
		while (x < interval) {
			// x = x + 365;
			x += 365;
			// PolYear = PolYear + 1;
			PolYear += 1;
		}

		return PolYear;
	}

	/**
	 * 通过身份证号号获取生日日期
	 * 
	 * @param IdNo
	 *            String
	 * @return String
	 */
	public static String getBirthdayFromId(String IdNo) {
		String tIdNo = StrTool.cTrim(IdNo);
		String birthday = "";
		if (tIdNo.length() != 15 && tIdNo.length() != 18) {
			return "";
		}
		if (tIdNo.length() == 18) {
			birthday = tIdNo.substring(6, 14);
			birthday = birthday.substring(0, 4) + "-"
					+ birthday.substring(4, 6) + "-" + birthday.substring(6);
		}
		if (tIdNo.length() == 15) {
			birthday = tIdNo.substring(6, 12);
			birthday = birthday.substring(0, 2) + "-"
					+ birthday.substring(2, 4) + "-" + birthday.substring(4);
			birthday = "19" + birthday;
		}
		return birthday;

	}

	/**
	 * 通过身份证号获取性别
	 * 
	 * @param IdNo
	 *            String
	 * @return String
	 */
	public static String getSexFromId(String IdNo) {
		String tIdNo = StrTool.cTrim(IdNo);
		if (tIdNo.length() != 15 && tIdNo.length() != 18) {
			return "";
		}
		String sex = "";
		if (tIdNo.length() == 15) {
			sex = tIdNo.substring(14, 15);
		} else {
			sex = tIdNo.substring(16, 17);
		}
		try {
			int iSex = Integer.parseInt(sex);
			// iSex = iSex % 2;
			iSex %= 2;
			if (iSex == 0) {
				return "1";
			}
			if (iSex == 1) {
				return "0";
			}
		} catch (Exception ex) {
			return "";
		}
		return "";
	}

	/**
	 * 校验录入的管理机构是否是操作员登陆机构同级或下级，参数为空返回false
	 * 
	 * @param cGlobalInput
	 *            GlobalInput
	 * @param RunScript
	 *            String
	 * @return boolean
	 */
	public static boolean checkManageCom(String InputManageCom,
			String UserManageCom) {
		if (InputManageCom == null || InputManageCom.trim().equals("")
				|| UserManageCom == null || UserManageCom.trim().equals(""))
			return false;
		String sqlcheck = "select isnull((select 'Y' from ldsysvar where sysvar = 'onerow' and trim("
				+ InputManageCom
				+ ") like trim("
				+ UserManageCom
				+ ")||'%'),'N') from ldsysvar where sysvar = 'onerow'";
		ExeSQL tExeSQL = new ExeSQL();
		String result = tExeSQL.getOneValue(sqlcheck);
		if (result.equals("Y"))
			return true;
		else
			return false;
	}

	/**
	 * 用户页面权限判断
	 * 
	 * @param cGlobalInput
	 *            GlobalInput
	 * @param RunScript
	 *            String
	 * @return boolean
	 */
	public static boolean canIDo(GlobalInput cGlobalInput, String RunScript) {
		String Operator = cGlobalInput.Operator;
		// String ComCode = cGlobalInput.ComCode;
		// String ManageCom = cGlobalInput.ManageCom;
		// 通过用户编码查询用户页面权限集合,NodeSign = 2为用户页面权限菜单标志
		String sqlStr = "select * from LDMenu";
		sqlStr = sqlStr + "where NodeSign = 2 and RunScript = '" + RunScript
				+ "' ";
		sqlStr = sqlStr
				+ "and NodeCode in ( select NodeCode from LDMenuGrpToMenu ";
		sqlStr = sqlStr
				+ "where MenuGrpCode in ( select MenuGrpCode from LDMenuGrp ";
		sqlStr = sqlStr
				+ "where MenuGrpCode in (select MenuGrpCode from LDUserToMenuGrp where UserCode = '";
		sqlStr = sqlStr + Operator;
		sqlStr = sqlStr + "') ) ) order by nodeorder";

		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sqlStr);

		if (tSSRS == null || tSSRS.equals("")) {
			return false;
		}
		return true;
	}

	/***************************************************************************
	 * 本函数功能：用于作各种自定义判断校验。前提是 必须将校验的SQL字串已经存入 LMCalMode表里 所需参数：
	 * CalCode----------获取校验SQL的代码; TransferData-----包含作校验时校验字串所需参数
	 * 返回参数：True--校验成功[校验字串返回值为“1”] ；False---校验失败；
	 * 例：判断业务员（代理人）是否有销售资格,代理人代码为：02281075 校验字串: select case salequaf when 'N'
	 * then '0' else '1' end from laagent where agentcode='?AgentCode?' 需要传入的参数:
	 * (1)、CalCode=“AgSale”； (2)、代理人代码<AgentCode>,则需将代理人代码放入 TransferData 调用方法;
	 * String tCalCode ="AgSale"; //根据字串从 lmcalmode 里获取 校验的SQL字串 TransferData
	 * tTransferData = new TransferData();
	 * tTransferData.setNameAndValue("AgentCode","02281075");//校验字串所需参数
	 * if(PubFun.userDefinedCheck(tCalCode,tTransferData)==false) {
	 * System.out.println("校验失败"); return false; }
	 **************************************************************************/
	// public static boolean userDefinedCheck(String mCalCode,
	// TransferData mTransferData) {
	// //
	// String tCalCode = ""; // 获取传入的 CalCode 代码，用于得到校验的SQL语句
	// TransferData tTransferData = new TransferData();
	// tTransferData = mTransferData; // 获取校验所需参数<>
	// // 判断传入代码的是否正确
	// if (mCalCode == null || mCalCode.equals("")) {
	// return false;
	// } else {
	// tCalCode = mCalCode.trim();
	// }
	// // 判断传入TransferData<包含校验所需参数>是否正确
	// if (tTransferData == null) {
	// return false;
	// }
	// // 以下调用 Calculator 类，作校验判断
	// Calculator mCalculator = new Calculator();
	// mCalculator.setCalCode(tCalCode);
	// Vector tVector = new Vector();
	// tVector = tTransferData.getValueNames();
	// if (tVector.size() > 0) {
	// // 获得要素名称并赋值到Calculator类中
	// String mValue = "";
	// for (int i = 0; i < tVector.size(); i++) {
	// String tFactorName = new String();
	// String tFactorValue = new String();
	// tFactorName = (String) tVector.get(i);
	// tFactorValue = (String) tTransferData
	// .getValueByName(tFactorName);
	// mCalculator.addBasicFactor(tFactorName, tFactorValue);
	// }
	// mValue = mCalculator.calculate();
	// if (mValue != null && mValue.equals("1")) {
	// return true;
	// } else {
	// return false;
	// }
	// } else {
	// return false;
	// }
	// }

	/**
	 * 取得sequenceno的值
	 * 
	 * @param type
	 *            String 序列号类型
	 * @return String 序列号,如果出错返回"-1"
	 */
	public static String getSeqNo(String type) {
		String ret = "-1";

		ExeSQL es = new ExeSQL();

		ret = es.getOneValue("select " + type + ".nextval from dual");
		return ret;
	}

	public static Object getClassForName(String sPackageClass) {
		Object obj;
		try {
			obj = Class.forName(sPackageClass).newInstance();
		} catch (Exception ex) {
			obj = null;
			ex.printStackTrace();
		}
		return obj;
	}

	public static Object getClassForName(String sPackage, String sClass) {
		Object obj;
		try {
			obj = Class.forName(sPackage + "." + sClass).newInstance();
		} catch (Exception ex) {
			obj = null;
			ex.printStackTrace();
		}
		return obj;
	}

	/**
	 * Function: customFormat的扩展，可以支持返回千位符格式 Author:wellhi Date: 2006-06-21
	 * 
	 * @param pattern
	 *            String :#,###.##
	 * @param value
	 *            double
	 * @return String 符号含义: 0 一个数字 # 一个数字，不包括 0 . 小数的分隔符的占位符 , 分组分隔符的占位符 ; 分隔格式。
	 *         - 缺省负数前缀。 % 乘以 100 和作为百分比显示 ? 乘以 1000 和作为千进制货币符显示；用货币符号代替；如果双写，用
	 *         国际货币符号代替。如果出现在一个模式中，用货币十进制分隔符代 替十进制分隔符。 X
	 *         前缀或后缀中使用的任何其它字符，用来引用前缀或后缀中的特殊字符。
	 */
	public static String customFormatEx(String pattern, double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		// System.out.println(value + " " + pattern + " " + output);
		return output;
	}

	/**
	 * 获得一个月最后一天lu add in 20070604
	 * 
	 * @param year
	 *            int
	 * @param month
	 *            int
	 * @return String
	 */
	public static String getLastDay(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			return year + "-" + month + "-31";
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return year + "-" + month + "-30";
		} else {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				return year + "-" + month + "-29";
			} else {
				return year + "-" + month + "-28";
			}
		}
	}

	/**
	 * 获得续期回冲时间lu add in 20070604
	 * 
	 * @param date
	 *            String
	 * @return String[]
	 */

	public static String dealErrorMessage(String errMessage) {
		String err = errMessage;// =replace(errMessage,"%","%25");
		// System.out.println(err);
		err = replace(errMessage, "\"", " ");
		// System.out.println(err);
		err = replace(errMessage, "'", " ");
		// System.out.println(err);
		/*
		 * err=replace(err,"~","%7E"); System.out.println(err);
		 * err=replace(err,"!","%21"); System.out.println(err); //
		 * err=replace(err,"#","%23"); // System.out.println(err);
		 * err=replace(err,"\\$","%24"); System.out.println(err);
		 * err=replace(err,"\\^","%5E"); System.out.println(err);
		 */
		// err=replace(err,"&","%26");
		// System.out.println(err);
		// err=replace(err,"\\(","%28");
		// System.out.println(err);
		// err=replace(err,"\\)","%29");
		// System.out.println(err);
		// err=replace(err,"\\+","%2B");
		/*
		 * System.out.println(err); err=replace(err,"\\|","%7C");
		 * System.out.println(err); err=replace(err,"\\\\","%5C");
		 * System.out.println(err); err=replace(err,"=","%3D");
		 * System.out.println(err); err=replace(err,"/","%2F");
		 */
		// System.out.println(err);
		// err=replace(err,"\\*","*");
		// System.out.println(err);
		// err=replace(err,"\\?","%3F");
		// System.out.println(err);
		// err=replace(err,">","%3E");
		// System.out.println(err);
		// err=replace(err,"<","%3C");
		// System.out.println(err);
		// err=replace(err,",","%2C");
		// System.out.println(err);
		// err=replace(err,":","%3A");
		// System.out.println(err);
		/*
		 * err=replace(err,";","%3B"); System.out.println(err);
		 * err=replace(err,"\\[","%5B"); System.out.println(err);
		 * err=replace(err,"\\]","%5D"); System.out.println(err);
		 * err=replace(err,"\\{","%7B"); System.out.println(err);
		 * err=replace(err,"\\}","%7D"); System.out.println(err);
		 */
		err = replace(err, "\n", "<br>");
		// System.out.println(err);
		return err;
	}

	public static String replace(String str, String findStr, String replaceWith) {
		String regEx = "" + findStr + "";
		System.out.println("当前替换:" + regEx);
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		String result = m.replaceAll(replaceWith);
		// System.out.println(result);
		return result;

	}

	/**
	 * 打印出当前的堆栈信息,方便调试分析错误,尤其适用于公共类
	 * 
	 * @author wellhi 2007-10-22
	 */
	public static StringBuffer PrintStackInfo() {
		StringBuffer buf = new StringBuffer();
		buf.append("\r\n################# Start of 堆栈信息 ####################\r\n");
		Throwable nThrowable = new Throwable();
		StackTraceElement[] nStackTraceElement = nThrowable.getStackTrace();
		for (int j = nStackTraceElement.length - 1; j > 0; j--) {
			buf.append("\t\t");
			buf.append(nStackTraceElement[j].getLineNumber());
			buf.append("\t");
			buf.append(nStackTraceElement[j].getClassName());
			buf.append(":");
			buf.append(nStackTraceElement[j].getMethodName());
			buf.append("\r\n");
		}
		buf.append("################# End of 堆栈信息 ####################");
		return buf;
	}

	/**
	 * 实现汉字内码转换 2008-02-27
	 * 
	 * @param srcFileName
	 *            :源文件文件名
	 * @param srcEncode
	 *            :源文件字符集
	 * @param desFileName
	 *            :目标文件名
	 * @param desEncode
	 *            :目标文件字符集
	 * @author wellhi
	 * @return boolean modify by zhaopeng 被逼的,如果是北京建行，单独走一条路
	 */
	public static boolean FileEncodeTransform(String srcFileName,
			String srcEncode, String desFileName, String desEncode,
			String tBankCode) {
		try {
			File srcFile = new File(srcFileName);
			File desFile = new File(desFileName);
			InputStream nFileInputStream = new FileInputStream(srcFile);
			FileOutputStream nFileOutputStream = new FileOutputStream(desFile);
			// 以指定的字符集读入文件
			BufferedReader in = new BufferedReader(new InputStreamReader(
					nFileInputStream, srcEncode));

			// 循环获取每一行
			while (true) {
				String strLine = in.readLine();

				if (strLine == null) {
					break;
				}
				if (strLine.equals("")) {
					continue;
				}
				if (tBankCode.equals("0100020")) {
					strLine += "\n";
				} else {
					strLine += "\r\n";
				}
				// strLine += "\n";
				// strLine += "\r\n";
				// System.out.print("strLine:" + strLine);
				nFileOutputStream.write(strLine.getBytes(desEncode));
			}

			// nFileOutputStream.flush();
			OutputStreamWriter nOutputStreamWriter = new OutputStreamWriter(
					nFileOutputStream, desEncode);
			nOutputStreamWriter.flush();

			nFileOutputStream.close();
			nFileInputStream.close();
			in.close();
			nOutputStreamWriter.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * @author Luochg
	 * @param milliseconds
	 * @return
	 */
	public static String getTime(long milliseconds) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(new Date(milliseconds));
		return str;
	}

	/**
	 * 判断是否为全由数字组成的两位字符串，暂时为保全回退专用，今后有时间可以改进 2008-05-06
	 * 
	 * @param EdorCode
	 * @author wangxu
	 * @return boolean
	 */
	public static boolean JudgeStringAllNum(String EdorCode) {
		if (EdorCode.length() != 2) {
			return false;
		}
		Pattern p = Pattern.compile("[0-9][0-9]");
		Matcher m = p.matcher(EdorCode);
		boolean Result = m.find();
		return Result;
	}

	/**
	 * DB类查询大数据量查询监控日志。
	 */
	public static void log4moreRecord() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("数据量超过1万，请评估采用分批处理方式:\t\n");
		sbf.append(PrintStackInfo());
		log4moreRec.warn(sbf.toString());
	}

	// 仅限两位数
	public static String getCapitalization(String str) {
		String[] list = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
		String Capital = "";
		String a = str.substring(0, 1);
		String b = str.substring(1, 2);
		int temp = Integer.parseInt(a);
		a = list[temp];
		temp = Integer.parseInt(b);
		b = list[temp];
		if (a.equals("零"))
			Capital = b;
		else if (b.equals("零"))
			Capital = a + "十";
		else {
			if (a.equals("一"))
				Capital = "十" + b;
			else
				Capital = a + "十" + b;
		}
		return Capital;

	}

	/**
	 * 根据路径创建文件目录
	 * 
	 * @param path
	 * @return 错误信息
	 */
	public String createDir(String path) {
		// 循环每个目录进行处理
		String[] folder = path.split("//|/");
		String contact = "/";
		String msg = null;
		for (int i = 0, j = folder.length; i < j; i++) {
			if (null != folder[i] && !"".equals(folder[i])) {
				contact = contact + folder[i] + "/";
				// 新建文件对象
				File dir = new java.io.File(contact);
				System.out.println("Absolute Path = " + dir.getAbsolutePath());
				if (!dir.exists()) {
					boolean result = dir.mkdirs();
					if (result == false) {
						msg = "错误原因:＜BR＞目录＜b＞" + dir.getAbsolutePath()
								+ "＜/B＞创建失败，原因不明！";
						return msg;
					}
				}
			}
		}
		return msg;
	}

	/**
	 * 根据传入的两个日期得到两个日期之间假期天数
	 * 
	 * @param 起始日期
	 *            startDate,终止日期 endDate,使用模块 modular
	 * @return 错误信息
	 */
	public int vacationSum(String startDate, String endDate, String modular) {
		int days = 0;
		String strSQL = "select count(1) from llvacationplan t where t.vadate >='"
				+ startDate + "' and t.vadate <='" + endDate + "'";
		if ("ALL".equals(modular)) {
			strSQL = strSQL
					+ " and t.nbflag ='1' and t.posflag ='1' and t.claimflag ='1'";
		} else if ("LP".equals(modular)) {
			strSQL = strSQL + "  and t.claimflag ='1'";
		} else if ("BQ".equals(modular)) {
			strSQL = strSQL + "  and t.posflag ='1' ";
		} else if ("TB".equals(modular)) {
			strSQL = strSQL + " and t.nbflag ='1' ";
		}
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(strSQL);

		if (!"".equals(tSSRS) || tSSRS != null) {
			days = Integer.valueOf(tSSRS.GetText(1, 1));
		}
		return days;
	}

	/**
	 * 去掉字符串tStr头尾的tLast字符
	 * 
	 * @param
	 * @return 修改后的字符串
	 */
	public static String delPreSuffix(String tStr, String tLast) {
		if (tStr != null && !tStr.trim().equals("") && tLast != null) {
			tStr = tStr.trim();
			tLast = tLast.trim();
			int tLength = tStr.length();
			if (tStr.endsWith(tLast)) {
				tStr = tStr.substring(0, tLength - 1);
				tLength = tStr.length();
			}
			if (tStr.startsWith(tLast)) {
				tStr = tStr.substring(1, tLength);
			}
		}
		return tStr;
	}

	/**
	 * 
	 * 身份证是否有效验证
	 * 
	 * @param s
	 *            号码内容
	 * 
	 * @return 身份证号码有效 返回true 其他null、""、均返回false
	 */
	public static boolean isIdcard(String s) {
		final int[] PARITYBIT = { '1', '0', 'X', '9', '8', '7', '6', '5', '4',
				'3', '2' };
		final int[] POWER_LIST = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
				8, 4, 2 };

		if (s == null || (s.length() != 15 && s.length() != 18))
			return false;
		final char[] cs = s.toUpperCase().toCharArray();
		// 校验位数
		int power = 0;
		for (int i = 0; i < cs.length; i++) {
			if (i == cs.length - 1 && cs[i] == 'X')
				break;// 最后一位可以 是X或x
			if (cs[i] < '0' || cs[i] > '9')
				return false;
			if (i < cs.length - 1) {
				power += (cs[i] - '0') * POWER_LIST[i];
			}
		}

		// 校验年份
		String year = s.length() == 15 ? "19" + s.substring(6, 8) : s
				.substring(6, 10);
		final int iyear = Integer.parseInt(year);
		if (iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR))
			return false;// 1900年的PASS，超过今年的PASS

		// 校验月份
		String month = s.length() == 15 ? s.substring(8, 10) : s.substring(10,
				12);
		final int imonth = Integer.parseInt(month);
		if (imonth < 1 || imonth > 12) {
			return false;
		}

		// 校验天数

		String day = s.length() == 15 ? s.substring(10, 12) : s.substring(12,
				14);
		final int iday = Integer.parseInt(day);
		if (iday < 1 || iday > 31)
			return false;

		// 校验"校验码"
		if (s.length() == 15)
			return true;
		return cs[cs.length - 1] == PARITYBIT[power % 11];
	}

	/**
	 * 根据日期和间隔计算新日期 by fengfei 规则引擎-考核试算
	 * 
	 * @param strDate
	 *            String
	 * @param interval
	 *            int
	 * @param unit
	 *            String
	 * @return String
	 */
	public static String calDateIntev(String strDate, int interval, String unit) {
		String date = "";
		try {
			GregorianCalendar mCalendar = new GregorianCalendar();
			FDate tFDate = new FDate();
			Date bDate = tFDate.getDate(strDate);
			mCalendar.setTime(bDate);
			if (unit.equals("Y")) {
				mCalendar.add(Calendar.YEAR, interval);
			}
			if (unit.equals("M")) {
				mCalendar.add(Calendar.MONTH, interval);
			}
			if (unit.equals("D")) {
				mCalendar.add(Calendar.DATE, interval);
			}
			String Year = mCalendar.get(Calendar.YEAR) + "";
			String Month = (mCalendar.get(Calendar.MONTH) + 1) + "";
			String Days = mCalendar.get(Calendar.DATE) + "";
			date = Year + "-" + Month + "-" + Days;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}

	// 验证正负浮点数
	// Add By 2015-03-20
	public static boolean isNumeric(String str) {
		String regex = "-?([0]\\.\\d{1,}?|[1-9]{1}[0-9]{0,}?|[1-9]{1}[0-9]{0,}?\\.\\d{1,}?)|[0]";
		return str.matches(regex);
	}

	/**
	 * HK身份证是否有效验证
	 * @param HKID 号码内容
	 * @return 身份证号码有效 返回true 其他null、""、均返回false
	 */
	public static boolean isHKIdcard(String HKID) {
		String CardNumber = HKID.trim();
		int index1=CardNumber.indexOf("(");
		int index2=CardNumber.indexOf(")");
		if((index1==-1 && index2 != -1 )||(index1!=-1 && index2 == -1 ) ){
			return false;
		}
		int index3=CardNumber.indexOf("（");
		int index4=CardNumber.indexOf("）");
		if((index3==-1 && index4 != -1 )||(index3!=-1 && index4 == -1 ) ){
			return false;
		}
		while (CardNumber.indexOf("(") != -1) {
			CardNumber = CardNumber.replace("(", "");
		}
		while (CardNumber.indexOf(")") != -1) {
			CardNumber = CardNumber.replace(")", "");
		}
		while (CardNumber.indexOf("（") != -1) {
			CardNumber = CardNumber.replace("(", "");
		}
		while (CardNumber.indexOf("）") != -1) {
			CardNumber = CardNumber.replace(")", "");
		}
		String regex = "[a-zA-Z]{1,2}[0-9]{6}[0-9A]{1}";
		if(!CardNumber.matches(regex)){
			return false;
		}
		int checkBit = getCheckSum(CardNumber);
		int EndBit = GetNumber(CardNumber.substring((CardNumber.length()-1), CardNumber.length()));
//		System.out.println(checkBit+"---------------"+EndBit);
		if(EndBit!=checkBit){
			return false;
	    }
		return true;
		
	}
	
	public static int getCheckSum(String CardNumber){
		int getCheckSum_checkSum2=-1;
		int checkSum1=0;
		String regex1 = "[a-zA-Z]{2}[0-9]{6}[0-9A]{1}";
		String regex2 = "[a-zA-Z]{1}[0-9]{6}[0-9A]{1}";
		if(CardNumber.matches(regex1)){
			checkSum1=GetNumber(CardNumber.substring(0, 1))*9+GetNumber(CardNumber.substring(1, 2))*8+GetNumber(CardNumber.substring(2, 3))*7+GetNumber(CardNumber.substring(3, 4))*6+GetNumber(CardNumber.substring(4, 5))*5+GetNumber(CardNumber.substring(5, 6))*4+GetNumber(CardNumber.substring(6, 7))*3+GetNumber(CardNumber.substring(7, 8))*2;
		}
		if(CardNumber.matches(regex2)){
			checkSum1 = 36 * 9 + GetNumber(CardNumber.substring(0, 1)) * 8 + GetNumber(CardNumber.substring(1, 2)) * 7 + GetNumber(CardNumber.substring(2, 3)) * 6 + GetNumber(CardNumber.substring(3, 4)) * 5 + GetNumber(CardNumber.substring(4, 5)) * 4 + GetNumber(CardNumber.substring(5, 6)) * 3 + GetNumber(CardNumber.substring(6, 7)) * 2;
		}
		int last=CardNumber.length()-1;
		if("0".equals(CardNumber.substring(last, last+1))){
			getCheckSum_checkSum2= checkSum1 % 11;
		}
		if(!"0".equals(CardNumber.substring(last, last+1))){
			getCheckSum_checkSum2=11 - checkSum1 % 11;
		}
		return getCheckSum_checkSum2;
	}


	public static int GetNumber(String c){
		int GetNumber_number=-2;
		String regex = "[a-zA-Z]{1}";
		if(c.matches(regex)){
			char character =c.toLowerCase().charAt(0);
			return (byte)character-87;
//			if("a".equals(character)){
//				GetNumber_number = 10;
//			}
//			if("b".equals(character)){
//				GetNumber_number = 11;
//			}
//			if("c".equals(character)){
//				GetNumber_number = 12;
//			}
//			if('d'==character){
//				GetNumber_number = 13;
//			}
//			if('e'==character){
//				GetNumber_number = 14;
//			}
//			if('f'==character){
//				GetNumber_number = 15;
//			}
//			if('g'==character){
//				GetNumber_number = 16;
//			}
//			if('h'==character){
//				GetNumber_number = 17;
//			}
//			if('i'==character){
//				GetNumber_number = 18;
//			}
//			if('j'==character){
//				GetNumber_number = 19;
//			}
//			if('k'==character){
//				GetNumber_number = 20;
//			}
//			if('l'==character){
//				GetNumber_number = 21;
//			}
//			if('m'==character){
//				GetNumber_number = 22;
//			}
//			if('n'==character){
//				GetNumber_number = 23;
//			}
//			if('o'==character){
//				GetNumber_number = 24;
//			}
//			if('p'==character){
//				GetNumber_number = 25;
//			}
//			if('q'==character){
//				GetNumber_number = 26;
//			}
//			if('r'==character){
//				GetNumber_number = 27;
//			}
//			if('s'==character){
//				GetNumber_number = 28;
//			}
//			if('t'==character){
//				GetNumber_number = 29;
//			}
//			if('u'==character){
//				GetNumber_number = 30;
//			}
//			if('v'==character){
//				GetNumber_number = 31;
//			}
//			if('w'==character){
//				GetNumber_number = 32;
//			}
//			if('x'==character){
//				GetNumber_number = 33;
//			}
//			if('y'==character){
//				GetNumber_number = 34;
//			}
//			if('z'==character){
//				GetNumber_number = 35;
//			}
		}else{
			GetNumber_number=Integer.parseInt(c);
		}
		return GetNumber_number;
	}

	/*
	 * 校验传入字符串是否为有效的日期格式
	 */
	public static boolean isValidDate(String tDate,String sepChar){
		String cleanDate=tDate.replace(sepChar, "");
		int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };  
		String regex = "[0-9]{8}";
		if(!cleanDate.matches(regex)){
			return false;
		}
		int year=Integer.parseInt(cleanDate.substring(0,4));
		int month=Integer.parseInt(cleanDate.substring(4,6));
		int day=Integer.parseInt(cleanDate.substring(6,8));
		
        if (year <= 0)  
            return false;  
        if (month <= 0 || month > 12)  
            return false;  
        if (day <= 0 || day > DAYS[month])
            return false;  
        if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {  
            return false;  
        } 
        
		return true;
	}
	
	/*
	 * 校验是否为闰年
	 */
	public static final boolean isGregorianLeapYear(int year) {  
	    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);  
	}
	
	public static final List getFormatBV(List para){
		List formatPara=new ArrayList();
		int size = para.size();
		String varatype="";
		for(int i=0;i<size;i++){
			String[] bv=new String[2];
			varatype = para.get(i).getClass().getName();
			if (varatype.equals("java.lang.String")){
				bv[0]=String.valueOf(Schema.TYPE_STRING);
				bv[1]=String.valueOf(para.get(i));
			}else if (varatype.equals("java.util.Date")){
				bv[0]=String.valueOf(Schema.TYPE_DATE);
				bv[1]=String.valueOf(para.get(i));
			}else if (varatype.equals("java.lang.Float")){
				bv[0]=String.valueOf(Schema.TYPE_FLOAT);
				bv[1]=String.valueOf(para.get(i));
			}else if (varatype.equals("java.lang.Integer")){
				bv[0]=String.valueOf(Schema.TYPE_INT);
				bv[1]=String.valueOf(para.get(i));
			}else if (varatype.equals("java.lang.Double")){
				bv[0]=String.valueOf(Schema.TYPE_DOUBLE);
				bv[1]=String.valueOf(para.get(i));
			}else{
				bv[0]=String.valueOf(Schema.TYPE_STRING);
				bv[1]=String.valueOf(para.get(i));
			}
			formatPara.add(bv);
		}
		return formatPara;
	}
	
	public static String getSafetySQLParam(String sqlParam){
        String safeSQLParam = "";
        safeSQLParam = sqlParam;
        //safeSQLParam = StringEscapeUtils.escapeSql(safeSQLParam);
        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|" 
                              + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)"; 
                  Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
                  Matcher match= pattern.matcher(safeSQLParam.toLowerCase());
                  if(match.find()){
                           return null;
                  }
        return safeSQLParam;
   }

    /**   
     * 字符串转换为DOCUMENT   
     * @param xmlStr 字符串   
     * @return doc JDOM的Document   
     * @throws Exception   
     */    
    public static Document string2Doc(String xmlStr) throws Exception {     
        java.io.Reader in = new StringReader(xmlStr);     
        Document doc = (new SAXBuilder()).build(in);            
        return doc;     
    }     
    
    /**   
     * Document转换为字符串   
     * @param xmlFilePath XML文件路径   
     * @return xmlStr 字符串   
     * @throws Exception   
     */    
    public static String doc2String(Document doc) throws Exception {     
        Format format = Format.getPrettyFormat();     
        format.setEncoding("UTF-8");// 设置xml文件的字符为UTF-8，解决中文问题     
        XMLOutputter xmlout = new XMLOutputter(format);     
        ByteArrayOutputStream bo = new ByteArrayOutputStream();     
        xmlout.output(doc, bo);     
        return bo.toString();     
    }
    
    //用来消除veracode中Directory Traversal
    public static String getSafetyPath(String path){
    	String safePath = "";
    	safePath = path;
    	if(safePath.contains("..\\"))
    		safePath = safePath.replace("..\\", "");
		if(safePath.contains("../"))
			safePath = safePath.replace("../", "");
		if(safePath.contains("./"))
			safePath = safePath.replace("./", "");
    	return safePath;
    }

    //用来消除veracode中CRLF Injection
    public static final String removeControlCharacter(String input)
    {
        if (input == null)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<input.codePointCount(0, input.length()); i++)
        {
            int codePoint = input.codePointAt(i);
            if(!Character.isISOControl(codePoint))
            {
                sb.appendCodePoint(codePoint);
            }
        }
        return sb.toString();
    }

    //用来消除veracode中XSS(Cross-Site Scripting)
    public static final String cleanXSS(String value) {
        //You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
    }
	
	public static final void setBV(PreparedStatement pstmt, List tBV) throws SQLException {
		for(int i=0;i<tBV.size();i++)
		{
			String[] tParams = (String[])tBV.get(i);
			String tType = tParams[0];
			String tValue = tParams[1];
			switch (Integer.parseInt(tType)) {
				case Schema.TYPE_STRING:
				case Schema.TYPE_DATE:
					pstmt.setString(i+1, tValue);
					break;
				case Schema.TYPE_DOUBLE:
					pstmt.setDouble(i+1, Double.parseDouble(tValue));
					break;
				case Schema.TYPE_FLOAT:
					pstmt.setFloat(i+1, Float.parseFloat(tValue));
					break;
				case Schema.TYPE_INT:
					pstmt.setInt(i+1, Integer.parseInt(tValue));
					break;
				default:
					break;
				}
					
		}
	}

	public static final Element addContent(String eleName,String eleValue){
		if(eleValue==null || "".equals(eleValue)){
			return new Element(eleName);
		}else{
			return new Element(eleName).addContent(eleValue);
		}
	}
	
	public static final File createFile(String tPath){
		return new File(tPath);
	}
	
	public static final FileInputStream createFileInputStream(String tPath){
		try {
			return new FileInputStream(tPath);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static final FileOutputStream createFileOutputStream(String tPath){
		try {
			return new FileOutputStream(tPath);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	

	
	public static final SSRS RSToSSRS(ResultSet tRS){
		ResultSetMetaData rsmd = null;
		SSRS tSSRS =new SSRS();
		try{
			rsmd = tRS.getMetaData();
	        int n = rsmd.getColumnCount();
	        if(n>0){
				tSSRS = new SSRS(n);
			    while (tRS.next()){
			        for (int j = 1; j <= n; j++){
			            tSSRS.SetText(getDataValue(rsmd, tRS, j));
			        }
			    }
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
		return tSSRS;
	}
	
    public static final String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i) {
        String strValue = "";
        FDate fDate = new FDate();

        try {
          int dataType = rsmd.getColumnType(i);
          int dataScale = rsmd.getScale(i);
          if ( (dataType == Types.CHAR) || (dataType == Types.NCHAR) 
        		  || (dataType == Types.VARCHAR) || (dataType == Types.NVARCHAR)  
        		  || (dataType == Types.LONGVARCHAR) || (dataType == Types.LONGNVARCHAR)) {
            strValue = StrTool.unicodeToGBK(rs.getString(i));
          }
          else if ( (dataType == Types.TIMESTAMP) || (dataType == Types.DATE)) {
            strValue = fDate.getString(rs.getDate(i));
          }
          else if ( (dataType == Types.DECIMAL) || (dataType == Types.FLOAT)) {
            strValue = String.valueOf(rs.getBigDecimal(i));
            strValue = PubFun.getInt(strValue);
          }
          else if ( (dataType == Types.INTEGER) ||
                   (dataType == Types.SMALLINT)) {
            strValue = String.valueOf(rs.getInt(i));
            strValue = PubFun.getInt(strValue);
          }
          else if (dataType == Types.NUMERIC) {
            if (dataScale == 0) {
              int dataPrecision = rsmd.getPrecision(i);
              if (dataPrecision == 0) {
                strValue = String.valueOf(rs.getBigDecimal(i));
              }
              else {
                strValue = String.valueOf(rs.getLong(i));
              }
            }
            else {
              strValue = String.valueOf(rs.getBigDecimal(i));
            }
            strValue = PubFun.getInt(strValue);
          }
          else if (dataType == Types.CLOB) {
    				Clob clob = rs.getClob(i);
    				if(clob == null) {
    					strValue = "";
    				}else {
    					BufferedReader br = new BufferedReader(clob.getCharacterStream());
    					StringBuffer sb = new StringBuffer();
    					try{
    						for (String line = br.readLine(); line != null; line = br
    								.readLine()) {
    							sb.append(line);
    						}
    						br.close();
    					} catch (IOException e) {
    						e.printStackTrace();
    					} finally {
    						if(br != null)try{br.close();}catch(Exception e){}
    					}
    					strValue = sb.toString();
    				}
    			}
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return StrTool.cTrim(strValue);
      }
	
//	/**
//	 * 主函数，测试用
//	 * 
//	 * @param args
//	 *            String[]
//	 */
//	public static void main(String[] args) {
//		// String t="1112000*-";
//		// System.out.println(t.toUpperCase());
////		System.out.println("abc".substring(0,1));
////		PubFun tPunFun = new PubFun();
////		System.out.println(PubFun.isHKIdcard("U1478920"));
//		System.out.println(PubFun.isValidDate("2015/01/32", "/"));
////		PubFun.GetNumber("X");
//		// String test = tPunFun.calLapseDate("2004-02-02", "111502");
//		// System.out.println(
//		// PubFun.calInterval("2004-01-01",
//		// "2005-01-01",
//		// "Y"));
//		// String
//		// result=PubFun.dealErrorMessage("sssssss\"#~#!###$#%#^#&#(#)#+#|#\\#=#/#*#+#?#>#<#,#");
//		// String result = PubFun.dealErrorMessage("插入语句失败:\"112\"");
//		// System.out.println(getCapitalization("21"));
//
////		int s = tPunFun.vacationSum("2011-10-20", "2011-11-20", "ALL");
//		// t = t.replaceAll("\\(", "B");
//		// System.out.println (t);
//
////		String regex = "[a-zA-Z]{1,2}[1-9]{6}[0-9A]{1}";
////		String a="ab123456A";
////		if(a.matches(regex)){
////			System.out.println("1");
////		}else{
////			System.out.println("2");
////		}
////		System.out.println((byte)'Z');
//		//a-97 z-122
//		//A-65 Z-90
//	}

}
