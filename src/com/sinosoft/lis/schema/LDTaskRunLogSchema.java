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
import com.sinosoft.lis.db.LDTaskRunLogDB;

/*
 * <p>ClassName: LDTaskRunLogSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDTaskRunLogSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDTaskRunLogSchema.class);
	// @Field
	/** Serialno */
	private double SerialNo;
	/** Taskcode */
	private String TaskCode;
	/** Taskplancode */
	private String TaskPlanCode;
	/** Executedate */
	private Date ExecuteDate;
	/** Executetime */
	private String ExecuteTime;
	/** Finishdate */
	private Date FinishDate;
	/** Finishtime */
	private String FinishTime;
	/** Executefrequence */
	private double ExecuteFrequence;
	/** Executestate */
	private String ExecuteState;
	/** Executeresult */
	private String ExecuteResult;

	public static final int FIELDNUM = 10;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDTaskRunLogSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "SerialNo";

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
		LDTaskRunLogSchema cloned = (LDTaskRunLogSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public double getSerialNo()
	{
		return SerialNo;
	}
	public void setSerialNo(double aSerialNo)
	{
		SerialNo = aSerialNo;
	}
	public void setSerialNo(String aSerialNo)
	{
		if (aSerialNo != null && !aSerialNo.equals(""))
		{
			Double tDouble = new Double(aSerialNo);
			double d = tDouble.doubleValue();
			SerialNo = d;
		}
	}

	public String getTaskCode()
	{
		return TaskCode;
	}
	public void setTaskCode(String aTaskCode)
	{
		if(aTaskCode!=null && aTaskCode.length()>6)
			throw new IllegalArgumentException("TaskcodeTaskCode值"+aTaskCode+"的长度"+aTaskCode.length()+"大于最大值6");
		TaskCode = aTaskCode;
	}
	public String getTaskPlanCode()
	{
		return TaskPlanCode;
	}
	public void setTaskPlanCode(String aTaskPlanCode)
	{
		if(aTaskPlanCode!=null && aTaskPlanCode.length()>6)
			throw new IllegalArgumentException("TaskplancodeTaskPlanCode值"+aTaskPlanCode+"的长度"+aTaskPlanCode.length()+"大于最大值6");
		TaskPlanCode = aTaskPlanCode;
	}
	public String getExecuteDate()
	{
		if( ExecuteDate != null )
			return fDate.getString(ExecuteDate);
		else
			return null;
	}
	public void setExecuteDate(Date aExecuteDate)
	{
		ExecuteDate = aExecuteDate;
	}
	public void setExecuteDate(String aExecuteDate)
	{
		if (aExecuteDate != null && !aExecuteDate.equals("") )
		{
			ExecuteDate = fDate.getDate( aExecuteDate );
		}
		else
			ExecuteDate = null;
	}

	public String getExecuteTime()
	{
		return ExecuteTime;
	}
	public void setExecuteTime(String aExecuteTime)
	{
		if(aExecuteTime!=null && aExecuteTime.length()>8)
			throw new IllegalArgumentException("ExecutetimeExecuteTime值"+aExecuteTime+"的长度"+aExecuteTime.length()+"大于最大值8");
		ExecuteTime = aExecuteTime;
	}
	public String getFinishDate()
	{
		if( FinishDate != null )
			return fDate.getString(FinishDate);
		else
			return null;
	}
	public void setFinishDate(Date aFinishDate)
	{
		FinishDate = aFinishDate;
	}
	public void setFinishDate(String aFinishDate)
	{
		if (aFinishDate != null && !aFinishDate.equals("") )
		{
			FinishDate = fDate.getDate( aFinishDate );
		}
		else
			FinishDate = null;
	}

	public String getFinishTime()
	{
		return FinishTime;
	}
	public void setFinishTime(String aFinishTime)
	{
		if(aFinishTime!=null && aFinishTime.length()>8)
			throw new IllegalArgumentException("FinishtimeFinishTime值"+aFinishTime+"的长度"+aFinishTime.length()+"大于最大值8");
		FinishTime = aFinishTime;
	}
	public double getExecuteFrequence()
	{
		return ExecuteFrequence;
	}
	public void setExecuteFrequence(double aExecuteFrequence)
	{
		ExecuteFrequence = aExecuteFrequence;
	}
	public void setExecuteFrequence(String aExecuteFrequence)
	{
		if (aExecuteFrequence != null && !aExecuteFrequence.equals(""))
		{
			Double tDouble = new Double(aExecuteFrequence);
			double d = tDouble.doubleValue();
			ExecuteFrequence = d;
		}
	}

	/**
	* 3 - 执行成功
	*/
	public String getExecuteState()
	{
		return ExecuteState;
	}
	public void setExecuteState(String aExecuteState)
	{
		if(aExecuteState!=null && aExecuteState.length()>1)
			throw new IllegalArgumentException("ExecutestateExecuteState值"+aExecuteState+"的长度"+aExecuteState.length()+"大于最大值1");
		ExecuteState = aExecuteState;
	}
	public String getExecuteResult()
	{
		return ExecuteResult;
	}
	public void setExecuteResult(String aExecuteResult)
	{
		if(aExecuteResult!=null && aExecuteResult.length()>900)
			throw new IllegalArgumentException("ExecuteresultExecuteResult值"+aExecuteResult+"的长度"+aExecuteResult.length()+"大于最大值900");
		ExecuteResult = aExecuteResult;
	}

	/**
	* 使用另外一个 LDTaskRunLogSchema 对象给 Schema 赋值
	* @param: aLDTaskRunLogSchema LDTaskRunLogSchema
	**/
	public void setSchema(LDTaskRunLogSchema aLDTaskRunLogSchema)
	{
		this.SerialNo = aLDTaskRunLogSchema.getSerialNo();
		this.TaskCode = aLDTaskRunLogSchema.getTaskCode();
		this.TaskPlanCode = aLDTaskRunLogSchema.getTaskPlanCode();
		this.ExecuteDate = fDate.getDate( aLDTaskRunLogSchema.getExecuteDate());
		this.ExecuteTime = aLDTaskRunLogSchema.getExecuteTime();
		this.FinishDate = fDate.getDate( aLDTaskRunLogSchema.getFinishDate());
		this.FinishTime = aLDTaskRunLogSchema.getFinishTime();
		this.ExecuteFrequence = aLDTaskRunLogSchema.getExecuteFrequence();
		this.ExecuteState = aLDTaskRunLogSchema.getExecuteState();
		this.ExecuteResult = aLDTaskRunLogSchema.getExecuteResult();
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
			this.SerialNo = rs.getDouble("SerialNo");
			if( rs.getString("TaskCode") == null )
				this.TaskCode = null;
			else
				this.TaskCode = rs.getString("TaskCode").trim();

			if( rs.getString("TaskPlanCode") == null )
				this.TaskPlanCode = null;
			else
				this.TaskPlanCode = rs.getString("TaskPlanCode").trim();

			this.ExecuteDate = rs.getDate("ExecuteDate");
			if( rs.getString("ExecuteTime") == null )
				this.ExecuteTime = null;
			else
				this.ExecuteTime = rs.getString("ExecuteTime").trim();

			this.FinishDate = rs.getDate("FinishDate");
			if( rs.getString("FinishTime") == null )
				this.FinishTime = null;
			else
				this.FinishTime = rs.getString("FinishTime").trim();

			this.ExecuteFrequence = rs.getDouble("ExecuteFrequence");
			if( rs.getString("ExecuteState") == null )
				this.ExecuteState = null;
			else
				this.ExecuteState = rs.getString("ExecuteState").trim();

			if( rs.getString("ExecuteResult") == null )
				this.ExecuteResult = null;
			else
				this.ExecuteResult = rs.getString("ExecuteResult").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDTaskRunLog表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDTaskRunLogSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDTaskRunLogSchema getSchema()
	{
		LDTaskRunLogSchema aLDTaskRunLogSchema = new LDTaskRunLogSchema();
		aLDTaskRunLogSchema.setSchema(this);
		return aLDTaskRunLogSchema;
	}

	public LDTaskRunLogDB getDB()
	{
		LDTaskRunLogDB aDBOper = new LDTaskRunLogDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDTaskRunLog描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append( ChgData.chgData(SerialNo));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TaskCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TaskPlanCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ExecuteDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ExecuteTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( FinishDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FinishTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(ExecuteFrequence));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ExecuteState)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ExecuteResult));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDTaskRunLog>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			SerialNo = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,1,SysConst.PACKAGESPILTER))).doubleValue();
			TaskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			TaskPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ExecuteDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,SysConst.PACKAGESPILTER));
			ExecuteTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			FinishDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			FinishTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			ExecuteFrequence = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,8,SysConst.PACKAGESPILTER))).doubleValue();
			ExecuteState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			ExecuteResult = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDTaskRunLogSchema";
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
		if (FCode.equalsIgnoreCase("SerialNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SerialNo));
		}
		if (FCode.equalsIgnoreCase("TaskCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TaskCode));
		}
		if (FCode.equalsIgnoreCase("TaskPlanCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TaskPlanCode));
		}
		if (FCode.equalsIgnoreCase("ExecuteDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getExecuteDate()));
		}
		if (FCode.equalsIgnoreCase("ExecuteTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ExecuteTime));
		}
		if (FCode.equalsIgnoreCase("FinishDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getFinishDate()));
		}
		if (FCode.equalsIgnoreCase("FinishTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FinishTime));
		}
		if (FCode.equalsIgnoreCase("ExecuteFrequence"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ExecuteFrequence));
		}
		if (FCode.equalsIgnoreCase("ExecuteState"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ExecuteState));
		}
		if (FCode.equalsIgnoreCase("ExecuteResult"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ExecuteResult));
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
				strFieldValue = String.valueOf(SerialNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(TaskCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(TaskPlanCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getExecuteDate()));
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ExecuteTime);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getFinishDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(FinishTime);
				break;
			case 7:
				strFieldValue = String.valueOf(ExecuteFrequence);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(ExecuteState);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(ExecuteResult);
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

		if (FCode.equalsIgnoreCase("SerialNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				SerialNo = d;
			}
		}
		if (FCode.equalsIgnoreCase("TaskCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TaskCode = FValue.trim();
			}
			else
				TaskCode = null;
		}
		if (FCode.equalsIgnoreCase("TaskPlanCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TaskPlanCode = FValue.trim();
			}
			else
				TaskPlanCode = null;
		}
		if (FCode.equalsIgnoreCase("ExecuteDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ExecuteDate = fDate.getDate( FValue );
			}
			else
				ExecuteDate = null;
		}
		if (FCode.equalsIgnoreCase("ExecuteTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ExecuteTime = FValue.trim();
			}
			else
				ExecuteTime = null;
		}
		if (FCode.equalsIgnoreCase("FinishDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				FinishDate = fDate.getDate( FValue );
			}
			else
				FinishDate = null;
		}
		if (FCode.equalsIgnoreCase("FinishTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FinishTime = FValue.trim();
			}
			else
				FinishTime = null;
		}
		if (FCode.equalsIgnoreCase("ExecuteFrequence"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				ExecuteFrequence = d;
			}
		}
		if (FCode.equalsIgnoreCase("ExecuteState"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ExecuteState = FValue.trim();
			}
			else
				ExecuteState = null;
		}
		if (FCode.equalsIgnoreCase("ExecuteResult"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ExecuteResult = FValue.trim();
			}
			else
				ExecuteResult = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDTaskRunLogSchema other = (LDTaskRunLogSchema)otherObject;
		return
			SerialNo == other.getSerialNo()
			&& TaskCode.equals(other.getTaskCode())
			&& TaskPlanCode.equals(other.getTaskPlanCode())
			&& fDate.getString(ExecuteDate).equals(other.getExecuteDate())
			&& ExecuteTime.equals(other.getExecuteTime())
			&& fDate.getString(FinishDate).equals(other.getFinishDate())
			&& FinishTime.equals(other.getFinishTime())
			&& ExecuteFrequence == other.getExecuteFrequence()
			&& ExecuteState.equals(other.getExecuteState())
			&& ExecuteResult.equals(other.getExecuteResult());
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
		if( strFieldName.equals("SerialNo") ) {
			return 0;
		}
		if( strFieldName.equals("TaskCode") ) {
			return 1;
		}
		if( strFieldName.equals("TaskPlanCode") ) {
			return 2;
		}
		if( strFieldName.equals("ExecuteDate") ) {
			return 3;
		}
		if( strFieldName.equals("ExecuteTime") ) {
			return 4;
		}
		if( strFieldName.equals("FinishDate") ) {
			return 5;
		}
		if( strFieldName.equals("FinishTime") ) {
			return 6;
		}
		if( strFieldName.equals("ExecuteFrequence") ) {
			return 7;
		}
		if( strFieldName.equals("ExecuteState") ) {
			return 8;
		}
		if( strFieldName.equals("ExecuteResult") ) {
			return 9;
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
				strFieldName = "SerialNo";
				break;
			case 1:
				strFieldName = "TaskCode";
				break;
			case 2:
				strFieldName = "TaskPlanCode";
				break;
			case 3:
				strFieldName = "ExecuteDate";
				break;
			case 4:
				strFieldName = "ExecuteTime";
				break;
			case 5:
				strFieldName = "FinishDate";
				break;
			case 6:
				strFieldName = "FinishTime";
				break;
			case 7:
				strFieldName = "ExecuteFrequence";
				break;
			case 8:
				strFieldName = "ExecuteState";
				break;
			case 9:
				strFieldName = "ExecuteResult";
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
		if( strFieldName.equals("SerialNo") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("TaskCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TaskPlanCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ExecuteDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ExecuteTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FinishDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("FinishTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ExecuteFrequence") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("ExecuteState") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ExecuteResult") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
