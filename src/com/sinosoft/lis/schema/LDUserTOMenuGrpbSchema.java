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
import com.sinosoft.lis.db.LDUserTOMenuGrpbDB;

/*
 * <p>ClassName: LDUserTOMenuGrpbSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 核心业务系统
 * @CreateDate：2011-03-16
 */
public class LDUserTOMenuGrpbSchema implements Schema, Cloneable
{
	// @Field
	/** 系列流水号 */
	private String EdorNo;
	/** 类型 */
	private String EdorType;
	/** 用户编码 */
	private String UserCode;
	/** 菜单分组编码 */
	private String MenuGrpCode;
	/** 角色分配日期 */
	private Date StartDate;
	/** 角色分配时间 */
	private String StartTime;
	/** 角色分配结束日期 */
	private Date EndDate;
	/** 角色分配结束时间 */
	private String EndTime;

	public static final int FIELDNUM = 8;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LDUserTOMenuGrpbSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "EdorNo";
		pk[1] = "EdorType";
		pk[2] = "UserCode";
		pk[3] = "MenuGrpCode";

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
                LDUserTOMenuGrpbSchema cloned = (LDUserTOMenuGrpbSchema)super.clone();
                cloned.fDate = (FDate) fDate.clone();
                cloned.mErrors = (CErrors) mErrors.clone();
                return cloned;
            }

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getEdorNo()
	{
		return EdorNo;
	}
	public void setEdorNo(String aEdorNo)
	{
		EdorNo = aEdorNo;
	}
	public String getEdorType()
	{
		return EdorType;
	}
	public void setEdorType(String aEdorType)
	{
		EdorType = aEdorType;
	}
	public String getUserCode()
	{
		return UserCode;
	}
	public void setUserCode(String aUserCode)
	{
		UserCode = aUserCode;
	}
	public String getMenuGrpCode()
	{
		return MenuGrpCode;
	}
	public void setMenuGrpCode(String aMenuGrpCode)
	{
		MenuGrpCode = aMenuGrpCode;
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

	public String getStartTime()
	{
		return StartTime;
	}
	public void setStartTime(String aStartTime)
	{
		StartTime = aStartTime;
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

	public String getEndTime()
	{
		return EndTime;
	}
	public void setEndTime(String aEndTime)
	{
		EndTime = aEndTime;
	}

	/**
	* 使用另外一个 LDUserTOMenuGrpbSchema 对象给 Schema 赋值
	* @param: aLDUserTOMenuGrpbSchema LDUserTOMenuGrpbSchema
	**/
	public void setSchema(LDUserTOMenuGrpbSchema aLDUserTOMenuGrpbSchema)
	{
		this.EdorNo = aLDUserTOMenuGrpbSchema.getEdorNo();
		this.EdorType = aLDUserTOMenuGrpbSchema.getEdorType();
		this.UserCode = aLDUserTOMenuGrpbSchema.getUserCode();
		this.MenuGrpCode = aLDUserTOMenuGrpbSchema.getMenuGrpCode();
		this.StartDate = fDate.getDate( aLDUserTOMenuGrpbSchema.getStartDate());
		this.StartTime = aLDUserTOMenuGrpbSchema.getStartTime();
		this.EndDate = fDate.getDate( aLDUserTOMenuGrpbSchema.getEndDate());
		this.EndTime = aLDUserTOMenuGrpbSchema.getEndTime();
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
			if( rs.getString("EdorNo") == null )
				this.EdorNo = null;
			else
				this.EdorNo = rs.getString("EdorNo").trim();

			if( rs.getString("EdorType") == null )
				this.EdorType = null;
			else
				this.EdorType = rs.getString("EdorType").trim();

			if( rs.getString("UserCode") == null )
				this.UserCode = null;
			else
				this.UserCode = rs.getString("UserCode").trim();

			if( rs.getString("MenuGrpCode") == null )
				this.MenuGrpCode = null;
			else
				this.MenuGrpCode = rs.getString("MenuGrpCode").trim();

			this.StartDate = rs.getDate("StartDate");
			if( rs.getString("StartTime") == null )
				this.StartTime = null;
			else
				this.StartTime = rs.getString("StartTime").trim();

			this.EndDate = rs.getDate("EndDate");
			if( rs.getString("EndTime") == null )
				this.EndTime = null;
			else
				this.EndTime = rs.getString("EndTime").trim();

		}
		catch(SQLException sqle)
		{
			System.out.println("数据库中的LDUserTOMenuGrpb表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDUserTOMenuGrpbSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LDUserTOMenuGrpbSchema getSchema()
	{
		LDUserTOMenuGrpbSchema aLDUserTOMenuGrpbSchema = new LDUserTOMenuGrpbSchema();
		aLDUserTOMenuGrpbSchema.setSchema(this);
		return aLDUserTOMenuGrpbSchema;
	}

	public LDUserTOMenuGrpbDB getDB()
	{
		LDUserTOMenuGrpbDB aDBOper = new LDUserTOMenuGrpbDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDUserTOMenuGrpb描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
strReturn.append(StrTool.cTrim(EdorNo)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(EdorType)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(UserCode)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(MenuGrpCode)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(fDate.getString( StartDate ))); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(StartTime)); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(fDate.getString( EndDate ))); strReturn.append(SysConst.PACKAGESPILTER);
strReturn.append(StrTool.cTrim(EndTime));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDUserTOMenuGrpb>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			EdorType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			UserCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			MenuGrpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			StartDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5,SysConst.PACKAGESPILTER));
			StartTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			EndDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7,SysConst.PACKAGESPILTER));
			EndTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDUserTOMenuGrpbSchema";
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
		if (FCode.equalsIgnoreCase("EdorNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorNo));
		}
		if (FCode.equalsIgnoreCase("EdorType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorType));
		}
		if (FCode.equalsIgnoreCase("UserCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(UserCode));
		}
		if (FCode.equalsIgnoreCase("MenuGrpCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MenuGrpCode));
		}
		if (FCode.equalsIgnoreCase("StartDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
		}
		if (FCode.equalsIgnoreCase("StartTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(StartTime));
		}
		if (FCode.equalsIgnoreCase("EndDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
		}
		if (FCode.equalsIgnoreCase("EndTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EndTime));
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
				strFieldValue = StrTool.GBKToUnicode(EdorNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(EdorType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(UserCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(MenuGrpCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getStartDate()));
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(StartTime);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getEndDate()));
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(EndTime);
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

		if (FCode.equalsIgnoreCase("EdorNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EdorNo = FValue.trim();
			}
			else
				EdorNo = null;
		}
		if (FCode.equalsIgnoreCase("EdorType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EdorType = FValue.trim();
			}
			else
				EdorType = null;
		}
		if (FCode.equalsIgnoreCase("UserCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				UserCode = FValue.trim();
			}
			else
				UserCode = null;
		}
		if (FCode.equalsIgnoreCase("MenuGrpCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MenuGrpCode = FValue.trim();
			}
			else
				MenuGrpCode = null;
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
		if (FCode.equalsIgnoreCase("StartTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				StartTime = FValue.trim();
			}
			else
				StartTime = null;
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
		if (FCode.equalsIgnoreCase("EndTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EndTime = FValue.trim();
			}
			else
				EndTime = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (!(otherObject instanceof LDUserTOMenuGrpbSchema )) return false;
		LDUserTOMenuGrpbSchema other = (LDUserTOMenuGrpbSchema)otherObject;
    if (EdorNo==null) {
      if (other.getEdorNo() != null)
         return false;
   }else if (!EdorNo.equals(other.getEdorNo())) {
      return false;
   }
    if (EdorType==null) {
      if (other.getEdorType() != null)
         return false;
   }else if (!EdorType.equals(other.getEdorType())) {
      return false;
   }
    if (UserCode==null) {
      if (other.getUserCode() != null)
         return false;
   }else if (!UserCode.equals(other.getUserCode())) {
      return false;
   }
    if (MenuGrpCode==null) {
      if (other.getMenuGrpCode() != null)
         return false;
   }else if (!MenuGrpCode.equals(other.getMenuGrpCode())) {
      return false;
   }
    if (fDate.getString(StartDate) ==null) {
      if (other.getStartDate() != null)
         return false;
   }else if (!fDate.getString(StartDate) .equals(other.getStartDate())) {
      return false;
   }
    if (StartTime==null) {
      if (other.getStartTime() != null)
         return false;
   }else if (!StartTime.equals(other.getStartTime())) {
      return false;
   }
    if (fDate.getString(EndDate) ==null) {
      if (other.getEndDate() != null)
         return false;
   }else if (!fDate.getString(EndDate) .equals(other.getEndDate())) {
      return false;
   }
    if (EndTime==null) {
      if (other.getEndTime() != null)
         return false;
   }else if (!EndTime.equals(other.getEndTime())) {
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
		if( strFieldName.equals("EdorNo") ) {
			return 0;
		}
		if( strFieldName.equals("EdorType") ) {
			return 1;
		}
		if( strFieldName.equals("UserCode") ) {
			return 2;
		}
		if( strFieldName.equals("MenuGrpCode") ) {
			return 3;
		}
		if( strFieldName.equals("StartDate") ) {
			return 4;
		}
		if( strFieldName.equals("StartTime") ) {
			return 5;
		}
		if( strFieldName.equals("EndDate") ) {
			return 6;
		}
		if( strFieldName.equals("EndTime") ) {
			return 7;
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
				strFieldName = "EdorNo";
				break;
			case 1:
				strFieldName = "EdorType";
				break;
			case 2:
				strFieldName = "UserCode";
				break;
			case 3:
				strFieldName = "MenuGrpCode";
				break;
			case 4:
				strFieldName = "StartDate";
				break;
			case 5:
				strFieldName = "StartTime";
				break;
			case 6:
				strFieldName = "EndDate";
				break;
			case 7:
				strFieldName = "EndTime";
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
		if( strFieldName.equals("EdorNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EdorType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("UserCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MenuGrpCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("StartDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("StartTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("EndDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("EndTime") ) {
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
				nFieldType = Schema.TYPE_DATE;
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
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
