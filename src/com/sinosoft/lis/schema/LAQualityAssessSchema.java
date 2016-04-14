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
import com.sinosoft.lis.db.LAQualityAssessDB;

/*
 * <p>ClassName: LAQualityAssessSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAQualityAssessSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAQualityAssessSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Branchtype */
	private String BranchType;
	/** Agentgroup */
	private String AgentGroup;
	/** Idx */
	private String IDX;
	/** Managecom */
	private String ManageCom;
	/** Noncompliancetype */
	private String NonComplianceType;
	/** Source */
	private String Source;
	/** Credit */
	private String Credit;
	/** Remarks */
	private String Remarks;
	/** Rewardpunishtype */
	private String RewardPunishType;
	/** Casedetails */
	private String CaseDetails;
	/** Comment */
	private String Comment;
	/** Donedate */
	private Date DoneDate;
	/** Doneflag */
	private String DoneFlag;
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

	public static final int FIELDNUM = 19;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAQualityAssessSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "AgentCode";
		pk[1] = "IDX";

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
		LAQualityAssessSchema cloned = (LAQualityAssessSchema)super.clone();
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
	public String getNonComplianceType()
	{
		return NonComplianceType;
	}
	public void setNonComplianceType(String aNonComplianceType)
	{
		if(aNonComplianceType!=null && aNonComplianceType.length()>500)
			throw new IllegalArgumentException("NoncompliancetypeNonComplianceType值"+aNonComplianceType+"的长度"+aNonComplianceType.length()+"大于最大值500");
		NonComplianceType = aNonComplianceType;
	}
	public String getSource()
	{
		return Source;
	}
	public void setSource(String aSource)
	{
		if(aSource!=null && aSource.length()>50)
			throw new IllegalArgumentException("SourceSource值"+aSource+"的长度"+aSource.length()+"大于最大值50");
		Source = aSource;
	}
	public String getCredit()
	{
		return Credit;
	}
	public void setCredit(String aCredit)
	{
		if(aCredit!=null && aCredit.length()>50)
			throw new IllegalArgumentException("CreditCredit值"+aCredit+"的长度"+aCredit.length()+"大于最大值50");
		Credit = aCredit;
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
	public String getRewardPunishType()
	{
		return RewardPunishType;
	}
	public void setRewardPunishType(String aRewardPunishType)
	{
		if(aRewardPunishType!=null && aRewardPunishType.length()>50)
			throw new IllegalArgumentException("RewardpunishtypeRewardPunishType值"+aRewardPunishType+"的长度"+aRewardPunishType.length()+"大于最大值50");
		RewardPunishType = aRewardPunishType;
	}
	public String getCaseDetails()
	{
		return CaseDetails;
	}
	public void setCaseDetails(String aCaseDetails)
	{
		if(aCaseDetails!=null && aCaseDetails.length()>100)
			throw new IllegalArgumentException("CasedetailsCaseDetails值"+aCaseDetails+"的长度"+aCaseDetails.length()+"大于最大值100");
		CaseDetails = aCaseDetails;
	}
	public String getComment()
	{
		return Comment;
	}
	public void setComment(String aComment)
	{
		if(aComment!=null && aComment.length()>50)
			throw new IllegalArgumentException("CommentComment值"+aComment+"的长度"+aComment.length()+"大于最大值50");
		Comment = aComment;
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

	/**
	* 使用另外一个 LAQualityAssessSchema 对象给 Schema 赋值
	* @param: aLAQualityAssessSchema LAQualityAssessSchema
	**/
	public void setSchema(LAQualityAssessSchema aLAQualityAssessSchema)
	{
		this.AgentCode = aLAQualityAssessSchema.getAgentCode();
		this.BranchType = aLAQualityAssessSchema.getBranchType();
		this.AgentGroup = aLAQualityAssessSchema.getAgentGroup();
		this.IDX = aLAQualityAssessSchema.getIDX();
		this.ManageCom = aLAQualityAssessSchema.getManageCom();
		this.NonComplianceType = aLAQualityAssessSchema.getNonComplianceType();
		this.Source = aLAQualityAssessSchema.getSource();
		this.Credit = aLAQualityAssessSchema.getCredit();
		this.Remarks = aLAQualityAssessSchema.getRemarks();
		this.RewardPunishType = aLAQualityAssessSchema.getRewardPunishType();
		this.CaseDetails = aLAQualityAssessSchema.getCaseDetails();
		this.Comment = aLAQualityAssessSchema.getComment();
		this.DoneDate = fDate.getDate( aLAQualityAssessSchema.getDoneDate());
		this.DoneFlag = aLAQualityAssessSchema.getDoneFlag();
		this.Operator = aLAQualityAssessSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAQualityAssessSchema.getMakeDate());
		this.MakeTime = aLAQualityAssessSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAQualityAssessSchema.getModifyDate());
		this.ModifyTime = aLAQualityAssessSchema.getModifyTime();
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

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("IDX") == null )
				this.IDX = null;
			else
				this.IDX = rs.getString("IDX").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("NonComplianceType") == null )
				this.NonComplianceType = null;
			else
				this.NonComplianceType = rs.getString("NonComplianceType").trim();

			if( rs.getString("Source") == null )
				this.Source = null;
			else
				this.Source = rs.getString("Source").trim();

			if( rs.getString("Credit") == null )
				this.Credit = null;
			else
				this.Credit = rs.getString("Credit").trim();

			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

			if( rs.getString("RewardPunishType") == null )
				this.RewardPunishType = null;
			else
				this.RewardPunishType = rs.getString("RewardPunishType").trim();

			if( rs.getString("CaseDetails") == null )
				this.CaseDetails = null;
			else
				this.CaseDetails = rs.getString("CaseDetails").trim();

			if( rs.getString("Comment") == null )
				this.Comment = null;
			else
				this.Comment = rs.getString("Comment").trim();

			this.DoneDate = rs.getDate("DoneDate");
			if( rs.getString("DoneFlag") == null )
				this.DoneFlag = null;
			else
				this.DoneFlag = rs.getString("DoneFlag").trim();

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
			logger.debug("数据库中的LAQualityAssess表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAQualityAssessSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAQualityAssessSchema getSchema()
	{
		LAQualityAssessSchema aLAQualityAssessSchema = new LAQualityAssessSchema();
		aLAQualityAssessSchema.setSchema(this);
		return aLAQualityAssessSchema;
	}

	public LAQualityAssessDB getDB()
	{
		LAQualityAssessDB aDBOper = new LAQualityAssessDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAQualityAssess描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IDX)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NonComplianceType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Source)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Credit)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RewardPunishType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CaseDetails)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Comment)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( DoneDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DoneFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAQualityAssess>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			IDX = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			NonComplianceType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Source = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Credit = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			RewardPunishType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			CaseDetails = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Comment = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			DoneDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			DoneFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAQualityAssessSchema";
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("IDX"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDX));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("NonComplianceType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NonComplianceType));
		}
		if (FCode.equalsIgnoreCase("Source"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Source));
		}
		if (FCode.equalsIgnoreCase("Credit"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Credit));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
		}
		if (FCode.equalsIgnoreCase("RewardPunishType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RewardPunishType));
		}
		if (FCode.equalsIgnoreCase("CaseDetails"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CaseDetails));
		}
		if (FCode.equalsIgnoreCase("Comment"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Comment));
		}
		if (FCode.equalsIgnoreCase("DoneDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getDoneDate()));
		}
		if (FCode.equalsIgnoreCase("DoneFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DoneFlag));
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
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(IDX);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(NonComplianceType);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(Source);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Credit);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(RewardPunishType);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(CaseDetails);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Comment);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getDoneDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(DoneFlag);
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
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
		if (FCode.equalsIgnoreCase("IDX"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDX = FValue.trim();
			}
			else
				IDX = null;
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
		if (FCode.equalsIgnoreCase("NonComplianceType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NonComplianceType = FValue.trim();
			}
			else
				NonComplianceType = null;
		}
		if (FCode.equalsIgnoreCase("Source"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Source = FValue.trim();
			}
			else
				Source = null;
		}
		if (FCode.equalsIgnoreCase("Credit"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Credit = FValue.trim();
			}
			else
				Credit = null;
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
		if (FCode.equalsIgnoreCase("RewardPunishType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RewardPunishType = FValue.trim();
			}
			else
				RewardPunishType = null;
		}
		if (FCode.equalsIgnoreCase("CaseDetails"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CaseDetails = FValue.trim();
			}
			else
				CaseDetails = null;
		}
		if (FCode.equalsIgnoreCase("Comment"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Comment = FValue.trim();
			}
			else
				Comment = null;
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
		LAQualityAssessSchema other = (LAQualityAssessSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& BranchType.equals(other.getBranchType())
			&& AgentGroup.equals(other.getAgentGroup())
			&& IDX.equals(other.getIDX())
			&& ManageCom.equals(other.getManageCom())
			&& NonComplianceType.equals(other.getNonComplianceType())
			&& Source.equals(other.getSource())
			&& Credit.equals(other.getCredit())
			&& Remarks.equals(other.getRemarks())
			&& RewardPunishType.equals(other.getRewardPunishType())
			&& CaseDetails.equals(other.getCaseDetails())
			&& Comment.equals(other.getComment())
			&& fDate.getString(DoneDate).equals(other.getDoneDate())
			&& DoneFlag.equals(other.getDoneFlag())
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
		if( strFieldName.equals("BranchType") ) {
			return 1;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 2;
		}
		if( strFieldName.equals("IDX") ) {
			return 3;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 4;
		}
		if( strFieldName.equals("NonComplianceType") ) {
			return 5;
		}
		if( strFieldName.equals("Source") ) {
			return 6;
		}
		if( strFieldName.equals("Credit") ) {
			return 7;
		}
		if( strFieldName.equals("Remarks") ) {
			return 8;
		}
		if( strFieldName.equals("RewardPunishType") ) {
			return 9;
		}
		if( strFieldName.equals("CaseDetails") ) {
			return 10;
		}
		if( strFieldName.equals("Comment") ) {
			return 11;
		}
		if( strFieldName.equals("DoneDate") ) {
			return 12;
		}
		if( strFieldName.equals("DoneFlag") ) {
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
				strFieldName = "BranchType";
				break;
			case 2:
				strFieldName = "AgentGroup";
				break;
			case 3:
				strFieldName = "IDX";
				break;
			case 4:
				strFieldName = "ManageCom";
				break;
			case 5:
				strFieldName = "NonComplianceType";
				break;
			case 6:
				strFieldName = "Source";
				break;
			case 7:
				strFieldName = "Credit";
				break;
			case 8:
				strFieldName = "Remarks";
				break;
			case 9:
				strFieldName = "RewardPunishType";
				break;
			case 10:
				strFieldName = "CaseDetails";
				break;
			case 11:
				strFieldName = "Comment";
				break;
			case 12:
				strFieldName = "DoneDate";
				break;
			case 13:
				strFieldName = "DoneFlag";
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
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IDX") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NonComplianceType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Source") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Credit") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remarks") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RewardPunishType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CaseDetails") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Comment") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DoneDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("DoneFlag") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_DATE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
