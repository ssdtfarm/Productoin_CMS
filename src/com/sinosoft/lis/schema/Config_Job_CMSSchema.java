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
import com.sinosoft.lis.db.Config_Job_CMSDB;

/*
 * <p>ClassName: Config_Job_CMSSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class Config_Job_CMSSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(Config_Job_CMSSchema.class);
	// @Field
	/** Batch_file_id */
	private String Batch_File_ID;
	/** Batch_date */
	private double Batch_Date;
	/** Batch_no */
	private double Batch_No;
	/** Max_modifydate */
	private Date Max_ModifyDate;
	/** Max_modifytime */
	private String Max_ModifyTime;

	public static final int FIELDNUM = 5;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public Config_Job_CMSSchema()
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
		Config_Job_CMSSchema cloned = (Config_Job_CMSSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getBatch_File_ID()
	{
		return Batch_File_ID;
	}
	public void setBatch_File_ID(String aBatch_File_ID)
	{
		if(aBatch_File_ID!=null && aBatch_File_ID.length()>10)
			throw new IllegalArgumentException("Batch_file_idBatch_File_ID值"+aBatch_File_ID+"的长度"+aBatch_File_ID.length()+"大于最大值10");
		Batch_File_ID = aBatch_File_ID;
	}
	public double getBatch_Date()
	{
		return Batch_Date;
	}
	public void setBatch_Date(double aBatch_Date)
	{
		Batch_Date = aBatch_Date;
	}
	public void setBatch_Date(String aBatch_Date)
	{
		if (aBatch_Date != null && !aBatch_Date.equals(""))
		{
			Double tDouble = new Double(aBatch_Date);
			double d = tDouble.doubleValue();
			Batch_Date = d;
		}
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

	public String getMax_ModifyDate()
	{
		if( Max_ModifyDate != null )
			return fDate.getString(Max_ModifyDate);
		else
			return null;
	}
	public void setMax_ModifyDate(Date aMax_ModifyDate)
	{
		Max_ModifyDate = aMax_ModifyDate;
	}
	public void setMax_ModifyDate(String aMax_ModifyDate)
	{
		if (aMax_ModifyDate != null && !aMax_ModifyDate.equals("") )
		{
			Max_ModifyDate = fDate.getDate( aMax_ModifyDate );
		}
		else
			Max_ModifyDate = null;
	}

	public String getMax_ModifyTime()
	{
		return Max_ModifyTime;
	}
	public void setMax_ModifyTime(String aMax_ModifyTime)
	{
		if(aMax_ModifyTime!=null && aMax_ModifyTime.length()>8)
			throw new IllegalArgumentException("Max_modifytimeMax_ModifyTime值"+aMax_ModifyTime+"的长度"+aMax_ModifyTime.length()+"大于最大值8");
		Max_ModifyTime = aMax_ModifyTime;
	}

	/**
	* 使用另外一个 Config_Job_CMSSchema 对象给 Schema 赋值
	* @param: aConfig_Job_CMSSchema Config_Job_CMSSchema
	**/
	public void setSchema(Config_Job_CMSSchema aConfig_Job_CMSSchema)
	{
		this.Batch_File_ID = aConfig_Job_CMSSchema.getBatch_File_ID();
		this.Batch_Date = aConfig_Job_CMSSchema.getBatch_Date();
		this.Batch_No = aConfig_Job_CMSSchema.getBatch_No();
		this.Max_ModifyDate = fDate.getDate( aConfig_Job_CMSSchema.getMax_ModifyDate());
		this.Max_ModifyTime = aConfig_Job_CMSSchema.getMax_ModifyTime();
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
			if( rs.getString("Batch_File_ID") == null )
				this.Batch_File_ID = null;
			else
				this.Batch_File_ID = rs.getString("Batch_File_ID").trim();

			this.Batch_Date = rs.getDouble("Batch_Date");
			this.Batch_No = rs.getDouble("Batch_No");
			this.Max_ModifyDate = rs.getDate("Max_ModifyDate");
			if( rs.getString("Max_ModifyTime") == null )
				this.Max_ModifyTime = null;
			else
				this.Max_ModifyTime = rs.getString("Max_ModifyTime").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的Config_Job_CMS表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "Config_Job_CMSSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public Config_Job_CMSSchema getSchema()
	{
		Config_Job_CMSSchema aConfig_Job_CMSSchema = new Config_Job_CMSSchema();
		aConfig_Job_CMSSchema.setSchema(this);
		return aConfig_Job_CMSSchema;
	}

	public Config_Job_CMSDB getDB()
	{
		Config_Job_CMSDB aDBOper = new Config_Job_CMSDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpConfig_Job_CMS描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(Batch_File_ID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Batch_Date));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Batch_No));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Max_ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Max_ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpConfig_Job_CMS>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			Batch_File_ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Batch_Date = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,2,SysConst.PACKAGESPILTER))).doubleValue();
			Batch_No = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,3,SysConst.PACKAGESPILTER))).doubleValue();
			Max_ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,SysConst.PACKAGESPILTER));
			Max_ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "Config_Job_CMSSchema";
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
		if (FCode.equalsIgnoreCase("Batch_File_ID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Batch_File_ID));
		}
		if (FCode.equalsIgnoreCase("Batch_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Batch_Date));
		}
		if (FCode.equalsIgnoreCase("Batch_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Batch_No));
		}
		if (FCode.equalsIgnoreCase("Max_ModifyDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMax_ModifyDate()));
		}
		if (FCode.equalsIgnoreCase("Max_ModifyTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Max_ModifyTime));
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
				strFieldValue = StrTool.GBKToUnicode(Batch_File_ID);
				break;
			case 1:
				strFieldValue = String.valueOf(Batch_Date);
				break;
			case 2:
				strFieldValue = String.valueOf(Batch_No);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMax_ModifyDate()));
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Max_ModifyTime);
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

		if (FCode.equalsIgnoreCase("Batch_File_ID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Batch_File_ID = FValue.trim();
			}
			else
				Batch_File_ID = null;
		}
		if (FCode.equalsIgnoreCase("Batch_Date"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Batch_Date = d;
			}
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
		if (FCode.equalsIgnoreCase("Max_ModifyDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Max_ModifyDate = fDate.getDate( FValue );
			}
			else
				Max_ModifyDate = null;
		}
		if (FCode.equalsIgnoreCase("Max_ModifyTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Max_ModifyTime = FValue.trim();
			}
			else
				Max_ModifyTime = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		Config_Job_CMSSchema other = (Config_Job_CMSSchema)otherObject;
		return
			Batch_File_ID.equals(other.getBatch_File_ID())
			&& Batch_Date == other.getBatch_Date()
			&& Batch_No == other.getBatch_No()
			&& fDate.getString(Max_ModifyDate).equals(other.getMax_ModifyDate())
			&& Max_ModifyTime.equals(other.getMax_ModifyTime());
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
		if( strFieldName.equals("Batch_File_ID") ) {
			return 0;
		}
		if( strFieldName.equals("Batch_Date") ) {
			return 1;
		}
		if( strFieldName.equals("Batch_No") ) {
			return 2;
		}
		if( strFieldName.equals("Max_ModifyDate") ) {
			return 3;
		}
		if( strFieldName.equals("Max_ModifyTime") ) {
			return 4;
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
				strFieldName = "Batch_File_ID";
				break;
			case 1:
				strFieldName = "Batch_Date";
				break;
			case 2:
				strFieldName = "Batch_No";
				break;
			case 3:
				strFieldName = "Max_ModifyDate";
				break;
			case 4:
				strFieldName = "Max_ModifyTime";
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
		if( strFieldName.equals("Batch_File_ID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Batch_Date") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Batch_No") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Max_ModifyDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Max_ModifyTime") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 2:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 3:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 4:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
