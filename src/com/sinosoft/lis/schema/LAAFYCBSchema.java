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
import com.sinosoft.lis.db.LAAFYCBDB;

/*
 * <p>ClassName: LAAFYCBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAFYCBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAFYCBSchema.class);
	// @Field
	/** Afycsn */
	private String AFYCSN;
	/** Companycode */
	private String CompanyCode;
	/** Mainpolno */
	private String MainPolNo;
	/** Productcode */
	private String ProductCode;
	/** Riskcode */
	private String RiskCode;
	/** Cvalidate */
	private Date CvaliDate;
	/** Afyc */
	private double AFYC;
	/** Afyp */
	private double AFYP;
	/** Trxcode */
	private String TrxCode;
	/** Calculationdate */
	private Date CalculationDate;
	/** Businessdate */
	private Date BusinessDate;
	/** Batchno */
	private double BatchNo;
	/** Batchdate */
	private Date BatchDate;
	/** Caldate */
	private Date CalDate;
	/** Splitrate1 */
	private double SplitRate1;
	/** Agentcode1 */
	private String Agentcode1;
	/** Umcode1 */
	private String UMCode1;
	/** Unitcode1 */
	private String UnitCode1;
	/** Dmcode1 */
	private String DMCode1;
	/** Divisioncode1 */
	private String DivisionCode1;
	/** Rmcode1 */
	private String RMCode1;
	/** Regioncode1 */
	private String RegionCode1;
	/** Drcode1 */
	private String DRCode1;
	/** Idrcode1 */
	private String IDRCode1;
	/** Rccode1 */
	private String RCCode1;
	/** Rfcode1 */
	private String RFCode1;
	/** Assessmonth1 */
	private String AssessMonth1;
	/** Wagemonth1 */
	private String WageMonth1;
	/** Splitrate2 */
	private double SplitRate2;
	/** Agentcode2 */
	private String Agentcode2;
	/** Umcode2 */
	private String UMCode2;
	/** Unitcode2 */
	private String UnitCode2;
	/** Dmcode2 */
	private String DMCode2;
	/** Divisioncode2 */
	private String DivisionCode2;
	/** Rmcode2 */
	private String RMCode2;
	/** Regioncode2 */
	private String RegionCode2;
	/** Drcode2 */
	private String DRCode2;
	/** Idrcode2 */
	private String IDRCode2;
	/** Rccode2 */
	private String RCCode2;
	/** Rfcode2 */
	private String RFCode2;
	/** Assessmonth2 */
	private String AssessMonth2;
	/** Wagemonth2 */
	private String WageMonth2;
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

	public static final int FIELDNUM = 50;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAFYCBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "AFYCSN";
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
		LAAFYCBSchema cloned = (LAAFYCBSchema)super.clone();
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
	* AFYCSN
	*/
	public String getAFYCSN()
	{
		return AFYCSN;
	}
	public void setAFYCSN(String aAFYCSN)
	{
		if(aAFYCSN!=null && aAFYCSN.length()>20)
			throw new IllegalArgumentException("AfycsnAFYCSN值"+aAFYCSN+"的长度"+aAFYCSN.length()+"大于最大值20");
		AFYCSN = aAFYCSN;
	}
	/**
	* 公司編號【同构表Company_Code】
	*/
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
	/**
	* 保單號【同构表Policy_No】
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
	* 產品代碼【同构表Product_Code】
	*/
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
	/**
	* 險種代碼【同构表Coverage_Code】
	*/
	public String getRiskCode()
	{
		return RiskCode;
	}
	public void setRiskCode(String aRiskCode)
	{
		if(aRiskCode!=null && aRiskCode.length()>4)
			throw new IllegalArgumentException("RiskcodeRiskCode值"+aRiskCode+"的长度"+aRiskCode.length()+"大于最大值4");
		RiskCode = aRiskCode;
	}
	/**
	* 險種生效日【同构表Coverage_Effective_Date】
	*/
	public String getCvaliDate()
	{
		if( CvaliDate != null )
			return fDate.getString(CvaliDate);
		else
			return null;
	}
	public void setCvaliDate(Date aCvaliDate)
	{
		CvaliDate = aCvaliDate;
	}
	public void setCvaliDate(String aCvaliDate)
	{
		if (aCvaliDate != null && !aCvaliDate.equals("") )
		{
			CvaliDate = fDate.getDate( aCvaliDate );
		}
		else
			CvaliDate = null;
	}

	/**
	* AFYC【同构表AFYC】
	*/
	public double getAFYC()
	{
		return AFYC;
	}
	public void setAFYC(double aAFYC)
	{
		AFYC = aAFYC;
	}
	public void setAFYC(String aAFYC)
	{
		if (aAFYC != null && !aAFYC.equals(""))
		{
			Double tDouble = new Double(aAFYC);
			double d = tDouble.doubleValue();
			AFYC = d;
		}
	}

	/**
	* AFYP【同构表AFYP】
	*/
	public double getAFYP()
	{
		return AFYP;
	}
	public void setAFYP(double aAFYP)
	{
		AFYP = aAFYP;
	}
	public void setAFYP(String aAFYP)
	{
		if (aAFYP != null && !aAFYP.equals(""))
		{
			Double tDouble = new Double(aAFYP);
			double d = tDouble.doubleValue();
			AFYP = d;
		}
	}

	/**
	* ？？【同构表Trx_Code】
	*/
	public String getTrxCode()
	{
		return TrxCode;
	}
	public void setTrxCode(String aTrxCode)
	{
		if(aTrxCode!=null && aTrxCode.length()>4)
			throw new IllegalArgumentException("TrxcodeTrxCode值"+aTrxCode+"的长度"+aTrxCode.length()+"大于最大值4");
		TrxCode = aTrxCode;
	}
	/**
	* AFYC計算日【同构表Calculation_Date】
	*/
	public String getCalculationDate()
	{
		if( CalculationDate != null )
			return fDate.getString(CalculationDate);
		else
			return null;
	}
	public void setCalculationDate(Date aCalculationDate)
	{
		CalculationDate = aCalculationDate;
	}
	public void setCalculationDate(String aCalculationDate)
	{
		if (aCalculationDate != null && !aCalculationDate.equals("") )
		{
			CalculationDate = fDate.getDate( aCalculationDate );
		}
		else
			CalculationDate = null;
	}

	/**
	* 業務AFYC產生日期【同构表Business_Date】
	*/
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

	/**
	* BatchNo【同构表Batch_No】
	*/
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

	/**
	* BatchDate【同构表Batch_Run_Date】
	*/
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

	/**
	* 计算日【CalDoBl计算时的系统日期】
	*/
	public String getCalDate()
	{
		if( CalDate != null )
			return fDate.getString(CalDate);
		else
			return null;
	}
	public void setCalDate(Date aCalDate)
	{
		CalDate = aCalDate;
	}
	public void setCalDate(String aCalDate)
	{
		if (aCalDate != null && !aCalDate.equals("") )
		{
			CalDate = fDate.getDate( aCalDate );
		}
		else
			CalDate = null;
	}

	/**
	* 主代理人分单比例分单比例【取自CalSaveBl提数时的LCCont】
	*/
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

	/**
	* 主代理人编码【取自CalSaveBl提数时的LCCont】
	*/
	public String getAgentcode1()
	{
		return Agentcode1;
	}
	public void setAgentcode1(String aAgentcode1)
	{
		if(aAgentcode1!=null && aAgentcode1.length()>12)
			throw new IllegalArgumentException("Agentcode1Agentcode1值"+aAgentcode1+"的长度"+aAgentcode1.length()+"大于最大值12");
		Agentcode1 = aAgentcode1;
	}
	/**
	* 主代理人UM编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getUMCode1()
	{
		return UMCode1;
	}
	public void setUMCode1(String aUMCode1)
	{
		if(aUMCode1!=null && aUMCode1.length()>12)
			throw new IllegalArgumentException("Umcode1UMCode1值"+aUMCode1+"的长度"+aUMCode1.length()+"大于最大值12");
		UMCode1 = aUMCode1;
	}
	public String getUnitCode1()
	{
		return UnitCode1;
	}
	public void setUnitCode1(String aUnitCode1)
	{
		if(aUnitCode1!=null && aUnitCode1.length()>20)
			throw new IllegalArgumentException("Unitcode1UnitCode1值"+aUnitCode1+"的长度"+aUnitCode1.length()+"大于最大值20");
		UnitCode1 = aUnitCode1;
	}
	/**
	* 主代理人DM编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getDMCode1()
	{
		return DMCode1;
	}
	public void setDMCode1(String aDMCode1)
	{
		if(aDMCode1!=null && aDMCode1.length()>12)
			throw new IllegalArgumentException("Dmcode1DMCode1值"+aDMCode1+"的长度"+aDMCode1.length()+"大于最大值12");
		DMCode1 = aDMCode1;
	}
	public String getDivisionCode1()
	{
		return DivisionCode1;
	}
	public void setDivisionCode1(String aDivisionCode1)
	{
		if(aDivisionCode1!=null && aDivisionCode1.length()>20)
			throw new IllegalArgumentException("Divisioncode1DivisionCode1值"+aDivisionCode1+"的长度"+aDivisionCode1.length()+"大于最大值20");
		DivisionCode1 = aDivisionCode1;
	}
	/**
	* 主代理人RM编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getRMCode1()
	{
		return RMCode1;
	}
	public void setRMCode1(String aRMCode1)
	{
		if(aRMCode1!=null && aRMCode1.length()>12)
			throw new IllegalArgumentException("Rmcode1RMCode1值"+aRMCode1+"的长度"+aRMCode1.length()+"大于最大值12");
		RMCode1 = aRMCode1;
	}
	public String getRegionCode1()
	{
		return RegionCode1;
	}
	public void setRegionCode1(String aRegionCode1)
	{
		if(aRegionCode1!=null && aRegionCode1.length()>20)
			throw new IllegalArgumentException("Regioncode1RegionCode1值"+aRegionCode1+"的长度"+aRegionCode1.length()+"大于最大值20");
		RegionCode1 = aRegionCode1;
	}
	/**
	* 主代理人DirectReporting人员编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getDRCode1()
	{
		return DRCode1;
	}
	public void setDRCode1(String aDRCode1)
	{
		if(aDRCode1!=null && aDRCode1.length()>12)
			throw new IllegalArgumentException("Drcode1DRCode1值"+aDRCode1+"的长度"+aDRCode1.length()+"大于最大值12");
		DRCode1 = aDRCode1;
	}
	/**
	* 主代理人IndirectReporting人员编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getIDRCode1()
	{
		return IDRCode1;
	}
	public void setIDRCode1(String aIDRCode1)
	{
		if(aIDRCode1!=null && aIDRCode1.length()>12)
			throw new IllegalArgumentException("Idrcode1IDRCode1值"+aIDRCode1+"的长度"+aIDRCode1.length()+"大于最大值12");
		IDRCode1 = aIDRCode1;
	}
	/**
	* 主代理人Recruiting招募人编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getRCCode1()
	{
		return RCCode1;
	}
	public void setRCCode1(String aRCCode1)
	{
		if(aRCCode1!=null && aRCCode1.length()>12)
			throw new IllegalArgumentException("Rccode1RCCode1值"+aRCCode1+"的长度"+aRCCode1.length()+"大于最大值12");
		RCCode1 = aRCCode1;
	}
	/**
	* 主代理人Referring推荐人编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getRFCode1()
	{
		return RFCode1;
	}
	public void setRFCode1(String aRFCode1)
	{
		if(aRFCode1!=null && aRFCode1.length()>12)
			throw new IllegalArgumentException("Rfcode1RFCode1值"+aRFCode1+"的长度"+aRFCode1.length()+"大于最大值12");
		RFCode1 = aRFCode1;
	}
	/**
	* 主代理人考核归属月【根据BusinessDate和最大考核计算月联合计算】
	*/
	public String getAssessMonth1()
	{
		return AssessMonth1;
	}
	public void setAssessMonth1(String aAssessMonth1)
	{
		if(aAssessMonth1!=null && aAssessMonth1.length()>6)
			throw new IllegalArgumentException("Assessmonth1AssessMonth1值"+aAssessMonth1+"的长度"+aAssessMonth1.length()+"大于最大值6");
		AssessMonth1 = aAssessMonth1;
	}
	/**
	* 主代理人薪资归属月【根据BusinessDate和最大薪资计算月联合计算】
	*/
	public String getWageMonth1()
	{
		return WageMonth1;
	}
	public void setWageMonth1(String aWageMonth1)
	{
		if(aWageMonth1!=null && aWageMonth1.length()>6)
			throw new IllegalArgumentException("Wagemonth1WageMonth1值"+aWageMonth1+"的长度"+aWageMonth1.length()+"大于最大值6");
		WageMonth1 = aWageMonth1;
	}
	/**
	* 次代理人分单比例分单比例【取自CalSaveBl提数时的LCCont】
	*/
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

	/**
	* 次代理人编码【取自CalSaveBl提数时的LCCont】
	*/
	public String getAgentcode2()
	{
		return Agentcode2;
	}
	public void setAgentcode2(String aAgentcode2)
	{
		if(aAgentcode2!=null && aAgentcode2.length()>12)
			throw new IllegalArgumentException("Agentcode2Agentcode2值"+aAgentcode2+"的长度"+aAgentcode2.length()+"大于最大值12");
		Agentcode2 = aAgentcode2;
	}
	/**
	* 次代理人UM编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getUMCode2()
	{
		return UMCode2;
	}
	public void setUMCode2(String aUMCode2)
	{
		if(aUMCode2!=null && aUMCode2.length()>12)
			throw new IllegalArgumentException("Umcode2UMCode2值"+aUMCode2+"的长度"+aUMCode2.length()+"大于最大值12");
		UMCode2 = aUMCode2;
	}
	public String getUnitCode2()
	{
		return UnitCode2;
	}
	public void setUnitCode2(String aUnitCode2)
	{
		if(aUnitCode2!=null && aUnitCode2.length()>20)
			throw new IllegalArgumentException("Unitcode2UnitCode2值"+aUnitCode2+"的长度"+aUnitCode2.length()+"大于最大值20");
		UnitCode2 = aUnitCode2;
	}
	/**
	* 次代理人DM编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getDMCode2()
	{
		return DMCode2;
	}
	public void setDMCode2(String aDMCode2)
	{
		if(aDMCode2!=null && aDMCode2.length()>12)
			throw new IllegalArgumentException("Dmcode2DMCode2值"+aDMCode2+"的长度"+aDMCode2.length()+"大于最大值12");
		DMCode2 = aDMCode2;
	}
	public String getDivisionCode2()
	{
		return DivisionCode2;
	}
	public void setDivisionCode2(String aDivisionCode2)
	{
		if(aDivisionCode2!=null && aDivisionCode2.length()>20)
			throw new IllegalArgumentException("Divisioncode2DivisionCode2值"+aDivisionCode2+"的长度"+aDivisionCode2.length()+"大于最大值20");
		DivisionCode2 = aDivisionCode2;
	}
	/**
	* 次代理人RM编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getRMCode2()
	{
		return RMCode2;
	}
	public void setRMCode2(String aRMCode2)
	{
		if(aRMCode2!=null && aRMCode2.length()>12)
			throw new IllegalArgumentException("Rmcode2RMCode2值"+aRMCode2+"的长度"+aRMCode2.length()+"大于最大值12");
		RMCode2 = aRMCode2;
	}
	public String getRegionCode2()
	{
		return RegionCode2;
	}
	public void setRegionCode2(String aRegionCode2)
	{
		if(aRegionCode2!=null && aRegionCode2.length()>20)
			throw new IllegalArgumentException("Regioncode2RegionCode2值"+aRegionCode2+"的长度"+aRegionCode2.length()+"大于最大值20");
		RegionCode2 = aRegionCode2;
	}
	/**
	* 次代理人DirectReporting人员编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getDRCode2()
	{
		return DRCode2;
	}
	public void setDRCode2(String aDRCode2)
	{
		if(aDRCode2!=null && aDRCode2.length()>12)
			throw new IllegalArgumentException("Drcode2DRCode2值"+aDRCode2+"的长度"+aDRCode2.length()+"大于最大值12");
		DRCode2 = aDRCode2;
	}
	/**
	* 次代理人IndirectReporting人员编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getIDRCode2()
	{
		return IDRCode2;
	}
	public void setIDRCode2(String aIDRCode2)
	{
		if(aIDRCode2!=null && aIDRCode2.length()>12)
			throw new IllegalArgumentException("Idrcode2IDRCode2值"+aIDRCode2+"的长度"+aIDRCode2.length()+"大于最大值12");
		IDRCode2 = aIDRCode2;
	}
	/**
	* 次代理人Recruiting招募人编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getRCCode2()
	{
		return RCCode2;
	}
	public void setRCCode2(String aRCCode2)
	{
		if(aRCCode2!=null && aRCCode2.length()>12)
			throw new IllegalArgumentException("Rccode2RCCode2值"+aRCCode2+"的长度"+aRCCode2.length()+"大于最大值12");
		RCCode2 = aRCCode2;
	}
	/**
	* 次代理人Referring推荐人编码【取自CalSaveBl提数时的laagentv】
	*/
	public String getRFCode2()
	{
		return RFCode2;
	}
	public void setRFCode2(String aRFCode2)
	{
		if(aRFCode2!=null && aRFCode2.length()>12)
			throw new IllegalArgumentException("Rfcode2RFCode2值"+aRFCode2+"的长度"+aRFCode2.length()+"大于最大值12");
		RFCode2 = aRFCode2;
	}
	/**
	* 次代理人考核归属月【根据BusinessDate和最大考核计算月联合计算】
	*/
	public String getAssessMonth2()
	{
		return AssessMonth2;
	}
	public void setAssessMonth2(String aAssessMonth2)
	{
		if(aAssessMonth2!=null && aAssessMonth2.length()>6)
			throw new IllegalArgumentException("Assessmonth2AssessMonth2值"+aAssessMonth2+"的长度"+aAssessMonth2.length()+"大于最大值6");
		AssessMonth2 = aAssessMonth2;
	}
	/**
	* 次代理人薪资归属月【根据BusinessDate和最大薪资计算月联合计算】
	*/
	public String getWageMonth2()
	{
		return WageMonth2;
	}
	public void setWageMonth2(String aWageMonth2)
	{
		if(aWageMonth2!=null && aWageMonth2.length()>6)
			throw new IllegalArgumentException("Wagemonth2WageMonth2值"+aWageMonth2+"的长度"+aWageMonth2.length()+"大于最大值6");
		WageMonth2 = aWageMonth2;
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
	* 使用另外一个 LAAFYCBSchema 对象给 Schema 赋值
	* @param: aLAAFYCBSchema LAAFYCBSchema
	**/
	public void setSchema(LAAFYCBSchema aLAAFYCBSchema)
	{
		this.AFYCSN = aLAAFYCBSchema.getAFYCSN();
		this.CompanyCode = aLAAFYCBSchema.getCompanyCode();
		this.MainPolNo = aLAAFYCBSchema.getMainPolNo();
		this.ProductCode = aLAAFYCBSchema.getProductCode();
		this.RiskCode = aLAAFYCBSchema.getRiskCode();
		this.CvaliDate = fDate.getDate( aLAAFYCBSchema.getCvaliDate());
		this.AFYC = aLAAFYCBSchema.getAFYC();
		this.AFYP = aLAAFYCBSchema.getAFYP();
		this.TrxCode = aLAAFYCBSchema.getTrxCode();
		this.CalculationDate = fDate.getDate( aLAAFYCBSchema.getCalculationDate());
		this.BusinessDate = fDate.getDate( aLAAFYCBSchema.getBusinessDate());
		this.BatchNo = aLAAFYCBSchema.getBatchNo();
		this.BatchDate = fDate.getDate( aLAAFYCBSchema.getBatchDate());
		this.CalDate = fDate.getDate( aLAAFYCBSchema.getCalDate());
		this.SplitRate1 = aLAAFYCBSchema.getSplitRate1();
		this.Agentcode1 = aLAAFYCBSchema.getAgentcode1();
		this.UMCode1 = aLAAFYCBSchema.getUMCode1();
		this.UnitCode1 = aLAAFYCBSchema.getUnitCode1();
		this.DMCode1 = aLAAFYCBSchema.getDMCode1();
		this.DivisionCode1 = aLAAFYCBSchema.getDivisionCode1();
		this.RMCode1 = aLAAFYCBSchema.getRMCode1();
		this.RegionCode1 = aLAAFYCBSchema.getRegionCode1();
		this.DRCode1 = aLAAFYCBSchema.getDRCode1();
		this.IDRCode1 = aLAAFYCBSchema.getIDRCode1();
		this.RCCode1 = aLAAFYCBSchema.getRCCode1();
		this.RFCode1 = aLAAFYCBSchema.getRFCode1();
		this.AssessMonth1 = aLAAFYCBSchema.getAssessMonth1();
		this.WageMonth1 = aLAAFYCBSchema.getWageMonth1();
		this.SplitRate2 = aLAAFYCBSchema.getSplitRate2();
		this.Agentcode2 = aLAAFYCBSchema.getAgentcode2();
		this.UMCode2 = aLAAFYCBSchema.getUMCode2();
		this.UnitCode2 = aLAAFYCBSchema.getUnitCode2();
		this.DMCode2 = aLAAFYCBSchema.getDMCode2();
		this.DivisionCode2 = aLAAFYCBSchema.getDivisionCode2();
		this.RMCode2 = aLAAFYCBSchema.getRMCode2();
		this.RegionCode2 = aLAAFYCBSchema.getRegionCode2();
		this.DRCode2 = aLAAFYCBSchema.getDRCode2();
		this.IDRCode2 = aLAAFYCBSchema.getIDRCode2();
		this.RCCode2 = aLAAFYCBSchema.getRCCode2();
		this.RFCode2 = aLAAFYCBSchema.getRFCode2();
		this.AssessMonth2 = aLAAFYCBSchema.getAssessMonth2();
		this.WageMonth2 = aLAAFYCBSchema.getWageMonth2();
		this.Operator = aLAAFYCBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAFYCBSchema.getMakeDate());
		this.MakeTime = aLAAFYCBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAFYCBSchema.getModifyDate());
		this.ModifyTime = aLAAFYCBSchema.getModifyTime();
		this.Operator1 = aLAAFYCBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLAAFYCBSchema.getMakeDate1());
		this.MakeTime1 = aLAAFYCBSchema.getMakeTime1();
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
			if( rs.getString("AFYCSN") == null )
				this.AFYCSN = null;
			else
				this.AFYCSN = rs.getString("AFYCSN").trim();

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

			if( rs.getString("RiskCode") == null )
				this.RiskCode = null;
			else
				this.RiskCode = rs.getString("RiskCode").trim();

			this.CvaliDate = rs.getDate("CvaliDate");
			this.AFYC = rs.getDouble("AFYC");
			this.AFYP = rs.getDouble("AFYP");
			if( rs.getString("TrxCode") == null )
				this.TrxCode = null;
			else
				this.TrxCode = rs.getString("TrxCode").trim();

			this.CalculationDate = rs.getDate("CalculationDate");
			this.BusinessDate = rs.getDate("BusinessDate");
			this.BatchNo = rs.getDouble("BatchNo");
			this.BatchDate = rs.getDate("BatchDate");
			this.CalDate = rs.getDate("CalDate");
			this.SplitRate1 = rs.getDouble("SplitRate1");
			if( rs.getString("Agentcode1") == null )
				this.Agentcode1 = null;
			else
				this.Agentcode1 = rs.getString("Agentcode1").trim();

			if( rs.getString("UMCode1") == null )
				this.UMCode1 = null;
			else
				this.UMCode1 = rs.getString("UMCode1").trim();

			if( rs.getString("UnitCode1") == null )
				this.UnitCode1 = null;
			else
				this.UnitCode1 = rs.getString("UnitCode1").trim();

			if( rs.getString("DMCode1") == null )
				this.DMCode1 = null;
			else
				this.DMCode1 = rs.getString("DMCode1").trim();

			if( rs.getString("DivisionCode1") == null )
				this.DivisionCode1 = null;
			else
				this.DivisionCode1 = rs.getString("DivisionCode1").trim();

			if( rs.getString("RMCode1") == null )
				this.RMCode1 = null;
			else
				this.RMCode1 = rs.getString("RMCode1").trim();

			if( rs.getString("RegionCode1") == null )
				this.RegionCode1 = null;
			else
				this.RegionCode1 = rs.getString("RegionCode1").trim();

			if( rs.getString("DRCode1") == null )
				this.DRCode1 = null;
			else
				this.DRCode1 = rs.getString("DRCode1").trim();

			if( rs.getString("IDRCode1") == null )
				this.IDRCode1 = null;
			else
				this.IDRCode1 = rs.getString("IDRCode1").trim();

			if( rs.getString("RCCode1") == null )
				this.RCCode1 = null;
			else
				this.RCCode1 = rs.getString("RCCode1").trim();

			if( rs.getString("RFCode1") == null )
				this.RFCode1 = null;
			else
				this.RFCode1 = rs.getString("RFCode1").trim();

			if( rs.getString("AssessMonth1") == null )
				this.AssessMonth1 = null;
			else
				this.AssessMonth1 = rs.getString("AssessMonth1").trim();

			if( rs.getString("WageMonth1") == null )
				this.WageMonth1 = null;
			else
				this.WageMonth1 = rs.getString("WageMonth1").trim();

			this.SplitRate2 = rs.getDouble("SplitRate2");
			if( rs.getString("Agentcode2") == null )
				this.Agentcode2 = null;
			else
				this.Agentcode2 = rs.getString("Agentcode2").trim();

			if( rs.getString("UMCode2") == null )
				this.UMCode2 = null;
			else
				this.UMCode2 = rs.getString("UMCode2").trim();

			if( rs.getString("UnitCode2") == null )
				this.UnitCode2 = null;
			else
				this.UnitCode2 = rs.getString("UnitCode2").trim();

			if( rs.getString("DMCode2") == null )
				this.DMCode2 = null;
			else
				this.DMCode2 = rs.getString("DMCode2").trim();

			if( rs.getString("DivisionCode2") == null )
				this.DivisionCode2 = null;
			else
				this.DivisionCode2 = rs.getString("DivisionCode2").trim();

			if( rs.getString("RMCode2") == null )
				this.RMCode2 = null;
			else
				this.RMCode2 = rs.getString("RMCode2").trim();

			if( rs.getString("RegionCode2") == null )
				this.RegionCode2 = null;
			else
				this.RegionCode2 = rs.getString("RegionCode2").trim();

			if( rs.getString("DRCode2") == null )
				this.DRCode2 = null;
			else
				this.DRCode2 = rs.getString("DRCode2").trim();

			if( rs.getString("IDRCode2") == null )
				this.IDRCode2 = null;
			else
				this.IDRCode2 = rs.getString("IDRCode2").trim();

			if( rs.getString("RCCode2") == null )
				this.RCCode2 = null;
			else
				this.RCCode2 = rs.getString("RCCode2").trim();

			if( rs.getString("RFCode2") == null )
				this.RFCode2 = null;
			else
				this.RFCode2 = rs.getString("RFCode2").trim();

			if( rs.getString("AssessMonth2") == null )
				this.AssessMonth2 = null;
			else
				this.AssessMonth2 = rs.getString("AssessMonth2").trim();

			if( rs.getString("WageMonth2") == null )
				this.WageMonth2 = null;
			else
				this.WageMonth2 = rs.getString("WageMonth2").trim();

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
			logger.debug("数据库中的LAAFYCB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAFYCBSchema getSchema()
	{
		LAAFYCBSchema aLAAFYCBSchema = new LAAFYCBSchema();
		aLAAFYCBSchema.setSchema(this);
		return aLAAFYCBSchema;
	}

	public LAAFYCBDB getDB()
	{
		LAAFYCBDB aDBOper = new LAAFYCBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAFYCB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AFYCSN)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CompanyCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainPolNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ProductCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( CvaliDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AFYC));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AFYP));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TrxCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( CalculationDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BusinessDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(BatchNo));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BatchDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( CalDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SplitRate1));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Agentcode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UMCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UnitCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DMCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DivisionCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RMCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegionCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DRCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IDRCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RCCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RFCode1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AssessMonth1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageMonth1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SplitRate2));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Agentcode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UMCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UnitCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DMCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DivisionCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RMCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegionCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DRCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IDRCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RCCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RFCode2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AssessMonth2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageMonth2)); strReturn.append(SysConst.PACKAGESPILTER);
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
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAFYCB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AFYCSN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			CompanyCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			MainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ProductCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			RiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			CvaliDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			AFYC = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,7,SysConst.PACKAGESPILTER))).doubleValue();
			AFYP = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,8,SysConst.PACKAGESPILTER))).doubleValue();
			TrxCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			CalculationDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			BusinessDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			BatchNo = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,12,SysConst.PACKAGESPILTER))).doubleValue();
			BatchDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			CalDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14,SysConst.PACKAGESPILTER));
			SplitRate1 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,15,SysConst.PACKAGESPILTER))).doubleValue();
			Agentcode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			UMCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			UnitCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			DMCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			DivisionCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			RMCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			RegionCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			DRCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			IDRCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			RCCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			RFCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			AssessMonth1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, SysConst.PACKAGESPILTER );
			WageMonth1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
			SplitRate2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,29,SysConst.PACKAGESPILTER))).doubleValue();
			Agentcode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, SysConst.PACKAGESPILTER );
			UMCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, SysConst.PACKAGESPILTER );
			UnitCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, SysConst.PACKAGESPILTER );
			DMCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, SysConst.PACKAGESPILTER );
			DivisionCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, SysConst.PACKAGESPILTER );
			RMCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, SysConst.PACKAGESPILTER );
			RegionCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, SysConst.PACKAGESPILTER );
			DRCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, SysConst.PACKAGESPILTER );
			IDRCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, SysConst.PACKAGESPILTER );
			RCCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, SysConst.PACKAGESPILTER );
			RFCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, SysConst.PACKAGESPILTER );
			AssessMonth2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, SysConst.PACKAGESPILTER );
			WageMonth2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCBSchema";
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
		if (FCode.equalsIgnoreCase("AFYCSN"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AFYCSN));
		}
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
		if (FCode.equalsIgnoreCase("RiskCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskCode));
		}
		if (FCode.equalsIgnoreCase("CvaliDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getCvaliDate()));
		}
		if (FCode.equalsIgnoreCase("AFYC"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AFYC));
		}
		if (FCode.equalsIgnoreCase("AFYP"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AFYP));
		}
		if (FCode.equalsIgnoreCase("TrxCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TrxCode));
		}
		if (FCode.equalsIgnoreCase("CalculationDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getCalculationDate()));
		}
		if (FCode.equalsIgnoreCase("BusinessDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBusinessDate()));
		}
		if (FCode.equalsIgnoreCase("BatchNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BatchNo));
		}
		if (FCode.equalsIgnoreCase("BatchDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBatchDate()));
		}
		if (FCode.equalsIgnoreCase("CalDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getCalDate()));
		}
		if (FCode.equalsIgnoreCase("SplitRate1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SplitRate1));
		}
		if (FCode.equalsIgnoreCase("Agentcode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Agentcode1));
		}
		if (FCode.equalsIgnoreCase("UMCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UMCode1));
		}
		if (FCode.equalsIgnoreCase("UnitCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UnitCode1));
		}
		if (FCode.equalsIgnoreCase("DMCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DMCode1));
		}
		if (FCode.equalsIgnoreCase("DivisionCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DivisionCode1));
		}
		if (FCode.equalsIgnoreCase("RMCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RMCode1));
		}
		if (FCode.equalsIgnoreCase("RegionCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegionCode1));
		}
		if (FCode.equalsIgnoreCase("DRCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DRCode1));
		}
		if (FCode.equalsIgnoreCase("IDRCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDRCode1));
		}
		if (FCode.equalsIgnoreCase("RCCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RCCode1));
		}
		if (FCode.equalsIgnoreCase("RFCode1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RFCode1));
		}
		if (FCode.equalsIgnoreCase("AssessMonth1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AssessMonth1));
		}
		if (FCode.equalsIgnoreCase("WageMonth1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageMonth1));
		}
		if (FCode.equalsIgnoreCase("SplitRate2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SplitRate2));
		}
		if (FCode.equalsIgnoreCase("Agentcode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Agentcode2));
		}
		if (FCode.equalsIgnoreCase("UMCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UMCode2));
		}
		if (FCode.equalsIgnoreCase("UnitCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UnitCode2));
		}
		if (FCode.equalsIgnoreCase("DMCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DMCode2));
		}
		if (FCode.equalsIgnoreCase("DivisionCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DivisionCode2));
		}
		if (FCode.equalsIgnoreCase("RMCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RMCode2));
		}
		if (FCode.equalsIgnoreCase("RegionCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegionCode2));
		}
		if (FCode.equalsIgnoreCase("DRCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DRCode2));
		}
		if (FCode.equalsIgnoreCase("IDRCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDRCode2));
		}
		if (FCode.equalsIgnoreCase("RCCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RCCode2));
		}
		if (FCode.equalsIgnoreCase("RFCode2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RFCode2));
		}
		if (FCode.equalsIgnoreCase("AssessMonth2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AssessMonth2));
		}
		if (FCode.equalsIgnoreCase("WageMonth2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageMonth2));
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
				strFieldValue = StrTool.GBKToUnicode(AFYCSN);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(CompanyCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(MainPolNo);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ProductCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(RiskCode);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCvaliDate()));
				break;
			case 6:
				strFieldValue = String.valueOf(AFYC);
				break;
			case 7:
				strFieldValue = String.valueOf(AFYP);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(TrxCode);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCalculationDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBusinessDate()));
				break;
			case 11:
				strFieldValue = String.valueOf(BatchNo);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBatchDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getCalDate()));
				break;
			case 14:
				strFieldValue = String.valueOf(SplitRate1);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Agentcode1);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(UMCode1);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(UnitCode1);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(DMCode1);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(DivisionCode1);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(RMCode1);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(RegionCode1);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(DRCode1);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(IDRCode1);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(RCCode1);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(RFCode1);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(AssessMonth1);
				break;
			case 27:
				strFieldValue = StrTool.GBKToUnicode(WageMonth1);
				break;
			case 28:
				strFieldValue = String.valueOf(SplitRate2);
				break;
			case 29:
				strFieldValue = StrTool.GBKToUnicode(Agentcode2);
				break;
			case 30:
				strFieldValue = StrTool.GBKToUnicode(UMCode2);
				break;
			case 31:
				strFieldValue = StrTool.GBKToUnicode(UnitCode2);
				break;
			case 32:
				strFieldValue = StrTool.GBKToUnicode(DMCode2);
				break;
			case 33:
				strFieldValue = StrTool.GBKToUnicode(DivisionCode2);
				break;
			case 34:
				strFieldValue = StrTool.GBKToUnicode(RMCode2);
				break;
			case 35:
				strFieldValue = StrTool.GBKToUnicode(RegionCode2);
				break;
			case 36:
				strFieldValue = StrTool.GBKToUnicode(DRCode2);
				break;
			case 37:
				strFieldValue = StrTool.GBKToUnicode(IDRCode2);
				break;
			case 38:
				strFieldValue = StrTool.GBKToUnicode(RCCode2);
				break;
			case 39:
				strFieldValue = StrTool.GBKToUnicode(RFCode2);
				break;
			case 40:
				strFieldValue = StrTool.GBKToUnicode(AssessMonth2);
				break;
			case 41:
				strFieldValue = StrTool.GBKToUnicode(WageMonth2);
				break;
			case 42:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 43:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 44:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 45:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 46:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 47:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 48:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 49:
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

		if (FCode.equalsIgnoreCase("AFYCSN"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AFYCSN = FValue.trim();
			}
			else
				AFYCSN = null;
		}
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
		if (FCode.equalsIgnoreCase("RiskCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskCode = FValue.trim();
			}
			else
				RiskCode = null;
		}
		if (FCode.equalsIgnoreCase("CvaliDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				CvaliDate = fDate.getDate( FValue );
			}
			else
				CvaliDate = null;
		}
		if (FCode.equalsIgnoreCase("AFYC"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				AFYC = d;
			}
		}
		if (FCode.equalsIgnoreCase("AFYP"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				AFYP = d;
			}
		}
		if (FCode.equalsIgnoreCase("TrxCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TrxCode = FValue.trim();
			}
			else
				TrxCode = null;
		}
		if (FCode.equalsIgnoreCase("CalculationDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				CalculationDate = fDate.getDate( FValue );
			}
			else
				CalculationDate = null;
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
		if (FCode.equalsIgnoreCase("CalDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				CalDate = fDate.getDate( FValue );
			}
			else
				CalDate = null;
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
		if (FCode.equalsIgnoreCase("Agentcode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Agentcode1 = FValue.trim();
			}
			else
				Agentcode1 = null;
		}
		if (FCode.equalsIgnoreCase("UMCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UMCode1 = FValue.trim();
			}
			else
				UMCode1 = null;
		}
		if (FCode.equalsIgnoreCase("UnitCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UnitCode1 = FValue.trim();
			}
			else
				UnitCode1 = null;
		}
		if (FCode.equalsIgnoreCase("DMCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DMCode1 = FValue.trim();
			}
			else
				DMCode1 = null;
		}
		if (FCode.equalsIgnoreCase("DivisionCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DivisionCode1 = FValue.trim();
			}
			else
				DivisionCode1 = null;
		}
		if (FCode.equalsIgnoreCase("RMCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RMCode1 = FValue.trim();
			}
			else
				RMCode1 = null;
		}
		if (FCode.equalsIgnoreCase("RegionCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegionCode1 = FValue.trim();
			}
			else
				RegionCode1 = null;
		}
		if (FCode.equalsIgnoreCase("DRCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DRCode1 = FValue.trim();
			}
			else
				DRCode1 = null;
		}
		if (FCode.equalsIgnoreCase("IDRCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDRCode1 = FValue.trim();
			}
			else
				IDRCode1 = null;
		}
		if (FCode.equalsIgnoreCase("RCCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RCCode1 = FValue.trim();
			}
			else
				RCCode1 = null;
		}
		if (FCode.equalsIgnoreCase("RFCode1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RFCode1 = FValue.trim();
			}
			else
				RFCode1 = null;
		}
		if (FCode.equalsIgnoreCase("AssessMonth1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AssessMonth1 = FValue.trim();
			}
			else
				AssessMonth1 = null;
		}
		if (FCode.equalsIgnoreCase("WageMonth1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageMonth1 = FValue.trim();
			}
			else
				WageMonth1 = null;
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
		if (FCode.equalsIgnoreCase("Agentcode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Agentcode2 = FValue.trim();
			}
			else
				Agentcode2 = null;
		}
		if (FCode.equalsIgnoreCase("UMCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UMCode2 = FValue.trim();
			}
			else
				UMCode2 = null;
		}
		if (FCode.equalsIgnoreCase("UnitCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UnitCode2 = FValue.trim();
			}
			else
				UnitCode2 = null;
		}
		if (FCode.equalsIgnoreCase("DMCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DMCode2 = FValue.trim();
			}
			else
				DMCode2 = null;
		}
		if (FCode.equalsIgnoreCase("DivisionCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DivisionCode2 = FValue.trim();
			}
			else
				DivisionCode2 = null;
		}
		if (FCode.equalsIgnoreCase("RMCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RMCode2 = FValue.trim();
			}
			else
				RMCode2 = null;
		}
		if (FCode.equalsIgnoreCase("RegionCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegionCode2 = FValue.trim();
			}
			else
				RegionCode2 = null;
		}
		if (FCode.equalsIgnoreCase("DRCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DRCode2 = FValue.trim();
			}
			else
				DRCode2 = null;
		}
		if (FCode.equalsIgnoreCase("IDRCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDRCode2 = FValue.trim();
			}
			else
				IDRCode2 = null;
		}
		if (FCode.equalsIgnoreCase("RCCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RCCode2 = FValue.trim();
			}
			else
				RCCode2 = null;
		}
		if (FCode.equalsIgnoreCase("RFCode2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RFCode2 = FValue.trim();
			}
			else
				RFCode2 = null;
		}
		if (FCode.equalsIgnoreCase("AssessMonth2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AssessMonth2 = FValue.trim();
			}
			else
				AssessMonth2 = null;
		}
		if (FCode.equalsIgnoreCase("WageMonth2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageMonth2 = FValue.trim();
			}
			else
				WageMonth2 = null;
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
		LAAFYCBSchema other = (LAAFYCBSchema)otherObject;
		return
			AFYCSN.equals(other.getAFYCSN())
			&& CompanyCode.equals(other.getCompanyCode())
			&& MainPolNo.equals(other.getMainPolNo())
			&& ProductCode.equals(other.getProductCode())
			&& RiskCode.equals(other.getRiskCode())
			&& fDate.getString(CvaliDate).equals(other.getCvaliDate())
			&& AFYC == other.getAFYC()
			&& AFYP == other.getAFYP()
			&& TrxCode.equals(other.getTrxCode())
			&& fDate.getString(CalculationDate).equals(other.getCalculationDate())
			&& fDate.getString(BusinessDate).equals(other.getBusinessDate())
			&& BatchNo == other.getBatchNo()
			&& fDate.getString(BatchDate).equals(other.getBatchDate())
			&& fDate.getString(CalDate).equals(other.getCalDate())
			&& SplitRate1 == other.getSplitRate1()
			&& Agentcode1.equals(other.getAgentcode1())
			&& UMCode1.equals(other.getUMCode1())
			&& UnitCode1.equals(other.getUnitCode1())
			&& DMCode1.equals(other.getDMCode1())
			&& DivisionCode1.equals(other.getDivisionCode1())
			&& RMCode1.equals(other.getRMCode1())
			&& RegionCode1.equals(other.getRegionCode1())
			&& DRCode1.equals(other.getDRCode1())
			&& IDRCode1.equals(other.getIDRCode1())
			&& RCCode1.equals(other.getRCCode1())
			&& RFCode1.equals(other.getRFCode1())
			&& AssessMonth1.equals(other.getAssessMonth1())
			&& WageMonth1.equals(other.getWageMonth1())
			&& SplitRate2 == other.getSplitRate2()
			&& Agentcode2.equals(other.getAgentcode2())
			&& UMCode2.equals(other.getUMCode2())
			&& UnitCode2.equals(other.getUnitCode2())
			&& DMCode2.equals(other.getDMCode2())
			&& DivisionCode2.equals(other.getDivisionCode2())
			&& RMCode2.equals(other.getRMCode2())
			&& RegionCode2.equals(other.getRegionCode2())
			&& DRCode2.equals(other.getDRCode2())
			&& IDRCode2.equals(other.getIDRCode2())
			&& RCCode2.equals(other.getRCCode2())
			&& RFCode2.equals(other.getRFCode2())
			&& AssessMonth2.equals(other.getAssessMonth2())
			&& WageMonth2.equals(other.getWageMonth2())
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
		if( strFieldName.equals("AFYCSN") ) {
			return 0;
		}
		if( strFieldName.equals("CompanyCode") ) {
			return 1;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return 2;
		}
		if( strFieldName.equals("ProductCode") ) {
			return 3;
		}
		if( strFieldName.equals("RiskCode") ) {
			return 4;
		}
		if( strFieldName.equals("CvaliDate") ) {
			return 5;
		}
		if( strFieldName.equals("AFYC") ) {
			return 6;
		}
		if( strFieldName.equals("AFYP") ) {
			return 7;
		}
		if( strFieldName.equals("TrxCode") ) {
			return 8;
		}
		if( strFieldName.equals("CalculationDate") ) {
			return 9;
		}
		if( strFieldName.equals("BusinessDate") ) {
			return 10;
		}
		if( strFieldName.equals("BatchNo") ) {
			return 11;
		}
		if( strFieldName.equals("BatchDate") ) {
			return 12;
		}
		if( strFieldName.equals("CalDate") ) {
			return 13;
		}
		if( strFieldName.equals("SplitRate1") ) {
			return 14;
		}
		if( strFieldName.equals("Agentcode1") ) {
			return 15;
		}
		if( strFieldName.equals("UMCode1") ) {
			return 16;
		}
		if( strFieldName.equals("UnitCode1") ) {
			return 17;
		}
		if( strFieldName.equals("DMCode1") ) {
			return 18;
		}
		if( strFieldName.equals("DivisionCode1") ) {
			return 19;
		}
		if( strFieldName.equals("RMCode1") ) {
			return 20;
		}
		if( strFieldName.equals("RegionCode1") ) {
			return 21;
		}
		if( strFieldName.equals("DRCode1") ) {
			return 22;
		}
		if( strFieldName.equals("IDRCode1") ) {
			return 23;
		}
		if( strFieldName.equals("RCCode1") ) {
			return 24;
		}
		if( strFieldName.equals("RFCode1") ) {
			return 25;
		}
		if( strFieldName.equals("AssessMonth1") ) {
			return 26;
		}
		if( strFieldName.equals("WageMonth1") ) {
			return 27;
		}
		if( strFieldName.equals("SplitRate2") ) {
			return 28;
		}
		if( strFieldName.equals("Agentcode2") ) {
			return 29;
		}
		if( strFieldName.equals("UMCode2") ) {
			return 30;
		}
		if( strFieldName.equals("UnitCode2") ) {
			return 31;
		}
		if( strFieldName.equals("DMCode2") ) {
			return 32;
		}
		if( strFieldName.equals("DivisionCode2") ) {
			return 33;
		}
		if( strFieldName.equals("RMCode2") ) {
			return 34;
		}
		if( strFieldName.equals("RegionCode2") ) {
			return 35;
		}
		if( strFieldName.equals("DRCode2") ) {
			return 36;
		}
		if( strFieldName.equals("IDRCode2") ) {
			return 37;
		}
		if( strFieldName.equals("RCCode2") ) {
			return 38;
		}
		if( strFieldName.equals("RFCode2") ) {
			return 39;
		}
		if( strFieldName.equals("AssessMonth2") ) {
			return 40;
		}
		if( strFieldName.equals("WageMonth2") ) {
			return 41;
		}
		if( strFieldName.equals("Operator") ) {
			return 42;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 43;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 44;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 45;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 46;
		}
		if( strFieldName.equals("Operator1") ) {
			return 47;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 48;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 49;
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
				strFieldName = "AFYCSN";
				break;
			case 1:
				strFieldName = "CompanyCode";
				break;
			case 2:
				strFieldName = "MainPolNo";
				break;
			case 3:
				strFieldName = "ProductCode";
				break;
			case 4:
				strFieldName = "RiskCode";
				break;
			case 5:
				strFieldName = "CvaliDate";
				break;
			case 6:
				strFieldName = "AFYC";
				break;
			case 7:
				strFieldName = "AFYP";
				break;
			case 8:
				strFieldName = "TrxCode";
				break;
			case 9:
				strFieldName = "CalculationDate";
				break;
			case 10:
				strFieldName = "BusinessDate";
				break;
			case 11:
				strFieldName = "BatchNo";
				break;
			case 12:
				strFieldName = "BatchDate";
				break;
			case 13:
				strFieldName = "CalDate";
				break;
			case 14:
				strFieldName = "SplitRate1";
				break;
			case 15:
				strFieldName = "Agentcode1";
				break;
			case 16:
				strFieldName = "UMCode1";
				break;
			case 17:
				strFieldName = "UnitCode1";
				break;
			case 18:
				strFieldName = "DMCode1";
				break;
			case 19:
				strFieldName = "DivisionCode1";
				break;
			case 20:
				strFieldName = "RMCode1";
				break;
			case 21:
				strFieldName = "RegionCode1";
				break;
			case 22:
				strFieldName = "DRCode1";
				break;
			case 23:
				strFieldName = "IDRCode1";
				break;
			case 24:
				strFieldName = "RCCode1";
				break;
			case 25:
				strFieldName = "RFCode1";
				break;
			case 26:
				strFieldName = "AssessMonth1";
				break;
			case 27:
				strFieldName = "WageMonth1";
				break;
			case 28:
				strFieldName = "SplitRate2";
				break;
			case 29:
				strFieldName = "Agentcode2";
				break;
			case 30:
				strFieldName = "UMCode2";
				break;
			case 31:
				strFieldName = "UnitCode2";
				break;
			case 32:
				strFieldName = "DMCode2";
				break;
			case 33:
				strFieldName = "DivisionCode2";
				break;
			case 34:
				strFieldName = "RMCode2";
				break;
			case 35:
				strFieldName = "RegionCode2";
				break;
			case 36:
				strFieldName = "DRCode2";
				break;
			case 37:
				strFieldName = "IDRCode2";
				break;
			case 38:
				strFieldName = "RCCode2";
				break;
			case 39:
				strFieldName = "RFCode2";
				break;
			case 40:
				strFieldName = "AssessMonth2";
				break;
			case 41:
				strFieldName = "WageMonth2";
				break;
			case 42:
				strFieldName = "Operator";
				break;
			case 43:
				strFieldName = "MakeDate";
				break;
			case 44:
				strFieldName = "MakeTime";
				break;
			case 45:
				strFieldName = "ModifyDate";
				break;
			case 46:
				strFieldName = "ModifyTime";
				break;
			case 47:
				strFieldName = "Operator1";
				break;
			case 48:
				strFieldName = "MakeDate1";
				break;
			case 49:
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
		if( strFieldName.equals("AFYCSN") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CompanyCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ProductCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CvaliDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("AFYC") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("AFYP") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("TrxCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalculationDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BusinessDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BatchNo") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("BatchDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("CalDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("SplitRate1") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Agentcode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UMCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UnitCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DMCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DivisionCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RMCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RegionCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DRCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IDRCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RCCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RFCode1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AssessMonth1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageMonth1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SplitRate2") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("Agentcode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UMCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UnitCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DMCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DivisionCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RMCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RegionCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DRCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IDRCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RCCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RFCode2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AssessMonth2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageMonth2") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 10:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 11:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 12:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 13:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 14:
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 28:
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 33:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 34:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 35:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 36:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 37:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 38:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 39:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 40:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 41:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 42:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 43:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 44:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 45:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 46:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 47:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 48:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 49:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
