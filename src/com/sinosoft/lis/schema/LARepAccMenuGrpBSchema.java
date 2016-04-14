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
import com.sinosoft.lis.db.LARepAccMenuGrpBDB;

/*
 * <p>ClassName: LARepAccMenuGrpBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LARepAccMenuGrpBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LARepAccMenuGrpBSchema.class);
	// @Field
	/** Reportcode */
	private String ReportCode;
	/** Impcode */
	private String ImpCode;
	/** Impname */
	private String ImpName;
	/** Imptype */
	private String ImpType;
	/** Impinput */
	private String ImpInput;
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
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;
	/** Operator1 */
	private String Operator1;

	public static final int FIELDNUM = 16;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LARepAccMenuGrpBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[6];
		pk[0] = "ReportCode";
		pk[1] = "ImpCode";
		pk[2] = "ImpType";
		pk[3] = "MakeDate1";
		pk[4] = "MakeTime1";
		pk[5] = "Operator1";

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
		LARepAccMenuGrpBSchema cloned = (LARepAccMenuGrpBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getReportCode()
	{
		return ReportCode;
	}
	public void setReportCode(String aReportCode)
	{
		if(aReportCode!=null && aReportCode.length()>100)
			throw new IllegalArgumentException("ReportcodeReportCode值"+aReportCode+"的长度"+aReportCode.length()+"大于最大值100");
		ReportCode = aReportCode;
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

	/**
	* 使用另外一个 LARepAccMenuGrpBSchema 对象给 Schema 赋值
	* @param: aLARepAccMenuGrpBSchema LARepAccMenuGrpBSchema
	**/
	public void setSchema(LARepAccMenuGrpBSchema aLARepAccMenuGrpBSchema)
	{
		this.ReportCode = aLARepAccMenuGrpBSchema.getReportCode();
		this.ImpCode = aLARepAccMenuGrpBSchema.getImpCode();
		this.ImpName = aLARepAccMenuGrpBSchema.getImpName();
		this.ImpType = aLARepAccMenuGrpBSchema.getImpType();
		this.ImpInput = aLARepAccMenuGrpBSchema.getImpInput();
		this.Flag1 = aLARepAccMenuGrpBSchema.getFlag1();
		this.Flag2 = aLARepAccMenuGrpBSchema.getFlag2();
		this.Flag3 = aLARepAccMenuGrpBSchema.getFlag3();
		this.MakeDate = fDate.getDate( aLARepAccMenuGrpBSchema.getMakeDate());
		this.MakeTime = aLARepAccMenuGrpBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLARepAccMenuGrpBSchema.getModifyDate());
		this.ModifyTime = aLARepAccMenuGrpBSchema.getModifyTime();
		this.Operator = aLARepAccMenuGrpBSchema.getOperator();
		this.MakeDate1 = fDate.getDate( aLARepAccMenuGrpBSchema.getMakeDate1());
		this.MakeTime1 = aLARepAccMenuGrpBSchema.getMakeTime1();
		this.Operator1 = aLARepAccMenuGrpBSchema.getOperator1();
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
			if( rs.getString("ReportCode") == null )
				this.ReportCode = null;
			else
				this.ReportCode = rs.getString("ReportCode").trim();

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

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

			if( rs.getString("Operator1") == null )
				this.Operator1 = null;
			else
				this.Operator1 = rs.getString("Operator1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LARepAccMenuGrpB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARepAccMenuGrpBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LARepAccMenuGrpBSchema getSchema()
	{
		LARepAccMenuGrpBSchema aLARepAccMenuGrpBSchema = new LARepAccMenuGrpBSchema();
		aLARepAccMenuGrpBSchema.setSchema(this);
		return aLARepAccMenuGrpBSchema;
	}

	public LARepAccMenuGrpBDB getDB()
	{
		LARepAccMenuGrpBDB aDBOper = new LARepAccMenuGrpBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARepAccMenuGrpB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ReportCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpInput)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARepAccMenuGrpB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ReportCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ImpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ImpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ImpType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ImpInput = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARepAccMenuGrpBSchema";
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
		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReportCode));
		}
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
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime1));
		}
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator1));
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
				strFieldValue = StrTool.GBKToUnicode(ReportCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ImpCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ImpName);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ImpType);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ImpInput);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Flag1);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(Flag2);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Flag3);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
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

		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReportCode = FValue.trim();
			}
			else
				ReportCode = null;
		}
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
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator1 = FValue.trim();
			}
			else
				Operator1 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LARepAccMenuGrpBSchema other = (LARepAccMenuGrpBSchema)otherObject;
		return
			ReportCode.equals(other.getReportCode())
			&& ImpCode.equals(other.getImpCode())
			&& ImpName.equals(other.getImpName())
			&& ImpType.equals(other.getImpType())
			&& ImpInput.equals(other.getImpInput())
			&& Flag1.equals(other.getFlag1())
			&& Flag2.equals(other.getFlag2())
			&& Flag3.equals(other.getFlag3())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1())
			&& Operator1.equals(other.getOperator1());
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
		if( strFieldName.equals("ReportCode") ) {
			return 0;
		}
		if( strFieldName.equals("ImpCode") ) {
			return 1;
		}
		if( strFieldName.equals("ImpName") ) {
			return 2;
		}
		if( strFieldName.equals("ImpType") ) {
			return 3;
		}
		if( strFieldName.equals("ImpInput") ) {
			return 4;
		}
		if( strFieldName.equals("Flag1") ) {
			return 5;
		}
		if( strFieldName.equals("Flag2") ) {
			return 6;
		}
		if( strFieldName.equals("Flag3") ) {
			return 7;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 8;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 9;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 10;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 11;
		}
		if( strFieldName.equals("Operator") ) {
			return 12;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 13;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 14;
		}
		if( strFieldName.equals("Operator1") ) {
			return 15;
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
				strFieldName = "ReportCode";
				break;
			case 1:
				strFieldName = "ImpCode";
				break;
			case 2:
				strFieldName = "ImpName";
				break;
			case 3:
				strFieldName = "ImpType";
				break;
			case 4:
				strFieldName = "ImpInput";
				break;
			case 5:
				strFieldName = "Flag1";
				break;
			case 6:
				strFieldName = "Flag2";
				break;
			case 7:
				strFieldName = "Flag3";
				break;
			case 8:
				strFieldName = "MakeDate";
				break;
			case 9:
				strFieldName = "MakeTime";
				break;
			case 10:
				strFieldName = "ModifyDate";
				break;
			case 11:
				strFieldName = "ModifyTime";
				break;
			case 12:
				strFieldName = "Operator";
				break;
			case 13:
				strFieldName = "MakeDate1";
				break;
			case 14:
				strFieldName = "MakeTime1";
				break;
			case 15:
				strFieldName = "Operator1";
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
		if( strFieldName.equals("ReportCode") ) {
			return Schema.TYPE_STRING;
		}
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
		if( strFieldName.equals("MakeDate1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator1") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 13:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
