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
import com.sinosoft.lis.db.DailyCMSLogDB;

/*
 * <p>ClassName: DailyCMSLogSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyCMSLogSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(DailyCMSLogSchema.class);
	// @Field
	/** Batch_file_id */
	private String Batch_File_ID;
	/** Batch_date */
	private double Batch_Date;
	/** Batch_no */
	private double Batch_No;
	/** No_of_records */
	private double No_Of_Records;
	/** Complete_status */
	private String Complete_Status;

	public static final int FIELDNUM = 5;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public DailyCMSLogSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[3];
		pk[0] = "Batch_File_ID";
		pk[1] = "Batch_Date";
		pk[2] = "Batch_No";

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
		DailyCMSLogSchema cloned = (DailyCMSLogSchema)super.clone();
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

	public double getNo_Of_Records()
	{
		return No_Of_Records;
	}
	public void setNo_Of_Records(double aNo_Of_Records)
	{
		No_Of_Records = aNo_Of_Records;
	}
	public void setNo_Of_Records(String aNo_Of_Records)
	{
		if (aNo_Of_Records != null && !aNo_Of_Records.equals(""))
		{
			Double tDouble = new Double(aNo_Of_Records);
			double d = tDouble.doubleValue();
			No_Of_Records = d;
		}
	}

	public String getComplete_Status()
	{
		return Complete_Status;
	}
	public void setComplete_Status(String aComplete_Status)
	{
		if(aComplete_Status!=null && aComplete_Status.length()>1)
			throw new IllegalArgumentException("Complete_statusComplete_Status值"+aComplete_Status+"的长度"+aComplete_Status.length()+"大于最大值1");
		Complete_Status = aComplete_Status;
	}

	/**
	* 使用另外一个 DailyCMSLogSchema 对象给 Schema 赋值
	* @param: aDailyCMSLogSchema DailyCMSLogSchema
	**/
	public void setSchema(DailyCMSLogSchema aDailyCMSLogSchema)
	{
		this.Batch_File_ID = aDailyCMSLogSchema.getBatch_File_ID();
		this.Batch_Date = aDailyCMSLogSchema.getBatch_Date();
		this.Batch_No = aDailyCMSLogSchema.getBatch_No();
		this.No_Of_Records = aDailyCMSLogSchema.getNo_Of_Records();
		this.Complete_Status = aDailyCMSLogSchema.getComplete_Status();
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
			this.No_Of_Records = rs.getDouble("No_Of_Records");
			if( rs.getString("Complete_Status") == null )
				this.Complete_Status = null;
			else
				this.Complete_Status = rs.getString("Complete_Status").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的DailyCMSLog表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyCMSLogSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public DailyCMSLogSchema getSchema()
	{
		DailyCMSLogSchema aDailyCMSLogSchema = new DailyCMSLogSchema();
		aDailyCMSLogSchema.setSchema(this);
		return aDailyCMSLogSchema;
	}

	public DailyCMSLogDB getDB()
	{
		DailyCMSLogDB aDBOper = new DailyCMSLogDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyCMSLog描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(Batch_File_ID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Batch_Date));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Batch_No));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(No_Of_Records));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Complete_Status));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyCMSLog>历史记账凭证主表信息</A>表字段
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
			No_Of_Records = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,4,SysConst.PACKAGESPILTER))).doubleValue();
			Complete_Status = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyCMSLogSchema";
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
		if (FCode.equalsIgnoreCase("No_Of_Records"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(No_Of_Records));
		}
		if (FCode.equalsIgnoreCase("Complete_Status"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Complete_Status));
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
				strFieldValue = String.valueOf(No_Of_Records);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Complete_Status);
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
		if (FCode.equalsIgnoreCase("No_Of_Records"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				No_Of_Records = d;
			}
		}
		if (FCode.equalsIgnoreCase("Complete_Status"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Complete_Status = FValue.trim();
			}
			else
				Complete_Status = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		DailyCMSLogSchema other = (DailyCMSLogSchema)otherObject;
		return
			Batch_File_ID.equals(other.getBatch_File_ID())
			&& Batch_Date == other.getBatch_Date()
			&& Batch_No == other.getBatch_No()
			&& No_Of_Records == other.getNo_Of_Records()
			&& Complete_Status.equals(other.getComplete_Status());
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
		if( strFieldName.equals("No_Of_Records") ) {
			return 3;
		}
		if( strFieldName.equals("Complete_Status") ) {
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
				strFieldName = "No_Of_Records";
				break;
			case 4:
				strFieldName = "Complete_Status";
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
		if( strFieldName.equals("No_Of_Records") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Complete_Status") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
