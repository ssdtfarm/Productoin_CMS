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
import com.sinosoft.lis.db.LARepImpCodeDB;

/*
 * <p>ClassName: LARepImpCodeSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LARepImpCodeSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LARepImpCodeSchema.class);
	// @Field
	/** Impcode */
	private String ImpCode;
	/** Impname */
	private String ImpName;
	/** Imptype */
	private String ImpType;
	/** Impinput */
	private String ImpInput;
	/** Impcodetype */
	private String ImpCodeType;
	/** Impcodefrom */
	private String ImpCodeFrom;
	/** Flag1 */
	private String Flag1;
	/** Flag2 */
	private String Flag2;
	/** Flag3 */
	private String Flag3;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;
	/** Operator */
	private String Operator;

	public static final int FIELDNUM = 14;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LARepImpCodeSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "ImpCode";
		pk[1] = "ImpType";

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
		LARepImpCodeSchema cloned = (LARepImpCodeSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getImpCode()
	{
		return ImpCode;
	}
	public void setImpCode(String aImpCode)
	{
		if(aImpCode!=null && aImpCode.length()>100)
			throw new IllegalArgumentException("ImpcodeImpCode值"+aImpCode+"的长度"+aImpCode.length()+"大于最大值100");
		ImpCode = aImpCode;
	}
	public String getImpName()
	{
		return ImpName;
	}
	public void setImpName(String aImpName)
	{
		if(aImpName!=null && aImpName.length()>200)
			throw new IllegalArgumentException("ImpnameImpName值"+aImpName+"的长度"+aImpName.length()+"大于最大值200");
		ImpName = aImpName;
	}
	public String getImpType()
	{
		return ImpType;
	}
	public void setImpType(String aImpType)
	{
		if(aImpType!=null && aImpType.length()>2)
			throw new IllegalArgumentException("ImptypeImpType值"+aImpType+"的长度"+aImpType.length()+"大于最大值2");
		ImpType = aImpType;
	}
	public String getImpInput()
	{
		return ImpInput;
	}
	public void setImpInput(String aImpInput)
	{
		if(aImpInput!=null && aImpInput.length()>2)
			throw new IllegalArgumentException("ImpinputImpInput值"+aImpInput+"的长度"+aImpInput.length()+"大于最大值2");
		ImpInput = aImpInput;
	}
	public String getImpCodeType()
	{
		return ImpCodeType;
	}
	public void setImpCodeType(String aImpCodeType)
	{
		if(aImpCodeType!=null && aImpCodeType.length()>50)
			throw new IllegalArgumentException("ImpcodetypeImpCodeType值"+aImpCodeType+"的长度"+aImpCodeType.length()+"大于最大值50");
		ImpCodeType = aImpCodeType;
	}
	public String getImpCodeFrom()
	{
		return ImpCodeFrom;
	}
	public void setImpCodeFrom(String aImpCodeFrom)
	{
		if(aImpCodeFrom!=null && aImpCodeFrom.length()>50)
			throw new IllegalArgumentException("ImpcodefromImpCodeFrom值"+aImpCodeFrom+"的长度"+aImpCodeFrom.length()+"大于最大值50");
		ImpCodeFrom = aImpCodeFrom;
	}
	public String getFlag1()
	{
		return Flag1;
	}
	public void setFlag1(String aFlag1)
	{
		if(aFlag1!=null && aFlag1.length()>80)
			throw new IllegalArgumentException("Flag1Flag1值"+aFlag1+"的长度"+aFlag1.length()+"大于最大值80");
		Flag1 = aFlag1;
	}
	public String getFlag2()
	{
		return Flag2;
	}
	public void setFlag2(String aFlag2)
	{
		if(aFlag2!=null && aFlag2.length()>80)
			throw new IllegalArgumentException("Flag2Flag2值"+aFlag2+"的长度"+aFlag2.length()+"大于最大值80");
		Flag2 = aFlag2;
	}
	public String getFlag3()
	{
		return Flag3;
	}
	public void setFlag3(String aFlag3)
	{
		if(aFlag3!=null && aFlag3.length()>80)
			throw new IllegalArgumentException("Flag3Flag3值"+aFlag3+"的长度"+aFlag3.length()+"大于最大值80");
		Flag3 = aFlag3;
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
	* 使用另外一个 LARepImpCodeSchema 对象给 Schema 赋值
	* @param: aLARepImpCodeSchema LARepImpCodeSchema
	**/
	public void setSchema(LARepImpCodeSchema aLARepImpCodeSchema)
	{
		this.ImpCode = aLARepImpCodeSchema.getImpCode();
		this.ImpName = aLARepImpCodeSchema.getImpName();
		this.ImpType = aLARepImpCodeSchema.getImpType();
		this.ImpInput = aLARepImpCodeSchema.getImpInput();
		this.ImpCodeType = aLARepImpCodeSchema.getImpCodeType();
		this.ImpCodeFrom = aLARepImpCodeSchema.getImpCodeFrom();
		this.Flag1 = aLARepImpCodeSchema.getFlag1();
		this.Flag2 = aLARepImpCodeSchema.getFlag2();
		this.Flag3 = aLARepImpCodeSchema.getFlag3();
		this.MakeDate = fDate.getDate( aLARepImpCodeSchema.getMakeDate());
		this.MakeTime = aLARepImpCodeSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLARepImpCodeSchema.getModifyDate());
		this.ModifyTime = aLARepImpCodeSchema.getModifyTime();
		this.Operator = aLARepImpCodeSchema.getOperator();
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
			if( rs.getString("ImpCode") == null )
				this.ImpCode = null;
			else
				this.ImpCode = rs.getString("ImpCode").trim();

			if( rs.getString("ImpName") == null )
				this.ImpName = null;
			else
				this.ImpName = rs.getString("ImpName").trim();

			if( rs.getString("ImpType") == null )
				this.ImpType = null;
			else
				this.ImpType = rs.getString("ImpType").trim();

			if( rs.getString("ImpInput") == null )
				this.ImpInput = null;
			else
				this.ImpInput = rs.getString("ImpInput").trim();

			if( rs.getString("ImpCodeType") == null )
				this.ImpCodeType = null;
			else
				this.ImpCodeType = rs.getString("ImpCodeType").trim();

			if( rs.getString("ImpCodeFrom") == null )
				this.ImpCodeFrom = null;
			else
				this.ImpCodeFrom = rs.getString("ImpCodeFrom").trim();

			if( rs.getString("Flag1") == null )
				this.Flag1 = null;
			else
				this.Flag1 = rs.getString("Flag1").trim();

			if( rs.getString("Flag2") == null )
				this.Flag2 = null;
			else
				this.Flag2 = rs.getString("Flag2").trim();

			if( rs.getString("Flag3") == null )
				this.Flag3 = null;
			else
				this.Flag3 = rs.getString("Flag3").trim();

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

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LARepImpCode表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARepImpCodeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LARepImpCodeSchema getSchema()
	{
		LARepImpCodeSchema aLARepImpCodeSchema = new LARepImpCodeSchema();
		aLARepImpCodeSchema.setSchema(this);
		return aLARepImpCodeSchema;
	}

	public LARepImpCodeDB getDB()
	{
		LARepImpCodeDB aDBOper = new LARepImpCodeDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARepImpCode描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ImpCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpInput)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpCodeType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpCodeFrom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARepImpCode>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ImpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ImpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ImpType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ImpInput = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ImpCodeType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			ImpCodeFrom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARepImpCodeSchema";
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
		if (FCode.equalsIgnoreCase("ImpCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ImpCode));
		}
		if (FCode.equalsIgnoreCase("ImpName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ImpName));
		}
		if (FCode.equalsIgnoreCase("ImpType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ImpType));
		}
		if (FCode.equalsIgnoreCase("ImpInput"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ImpInput));
		}
		if (FCode.equalsIgnoreCase("ImpCodeType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ImpCodeType));
		}
		if (FCode.equalsIgnoreCase("ImpCodeFrom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ImpCodeFrom));
		}
		if (FCode.equalsIgnoreCase("Flag1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag1));
		}
		if (FCode.equalsIgnoreCase("Flag2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag2));
		}
		if (FCode.equalsIgnoreCase("Flag3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag3));
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
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
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
				strFieldValue = StrTool.GBKToUnicode(ImpCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ImpName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ImpType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ImpInput);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ImpCodeType);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(ImpCodeFrom);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(Flag1);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Flag2);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Flag3);
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
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Operator);
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

		if (FCode.equalsIgnoreCase("ImpCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ImpCode = FValue.trim();
			}
			else
				ImpCode = null;
		}
		if (FCode.equalsIgnoreCase("ImpName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ImpName = FValue.trim();
			}
			else
				ImpName = null;
		}
		if (FCode.equalsIgnoreCase("ImpType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ImpType = FValue.trim();
			}
			else
				ImpType = null;
		}
		if (FCode.equalsIgnoreCase("ImpInput"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ImpInput = FValue.trim();
			}
			else
				ImpInput = null;
		}
		if (FCode.equalsIgnoreCase("ImpCodeType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ImpCodeType = FValue.trim();
			}
			else
				ImpCodeType = null;
		}
		if (FCode.equalsIgnoreCase("ImpCodeFrom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ImpCodeFrom = FValue.trim();
			}
			else
				ImpCodeFrom = null;
		}
		if (FCode.equalsIgnoreCase("Flag1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag1 = FValue.trim();
			}
			else
				Flag1 = null;
		}
		if (FCode.equalsIgnoreCase("Flag2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag2 = FValue.trim();
			}
			else
				Flag2 = null;
		}
		if (FCode.equalsIgnoreCase("Flag3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag3 = FValue.trim();
			}
			else
				Flag3 = null;
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
		if (FCode.equalsIgnoreCase("Operator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator = FValue.trim();
			}
			else
				Operator = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LARepImpCodeSchema other = (LARepImpCodeSchema)otherObject;
		return
			ImpCode.equals(other.getImpCode())
			&& ImpName.equals(other.getImpName())
			&& ImpType.equals(other.getImpType())
			&& ImpInput.equals(other.getImpInput())
			&& ImpCodeType.equals(other.getImpCodeType())
			&& ImpCodeFrom.equals(other.getImpCodeFrom())
			&& Flag1.equals(other.getFlag1())
			&& Flag2.equals(other.getFlag2())
			&& Flag3.equals(other.getFlag3())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator.equals(other.getOperator());
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
		if( strFieldName.equals("ImpCode") ) {
			return 0;
		}
		if( strFieldName.equals("ImpName") ) {
			return 1;
		}
		if( strFieldName.equals("ImpType") ) {
			return 2;
		}
		if( strFieldName.equals("ImpInput") ) {
			return 3;
		}
		if( strFieldName.equals("ImpCodeType") ) {
			return 4;
		}
		if( strFieldName.equals("ImpCodeFrom") ) {
			return 5;
		}
		if( strFieldName.equals("Flag1") ) {
			return 6;
		}
		if( strFieldName.equals("Flag2") ) {
			return 7;
		}
		if( strFieldName.equals("Flag3") ) {
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
		if( strFieldName.equals("Operator") ) {
			return 13;
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
				strFieldName = "ImpCode";
				break;
			case 1:
				strFieldName = "ImpName";
				break;
			case 2:
				strFieldName = "ImpType";
				break;
			case 3:
				strFieldName = "ImpInput";
				break;
			case 4:
				strFieldName = "ImpCodeType";
				break;
			case 5:
				strFieldName = "ImpCodeFrom";
				break;
			case 6:
				strFieldName = "Flag1";
				break;
			case 7:
				strFieldName = "Flag2";
				break;
			case 8:
				strFieldName = "Flag3";
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
			case 13:
				strFieldName = "Operator";
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
		if( strFieldName.equals("ImpCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ImpName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ImpType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ImpInput") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ImpCodeType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ImpCodeFrom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Flag1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Flag2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Flag3") ) {
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
		if( strFieldName.equals("Operator") ) {
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
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
