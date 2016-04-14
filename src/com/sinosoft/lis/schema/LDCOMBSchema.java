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
import com.sinosoft.lis.db.LDCOMBDB;

/*
 * <p>ClassName: LDCOMBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDCOMBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDCOMBSchema.class);
	// @Field
	/** Comcode */
	private String COMCODE;
	/** Name */
	private String NAME;
	/** Shortname */
	private String SHORTNAME;
	/** Comgrade */
	private String COMGRADE;
	/** Upcomcode */
	private String UPCOMCODE;
	/** Citycode */
	private String CITYCODE;
	/** Citytype */
	private String CITYTYPE;
	/** Areacode */
	private String AREACODE;
	/** Founddate */
	private Date FOUNDDATE;
	/** Address */
	private String ADDRESS;
	/** Zipcode */
	private String ZIPCODE;
	/** Phone */
	private String PHONE;
	/** Fax */
	private String FAX;
	/** Email */
	private String EMAIL;
	/** Sign */
	private String SIGN;
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
	/** Operator1 */
	private String OPERATOR1;
	/** Makedate1 */
	private Date MAKEDATE1;
	/** Maketime1 */
	private String MAKETIME1;

	public static final int FIELDNUM = 23;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDCOMBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "COMCODE";
		pk[1] = "OPERATOR1";
		pk[2] = "MAKEDATE1";
		pk[3] = "MAKETIME1";

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
		LDCOMBSchema cloned = (LDCOMBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCOMCODE()
	{
		return COMCODE;
	}
	public void setCOMCODE(String aCOMCODE)
	{
		if(aCOMCODE!=null && aCOMCODE.length()>12)
			throw new IllegalArgumentException("ComcodeCOMCODE值"+aCOMCODE+"的长度"+aCOMCODE.length()+"大于最大值12");
		COMCODE = aCOMCODE;
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
	public String getSHORTNAME()
	{
		return SHORTNAME;
	}
	public void setSHORTNAME(String aSHORTNAME)
	{
		if(aSHORTNAME!=null && aSHORTNAME.length()>100)
			throw new IllegalArgumentException("ShortnameSHORTNAME值"+aSHORTNAME+"的长度"+aSHORTNAME.length()+"大于最大值100");
		SHORTNAME = aSHORTNAME;
	}
	public String getCOMGRADE()
	{
		return COMGRADE;
	}
	public void setCOMGRADE(String aCOMGRADE)
	{
		if(aCOMGRADE!=null && aCOMGRADE.length()>2)
			throw new IllegalArgumentException("ComgradeCOMGRADE值"+aCOMGRADE+"的长度"+aCOMGRADE.length()+"大于最大值2");
		COMGRADE = aCOMGRADE;
	}
	public String getUPCOMCODE()
	{
		return UPCOMCODE;
	}
	public void setUPCOMCODE(String aUPCOMCODE)
	{
		if(aUPCOMCODE!=null && aUPCOMCODE.length()>12)
			throw new IllegalArgumentException("UpcomcodeUPCOMCODE值"+aUPCOMCODE+"的长度"+aUPCOMCODE.length()+"大于最大值12");
		UPCOMCODE = aUPCOMCODE;
	}
	public String getCITYCODE()
	{
		return CITYCODE;
	}
	public void setCITYCODE(String aCITYCODE)
	{
		if(aCITYCODE!=null && aCITYCODE.length()>4)
			throw new IllegalArgumentException("CitycodeCITYCODE值"+aCITYCODE+"的长度"+aCITYCODE.length()+"大于最大值4");
		CITYCODE = aCITYCODE;
	}
	public String getCITYTYPE()
	{
		return CITYTYPE;
	}
	public void setCITYTYPE(String aCITYTYPE)
	{
		if(aCITYTYPE!=null && aCITYTYPE.length()>1)
			throw new IllegalArgumentException("CitytypeCITYTYPE值"+aCITYTYPE+"的长度"+aCITYTYPE.length()+"大于最大值1");
		CITYTYPE = aCITYTYPE;
	}
	public String getAREACODE()
	{
		return AREACODE;
	}
	public void setAREACODE(String aAREACODE)
	{
		if(aAREACODE!=null && aAREACODE.length()>2)
			throw new IllegalArgumentException("AreacodeAREACODE值"+aAREACODE+"的长度"+aAREACODE.length()+"大于最大值2");
		AREACODE = aAREACODE;
	}
	public String getFOUNDDATE()
	{
		if( FOUNDDATE != null )
			return fDate.getString(FOUNDDATE);
		else
			return null;
	}
	public void setFOUNDDATE(Date aFOUNDDATE)
	{
		FOUNDDATE = aFOUNDDATE;
	}
	public void setFOUNDDATE(String aFOUNDDATE)
	{
		if (aFOUNDDATE != null && !aFOUNDDATE.equals("") )
		{
			FOUNDDATE = fDate.getDate( aFOUNDDATE );
		}
		else
			FOUNDDATE = null;
	}

	public String getADDRESS()
	{
		return ADDRESS;
	}
	public void setADDRESS(String aADDRESS)
	{
		if(aADDRESS!=null && aADDRESS.length()>1000)
			throw new IllegalArgumentException("AddressADDRESS值"+aADDRESS+"的长度"+aADDRESS.length()+"大于最大值1000");
		ADDRESS = aADDRESS;
	}
	public String getZIPCODE()
	{
		return ZIPCODE;
	}
	public void setZIPCODE(String aZIPCODE)
	{
		if(aZIPCODE!=null && aZIPCODE.length()>6)
			throw new IllegalArgumentException("ZipcodeZIPCODE值"+aZIPCODE+"的长度"+aZIPCODE.length()+"大于最大值6");
		ZIPCODE = aZIPCODE;
	}
	public String getPHONE()
	{
		return PHONE;
	}
	public void setPHONE(String aPHONE)
	{
		if(aPHONE!=null && aPHONE.length()>18)
			throw new IllegalArgumentException("PhonePHONE值"+aPHONE+"的长度"+aPHONE.length()+"大于最大值18");
		PHONE = aPHONE;
	}
	public String getFAX()
	{
		return FAX;
	}
	public void setFAX(String aFAX)
	{
		if(aFAX!=null && aFAX.length()>18)
			throw new IllegalArgumentException("FaxFAX值"+aFAX+"的长度"+aFAX.length()+"大于最大值18");
		FAX = aFAX;
	}
	public String getEMAIL()
	{
		return EMAIL;
	}
	public void setEMAIL(String aEMAIL)
	{
		if(aEMAIL!=null && aEMAIL.length()>60)
			throw new IllegalArgumentException("EmailEMAIL值"+aEMAIL+"的长度"+aEMAIL.length()+"大于最大值60");
		EMAIL = aEMAIL;
	}
	public String getSIGN()
	{
		return SIGN;
	}
	public void setSIGN(String aSIGN)
	{
		if(aSIGN!=null && aSIGN.length()>60)
			throw new IllegalArgumentException("SignSIGN值"+aSIGN+"的长度"+aSIGN.length()+"大于最大值60");
		SIGN = aSIGN;
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
	public String getOPERATOR1()
	{
		return OPERATOR1;
	}
	public void setOPERATOR1(String aOPERATOR1)
	{
		if(aOPERATOR1!=null && aOPERATOR1.length()>60)
			throw new IllegalArgumentException("Operator1OPERATOR1值"+aOPERATOR1+"的长度"+aOPERATOR1.length()+"大于最大值60");
		OPERATOR1 = aOPERATOR1;
	}
	public String getMAKEDATE1()
	{
		if( MAKEDATE1 != null )
			return fDate.getString(MAKEDATE1);
		else
			return null;
	}
	public void setMAKEDATE1(Date aMAKEDATE1)
	{
		MAKEDATE1 = aMAKEDATE1;
	}
	public void setMAKEDATE1(String aMAKEDATE1)
	{
		if (aMAKEDATE1 != null && !aMAKEDATE1.equals("") )
		{
			MAKEDATE1 = fDate.getDate( aMAKEDATE1 );
		}
		else
			MAKEDATE1 = null;
	}

	public String getMAKETIME1()
	{
		return MAKETIME1;
	}
	public void setMAKETIME1(String aMAKETIME1)
	{
		if(aMAKETIME1!=null && aMAKETIME1.length()>8)
			throw new IllegalArgumentException("Maketime1MAKETIME1值"+aMAKETIME1+"的长度"+aMAKETIME1.length()+"大于最大值8");
		MAKETIME1 = aMAKETIME1;
	}

	/**
	* 使用另外一个 LDCOMBSchema 对象给 Schema 赋值
	* @param: aLDCOMBSchema LDCOMBSchema
	**/
	public void setSchema(LDCOMBSchema aLDCOMBSchema)
	{
		this.COMCODE = aLDCOMBSchema.getCOMCODE();
		this.NAME = aLDCOMBSchema.getNAME();
		this.SHORTNAME = aLDCOMBSchema.getSHORTNAME();
		this.COMGRADE = aLDCOMBSchema.getCOMGRADE();
		this.UPCOMCODE = aLDCOMBSchema.getUPCOMCODE();
		this.CITYCODE = aLDCOMBSchema.getCITYCODE();
		this.CITYTYPE = aLDCOMBSchema.getCITYTYPE();
		this.AREACODE = aLDCOMBSchema.getAREACODE();
		this.FOUNDDATE = fDate.getDate( aLDCOMBSchema.getFOUNDDATE());
		this.ADDRESS = aLDCOMBSchema.getADDRESS();
		this.ZIPCODE = aLDCOMBSchema.getZIPCODE();
		this.PHONE = aLDCOMBSchema.getPHONE();
		this.FAX = aLDCOMBSchema.getFAX();
		this.EMAIL = aLDCOMBSchema.getEMAIL();
		this.SIGN = aLDCOMBSchema.getSIGN();
		this.OPERATOR = aLDCOMBSchema.getOPERATOR();
		this.MAKEDATE = fDate.getDate( aLDCOMBSchema.getMAKEDATE());
		this.MAKETIME = aLDCOMBSchema.getMAKETIME();
		this.MODIFYDATE = fDate.getDate( aLDCOMBSchema.getMODIFYDATE());
		this.MODIFYTIME = aLDCOMBSchema.getMODIFYTIME();
		this.OPERATOR1 = aLDCOMBSchema.getOPERATOR1();
		this.MAKEDATE1 = fDate.getDate( aLDCOMBSchema.getMAKEDATE1());
		this.MAKETIME1 = aLDCOMBSchema.getMAKETIME1();
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
			if( rs.getString("COMCODE") == null )
				this.COMCODE = null;
			else
				this.COMCODE = rs.getString("COMCODE").trim();

			if( rs.getString("NAME") == null )
				this.NAME = null;
			else
				this.NAME = rs.getString("NAME").trim();

			if( rs.getString("SHORTNAME") == null )
				this.SHORTNAME = null;
			else
				this.SHORTNAME = rs.getString("SHORTNAME").trim();

			if( rs.getString("COMGRADE") == null )
				this.COMGRADE = null;
			else
				this.COMGRADE = rs.getString("COMGRADE").trim();

			if( rs.getString("UPCOMCODE") == null )
				this.UPCOMCODE = null;
			else
				this.UPCOMCODE = rs.getString("UPCOMCODE").trim();

			if( rs.getString("CITYCODE") == null )
				this.CITYCODE = null;
			else
				this.CITYCODE = rs.getString("CITYCODE").trim();

			if( rs.getString("CITYTYPE") == null )
				this.CITYTYPE = null;
			else
				this.CITYTYPE = rs.getString("CITYTYPE").trim();

			if( rs.getString("AREACODE") == null )
				this.AREACODE = null;
			else
				this.AREACODE = rs.getString("AREACODE").trim();

			this.FOUNDDATE = rs.getDate("FOUNDDATE");
			if( rs.getString("ADDRESS") == null )
				this.ADDRESS = null;
			else
				this.ADDRESS = rs.getString("ADDRESS").trim();

			if( rs.getString("ZIPCODE") == null )
				this.ZIPCODE = null;
			else
				this.ZIPCODE = rs.getString("ZIPCODE").trim();

			if( rs.getString("PHONE") == null )
				this.PHONE = null;
			else
				this.PHONE = rs.getString("PHONE").trim();

			if( rs.getString("FAX") == null )
				this.FAX = null;
			else
				this.FAX = rs.getString("FAX").trim();

			if( rs.getString("EMAIL") == null )
				this.EMAIL = null;
			else
				this.EMAIL = rs.getString("EMAIL").trim();

			if( rs.getString("SIGN") == null )
				this.SIGN = null;
			else
				this.SIGN = rs.getString("SIGN").trim();

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

			if( rs.getString("OPERATOR1") == null )
				this.OPERATOR1 = null;
			else
				this.OPERATOR1 = rs.getString("OPERATOR1").trim();

			this.MAKEDATE1 = rs.getDate("MAKEDATE1");
			if( rs.getString("MAKETIME1") == null )
				this.MAKETIME1 = null;
			else
				this.MAKETIME1 = rs.getString("MAKETIME1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDCOMB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDCOMBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDCOMBSchema getSchema()
	{
		LDCOMBSchema aLDCOMBSchema = new LDCOMBSchema();
		aLDCOMBSchema.setSchema(this);
		return aLDCOMBSchema;
	}

	public LDCOMBDB getDB()
	{
		LDCOMBDB aDBOper = new LDCOMBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCOMB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(COMCODE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NAME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SHORTNAME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(COMGRADE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UPCOMCODE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CITYCODE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CITYTYPE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AREACODE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( FOUNDDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ADDRESS)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ZIPCODE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PHONE)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FAX)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EMAIL)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SIGN)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OPERATOR)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MAKEDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MAKETIME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MODIFYDATE ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MODIFYTIME)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OPERATOR1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MAKEDATE1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MAKETIME1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCOMB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			COMCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			NAME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			SHORTNAME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			COMGRADE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			UPCOMCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			CITYCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			CITYTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			AREACODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			FOUNDDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			ADDRESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ZIPCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			PHONE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			FAX = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			EMAIL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			SIGN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			OPERATOR = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			MAKEDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17,SysConst.PACKAGESPILTER));
			MAKETIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			MODIFYDATE = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			MODIFYTIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			OPERATOR1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			MAKEDATE1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22,SysConst.PACKAGESPILTER));
			MAKETIME1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDCOMBSchema";
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
		if (FCode.equalsIgnoreCase("COMCODE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(COMCODE));
		}
		if (FCode.equalsIgnoreCase("NAME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NAME));
		}
		if (FCode.equalsIgnoreCase("SHORTNAME"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SHORTNAME));
		}
		if (FCode.equalsIgnoreCase("COMGRADE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(COMGRADE));
		}
		if (FCode.equalsIgnoreCase("UPCOMCODE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UPCOMCODE));
		}
		if (FCode.equalsIgnoreCase("CITYCODE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CITYCODE));
		}
		if (FCode.equalsIgnoreCase("CITYTYPE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CITYTYPE));
		}
		if (FCode.equalsIgnoreCase("AREACODE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AREACODE));
		}
		if (FCode.equalsIgnoreCase("FOUNDDATE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getFOUNDDATE()));
		}
		if (FCode.equalsIgnoreCase("ADDRESS"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ADDRESS));
		}
		if (FCode.equalsIgnoreCase("ZIPCODE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ZIPCODE));
		}
		if (FCode.equalsIgnoreCase("PHONE"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PHONE));
		}
		if (FCode.equalsIgnoreCase("FAX"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FAX));
		}
		if (FCode.equalsIgnoreCase("EMAIL"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EMAIL));
		}
		if (FCode.equalsIgnoreCase("SIGN"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SIGN));
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
		if (FCode.equalsIgnoreCase("OPERATOR1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OPERATOR1));
		}
		if (FCode.equalsIgnoreCase("MAKEDATE1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMAKEDATE1()));
		}
		if (FCode.equalsIgnoreCase("MAKETIME1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAKETIME1));
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
				strFieldValue = StrTool.GBKToUnicode(COMCODE);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(NAME);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(SHORTNAME);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(COMGRADE);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(UPCOMCODE);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(CITYCODE);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(CITYTYPE);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(AREACODE);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getFOUNDDATE()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(ADDRESS);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(ZIPCODE);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(PHONE);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(FAX);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(EMAIL);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(SIGN);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(OPERATOR);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMAKEDATE()));
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(MAKETIME);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMODIFYDATE()));
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(MODIFYTIME);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(OPERATOR1);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMAKEDATE1()));
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(MAKETIME1);
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

		if (FCode.equalsIgnoreCase("COMCODE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				COMCODE = FValue.trim();
			}
			else
				COMCODE = null;
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
		if (FCode.equalsIgnoreCase("SHORTNAME"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SHORTNAME = FValue.trim();
			}
			else
				SHORTNAME = null;
		}
		if (FCode.equalsIgnoreCase("COMGRADE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				COMGRADE = FValue.trim();
			}
			else
				COMGRADE = null;
		}
		if (FCode.equalsIgnoreCase("UPCOMCODE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UPCOMCODE = FValue.trim();
			}
			else
				UPCOMCODE = null;
		}
		if (FCode.equalsIgnoreCase("CITYCODE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CITYCODE = FValue.trim();
			}
			else
				CITYCODE = null;
		}
		if (FCode.equalsIgnoreCase("CITYTYPE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CITYTYPE = FValue.trim();
			}
			else
				CITYTYPE = null;
		}
		if (FCode.equalsIgnoreCase("AREACODE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AREACODE = FValue.trim();
			}
			else
				AREACODE = null;
		}
		if (FCode.equalsIgnoreCase("FOUNDDATE"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				FOUNDDATE = fDate.getDate( FValue );
			}
			else
				FOUNDDATE = null;
		}
		if (FCode.equalsIgnoreCase("ADDRESS"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ADDRESS = FValue.trim();
			}
			else
				ADDRESS = null;
		}
		if (FCode.equalsIgnoreCase("ZIPCODE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ZIPCODE = FValue.trim();
			}
			else
				ZIPCODE = null;
		}
		if (FCode.equalsIgnoreCase("PHONE"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PHONE = FValue.trim();
			}
			else
				PHONE = null;
		}
		if (FCode.equalsIgnoreCase("FAX"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FAX = FValue.trim();
			}
			else
				FAX = null;
		}
		if (FCode.equalsIgnoreCase("EMAIL"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EMAIL = FValue.trim();
			}
			else
				EMAIL = null;
		}
		if (FCode.equalsIgnoreCase("SIGN"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SIGN = FValue.trim();
			}
			else
				SIGN = null;
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
		if (FCode.equalsIgnoreCase("OPERATOR1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OPERATOR1 = FValue.trim();
			}
			else
				OPERATOR1 = null;
		}
		if (FCode.equalsIgnoreCase("MAKEDATE1"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MAKEDATE1 = fDate.getDate( FValue );
			}
			else
				MAKEDATE1 = null;
		}
		if (FCode.equalsIgnoreCase("MAKETIME1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MAKETIME1 = FValue.trim();
			}
			else
				MAKETIME1 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDCOMBSchema other = (LDCOMBSchema)otherObject;
		return
			COMCODE.equals(other.getCOMCODE())
			&& NAME.equals(other.getNAME())
			&& SHORTNAME.equals(other.getSHORTNAME())
			&& COMGRADE.equals(other.getCOMGRADE())
			&& UPCOMCODE.equals(other.getUPCOMCODE())
			&& CITYCODE.equals(other.getCITYCODE())
			&& CITYTYPE.equals(other.getCITYTYPE())
			&& AREACODE.equals(other.getAREACODE())
			&& fDate.getString(FOUNDDATE).equals(other.getFOUNDDATE())
			&& ADDRESS.equals(other.getADDRESS())
			&& ZIPCODE.equals(other.getZIPCODE())
			&& PHONE.equals(other.getPHONE())
			&& FAX.equals(other.getFAX())
			&& EMAIL.equals(other.getEMAIL())
			&& SIGN.equals(other.getSIGN())
			&& OPERATOR.equals(other.getOPERATOR())
			&& fDate.getString(MAKEDATE).equals(other.getMAKEDATE())
			&& MAKETIME.equals(other.getMAKETIME())
			&& fDate.getString(MODIFYDATE).equals(other.getMODIFYDATE())
			&& MODIFYTIME.equals(other.getMODIFYTIME())
			&& OPERATOR1.equals(other.getOPERATOR1())
			&& fDate.getString(MAKEDATE1).equals(other.getMAKEDATE1())
			&& MAKETIME1.equals(other.getMAKETIME1());
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
		if( strFieldName.equals("COMCODE") ) {
			return 0;
		}
		if( strFieldName.equals("NAME") ) {
			return 1;
		}
		if( strFieldName.equals("SHORTNAME") ) {
			return 2;
		}
		if( strFieldName.equals("COMGRADE") ) {
			return 3;
		}
		if( strFieldName.equals("UPCOMCODE") ) {
			return 4;
		}
		if( strFieldName.equals("CITYCODE") ) {
			return 5;
		}
		if( strFieldName.equals("CITYTYPE") ) {
			return 6;
		}
		if( strFieldName.equals("AREACODE") ) {
			return 7;
		}
		if( strFieldName.equals("FOUNDDATE") ) {
			return 8;
		}
		if( strFieldName.equals("ADDRESS") ) {
			return 9;
		}
		if( strFieldName.equals("ZIPCODE") ) {
			return 10;
		}
		if( strFieldName.equals("PHONE") ) {
			return 11;
		}
		if( strFieldName.equals("FAX") ) {
			return 12;
		}
		if( strFieldName.equals("EMAIL") ) {
			return 13;
		}
		if( strFieldName.equals("SIGN") ) {
			return 14;
		}
		if( strFieldName.equals("OPERATOR") ) {
			return 15;
		}
		if( strFieldName.equals("MAKEDATE") ) {
			return 16;
		}
		if( strFieldName.equals("MAKETIME") ) {
			return 17;
		}
		if( strFieldName.equals("MODIFYDATE") ) {
			return 18;
		}
		if( strFieldName.equals("MODIFYTIME") ) {
			return 19;
		}
		if( strFieldName.equals("OPERATOR1") ) {
			return 20;
		}
		if( strFieldName.equals("MAKEDATE1") ) {
			return 21;
		}
		if( strFieldName.equals("MAKETIME1") ) {
			return 22;
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
				strFieldName = "COMCODE";
				break;
			case 1:
				strFieldName = "NAME";
				break;
			case 2:
				strFieldName = "SHORTNAME";
				break;
			case 3:
				strFieldName = "COMGRADE";
				break;
			case 4:
				strFieldName = "UPCOMCODE";
				break;
			case 5:
				strFieldName = "CITYCODE";
				break;
			case 6:
				strFieldName = "CITYTYPE";
				break;
			case 7:
				strFieldName = "AREACODE";
				break;
			case 8:
				strFieldName = "FOUNDDATE";
				break;
			case 9:
				strFieldName = "ADDRESS";
				break;
			case 10:
				strFieldName = "ZIPCODE";
				break;
			case 11:
				strFieldName = "PHONE";
				break;
			case 12:
				strFieldName = "FAX";
				break;
			case 13:
				strFieldName = "EMAIL";
				break;
			case 14:
				strFieldName = "SIGN";
				break;
			case 15:
				strFieldName = "OPERATOR";
				break;
			case 16:
				strFieldName = "MAKEDATE";
				break;
			case 17:
				strFieldName = "MAKETIME";
				break;
			case 18:
				strFieldName = "MODIFYDATE";
				break;
			case 19:
				strFieldName = "MODIFYTIME";
				break;
			case 20:
				strFieldName = "OPERATOR1";
				break;
			case 21:
				strFieldName = "MAKEDATE1";
				break;
			case 22:
				strFieldName = "MAKETIME1";
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
		if( strFieldName.equals("COMCODE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NAME") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SHORTNAME") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("COMGRADE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UPCOMCODE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CITYCODE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CITYTYPE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AREACODE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FOUNDDATE") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ADDRESS") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ZIPCODE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PHONE") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FAX") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EMAIL") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SIGN") ) {
			return Schema.TYPE_STRING;
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
		if( strFieldName.equals("OPERATOR1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MAKEDATE1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MAKETIME1") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 8:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 16:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 20:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 21:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 22:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
