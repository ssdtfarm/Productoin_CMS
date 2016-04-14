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
import com.sinosoft.lis.db.LAFinanceDataDB;

/*
 * <p>ClassName: LAFinanceDataSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAFinanceDataSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAFinanceDataSchema.class);
	// @Field
	/** Indexcalno */
	private String IndexCalNo;
	/** Transdate */
	private Date TransDate;
	/** Managecom */
	private String ManageCom;
	/** Reportcode */
	private String ReportCode;
	/** Reportname */
	private String ReportName;
	/** Titlecode */
	private String TitleCode;
	/** Titlename */
	private String TitleName;
	/** Dcflag */
	private String DCFlag;
	/** Amount */
	private double Amount;
	/** B1 */
	private String B1;
	/** B2 */
	private String B2;
	/** B3 */
	private String B3;
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

	public static final int FIELDNUM = 17;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAFinanceDataSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[5];
		pk[0] = "IndexCalNo";
		pk[1] = "TransDate";
		pk[2] = "ManageCom";
		pk[3] = "ReportCode";
		pk[4] = "TitleCode";

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
		LAFinanceDataSchema cloned = (LAFinanceDataSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	/**
	* 年月
	*/
	public String getIndexCalNo()
	{
		return IndexCalNo;
	}
	public void setIndexCalNo(String aIndexCalNo)
	{
		if(aIndexCalNo!=null && aIndexCalNo.length()>6)
			throw new IllegalArgumentException("IndexcalnoIndexCalNo值"+aIndexCalNo+"的长度"+aIndexCalNo.length()+"大于最大值6");
		IndexCalNo = aIndexCalNo;
	}
	/**
	* 日期
	*/
	public String getTransDate()
	{
		if( TransDate != null )
			return fDate.getString(TransDate);
		else
			return null;
	}
	public void setTransDate(Date aTransDate)
	{
		TransDate = aTransDate;
	}
	public void setTransDate(String aTransDate)
	{
		if (aTransDate != null && !aTransDate.equals("") )
		{
			TransDate = fDate.getDate( aTransDate );
		}
		else
			TransDate = null;
	}

	/**
	* 机构
	*/
	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>4)
			throw new IllegalArgumentException("ManagecomManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值4");
		ManageCom = aManageCom;
	}
	/**
	* 财务报表类型
	*/
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
	/**
	* 财务报表名称
	*/
	public String getReportName()
	{
		return ReportName;
	}
	public void setReportName(String aReportName)
	{
		if(aReportName!=null && aReportName.length()>100)
			throw new IllegalArgumentException("ReportnameReportName值"+aReportName+"的长度"+aReportName.length()+"大于最大值100");
		ReportName = aReportName;
	}
	/**
	* 业务奖金/薪资结果编目编码
	*/
	public String getTitleCode()
	{
		return TitleCode;
	}
	public void setTitleCode(String aTitleCode)
	{
		if(aTitleCode!=null && aTitleCode.length()>30)
			throw new IllegalArgumentException("TitlecodeTitleCode值"+aTitleCode+"的长度"+aTitleCode.length()+"大于最大值30");
		TitleCode = aTitleCode;
	}
	/**
	* 业务奖金/薪资结果编目名称
	*/
	public String getTitleName()
	{
		return TitleName;
	}
	public void setTitleName(String aTitleName)
	{
		if(aTitleName!=null && aTitleName.length()>100)
			throw new IllegalArgumentException("TitlenameTitleName值"+aTitleName+"的长度"+aTitleName.length()+"大于最大值100");
		TitleName = aTitleName;
	}
	/**
	* Debit/Credit标志
	*/
	public String getDCFlag()
	{
		return DCFlag;
	}
	public void setDCFlag(String aDCFlag)
	{
		if(aDCFlag!=null && aDCFlag.length()>1)
			throw new IllegalArgumentException("DcflagDCFlag值"+aDCFlag+"的长度"+aDCFlag.length()+"大于最大值1");
		DCFlag = aDCFlag;
	}
	/**
	* 金额
	*/
	public double getAmount()
	{
		return Amount;
	}
	public void setAmount(double aAmount)
	{
		Amount = aAmount;
	}
	public void setAmount(String aAmount)
	{
		if (aAmount != null && !aAmount.equals(""))
		{
			Double tDouble = new Double(aAmount);
			double d = tDouble.doubleValue();
			Amount = d;
		}
	}

	/**
	* 备用1
	*/
	public String getB1()
	{
		return B1;
	}
	public void setB1(String aB1)
	{
		if(aB1!=null && aB1.length()>100)
			throw new IllegalArgumentException("B1B1值"+aB1+"的长度"+aB1.length()+"大于最大值100");
		B1 = aB1;
	}
	/**
	* 备用2
	*/
	public String getB2()
	{
		return B2;
	}
	public void setB2(String aB2)
	{
		if(aB2!=null && aB2.length()>100)
			throw new IllegalArgumentException("B2B2值"+aB2+"的长度"+aB2.length()+"大于最大值100");
		B2 = aB2;
	}
	/**
	* 备用3
	*/
	public String getB3()
	{
		return B3;
	}
	public void setB3(String aB3)
	{
		if(aB3!=null && aB3.length()>100)
			throw new IllegalArgumentException("B3B3值"+aB3+"的长度"+aB3.length()+"大于最大值100");
		B3 = aB3;
	}
	/**
	* Operator
	*/
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>100)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值100");
		Operator = aOperator;
	}
	/**
	* MakeDate
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
	* MakeTime
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
	* ModifyDate
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
	* ModifyTime
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
	* 使用另外一个 LAFinanceDataSchema 对象给 Schema 赋值
	* @param: aLAFinanceDataSchema LAFinanceDataSchema
	**/
	public void setSchema(LAFinanceDataSchema aLAFinanceDataSchema)
	{
		this.IndexCalNo = aLAFinanceDataSchema.getIndexCalNo();
		this.TransDate = fDate.getDate( aLAFinanceDataSchema.getTransDate());
		this.ManageCom = aLAFinanceDataSchema.getManageCom();
		this.ReportCode = aLAFinanceDataSchema.getReportCode();
		this.ReportName = aLAFinanceDataSchema.getReportName();
		this.TitleCode = aLAFinanceDataSchema.getTitleCode();
		this.TitleName = aLAFinanceDataSchema.getTitleName();
		this.DCFlag = aLAFinanceDataSchema.getDCFlag();
		this.Amount = aLAFinanceDataSchema.getAmount();
		this.B1 = aLAFinanceDataSchema.getB1();
		this.B2 = aLAFinanceDataSchema.getB2();
		this.B3 = aLAFinanceDataSchema.getB3();
		this.Operator = aLAFinanceDataSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAFinanceDataSchema.getMakeDate());
		this.MakeTime = aLAFinanceDataSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAFinanceDataSchema.getModifyDate());
		this.ModifyTime = aLAFinanceDataSchema.getModifyTime();
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
			if( rs.getString("IndexCalNo") == null )
				this.IndexCalNo = null;
			else
				this.IndexCalNo = rs.getString("IndexCalNo").trim();

			this.TransDate = rs.getDate("TransDate");
			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("ReportCode") == null )
				this.ReportCode = null;
			else
				this.ReportCode = rs.getString("ReportCode").trim();

			if( rs.getString("ReportName") == null )
				this.ReportName = null;
			else
				this.ReportName = rs.getString("ReportName").trim();

			if( rs.getString("TitleCode") == null )
				this.TitleCode = null;
			else
				this.TitleCode = rs.getString("TitleCode").trim();

			if( rs.getString("TitleName") == null )
				this.TitleName = null;
			else
				this.TitleName = rs.getString("TitleName").trim();

			if( rs.getString("DCFlag") == null )
				this.DCFlag = null;
			else
				this.DCFlag = rs.getString("DCFlag").trim();

			this.Amount = rs.getDouble("Amount");
			if( rs.getString("B1") == null )
				this.B1 = null;
			else
				this.B1 = rs.getString("B1").trim();

			if( rs.getString("B2") == null )
				this.B2 = null;
			else
				this.B2 = rs.getString("B2").trim();

			if( rs.getString("B3") == null )
				this.B3 = null;
			else
				this.B3 = rs.getString("B3").trim();

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
			logger.debug("数据库中的LAFinanceData表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAFinanceDataSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAFinanceDataSchema getSchema()
	{
		LAFinanceDataSchema aLAFinanceDataSchema = new LAFinanceDataSchema();
		aLAFinanceDataSchema.setSchema(this);
		return aLAFinanceDataSchema;
	}

	public LAFinanceDataDB getDB()
	{
		LAFinanceDataDB aDBOper = new LAFinanceDataDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAFinanceData描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(IndexCalNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( TransDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReportCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReportName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TitleCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TitleName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DCFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Amount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(B3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAFinanceData>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			IndexCalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			TransDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2,SysConst.PACKAGESPILTER));
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ReportCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ReportName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			TitleCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			TitleName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			DCFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Amount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,9,SysConst.PACKAGESPILTER))).doubleValue();
			B1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			B2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			B3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAFinanceDataSchema";
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
		if (FCode.equalsIgnoreCase("IndexCalNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexCalNo));
		}
		if (FCode.equalsIgnoreCase("TransDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getTransDate()));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReportCode));
		}
		if (FCode.equalsIgnoreCase("ReportName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReportName));
		}
		if (FCode.equalsIgnoreCase("TitleCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TitleCode));
		}
		if (FCode.equalsIgnoreCase("TitleName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TitleName));
		}
		if (FCode.equalsIgnoreCase("DCFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DCFlag));
		}
		if (FCode.equalsIgnoreCase("Amount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Amount));
		}
		if (FCode.equalsIgnoreCase("B1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B1));
		}
		if (FCode.equalsIgnoreCase("B2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B2));
		}
		if (FCode.equalsIgnoreCase("B3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(B3));
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
				strFieldValue = StrTool.GBKToUnicode(IndexCalNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getTransDate()));
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ReportCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ReportName);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(TitleCode);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(TitleName);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(DCFlag);
				break;
			case 8:
				strFieldValue = String.valueOf(Amount);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(B1);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(B2);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(B3);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 16:
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

		if (FCode.equalsIgnoreCase("IndexCalNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexCalNo = FValue.trim();
			}
			else
				IndexCalNo = null;
		}
		if (FCode.equalsIgnoreCase("TransDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				TransDate = fDate.getDate( FValue );
			}
			else
				TransDate = null;
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ManageCom = FValue.trim();
			}
			else
				ManageCom = null;
		}
		if (FCode.equalsIgnoreCase("ReportCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReportCode = FValue.trim();
			}
			else
				ReportCode = null;
		}
		if (FCode.equalsIgnoreCase("ReportName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReportName = FValue.trim();
			}
			else
				ReportName = null;
		}
		if (FCode.equalsIgnoreCase("TitleCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TitleCode = FValue.trim();
			}
			else
				TitleCode = null;
		}
		if (FCode.equalsIgnoreCase("TitleName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TitleName = FValue.trim();
			}
			else
				TitleName = null;
		}
		if (FCode.equalsIgnoreCase("DCFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DCFlag = FValue.trim();
			}
			else
				DCFlag = null;
		}
		if (FCode.equalsIgnoreCase("Amount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Amount = d;
			}
		}
		if (FCode.equalsIgnoreCase("B1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B1 = FValue.trim();
			}
			else
				B1 = null;
		}
		if (FCode.equalsIgnoreCase("B2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B2 = FValue.trim();
			}
			else
				B2 = null;
		}
		if (FCode.equalsIgnoreCase("B3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				B3 = FValue.trim();
			}
			else
				B3 = null;
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
		LAFinanceDataSchema other = (LAFinanceDataSchema)otherObject;
		return
			IndexCalNo.equals(other.getIndexCalNo())
			&& fDate.getString(TransDate).equals(other.getTransDate())
			&& ManageCom.equals(other.getManageCom())
			&& ReportCode.equals(other.getReportCode())
			&& ReportName.equals(other.getReportName())
			&& TitleCode.equals(other.getTitleCode())
			&& TitleName.equals(other.getTitleName())
			&& DCFlag.equals(other.getDCFlag())
			&& Amount == other.getAmount()
			&& B1.equals(other.getB1())
			&& B2.equals(other.getB2())
			&& B3.equals(other.getB3())
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
		if( strFieldName.equals("IndexCalNo") ) {
			return 0;
		}
		if( strFieldName.equals("TransDate") ) {
			return 1;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 2;
		}
		if( strFieldName.equals("ReportCode") ) {
			return 3;
		}
		if( strFieldName.equals("ReportName") ) {
			return 4;
		}
		if( strFieldName.equals("TitleCode") ) {
			return 5;
		}
		if( strFieldName.equals("TitleName") ) {
			return 6;
		}
		if( strFieldName.equals("DCFlag") ) {
			return 7;
		}
		if( strFieldName.equals("Amount") ) {
			return 8;
		}
		if( strFieldName.equals("B1") ) {
			return 9;
		}
		if( strFieldName.equals("B2") ) {
			return 10;
		}
		if( strFieldName.equals("B3") ) {
			return 11;
		}
		if( strFieldName.equals("Operator") ) {
			return 12;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 13;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 14;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 15;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 16;
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
				strFieldName = "IndexCalNo";
				break;
			case 1:
				strFieldName = "TransDate";
				break;
			case 2:
				strFieldName = "ManageCom";
				break;
			case 3:
				strFieldName = "ReportCode";
				break;
			case 4:
				strFieldName = "ReportName";
				break;
			case 5:
				strFieldName = "TitleCode";
				break;
			case 6:
				strFieldName = "TitleName";
				break;
			case 7:
				strFieldName = "DCFlag";
				break;
			case 8:
				strFieldName = "Amount";
				break;
			case 9:
				strFieldName = "B1";
				break;
			case 10:
				strFieldName = "B2";
				break;
			case 11:
				strFieldName = "B3";
				break;
			case 12:
				strFieldName = "Operator";
				break;
			case 13:
				strFieldName = "MakeDate";
				break;
			case 14:
				strFieldName = "MakeTime";
				break;
			case 15:
				strFieldName = "ModifyDate";
				break;
			case 16:
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
		if( strFieldName.equals("IndexCalNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TransDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReportCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReportName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TitleCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TitleName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DCFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Amount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("B1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("B3") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
