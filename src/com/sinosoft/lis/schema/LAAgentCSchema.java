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
import com.sinosoft.lis.db.LAAgentCDB;

/*
 * <p>ClassName: LAAgentCSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LAAgentCd
 */
public class LAAgentCSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentCSchema.class);
	// @Field
	/** Bakmonth */
	private String BakMonth;
	/** Baktype */
	private String BakType;
	/** Laagent【agentcode】 */
	private String AgentCode;
	/** Laagent【branchtype】 */
	private String BranchType;
	/** Laagent【agentgroup】 */
	private String AgentGroup;
	/** Laagent【managecom】 */
	private String ManageCom;
	/** Laagent【password】 */
	private String Password;
	/** Laagent【agentstate】 */
	private String AgentState;
	/** Laagent【surname】 */
	private String SurName;
	/** Laagent【givenname】 */
	private String GivenName;
	/** Laagent【englishname】 */
	private String EnglishName;
	/** Laagent【hkidname】 */
	private String HKIDName;
	/** Laagent【chinesename】 */
	private String ChineseName;
	/** Laagent【idtype】 */
	private String IDType;
	/** Laagent【idno】 */
	private String IDNo;
	/** Laagent【workingvisa】 */
	private String WorkingVisa;
	/** Laagent【workingvisaexpirydate】 */
	private Date WorkingVisaExpiryDate;
	/** Laagent【workingvisatype】 */
	private String WorkingVisaType;
	/** Laagent【qualification】 */
	private String Qualification;
	/** Laagent【contracttype】 */
	private String ContractType;
	/** Laagent【contracteffdate】 */
	private Date ContractEffDate;
	/** Laagent【contractstatus】 */
	private String ContractStatus;
	/** Laagent【recruitmentprofile】 */
	private String RecruitmentProfile;
	/** Laagent【lastterminationdate】 */
	private Date LastTerminationDate;
	/** Laagent【lastterminationreason】 */
	private String LastTerminationReason;
	/** Laagent【terminationno】 */
	private int TerminationNo;
	/** Laagent【paymentmethod】 */
	private String PaymentMethod;
	/** Laagent【bankaccountname】 */
	private String BankAccountName;
	/** Laagent【bankaccountno】 */
	private String BankAccountNo;
	/** Laagent【withheldreason】 */
	private String WithheldReason;
	/** Laagent【guarantoragentcode】 */
	private String GuarantorAgentCode;
	/** Laagent【guarantoragentrelation】 */
	private String GuarantorAgentRelation;
	/** Laagent【guarantortype】 */
	private String GuarantorType;
	/** Laagent【sex】 */
	private String Sex;
	/** Laagent【title】 */
	private String Title;
	/** Laagent【nationality】 */
	private String Nationality;
	/** Laagent【birthday】 */
	private Date Birthday;
	/** Laagent【workingexperience】 */
	private int WorkingExperience;
	/** Laagent【lastjob】 */
	private String LastJob;
	/** Laagent【lastjobserviceyears】 */
	private int LastJobServiceYears;
	/** Laagent【insuranceexperience】 */
	private String InsuranceExperience;
	/** Laagent【insuranceexperienceyears】 */
	private int InsuranceExperienceYears;
	/** Laagent【educationlevel】 */
	private String EducationLevel;
	/** Laagent【addresstype】 */
	private String AddressType;
	/** Laagent【addressroom】 */
	private String AddressRoom;
	/** Laagent【addressfloor】 */
	private String AddressFloor;
	/** Laagent【addressblock】 */
	private String AddressBlock;
	/** Laagent【addressbuilding】 */
	private String AddressBuilding;
	/** Laagent【addressstreet】 */
	private String AddressStreet;
	/** Laagent【addressdistrict】 */
	private String AddressDistrict;
	/** Laagent【freeaddress】 */
	private String FreeAddress;
	/** Laagent【phone】 */
	private String Phone;
	/** Laagent【mobile】 */
	private String Mobile;
	/** Laagent【email】 */
	private String Email;
	/** Laagent【companyemail】 */
	private String CompanyEmail;
	/** Laagent【officeaddress】 */
	private String OfficeAddress;
	/** Laagent【officetel】 */
	private String OfficeTel;
	/** Laagent【officefaxno】 */
	private String OfficeFaxNo;
	/** Laagent【marriage】 */
	private String Marriage;
	/** Laagent【spousename】 */
	private String SpouseName;
	/** Laagent【spouseidno】 */
	private String SpouseIDNo;
	/** Laagent【flag1】 */
	private String Flag1;
	/** Laagent【flag2】 */
	private String Flag2;
	/** Laagent【flag3】 */
	private String Flag3;
	/** Latree【agentgrade】 */
	private String AgentGrade;
	/** Latree【gradestartdate】 */
	private Date GradeStartDate;
	/** Latree【agentsubgrade】 */
	private String AgentSubGrade;
	/** Latree【subgradestartdate】 */
	private Date SubGradeStartDate;
	/** Latree【effectivedate】 */
	private Date EffectiveDate;
	/** Latree【transfereffectivedate】 */
	private Date TransferEffectiveDate;
	/** Labranchgroup【branchattr】 */
	private String BranchAttr;
	/** Labranchgroup【branchlevel】 */
	private String BranchLevel;
	/** Labranchgroup【branchname】 */
	private String BranchName;
	/** Labranchgroup【branchnameeng】 */
	private String BranchNameEng;
	/** Labranchgroup【branchnamechi】 */
	private String BranchNameChi;
	/** Labranchgroup【brancheffdate】 */
	private Date BranchEffDate;
	/** Labranchgroup【branchaddress】 */
	private String BranchAddress;
	/** Labranchgroup【branchphoneno】 */
	private String BranchPhoneNo;
	/** Labranchgroup【branchfaxno】 */
	private String BranchFaxNo;
	/** Labranchgroup【branchlocation】 */
	private String BranchLocation;
	/** Labranchgroup【branchstatus】 */
	private String BranchStatus;
	/** Labranchgroup【branchterminateeffdate】 */
	private Date BranchTerminateEffDate;
	/** Labranchgroup【branchterminatereason】 */
	private String BranchTerminateReason;
	/** Labranchgroup【directflag】 */
	private String DirectFlag;
	/** Labranchgroup【upagentgroup】 */
	private String UpAgentGroup;
	/** Labranchgroup【branchmanager】 */
	private String BranchManager;
	/** Unit主管编码 */
	private String UnitManager;
	/** Division主管编码 */
	private String DivisionManager;
	/** Region主管编码 */
	private String RegionManager;
	/** 招募人编码 */
	private String RecruitingAgentCode;
	/** 推荐人编码 */
	private String ReferringAgentCode;
	/** 直接汇报人编码 */
	private String DirectReportingAgentCode;
	/** 间接汇报人编码 */
	private String InirectReportingAgentCode;
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
	/** Lastjobnature */
	private String LastJobNature;
	/** Unitbranchattr */
	private String UnitBranchAttr;
	/** Divisionbranchattr */
	private String DivisionBranchAttr;
	/** Regionbranchattr */
	private String RegionBranchAttr;
	/** Outworkdate */
	private Date OutWorkDate;
	/** Dummygradeflag */
	private String DummyGradeFlag;

	public static final int FIELDNUM = 104;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentCSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[3];
		pk[0] = "BakMonth";
		pk[1] = "BakType";
		pk[2] = "AgentCode";

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
		LAAgentCSchema cloned = (LAAgentCSchema)super.clone();
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
	* BakMonth
	*/
	public String getBakMonth()
	{
		return BakMonth;
	}
	public void setBakMonth(String aBakMonth)
	{
		if(aBakMonth!=null && aBakMonth.length()>6)
			throw new IllegalArgumentException("BakmonthBakMonth值"+aBakMonth+"的长度"+aBakMonth.length()+"大于最大值6");
		BakMonth = aBakMonth;
	}
	/**
	* BakType
	*/
	public String getBakType()
	{
		return BakType;
	}
	public void setBakType(String aBakType)
	{
		if(aBakType!=null && aBakType.length()>2)
			throw new IllegalArgumentException("BaktypeBakType值"+aBakType+"的长度"+aBakType.length()+"大于最大值2");
		BakType = aBakType;
	}
	/**
	* LAAgent【AgentCode】【Agent Code】
	*/
	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>12)
			throw new IllegalArgumentException("Laagent【agentcode】AgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值12");
		AgentCode = aAgentCode;
	}
	/**
	* LAAgent【BranchType】
	*/
	public String getBranchType()
	{
		return BranchType;
	}
	public void setBranchType(String aBranchType)
	{
		if(aBranchType!=null && aBranchType.length()>2)
			throw new IllegalArgumentException("Laagent【branchtype】BranchType值"+aBranchType+"的长度"+aBranchType.length()+"大于最大值2");
		BranchType = aBranchType;
	}
	/**
	* LAAgent【AgentGroup】
	*/
	public String getAgentGroup()
	{
		return AgentGroup;
	}
	public void setAgentGroup(String aAgentGroup)
	{
		if(aAgentGroup!=null && aAgentGroup.length()>20)
			throw new IllegalArgumentException("Laagent【agentgroup】AgentGroup值"+aAgentGroup+"的长度"+aAgentGroup.length()+"大于最大值20");
		AgentGroup = aAgentGroup;
	}
	/**
	* LAAgent【ManageCom】
	*/
	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>10)
			throw new IllegalArgumentException("Laagent【managecom】ManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值10");
		ManageCom = aManageCom;
	}
	/**
	* LAAgent【Password】
	*/
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String aPassword)
	{
		if(aPassword!=null && aPassword.length()>40)
			throw new IllegalArgumentException("Laagent【password】Password值"+aPassword+"的长度"+aPassword.length()+"大于最大值40");
		Password = aPassword;
	}
	/**
	* LAAgent【AgentState】
	*/
	public String getAgentState()
	{
		return AgentState;
	}
	public void setAgentState(String aAgentState)
	{
		if(aAgentState!=null && aAgentState.length()>2)
			throw new IllegalArgumentException("Laagent【agentstate】AgentState值"+aAgentState+"的长度"+aAgentState.length()+"大于最大值2");
		AgentState = aAgentState;
	}
	/**
	* LAAgent【SurName】【Agent Surname】
	*/
	public String getSurName()
	{
		return SurName;
	}
	public void setSurName(String aSurName)
	{
		if(aSurName!=null && aSurName.length()>20)
			throw new IllegalArgumentException("Laagent【surname】SurName值"+aSurName+"的长度"+aSurName.length()+"大于最大值20");
		SurName = aSurName;
	}
	/**
	* LAAgent【GivenName】【Agent Given Name】
	*/
	public String getGivenName()
	{
		return GivenName;
	}
	public void setGivenName(String aGivenName)
	{
		if(aGivenName!=null && aGivenName.length()>50)
			throw new IllegalArgumentException("Laagent【givenname】GivenName值"+aGivenName+"的长度"+aGivenName.length()+"大于最大值50");
		GivenName = aGivenName;
	}
	/**
	* LAAgent【EnglishName】【Agent English Name】
	*/
	public String getEnglishName()
	{
		return EnglishName;
	}
	public void setEnglishName(String aEnglishName)
	{
		if(aEnglishName!=null && aEnglishName.length()>30)
			throw new IllegalArgumentException("Laagent【englishname】EnglishName值"+aEnglishName+"的长度"+aEnglishName.length()+"大于最大值30");
		EnglishName = aEnglishName;
	}
	/**
	* LAAgent【HKIDName】【Agent HKID Name】
	*/
	public String getHKIDName()
	{
		return HKIDName;
	}
	public void setHKIDName(String aHKIDName)
	{
		if(aHKIDName!=null && aHKIDName.length()>40)
			throw new IllegalArgumentException("Laagent【hkidname】HKIDName值"+aHKIDName+"的长度"+aHKIDName.length()+"大于最大值40");
		HKIDName = aHKIDName;
	}
	/**
	* LAAgent【ChineseName】【Agent Chinese Name】
	*/
	public String getChineseName()
	{
		return ChineseName;
	}
	public void setChineseName(String aChineseName)
	{
		if(aChineseName!=null && aChineseName.length()>20)
			throw new IllegalArgumentException("Laagent【chinesename】ChineseName值"+aChineseName+"的长度"+aChineseName.length()+"大于最大值20");
		ChineseName = aChineseName;
	}
	/**
	* LAAgent【IDType】【默认HKID】
	*/
	public String getIDType()
	{
		return IDType;
	}
	public void setIDType(String aIDType)
	{
		if(aIDType!=null && aIDType.length()>1)
			throw new IllegalArgumentException("Laagent【idtype】IDType值"+aIDType+"的长度"+aIDType.length()+"大于最大值1");
		IDType = aIDType;
	}
	/**
	* LAAgent【IDNo】【HKID Card No】
	*/
	public String getIDNo()
	{
		return IDNo;
	}
	public void setIDNo(String aIDNo)
	{
		if(aIDNo!=null && aIDNo.length()>20)
			throw new IllegalArgumentException("Laagent【idno】IDNo值"+aIDNo+"的长度"+aIDNo.length()+"大于最大值20");
		IDNo = aIDNo;
	}
	/**
	* LAAgent【WorkingVisa】【Yes/No】
	*/
	public String getWorkingVisa()
	{
		return WorkingVisa;
	}
	public void setWorkingVisa(String aWorkingVisa)
	{
		if(aWorkingVisa!=null && aWorkingVisa.length()>1)
			throw new IllegalArgumentException("Laagent【workingvisa】WorkingVisa值"+aWorkingVisa+"的长度"+aWorkingVisa.length()+"大于最大值1");
		WorkingVisa = aWorkingVisa;
	}
	/**
	* LAAgent【WorkingVisaExpiryDate】【WorkingVisa是Y的时候，Date不可为空，>=当前日期】
	*/
	public String getWorkingVisaExpiryDate()
	{
		if( WorkingVisaExpiryDate != null )
			return fDate.getString(WorkingVisaExpiryDate);
		else
			return null;
	}
	public void setWorkingVisaExpiryDate(Date aWorkingVisaExpiryDate)
	{
		WorkingVisaExpiryDate = aWorkingVisaExpiryDate;
	}
	public void setWorkingVisaExpiryDate(String aWorkingVisaExpiryDate)
	{
		if (aWorkingVisaExpiryDate != null && !aWorkingVisaExpiryDate.equals("") )
		{
			WorkingVisaExpiryDate = fDate.getDate( aWorkingVisaExpiryDate );
		}
		else
			WorkingVisaExpiryDate = null;
	}

	/**
	* LAAgent【WorkingVisaType】【Working Visa Type】
	*/
	public String getWorkingVisaType()
	{
		return WorkingVisaType;
	}
	public void setWorkingVisaType(String aWorkingVisaType)
	{
		if(aWorkingVisaType!=null && aWorkingVisaType.length()>20)
			throw new IllegalArgumentException("Laagent【workingvisatype】WorkingVisaType值"+aWorkingVisaType+"的长度"+aWorkingVisaType.length()+"大于最大值20");
		WorkingVisaType = aWorkingVisaType;
	}
	/**
	* LAAgent【Qualification】【Qualification】
	*/
	public String getQualification()
	{
		return Qualification;
	}
	public void setQualification(String aQualification)
	{
		if(aQualification!=null && aQualification.length()>50)
			throw new IllegalArgumentException("Laagent【qualification】Qualification值"+aQualification+"的长度"+aQualification.length()+"大于最大值50");
		Qualification = aQualification;
	}
	/**
	* LAAgent【ContractType】【Contract Type】
	*/
	public String getContractType()
	{
		return ContractType;
	}
	public void setContractType(String aContractType)
	{
		if(aContractType!=null && aContractType.length()>2)
			throw new IllegalArgumentException("Laagent【contracttype】ContractType值"+aContractType+"的长度"+aContractType.length()+"大于最大值2");
		ContractType = aContractType;
	}
	/**
	* LAAgent【ContractEffDate】【Contract Effective Date】
	*/
	public String getContractEffDate()
	{
		if( ContractEffDate != null )
			return fDate.getString(ContractEffDate);
		else
			return null;
	}
	public void setContractEffDate(Date aContractEffDate)
	{
		ContractEffDate = aContractEffDate;
	}
	public void setContractEffDate(String aContractEffDate)
	{
		if (aContractEffDate != null && !aContractEffDate.equals("") )
		{
			ContractEffDate = fDate.getDate( aContractEffDate );
		}
		else
			ContractEffDate = null;
	}

	/**
	* LAAgent【ContractStatus】【Status】
	*/
	public String getContractStatus()
	{
		return ContractStatus;
	}
	public void setContractStatus(String aContractStatus)
	{
		if(aContractStatus!=null && aContractStatus.length()>2)
			throw new IllegalArgumentException("Laagent【contractstatus】ContractStatus值"+aContractStatus+"的长度"+aContractStatus.length()+"大于最大值2");
		ContractStatus = aContractStatus;
	}
	/**
	* LAAgent【RecruitmentProfile】【Recruitment Profile】
	*/
	public String getRecruitmentProfile()
	{
		return RecruitmentProfile;
	}
	public void setRecruitmentProfile(String aRecruitmentProfile)
	{
		if(aRecruitmentProfile!=null && aRecruitmentProfile.length()>2)
			throw new IllegalArgumentException("Laagent【recruitmentprofile】RecruitmentProfile值"+aRecruitmentProfile+"的长度"+aRecruitmentProfile.length()+"大于最大值2");
		RecruitmentProfile = aRecruitmentProfile;
	}
	/**
	* LAAgent【LastTerminationDate】【Last Termination Date】
	*/
	public String getLastTerminationDate()
	{
		if( LastTerminationDate != null )
			return fDate.getString(LastTerminationDate);
		else
			return null;
	}
	public void setLastTerminationDate(Date aLastTerminationDate)
	{
		LastTerminationDate = aLastTerminationDate;
	}
	public void setLastTerminationDate(String aLastTerminationDate)
	{
		if (aLastTerminationDate != null && !aLastTerminationDate.equals("") )
		{
			LastTerminationDate = fDate.getDate( aLastTerminationDate );
		}
		else
			LastTerminationDate = null;
	}

	/**
	* LAAgent【LastTerminationReason】【Last Termination Reason：离职功能中选的原因】
	*/
	public String getLastTerminationReason()
	{
		return LastTerminationReason;
	}
	public void setLastTerminationReason(String aLastTerminationReason)
	{
		if(aLastTerminationReason!=null && aLastTerminationReason.length()>500)
			throw new IllegalArgumentException("Laagent【lastterminationreason】LastTerminationReason值"+aLastTerminationReason+"的长度"+aLastTerminationReason.length()+"大于最大值500");
		LastTerminationReason = aLastTerminationReason;
	}
	/**
	* LAAgent【TerminationNo】【No. of Termination:根据HKID自动计算出来】
	*/
	public int getTerminationNo()
	{
		return TerminationNo;
	}
	public void setTerminationNo(int aTerminationNo)
	{
		TerminationNo = aTerminationNo;
	}
	public void setTerminationNo(String aTerminationNo)
	{
		if (aTerminationNo != null && !aTerminationNo.equals(""))
		{
			Integer tInteger = new Integer(aTerminationNo);
			int i = tInteger.intValue();
			TerminationNo = i;
		}
	}

	/**
	* LAAgent【PaymentMethod】【Payment Method】
	*/
	public String getPaymentMethod()
	{
		return PaymentMethod;
	}
	public void setPaymentMethod(String aPaymentMethod)
	{
		if(aPaymentMethod!=null && aPaymentMethod.length()>2)
			throw new IllegalArgumentException("Laagent【paymentmethod】PaymentMethod值"+aPaymentMethod+"的长度"+aPaymentMethod.length()+"大于最大值2");
		PaymentMethod = aPaymentMethod;
	}
	/**
	* LAAgent【BankAccountName】【Payment Method是AutoPay的时候，该项必须有值】
	*/
	public String getBankAccountName()
	{
		return BankAccountName;
	}
	public void setBankAccountName(String aBankAccountName)
	{
		if(aBankAccountName!=null && aBankAccountName.length()>50)
			throw new IllegalArgumentException("Laagent【bankaccountname】BankAccountName值"+aBankAccountName+"的长度"+aBankAccountName.length()+"大于最大值50");
		BankAccountName = aBankAccountName;
	}
	/**
	* LAAgent【BankAccountNo】【Payment Method是AutoPay的时候，该项必须有值】
	*/
	public String getBankAccountNo()
	{
		return BankAccountNo;
	}
	public void setBankAccountNo(String aBankAccountNo)
	{
		if(aBankAccountNo!=null && aBankAccountNo.length()>50)
			throw new IllegalArgumentException("Laagent【bankaccountno】BankAccountNo值"+aBankAccountNo+"的长度"+aBankAccountNo.length()+"大于最大值50");
		BankAccountNo = aBankAccountNo;
	}
	/**
	* LAAgent【WithheldReason】【Withheld Reason】
	*/
	public String getWithheldReason()
	{
		return WithheldReason;
	}
	public void setWithheldReason(String aWithheldReason)
	{
		if(aWithheldReason!=null && aWithheldReason.length()>200)
			throw new IllegalArgumentException("Laagent【withheldreason】WithheldReason值"+aWithheldReason+"的长度"+aWithheldReason.length()+"大于最大值200");
		WithheldReason = aWithheldReason;
	}
	/**
	* LAAgent【GuarantorAgentCode】【Agent Code】
	*/
	public String getGuarantorAgentCode()
	{
		return GuarantorAgentCode;
	}
	public void setGuarantorAgentCode(String aGuarantorAgentCode)
	{
		if(aGuarantorAgentCode!=null && aGuarantorAgentCode.length()>12)
			throw new IllegalArgumentException("Laagent【guarantoragentcode】GuarantorAgentCode值"+aGuarantorAgentCode+"的长度"+aGuarantorAgentCode.length()+"大于最大值12");
		GuarantorAgentCode = aGuarantorAgentCode;
	}
	/**
	* LAAgent【GuarantorAgentRelation】【Relationship】
	*/
	public String getGuarantorAgentRelation()
	{
		return GuarantorAgentRelation;
	}
	public void setGuarantorAgentRelation(String aGuarantorAgentRelation)
	{
		if(aGuarantorAgentRelation!=null && aGuarantorAgentRelation.length()>40)
			throw new IllegalArgumentException("Laagent【guarantoragentrelation】GuarantorAgentRelation值"+aGuarantorAgentRelation+"的长度"+aGuarantorAgentRelation.length()+"大于最大值40");
		GuarantorAgentRelation = aGuarantorAgentRelation;
	}
	/**
	* LAAgent【GuarantorType】【Guarantor Type】
	*/
	public String getGuarantorType()
	{
		return GuarantorType;
	}
	public void setGuarantorType(String aGuarantorType)
	{
		if(aGuarantorType!=null && aGuarantorType.length()>40)
			throw new IllegalArgumentException("Laagent【guarantortype】GuarantorType值"+aGuarantorType+"的长度"+aGuarantorType.length()+"大于最大值40");
		GuarantorType = aGuarantorType;
	}
	/**
	* LAAgent【Sex】【Gender】
	*/
	public String getSex()
	{
		return Sex;
	}
	public void setSex(String aSex)
	{
		if(aSex!=null && aSex.length()>1)
			throw new IllegalArgumentException("Laagent【sex】Sex值"+aSex+"的长度"+aSex.length()+"大于最大值1");
		Sex = aSex;
	}
	/**
	* "LAAgent【Title】【Title1-Mr. 2-Mrs.3- Ms.】"
	*/
	public String getTitle()
	{
		return Title;
	}
	public void setTitle(String aTitle)
	{
		if(aTitle!=null && aTitle.length()>2)
			throw new IllegalArgumentException("Laagent【title】Title值"+aTitle+"的长度"+aTitle.length()+"大于最大值2");
		Title = aTitle;
	}
	/**
	* LAAgent【Nationality】【录入，默认Hong Kong，可修改】
	*/
	public String getNationality()
	{
		return Nationality;
	}
	public void setNationality(String aNationality)
	{
		if(aNationality!=null && aNationality.length()>40)
			throw new IllegalArgumentException("Laagent【nationality】Nationality值"+aNationality+"的长度"+aNationality.length()+"大于最大值40");
		Nationality = aNationality;
	}
	/**
	* LAAgent【Birthday】【Date of Birth】
	*/
	public String getBirthday()
	{
		if( Birthday != null )
			return fDate.getString(Birthday);
		else
			return null;
	}
	public void setBirthday(Date aBirthday)
	{
		Birthday = aBirthday;
	}
	public void setBirthday(String aBirthday)
	{
		if (aBirthday != null && !aBirthday.equals("") )
		{
			Birthday = fDate.getDate( aBirthday );
		}
		else
			Birthday = null;
	}

	/**
	* LAAgent【WorkingExperience】【Total Working Experience(Yrs)】
	*/
	public int getWorkingExperience()
	{
		return WorkingExperience;
	}
	public void setWorkingExperience(int aWorkingExperience)
	{
		WorkingExperience = aWorkingExperience;
	}
	public void setWorkingExperience(String aWorkingExperience)
	{
		if (aWorkingExperience != null && !aWorkingExperience.equals(""))
		{
			Integer tInteger = new Integer(aWorkingExperience);
			int i = tInteger.intValue();
			WorkingExperience = i;
		}
	}

	/**
	* LAAgent【LastJob】【Last Job】
	*/
	public String getLastJob()
	{
		return LastJob;
	}
	public void setLastJob(String aLastJob)
	{
		if(aLastJob!=null && aLastJob.length()>2)
			throw new IllegalArgumentException("Laagent【lastjob】LastJob值"+aLastJob+"的长度"+aLastJob.length()+"大于最大值2");
		LastJob = aLastJob;
	}
	/**
	* LAAgent【LastJobServiceYears】【Last Job Years of Service(Yrs)】
	*/
	public int getLastJobServiceYears()
	{
		return LastJobServiceYears;
	}
	public void setLastJobServiceYears(int aLastJobServiceYears)
	{
		LastJobServiceYears = aLastJobServiceYears;
	}
	public void setLastJobServiceYears(String aLastJobServiceYears)
	{
		if (aLastJobServiceYears != null && !aLastJobServiceYears.equals(""))
		{
			Integer tInteger = new Integer(aLastJobServiceYears);
			int i = tInteger.intValue();
			LastJobServiceYears = i;
		}
	}

	/**
	* "LAAgent【InsuranceExperience】【Insurance Experience1-Yes、2-No】"
	*/
	public String getInsuranceExperience()
	{
		return InsuranceExperience;
	}
	public void setInsuranceExperience(String aInsuranceExperience)
	{
		if(aInsuranceExperience!=null && aInsuranceExperience.length()>2)
			throw new IllegalArgumentException("Laagent【insuranceexperience】InsuranceExperience值"+aInsuranceExperience+"的长度"+aInsuranceExperience.length()+"大于最大值2");
		InsuranceExperience = aInsuranceExperience;
	}
	/**
	* LAAgent【InsuranceExperienceYears】【Year of Insurance Experience】
	*/
	public int getInsuranceExperienceYears()
	{
		return InsuranceExperienceYears;
	}
	public void setInsuranceExperienceYears(int aInsuranceExperienceYears)
	{
		InsuranceExperienceYears = aInsuranceExperienceYears;
	}
	public void setInsuranceExperienceYears(String aInsuranceExperienceYears)
	{
		if (aInsuranceExperienceYears != null && !aInsuranceExperienceYears.equals(""))
		{
			Integer tInteger = new Integer(aInsuranceExperienceYears);
			int i = tInteger.intValue();
			InsuranceExperienceYears = i;
		}
	}

	/**
	* LAAgent【EducationLevel】【Education Level】
	*/
	public String getEducationLevel()
	{
		return EducationLevel;
	}
	public void setEducationLevel(String aEducationLevel)
	{
		if(aEducationLevel!=null && aEducationLevel.length()>2)
			throw new IllegalArgumentException("Laagent【educationlevel】EducationLevel值"+aEducationLevel+"的长度"+aEducationLevel.length()+"大于最大值2");
		EducationLevel = aEducationLevel;
	}
	/**
	* LAAgent【AddressType】【下拉选择Standard/Address】
	*/
	public String getAddressType()
	{
		return AddressType;
	}
	public void setAddressType(String aAddressType)
	{
		if(aAddressType!=null && aAddressType.length()>2)
			throw new IllegalArgumentException("Laagent【addresstype】AddressType值"+aAddressType+"的长度"+aAddressType.length()+"大于最大值2");
		AddressType = aAddressType;
	}
	/**
	* LAAgent【AddressRoom】【录入】
	*/
	public String getAddressRoom()
	{
		return AddressRoom;
	}
	public void setAddressRoom(String aAddressRoom)
	{
		if(aAddressRoom!=null && aAddressRoom.length()>50)
			throw new IllegalArgumentException("Laagent【addressroom】AddressRoom值"+aAddressRoom+"的长度"+aAddressRoom.length()+"大于最大值50");
		AddressRoom = aAddressRoom;
	}
	/**
	* LAAgent【AddressFloor】【录入】
	*/
	public String getAddressFloor()
	{
		return AddressFloor;
	}
	public void setAddressFloor(String aAddressFloor)
	{
		if(aAddressFloor!=null && aAddressFloor.length()>50)
			throw new IllegalArgumentException("Laagent【addressfloor】AddressFloor值"+aAddressFloor+"的长度"+aAddressFloor.length()+"大于最大值50");
		AddressFloor = aAddressFloor;
	}
	/**
	* LAAgent【AddressBlock】【录入】
	*/
	public String getAddressBlock()
	{
		return AddressBlock;
	}
	public void setAddressBlock(String aAddressBlock)
	{
		if(aAddressBlock!=null && aAddressBlock.length()>50)
			throw new IllegalArgumentException("Laagent【addressblock】AddressBlock值"+aAddressBlock+"的长度"+aAddressBlock.length()+"大于最大值50");
		AddressBlock = aAddressBlock;
	}
	/**
	* LAAgent【AddressBuilding】【录入】
	*/
	public String getAddressBuilding()
	{
		return AddressBuilding;
	}
	public void setAddressBuilding(String aAddressBuilding)
	{
		if(aAddressBuilding!=null && aAddressBuilding.length()>50)
			throw new IllegalArgumentException("Laagent【addressbuilding】AddressBuilding值"+aAddressBuilding+"的长度"+aAddressBuilding.length()+"大于最大值50");
		AddressBuilding = aAddressBuilding;
	}
	/**
	* LAAgent【AddressStreet】【录入】
	*/
	public String getAddressStreet()
	{
		return AddressStreet;
	}
	public void setAddressStreet(String aAddressStreet)
	{
		if(aAddressStreet!=null && aAddressStreet.length()>50)
			throw new IllegalArgumentException("Laagent【addressstreet】AddressStreet值"+aAddressStreet+"的长度"+aAddressStreet.length()+"大于最大值50");
		AddressStreet = aAddressStreet;
	}
	/**
	* LAAgent【AddressDistrict】【下拉】
	*/
	public String getAddressDistrict()
	{
		return AddressDistrict;
	}
	public void setAddressDistrict(String aAddressDistrict)
	{
		if(aAddressDistrict!=null && aAddressDistrict.length()>2)
			throw new IllegalArgumentException("Laagent【addressdistrict】AddressDistrict值"+aAddressDistrict+"的长度"+aAddressDistrict.length()+"大于最大值2");
		AddressDistrict = aAddressDistrict;
	}
	/**
	* LAAgent【FreeAddress】【下拉选择Standard/Address】
	*/
	public String getFreeAddress()
	{
		return FreeAddress;
	}
	public void setFreeAddress(String aFreeAddress)
	{
		if(aFreeAddress!=null && aFreeAddress.length()>500)
			throw new IllegalArgumentException("Laagent【freeaddress】FreeAddress值"+aFreeAddress+"的长度"+aFreeAddress.length()+"大于最大值500");
		FreeAddress = aFreeAddress;
	}
	/**
	* LAAgent【Phone】【Home Tel No】
	*/
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String aPhone)
	{
		if(aPhone!=null && aPhone.length()>20)
			throw new IllegalArgumentException("Laagent【phone】Phone值"+aPhone+"的长度"+aPhone.length()+"大于最大值20");
		Phone = aPhone;
	}
	/**
	* LAAgent【Mobile】【Mobile No】
	*/
	public String getMobile()
	{
		return Mobile;
	}
	public void setMobile(String aMobile)
	{
		if(aMobile!=null && aMobile.length()>20)
			throw new IllegalArgumentException("Laagent【mobile】Mobile值"+aMobile+"的长度"+aMobile.length()+"大于最大值20");
		Mobile = aMobile;
	}
	/**
	* LAAgent【Email】【Personal Email Address】
	*/
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String aEmail)
	{
		if(aEmail!=null && aEmail.length()>50)
			throw new IllegalArgumentException("Laagent【email】Email值"+aEmail+"的长度"+aEmail.length()+"大于最大值50");
		Email = aEmail;
	}
	/**
	* LAAgent【CompanyEmail】【Company Email Address】
	*/
	public String getCompanyEmail()
	{
		return CompanyEmail;
	}
	public void setCompanyEmail(String aCompanyEmail)
	{
		if(aCompanyEmail!=null && aCompanyEmail.length()>50)
			throw new IllegalArgumentException("Laagent【companyemail】CompanyEmail值"+aCompanyEmail+"的长度"+aCompanyEmail.length()+"大于最大值50");
		CompanyEmail = aCompanyEmail;
	}
	/**
	* LAAgent【OfficeAddress】【Office Address，默认为UnitAddress】
	*/
	public String getOfficeAddress()
	{
		return OfficeAddress;
	}
	public void setOfficeAddress(String aOfficeAddress)
	{
		if(aOfficeAddress!=null && aOfficeAddress.length()>200)
			throw new IllegalArgumentException("Laagent【officeaddress】OfficeAddress值"+aOfficeAddress+"的长度"+aOfficeAddress.length()+"大于最大值200");
		OfficeAddress = aOfficeAddress;
	}
	/**
	* LAAgent【OfficeTel】【Office Tel】
	*/
	public String getOfficeTel()
	{
		return OfficeTel;
	}
	public void setOfficeTel(String aOfficeTel)
	{
		if(aOfficeTel!=null && aOfficeTel.length()>20)
			throw new IllegalArgumentException("Laagent【officetel】OfficeTel值"+aOfficeTel+"的长度"+aOfficeTel.length()+"大于最大值20");
		OfficeTel = aOfficeTel;
	}
	/**
	* LAAgent【OfficeFaxNo】【Office Fax No】
	*/
	public String getOfficeFaxNo()
	{
		return OfficeFaxNo;
	}
	public void setOfficeFaxNo(String aOfficeFaxNo)
	{
		if(aOfficeFaxNo!=null && aOfficeFaxNo.length()>20)
			throw new IllegalArgumentException("Laagent【officefaxno】OfficeFaxNo值"+aOfficeFaxNo+"的长度"+aOfficeFaxNo.length()+"大于最大值20");
		OfficeFaxNo = aOfficeFaxNo;
	}
	/**
	* LAAgent【Marriage】【Martial Status】
	*/
	public String getMarriage()
	{
		return Marriage;
	}
	public void setMarriage(String aMarriage)
	{
		if(aMarriage!=null && aMarriage.length()>2)
			throw new IllegalArgumentException("Laagent【marriage】Marriage值"+aMarriage+"的长度"+aMarriage.length()+"大于最大值2");
		Marriage = aMarriage;
	}
	/**
	* LAAgent【SpouseName】【Spouse Name】
	*/
	public String getSpouseName()
	{
		return SpouseName;
	}
	public void setSpouseName(String aSpouseName)
	{
		if(aSpouseName!=null && aSpouseName.length()>50)
			throw new IllegalArgumentException("Laagent【spousename】SpouseName值"+aSpouseName+"的长度"+aSpouseName.length()+"大于最大值50");
		SpouseName = aSpouseName;
	}
	/**
	* LAAgent【SpouseIDNo】【Spouse HKID No/Passport Number】
	*/
	public String getSpouseIDNo()
	{
		return SpouseIDNo;
	}
	public void setSpouseIDNo(String aSpouseIDNo)
	{
		if(aSpouseIDNo!=null && aSpouseIDNo.length()>20)
			throw new IllegalArgumentException("Laagent【spouseidno】SpouseIDNo值"+aSpouseIDNo+"的长度"+aSpouseIDNo.length()+"大于最大值20");
		SpouseIDNo = aSpouseIDNo;
	}
	/**
	* LAAgent【Flag1】
	*/
	public String getFlag1()
	{
		return Flag1;
	}
	public void setFlag1(String aFlag1)
	{
		if(aFlag1!=null && aFlag1.length()>50)
			throw new IllegalArgumentException("Laagent【flag1】Flag1值"+aFlag1+"的长度"+aFlag1.length()+"大于最大值50");
		Flag1 = aFlag1;
	}
	/**
	* LAAgent【Flag2】
	*/
	public String getFlag2()
	{
		return Flag2;
	}
	public void setFlag2(String aFlag2)
	{
		if(aFlag2!=null && aFlag2.length()>50)
			throw new IllegalArgumentException("Laagent【flag2】Flag2值"+aFlag2+"的长度"+aFlag2.length()+"大于最大值50");
		Flag2 = aFlag2;
	}
	/**
	* LAAgent【Flag3】
	*/
	public String getFlag3()
	{
		return Flag3;
	}
	public void setFlag3(String aFlag3)
	{
		if(aFlag3!=null && aFlag3.length()>50)
			throw new IllegalArgumentException("Laagent【flag3】Flag3值"+aFlag3+"的长度"+aFlag3.length()+"大于最大值50");
		Flag3 = aFlag3;
	}
	/**
	* LATree【AgentGrade】【Agent Title，下拉A01-SDD】
	*/
	public String getAgentGrade()
	{
		return AgentGrade;
	}
	public void setAgentGrade(String aAgentGrade)
	{
		if(aAgentGrade!=null && aAgentGrade.length()>10)
			throw new IllegalArgumentException("Latree【agentgrade】AgentGrade值"+aAgentGrade+"的长度"+aAgentGrade.length()+"大于最大值10");
		AgentGrade = aAgentGrade;
	}
	/**
	* LATree【GradeStartDate】
	*/
	public String getGradeStartDate()
	{
		if( GradeStartDate != null )
			return fDate.getString(GradeStartDate);
		else
			return null;
	}
	public void setGradeStartDate(Date aGradeStartDate)
	{
		GradeStartDate = aGradeStartDate;
	}
	public void setGradeStartDate(String aGradeStartDate)
	{
		if (aGradeStartDate != null && !aGradeStartDate.equals("") )
		{
			GradeStartDate = fDate.getDate( aGradeStartDate );
		}
		else
			GradeStartDate = null;
	}

	/**
	* LATree【AgentSubGrade】
	*/
	public String getAgentSubGrade()
	{
		return AgentSubGrade;
	}
	public void setAgentSubGrade(String aAgentSubGrade)
	{
		if(aAgentSubGrade!=null && aAgentSubGrade.length()>10)
			throw new IllegalArgumentException("Latree【agentsubgrade】AgentSubGrade值"+aAgentSubGrade+"的长度"+aAgentSubGrade.length()+"大于最大值10");
		AgentSubGrade = aAgentSubGrade;
	}
	/**
	* LATree【SubGradeStartDate】
	*/
	public String getSubGradeStartDate()
	{
		if( SubGradeStartDate != null )
			return fDate.getString(SubGradeStartDate);
		else
			return null;
	}
	public void setSubGradeStartDate(Date aSubGradeStartDate)
	{
		SubGradeStartDate = aSubGradeStartDate;
	}
	public void setSubGradeStartDate(String aSubGradeStartDate)
	{
		if (aSubGradeStartDate != null && !aSubGradeStartDate.equals("") )
		{
			SubGradeStartDate = fDate.getDate( aSubGradeStartDate );
		}
		else
			SubGradeStartDate = null;
	}

	/**
	* LATree【EffectiveDate】
	*/
	public String getEffectiveDate()
	{
		if( EffectiveDate != null )
			return fDate.getString(EffectiveDate);
		else
			return null;
	}
	public void setEffectiveDate(Date aEffectiveDate)
	{
		EffectiveDate = aEffectiveDate;
	}
	public void setEffectiveDate(String aEffectiveDate)
	{
		if (aEffectiveDate != null && !aEffectiveDate.equals("") )
		{
			EffectiveDate = fDate.getDate( aEffectiveDate );
		}
		else
			EffectiveDate = null;
	}

	/**
	* LATree【TransferEffectiveDate】
	*/
	public String getTransferEffectiveDate()
	{
		if( TransferEffectiveDate != null )
			return fDate.getString(TransferEffectiveDate);
		else
			return null;
	}
	public void setTransferEffectiveDate(Date aTransferEffectiveDate)
	{
		TransferEffectiveDate = aTransferEffectiveDate;
	}
	public void setTransferEffectiveDate(String aTransferEffectiveDate)
	{
		if (aTransferEffectiveDate != null && !aTransferEffectiveDate.equals("") )
		{
			TransferEffectiveDate = fDate.getDate( aTransferEffectiveDate );
		}
		else
			TransferEffectiveDate = null;
	}

	/**
	* LABranchgroup【BranchAttr】
	*/
	public String getBranchAttr()
	{
		return BranchAttr;
	}
	public void setBranchAttr(String aBranchAttr)
	{
		if(aBranchAttr!=null && aBranchAttr.length()>20)
			throw new IllegalArgumentException("Labranchgroup【branchattr】BranchAttr值"+aBranchAttr+"的长度"+aBranchAttr.length()+"大于最大值20");
		BranchAttr = aBranchAttr;
	}
	/**
	* LABranchgroup【BranchLevel】
	*/
	public String getBranchLevel()
	{
		return BranchLevel;
	}
	public void setBranchLevel(String aBranchLevel)
	{
		if(aBranchLevel!=null && aBranchLevel.length()>2)
			throw new IllegalArgumentException("Labranchgroup【branchlevel】BranchLevel值"+aBranchLevel+"的长度"+aBranchLevel.length()+"大于最大值2");
		BranchLevel = aBranchLevel;
	}
	/**
	* LABranchgroup【BranchName】
	*/
	public String getBranchName()
	{
		return BranchName;
	}
	public void setBranchName(String aBranchName)
	{
		if(aBranchName!=null && aBranchName.length()>60)
			throw new IllegalArgumentException("Labranchgroup【branchname】BranchName值"+aBranchName+"的长度"+aBranchName.length()+"大于最大值60");
		BranchName = aBranchName;
	}
	/**
	* LABranchgroup【BranchNameEng】
	*/
	public String getBranchNameEng()
	{
		return BranchNameEng;
	}
	public void setBranchNameEng(String aBranchNameEng)
	{
		if(aBranchNameEng!=null && aBranchNameEng.length()>60)
			throw new IllegalArgumentException("Labranchgroup【branchnameeng】BranchNameEng值"+aBranchNameEng+"的长度"+aBranchNameEng.length()+"大于最大值60");
		BranchNameEng = aBranchNameEng;
	}
	/**
	* LABranchgroup【BranchNameChi】
	*/
	public String getBranchNameChi()
	{
		return BranchNameChi;
	}
	public void setBranchNameChi(String aBranchNameChi)
	{
		if(aBranchNameChi!=null && aBranchNameChi.length()>60)
			throw new IllegalArgumentException("Labranchgroup【branchnamechi】BranchNameChi值"+aBranchNameChi+"的长度"+aBranchNameChi.length()+"大于最大值60");
		BranchNameChi = aBranchNameChi;
	}
	/**
	* LABranchgroup【BranchEffDate】
	*/
	public String getBranchEffDate()
	{
		if( BranchEffDate != null )
			return fDate.getString(BranchEffDate);
		else
			return null;
	}
	public void setBranchEffDate(Date aBranchEffDate)
	{
		BranchEffDate = aBranchEffDate;
	}
	public void setBranchEffDate(String aBranchEffDate)
	{
		if (aBranchEffDate != null && !aBranchEffDate.equals("") )
		{
			BranchEffDate = fDate.getDate( aBranchEffDate );
		}
		else
			BranchEffDate = null;
	}

	/**
	* LABranchgroup【BranchAddress】
	*/
	public String getBranchAddress()
	{
		return BranchAddress;
	}
	public void setBranchAddress(String aBranchAddress)
	{
		if(aBranchAddress!=null && aBranchAddress.length()>200)
			throw new IllegalArgumentException("Labranchgroup【branchaddress】BranchAddress值"+aBranchAddress+"的长度"+aBranchAddress.length()+"大于最大值200");
		BranchAddress = aBranchAddress;
	}
	/**
	* LABranchgroup【BranchPhoneNo】
	*/
	public String getBranchPhoneNo()
	{
		return BranchPhoneNo;
	}
	public void setBranchPhoneNo(String aBranchPhoneNo)
	{
		if(aBranchPhoneNo!=null && aBranchPhoneNo.length()>20)
			throw new IllegalArgumentException("Labranchgroup【branchphoneno】BranchPhoneNo值"+aBranchPhoneNo+"的长度"+aBranchPhoneNo.length()+"大于最大值20");
		BranchPhoneNo = aBranchPhoneNo;
	}
	/**
	* LABranchgroup【BranchFaxNo】
	*/
	public String getBranchFaxNo()
	{
		return BranchFaxNo;
	}
	public void setBranchFaxNo(String aBranchFaxNo)
	{
		if(aBranchFaxNo!=null && aBranchFaxNo.length()>20)
			throw new IllegalArgumentException("Labranchgroup【branchfaxno】BranchFaxNo值"+aBranchFaxNo+"的长度"+aBranchFaxNo.length()+"大于最大值20");
		BranchFaxNo = aBranchFaxNo;
	}
	/**
	* LABranchgroup【BranchLocation】
	*/
	public String getBranchLocation()
	{
		return BranchLocation;
	}
	public void setBranchLocation(String aBranchLocation)
	{
		if(aBranchLocation!=null && aBranchLocation.length()>200)
			throw new IllegalArgumentException("Labranchgroup【branchlocation】BranchLocation值"+aBranchLocation+"的长度"+aBranchLocation.length()+"大于最大值200");
		BranchLocation = aBranchLocation;
	}
	/**
	* LABranchgroup【BranchStatus】
	*/
	public String getBranchStatus()
	{
		return BranchStatus;
	}
	public void setBranchStatus(String aBranchStatus)
	{
		if(aBranchStatus!=null && aBranchStatus.length()>2)
			throw new IllegalArgumentException("Labranchgroup【branchstatus】BranchStatus值"+aBranchStatus+"的长度"+aBranchStatus.length()+"大于最大值2");
		BranchStatus = aBranchStatus;
	}
	/**
	* LABranchgroup【BranchTerminateEffDate】
	*/
	public String getBranchTerminateEffDate()
	{
		if( BranchTerminateEffDate != null )
			return fDate.getString(BranchTerminateEffDate);
		else
			return null;
	}
	public void setBranchTerminateEffDate(Date aBranchTerminateEffDate)
	{
		BranchTerminateEffDate = aBranchTerminateEffDate;
	}
	public void setBranchTerminateEffDate(String aBranchTerminateEffDate)
	{
		if (aBranchTerminateEffDate != null && !aBranchTerminateEffDate.equals("") )
		{
			BranchTerminateEffDate = fDate.getDate( aBranchTerminateEffDate );
		}
		else
			BranchTerminateEffDate = null;
	}

	/**
	* LABranchgroup【BranchTerminateReason】
	*/
	public String getBranchTerminateReason()
	{
		return BranchTerminateReason;
	}
	public void setBranchTerminateReason(String aBranchTerminateReason)
	{
		if(aBranchTerminateReason!=null && aBranchTerminateReason.length()>500)
			throw new IllegalArgumentException("Labranchgroup【branchterminatereason】BranchTerminateReason值"+aBranchTerminateReason+"的长度"+aBranchTerminateReason.length()+"大于最大值500");
		BranchTerminateReason = aBranchTerminateReason;
	}
	/**
	* LABranchgroup【DirectFlag】
	*/
	public String getDirectFlag()
	{
		return DirectFlag;
	}
	public void setDirectFlag(String aDirectFlag)
	{
		if(aDirectFlag!=null && aDirectFlag.length()>2)
			throw new IllegalArgumentException("Labranchgroup【directflag】DirectFlag值"+aDirectFlag+"的长度"+aDirectFlag.length()+"大于最大值2");
		DirectFlag = aDirectFlag;
	}
	/**
	* LABranchgroup【UpAgentGroup】【预留】
	*/
	public String getUpAgentGroup()
	{
		return UpAgentGroup;
	}
	public void setUpAgentGroup(String aUpAgentGroup)
	{
		if(aUpAgentGroup!=null && aUpAgentGroup.length()>10)
			throw new IllegalArgumentException("Labranchgroup【upagentgroup】UpAgentGroup值"+aUpAgentGroup+"的长度"+aUpAgentGroup.length()+"大于最大值10");
		UpAgentGroup = aUpAgentGroup;
	}
	/**
	* LABranchgroup【BranchManager】【预留】
	*/
	public String getBranchManager()
	{
		return BranchManager;
	}
	public void setBranchManager(String aBranchManager)
	{
		if(aBranchManager!=null && aBranchManager.length()>12)
			throw new IllegalArgumentException("Labranchgroup【branchmanager】BranchManager值"+aBranchManager+"的长度"+aBranchManager.length()+"大于最大值12");
		BranchManager = aBranchManager;
	}
	/**
	* Unit主管编码【取LAAgentV】
	*/
	public String getUnitManager()
	{
		return UnitManager;
	}
	public void setUnitManager(String aUnitManager)
	{
		if(aUnitManager!=null && aUnitManager.length()>12)
			throw new IllegalArgumentException("Unit主管编码UnitManager值"+aUnitManager+"的长度"+aUnitManager.length()+"大于最大值12");
		UnitManager = aUnitManager;
	}
	/**
	* Division主管编码【取LAAgentV】
	*/
	public String getDivisionManager()
	{
		return DivisionManager;
	}
	public void setDivisionManager(String aDivisionManager)
	{
		if(aDivisionManager!=null && aDivisionManager.length()>12)
			throw new IllegalArgumentException("Division主管编码DivisionManager值"+aDivisionManager+"的长度"+aDivisionManager.length()+"大于最大值12");
		DivisionManager = aDivisionManager;
	}
	/**
	* Region主管编码【取LAAgentV】
	*/
	public String getRegionManager()
	{
		return RegionManager;
	}
	public void setRegionManager(String aRegionManager)
	{
		if(aRegionManager!=null && aRegionManager.length()>12)
			throw new IllegalArgumentException("Region主管编码RegionManager值"+aRegionManager+"的长度"+aRegionManager.length()+"大于最大值12");
		RegionManager = aRegionManager;
	}
	/**
	* 招募人编码【取LAAgentV】
	*/
	public String getRecruitingAgentCode()
	{
		return RecruitingAgentCode;
	}
	public void setRecruitingAgentCode(String aRecruitingAgentCode)
	{
		if(aRecruitingAgentCode!=null && aRecruitingAgentCode.length()>12)
			throw new IllegalArgumentException("招募人编码RecruitingAgentCode值"+aRecruitingAgentCode+"的长度"+aRecruitingAgentCode.length()+"大于最大值12");
		RecruitingAgentCode = aRecruitingAgentCode;
	}
	/**
	* 推荐人编码【取LAAgentV】
	*/
	public String getReferringAgentCode()
	{
		return ReferringAgentCode;
	}
	public void setReferringAgentCode(String aReferringAgentCode)
	{
		if(aReferringAgentCode!=null && aReferringAgentCode.length()>12)
			throw new IllegalArgumentException("推荐人编码ReferringAgentCode值"+aReferringAgentCode+"的长度"+aReferringAgentCode.length()+"大于最大值12");
		ReferringAgentCode = aReferringAgentCode;
	}
	/**
	* 直接汇报人编码【取LAAgentV】
	*/
	public String getDirectReportingAgentCode()
	{
		return DirectReportingAgentCode;
	}
	public void setDirectReportingAgentCode(String aDirectReportingAgentCode)
	{
		if(aDirectReportingAgentCode!=null && aDirectReportingAgentCode.length()>12)
			throw new IllegalArgumentException("直接汇报人编码DirectReportingAgentCode值"+aDirectReportingAgentCode+"的长度"+aDirectReportingAgentCode.length()+"大于最大值12");
		DirectReportingAgentCode = aDirectReportingAgentCode;
	}
	/**
	* 间接汇报人编码【取LAAgentV】
	*/
	public String getInirectReportingAgentCode()
	{
		return InirectReportingAgentCode;
	}
	public void setInirectReportingAgentCode(String aInirectReportingAgentCode)
	{
		if(aInirectReportingAgentCode!=null && aInirectReportingAgentCode.length()>12)
			throw new IllegalArgumentException("间接汇报人编码InirectReportingAgentCode值"+aInirectReportingAgentCode+"的长度"+aInirectReportingAgentCode.length()+"大于最大值12");
		InirectReportingAgentCode = aInirectReportingAgentCode;
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
	public String getLastJobNature()
	{
		return LastJobNature;
	}
	public void setLastJobNature(String aLastJobNature)
	{
		if(aLastJobNature!=null && aLastJobNature.length()>100)
			throw new IllegalArgumentException("LastjobnatureLastJobNature值"+aLastJobNature+"的长度"+aLastJobNature.length()+"大于最大值100");
		LastJobNature = aLastJobNature;
	}
	public String getUnitBranchAttr()
	{
		return UnitBranchAttr;
	}
	public void setUnitBranchAttr(String aUnitBranchAttr)
	{
		if(aUnitBranchAttr!=null && aUnitBranchAttr.length()>20)
			throw new IllegalArgumentException("UnitbranchattrUnitBranchAttr值"+aUnitBranchAttr+"的长度"+aUnitBranchAttr.length()+"大于最大值20");
		UnitBranchAttr = aUnitBranchAttr;
	}
	public String getDivisionBranchAttr()
	{
		return DivisionBranchAttr;
	}
	public void setDivisionBranchAttr(String aDivisionBranchAttr)
	{
		if(aDivisionBranchAttr!=null && aDivisionBranchAttr.length()>20)
			throw new IllegalArgumentException("DivisionbranchattrDivisionBranchAttr值"+aDivisionBranchAttr+"的长度"+aDivisionBranchAttr.length()+"大于最大值20");
		DivisionBranchAttr = aDivisionBranchAttr;
	}
	public String getRegionBranchAttr()
	{
		return RegionBranchAttr;
	}
	public void setRegionBranchAttr(String aRegionBranchAttr)
	{
		if(aRegionBranchAttr!=null && aRegionBranchAttr.length()>20)
			throw new IllegalArgumentException("RegionbranchattrRegionBranchAttr值"+aRegionBranchAttr+"的长度"+aRegionBranchAttr.length()+"大于最大值20");
		RegionBranchAttr = aRegionBranchAttr;
	}
	public String getOutWorkDate()
	{
		if( OutWorkDate != null )
			return fDate.getString(OutWorkDate);
		else
			return null;
	}
	public void setOutWorkDate(Date aOutWorkDate)
	{
		OutWorkDate = aOutWorkDate;
	}
	public void setOutWorkDate(String aOutWorkDate)
	{
		if (aOutWorkDate != null && !aOutWorkDate.equals("") )
		{
			OutWorkDate = fDate.getDate( aOutWorkDate );
		}
		else
			OutWorkDate = null;
	}

	public String getDummyGradeFlag()
	{
		return DummyGradeFlag;
	}
	public void setDummyGradeFlag(String aDummyGradeFlag)
	{
		if(aDummyGradeFlag!=null && aDummyGradeFlag.length()>2)
			throw new IllegalArgumentException("DummygradeflagDummyGradeFlag值"+aDummyGradeFlag+"的长度"+aDummyGradeFlag.length()+"大于最大值2");
		DummyGradeFlag = aDummyGradeFlag;
	}

	/**
	* 使用另外一个 LAAgentCSchema 对象给 Schema 赋值
	* @param: aLAAgentCSchema LAAgentCSchema
	**/
	public void setSchema(LAAgentCSchema aLAAgentCSchema)
	{
		this.BakMonth = aLAAgentCSchema.getBakMonth();
		this.BakType = aLAAgentCSchema.getBakType();
		this.AgentCode = aLAAgentCSchema.getAgentCode();
		this.BranchType = aLAAgentCSchema.getBranchType();
		this.AgentGroup = aLAAgentCSchema.getAgentGroup();
		this.ManageCom = aLAAgentCSchema.getManageCom();
		this.Password = aLAAgentCSchema.getPassword();
		this.AgentState = aLAAgentCSchema.getAgentState();
		this.SurName = aLAAgentCSchema.getSurName();
		this.GivenName = aLAAgentCSchema.getGivenName();
		this.EnglishName = aLAAgentCSchema.getEnglishName();
		this.HKIDName = aLAAgentCSchema.getHKIDName();
		this.ChineseName = aLAAgentCSchema.getChineseName();
		this.IDType = aLAAgentCSchema.getIDType();
		this.IDNo = aLAAgentCSchema.getIDNo();
		this.WorkingVisa = aLAAgentCSchema.getWorkingVisa();
		this.WorkingVisaExpiryDate = fDate.getDate( aLAAgentCSchema.getWorkingVisaExpiryDate());
		this.WorkingVisaType = aLAAgentCSchema.getWorkingVisaType();
		this.Qualification = aLAAgentCSchema.getQualification();
		this.ContractType = aLAAgentCSchema.getContractType();
		this.ContractEffDate = fDate.getDate( aLAAgentCSchema.getContractEffDate());
		this.ContractStatus = aLAAgentCSchema.getContractStatus();
		this.RecruitmentProfile = aLAAgentCSchema.getRecruitmentProfile();
		this.LastTerminationDate = fDate.getDate( aLAAgentCSchema.getLastTerminationDate());
		this.LastTerminationReason = aLAAgentCSchema.getLastTerminationReason();
		this.TerminationNo = aLAAgentCSchema.getTerminationNo();
		this.PaymentMethod = aLAAgentCSchema.getPaymentMethod();
		this.BankAccountName = aLAAgentCSchema.getBankAccountName();
		this.BankAccountNo = aLAAgentCSchema.getBankAccountNo();
		this.WithheldReason = aLAAgentCSchema.getWithheldReason();
		this.GuarantorAgentCode = aLAAgentCSchema.getGuarantorAgentCode();
		this.GuarantorAgentRelation = aLAAgentCSchema.getGuarantorAgentRelation();
		this.GuarantorType = aLAAgentCSchema.getGuarantorType();
		this.Sex = aLAAgentCSchema.getSex();
		this.Title = aLAAgentCSchema.getTitle();
		this.Nationality = aLAAgentCSchema.getNationality();
		this.Birthday = fDate.getDate( aLAAgentCSchema.getBirthday());
		this.WorkingExperience = aLAAgentCSchema.getWorkingExperience();
		this.LastJob = aLAAgentCSchema.getLastJob();
		this.LastJobServiceYears = aLAAgentCSchema.getLastJobServiceYears();
		this.InsuranceExperience = aLAAgentCSchema.getInsuranceExperience();
		this.InsuranceExperienceYears = aLAAgentCSchema.getInsuranceExperienceYears();
		this.EducationLevel = aLAAgentCSchema.getEducationLevel();
		this.AddressType = aLAAgentCSchema.getAddressType();
		this.AddressRoom = aLAAgentCSchema.getAddressRoom();
		this.AddressFloor = aLAAgentCSchema.getAddressFloor();
		this.AddressBlock = aLAAgentCSchema.getAddressBlock();
		this.AddressBuilding = aLAAgentCSchema.getAddressBuilding();
		this.AddressStreet = aLAAgentCSchema.getAddressStreet();
		this.AddressDistrict = aLAAgentCSchema.getAddressDistrict();
		this.FreeAddress = aLAAgentCSchema.getFreeAddress();
		this.Phone = aLAAgentCSchema.getPhone();
		this.Mobile = aLAAgentCSchema.getMobile();
		this.Email = aLAAgentCSchema.getEmail();
		this.CompanyEmail = aLAAgentCSchema.getCompanyEmail();
		this.OfficeAddress = aLAAgentCSchema.getOfficeAddress();
		this.OfficeTel = aLAAgentCSchema.getOfficeTel();
		this.OfficeFaxNo = aLAAgentCSchema.getOfficeFaxNo();
		this.Marriage = aLAAgentCSchema.getMarriage();
		this.SpouseName = aLAAgentCSchema.getSpouseName();
		this.SpouseIDNo = aLAAgentCSchema.getSpouseIDNo();
		this.Flag1 = aLAAgentCSchema.getFlag1();
		this.Flag2 = aLAAgentCSchema.getFlag2();
		this.Flag3 = aLAAgentCSchema.getFlag3();
		this.AgentGrade = aLAAgentCSchema.getAgentGrade();
		this.GradeStartDate = fDate.getDate( aLAAgentCSchema.getGradeStartDate());
		this.AgentSubGrade = aLAAgentCSchema.getAgentSubGrade();
		this.SubGradeStartDate = fDate.getDate( aLAAgentCSchema.getSubGradeStartDate());
		this.EffectiveDate = fDate.getDate( aLAAgentCSchema.getEffectiveDate());
		this.TransferEffectiveDate = fDate.getDate( aLAAgentCSchema.getTransferEffectiveDate());
		this.BranchAttr = aLAAgentCSchema.getBranchAttr();
		this.BranchLevel = aLAAgentCSchema.getBranchLevel();
		this.BranchName = aLAAgentCSchema.getBranchName();
		this.BranchNameEng = aLAAgentCSchema.getBranchNameEng();
		this.BranchNameChi = aLAAgentCSchema.getBranchNameChi();
		this.BranchEffDate = fDate.getDate( aLAAgentCSchema.getBranchEffDate());
		this.BranchAddress = aLAAgentCSchema.getBranchAddress();
		this.BranchPhoneNo = aLAAgentCSchema.getBranchPhoneNo();
		this.BranchFaxNo = aLAAgentCSchema.getBranchFaxNo();
		this.BranchLocation = aLAAgentCSchema.getBranchLocation();
		this.BranchStatus = aLAAgentCSchema.getBranchStatus();
		this.BranchTerminateEffDate = fDate.getDate( aLAAgentCSchema.getBranchTerminateEffDate());
		this.BranchTerminateReason = aLAAgentCSchema.getBranchTerminateReason();
		this.DirectFlag = aLAAgentCSchema.getDirectFlag();
		this.UpAgentGroup = aLAAgentCSchema.getUpAgentGroup();
		this.BranchManager = aLAAgentCSchema.getBranchManager();
		this.UnitManager = aLAAgentCSchema.getUnitManager();
		this.DivisionManager = aLAAgentCSchema.getDivisionManager();
		this.RegionManager = aLAAgentCSchema.getRegionManager();
		this.RecruitingAgentCode = aLAAgentCSchema.getRecruitingAgentCode();
		this.ReferringAgentCode = aLAAgentCSchema.getReferringAgentCode();
		this.DirectReportingAgentCode = aLAAgentCSchema.getDirectReportingAgentCode();
		this.InirectReportingAgentCode = aLAAgentCSchema.getInirectReportingAgentCode();
		this.Operator = aLAAgentCSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentCSchema.getMakeDate());
		this.MakeTime = aLAAgentCSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentCSchema.getModifyDate());
		this.ModifyTime = aLAAgentCSchema.getModifyTime();
		this.LastJobNature = aLAAgentCSchema.getLastJobNature();
		this.UnitBranchAttr = aLAAgentCSchema.getUnitBranchAttr();
		this.DivisionBranchAttr = aLAAgentCSchema.getDivisionBranchAttr();
		this.RegionBranchAttr = aLAAgentCSchema.getRegionBranchAttr();
		this.OutWorkDate = fDate.getDate( aLAAgentCSchema.getOutWorkDate());
		this.DummyGradeFlag = aLAAgentCSchema.getDummyGradeFlag();
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
			if( rs.getString("BakMonth") == null )
				this.BakMonth = null;
			else
				this.BakMonth = rs.getString("BakMonth").trim();

			if( rs.getString("BakType") == null )
				this.BakType = null;
			else
				this.BakType = rs.getString("BakType").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("Password") == null )
				this.Password = null;
			else
				this.Password = rs.getString("Password").trim();

			if( rs.getString("AgentState") == null )
				this.AgentState = null;
			else
				this.AgentState = rs.getString("AgentState").trim();

			if( rs.getString("SurName") == null )
				this.SurName = null;
			else
				this.SurName = rs.getString("SurName").trim();

			if( rs.getString("GivenName") == null )
				this.GivenName = null;
			else
				this.GivenName = rs.getString("GivenName").trim();

			if( rs.getString("EnglishName") == null )
				this.EnglishName = null;
			else
				this.EnglishName = rs.getString("EnglishName").trim();

			if( rs.getString("HKIDName") == null )
				this.HKIDName = null;
			else
				this.HKIDName = rs.getString("HKIDName").trim();

			if( rs.getString("ChineseName") == null )
				this.ChineseName = null;
			else
				this.ChineseName = rs.getString("ChineseName").trim();

			if( rs.getString("IDType") == null )
				this.IDType = null;
			else
				this.IDType = rs.getString("IDType").trim();

			if( rs.getString("IDNo") == null )
				this.IDNo = null;
			else
				this.IDNo = rs.getString("IDNo").trim();

			if( rs.getString("WorkingVisa") == null )
				this.WorkingVisa = null;
			else
				this.WorkingVisa = rs.getString("WorkingVisa").trim();

			this.WorkingVisaExpiryDate = rs.getDate("WorkingVisaExpiryDate");
			if( rs.getString("WorkingVisaType") == null )
				this.WorkingVisaType = null;
			else
				this.WorkingVisaType = rs.getString("WorkingVisaType").trim();

			if( rs.getString("Qualification") == null )
				this.Qualification = null;
			else
				this.Qualification = rs.getString("Qualification").trim();

			if( rs.getString("ContractType") == null )
				this.ContractType = null;
			else
				this.ContractType = rs.getString("ContractType").trim();

			this.ContractEffDate = rs.getDate("ContractEffDate");
			if( rs.getString("ContractStatus") == null )
				this.ContractStatus = null;
			else
				this.ContractStatus = rs.getString("ContractStatus").trim();

			if( rs.getString("RecruitmentProfile") == null )
				this.RecruitmentProfile = null;
			else
				this.RecruitmentProfile = rs.getString("RecruitmentProfile").trim();

			this.LastTerminationDate = rs.getDate("LastTerminationDate");
			if( rs.getString("LastTerminationReason") == null )
				this.LastTerminationReason = null;
			else
				this.LastTerminationReason = rs.getString("LastTerminationReason").trim();

			this.TerminationNo = rs.getInt("TerminationNo");
			if( rs.getString("PaymentMethod") == null )
				this.PaymentMethod = null;
			else
				this.PaymentMethod = rs.getString("PaymentMethod").trim();

			if( rs.getString("BankAccountName") == null )
				this.BankAccountName = null;
			else
				this.BankAccountName = rs.getString("BankAccountName").trim();

			if( rs.getString("BankAccountNo") == null )
				this.BankAccountNo = null;
			else
				this.BankAccountNo = rs.getString("BankAccountNo").trim();

			if( rs.getString("WithheldReason") == null )
				this.WithheldReason = null;
			else
				this.WithheldReason = rs.getString("WithheldReason").trim();

			if( rs.getString("GuarantorAgentCode") == null )
				this.GuarantorAgentCode = null;
			else
				this.GuarantorAgentCode = rs.getString("GuarantorAgentCode").trim();

			if( rs.getString("GuarantorAgentRelation") == null )
				this.GuarantorAgentRelation = null;
			else
				this.GuarantorAgentRelation = rs.getString("GuarantorAgentRelation").trim();

			if( rs.getString("GuarantorType") == null )
				this.GuarantorType = null;
			else
				this.GuarantorType = rs.getString("GuarantorType").trim();

			if( rs.getString("Sex") == null )
				this.Sex = null;
			else
				this.Sex = rs.getString("Sex").trim();

			if( rs.getString("Title") == null )
				this.Title = null;
			else
				this.Title = rs.getString("Title").trim();

			if( rs.getString("Nationality") == null )
				this.Nationality = null;
			else
				this.Nationality = rs.getString("Nationality").trim();

			this.Birthday = rs.getDate("Birthday");
			this.WorkingExperience = rs.getInt("WorkingExperience");
			if( rs.getString("LastJob") == null )
				this.LastJob = null;
			else
				this.LastJob = rs.getString("LastJob").trim();

			this.LastJobServiceYears = rs.getInt("LastJobServiceYears");
			if( rs.getString("InsuranceExperience") == null )
				this.InsuranceExperience = null;
			else
				this.InsuranceExperience = rs.getString("InsuranceExperience").trim();

			this.InsuranceExperienceYears = rs.getInt("InsuranceExperienceYears");
			if( rs.getString("EducationLevel") == null )
				this.EducationLevel = null;
			else
				this.EducationLevel = rs.getString("EducationLevel").trim();

			if( rs.getString("AddressType") == null )
				this.AddressType = null;
			else
				this.AddressType = rs.getString("AddressType").trim();

			if( rs.getString("AddressRoom") == null )
				this.AddressRoom = null;
			else
				this.AddressRoom = rs.getString("AddressRoom").trim();

			if( rs.getString("AddressFloor") == null )
				this.AddressFloor = null;
			else
				this.AddressFloor = rs.getString("AddressFloor").trim();

			if( rs.getString("AddressBlock") == null )
				this.AddressBlock = null;
			else
				this.AddressBlock = rs.getString("AddressBlock").trim();

			if( rs.getString("AddressBuilding") == null )
				this.AddressBuilding = null;
			else
				this.AddressBuilding = rs.getString("AddressBuilding").trim();

			if( rs.getString("AddressStreet") == null )
				this.AddressStreet = null;
			else
				this.AddressStreet = rs.getString("AddressStreet").trim();

			if( rs.getString("AddressDistrict") == null )
				this.AddressDistrict = null;
			else
				this.AddressDistrict = rs.getString("AddressDistrict").trim();

			if( rs.getString("FreeAddress") == null )
				this.FreeAddress = null;
			else
				this.FreeAddress = rs.getString("FreeAddress").trim();

			if( rs.getString("Phone") == null )
				this.Phone = null;
			else
				this.Phone = rs.getString("Phone").trim();

			if( rs.getString("Mobile") == null )
				this.Mobile = null;
			else
				this.Mobile = rs.getString("Mobile").trim();

			if( rs.getString("Email") == null )
				this.Email = null;
			else
				this.Email = rs.getString("Email").trim();

			if( rs.getString("CompanyEmail") == null )
				this.CompanyEmail = null;
			else
				this.CompanyEmail = rs.getString("CompanyEmail").trim();

			if( rs.getString("OfficeAddress") == null )
				this.OfficeAddress = null;
			else
				this.OfficeAddress = rs.getString("OfficeAddress").trim();

			if( rs.getString("OfficeTel") == null )
				this.OfficeTel = null;
			else
				this.OfficeTel = rs.getString("OfficeTel").trim();

			if( rs.getString("OfficeFaxNo") == null )
				this.OfficeFaxNo = null;
			else
				this.OfficeFaxNo = rs.getString("OfficeFaxNo").trim();

			if( rs.getString("Marriage") == null )
				this.Marriage = null;
			else
				this.Marriage = rs.getString("Marriage").trim();

			if( rs.getString("SpouseName") == null )
				this.SpouseName = null;
			else
				this.SpouseName = rs.getString("SpouseName").trim();

			if( rs.getString("SpouseIDNo") == null )
				this.SpouseIDNo = null;
			else
				this.SpouseIDNo = rs.getString("SpouseIDNo").trim();

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

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			this.GradeStartDate = rs.getDate("GradeStartDate");
			if( rs.getString("AgentSubGrade") == null )
				this.AgentSubGrade = null;
			else
				this.AgentSubGrade = rs.getString("AgentSubGrade").trim();

			this.SubGradeStartDate = rs.getDate("SubGradeStartDate");
			this.EffectiveDate = rs.getDate("EffectiveDate");
			this.TransferEffectiveDate = rs.getDate("TransferEffectiveDate");
			if( rs.getString("BranchAttr") == null )
				this.BranchAttr = null;
			else
				this.BranchAttr = rs.getString("BranchAttr").trim();

			if( rs.getString("BranchLevel") == null )
				this.BranchLevel = null;
			else
				this.BranchLevel = rs.getString("BranchLevel").trim();

			if( rs.getString("BranchName") == null )
				this.BranchName = null;
			else
				this.BranchName = rs.getString("BranchName").trim();

			if( rs.getString("BranchNameEng") == null )
				this.BranchNameEng = null;
			else
				this.BranchNameEng = rs.getString("BranchNameEng").trim();

			if( rs.getString("BranchNameChi") == null )
				this.BranchNameChi = null;
			else
				this.BranchNameChi = rs.getString("BranchNameChi").trim();

			this.BranchEffDate = rs.getDate("BranchEffDate");
			if( rs.getString("BranchAddress") == null )
				this.BranchAddress = null;
			else
				this.BranchAddress = rs.getString("BranchAddress").trim();

			if( rs.getString("BranchPhoneNo") == null )
				this.BranchPhoneNo = null;
			else
				this.BranchPhoneNo = rs.getString("BranchPhoneNo").trim();

			if( rs.getString("BranchFaxNo") == null )
				this.BranchFaxNo = null;
			else
				this.BranchFaxNo = rs.getString("BranchFaxNo").trim();

			if( rs.getString("BranchLocation") == null )
				this.BranchLocation = null;
			else
				this.BranchLocation = rs.getString("BranchLocation").trim();

			if( rs.getString("BranchStatus") == null )
				this.BranchStatus = null;
			else
				this.BranchStatus = rs.getString("BranchStatus").trim();

			this.BranchTerminateEffDate = rs.getDate("BranchTerminateEffDate");
			if( rs.getString("BranchTerminateReason") == null )
				this.BranchTerminateReason = null;
			else
				this.BranchTerminateReason = rs.getString("BranchTerminateReason").trim();

			if( rs.getString("DirectFlag") == null )
				this.DirectFlag = null;
			else
				this.DirectFlag = rs.getString("DirectFlag").trim();

			if( rs.getString("UpAgentGroup") == null )
				this.UpAgentGroup = null;
			else
				this.UpAgentGroup = rs.getString("UpAgentGroup").trim();

			if( rs.getString("BranchManager") == null )
				this.BranchManager = null;
			else
				this.BranchManager = rs.getString("BranchManager").trim();

			if( rs.getString("UnitManager") == null )
				this.UnitManager = null;
			else
				this.UnitManager = rs.getString("UnitManager").trim();

			if( rs.getString("DivisionManager") == null )
				this.DivisionManager = null;
			else
				this.DivisionManager = rs.getString("DivisionManager").trim();

			if( rs.getString("RegionManager") == null )
				this.RegionManager = null;
			else
				this.RegionManager = rs.getString("RegionManager").trim();

			if( rs.getString("RecruitingAgentCode") == null )
				this.RecruitingAgentCode = null;
			else
				this.RecruitingAgentCode = rs.getString("RecruitingAgentCode").trim();

			if( rs.getString("ReferringAgentCode") == null )
				this.ReferringAgentCode = null;
			else
				this.ReferringAgentCode = rs.getString("ReferringAgentCode").trim();

			if( rs.getString("DirectReportingAgentCode") == null )
				this.DirectReportingAgentCode = null;
			else
				this.DirectReportingAgentCode = rs.getString("DirectReportingAgentCode").trim();

			if( rs.getString("InirectReportingAgentCode") == null )
				this.InirectReportingAgentCode = null;
			else
				this.InirectReportingAgentCode = rs.getString("InirectReportingAgentCode").trim();

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

			if( rs.getString("LastJobNature") == null )
				this.LastJobNature = null;
			else
				this.LastJobNature = rs.getString("LastJobNature").trim();

			if( rs.getString("UnitBranchAttr") == null )
				this.UnitBranchAttr = null;
			else
				this.UnitBranchAttr = rs.getString("UnitBranchAttr").trim();

			if( rs.getString("DivisionBranchAttr") == null )
				this.DivisionBranchAttr = null;
			else
				this.DivisionBranchAttr = rs.getString("DivisionBranchAttr").trim();

			if( rs.getString("RegionBranchAttr") == null )
				this.RegionBranchAttr = null;
			else
				this.RegionBranchAttr = rs.getString("RegionBranchAttr").trim();

			this.OutWorkDate = rs.getDate("OutWorkDate");
			if( rs.getString("DummyGradeFlag") == null )
				this.DummyGradeFlag = null;
			else
				this.DummyGradeFlag = rs.getString("DummyGradeFlag").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAAgentC表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentCSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentCSchema getSchema()
	{
		LAAgentCSchema aLAAgentCSchema = new LAAgentCSchema();
		aLAAgentCSchema.setSchema(this);
		return aLAAgentCSchema;
	}

	public LAAgentCDB getDB()
	{
		LAAgentCDB aDBOper = new LAAgentCDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentC描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(BakMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BakType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Password)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentState)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SurName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GivenName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EnglishName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(HKIDName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ChineseName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IDType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IDNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WorkingVisa)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( WorkingVisaExpiryDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WorkingVisaType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Qualification)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ContractType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ContractEffDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ContractStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RecruitmentProfile)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( LastTerminationDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LastTerminationReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(TerminationNo));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PaymentMethod)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BankAccountName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BankAccountNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WithheldReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GuarantorAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GuarantorAgentRelation)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GuarantorType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Sex)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Title)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Nationality)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( Birthday ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(WorkingExperience));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LastJob)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(LastJobServiceYears));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InsuranceExperience)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(InsuranceExperienceYears));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EducationLevel)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AddressType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AddressRoom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AddressFloor)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AddressBlock)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AddressBuilding)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AddressStreet)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AddressDistrict)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FreeAddress)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Phone)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Mobile)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Email)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CompanyEmail)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OfficeAddress)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OfficeTel)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OfficeFaxNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Marriage)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SpouseName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SpouseIDNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( GradeStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentSubGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( SubGradeStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( TransferEffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchLevel)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchNameEng)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchNameChi)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BranchEffDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAddress)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchPhoneNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchFaxNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchLocation)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchStatus)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( BranchTerminateEffDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchTerminateReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DirectFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UpAgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchManager)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UnitManager)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DivisionManager)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegionManager)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RecruitingAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReferringAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DirectReportingAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InirectReportingAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LastJobNature)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UnitBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DivisionBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegionBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( OutWorkDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DummyGradeFlag));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentC>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			BakMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			BakType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			AgentState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			SurName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			GivenName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			EnglishName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			HKIDName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			ChineseName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			IDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			IDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			WorkingVisa = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			WorkingVisaExpiryDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17,SysConst.PACKAGESPILTER));
			WorkingVisaType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			Qualification = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			ContractType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			ContractEffDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21,SysConst.PACKAGESPILTER));
			ContractStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			RecruitmentProfile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			LastTerminationDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24,SysConst.PACKAGESPILTER));
			LastTerminationReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			TerminationNo= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,26,SysConst.PACKAGESPILTER))).intValue();
			PaymentMethod = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, SysConst.PACKAGESPILTER );
			BankAccountName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
			BankAccountNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, SysConst.PACKAGESPILTER );
			WithheldReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, SysConst.PACKAGESPILTER );
			GuarantorAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, SysConst.PACKAGESPILTER );
			GuarantorAgentRelation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, SysConst.PACKAGESPILTER );
			GuarantorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, SysConst.PACKAGESPILTER );
			Sex = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, SysConst.PACKAGESPILTER );
			Title = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, SysConst.PACKAGESPILTER );
			Nationality = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, SysConst.PACKAGESPILTER );
			Birthday = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37,SysConst.PACKAGESPILTER));
			WorkingExperience= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,38,SysConst.PACKAGESPILTER))).intValue();
			LastJob = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, SysConst.PACKAGESPILTER );
			LastJobServiceYears= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,40,SysConst.PACKAGESPILTER))).intValue();
			InsuranceExperience = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, SysConst.PACKAGESPILTER );
			InsuranceExperienceYears= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,42,SysConst.PACKAGESPILTER))).intValue();
			EducationLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, SysConst.PACKAGESPILTER );
			AddressType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, SysConst.PACKAGESPILTER );
			AddressRoom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, SysConst.PACKAGESPILTER );
			AddressFloor = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, SysConst.PACKAGESPILTER );
			AddressBlock = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, SysConst.PACKAGESPILTER );
			AddressBuilding = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, SysConst.PACKAGESPILTER );
			AddressStreet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, SysConst.PACKAGESPILTER );
			AddressDistrict = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, SysConst.PACKAGESPILTER );
			FreeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, SysConst.PACKAGESPILTER );
			Phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, SysConst.PACKAGESPILTER );
			Mobile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, SysConst.PACKAGESPILTER );
			Email = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, SysConst.PACKAGESPILTER );
			CompanyEmail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, SysConst.PACKAGESPILTER );
			OfficeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, SysConst.PACKAGESPILTER );
			OfficeTel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, SysConst.PACKAGESPILTER );
			OfficeFaxNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, SysConst.PACKAGESPILTER );
			Marriage = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 59, SysConst.PACKAGESPILTER );
			SpouseName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 60, SysConst.PACKAGESPILTER );
			SpouseIDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, SysConst.PACKAGESPILTER );
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, SysConst.PACKAGESPILTER );
			GradeStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66,SysConst.PACKAGESPILTER));
			AgentSubGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, SysConst.PACKAGESPILTER );
			SubGradeStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68,SysConst.PACKAGESPILTER));
			EffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69,SysConst.PACKAGESPILTER));
			TransferEffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70,SysConst.PACKAGESPILTER));
			BranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, SysConst.PACKAGESPILTER );
			BranchLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, SysConst.PACKAGESPILTER );
			BranchName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, SysConst.PACKAGESPILTER );
			BranchNameEng = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, SysConst.PACKAGESPILTER );
			BranchNameChi = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, SysConst.PACKAGESPILTER );
			BranchEffDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76,SysConst.PACKAGESPILTER));
			BranchAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, SysConst.PACKAGESPILTER );
			BranchPhoneNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, SysConst.PACKAGESPILTER );
			BranchFaxNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, SysConst.PACKAGESPILTER );
			BranchLocation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, SysConst.PACKAGESPILTER );
			BranchStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, SysConst.PACKAGESPILTER );
			BranchTerminateEffDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82,SysConst.PACKAGESPILTER));
			BranchTerminateReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, SysConst.PACKAGESPILTER );
			DirectFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, SysConst.PACKAGESPILTER );
			UpAgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, SysConst.PACKAGESPILTER );
			BranchManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, SysConst.PACKAGESPILTER );
			UnitManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, SysConst.PACKAGESPILTER );
			DivisionManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, SysConst.PACKAGESPILTER );
			RegionManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, SysConst.PACKAGESPILTER );
			RecruitingAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, SysConst.PACKAGESPILTER );
			ReferringAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, SysConst.PACKAGESPILTER );
			DirectReportingAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, SysConst.PACKAGESPILTER );
			InirectReportingAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 94, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 95,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 96, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 97,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 98, SysConst.PACKAGESPILTER );
			LastJobNature = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 99, SysConst.PACKAGESPILTER );
			UnitBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 100, SysConst.PACKAGESPILTER );
			DivisionBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 101, SysConst.PACKAGESPILTER );
			RegionBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 102, SysConst.PACKAGESPILTER );
			OutWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 103,SysConst.PACKAGESPILTER));
			DummyGradeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 104, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentCSchema";
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
		if (FCode.equalsIgnoreCase("BakMonth"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakMonth));
		}
		if (FCode.equalsIgnoreCase("BakType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BakType));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("Password"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Password));
		}
		if (FCode.equalsIgnoreCase("AgentState"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentState));
		}
		if (FCode.equalsIgnoreCase("SurName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SurName));
		}
		if (FCode.equalsIgnoreCase("GivenName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GivenName));
		}
		if (FCode.equalsIgnoreCase("EnglishName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EnglishName));
		}
		if (FCode.equalsIgnoreCase("HKIDName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(HKIDName));
		}
		if (FCode.equalsIgnoreCase("ChineseName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ChineseName));
		}
		if (FCode.equalsIgnoreCase("IDType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDType));
		}
		if (FCode.equalsIgnoreCase("IDNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IDNo));
		}
		if (FCode.equalsIgnoreCase("WorkingVisa"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WorkingVisa));
		}
		if (FCode.equalsIgnoreCase("WorkingVisaExpiryDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getWorkingVisaExpiryDate()));
		}
		if (FCode.equalsIgnoreCase("WorkingVisaType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WorkingVisaType));
		}
		if (FCode.equalsIgnoreCase("Qualification"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Qualification));
		}
		if (FCode.equalsIgnoreCase("ContractType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContractType));
		}
		if (FCode.equalsIgnoreCase("ContractEffDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getContractEffDate()));
		}
		if (FCode.equalsIgnoreCase("ContractStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ContractStatus));
		}
		if (FCode.equalsIgnoreCase("RecruitmentProfile"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RecruitmentProfile));
		}
		if (FCode.equalsIgnoreCase("LastTerminationDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getLastTerminationDate()));
		}
		if (FCode.equalsIgnoreCase("LastTerminationReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LastTerminationReason));
		}
		if (FCode.equalsIgnoreCase("TerminationNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TerminationNo));
		}
		if (FCode.equalsIgnoreCase("PaymentMethod"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PaymentMethod));
		}
		if (FCode.equalsIgnoreCase("BankAccountName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BankAccountName));
		}
		if (FCode.equalsIgnoreCase("BankAccountNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BankAccountNo));
		}
		if (FCode.equalsIgnoreCase("WithheldReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WithheldReason));
		}
		if (FCode.equalsIgnoreCase("GuarantorAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GuarantorAgentCode));
		}
		if (FCode.equalsIgnoreCase("GuarantorAgentRelation"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GuarantorAgentRelation));
		}
		if (FCode.equalsIgnoreCase("GuarantorType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GuarantorType));
		}
		if (FCode.equalsIgnoreCase("Sex"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Sex));
		}
		if (FCode.equalsIgnoreCase("Title"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Title));
		}
		if (FCode.equalsIgnoreCase("Nationality"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Nationality));
		}
		if (FCode.equalsIgnoreCase("Birthday"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBirthday()));
		}
		if (FCode.equalsIgnoreCase("WorkingExperience"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WorkingExperience));
		}
		if (FCode.equalsIgnoreCase("LastJob"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LastJob));
		}
		if (FCode.equalsIgnoreCase("LastJobServiceYears"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LastJobServiceYears));
		}
		if (FCode.equalsIgnoreCase("InsuranceExperience"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuranceExperience));
		}
		if (FCode.equalsIgnoreCase("InsuranceExperienceYears"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuranceExperienceYears));
		}
		if (FCode.equalsIgnoreCase("EducationLevel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EducationLevel));
		}
		if (FCode.equalsIgnoreCase("AddressType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressType));
		}
		if (FCode.equalsIgnoreCase("AddressRoom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressRoom));
		}
		if (FCode.equalsIgnoreCase("AddressFloor"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressFloor));
		}
		if (FCode.equalsIgnoreCase("AddressBlock"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressBlock));
		}
		if (FCode.equalsIgnoreCase("AddressBuilding"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressBuilding));
		}
		if (FCode.equalsIgnoreCase("AddressStreet"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressStreet));
		}
		if (FCode.equalsIgnoreCase("AddressDistrict"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AddressDistrict));
		}
		if (FCode.equalsIgnoreCase("FreeAddress"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FreeAddress));
		}
		if (FCode.equalsIgnoreCase("Phone"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Phone));
		}
		if (FCode.equalsIgnoreCase("Mobile"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Mobile));
		}
		if (FCode.equalsIgnoreCase("Email"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Email));
		}
		if (FCode.equalsIgnoreCase("CompanyEmail"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CompanyEmail));
		}
		if (FCode.equalsIgnoreCase("OfficeAddress"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OfficeAddress));
		}
		if (FCode.equalsIgnoreCase("OfficeTel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OfficeTel));
		}
		if (FCode.equalsIgnoreCase("OfficeFaxNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OfficeFaxNo));
		}
		if (FCode.equalsIgnoreCase("Marriage"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Marriage));
		}
		if (FCode.equalsIgnoreCase("SpouseName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SpouseName));
		}
		if (FCode.equalsIgnoreCase("SpouseIDNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SpouseIDNo));
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
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("GradeStartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getGradeStartDate()));
		}
		if (FCode.equalsIgnoreCase("AgentSubGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentSubGrade));
		}
		if (FCode.equalsIgnoreCase("SubGradeStartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getSubGradeStartDate()));
		}
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
		}
		if (FCode.equalsIgnoreCase("TransferEffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getTransferEffectiveDate()));
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAttr));
		}
		if (FCode.equalsIgnoreCase("BranchLevel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchLevel));
		}
		if (FCode.equalsIgnoreCase("BranchName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchName));
		}
		if (FCode.equalsIgnoreCase("BranchNameEng"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchNameEng));
		}
		if (FCode.equalsIgnoreCase("BranchNameChi"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchNameChi));
		}
		if (FCode.equalsIgnoreCase("BranchEffDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBranchEffDate()));
		}
		if (FCode.equalsIgnoreCase("BranchAddress"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAddress));
		}
		if (FCode.equalsIgnoreCase("BranchPhoneNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchPhoneNo));
		}
		if (FCode.equalsIgnoreCase("BranchFaxNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchFaxNo));
		}
		if (FCode.equalsIgnoreCase("BranchLocation"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchLocation));
		}
		if (FCode.equalsIgnoreCase("BranchStatus"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchStatus));
		}
		if (FCode.equalsIgnoreCase("BranchTerminateEffDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getBranchTerminateEffDate()));
		}
		if (FCode.equalsIgnoreCase("BranchTerminateReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchTerminateReason));
		}
		if (FCode.equalsIgnoreCase("DirectFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DirectFlag));
		}
		if (FCode.equalsIgnoreCase("UpAgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UpAgentGroup));
		}
		if (FCode.equalsIgnoreCase("BranchManager"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchManager));
		}
		if (FCode.equalsIgnoreCase("UnitManager"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UnitManager));
		}
		if (FCode.equalsIgnoreCase("DivisionManager"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DivisionManager));
		}
		if (FCode.equalsIgnoreCase("RegionManager"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegionManager));
		}
		if (FCode.equalsIgnoreCase("RecruitingAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RecruitingAgentCode));
		}
		if (FCode.equalsIgnoreCase("ReferringAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReferringAgentCode));
		}
		if (FCode.equalsIgnoreCase("DirectReportingAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DirectReportingAgentCode));
		}
		if (FCode.equalsIgnoreCase("InirectReportingAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InirectReportingAgentCode));
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
		if (FCode.equalsIgnoreCase("LastJobNature"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LastJobNature));
		}
		if (FCode.equalsIgnoreCase("UnitBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UnitBranchAttr));
		}
		if (FCode.equalsIgnoreCase("DivisionBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DivisionBranchAttr));
		}
		if (FCode.equalsIgnoreCase("RegionBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegionBranchAttr));
		}
		if (FCode.equalsIgnoreCase("OutWorkDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getOutWorkDate()));
		}
		if (FCode.equalsIgnoreCase("DummyGradeFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DummyGradeFlag));
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
				strFieldValue = StrTool.GBKToUnicode(BakMonth);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(BakType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(Password);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(AgentState);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(SurName);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(GivenName);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(EnglishName);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(HKIDName);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(ChineseName);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(IDType);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(IDNo);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(WorkingVisa);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getWorkingVisaExpiryDate()));
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(WorkingVisaType);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(Qualification);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(ContractType);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getContractEffDate()));
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(ContractStatus);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(RecruitmentProfile);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getLastTerminationDate()));
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(LastTerminationReason);
				break;
			case 25:
				strFieldValue = String.valueOf(TerminationNo);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(PaymentMethod);
				break;
			case 27:
				strFieldValue = StrTool.GBKToUnicode(BankAccountName);
				break;
			case 28:
				strFieldValue = StrTool.GBKToUnicode(BankAccountNo);
				break;
			case 29:
				strFieldValue = StrTool.GBKToUnicode(WithheldReason);
				break;
			case 30:
				strFieldValue = StrTool.GBKToUnicode(GuarantorAgentCode);
				break;
			case 31:
				strFieldValue = StrTool.GBKToUnicode(GuarantorAgentRelation);
				break;
			case 32:
				strFieldValue = StrTool.GBKToUnicode(GuarantorType);
				break;
			case 33:
				strFieldValue = StrTool.GBKToUnicode(Sex);
				break;
			case 34:
				strFieldValue = StrTool.GBKToUnicode(Title);
				break;
			case 35:
				strFieldValue = StrTool.GBKToUnicode(Nationality);
				break;
			case 36:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBirthday()));
				break;
			case 37:
				strFieldValue = String.valueOf(WorkingExperience);
				break;
			case 38:
				strFieldValue = StrTool.GBKToUnicode(LastJob);
				break;
			case 39:
				strFieldValue = String.valueOf(LastJobServiceYears);
				break;
			case 40:
				strFieldValue = StrTool.GBKToUnicode(InsuranceExperience);
				break;
			case 41:
				strFieldValue = String.valueOf(InsuranceExperienceYears);
				break;
			case 42:
				strFieldValue = StrTool.GBKToUnicode(EducationLevel);
				break;
			case 43:
				strFieldValue = StrTool.GBKToUnicode(AddressType);
				break;
			case 44:
				strFieldValue = StrTool.GBKToUnicode(AddressRoom);
				break;
			case 45:
				strFieldValue = StrTool.GBKToUnicode(AddressFloor);
				break;
			case 46:
				strFieldValue = StrTool.GBKToUnicode(AddressBlock);
				break;
			case 47:
				strFieldValue = StrTool.GBKToUnicode(AddressBuilding);
				break;
			case 48:
				strFieldValue = StrTool.GBKToUnicode(AddressStreet);
				break;
			case 49:
				strFieldValue = StrTool.GBKToUnicode(AddressDistrict);
				break;
			case 50:
				strFieldValue = StrTool.GBKToUnicode(FreeAddress);
				break;
			case 51:
				strFieldValue = StrTool.GBKToUnicode(Phone);
				break;
			case 52:
				strFieldValue = StrTool.GBKToUnicode(Mobile);
				break;
			case 53:
				strFieldValue = StrTool.GBKToUnicode(Email);
				break;
			case 54:
				strFieldValue = StrTool.GBKToUnicode(CompanyEmail);
				break;
			case 55:
				strFieldValue = StrTool.GBKToUnicode(OfficeAddress);
				break;
			case 56:
				strFieldValue = StrTool.GBKToUnicode(OfficeTel);
				break;
			case 57:
				strFieldValue = StrTool.GBKToUnicode(OfficeFaxNo);
				break;
			case 58:
				strFieldValue = StrTool.GBKToUnicode(Marriage);
				break;
			case 59:
				strFieldValue = StrTool.GBKToUnicode(SpouseName);
				break;
			case 60:
				strFieldValue = StrTool.GBKToUnicode(SpouseIDNo);
				break;
			case 61:
				strFieldValue = StrTool.GBKToUnicode(Flag1);
				break;
			case 62:
				strFieldValue = StrTool.GBKToUnicode(Flag2);
				break;
			case 63:
				strFieldValue = StrTool.GBKToUnicode(Flag3);
				break;
			case 64:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 65:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getGradeStartDate()));
				break;
			case 66:
				strFieldValue = StrTool.GBKToUnicode(AgentSubGrade);
				break;
			case 67:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getSubGradeStartDate()));
				break;
			case 68:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
				break;
			case 69:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getTransferEffectiveDate()));
				break;
			case 70:
				strFieldValue = StrTool.GBKToUnicode(BranchAttr);
				break;
			case 71:
				strFieldValue = StrTool.GBKToUnicode(BranchLevel);
				break;
			case 72:
				strFieldValue = StrTool.GBKToUnicode(BranchName);
				break;
			case 73:
				strFieldValue = StrTool.GBKToUnicode(BranchNameEng);
				break;
			case 74:
				strFieldValue = StrTool.GBKToUnicode(BranchNameChi);
				break;
			case 75:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBranchEffDate()));
				break;
			case 76:
				strFieldValue = StrTool.GBKToUnicode(BranchAddress);
				break;
			case 77:
				strFieldValue = StrTool.GBKToUnicode(BranchPhoneNo);
				break;
			case 78:
				strFieldValue = StrTool.GBKToUnicode(BranchFaxNo);
				break;
			case 79:
				strFieldValue = StrTool.GBKToUnicode(BranchLocation);
				break;
			case 80:
				strFieldValue = StrTool.GBKToUnicode(BranchStatus);
				break;
			case 81:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getBranchTerminateEffDate()));
				break;
			case 82:
				strFieldValue = StrTool.GBKToUnicode(BranchTerminateReason);
				break;
			case 83:
				strFieldValue = StrTool.GBKToUnicode(DirectFlag);
				break;
			case 84:
				strFieldValue = StrTool.GBKToUnicode(UpAgentGroup);
				break;
			case 85:
				strFieldValue = StrTool.GBKToUnicode(BranchManager);
				break;
			case 86:
				strFieldValue = StrTool.GBKToUnicode(UnitManager);
				break;
			case 87:
				strFieldValue = StrTool.GBKToUnicode(DivisionManager);
				break;
			case 88:
				strFieldValue = StrTool.GBKToUnicode(RegionManager);
				break;
			case 89:
				strFieldValue = StrTool.GBKToUnicode(RecruitingAgentCode);
				break;
			case 90:
				strFieldValue = StrTool.GBKToUnicode(ReferringAgentCode);
				break;
			case 91:
				strFieldValue = StrTool.GBKToUnicode(DirectReportingAgentCode);
				break;
			case 92:
				strFieldValue = StrTool.GBKToUnicode(InirectReportingAgentCode);
				break;
			case 93:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 94:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 95:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 96:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 97:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 98:
				strFieldValue = StrTool.GBKToUnicode(LastJobNature);
				break;
			case 99:
				strFieldValue = StrTool.GBKToUnicode(UnitBranchAttr);
				break;
			case 100:
				strFieldValue = StrTool.GBKToUnicode(DivisionBranchAttr);
				break;
			case 101:
				strFieldValue = StrTool.GBKToUnicode(RegionBranchAttr);
				break;
			case 102:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getOutWorkDate()));
				break;
			case 103:
				strFieldValue = StrTool.GBKToUnicode(DummyGradeFlag);
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

		if (FCode.equalsIgnoreCase("BakMonth"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BakMonth = FValue.trim();
			}
			else
				BakMonth = null;
		}
		if (FCode.equalsIgnoreCase("BakType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BakType = FValue.trim();
			}
			else
				BakType = null;
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGroup = FValue.trim();
			}
			else
				AgentGroup = null;
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
		if (FCode.equalsIgnoreCase("Password"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Password = FValue.trim();
			}
			else
				Password = null;
		}
		if (FCode.equalsIgnoreCase("AgentState"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentState = FValue.trim();
			}
			else
				AgentState = null;
		}
		if (FCode.equalsIgnoreCase("SurName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SurName = FValue.trim();
			}
			else
				SurName = null;
		}
		if (FCode.equalsIgnoreCase("GivenName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GivenName = FValue.trim();
			}
			else
				GivenName = null;
		}
		if (FCode.equalsIgnoreCase("EnglishName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EnglishName = FValue.trim();
			}
			else
				EnglishName = null;
		}
		if (FCode.equalsIgnoreCase("HKIDName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				HKIDName = FValue.trim();
			}
			else
				HKIDName = null;
		}
		if (FCode.equalsIgnoreCase("ChineseName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ChineseName = FValue.trim();
			}
			else
				ChineseName = null;
		}
		if (FCode.equalsIgnoreCase("IDType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IDType = FValue.trim();
			}
			else
				IDType = null;
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
		if (FCode.equalsIgnoreCase("WorkingVisa"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WorkingVisa = FValue.trim();
			}
			else
				WorkingVisa = null;
		}
		if (FCode.equalsIgnoreCase("WorkingVisaExpiryDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				WorkingVisaExpiryDate = fDate.getDate( FValue );
			}
			else
				WorkingVisaExpiryDate = null;
		}
		if (FCode.equalsIgnoreCase("WorkingVisaType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WorkingVisaType = FValue.trim();
			}
			else
				WorkingVisaType = null;
		}
		if (FCode.equalsIgnoreCase("Qualification"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Qualification = FValue.trim();
			}
			else
				Qualification = null;
		}
		if (FCode.equalsIgnoreCase("ContractType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ContractType = FValue.trim();
			}
			else
				ContractType = null;
		}
		if (FCode.equalsIgnoreCase("ContractEffDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ContractEffDate = fDate.getDate( FValue );
			}
			else
				ContractEffDate = null;
		}
		if (FCode.equalsIgnoreCase("ContractStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ContractStatus = FValue.trim();
			}
			else
				ContractStatus = null;
		}
		if (FCode.equalsIgnoreCase("RecruitmentProfile"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RecruitmentProfile = FValue.trim();
			}
			else
				RecruitmentProfile = null;
		}
		if (FCode.equalsIgnoreCase("LastTerminationDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				LastTerminationDate = fDate.getDate( FValue );
			}
			else
				LastTerminationDate = null;
		}
		if (FCode.equalsIgnoreCase("LastTerminationReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LastTerminationReason = FValue.trim();
			}
			else
				LastTerminationReason = null;
		}
		if (FCode.equalsIgnoreCase("TerminationNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				TerminationNo = i;
			}
		}
		if (FCode.equalsIgnoreCase("PaymentMethod"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PaymentMethod = FValue.trim();
			}
			else
				PaymentMethod = null;
		}
		if (FCode.equalsIgnoreCase("BankAccountName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BankAccountName = FValue.trim();
			}
			else
				BankAccountName = null;
		}
		if (FCode.equalsIgnoreCase("BankAccountNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BankAccountNo = FValue.trim();
			}
			else
				BankAccountNo = null;
		}
		if (FCode.equalsIgnoreCase("WithheldReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WithheldReason = FValue.trim();
			}
			else
				WithheldReason = null;
		}
		if (FCode.equalsIgnoreCase("GuarantorAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GuarantorAgentCode = FValue.trim();
			}
			else
				GuarantorAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("GuarantorAgentRelation"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GuarantorAgentRelation = FValue.trim();
			}
			else
				GuarantorAgentRelation = null;
		}
		if (FCode.equalsIgnoreCase("GuarantorType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GuarantorType = FValue.trim();
			}
			else
				GuarantorType = null;
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
		if (FCode.equalsIgnoreCase("Title"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Title = FValue.trim();
			}
			else
				Title = null;
		}
		if (FCode.equalsIgnoreCase("Nationality"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Nationality = FValue.trim();
			}
			else
				Nationality = null;
		}
		if (FCode.equalsIgnoreCase("Birthday"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				Birthday = fDate.getDate( FValue );
			}
			else
				Birthday = null;
		}
		if (FCode.equalsIgnoreCase("WorkingExperience"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				WorkingExperience = i;
			}
		}
		if (FCode.equalsIgnoreCase("LastJob"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LastJob = FValue.trim();
			}
			else
				LastJob = null;
		}
		if (FCode.equalsIgnoreCase("LastJobServiceYears"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				LastJobServiceYears = i;
			}
		}
		if (FCode.equalsIgnoreCase("InsuranceExperience"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InsuranceExperience = FValue.trim();
			}
			else
				InsuranceExperience = null;
		}
		if (FCode.equalsIgnoreCase("InsuranceExperienceYears"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				InsuranceExperienceYears = i;
			}
		}
		if (FCode.equalsIgnoreCase("EducationLevel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EducationLevel = FValue.trim();
			}
			else
				EducationLevel = null;
		}
		if (FCode.equalsIgnoreCase("AddressType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AddressType = FValue.trim();
			}
			else
				AddressType = null;
		}
		if (FCode.equalsIgnoreCase("AddressRoom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AddressRoom = FValue.trim();
			}
			else
				AddressRoom = null;
		}
		if (FCode.equalsIgnoreCase("AddressFloor"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AddressFloor = FValue.trim();
			}
			else
				AddressFloor = null;
		}
		if (FCode.equalsIgnoreCase("AddressBlock"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AddressBlock = FValue.trim();
			}
			else
				AddressBlock = null;
		}
		if (FCode.equalsIgnoreCase("AddressBuilding"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AddressBuilding = FValue.trim();
			}
			else
				AddressBuilding = null;
		}
		if (FCode.equalsIgnoreCase("AddressStreet"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AddressStreet = FValue.trim();
			}
			else
				AddressStreet = null;
		}
		if (FCode.equalsIgnoreCase("AddressDistrict"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AddressDistrict = FValue.trim();
			}
			else
				AddressDistrict = null;
		}
		if (FCode.equalsIgnoreCase("FreeAddress"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FreeAddress = FValue.trim();
			}
			else
				FreeAddress = null;
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
		if (FCode.equalsIgnoreCase("Mobile"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Mobile = FValue.trim();
			}
			else
				Mobile = null;
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
		if (FCode.equalsIgnoreCase("CompanyEmail"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CompanyEmail = FValue.trim();
			}
			else
				CompanyEmail = null;
		}
		if (FCode.equalsIgnoreCase("OfficeAddress"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OfficeAddress = FValue.trim();
			}
			else
				OfficeAddress = null;
		}
		if (FCode.equalsIgnoreCase("OfficeTel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OfficeTel = FValue.trim();
			}
			else
				OfficeTel = null;
		}
		if (FCode.equalsIgnoreCase("OfficeFaxNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OfficeFaxNo = FValue.trim();
			}
			else
				OfficeFaxNo = null;
		}
		if (FCode.equalsIgnoreCase("Marriage"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Marriage = FValue.trim();
			}
			else
				Marriage = null;
		}
		if (FCode.equalsIgnoreCase("SpouseName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SpouseName = FValue.trim();
			}
			else
				SpouseName = null;
		}
		if (FCode.equalsIgnoreCase("SpouseIDNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SpouseIDNo = FValue.trim();
			}
			else
				SpouseIDNo = null;
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
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGrade = FValue.trim();
			}
			else
				AgentGrade = null;
		}
		if (FCode.equalsIgnoreCase("GradeStartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				GradeStartDate = fDate.getDate( FValue );
			}
			else
				GradeStartDate = null;
		}
		if (FCode.equalsIgnoreCase("AgentSubGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentSubGrade = FValue.trim();
			}
			else
				AgentSubGrade = null;
		}
		if (FCode.equalsIgnoreCase("SubGradeStartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				SubGradeStartDate = fDate.getDate( FValue );
			}
			else
				SubGradeStartDate = null;
		}
		if (FCode.equalsIgnoreCase("EffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				EffectiveDate = fDate.getDate( FValue );
			}
			else
				EffectiveDate = null;
		}
		if (FCode.equalsIgnoreCase("TransferEffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				TransferEffectiveDate = fDate.getDate( FValue );
			}
			else
				TransferEffectiveDate = null;
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchAttr = FValue.trim();
			}
			else
				BranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("BranchLevel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchLevel = FValue.trim();
			}
			else
				BranchLevel = null;
		}
		if (FCode.equalsIgnoreCase("BranchName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchName = FValue.trim();
			}
			else
				BranchName = null;
		}
		if (FCode.equalsIgnoreCase("BranchNameEng"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchNameEng = FValue.trim();
			}
			else
				BranchNameEng = null;
		}
		if (FCode.equalsIgnoreCase("BranchNameChi"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchNameChi = FValue.trim();
			}
			else
				BranchNameChi = null;
		}
		if (FCode.equalsIgnoreCase("BranchEffDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BranchEffDate = fDate.getDate( FValue );
			}
			else
				BranchEffDate = null;
		}
		if (FCode.equalsIgnoreCase("BranchAddress"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchAddress = FValue.trim();
			}
			else
				BranchAddress = null;
		}
		if (FCode.equalsIgnoreCase("BranchPhoneNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchPhoneNo = FValue.trim();
			}
			else
				BranchPhoneNo = null;
		}
		if (FCode.equalsIgnoreCase("BranchFaxNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchFaxNo = FValue.trim();
			}
			else
				BranchFaxNo = null;
		}
		if (FCode.equalsIgnoreCase("BranchLocation"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchLocation = FValue.trim();
			}
			else
				BranchLocation = null;
		}
		if (FCode.equalsIgnoreCase("BranchStatus"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchStatus = FValue.trim();
			}
			else
				BranchStatus = null;
		}
		if (FCode.equalsIgnoreCase("BranchTerminateEffDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				BranchTerminateEffDate = fDate.getDate( FValue );
			}
			else
				BranchTerminateEffDate = null;
		}
		if (FCode.equalsIgnoreCase("BranchTerminateReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchTerminateReason = FValue.trim();
			}
			else
				BranchTerminateReason = null;
		}
		if (FCode.equalsIgnoreCase("DirectFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DirectFlag = FValue.trim();
			}
			else
				DirectFlag = null;
		}
		if (FCode.equalsIgnoreCase("UpAgentGroup"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UpAgentGroup = FValue.trim();
			}
			else
				UpAgentGroup = null;
		}
		if (FCode.equalsIgnoreCase("BranchManager"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchManager = FValue.trim();
			}
			else
				BranchManager = null;
		}
		if (FCode.equalsIgnoreCase("UnitManager"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UnitManager = FValue.trim();
			}
			else
				UnitManager = null;
		}
		if (FCode.equalsIgnoreCase("DivisionManager"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DivisionManager = FValue.trim();
			}
			else
				DivisionManager = null;
		}
		if (FCode.equalsIgnoreCase("RegionManager"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegionManager = FValue.trim();
			}
			else
				RegionManager = null;
		}
		if (FCode.equalsIgnoreCase("RecruitingAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RecruitingAgentCode = FValue.trim();
			}
			else
				RecruitingAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("ReferringAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ReferringAgentCode = FValue.trim();
			}
			else
				ReferringAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("DirectReportingAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DirectReportingAgentCode = FValue.trim();
			}
			else
				DirectReportingAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("InirectReportingAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InirectReportingAgentCode = FValue.trim();
			}
			else
				InirectReportingAgentCode = null;
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
		if (FCode.equalsIgnoreCase("LastJobNature"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LastJobNature = FValue.trim();
			}
			else
				LastJobNature = null;
		}
		if (FCode.equalsIgnoreCase("UnitBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UnitBranchAttr = FValue.trim();
			}
			else
				UnitBranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("DivisionBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DivisionBranchAttr = FValue.trim();
			}
			else
				DivisionBranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("RegionBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegionBranchAttr = FValue.trim();
			}
			else
				RegionBranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("OutWorkDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				OutWorkDate = fDate.getDate( FValue );
			}
			else
				OutWorkDate = null;
		}
		if (FCode.equalsIgnoreCase("DummyGradeFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DummyGradeFlag = FValue.trim();
			}
			else
				DummyGradeFlag = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAAgentCSchema other = (LAAgentCSchema)otherObject;
		return
			BakMonth.equals(other.getBakMonth())
			&& BakType.equals(other.getBakType())
			&& AgentCode.equals(other.getAgentCode())
			&& BranchType.equals(other.getBranchType())
			&& AgentGroup.equals(other.getAgentGroup())
			&& ManageCom.equals(other.getManageCom())
			&& Password.equals(other.getPassword())
			&& AgentState.equals(other.getAgentState())
			&& SurName.equals(other.getSurName())
			&& GivenName.equals(other.getGivenName())
			&& EnglishName.equals(other.getEnglishName())
			&& HKIDName.equals(other.getHKIDName())
			&& ChineseName.equals(other.getChineseName())
			&& IDType.equals(other.getIDType())
			&& IDNo.equals(other.getIDNo())
			&& WorkingVisa.equals(other.getWorkingVisa())
			&& fDate.getString(WorkingVisaExpiryDate).equals(other.getWorkingVisaExpiryDate())
			&& WorkingVisaType.equals(other.getWorkingVisaType())
			&& Qualification.equals(other.getQualification())
			&& ContractType.equals(other.getContractType())
			&& fDate.getString(ContractEffDate).equals(other.getContractEffDate())
			&& ContractStatus.equals(other.getContractStatus())
			&& RecruitmentProfile.equals(other.getRecruitmentProfile())
			&& fDate.getString(LastTerminationDate).equals(other.getLastTerminationDate())
			&& LastTerminationReason.equals(other.getLastTerminationReason())
			&& TerminationNo == other.getTerminationNo()
			&& PaymentMethod.equals(other.getPaymentMethod())
			&& BankAccountName.equals(other.getBankAccountName())
			&& BankAccountNo.equals(other.getBankAccountNo())
			&& WithheldReason.equals(other.getWithheldReason())
			&& GuarantorAgentCode.equals(other.getGuarantorAgentCode())
			&& GuarantorAgentRelation.equals(other.getGuarantorAgentRelation())
			&& GuarantorType.equals(other.getGuarantorType())
			&& Sex.equals(other.getSex())
			&& Title.equals(other.getTitle())
			&& Nationality.equals(other.getNationality())
			&& fDate.getString(Birthday).equals(other.getBirthday())
			&& WorkingExperience == other.getWorkingExperience()
			&& LastJob.equals(other.getLastJob())
			&& LastJobServiceYears == other.getLastJobServiceYears()
			&& InsuranceExperience.equals(other.getInsuranceExperience())
			&& InsuranceExperienceYears == other.getInsuranceExperienceYears()
			&& EducationLevel.equals(other.getEducationLevel())
			&& AddressType.equals(other.getAddressType())
			&& AddressRoom.equals(other.getAddressRoom())
			&& AddressFloor.equals(other.getAddressFloor())
			&& AddressBlock.equals(other.getAddressBlock())
			&& AddressBuilding.equals(other.getAddressBuilding())
			&& AddressStreet.equals(other.getAddressStreet())
			&& AddressDistrict.equals(other.getAddressDistrict())
			&& FreeAddress.equals(other.getFreeAddress())
			&& Phone.equals(other.getPhone())
			&& Mobile.equals(other.getMobile())
			&& Email.equals(other.getEmail())
			&& CompanyEmail.equals(other.getCompanyEmail())
			&& OfficeAddress.equals(other.getOfficeAddress())
			&& OfficeTel.equals(other.getOfficeTel())
			&& OfficeFaxNo.equals(other.getOfficeFaxNo())
			&& Marriage.equals(other.getMarriage())
			&& SpouseName.equals(other.getSpouseName())
			&& SpouseIDNo.equals(other.getSpouseIDNo())
			&& Flag1.equals(other.getFlag1())
			&& Flag2.equals(other.getFlag2())
			&& Flag3.equals(other.getFlag3())
			&& AgentGrade.equals(other.getAgentGrade())
			&& fDate.getString(GradeStartDate).equals(other.getGradeStartDate())
			&& AgentSubGrade.equals(other.getAgentSubGrade())
			&& fDate.getString(SubGradeStartDate).equals(other.getSubGradeStartDate())
			&& fDate.getString(EffectiveDate).equals(other.getEffectiveDate())
			&& fDate.getString(TransferEffectiveDate).equals(other.getTransferEffectiveDate())
			&& BranchAttr.equals(other.getBranchAttr())
			&& BranchLevel.equals(other.getBranchLevel())
			&& BranchName.equals(other.getBranchName())
			&& BranchNameEng.equals(other.getBranchNameEng())
			&& BranchNameChi.equals(other.getBranchNameChi())
			&& fDate.getString(BranchEffDate).equals(other.getBranchEffDate())
			&& BranchAddress.equals(other.getBranchAddress())
			&& BranchPhoneNo.equals(other.getBranchPhoneNo())
			&& BranchFaxNo.equals(other.getBranchFaxNo())
			&& BranchLocation.equals(other.getBranchLocation())
			&& BranchStatus.equals(other.getBranchStatus())
			&& fDate.getString(BranchTerminateEffDate).equals(other.getBranchTerminateEffDate())
			&& BranchTerminateReason.equals(other.getBranchTerminateReason())
			&& DirectFlag.equals(other.getDirectFlag())
			&& UpAgentGroup.equals(other.getUpAgentGroup())
			&& BranchManager.equals(other.getBranchManager())
			&& UnitManager.equals(other.getUnitManager())
			&& DivisionManager.equals(other.getDivisionManager())
			&& RegionManager.equals(other.getRegionManager())
			&& RecruitingAgentCode.equals(other.getRecruitingAgentCode())
			&& ReferringAgentCode.equals(other.getReferringAgentCode())
			&& DirectReportingAgentCode.equals(other.getDirectReportingAgentCode())
			&& InirectReportingAgentCode.equals(other.getInirectReportingAgentCode())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& LastJobNature.equals(other.getLastJobNature())
			&& UnitBranchAttr.equals(other.getUnitBranchAttr())
			&& DivisionBranchAttr.equals(other.getDivisionBranchAttr())
			&& RegionBranchAttr.equals(other.getRegionBranchAttr())
			&& fDate.getString(OutWorkDate).equals(other.getOutWorkDate())
			&& DummyGradeFlag.equals(other.getDummyGradeFlag());
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
		if( strFieldName.equals("BakMonth") ) {
			return 0;
		}
		if( strFieldName.equals("BakType") ) {
			return 1;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 2;
		}
		if( strFieldName.equals("BranchType") ) {
			return 3;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 4;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 5;
		}
		if( strFieldName.equals("Password") ) {
			return 6;
		}
		if( strFieldName.equals("AgentState") ) {
			return 7;
		}
		if( strFieldName.equals("SurName") ) {
			return 8;
		}
		if( strFieldName.equals("GivenName") ) {
			return 9;
		}
		if( strFieldName.equals("EnglishName") ) {
			return 10;
		}
		if( strFieldName.equals("HKIDName") ) {
			return 11;
		}
		if( strFieldName.equals("ChineseName") ) {
			return 12;
		}
		if( strFieldName.equals("IDType") ) {
			return 13;
		}
		if( strFieldName.equals("IDNo") ) {
			return 14;
		}
		if( strFieldName.equals("WorkingVisa") ) {
			return 15;
		}
		if( strFieldName.equals("WorkingVisaExpiryDate") ) {
			return 16;
		}
		if( strFieldName.equals("WorkingVisaType") ) {
			return 17;
		}
		if( strFieldName.equals("Qualification") ) {
			return 18;
		}
		if( strFieldName.equals("ContractType") ) {
			return 19;
		}
		if( strFieldName.equals("ContractEffDate") ) {
			return 20;
		}
		if( strFieldName.equals("ContractStatus") ) {
			return 21;
		}
		if( strFieldName.equals("RecruitmentProfile") ) {
			return 22;
		}
		if( strFieldName.equals("LastTerminationDate") ) {
			return 23;
		}
		if( strFieldName.equals("LastTerminationReason") ) {
			return 24;
		}
		if( strFieldName.equals("TerminationNo") ) {
			return 25;
		}
		if( strFieldName.equals("PaymentMethod") ) {
			return 26;
		}
		if( strFieldName.equals("BankAccountName") ) {
			return 27;
		}
		if( strFieldName.equals("BankAccountNo") ) {
			return 28;
		}
		if( strFieldName.equals("WithheldReason") ) {
			return 29;
		}
		if( strFieldName.equals("GuarantorAgentCode") ) {
			return 30;
		}
		if( strFieldName.equals("GuarantorAgentRelation") ) {
			return 31;
		}
		if( strFieldName.equals("GuarantorType") ) {
			return 32;
		}
		if( strFieldName.equals("Sex") ) {
			return 33;
		}
		if( strFieldName.equals("Title") ) {
			return 34;
		}
		if( strFieldName.equals("Nationality") ) {
			return 35;
		}
		if( strFieldName.equals("Birthday") ) {
			return 36;
		}
		if( strFieldName.equals("WorkingExperience") ) {
			return 37;
		}
		if( strFieldName.equals("LastJob") ) {
			return 38;
		}
		if( strFieldName.equals("LastJobServiceYears") ) {
			return 39;
		}
		if( strFieldName.equals("InsuranceExperience") ) {
			return 40;
		}
		if( strFieldName.equals("InsuranceExperienceYears") ) {
			return 41;
		}
		if( strFieldName.equals("EducationLevel") ) {
			return 42;
		}
		if( strFieldName.equals("AddressType") ) {
			return 43;
		}
		if( strFieldName.equals("AddressRoom") ) {
			return 44;
		}
		if( strFieldName.equals("AddressFloor") ) {
			return 45;
		}
		if( strFieldName.equals("AddressBlock") ) {
			return 46;
		}
		if( strFieldName.equals("AddressBuilding") ) {
			return 47;
		}
		if( strFieldName.equals("AddressStreet") ) {
			return 48;
		}
		if( strFieldName.equals("AddressDistrict") ) {
			return 49;
		}
		if( strFieldName.equals("FreeAddress") ) {
			return 50;
		}
		if( strFieldName.equals("Phone") ) {
			return 51;
		}
		if( strFieldName.equals("Mobile") ) {
			return 52;
		}
		if( strFieldName.equals("Email") ) {
			return 53;
		}
		if( strFieldName.equals("CompanyEmail") ) {
			return 54;
		}
		if( strFieldName.equals("OfficeAddress") ) {
			return 55;
		}
		if( strFieldName.equals("OfficeTel") ) {
			return 56;
		}
		if( strFieldName.equals("OfficeFaxNo") ) {
			return 57;
		}
		if( strFieldName.equals("Marriage") ) {
			return 58;
		}
		if( strFieldName.equals("SpouseName") ) {
			return 59;
		}
		if( strFieldName.equals("SpouseIDNo") ) {
			return 60;
		}
		if( strFieldName.equals("Flag1") ) {
			return 61;
		}
		if( strFieldName.equals("Flag2") ) {
			return 62;
		}
		if( strFieldName.equals("Flag3") ) {
			return 63;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 64;
		}
		if( strFieldName.equals("GradeStartDate") ) {
			return 65;
		}
		if( strFieldName.equals("AgentSubGrade") ) {
			return 66;
		}
		if( strFieldName.equals("SubGradeStartDate") ) {
			return 67;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return 68;
		}
		if( strFieldName.equals("TransferEffectiveDate") ) {
			return 69;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return 70;
		}
		if( strFieldName.equals("BranchLevel") ) {
			return 71;
		}
		if( strFieldName.equals("BranchName") ) {
			return 72;
		}
		if( strFieldName.equals("BranchNameEng") ) {
			return 73;
		}
		if( strFieldName.equals("BranchNameChi") ) {
			return 74;
		}
		if( strFieldName.equals("BranchEffDate") ) {
			return 75;
		}
		if( strFieldName.equals("BranchAddress") ) {
			return 76;
		}
		if( strFieldName.equals("BranchPhoneNo") ) {
			return 77;
		}
		if( strFieldName.equals("BranchFaxNo") ) {
			return 78;
		}
		if( strFieldName.equals("BranchLocation") ) {
			return 79;
		}
		if( strFieldName.equals("BranchStatus") ) {
			return 80;
		}
		if( strFieldName.equals("BranchTerminateEffDate") ) {
			return 81;
		}
		if( strFieldName.equals("BranchTerminateReason") ) {
			return 82;
		}
		if( strFieldName.equals("DirectFlag") ) {
			return 83;
		}
		if( strFieldName.equals("UpAgentGroup") ) {
			return 84;
		}
		if( strFieldName.equals("BranchManager") ) {
			return 85;
		}
		if( strFieldName.equals("UnitManager") ) {
			return 86;
		}
		if( strFieldName.equals("DivisionManager") ) {
			return 87;
		}
		if( strFieldName.equals("RegionManager") ) {
			return 88;
		}
		if( strFieldName.equals("RecruitingAgentCode") ) {
			return 89;
		}
		if( strFieldName.equals("ReferringAgentCode") ) {
			return 90;
		}
		if( strFieldName.equals("DirectReportingAgentCode") ) {
			return 91;
		}
		if( strFieldName.equals("InirectReportingAgentCode") ) {
			return 92;
		}
		if( strFieldName.equals("Operator") ) {
			return 93;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 94;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 95;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 96;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 97;
		}
		if( strFieldName.equals("LastJobNature") ) {
			return 98;
		}
		if( strFieldName.equals("UnitBranchAttr") ) {
			return 99;
		}
		if( strFieldName.equals("DivisionBranchAttr") ) {
			return 100;
		}
		if( strFieldName.equals("RegionBranchAttr") ) {
			return 101;
		}
		if( strFieldName.equals("OutWorkDate") ) {
			return 102;
		}
		if( strFieldName.equals("DummyGradeFlag") ) {
			return 103;
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
				strFieldName = "BakMonth";
				break;
			case 1:
				strFieldName = "BakType";
				break;
			case 2:
				strFieldName = "AgentCode";
				break;
			case 3:
				strFieldName = "BranchType";
				break;
			case 4:
				strFieldName = "AgentGroup";
				break;
			case 5:
				strFieldName = "ManageCom";
				break;
			case 6:
				strFieldName = "Password";
				break;
			case 7:
				strFieldName = "AgentState";
				break;
			case 8:
				strFieldName = "SurName";
				break;
			case 9:
				strFieldName = "GivenName";
				break;
			case 10:
				strFieldName = "EnglishName";
				break;
			case 11:
				strFieldName = "HKIDName";
				break;
			case 12:
				strFieldName = "ChineseName";
				break;
			case 13:
				strFieldName = "IDType";
				break;
			case 14:
				strFieldName = "IDNo";
				break;
			case 15:
				strFieldName = "WorkingVisa";
				break;
			case 16:
				strFieldName = "WorkingVisaExpiryDate";
				break;
			case 17:
				strFieldName = "WorkingVisaType";
				break;
			case 18:
				strFieldName = "Qualification";
				break;
			case 19:
				strFieldName = "ContractType";
				break;
			case 20:
				strFieldName = "ContractEffDate";
				break;
			case 21:
				strFieldName = "ContractStatus";
				break;
			case 22:
				strFieldName = "RecruitmentProfile";
				break;
			case 23:
				strFieldName = "LastTerminationDate";
				break;
			case 24:
				strFieldName = "LastTerminationReason";
				break;
			case 25:
				strFieldName = "TerminationNo";
				break;
			case 26:
				strFieldName = "PaymentMethod";
				break;
			case 27:
				strFieldName = "BankAccountName";
				break;
			case 28:
				strFieldName = "BankAccountNo";
				break;
			case 29:
				strFieldName = "WithheldReason";
				break;
			case 30:
				strFieldName = "GuarantorAgentCode";
				break;
			case 31:
				strFieldName = "GuarantorAgentRelation";
				break;
			case 32:
				strFieldName = "GuarantorType";
				break;
			case 33:
				strFieldName = "Sex";
				break;
			case 34:
				strFieldName = "Title";
				break;
			case 35:
				strFieldName = "Nationality";
				break;
			case 36:
				strFieldName = "Birthday";
				break;
			case 37:
				strFieldName = "WorkingExperience";
				break;
			case 38:
				strFieldName = "LastJob";
				break;
			case 39:
				strFieldName = "LastJobServiceYears";
				break;
			case 40:
				strFieldName = "InsuranceExperience";
				break;
			case 41:
				strFieldName = "InsuranceExperienceYears";
				break;
			case 42:
				strFieldName = "EducationLevel";
				break;
			case 43:
				strFieldName = "AddressType";
				break;
			case 44:
				strFieldName = "AddressRoom";
				break;
			case 45:
				strFieldName = "AddressFloor";
				break;
			case 46:
				strFieldName = "AddressBlock";
				break;
			case 47:
				strFieldName = "AddressBuilding";
				break;
			case 48:
				strFieldName = "AddressStreet";
				break;
			case 49:
				strFieldName = "AddressDistrict";
				break;
			case 50:
				strFieldName = "FreeAddress";
				break;
			case 51:
				strFieldName = "Phone";
				break;
			case 52:
				strFieldName = "Mobile";
				break;
			case 53:
				strFieldName = "Email";
				break;
			case 54:
				strFieldName = "CompanyEmail";
				break;
			case 55:
				strFieldName = "OfficeAddress";
				break;
			case 56:
				strFieldName = "OfficeTel";
				break;
			case 57:
				strFieldName = "OfficeFaxNo";
				break;
			case 58:
				strFieldName = "Marriage";
				break;
			case 59:
				strFieldName = "SpouseName";
				break;
			case 60:
				strFieldName = "SpouseIDNo";
				break;
			case 61:
				strFieldName = "Flag1";
				break;
			case 62:
				strFieldName = "Flag2";
				break;
			case 63:
				strFieldName = "Flag3";
				break;
			case 64:
				strFieldName = "AgentGrade";
				break;
			case 65:
				strFieldName = "GradeStartDate";
				break;
			case 66:
				strFieldName = "AgentSubGrade";
				break;
			case 67:
				strFieldName = "SubGradeStartDate";
				break;
			case 68:
				strFieldName = "EffectiveDate";
				break;
			case 69:
				strFieldName = "TransferEffectiveDate";
				break;
			case 70:
				strFieldName = "BranchAttr";
				break;
			case 71:
				strFieldName = "BranchLevel";
				break;
			case 72:
				strFieldName = "BranchName";
				break;
			case 73:
				strFieldName = "BranchNameEng";
				break;
			case 74:
				strFieldName = "BranchNameChi";
				break;
			case 75:
				strFieldName = "BranchEffDate";
				break;
			case 76:
				strFieldName = "BranchAddress";
				break;
			case 77:
				strFieldName = "BranchPhoneNo";
				break;
			case 78:
				strFieldName = "BranchFaxNo";
				break;
			case 79:
				strFieldName = "BranchLocation";
				break;
			case 80:
				strFieldName = "BranchStatus";
				break;
			case 81:
				strFieldName = "BranchTerminateEffDate";
				break;
			case 82:
				strFieldName = "BranchTerminateReason";
				break;
			case 83:
				strFieldName = "DirectFlag";
				break;
			case 84:
				strFieldName = "UpAgentGroup";
				break;
			case 85:
				strFieldName = "BranchManager";
				break;
			case 86:
				strFieldName = "UnitManager";
				break;
			case 87:
				strFieldName = "DivisionManager";
				break;
			case 88:
				strFieldName = "RegionManager";
				break;
			case 89:
				strFieldName = "RecruitingAgentCode";
				break;
			case 90:
				strFieldName = "ReferringAgentCode";
				break;
			case 91:
				strFieldName = "DirectReportingAgentCode";
				break;
			case 92:
				strFieldName = "InirectReportingAgentCode";
				break;
			case 93:
				strFieldName = "Operator";
				break;
			case 94:
				strFieldName = "MakeDate";
				break;
			case 95:
				strFieldName = "MakeTime";
				break;
			case 96:
				strFieldName = "ModifyDate";
				break;
			case 97:
				strFieldName = "ModifyTime";
				break;
			case 98:
				strFieldName = "LastJobNature";
				break;
			case 99:
				strFieldName = "UnitBranchAttr";
				break;
			case 100:
				strFieldName = "DivisionBranchAttr";
				break;
			case 101:
				strFieldName = "RegionBranchAttr";
				break;
			case 102:
				strFieldName = "OutWorkDate";
				break;
			case 103:
				strFieldName = "DummyGradeFlag";
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
		if( strFieldName.equals("BakMonth") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BakType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Password") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentState") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SurName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GivenName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EnglishName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("HKIDName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ChineseName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IDType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IDNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WorkingVisa") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WorkingVisaExpiryDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("WorkingVisaType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Qualification") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ContractType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ContractEffDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ContractStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RecruitmentProfile") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LastTerminationDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("LastTerminationReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TerminationNo") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("PaymentMethod") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BankAccountName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BankAccountNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WithheldReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GuarantorAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GuarantorAgentRelation") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GuarantorType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Sex") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Title") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Nationality") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Birthday") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("WorkingExperience") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("LastJob") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LastJobServiceYears") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("InsuranceExperience") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InsuranceExperienceYears") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("EducationLevel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AddressType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AddressRoom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AddressFloor") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AddressBlock") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AddressBuilding") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AddressStreet") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AddressDistrict") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FreeAddress") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Phone") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Mobile") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Email") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CompanyEmail") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OfficeAddress") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OfficeTel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OfficeFaxNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Marriage") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SpouseName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SpouseIDNo") ) {
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
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeStartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("AgentSubGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubGradeStartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("TransferEffectiveDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchLevel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchNameEng") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchNameChi") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchEffDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BranchAddress") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchPhoneNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchFaxNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchLocation") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchStatus") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchTerminateEffDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("BranchTerminateReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DirectFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UpAgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchManager") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UnitManager") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DivisionManager") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RegionManager") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RecruitingAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReferringAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DirectReportingAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InirectReportingAgentCode") ) {
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
		if( strFieldName.equals("LastJobNature") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UnitBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DivisionBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RegionBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OutWorkDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("DummyGradeFlag") ) {
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
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_INT;
				break;
			case 26:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 27:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 28:
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 37:
				nFieldType = Schema.TYPE_INT;
				break;
			case 38:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 39:
				nFieldType = Schema.TYPE_INT;
				break;
			case 40:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 41:
				nFieldType = Schema.TYPE_INT;
				break;
			case 42:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 43:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 44:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 45:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 46:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 47:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 48:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 49:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 50:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 51:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 52:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 53:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 54:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 55:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 56:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 57:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 58:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 59:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 60:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 61:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 62:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 63:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 64:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 65:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 66:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 67:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 68:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 69:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 70:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 71:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 72:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 73:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 74:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 75:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 76:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 77:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 78:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 79:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 80:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 81:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 82:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 83:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 84:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 85:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 86:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 87:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 88:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 89:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 90:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 91:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 92:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 93:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 94:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 95:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 96:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 97:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 98:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 99:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 100:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 101:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 102:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 103:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
