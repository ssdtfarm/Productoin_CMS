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
import com.sinosoft.lis.db.LRIndexDB;

/*
 * <p>ClassName: LRIndexSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRIndexSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LRIndexSchema.class);
	// @Field
	/** Wagecode */
	private String WageCode;
	/** Wagename */
	private String WageName;
	/** Description */
	private String Description;
	/** Indexserise */
	private String IndexSerise;
	/** Wagetype */
	private String WageType;
	/** State */
	private String State;
	/** Branchtype */
	private String BranchType;
	/** Branchtype2 */
	private String BranchType2;
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

	public static final int FIELDNUM = 13;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LRIndexSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "WageCode";

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
		LRIndexSchema cloned = (LRIndexSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getWageCode()
	{
		return WageCode;
	}
	public void setWageCode(String aWageCode)
	{
		if(aWageCode!=null && aWageCode.length()>20)
			throw new IllegalArgumentException("WagecodeWageCode值"+aWageCode+"的长度"+aWageCode.length()+"大于最大值20");
		WageCode = aWageCode;
	}
	/**
	* 项目名称
	*/
	public String getWageName()
	{
		return WageName;
	}
	public void setWageName(String aWageName)
	{
		if(aWageName!=null && aWageName.length()>200)
			throw new IllegalArgumentException("WagenameWageName值"+aWageName+"的长度"+aWageName.length()+"大于最大值200");
		WageName = aWageName;
	}
	/**
	* 描述
	*/
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String aDescription)
	{
		if(aDescription!=null && aDescription.length()>500)
			throw new IllegalArgumentException("DescriptionDescription值"+aDescription+"的长度"+aDescription.length()+"大于最大值500");
		Description = aDescription;
	}
	/**
	* 项目系列
	*/
	public String getIndexSerise()
	{
		return IndexSerise;
	}
	public void setIndexSerise(String aIndexSerise)
	{
		if(aIndexSerise!=null && aIndexSerise.length()>2)
			throw new IllegalArgumentException("IndexseriseIndexSerise值"+aIndexSerise+"的长度"+aIndexSerise.length()+"大于最大值2");
		IndexSerise = aIndexSerise;
	}
	/**
	* 项目类型
	*/
	public String getWageType()
	{
		return WageType;
	}
	public void setWageType(String aWageType)
	{
		if(aWageType!=null && aWageType.length()>2)
			throw new IllegalArgumentException("WagetypeWageType值"+aWageType+"的长度"+aWageType.length()+"大于最大值2");
		WageType = aWageType;
	}
	/**
	* 状态
	*/
	public String getState()
	{
		return State;
	}
	public void setState(String aState)
	{
		if(aState!=null && aState.length()>1)
			throw new IllegalArgumentException("StateState值"+aState+"的长度"+aState.length()+"大于最大值1");
		State = aState;
	}
	/**
	* 渠道
	*/
	public String getBranchType()
	{
		return BranchType;
	}
	public void setBranchType(String aBranchType)
	{
		if(aBranchType!=null && aBranchType.length()>2)
			throw new IllegalArgumentException("BranchtypeBranchType值"+aBranchType+"的长度"+aBranchType.length()+"大于最大值2");
		BranchType = aBranchType;
	}
	/**
	* 子渠道
	*/
	public String getBranchType2()
	{
		return BranchType2;
	}
	public void setBranchType2(String aBranchType2)
	{
		if(aBranchType2!=null && aBranchType2.length()>2)
			throw new IllegalArgumentException("Branchtype2BranchType2值"+aBranchType2+"的长度"+aBranchType2.length()+"大于最大值2");
		BranchType2 = aBranchType2;
	}
	/**
	* 操作者
	*/
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
	/**
	* 入机日期
	*/
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

	/**
	* 入机时间
	*/
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
	/**
	* 最后一次修改日期
	*/
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

	/**
	* 最后一次修改时间
	*/
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

	/**
	* 使用另外一个 LRIndexSchema 对象给 Schema 赋值
	* @param: aLRIndexSchema LRIndexSchema
	**/
	public void setSchema(LRIndexSchema aLRIndexSchema)
	{
		this.WageCode = aLRIndexSchema.getWageCode();
		this.WageName = aLRIndexSchema.getWageName();
		this.Description = aLRIndexSchema.getDescription();
		this.IndexSerise = aLRIndexSchema.getIndexSerise();
		this.WageType = aLRIndexSchema.getWageType();
		this.State = aLRIndexSchema.getState();
		this.BranchType = aLRIndexSchema.getBranchType();
		this.BranchType2 = aLRIndexSchema.getBranchType2();
		this.Operator = aLRIndexSchema.getOperator();
		this.MakeDate = fDate.getDate( aLRIndexSchema.getMakeDate());
		this.MakeTime = aLRIndexSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLRIndexSchema.getModifyDate());
		this.ModifyTime = aLRIndexSchema.getModifyTime();
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
			if( rs.getString("WageCode") == null )
				this.WageCode = null;
			else
				this.WageCode = rs.getString("WageCode").trim();

			if( rs.getString("WageName") == null )
				this.WageName = null;
			else
				this.WageName = rs.getString("WageName").trim();

			if( rs.getString("Description") == null )
				this.Description = null;
			else
				this.Description = rs.getString("Description").trim();

			if( rs.getString("IndexSerise") == null )
				this.IndexSerise = null;
			else
				this.IndexSerise = rs.getString("IndexSerise").trim();

			if( rs.getString("WageType") == null )
				this.WageType = null;
			else
				this.WageType = rs.getString("WageType").trim();

			if( rs.getString("State") == null )
				this.State = null;
			else
				this.State = rs.getString("State").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("BranchType2") == null )
				this.BranchType2 = null;
			else
				this.BranchType2 = rs.getString("BranchType2").trim();

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

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LRIndex表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LRIndexSchema getSchema()
	{
		LRIndexSchema aLRIndexSchema = new LRIndexSchema();
		aLRIndexSchema.setSchema(this);
		return aLRIndexSchema;
	}

	public LRIndexDB getDB()
	{
		LRIndexDB aDBOper = new LRIndexDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRIndex描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(WageCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Description)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexSerise)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(State)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRIndex>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			WageCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			WageName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			Description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			IndexSerise = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			WageType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			BranchType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexSchema";
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
		if (FCode.equalsIgnoreCase("WageCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageCode));
		}
		if (FCode.equalsIgnoreCase("WageName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageName));
		}
		if (FCode.equalsIgnoreCase("Description"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Description));
		}
		if (FCode.equalsIgnoreCase("IndexSerise"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexSerise));
		}
		if (FCode.equalsIgnoreCase("WageType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageType));
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(State));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType2));
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
				strFieldValue = StrTool.GBKToUnicode(WageCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(WageName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(Description);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(IndexSerise);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(WageType);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(State);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(BranchType2);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
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

		if (FCode.equalsIgnoreCase("WageCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageCode = FValue.trim();
			}
			else
				WageCode = null;
		}
		if (FCode.equalsIgnoreCase("WageName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageName = FValue.trim();
			}
			else
				WageName = null;
		}
		if (FCode.equalsIgnoreCase("Description"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Description = FValue.trim();
			}
			else
				Description = null;
		}
		if (FCode.equalsIgnoreCase("IndexSerise"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexSerise = FValue.trim();
			}
			else
				IndexSerise = null;
		}
		if (FCode.equalsIgnoreCase("WageType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageType = FValue.trim();
			}
			else
				WageType = null;
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				State = FValue.trim();
			}
			else
				State = null;
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
		}
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType2 = FValue.trim();
			}
			else
				BranchType2 = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LRIndexSchema other = (LRIndexSchema)otherObject;
		return
			WageCode.equals(other.getWageCode())
			&& WageName.equals(other.getWageName())
			&& Description.equals(other.getDescription())
			&& IndexSerise.equals(other.getIndexSerise())
			&& WageType.equals(other.getWageType())
			&& State.equals(other.getState())
			&& BranchType.equals(other.getBranchType())
			&& BranchType2.equals(other.getBranchType2())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime());
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
		if( strFieldName.equals("WageCode") ) {
			return 0;
		}
		if( strFieldName.equals("WageName") ) {
			return 1;
		}
		if( strFieldName.equals("Description") ) {
			return 2;
		}
		if( strFieldName.equals("IndexSerise") ) {
			return 3;
		}
		if( strFieldName.equals("WageType") ) {
			return 4;
		}
		if( strFieldName.equals("State") ) {
			return 5;
		}
		if( strFieldName.equals("BranchType") ) {
			return 6;
		}
		if( strFieldName.equals("BranchType2") ) {
			return 7;
		}
		if( strFieldName.equals("Operator") ) {
			return 8;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 9;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 10;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 11;
		}
		if( strFieldName.equals("ModifyTime") ) {
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
				strFieldName = "WageCode";
				break;
			case 1:
				strFieldName = "WageName";
				break;
			case 2:
				strFieldName = "Description";
				break;
			case 3:
				strFieldName = "IndexSerise";
				break;
			case 4:
				strFieldName = "WageType";
				break;
			case 5:
				strFieldName = "State";
				break;
			case 6:
				strFieldName = "BranchType";
				break;
			case 7:
				strFieldName = "BranchType2";
				break;
			case 8:
				strFieldName = "Operator";
				break;
			case 9:
				strFieldName = "MakeDate";
				break;
			case 10:
				strFieldName = "MakeTime";
				break;
			case 11:
				strFieldName = "ModifyDate";
				break;
			case 12:
				strFieldName = "ModifyTime";
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
		if( strFieldName.equals("WageCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Description") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexSerise") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("State") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType2") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_DATE;
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
