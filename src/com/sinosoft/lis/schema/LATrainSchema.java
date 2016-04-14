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
import com.sinosoft.lis.db.LATrainDB;

/*
 * <p>ClassName: LATrainSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LATrainSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LATrainSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Branchtype */
	private String BranchType;
	/** Openclassid */
	private String OpenClassID;
	/** Managecom */
	private String Managecom;
	/** Resultlevel */
	private String ResultLevel;
	/** Result */
	private double Result;
	/** Trainpassflag */
	private String TrainPassFlag;
	/** Remarks */
	private String Remarks;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;
	/** Operator */
	private String Operator;

	public static final int FIELDNUM = 13;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LATrainSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[3];
		pk[0] = "AgentCode";
		pk[1] = "BranchType";
		pk[2] = "OpenClassID";

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
		LATrainSchema cloned = (LATrainSchema)super.clone();
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
	public String getOpenClassID()
	{
		return OpenClassID;
	}
	public void setOpenClassID(String aOpenClassID)
	{
		if(aOpenClassID!=null && aOpenClassID.length()>20)
			throw new IllegalArgumentException("OpenclassidOpenClassID值"+aOpenClassID+"的长度"+aOpenClassID.length()+"大于最大值20");
		OpenClassID = aOpenClassID;
	}
	public String getManagecom()
	{
		return Managecom;
	}
	public void setManagecom(String aManagecom)
	{
		if(aManagecom!=null && aManagecom.length()>10)
			throw new IllegalArgumentException("ManagecomManagecom值"+aManagecom+"的长度"+aManagecom.length()+"大于最大值10");
		Managecom = aManagecom;
	}
	public String getResultLevel()
	{
		return ResultLevel;
	}
	public void setResultLevel(String aResultLevel)
	{
		if(aResultLevel!=null && aResultLevel.length()>2)
			throw new IllegalArgumentException("ResultlevelResultLevel值"+aResultLevel+"的长度"+aResultLevel.length()+"大于最大值2");
		ResultLevel = aResultLevel;
	}
	public double getResult()
	{
		return Result;
	}
	public void setResult(double aResult)
	{
		Result = aResult;
	}
	public void setResult(String aResult)
	{
		if (aResult != null && !aResult.equals(""))
		{
			Double tDouble = new Double(aResult);
			double d = tDouble.doubleValue();
			Result = d;
		}
	}

	public String getTrainPassFlag()
	{
		return TrainPassFlag;
	}
	public void setTrainPassFlag(String aTrainPassFlag)
	{
		if(aTrainPassFlag!=null && aTrainPassFlag.length()>2)
			throw new IllegalArgumentException("TrainpassflagTrainPassFlag值"+aTrainPassFlag+"的长度"+aTrainPassFlag.length()+"大于最大值2");
		TrainPassFlag = aTrainPassFlag;
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
	* 使用另外一个 LATrainSchema 对象给 Schema 赋值
	* @param: aLATrainSchema LATrainSchema
	**/
	public void setSchema(LATrainSchema aLATrainSchema)
	{
		this.AgentCode = aLATrainSchema.getAgentCode();
		this.BranchType = aLATrainSchema.getBranchType();
		this.OpenClassID = aLATrainSchema.getOpenClassID();
		this.Managecom = aLATrainSchema.getManagecom();
		this.ResultLevel = aLATrainSchema.getResultLevel();
		this.Result = aLATrainSchema.getResult();
		this.TrainPassFlag = aLATrainSchema.getTrainPassFlag();
		this.Remarks = aLATrainSchema.getRemarks();
		this.MakeDate = fDate.getDate( aLATrainSchema.getMakeDate());
		this.MakeTime = aLATrainSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLATrainSchema.getModifyDate());
		this.ModifyTime = aLATrainSchema.getModifyTime();
		this.Operator = aLATrainSchema.getOperator();
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

			if( rs.getString("OpenClassID") == null )
				this.OpenClassID = null;
			else
				this.OpenClassID = rs.getString("OpenClassID").trim();

			if( rs.getString("Managecom") == null )
				this.Managecom = null;
			else
				this.Managecom = rs.getString("Managecom").trim();

			if( rs.getString("ResultLevel") == null )
				this.ResultLevel = null;
			else
				this.ResultLevel = rs.getString("ResultLevel").trim();

			this.Result = rs.getDouble("Result");
			if( rs.getString("TrainPassFlag") == null )
				this.TrainPassFlag = null;
			else
				this.TrainPassFlag = rs.getString("TrainPassFlag").trim();

			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

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

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LATrain表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LATrainSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LATrainSchema getSchema()
	{
		LATrainSchema aLATrainSchema = new LATrainSchema();
		aLATrainSchema.setSchema(this);
		return aLATrainSchema;
	}

	public LATrainDB getDB()
	{
		LATrainDB aDBOper = new LATrainDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLATrain描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OpenClassID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Managecom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ResultLevel)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Result));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TrainPassFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLATrain>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			OpenClassID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			Managecom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ResultLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Result = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,6,SysConst.PACKAGESPILTER))).doubleValue();
			TrainPassFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LATrainSchema";
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
		if (FCode.equalsIgnoreCase("OpenClassID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OpenClassID));
		}
		if (FCode.equalsIgnoreCase("Managecom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Managecom));
		}
		if (FCode.equalsIgnoreCase("ResultLevel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ResultLevel));
		}
		if (FCode.equalsIgnoreCase("Result"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Result));
		}
		if (FCode.equalsIgnoreCase("TrainPassFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TrainPassFlag));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
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
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
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
				strFieldValue = StrTool.GBKToUnicode(OpenClassID);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(Managecom);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ResultLevel);
				break;
			case 5:
				strFieldValue = String.valueOf(Result);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(TrainPassFlag);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(Operator);
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
		if (FCode.equalsIgnoreCase("OpenClassID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OpenClassID = FValue.trim();
			}
			else
				OpenClassID = null;
		}
		if (FCode.equalsIgnoreCase("Managecom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Managecom = FValue.trim();
			}
			else
				Managecom = null;
		}
		if (FCode.equalsIgnoreCase("ResultLevel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ResultLevel = FValue.trim();
			}
			else
				ResultLevel = null;
		}
		if (FCode.equalsIgnoreCase("Result"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Result = d;
			}
		}
		if (FCode.equalsIgnoreCase("TrainPassFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TrainPassFlag = FValue.trim();
			}
			else
				TrainPassFlag = null;
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
		if (FCode.equalsIgnoreCase("Operator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator = FValue.trim();
			}
			else
				Operator = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LATrainSchema other = (LATrainSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& BranchType.equals(other.getBranchType())
			&& OpenClassID.equals(other.getOpenClassID())
			&& Managecom.equals(other.getManagecom())
			&& ResultLevel.equals(other.getResultLevel())
			&& Result == other.getResult()
			&& TrainPassFlag.equals(other.getTrainPassFlag())
			&& Remarks.equals(other.getRemarks())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator.equals(other.getOperator());
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
		if( strFieldName.equals("OpenClassID") ) {
			return 2;
		}
		if( strFieldName.equals("Managecom") ) {
			return 3;
		}
		if( strFieldName.equals("ResultLevel") ) {
			return 4;
		}
		if( strFieldName.equals("Result") ) {
			return 5;
		}
		if( strFieldName.equals("TrainPassFlag") ) {
			return 6;
		}
		if( strFieldName.equals("Remarks") ) {
			return 7;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 8;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 9;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 10;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 11;
		}
		if( strFieldName.equals("Operator") ) {
			return 12;
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
				strFieldName = "OpenClassID";
				break;
			case 3:
				strFieldName = "Managecom";
				break;
			case 4:
				strFieldName = "ResultLevel";
				break;
			case 5:
				strFieldName = "Result";
				break;
			case 6:
				strFieldName = "TrainPassFlag";
				break;
			case 7:
				strFieldName = "Remarks";
				break;
			case 8:
				strFieldName = "MakeDate";
				break;
			case 9:
				strFieldName = "MakeTime";
				break;
			case 10:
				strFieldName = "ModifyDate";
				break;
			case 11:
				strFieldName = "ModifyTime";
				break;
			case 12:
				strFieldName = "Operator";
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
		if( strFieldName.equals("OpenClassID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Managecom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ResultLevel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Result") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("TrainPassFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remarks") ) {
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
		if( strFieldName.equals("Operator") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
