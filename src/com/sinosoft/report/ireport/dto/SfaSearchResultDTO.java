package com.sinosoft.report.ireport.dto;

import net.sf.jasperreports.engine.JREmptyDataSource;

/**
 * 客户检索结果DTO类
 * 
 * @author xujun
 * 
 */
public class SfaSearchResultDTO {
	private static final long serialVersionUID = 1;

	/** 子报表 */
	private JREmptyDataSource subDataSource;
	
	/** 图片路径*/
	private String imagePath;

	/** 组编号 */
	private String groupno;

	/** 检索条件编号（系统设定编号/总公司设定流水号） */
	private String searchId;

	/** 检索条件显示名称 */
	private String ruleName;

	/** 检索结果家庭个数 */
	private String familyCount;

	/** 检索条件内容 */
	private String ruleDescription;

	/** 代理人姓名 */
	private String agentName;

	/** 查询对象月显示名称 */
	private String searchMonthName;
	
	/** 复核人（在河北和辽宁的发票打印会用到） ---modify by baidq------2010-10-20 */
	private String Checker;
	
	/** 操作人员（打印用） */
	private String operator;

	/** 操作时间（打印用） */
	private String operDate;

	/** 报表路径（打印用） */
	private String filePath;
	
	/** 家庭编号（打印用） */
	private String familyCode;
	
	
	private String contNo;
	
	
	private String edorNo;
	
	/** ************************************险种信息********************************** */
	/** 家庭关系 "01"-本人 "02"-配偶 "03"-子女 */
	private String relation;

	/** 个人基本客户号 */
	private String customId;

	/** 承保客户号 */
	private String cltCustomId;

	/** 客户姓名 */
	private String customName;

	/** 性别 */
	private String sex;

	/** 出生年月日 */
	private String birthday;

	/** 年龄 */
	private String age;

	/** 采用度/增员机会 */
	private String possibilityofincrease;

	/** 访问事由一 */
	private String visit1;

	/** 访问事由二 */
	private String visit2;

	/** 访问事由三 */
	private String visit3;

	/** 访问事由对应日期 */
	private String visitDay;

	/** 分紅储蓄 */
	private String fenhong;

	/** 年金 */
	private String nianjin;

	/** 子女教育 */
	private String jiaoyu;

	/** 重大疾病 */
	private String zhongji;

	/** 年金重疾 */
	private String nianjinzhongji;

	/** 定期 */
	private String dingqi;

	/** 伤害 */
	private String shanghai;

	/** 入院 */
	private String ruyuan;

	/** 伤害医疗 */
	private String shangyi;

	/** 保费免除 */
	private String mianbaofei;
	
	/** 最新生活设计书 */
	private String fpDay;

	/** 最新保障设计书 */
	private String sfaDay;
	
	/** 投保人姓名 */
	private String appntName;
	
	/** 其他业务号码 */
	private String otherNo;
	
	/** 大写金额 */
	private String premCap;
	
	/** 小写金额 */
	private String premLow;
	
	/** 险种代码 */
	private String riskCode;
	
	/** 被保人姓名 */
	private String insuredName;	
	
	/** 保费 */
	private String prem;
	
	/** 代理人标签 */
	private String agentTag;
	
	/**  代理人单位标签*/
	private String agentGroupTag;
	
	/** 代理人单位*/
	private String agentGroup;
	
	/** 客服电话 */
	private String searchMonth;
	
	/** 系统当前日期 */
	private String printDate;
	/** 其他号码*/
	private String othernoName;
	/**缴费次数**77777777777新加上的一个属性201-7-7********/          
	private String payCount;
	
	/**险种1**/
	private String riskCode1;
	/**被保人1**/
	private String insuredName1;
	/**保险1**/
	private String prem1;
	
	/**险种2**/
	private String riskCode2;
	/**被保人2**/
	private String insuredName2;
	/**保险2**/
	private String prem2;
	
	/**险种3**/
	private String riskCode3;
	/**被保人3**/
	private String insuredName3;
	/**保险3**/
	private String prem3;
	
	/**险种4**/
	private String riskCode4;
	/**被保人4**/
	private String insuredName4;
	/**保险4**/
	private String prem4;
	
	/**险种5**/
	private String riskCode5;
	/**被保人5**/
	private String insuredName5;
	/**保险5**/
	private String prem5;
	
	private String printDay;
	
	private String printMonth;
	
	private String printYear;
/**--------------------------以下为河南发票字段2010-08-24----------------*/	
	/**机打票号*/
	private String prtseq;
	/**代理人代码*/
	private String agentCode;
	/**交费方式*/
	private String payintv;
	/**交费期间*/
	private String payYears;
	/**交费开始日期*/
	private String cvalidate;
	/**交费结束日期*/
	private String paytodate;
	/**收费形式*/
	private String paymode;	
	/**临时字段*/
	private String str;
	
	
	public String getPrintDay() {
		return printDay;
	}

	public void setPrintDay(String printDay) {
		this.printDay = printDay;
	}

	public String getPrintMonth() {
		return printMonth;
	}

	public void setPrintMonth(String printMonth) {
		this.printMonth = printMonth;
	}

	public String getPrintYear() {
		return printYear;
	}

	public void setPrintYear(String printYear) {
		this.printYear = printYear;
	}

	public String getPrintDate() {
		return printDate;
	}

	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgentGroup() {
		return agentGroup;
	}

	public void setAgentGroup(String agentGroup) {
		this.agentGroup = agentGroup;
	}

	public String getAgentGroupTag() {
		return agentGroupTag;
	}

	public void setAgentGroupTag(String agentGroupTag) {
		this.agentGroupTag = agentGroupTag;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentTag() {
		return agentTag;
	}

	public void setAgentTag(String agentTag) {
		this.agentTag = agentTag;
	}

	public String getAppntName() {
		return appntName;
	}

	public void setAppntName(String appntName) {
		this.appntName = appntName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCltCustomId() {
		return cltCustomId;
	}

	public void setCltCustomId(String cltCustomId) {
		this.cltCustomId = cltCustomId;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getDingqi() {
		return dingqi;
	}

	public void setDingqi(String dingqi) {
		this.dingqi = dingqi;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public String getFamilyCount() {
		return familyCount;
	}

	public void setFamilyCount(String familyCount) {
		this.familyCount = familyCount;
	}

	public String getFenhong() {
		return fenhong;
	}

	public void setFenhong(String fenhong) {
		this.fenhong = fenhong;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFpDay() {
		return fpDay;
	}

	public void setFpDay(String fpDay) {
		this.fpDay = fpDay;
	}

	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getJiaoyu() {
		return jiaoyu;
	}

	public void setJiaoyu(String jiaoyu) {
		this.jiaoyu = jiaoyu;
	}

	public String getMianbaofei() {
		return mianbaofei;
	}

	public void setMianbaofei(String mianbaofei) {
		this.mianbaofei = mianbaofei;
	}

	public String getNianjin() {
		return nianjin;
	}

	public void setNianjin(String nianjin) {
		this.nianjin = nianjin;
	}

	public String getNianjinzhongji() {
		return nianjinzhongji;
	}

	public void setNianjinzhongji(String nianjinzhongji) {
		this.nianjinzhongji = nianjinzhongji;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperDate() {
		return operDate;
	}

	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}
	
	public String getOtherNo() {
		return otherNo;
	}

	public void setOtherNo(String otherNo) {
		this.otherNo = otherNo;
	}

	public String getPossibilityofincrease() {
		return possibilityofincrease;
	}

	public void setPossibilityofincrease(String possibilityofincrease) {
		this.possibilityofincrease = possibilityofincrease;
	}

	public String getPrem() {
		return prem;
	}

	public void setPrem(String prem) {
		this.prem = prem;
	}

	public String getPremCap() {
		return premCap;
	}

	public void setPremCap(String premCap) {
		this.premCap = premCap;
	}

	public String getPremLow() {
		return premLow;
	}

	public void setPremLow(String premLow) {
		this.premLow = premLow;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuyuan() {
		return ruyuan;
	}

	public void setRuyuan(String ruyuan) {
		this.ruyuan = ruyuan;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getSearchMonth() {
		return searchMonth;
	}

	public void setSearchMonth(String searchMonth) {
		this.searchMonth = searchMonth;
	}

	public String getSearchMonthName() {
		return searchMonthName;
	}

	public void setSearchMonthName(String searchMonthName) {
		this.searchMonthName = searchMonthName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSfaDay() {
		return sfaDay;
	}

	public void setSfaDay(String sfaDay) {
		this.sfaDay = sfaDay;
	}

	public String getShanghai() {
		return shanghai;
	}

	public void setShanghai(String shanghai) {
		this.shanghai = shanghai;
	}

	public String getShangyi() {
		return shangyi;
	}

	public void setShangyi(String shangyi) {
		this.shangyi = shangyi;
	}

	public JREmptyDataSource getSubDataSource() {
		return subDataSource;
	}

	public void setSubDataSource(JREmptyDataSource subDataSource) {
		this.subDataSource = subDataSource;
	}

	public String getVisit1() {
		return visit1;
	}

	public void setVisit1(String visit1) {
		this.visit1 = visit1;
	}

	public String getVisit2() {
		return visit2;
	}

	public void setVisit2(String visit2) {
		this.visit2 = visit2;
	}

	public String getVisit3() {
		return visit3;
	}

	public void setVisit3(String visit3) {
		this.visit3 = visit3;
	}

	public String getVisitDay() {
		return visitDay;
	}

	public void setVisitDay(String visitDay) {
		this.visitDay = visitDay;
	}

	public String getZhongji() {
		return zhongji;
	}

	public void setZhongji(String zhongji) {
		this.zhongji = zhongji;
	}

	public String getOthernoName() {
		return othernoName;
	}

	public void setOthernoName(String othernoName) {
		this.othernoName = othernoName;
	}

	public String getRiskCode1() {
		return riskCode1;
	}

	public void setRiskCode1(String riskCode1) {
		this.riskCode1 = riskCode1;
	}

	public String getInsuredName1() {
		return insuredName1;
	}

	public void setInsuredName1(String insuredName1) {
		this.insuredName1 = insuredName1;
	}

	public String getPrem1() {
		return prem1;
	}

	public void setPrem1(String prem1) {
		this.prem1 = prem1;
	}

	public String getRiskCode2() {
		return riskCode2;
	}

	public void setRiskCode2(String riskCode2) {
		this.riskCode2 = riskCode2;
	}

	public String getInsuredName2() {
		return insuredName2;
	}

	public void setInsuredName2(String insuredName2) {
		this.insuredName2 = insuredName2;
	}

	public String getPrem2() {
		return prem2;
	}

	public void setPrem2(String prem2) {
		this.prem2 = prem2;
	}

	public String getRiskCode3() {
		return riskCode3;
	}

	public void setRiskCode3(String riskCode3) {
		this.riskCode3 = riskCode3;
	}

	public String getInsuredName3() {
		return insuredName3;
	}

	public void setInsuredName3(String insuredName3) {
		this.insuredName3 = insuredName3;
	}

	public String getPrem3() {
		return prem3;
	}

	public void setPrem3(String prem3) {
		this.prem3 = prem3;
	}

	public String getRiskCode4() {
		return riskCode4;
	}

	public void setRiskCode4(String riskCode4) {
		this.riskCode4 = riskCode4;
	}

	public String getInsuredName4() {
		return insuredName4;
	}

	public void setInsuredName4(String insuredName4) {
		this.insuredName4 = insuredName4;
	}

	public String getPrem4() {
		return prem4;
	}

	public void setPrem4(String prem4) {
		this.prem4 = prem4;
	}

	public String getRiskCode5() {
		return riskCode5;
	}

	public void setRiskCode5(String riskCode5) {
		this.riskCode5 = riskCode5;
	}

	public String getInsuredName5() {
		return insuredName5;
	}

	public void setInsuredName5(String insuredName5) {
		this.insuredName5 = insuredName5;
	}

	public String getPrem5() {
		return prem5;
	}

	public void setPrem5(String prem5) {
		this.prem5 = prem5;
	}

	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	public String getEdorNo() {
		return edorNo;
	}

	public void setEdorNo(String edorNo) {
		this.edorNo = edorNo;
	}

	public String getPayCount() {
		return payCount;
	}

	public void setPayCount(String payCount) {
		this.payCount = payCount;
	}

	public String getPrtseq() {
		return prtseq;
	}

	public void setPrtseq(String prtseq) {
		this.prtseq = prtseq;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getPayintv() {
		return payintv;
	}

	public void setPayintv(String payintv) {
		this.payintv = payintv;
	}

	public String getPayYears() {
		return payYears;
	}

	public void setPayYears(String payYears) {
		this.payYears = payYears;
	}

	public String getCvalidate() {
		return cvalidate;
	}

	public void setCvalidate(String cvalidate) {
		this.cvalidate = cvalidate;
	}

	public String getPaytodate() {
		return paytodate;
	}

	public void setPaytodate(String paytodate) {
		this.paytodate = paytodate;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getChecker() {
		return Checker;
	}

	public void setChecker(String checker) {
		Checker = checker;
	}
	
	/** ************************************活动信息********************************** */
	

}
