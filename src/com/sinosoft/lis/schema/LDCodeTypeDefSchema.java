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
import com.sinosoft.lis.db.LDCodeTypeDefDB;

/*
 * <p>ClassName: LDCodeTypeDefSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDCodeTypeDefSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDCodeTypeDefSchema.class);
	// @Field
	/** Codetypename */
	private String CodeTypeName;
	/** Codetypeno */
	private String CodeTypeNo;
	/** Codetypenameen */
	private String CodeTypeNameEn;
	/** Codelen */
	private double CodeLen;
	/** Waytypeno */
	private String WayTypeNo;
	/** Isallowed */
	private String IsAllowed;

	public static final int FIELDNUM = 6;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDCodeTypeDefSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "CodeTypeNo";

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
		LDCodeTypeDefSchema cloned = (LDCodeTypeDefSchema)super.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCodeTypeName()
	{
		return CodeTypeName;
	}
	public void setCodeTypeName(String aCodeTypeName)
	{
		if(aCodeTypeName!=null && aCodeTypeName.length()>64)
			throw new IllegalArgumentException("CodetypenameCodeTypeName值"+aCodeTypeName+"的长度"+aCodeTypeName.length()+"大于最大值64");
		CodeTypeName = aCodeTypeName;
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
	public String getCodeTypeNameEn()
	{
		return CodeTypeNameEn;
	}
	public void setCodeTypeNameEn(String aCodeTypeNameEn)
	{
		if(aCodeTypeNameEn!=null && aCodeTypeNameEn.length()>64)
			throw new IllegalArgumentException("CodetypenameenCodeTypeNameEn值"+aCodeTypeNameEn+"的长度"+aCodeTypeNameEn.length()+"大于最大值64");
		CodeTypeNameEn = aCodeTypeNameEn;
	}
	public double getCodeLen()
	{
		return CodeLen;
	}
	public void setCodeLen(double aCodeLen)
	{
		CodeLen = aCodeLen;
	}
	public void setCodeLen(String aCodeLen)
	{
		if (aCodeLen != null && !aCodeLen.equals(""))
		{
			Double tDouble = new Double(aCodeLen);
			double d = tDouble.doubleValue();
			CodeLen = d;
		}
	}

	public String getWayTypeNo()
	{
		return WayTypeNo;
	}
	public void setWayTypeNo(String aWayTypeNo)
	{
		if(aWayTypeNo!=null && aWayTypeNo.length()>4)
			throw new IllegalArgumentException("WaytypenoWayTypeNo值"+aWayTypeNo+"的长度"+aWayTypeNo.length()+"大于最大值4");
		WayTypeNo = aWayTypeNo;
	}
	public String getIsAllowed()
	{
		return IsAllowed;
	}
	public void setIsAllowed(String aIsAllowed)
	{
		if(aIsAllowed!=null && aIsAllowed.length()>4)
			throw new IllegalArgumentException("IsallowedIsAllowed值"+aIsAllowed+"的长度"+aIsAllowed.length()+"大于最大值4");
		IsAllowed = aIsAllowed;
	}

	/**
	* 使用另外一个 LDCodeTypeDefSchema 对象给 Schema 赋值
	* @param: aLDCodeTypeDefSchema LDCodeTypeDefSchema
	**/
	public void setSchema(LDCodeTypeDefSchema aLDCodeTypeDefSchema)
	{
		this.CodeTypeName = aLDCodeTypeDefSchema.getCodeTypeName();
		this.CodeTypeNo = aLDCodeTypeDefSchema.getCodeTypeNo();
		this.CodeTypeNameEn = aLDCodeTypeDefSchema.getCodeTypeNameEn();
		this.CodeLen = aLDCodeTypeDefSchema.getCodeLen();
		this.WayTypeNo = aLDCodeTypeDefSchema.getWayTypeNo();
		this.IsAllowed = aLDCodeTypeDefSchema.getIsAllowed();
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
			if( rs.getString("CodeTypeName") == null )
				this.CodeTypeName = null;
			else
				this.CodeTypeName = rs.getString("CodeTypeName").trim();

			if( rs.getString("CodeTypeNo") == null )
				this.CodeTypeNo = null;
			else
				this.CodeTypeNo = rs.getString("CodeTypeNo").trim();

			if( rs.getString("CodeTypeNameEn") == null )
				this.CodeTypeNameEn = null;
			else
				this.CodeTypeNameEn = rs.getString("CodeTypeNameEn").trim();

			this.CodeLen = rs.getDouble("CodeLen");
			if( rs.getString("WayTypeNo") == null )
				this.WayTypeNo = null;
			else
				this.WayTypeNo = rs.getString("WayTypeNo").trim();

			if( rs.getString("IsAllowed") == null )
				this.IsAllowed = null;
			else
				this.IsAllowed = rs.getString("IsAllowed").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDCodeTypeDef表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDCodeTypeDefSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDCodeTypeDefSchema getSchema()
	{
		LDCodeTypeDefSchema aLDCodeTypeDefSchema = new LDCodeTypeDefSchema();
		aLDCodeTypeDefSchema.setSchema(this);
		return aLDCodeTypeDefSchema;
	}

	public LDCodeTypeDefDB getDB()
	{
		LDCodeTypeDefDB aDBOper = new LDCodeTypeDefDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCodeTypeDef描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(CodeTypeName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CodeTypeNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CodeTypeNameEn)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(CodeLen));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WayTypeNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IsAllowed));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCodeTypeDef>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			CodeTypeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			CodeTypeNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			CodeTypeNameEn = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			CodeLen = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,4,SysConst.PACKAGESPILTER))).doubleValue();
			WayTypeNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			IsAllowed = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDCodeTypeDefSchema";
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
		if (FCode.equalsIgnoreCase("CodeTypeName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CodeTypeName));
		}
		if (FCode.equalsIgnoreCase("CodeTypeNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CodeTypeNo));
		}
		if (FCode.equalsIgnoreCase("CodeTypeNameEn"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CodeTypeNameEn));
		}
		if (FCode.equalsIgnoreCase("CodeLen"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CodeLen));
		}
		if (FCode.equalsIgnoreCase("WayTypeNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WayTypeNo));
		}
		if (FCode.equalsIgnoreCase("IsAllowed"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IsAllowed));
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
				strFieldValue = StrTool.GBKToUnicode(CodeTypeName);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(CodeTypeNo);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(CodeTypeNameEn);
				break;
			case 3:
				strFieldValue = String.valueOf(CodeLen);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(WayTypeNo);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(IsAllowed);
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

		if (FCode.equalsIgnoreCase("CodeTypeName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CodeTypeName = FValue.trim();
			}
			else
				CodeTypeName = null;
		}
		if (FCode.equalsIgnoreCase("CodeTypeNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CodeTypeNo = FValue.trim();
			}
			else
				CodeTypeNo = null;
		}
		if (FCode.equalsIgnoreCase("CodeTypeNameEn"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CodeTypeNameEn = FValue.trim();
			}
			else
				CodeTypeNameEn = null;
		}
		if (FCode.equalsIgnoreCase("CodeLen"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				CodeLen = d;
			}
		}
		if (FCode.equalsIgnoreCase("WayTypeNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WayTypeNo = FValue.trim();
			}
			else
				WayTypeNo = null;
		}
		if (FCode.equalsIgnoreCase("IsAllowed"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IsAllowed = FValue.trim();
			}
			else
				IsAllowed = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDCodeTypeDefSchema other = (LDCodeTypeDefSchema)otherObject;
		return
			CodeTypeName.equals(other.getCodeTypeName())
			&& CodeTypeNo.equals(other.getCodeTypeNo())
			&& CodeTypeNameEn.equals(other.getCodeTypeNameEn())
			&& CodeLen == other.getCodeLen()
			&& WayTypeNo.equals(other.getWayTypeNo())
			&& IsAllowed.equals(other.getIsAllowed());
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
		if( strFieldName.equals("CodeTypeName") ) {
			return 0;
		}
		if( strFieldName.equals("CodeTypeNo") ) {
			return 1;
		}
		if( strFieldName.equals("CodeTypeNameEn") ) {
			return 2;
		}
		if( strFieldName.equals("CodeLen") ) {
			return 3;
		}
		if( strFieldName.equals("WayTypeNo") ) {
			return 4;
		}
		if( strFieldName.equals("IsAllowed") ) {
			return 5;
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
				strFieldName = "CodeTypeName";
				break;
			case 1:
				strFieldName = "CodeTypeNo";
				break;
			case 2:
				strFieldName = "CodeTypeNameEn";
				break;
			case 3:
				strFieldName = "CodeLen";
				break;
			case 4:
				strFieldName = "WayTypeNo";
				break;
			case 5:
				strFieldName = "IsAllowed";
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
		if( strFieldName.equals("CodeTypeName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CodeTypeNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CodeTypeNameEn") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CodeLen") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("WayTypeNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IsAllowed") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 4:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 5:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
