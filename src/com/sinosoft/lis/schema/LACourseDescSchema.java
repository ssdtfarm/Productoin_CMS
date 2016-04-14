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
import com.sinosoft.lis.db.LACourseDescDB;

/*
 * <p>ClassName: LACourseDescSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LACourseDescSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LACourseDescSchema.class);
	// @Field
	/** Courseid */
	private String CourseID;
	/** Channelcode */
	private String Channelcode;
	/** Coursetype */
	private String CourseType;
	/** Courseseries */
	private String CourseSeries;
	/** Coursegrade */
	private String CourseGrade;
	/** Courseno */
	private String CourseNo;
	/** Courseprofit */
	private String CourseProfit;
	/** Coursename */
	private String CourseName;
	/** Coursehour */
	private double CourseHour;
	/** Teachergrade */
	private String TeacherGrade;
	/** Stopflag */
	private String StopFlag;
	/** Remarks */
	private String Remarks;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;
	/** Operator */
	private String Operator;

	public static final int FIELDNUM = 17;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LACourseDescSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "CourseID";
		pk[1] = "Channelcode";

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
		LACourseDescSchema cloned = (LACourseDescSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCourseID()
	{
		return CourseID;
	}
	public void setCourseID(String aCourseID)
	{
		if(aCourseID!=null && aCourseID.length()>15)
			throw new IllegalArgumentException("CourseidCourseID值"+aCourseID+"的长度"+aCourseID.length()+"大于最大值15");
		CourseID = aCourseID;
	}
	public String getChannelcode()
	{
		return Channelcode;
	}
	public void setChannelcode(String aChannelcode)
	{
		if(aChannelcode!=null && aChannelcode.length()>2)
			throw new IllegalArgumentException("ChannelcodeChannelcode值"+aChannelcode+"的长度"+aChannelcode.length()+"大于最大值2");
		Channelcode = aChannelcode;
	}
	public String getCourseType()
	{
		return CourseType;
	}
	public void setCourseType(String aCourseType)
	{
		if(aCourseType!=null && aCourseType.length()>4)
			throw new IllegalArgumentException("CoursetypeCourseType值"+aCourseType+"的长度"+aCourseType.length()+"大于最大值4");
		CourseType = aCourseType;
	}
	public String getCourseSeries()
	{
		return CourseSeries;
	}
	public void setCourseSeries(String aCourseSeries)
	{
		if(aCourseSeries!=null && aCourseSeries.length()>4)
			throw new IllegalArgumentException("CourseseriesCourseSeries值"+aCourseSeries+"的长度"+aCourseSeries.length()+"大于最大值4");
		CourseSeries = aCourseSeries;
	}
	public String getCourseGrade()
	{
		return CourseGrade;
	}
	public void setCourseGrade(String aCourseGrade)
	{
		if(aCourseGrade!=null && aCourseGrade.length()>4)
			throw new IllegalArgumentException("CoursegradeCourseGrade值"+aCourseGrade+"的长度"+aCourseGrade.length()+"大于最大值4");
		CourseGrade = aCourseGrade;
	}
	public String getCourseNo()
	{
		return CourseNo;
	}
	public void setCourseNo(String aCourseNo)
	{
		if(aCourseNo!=null && aCourseNo.length()>5)
			throw new IllegalArgumentException("CoursenoCourseNo值"+aCourseNo+"的长度"+aCourseNo.length()+"大于最大值5");
		CourseNo = aCourseNo;
	}
	public String getCourseProfit()
	{
		return CourseProfit;
	}
	public void setCourseProfit(String aCourseProfit)
	{
		if(aCourseProfit!=null && aCourseProfit.length()>2)
			throw new IllegalArgumentException("CourseprofitCourseProfit值"+aCourseProfit+"的长度"+aCourseProfit.length()+"大于最大值2");
		CourseProfit = aCourseProfit;
	}
	public String getCourseName()
	{
		return CourseName;
	}
	public void setCourseName(String aCourseName)
	{
		if(aCourseName!=null && aCourseName.length()>100)
			throw new IllegalArgumentException("CoursenameCourseName值"+aCourseName+"的长度"+aCourseName.length()+"大于最大值100");
		CourseName = aCourseName;
	}
	public double getCourseHour()
	{
		return CourseHour;
	}
	public void setCourseHour(double aCourseHour)
	{
		CourseHour = aCourseHour;
	}
	public void setCourseHour(String aCourseHour)
	{
		if (aCourseHour != null && !aCourseHour.equals(""))
		{
			Double tDouble = new Double(aCourseHour);
			double d = tDouble.doubleValue();
			CourseHour = d;
		}
	}

	public String getTeacherGrade()
	{
		return TeacherGrade;
	}
	public void setTeacherGrade(String aTeacherGrade)
	{
		if(aTeacherGrade!=null && aTeacherGrade.length()>10)
			throw new IllegalArgumentException("TeachergradeTeacherGrade值"+aTeacherGrade+"的长度"+aTeacherGrade.length()+"大于最大值10");
		TeacherGrade = aTeacherGrade;
	}
	public String getStopFlag()
	{
		return StopFlag;
	}
	public void setStopFlag(String aStopFlag)
	{
		if(aStopFlag!=null && aStopFlag.length()>2)
			throw new IllegalArgumentException("StopflagStopFlag值"+aStopFlag+"的长度"+aStopFlag.length()+"大于最大值2");
		StopFlag = aStopFlag;
	}
	public String getRemarks()
	{
		return Remarks;
	}
	public void setRemarks(String aRemarks)
	{
		if(aRemarks!=null && aRemarks.length()>500)
			throw new IllegalArgumentException("RemarksRemarks值"+aRemarks+"的长度"+aRemarks.length()+"大于最大值500");
		Remarks = aRemarks;
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
	* 使用另外一个 LACourseDescSchema 对象给 Schema 赋值
	* @param: aLACourseDescSchema LACourseDescSchema
	**/
	public void setSchema(LACourseDescSchema aLACourseDescSchema)
	{
		this.CourseID = aLACourseDescSchema.getCourseID();
		this.Channelcode = aLACourseDescSchema.getChannelcode();
		this.CourseType = aLACourseDescSchema.getCourseType();
		this.CourseSeries = aLACourseDescSchema.getCourseSeries();
		this.CourseGrade = aLACourseDescSchema.getCourseGrade();
		this.CourseNo = aLACourseDescSchema.getCourseNo();
		this.CourseProfit = aLACourseDescSchema.getCourseProfit();
		this.CourseName = aLACourseDescSchema.getCourseName();
		this.CourseHour = aLACourseDescSchema.getCourseHour();
		this.TeacherGrade = aLACourseDescSchema.getTeacherGrade();
		this.StopFlag = aLACourseDescSchema.getStopFlag();
		this.Remarks = aLACourseDescSchema.getRemarks();
		this.MakeDate = fDate.getDate( aLACourseDescSchema.getMakeDate());
		this.MakeTime = aLACourseDescSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLACourseDescSchema.getModifyDate());
		this.ModifyTime = aLACourseDescSchema.getModifyTime();
		this.Operator = aLACourseDescSchema.getOperator();
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
			if( rs.getString("CourseID") == null )
				this.CourseID = null;
			else
				this.CourseID = rs.getString("CourseID").trim();

			if( rs.getString("Channelcode") == null )
				this.Channelcode = null;
			else
				this.Channelcode = rs.getString("Channelcode").trim();

			if( rs.getString("CourseType") == null )
				this.CourseType = null;
			else
				this.CourseType = rs.getString("CourseType").trim();

			if( rs.getString("CourseSeries") == null )
				this.CourseSeries = null;
			else
				this.CourseSeries = rs.getString("CourseSeries").trim();

			if( rs.getString("CourseGrade") == null )
				this.CourseGrade = null;
			else
				this.CourseGrade = rs.getString("CourseGrade").trim();

			if( rs.getString("CourseNo") == null )
				this.CourseNo = null;
			else
				this.CourseNo = rs.getString("CourseNo").trim();

			if( rs.getString("CourseProfit") == null )
				this.CourseProfit = null;
			else
				this.CourseProfit = rs.getString("CourseProfit").trim();

			if( rs.getString("CourseName") == null )
				this.CourseName = null;
			else
				this.CourseName = rs.getString("CourseName").trim();

			this.CourseHour = rs.getDouble("CourseHour");
			if( rs.getString("TeacherGrade") == null )
				this.TeacherGrade = null;
			else
				this.TeacherGrade = rs.getString("TeacherGrade").trim();

			if( rs.getString("StopFlag") == null )
				this.StopFlag = null;
			else
				this.StopFlag = rs.getString("StopFlag").trim();

			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

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

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LACourseDesc表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACourseDescSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LACourseDescSchema getSchema()
	{
		LACourseDescSchema aLACourseDescSchema = new LACourseDescSchema();
		aLACourseDescSchema.setSchema(this);
		return aLACourseDescSchema;
	}

	public LACourseDescDB getDB()
	{
		LACourseDescDB aDBOper = new LACourseDescDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLACourseDesc描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(CourseID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Channelcode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseSeries)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseProfit)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(CourseHour));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TeacherGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(StopFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLACourseDesc>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			CourseID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Channelcode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			CourseType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			CourseSeries = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			CourseGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			CourseNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			CourseProfit = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			CourseName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			CourseHour = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,9,SysConst.PACKAGESPILTER))).doubleValue();
			TeacherGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			StopFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACourseDescSchema";
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
		if (FCode.equalsIgnoreCase("CourseID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseID));
		}
		if (FCode.equalsIgnoreCase("Channelcode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Channelcode));
		}
		if (FCode.equalsIgnoreCase("CourseType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseType));
		}
		if (FCode.equalsIgnoreCase("CourseSeries"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseSeries));
		}
		if (FCode.equalsIgnoreCase("CourseGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseGrade));
		}
		if (FCode.equalsIgnoreCase("CourseNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseNo));
		}
		if (FCode.equalsIgnoreCase("CourseProfit"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseProfit));
		}
		if (FCode.equalsIgnoreCase("CourseName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseName));
		}
		if (FCode.equalsIgnoreCase("CourseHour"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseHour));
		}
		if (FCode.equalsIgnoreCase("TeacherGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TeacherGrade));
		}
		if (FCode.equalsIgnoreCase("StopFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(StopFlag));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
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
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
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
				strFieldValue = StrTool.GBKToUnicode(CourseID);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(Channelcode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(CourseType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(CourseSeries);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(CourseGrade);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(CourseNo);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(CourseProfit);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(CourseName);
				break;
			case 8:
				strFieldValue = String.valueOf(CourseHour);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(TeacherGrade);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(StopFlag);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Operator);
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

		if (FCode.equalsIgnoreCase("CourseID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseID = FValue.trim();
			}
			else
				CourseID = null;
		}
		if (FCode.equalsIgnoreCase("Channelcode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Channelcode = FValue.trim();
			}
			else
				Channelcode = null;
		}
		if (FCode.equalsIgnoreCase("CourseType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseType = FValue.trim();
			}
			else
				CourseType = null;
		}
		if (FCode.equalsIgnoreCase("CourseSeries"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseSeries = FValue.trim();
			}
			else
				CourseSeries = null;
		}
		if (FCode.equalsIgnoreCase("CourseGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseGrade = FValue.trim();
			}
			else
				CourseGrade = null;
		}
		if (FCode.equalsIgnoreCase("CourseNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseNo = FValue.trim();
			}
			else
				CourseNo = null;
		}
		if (FCode.equalsIgnoreCase("CourseProfit"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseProfit = FValue.trim();
			}
			else
				CourseProfit = null;
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
		if (FCode.equalsIgnoreCase("CourseHour"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				CourseHour = d;
			}
		}
		if (FCode.equalsIgnoreCase("TeacherGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TeacherGrade = FValue.trim();
			}
			else
				TeacherGrade = null;
		}
		if (FCode.equalsIgnoreCase("StopFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				StopFlag = FValue.trim();
			}
			else
				StopFlag = null;
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Remarks = FValue.trim();
			}
			else
				Remarks = null;
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
		if (FCode.equalsIgnoreCase("Operator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator = FValue.trim();
			}
			else
				Operator = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LACourseDescSchema other = (LACourseDescSchema)otherObject;
		return
			CourseID.equals(other.getCourseID())
			&& Channelcode.equals(other.getChannelcode())
			&& CourseType.equals(other.getCourseType())
			&& CourseSeries.equals(other.getCourseSeries())
			&& CourseGrade.equals(other.getCourseGrade())
			&& CourseNo.equals(other.getCourseNo())
			&& CourseProfit.equals(other.getCourseProfit())
			&& CourseName.equals(other.getCourseName())
			&& CourseHour == other.getCourseHour()
			&& TeacherGrade.equals(other.getTeacherGrade())
			&& StopFlag.equals(other.getStopFlag())
			&& Remarks.equals(other.getRemarks())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator.equals(other.getOperator());
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
		if( strFieldName.equals("CourseID") ) {
			return 0;
		}
		if( strFieldName.equals("Channelcode") ) {
			return 1;
		}
		if( strFieldName.equals("CourseType") ) {
			return 2;
		}
		if( strFieldName.equals("CourseSeries") ) {
			return 3;
		}
		if( strFieldName.equals("CourseGrade") ) {
			return 4;
		}
		if( strFieldName.equals("CourseNo") ) {
			return 5;
		}
		if( strFieldName.equals("CourseProfit") ) {
			return 6;
		}
		if( strFieldName.equals("CourseName") ) {
			return 7;
		}
		if( strFieldName.equals("CourseHour") ) {
			return 8;
		}
		if( strFieldName.equals("TeacherGrade") ) {
			return 9;
		}
		if( strFieldName.equals("StopFlag") ) {
			return 10;
		}
		if( strFieldName.equals("Remarks") ) {
			return 11;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 12;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 13;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 14;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 15;
		}
		if( strFieldName.equals("Operator") ) {
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
				strFieldName = "CourseID";
				break;
			case 1:
				strFieldName = "Channelcode";
				break;
			case 2:
				strFieldName = "CourseType";
				break;
			case 3:
				strFieldName = "CourseSeries";
				break;
			case 4:
				strFieldName = "CourseGrade";
				break;
			case 5:
				strFieldName = "CourseNo";
				break;
			case 6:
				strFieldName = "CourseProfit";
				break;
			case 7:
				strFieldName = "CourseName";
				break;
			case 8:
				strFieldName = "CourseHour";
				break;
			case 9:
				strFieldName = "TeacherGrade";
				break;
			case 10:
				strFieldName = "StopFlag";
				break;
			case 11:
				strFieldName = "Remarks";
				break;
			case 12:
				strFieldName = "MakeDate";
				break;
			case 13:
				strFieldName = "MakeTime";
				break;
			case 14:
				strFieldName = "ModifyDate";
				break;
			case 15:
				strFieldName = "ModifyTime";
				break;
			case 16:
				strFieldName = "Operator";
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
		if( strFieldName.equals("CourseID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Channelcode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseSeries") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseProfit") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseHour") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("TeacherGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StopFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remarks") ) {
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
		if( strFieldName.equals("Operator") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
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
