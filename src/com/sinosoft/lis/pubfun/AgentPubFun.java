package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
/**
 * <p>
 * Title:销售管理系统
 * </p>
 * <p>
 * Description:销售管理的公共业务处理函数
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author
 * @version 1.0
 */
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sinosoft.lis.db.LABranchLevelDB;
import com.sinosoft.lis.db.LDCodeRelaDB;
import com.sinosoft.lis.schema.LABranchLevelSchema;
import com.sinosoft.lis.vschema.LDCodeRelaSet;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;

public class AgentPubFun {

	public AgentPubFun() {
	}

	/**
	 * 转换业务系统的销售渠道为销售系统的展业类型的函数 author: liujw
	 * 
	 * @param cSalChnl
	 *            业务系统的销售渠道
	 * @return String 销售系统的展业类型(BranchType)
	 */
	public static String switchSalChnltoBranchType(String cSalChnl) {
		String tBranchType = "";

		cSalChnl = cSalChnl.trim();
		if (cSalChnl.equals("01")) { // 团险
			tBranchType = "2";
		} else if (cSalChnl.equals("02")) { // 个险
			tBranchType = "1";
		} else if (cSalChnl.equals("03") || cSalChnl.equals("04") || cSalChnl.equals("05") || cSalChnl.equals("06"))
		// 银行保险 兼业代理 专业代理 经纪公司
		{
			tBranchType = "3";
		}

		return tBranchType;
	}

	// xjh Add 2005/04/01
	public static String[] switchSalChnl(String cSalChnl) {
		String[] result = new String[2];
		LDCodeRelaSet tLDCodeRelaSet = new LDCodeRelaSet();
		LDCodeRelaDB tLDCodeRelaDB = new LDCodeRelaDB();
		tLDCodeRelaDB.setRelaType("salechnlvsbranchtype");
		tLDCodeRelaDB.setCode3(cSalChnl);
		tLDCodeRelaSet = tLDCodeRelaDB.query();
		if (tLDCodeRelaSet.size() == 0) {
			return null;
		} else {
			result[0] = tLDCodeRelaSet.get(1).getCode1();
			result[1] = tLDCodeRelaSet.get(1).getCode2();
		}
		return result;
	}

	/**
	 * parseTime
	 * 
	 * @param endTime
	 *            String
	 * @param reportType
	 *            String
	 * @param reportCycle
	 *            String
	 * @return String[]
	 */
	public static String[] parseTime(String endTime, int reportType, int reportCycle) {
		// 当前时间形式,yyyy-MM-dd
		// String sourcePattern=getSessionPool().getConfig().getDefaultDateFormat();

		// int reportCycle=1;
		String sourcePattern = "yyyy-MM-dd";
		String targetPattern = "yyyy-MM-dd";

		SimpleDateFormat sdf = new SimpleDateFormat(sourcePattern); // 用户定义形式
		SimpleDateFormat targetDF = new SimpleDateFormat(targetPattern); // 数据库要求形式

		String reportStartTime = endTime;
		String reportEndTime = endTime;

		String settedEnd = endTime;

		Date endDate;
		// Date startDate;
		try {
			endDate = sdf.parse(settedEnd);

			// 报表类型
			int type = reportType;
			// 报表周期
			int cycle = reportCycle;

			Calendar cal = Calendar.getInstance();
			cal.setTime(endDate);
			switch (type) {
				case 1: // 日报
					reportEndTime = targetDF.format(endDate);
					cal.add(Calendar.DATE, -1 * cycle + 1); // 开始时间=结束时间-周期+1
					reportStartTime = targetDF.format(cal.getTime());
					break;
				case 2: // 月报
					cal.set(Calendar.DAY_OF_MONTH, 1); // 月初
					cal.add(Calendar.MONTH, -1 * cycle + 1); // 到周期的月初
					reportStartTime = targetDF.format(cal.getTime()); // 开始时间
					cal.add(Calendar.MONTH, cycle); // 周期末的下月初
					cal.add(Calendar.DAY_OF_MONTH, -1); // 周期末
					reportEndTime = targetDF.format(cal.getTime());
					break;
				case 3: // 季报

					// int month=cal.get(Calendar.MONTH)+1; //月度,需要+1
					int month = cal.get(Calendar.MONTH);
					int quarter = month / 3; // 所在季度,0-spring;1-summer
					cal.set(Calendar.MONTH, quarter * 3 + (-1 * cycle + 1) * 3); // 季初-周期持续时间
					cal.set(Calendar.DATE, 1); // 设到1号
					reportStartTime = targetDF.format(cal.getTime());

					// //////////////////end time
					cal.add(Calendar.MONTH, cycle * 3); // 多了一天
					cal.add(Calendar.DATE, -1);
					reportEndTime = targetDF.format(cal.getTime());
					break;
				case 4: // 年报
					cal.add(Calendar.YEAR, -1 * cycle + 1);
					cal.set(Calendar.MONTH, Calendar.JANUARY);
					cal.set(Calendar.DATE, 1); // 设到年初
					reportStartTime = targetDF.format(cal.getTime());

					// ///////
					cal.add(Calendar.YEAR, cycle); // 下一年元旦,多了一天
					cal.add(Calendar.DATE, -1); // 年末
					reportEndTime = targetDF.format(cal.getTime());
					break;
				default:
					break;
			}
		} catch (ParseException ex) {

		}

		String[] result = new String[2];
		result[0] = reportStartTime;
		result[1] = reportEndTime;
		return result;
	}

	/**
	 * 将日期格式化成“YYYY年MM月DD天”的格式，输入格式为“YYYY/MM/DD”，“YYYY-MM-DD”
	 */
	public static String formatDatex(String cDate) {
		if (cDate.indexOf("/") != -1) {
			cDate = cDate.substring(0, cDate.indexOf("/")) + ""+bundle.getString("waitForTran")+"";
		} else if (cDate.indexOf("-") != -1) {
			cDate = cDate.substring(0, cDate.indexOf("-")) + ""+bundle.getString("waitForTran")+"";
		}
		return cDate;
	}

	/**
	 * 转换业务系统的销售渠道为销售系统的展业类型的函数 author: liujw
	 * 
	 * @param cSalChnl
	 *            销售系统的展业类型(BranchType)
	 * @return String 业务系统的销售渠道
	 */
	public static String switchBranchTypetoSalChnl(String cBranchType) {
		String tSalChnl = "";
		// cBranchType = cBranchType.trim();
		// if (cBranchType.equals("2"))
		// { //团险
		// tSalChnl = "01";
		// }
		// else if (cBranchType.equals("1"))
		// { //个险
		// tSalChnl = "02";
		// }
		// else if (cBranchType.equals("3"))
		// //银行保险 兼业代理 专业代理 经纪公司
		// {
		// tSalChnl = "03";
		// }
		LDCodeRelaDB tLDCodeRelaDB = new LDCodeRelaDB();
		LDCodeRelaSet tLDCodeRelaSet = new LDCodeRelaSet();
		tLDCodeRelaDB.setRelaType("salechnlvsbranchtype");
		tLDCodeRelaDB.setCode1(cBranchType);
		tLDCodeRelaSet = tLDCodeRelaDB.query();
		for (int i = 1; i <= tLDCodeRelaSet.size(); i++) {
			tSalChnl += tLDCodeRelaSet.get(i).getCode3();
			if (i != tLDCodeRelaSet.size()) {
				tSalChnl += ",";
			}
		}
		return tSalChnl;
	}

	// xjh Add 2005/04/01
	public static String switchBranchTypetoSalChnl(String cBranchType, String cBranchType2) {
		LDCodeRelaSet tLDCodeRelaSet = new LDCodeRelaSet();
		LDCodeRelaDB tLDCodeRelaDB = new LDCodeRelaDB();
		tLDCodeRelaDB.setRelaType("salechnlvsbranchtype");
		tLDCodeRelaDB.setCode1(cBranchType);
		tLDCodeRelaDB.setCode2(cBranchType2);
		tLDCodeRelaSet = tLDCodeRelaDB.query();
		if (tLDCodeRelaSet.size() == 0) {
			return null;
		} else {
			return tLDCodeRelaSet.get(1).getCode3();
		}
	}

	/**
	 * 得到机构2468位的函数 author: zy
	 * 
	 * @param cmanagecom
	 *            销售系统的管理机构
	 * @param mManagecom
	 *            登陆管理机构
	 * @return SSRS 机构数
	 */
	public static SSRS getbranch(String cManagecom, String mManagecom) {
		// GlobalInput mGlobalInput =new GlobalInput() ;
		SSRS tSSRS = new SSRS();
		int n = cManagecom.trim().length();
		System.out.println("录入机构－－－" + cManagecom);
		System.out.println("录入机构长度－－－" + n);
		String MM = "";
		switch (n) {
			case 2: {
				MM = " and length(a)=4 ";
				break;
			}
			case 4: {
				MM = " and length(a)=6 ";
				break;
			}
			case 6: {
				MM = " and length(a)=8 ";
				break;
			}
			case 8: {
				MM = " and length(a)=12 ";
				break;
			}
			case 12: {
				MM = " and length(a)=15 ";
				break;
			}
			case 15: {
				MM = " and length(a)=18 ";
				break;
			}
		}
		String nsql = "select a,b from (select trim(comcode) a,shortname b from ldcom union" + " select trim(branchattr) a,name b From labranchgroup where branchtype='1'"
				+ " and (state<>1 or state is null) and length(trim(branchattr))<>8)" + " where a like '" + cManagecom + "%' and a like '" + mManagecom + "%' " + MM + "order by a";
		// SSRS ySSRS = new SSRS();
		ExeSQL aExeSQL = new ExeSQL();
		tSSRS = aExeSQL.execSQL(nsql);
		return tSSRS;
	}

	/**
	 * 根据代理人职级查询代理人系列（只适用个险）
	 * 
	 * @param cAgentGrade
	 *            个险的代理人职级
	 * @return String 职级对应的代理人系列
	 */
	public static String getAgentSeries(String cAgentGrade) {
		if (cAgentGrade == null || cAgentGrade.equals("")) {
			return null;
		}
		String tAgentSeries = "";
		// xjh Modify 2005/3/22
		// String tSQL =
		// "select Trim(code2) from ldcodeRela where relaType = 'gradeserieslevel' "
		// + "and code1 = '" + cAgentGrade + "' ";
		String tSQL = "Select GradeProperty2 from LAAgentGrade where GradeCode = '" + cAgentGrade + "'";
		ExeSQL tExeSQL = new ExeSQL();
		tAgentSeries = tExeSQL.getOneValue(tSQL);
		if (tExeSQL.mErrors.needDealError()) {
			return null;
		}
		return tAgentSeries;
	}

	/**
	 * 根据代理人编码查询代理人入司职级
	 * 
	 * @param cAgentCode
	 *            代理人编码
	 * @return String 代理人入司日期
	 */
	public static String getAgentGrade(String cAgentCode) {
		if (cAgentCode == null || cAgentCode.equals("")) {
			return null;
		}
		String tAgentGrade = "";
		String tSQL = "select agentgrade from latreeb where agentcode='" + cAgentCode + "' order by makedate,maketime";
		ExeSQL tExeSQL = new ExeSQL();
		tAgentGrade = tExeSQL.getOneValue(tSQL);
		if (tAgentGrade == null || tAgentGrade.equals("")) {
			String aSQL = "select agentgrade from latree where agentcode='" + cAgentCode + "' ";
			ExeSQL aExeSQL = new ExeSQL();
			tAgentGrade = aExeSQL.getOneValue(aSQL);
		}
		return tAgentGrade;
	}

	public static String AdjustCommCheck(String tAgentCode, String tStartDate) {
		String sql1 = "select startdate from lastatsegment where stattype='5' and startdate<='" + tStartDate + "' and enddate>='" + tStartDate + "' ";
		ExeSQL tExeSQL1 = new ExeSQL();
		String MStartDate = tExeSQL1.getOneValue(sql1);
		if (!AgentPubFun.formatDate(tStartDate, "DD").endsWith(AgentPubFun.formatDate(MStartDate, "DD"))) // 如果开始时间不是从1号开始，则返回错误
		{
			return ""+bundle.getString("waitForTran")+"";
		}
		// if (!tStartDate.endsWith("26")) //如果开始时间不是从26号开始，则返回错误
		// {
		// return "调整日期必须是从26号开始";
		// }
		String sql = "select max(indexcalno) from lawage where AgentCode='" + tAgentCode + "'";
		ExeSQL tExeSQL = new ExeSQL();
		String maxIndexCalNo = tExeSQL.getOneValue(sql);
		if (maxIndexCalNo != null && !maxIndexCalNo.equals("")) {
			String lastDate = PubFun.calDate(tStartDate, -1, "M", null);
			lastDate = AgentPubFun.formatDate(lastDate, "yyyyMM");
			if (maxIndexCalNo.trim().compareTo(lastDate.trim()) > 0) {
				return ""+bundle.getString("waitForTran")+"";
			}
		}
		return "00";

	}

	/**
	 * 查询代理人所在组的外部编码
	 * 
	 * @param cAgentGrade
	 *            代理人代码
	 * @return String 代理人所在组的外部编码
	 */
	public static String getAgentBranchAttr(String cAgentCode) {
		String tBranchAttr = "";
		if (cAgentCode == null || cAgentCode.equals("")) {
			return null;
		}
		String tSQL = "Select Trim(BranchAttr) From LABranchGroup Where AgentGroup = (" + "Select BranchCode From LAAgent Where AgentCode = '" + cAgentCode + "') ";
		ExeSQL tExeSQL = new ExeSQL();
		tBranchAttr = tExeSQL.getOneValue(tSQL);
		if (tExeSQL.mErrors.needDealError()) {
			return null;
		}
		return tBranchAttr;
	}

	/**
	 * 按cFormat的格式 格式化日期类型 年月日的表示字母为 y M d
	 */
	public static String formatDate(String cDate, String cFormat) {
		String FormatDate = "";
		Date tDate;
		SimpleDateFormat sfd = new SimpleDateFormat(cFormat);
		FDate fDate = new FDate();
		tDate = fDate.getDate(cDate.trim());
		FormatDate = sfd.format(tDate);
		// System.out.println("[--formatedate--]:"+FormatDate);
		return FormatDate;
	}

	/**
	 * 从LDCodeRela表中查出ManageCom对应的地区类型
	 */
	public static String getAreaType(String cManageCom) {
		// AreaType
		String tSql = "Select trim(code2) From LDCodeRela Where trim(RelaType) = 'comtoareatype' and trim(code1) = '" + cManageCom.substring(0, 4) + "'";
		ExeSQL tExeSQL = new ExeSQL();
		String tAreaType = tExeSQL.getOneValue(tSql);
		if (tExeSQL.mErrors.needDealError()) {
			return null;
		}
		if (tAreaType == null || tAreaType.equals("")) {
			return null;
		}
		return tAreaType;
	}

	/**
	 * 大纲版本分渠道类型.2006-05-18 Howie 从LDCodeRela表中查出ManageCom对应的地区类型 通过管理机构计算地区类型，各渠道现在有'01'(A版),'02'(B版)大纲
	 */
	public static String getAreaType(String cManageCom, String cBranchType) {
		String tSql = "";
		// AreaType
		if (cBranchType.equals("4")) { // 收费员大纲版本定义到中支
			tSql = "Select trim(code2) From LDCodeRela Where trim(RelaType) = 'comtoareatype' and trim(code1) = '" + cManageCom.substring(0, 4) + "' and trim(code3) = '" + cBranchType + "'";
		} else {
			tSql = "Select trim(code2) From LDCodeRela Where trim(RelaType) = 'comtoareatype' and trim(code1) = '" + cManageCom.substring(0, 4) + "' and trim(code3) = '" + cBranchType + "'";
		}

		ExeSQL tExeSQL = new ExeSQL();
		String tAreaType = tExeSQL.getOneValue(tSql);
		if (tExeSQL.mErrors.needDealError()) {
			return null;
		}
		if (tAreaType == null || tAreaType.equals("")) {
			return null;
		}
		return tAreaType;
	}

	public static String CalWageNo(String cWageNo, int interval) {
		String tYMD = cWageNo + "01";
		String AYMD = PubFun.calDate(tYMD, interval - 1, "M", "");
		String AWageNo = formatDate(AYMD, "yyyyMM");
		return AWageNo;
	}

	public static int calWageNoIntv(String cBeginWageNo, String cEndWageNo) {
		String cBYMD = cBeginWageNo + "01";
		String cEYMD = cEndWageNo + "01";
		int intv = PubFun.calInterval(cBYMD, cEYMD, "M");
		return intv;
	}

	/**
	 * 转换规则：上月26号---本月25号算作本月
	 * 
	 * @Return :格式为YYYYMM
	 */
	public static String ConverttoYM(String cDate) {
		String sYearMonth = "";
		ExeSQL tExeSQL = new ExeSQL();
		String tSql = "Select YearMonth From LAStatSegment Where StatType = '5' " + "And StartDate <= '" + cDate + "' And EndDate >= '" + cDate + "'";
		sYearMonth = tExeSQL.getOneValue(tSql);
		if (tExeSQL.mErrors.needDealError()) {
			return null;
		}
		if (sYearMonth == null || sYearMonth.equals("")) {
			return null;
		}
		return sYearMonth;
	}

	/**
	 * getManagecom 从LABranchGroup 表中由AgentGroup取得其管理机构
	 * 
	 * @param AgentGroup
	 *            String
	 * @return String
	 */
	public static String getManagecom(String cAgentGroup) {
		if (cAgentGroup == null || cAgentGroup.equals("")) {
			return null;
		}
		String tSQL = "Select Trim(Managecom) From LABranchGroup Where AgentGroup = '" + cAgentGroup + "'";
		ExeSQL tExeSQL = new ExeSQL();
		String tManagecom = tExeSQL.getOneValue(tSQL);
		if (tExeSQL.mErrors.needDealError()) {
			return null;
		}
		return tManagecom;
	}

	/**
	 * 转换规则：上月26号---本月25号算作本月
	 * 
	 * @Return :格式为YYYYMMDD
	 */
	public static String ConverttoYMD(String cDate) {
		String sYearMonth = "";
		sYearMonth = ConverttoYM(cDate);
		if (sYearMonth != null && !sYearMonth.equals("")) {
			sYearMonth = sYearMonth.substring(0, 4) + "-" + sYearMonth.substring(4) + "-01";
		}
		return sYearMonth;
	}

	/**
	 * 查询机构系列号
	 * 
	 * @param cAgentGroup
	 *            机构内部编码
	 * @return String 机构系列号
	 */
	/*
	 * public static String getBranchSeries(String cAgentGroup) { String tBranchSeries = cAgentGroup; if (cAgentGroup == null ||
	 * cAgentGroup.equals("")) { return ""; } String tSQL = "Select Trim(UpBranch) From LABranchGroup Where AgentGroup = '" + cAgentGroup + "'";
	 * ExeSQL tExeSQL = new ExeSQL(); String tUpBranch = tExeSQL.getOneValue(tSQL); if (tExeSQL.mErrors.needDealError()) { return ""; } if (tUpBranch
	 * == null || tUpBranch.compareTo("") == 0) { System.out.println("到达出口"); } else { //如果发现该机构存在上级机构，则查询上级机构信息 //xjh Modify ， 2005/02/17，机构间使用“：”分隔符
	 * // tBranchSeries = getBranchSeries(tUpBranch) + tBranchSeries; tBranchSeries = getBranchSeries(tUpBranch) + ":" + tBranchSeries;
	 * 
	 * // System.out.println("机构序列" + tBranchSeries); } return tBranchSeries; }
	 */
	public static String getBranchSeries(String cAgentGroup) {
		String tBranchSeries = "";
		if (cAgentGroup == null || cAgentGroup.equals("")) {
			return "";
		}
		String tSQL = "Select branchseries From LABranchGroup Where AgentGroup = '" + cAgentGroup + "'";
		ExeSQL tExeSQL = new ExeSQL();
		tBranchSeries = tExeSQL.getOneValue(tSQL);
		if (tExeSQL.mErrors.needDealError()) {
			return "";
		}
		return tBranchSeries;
	}

	/**
	 * 自动生成销售机构外部号BranchAttr
	 * 
	 * @param cUpBranchAttr
	 *            上级机构的外部编码 cBranchLevel 被生成机构的级别 cBranchType 渠道 cBranchType2 渠道类型2
	 * @return String 机构系列号
	 */
	public static String CreateBranchAttr(String cUpBranchAttr, String cBranchLevel, String cBranchType, String cBranchType2) {
		System.out.println("CreateBranchAttr...");
		LABranchLevelDB tLABranchLevelDB = new LABranchLevelDB();
		tLABranchLevelDB.setBranchLevelCode(cBranchLevel);
		tLABranchLevelDB.setBranchType(cBranchType);
		tLABranchLevelDB.setBranchType2(cBranchType2);
		if (!tLABranchLevelDB.getInfo()) {
			return null;
		}
		LABranchLevelSchema tLABranchLevelSchema = new LABranchLevelSchema();
		tLABranchLevelSchema = tLABranchLevelDB.getSchema();

		String tmaxBranchAttr = "";
		ExeSQL tExeSQL = new ExeSQL();
		String tmaxBranchAttr1 = "";
		String tmaxBranchAttr2 = "";
		String sql = "";

		if (cBranchType.equals("1")) {
			sql = "select MAX(SUBSTR(BRANCHATTR,LENGTH(BRANCHATTR)-2,3)) from labranchgroup where BranchType='" + cBranchType + "' and  BranchLevel = '" + cBranchLevel + "'" + " and "
					+ (cBranchLevel.equals("03") ? "managecom" : "branchattr") + " like '" + cUpBranchAttr + "%' ";
		} else {
			sql = "select max(branchattr) from labranchgroup where BranchType='" + cBranchType + "' and BranchLevel = '" + cBranchLevel + "'"
					+ (cUpBranchAttr.equals("") ? "" : " and branchattr like '" + cUpBranchAttr + "%' ");
		}
		tmaxBranchAttr1 = tExeSQL.getOneValue(sql);
		if (tmaxBranchAttr1 == null || tmaxBranchAttr1.equals("")) {
			System.out.println(tLABranchLevelSchema.getBranchLevelProperty2());
			tmaxBranchAttr1 = cBranchType.equals("1") ? "000000000000000".substring(0, Integer.parseInt(tLABranchLevelSchema.getBranchLevelProperty2()) - cUpBranchAttr.length()) : cUpBranchAttr
					+ "000000000000000".substring(0, Integer.parseInt(tLABranchLevelSchema.getBranchLevelProperty2()) - cUpBranchAttr.length());
		}
		BigInteger tBigInteger = new BigInteger(cBranchLevel.equals("03") ? tmaxBranchAttr1 : "1" + tmaxBranchAttr1);
		System.out.println("tmaxBranchAttr1: " + tmaxBranchAttr1 + " " + tBigInteger);

		if (cBranchType.equals("1")) {
			sql = "select MAX(SUBSTR(BRANCHATTR,LENGTH(BRANCHATTR)-2,3)) from labranchgroupb where BranchType='" + cBranchType + "' and  BranchLevel = '" + cBranchLevel + "'" + " and "
					+ (cBranchLevel.equals("03") ? "managecom" : "branchattr") + " like '" + cUpBranchAttr + "%' ";
		} else {
			sql = "select max(branchattr) from labranchgroupb where BranchType='" + cBranchType + "' and  BranchLevel = '" + cBranchLevel + "'"
					+ (cUpBranchAttr.equals("") ? "" : " and branchattr like '" + cUpBranchAttr + "%'  ");
		}
		tmaxBranchAttr2 = tExeSQL.getOneValue(sql);
		if (tmaxBranchAttr2 == null || tmaxBranchAttr2.equals("")) {
			tmaxBranchAttr2 = cBranchType.equals("1") ? "000000000000000".substring(0, Integer.parseInt(tLABranchLevelSchema.getBranchLevelProperty2()) - cUpBranchAttr.length()) : cUpBranchAttr
					+ "000000000000000".substring(0, Integer.parseInt(tLABranchLevelSchema.getBranchLevelProperty2()) - cUpBranchAttr.length());
		}
		BigInteger tBigInteger1 = new BigInteger(cBranchLevel.equals("03") ? tmaxBranchAttr2 : "1" + tmaxBranchAttr2);
		System.out.println("tmaxBranchAttr2: " + tmaxBranchAttr2 + " " + tBigInteger1);

		if (tBigInteger1.compareTo(tBigInteger) >= 0) {
			BigInteger tAdd = new BigInteger("1");
			tBigInteger1 = tBigInteger1.add(tAdd);
			tmaxBranchAttr = cBranchLevel.equals("03") ? tBigInteger1.toString() : tBigInteger1.toString().substring(1);
		} else {
			BigInteger tAdd = new BigInteger("1");
			tBigInteger = tBigInteger.add(tAdd);
			tmaxBranchAttr = cBranchLevel.equals("03") ? tBigInteger.toString() : tBigInteger.toString().substring(1);
		}
		int big = Integer.parseInt(tmaxBranchAttr);
		if (cBranchType.equals("1") && cBranchLevel.equals("03") && big < 101) {// 如果是个险加区的时候查出来的编号小于1001则返回1001,否则返回查出来的数据，因为现在得规则是区的第一位是从1开始
			String manattr = "101";
			return manattr;
		} else {
			return tmaxBranchAttr;
		}
	}
	
	/**
	 * 为续收渠道收费机构创建外部编码
	 * @param cUpBranchAttr
	 * @param cBranchLevel
	 * @param cBranchType
	 * @param cBranchType2
	 * @param cManageCom
	 * @return
	 */
	public static String CreateBranchAttr(String cUpBranchAttr, String cBranchLevel, String cBranchType, String cBranchType2,String cManageCom) {
		System.out.println("CreateBranchAttr...");
		ExeSQL tExeSQL = new ExeSQL();
		String tBranchAttr = "";
		String sql = "";
		sql = "select substr(to_number(MAX(SUBSTR(BRANCHATTR,LENGTH(BRANCHATTR)-2,3)))+1001,2) from labranchgroup where BranchType='" + cBranchType + "' and  BranchLevel = '" + cBranchLevel + "'" ;
		tBranchAttr = tExeSQL.getOneValue(sql);
		
		if(tBranchAttr==null || "".equals(tBranchAttr)){
			tBranchAttr = "001";
		} 
		tBranchAttr = "864301" + tBranchAttr ;
		return tBranchAttr;
	}

	/**
	 * 自动生成销售机构外部号BranchAttr
	 * 
	 * @param cUpBranchAttr
	 *            上级机构的外部编码 cBranchLevel 被生成机构的级别 cBranchType 渠道 cBranchType2 渠道类型2
	 * @return String 机构系列号
	 */
	public static String getMaxBranchAttr(String cUpBranchAttr, String cMaxBranchAttr) {
		System.out.println("CreateBranchAttr...");

		int iLength = cUpBranchAttr.length();
		String tMaxBranchAttr = cMaxBranchAttr.substring(iLength);

		BigInteger tBigInteger = new BigInteger("1" + tMaxBranchAttr);

		BigInteger tAdd = new BigInteger("1");
		tBigInteger = tBigInteger.add(tAdd);
		tMaxBranchAttr = cUpBranchAttr + tBigInteger.toString().substring(1);

		return tMaxBranchAttr;
	}

	/*
	 * 自动校验人员在指定考核年月，是否已经处在考核归属完成的阶段cAgentCode——人员编码 cBranchType——校验渠道 cIndexCalNo——考核年月return: 0——本月参加考核，归属完成，条件成立 1——本月参加考核，归属未完成，条件不成立
	 * 2——本月未参加考核，条件成立 3——本月人员所在机构考核工作未开始，条件不成立 4——收费员暂时不处理，条件成立 5——人员渠道不匹配，条件不成立 6——其它，条件成立 7——其它，条件不成立
	 */
	public static int CheckAgentAssessState(String cAgentCode, String cBranchType, String cIndexCalNo) {
		return 0;
	}

	/*
	 * 根据个险信息找出有效团险交叉销售的专管员,查找顺序按输入对象低至高,遵循低有效原则 cAgentcode——个险业务员编码,cBranchCode——个险营销组的内部编码,cManageCom——个险营销服务部；
	 * 返回：团险交叉销售专管员的数组，按makedate,modifydate,StandbyFlag1(比率)排序；查询不到返回null 注意事项：当cBranchCode条件查询失败时，方法延溯其上级机构
	 */

	public static String[] getExchangeAgentCode(String cAgentCode, String cBranchCode, String cManageCom) {
		String[] GAgentCode = null;
		String AgentGroup = "";
		String District = "";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String SQLstr = "";
		// 1.AgentCode条件
		SQLstr = "select agentcode from laagenttobranch where code1='" + cAgentCode + "' and state='1' and type='1' order by makedate,modifydate,StandbyFlag1";
		tSSRS = tExeSQL.execSQL(SQLstr);
		if (tSSRS.MaxRow <= 0) {// 说明没有具体到人的记录
			SQLstr = "select agentcode from laagenttobranch where code1='" + cBranchCode + "' and state='1' and type='2' order by makedate,modifydate,StandbyFlag1";
			tSSRS = tExeSQL.execSQL(SQLstr);
			if (tSSRS.MaxRow <= 0) {// 说明没有具体到组的记录
				SQLstr = "select upbranch from labranchgroup where agentgroup='" + cBranchCode + "'";
				AgentGroup = tExeSQL.getOneValue(SQLstr);
				SQLstr = "select agentcode from laagenttobranch where code1='" + AgentGroup + "' and state='1' and type='2' order by makedate,modifydate,StandbyFlag1";
				tSSRS = tExeSQL.execSQL(SQLstr);
				if (tSSRS.MaxRow <= 0) {// 说明没有具体到部的记录
					SQLstr = "select upbranch from labranchgroup where agentgroup='" + AgentGroup + "'";
					District = tExeSQL.getOneValue(SQLstr);
					SQLstr = "select agentcode from laagenttobranch where code1='" + District + "' and state='1' and type='2' order by makedate,modifydate,StandbyFlag1";
					tSSRS = tExeSQL.execSQL(SQLstr);
					if (tSSRS.MaxRow <= 0) {// 说明没有具体到区的记录
						SQLstr = "select agentcode from laagenttobranch where code1='" + cManageCom + "' and state='1' and type='3' order by makedate,modifydate,StandbyFlag1";
						tSSRS = tExeSQL.execSQL(SQLstr);
						if (tSSRS.MaxRow <= 0) {// 说明没有具体到营销服务部的记录
							return null;
						}
					}
				}
			}
		}
		try {
			GAgentCode = new String[tSSRS.MaxRow];
			for (int i = 1; i <= tSSRS.MaxRow; i++) {
				GAgentCode[i - 1] = tSSRS.GetText(i, 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return GAgentCode;
	}

	/*
	 * 功能：根据个险信息找出有效团险交叉销售的专管员,查找顺序为人、组、部、区、营销服务部,遵循低有效原则 参数：cAgentcode——个险业务员编码； 返回：团险交叉销售专管员的数组，按makedate,modifydate,StandbyFlag1(比率)排序；查询不到返回null
	 */
	public static String[][] getExchangeAgentCodeAndRate(String cAgentCode) {
		String[][] GAgentCode = null;
		String BranchCode = "";
		String AgentGroup = "";
		String District = "";
		String ManageCom = "";
		String BranchSeries = "";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String SQLstr = "";
		SQLstr = "select branchseries,managecom from labranchgroup where agentgroup=(select branchcode from latree where agentcode='" + cAgentCode + "' ) ";
		tSSRS = tExeSQL.execSQL(SQLstr);
		if (tSSRS.MaxRow <= 0) {
			return null;
		}
		ManageCom = tSSRS.GetText(1, 2);
		BranchSeries = tSSRS.GetText(1, 1);
		// 1.AgentCode条件
		SQLstr = "select agentcode,standbyflag1 from laagenttobranch where code1='" + cAgentCode + "' and state='1' and type='1' order by makedate,modifydate,StandbyFlag1";
		tSSRS = tExeSQL.execSQL(SQLstr);
		if (tSSRS.MaxRow <= 0) {// 说明没有具体到人的记录
			BranchCode = BranchSeries.substring(BranchSeries.length() - 12);
			BranchSeries = BranchSeries.substring(0, BranchSeries.lastIndexOf(":"));
			SQLstr = "select agentcode,standbyflag1 from laagenttobranch where code1='" + BranchCode + "' and state='1' and type='2' order by makedate,modifydate,StandbyFlag1";
			tSSRS = tExeSQL.execSQL(SQLstr);
			if (tSSRS.MaxRow <= 0) {// 说明没有具体到组的记录
				AgentGroup = BranchSeries.substring(BranchSeries.length() - 12);
				BranchSeries = BranchSeries.substring(0, BranchSeries.lastIndexOf(":"));
				SQLstr = "select agentcode,standbyflag1 from laagenttobranch where code1='" + AgentGroup + "' and state='1' and type='2' order by makedate,modifydate,StandbyFlag1";
				tSSRS = tExeSQL.execSQL(SQLstr);
				if (tSSRS.MaxRow <= 0) {// 说明没有具体到部的记录
					District = BranchSeries;
					SQLstr = "select agentcode,standbyflag1 from laagenttobranch where code1='" + District + "' and state='1' and type='2' order by makedate,modifydate,StandbyFlag1";
					tSSRS = tExeSQL.execSQL(SQLstr);
					if (tSSRS.MaxRow <= 0) {// 说明没有具体到区的记录
						SQLstr = "select agentcode,standbyflag1 from laagenttobranch where code1='" + ManageCom + "' and state='1' and type='3' order by makedate,modifydate,StandbyFlag1";
						tSSRS = tExeSQL.execSQL(SQLstr);
						if (tSSRS.MaxRow <= 0) {// 说明没有具体到营销服务部的记录
							return null;
						}
					}
				}
			}
		}
		try {
			GAgentCode = tSSRS.getAllData();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return GAgentCode;
	}

	/*
	 * 功能：根据保单号和销售渠道，查询该保单对应的业务员编码、姓名、分摊比例 参数：cContNo-保单号，必填项 cBranchType-渠道类型（个人代理销售团险、团险业务员），必填项 cBranchType2-团险子渠道，可以为空 返回：业务员的数组；查询不到返回null by
	 * zhanggl 2006-12-8
	 */
	public static String[][] getContToAgentAndRate(String cContNo, String cBranchType, String cBranchType2) {
		String[][] GAgentCode = null;
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String SQLstr = "select a.agentcode," + "(select name from laagent where agentcode=a.agentcode),"
				+ "BusiRate,(select (select codename from ldcode where codetype='branchtype2' and trim(code)=b.branchtype2) from laagent b where agentcode=a.agentcode) from lacommisiondetail a"
				+ " where grpcontno='" + cContNo + "' and exists (select 'X' from laagent where agentcode=a.agentcode and branchtype='" + cBranchType + "'";
		if (!cBranchType2.equals("") && cBranchType2 != null) {
			SQLstr += " and branchtype2='" + cBranchType2 + "')";
		} else {
			SQLstr += ")";
		}
		tSSRS = tExeSQL.execSQL(SQLstr);
		if (tSSRS.MaxRow <= 0) {
			return null;
		}

		try {
			GAgentCode = tSSRS.getAllData();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return GAgentCode;
	}

	/*
	 * 功能：根据中介机构编码，查询该中介机构对应的中介专管员编码、姓名、分摊比例、团险子渠道编码、团险子渠道类型 参数：cAgentComCode-中介机构编码，必填项 返回：业务员的数组；查询不到返回null by zhanggl 2006-12-8
	 */
	public static String[][] getComToAgentAndRate(String cAgentComCode) {
		String[][] GAgentCode = null;
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String SQLstr = "select AgentCode,(select name from laagent where agentcode=a.agentcode),Rate," + "(select branchtype2 from laagent where agentcode=a.agentcode),"
				+ "(select codename from ldcode,laagent b where codetype='branchtype2' and trim(code)=b.branchtype2 and b.agentcode=a.agentcode)" + " from lacomtoagent a where agentcom='"
				+ cAgentComCode + "'";
		tSSRS = tExeSQL.execSQL(SQLstr);
		if (tSSRS.MaxRow <= 0) {
			return null;
		}

		try {
			GAgentCode = tSSRS.getAllData();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return GAgentCode;
	}

	/**
	 * 校验系统目前，是否处于管理机构是否处于上个月薪资计算至考核归属之间
	 * 
	 * @param managecom
	 *            管理机构代码
	 * @param branchtype
	 *            渠道
	 * @return 处于之间返回true，不处于返回false
	 */
	public static boolean isWageAssessTime(String managecom, String branchtype) {
		return isWageAssessTime(managecom, branchtype, PubFun.getCurrentDate());
	}

	/**
	 * 校验传入日期是否处于管理机构是否处于上个月薪资计算至考核归属之间
	 * 
	 * @param managecom
	 *            管理机构代码
	 * @param branchtype
	 *            渠道
	 * @param date
	 *            日期，格式为：2012-12-1
	 * 
	 *            ******************************日期格式请不要传错*****************************************
	 * 
	 * @return 处于之间返回true，不处于返回false
	 */
	public static boolean isWageAssessTime(String managecom, String branchtype, String date) {
		String subCom = managecom.substring(0, 4);
		String[] temp = StringUtils.split(PubFun.calDate(date, -1, "M", null), '-');
		// 传入日期的上个月
		String wageno = temp[0] + temp[1];
		// 查询分公司薪资状态，没有记录默认薪资没有开始就算
		String sql = "select isnull(min(state),11) from lawagehistory where aclass='03' and branchtype='" + branchtype + "' and managecom like '" + subCom + "%' and wageno='" + wageno + "'";
		ExeSQL exeSQL = new ExeSQL();
		String wageState = exeSQL.getOneValue(sql);
		int state = Integer.valueOf(wageState);
		if (state > 11) {
			System.out.println("薪资已经开始计算！");
			if (state == 21) {
				System.out.println("薪资已经审核发放！");
				// 查询考核状态
				/****************************************
				 * 考核目前没有上线，不计算考核，所以默认薪资审核发放后，考核已经归属完毕
				 **************************************** 
				 * 
				 * sql = "select count(1) from laassessmain where assesstype='00' and branchtype='"+branchtype+"' and managecom like '"
				 * +subCom+"%' and indexcalno='"+wageno+"'"; String count = exeSQL.getOneValue(sql); if("0".equals(count)) {
				 * System.out.println("还没有开始考核！"); return true; } else { sql =
				 * "select min(state) from laassessmain where assesscount>0 and assesstype='00' and branchtype='"
				 * +branchtype+"' and managecom like '"+subCom+"%' and indexcalno='"+wageno+"'"; String assessState = exeSQL.getOneValue(sql);
				 * if(!"2".equals(assessState)) { System.out.println("考核还没有归属完！"); return true; } }
				 ****************************************/
			} else {
				System.out.println("薪资在计算至审核之间！");
				return true;
			}
		}

		return false;
	}

//	public static void main(String args[]) {
		// String attr = AgentPubFun.CreateBranchAttr("0001","02","1","01");
		// String attr = AgentPubFun.getMaxBranchAttr("0001","0001007");
		// System.out.println(attr);
		// String Agentcode = "000000000473";
		// System.out.println(getBranchSeries(Agentcode));
		// System.out.println(calWageNoIntv("200507", "200506"));
		// System.out.println(isWageAssessTime("8623", "1"));
//		System.out.println(isWageAssessTime("8607", "1", "2010-2-3"));
//	}
}
