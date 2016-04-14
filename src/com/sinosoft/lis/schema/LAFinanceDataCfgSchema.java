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
import com.sinosoft.lis.db.LAFinanceDataCfgDB;

/*
 * <p>ClassName: LAFinanceDataCfgSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAFinanceDataCfgSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAFinanceDataCfgSchema.class);
	// @Field
	/** Smonth */
	private String SMonth;
	/** Emonth */
	private String EMonth;
	/** Reportcode */
	private String ReportCode;
	/** Reportname */
	private String ReportName;
	/** Titlecode */
	private String TitleCode;
	/** Titlename */
	private String TitleName;
	/** Dcflag */
	private String DCFlag;
	/** Description */
	private String Description;
	/** B1 */
	private String B1;
	/** B2 */
	private String B2;
	/** B3 */
	private String B3;
	/** B4 */
	private String B4;
	/** B5 */
	private String B5;
	/** B6 */
	private String B6;
	/** B7 */
	private String B7;
	/** B8 */
	private String B8;
	/** B9 */
	private String B9;
	/** B10 */
	private String B10;
	/** B11 */
	private String B11;
	/** B12 */
	private String B12;
	/** B13 */
	private String B13;
	/** B14 */
	private String B14;
	/** B15 */
	private String B15;
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

	public static final int FIELDNUM = 28;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAFinanceDataCfgSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "SMonth";
		pk[1] = "EMonth";
		pk[2] = "ReportCode";
		pk[3] = "TitleCode";

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
		LAFinanceDataCfgSchema cloned = (LAFinanceDataCfgSchema)super.clone();
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
	* 生效区间起始月
	*/
	public String getSMonth()
	{
		return SMonth;
	}
	public void setSMonth(String aSMonth)
	{
		if(aSMonth!=null && aSMonth.length()>6)
			throw new IllegalArgumentException("SmonthSMonth值"+aSMonth+"的长度"+aSMonth.length()+"大于最大值6");
		SMonth = aSMonth;
	}
	/**
	* 生效区间截止月
	*/
	public String getEMonth()
	{
		return EMonth;
	}
	public void setEMonth(String aEMonth)
	{
		if(aEMonth!=null && aEMonth.length()>6)
			throw new IllegalArgumentException("EmonthEMonth值"+aEMonth+"的长度"+aEMonth.length()+"大于最大值6");
		EMonth = aEMonth;
	}
	/**
	* 财务报表类型
	*/
	public String getReportCode()
	{
		return ReportCode;
	}
	public void setReportCode(String aReportCode)
	{
		if(aReportCode!=null && aReportCode.length()>30)
			throw new IllegalArgumentException("ReportcodeReportCode值"+aReportCode+"的长度"+aReportCode.length()+"大于最大值30");
		ReportCode = aReportCode;
	}
	/**
	* 财务报表名称
	*/
	public String getReportName()
	{
		return ReportName;
	}
	public void setReportName(String aReportName)
	{
		if(aReportName!=null && aReportName.length()>100)
			throw new IllegalArgumentException("ReportnameReportName值"+aReportName+"的长度"+aReportName.length()+"大于最大值100");
		ReportName = aReportName;
	}
	/**
	* 报表展示科目编码
	*/
	public String getTitleCode()
	{
		return TitleCode;
	}
	public void setTitleCode(String aTitleCode)
	{
		if(aTitleCode!=null && aTitleCode.length()>30)
			throw new IllegalArgumentException("TitlecodeTitleCode值"+aTitleCode+"的长度"+aTitleCode.length()+"大于最大值30");
		TitleCode = aTitleCode;
	}
	/**
	* 报表展示科目名称
	*/
	public String getTitleName()
	{
		return TitleName;
	}
	public void setTitleName(String aTitleName)
	{
		if(aTitleName!=null && aTitleName.length()>100)
			throw new IllegalArgumentException("TitlenameTitleName值"+aTitleName+"的长度"+aTitleName.length()+"大于最大值100");
		TitleName = aTitleName;
	}
	/**
	* Debit/Credit标志
	*/
	public String getDCFlag()
	{
		return DCFlag;
	}
	public void setDCFlag(String aDCFlag)
	{
		if(aDCFlag!=null && aDCFlag.length()>1)
			throw new IllegalArgumentException("DcflagDCFlag值"+aDCFlag+"的长度"+aDCFlag.length()+"大于最大值1");
		DCFlag = aDCFlag;
	}
	/**
	* 说明
	*/
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String aDescription)
	{
		if(aDescription!=null && aDescription.length()>1000)
			throw new IllegalArgumentException("DescriptionDescription值"+aDescription+"的长度"+aDescription.length()+"大于最大值1000");
		Description = aDescription;
	}
	/**
	* 备用1
	*/
	public String getB1()
	{
		return B1;
	}
	public void setB1(String aB1)
	{
		if(aB1!=null && aB1.length()>100)
			throw new IllegalArgumentException("B1B1值"+aB1+"的长度"+aB1.length()+"大于最大值100");
		B1 = aB1;
	}
	public String getB2()
	{
		return B2;
	}
	public void setB2(String aB2)
	{
		if(aB2!=null && aB2.length()>100)
			throw new IllegalArgumentException("B2B2值"+aB2+"的长度"+aB2.length()+"大于最大值100");
		B2 = aB2;
	}
	public String getB3()
	{
		return B3;
	}
	public void setB3(String aB3)
	{
		if(aB3!=null && aB3.length()>100)
			throw new IllegalArgumentException("B3B3值"+aB3+"的长度"+aB3.length()+"大于最大值100");
		B3 = aB3;
	}
	public String getB4()
	{
		return B4;
	}
	public void setB4(String aB4)
	{
		if(aB4!=null && aB4.length()>100)
			throw new IllegalArgumentException("B4B4值"+aB4+"的长度"+aB4.length()+"大于最大值100");
		B4 = aB4;
	}
	public String getB5()
	{
		return B5;
	}
	public void setB5(String aB5)
	{
		if(aB5!=null && aB5.length()>100)
			throw new IllegalArgumentException("B5B5值"+aB5+"的长度"+aB5.length()+"大于最大值100");
		B5 = aB5;
	}
	public String getB6()
	{
		return B6;
	}
	public void setB6(String aB6)
	{
		if(aB6!=null && aB6.length()>100)
			throw new IllegalArgumentException("B6B6值"+aB6+"的长度"+aB6.length()+"大于最大值100");
		B6 = aB6;
	}
	public String getB7()
	{
		return B7;
	}
	public void setB7(String aB7)
	{
		if(aB7!=null && aB7.length()>100)
			throw new IllegalArgumentException("B7B7值"+aB7+"的长度"+aB7.length()+"大于最大值100");
		B7 = aB7;
	}
	public String getB8()
	{
		return B8;
	}
	public void setB8(String aB8)
	{
		if(aB8!=null && aB8.length()>100)
			throw new IllegalArgumentException("B8B8值"+aB8+"的长度"+aB8.length()+"大于最大值100");
		B8 = aB8;
	}
	public String getB9()
	{
		return B9;
	}
	public void setB9(String aB9)
	{
		if(aB9!=null && aB9.length()>100)
			throw new IllegalArgumentException("B9B9值"+aB9+"的长度"+aB9.length()+"大于最大值100");
		B9 = aB9;
	}
	public String getB10()
	{
		return B10;
	}
	public void setB10(String aB10)
	{
		if(aB10!=null && aB10.length()>100)
			throw new IllegalArgumentException("B10B10值"+aB10+"的长度"+aB10.length()+"大于最大值100");
		B10 = aB10;
	}
	public String getB11()
	{
		return B11;
	}
	public void setB11(String aB11)
	{
		if(aB11!=null && aB11.length()>100)
			throw new IllegalArgumentException("B11B11值"+aB11+"的长度"+aB11.length()+"大于最大值100");
		B11 = aB11;
	}
	public String getB12()
	{
		return B12;
	}
	public void setB12(String aB12)
	{
		if(aB12!=null && aB12.length()>100)
			throw new IllegalArgumentException("B12B12值"+aB12+"的长度"+aB12.length()+"大于最大值100");
		B12 = aB12;
	}
	public String getB13()
	{
		return B13;
	}
	public void setB13(String aB13)
	{
		if(aB13!=null && aB13.length()>100)
			throw new IllegalArgumentException("B13B13值"+aB13+"的长度"+aB13.length()+"大于最大值100");
		B13 = aB13;
	}
	public String getB14()
	{
		return B14;
	}
	public void setB14(String aB14)
	{
		if(aB14!=null && aB14.length()>100)
			throw new IllegalArgumentException("B14B14值"+aB14+"的长度"+aB14.length()+"大于最大值100");
		B14 = aB14;
	}
	public String getB15()
	{
		return B15;
	}
	public void setB15(String aB15)
	{
		if(aB15!=null && aB15.length()>100)
			throw new IllegalArgumentException("B15B15值"+aB15+"的长度"+aB15.length()+"大于最大值100");
		B15 = aB15;
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
		if(aOperator!=null && aOperator.length()>100)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值100");
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
	* 使用另外一个 LAFinanceDataCfgSchema 对象给 Schema 赋值
	* @param: aLAFinanceDataCfgSchema LAFinanceDataCfgSchema
	**/
	public void setSchema(LAFinanceDataCfgSchema aLAFinanceDataCfgSchema)
	{
		this.SMonth = aLAFinanceDataCfgSchema.getSMonth();
		this.EMonth = aLAFinanceDataCfgSchema.getEMonth();
		this.ReportCode = aLAFinanceDataCfgSchema.getReportCode();
		this.ReportName = aLAFinanceDataCfgSchema.getReportName();
		this.TitleCode = aLAFinanceDataCfgSchema.getTitleCode();
		this.TitleName = aLAFinanceDataCfgSchema.getTitleName();
		this.DCFlag = aLAFinanceDataCfgSchema.getDCFlag();
		this.Description = aLAFinanceDataCfgSchema.getDescription();
		this.B1 = aLAFinanceDataCfgSchema.getB1();
		this.B2 = aLAFinanceDataCfgSchema.getB2();
		this.B3 = aLAFinanceDataCfgSchema.getB3();
		this.B4 = aLAFinanceDataCfgSchema.getB4();
		this.B5 = aLAFinanceDataCfgSchema.getB5();
		this.B6 = aLAFinanceDataCfgSchema.getB6();
		this.B7 = aLAFinanceDataCfgSchema.getB7();
		this.B8 = aLAFinanceDataCfgSchema.getB8();
		this.B9 = aLAFinanceDataCfgSchema.getB9();
		this.B10 = aLAFinanceDataCfgSchema.getB10();
		this.B11 = aLAFinanceDataCfgSchema.getB11();
		this.B12 = aLAFinanceDataCfgSchema.getB12();
		this.B13 = aLAFinanceDataCfgSchema.getB13();
		this.B14 = aLAFinanceDataCfgSchema.getB14();
		this.B15 = aLAFinanceDataCfgSchema.getB15();
		this.Operator = aLAFinanceDataCfgSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAFinanceDataCfgSchema.getMakeDate());
		this.MakeTime = aLAFinanceDataCfgSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAFinanceDataCfgSchema.getModifyDate());
		this.ModifyTime = aLAFinanceDataCfgSchema.getModifyTime();
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
			if( rs.getString("SMonth") == null )
				this.SMonth = null;
			else
				this.SMonth = rs.getString("SMonth").trim();

			if( rs.getString("EMonth") == null )
				this.EMonth = null;
			else
				this.EMonth = rs.getString("EMonth").trim();

			if( rs.getString("ReportCode") == null )
				this.ReportCode = null;
			else
				this.ReportCode = rs.getString("ReportCode").trim();

			if( rs.getString("ReportName") == null )
				this.ReportName = null;
			else
				this.ReportName = rs.getString("ReportName").trim();

			if( rs.getString("TitleCode") == null )
				this.TitleCode = null;
			else
				this.TitleCode = rs.getString("TitleCode").trim();

			if( rs.getString("TitleName") == null )
				this.TitleName = null;
			else
				this.TitleName = rs.getString("TitleName").trim();

			if( rs.getString("DCFlag") == null )
				this.DCFlag = null;
			else
				this.DCFlag = rs.getString("DCFlag").trim();

			if( rs.getString("Description") == null )
				this.Description = null;
			else
				this.Description = rs.getString("Description").trim();

			if( rs.getString("B1") == null )
				this.B1 = null;
			else
				this.B1 = rs.getString("B1").trim();

			if( rs.getString("B2") == null )
				this.B2 = null;
			else
				this.B2 = rs.getString("B2").trim();

			if( rs.getString("B3") == null )
				this.B3 = null;
			else
				this.B3 = rs.getString("B3").trim();

			if( rs.getString("B4") == null )
				this.B4 = null;
			else
				this.B4 = rs.getString("B4").trim();

			if( rs.getString("B5") == null )
				this.B5 = null;
			else
				this.B5 = rs.getString("B5").trim();

			if( rs.getString("B6") == null )
				this.B6 = null;
			else
				this.B6 = rs.getString("B6").trim();

			if( rs.getString("B7") == null )
				this.B7 = null;
			else
				this.B7 = rs.getString("B7").trim();

			if( rs.getString("B8") == null )
				this.B8 = null;
			else
				this.B8 = rs.getString("B8").trim();

			if( rs.getString("B9") == null )
				this.B9 = null;
			else
				this.B9 = rs.getString("B9").trim();

			if( rs.getString("B10") == null )
				this.B10 = null;
			else
				this.B10 = rs.getString("B10").trim();

			if( rs.getString("B11") == null )
				this.B11 = null;
			else
				this.B11 = rs.getString("B11").trim();

			if( rs.getString("B12") == null )
				this.B12 = null;
			else
				this.B12 = rs.getString("B12").trim();

			if( rs.getString("B13") == null )
				this.B13 = null;
			else
				this.B13 = rs.getString("B13").trim();

			if( rs.getString("B14") == null )
				this.B14 = null;
			else
				this.B14 = rs.getString("B14").trim();

			if( rs.getString("B15") == null )
				this.B15 = null;
			else
				this.B15 = rs.getString("B15").trim();

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
			logger.debug("数据库中的LAFinanceDataCfg表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAFinanceDataCfgSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAFinanceDataCfgSchema getSchema()
	{
		LAFinanceDataCfgSchema aLAFinanceDataCfgSchema = new LAFinanceDataCfgSchema();
		aLAFinanceDataCfgSchema.setSchema(this);
		return aLAFinanceDataCfgSchema;
	}

	public LAFinanceDataCfgDB getDB()
	{
		LAFinanceDataCfgDB aDBOper = new LAFinanceDataCfgDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAFinanceDataCfg描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(SMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReportCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReportName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TitleCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TitleName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DCFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Description)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B4)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B5)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B6)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B7)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B8)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B9)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B10)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B11)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B12)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B13)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B14)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B15)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAFinanceDataCfg>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			SMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			EMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ReportCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ReportName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			TitleCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			TitleName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			DCFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			B1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			B2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			B3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			B4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			B5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			B6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			B7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			B8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			B9 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			B10 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			B11 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			B12 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			B13 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			B14 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			B15 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAFinanceDataCfgSchema";
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
		if (FCode.equalsIgnoreCase("SMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SMonth));
		}
		if (FCode.equalsIgnoreCase("EMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EMonth));
		}
		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReportCode));
		}
		if (FCode.equalsIgnoreCase("ReportName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReportName));
		}
		if (FCode.equalsIgnoreCase("TitleCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TitleCode));
		}
		if (FCode.equalsIgnoreCase("TitleName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TitleName));
		}
		if (FCode.equalsIgnoreCase("DCFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DCFlag));
		}
		if (FCode.equalsIgnoreCase("Description"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Description));
		}
		if (FCode.equalsIgnoreCase("B1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B1));
		}
		if (FCode.equalsIgnoreCase("B2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B2));
		}
		if (FCode.equalsIgnoreCase("B3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B3));
		}
		if (FCode.equalsIgnoreCase("B4"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B4));
		}
		if (FCode.equalsIgnoreCase("B5"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B5));
		}
		if (FCode.equalsIgnoreCase("B6"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B6));
		}
		if (FCode.equalsIgnoreCase("B7"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B7));
		}
		if (FCode.equalsIgnoreCase("B8"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B8));
		}
		if (FCode.equalsIgnoreCase("B9"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B9));
		}
		if (FCode.equalsIgnoreCase("B10"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B10));
		}
		if (FCode.equalsIgnoreCase("B11"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B11));
		}
		if (FCode.equalsIgnoreCase("B12"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B12));
		}
		if (FCode.equalsIgnoreCase("B13"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B13));
		}
		if (FCode.equalsIgnoreCase("B14"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B14));
		}
		if (FCode.equalsIgnoreCase("B15"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B15));
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
				strFieldValue = StrTool.GBKToUnicode(SMonth);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(EMonth);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ReportCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ReportName);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(TitleCode);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(TitleName);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(DCFlag);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Description);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(B1);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(B2);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(B3);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(B4);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(B5);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(B6);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(B7);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(B8);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(B9);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(B10);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(B11);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(B12);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(B13);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(B14);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(B15);
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

		if (FCode.equalsIgnoreCase("SMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SMonth = FValue.trim();
			}
			else
				SMonth = null;
		}
		if (FCode.equalsIgnoreCase("EMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EMonth = FValue.trim();
			}
			else
				EMonth = null;
		}
		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReportCode = FValue.trim();
			}
			else
				ReportCode = null;
		}
		if (FCode.equalsIgnoreCase("ReportName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReportName = FValue.trim();
			}
			else
				ReportName = null;
		}
		if (FCode.equalsIgnoreCase("TitleCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TitleCode = FValue.trim();
			}
			else
				TitleCode = null;
		}
		if (FCode.equalsIgnoreCase("TitleName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TitleName = FValue.trim();
			}
			else
				TitleName = null;
		}
		if (FCode.equalsIgnoreCase("DCFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DCFlag = FValue.trim();
			}
			else
				DCFlag = null;
		}
		if (FCode.equalsIgnoreCase("Description"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Description = FValue.trim();
			}
			else
				Description = null;
		}
		if (FCode.equalsIgnoreCase("B1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B1 = FValue.trim();
			}
			else
				B1 = null;
		}
		if (FCode.equalsIgnoreCase("B2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B2 = FValue.trim();
			}
			else
				B2 = null;
		}
		if (FCode.equalsIgnoreCase("B3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B3 = FValue.trim();
			}
			else
				B3 = null;
		}
		if (FCode.equalsIgnoreCase("B4"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B4 = FValue.trim();
			}
			else
				B4 = null;
		}
		if (FCode.equalsIgnoreCase("B5"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B5 = FValue.trim();
			}
			else
				B5 = null;
		}
		if (FCode.equalsIgnoreCase("B6"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B6 = FValue.trim();
			}
			else
				B6 = null;
		}
		if (FCode.equalsIgnoreCase("B7"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B7 = FValue.trim();
			}
			else
				B7 = null;
		}
		if (FCode.equalsIgnoreCase("B8"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B8 = FValue.trim();
			}
			else
				B8 = null;
		}
		if (FCode.equalsIgnoreCase("B9"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B9 = FValue.trim();
			}
			else
				B9 = null;
		}
		if (FCode.equalsIgnoreCase("B10"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B10 = FValue.trim();
			}
			else
				B10 = null;
		}
		if (FCode.equalsIgnoreCase("B11"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B11 = FValue.trim();
			}
			else
				B11 = null;
		}
		if (FCode.equalsIgnoreCase("B12"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B12 = FValue.trim();
			}
			else
				B12 = null;
		}
		if (FCode.equalsIgnoreCase("B13"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B13 = FValue.trim();
			}
			else
				B13 = null;
		}
		if (FCode.equalsIgnoreCase("B14"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B14 = FValue.trim();
			}
			else
				B14 = null;
		}
		if (FCode.equalsIgnoreCase("B15"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B15 = FValue.trim();
			}
			else
				B15 = null;
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
		LAFinanceDataCfgSchema other = (LAFinanceDataCfgSchema)otherObject;
		return
			SMonth.equals(other.getSMonth())
			&& EMonth.equals(other.getEMonth())
			&& ReportCode.equals(other.getReportCode())
			&& ReportName.equals(other.getReportName())
			&& TitleCode.equals(other.getTitleCode())
			&& TitleName.equals(other.getTitleName())
			&& DCFlag.equals(other.getDCFlag())
			&& Description.equals(other.getDescription())
			&& B1.equals(other.getB1())
			&& B2.equals(other.getB2())
			&& B3.equals(other.getB3())
			&& B4.equals(other.getB4())
			&& B5.equals(other.getB5())
			&& B6.equals(other.getB6())
			&& B7.equals(other.getB7())
			&& B8.equals(other.getB8())
			&& B9.equals(other.getB9())
			&& B10.equals(other.getB10())
			&& B11.equals(other.getB11())
			&& B12.equals(other.getB12())
			&& B13.equals(other.getB13())
			&& B14.equals(other.getB14())
			&& B15.equals(other.getB15())
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
		if( strFieldName.equals("SMonth") ) {
			return 0;
		}
		if( strFieldName.equals("EMonth") ) {
			return 1;
		}
		if( strFieldName.equals("ReportCode") ) {
			return 2;
		}
		if( strFieldName.equals("ReportName") ) {
			return 3;
		}
		if( strFieldName.equals("TitleCode") ) {
			return 4;
		}
		if( strFieldName.equals("TitleName") ) {
			return 5;
		}
		if( strFieldName.equals("DCFlag") ) {
			return 6;
		}
		if( strFieldName.equals("Description") ) {
			return 7;
		}
		if( strFieldName.equals("B1") ) {
			return 8;
		}
		if( strFieldName.equals("B2") ) {
			return 9;
		}
		if( strFieldName.equals("B3") ) {
			return 10;
		}
		if( strFieldName.equals("B4") ) {
			return 11;
		}
		if( strFieldName.equals("B5") ) {
			return 12;
		}
		if( strFieldName.equals("B6") ) {
			return 13;
		}
		if( strFieldName.equals("B7") ) {
			return 14;
		}
		if( strFieldName.equals("B8") ) {
			return 15;
		}
		if( strFieldName.equals("B9") ) {
			return 16;
		}
		if( strFieldName.equals("B10") ) {
			return 17;
		}
		if( strFieldName.equals("B11") ) {
			return 18;
		}
		if( strFieldName.equals("B12") ) {
			return 19;
		}
		if( strFieldName.equals("B13") ) {
			return 20;
		}
		if( strFieldName.equals("B14") ) {
			return 21;
		}
		if( strFieldName.equals("B15") ) {
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
				strFieldName = "SMonth";
				break;
			case 1:
				strFieldName = "EMonth";
				break;
			case 2:
				strFieldName = "ReportCode";
				break;
			case 3:
				strFieldName = "ReportName";
				break;
			case 4:
				strFieldName = "TitleCode";
				break;
			case 5:
				strFieldName = "TitleName";
				break;
			case 6:
				strFieldName = "DCFlag";
				break;
			case 7:
				strFieldName = "Description";
				break;
			case 8:
				strFieldName = "B1";
				break;
			case 9:
				strFieldName = "B2";
				break;
			case 10:
				strFieldName = "B3";
				break;
			case 11:
				strFieldName = "B4";
				break;
			case 12:
				strFieldName = "B5";
				break;
			case 13:
				strFieldName = "B6";
				break;
			case 14:
				strFieldName = "B7";
				break;
			case 15:
				strFieldName = "B8";
				break;
			case 16:
				strFieldName = "B9";
				break;
			case 17:
				strFieldName = "B10";
				break;
			case 18:
				strFieldName = "B11";
				break;
			case 19:
				strFieldName = "B12";
				break;
			case 20:
				strFieldName = "B13";
				break;
			case 21:
				strFieldName = "B14";
				break;
			case 22:
				strFieldName = "B15";
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
		if( strFieldName.equals("SMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReportCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReportName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TitleCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TitleName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DCFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Description") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B3") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B4") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B5") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B6") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B7") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B8") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B9") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B10") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B11") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B12") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B13") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B14") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B15") ) {
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
