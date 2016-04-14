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
import com.sinosoft.lis.db.LAAgentBlackListBDB;

/*
 * <p>ClassName: LAAgentBlackListBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAgentBlackListBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentBlackListBSchema.class);
	// @Field
	/** Idno */
	private String IDNo;
	/** Name */
	private String Name;
	/** Agentcode */
	private String AgentCode;
	/** Insurancecompany */
	private String InsuranceCompany;
	/** Source */
	private String Source;
	/** Handlingmethod */
	private String HandlingMethod;
	/** Reason */
	private String Reason;
	/** Effectivedate */
	private Date EffectiveDate;
	/** Expirydate */
	private Date ExpiryDate;
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
	/** Operator1 */
	private String Operator1;
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;

	public static final int FIELDNUM = 17;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentBlackListBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "IDNo";
		pk[1] = "Operator1";
		pk[2] = "MakeDate1";
		pk[3] = "MakeTime1";

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
		LAAgentBlackListBSchema cloned = (LAAgentBlackListBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	/**
	* 證件號
	*/
	public String getIDNo()
	{
		return IDNo;
	}
	public void setIDNo(String aIDNo)
	{
		if(aIDNo!=null && aIDNo.length()>20)
			throw new IllegalArgumentException("IdnoIDNo值"+aIDNo+"的长度"+aIDNo.length()+"大于最大值20");
		IDNo = aIDNo;
	}
	/**
	* 姓名
	*/
	public String getName()
	{
		return Name;
	}
	public void setName(String aName)
	{
		if(aName!=null && aName.length()>100)
			throw new IllegalArgumentException("NameName值"+aName+"的长度"+aName.length()+"大于最大值100");
		Name = aName;
	}
	/**
	* Metlife代理人編碼【如果是Metlife代理人的話才存在，如果不是Metlife代理人，此項為空】
	*/
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
	/**
	* 所屬保險公司
	*/
	public String getInsuranceCompany()
	{
		return InsuranceCompany;
	}
	public void setInsuranceCompany(String aInsuranceCompany)
	{
		if(aInsuranceCompany!=null && aInsuranceCompany.length()>50)
			throw new IllegalArgumentException("InsurancecompanyInsuranceCompany值"+aInsuranceCompany+"的长度"+aInsuranceCompany.length()+"大于最大值50");
		InsuranceCompany = aInsuranceCompany;
	}
	/**
	* 黑名單來源
	*/
	public String getSource()
	{
		return Source;
	}
	public void setSource(String aSource)
	{
		if(aSource!=null && aSource.length()>2)
			throw new IllegalArgumentException("SourceSource值"+aSource+"的长度"+aSource.length()+"大于最大值2");
		Source = aSource;
	}
	/**
	* 處理方式
	*/
	public String getHandlingMethod()
	{
		return HandlingMethod;
	}
	public void setHandlingMethod(String aHandlingMethod)
	{
		if(aHandlingMethod!=null && aHandlingMethod.length()>2)
			throw new IllegalArgumentException("HandlingmethodHandlingMethod值"+aHandlingMethod+"的长度"+aHandlingMethod.length()+"大于最大值2");
		HandlingMethod = aHandlingMethod;
	}
	/**
	* 記入名單原因
	*/
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
	/**
	* 生效日
	*/
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

	/**
	* 滿期日
	*/
	public String getExpiryDate()
	{
		if( ExpiryDate != null )
			return fDate.getString(ExpiryDate);
		else
			return null;
	}
	public void setExpiryDate(Date aExpiryDate)
	{
		ExpiryDate = aExpiryDate;
	}
	public void setExpiryDate(String aExpiryDate)
	{
		if (aExpiryDate != null && !aExpiryDate.equals("") )
		{
			ExpiryDate = fDate.getDate( aExpiryDate );
		}
		else
			ExpiryDate = null;
	}

	/**
	* Operator
	*/
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
	/**
	* MakeDate
	*/
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

	/**
	* MakeTime
	*/
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
	/**
	* ModifyDate
	*/
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

	/**
	* ModifyTime
	*/
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
	* Operator1
	*/
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
	* MakeDate1
	*/
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

	/**
	* MakeTime1
	*/
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

	/**
	* 使用另外一个 LAAgentBlackListBSchema 对象给 Schema 赋值
	* @param: aLAAgentBlackListBSchema LAAgentBlackListBSchema
	**/
	public void setSchema(LAAgentBlackListBSchema aLAAgentBlackListBSchema)
	{
		this.IDNo = aLAAgentBlackListBSchema.getIDNo();
		this.Name = aLAAgentBlackListBSchema.getName();
		this.AgentCode = aLAAgentBlackListBSchema.getAgentCode();
		this.InsuranceCompany = aLAAgentBlackListBSchema.getInsuranceCompany();
		this.Source = aLAAgentBlackListBSchema.getSource();
		this.HandlingMethod = aLAAgentBlackListBSchema.getHandlingMethod();
		this.Reason = aLAAgentBlackListBSchema.getReason();
		this.EffectiveDate = fDate.getDate( aLAAgentBlackListBSchema.getEffectiveDate());
		this.ExpiryDate = fDate.getDate( aLAAgentBlackListBSchema.getExpiryDate());
		this.Operator = aLAAgentBlackListBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentBlackListBSchema.getMakeDate());
		this.MakeTime = aLAAgentBlackListBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentBlackListBSchema.getModifyDate());
		this.ModifyTime = aLAAgentBlackListBSchema.getModifyTime();
		this.Operator1 = aLAAgentBlackListBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLAAgentBlackListBSchema.getMakeDate1());
		this.MakeTime1 = aLAAgentBlackListBSchema.getMakeTime1();
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
			if( rs.getString("IDNo") == null )
				this.IDNo = null;
			else
				this.IDNo = rs.getString("IDNo").trim();

			if( rs.getString("Name") == null )
				this.Name = null;
			else
				this.Name = rs.getString("Name").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("InsuranceCompany") == null )
				this.InsuranceCompany = null;
			else
				this.InsuranceCompany = rs.getString("InsuranceCompany").trim();

			if( rs.getString("Source") == null )
				this.Source = null;
			else
				this.Source = rs.getString("Source").trim();

			if( rs.getString("HandlingMethod") == null )
				this.HandlingMethod = null;
			else
				this.HandlingMethod = rs.getString("HandlingMethod").trim();

			if( rs.getString("Reason") == null )
				this.Reason = null;
			else
				this.Reason = rs.getString("Reason").trim();

			this.EffectiveDate = rs.getDate("EffectiveDate");
			this.ExpiryDate = rs.getDate("ExpiryDate");
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

			if( rs.getString("Operator1") == null )
				this.Operator1 = null;
			else
				this.Operator1 = rs.getString("Operator1").trim();

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAAgentBlackListB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentBlackListBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentBlackListBSchema getSchema()
	{
		LAAgentBlackListBSchema aLAAgentBlackListBSchema = new LAAgentBlackListBSchema();
		aLAAgentBlackListBSchema.setSchema(this);
		return aLAAgentBlackListBSchema;
	}

	public LAAgentBlackListBDB getDB()
	{
		LAAgentBlackListBDB aDBOper = new LAAgentBlackListBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentBlackListB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(IDNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Name)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InsuranceCompany)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Source)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HandlingMethod)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Reason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ExpiryDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentBlackListB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			IDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			InsuranceCompany = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Source = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			HandlingMethod = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Reason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			EffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			ExpiryDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentBlackListBSchema";
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
		if (FCode.equalsIgnoreCase("IDNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDNo));
		}
		if (FCode.equalsIgnoreCase("Name"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Name));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("InsuranceCompany"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuranceCompany));
		}
		if (FCode.equalsIgnoreCase("Source"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Source));
		}
		if (FCode.equalsIgnoreCase("HandlingMethod"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HandlingMethod));
		}
		if (FCode.equalsIgnoreCase("Reason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Reason));
		}
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
		}
		if (FCode.equalsIgnoreCase("ExpiryDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getExpiryDate()));
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
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator1));
		}
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime1));
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
				strFieldValue = StrTool.GBKToUnicode(IDNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(Name);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(InsuranceCompany);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Source);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(HandlingMethod);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(Reason);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getExpiryDate()));
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
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
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

		if (FCode.equalsIgnoreCase("IDNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDNo = FValue.trim();
			}
			else
				IDNo = null;
		}
		if (FCode.equalsIgnoreCase("Name"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Name = FValue.trim();
			}
			else
				Name = null;
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
		if (FCode.equalsIgnoreCase("InsuranceCompany"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InsuranceCompany = FValue.trim();
			}
			else
				InsuranceCompany = null;
		}
		if (FCode.equalsIgnoreCase("Source"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Source = FValue.trim();
			}
			else
				Source = null;
		}
		if (FCode.equalsIgnoreCase("HandlingMethod"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HandlingMethod = FValue.trim();
			}
			else
				HandlingMethod = null;
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
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				EffectiveDate = fDate.getDate( FValue );
			}
			else
				EffectiveDate = null;
		}
		if (FCode.equalsIgnoreCase("ExpiryDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ExpiryDate = fDate.getDate( FValue );
			}
			else
				ExpiryDate = null;
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
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator1 = FValue.trim();
			}
			else
				Operator1 = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAAgentBlackListBSchema other = (LAAgentBlackListBSchema)otherObject;
		return
			IDNo.equals(other.getIDNo())
			&& Name.equals(other.getName())
			&& AgentCode.equals(other.getAgentCode())
			&& InsuranceCompany.equals(other.getInsuranceCompany())
			&& Source.equals(other.getSource())
			&& HandlingMethod.equals(other.getHandlingMethod())
			&& Reason.equals(other.getReason())
			&& fDate.getString(EffectiveDate).equals(other.getEffectiveDate())
			&& fDate.getString(ExpiryDate).equals(other.getExpiryDate())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator1.equals(other.getOperator1())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1());
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
		if( strFieldName.equals("IDNo") ) {
			return 0;
		}
		if( strFieldName.equals("Name") ) {
			return 1;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 2;
		}
		if( strFieldName.equals("InsuranceCompany") ) {
			return 3;
		}
		if( strFieldName.equals("Source") ) {
			return 4;
		}
		if( strFieldName.equals("HandlingMethod") ) {
			return 5;
		}
		if( strFieldName.equals("Reason") ) {
			return 6;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return 7;
		}
		if( strFieldName.equals("ExpiryDate") ) {
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
		if( strFieldName.equals("Operator1") ) {
			return 14;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 15;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 16;
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
				strFieldName = "IDNo";
				break;
			case 1:
				strFieldName = "Name";
				break;
			case 2:
				strFieldName = "AgentCode";
				break;
			case 3:
				strFieldName = "InsuranceCompany";
				break;
			case 4:
				strFieldName = "Source";
				break;
			case 5:
				strFieldName = "HandlingMethod";
				break;
			case 6:
				strFieldName = "Reason";
				break;
			case 7:
				strFieldName = "EffectiveDate";
				break;
			case 8:
				strFieldName = "ExpiryDate";
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
			case 14:
				strFieldName = "Operator1";
				break;
			case 15:
				strFieldName = "MakeDate1";
				break;
			case 16:
				strFieldName = "MakeTime1";
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
		if( strFieldName.equals("IDNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Name") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InsuranceCompany") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Source") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HandlingMethod") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Reason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ExpiryDate") ) {
			return Schema.TYPE_DATE;
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
		if( strFieldName.equals("Operator1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime1") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_DATE;
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
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
