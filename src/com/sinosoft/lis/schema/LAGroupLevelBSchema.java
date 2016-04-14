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
import com.sinosoft.lis.db.LAGroupLevelBDB;

/*
 * <p>ClassName: LAGroupLevelBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAGroupLevelBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAGroupLevelBSchema.class);
	// @Field
	/** Level */
	private String Level;
	/** Hierarchyname */
	private String HierarchyName;
	/** Channelcode */
	private String ChannelCode;
	/** Channelcodename */
	private String ChannelCodeName;
	/** Branchtypemaping */
	private String BranchTypeMaping;
	/** Operator */
	private String Operator;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;
	/** Operator1 */
	private String Operator1;
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;

	public static final int FIELDNUM = 13;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAGroupLevelBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "Level";
		pk[1] = "Operator1";
		pk[2] = "MakeDate1";
		pk[3] = "MakeTime1";

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
		LAGroupLevelBSchema cloned = (LAGroupLevelBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getLevel()
	{
		return Level;
	}
	public void setLevel(String aLevel)
	{
		if(aLevel!=null && aLevel.length()>10)
			throw new IllegalArgumentException("LevelLevel值"+aLevel+"的长度"+aLevel.length()+"大于最大值10");
		Level = aLevel;
	}
	public String getHierarchyName()
	{
		return HierarchyName;
	}
	public void setHierarchyName(String aHierarchyName)
	{
		if(aHierarchyName!=null && aHierarchyName.length()>20)
			throw new IllegalArgumentException("HierarchynameHierarchyName值"+aHierarchyName+"的长度"+aHierarchyName.length()+"大于最大值20");
		HierarchyName = aHierarchyName;
	}
	public String getChannelCode()
	{
		return ChannelCode;
	}
	public void setChannelCode(String aChannelCode)
	{
		if(aChannelCode!=null && aChannelCode.length()>2)
			throw new IllegalArgumentException("ChannelcodeChannelCode值"+aChannelCode+"的长度"+aChannelCode.length()+"大于最大值2");
		ChannelCode = aChannelCode;
	}
	public String getChannelCodeName()
	{
		return ChannelCodeName;
	}
	public void setChannelCodeName(String aChannelCodeName)
	{
		if(aChannelCodeName!=null && aChannelCodeName.length()>20)
			throw new IllegalArgumentException("ChannelcodenameChannelCodeName值"+aChannelCodeName+"的长度"+aChannelCodeName.length()+"大于最大值20");
		ChannelCodeName = aChannelCodeName;
	}
	public String getBranchTypeMaping()
	{
		return BranchTypeMaping;
	}
	public void setBranchTypeMaping(String aBranchTypeMaping)
	{
		if(aBranchTypeMaping!=null && aBranchTypeMaping.length()>3)
			throw new IllegalArgumentException("BranchtypemapingBranchTypeMaping值"+aBranchTypeMaping+"的长度"+aBranchTypeMaping.length()+"大于最大值3");
		BranchTypeMaping = aBranchTypeMaping;
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
	public String getModifyDate()
	{
		if( ModifyDate != null )
			return fDate.getString(ModifyDate);
		else
			return null;
	}
	public void setModifyDate(Date aModifyDate)
	{
		ModifyDate = aModifyDate;
	}
	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals("") )
		{
			ModifyDate = fDate.getDate( aModifyDate );
		}
		else
			ModifyDate = null;
	}

	public String getModifyTime()
	{
		return ModifyTime;
	}
	public void setModifyTime(String aModifyTime)
	{
		if(aModifyTime!=null && aModifyTime.length()>8)
			throw new IllegalArgumentException("ModifytimeModifyTime值"+aModifyTime+"的长度"+aModifyTime.length()+"大于最大值8");
		ModifyTime = aModifyTime;
	}
	public String getOperator1()
	{
		return Operator1;
	}
	public void setOperator1(String aOperator1)
	{
		if(aOperator1!=null && aOperator1.length()>60)
			throw new IllegalArgumentException("Operator1Operator1值"+aOperator1+"的长度"+aOperator1.length()+"大于最大值60");
		Operator1 = aOperator1;
	}
	public String getMakeDate1()
	{
		if( MakeDate1 != null )
			return fDate.getString(MakeDate1);
		else
			return null;
	}
	public void setMakeDate1(Date aMakeDate1)
	{
		MakeDate1 = aMakeDate1;
	}
	public void setMakeDate1(String aMakeDate1)
	{
		if (aMakeDate1 != null && !aMakeDate1.equals("") )
		{
			MakeDate1 = fDate.getDate( aMakeDate1 );
		}
		else
			MakeDate1 = null;
	}

	public String getMakeTime1()
	{
		return MakeTime1;
	}
	public void setMakeTime1(String aMakeTime1)
	{
		if(aMakeTime1!=null && aMakeTime1.length()>8)
			throw new IllegalArgumentException("Maketime1MakeTime1值"+aMakeTime1+"的长度"+aMakeTime1.length()+"大于最大值8");
		MakeTime1 = aMakeTime1;
	}

	/**
	* 使用另外一个 LAGroupLevelBSchema 对象给 Schema 赋值
	* @param: aLAGroupLevelBSchema LAGroupLevelBSchema
	**/
	public void setSchema(LAGroupLevelBSchema aLAGroupLevelBSchema)
	{
		this.Level = aLAGroupLevelBSchema.getLevel();
		this.HierarchyName = aLAGroupLevelBSchema.getHierarchyName();
		this.ChannelCode = aLAGroupLevelBSchema.getChannelCode();
		this.ChannelCodeName = aLAGroupLevelBSchema.getChannelCodeName();
		this.BranchTypeMaping = aLAGroupLevelBSchema.getBranchTypeMaping();
		this.Operator = aLAGroupLevelBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAGroupLevelBSchema.getMakeDate());
		this.MakeTime = aLAGroupLevelBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAGroupLevelBSchema.getModifyDate());
		this.ModifyTime = aLAGroupLevelBSchema.getModifyTime();
		this.Operator1 = aLAGroupLevelBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLAGroupLevelBSchema.getMakeDate1());
		this.MakeTime1 = aLAGroupLevelBSchema.getMakeTime1();
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
			if( rs.getString("Level") == null )
				this.Level = null;
			else
				this.Level = rs.getString("Level").trim();

			if( rs.getString("HierarchyName") == null )
				this.HierarchyName = null;
			else
				this.HierarchyName = rs.getString("HierarchyName").trim();

			if( rs.getString("ChannelCode") == null )
				this.ChannelCode = null;
			else
				this.ChannelCode = rs.getString("ChannelCode").trim();

			if( rs.getString("ChannelCodeName") == null )
				this.ChannelCodeName = null;
			else
				this.ChannelCodeName = rs.getString("ChannelCodeName").trim();

			if( rs.getString("BranchTypeMaping") == null )
				this.BranchTypeMaping = null;
			else
				this.BranchTypeMaping = rs.getString("BranchTypeMaping").trim();

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

			this.ModifyDate = rs.getDate("ModifyDate");
			if( rs.getString("ModifyTime") == null )
				this.ModifyTime = null;
			else
				this.ModifyTime = rs.getString("ModifyTime").trim();

			if( rs.getString("Operator1") == null )
				this.Operator1 = null;
			else
				this.Operator1 = rs.getString("Operator1").trim();

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAGroupLevelB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAGroupLevelBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAGroupLevelBSchema getSchema()
	{
		LAGroupLevelBSchema aLAGroupLevelBSchema = new LAGroupLevelBSchema();
		aLAGroupLevelBSchema.setSchema(this);
		return aLAGroupLevelBSchema;
	}

	public LAGroupLevelBDB getDB()
	{
		LAGroupLevelBDB aDBOper = new LAGroupLevelBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAGroupLevelB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(Level)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HierarchyName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ChannelCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ChannelCodeName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchTypeMaping)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAGroupLevelB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			Level = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			HierarchyName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ChannelCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ChannelCodeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			BranchTypeMaping = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAGroupLevelBSchema";
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
		if (FCode.equalsIgnoreCase("Level"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Level));
		}
		if (FCode.equalsIgnoreCase("HierarchyName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HierarchyName));
		}
		if (FCode.equalsIgnoreCase("ChannelCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ChannelCode));
		}
		if (FCode.equalsIgnoreCase("ChannelCodeName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ChannelCodeName));
		}
		if (FCode.equalsIgnoreCase("BranchTypeMaping"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchTypeMaping));
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
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		}
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator1));
		}
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime1));
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
				strFieldValue = StrTool.GBKToUnicode(Level);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(HierarchyName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ChannelCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ChannelCodeName);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(BranchTypeMaping);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
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

		if (FCode.equalsIgnoreCase("Level"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Level = FValue.trim();
			}
			else
				Level = null;
		}
		if (FCode.equalsIgnoreCase("HierarchyName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HierarchyName = FValue.trim();
			}
			else
				HierarchyName = null;
		}
		if (FCode.equalsIgnoreCase("ChannelCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ChannelCode = FValue.trim();
			}
			else
				ChannelCode = null;
		}
		if (FCode.equalsIgnoreCase("ChannelCodeName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ChannelCodeName = FValue.trim();
			}
			else
				ChannelCodeName = null;
		}
		if (FCode.equalsIgnoreCase("BranchTypeMaping"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchTypeMaping = FValue.trim();
			}
			else
				BranchTypeMaping = null;
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
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ModifyDate = fDate.getDate( FValue );
			}
			else
				ModifyDate = null;
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyTime = FValue.trim();
			}
			else
				ModifyTime = null;
		}
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator1 = FValue.trim();
			}
			else
				Operator1 = null;
		}
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MakeDate1 = fDate.getDate( FValue );
			}
			else
				MakeDate1 = null;
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MakeTime1 = FValue.trim();
			}
			else
				MakeTime1 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAGroupLevelBSchema other = (LAGroupLevelBSchema)otherObject;
		return
			Level.equals(other.getLevel())
			&& HierarchyName.equals(other.getHierarchyName())
			&& ChannelCode.equals(other.getChannelCode())
			&& ChannelCodeName.equals(other.getChannelCodeName())
			&& BranchTypeMaping.equals(other.getBranchTypeMaping())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator1.equals(other.getOperator1())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1());
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
		if( strFieldName.equals("Level") ) {
			return 0;
		}
		if( strFieldName.equals("HierarchyName") ) {
			return 1;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return 2;
		}
		if( strFieldName.equals("ChannelCodeName") ) {
			return 3;
		}
		if( strFieldName.equals("BranchTypeMaping") ) {
			return 4;
		}
		if( strFieldName.equals("Operator") ) {
			return 5;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 6;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 7;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 8;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 9;
		}
		if( strFieldName.equals("Operator1") ) {
			return 10;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 11;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 12;
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
				strFieldName = "Level";
				break;
			case 1:
				strFieldName = "HierarchyName";
				break;
			case 2:
				strFieldName = "ChannelCode";
				break;
			case 3:
				strFieldName = "ChannelCodeName";
				break;
			case 4:
				strFieldName = "BranchTypeMaping";
				break;
			case 5:
				strFieldName = "Operator";
				break;
			case 6:
				strFieldName = "MakeDate";
				break;
			case 7:
				strFieldName = "MakeTime";
				break;
			case 8:
				strFieldName = "ModifyDate";
				break;
			case 9:
				strFieldName = "ModifyTime";
				break;
			case 10:
				strFieldName = "Operator1";
				break;
			case 11:
				strFieldName = "MakeDate1";
				break;
			case 12:
				strFieldName = "MakeTime1";
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
		if( strFieldName.equals("Level") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HierarchyName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ChannelCodeName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchTypeMaping") ) {
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
		if( strFieldName.equals("ModifyDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime1") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
