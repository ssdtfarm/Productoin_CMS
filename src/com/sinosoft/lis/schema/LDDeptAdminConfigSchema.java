/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.schema;

import java.sql.*;
import java.io.*;
import java.util.Date;
import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.utility.*;
import com.sinosoft.lis.db.LDDeptAdminConfigDB;

/*
 * <p>ClassName: LDDeptAdminConfigSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 核心业务系统
 * @CreateDate：2011-03-16
 */
public class LDDeptAdminConfigSchema implements Schema, Cloneable
{
	// @Field
	/** 部组代码 */
	private String DepNo;
	/** 部组名称 */
	private String DepName;
	/** 配置级别 */
	private String DepLevel;
	/** 上级机构代码 */
	private String UpDepNo;
	/** 部组负责人 */
	private String DepManager;
	/** 部组负责人姓名 */
	private String DepManagerName;
	/** 操作人员 */
	private String Operator;
	/** 入机日期 */
	private Date MakeDate;
	/** 入机时间 */
	private String MakeTime;
	/** 修改日期 */
	private Date ModifyDate;
	/** 修改时间 */
	private String ModifyTime;

	public static final int FIELDNUM = 11;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDDeptAdminConfigSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[1];
		pk[0] = "DepNo";

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
                LDDeptAdminConfigSchema cloned = (LDDeptAdminConfigSchema)super.clone();
                cloned.fDate = (FDate) fDate.clone();
                cloned.mErrors = (CErrors) mErrors.clone();
                return cloned;
            }

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getDepNo()
	{
		return DepNo;
	}
	public void setDepNo(String aDepNo)
	{
		DepNo = aDepNo;
	}
	public String getDepName()
	{
		return DepName;
	}
	public void setDepName(String aDepName)
	{
		DepName = aDepName;
	}
	public String getDepLevel()
	{
		return DepLevel;
	}
	public void setDepLevel(String aDepLevel)
	{
		DepLevel = aDepLevel;
	}
	public String getUpDepNo()
	{
		return UpDepNo;
	}
	public void setUpDepNo(String aUpDepNo)
	{
		UpDepNo = aUpDepNo;
	}
	public String getDepManager()
	{
		return DepManager;
	}
	public void setDepManager(String aDepManager)
	{
		DepManager = aDepManager;
	}
	public String getDepManagerName()
	{
		return DepManagerName;
	}
	public void setDepManagerName(String aDepManagerName)
	{
		DepManagerName = aDepManagerName;
	}
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
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
		ModifyTime = aModifyTime;
	}

	/**
	* 使用另外一个 LDDeptAdminConfigSchema 对象给 Schema 赋值
	* @param: aLDDeptAdminConfigSchema LDDeptAdminConfigSchema
	**/
	public void setSchema(LDDeptAdminConfigSchema aLDDeptAdminConfigSchema)
	{
		this.DepNo = aLDDeptAdminConfigSchema.getDepNo();
		this.DepName = aLDDeptAdminConfigSchema.getDepName();
		this.DepLevel = aLDDeptAdminConfigSchema.getDepLevel();
		this.UpDepNo = aLDDeptAdminConfigSchema.getUpDepNo();
		this.DepManager = aLDDeptAdminConfigSchema.getDepManager();
		this.DepManagerName = aLDDeptAdminConfigSchema.getDepManagerName();
		this.Operator = aLDDeptAdminConfigSchema.getOperator();
		this.MakeDate = fDate.getDate( aLDDeptAdminConfigSchema.getMakeDate());
		this.MakeTime = aLDDeptAdminConfigSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLDDeptAdminConfigSchema.getModifyDate());
		this.ModifyTime = aLDDeptAdminConfigSchema.getModifyTime();
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
			if( rs.getString("DepNo") == null )
				this.DepNo = null;
			else
				this.DepNo = rs.getString("DepNo").trim();

			if( rs.getString("DepName") == null )
				this.DepName = null;
			else
				this.DepName = rs.getString("DepName").trim();

			if( rs.getString("DepLevel") == null )
				this.DepLevel = null;
			else
				this.DepLevel = rs.getString("DepLevel").trim();

			if( rs.getString("UpDepNo") == null )
				this.UpDepNo = null;
			else
				this.UpDepNo = rs.getString("UpDepNo").trim();

			if( rs.getString("DepManager") == null )
				this.DepManager = null;
			else
				this.DepManager = rs.getString("DepManager").trim();

			if( rs.getString("DepManagerName") == null )
				this.DepManagerName = null;
			else
				this.DepManagerName = rs.getString("DepManagerName").trim();

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
			System.out.println("数据库中的LDDeptAdminConfig表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDDeptAdminConfigSchema getSchema()
	{
		LDDeptAdminConfigSchema aLDDeptAdminConfigSchema = new LDDeptAdminConfigSchema();
		aLDDeptAdminConfigSchema.setSchema(this);
		return aLDDeptAdminConfigSchema;
	}

	public LDDeptAdminConfigDB getDB()
	{
		LDDeptAdminConfigDB aDBOper = new LDDeptAdminConfigDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDDeptAdminConfig描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
strReturn.append(StrTool.cTrim(DepNo)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(DepName)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(DepLevel)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(UpDepNo)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(DepManager)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(DepManagerName)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(ModifyTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDDeptAdminConfig>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			DepNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			DepName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			DepLevel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			UpDepNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			DepManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			DepManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigSchema";
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
		if (FCode.equalsIgnoreCase("DepNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DepNo));
		}
		if (FCode.equalsIgnoreCase("DepName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DepName));
		}
		if (FCode.equalsIgnoreCase("DepLevel"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DepLevel));
		}
		if (FCode.equalsIgnoreCase("UpDepNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UpDepNo));
		}
		if (FCode.equalsIgnoreCase("DepManager"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DepManager));
		}
		if (FCode.equalsIgnoreCase("DepManagerName"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DepManagerName));
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
				strFieldValue = StrTool.GBKToUnicode(DepNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(DepName);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(DepLevel);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(UpDepNo);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(DepManager);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(DepManagerName);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 10:
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

		if (FCode.equalsIgnoreCase("DepNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DepNo = FValue.trim();
			}
			else
				DepNo = null;
		}
		if (FCode.equalsIgnoreCase("DepName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DepName = FValue.trim();
			}
			else
				DepName = null;
		}
		if (FCode.equalsIgnoreCase("DepLevel"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DepLevel = FValue.trim();
			}
			else
				DepLevel = null;
		}
		if (FCode.equalsIgnoreCase("UpDepNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UpDepNo = FValue.trim();
			}
			else
				UpDepNo = null;
		}
		if (FCode.equalsIgnoreCase("DepManager"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DepManager = FValue.trim();
			}
			else
				DepManager = null;
		}
		if (FCode.equalsIgnoreCase("DepManagerName"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DepManagerName = FValue.trim();
			}
			else
				DepManagerName = null;
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
		if (!(otherObject instanceof LDDeptAdminConfigSchema )) return false;
		LDDeptAdminConfigSchema other = (LDDeptAdminConfigSchema)otherObject;
    if (DepNo==null) {
      if (other.getDepNo() != null)
         return false;
   }else if (!DepNo.equals(other.getDepNo())) {
      return false;
   }
    if (DepName==null) {
      if (other.getDepName() != null)
         return false;
   }else if (!DepName.equals(other.getDepName())) {
      return false;
   }
    if (DepLevel==null) {
      if (other.getDepLevel() != null)
         return false;
   }else if (!DepLevel.equals(other.getDepLevel())) {
      return false;
   }
    if (UpDepNo==null) {
      if (other.getUpDepNo() != null)
         return false;
   }else if (!UpDepNo.equals(other.getUpDepNo())) {
      return false;
   }
    if (DepManager==null) {
      if (other.getDepManager() != null)
         return false;
   }else if (!DepManager.equals(other.getDepManager())) {
      return false;
   }
    if (DepManagerName==null) {
      if (other.getDepManagerName() != null)
         return false;
   }else if (!DepManagerName.equals(other.getDepManagerName())) {
      return false;
   }
    if (Operator==null) {
      if (other.getOperator() != null)
         return false;
   }else if (!Operator.equals(other.getOperator())) {
      return false;
   }
    if (fDate.getString(MakeDate) ==null) {
      if (other.getMakeDate() != null)
         return false;
   }else if (!fDate.getString(MakeDate) .equals(other.getMakeDate())) {
      return false;
   }
    if (MakeTime==null) {
      if (other.getMakeTime() != null)
         return false;
   }else if (!MakeTime.equals(other.getMakeTime())) {
      return false;
   }
    if (fDate.getString(ModifyDate) ==null) {
      if (other.getModifyDate() != null)
         return false;
   }else if (!fDate.getString(ModifyDate) .equals(other.getModifyDate())) {
      return false;
   }
    if (ModifyTime==null) {
      if (other.getModifyTime() != null)
         return false;
   }else if (!ModifyTime.equals(other.getModifyTime())) {
      return false;
   }
    return true;
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
		if( strFieldName.equals("DepNo") ) {
			return 0;
		}
		if( strFieldName.equals("DepName") ) {
			return 1;
		}
		if( strFieldName.equals("DepLevel") ) {
			return 2;
		}
		if( strFieldName.equals("UpDepNo") ) {
			return 3;
		}
		if( strFieldName.equals("DepManager") ) {
			return 4;
		}
		if( strFieldName.equals("DepManagerName") ) {
			return 5;
		}
		if( strFieldName.equals("Operator") ) {
			return 6;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 7;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 8;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 9;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 10;
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
				strFieldName = "DepNo";
				break;
			case 1:
				strFieldName = "DepName";
				break;
			case 2:
				strFieldName = "DepLevel";
				break;
			case 3:
				strFieldName = "UpDepNo";
				break;
			case 4:
				strFieldName = "DepManager";
				break;
			case 5:
				strFieldName = "DepManagerName";
				break;
			case 6:
				strFieldName = "Operator";
				break;
			case 7:
				strFieldName = "MakeDate";
				break;
			case 8:
				strFieldName = "MakeTime";
				break;
			case 9:
				strFieldName = "ModifyDate";
				break;
			case 10:
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
		if( strFieldName.equals("DepNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DepName") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DepLevel") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UpDepNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DepManager") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DepManagerName") ) {
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
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
