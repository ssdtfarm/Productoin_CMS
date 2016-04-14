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
import com.sinosoft.lis.db.LAAgentDB;

/*
 * <p>ClassName: LAAgentSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAgentSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Branchtype */
	private String BranchType;
	/** Agentgroup */
	private String AgentGroup;
	/** Managecom */
	private String ManageCom;
	/** Password */
	private String Password;
	/** Agentstate */
	private String AgentState;
	/** Surname */
	private String SurName;
	/** Givenname */
	private String GivenName;
	/** Englishname */
	private String EnglishName;
	/** Hkidname */
	private String HKIDName;
	/** Chinesename */
	private String ChineseName;
	/** Idtype */
	private String IDType;
	/** Idno */
	private String IDNo;
	/** Workingvisa */
	private String WorkingVisa;
	/** Workingvisaexpirydate */
	private Date WorkingVisaExpiryDate;
	/** Workingvisatype */
	private String WorkingVisaType;
	/** Qualification */
	private String Qualification;
	/** Contracttype */
	private String ContractType;
	/** Contracteffdate */
	private Date ContractEffDate;
	/** Contractstatus */
	private String ContractStatus;
	/** Recruitmentprofile */
	private String RecruitmentProfile;
	/** Recruitingagentcode */
	private String RecruitingAgentCode;
	/** Referringagentcode */
	private String ReferringAgentCode;
	/** Lastterminationdate */
	private Date LastTerminationDate;
	/** Lastterminationreason */
	private String LastTerminationReason;
	/** Terminationno */
	private int TerminationNo;
	/** Paymentmethod */
	private String PaymentMethod;
	/** Bankaccountname */
	private String BankAccountName;
	/** Bankaccountno */
	private String BankAccountNo;
	/** Withheldreason */
	private String WithheldReason;
	/** Guarantoragentcode */
	private String GuarantorAgentCode;
	/** Guarantoragentrelation */
	private String GuarantorAgentRelation;
	/** Guarantortype */
	private String GuarantorType;
	/** Sex */
	private String Sex;
	/** Title */
	private String Title;
	/** Nationality */
	private String Nationality;
	/** Birthday */
	private Date Birthday;
	/** Workingexperience */
	private int WorkingExperience;
	/** Lastjob */
	private String LastJob;
	/** Lastjobserviceyears */
	private int LastJobServiceYears;
	/** Insuranceexperience */
	private String InsuranceExperience;
	/** Insuranceexperienceyears */
	private int InsuranceExperienceYears;
	/** Educationlevel */
	private String EducationLevel;
	/** Addresstype */
	private String AddressType;
	/** Addressroom */
	private String AddressRoom;
	/** Addressfloor */
	private String AddressFloor;
	/** Addressblock */
	private String AddressBlock;
	/** Addressbuilding */
	private String AddressBuilding;
	/** Addressstreet */
	private String AddressStreet;
	/** Addressdistrict */
	private String AddressDistrict;
	/** Freeaddress */
	private String FreeAddress;
	/** Phone */
	private String Phone;
	/** Mobile */
	private String Mobile;
	/** Email */
	private String Email;
	/** Companyemail */
	private String CompanyEmail;
	/** Officeaddress */
	private String OfficeAddress;
	/** Officetel */
	private String OfficeTel;
	/** Officefaxno */
	private String OfficeFaxNo;
	/** Marriage */
	private String Marriage;
	/** Spousename */
	private String SpouseName;
	/** Spouseidno */
	private String SpouseIDNo;
	/** Flag1 */
	private String Flag1;
	/** Flag2 */
	private String Flag2;
	/** Flag3 */
	private String Flag3;
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

	public static final int FIELDNUM = 70;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "AgentCode";

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
		LAAgentSchema cloned = (LAAgentSchema)super.clone();
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
	* 代理人编码--手动录入
	*/
	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>12)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值12");
		AgentCode = aAgentCode;
	}
	/**
	* BranchType--默认为--‘1’
	*/
	public String getBranchType()
	{
		return BranchType;
	}
	public void setBranchType(String aBranchType)
	{
		if(aBranchType!=null && aBranchType.length()>2)
			throw new IllegalArgumentException("BranchtypeBranchType值"+aBranchType+"的长度"+aBranchType.length()+"大于最大值2");
		BranchType = aBranchType;
	}
	/**
	* AgentGroup--代理人所属组
	*/
	public String getAgentGroup()
	{
		return AgentGroup;
	}
	public void setAgentGroup(String aAgentGroup)
	{
		if(aAgentGroup!=null && aAgentGroup.length()>20)
			throw new IllegalArgumentException("AgentgroupAgentGroup值"+aAgentGroup+"的长度"+aAgentGroup.length()+"大于最大值20");
		AgentGroup = aAgentGroup;
	}
	/**
	* ManageCom
	*/
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
	/**
	* Password
	*/
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String aPassword)
	{
		if(aPassword!=null && aPassword.length()>40)
			throw new IllegalArgumentException("PasswordPassword值"+aPassword+"的长度"+aPassword.length()+"大于最大值40");
		Password = aPassword;
	}
	/**
	* 代理人状态-01第一次入职，02-多次入职，03-离职
	*/
	public String getAgentState()
	{
		return AgentState;
	}
	public void setAgentState(String aAgentState)
	{
		if(aAgentState!=null && aAgentState.length()>2)
			throw new IllegalArgumentException("AgentstateAgentState值"+aAgentState+"的长度"+aAgentState.length()+"大于最大值2");
		AgentState = aAgentState;
	}
	/**
	* 姓【Agent Surname】
	*/
	public String getSurName()
	{
		return SurName;
	}
	public void setSurName(String aSurName)
	{
		if(aSurName!=null && aSurName.length()>20)
			throw new IllegalArgumentException("SurnameSurName值"+aSurName+"的长度"+aSurName.length()+"大于最大值20");
		SurName = aSurName;
	}
	/**
	* 教名【Agent Given Name】
	*/
	public String getGivenName()
	{
		return GivenName;
	}
	public void setGivenName(String aGivenName)
	{
		if(aGivenName!=null && aGivenName.length()>50)
			throw new IllegalArgumentException("GivennameGivenName值"+aGivenName+"的长度"+aGivenName.length()+"大于最大值50");
		GivenName = aGivenName;
	}
	/**
	* 英文名【Agent English Name】
	*/
	public String getEnglishName()
	{
		return EnglishName;
	}
	public void setEnglishName(String aEnglishName)
	{
		if(aEnglishName!=null && aEnglishName.length()>30)
			throw new IllegalArgumentException("EnglishnameEnglishName值"+aEnglishName+"的长度"+aEnglishName.length()+"大于最大值30");
		EnglishName = aEnglishName;
	}
	/**
	* HKID姓名【Agent HKID Name】
	*/
	public String getHKIDName()
	{
		return HKIDName;
	}
	public void setHKIDName(String aHKIDName)
	{
		if(aHKIDName!=null && aHKIDName.length()>40)
			throw new IllegalArgumentException("HkidnameHKIDName值"+aHKIDName+"的长度"+aHKIDName.length()+"大于最大值40");
		HKIDName = aHKIDName;
	}
	/**
	* 中文名【Agent Chinese Name】
	*/
	public String getChineseName()
	{
		return ChineseName;
	}
	public void setChineseName(String aChineseName)
	{
		if(aChineseName!=null && aChineseName.length()>20)
			throw new IllegalArgumentException("ChinesenameChineseName值"+aChineseName+"的长度"+aChineseName.length()+"大于最大值20");
		ChineseName = aChineseName;
	}
	/**
	* IDType【默认HKID】
	*/
	public String getIDType()
	{
		return IDType;
	}
	public void setIDType(String aIDType)
	{
		if(aIDType!=null && aIDType.length()>1)
			throw new IllegalArgumentException("IdtypeIDType值"+aIDType+"的长度"+aIDType.length()+"大于最大值1");
		IDType = aIDType;
	}
	/**
	* IDNo【HKID Card No】
	*/
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
	/**
	* WorkingVisa【Yes/No】
	*/
	public String getWorkingVisa()
	{
		return WorkingVisa;
	}
	public void setWorkingVisa(String aWorkingVisa)
	{
		if(aWorkingVisa!=null && aWorkingVisa.length()>1)
			throw new IllegalArgumentException("WorkingvisaWorkingVisa值"+aWorkingVisa+"的长度"+aWorkingVisa.length()+"大于最大值1");
		WorkingVisa = aWorkingVisa;
	}
	/**
	* WorkingVisaExpiryDate【WorkingVisa是Y的时候，Date不可为空，>=当前日期】
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
	* WorkingVisaType【Working Visa Type】
	*/
	public String getWorkingVisaType()
	{
		return WorkingVisaType;
	}
	public void setWorkingVisaType(String aWorkingVisaType)
	{
		if(aWorkingVisaType!=null && aWorkingVisaType.length()>20)
			throw new IllegalArgumentException("WorkingvisatypeWorkingVisaType值"+aWorkingVisaType+"的长度"+aWorkingVisaType.length()+"大于最大值20");
		WorkingVisaType = aWorkingVisaType;
	}
	/**
	* Qualification【Qualification】
	*/
	public String getQualification()
	{
		return Qualification;
	}
	public void setQualification(String aQualification)
	{
		if(aQualification!=null && aQualification.length()>50)
			throw new IllegalArgumentException("QualificationQualification值"+aQualification+"的长度"+aQualification.length()+"大于最大值50");
		Qualification = aQualification;
	}
	/**
	* 合同类型【Contract Type】
	*/
	public String getContractType()
	{
		return ContractType;
	}
	public void setContractType(String aContractType)
	{
		if(aContractType!=null && aContractType.length()>2)
			throw new IllegalArgumentException("ContracttypeContractType值"+aContractType+"的长度"+aContractType.length()+"大于最大值2");
		ContractType = aContractType;
	}
	/**
	* 合同生效日【Contract Effective Date】
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
	* 合同状态【Status】
	*/
	public String getContractStatus()
	{
		return ContractStatus;
	}
	public void setContractStatus(String aContractStatus)
	{
		if(aContractStatus!=null && aContractStatus.length()>2)
			throw new IllegalArgumentException("ContractstatusContractStatus值"+aContractStatus+"的长度"+aContractStatus.length()+"大于最大值2");
		ContractStatus = aContractStatus;
	}
	/**
	* RecruitmentProfile【Recruitment Profile】
	*/
	public String getRecruitmentProfile()
	{
		return RecruitmentProfile;
	}
	public void setRecruitmentProfile(String aRecruitmentProfile)
	{
		if(aRecruitmentProfile!=null && aRecruitmentProfile.length()>2)
			throw new IllegalArgumentException("RecruitmentprofileRecruitmentProfile值"+aRecruitmentProfile+"的长度"+aRecruitmentProfile.length()+"大于最大值2");
		RecruitmentProfile = aRecruitmentProfile;
	}
	/**
	* 招募人编码【Recruiting Manager Agent Code】
	*/
	public String getRecruitingAgentCode()
	{
		return RecruitingAgentCode;
	}
	public void setRecruitingAgentCode(String aRecruitingAgentCode)
	{
		if(aRecruitingAgentCode!=null && aRecruitingAgentCode.length()>10)
			throw new IllegalArgumentException("RecruitingagentcodeRecruitingAgentCode值"+aRecruitingAgentCode+"的长度"+aRecruitingAgentCode.length()+"大于最大值10");
		RecruitingAgentCode = aRecruitingAgentCode;
	}
	/**
	* 推荐人编码【Referring Agent Code】
	*/
	public String getReferringAgentCode()
	{
		return ReferringAgentCode;
	}
	public void setReferringAgentCode(String aReferringAgentCode)
	{
		if(aReferringAgentCode!=null && aReferringAgentCode.length()>10)
			throw new IllegalArgumentException("ReferringagentcodeReferringAgentCode值"+aReferringAgentCode+"的长度"+aReferringAgentCode.length()+"大于最大值10");
		ReferringAgentCode = aReferringAgentCode;
	}
	/**
	* LastTerminationDate【Last Termination Date】
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
	* LastTerminationReason【Last Termination Reason：离职功能中选的原因】
	*/
	public String getLastTerminationReason()
	{
		return LastTerminationReason;
	}
	public void setLastTerminationReason(String aLastTerminationReason)
	{
		if(aLastTerminationReason!=null && aLastTerminationReason.length()>500)
			throw new IllegalArgumentException("LastterminationreasonLastTerminationReason值"+aLastTerminationReason+"的长度"+aLastTerminationReason.length()+"大于最大值500");
		LastTerminationReason = aLastTerminationReason;
	}
	/**
	* TerminationNo【No. of Termination:根据HKID自动计算出来】
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
	* PaymentMethod【Payment Method】
	*/
	public String getPaymentMethod()
	{
		return PaymentMethod;
	}
	public void setPaymentMethod(String aPaymentMethod)
	{
		if(aPaymentMethod!=null && aPaymentMethod.length()>2)
			throw new IllegalArgumentException("PaymentmethodPaymentMethod值"+aPaymentMethod+"的长度"+aPaymentMethod.length()+"大于最大值2");
		PaymentMethod = aPaymentMethod;
	}
	/**
	* 银行账号名称【Payment Method是AutoPay的时候，该项必须有值】
	*/
	public String getBankAccountName()
	{
		return BankAccountName;
	}
	public void setBankAccountName(String aBankAccountName)
	{
		if(aBankAccountName!=null && aBankAccountName.length()>50)
			throw new IllegalArgumentException("BankaccountnameBankAccountName值"+aBankAccountName+"的长度"+aBankAccountName.length()+"大于最大值50");
		BankAccountName = aBankAccountName;
	}
	/**
	* 银行账号【Payment Method是AutoPay的时候，该项必须有值】
	*/
	public String getBankAccountNo()
	{
		return BankAccountNo;
	}
	public void setBankAccountNo(String aBankAccountNo)
	{
		if(aBankAccountNo!=null && aBankAccountNo.length()>50)
			throw new IllegalArgumentException("BankaccountnoBankAccountNo值"+aBankAccountNo+"的长度"+aBankAccountNo.length()+"大于最大值50");
		BankAccountNo = aBankAccountNo;
	}
	/**
	* 保留原因【Withheld Reason】
	*/
	public String getWithheldReason()
	{
		return WithheldReason;
	}
	public void setWithheldReason(String aWithheldReason)
	{
		if(aWithheldReason!=null && aWithheldReason.length()>200)
			throw new IllegalArgumentException("WithheldreasonWithheldReason值"+aWithheldReason+"的长度"+aWithheldReason.length()+"大于最大值200");
		WithheldReason = aWithheldReason;
	}
	/**
	* 担保人编码【Agent Code】
	*/
	public String getGuarantorAgentCode()
	{
		return GuarantorAgentCode;
	}
	public void setGuarantorAgentCode(String aGuarantorAgentCode)
	{
		if(aGuarantorAgentCode!=null && aGuarantorAgentCode.length()>12)
			throw new IllegalArgumentException("GuarantoragentcodeGuarantorAgentCode值"+aGuarantorAgentCode+"的长度"+aGuarantorAgentCode.length()+"大于最大值12");
		GuarantorAgentCode = aGuarantorAgentCode;
	}
	/**
	* 担保人关系【Relationship】
	*/
	public String getGuarantorAgentRelation()
	{
		return GuarantorAgentRelation;
	}
	public void setGuarantorAgentRelation(String aGuarantorAgentRelation)
	{
		if(aGuarantorAgentRelation!=null && aGuarantorAgentRelation.length()>2)
			throw new IllegalArgumentException("GuarantoragentrelationGuarantorAgentRelation值"+aGuarantorAgentRelation+"的长度"+aGuarantorAgentRelation.length()+"大于最大值2");
		GuarantorAgentRelation = aGuarantorAgentRelation;
	}
	/**
	* 担保人类型【Guarantor Type】
	*/
	public String getGuarantorType()
	{
		return GuarantorType;
	}
	public void setGuarantorType(String aGuarantorType)
	{
		if(aGuarantorType!=null && aGuarantorType.length()>2)
			throw new IllegalArgumentException("GuarantortypeGuarantorType值"+aGuarantorType+"的长度"+aGuarantorType.length()+"大于最大值2");
		GuarantorType = aGuarantorType;
	}
	/**
	* 性别【Gender】
	*/
	public String getSex()
	{
		return Sex;
	}
	public void setSex(String aSex)
	{
		if(aSex!=null && aSex.length()>1)
			throw new IllegalArgumentException("SexSex值"+aSex+"的长度"+aSex.length()+"大于最大值1");
		Sex = aSex;
	}
	/**
	* Title【Title1-Mr. 2-Mrs.3- Ms.】
	*/
	public String getTitle()
	{
		return Title;
	}
	public void setTitle(String aTitle)
	{
		if(aTitle!=null && aTitle.length()>2)
			throw new IllegalArgumentException("TitleTitle值"+aTitle+"的长度"+aTitle.length()+"大于最大值2");
		Title = aTitle;
	}
	/**
	* 国籍【录入，默认Hong Kong，可修改】
	*/
	public String getNationality()
	{
		return Nationality;
	}
	public void setNationality(String aNationality)
	{
		if(aNationality!=null && aNationality.length()>40)
			throw new IllegalArgumentException("NationalityNationality值"+aNationality+"的长度"+aNationality.length()+"大于最大值40");
		Nationality = aNationality;
	}
	/**
	* 生日【Date of Birth】
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
	* WorkingExperience【Total Working Experience(Yrs)】
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
	* LastJob【Last Job】
	*/
	public String getLastJob()
	{
		return LastJob;
	}
	public void setLastJob(String aLastJob)
	{
		if(aLastJob!=null && aLastJob.length()>2)
			throw new IllegalArgumentException("LastjobLastJob值"+aLastJob+"的长度"+aLastJob.length()+"大于最大值2");
		LastJob = aLastJob;
	}
	/**
	* LastJobServiceYears【Last Job Years of Service(Yrs)】
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
	* 是否有同业经验【Insurance Experience1-Yes、2-No】
	*/
	public String getInsuranceExperience()
	{
		return InsuranceExperience;
	}
	public void setInsuranceExperience(String aInsuranceExperience)
	{
		if(aInsuranceExperience!=null && aInsuranceExperience.length()>2)
			throw new IllegalArgumentException("InsuranceexperienceInsuranceExperience值"+aInsuranceExperience+"的长度"+aInsuranceExperience.length()+"大于最大值2");
		InsuranceExperience = aInsuranceExperience;
	}
	/**
	* 同业年限【Year of Insurance Experience】
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
	* 文化程度【Education Level】
	*/
	public String getEducationLevel()
	{
		return EducationLevel;
	}
	public void setEducationLevel(String aEducationLevel)
	{
		if(aEducationLevel!=null && aEducationLevel.length()>2)
			throw new IllegalArgumentException("EducationlevelEducationLevel值"+aEducationLevel+"的长度"+aEducationLevel.length()+"大于最大值2");
		EducationLevel = aEducationLevel;
	}
	/**
	* 地址录入类型【下拉选择Standard/Address】
	*/
	public String getAddressType()
	{
		return AddressType;
	}
	public void setAddressType(String aAddressType)
	{
		if(aAddressType!=null && aAddressType.length()>2)
			throw new IllegalArgumentException("AddresstypeAddressType值"+aAddressType+"的长度"+aAddressType.length()+"大于最大值2");
		AddressType = aAddressType;
	}
	/**
	* AddressRoom【录入】
	*/
	public String getAddressRoom()
	{
		return AddressRoom;
	}
	public void setAddressRoom(String aAddressRoom)
	{
		if(aAddressRoom!=null && aAddressRoom.length()>50)
			throw new IllegalArgumentException("AddressroomAddressRoom值"+aAddressRoom+"的长度"+aAddressRoom.length()+"大于最大值50");
		AddressRoom = aAddressRoom;
	}
	/**
	* AddressFloor【录入】
	*/
	public String getAddressFloor()
	{
		return AddressFloor;
	}
	public void setAddressFloor(String aAddressFloor)
	{
		if(aAddressFloor!=null && aAddressFloor.length()>50)
			throw new IllegalArgumentException("AddressfloorAddressFloor值"+aAddressFloor+"的长度"+aAddressFloor.length()+"大于最大值50");
		AddressFloor = aAddressFloor;
	}
	/**
	* AddressBlock【录入】
	*/
	public String getAddressBlock()
	{
		return AddressBlock;
	}
	public void setAddressBlock(String aAddressBlock)
	{
		if(aAddressBlock!=null && aAddressBlock.length()>50)
			throw new IllegalArgumentException("AddressblockAddressBlock值"+aAddressBlock+"的长度"+aAddressBlock.length()+"大于最大值50");
		AddressBlock = aAddressBlock;
	}
	/**
	* AddressBuilding【录入】
	*/
	public String getAddressBuilding()
	{
		return AddressBuilding;
	}
	public void setAddressBuilding(String aAddressBuilding)
	{
		if(aAddressBuilding!=null && aAddressBuilding.length()>50)
			throw new IllegalArgumentException("AddressbuildingAddressBuilding值"+aAddressBuilding+"的长度"+aAddressBuilding.length()+"大于最大值50");
		AddressBuilding = aAddressBuilding;
	}
	/**
	* AddressStreet【录入】
	*/
	public String getAddressStreet()
	{
		return AddressStreet;
	}
	public void setAddressStreet(String aAddressStreet)
	{
		if(aAddressStreet!=null && aAddressStreet.length()>50)
			throw new IllegalArgumentException("AddressstreetAddressStreet值"+aAddressStreet+"的长度"+aAddressStreet.length()+"大于最大值50");
		AddressStreet = aAddressStreet;
	}
	/**
	* AddressDistrict【下拉】
	*/
	public String getAddressDistrict()
	{
		return AddressDistrict;
	}
	public void setAddressDistrict(String aAddressDistrict)
	{
		if(aAddressDistrict!=null && aAddressDistrict.length()>2)
			throw new IllegalArgumentException("AddressdistrictAddressDistrict值"+aAddressDistrict+"的长度"+aAddressDistrict.length()+"大于最大值2");
		AddressDistrict = aAddressDistrict;
	}
	/**
	* FreeAddress【下拉选择Standard/Address】
	*/
	public String getFreeAddress()
	{
		return FreeAddress;
	}
	public void setFreeAddress(String aFreeAddress)
	{
		if(aFreeAddress!=null && aFreeAddress.length()>500)
			throw new IllegalArgumentException("FreeaddressFreeAddress值"+aFreeAddress+"的长度"+aFreeAddress.length()+"大于最大值500");
		FreeAddress = aFreeAddress;
	}
	/**
	* Phone【Home Tel No】
	*/
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String aPhone)
	{
		if(aPhone!=null && aPhone.length()>20)
			throw new IllegalArgumentException("PhonePhone值"+aPhone+"的长度"+aPhone.length()+"大于最大值20");
		Phone = aPhone;
	}
	/**
	* Mobile【Mobile No】
	*/
	public String getMobile()
	{
		return Mobile;
	}
	public void setMobile(String aMobile)
	{
		if(aMobile!=null && aMobile.length()>20)
			throw new IllegalArgumentException("MobileMobile值"+aMobile+"的长度"+aMobile.length()+"大于最大值20");
		Mobile = aMobile;
	}
	/**
	* Email【Personal Email Address】
	*/
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
	/**
	* CompanyEmail【Company Email Address】
	*/
	public String getCompanyEmail()
	{
		return CompanyEmail;
	}
	public void setCompanyEmail(String aCompanyEmail)
	{
		if(aCompanyEmail!=null && aCompanyEmail.length()>50)
			throw new IllegalArgumentException("CompanyemailCompanyEmail值"+aCompanyEmail+"的长度"+aCompanyEmail.length()+"大于最大值50");
		CompanyEmail = aCompanyEmail;
	}
	/**
	* FreeType【Office Address，默认为UnitAddress】
	*/
	public String getOfficeAddress()
	{
		return OfficeAddress;
	}
	public void setOfficeAddress(String aOfficeAddress)
	{
		if(aOfficeAddress!=null && aOfficeAddress.length()>200)
			throw new IllegalArgumentException("OfficeaddressOfficeAddress值"+aOfficeAddress+"的长度"+aOfficeAddress.length()+"大于最大值200");
		OfficeAddress = aOfficeAddress;
	}
	/**
	* OfficeTel【Office Tel】
	*/
	public String getOfficeTel()
	{
		return OfficeTel;
	}
	public void setOfficeTel(String aOfficeTel)
	{
		if(aOfficeTel!=null && aOfficeTel.length()>20)
			throw new IllegalArgumentException("OfficetelOfficeTel值"+aOfficeTel+"的长度"+aOfficeTel.length()+"大于最大值20");
		OfficeTel = aOfficeTel;
	}
	/**
	* OfficeFaxNo【Office Fax No】
	*/
	public String getOfficeFaxNo()
	{
		return OfficeFaxNo;
	}
	public void setOfficeFaxNo(String aOfficeFaxNo)
	{
		if(aOfficeFaxNo!=null && aOfficeFaxNo.length()>20)
			throw new IllegalArgumentException("OfficefaxnoOfficeFaxNo值"+aOfficeFaxNo+"的长度"+aOfficeFaxNo.length()+"大于最大值20");
		OfficeFaxNo = aOfficeFaxNo;
	}
	/**
	* Marriage【Martial Status】
	*/
	public String getMarriage()
	{
		return Marriage;
	}
	public void setMarriage(String aMarriage)
	{
		if(aMarriage!=null && aMarriage.length()>2)
			throw new IllegalArgumentException("MarriageMarriage值"+aMarriage+"的长度"+aMarriage.length()+"大于最大值2");
		Marriage = aMarriage;
	}
	/**
	* SpouseName【Spouse Name】
	*/
	public String getSpouseName()
	{
		return SpouseName;
	}
	public void setSpouseName(String aSpouseName)
	{
		if(aSpouseName!=null && aSpouseName.length()>50)
			throw new IllegalArgumentException("SpousenameSpouseName值"+aSpouseName+"的长度"+aSpouseName.length()+"大于最大值50");
		SpouseName = aSpouseName;
	}
	/**
	* SpouseIDNo【Spouse HKID No/Passport Number】
	*/
	public String getSpouseIDNo()
	{
		return SpouseIDNo;
	}
	public void setSpouseIDNo(String aSpouseIDNo)
	{
		if(aSpouseIDNo!=null && aSpouseIDNo.length()>20)
			throw new IllegalArgumentException("SpouseidnoSpouseIDNo值"+aSpouseIDNo+"的长度"+aSpouseIDNo.length()+"大于最大值20");
		SpouseIDNo = aSpouseIDNo;
	}
	/**
	* Flag1
	*/
	public String getFlag1()
	{
		return Flag1;
	}
	public void setFlag1(String aFlag1)
	{
		if(aFlag1!=null && aFlag1.length()>50)
			throw new IllegalArgumentException("Flag1Flag1值"+aFlag1+"的长度"+aFlag1.length()+"大于最大值50");
		Flag1 = aFlag1;
	}
	/**
	* Flag2
	*/
	public String getFlag2()
	{
		return Flag2;
	}
	public void setFlag2(String aFlag2)
	{
		if(aFlag2!=null && aFlag2.length()>50)
			throw new IllegalArgumentException("Flag2Flag2值"+aFlag2+"的长度"+aFlag2.length()+"大于最大值50");
		Flag2 = aFlag2;
	}
	/**
	* Flag3
	*/
	public String getFlag3()
	{
		return Flag3;
	}
	public void setFlag3(String aFlag3)
	{
		if(aFlag3!=null && aFlag3.length()>50)
			throw new IllegalArgumentException("Flag3Flag3值"+aFlag3+"的长度"+aFlag3.length()+"大于最大值50");
		Flag3 = aFlag3;
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
		if(aLastJobNature!=null && aLastJobNature.length()>50)
			throw new IllegalArgumentException("LastjobnatureLastJobNature值"+aLastJobNature+"的长度"+aLastJobNature.length()+"大于最大值50");
		LastJobNature = aLastJobNature;
	}

	/**
	* 使用另外一个 LAAgentSchema 对象给 Schema 赋值
	* @param: aLAAgentSchema LAAgentSchema
	**/
	public void setSchema(LAAgentSchema aLAAgentSchema)
	{
		this.AgentCode = aLAAgentSchema.getAgentCode();
		this.BranchType = aLAAgentSchema.getBranchType();
		this.AgentGroup = aLAAgentSchema.getAgentGroup();
		this.ManageCom = aLAAgentSchema.getManageCom();
		this.Password = aLAAgentSchema.getPassword();
		this.AgentState = aLAAgentSchema.getAgentState();
		this.SurName = aLAAgentSchema.getSurName();
		this.GivenName = aLAAgentSchema.getGivenName();
		this.EnglishName = aLAAgentSchema.getEnglishName();
		this.HKIDName = aLAAgentSchema.getHKIDName();
		this.ChineseName = aLAAgentSchema.getChineseName();
		this.IDType = aLAAgentSchema.getIDType();
		this.IDNo = aLAAgentSchema.getIDNo();
		this.WorkingVisa = aLAAgentSchema.getWorkingVisa();
		this.WorkingVisaExpiryDate = fDate.getDate( aLAAgentSchema.getWorkingVisaExpiryDate());
		this.WorkingVisaType = aLAAgentSchema.getWorkingVisaType();
		this.Qualification = aLAAgentSchema.getQualification();
		this.ContractType = aLAAgentSchema.getContractType();
		this.ContractEffDate = fDate.getDate( aLAAgentSchema.getContractEffDate());
		this.ContractStatus = aLAAgentSchema.getContractStatus();
		this.RecruitmentProfile = aLAAgentSchema.getRecruitmentProfile();
		this.RecruitingAgentCode = aLAAgentSchema.getRecruitingAgentCode();
		this.ReferringAgentCode = aLAAgentSchema.getReferringAgentCode();
		this.LastTerminationDate = fDate.getDate( aLAAgentSchema.getLastTerminationDate());
		this.LastTerminationReason = aLAAgentSchema.getLastTerminationReason();
		this.TerminationNo = aLAAgentSchema.getTerminationNo();
		this.PaymentMethod = aLAAgentSchema.getPaymentMethod();
		this.BankAccountName = aLAAgentSchema.getBankAccountName();
		this.BankAccountNo = aLAAgentSchema.getBankAccountNo();
		this.WithheldReason = aLAAgentSchema.getWithheldReason();
		this.GuarantorAgentCode = aLAAgentSchema.getGuarantorAgentCode();
		this.GuarantorAgentRelation = aLAAgentSchema.getGuarantorAgentRelation();
		this.GuarantorType = aLAAgentSchema.getGuarantorType();
		this.Sex = aLAAgentSchema.getSex();
		this.Title = aLAAgentSchema.getTitle();
		this.Nationality = aLAAgentSchema.getNationality();
		this.Birthday = fDate.getDate( aLAAgentSchema.getBirthday());
		this.WorkingExperience = aLAAgentSchema.getWorkingExperience();
		this.LastJob = aLAAgentSchema.getLastJob();
		this.LastJobServiceYears = aLAAgentSchema.getLastJobServiceYears();
		this.InsuranceExperience = aLAAgentSchema.getInsuranceExperience();
		this.InsuranceExperienceYears = aLAAgentSchema.getInsuranceExperienceYears();
		this.EducationLevel = aLAAgentSchema.getEducationLevel();
		this.AddressType = aLAAgentSchema.getAddressType();
		this.AddressRoom = aLAAgentSchema.getAddressRoom();
		this.AddressFloor = aLAAgentSchema.getAddressFloor();
		this.AddressBlock = aLAAgentSchema.getAddressBlock();
		this.AddressBuilding = aLAAgentSchema.getAddressBuilding();
		this.AddressStreet = aLAAgentSchema.getAddressStreet();
		this.AddressDistrict = aLAAgentSchema.getAddressDistrict();
		this.FreeAddress = aLAAgentSchema.getFreeAddress();
		this.Phone = aLAAgentSchema.getPhone();
		this.Mobile = aLAAgentSchema.getMobile();
		this.Email = aLAAgentSchema.getEmail();
		this.CompanyEmail = aLAAgentSchema.getCompanyEmail();
		this.OfficeAddress = aLAAgentSchema.getOfficeAddress();
		this.OfficeTel = aLAAgentSchema.getOfficeTel();
		this.OfficeFaxNo = aLAAgentSchema.getOfficeFaxNo();
		this.Marriage = aLAAgentSchema.getMarriage();
		this.SpouseName = aLAAgentSchema.getSpouseName();
		this.SpouseIDNo = aLAAgentSchema.getSpouseIDNo();
		this.Flag1 = aLAAgentSchema.getFlag1();
		this.Flag2 = aLAAgentSchema.getFlag2();
		this.Flag3 = aLAAgentSchema.getFlag3();
		this.Operator = aLAAgentSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentSchema.getMakeDate());
		this.MakeTime = aLAAgentSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentSchema.getModifyDate());
		this.ModifyTime = aLAAgentSchema.getModifyTime();
		this.LastJobNature = aLAAgentSchema.getLastJobNature();
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

			if( rs.getString("RecruitingAgentCode") == null )
				this.RecruitingAgentCode = null;
			else
				this.RecruitingAgentCode = rs.getString("RecruitingAgentCode").trim();

			if( rs.getString("ReferringAgentCode") == null )
				this.ReferringAgentCode = null;
			else
				this.ReferringAgentCode = rs.getString("ReferringAgentCode").trim();

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

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAAgent表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentSchema getSchema()
	{
		LAAgentSchema aLAAgentSchema = new LAAgentSchema();
		aLAAgentSchema.setSchema(this);
		return aLAAgentSchema;
	}

	public LAAgentDB getDB()
	{
		LAAgentDB aDBOper = new LAAgentDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgent描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
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
		strReturn.append(StrTool.cTrim(RecruitingAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ReferringAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
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
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LastJobNature));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgent>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Password = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AgentState = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			SurName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			GivenName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			EnglishName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			HKIDName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ChineseName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			IDType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			IDNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			WorkingVisa = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			WorkingVisaExpiryDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			WorkingVisaType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Qualification = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			ContractType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			ContractEffDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19,SysConst.PACKAGESPILTER));
			ContractStatus = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			RecruitmentProfile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			RecruitingAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			ReferringAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
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
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, SysConst.PACKAGESPILTER );
			LastJobNature = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentSchema";
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
		if (FCode.equalsIgnoreCase("RecruitingAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RecruitingAgentCode));
		}
		if (FCode.equalsIgnoreCase("ReferringAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ReferringAgentCode));
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
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Password);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(AgentState);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(SurName);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(GivenName);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(EnglishName);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(HKIDName);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(ChineseName);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(IDType);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(IDNo);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(WorkingVisa);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getWorkingVisaExpiryDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(WorkingVisaType);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Qualification);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(ContractType);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getContractEffDate()));
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(ContractStatus);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(RecruitmentProfile);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(RecruitingAgentCode);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(ReferringAgentCode);
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
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 65:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 66:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 67:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 68:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 69:
				strFieldValue = StrTool.GBKToUnicode(LastJobNature);
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAAgentSchema other = (LAAgentSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
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
			&& RecruitingAgentCode.equals(other.getRecruitingAgentCode())
			&& ReferringAgentCode.equals(other.getReferringAgentCode())
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
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& LastJobNature.equals(other.getLastJobNature());
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
		if( strFieldName.equals("AgentCode") ) {
			return 0;
		}
		if( strFieldName.equals("BranchType") ) {
			return 1;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 2;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 3;
		}
		if( strFieldName.equals("Password") ) {
			return 4;
		}
		if( strFieldName.equals("AgentState") ) {
			return 5;
		}
		if( strFieldName.equals("SurName") ) {
			return 6;
		}
		if( strFieldName.equals("GivenName") ) {
			return 7;
		}
		if( strFieldName.equals("EnglishName") ) {
			return 8;
		}
		if( strFieldName.equals("HKIDName") ) {
			return 9;
		}
		if( strFieldName.equals("ChineseName") ) {
			return 10;
		}
		if( strFieldName.equals("IDType") ) {
			return 11;
		}
		if( strFieldName.equals("IDNo") ) {
			return 12;
		}
		if( strFieldName.equals("WorkingVisa") ) {
			return 13;
		}
		if( strFieldName.equals("WorkingVisaExpiryDate") ) {
			return 14;
		}
		if( strFieldName.equals("WorkingVisaType") ) {
			return 15;
		}
		if( strFieldName.equals("Qualification") ) {
			return 16;
		}
		if( strFieldName.equals("ContractType") ) {
			return 17;
		}
		if( strFieldName.equals("ContractEffDate") ) {
			return 18;
		}
		if( strFieldName.equals("ContractStatus") ) {
			return 19;
		}
		if( strFieldName.equals("RecruitmentProfile") ) {
			return 20;
		}
		if( strFieldName.equals("RecruitingAgentCode") ) {
			return 21;
		}
		if( strFieldName.equals("ReferringAgentCode") ) {
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
		if( strFieldName.equals("Operator") ) {
			return 64;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 65;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 66;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 67;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 68;
		}
		if( strFieldName.equals("LastJobNature") ) {
			return 69;
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
				strFieldName = "AgentCode";
				break;
			case 1:
				strFieldName = "BranchType";
				break;
			case 2:
				strFieldName = "AgentGroup";
				break;
			case 3:
				strFieldName = "ManageCom";
				break;
			case 4:
				strFieldName = "Password";
				break;
			case 5:
				strFieldName = "AgentState";
				break;
			case 6:
				strFieldName = "SurName";
				break;
			case 7:
				strFieldName = "GivenName";
				break;
			case 8:
				strFieldName = "EnglishName";
				break;
			case 9:
				strFieldName = "HKIDName";
				break;
			case 10:
				strFieldName = "ChineseName";
				break;
			case 11:
				strFieldName = "IDType";
				break;
			case 12:
				strFieldName = "IDNo";
				break;
			case 13:
				strFieldName = "WorkingVisa";
				break;
			case 14:
				strFieldName = "WorkingVisaExpiryDate";
				break;
			case 15:
				strFieldName = "WorkingVisaType";
				break;
			case 16:
				strFieldName = "Qualification";
				break;
			case 17:
				strFieldName = "ContractType";
				break;
			case 18:
				strFieldName = "ContractEffDate";
				break;
			case 19:
				strFieldName = "ContractStatus";
				break;
			case 20:
				strFieldName = "RecruitmentProfile";
				break;
			case 21:
				strFieldName = "RecruitingAgentCode";
				break;
			case 22:
				strFieldName = "ReferringAgentCode";
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
				strFieldName = "Operator";
				break;
			case 65:
				strFieldName = "MakeDate";
				break;
			case 66:
				strFieldName = "MakeTime";
				break;
			case 67:
				strFieldName = "ModifyDate";
				break;
			case 68:
				strFieldName = "ModifyTime";
				break;
			case 69:
				strFieldName = "LastJobNature";
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
		if( strFieldName.equals("RecruitingAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ReferringAgentCode") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 69:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
