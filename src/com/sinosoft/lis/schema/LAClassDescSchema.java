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
import com.sinosoft.lis.db.LAClassDescDB;

/*
 * <p>ClassName: LAClassDescSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAClassDescSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAClassDescSchema.class);
	// @Field
	/** Classno */
	private String ClassNo;
	/** Channelcode */
	private String ChannelCode;
	/** Classname */
	private String ClassName;
	/** Receigrade */
	private String ReceiGrade;
	/** Classseries */
	private String ClassSeries;
	/** Stopflag */
	private String StopFlag;
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

	public static final int FIELDNUM = 11;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAClassDescSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "ClassNo";
		pk[1] = "ChannelCode";

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
		LAClassDescSchema cloned = (LAClassDescSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getClassNo()
	{
		return ClassNo;
	}
	public void setClassNo(String aClassNo)
	{
		if(aClassNo!=null && aClassNo.length()>15)
			throw new IllegalArgumentException("ClassnoClassNo值"+aClassNo+"的长度"+aClassNo.length()+"大于最大值15");
		ClassNo = aClassNo;
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
	public String getClassName()
	{
		return ClassName;
	}
	public void setClassName(String aClassName)
	{
		if(aClassName!=null && aClassName.length()>100)
			throw new IllegalArgumentException("ClassnameClassName值"+aClassName+"的长度"+aClassName.length()+"大于最大值100");
		ClassName = aClassName;
	}
	public String getReceiGrade()
	{
		return ReceiGrade;
	}
	public void setReceiGrade(String aReceiGrade)
	{
		if(aReceiGrade!=null && aReceiGrade.length()>5)
			throw new IllegalArgumentException("ReceigradeReceiGrade值"+aReceiGrade+"的长度"+aReceiGrade.length()+"大于最大值5");
		ReceiGrade = aReceiGrade;
	}
	public String getClassSeries()
	{
		return ClassSeries;
	}
	public void setClassSeries(String aClassSeries)
	{
		if(aClassSeries!=null && aClassSeries.length()>5)
			throw new IllegalArgumentException("ClassseriesClassSeries值"+aClassSeries+"的长度"+aClassSeries.length()+"大于最大值5");
		ClassSeries = aClassSeries;
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
	* 使用另外一个 LAClassDescSchema 对象给 Schema 赋值
	* @param: aLAClassDescSchema LAClassDescSchema
	**/
	public void setSchema(LAClassDescSchema aLAClassDescSchema)
	{
		this.ClassNo = aLAClassDescSchema.getClassNo();
		this.ChannelCode = aLAClassDescSchema.getChannelCode();
		this.ClassName = aLAClassDescSchema.getClassName();
		this.ReceiGrade = aLAClassDescSchema.getReceiGrade();
		this.ClassSeries = aLAClassDescSchema.getClassSeries();
		this.StopFlag = aLAClassDescSchema.getStopFlag();
		this.MakeDate = fDate.getDate( aLAClassDescSchema.getMakeDate());
		this.MakeTime = aLAClassDescSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAClassDescSchema.getModifyDate());
		this.ModifyTime = aLAClassDescSchema.getModifyTime();
		this.Operator = aLAClassDescSchema.getOperator();
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
			if( rs.getString("ClassNo") == null )
				this.ClassNo = null;
			else
				this.ClassNo = rs.getString("ClassNo").trim();

			if( rs.getString("ChannelCode") == null )
				this.ChannelCode = null;
			else
				this.ChannelCode = rs.getString("ChannelCode").trim();

			if( rs.getString("ClassName") == null )
				this.ClassName = null;
			else
				this.ClassName = rs.getString("ClassName").trim();

			if( rs.getString("ReceiGrade") == null )
				this.ReceiGrade = null;
			else
				this.ReceiGrade = rs.getString("ReceiGrade").trim();

			if( rs.getString("ClassSeries") == null )
				this.ClassSeries = null;
			else
				this.ClassSeries = rs.getString("ClassSeries").trim();

			if( rs.getString("StopFlag") == null )
				this.StopFlag = null;
			else
				this.StopFlag = rs.getString("StopFlag").trim();

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
			logger.debug("数据库中的LAClassDesc表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAClassDescSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAClassDescSchema getSchema()
	{
		LAClassDescSchema aLAClassDescSchema = new LAClassDescSchema();
		aLAClassDescSchema.setSchema(this);
		return aLAClassDescSchema;
	}

	public LAClassDescDB getDB()
	{
		LAClassDescDB aDBOper = new LAClassDescDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAClassDesc描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ClassNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ChannelCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ClassName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReceiGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ClassSeries)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(StopFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAClassDesc>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ClassNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ChannelCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ClassName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ReceiGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ClassSeries = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			StopFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAClassDescSchema";
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
		if (FCode.equalsIgnoreCase("ClassNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ClassNo));
		}
		if (FCode.equalsIgnoreCase("ChannelCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ChannelCode));
		}
		if (FCode.equalsIgnoreCase("ClassName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ClassName));
		}
		if (FCode.equalsIgnoreCase("ReceiGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReceiGrade));
		}
		if (FCode.equalsIgnoreCase("ClassSeries"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ClassSeries));
		}
		if (FCode.equalsIgnoreCase("StopFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(StopFlag));
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
				strFieldValue = StrTool.GBKToUnicode(ClassNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ChannelCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ClassName);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ReceiGrade);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ClassSeries);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(StopFlag);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 10:
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

		if (FCode.equalsIgnoreCase("ClassNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ClassNo = FValue.trim();
			}
			else
				ClassNo = null;
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
		if (FCode.equalsIgnoreCase("ClassName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ClassName = FValue.trim();
			}
			else
				ClassName = null;
		}
		if (FCode.equalsIgnoreCase("ReceiGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReceiGrade = FValue.trim();
			}
			else
				ReceiGrade = null;
		}
		if (FCode.equalsIgnoreCase("ClassSeries"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ClassSeries = FValue.trim();
			}
			else
				ClassSeries = null;
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
		LAClassDescSchema other = (LAClassDescSchema)otherObject;
		return
			ClassNo.equals(other.getClassNo())
			&& ChannelCode.equals(other.getChannelCode())
			&& ClassName.equals(other.getClassName())
			&& ReceiGrade.equals(other.getReceiGrade())
			&& ClassSeries.equals(other.getClassSeries())
			&& StopFlag.equals(other.getStopFlag())
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
		if( strFieldName.equals("ClassNo") ) {
			return 0;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return 1;
		}
		if( strFieldName.equals("ClassName") ) {
			return 2;
		}
		if( strFieldName.equals("ReceiGrade") ) {
			return 3;
		}
		if( strFieldName.equals("ClassSeries") ) {
			return 4;
		}
		if( strFieldName.equals("StopFlag") ) {
			return 5;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 6;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 7;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 8;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 9;
		}
		if( strFieldName.equals("Operator") ) {
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
				strFieldName = "ClassNo";
				break;
			case 1:
				strFieldName = "ChannelCode";
				break;
			case 2:
				strFieldName = "ClassName";
				break;
			case 3:
				strFieldName = "ReceiGrade";
				break;
			case 4:
				strFieldName = "ClassSeries";
				break;
			case 5:
				strFieldName = "StopFlag";
				break;
			case 6:
				strFieldName = "MakeDate";
				break;
			case 7:
				strFieldName = "MakeTime";
				break;
			case 8:
				strFieldName = "ModifyDate";
				break;
			case 9:
				strFieldName = "ModifyTime";
				break;
			case 10:
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
		if( strFieldName.equals("ClassNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ClassName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReceiGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ClassSeries") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StopFlag") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 7:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 8:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
