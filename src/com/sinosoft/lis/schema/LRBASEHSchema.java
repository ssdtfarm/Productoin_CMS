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
import com.sinosoft.lis.db.LRBASEHDB;

/*
 * <p>ClassName: LRBASEHSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRBASEHSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LRBASEHSchema.class);
	// @Field
	/** Basecode */
	private String BASECODE;
	/** Name */
	private String NAME;
	/** Status */
	private String STATUS;
	/** Branchtype */
	private String BRANCHTYPE;
	/** Remark */
	private String REMARK;
	/** Operator */
	private String OPERATOR;
	/** Modifytime */
	private String MODIFYTIME;
	/** Modifydate */
	private Date MODIFYDATE;
	/** Startdate */
	private Date STARTDATE;
	/** Enddate */
	private Date ENDDATE;

	public static final int FIELDNUM = 10;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LRBASEHSchema()
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
		LRBASEHSchema cloned = (LRBASEHSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getBASECODE()
	{
		return BASECODE;
	}
	public void setBASECODE(String aBASECODE)
	{
		if(aBASECODE!=null && aBASECODE.length()>10)
			throw new IllegalArgumentException("BasecodeBASECODE值"+aBASECODE+"的长度"+aBASECODE.length()+"大于最大值10");
		BASECODE = aBASECODE;
	}
	public String getNAME()
	{
		return NAME;
	}
	public void setNAME(String aNAME)
	{
		if(aNAME!=null && aNAME.length()>100)
			throw new IllegalArgumentException("NameNAME值"+aNAME+"的长度"+aNAME.length()+"大于最大值100");
		NAME = aNAME;
	}
	public String getSTATUS()
	{
		return STATUS;
	}
	public void setSTATUS(String aSTATUS)
	{
		if(aSTATUS!=null && aSTATUS.length()>2)
			throw new IllegalArgumentException("StatusSTATUS值"+aSTATUS+"的长度"+aSTATUS.length()+"大于最大值2");
		STATUS = aSTATUS;
	}
	public String getBRANCHTYPE()
	{
		return BRANCHTYPE;
	}
	public void setBRANCHTYPE(String aBRANCHTYPE)
	{
		if(aBRANCHTYPE!=null && aBRANCHTYPE.length()>2)
			throw new IllegalArgumentException("BranchtypeBRANCHTYPE值"+aBRANCHTYPE+"的长度"+aBRANCHTYPE.length()+"大于最大值2");
		BRANCHTYPE = aBRANCHTYPE;
	}
	public String getREMARK()
	{
		return REMARK;
	}
	public void setREMARK(String aREMARK)
	{
		if(aREMARK!=null && aREMARK.length()>200)
			throw new IllegalArgumentException("RemarkREMARK值"+aREMARK+"的长度"+aREMARK.length()+"大于最大值200");
		REMARK = aREMARK;
	}
	public String getOPERATOR()
	{
		return OPERATOR;
	}
	public void setOPERATOR(String aOPERATOR)
	{
		if(aOPERATOR!=null && aOPERATOR.length()>60)
			throw new IllegalArgumentException("OperatorOPERATOR值"+aOPERATOR+"的长度"+aOPERATOR.length()+"大于最大值60");
		OPERATOR = aOPERATOR;
	}
	public String getMODIFYTIME()
	{
		return MODIFYTIME;
	}
	public void setMODIFYTIME(String aMODIFYTIME)
	{
		if(aMODIFYTIME!=null && aMODIFYTIME.length()>8)
			throw new IllegalArgumentException("ModifytimeMODIFYTIME值"+aMODIFYTIME+"的长度"+aMODIFYTIME.length()+"大于最大值8");
		MODIFYTIME = aMODIFYTIME;
	}
	public String getMODIFYDATE()
	{
		if( MODIFYDATE != null )
			return fDate.getString(MODIFYDATE);
		else
			return null;
	}
	public void setMODIFYDATE(Date aMODIFYDATE)
	{
		MODIFYDATE = aMODIFYDATE;
	}
	public void setMODIFYDATE(String aMODIFYDATE)
	{
		if (aMODIFYDATE != null && !aMODIFYDATE.equals("") )
		{
			MODIFYDATE = fDate.getDate( aMODIFYDATE );
		}
		else
			MODIFYDATE = null;
	}

	public String getSTARTDATE()
	{
		if( STARTDATE != null )
			return fDate.getString(STARTDATE);
		else
			return null;
	}
	public void setSTARTDATE(Date aSTARTDATE)
	{
		STARTDATE = aSTARTDATE;
	}
	public void setSTARTDATE(String aSTARTDATE)
	{
		if (aSTARTDATE != null && !aSTARTDATE.equals("") )
		{
			STARTDATE = fDate.getDate( aSTARTDATE );
		}
		else
			STARTDATE = null;
	}

	public String getENDDATE()
	{
		if( ENDDATE != null )
			return fDate.getString(ENDDATE);
		else
			return null;
	}
	public void setENDDATE(Date aENDDATE)
	{
		ENDDATE = aENDDATE;
	}
	public void setENDDATE(String aENDDATE)
	{
		if (aENDDATE != null && !aENDDATE.equals("") )
		{
			ENDDATE = fDate.getDate( aENDDATE );
		}
		else
			ENDDATE = null;
	}


	/**
	* 使用另外一个 LRBASEHSchema 对象给 Schema 赋值
	* @param: aLRBASEHSchema LRBASEHSchema
	**/
	public void setSchema(LRBASEHSchema aLRBASEHSchema)
	{
		this.BASECODE = aLRBASEHSchema.getBASECODE();
		this.NAME = aLRBASEHSchema.getNAME();
		this.STATUS = aLRBASEHSchema.getSTATUS();
		this.BRANCHTYPE = aLRBASEHSchema.getBRANCHTYPE();
		this.REMARK = aLRBASEHSchema.getREMARK();
		this.OPERATOR = aLRBASEHSchema.getOPERATOR();
		this.MODIFYTIME = aLRBASEHSchema.getMODIFYTIME();
		this.MODIFYDATE = fDate.getDate( aLRBASEHSchema.getMODIFYDATE());
		this.STARTDATE = fDate.getDate( aLRBASEHSchema.getSTARTDATE());
		this.ENDDATE = fDate.getDate( aLRBASEHSchema.getENDDATE());
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
			if( rs.getString("BASECODE") == null )
				this.BASECODE = null;
			else
				this.BASECODE = rs.getString("BASECODE").trim();

			if( rs.getString("NAME") == null )
				this.NAME = null;
			else
				this.NAME = rs.getString("NAME").trim();

			if( rs.getString("STATUS") == null )
				this.STATUS = null;
			else
				this.STATUS = rs.getString("STATUS").trim();

			if( rs.getString("BRANCHTYPE") == null )
				this.BRANCHTYPE = null;
			else
				this.BRANCHTYPE = rs.getString("BRANCHTYPE").trim();

			if( rs.getString("REMARK") == null )
				this.REMARK = null;
			else
				this.REMARK = rs.getString("REMARK").trim();

			if( rs.getString("OPERATOR") == null )
				this.OPERATOR = null;
			else
				this.OPERATOR = rs.getString("OPERATOR").trim();

			if( rs.getString("MODIFYTIME") == null )
				this.MODIFYTIME = null;
			else
				this.MODIFYTIME = rs.getString("MODIFYTIME").trim();

			this.MODIFYDATE = rs.getDate("MODIFYDATE");
			this.STARTDATE = rs.getDate("STARTDATE");
			this.ENDDATE = rs.getDate("ENDDATE");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LRBASEH表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRBASEHSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LRBASEHSchema getSchema()
	{
		LRBASEHSchema aLRBASEHSchema = new LRBASEHSchema();
		aLRBASEHSchema.setSchema(this);
		return aLRBASEHSchema;
	}

	public LRBASEHDB getDB()
	{
		LRBASEHDB aDBOper = new LRBASEHDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRBASEH描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(BASECODE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NAME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(STATUS)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BRANCHTYPE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(REMARK)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OPERATOR)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MODIFYTIME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MODIFYDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( STARTDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ENDDATE )));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRBASEH>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			BASECODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			NAME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			STATUS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BRANCHTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			REMARK = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			OPERATOR = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			MODIFYTIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			MODIFYDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			STARTDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			ENDDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRBASEHSchema";
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
		if (FCode.equalsIgnoreCase("BASECODE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BASECODE));
		}
		if (FCode.equalsIgnoreCase("NAME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NAME));
		}
		if (FCode.equalsIgnoreCase("STATUS"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(STATUS));
		}
		if (FCode.equalsIgnoreCase("BRANCHTYPE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BRANCHTYPE));
		}
		if (FCode.equalsIgnoreCase("REMARK"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(REMARK));
		}
		if (FCode.equalsIgnoreCase("OPERATOR"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OPERATOR));
		}
		if (FCode.equalsIgnoreCase("MODIFYTIME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MODIFYTIME));
		}
		if (FCode.equalsIgnoreCase("MODIFYDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMODIFYDATE()));
		}
		if (FCode.equalsIgnoreCase("STARTDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getSTARTDATE()));
		}
		if (FCode.equalsIgnoreCase("ENDDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getENDDATE()));
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
				strFieldValue = StrTool.GBKToUnicode(BASECODE);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(NAME);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(STATUS);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(BRANCHTYPE);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(REMARK);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(OPERATOR);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(MODIFYTIME);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMODIFYDATE()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getSTARTDATE()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getENDDATE()));
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

		if (FCode.equalsIgnoreCase("BASECODE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BASECODE = FValue.trim();
			}
			else
				BASECODE = null;
		}
		if (FCode.equalsIgnoreCase("NAME"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NAME = FValue.trim();
			}
			else
				NAME = null;
		}
		if (FCode.equalsIgnoreCase("STATUS"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				STATUS = FValue.trim();
			}
			else
				STATUS = null;
		}
		if (FCode.equalsIgnoreCase("BRANCHTYPE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BRANCHTYPE = FValue.trim();
			}
			else
				BRANCHTYPE = null;
		}
		if (FCode.equalsIgnoreCase("REMARK"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				REMARK = FValue.trim();
			}
			else
				REMARK = null;
		}
		if (FCode.equalsIgnoreCase("OPERATOR"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OPERATOR = FValue.trim();
			}
			else
				OPERATOR = null;
		}
		if (FCode.equalsIgnoreCase("MODIFYTIME"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MODIFYTIME = FValue.trim();
			}
			else
				MODIFYTIME = null;
		}
		if (FCode.equalsIgnoreCase("MODIFYDATE"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MODIFYDATE = fDate.getDate( FValue );
			}
			else
				MODIFYDATE = null;
		}
		if (FCode.equalsIgnoreCase("STARTDATE"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				STARTDATE = fDate.getDate( FValue );
			}
			else
				STARTDATE = null;
		}
		if (FCode.equalsIgnoreCase("ENDDATE"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ENDDATE = fDate.getDate( FValue );
			}
			else
				ENDDATE = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LRBASEHSchema other = (LRBASEHSchema)otherObject;
		return
			BASECODE.equals(other.getBASECODE())
			&& NAME.equals(other.getNAME())
			&& STATUS.equals(other.getSTATUS())
			&& BRANCHTYPE.equals(other.getBRANCHTYPE())
			&& REMARK.equals(other.getREMARK())
			&& OPERATOR.equals(other.getOPERATOR())
			&& MODIFYTIME.equals(other.getMODIFYTIME())
			&& fDate.getString(MODIFYDATE).equals(other.getMODIFYDATE())
			&& fDate.getString(STARTDATE).equals(other.getSTARTDATE())
			&& fDate.getString(ENDDATE).equals(other.getENDDATE());
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
		if( strFieldName.equals("BASECODE") ) {
			return 0;
		}
		if( strFieldName.equals("NAME") ) {
			return 1;
		}
		if( strFieldName.equals("STATUS") ) {
			return 2;
		}
		if( strFieldName.equals("BRANCHTYPE") ) {
			return 3;
		}
		if( strFieldName.equals("REMARK") ) {
			return 4;
		}
		if( strFieldName.equals("OPERATOR") ) {
			return 5;
		}
		if( strFieldName.equals("MODIFYTIME") ) {
			return 6;
		}
		if( strFieldName.equals("MODIFYDATE") ) {
			return 7;
		}
		if( strFieldName.equals("STARTDATE") ) {
			return 8;
		}
		if( strFieldName.equals("ENDDATE") ) {
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
				strFieldName = "BASECODE";
				break;
			case 1:
				strFieldName = "NAME";
				break;
			case 2:
				strFieldName = "STATUS";
				break;
			case 3:
				strFieldName = "BRANCHTYPE";
				break;
			case 4:
				strFieldName = "REMARK";
				break;
			case 5:
				strFieldName = "OPERATOR";
				break;
			case 6:
				strFieldName = "MODIFYTIME";
				break;
			case 7:
				strFieldName = "MODIFYDATE";
				break;
			case 8:
				strFieldName = "STARTDATE";
				break;
			case 9:
				strFieldName = "ENDDATE";
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
		if( strFieldName.equals("BASECODE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NAME") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("STATUS") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BRANCHTYPE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("REMARK") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OPERATOR") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MODIFYTIME") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MODIFYDATE") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("STARTDATE") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ENDDATE") ) {
			return Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 9:
				nFieldType = Schema.TYPE_DATE;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
