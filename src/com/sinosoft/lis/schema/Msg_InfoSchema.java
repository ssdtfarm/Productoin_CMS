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
import com.sinosoft.lis.db.Msg_InfoDB;

/*
 * <p>ClassName: Msg_InfoSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class Msg_InfoSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(Msg_InfoSchema.class);
	// @Field
	/** Msg_id */
	private String Msg_ID;
	/** Msg_type */
	private String Msg_Type;
	/** Seqno */
	private int SeqNo;
	/** Msg_cn */
	private String Msg_Cn;
	/** Msg_tr */
	private String Msg_Tr;
	/** Msg_en */
	private String Msg_En;
	/** Remark */
	private String Remark;
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

	public static final int FIELDNUM = 12;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public Msg_InfoSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "Msg_ID";

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
		Msg_InfoSchema cloned = (Msg_InfoSchema)super.clone();
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
	* 国际化ID
	*/
	public String getMsg_ID()
	{
		return Msg_ID;
	}
	public void setMsg_ID(String aMsg_ID)
	{
		if(aMsg_ID!=null && aMsg_ID.length()>100)
			throw new IllegalArgumentException("Msg_idMsg_ID值"+aMsg_ID+"的长度"+aMsg_ID.length()+"大于最大值100");
		Msg_ID = aMsg_ID;
	}
	/**
	* 国际化类型（1-菜单词典，2-系统公共下拉项词典，3-系统公共词典，4-系统基础功能词典，5-需求功能下拉词典，6-需求功能词典）
	*/
	public String getMsg_Type()
	{
		return Msg_Type;
	}
	public void setMsg_Type(String aMsg_Type)
	{
		if(aMsg_Type!=null && aMsg_Type.length()>20)
			throw new IllegalArgumentException("Msg_typeMsg_Type值"+aMsg_Type+"的长度"+aMsg_Type.length()+"大于最大值20");
		Msg_Type = aMsg_Type;
	}
	/**
	* 类型对应流水号
	*/
	public int getSeqNo()
	{
		return SeqNo;
	}
	public void setSeqNo(int aSeqNo)
	{
		SeqNo = aSeqNo;
	}
	public void setSeqNo(String aSeqNo)
	{
		if (aSeqNo != null && !aSeqNo.equals(""))
		{
			Integer tInteger = new Integer(aSeqNo);
			int i = tInteger.intValue();
			SeqNo = i;
		}
	}

	/**
	* 简体中文翻译
	*/
	public String getMsg_Cn()
	{
		return Msg_Cn;
	}
	public void setMsg_Cn(String aMsg_Cn)
	{
		if(aMsg_Cn!=null && aMsg_Cn.length()>500)
			throw new IllegalArgumentException("Msg_cnMsg_Cn值"+aMsg_Cn+"的长度"+aMsg_Cn.length()+"大于最大值500");
		Msg_Cn = aMsg_Cn;
	}
	/**
	* 繁体中文翻译
	*/
	public String getMsg_Tr()
	{
		return Msg_Tr;
	}
	public void setMsg_Tr(String aMsg_Tr)
	{
		if(aMsg_Tr!=null && aMsg_Tr.length()>500)
			throw new IllegalArgumentException("Msg_trMsg_Tr值"+aMsg_Tr+"的长度"+aMsg_Tr.length()+"大于最大值500");
		Msg_Tr = aMsg_Tr;
	}
	/**
	* 英文翻译
	*/
	public String getMsg_En()
	{
		return Msg_En;
	}
	public void setMsg_En(String aMsg_En)
	{
		if(aMsg_En!=null && aMsg_En.length()>500)
			throw new IllegalArgumentException("Msg_enMsg_En值"+aMsg_En+"的长度"+aMsg_En.length()+"大于最大值500");
		Msg_En = aMsg_En;
	}
	/**
	* 备注
	*/
	public String getRemark()
	{
		return Remark;
	}
	public void setRemark(String aRemark)
	{
		if(aRemark!=null && aRemark.length()>500)
			throw new IllegalArgumentException("RemarkRemark值"+aRemark+"的长度"+aRemark.length()+"大于最大值500");
		Remark = aRemark;
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
	* 使用另外一个 Msg_InfoSchema 对象给 Schema 赋值
	* @param: aMsg_InfoSchema Msg_InfoSchema
	**/
	public void setSchema(Msg_InfoSchema aMsg_InfoSchema)
	{
		this.Msg_ID = aMsg_InfoSchema.getMsg_ID();
		this.Msg_Type = aMsg_InfoSchema.getMsg_Type();
		this.SeqNo = aMsg_InfoSchema.getSeqNo();
		this.Msg_Cn = aMsg_InfoSchema.getMsg_Cn();
		this.Msg_Tr = aMsg_InfoSchema.getMsg_Tr();
		this.Msg_En = aMsg_InfoSchema.getMsg_En();
		this.Remark = aMsg_InfoSchema.getRemark();
		this.Operator = aMsg_InfoSchema.getOperator();
		this.MakeDate = fDate.getDate( aMsg_InfoSchema.getMakeDate());
		this.MakeTime = aMsg_InfoSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aMsg_InfoSchema.getModifyDate());
		this.ModifyTime = aMsg_InfoSchema.getModifyTime();
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
			if( rs.getString("Msg_ID") == null )
				this.Msg_ID = null;
			else
				this.Msg_ID = rs.getString("Msg_ID").trim();

			if( rs.getString("Msg_Type") == null )
				this.Msg_Type = null;
			else
				this.Msg_Type = rs.getString("Msg_Type").trim();

			this.SeqNo = rs.getInt("SeqNo");
			if( rs.getString("Msg_Cn") == null )
				this.Msg_Cn = null;
			else
				this.Msg_Cn = rs.getString("Msg_Cn").trim();

			if( rs.getString("Msg_Tr") == null )
				this.Msg_Tr = null;
			else
				this.Msg_Tr = rs.getString("Msg_Tr").trim();

			if( rs.getString("Msg_En") == null )
				this.Msg_En = null;
			else
				this.Msg_En = rs.getString("Msg_En").trim();

			if( rs.getString("Remark") == null )
				this.Remark = null;
			else
				this.Remark = rs.getString("Remark").trim();

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
			logger.debug("数据库中的Msg_Info表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "Msg_InfoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public Msg_InfoSchema getSchema()
	{
		Msg_InfoSchema aMsg_InfoSchema = new Msg_InfoSchema();
		aMsg_InfoSchema.setSchema(this);
		return aMsg_InfoSchema;
	}

	public Msg_InfoDB getDB()
	{
		Msg_InfoDB aDBOper = new Msg_InfoDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpMsg_Info描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(Msg_ID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Msg_Type)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(SeqNo));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Msg_Cn)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Msg_Tr)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Msg_En)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remark)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpMsg_Info>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			Msg_ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Msg_Type = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			SeqNo= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,3,SysConst.PACKAGESPILTER))).intValue();
			Msg_Cn = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Msg_Tr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			Msg_En = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "Msg_InfoSchema";
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
		if (FCode.equalsIgnoreCase("Msg_ID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Msg_ID));
		}
		if (FCode.equalsIgnoreCase("Msg_Type"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Msg_Type));
		}
		if (FCode.equalsIgnoreCase("SeqNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(SeqNo));
		}
		if (FCode.equalsIgnoreCase("Msg_Cn"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Msg_Cn));
		}
		if (FCode.equalsIgnoreCase("Msg_Tr"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Msg_Tr));
		}
		if (FCode.equalsIgnoreCase("Msg_En"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Msg_En));
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remark));
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
				strFieldValue = StrTool.GBKToUnicode(Msg_ID);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(Msg_Type);
				break;
			case 2:
				strFieldValue = String.valueOf(SeqNo);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(Msg_Cn);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Msg_Tr);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(Msg_En);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(Remark);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 11:
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

		if (FCode.equalsIgnoreCase("Msg_ID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Msg_ID = FValue.trim();
			}
			else
				Msg_ID = null;
		}
		if (FCode.equalsIgnoreCase("Msg_Type"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Msg_Type = FValue.trim();
			}
			else
				Msg_Type = null;
		}
		if (FCode.equalsIgnoreCase("SeqNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				SeqNo = i;
			}
		}
		if (FCode.equalsIgnoreCase("Msg_Cn"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Msg_Cn = FValue.trim();
			}
			else
				Msg_Cn = null;
		}
		if (FCode.equalsIgnoreCase("Msg_Tr"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Msg_Tr = FValue.trim();
			}
			else
				Msg_Tr = null;
		}
		if (FCode.equalsIgnoreCase("Msg_En"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Msg_En = FValue.trim();
			}
			else
				Msg_En = null;
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Remark = FValue.trim();
			}
			else
				Remark = null;
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
		Msg_InfoSchema other = (Msg_InfoSchema)otherObject;
		return
			Msg_ID.equals(other.getMsg_ID())
			&& Msg_Type.equals(other.getMsg_Type())
			&& SeqNo == other.getSeqNo()
			&& Msg_Cn.equals(other.getMsg_Cn())
			&& Msg_Tr.equals(other.getMsg_Tr())
			&& Msg_En.equals(other.getMsg_En())
			&& Remark.equals(other.getRemark())
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
		if( strFieldName.equals("Msg_ID") ) {
			return 0;
		}
		if( strFieldName.equals("Msg_Type") ) {
			return 1;
		}
		if( strFieldName.equals("SeqNo") ) {
			return 2;
		}
		if( strFieldName.equals("Msg_Cn") ) {
			return 3;
		}
		if( strFieldName.equals("Msg_Tr") ) {
			return 4;
		}
		if( strFieldName.equals("Msg_En") ) {
			return 5;
		}
		if( strFieldName.equals("Remark") ) {
			return 6;
		}
		if( strFieldName.equals("Operator") ) {
			return 7;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 8;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 9;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 10;
		}
		if( strFieldName.equals("ModifyTime") ) {
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
				strFieldName = "Msg_ID";
				break;
			case 1:
				strFieldName = "Msg_Type";
				break;
			case 2:
				strFieldName = "SeqNo";
				break;
			case 3:
				strFieldName = "Msg_Cn";
				break;
			case 4:
				strFieldName = "Msg_Tr";
				break;
			case 5:
				strFieldName = "Msg_En";
				break;
			case 6:
				strFieldName = "Remark";
				break;
			case 7:
				strFieldName = "Operator";
				break;
			case 8:
				strFieldName = "MakeDate";
				break;
			case 9:
				strFieldName = "MakeTime";
				break;
			case 10:
				strFieldName = "ModifyDate";
				break;
			case 11:
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
		if( strFieldName.equals("Msg_ID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Msg_Type") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("SeqNo") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("Msg_Cn") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Msg_Tr") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Msg_En") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remark") ) {
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
				nFieldType = Schema.TYPE_STRING;
				break;
			case 2:
				nFieldType = Schema.TYPE_INT;
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_DATE;
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
