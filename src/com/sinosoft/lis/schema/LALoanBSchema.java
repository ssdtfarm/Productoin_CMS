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
import com.sinosoft.lis.db.LALoanBDB;

/*
 * <p>ClassName: LALoanBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LALoanBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LALoanBSchema.class);
	// @Field
	/** Id */
	private String ID;
	/** Leaderliabilityagentdivisioncode */
	private String LeaderLiabilityAgentDivisionCode;
	/** Leaderliabilityloanagentcode */
	private String LeaderLiabilityLoanAgentCode;
	/** Leaderliabilityloanagentname */
	private String LeaderLiabilityLoanAgentName;
	/** Leaderliabilityloanagenttitle */
	private String LeaderLiabilityLoanAgentTitle;
	/** Leaderliabilityloanagentcontractstatus */
	private String LeaderLiabilityLoanAgentContractStatus;
	/** Agentdivisioncode */
	private String AgentDivisionCode;
	/** Agentcode */
	private String AgentCode;
	/** Agentname */
	private String AgentName;
	/** Agenttitle */
	private String AgentTitle;
	/** Agentcontractstatus */
	private String AgentContractStatus;
	/** Loantype */
	private String LoanType;
	/** Loanstatus */
	private String LoanStatus;
	/** Loanamount */
	private String LoanAmount;
	/** Interestrate */
	private double InterestRate;
	/** Installment */
	private String Installment;
	/** Monthlyrepaymentamount */
	private double MonthlyRepaymentAmount;
	/** Loanfrom */
	private String LoanFrom;
	/** Loanto */
	private String LoanTo;
	/** Withheldreason */
	private String WithheldReason;
	/** Operator */
	private String Operator;
	/** Deleteflag */
	private String DeleteFlag;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;

	public static final int FIELDNUM = 26;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LALoanBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "ID";

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
		LALoanBSchema cloned = (LALoanBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getID()
	{
		return ID;
	}
	public void setID(String aID)
	{
		if(aID!=null && aID.length()>20)
			throw new IllegalArgumentException("IdID值"+aID+"的长度"+aID.length()+"大于最大值20");
		ID = aID;
	}
	public String getLeaderLiabilityAgentDivisionCode()
	{
		return LeaderLiabilityAgentDivisionCode;
	}
	public void setLeaderLiabilityAgentDivisionCode(String aLeaderLiabilityAgentDivisionCode)
	{
		if(aLeaderLiabilityAgentDivisionCode!=null && aLeaderLiabilityAgentDivisionCode.length()>200)
			throw new IllegalArgumentException("LeaderliabilityagentdivisioncodeLeaderLiabilityAgentDivisionCode值"+aLeaderLiabilityAgentDivisionCode+"的长度"+aLeaderLiabilityAgentDivisionCode.length()+"大于最大值200");
		LeaderLiabilityAgentDivisionCode = aLeaderLiabilityAgentDivisionCode;
	}
	public String getLeaderLiabilityLoanAgentCode()
	{
		return LeaderLiabilityLoanAgentCode;
	}
	public void setLeaderLiabilityLoanAgentCode(String aLeaderLiabilityLoanAgentCode)
	{
		if(aLeaderLiabilityLoanAgentCode!=null && aLeaderLiabilityLoanAgentCode.length()>200)
			throw new IllegalArgumentException("LeaderliabilityloanagentcodeLeaderLiabilityLoanAgentCode值"+aLeaderLiabilityLoanAgentCode+"的长度"+aLeaderLiabilityLoanAgentCode.length()+"大于最大值200");
		LeaderLiabilityLoanAgentCode = aLeaderLiabilityLoanAgentCode;
	}
	public String getLeaderLiabilityLoanAgentName()
	{
		return LeaderLiabilityLoanAgentName;
	}
	public void setLeaderLiabilityLoanAgentName(String aLeaderLiabilityLoanAgentName)
	{
		if(aLeaderLiabilityLoanAgentName!=null && aLeaderLiabilityLoanAgentName.length()>200)
			throw new IllegalArgumentException("LeaderliabilityloanagentnameLeaderLiabilityLoanAgentName值"+aLeaderLiabilityLoanAgentName+"的长度"+aLeaderLiabilityLoanAgentName.length()+"大于最大值200");
		LeaderLiabilityLoanAgentName = aLeaderLiabilityLoanAgentName;
	}
	public String getLeaderLiabilityLoanAgentTitle()
	{
		return LeaderLiabilityLoanAgentTitle;
	}
	public void setLeaderLiabilityLoanAgentTitle(String aLeaderLiabilityLoanAgentTitle)
	{
		if(aLeaderLiabilityLoanAgentTitle!=null && aLeaderLiabilityLoanAgentTitle.length()>200)
			throw new IllegalArgumentException("LeaderliabilityloanagenttitleLeaderLiabilityLoanAgentTitle值"+aLeaderLiabilityLoanAgentTitle+"的长度"+aLeaderLiabilityLoanAgentTitle.length()+"大于最大值200");
		LeaderLiabilityLoanAgentTitle = aLeaderLiabilityLoanAgentTitle;
	}
	public String getLeaderLiabilityLoanAgentContractStatus()
	{
		return LeaderLiabilityLoanAgentContractStatus;
	}
	public void setLeaderLiabilityLoanAgentContractStatus(String aLeaderLiabilityLoanAgentContractStatus)
	{
		if(aLeaderLiabilityLoanAgentContractStatus!=null && aLeaderLiabilityLoanAgentContractStatus.length()>200)
			throw new IllegalArgumentException("LeaderliabilityloanagentcontractstatusLeaderLiabilityLoanAgentContractStatus值"+aLeaderLiabilityLoanAgentContractStatus+"的长度"+aLeaderLiabilityLoanAgentContractStatus.length()+"大于最大值200");
		LeaderLiabilityLoanAgentContractStatus = aLeaderLiabilityLoanAgentContractStatus;
	}
	public String getAgentDivisionCode()
	{
		return AgentDivisionCode;
	}
	public void setAgentDivisionCode(String aAgentDivisionCode)
	{
		if(aAgentDivisionCode!=null && aAgentDivisionCode.length()>200)
			throw new IllegalArgumentException("AgentdivisioncodeAgentDivisionCode值"+aAgentDivisionCode+"的长度"+aAgentDivisionCode.length()+"大于最大值200");
		AgentDivisionCode = aAgentDivisionCode;
	}
	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>200)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值200");
		AgentCode = aAgentCode;
	}
	public String getAgentName()
	{
		return AgentName;
	}
	public void setAgentName(String aAgentName)
	{
		if(aAgentName!=null && aAgentName.length()>200)
			throw new IllegalArgumentException("AgentnameAgentName值"+aAgentName+"的长度"+aAgentName.length()+"大于最大值200");
		AgentName = aAgentName;
	}
	public String getAgentTitle()
	{
		return AgentTitle;
	}
	public void setAgentTitle(String aAgentTitle)
	{
		if(aAgentTitle!=null && aAgentTitle.length()>200)
			throw new IllegalArgumentException("AgenttitleAgentTitle值"+aAgentTitle+"的长度"+aAgentTitle.length()+"大于最大值200");
		AgentTitle = aAgentTitle;
	}
	public String getAgentContractStatus()
	{
		return AgentContractStatus;
	}
	public void setAgentContractStatus(String aAgentContractStatus)
	{
		if(aAgentContractStatus!=null && aAgentContractStatus.length()>200)
			throw new IllegalArgumentException("AgentcontractstatusAgentContractStatus值"+aAgentContractStatus+"的长度"+aAgentContractStatus.length()+"大于最大值200");
		AgentContractStatus = aAgentContractStatus;
	}
	public String getLoanType()
	{
		return LoanType;
	}
	public void setLoanType(String aLoanType)
	{
		if(aLoanType!=null && aLoanType.length()>200)
			throw new IllegalArgumentException("LoantypeLoanType值"+aLoanType+"的长度"+aLoanType.length()+"大于最大值200");
		LoanType = aLoanType;
	}
	public String getLoanStatus()
	{
		return LoanStatus;
	}
	public void setLoanStatus(String aLoanStatus)
	{
		if(aLoanStatus!=null && aLoanStatus.length()>200)
			throw new IllegalArgumentException("LoanstatusLoanStatus值"+aLoanStatus+"的长度"+aLoanStatus.length()+"大于最大值200");
		LoanStatus = aLoanStatus;
	}
	public String getLoanAmount()
	{
		return LoanAmount;
	}
	public void setLoanAmount(String aLoanAmount)
	{
		if(aLoanAmount!=null && aLoanAmount.length()>200)
			throw new IllegalArgumentException("LoanamountLoanAmount值"+aLoanAmount+"的长度"+aLoanAmount.length()+"大于最大值200");
		LoanAmount = aLoanAmount;
	}
	public double getInterestRate()
	{
		return InterestRate;
	}
	public void setInterestRate(double aInterestRate)
	{
		InterestRate = aInterestRate;
	}
	public void setInterestRate(String aInterestRate)
	{
		if (aInterestRate != null && !aInterestRate.equals(""))
		{
			Double tDouble = new Double(aInterestRate);
			double d = tDouble.doubleValue();
			InterestRate = d;
		}
	}

	public String getInstallment()
	{
		return Installment;
	}
	public void setInstallment(String aInstallment)
	{
		if(aInstallment!=null && aInstallment.length()>200)
			throw new IllegalArgumentException("InstallmentInstallment值"+aInstallment+"的长度"+aInstallment.length()+"大于最大值200");
		Installment = aInstallment;
	}
	public double getMonthlyRepaymentAmount()
	{
		return MonthlyRepaymentAmount;
	}
	public void setMonthlyRepaymentAmount(double aMonthlyRepaymentAmount)
	{
		MonthlyRepaymentAmount = aMonthlyRepaymentAmount;
	}
	public void setMonthlyRepaymentAmount(String aMonthlyRepaymentAmount)
	{
		if (aMonthlyRepaymentAmount != null && !aMonthlyRepaymentAmount.equals(""))
		{
			Double tDouble = new Double(aMonthlyRepaymentAmount);
			double d = tDouble.doubleValue();
			MonthlyRepaymentAmount = d;
		}
	}

	public String getLoanFrom()
	{
		return LoanFrom;
	}
	public void setLoanFrom(String aLoanFrom)
	{
		if(aLoanFrom!=null && aLoanFrom.length()>200)
			throw new IllegalArgumentException("LoanfromLoanFrom值"+aLoanFrom+"的长度"+aLoanFrom.length()+"大于最大值200");
		LoanFrom = aLoanFrom;
	}
	public String getLoanTo()
	{
		return LoanTo;
	}
	public void setLoanTo(String aLoanTo)
	{
		if(aLoanTo!=null && aLoanTo.length()>200)
			throw new IllegalArgumentException("LoantoLoanTo值"+aLoanTo+"的长度"+aLoanTo.length()+"大于最大值200");
		LoanTo = aLoanTo;
	}
	public String getWithheldReason()
	{
		return WithheldReason;
	}
	public void setWithheldReason(String aWithheldReason)
	{
		if(aWithheldReason!=null && aWithheldReason.length()>500)
			throw new IllegalArgumentException("WithheldreasonWithheldReason值"+aWithheldReason+"的长度"+aWithheldReason.length()+"大于最大值500");
		WithheldReason = aWithheldReason;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>200)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值200");
		Operator = aOperator;
	}
	public String getDeleteFlag()
	{
		return DeleteFlag;
	}
	public void setDeleteFlag(String aDeleteFlag)
	{
		if(aDeleteFlag!=null && aDeleteFlag.length()>200)
			throw new IllegalArgumentException("DeleteflagDeleteFlag值"+aDeleteFlag+"的长度"+aDeleteFlag.length()+"大于最大值200");
		DeleteFlag = aDeleteFlag;
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

	/**
	* 使用另外一个 LALoanBSchema 对象给 Schema 赋值
	* @param: aLALoanBSchema LALoanBSchema
	**/
	public void setSchema(LALoanBSchema aLALoanBSchema)
	{
		this.ID = aLALoanBSchema.getID();
		this.LeaderLiabilityAgentDivisionCode = aLALoanBSchema.getLeaderLiabilityAgentDivisionCode();
		this.LeaderLiabilityLoanAgentCode = aLALoanBSchema.getLeaderLiabilityLoanAgentCode();
		this.LeaderLiabilityLoanAgentName = aLALoanBSchema.getLeaderLiabilityLoanAgentName();
		this.LeaderLiabilityLoanAgentTitle = aLALoanBSchema.getLeaderLiabilityLoanAgentTitle();
		this.LeaderLiabilityLoanAgentContractStatus = aLALoanBSchema.getLeaderLiabilityLoanAgentContractStatus();
		this.AgentDivisionCode = aLALoanBSchema.getAgentDivisionCode();
		this.AgentCode = aLALoanBSchema.getAgentCode();
		this.AgentName = aLALoanBSchema.getAgentName();
		this.AgentTitle = aLALoanBSchema.getAgentTitle();
		this.AgentContractStatus = aLALoanBSchema.getAgentContractStatus();
		this.LoanType = aLALoanBSchema.getLoanType();
		this.LoanStatus = aLALoanBSchema.getLoanStatus();
		this.LoanAmount = aLALoanBSchema.getLoanAmount();
		this.InterestRate = aLALoanBSchema.getInterestRate();
		this.Installment = aLALoanBSchema.getInstallment();
		this.MonthlyRepaymentAmount = aLALoanBSchema.getMonthlyRepaymentAmount();
		this.LoanFrom = aLALoanBSchema.getLoanFrom();
		this.LoanTo = aLALoanBSchema.getLoanTo();
		this.WithheldReason = aLALoanBSchema.getWithheldReason();
		this.Operator = aLALoanBSchema.getOperator();
		this.DeleteFlag = aLALoanBSchema.getDeleteFlag();
		this.MakeDate = fDate.getDate( aLALoanBSchema.getMakeDate());
		this.MakeTime = aLALoanBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLALoanBSchema.getModifyDate());
		this.ModifyTime = aLALoanBSchema.getModifyTime();
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
			if( rs.getString("ID") == null )
				this.ID = null;
			else
				this.ID = rs.getString("ID").trim();

			if( rs.getString("LeaderLiabilityAgentDivisionCode") == null )
				this.LeaderLiabilityAgentDivisionCode = null;
			else
				this.LeaderLiabilityAgentDivisionCode = rs.getString("LeaderLiabilityAgentDivisionCode").trim();

			if( rs.getString("LeaderLiabilityLoanAgentCode") == null )
				this.LeaderLiabilityLoanAgentCode = null;
			else
				this.LeaderLiabilityLoanAgentCode = rs.getString("LeaderLiabilityLoanAgentCode").trim();

			if( rs.getString("LeaderLiabilityLoanAgentName") == null )
				this.LeaderLiabilityLoanAgentName = null;
			else
				this.LeaderLiabilityLoanAgentName = rs.getString("LeaderLiabilityLoanAgentName").trim();

			if( rs.getString("LeaderLiabilityLoanAgentTitle") == null )
				this.LeaderLiabilityLoanAgentTitle = null;
			else
				this.LeaderLiabilityLoanAgentTitle = rs.getString("LeaderLiabilityLoanAgentTitle").trim();

			if( rs.getString("LeaderLiabilityLoanAgentContractStatus") == null )
				this.LeaderLiabilityLoanAgentContractStatus = null;
			else
				this.LeaderLiabilityLoanAgentContractStatus = rs.getString("LeaderLiabilityLoanAgentContractStatus").trim();

			if( rs.getString("AgentDivisionCode") == null )
				this.AgentDivisionCode = null;
			else
				this.AgentDivisionCode = rs.getString("AgentDivisionCode").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("AgentName") == null )
				this.AgentName = null;
			else
				this.AgentName = rs.getString("AgentName").trim();

			if( rs.getString("AgentTitle") == null )
				this.AgentTitle = null;
			else
				this.AgentTitle = rs.getString("AgentTitle").trim();

			if( rs.getString("AgentContractStatus") == null )
				this.AgentContractStatus = null;
			else
				this.AgentContractStatus = rs.getString("AgentContractStatus").trim();

			if( rs.getString("LoanType") == null )
				this.LoanType = null;
			else
				this.LoanType = rs.getString("LoanType").trim();

			if( rs.getString("LoanStatus") == null )
				this.LoanStatus = null;
			else
				this.LoanStatus = rs.getString("LoanStatus").trim();

			if( rs.getString("LoanAmount") == null )
				this.LoanAmount = null;
			else
				this.LoanAmount = rs.getString("LoanAmount").trim();

			this.InterestRate = rs.getDouble("InterestRate");
			if( rs.getString("Installment") == null )
				this.Installment = null;
			else
				this.Installment = rs.getString("Installment").trim();

			this.MonthlyRepaymentAmount = rs.getDouble("MonthlyRepaymentAmount");
			if( rs.getString("LoanFrom") == null )
				this.LoanFrom = null;
			else
				this.LoanFrom = rs.getString("LoanFrom").trim();

			if( rs.getString("LoanTo") == null )
				this.LoanTo = null;
			else
				this.LoanTo = rs.getString("LoanTo").trim();

			if( rs.getString("WithheldReason") == null )
				this.WithheldReason = null;
			else
				this.WithheldReason = rs.getString("WithheldReason").trim();

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			if( rs.getString("DeleteFlag") == null )
				this.DeleteFlag = null;
			else
				this.DeleteFlag = rs.getString("DeleteFlag").trim();

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

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LALoanB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LALoanBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LALoanBSchema getSchema()
	{
		LALoanBSchema aLALoanBSchema = new LALoanBSchema();
		aLALoanBSchema.setSchema(this);
		return aLALoanBSchema;
	}

	public LALoanBDB getDB()
	{
		LALoanBDB aDBOper = new LALoanBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLALoanB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LeaderLiabilityAgentDivisionCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LeaderLiabilityLoanAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LeaderLiabilityLoanAgentName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LeaderLiabilityLoanAgentTitle)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LeaderLiabilityLoanAgentContractStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentDivisionCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentTitle)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentContractStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LoanType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LoanStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LoanAmount)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(InterestRate));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Installment)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MonthlyRepaymentAmount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LoanFrom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LoanTo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WithheldReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DeleteFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLALoanB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			LeaderLiabilityAgentDivisionCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			LeaderLiabilityLoanAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			LeaderLiabilityLoanAgentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			LeaderLiabilityLoanAgentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			LeaderLiabilityLoanAgentContractStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AgentDivisionCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			AgentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			AgentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			AgentContractStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			LoanType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			LoanStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			LoanAmount = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			InterestRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,15,SysConst.PACKAGESPILTER))).doubleValue();
			Installment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			MonthlyRepaymentAmount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,17,SysConst.PACKAGESPILTER))).doubleValue();
			LoanFrom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			LoanTo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			WithheldReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			DeleteFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LALoanBSchema";
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
		if (FCode.equalsIgnoreCase("ID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ID));
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityAgentDivisionCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LeaderLiabilityAgentDivisionCode));
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LeaderLiabilityLoanAgentCode));
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LeaderLiabilityLoanAgentName));
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentTitle"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LeaderLiabilityLoanAgentTitle));
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentContractStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LeaderLiabilityLoanAgentContractStatus));
		}
		if (FCode.equalsIgnoreCase("AgentDivisionCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentDivisionCode));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("AgentName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentName));
		}
		if (FCode.equalsIgnoreCase("AgentTitle"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentTitle));
		}
		if (FCode.equalsIgnoreCase("AgentContractStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentContractStatus));
		}
		if (FCode.equalsIgnoreCase("LoanType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LoanType));
		}
		if (FCode.equalsIgnoreCase("LoanStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LoanStatus));
		}
		if (FCode.equalsIgnoreCase("LoanAmount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LoanAmount));
		}
		if (FCode.equalsIgnoreCase("InterestRate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InterestRate));
		}
		if (FCode.equalsIgnoreCase("Installment"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Installment));
		}
		if (FCode.equalsIgnoreCase("MonthlyRepaymentAmount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MonthlyRepaymentAmount));
		}
		if (FCode.equalsIgnoreCase("LoanFrom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LoanFrom));
		}
		if (FCode.equalsIgnoreCase("LoanTo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LoanTo));
		}
		if (FCode.equalsIgnoreCase("WithheldReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WithheldReason));
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		}
		if (FCode.equalsIgnoreCase("DeleteFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DeleteFlag));
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
				strFieldValue = StrTool.GBKToUnicode(ID);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(LeaderLiabilityAgentDivisionCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(LeaderLiabilityLoanAgentCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(LeaderLiabilityLoanAgentName);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(LeaderLiabilityLoanAgentTitle);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(LeaderLiabilityLoanAgentContractStatus);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentDivisionCode);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(AgentName);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(AgentTitle);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(AgentContractStatus);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(LoanType);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(LoanStatus);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(LoanAmount);
				break;
			case 14:
				strFieldValue = String.valueOf(InterestRate);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Installment);
				break;
			case 16:
				strFieldValue = String.valueOf(MonthlyRepaymentAmount);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(LoanFrom);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(LoanTo);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(WithheldReason);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(DeleteFlag);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
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

		if (FCode.equalsIgnoreCase("ID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ID = FValue.trim();
			}
			else
				ID = null;
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityAgentDivisionCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LeaderLiabilityAgentDivisionCode = FValue.trim();
			}
			else
				LeaderLiabilityAgentDivisionCode = null;
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LeaderLiabilityLoanAgentCode = FValue.trim();
			}
			else
				LeaderLiabilityLoanAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LeaderLiabilityLoanAgentName = FValue.trim();
			}
			else
				LeaderLiabilityLoanAgentName = null;
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentTitle"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LeaderLiabilityLoanAgentTitle = FValue.trim();
			}
			else
				LeaderLiabilityLoanAgentTitle = null;
		}
		if (FCode.equalsIgnoreCase("LeaderLiabilityLoanAgentContractStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LeaderLiabilityLoanAgentContractStatus = FValue.trim();
			}
			else
				LeaderLiabilityLoanAgentContractStatus = null;
		}
		if (FCode.equalsIgnoreCase("AgentDivisionCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentDivisionCode = FValue.trim();
			}
			else
				AgentDivisionCode = null;
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("AgentName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentName = FValue.trim();
			}
			else
				AgentName = null;
		}
		if (FCode.equalsIgnoreCase("AgentTitle"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentTitle = FValue.trim();
			}
			else
				AgentTitle = null;
		}
		if (FCode.equalsIgnoreCase("AgentContractStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentContractStatus = FValue.trim();
			}
			else
				AgentContractStatus = null;
		}
		if (FCode.equalsIgnoreCase("LoanType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LoanType = FValue.trim();
			}
			else
				LoanType = null;
		}
		if (FCode.equalsIgnoreCase("LoanStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LoanStatus = FValue.trim();
			}
			else
				LoanStatus = null;
		}
		if (FCode.equalsIgnoreCase("LoanAmount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LoanAmount = FValue.trim();
			}
			else
				LoanAmount = null;
		}
		if (FCode.equalsIgnoreCase("InterestRate"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				InterestRate = d;
			}
		}
		if (FCode.equalsIgnoreCase("Installment"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Installment = FValue.trim();
			}
			else
				Installment = null;
		}
		if (FCode.equalsIgnoreCase("MonthlyRepaymentAmount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MonthlyRepaymentAmount = d;
			}
		}
		if (FCode.equalsIgnoreCase("LoanFrom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LoanFrom = FValue.trim();
			}
			else
				LoanFrom = null;
		}
		if (FCode.equalsIgnoreCase("LoanTo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LoanTo = FValue.trim();
			}
			else
				LoanTo = null;
		}
		if (FCode.equalsIgnoreCase("WithheldReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WithheldReason = FValue.trim();
			}
			else
				WithheldReason = null;
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
		if (FCode.equalsIgnoreCase("DeleteFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DeleteFlag = FValue.trim();
			}
			else
				DeleteFlag = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LALoanBSchema other = (LALoanBSchema)otherObject;
		return
			ID.equals(other.getID())
			&& LeaderLiabilityAgentDivisionCode.equals(other.getLeaderLiabilityAgentDivisionCode())
			&& LeaderLiabilityLoanAgentCode.equals(other.getLeaderLiabilityLoanAgentCode())
			&& LeaderLiabilityLoanAgentName.equals(other.getLeaderLiabilityLoanAgentName())
			&& LeaderLiabilityLoanAgentTitle.equals(other.getLeaderLiabilityLoanAgentTitle())
			&& LeaderLiabilityLoanAgentContractStatus.equals(other.getLeaderLiabilityLoanAgentContractStatus())
			&& AgentDivisionCode.equals(other.getAgentDivisionCode())
			&& AgentCode.equals(other.getAgentCode())
			&& AgentName.equals(other.getAgentName())
			&& AgentTitle.equals(other.getAgentTitle())
			&& AgentContractStatus.equals(other.getAgentContractStatus())
			&& LoanType.equals(other.getLoanType())
			&& LoanStatus.equals(other.getLoanStatus())
			&& LoanAmount.equals(other.getLoanAmount())
			&& InterestRate == other.getInterestRate()
			&& Installment.equals(other.getInstallment())
			&& MonthlyRepaymentAmount == other.getMonthlyRepaymentAmount()
			&& LoanFrom.equals(other.getLoanFrom())
			&& LoanTo.equals(other.getLoanTo())
			&& WithheldReason.equals(other.getWithheldReason())
			&& Operator.equals(other.getOperator())
			&& DeleteFlag.equals(other.getDeleteFlag())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime());
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
		if( strFieldName.equals("ID") ) {
			return 0;
		}
		if( strFieldName.equals("LeaderLiabilityAgentDivisionCode") ) {
			return 1;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentCode") ) {
			return 2;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentName") ) {
			return 3;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentTitle") ) {
			return 4;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentContractStatus") ) {
			return 5;
		}
		if( strFieldName.equals("AgentDivisionCode") ) {
			return 6;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 7;
		}
		if( strFieldName.equals("AgentName") ) {
			return 8;
		}
		if( strFieldName.equals("AgentTitle") ) {
			return 9;
		}
		if( strFieldName.equals("AgentContractStatus") ) {
			return 10;
		}
		if( strFieldName.equals("LoanType") ) {
			return 11;
		}
		if( strFieldName.equals("LoanStatus") ) {
			return 12;
		}
		if( strFieldName.equals("LoanAmount") ) {
			return 13;
		}
		if( strFieldName.equals("InterestRate") ) {
			return 14;
		}
		if( strFieldName.equals("Installment") ) {
			return 15;
		}
		if( strFieldName.equals("MonthlyRepaymentAmount") ) {
			return 16;
		}
		if( strFieldName.equals("LoanFrom") ) {
			return 17;
		}
		if( strFieldName.equals("LoanTo") ) {
			return 18;
		}
		if( strFieldName.equals("WithheldReason") ) {
			return 19;
		}
		if( strFieldName.equals("Operator") ) {
			return 20;
		}
		if( strFieldName.equals("DeleteFlag") ) {
			return 21;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 22;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 23;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 24;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 25;
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
				strFieldName = "ID";
				break;
			case 1:
				strFieldName = "LeaderLiabilityAgentDivisionCode";
				break;
			case 2:
				strFieldName = "LeaderLiabilityLoanAgentCode";
				break;
			case 3:
				strFieldName = "LeaderLiabilityLoanAgentName";
				break;
			case 4:
				strFieldName = "LeaderLiabilityLoanAgentTitle";
				break;
			case 5:
				strFieldName = "LeaderLiabilityLoanAgentContractStatus";
				break;
			case 6:
				strFieldName = "AgentDivisionCode";
				break;
			case 7:
				strFieldName = "AgentCode";
				break;
			case 8:
				strFieldName = "AgentName";
				break;
			case 9:
				strFieldName = "AgentTitle";
				break;
			case 10:
				strFieldName = "AgentContractStatus";
				break;
			case 11:
				strFieldName = "LoanType";
				break;
			case 12:
				strFieldName = "LoanStatus";
				break;
			case 13:
				strFieldName = "LoanAmount";
				break;
			case 14:
				strFieldName = "InterestRate";
				break;
			case 15:
				strFieldName = "Installment";
				break;
			case 16:
				strFieldName = "MonthlyRepaymentAmount";
				break;
			case 17:
				strFieldName = "LoanFrom";
				break;
			case 18:
				strFieldName = "LoanTo";
				break;
			case 19:
				strFieldName = "WithheldReason";
				break;
			case 20:
				strFieldName = "Operator";
				break;
			case 21:
				strFieldName = "DeleteFlag";
				break;
			case 22:
				strFieldName = "MakeDate";
				break;
			case 23:
				strFieldName = "MakeTime";
				break;
			case 24:
				strFieldName = "ModifyDate";
				break;
			case 25:
				strFieldName = "ModifyTime";
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
		if( strFieldName.equals("ID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LeaderLiabilityAgentDivisionCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentTitle") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LeaderLiabilityLoanAgentContractStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentDivisionCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentTitle") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentContractStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LoanType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LoanStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LoanAmount") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InterestRate") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Installment") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MonthlyRepaymentAmount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("LoanFrom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LoanTo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WithheldReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DeleteFlag") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 5:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 16:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DATE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
