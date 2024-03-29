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
import com.sinosoft.lis.db.LAAgentFPDetailDB;

/*
 * <p>ClassName: LAAgentFPDetailSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LAAgentFP_Setting
 */
public class LAAgentFPDetailSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentFPDetailSchema.class);
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

	public static final int FIELDNUM = 11;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentFPDetailSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "AgentCode";
		pk[1] = "YearMonth";

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
		LAAgentFPDetailSchema cloned = (LAAgentFPDetailSchema)super.clone();
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

	/**
	* 使用另外一个 LAAgentFPDetailSchema 对象给 Schema 赋值
	* @param: aLAAgentFPDetailSchema LAAgentFPDetailSchema
	**/
	public void setSchema(LAAgentFPDetailSchema aLAAgentFPDetailSchema)
	{
		this.AgentCode = aLAAgentFPDetailSchema.getAgentCode();
		this.YearMonth = aLAAgentFPDetailSchema.getYearMonth();
		this.MonthlyFinance = aLAAgentFPDetailSchema.getMonthlyFinance();
		this.ValidationReq = aLAAgentFPDetailSchema.getValidationReq();
		this.WelcomeIncentive = aLAAgentFPDetailSchema.getWelcomeIncentive();
		this.MonthlyFinanceAdvance = aLAAgentFPDetailSchema.getMonthlyFinanceAdvance();
		this.Operator = aLAAgentFPDetailSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentFPDetailSchema.getMakeDate());
		this.MakeTime = aLAAgentFPDetailSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentFPDetailSchema.getModifyDate());
		this.ModifyTime = aLAAgentFPDetailSchema.getModifyTime();
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

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAAgentFPDetail表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentFPDetailSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentFPDetailSchema getSchema()
	{
		LAAgentFPDetailSchema aLAAgentFPDetailSchema = new LAAgentFPDetailSchema();
		aLAAgentFPDetailSchema.setSchema(this);
		return aLAAgentFPDetailSchema;
	}

	public LAAgentFPDetailDB getDB()
	{
		LAAgentFPDetailDB aDBOper = new LAAgentFPDetailDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentFPDetail描述/A>表字段
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
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentFPDetail>历史记账凭证主表信息</A>表字段
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
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentFPDetailSchema";
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
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 10:
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAAgentFPDetailSchema other = (LAAgentFPDetailSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& YearMonth.equals(other.getYearMonth())
			&& MonthlyFinance == other.getMonthlyFinance()
			&& ValidationReq == other.getValidationReq()
			&& WelcomeIncentive == other.getWelcomeIncentive()
			&& MonthlyFinanceAdvance == other.getMonthlyFinanceAdvance()
			&& Operator.equals(other.getOperator())
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
		if( strFieldName.equals("Operator") ) {
			return 6;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 7;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 8;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 9;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 10;
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
				strFieldName = "Operator";
				break;
			case 7:
				strFieldName = "MakeDate";
				break;
			case 8:
				strFieldName = "MakeTime";
				break;
			case 9:
				strFieldName = "ModifyDate";
				break;
			case 10:
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
