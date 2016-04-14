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
import com.sinosoft.lis.db.LecturertBDB;

/*
 * <p>ClassName: LecturertBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LecturertBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LecturertBSchema.class);
	// @Field
	/** Lecturertcode */
	private String LecturertCode;
	/** Lecturertname */
	private String LecturertName;
	/** Sex */
	private String Sex;
	/** Birthday */
	private Date BirthDay;
	/** Idno */
	private String IDNo;
	/** Degree */
	private String Degree;
	/** Agentgrade */
	private String AgentGrade;
	/** Phone */
	private String Phone;
	/** Email */
	private String Email;
	/** Employdate */
	private Date Employdate;
	/** Managecom */
	private String ManageCom;
	/** Lecturerttype */
	private String Lecturerttype;
	/** Servingtime */
	private int ServingTime;
	/** Lecturertlevel */
	private String LecturertLevel;
	/** Remarks */
	private String Remarks;
	/** Flag1 */
	private String Flag1;
	/** Flag2 */
	private String Flag2;
	/** Flag3 */
	private String Flag3;
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
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;
	/** Operator1 */
	private String Operator1;

	public static final int FIELDNUM = 26;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LecturertBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "LecturertCode";
		pk[1] = "MakeDate1";
		pk[2] = "MakeTime1";
		pk[3] = "Operator1";

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
		LecturertBSchema cloned = (LecturertBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getLecturertCode()
	{
		return LecturertCode;
	}
	public void setLecturertCode(String aLecturertCode)
	{
		if(aLecturertCode!=null && aLecturertCode.length()>12)
			throw new IllegalArgumentException("LecturertcodeLecturertCode值"+aLecturertCode+"的长度"+aLecturertCode.length()+"大于最大值12");
		LecturertCode = aLecturertCode;
	}
	public String getLecturertName()
	{
		return LecturertName;
	}
	public void setLecturertName(String aLecturertName)
	{
		if(aLecturertName!=null && aLecturertName.length()>100)
			throw new IllegalArgumentException("LecturertnameLecturertName值"+aLecturertName+"的长度"+aLecturertName.length()+"大于最大值100");
		LecturertName = aLecturertName;
	}
	public String getSex()
	{
		return Sex;
	}
	public void setSex(String aSex)
	{
		if(aSex!=null && aSex.length()>2)
			throw new IllegalArgumentException("SexSex值"+aSex+"的长度"+aSex.length()+"大于最大值2");
		Sex = aSex;
	}
	public String getBirthDay()
	{
		if( BirthDay != null )
			return fDate.getString(BirthDay);
		else
			return null;
	}
	public void setBirthDay(Date aBirthDay)
	{
		BirthDay = aBirthDay;
	}
	public void setBirthDay(String aBirthDay)
	{
		if (aBirthDay != null && !aBirthDay.equals("") )
		{
			BirthDay = fDate.getDate( aBirthDay );
		}
		else
			BirthDay = null;
	}

	public String getIDNo()
	{
		return IDNo;
	}
	public void setIDNo(String aIDNo)
	{
		if(aIDNo!=null && aIDNo.length()>20)
			throw new IllegalArgumentException("IdnoIDNo值"+aIDNo+"的长度"+aIDNo.length()+"大于最大值20");
		IDNo = aIDNo;
	}
	public String getDegree()
	{
		return Degree;
	}
	public void setDegree(String aDegree)
	{
		if(aDegree!=null && aDegree.length()>2)
			throw new IllegalArgumentException("DegreeDegree值"+aDegree+"的长度"+aDegree.length()+"大于最大值2");
		Degree = aDegree;
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
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String aPhone)
	{
		if(aPhone!=null && aPhone.length()>60)
			throw new IllegalArgumentException("PhonePhone值"+aPhone+"的长度"+aPhone.length()+"大于最大值60");
		Phone = aPhone;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String aEmail)
	{
		if(aEmail!=null && aEmail.length()>50)
			throw new IllegalArgumentException("EmailEmail值"+aEmail+"的长度"+aEmail.length()+"大于最大值50");
		Email = aEmail;
	}
	public String getEmploydate()
	{
		if( Employdate != null )
			return fDate.getString(Employdate);
		else
			return null;
	}
	public void setEmploydate(Date aEmploydate)
	{
		Employdate = aEmploydate;
	}
	public void setEmploydate(String aEmploydate)
	{
		if (aEmploydate != null && !aEmploydate.equals("") )
		{
			Employdate = fDate.getDate( aEmploydate );
		}
		else
			Employdate = null;
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
	public String getLecturerttype()
	{
		return Lecturerttype;
	}
	public void setLecturerttype(String aLecturerttype)
	{
		if(aLecturerttype!=null && aLecturerttype.length()>2)
			throw new IllegalArgumentException("LecturerttypeLecturerttype值"+aLecturerttype+"的长度"+aLecturerttype.length()+"大于最大值2");
		Lecturerttype = aLecturerttype;
	}
	public int getServingTime()
	{
		return ServingTime;
	}
	public void setServingTime(int aServingTime)
	{
		ServingTime = aServingTime;
	}
	public void setServingTime(String aServingTime)
	{
		if (aServingTime != null && !aServingTime.equals(""))
		{
			Integer tInteger = new Integer(aServingTime);
			int i = tInteger.intValue();
			ServingTime = i;
		}
	}

	public String getLecturertLevel()
	{
		return LecturertLevel;
	}
	public void setLecturertLevel(String aLecturertLevel)
	{
		if(aLecturertLevel!=null && aLecturertLevel.length()>2)
			throw new IllegalArgumentException("LecturertlevelLecturertLevel值"+aLecturertLevel+"的长度"+aLecturertLevel.length()+"大于最大值2");
		LecturertLevel = aLecturertLevel;
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
	public String getFlag1()
	{
		return Flag1;
	}
	public void setFlag1(String aFlag1)
	{
		if(aFlag1!=null && aFlag1.length()>60)
			throw new IllegalArgumentException("Flag1Flag1值"+aFlag1+"的长度"+aFlag1.length()+"大于最大值60");
		Flag1 = aFlag1;
	}
	public String getFlag2()
	{
		return Flag2;
	}
	public void setFlag2(String aFlag2)
	{
		if(aFlag2!=null && aFlag2.length()>60)
			throw new IllegalArgumentException("Flag2Flag2值"+aFlag2+"的长度"+aFlag2.length()+"大于最大值60");
		Flag2 = aFlag2;
	}
	public String getFlag3()
	{
		return Flag3;
	}
	public void setFlag3(String aFlag3)
	{
		if(aFlag3!=null && aFlag3.length()>60)
			throw new IllegalArgumentException("Flag3Flag3值"+aFlag3+"的长度"+aFlag3.length()+"大于最大值60");
		Flag3 = aFlag3;
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
	public String getOperator1()
	{
		return Operator1;
	}
	public void setOperator1(String aOperator1)
	{
		if(aOperator1!=null && aOperator1.length()>60)
			throw new IllegalArgumentException("Operator1Operator1值"+aOperator1+"的长度"+aOperator1.length()+"大于最大值60");
		Operator1 = aOperator1;
	}

	/**
	* 使用另外一个 LecturertBSchema 对象给 Schema 赋值
	* @param: aLecturertBSchema LecturertBSchema
	**/
	public void setSchema(LecturertBSchema aLecturertBSchema)
	{
		this.LecturertCode = aLecturertBSchema.getLecturertCode();
		this.LecturertName = aLecturertBSchema.getLecturertName();
		this.Sex = aLecturertBSchema.getSex();
		this.BirthDay = fDate.getDate( aLecturertBSchema.getBirthDay());
		this.IDNo = aLecturertBSchema.getIDNo();
		this.Degree = aLecturertBSchema.getDegree();
		this.AgentGrade = aLecturertBSchema.getAgentGrade();
		this.Phone = aLecturertBSchema.getPhone();
		this.Email = aLecturertBSchema.getEmail();
		this.Employdate = fDate.getDate( aLecturertBSchema.getEmploydate());
		this.ManageCom = aLecturertBSchema.getManageCom();
		this.Lecturerttype = aLecturertBSchema.getLecturerttype();
		this.ServingTime = aLecturertBSchema.getServingTime();
		this.LecturertLevel = aLecturertBSchema.getLecturertLevel();
		this.Remarks = aLecturertBSchema.getRemarks();
		this.Flag1 = aLecturertBSchema.getFlag1();
		this.Flag2 = aLecturertBSchema.getFlag2();
		this.Flag3 = aLecturertBSchema.getFlag3();
		this.MakeDate = fDate.getDate( aLecturertBSchema.getMakeDate());
		this.MakeTime = aLecturertBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLecturertBSchema.getModifyDate());
		this.ModifyTime = aLecturertBSchema.getModifyTime();
		this.Operator = aLecturertBSchema.getOperator();
		this.MakeDate1 = fDate.getDate( aLecturertBSchema.getMakeDate1());
		this.MakeTime1 = aLecturertBSchema.getMakeTime1();
		this.Operator1 = aLecturertBSchema.getOperator1();
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
			if( rs.getString("LecturertCode") == null )
				this.LecturertCode = null;
			else
				this.LecturertCode = rs.getString("LecturertCode").trim();

			if( rs.getString("LecturertName") == null )
				this.LecturertName = null;
			else
				this.LecturertName = rs.getString("LecturertName").trim();

			if( rs.getString("Sex") == null )
				this.Sex = null;
			else
				this.Sex = rs.getString("Sex").trim();

			this.BirthDay = rs.getDate("BirthDay");
			if( rs.getString("IDNo") == null )
				this.IDNo = null;
			else
				this.IDNo = rs.getString("IDNo").trim();

			if( rs.getString("Degree") == null )
				this.Degree = null;
			else
				this.Degree = rs.getString("Degree").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("Phone") == null )
				this.Phone = null;
			else
				this.Phone = rs.getString("Phone").trim();

			if( rs.getString("Email") == null )
				this.Email = null;
			else
				this.Email = rs.getString("Email").trim();

			this.Employdate = rs.getDate("Employdate");
			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("Lecturerttype") == null )
				this.Lecturerttype = null;
			else
				this.Lecturerttype = rs.getString("Lecturerttype").trim();

			this.ServingTime = rs.getInt("ServingTime");
			if( rs.getString("LecturertLevel") == null )
				this.LecturertLevel = null;
			else
				this.LecturertLevel = rs.getString("LecturertLevel").trim();

			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

			if( rs.getString("Flag1") == null )
				this.Flag1 = null;
			else
				this.Flag1 = rs.getString("Flag1").trim();

			if( rs.getString("Flag2") == null )
				this.Flag2 = null;
			else
				this.Flag2 = rs.getString("Flag2").trim();

			if( rs.getString("Flag3") == null )
				this.Flag3 = null;
			else
				this.Flag3 = rs.getString("Flag3").trim();

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

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

			if( rs.getString("Operator1") == null )
				this.Operator1 = null;
			else
				this.Operator1 = rs.getString("Operator1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LecturertB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LecturertBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LecturertBSchema getSchema()
	{
		LecturertBSchema aLecturertBSchema = new LecturertBSchema();
		aLecturertBSchema.setSchema(this);
		return aLecturertBSchema;
	}

	public LecturertBDB getDB()
	{
		LecturertBDB aDBOper = new LecturertBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLecturertB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(LecturertCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LecturertName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Sex)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BirthDay ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IDNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Degree)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Phone)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Email)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Employdate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Lecturerttype)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(ServingTime));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LecturertLevel)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLecturertB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			LecturertCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			LecturertName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			Sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BirthDay = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,SysConst.PACKAGESPILTER));
			IDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Degree = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Email = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			Employdate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Lecturerttype = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			ServingTime= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,13,SysConst.PACKAGESPILTER))).intValue();
			LecturertLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LecturertBSchema";
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
		if (FCode.equalsIgnoreCase("LecturertCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LecturertCode));
		}
		if (FCode.equalsIgnoreCase("LecturertName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LecturertName));
		}
		if (FCode.equalsIgnoreCase("Sex"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Sex));
		}
		if (FCode.equalsIgnoreCase("BirthDay"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBirthDay()));
		}
		if (FCode.equalsIgnoreCase("IDNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDNo));
		}
		if (FCode.equalsIgnoreCase("Degree"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Degree));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("Phone"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Phone));
		}
		if (FCode.equalsIgnoreCase("Email"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Email));
		}
		if (FCode.equalsIgnoreCase("Employdate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEmploydate()));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("Lecturerttype"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Lecturerttype));
		}
		if (FCode.equalsIgnoreCase("ServingTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ServingTime));
		}
		if (FCode.equalsIgnoreCase("LecturertLevel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LecturertLevel));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
		}
		if (FCode.equalsIgnoreCase("Flag1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag1));
		}
		if (FCode.equalsIgnoreCase("Flag2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag2));
		}
		if (FCode.equalsIgnoreCase("Flag3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag3));
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
		if (FCode.equalsIgnoreCase("MakeDate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
		}
		if (FCode.equalsIgnoreCase("MakeTime1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime1));
		}
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator1));
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
				strFieldValue = StrTool.GBKToUnicode(LecturertCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(LecturertName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(Sex);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBirthDay()));
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(IDNo);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Degree);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Phone);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Email);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEmploydate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Lecturerttype);
				break;
			case 12:
				strFieldValue = String.valueOf(ServingTime);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(LecturertLevel);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Flag1);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Flag2);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(Flag3);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
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

		if (FCode.equalsIgnoreCase("LecturertCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LecturertCode = FValue.trim();
			}
			else
				LecturertCode = null;
		}
		if (FCode.equalsIgnoreCase("LecturertName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LecturertName = FValue.trim();
			}
			else
				LecturertName = null;
		}
		if (FCode.equalsIgnoreCase("Sex"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Sex = FValue.trim();
			}
			else
				Sex = null;
		}
		if (FCode.equalsIgnoreCase("BirthDay"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BirthDay = fDate.getDate( FValue );
			}
			else
				BirthDay = null;
		}
		if (FCode.equalsIgnoreCase("IDNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDNo = FValue.trim();
			}
			else
				IDNo = null;
		}
		if (FCode.equalsIgnoreCase("Degree"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Degree = FValue.trim();
			}
			else
				Degree = null;
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
		if (FCode.equalsIgnoreCase("Phone"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Phone = FValue.trim();
			}
			else
				Phone = null;
		}
		if (FCode.equalsIgnoreCase("Email"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Email = FValue.trim();
			}
			else
				Email = null;
		}
		if (FCode.equalsIgnoreCase("Employdate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Employdate = fDate.getDate( FValue );
			}
			else
				Employdate = null;
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
		if (FCode.equalsIgnoreCase("Lecturerttype"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Lecturerttype = FValue.trim();
			}
			else
				Lecturerttype = null;
		}
		if (FCode.equalsIgnoreCase("ServingTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				ServingTime = i;
			}
		}
		if (FCode.equalsIgnoreCase("LecturertLevel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LecturertLevel = FValue.trim();
			}
			else
				LecturertLevel = null;
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
		if (FCode.equalsIgnoreCase("Flag1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag1 = FValue.trim();
			}
			else
				Flag1 = null;
		}
		if (FCode.equalsIgnoreCase("Flag2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag2 = FValue.trim();
			}
			else
				Flag2 = null;
		}
		if (FCode.equalsIgnoreCase("Flag3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag3 = FValue.trim();
			}
			else
				Flag3 = null;
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
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator1 = FValue.trim();
			}
			else
				Operator1 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LecturertBSchema other = (LecturertBSchema)otherObject;
		return
			LecturertCode.equals(other.getLecturertCode())
			&& LecturertName.equals(other.getLecturertName())
			&& Sex.equals(other.getSex())
			&& fDate.getString(BirthDay).equals(other.getBirthDay())
			&& IDNo.equals(other.getIDNo())
			&& Degree.equals(other.getDegree())
			&& AgentGrade.equals(other.getAgentGrade())
			&& Phone.equals(other.getPhone())
			&& Email.equals(other.getEmail())
			&& fDate.getString(Employdate).equals(other.getEmploydate())
			&& ManageCom.equals(other.getManageCom())
			&& Lecturerttype.equals(other.getLecturerttype())
			&& ServingTime == other.getServingTime()
			&& LecturertLevel.equals(other.getLecturertLevel())
			&& Remarks.equals(other.getRemarks())
			&& Flag1.equals(other.getFlag1())
			&& Flag2.equals(other.getFlag2())
			&& Flag3.equals(other.getFlag3())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1())
			&& Operator1.equals(other.getOperator1());
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
		if( strFieldName.equals("LecturertCode") ) {
			return 0;
		}
		if( strFieldName.equals("LecturertName") ) {
			return 1;
		}
		if( strFieldName.equals("Sex") ) {
			return 2;
		}
		if( strFieldName.equals("BirthDay") ) {
			return 3;
		}
		if( strFieldName.equals("IDNo") ) {
			return 4;
		}
		if( strFieldName.equals("Degree") ) {
			return 5;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 6;
		}
		if( strFieldName.equals("Phone") ) {
			return 7;
		}
		if( strFieldName.equals("Email") ) {
			return 8;
		}
		if( strFieldName.equals("Employdate") ) {
			return 9;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 10;
		}
		if( strFieldName.equals("Lecturerttype") ) {
			return 11;
		}
		if( strFieldName.equals("ServingTime") ) {
			return 12;
		}
		if( strFieldName.equals("LecturertLevel") ) {
			return 13;
		}
		if( strFieldName.equals("Remarks") ) {
			return 14;
		}
		if( strFieldName.equals("Flag1") ) {
			return 15;
		}
		if( strFieldName.equals("Flag2") ) {
			return 16;
		}
		if( strFieldName.equals("Flag3") ) {
			return 17;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 18;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 19;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 20;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 21;
		}
		if( strFieldName.equals("Operator") ) {
			return 22;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 23;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 24;
		}
		if( strFieldName.equals("Operator1") ) {
			return 25;
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
				strFieldName = "LecturertCode";
				break;
			case 1:
				strFieldName = "LecturertName";
				break;
			case 2:
				strFieldName = "Sex";
				break;
			case 3:
				strFieldName = "BirthDay";
				break;
			case 4:
				strFieldName = "IDNo";
				break;
			case 5:
				strFieldName = "Degree";
				break;
			case 6:
				strFieldName = "AgentGrade";
				break;
			case 7:
				strFieldName = "Phone";
				break;
			case 8:
				strFieldName = "Email";
				break;
			case 9:
				strFieldName = "Employdate";
				break;
			case 10:
				strFieldName = "ManageCom";
				break;
			case 11:
				strFieldName = "Lecturerttype";
				break;
			case 12:
				strFieldName = "ServingTime";
				break;
			case 13:
				strFieldName = "LecturertLevel";
				break;
			case 14:
				strFieldName = "Remarks";
				break;
			case 15:
				strFieldName = "Flag1";
				break;
			case 16:
				strFieldName = "Flag2";
				break;
			case 17:
				strFieldName = "Flag3";
				break;
			case 18:
				strFieldName = "MakeDate";
				break;
			case 19:
				strFieldName = "MakeTime";
				break;
			case 20:
				strFieldName = "ModifyDate";
				break;
			case 21:
				strFieldName = "ModifyTime";
				break;
			case 22:
				strFieldName = "Operator";
				break;
			case 23:
				strFieldName = "MakeDate1";
				break;
			case 24:
				strFieldName = "MakeTime1";
				break;
			case 25:
				strFieldName = "Operator1";
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
		if( strFieldName.equals("LecturertCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LecturertName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Sex") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BirthDay") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("IDNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Degree") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Phone") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Email") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Employdate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Lecturerttype") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ServingTime") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("LecturertLevel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remarks") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Flag1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Flag2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Flag3") ) {
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
		if( strFieldName.equals("MakeDate1") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator1") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_INT;
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
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 20:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 21:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 22:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 23:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 24:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 25:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
