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
import com.sinosoft.lis.db.LABranchGroupBDB;

/*
 * <p>ClassName: LABranchGroupBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LABranchGroupBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LABranchGroupBSchema.class);
	// @Field
	/** Agentgroup */
	private String AgentGroup;
	/** Managecom */
	private String ManageCom;
	/** Branchtype */
	private String BranchType;
	/** Branchattr */
	private String BranchAttr;
	/** Branchlevel */
	private String BranchLevel;
	/** Branchname */
	private String BranchName;
	/** Branchnameeng */
	private String BranchNameEng;
	/** Branchnamechi */
	private String BranchNameChi;
	/** Brancheffdate */
	private Date BranchEffDate;
	/** Branchaddress */
	private String BranchAddress;
	/** Branchphoneno */
	private String BranchPhoneNo;
	/** Branchfaxno */
	private String BranchFaxNo;
	/** Branchlocation */
	private String BranchLocation;
	/** Branchstatus */
	private String BranchStatus;
	/** Branchterminateeffdate */
	private Date BranchTerminateEffDate;
	/** Branchterminatereason */
	private String BranchTerminateReason;
	/** Directflag */
	private String DirectFlag;
	/** Upagentgroup */
	private String UpAgentGroup;
	/** Branchmanager */
	private String BranchManager;
	/** Reportingmanager */
	private String ReportingManager;
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

	public static final int FIELDNUM = 28;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LABranchGroupBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "AgentGroup";
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
		LABranchGroupBSchema cloned = (LABranchGroupBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getAgentGroup()
	{
		return AgentGroup;
	}
	public void setAgentGroup(String aAgentGroup)
	{
		if(aAgentGroup!=null && aAgentGroup.length()>10)
			throw new IllegalArgumentException("AgentgroupAgentGroup值"+aAgentGroup+"的长度"+aAgentGroup.length()+"大于最大值10");
		AgentGroup = aAgentGroup;
	}
	/**
	* 管理机构
	*/
	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>10)
			throw new IllegalArgumentException("ManagecomManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值10");
		ManageCom = aManageCom;
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
	* 机构编码
	*/
	public String getBranchAttr()
	{
		return BranchAttr;
	}
	public void setBranchAttr(String aBranchAttr)
	{
		if(aBranchAttr!=null && aBranchAttr.length()>20)
			throw new IllegalArgumentException("BranchattrBranchAttr值"+aBranchAttr+"的长度"+aBranchAttr.length()+"大于最大值20");
		BranchAttr = aBranchAttr;
	}
	/**
	* 机构级别
	*/
	public String getBranchLevel()
	{
		return BranchLevel;
	}
	public void setBranchLevel(String aBranchLevel)
	{
		if(aBranchLevel!=null && aBranchLevel.length()>2)
			throw new IllegalArgumentException("BranchlevelBranchLevel值"+aBranchLevel+"的长度"+aBranchLevel.length()+"大于最大值2");
		BranchLevel = aBranchLevel;
	}
	/**
	* 机构名称
	*/
	public String getBranchName()
	{
		return BranchName;
	}
	public void setBranchName(String aBranchName)
	{
		if(aBranchName!=null && aBranchName.length()>60)
			throw new IllegalArgumentException("BranchnameBranchName值"+aBranchName+"的长度"+aBranchName.length()+"大于最大值60");
		BranchName = aBranchName;
	}
	/**
	* 机构英文名
	*/
	public String getBranchNameEng()
	{
		return BranchNameEng;
	}
	public void setBranchNameEng(String aBranchNameEng)
	{
		if(aBranchNameEng!=null && aBranchNameEng.length()>60)
			throw new IllegalArgumentException("BranchnameengBranchNameEng值"+aBranchNameEng+"的长度"+aBranchNameEng.length()+"大于最大值60");
		BranchNameEng = aBranchNameEng;
	}
	/**
	* 机构中文名
	*/
	public String getBranchNameChi()
	{
		return BranchNameChi;
	}
	public void setBranchNameChi(String aBranchNameChi)
	{
		if(aBranchNameChi!=null && aBranchNameChi.length()>60)
			throw new IllegalArgumentException("BranchnamechiBranchNameChi值"+aBranchNameChi+"的长度"+aBranchNameChi.length()+"大于最大值60");
		BranchNameChi = aBranchNameChi;
	}
	/**
	* 机构建立日期
	*/
	public String getBranchEffDate()
	{
		if( BranchEffDate != null )
			return fDate.getString(BranchEffDate);
		else
			return null;
	}
	public void setBranchEffDate(Date aBranchEffDate)
	{
		BranchEffDate = aBranchEffDate;
	}
	public void setBranchEffDate(String aBranchEffDate)
	{
		if (aBranchEffDate != null && !aBranchEffDate.equals("") )
		{
			BranchEffDate = fDate.getDate( aBranchEffDate );
		}
		else
			BranchEffDate = null;
	}

	/**
	* 机构地址
	*/
	public String getBranchAddress()
	{
		return BranchAddress;
	}
	public void setBranchAddress(String aBranchAddress)
	{
		if(aBranchAddress!=null && aBranchAddress.length()>200)
			throw new IllegalArgumentException("BranchaddressBranchAddress值"+aBranchAddress+"的长度"+aBranchAddress.length()+"大于最大值200");
		BranchAddress = aBranchAddress;
	}
	/**
	* 机构电话
	*/
	public String getBranchPhoneNo()
	{
		return BranchPhoneNo;
	}
	public void setBranchPhoneNo(String aBranchPhoneNo)
	{
		if(aBranchPhoneNo!=null && aBranchPhoneNo.length()>20)
			throw new IllegalArgumentException("BranchphonenoBranchPhoneNo值"+aBranchPhoneNo+"的长度"+aBranchPhoneNo.length()+"大于最大值20");
		BranchPhoneNo = aBranchPhoneNo;
	}
	/**
	* 机构传真
	*/
	public String getBranchFaxNo()
	{
		return BranchFaxNo;
	}
	public void setBranchFaxNo(String aBranchFaxNo)
	{
		if(aBranchFaxNo!=null && aBranchFaxNo.length()>20)
			throw new IllegalArgumentException("BranchfaxnoBranchFaxNo值"+aBranchFaxNo+"的长度"+aBranchFaxNo.length()+"大于最大值20");
		BranchFaxNo = aBranchFaxNo;
	}
	/**
	* 机构位置（？）
	*/
	public String getBranchLocation()
	{
		return BranchLocation;
	}
	public void setBranchLocation(String aBranchLocation)
	{
		if(aBranchLocation!=null && aBranchLocation.length()>200)
			throw new IllegalArgumentException("BranchlocationBranchLocation值"+aBranchLocation+"的长度"+aBranchLocation.length()+"大于最大值200");
		BranchLocation = aBranchLocation;
	}
	/**
	* 机构状态
	*/
	public String getBranchStatus()
	{
		return BranchStatus;
	}
	public void setBranchStatus(String aBranchStatus)
	{
		if(aBranchStatus!=null && aBranchStatus.length()>2)
			throw new IllegalArgumentException("BranchstatusBranchStatus值"+aBranchStatus+"的长度"+aBranchStatus.length()+"大于最大值2");
		BranchStatus = aBranchStatus;
	}
	/**
	* 机构停业日期
	*/
	public String getBranchTerminateEffDate()
	{
		if( BranchTerminateEffDate != null )
			return fDate.getString(BranchTerminateEffDate);
		else
			return null;
	}
	public void setBranchTerminateEffDate(Date aBranchTerminateEffDate)
	{
		BranchTerminateEffDate = aBranchTerminateEffDate;
	}
	public void setBranchTerminateEffDate(String aBranchTerminateEffDate)
	{
		if (aBranchTerminateEffDate != null && !aBranchTerminateEffDate.equals("") )
		{
			BranchTerminateEffDate = fDate.getDate( aBranchTerminateEffDate );
		}
		else
			BranchTerminateEffDate = null;
	}

	/**
	* 机构停业原因
	*/
	public String getBranchTerminateReason()
	{
		return BranchTerminateReason;
	}
	public void setBranchTerminateReason(String aBranchTerminateReason)
	{
		if(aBranchTerminateReason!=null && aBranchTerminateReason.length()>500)
			throw new IllegalArgumentException("BranchterminatereasonBranchTerminateReason值"+aBranchTerminateReason+"的长度"+aBranchTerminateReason.length()+"大于最大值500");
		BranchTerminateReason = aBranchTerminateReason;
	}
	/**
	* 直辖标志
	*/
	public String getDirectFlag()
	{
		return DirectFlag;
	}
	public void setDirectFlag(String aDirectFlag)
	{
		if(aDirectFlag!=null && aDirectFlag.length()>2)
			throw new IllegalArgumentException("DirectflagDirectFlag值"+aDirectFlag+"的长度"+aDirectFlag.length()+"大于最大值2");
		DirectFlag = aDirectFlag;
	}
	/**
	* 上级机构编码【预留】
	*/
	public String getUpAgentGroup()
	{
		return UpAgentGroup;
	}
	public void setUpAgentGroup(String aUpAgentGroup)
	{
		if(aUpAgentGroup!=null && aUpAgentGroup.length()>10)
			throw new IllegalArgumentException("UpagentgroupUpAgentGroup值"+aUpAgentGroup+"的长度"+aUpAgentGroup.length()+"大于最大值10");
		UpAgentGroup = aUpAgentGroup;
	}
	/**
	* 机构管理者编码【预留】
	*/
	public String getBranchManager()
	{
		return BranchManager;
	}
	public void setBranchManager(String aBranchManager)
	{
		if(aBranchManager!=null && aBranchManager.length()>12)
			throw new IllegalArgumentException("BranchmanagerBranchManager值"+aBranchManager+"的长度"+aBranchManager.length()+"大于最大值12");
		BranchManager = aBranchManager;
	}
	/**
	* 机构汇报者编码【预留】
	*/
	public String getReportingManager()
	{
		return ReportingManager;
	}
	public void setReportingManager(String aReportingManager)
	{
		if(aReportingManager!=null && aReportingManager.length()>12)
			throw new IllegalArgumentException("ReportingmanagerReportingManager值"+aReportingManager+"的长度"+aReportingManager.length()+"大于最大值12");
		ReportingManager = aReportingManager;
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
		if(aOperator!=null && aOperator.length()>60)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值60");
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
	* Operator1
	*/
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
	* MakeDate1
	*/
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

	/**
	* MakeTime1
	*/
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
	* 使用另外一个 LABranchGroupBSchema 对象给 Schema 赋值
	* @param: aLABranchGroupBSchema LABranchGroupBSchema
	**/
	public void setSchema(LABranchGroupBSchema aLABranchGroupBSchema)
	{
		this.AgentGroup = aLABranchGroupBSchema.getAgentGroup();
		this.ManageCom = aLABranchGroupBSchema.getManageCom();
		this.BranchType = aLABranchGroupBSchema.getBranchType();
		this.BranchAttr = aLABranchGroupBSchema.getBranchAttr();
		this.BranchLevel = aLABranchGroupBSchema.getBranchLevel();
		this.BranchName = aLABranchGroupBSchema.getBranchName();
		this.BranchNameEng = aLABranchGroupBSchema.getBranchNameEng();
		this.BranchNameChi = aLABranchGroupBSchema.getBranchNameChi();
		this.BranchEffDate = fDate.getDate( aLABranchGroupBSchema.getBranchEffDate());
		this.BranchAddress = aLABranchGroupBSchema.getBranchAddress();
		this.BranchPhoneNo = aLABranchGroupBSchema.getBranchPhoneNo();
		this.BranchFaxNo = aLABranchGroupBSchema.getBranchFaxNo();
		this.BranchLocation = aLABranchGroupBSchema.getBranchLocation();
		this.BranchStatus = aLABranchGroupBSchema.getBranchStatus();
		this.BranchTerminateEffDate = fDate.getDate( aLABranchGroupBSchema.getBranchTerminateEffDate());
		this.BranchTerminateReason = aLABranchGroupBSchema.getBranchTerminateReason();
		this.DirectFlag = aLABranchGroupBSchema.getDirectFlag();
		this.UpAgentGroup = aLABranchGroupBSchema.getUpAgentGroup();
		this.BranchManager = aLABranchGroupBSchema.getBranchManager();
		this.ReportingManager = aLABranchGroupBSchema.getReportingManager();
		this.Operator = aLABranchGroupBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLABranchGroupBSchema.getMakeDate());
		this.MakeTime = aLABranchGroupBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLABranchGroupBSchema.getModifyDate());
		this.ModifyTime = aLABranchGroupBSchema.getModifyTime();
		this.Operator1 = aLABranchGroupBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLABranchGroupBSchema.getMakeDate1());
		this.MakeTime1 = aLABranchGroupBSchema.getMakeTime1();
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
			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("BranchAttr") == null )
				this.BranchAttr = null;
			else
				this.BranchAttr = rs.getString("BranchAttr").trim();

			if( rs.getString("BranchLevel") == null )
				this.BranchLevel = null;
			else
				this.BranchLevel = rs.getString("BranchLevel").trim();

			if( rs.getString("BranchName") == null )
				this.BranchName = null;
			else
				this.BranchName = rs.getString("BranchName").trim();

			if( rs.getString("BranchNameEng") == null )
				this.BranchNameEng = null;
			else
				this.BranchNameEng = rs.getString("BranchNameEng").trim();

			if( rs.getString("BranchNameChi") == null )
				this.BranchNameChi = null;
			else
				this.BranchNameChi = rs.getString("BranchNameChi").trim();

			this.BranchEffDate = rs.getDate("BranchEffDate");
			if( rs.getString("BranchAddress") == null )
				this.BranchAddress = null;
			else
				this.BranchAddress = rs.getString("BranchAddress").trim();

			if( rs.getString("BranchPhoneNo") == null )
				this.BranchPhoneNo = null;
			else
				this.BranchPhoneNo = rs.getString("BranchPhoneNo").trim();

			if( rs.getString("BranchFaxNo") == null )
				this.BranchFaxNo = null;
			else
				this.BranchFaxNo = rs.getString("BranchFaxNo").trim();

			if( rs.getString("BranchLocation") == null )
				this.BranchLocation = null;
			else
				this.BranchLocation = rs.getString("BranchLocation").trim();

			if( rs.getString("BranchStatus") == null )
				this.BranchStatus = null;
			else
				this.BranchStatus = rs.getString("BranchStatus").trim();

			this.BranchTerminateEffDate = rs.getDate("BranchTerminateEffDate");
			if( rs.getString("BranchTerminateReason") == null )
				this.BranchTerminateReason = null;
			else
				this.BranchTerminateReason = rs.getString("BranchTerminateReason").trim();

			if( rs.getString("DirectFlag") == null )
				this.DirectFlag = null;
			else
				this.DirectFlag = rs.getString("DirectFlag").trim();

			if( rs.getString("UpAgentGroup") == null )
				this.UpAgentGroup = null;
			else
				this.UpAgentGroup = rs.getString("UpAgentGroup").trim();

			if( rs.getString("BranchManager") == null )
				this.BranchManager = null;
			else
				this.BranchManager = rs.getString("BranchManager").trim();

			if( rs.getString("ReportingManager") == null )
				this.ReportingManager = null;
			else
				this.ReportingManager = rs.getString("ReportingManager").trim();

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
			logger.debug("数据库中的LABranchGroupB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LABranchGroupBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LABranchGroupBSchema getSchema()
	{
		LABranchGroupBSchema aLABranchGroupBSchema = new LABranchGroupBSchema();
		aLABranchGroupBSchema.setSchema(this);
		return aLABranchGroupBSchema;
	}

	public LABranchGroupBDB getDB()
	{
		LABranchGroupBDB aDBOper = new LABranchGroupBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLABranchGroupB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchLevel)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchNameEng)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchNameChi)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BranchEffDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAddress)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchPhoneNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchFaxNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchLocation)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BranchTerminateEffDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchTerminateReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DirectFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UpAgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchManager)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReportingManager)); strReturn.append(SysConst.PACKAGESPILTER);
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
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLABranchGroupB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			BranchLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			BranchName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			BranchNameEng = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			BranchNameChi = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			BranchEffDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			BranchAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			BranchPhoneNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			BranchFaxNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			BranchLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			BranchStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			BranchTerminateEffDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			BranchTerminateReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			DirectFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			UpAgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			BranchManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			ReportingManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LABranchGroupBSchema";
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
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAttr));
		}
		if (FCode.equalsIgnoreCase("BranchLevel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchLevel));
		}
		if (FCode.equalsIgnoreCase("BranchName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchName));
		}
		if (FCode.equalsIgnoreCase("BranchNameEng"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchNameEng));
		}
		if (FCode.equalsIgnoreCase("BranchNameChi"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchNameChi));
		}
		if (FCode.equalsIgnoreCase("BranchEffDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBranchEffDate()));
		}
		if (FCode.equalsIgnoreCase("BranchAddress"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAddress));
		}
		if (FCode.equalsIgnoreCase("BranchPhoneNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchPhoneNo));
		}
		if (FCode.equalsIgnoreCase("BranchFaxNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchFaxNo));
		}
		if (FCode.equalsIgnoreCase("BranchLocation"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchLocation));
		}
		if (FCode.equalsIgnoreCase("BranchStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchStatus));
		}
		if (FCode.equalsIgnoreCase("BranchTerminateEffDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBranchTerminateEffDate()));
		}
		if (FCode.equalsIgnoreCase("BranchTerminateReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchTerminateReason));
		}
		if (FCode.equalsIgnoreCase("DirectFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DirectFlag));
		}
		if (FCode.equalsIgnoreCase("UpAgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UpAgentGroup));
		}
		if (FCode.equalsIgnoreCase("BranchManager"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchManager));
		}
		if (FCode.equalsIgnoreCase("ReportingManager"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReportingManager));
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
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(BranchAttr);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(BranchLevel);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(BranchName);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(BranchNameEng);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(BranchNameChi);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBranchEffDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(BranchAddress);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(BranchPhoneNo);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(BranchFaxNo);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(BranchLocation);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(BranchStatus);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBranchTerminateEffDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(BranchTerminateReason);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(DirectFlag);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(UpAgentGroup);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(BranchManager);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(ReportingManager);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 27:
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchAttr = FValue.trim();
			}
			else
				BranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("BranchLevel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchLevel = FValue.trim();
			}
			else
				BranchLevel = null;
		}
		if (FCode.equalsIgnoreCase("BranchName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchName = FValue.trim();
			}
			else
				BranchName = null;
		}
		if (FCode.equalsIgnoreCase("BranchNameEng"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchNameEng = FValue.trim();
			}
			else
				BranchNameEng = null;
		}
		if (FCode.equalsIgnoreCase("BranchNameChi"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchNameChi = FValue.trim();
			}
			else
				BranchNameChi = null;
		}
		if (FCode.equalsIgnoreCase("BranchEffDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BranchEffDate = fDate.getDate( FValue );
			}
			else
				BranchEffDate = null;
		}
		if (FCode.equalsIgnoreCase("BranchAddress"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchAddress = FValue.trim();
			}
			else
				BranchAddress = null;
		}
		if (FCode.equalsIgnoreCase("BranchPhoneNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchPhoneNo = FValue.trim();
			}
			else
				BranchPhoneNo = null;
		}
		if (FCode.equalsIgnoreCase("BranchFaxNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchFaxNo = FValue.trim();
			}
			else
				BranchFaxNo = null;
		}
		if (FCode.equalsIgnoreCase("BranchLocation"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchLocation = FValue.trim();
			}
			else
				BranchLocation = null;
		}
		if (FCode.equalsIgnoreCase("BranchStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchStatus = FValue.trim();
			}
			else
				BranchStatus = null;
		}
		if (FCode.equalsIgnoreCase("BranchTerminateEffDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BranchTerminateEffDate = fDate.getDate( FValue );
			}
			else
				BranchTerminateEffDate = null;
		}
		if (FCode.equalsIgnoreCase("BranchTerminateReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchTerminateReason = FValue.trim();
			}
			else
				BranchTerminateReason = null;
		}
		if (FCode.equalsIgnoreCase("DirectFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DirectFlag = FValue.trim();
			}
			else
				DirectFlag = null;
		}
		if (FCode.equalsIgnoreCase("UpAgentGroup"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UpAgentGroup = FValue.trim();
			}
			else
				UpAgentGroup = null;
		}
		if (FCode.equalsIgnoreCase("BranchManager"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchManager = FValue.trim();
			}
			else
				BranchManager = null;
		}
		if (FCode.equalsIgnoreCase("ReportingManager"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReportingManager = FValue.trim();
			}
			else
				ReportingManager = null;
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
		LABranchGroupBSchema other = (LABranchGroupBSchema)otherObject;
		return
			AgentGroup.equals(other.getAgentGroup())
			&& ManageCom.equals(other.getManageCom())
			&& BranchType.equals(other.getBranchType())
			&& BranchAttr.equals(other.getBranchAttr())
			&& BranchLevel.equals(other.getBranchLevel())
			&& BranchName.equals(other.getBranchName())
			&& BranchNameEng.equals(other.getBranchNameEng())
			&& BranchNameChi.equals(other.getBranchNameChi())
			&& fDate.getString(BranchEffDate).equals(other.getBranchEffDate())
			&& BranchAddress.equals(other.getBranchAddress())
			&& BranchPhoneNo.equals(other.getBranchPhoneNo())
			&& BranchFaxNo.equals(other.getBranchFaxNo())
			&& BranchLocation.equals(other.getBranchLocation())
			&& BranchStatus.equals(other.getBranchStatus())
			&& fDate.getString(BranchTerminateEffDate).equals(other.getBranchTerminateEffDate())
			&& BranchTerminateReason.equals(other.getBranchTerminateReason())
			&& DirectFlag.equals(other.getDirectFlag())
			&& UpAgentGroup.equals(other.getUpAgentGroup())
			&& BranchManager.equals(other.getBranchManager())
			&& ReportingManager.equals(other.getReportingManager())
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
		if( strFieldName.equals("AgentGroup") ) {
			return 0;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 1;
		}
		if( strFieldName.equals("BranchType") ) {
			return 2;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return 3;
		}
		if( strFieldName.equals("BranchLevel") ) {
			return 4;
		}
		if( strFieldName.equals("BranchName") ) {
			return 5;
		}
		if( strFieldName.equals("BranchNameEng") ) {
			return 6;
		}
		if( strFieldName.equals("BranchNameChi") ) {
			return 7;
		}
		if( strFieldName.equals("BranchEffDate") ) {
			return 8;
		}
		if( strFieldName.equals("BranchAddress") ) {
			return 9;
		}
		if( strFieldName.equals("BranchPhoneNo") ) {
			return 10;
		}
		if( strFieldName.equals("BranchFaxNo") ) {
			return 11;
		}
		if( strFieldName.equals("BranchLocation") ) {
			return 12;
		}
		if( strFieldName.equals("BranchStatus") ) {
			return 13;
		}
		if( strFieldName.equals("BranchTerminateEffDate") ) {
			return 14;
		}
		if( strFieldName.equals("BranchTerminateReason") ) {
			return 15;
		}
		if( strFieldName.equals("DirectFlag") ) {
			return 16;
		}
		if( strFieldName.equals("UpAgentGroup") ) {
			return 17;
		}
		if( strFieldName.equals("BranchManager") ) {
			return 18;
		}
		if( strFieldName.equals("ReportingManager") ) {
			return 19;
		}
		if( strFieldName.equals("Operator") ) {
			return 20;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 21;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 22;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 23;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 24;
		}
		if( strFieldName.equals("Operator1") ) {
			return 25;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 26;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 27;
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
				strFieldName = "AgentGroup";
				break;
			case 1:
				strFieldName = "ManageCom";
				break;
			case 2:
				strFieldName = "BranchType";
				break;
			case 3:
				strFieldName = "BranchAttr";
				break;
			case 4:
				strFieldName = "BranchLevel";
				break;
			case 5:
				strFieldName = "BranchName";
				break;
			case 6:
				strFieldName = "BranchNameEng";
				break;
			case 7:
				strFieldName = "BranchNameChi";
				break;
			case 8:
				strFieldName = "BranchEffDate";
				break;
			case 9:
				strFieldName = "BranchAddress";
				break;
			case 10:
				strFieldName = "BranchPhoneNo";
				break;
			case 11:
				strFieldName = "BranchFaxNo";
				break;
			case 12:
				strFieldName = "BranchLocation";
				break;
			case 13:
				strFieldName = "BranchStatus";
				break;
			case 14:
				strFieldName = "BranchTerminateEffDate";
				break;
			case 15:
				strFieldName = "BranchTerminateReason";
				break;
			case 16:
				strFieldName = "DirectFlag";
				break;
			case 17:
				strFieldName = "UpAgentGroup";
				break;
			case 18:
				strFieldName = "BranchManager";
				break;
			case 19:
				strFieldName = "ReportingManager";
				break;
			case 20:
				strFieldName = "Operator";
				break;
			case 21:
				strFieldName = "MakeDate";
				break;
			case 22:
				strFieldName = "MakeTime";
				break;
			case 23:
				strFieldName = "ModifyDate";
				break;
			case 24:
				strFieldName = "ModifyTime";
				break;
			case 25:
				strFieldName = "Operator1";
				break;
			case 26:
				strFieldName = "MakeDate1";
				break;
			case 27:
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
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchLevel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchNameEng") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchNameChi") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchEffDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BranchAddress") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchPhoneNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchFaxNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchLocation") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchTerminateEffDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BranchTerminateReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DirectFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UpAgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchManager") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReportingManager") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
			case 23:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 24:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 25:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 26:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 27:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
