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
import com.sinosoft.lis.db.DailyPersistencyDB;

/*
 * <p>ClassName: DailyPersistencySchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyPersistencySchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(DailyPersistencySchema.class);
	// @Field
	/** Company_code */
	private String Company_Code;
	/** Policy_no */
	private String Policy_No;
	/** Product_code */
	private String Product_Code;
	/** Coverage_code */
	private String Coverage_Code;
	/** Coverage_effective_date */
	private Date Coverage_Effective_Date;
	/** Lapse__anp_at_issue */
	private double Lapse__ANP_At_Issue;
	/** Exposure__anp_at_issue */
	private double Exposure__ANP_At_Issue;
	/** Calculation_date */
	private Date Calculation_Date;
	/** Business_date */
	private Date Business_Date;
	/** Batch_no */
	private double Batch_No;
	/** Batch_run_date */
	private Date Batch_Run_Date;

	public static final int FIELDNUM = 11;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public DailyPersistencySchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[0];

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
		DailyPersistencySchema cloned = (DailyPersistencySchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCompany_Code()
	{
		return Company_Code;
	}
	public void setCompany_Code(String aCompany_Code)
	{
		if(aCompany_Code!=null && aCompany_Code.length()>1)
			throw new IllegalArgumentException("Company_codeCompany_Code值"+aCompany_Code+"的长度"+aCompany_Code.length()+"大于最大值1");
		Company_Code = aCompany_Code;
	}
	public String getPolicy_No()
	{
		return Policy_No;
	}
	public void setPolicy_No(String aPolicy_No)
	{
		if(aPolicy_No!=null && aPolicy_No.length()>8)
			throw new IllegalArgumentException("Policy_noPolicy_No值"+aPolicy_No+"的长度"+aPolicy_No.length()+"大于最大值8");
		Policy_No = aPolicy_No;
	}
	public String getProduct_Code()
	{
		return Product_Code;
	}
	public void setProduct_Code(String aProduct_Code)
	{
		if(aProduct_Code!=null && aProduct_Code.length()>3)
			throw new IllegalArgumentException("Product_codeProduct_Code值"+aProduct_Code+"的长度"+aProduct_Code.length()+"大于最大值3");
		Product_Code = aProduct_Code;
	}
	public String getCoverage_Code()
	{
		return Coverage_Code;
	}
	public void setCoverage_Code(String aCoverage_Code)
	{
		if(aCoverage_Code!=null && aCoverage_Code.length()>4)
			throw new IllegalArgumentException("Coverage_codeCoverage_Code值"+aCoverage_Code+"的长度"+aCoverage_Code.length()+"大于最大值4");
		Coverage_Code = aCoverage_Code;
	}
	public String getCoverage_Effective_Date()
	{
		if( Coverage_Effective_Date != null )
			return fDate.getString(Coverage_Effective_Date);
		else
			return null;
	}
	public void setCoverage_Effective_Date(Date aCoverage_Effective_Date)
	{
		Coverage_Effective_Date = aCoverage_Effective_Date;
	}
	public void setCoverage_Effective_Date(String aCoverage_Effective_Date)
	{
		if (aCoverage_Effective_Date != null && !aCoverage_Effective_Date.equals("") )
		{
			Coverage_Effective_Date = fDate.getDate( aCoverage_Effective_Date );
		}
		else
			Coverage_Effective_Date = null;
	}

	public double getLapse__ANP_At_Issue()
	{
		return Lapse__ANP_At_Issue;
	}
	public void setLapse__ANP_At_Issue(double aLapse__ANP_At_Issue)
	{
		Lapse__ANP_At_Issue = aLapse__ANP_At_Issue;
	}
	public void setLapse__ANP_At_Issue(String aLapse__ANP_At_Issue)
	{
		if (aLapse__ANP_At_Issue != null && !aLapse__ANP_At_Issue.equals(""))
		{
			Double tDouble = new Double(aLapse__ANP_At_Issue);
			double d = tDouble.doubleValue();
			Lapse__ANP_At_Issue = d;
		}
	}

	public double getExposure__ANP_At_Issue()
	{
		return Exposure__ANP_At_Issue;
	}
	public void setExposure__ANP_At_Issue(double aExposure__ANP_At_Issue)
	{
		Exposure__ANP_At_Issue = aExposure__ANP_At_Issue;
	}
	public void setExposure__ANP_At_Issue(String aExposure__ANP_At_Issue)
	{
		if (aExposure__ANP_At_Issue != null && !aExposure__ANP_At_Issue.equals(""))
		{
			Double tDouble = new Double(aExposure__ANP_At_Issue);
			double d = tDouble.doubleValue();
			Exposure__ANP_At_Issue = d;
		}
	}

	public String getCalculation_Date()
	{
		if( Calculation_Date != null )
			return fDate.getString(Calculation_Date);
		else
			return null;
	}
	public void setCalculation_Date(Date aCalculation_Date)
	{
		Calculation_Date = aCalculation_Date;
	}
	public void setCalculation_Date(String aCalculation_Date)
	{
		if (aCalculation_Date != null && !aCalculation_Date.equals("") )
		{
			Calculation_Date = fDate.getDate( aCalculation_Date );
		}
		else
			Calculation_Date = null;
	}

	public String getBusiness_Date()
	{
		if( Business_Date != null )
			return fDate.getString(Business_Date);
		else
			return null;
	}
	public void setBusiness_Date(Date aBusiness_Date)
	{
		Business_Date = aBusiness_Date;
	}
	public void setBusiness_Date(String aBusiness_Date)
	{
		if (aBusiness_Date != null && !aBusiness_Date.equals("") )
		{
			Business_Date = fDate.getDate( aBusiness_Date );
		}
		else
			Business_Date = null;
	}

	public double getBatch_No()
	{
		return Batch_No;
	}
	public void setBatch_No(double aBatch_No)
	{
		Batch_No = aBatch_No;
	}
	public void setBatch_No(String aBatch_No)
	{
		if (aBatch_No != null && !aBatch_No.equals(""))
		{
			Double tDouble = new Double(aBatch_No);
			double d = tDouble.doubleValue();
			Batch_No = d;
		}
	}

	public String getBatch_Run_Date()
	{
		if( Batch_Run_Date != null )
			return fDate.getString(Batch_Run_Date);
		else
			return null;
	}
	public void setBatch_Run_Date(Date aBatch_Run_Date)
	{
		Batch_Run_Date = aBatch_Run_Date;
	}
	public void setBatch_Run_Date(String aBatch_Run_Date)
	{
		if (aBatch_Run_Date != null && !aBatch_Run_Date.equals("") )
		{
			Batch_Run_Date = fDate.getDate( aBatch_Run_Date );
		}
		else
			Batch_Run_Date = null;
	}


	/**
	* 使用另外一个 DailyPersistencySchema 对象给 Schema 赋值
	* @param: aDailyPersistencySchema DailyPersistencySchema
	**/
	public void setSchema(DailyPersistencySchema aDailyPersistencySchema)
	{
		this.Company_Code = aDailyPersistencySchema.getCompany_Code();
		this.Policy_No = aDailyPersistencySchema.getPolicy_No();
		this.Product_Code = aDailyPersistencySchema.getProduct_Code();
		this.Coverage_Code = aDailyPersistencySchema.getCoverage_Code();
		this.Coverage_Effective_Date = fDate.getDate( aDailyPersistencySchema.getCoverage_Effective_Date());
		this.Lapse__ANP_At_Issue = aDailyPersistencySchema.getLapse__ANP_At_Issue();
		this.Exposure__ANP_At_Issue = aDailyPersistencySchema.getExposure__ANP_At_Issue();
		this.Calculation_Date = fDate.getDate( aDailyPersistencySchema.getCalculation_Date());
		this.Business_Date = fDate.getDate( aDailyPersistencySchema.getBusiness_Date());
		this.Batch_No = aDailyPersistencySchema.getBatch_No();
		this.Batch_Run_Date = fDate.getDate( aDailyPersistencySchema.getBatch_Run_Date());
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
			if( rs.getString("Company_Code") == null )
				this.Company_Code = null;
			else
				this.Company_Code = rs.getString("Company_Code").trim();

			if( rs.getString("Policy_No") == null )
				this.Policy_No = null;
			else
				this.Policy_No = rs.getString("Policy_No").trim();

			if( rs.getString("Product_Code") == null )
				this.Product_Code = null;
			else
				this.Product_Code = rs.getString("Product_Code").trim();

			if( rs.getString("Coverage_Code") == null )
				this.Coverage_Code = null;
			else
				this.Coverage_Code = rs.getString("Coverage_Code").trim();

			this.Coverage_Effective_Date = rs.getDate("Coverage_Effective_Date");
			this.Lapse__ANP_At_Issue = rs.getDouble("Lapse__ANP_At_Issue");
			this.Exposure__ANP_At_Issue = rs.getDouble("Exposure__ANP_At_Issue");
			this.Calculation_Date = rs.getDate("Calculation_Date");
			this.Business_Date = rs.getDate("Business_Date");
			this.Batch_No = rs.getDouble("Batch_No");
			this.Batch_Run_Date = rs.getDate("Batch_Run_Date");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的DailyPersistency表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPersistencySchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public DailyPersistencySchema getSchema()
	{
		DailyPersistencySchema aDailyPersistencySchema = new DailyPersistencySchema();
		aDailyPersistencySchema.setSchema(this);
		return aDailyPersistencySchema;
	}

	public DailyPersistencyDB getDB()
	{
		DailyPersistencyDB aDBOper = new DailyPersistencyDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyPersistency描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(Company_Code)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Policy_No)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Product_Code)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Coverage_Code)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Coverage_Effective_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Lapse__ANP_At_Issue));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Exposure__ANP_At_Issue));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Calculation_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Business_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Batch_No));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Batch_Run_Date )));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyPersistency>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			Company_Code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Policy_No = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			Product_Code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			Coverage_Code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Coverage_Effective_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5,SysConst.PACKAGESPILTER));
			Lapse__ANP_At_Issue = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,6,SysConst.PACKAGESPILTER))).doubleValue();
			Exposure__ANP_At_Issue = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			Calculation_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			Business_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			Batch_No = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,10,SysConst.PACKAGESPILTER))).doubleValue();
			Batch_Run_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPersistencySchema";
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
		if (FCode.equalsIgnoreCase("Company_Code"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Company_Code));
		}
		if (FCode.equalsIgnoreCase("Policy_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Policy_No));
		}
		if (FCode.equalsIgnoreCase("Product_Code"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Product_Code));
		}
		if (FCode.equalsIgnoreCase("Coverage_Code"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Coverage_Code));
		}
		if (FCode.equalsIgnoreCase("Coverage_Effective_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getCoverage_Effective_Date()));
		}
		if (FCode.equalsIgnoreCase("Lapse__ANP_At_Issue"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Lapse__ANP_At_Issue));
		}
		if (FCode.equalsIgnoreCase("Exposure__ANP_At_Issue"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Exposure__ANP_At_Issue));
		}
		if (FCode.equalsIgnoreCase("Calculation_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getCalculation_Date()));
		}
		if (FCode.equalsIgnoreCase("Business_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBusiness_Date()));
		}
		if (FCode.equalsIgnoreCase("Batch_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Batch_No));
		}
		if (FCode.equalsIgnoreCase("Batch_Run_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBatch_Run_Date()));
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
				strFieldValue = StrTool.GBKToUnicode(Company_Code);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(Policy_No);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(Product_Code);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(Coverage_Code);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCoverage_Effective_Date()));
				break;
			case 5:
				strFieldValue = String.valueOf(Lapse__ANP_At_Issue);
				break;
			case 6:
				strFieldValue = String.valueOf(Exposure__ANP_At_Issue);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCalculation_Date()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBusiness_Date()));
				break;
			case 9:
				strFieldValue = String.valueOf(Batch_No);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBatch_Run_Date()));
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

		if (FCode.equalsIgnoreCase("Company_Code"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Company_Code = FValue.trim();
			}
			else
				Company_Code = null;
		}
		if (FCode.equalsIgnoreCase("Policy_No"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Policy_No = FValue.trim();
			}
			else
				Policy_No = null;
		}
		if (FCode.equalsIgnoreCase("Product_Code"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Product_Code = FValue.trim();
			}
			else
				Product_Code = null;
		}
		if (FCode.equalsIgnoreCase("Coverage_Code"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Coverage_Code = FValue.trim();
			}
			else
				Coverage_Code = null;
		}
		if (FCode.equalsIgnoreCase("Coverage_Effective_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Coverage_Effective_Date = fDate.getDate( FValue );
			}
			else
				Coverage_Effective_Date = null;
		}
		if (FCode.equalsIgnoreCase("Lapse__ANP_At_Issue"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Lapse__ANP_At_Issue = d;
			}
		}
		if (FCode.equalsIgnoreCase("Exposure__ANP_At_Issue"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Exposure__ANP_At_Issue = d;
			}
		}
		if (FCode.equalsIgnoreCase("Calculation_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Calculation_Date = fDate.getDate( FValue );
			}
			else
				Calculation_Date = null;
		}
		if (FCode.equalsIgnoreCase("Business_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Business_Date = fDate.getDate( FValue );
			}
			else
				Business_Date = null;
		}
		if (FCode.equalsIgnoreCase("Batch_No"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Batch_No = d;
			}
		}
		if (FCode.equalsIgnoreCase("Batch_Run_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Batch_Run_Date = fDate.getDate( FValue );
			}
			else
				Batch_Run_Date = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		DailyPersistencySchema other = (DailyPersistencySchema)otherObject;
		return
			Company_Code.equals(other.getCompany_Code())
			&& Policy_No.equals(other.getPolicy_No())
			&& Product_Code.equals(other.getProduct_Code())
			&& Coverage_Code.equals(other.getCoverage_Code())
			&& fDate.getString(Coverage_Effective_Date).equals(other.getCoverage_Effective_Date())
			&& Lapse__ANP_At_Issue == other.getLapse__ANP_At_Issue()
			&& Exposure__ANP_At_Issue == other.getExposure__ANP_At_Issue()
			&& fDate.getString(Calculation_Date).equals(other.getCalculation_Date())
			&& fDate.getString(Business_Date).equals(other.getBusiness_Date())
			&& Batch_No == other.getBatch_No()
			&& fDate.getString(Batch_Run_Date).equals(other.getBatch_Run_Date());
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
		if( strFieldName.equals("Company_Code") ) {
			return 0;
		}
		if( strFieldName.equals("Policy_No") ) {
			return 1;
		}
		if( strFieldName.equals("Product_Code") ) {
			return 2;
		}
		if( strFieldName.equals("Coverage_Code") ) {
			return 3;
		}
		if( strFieldName.equals("Coverage_Effective_Date") ) {
			return 4;
		}
		if( strFieldName.equals("Lapse__ANP_At_Issue") ) {
			return 5;
		}
		if( strFieldName.equals("Exposure__ANP_At_Issue") ) {
			return 6;
		}
		if( strFieldName.equals("Calculation_Date") ) {
			return 7;
		}
		if( strFieldName.equals("Business_Date") ) {
			return 8;
		}
		if( strFieldName.equals("Batch_No") ) {
			return 9;
		}
		if( strFieldName.equals("Batch_Run_Date") ) {
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
				strFieldName = "Company_Code";
				break;
			case 1:
				strFieldName = "Policy_No";
				break;
			case 2:
				strFieldName = "Product_Code";
				break;
			case 3:
				strFieldName = "Coverage_Code";
				break;
			case 4:
				strFieldName = "Coverage_Effective_Date";
				break;
			case 5:
				strFieldName = "Lapse__ANP_At_Issue";
				break;
			case 6:
				strFieldName = "Exposure__ANP_At_Issue";
				break;
			case 7:
				strFieldName = "Calculation_Date";
				break;
			case 8:
				strFieldName = "Business_Date";
				break;
			case 9:
				strFieldName = "Batch_No";
				break;
			case 10:
				strFieldName = "Batch_Run_Date";
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
		if( strFieldName.equals("Company_Code") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Policy_No") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Product_Code") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Coverage_Code") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Coverage_Effective_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Lapse__ANP_At_Issue") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Exposure__ANP_At_Issue") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Calculation_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Business_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Batch_No") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Batch_Run_Date") ) {
			return Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 6:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 9:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 10:
				nFieldType = Schema.TYPE_DATE;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
