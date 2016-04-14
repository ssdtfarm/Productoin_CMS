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
import com.sinosoft.lis.db.LAAgentFPDetailUnApprovalBDB;

/*
 * <p>ClassName: LAAgentFPDetailUnApprovalBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LAAgentFP_Setting
 */
public class LAAgentFPDetailUnApprovalBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentFPDetailUnApprovalBSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Yearmonth */
	private String YearMonth;
	/** Monthlyfinance */
	private double MonthlyFinance;
	/** Validationreq */
	private double ValidationReq;
	/** Welcomeincentive */
	private double WelcomeIncentive;
	/** Monthlyfinanceadvance */
	private double MonthlyFinanceAdvance;
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

	public static final int FIELDNUM = 19;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentFPDetailUnApprovalBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[5];
		pk[0] = "AgentCode";
		pk[1] = "YearMonth";
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
		LAAgentFPDetailUnApprovalBSchema cloned = (LAAgentFPDetailUnApprovalBSchema)super.clone();
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
	public String getYearMonth()
	{
		return YearMonth;
	}
	public void setYearMonth(String aYearMonth)
	{
		if(aYearMonth!=null && aYearMonth.length()>6)
			throw new IllegalArgumentException("YearmonthYearMonth值"+aYearMonth+"的长度"+aYearMonth.length()+"大于最大值6");
		YearMonth = aYearMonth;
	}
	public double getMonthlyFinance()
	{
		return MonthlyFinance;
	}
	public void setMonthlyFinance(double aMonthlyFinance)
	{
		MonthlyFinance = aMonthlyFinance;
	}
	public void setMonthlyFinance(String aMonthlyFinance)
	{
		if (aMonthlyFinance != null && !aMonthlyFinance.equals(""))
		{
			Double tDouble = new Double(aMonthlyFinance);
			double d = tDouble.doubleValue();
			MonthlyFinance = d;
		}
	}

	public double getValidationReq()
	{
		return ValidationReq;
	}
	public void setValidationReq(double aValidationReq)
	{
		ValidationReq = aValidationReq;
	}
	public void setValidationReq(String aValidationReq)
	{
		if (aValidationReq != null && !aValidationReq.equals(""))
		{
			Double tDouble = new Double(aValidationReq);
			double d = tDouble.doubleValue();
			ValidationReq = d;
		}
	}

	public double getWelcomeIncentive()
	{
		return WelcomeIncentive;
	}
	public void setWelcomeIncentive(double aWelcomeIncentive)
	{
		WelcomeIncentive = aWelcomeIncentive;
	}
	public void setWelcomeIncentive(String aWelcomeIncentive)
	{
		if (aWelcomeIncentive != null && !aWelcomeIncentive.equals(""))
		{
			Double tDouble = new Double(aWelcomeIncentive);
			double d = tDouble.doubleValue();
			WelcomeIncentive = d;
		}
	}

	public double getMonthlyFinanceAdvance()
	{
		return MonthlyFinanceAdvance;
	}
	public void setMonthlyFinanceAdvance(double aMonthlyFinanceAdvance)
	{
		MonthlyFinanceAdvance = aMonthlyFinanceAdvance;
	}
	public void setMonthlyFinanceAdvance(String aMonthlyFinanceAdvance)
	{
		if (aMonthlyFinanceAdvance != null && !aMonthlyFinanceAdvance.equals(""))
		{
			Double tDouble = new Double(aMonthlyFinanceAdvance);
			double d = tDouble.doubleValue();
			MonthlyFinanceAdvance = d;
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
	* 使用另外一个 LAAgentFPDetailUnApprovalBSchema 对象给 Schema 赋值
	* @param: aLAAgentFPDetailUnApprovalBSchema LAAgentFPDetailUnApprovalBSchema
	**/
	public void setSchema(LAAgentFPDetailUnApprovalBSchema aLAAgentFPDetailUnApprovalBSchema)
	{
		this.AgentCode = aLAAgentFPDetailUnApprovalBSchema.getAgentCode();
		this.YearMonth = aLAAgentFPDetailUnApprovalBSchema.getYearMonth();
		this.MonthlyFinance = aLAAgentFPDetailUnApprovalBSchema.getMonthlyFinance();
		this.ValidationReq = aLAAgentFPDetailUnApprovalBSchema.getValidationReq();
		this.WelcomeIncentive = aLAAgentFPDetailUnApprovalBSchema.getWelcomeIncentive();
		this.MonthlyFinanceAdvance = aLAAgentFPDetailUnApprovalBSchema.getMonthlyFinanceAdvance();
		this.ApprovalDate = fDate.getDate( aLAAgentFPDetailUnApprovalBSchema.getApprovalDate());
		this.ApprovalTime = aLAAgentFPDetailUnApprovalBSchema.getApprovalTime();
		this.ApprovalOperator = aLAAgentFPDetailUnApprovalBSchema.getApprovalOperator();
		this.ApprovalReason = aLAAgentFPDetailUnApprovalBSchema.getApprovalReason();
		this.ApprovalFlag = aLAAgentFPDetailUnApprovalBSchema.getApprovalFlag();
		this.Operator = aLAAgentFPDetailUnApprovalBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentFPDetailUnApprovalBSchema.getMakeDate());
		this.MakeTime = aLAAgentFPDetailUnApprovalBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentFPDetailUnApprovalBSchema.getModifyDate());
		this.ModifyTime = aLAAgentFPDetailUnApprovalBSchema.getModifyTime();
		this.MakeDate1 = fDate.getDate( aLAAgentFPDetailUnApprovalBSchema.getMakeDate1());
		this.MakeTime1 = aLAAgentFPDetailUnApprovalBSchema.getMakeTime1();
		this.Operator1 = aLAAgentFPDetailUnApprovalBSchema.getOperator1();
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

			if( rs.getString("YearMonth") == null )
				this.YearMonth = null;
			else
				this.YearMonth = rs.getString("YearMonth").trim();

			this.MonthlyFinance = rs.getDouble("MonthlyFinance");
			this.ValidationReq = rs.getDouble("ValidationReq");
			this.WelcomeIncentive = rs.getDouble("WelcomeIncentive");
			this.MonthlyFinanceAdvance = rs.getDouble("MonthlyFinanceAdvance");
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
			logger.debug("数据库中的LAAgentFPDetailUnApprovalB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentFPDetailUnApprovalBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentFPDetailUnApprovalBSchema getSchema()
	{
		LAAgentFPDetailUnApprovalBSchema aLAAgentFPDetailUnApprovalBSchema = new LAAgentFPDetailUnApprovalBSchema();
		aLAAgentFPDetailUnApprovalBSchema.setSchema(this);
		return aLAAgentFPDetailUnApprovalBSchema;
	}

	public LAAgentFPDetailUnApprovalBDB getDB()
	{
		LAAgentFPDetailUnApprovalBDB aDBOper = new LAAgentFPDetailUnApprovalBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentFPDetailUnApprovalB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(YearMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MonthlyFinance));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(ValidationReq));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(WelcomeIncentive));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MonthlyFinanceAdvance));strReturn.append(SysConst.PACKAGESPILTER);
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
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentFPDetailUnApprovalB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			YearMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			MonthlyFinance = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,3,SysConst.PACKAGESPILTER))).doubleValue();
			ValidationReq = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,4,SysConst.PACKAGESPILTER))).doubleValue();
			WelcomeIncentive = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,5,SysConst.PACKAGESPILTER))).doubleValue();
			MonthlyFinanceAdvance = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,6,SysConst.PACKAGESPILTER))).doubleValue();
			ApprovalDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			ApprovalTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			ApprovalOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			ApprovalReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ApprovalFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentFPDetailUnApprovalBSchema";
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
		if (FCode.equalsIgnoreCase("YearMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(YearMonth));
		}
		if (FCode.equalsIgnoreCase("MonthlyFinance"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MonthlyFinance));
		}
		if (FCode.equalsIgnoreCase("ValidationReq"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ValidationReq));
		}
		if (FCode.equalsIgnoreCase("WelcomeIncentive"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WelcomeIncentive));
		}
		if (FCode.equalsIgnoreCase("MonthlyFinanceAdvance"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MonthlyFinanceAdvance));
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
				strFieldValue = StrTool.GBKToUnicode(YearMonth);
				break;
			case 2:
				strFieldValue = String.valueOf(MonthlyFinance);
				break;
			case 3:
				strFieldValue = String.valueOf(ValidationReq);
				break;
			case 4:
				strFieldValue = String.valueOf(WelcomeIncentive);
				break;
			case 5:
				strFieldValue = String.valueOf(MonthlyFinanceAdvance);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getApprovalDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(ApprovalTime);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(ApprovalOperator);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(ApprovalReason);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(ApprovalFlag);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
				break;
			case 18:
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
		if (FCode.equalsIgnoreCase("YearMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				YearMonth = FValue.trim();
			}
			else
				YearMonth = null;
		}
		if (FCode.equalsIgnoreCase("MonthlyFinance"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MonthlyFinance = d;
			}
		}
		if (FCode.equalsIgnoreCase("ValidationReq"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				ValidationReq = d;
			}
		}
		if (FCode.equalsIgnoreCase("WelcomeIncentive"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				WelcomeIncentive = d;
			}
		}
		if (FCode.equalsIgnoreCase("MonthlyFinanceAdvance"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				MonthlyFinanceAdvance = d;
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
		LAAgentFPDetailUnApprovalBSchema other = (LAAgentFPDetailUnApprovalBSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& YearMonth.equals(other.getYearMonth())
			&& MonthlyFinance == other.getMonthlyFinance()
			&& ValidationReq == other.getValidationReq()
			&& WelcomeIncentive == other.getWelcomeIncentive()
			&& MonthlyFinanceAdvance == other.getMonthlyFinanceAdvance()
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
		if( strFieldName.equals("YearMonth") ) {
			return 1;
		}
		if( strFieldName.equals("MonthlyFinance") ) {
			return 2;
		}
		if( strFieldName.equals("ValidationReq") ) {
			return 3;
		}
		if( strFieldName.equals("WelcomeIncentive") ) {
			return 4;
		}
		if( strFieldName.equals("MonthlyFinanceAdvance") ) {
			return 5;
		}
		if( strFieldName.equals("ApprovalDate") ) {
			return 6;
		}
		if( strFieldName.equals("ApprovalTime") ) {
			return 7;
		}
		if( strFieldName.equals("ApprovalOperator") ) {
			return 8;
		}
		if( strFieldName.equals("ApprovalReason") ) {
			return 9;
		}
		if( strFieldName.equals("ApprovalFlag") ) {
			return 10;
		}
		if( strFieldName.equals("Operator") ) {
			return 11;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 12;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 13;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 14;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 15;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 16;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 17;
		}
		if( strFieldName.equals("Operator1") ) {
			return 18;
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
				strFieldName = "YearMonth";
				break;
			case 2:
				strFieldName = "MonthlyFinance";
				break;
			case 3:
				strFieldName = "ValidationReq";
				break;
			case 4:
				strFieldName = "WelcomeIncentive";
				break;
			case 5:
				strFieldName = "MonthlyFinanceAdvance";
				break;
			case 6:
				strFieldName = "ApprovalDate";
				break;
			case 7:
				strFieldName = "ApprovalTime";
				break;
			case 8:
				strFieldName = "ApprovalOperator";
				break;
			case 9:
				strFieldName = "ApprovalReason";
				break;
			case 10:
				strFieldName = "ApprovalFlag";
				break;
			case 11:
				strFieldName = "Operator";
				break;
			case 12:
				strFieldName = "MakeDate";
				break;
			case 13:
				strFieldName = "MakeTime";
				break;
			case 14:
				strFieldName = "ModifyDate";
				break;
			case 15:
				strFieldName = "ModifyTime";
				break;
			case 16:
				strFieldName = "MakeDate1";
				break;
			case 17:
				strFieldName = "MakeTime1";
				break;
			case 18:
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
		if( strFieldName.equals("YearMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MonthlyFinance") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("ValidationReq") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("WelcomeIncentive") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("MonthlyFinanceAdvance") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 3:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 4:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 5:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 6:
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 16:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
