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
import com.sinosoft.lis.db.LARewardPunishBDB;

/*
 * <p>ClassName: LARewardPunishBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LARewardPunishBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LARewardPunishBSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Agentgroup */
	private String AgentGroup;
	/** Managecom */
	private String ManageCom;
	/** Idx */
	private String IDX;
	/** Amount */
	private String Amount;
	/** Donedate */
	private Date DoneDate;
	/** Doneflag */
	private String DoneFlag;
	/** Remarks */
	private String Remarks;
	/** Awardtitle */
	private String AwardTitle;
	/** Awardsource */
	private String AwardSource;
	/** Awardreason */
	private String AwardReason;
	/** Awardtype */
	private String AwardType;
	/** Awardquarter */
	private String AwardQuarter;
	/** Awardyear */
	private String AwardYear;
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
	/** Branchtype */
	private String BranchType;
	/** Operator1 */
	private String Operator1;
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;

	public static final int FIELDNUM = 23;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LARewardPunishBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[3];
		pk[0] = "Operator1";
		pk[1] = "MakeDate1";
		pk[2] = "MakeTime1";

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
		LARewardPunishBSchema cloned = (LARewardPunishBSchema)super.clone();
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
		if(aAgentCode!=null && aAgentCode.length()>20)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值20");
		AgentCode = aAgentCode;
	}
	public String getAgentGroup()
	{
		return AgentGroup;
	}
	public void setAgentGroup(String aAgentGroup)
	{
		if(aAgentGroup!=null && aAgentGroup.length()>20)
			throw new IllegalArgumentException("AgentgroupAgentGroup值"+aAgentGroup+"的长度"+aAgentGroup.length()+"大于最大值20");
		AgentGroup = aAgentGroup;
	}
	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>20)
			throw new IllegalArgumentException("ManagecomManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值20");
		ManageCom = aManageCom;
	}
	public String getIDX()
	{
		return IDX;
	}
	public void setIDX(String aIDX)
	{
		if(aIDX!=null && aIDX.length()>10)
			throw new IllegalArgumentException("IdxIDX值"+aIDX+"的长度"+aIDX.length()+"大于最大值10");
		IDX = aIDX;
	}
	public String getAmount()
	{
		return Amount;
	}
	public void setAmount(String aAmount)
	{
		if(aAmount!=null && aAmount.length()>10)
			throw new IllegalArgumentException("AmountAmount值"+aAmount+"的长度"+aAmount.length()+"大于最大值10");
		Amount = aAmount;
	}
	public String getDoneDate()
	{
		if( DoneDate != null )
			return fDate.getString(DoneDate);
		else
			return null;
	}
	public void setDoneDate(Date aDoneDate)
	{
		DoneDate = aDoneDate;
	}
	public void setDoneDate(String aDoneDate)
	{
		if (aDoneDate != null && !aDoneDate.equals("") )
		{
			DoneDate = fDate.getDate( aDoneDate );
		}
		else
			DoneDate = null;
	}

	public String getDoneFlag()
	{
		return DoneFlag;
	}
	public void setDoneFlag(String aDoneFlag)
	{
		if(aDoneFlag!=null && aDoneFlag.length()>2)
			throw new IllegalArgumentException("DoneflagDoneFlag值"+aDoneFlag+"的长度"+aDoneFlag.length()+"大于最大值2");
		DoneFlag = aDoneFlag;
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
	public String getAwardTitle()
	{
		return AwardTitle;
	}
	public void setAwardTitle(String aAwardTitle)
	{
		if(aAwardTitle!=null && aAwardTitle.length()>20)
			throw new IllegalArgumentException("AwardtitleAwardTitle值"+aAwardTitle+"的长度"+aAwardTitle.length()+"大于最大值20");
		AwardTitle = aAwardTitle;
	}
	public String getAwardSource()
	{
		return AwardSource;
	}
	public void setAwardSource(String aAwardSource)
	{
		if(aAwardSource!=null && aAwardSource.length()>20)
			throw new IllegalArgumentException("AwardsourceAwardSource值"+aAwardSource+"的长度"+aAwardSource.length()+"大于最大值20");
		AwardSource = aAwardSource;
	}
	public String getAwardReason()
	{
		return AwardReason;
	}
	public void setAwardReason(String aAwardReason)
	{
		if(aAwardReason!=null && aAwardReason.length()>100)
			throw new IllegalArgumentException("AwardreasonAwardReason值"+aAwardReason+"的长度"+aAwardReason.length()+"大于最大值100");
		AwardReason = aAwardReason;
	}
	public String getAwardType()
	{
		return AwardType;
	}
	public void setAwardType(String aAwardType)
	{
		if(aAwardType!=null && aAwardType.length()>10)
			throw new IllegalArgumentException("AwardtypeAwardType值"+aAwardType+"的长度"+aAwardType.length()+"大于最大值10");
		AwardType = aAwardType;
	}
	public String getAwardQuarter()
	{
		return AwardQuarter;
	}
	public void setAwardQuarter(String aAwardQuarter)
	{
		if(aAwardQuarter!=null && aAwardQuarter.length()>10)
			throw new IllegalArgumentException("AwardquarterAwardQuarter值"+aAwardQuarter+"的长度"+aAwardQuarter.length()+"大于最大值10");
		AwardQuarter = aAwardQuarter;
	}
	public String getAwardYear()
	{
		return AwardYear;
	}
	public void setAwardYear(String aAwardYear)
	{
		if(aAwardYear!=null && aAwardYear.length()>10)
			throw new IllegalArgumentException("AwardyearAwardYear值"+aAwardYear+"的长度"+aAwardYear.length()+"大于最大值10");
		AwardYear = aAwardYear;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>10)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值10");
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
	public String getOperator1()
	{
		return Operator1;
	}
	public void setOperator1(String aOperator1)
	{
		if(aOperator1!=null && aOperator1.length()>10)
			throw new IllegalArgumentException("Operator1Operator1值"+aOperator1+"的长度"+aOperator1.length()+"大于最大值10");
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
	* 使用另外一个 LARewardPunishBSchema 对象给 Schema 赋值
	* @param: aLARewardPunishBSchema LARewardPunishBSchema
	**/
	public void setSchema(LARewardPunishBSchema aLARewardPunishBSchema)
	{
		this.AgentCode = aLARewardPunishBSchema.getAgentCode();
		this.AgentGroup = aLARewardPunishBSchema.getAgentGroup();
		this.ManageCom = aLARewardPunishBSchema.getManageCom();
		this.IDX = aLARewardPunishBSchema.getIDX();
		this.Amount = aLARewardPunishBSchema.getAmount();
		this.DoneDate = fDate.getDate( aLARewardPunishBSchema.getDoneDate());
		this.DoneFlag = aLARewardPunishBSchema.getDoneFlag();
		this.Remarks = aLARewardPunishBSchema.getRemarks();
		this.AwardTitle = aLARewardPunishBSchema.getAwardTitle();
		this.AwardSource = aLARewardPunishBSchema.getAwardSource();
		this.AwardReason = aLARewardPunishBSchema.getAwardReason();
		this.AwardType = aLARewardPunishBSchema.getAwardType();
		this.AwardQuarter = aLARewardPunishBSchema.getAwardQuarter();
		this.AwardYear = aLARewardPunishBSchema.getAwardYear();
		this.Operator = aLARewardPunishBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLARewardPunishBSchema.getMakeDate());
		this.MakeTime = aLARewardPunishBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLARewardPunishBSchema.getModifyDate());
		this.ModifyTime = aLARewardPunishBSchema.getModifyTime();
		this.BranchType = aLARewardPunishBSchema.getBranchType();
		this.Operator1 = aLARewardPunishBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLARewardPunishBSchema.getMakeDate1());
		this.MakeTime1 = aLARewardPunishBSchema.getMakeTime1();
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

			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("IDX") == null )
				this.IDX = null;
			else
				this.IDX = rs.getString("IDX").trim();

			if( rs.getString("Amount") == null )
				this.Amount = null;
			else
				this.Amount = rs.getString("Amount").trim();

			this.DoneDate = rs.getDate("DoneDate");
			if( rs.getString("DoneFlag") == null )
				this.DoneFlag = null;
			else
				this.DoneFlag = rs.getString("DoneFlag").trim();

			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

			if( rs.getString("AwardTitle") == null )
				this.AwardTitle = null;
			else
				this.AwardTitle = rs.getString("AwardTitle").trim();

			if( rs.getString("AwardSource") == null )
				this.AwardSource = null;
			else
				this.AwardSource = rs.getString("AwardSource").trim();

			if( rs.getString("AwardReason") == null )
				this.AwardReason = null;
			else
				this.AwardReason = rs.getString("AwardReason").trim();

			if( rs.getString("AwardType") == null )
				this.AwardType = null;
			else
				this.AwardType = rs.getString("AwardType").trim();

			if( rs.getString("AwardQuarter") == null )
				this.AwardQuarter = null;
			else
				this.AwardQuarter = rs.getString("AwardQuarter").trim();

			if( rs.getString("AwardYear") == null )
				this.AwardYear = null;
			else
				this.AwardYear = rs.getString("AwardYear").trim();

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

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

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
			logger.debug("数据库中的LARewardPunishB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARewardPunishBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LARewardPunishBSchema getSchema()
	{
		LARewardPunishBSchema aLARewardPunishBSchema = new LARewardPunishBSchema();
		aLARewardPunishBSchema.setSchema(this);
		return aLARewardPunishBSchema;
	}

	public LARewardPunishBDB getDB()
	{
		LARewardPunishBDB aDBOper = new LARewardPunishBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARewardPunishB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IDX)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Amount)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( DoneDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DoneFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardTitle)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardSource)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardQuarter)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardYear)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARewardPunishB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			IDX = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Amount = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			DoneDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			DoneFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			AwardTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			AwardSource = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			AwardReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			AwardType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			AwardQuarter = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			AwardYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARewardPunishBSchema";
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
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("IDX"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDX));
		}
		if (FCode.equalsIgnoreCase("Amount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Amount));
		}
		if (FCode.equalsIgnoreCase("DoneDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getDoneDate()));
		}
		if (FCode.equalsIgnoreCase("DoneFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DoneFlag));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
		}
		if (FCode.equalsIgnoreCase("AwardTitle"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardTitle));
		}
		if (FCode.equalsIgnoreCase("AwardSource"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardSource));
		}
		if (FCode.equalsIgnoreCase("AwardReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardReason));
		}
		if (FCode.equalsIgnoreCase("AwardType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardType));
		}
		if (FCode.equalsIgnoreCase("AwardQuarter"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardQuarter));
		}
		if (FCode.equalsIgnoreCase("AwardYear"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardYear));
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
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
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(IDX);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Amount);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getDoneDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(DoneFlag);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(AwardTitle);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(AwardSource);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(AwardReason);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(AwardType);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(AwardQuarter);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(AwardYear);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 22:
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
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGroup = FValue.trim();
			}
			else
				AgentGroup = null;
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
		if (FCode.equalsIgnoreCase("IDX"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDX = FValue.trim();
			}
			else
				IDX = null;
		}
		if (FCode.equalsIgnoreCase("Amount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Amount = FValue.trim();
			}
			else
				Amount = null;
		}
		if (FCode.equalsIgnoreCase("DoneDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				DoneDate = fDate.getDate( FValue );
			}
			else
				DoneDate = null;
		}
		if (FCode.equalsIgnoreCase("DoneFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DoneFlag = FValue.trim();
			}
			else
				DoneFlag = null;
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
		if (FCode.equalsIgnoreCase("AwardTitle"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AwardTitle = FValue.trim();
			}
			else
				AwardTitle = null;
		}
		if (FCode.equalsIgnoreCase("AwardSource"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AwardSource = FValue.trim();
			}
			else
				AwardSource = null;
		}
		if (FCode.equalsIgnoreCase("AwardReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AwardReason = FValue.trim();
			}
			else
				AwardReason = null;
		}
		if (FCode.equalsIgnoreCase("AwardType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AwardType = FValue.trim();
			}
			else
				AwardType = null;
		}
		if (FCode.equalsIgnoreCase("AwardQuarter"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AwardQuarter = FValue.trim();
			}
			else
				AwardQuarter = null;
		}
		if (FCode.equalsIgnoreCase("AwardYear"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AwardYear = FValue.trim();
			}
			else
				AwardYear = null;
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
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
		LARewardPunishBSchema other = (LARewardPunishBSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& AgentGroup.equals(other.getAgentGroup())
			&& ManageCom.equals(other.getManageCom())
			&& IDX.equals(other.getIDX())
			&& Amount.equals(other.getAmount())
			&& fDate.getString(DoneDate).equals(other.getDoneDate())
			&& DoneFlag.equals(other.getDoneFlag())
			&& Remarks.equals(other.getRemarks())
			&& AwardTitle.equals(other.getAwardTitle())
			&& AwardSource.equals(other.getAwardSource())
			&& AwardReason.equals(other.getAwardReason())
			&& AwardType.equals(other.getAwardType())
			&& AwardQuarter.equals(other.getAwardQuarter())
			&& AwardYear.equals(other.getAwardYear())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& BranchType.equals(other.getBranchType())
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
		if( strFieldName.equals("AgentGroup") ) {
			return 1;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 2;
		}
		if( strFieldName.equals("IDX") ) {
			return 3;
		}
		if( strFieldName.equals("Amount") ) {
			return 4;
		}
		if( strFieldName.equals("DoneDate") ) {
			return 5;
		}
		if( strFieldName.equals("DoneFlag") ) {
			return 6;
		}
		if( strFieldName.equals("Remarks") ) {
			return 7;
		}
		if( strFieldName.equals("AwardTitle") ) {
			return 8;
		}
		if( strFieldName.equals("AwardSource") ) {
			return 9;
		}
		if( strFieldName.equals("AwardReason") ) {
			return 10;
		}
		if( strFieldName.equals("AwardType") ) {
			return 11;
		}
		if( strFieldName.equals("AwardQuarter") ) {
			return 12;
		}
		if( strFieldName.equals("AwardYear") ) {
			return 13;
		}
		if( strFieldName.equals("Operator") ) {
			return 14;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 15;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 16;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 17;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 18;
		}
		if( strFieldName.equals("BranchType") ) {
			return 19;
		}
		if( strFieldName.equals("Operator1") ) {
			return 20;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 21;
		}
		if( strFieldName.equals("MakeTime1") ) {
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
				strFieldName = "AgentGroup";
				break;
			case 2:
				strFieldName = "ManageCom";
				break;
			case 3:
				strFieldName = "IDX";
				break;
			case 4:
				strFieldName = "Amount";
				break;
			case 5:
				strFieldName = "DoneDate";
				break;
			case 6:
				strFieldName = "DoneFlag";
				break;
			case 7:
				strFieldName = "Remarks";
				break;
			case 8:
				strFieldName = "AwardTitle";
				break;
			case 9:
				strFieldName = "AwardSource";
				break;
			case 10:
				strFieldName = "AwardReason";
				break;
			case 11:
				strFieldName = "AwardType";
				break;
			case 12:
				strFieldName = "AwardQuarter";
				break;
			case 13:
				strFieldName = "AwardYear";
				break;
			case 14:
				strFieldName = "Operator";
				break;
			case 15:
				strFieldName = "MakeDate";
				break;
			case 16:
				strFieldName = "MakeTime";
				break;
			case 17:
				strFieldName = "ModifyDate";
				break;
			case 18:
				strFieldName = "ModifyTime";
				break;
			case 19:
				strFieldName = "BranchType";
				break;
			case 20:
				strFieldName = "Operator1";
				break;
			case 21:
				strFieldName = "MakeDate1";
				break;
			case 22:
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
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IDX") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Amount") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DoneDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("DoneFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remarks") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardTitle") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardSource") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardQuarter") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardYear") ) {
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
		if( strFieldName.equals("BranchType") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 17:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 18:
				nFieldType = Schema.TYPE_STRING;
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
