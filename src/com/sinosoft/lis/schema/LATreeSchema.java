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
import com.sinosoft.lis.db.LATreeDB;

/*
 * <p>ClassName: LATreeSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LATreeSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LATreeSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Branchtype */
	private String BranchType;
	/** Agentgroup */
	private String AgentGroup;
	/** Managecom */
	private String ManageCom;
	/** Agentgrade */
	private String AgentGrade;
	/** Gradestartdate */
	private Date GradeStartDate;
	/** Agentsubgrade */
	private String AgentSubGrade;
	/** Subgradestartdate */
	private Date SubGradeStartDate;
	/** Effectivedate */
	private Date EffectiveDate;
	/** Transfereffectivedate */
	private Date TransferEffectiveDate;
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

	public static final int FIELDNUM = 15;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LATreeSchema()
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
		LATreeSchema cloned = (LATreeSchema)super.clone();
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
	/**
	* BranchType
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
	* AgentGroup
	*/
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
	/**
	* ManageCom
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
	* 代理人职级【Agent Title，下拉A01-SDD】
	*/
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
	/**
	* 职级起始日
	*/
	public String getGradeStartDate()
	{
		if( GradeStartDate != null )
			return fDate.getString(GradeStartDate);
		else
			return null;
	}
	public void setGradeStartDate(Date aGradeStartDate)
	{
		GradeStartDate = aGradeStartDate;
	}
	public void setGradeStartDate(String aGradeStartDate)
	{
		if (aGradeStartDate != null && !aGradeStartDate.equals("") )
		{
			GradeStartDate = fDate.getDate( aGradeStartDate );
		}
		else
			GradeStartDate = null;
	}

	/**
	* 代理人子职级
	*/
	public String getAgentSubGrade()
	{
		return AgentSubGrade;
	}
	public void setAgentSubGrade(String aAgentSubGrade)
	{
		if(aAgentSubGrade!=null && aAgentSubGrade.length()>10)
			throw new IllegalArgumentException("AgentsubgradeAgentSubGrade值"+aAgentSubGrade+"的长度"+aAgentSubGrade.length()+"大于最大值10");
		AgentSubGrade = aAgentSubGrade;
	}
	/**
	* 子职级起始日
	*/
	public String getSubGradeStartDate()
	{
		if( SubGradeStartDate != null )
			return fDate.getString(SubGradeStartDate);
		else
			return null;
	}
	public void setSubGradeStartDate(Date aSubGradeStartDate)
	{
		SubGradeStartDate = aSubGradeStartDate;
	}
	public void setSubGradeStartDate(String aSubGradeStartDate)
	{
		if (aSubGradeStartDate != null && !aSubGradeStartDate.equals("") )
		{
			SubGradeStartDate = fDate.getDate( aSubGradeStartDate );
		}
		else
			SubGradeStartDate = null;
	}

	/**
	* EffectiveDate
	*/
	public String getEffectiveDate()
	{
		if( EffectiveDate != null )
			return fDate.getString(EffectiveDate);
		else
			return null;
	}
	public void setEffectiveDate(Date aEffectiveDate)
	{
		EffectiveDate = aEffectiveDate;
	}
	public void setEffectiveDate(String aEffectiveDate)
	{
		if (aEffectiveDate != null && !aEffectiveDate.equals("") )
		{
			EffectiveDate = fDate.getDate( aEffectiveDate );
		}
		else
			EffectiveDate = null;
	}

	/**
	* TransferEffectiveDate
	*/
	public String getTransferEffectiveDate()
	{
		if( TransferEffectiveDate != null )
			return fDate.getString(TransferEffectiveDate);
		else
			return null;
	}
	public void setTransferEffectiveDate(Date aTransferEffectiveDate)
	{
		TransferEffectiveDate = aTransferEffectiveDate;
	}
	public void setTransferEffectiveDate(String aTransferEffectiveDate)
	{
		if (aTransferEffectiveDate != null && !aTransferEffectiveDate.equals("") )
		{
			TransferEffectiveDate = fDate.getDate( aTransferEffectiveDate );
		}
		else
			TransferEffectiveDate = null;
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
	* 使用另外一个 LATreeSchema 对象给 Schema 赋值
	* @param: aLATreeSchema LATreeSchema
	**/
	public void setSchema(LATreeSchema aLATreeSchema)
	{
		this.AgentCode = aLATreeSchema.getAgentCode();
		this.BranchType = aLATreeSchema.getBranchType();
		this.AgentGroup = aLATreeSchema.getAgentGroup();
		this.ManageCom = aLATreeSchema.getManageCom();
		this.AgentGrade = aLATreeSchema.getAgentGrade();
		this.GradeStartDate = fDate.getDate( aLATreeSchema.getGradeStartDate());
		this.AgentSubGrade = aLATreeSchema.getAgentSubGrade();
		this.SubGradeStartDate = fDate.getDate( aLATreeSchema.getSubGradeStartDate());
		this.EffectiveDate = fDate.getDate( aLATreeSchema.getEffectiveDate());
		this.TransferEffectiveDate = fDate.getDate( aLATreeSchema.getTransferEffectiveDate());
		this.Operator = aLATreeSchema.getOperator();
		this.MakeDate = fDate.getDate( aLATreeSchema.getMakeDate());
		this.MakeTime = aLATreeSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLATreeSchema.getModifyDate());
		this.ModifyTime = aLATreeSchema.getModifyTime();
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

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			this.GradeStartDate = rs.getDate("GradeStartDate");
			if( rs.getString("AgentSubGrade") == null )
				this.AgentSubGrade = null;
			else
				this.AgentSubGrade = rs.getString("AgentSubGrade").trim();

			this.SubGradeStartDate = rs.getDate("SubGradeStartDate");
			this.EffectiveDate = rs.getDate("EffectiveDate");
			this.TransferEffectiveDate = rs.getDate("TransferEffectiveDate");
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
			logger.debug("数据库中的LATree表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LATreeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LATreeSchema getSchema()
	{
		LATreeSchema aLATreeSchema = new LATreeSchema();
		aLATreeSchema.setSchema(this);
		return aLATreeSchema;
	}

	public LATreeDB getDB()
	{
		LATreeDB aDBOper = new LATreeDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLATree描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( GradeStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentSubGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( SubGradeStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( TransferEffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLATree>历史记账凭证主表信息</A>表字段
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
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			GradeStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			AgentSubGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			SubGradeStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			EffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			TransferEffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LATreeSchema";
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
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("GradeStartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getGradeStartDate()));
		}
		if (FCode.equalsIgnoreCase("AgentSubGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentSubGrade));
		}
		if (FCode.equalsIgnoreCase("SubGradeStartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getSubGradeStartDate()));
		}
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
		}
		if (FCode.equalsIgnoreCase("TransferEffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getTransferEffectiveDate()));
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
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getGradeStartDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentSubGrade);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getSubGradeStartDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getTransferEffectiveDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 14:
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
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ManageCom = FValue.trim();
			}
			else
				ManageCom = null;
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
		if (FCode.equalsIgnoreCase("GradeStartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				GradeStartDate = fDate.getDate( FValue );
			}
			else
				GradeStartDate = null;
		}
		if (FCode.equalsIgnoreCase("AgentSubGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentSubGrade = FValue.trim();
			}
			else
				AgentSubGrade = null;
		}
		if (FCode.equalsIgnoreCase("SubGradeStartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				SubGradeStartDate = fDate.getDate( FValue );
			}
			else
				SubGradeStartDate = null;
		}
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				EffectiveDate = fDate.getDate( FValue );
			}
			else
				EffectiveDate = null;
		}
		if (FCode.equalsIgnoreCase("TransferEffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				TransferEffectiveDate = fDate.getDate( FValue );
			}
			else
				TransferEffectiveDate = null;
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
		LATreeSchema other = (LATreeSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& BranchType.equals(other.getBranchType())
			&& AgentGroup.equals(other.getAgentGroup())
			&& ManageCom.equals(other.getManageCom())
			&& AgentGrade.equals(other.getAgentGrade())
			&& fDate.getString(GradeStartDate).equals(other.getGradeStartDate())
			&& AgentSubGrade.equals(other.getAgentSubGrade())
			&& fDate.getString(SubGradeStartDate).equals(other.getSubGradeStartDate())
			&& fDate.getString(EffectiveDate).equals(other.getEffectiveDate())
			&& fDate.getString(TransferEffectiveDate).equals(other.getTransferEffectiveDate())
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
		if( strFieldName.equals("ManageCom") ) {
			return 3;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 4;
		}
		if( strFieldName.equals("GradeStartDate") ) {
			return 5;
		}
		if( strFieldName.equals("AgentSubGrade") ) {
			return 6;
		}
		if( strFieldName.equals("SubGradeStartDate") ) {
			return 7;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return 8;
		}
		if( strFieldName.equals("TransferEffectiveDate") ) {
			return 9;
		}
		if( strFieldName.equals("Operator") ) {
			return 10;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 11;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 12;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 13;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 14;
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
				strFieldName = "ManageCom";
				break;
			case 4:
				strFieldName = "AgentGrade";
				break;
			case 5:
				strFieldName = "GradeStartDate";
				break;
			case 6:
				strFieldName = "AgentSubGrade";
				break;
			case 7:
				strFieldName = "SubGradeStartDate";
				break;
			case 8:
				strFieldName = "EffectiveDate";
				break;
			case 9:
				strFieldName = "TransferEffectiveDate";
				break;
			case 10:
				strFieldName = "Operator";
				break;
			case 11:
				strFieldName = "MakeDate";
				break;
			case 12:
				strFieldName = "MakeTime";
				break;
			case 13:
				strFieldName = "ModifyDate";
				break;
			case 14:
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
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeStartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("AgentSubGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubGradeStartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("TransferEffectiveDate") ) {
			return Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_DATE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
