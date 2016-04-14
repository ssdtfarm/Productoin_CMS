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
import com.sinosoft.lis.db.LAOrphanCommisionBDB;

/*
 * <p>ClassName: LAOrphanCommisionBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAOrphanCommisionBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAOrphanCommisionBSchema.class);
	// @Field
	/** Commisionsn */
	private String CommisionSN;
	/** Mainpolno */
	private String MainPolNo;
	/** Serviceagentcode */
	private String ServiceAgentCode;
	/** Leaderagentcode */
	private String LeaderAgentCode;
	/** Isleader */
	private String ISLeader;
	/** Sagentaccountamt */
	private double SAgentAccountAmt;
	/** Leaderaccountamt */
	private double LeaderAccountAmt;
	/** Companyaccountamt */
	private double CompanyAccountAmt;
	/** Assigndate */
	private Date AssignDate;
	/** Asareceiveddate */
	private Date ASAReceivedDate;
	/** Remark */
	private String Remark;
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
	/** Operator1 */
	private String Operator1;
	/** Makedate1 */
	private Date MakeDate1;
	/** Maketime1 */
	private String MakeTime1;

	public static final int FIELDNUM = 19;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAOrphanCommisionBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "CommisionSN";
		pk[1] = "Operator1";
		pk[2] = "MakeDate1";
		pk[3] = "MakeTime1";

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
		LAOrphanCommisionBSchema cloned = (LAOrphanCommisionBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	/**
	* 对应lacommision-commisionsn
	*/
	public String getCommisionSN()
	{
		return CommisionSN;
	}
	public void setCommisionSN(String aCommisionSN)
	{
		if(aCommisionSN!=null && aCommisionSN.length()>12)
			throw new IllegalArgumentException("CommisionsnCommisionSN值"+aCommisionSN+"的长度"+aCommisionSN.length()+"大于最大值12");
		CommisionSN = aCommisionSN;
	}
	/**
	* 保单号
	*/
	public String getMainPolNo()
	{
		return MainPolNo;
	}
	public void setMainPolNo(String aMainPolNo)
	{
		if(aMainPolNo!=null && aMainPolNo.length()>8)
			throw new IllegalArgumentException("MainpolnoMainPolNo值"+aMainPolNo+"的长度"+aMainPolNo.length()+"大于最大值8");
		MainPolNo = aMainPolNo;
	}
	/**
	* Assign的新服务代理人编码
	*/
	public String getServiceAgentCode()
	{
		return ServiceAgentCode;
	}
	public void setServiceAgentCode(String aServiceAgentCode)
	{
		if(aServiceAgentCode!=null && aServiceAgentCode.length()>12)
			throw new IllegalArgumentException("ServiceagentcodeServiceAgentCode值"+aServiceAgentCode+"的长度"+aServiceAgentCode.length()+"大于最大值12");
		ServiceAgentCode = aServiceAgentCode;
	}
	/**
	* Assign的新服务代理人ReportingLeader人员编码
	*/
	public String getLeaderAgentCode()
	{
		return LeaderAgentCode;
	}
	public void setLeaderAgentCode(String aLeaderAgentCode)
	{
		if(aLeaderAgentCode!=null && aLeaderAgentCode.length()>12)
			throw new IllegalArgumentException("LeaderagentcodeLeaderAgentCode值"+aLeaderAgentCode+"的长度"+aLeaderAgentCode.length()+"大于最大值12");
		LeaderAgentCode = aLeaderAgentCode;
	}
	/**
	* 服务代理人是否为主管标志【用以标记是计入服务代理人SecondAccount还是SUA；Y-SUA、N-SecondAccount】
	*/
	public String getISLeader()
	{
		return ISLeader;
	}
	public void setISLeader(String aISLeader)
	{
		if(aISLeader!=null && aISLeader.length()>2)
			throw new IllegalArgumentException("IsleaderISLeader值"+aISLeader+"的长度"+aISLeader.length()+"大于最大值2");
		ISLeader = aISLeader;
	}
	/**
	* 计入服务代理人账户金额
	*/
	public double getSAgentAccountAmt()
	{
		return SAgentAccountAmt;
	}
	public void setSAgentAccountAmt(double aSAgentAccountAmt)
	{
		SAgentAccountAmt = aSAgentAccountAmt;
	}
	public void setSAgentAccountAmt(String aSAgentAccountAmt)
	{
		if (aSAgentAccountAmt != null && !aSAgentAccountAmt.equals(""))
		{
			Double tDouble = new Double(aSAgentAccountAmt);
			double d = tDouble.doubleValue();
			SAgentAccountAmt = d;
		}
	}

	/**
	* 计入Leader账户金额
	*/
	public double getLeaderAccountAmt()
	{
		return LeaderAccountAmt;
	}
	public void setLeaderAccountAmt(double aLeaderAccountAmt)
	{
		LeaderAccountAmt = aLeaderAccountAmt;
	}
	public void setLeaderAccountAmt(String aLeaderAccountAmt)
	{
		if (aLeaderAccountAmt != null && !aLeaderAccountAmt.equals(""))
		{
			Double tDouble = new Double(aLeaderAccountAmt);
			double d = tDouble.doubleValue();
			LeaderAccountAmt = d;
		}
	}

	/**
	* 计入公司账户金额
	*/
	public double getCompanyAccountAmt()
	{
		return CompanyAccountAmt;
	}
	public void setCompanyAccountAmt(double aCompanyAccountAmt)
	{
		CompanyAccountAmt = aCompanyAccountAmt;
	}
	public void setCompanyAccountAmt(String aCompanyAccountAmt)
	{
		if (aCompanyAccountAmt != null && !aCompanyAccountAmt.equals(""))
		{
			Double tDouble = new Double(aCompanyAccountAmt);
			double d = tDouble.doubleValue();
			CompanyAccountAmt = d;
		}
	}

	/**
	* 保单归属变更日期，为Assign功能中录入AssignDate
	*/
	public String getAssignDate()
	{
		if( AssignDate != null )
			return fDate.getString(AssignDate);
		else
			return null;
	}
	public void setAssignDate(Date aAssignDate)
	{
		AssignDate = aAssignDate;
	}
	public void setAssignDate(String aAssignDate)
	{
		if (aAssignDate != null && !aAssignDate.equals("") )
		{
			AssignDate = fDate.getDate( aAssignDate );
		}
		else
			AssignDate = null;
	}

	/**
	* 保单ASA回执日期
	*/
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

	/**
	* 备注
	*/
	public String getRemark()
	{
		return Remark;
	}
	public void setRemark(String aRemark)
	{
		if(aRemark!=null && aRemark.length()>1000)
			throw new IllegalArgumentException("RemarkRemark值"+aRemark+"的长度"+aRemark.length()+"大于最大值1000");
		Remark = aRemark;
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
	* Operator1
	*/
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
	* MakeDate1
	*/
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

	/**
	* MakeTime1
	*/
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
	* 使用另外一个 LAOrphanCommisionBSchema 对象给 Schema 赋值
	* @param: aLAOrphanCommisionBSchema LAOrphanCommisionBSchema
	**/
	public void setSchema(LAOrphanCommisionBSchema aLAOrphanCommisionBSchema)
	{
		this.CommisionSN = aLAOrphanCommisionBSchema.getCommisionSN();
		this.MainPolNo = aLAOrphanCommisionBSchema.getMainPolNo();
		this.ServiceAgentCode = aLAOrphanCommisionBSchema.getServiceAgentCode();
		this.LeaderAgentCode = aLAOrphanCommisionBSchema.getLeaderAgentCode();
		this.ISLeader = aLAOrphanCommisionBSchema.getISLeader();
		this.SAgentAccountAmt = aLAOrphanCommisionBSchema.getSAgentAccountAmt();
		this.LeaderAccountAmt = aLAOrphanCommisionBSchema.getLeaderAccountAmt();
		this.CompanyAccountAmt = aLAOrphanCommisionBSchema.getCompanyAccountAmt();
		this.AssignDate = fDate.getDate( aLAOrphanCommisionBSchema.getAssignDate());
		this.ASAReceivedDate = fDate.getDate( aLAOrphanCommisionBSchema.getASAReceivedDate());
		this.Remark = aLAOrphanCommisionBSchema.getRemark();
		this.Operator = aLAOrphanCommisionBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAOrphanCommisionBSchema.getMakeDate());
		this.MakeTime = aLAOrphanCommisionBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAOrphanCommisionBSchema.getModifyDate());
		this.ModifyTime = aLAOrphanCommisionBSchema.getModifyTime();
		this.Operator1 = aLAOrphanCommisionBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLAOrphanCommisionBSchema.getMakeDate1());
		this.MakeTime1 = aLAOrphanCommisionBSchema.getMakeTime1();
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
			if( rs.getString("CommisionSN") == null )
				this.CommisionSN = null;
			else
				this.CommisionSN = rs.getString("CommisionSN").trim();

			if( rs.getString("MainPolNo") == null )
				this.MainPolNo = null;
			else
				this.MainPolNo = rs.getString("MainPolNo").trim();

			if( rs.getString("ServiceAgentCode") == null )
				this.ServiceAgentCode = null;
			else
				this.ServiceAgentCode = rs.getString("ServiceAgentCode").trim();

			if( rs.getString("LeaderAgentCode") == null )
				this.LeaderAgentCode = null;
			else
				this.LeaderAgentCode = rs.getString("LeaderAgentCode").trim();

			if( rs.getString("ISLeader") == null )
				this.ISLeader = null;
			else
				this.ISLeader = rs.getString("ISLeader").trim();

			this.SAgentAccountAmt = rs.getDouble("SAgentAccountAmt");
			this.LeaderAccountAmt = rs.getDouble("LeaderAccountAmt");
			this.CompanyAccountAmt = rs.getDouble("CompanyAccountAmt");
			this.AssignDate = rs.getDate("AssignDate");
			this.ASAReceivedDate = rs.getDate("ASAReceivedDate");
			if( rs.getString("Remark") == null )
				this.Remark = null;
			else
				this.Remark = rs.getString("Remark").trim();

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

			if( rs.getString("Operator1") == null )
				this.Operator1 = null;
			else
				this.Operator1 = rs.getString("Operator1").trim();

			this.MakeDate1 = rs.getDate("MakeDate1");
			if( rs.getString("MakeTime1") == null )
				this.MakeTime1 = null;
			else
				this.MakeTime1 = rs.getString("MakeTime1").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAOrphanCommisionB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAOrphanCommisionBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAOrphanCommisionBSchema getSchema()
	{
		LAOrphanCommisionBSchema aLAOrphanCommisionBSchema = new LAOrphanCommisionBSchema();
		aLAOrphanCommisionBSchema.setSchema(this);
		return aLAOrphanCommisionBSchema;
	}

	public LAOrphanCommisionBDB getDB()
	{
		LAOrphanCommisionBDB aDBOper = new LAOrphanCommisionBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAOrphanCommisionB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(CommisionSN)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainPolNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ServiceAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LeaderAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ISLeader)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SAgentAccountAmt));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(LeaderAccountAmt));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(CompanyAccountAmt));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( AssignDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ASAReceivedDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remark)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAOrphanCommisionB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			CommisionSN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			MainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ServiceAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			LeaderAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			ISLeader = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			SAgentAccountAmt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,6,SysConst.PACKAGESPILTER))).doubleValue();
			LeaderAccountAmt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			CompanyAccountAmt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,8,SysConst.PACKAGESPILTER))).doubleValue();
			AssignDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			ASAReceivedDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAOrphanCommisionBSchema";
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
		if (FCode.equalsIgnoreCase("CommisionSN"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CommisionSN));
		}
		if (FCode.equalsIgnoreCase("MainPolNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainPolNo));
		}
		if (FCode.equalsIgnoreCase("ServiceAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ServiceAgentCode));
		}
		if (FCode.equalsIgnoreCase("LeaderAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LeaderAgentCode));
		}
		if (FCode.equalsIgnoreCase("ISLeader"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ISLeader));
		}
		if (FCode.equalsIgnoreCase("SAgentAccountAmt"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SAgentAccountAmt));
		}
		if (FCode.equalsIgnoreCase("LeaderAccountAmt"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LeaderAccountAmt));
		}
		if (FCode.equalsIgnoreCase("CompanyAccountAmt"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CompanyAccountAmt));
		}
		if (FCode.equalsIgnoreCase("AssignDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getAssignDate()));
		}
		if (FCode.equalsIgnoreCase("ASAReceivedDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remark));
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
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator1));
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
				strFieldValue = StrTool.GBKToUnicode(CommisionSN);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(MainPolNo);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ServiceAgentCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(LeaderAgentCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(ISLeader);
				break;
			case 5:
				strFieldValue = String.valueOf(SAgentAccountAmt);
				break;
			case 6:
				strFieldValue = String.valueOf(LeaderAccountAmt);
				break;
			case 7:
				strFieldValue = String.valueOf(CompanyAccountAmt);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getAssignDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(Remark);
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
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 18:
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

		if (FCode.equalsIgnoreCase("CommisionSN"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CommisionSN = FValue.trim();
			}
			else
				CommisionSN = null;
		}
		if (FCode.equalsIgnoreCase("MainPolNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MainPolNo = FValue.trim();
			}
			else
				MainPolNo = null;
		}
		if (FCode.equalsIgnoreCase("ServiceAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ServiceAgentCode = FValue.trim();
			}
			else
				ServiceAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("LeaderAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LeaderAgentCode = FValue.trim();
			}
			else
				LeaderAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("ISLeader"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ISLeader = FValue.trim();
			}
			else
				ISLeader = null;
		}
		if (FCode.equalsIgnoreCase("SAgentAccountAmt"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				SAgentAccountAmt = d;
			}
		}
		if (FCode.equalsIgnoreCase("LeaderAccountAmt"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				LeaderAccountAmt = d;
			}
		}
		if (FCode.equalsIgnoreCase("CompanyAccountAmt"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				CompanyAccountAmt = d;
			}
		}
		if (FCode.equalsIgnoreCase("AssignDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				AssignDate = fDate.getDate( FValue );
			}
			else
				AssignDate = null;
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
		if (FCode.equalsIgnoreCase("Remark"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Remark = FValue.trim();
			}
			else
				Remark = null;
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
		if (FCode.equalsIgnoreCase("Operator1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator1 = FValue.trim();
			}
			else
				Operator1 = null;
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
		LAOrphanCommisionBSchema other = (LAOrphanCommisionBSchema)otherObject;
		return
			CommisionSN.equals(other.getCommisionSN())
			&& MainPolNo.equals(other.getMainPolNo())
			&& ServiceAgentCode.equals(other.getServiceAgentCode())
			&& LeaderAgentCode.equals(other.getLeaderAgentCode())
			&& ISLeader.equals(other.getISLeader())
			&& SAgentAccountAmt == other.getSAgentAccountAmt()
			&& LeaderAccountAmt == other.getLeaderAccountAmt()
			&& CompanyAccountAmt == other.getCompanyAccountAmt()
			&& fDate.getString(AssignDate).equals(other.getAssignDate())
			&& fDate.getString(ASAReceivedDate).equals(other.getASAReceivedDate())
			&& Remark.equals(other.getRemark())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator1.equals(other.getOperator1())
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
		if( strFieldName.equals("CommisionSN") ) {
			return 0;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return 1;
		}
		if( strFieldName.equals("ServiceAgentCode") ) {
			return 2;
		}
		if( strFieldName.equals("LeaderAgentCode") ) {
			return 3;
		}
		if( strFieldName.equals("ISLeader") ) {
			return 4;
		}
		if( strFieldName.equals("SAgentAccountAmt") ) {
			return 5;
		}
		if( strFieldName.equals("LeaderAccountAmt") ) {
			return 6;
		}
		if( strFieldName.equals("CompanyAccountAmt") ) {
			return 7;
		}
		if( strFieldName.equals("AssignDate") ) {
			return 8;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return 9;
		}
		if( strFieldName.equals("Remark") ) {
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
		if( strFieldName.equals("ModifyDate") ) {
			return 14;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 15;
		}
		if( strFieldName.equals("Operator1") ) {
			return 16;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 17;
		}
		if( strFieldName.equals("MakeTime1") ) {
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
				strFieldName = "CommisionSN";
				break;
			case 1:
				strFieldName = "MainPolNo";
				break;
			case 2:
				strFieldName = "ServiceAgentCode";
				break;
			case 3:
				strFieldName = "LeaderAgentCode";
				break;
			case 4:
				strFieldName = "ISLeader";
				break;
			case 5:
				strFieldName = "SAgentAccountAmt";
				break;
			case 6:
				strFieldName = "LeaderAccountAmt";
				break;
			case 7:
				strFieldName = "CompanyAccountAmt";
				break;
			case 8:
				strFieldName = "AssignDate";
				break;
			case 9:
				strFieldName = "ASAReceivedDate";
				break;
			case 10:
				strFieldName = "Remark";
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
				strFieldName = "ModifyDate";
				break;
			case 15:
				strFieldName = "ModifyTime";
				break;
			case 16:
				strFieldName = "Operator1";
				break;
			case 17:
				strFieldName = "MakeDate1";
				break;
			case 18:
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
		if( strFieldName.equals("CommisionSN") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ServiceAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LeaderAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ISLeader") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SAgentAccountAmt") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("LeaderAccountAmt") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("CompanyAccountAmt") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("AssignDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Remark") ) {
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
		if( strFieldName.equals("Operator1") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
