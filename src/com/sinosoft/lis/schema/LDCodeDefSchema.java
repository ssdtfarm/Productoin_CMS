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
import com.sinosoft.lis.db.LDCodeDefDB;

/*
 * <p>ClassName: LDCodeDefSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDCodeDefSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDCodeDefSchema.class);
	// @Field
	/** Codetypeno */
	private String CodeTypeNo;
	/** Codevalue */
	private String CodeValue;
	/** Codename */
	private String CodeName;
	/** Langtypeno */
	private String LangTypeNo;

	public static final int FIELDNUM = 4;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDCodeDefSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "CodeTypeNo";
		pk[1] = "CodeValue";

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
		LDCodeDefSchema cloned = (LDCodeDefSchema)super.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCodeTypeNo()
	{
		return CodeTypeNo;
	}
	public void setCodeTypeNo(String aCodeTypeNo)
	{
		if(aCodeTypeNo!=null && aCodeTypeNo.length()>4)
			throw new IllegalArgumentException("CodetypenoCodeTypeNo值"+aCodeTypeNo+"的长度"+aCodeTypeNo.length()+"大于最大值4");
		CodeTypeNo = aCodeTypeNo;
	}
	public String getCodeValue()
	{
		return CodeValue;
	}
	public void setCodeValue(String aCodeValue)
	{
		if(aCodeValue!=null && aCodeValue.length()>16)
			throw new IllegalArgumentException("CodevalueCodeValue值"+aCodeValue+"的长度"+aCodeValue.length()+"大于最大值16");
		CodeValue = aCodeValue;
	}
	public String getCodeName()
	{
		return CodeName;
	}
	public void setCodeName(String aCodeName)
	{
		if(aCodeName!=null && aCodeName.length()>64)
			throw new IllegalArgumentException("CodenameCodeName值"+aCodeName+"的长度"+aCodeName.length()+"大于最大值64");
		CodeName = aCodeName;
	}
	public String getLangTypeNo()
	{
		return LangTypeNo;
	}
	public void setLangTypeNo(String aLangTypeNo)
	{
		if(aLangTypeNo!=null && aLangTypeNo.length()>2)
			throw new IllegalArgumentException("LangtypenoLangTypeNo值"+aLangTypeNo+"的长度"+aLangTypeNo.length()+"大于最大值2");
		LangTypeNo = aLangTypeNo;
	}

	/**
	* 使用另外一个 LDCodeDefSchema 对象给 Schema 赋值
	* @param: aLDCodeDefSchema LDCodeDefSchema
	**/
	public void setSchema(LDCodeDefSchema aLDCodeDefSchema)
	{
		this.CodeTypeNo = aLDCodeDefSchema.getCodeTypeNo();
		this.CodeValue = aLDCodeDefSchema.getCodeValue();
		this.CodeName = aLDCodeDefSchema.getCodeName();
		this.LangTypeNo = aLDCodeDefSchema.getLangTypeNo();
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
			if( rs.getString("CodeTypeNo") == null )
				this.CodeTypeNo = null;
			else
				this.CodeTypeNo = rs.getString("CodeTypeNo").trim();

			if( rs.getString("CodeValue") == null )
				this.CodeValue = null;
			else
				this.CodeValue = rs.getString("CodeValue").trim();

			if( rs.getString("CodeName") == null )
				this.CodeName = null;
			else
				this.CodeName = rs.getString("CodeName").trim();

			if( rs.getString("LangTypeNo") == null )
				this.LangTypeNo = null;
			else
				this.LangTypeNo = rs.getString("LangTypeNo").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDCodeDef表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDCodeDefSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDCodeDefSchema getSchema()
	{
		LDCodeDefSchema aLDCodeDefSchema = new LDCodeDefSchema();
		aLDCodeDefSchema.setSchema(this);
		return aLDCodeDefSchema;
	}

	public LDCodeDefDB getDB()
	{
		LDCodeDefDB aDBOper = new LDCodeDefDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCodeDef描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(CodeTypeNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CodeValue)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CodeName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LangTypeNo));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCodeDef>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			CodeTypeNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			CodeValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			CodeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			LangTypeNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDCodeDefSchema";
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
		if (FCode.equalsIgnoreCase("CodeTypeNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CodeTypeNo));
		}
		if (FCode.equalsIgnoreCase("CodeValue"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CodeValue));
		}
		if (FCode.equalsIgnoreCase("CodeName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CodeName));
		}
		if (FCode.equalsIgnoreCase("LangTypeNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LangTypeNo));
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
				strFieldValue = StrTool.GBKToUnicode(CodeTypeNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(CodeValue);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(CodeName);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(LangTypeNo);
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

		if (FCode.equalsIgnoreCase("CodeTypeNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CodeTypeNo = FValue.trim();
			}
			else
				CodeTypeNo = null;
		}
		if (FCode.equalsIgnoreCase("CodeValue"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CodeValue = FValue.trim();
			}
			else
				CodeValue = null;
		}
		if (FCode.equalsIgnoreCase("CodeName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CodeName = FValue.trim();
			}
			else
				CodeName = null;
		}
		if (FCode.equalsIgnoreCase("LangTypeNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LangTypeNo = FValue.trim();
			}
			else
				LangTypeNo = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDCodeDefSchema other = (LDCodeDefSchema)otherObject;
		return
			CodeTypeNo.equals(other.getCodeTypeNo())
			&& CodeValue.equals(other.getCodeValue())
			&& CodeName.equals(other.getCodeName())
			&& LangTypeNo.equals(other.getLangTypeNo());
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
		if( strFieldName.equals("CodeTypeNo") ) {
			return 0;
		}
		if( strFieldName.equals("CodeValue") ) {
			return 1;
		}
		if( strFieldName.equals("CodeName") ) {
			return 2;
		}
		if( strFieldName.equals("LangTypeNo") ) {
			return 3;
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
				strFieldName = "CodeTypeNo";
				break;
			case 1:
				strFieldName = "CodeValue";
				break;
			case 2:
				strFieldName = "CodeName";
				break;
			case 3:
				strFieldName = "LangTypeNo";
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
		if( strFieldName.equals("CodeTypeNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CodeValue") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CodeName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LangTypeNo") ) {
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
