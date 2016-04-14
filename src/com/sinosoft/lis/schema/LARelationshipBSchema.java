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
import com.sinosoft.lis.db.LARelationshipBDB;

/*
 * <p>ClassName: LARelationshipBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LARelationshipBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LARelationshipBSchema.class);
	// @Field
	/** Edorno */
	private String EdorNo;
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
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;

	public static final int FIELDNUM = 24;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LARelationshipBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "EdorNo";

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
		LARelationshipBSchema cloned = (LARelationshipBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getEdorNo()
	{
		return EdorNo;
	}
	public void setEdorNo(String aEdorNo)
	{
		if(aEdorNo!=null && aEdorNo.length()>20)
			throw new IllegalArgumentException("EdornoEdorNo值"+aEdorNo+"的长度"+aEdorNo.length()+"大于最大值20");
		EdorNo = aEdorNo;
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
		if(aOperator!=null && aOperator.length()>80)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值80");
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
		if(aOperator1!=null && aOperator1.length()>80)
			throw new IllegalArgumentException("Operator1Operator1值"+aOperator1+"的长度"+aOperator1.length()+"大于最大值80");
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
	* 使用另外一个 LARelationshipBSchema 对象给 Schema 赋值
	* @param: aLARelationshipBSchema LARelationshipBSchema
	**/
	public void setSchema(LARelationshipBSchema aLARelationshipBSchema)
	{
		this.EdorNo = aLARelationshipBSchema.getEdorNo();
		this.RelationID = aLARelationshipBSchema.getRelationID();
		this.ManageCom = aLARelationshipBSchema.getManageCom();
		this.AgentCode = aLARelationshipBSchema.getAgentCode();
		this.Type = aLARelationshipBSchema.getType();
		this.AgentGrade = aLARelationshipBSchema.getAgentGrade();
		this.AgentGroup = aLARelationshipBSchema.getAgentGroup();
		this.IAgentCode = aLARelationshipBSchema.getIAgentCode();
		this.IAgentGroup = aLARelationshipBSchema.getIAgentGroup();
		this.IAgentGrade = aLARelationshipBSchema.getIAgentGrade();
		this.Deep = aLARelationshipBSchema.getDeep();
		this.State = aLARelationshipBSchema.getState();
		this.StartDate = fDate.getDate( aLARelationshipBSchema.getStartDate());
		this.EndDate = fDate.getDate( aLARelationshipBSchema.getEndDate());
		this.PBreakDate = fDate.getDate( aLARelationshipBSchema.getPBreakDate());
		this.INo = aLARelationshipBSchema.getINo();
		this.Operator = aLARelationshipBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLARelationshipBSchema.getMakeDate());
		this.MakeTime = aLARelationshipBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLARelationshipBSchema.getModifyDate());
		this.ModifyTime = aLARelationshipBSchema.getModifyTime();
		this.Operator1 = aLARelationshipBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLARelationshipBSchema.getMakeDate1());
		this.MakeTime1 = aLARelationshipBSchema.getMakeTime1();
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
			if( rs.getString("EdorNo") == null )
				this.EdorNo = null;
			else
				this.EdorNo = rs.getString("EdorNo").trim();

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

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LARelationshipB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARelationshipBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LARelationshipBSchema getSchema()
	{
		LARelationshipBSchema aLARelationshipBSchema = new LARelationshipBSchema();
		aLARelationshipBSchema.setSchema(this);
		return aLARelationshipBSchema;
	}

	public LARelationshipBDB getDB()
	{
		LARelationshipBDB aDBOper = new LARelationshipBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARelationshipB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(EdorNo)); strReturn.append(SysConst.PACKAGESPILTER);
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
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLARelationshipB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			RelationID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			IAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			IAgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			IAgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			Deep= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,11,SysConst.PACKAGESPILTER))).intValue();
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			StartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			EndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			PBreakDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			INo= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,16,SysConst.PACKAGESPILTER))).intValue();
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LARelationshipBSchema";
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
		if (FCode.equalsIgnoreCase("EdorNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorNo));
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
				strFieldValue = StrTool.GBKToUnicode(EdorNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(RelationID);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Type);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(IAgentCode);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(IAgentGroup);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(IAgentGrade);
				break;
			case 10:
				strFieldValue = String.valueOf(Deep);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(State);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getPBreakDate()));
				break;
			case 15:
				strFieldValue = String.valueOf(INo);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 23:
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

		if (FCode.equalsIgnoreCase("EdorNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EdorNo = FValue.trim();
			}
			else
				EdorNo = null;
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
		LARelationshipBSchema other = (LARelationshipBSchema)otherObject;
		return
			EdorNo.equals(other.getEdorNo())
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
		if( strFieldName.equals("EdorNo") ) {
			return 0;
		}
		if( strFieldName.equals("RelationID") ) {
			return 1;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 2;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 3;
		}
		if( strFieldName.equals("Type") ) {
			return 4;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 5;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 6;
		}
		if( strFieldName.equals("IAgentCode") ) {
			return 7;
		}
		if( strFieldName.equals("IAgentGroup") ) {
			return 8;
		}
		if( strFieldName.equals("IAgentGrade") ) {
			return 9;
		}
		if( strFieldName.equals("Deep") ) {
			return 10;
		}
		if( strFieldName.equals("State") ) {
			return 11;
		}
		if( strFieldName.equals("StartDate") ) {
			return 12;
		}
		if( strFieldName.equals("EndDate") ) {
			return 13;
		}
		if( strFieldName.equals("PBreakDate") ) {
			return 14;
		}
		if( strFieldName.equals("INo") ) {
			return 15;
		}
		if( strFieldName.equals("Operator") ) {
			return 16;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 17;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 18;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 19;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 20;
		}
		if( strFieldName.equals("Operator1") ) {
			return 21;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 22;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 23;
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
				strFieldName = "EdorNo";
				break;
			case 1:
				strFieldName = "RelationID";
				break;
			case 2:
				strFieldName = "ManageCom";
				break;
			case 3:
				strFieldName = "AgentCode";
				break;
			case 4:
				strFieldName = "Type";
				break;
			case 5:
				strFieldName = "AgentGrade";
				break;
			case 6:
				strFieldName = "AgentGroup";
				break;
			case 7:
				strFieldName = "IAgentCode";
				break;
			case 8:
				strFieldName = "IAgentGroup";
				break;
			case 9:
				strFieldName = "IAgentGrade";
				break;
			case 10:
				strFieldName = "Deep";
				break;
			case 11:
				strFieldName = "State";
				break;
			case 12:
				strFieldName = "StartDate";
				break;
			case 13:
				strFieldName = "EndDate";
				break;
			case 14:
				strFieldName = "PBreakDate";
				break;
			case 15:
				strFieldName = "INo";
				break;
			case 16:
				strFieldName = "Operator";
				break;
			case 17:
				strFieldName = "MakeDate";
				break;
			case 18:
				strFieldName = "MakeTime";
				break;
			case 19:
				strFieldName = "ModifyDate";
				break;
			case 20:
				strFieldName = "ModifyTime";
				break;
			case 21:
				strFieldName = "Operator1";
				break;
			case 22:
				strFieldName = "MakeDate1";
				break;
			case 23:
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
		if( strFieldName.equals("EdorNo") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_INT;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 13:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 14:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 15:
				nFieldType = Schema.TYPE_INT;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 20:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 21:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 22:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 23:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
