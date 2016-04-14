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
import com.sinosoft.lis.db.LATreeBDB;

/*
 * <p>ClassName: LATreeBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LATreeB
 */
public class LATreeBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LATreeBSchema.class);
	// @Field
	/** Agentcode */
	private String AgentCode;
	/** Branchtype */
	private String BranchType;
	/** Agentgroup */
	private String AgentGroup;
	/** Managecom */
	private String ManageCom;
	/** 代理人职级 */
	private String AgentGrade;
	/** 职级起始日 */
	private Date GradeStartDate;
	/** 代理人子职级 */
	private String AgentSubGrade;
	/** 子职级起始日 */
	private Date SubGradeStartDate;
	/** Effectivedate */
	private Date EffectiveDate;
	/** Transfereffectivedate */
	private Date TransferEffectiveDate;
	/** Regionbranchattr */
	private String RegionBranchAttr;
	/** Divisionbranchattr */
	private String DivisionBranchAttr;
	/** Unitbranchattr */
	private String UnitBranchAttr;
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
	/** Nextregionbranchattr */
	private String NextRegionBranchAttr;
	/** Nextdivisionbranchattr */
	private String NextDivisionBranchAttr;
	/** Nextunitbranchattr */
	private String NextUnitBranchAttr;
	/** Nextrepmanagercode */
	private String NextRepManagerCode;
	/** Nextrepmanagername */
	private String NextRepManagerName;
	/** Nextagentgrade */
	private String NextAgentGrade;
	/** Currentrepmanagercode */
	private String CurrentRepManagerCode;
	/** Currentrepmanagername */
	private String CurrentRepManagerName;
	/** Currentrepmanagergrade */
	private String CurrentRepManagerGrade;
	/** Currentname */
	private String CurrentName;
	/** Nextrepmanagergrade */
	private String NextRepManagerGrade;
	/** Nexteffectivedate */
	private Date NextEffectiveDate;
	/** Nexttraneffectivedate */
	private Date NextTranEffectiveDate;

	public static final int FIELDNUM = 34;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LATreeBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "AgentCode";
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
		LATreeBSchema cloned = (LATreeBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

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
	* BranchType
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
	* AgentGroup
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
	* 代理人职级【Agent Title，下拉A01-SDD】
	*/
	public String getAgentGrade()
	{
		return AgentGrade;
	}
	public void setAgentGrade(String aAgentGrade)
	{
		if(aAgentGrade!=null && aAgentGrade.length()>10)
			throw new IllegalArgumentException("代理人职级AgentGrade值"+aAgentGrade+"的长度"+aAgentGrade.length()+"大于最大值10");
		AgentGrade = aAgentGrade;
	}
	/**
	* 职级起始日
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
	* 代理人子职级
	*/
	public String getAgentSubGrade()
	{
		return AgentSubGrade;
	}
	public void setAgentSubGrade(String aAgentSubGrade)
	{
		if(aAgentSubGrade!=null && aAgentSubGrade.length()>10)
			throw new IllegalArgumentException("代理人子职级AgentSubGrade值"+aAgentSubGrade+"的长度"+aAgentSubGrade.length()+"大于最大值10");
		AgentSubGrade = aAgentSubGrade;
	}
	/**
	* 子职级起始日
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
	* EffectiveDate
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
	* TransferEffectiveDate
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
	public String getNextRegionBranchAttr()
	{
		return NextRegionBranchAttr;
	}
	public void setNextRegionBranchAttr(String aNextRegionBranchAttr)
	{
		if(aNextRegionBranchAttr!=null && aNextRegionBranchAttr.length()>20)
			throw new IllegalArgumentException("NextregionbranchattrNextRegionBranchAttr值"+aNextRegionBranchAttr+"的长度"+aNextRegionBranchAttr.length()+"大于最大值20");
		NextRegionBranchAttr = aNextRegionBranchAttr;
	}
	public String getNextDivisionBranchAttr()
	{
		return NextDivisionBranchAttr;
	}
	public void setNextDivisionBranchAttr(String aNextDivisionBranchAttr)
	{
		if(aNextDivisionBranchAttr!=null && aNextDivisionBranchAttr.length()>20)
			throw new IllegalArgumentException("NextdivisionbranchattrNextDivisionBranchAttr值"+aNextDivisionBranchAttr+"的长度"+aNextDivisionBranchAttr.length()+"大于最大值20");
		NextDivisionBranchAttr = aNextDivisionBranchAttr;
	}
	public String getNextUnitBranchAttr()
	{
		return NextUnitBranchAttr;
	}
	public void setNextUnitBranchAttr(String aNextUnitBranchAttr)
	{
		if(aNextUnitBranchAttr!=null && aNextUnitBranchAttr.length()>20)
			throw new IllegalArgumentException("NextunitbranchattrNextUnitBranchAttr值"+aNextUnitBranchAttr+"的长度"+aNextUnitBranchAttr.length()+"大于最大值20");
		NextUnitBranchAttr = aNextUnitBranchAttr;
	}
	public String getNextRepManagerCode()
	{
		return NextRepManagerCode;
	}
	public void setNextRepManagerCode(String aNextRepManagerCode)
	{
		if(aNextRepManagerCode!=null && aNextRepManagerCode.length()>12)
			throw new IllegalArgumentException("NextrepmanagercodeNextRepManagerCode值"+aNextRepManagerCode+"的长度"+aNextRepManagerCode.length()+"大于最大值12");
		NextRepManagerCode = aNextRepManagerCode;
	}
	public String getNextRepManagerName()
	{
		return NextRepManagerName;
	}
	public void setNextRepManagerName(String aNextRepManagerName)
	{
		if(aNextRepManagerName!=null && aNextRepManagerName.length()>100)
			throw new IllegalArgumentException("NextrepmanagernameNextRepManagerName值"+aNextRepManagerName+"的长度"+aNextRepManagerName.length()+"大于最大值100");
		NextRepManagerName = aNextRepManagerName;
	}
	public String getNextAgentGrade()
	{
		return NextAgentGrade;
	}
	public void setNextAgentGrade(String aNextAgentGrade)
	{
		if(aNextAgentGrade!=null && aNextAgentGrade.length()>10)
			throw new IllegalArgumentException("NextagentgradeNextAgentGrade值"+aNextAgentGrade+"的长度"+aNextAgentGrade.length()+"大于最大值10");
		NextAgentGrade = aNextAgentGrade;
	}
	public String getCurrentRepManagerCode()
	{
		return CurrentRepManagerCode;
	}
	public void setCurrentRepManagerCode(String aCurrentRepManagerCode)
	{
		if(aCurrentRepManagerCode!=null && aCurrentRepManagerCode.length()>12)
			throw new IllegalArgumentException("CurrentrepmanagercodeCurrentRepManagerCode值"+aCurrentRepManagerCode+"的长度"+aCurrentRepManagerCode.length()+"大于最大值12");
		CurrentRepManagerCode = aCurrentRepManagerCode;
	}
	public String getCurrentRepManagerName()
	{
		return CurrentRepManagerName;
	}
	public void setCurrentRepManagerName(String aCurrentRepManagerName)
	{
		if(aCurrentRepManagerName!=null && aCurrentRepManagerName.length()>100)
			throw new IllegalArgumentException("CurrentrepmanagernameCurrentRepManagerName值"+aCurrentRepManagerName+"的长度"+aCurrentRepManagerName.length()+"大于最大值100");
		CurrentRepManagerName = aCurrentRepManagerName;
	}
	public String getCurrentRepManagerGrade()
	{
		return CurrentRepManagerGrade;
	}
	public void setCurrentRepManagerGrade(String aCurrentRepManagerGrade)
	{
		if(aCurrentRepManagerGrade!=null && aCurrentRepManagerGrade.length()>10)
			throw new IllegalArgumentException("CurrentrepmanagergradeCurrentRepManagerGrade值"+aCurrentRepManagerGrade+"的长度"+aCurrentRepManagerGrade.length()+"大于最大值10");
		CurrentRepManagerGrade = aCurrentRepManagerGrade;
	}
	public String getCurrentName()
	{
		return CurrentName;
	}
	public void setCurrentName(String aCurrentName)
	{
		if(aCurrentName!=null && aCurrentName.length()>100)
			throw new IllegalArgumentException("CurrentnameCurrentName值"+aCurrentName+"的长度"+aCurrentName.length()+"大于最大值100");
		CurrentName = aCurrentName;
	}
	public String getNextRepManagerGrade()
	{
		return NextRepManagerGrade;
	}
	public void setNextRepManagerGrade(String aNextRepManagerGrade)
	{
		if(aNextRepManagerGrade!=null && aNextRepManagerGrade.length()>10)
			throw new IllegalArgumentException("NextrepmanagergradeNextRepManagerGrade值"+aNextRepManagerGrade+"的长度"+aNextRepManagerGrade.length()+"大于最大值10");
		NextRepManagerGrade = aNextRepManagerGrade;
	}
	public String getNextEffectiveDate()
	{
		if( NextEffectiveDate != null )
			return fDate.getString(NextEffectiveDate);
		else
			return null;
	}
	public void setNextEffectiveDate(Date aNextEffectiveDate)
	{
		NextEffectiveDate = aNextEffectiveDate;
	}
	public void setNextEffectiveDate(String aNextEffectiveDate)
	{
		if (aNextEffectiveDate != null && !aNextEffectiveDate.equals("") )
		{
			NextEffectiveDate = fDate.getDate( aNextEffectiveDate );
		}
		else
			NextEffectiveDate = null;
	}

	public String getNextTranEffectiveDate()
	{
		if( NextTranEffectiveDate != null )
			return fDate.getString(NextTranEffectiveDate);
		else
			return null;
	}
	public void setNextTranEffectiveDate(Date aNextTranEffectiveDate)
	{
		NextTranEffectiveDate = aNextTranEffectiveDate;
	}
	public void setNextTranEffectiveDate(String aNextTranEffectiveDate)
	{
		if (aNextTranEffectiveDate != null && !aNextTranEffectiveDate.equals("") )
		{
			NextTranEffectiveDate = fDate.getDate( aNextTranEffectiveDate );
		}
		else
			NextTranEffectiveDate = null;
	}


	/**
	* 使用另外一个 LATreeBSchema 对象给 Schema 赋值
	* @param: aLATreeBSchema LATreeBSchema
	**/
	public void setSchema(LATreeBSchema aLATreeBSchema)
	{
		this.AgentCode = aLATreeBSchema.getAgentCode();
		this.BranchType = aLATreeBSchema.getBranchType();
		this.AgentGroup = aLATreeBSchema.getAgentGroup();
		this.ManageCom = aLATreeBSchema.getManageCom();
		this.AgentGrade = aLATreeBSchema.getAgentGrade();
		this.GradeStartDate = fDate.getDate( aLATreeBSchema.getGradeStartDate());
		this.AgentSubGrade = aLATreeBSchema.getAgentSubGrade();
		this.SubGradeStartDate = fDate.getDate( aLATreeBSchema.getSubGradeStartDate());
		this.EffectiveDate = fDate.getDate( aLATreeBSchema.getEffectiveDate());
		this.TransferEffectiveDate = fDate.getDate( aLATreeBSchema.getTransferEffectiveDate());
		this.RegionBranchAttr = aLATreeBSchema.getRegionBranchAttr();
		this.DivisionBranchAttr = aLATreeBSchema.getDivisionBranchAttr();
		this.UnitBranchAttr = aLATreeBSchema.getUnitBranchAttr();
		this.Operator = aLATreeBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLATreeBSchema.getMakeDate());
		this.MakeTime = aLATreeBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLATreeBSchema.getModifyDate());
		this.ModifyTime = aLATreeBSchema.getModifyTime();
		this.Operator1 = aLATreeBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLATreeBSchema.getMakeDate1());
		this.MakeTime1 = aLATreeBSchema.getMakeTime1();
		this.NextRegionBranchAttr = aLATreeBSchema.getNextRegionBranchAttr();
		this.NextDivisionBranchAttr = aLATreeBSchema.getNextDivisionBranchAttr();
		this.NextUnitBranchAttr = aLATreeBSchema.getNextUnitBranchAttr();
		this.NextRepManagerCode = aLATreeBSchema.getNextRepManagerCode();
		this.NextRepManagerName = aLATreeBSchema.getNextRepManagerName();
		this.NextAgentGrade = aLATreeBSchema.getNextAgentGrade();
		this.CurrentRepManagerCode = aLATreeBSchema.getCurrentRepManagerCode();
		this.CurrentRepManagerName = aLATreeBSchema.getCurrentRepManagerName();
		this.CurrentRepManagerGrade = aLATreeBSchema.getCurrentRepManagerGrade();
		this.CurrentName = aLATreeBSchema.getCurrentName();
		this.NextRepManagerGrade = aLATreeBSchema.getNextRepManagerGrade();
		this.NextEffectiveDate = fDate.getDate( aLATreeBSchema.getNextEffectiveDate());
		this.NextTranEffectiveDate = fDate.getDate( aLATreeBSchema.getNextTranEffectiveDate());
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
			if( rs.getString("RegionBranchAttr") == null )
				this.RegionBranchAttr = null;
			else
				this.RegionBranchAttr = rs.getString("RegionBranchAttr").trim();

			if( rs.getString("DivisionBranchAttr") == null )
				this.DivisionBranchAttr = null;
			else
				this.DivisionBranchAttr = rs.getString("DivisionBranchAttr").trim();

			if( rs.getString("UnitBranchAttr") == null )
				this.UnitBranchAttr = null;
			else
				this.UnitBranchAttr = rs.getString("UnitBranchAttr").trim();

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

			if( rs.getString("NextRegionBranchAttr") == null )
				this.NextRegionBranchAttr = null;
			else
				this.NextRegionBranchAttr = rs.getString("NextRegionBranchAttr").trim();

			if( rs.getString("NextDivisionBranchAttr") == null )
				this.NextDivisionBranchAttr = null;
			else
				this.NextDivisionBranchAttr = rs.getString("NextDivisionBranchAttr").trim();

			if( rs.getString("NextUnitBranchAttr") == null )
				this.NextUnitBranchAttr = null;
			else
				this.NextUnitBranchAttr = rs.getString("NextUnitBranchAttr").trim();

			if( rs.getString("NextRepManagerCode") == null )
				this.NextRepManagerCode = null;
			else
				this.NextRepManagerCode = rs.getString("NextRepManagerCode").trim();

			if( rs.getString("NextRepManagerName") == null )
				this.NextRepManagerName = null;
			else
				this.NextRepManagerName = rs.getString("NextRepManagerName").trim();

			if( rs.getString("NextAgentGrade") == null )
				this.NextAgentGrade = null;
			else
				this.NextAgentGrade = rs.getString("NextAgentGrade").trim();

			if( rs.getString("CurrentRepManagerCode") == null )
				this.CurrentRepManagerCode = null;
			else
				this.CurrentRepManagerCode = rs.getString("CurrentRepManagerCode").trim();

			if( rs.getString("CurrentRepManagerName") == null )
				this.CurrentRepManagerName = null;
			else
				this.CurrentRepManagerName = rs.getString("CurrentRepManagerName").trim();

			if( rs.getString("CurrentRepManagerGrade") == null )
				this.CurrentRepManagerGrade = null;
			else
				this.CurrentRepManagerGrade = rs.getString("CurrentRepManagerGrade").trim();

			if( rs.getString("CurrentName") == null )
				this.CurrentName = null;
			else
				this.CurrentName = rs.getString("CurrentName").trim();

			if( rs.getString("NextRepManagerGrade") == null )
				this.NextRepManagerGrade = null;
			else
				this.NextRepManagerGrade = rs.getString("NextRepManagerGrade").trim();

			this.NextEffectiveDate = rs.getDate("NextEffectiveDate");
			this.NextTranEffectiveDate = rs.getDate("NextTranEffectiveDate");
		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LATreeB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LATreeBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LATreeBSchema getSchema()
	{
		LATreeBSchema aLATreeBSchema = new LATreeBSchema();
		aLATreeBSchema.setSchema(this);
		return aLATreeBSchema;
	}

	public LATreeBDB getDB()
	{
		LATreeBDB aDBOper = new LATreeBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLATreeB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( GradeStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentSubGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( SubGradeStartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( EffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( TransferEffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(RegionBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DivisionBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(UnitBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NextRegionBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NextDivisionBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NextUnitBranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NextRepManagerCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NextRepManagerName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NextAgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CurrentRepManagerCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CurrentRepManagerName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CurrentRepManagerGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CurrentName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NextRepManagerGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( NextEffectiveDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( NextTranEffectiveDate )));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLATreeB>历史记账凭证主表信息</A>表字段
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
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			GradeStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			AgentSubGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			SubGradeStartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			EffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			TransferEffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			RegionBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			DivisionBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			UnitBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			NextRegionBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			NextDivisionBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			NextUnitBranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			NextRepManagerCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			NextRepManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			NextAgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, SysConst.PACKAGESPILTER );
			CurrentRepManagerCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
			CurrentRepManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, SysConst.PACKAGESPILTER );
			CurrentRepManagerGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, SysConst.PACKAGESPILTER );
			CurrentName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, SysConst.PACKAGESPILTER );
			NextRepManagerGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, SysConst.PACKAGESPILTER );
			NextEffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33,SysConst.PACKAGESPILTER));
			NextTranEffectiveDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34,SysConst.PACKAGESPILTER));
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LATreeBSchema";
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
		if (FCode.equalsIgnoreCase("RegionBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(RegionBranchAttr));
		}
		if (FCode.equalsIgnoreCase("DivisionBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DivisionBranchAttr));
		}
		if (FCode.equalsIgnoreCase("UnitBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UnitBranchAttr));
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
		if (FCode.equalsIgnoreCase("NextRegionBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NextRegionBranchAttr));
		}
		if (FCode.equalsIgnoreCase("NextDivisionBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NextDivisionBranchAttr));
		}
		if (FCode.equalsIgnoreCase("NextUnitBranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NextUnitBranchAttr));
		}
		if (FCode.equalsIgnoreCase("NextRepManagerCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NextRepManagerCode));
		}
		if (FCode.equalsIgnoreCase("NextRepManagerName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NextRepManagerName));
		}
		if (FCode.equalsIgnoreCase("NextAgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NextAgentGrade));
		}
		if (FCode.equalsIgnoreCase("CurrentRepManagerCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CurrentRepManagerCode));
		}
		if (FCode.equalsIgnoreCase("CurrentRepManagerName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CurrentRepManagerName));
		}
		if (FCode.equalsIgnoreCase("CurrentRepManagerGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CurrentRepManagerGrade));
		}
		if (FCode.equalsIgnoreCase("CurrentName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CurrentName));
		}
		if (FCode.equalsIgnoreCase("NextRepManagerGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NextRepManagerGrade));
		}
		if (FCode.equalsIgnoreCase("NextEffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getNextEffectiveDate()));
		}
		if (FCode.equalsIgnoreCase("NextTranEffectiveDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getNextTranEffectiveDate()));
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
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getGradeStartDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentSubGrade);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getSubGradeStartDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEffectiveDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getTransferEffectiveDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(RegionBranchAttr);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(DivisionBranchAttr);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(UnitBranchAttr);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(NextRegionBranchAttr);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(NextDivisionBranchAttr);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(NextUnitBranchAttr);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(NextRepManagerCode);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(NextRepManagerName);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(NextAgentGrade);
				break;
			case 27:
				strFieldValue = StrTool.GBKToUnicode(CurrentRepManagerCode);
				break;
			case 28:
				strFieldValue = StrTool.GBKToUnicode(CurrentRepManagerName);
				break;
			case 29:
				strFieldValue = StrTool.GBKToUnicode(CurrentRepManagerGrade);
				break;
			case 30:
				strFieldValue = StrTool.GBKToUnicode(CurrentName);
				break;
			case 31:
				strFieldValue = StrTool.GBKToUnicode(NextRepManagerGrade);
				break;
			case 32:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getNextEffectiveDate()));
				break;
			case 33:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getNextTranEffectiveDate()));
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
		if (FCode.equalsIgnoreCase("RegionBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				RegionBranchAttr = FValue.trim();
			}
			else
				RegionBranchAttr = null;
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
		if (FCode.equalsIgnoreCase("UnitBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UnitBranchAttr = FValue.trim();
			}
			else
				UnitBranchAttr = null;
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
		if (FCode.equalsIgnoreCase("NextRegionBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NextRegionBranchAttr = FValue.trim();
			}
			else
				NextRegionBranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("NextDivisionBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NextDivisionBranchAttr = FValue.trim();
			}
			else
				NextDivisionBranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("NextUnitBranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NextUnitBranchAttr = FValue.trim();
			}
			else
				NextUnitBranchAttr = null;
		}
		if (FCode.equalsIgnoreCase("NextRepManagerCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NextRepManagerCode = FValue.trim();
			}
			else
				NextRepManagerCode = null;
		}
		if (FCode.equalsIgnoreCase("NextRepManagerName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NextRepManagerName = FValue.trim();
			}
			else
				NextRepManagerName = null;
		}
		if (FCode.equalsIgnoreCase("NextAgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NextAgentGrade = FValue.trim();
			}
			else
				NextAgentGrade = null;
		}
		if (FCode.equalsIgnoreCase("CurrentRepManagerCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CurrentRepManagerCode = FValue.trim();
			}
			else
				CurrentRepManagerCode = null;
		}
		if (FCode.equalsIgnoreCase("CurrentRepManagerName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CurrentRepManagerName = FValue.trim();
			}
			else
				CurrentRepManagerName = null;
		}
		if (FCode.equalsIgnoreCase("CurrentRepManagerGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CurrentRepManagerGrade = FValue.trim();
			}
			else
				CurrentRepManagerGrade = null;
		}
		if (FCode.equalsIgnoreCase("CurrentName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CurrentName = FValue.trim();
			}
			else
				CurrentName = null;
		}
		if (FCode.equalsIgnoreCase("NextRepManagerGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NextRepManagerGrade = FValue.trim();
			}
			else
				NextRepManagerGrade = null;
		}
		if (FCode.equalsIgnoreCase("NextEffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				NextEffectiveDate = fDate.getDate( FValue );
			}
			else
				NextEffectiveDate = null;
		}
		if (FCode.equalsIgnoreCase("NextTranEffectiveDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				NextTranEffectiveDate = fDate.getDate( FValue );
			}
			else
				NextTranEffectiveDate = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LATreeBSchema other = (LATreeBSchema)otherObject;
		return
			AgentCode.equals(other.getAgentCode())
			&& BranchType.equals(other.getBranchType())
			&& AgentGroup.equals(other.getAgentGroup())
			&& ManageCom.equals(other.getManageCom())
			&& AgentGrade.equals(other.getAgentGrade())
			&& fDate.getString(GradeStartDate).equals(other.getGradeStartDate())
			&& AgentSubGrade.equals(other.getAgentSubGrade())
			&& fDate.getString(SubGradeStartDate).equals(other.getSubGradeStartDate())
			&& fDate.getString(EffectiveDate).equals(other.getEffectiveDate())
			&& fDate.getString(TransferEffectiveDate).equals(other.getTransferEffectiveDate())
			&& RegionBranchAttr.equals(other.getRegionBranchAttr())
			&& DivisionBranchAttr.equals(other.getDivisionBranchAttr())
			&& UnitBranchAttr.equals(other.getUnitBranchAttr())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator1.equals(other.getOperator1())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1())
			&& NextRegionBranchAttr.equals(other.getNextRegionBranchAttr())
			&& NextDivisionBranchAttr.equals(other.getNextDivisionBranchAttr())
			&& NextUnitBranchAttr.equals(other.getNextUnitBranchAttr())
			&& NextRepManagerCode.equals(other.getNextRepManagerCode())
			&& NextRepManagerName.equals(other.getNextRepManagerName())
			&& NextAgentGrade.equals(other.getNextAgentGrade())
			&& CurrentRepManagerCode.equals(other.getCurrentRepManagerCode())
			&& CurrentRepManagerName.equals(other.getCurrentRepManagerName())
			&& CurrentRepManagerGrade.equals(other.getCurrentRepManagerGrade())
			&& CurrentName.equals(other.getCurrentName())
			&& NextRepManagerGrade.equals(other.getNextRepManagerGrade())
			&& fDate.getString(NextEffectiveDate).equals(other.getNextEffectiveDate())
			&& fDate.getString(NextTranEffectiveDate).equals(other.getNextTranEffectiveDate());
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
		if( strFieldName.equals("AgentGrade") ) {
			return 4;
		}
		if( strFieldName.equals("GradeStartDate") ) {
			return 5;
		}
		if( strFieldName.equals("AgentSubGrade") ) {
			return 6;
		}
		if( strFieldName.equals("SubGradeStartDate") ) {
			return 7;
		}
		if( strFieldName.equals("EffectiveDate") ) {
			return 8;
		}
		if( strFieldName.equals("TransferEffectiveDate") ) {
			return 9;
		}
		if( strFieldName.equals("RegionBranchAttr") ) {
			return 10;
		}
		if( strFieldName.equals("DivisionBranchAttr") ) {
			return 11;
		}
		if( strFieldName.equals("UnitBranchAttr") ) {
			return 12;
		}
		if( strFieldName.equals("Operator") ) {
			return 13;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 14;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 15;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 16;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 17;
		}
		if( strFieldName.equals("Operator1") ) {
			return 18;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 19;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 20;
		}
		if( strFieldName.equals("NextRegionBranchAttr") ) {
			return 21;
		}
		if( strFieldName.equals("NextDivisionBranchAttr") ) {
			return 22;
		}
		if( strFieldName.equals("NextUnitBranchAttr") ) {
			return 23;
		}
		if( strFieldName.equals("NextRepManagerCode") ) {
			return 24;
		}
		if( strFieldName.equals("NextRepManagerName") ) {
			return 25;
		}
		if( strFieldName.equals("NextAgentGrade") ) {
			return 26;
		}
		if( strFieldName.equals("CurrentRepManagerCode") ) {
			return 27;
		}
		if( strFieldName.equals("CurrentRepManagerName") ) {
			return 28;
		}
		if( strFieldName.equals("CurrentRepManagerGrade") ) {
			return 29;
		}
		if( strFieldName.equals("CurrentName") ) {
			return 30;
		}
		if( strFieldName.equals("NextRepManagerGrade") ) {
			return 31;
		}
		if( strFieldName.equals("NextEffectiveDate") ) {
			return 32;
		}
		if( strFieldName.equals("NextTranEffectiveDate") ) {
			return 33;
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
				strFieldName = "AgentGrade";
				break;
			case 5:
				strFieldName = "GradeStartDate";
				break;
			case 6:
				strFieldName = "AgentSubGrade";
				break;
			case 7:
				strFieldName = "SubGradeStartDate";
				break;
			case 8:
				strFieldName = "EffectiveDate";
				break;
			case 9:
				strFieldName = "TransferEffectiveDate";
				break;
			case 10:
				strFieldName = "RegionBranchAttr";
				break;
			case 11:
				strFieldName = "DivisionBranchAttr";
				break;
			case 12:
				strFieldName = "UnitBranchAttr";
				break;
			case 13:
				strFieldName = "Operator";
				break;
			case 14:
				strFieldName = "MakeDate";
				break;
			case 15:
				strFieldName = "MakeTime";
				break;
			case 16:
				strFieldName = "ModifyDate";
				break;
			case 17:
				strFieldName = "ModifyTime";
				break;
			case 18:
				strFieldName = "Operator1";
				break;
			case 19:
				strFieldName = "MakeDate1";
				break;
			case 20:
				strFieldName = "MakeTime1";
				break;
			case 21:
				strFieldName = "NextRegionBranchAttr";
				break;
			case 22:
				strFieldName = "NextDivisionBranchAttr";
				break;
			case 23:
				strFieldName = "NextUnitBranchAttr";
				break;
			case 24:
				strFieldName = "NextRepManagerCode";
				break;
			case 25:
				strFieldName = "NextRepManagerName";
				break;
			case 26:
				strFieldName = "NextAgentGrade";
				break;
			case 27:
				strFieldName = "CurrentRepManagerCode";
				break;
			case 28:
				strFieldName = "CurrentRepManagerName";
				break;
			case 29:
				strFieldName = "CurrentRepManagerGrade";
				break;
			case 30:
				strFieldName = "CurrentName";
				break;
			case 31:
				strFieldName = "NextRepManagerGrade";
				break;
			case 32:
				strFieldName = "NextEffectiveDate";
				break;
			case 33:
				strFieldName = "NextTranEffectiveDate";
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
		if( strFieldName.equals("RegionBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DivisionBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UnitBranchAttr") ) {
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
		if( strFieldName.equals("NextRegionBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NextDivisionBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NextUnitBranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NextRepManagerCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NextRepManagerName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NextAgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CurrentRepManagerCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CurrentRepManagerName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CurrentRepManagerGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CurrentName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NextRepManagerGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NextEffectiveDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("NextTranEffectiveDate") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 33:
				nFieldType = Schema.TYPE_DATE;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
