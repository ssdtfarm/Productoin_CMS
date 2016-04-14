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
import com.sinosoft.lis.db.LAAssessAccessoryTrialDB;

/*
 * <p>ClassName: LAAssessAccessoryTrialSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAssessAccessoryTrialSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAssessAccessoryTrialSchema.class);
	// @Field
	/** Indexcalno */
	private String IndexCalNo;
	/** Assesstype */
	private String AssessType;
	/** Agentcode */
	private String AgentCode;
	/** Basecode */
	private String BaseCode;
	/** Branchtype */
	private String BranchType;
	/** Branchattr */
	private String BranchAttr;
	/** Agentgroup */
	private String AgentGroup;
	/** Managecom */
	private String ManageCom;
	/** Result */
	private String Result;
	/** Modifyflag */
	private String ModifyFlag;
	/** Agentgrade */
	private String AgentGrade;
	/** Calagentgrade */
	private String CalAgentGrade;
	/** Agentgrade1 */
	private String AgentGrade1;
	/** Confirmer */
	private String ConFirmer;
	/** Confirmdate */
	private Date ConFirmDate;
	/** State */
	private String State;
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
	/** Branchtype2 */
	private String BranchType2;
	/** Curredorno */
	private String CurrEdorNo;
	/** Modifyreason */
	private String ModifyReason;
	/** Isjoin */
	private String IsJoin;
	/** Salary_old */
	private double Salary_Old;
	/** Salary_new */
	private double Salary_New;

	public static final int FIELDNUM = 27;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAssessAccessoryTrialSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[6];
		pk[0] = "IndexCalNo";
		pk[1] = "AssessType";
		pk[2] = "AgentCode";
		pk[3] = "BaseCode";
		pk[4] = "BranchType";
		pk[5] = "BranchType2";

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
		LAAssessAccessoryTrialSchema cloned = (LAAssessAccessoryTrialSchema)super.clone();
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
	* 考核年月
	*/
	public String getIndexCalNo()
	{
		return IndexCalNo;
	}
	public void setIndexCalNo(String aIndexCalNo)
	{
		if(aIndexCalNo!=null && aIndexCalNo.length()>10)
			throw new IllegalArgumentException("IndexcalnoIndexCalNo值"+aIndexCalNo+"的长度"+aIndexCalNo.length()+"大于最大值10");
		IndexCalNo = aIndexCalNo;
	}
	/**
	* 考核类型【00-正式考核；01-预警考核】
	*/
	public String getAssessType()
	{
		return AssessType;
	}
	public void setAssessType(String aAssessType)
	{
		if(aAssessType!=null && aAssessType.length()>2)
			throw new IllegalArgumentException("AssesstypeAssessType值"+aAssessType+"的长度"+aAssessType.length()+"大于最大值2");
		AssessType = aAssessType;
	}
	/**
	* 代理人编码
	*/
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
	/**
	* 基本法
	*/
	public String getBaseCode()
	{
		return BaseCode;
	}
	public void setBaseCode(String aBaseCode)
	{
		if(aBaseCode!=null && aBaseCode.length()>20)
			throw new IllegalArgumentException("BasecodeBaseCode值"+aBaseCode+"的长度"+aBaseCode.length()+"大于最大值20");
		BaseCode = aBaseCode;
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
	* 机构外部代码
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
	* 机构内部代码
	*/
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
	/**
	* 管理机构
	*/
	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>11)
			throw new IllegalArgumentException("ManagecomManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值11");
		ManageCom = aManageCom;
	}
	/**
	* 结果标志【-2-降两级；-1-降一级；0-维持；1-升一级；2-升两级】
	*/
	public String getResult()
	{
		return Result;
	}
	public void setResult(String aResult)
	{
		if(aResult!=null && aResult.length()>60)
			throw new IllegalArgumentException("ResultResult值"+aResult+"的长度"+aResult.length()+"大于最大值60");
		Result = aResult;
	}
	/**
	* 修改标志【Y-有修改；N-无修改】
	*/
	public String getModifyFlag()
	{
		return ModifyFlag;
	}
	public void setModifyFlag(String aModifyFlag)
	{
		if(aModifyFlag!=null && aModifyFlag.length()>2)
			throw new IllegalArgumentException("ModifyflagModifyFlag值"+aModifyFlag+"的长度"+aModifyFlag.length()+"大于最大值2");
		ModifyFlag = aModifyFlag;
	}
	/**
	* 职级
	*/
	public String getAgentGrade()
	{
		return AgentGrade;
	}
	public void setAgentGrade(String aAgentGrade)
	{
		if(aAgentGrade!=null && aAgentGrade.length()>6)
			throw new IllegalArgumentException("AgentgradeAgentGrade值"+aAgentGrade+"的长度"+aAgentGrade.length()+"大于最大值6");
		AgentGrade = aAgentGrade;
	}
	/**
	* 计算后代理人职级
	*/
	public String getCalAgentGrade()
	{
		return CalAgentGrade;
	}
	public void setCalAgentGrade(String aCalAgentGrade)
	{
		if(aCalAgentGrade!=null && aCalAgentGrade.length()>6)
			throw new IllegalArgumentException("CalagentgradeCalAgentGrade值"+aCalAgentGrade+"的长度"+aCalAgentGrade.length()+"大于最大值6");
		CalAgentGrade = aCalAgentGrade;
	}
	/**
	* 调整后代理人职级
	*/
	public String getAgentGrade1()
	{
		return AgentGrade1;
	}
	public void setAgentGrade1(String aAgentGrade1)
	{
		if(aAgentGrade1!=null && aAgentGrade1.length()>6)
			throw new IllegalArgumentException("Agentgrade1AgentGrade1值"+aAgentGrade1+"的长度"+aAgentGrade1.length()+"大于最大值6");
		AgentGrade1 = aAgentGrade1;
	}
	/**
	* 确认操作者
	*/
	public String getConFirmer()
	{
		return ConFirmer;
	}
	public void setConFirmer(String aConFirmer)
	{
		if(aConFirmer!=null && aConFirmer.length()>60)
			throw new IllegalArgumentException("ConfirmerConFirmer值"+aConFirmer+"的长度"+aConFirmer.length()+"大于最大值60");
		ConFirmer = aConFirmer;
	}
	/**
	* 确认操作日期
	*/
	public String getConFirmDate()
	{
		if( ConFirmDate != null )
			return fDate.getString(ConFirmDate);
		else
			return null;
	}
	public void setConFirmDate(Date aConFirmDate)
	{
		ConFirmDate = aConFirmDate;
	}
	public void setConFirmDate(String aConFirmDate)
	{
		if (aConFirmDate != null && !aConFirmDate.equals("") )
		{
			ConFirmDate = fDate.getDate( aConFirmDate );
		}
		else
			ConFirmDate = null;
	}

	/**
	* 状态
	*/
	public String getState()
	{
		return State;
	}
	public void setState(String aState)
	{
		if(aState!=null && aState.length()>10)
			throw new IllegalArgumentException("StateState值"+aState+"的长度"+aState.length()+"大于最大值10");
		State = aState;
	}
	/**
	* 操作者
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
	* 入机日期
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
	* 入机时间
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
	* 最后一次修改日期
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
	* 最后一次修改时间
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
	* 子渠道
	*/
	public String getBranchType2()
	{
		return BranchType2;
	}
	public void setBranchType2(String aBranchType2)
	{
		if(aBranchType2!=null && aBranchType2.length()>2)
			throw new IllegalArgumentException("Branchtype2BranchType2值"+aBranchType2+"的长度"+aBranchType2.length()+"大于最大值2");
		BranchType2 = aBranchType2;
	}
	/**
	* 当前流水号
	*/
	public String getCurrEdorNo()
	{
		return CurrEdorNo;
	}
	public void setCurrEdorNo(String aCurrEdorNo)
	{
		if(aCurrEdorNo!=null && aCurrEdorNo.length()>20)
			throw new IllegalArgumentException("CurredornoCurrEdorNo值"+aCurrEdorNo+"的长度"+aCurrEdorNo.length()+"大于最大值20");
		CurrEdorNo = aCurrEdorNo;
	}
	/**
	* 修改原因
	*/
	public String getModifyReason()
	{
		return ModifyReason;
	}
	public void setModifyReason(String aModifyReason)
	{
		if(aModifyReason!=null && aModifyReason.length()>100)
			throw new IllegalArgumentException("ModifyreasonModifyReason值"+aModifyReason+"的长度"+aModifyReason.length()+"大于最大值100");
		ModifyReason = aModifyReason;
	}
	/**
	* 是否参加考核【Y-参加考核；N-不参加考核（IA转正日期在本考核期内，默认不参加考核）】
	*/
	public String getIsJoin()
	{
		return IsJoin;
	}
	public void setIsJoin(String aIsJoin)
	{
		if(aIsJoin!=null && aIsJoin.length()>1)
			throw new IllegalArgumentException("IsjoinIsJoin值"+aIsJoin+"的长度"+aIsJoin.length()+"大于最大值1");
		IsJoin = aIsJoin;
	}
	/**
	* 考核前底薪
	*/
	public double getSalary_Old()
	{
		return Salary_Old;
	}
	public void setSalary_Old(double aSalary_Old)
	{
		Salary_Old = aSalary_Old;
	}
	public void setSalary_Old(String aSalary_Old)
	{
		if (aSalary_Old != null && !aSalary_Old.equals(""))
		{
			Double tDouble = new Double(aSalary_Old);
			double d = tDouble.doubleValue();
			Salary_Old = d;
		}
	}

	/**
	* 考核后底薪
	*/
	public double getSalary_New()
	{
		return Salary_New;
	}
	public void setSalary_New(double aSalary_New)
	{
		Salary_New = aSalary_New;
	}
	public void setSalary_New(String aSalary_New)
	{
		if (aSalary_New != null && !aSalary_New.equals(""))
		{
			Double tDouble = new Double(aSalary_New);
			double d = tDouble.doubleValue();
			Salary_New = d;
		}
	}


	/**
	* 使用另外一个 LAAssessAccessoryTrialSchema 对象给 Schema 赋值
	* @param: aLAAssessAccessoryTrialSchema LAAssessAccessoryTrialSchema
	**/
	public void setSchema(LAAssessAccessoryTrialSchema aLAAssessAccessoryTrialSchema)
	{
		this.IndexCalNo = aLAAssessAccessoryTrialSchema.getIndexCalNo();
		this.AssessType = aLAAssessAccessoryTrialSchema.getAssessType();
		this.AgentCode = aLAAssessAccessoryTrialSchema.getAgentCode();
		this.BaseCode = aLAAssessAccessoryTrialSchema.getBaseCode();
		this.BranchType = aLAAssessAccessoryTrialSchema.getBranchType();
		this.BranchAttr = aLAAssessAccessoryTrialSchema.getBranchAttr();
		this.AgentGroup = aLAAssessAccessoryTrialSchema.getAgentGroup();
		this.ManageCom = aLAAssessAccessoryTrialSchema.getManageCom();
		this.Result = aLAAssessAccessoryTrialSchema.getResult();
		this.ModifyFlag = aLAAssessAccessoryTrialSchema.getModifyFlag();
		this.AgentGrade = aLAAssessAccessoryTrialSchema.getAgentGrade();
		this.CalAgentGrade = aLAAssessAccessoryTrialSchema.getCalAgentGrade();
		this.AgentGrade1 = aLAAssessAccessoryTrialSchema.getAgentGrade1();
		this.ConFirmer = aLAAssessAccessoryTrialSchema.getConFirmer();
		this.ConFirmDate = fDate.getDate( aLAAssessAccessoryTrialSchema.getConFirmDate());
		this.State = aLAAssessAccessoryTrialSchema.getState();
		this.Operator = aLAAssessAccessoryTrialSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAssessAccessoryTrialSchema.getMakeDate());
		this.MakeTime = aLAAssessAccessoryTrialSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAssessAccessoryTrialSchema.getModifyDate());
		this.ModifyTime = aLAAssessAccessoryTrialSchema.getModifyTime();
		this.BranchType2 = aLAAssessAccessoryTrialSchema.getBranchType2();
		this.CurrEdorNo = aLAAssessAccessoryTrialSchema.getCurrEdorNo();
		this.ModifyReason = aLAAssessAccessoryTrialSchema.getModifyReason();
		this.IsJoin = aLAAssessAccessoryTrialSchema.getIsJoin();
		this.Salary_Old = aLAAssessAccessoryTrialSchema.getSalary_Old();
		this.Salary_New = aLAAssessAccessoryTrialSchema.getSalary_New();
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

			if( rs.getString("AssessType") == null )
				this.AssessType = null;
			else
				this.AssessType = rs.getString("AssessType").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("BaseCode") == null )
				this.BaseCode = null;
			else
				this.BaseCode = rs.getString("BaseCode").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("BranchAttr") == null )
				this.BranchAttr = null;
			else
				this.BranchAttr = rs.getString("BranchAttr").trim();

			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("Result") == null )
				this.Result = null;
			else
				this.Result = rs.getString("Result").trim();

			if( rs.getString("ModifyFlag") == null )
				this.ModifyFlag = null;
			else
				this.ModifyFlag = rs.getString("ModifyFlag").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("CalAgentGrade") == null )
				this.CalAgentGrade = null;
			else
				this.CalAgentGrade = rs.getString("CalAgentGrade").trim();

			if( rs.getString("AgentGrade1") == null )
				this.AgentGrade1 = null;
			else
				this.AgentGrade1 = rs.getString("AgentGrade1").trim();

			if( rs.getString("ConFirmer") == null )
				this.ConFirmer = null;
			else
				this.ConFirmer = rs.getString("ConFirmer").trim();

			this.ConFirmDate = rs.getDate("ConFirmDate");
			if( rs.getString("State") == null )
				this.State = null;
			else
				this.State = rs.getString("State").trim();

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

			if( rs.getString("BranchType2") == null )
				this.BranchType2 = null;
			else
				this.BranchType2 = rs.getString("BranchType2").trim();

			if( rs.getString("CurrEdorNo") == null )
				this.CurrEdorNo = null;
			else
				this.CurrEdorNo = rs.getString("CurrEdorNo").trim();

			if( rs.getString("ModifyReason") == null )
				this.ModifyReason = null;
			else
				this.ModifyReason = rs.getString("ModifyReason").trim();

			if( rs.getString("IsJoin") == null )
				this.IsJoin = null;
			else
				this.IsJoin = rs.getString("IsJoin").trim();

			this.Salary_Old = rs.getDouble("Salary_Old");
			this.Salary_New = rs.getDouble("Salary_New");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAAssessAccessoryTrial表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAssessAccessoryTrialSchema getSchema()
	{
		LAAssessAccessoryTrialSchema aLAAssessAccessoryTrialSchema = new LAAssessAccessoryTrialSchema();
		aLAAssessAccessoryTrialSchema.setSchema(this);
		return aLAAssessAccessoryTrialSchema;
	}

	public LAAssessAccessoryTrialDB getDB()
	{
		LAAssessAccessoryTrialDB aDBOper = new LAAssessAccessoryTrialDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAssessAccessoryTrial描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(IndexCalNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AssessType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BaseCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Result)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalAgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ConFirmer)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ConFirmDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(State)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CurrEdorNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IsJoin)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Salary_Old));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Salary_New));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAssessAccessoryTrial>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			IndexCalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			AssessType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BaseCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			BranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Result = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			ModifyFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			CalAgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			AgentGrade1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			ConFirmer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			ConFirmDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			BranchType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			CurrEdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			ModifyReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			IsJoin = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			Salary_Old = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,26,SysConst.PACKAGESPILTER))).doubleValue();
			Salary_New = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,27,SysConst.PACKAGESPILTER))).doubleValue();
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialSchema";
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
		if (FCode.equalsIgnoreCase("AssessType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AssessType));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("BaseCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BaseCode));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAttr));
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("Result"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Result));
		}
		if (FCode.equalsIgnoreCase("ModifyFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyFlag));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("CalAgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalAgentGrade));
		}
		if (FCode.equalsIgnoreCase("AgentGrade1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade1));
		}
		if (FCode.equalsIgnoreCase("ConFirmer"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ConFirmer));
		}
		if (FCode.equalsIgnoreCase("ConFirmDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getConFirmDate()));
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(State));
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
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType2));
		}
		if (FCode.equalsIgnoreCase("CurrEdorNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CurrEdorNo));
		}
		if (FCode.equalsIgnoreCase("ModifyReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyReason));
		}
		if (FCode.equalsIgnoreCase("IsJoin"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IsJoin));
		}
		if (FCode.equalsIgnoreCase("Salary_Old"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Salary_Old));
		}
		if (FCode.equalsIgnoreCase("Salary_New"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Salary_New));
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
				strFieldValue = StrTool.GBKToUnicode(AssessType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(BaseCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(BranchAttr);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Result);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(ModifyFlag);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(CalAgentGrade);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade1);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(ConFirmer);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getConFirmDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(State);
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
				strFieldValue = StrTool.GBKToUnicode(BranchType2);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(CurrEdorNo);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(ModifyReason);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(IsJoin);
				break;
			case 25:
				strFieldValue = String.valueOf(Salary_Old);
				break;
			case 26:
				strFieldValue = String.valueOf(Salary_New);
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
		if (FCode.equalsIgnoreCase("AssessType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AssessType = FValue.trim();
			}
			else
				AssessType = null;
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
		if (FCode.equalsIgnoreCase("BaseCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BaseCode = FValue.trim();
			}
			else
				BaseCode = null;
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
		if (FCode.equalsIgnoreCase("Result"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Result = FValue.trim();
			}
			else
				Result = null;
		}
		if (FCode.equalsIgnoreCase("ModifyFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyFlag = FValue.trim();
			}
			else
				ModifyFlag = null;
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
		if (FCode.equalsIgnoreCase("CalAgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalAgentGrade = FValue.trim();
			}
			else
				CalAgentGrade = null;
		}
		if (FCode.equalsIgnoreCase("AgentGrade1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGrade1 = FValue.trim();
			}
			else
				AgentGrade1 = null;
		}
		if (FCode.equalsIgnoreCase("ConFirmer"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ConFirmer = FValue.trim();
			}
			else
				ConFirmer = null;
		}
		if (FCode.equalsIgnoreCase("ConFirmDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ConFirmDate = fDate.getDate( FValue );
			}
			else
				ConFirmDate = null;
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
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType2 = FValue.trim();
			}
			else
				BranchType2 = null;
		}
		if (FCode.equalsIgnoreCase("CurrEdorNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CurrEdorNo = FValue.trim();
			}
			else
				CurrEdorNo = null;
		}
		if (FCode.equalsIgnoreCase("ModifyReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyReason = FValue.trim();
			}
			else
				ModifyReason = null;
		}
		if (FCode.equalsIgnoreCase("IsJoin"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IsJoin = FValue.trim();
			}
			else
				IsJoin = null;
		}
		if (FCode.equalsIgnoreCase("Salary_Old"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Salary_Old = d;
			}
		}
		if (FCode.equalsIgnoreCase("Salary_New"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Salary_New = d;
			}
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAAssessAccessoryTrialSchema other = (LAAssessAccessoryTrialSchema)otherObject;
		return
			IndexCalNo.equals(other.getIndexCalNo())
			&& AssessType.equals(other.getAssessType())
			&& AgentCode.equals(other.getAgentCode())
			&& BaseCode.equals(other.getBaseCode())
			&& BranchType.equals(other.getBranchType())
			&& BranchAttr.equals(other.getBranchAttr())
			&& AgentGroup.equals(other.getAgentGroup())
			&& ManageCom.equals(other.getManageCom())
			&& Result.equals(other.getResult())
			&& ModifyFlag.equals(other.getModifyFlag())
			&& AgentGrade.equals(other.getAgentGrade())
			&& CalAgentGrade.equals(other.getCalAgentGrade())
			&& AgentGrade1.equals(other.getAgentGrade1())
			&& ConFirmer.equals(other.getConFirmer())
			&& fDate.getString(ConFirmDate).equals(other.getConFirmDate())
			&& State.equals(other.getState())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& BranchType2.equals(other.getBranchType2())
			&& CurrEdorNo.equals(other.getCurrEdorNo())
			&& ModifyReason.equals(other.getModifyReason())
			&& IsJoin.equals(other.getIsJoin())
			&& Salary_Old == other.getSalary_Old()
			&& Salary_New == other.getSalary_New();
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
		if( strFieldName.equals("AssessType") ) {
			return 1;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 2;
		}
		if( strFieldName.equals("BaseCode") ) {
			return 3;
		}
		if( strFieldName.equals("BranchType") ) {
			return 4;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return 5;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 6;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 7;
		}
		if( strFieldName.equals("Result") ) {
			return 8;
		}
		if( strFieldName.equals("ModifyFlag") ) {
			return 9;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 10;
		}
		if( strFieldName.equals("CalAgentGrade") ) {
			return 11;
		}
		if( strFieldName.equals("AgentGrade1") ) {
			return 12;
		}
		if( strFieldName.equals("ConFirmer") ) {
			return 13;
		}
		if( strFieldName.equals("ConFirmDate") ) {
			return 14;
		}
		if( strFieldName.equals("State") ) {
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
		if( strFieldName.equals("BranchType2") ) {
			return 21;
		}
		if( strFieldName.equals("CurrEdorNo") ) {
			return 22;
		}
		if( strFieldName.equals("ModifyReason") ) {
			return 23;
		}
		if( strFieldName.equals("IsJoin") ) {
			return 24;
		}
		if( strFieldName.equals("Salary_Old") ) {
			return 25;
		}
		if( strFieldName.equals("Salary_New") ) {
			return 26;
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
				strFieldName = "AssessType";
				break;
			case 2:
				strFieldName = "AgentCode";
				break;
			case 3:
				strFieldName = "BaseCode";
				break;
			case 4:
				strFieldName = "BranchType";
				break;
			case 5:
				strFieldName = "BranchAttr";
				break;
			case 6:
				strFieldName = "AgentGroup";
				break;
			case 7:
				strFieldName = "ManageCom";
				break;
			case 8:
				strFieldName = "Result";
				break;
			case 9:
				strFieldName = "ModifyFlag";
				break;
			case 10:
				strFieldName = "AgentGrade";
				break;
			case 11:
				strFieldName = "CalAgentGrade";
				break;
			case 12:
				strFieldName = "AgentGrade1";
				break;
			case 13:
				strFieldName = "ConFirmer";
				break;
			case 14:
				strFieldName = "ConFirmDate";
				break;
			case 15:
				strFieldName = "State";
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
				strFieldName = "BranchType2";
				break;
			case 22:
				strFieldName = "CurrEdorNo";
				break;
			case 23:
				strFieldName = "ModifyReason";
				break;
			case 24:
				strFieldName = "IsJoin";
				break;
			case 25:
				strFieldName = "Salary_Old";
				break;
			case 26:
				strFieldName = "Salary_New";
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
		if( strFieldName.equals("AssessType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BaseCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Result") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ModifyFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalAgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ConFirmer") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ConFirmDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("State") ) {
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
		if( strFieldName.equals("BranchType2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CurrEdorNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ModifyReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IsJoin") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Salary_Old") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Salary_New") ) {
			return Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 23:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 24:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 25:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 26:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
