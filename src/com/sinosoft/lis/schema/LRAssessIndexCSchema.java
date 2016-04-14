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
import com.sinosoft.lis.db.LRAssessIndexCDB;

/*
 * <p>ClassName: LRAssessIndexCSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRAssessIndexCSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LRAssessIndexCSchema.class);
	// @Field
	/** Bakmonth */
	private String BakMonth;
	/** Type */
	private String Type;
	/** Basecode */
	private String BaseCode;
	/** Agentgrade */
	private String AgentGrade;
	/** Indexcode */
	private String IndexCode;
	/** Indexname */
	private String IndexName;
	/** Indexset */
	private String IndexSet;
	/** Mainindexflag */
	private String MainIndexFlag;
	/** Indextype */
	private String IndexType;
	/** Indexserise */
	private String IndexSerise;
	/** Caltype */
	private String CalType;
	/** Calcode */
	private String CalCode;
	/** Datatype */
	private String DataType;
	/** Resulttype */
	private String ResultType;
	/** Calprpty */
	private String CalPrpty;
	/** Defaultvalue */
	private String DefaultValue;
	/** Description */
	private String Description;
	/** Allset */
	private String AllSet;
	/** Calsql */
	private String CalSql;
	/** Itablename */
	private String ITableName;
	/** Icolname */
	private String IColName;
	/** Branchtype */
	private String BranchType;
	/** Branchtype2 */
	private String BranchType2;
	/** Json */
	private String Json;
	/** Sqltemp */
	private String SqlTemp;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;

	public static final int FIELDNUM = 27;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LRAssessIndexCSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[6];
		pk[0] = "BakMonth";
		pk[1] = "Type";
		pk[2] = "BaseCode";
		pk[3] = "AgentGrade";
		pk[4] = "IndexCode";
		pk[5] = "IndexType";

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
		LRAssessIndexCSchema cloned = (LRAssessIndexCSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

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
	public String getType()
	{
		return Type;
	}
	public void setType(String aType)
	{
		if(aType!=null && aType.length()>2)
			throw new IllegalArgumentException("TypeType值"+aType+"的长度"+aType.length()+"大于最大值2");
		Type = aType;
	}
	public String getBaseCode()
	{
		return BaseCode;
	}
	public void setBaseCode(String aBaseCode)
	{
		if(aBaseCode!=null && aBaseCode.length()>20)
			throw new IllegalArgumentException("BasecodeBaseCode值"+aBaseCode+"的长度"+aBaseCode.length()+"大于最大值20");
		BaseCode = aBaseCode;
	}
	public String getAgentGrade()
	{
		return AgentGrade;
	}
	public void setAgentGrade(String aAgentGrade)
	{
		if(aAgentGrade!=null && aAgentGrade.length()>10)
			throw new IllegalArgumentException("AgentgradeAgentGrade值"+aAgentGrade+"的长度"+aAgentGrade.length()+"大于最大值10");
		AgentGrade = aAgentGrade;
	}
	public String getIndexCode()
	{
		return IndexCode;
	}
	public void setIndexCode(String aIndexCode)
	{
		if(aIndexCode!=null && aIndexCode.length()>20)
			throw new IllegalArgumentException("IndexcodeIndexCode值"+aIndexCode+"的长度"+aIndexCode.length()+"大于最大值20");
		IndexCode = aIndexCode;
	}
	public String getIndexName()
	{
		return IndexName;
	}
	public void setIndexName(String aIndexName)
	{
		if(aIndexName!=null && aIndexName.length()>200)
			throw new IllegalArgumentException("IndexnameIndexName值"+aIndexName+"的长度"+aIndexName.length()+"大于最大值200");
		IndexName = aIndexName;
	}
	public String getIndexSet()
	{
		return IndexSet;
	}
	public void setIndexSet(String aIndexSet)
	{
		if(aIndexSet!=null && aIndexSet.length()>400)
			throw new IllegalArgumentException("IndexsetIndexSet值"+aIndexSet+"的长度"+aIndexSet.length()+"大于最大值400");
		IndexSet = aIndexSet;
	}
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
	public String getIndexSerise()
	{
		return IndexSerise;
	}
	public void setIndexSerise(String aIndexSerise)
	{
		if(aIndexSerise!=null && aIndexSerise.length()>2)
			throw new IllegalArgumentException("IndexseriseIndexSerise值"+aIndexSerise+"的长度"+aIndexSerise.length()+"大于最大值2");
		IndexSerise = aIndexSerise;
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
	public String getCalCode()
	{
		return CalCode;
	}
	public void setCalCode(String aCalCode)
	{
		if(aCalCode!=null && aCalCode.length()>20)
			throw new IllegalArgumentException("CalcodeCalCode值"+aCalCode+"的长度"+aCalCode.length()+"大于最大值20");
		CalCode = aCalCode;
	}
	public String getDataType()
	{
		return DataType;
	}
	public void setDataType(String aDataType)
	{
		if(aDataType!=null && aDataType.length()>2)
			throw new IllegalArgumentException("DatatypeDataType值"+aDataType+"的长度"+aDataType.length()+"大于最大值2");
		DataType = aDataType;
	}
	public String getResultType()
	{
		return ResultType;
	}
	public void setResultType(String aResultType)
	{
		if(aResultType!=null && aResultType.length()>2)
			throw new IllegalArgumentException("ResulttypeResultType值"+aResultType+"的长度"+aResultType.length()+"大于最大值2");
		ResultType = aResultType;
	}
	public String getCalPrpty()
	{
		return CalPrpty;
	}
	public void setCalPrpty(String aCalPrpty)
	{
		if(aCalPrpty!=null && aCalPrpty.length()>2)
			throw new IllegalArgumentException("CalprptyCalPrpty值"+aCalPrpty+"的长度"+aCalPrpty.length()+"大于最大值2");
		CalPrpty = aCalPrpty;
	}
	public String getDefaultValue()
	{
		return DefaultValue;
	}
	public void setDefaultValue(String aDefaultValue)
	{
		if(aDefaultValue!=null && aDefaultValue.length()>20)
			throw new IllegalArgumentException("DefaultvalueDefaultValue值"+aDefaultValue+"的长度"+aDefaultValue.length()+"大于最大值20");
		DefaultValue = aDefaultValue;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String aDescription)
	{
		if(aDescription!=null && aDescription.length()>500)
			throw new IllegalArgumentException("DescriptionDescription值"+aDescription+"的长度"+aDescription.length()+"大于最大值500");
		Description = aDescription;
	}
	public String getAllSet()
	{
		return AllSet;
	}
	public void setAllSet(String aAllSet)
	{
		AllSet = aAllSet;
	}
	public String getCalSql()
	{
		return CalSql;
	}
	public void setCalSql(String aCalSql)
	{
		CalSql = aCalSql;
	}
	public String getITableName()
	{
		return ITableName;
	}
	public void setITableName(String aITableName)
	{
		if(aITableName!=null && aITableName.length()>50)
			throw new IllegalArgumentException("ItablenameITableName值"+aITableName+"的长度"+aITableName.length()+"大于最大值50");
		ITableName = aITableName;
	}
	public String getIColName()
	{
		return IColName;
	}
	public void setIColName(String aIColName)
	{
		if(aIColName!=null && aIColName.length()>50)
			throw new IllegalArgumentException("IcolnameIColName值"+aIColName+"的长度"+aIColName.length()+"大于最大值50");
		IColName = aIColName;
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
	public String getJson()
	{
		return Json;
	}
	public void setJson(String aJson)
	{
		Json = aJson;
	}
	public String getSqlTemp()
	{
		return SqlTemp;
	}
	public void setSqlTemp(String aSqlTemp)
	{
		SqlTemp = aSqlTemp;
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

	/**
	* 使用另外一个 LRAssessIndexCSchema 对象给 Schema 赋值
	* @param: aLRAssessIndexCSchema LRAssessIndexCSchema
	**/
	public void setSchema(LRAssessIndexCSchema aLRAssessIndexCSchema)
	{
		this.BakMonth = aLRAssessIndexCSchema.getBakMonth();
		this.Type = aLRAssessIndexCSchema.getType();
		this.BaseCode = aLRAssessIndexCSchema.getBaseCode();
		this.AgentGrade = aLRAssessIndexCSchema.getAgentGrade();
		this.IndexCode = aLRAssessIndexCSchema.getIndexCode();
		this.IndexName = aLRAssessIndexCSchema.getIndexName();
		this.IndexSet = aLRAssessIndexCSchema.getIndexSet();
		this.MainIndexFlag = aLRAssessIndexCSchema.getMainIndexFlag();
		this.IndexType = aLRAssessIndexCSchema.getIndexType();
		this.IndexSerise = aLRAssessIndexCSchema.getIndexSerise();
		this.CalType = aLRAssessIndexCSchema.getCalType();
		this.CalCode = aLRAssessIndexCSchema.getCalCode();
		this.DataType = aLRAssessIndexCSchema.getDataType();
		this.ResultType = aLRAssessIndexCSchema.getResultType();
		this.CalPrpty = aLRAssessIndexCSchema.getCalPrpty();
		this.DefaultValue = aLRAssessIndexCSchema.getDefaultValue();
		this.Description = aLRAssessIndexCSchema.getDescription();
		this.AllSet = aLRAssessIndexCSchema.getAllSet();
		this.CalSql = aLRAssessIndexCSchema.getCalSql();
		this.ITableName = aLRAssessIndexCSchema.getITableName();
		this.IColName = aLRAssessIndexCSchema.getIColName();
		this.BranchType = aLRAssessIndexCSchema.getBranchType();
		this.BranchType2 = aLRAssessIndexCSchema.getBranchType2();
		this.Json = aLRAssessIndexCSchema.getJson();
		this.SqlTemp = aLRAssessIndexCSchema.getSqlTemp();
		this.MakeDate = fDate.getDate( aLRAssessIndexCSchema.getMakeDate());
		this.MakeTime = aLRAssessIndexCSchema.getMakeTime();
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

			if( rs.getString("Type") == null )
				this.Type = null;
			else
				this.Type = rs.getString("Type").trim();

			if( rs.getString("BaseCode") == null )
				this.BaseCode = null;
			else
				this.BaseCode = rs.getString("BaseCode").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("IndexCode") == null )
				this.IndexCode = null;
			else
				this.IndexCode = rs.getString("IndexCode").trim();

			if( rs.getString("IndexName") == null )
				this.IndexName = null;
			else
				this.IndexName = rs.getString("IndexName").trim();

			if( rs.getString("IndexSet") == null )
				this.IndexSet = null;
			else
				this.IndexSet = rs.getString("IndexSet").trim();

			if( rs.getString("MainIndexFlag") == null )
				this.MainIndexFlag = null;
			else
				this.MainIndexFlag = rs.getString("MainIndexFlag").trim();

			if( rs.getString("IndexType") == null )
				this.IndexType = null;
			else
				this.IndexType = rs.getString("IndexType").trim();

			if( rs.getString("IndexSerise") == null )
				this.IndexSerise = null;
			else
				this.IndexSerise = rs.getString("IndexSerise").trim();

			if( rs.getString("CalType") == null )
				this.CalType = null;
			else
				this.CalType = rs.getString("CalType").trim();

			if( rs.getString("CalCode") == null )
				this.CalCode = null;
			else
				this.CalCode = rs.getString("CalCode").trim();

			if( rs.getString("DataType") == null )
				this.DataType = null;
			else
				this.DataType = rs.getString("DataType").trim();

			if( rs.getString("ResultType") == null )
				this.ResultType = null;
			else
				this.ResultType = rs.getString("ResultType").trim();

			if( rs.getString("CalPrpty") == null )
				this.CalPrpty = null;
			else
				this.CalPrpty = rs.getString("CalPrpty").trim();

			if( rs.getString("DefaultValue") == null )
				this.DefaultValue = null;
			else
				this.DefaultValue = rs.getString("DefaultValue").trim();

			if( rs.getString("Description") == null )
				this.Description = null;
			else
				this.Description = rs.getString("Description").trim();

			if( rs.getString("AllSet") == null )
				this.AllSet = null;
			else
				this.AllSet = rs.getString("AllSet").trim();

			if( rs.getString("CalSql") == null )
				this.CalSql = null;
			else
				this.CalSql = rs.getString("CalSql").trim();

			if( rs.getString("ITableName") == null )
				this.ITableName = null;
			else
				this.ITableName = rs.getString("ITableName").trim();

			if( rs.getString("IColName") == null )
				this.IColName = null;
			else
				this.IColName = rs.getString("IColName").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("BranchType2") == null )
				this.BranchType2 = null;
			else
				this.BranchType2 = rs.getString("BranchType2").trim();

			if( rs.getString("Json") == null )
				this.Json = null;
			else
				this.Json = rs.getString("Json").trim();

			if( rs.getString("SqlTemp") == null )
				this.SqlTemp = null;
			else
				this.SqlTemp = rs.getString("SqlTemp").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LRAssessIndexC表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRAssessIndexCSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LRAssessIndexCSchema getSchema()
	{
		LRAssessIndexCSchema aLRAssessIndexCSchema = new LRAssessIndexCSchema();
		aLRAssessIndexCSchema.setSchema(this);
		return aLRAssessIndexCSchema;
	}

	public LRAssessIndexCDB getDB()
	{
		LRAssessIndexCDB aDBOper = new LRAssessIndexCDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRAssessIndexC描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(BakMonth)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Type)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BaseCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexSet)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainIndexFlag)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexSerise)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DataType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ResultType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalPrpty)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DefaultValue)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Description)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AllSet)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalSql)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ITableName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IColName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Json)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(SqlTemp)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRAssessIndexC>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			BakMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			BaseCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			IndexCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			IndexName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			IndexSet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			MainIndexFlag = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			IndexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			IndexSerise = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			CalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			CalCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			DataType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			ResultType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			CalPrpty = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			DefaultValue = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			AllSet = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			CalSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			ITableName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			IColName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			BranchType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			Json = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			SqlTemp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRAssessIndexCSchema";
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
		if (FCode.equalsIgnoreCase("Type"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Type));
		}
		if (FCode.equalsIgnoreCase("BaseCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BaseCode));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("IndexCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexCode));
		}
		if (FCode.equalsIgnoreCase("IndexName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexName));
		}
		if (FCode.equalsIgnoreCase("IndexSet"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexSet));
		}
		if (FCode.equalsIgnoreCase("MainIndexFlag"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainIndexFlag));
		}
		if (FCode.equalsIgnoreCase("IndexType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexType));
		}
		if (FCode.equalsIgnoreCase("IndexSerise"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexSerise));
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalType));
		}
		if (FCode.equalsIgnoreCase("CalCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalCode));
		}
		if (FCode.equalsIgnoreCase("DataType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DataType));
		}
		if (FCode.equalsIgnoreCase("ResultType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ResultType));
		}
		if (FCode.equalsIgnoreCase("CalPrpty"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalPrpty));
		}
		if (FCode.equalsIgnoreCase("DefaultValue"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DefaultValue));
		}
		if (FCode.equalsIgnoreCase("Description"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Description));
		}
		if (FCode.equalsIgnoreCase("AllSet"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AllSet));
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalSql));
		}
		if (FCode.equalsIgnoreCase("ITableName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ITableName));
		}
		if (FCode.equalsIgnoreCase("IColName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IColName));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType2));
		}
		if (FCode.equalsIgnoreCase("Json"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Json));
		}
		if (FCode.equalsIgnoreCase("SqlTemp"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SqlTemp));
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
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
				strFieldValue = StrTool.GBKToUnicode(Type);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(BaseCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(IndexCode);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(IndexName);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(IndexSet);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(MainIndexFlag);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(IndexType);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(IndexSerise);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(CalType);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(CalCode);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(DataType);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(ResultType);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(CalPrpty);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(DefaultValue);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Description);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(AllSet);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(CalSql);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(ITableName);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(IColName);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(BranchType2);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(Json);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(SqlTemp);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
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
		if (FCode.equalsIgnoreCase("Type"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Type = FValue.trim();
			}
			else
				Type = null;
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
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGrade = FValue.trim();
			}
			else
				AgentGrade = null;
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
		if (FCode.equalsIgnoreCase("IndexName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexName = FValue.trim();
			}
			else
				IndexName = null;
		}
		if (FCode.equalsIgnoreCase("IndexSet"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexSet = FValue.trim();
			}
			else
				IndexSet = null;
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
		if (FCode.equalsIgnoreCase("IndexType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexType = FValue.trim();
			}
			else
				IndexType = null;
		}
		if (FCode.equalsIgnoreCase("IndexSerise"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexSerise = FValue.trim();
			}
			else
				IndexSerise = null;
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
		if (FCode.equalsIgnoreCase("CalCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalCode = FValue.trim();
			}
			else
				CalCode = null;
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
		if (FCode.equalsIgnoreCase("ResultType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ResultType = FValue.trim();
			}
			else
				ResultType = null;
		}
		if (FCode.equalsIgnoreCase("CalPrpty"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalPrpty = FValue.trim();
			}
			else
				CalPrpty = null;
		}
		if (FCode.equalsIgnoreCase("DefaultValue"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DefaultValue = FValue.trim();
			}
			else
				DefaultValue = null;
		}
		if (FCode.equalsIgnoreCase("Description"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Description = FValue.trim();
			}
			else
				Description = null;
		}
		if (FCode.equalsIgnoreCase("AllSet"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AllSet = FValue.trim();
			}
			else
				AllSet = null;
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalSql = FValue.trim();
			}
			else
				CalSql = null;
		}
		if (FCode.equalsIgnoreCase("ITableName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ITableName = FValue.trim();
			}
			else
				ITableName = null;
		}
		if (FCode.equalsIgnoreCase("IColName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IColName = FValue.trim();
			}
			else
				IColName = null;
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
		if (FCode.equalsIgnoreCase("Json"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Json = FValue.trim();
			}
			else
				Json = null;
		}
		if (FCode.equalsIgnoreCase("SqlTemp"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				SqlTemp = FValue.trim();
			}
			else
				SqlTemp = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LRAssessIndexCSchema other = (LRAssessIndexCSchema)otherObject;
		return
			BakMonth.equals(other.getBakMonth())
			&& Type.equals(other.getType())
			&& BaseCode.equals(other.getBaseCode())
			&& AgentGrade.equals(other.getAgentGrade())
			&& IndexCode.equals(other.getIndexCode())
			&& IndexName.equals(other.getIndexName())
			&& IndexSet.equals(other.getIndexSet())
			&& MainIndexFlag.equals(other.getMainIndexFlag())
			&& IndexType.equals(other.getIndexType())
			&& IndexSerise.equals(other.getIndexSerise())
			&& CalType.equals(other.getCalType())
			&& CalCode.equals(other.getCalCode())
			&& DataType.equals(other.getDataType())
			&& ResultType.equals(other.getResultType())
			&& CalPrpty.equals(other.getCalPrpty())
			&& DefaultValue.equals(other.getDefaultValue())
			&& Description.equals(other.getDescription())
			&& AllSet.equals(other.getAllSet())
			&& CalSql.equals(other.getCalSql())
			&& ITableName.equals(other.getITableName())
			&& IColName.equals(other.getIColName())
			&& BranchType.equals(other.getBranchType())
			&& BranchType2.equals(other.getBranchType2())
			&& Json.equals(other.getJson())
			&& SqlTemp.equals(other.getSqlTemp())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime());
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
		if( strFieldName.equals("Type") ) {
			return 1;
		}
		if( strFieldName.equals("BaseCode") ) {
			return 2;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 3;
		}
		if( strFieldName.equals("IndexCode") ) {
			return 4;
		}
		if( strFieldName.equals("IndexName") ) {
			return 5;
		}
		if( strFieldName.equals("IndexSet") ) {
			return 6;
		}
		if( strFieldName.equals("MainIndexFlag") ) {
			return 7;
		}
		if( strFieldName.equals("IndexType") ) {
			return 8;
		}
		if( strFieldName.equals("IndexSerise") ) {
			return 9;
		}
		if( strFieldName.equals("CalType") ) {
			return 10;
		}
		if( strFieldName.equals("CalCode") ) {
			return 11;
		}
		if( strFieldName.equals("DataType") ) {
			return 12;
		}
		if( strFieldName.equals("ResultType") ) {
			return 13;
		}
		if( strFieldName.equals("CalPrpty") ) {
			return 14;
		}
		if( strFieldName.equals("DefaultValue") ) {
			return 15;
		}
		if( strFieldName.equals("Description") ) {
			return 16;
		}
		if( strFieldName.equals("AllSet") ) {
			return 17;
		}
		if( strFieldName.equals("CalSql") ) {
			return 18;
		}
		if( strFieldName.equals("ITableName") ) {
			return 19;
		}
		if( strFieldName.equals("IColName") ) {
			return 20;
		}
		if( strFieldName.equals("BranchType") ) {
			return 21;
		}
		if( strFieldName.equals("BranchType2") ) {
			return 22;
		}
		if( strFieldName.equals("Json") ) {
			return 23;
		}
		if( strFieldName.equals("SqlTemp") ) {
			return 24;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 25;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 26;
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
				strFieldName = "Type";
				break;
			case 2:
				strFieldName = "BaseCode";
				break;
			case 3:
				strFieldName = "AgentGrade";
				break;
			case 4:
				strFieldName = "IndexCode";
				break;
			case 5:
				strFieldName = "IndexName";
				break;
			case 6:
				strFieldName = "IndexSet";
				break;
			case 7:
				strFieldName = "MainIndexFlag";
				break;
			case 8:
				strFieldName = "IndexType";
				break;
			case 9:
				strFieldName = "IndexSerise";
				break;
			case 10:
				strFieldName = "CalType";
				break;
			case 11:
				strFieldName = "CalCode";
				break;
			case 12:
				strFieldName = "DataType";
				break;
			case 13:
				strFieldName = "ResultType";
				break;
			case 14:
				strFieldName = "CalPrpty";
				break;
			case 15:
				strFieldName = "DefaultValue";
				break;
			case 16:
				strFieldName = "Description";
				break;
			case 17:
				strFieldName = "AllSet";
				break;
			case 18:
				strFieldName = "CalSql";
				break;
			case 19:
				strFieldName = "ITableName";
				break;
			case 20:
				strFieldName = "IColName";
				break;
			case 21:
				strFieldName = "BranchType";
				break;
			case 22:
				strFieldName = "BranchType2";
				break;
			case 23:
				strFieldName = "Json";
				break;
			case 24:
				strFieldName = "SqlTemp";
				break;
			case 25:
				strFieldName = "MakeDate";
				break;
			case 26:
				strFieldName = "MakeTime";
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
		if( strFieldName.equals("Type") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BaseCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexSet") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainIndexFlag") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexSerise") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DataType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ResultType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalPrpty") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DefaultValue") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Description") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AllSet") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalSql") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ITableName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IColName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Json") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SqlTemp") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 26:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
