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
import com.sinosoft.lis.db.LAOrphanPolicyDB;

/*
 * <p>ClassName: LAOrphanPolicySchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAOrphanPolicySchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAOrphanPolicySchema.class);
	// @Field
	/** Mainpolno */
	private String MainPolNo;
	/** Primaryagentcode */
	private String PrimaryAgentCode;
	/** Primaryoutworkdate */
	private Date PrimaryOutWorkDate;
	/** Primarydebitamt */
	private double PrimaryDebitAmt;
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

	public static final int FIELDNUM = 9;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAOrphanPolicySchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "MainPolNo";

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
		LAOrphanPolicySchema cloned = (LAOrphanPolicySchema)super.clone();
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
	* 保单号
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
	* 主代理人编码
	*/
	public String getPrimaryAgentCode()
	{
		return PrimaryAgentCode;
	}
	public void setPrimaryAgentCode(String aPrimaryAgentCode)
	{
		if(aPrimaryAgentCode!=null && aPrimaryAgentCode.length()>12)
			throw new IllegalArgumentException("PrimaryagentcodePrimaryAgentCode值"+aPrimaryAgentCode+"的长度"+aPrimaryAgentCode.length()+"大于最大值12");
		PrimaryAgentCode = aPrimaryAgentCode;
	}
	/**
	* 主代理人离职日期
	*/
	public String getPrimaryOutWorkDate()
	{
		if( PrimaryOutWorkDate != null )
			return fDate.getString(PrimaryOutWorkDate);
		else
			return null;
	}
	public void setPrimaryOutWorkDate(Date aPrimaryOutWorkDate)
	{
		PrimaryOutWorkDate = aPrimaryOutWorkDate;
	}
	public void setPrimaryOutWorkDate(String aPrimaryOutWorkDate)
	{
		if (aPrimaryOutWorkDate != null && !aPrimaryOutWorkDate.equals("") )
		{
			PrimaryOutWorkDate = fDate.getDate( aPrimaryOutWorkDate );
		}
		else
			PrimaryOutWorkDate = null;
	}

	/**
	* 主代理人离职时欠款
	*/
	public double getPrimaryDebitAmt()
	{
		return PrimaryDebitAmt;
	}
	public void setPrimaryDebitAmt(double aPrimaryDebitAmt)
	{
		PrimaryDebitAmt = aPrimaryDebitAmt;
	}
	public void setPrimaryDebitAmt(String aPrimaryDebitAmt)
	{
		if (aPrimaryDebitAmt != null && !aPrimaryDebitAmt.equals(""))
		{
			Double tDouble = new Double(aPrimaryDebitAmt);
			double d = tDouble.doubleValue();
			PrimaryDebitAmt = d;
		}
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
	* 使用另外一个 LAOrphanPolicySchema 对象给 Schema 赋值
	* @param: aLAOrphanPolicySchema LAOrphanPolicySchema
	**/
	public void setSchema(LAOrphanPolicySchema aLAOrphanPolicySchema)
	{
		this.MainPolNo = aLAOrphanPolicySchema.getMainPolNo();
		this.PrimaryAgentCode = aLAOrphanPolicySchema.getPrimaryAgentCode();
		this.PrimaryOutWorkDate = fDate.getDate( aLAOrphanPolicySchema.getPrimaryOutWorkDate());
		this.PrimaryDebitAmt = aLAOrphanPolicySchema.getPrimaryDebitAmt();
		this.Operator = aLAOrphanPolicySchema.getOperator();
		this.MakeDate = fDate.getDate( aLAOrphanPolicySchema.getMakeDate());
		this.MakeTime = aLAOrphanPolicySchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAOrphanPolicySchema.getModifyDate());
		this.ModifyTime = aLAOrphanPolicySchema.getModifyTime();
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
			if( rs.getString("MainPolNo") == null )
				this.MainPolNo = null;
			else
				this.MainPolNo = rs.getString("MainPolNo").trim();

			if( rs.getString("PrimaryAgentCode") == null )
				this.PrimaryAgentCode = null;
			else
				this.PrimaryAgentCode = rs.getString("PrimaryAgentCode").trim();

			this.PrimaryOutWorkDate = rs.getDate("PrimaryOutWorkDate");
			this.PrimaryDebitAmt = rs.getDouble("PrimaryDebitAmt");
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
			logger.debug("数据库中的LAOrphanPolicy表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAOrphanPolicySchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAOrphanPolicySchema getSchema()
	{
		LAOrphanPolicySchema aLAOrphanPolicySchema = new LAOrphanPolicySchema();
		aLAOrphanPolicySchema.setSchema(this);
		return aLAOrphanPolicySchema;
	}

	public LAOrphanPolicyDB getDB()
	{
		LAOrphanPolicyDB aDBOper = new LAOrphanPolicyDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAOrphanPolicy描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(MainPolNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(PrimaryAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( PrimaryOutWorkDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(PrimaryDebitAmt));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAOrphanPolicy>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			MainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			PrimaryAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			PrimaryOutWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3,SysConst.PACKAGESPILTER));
			PrimaryDebitAmt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,4,SysConst.PACKAGESPILTER))).doubleValue();
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAOrphanPolicySchema";
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
		if (FCode.equalsIgnoreCase("MainPolNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainPolNo));
		}
		if (FCode.equalsIgnoreCase("PrimaryAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PrimaryAgentCode));
		}
		if (FCode.equalsIgnoreCase("PrimaryOutWorkDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getPrimaryOutWorkDate()));
		}
		if (FCode.equalsIgnoreCase("PrimaryDebitAmt"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(PrimaryDebitAmt));
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
				strFieldValue = StrTool.GBKToUnicode(MainPolNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(PrimaryAgentCode);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getPrimaryOutWorkDate()));
				break;
			case 3:
				strFieldValue = String.valueOf(PrimaryDebitAmt);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 8:
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

		if (FCode.equalsIgnoreCase("MainPolNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MainPolNo = FValue.trim();
			}
			else
				MainPolNo = null;
		}
		if (FCode.equalsIgnoreCase("PrimaryAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				PrimaryAgentCode = FValue.trim();
			}
			else
				PrimaryAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("PrimaryOutWorkDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				PrimaryOutWorkDate = fDate.getDate( FValue );
			}
			else
				PrimaryOutWorkDate = null;
		}
		if (FCode.equalsIgnoreCase("PrimaryDebitAmt"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				PrimaryDebitAmt = d;
			}
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
		LAOrphanPolicySchema other = (LAOrphanPolicySchema)otherObject;
		return
			MainPolNo.equals(other.getMainPolNo())
			&& PrimaryAgentCode.equals(other.getPrimaryAgentCode())
			&& fDate.getString(PrimaryOutWorkDate).equals(other.getPrimaryOutWorkDate())
			&& PrimaryDebitAmt == other.getPrimaryDebitAmt()
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
		if( strFieldName.equals("MainPolNo") ) {
			return 0;
		}
		if( strFieldName.equals("PrimaryAgentCode") ) {
			return 1;
		}
		if( strFieldName.equals("PrimaryOutWorkDate") ) {
			return 2;
		}
		if( strFieldName.equals("PrimaryDebitAmt") ) {
			return 3;
		}
		if( strFieldName.equals("Operator") ) {
			return 4;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 5;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 6;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 7;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 8;
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
				strFieldName = "MainPolNo";
				break;
			case 1:
				strFieldName = "PrimaryAgentCode";
				break;
			case 2:
				strFieldName = "PrimaryOutWorkDate";
				break;
			case 3:
				strFieldName = "PrimaryDebitAmt";
				break;
			case 4:
				strFieldName = "Operator";
				break;
			case 5:
				strFieldName = "MakeDate";
				break;
			case 6:
				strFieldName = "MakeTime";
				break;
			case 7:
				strFieldName = "ModifyDate";
				break;
			case 8:
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
		if( strFieldName.equals("MainPolNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PrimaryAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("PrimaryOutWorkDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("PrimaryDebitAmt") ) {
			return Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 3:
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
