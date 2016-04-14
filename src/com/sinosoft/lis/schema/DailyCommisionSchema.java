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
import com.sinosoft.lis.db.DailyCommisionDB;

/*
 * <p>ClassName: DailyCommisionSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyCommisionSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(DailyCommisionSchema.class);
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
	/** Premium_contract_currency */
	private String Premium_Contract_Currency;
	/** Premium_amount */
	private double Premium_Amount;
	/** Commission */
	private double Commission;
	/** Commission_type */
	private String Commission_Type;
	/** Portion */
	private String Portion;
	/** Instalment_number */
	private double Instalment_Number;
	/** Pay_mode */
	private String Pay_Mode;
	/** Base_policy_indicator */
	private String Base_Policy_Indicator;
	/** Trx_code */
	private String Trx_Code;
	/** Calculation_date */
	private Date Calculation_Date;
	/** Business_date */
	private Date Business_Date;
	/** Batch_no */
	private double Batch_No;
	/** Batch_run_date */
	private Date Batch_Run_Date;

	public static final int FIELDNUM = 18;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public DailyCommisionSchema()
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
		DailyCommisionSchema cloned = (DailyCommisionSchema)super.clone();
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

	public String getPremium_Contract_Currency()
	{
		return Premium_Contract_Currency;
	}
	public void setPremium_Contract_Currency(String aPremium_Contract_Currency)
	{
		if(aPremium_Contract_Currency!=null && aPremium_Contract_Currency.length()>3)
			throw new IllegalArgumentException("Premium_contract_currencyPremium_Contract_Currency值"+aPremium_Contract_Currency+"的长度"+aPremium_Contract_Currency.length()+"大于最大值3");
		Premium_Contract_Currency = aPremium_Contract_Currency;
	}
	public double getPremium_Amount()
	{
		return Premium_Amount;
	}
	public void setPremium_Amount(double aPremium_Amount)
	{
		Premium_Amount = aPremium_Amount;
	}
	public void setPremium_Amount(String aPremium_Amount)
	{
		if (aPremium_Amount != null && !aPremium_Amount.equals(""))
		{
			Double tDouble = new Double(aPremium_Amount);
			double d = tDouble.doubleValue();
			Premium_Amount = d;
		}
	}

	public double getCommission()
	{
		return Commission;
	}
	public void setCommission(double aCommission)
	{
		Commission = aCommission;
	}
	public void setCommission(String aCommission)
	{
		if (aCommission != null && !aCommission.equals(""))
		{
			Double tDouble = new Double(aCommission);
			double d = tDouble.doubleValue();
			Commission = d;
		}
	}

	public String getCommission_Type()
	{
		return Commission_Type;
	}
	public void setCommission_Type(String aCommission_Type)
	{
		if(aCommission_Type!=null && aCommission_Type.length()>2)
			throw new IllegalArgumentException("Commission_typeCommission_Type值"+aCommission_Type+"的长度"+aCommission_Type.length()+"大于最大值2");
		Commission_Type = aCommission_Type;
	}
	public String getPortion()
	{
		return Portion;
	}
	public void setPortion(String aPortion)
	{
		if(aPortion!=null && aPortion.length()>1)
			throw new IllegalArgumentException("PortionPortion值"+aPortion+"的长度"+aPortion.length()+"大于最大值1");
		Portion = aPortion;
	}
	public double getInstalment_Number()
	{
		return Instalment_Number;
	}
	public void setInstalment_Number(double aInstalment_Number)
	{
		Instalment_Number = aInstalment_Number;
	}
	public void setInstalment_Number(String aInstalment_Number)
	{
		if (aInstalment_Number != null && !aInstalment_Number.equals(""))
		{
			Double tDouble = new Double(aInstalment_Number);
			double d = tDouble.doubleValue();
			Instalment_Number = d;
		}
	}

	public String getPay_Mode()
	{
		return Pay_Mode;
	}
	public void setPay_Mode(String aPay_Mode)
	{
		if(aPay_Mode!=null && aPay_Mode.length()>2)
			throw new IllegalArgumentException("Pay_modePay_Mode值"+aPay_Mode+"的长度"+aPay_Mode.length()+"大于最大值2");
		Pay_Mode = aPay_Mode;
	}
	public String getBase_Policy_Indicator()
	{
		return Base_Policy_Indicator;
	}
	public void setBase_Policy_Indicator(String aBase_Policy_Indicator)
	{
		if(aBase_Policy_Indicator!=null && aBase_Policy_Indicator.length()>1)
			throw new IllegalArgumentException("Base_policy_indicatorBase_Policy_Indicator值"+aBase_Policy_Indicator+"的长度"+aBase_Policy_Indicator.length()+"大于最大值1");
		Base_Policy_Indicator = aBase_Policy_Indicator;
	}
	public String getTrx_Code()
	{
		return Trx_Code;
	}
	public void setTrx_Code(String aTrx_Code)
	{
		if(aTrx_Code!=null && aTrx_Code.length()>4)
			throw new IllegalArgumentException("Trx_codeTrx_Code值"+aTrx_Code+"的长度"+aTrx_Code.length()+"大于最大值4");
		Trx_Code = aTrx_Code;
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
	* 使用另外一个 DailyCommisionSchema 对象给 Schema 赋值
	* @param: aDailyCommisionSchema DailyCommisionSchema
	**/
	public void setSchema(DailyCommisionSchema aDailyCommisionSchema)
	{
		this.Company_Code = aDailyCommisionSchema.getCompany_Code();
		this.Policy_No = aDailyCommisionSchema.getPolicy_No();
		this.Product_Code = aDailyCommisionSchema.getProduct_Code();
		this.Coverage_Code = aDailyCommisionSchema.getCoverage_Code();
		this.Coverage_Effective_Date = fDate.getDate( aDailyCommisionSchema.getCoverage_Effective_Date());
		this.Premium_Contract_Currency = aDailyCommisionSchema.getPremium_Contract_Currency();
		this.Premium_Amount = aDailyCommisionSchema.getPremium_Amount();
		this.Commission = aDailyCommisionSchema.getCommission();
		this.Commission_Type = aDailyCommisionSchema.getCommission_Type();
		this.Portion = aDailyCommisionSchema.getPortion();
		this.Instalment_Number = aDailyCommisionSchema.getInstalment_Number();
		this.Pay_Mode = aDailyCommisionSchema.getPay_Mode();
		this.Base_Policy_Indicator = aDailyCommisionSchema.getBase_Policy_Indicator();
		this.Trx_Code = aDailyCommisionSchema.getTrx_Code();
		this.Calculation_Date = fDate.getDate( aDailyCommisionSchema.getCalculation_Date());
		this.Business_Date = fDate.getDate( aDailyCommisionSchema.getBusiness_Date());
		this.Batch_No = aDailyCommisionSchema.getBatch_No();
		this.Batch_Run_Date = fDate.getDate( aDailyCommisionSchema.getBatch_Run_Date());
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
			if( rs.getString("Premium_Contract_Currency") == null )
				this.Premium_Contract_Currency = null;
			else
				this.Premium_Contract_Currency = rs.getString("Premium_Contract_Currency").trim();

			this.Premium_Amount = rs.getDouble("Premium_Amount");
			this.Commission = rs.getDouble("Commission");
			if( rs.getString("Commission_Type") == null )
				this.Commission_Type = null;
			else
				this.Commission_Type = rs.getString("Commission_Type").trim();

			if( rs.getString("Portion") == null )
				this.Portion = null;
			else
				this.Portion = rs.getString("Portion").trim();

			this.Instalment_Number = rs.getDouble("Instalment_Number");
			if( rs.getString("Pay_Mode") == null )
				this.Pay_Mode = null;
			else
				this.Pay_Mode = rs.getString("Pay_Mode").trim();

			if( rs.getString("Base_Policy_Indicator") == null )
				this.Base_Policy_Indicator = null;
			else
				this.Base_Policy_Indicator = rs.getString("Base_Policy_Indicator").trim();

			if( rs.getString("Trx_Code") == null )
				this.Trx_Code = null;
			else
				this.Trx_Code = rs.getString("Trx_Code").trim();

			this.Calculation_Date = rs.getDate("Calculation_Date");
			this.Business_Date = rs.getDate("Business_Date");
			this.Batch_No = rs.getDouble("Batch_No");
			this.Batch_Run_Date = rs.getDate("Batch_Run_Date");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的DailyCommision表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyCommisionSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public DailyCommisionSchema getSchema()
	{
		DailyCommisionSchema aDailyCommisionSchema = new DailyCommisionSchema();
		aDailyCommisionSchema.setSchema(this);
		return aDailyCommisionSchema;
	}

	public DailyCommisionDB getDB()
	{
		DailyCommisionDB aDBOper = new DailyCommisionDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyCommision描述/A>表字段
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
		strReturn.append(StrTool.cTrim(Premium_Contract_Currency)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Premium_Amount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Commission));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Commission_Type)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Portion)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Instalment_Number));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Pay_Mode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Base_Policy_Indicator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Trx_Code)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Calculation_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Business_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Batch_No));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Batch_Run_Date )));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyCommision>历史记账凭证主表信息</A>表字段
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
			Premium_Contract_Currency = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Premium_Amount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			Commission = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,8,SysConst.PACKAGESPILTER))).doubleValue();
			Commission_Type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			Portion = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			Instalment_Number = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,11,SysConst.PACKAGESPILTER))).doubleValue();
			Pay_Mode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Base_Policy_Indicator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Trx_Code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Calculation_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			Business_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			Batch_No = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,17,SysConst.PACKAGESPILTER))).doubleValue();
			Batch_Run_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyCommisionSchema";
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
		if (FCode.equalsIgnoreCase("Premium_Contract_Currency"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Premium_Contract_Currency));
		}
		if (FCode.equalsIgnoreCase("Premium_Amount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Premium_Amount));
		}
		if (FCode.equalsIgnoreCase("Commission"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Commission));
		}
		if (FCode.equalsIgnoreCase("Commission_Type"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Commission_Type));
		}
		if (FCode.equalsIgnoreCase("Portion"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Portion));
		}
		if (FCode.equalsIgnoreCase("Instalment_Number"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Instalment_Number));
		}
		if (FCode.equalsIgnoreCase("Pay_Mode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Pay_Mode));
		}
		if (FCode.equalsIgnoreCase("Base_Policy_Indicator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Base_Policy_Indicator));
		}
		if (FCode.equalsIgnoreCase("Trx_Code"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Trx_Code));
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
				strFieldValue = StrTool.GBKToUnicode(Premium_Contract_Currency);
				break;
			case 6:
				strFieldValue = String.valueOf(Premium_Amount);
				break;
			case 7:
				strFieldValue = String.valueOf(Commission);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Commission_Type);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Portion);
				break;
			case 10:
				strFieldValue = String.valueOf(Instalment_Number);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Pay_Mode);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(Base_Policy_Indicator);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Trx_Code);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCalculation_Date()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBusiness_Date()));
				break;
			case 16:
				strFieldValue = String.valueOf(Batch_No);
				break;
			case 17:
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
		if (FCode.equalsIgnoreCase("Premium_Contract_Currency"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Premium_Contract_Currency = FValue.trim();
			}
			else
				Premium_Contract_Currency = null;
		}
		if (FCode.equalsIgnoreCase("Premium_Amount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Premium_Amount = d;
			}
		}
		if (FCode.equalsIgnoreCase("Commission"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Commission = d;
			}
		}
		if (FCode.equalsIgnoreCase("Commission_Type"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Commission_Type = FValue.trim();
			}
			else
				Commission_Type = null;
		}
		if (FCode.equalsIgnoreCase("Portion"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Portion = FValue.trim();
			}
			else
				Portion = null;
		}
		if (FCode.equalsIgnoreCase("Instalment_Number"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Instalment_Number = d;
			}
		}
		if (FCode.equalsIgnoreCase("Pay_Mode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Pay_Mode = FValue.trim();
			}
			else
				Pay_Mode = null;
		}
		if (FCode.equalsIgnoreCase("Base_Policy_Indicator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Base_Policy_Indicator = FValue.trim();
			}
			else
				Base_Policy_Indicator = null;
		}
		if (FCode.equalsIgnoreCase("Trx_Code"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Trx_Code = FValue.trim();
			}
			else
				Trx_Code = null;
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
		DailyCommisionSchema other = (DailyCommisionSchema)otherObject;
		return
			Company_Code.equals(other.getCompany_Code())
			&& Policy_No.equals(other.getPolicy_No())
			&& Product_Code.equals(other.getProduct_Code())
			&& Coverage_Code.equals(other.getCoverage_Code())
			&& fDate.getString(Coverage_Effective_Date).equals(other.getCoverage_Effective_Date())
			&& Premium_Contract_Currency.equals(other.getPremium_Contract_Currency())
			&& Premium_Amount == other.getPremium_Amount()
			&& Commission == other.getCommission()
			&& Commission_Type.equals(other.getCommission_Type())
			&& Portion.equals(other.getPortion())
			&& Instalment_Number == other.getInstalment_Number()
			&& Pay_Mode.equals(other.getPay_Mode())
			&& Base_Policy_Indicator.equals(other.getBase_Policy_Indicator())
			&& Trx_Code.equals(other.getTrx_Code())
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
		if( strFieldName.equals("Premium_Contract_Currency") ) {
			return 5;
		}
		if( strFieldName.equals("Premium_Amount") ) {
			return 6;
		}
		if( strFieldName.equals("Commission") ) {
			return 7;
		}
		if( strFieldName.equals("Commission_Type") ) {
			return 8;
		}
		if( strFieldName.equals("Portion") ) {
			return 9;
		}
		if( strFieldName.equals("Instalment_Number") ) {
			return 10;
		}
		if( strFieldName.equals("Pay_Mode") ) {
			return 11;
		}
		if( strFieldName.equals("Base_Policy_Indicator") ) {
			return 12;
		}
		if( strFieldName.equals("Trx_Code") ) {
			return 13;
		}
		if( strFieldName.equals("Calculation_Date") ) {
			return 14;
		}
		if( strFieldName.equals("Business_Date") ) {
			return 15;
		}
		if( strFieldName.equals("Batch_No") ) {
			return 16;
		}
		if( strFieldName.equals("Batch_Run_Date") ) {
			return 17;
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
				strFieldName = "Premium_Contract_Currency";
				break;
			case 6:
				strFieldName = "Premium_Amount";
				break;
			case 7:
				strFieldName = "Commission";
				break;
			case 8:
				strFieldName = "Commission_Type";
				break;
			case 9:
				strFieldName = "Portion";
				break;
			case 10:
				strFieldName = "Instalment_Number";
				break;
			case 11:
				strFieldName = "Pay_Mode";
				break;
			case 12:
				strFieldName = "Base_Policy_Indicator";
				break;
			case 13:
				strFieldName = "Trx_Code";
				break;
			case 14:
				strFieldName = "Calculation_Date";
				break;
			case 15:
				strFieldName = "Business_Date";
				break;
			case 16:
				strFieldName = "Batch_No";
				break;
			case 17:
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
		if( strFieldName.equals("Premium_Contract_Currency") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Premium_Amount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Commission") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Commission_Type") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Portion") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Instalment_Number") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Pay_Mode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Base_Policy_Indicator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Trx_Code") ) {
			return Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 15:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 17:
				nFieldType = Schema.TYPE_DATE;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
