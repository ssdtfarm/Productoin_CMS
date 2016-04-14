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
import com.sinosoft.lis.db.LACPDBDB;

/*
 * <p>ClassName: LACPDBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LACPDBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LACPDBSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Coursename */
	private String CourseName;
	/** Hkcaavqcode */
	private String HKCAAVQCode;
	/** Coursedate */
	private Date CourseDate;
	/** Regulatorytype1 */
	private String RegulatoryType1;
	/** Regulatorytype2 */
	private String RegulatoryType2;
	/** Regulatorytype3 */
	private String RegulatoryType3;
	/** Cpdhourtype1 */
	private String CPDHourType1;
	/** Cpdhourtype2 */
	private String CPDHourType2;
	/** Cpdhourtype3 */
	private String CPDHourType3;
	/** Cpdhour1 */
	private String CPDHour1;
	/** Cpdhour2 */
	private String CPDHour2;
	/** Cpdhour3 */
	private String CPDHour3;
	/** Reportingperiod */
	private Date ReportingPeriod;
	/** Remark */
	private String Remark;
	/** Eligibleamounts */
	private double EligibleAmounts;
	/** Reimbursedamount */
	private double ReimbursedAmount;
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

	public static final int FIELDNUM = 25;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LACPDBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[5];
		pk[0] = "AgentCode";
		pk[1] = "HKCAAVQCode";
		pk[2] = "Operator1";
		pk[3] = "MakeDate1";
		pk[4] = "MakeTime1";

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
		LACPDBSchema cloned = (LACPDBSchema)super.clone();
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
	public String getCourseName()
	{
		return CourseName;
	}
	public void setCourseName(String aCourseName)
	{
		if(aCourseName!=null && aCourseName.length()>20)
			throw new IllegalArgumentException("CoursenameCourseName值"+aCourseName+"的长度"+aCourseName.length()+"大于最大值20");
		CourseName = aCourseName;
	}
	public String getHKCAAVQCode()
	{
		return HKCAAVQCode;
	}
	public void setHKCAAVQCode(String aHKCAAVQCode)
	{
		if(aHKCAAVQCode!=null && aHKCAAVQCode.length()>20)
			throw new IllegalArgumentException("HkcaavqcodeHKCAAVQCode值"+aHKCAAVQCode+"的长度"+aHKCAAVQCode.length()+"大于最大值20");
		HKCAAVQCode = aHKCAAVQCode;
	}
	public String getCourseDate()
	{
		if( CourseDate != null )
			return fDate.getString(CourseDate);
		else
			return null;
	}
	public void setCourseDate(Date aCourseDate)
	{
		CourseDate = aCourseDate;
	}
	public void setCourseDate(String aCourseDate)
	{
		if (aCourseDate != null && !aCourseDate.equals("") )
		{
			CourseDate = fDate.getDate( aCourseDate );
		}
		else
			CourseDate = null;
	}

	public String getRegulatoryType1()
	{
		return RegulatoryType1;
	}
	public void setRegulatoryType1(String aRegulatoryType1)
	{
		if(aRegulatoryType1!=null && aRegulatoryType1.length()>2)
			throw new IllegalArgumentException("Regulatorytype1RegulatoryType1值"+aRegulatoryType1+"的长度"+aRegulatoryType1.length()+"大于最大值2");
		RegulatoryType1 = aRegulatoryType1;
	}
	public String getRegulatoryType2()
	{
		return RegulatoryType2;
	}
	public void setRegulatoryType2(String aRegulatoryType2)
	{
		if(aRegulatoryType2!=null && aRegulatoryType2.length()>2)
			throw new IllegalArgumentException("Regulatorytype2RegulatoryType2值"+aRegulatoryType2+"的长度"+aRegulatoryType2.length()+"大于最大值2");
		RegulatoryType2 = aRegulatoryType2;
	}
	public String getRegulatoryType3()
	{
		return RegulatoryType3;
	}
	public void setRegulatoryType3(String aRegulatoryType3)
	{
		if(aRegulatoryType3!=null && aRegulatoryType3.length()>2)
			throw new IllegalArgumentException("Regulatorytype3RegulatoryType3值"+aRegulatoryType3+"的长度"+aRegulatoryType3.length()+"大于最大值2");
		RegulatoryType3 = aRegulatoryType3;
	}
	public String getCPDHourType1()
	{
		return CPDHourType1;
	}
	public void setCPDHourType1(String aCPDHourType1)
	{
		if(aCPDHourType1!=null && aCPDHourType1.length()>2)
			throw new IllegalArgumentException("Cpdhourtype1CPDHourType1值"+aCPDHourType1+"的长度"+aCPDHourType1.length()+"大于最大值2");
		CPDHourType1 = aCPDHourType1;
	}
	public String getCPDHourType2()
	{
		return CPDHourType2;
	}
	public void setCPDHourType2(String aCPDHourType2)
	{
		if(aCPDHourType2!=null && aCPDHourType2.length()>2)
			throw new IllegalArgumentException("Cpdhourtype2CPDHourType2值"+aCPDHourType2+"的长度"+aCPDHourType2.length()+"大于最大值2");
		CPDHourType2 = aCPDHourType2;
	}
	public String getCPDHourType3()
	{
		return CPDHourType3;
	}
	public void setCPDHourType3(String aCPDHourType3)
	{
		if(aCPDHourType3!=null && aCPDHourType3.length()>2)
			throw new IllegalArgumentException("Cpdhourtype3CPDHourType3值"+aCPDHourType3+"的长度"+aCPDHourType3.length()+"大于最大值2");
		CPDHourType3 = aCPDHourType3;
	}
	public String getCPDHour1()
	{
		return CPDHour1;
	}
	public void setCPDHour1(String aCPDHour1)
	{
		if(aCPDHour1!=null && aCPDHour1.length()>20)
			throw new IllegalArgumentException("Cpdhour1CPDHour1值"+aCPDHour1+"的长度"+aCPDHour1.length()+"大于最大值20");
		CPDHour1 = aCPDHour1;
	}
	public String getCPDHour2()
	{
		return CPDHour2;
	}
	public void setCPDHour2(String aCPDHour2)
	{
		if(aCPDHour2!=null && aCPDHour2.length()>20)
			throw new IllegalArgumentException("Cpdhour2CPDHour2值"+aCPDHour2+"的长度"+aCPDHour2.length()+"大于最大值20");
		CPDHour2 = aCPDHour2;
	}
	public String getCPDHour3()
	{
		return CPDHour3;
	}
	public void setCPDHour3(String aCPDHour3)
	{
		if(aCPDHour3!=null && aCPDHour3.length()>20)
			throw new IllegalArgumentException("Cpdhour3CPDHour3值"+aCPDHour3+"的长度"+aCPDHour3.length()+"大于最大值20");
		CPDHour3 = aCPDHour3;
	}
	public String getReportingPeriod()
	{
		if( ReportingPeriod != null )
			return fDate.getString(ReportingPeriod);
		else
			return null;
	}
	public void setReportingPeriod(Date aReportingPeriod)
	{
		ReportingPeriod = aReportingPeriod;
	}
	public void setReportingPeriod(String aReportingPeriod)
	{
		if (aReportingPeriod != null && !aReportingPeriod.equals("") )
		{
			ReportingPeriod = fDate.getDate( aReportingPeriod );
		}
		else
			ReportingPeriod = null;
	}

	public String getRemark()
	{
		return Remark;
	}
	public void setRemark(String aRemark)
	{
		if(aRemark!=null && aRemark.length()>500)
			throw new IllegalArgumentException("RemarkRemark值"+aRemark+"的长度"+aRemark.length()+"大于最大值500");
		Remark = aRemark;
	}
	public double getEligibleAmounts()
	{
		return EligibleAmounts;
	}
	public void setEligibleAmounts(double aEligibleAmounts)
	{
		EligibleAmounts = aEligibleAmounts;
	}
	public void setEligibleAmounts(String aEligibleAmounts)
	{
		if (aEligibleAmounts != null && !aEligibleAmounts.equals(""))
		{
			Double tDouble = new Double(aEligibleAmounts);
			double d = tDouble.doubleValue();
			EligibleAmounts = d;
		}
	}

	public double getReimbursedAmount()
	{
		return ReimbursedAmount;
	}
	public void setReimbursedAmount(double aReimbursedAmount)
	{
		ReimbursedAmount = aReimbursedAmount;
	}
	public void setReimbursedAmount(String aReimbursedAmount)
	{
		if (aReimbursedAmount != null && !aReimbursedAmount.equals(""))
		{
			Double tDouble = new Double(aReimbursedAmount);
			double d = tDouble.doubleValue();
			ReimbursedAmount = d;
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

	/**
	* 使用另外一个 LACPDBSchema 对象给 Schema 赋值
	* @param: aLACPDBSchema LACPDBSchema
	**/
	public void setSchema(LACPDBSchema aLACPDBSchema)
	{
		this.AgentCode = aLACPDBSchema.getAgentCode();
		this.CourseName = aLACPDBSchema.getCourseName();
		this.HKCAAVQCode = aLACPDBSchema.getHKCAAVQCode();
		this.CourseDate = fDate.getDate( aLACPDBSchema.getCourseDate());
		this.RegulatoryType1 = aLACPDBSchema.getRegulatoryType1();
		this.RegulatoryType2 = aLACPDBSchema.getRegulatoryType2();
		this.RegulatoryType3 = aLACPDBSchema.getRegulatoryType3();
		this.CPDHourType1 = aLACPDBSchema.getCPDHourType1();
		this.CPDHourType2 = aLACPDBSchema.getCPDHourType2();
		this.CPDHourType3 = aLACPDBSchema.getCPDHourType3();
		this.CPDHour1 = aLACPDBSchema.getCPDHour1();
		this.CPDHour2 = aLACPDBSchema.getCPDHour2();
		this.CPDHour3 = aLACPDBSchema.getCPDHour3();
		this.ReportingPeriod = fDate.getDate( aLACPDBSchema.getReportingPeriod());
		this.Remark = aLACPDBSchema.getRemark();
		this.EligibleAmounts = aLACPDBSchema.getEligibleAmounts();
		this.ReimbursedAmount = aLACPDBSchema.getReimbursedAmount();
		this.Operator = aLACPDBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLACPDBSchema.getMakeDate());
		this.MakeTime = aLACPDBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLACPDBSchema.getModifyDate());
		this.ModifyTime = aLACPDBSchema.getModifyTime();
		this.Operator1 = aLACPDBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLACPDBSchema.getMakeDate1());
		this.MakeTime1 = aLACPDBSchema.getMakeTime1();
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

			if( rs.getString("CourseName") == null )
				this.CourseName = null;
			else
				this.CourseName = rs.getString("CourseName").trim();

			if( rs.getString("HKCAAVQCode") == null )
				this.HKCAAVQCode = null;
			else
				this.HKCAAVQCode = rs.getString("HKCAAVQCode").trim();

			this.CourseDate = rs.getDate("CourseDate");
			if( rs.getString("RegulatoryType1") == null )
				this.RegulatoryType1 = null;
			else
				this.RegulatoryType1 = rs.getString("RegulatoryType1").trim();

			if( rs.getString("RegulatoryType2") == null )
				this.RegulatoryType2 = null;
			else
				this.RegulatoryType2 = rs.getString("RegulatoryType2").trim();

			if( rs.getString("RegulatoryType3") == null )
				this.RegulatoryType3 = null;
			else
				this.RegulatoryType3 = rs.getString("RegulatoryType3").trim();

			if( rs.getString("CPDHourType1") == null )
				this.CPDHourType1 = null;
			else
				this.CPDHourType1 = rs.getString("CPDHourType1").trim();

			if( rs.getString("CPDHourType2") == null )
				this.CPDHourType2 = null;
			else
				this.CPDHourType2 = rs.getString("CPDHourType2").trim();

			if( rs.getString("CPDHourType3") == null )
				this.CPDHourType3 = null;
			else
				this.CPDHourType3 = rs.getString("CPDHourType3").trim();

			if( rs.getString("CPDHour1") == null )
				this.CPDHour1 = null;
			else
				this.CPDHour1 = rs.getString("CPDHour1").trim();

			if( rs.getString("CPDHour2") == null )
				this.CPDHour2 = null;
			else
				this.CPDHour2 = rs.getString("CPDHour2").trim();

			if( rs.getString("CPDHour3") == null )
				this.CPDHour3 = null;
			else
				this.CPDHour3 = rs.getString("CPDHour3").trim();

			this.ReportingPeriod = rs.getDate("ReportingPeriod");
			if( rs.getString("Remark") == null )
				this.Remark = null;
			else
				this.Remark = rs.getString("Remark").trim();

			this.EligibleAmounts = rs.getDouble("EligibleAmounts");
			this.ReimbursedAmount = rs.getDouble("ReimbursedAmount");
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
			logger.debug("数据库中的LACPDB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACPDBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LACPDBSchema getSchema()
	{
		LACPDBSchema aLACPDBSchema = new LACPDBSchema();
		aLACPDBSchema.setSchema(this);
		return aLACPDBSchema;
	}

	public LACPDBDB getDB()
	{
		LACPDBDB aDBOper = new LACPDBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLACPDB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKCAAVQCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( CourseDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegulatoryType1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegulatoryType2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegulatoryType3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CPDHourType1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CPDHourType2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CPDHourType3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CPDHour1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CPDHour2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CPDHour3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ReportingPeriod ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remark)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(EligibleAmounts));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(ReimbursedAmount));strReturn.append(SysConst.PACKAGESPILTER);
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
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLACPDB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			CourseName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			HKCAAVQCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			CourseDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,SysConst.PACKAGESPILTER));
			RegulatoryType1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			RegulatoryType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			RegulatoryType3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			CPDHourType1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			CPDHourType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			CPDHourType3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			CPDHour1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			CPDHour2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			CPDHour3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			ReportingPeriod = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			EligibleAmounts = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,16,SysConst.PACKAGESPILTER))).doubleValue();
			ReimbursedAmount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,17,SysConst.PACKAGESPILTER))).doubleValue();
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACPDBSchema";
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
		if (FCode.equalsIgnoreCase("CourseName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseName));
		}
		if (FCode.equalsIgnoreCase("HKCAAVQCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKCAAVQCode));
		}
		if (FCode.equalsIgnoreCase("CourseDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getCourseDate()));
		}
		if (FCode.equalsIgnoreCase("RegulatoryType1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegulatoryType1));
		}
		if (FCode.equalsIgnoreCase("RegulatoryType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegulatoryType2));
		}
		if (FCode.equalsIgnoreCase("RegulatoryType3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegulatoryType3));
		}
		if (FCode.equalsIgnoreCase("CPDHourType1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CPDHourType1));
		}
		if (FCode.equalsIgnoreCase("CPDHourType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CPDHourType2));
		}
		if (FCode.equalsIgnoreCase("CPDHourType3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CPDHourType3));
		}
		if (FCode.equalsIgnoreCase("CPDHour1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CPDHour1));
		}
		if (FCode.equalsIgnoreCase("CPDHour2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CPDHour2));
		}
		if (FCode.equalsIgnoreCase("CPDHour3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CPDHour3));
		}
		if (FCode.equalsIgnoreCase("ReportingPeriod"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getReportingPeriod()));
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remark));
		}
		if (FCode.equalsIgnoreCase("EligibleAmounts"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EligibleAmounts));
		}
		if (FCode.equalsIgnoreCase("ReimbursedAmount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReimbursedAmount));
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
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(CourseName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(HKCAAVQCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCourseDate()));
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(RegulatoryType1);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(RegulatoryType2);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(RegulatoryType3);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(CPDHourType1);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(CPDHourType2);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(CPDHourType3);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(CPDHour1);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(CPDHour2);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(CPDHour3);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getReportingPeriod()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Remark);
				break;
			case 15:
				strFieldValue = String.valueOf(EligibleAmounts);
				break;
			case 16:
				strFieldValue = String.valueOf(ReimbursedAmount);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 24:
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

		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("CourseName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseName = FValue.trim();
			}
			else
				CourseName = null;
		}
		if (FCode.equalsIgnoreCase("HKCAAVQCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKCAAVQCode = FValue.trim();
			}
			else
				HKCAAVQCode = null;
		}
		if (FCode.equalsIgnoreCase("CourseDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				CourseDate = fDate.getDate( FValue );
			}
			else
				CourseDate = null;
		}
		if (FCode.equalsIgnoreCase("RegulatoryType1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegulatoryType1 = FValue.trim();
			}
			else
				RegulatoryType1 = null;
		}
		if (FCode.equalsIgnoreCase("RegulatoryType2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegulatoryType2 = FValue.trim();
			}
			else
				RegulatoryType2 = null;
		}
		if (FCode.equalsIgnoreCase("RegulatoryType3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegulatoryType3 = FValue.trim();
			}
			else
				RegulatoryType3 = null;
		}
		if (FCode.equalsIgnoreCase("CPDHourType1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CPDHourType1 = FValue.trim();
			}
			else
				CPDHourType1 = null;
		}
		if (FCode.equalsIgnoreCase("CPDHourType2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CPDHourType2 = FValue.trim();
			}
			else
				CPDHourType2 = null;
		}
		if (FCode.equalsIgnoreCase("CPDHourType3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CPDHourType3 = FValue.trim();
			}
			else
				CPDHourType3 = null;
		}
		if (FCode.equalsIgnoreCase("CPDHour1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CPDHour1 = FValue.trim();
			}
			else
				CPDHour1 = null;
		}
		if (FCode.equalsIgnoreCase("CPDHour2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CPDHour2 = FValue.trim();
			}
			else
				CPDHour2 = null;
		}
		if (FCode.equalsIgnoreCase("CPDHour3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CPDHour3 = FValue.trim();
			}
			else
				CPDHour3 = null;
		}
		if (FCode.equalsIgnoreCase("ReportingPeriod"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ReportingPeriod = fDate.getDate( FValue );
			}
			else
				ReportingPeriod = null;
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Remark = FValue.trim();
			}
			else
				Remark = null;
		}
		if (FCode.equalsIgnoreCase("EligibleAmounts"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				EligibleAmounts = d;
			}
		}
		if (FCode.equalsIgnoreCase("ReimbursedAmount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				ReimbursedAmount = d;
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
		LACPDBSchema other = (LACPDBSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& CourseName.equals(other.getCourseName())
			&& HKCAAVQCode.equals(other.getHKCAAVQCode())
			&& fDate.getString(CourseDate).equals(other.getCourseDate())
			&& RegulatoryType1.equals(other.getRegulatoryType1())
			&& RegulatoryType2.equals(other.getRegulatoryType2())
			&& RegulatoryType3.equals(other.getRegulatoryType3())
			&& CPDHourType1.equals(other.getCPDHourType1())
			&& CPDHourType2.equals(other.getCPDHourType2())
			&& CPDHourType3.equals(other.getCPDHourType3())
			&& CPDHour1.equals(other.getCPDHour1())
			&& CPDHour2.equals(other.getCPDHour2())
			&& CPDHour3.equals(other.getCPDHour3())
			&& fDate.getString(ReportingPeriod).equals(other.getReportingPeriod())
			&& Remark.equals(other.getRemark())
			&& EligibleAmounts == other.getEligibleAmounts()
			&& ReimbursedAmount == other.getReimbursedAmount()
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
		if( strFieldName.equals("AgentCode") ) {
			return 0;
		}
		if( strFieldName.equals("CourseName") ) {
			return 1;
		}
		if( strFieldName.equals("HKCAAVQCode") ) {
			return 2;
		}
		if( strFieldName.equals("CourseDate") ) {
			return 3;
		}
		if( strFieldName.equals("RegulatoryType1") ) {
			return 4;
		}
		if( strFieldName.equals("RegulatoryType2") ) {
			return 5;
		}
		if( strFieldName.equals("RegulatoryType3") ) {
			return 6;
		}
		if( strFieldName.equals("CPDHourType1") ) {
			return 7;
		}
		if( strFieldName.equals("CPDHourType2") ) {
			return 8;
		}
		if( strFieldName.equals("CPDHourType3") ) {
			return 9;
		}
		if( strFieldName.equals("CPDHour1") ) {
			return 10;
		}
		if( strFieldName.equals("CPDHour2") ) {
			return 11;
		}
		if( strFieldName.equals("CPDHour3") ) {
			return 12;
		}
		if( strFieldName.equals("ReportingPeriod") ) {
			return 13;
		}
		if( strFieldName.equals("Remark") ) {
			return 14;
		}
		if( strFieldName.equals("EligibleAmounts") ) {
			return 15;
		}
		if( strFieldName.equals("ReimbursedAmount") ) {
			return 16;
		}
		if( strFieldName.equals("Operator") ) {
			return 17;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 18;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 19;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 20;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 21;
		}
		if( strFieldName.equals("Operator1") ) {
			return 22;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 23;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 24;
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
				strFieldName = "CourseName";
				break;
			case 2:
				strFieldName = "HKCAAVQCode";
				break;
			case 3:
				strFieldName = "CourseDate";
				break;
			case 4:
				strFieldName = "RegulatoryType1";
				break;
			case 5:
				strFieldName = "RegulatoryType2";
				break;
			case 6:
				strFieldName = "RegulatoryType3";
				break;
			case 7:
				strFieldName = "CPDHourType1";
				break;
			case 8:
				strFieldName = "CPDHourType2";
				break;
			case 9:
				strFieldName = "CPDHourType3";
				break;
			case 10:
				strFieldName = "CPDHour1";
				break;
			case 11:
				strFieldName = "CPDHour2";
				break;
			case 12:
				strFieldName = "CPDHour3";
				break;
			case 13:
				strFieldName = "ReportingPeriod";
				break;
			case 14:
				strFieldName = "Remark";
				break;
			case 15:
				strFieldName = "EligibleAmounts";
				break;
			case 16:
				strFieldName = "ReimbursedAmount";
				break;
			case 17:
				strFieldName = "Operator";
				break;
			case 18:
				strFieldName = "MakeDate";
				break;
			case 19:
				strFieldName = "MakeTime";
				break;
			case 20:
				strFieldName = "ModifyDate";
				break;
			case 21:
				strFieldName = "ModifyTime";
				break;
			case 22:
				strFieldName = "Operator1";
				break;
			case 23:
				strFieldName = "MakeDate1";
				break;
			case 24:
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
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKCAAVQCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("RegulatoryType1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RegulatoryType2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RegulatoryType3") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CPDHourType1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CPDHourType2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CPDHourType3") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CPDHour1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CPDHour2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CPDHour3") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReportingPeriod") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Remark") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EligibleAmounts") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("ReimbursedAmount") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 16:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 20:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 21:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 22:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 23:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 24:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
