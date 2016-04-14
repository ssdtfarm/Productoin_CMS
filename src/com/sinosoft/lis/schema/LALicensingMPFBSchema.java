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
import com.sinosoft.lis.db.LALicensingMPFBDB;

/*
 * <p>ClassName: LALicensingMPFBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LALicensingMPFBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LALicensingMPFBSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Mpfregno */
	private String MPFRegNo;
	/** Mpfregstatus */
	private String MPFRegStatus;
	/** Mpfregdate */
	private Date MPFRegDate;
	/** Mpfderegdate */
	private Date MPFDeregDate;
	/** Remarks */
	private String Remarks;
	/** Flag1 */
	private String Flag1;
	/** Flag2 */
	private String Flag2;
	/** Flag3 */
	private String Flag3;
	/** Hkfibak1 */
	private String HKFIBak1;
	/** Hkfibak2 */
	private String HKFIBak2;
	/** Hkfibak3 */
	private String HKFIBak3;
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

	public static final int FIELDNUM = 20;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LALicensingMPFBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "AgentCode";
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
		LALicensingMPFBSchema cloned = (LALicensingMPFBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>12)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值12");
		AgentCode = aAgentCode;
	}
	public String getMPFRegNo()
	{
		return MPFRegNo;
	}
	public void setMPFRegNo(String aMPFRegNo)
	{
		if(aMPFRegNo!=null && aMPFRegNo.length()>10)
			throw new IllegalArgumentException("MpfregnoMPFRegNo值"+aMPFRegNo+"的长度"+aMPFRegNo.length()+"大于最大值10");
		MPFRegNo = aMPFRegNo;
	}
	public String getMPFRegStatus()
	{
		return MPFRegStatus;
	}
	public void setMPFRegStatus(String aMPFRegStatus)
	{
		if(aMPFRegStatus!=null && aMPFRegStatus.length()>10)
			throw new IllegalArgumentException("MpfregstatusMPFRegStatus值"+aMPFRegStatus+"的长度"+aMPFRegStatus.length()+"大于最大值10");
		MPFRegStatus = aMPFRegStatus;
	}
	public String getMPFRegDate()
	{
		if( MPFRegDate != null )
			return fDate.getString(MPFRegDate);
		else
			return null;
	}
	public void setMPFRegDate(Date aMPFRegDate)
	{
		MPFRegDate = aMPFRegDate;
	}
	public void setMPFRegDate(String aMPFRegDate)
	{
		if (aMPFRegDate != null && !aMPFRegDate.equals("") )
		{
			MPFRegDate = fDate.getDate( aMPFRegDate );
		}
		else
			MPFRegDate = null;
	}

	public String getMPFDeregDate()
	{
		if( MPFDeregDate != null )
			return fDate.getString(MPFDeregDate);
		else
			return null;
	}
	public void setMPFDeregDate(Date aMPFDeregDate)
	{
		MPFDeregDate = aMPFDeregDate;
	}
	public void setMPFDeregDate(String aMPFDeregDate)
	{
		if (aMPFDeregDate != null && !aMPFDeregDate.equals("") )
		{
			MPFDeregDate = fDate.getDate( aMPFDeregDate );
		}
		else
			MPFDeregDate = null;
	}

	public String getRemarks()
	{
		return Remarks;
	}
	public void setRemarks(String aRemarks)
	{
		if(aRemarks!=null && aRemarks.length()>500)
			throw new IllegalArgumentException("RemarksRemarks值"+aRemarks+"的长度"+aRemarks.length()+"大于最大值500");
		Remarks = aRemarks;
	}
	public String getFlag1()
	{
		return Flag1;
	}
	public void setFlag1(String aFlag1)
	{
		if(aFlag1!=null && aFlag1.length()>50)
			throw new IllegalArgumentException("Flag1Flag1值"+aFlag1+"的长度"+aFlag1.length()+"大于最大值50");
		Flag1 = aFlag1;
	}
	public String getFlag2()
	{
		return Flag2;
	}
	public void setFlag2(String aFlag2)
	{
		if(aFlag2!=null && aFlag2.length()>50)
			throw new IllegalArgumentException("Flag2Flag2值"+aFlag2+"的长度"+aFlag2.length()+"大于最大值50");
		Flag2 = aFlag2;
	}
	public String getFlag3()
	{
		return Flag3;
	}
	public void setFlag3(String aFlag3)
	{
		if(aFlag3!=null && aFlag3.length()>50)
			throw new IllegalArgumentException("Flag3Flag3值"+aFlag3+"的长度"+aFlag3.length()+"大于最大值50");
		Flag3 = aFlag3;
	}
	public String getHKFIBak1()
	{
		return HKFIBak1;
	}
	public void setHKFIBak1(String aHKFIBak1)
	{
		if(aHKFIBak1!=null && aHKFIBak1.length()>50)
			throw new IllegalArgumentException("Hkfibak1HKFIBak1值"+aHKFIBak1+"的长度"+aHKFIBak1.length()+"大于最大值50");
		HKFIBak1 = aHKFIBak1;
	}
	public String getHKFIBak2()
	{
		return HKFIBak2;
	}
	public void setHKFIBak2(String aHKFIBak2)
	{
		if(aHKFIBak2!=null && aHKFIBak2.length()>50)
			throw new IllegalArgumentException("Hkfibak2HKFIBak2值"+aHKFIBak2+"的长度"+aHKFIBak2.length()+"大于最大值50");
		HKFIBak2 = aHKFIBak2;
	}
	public String getHKFIBak3()
	{
		return HKFIBak3;
	}
	public void setHKFIBak3(String aHKFIBak3)
	{
		if(aHKFIBak3!=null && aHKFIBak3.length()>50)
			throw new IllegalArgumentException("Hkfibak3HKFIBak3值"+aHKFIBak3+"的长度"+aHKFIBak3.length()+"大于最大值50");
		HKFIBak3 = aHKFIBak3;
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
	* 使用另外一个 LALicensingMPFBSchema 对象给 Schema 赋值
	* @param: aLALicensingMPFBSchema LALicensingMPFBSchema
	**/
	public void setSchema(LALicensingMPFBSchema aLALicensingMPFBSchema)
	{
		this.AgentCode = aLALicensingMPFBSchema.getAgentCode();
		this.MPFRegNo = aLALicensingMPFBSchema.getMPFRegNo();
		this.MPFRegStatus = aLALicensingMPFBSchema.getMPFRegStatus();
		this.MPFRegDate = fDate.getDate( aLALicensingMPFBSchema.getMPFRegDate());
		this.MPFDeregDate = fDate.getDate( aLALicensingMPFBSchema.getMPFDeregDate());
		this.Remarks = aLALicensingMPFBSchema.getRemarks();
		this.Flag1 = aLALicensingMPFBSchema.getFlag1();
		this.Flag2 = aLALicensingMPFBSchema.getFlag2();
		this.Flag3 = aLALicensingMPFBSchema.getFlag3();
		this.HKFIBak1 = aLALicensingMPFBSchema.getHKFIBak1();
		this.HKFIBak2 = aLALicensingMPFBSchema.getHKFIBak2();
		this.HKFIBak3 = aLALicensingMPFBSchema.getHKFIBak3();
		this.Operator = aLALicensingMPFBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLALicensingMPFBSchema.getMakeDate());
		this.MakeTime = aLALicensingMPFBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLALicensingMPFBSchema.getModifyDate());
		this.ModifyTime = aLALicensingMPFBSchema.getModifyTime();
		this.Operator1 = aLALicensingMPFBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLALicensingMPFBSchema.getMakeDate1());
		this.MakeTime1 = aLALicensingMPFBSchema.getMakeTime1();
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
			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("MPFRegNo") == null )
				this.MPFRegNo = null;
			else
				this.MPFRegNo = rs.getString("MPFRegNo").trim();

			if( rs.getString("MPFRegStatus") == null )
				this.MPFRegStatus = null;
			else
				this.MPFRegStatus = rs.getString("MPFRegStatus").trim();

			this.MPFRegDate = rs.getDate("MPFRegDate");
			this.MPFDeregDate = rs.getDate("MPFDeregDate");
			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

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

			if( rs.getString("HKFIBak1") == null )
				this.HKFIBak1 = null;
			else
				this.HKFIBak1 = rs.getString("HKFIBak1").trim();

			if( rs.getString("HKFIBak2") == null )
				this.HKFIBak2 = null;
			else
				this.HKFIBak2 = rs.getString("HKFIBak2").trim();

			if( rs.getString("HKFIBak3") == null )
				this.HKFIBak3 = null;
			else
				this.HKFIBak3 = rs.getString("HKFIBak3").trim();

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
			logger.debug("数据库中的LALicensingMPFB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LALicensingMPFBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LALicensingMPFBSchema getSchema()
	{
		LALicensingMPFBSchema aLALicensingMPFBSchema = new LALicensingMPFBSchema();
		aLALicensingMPFBSchema.setSchema(this);
		return aLALicensingMPFBSchema;
	}

	public LALicensingMPFBDB getDB()
	{
		LALicensingMPFBDB aDBOper = new LALicensingMPFBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLALicensingMPFB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MPFRegNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MPFRegStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MPFRegDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MPFDeregDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKFIBak1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKFIBak2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKFIBak3)); strReturn.append(SysConst.PACKAGESPILTER);
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
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLALicensingMPFB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			MPFRegNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			MPFRegStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			MPFRegDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,SysConst.PACKAGESPILTER));
			MPFDeregDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5,SysConst.PACKAGESPILTER));
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			HKFIBak1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			HKFIBak2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			HKFIBak3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LALicensingMPFBSchema";
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
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("MPFRegNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MPFRegNo));
		}
		if (FCode.equalsIgnoreCase("MPFRegStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MPFRegStatus));
		}
		if (FCode.equalsIgnoreCase("MPFRegDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMPFRegDate()));
		}
		if (FCode.equalsIgnoreCase("MPFDeregDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMPFDeregDate()));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
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
		if (FCode.equalsIgnoreCase("HKFIBak1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKFIBak1));
		}
		if (FCode.equalsIgnoreCase("HKFIBak2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKFIBak2));
		}
		if (FCode.equalsIgnoreCase("HKFIBak3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKFIBak3));
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
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(MPFRegNo);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(MPFRegStatus);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMPFRegDate()));
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMPFDeregDate()));
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
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
				strFieldValue = StrTool.GBKToUnicode(HKFIBak1);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(HKFIBak2);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(HKFIBak3);
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
			case 17:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 19:
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

		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("MPFRegNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MPFRegNo = FValue.trim();
			}
			else
				MPFRegNo = null;
		}
		if (FCode.equalsIgnoreCase("MPFRegStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MPFRegStatus = FValue.trim();
			}
			else
				MPFRegStatus = null;
		}
		if (FCode.equalsIgnoreCase("MPFRegDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MPFRegDate = fDate.getDate( FValue );
			}
			else
				MPFRegDate = null;
		}
		if (FCode.equalsIgnoreCase("MPFDeregDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MPFDeregDate = fDate.getDate( FValue );
			}
			else
				MPFDeregDate = null;
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Remarks = FValue.trim();
			}
			else
				Remarks = null;
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
		if (FCode.equalsIgnoreCase("HKFIBak1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKFIBak1 = FValue.trim();
			}
			else
				HKFIBak1 = null;
		}
		if (FCode.equalsIgnoreCase("HKFIBak2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKFIBak2 = FValue.trim();
			}
			else
				HKFIBak2 = null;
		}
		if (FCode.equalsIgnoreCase("HKFIBak3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKFIBak3 = FValue.trim();
			}
			else
				HKFIBak3 = null;
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
		LALicensingMPFBSchema other = (LALicensingMPFBSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& MPFRegNo.equals(other.getMPFRegNo())
			&& MPFRegStatus.equals(other.getMPFRegStatus())
			&& fDate.getString(MPFRegDate).equals(other.getMPFRegDate())
			&& fDate.getString(MPFDeregDate).equals(other.getMPFDeregDate())
			&& Remarks.equals(other.getRemarks())
			&& Flag1.equals(other.getFlag1())
			&& Flag2.equals(other.getFlag2())
			&& Flag3.equals(other.getFlag3())
			&& HKFIBak1.equals(other.getHKFIBak1())
			&& HKFIBak2.equals(other.getHKFIBak2())
			&& HKFIBak3.equals(other.getHKFIBak3())
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
		if( strFieldName.equals("AgentCode") ) {
			return 0;
		}
		if( strFieldName.equals("MPFRegNo") ) {
			return 1;
		}
		if( strFieldName.equals("MPFRegStatus") ) {
			return 2;
		}
		if( strFieldName.equals("MPFRegDate") ) {
			return 3;
		}
		if( strFieldName.equals("MPFDeregDate") ) {
			return 4;
		}
		if( strFieldName.equals("Remarks") ) {
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
		if( strFieldName.equals("HKFIBak1") ) {
			return 9;
		}
		if( strFieldName.equals("HKFIBak2") ) {
			return 10;
		}
		if( strFieldName.equals("HKFIBak3") ) {
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
		if( strFieldName.equals("Operator1") ) {
			return 17;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 18;
		}
		if( strFieldName.equals("MakeTime1") ) {
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
				strFieldName = "AgentCode";
				break;
			case 1:
				strFieldName = "MPFRegNo";
				break;
			case 2:
				strFieldName = "MPFRegStatus";
				break;
			case 3:
				strFieldName = "MPFRegDate";
				break;
			case 4:
				strFieldName = "MPFDeregDate";
				break;
			case 5:
				strFieldName = "Remarks";
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
				strFieldName = "HKFIBak1";
				break;
			case 10:
				strFieldName = "HKFIBak2";
				break;
			case 11:
				strFieldName = "HKFIBak3";
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
			case 17:
				strFieldName = "Operator1";
				break;
			case 18:
				strFieldName = "MakeDate1";
				break;
			case 19:
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
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MPFRegNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MPFRegStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MPFRegDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MPFDeregDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Remarks") ) {
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
		if( strFieldName.equals("HKFIBak1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKFIBak2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKFIBak3") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 4:
				nFieldType = Schema.TYPE_DATE;
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
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_DATE;
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
