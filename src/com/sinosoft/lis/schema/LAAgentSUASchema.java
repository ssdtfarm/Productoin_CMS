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
import com.sinosoft.lis.db.LAAgentSUADB;

/*
 * <p>ClassName: LAAgentSUASchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAgentSUASchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentSUASchema.class);
	// @Field
	/** Suasn */
	private String SUASN;
	/** Servicingagentcode */
	private String ServicingAgentCode;
	/** Policyno */
	private String PolicyNo;
	/** Suaadjusttype */
	private String SUAAdjustType;
	/** Suaadjustdate */
	private Date SUAAdjustDate;
	/** Fyc_ryc_type */
	private String FYC_RYC_Type;
	/** Adjustamount */
	private double AdjustAmount;
	/** Suaaccount */
	private double SUAAccount;
	/** Reason */
	private String Reason;
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

	public static final int FIELDNUM = 14;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentSUASchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "SUASN";

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
		LAAgentSUASchema cloned = (LAAgentSUASchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getSUASN()
	{
		return SUASN;
	}
	public void setSUASN(String aSUASN)
	{
		if(aSUASN!=null && aSUASN.length()>20)
			throw new IllegalArgumentException("SuasnSUASN值"+aSUASN+"的长度"+aSUASN.length()+"大于最大值20");
		SUASN = aSUASN;
	}
	public String getServicingAgentCode()
	{
		return ServicingAgentCode;
	}
	public void setServicingAgentCode(String aServicingAgentCode)
	{
		if(aServicingAgentCode!=null && aServicingAgentCode.length()>12)
			throw new IllegalArgumentException("ServicingagentcodeServicingAgentCode值"+aServicingAgentCode+"的长度"+aServicingAgentCode.length()+"大于最大值12");
		ServicingAgentCode = aServicingAgentCode;
	}
	public String getPolicyNo()
	{
		return PolicyNo;
	}
	public void setPolicyNo(String aPolicyNo)
	{
		if(aPolicyNo!=null && aPolicyNo.length()>8)
			throw new IllegalArgumentException("PolicynoPolicyNo值"+aPolicyNo+"的长度"+aPolicyNo.length()+"大于最大值8");
		PolicyNo = aPolicyNo;
	}
	public String getSUAAdjustType()
	{
		return SUAAdjustType;
	}
	public void setSUAAdjustType(String aSUAAdjustType)
	{
		if(aSUAAdjustType!=null && aSUAAdjustType.length()>2)
			throw new IllegalArgumentException("SuaadjusttypeSUAAdjustType值"+aSUAAdjustType+"的长度"+aSUAAdjustType.length()+"大于最大值2");
		SUAAdjustType = aSUAAdjustType;
	}
	public String getSUAAdjustDate()
	{
		if( SUAAdjustDate != null )
			return fDate.getString(SUAAdjustDate);
		else
			return null;
	}
	public void setSUAAdjustDate(Date aSUAAdjustDate)
	{
		SUAAdjustDate = aSUAAdjustDate;
	}
	public void setSUAAdjustDate(String aSUAAdjustDate)
	{
		if (aSUAAdjustDate != null && !aSUAAdjustDate.equals("") )
		{
			SUAAdjustDate = fDate.getDate( aSUAAdjustDate );
		}
		else
			SUAAdjustDate = null;
	}

	public String getFYC_RYC_Type()
	{
		return FYC_RYC_Type;
	}
	public void setFYC_RYC_Type(String aFYC_RYC_Type)
	{
		if(aFYC_RYC_Type!=null && aFYC_RYC_Type.length()>2)
			throw new IllegalArgumentException("Fyc_ryc_typeFYC_RYC_Type值"+aFYC_RYC_Type+"的长度"+aFYC_RYC_Type.length()+"大于最大值2");
		FYC_RYC_Type = aFYC_RYC_Type;
	}
	public double getAdjustAmount()
	{
		return AdjustAmount;
	}
	public void setAdjustAmount(double aAdjustAmount)
	{
		AdjustAmount = aAdjustAmount;
	}
	public void setAdjustAmount(String aAdjustAmount)
	{
		if (aAdjustAmount != null && !aAdjustAmount.equals(""))
		{
			Double tDouble = new Double(aAdjustAmount);
			double d = tDouble.doubleValue();
			AdjustAmount = d;
		}
	}

	public double getSUAAccount()
	{
		return SUAAccount;
	}
	public void setSUAAccount(double aSUAAccount)
	{
		SUAAccount = aSUAAccount;
	}
	public void setSUAAccount(String aSUAAccount)
	{
		if (aSUAAccount != null && !aSUAAccount.equals(""))
		{
			Double tDouble = new Double(aSUAAccount);
			double d = tDouble.doubleValue();
			SUAAccount = d;
		}
	}

	public String getReason()
	{
		return Reason;
	}
	public void setReason(String aReason)
	{
		if(aReason!=null && aReason.length()>500)
			throw new IllegalArgumentException("ReasonReason值"+aReason+"的长度"+aReason.length()+"大于最大值500");
		Reason = aReason;
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
	* 使用另外一个 LAAgentSUASchema 对象给 Schema 赋值
	* @param: aLAAgentSUASchema LAAgentSUASchema
	**/
	public void setSchema(LAAgentSUASchema aLAAgentSUASchema)
	{
		this.SUASN = aLAAgentSUASchema.getSUASN();
		this.ServicingAgentCode = aLAAgentSUASchema.getServicingAgentCode();
		this.PolicyNo = aLAAgentSUASchema.getPolicyNo();
		this.SUAAdjustType = aLAAgentSUASchema.getSUAAdjustType();
		this.SUAAdjustDate = fDate.getDate( aLAAgentSUASchema.getSUAAdjustDate());
		this.FYC_RYC_Type = aLAAgentSUASchema.getFYC_RYC_Type();
		this.AdjustAmount = aLAAgentSUASchema.getAdjustAmount();
		this.SUAAccount = aLAAgentSUASchema.getSUAAccount();
		this.Reason = aLAAgentSUASchema.getReason();
		this.Operator = aLAAgentSUASchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentSUASchema.getMakeDate());
		this.MakeTime = aLAAgentSUASchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentSUASchema.getModifyDate());
		this.ModifyTime = aLAAgentSUASchema.getModifyTime();
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
			if( rs.getString("SUASN") == null )
				this.SUASN = null;
			else
				this.SUASN = rs.getString("SUASN").trim();

			if( rs.getString("ServicingAgentCode") == null )
				this.ServicingAgentCode = null;
			else
				this.ServicingAgentCode = rs.getString("ServicingAgentCode").trim();

			if( rs.getString("PolicyNo") == null )
				this.PolicyNo = null;
			else
				this.PolicyNo = rs.getString("PolicyNo").trim();

			if( rs.getString("SUAAdjustType") == null )
				this.SUAAdjustType = null;
			else
				this.SUAAdjustType = rs.getString("SUAAdjustType").trim();

			this.SUAAdjustDate = rs.getDate("SUAAdjustDate");
			if( rs.getString("FYC_RYC_Type") == null )
				this.FYC_RYC_Type = null;
			else
				this.FYC_RYC_Type = rs.getString("FYC_RYC_Type").trim();

			this.AdjustAmount = rs.getDouble("AdjustAmount");
			this.SUAAccount = rs.getDouble("SUAAccount");
			if( rs.getString("Reason") == null )
				this.Reason = null;
			else
				this.Reason = rs.getString("Reason").trim();

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
			logger.debug("数据库中的LAAgentSUA表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentSUASchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentSUASchema getSchema()
	{
		LAAgentSUASchema aLAAgentSUASchema = new LAAgentSUASchema();
		aLAAgentSUASchema.setSchema(this);
		return aLAAgentSUASchema;
	}

	public LAAgentSUADB getDB()
	{
		LAAgentSUADB aDBOper = new LAAgentSUADB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentSUA描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(SUASN)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ServicingAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PolicyNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SUAAdjustType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( SUAAdjustDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FYC_RYC_Type)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AdjustAmount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SUAAccount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Reason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentSUA>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			SUASN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ServicingAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			PolicyNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			SUAAdjustType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			SUAAdjustDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5,SysConst.PACKAGESPILTER));
			FYC_RYC_Type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AdjustAmount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			SUAAccount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,8,SysConst.PACKAGESPILTER))).doubleValue();
			Reason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentSUASchema";
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
		if (FCode.equalsIgnoreCase("SUASN"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SUASN));
		}
		if (FCode.equalsIgnoreCase("ServicingAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ServicingAgentCode));
		}
		if (FCode.equalsIgnoreCase("PolicyNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PolicyNo));
		}
		if (FCode.equalsIgnoreCase("SUAAdjustType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SUAAdjustType));
		}
		if (FCode.equalsIgnoreCase("SUAAdjustDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getSUAAdjustDate()));
		}
		if (FCode.equalsIgnoreCase("FYC_RYC_Type"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FYC_RYC_Type));
		}
		if (FCode.equalsIgnoreCase("AdjustAmount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AdjustAmount));
		}
		if (FCode.equalsIgnoreCase("SUAAccount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SUAAccount));
		}
		if (FCode.equalsIgnoreCase("Reason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Reason));
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
				strFieldValue = StrTool.GBKToUnicode(SUASN);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ServicingAgentCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(PolicyNo);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(SUAAdjustType);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getSUAAdjustDate()));
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(FYC_RYC_Type);
				break;
			case 6:
				strFieldValue = String.valueOf(AdjustAmount);
				break;
			case 7:
				strFieldValue = String.valueOf(SUAAccount);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Reason);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 13:
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

		if (FCode.equalsIgnoreCase("SUASN"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SUASN = FValue.trim();
			}
			else
				SUASN = null;
		}
		if (FCode.equalsIgnoreCase("ServicingAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ServicingAgentCode = FValue.trim();
			}
			else
				ServicingAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("PolicyNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PolicyNo = FValue.trim();
			}
			else
				PolicyNo = null;
		}
		if (FCode.equalsIgnoreCase("SUAAdjustType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SUAAdjustType = FValue.trim();
			}
			else
				SUAAdjustType = null;
		}
		if (FCode.equalsIgnoreCase("SUAAdjustDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				SUAAdjustDate = fDate.getDate( FValue );
			}
			else
				SUAAdjustDate = null;
		}
		if (FCode.equalsIgnoreCase("FYC_RYC_Type"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FYC_RYC_Type = FValue.trim();
			}
			else
				FYC_RYC_Type = null;
		}
		if (FCode.equalsIgnoreCase("AdjustAmount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				AdjustAmount = d;
			}
		}
		if (FCode.equalsIgnoreCase("SUAAccount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				SUAAccount = d;
			}
		}
		if (FCode.equalsIgnoreCase("Reason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Reason = FValue.trim();
			}
			else
				Reason = null;
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
		LAAgentSUASchema other = (LAAgentSUASchema)otherObject;
		return
			SUASN.equals(other.getSUASN())
			&& ServicingAgentCode.equals(other.getServicingAgentCode())
			&& PolicyNo.equals(other.getPolicyNo())
			&& SUAAdjustType.equals(other.getSUAAdjustType())
			&& fDate.getString(SUAAdjustDate).equals(other.getSUAAdjustDate())
			&& FYC_RYC_Type.equals(other.getFYC_RYC_Type())
			&& AdjustAmount == other.getAdjustAmount()
			&& SUAAccount == other.getSUAAccount()
			&& Reason.equals(other.getReason())
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
		if( strFieldName.equals("SUASN") ) {
			return 0;
		}
		if( strFieldName.equals("ServicingAgentCode") ) {
			return 1;
		}
		if( strFieldName.equals("PolicyNo") ) {
			return 2;
		}
		if( strFieldName.equals("SUAAdjustType") ) {
			return 3;
		}
		if( strFieldName.equals("SUAAdjustDate") ) {
			return 4;
		}
		if( strFieldName.equals("FYC_RYC_Type") ) {
			return 5;
		}
		if( strFieldName.equals("AdjustAmount") ) {
			return 6;
		}
		if( strFieldName.equals("SUAAccount") ) {
			return 7;
		}
		if( strFieldName.equals("Reason") ) {
			return 8;
		}
		if( strFieldName.equals("Operator") ) {
			return 9;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 10;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 11;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 12;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 13;
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
				strFieldName = "SUASN";
				break;
			case 1:
				strFieldName = "ServicingAgentCode";
				break;
			case 2:
				strFieldName = "PolicyNo";
				break;
			case 3:
				strFieldName = "SUAAdjustType";
				break;
			case 4:
				strFieldName = "SUAAdjustDate";
				break;
			case 5:
				strFieldName = "FYC_RYC_Type";
				break;
			case 6:
				strFieldName = "AdjustAmount";
				break;
			case 7:
				strFieldName = "SUAAccount";
				break;
			case 8:
				strFieldName = "Reason";
				break;
			case 9:
				strFieldName = "Operator";
				break;
			case 10:
				strFieldName = "MakeDate";
				break;
			case 11:
				strFieldName = "MakeTime";
				break;
			case 12:
				strFieldName = "ModifyDate";
				break;
			case 13:
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
		if( strFieldName.equals("SUASN") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ServicingAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PolicyNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SUAAdjustType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SUAAdjustDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("FYC_RYC_Type") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AdjustAmount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("SUAAccount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Reason") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 5:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 6:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 7:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_DATE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
