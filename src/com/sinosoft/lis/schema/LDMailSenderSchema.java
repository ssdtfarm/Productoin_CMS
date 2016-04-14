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
import com.sinosoft.lis.db.LDMailSenderDB;

/*
 * <p>ClassName: LDMailSenderSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDMailSenderSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDMailSenderSchema.class);
	// @Field
	/** Mailtype */
	private String MAILTYPE;
	/** Mailpara */
	private String MAILPARA;
	/** Mailvalue */
	private String MAILVALUE;

	public static final int FIELDNUM = 3;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDMailSenderSchema()
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
		LDMailSenderSchema cloned = (LDMailSenderSchema)super.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getMAILTYPE()
	{
		return MAILTYPE;
	}
	public void setMAILTYPE(String aMAILTYPE)
	{
		if(aMAILTYPE!=null && aMAILTYPE.length()>20)
			throw new IllegalArgumentException("MailtypeMAILTYPE值"+aMAILTYPE+"的长度"+aMAILTYPE.length()+"大于最大值20");
		MAILTYPE = aMAILTYPE;
	}
	public String getMAILPARA()
	{
		return MAILPARA;
	}
	public void setMAILPARA(String aMAILPARA)
	{
		if(aMAILPARA!=null && aMAILPARA.length()>20)
			throw new IllegalArgumentException("MailparaMAILPARA值"+aMAILPARA+"的长度"+aMAILPARA.length()+"大于最大值20");
		MAILPARA = aMAILPARA;
	}
	public String getMAILVALUE()
	{
		return MAILVALUE;
	}
	public void setMAILVALUE(String aMAILVALUE)
	{
		if(aMAILVALUE!=null && aMAILVALUE.length()>500)
			throw new IllegalArgumentException("MailvalueMAILVALUE值"+aMAILVALUE+"的长度"+aMAILVALUE.length()+"大于最大值500");
		MAILVALUE = aMAILVALUE;
	}

	/**
	* 使用另外一个 LDMailSenderSchema 对象给 Schema 赋值
	* @param: aLDMailSenderSchema LDMailSenderSchema
	**/
	public void setSchema(LDMailSenderSchema aLDMailSenderSchema)
	{
		this.MAILTYPE = aLDMailSenderSchema.getMAILTYPE();
		this.MAILPARA = aLDMailSenderSchema.getMAILPARA();
		this.MAILVALUE = aLDMailSenderSchema.getMAILVALUE();
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
			if( rs.getString("MAILTYPE") == null )
				this.MAILTYPE = null;
			else
				this.MAILTYPE = rs.getString("MAILTYPE").trim();

			if( rs.getString("MAILPARA") == null )
				this.MAILPARA = null;
			else
				this.MAILPARA = rs.getString("MAILPARA").trim();

			if( rs.getString("MAILVALUE") == null )
				this.MAILVALUE = null;
			else
				this.MAILVALUE = rs.getString("MAILVALUE").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDMailSender表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDMailSenderSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDMailSenderSchema getSchema()
	{
		LDMailSenderSchema aLDMailSenderSchema = new LDMailSenderSchema();
		aLDMailSenderSchema.setSchema(this);
		return aLDMailSenderSchema;
	}

	public LDMailSenderDB getDB()
	{
		LDMailSenderDB aDBOper = new LDMailSenderDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDMailSender描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(MAILTYPE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MAILPARA)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MAILVALUE));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDMailSender>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			MAILTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			MAILPARA = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			MAILVALUE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDMailSenderSchema";
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
		if (FCode.equalsIgnoreCase("MAILTYPE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAILTYPE));
		}
		if (FCode.equalsIgnoreCase("MAILPARA"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAILPARA));
		}
		if (FCode.equalsIgnoreCase("MAILVALUE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAILVALUE));
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
				strFieldValue = StrTool.GBKToUnicode(MAILTYPE);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(MAILPARA);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(MAILVALUE);
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

		if (FCode.equalsIgnoreCase("MAILTYPE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MAILTYPE = FValue.trim();
			}
			else
				MAILTYPE = null;
		}
		if (FCode.equalsIgnoreCase("MAILPARA"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MAILPARA = FValue.trim();
			}
			else
				MAILPARA = null;
		}
		if (FCode.equalsIgnoreCase("MAILVALUE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MAILVALUE = FValue.trim();
			}
			else
				MAILVALUE = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDMailSenderSchema other = (LDMailSenderSchema)otherObject;
		return
			MAILTYPE.equals(other.getMAILTYPE())
			&& MAILPARA.equals(other.getMAILPARA())
			&& MAILVALUE.equals(other.getMAILVALUE());
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
		if( strFieldName.equals("MAILTYPE") ) {
			return 0;
		}
		if( strFieldName.equals("MAILPARA") ) {
			return 1;
		}
		if( strFieldName.equals("MAILVALUE") ) {
			return 2;
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
				strFieldName = "MAILTYPE";
				break;
			case 1:
				strFieldName = "MAILPARA";
				break;
			case 2:
				strFieldName = "MAILVALUE";
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
		if( strFieldName.equals("MAILTYPE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MAILPARA") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MAILVALUE") ) {
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
