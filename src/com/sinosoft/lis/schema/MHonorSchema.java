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
import com.sinosoft.lis.db.MHonorDB;

/*
 * <p>ClassName: MHonorSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class MHonorSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(MHonorSchema.class);
	// @Field
	/** Idx */
	private String IDX;
	/** Statyear */
	private String StatYear;
	/** Statbatch */
	private String StatBatch;
	/** Agentcode */
	private String AgentCode;
	/** Agentname */
	private String AgentName;
	/** Agentgrade */
	private String AgentGrade;
	/** Branchattr */
	private String BranchAttr;
	/** Awardtype */
	private String AwardType;
	/** Awardname */
	private String AwardName;
	/** Startdate */
	private Date StartDate;
	/** Enddate */
	private Date EndDate;
	/** Remarks */
	private String Remarks;
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

	public static final int FIELDNUM = 17;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public MHonorSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "IDX";

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
		MHonorSchema cloned = (MHonorSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
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
	public String getStatYear()
	{
		return StatYear;
	}
	public void setStatYear(String aStatYear)
	{
		if(aStatYear!=null && aStatYear.length()>4)
			throw new IllegalArgumentException("StatyearStatYear值"+aStatYear+"的长度"+aStatYear.length()+"大于最大值4");
		StatYear = aStatYear;
	}
	public String getStatBatch()
	{
		return StatBatch;
	}
	public void setStatBatch(String aStatBatch)
	{
		if(aStatBatch!=null && aStatBatch.length()>10)
			throw new IllegalArgumentException("StatbatchStatBatch值"+aStatBatch+"的长度"+aStatBatch.length()+"大于最大值10");
		StatBatch = aStatBatch;
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
	public String getAgentName()
	{
		return AgentName;
	}
	public void setAgentName(String aAgentName)
	{
		if(aAgentName!=null && aAgentName.length()>60)
			throw new IllegalArgumentException("AgentnameAgentName值"+aAgentName+"的长度"+aAgentName.length()+"大于最大值60");
		AgentName = aAgentName;
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
	public String getAwardType()
	{
		return AwardType;
	}
	public void setAwardType(String aAwardType)
	{
		if(aAwardType!=null && aAwardType.length()>20)
			throw new IllegalArgumentException("AwardtypeAwardType值"+aAwardType+"的长度"+aAwardType.length()+"大于最大值20");
		AwardType = aAwardType;
	}
	public String getAwardName()
	{
		return AwardName;
	}
	public void setAwardName(String aAwardName)
	{
		if(aAwardName!=null && aAwardName.length()>100)
			throw new IllegalArgumentException("AwardnameAwardName值"+aAwardName+"的长度"+aAwardName.length()+"大于最大值100");
		AwardName = aAwardName;
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
	* 使用另外一个 MHonorSchema 对象给 Schema 赋值
	* @param: aMHonorSchema MHonorSchema
	**/
	public void setSchema(MHonorSchema aMHonorSchema)
	{
		this.IDX = aMHonorSchema.getIDX();
		this.StatYear = aMHonorSchema.getStatYear();
		this.StatBatch = aMHonorSchema.getStatBatch();
		this.AgentCode = aMHonorSchema.getAgentCode();
		this.AgentName = aMHonorSchema.getAgentName();
		this.AgentGrade = aMHonorSchema.getAgentGrade();
		this.BranchAttr = aMHonorSchema.getBranchAttr();
		this.AwardType = aMHonorSchema.getAwardType();
		this.AwardName = aMHonorSchema.getAwardName();
		this.StartDate = fDate.getDate( aMHonorSchema.getStartDate());
		this.EndDate = fDate.getDate( aMHonorSchema.getEndDate());
		this.Remarks = aMHonorSchema.getRemarks();
		this.Operator = aMHonorSchema.getOperator();
		this.MakeDate = fDate.getDate( aMHonorSchema.getMakeDate());
		this.MakeTime = aMHonorSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aMHonorSchema.getModifyDate());
		this.ModifyTime = aMHonorSchema.getModifyTime();
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
			if( rs.getString("IDX") == null )
				this.IDX = null;
			else
				this.IDX = rs.getString("IDX").trim();

			if( rs.getString("StatYear") == null )
				this.StatYear = null;
			else
				this.StatYear = rs.getString("StatYear").trim();

			if( rs.getString("StatBatch") == null )
				this.StatBatch = null;
			else
				this.StatBatch = rs.getString("StatBatch").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("AgentName") == null )
				this.AgentName = null;
			else
				this.AgentName = rs.getString("AgentName").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("BranchAttr") == null )
				this.BranchAttr = null;
			else
				this.BranchAttr = rs.getString("BranchAttr").trim();

			if( rs.getString("AwardType") == null )
				this.AwardType = null;
			else
				this.AwardType = rs.getString("AwardType").trim();

			if( rs.getString("AwardName") == null )
				this.AwardName = null;
			else
				this.AwardName = rs.getString("AwardName").trim();

			this.StartDate = rs.getDate("StartDate");
			this.EndDate = rs.getDate("EndDate");
			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

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
			logger.debug("数据库中的MHonor表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "MHonorSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public MHonorSchema getSchema()
	{
		MHonorSchema aMHonorSchema = new MHonorSchema();
		aMHonorSchema.setSchema(this);
		return aMHonorSchema;
	}

	public MHonorDB getDB()
	{
		MHonorDB aDBOper = new MHonorDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpMHonor描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(IDX)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(StatYear)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(StatBatch)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AwardName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( StartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EndDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpMHonor>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			IDX = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			StatYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			StatBatch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			AgentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			BranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			AwardType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			AwardName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			StartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			EndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "MHonorSchema";
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
		if (FCode.equalsIgnoreCase("IDX"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDX));
		}
		if (FCode.equalsIgnoreCase("StatYear"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(StatYear));
		}
		if (FCode.equalsIgnoreCase("StatBatch"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(StatBatch));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("AgentName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentName));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAttr));
		}
		if (FCode.equalsIgnoreCase("AwardType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardType));
		}
		if (FCode.equalsIgnoreCase("AwardName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AwardName));
		}
		if (FCode.equalsIgnoreCase("StartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
		}
		if (FCode.equalsIgnoreCase("EndDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
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
				strFieldValue = StrTool.GBKToUnicode(IDX);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(StatYear);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(StatBatch);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(AgentName);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(BranchAttr);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(AwardType);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(AwardName);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
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

		if (FCode.equalsIgnoreCase("IDX"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDX = FValue.trim();
			}
			else
				IDX = null;
		}
		if (FCode.equalsIgnoreCase("StatYear"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				StatYear = FValue.trim();
			}
			else
				StatYear = null;
		}
		if (FCode.equalsIgnoreCase("StatBatch"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				StatBatch = FValue.trim();
			}
			else
				StatBatch = null;
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
		if (FCode.equalsIgnoreCase("AgentName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentName = FValue.trim();
			}
			else
				AgentName = null;
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
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchAttr = FValue.trim();
			}
			else
				BranchAttr = null;
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
		if (FCode.equalsIgnoreCase("AwardName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AwardName = FValue.trim();
			}
			else
				AwardName = null;
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
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Remarks = FValue.trim();
			}
			else
				Remarks = null;
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
		MHonorSchema other = (MHonorSchema)otherObject;
		return
			IDX.equals(other.getIDX())
			&& StatYear.equals(other.getStatYear())
			&& StatBatch.equals(other.getStatBatch())
			&& AgentCode.equals(other.getAgentCode())
			&& AgentName.equals(other.getAgentName())
			&& AgentGrade.equals(other.getAgentGrade())
			&& BranchAttr.equals(other.getBranchAttr())
			&& AwardType.equals(other.getAwardType())
			&& AwardName.equals(other.getAwardName())
			&& fDate.getString(StartDate).equals(other.getStartDate())
			&& fDate.getString(EndDate).equals(other.getEndDate())
			&& Remarks.equals(other.getRemarks())
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
		if( strFieldName.equals("IDX") ) {
			return 0;
		}
		if( strFieldName.equals("StatYear") ) {
			return 1;
		}
		if( strFieldName.equals("StatBatch") ) {
			return 2;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 3;
		}
		if( strFieldName.equals("AgentName") ) {
			return 4;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 5;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return 6;
		}
		if( strFieldName.equals("AwardType") ) {
			return 7;
		}
		if( strFieldName.equals("AwardName") ) {
			return 8;
		}
		if( strFieldName.equals("StartDate") ) {
			return 9;
		}
		if( strFieldName.equals("EndDate") ) {
			return 10;
		}
		if( strFieldName.equals("Remarks") ) {
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
				strFieldName = "IDX";
				break;
			case 1:
				strFieldName = "StatYear";
				break;
			case 2:
				strFieldName = "StatBatch";
				break;
			case 3:
				strFieldName = "AgentCode";
				break;
			case 4:
				strFieldName = "AgentName";
				break;
			case 5:
				strFieldName = "AgentGrade";
				break;
			case 6:
				strFieldName = "BranchAttr";
				break;
			case 7:
				strFieldName = "AwardType";
				break;
			case 8:
				strFieldName = "AwardName";
				break;
			case 9:
				strFieldName = "StartDate";
				break;
			case 10:
				strFieldName = "EndDate";
				break;
			case 11:
				strFieldName = "Remarks";
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
		if( strFieldName.equals("IDX") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StatYear") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StatBatch") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AwardName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("EndDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Remarks") ) {
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
