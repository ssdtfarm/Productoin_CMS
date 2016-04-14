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
import com.sinosoft.lis.db.LRIndexVsCommPDB;

/*
 * <p>ClassName: LRIndexVsCommPSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRIndexVsCommPSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LRIndexVsCommPSchema.class);
	// @Field
	/** Basecode */
	private String BaseCode;
	/** Managecom */
	private String ManageCom;
	/** Agentgrade */
	private String AgentGrade;
	/** Indextype */
	private String IndexType;
	/** Indexserise */
	private String IndexSerise;
	/** Wagecode */
	private String WageCode;
	/** Wagename */
	private String WageName;
	/** Indexcode */
	private String IndexCode;
	/** Description */
	private String Description;
	/** Wageorder */
	private int WageOrder;
	/** Branchtype */
	private String BranchType;
	/** Branchtype2 */
	private String BranchType2;

	public static final int FIELDNUM = 12;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LRIndexVsCommPSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[5];
		pk[0] = "BaseCode";
		pk[1] = "ManageCom";
		pk[2] = "AgentGrade";
		pk[3] = "IndexType";
		pk[4] = "WageCode";

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
		LRIndexVsCommPSchema cloned = (LRIndexVsCommPSchema)super.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
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
		if(aBaseCode!=null && aBaseCode.length()>20)
			throw new IllegalArgumentException("BasecodeBaseCode值"+aBaseCode+"的长度"+aBaseCode.length()+"大于最大值20");
		BaseCode = aBaseCode;
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
	* 职级
	*/
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
	* 项目系列
	*/
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
	* 规则编码
	*/
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
	/**
	* 备注
	*/
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
	/**
	* 项目顺序
	*/
	public int getWageOrder()
	{
		return WageOrder;
	}
	public void setWageOrder(int aWageOrder)
	{
		WageOrder = aWageOrder;
	}
	public void setWageOrder(String aWageOrder)
	{
		if (aWageOrder != null && !aWageOrder.equals(""))
		{
			Integer tInteger = new Integer(aWageOrder);
			int i = tInteger.intValue();
			WageOrder = i;
		}
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
	* 使用另外一个 LRIndexVsCommPSchema 对象给 Schema 赋值
	* @param: aLRIndexVsCommPSchema LRIndexVsCommPSchema
	**/
	public void setSchema(LRIndexVsCommPSchema aLRIndexVsCommPSchema)
	{
		this.BaseCode = aLRIndexVsCommPSchema.getBaseCode();
		this.ManageCom = aLRIndexVsCommPSchema.getManageCom();
		this.AgentGrade = aLRIndexVsCommPSchema.getAgentGrade();
		this.IndexType = aLRIndexVsCommPSchema.getIndexType();
		this.IndexSerise = aLRIndexVsCommPSchema.getIndexSerise();
		this.WageCode = aLRIndexVsCommPSchema.getWageCode();
		this.WageName = aLRIndexVsCommPSchema.getWageName();
		this.IndexCode = aLRIndexVsCommPSchema.getIndexCode();
		this.Description = aLRIndexVsCommPSchema.getDescription();
		this.WageOrder = aLRIndexVsCommPSchema.getWageOrder();
		this.BranchType = aLRIndexVsCommPSchema.getBranchType();
		this.BranchType2 = aLRIndexVsCommPSchema.getBranchType2();
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
			if( rs.getString("BaseCode") == null )
				this.BaseCode = null;
			else
				this.BaseCode = rs.getString("BaseCode").trim();

			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("IndexType") == null )
				this.IndexType = null;
			else
				this.IndexType = rs.getString("IndexType").trim();

			if( rs.getString("IndexSerise") == null )
				this.IndexSerise = null;
			else
				this.IndexSerise = rs.getString("IndexSerise").trim();

			if( rs.getString("WageCode") == null )
				this.WageCode = null;
			else
				this.WageCode = rs.getString("WageCode").trim();

			if( rs.getString("WageName") == null )
				this.WageName = null;
			else
				this.WageName = rs.getString("WageName").trim();

			if( rs.getString("IndexCode") == null )
				this.IndexCode = null;
			else
				this.IndexCode = rs.getString("IndexCode").trim();

			if( rs.getString("Description") == null )
				this.Description = null;
			else
				this.Description = rs.getString("Description").trim();

			this.WageOrder = rs.getInt("WageOrder");
			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("BranchType2") == null )
				this.BranchType2 = null;
			else
				this.BranchType2 = rs.getString("BranchType2").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LRIndexVsCommP表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexVsCommPSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LRIndexVsCommPSchema getSchema()
	{
		LRIndexVsCommPSchema aLRIndexVsCommPSchema = new LRIndexVsCommPSchema();
		aLRIndexVsCommPSchema.setSchema(this);
		return aLRIndexVsCommPSchema;
	}

	public LRIndexVsCommPDB getDB()
	{
		LRIndexVsCommPDB aDBOper = new LRIndexVsCommPDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRIndexVsCommP描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(BaseCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexSerise)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(WageName)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Description)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(WageOrder));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType2));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRIndexVsCommP>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			BaseCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			IndexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			IndexSerise = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			WageCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			WageName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			IndexCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			Description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			WageOrder= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,10,SysConst.PACKAGESPILTER))).intValue();
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			BranchType2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexVsCommPSchema";
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
		if (FCode.equalsIgnoreCase("BaseCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BaseCode));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("IndexType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexType));
		}
		if (FCode.equalsIgnoreCase("IndexSerise"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexSerise));
		}
		if (FCode.equalsIgnoreCase("WageCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageCode));
		}
		if (FCode.equalsIgnoreCase("WageName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageName));
		}
		if (FCode.equalsIgnoreCase("IndexCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexCode));
		}
		if (FCode.equalsIgnoreCase("Description"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Description));
		}
		if (FCode.equalsIgnoreCase("WageOrder"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageOrder));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("BranchType2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType2));
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
				strFieldValue = StrTool.GBKToUnicode(BaseCode);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(IndexType);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(IndexSerise);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(WageCode);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(WageName);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(IndexCode);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Description);
				break;
			case 9:
				strFieldValue = String.valueOf(WageOrder);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(BranchType2);
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

		if (FCode.equalsIgnoreCase("BaseCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BaseCode = FValue.trim();
			}
			else
				BaseCode = null;
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
		if (FCode.equalsIgnoreCase("WageCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageCode = FValue.trim();
			}
			else
				WageCode = null;
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
		if (FCode.equalsIgnoreCase("IndexCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexCode = FValue.trim();
			}
			else
				IndexCode = null;
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
		if (FCode.equalsIgnoreCase("WageOrder"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				WageOrder = i;
			}
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LRIndexVsCommPSchema other = (LRIndexVsCommPSchema)otherObject;
		return
			BaseCode.equals(other.getBaseCode())
			&& ManageCom.equals(other.getManageCom())
			&& AgentGrade.equals(other.getAgentGrade())
			&& IndexType.equals(other.getIndexType())
			&& IndexSerise.equals(other.getIndexSerise())
			&& WageCode.equals(other.getWageCode())
			&& WageName.equals(other.getWageName())
			&& IndexCode.equals(other.getIndexCode())
			&& Description.equals(other.getDescription())
			&& WageOrder == other.getWageOrder()
			&& BranchType.equals(other.getBranchType())
			&& BranchType2.equals(other.getBranchType2());
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
		if( strFieldName.equals("BaseCode") ) {
			return 0;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 1;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 2;
		}
		if( strFieldName.equals("IndexType") ) {
			return 3;
		}
		if( strFieldName.equals("IndexSerise") ) {
			return 4;
		}
		if( strFieldName.equals("WageCode") ) {
			return 5;
		}
		if( strFieldName.equals("WageName") ) {
			return 6;
		}
		if( strFieldName.equals("IndexCode") ) {
			return 7;
		}
		if( strFieldName.equals("Description") ) {
			return 8;
		}
		if( strFieldName.equals("WageOrder") ) {
			return 9;
		}
		if( strFieldName.equals("BranchType") ) {
			return 10;
		}
		if( strFieldName.equals("BranchType2") ) {
			return 11;
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
				strFieldName = "BaseCode";
				break;
			case 1:
				strFieldName = "ManageCom";
				break;
			case 2:
				strFieldName = "AgentGrade";
				break;
			case 3:
				strFieldName = "IndexType";
				break;
			case 4:
				strFieldName = "IndexSerise";
				break;
			case 5:
				strFieldName = "WageCode";
				break;
			case 6:
				strFieldName = "WageName";
				break;
			case 7:
				strFieldName = "IndexCode";
				break;
			case 8:
				strFieldName = "Description";
				break;
			case 9:
				strFieldName = "WageOrder";
				break;
			case 10:
				strFieldName = "BranchType";
				break;
			case 11:
				strFieldName = "BranchType2";
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
		if( strFieldName.equals("BaseCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexSerise") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Description") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("WageOrder") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType2") ) {
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
				nFieldType = Schema.TYPE_INT;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
