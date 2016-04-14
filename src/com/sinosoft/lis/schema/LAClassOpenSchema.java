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
import com.sinosoft.lis.db.LAClassOpenDB;

/*
 * <p>ClassName: LAClassOpenSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAClassOpenSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAClassOpenSchema.class);
	// @Field
	/** Openclassid */
	private String OpenClassID;
	/** Channelcode */
	private String ChannelCode;
	/** Classno */
	private String ClassNo;
	/** Trainstartdate */
	private Date TrainStartDate;
	/** Trainenddate */
	private Date TrainEndDate;
	/** Managecom */
	private String Managecom;
	/** Managecomname */
	private String ManagecomName;
	/** Charger */
	private String Charger;
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

	public static final int FIELDNUM = 14;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAClassOpenSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "OpenClassID";

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
		LAClassOpenSchema cloned = (LAClassOpenSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
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
	public String getChannelCode()
	{
		return ChannelCode;
	}
	public void setChannelCode(String aChannelCode)
	{
		if(aChannelCode!=null && aChannelCode.length()>2)
			throw new IllegalArgumentException("ChannelcodeChannelCode值"+aChannelCode+"的长度"+aChannelCode.length()+"大于最大值2");
		ChannelCode = aChannelCode;
	}
	public String getClassNo()
	{
		return ClassNo;
	}
	public void setClassNo(String aClassNo)
	{
		if(aClassNo!=null && aClassNo.length()>15)
			throw new IllegalArgumentException("ClassnoClassNo值"+aClassNo+"的长度"+aClassNo.length()+"大于最大值15");
		ClassNo = aClassNo;
	}
	public String getTrainStartDate()
	{
		if( TrainStartDate != null )
			return fDate.getString(TrainStartDate);
		else
			return null;
	}
	public void setTrainStartDate(Date aTrainStartDate)
	{
		TrainStartDate = aTrainStartDate;
	}
	public void setTrainStartDate(String aTrainStartDate)
	{
		if (aTrainStartDate != null && !aTrainStartDate.equals("") )
		{
			TrainStartDate = fDate.getDate( aTrainStartDate );
		}
		else
			TrainStartDate = null;
	}

	public String getTrainEndDate()
	{
		if( TrainEndDate != null )
			return fDate.getString(TrainEndDate);
		else
			return null;
	}
	public void setTrainEndDate(Date aTrainEndDate)
	{
		TrainEndDate = aTrainEndDate;
	}
	public void setTrainEndDate(String aTrainEndDate)
	{
		if (aTrainEndDate != null && !aTrainEndDate.equals("") )
		{
			TrainEndDate = fDate.getDate( aTrainEndDate );
		}
		else
			TrainEndDate = null;
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
	public String getManagecomName()
	{
		return ManagecomName;
	}
	public void setManagecomName(String aManagecomName)
	{
		if(aManagecomName!=null && aManagecomName.length()>100)
			throw new IllegalArgumentException("ManagecomnameManagecomName值"+aManagecomName+"的长度"+aManagecomName.length()+"大于最大值100");
		ManagecomName = aManagecomName;
	}
	public String getCharger()
	{
		return Charger;
	}
	public void setCharger(String aCharger)
	{
		if(aCharger!=null && aCharger.length()>60)
			throw new IllegalArgumentException("ChargerCharger值"+aCharger+"的长度"+aCharger.length()+"大于最大值60");
		Charger = aCharger;
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
	* 使用另外一个 LAClassOpenSchema 对象给 Schema 赋值
	* @param: aLAClassOpenSchema LAClassOpenSchema
	**/
	public void setSchema(LAClassOpenSchema aLAClassOpenSchema)
	{
		this.OpenClassID = aLAClassOpenSchema.getOpenClassID();
		this.ChannelCode = aLAClassOpenSchema.getChannelCode();
		this.ClassNo = aLAClassOpenSchema.getClassNo();
		this.TrainStartDate = fDate.getDate( aLAClassOpenSchema.getTrainStartDate());
		this.TrainEndDate = fDate.getDate( aLAClassOpenSchema.getTrainEndDate());
		this.Managecom = aLAClassOpenSchema.getManagecom();
		this.ManagecomName = aLAClassOpenSchema.getManagecomName();
		this.Charger = aLAClassOpenSchema.getCharger();
		this.Remarks = aLAClassOpenSchema.getRemarks();
		this.MakeDate = fDate.getDate( aLAClassOpenSchema.getMakeDate());
		this.MakeTime = aLAClassOpenSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAClassOpenSchema.getModifyDate());
		this.ModifyTime = aLAClassOpenSchema.getModifyTime();
		this.Operator = aLAClassOpenSchema.getOperator();
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
			if( rs.getString("OpenClassID") == null )
				this.OpenClassID = null;
			else
				this.OpenClassID = rs.getString("OpenClassID").trim();

			if( rs.getString("ChannelCode") == null )
				this.ChannelCode = null;
			else
				this.ChannelCode = rs.getString("ChannelCode").trim();

			if( rs.getString("ClassNo") == null )
				this.ClassNo = null;
			else
				this.ClassNo = rs.getString("ClassNo").trim();

			this.TrainStartDate = rs.getDate("TrainStartDate");
			this.TrainEndDate = rs.getDate("TrainEndDate");
			if( rs.getString("Managecom") == null )
				this.Managecom = null;
			else
				this.Managecom = rs.getString("Managecom").trim();

			if( rs.getString("ManagecomName") == null )
				this.ManagecomName = null;
			else
				this.ManagecomName = rs.getString("ManagecomName").trim();

			if( rs.getString("Charger") == null )
				this.Charger = null;
			else
				this.Charger = rs.getString("Charger").trim();

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
			logger.debug("数据库中的LAClassOpen表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAClassOpenSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAClassOpenSchema getSchema()
	{
		LAClassOpenSchema aLAClassOpenSchema = new LAClassOpenSchema();
		aLAClassOpenSchema.setSchema(this);
		return aLAClassOpenSchema;
	}

	public LAClassOpenDB getDB()
	{
		LAClassOpenDB aDBOper = new LAClassOpenDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAClassOpen描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(OpenClassID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ChannelCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ClassNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( TrainStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( TrainEndDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Managecom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManagecomName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Charger)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAClassOpen>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			OpenClassID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ChannelCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ClassNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			TrainStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,SysConst.PACKAGESPILTER));
			TrainEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5,SysConst.PACKAGESPILTER));
			Managecom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			ManagecomName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Charger = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAClassOpenSchema";
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
		if (FCode.equalsIgnoreCase("OpenClassID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OpenClassID));
		}
		if (FCode.equalsIgnoreCase("ChannelCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ChannelCode));
		}
		if (FCode.equalsIgnoreCase("ClassNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ClassNo));
		}
		if (FCode.equalsIgnoreCase("TrainStartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getTrainStartDate()));
		}
		if (FCode.equalsIgnoreCase("TrainEndDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getTrainEndDate()));
		}
		if (FCode.equalsIgnoreCase("Managecom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Managecom));
		}
		if (FCode.equalsIgnoreCase("ManagecomName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManagecomName));
		}
		if (FCode.equalsIgnoreCase("Charger"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Charger));
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
				strFieldValue = StrTool.GBKToUnicode(OpenClassID);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ChannelCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ClassNo);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getTrainStartDate()));
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getTrainEndDate()));
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Managecom);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(ManagecomName);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Charger);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
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

		if (FCode.equalsIgnoreCase("OpenClassID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OpenClassID = FValue.trim();
			}
			else
				OpenClassID = null;
		}
		if (FCode.equalsIgnoreCase("ChannelCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ChannelCode = FValue.trim();
			}
			else
				ChannelCode = null;
		}
		if (FCode.equalsIgnoreCase("ClassNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ClassNo = FValue.trim();
			}
			else
				ClassNo = null;
		}
		if (FCode.equalsIgnoreCase("TrainStartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				TrainStartDate = fDate.getDate( FValue );
			}
			else
				TrainStartDate = null;
		}
		if (FCode.equalsIgnoreCase("TrainEndDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				TrainEndDate = fDate.getDate( FValue );
			}
			else
				TrainEndDate = null;
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
		if (FCode.equalsIgnoreCase("ManagecomName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ManagecomName = FValue.trim();
			}
			else
				ManagecomName = null;
		}
		if (FCode.equalsIgnoreCase("Charger"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Charger = FValue.trim();
			}
			else
				Charger = null;
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
		LAClassOpenSchema other = (LAClassOpenSchema)otherObject;
		return
			OpenClassID.equals(other.getOpenClassID())
			&& ChannelCode.equals(other.getChannelCode())
			&& ClassNo.equals(other.getClassNo())
			&& fDate.getString(TrainStartDate).equals(other.getTrainStartDate())
			&& fDate.getString(TrainEndDate).equals(other.getTrainEndDate())
			&& Managecom.equals(other.getManagecom())
			&& ManagecomName.equals(other.getManagecomName())
			&& Charger.equals(other.getCharger())
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
		if( strFieldName.equals("OpenClassID") ) {
			return 0;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return 1;
		}
		if( strFieldName.equals("ClassNo") ) {
			return 2;
		}
		if( strFieldName.equals("TrainStartDate") ) {
			return 3;
		}
		if( strFieldName.equals("TrainEndDate") ) {
			return 4;
		}
		if( strFieldName.equals("Managecom") ) {
			return 5;
		}
		if( strFieldName.equals("ManagecomName") ) {
			return 6;
		}
		if( strFieldName.equals("Charger") ) {
			return 7;
		}
		if( strFieldName.equals("Remarks") ) {
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
		if( strFieldName.equals("Operator") ) {
			return 13;
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
				strFieldName = "OpenClassID";
				break;
			case 1:
				strFieldName = "ChannelCode";
				break;
			case 2:
				strFieldName = "ClassNo";
				break;
			case 3:
				strFieldName = "TrainStartDate";
				break;
			case 4:
				strFieldName = "TrainEndDate";
				break;
			case 5:
				strFieldName = "Managecom";
				break;
			case 6:
				strFieldName = "ManagecomName";
				break;
			case 7:
				strFieldName = "Charger";
				break;
			case 8:
				strFieldName = "Remarks";
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
		if( strFieldName.equals("OpenClassID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ChannelCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ClassNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TrainStartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("TrainEndDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Managecom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManagecomName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Charger") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 4:
				nFieldType = Schema.TYPE_DATE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
