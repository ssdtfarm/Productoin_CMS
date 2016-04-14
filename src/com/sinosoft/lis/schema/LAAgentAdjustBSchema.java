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
import com.sinosoft.lis.db.LAAgentAdjustBDB;

/*
 * <p>ClassName: LAAgentAdjustBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LAAgentSUA
 */
public class LAAgentAdjustBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentAdjustBSchema.class);
	// @Field
	/** 加扣款序号 */
	private String AdjustSN;
	/** 代理人编码 */
	private String AgentCode;
	/** 加扣款日期 */
	private Date AdjustDate;
	/** 加扣款年月 */
	private String AdjustMonth;
	/** 加扣款科目 */
	private String SubjectCode;
	/** 加扣款金额 */
	private double Amount;
	/** 支付机构类别（预留） */
	private String PaymentOrganisationType;
	/** 支付机构（预留） */
	private String PaymentOrganisation;
	/** 备注 */
	private String Remark;
	/** Caltype */
	private String CalType;
	/** 加扣款状态 */
	private String PaymentState;
	/** 审核标志 */
	private String ApprovalFlag;
	/** 审核操作员 */
	private String ApprovalOperator;
	/** 审核时间 */
	private Date ApprovalDate;
	/** 原因 */
	private String Reason;
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

	public static final int FIELDNUM = 23;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentAdjustBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "AdjustSN";
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
		LAAgentAdjustBSchema cloned = (LAAgentAdjustBSchema)super.clone();
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
	* 加扣款序号
	*/
	public String getAdjustSN()
	{
		return AdjustSN;
	}
	public void setAdjustSN(String aAdjustSN)
	{
		if(aAdjustSN!=null && aAdjustSN.length()>10)
			throw new IllegalArgumentException("加扣款序号AdjustSN值"+aAdjustSN+"的长度"+aAdjustSN.length()+"大于最大值10");
		AdjustSN = aAdjustSN;
	}
	/**
	* 代理人编码
	*/
	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>12)
			throw new IllegalArgumentException("代理人编码AgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值12");
		AgentCode = aAgentCode;
	}
	/**
	* 加扣款日期
	*/
	public String getAdjustDate()
	{
		if( AdjustDate != null )
			return fDate.getString(AdjustDate);
		else
			return null;
	}
	public void setAdjustDate(Date aAdjustDate)
	{
		AdjustDate = aAdjustDate;
	}
	public void setAdjustDate(String aAdjustDate)
	{
		if (aAdjustDate != null && !aAdjustDate.equals("") )
		{
			AdjustDate = fDate.getDate( aAdjustDate );
		}
		else
			AdjustDate = null;
	}

	/**
	* 加扣款年月【根据AdjustDate自动转】
	*/
	public String getAdjustMonth()
	{
		return AdjustMonth;
	}
	public void setAdjustMonth(String aAdjustMonth)
	{
		if(aAdjustMonth!=null && aAdjustMonth.length()>6)
			throw new IllegalArgumentException("加扣款年月AdjustMonth值"+aAdjustMonth+"的长度"+aAdjustMonth.length()+"大于最大值6");
		AdjustMonth = aAdjustMonth;
	}
	/**
	* 加扣款科目
	*/
	public String getSubjectCode()
	{
		return SubjectCode;
	}
	public void setSubjectCode(String aSubjectCode)
	{
		if(aSubjectCode!=null && aSubjectCode.length()>10)
			throw new IllegalArgumentException("加扣款科目SubjectCode值"+aSubjectCode+"的长度"+aSubjectCode.length()+"大于最大值10");
		SubjectCode = aSubjectCode;
	}
	/**
	* 加扣款金额
	*/
	public double getAmount()
	{
		return Amount;
	}
	public void setAmount(double aAmount)
	{
		Amount = aAmount;
	}
	public void setAmount(String aAmount)
	{
		if (aAmount != null && !aAmount.equals(""))
		{
			Double tDouble = new Double(aAmount);
			double d = tDouble.doubleValue();
			Amount = d;
		}
	}

	/**
	* 支付机构类别（预留）
	*/
	public String getPaymentOrganisationType()
	{
		return PaymentOrganisationType;
	}
	public void setPaymentOrganisationType(String aPaymentOrganisationType)
	{
		if(aPaymentOrganisationType!=null && aPaymentOrganisationType.length()>50)
			throw new IllegalArgumentException("支付机构类别（预留）PaymentOrganisationType值"+aPaymentOrganisationType+"的长度"+aPaymentOrganisationType.length()+"大于最大值50");
		PaymentOrganisationType = aPaymentOrganisationType;
	}
	/**
	* 支付机构（预留）
	*/
	public String getPaymentOrganisation()
	{
		return PaymentOrganisation;
	}
	public void setPaymentOrganisation(String aPaymentOrganisation)
	{
		if(aPaymentOrganisation!=null && aPaymentOrganisation.length()>50)
			throw new IllegalArgumentException("支付机构（预留）PaymentOrganisation值"+aPaymentOrganisation+"的长度"+aPaymentOrganisation.length()+"大于最大值50");
		PaymentOrganisation = aPaymentOrganisation;
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
		if(aRemark!=null && aRemark.length()>500)
			throw new IllegalArgumentException("备注Remark值"+aRemark+"的长度"+aRemark.length()+"大于最大值500");
		Remark = aRemark;
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
	/**
	* 加扣款状态【同薪资状态（未计算，计算待审核，审核通过）】
	*/
	public String getPaymentState()
	{
		return PaymentState;
	}
	public void setPaymentState(String aPaymentState)
	{
		if(aPaymentState!=null && aPaymentState.length()>2)
			throw new IllegalArgumentException("加扣款状态PaymentState值"+aPaymentState+"的长度"+aPaymentState.length()+"大于最大值2");
		PaymentState = aPaymentState;
	}
	public String getApprovalFlag()
	{
		return ApprovalFlag;
	}
	public void setApprovalFlag(String aApprovalFlag)
	{
		if(aApprovalFlag!=null && aApprovalFlag.length()>2)
			throw new IllegalArgumentException("审核标志ApprovalFlag值"+aApprovalFlag+"的长度"+aApprovalFlag.length()+"大于最大值2");
		ApprovalFlag = aApprovalFlag;
	}
	public String getApprovalOperator()
	{
		return ApprovalOperator;
	}
	public void setApprovalOperator(String aApprovalOperator)
	{
		if(aApprovalOperator!=null && aApprovalOperator.length()>60)
			throw new IllegalArgumentException("审核操作员ApprovalOperator值"+aApprovalOperator+"的长度"+aApprovalOperator.length()+"大于最大值60");
		ApprovalOperator = aApprovalOperator;
	}
	public String getApprovalDate()
	{
		if( ApprovalDate != null )
			return fDate.getString(ApprovalDate);
		else
			return null;
	}
	public void setApprovalDate(Date aApprovalDate)
	{
		ApprovalDate = aApprovalDate;
	}
	public void setApprovalDate(String aApprovalDate)
	{
		if (aApprovalDate != null && !aApprovalDate.equals("") )
		{
			ApprovalDate = fDate.getDate( aApprovalDate );
		}
		else
			ApprovalDate = null;
	}

	public String getReason()
	{
		return Reason;
	}
	public void setReason(String aReason)
	{
		if(aReason!=null && aReason.length()>60)
			throw new IllegalArgumentException("原因Reason值"+aReason+"的长度"+aReason.length()+"大于最大值60");
		Reason = aReason;
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
	* 使用另外一个 LAAgentAdjustBSchema 对象给 Schema 赋值
	* @param: aLAAgentAdjustBSchema LAAgentAdjustBSchema
	**/
	public void setSchema(LAAgentAdjustBSchema aLAAgentAdjustBSchema)
	{
		this.AdjustSN = aLAAgentAdjustBSchema.getAdjustSN();
		this.AgentCode = aLAAgentAdjustBSchema.getAgentCode();
		this.AdjustDate = fDate.getDate( aLAAgentAdjustBSchema.getAdjustDate());
		this.AdjustMonth = aLAAgentAdjustBSchema.getAdjustMonth();
		this.SubjectCode = aLAAgentAdjustBSchema.getSubjectCode();
		this.Amount = aLAAgentAdjustBSchema.getAmount();
		this.PaymentOrganisationType = aLAAgentAdjustBSchema.getPaymentOrganisationType();
		this.PaymentOrganisation = aLAAgentAdjustBSchema.getPaymentOrganisation();
		this.Remark = aLAAgentAdjustBSchema.getRemark();
		this.CalType = aLAAgentAdjustBSchema.getCalType();
		this.PaymentState = aLAAgentAdjustBSchema.getPaymentState();
		this.ApprovalFlag = aLAAgentAdjustBSchema.getApprovalFlag();
		this.ApprovalOperator = aLAAgentAdjustBSchema.getApprovalOperator();
		this.ApprovalDate = fDate.getDate( aLAAgentAdjustBSchema.getApprovalDate());
		this.Reason = aLAAgentAdjustBSchema.getReason();
		this.Operator = aLAAgentAdjustBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentAdjustBSchema.getMakeDate());
		this.MakeTime = aLAAgentAdjustBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentAdjustBSchema.getModifyDate());
		this.ModifyTime = aLAAgentAdjustBSchema.getModifyTime();
		this.Operator1 = aLAAgentAdjustBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLAAgentAdjustBSchema.getMakeDate1());
		this.MakeTime1 = aLAAgentAdjustBSchema.getMakeTime1();
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
			if( rs.getString("AdjustSN") == null )
				this.AdjustSN = null;
			else
				this.AdjustSN = rs.getString("AdjustSN").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			this.AdjustDate = rs.getDate("AdjustDate");
			if( rs.getString("AdjustMonth") == null )
				this.AdjustMonth = null;
			else
				this.AdjustMonth = rs.getString("AdjustMonth").trim();

			if( rs.getString("SubjectCode") == null )
				this.SubjectCode = null;
			else
				this.SubjectCode = rs.getString("SubjectCode").trim();

			this.Amount = rs.getDouble("Amount");
			if( rs.getString("PaymentOrganisationType") == null )
				this.PaymentOrganisationType = null;
			else
				this.PaymentOrganisationType = rs.getString("PaymentOrganisationType").trim();

			if( rs.getString("PaymentOrganisation") == null )
				this.PaymentOrganisation = null;
			else
				this.PaymentOrganisation = rs.getString("PaymentOrganisation").trim();

			if( rs.getString("Remark") == null )
				this.Remark = null;
			else
				this.Remark = rs.getString("Remark").trim();

			if( rs.getString("CalType") == null )
				this.CalType = null;
			else
				this.CalType = rs.getString("CalType").trim();

			if( rs.getString("PaymentState") == null )
				this.PaymentState = null;
			else
				this.PaymentState = rs.getString("PaymentState").trim();

			if( rs.getString("ApprovalFlag") == null )
				this.ApprovalFlag = null;
			else
				this.ApprovalFlag = rs.getString("ApprovalFlag").trim();

			if( rs.getString("ApprovalOperator") == null )
				this.ApprovalOperator = null;
			else
				this.ApprovalOperator = rs.getString("ApprovalOperator").trim();

			this.ApprovalDate = rs.getDate("ApprovalDate");
			if( rs.getString("Reason") == null )
				this.Reason = null;
			else
				this.Reason = rs.getString("Reason").trim();

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
			logger.debug("数据库中的LAAgentAdjustB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentAdjustBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentAdjustBSchema getSchema()
	{
		LAAgentAdjustBSchema aLAAgentAdjustBSchema = new LAAgentAdjustBSchema();
		aLAAgentAdjustBSchema.setSchema(this);
		return aLAAgentAdjustBSchema;
	}

	public LAAgentAdjustBDB getDB()
	{
		LAAgentAdjustBDB aDBOper = new LAAgentAdjustBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentAdjustB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AdjustSN)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( AdjustDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AdjustMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubjectCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Amount));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PaymentOrganisationType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PaymentOrganisation)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remark)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PaymentState)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ApprovalFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ApprovalOperator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ApprovalDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Reason)); strReturn.append(SysConst.PACKAGESPILTER);
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
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentAdjustB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AdjustSN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			AdjustDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3,SysConst.PACKAGESPILTER));
			AdjustMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			SubjectCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Amount = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,6,SysConst.PACKAGESPILTER))).doubleValue();
			PaymentOrganisationType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			PaymentOrganisation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			CalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			PaymentState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			ApprovalFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			ApprovalOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			ApprovalDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			Reason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentAdjustBSchema";
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
		if (FCode.equalsIgnoreCase("AdjustSN"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AdjustSN));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("AdjustDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getAdjustDate()));
		}
		if (FCode.equalsIgnoreCase("AdjustMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AdjustMonth));
		}
		if (FCode.equalsIgnoreCase("SubjectCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubjectCode));
		}
		if (FCode.equalsIgnoreCase("Amount"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Amount));
		}
		if (FCode.equalsIgnoreCase("PaymentOrganisationType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PaymentOrganisationType));
		}
		if (FCode.equalsIgnoreCase("PaymentOrganisation"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PaymentOrganisation));
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remark));
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalType));
		}
		if (FCode.equalsIgnoreCase("PaymentState"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PaymentState));
		}
		if (FCode.equalsIgnoreCase("ApprovalFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ApprovalFlag));
		}
		if (FCode.equalsIgnoreCase("ApprovalOperator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ApprovalOperator));
		}
		if (FCode.equalsIgnoreCase("ApprovalDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getApprovalDate()));
		}
		if (FCode.equalsIgnoreCase("Reason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Reason));
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
				strFieldValue = StrTool.GBKToUnicode(AdjustSN);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getAdjustDate()));
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(AdjustMonth);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(SubjectCode);
				break;
			case 5:
				strFieldValue = String.valueOf(Amount);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(PaymentOrganisationType);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(PaymentOrganisation);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Remark);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(CalType);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(PaymentState);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(ApprovalFlag);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(ApprovalOperator);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getApprovalDate()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Reason);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 22:
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

		if (FCode.equalsIgnoreCase("AdjustSN"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AdjustSN = FValue.trim();
			}
			else
				AdjustSN = null;
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
		if (FCode.equalsIgnoreCase("AdjustDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				AdjustDate = fDate.getDate( FValue );
			}
			else
				AdjustDate = null;
		}
		if (FCode.equalsIgnoreCase("AdjustMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AdjustMonth = FValue.trim();
			}
			else
				AdjustMonth = null;
		}
		if (FCode.equalsIgnoreCase("SubjectCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SubjectCode = FValue.trim();
			}
			else
				SubjectCode = null;
		}
		if (FCode.equalsIgnoreCase("Amount"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Amount = d;
			}
		}
		if (FCode.equalsIgnoreCase("PaymentOrganisationType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PaymentOrganisationType = FValue.trim();
			}
			else
				PaymentOrganisationType = null;
		}
		if (FCode.equalsIgnoreCase("PaymentOrganisation"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PaymentOrganisation = FValue.trim();
			}
			else
				PaymentOrganisation = null;
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
		if (FCode.equalsIgnoreCase("CalType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalType = FValue.trim();
			}
			else
				CalType = null;
		}
		if (FCode.equalsIgnoreCase("PaymentState"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PaymentState = FValue.trim();
			}
			else
				PaymentState = null;
		}
		if (FCode.equalsIgnoreCase("ApprovalFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ApprovalFlag = FValue.trim();
			}
			else
				ApprovalFlag = null;
		}
		if (FCode.equalsIgnoreCase("ApprovalOperator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ApprovalOperator = FValue.trim();
			}
			else
				ApprovalOperator = null;
		}
		if (FCode.equalsIgnoreCase("ApprovalDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ApprovalDate = fDate.getDate( FValue );
			}
			else
				ApprovalDate = null;
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
		LAAgentAdjustBSchema other = (LAAgentAdjustBSchema)otherObject;
		return
			AdjustSN.equals(other.getAdjustSN())
			&& AgentCode.equals(other.getAgentCode())
			&& fDate.getString(AdjustDate).equals(other.getAdjustDate())
			&& AdjustMonth.equals(other.getAdjustMonth())
			&& SubjectCode.equals(other.getSubjectCode())
			&& Amount == other.getAmount()
			&& PaymentOrganisationType.equals(other.getPaymentOrganisationType())
			&& PaymentOrganisation.equals(other.getPaymentOrganisation())
			&& Remark.equals(other.getRemark())
			&& CalType.equals(other.getCalType())
			&& PaymentState.equals(other.getPaymentState())
			&& ApprovalFlag.equals(other.getApprovalFlag())
			&& ApprovalOperator.equals(other.getApprovalOperator())
			&& fDate.getString(ApprovalDate).equals(other.getApprovalDate())
			&& Reason.equals(other.getReason())
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
		if( strFieldName.equals("AdjustSN") ) {
			return 0;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 1;
		}
		if( strFieldName.equals("AdjustDate") ) {
			return 2;
		}
		if( strFieldName.equals("AdjustMonth") ) {
			return 3;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return 4;
		}
		if( strFieldName.equals("Amount") ) {
			return 5;
		}
		if( strFieldName.equals("PaymentOrganisationType") ) {
			return 6;
		}
		if( strFieldName.equals("PaymentOrganisation") ) {
			return 7;
		}
		if( strFieldName.equals("Remark") ) {
			return 8;
		}
		if( strFieldName.equals("CalType") ) {
			return 9;
		}
		if( strFieldName.equals("PaymentState") ) {
			return 10;
		}
		if( strFieldName.equals("ApprovalFlag") ) {
			return 11;
		}
		if( strFieldName.equals("ApprovalOperator") ) {
			return 12;
		}
		if( strFieldName.equals("ApprovalDate") ) {
			return 13;
		}
		if( strFieldName.equals("Reason") ) {
			return 14;
		}
		if( strFieldName.equals("Operator") ) {
			return 15;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 16;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 17;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 18;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 19;
		}
		if( strFieldName.equals("Operator1") ) {
			return 20;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 21;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 22;
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
				strFieldName = "AdjustSN";
				break;
			case 1:
				strFieldName = "AgentCode";
				break;
			case 2:
				strFieldName = "AdjustDate";
				break;
			case 3:
				strFieldName = "AdjustMonth";
				break;
			case 4:
				strFieldName = "SubjectCode";
				break;
			case 5:
				strFieldName = "Amount";
				break;
			case 6:
				strFieldName = "PaymentOrganisationType";
				break;
			case 7:
				strFieldName = "PaymentOrganisation";
				break;
			case 8:
				strFieldName = "Remark";
				break;
			case 9:
				strFieldName = "CalType";
				break;
			case 10:
				strFieldName = "PaymentState";
				break;
			case 11:
				strFieldName = "ApprovalFlag";
				break;
			case 12:
				strFieldName = "ApprovalOperator";
				break;
			case 13:
				strFieldName = "ApprovalDate";
				break;
			case 14:
				strFieldName = "Reason";
				break;
			case 15:
				strFieldName = "Operator";
				break;
			case 16:
				strFieldName = "MakeDate";
				break;
			case 17:
				strFieldName = "MakeTime";
				break;
			case 18:
				strFieldName = "ModifyDate";
				break;
			case 19:
				strFieldName = "ModifyTime";
				break;
			case 20:
				strFieldName = "Operator1";
				break;
			case 21:
				strFieldName = "MakeDate1";
				break;
			case 22:
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
		if( strFieldName.equals("AdjustSN") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AdjustDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("AdjustMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubjectCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Amount") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("PaymentOrganisationType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PaymentOrganisation") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remark") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PaymentState") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ApprovalFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ApprovalOperator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ApprovalDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Reason") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 13:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
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
			case 18:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 20:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 21:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 22:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
