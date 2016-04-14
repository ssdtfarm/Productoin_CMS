/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.schema;

import org.apache.log4j.Logger;
import java.sql.*;
import java.io.*;
import java.util.Date;
import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.utility.*;
import com.sinosoft.lis.db.LAAgentFPUnApprovalBDB;

/*
 * <p>ClassName: LAAgentFPUnApprovalBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LAAgentFP_Setting
 */
public class LAAgentFPUnApprovalBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentFPUnApprovalBSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Plantype */
	private String PlanType;
	/** Financepackage */
	private String FinancePackage;
	/** Financestartmonth */
	private String FinanceStartMonth;
	/** Monthlyinstallment */
	private int MonthlyInstallment;
	/** Financeendmonth */
	private String FinanceEndMonth;
	/** Fpai */
	private double FPAI;
	/** Cbpaidmonth */
	private String CBPaidMonth;
	/** Cbinstallmentmonth */
	private int CBInstallmentMonth;
	/** Challengebonusamount */
	private double ChallengeBonusAmount;
	/** Achieverewardrate */
	private double AchieveRewardRate;
	/** Achieverewardamount */
	private double AchieveRewardAmount;
	/** Megafixedbonusreq */
	private double MegaFixedBonusReq;
	/** Megafixedbonus */
	private double MegaFixedBonus;
	/** Megaextrabonusreq */
	private double MegaExtraBonusReq;
	/** Megaextrabonusrate */
	private double MegaExtraBonusRate;
	/** Megaawardreq */
	private double MegaAwardReq;
	/** Megaaward */
	private double MegaAward;
	/** Approvaldate */
	private Date ApprovalDate;
	/** Approvaltime */
	private String ApprovalTime;
	/** Approvaloperator */
	private String ApprovalOperator;
	/** Approvalreason */
	private String ApprovalReason;
	/** Approvalflag */
	private String ApprovalFlag;
	/** Operator */
	private String Operator;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;
	/** Operator1 */
	private String Operator1;

	public static final int FIELDNUM = 31;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentFPUnApprovalBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[5];
		pk[0] = "AgentCode";
		pk[1] = "FinanceStartMonth";
		pk[2] = "MakeDate1";
		pk[3] = "MakeTime1";
		pk[4] = "Operator1";

		PK = pk;
	}

	/**
	* Schema克隆
	* @return Object
	* @throws CloneNotSupportedException
	*/
	public Object clone()
		throws CloneNotSupportedException
	{
		LAAgentFPUnApprovalBSchema cloned = (LAAgentFPUnApprovalBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>12)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值12");
		AgentCode = aAgentCode;
	}
	public String getPlanType()
	{
		return PlanType;
	}
	public void setPlanType(String aPlanType)
	{
		if(aPlanType!=null && aPlanType.length()>2)
			throw new IllegalArgumentException("PlantypePlanType值"+aPlanType+"的长度"+aPlanType.length()+"大于最大值2");
		PlanType = aPlanType;
	}
	public String getFinancePackage()
	{
		return FinancePackage;
	}
	public void setFinancePackage(String aFinancePackage)
	{
		if(aFinancePackage!=null && aFinancePackage.length()>60)
			throw new IllegalArgumentException("FinancepackageFinancePackage值"+aFinancePackage+"的长度"+aFinancePackage.length()+"大于最大值60");
		FinancePackage = aFinancePackage;
	}
	public String getFinanceStartMonth()
	{
		return FinanceStartMonth;
	}
	public void setFinanceStartMonth(String aFinanceStartMonth)
	{
		if(aFinanceStartMonth!=null && aFinanceStartMonth.length()>6)
			throw new IllegalArgumentException("FinancestartmonthFinanceStartMonth值"+aFinanceStartMonth+"的长度"+aFinanceStartMonth.length()+"大于最大值6");
		FinanceStartMonth = aFinanceStartMonth;
	}
	public int getMonthlyInstallment()
	{
		return MonthlyInstallment;
	}
	public void setMonthlyInstallment(int aMonthlyInstallment)
	{
		MonthlyInstallment = aMonthlyInstallment;
	}
	public void setMonthlyInstallment(String aMonthlyInstallment)
	{
		if (aMonthlyInstallment != null && !aMonthlyInstallment.equals(""))
		{
			Integer tInteger = new Integer(aMonthlyInstallment);
			int i = tInteger.intValue();
			MonthlyInstallment = i;
		}
	}

	public String getFinanceEndMonth()
	{
		return FinanceEndMonth;
	}
	public void setFinanceEndMonth(String aFinanceEndMonth)
	{
		if(aFinanceEndMonth!=null && aFinanceEndMonth.length()>6)
			throw new IllegalArgumentException("FinanceendmonthFinanceEndMonth值"+aFinanceEndMonth+"的长度"+aFinanceEndMonth.length()+"大于最大值6");
		FinanceEndMonth = aFinanceEndMonth;
	}
	public double getFPAI()
	{
		return FPAI;
	}
	public void setFPAI(double aFPAI)
	{
		FPAI = aFPAI;
	}
	public void setFPAI(String aFPAI)
	{
		if (aFPAI != null && !aFPAI.equals(""))
		{
			Double tDouble = new Double(aFPAI);
			double d = tDouble.doubleValue();
			FPAI = d;
		}
	}

	public String getCBPaidMonth()
	{
		return CBPaidMonth;
	}
	public void setCBPaidMonth(String aCBPaidMonth)
	{
		if(aCBPaidMonth!=null && aCBPaidMonth.length()>6)
			throw new IllegalArgumentException("CbpaidmonthCBPaidMonth值"+aCBPaidMonth+"的长度"+aCBPaidMonth.length()+"大于最大值6");
		CBPaidMonth = aCBPaidMonth;
	}
	public int getCBInstallmentMonth()
	{
		return CBInstallmentMonth;
	}
	public void setCBInstallmentMonth(int aCBInstallmentMonth)
	{
		CBInstallmentMonth = aCBInstallmentMonth;
	}
	public void setCBInstallmentMonth(String aCBInstallmentMonth)
	{
		if (aCBInstallmentMonth != null && !aCBInstallmentMonth.equals(""))
		{
			Integer tInteger = new Integer(aCBInstallmentMonth);
			int i = tInteger.intValue();
			CBInstallmentMonth = i;
		}
	}

	public double getChallengeBonusAmount()
	{
		return ChallengeBonusAmount;
	}
	public void setChallengeBonusAmount(double aChallengeBonusAmount)
	{
		ChallengeBonusAmount = aChallengeBonusAmount;
	}
	public void setChallengeBonusAmount(String aChallengeBonusAmount)
	{
		if (aChallengeBonusAmount != null && !aChallengeBonusAmount.equals(""))
		{
			Double tDouble = new Double(aChallengeBonusAmount);
			double d = tDouble.doubleValue();
			ChallengeBonusAmount = d;
		}
	}

	public double getAchieveRewardRate()
	{
		return AchieveRewardRate;
	}
	public void setAchieveRewardRate(double aAchieveRewardRate)
	{
		AchieveRewardRate = aAchieveRewardRate;
	}
	public void setAchieveRewardRate(String aAchieveRewardRate)
	{
		if (aAchieveRewardRate != null && !aAchieveRewardRate.equals(""))
		{
			Double tDouble = new Double(aAchieveRewardRate);
			double d = tDouble.doubleValue();
			AchieveRewardRate = d;
		}
	}

	public double getAchieveRewardAmount()
	{
		return AchieveRewardAmount;
	}
	public void setAchieveRewardAmount(double aAchieveRewardAmount)
	{
		AchieveRewardAmount = aAchieveRewardAmount;
	}
	public void setAchieveRewardAmount(String aAchieveRewardAmount)
	{
		if (aAchieveRewardAmount != null && !aAchieveRewardAmount.equals(""))
		{
			Double tDouble = new Double(aAchieveRewardAmount);
			double d = tDouble.doubleValue();
			AchieveRewardAmount = d;
		}
	}

	public double getMegaFixedBonusReq()
	{
		return MegaFixedBonusReq;
	}
	public void setMegaFixedBonusReq(double aMegaFixedBonusReq)
	{
		MegaFixedBonusReq = aMegaFixedBonusReq;
	}
	public void setMegaFixedBonusReq(String aMegaFixedBonusReq)
	{
		if (aMegaFixedBonusReq != null && !aMegaFixedBonusReq.equals(""))
		{
			Double tDouble = new Double(aMegaFixedBonusReq);
			double d = tDouble.doubleValue();
			MegaFixedBonusReq = d;
		}
	}

	public double getMegaFixedBonus()
	{
		return MegaFixedBonus;
	}
	public void setMegaFixedBonus(double aMegaFixedBonus)
	{
		MegaFixedBonus = aMegaFixedBonus;
	}
	public void setMegaFixedBonus(String aMegaFixedBonus)
	{
		if (aMegaFixedBonus != null && !aMegaFixedBonus.equals(""))
		{
			Double tDouble = new Double(aMegaFixedBonus);
			double d = tDouble.doubleValue();
			MegaFixedBonus = d;
		}
	}

	public double getMegaExtraBonusReq()
	{
		return MegaExtraBonusReq;
	}
	public void setMegaExtraBonusReq(double aMegaExtraBonusReq)
	{
		MegaExtraBonusReq = aMegaExtraBonusReq;
	}
	public void setMegaExtraBonusReq(String aMegaExtraBonusReq)
	{
		if (aMegaExtraBonusReq != null && !aMegaExtraBonusReq.equals(""))
		{
			Double tDouble = new Double(aMegaExtraBonusReq);
			double d = tDouble.doubleValue();
			MegaExtraBonusReq = d;
		}
	}

	public double getMegaExtraBonusRate()
	{
		return MegaExtraBonusRate;
	}
	public void setMegaExtraBonusRate(double aMegaExtraBonusRate)
	{
		MegaExtraBonusRate = aMegaExtraBonusRate;
	}
	public void setMegaExtraBonusRate(String aMegaExtraBonusRate)
	{
		if (aMegaExtraBonusRate != null && !aMegaExtraBonusRate.equals(""))
		{
			Double tDouble = new Double(aMegaExtraBonusRate);
			double d = tDouble.doubleValue();
			MegaExtraBonusRate = d;
		}
	}

	public double getMegaAwardReq()
	{
		return MegaAwardReq;
	}
	public void setMegaAwardReq(double aMegaAwardReq)
	{
		MegaAwardReq = aMegaAwardReq;
	}
	public void setMegaAwardReq(String aMegaAwardReq)
	{
		if (aMegaAwardReq != null && !aMegaAwardReq.equals(""))
		{
			Double tDouble = new Double(aMegaAwardReq);
			double d = tDouble.doubleValue();
			MegaAwardReq = d;
		}
	}

	public double getMegaAward()
	{
		return MegaAward;
	}
	public void setMegaAward(double aMegaAward)
	{
		MegaAward = aMegaAward;
	}
	public void setMegaAward(String aMegaAward)
	{
		if (aMegaAward != null && !aMegaAward.equals(""))
		{
			Double tDouble = new Double(aMegaAward);
			double d = tDouble.doubleValue();
			MegaAward = d;
		}
	}

	public String getApprovalDate()
	{
		if( ApprovalDate != null )
			return fDate.getString(ApprovalDate);
		else
			return null;
	}
	public void setApprovalDate(Date aApprovalDate)
	{
		ApprovalDate = aApprovalDate;
	}
	public void setApprovalDate(String aApprovalDate)
	{
		if (aApprovalDate != null && !aApprovalDate.equals("") )
		{
			ApprovalDate = fDate.getDate( aApprovalDate );
		}
		else
			ApprovalDate = null;
	}

	public String getApprovalTime()
	{
		return ApprovalTime;
	}
	public void setApprovalTime(String aApprovalTime)
	{
		if(aApprovalTime!=null && aApprovalTime.length()>8)
			throw new IllegalArgumentException("ApprovaltimeApprovalTime值"+aApprovalTime+"的长度"+aApprovalTime.length()+"大于最大值8");
		ApprovalTime = aApprovalTime;
	}
	public String getApprovalOperator()
	{
		return ApprovalOperator;
	}
	public void setApprovalOperator(String aApprovalOperator)
	{
		if(aApprovalOperator!=null && aApprovalOperator.length()>60)
			throw new IllegalArgumentException("ApprovaloperatorApprovalOperator值"+aApprovalOperator+"的长度"+aApprovalOperator.length()+"大于最大值60");
		ApprovalOperator = aApprovalOperator;
	}
	public String getApprovalReason()
	{
		return ApprovalReason;
	}
	public void setApprovalReason(String aApprovalReason)
	{
		if(aApprovalReason!=null && aApprovalReason.length()>500)
			throw new IllegalArgumentException("ApprovalreasonApprovalReason值"+aApprovalReason+"的长度"+aApprovalReason.length()+"大于最大值500");
		ApprovalReason = aApprovalReason;
	}
	public String getApprovalFlag()
	{
		return ApprovalFlag;
	}
	public void setApprovalFlag(String aApprovalFlag)
	{
		if(aApprovalFlag!=null && aApprovalFlag.length()>2)
			throw new IllegalArgumentException("ApprovalflagApprovalFlag值"+aApprovalFlag+"的长度"+aApprovalFlag.length()+"大于最大值2");
		ApprovalFlag = aApprovalFlag;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>60)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值60");
		Operator = aOperator;
	}
	public String getMakeDate()
	{
		if( MakeDate != null )
			return fDate.getString(MakeDate);
		else
			return null;
	}
	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}
	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals("") )
		{
			MakeDate = fDate.getDate( aMakeDate );
		}
		else
			MakeDate = null;
	}

	public String getMakeTime()
	{
		return MakeTime;
	}
	public void setMakeTime(String aMakeTime)
	{
		if(aMakeTime!=null && aMakeTime.length()>8)
			throw new IllegalArgumentException("MaketimeMakeTime值"+aMakeTime+"的长度"+aMakeTime.length()+"大于最大值8");
		MakeTime = aMakeTime;
	}
	public String getModifyDate()
	{
		if( ModifyDate != null )
			return fDate.getString(ModifyDate);
		else
			return null;
	}
	public void setModifyDate(Date aModifyDate)
	{
		ModifyDate = aModifyDate;
	}
	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals("") )
		{
			ModifyDate = fDate.getDate( aModifyDate );
		}
		else
			ModifyDate = null;
	}

	public String getModifyTime()
	{
		return ModifyTime;
	}
	public void setModifyTime(String aModifyTime)
	{
		if(aModifyTime!=null && aModifyTime.length()>8)
			throw new IllegalArgumentException("ModifytimeModifyTime值"+aModifyTime+"的长度"+aModifyTime.length()+"大于最大值8");
		ModifyTime = aModifyTime;
	}
	public String getMakeDate1()
	{
		if( MakeDate1 != null )
			return fDate.getString(MakeDate1);
		else
			return null;
	}
	public void setMakeDate1(Date aMakeDate1)
	{
		MakeDate1 = aMakeDate1;
	}
	public void setMakeDate1(String aMakeDate1)
	{
		if (aMakeDate1 != null && !aMakeDate1.equals("") )
		{
			MakeDate1 = fDate.getDate( aMakeDate1 );
		}
		else
			MakeDate1 = null;
	}

	public String getMakeTime1()
	{
		return MakeTime1;
	}
	public void setMakeTime1(String aMakeTime1)
	{
		if(aMakeTime1!=null && aMakeTime1.length()>8)
			throw new IllegalArgumentException("Maketime1MakeTime1值"+aMakeTime1+"的长度"+aMakeTime1.length()+"大于最大值8");
		MakeTime1 = aMakeTime1;
	}
	public String getOperator1()
	{
		return Operator1;
	}
	public void setOperator1(String aOperator1)
	{
		if(aOperator1!=null && aOperator1.length()>60)
			throw new IllegalArgumentException("Operator1Operator1值"+aOperator1+"的长度"+aOperator1.length()+"大于最大值60");
		Operator1 = aOperator1;
	}

	/**
	* 使用另外一个 LAAgentFPUnApprovalBSchema 对象给 Schema 赋值
	* @param: aLAAgentFPUnApprovalBSchema LAAgentFPUnApprovalBSchema
	**/
	public void setSchema(LAAgentFPUnApprovalBSchema aLAAgentFPUnApprovalBSchema)
	{
		this.AgentCode = aLAAgentFPUnApprovalBSchema.getAgentCode();
		this.PlanType = aLAAgentFPUnApprovalBSchema.getPlanType();
		this.FinancePackage = aLAAgentFPUnApprovalBSchema.getFinancePackage();
		this.FinanceStartMonth = aLAAgentFPUnApprovalBSchema.getFinanceStartMonth();
		this.MonthlyInstallment = aLAAgentFPUnApprovalBSchema.getMonthlyInstallment();
		this.FinanceEndMonth = aLAAgentFPUnApprovalBSchema.getFinanceEndMonth();
		this.FPAI = aLAAgentFPUnApprovalBSchema.getFPAI();
		this.CBPaidMonth = aLAAgentFPUnApprovalBSchema.getCBPaidMonth();
		this.CBInstallmentMonth = aLAAgentFPUnApprovalBSchema.getCBInstallmentMonth();
		this.ChallengeBonusAmount = aLAAgentFPUnApprovalBSchema.getChallengeBonusAmount();
		this.AchieveRewardRate = aLAAgentFPUnApprovalBSchema.getAchieveRewardRate();
		this.AchieveRewardAmount = aLAAgentFPUnApprovalBSchema.getAchieveRewardAmount();
		this.MegaFixedBonusReq = aLAAgentFPUnApprovalBSchema.getMegaFixedBonusReq();
		this.MegaFixedBonus = aLAAgentFPUnApprovalBSchema.getMegaFixedBonus();
		this.MegaExtraBonusReq = aLAAgentFPUnApprovalBSchema.getMegaExtraBonusReq();
		this.MegaExtraBonusRate = aLAAgentFPUnApprovalBSchema.getMegaExtraBonusRate();
		this.MegaAwardReq = aLAAgentFPUnApprovalBSchema.getMegaAwardReq();
		this.MegaAward = aLAAgentFPUnApprovalBSchema.getMegaAward();
		this.ApprovalDate = fDate.getDate( aLAAgentFPUnApprovalBSchema.getApprovalDate());
		this.ApprovalTime = aLAAgentFPUnApprovalBSchema.getApprovalTime();
		this.ApprovalOperator = aLAAgentFPUnApprovalBSchema.getApprovalOperator();
		this.ApprovalReason = aLAAgentFPUnApprovalBSchema.getApprovalReason();
		this.ApprovalFlag = aLAAgentFPUnApprovalBSchema.getApprovalFlag();
		this.Operator = aLAAgentFPUnApprovalBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentFPUnApprovalBSchema.getMakeDate());
		this.MakeTime = aLAAgentFPUnApprovalBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentFPUnApprovalBSchema.getModifyDate());
		this.ModifyTime = aLAAgentFPUnApprovalBSchema.getModifyTime();
		this.MakeDate1 = fDate.getDate( aLAAgentFPUnApprovalBSchema.getMakeDate1());
		this.MakeTime1 = aLAAgentFPUnApprovalBSchema.getMakeTime1();
		this.Operator1 = aLAAgentFPUnApprovalBSchema.getOperator1();
	}

	/**
	* 使用 ResultSet 中的第 i 行给 Schema 赋值
	* @param: rs ResultSet
	* @param: i int
	* @return: boolean
	**/
	public boolean setSchema(ResultSet rs,int i)
	{
		try
		{
			//rs.absolute(i);		// 非滚动游标
			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("PlanType") == null )
				this.PlanType = null;
			else
				this.PlanType = rs.getString("PlanType").trim();

			if( rs.getString("FinancePackage") == null )
				this.FinancePackage = null;
			else
				this.FinancePackage = rs.getString("FinancePackage").trim();

			if( rs.getString("FinanceStartMonth") == null )
				this.FinanceStartMonth = null;
			else
				this.FinanceStartMonth = rs.getString("FinanceStartMonth").trim();

			this.MonthlyInstallment = rs.getInt("MonthlyInstallment");
			if( rs.getString("FinanceEndMonth") == null )
				this.FinanceEndMonth = null;
			else
				this.FinanceEndMonth = rs.getString("FinanceEndMonth").trim();

			this.FPAI = rs.getDouble("FPAI");
			if( rs.getString("CBPaidMonth") == null )
				this.CBPaidMonth = null;
			else
				this.CBPaidMonth = rs.getString("CBPaidMonth").trim();

			this.CBInstallmentMonth = rs.getInt("CBInstallmentMonth");
			this.ChallengeBonusAmount = rs.getDouble("ChallengeBonusAmount");
			this.AchieveRewardRate = rs.getDouble("AchieveRewardRate");
			this.AchieveRewardAmount = rs.getDouble("AchieveRewardAmount");
			this.MegaFixedBonusReq = rs.getDouble("MegaFixedBonusReq");
			this.MegaFixedBonus = rs.getDouble("MegaFixedBonus");
			this.MegaExtraBonusReq = rs.getDouble("MegaExtraBonusReq");
			this.MegaExtraBonusRate = rs.getDouble("MegaExtraBonusRate");
			this.MegaAwardReq = rs.getDouble("MegaAwardReq");
			this.MegaAward = rs.getDouble("MegaAward");
			this.ApprovalDate = rs.getDate("ApprovalDate");
			if( rs.getString("ApprovalTime") == null )
				this.ApprovalTime = null;
			else
				this.ApprovalTime = rs.getString("ApprovalTime").trim();

			if( rs.getString("ApprovalOperator") == null )
				this.ApprovalOperator = null;
			else
				this.ApprovalOperator = rs.getString("ApprovalOperator").trim();

			if( rs.getString("ApprovalReason") == null )
				this.ApprovalReason = null;
			else
				this.ApprovalReason = rs.getString("ApprovalReason").trim();

			if( rs.getString("ApprovalFlag") == null )
				this.ApprovalFlag = null;
			else
				this.ApprovalFlag = rs.getString("ApprovalFlag").trim();

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

			this.ModifyDate = rs.getDate("ModifyDate");
			if( rs.getString("ModifyTime") == null )
				this.ModifyTime = null;
			else
				this.ModifyTime = rs.getString("ModifyTime").trim();

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

			if( rs.getString("Operator1") == null )
				this.Operator1 = null;
			else
				this.Operator1 = rs.getString("Operator1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAAgentFPUnApprovalB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentFPUnApprovalBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentFPUnApprovalBSchema getSchema()
	{
		LAAgentFPUnApprovalBSchema aLAAgentFPUnApprovalBSchema = new LAAgentFPUnApprovalBSchema();
		aLAAgentFPUnApprovalBSchema.setSchema(this);
		return aLAAgentFPUnApprovalBSchema;
	}

	public LAAgentFPUnApprovalBDB getDB()
	{
		LAAgentFPUnApprovalBDB aDBOper = new LAAgentFPUnApprovalBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentFPUnApprovalB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PlanType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FinancePackage)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FinanceStartMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MonthlyInstallment));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FinanceEndMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(FPAI));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CBPaidMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(CBInstallmentMonth));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(ChallengeBonusAmount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AchieveRewardRate));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AchieveRewardAmount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MegaFixedBonusReq));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MegaFixedBonus));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MegaExtraBonusReq));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MegaExtraBonusRate));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MegaAwardReq));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MegaAward));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ApprovalDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ApprovalTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ApprovalOperator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ApprovalReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ApprovalFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentFPUnApprovalB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			PlanType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			FinancePackage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			FinanceStartMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			MonthlyInstallment= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,5,SysConst.PACKAGESPILTER))).intValue();
			FinanceEndMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			FPAI = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			CBPaidMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			CBInstallmentMonth= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,9,SysConst.PACKAGESPILTER))).intValue();
			ChallengeBonusAmount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,10,SysConst.PACKAGESPILTER))).doubleValue();
			AchieveRewardRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,11,SysConst.PACKAGESPILTER))).doubleValue();
			AchieveRewardAmount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,12,SysConst.PACKAGESPILTER))).doubleValue();
			MegaFixedBonusReq = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,13,SysConst.PACKAGESPILTER))).doubleValue();
			MegaFixedBonus = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,14,SysConst.PACKAGESPILTER))).doubleValue();
			MegaExtraBonusReq = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,15,SysConst.PACKAGESPILTER))).doubleValue();
			MegaExtraBonusRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,16,SysConst.PACKAGESPILTER))).doubleValue();
			MegaAwardReq = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,17,SysConst.PACKAGESPILTER))).doubleValue();
			MegaAward = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,18,SysConst.PACKAGESPILTER))).doubleValue();
			ApprovalDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			ApprovalTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			ApprovalOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			ApprovalReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			ApprovalFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentFPUnApprovalBSchema";
			tError.functionName = "decode";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			return false;
		}
		return true;
	}

	/**
	* 取得对应传入参数的String形式的字段值
	* @param: FCode String 希望取得的字段名
	* @return: String
	* 如果没有对应的字段，返回""
	* 如果字段值为空，返回"null"
	**/
	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("PlanType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PlanType));
		}
		if (FCode.equalsIgnoreCase("FinancePackage"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FinancePackage));
		}
		if (FCode.equalsIgnoreCase("FinanceStartMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FinanceStartMonth));
		}
		if (FCode.equalsIgnoreCase("MonthlyInstallment"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MonthlyInstallment));
		}
		if (FCode.equalsIgnoreCase("FinanceEndMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FinanceEndMonth));
		}
		if (FCode.equalsIgnoreCase("FPAI"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FPAI));
		}
		if (FCode.equalsIgnoreCase("CBPaidMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CBPaidMonth));
		}
		if (FCode.equalsIgnoreCase("CBInstallmentMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CBInstallmentMonth));
		}
		if (FCode.equalsIgnoreCase("ChallengeBonusAmount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ChallengeBonusAmount));
		}
		if (FCode.equalsIgnoreCase("AchieveRewardRate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AchieveRewardRate));
		}
		if (FCode.equalsIgnoreCase("AchieveRewardAmount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AchieveRewardAmount));
		}
		if (FCode.equalsIgnoreCase("MegaFixedBonusReq"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MegaFixedBonusReq));
		}
		if (FCode.equalsIgnoreCase("MegaFixedBonus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MegaFixedBonus));
		}
		if (FCode.equalsIgnoreCase("MegaExtraBonusReq"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MegaExtraBonusReq));
		}
		if (FCode.equalsIgnoreCase("MegaExtraBonusRate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MegaExtraBonusRate));
		}
		if (FCode.equalsIgnoreCase("MegaAwardReq"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MegaAwardReq));
		}
		if (FCode.equalsIgnoreCase("MegaAward"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MegaAward));
		}
		if (FCode.equalsIgnoreCase("ApprovalDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getApprovalDate()));
		}
		if (FCode.equalsIgnoreCase("ApprovalTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ApprovalTime));
		}
		if (FCode.equalsIgnoreCase("ApprovalOperator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ApprovalOperator));
		}
		if (FCode.equalsIgnoreCase("ApprovalReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ApprovalReason));
		}
		if (FCode.equalsIgnoreCase("ApprovalFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ApprovalFlag));
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		}
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		}
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime1));
		}
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator1));
		}
		if (strReturn.equals(""))
		{
			strReturn = "null";
		}

		return strReturn;
	}


	/**
	* 取得Schema中指定索引值所对应的字段值
	* @param: nFieldIndex int 指定的字段索引值
	* @return: String
	* 如果没有对应的字段，返回""
	* 如果字段值为空，返回"null"
	**/
	public String getV(int nFieldIndex)
	{
		String strFieldValue = "";
		switch(nFieldIndex) {
			case 0:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(PlanType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(FinancePackage);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(FinanceStartMonth);
				break;
			case 4:
				strFieldValue = String.valueOf(MonthlyInstallment);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(FinanceEndMonth);
				break;
			case 6:
				strFieldValue = String.valueOf(FPAI);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(CBPaidMonth);
				break;
			case 8:
				strFieldValue = String.valueOf(CBInstallmentMonth);
				break;
			case 9:
				strFieldValue = String.valueOf(ChallengeBonusAmount);
				break;
			case 10:
				strFieldValue = String.valueOf(AchieveRewardRate);
				break;
			case 11:
				strFieldValue = String.valueOf(AchieveRewardAmount);
				break;
			case 12:
				strFieldValue = String.valueOf(MegaFixedBonusReq);
				break;
			case 13:
				strFieldValue = String.valueOf(MegaFixedBonus);
				break;
			case 14:
				strFieldValue = String.valueOf(MegaExtraBonusReq);
				break;
			case 15:
				strFieldValue = String.valueOf(MegaExtraBonusRate);
				break;
			case 16:
				strFieldValue = String.valueOf(MegaAwardReq);
				break;
			case 17:
				strFieldValue = String.valueOf(MegaAward);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getApprovalDate()));
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(ApprovalTime);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(ApprovalOperator);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(ApprovalReason);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(ApprovalFlag);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 27:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 28:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 29:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
				break;
			case 30:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			default:
				strFieldValue = "";
		};
		if( strFieldValue.equals("") ) {
			strFieldValue = "null";
		}
		return strFieldValue;
	}

	/**
	* 设置对应传入参数的String形式的字段值
	* @param: FCode String 需要赋值的对象
	* @param: FValue String 要赋的值
	* @return: boolean
	**/
	public boolean setV(String FCode ,String FValue)
	{
		if( StrTool.cTrim( FCode ).equals( "" ))
			return false;

		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("PlanType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PlanType = FValue.trim();
			}
			else
				PlanType = null;
		}
		if (FCode.equalsIgnoreCase("FinancePackage"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FinancePackage = FValue.trim();
			}
			else
				FinancePackage = null;
		}
		if (FCode.equalsIgnoreCase("FinanceStartMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FinanceStartMonth = FValue.trim();
			}
			else
				FinanceStartMonth = null;
		}
		if (FCode.equalsIgnoreCase("MonthlyInstallment"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				MonthlyInstallment = i;
			}
		}
		if (FCode.equalsIgnoreCase("FinanceEndMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FinanceEndMonth = FValue.trim();
			}
			else
				FinanceEndMonth = null;
		}
		if (FCode.equalsIgnoreCase("FPAI"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				FPAI = d;
			}
		}
		if (FCode.equalsIgnoreCase("CBPaidMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CBPaidMonth = FValue.trim();
			}
			else
				CBPaidMonth = null;
		}
		if (FCode.equalsIgnoreCase("CBInstallmentMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				CBInstallmentMonth = i;
			}
		}
		if (FCode.equalsIgnoreCase("ChallengeBonusAmount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				ChallengeBonusAmount = d;
			}
		}
		if (FCode.equalsIgnoreCase("AchieveRewardRate"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				AchieveRewardRate = d;
			}
		}
		if (FCode.equalsIgnoreCase("AchieveRewardAmount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				AchieveRewardAmount = d;
			}
		}
		if (FCode.equalsIgnoreCase("MegaFixedBonusReq"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MegaFixedBonusReq = d;
			}
		}
		if (FCode.equalsIgnoreCase("MegaFixedBonus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MegaFixedBonus = d;
			}
		}
		if (FCode.equalsIgnoreCase("MegaExtraBonusReq"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MegaExtraBonusReq = d;
			}
		}
		if (FCode.equalsIgnoreCase("MegaExtraBonusRate"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MegaExtraBonusRate = d;
			}
		}
		if (FCode.equalsIgnoreCase("MegaAwardReq"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MegaAwardReq = d;
			}
		}
		if (FCode.equalsIgnoreCase("MegaAward"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MegaAward = d;
			}
		}
		if (FCode.equalsIgnoreCase("ApprovalDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ApprovalDate = fDate.getDate( FValue );
			}
			else
				ApprovalDate = null;
		}
		if (FCode.equalsIgnoreCase("ApprovalTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ApprovalTime = FValue.trim();
			}
			else
				ApprovalTime = null;
		}
		if (FCode.equalsIgnoreCase("ApprovalOperator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ApprovalOperator = FValue.trim();
			}
			else
				ApprovalOperator = null;
		}
		if (FCode.equalsIgnoreCase("ApprovalReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ApprovalReason = FValue.trim();
			}
			else
				ApprovalReason = null;
		}
		if (FCode.equalsIgnoreCase("ApprovalFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ApprovalFlag = FValue.trim();
			}
			else
				ApprovalFlag = null;
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator = FValue.trim();
			}
			else
				Operator = null;
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MakeDate = fDate.getDate( FValue );
			}
			else
				MakeDate = null;
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MakeTime = FValue.trim();
			}
			else
				MakeTime = null;
		}
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ModifyDate = fDate.getDate( FValue );
			}
			else
				ModifyDate = null;
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyTime = FValue.trim();
			}
			else
				ModifyTime = null;
		}
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MakeDate1 = fDate.getDate( FValue );
			}
			else
				MakeDate1 = null;
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MakeTime1 = FValue.trim();
			}
			else
				MakeTime1 = null;
		}
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator1 = FValue.trim();
			}
			else
				Operator1 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAAgentFPUnApprovalBSchema other = (LAAgentFPUnApprovalBSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& PlanType.equals(other.getPlanType())
			&& FinancePackage.equals(other.getFinancePackage())
			&& FinanceStartMonth.equals(other.getFinanceStartMonth())
			&& MonthlyInstallment == other.getMonthlyInstallment()
			&& FinanceEndMonth.equals(other.getFinanceEndMonth())
			&& FPAI == other.getFPAI()
			&& CBPaidMonth.equals(other.getCBPaidMonth())
			&& CBInstallmentMonth == other.getCBInstallmentMonth()
			&& ChallengeBonusAmount == other.getChallengeBonusAmount()
			&& AchieveRewardRate == other.getAchieveRewardRate()
			&& AchieveRewardAmount == other.getAchieveRewardAmount()
			&& MegaFixedBonusReq == other.getMegaFixedBonusReq()
			&& MegaFixedBonus == other.getMegaFixedBonus()
			&& MegaExtraBonusReq == other.getMegaExtraBonusReq()
			&& MegaExtraBonusRate == other.getMegaExtraBonusRate()
			&& MegaAwardReq == other.getMegaAwardReq()
			&& MegaAward == other.getMegaAward()
			&& fDate.getString(ApprovalDate).equals(other.getApprovalDate())
			&& ApprovalTime.equals(other.getApprovalTime())
			&& ApprovalOperator.equals(other.getApprovalOperator())
			&& ApprovalReason.equals(other.getApprovalReason())
			&& ApprovalFlag.equals(other.getApprovalFlag())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1())
			&& Operator1.equals(other.getOperator1());
	}

	/**
	* 取得Schema拥有字段的数量
       * @return: int
	**/
	public int getFieldCount()
	{
 		return FIELDNUM;
	}

	/**
	* 取得Schema中指定字段名所对应的索引值
	* 如果没有对应的字段，返回-1
       * @param: strFieldName String
       * @return: int
	**/
	public int getFieldIndex(String strFieldName)
	{
		if( strFieldName.equals("AgentCode") ) {
			return 0;
		}
		if( strFieldName.equals("PlanType") ) {
			return 1;
		}
		if( strFieldName.equals("FinancePackage") ) {
			return 2;
		}
		if( strFieldName.equals("FinanceStartMonth") ) {
			return 3;
		}
		if( strFieldName.equals("MonthlyInstallment") ) {
			return 4;
		}
		if( strFieldName.equals("FinanceEndMonth") ) {
			return 5;
		}
		if( strFieldName.equals("FPAI") ) {
			return 6;
		}
		if( strFieldName.equals("CBPaidMonth") ) {
			return 7;
		}
		if( strFieldName.equals("CBInstallmentMonth") ) {
			return 8;
		}
		if( strFieldName.equals("ChallengeBonusAmount") ) {
			return 9;
		}
		if( strFieldName.equals("AchieveRewardRate") ) {
			return 10;
		}
		if( strFieldName.equals("AchieveRewardAmount") ) {
			return 11;
		}
		if( strFieldName.equals("MegaFixedBonusReq") ) {
			return 12;
		}
		if( strFieldName.equals("MegaFixedBonus") ) {
			return 13;
		}
		if( strFieldName.equals("MegaExtraBonusReq") ) {
			return 14;
		}
		if( strFieldName.equals("MegaExtraBonusRate") ) {
			return 15;
		}
		if( strFieldName.equals("MegaAwardReq") ) {
			return 16;
		}
		if( strFieldName.equals("MegaAward") ) {
			return 17;
		}
		if( strFieldName.equals("ApprovalDate") ) {
			return 18;
		}
		if( strFieldName.equals("ApprovalTime") ) {
			return 19;
		}
		if( strFieldName.equals("ApprovalOperator") ) {
			return 20;
		}
		if( strFieldName.equals("ApprovalReason") ) {
			return 21;
		}
		if( strFieldName.equals("ApprovalFlag") ) {
			return 22;
		}
		if( strFieldName.equals("Operator") ) {
			return 23;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 24;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 25;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 26;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 27;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 28;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 29;
		}
		if( strFieldName.equals("Operator1") ) {
			return 30;
		}
		return -1;
	}

	/**
	* 取得Schema中指定索引值所对应的字段名
	* 如果没有对应的字段，返回""
       * @param: nFieldIndex int
       * @return: String
	**/
	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch(nFieldIndex) {
			case 0:
				strFieldName = "AgentCode";
				break;
			case 1:
				strFieldName = "PlanType";
				break;
			case 2:
				strFieldName = "FinancePackage";
				break;
			case 3:
				strFieldName = "FinanceStartMonth";
				break;
			case 4:
				strFieldName = "MonthlyInstallment";
				break;
			case 5:
				strFieldName = "FinanceEndMonth";
				break;
			case 6:
				strFieldName = "FPAI";
				break;
			case 7:
				strFieldName = "CBPaidMonth";
				break;
			case 8:
				strFieldName = "CBInstallmentMonth";
				break;
			case 9:
				strFieldName = "ChallengeBonusAmount";
				break;
			case 10:
				strFieldName = "AchieveRewardRate";
				break;
			case 11:
				strFieldName = "AchieveRewardAmount";
				break;
			case 12:
				strFieldName = "MegaFixedBonusReq";
				break;
			case 13:
				strFieldName = "MegaFixedBonus";
				break;
			case 14:
				strFieldName = "MegaExtraBonusReq";
				break;
			case 15:
				strFieldName = "MegaExtraBonusRate";
				break;
			case 16:
				strFieldName = "MegaAwardReq";
				break;
			case 17:
				strFieldName = "MegaAward";
				break;
			case 18:
				strFieldName = "ApprovalDate";
				break;
			case 19:
				strFieldName = "ApprovalTime";
				break;
			case 20:
				strFieldName = "ApprovalOperator";
				break;
			case 21:
				strFieldName = "ApprovalReason";
				break;
			case 22:
				strFieldName = "ApprovalFlag";
				break;
			case 23:
				strFieldName = "Operator";
				break;
			case 24:
				strFieldName = "MakeDate";
				break;
			case 25:
				strFieldName = "MakeTime";
				break;
			case 26:
				strFieldName = "ModifyDate";
				break;
			case 27:
				strFieldName = "ModifyTime";
				break;
			case 28:
				strFieldName = "MakeDate1";
				break;
			case 29:
				strFieldName = "MakeTime1";
				break;
			case 30:
				strFieldName = "Operator1";
				break;
			default:
				strFieldName = "";
		};
		return strFieldName;
	}

	/**
	* 取得Schema中指定字段名所对应的字段类型
	* 如果没有对应的字段，返回Schema.TYPE_NOFOUND
       * @param: strFieldName String
       * @return: int
	**/
	public int getFieldType(String strFieldName)
	{
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PlanType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FinancePackage") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FinanceStartMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MonthlyInstallment") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("FinanceEndMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FPAI") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("CBPaidMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CBInstallmentMonth") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("ChallengeBonusAmount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("AchieveRewardRate") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("AchieveRewardAmount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("MegaFixedBonusReq") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("MegaFixedBonus") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("MegaExtraBonusReq") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("MegaExtraBonusRate") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("MegaAwardReq") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("MegaAward") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("ApprovalDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ApprovalTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ApprovalOperator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ApprovalReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ApprovalFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator1") ) {
			return Schema.TYPE_STRING;
		}
		return Schema.TYPE_NOFOUND;
	}

	/**
	* 取得Schema中指定索引值所对应的字段类型
	* 如果没有对应的字段，返回Schema.TYPE_NOFOUND
       * @param: nFieldIndex int
       * @return: int
	**/
	public int getFieldType(int nFieldIndex)
	{
		int nFieldType = Schema.TYPE_NOFOUND;
		switch(nFieldIndex) {
			case 0:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 1:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 2:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 3:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 4:
				nFieldType = Schema.TYPE_INT;
				break;
			case 5:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 6:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 7:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 8:
				nFieldType = Schema.TYPE_INT;
				break;
			case 9:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 10:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 11:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 12:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 13:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 14:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 15:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 16:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 17:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 18:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 20:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 21:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 22:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 23:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 24:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 25:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 26:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 27:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 28:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 29:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 30:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
