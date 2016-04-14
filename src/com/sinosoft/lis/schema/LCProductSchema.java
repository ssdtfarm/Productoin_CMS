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
import com.sinosoft.lis.db.LCProductDB;

/*
 * <p>ClassName: LCProductSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCProductSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LCProductSchema.class);
	// @Field
	/** Riskcode */
	private String RiskCode;
	/** Riskprop */
	private String RiskProp;
	/** Riskver */
	private String RiskVer;
	/** Riskname */
	private String RiskName;
	/** Subriskflag */
	private String SubRiskFlag;
	/** Kindcode */
	private String KindCode;
	/** Startdate */
	private Date StartDate;
	/** Enddate */
	private Date EndDate;
	/** Risktype */
	private String RiskType;
	/** Risktype1 */
	private String RiskType1;
	/** Risktype2 */
	private String RiskType2;
	/** Risktype3 */
	private String RiskType3;
	/** Risktype4 */
	private String RiskType4;
	/** Risktype5 */
	private String RiskType5;
	/** Riskperiod */
	private String RiskPeriod;
	/** Riskflagdetail */
	private String RiskFlagDetail;
	/** Riskflag */
	private String RiskFlag;
	/** Poltype */
	private String PolType;
	/** Investflag */
	private String InvestFlag;
	/** Bonusflag */
	private String BonusFlag;
	/** Bonusmode */
	private String BonusMode;
	/** Listflag */
	private String ListFlag;
	/** Caldigital */
	private int CalDigital;
	/** Calchomode */
	private String CalChomode;
	/** Riskamntmult */
	private int RiskAmntmult;
	/** Insuperiodflag */
	private String InsuperiodFlag;
	/** Maxendperiod */
	private int MaxEndPeriod;
	/** Agelmt */
	private int AgeLmt;
	/** Signdatecalmode */
	private int SignDateCalMode;
	/** Protocolflag */
	private String ProtocolFlag;
	/** Getchgflag */
	private String GetChgFlag;
	/** Protocolpayflag */
	private String ProtocolPayFlag;
	/** Ensuplanflag */
	private String EnSuplanFlag;
	/** Ensuplanadjflag */
	private String EnSuplanAdjFlag;
	/** Appinterest */
	private double AppInterest;
	/** Apppremrate */
	private double AppPremrate;
	/** Insuredflag */
	private String InSuredFlag;
	/** Shareflag */
	private String ShareFlag;
	/** Bnfflag */
	private String BnfFlag;
	/** Temppayflag */
	private String TempPayFlag;
	/** Inppayplan */
	private String InpPayPlan;
	/** Impartflag */
	private String ImpartFlag;
	/** Insuexpeflag */
	private String InsuexpeFlag;
	/** Loanflag */
	private String LoanFlag;
	/** Mortagageflag */
	private String MortagageFlag;
	/** Idifreturnflag */
	private String IdifreturnFlag;
	/** Cutamntstoppay */
	private String CutamntstopPay;
	/** Rinsrate */
	private double RinsRate;
	/** Saleflag */
	private String SaleFlag;
	/** Fileappflag */
	private String FileAppFlag;
	/** Mngcom */
	private String MngCom;
	/** Autopayflag */
	private String AutoPayFlag;
	/** Needprinthospital */
	private String NeedPrintHospital;
	/** Needprintget */
	private String NeedPrintGet;
	/** Notprintpol */
	private String NotPrintPol;
	/** Needgetpoldate */
	private String NeedGetPolDate;
	/** Needrereadbank */
	private String NeedRereadBank;
	/** Specflag */
	private String SpecFlag;
	/** Interestdifflag */
	private String InterestDifFlag;
	/** Minappntage */
	private int MinappntAge;
	/** Maxappntage */
	private int MaxAppntAge;
	/** Maxinsuredage */
	private int MaxInsuredAge;
	/** Mininsuredage */
	private int MinInsuredAge;

	public static final int FIELDNUM = 63;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LCProductSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "RiskCode";
		pk[1] = "RiskProp";

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
		LCProductSchema cloned = (LCProductSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getRiskCode()
	{
		return RiskCode;
	}
	public void setRiskCode(String aRiskCode)
	{
		if(aRiskCode!=null && aRiskCode.length()>8)
			throw new IllegalArgumentException("RiskcodeRiskCode值"+aRiskCode+"的长度"+aRiskCode.length()+"大于最大值8");
		RiskCode = aRiskCode;
	}
	public String getRiskProp()
	{
		return RiskProp;
	}
	public void setRiskProp(String aRiskProp)
	{
		if(aRiskProp!=null && aRiskProp.length()>1)
			throw new IllegalArgumentException("RiskpropRiskProp值"+aRiskProp+"的长度"+aRiskProp.length()+"大于最大值1");
		RiskProp = aRiskProp;
	}
	public String getRiskVer()
	{
		return RiskVer;
	}
	public void setRiskVer(String aRiskVer)
	{
		if(aRiskVer!=null && aRiskVer.length()>8)
			throw new IllegalArgumentException("RiskverRiskVer值"+aRiskVer+"的长度"+aRiskVer.length()+"大于最大值8");
		RiskVer = aRiskVer;
	}
	public String getRiskName()
	{
		return RiskName;
	}
	public void setRiskName(String aRiskName)
	{
		if(aRiskName!=null && aRiskName.length()>120)
			throw new IllegalArgumentException("RisknameRiskName值"+aRiskName+"的长度"+aRiskName.length()+"大于最大值120");
		RiskName = aRiskName;
	}
	public String getSubRiskFlag()
	{
		return SubRiskFlag;
	}
	public void setSubRiskFlag(String aSubRiskFlag)
	{
		if(aSubRiskFlag!=null && aSubRiskFlag.length()>1)
			throw new IllegalArgumentException("SubriskflagSubRiskFlag值"+aSubRiskFlag+"的长度"+aSubRiskFlag.length()+"大于最大值1");
		SubRiskFlag = aSubRiskFlag;
	}
	public String getKindCode()
	{
		return KindCode;
	}
	public void setKindCode(String aKindCode)
	{
		if(aKindCode!=null && aKindCode.length()>3)
			throw new IllegalArgumentException("KindcodeKindCode值"+aKindCode+"的长度"+aKindCode.length()+"大于最大值3");
		KindCode = aKindCode;
	}
	public String getStartDate()
	{
		if( StartDate != null )
			return fDate.getString(StartDate);
		else
			return null;
	}
	public void setStartDate(Date aStartDate)
	{
		StartDate = aStartDate;
	}
	public void setStartDate(String aStartDate)
	{
		if (aStartDate != null && !aStartDate.equals("") )
		{
			StartDate = fDate.getDate( aStartDate );
		}
		else
			StartDate = null;
	}

	public String getEndDate()
	{
		if( EndDate != null )
			return fDate.getString(EndDate);
		else
			return null;
	}
	public void setEndDate(Date aEndDate)
	{
		EndDate = aEndDate;
	}
	public void setEndDate(String aEndDate)
	{
		if (aEndDate != null && !aEndDate.equals("") )
		{
			EndDate = fDate.getDate( aEndDate );
		}
		else
			EndDate = null;
	}

	public String getRiskType()
	{
		return RiskType;
	}
	public void setRiskType(String aRiskType)
	{
		if(aRiskType!=null && aRiskType.length()>2)
			throw new IllegalArgumentException("RisktypeRiskType值"+aRiskType+"的长度"+aRiskType.length()+"大于最大值2");
		RiskType = aRiskType;
	}
	public String getRiskType1()
	{
		return RiskType1;
	}
	public void setRiskType1(String aRiskType1)
	{
		if(aRiskType1!=null && aRiskType1.length()>1)
			throw new IllegalArgumentException("Risktype1RiskType1值"+aRiskType1+"的长度"+aRiskType1.length()+"大于最大值1");
		RiskType1 = aRiskType1;
	}
	public String getRiskType2()
	{
		return RiskType2;
	}
	public void setRiskType2(String aRiskType2)
	{
		if(aRiskType2!=null && aRiskType2.length()>1)
			throw new IllegalArgumentException("Risktype2RiskType2值"+aRiskType2+"的长度"+aRiskType2.length()+"大于最大值1");
		RiskType2 = aRiskType2;
	}
	public String getRiskType3()
	{
		return RiskType3;
	}
	public void setRiskType3(String aRiskType3)
	{
		if(aRiskType3!=null && aRiskType3.length()>1)
			throw new IllegalArgumentException("Risktype3RiskType3值"+aRiskType3+"的长度"+aRiskType3.length()+"大于最大值1");
		RiskType3 = aRiskType3;
	}
	public String getRiskType4()
	{
		return RiskType4;
	}
	public void setRiskType4(String aRiskType4)
	{
		if(aRiskType4!=null && aRiskType4.length()>1)
			throw new IllegalArgumentException("Risktype4RiskType4值"+aRiskType4+"的长度"+aRiskType4.length()+"大于最大值1");
		RiskType4 = aRiskType4;
	}
	public String getRiskType5()
	{
		return RiskType5;
	}
	public void setRiskType5(String aRiskType5)
	{
		if(aRiskType5!=null && aRiskType5.length()>1)
			throw new IllegalArgumentException("Risktype5RiskType5值"+aRiskType5+"的长度"+aRiskType5.length()+"大于最大值1");
		RiskType5 = aRiskType5;
	}
	public String getRiskPeriod()
	{
		return RiskPeriod;
	}
	public void setRiskPeriod(String aRiskPeriod)
	{
		if(aRiskPeriod!=null && aRiskPeriod.length()>1)
			throw new IllegalArgumentException("RiskperiodRiskPeriod值"+aRiskPeriod+"的长度"+aRiskPeriod.length()+"大于最大值1");
		RiskPeriod = aRiskPeriod;
	}
	public String getRiskFlagDetail()
	{
		return RiskFlagDetail;
	}
	public void setRiskFlagDetail(String aRiskFlagDetail)
	{
		if(aRiskFlagDetail!=null && aRiskFlagDetail.length()>3)
			throw new IllegalArgumentException("RiskflagdetailRiskFlagDetail值"+aRiskFlagDetail+"的长度"+aRiskFlagDetail.length()+"大于最大值3");
		RiskFlagDetail = aRiskFlagDetail;
	}
	public String getRiskFlag()
	{
		return RiskFlag;
	}
	public void setRiskFlag(String aRiskFlag)
	{
		if(aRiskFlag!=null && aRiskFlag.length()>1)
			throw new IllegalArgumentException("RiskflagRiskFlag值"+aRiskFlag+"的长度"+aRiskFlag.length()+"大于最大值1");
		RiskFlag = aRiskFlag;
	}
	public String getPolType()
	{
		return PolType;
	}
	public void setPolType(String aPolType)
	{
		if(aPolType!=null && aPolType.length()>1)
			throw new IllegalArgumentException("PoltypePolType值"+aPolType+"的长度"+aPolType.length()+"大于最大值1");
		PolType = aPolType;
	}
	public String getInvestFlag()
	{
		return InvestFlag;
	}
	public void setInvestFlag(String aInvestFlag)
	{
		if(aInvestFlag!=null && aInvestFlag.length()>1)
			throw new IllegalArgumentException("InvestflagInvestFlag值"+aInvestFlag+"的长度"+aInvestFlag.length()+"大于最大值1");
		InvestFlag = aInvestFlag;
	}
	public String getBonusFlag()
	{
		return BonusFlag;
	}
	public void setBonusFlag(String aBonusFlag)
	{
		if(aBonusFlag!=null && aBonusFlag.length()>1)
			throw new IllegalArgumentException("BonusflagBonusFlag值"+aBonusFlag+"的长度"+aBonusFlag.length()+"大于最大值1");
		BonusFlag = aBonusFlag;
	}
	public String getBonusMode()
	{
		return BonusMode;
	}
	public void setBonusMode(String aBonusMode)
	{
		if(aBonusMode!=null && aBonusMode.length()>1)
			throw new IllegalArgumentException("BonusmodeBonusMode值"+aBonusMode+"的长度"+aBonusMode.length()+"大于最大值1");
		BonusMode = aBonusMode;
	}
	public String getListFlag()
	{
		return ListFlag;
	}
	public void setListFlag(String aListFlag)
	{
		if(aListFlag!=null && aListFlag.length()>1)
			throw new IllegalArgumentException("ListflagListFlag值"+aListFlag+"的长度"+aListFlag.length()+"大于最大值1");
		ListFlag = aListFlag;
	}
	public int getCalDigital()
	{
		return CalDigital;
	}
	public void setCalDigital(int aCalDigital)
	{
		CalDigital = aCalDigital;
	}
	public void setCalDigital(String aCalDigital)
	{
		if (aCalDigital != null && !aCalDigital.equals(""))
		{
			Integer tInteger = new Integer(aCalDigital);
			int i = tInteger.intValue();
			CalDigital = i;
		}
	}

	public String getCalChomode()
	{
		return CalChomode;
	}
	public void setCalChomode(String aCalChomode)
	{
		if(aCalChomode!=null && aCalChomode.length()>1)
			throw new IllegalArgumentException("CalchomodeCalChomode值"+aCalChomode+"的长度"+aCalChomode.length()+"大于最大值1");
		CalChomode = aCalChomode;
	}
	public int getRiskAmntmult()
	{
		return RiskAmntmult;
	}
	public void setRiskAmntmult(int aRiskAmntmult)
	{
		RiskAmntmult = aRiskAmntmult;
	}
	public void setRiskAmntmult(String aRiskAmntmult)
	{
		if (aRiskAmntmult != null && !aRiskAmntmult.equals(""))
		{
			Integer tInteger = new Integer(aRiskAmntmult);
			int i = tInteger.intValue();
			RiskAmntmult = i;
		}
	}

	public String getInsuperiodFlag()
	{
		return InsuperiodFlag;
	}
	public void setInsuperiodFlag(String aInsuperiodFlag)
	{
		if(aInsuperiodFlag!=null && aInsuperiodFlag.length()>1)
			throw new IllegalArgumentException("InsuperiodflagInsuperiodFlag值"+aInsuperiodFlag+"的长度"+aInsuperiodFlag.length()+"大于最大值1");
		InsuperiodFlag = aInsuperiodFlag;
	}
	public int getMaxEndPeriod()
	{
		return MaxEndPeriod;
	}
	public void setMaxEndPeriod(int aMaxEndPeriod)
	{
		MaxEndPeriod = aMaxEndPeriod;
	}
	public void setMaxEndPeriod(String aMaxEndPeriod)
	{
		if (aMaxEndPeriod != null && !aMaxEndPeriod.equals(""))
		{
			Integer tInteger = new Integer(aMaxEndPeriod);
			int i = tInteger.intValue();
			MaxEndPeriod = i;
		}
	}

	public int getAgeLmt()
	{
		return AgeLmt;
	}
	public void setAgeLmt(int aAgeLmt)
	{
		AgeLmt = aAgeLmt;
	}
	public void setAgeLmt(String aAgeLmt)
	{
		if (aAgeLmt != null && !aAgeLmt.equals(""))
		{
			Integer tInteger = new Integer(aAgeLmt);
			int i = tInteger.intValue();
			AgeLmt = i;
		}
	}

	public int getSignDateCalMode()
	{
		return SignDateCalMode;
	}
	public void setSignDateCalMode(int aSignDateCalMode)
	{
		SignDateCalMode = aSignDateCalMode;
	}
	public void setSignDateCalMode(String aSignDateCalMode)
	{
		if (aSignDateCalMode != null && !aSignDateCalMode.equals(""))
		{
			Integer tInteger = new Integer(aSignDateCalMode);
			int i = tInteger.intValue();
			SignDateCalMode = i;
		}
	}

	public String getProtocolFlag()
	{
		return ProtocolFlag;
	}
	public void setProtocolFlag(String aProtocolFlag)
	{
		if(aProtocolFlag!=null && aProtocolFlag.length()>1)
			throw new IllegalArgumentException("ProtocolflagProtocolFlag值"+aProtocolFlag+"的长度"+aProtocolFlag.length()+"大于最大值1");
		ProtocolFlag = aProtocolFlag;
	}
	public String getGetChgFlag()
	{
		return GetChgFlag;
	}
	public void setGetChgFlag(String aGetChgFlag)
	{
		if(aGetChgFlag!=null && aGetChgFlag.length()>1)
			throw new IllegalArgumentException("GetchgflagGetChgFlag值"+aGetChgFlag+"的长度"+aGetChgFlag.length()+"大于最大值1");
		GetChgFlag = aGetChgFlag;
	}
	public String getProtocolPayFlag()
	{
		return ProtocolPayFlag;
	}
	public void setProtocolPayFlag(String aProtocolPayFlag)
	{
		if(aProtocolPayFlag!=null && aProtocolPayFlag.length()>1)
			throw new IllegalArgumentException("ProtocolpayflagProtocolPayFlag值"+aProtocolPayFlag+"的长度"+aProtocolPayFlag.length()+"大于最大值1");
		ProtocolPayFlag = aProtocolPayFlag;
	}
	public String getEnSuplanFlag()
	{
		return EnSuplanFlag;
	}
	public void setEnSuplanFlag(String aEnSuplanFlag)
	{
		if(aEnSuplanFlag!=null && aEnSuplanFlag.length()>1)
			throw new IllegalArgumentException("EnsuplanflagEnSuplanFlag值"+aEnSuplanFlag+"的长度"+aEnSuplanFlag.length()+"大于最大值1");
		EnSuplanFlag = aEnSuplanFlag;
	}
	public String getEnSuplanAdjFlag()
	{
		return EnSuplanAdjFlag;
	}
	public void setEnSuplanAdjFlag(String aEnSuplanAdjFlag)
	{
		if(aEnSuplanAdjFlag!=null && aEnSuplanAdjFlag.length()>1)
			throw new IllegalArgumentException("EnsuplanadjflagEnSuplanAdjFlag值"+aEnSuplanAdjFlag+"的长度"+aEnSuplanAdjFlag.length()+"大于最大值1");
		EnSuplanAdjFlag = aEnSuplanAdjFlag;
	}
	public double getAppInterest()
	{
		return AppInterest;
	}
	public void setAppInterest(double aAppInterest)
	{
		AppInterest = aAppInterest;
	}
	public void setAppInterest(String aAppInterest)
	{
		if (aAppInterest != null && !aAppInterest.equals(""))
		{
			Double tDouble = new Double(aAppInterest);
			double d = tDouble.doubleValue();
			AppInterest = d;
		}
	}

	public double getAppPremrate()
	{
		return AppPremrate;
	}
	public void setAppPremrate(double aAppPremrate)
	{
		AppPremrate = aAppPremrate;
	}
	public void setAppPremrate(String aAppPremrate)
	{
		if (aAppPremrate != null && !aAppPremrate.equals(""))
		{
			Double tDouble = new Double(aAppPremrate);
			double d = tDouble.doubleValue();
			AppPremrate = d;
		}
	}

	public String getInSuredFlag()
	{
		return InSuredFlag;
	}
	public void setInSuredFlag(String aInSuredFlag)
	{
		if(aInSuredFlag!=null && aInSuredFlag.length()>1)
			throw new IllegalArgumentException("InsuredflagInSuredFlag值"+aInSuredFlag+"的长度"+aInSuredFlag.length()+"大于最大值1");
		InSuredFlag = aInSuredFlag;
	}
	public String getShareFlag()
	{
		return ShareFlag;
	}
	public void setShareFlag(String aShareFlag)
	{
		if(aShareFlag!=null && aShareFlag.length()>1)
			throw new IllegalArgumentException("ShareflagShareFlag值"+aShareFlag+"的长度"+aShareFlag.length()+"大于最大值1");
		ShareFlag = aShareFlag;
	}
	public String getBnfFlag()
	{
		return BnfFlag;
	}
	public void setBnfFlag(String aBnfFlag)
	{
		if(aBnfFlag!=null && aBnfFlag.length()>1)
			throw new IllegalArgumentException("BnfflagBnfFlag值"+aBnfFlag+"的长度"+aBnfFlag.length()+"大于最大值1");
		BnfFlag = aBnfFlag;
	}
	public String getTempPayFlag()
	{
		return TempPayFlag;
	}
	public void setTempPayFlag(String aTempPayFlag)
	{
		if(aTempPayFlag!=null && aTempPayFlag.length()>1)
			throw new IllegalArgumentException("TemppayflagTempPayFlag值"+aTempPayFlag+"的长度"+aTempPayFlag.length()+"大于最大值1");
		TempPayFlag = aTempPayFlag;
	}
	public String getInpPayPlan()
	{
		return InpPayPlan;
	}
	public void setInpPayPlan(String aInpPayPlan)
	{
		if(aInpPayPlan!=null && aInpPayPlan.length()>1)
			throw new IllegalArgumentException("InppayplanInpPayPlan值"+aInpPayPlan+"的长度"+aInpPayPlan.length()+"大于最大值1");
		InpPayPlan = aInpPayPlan;
	}
	public String getImpartFlag()
	{
		return ImpartFlag;
	}
	public void setImpartFlag(String aImpartFlag)
	{
		if(aImpartFlag!=null && aImpartFlag.length()>1)
			throw new IllegalArgumentException("ImpartflagImpartFlag值"+aImpartFlag+"的长度"+aImpartFlag.length()+"大于最大值1");
		ImpartFlag = aImpartFlag;
	}
	public String getInsuexpeFlag()
	{
		return InsuexpeFlag;
	}
	public void setInsuexpeFlag(String aInsuexpeFlag)
	{
		if(aInsuexpeFlag!=null && aInsuexpeFlag.length()>1)
			throw new IllegalArgumentException("InsuexpeflagInsuexpeFlag值"+aInsuexpeFlag+"的长度"+aInsuexpeFlag.length()+"大于最大值1");
		InsuexpeFlag = aInsuexpeFlag;
	}
	public String getLoanFlag()
	{
		return LoanFlag;
	}
	public void setLoanFlag(String aLoanFlag)
	{
		if(aLoanFlag!=null && aLoanFlag.length()>1)
			throw new IllegalArgumentException("LoanflagLoanFlag值"+aLoanFlag+"的长度"+aLoanFlag.length()+"大于最大值1");
		LoanFlag = aLoanFlag;
	}
	public String getMortagageFlag()
	{
		return MortagageFlag;
	}
	public void setMortagageFlag(String aMortagageFlag)
	{
		if(aMortagageFlag!=null && aMortagageFlag.length()>1)
			throw new IllegalArgumentException("MortagageflagMortagageFlag值"+aMortagageFlag+"的长度"+aMortagageFlag.length()+"大于最大值1");
		MortagageFlag = aMortagageFlag;
	}
	public String getIdifreturnFlag()
	{
		return IdifreturnFlag;
	}
	public void setIdifreturnFlag(String aIdifreturnFlag)
	{
		if(aIdifreturnFlag!=null && aIdifreturnFlag.length()>1)
			throw new IllegalArgumentException("IdifreturnflagIdifreturnFlag值"+aIdifreturnFlag+"的长度"+aIdifreturnFlag.length()+"大于最大值1");
		IdifreturnFlag = aIdifreturnFlag;
	}
	public String getCutamntstopPay()
	{
		return CutamntstopPay;
	}
	public void setCutamntstopPay(String aCutamntstopPay)
	{
		if(aCutamntstopPay!=null && aCutamntstopPay.length()>1)
			throw new IllegalArgumentException("CutamntstoppayCutamntstopPay值"+aCutamntstopPay+"的长度"+aCutamntstopPay.length()+"大于最大值1");
		CutamntstopPay = aCutamntstopPay;
	}
	public double getRinsRate()
	{
		return RinsRate;
	}
	public void setRinsRate(double aRinsRate)
	{
		RinsRate = aRinsRate;
	}
	public void setRinsRate(String aRinsRate)
	{
		if (aRinsRate != null && !aRinsRate.equals(""))
		{
			Double tDouble = new Double(aRinsRate);
			double d = tDouble.doubleValue();
			RinsRate = d;
		}
	}

	public String getSaleFlag()
	{
		return SaleFlag;
	}
	public void setSaleFlag(String aSaleFlag)
	{
		if(aSaleFlag!=null && aSaleFlag.length()>1)
			throw new IllegalArgumentException("SaleflagSaleFlag值"+aSaleFlag+"的长度"+aSaleFlag.length()+"大于最大值1");
		SaleFlag = aSaleFlag;
	}
	public String getFileAppFlag()
	{
		return FileAppFlag;
	}
	public void setFileAppFlag(String aFileAppFlag)
	{
		if(aFileAppFlag!=null && aFileAppFlag.length()>1)
			throw new IllegalArgumentException("FileappflagFileAppFlag值"+aFileAppFlag+"的长度"+aFileAppFlag.length()+"大于最大值1");
		FileAppFlag = aFileAppFlag;
	}
	public String getMngCom()
	{
		return MngCom;
	}
	public void setMngCom(String aMngCom)
	{
		if(aMngCom!=null && aMngCom.length()>10)
			throw new IllegalArgumentException("MngcomMngCom值"+aMngCom+"的长度"+aMngCom.length()+"大于最大值10");
		MngCom = aMngCom;
	}
	public String getAutoPayFlag()
	{
		return AutoPayFlag;
	}
	public void setAutoPayFlag(String aAutoPayFlag)
	{
		if(aAutoPayFlag!=null && aAutoPayFlag.length()>1)
			throw new IllegalArgumentException("AutopayflagAutoPayFlag值"+aAutoPayFlag+"的长度"+aAutoPayFlag.length()+"大于最大值1");
		AutoPayFlag = aAutoPayFlag;
	}
	public String getNeedPrintHospital()
	{
		return NeedPrintHospital;
	}
	public void setNeedPrintHospital(String aNeedPrintHospital)
	{
		if(aNeedPrintHospital!=null && aNeedPrintHospital.length()>1)
			throw new IllegalArgumentException("NeedprinthospitalNeedPrintHospital值"+aNeedPrintHospital+"的长度"+aNeedPrintHospital.length()+"大于最大值1");
		NeedPrintHospital = aNeedPrintHospital;
	}
	public String getNeedPrintGet()
	{
		return NeedPrintGet;
	}
	public void setNeedPrintGet(String aNeedPrintGet)
	{
		if(aNeedPrintGet!=null && aNeedPrintGet.length()>1)
			throw new IllegalArgumentException("NeedprintgetNeedPrintGet值"+aNeedPrintGet+"的长度"+aNeedPrintGet.length()+"大于最大值1");
		NeedPrintGet = aNeedPrintGet;
	}
	public String getNotPrintPol()
	{
		return NotPrintPol;
	}
	public void setNotPrintPol(String aNotPrintPol)
	{
		if(aNotPrintPol!=null && aNotPrintPol.length()>1)
			throw new IllegalArgumentException("NotprintpolNotPrintPol值"+aNotPrintPol+"的长度"+aNotPrintPol.length()+"大于最大值1");
		NotPrintPol = aNotPrintPol;
	}
	public String getNeedGetPolDate()
	{
		return NeedGetPolDate;
	}
	public void setNeedGetPolDate(String aNeedGetPolDate)
	{
		if(aNeedGetPolDate!=null && aNeedGetPolDate.length()>1)
			throw new IllegalArgumentException("NeedgetpoldateNeedGetPolDate值"+aNeedGetPolDate+"的长度"+aNeedGetPolDate.length()+"大于最大值1");
		NeedGetPolDate = aNeedGetPolDate;
	}
	public String getNeedRereadBank()
	{
		return NeedRereadBank;
	}
	public void setNeedRereadBank(String aNeedRereadBank)
	{
		if(aNeedRereadBank!=null && aNeedRereadBank.length()>1)
			throw new IllegalArgumentException("NeedrereadbankNeedRereadBank值"+aNeedRereadBank+"的长度"+aNeedRereadBank.length()+"大于最大值1");
		NeedRereadBank = aNeedRereadBank;
	}
	public String getSpecFlag()
	{
		return SpecFlag;
	}
	public void setSpecFlag(String aSpecFlag)
	{
		if(aSpecFlag!=null && aSpecFlag.length()>2)
			throw new IllegalArgumentException("SpecflagSpecFlag值"+aSpecFlag+"的长度"+aSpecFlag.length()+"大于最大值2");
		SpecFlag = aSpecFlag;
	}
	public String getInterestDifFlag()
	{
		return InterestDifFlag;
	}
	public void setInterestDifFlag(String aInterestDifFlag)
	{
		if(aInterestDifFlag!=null && aInterestDifFlag.length()>1)
			throw new IllegalArgumentException("InterestdifflagInterestDifFlag值"+aInterestDifFlag+"的长度"+aInterestDifFlag.length()+"大于最大值1");
		InterestDifFlag = aInterestDifFlag;
	}
	public int getMinappntAge()
	{
		return MinappntAge;
	}
	public void setMinappntAge(int aMinappntAge)
	{
		MinappntAge = aMinappntAge;
	}
	public void setMinappntAge(String aMinappntAge)
	{
		if (aMinappntAge != null && !aMinappntAge.equals(""))
		{
			Integer tInteger = new Integer(aMinappntAge);
			int i = tInteger.intValue();
			MinappntAge = i;
		}
	}

	public int getMaxAppntAge()
	{
		return MaxAppntAge;
	}
	public void setMaxAppntAge(int aMaxAppntAge)
	{
		MaxAppntAge = aMaxAppntAge;
	}
	public void setMaxAppntAge(String aMaxAppntAge)
	{
		if (aMaxAppntAge != null && !aMaxAppntAge.equals(""))
		{
			Integer tInteger = new Integer(aMaxAppntAge);
			int i = tInteger.intValue();
			MaxAppntAge = i;
		}
	}

	public int getMaxInsuredAge()
	{
		return MaxInsuredAge;
	}
	public void setMaxInsuredAge(int aMaxInsuredAge)
	{
		MaxInsuredAge = aMaxInsuredAge;
	}
	public void setMaxInsuredAge(String aMaxInsuredAge)
	{
		if (aMaxInsuredAge != null && !aMaxInsuredAge.equals(""))
		{
			Integer tInteger = new Integer(aMaxInsuredAge);
			int i = tInteger.intValue();
			MaxInsuredAge = i;
		}
	}

	public int getMinInsuredAge()
	{
		return MinInsuredAge;
	}
	public void setMinInsuredAge(int aMinInsuredAge)
	{
		MinInsuredAge = aMinInsuredAge;
	}
	public void setMinInsuredAge(String aMinInsuredAge)
	{
		if (aMinInsuredAge != null && !aMinInsuredAge.equals(""))
		{
			Integer tInteger = new Integer(aMinInsuredAge);
			int i = tInteger.intValue();
			MinInsuredAge = i;
		}
	}


	/**
	* 使用另外一个 LCProductSchema 对象给 Schema 赋值
	* @param: aLCProductSchema LCProductSchema
	**/
	public void setSchema(LCProductSchema aLCProductSchema)
	{
		this.RiskCode = aLCProductSchema.getRiskCode();
		this.RiskProp = aLCProductSchema.getRiskProp();
		this.RiskVer = aLCProductSchema.getRiskVer();
		this.RiskName = aLCProductSchema.getRiskName();
		this.SubRiskFlag = aLCProductSchema.getSubRiskFlag();
		this.KindCode = aLCProductSchema.getKindCode();
		this.StartDate = fDate.getDate( aLCProductSchema.getStartDate());
		this.EndDate = fDate.getDate( aLCProductSchema.getEndDate());
		this.RiskType = aLCProductSchema.getRiskType();
		this.RiskType1 = aLCProductSchema.getRiskType1();
		this.RiskType2 = aLCProductSchema.getRiskType2();
		this.RiskType3 = aLCProductSchema.getRiskType3();
		this.RiskType4 = aLCProductSchema.getRiskType4();
		this.RiskType5 = aLCProductSchema.getRiskType5();
		this.RiskPeriod = aLCProductSchema.getRiskPeriod();
		this.RiskFlagDetail = aLCProductSchema.getRiskFlagDetail();
		this.RiskFlag = aLCProductSchema.getRiskFlag();
		this.PolType = aLCProductSchema.getPolType();
		this.InvestFlag = aLCProductSchema.getInvestFlag();
		this.BonusFlag = aLCProductSchema.getBonusFlag();
		this.BonusMode = aLCProductSchema.getBonusMode();
		this.ListFlag = aLCProductSchema.getListFlag();
		this.CalDigital = aLCProductSchema.getCalDigital();
		this.CalChomode = aLCProductSchema.getCalChomode();
		this.RiskAmntmult = aLCProductSchema.getRiskAmntmult();
		this.InsuperiodFlag = aLCProductSchema.getInsuperiodFlag();
		this.MaxEndPeriod = aLCProductSchema.getMaxEndPeriod();
		this.AgeLmt = aLCProductSchema.getAgeLmt();
		this.SignDateCalMode = aLCProductSchema.getSignDateCalMode();
		this.ProtocolFlag = aLCProductSchema.getProtocolFlag();
		this.GetChgFlag = aLCProductSchema.getGetChgFlag();
		this.ProtocolPayFlag = aLCProductSchema.getProtocolPayFlag();
		this.EnSuplanFlag = aLCProductSchema.getEnSuplanFlag();
		this.EnSuplanAdjFlag = aLCProductSchema.getEnSuplanAdjFlag();
		this.AppInterest = aLCProductSchema.getAppInterest();
		this.AppPremrate = aLCProductSchema.getAppPremrate();
		this.InSuredFlag = aLCProductSchema.getInSuredFlag();
		this.ShareFlag = aLCProductSchema.getShareFlag();
		this.BnfFlag = aLCProductSchema.getBnfFlag();
		this.TempPayFlag = aLCProductSchema.getTempPayFlag();
		this.InpPayPlan = aLCProductSchema.getInpPayPlan();
		this.ImpartFlag = aLCProductSchema.getImpartFlag();
		this.InsuexpeFlag = aLCProductSchema.getInsuexpeFlag();
		this.LoanFlag = aLCProductSchema.getLoanFlag();
		this.MortagageFlag = aLCProductSchema.getMortagageFlag();
		this.IdifreturnFlag = aLCProductSchema.getIdifreturnFlag();
		this.CutamntstopPay = aLCProductSchema.getCutamntstopPay();
		this.RinsRate = aLCProductSchema.getRinsRate();
		this.SaleFlag = aLCProductSchema.getSaleFlag();
		this.FileAppFlag = aLCProductSchema.getFileAppFlag();
		this.MngCom = aLCProductSchema.getMngCom();
		this.AutoPayFlag = aLCProductSchema.getAutoPayFlag();
		this.NeedPrintHospital = aLCProductSchema.getNeedPrintHospital();
		this.NeedPrintGet = aLCProductSchema.getNeedPrintGet();
		this.NotPrintPol = aLCProductSchema.getNotPrintPol();
		this.NeedGetPolDate = aLCProductSchema.getNeedGetPolDate();
		this.NeedRereadBank = aLCProductSchema.getNeedRereadBank();
		this.SpecFlag = aLCProductSchema.getSpecFlag();
		this.InterestDifFlag = aLCProductSchema.getInterestDifFlag();
		this.MinappntAge = aLCProductSchema.getMinappntAge();
		this.MaxAppntAge = aLCProductSchema.getMaxAppntAge();
		this.MaxInsuredAge = aLCProductSchema.getMaxInsuredAge();
		this.MinInsuredAge = aLCProductSchema.getMinInsuredAge();
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
			if( rs.getString("RiskCode") == null )
				this.RiskCode = null;
			else
				this.RiskCode = rs.getString("RiskCode").trim();

			if( rs.getString("RiskProp") == null )
				this.RiskProp = null;
			else
				this.RiskProp = rs.getString("RiskProp").trim();

			if( rs.getString("RiskVer") == null )
				this.RiskVer = null;
			else
				this.RiskVer = rs.getString("RiskVer").trim();

			if( rs.getString("RiskName") == null )
				this.RiskName = null;
			else
				this.RiskName = rs.getString("RiskName").trim();

			if( rs.getString("SubRiskFlag") == null )
				this.SubRiskFlag = null;
			else
				this.SubRiskFlag = rs.getString("SubRiskFlag").trim();

			if( rs.getString("KindCode") == null )
				this.KindCode = null;
			else
				this.KindCode = rs.getString("KindCode").trim();

			this.StartDate = rs.getDate("StartDate");
			this.EndDate = rs.getDate("EndDate");
			if( rs.getString("RiskType") == null )
				this.RiskType = null;
			else
				this.RiskType = rs.getString("RiskType").trim();

			if( rs.getString("RiskType1") == null )
				this.RiskType1 = null;
			else
				this.RiskType1 = rs.getString("RiskType1").trim();

			if( rs.getString("RiskType2") == null )
				this.RiskType2 = null;
			else
				this.RiskType2 = rs.getString("RiskType2").trim();

			if( rs.getString("RiskType3") == null )
				this.RiskType3 = null;
			else
				this.RiskType3 = rs.getString("RiskType3").trim();

			if( rs.getString("RiskType4") == null )
				this.RiskType4 = null;
			else
				this.RiskType4 = rs.getString("RiskType4").trim();

			if( rs.getString("RiskType5") == null )
				this.RiskType5 = null;
			else
				this.RiskType5 = rs.getString("RiskType5").trim();

			if( rs.getString("RiskPeriod") == null )
				this.RiskPeriod = null;
			else
				this.RiskPeriod = rs.getString("RiskPeriod").trim();

			if( rs.getString("RiskFlagDetail") == null )
				this.RiskFlagDetail = null;
			else
				this.RiskFlagDetail = rs.getString("RiskFlagDetail").trim();

			if( rs.getString("RiskFlag") == null )
				this.RiskFlag = null;
			else
				this.RiskFlag = rs.getString("RiskFlag").trim();

			if( rs.getString("PolType") == null )
				this.PolType = null;
			else
				this.PolType = rs.getString("PolType").trim();

			if( rs.getString("InvestFlag") == null )
				this.InvestFlag = null;
			else
				this.InvestFlag = rs.getString("InvestFlag").trim();

			if( rs.getString("BonusFlag") == null )
				this.BonusFlag = null;
			else
				this.BonusFlag = rs.getString("BonusFlag").trim();

			if( rs.getString("BonusMode") == null )
				this.BonusMode = null;
			else
				this.BonusMode = rs.getString("BonusMode").trim();

			if( rs.getString("ListFlag") == null )
				this.ListFlag = null;
			else
				this.ListFlag = rs.getString("ListFlag").trim();

			this.CalDigital = rs.getInt("CalDigital");
			if( rs.getString("CalChomode") == null )
				this.CalChomode = null;
			else
				this.CalChomode = rs.getString("CalChomode").trim();

			this.RiskAmntmult = rs.getInt("RiskAmntmult");
			if( rs.getString("InsuperiodFlag") == null )
				this.InsuperiodFlag = null;
			else
				this.InsuperiodFlag = rs.getString("InsuperiodFlag").trim();

			this.MaxEndPeriod = rs.getInt("MaxEndPeriod");
			this.AgeLmt = rs.getInt("AgeLmt");
			this.SignDateCalMode = rs.getInt("SignDateCalMode");
			if( rs.getString("ProtocolFlag") == null )
				this.ProtocolFlag = null;
			else
				this.ProtocolFlag = rs.getString("ProtocolFlag").trim();

			if( rs.getString("GetChgFlag") == null )
				this.GetChgFlag = null;
			else
				this.GetChgFlag = rs.getString("GetChgFlag").trim();

			if( rs.getString("ProtocolPayFlag") == null )
				this.ProtocolPayFlag = null;
			else
				this.ProtocolPayFlag = rs.getString("ProtocolPayFlag").trim();

			if( rs.getString("EnSuplanFlag") == null )
				this.EnSuplanFlag = null;
			else
				this.EnSuplanFlag = rs.getString("EnSuplanFlag").trim();

			if( rs.getString("EnSuplanAdjFlag") == null )
				this.EnSuplanAdjFlag = null;
			else
				this.EnSuplanAdjFlag = rs.getString("EnSuplanAdjFlag").trim();

			this.AppInterest = rs.getDouble("AppInterest");
			this.AppPremrate = rs.getDouble("AppPremrate");
			if( rs.getString("InSuredFlag") == null )
				this.InSuredFlag = null;
			else
				this.InSuredFlag = rs.getString("InSuredFlag").trim();

			if( rs.getString("ShareFlag") == null )
				this.ShareFlag = null;
			else
				this.ShareFlag = rs.getString("ShareFlag").trim();

			if( rs.getString("BnfFlag") == null )
				this.BnfFlag = null;
			else
				this.BnfFlag = rs.getString("BnfFlag").trim();

			if( rs.getString("TempPayFlag") == null )
				this.TempPayFlag = null;
			else
				this.TempPayFlag = rs.getString("TempPayFlag").trim();

			if( rs.getString("InpPayPlan") == null )
				this.InpPayPlan = null;
			else
				this.InpPayPlan = rs.getString("InpPayPlan").trim();

			if( rs.getString("ImpartFlag") == null )
				this.ImpartFlag = null;
			else
				this.ImpartFlag = rs.getString("ImpartFlag").trim();

			if( rs.getString("InsuexpeFlag") == null )
				this.InsuexpeFlag = null;
			else
				this.InsuexpeFlag = rs.getString("InsuexpeFlag").trim();

			if( rs.getString("LoanFlag") == null )
				this.LoanFlag = null;
			else
				this.LoanFlag = rs.getString("LoanFlag").trim();

			if( rs.getString("MortagageFlag") == null )
				this.MortagageFlag = null;
			else
				this.MortagageFlag = rs.getString("MortagageFlag").trim();

			if( rs.getString("IdifreturnFlag") == null )
				this.IdifreturnFlag = null;
			else
				this.IdifreturnFlag = rs.getString("IdifreturnFlag").trim();

			if( rs.getString("CutamntstopPay") == null )
				this.CutamntstopPay = null;
			else
				this.CutamntstopPay = rs.getString("CutamntstopPay").trim();

			this.RinsRate = rs.getDouble("RinsRate");
			if( rs.getString("SaleFlag") == null )
				this.SaleFlag = null;
			else
				this.SaleFlag = rs.getString("SaleFlag").trim();

			if( rs.getString("FileAppFlag") == null )
				this.FileAppFlag = null;
			else
				this.FileAppFlag = rs.getString("FileAppFlag").trim();

			if( rs.getString("MngCom") == null )
				this.MngCom = null;
			else
				this.MngCom = rs.getString("MngCom").trim();

			if( rs.getString("AutoPayFlag") == null )
				this.AutoPayFlag = null;
			else
				this.AutoPayFlag = rs.getString("AutoPayFlag").trim();

			if( rs.getString("NeedPrintHospital") == null )
				this.NeedPrintHospital = null;
			else
				this.NeedPrintHospital = rs.getString("NeedPrintHospital").trim();

			if( rs.getString("NeedPrintGet") == null )
				this.NeedPrintGet = null;
			else
				this.NeedPrintGet = rs.getString("NeedPrintGet").trim();

			if( rs.getString("NotPrintPol") == null )
				this.NotPrintPol = null;
			else
				this.NotPrintPol = rs.getString("NotPrintPol").trim();

			if( rs.getString("NeedGetPolDate") == null )
				this.NeedGetPolDate = null;
			else
				this.NeedGetPolDate = rs.getString("NeedGetPolDate").trim();

			if( rs.getString("NeedRereadBank") == null )
				this.NeedRereadBank = null;
			else
				this.NeedRereadBank = rs.getString("NeedRereadBank").trim();

			if( rs.getString("SpecFlag") == null )
				this.SpecFlag = null;
			else
				this.SpecFlag = rs.getString("SpecFlag").trim();

			if( rs.getString("InterestDifFlag") == null )
				this.InterestDifFlag = null;
			else
				this.InterestDifFlag = rs.getString("InterestDifFlag").trim();

			this.MinappntAge = rs.getInt("MinappntAge");
			this.MaxAppntAge = rs.getInt("MaxAppntAge");
			this.MaxInsuredAge = rs.getInt("MaxInsuredAge");
			this.MinInsuredAge = rs.getInt("MinInsuredAge");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LCProduct表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCProductSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LCProductSchema getSchema()
	{
		LCProductSchema aLCProductSchema = new LCProductSchema();
		aLCProductSchema.setSchema(this);
		return aLCProductSchema;
	}

	public LCProductDB getDB()
	{
		LCProductDB aDBOper = new LCProductDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCProduct描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(RiskCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskProp)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskVer)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SubRiskFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(KindCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( StartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EndDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskType1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskType2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskType3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskType4)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskType5)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskPeriod)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskFlagDetail)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RiskFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PolType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InvestFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BonusFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BonusMode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ListFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(CalDigital));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalChomode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(RiskAmntmult));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InsuperiodFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MaxEndPeriod));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AgeLmt));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SignDateCalMode));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ProtocolFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GetChgFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ProtocolPayFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EnSuplanFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(EnSuplanAdjFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AppInterest));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(AppPremrate));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InSuredFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ShareFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BnfFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TempPayFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InpPayPlan)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ImpartFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InsuexpeFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(LoanFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MortagageFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IdifreturnFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CutamntstopPay)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(RinsRate));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SaleFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(FileAppFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MngCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AutoPayFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NeedPrintHospital)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NeedPrintGet)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NotPrintPol)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NeedGetPolDate)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NeedRereadBank)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SpecFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(InterestDifFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MinappntAge));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MaxAppntAge));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MaxInsuredAge));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(MinInsuredAge));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCProduct>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			RiskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			RiskProp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			RiskVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			RiskName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			SubRiskFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			KindCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			StartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			EndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			RiskType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			RiskType1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			RiskType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			RiskType3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			RiskType4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			RiskType5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			RiskPeriod = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			RiskFlagDetail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			RiskFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			PolType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			InvestFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			BonusFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			BonusMode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			ListFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			CalDigital= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,23,SysConst.PACKAGESPILTER))).intValue();
			CalChomode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			RiskAmntmult= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,25,SysConst.PACKAGESPILTER))).intValue();
			InsuperiodFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			MaxEndPeriod= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,27,SysConst.PACKAGESPILTER))).intValue();
			AgeLmt= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,28,SysConst.PACKAGESPILTER))).intValue();
			SignDateCalMode= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,29,SysConst.PACKAGESPILTER))).intValue();
			ProtocolFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, SysConst.PACKAGESPILTER );
			GetChgFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, SysConst.PACKAGESPILTER );
			ProtocolPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, SysConst.PACKAGESPILTER );
			EnSuplanFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, SysConst.PACKAGESPILTER );
			EnSuplanAdjFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, SysConst.PACKAGESPILTER );
			AppInterest = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,35,SysConst.PACKAGESPILTER))).doubleValue();
			AppPremrate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,36,SysConst.PACKAGESPILTER))).doubleValue();
			InSuredFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, SysConst.PACKAGESPILTER );
			ShareFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, SysConst.PACKAGESPILTER );
			BnfFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, SysConst.PACKAGESPILTER );
			TempPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, SysConst.PACKAGESPILTER );
			InpPayPlan = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, SysConst.PACKAGESPILTER );
			ImpartFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, SysConst.PACKAGESPILTER );
			InsuexpeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, SysConst.PACKAGESPILTER );
			LoanFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, SysConst.PACKAGESPILTER );
			MortagageFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, SysConst.PACKAGESPILTER );
			IdifreturnFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, SysConst.PACKAGESPILTER );
			CutamntstopPay = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, SysConst.PACKAGESPILTER );
			RinsRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,48,SysConst.PACKAGESPILTER))).doubleValue();
			SaleFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, SysConst.PACKAGESPILTER );
			FileAppFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, SysConst.PACKAGESPILTER );
			MngCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, SysConst.PACKAGESPILTER );
			AutoPayFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, SysConst.PACKAGESPILTER );
			NeedPrintHospital = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, SysConst.PACKAGESPILTER );
			NeedPrintGet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, SysConst.PACKAGESPILTER );
			NotPrintPol = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, SysConst.PACKAGESPILTER );
			NeedGetPolDate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, SysConst.PACKAGESPILTER );
			NeedRereadBank = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, SysConst.PACKAGESPILTER );
			SpecFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, SysConst.PACKAGESPILTER );
			InterestDifFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 59, SysConst.PACKAGESPILTER );
			MinappntAge= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,60,SysConst.PACKAGESPILTER))).intValue();
			MaxAppntAge= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,61,SysConst.PACKAGESPILTER))).intValue();
			MaxInsuredAge= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,62,SysConst.PACKAGESPILTER))).intValue();
			MinInsuredAge= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,63,SysConst.PACKAGESPILTER))).intValue();
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCProductSchema";
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
		if (FCode.equalsIgnoreCase("RiskCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskCode));
		}
		if (FCode.equalsIgnoreCase("RiskProp"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskProp));
		}
		if (FCode.equalsIgnoreCase("RiskVer"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskVer));
		}
		if (FCode.equalsIgnoreCase("RiskName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskName));
		}
		if (FCode.equalsIgnoreCase("SubRiskFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SubRiskFlag));
		}
		if (FCode.equalsIgnoreCase("KindCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(KindCode));
		}
		if (FCode.equalsIgnoreCase("StartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
		}
		if (FCode.equalsIgnoreCase("EndDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
		}
		if (FCode.equalsIgnoreCase("RiskType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskType));
		}
		if (FCode.equalsIgnoreCase("RiskType1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskType1));
		}
		if (FCode.equalsIgnoreCase("RiskType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskType2));
		}
		if (FCode.equalsIgnoreCase("RiskType3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskType3));
		}
		if (FCode.equalsIgnoreCase("RiskType4"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskType4));
		}
		if (FCode.equalsIgnoreCase("RiskType5"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskType5));
		}
		if (FCode.equalsIgnoreCase("RiskPeriod"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskPeriod));
		}
		if (FCode.equalsIgnoreCase("RiskFlagDetail"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskFlagDetail));
		}
		if (FCode.equalsIgnoreCase("RiskFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskFlag));
		}
		if (FCode.equalsIgnoreCase("PolType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PolType));
		}
		if (FCode.equalsIgnoreCase("InvestFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InvestFlag));
		}
		if (FCode.equalsIgnoreCase("BonusFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BonusFlag));
		}
		if (FCode.equalsIgnoreCase("BonusMode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BonusMode));
		}
		if (FCode.equalsIgnoreCase("ListFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ListFlag));
		}
		if (FCode.equalsIgnoreCase("CalDigital"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalDigital));
		}
		if (FCode.equalsIgnoreCase("CalChomode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalChomode));
		}
		if (FCode.equalsIgnoreCase("RiskAmntmult"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RiskAmntmult));
		}
		if (FCode.equalsIgnoreCase("InsuperiodFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuperiodFlag));
		}
		if (FCode.equalsIgnoreCase("MaxEndPeriod"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MaxEndPeriod));
		}
		if (FCode.equalsIgnoreCase("AgeLmt"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgeLmt));
		}
		if (FCode.equalsIgnoreCase("SignDateCalMode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SignDateCalMode));
		}
		if (FCode.equalsIgnoreCase("ProtocolFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ProtocolFlag));
		}
		if (FCode.equalsIgnoreCase("GetChgFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GetChgFlag));
		}
		if (FCode.equalsIgnoreCase("ProtocolPayFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ProtocolPayFlag));
		}
		if (FCode.equalsIgnoreCase("EnSuplanFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EnSuplanFlag));
		}
		if (FCode.equalsIgnoreCase("EnSuplanAdjFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EnSuplanAdjFlag));
		}
		if (FCode.equalsIgnoreCase("AppInterest"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AppInterest));
		}
		if (FCode.equalsIgnoreCase("AppPremrate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AppPremrate));
		}
		if (FCode.equalsIgnoreCase("InSuredFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InSuredFlag));
		}
		if (FCode.equalsIgnoreCase("ShareFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ShareFlag));
		}
		if (FCode.equalsIgnoreCase("BnfFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BnfFlag));
		}
		if (FCode.equalsIgnoreCase("TempPayFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TempPayFlag));
		}
		if (FCode.equalsIgnoreCase("InpPayPlan"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InpPayPlan));
		}
		if (FCode.equalsIgnoreCase("ImpartFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ImpartFlag));
		}
		if (FCode.equalsIgnoreCase("InsuexpeFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InsuexpeFlag));
		}
		if (FCode.equalsIgnoreCase("LoanFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(LoanFlag));
		}
		if (FCode.equalsIgnoreCase("MortagageFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MortagageFlag));
		}
		if (FCode.equalsIgnoreCase("IdifreturnFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IdifreturnFlag));
		}
		if (FCode.equalsIgnoreCase("CutamntstopPay"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CutamntstopPay));
		}
		if (FCode.equalsIgnoreCase("RinsRate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RinsRate));
		}
		if (FCode.equalsIgnoreCase("SaleFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SaleFlag));
		}
		if (FCode.equalsIgnoreCase("FileAppFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(FileAppFlag));
		}
		if (FCode.equalsIgnoreCase("MngCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MngCom));
		}
		if (FCode.equalsIgnoreCase("AutoPayFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AutoPayFlag));
		}
		if (FCode.equalsIgnoreCase("NeedPrintHospital"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NeedPrintHospital));
		}
		if (FCode.equalsIgnoreCase("NeedPrintGet"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NeedPrintGet));
		}
		if (FCode.equalsIgnoreCase("NotPrintPol"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NotPrintPol));
		}
		if (FCode.equalsIgnoreCase("NeedGetPolDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NeedGetPolDate));
		}
		if (FCode.equalsIgnoreCase("NeedRereadBank"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NeedRereadBank));
		}
		if (FCode.equalsIgnoreCase("SpecFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SpecFlag));
		}
		if (FCode.equalsIgnoreCase("InterestDifFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(InterestDifFlag));
		}
		if (FCode.equalsIgnoreCase("MinappntAge"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MinappntAge));
		}
		if (FCode.equalsIgnoreCase("MaxAppntAge"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MaxAppntAge));
		}
		if (FCode.equalsIgnoreCase("MaxInsuredAge"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MaxInsuredAge));
		}
		if (FCode.equalsIgnoreCase("MinInsuredAge"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MinInsuredAge));
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
				strFieldValue = StrTool.GBKToUnicode(RiskCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(RiskProp);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(RiskVer);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(RiskName);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(SubRiskFlag);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(KindCode);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(RiskType);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(RiskType1);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(RiskType2);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(RiskType3);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(RiskType4);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(RiskType5);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(RiskPeriod);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(RiskFlagDetail);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(RiskFlag);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(PolType);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(InvestFlag);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(BonusFlag);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(BonusMode);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(ListFlag);
				break;
			case 22:
				strFieldValue = String.valueOf(CalDigital);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(CalChomode);
				break;
			case 24:
				strFieldValue = String.valueOf(RiskAmntmult);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(InsuperiodFlag);
				break;
			case 26:
				strFieldValue = String.valueOf(MaxEndPeriod);
				break;
			case 27:
				strFieldValue = String.valueOf(AgeLmt);
				break;
			case 28:
				strFieldValue = String.valueOf(SignDateCalMode);
				break;
			case 29:
				strFieldValue = StrTool.GBKToUnicode(ProtocolFlag);
				break;
			case 30:
				strFieldValue = StrTool.GBKToUnicode(GetChgFlag);
				break;
			case 31:
				strFieldValue = StrTool.GBKToUnicode(ProtocolPayFlag);
				break;
			case 32:
				strFieldValue = StrTool.GBKToUnicode(EnSuplanFlag);
				break;
			case 33:
				strFieldValue = StrTool.GBKToUnicode(EnSuplanAdjFlag);
				break;
			case 34:
				strFieldValue = String.valueOf(AppInterest);
				break;
			case 35:
				strFieldValue = String.valueOf(AppPremrate);
				break;
			case 36:
				strFieldValue = StrTool.GBKToUnicode(InSuredFlag);
				break;
			case 37:
				strFieldValue = StrTool.GBKToUnicode(ShareFlag);
				break;
			case 38:
				strFieldValue = StrTool.GBKToUnicode(BnfFlag);
				break;
			case 39:
				strFieldValue = StrTool.GBKToUnicode(TempPayFlag);
				break;
			case 40:
				strFieldValue = StrTool.GBKToUnicode(InpPayPlan);
				break;
			case 41:
				strFieldValue = StrTool.GBKToUnicode(ImpartFlag);
				break;
			case 42:
				strFieldValue = StrTool.GBKToUnicode(InsuexpeFlag);
				break;
			case 43:
				strFieldValue = StrTool.GBKToUnicode(LoanFlag);
				break;
			case 44:
				strFieldValue = StrTool.GBKToUnicode(MortagageFlag);
				break;
			case 45:
				strFieldValue = StrTool.GBKToUnicode(IdifreturnFlag);
				break;
			case 46:
				strFieldValue = StrTool.GBKToUnicode(CutamntstopPay);
				break;
			case 47:
				strFieldValue = String.valueOf(RinsRate);
				break;
			case 48:
				strFieldValue = StrTool.GBKToUnicode(SaleFlag);
				break;
			case 49:
				strFieldValue = StrTool.GBKToUnicode(FileAppFlag);
				break;
			case 50:
				strFieldValue = StrTool.GBKToUnicode(MngCom);
				break;
			case 51:
				strFieldValue = StrTool.GBKToUnicode(AutoPayFlag);
				break;
			case 52:
				strFieldValue = StrTool.GBKToUnicode(NeedPrintHospital);
				break;
			case 53:
				strFieldValue = StrTool.GBKToUnicode(NeedPrintGet);
				break;
			case 54:
				strFieldValue = StrTool.GBKToUnicode(NotPrintPol);
				break;
			case 55:
				strFieldValue = StrTool.GBKToUnicode(NeedGetPolDate);
				break;
			case 56:
				strFieldValue = StrTool.GBKToUnicode(NeedRereadBank);
				break;
			case 57:
				strFieldValue = StrTool.GBKToUnicode(SpecFlag);
				break;
			case 58:
				strFieldValue = StrTool.GBKToUnicode(InterestDifFlag);
				break;
			case 59:
				strFieldValue = String.valueOf(MinappntAge);
				break;
			case 60:
				strFieldValue = String.valueOf(MaxAppntAge);
				break;
			case 61:
				strFieldValue = String.valueOf(MaxInsuredAge);
				break;
			case 62:
				strFieldValue = String.valueOf(MinInsuredAge);
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

		if (FCode.equalsIgnoreCase("RiskCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskCode = FValue.trim();
			}
			else
				RiskCode = null;
		}
		if (FCode.equalsIgnoreCase("RiskProp"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskProp = FValue.trim();
			}
			else
				RiskProp = null;
		}
		if (FCode.equalsIgnoreCase("RiskVer"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskVer = FValue.trim();
			}
			else
				RiskVer = null;
		}
		if (FCode.equalsIgnoreCase("RiskName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskName = FValue.trim();
			}
			else
				RiskName = null;
		}
		if (FCode.equalsIgnoreCase("SubRiskFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SubRiskFlag = FValue.trim();
			}
			else
				SubRiskFlag = null;
		}
		if (FCode.equalsIgnoreCase("KindCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				KindCode = FValue.trim();
			}
			else
				KindCode = null;
		}
		if (FCode.equalsIgnoreCase("StartDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				StartDate = fDate.getDate( FValue );
			}
			else
				StartDate = null;
		}
		if (FCode.equalsIgnoreCase("EndDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				EndDate = fDate.getDate( FValue );
			}
			else
				EndDate = null;
		}
		if (FCode.equalsIgnoreCase("RiskType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskType = FValue.trim();
			}
			else
				RiskType = null;
		}
		if (FCode.equalsIgnoreCase("RiskType1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskType1 = FValue.trim();
			}
			else
				RiskType1 = null;
		}
		if (FCode.equalsIgnoreCase("RiskType2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskType2 = FValue.trim();
			}
			else
				RiskType2 = null;
		}
		if (FCode.equalsIgnoreCase("RiskType3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskType3 = FValue.trim();
			}
			else
				RiskType3 = null;
		}
		if (FCode.equalsIgnoreCase("RiskType4"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskType4 = FValue.trim();
			}
			else
				RiskType4 = null;
		}
		if (FCode.equalsIgnoreCase("RiskType5"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskType5 = FValue.trim();
			}
			else
				RiskType5 = null;
		}
		if (FCode.equalsIgnoreCase("RiskPeriod"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskPeriod = FValue.trim();
			}
			else
				RiskPeriod = null;
		}
		if (FCode.equalsIgnoreCase("RiskFlagDetail"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskFlagDetail = FValue.trim();
			}
			else
				RiskFlagDetail = null;
		}
		if (FCode.equalsIgnoreCase("RiskFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RiskFlag = FValue.trim();
			}
			else
				RiskFlag = null;
		}
		if (FCode.equalsIgnoreCase("PolType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PolType = FValue.trim();
			}
			else
				PolType = null;
		}
		if (FCode.equalsIgnoreCase("InvestFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InvestFlag = FValue.trim();
			}
			else
				InvestFlag = null;
		}
		if (FCode.equalsIgnoreCase("BonusFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BonusFlag = FValue.trim();
			}
			else
				BonusFlag = null;
		}
		if (FCode.equalsIgnoreCase("BonusMode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BonusMode = FValue.trim();
			}
			else
				BonusMode = null;
		}
		if (FCode.equalsIgnoreCase("ListFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ListFlag = FValue.trim();
			}
			else
				ListFlag = null;
		}
		if (FCode.equalsIgnoreCase("CalDigital"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				CalDigital = i;
			}
		}
		if (FCode.equalsIgnoreCase("CalChomode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalChomode = FValue.trim();
			}
			else
				CalChomode = null;
		}
		if (FCode.equalsIgnoreCase("RiskAmntmult"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				RiskAmntmult = i;
			}
		}
		if (FCode.equalsIgnoreCase("InsuperiodFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InsuperiodFlag = FValue.trim();
			}
			else
				InsuperiodFlag = null;
		}
		if (FCode.equalsIgnoreCase("MaxEndPeriod"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				MaxEndPeriod = i;
			}
		}
		if (FCode.equalsIgnoreCase("AgeLmt"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				AgeLmt = i;
			}
		}
		if (FCode.equalsIgnoreCase("SignDateCalMode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				SignDateCalMode = i;
			}
		}
		if (FCode.equalsIgnoreCase("ProtocolFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ProtocolFlag = FValue.trim();
			}
			else
				ProtocolFlag = null;
		}
		if (FCode.equalsIgnoreCase("GetChgFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GetChgFlag = FValue.trim();
			}
			else
				GetChgFlag = null;
		}
		if (FCode.equalsIgnoreCase("ProtocolPayFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ProtocolPayFlag = FValue.trim();
			}
			else
				ProtocolPayFlag = null;
		}
		if (FCode.equalsIgnoreCase("EnSuplanFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EnSuplanFlag = FValue.trim();
			}
			else
				EnSuplanFlag = null;
		}
		if (FCode.equalsIgnoreCase("EnSuplanAdjFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EnSuplanAdjFlag = FValue.trim();
			}
			else
				EnSuplanAdjFlag = null;
		}
		if (FCode.equalsIgnoreCase("AppInterest"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				AppInterest = d;
			}
		}
		if (FCode.equalsIgnoreCase("AppPremrate"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				AppPremrate = d;
			}
		}
		if (FCode.equalsIgnoreCase("InSuredFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InSuredFlag = FValue.trim();
			}
			else
				InSuredFlag = null;
		}
		if (FCode.equalsIgnoreCase("ShareFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ShareFlag = FValue.trim();
			}
			else
				ShareFlag = null;
		}
		if (FCode.equalsIgnoreCase("BnfFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BnfFlag = FValue.trim();
			}
			else
				BnfFlag = null;
		}
		if (FCode.equalsIgnoreCase("TempPayFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TempPayFlag = FValue.trim();
			}
			else
				TempPayFlag = null;
		}
		if (FCode.equalsIgnoreCase("InpPayPlan"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InpPayPlan = FValue.trim();
			}
			else
				InpPayPlan = null;
		}
		if (FCode.equalsIgnoreCase("ImpartFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ImpartFlag = FValue.trim();
			}
			else
				ImpartFlag = null;
		}
		if (FCode.equalsIgnoreCase("InsuexpeFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InsuexpeFlag = FValue.trim();
			}
			else
				InsuexpeFlag = null;
		}
		if (FCode.equalsIgnoreCase("LoanFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				LoanFlag = FValue.trim();
			}
			else
				LoanFlag = null;
		}
		if (FCode.equalsIgnoreCase("MortagageFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MortagageFlag = FValue.trim();
			}
			else
				MortagageFlag = null;
		}
		if (FCode.equalsIgnoreCase("IdifreturnFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IdifreturnFlag = FValue.trim();
			}
			else
				IdifreturnFlag = null;
		}
		if (FCode.equalsIgnoreCase("CutamntstopPay"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CutamntstopPay = FValue.trim();
			}
			else
				CutamntstopPay = null;
		}
		if (FCode.equalsIgnoreCase("RinsRate"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				RinsRate = d;
			}
		}
		if (FCode.equalsIgnoreCase("SaleFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SaleFlag = FValue.trim();
			}
			else
				SaleFlag = null;
		}
		if (FCode.equalsIgnoreCase("FileAppFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				FileAppFlag = FValue.trim();
			}
			else
				FileAppFlag = null;
		}
		if (FCode.equalsIgnoreCase("MngCom"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MngCom = FValue.trim();
			}
			else
				MngCom = null;
		}
		if (FCode.equalsIgnoreCase("AutoPayFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AutoPayFlag = FValue.trim();
			}
			else
				AutoPayFlag = null;
		}
		if (FCode.equalsIgnoreCase("NeedPrintHospital"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NeedPrintHospital = FValue.trim();
			}
			else
				NeedPrintHospital = null;
		}
		if (FCode.equalsIgnoreCase("NeedPrintGet"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NeedPrintGet = FValue.trim();
			}
			else
				NeedPrintGet = null;
		}
		if (FCode.equalsIgnoreCase("NotPrintPol"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NotPrintPol = FValue.trim();
			}
			else
				NotPrintPol = null;
		}
		if (FCode.equalsIgnoreCase("NeedGetPolDate"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NeedGetPolDate = FValue.trim();
			}
			else
				NeedGetPolDate = null;
		}
		if (FCode.equalsIgnoreCase("NeedRereadBank"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NeedRereadBank = FValue.trim();
			}
			else
				NeedRereadBank = null;
		}
		if (FCode.equalsIgnoreCase("SpecFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SpecFlag = FValue.trim();
			}
			else
				SpecFlag = null;
		}
		if (FCode.equalsIgnoreCase("InterestDifFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				InterestDifFlag = FValue.trim();
			}
			else
				InterestDifFlag = null;
		}
		if (FCode.equalsIgnoreCase("MinappntAge"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				MinappntAge = i;
			}
		}
		if (FCode.equalsIgnoreCase("MaxAppntAge"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				MaxAppntAge = i;
			}
		}
		if (FCode.equalsIgnoreCase("MaxInsuredAge"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				MaxInsuredAge = i;
			}
		}
		if (FCode.equalsIgnoreCase("MinInsuredAge"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				MinInsuredAge = i;
			}
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LCProductSchema other = (LCProductSchema)otherObject;
		return
			RiskCode.equals(other.getRiskCode())
			&& RiskProp.equals(other.getRiskProp())
			&& RiskVer.equals(other.getRiskVer())
			&& RiskName.equals(other.getRiskName())
			&& SubRiskFlag.equals(other.getSubRiskFlag())
			&& KindCode.equals(other.getKindCode())
			&& fDate.getString(StartDate).equals(other.getStartDate())
			&& fDate.getString(EndDate).equals(other.getEndDate())
			&& RiskType.equals(other.getRiskType())
			&& RiskType1.equals(other.getRiskType1())
			&& RiskType2.equals(other.getRiskType2())
			&& RiskType3.equals(other.getRiskType3())
			&& RiskType4.equals(other.getRiskType4())
			&& RiskType5.equals(other.getRiskType5())
			&& RiskPeriod.equals(other.getRiskPeriod())
			&& RiskFlagDetail.equals(other.getRiskFlagDetail())
			&& RiskFlag.equals(other.getRiskFlag())
			&& PolType.equals(other.getPolType())
			&& InvestFlag.equals(other.getInvestFlag())
			&& BonusFlag.equals(other.getBonusFlag())
			&& BonusMode.equals(other.getBonusMode())
			&& ListFlag.equals(other.getListFlag())
			&& CalDigital == other.getCalDigital()
			&& CalChomode.equals(other.getCalChomode())
			&& RiskAmntmult == other.getRiskAmntmult()
			&& InsuperiodFlag.equals(other.getInsuperiodFlag())
			&& MaxEndPeriod == other.getMaxEndPeriod()
			&& AgeLmt == other.getAgeLmt()
			&& SignDateCalMode == other.getSignDateCalMode()
			&& ProtocolFlag.equals(other.getProtocolFlag())
			&& GetChgFlag.equals(other.getGetChgFlag())
			&& ProtocolPayFlag.equals(other.getProtocolPayFlag())
			&& EnSuplanFlag.equals(other.getEnSuplanFlag())
			&& EnSuplanAdjFlag.equals(other.getEnSuplanAdjFlag())
			&& AppInterest == other.getAppInterest()
			&& AppPremrate == other.getAppPremrate()
			&& InSuredFlag.equals(other.getInSuredFlag())
			&& ShareFlag.equals(other.getShareFlag())
			&& BnfFlag.equals(other.getBnfFlag())
			&& TempPayFlag.equals(other.getTempPayFlag())
			&& InpPayPlan.equals(other.getInpPayPlan())
			&& ImpartFlag.equals(other.getImpartFlag())
			&& InsuexpeFlag.equals(other.getInsuexpeFlag())
			&& LoanFlag.equals(other.getLoanFlag())
			&& MortagageFlag.equals(other.getMortagageFlag())
			&& IdifreturnFlag.equals(other.getIdifreturnFlag())
			&& CutamntstopPay.equals(other.getCutamntstopPay())
			&& RinsRate == other.getRinsRate()
			&& SaleFlag.equals(other.getSaleFlag())
			&& FileAppFlag.equals(other.getFileAppFlag())
			&& MngCom.equals(other.getMngCom())
			&& AutoPayFlag.equals(other.getAutoPayFlag())
			&& NeedPrintHospital.equals(other.getNeedPrintHospital())
			&& NeedPrintGet.equals(other.getNeedPrintGet())
			&& NotPrintPol.equals(other.getNotPrintPol())
			&& NeedGetPolDate.equals(other.getNeedGetPolDate())
			&& NeedRereadBank.equals(other.getNeedRereadBank())
			&& SpecFlag.equals(other.getSpecFlag())
			&& InterestDifFlag.equals(other.getInterestDifFlag())
			&& MinappntAge == other.getMinappntAge()
			&& MaxAppntAge == other.getMaxAppntAge()
			&& MaxInsuredAge == other.getMaxInsuredAge()
			&& MinInsuredAge == other.getMinInsuredAge();
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
		if( strFieldName.equals("RiskCode") ) {
			return 0;
		}
		if( strFieldName.equals("RiskProp") ) {
			return 1;
		}
		if( strFieldName.equals("RiskVer") ) {
			return 2;
		}
		if( strFieldName.equals("RiskName") ) {
			return 3;
		}
		if( strFieldName.equals("SubRiskFlag") ) {
			return 4;
		}
		if( strFieldName.equals("KindCode") ) {
			return 5;
		}
		if( strFieldName.equals("StartDate") ) {
			return 6;
		}
		if( strFieldName.equals("EndDate") ) {
			return 7;
		}
		if( strFieldName.equals("RiskType") ) {
			return 8;
		}
		if( strFieldName.equals("RiskType1") ) {
			return 9;
		}
		if( strFieldName.equals("RiskType2") ) {
			return 10;
		}
		if( strFieldName.equals("RiskType3") ) {
			return 11;
		}
		if( strFieldName.equals("RiskType4") ) {
			return 12;
		}
		if( strFieldName.equals("RiskType5") ) {
			return 13;
		}
		if( strFieldName.equals("RiskPeriod") ) {
			return 14;
		}
		if( strFieldName.equals("RiskFlagDetail") ) {
			return 15;
		}
		if( strFieldName.equals("RiskFlag") ) {
			return 16;
		}
		if( strFieldName.equals("PolType") ) {
			return 17;
		}
		if( strFieldName.equals("InvestFlag") ) {
			return 18;
		}
		if( strFieldName.equals("BonusFlag") ) {
			return 19;
		}
		if( strFieldName.equals("BonusMode") ) {
			return 20;
		}
		if( strFieldName.equals("ListFlag") ) {
			return 21;
		}
		if( strFieldName.equals("CalDigital") ) {
			return 22;
		}
		if( strFieldName.equals("CalChomode") ) {
			return 23;
		}
		if( strFieldName.equals("RiskAmntmult") ) {
			return 24;
		}
		if( strFieldName.equals("InsuperiodFlag") ) {
			return 25;
		}
		if( strFieldName.equals("MaxEndPeriod") ) {
			return 26;
		}
		if( strFieldName.equals("AgeLmt") ) {
			return 27;
		}
		if( strFieldName.equals("SignDateCalMode") ) {
			return 28;
		}
		if( strFieldName.equals("ProtocolFlag") ) {
			return 29;
		}
		if( strFieldName.equals("GetChgFlag") ) {
			return 30;
		}
		if( strFieldName.equals("ProtocolPayFlag") ) {
			return 31;
		}
		if( strFieldName.equals("EnSuplanFlag") ) {
			return 32;
		}
		if( strFieldName.equals("EnSuplanAdjFlag") ) {
			return 33;
		}
		if( strFieldName.equals("AppInterest") ) {
			return 34;
		}
		if( strFieldName.equals("AppPremrate") ) {
			return 35;
		}
		if( strFieldName.equals("InSuredFlag") ) {
			return 36;
		}
		if( strFieldName.equals("ShareFlag") ) {
			return 37;
		}
		if( strFieldName.equals("BnfFlag") ) {
			return 38;
		}
		if( strFieldName.equals("TempPayFlag") ) {
			return 39;
		}
		if( strFieldName.equals("InpPayPlan") ) {
			return 40;
		}
		if( strFieldName.equals("ImpartFlag") ) {
			return 41;
		}
		if( strFieldName.equals("InsuexpeFlag") ) {
			return 42;
		}
		if( strFieldName.equals("LoanFlag") ) {
			return 43;
		}
		if( strFieldName.equals("MortagageFlag") ) {
			return 44;
		}
		if( strFieldName.equals("IdifreturnFlag") ) {
			return 45;
		}
		if( strFieldName.equals("CutamntstopPay") ) {
			return 46;
		}
		if( strFieldName.equals("RinsRate") ) {
			return 47;
		}
		if( strFieldName.equals("SaleFlag") ) {
			return 48;
		}
		if( strFieldName.equals("FileAppFlag") ) {
			return 49;
		}
		if( strFieldName.equals("MngCom") ) {
			return 50;
		}
		if( strFieldName.equals("AutoPayFlag") ) {
			return 51;
		}
		if( strFieldName.equals("NeedPrintHospital") ) {
			return 52;
		}
		if( strFieldName.equals("NeedPrintGet") ) {
			return 53;
		}
		if( strFieldName.equals("NotPrintPol") ) {
			return 54;
		}
		if( strFieldName.equals("NeedGetPolDate") ) {
			return 55;
		}
		if( strFieldName.equals("NeedRereadBank") ) {
			return 56;
		}
		if( strFieldName.equals("SpecFlag") ) {
			return 57;
		}
		if( strFieldName.equals("InterestDifFlag") ) {
			return 58;
		}
		if( strFieldName.equals("MinappntAge") ) {
			return 59;
		}
		if( strFieldName.equals("MaxAppntAge") ) {
			return 60;
		}
		if( strFieldName.equals("MaxInsuredAge") ) {
			return 61;
		}
		if( strFieldName.equals("MinInsuredAge") ) {
			return 62;
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
				strFieldName = "RiskCode";
				break;
			case 1:
				strFieldName = "RiskProp";
				break;
			case 2:
				strFieldName = "RiskVer";
				break;
			case 3:
				strFieldName = "RiskName";
				break;
			case 4:
				strFieldName = "SubRiskFlag";
				break;
			case 5:
				strFieldName = "KindCode";
				break;
			case 6:
				strFieldName = "StartDate";
				break;
			case 7:
				strFieldName = "EndDate";
				break;
			case 8:
				strFieldName = "RiskType";
				break;
			case 9:
				strFieldName = "RiskType1";
				break;
			case 10:
				strFieldName = "RiskType2";
				break;
			case 11:
				strFieldName = "RiskType3";
				break;
			case 12:
				strFieldName = "RiskType4";
				break;
			case 13:
				strFieldName = "RiskType5";
				break;
			case 14:
				strFieldName = "RiskPeriod";
				break;
			case 15:
				strFieldName = "RiskFlagDetail";
				break;
			case 16:
				strFieldName = "RiskFlag";
				break;
			case 17:
				strFieldName = "PolType";
				break;
			case 18:
				strFieldName = "InvestFlag";
				break;
			case 19:
				strFieldName = "BonusFlag";
				break;
			case 20:
				strFieldName = "BonusMode";
				break;
			case 21:
				strFieldName = "ListFlag";
				break;
			case 22:
				strFieldName = "CalDigital";
				break;
			case 23:
				strFieldName = "CalChomode";
				break;
			case 24:
				strFieldName = "RiskAmntmult";
				break;
			case 25:
				strFieldName = "InsuperiodFlag";
				break;
			case 26:
				strFieldName = "MaxEndPeriod";
				break;
			case 27:
				strFieldName = "AgeLmt";
				break;
			case 28:
				strFieldName = "SignDateCalMode";
				break;
			case 29:
				strFieldName = "ProtocolFlag";
				break;
			case 30:
				strFieldName = "GetChgFlag";
				break;
			case 31:
				strFieldName = "ProtocolPayFlag";
				break;
			case 32:
				strFieldName = "EnSuplanFlag";
				break;
			case 33:
				strFieldName = "EnSuplanAdjFlag";
				break;
			case 34:
				strFieldName = "AppInterest";
				break;
			case 35:
				strFieldName = "AppPremrate";
				break;
			case 36:
				strFieldName = "InSuredFlag";
				break;
			case 37:
				strFieldName = "ShareFlag";
				break;
			case 38:
				strFieldName = "BnfFlag";
				break;
			case 39:
				strFieldName = "TempPayFlag";
				break;
			case 40:
				strFieldName = "InpPayPlan";
				break;
			case 41:
				strFieldName = "ImpartFlag";
				break;
			case 42:
				strFieldName = "InsuexpeFlag";
				break;
			case 43:
				strFieldName = "LoanFlag";
				break;
			case 44:
				strFieldName = "MortagageFlag";
				break;
			case 45:
				strFieldName = "IdifreturnFlag";
				break;
			case 46:
				strFieldName = "CutamntstopPay";
				break;
			case 47:
				strFieldName = "RinsRate";
				break;
			case 48:
				strFieldName = "SaleFlag";
				break;
			case 49:
				strFieldName = "FileAppFlag";
				break;
			case 50:
				strFieldName = "MngCom";
				break;
			case 51:
				strFieldName = "AutoPayFlag";
				break;
			case 52:
				strFieldName = "NeedPrintHospital";
				break;
			case 53:
				strFieldName = "NeedPrintGet";
				break;
			case 54:
				strFieldName = "NotPrintPol";
				break;
			case 55:
				strFieldName = "NeedGetPolDate";
				break;
			case 56:
				strFieldName = "NeedRereadBank";
				break;
			case 57:
				strFieldName = "SpecFlag";
				break;
			case 58:
				strFieldName = "InterestDifFlag";
				break;
			case 59:
				strFieldName = "MinappntAge";
				break;
			case 60:
				strFieldName = "MaxAppntAge";
				break;
			case 61:
				strFieldName = "MaxInsuredAge";
				break;
			case 62:
				strFieldName = "MinInsuredAge";
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
		if( strFieldName.equals("RiskCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskProp") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskVer") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SubRiskFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("KindCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("EndDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("RiskType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskType1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskType2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskType3") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskType4") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskType5") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskPeriod") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskFlagDetail") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PolType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InvestFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BonusFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BonusMode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ListFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalDigital") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("CalChomode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RiskAmntmult") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("InsuperiodFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MaxEndPeriod") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("AgeLmt") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("SignDateCalMode") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("ProtocolFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GetChgFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ProtocolPayFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EnSuplanFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EnSuplanAdjFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AppInterest") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("AppPremrate") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("InSuredFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ShareFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BnfFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TempPayFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InpPayPlan") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ImpartFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InsuexpeFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("LoanFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MortagageFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IdifreturnFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CutamntstopPay") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("RinsRate") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("SaleFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("FileAppFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MngCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AutoPayFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NeedPrintHospital") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NeedPrintGet") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NotPrintPol") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NeedGetPolDate") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NeedRereadBank") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SpecFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("InterestDifFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MinappntAge") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("MaxAppntAge") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("MaxInsuredAge") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("MinInsuredAge") ) {
			return Schema.TYPE_INT;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_INT;
				break;
			case 23:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 24:
				nFieldType = Schema.TYPE_INT;
				break;
			case 25:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 26:
				nFieldType = Schema.TYPE_INT;
				break;
			case 27:
				nFieldType = Schema.TYPE_INT;
				break;
			case 28:
				nFieldType = Schema.TYPE_INT;
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
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 35:
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_INT;
				break;
			case 60:
				nFieldType = Schema.TYPE_INT;
				break;
			case 61:
				nFieldType = Schema.TYPE_INT;
				break;
			case 62:
				nFieldType = Schema.TYPE_INT;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
