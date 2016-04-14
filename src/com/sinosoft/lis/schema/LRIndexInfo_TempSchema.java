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
import com.sinosoft.lis.db.LRIndexInfo_TempDB;

/*
 * <p>ClassName: LRIndexInfo_TempSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRIndexInfo_TempSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LRIndexInfo_TempSchema.class);
	// @Field
	/** Wageno */
	private String WageNo;
	/** Indextype */
	private String IndexType;
	/** Branchtype */
	private String BranchType;
	/** Branchtype2 */
	private String BranchType2;
	/** Basecode */
	private String BaseCode;
	/** Indexcode */
	private String IndexCode;
	/** Agentcode */
	private String AgentCode;
	/** Agentgrade */
	private String AgentGrade;
	/** Managecom */
	private String ManageCom;
	/** Branchattr */
	private String BranchAttr;
	/** Agentgroup */
	private String AgentGroup;
	/** Branchseries */
	private String BranchSeries;
	/** State */
	private String State;
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
	/** Datatype */
	private String DataType;
	/** D */
	private Date D;
	/** N0 */
	private int N0;
	/** N2 */
	private double N2;
	/** N4 */
	private double N4;
	/** N6 */
	private double N6;
	/** S */
	private String S;
	/** Mainindexflag */
	private String MainIndexFlag;
	/** Wagename */
	private String WageName;
	/** Wagecode */
	private String WageCode;
	/** Caltype */
	private String CalType;

	public static final int FIELDNUM = 29;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LRIndexInfo_TempSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[7];
		pk[0] = "WageNo";
		pk[1] = "IndexType";
		pk[2] = "BranchType";
		pk[3] = "BranchType2";
		pk[4] = "BaseCode";
		pk[5] = "IndexCode";
		pk[6] = "AgentCode";

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
		LRIndexInfo_TempSchema cloned = (LRIndexInfo_TempSchema)super.clone();
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
	* 月份
	*/
	public String getWageNo()
	{
		return WageNo;
	}
	public void setWageNo(String aWageNo)
	{
		if(aWageNo!=null && aWageNo.length()>10)
			throw new IllegalArgumentException("WagenoWageNo值"+aWageNo+"的长度"+aWageNo.length()+"大于最大值10");
		WageNo = aWageNo;
	}
	/**
	* 项目类型
	*/
	public String getIndexType()
	{
		return IndexType;
	}
	public void setIndexType(String aIndexType)
	{
		if(aIndexType!=null && aIndexType.length()>2)
			throw new IllegalArgumentException("IndextypeIndexType值"+aIndexType+"的长度"+aIndexType.length()+"大于最大值2");
		IndexType = aIndexType;
	}
	/**
	* 渠道
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
	* 子渠道
	*/
	public String getBranchType2()
	{
		return BranchType2;
	}
	public void setBranchType2(String aBranchType2)
	{
		if(aBranchType2!=null && aBranchType2.length()>2)
			throw new IllegalArgumentException("Branchtype2BranchType2值"+aBranchType2+"的长度"+aBranchType2.length()+"大于最大值2");
		BranchType2 = aBranchType2;
	}
	/**
	* 基本法编码
	*/
	public String getBaseCode()
	{
		return BaseCode;
	}
	public void setBaseCode(String aBaseCode)
	{
		if(aBaseCode!=null && aBaseCode.length()>10)
			throw new IllegalArgumentException("BasecodeBaseCode值"+aBaseCode+"的长度"+aBaseCode.length()+"大于最大值10");
		BaseCode = aBaseCode;
	}
	/**
	* 规则编码
	*/
	public String getIndexCode()
	{
		return IndexCode;
	}
	public void setIndexCode(String aIndexCode)
	{
		if(aIndexCode!=null && aIndexCode.length()>10)
			throw new IllegalArgumentException("IndexcodeIndexCode值"+aIndexCode+"的长度"+aIndexCode.length()+"大于最大值10");
		IndexCode = aIndexCode;
	}
	/**
	* 代理人代码
	*/
	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>20)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值20");
		AgentCode = aAgentCode;
	}
	/**
	* 代理人职级
	*/
	public String getAgentGrade()
	{
		return AgentGrade;
	}
	public void setAgentGrade(String aAgentGrade)
	{
		if(aAgentGrade!=null && aAgentGrade.length()>6)
			throw new IllegalArgumentException("AgentgradeAgentGrade值"+aAgentGrade+"的长度"+aAgentGrade.length()+"大于最大值6");
		AgentGrade = aAgentGrade;
	}
	/**
	* 管理机构
	*/
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
	/**
	* 机构代码
	*/
	public String getBranchAttr()
	{
		return BranchAttr;
	}
	public void setBranchAttr(String aBranchAttr)
	{
		if(aBranchAttr!=null && aBranchAttr.length()>20)
			throw new IllegalArgumentException("BranchattrBranchAttr值"+aBranchAttr+"的长度"+aBranchAttr.length()+"大于最大值20");
		BranchAttr = aBranchAttr;
	}
	/**
	* 代理人机构
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
	* 机构序列
	*/
	public String getBranchSeries()
	{
		return BranchSeries;
	}
	public void setBranchSeries(String aBranchSeries)
	{
		if(aBranchSeries!=null && aBranchSeries.length()>200)
			throw new IllegalArgumentException("BranchseriesBranchSeries值"+aBranchSeries+"的长度"+aBranchSeries.length()+"大于最大值200");
		BranchSeries = aBranchSeries;
	}
	/**
	* 状态
	*/
	public String getState()
	{
		return State;
	}
	public void setState(String aState)
	{
		if(aState!=null && aState.length()>20)
			throw new IllegalArgumentException("StateState值"+aState+"的长度"+aState.length()+"大于最大值20");
		State = aState;
	}
	/**
	* 操作人
	*/
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>80)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值80");
		Operator = aOperator;
	}
	/**
	* 入机日期
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
	* 入机时间
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
	* 修改日期
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
	* 修改时间
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
	* 数据类型
	*/
	public String getDataType()
	{
		return DataType;
	}
	public void setDataType(String aDataType)
	{
		if(aDataType!=null && aDataType.length()>10)
			throw new IllegalArgumentException("DatatypeDataType值"+aDataType+"的长度"+aDataType.length()+"大于最大值10");
		DataType = aDataType;
	}
	/**
	* 日期字段
	*/
	public String getD()
	{
		if( D != null )
			return fDate.getString(D);
		else
			return null;
	}
	public void setD(Date aD)
	{
		D = aD;
	}
	public void setD(String aD)
	{
		if (aD != null && !aD.equals("") )
		{
			D = fDate.getDate( aD );
		}
		else
			D = null;
	}

	/**
	* 数字字段
	*/
	public int getN0()
	{
		return N0;
	}
	public void setN0(int aN0)
	{
		N0 = aN0;
	}
	public void setN0(String aN0)
	{
		if (aN0 != null && !aN0.equals(""))
		{
			Integer tInteger = new Integer(aN0);
			int i = tInteger.intValue();
			N0 = i;
		}
	}

	/**
	* 两位数字字段
	*/
	public double getN2()
	{
		return N2;
	}
	public void setN2(double aN2)
	{
		N2 = aN2;
	}
	public void setN2(String aN2)
	{
		if (aN2 != null && !aN2.equals(""))
		{
			Double tDouble = new Double(aN2);
			double d = tDouble.doubleValue();
			N2 = d;
		}
	}

	/**
	* 四位数字字段
	*/
	public double getN4()
	{
		return N4;
	}
	public void setN4(double aN4)
	{
		N4 = aN4;
	}
	public void setN4(String aN4)
	{
		if (aN4 != null && !aN4.equals(""))
		{
			Double tDouble = new Double(aN4);
			double d = tDouble.doubleValue();
			N4 = d;
		}
	}

	/**
	* 六位数字字段
	*/
	public double getN6()
	{
		return N6;
	}
	public void setN6(double aN6)
	{
		N6 = aN6;
	}
	public void setN6(String aN6)
	{
		if (aN6 != null && !aN6.equals(""))
		{
			Double tDouble = new Double(aN6);
			double d = tDouble.doubleValue();
			N6 = d;
		}
	}

	/**
	* 字符串字段
	*/
	public String getS()
	{
		return S;
	}
	public void setS(String aS)
	{
		if(aS!=null && aS.length()>100)
			throw new IllegalArgumentException("SS值"+aS+"的长度"+aS.length()+"大于最大值100");
		S = aS;
	}
	/**
	* 主附标志
	*/
	public String getMainIndexFlag()
	{
		return MainIndexFlag;
	}
	public void setMainIndexFlag(String aMainIndexFlag)
	{
		if(aMainIndexFlag!=null && aMainIndexFlag.length()>1)
			throw new IllegalArgumentException("MainindexflagMainIndexFlag值"+aMainIndexFlag+"的长度"+aMainIndexFlag.length()+"大于最大值1");
		MainIndexFlag = aMainIndexFlag;
	}
	/**
	* 项目名称
	*/
	public String getWageName()
	{
		return WageName;
	}
	public void setWageName(String aWageName)
	{
		if(aWageName!=null && aWageName.length()>200)
			throw new IllegalArgumentException("WagenameWageName值"+aWageName+"的长度"+aWageName.length()+"大于最大值200");
		WageName = aWageName;
	}
	/**
	* 项目编码
	*/
	public String getWageCode()
	{
		return WageCode;
	}
	public void setWageCode(String aWageCode)
	{
		if(aWageCode!=null && aWageCode.length()>20)
			throw new IllegalArgumentException("WagecodeWageCode值"+aWageCode+"的长度"+aWageCode.length()+"大于最大值20");
		WageCode = aWageCode;
	}
	/**
	* 考核类型
	*/
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
	* 使用另外一个 LRIndexInfo_TempSchema 对象给 Schema 赋值
	* @param: aLRIndexInfo_TempSchema LRIndexInfo_TempSchema
	**/
	public void setSchema(LRIndexInfo_TempSchema aLRIndexInfo_TempSchema)
	{
		this.WageNo = aLRIndexInfo_TempSchema.getWageNo();
		this.IndexType = aLRIndexInfo_TempSchema.getIndexType();
		this.BranchType = aLRIndexInfo_TempSchema.getBranchType();
		this.BranchType2 = aLRIndexInfo_TempSchema.getBranchType2();
		this.BaseCode = aLRIndexInfo_TempSchema.getBaseCode();
		this.IndexCode = aLRIndexInfo_TempSchema.getIndexCode();
		this.AgentCode = aLRIndexInfo_TempSchema.getAgentCode();
		this.AgentGrade = aLRIndexInfo_TempSchema.getAgentGrade();
		this.ManageCom = aLRIndexInfo_TempSchema.getManageCom();
		this.BranchAttr = aLRIndexInfo_TempSchema.getBranchAttr();
		this.AgentGroup = aLRIndexInfo_TempSchema.getAgentGroup();
		this.BranchSeries = aLRIndexInfo_TempSchema.getBranchSeries();
		this.State = aLRIndexInfo_TempSchema.getState();
		this.Operator = aLRIndexInfo_TempSchema.getOperator();
		this.MakeDate = fDate.getDate( aLRIndexInfo_TempSchema.getMakeDate());
		this.MakeTime = aLRIndexInfo_TempSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLRIndexInfo_TempSchema.getModifyDate());
		this.ModifyTime = aLRIndexInfo_TempSchema.getModifyTime();
		this.DataType = aLRIndexInfo_TempSchema.getDataType();
		this.D = fDate.getDate( aLRIndexInfo_TempSchema.getD());
		this.N0 = aLRIndexInfo_TempSchema.getN0();
		this.N2 = aLRIndexInfo_TempSchema.getN2();
		this.N4 = aLRIndexInfo_TempSchema.getN4();
		this.N6 = aLRIndexInfo_TempSchema.getN6();
		this.S = aLRIndexInfo_TempSchema.getS();
		this.MainIndexFlag = aLRIndexInfo_TempSchema.getMainIndexFlag();
		this.WageName = aLRIndexInfo_TempSchema.getWageName();
		this.WageCode = aLRIndexInfo_TempSchema.getWageCode();
		this.CalType = aLRIndexInfo_TempSchema.getCalType();
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
			if( rs.getString("WageNo") == null )
				this.WageNo = null;
			else
				this.WageNo = rs.getString("WageNo").trim();

			if( rs.getString("IndexType") == null )
				this.IndexType = null;
			else
				this.IndexType = rs.getString("IndexType").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("BranchType2") == null )
				this.BranchType2 = null;
			else
				this.BranchType2 = rs.getString("BranchType2").trim();

			if( rs.getString("BaseCode") == null )
				this.BaseCode = null;
			else
				this.BaseCode = rs.getString("BaseCode").trim();

			if( rs.getString("IndexCode") == null )
				this.IndexCode = null;
			else
				this.IndexCode = rs.getString("IndexCode").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("BranchAttr") == null )
				this.BranchAttr = null;
			else
				this.BranchAttr = rs.getString("BranchAttr").trim();

			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("BranchSeries") == null )
				this.BranchSeries = null;
			else
				this.BranchSeries = rs.getString("BranchSeries").trim();

			if( rs.getString("State") == null )
				this.State = null;
			else
				this.State = rs.getString("State").trim();

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

			if( rs.getString("DataType") == null )
				this.DataType = null;
			else
				this.DataType = rs.getString("DataType").trim();

			this.D = rs.getDate("D");
			this.N0 = rs.getInt("N0");
			this.N2 = rs.getDouble("N2");
			this.N4 = rs.getDouble("N4");
			this.N6 = rs.getDouble("N6");
			if( rs.getString("S") == null )
				this.S = null;
			else
				this.S = rs.getString("S").trim();

			if( rs.getString("MainIndexFlag") == null )
				this.MainIndexFlag = null;
			else
				this.MainIndexFlag = rs.getString("MainIndexFlag").trim();

			if( rs.getString("WageName") == null )
				this.WageName = null;
			else
				this.WageName = rs.getString("WageName").trim();

			if( rs.getString("WageCode") == null )
				this.WageCode = null;
			else
				this.WageCode = rs.getString("WageCode").trim();

			if( rs.getString("CalType") == null )
				this.CalType = null;
			else
				this.CalType = rs.getString("CalType").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LRIndexInfo_Temp表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexInfo_TempSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LRIndexInfo_TempSchema getSchema()
	{
		LRIndexInfo_TempSchema aLRIndexInfo_TempSchema = new LRIndexInfo_TempSchema();
		aLRIndexInfo_TempSchema.setSchema(this);
		return aLRIndexInfo_TempSchema;
	}

	public LRIndexInfo_TempDB getDB()
	{
		LRIndexInfo_TempDB aDBOper = new LRIndexInfo_TempDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRIndexInfo_Temp描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(WageNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BaseCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchAttr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchSeries)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(State)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DataType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( D ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(N0));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(N2));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(N4));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(N6));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(S)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainIndexFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalType));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRIndexInfo_Temp>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			WageNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			IndexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BranchType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			BaseCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			IndexCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			BranchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			BranchSeries = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			DataType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			D = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20,SysConst.PACKAGESPILTER));
			N0= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,21,SysConst.PACKAGESPILTER))).intValue();
			N2 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,22,SysConst.PACKAGESPILTER))).doubleValue();
			N4 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,23,SysConst.PACKAGESPILTER))).doubleValue();
			N6 = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,24,SysConst.PACKAGESPILTER))).doubleValue();
			S = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			MainIndexFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			WageName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, SysConst.PACKAGESPILTER );
			WageCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
			CalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexInfo_TempSchema";
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
		if (FCode.equalsIgnoreCase("WageNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageNo));
		}
		if (FCode.equalsIgnoreCase("IndexType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexType));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType2));
		}
		if (FCode.equalsIgnoreCase("BaseCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BaseCode));
		}
		if (FCode.equalsIgnoreCase("IndexCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexCode));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchAttr));
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("BranchSeries"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchSeries));
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(State));
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
		if (FCode.equalsIgnoreCase("DataType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DataType));
		}
		if (FCode.equalsIgnoreCase("D"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getD()));
		}
		if (FCode.equalsIgnoreCase("N0"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(N0));
		}
		if (FCode.equalsIgnoreCase("N2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(N2));
		}
		if (FCode.equalsIgnoreCase("N4"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(N4));
		}
		if (FCode.equalsIgnoreCase("N6"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(N6));
		}
		if (FCode.equalsIgnoreCase("S"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(S));
		}
		if (FCode.equalsIgnoreCase("MainIndexFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainIndexFlag));
		}
		if (FCode.equalsIgnoreCase("WageName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageName));
		}
		if (FCode.equalsIgnoreCase("WageCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageCode));
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalType));
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
				strFieldValue = StrTool.GBKToUnicode(WageNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(IndexType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(BranchType2);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(BaseCode);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(IndexCode);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(BranchAttr);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(BranchSeries);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(State);
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
				strFieldValue = StrTool.GBKToUnicode(DataType);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getD()));
				break;
			case 20:
				strFieldValue = String.valueOf(N0);
				break;
			case 21:
				strFieldValue = String.valueOf(N2);
				break;
			case 22:
				strFieldValue = String.valueOf(N4);
				break;
			case 23:
				strFieldValue = String.valueOf(N6);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(S);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(MainIndexFlag);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(WageName);
				break;
			case 27:
				strFieldValue = StrTool.GBKToUnicode(WageCode);
				break;
			case 28:
				strFieldValue = StrTool.GBKToUnicode(CalType);
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

		if (FCode.equalsIgnoreCase("WageNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageNo = FValue.trim();
			}
			else
				WageNo = null;
		}
		if (FCode.equalsIgnoreCase("IndexType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexType = FValue.trim();
			}
			else
				IndexType = null;
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
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType2 = FValue.trim();
			}
			else
				BranchType2 = null;
		}
		if (FCode.equalsIgnoreCase("BaseCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BaseCode = FValue.trim();
			}
			else
				BaseCode = null;
		}
		if (FCode.equalsIgnoreCase("IndexCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexCode = FValue.trim();
			}
			else
				IndexCode = null;
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
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGrade = FValue.trim();
			}
			else
				AgentGrade = null;
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
		if (FCode.equalsIgnoreCase("BranchAttr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchAttr = FValue.trim();
			}
			else
				BranchAttr = null;
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
		if (FCode.equalsIgnoreCase("BranchSeries"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchSeries = FValue.trim();
			}
			else
				BranchSeries = null;
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				State = FValue.trim();
			}
			else
				State = null;
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
		if (FCode.equalsIgnoreCase("DataType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DataType = FValue.trim();
			}
			else
				DataType = null;
		}
		if (FCode.equalsIgnoreCase("D"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				D = fDate.getDate( FValue );
			}
			else
				D = null;
		}
		if (FCode.equalsIgnoreCase("N0"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				N0 = i;
			}
		}
		if (FCode.equalsIgnoreCase("N2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				N2 = d;
			}
		}
		if (FCode.equalsIgnoreCase("N4"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				N4 = d;
			}
		}
		if (FCode.equalsIgnoreCase("N6"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				N6 = d;
			}
		}
		if (FCode.equalsIgnoreCase("S"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				S = FValue.trim();
			}
			else
				S = null;
		}
		if (FCode.equalsIgnoreCase("MainIndexFlag"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MainIndexFlag = FValue.trim();
			}
			else
				MainIndexFlag = null;
		}
		if (FCode.equalsIgnoreCase("WageName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageName = FValue.trim();
			}
			else
				WageName = null;
		}
		if (FCode.equalsIgnoreCase("WageCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageCode = FValue.trim();
			}
			else
				WageCode = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LRIndexInfo_TempSchema other = (LRIndexInfo_TempSchema)otherObject;
		return
			WageNo.equals(other.getWageNo())
			&& IndexType.equals(other.getIndexType())
			&& BranchType.equals(other.getBranchType())
			&& BranchType2.equals(other.getBranchType2())
			&& BaseCode.equals(other.getBaseCode())
			&& IndexCode.equals(other.getIndexCode())
			&& AgentCode.equals(other.getAgentCode())
			&& AgentGrade.equals(other.getAgentGrade())
			&& ManageCom.equals(other.getManageCom())
			&& BranchAttr.equals(other.getBranchAttr())
			&& AgentGroup.equals(other.getAgentGroup())
			&& BranchSeries.equals(other.getBranchSeries())
			&& State.equals(other.getState())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& DataType.equals(other.getDataType())
			&& fDate.getString(D).equals(other.getD())
			&& N0 == other.getN0()
			&& N2 == other.getN2()
			&& N4 == other.getN4()
			&& N6 == other.getN6()
			&& S.equals(other.getS())
			&& MainIndexFlag.equals(other.getMainIndexFlag())
			&& WageName.equals(other.getWageName())
			&& WageCode.equals(other.getWageCode())
			&& CalType.equals(other.getCalType());
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
		if( strFieldName.equals("WageNo") ) {
			return 0;
		}
		if( strFieldName.equals("IndexType") ) {
			return 1;
		}
		if( strFieldName.equals("BranchType") ) {
			return 2;
		}
		if( strFieldName.equals("BranchType2") ) {
			return 3;
		}
		if( strFieldName.equals("BaseCode") ) {
			return 4;
		}
		if( strFieldName.equals("IndexCode") ) {
			return 5;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 6;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 7;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 8;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return 9;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 10;
		}
		if( strFieldName.equals("BranchSeries") ) {
			return 11;
		}
		if( strFieldName.equals("State") ) {
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
		if( strFieldName.equals("DataType") ) {
			return 18;
		}
		if( strFieldName.equals("D") ) {
			return 19;
		}
		if( strFieldName.equals("N0") ) {
			return 20;
		}
		if( strFieldName.equals("N2") ) {
			return 21;
		}
		if( strFieldName.equals("N4") ) {
			return 22;
		}
		if( strFieldName.equals("N6") ) {
			return 23;
		}
		if( strFieldName.equals("S") ) {
			return 24;
		}
		if( strFieldName.equals("MainIndexFlag") ) {
			return 25;
		}
		if( strFieldName.equals("WageName") ) {
			return 26;
		}
		if( strFieldName.equals("WageCode") ) {
			return 27;
		}
		if( strFieldName.equals("CalType") ) {
			return 28;
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
				strFieldName = "WageNo";
				break;
			case 1:
				strFieldName = "IndexType";
				break;
			case 2:
				strFieldName = "BranchType";
				break;
			case 3:
				strFieldName = "BranchType2";
				break;
			case 4:
				strFieldName = "BaseCode";
				break;
			case 5:
				strFieldName = "IndexCode";
				break;
			case 6:
				strFieldName = "AgentCode";
				break;
			case 7:
				strFieldName = "AgentGrade";
				break;
			case 8:
				strFieldName = "ManageCom";
				break;
			case 9:
				strFieldName = "BranchAttr";
				break;
			case 10:
				strFieldName = "AgentGroup";
				break;
			case 11:
				strFieldName = "BranchSeries";
				break;
			case 12:
				strFieldName = "State";
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
				strFieldName = "DataType";
				break;
			case 19:
				strFieldName = "D";
				break;
			case 20:
				strFieldName = "N0";
				break;
			case 21:
				strFieldName = "N2";
				break;
			case 22:
				strFieldName = "N4";
				break;
			case 23:
				strFieldName = "N6";
				break;
			case 24:
				strFieldName = "S";
				break;
			case 25:
				strFieldName = "MainIndexFlag";
				break;
			case 26:
				strFieldName = "WageName";
				break;
			case 27:
				strFieldName = "WageCode";
				break;
			case 28:
				strFieldName = "CalType";
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
		if( strFieldName.equals("WageNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BaseCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchAttr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchSeries") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("State") ) {
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
		if( strFieldName.equals("DataType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("D") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("N0") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("N2") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("N4") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("N6") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("S") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainIndexFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalType") ) {
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
				nFieldType = Schema.TYPE_INT;
				break;
			case 21:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 22:
				nFieldType = Schema.TYPE_DOUBLE;
				break;
			case 23:
				nFieldType = Schema.TYPE_DOUBLE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
