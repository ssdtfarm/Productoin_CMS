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
import com.sinosoft.lis.db.LAAgentGradeDB;

/*
 * <p>ClassName: LAAgentGradeSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LAAgentGrade_Setting
 */
public class LAAgentGradeSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAAgentGradeSchema.class);
	// @Field
	/** Gradecode */
	private String GradeCode;
	/** Gradeid */
	private double GradeId;
	/** Gradename */
	private String GradeName;
	/** Gradelevel */
	private String GradeLevel;
	/** Gradeabbreviation */
	private String GradeAbbreviation;
	/** Dummygradeflag */
	private String DummyGradeFlag;
	/** Gradelevelorder */
	private String GradeLevelOrder;
	/** Remarks */
	private String Remarks;
	/** Branchtype */
	private String BranchType;
	/** Branchtypemapping */
	private String BranchTypeMapping;
	/** Gradereport1 */
	private String GradeReport1;
	/** Gradereport2 */
	private String GradeReport2;
	/** Gradereport3 */
	private String GradeReport3;
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

	public static final int FIELDNUM = 21;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAAgentGradeSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "GradeCode";

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
		LAAgentGradeSchema cloned = (LAAgentGradeSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getGradeCode()
	{
		return GradeCode;
	}
	public void setGradeCode(String aGradeCode)
	{
		if(aGradeCode!=null && aGradeCode.length()>10)
			throw new IllegalArgumentException("GradecodeGradeCode值"+aGradeCode+"的长度"+aGradeCode.length()+"大于最大值10");
		GradeCode = aGradeCode;
	}
	public double getGradeId()
	{
		return GradeId;
	}
	public void setGradeId(double aGradeId)
	{
		GradeId = aGradeId;
	}
	public void setGradeId(String aGradeId)
	{
		if (aGradeId != null && !aGradeId.equals(""))
		{
			Double tDouble = new Double(aGradeId);
			double d = tDouble.doubleValue();
			GradeId = d;
		}
	}

	public String getGradeName()
	{
		return GradeName;
	}
	public void setGradeName(String aGradeName)
	{
		if(aGradeName!=null && aGradeName.length()>40)
			throw new IllegalArgumentException("GradenameGradeName值"+aGradeName+"的长度"+aGradeName.length()+"大于最大值40");
		GradeName = aGradeName;
	}
	public String getGradeLevel()
	{
		return GradeLevel;
	}
	public void setGradeLevel(String aGradeLevel)
	{
		if(aGradeLevel!=null && aGradeLevel.length()>2)
			throw new IllegalArgumentException("GradelevelGradeLevel值"+aGradeLevel+"的长度"+aGradeLevel.length()+"大于最大值2");
		GradeLevel = aGradeLevel;
	}
	public String getGradeAbbreviation()
	{
		return GradeAbbreviation;
	}
	public void setGradeAbbreviation(String aGradeAbbreviation)
	{
		if(aGradeAbbreviation!=null && aGradeAbbreviation.length()>20)
			throw new IllegalArgumentException("GradeabbreviationGradeAbbreviation值"+aGradeAbbreviation+"的长度"+aGradeAbbreviation.length()+"大于最大值20");
		GradeAbbreviation = aGradeAbbreviation;
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
	public String getGradeLevelOrder()
	{
		return GradeLevelOrder;
	}
	public void setGradeLevelOrder(String aGradeLevelOrder)
	{
		if(aGradeLevelOrder!=null && aGradeLevelOrder.length()>2)
			throw new IllegalArgumentException("GradelevelorderGradeLevelOrder值"+aGradeLevelOrder+"的长度"+aGradeLevelOrder.length()+"大于最大值2");
		GradeLevelOrder = aGradeLevelOrder;
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
	public String getBranchTypeMapping()
	{
		return BranchTypeMapping;
	}
	public void setBranchTypeMapping(String aBranchTypeMapping)
	{
		if(aBranchTypeMapping!=null && aBranchTypeMapping.length()>5)
			throw new IllegalArgumentException("BranchtypemappingBranchTypeMapping值"+aBranchTypeMapping+"的长度"+aBranchTypeMapping.length()+"大于最大值5");
		BranchTypeMapping = aBranchTypeMapping;
	}
	public String getGradeReport1()
	{
		return GradeReport1;
	}
	public void setGradeReport1(String aGradeReport1)
	{
		if(aGradeReport1!=null && aGradeReport1.length()>10)
			throw new IllegalArgumentException("Gradereport1GradeReport1值"+aGradeReport1+"的长度"+aGradeReport1.length()+"大于最大值10");
		GradeReport1 = aGradeReport1;
	}
	public String getGradeReport2()
	{
		return GradeReport2;
	}
	public void setGradeReport2(String aGradeReport2)
	{
		if(aGradeReport2!=null && aGradeReport2.length()>10)
			throw new IllegalArgumentException("Gradereport2GradeReport2值"+aGradeReport2+"的长度"+aGradeReport2.length()+"大于最大值10");
		GradeReport2 = aGradeReport2;
	}
	public String getGradeReport3()
	{
		return GradeReport3;
	}
	public void setGradeReport3(String aGradeReport3)
	{
		if(aGradeReport3!=null && aGradeReport3.length()>10)
			throw new IllegalArgumentException("Gradereport3GradeReport3值"+aGradeReport3+"的长度"+aGradeReport3.length()+"大于最大值10");
		GradeReport3 = aGradeReport3;
	}
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
	* 使用另外一个 LAAgentGradeSchema 对象给 Schema 赋值
	* @param: aLAAgentGradeSchema LAAgentGradeSchema
	**/
	public void setSchema(LAAgentGradeSchema aLAAgentGradeSchema)
	{
		this.GradeCode = aLAAgentGradeSchema.getGradeCode();
		this.GradeId = aLAAgentGradeSchema.getGradeId();
		this.GradeName = aLAAgentGradeSchema.getGradeName();
		this.GradeLevel = aLAAgentGradeSchema.getGradeLevel();
		this.GradeAbbreviation = aLAAgentGradeSchema.getGradeAbbreviation();
		this.DummyGradeFlag = aLAAgentGradeSchema.getDummyGradeFlag();
		this.GradeLevelOrder = aLAAgentGradeSchema.getGradeLevelOrder();
		this.Remarks = aLAAgentGradeSchema.getRemarks();
		this.BranchType = aLAAgentGradeSchema.getBranchType();
		this.BranchTypeMapping = aLAAgentGradeSchema.getBranchTypeMapping();
		this.GradeReport1 = aLAAgentGradeSchema.getGradeReport1();
		this.GradeReport2 = aLAAgentGradeSchema.getGradeReport2();
		this.GradeReport3 = aLAAgentGradeSchema.getGradeReport3();
		this.Flag1 = aLAAgentGradeSchema.getFlag1();
		this.Flag2 = aLAAgentGradeSchema.getFlag2();
		this.Flag3 = aLAAgentGradeSchema.getFlag3();
		this.Operator = aLAAgentGradeSchema.getOperator();
		this.MakeDate = fDate.getDate( aLAAgentGradeSchema.getMakeDate());
		this.MakeTime = aLAAgentGradeSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAAgentGradeSchema.getModifyDate());
		this.ModifyTime = aLAAgentGradeSchema.getModifyTime();
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
			if( rs.getString("GradeCode") == null )
				this.GradeCode = null;
			else
				this.GradeCode = rs.getString("GradeCode").trim();

			this.GradeId = rs.getDouble("GradeId");
			if( rs.getString("GradeName") == null )
				this.GradeName = null;
			else
				this.GradeName = rs.getString("GradeName").trim();

			if( rs.getString("GradeLevel") == null )
				this.GradeLevel = null;
			else
				this.GradeLevel = rs.getString("GradeLevel").trim();

			if( rs.getString("GradeAbbreviation") == null )
				this.GradeAbbreviation = null;
			else
				this.GradeAbbreviation = rs.getString("GradeAbbreviation").trim();

			if( rs.getString("DummyGradeFlag") == null )
				this.DummyGradeFlag = null;
			else
				this.DummyGradeFlag = rs.getString("DummyGradeFlag").trim();

			if( rs.getString("GradeLevelOrder") == null )
				this.GradeLevelOrder = null;
			else
				this.GradeLevelOrder = rs.getString("GradeLevelOrder").trim();

			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("BranchTypeMapping") == null )
				this.BranchTypeMapping = null;
			else
				this.BranchTypeMapping = rs.getString("BranchTypeMapping").trim();

			if( rs.getString("GradeReport1") == null )
				this.GradeReport1 = null;
			else
				this.GradeReport1 = rs.getString("GradeReport1").trim();

			if( rs.getString("GradeReport2") == null )
				this.GradeReport2 = null;
			else
				this.GradeReport2 = rs.getString("GradeReport2").trim();

			if( rs.getString("GradeReport3") == null )
				this.GradeReport3 = null;
			else
				this.GradeReport3 = rs.getString("GradeReport3").trim();

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

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAAgentGrade表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentGradeSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAAgentGradeSchema getSchema()
	{
		LAAgentGradeSchema aLAAgentGradeSchema = new LAAgentGradeSchema();
		aLAAgentGradeSchema.setSchema(this);
		return aLAAgentGradeSchema;
	}

	public LAAgentGradeDB getDB()
	{
		LAAgentGradeDB aDBOper = new LAAgentGradeDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentGrade描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(GradeCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(GradeId));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeLevel)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeAbbreviation)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DummyGradeFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeLevelOrder)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchTypeMapping)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeReport1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeReport2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(GradeReport3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Flag3)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAAgentGrade>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			GradeCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			GradeId = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,2,SysConst.PACKAGESPILTER))).doubleValue();
			GradeName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			GradeLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			GradeAbbreviation = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			DummyGradeFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			GradeLevelOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			BranchTypeMapping = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			GradeReport1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			GradeReport2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			GradeReport3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Flag1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Flag2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			Flag3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
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
			tError.moduleName = "LAAgentGradeSchema";
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
		if (FCode.equalsIgnoreCase("GradeCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeCode));
		}
		if (FCode.equalsIgnoreCase("GradeId"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeId));
		}
		if (FCode.equalsIgnoreCase("GradeName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeName));
		}
		if (FCode.equalsIgnoreCase("GradeLevel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeLevel));
		}
		if (FCode.equalsIgnoreCase("GradeAbbreviation"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeAbbreviation));
		}
		if (FCode.equalsIgnoreCase("DummyGradeFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DummyGradeFlag));
		}
		if (FCode.equalsIgnoreCase("GradeLevelOrder"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeLevelOrder));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("BranchTypeMapping"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchTypeMapping));
		}
		if (FCode.equalsIgnoreCase("GradeReport1"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeReport1));
		}
		if (FCode.equalsIgnoreCase("GradeReport2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeReport2));
		}
		if (FCode.equalsIgnoreCase("GradeReport3"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(GradeReport3));
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
				strFieldValue = StrTool.GBKToUnicode(GradeCode);
				break;
			case 1:
				strFieldValue = String.valueOf(GradeId);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(GradeName);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(GradeLevel);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(GradeAbbreviation);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(DummyGradeFlag);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(GradeLevelOrder);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(BranchTypeMapping);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(GradeReport1);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(GradeReport2);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(GradeReport3);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(Flag1);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Flag2);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(Flag3);
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

		if (FCode.equalsIgnoreCase("GradeCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeCode = FValue.trim();
			}
			else
				GradeCode = null;
		}
		if (FCode.equalsIgnoreCase("GradeId"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				GradeId = d;
			}
		}
		if (FCode.equalsIgnoreCase("GradeName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeName = FValue.trim();
			}
			else
				GradeName = null;
		}
		if (FCode.equalsIgnoreCase("GradeLevel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeLevel = FValue.trim();
			}
			else
				GradeLevel = null;
		}
		if (FCode.equalsIgnoreCase("GradeAbbreviation"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeAbbreviation = FValue.trim();
			}
			else
				GradeAbbreviation = null;
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
		if (FCode.equalsIgnoreCase("GradeLevelOrder"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeLevelOrder = FValue.trim();
			}
			else
				GradeLevelOrder = null;
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
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
		}
		if (FCode.equalsIgnoreCase("BranchTypeMapping"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchTypeMapping = FValue.trim();
			}
			else
				BranchTypeMapping = null;
		}
		if (FCode.equalsIgnoreCase("GradeReport1"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeReport1 = FValue.trim();
			}
			else
				GradeReport1 = null;
		}
		if (FCode.equalsIgnoreCase("GradeReport2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeReport2 = FValue.trim();
			}
			else
				GradeReport2 = null;
		}
		if (FCode.equalsIgnoreCase("GradeReport3"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				GradeReport3 = FValue.trim();
			}
			else
				GradeReport3 = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAAgentGradeSchema other = (LAAgentGradeSchema)otherObject;
		return
			GradeCode.equals(other.getGradeCode())
			&& GradeId == other.getGradeId()
			&& GradeName.equals(other.getGradeName())
			&& GradeLevel.equals(other.getGradeLevel())
			&& GradeAbbreviation.equals(other.getGradeAbbreviation())
			&& DummyGradeFlag.equals(other.getDummyGradeFlag())
			&& GradeLevelOrder.equals(other.getGradeLevelOrder())
			&& Remarks.equals(other.getRemarks())
			&& BranchType.equals(other.getBranchType())
			&& BranchTypeMapping.equals(other.getBranchTypeMapping())
			&& GradeReport1.equals(other.getGradeReport1())
			&& GradeReport2.equals(other.getGradeReport2())
			&& GradeReport3.equals(other.getGradeReport3())
			&& Flag1.equals(other.getFlag1())
			&& Flag2.equals(other.getFlag2())
			&& Flag3.equals(other.getFlag3())
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
		if( strFieldName.equals("GradeCode") ) {
			return 0;
		}
		if( strFieldName.equals("GradeId") ) {
			return 1;
		}
		if( strFieldName.equals("GradeName") ) {
			return 2;
		}
		if( strFieldName.equals("GradeLevel") ) {
			return 3;
		}
		if( strFieldName.equals("GradeAbbreviation") ) {
			return 4;
		}
		if( strFieldName.equals("DummyGradeFlag") ) {
			return 5;
		}
		if( strFieldName.equals("GradeLevelOrder") ) {
			return 6;
		}
		if( strFieldName.equals("Remarks") ) {
			return 7;
		}
		if( strFieldName.equals("BranchType") ) {
			return 8;
		}
		if( strFieldName.equals("BranchTypeMapping") ) {
			return 9;
		}
		if( strFieldName.equals("GradeReport1") ) {
			return 10;
		}
		if( strFieldName.equals("GradeReport2") ) {
			return 11;
		}
		if( strFieldName.equals("GradeReport3") ) {
			return 12;
		}
		if( strFieldName.equals("Flag1") ) {
			return 13;
		}
		if( strFieldName.equals("Flag2") ) {
			return 14;
		}
		if( strFieldName.equals("Flag3") ) {
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
				strFieldName = "GradeCode";
				break;
			case 1:
				strFieldName = "GradeId";
				break;
			case 2:
				strFieldName = "GradeName";
				break;
			case 3:
				strFieldName = "GradeLevel";
				break;
			case 4:
				strFieldName = "GradeAbbreviation";
				break;
			case 5:
				strFieldName = "DummyGradeFlag";
				break;
			case 6:
				strFieldName = "GradeLevelOrder";
				break;
			case 7:
				strFieldName = "Remarks";
				break;
			case 8:
				strFieldName = "BranchType";
				break;
			case 9:
				strFieldName = "BranchTypeMapping";
				break;
			case 10:
				strFieldName = "GradeReport1";
				break;
			case 11:
				strFieldName = "GradeReport2";
				break;
			case 12:
				strFieldName = "GradeReport3";
				break;
			case 13:
				strFieldName = "Flag1";
				break;
			case 14:
				strFieldName = "Flag2";
				break;
			case 15:
				strFieldName = "Flag3";
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
		if( strFieldName.equals("GradeCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeId") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("GradeName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeLevel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeAbbreviation") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DummyGradeFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeLevelOrder") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remarks") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchTypeMapping") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeReport1") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeReport2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("GradeReport3") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
