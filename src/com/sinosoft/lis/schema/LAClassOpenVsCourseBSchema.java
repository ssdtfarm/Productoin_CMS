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
import com.sinosoft.lis.db.LAClassOpenVsCourseBDB;

/*
 * <p>ClassName: LAClassOpenVsCourseBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAClassOpenVsCourseBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAClassOpenVsCourseBSchema.class);
	// @Field
	/** Openclassid */
	private String OpenClassID;
	/** Courseid */
	private String CourseID;
	/** Channelcode */
	private String ChannelCode;
	/** Teachercode */
	private String TeacherCode;
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
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;
	/** Operator1 */
	private String Operator1;

	public static final int FIELDNUM = 12;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAClassOpenVsCourseBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[6];
		pk[0] = "OpenClassID";
		pk[1] = "CourseID";
		pk[2] = "ChannelCode";
		pk[3] = "MakeDate1";
		pk[4] = "MakeTime1";
		pk[5] = "Operator1";

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
		LAClassOpenVsCourseBSchema cloned = (LAClassOpenVsCourseBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getOpenClassID()
	{
		return OpenClassID;
	}
	public void setOpenClassID(String aOpenClassID)
	{
		if(aOpenClassID!=null && aOpenClassID.length()>20)
			throw new IllegalArgumentException("OpenclassidOpenClassID值"+aOpenClassID+"的长度"+aOpenClassID.length()+"大于最大值20");
		OpenClassID = aOpenClassID;
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
	public String getChannelCode()
	{
		return ChannelCode;
	}
	public void setChannelCode(String aChannelCode)
	{
		if(aChannelCode!=null && aChannelCode.length()>2)
			throw new IllegalArgumentException("ChannelcodeChannelCode值"+aChannelCode+"的长度"+aChannelCode.length()+"大于最大值2");
		ChannelCode = aChannelCode;
	}
	public String getTeacherCode()
	{
		return TeacherCode;
	}
	public void setTeacherCode(String aTeacherCode)
	{
		if(aTeacherCode!=null && aTeacherCode.length()>12)
			throw new IllegalArgumentException("TeachercodeTeacherCode值"+aTeacherCode+"的长度"+aTeacherCode.length()+"大于最大值12");
		TeacherCode = aTeacherCode;
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
	* 使用另外一个 LAClassOpenVsCourseBSchema 对象给 Schema 赋值
	* @param: aLAClassOpenVsCourseBSchema LAClassOpenVsCourseBSchema
	**/
	public void setSchema(LAClassOpenVsCourseBSchema aLAClassOpenVsCourseBSchema)
	{
		this.OpenClassID = aLAClassOpenVsCourseBSchema.getOpenClassID();
		this.CourseID = aLAClassOpenVsCourseBSchema.getCourseID();
		this.ChannelCode = aLAClassOpenVsCourseBSchema.getChannelCode();
		this.TeacherCode = aLAClassOpenVsCourseBSchema.getTeacherCode();
		this.MakeDate = fDate.getDate( aLAClassOpenVsCourseBSchema.getMakeDate());
		this.MakeTime = aLAClassOpenVsCourseBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAClassOpenVsCourseBSchema.getModifyDate());
		this.ModifyTime = aLAClassOpenVsCourseBSchema.getModifyTime();
		this.Operator = aLAClassOpenVsCourseBSchema.getOperator();
		this.MakeDate1 = fDate.getDate( aLAClassOpenVsCourseBSchema.getMakeDate1());
		this.MakeTime1 = aLAClassOpenVsCourseBSchema.getMakeTime1();
		this.Operator1 = aLAClassOpenVsCourseBSchema.getOperator1();
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
			if( rs.getString("OpenClassID") == null )
				this.OpenClassID = null;
			else
				this.OpenClassID = rs.getString("OpenClassID").trim();

			if( rs.getString("CourseID") == null )
				this.CourseID = null;
			else
				this.CourseID = rs.getString("CourseID").trim();

			if( rs.getString("ChannelCode") == null )
				this.ChannelCode = null;
			else
				this.ChannelCode = rs.getString("ChannelCode").trim();

			if( rs.getString("TeacherCode") == null )
				this.TeacherCode = null;
			else
				this.TeacherCode = rs.getString("TeacherCode").trim();

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

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

			if( rs.getString("Operator1") == null )
				this.Operator1 = null;
			else
				this.Operator1 = rs.getString("Operator1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAClassOpenVsCourseB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAClassOpenVsCourseBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAClassOpenVsCourseBSchema getSchema()
	{
		LAClassOpenVsCourseBSchema aLAClassOpenVsCourseBSchema = new LAClassOpenVsCourseBSchema();
		aLAClassOpenVsCourseBSchema.setSchema(this);
		return aLAClassOpenVsCourseBSchema;
	}

	public LAClassOpenVsCourseBDB getDB()
	{
		LAClassOpenVsCourseBDB aDBOper = new LAClassOpenVsCourseBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAClassOpenVsCourseB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(OpenClassID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CourseID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ChannelCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TeacherCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAClassOpenVsCourseB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			OpenClassID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			CourseID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ChannelCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			TeacherCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAClassOpenVsCourseBSchema";
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
		if (FCode.equalsIgnoreCase("OpenClassID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OpenClassID));
		}
		if (FCode.equalsIgnoreCase("CourseID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CourseID));
		}
		if (FCode.equalsIgnoreCase("ChannelCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ChannelCode));
		}
		if (FCode.equalsIgnoreCase("TeacherCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TeacherCode));
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
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime1));
		}
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator1));
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
				strFieldValue = StrTool.GBKToUnicode(OpenClassID);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(CourseID);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ChannelCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(TeacherCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
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

		if (FCode.equalsIgnoreCase("OpenClassID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OpenClassID = FValue.trim();
			}
			else
				OpenClassID = null;
		}
		if (FCode.equalsIgnoreCase("CourseID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CourseID = FValue.trim();
			}
			else
				CourseID = null;
		}
		if (FCode.equalsIgnoreCase("ChannelCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ChannelCode = FValue.trim();
			}
			else
				ChannelCode = null;
		}
		if (FCode.equalsIgnoreCase("TeacherCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TeacherCode = FValue.trim();
			}
			else
				TeacherCode = null;
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
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator1 = FValue.trim();
			}
			else
				Operator1 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAClassOpenVsCourseBSchema other = (LAClassOpenVsCourseBSchema)otherObject;
		return
			OpenClassID.equals(other.getOpenClassID())
			&& CourseID.equals(other.getCourseID())
			&& ChannelCode.equals(other.getChannelCode())
			&& TeacherCode.equals(other.getTeacherCode())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1())
			&& Operator1.equals(other.getOperator1());
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
		if( strFieldName.equals("OpenClassID") ) {
			return 0;
		}
		if( strFieldName.equals("CourseID") ) {
			return 1;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return 2;
		}
		if( strFieldName.equals("TeacherCode") ) {
			return 3;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 4;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 5;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 6;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 7;
		}
		if( strFieldName.equals("Operator") ) {
			return 8;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 9;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 10;
		}
		if( strFieldName.equals("Operator1") ) {
			return 11;
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
				strFieldName = "OpenClassID";
				break;
			case 1:
				strFieldName = "CourseID";
				break;
			case 2:
				strFieldName = "ChannelCode";
				break;
			case 3:
				strFieldName = "TeacherCode";
				break;
			case 4:
				strFieldName = "MakeDate";
				break;
			case 5:
				strFieldName = "MakeTime";
				break;
			case 6:
				strFieldName = "ModifyDate";
				break;
			case 7:
				strFieldName = "ModifyTime";
				break;
			case 8:
				strFieldName = "Operator";
				break;
			case 9:
				strFieldName = "MakeDate1";
				break;
			case 10:
				strFieldName = "MakeTime1";
				break;
			case 11:
				strFieldName = "Operator1";
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
		if( strFieldName.equals("OpenClassID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CourseID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TeacherCode") ) {
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
		if( strFieldName.equals("MakeDate1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator1") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
