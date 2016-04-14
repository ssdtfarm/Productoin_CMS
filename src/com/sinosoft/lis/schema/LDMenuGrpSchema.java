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
import com.sinosoft.lis.db.LDMenuGrpDB;

/*
 * <p>ClassName: LDMenuGrpSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDMenuGrpSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDMenuGrpSchema.class);
	// @Field
	/** Menugrpcode */
	private String MenuGrpCode;
	/** Menugrpname */
	private String MenuGrpName;
	/** Menugrpdescription */
	private String MenuGrpDescription;
	/** Menusign */
	private String MenuSign;
	/** Operator */
	private String Operator;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Department */
	private String DepartMent;
	/** Team */
	private String Team;

	public static final int FIELDNUM = 9;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDMenuGrpSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "MenuGrpCode";

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
		LDMenuGrpSchema cloned = (LDMenuGrpSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getMenuGrpCode()
	{
		return MenuGrpCode;
	}
	public void setMenuGrpCode(String aMenuGrpCode)
	{
		if(aMenuGrpCode!=null && aMenuGrpCode.length()>8)
			throw new IllegalArgumentException("MenugrpcodeMenuGrpCode值"+aMenuGrpCode+"的长度"+aMenuGrpCode.length()+"大于最大值8");
		MenuGrpCode = aMenuGrpCode;
	}
	public String getMenuGrpName()
	{
		return MenuGrpName;
	}
	public void setMenuGrpName(String aMenuGrpName)
	{
		if(aMenuGrpName!=null && aMenuGrpName.length()>20)
			throw new IllegalArgumentException("MenugrpnameMenuGrpName值"+aMenuGrpName+"的长度"+aMenuGrpName.length()+"大于最大值20");
		MenuGrpName = aMenuGrpName;
	}
	public String getMenuGrpDescription()
	{
		return MenuGrpDescription;
	}
	public void setMenuGrpDescription(String aMenuGrpDescription)
	{
		if(aMenuGrpDescription!=null && aMenuGrpDescription.length()>100)
			throw new IllegalArgumentException("MenugrpdescriptionMenuGrpDescription值"+aMenuGrpDescription+"的长度"+aMenuGrpDescription.length()+"大于最大值100");
		MenuGrpDescription = aMenuGrpDescription;
	}
	public String getMenuSign()
	{
		return MenuSign;
	}
	public void setMenuSign(String aMenuSign)
	{
		if(aMenuSign!=null && aMenuSign.length()>5)
			throw new IllegalArgumentException("MenusignMenuSign值"+aMenuSign+"的长度"+aMenuSign.length()+"大于最大值5");
		MenuSign = aMenuSign;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>60)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值60");
		Operator = aOperator;
	}
	public String getMakeDate()
	{
		if( MakeDate != null )
			return fDate.getString(MakeDate);
		else
			return null;
	}
	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}
	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals("") )
		{
			MakeDate = fDate.getDate( aMakeDate );
		}
		else
			MakeDate = null;
	}

	public String getMakeTime()
	{
		return MakeTime;
	}
	public void setMakeTime(String aMakeTime)
	{
		if(aMakeTime!=null && aMakeTime.length()>8)
			throw new IllegalArgumentException("MaketimeMakeTime值"+aMakeTime+"的长度"+aMakeTime.length()+"大于最大值8");
		MakeTime = aMakeTime;
	}
	public String getDepartMent()
	{
		return DepartMent;
	}
	public void setDepartMent(String aDepartMent)
	{
		if(aDepartMent!=null && aDepartMent.length()>20)
			throw new IllegalArgumentException("DepartmentDepartMent值"+aDepartMent+"的长度"+aDepartMent.length()+"大于最大值20");
		DepartMent = aDepartMent;
	}
	public String getTeam()
	{
		return Team;
	}
	public void setTeam(String aTeam)
	{
		if(aTeam!=null && aTeam.length()>20)
			throw new IllegalArgumentException("TeamTeam值"+aTeam+"的长度"+aTeam.length()+"大于最大值20");
		Team = aTeam;
	}

	/**
	* 使用另外一个 LDMenuGrpSchema 对象给 Schema 赋值
	* @param: aLDMenuGrpSchema LDMenuGrpSchema
	**/
	public void setSchema(LDMenuGrpSchema aLDMenuGrpSchema)
	{
		this.MenuGrpCode = aLDMenuGrpSchema.getMenuGrpCode();
		this.MenuGrpName = aLDMenuGrpSchema.getMenuGrpName();
		this.MenuGrpDescription = aLDMenuGrpSchema.getMenuGrpDescription();
		this.MenuSign = aLDMenuGrpSchema.getMenuSign();
		this.Operator = aLDMenuGrpSchema.getOperator();
		this.MakeDate = fDate.getDate( aLDMenuGrpSchema.getMakeDate());
		this.MakeTime = aLDMenuGrpSchema.getMakeTime();
		this.DepartMent = aLDMenuGrpSchema.getDepartMent();
		this.Team = aLDMenuGrpSchema.getTeam();
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
			if( rs.getString("MenuGrpCode") == null )
				this.MenuGrpCode = null;
			else
				this.MenuGrpCode = rs.getString("MenuGrpCode").trim();

			if( rs.getString("MenuGrpName") == null )
				this.MenuGrpName = null;
			else
				this.MenuGrpName = rs.getString("MenuGrpName").trim();

			if( rs.getString("MenuGrpDescription") == null )
				this.MenuGrpDescription = null;
			else
				this.MenuGrpDescription = rs.getString("MenuGrpDescription").trim();

			if( rs.getString("MenuSign") == null )
				this.MenuSign = null;
			else
				this.MenuSign = rs.getString("MenuSign").trim();

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

			if( rs.getString("DepartMent") == null )
				this.DepartMent = null;
			else
				this.DepartMent = rs.getString("DepartMent").trim();

			if( rs.getString("Team") == null )
				this.Team = null;
			else
				this.Team = rs.getString("Team").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDMenuGrp表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDMenuGrpSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDMenuGrpSchema getSchema()
	{
		LDMenuGrpSchema aLDMenuGrpSchema = new LDMenuGrpSchema();
		aLDMenuGrpSchema.setSchema(this);
		return aLDMenuGrpSchema;
	}

	public LDMenuGrpDB getDB()
	{
		LDMenuGrpDB aDBOper = new LDMenuGrpDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDMenuGrp描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(MenuGrpCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MenuGrpName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MenuGrpDescription)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MenuSign)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DepartMent)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Team));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDMenuGrp>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			MenuGrpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			MenuGrpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			MenuGrpDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			MenuSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			DepartMent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Team = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDMenuGrpSchema";
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
		if (FCode.equalsIgnoreCase("MenuGrpCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MenuGrpCode));
		}
		if (FCode.equalsIgnoreCase("MenuGrpName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MenuGrpName));
		}
		if (FCode.equalsIgnoreCase("MenuGrpDescription"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MenuGrpDescription));
		}
		if (FCode.equalsIgnoreCase("MenuSign"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MenuSign));
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		}
		if (FCode.equalsIgnoreCase("DepartMent"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DepartMent));
		}
		if (FCode.equalsIgnoreCase("Team"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Team));
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
				strFieldValue = StrTool.GBKToUnicode(MenuGrpCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(MenuGrpName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(MenuGrpDescription);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(MenuSign);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(DepartMent);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Team);
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

		if (FCode.equalsIgnoreCase("MenuGrpCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MenuGrpCode = FValue.trim();
			}
			else
				MenuGrpCode = null;
		}
		if (FCode.equalsIgnoreCase("MenuGrpName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MenuGrpName = FValue.trim();
			}
			else
				MenuGrpName = null;
		}
		if (FCode.equalsIgnoreCase("MenuGrpDescription"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MenuGrpDescription = FValue.trim();
			}
			else
				MenuGrpDescription = null;
		}
		if (FCode.equalsIgnoreCase("MenuSign"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MenuSign = FValue.trim();
			}
			else
				MenuSign = null;
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator = FValue.trim();
			}
			else
				Operator = null;
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MakeDate = fDate.getDate( FValue );
			}
			else
				MakeDate = null;
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MakeTime = FValue.trim();
			}
			else
				MakeTime = null;
		}
		if (FCode.equalsIgnoreCase("DepartMent"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DepartMent = FValue.trim();
			}
			else
				DepartMent = null;
		}
		if (FCode.equalsIgnoreCase("Team"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Team = FValue.trim();
			}
			else
				Team = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDMenuGrpSchema other = (LDMenuGrpSchema)otherObject;
		return
			MenuGrpCode.equals(other.getMenuGrpCode())
			&& MenuGrpName.equals(other.getMenuGrpName())
			&& MenuGrpDescription.equals(other.getMenuGrpDescription())
			&& MenuSign.equals(other.getMenuSign())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& DepartMent.equals(other.getDepartMent())
			&& Team.equals(other.getTeam());
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
		if( strFieldName.equals("MenuGrpCode") ) {
			return 0;
		}
		if( strFieldName.equals("MenuGrpName") ) {
			return 1;
		}
		if( strFieldName.equals("MenuGrpDescription") ) {
			return 2;
		}
		if( strFieldName.equals("MenuSign") ) {
			return 3;
		}
		if( strFieldName.equals("Operator") ) {
			return 4;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 5;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 6;
		}
		if( strFieldName.equals("DepartMent") ) {
			return 7;
		}
		if( strFieldName.equals("Team") ) {
			return 8;
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
				strFieldName = "MenuGrpCode";
				break;
			case 1:
				strFieldName = "MenuGrpName";
				break;
			case 2:
				strFieldName = "MenuGrpDescription";
				break;
			case 3:
				strFieldName = "MenuSign";
				break;
			case 4:
				strFieldName = "Operator";
				break;
			case 5:
				strFieldName = "MakeDate";
				break;
			case 6:
				strFieldName = "MakeTime";
				break;
			case 7:
				strFieldName = "DepartMent";
				break;
			case 8:
				strFieldName = "Team";
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
		if( strFieldName.equals("MenuGrpCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MenuGrpName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MenuGrpDescription") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MenuSign") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DepartMent") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Team") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
