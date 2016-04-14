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
import com.sinosoft.lis.db.LCcopfDB;

/*
 * <p>ClassName: LCcopfSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: CMS_HK_AllTable
 */
public class LCcopfSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LCcopfSchema.class);
	// @Field
	/** Id */
	private String ID;
	/** Managecom */
	private String ManageCom;
	/** Mainpolno */
	private String MainPolno;
	/** Ttmprcno */
	private String TtmprcNo;
	/** Originalagentcode */
	private String OriginalAgentcode;
	/** Newagentcode */
	private String NewAgentcode;
	/** Validflag */
	private String ValidFlag;
	/** Usrprf */
	private String UsrPrf;
	/** Jobnm */
	private String JobNm;
	/** Datime */
	private Date DaTime;
	/** Reason */
	private String Reason;
	/** Assignmentdate */
	private Date AssignmentDate;
	/** Asareceiveddate */
	private Date ASAReceivedDate;
	/** Asaflag */
	private String ASAFlag;
	/** Orhpanindicator */
	private String OrhpanIndicator;
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

	public static final int FIELDNUM = 21;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LCcopfSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[6];
		pk[0] = "ID";
		pk[1] = "MainPolno";
		pk[2] = "TtmprcNo";
		pk[3] = "OriginalAgentcode";
		pk[4] = "NewAgentcode";
		pk[5] = "MakeDate";

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
		LCcopfSchema cloned = (LCcopfSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getID()
	{
		return ID;
	}
	public void setID(String aID)
	{
		if(aID!=null && aID.length()>10)
			throw new IllegalArgumentException("IdID值"+aID+"的长度"+aID.length()+"大于最大值10");
		ID = aID;
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
	public String getMainPolno()
	{
		return MainPolno;
	}
	public void setMainPolno(String aMainPolno)
	{
		if(aMainPolno!=null && aMainPolno.length()>20)
			throw new IllegalArgumentException("MainpolnoMainPolno值"+aMainPolno+"的长度"+aMainPolno.length()+"大于最大值20");
		MainPolno = aMainPolno;
	}
	public String getTtmprcNo()
	{
		return TtmprcNo;
	}
	public void setTtmprcNo(String aTtmprcNo)
	{
		if(aTtmprcNo!=null && aTtmprcNo.length()>20)
			throw new IllegalArgumentException("TtmprcnoTtmprcNo值"+aTtmprcNo+"的长度"+aTtmprcNo.length()+"大于最大值20");
		TtmprcNo = aTtmprcNo;
	}
	public String getOriginalAgentcode()
	{
		return OriginalAgentcode;
	}
	public void setOriginalAgentcode(String aOriginalAgentcode)
	{
		if(aOriginalAgentcode!=null && aOriginalAgentcode.length()>10)
			throw new IllegalArgumentException("OriginalagentcodeOriginalAgentcode值"+aOriginalAgentcode+"的长度"+aOriginalAgentcode.length()+"大于最大值10");
		OriginalAgentcode = aOriginalAgentcode;
	}
	public String getNewAgentcode()
	{
		return NewAgentcode;
	}
	public void setNewAgentcode(String aNewAgentcode)
	{
		if(aNewAgentcode!=null && aNewAgentcode.length()>14)
			throw new IllegalArgumentException("NewagentcodeNewAgentcode值"+aNewAgentcode+"的长度"+aNewAgentcode.length()+"大于最大值14");
		NewAgentcode = aNewAgentcode;
	}
	public String getValidFlag()
	{
		return ValidFlag;
	}
	public void setValidFlag(String aValidFlag)
	{
		if(aValidFlag!=null && aValidFlag.length()>1)
			throw new IllegalArgumentException("ValidflagValidFlag值"+aValidFlag+"的长度"+aValidFlag.length()+"大于最大值1");
		ValidFlag = aValidFlag;
	}
	public String getUsrPrf()
	{
		return UsrPrf;
	}
	public void setUsrPrf(String aUsrPrf)
	{
		if(aUsrPrf!=null && aUsrPrf.length()>10)
			throw new IllegalArgumentException("UsrprfUsrPrf值"+aUsrPrf+"的长度"+aUsrPrf.length()+"大于最大值10");
		UsrPrf = aUsrPrf;
	}
	public String getJobNm()
	{
		return JobNm;
	}
	public void setJobNm(String aJobNm)
	{
		if(aJobNm!=null && aJobNm.length()>10)
			throw new IllegalArgumentException("JobnmJobNm值"+aJobNm+"的长度"+aJobNm.length()+"大于最大值10");
		JobNm = aJobNm;
	}
	public String getDaTime()
	{
		if( DaTime != null )
			return fDate.getString(DaTime);
		else
			return null;
	}
	public void setDaTime(Date aDaTime)
	{
		DaTime = aDaTime;
	}
	public void setDaTime(String aDaTime)
	{
		if (aDaTime != null && !aDaTime.equals("") )
		{
			DaTime = fDate.getDate( aDaTime );
		}
		else
			DaTime = null;
	}

	public String getReason()
	{
		return Reason;
	}
	public void setReason(String aReason)
	{
		if(aReason!=null && aReason.length()>3)
			throw new IllegalArgumentException("ReasonReason值"+aReason+"的长度"+aReason.length()+"大于最大值3");
		Reason = aReason;
	}
	public String getAssignmentDate()
	{
		if( AssignmentDate != null )
			return fDate.getString(AssignmentDate);
		else
			return null;
	}
	public void setAssignmentDate(Date aAssignmentDate)
	{
		AssignmentDate = aAssignmentDate;
	}
	public void setAssignmentDate(String aAssignmentDate)
	{
		if (aAssignmentDate != null && !aAssignmentDate.equals("") )
		{
			AssignmentDate = fDate.getDate( aAssignmentDate );
		}
		else
			AssignmentDate = null;
	}

	public String getASAReceivedDate()
	{
		if( ASAReceivedDate != null )
			return fDate.getString(ASAReceivedDate);
		else
			return null;
	}
	public void setASAReceivedDate(Date aASAReceivedDate)
	{
		ASAReceivedDate = aASAReceivedDate;
	}
	public void setASAReceivedDate(String aASAReceivedDate)
	{
		if (aASAReceivedDate != null && !aASAReceivedDate.equals("") )
		{
			ASAReceivedDate = fDate.getDate( aASAReceivedDate );
		}
		else
			ASAReceivedDate = null;
	}

	public String getASAFlag()
	{
		return ASAFlag;
	}
	public void setASAFlag(String aASAFlag)
	{
		if(aASAFlag!=null && aASAFlag.length()>3)
			throw new IllegalArgumentException("AsaflagASAFlag值"+aASAFlag+"的长度"+aASAFlag.length()+"大于最大值3");
		ASAFlag = aASAFlag;
	}
	public String getOrhpanIndicator()
	{
		return OrhpanIndicator;
	}
	public void setOrhpanIndicator(String aOrhpanIndicator)
	{
		if(aOrhpanIndicator!=null && aOrhpanIndicator.length()>10)
			throw new IllegalArgumentException("OrhpanindicatorOrhpanIndicator值"+aOrhpanIndicator+"的长度"+aOrhpanIndicator.length()+"大于最大值10");
		OrhpanIndicator = aOrhpanIndicator;
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

	/**
	* 使用另外一个 LCcopfSchema 对象给 Schema 赋值
	* @param: aLCcopfSchema LCcopfSchema
	**/
	public void setSchema(LCcopfSchema aLCcopfSchema)
	{
		this.ID = aLCcopfSchema.getID();
		this.ManageCom = aLCcopfSchema.getManageCom();
		this.MainPolno = aLCcopfSchema.getMainPolno();
		this.TtmprcNo = aLCcopfSchema.getTtmprcNo();
		this.OriginalAgentcode = aLCcopfSchema.getOriginalAgentcode();
		this.NewAgentcode = aLCcopfSchema.getNewAgentcode();
		this.ValidFlag = aLCcopfSchema.getValidFlag();
		this.UsrPrf = aLCcopfSchema.getUsrPrf();
		this.JobNm = aLCcopfSchema.getJobNm();
		this.DaTime = fDate.getDate( aLCcopfSchema.getDaTime());
		this.Reason = aLCcopfSchema.getReason();
		this.AssignmentDate = fDate.getDate( aLCcopfSchema.getAssignmentDate());
		this.ASAReceivedDate = fDate.getDate( aLCcopfSchema.getASAReceivedDate());
		this.ASAFlag = aLCcopfSchema.getASAFlag();
		this.OrhpanIndicator = aLCcopfSchema.getOrhpanIndicator();
		this.Remarks = aLCcopfSchema.getRemarks();
		this.Operator = aLCcopfSchema.getOperator();
		this.MakeDate = fDate.getDate( aLCcopfSchema.getMakeDate());
		this.MakeTime = aLCcopfSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLCcopfSchema.getModifyDate());
		this.ModifyTime = aLCcopfSchema.getModifyTime();
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
			if( rs.getString("ID") == null )
				this.ID = null;
			else
				this.ID = rs.getString("ID").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("MainPolno") == null )
				this.MainPolno = null;
			else
				this.MainPolno = rs.getString("MainPolno").trim();

			if( rs.getString("TtmprcNo") == null )
				this.TtmprcNo = null;
			else
				this.TtmprcNo = rs.getString("TtmprcNo").trim();

			if( rs.getString("OriginalAgentcode") == null )
				this.OriginalAgentcode = null;
			else
				this.OriginalAgentcode = rs.getString("OriginalAgentcode").trim();

			if( rs.getString("NewAgentcode") == null )
				this.NewAgentcode = null;
			else
				this.NewAgentcode = rs.getString("NewAgentcode").trim();

			if( rs.getString("ValidFlag") == null )
				this.ValidFlag = null;
			else
				this.ValidFlag = rs.getString("ValidFlag").trim();

			if( rs.getString("UsrPrf") == null )
				this.UsrPrf = null;
			else
				this.UsrPrf = rs.getString("UsrPrf").trim();

			if( rs.getString("JobNm") == null )
				this.JobNm = null;
			else
				this.JobNm = rs.getString("JobNm").trim();

			this.DaTime = rs.getDate("DaTime");
			if( rs.getString("Reason") == null )
				this.Reason = null;
			else
				this.Reason = rs.getString("Reason").trim();

			this.AssignmentDate = rs.getDate("AssignmentDate");
			this.ASAReceivedDate = rs.getDate("ASAReceivedDate");
			if( rs.getString("ASAFlag") == null )
				this.ASAFlag = null;
			else
				this.ASAFlag = rs.getString("ASAFlag").trim();

			if( rs.getString("OrhpanIndicator") == null )
				this.OrhpanIndicator = null;
			else
				this.OrhpanIndicator = rs.getString("OrhpanIndicator").trim();

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
			logger.debug("数据库中的LCcopf表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCcopfSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LCcopfSchema getSchema()
	{
		LCcopfSchema aLCcopfSchema = new LCcopfSchema();
		aLCcopfSchema.setSchema(this);
		return aLCcopfSchema;
	}

	public LCcopfDB getDB()
	{
		LCcopfDB aDBOper = new LCcopfDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCcopf描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainPolno)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TtmprcNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OriginalAgentcode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NewAgentcode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ValidFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UsrPrf)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(JobNm)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( DaTime ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Reason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( AssignmentDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ASAReceivedDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ASAFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OrhpanIndicator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCcopf>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			MainPolno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			TtmprcNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			OriginalAgentcode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			NewAgentcode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			ValidFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			UsrPrf = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			JobNm = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			DaTime = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			Reason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			AssignmentDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			ASAReceivedDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			ASAFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			OrhpanIndicator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCcopfSchema";
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
		if (FCode.equalsIgnoreCase("ID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ID));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("MainPolno"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainPolno));
		}
		if (FCode.equalsIgnoreCase("TtmprcNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TtmprcNo));
		}
		if (FCode.equalsIgnoreCase("OriginalAgentcode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OriginalAgentcode));
		}
		if (FCode.equalsIgnoreCase("NewAgentcode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NewAgentcode));
		}
		if (FCode.equalsIgnoreCase("ValidFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ValidFlag));
		}
		if (FCode.equalsIgnoreCase("UsrPrf"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UsrPrf));
		}
		if (FCode.equalsIgnoreCase("JobNm"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(JobNm));
		}
		if (FCode.equalsIgnoreCase("DaTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getDaTime()));
		}
		if (FCode.equalsIgnoreCase("Reason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Reason));
		}
		if (FCode.equalsIgnoreCase("AssignmentDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getAssignmentDate()));
		}
		if (FCode.equalsIgnoreCase("ASAReceivedDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
		}
		if (FCode.equalsIgnoreCase("ASAFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ASAFlag));
		}
		if (FCode.equalsIgnoreCase("OrhpanIndicator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OrhpanIndicator));
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
				strFieldValue = StrTool.GBKToUnicode(ID);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(MainPolno);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(TtmprcNo);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(OriginalAgentcode);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(NewAgentcode);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(ValidFlag);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(UsrPrf);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(JobNm);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getDaTime()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(Reason);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getAssignmentDate()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(ASAFlag);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(OrhpanIndicator);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
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

		if (FCode.equalsIgnoreCase("ID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ID = FValue.trim();
			}
			else
				ID = null;
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
		if (FCode.equalsIgnoreCase("MainPolno"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MainPolno = FValue.trim();
			}
			else
				MainPolno = null;
		}
		if (FCode.equalsIgnoreCase("TtmprcNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TtmprcNo = FValue.trim();
			}
			else
				TtmprcNo = null;
		}
		if (FCode.equalsIgnoreCase("OriginalAgentcode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OriginalAgentcode = FValue.trim();
			}
			else
				OriginalAgentcode = null;
		}
		if (FCode.equalsIgnoreCase("NewAgentcode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NewAgentcode = FValue.trim();
			}
			else
				NewAgentcode = null;
		}
		if (FCode.equalsIgnoreCase("ValidFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ValidFlag = FValue.trim();
			}
			else
				ValidFlag = null;
		}
		if (FCode.equalsIgnoreCase("UsrPrf"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UsrPrf = FValue.trim();
			}
			else
				UsrPrf = null;
		}
		if (FCode.equalsIgnoreCase("JobNm"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				JobNm = FValue.trim();
			}
			else
				JobNm = null;
		}
		if (FCode.equalsIgnoreCase("DaTime"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				DaTime = fDate.getDate( FValue );
			}
			else
				DaTime = null;
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
		if (FCode.equalsIgnoreCase("AssignmentDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				AssignmentDate = fDate.getDate( FValue );
			}
			else
				AssignmentDate = null;
		}
		if (FCode.equalsIgnoreCase("ASAReceivedDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ASAReceivedDate = fDate.getDate( FValue );
			}
			else
				ASAReceivedDate = null;
		}
		if (FCode.equalsIgnoreCase("ASAFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ASAFlag = FValue.trim();
			}
			else
				ASAFlag = null;
		}
		if (FCode.equalsIgnoreCase("OrhpanIndicator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OrhpanIndicator = FValue.trim();
			}
			else
				OrhpanIndicator = null;
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
		LCcopfSchema other = (LCcopfSchema)otherObject;
		return
			ID.equals(other.getID())
			&& ManageCom.equals(other.getManageCom())
			&& MainPolno.equals(other.getMainPolno())
			&& TtmprcNo.equals(other.getTtmprcNo())
			&& OriginalAgentcode.equals(other.getOriginalAgentcode())
			&& NewAgentcode.equals(other.getNewAgentcode())
			&& ValidFlag.equals(other.getValidFlag())
			&& UsrPrf.equals(other.getUsrPrf())
			&& JobNm.equals(other.getJobNm())
			&& fDate.getString(DaTime).equals(other.getDaTime())
			&& Reason.equals(other.getReason())
			&& fDate.getString(AssignmentDate).equals(other.getAssignmentDate())
			&& fDate.getString(ASAReceivedDate).equals(other.getASAReceivedDate())
			&& ASAFlag.equals(other.getASAFlag())
			&& OrhpanIndicator.equals(other.getOrhpanIndicator())
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
		if( strFieldName.equals("ID") ) {
			return 0;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 1;
		}
		if( strFieldName.equals("MainPolno") ) {
			return 2;
		}
		if( strFieldName.equals("TtmprcNo") ) {
			return 3;
		}
		if( strFieldName.equals("OriginalAgentcode") ) {
			return 4;
		}
		if( strFieldName.equals("NewAgentcode") ) {
			return 5;
		}
		if( strFieldName.equals("ValidFlag") ) {
			return 6;
		}
		if( strFieldName.equals("UsrPrf") ) {
			return 7;
		}
		if( strFieldName.equals("JobNm") ) {
			return 8;
		}
		if( strFieldName.equals("DaTime") ) {
			return 9;
		}
		if( strFieldName.equals("Reason") ) {
			return 10;
		}
		if( strFieldName.equals("AssignmentDate") ) {
			return 11;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return 12;
		}
		if( strFieldName.equals("ASAFlag") ) {
			return 13;
		}
		if( strFieldName.equals("OrhpanIndicator") ) {
			return 14;
		}
		if( strFieldName.equals("Remarks") ) {
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
				strFieldName = "ID";
				break;
			case 1:
				strFieldName = "ManageCom";
				break;
			case 2:
				strFieldName = "MainPolno";
				break;
			case 3:
				strFieldName = "TtmprcNo";
				break;
			case 4:
				strFieldName = "OriginalAgentcode";
				break;
			case 5:
				strFieldName = "NewAgentcode";
				break;
			case 6:
				strFieldName = "ValidFlag";
				break;
			case 7:
				strFieldName = "UsrPrf";
				break;
			case 8:
				strFieldName = "JobNm";
				break;
			case 9:
				strFieldName = "DaTime";
				break;
			case 10:
				strFieldName = "Reason";
				break;
			case 11:
				strFieldName = "AssignmentDate";
				break;
			case 12:
				strFieldName = "ASAReceivedDate";
				break;
			case 13:
				strFieldName = "ASAFlag";
				break;
			case 14:
				strFieldName = "OrhpanIndicator";
				break;
			case 15:
				strFieldName = "Remarks";
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
		if( strFieldName.equals("ID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainPolno") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TtmprcNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OriginalAgentcode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NewAgentcode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ValidFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UsrPrf") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("JobNm") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DaTime") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Reason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AssignmentDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ASAFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OrhpanIndicator") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_DATE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
