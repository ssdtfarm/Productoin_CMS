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
import com.sinosoft.lis.db.LAGroupMedicalandLifeDB;

/*
 * <p>ClassName: LAGroupMedicalandLifeSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAGroupMedicalandLifeSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAGroupMedicalandLifeSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Classcode */
	private String ClassCode;
	/** Poltype */
	private String POLTYPE;
	/** Dependentpremium */
	private double DependentPremium;
	/** Coverageamount */
	private double CoverageAmount;
	/** Nextreviewdate */
	private Date NextReviewDate;
	/** Noofchildren */
	private double Noofchildren;
	/** Effectivedate */
	private Date EffectiveDate;
	/** Operator */
	private String Operator;
	/** Makedate */
	private Date MAKEDATE;
	/** Maketime */
	private String MAKETIME;
	/** Modifydate */
	private Date MODIFYDATE;
	/** Modifytime */
	private String MODIFYTIME;

	public static final int FIELDNUM = 13;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAGroupMedicalandLifeSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "AgentCode";
		pk[1] = "POLTYPE";

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
		LAGroupMedicalandLifeSchema cloned = (LAGroupMedicalandLifeSchema)super.clone();
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
		if(aAgentCode!=null && aAgentCode.length()>10)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值10");
		AgentCode = aAgentCode;
	}
	public String getClassCode()
	{
		return ClassCode;
	}
	public void setClassCode(String aClassCode)
	{
		if(aClassCode!=null && aClassCode.length()>20)
			throw new IllegalArgumentException("ClasscodeClassCode值"+aClassCode+"的长度"+aClassCode.length()+"大于最大值20");
		ClassCode = aClassCode;
	}
	public String getPOLTYPE()
	{
		return POLTYPE;
	}
	public void setPOLTYPE(String aPOLTYPE)
	{
		if(aPOLTYPE!=null && aPOLTYPE.length()>50)
			throw new IllegalArgumentException("PoltypePOLTYPE值"+aPOLTYPE+"的长度"+aPOLTYPE.length()+"大于最大值50");
		POLTYPE = aPOLTYPE;
	}
	public double getDependentPremium()
	{
		return DependentPremium;
	}
	public void setDependentPremium(double aDependentPremium)
	{
		DependentPremium = aDependentPremium;
	}
	public void setDependentPremium(String aDependentPremium)
	{
		if (aDependentPremium != null && !aDependentPremium.equals(""))
		{
			Double tDouble = new Double(aDependentPremium);
			double d = tDouble.doubleValue();
			DependentPremium = d;
		}
	}

	public double getCoverageAmount()
	{
		return CoverageAmount;
	}
	public void setCoverageAmount(double aCoverageAmount)
	{
		CoverageAmount = aCoverageAmount;
	}
	public void setCoverageAmount(String aCoverageAmount)
	{
		if (aCoverageAmount != null && !aCoverageAmount.equals(""))
		{
			Double tDouble = new Double(aCoverageAmount);
			double d = tDouble.doubleValue();
			CoverageAmount = d;
		}
	}

	public String getNextReviewDate()
	{
		if( NextReviewDate != null )
			return fDate.getString(NextReviewDate);
		else
			return null;
	}
	public void setNextReviewDate(Date aNextReviewDate)
	{
		NextReviewDate = aNextReviewDate;
	}
	public void setNextReviewDate(String aNextReviewDate)
	{
		if (aNextReviewDate != null && !aNextReviewDate.equals("") )
		{
			NextReviewDate = fDate.getDate( aNextReviewDate );
		}
		else
			NextReviewDate = null;
	}

	public double getNoofchildren()
	{
		return Noofchildren;
	}
	public void setNoofchildren(double aNoofchildren)
	{
		Noofchildren = aNoofchildren;
	}
	public void setNoofchildren(String aNoofchildren)
	{
		if (aNoofchildren != null && !aNoofchildren.equals(""))
		{
			Double tDouble = new Double(aNoofchildren);
			double d = tDouble.doubleValue();
			Noofchildren = d;
		}
	}

	public String getEffectiveDate()
	{
		if( EffectiveDate != null )
			return fDate.getString(EffectiveDate);
		else
			return null;
	}
	public void setEffectiveDate(Date aEffectiveDate)
	{
		EffectiveDate = aEffectiveDate;
	}
	public void setEffectiveDate(String aEffectiveDate)
	{
		if (aEffectiveDate != null && !aEffectiveDate.equals("") )
		{
			EffectiveDate = fDate.getDate( aEffectiveDate );
		}
		else
			EffectiveDate = null;
	}

	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>10)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值10");
		Operator = aOperator;
	}
	public String getMAKEDATE()
	{
		if( MAKEDATE != null )
			return fDate.getString(MAKEDATE);
		else
			return null;
	}
	public void setMAKEDATE(Date aMAKEDATE)
	{
		MAKEDATE = aMAKEDATE;
	}
	public void setMAKEDATE(String aMAKEDATE)
	{
		if (aMAKEDATE != null && !aMAKEDATE.equals("") )
		{
			MAKEDATE = fDate.getDate( aMAKEDATE );
		}
		else
			MAKEDATE = null;
	}

	public String getMAKETIME()
	{
		return MAKETIME;
	}
	public void setMAKETIME(String aMAKETIME)
	{
		if(aMAKETIME!=null && aMAKETIME.length()>8)
			throw new IllegalArgumentException("MaketimeMAKETIME值"+aMAKETIME+"的长度"+aMAKETIME.length()+"大于最大值8");
		MAKETIME = aMAKETIME;
	}
	public String getMODIFYDATE()
	{
		if( MODIFYDATE != null )
			return fDate.getString(MODIFYDATE);
		else
			return null;
	}
	public void setMODIFYDATE(Date aMODIFYDATE)
	{
		MODIFYDATE = aMODIFYDATE;
	}
	public void setMODIFYDATE(String aMODIFYDATE)
	{
		if (aMODIFYDATE != null && !aMODIFYDATE.equals("") )
		{
			MODIFYDATE = fDate.getDate( aMODIFYDATE );
		}
		else
			MODIFYDATE = null;
	}

	public String getMODIFYTIME()
	{
		return MODIFYTIME;
	}
	public void setMODIFYTIME(String aMODIFYTIME)
	{
		if(aMODIFYTIME!=null && aMODIFYTIME.length()>8)
			throw new IllegalArgumentException("ModifytimeMODIFYTIME值"+aMODIFYTIME+"的长度"+aMODIFYTIME.length()+"大于最大值8");
		MODIFYTIME = aMODIFYTIME;
	}

	/**
	* 使用另外一个 LAGroupMedicalandLifeSchema 对象给 Schema 赋值
	* @param: aLAGroupMedicalandLifeSchema LAGroupMedicalandLifeSchema
	**/
	public void setSchema(LAGroupMedicalandLifeSchema aLAGroupMedicalandLifeSchema)
	{
		this.AgentCode = aLAGroupMedicalandLifeSchema.getAgentCode();
		this.ClassCode = aLAGroupMedicalandLifeSchema.getClassCode();
		this.POLTYPE = aLAGroupMedicalandLifeSchema.getPOLTYPE();
		this.DependentPremium = aLAGroupMedicalandLifeSchema.getDependentPremium();
		this.CoverageAmount = aLAGroupMedicalandLifeSchema.getCoverageAmount();
		this.NextReviewDate = fDate.getDate( aLAGroupMedicalandLifeSchema.getNextReviewDate());
		this.Noofchildren = aLAGroupMedicalandLifeSchema.getNoofchildren();
		this.EffectiveDate = fDate.getDate( aLAGroupMedicalandLifeSchema.getEffectiveDate());
		this.Operator = aLAGroupMedicalandLifeSchema.getOperator();
		this.MAKEDATE = fDate.getDate( aLAGroupMedicalandLifeSchema.getMAKEDATE());
		this.MAKETIME = aLAGroupMedicalandLifeSchema.getMAKETIME();
		this.MODIFYDATE = fDate.getDate( aLAGroupMedicalandLifeSchema.getMODIFYDATE());
		this.MODIFYTIME = aLAGroupMedicalandLifeSchema.getMODIFYTIME();
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

			if( rs.getString("ClassCode") == null )
				this.ClassCode = null;
			else
				this.ClassCode = rs.getString("ClassCode").trim();

			if( rs.getString("POLTYPE") == null )
				this.POLTYPE = null;
			else
				this.POLTYPE = rs.getString("POLTYPE").trim();

			this.DependentPremium = rs.getDouble("DependentPremium");
			this.CoverageAmount = rs.getDouble("CoverageAmount");
			this.NextReviewDate = rs.getDate("NextReviewDate");
			this.Noofchildren = rs.getDouble("Noofchildren");
			this.EffectiveDate = rs.getDate("EffectiveDate");
			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			this.MAKEDATE = rs.getDate("MAKEDATE");
			if( rs.getString("MAKETIME") == null )
				this.MAKETIME = null;
			else
				this.MAKETIME = rs.getString("MAKETIME").trim();

			this.MODIFYDATE = rs.getDate("MODIFYDATE");
			if( rs.getString("MODIFYTIME") == null )
				this.MODIFYTIME = null;
			else
				this.MODIFYTIME = rs.getString("MODIFYTIME").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAGroupMedicalandLife表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAGroupMedicalandLifeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAGroupMedicalandLifeSchema getSchema()
	{
		LAGroupMedicalandLifeSchema aLAGroupMedicalandLifeSchema = new LAGroupMedicalandLifeSchema();
		aLAGroupMedicalandLifeSchema.setSchema(this);
		return aLAGroupMedicalandLifeSchema;
	}

	public LAGroupMedicalandLifeDB getDB()
	{
		LAGroupMedicalandLifeDB aDBOper = new LAGroupMedicalandLifeDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAGroupMedicalandLife描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ClassCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(POLTYPE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(DependentPremium));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(CoverageAmount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( NextReviewDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Noofchildren));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MAKEDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MAKETIME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MODIFYDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MODIFYTIME));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAGroupMedicalandLife>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ClassCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			POLTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			DependentPremium = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,4,SysConst.PACKAGESPILTER))).doubleValue();
			CoverageAmount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,5,SysConst.PACKAGESPILTER))).doubleValue();
			NextReviewDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			Noofchildren = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			EffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MAKEDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MAKETIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			MODIFYDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			MODIFYTIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAGroupMedicalandLifeSchema";
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
		if (FCode.equalsIgnoreCase("ClassCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ClassCode));
		}
		if (FCode.equalsIgnoreCase("POLTYPE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(POLTYPE));
		}
		if (FCode.equalsIgnoreCase("DependentPremium"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DependentPremium));
		}
		if (FCode.equalsIgnoreCase("CoverageAmount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CoverageAmount));
		}
		if (FCode.equalsIgnoreCase("NextReviewDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getNextReviewDate()));
		}
		if (FCode.equalsIgnoreCase("Noofchildren"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Noofchildren));
		}
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		}
		if (FCode.equalsIgnoreCase("MAKEDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMAKEDATE()));
		}
		if (FCode.equalsIgnoreCase("MAKETIME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAKETIME));
		}
		if (FCode.equalsIgnoreCase("MODIFYDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMODIFYDATE()));
		}
		if (FCode.equalsIgnoreCase("MODIFYTIME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MODIFYTIME));
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
				strFieldValue = StrTool.GBKToUnicode(ClassCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(POLTYPE);
				break;
			case 3:
				strFieldValue = String.valueOf(DependentPremium);
				break;
			case 4:
				strFieldValue = String.valueOf(CoverageAmount);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getNextReviewDate()));
				break;
			case 6:
				strFieldValue = String.valueOf(Noofchildren);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMAKEDATE()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(MAKETIME);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMODIFYDATE()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(MODIFYTIME);
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
		if (FCode.equalsIgnoreCase("ClassCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ClassCode = FValue.trim();
			}
			else
				ClassCode = null;
		}
		if (FCode.equalsIgnoreCase("POLTYPE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				POLTYPE = FValue.trim();
			}
			else
				POLTYPE = null;
		}
		if (FCode.equalsIgnoreCase("DependentPremium"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				DependentPremium = d;
			}
		}
		if (FCode.equalsIgnoreCase("CoverageAmount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				CoverageAmount = d;
			}
		}
		if (FCode.equalsIgnoreCase("NextReviewDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				NextReviewDate = fDate.getDate( FValue );
			}
			else
				NextReviewDate = null;
		}
		if (FCode.equalsIgnoreCase("Noofchildren"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Noofchildren = d;
			}
		}
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				EffectiveDate = fDate.getDate( FValue );
			}
			else
				EffectiveDate = null;
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
		if (FCode.equalsIgnoreCase("MAKEDATE"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MAKEDATE = fDate.getDate( FValue );
			}
			else
				MAKEDATE = null;
		}
		if (FCode.equalsIgnoreCase("MAKETIME"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MAKETIME = FValue.trim();
			}
			else
				MAKETIME = null;
		}
		if (FCode.equalsIgnoreCase("MODIFYDATE"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MODIFYDATE = fDate.getDate( FValue );
			}
			else
				MODIFYDATE = null;
		}
		if (FCode.equalsIgnoreCase("MODIFYTIME"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MODIFYTIME = FValue.trim();
			}
			else
				MODIFYTIME = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAGroupMedicalandLifeSchema other = (LAGroupMedicalandLifeSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& ClassCode.equals(other.getClassCode())
			&& POLTYPE.equals(other.getPOLTYPE())
			&& DependentPremium == other.getDependentPremium()
			&& CoverageAmount == other.getCoverageAmount()
			&& fDate.getString(NextReviewDate).equals(other.getNextReviewDate())
			&& Noofchildren == other.getNoofchildren()
			&& fDate.getString(EffectiveDate).equals(other.getEffectiveDate())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MAKEDATE).equals(other.getMAKEDATE())
			&& MAKETIME.equals(other.getMAKETIME())
			&& fDate.getString(MODIFYDATE).equals(other.getMODIFYDATE())
			&& MODIFYTIME.equals(other.getMODIFYTIME());
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
		if( strFieldName.equals("ClassCode") ) {
			return 1;
		}
		if( strFieldName.equals("POLTYPE") ) {
			return 2;
		}
		if( strFieldName.equals("DependentPremium") ) {
			return 3;
		}
		if( strFieldName.equals("CoverageAmount") ) {
			return 4;
		}
		if( strFieldName.equals("NextReviewDate") ) {
			return 5;
		}
		if( strFieldName.equals("Noofchildren") ) {
			return 6;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return 7;
		}
		if( strFieldName.equals("Operator") ) {
			return 8;
		}
		if( strFieldName.equals("MAKEDATE") ) {
			return 9;
		}
		if( strFieldName.equals("MAKETIME") ) {
			return 10;
		}
		if( strFieldName.equals("MODIFYDATE") ) {
			return 11;
		}
		if( strFieldName.equals("MODIFYTIME") ) {
			return 12;
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
				strFieldName = "ClassCode";
				break;
			case 2:
				strFieldName = "POLTYPE";
				break;
			case 3:
				strFieldName = "DependentPremium";
				break;
			case 4:
				strFieldName = "CoverageAmount";
				break;
			case 5:
				strFieldName = "NextReviewDate";
				break;
			case 6:
				strFieldName = "Noofchildren";
				break;
			case 7:
				strFieldName = "EffectiveDate";
				break;
			case 8:
				strFieldName = "Operator";
				break;
			case 9:
				strFieldName = "MAKEDATE";
				break;
			case 10:
				strFieldName = "MAKETIME";
				break;
			case 11:
				strFieldName = "MODIFYDATE";
				break;
			case 12:
				strFieldName = "MODIFYTIME";
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
		if( strFieldName.equals("ClassCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("POLTYPE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DependentPremium") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("CoverageAmount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("NextReviewDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Noofchildren") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Operator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MAKEDATE") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MAKETIME") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MODIFYDATE") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MODIFYTIME") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 4:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 5:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 6:
				nFieldType = Schema.TYPE_DOUBLE;
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
			case 11:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
