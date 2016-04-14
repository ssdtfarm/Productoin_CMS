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
import com.sinosoft.lis.db.DailyPolicyDetailsDB;

/*
 * <p>ClassName: DailyPolicyDetailsSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyPolicyDetailsSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(DailyPolicyDetailsSchema.class);
	// @Field
	/** Company_code */
	private String Company_Code;
	/** Policy_no */
	private String Policy_No;
	/** Product_code */
	private String Product_Code;
	/** Product_type */
	private String Product_Type;
	/** Link_or_no_link_product */
	private String Link_or_No_Link_Product;
	/** Agentcode1 */
	private String AgentCode1;
	/** Agentcode2 */
	private String AgentCode2;
	/** Splitrate1 */
	private double SplitRate1;
	/** Splitrate2 */
	private double SplitRate2;
	/** Servicing_agent_code */
	private String Servicing_Agent_Code;
	/** Risk_status */
	private String Risk_Status;
	/** Effective_date */
	private Date Effective_Date;
	/** First_issue_date */
	private Date First_Issue_Date;
	/** Reissue_issue_date */
	private Date Reissue_Issue_Date;
	/** Reinstatement_date */
	private Date Reinstatement_Date;
	/** Policy_owner_customer_id */
	private String Policy_Owner_Customer_ID;
	/** Policy_owner_name */
	private String Policy_Owner_Name;
	/** Owner_security_no */
	private String Owner_Security_No;
	/** Policy_insured_name */
	private String Policy_Insured_Name;
	/** Insured_security_no */
	private String Insured_Security_No;
	/** Old_policy_no */
	private String Old_Policy_No;
	/** Business_date */
	private Date Business_Date;
	/** Batch_no */
	private double Batch_No;
	/** Batch_run_date */
	private Date Batch_Run_Date;

	public static final int FIELDNUM = 24;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public DailyPolicyDetailsSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "Company_Code";
		pk[1] = "Policy_No";
		pk[2] = "Batch_No";
		pk[3] = "Batch_Run_Date";

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
		DailyPolicyDetailsSchema cloned = (DailyPolicyDetailsSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCompany_Code()
	{
		return Company_Code;
	}
	public void setCompany_Code(String aCompany_Code)
	{
		if(aCompany_Code!=null && aCompany_Code.length()>1)
			throw new IllegalArgumentException("Company_codeCompany_Code值"+aCompany_Code+"的长度"+aCompany_Code.length()+"大于最大值1");
		Company_Code = aCompany_Code;
	}
	public String getPolicy_No()
	{
		return Policy_No;
	}
	public void setPolicy_No(String aPolicy_No)
	{
		if(aPolicy_No!=null && aPolicy_No.length()>8)
			throw new IllegalArgumentException("Policy_noPolicy_No值"+aPolicy_No+"的长度"+aPolicy_No.length()+"大于最大值8");
		Policy_No = aPolicy_No;
	}
	public String getProduct_Code()
	{
		return Product_Code;
	}
	public void setProduct_Code(String aProduct_Code)
	{
		if(aProduct_Code!=null && aProduct_Code.length()>3)
			throw new IllegalArgumentException("Product_codeProduct_Code值"+aProduct_Code+"的长度"+aProduct_Code.length()+"大于最大值3");
		Product_Code = aProduct_Code;
	}
	public String getProduct_Type()
	{
		return Product_Type;
	}
	public void setProduct_Type(String aProduct_Type)
	{
		if(aProduct_Type!=null && aProduct_Type.length()>30)
			throw new IllegalArgumentException("Product_typeProduct_Type值"+aProduct_Type+"的长度"+aProduct_Type.length()+"大于最大值30");
		Product_Type = aProduct_Type;
	}
	public String getLink_or_No_Link_Product()
	{
		return Link_or_No_Link_Product;
	}
	public void setLink_or_No_Link_Product(String aLink_or_No_Link_Product)
	{
		if(aLink_or_No_Link_Product!=null && aLink_or_No_Link_Product.length()>1)
			throw new IllegalArgumentException("Link_or_no_link_productLink_or_No_Link_Product值"+aLink_or_No_Link_Product+"的长度"+aLink_or_No_Link_Product.length()+"大于最大值1");
		Link_or_No_Link_Product = aLink_or_No_Link_Product;
	}
	public String getAgentCode1()
	{
		return AgentCode1;
	}
	public void setAgentCode1(String aAgentCode1)
	{
		if(aAgentCode1!=null && aAgentCode1.length()>12)
			throw new IllegalArgumentException("Agentcode1AgentCode1值"+aAgentCode1+"的长度"+aAgentCode1.length()+"大于最大值12");
		AgentCode1 = aAgentCode1;
	}
	public String getAgentCode2()
	{
		return AgentCode2;
	}
	public void setAgentCode2(String aAgentCode2)
	{
		if(aAgentCode2!=null && aAgentCode2.length()>12)
			throw new IllegalArgumentException("Agentcode2AgentCode2值"+aAgentCode2+"的长度"+aAgentCode2.length()+"大于最大值12");
		AgentCode2 = aAgentCode2;
	}
	public double getSplitRate1()
	{
		return SplitRate1;
	}
	public void setSplitRate1(double aSplitRate1)
	{
		SplitRate1 = aSplitRate1;
	}
	public void setSplitRate1(String aSplitRate1)
	{
		if (aSplitRate1 != null && !aSplitRate1.equals(""))
		{
			Double tDouble = new Double(aSplitRate1);
			double d = tDouble.doubleValue();
			SplitRate1 = d;
		}
	}

	public double getSplitRate2()
	{
		return SplitRate2;
	}
	public void setSplitRate2(double aSplitRate2)
	{
		SplitRate2 = aSplitRate2;
	}
	public void setSplitRate2(String aSplitRate2)
	{
		if (aSplitRate2 != null && !aSplitRate2.equals(""))
		{
			Double tDouble = new Double(aSplitRate2);
			double d = tDouble.doubleValue();
			SplitRate2 = d;
		}
	}

	public String getServicing_Agent_Code()
	{
		return Servicing_Agent_Code;
	}
	public void setServicing_Agent_Code(String aServicing_Agent_Code)
	{
		if(aServicing_Agent_Code!=null && aServicing_Agent_Code.length()>12)
			throw new IllegalArgumentException("Servicing_agent_codeServicing_Agent_Code值"+aServicing_Agent_Code+"的长度"+aServicing_Agent_Code.length()+"大于最大值12");
		Servicing_Agent_Code = aServicing_Agent_Code;
	}
	public String getRisk_Status()
	{
		return Risk_Status;
	}
	public void setRisk_Status(String aRisk_Status)
	{
		if(aRisk_Status!=null && aRisk_Status.length()>2)
			throw new IllegalArgumentException("Risk_statusRisk_Status值"+aRisk_Status+"的长度"+aRisk_Status.length()+"大于最大值2");
		Risk_Status = aRisk_Status;
	}
	public String getEffective_Date()
	{
		if( Effective_Date != null )
			return fDate.getString(Effective_Date);
		else
			return null;
	}
	public void setEffective_Date(Date aEffective_Date)
	{
		Effective_Date = aEffective_Date;
	}
	public void setEffective_Date(String aEffective_Date)
	{
		if (aEffective_Date != null && !aEffective_Date.equals("") )
		{
			Effective_Date = fDate.getDate( aEffective_Date );
		}
		else
			Effective_Date = null;
	}

	public String getFirst_Issue_Date()
	{
		if( First_Issue_Date != null )
			return fDate.getString(First_Issue_Date);
		else
			return null;
	}
	public void setFirst_Issue_Date(Date aFirst_Issue_Date)
	{
		First_Issue_Date = aFirst_Issue_Date;
	}
	public void setFirst_Issue_Date(String aFirst_Issue_Date)
	{
		if (aFirst_Issue_Date != null && !aFirst_Issue_Date.equals("") )
		{
			First_Issue_Date = fDate.getDate( aFirst_Issue_Date );
		}
		else
			First_Issue_Date = null;
	}

	public String getReissue_Issue_Date()
	{
		if( Reissue_Issue_Date != null )
			return fDate.getString(Reissue_Issue_Date);
		else
			return null;
	}
	public void setReissue_Issue_Date(Date aReissue_Issue_Date)
	{
		Reissue_Issue_Date = aReissue_Issue_Date;
	}
	public void setReissue_Issue_Date(String aReissue_Issue_Date)
	{
		if (aReissue_Issue_Date != null && !aReissue_Issue_Date.equals("") )
		{
			Reissue_Issue_Date = fDate.getDate( aReissue_Issue_Date );
		}
		else
			Reissue_Issue_Date = null;
	}

	public String getReinstatement_Date()
	{
		if( Reinstatement_Date != null )
			return fDate.getString(Reinstatement_Date);
		else
			return null;
	}
	public void setReinstatement_Date(Date aReinstatement_Date)
	{
		Reinstatement_Date = aReinstatement_Date;
	}
	public void setReinstatement_Date(String aReinstatement_Date)
	{
		if (aReinstatement_Date != null && !aReinstatement_Date.equals("") )
		{
			Reinstatement_Date = fDate.getDate( aReinstatement_Date );
		}
		else
			Reinstatement_Date = null;
	}

	public String getPolicy_Owner_Customer_ID()
	{
		return Policy_Owner_Customer_ID;
	}
	public void setPolicy_Owner_Customer_ID(String aPolicy_Owner_Customer_ID)
	{
		if(aPolicy_Owner_Customer_ID!=null && aPolicy_Owner_Customer_ID.length()>8)
			throw new IllegalArgumentException("Policy_owner_customer_idPolicy_Owner_Customer_ID值"+aPolicy_Owner_Customer_ID+"的长度"+aPolicy_Owner_Customer_ID.length()+"大于最大值8");
		Policy_Owner_Customer_ID = aPolicy_Owner_Customer_ID;
	}
	public String getPolicy_Owner_Name()
	{
		return Policy_Owner_Name;
	}
	public void setPolicy_Owner_Name(String aPolicy_Owner_Name)
	{
		if(aPolicy_Owner_Name!=null && aPolicy_Owner_Name.length()>120)
			throw new IllegalArgumentException("Policy_owner_namePolicy_Owner_Name值"+aPolicy_Owner_Name+"的长度"+aPolicy_Owner_Name.length()+"大于最大值120");
		Policy_Owner_Name = aPolicy_Owner_Name;
	}
	public String getOwner_Security_No()
	{
		return Owner_Security_No;
	}
	public void setOwner_Security_No(String aOwner_Security_No)
	{
		if(aOwner_Security_No!=null && aOwner_Security_No.length()>24)
			throw new IllegalArgumentException("Owner_security_noOwner_Security_No值"+aOwner_Security_No+"的长度"+aOwner_Security_No.length()+"大于最大值24");
		Owner_Security_No = aOwner_Security_No;
	}
	public String getPolicy_Insured_Name()
	{
		return Policy_Insured_Name;
	}
	public void setPolicy_Insured_Name(String aPolicy_Insured_Name)
	{
		if(aPolicy_Insured_Name!=null && aPolicy_Insured_Name.length()>120)
			throw new IllegalArgumentException("Policy_insured_namePolicy_Insured_Name值"+aPolicy_Insured_Name+"的长度"+aPolicy_Insured_Name.length()+"大于最大值120");
		Policy_Insured_Name = aPolicy_Insured_Name;
	}
	public String getInsured_Security_No()
	{
		return Insured_Security_No;
	}
	public void setInsured_Security_No(String aInsured_Security_No)
	{
		if(aInsured_Security_No!=null && aInsured_Security_No.length()>24)
			throw new IllegalArgumentException("Insured_security_noInsured_Security_No值"+aInsured_Security_No+"的长度"+aInsured_Security_No.length()+"大于最大值24");
		Insured_Security_No = aInsured_Security_No;
	}
	public String getOld_Policy_No()
	{
		return Old_Policy_No;
	}
	public void setOld_Policy_No(String aOld_Policy_No)
	{
		if(aOld_Policy_No!=null && aOld_Policy_No.length()>8)
			throw new IllegalArgumentException("Old_policy_noOld_Policy_No值"+aOld_Policy_No+"的长度"+aOld_Policy_No.length()+"大于最大值8");
		Old_Policy_No = aOld_Policy_No;
	}
	public String getBusiness_Date()
	{
		if( Business_Date != null )
			return fDate.getString(Business_Date);
		else
			return null;
	}
	public void setBusiness_Date(Date aBusiness_Date)
	{
		Business_Date = aBusiness_Date;
	}
	public void setBusiness_Date(String aBusiness_Date)
	{
		if (aBusiness_Date != null && !aBusiness_Date.equals("") )
		{
			Business_Date = fDate.getDate( aBusiness_Date );
		}
		else
			Business_Date = null;
	}

	public double getBatch_No()
	{
		return Batch_No;
	}
	public void setBatch_No(double aBatch_No)
	{
		Batch_No = aBatch_No;
	}
	public void setBatch_No(String aBatch_No)
	{
		if (aBatch_No != null && !aBatch_No.equals(""))
		{
			Double tDouble = new Double(aBatch_No);
			double d = tDouble.doubleValue();
			Batch_No = d;
		}
	}

	public String getBatch_Run_Date()
	{
		if( Batch_Run_Date != null )
			return fDate.getString(Batch_Run_Date);
		else
			return null;
	}
	public void setBatch_Run_Date(Date aBatch_Run_Date)
	{
		Batch_Run_Date = aBatch_Run_Date;
	}
	public void setBatch_Run_Date(String aBatch_Run_Date)
	{
		if (aBatch_Run_Date != null && !aBatch_Run_Date.equals("") )
		{
			Batch_Run_Date = fDate.getDate( aBatch_Run_Date );
		}
		else
			Batch_Run_Date = null;
	}


	/**
	* 使用另外一个 DailyPolicyDetailsSchema 对象给 Schema 赋值
	* @param: aDailyPolicyDetailsSchema DailyPolicyDetailsSchema
	**/
	public void setSchema(DailyPolicyDetailsSchema aDailyPolicyDetailsSchema)
	{
		this.Company_Code = aDailyPolicyDetailsSchema.getCompany_Code();
		this.Policy_No = aDailyPolicyDetailsSchema.getPolicy_No();
		this.Product_Code = aDailyPolicyDetailsSchema.getProduct_Code();
		this.Product_Type = aDailyPolicyDetailsSchema.getProduct_Type();
		this.Link_or_No_Link_Product = aDailyPolicyDetailsSchema.getLink_or_No_Link_Product();
		this.AgentCode1 = aDailyPolicyDetailsSchema.getAgentCode1();
		this.AgentCode2 = aDailyPolicyDetailsSchema.getAgentCode2();
		this.SplitRate1 = aDailyPolicyDetailsSchema.getSplitRate1();
		this.SplitRate2 = aDailyPolicyDetailsSchema.getSplitRate2();
		this.Servicing_Agent_Code = aDailyPolicyDetailsSchema.getServicing_Agent_Code();
		this.Risk_Status = aDailyPolicyDetailsSchema.getRisk_Status();
		this.Effective_Date = fDate.getDate( aDailyPolicyDetailsSchema.getEffective_Date());
		this.First_Issue_Date = fDate.getDate( aDailyPolicyDetailsSchema.getFirst_Issue_Date());
		this.Reissue_Issue_Date = fDate.getDate( aDailyPolicyDetailsSchema.getReissue_Issue_Date());
		this.Reinstatement_Date = fDate.getDate( aDailyPolicyDetailsSchema.getReinstatement_Date());
		this.Policy_Owner_Customer_ID = aDailyPolicyDetailsSchema.getPolicy_Owner_Customer_ID();
		this.Policy_Owner_Name = aDailyPolicyDetailsSchema.getPolicy_Owner_Name();
		this.Owner_Security_No = aDailyPolicyDetailsSchema.getOwner_Security_No();
		this.Policy_Insured_Name = aDailyPolicyDetailsSchema.getPolicy_Insured_Name();
		this.Insured_Security_No = aDailyPolicyDetailsSchema.getInsured_Security_No();
		this.Old_Policy_No = aDailyPolicyDetailsSchema.getOld_Policy_No();
		this.Business_Date = fDate.getDate( aDailyPolicyDetailsSchema.getBusiness_Date());
		this.Batch_No = aDailyPolicyDetailsSchema.getBatch_No();
		this.Batch_Run_Date = fDate.getDate( aDailyPolicyDetailsSchema.getBatch_Run_Date());
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
			if( rs.getString("Company_Code") == null )
				this.Company_Code = null;
			else
				this.Company_Code = rs.getString("Company_Code").trim();

			if( rs.getString("Policy_No") == null )
				this.Policy_No = null;
			else
				this.Policy_No = rs.getString("Policy_No").trim();

			if( rs.getString("Product_Code") == null )
				this.Product_Code = null;
			else
				this.Product_Code = rs.getString("Product_Code").trim();

			if( rs.getString("Product_Type") == null )
				this.Product_Type = null;
			else
				this.Product_Type = rs.getString("Product_Type").trim();

			if( rs.getString("Link_or_No_Link_Product") == null )
				this.Link_or_No_Link_Product = null;
			else
				this.Link_or_No_Link_Product = rs.getString("Link_or_No_Link_Product").trim();

			if( rs.getString("AgentCode1") == null )
				this.AgentCode1 = null;
			else
				this.AgentCode1 = rs.getString("AgentCode1").trim();

			if( rs.getString("AgentCode2") == null )
				this.AgentCode2 = null;
			else
				this.AgentCode2 = rs.getString("AgentCode2").trim();

			this.SplitRate1 = rs.getDouble("SplitRate1");
			this.SplitRate2 = rs.getDouble("SplitRate2");
			if( rs.getString("Servicing_Agent_Code") == null )
				this.Servicing_Agent_Code = null;
			else
				this.Servicing_Agent_Code = rs.getString("Servicing_Agent_Code").trim();

			if( rs.getString("Risk_Status") == null )
				this.Risk_Status = null;
			else
				this.Risk_Status = rs.getString("Risk_Status").trim();

			this.Effective_Date = rs.getDate("Effective_Date");
			this.First_Issue_Date = rs.getDate("First_Issue_Date");
			this.Reissue_Issue_Date = rs.getDate("Reissue_Issue_Date");
			this.Reinstatement_Date = rs.getDate("Reinstatement_Date");
			if( rs.getString("Policy_Owner_Customer_ID") == null )
				this.Policy_Owner_Customer_ID = null;
			else
				this.Policy_Owner_Customer_ID = rs.getString("Policy_Owner_Customer_ID").trim();

			if( rs.getString("Policy_Owner_Name") == null )
				this.Policy_Owner_Name = null;
			else
				this.Policy_Owner_Name = rs.getString("Policy_Owner_Name").trim();

			if( rs.getString("Owner_Security_No") == null )
				this.Owner_Security_No = null;
			else
				this.Owner_Security_No = rs.getString("Owner_Security_No").trim();

			if( rs.getString("Policy_Insured_Name") == null )
				this.Policy_Insured_Name = null;
			else
				this.Policy_Insured_Name = rs.getString("Policy_Insured_Name").trim();

			if( rs.getString("Insured_Security_No") == null )
				this.Insured_Security_No = null;
			else
				this.Insured_Security_No = rs.getString("Insured_Security_No").trim();

			if( rs.getString("Old_Policy_No") == null )
				this.Old_Policy_No = null;
			else
				this.Old_Policy_No = rs.getString("Old_Policy_No").trim();

			this.Business_Date = rs.getDate("Business_Date");
			this.Batch_No = rs.getDouble("Batch_No");
			this.Batch_Run_Date = rs.getDate("Batch_Run_Date");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的DailyPolicyDetails表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public DailyPolicyDetailsSchema getSchema()
	{
		DailyPolicyDetailsSchema aDailyPolicyDetailsSchema = new DailyPolicyDetailsSchema();
		aDailyPolicyDetailsSchema.setSchema(this);
		return aDailyPolicyDetailsSchema;
	}

	public DailyPolicyDetailsDB getDB()
	{
		DailyPolicyDetailsDB aDBOper = new DailyPolicyDetailsDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyPolicyDetails描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(Company_Code)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Policy_No)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Product_Code)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Product_Type)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Link_or_No_Link_Product)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SplitRate1));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SplitRate2));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Servicing_Agent_Code)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Risk_Status)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Effective_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( First_Issue_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Reissue_Issue_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Reinstatement_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Policy_Owner_Customer_ID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Policy_Owner_Name)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Owner_Security_No)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Policy_Insured_Name)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Insured_Security_No)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Old_Policy_No)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Business_Date ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(Batch_No));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Batch_Run_Date )));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpDailyPolicyDetails>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			Company_Code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Policy_No = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			Product_Code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			Product_Type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Link_or_No_Link_Product = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AgentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AgentCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			SplitRate1 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,8,SysConst.PACKAGESPILTER))).doubleValue();
			SplitRate2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,9,SysConst.PACKAGESPILTER))).doubleValue();
			Servicing_Agent_Code = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			Risk_Status = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Effective_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			First_Issue_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			Reissue_Issue_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			Reinstatement_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			Policy_Owner_Customer_ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Policy_Owner_Name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			Owner_Security_No = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			Policy_Insured_Name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			Insured_Security_No = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			Old_Policy_No = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			Business_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22,SysConst.PACKAGESPILTER));
			Batch_No = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,23,SysConst.PACKAGESPILTER))).doubleValue();
			Batch_Run_Date = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24,SysConst.PACKAGESPILTER));
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsSchema";
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
		if (FCode.equalsIgnoreCase("Company_Code"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Company_Code));
		}
		if (FCode.equalsIgnoreCase("Policy_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Policy_No));
		}
		if (FCode.equalsIgnoreCase("Product_Code"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Product_Code));
		}
		if (FCode.equalsIgnoreCase("Product_Type"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Product_Type));
		}
		if (FCode.equalsIgnoreCase("Link_or_No_Link_Product"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Link_or_No_Link_Product));
		}
		if (FCode.equalsIgnoreCase("AgentCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode1));
		}
		if (FCode.equalsIgnoreCase("AgentCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode2));
		}
		if (FCode.equalsIgnoreCase("SplitRate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SplitRate1));
		}
		if (FCode.equalsIgnoreCase("SplitRate2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SplitRate2));
		}
		if (FCode.equalsIgnoreCase("Servicing_Agent_Code"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Servicing_Agent_Code));
		}
		if (FCode.equalsIgnoreCase("Risk_Status"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Risk_Status));
		}
		if (FCode.equalsIgnoreCase("Effective_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEffective_Date()));
		}
		if (FCode.equalsIgnoreCase("First_Issue_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getFirst_Issue_Date()));
		}
		if (FCode.equalsIgnoreCase("Reissue_Issue_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getReissue_Issue_Date()));
		}
		if (FCode.equalsIgnoreCase("Reinstatement_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getReinstatement_Date()));
		}
		if (FCode.equalsIgnoreCase("Policy_Owner_Customer_ID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Policy_Owner_Customer_ID));
		}
		if (FCode.equalsIgnoreCase("Policy_Owner_Name"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Policy_Owner_Name));
		}
		if (FCode.equalsIgnoreCase("Owner_Security_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Owner_Security_No));
		}
		if (FCode.equalsIgnoreCase("Policy_Insured_Name"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Policy_Insured_Name));
		}
		if (FCode.equalsIgnoreCase("Insured_Security_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Insured_Security_No));
		}
		if (FCode.equalsIgnoreCase("Old_Policy_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Old_Policy_No));
		}
		if (FCode.equalsIgnoreCase("Business_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBusiness_Date()));
		}
		if (FCode.equalsIgnoreCase("Batch_No"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Batch_No));
		}
		if (FCode.equalsIgnoreCase("Batch_Run_Date"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBatch_Run_Date()));
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
				strFieldValue = StrTool.GBKToUnicode(Company_Code);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(Policy_No);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(Product_Code);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(Product_Type);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Link_or_No_Link_Product);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(AgentCode1);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentCode2);
				break;
			case 7:
				strFieldValue = String.valueOf(SplitRate1);
				break;
			case 8:
				strFieldValue = String.valueOf(SplitRate2);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Servicing_Agent_Code);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(Risk_Status);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEffective_Date()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getFirst_Issue_Date()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getReissue_Issue_Date()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getReinstatement_Date()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Policy_Owner_Customer_ID);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Policy_Owner_Name);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(Owner_Security_No);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(Policy_Insured_Name);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(Insured_Security_No);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(Old_Policy_No);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBusiness_Date()));
				break;
			case 22:
				strFieldValue = String.valueOf(Batch_No);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBatch_Run_Date()));
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

		if (FCode.equalsIgnoreCase("Company_Code"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Company_Code = FValue.trim();
			}
			else
				Company_Code = null;
		}
		if (FCode.equalsIgnoreCase("Policy_No"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Policy_No = FValue.trim();
			}
			else
				Policy_No = null;
		}
		if (FCode.equalsIgnoreCase("Product_Code"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Product_Code = FValue.trim();
			}
			else
				Product_Code = null;
		}
		if (FCode.equalsIgnoreCase("Product_Type"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Product_Type = FValue.trim();
			}
			else
				Product_Type = null;
		}
		if (FCode.equalsIgnoreCase("Link_or_No_Link_Product"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Link_or_No_Link_Product = FValue.trim();
			}
			else
				Link_or_No_Link_Product = null;
		}
		if (FCode.equalsIgnoreCase("AgentCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode1 = FValue.trim();
			}
			else
				AgentCode1 = null;
		}
		if (FCode.equalsIgnoreCase("AgentCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode2 = FValue.trim();
			}
			else
				AgentCode2 = null;
		}
		if (FCode.equalsIgnoreCase("SplitRate1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				SplitRate1 = d;
			}
		}
		if (FCode.equalsIgnoreCase("SplitRate2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				SplitRate2 = d;
			}
		}
		if (FCode.equalsIgnoreCase("Servicing_Agent_Code"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Servicing_Agent_Code = FValue.trim();
			}
			else
				Servicing_Agent_Code = null;
		}
		if (FCode.equalsIgnoreCase("Risk_Status"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Risk_Status = FValue.trim();
			}
			else
				Risk_Status = null;
		}
		if (FCode.equalsIgnoreCase("Effective_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Effective_Date = fDate.getDate( FValue );
			}
			else
				Effective_Date = null;
		}
		if (FCode.equalsIgnoreCase("First_Issue_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				First_Issue_Date = fDate.getDate( FValue );
			}
			else
				First_Issue_Date = null;
		}
		if (FCode.equalsIgnoreCase("Reissue_Issue_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Reissue_Issue_Date = fDate.getDate( FValue );
			}
			else
				Reissue_Issue_Date = null;
		}
		if (FCode.equalsIgnoreCase("Reinstatement_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Reinstatement_Date = fDate.getDate( FValue );
			}
			else
				Reinstatement_Date = null;
		}
		if (FCode.equalsIgnoreCase("Policy_Owner_Customer_ID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Policy_Owner_Customer_ID = FValue.trim();
			}
			else
				Policy_Owner_Customer_ID = null;
		}
		if (FCode.equalsIgnoreCase("Policy_Owner_Name"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Policy_Owner_Name = FValue.trim();
			}
			else
				Policy_Owner_Name = null;
		}
		if (FCode.equalsIgnoreCase("Owner_Security_No"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Owner_Security_No = FValue.trim();
			}
			else
				Owner_Security_No = null;
		}
		if (FCode.equalsIgnoreCase("Policy_Insured_Name"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Policy_Insured_Name = FValue.trim();
			}
			else
				Policy_Insured_Name = null;
		}
		if (FCode.equalsIgnoreCase("Insured_Security_No"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Insured_Security_No = FValue.trim();
			}
			else
				Insured_Security_No = null;
		}
		if (FCode.equalsIgnoreCase("Old_Policy_No"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Old_Policy_No = FValue.trim();
			}
			else
				Old_Policy_No = null;
		}
		if (FCode.equalsIgnoreCase("Business_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Business_Date = fDate.getDate( FValue );
			}
			else
				Business_Date = null;
		}
		if (FCode.equalsIgnoreCase("Batch_No"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				Batch_No = d;
			}
		}
		if (FCode.equalsIgnoreCase("Batch_Run_Date"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Batch_Run_Date = fDate.getDate( FValue );
			}
			else
				Batch_Run_Date = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		DailyPolicyDetailsSchema other = (DailyPolicyDetailsSchema)otherObject;
		return
			Company_Code.equals(other.getCompany_Code())
			&& Policy_No.equals(other.getPolicy_No())
			&& Product_Code.equals(other.getProduct_Code())
			&& Product_Type.equals(other.getProduct_Type())
			&& Link_or_No_Link_Product.equals(other.getLink_or_No_Link_Product())
			&& AgentCode1.equals(other.getAgentCode1())
			&& AgentCode2.equals(other.getAgentCode2())
			&& SplitRate1 == other.getSplitRate1()
			&& SplitRate2 == other.getSplitRate2()
			&& Servicing_Agent_Code.equals(other.getServicing_Agent_Code())
			&& Risk_Status.equals(other.getRisk_Status())
			&& fDate.getString(Effective_Date).equals(other.getEffective_Date())
			&& fDate.getString(First_Issue_Date).equals(other.getFirst_Issue_Date())
			&& fDate.getString(Reissue_Issue_Date).equals(other.getReissue_Issue_Date())
			&& fDate.getString(Reinstatement_Date).equals(other.getReinstatement_Date())
			&& Policy_Owner_Customer_ID.equals(other.getPolicy_Owner_Customer_ID())
			&& Policy_Owner_Name.equals(other.getPolicy_Owner_Name())
			&& Owner_Security_No.equals(other.getOwner_Security_No())
			&& Policy_Insured_Name.equals(other.getPolicy_Insured_Name())
			&& Insured_Security_No.equals(other.getInsured_Security_No())
			&& Old_Policy_No.equals(other.getOld_Policy_No())
			&& fDate.getString(Business_Date).equals(other.getBusiness_Date())
			&& Batch_No == other.getBatch_No()
			&& fDate.getString(Batch_Run_Date).equals(other.getBatch_Run_Date());
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
		if( strFieldName.equals("Company_Code") ) {
			return 0;
		}
		if( strFieldName.equals("Policy_No") ) {
			return 1;
		}
		if( strFieldName.equals("Product_Code") ) {
			return 2;
		}
		if( strFieldName.equals("Product_Type") ) {
			return 3;
		}
		if( strFieldName.equals("Link_or_No_Link_Product") ) {
			return 4;
		}
		if( strFieldName.equals("AgentCode1") ) {
			return 5;
		}
		if( strFieldName.equals("AgentCode2") ) {
			return 6;
		}
		if( strFieldName.equals("SplitRate1") ) {
			return 7;
		}
		if( strFieldName.equals("SplitRate2") ) {
			return 8;
		}
		if( strFieldName.equals("Servicing_Agent_Code") ) {
			return 9;
		}
		if( strFieldName.equals("Risk_Status") ) {
			return 10;
		}
		if( strFieldName.equals("Effective_Date") ) {
			return 11;
		}
		if( strFieldName.equals("First_Issue_Date") ) {
			return 12;
		}
		if( strFieldName.equals("Reissue_Issue_Date") ) {
			return 13;
		}
		if( strFieldName.equals("Reinstatement_Date") ) {
			return 14;
		}
		if( strFieldName.equals("Policy_Owner_Customer_ID") ) {
			return 15;
		}
		if( strFieldName.equals("Policy_Owner_Name") ) {
			return 16;
		}
		if( strFieldName.equals("Owner_Security_No") ) {
			return 17;
		}
		if( strFieldName.equals("Policy_Insured_Name") ) {
			return 18;
		}
		if( strFieldName.equals("Insured_Security_No") ) {
			return 19;
		}
		if( strFieldName.equals("Old_Policy_No") ) {
			return 20;
		}
		if( strFieldName.equals("Business_Date") ) {
			return 21;
		}
		if( strFieldName.equals("Batch_No") ) {
			return 22;
		}
		if( strFieldName.equals("Batch_Run_Date") ) {
			return 23;
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
				strFieldName = "Company_Code";
				break;
			case 1:
				strFieldName = "Policy_No";
				break;
			case 2:
				strFieldName = "Product_Code";
				break;
			case 3:
				strFieldName = "Product_Type";
				break;
			case 4:
				strFieldName = "Link_or_No_Link_Product";
				break;
			case 5:
				strFieldName = "AgentCode1";
				break;
			case 6:
				strFieldName = "AgentCode2";
				break;
			case 7:
				strFieldName = "SplitRate1";
				break;
			case 8:
				strFieldName = "SplitRate2";
				break;
			case 9:
				strFieldName = "Servicing_Agent_Code";
				break;
			case 10:
				strFieldName = "Risk_Status";
				break;
			case 11:
				strFieldName = "Effective_Date";
				break;
			case 12:
				strFieldName = "First_Issue_Date";
				break;
			case 13:
				strFieldName = "Reissue_Issue_Date";
				break;
			case 14:
				strFieldName = "Reinstatement_Date";
				break;
			case 15:
				strFieldName = "Policy_Owner_Customer_ID";
				break;
			case 16:
				strFieldName = "Policy_Owner_Name";
				break;
			case 17:
				strFieldName = "Owner_Security_No";
				break;
			case 18:
				strFieldName = "Policy_Insured_Name";
				break;
			case 19:
				strFieldName = "Insured_Security_No";
				break;
			case 20:
				strFieldName = "Old_Policy_No";
				break;
			case 21:
				strFieldName = "Business_Date";
				break;
			case 22:
				strFieldName = "Batch_No";
				break;
			case 23:
				strFieldName = "Batch_Run_Date";
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
		if( strFieldName.equals("Company_Code") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Policy_No") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Product_Code") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Product_Type") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Link_or_No_Link_Product") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SplitRate1") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("SplitRate2") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Servicing_Agent_Code") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Risk_Status") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Effective_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("First_Issue_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Reissue_Issue_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Reinstatement_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Policy_Owner_Customer_ID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Policy_Owner_Name") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Owner_Security_No") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Policy_Insured_Name") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Insured_Security_No") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Old_Policy_No") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Business_Date") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Batch_No") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Batch_Run_Date") ) {
			return Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 8:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 23:
				nFieldType = Schema.TYPE_DATE;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
