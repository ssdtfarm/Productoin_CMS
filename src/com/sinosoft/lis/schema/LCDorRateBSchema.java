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
import com.sinosoft.lis.db.LCDorRateBDB;

/*
 * <p>ClassName: LCDorRateBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCDorRateBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LCDorRateBSchema.class);
	// @Field
	/** Productcode */
	private String ProductCode;
	/** Dorrate */
	private String DorRate;
	/** Effectiveym */
	private String EffectiveYM;
	/** Effectiveendym */
	private String EffectiveEndYM;
	/** Deleteflag */
	private String DeleteFlag;
	/** Operationdate */
	private Date OperationDate;
	/** Operator */
	private String OPERATOR;
	/** Makedate */
	private Date MAKEDATE;
	/** Maketime */
	private String MAKETIME;
	/** Modifydate */
	private Date MODIFYDATE;
	/** Modifytime */
	private String MODIFYTIME;

	public static final int FIELDNUM = 11;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LCDorRateBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "ProductCode";

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
		LCDorRateBSchema cloned = (LCDorRateBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getProductCode()
	{
		return ProductCode;
	}
	public void setProductCode(String aProductCode)
	{
		if(aProductCode!=null && aProductCode.length()>10)
			throw new IllegalArgumentException("ProductcodeProductCode值"+aProductCode+"的长度"+aProductCode.length()+"大于最大值10");
		ProductCode = aProductCode;
	}
	public String getDorRate()
	{
		return DorRate;
	}
	public void setDorRate(String aDorRate)
	{
		if(aDorRate!=null && aDorRate.length()>20)
			throw new IllegalArgumentException("DorrateDorRate值"+aDorRate+"的长度"+aDorRate.length()+"大于最大值20");
		DorRate = aDorRate;
	}
	public String getEffectiveYM()
	{
		return EffectiveYM;
	}
	public void setEffectiveYM(String aEffectiveYM)
	{
		if(aEffectiveYM!=null && aEffectiveYM.length()>6)
			throw new IllegalArgumentException("EffectiveymEffectiveYM值"+aEffectiveYM+"的长度"+aEffectiveYM.length()+"大于最大值6");
		EffectiveYM = aEffectiveYM;
	}
	public String getEffectiveEndYM()
	{
		return EffectiveEndYM;
	}
	public void setEffectiveEndYM(String aEffectiveEndYM)
	{
		if(aEffectiveEndYM!=null && aEffectiveEndYM.length()>6)
			throw new IllegalArgumentException("EffectiveendymEffectiveEndYM值"+aEffectiveEndYM+"的长度"+aEffectiveEndYM.length()+"大于最大值6");
		EffectiveEndYM = aEffectiveEndYM;
	}
	public String getDeleteFlag()
	{
		return DeleteFlag;
	}
	public void setDeleteFlag(String aDeleteFlag)
	{
		if(aDeleteFlag!=null && aDeleteFlag.length()>1)
			throw new IllegalArgumentException("DeleteflagDeleteFlag值"+aDeleteFlag+"的长度"+aDeleteFlag.length()+"大于最大值1");
		DeleteFlag = aDeleteFlag;
	}
	public String getOperationDate()
	{
		if( OperationDate != null )
			return fDate.getString(OperationDate);
		else
			return null;
	}
	public void setOperationDate(Date aOperationDate)
	{
		OperationDate = aOperationDate;
	}
	public void setOperationDate(String aOperationDate)
	{
		if (aOperationDate != null && !aOperationDate.equals("") )
		{
			OperationDate = fDate.getDate( aOperationDate );
		}
		else
			OperationDate = null;
	}

	public String getOPERATOR()
	{
		return OPERATOR;
	}
	public void setOPERATOR(String aOPERATOR)
	{
		if(aOPERATOR!=null && aOPERATOR.length()>10)
			throw new IllegalArgumentException("OperatorOPERATOR值"+aOPERATOR+"的长度"+aOPERATOR.length()+"大于最大值10");
		OPERATOR = aOPERATOR;
	}
	public String getMAKEDATE()
	{
		if( MAKEDATE != null )
			return fDate.getString(MAKEDATE);
		else
			return null;
	}
	public void setMAKEDATE(Date aMAKEDATE)
	{
		MAKEDATE = aMAKEDATE;
	}
	public void setMAKEDATE(String aMAKEDATE)
	{
		if (aMAKEDATE != null && !aMAKEDATE.equals("") )
		{
			MAKEDATE = fDate.getDate( aMAKEDATE );
		}
		else
			MAKEDATE = null;
	}

	public String getMAKETIME()
	{
		return MAKETIME;
	}
	public void setMAKETIME(String aMAKETIME)
	{
		if(aMAKETIME!=null && aMAKETIME.length()>8)
			throw new IllegalArgumentException("MaketimeMAKETIME值"+aMAKETIME+"的长度"+aMAKETIME.length()+"大于最大值8");
		MAKETIME = aMAKETIME;
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

	/**
	* 使用另外一个 LCDorRateBSchema 对象给 Schema 赋值
	* @param: aLCDorRateBSchema LCDorRateBSchema
	**/
	public void setSchema(LCDorRateBSchema aLCDorRateBSchema)
	{
		this.ProductCode = aLCDorRateBSchema.getProductCode();
		this.DorRate = aLCDorRateBSchema.getDorRate();
		this.EffectiveYM = aLCDorRateBSchema.getEffectiveYM();
		this.EffectiveEndYM = aLCDorRateBSchema.getEffectiveEndYM();
		this.DeleteFlag = aLCDorRateBSchema.getDeleteFlag();
		this.OperationDate = fDate.getDate( aLCDorRateBSchema.getOperationDate());
		this.OPERATOR = aLCDorRateBSchema.getOPERATOR();
		this.MAKEDATE = fDate.getDate( aLCDorRateBSchema.getMAKEDATE());
		this.MAKETIME = aLCDorRateBSchema.getMAKETIME();
		this.MODIFYDATE = fDate.getDate( aLCDorRateBSchema.getMODIFYDATE());
		this.MODIFYTIME = aLCDorRateBSchema.getMODIFYTIME();
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
			if( rs.getString("ProductCode") == null )
				this.ProductCode = null;
			else
				this.ProductCode = rs.getString("ProductCode").trim();

			if( rs.getString("DorRate") == null )
				this.DorRate = null;
			else
				this.DorRate = rs.getString("DorRate").trim();

			if( rs.getString("EffectiveYM") == null )
				this.EffectiveYM = null;
			else
				this.EffectiveYM = rs.getString("EffectiveYM").trim();

			if( rs.getString("EffectiveEndYM") == null )
				this.EffectiveEndYM = null;
			else
				this.EffectiveEndYM = rs.getString("EffectiveEndYM").trim();

			if( rs.getString("DeleteFlag") == null )
				this.DeleteFlag = null;
			else
				this.DeleteFlag = rs.getString("DeleteFlag").trim();

			this.OperationDate = rs.getDate("OperationDate");
			if( rs.getString("OPERATOR") == null )
				this.OPERATOR = null;
			else
				this.OPERATOR = rs.getString("OPERATOR").trim();

			this.MAKEDATE = rs.getDate("MAKEDATE");
			if( rs.getString("MAKETIME") == null )
				this.MAKETIME = null;
			else
				this.MAKETIME = rs.getString("MAKETIME").trim();

			this.MODIFYDATE = rs.getDate("MODIFYDATE");
			if( rs.getString("MODIFYTIME") == null )
				this.MODIFYTIME = null;
			else
				this.MODIFYTIME = rs.getString("MODIFYTIME").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LCDorRateB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCDorRateBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LCDorRateBSchema getSchema()
	{
		LCDorRateBSchema aLCDorRateBSchema = new LCDorRateBSchema();
		aLCDorRateBSchema.setSchema(this);
		return aLCDorRateBSchema;
	}

	public LCDorRateBDB getDB()
	{
		LCDorRateBDB aDBOper = new LCDorRateBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCDorRateB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ProductCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DorRate)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EffectiveYM)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EffectiveEndYM)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DeleteFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( OperationDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OPERATOR)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MAKEDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MAKETIME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MODIFYDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MODIFYTIME));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCDorRateB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ProductCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			DorRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			EffectiveYM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			EffectiveEndYM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			DeleteFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			OperationDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			OPERATOR = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			MAKEDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			MAKETIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MODIFYDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MODIFYTIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCDorRateBSchema";
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
		if (FCode.equalsIgnoreCase("ProductCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ProductCode));
		}
		if (FCode.equalsIgnoreCase("DorRate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DorRate));
		}
		if (FCode.equalsIgnoreCase("EffectiveYM"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EffectiveYM));
		}
		if (FCode.equalsIgnoreCase("EffectiveEndYM"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EffectiveEndYM));
		}
		if (FCode.equalsIgnoreCase("DeleteFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DeleteFlag));
		}
		if (FCode.equalsIgnoreCase("OperationDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getOperationDate()));
		}
		if (FCode.equalsIgnoreCase("OPERATOR"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OPERATOR));
		}
		if (FCode.equalsIgnoreCase("MAKEDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMAKEDATE()));
		}
		if (FCode.equalsIgnoreCase("MAKETIME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAKETIME));
		}
		if (FCode.equalsIgnoreCase("MODIFYDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMODIFYDATE()));
		}
		if (FCode.equalsIgnoreCase("MODIFYTIME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MODIFYTIME));
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
				strFieldValue = StrTool.GBKToUnicode(ProductCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(DorRate);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(EffectiveYM);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(EffectiveEndYM);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(DeleteFlag);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getOperationDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(OPERATOR);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMAKEDATE()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(MAKETIME);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMODIFYDATE()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(MODIFYTIME);
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

		if (FCode.equalsIgnoreCase("ProductCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ProductCode = FValue.trim();
			}
			else
				ProductCode = null;
		}
		if (FCode.equalsIgnoreCase("DorRate"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DorRate = FValue.trim();
			}
			else
				DorRate = null;
		}
		if (FCode.equalsIgnoreCase("EffectiveYM"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EffectiveYM = FValue.trim();
			}
			else
				EffectiveYM = null;
		}
		if (FCode.equalsIgnoreCase("EffectiveEndYM"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EffectiveEndYM = FValue.trim();
			}
			else
				EffectiveEndYM = null;
		}
		if (FCode.equalsIgnoreCase("DeleteFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DeleteFlag = FValue.trim();
			}
			else
				DeleteFlag = null;
		}
		if (FCode.equalsIgnoreCase("OperationDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				OperationDate = fDate.getDate( FValue );
			}
			else
				OperationDate = null;
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
		if (FCode.equalsIgnoreCase("MAKEDATE"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MAKEDATE = fDate.getDate( FValue );
			}
			else
				MAKEDATE = null;
		}
		if (FCode.equalsIgnoreCase("MAKETIME"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MAKETIME = FValue.trim();
			}
			else
				MAKETIME = null;
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
		if (FCode.equalsIgnoreCase("MODIFYTIME"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MODIFYTIME = FValue.trim();
			}
			else
				MODIFYTIME = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LCDorRateBSchema other = (LCDorRateBSchema)otherObject;
		return
			ProductCode.equals(other.getProductCode())
			&& DorRate.equals(other.getDorRate())
			&& EffectiveYM.equals(other.getEffectiveYM())
			&& EffectiveEndYM.equals(other.getEffectiveEndYM())
			&& DeleteFlag.equals(other.getDeleteFlag())
			&& fDate.getString(OperationDate).equals(other.getOperationDate())
			&& OPERATOR.equals(other.getOPERATOR())
			&& fDate.getString(MAKEDATE).equals(other.getMAKEDATE())
			&& MAKETIME.equals(other.getMAKETIME())
			&& fDate.getString(MODIFYDATE).equals(other.getMODIFYDATE())
			&& MODIFYTIME.equals(other.getMODIFYTIME());
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
		if( strFieldName.equals("ProductCode") ) {
			return 0;
		}
		if( strFieldName.equals("DorRate") ) {
			return 1;
		}
		if( strFieldName.equals("EffectiveYM") ) {
			return 2;
		}
		if( strFieldName.equals("EffectiveEndYM") ) {
			return 3;
		}
		if( strFieldName.equals("DeleteFlag") ) {
			return 4;
		}
		if( strFieldName.equals("OperationDate") ) {
			return 5;
		}
		if( strFieldName.equals("OPERATOR") ) {
			return 6;
		}
		if( strFieldName.equals("MAKEDATE") ) {
			return 7;
		}
		if( strFieldName.equals("MAKETIME") ) {
			return 8;
		}
		if( strFieldName.equals("MODIFYDATE") ) {
			return 9;
		}
		if( strFieldName.equals("MODIFYTIME") ) {
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
				strFieldName = "ProductCode";
				break;
			case 1:
				strFieldName = "DorRate";
				break;
			case 2:
				strFieldName = "EffectiveYM";
				break;
			case 3:
				strFieldName = "EffectiveEndYM";
				break;
			case 4:
				strFieldName = "DeleteFlag";
				break;
			case 5:
				strFieldName = "OperationDate";
				break;
			case 6:
				strFieldName = "OPERATOR";
				break;
			case 7:
				strFieldName = "MAKEDATE";
				break;
			case 8:
				strFieldName = "MAKETIME";
				break;
			case 9:
				strFieldName = "MODIFYDATE";
				break;
			case 10:
				strFieldName = "MODIFYTIME";
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
		if( strFieldName.equals("ProductCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DorRate") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EffectiveYM") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EffectiveEndYM") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DeleteFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OperationDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("OPERATOR") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MAKEDATE") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MAKETIME") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MODIFYDATE") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MODIFYTIME") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
