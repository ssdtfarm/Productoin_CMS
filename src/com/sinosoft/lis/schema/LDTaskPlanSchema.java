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
import com.sinosoft.lis.db.LDTaskPlanDB;

/*
 * <p>ClassName: LDTaskPlanSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDTaskPlanSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDTaskPlanSchema.class);
	// @Field
	/** Taskplancode */
	private String TaskPlanCode;
	/** Runflag */
	private String RunFlag;
	/** Recycletype */
	private String RecycleType;
	/** Starttime */
	private String StartTime;
	/** Endtime */
	private String EndTime;
	/** Interval */
	private double Interval;
	/** Times */
	private double Times;
	/** Runstate */
	private String RunState;
	/** Taskcode */
	private String TaskCode;
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
	/** Ipaddress */
	private String IPAddress;
	/** Port */
	private String Port;

	public static final int FIELDNUM = 16;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDTaskPlanSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "TaskPlanCode";

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
		LDTaskPlanSchema cloned = (LDTaskPlanSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getTaskPlanCode()
	{
		return TaskPlanCode;
	}
	public void setTaskPlanCode(String aTaskPlanCode)
	{
		if(aTaskPlanCode!=null && aTaskPlanCode.length()>6)
			throw new IllegalArgumentException("TaskplancodeTaskPlanCode值"+aTaskPlanCode+"的长度"+aTaskPlanCode.length()+"大于最大值6");
		TaskPlanCode = aTaskPlanCode;
	}
	public String getRunFlag()
	{
		return RunFlag;
	}
	public void setRunFlag(String aRunFlag)
	{
		if(aRunFlag!=null && aRunFlag.length()>1)
			throw new IllegalArgumentException("RunflagRunFlag值"+aRunFlag+"的长度"+aRunFlag.length()+"大于最大值1");
		RunFlag = aRunFlag;
	}
	public String getRecycleType()
	{
		return RecycleType;
	}
	public void setRecycleType(String aRecycleType)
	{
		if(aRecycleType!=null && aRecycleType.length()>2)
			throw new IllegalArgumentException("RecycletypeRecycleType值"+aRecycleType+"的长度"+aRecycleType.length()+"大于最大值2");
		RecycleType = aRecycleType;
	}
	public String getStartTime()
	{
		return StartTime;
	}
	public void setStartTime(String aStartTime)
	{
		if(aStartTime!=null && aStartTime.length()>20)
			throw new IllegalArgumentException("StarttimeStartTime值"+aStartTime+"的长度"+aStartTime.length()+"大于最大值20");
		StartTime = aStartTime;
	}
	public String getEndTime()
	{
		return EndTime;
	}
	public void setEndTime(String aEndTime)
	{
		if(aEndTime!=null && aEndTime.length()>20)
			throw new IllegalArgumentException("EndtimeEndTime值"+aEndTime+"的长度"+aEndTime.length()+"大于最大值20");
		EndTime = aEndTime;
	}
	public double getInterval()
	{
		return Interval;
	}
	public void setInterval(double aInterval)
	{
		Interval = aInterval;
	}
	public void setInterval(String aInterval)
	{
		if (aInterval != null && !aInterval.equals(""))
		{
			Double tDouble = new Double(aInterval);
			double d = tDouble.doubleValue();
			Interval = d;
		}
	}

	public double getTimes()
	{
		return Times;
	}
	public void setTimes(double aTimes)
	{
		Times = aTimes;
	}
	public void setTimes(String aTimes)
	{
		if (aTimes != null && !aTimes.equals(""))
		{
			Double tDouble = new Double(aTimes);
			double d = tDouble.doubleValue();
			Times = d;
		}
	}

	public String getRunState()
	{
		return RunState;
	}
	public void setRunState(String aRunState)
	{
		if(aRunState!=null && aRunState.length()>1)
			throw new IllegalArgumentException("RunstateRunState值"+aRunState+"的长度"+aRunState.length()+"大于最大值1");
		RunState = aRunState;
	}
	public String getTaskCode()
	{
		return TaskCode;
	}
	public void setTaskCode(String aTaskCode)
	{
		if(aTaskCode!=null && aTaskCode.length()>6)
			throw new IllegalArgumentException("TaskcodeTaskCode值"+aTaskCode+"的长度"+aTaskCode.length()+"大于最大值6");
		TaskCode = aTaskCode;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>20)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值20");
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
	public String getIPAddress()
	{
		return IPAddress;
	}
	public void setIPAddress(String aIPAddress)
	{
		if(aIPAddress!=null && aIPAddress.length()>25)
			throw new IllegalArgumentException("IpaddressIPAddress值"+aIPAddress+"的长度"+aIPAddress.length()+"大于最大值25");
		IPAddress = aIPAddress;
	}
	public String getPort()
	{
		return Port;
	}
	public void setPort(String aPort)
	{
		if(aPort!=null && aPort.length()>5)
			throw new IllegalArgumentException("PortPort值"+aPort+"的长度"+aPort.length()+"大于最大值5");
		Port = aPort;
	}

	/**
	* 使用另外一个 LDTaskPlanSchema 对象给 Schema 赋值
	* @param: aLDTaskPlanSchema LDTaskPlanSchema
	**/
	public void setSchema(LDTaskPlanSchema aLDTaskPlanSchema)
	{
		this.TaskPlanCode = aLDTaskPlanSchema.getTaskPlanCode();
		this.RunFlag = aLDTaskPlanSchema.getRunFlag();
		this.RecycleType = aLDTaskPlanSchema.getRecycleType();
		this.StartTime = aLDTaskPlanSchema.getStartTime();
		this.EndTime = aLDTaskPlanSchema.getEndTime();
		this.Interval = aLDTaskPlanSchema.getInterval();
		this.Times = aLDTaskPlanSchema.getTimes();
		this.RunState = aLDTaskPlanSchema.getRunState();
		this.TaskCode = aLDTaskPlanSchema.getTaskCode();
		this.Operator = aLDTaskPlanSchema.getOperator();
		this.MakeDate = fDate.getDate( aLDTaskPlanSchema.getMakeDate());
		this.MakeTime = aLDTaskPlanSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLDTaskPlanSchema.getModifyDate());
		this.ModifyTime = aLDTaskPlanSchema.getModifyTime();
		this.IPAddress = aLDTaskPlanSchema.getIPAddress();
		this.Port = aLDTaskPlanSchema.getPort();
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
			if( rs.getString("TaskPlanCode") == null )
				this.TaskPlanCode = null;
			else
				this.TaskPlanCode = rs.getString("TaskPlanCode").trim();

			if( rs.getString("RunFlag") == null )
				this.RunFlag = null;
			else
				this.RunFlag = rs.getString("RunFlag").trim();

			if( rs.getString("RecycleType") == null )
				this.RecycleType = null;
			else
				this.RecycleType = rs.getString("RecycleType").trim();

			if( rs.getString("StartTime") == null )
				this.StartTime = null;
			else
				this.StartTime = rs.getString("StartTime").trim();

			if( rs.getString("EndTime") == null )
				this.EndTime = null;
			else
				this.EndTime = rs.getString("EndTime").trim();

			this.Interval = rs.getDouble("Interval");
			this.Times = rs.getDouble("Times");
			if( rs.getString("RunState") == null )
				this.RunState = null;
			else
				this.RunState = rs.getString("RunState").trim();

			if( rs.getString("TaskCode") == null )
				this.TaskCode = null;
			else
				this.TaskCode = rs.getString("TaskCode").trim();

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

			if( rs.getString("IPAddress") == null )
				this.IPAddress = null;
			else
				this.IPAddress = rs.getString("IPAddress").trim();

			if( rs.getString("Port") == null )
				this.Port = null;
			else
				this.Port = rs.getString("Port").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDTaskPlan表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDTaskPlanSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDTaskPlanSchema getSchema()
	{
		LDTaskPlanSchema aLDTaskPlanSchema = new LDTaskPlanSchema();
		aLDTaskPlanSchema.setSchema(this);
		return aLDTaskPlanSchema;
	}

	public LDTaskPlanDB getDB()
	{
		LDTaskPlanDB aDBOper = new LDTaskPlanDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDTaskPlan描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(TaskPlanCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RunFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RecycleType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(StartTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EndTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Interval));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Times));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RunState)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TaskCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IPAddress)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Port));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDTaskPlan>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			TaskPlanCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			RunFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			RecycleType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			StartTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			EndTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Interval = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,6,SysConst.PACKAGESPILTER))).doubleValue();
			Times = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			RunState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			TaskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			IPAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			Port = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDTaskPlanSchema";
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
		if (FCode.equalsIgnoreCase("TaskPlanCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TaskPlanCode));
		}
		if (FCode.equalsIgnoreCase("RunFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RunFlag));
		}
		if (FCode.equalsIgnoreCase("RecycleType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RecycleType));
		}
		if (FCode.equalsIgnoreCase("StartTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(StartTime));
		}
		if (FCode.equalsIgnoreCase("EndTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EndTime));
		}
		if (FCode.equalsIgnoreCase("Interval"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Interval));
		}
		if (FCode.equalsIgnoreCase("Times"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Times));
		}
		if (FCode.equalsIgnoreCase("RunState"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RunState));
		}
		if (FCode.equalsIgnoreCase("TaskCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TaskCode));
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
		if (FCode.equalsIgnoreCase("IPAddress"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IPAddress));
		}
		if (FCode.equalsIgnoreCase("Port"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Port));
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
				strFieldValue = StrTool.GBKToUnicode(TaskPlanCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(RunFlag);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(RecycleType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(StartTime);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(EndTime);
				break;
			case 5:
				strFieldValue = String.valueOf(Interval);
				break;
			case 6:
				strFieldValue = String.valueOf(Times);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(RunState);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(TaskCode);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(IPAddress);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Port);
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

		if (FCode.equalsIgnoreCase("TaskPlanCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TaskPlanCode = FValue.trim();
			}
			else
				TaskPlanCode = null;
		}
		if (FCode.equalsIgnoreCase("RunFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RunFlag = FValue.trim();
			}
			else
				RunFlag = null;
		}
		if (FCode.equalsIgnoreCase("RecycleType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RecycleType = FValue.trim();
			}
			else
				RecycleType = null;
		}
		if (FCode.equalsIgnoreCase("StartTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				StartTime = FValue.trim();
			}
			else
				StartTime = null;
		}
		if (FCode.equalsIgnoreCase("EndTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EndTime = FValue.trim();
			}
			else
				EndTime = null;
		}
		if (FCode.equalsIgnoreCase("Interval"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Interval = d;
			}
		}
		if (FCode.equalsIgnoreCase("Times"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Times = d;
			}
		}
		if (FCode.equalsIgnoreCase("RunState"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RunState = FValue.trim();
			}
			else
				RunState = null;
		}
		if (FCode.equalsIgnoreCase("TaskCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TaskCode = FValue.trim();
			}
			else
				TaskCode = null;
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
		if (FCode.equalsIgnoreCase("IPAddress"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IPAddress = FValue.trim();
			}
			else
				IPAddress = null;
		}
		if (FCode.equalsIgnoreCase("Port"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Port = FValue.trim();
			}
			else
				Port = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDTaskPlanSchema other = (LDTaskPlanSchema)otherObject;
		return
			TaskPlanCode.equals(other.getTaskPlanCode())
			&& RunFlag.equals(other.getRunFlag())
			&& RecycleType.equals(other.getRecycleType())
			&& StartTime.equals(other.getStartTime())
			&& EndTime.equals(other.getEndTime())
			&& Interval == other.getInterval()
			&& Times == other.getTimes()
			&& RunState.equals(other.getRunState())
			&& TaskCode.equals(other.getTaskCode())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& IPAddress.equals(other.getIPAddress())
			&& Port.equals(other.getPort());
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
		if( strFieldName.equals("TaskPlanCode") ) {
			return 0;
		}
		if( strFieldName.equals("RunFlag") ) {
			return 1;
		}
		if( strFieldName.equals("RecycleType") ) {
			return 2;
		}
		if( strFieldName.equals("StartTime") ) {
			return 3;
		}
		if( strFieldName.equals("EndTime") ) {
			return 4;
		}
		if( strFieldName.equals("Interval") ) {
			return 5;
		}
		if( strFieldName.equals("Times") ) {
			return 6;
		}
		if( strFieldName.equals("RunState") ) {
			return 7;
		}
		if( strFieldName.equals("TaskCode") ) {
			return 8;
		}
		if( strFieldName.equals("Operator") ) {
			return 9;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 10;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 11;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 12;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 13;
		}
		if( strFieldName.equals("IPAddress") ) {
			return 14;
		}
		if( strFieldName.equals("Port") ) {
			return 15;
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
				strFieldName = "TaskPlanCode";
				break;
			case 1:
				strFieldName = "RunFlag";
				break;
			case 2:
				strFieldName = "RecycleType";
				break;
			case 3:
				strFieldName = "StartTime";
				break;
			case 4:
				strFieldName = "EndTime";
				break;
			case 5:
				strFieldName = "Interval";
				break;
			case 6:
				strFieldName = "Times";
				break;
			case 7:
				strFieldName = "RunState";
				break;
			case 8:
				strFieldName = "TaskCode";
				break;
			case 9:
				strFieldName = "Operator";
				break;
			case 10:
				strFieldName = "MakeDate";
				break;
			case 11:
				strFieldName = "MakeTime";
				break;
			case 12:
				strFieldName = "ModifyDate";
				break;
			case 13:
				strFieldName = "ModifyTime";
				break;
			case 14:
				strFieldName = "IPAddress";
				break;
			case 15:
				strFieldName = "Port";
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
		if( strFieldName.equals("TaskPlanCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RunFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RecycleType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StartTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EndTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Interval") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Times") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("RunState") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TaskCode") ) {
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
		if( strFieldName.equals("IPAddress") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Port") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 6:
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
