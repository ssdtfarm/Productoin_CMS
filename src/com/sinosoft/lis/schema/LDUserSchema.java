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
import com.sinosoft.lis.db.LDUserDB;

/*
 * <p>ClassName: LDUserSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDUserSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDUserSchema.class);
	// @Field
	/** Usercode */
	private String UserCode;
	/** Username */
	private String UserName;
	/** Comcode */
	private String ComCode;
	/** Password */
	private String Password;
	/** Userdescription */
	private String UserDescription;
	/** Userstate */
	private String UserState;
	/** Uwpopedom */
	private String UWPopedom;
	/** Claimpopedom */
	private String ClaimPopedom;
	/** Otherpopedom */
	private String OtherPopedom;
	/** Popuwflag */
	private String PopUWFlag;
	/** Superpopedomflag */
	private String SuperPopedomFlag;
	/** Operator */
	private String Operator;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Validstartdate */
	private Date ValidStartDate;
	/** Validenddate */
	private Date ValidEndDate;
	/** Certifyflag */
	private String CertifyFlag;
	/** Edorpopedom */
	private String EdorPopedom;
	/** Agentcom */
	private String AgentCom;

	public static final int FIELDNUM = 19;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDUserSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "UserCode";

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
		LDUserSchema cloned = (LDUserSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getUserCode()
	{
		return UserCode;
	}
	public void setUserCode(String aUserCode)
	{
		if(aUserCode!=null && aUserCode.length()>60)
			throw new IllegalArgumentException("UsercodeUserCode值"+aUserCode+"的长度"+aUserCode.length()+"大于最大值60");
		UserCode = aUserCode;
	}
	public String getUserName()
	{
		return UserName;
	}
	public void setUserName(String aUserName)
	{
		if(aUserName!=null && aUserName.length()>20)
			throw new IllegalArgumentException("UsernameUserName值"+aUserName+"的长度"+aUserName.length()+"大于最大值20");
		UserName = aUserName;
	}
	public String getComCode()
	{
		return ComCode;
	}
	public void setComCode(String aComCode)
	{
		if(aComCode!=null && aComCode.length()>20)
			throw new IllegalArgumentException("ComcodeComCode值"+aComCode+"的长度"+aComCode.length()+"大于最大值20");
		ComCode = aComCode;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String aPassword)
	{
//		if(aPassword!=null && aPassword.length()>16)
//			throw new IllegalArgumentException("PasswordPassword值"+aPassword+"的长度"+aPassword.length()+"大于最大值16");
		Password = aPassword;
	}
	public String getUserDescription()
	{
		return UserDescription;
	}
	public void setUserDescription(String aUserDescription)
	{
		if(aUserDescription!=null && aUserDescription.length()>50)
			throw new IllegalArgumentException("UserdescriptionUserDescription值"+aUserDescription+"的长度"+aUserDescription.length()+"大于最大值50");
		UserDescription = aUserDescription;
	}
	public String getUserState()
	{
		return UserState;
	}
	public void setUserState(String aUserState)
	{
		if(aUserState!=null && aUserState.length()>1)
			throw new IllegalArgumentException("UserstateUserState值"+aUserState+"的长度"+aUserState.length()+"大于最大值1");
		UserState = aUserState;
	}
	public String getUWPopedom()
	{
		return UWPopedom;
	}
	public void setUWPopedom(String aUWPopedom)
	{
		if(aUWPopedom!=null && aUWPopedom.length()>10)
			throw new IllegalArgumentException("UwpopedomUWPopedom值"+aUWPopedom+"的长度"+aUWPopedom.length()+"大于最大值10");
		UWPopedom = aUWPopedom;
	}
	public String getClaimPopedom()
	{
		return ClaimPopedom;
	}
	public void setClaimPopedom(String aClaimPopedom)
	{
		if(aClaimPopedom!=null && aClaimPopedom.length()>2)
			throw new IllegalArgumentException("ClaimpopedomClaimPopedom值"+aClaimPopedom+"的长度"+aClaimPopedom.length()+"大于最大值2");
		ClaimPopedom = aClaimPopedom;
	}
	public String getOtherPopedom()
	{
		return OtherPopedom;
	}
	public void setOtherPopedom(String aOtherPopedom)
	{
		if(aOtherPopedom!=null && aOtherPopedom.length()>2)
			throw new IllegalArgumentException("OtherpopedomOtherPopedom值"+aOtherPopedom+"的长度"+aOtherPopedom.length()+"大于最大值2");
		OtherPopedom = aOtherPopedom;
	}
	public String getPopUWFlag()
	{
		return PopUWFlag;
	}
	public void setPopUWFlag(String aPopUWFlag)
	{
		if(aPopUWFlag!=null && aPopUWFlag.length()>1)
			throw new IllegalArgumentException("PopuwflagPopUWFlag值"+aPopUWFlag+"的长度"+aPopUWFlag.length()+"大于最大值1");
		PopUWFlag = aPopUWFlag;
	}
	public String getSuperPopedomFlag()
	{
		return SuperPopedomFlag;
	}
	public void setSuperPopedomFlag(String aSuperPopedomFlag)
	{
		if(aSuperPopedomFlag!=null && aSuperPopedomFlag.length()>1)
			throw new IllegalArgumentException("SuperpopedomflagSuperPopedomFlag值"+aSuperPopedomFlag+"的长度"+aSuperPopedomFlag.length()+"大于最大值1");
		SuperPopedomFlag = aSuperPopedomFlag;
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
	public String getValidStartDate()
	{
		if( ValidStartDate != null )
			return fDate.getString(ValidStartDate);
		else
			return null;
	}
	public void setValidStartDate(Date aValidStartDate)
	{
		ValidStartDate = aValidStartDate;
	}
	public void setValidStartDate(String aValidStartDate)
	{
		if (aValidStartDate != null && !aValidStartDate.equals("") )
		{
			ValidStartDate = fDate.getDate( aValidStartDate );
		}
		else
			ValidStartDate = null;
	}

	public String getValidEndDate()
	{
		if( ValidEndDate != null )
			return fDate.getString(ValidEndDate);
		else
			return null;
	}
	public void setValidEndDate(Date aValidEndDate)
	{
		ValidEndDate = aValidEndDate;
	}
	public void setValidEndDate(String aValidEndDate)
	{
		if (aValidEndDate != null && !aValidEndDate.equals("") )
		{
			ValidEndDate = fDate.getDate( aValidEndDate );
		}
		else
			ValidEndDate = null;
	}

	public String getCertifyFlag()
	{
		return CertifyFlag;
	}
	public void setCertifyFlag(String aCertifyFlag)
	{
		if(aCertifyFlag!=null && aCertifyFlag.length()>1)
			throw new IllegalArgumentException("CertifyflagCertifyFlag值"+aCertifyFlag+"的长度"+aCertifyFlag.length()+"大于最大值1");
		CertifyFlag = aCertifyFlag;
	}
	public String getEdorPopedom()
	{
		return EdorPopedom;
	}
	public void setEdorPopedom(String aEdorPopedom)
	{
		if(aEdorPopedom!=null && aEdorPopedom.length()>2)
			throw new IllegalArgumentException("EdorpopedomEdorPopedom值"+aEdorPopedom+"的长度"+aEdorPopedom.length()+"大于最大值2");
		EdorPopedom = aEdorPopedom;
	}
	public String getAgentCom()
	{
		return AgentCom;
	}
	public void setAgentCom(String aAgentCom)
	{
		if(aAgentCom!=null && aAgentCom.length()>20)
			throw new IllegalArgumentException("AgentcomAgentCom值"+aAgentCom+"的长度"+aAgentCom.length()+"大于最大值20");
		AgentCom = aAgentCom;
	}

	/**
	* 使用另外一个 LDUserSchema 对象给 Schema 赋值
	* @param: aLDUserSchema LDUserSchema
	**/
	public void setSchema(LDUserSchema aLDUserSchema)
	{
		this.UserCode = aLDUserSchema.getUserCode();
		this.UserName = aLDUserSchema.getUserName();
		this.ComCode = aLDUserSchema.getComCode();
		this.Password = aLDUserSchema.getPassword();
		this.UserDescription = aLDUserSchema.getUserDescription();
		this.UserState = aLDUserSchema.getUserState();
		this.UWPopedom = aLDUserSchema.getUWPopedom();
		this.ClaimPopedom = aLDUserSchema.getClaimPopedom();
		this.OtherPopedom = aLDUserSchema.getOtherPopedom();
		this.PopUWFlag = aLDUserSchema.getPopUWFlag();
		this.SuperPopedomFlag = aLDUserSchema.getSuperPopedomFlag();
		this.Operator = aLDUserSchema.getOperator();
		this.MakeDate = fDate.getDate( aLDUserSchema.getMakeDate());
		this.MakeTime = aLDUserSchema.getMakeTime();
		this.ValidStartDate = fDate.getDate( aLDUserSchema.getValidStartDate());
		this.ValidEndDate = fDate.getDate( aLDUserSchema.getValidEndDate());
		this.CertifyFlag = aLDUserSchema.getCertifyFlag();
		this.EdorPopedom = aLDUserSchema.getEdorPopedom();
		this.AgentCom = aLDUserSchema.getAgentCom();
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
			if( rs.getString("UserCode") == null )
				this.UserCode = null;
			else
				this.UserCode = rs.getString("UserCode").trim();

			if( rs.getString("UserName") == null )
				this.UserName = null;
			else
				this.UserName = rs.getString("UserName").trim();

			if( rs.getString("ComCode") == null )
				this.ComCode = null;
			else
				this.ComCode = rs.getString("ComCode").trim();

			if( rs.getString("Password") == null )
				this.Password = null;
			else
				this.Password = rs.getString("Password").trim();

			if( rs.getString("UserDescription") == null )
				this.UserDescription = null;
			else
				this.UserDescription = rs.getString("UserDescription").trim();

			if( rs.getString("UserState") == null )
				this.UserState = null;
			else
				this.UserState = rs.getString("UserState").trim();

			if( rs.getString("UWPopedom") == null )
				this.UWPopedom = null;
			else
				this.UWPopedom = rs.getString("UWPopedom").trim();

			if( rs.getString("ClaimPopedom") == null )
				this.ClaimPopedom = null;
			else
				this.ClaimPopedom = rs.getString("ClaimPopedom").trim();

			if( rs.getString("OtherPopedom") == null )
				this.OtherPopedom = null;
			else
				this.OtherPopedom = rs.getString("OtherPopedom").trim();

			if( rs.getString("PopUWFlag") == null )
				this.PopUWFlag = null;
			else
				this.PopUWFlag = rs.getString("PopUWFlag").trim();

			if( rs.getString("SuperPopedomFlag") == null )
				this.SuperPopedomFlag = null;
			else
				this.SuperPopedomFlag = rs.getString("SuperPopedomFlag").trim();

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

			this.ValidStartDate = rs.getDate("ValidStartDate");
			this.ValidEndDate = rs.getDate("ValidEndDate");
			if( rs.getString("CertifyFlag") == null )
				this.CertifyFlag = null;
			else
				this.CertifyFlag = rs.getString("CertifyFlag").trim();

			if( rs.getString("EdorPopedom") == null )
				this.EdorPopedom = null;
			else
				this.EdorPopedom = rs.getString("EdorPopedom").trim();

			if( rs.getString("AgentCom") == null )
				this.AgentCom = null;
			else
				this.AgentCom = rs.getString("AgentCom").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDUser表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDUserSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDUserSchema getSchema()
	{
		LDUserSchema aLDUserSchema = new LDUserSchema();
		aLDUserSchema.setSchema(this);
		return aLDUserSchema;
	}

	public LDUserDB getDB()
	{
		LDUserDB aDBOper = new LDUserDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDUser描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(UserCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UserName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ComCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Password)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UserDescription)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UserState)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UWPopedom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ClaimPopedom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OtherPopedom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PopUWFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SuperPopedomFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ValidStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ValidEndDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CertifyFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EdorPopedom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCom));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDUser>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			UserCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			UserName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ComCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			Password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			UserDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			UserState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			UWPopedom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			ClaimPopedom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			OtherPopedom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			PopUWFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			SuperPopedomFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			ValidStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			ValidEndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			CertifyFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			EdorPopedom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			AgentCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDUserSchema";
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
		if (FCode.equalsIgnoreCase("UserCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UserCode));
		}
		if (FCode.equalsIgnoreCase("UserName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UserName));
		}
		if (FCode.equalsIgnoreCase("ComCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ComCode));
		}
		if (FCode.equalsIgnoreCase("Password"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Password));
		}
		if (FCode.equalsIgnoreCase("UserDescription"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UserDescription));
		}
		if (FCode.equalsIgnoreCase("UserState"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UserState));
		}
		if (FCode.equalsIgnoreCase("UWPopedom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UWPopedom));
		}
		if (FCode.equalsIgnoreCase("ClaimPopedom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ClaimPopedom));
		}
		if (FCode.equalsIgnoreCase("OtherPopedom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OtherPopedom));
		}
		if (FCode.equalsIgnoreCase("PopUWFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PopUWFlag));
		}
		if (FCode.equalsIgnoreCase("SuperPopedomFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SuperPopedomFlag));
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
		if (FCode.equalsIgnoreCase("ValidStartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getValidStartDate()));
		}
		if (FCode.equalsIgnoreCase("ValidEndDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getValidEndDate()));
		}
		if (FCode.equalsIgnoreCase("CertifyFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CertifyFlag));
		}
		if (FCode.equalsIgnoreCase("EdorPopedom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorPopedom));
		}
		if (FCode.equalsIgnoreCase("AgentCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCom));
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
				strFieldValue = StrTool.GBKToUnicode(UserCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(UserName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ComCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(Password);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(UserDescription);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(UserState);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(UWPopedom);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(ClaimPopedom);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(OtherPopedom);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(PopUWFlag);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(SuperPopedomFlag);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getValidStartDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getValidEndDate()));
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(CertifyFlag);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(EdorPopedom);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(AgentCom);
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

		if (FCode.equalsIgnoreCase("UserCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UserCode = FValue.trim();
			}
			else
				UserCode = null;
		}
		if (FCode.equalsIgnoreCase("UserName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UserName = FValue.trim();
			}
			else
				UserName = null;
		}
		if (FCode.equalsIgnoreCase("ComCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ComCode = FValue.trim();
			}
			else
				ComCode = null;
		}
		if (FCode.equalsIgnoreCase("Password"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Password = FValue.trim();
			}
			else
				Password = null;
		}
		if (FCode.equalsIgnoreCase("UserDescription"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UserDescription = FValue.trim();
			}
			else
				UserDescription = null;
		}
		if (FCode.equalsIgnoreCase("UserState"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UserState = FValue.trim();
			}
			else
				UserState = null;
		}
		if (FCode.equalsIgnoreCase("UWPopedom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UWPopedom = FValue.trim();
			}
			else
				UWPopedom = null;
		}
		if (FCode.equalsIgnoreCase("ClaimPopedom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ClaimPopedom = FValue.trim();
			}
			else
				ClaimPopedom = null;
		}
		if (FCode.equalsIgnoreCase("OtherPopedom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OtherPopedom = FValue.trim();
			}
			else
				OtherPopedom = null;
		}
		if (FCode.equalsIgnoreCase("PopUWFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PopUWFlag = FValue.trim();
			}
			else
				PopUWFlag = null;
		}
		if (FCode.equalsIgnoreCase("SuperPopedomFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SuperPopedomFlag = FValue.trim();
			}
			else
				SuperPopedomFlag = null;
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
		if (FCode.equalsIgnoreCase("ValidStartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ValidStartDate = fDate.getDate( FValue );
			}
			else
				ValidStartDate = null;
		}
		if (FCode.equalsIgnoreCase("ValidEndDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ValidEndDate = fDate.getDate( FValue );
			}
			else
				ValidEndDate = null;
		}
		if (FCode.equalsIgnoreCase("CertifyFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CertifyFlag = FValue.trim();
			}
			else
				CertifyFlag = null;
		}
		if (FCode.equalsIgnoreCase("EdorPopedom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EdorPopedom = FValue.trim();
			}
			else
				EdorPopedom = null;
		}
		if (FCode.equalsIgnoreCase("AgentCom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCom = FValue.trim();
			}
			else
				AgentCom = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDUserSchema other = (LDUserSchema)otherObject;
		return
			UserCode.equals(other.getUserCode())
			&& UserName.equals(other.getUserName())
			&& ComCode.equals(other.getComCode())
			&& Password.equals(other.getPassword())
			&& UserDescription.equals(other.getUserDescription())
			&& UserState.equals(other.getUserState())
			&& UWPopedom.equals(other.getUWPopedom())
			&& ClaimPopedom.equals(other.getClaimPopedom())
			&& OtherPopedom.equals(other.getOtherPopedom())
			&& PopUWFlag.equals(other.getPopUWFlag())
			&& SuperPopedomFlag.equals(other.getSuperPopedomFlag())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ValidStartDate).equals(other.getValidStartDate())
			&& fDate.getString(ValidEndDate).equals(other.getValidEndDate())
			&& CertifyFlag.equals(other.getCertifyFlag())
			&& EdorPopedom.equals(other.getEdorPopedom())
			&& AgentCom.equals(other.getAgentCom());
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
		if( strFieldName.equals("UserCode") ) {
			return 0;
		}
		if( strFieldName.equals("UserName") ) {
			return 1;
		}
		if( strFieldName.equals("ComCode") ) {
			return 2;
		}
		if( strFieldName.equals("Password") ) {
			return 3;
		}
		if( strFieldName.equals("UserDescription") ) {
			return 4;
		}
		if( strFieldName.equals("UserState") ) {
			return 5;
		}
		if( strFieldName.equals("UWPopedom") ) {
			return 6;
		}
		if( strFieldName.equals("ClaimPopedom") ) {
			return 7;
		}
		if( strFieldName.equals("OtherPopedom") ) {
			return 8;
		}
		if( strFieldName.equals("PopUWFlag") ) {
			return 9;
		}
		if( strFieldName.equals("SuperPopedomFlag") ) {
			return 10;
		}
		if( strFieldName.equals("Operator") ) {
			return 11;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 12;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 13;
		}
		if( strFieldName.equals("ValidStartDate") ) {
			return 14;
		}
		if( strFieldName.equals("ValidEndDate") ) {
			return 15;
		}
		if( strFieldName.equals("CertifyFlag") ) {
			return 16;
		}
		if( strFieldName.equals("EdorPopedom") ) {
			return 17;
		}
		if( strFieldName.equals("AgentCom") ) {
			return 18;
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
				strFieldName = "UserCode";
				break;
			case 1:
				strFieldName = "UserName";
				break;
			case 2:
				strFieldName = "ComCode";
				break;
			case 3:
				strFieldName = "Password";
				break;
			case 4:
				strFieldName = "UserDescription";
				break;
			case 5:
				strFieldName = "UserState";
				break;
			case 6:
				strFieldName = "UWPopedom";
				break;
			case 7:
				strFieldName = "ClaimPopedom";
				break;
			case 8:
				strFieldName = "OtherPopedom";
				break;
			case 9:
				strFieldName = "PopUWFlag";
				break;
			case 10:
				strFieldName = "SuperPopedomFlag";
				break;
			case 11:
				strFieldName = "Operator";
				break;
			case 12:
				strFieldName = "MakeDate";
				break;
			case 13:
				strFieldName = "MakeTime";
				break;
			case 14:
				strFieldName = "ValidStartDate";
				break;
			case 15:
				strFieldName = "ValidEndDate";
				break;
			case 16:
				strFieldName = "CertifyFlag";
				break;
			case 17:
				strFieldName = "EdorPopedom";
				break;
			case 18:
				strFieldName = "AgentCom";
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
		if( strFieldName.equals("UserCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UserName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ComCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Password") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UserDescription") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UserState") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UWPopedom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ClaimPopedom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OtherPopedom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PopUWFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SuperPopedomFlag") ) {
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
		if( strFieldName.equals("ValidStartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ValidEndDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("CertifyFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EdorPopedom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCom") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 15:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
