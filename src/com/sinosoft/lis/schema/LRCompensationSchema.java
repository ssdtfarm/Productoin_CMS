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
import com.sinosoft.lis.db.LRCompensationDB;

/*
 * <p>ClassName: LRCompensationSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LRCompensation_Setting
 */
public class LRCompensationSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LRCompensationSchema.class);
	// @Field
	/** Compensationid */
	private double CompensationId;
	/** Managecom */
	private String ManageCom;
	/** Branchtype */
	private String BranchType;
	/** Agentcode */
	private String AgentCode;
	/** Calmonthyear */
	private String CalMonthYear;
	/** Branchattr */
	private String BranchAttr;
	/** Filepath */
	private String FilePath;
	/** Filename */
	private String FileName;
	/** Caltype */
	private String CalType;
	/** Batchstartdate */
	private Date BatchStartDate;
	/** Batchstarttime */
	private String BatchStartTime;
	/** Batchenddate */
	private Date BatchEndDate;
	/** Batchendtime */
	private String BatchEndTime;
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

	public static final int FIELDNUM = 18;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LRCompensationSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[3];
		pk[0] = "CompensationId";
		pk[1] = "AgentCode";
		pk[2] = "CalMonthYear";

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
		LRCompensationSchema cloned = (LRCompensationSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public double getCompensationId()
	{
		return CompensationId;
	}
	public void setCompensationId(double aCompensationId)
	{
		CompensationId = aCompensationId;
	}
	public void setCompensationId(String aCompensationId)
	{
		if (aCompensationId != null && !aCompensationId.equals(""))
		{
			Double tDouble = new Double(aCompensationId);
			double d = tDouble.doubleValue();
			CompensationId = d;
		}
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
	public String getCalMonthYear()
	{
		return CalMonthYear;
	}
	public void setCalMonthYear(String aCalMonthYear)
	{
		if(aCalMonthYear!=null && aCalMonthYear.length()>6)
			throw new IllegalArgumentException("CalmonthyearCalMonthYear值"+aCalMonthYear+"的长度"+aCalMonthYear.length()+"大于最大值6");
		CalMonthYear = aCalMonthYear;
	}
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
	public String getFilePath()
	{
		return FilePath;
	}
	public void setFilePath(String aFilePath)
	{
		if(aFilePath!=null && aFilePath.length()>500)
			throw new IllegalArgumentException("FilepathFilePath值"+aFilePath+"的长度"+aFilePath.length()+"大于最大值500");
		FilePath = aFilePath;
	}
	public String getFileName()
	{
		return FileName;
	}
	public void setFileName(String aFileName)
	{
		if(aFileName!=null && aFileName.length()>500)
			throw new IllegalArgumentException("FilenameFileName值"+aFileName+"的长度"+aFileName.length()+"大于最大值500");
		FileName = aFileName;
	}
	public String getCalType()
	{
		return CalType;
	}
	public void setCalType(String aCalType)
	{
		if(aCalType!=null && aCalType.length()>2)
			throw new IllegalArgumentException("CaltypeCalType值"+aCalType+"的长度"+aCalType.length()+"大于最大值2");
		CalType = aCalType;
	}
	public String getBatchStartDate()
	{
		if( BatchStartDate != null )
			return fDate.getString(BatchStartDate);
		else
			return null;
	}
	public void setBatchStartDate(Date aBatchStartDate)
	{
		BatchStartDate = aBatchStartDate;
	}
	public void setBatchStartDate(String aBatchStartDate)
	{
		if (aBatchStartDate != null && !aBatchStartDate.equals("") )
		{
			BatchStartDate = fDate.getDate( aBatchStartDate );
		}
		else
			BatchStartDate = null;
	}

	public String getBatchStartTime()
	{
		return BatchStartTime;
	}
	public void setBatchStartTime(String aBatchStartTime)
	{
		if(aBatchStartTime!=null && aBatchStartTime.length()>8)
			throw new IllegalArgumentException("BatchstarttimeBatchStartTime值"+aBatchStartTime+"的长度"+aBatchStartTime.length()+"大于最大值8");
		BatchStartTime = aBatchStartTime;
	}
	public String getBatchEndDate()
	{
		if( BatchEndDate != null )
			return fDate.getString(BatchEndDate);
		else
			return null;
	}
	public void setBatchEndDate(Date aBatchEndDate)
	{
		BatchEndDate = aBatchEndDate;
	}
	public void setBatchEndDate(String aBatchEndDate)
	{
		if (aBatchEndDate != null && !aBatchEndDate.equals("") )
		{
			BatchEndDate = fDate.getDate( aBatchEndDate );
		}
		else
			BatchEndDate = null;
	}

	public String getBatchEndTime()
	{
		return BatchEndTime;
	}
	public void setBatchEndTime(String aBatchEndTime)
	{
		if(aBatchEndTime!=null && aBatchEndTime.length()>8)
			throw new IllegalArgumentException("BatchendtimeBatchEndTime值"+aBatchEndTime+"的长度"+aBatchEndTime.length()+"大于最大值8");
		BatchEndTime = aBatchEndTime;
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
	* 使用另外一个 LRCompensationSchema 对象给 Schema 赋值
	* @param: aLRCompensationSchema LRCompensationSchema
	**/
	public void setSchema(LRCompensationSchema aLRCompensationSchema)
	{
		this.CompensationId = aLRCompensationSchema.getCompensationId();
		this.ManageCom = aLRCompensationSchema.getManageCom();
		this.BranchType = aLRCompensationSchema.getBranchType();
		this.AgentCode = aLRCompensationSchema.getAgentCode();
		this.CalMonthYear = aLRCompensationSchema.getCalMonthYear();
		this.BranchAttr = aLRCompensationSchema.getBranchAttr();
		this.FilePath = aLRCompensationSchema.getFilePath();
		this.FileName = aLRCompensationSchema.getFileName();
		this.CalType = aLRCompensationSchema.getCalType();
		this.BatchStartDate = fDate.getDate( aLRCompensationSchema.getBatchStartDate());
		this.BatchStartTime = aLRCompensationSchema.getBatchStartTime();
		this.BatchEndDate = fDate.getDate( aLRCompensationSchema.getBatchEndDate());
		this.BatchEndTime = aLRCompensationSchema.getBatchEndTime();
		this.Operator = aLRCompensationSchema.getOperator();
		this.MakeDate = fDate.getDate( aLRCompensationSchema.getMakeDate());
		this.MakeTime = aLRCompensationSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLRCompensationSchema.getModifyDate());
		this.ModifyTime = aLRCompensationSchema.getModifyTime();
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
			this.CompensationId = rs.getDouble("CompensationId");
			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("CalMonthYear") == null )
				this.CalMonthYear = null;
			else
				this.CalMonthYear = rs.getString("CalMonthYear").trim();

			if( rs.getString("BranchAttr") == null )
				this.BranchAttr = null;
			else
				this.BranchAttr = rs.getString("BranchAttr").trim();

			if( rs.getString("FilePath") == null )
				this.FilePath = null;
			else
				this.FilePath = rs.getString("FilePath").trim();

			if( rs.getString("FileName") == null )
				this.FileName = null;
			else
				this.FileName = rs.getString("FileName").trim();

			if( rs.getString("CalType") == null )
				this.CalType = null;
			else
				this.CalType = rs.getString("CalType").trim();

			this.BatchStartDate = rs.getDate("BatchStartDate");
			if( rs.getString("BatchStartTime") == null )
				this.BatchStartTime = null;
			else
				this.BatchStartTime = rs.getString("BatchStartTime").trim();

			this.BatchEndDate = rs.getDate("BatchEndDate");
			if( rs.getString("BatchEndTime") == null )
				this.BatchEndTime = null;
			else
				this.BatchEndTime = rs.getString("BatchEndTime").trim();

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
			logger.debug("数据库中的LRCompensation表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRCompensationSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LRCompensationSchema getSchema()
	{
		LRCompensationSchema aLRCompensationSchema = new LRCompensationSchema();
		aLRCompensationSchema.setSchema(this);
		return aLRCompensationSchema;
	}

	public LRCompensationDB getDB()
	{
		LRCompensationDB aDBOper = new LRCompensationDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRCompensation描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append( ChgData.chgData(CompensationId));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalMonthYear)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FilePath)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FileName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BatchStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BatchStartTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BatchEndDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BatchEndTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRCompensation>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			CompensationId = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,1,SysConst.PACKAGESPILTER))).doubleValue();
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			CalMonthYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			BranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			FilePath = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			FileName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			CalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			BatchStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			BatchStartTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			BatchEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			BatchEndTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRCompensationSchema";
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
		if (FCode.equalsIgnoreCase("CompensationId"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CompensationId));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("CalMonthYear"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalMonthYear));
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAttr));
		}
		if (FCode.equalsIgnoreCase("FilePath"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FilePath));
		}
		if (FCode.equalsIgnoreCase("FileName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FileName));
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalType));
		}
		if (FCode.equalsIgnoreCase("BatchStartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBatchStartDate()));
		}
		if (FCode.equalsIgnoreCase("BatchStartTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BatchStartTime));
		}
		if (FCode.equalsIgnoreCase("BatchEndDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBatchEndDate()));
		}
		if (FCode.equalsIgnoreCase("BatchEndTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BatchEndTime));
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
				strFieldValue = String.valueOf(CompensationId);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(CalMonthYear);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(BranchAttr);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(FilePath);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(FileName);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(CalType);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBatchStartDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(BatchStartTime);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBatchEndDate()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(BatchEndTime);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 17:
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

		if (FCode.equalsIgnoreCase("CompensationId"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				CompensationId = d;
			}
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
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("CalMonthYear"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalMonthYear = FValue.trim();
			}
			else
				CalMonthYear = null;
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
		if (FCode.equalsIgnoreCase("FilePath"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FilePath = FValue.trim();
			}
			else
				FilePath = null;
		}
		if (FCode.equalsIgnoreCase("FileName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FileName = FValue.trim();
			}
			else
				FileName = null;
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalType = FValue.trim();
			}
			else
				CalType = null;
		}
		if (FCode.equalsIgnoreCase("BatchStartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BatchStartDate = fDate.getDate( FValue );
			}
			else
				BatchStartDate = null;
		}
		if (FCode.equalsIgnoreCase("BatchStartTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BatchStartTime = FValue.trim();
			}
			else
				BatchStartTime = null;
		}
		if (FCode.equalsIgnoreCase("BatchEndDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BatchEndDate = fDate.getDate( FValue );
			}
			else
				BatchEndDate = null;
		}
		if (FCode.equalsIgnoreCase("BatchEndTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BatchEndTime = FValue.trim();
			}
			else
				BatchEndTime = null;
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
		LRCompensationSchema other = (LRCompensationSchema)otherObject;
		return
			CompensationId == other.getCompensationId()
			&& ManageCom.equals(other.getManageCom())
			&& BranchType.equals(other.getBranchType())
			&& AgentCode.equals(other.getAgentCode())
			&& CalMonthYear.equals(other.getCalMonthYear())
			&& BranchAttr.equals(other.getBranchAttr())
			&& FilePath.equals(other.getFilePath())
			&& FileName.equals(other.getFileName())
			&& CalType.equals(other.getCalType())
			&& fDate.getString(BatchStartDate).equals(other.getBatchStartDate())
			&& BatchStartTime.equals(other.getBatchStartTime())
			&& fDate.getString(BatchEndDate).equals(other.getBatchEndDate())
			&& BatchEndTime.equals(other.getBatchEndTime())
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
		if( strFieldName.equals("CompensationId") ) {
			return 0;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 1;
		}
		if( strFieldName.equals("BranchType") ) {
			return 2;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 3;
		}
		if( strFieldName.equals("CalMonthYear") ) {
			return 4;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return 5;
		}
		if( strFieldName.equals("FilePath") ) {
			return 6;
		}
		if( strFieldName.equals("FileName") ) {
			return 7;
		}
		if( strFieldName.equals("CalType") ) {
			return 8;
		}
		if( strFieldName.equals("BatchStartDate") ) {
			return 9;
		}
		if( strFieldName.equals("BatchStartTime") ) {
			return 10;
		}
		if( strFieldName.equals("BatchEndDate") ) {
			return 11;
		}
		if( strFieldName.equals("BatchEndTime") ) {
			return 12;
		}
		if( strFieldName.equals("Operator") ) {
			return 13;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 14;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 15;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 16;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 17;
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
				strFieldName = "CompensationId";
				break;
			case 1:
				strFieldName = "ManageCom";
				break;
			case 2:
				strFieldName = "BranchType";
				break;
			case 3:
				strFieldName = "AgentCode";
				break;
			case 4:
				strFieldName = "CalMonthYear";
				break;
			case 5:
				strFieldName = "BranchAttr";
				break;
			case 6:
				strFieldName = "FilePath";
				break;
			case 7:
				strFieldName = "FileName";
				break;
			case 8:
				strFieldName = "CalType";
				break;
			case 9:
				strFieldName = "BatchStartDate";
				break;
			case 10:
				strFieldName = "BatchStartTime";
				break;
			case 11:
				strFieldName = "BatchEndDate";
				break;
			case 12:
				strFieldName = "BatchEndTime";
				break;
			case 13:
				strFieldName = "Operator";
				break;
			case 14:
				strFieldName = "MakeDate";
				break;
			case 15:
				strFieldName = "MakeTime";
				break;
			case 16:
				strFieldName = "ModifyDate";
				break;
			case 17:
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
		if( strFieldName.equals("CompensationId") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalMonthYear") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FilePath") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FileName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BatchStartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BatchStartTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BatchEndDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BatchEndTime") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
