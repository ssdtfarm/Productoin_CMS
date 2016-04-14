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
import com.sinosoft.lis.db.LALicensingHKFIDB;

/*
 * <p>ClassName: LALicensingHKFISchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LALicensingHKFISchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LALicensingHKFISchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Hkfiregno */
	private String HKFIRegNo;
	/** Hkfilineofbusiness */
	private String HKFILineofBusiness;
	/** Hkhiregdate */
	private Date HKHIRegDate;
	/** Hkfiregstatus */
	private String HKFIRegStatus;
	/** Hkfilltregdate */
	private Date HKFILLTRegDate;
	/** Hkfilltregderegdate */
	private Date HKFILLTRegDeregDate;
	/** Hkfigiregdate */
	private Date HKFIGIRegDate;
	/** Hkfigiregderegdate */
	private Date HKFIGIRegDeregDate;
	/** Hkfiregexpdate */
	private Date HKFIRegExpDate;
	/** Hkfideregdate */
	private Date HKFIDeregDate;
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

	public static final int FIELDNUM = 23;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LALicensingHKFISchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "AgentCode";

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
		LALicensingHKFISchema cloned = (LALicensingHKFISchema)super.clone();
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
	public String getHKFIRegNo()
	{
		return HKFIRegNo;
	}
	public void setHKFIRegNo(String aHKFIRegNo)
	{
		if(aHKFIRegNo!=null && aHKFIRegNo.length()>10)
			throw new IllegalArgumentException("HkfiregnoHKFIRegNo值"+aHKFIRegNo+"的长度"+aHKFIRegNo.length()+"大于最大值10");
		HKFIRegNo = aHKFIRegNo;
	}
	public String getHKFILineofBusiness()
	{
		return HKFILineofBusiness;
	}
	public void setHKFILineofBusiness(String aHKFILineofBusiness)
	{
		if(aHKFILineofBusiness!=null && aHKFILineofBusiness.length()>10)
			throw new IllegalArgumentException("HkfilineofbusinessHKFILineofBusiness值"+aHKFILineofBusiness+"的长度"+aHKFILineofBusiness.length()+"大于最大值10");
		HKFILineofBusiness = aHKFILineofBusiness;
	}
	public String getHKHIRegDate()
	{
		if( HKHIRegDate != null )
			return fDate.getString(HKHIRegDate);
		else
			return null;
	}
	public void setHKHIRegDate(Date aHKHIRegDate)
	{
		HKHIRegDate = aHKHIRegDate;
	}
	public void setHKHIRegDate(String aHKHIRegDate)
	{
		if (aHKHIRegDate != null && !aHKHIRegDate.equals("") )
		{
			HKHIRegDate = fDate.getDate( aHKHIRegDate );
		}
		else
			HKHIRegDate = null;
	}

	public String getHKFIRegStatus()
	{
		return HKFIRegStatus;
	}
	public void setHKFIRegStatus(String aHKFIRegStatus)
	{
		if(aHKFIRegStatus!=null && aHKFIRegStatus.length()>10)
			throw new IllegalArgumentException("HkfiregstatusHKFIRegStatus值"+aHKFIRegStatus+"的长度"+aHKFIRegStatus.length()+"大于最大值10");
		HKFIRegStatus = aHKFIRegStatus;
	}
	public String getHKFILLTRegDate()
	{
		if( HKFILLTRegDate != null )
			return fDate.getString(HKFILLTRegDate);
		else
			return null;
	}
	public void setHKFILLTRegDate(Date aHKFILLTRegDate)
	{
		HKFILLTRegDate = aHKFILLTRegDate;
	}
	public void setHKFILLTRegDate(String aHKFILLTRegDate)
	{
		if (aHKFILLTRegDate != null && !aHKFILLTRegDate.equals("") )
		{
			HKFILLTRegDate = fDate.getDate( aHKFILLTRegDate );
		}
		else
			HKFILLTRegDate = null;
	}

	public String getHKFILLTRegDeregDate()
	{
		if( HKFILLTRegDeregDate != null )
			return fDate.getString(HKFILLTRegDeregDate);
		else
			return null;
	}
	public void setHKFILLTRegDeregDate(Date aHKFILLTRegDeregDate)
	{
		HKFILLTRegDeregDate = aHKFILLTRegDeregDate;
	}
	public void setHKFILLTRegDeregDate(String aHKFILLTRegDeregDate)
	{
		if (aHKFILLTRegDeregDate != null && !aHKFILLTRegDeregDate.equals("") )
		{
			HKFILLTRegDeregDate = fDate.getDate( aHKFILLTRegDeregDate );
		}
		else
			HKFILLTRegDeregDate = null;
	}

	public String getHKFIGIRegDate()
	{
		if( HKFIGIRegDate != null )
			return fDate.getString(HKFIGIRegDate);
		else
			return null;
	}
	public void setHKFIGIRegDate(Date aHKFIGIRegDate)
	{
		HKFIGIRegDate = aHKFIGIRegDate;
	}
	public void setHKFIGIRegDate(String aHKFIGIRegDate)
	{
		if (aHKFIGIRegDate != null && !aHKFIGIRegDate.equals("") )
		{
			HKFIGIRegDate = fDate.getDate( aHKFIGIRegDate );
		}
		else
			HKFIGIRegDate = null;
	}

	public String getHKFIGIRegDeregDate()
	{
		if( HKFIGIRegDeregDate != null )
			return fDate.getString(HKFIGIRegDeregDate);
		else
			return null;
	}
	public void setHKFIGIRegDeregDate(Date aHKFIGIRegDeregDate)
	{
		HKFIGIRegDeregDate = aHKFIGIRegDeregDate;
	}
	public void setHKFIGIRegDeregDate(String aHKFIGIRegDeregDate)
	{
		if (aHKFIGIRegDeregDate != null && !aHKFIGIRegDeregDate.equals("") )
		{
			HKFIGIRegDeregDate = fDate.getDate( aHKFIGIRegDeregDate );
		}
		else
			HKFIGIRegDeregDate = null;
	}

	public String getHKFIRegExpDate()
	{
		if( HKFIRegExpDate != null )
			return fDate.getString(HKFIRegExpDate);
		else
			return null;
	}
	public void setHKFIRegExpDate(Date aHKFIRegExpDate)
	{
		HKFIRegExpDate = aHKFIRegExpDate;
	}
	public void setHKFIRegExpDate(String aHKFIRegExpDate)
	{
		if (aHKFIRegExpDate != null && !aHKFIRegExpDate.equals("") )
		{
			HKFIRegExpDate = fDate.getDate( aHKFIRegExpDate );
		}
		else
			HKFIRegExpDate = null;
	}

	public String getHKFIDeregDate()
	{
		if( HKFIDeregDate != null )
			return fDate.getString(HKFIDeregDate);
		else
			return null;
	}
	public void setHKFIDeregDate(Date aHKFIDeregDate)
	{
		HKFIDeregDate = aHKFIDeregDate;
	}
	public void setHKFIDeregDate(String aHKFIDeregDate)
	{
		if (aHKFIDeregDate != null && !aHKFIDeregDate.equals("") )
		{
			HKFIDeregDate = fDate.getDate( aHKFIDeregDate );
		}
		else
			HKFIDeregDate = null;
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

	/**
	* 使用另外一个 LALicensingHKFISchema 对象给 Schema 赋值
	* @param: aLALicensingHKFISchema LALicensingHKFISchema
	**/
	public void setSchema(LALicensingHKFISchema aLALicensingHKFISchema)
	{
		this.AgentCode = aLALicensingHKFISchema.getAgentCode();
		this.HKFIRegNo = aLALicensingHKFISchema.getHKFIRegNo();
		this.HKFILineofBusiness = aLALicensingHKFISchema.getHKFILineofBusiness();
		this.HKHIRegDate = fDate.getDate( aLALicensingHKFISchema.getHKHIRegDate());
		this.HKFIRegStatus = aLALicensingHKFISchema.getHKFIRegStatus();
		this.HKFILLTRegDate = fDate.getDate( aLALicensingHKFISchema.getHKFILLTRegDate());
		this.HKFILLTRegDeregDate = fDate.getDate( aLALicensingHKFISchema.getHKFILLTRegDeregDate());
		this.HKFIGIRegDate = fDate.getDate( aLALicensingHKFISchema.getHKFIGIRegDate());
		this.HKFIGIRegDeregDate = fDate.getDate( aLALicensingHKFISchema.getHKFIGIRegDeregDate());
		this.HKFIRegExpDate = fDate.getDate( aLALicensingHKFISchema.getHKFIRegExpDate());
		this.HKFIDeregDate = fDate.getDate( aLALicensingHKFISchema.getHKFIDeregDate());
		this.Remarks = aLALicensingHKFISchema.getRemarks();
		this.Flag1 = aLALicensingHKFISchema.getFlag1();
		this.Flag2 = aLALicensingHKFISchema.getFlag2();
		this.Flag3 = aLALicensingHKFISchema.getFlag3();
		this.HKFIBak1 = aLALicensingHKFISchema.getHKFIBak1();
		this.HKFIBak2 = aLALicensingHKFISchema.getHKFIBak2();
		this.HKFIBak3 = aLALicensingHKFISchema.getHKFIBak3();
		this.Operator = aLALicensingHKFISchema.getOperator();
		this.MakeDate = fDate.getDate( aLALicensingHKFISchema.getMakeDate());
		this.MakeTime = aLALicensingHKFISchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLALicensingHKFISchema.getModifyDate());
		this.ModifyTime = aLALicensingHKFISchema.getModifyTime();
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

			if( rs.getString("HKFIRegNo") == null )
				this.HKFIRegNo = null;
			else
				this.HKFIRegNo = rs.getString("HKFIRegNo").trim();

			if( rs.getString("HKFILineofBusiness") == null )
				this.HKFILineofBusiness = null;
			else
				this.HKFILineofBusiness = rs.getString("HKFILineofBusiness").trim();

			this.HKHIRegDate = rs.getDate("HKHIRegDate");
			if( rs.getString("HKFIRegStatus") == null )
				this.HKFIRegStatus = null;
			else
				this.HKFIRegStatus = rs.getString("HKFIRegStatus").trim();

			this.HKFILLTRegDate = rs.getDate("HKFILLTRegDate");
			this.HKFILLTRegDeregDate = rs.getDate("HKFILLTRegDeregDate");
			this.HKFIGIRegDate = rs.getDate("HKFIGIRegDate");
			this.HKFIGIRegDeregDate = rs.getDate("HKFIGIRegDeregDate");
			this.HKFIRegExpDate = rs.getDate("HKFIRegExpDate");
			this.HKFIDeregDate = rs.getDate("HKFIDeregDate");
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

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LALicensingHKFI表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LALicensingHKFISchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LALicensingHKFISchema getSchema()
	{
		LALicensingHKFISchema aLALicensingHKFISchema = new LALicensingHKFISchema();
		aLALicensingHKFISchema.setSchema(this);
		return aLALicensingHKFISchema;
	}

	public LALicensingHKFIDB getDB()
	{
		LALicensingHKFIDB aDBOper = new LALicensingHKFIDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLALicensingHKFI描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKFIRegNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKFILineofBusiness)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( HKHIRegDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKFIRegStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( HKFILLTRegDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( HKFILLTRegDeregDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( HKFIGIRegDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( HKFIGIRegDeregDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( HKFIRegExpDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( HKFIDeregDate ))); strReturn.append(SysConst.PACKAGESPILTER);
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
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLALicensingHKFI>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			HKFIRegNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			HKFILineofBusiness = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			HKHIRegDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,SysConst.PACKAGESPILTER));
			HKFIRegStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			HKFILLTRegDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			HKFILLTRegDeregDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			HKFIGIRegDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			HKFIGIRegDeregDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			HKFIRegExpDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			HKFIDeregDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			HKFIBak1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			HKFIBak2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			HKFIBak3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LALicensingHKFISchema";
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
		if (FCode.equalsIgnoreCase("HKFIRegNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKFIRegNo));
		}
		if (FCode.equalsIgnoreCase("HKFILineofBusiness"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKFILineofBusiness));
		}
		if (FCode.equalsIgnoreCase("HKHIRegDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getHKHIRegDate()));
		}
		if (FCode.equalsIgnoreCase("HKFIRegStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKFIRegStatus));
		}
		if (FCode.equalsIgnoreCase("HKFILLTRegDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getHKFILLTRegDate()));
		}
		if (FCode.equalsIgnoreCase("HKFILLTRegDeregDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getHKFILLTRegDeregDate()));
		}
		if (FCode.equalsIgnoreCase("HKFIGIRegDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getHKFIGIRegDate()));
		}
		if (FCode.equalsIgnoreCase("HKFIGIRegDeregDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getHKFIGIRegDeregDate()));
		}
		if (FCode.equalsIgnoreCase("HKFIRegExpDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getHKFIRegExpDate()));
		}
		if (FCode.equalsIgnoreCase("HKFIDeregDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getHKFIDeregDate()));
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
				strFieldValue = StrTool.GBKToUnicode(HKFIRegNo);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(HKFILineofBusiness);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getHKHIRegDate()));
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(HKFIRegStatus);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getHKFILLTRegDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getHKFILLTRegDeregDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getHKFIGIRegDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getHKFIGIRegDeregDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getHKFIRegExpDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getHKFIDeregDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(Flag1);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Flag2);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Flag3);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(HKFIBak1);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(HKFIBak2);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(HKFIBak3);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 22:
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

		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("HKFIRegNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKFIRegNo = FValue.trim();
			}
			else
				HKFIRegNo = null;
		}
		if (FCode.equalsIgnoreCase("HKFILineofBusiness"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKFILineofBusiness = FValue.trim();
			}
			else
				HKFILineofBusiness = null;
		}
		if (FCode.equalsIgnoreCase("HKHIRegDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				HKHIRegDate = fDate.getDate( FValue );
			}
			else
				HKHIRegDate = null;
		}
		if (FCode.equalsIgnoreCase("HKFIRegStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKFIRegStatus = FValue.trim();
			}
			else
				HKFIRegStatus = null;
		}
		if (FCode.equalsIgnoreCase("HKFILLTRegDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				HKFILLTRegDate = fDate.getDate( FValue );
			}
			else
				HKFILLTRegDate = null;
		}
		if (FCode.equalsIgnoreCase("HKFILLTRegDeregDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				HKFILLTRegDeregDate = fDate.getDate( FValue );
			}
			else
				HKFILLTRegDeregDate = null;
		}
		if (FCode.equalsIgnoreCase("HKFIGIRegDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				HKFIGIRegDate = fDate.getDate( FValue );
			}
			else
				HKFIGIRegDate = null;
		}
		if (FCode.equalsIgnoreCase("HKFIGIRegDeregDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				HKFIGIRegDeregDate = fDate.getDate( FValue );
			}
			else
				HKFIGIRegDeregDate = null;
		}
		if (FCode.equalsIgnoreCase("HKFIRegExpDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				HKFIRegExpDate = fDate.getDate( FValue );
			}
			else
				HKFIRegExpDate = null;
		}
		if (FCode.equalsIgnoreCase("HKFIDeregDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				HKFIDeregDate = fDate.getDate( FValue );
			}
			else
				HKFIDeregDate = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LALicensingHKFISchema other = (LALicensingHKFISchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& HKFIRegNo.equals(other.getHKFIRegNo())
			&& HKFILineofBusiness.equals(other.getHKFILineofBusiness())
			&& fDate.getString(HKHIRegDate).equals(other.getHKHIRegDate())
			&& HKFIRegStatus.equals(other.getHKFIRegStatus())
			&& fDate.getString(HKFILLTRegDate).equals(other.getHKFILLTRegDate())
			&& fDate.getString(HKFILLTRegDeregDate).equals(other.getHKFILLTRegDeregDate())
			&& fDate.getString(HKFIGIRegDate).equals(other.getHKFIGIRegDate())
			&& fDate.getString(HKFIGIRegDeregDate).equals(other.getHKFIGIRegDeregDate())
			&& fDate.getString(HKFIRegExpDate).equals(other.getHKFIRegExpDate())
			&& fDate.getString(HKFIDeregDate).equals(other.getHKFIDeregDate())
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
		if( strFieldName.equals("AgentCode") ) {
			return 0;
		}
		if( strFieldName.equals("HKFIRegNo") ) {
			return 1;
		}
		if( strFieldName.equals("HKFILineofBusiness") ) {
			return 2;
		}
		if( strFieldName.equals("HKHIRegDate") ) {
			return 3;
		}
		if( strFieldName.equals("HKFIRegStatus") ) {
			return 4;
		}
		if( strFieldName.equals("HKFILLTRegDate") ) {
			return 5;
		}
		if( strFieldName.equals("HKFILLTRegDeregDate") ) {
			return 6;
		}
		if( strFieldName.equals("HKFIGIRegDate") ) {
			return 7;
		}
		if( strFieldName.equals("HKFIGIRegDeregDate") ) {
			return 8;
		}
		if( strFieldName.equals("HKFIRegExpDate") ) {
			return 9;
		}
		if( strFieldName.equals("HKFIDeregDate") ) {
			return 10;
		}
		if( strFieldName.equals("Remarks") ) {
			return 11;
		}
		if( strFieldName.equals("Flag1") ) {
			return 12;
		}
		if( strFieldName.equals("Flag2") ) {
			return 13;
		}
		if( strFieldName.equals("Flag3") ) {
			return 14;
		}
		if( strFieldName.equals("HKFIBak1") ) {
			return 15;
		}
		if( strFieldName.equals("HKFIBak2") ) {
			return 16;
		}
		if( strFieldName.equals("HKFIBak3") ) {
			return 17;
		}
		if( strFieldName.equals("Operator") ) {
			return 18;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 19;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 20;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 21;
		}
		if( strFieldName.equals("ModifyTime") ) {
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
				strFieldName = "AgentCode";
				break;
			case 1:
				strFieldName = "HKFIRegNo";
				break;
			case 2:
				strFieldName = "HKFILineofBusiness";
				break;
			case 3:
				strFieldName = "HKHIRegDate";
				break;
			case 4:
				strFieldName = "HKFIRegStatus";
				break;
			case 5:
				strFieldName = "HKFILLTRegDate";
				break;
			case 6:
				strFieldName = "HKFILLTRegDeregDate";
				break;
			case 7:
				strFieldName = "HKFIGIRegDate";
				break;
			case 8:
				strFieldName = "HKFIGIRegDeregDate";
				break;
			case 9:
				strFieldName = "HKFIRegExpDate";
				break;
			case 10:
				strFieldName = "HKFIDeregDate";
				break;
			case 11:
				strFieldName = "Remarks";
				break;
			case 12:
				strFieldName = "Flag1";
				break;
			case 13:
				strFieldName = "Flag2";
				break;
			case 14:
				strFieldName = "Flag3";
				break;
			case 15:
				strFieldName = "HKFIBak1";
				break;
			case 16:
				strFieldName = "HKFIBak2";
				break;
			case 17:
				strFieldName = "HKFIBak3";
				break;
			case 18:
				strFieldName = "Operator";
				break;
			case 19:
				strFieldName = "MakeDate";
				break;
			case 20:
				strFieldName = "MakeTime";
				break;
			case 21:
				strFieldName = "ModifyDate";
				break;
			case 22:
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
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKFIRegNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKFILineofBusiness") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKHIRegDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("HKFIRegStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKFILLTRegDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("HKFILLTRegDeregDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("HKFIGIRegDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("HKFIGIRegDeregDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("HKFIRegExpDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("HKFIDeregDate") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 5:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 6:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 9:
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 19:
				nFieldType = Schema.TYPE_DATE;
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
