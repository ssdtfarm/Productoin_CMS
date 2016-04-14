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
import com.sinosoft.lis.db.LADimissionBDB;

/*
 * <p>ClassName: LADimissionBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LADimissionBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LADimissionBSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Managecom */
	private String ManageCom;
	/** Branchtype */
	private String Branchtype;
	/** Terminationnum */
	private double TerminationNum;
	/** Reason */
	private String Reason;
	/** Outworkdate */
	private Date OutWorkDate;
	/** Endflag */
	private String EndFlag;
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
	/** Operaotr1 */
	private String Operaotr1;
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;

	public static final int FIELDNUM = 16;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LADimissionBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[3];
		pk[0] = "Operaotr1";
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
		LADimissionBSchema cloned = (LADimissionBSchema)super.clone();
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
		if(aAgentCode!=null && aAgentCode.length()>10)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值10");
		AgentCode = aAgentCode;
	}
	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>12)
			throw new IllegalArgumentException("ManagecomManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值12");
		ManageCom = aManageCom;
	}
	public String getBranchtype()
	{
		return Branchtype;
	}
	public void setBranchtype(String aBranchtype)
	{
		if(aBranchtype!=null && aBranchtype.length()>2)
			throw new IllegalArgumentException("BranchtypeBranchtype值"+aBranchtype+"的长度"+aBranchtype.length()+"大于最大值2");
		Branchtype = aBranchtype;
	}
	public double getTerminationNum()
	{
		return TerminationNum;
	}
	public void setTerminationNum(double aTerminationNum)
	{
		TerminationNum = aTerminationNum;
	}
	public void setTerminationNum(String aTerminationNum)
	{
		if (aTerminationNum != null && !aTerminationNum.equals(""))
		{
			Double tDouble = new Double(aTerminationNum);
			double d = tDouble.doubleValue();
			TerminationNum = d;
		}
	}

	public String getReason()
	{
		return Reason;
	}
	public void setReason(String aReason)
	{
		if(aReason!=null && aReason.length()>2)
			throw new IllegalArgumentException("ReasonReason值"+aReason+"的长度"+aReason.length()+"大于最大值2");
		Reason = aReason;
	}
	public String getOutWorkDate()
	{
		if( OutWorkDate != null )
			return fDate.getString(OutWorkDate);
		else
			return null;
	}
	public void setOutWorkDate(Date aOutWorkDate)
	{
		OutWorkDate = aOutWorkDate;
	}
	public void setOutWorkDate(String aOutWorkDate)
	{
		if (aOutWorkDate != null && !aOutWorkDate.equals("") )
		{
			OutWorkDate = fDate.getDate( aOutWorkDate );
		}
		else
			OutWorkDate = null;
	}

	public String getEndFlag()
	{
		return EndFlag;
	}
	public void setEndFlag(String aEndFlag)
	{
		if(aEndFlag!=null && aEndFlag.length()>2)
			throw new IllegalArgumentException("EndflagEndFlag值"+aEndFlag+"的长度"+aEndFlag.length()+"大于最大值2");
		EndFlag = aEndFlag;
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
	public String getOperaotr1()
	{
		return Operaotr1;
	}
	public void setOperaotr1(String aOperaotr1)
	{
		if(aOperaotr1!=null && aOperaotr1.length()>10)
			throw new IllegalArgumentException("Operaotr1Operaotr1值"+aOperaotr1+"的长度"+aOperaotr1.length()+"大于最大值10");
		Operaotr1 = aOperaotr1;
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
	* 使用另外一个 LADimissionBSchema 对象给 Schema 赋值
	* @param: aLADimissionBSchema LADimissionBSchema
	**/
	public void setSchema(LADimissionBSchema aLADimissionBSchema)
	{
		this.AgentCode = aLADimissionBSchema.getAgentCode();
		this.ManageCom = aLADimissionBSchema.getManageCom();
		this.Branchtype = aLADimissionBSchema.getBranchtype();
		this.TerminationNum = aLADimissionBSchema.getTerminationNum();
		this.Reason = aLADimissionBSchema.getReason();
		this.OutWorkDate = fDate.getDate( aLADimissionBSchema.getOutWorkDate());
		this.EndFlag = aLADimissionBSchema.getEndFlag();
		this.Remarks = aLADimissionBSchema.getRemarks();
		this.Operator = aLADimissionBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLADimissionBSchema.getMakeDate());
		this.MakeTime = aLADimissionBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLADimissionBSchema.getModifyDate());
		this.ModifyTime = aLADimissionBSchema.getModifyTime();
		this.Operaotr1 = aLADimissionBSchema.getOperaotr1();
		this.MakeDate1 = fDate.getDate( aLADimissionBSchema.getMakeDate1());
		this.MakeTime1 = aLADimissionBSchema.getMakeTime1();
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

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("Branchtype") == null )
				this.Branchtype = null;
			else
				this.Branchtype = rs.getString("Branchtype").trim();

			this.TerminationNum = rs.getDouble("TerminationNum");
			if( rs.getString("Reason") == null )
				this.Reason = null;
			else
				this.Reason = rs.getString("Reason").trim();

			this.OutWorkDate = rs.getDate("OutWorkDate");
			if( rs.getString("EndFlag") == null )
				this.EndFlag = null;
			else
				this.EndFlag = rs.getString("EndFlag").trim();

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

			if( rs.getString("Operaotr1") == null )
				this.Operaotr1 = null;
			else
				this.Operaotr1 = rs.getString("Operaotr1").trim();

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LADimissionB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LADimissionBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LADimissionBSchema getSchema()
	{
		LADimissionBSchema aLADimissionBSchema = new LADimissionBSchema();
		aLADimissionBSchema.setSchema(this);
		return aLADimissionBSchema;
	}

	public LADimissionBDB getDB()
	{
		LADimissionBDB aDBOper = new LADimissionBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLADimissionB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Branchtype)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(TerminationNum));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Reason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( OutWorkDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EndFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operaotr1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLADimissionB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			Branchtype = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			TerminationNum = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,4,SysConst.PACKAGESPILTER))).doubleValue();
			Reason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			OutWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			EndFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Operaotr1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LADimissionBSchema";
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
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("Branchtype"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Branchtype));
		}
		if (FCode.equalsIgnoreCase("TerminationNum"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TerminationNum));
		}
		if (FCode.equalsIgnoreCase("Reason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Reason));
		}
		if (FCode.equalsIgnoreCase("OutWorkDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getOutWorkDate()));
		}
		if (FCode.equalsIgnoreCase("EndFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EndFlag));
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
		if (FCode.equalsIgnoreCase("Operaotr1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operaotr1));
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
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(Branchtype);
				break;
			case 3:
				strFieldValue = String.valueOf(TerminationNum);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Reason);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getOutWorkDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(EndFlag);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Operaotr1);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 15:
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
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ManageCom = FValue.trim();
			}
			else
				ManageCom = null;
		}
		if (FCode.equalsIgnoreCase("Branchtype"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Branchtype = FValue.trim();
			}
			else
				Branchtype = null;
		}
		if (FCode.equalsIgnoreCase("TerminationNum"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				TerminationNum = d;
			}
		}
		if (FCode.equalsIgnoreCase("Reason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Reason = FValue.trim();
			}
			else
				Reason = null;
		}
		if (FCode.equalsIgnoreCase("OutWorkDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				OutWorkDate = fDate.getDate( FValue );
			}
			else
				OutWorkDate = null;
		}
		if (FCode.equalsIgnoreCase("EndFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EndFlag = FValue.trim();
			}
			else
				EndFlag = null;
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
		if (FCode.equalsIgnoreCase("Operaotr1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operaotr1 = FValue.trim();
			}
			else
				Operaotr1 = null;
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
		LADimissionBSchema other = (LADimissionBSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& ManageCom.equals(other.getManageCom())
			&& Branchtype.equals(other.getBranchtype())
			&& TerminationNum == other.getTerminationNum()
			&& Reason.equals(other.getReason())
			&& fDate.getString(OutWorkDate).equals(other.getOutWorkDate())
			&& EndFlag.equals(other.getEndFlag())
			&& Remarks.equals(other.getRemarks())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operaotr1.equals(other.getOperaotr1())
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
		if( strFieldName.equals("ManageCom") ) {
			return 1;
		}
		if( strFieldName.equals("Branchtype") ) {
			return 2;
		}
		if( strFieldName.equals("TerminationNum") ) {
			return 3;
		}
		if( strFieldName.equals("Reason") ) {
			return 4;
		}
		if( strFieldName.equals("OutWorkDate") ) {
			return 5;
		}
		if( strFieldName.equals("EndFlag") ) {
			return 6;
		}
		if( strFieldName.equals("Remarks") ) {
			return 7;
		}
		if( strFieldName.equals("Operator") ) {
			return 8;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 9;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 10;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 11;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 12;
		}
		if( strFieldName.equals("Operaotr1") ) {
			return 13;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 14;
		}
		if( strFieldName.equals("MakeTime1") ) {
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
				strFieldName = "AgentCode";
				break;
			case 1:
				strFieldName = "ManageCom";
				break;
			case 2:
				strFieldName = "Branchtype";
				break;
			case 3:
				strFieldName = "TerminationNum";
				break;
			case 4:
				strFieldName = "Reason";
				break;
			case 5:
				strFieldName = "OutWorkDate";
				break;
			case 6:
				strFieldName = "EndFlag";
				break;
			case 7:
				strFieldName = "Remarks";
				break;
			case 8:
				strFieldName = "Operator";
				break;
			case 9:
				strFieldName = "MakeDate";
				break;
			case 10:
				strFieldName = "MakeTime";
				break;
			case 11:
				strFieldName = "ModifyDate";
				break;
			case 12:
				strFieldName = "ModifyTime";
				break;
			case 13:
				strFieldName = "Operaotr1";
				break;
			case 14:
				strFieldName = "MakeDate1";
				break;
			case 15:
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
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Branchtype") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TerminationNum") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Reason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OutWorkDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("EndFlag") ) {
			return Schema.TYPE_STRING;
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
		if( strFieldName.equals("Operaotr1") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
