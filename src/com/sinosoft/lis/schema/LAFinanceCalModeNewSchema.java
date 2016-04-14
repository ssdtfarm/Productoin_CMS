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
import com.sinosoft.lis.db.LAFinanceCalModeNewDB;

/*
 * <p>ClassName: LAFinanceCalModeNewSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAFinanceCalModeNewSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAFinanceCalModeNewSchema.class);
	// @Field
	/** Reportcode */
	private String ReportCode;
	/** Titlecode */
	private String TitleCode;
	/** Subjectorder */
	private int SubjectOrder;
	/** Subjectcode */
	private String SubjectCode;
	/** Subjectname */
	private String SubjectName;
	/** Agentseries */
	private String AgentSeries;
	/** Gradeseries */
	private String GradeSeries;
	/** Calsql */
	private String CalSql;
	/** Monthdeviation */
	private int MonthDeviation;
	/** Operation */
	private String Operation;
	/** Description */
	private String Description;
	/** B1 */
	private String B1;
	/** B2 */
	private String B2;
	/** B3 */
	private String B3;
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

	public static final int FIELDNUM = 19;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAFinanceCalModeNewSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[8];
		pk[0] = "ReportCode";
		pk[1] = "TitleCode";
		pk[2] = "SubjectOrder";
		pk[3] = "Operator";
		pk[4] = "MakeDate";
		pk[5] = "MakeTime";
		pk[6] = "ModifyDate";
		pk[7] = "ModifyTime";

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
		LAFinanceCalModeNewSchema cloned = (LAFinanceCalModeNewSchema)super.clone();
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
	* 报表科目编码
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
	* 报表科目所含子项流水ID
	*/
	public int getSubjectOrder()
	{
		return SubjectOrder;
	}
	public void setSubjectOrder(int aSubjectOrder)
	{
		SubjectOrder = aSubjectOrder;
	}
	public void setSubjectOrder(String aSubjectOrder)
	{
		if (aSubjectOrder != null && !aSubjectOrder.equals(""))
		{
			Integer tInteger = new Integer(aSubjectOrder);
			int i = tInteger.intValue();
			SubjectOrder = i;
		}
	}

	/**
	* 报表科目所含子项subjectcode—对应lainterfacedatacfg
	*/
	public String getSubjectCode()
	{
		return SubjectCode;
	}
	public void setSubjectCode(String aSubjectCode)
	{
		if(aSubjectCode!=null && aSubjectCode.length()>30)
			throw new IllegalArgumentException("SubjectcodeSubjectCode值"+aSubjectCode+"的长度"+aSubjectCode.length()+"大于最大值30");
		SubjectCode = aSubjectCode;
	}
	/**
	* 报表科目所含子项subjectname—对应lainterfacedatacfg
	*/
	public String getSubjectName()
	{
		return SubjectName;
	}
	public void setSubjectName(String aSubjectName)
	{
		if(aSubjectName!=null && aSubjectName.length()>100)
			throw new IllegalArgumentException("SubjectnameSubjectName值"+aSubjectName+"的长度"+aSubjectName.length()+"大于最大值100");
		SubjectName = aSubjectName;
	}
	/**
	* 人员类型
	*/
	public String getAgentSeries()
	{
		return AgentSeries;
	}
	public void setAgentSeries(String aAgentSeries)
	{
		if(aAgentSeries!=null && aAgentSeries.length()>30)
			throw new IllegalArgumentException("AgentseriesAgentSeries值"+aAgentSeries+"的长度"+aAgentSeries.length()+"大于最大值30");
		AgentSeries = aAgentSeries;
	}
	/**
	* 职级类型
	*/
	public String getGradeSeries()
	{
		return GradeSeries;
	}
	public void setGradeSeries(String aGradeSeries)
	{
		if(aGradeSeries!=null && aGradeSeries.length()>30)
			throw new IllegalArgumentException("GradeseriesGradeSeries值"+aGradeSeries+"的长度"+aGradeSeries.length()+"大于最大值30");
		GradeSeries = aGradeSeries;
	}
	/**
	* 如果不能从subjectcode里直接取到，则使用calsql计算
	*/
	public String getCalSql()
	{
		return CalSql;
	}
	public void setCalSql(String aCalSql)
	{
		if(aCalSql!=null && aCalSql.length()>1000)
			throw new IllegalArgumentException("CalsqlCalSql值"+aCalSql+"的长度"+aCalSql.length()+"大于最大值1000");
		CalSql = aCalSql;
	}
	/**
	* 报表科目所包含子项归属年月（当月0，上月-1，次月+1…）
	*/
	public int getMonthDeviation()
	{
		return MonthDeviation;
	}
	public void setMonthDeviation(int aMonthDeviation)
	{
		MonthDeviation = aMonthDeviation;
	}
	public void setMonthDeviation(String aMonthDeviation)
	{
		if (aMonthDeviation != null && !aMonthDeviation.equals(""))
		{
			Integer tInteger = new Integer(aMonthDeviation);
			int i = tInteger.intValue();
			MonthDeviation = i;
		}
	}

	/**
	* 操作符（+-*÷）
	*/
	public String getOperation()
	{
		return Operation;
	}
	public void setOperation(String aOperation)
	{
		if(aOperation!=null && aOperation.length()>10)
			throw new IllegalArgumentException("OperationOperation值"+aOperation+"的长度"+aOperation.length()+"大于最大值10");
		Operation = aOperation;
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
	/**
	* 备用2
	*/
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
	/**
	* 备用3
	*/
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
	* 使用另外一个 LAFinanceCalModeNewSchema 对象给 Schema 赋值
	* @param: aLAFinanceCalModeNewSchema LAFinanceCalModeNewSchema
	**/
	public void setSchema(LAFinanceCalModeNewSchema aLAFinanceCalModeNewSchema)
	{
		this.ReportCode = aLAFinanceCalModeNewSchema.getReportCode();
		this.TitleCode = aLAFinanceCalModeNewSchema.getTitleCode();
		this.SubjectOrder = aLAFinanceCalModeNewSchema.getSubjectOrder();
		this.SubjectCode = aLAFinanceCalModeNewSchema.getSubjectCode();
		this.SubjectName = aLAFinanceCalModeNewSchema.getSubjectName();
		this.AgentSeries = aLAFinanceCalModeNewSchema.getAgentSeries();
		this.GradeSeries = aLAFinanceCalModeNewSchema.getGradeSeries();
		this.CalSql = aLAFinanceCalModeNewSchema.getCalSql();
		this.MonthDeviation = aLAFinanceCalModeNewSchema.getMonthDeviation();
		this.Operation = aLAFinanceCalModeNewSchema.getOperation();
		this.Description = aLAFinanceCalModeNewSchema.getDescription();
		this.B1 = aLAFinanceCalModeNewSchema.getB1();
		this.B2 = aLAFinanceCalModeNewSchema.getB2();
		this.B3 = aLAFinanceCalModeNewSchema.getB3();
		this.Operator = aLAFinanceCalModeNewSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAFinanceCalModeNewSchema.getMakeDate());
		this.MakeTime = aLAFinanceCalModeNewSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAFinanceCalModeNewSchema.getModifyDate());
		this.ModifyTime = aLAFinanceCalModeNewSchema.getModifyTime();
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
			if( rs.getString("ReportCode") == null )
				this.ReportCode = null;
			else
				this.ReportCode = rs.getString("ReportCode").trim();

			if( rs.getString("TitleCode") == null )
				this.TitleCode = null;
			else
				this.TitleCode = rs.getString("TitleCode").trim();

			this.SubjectOrder = rs.getInt("SubjectOrder");
			if( rs.getString("SubjectCode") == null )
				this.SubjectCode = null;
			else
				this.SubjectCode = rs.getString("SubjectCode").trim();

			if( rs.getString("SubjectName") == null )
				this.SubjectName = null;
			else
				this.SubjectName = rs.getString("SubjectName").trim();

			if( rs.getString("AgentSeries") == null )
				this.AgentSeries = null;
			else
				this.AgentSeries = rs.getString("AgentSeries").trim();

			if( rs.getString("GradeSeries") == null )
				this.GradeSeries = null;
			else
				this.GradeSeries = rs.getString("GradeSeries").trim();

			if( rs.getString("CalSql") == null )
				this.CalSql = null;
			else
				this.CalSql = rs.getString("CalSql").trim();

			this.MonthDeviation = rs.getInt("MonthDeviation");
			if( rs.getString("Operation") == null )
				this.Operation = null;
			else
				this.Operation = rs.getString("Operation").trim();

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
			logger.debug("数据库中的LAFinanceCalModeNew表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAFinanceCalModeNewSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAFinanceCalModeNewSchema getSchema()
	{
		LAFinanceCalModeNewSchema aLAFinanceCalModeNewSchema = new LAFinanceCalModeNewSchema();
		aLAFinanceCalModeNewSchema.setSchema(this);
		return aLAFinanceCalModeNewSchema;
	}

	public LAFinanceCalModeNewDB getDB()
	{
		LAFinanceCalModeNewDB aDBOper = new LAFinanceCalModeNewDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAFinanceCalModeNew描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ReportCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TitleCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SubjectOrder));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubjectCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubjectName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentSeries)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeSeries)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalSql)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MonthDeviation));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operation)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Description)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAFinanceCalModeNew>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ReportCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			TitleCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			SubjectOrder= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,3,SysConst.PACKAGESPILTER))).intValue();
			SubjectCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			SubjectName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AgentSeries = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			GradeSeries = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			CalSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			MonthDeviation= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,9,SysConst.PACKAGESPILTER))).intValue();
			Operation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			Description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			B1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			B2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			B3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAFinanceCalModeNewSchema";
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
		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReportCode));
		}
		if (FCode.equalsIgnoreCase("TitleCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TitleCode));
		}
		if (FCode.equalsIgnoreCase("SubjectOrder"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectOrder));
		}
		if (FCode.equalsIgnoreCase("SubjectCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectCode));
		}
		if (FCode.equalsIgnoreCase("SubjectName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectName));
		}
		if (FCode.equalsIgnoreCase("AgentSeries"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentSeries));
		}
		if (FCode.equalsIgnoreCase("GradeSeries"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeSeries));
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalSql));
		}
		if (FCode.equalsIgnoreCase("MonthDeviation"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MonthDeviation));
		}
		if (FCode.equalsIgnoreCase("Operation"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operation));
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
				strFieldValue = StrTool.GBKToUnicode(ReportCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(TitleCode);
				break;
			case 2:
				strFieldValue = String.valueOf(SubjectOrder);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(SubjectCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(SubjectName);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(AgentSeries);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(GradeSeries);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(CalSql);
				break;
			case 8:
				strFieldValue = String.valueOf(MonthDeviation);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Operation);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(Description);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(B1);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(B2);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(B3);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 18:
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

		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReportCode = FValue.trim();
			}
			else
				ReportCode = null;
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
		if (FCode.equalsIgnoreCase("SubjectOrder"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				SubjectOrder = i;
			}
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
		if (FCode.equalsIgnoreCase("AgentSeries"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentSeries = FValue.trim();
			}
			else
				AgentSeries = null;
		}
		if (FCode.equalsIgnoreCase("GradeSeries"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeSeries = FValue.trim();
			}
			else
				GradeSeries = null;
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalSql = FValue.trim();
			}
			else
				CalSql = null;
		}
		if (FCode.equalsIgnoreCase("MonthDeviation"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				MonthDeviation = i;
			}
		}
		if (FCode.equalsIgnoreCase("Operation"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operation = FValue.trim();
			}
			else
				Operation = null;
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
		LAFinanceCalModeNewSchema other = (LAFinanceCalModeNewSchema)otherObject;
		return
			ReportCode.equals(other.getReportCode())
			&& TitleCode.equals(other.getTitleCode())
			&& SubjectOrder == other.getSubjectOrder()
			&& SubjectCode.equals(other.getSubjectCode())
			&& SubjectName.equals(other.getSubjectName())
			&& AgentSeries.equals(other.getAgentSeries())
			&& GradeSeries.equals(other.getGradeSeries())
			&& CalSql.equals(other.getCalSql())
			&& MonthDeviation == other.getMonthDeviation()
			&& Operation.equals(other.getOperation())
			&& Description.equals(other.getDescription())
			&& B1.equals(other.getB1())
			&& B2.equals(other.getB2())
			&& B3.equals(other.getB3())
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
		if( strFieldName.equals("ReportCode") ) {
			return 0;
		}
		if( strFieldName.equals("TitleCode") ) {
			return 1;
		}
		if( strFieldName.equals("SubjectOrder") ) {
			return 2;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return 3;
		}
		if( strFieldName.equals("SubjectName") ) {
			return 4;
		}
		if( strFieldName.equals("AgentSeries") ) {
			return 5;
		}
		if( strFieldName.equals("GradeSeries") ) {
			return 6;
		}
		if( strFieldName.equals("CalSql") ) {
			return 7;
		}
		if( strFieldName.equals("MonthDeviation") ) {
			return 8;
		}
		if( strFieldName.equals("Operation") ) {
			return 9;
		}
		if( strFieldName.equals("Description") ) {
			return 10;
		}
		if( strFieldName.equals("B1") ) {
			return 11;
		}
		if( strFieldName.equals("B2") ) {
			return 12;
		}
		if( strFieldName.equals("B3") ) {
			return 13;
		}
		if( strFieldName.equals("Operator") ) {
			return 14;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 15;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 16;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 17;
		}
		if( strFieldName.equals("ModifyTime") ) {
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
				strFieldName = "ReportCode";
				break;
			case 1:
				strFieldName = "TitleCode";
				break;
			case 2:
				strFieldName = "SubjectOrder";
				break;
			case 3:
				strFieldName = "SubjectCode";
				break;
			case 4:
				strFieldName = "SubjectName";
				break;
			case 5:
				strFieldName = "AgentSeries";
				break;
			case 6:
				strFieldName = "GradeSeries";
				break;
			case 7:
				strFieldName = "CalSql";
				break;
			case 8:
				strFieldName = "MonthDeviation";
				break;
			case 9:
				strFieldName = "Operation";
				break;
			case 10:
				strFieldName = "Description";
				break;
			case 11:
				strFieldName = "B1";
				break;
			case 12:
				strFieldName = "B2";
				break;
			case 13:
				strFieldName = "B3";
				break;
			case 14:
				strFieldName = "Operator";
				break;
			case 15:
				strFieldName = "MakeDate";
				break;
			case 16:
				strFieldName = "MakeTime";
				break;
			case 17:
				strFieldName = "ModifyDate";
				break;
			case 18:
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
		if( strFieldName.equals("ReportCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TitleCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubjectOrder") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubjectName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentSeries") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeSeries") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalSql") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MonthDeviation") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("Operation") ) {
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
				nFieldType = Schema.TYPE_INT;
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
				nFieldType = Schema.TYPE_INT;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 17:
				nFieldType = Schema.TYPE_DATE;
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
