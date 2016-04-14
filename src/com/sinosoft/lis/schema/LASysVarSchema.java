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
import com.sinosoft.lis.db.LASysVarDB;

/*
 * <p>ClassName: LASysVarSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LASysVarSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LASysVarSchema.class);
	// @Field
	/** Vartype */
	private String VarType;
	/** Varvalue */
	private String VarValue;

	public static final int FIELDNUM = 2;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LASysVarSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "VarType";

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
		LASysVarSchema cloned = (LASysVarSchema)super.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getVarType()
	{
		return VarType;
	}
	public void setVarType(String aVarType)
	{
		if(aVarType!=null && aVarType.length()>15)
			throw new IllegalArgumentException("VartypeVarType值"+aVarType+"的长度"+aVarType.length()+"大于最大值15");
		VarType = aVarType;
	}
	public String getVarValue()
	{
		return VarValue;
	}
	public void setVarValue(String aVarValue)
	{
		if(aVarValue!=null && aVarValue.length()>1000)
			throw new IllegalArgumentException("VarvalueVarValue值"+aVarValue+"的长度"+aVarValue.length()+"大于最大值1000");
		VarValue = aVarValue;
	}

	/**
	* 使用另外一个 LASysVarSchema 对象给 Schema 赋值
	* @param: aLASysVarSchema LASysVarSchema
	**/
	public void setSchema(LASysVarSchema aLASysVarSchema)
	{
		this.VarType = aLASysVarSchema.getVarType();
		this.VarValue = aLASysVarSchema.getVarValue();
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
			if( rs.getString("VarType") == null )
				this.VarType = null;
			else
				this.VarType = rs.getString("VarType").trim();

			if( rs.getString("VarValue") == null )
				this.VarValue = null;
			else
				this.VarValue = rs.getString("VarValue").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LASysVar表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LASysVarSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LASysVarSchema getSchema()
	{
		LASysVarSchema aLASysVarSchema = new LASysVarSchema();
		aLASysVarSchema.setSchema(this);
		return aLASysVarSchema;
	}

	public LASysVarDB getDB()
	{
		LASysVarDB aDBOper = new LASysVarDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLASysVar描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(VarType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(VarValue));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLASysVar>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			VarType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			VarValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LASysVarSchema";
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
		if (FCode.equalsIgnoreCase("VarType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(VarType));
		}
		if (FCode.equalsIgnoreCase("VarValue"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(VarValue));
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
				strFieldValue = StrTool.GBKToUnicode(VarType);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(VarValue);
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

		if (FCode.equalsIgnoreCase("VarType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				VarType = FValue.trim();
			}
			else
				VarType = null;
		}
		if (FCode.equalsIgnoreCase("VarValue"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				VarValue = FValue.trim();
			}
			else
				VarValue = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LASysVarSchema other = (LASysVarSchema)otherObject;
		return
			VarType.equals(other.getVarType())
			&& VarValue.equals(other.getVarValue());
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
		if( strFieldName.equals("VarType") ) {
			return 0;
		}
		if( strFieldName.equals("VarValue") ) {
			return 1;
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
				strFieldName = "VarType";
				break;
			case 1:
				strFieldName = "VarValue";
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
		if( strFieldName.equals("VarType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("VarValue") ) {
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
