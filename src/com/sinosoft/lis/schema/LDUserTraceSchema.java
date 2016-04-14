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
import com.sinosoft.lis.db.LDUserTraceDB;

/*
 * <p>ClassName: LDUserTraceSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDUserTraceSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LDUserTraceSchema.class);
	// @Field
	/** Traceno */
	private double TraceNo;
	/** Managecom */
	private String ManageCom;
	/** Operator */
	private String Operator;
	/** Tracetype */
	private String TraceType;
	/** Tracecontent */
	private String TraceContent;
	/** Clientip */
	private String ClientIP;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Serveraddress */
	private String ServerAddress;

	public static final int FIELDNUM = 9;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDUserTraceSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "TraceNo";

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
		LDUserTraceSchema cloned = (LDUserTraceSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public double getTraceNo()
	{
		return TraceNo;
	}
	public void setTraceNo(double aTraceNo)
	{
		TraceNo = aTraceNo;
	}
	public void setTraceNo(String aTraceNo)
	{
		if (aTraceNo != null && !aTraceNo.equals(""))
		{
			Double tDouble = new Double(aTraceNo);
			double d = tDouble.doubleValue();
			TraceNo = d;
		}
	}

	public String getManageCom()
	{
		return ManageCom;
	}
	public void setManageCom(String aManageCom)
	{
		if(aManageCom!=null && aManageCom.length()>11)
			throw new IllegalArgumentException("ManagecomManageCom值"+aManageCom+"的长度"+aManageCom.length()+"大于最大值11");
		ManageCom = aManageCom;
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
	public String getTraceType()
	{
		return TraceType;
	}
	public void setTraceType(String aTraceType)
	{
		if(aTraceType!=null && aTraceType.length()>2)
			throw new IllegalArgumentException("TracetypeTraceType值"+aTraceType+"的长度"+aTraceType.length()+"大于最大值2");
		TraceType = aTraceType;
	}
	public String getTraceContent()
	{
		return TraceContent;
	}
	public void setTraceContent(String aTraceContent)
	{
		if(aTraceContent!=null && aTraceContent.length()>150)
			throw new IllegalArgumentException("TracecontentTraceContent值"+aTraceContent+"的长度"+aTraceContent.length()+"大于最大值150");
		TraceContent = aTraceContent;
	}
	public String getClientIP()
	{
		return ClientIP;
	}
	public void setClientIP(String aClientIP)
	{
		if(aClientIP!=null && aClientIP.length()>15)
			throw new IllegalArgumentException("ClientipClientIP值"+aClientIP+"的长度"+aClientIP.length()+"大于最大值15");
		ClientIP = aClientIP;
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
	public String getServerAddress()
	{
		return ServerAddress;
	}
	public void setServerAddress(String aServerAddress)
	{
		if(aServerAddress!=null && aServerAddress.length()>20)
			throw new IllegalArgumentException("ServeraddressServerAddress值"+aServerAddress+"的长度"+aServerAddress.length()+"大于最大值20");
		ServerAddress = aServerAddress;
	}

	/**
	* 使用另外一个 LDUserTraceSchema 对象给 Schema 赋值
	* @param: aLDUserTraceSchema LDUserTraceSchema
	**/
	public void setSchema(LDUserTraceSchema aLDUserTraceSchema)
	{
		this.TraceNo = aLDUserTraceSchema.getTraceNo();
		this.ManageCom = aLDUserTraceSchema.getManageCom();
		this.Operator = aLDUserTraceSchema.getOperator();
		this.TraceType = aLDUserTraceSchema.getTraceType();
		this.TraceContent = aLDUserTraceSchema.getTraceContent();
		this.ClientIP = aLDUserTraceSchema.getClientIP();
		this.MakeDate = fDate.getDate( aLDUserTraceSchema.getMakeDate());
		this.MakeTime = aLDUserTraceSchema.getMakeTime();
		this.ServerAddress = aLDUserTraceSchema.getServerAddress();
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
			this.TraceNo = rs.getDouble("TraceNo");
			if( rs.getString("ManageCom") == null )
				this.ManageCom = null;
			else
				this.ManageCom = rs.getString("ManageCom").trim();

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			if( rs.getString("TraceType") == null )
				this.TraceType = null;
			else
				this.TraceType = rs.getString("TraceType").trim();

			if( rs.getString("TraceContent") == null )
				this.TraceContent = null;
			else
				this.TraceContent = rs.getString("TraceContent").trim();

			if( rs.getString("ClientIP") == null )
				this.ClientIP = null;
			else
				this.ClientIP = rs.getString("ClientIP").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

			if( rs.getString("ServerAddress") == null )
				this.ServerAddress = null;
			else
				this.ServerAddress = rs.getString("ServerAddress").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LDUserTrace表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDUserTraceSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDUserTraceSchema getSchema()
	{
		LDUserTraceSchema aLDUserTraceSchema = new LDUserTraceSchema();
		aLDUserTraceSchema.setSchema(this);
		return aLDUserTraceSchema;
	}

	public LDUserTraceDB getDB()
	{
		LDUserTraceDB aDBOper = new LDUserTraceDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDUserTrace描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append( ChgData.chgData(TraceNo));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ManageCom)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TraceType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(TraceContent)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ClientIP)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ServerAddress));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDUserTrace>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			TraceNo = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage,1,SysConst.PACKAGESPILTER))).doubleValue();
			ManageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			TraceType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			TraceContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			ClientIP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			ServerAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDUserTraceSchema";
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
		if (FCode.equalsIgnoreCase("TraceNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TraceNo));
		}
		if (FCode.equalsIgnoreCase("ManageCom"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ManageCom));
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		}
		if (FCode.equalsIgnoreCase("TraceType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TraceType));
		}
		if (FCode.equalsIgnoreCase("TraceContent"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(TraceContent));
		}
		if (FCode.equalsIgnoreCase("ClientIP"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ClientIP));
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		}
		if (FCode.equalsIgnoreCase("ServerAddress"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ServerAddress));
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
				strFieldValue = String.valueOf(TraceNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(ManageCom);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(TraceType);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(TraceContent);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(ClientIP);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(ServerAddress);
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

		if (FCode.equalsIgnoreCase("TraceNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Double tDouble = new Double( FValue );
				double d = tDouble.doubleValue();
				TraceNo = d;
			}
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
		if (FCode.equalsIgnoreCase("Operator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator = FValue.trim();
			}
			else
				Operator = null;
		}
		if (FCode.equalsIgnoreCase("TraceType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TraceType = FValue.trim();
			}
			else
				TraceType = null;
		}
		if (FCode.equalsIgnoreCase("TraceContent"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				TraceContent = FValue.trim();
			}
			else
				TraceContent = null;
		}
		if (FCode.equalsIgnoreCase("ClientIP"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ClientIP = FValue.trim();
			}
			else
				ClientIP = null;
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
		if (FCode.equalsIgnoreCase("ServerAddress"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ServerAddress = FValue.trim();
			}
			else
				ServerAddress = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LDUserTraceSchema other = (LDUserTraceSchema)otherObject;
		return
			TraceNo == other.getTraceNo()
			&& ManageCom.equals(other.getManageCom())
			&& Operator.equals(other.getOperator())
			&& TraceType.equals(other.getTraceType())
			&& TraceContent.equals(other.getTraceContent())
			&& ClientIP.equals(other.getClientIP())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& ServerAddress.equals(other.getServerAddress());
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
		if( strFieldName.equals("TraceNo") ) {
			return 0;
		}
		if( strFieldName.equals("ManageCom") ) {
			return 1;
		}
		if( strFieldName.equals("Operator") ) {
			return 2;
		}
		if( strFieldName.equals("TraceType") ) {
			return 3;
		}
		if( strFieldName.equals("TraceContent") ) {
			return 4;
		}
		if( strFieldName.equals("ClientIP") ) {
			return 5;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 6;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 7;
		}
		if( strFieldName.equals("ServerAddress") ) {
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
				strFieldName = "TraceNo";
				break;
			case 1:
				strFieldName = "ManageCom";
				break;
			case 2:
				strFieldName = "Operator";
				break;
			case 3:
				strFieldName = "TraceType";
				break;
			case 4:
				strFieldName = "TraceContent";
				break;
			case 5:
				strFieldName = "ClientIP";
				break;
			case 6:
				strFieldName = "MakeDate";
				break;
			case 7:
				strFieldName = "MakeTime";
				break;
			case 8:
				strFieldName = "ServerAddress";
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
		if( strFieldName.equals("TraceNo") ) {
			return Schema.TYPE_DOUBLE;
		}
		if( strFieldName.equals("ManageCom") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TraceType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("TraceContent") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ClientIP") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ServerAddress") ) {
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
				nFieldType = Schema.TYPE_DOUBLE;
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
				nFieldType = Schema.TYPE_STRING;
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
