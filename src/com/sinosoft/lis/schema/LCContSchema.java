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
import com.sinosoft.lis.db.LCContDB;

/*
 * <p>ClassName: LCContSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCContSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LCContSchema.class);
	// @Field
	/** Companycode */
	private String CompanyCode;
	/** Mainpolno */
	private String MainPolNo;
	/** Productcode */
	private String ProductCode;
	/** Producttype */
	private String ProductType;
	/** Agentcode1 */
	private String AgentCode1;
	/** Agentcode2 */
	private String AgentCode2;
	/** Splitrate1 */
	private double SplitRate1;
	/** Splitrate2 */
	private double SplitRate2;
	/** Sagentcode */
	private String SAgentCode;
	/** Polstate */
	private String PolState;
	/** Cvalidate */
	private Date CValiDate;
	/** Signdate */
	private Date SignDate;
	/** Resigndate */
	private Date ReSignDate;
	/** Reindate */
	private Date ReinDate;
	/** Appntno */
	private String AppntNo;
	/** Appntname */
	private String AppntName;
	/** Appntid */
	private String AppntID;
	/** Insuredname */
	private String InsuredName;
	/** Insuredid */
	private String InsuredID;
	/** Oldpolicyno */
	private String OldPolicyNo;
	/** Businessdate */
	private Date BusinessDate;
	/** Asareceiveddate */
	private Date ASAReceivedDate;
	/** Flag1 */
	private String Flag1;
	/** Flag2 */
	private String Flag2;
	/** Flag3 */
	private String Flag3;
	/** Flag4 */
	private String Flag4;
	/** Flag5 */
	private String Flag5;
	/** Batchno */
	private double BatchNo;
	/** Batchdate */
	private Date BatchDate;
	/** Managecom */
	private String ManageCom;
	/** Branchtype */
	private String BranchType;
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

	public static final int FIELDNUM = 36;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LCContSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "CompanyCode";
		pk[1] = "MainPolNo";

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
		LCContSchema cloned = (LCContSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getCompanyCode()
	{
		return CompanyCode;
	}
	public void setCompanyCode(String aCompanyCode)
	{
		if(aCompanyCode!=null && aCompanyCode.length()>1)
			throw new IllegalArgumentException("CompanycodeCompanyCode值"+aCompanyCode+"的长度"+aCompanyCode.length()+"大于最大值1");
		CompanyCode = aCompanyCode;
	}
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
	public String getProductCode()
	{
		return ProductCode;
	}
	public void setProductCode(String aProductCode)
	{
		if(aProductCode!=null && aProductCode.length()>3)
			throw new IllegalArgumentException("ProductcodeProductCode值"+aProductCode+"的长度"+aProductCode.length()+"大于最大值3");
		ProductCode = aProductCode;
	}
	public String getProductType()
	{
		return ProductType;
	}
	public void setProductType(String aProductType)
	{
		if(aProductType!=null && aProductType.length()>30)
			throw new IllegalArgumentException("ProducttypeProductType值"+aProductType+"的长度"+aProductType.length()+"大于最大值30");
		ProductType = aProductType;
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

	public String getSAgentCode()
	{
		return SAgentCode;
	}
	public void setSAgentCode(String aSAgentCode)
	{
		if(aSAgentCode!=null && aSAgentCode.length()>12)
			throw new IllegalArgumentException("SagentcodeSAgentCode值"+aSAgentCode+"的长度"+aSAgentCode.length()+"大于最大值12");
		SAgentCode = aSAgentCode;
	}
	public String getPolState()
	{
		return PolState;
	}
	public void setPolState(String aPolState)
	{
		if(aPolState!=null && aPolState.length()>2)
			throw new IllegalArgumentException("PolstatePolState值"+aPolState+"的长度"+aPolState.length()+"大于最大值2");
		PolState = aPolState;
	}
	public String getCValiDate()
	{
		if( CValiDate != null )
			return fDate.getString(CValiDate);
		else
			return null;
	}
	public void setCValiDate(Date aCValiDate)
	{
		CValiDate = aCValiDate;
	}
	public void setCValiDate(String aCValiDate)
	{
		if (aCValiDate != null && !aCValiDate.equals("") )
		{
			CValiDate = fDate.getDate( aCValiDate );
		}
		else
			CValiDate = null;
	}

	public String getSignDate()
	{
		if( SignDate != null )
			return fDate.getString(SignDate);
		else
			return null;
	}
	public void setSignDate(Date aSignDate)
	{
		SignDate = aSignDate;
	}
	public void setSignDate(String aSignDate)
	{
		if (aSignDate != null && !aSignDate.equals("") )
		{
			SignDate = fDate.getDate( aSignDate );
		}
		else
			SignDate = null;
	}

	public String getReSignDate()
	{
		if( ReSignDate != null )
			return fDate.getString(ReSignDate);
		else
			return null;
	}
	public void setReSignDate(Date aReSignDate)
	{
		ReSignDate = aReSignDate;
	}
	public void setReSignDate(String aReSignDate)
	{
		if (aReSignDate != null && !aReSignDate.equals("") )
		{
			ReSignDate = fDate.getDate( aReSignDate );
		}
		else
			ReSignDate = null;
	}

	public String getReinDate()
	{
		if( ReinDate != null )
			return fDate.getString(ReinDate);
		else
			return null;
	}
	public void setReinDate(Date aReinDate)
	{
		ReinDate = aReinDate;
	}
	public void setReinDate(String aReinDate)
	{
		if (aReinDate != null && !aReinDate.equals("") )
		{
			ReinDate = fDate.getDate( aReinDate );
		}
		else
			ReinDate = null;
	}

	public String getAppntNo()
	{
		return AppntNo;
	}
	public void setAppntNo(String aAppntNo)
	{
		if(aAppntNo!=null && aAppntNo.length()>8)
			throw new IllegalArgumentException("AppntnoAppntNo值"+aAppntNo+"的长度"+aAppntNo.length()+"大于最大值8");
		AppntNo = aAppntNo;
	}
	public String getAppntName()
	{
		return AppntName;
	}
	public void setAppntName(String aAppntName)
	{
		if(aAppntName!=null && aAppntName.length()>120)
			throw new IllegalArgumentException("AppntnameAppntName值"+aAppntName+"的长度"+aAppntName.length()+"大于最大值120");
		AppntName = aAppntName;
	}
	public String getAppntID()
	{
		return AppntID;
	}
	public void setAppntID(String aAppntID)
	{
		if(aAppntID!=null && aAppntID.length()>24)
			throw new IllegalArgumentException("AppntidAppntID值"+aAppntID+"的长度"+aAppntID.length()+"大于最大值24");
		AppntID = aAppntID;
	}
	public String getInsuredName()
	{
		return InsuredName;
	}
	public void setInsuredName(String aInsuredName)
	{
		if(aInsuredName!=null && aInsuredName.length()>120)
			throw new IllegalArgumentException("InsurednameInsuredName值"+aInsuredName+"的长度"+aInsuredName.length()+"大于最大值120");
		InsuredName = aInsuredName;
	}
	public String getInsuredID()
	{
		return InsuredID;
	}
	public void setInsuredID(String aInsuredID)
	{
		if(aInsuredID!=null && aInsuredID.length()>24)
			throw new IllegalArgumentException("InsuredidInsuredID值"+aInsuredID+"的长度"+aInsuredID.length()+"大于最大值24");
		InsuredID = aInsuredID;
	}
	public String getOldPolicyNo()
	{
		return OldPolicyNo;
	}
	public void setOldPolicyNo(String aOldPolicyNo)
	{
		if(aOldPolicyNo!=null && aOldPolicyNo.length()>8)
			throw new IllegalArgumentException("OldpolicynoOldPolicyNo值"+aOldPolicyNo+"的长度"+aOldPolicyNo.length()+"大于最大值8");
		OldPolicyNo = aOldPolicyNo;
	}
	public String getBusinessDate()
	{
		if( BusinessDate != null )
			return fDate.getString(BusinessDate);
		else
			return null;
	}
	public void setBusinessDate(Date aBusinessDate)
	{
		BusinessDate = aBusinessDate;
	}
	public void setBusinessDate(String aBusinessDate)
	{
		if (aBusinessDate != null && !aBusinessDate.equals("") )
		{
			BusinessDate = fDate.getDate( aBusinessDate );
		}
		else
			BusinessDate = null;
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

	public String getFlag1()
	{
		return Flag1;
	}
	public void setFlag1(String aFlag1)
	{
		if(aFlag1!=null && aFlag1.length()>10)
			throw new IllegalArgumentException("Flag1Flag1值"+aFlag1+"的长度"+aFlag1.length()+"大于最大值10");
		Flag1 = aFlag1;
	}
	public String getFlag2()
	{
		return Flag2;
	}
	public void setFlag2(String aFlag2)
	{
		if(aFlag2!=null && aFlag2.length()>10)
			throw new IllegalArgumentException("Flag2Flag2值"+aFlag2+"的长度"+aFlag2.length()+"大于最大值10");
		Flag2 = aFlag2;
	}
	public String getFlag3()
	{
		return Flag3;
	}
	public void setFlag3(String aFlag3)
	{
		if(aFlag3!=null && aFlag3.length()>10)
			throw new IllegalArgumentException("Flag3Flag3值"+aFlag3+"的长度"+aFlag3.length()+"大于最大值10");
		Flag3 = aFlag3;
	}
	public String getFlag4()
	{
		return Flag4;
	}
	public void setFlag4(String aFlag4)
	{
		if(aFlag4!=null && aFlag4.length()>10)
			throw new IllegalArgumentException("Flag4Flag4值"+aFlag4+"的长度"+aFlag4.length()+"大于最大值10");
		Flag4 = aFlag4;
	}
	public String getFlag5()
	{
		return Flag5;
	}
	public void setFlag5(String aFlag5)
	{
		if(aFlag5!=null && aFlag5.length()>10)
			throw new IllegalArgumentException("Flag5Flag5值"+aFlag5+"的长度"+aFlag5.length()+"大于最大值10");
		Flag5 = aFlag5;
	}
	public double getBatchNo()
	{
		return BatchNo;
	}
	public void setBatchNo(double aBatchNo)
	{
		BatchNo = aBatchNo;
	}
	public void setBatchNo(String aBatchNo)
	{
		if (aBatchNo != null && !aBatchNo.equals(""))
		{
			Double tDouble = new Double(aBatchNo);
			double d = tDouble.doubleValue();
			BatchNo = d;
		}
	}

	public String getBatchDate()
	{
		if( BatchDate != null )
			return fDate.getString(BatchDate);
		else
			return null;
	}
	public void setBatchDate(Date aBatchDate)
	{
		BatchDate = aBatchDate;
	}
	public void setBatchDate(String aBatchDate)
	{
		if (aBatchDate != null && !aBatchDate.equals("") )
		{
			BatchDate = fDate.getDate( aBatchDate );
		}
		else
			BatchDate = null;
	}

	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>20)
			throw new IllegalArgumentException("ManagecomManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值20");
		ManageCom = aManageCom;
	}
	public String getBranchType()
	{
		return BranchType;
	}
	public void setBranchType(String aBranchType)
	{
		if(aBranchType!=null && aBranchType.length()>1)
			throw new IllegalArgumentException("BranchtypeBranchType值"+aBranchType+"的长度"+aBranchType.length()+"大于最大值1");
		BranchType = aBranchType;
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
	* 使用另外一个 LCContSchema 对象给 Schema 赋值
	* @param: aLCContSchema LCContSchema
	**/
	public void setSchema(LCContSchema aLCContSchema)
	{
		this.CompanyCode = aLCContSchema.getCompanyCode();
		this.MainPolNo = aLCContSchema.getMainPolNo();
		this.ProductCode = aLCContSchema.getProductCode();
		this.ProductType = aLCContSchema.getProductType();
		this.AgentCode1 = aLCContSchema.getAgentCode1();
		this.AgentCode2 = aLCContSchema.getAgentCode2();
		this.SplitRate1 = aLCContSchema.getSplitRate1();
		this.SplitRate2 = aLCContSchema.getSplitRate2();
		this.SAgentCode = aLCContSchema.getSAgentCode();
		this.PolState = aLCContSchema.getPolState();
		this.CValiDate = fDate.getDate( aLCContSchema.getCValiDate());
		this.SignDate = fDate.getDate( aLCContSchema.getSignDate());
		this.ReSignDate = fDate.getDate( aLCContSchema.getReSignDate());
		this.ReinDate = fDate.getDate( aLCContSchema.getReinDate());
		this.AppntNo = aLCContSchema.getAppntNo();
		this.AppntName = aLCContSchema.getAppntName();
		this.AppntID = aLCContSchema.getAppntID();
		this.InsuredName = aLCContSchema.getInsuredName();
		this.InsuredID = aLCContSchema.getInsuredID();
		this.OldPolicyNo = aLCContSchema.getOldPolicyNo();
		this.BusinessDate = fDate.getDate( aLCContSchema.getBusinessDate());
		this.ASAReceivedDate = fDate.getDate( aLCContSchema.getASAReceivedDate());
		this.Flag1 = aLCContSchema.getFlag1();
		this.Flag2 = aLCContSchema.getFlag2();
		this.Flag3 = aLCContSchema.getFlag3();
		this.Flag4 = aLCContSchema.getFlag4();
		this.Flag5 = aLCContSchema.getFlag5();
		this.BatchNo = aLCContSchema.getBatchNo();
		this.BatchDate = fDate.getDate( aLCContSchema.getBatchDate());
		this.ManageCom = aLCContSchema.getManageCom();
		this.BranchType = aLCContSchema.getBranchType();
		this.Operator = aLCContSchema.getOperator();
		this.MakeDate = fDate.getDate( aLCContSchema.getMakeDate());
		this.MakeTime = aLCContSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLCContSchema.getModifyDate());
		this.ModifyTime = aLCContSchema.getModifyTime();
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
			if( rs.getString("CompanyCode") == null )
				this.CompanyCode = null;
			else
				this.CompanyCode = rs.getString("CompanyCode").trim();

			if( rs.getString("MainPolNo") == null )
				this.MainPolNo = null;
			else
				this.MainPolNo = rs.getString("MainPolNo").trim();

			if( rs.getString("ProductCode") == null )
				this.ProductCode = null;
			else
				this.ProductCode = rs.getString("ProductCode").trim();

			if( rs.getString("ProductType") == null )
				this.ProductType = null;
			else
				this.ProductType = rs.getString("ProductType").trim();

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
			if( rs.getString("SAgentCode") == null )
				this.SAgentCode = null;
			else
				this.SAgentCode = rs.getString("SAgentCode").trim();

			if( rs.getString("PolState") == null )
				this.PolState = null;
			else
				this.PolState = rs.getString("PolState").trim();

			this.CValiDate = rs.getDate("CValiDate");
			this.SignDate = rs.getDate("SignDate");
			this.ReSignDate = rs.getDate("ReSignDate");
			this.ReinDate = rs.getDate("ReinDate");
			if( rs.getString("AppntNo") == null )
				this.AppntNo = null;
			else
				this.AppntNo = rs.getString("AppntNo").trim();

			if( rs.getString("AppntName") == null )
				this.AppntName = null;
			else
				this.AppntName = rs.getString("AppntName").trim();

			if( rs.getString("AppntID") == null )
				this.AppntID = null;
			else
				this.AppntID = rs.getString("AppntID").trim();

			if( rs.getString("InsuredName") == null )
				this.InsuredName = null;
			else
				this.InsuredName = rs.getString("InsuredName").trim();

			if( rs.getString("InsuredID") == null )
				this.InsuredID = null;
			else
				this.InsuredID = rs.getString("InsuredID").trim();

			if( rs.getString("OldPolicyNo") == null )
				this.OldPolicyNo = null;
			else
				this.OldPolicyNo = rs.getString("OldPolicyNo").trim();

			this.BusinessDate = rs.getDate("BusinessDate");
			this.ASAReceivedDate = rs.getDate("ASAReceivedDate");
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

			if( rs.getString("Flag4") == null )
				this.Flag4 = null;
			else
				this.Flag4 = rs.getString("Flag4").trim();

			if( rs.getString("Flag5") == null )
				this.Flag5 = null;
			else
				this.Flag5 = rs.getString("Flag5").trim();

			this.BatchNo = rs.getDouble("BatchNo");
			this.BatchDate = rs.getDate("BatchDate");
			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

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
			logger.debug("数据库中的LCCont表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCContSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LCContSchema getSchema()
	{
		LCContSchema aLCContSchema = new LCContSchema();
		aLCContSchema.setSchema(this);
		return aLCContSchema;
	}

	public LCContDB getDB()
	{
		LCContDB aDBOper = new LCContDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCCont描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(CompanyCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainPolNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ProductCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ProductType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SplitRate1));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SplitRate2));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PolState)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( CValiDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( SignDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ReSignDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ReinDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AppntNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AppntName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AppntID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InsuredName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InsuredID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OldPolicyNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BusinessDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ASAReceivedDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag4)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag5)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(BatchNo));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BatchDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCCont>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			CompanyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			MainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			ProductCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ProductType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			AgentCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AgentCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			SplitRate1 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			SplitRate2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,8,SysConst.PACKAGESPILTER))).doubleValue();
			SAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			PolState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			CValiDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			SignDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12,SysConst.PACKAGESPILTER));
			ReSignDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			ReinDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			AppntNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			AppntName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			AppntID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			InsuredName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			InsuredID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			OldPolicyNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			BusinessDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21,SysConst.PACKAGESPILTER));
			ASAReceivedDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22,SysConst.PACKAGESPILTER));
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			Flag4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			Flag5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, SysConst.PACKAGESPILTER );
			BatchNo = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,28,SysConst.PACKAGESPILTER))).doubleValue();
			BatchDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29,SysConst.PACKAGESPILTER));
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCContSchema";
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
		if (FCode.equalsIgnoreCase("CompanyCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CompanyCode));
		}
		if (FCode.equalsIgnoreCase("MainPolNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainPolNo));
		}
		if (FCode.equalsIgnoreCase("ProductCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ProductCode));
		}
		if (FCode.equalsIgnoreCase("ProductType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ProductType));
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
		if (FCode.equalsIgnoreCase("SAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SAgentCode));
		}
		if (FCode.equalsIgnoreCase("PolState"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PolState));
		}
		if (FCode.equalsIgnoreCase("CValiDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getCValiDate()));
		}
		if (FCode.equalsIgnoreCase("SignDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getSignDate()));
		}
		if (FCode.equalsIgnoreCase("ReSignDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getReSignDate()));
		}
		if (FCode.equalsIgnoreCase("ReinDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getReinDate()));
		}
		if (FCode.equalsIgnoreCase("AppntNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AppntNo));
		}
		if (FCode.equalsIgnoreCase("AppntName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AppntName));
		}
		if (FCode.equalsIgnoreCase("AppntID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AppntID));
		}
		if (FCode.equalsIgnoreCase("InsuredName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuredName));
		}
		if (FCode.equalsIgnoreCase("InsuredID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuredID));
		}
		if (FCode.equalsIgnoreCase("OldPolicyNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OldPolicyNo));
		}
		if (FCode.equalsIgnoreCase("BusinessDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBusinessDate()));
		}
		if (FCode.equalsIgnoreCase("ASAReceivedDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
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
		if (FCode.equalsIgnoreCase("Flag4"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag4));
		}
		if (FCode.equalsIgnoreCase("Flag5"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Flag5));
		}
		if (FCode.equalsIgnoreCase("BatchNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BatchNo));
		}
		if (FCode.equalsIgnoreCase("BatchDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBatchDate()));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
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
				strFieldValue = StrTool.GBKToUnicode(CompanyCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(MainPolNo);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(ProductCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ProductType);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(AgentCode1);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(AgentCode2);
				break;
			case 6:
				strFieldValue = String.valueOf(SplitRate1);
				break;
			case 7:
				strFieldValue = String.valueOf(SplitRate2);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(SAgentCode);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(PolState);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCValiDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getSignDate()));
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getReSignDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getReinDate()));
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(AppntNo);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(AppntName);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(AppntID);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(InsuredName);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(InsuredID);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(OldPolicyNo);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBusinessDate()));
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(Flag1);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(Flag2);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(Flag3);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(Flag4);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(Flag5);
				break;
			case 27:
				strFieldValue = String.valueOf(BatchNo);
				break;
			case 28:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBatchDate()));
				break;
			case 29:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 30:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 31:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 32:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 33:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 34:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 35:
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

		if (FCode.equalsIgnoreCase("CompanyCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CompanyCode = FValue.trim();
			}
			else
				CompanyCode = null;
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
		if (FCode.equalsIgnoreCase("ProductCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ProductCode = FValue.trim();
			}
			else
				ProductCode = null;
		}
		if (FCode.equalsIgnoreCase("ProductType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ProductType = FValue.trim();
			}
			else
				ProductType = null;
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
		if (FCode.equalsIgnoreCase("SAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SAgentCode = FValue.trim();
			}
			else
				SAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("PolState"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PolState = FValue.trim();
			}
			else
				PolState = null;
		}
		if (FCode.equalsIgnoreCase("CValiDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				CValiDate = fDate.getDate( FValue );
			}
			else
				CValiDate = null;
		}
		if (FCode.equalsIgnoreCase("SignDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				SignDate = fDate.getDate( FValue );
			}
			else
				SignDate = null;
		}
		if (FCode.equalsIgnoreCase("ReSignDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ReSignDate = fDate.getDate( FValue );
			}
			else
				ReSignDate = null;
		}
		if (FCode.equalsIgnoreCase("ReinDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ReinDate = fDate.getDate( FValue );
			}
			else
				ReinDate = null;
		}
		if (FCode.equalsIgnoreCase("AppntNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AppntNo = FValue.trim();
			}
			else
				AppntNo = null;
		}
		if (FCode.equalsIgnoreCase("AppntName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AppntName = FValue.trim();
			}
			else
				AppntName = null;
		}
		if (FCode.equalsIgnoreCase("AppntID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AppntID = FValue.trim();
			}
			else
				AppntID = null;
		}
		if (FCode.equalsIgnoreCase("InsuredName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InsuredName = FValue.trim();
			}
			else
				InsuredName = null;
		}
		if (FCode.equalsIgnoreCase("InsuredID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InsuredID = FValue.trim();
			}
			else
				InsuredID = null;
		}
		if (FCode.equalsIgnoreCase("OldPolicyNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OldPolicyNo = FValue.trim();
			}
			else
				OldPolicyNo = null;
		}
		if (FCode.equalsIgnoreCase("BusinessDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BusinessDate = fDate.getDate( FValue );
			}
			else
				BusinessDate = null;
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
		if (FCode.equalsIgnoreCase("Flag4"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag4 = FValue.trim();
			}
			else
				Flag4 = null;
		}
		if (FCode.equalsIgnoreCase("Flag5"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Flag5 = FValue.trim();
			}
			else
				Flag5 = null;
		}
		if (FCode.equalsIgnoreCase("BatchNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				BatchNo = d;
			}
		}
		if (FCode.equalsIgnoreCase("BatchDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BatchDate = fDate.getDate( FValue );
			}
			else
				BatchDate = null;
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
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
		LCContSchema other = (LCContSchema)otherObject;
		return
			CompanyCode.equals(other.getCompanyCode())
			&& MainPolNo.equals(other.getMainPolNo())
			&& ProductCode.equals(other.getProductCode())
			&& ProductType.equals(other.getProductType())
			&& AgentCode1.equals(other.getAgentCode1())
			&& AgentCode2.equals(other.getAgentCode2())
			&& SplitRate1 == other.getSplitRate1()
			&& SplitRate2 == other.getSplitRate2()
			&& SAgentCode.equals(other.getSAgentCode())
			&& PolState.equals(other.getPolState())
			&& fDate.getString(CValiDate).equals(other.getCValiDate())
			&& fDate.getString(SignDate).equals(other.getSignDate())
			&& fDate.getString(ReSignDate).equals(other.getReSignDate())
			&& fDate.getString(ReinDate).equals(other.getReinDate())
			&& AppntNo.equals(other.getAppntNo())
			&& AppntName.equals(other.getAppntName())
			&& AppntID.equals(other.getAppntID())
			&& InsuredName.equals(other.getInsuredName())
			&& InsuredID.equals(other.getInsuredID())
			&& OldPolicyNo.equals(other.getOldPolicyNo())
			&& fDate.getString(BusinessDate).equals(other.getBusinessDate())
			&& fDate.getString(ASAReceivedDate).equals(other.getASAReceivedDate())
			&& Flag1.equals(other.getFlag1())
			&& Flag2.equals(other.getFlag2())
			&& Flag3.equals(other.getFlag3())
			&& Flag4.equals(other.getFlag4())
			&& Flag5.equals(other.getFlag5())
			&& BatchNo == other.getBatchNo()
			&& fDate.getString(BatchDate).equals(other.getBatchDate())
			&& ManageCom.equals(other.getManageCom())
			&& BranchType.equals(other.getBranchType())
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
		if( strFieldName.equals("CompanyCode") ) {
			return 0;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return 1;
		}
		if( strFieldName.equals("ProductCode") ) {
			return 2;
		}
		if( strFieldName.equals("ProductType") ) {
			return 3;
		}
		if( strFieldName.equals("AgentCode1") ) {
			return 4;
		}
		if( strFieldName.equals("AgentCode2") ) {
			return 5;
		}
		if( strFieldName.equals("SplitRate1") ) {
			return 6;
		}
		if( strFieldName.equals("SplitRate2") ) {
			return 7;
		}
		if( strFieldName.equals("SAgentCode") ) {
			return 8;
		}
		if( strFieldName.equals("PolState") ) {
			return 9;
		}
		if( strFieldName.equals("CValiDate") ) {
			return 10;
		}
		if( strFieldName.equals("SignDate") ) {
			return 11;
		}
		if( strFieldName.equals("ReSignDate") ) {
			return 12;
		}
		if( strFieldName.equals("ReinDate") ) {
			return 13;
		}
		if( strFieldName.equals("AppntNo") ) {
			return 14;
		}
		if( strFieldName.equals("AppntName") ) {
			return 15;
		}
		if( strFieldName.equals("AppntID") ) {
			return 16;
		}
		if( strFieldName.equals("InsuredName") ) {
			return 17;
		}
		if( strFieldName.equals("InsuredID") ) {
			return 18;
		}
		if( strFieldName.equals("OldPolicyNo") ) {
			return 19;
		}
		if( strFieldName.equals("BusinessDate") ) {
			return 20;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return 21;
		}
		if( strFieldName.equals("Flag1") ) {
			return 22;
		}
		if( strFieldName.equals("Flag2") ) {
			return 23;
		}
		if( strFieldName.equals("Flag3") ) {
			return 24;
		}
		if( strFieldName.equals("Flag4") ) {
			return 25;
		}
		if( strFieldName.equals("Flag5") ) {
			return 26;
		}
		if( strFieldName.equals("BatchNo") ) {
			return 27;
		}
		if( strFieldName.equals("BatchDate") ) {
			return 28;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 29;
		}
		if( strFieldName.equals("BranchType") ) {
			return 30;
		}
		if( strFieldName.equals("Operator") ) {
			return 31;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 32;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 33;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 34;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 35;
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
				strFieldName = "CompanyCode";
				break;
			case 1:
				strFieldName = "MainPolNo";
				break;
			case 2:
				strFieldName = "ProductCode";
				break;
			case 3:
				strFieldName = "ProductType";
				break;
			case 4:
				strFieldName = "AgentCode1";
				break;
			case 5:
				strFieldName = "AgentCode2";
				break;
			case 6:
				strFieldName = "SplitRate1";
				break;
			case 7:
				strFieldName = "SplitRate2";
				break;
			case 8:
				strFieldName = "SAgentCode";
				break;
			case 9:
				strFieldName = "PolState";
				break;
			case 10:
				strFieldName = "CValiDate";
				break;
			case 11:
				strFieldName = "SignDate";
				break;
			case 12:
				strFieldName = "ReSignDate";
				break;
			case 13:
				strFieldName = "ReinDate";
				break;
			case 14:
				strFieldName = "AppntNo";
				break;
			case 15:
				strFieldName = "AppntName";
				break;
			case 16:
				strFieldName = "AppntID";
				break;
			case 17:
				strFieldName = "InsuredName";
				break;
			case 18:
				strFieldName = "InsuredID";
				break;
			case 19:
				strFieldName = "OldPolicyNo";
				break;
			case 20:
				strFieldName = "BusinessDate";
				break;
			case 21:
				strFieldName = "ASAReceivedDate";
				break;
			case 22:
				strFieldName = "Flag1";
				break;
			case 23:
				strFieldName = "Flag2";
				break;
			case 24:
				strFieldName = "Flag3";
				break;
			case 25:
				strFieldName = "Flag4";
				break;
			case 26:
				strFieldName = "Flag5";
				break;
			case 27:
				strFieldName = "BatchNo";
				break;
			case 28:
				strFieldName = "BatchDate";
				break;
			case 29:
				strFieldName = "ManageCom";
				break;
			case 30:
				strFieldName = "BranchType";
				break;
			case 31:
				strFieldName = "Operator";
				break;
			case 32:
				strFieldName = "MakeDate";
				break;
			case 33:
				strFieldName = "MakeTime";
				break;
			case 34:
				strFieldName = "ModifyDate";
				break;
			case 35:
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
		if( strFieldName.equals("CompanyCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ProductCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ProductType") ) {
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
		if( strFieldName.equals("SAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PolState") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CValiDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("SignDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ReSignDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ReinDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("AppntNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AppntName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AppntID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InsuredName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InsuredID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OldPolicyNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BusinessDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return Schema.TYPE_DATE;
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
		if( strFieldName.equals("Flag4") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Flag5") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BatchNo") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("BatchDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 7:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 20:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 21:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 22:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 23:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 24:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 25:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 26:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 27:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 28:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 29:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 30:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 31:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 32:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 33:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 34:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 35:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
