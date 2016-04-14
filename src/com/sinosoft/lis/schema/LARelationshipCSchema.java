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
import com.sinosoft.lis.db.LARelationshipCDB;

/*
 * <p>ClassName: LARelationshipCSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LARelationshipCSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LARelationshipCSchema.class);
	// @Field
	/** Backupmonth */
	private String BackupMonth;
	/** Backtype */
	private String BackType;
	/** Relationid */
	private String RelationID;
	/** Managecom */
	private String ManageCom;
	/** Agentcode */
	private String AgentCode;
	/** Type */
	private String Type;
	/** Agentgrade */
	private String AgentGrade;
	/** Agentgroup */
	private String AgentGroup;
	/** Iagentcode */
	private String IAgentCode;
	/** Iagentgroup */
	private String IAgentGroup;
	/** Iagentgrade */
	private String IAgentGrade;
	/** Deep */
	private int Deep;
	/** State */
	private String State;
	/** Startdate */
	private Date StartDate;
	/** Enddate */
	private Date EndDate;
	/** Pbreakdate */
	private Date PBreakDate;
	/** Ino */
	private int INo;
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
	/** Backupdate */
	private Date BackupDate;
	/** Backuptime */
	private String BackupTime;

	public static final int FIELDNUM = 25;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LARelationshipCSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[6];
		pk[0] = "BackupMonth";
		pk[1] = "BackType";
		pk[2] = "RelationID";
		pk[3] = "Operator1";
		pk[4] = "BackupDate";
		pk[5] = "BackupTime";

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
		LARelationshipCSchema cloned = (LARelationshipCSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getBackupMonth()
	{
		return BackupMonth;
	}
	public void setBackupMonth(String aBackupMonth)
	{
		if(aBackupMonth!=null && aBackupMonth.length()>6)
			throw new IllegalArgumentException("BackupmonthBackupMonth值"+aBackupMonth+"的长度"+aBackupMonth.length()+"大于最大值6");
		BackupMonth = aBackupMonth;
	}
	public String getBackType()
	{
		return BackType;
	}
	public void setBackType(String aBackType)
	{
		if(aBackType!=null && aBackType.length()>2)
			throw new IllegalArgumentException("BacktypeBackType值"+aBackType+"的长度"+aBackType.length()+"大于最大值2");
		BackType = aBackType;
	}
	public String getRelationID()
	{
		return RelationID;
	}
	public void setRelationID(String aRelationID)
	{
		if(aRelationID!=null && aRelationID.length()>20)
			throw new IllegalArgumentException("RelationidRelationID值"+aRelationID+"的长度"+aRelationID.length()+"大于最大值20");
		RelationID = aRelationID;
	}
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
	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>10)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值10");
		AgentCode = aAgentCode;
	}
	public String getType()
	{
		return Type;
	}
	public void setType(String aType)
	{
		if(aType!=null && aType.length()>2)
			throw new IllegalArgumentException("TypeType值"+aType+"的长度"+aType.length()+"大于最大值2");
		Type = aType;
	}
	public String getAgentGrade()
	{
		return AgentGrade;
	}
	public void setAgentGrade(String aAgentGrade)
	{
		if(aAgentGrade!=null && aAgentGrade.length()>10)
			throw new IllegalArgumentException("AgentgradeAgentGrade值"+aAgentGrade+"的长度"+aAgentGrade.length()+"大于最大值10");
		AgentGrade = aAgentGrade;
	}
	public String getAgentGroup()
	{
		return AgentGroup;
	}
	public void setAgentGroup(String aAgentGroup)
	{
		if(aAgentGroup!=null && aAgentGroup.length()>12)
			throw new IllegalArgumentException("AgentgroupAgentGroup值"+aAgentGroup+"的长度"+aAgentGroup.length()+"大于最大值12");
		AgentGroup = aAgentGroup;
	}
	public String getIAgentCode()
	{
		return IAgentCode;
	}
	public void setIAgentCode(String aIAgentCode)
	{
		if(aIAgentCode!=null && aIAgentCode.length()>10)
			throw new IllegalArgumentException("IagentcodeIAgentCode值"+aIAgentCode+"的长度"+aIAgentCode.length()+"大于最大值10");
		IAgentCode = aIAgentCode;
	}
	public String getIAgentGroup()
	{
		return IAgentGroup;
	}
	public void setIAgentGroup(String aIAgentGroup)
	{
		if(aIAgentGroup!=null && aIAgentGroup.length()>12)
			throw new IllegalArgumentException("IagentgroupIAgentGroup值"+aIAgentGroup+"的长度"+aIAgentGroup.length()+"大于最大值12");
		IAgentGroup = aIAgentGroup;
	}
	public String getIAgentGrade()
	{
		return IAgentGrade;
	}
	public void setIAgentGrade(String aIAgentGrade)
	{
		if(aIAgentGrade!=null && aIAgentGrade.length()>10)
			throw new IllegalArgumentException("IagentgradeIAgentGrade值"+aIAgentGrade+"的长度"+aIAgentGrade.length()+"大于最大值10");
		IAgentGrade = aIAgentGrade;
	}
	public int getDeep()
	{
		return Deep;
	}
	public void setDeep(int aDeep)
	{
		Deep = aDeep;
	}
	public void setDeep(String aDeep)
	{
		if (aDeep != null && !aDeep.equals(""))
		{
			Integer tInteger = new Integer(aDeep);
			int i = tInteger.intValue();
			Deep = i;
		}
	}

	public String getState()
	{
		return State;
	}
	public void setState(String aState)
	{
		if(aState!=null && aState.length()>2)
			throw new IllegalArgumentException("StateState值"+aState+"的长度"+aState.length()+"大于最大值2");
		State = aState;
	}
	public String getStartDate()
	{
		if( StartDate != null )
			return fDate.getString(StartDate);
		else
			return null;
	}
	public void setStartDate(Date aStartDate)
	{
		StartDate = aStartDate;
	}
	public void setStartDate(String aStartDate)
	{
		if (aStartDate != null && !aStartDate.equals("") )
		{
			StartDate = fDate.getDate( aStartDate );
		}
		else
			StartDate = null;
	}

	public String getEndDate()
	{
		if( EndDate != null )
			return fDate.getString(EndDate);
		else
			return null;
	}
	public void setEndDate(Date aEndDate)
	{
		EndDate = aEndDate;
	}
	public void setEndDate(String aEndDate)
	{
		if (aEndDate != null && !aEndDate.equals("") )
		{
			EndDate = fDate.getDate( aEndDate );
		}
		else
			EndDate = null;
	}

	public String getPBreakDate()
	{
		if( PBreakDate != null )
			return fDate.getString(PBreakDate);
		else
			return null;
	}
	public void setPBreakDate(Date aPBreakDate)
	{
		PBreakDate = aPBreakDate;
	}
	public void setPBreakDate(String aPBreakDate)
	{
		if (aPBreakDate != null && !aPBreakDate.equals("") )
		{
			PBreakDate = fDate.getDate( aPBreakDate );
		}
		else
			PBreakDate = null;
	}

	public int getINo()
	{
		return INo;
	}
	public void setINo(int aINo)
	{
		INo = aINo;
	}
	public void setINo(String aINo)
	{
		if (aINo != null && !aINo.equals(""))
		{
			Integer tInteger = new Integer(aINo);
			int i = tInteger.intValue();
			INo = i;
		}
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
	public String getBackupDate()
	{
		if( BackupDate != null )
			return fDate.getString(BackupDate);
		else
			return null;
	}
	public void setBackupDate(Date aBackupDate)
	{
		BackupDate = aBackupDate;
	}
	public void setBackupDate(String aBackupDate)
	{
		if (aBackupDate != null && !aBackupDate.equals("") )
		{
			BackupDate = fDate.getDate( aBackupDate );
		}
		else
			BackupDate = null;
	}

	public String getBackupTime()
	{
		return BackupTime;
	}
	public void setBackupTime(String aBackupTime)
	{
		if(aBackupTime!=null && aBackupTime.length()>8)
			throw new IllegalArgumentException("BackuptimeBackupTime值"+aBackupTime+"的长度"+aBackupTime.length()+"大于最大值8");
		BackupTime = aBackupTime;
	}

	/**
	* 使用另外一个 LARelationshipCSchema 对象给 Schema 赋值
	* @param: aLARelationshipCSchema LARelationshipCSchema
	**/
	public void setSchema(LARelationshipCSchema aLARelationshipCSchema)
	{
		this.BackupMonth = aLARelationshipCSchema.getBackupMonth();
		this.BackType = aLARelationshipCSchema.getBackType();
		this.RelationID = aLARelationshipCSchema.getRelationID();
		this.ManageCom = aLARelationshipCSchema.getManageCom();
		this.AgentCode = aLARelationshipCSchema.getAgentCode();
		this.Type = aLARelationshipCSchema.getType();
		this.AgentGrade = aLARelationshipCSchema.getAgentGrade();
		this.AgentGroup = aLARelationshipCSchema.getAgentGroup();
		this.IAgentCode = aLARelationshipCSchema.getIAgentCode();
		this.IAgentGroup = aLARelationshipCSchema.getIAgentGroup();
		this.IAgentGrade = aLARelationshipCSchema.getIAgentGrade();
		this.Deep = aLARelationshipCSchema.getDeep();
		this.State = aLARelationshipCSchema.getState();
		this.StartDate = fDate.getDate( aLARelationshipCSchema.getStartDate());
		this.EndDate = fDate.getDate( aLARelationshipCSchema.getEndDate());
		this.PBreakDate = fDate.getDate( aLARelationshipCSchema.getPBreakDate());
		this.INo = aLARelationshipCSchema.getINo();
		this.Operator = aLARelationshipCSchema.getOperator();
		this.MakeDate = fDate.getDate( aLARelationshipCSchema.getMakeDate());
		this.MakeTime = aLARelationshipCSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLARelationshipCSchema.getModifyDate());
		this.ModifyTime = aLARelationshipCSchema.getModifyTime();
		this.Operator1 = aLARelationshipCSchema.getOperator1();
		this.BackupDate = fDate.getDate( aLARelationshipCSchema.getBackupDate());
		this.BackupTime = aLARelationshipCSchema.getBackupTime();
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
			if( rs.getString("BackupMonth") == null )
				this.BackupMonth = null;
			else
				this.BackupMonth = rs.getString("BackupMonth").trim();

			if( rs.getString("BackType") == null )
				this.BackType = null;
			else
				this.BackType = rs.getString("BackType").trim();

			if( rs.getString("RelationID") == null )
				this.RelationID = null;
			else
				this.RelationID = rs.getString("RelationID").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("Type") == null )
				this.Type = null;
			else
				this.Type = rs.getString("Type").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("IAgentCode") == null )
				this.IAgentCode = null;
			else
				this.IAgentCode = rs.getString("IAgentCode").trim();

			if( rs.getString("IAgentGroup") == null )
				this.IAgentGroup = null;
			else
				this.IAgentGroup = rs.getString("IAgentGroup").trim();

			if( rs.getString("IAgentGrade") == null )
				this.IAgentGrade = null;
			else
				this.IAgentGrade = rs.getString("IAgentGrade").trim();

			this.Deep = rs.getInt("Deep");
			if( rs.getString("State") == null )
				this.State = null;
			else
				this.State = rs.getString("State").trim();

			this.StartDate = rs.getDate("StartDate");
			this.EndDate = rs.getDate("EndDate");
			this.PBreakDate = rs.getDate("PBreakDate");
			this.INo = rs.getInt("INo");
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

			this.BackupDate = rs.getDate("BackupDate");
			if( rs.getString("BackupTime") == null )
				this.BackupTime = null;
			else
				this.BackupTime = rs.getString("BackupTime").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LARelationshipC表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARelationshipCSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LARelationshipCSchema getSchema()
	{
		LARelationshipCSchema aLARelationshipCSchema = new LARelationshipCSchema();
		aLARelationshipCSchema.setSchema(this);
		return aLARelationshipCSchema;
	}

	public LARelationshipCDB getDB()
	{
		LARelationshipCDB aDBOper = new LARelationshipCDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARelationshipC描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(BackupMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BackType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RelationID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Type)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IAgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IAgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Deep));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(State)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( StartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EndDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( PBreakDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(INo));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BackupDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BackupTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARelationshipC>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			BackupMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			BackType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			RelationID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			IAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			IAgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			IAgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Deep= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,12,SysConst.PACKAGESPILTER))).intValue();
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			StartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			EndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			PBreakDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			INo= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,17,SysConst.PACKAGESPILTER))).intValue();
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			BackupDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24,SysConst.PACKAGESPILTER));
			BackupTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARelationshipCSchema";
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
		if (FCode.equalsIgnoreCase("BackupMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BackupMonth));
		}
		if (FCode.equalsIgnoreCase("BackType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BackType));
		}
		if (FCode.equalsIgnoreCase("RelationID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RelationID));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("Type"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Type));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("IAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IAgentCode));
		}
		if (FCode.equalsIgnoreCase("IAgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IAgentGroup));
		}
		if (FCode.equalsIgnoreCase("IAgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IAgentGrade));
		}
		if (FCode.equalsIgnoreCase("Deep"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Deep));
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(State));
		}
		if (FCode.equalsIgnoreCase("StartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
		}
		if (FCode.equalsIgnoreCase("EndDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
		}
		if (FCode.equalsIgnoreCase("PBreakDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getPBreakDate()));
		}
		if (FCode.equalsIgnoreCase("INo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(INo));
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
		if (FCode.equalsIgnoreCase("BackupDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBackupDate()));
		}
		if (FCode.equalsIgnoreCase("BackupTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BackupTime));
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
				strFieldValue = StrTool.GBKToUnicode(BackupMonth);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(BackType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(RelationID);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Type);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(IAgentCode);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(IAgentGroup);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(IAgentGrade);
				break;
			case 11:
				strFieldValue = String.valueOf(Deep);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(State);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getPBreakDate()));
				break;
			case 16:
				strFieldValue = String.valueOf(INo);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBackupDate()));
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(BackupTime);
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

		if (FCode.equalsIgnoreCase("BackupMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BackupMonth = FValue.trim();
			}
			else
				BackupMonth = null;
		}
		if (FCode.equalsIgnoreCase("BackType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BackType = FValue.trim();
			}
			else
				BackType = null;
		}
		if (FCode.equalsIgnoreCase("RelationID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RelationID = FValue.trim();
			}
			else
				RelationID = null;
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
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("Type"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Type = FValue.trim();
			}
			else
				Type = null;
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGrade = FValue.trim();
			}
			else
				AgentGrade = null;
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
		if (FCode.equalsIgnoreCase("IAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IAgentCode = FValue.trim();
			}
			else
				IAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("IAgentGroup"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IAgentGroup = FValue.trim();
			}
			else
				IAgentGroup = null;
		}
		if (FCode.equalsIgnoreCase("IAgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IAgentGrade = FValue.trim();
			}
			else
				IAgentGrade = null;
		}
		if (FCode.equalsIgnoreCase("Deep"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				Deep = i;
			}
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
		if (FCode.equalsIgnoreCase("StartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				StartDate = fDate.getDate( FValue );
			}
			else
				StartDate = null;
		}
		if (FCode.equalsIgnoreCase("EndDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				EndDate = fDate.getDate( FValue );
			}
			else
				EndDate = null;
		}
		if (FCode.equalsIgnoreCase("PBreakDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				PBreakDate = fDate.getDate( FValue );
			}
			else
				PBreakDate = null;
		}
		if (FCode.equalsIgnoreCase("INo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				INo = i;
			}
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
		if (FCode.equalsIgnoreCase("BackupDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BackupDate = fDate.getDate( FValue );
			}
			else
				BackupDate = null;
		}
		if (FCode.equalsIgnoreCase("BackupTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BackupTime = FValue.trim();
			}
			else
				BackupTime = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LARelationshipCSchema other = (LARelationshipCSchema)otherObject;
		return
			BackupMonth.equals(other.getBackupMonth())
			&& BackType.equals(other.getBackType())
			&& RelationID.equals(other.getRelationID())
			&& ManageCom.equals(other.getManageCom())
			&& AgentCode.equals(other.getAgentCode())
			&& Type.equals(other.getType())
			&& AgentGrade.equals(other.getAgentGrade())
			&& AgentGroup.equals(other.getAgentGroup())
			&& IAgentCode.equals(other.getIAgentCode())
			&& IAgentGroup.equals(other.getIAgentGroup())
			&& IAgentGrade.equals(other.getIAgentGrade())
			&& Deep == other.getDeep()
			&& State.equals(other.getState())
			&& fDate.getString(StartDate).equals(other.getStartDate())
			&& fDate.getString(EndDate).equals(other.getEndDate())
			&& fDate.getString(PBreakDate).equals(other.getPBreakDate())
			&& INo == other.getINo()
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator1.equals(other.getOperator1())
			&& fDate.getString(BackupDate).equals(other.getBackupDate())
			&& BackupTime.equals(other.getBackupTime());
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
		if( strFieldName.equals("BackupMonth") ) {
			return 0;
		}
		if( strFieldName.equals("BackType") ) {
			return 1;
		}
		if( strFieldName.equals("RelationID") ) {
			return 2;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 3;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 4;
		}
		if( strFieldName.equals("Type") ) {
			return 5;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 6;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 7;
		}
		if( strFieldName.equals("IAgentCode") ) {
			return 8;
		}
		if( strFieldName.equals("IAgentGroup") ) {
			return 9;
		}
		if( strFieldName.equals("IAgentGrade") ) {
			return 10;
		}
		if( strFieldName.equals("Deep") ) {
			return 11;
		}
		if( strFieldName.equals("State") ) {
			return 12;
		}
		if( strFieldName.equals("StartDate") ) {
			return 13;
		}
		if( strFieldName.equals("EndDate") ) {
			return 14;
		}
		if( strFieldName.equals("PBreakDate") ) {
			return 15;
		}
		if( strFieldName.equals("INo") ) {
			return 16;
		}
		if( strFieldName.equals("Operator") ) {
			return 17;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 18;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 19;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 20;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 21;
		}
		if( strFieldName.equals("Operator1") ) {
			return 22;
		}
		if( strFieldName.equals("BackupDate") ) {
			return 23;
		}
		if( strFieldName.equals("BackupTime") ) {
			return 24;
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
				strFieldName = "BackupMonth";
				break;
			case 1:
				strFieldName = "BackType";
				break;
			case 2:
				strFieldName = "RelationID";
				break;
			case 3:
				strFieldName = "ManageCom";
				break;
			case 4:
				strFieldName = "AgentCode";
				break;
			case 5:
				strFieldName = "Type";
				break;
			case 6:
				strFieldName = "AgentGrade";
				break;
			case 7:
				strFieldName = "AgentGroup";
				break;
			case 8:
				strFieldName = "IAgentCode";
				break;
			case 9:
				strFieldName = "IAgentGroup";
				break;
			case 10:
				strFieldName = "IAgentGrade";
				break;
			case 11:
				strFieldName = "Deep";
				break;
			case 12:
				strFieldName = "State";
				break;
			case 13:
				strFieldName = "StartDate";
				break;
			case 14:
				strFieldName = "EndDate";
				break;
			case 15:
				strFieldName = "PBreakDate";
				break;
			case 16:
				strFieldName = "INo";
				break;
			case 17:
				strFieldName = "Operator";
				break;
			case 18:
				strFieldName = "MakeDate";
				break;
			case 19:
				strFieldName = "MakeTime";
				break;
			case 20:
				strFieldName = "ModifyDate";
				break;
			case 21:
				strFieldName = "ModifyTime";
				break;
			case 22:
				strFieldName = "Operator1";
				break;
			case 23:
				strFieldName = "BackupDate";
				break;
			case 24:
				strFieldName = "BackupTime";
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
		if( strFieldName.equals("BackupMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BackType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RelationID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Type") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IAgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IAgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Deep") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("State") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("EndDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("PBreakDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("INo") ) {
			return Schema.TYPE_INT;
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
		if( strFieldName.equals("BackupDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BackupTime") ) {
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
				nFieldType = Schema.TYPE_INT;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 13:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 14:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 15:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_INT;
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
			case 20:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 21:
				nFieldType = Schema.TYPE_STRING;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
