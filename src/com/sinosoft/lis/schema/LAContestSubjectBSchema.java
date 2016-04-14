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
import com.sinosoft.lis.db.LAContestSubjectBDB;

/*
 * <p>ClassName: LAContestSubjectBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAContestSubjectBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAContestSubjectBSchema.class);
	// @Field
	/** Contetcode */
	private String ContetCode;
	/** Subjectcode */
	private String SubjectCode;
	/** Subjecttype */
	private String SubjectType;
	/** Baktype */
	private String BakType;
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
	/** Modifydate1 */
	private Date ModifyDate1;
	/** Modifytime1 */
	private String ModifyTime1;

	public static final int FIELDNUM = 12;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAContestSubjectBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[6];
		pk[0] = "ContetCode";
		pk[1] = "SubjectCode";
		pk[2] = "SubjectType";
		pk[3] = "Operator1";
		pk[4] = "ModifyDate1";
		pk[5] = "ModifyTime1";

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
		LAContestSubjectBSchema cloned = (LAContestSubjectBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getContetCode()
	{
		return ContetCode;
	}
	public void setContetCode(String aContetCode)
	{
		if(aContetCode!=null && aContetCode.length()>10)
			throw new IllegalArgumentException("ContetcodeContetCode值"+aContetCode+"的长度"+aContetCode.length()+"大于最大值10");
		ContetCode = aContetCode;
	}
	public String getSubjectCode()
	{
		return SubjectCode;
	}
	public void setSubjectCode(String aSubjectCode)
	{
		if(aSubjectCode!=null && aSubjectCode.length()>12)
			throw new IllegalArgumentException("SubjectcodeSubjectCode值"+aSubjectCode+"的长度"+aSubjectCode.length()+"大于最大值12");
		SubjectCode = aSubjectCode;
	}
	public String getSubjectType()
	{
		return SubjectType;
	}
	public void setSubjectType(String aSubjectType)
	{
		if(aSubjectType!=null && aSubjectType.length()>2)
			throw new IllegalArgumentException("SubjecttypeSubjectType值"+aSubjectType+"的长度"+aSubjectType.length()+"大于最大值2");
		SubjectType = aSubjectType;
	}
	public String getBakType()
	{
		return BakType;
	}
	public void setBakType(String aBakType)
	{
		if(aBakType!=null && aBakType.length()>2)
			throw new IllegalArgumentException("BaktypeBakType值"+aBakType+"的长度"+aBakType.length()+"大于最大值2");
		BakType = aBakType;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>12)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值12");
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
	public String getModifyDate1()
	{
		if( ModifyDate1 != null )
			return fDate.getString(ModifyDate1);
		else
			return null;
	}
	public void setModifyDate1(Date aModifyDate1)
	{
		ModifyDate1 = aModifyDate1;
	}
	public void setModifyDate1(String aModifyDate1)
	{
		if (aModifyDate1 != null && !aModifyDate1.equals("") )
		{
			ModifyDate1 = fDate.getDate( aModifyDate1 );
		}
		else
			ModifyDate1 = null;
	}

	public String getModifyTime1()
	{
		return ModifyTime1;
	}
	public void setModifyTime1(String aModifyTime1)
	{
		if(aModifyTime1!=null && aModifyTime1.length()>8)
			throw new IllegalArgumentException("Modifytime1ModifyTime1值"+aModifyTime1+"的长度"+aModifyTime1.length()+"大于最大值8");
		ModifyTime1 = aModifyTime1;
	}

	/**
	* 使用另外一个 LAContestSubjectBSchema 对象给 Schema 赋值
	* @param: aLAContestSubjectBSchema LAContestSubjectBSchema
	**/
	public void setSchema(LAContestSubjectBSchema aLAContestSubjectBSchema)
	{
		this.ContetCode = aLAContestSubjectBSchema.getContetCode();
		this.SubjectCode = aLAContestSubjectBSchema.getSubjectCode();
		this.SubjectType = aLAContestSubjectBSchema.getSubjectType();
		this.BakType = aLAContestSubjectBSchema.getBakType();
		this.Operator = aLAContestSubjectBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAContestSubjectBSchema.getMakeDate());
		this.MakeTime = aLAContestSubjectBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAContestSubjectBSchema.getModifyDate());
		this.ModifyTime = aLAContestSubjectBSchema.getModifyTime();
		this.Operator1 = aLAContestSubjectBSchema.getOperator1();
		this.ModifyDate1 = fDate.getDate( aLAContestSubjectBSchema.getModifyDate1());
		this.ModifyTime1 = aLAContestSubjectBSchema.getModifyTime1();
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
			if( rs.getString("ContetCode") == null )
				this.ContetCode = null;
			else
				this.ContetCode = rs.getString("ContetCode").trim();

			if( rs.getString("SubjectCode") == null )
				this.SubjectCode = null;
			else
				this.SubjectCode = rs.getString("SubjectCode").trim();

			if( rs.getString("SubjectType") == null )
				this.SubjectType = null;
			else
				this.SubjectType = rs.getString("SubjectType").trim();

			if( rs.getString("BakType") == null )
				this.BakType = null;
			else
				this.BakType = rs.getString("BakType").trim();

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

			this.ModifyDate1 = rs.getDate("ModifyDate1");
			if( rs.getString("ModifyTime1") == null )
				this.ModifyTime1 = null;
			else
				this.ModifyTime1 = rs.getString("ModifyTime1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAContestSubjectB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAContestSubjectBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAContestSubjectBSchema getSchema()
	{
		LAContestSubjectBSchema aLAContestSubjectBSchema = new LAContestSubjectBSchema();
		aLAContestSubjectBSchema.setSchema(this);
		return aLAContestSubjectBSchema;
	}

	public LAContestSubjectBDB getDB()
	{
		LAContestSubjectBDB aDBOper = new LAContestSubjectBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAContestSubjectB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ContetCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubjectCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubjectType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BakType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAContestSubjectB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ContetCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			SubjectCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			SubjectType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BakType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ModifyDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			ModifyTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAContestSubjectBSchema";
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
		if (FCode.equalsIgnoreCase("ContetCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContetCode));
		}
		if (FCode.equalsIgnoreCase("SubjectCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectCode));
		}
		if (FCode.equalsIgnoreCase("SubjectType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectType));
		}
		if (FCode.equalsIgnoreCase("BakType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakType));
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
		if (FCode.equalsIgnoreCase("ModifyDate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate1()));
		}
		if (FCode.equalsIgnoreCase("ModifyTime1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime1));
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
				strFieldValue = StrTool.GBKToUnicode(ContetCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(SubjectCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(SubjectType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(BakType);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate1()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime1);
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

		if (FCode.equalsIgnoreCase("ContetCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ContetCode = FValue.trim();
			}
			else
				ContetCode = null;
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
		if (FCode.equalsIgnoreCase("SubjectType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SubjectType = FValue.trim();
			}
			else
				SubjectType = null;
		}
		if (FCode.equalsIgnoreCase("BakType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BakType = FValue.trim();
			}
			else
				BakType = null;
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
		if (FCode.equalsIgnoreCase("ModifyDate1"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ModifyDate1 = fDate.getDate( FValue );
			}
			else
				ModifyDate1 = null;
		}
		if (FCode.equalsIgnoreCase("ModifyTime1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyTime1 = FValue.trim();
			}
			else
				ModifyTime1 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAContestSubjectBSchema other = (LAContestSubjectBSchema)otherObject;
		return
			ContetCode.equals(other.getContetCode())
			&& SubjectCode.equals(other.getSubjectCode())
			&& SubjectType.equals(other.getSubjectType())
			&& BakType.equals(other.getBakType())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator1.equals(other.getOperator1())
			&& fDate.getString(ModifyDate1).equals(other.getModifyDate1())
			&& ModifyTime1.equals(other.getModifyTime1());
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
		if( strFieldName.equals("ContetCode") ) {
			return 0;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return 1;
		}
		if( strFieldName.equals("SubjectType") ) {
			return 2;
		}
		if( strFieldName.equals("BakType") ) {
			return 3;
		}
		if( strFieldName.equals("Operator") ) {
			return 4;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 5;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 6;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 7;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 8;
		}
		if( strFieldName.equals("Operator1") ) {
			return 9;
		}
		if( strFieldName.equals("ModifyDate1") ) {
			return 10;
		}
		if( strFieldName.equals("ModifyTime1") ) {
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
				strFieldName = "ContetCode";
				break;
			case 1:
				strFieldName = "SubjectCode";
				break;
			case 2:
				strFieldName = "SubjectType";
				break;
			case 3:
				strFieldName = "BakType";
				break;
			case 4:
				strFieldName = "Operator";
				break;
			case 5:
				strFieldName = "MakeDate";
				break;
			case 6:
				strFieldName = "MakeTime";
				break;
			case 7:
				strFieldName = "ModifyDate";
				break;
			case 8:
				strFieldName = "ModifyTime";
				break;
			case 9:
				strFieldName = "Operator1";
				break;
			case 10:
				strFieldName = "ModifyDate1";
				break;
			case 11:
				strFieldName = "ModifyTime1";
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
		if( strFieldName.equals("ContetCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubjectType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BakType") ) {
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
		if( strFieldName.equals("Operator1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ModifyDate1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ModifyTime1") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
