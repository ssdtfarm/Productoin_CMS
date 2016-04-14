/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.schema;

import java.sql.*;
import java.io.*;
import java.util.Date;
import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.utility.*;
import com.sinosoft.lis.db.LACalModeZDB;

/*
 * <p>ClassName: LACalModeZSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: PhysicalDataModel_1
 * @CreateDate：2011-01-04
 */
public class LACalModeZSchema implements Schema, Cloneable
{
	// @Field
	/** 规则编码 */
	private String CalCode;
	/** 规则类型 */
	private String IndexSeries;
	/** 规则简介 */
	private String EIntroduce;
	/** 规则算法 */
	private String CalSql;
	/** 参数设置类型 */
	private String ParaType;
	/** 规则介绍 */
	private String Introduce;
	/** 规则公式 */
	private String CalRule;
	/** 操作员代码 */
	private String Operator;
	/** 入机日期 */
	private Date MakeDate;
	/** 入机时间 */
	private String MakeTime;
	/** 最后一次修改日期 */
	private Date ModifyDate;
	/** 最后一次修改时间 */
	private String ModifyTime;
	/** 版本号 */
	private String Version;
	/** 批次号 */
	private String Batch;
	/** 备用1 */
	private String T1;
	/** 备用2 */
	private String T2;
	/** 备用3 */
	private String T3;
	/** 备用4 */
	private String T4;
	/** 备用5 */
	private double T5;
	/** 审核标志 */
	private String Flag;

	public static final int FIELDNUM = 20;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LACalModeZSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "CalCode";

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
                LACalModeZSchema cloned = (LACalModeZSchema)super.clone();
                cloned.fDate = (FDate) fDate.clone();
                cloned.mErrors = (CErrors) mErrors.clone();
                return cloned;
            }

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCalCode()
	{
		return CalCode;
	}
	public void setCalCode(String aCalCode)
	{
		CalCode = aCalCode;
	}
	public String getIndexSeries()
	{
		return IndexSeries;
	}
	public void setIndexSeries(String aIndexSeries)
	{
		IndexSeries = aIndexSeries;
	}
	public String getEIntroduce()
	{
		return EIntroduce;
	}
	public void setEIntroduce(String aEIntroduce)
	{
		EIntroduce = aEIntroduce;
	}
	public String getCalSql()
	{
		return CalSql;
	}
	public void setCalSql(String aCalSql)
	{
		CalSql = aCalSql;
	}
	public String getParaType()
	{
		return ParaType;
	}
	public void setParaType(String aParaType)
	{
		ParaType = aParaType;
	}
	public String getIntroduce()
	{
		return Introduce;
	}
	public void setIntroduce(String aIntroduce)
	{
		Introduce = aIntroduce;
	}
	public String getCalRule()
	{
		return CalRule;
	}
	public void setCalRule(String aCalRule)
	{
		CalRule = aCalRule;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
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
		ModifyTime = aModifyTime;
	}
	public String getVersion()
	{
		return Version;
	}
	public void setVersion(String aVersion)
	{
		Version = aVersion;
	}
	public String getBatch()
	{
		return Batch;
	}
	public void setBatch(String aBatch)
	{
		Batch = aBatch;
	}
	public String getT1()
	{
		return T1;
	}
	public void setT1(String aT1)
	{
		T1 = aT1;
	}
	public String getT2()
	{
		return T2;
	}
	public void setT2(String aT2)
	{
		T2 = aT2;
	}
	public String getT3()
	{
		return T3;
	}
	public void setT3(String aT3)
	{
		T3 = aT3;
	}
	public String getT4()
	{
		return T4;
	}
	public void setT4(String aT4)
	{
		T4 = aT4;
	}
	public double getT5()
	{
		return T5;
	}
	public void setT5(double aT5)
	{
		T5 = aT5;
	}
	public void setT5(String aT5)
	{
		if (aT5 != null && !aT5.equals(""))
		{
			Double tDouble = new Double(aT5);
			double d = tDouble.doubleValue();
			T5 = d;
		}
	}

	public String getFlag()
	{
		return Flag;
	}
	public void setFlag(String aFlag)
	{
		Flag = aFlag;
	}

	/**
	* 使用另外一个 LACalModeZSchema 对象给 Schema 赋值
	* @param: aLACalModeZSchema LACalModeZSchema
	**/
	public void setSchema(LACalModeZSchema aLACalModeZSchema)
	{
		this.CalCode = aLACalModeZSchema.getCalCode();
		this.IndexSeries = aLACalModeZSchema.getIndexSeries();
		this.EIntroduce = aLACalModeZSchema.getEIntroduce();
		this.CalSql = aLACalModeZSchema.getCalSql();
		this.ParaType = aLACalModeZSchema.getParaType();
		this.Introduce = aLACalModeZSchema.getIntroduce();
		this.CalRule = aLACalModeZSchema.getCalRule();
		this.Operator = aLACalModeZSchema.getOperator();
		this.MakeDate = fDate.getDate( aLACalModeZSchema.getMakeDate());
		this.MakeTime = aLACalModeZSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLACalModeZSchema.getModifyDate());
		this.ModifyTime = aLACalModeZSchema.getModifyTime();
		this.Version = aLACalModeZSchema.getVersion();
		this.Batch = aLACalModeZSchema.getBatch();
		this.T1 = aLACalModeZSchema.getT1();
		this.T2 = aLACalModeZSchema.getT2();
		this.T3 = aLACalModeZSchema.getT3();
		this.T4 = aLACalModeZSchema.getT4();
		this.T5 = aLACalModeZSchema.getT5();
		this.Flag = aLACalModeZSchema.getFlag();
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
			if( rs.getString("CalCode") == null )
				this.CalCode = null;
			else
				this.CalCode = rs.getString("CalCode").trim();

			if( rs.getString("IndexSeries") == null )
				this.IndexSeries = null;
			else
				this.IndexSeries = rs.getString("IndexSeries").trim();

			if( rs.getString("EIntroduce") == null )
				this.EIntroduce = null;
			else
				this.EIntroduce = rs.getString("EIntroduce").trim();

			if( rs.getString("CalSql") == null )
				this.CalSql = null;
			else
				this.CalSql = rs.getString("CalSql").trim();

			if( rs.getString("ParaType") == null )
				this.ParaType = null;
			else
				this.ParaType = rs.getString("ParaType").trim();

			if( rs.getString("Introduce") == null )
				this.Introduce = null;
			else
				this.Introduce = rs.getString("Introduce").trim();

			if( rs.getString("CalRule") == null )
				this.CalRule = null;
			else
				this.CalRule = rs.getString("CalRule").trim();

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

			if( rs.getString("Version") == null )
				this.Version = null;
			else
				this.Version = rs.getString("Version").trim();

			if( rs.getString("Batch") == null )
				this.Batch = null;
			else
				this.Batch = rs.getString("Batch").trim();

			if( rs.getString("T1") == null )
				this.T1 = null;
			else
				this.T1 = rs.getString("T1").trim();

			if( rs.getString("T2") == null )
				this.T2 = null;
			else
				this.T2 = rs.getString("T2").trim();

			if( rs.getString("T3") == null )
				this.T3 = null;
			else
				this.T3 = rs.getString("T3").trim();

			if( rs.getString("T4") == null )
				this.T4 = null;
			else
				this.T4 = rs.getString("T4").trim();

			this.T5 = rs.getDouble("T5");
			if( rs.getString("Flag") == null )
				this.Flag = null;
			else
				this.Flag = rs.getString("Flag").trim();

		}
		catch(SQLException sqle)
		{
			System.out.println("数据库中的LACalModeZ表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACalModeZSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LACalModeZSchema getSchema()
	{
		LACalModeZSchema aLACalModeZSchema = new LACalModeZSchema();
		aLACalModeZSchema.setSchema(this);
		return aLACalModeZSchema;
	}

	public LACalModeZDB getDB()
	{
		LACalModeZDB aDBOper = new LACalModeZDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLACalModeZ描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
strReturn.append(StrTool.cTrim(CalCode)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(IndexSeries)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(EIntroduce)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(CalSql)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(ParaType)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(Introduce)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(CalRule)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(Version)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(Batch)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(T1)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(T2)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(T3)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(T4)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append( ChgData.chgData(T5));strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(Flag));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLACalModeZ>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			CalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			IndexSeries = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			EIntroduce = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			CalSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ParaType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Introduce = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			CalRule = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Version = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Batch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			T1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			T2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			T3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			T4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			T5 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,19,SysConst.PACKAGESPILTER))).doubleValue();
			Flag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACalModeZSchema";
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
		if (FCode.equalsIgnoreCase("CalCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalCode));
		}
		if (FCode.equalsIgnoreCase("IndexSeries"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexSeries));
		}
		if (FCode.equalsIgnoreCase("EIntroduce"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EIntroduce));
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalSql));
		}
		if (FCode.equalsIgnoreCase("ParaType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ParaType));
		}
		if (FCode.equalsIgnoreCase("Introduce"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Introduce));
		}
		if (FCode.equalsIgnoreCase("CalRule"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalRule));
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
		if (FCode.equalsIgnoreCase("Version"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Version));
		}
		if (FCode.equalsIgnoreCase("Batch"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Batch));
		}
		if (FCode.equalsIgnoreCase("T1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(T1));
		}
		if (FCode.equalsIgnoreCase("T2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(T2));
		}
		if (FCode.equalsIgnoreCase("T3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(T3));
		}
		if (FCode.equalsIgnoreCase("T4"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(T4));
		}
		if (FCode.equalsIgnoreCase("T5"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(T5));
		}
		if (FCode.equalsIgnoreCase("Flag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag));
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
				strFieldValue = StrTool.GBKToUnicode(CalCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(IndexSeries);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(EIntroduce);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(CalSql);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ParaType);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Introduce);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(CalRule);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Operator);
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
				strFieldValue = StrTool.GBKToUnicode(Version);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Batch);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(T1);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(T2);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(T3);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(T4);
				break;
			case 18:
				strFieldValue = String.valueOf(T5);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(Flag);
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

		if (FCode.equalsIgnoreCase("CalCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalCode = FValue.trim();
			}
			else
				CalCode = null;
		}
		if (FCode.equalsIgnoreCase("IndexSeries"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexSeries = FValue.trim();
			}
			else
				IndexSeries = null;
		}
		if (FCode.equalsIgnoreCase("EIntroduce"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EIntroduce = FValue.trim();
			}
			else
				EIntroduce = null;
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalSql = FValue.trim();
			}
			else
				CalSql = null;
		}
		if (FCode.equalsIgnoreCase("ParaType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ParaType = FValue.trim();
			}
			else
				ParaType = null;
		}
		if (FCode.equalsIgnoreCase("Introduce"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Introduce = FValue.trim();
			}
			else
				Introduce = null;
		}
		if (FCode.equalsIgnoreCase("CalRule"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalRule = FValue.trim();
			}
			else
				CalRule = null;
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
		if (FCode.equalsIgnoreCase("Version"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Version = FValue.trim();
			}
			else
				Version = null;
		}
		if (FCode.equalsIgnoreCase("Batch"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Batch = FValue.trim();
			}
			else
				Batch = null;
		}
		if (FCode.equalsIgnoreCase("T1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				T1 = FValue.trim();
			}
			else
				T1 = null;
		}
		if (FCode.equalsIgnoreCase("T2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				T2 = FValue.trim();
			}
			else
				T2 = null;
		}
		if (FCode.equalsIgnoreCase("T3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				T3 = FValue.trim();
			}
			else
				T3 = null;
		}
		if (FCode.equalsIgnoreCase("T4"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				T4 = FValue.trim();
			}
			else
				T4 = null;
		}
		if (FCode.equalsIgnoreCase("T5"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				T5 = d;
			}
		}
		if (FCode.equalsIgnoreCase("Flag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag = FValue.trim();
			}
			else
				Flag = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (!(otherObject instanceof LACalModeZSchema )) return false;
		LACalModeZSchema other = (LACalModeZSchema)otherObject;
    if (CalCode==null) {
      if (other.getCalCode() != null)
         return false;
   }else if (!CalCode.equals(other.getCalCode())) {
      return false;
   }
    if (IndexSeries==null) {
      if (other.getIndexSeries() != null)
         return false;
   }else if (!IndexSeries.equals(other.getIndexSeries())) {
      return false;
   }
    if (EIntroduce==null) {
      if (other.getEIntroduce() != null)
         return false;
   }else if (!EIntroduce.equals(other.getEIntroduce())) {
      return false;
   }
    if (CalSql==null) {
      if (other.getCalSql() != null)
         return false;
   }else if (!CalSql.equals(other.getCalSql())) {
      return false;
   }
    if (ParaType==null) {
      if (other.getParaType() != null)
         return false;
   }else if (!ParaType.equals(other.getParaType())) {
      return false;
   }
    if (Introduce==null) {
      if (other.getIntroduce() != null)
         return false;
   }else if (!Introduce.equals(other.getIntroduce())) {
      return false;
   }
    if (CalRule==null) {
      if (other.getCalRule() != null)
         return false;
   }else if (!CalRule.equals(other.getCalRule())) {
      return false;
   }
    if (Operator==null) {
      if (other.getOperator() != null)
         return false;
   }else if (!Operator.equals(other.getOperator())) {
      return false;
   }
    if (fDate.getString(MakeDate) ==null) {
      if (other.getMakeDate() != null)
         return false;
   }else if (!fDate.getString(MakeDate) .equals(other.getMakeDate())) {
      return false;
   }
    if (MakeTime==null) {
      if (other.getMakeTime() != null)
         return false;
   }else if (!MakeTime.equals(other.getMakeTime())) {
      return false;
   }
    if (fDate.getString(ModifyDate) ==null) {
      if (other.getModifyDate() != null)
         return false;
   }else if (!fDate.getString(ModifyDate) .equals(other.getModifyDate())) {
      return false;
   }
    if (ModifyTime==null) {
      if (other.getModifyTime() != null)
         return false;
   }else if (!ModifyTime.equals(other.getModifyTime())) {
      return false;
   }
    if (Version==null) {
      if (other.getVersion() != null)
         return false;
   }else if (!Version.equals(other.getVersion())) {
      return false;
   }
    if (Batch==null) {
      if (other.getBatch() != null)
         return false;
   }else if (!Batch.equals(other.getBatch())) {
      return false;
   }
    if (T1==null) {
      if (other.getT1() != null)
         return false;
   }else if (!T1.equals(other.getT1())) {
      return false;
   }
    if (T2==null) {
      if (other.getT2() != null)
         return false;
   }else if (!T2.equals(other.getT2())) {
      return false;
   }
    if (T3==null) {
      if (other.getT3() != null)
         return false;
   }else if (!T3.equals(other.getT3())) {
      return false;
   }
    if (T4==null) {
      if (other.getT4() != null)
         return false;
   }else if (!T4.equals(other.getT4())) {
      return false;
   }
   if (Double.doubleToLongBits(T5)!=Double.doubleToLongBits(other.getT5())) {
      return false;
   }
    if (Flag==null) {
      if (other.getFlag() != null)
         return false;
   }else if (!Flag.equals(other.getFlag())) {
      return false;
   }
    return true;
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
		if( strFieldName.equals("CalCode") ) {
			return 0;
		}
		if( strFieldName.equals("IndexSeries") ) {
			return 1;
		}
		if( strFieldName.equals("EIntroduce") ) {
			return 2;
		}
		if( strFieldName.equals("CalSql") ) {
			return 3;
		}
		if( strFieldName.equals("ParaType") ) {
			return 4;
		}
		if( strFieldName.equals("Introduce") ) {
			return 5;
		}
		if( strFieldName.equals("CalRule") ) {
			return 6;
		}
		if( strFieldName.equals("Operator") ) {
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
		if( strFieldName.equals("Version") ) {
			return 12;
		}
		if( strFieldName.equals("Batch") ) {
			return 13;
		}
		if( strFieldName.equals("T1") ) {
			return 14;
		}
		if( strFieldName.equals("T2") ) {
			return 15;
		}
		if( strFieldName.equals("T3") ) {
			return 16;
		}
		if( strFieldName.equals("T4") ) {
			return 17;
		}
		if( strFieldName.equals("T5") ) {
			return 18;
		}
		if( strFieldName.equals("Flag") ) {
			return 19;
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
				strFieldName = "CalCode";
				break;
			case 1:
				strFieldName = "IndexSeries";
				break;
			case 2:
				strFieldName = "EIntroduce";
				break;
			case 3:
				strFieldName = "CalSql";
				break;
			case 4:
				strFieldName = "ParaType";
				break;
			case 5:
				strFieldName = "Introduce";
				break;
			case 6:
				strFieldName = "CalRule";
				break;
			case 7:
				strFieldName = "Operator";
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
				strFieldName = "Version";
				break;
			case 13:
				strFieldName = "Batch";
				break;
			case 14:
				strFieldName = "T1";
				break;
			case 15:
				strFieldName = "T2";
				break;
			case 16:
				strFieldName = "T3";
				break;
			case 17:
				strFieldName = "T4";
				break;
			case 18:
				strFieldName = "T5";
				break;
			case 19:
				strFieldName = "Flag";
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
		if( strFieldName.equals("CalCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexSeries") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EIntroduce") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalSql") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ParaType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Introduce") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalRule") ) {
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
		if( strFieldName.equals("Version") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Batch") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("T1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("T2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("T3") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("T4") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("T5") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Flag") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
