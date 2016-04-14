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
import com.sinosoft.lis.db.LASubjectDB;

/*
 * <p>ClassName: LASubjectSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LASubjectSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LASubjectSchema.class);
	// @Field
	/** Managecom */
	private String Managecom;
	/** Branchtype */
	private String BranchType;
	/** Subjectcode */
	private String SubjectCode;
	/** Subjectname */
	private String SubjectName;
	/** Riskcode */
	private String RiskCode;
	/** Status */
	private String Status;
	/** Caltype */
	private String CalType;
	/** Reflectfiled */
	private String ReflectFiled;
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
	/** Taxflag */
	private String TaxFlag;
	/** Offerflag */
	private String OfferFlag;
	/** Firstyearflag */
	private String FirstYearFlag;
	/** Mainsubjectcode */
	private String MainSubjectCode;
	/** Subbranch */
	private String Subbranch;
	/** Financetype */
	private String FinanceType;
	/** Adjustflag */
	private String AdjustFlag;
	/** Calcode */
	private String CalCode;
	/** F1 */
	private double F1;
	/** F2 */
	private double F2;
	/** F3 */
	private double F3;
	/** F4 */
	private double F4;
	/** F5 */
	private double F5;
	/** F6 */
	private double F6;

	public static final int FIELDNUM = 27;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LASubjectSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "MainSubjectCode";
		pk[1] = "Subbranch";

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
		LASubjectSchema cloned = (LASubjectSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getManagecom()
	{
		return Managecom;
	}
	public void setManagecom(String aManagecom)
	{
		if(aManagecom!=null && aManagecom.length()>10)
			throw new IllegalArgumentException("ManagecomManagecom值"+aManagecom+"的长度"+aManagecom.length()+"大于最大值10");
		Managecom = aManagecom;
	}
	public String getBranchType()
	{
		return BranchType;
	}
	public void setBranchType(String aBranchType)
	{
		if(aBranchType!=null && aBranchType.length()>2)
			throw new IllegalArgumentException("BranchtypeBranchType值"+aBranchType+"的长度"+aBranchType.length()+"大于最大值2");
		BranchType = aBranchType;
	}
	public String getSubjectCode()
	{
		return SubjectCode;
	}
	public void setSubjectCode(String aSubjectCode)
	{
		if(aSubjectCode!=null && aSubjectCode.length()>20)
			throw new IllegalArgumentException("SubjectcodeSubjectCode值"+aSubjectCode+"的长度"+aSubjectCode.length()+"大于最大值20");
		SubjectCode = aSubjectCode;
	}
	public String getSubjectName()
	{
		return SubjectName;
	}
	public void setSubjectName(String aSubjectName)
	{
		if(aSubjectName!=null && aSubjectName.length()>150)
			throw new IllegalArgumentException("SubjectnameSubjectName值"+aSubjectName+"的长度"+aSubjectName.length()+"大于最大值150");
		SubjectName = aSubjectName;
	}
	public String getRiskCode()
	{
		return RiskCode;
	}
	public void setRiskCode(String aRiskCode)
	{
		if(aRiskCode!=null && aRiskCode.length()>12)
			throw new IllegalArgumentException("RiskcodeRiskCode值"+aRiskCode+"的长度"+aRiskCode.length()+"大于最大值12");
		RiskCode = aRiskCode;
	}
	public String getStatus()
	{
		return Status;
	}
	public void setStatus(String aStatus)
	{
		if(aStatus!=null && aStatus.length()>2)
			throw new IllegalArgumentException("StatusStatus值"+aStatus+"的长度"+aStatus.length()+"大于最大值2");
		Status = aStatus;
	}
	public String getCalType()
	{
		return CalType;
	}
	public void setCalType(String aCalType)
	{
		if(aCalType!=null && aCalType.length()>2)
			throw new IllegalArgumentException("CaltypeCalType值"+aCalType+"的长度"+aCalType.length()+"大于最大值2");
		CalType = aCalType;
	}
	public String getReflectFiled()
	{
		return ReflectFiled;
	}
	public void setReflectFiled(String aReflectFiled)
	{
		if(aReflectFiled!=null && aReflectFiled.length()>50)
			throw new IllegalArgumentException("ReflectfiledReflectFiled值"+aReflectFiled+"的长度"+aReflectFiled.length()+"大于最大值50");
		ReflectFiled = aReflectFiled;
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
	public String getTaxFlag()
	{
		return TaxFlag;
	}
	public void setTaxFlag(String aTaxFlag)
	{
		if(aTaxFlag!=null && aTaxFlag.length()>20)
			throw new IllegalArgumentException("TaxflagTaxFlag值"+aTaxFlag+"的长度"+aTaxFlag.length()+"大于最大值20");
		TaxFlag = aTaxFlag;
	}
	public String getOfferFlag()
	{
		return OfferFlag;
	}
	public void setOfferFlag(String aOfferFlag)
	{
		if(aOfferFlag!=null && aOfferFlag.length()>20)
			throw new IllegalArgumentException("OfferflagOfferFlag值"+aOfferFlag+"的长度"+aOfferFlag.length()+"大于最大值20");
		OfferFlag = aOfferFlag;
	}
	public String getFirstYearFlag()
	{
		return FirstYearFlag;
	}
	public void setFirstYearFlag(String aFirstYearFlag)
	{
		if(aFirstYearFlag!=null && aFirstYearFlag.length()>20)
			throw new IllegalArgumentException("FirstyearflagFirstYearFlag值"+aFirstYearFlag+"的长度"+aFirstYearFlag.length()+"大于最大值20");
		FirstYearFlag = aFirstYearFlag;
	}
	public String getMainSubjectCode()
	{
		return MainSubjectCode;
	}
	public void setMainSubjectCode(String aMainSubjectCode)
	{
		if(aMainSubjectCode!=null && aMainSubjectCode.length()>20)
			throw new IllegalArgumentException("MainsubjectcodeMainSubjectCode值"+aMainSubjectCode+"的长度"+aMainSubjectCode.length()+"大于最大值20");
		MainSubjectCode = aMainSubjectCode;
	}
	public String getSubbranch()
	{
		return Subbranch;
	}
	public void setSubbranch(String aSubbranch)
	{
		if(aSubbranch!=null && aSubbranch.length()>20)
			throw new IllegalArgumentException("SubbranchSubbranch值"+aSubbranch+"的长度"+aSubbranch.length()+"大于最大值20");
		Subbranch = aSubbranch;
	}
	public String getFinanceType()
	{
		return FinanceType;
	}
	public void setFinanceType(String aFinanceType)
	{
		if(aFinanceType!=null && aFinanceType.length()>20)
			throw new IllegalArgumentException("FinancetypeFinanceType值"+aFinanceType+"的长度"+aFinanceType.length()+"大于最大值20");
		FinanceType = aFinanceType;
	}
	public String getAdjustFlag()
	{
		return AdjustFlag;
	}
	public void setAdjustFlag(String aAdjustFlag)
	{
		if(aAdjustFlag!=null && aAdjustFlag.length()>20)
			throw new IllegalArgumentException("AdjustflagAdjustFlag值"+aAdjustFlag+"的长度"+aAdjustFlag.length()+"大于最大值20");
		AdjustFlag = aAdjustFlag;
	}
	public String getCalCode()
	{
		return CalCode;
	}
	public void setCalCode(String aCalCode)
	{
		if(aCalCode!=null && aCalCode.length()>20)
			throw new IllegalArgumentException("CalcodeCalCode值"+aCalCode+"的长度"+aCalCode.length()+"大于最大值20");
		CalCode = aCalCode;
	}
	public double getF1()
	{
		return F1;
	}
	public void setF1(double aF1)
	{
		F1 = aF1;
	}
	public void setF1(String aF1)
	{
		if (aF1 != null && !aF1.equals(""))
		{
			Double tDouble = new Double(aF1);
			double d = tDouble.doubleValue();
			F1 = d;
		}
	}

	public double getF2()
	{
		return F2;
	}
	public void setF2(double aF2)
	{
		F2 = aF2;
	}
	public void setF2(String aF2)
	{
		if (aF2 != null && !aF2.equals(""))
		{
			Double tDouble = new Double(aF2);
			double d = tDouble.doubleValue();
			F2 = d;
		}
	}

	public double getF3()
	{
		return F3;
	}
	public void setF3(double aF3)
	{
		F3 = aF3;
	}
	public void setF3(String aF3)
	{
		if (aF3 != null && !aF3.equals(""))
		{
			Double tDouble = new Double(aF3);
			double d = tDouble.doubleValue();
			F3 = d;
		}
	}

	public double getF4()
	{
		return F4;
	}
	public void setF4(double aF4)
	{
		F4 = aF4;
	}
	public void setF4(String aF4)
	{
		if (aF4 != null && !aF4.equals(""))
		{
			Double tDouble = new Double(aF4);
			double d = tDouble.doubleValue();
			F4 = d;
		}
	}

	public double getF5()
	{
		return F5;
	}
	public void setF5(double aF5)
	{
		F5 = aF5;
	}
	public void setF5(String aF5)
	{
		if (aF5 != null && !aF5.equals(""))
		{
			Double tDouble = new Double(aF5);
			double d = tDouble.doubleValue();
			F5 = d;
		}
	}

	public double getF6()
	{
		return F6;
	}
	public void setF6(double aF6)
	{
		F6 = aF6;
	}
	public void setF6(String aF6)
	{
		if (aF6 != null && !aF6.equals(""))
		{
			Double tDouble = new Double(aF6);
			double d = tDouble.doubleValue();
			F6 = d;
		}
	}


	/**
	* 使用另外一个 LASubjectSchema 对象给 Schema 赋值
	* @param: aLASubjectSchema LASubjectSchema
	**/
	public void setSchema(LASubjectSchema aLASubjectSchema)
	{
		this.Managecom = aLASubjectSchema.getManagecom();
		this.BranchType = aLASubjectSchema.getBranchType();
		this.SubjectCode = aLASubjectSchema.getSubjectCode();
		this.SubjectName = aLASubjectSchema.getSubjectName();
		this.RiskCode = aLASubjectSchema.getRiskCode();
		this.Status = aLASubjectSchema.getStatus();
		this.CalType = aLASubjectSchema.getCalType();
		this.ReflectFiled = aLASubjectSchema.getReflectFiled();
		this.Operator = aLASubjectSchema.getOperator();
		this.MakeDate = fDate.getDate( aLASubjectSchema.getMakeDate());
		this.MakeTime = aLASubjectSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLASubjectSchema.getModifyDate());
		this.ModifyTime = aLASubjectSchema.getModifyTime();
		this.TaxFlag = aLASubjectSchema.getTaxFlag();
		this.OfferFlag = aLASubjectSchema.getOfferFlag();
		this.FirstYearFlag = aLASubjectSchema.getFirstYearFlag();
		this.MainSubjectCode = aLASubjectSchema.getMainSubjectCode();
		this.Subbranch = aLASubjectSchema.getSubbranch();
		this.FinanceType = aLASubjectSchema.getFinanceType();
		this.AdjustFlag = aLASubjectSchema.getAdjustFlag();
		this.CalCode = aLASubjectSchema.getCalCode();
		this.F1 = aLASubjectSchema.getF1();
		this.F2 = aLASubjectSchema.getF2();
		this.F3 = aLASubjectSchema.getF3();
		this.F4 = aLASubjectSchema.getF4();
		this.F5 = aLASubjectSchema.getF5();
		this.F6 = aLASubjectSchema.getF6();
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
			if( rs.getString("Managecom") == null )
				this.Managecom = null;
			else
				this.Managecom = rs.getString("Managecom").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("SubjectCode") == null )
				this.SubjectCode = null;
			else
				this.SubjectCode = rs.getString("SubjectCode").trim();

			if( rs.getString("SubjectName") == null )
				this.SubjectName = null;
			else
				this.SubjectName = rs.getString("SubjectName").trim();

			if( rs.getString("RiskCode") == null )
				this.RiskCode = null;
			else
				this.RiskCode = rs.getString("RiskCode").trim();

			if( rs.getString("Status") == null )
				this.Status = null;
			else
				this.Status = rs.getString("Status").trim();

			if( rs.getString("CalType") == null )
				this.CalType = null;
			else
				this.CalType = rs.getString("CalType").trim();

			if( rs.getString("ReflectFiled") == null )
				this.ReflectFiled = null;
			else
				this.ReflectFiled = rs.getString("ReflectFiled").trim();

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

			if( rs.getString("TaxFlag") == null )
				this.TaxFlag = null;
			else
				this.TaxFlag = rs.getString("TaxFlag").trim();

			if( rs.getString("OfferFlag") == null )
				this.OfferFlag = null;
			else
				this.OfferFlag = rs.getString("OfferFlag").trim();

			if( rs.getString("FirstYearFlag") == null )
				this.FirstYearFlag = null;
			else
				this.FirstYearFlag = rs.getString("FirstYearFlag").trim();

			if( rs.getString("MainSubjectCode") == null )
				this.MainSubjectCode = null;
			else
				this.MainSubjectCode = rs.getString("MainSubjectCode").trim();

			if( rs.getString("Subbranch") == null )
				this.Subbranch = null;
			else
				this.Subbranch = rs.getString("Subbranch").trim();

			if( rs.getString("FinanceType") == null )
				this.FinanceType = null;
			else
				this.FinanceType = rs.getString("FinanceType").trim();

			if( rs.getString("AdjustFlag") == null )
				this.AdjustFlag = null;
			else
				this.AdjustFlag = rs.getString("AdjustFlag").trim();

			if( rs.getString("CalCode") == null )
				this.CalCode = null;
			else
				this.CalCode = rs.getString("CalCode").trim();

			this.F1 = rs.getDouble("F1");
			this.F2 = rs.getDouble("F2");
			this.F3 = rs.getDouble("F3");
			this.F4 = rs.getDouble("F4");
			this.F5 = rs.getDouble("F5");
			this.F6 = rs.getDouble("F6");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LASubject表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LASubjectSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LASubjectSchema getSchema()
	{
		LASubjectSchema aLASubjectSchema = new LASubjectSchema();
		aLASubjectSchema.setSchema(this);
		return aLASubjectSchema;
	}

	public LASubjectDB getDB()
	{
		LASubjectDB aDBOper = new LASubjectDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLASubject描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(Managecom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubjectCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubjectName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Status)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReflectFiled)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TaxFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OfferFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FirstYearFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainSubjectCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Subbranch)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FinanceType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AdjustFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(F1));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(F2));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(F3));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(F4));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(F5));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(F6));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLASubject>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			Managecom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			SubjectCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			SubjectName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			RiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Status = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			CalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			ReflectFiled = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			TaxFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			OfferFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			FirstYearFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			MainSubjectCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			Subbranch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			FinanceType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			AdjustFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			CalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			F1 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,22,SysConst.PACKAGESPILTER))).doubleValue();
			F2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,23,SysConst.PACKAGESPILTER))).doubleValue();
			F3 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,24,SysConst.PACKAGESPILTER))).doubleValue();
			F4 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,25,SysConst.PACKAGESPILTER))).doubleValue();
			F5 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,26,SysConst.PACKAGESPILTER))).doubleValue();
			F6 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,27,SysConst.PACKAGESPILTER))).doubleValue();
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LASubjectSchema";
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
		if (FCode.equalsIgnoreCase("Managecom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Managecom));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("SubjectCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectCode));
		}
		if (FCode.equalsIgnoreCase("SubjectName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectName));
		}
		if (FCode.equalsIgnoreCase("RiskCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskCode));
		}
		if (FCode.equalsIgnoreCase("Status"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Status));
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalType));
		}
		if (FCode.equalsIgnoreCase("ReflectFiled"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReflectFiled));
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
		if (FCode.equalsIgnoreCase("TaxFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TaxFlag));
		}
		if (FCode.equalsIgnoreCase("OfferFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OfferFlag));
		}
		if (FCode.equalsIgnoreCase("FirstYearFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FirstYearFlag));
		}
		if (FCode.equalsIgnoreCase("MainSubjectCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainSubjectCode));
		}
		if (FCode.equalsIgnoreCase("Subbranch"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Subbranch));
		}
		if (FCode.equalsIgnoreCase("FinanceType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FinanceType));
		}
		if (FCode.equalsIgnoreCase("AdjustFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AdjustFlag));
		}
		if (FCode.equalsIgnoreCase("CalCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalCode));
		}
		if (FCode.equalsIgnoreCase("F1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(F1));
		}
		if (FCode.equalsIgnoreCase("F2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(F2));
		}
		if (FCode.equalsIgnoreCase("F3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(F3));
		}
		if (FCode.equalsIgnoreCase("F4"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(F4));
		}
		if (FCode.equalsIgnoreCase("F5"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(F5));
		}
		if (FCode.equalsIgnoreCase("F6"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(F6));
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
				strFieldValue = StrTool.GBKToUnicode(Managecom);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(SubjectCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(SubjectName);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(RiskCode);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Status);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(CalType);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(ReflectFiled);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(TaxFlag);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(OfferFlag);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(FirstYearFlag);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(MainSubjectCode);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(Subbranch);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(FinanceType);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(AdjustFlag);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(CalCode);
				break;
			case 21:
				strFieldValue = String.valueOf(F1);
				break;
			case 22:
				strFieldValue = String.valueOf(F2);
				break;
			case 23:
				strFieldValue = String.valueOf(F3);
				break;
			case 24:
				strFieldValue = String.valueOf(F4);
				break;
			case 25:
				strFieldValue = String.valueOf(F5);
				break;
			case 26:
				strFieldValue = String.valueOf(F6);
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

		if (FCode.equalsIgnoreCase("Managecom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Managecom = FValue.trim();
			}
			else
				Managecom = null;
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
		}
		if (FCode.equalsIgnoreCase("SubjectCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SubjectCode = FValue.trim();
			}
			else
				SubjectCode = null;
		}
		if (FCode.equalsIgnoreCase("SubjectName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SubjectName = FValue.trim();
			}
			else
				SubjectName = null;
		}
		if (FCode.equalsIgnoreCase("RiskCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskCode = FValue.trim();
			}
			else
				RiskCode = null;
		}
		if (FCode.equalsIgnoreCase("Status"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Status = FValue.trim();
			}
			else
				Status = null;
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalType = FValue.trim();
			}
			else
				CalType = null;
		}
		if (FCode.equalsIgnoreCase("ReflectFiled"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReflectFiled = FValue.trim();
			}
			else
				ReflectFiled = null;
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
		if (FCode.equalsIgnoreCase("TaxFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TaxFlag = FValue.trim();
			}
			else
				TaxFlag = null;
		}
		if (FCode.equalsIgnoreCase("OfferFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OfferFlag = FValue.trim();
			}
			else
				OfferFlag = null;
		}
		if (FCode.equalsIgnoreCase("FirstYearFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FirstYearFlag = FValue.trim();
			}
			else
				FirstYearFlag = null;
		}
		if (FCode.equalsIgnoreCase("MainSubjectCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MainSubjectCode = FValue.trim();
			}
			else
				MainSubjectCode = null;
		}
		if (FCode.equalsIgnoreCase("Subbranch"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Subbranch = FValue.trim();
			}
			else
				Subbranch = null;
		}
		if (FCode.equalsIgnoreCase("FinanceType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FinanceType = FValue.trim();
			}
			else
				FinanceType = null;
		}
		if (FCode.equalsIgnoreCase("AdjustFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AdjustFlag = FValue.trim();
			}
			else
				AdjustFlag = null;
		}
		if (FCode.equalsIgnoreCase("CalCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalCode = FValue.trim();
			}
			else
				CalCode = null;
		}
		if (FCode.equalsIgnoreCase("F1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				F1 = d;
			}
		}
		if (FCode.equalsIgnoreCase("F2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				F2 = d;
			}
		}
		if (FCode.equalsIgnoreCase("F3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				F3 = d;
			}
		}
		if (FCode.equalsIgnoreCase("F4"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				F4 = d;
			}
		}
		if (FCode.equalsIgnoreCase("F5"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				F5 = d;
			}
		}
		if (FCode.equalsIgnoreCase("F6"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				F6 = d;
			}
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LASubjectSchema other = (LASubjectSchema)otherObject;
		return
			Managecom.equals(other.getManagecom())
			&& BranchType.equals(other.getBranchType())
			&& SubjectCode.equals(other.getSubjectCode())
			&& SubjectName.equals(other.getSubjectName())
			&& RiskCode.equals(other.getRiskCode())
			&& Status.equals(other.getStatus())
			&& CalType.equals(other.getCalType())
			&& ReflectFiled.equals(other.getReflectFiled())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& TaxFlag.equals(other.getTaxFlag())
			&& OfferFlag.equals(other.getOfferFlag())
			&& FirstYearFlag.equals(other.getFirstYearFlag())
			&& MainSubjectCode.equals(other.getMainSubjectCode())
			&& Subbranch.equals(other.getSubbranch())
			&& FinanceType.equals(other.getFinanceType())
			&& AdjustFlag.equals(other.getAdjustFlag())
			&& CalCode.equals(other.getCalCode())
			&& F1 == other.getF1()
			&& F2 == other.getF2()
			&& F3 == other.getF3()
			&& F4 == other.getF4()
			&& F5 == other.getF5()
			&& F6 == other.getF6();
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
		if( strFieldName.equals("Managecom") ) {
			return 0;
		}
		if( strFieldName.equals("BranchType") ) {
			return 1;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return 2;
		}
		if( strFieldName.equals("SubjectName") ) {
			return 3;
		}
		if( strFieldName.equals("RiskCode") ) {
			return 4;
		}
		if( strFieldName.equals("Status") ) {
			return 5;
		}
		if( strFieldName.equals("CalType") ) {
			return 6;
		}
		if( strFieldName.equals("ReflectFiled") ) {
			return 7;
		}
		if( strFieldName.equals("Operator") ) {
			return 8;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 9;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 10;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 11;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 12;
		}
		if( strFieldName.equals("TaxFlag") ) {
			return 13;
		}
		if( strFieldName.equals("OfferFlag") ) {
			return 14;
		}
		if( strFieldName.equals("FirstYearFlag") ) {
			return 15;
		}
		if( strFieldName.equals("MainSubjectCode") ) {
			return 16;
		}
		if( strFieldName.equals("Subbranch") ) {
			return 17;
		}
		if( strFieldName.equals("FinanceType") ) {
			return 18;
		}
		if( strFieldName.equals("AdjustFlag") ) {
			return 19;
		}
		if( strFieldName.equals("CalCode") ) {
			return 20;
		}
		if( strFieldName.equals("F1") ) {
			return 21;
		}
		if( strFieldName.equals("F2") ) {
			return 22;
		}
		if( strFieldName.equals("F3") ) {
			return 23;
		}
		if( strFieldName.equals("F4") ) {
			return 24;
		}
		if( strFieldName.equals("F5") ) {
			return 25;
		}
		if( strFieldName.equals("F6") ) {
			return 26;
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
				strFieldName = "Managecom";
				break;
			case 1:
				strFieldName = "BranchType";
				break;
			case 2:
				strFieldName = "SubjectCode";
				break;
			case 3:
				strFieldName = "SubjectName";
				break;
			case 4:
				strFieldName = "RiskCode";
				break;
			case 5:
				strFieldName = "Status";
				break;
			case 6:
				strFieldName = "CalType";
				break;
			case 7:
				strFieldName = "ReflectFiled";
				break;
			case 8:
				strFieldName = "Operator";
				break;
			case 9:
				strFieldName = "MakeDate";
				break;
			case 10:
				strFieldName = "MakeTime";
				break;
			case 11:
				strFieldName = "ModifyDate";
				break;
			case 12:
				strFieldName = "ModifyTime";
				break;
			case 13:
				strFieldName = "TaxFlag";
				break;
			case 14:
				strFieldName = "OfferFlag";
				break;
			case 15:
				strFieldName = "FirstYearFlag";
				break;
			case 16:
				strFieldName = "MainSubjectCode";
				break;
			case 17:
				strFieldName = "Subbranch";
				break;
			case 18:
				strFieldName = "FinanceType";
				break;
			case 19:
				strFieldName = "AdjustFlag";
				break;
			case 20:
				strFieldName = "CalCode";
				break;
			case 21:
				strFieldName = "F1";
				break;
			case 22:
				strFieldName = "F2";
				break;
			case 23:
				strFieldName = "F3";
				break;
			case 24:
				strFieldName = "F4";
				break;
			case 25:
				strFieldName = "F5";
				break;
			case 26:
				strFieldName = "F6";
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
		if( strFieldName.equals("Managecom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubjectName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Status") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReflectFiled") ) {
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
		if( strFieldName.equals("TaxFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OfferFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FirstYearFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainSubjectCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Subbranch") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FinanceType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AdjustFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("F1") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("F2") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("F3") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("F4") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("F5") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("F6") ) {
			return Schema.TYPE_DOUBLE;
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
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 22:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 23:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 24:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 25:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 26:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
