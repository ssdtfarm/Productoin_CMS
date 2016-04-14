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
import com.sinosoft.lis.db.LCContAssignmentBDB;

/*
 * <p>ClassName: LCContAssignmentBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCContAssignmentBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LCContAssignmentBSchema.class);
	// @Field
	/** Id */
	private String ID;
	/** Mainpolno */
	private String MainPolNo;
	/** Oldsagentcode */
	private String OldSAgentCode;
	/** Newsagentcode */
	private String NewSAgentCode;
	/** Assignreason */
	private String AssignReason;
	/** Assigndate */
	private Date AssignDate;
	/** Asareceipt */
	private String ASAReceipt;
	/** Asareceiveddate */
	private Date ASAReceivedDate;
	/** Remarks */
	private String Remarks;
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

	public static final int FIELDNUM = 17;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LCContAssignmentBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[4];
		pk[0] = "ID";
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
		LCContAssignmentBSchema cloned = (LCContAssignmentBSchema)super.clone();
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
	* 流水号
	*/
	public String getID()
	{
		return ID;
	}
	public void setID(String aID)
	{
		if(aID!=null && aID.length()>10)
			throw new IllegalArgumentException("IdID值"+aID+"的长度"+aID.length()+"大于最大值10");
		ID = aID;
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
	* 原服务代理人编码
	*/
	public String getOldSAgentCode()
	{
		return OldSAgentCode;
	}
	public void setOldSAgentCode(String aOldSAgentCode)
	{
		if(aOldSAgentCode!=null && aOldSAgentCode.length()>12)
			throw new IllegalArgumentException("OldsagentcodeOldSAgentCode值"+aOldSAgentCode+"的长度"+aOldSAgentCode.length()+"大于最大值12");
		OldSAgentCode = aOldSAgentCode;
	}
	/**
	* 新服务代理人编码
	*/
	public String getNewSAgentCode()
	{
		return NewSAgentCode;
	}
	public void setNewSAgentCode(String aNewSAgentCode)
	{
		if(aNewSAgentCode!=null && aNewSAgentCode.length()>12)
			throw new IllegalArgumentException("NewsagentcodeNewSAgentCode值"+aNewSAgentCode+"的长度"+aNewSAgentCode.length()+"大于最大值12");
		NewSAgentCode = aNewSAgentCode;
	}
	/**
	* 调整原因
	*/
	public String getAssignReason()
	{
		return AssignReason;
	}
	public void setAssignReason(String aAssignReason)
	{
		if(aAssignReason!=null && aAssignReason.length()>2)
			throw new IllegalArgumentException("AssignreasonAssignReason值"+aAssignReason+"的长度"+aAssignReason.length()+"大于最大值2");
		AssignReason = aAssignReason;
	}
	/**
	* 调整日期
	*/
	public String getAssignDate()
	{
		if( AssignDate != null )
			return fDate.getString(AssignDate);
		else
			return null;
	}
	public void setAssignDate(Date aAssignDate)
	{
		AssignDate = aAssignDate;
	}
	public void setAssignDate(String aAssignDate)
	{
		if (aAssignDate != null && !aAssignDate.equals("") )
		{
			AssignDate = fDate.getDate( aAssignDate );
		}
		else
			AssignDate = null;
	}

	/**
	* 是否有ASA回执
	*/
	public String getASAReceipt()
	{
		return ASAReceipt;
	}
	public void setASAReceipt(String aASAReceipt)
	{
		if(aASAReceipt!=null && aASAReceipt.length()>2)
			throw new IllegalArgumentException("AsareceiptASAReceipt值"+aASAReceipt+"的长度"+aASAReceipt.length()+"大于最大值2");
		ASAReceipt = aASAReceipt;
	}
	/**
	* ASA回执日期
	*/
	public String getASAReceivedDate()
	{
		if( ASAReceivedDate != null )
			return fDate.getString(ASAReceivedDate);
		else
			return null;
	}
	public void setASAReceivedDate(Date aASAReceivedDate)
	{
		ASAReceivedDate = aASAReceivedDate;
	}
	public void setASAReceivedDate(String aASAReceivedDate)
	{
		if (aASAReceivedDate != null && !aASAReceivedDate.equals("") )
		{
			ASAReceivedDate = fDate.getDate( aASAReceivedDate );
		}
		else
			ASAReceivedDate = null;
	}

	/**
	* 备注
	*/
	public String getRemarks()
	{
		return Remarks;
	}
	public void setRemarks(String aRemarks)
	{
		if(aRemarks!=null && aRemarks.length()>1000)
			throw new IllegalArgumentException("RemarksRemarks值"+aRemarks+"的长度"+aRemarks.length()+"大于最大值1000");
		Remarks = aRemarks;
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

	/**
	* 使用另外一个 LCContAssignmentBSchema 对象给 Schema 赋值
	* @param: aLCContAssignmentBSchema LCContAssignmentBSchema
	**/
	public void setSchema(LCContAssignmentBSchema aLCContAssignmentBSchema)
	{
		this.ID = aLCContAssignmentBSchema.getID();
		this.MainPolNo = aLCContAssignmentBSchema.getMainPolNo();
		this.OldSAgentCode = aLCContAssignmentBSchema.getOldSAgentCode();
		this.NewSAgentCode = aLCContAssignmentBSchema.getNewSAgentCode();
		this.AssignReason = aLCContAssignmentBSchema.getAssignReason();
		this.AssignDate = fDate.getDate( aLCContAssignmentBSchema.getAssignDate());
		this.ASAReceipt = aLCContAssignmentBSchema.getASAReceipt();
		this.ASAReceivedDate = fDate.getDate( aLCContAssignmentBSchema.getASAReceivedDate());
		this.Remarks = aLCContAssignmentBSchema.getRemarks();
		this.Operator = aLCContAssignmentBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLCContAssignmentBSchema.getMakeDate());
		this.MakeTime = aLCContAssignmentBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLCContAssignmentBSchema.getModifyDate());
		this.ModifyTime = aLCContAssignmentBSchema.getModifyTime();
		this.Operator1 = aLCContAssignmentBSchema.getOperator1();
		this.MakeDate1 = fDate.getDate( aLCContAssignmentBSchema.getMakeDate1());
		this.MakeTime1 = aLCContAssignmentBSchema.getMakeTime1();
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
			if( rs.getString("ID") == null )
				this.ID = null;
			else
				this.ID = rs.getString("ID").trim();

			if( rs.getString("MainPolNo") == null )
				this.MainPolNo = null;
			else
				this.MainPolNo = rs.getString("MainPolNo").trim();

			if( rs.getString("OldSAgentCode") == null )
				this.OldSAgentCode = null;
			else
				this.OldSAgentCode = rs.getString("OldSAgentCode").trim();

			if( rs.getString("NewSAgentCode") == null )
				this.NewSAgentCode = null;
			else
				this.NewSAgentCode = rs.getString("NewSAgentCode").trim();

			if( rs.getString("AssignReason") == null )
				this.AssignReason = null;
			else
				this.AssignReason = rs.getString("AssignReason").trim();

			this.AssignDate = rs.getDate("AssignDate");
			if( rs.getString("ASAReceipt") == null )
				this.ASAReceipt = null;
			else
				this.ASAReceipt = rs.getString("ASAReceipt").trim();

			this.ASAReceivedDate = rs.getDate("ASAReceivedDate");
			if( rs.getString("Remarks") == null )
				this.Remarks = null;
			else
				this.Remarks = rs.getString("Remarks").trim();

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

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LCContAssignmentB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCContAssignmentBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LCContAssignmentBSchema getSchema()
	{
		LCContAssignmentBSchema aLCContAssignmentBSchema = new LCContAssignmentBSchema();
		aLCContAssignmentBSchema.setSchema(this);
		return aLCContAssignmentBSchema;
	}

	public LCContAssignmentBDB getDB()
	{
		LCContAssignmentBDB aDBOper = new LCContAssignmentBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCContAssignmentB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(ID)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MainPolNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(OldSAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(NewSAgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AssignReason)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( AssignDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ASAReceipt)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ASAReceivedDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remarks)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator1)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate1 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime1));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLCContAssignmentB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			ID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			MainPolNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			OldSAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			NewSAgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			AssignReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AssignDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,SysConst.PACKAGESPILTER));
			ASAReceipt = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			ASAReceivedDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			Remarks = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			Operator1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			MakeDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16,SysConst.PACKAGESPILTER));
			MakeTime1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCContAssignmentBSchema";
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
		if (FCode.equalsIgnoreCase("ID"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ID));
		}
		if (FCode.equalsIgnoreCase("MainPolNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MainPolNo));
		}
		if (FCode.equalsIgnoreCase("OldSAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(OldSAgentCode));
		}
		if (FCode.equalsIgnoreCase("NewSAgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(NewSAgentCode));
		}
		if (FCode.equalsIgnoreCase("AssignReason"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AssignReason));
		}
		if (FCode.equalsIgnoreCase("AssignDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getAssignDate()));
		}
		if (FCode.equalsIgnoreCase("ASAReceipt"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ASAReceipt));
		}
		if (FCode.equalsIgnoreCase("ASAReceivedDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
		}
		if (FCode.equalsIgnoreCase("Remarks"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remarks));
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
				strFieldValue = StrTool.GBKToUnicode(ID);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(MainPolNo);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(OldSAgentCode);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(NewSAgentCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(AssignReason);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getAssignDate()));
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(ASAReceipt);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getASAReceivedDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(Remarks);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(Operator1);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate1()));
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(MakeTime1);
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

		if (FCode.equalsIgnoreCase("ID"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ID = FValue.trim();
			}
			else
				ID = null;
		}
		if (FCode.equalsIgnoreCase("MainPolNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MainPolNo = FValue.trim();
			}
			else
				MainPolNo = null;
		}
		if (FCode.equalsIgnoreCase("OldSAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				OldSAgentCode = FValue.trim();
			}
			else
				OldSAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("NewSAgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				NewSAgentCode = FValue.trim();
			}
			else
				NewSAgentCode = null;
		}
		if (FCode.equalsIgnoreCase("AssignReason"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AssignReason = FValue.trim();
			}
			else
				AssignReason = null;
		}
		if (FCode.equalsIgnoreCase("AssignDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				AssignDate = fDate.getDate( FValue );
			}
			else
				AssignDate = null;
		}
		if (FCode.equalsIgnoreCase("ASAReceipt"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ASAReceipt = FValue.trim();
			}
			else
				ASAReceipt = null;
		}
		if (FCode.equalsIgnoreCase("ASAReceivedDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ASAReceivedDate = fDate.getDate( FValue );
			}
			else
				ASAReceivedDate = null;
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
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LCContAssignmentBSchema other = (LCContAssignmentBSchema)otherObject;
		return
			ID.equals(other.getID())
			&& MainPolNo.equals(other.getMainPolNo())
			&& OldSAgentCode.equals(other.getOldSAgentCode())
			&& NewSAgentCode.equals(other.getNewSAgentCode())
			&& AssignReason.equals(other.getAssignReason())
			&& fDate.getString(AssignDate).equals(other.getAssignDate())
			&& ASAReceipt.equals(other.getASAReceipt())
			&& fDate.getString(ASAReceivedDate).equals(other.getASAReceivedDate())
			&& Remarks.equals(other.getRemarks())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator1.equals(other.getOperator1())
			&& fDate.getString(MakeDate1).equals(other.getMakeDate1())
			&& MakeTime1.equals(other.getMakeTime1());
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
		if( strFieldName.equals("ID") ) {
			return 0;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return 1;
		}
		if( strFieldName.equals("OldSAgentCode") ) {
			return 2;
		}
		if( strFieldName.equals("NewSAgentCode") ) {
			return 3;
		}
		if( strFieldName.equals("AssignReason") ) {
			return 4;
		}
		if( strFieldName.equals("AssignDate") ) {
			return 5;
		}
		if( strFieldName.equals("ASAReceipt") ) {
			return 6;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return 7;
		}
		if( strFieldName.equals("Remarks") ) {
			return 8;
		}
		if( strFieldName.equals("Operator") ) {
			return 9;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 10;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 11;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 12;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 13;
		}
		if( strFieldName.equals("Operator1") ) {
			return 14;
		}
		if( strFieldName.equals("MakeDate1") ) {
			return 15;
		}
		if( strFieldName.equals("MakeTime1") ) {
			return 16;
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
				strFieldName = "ID";
				break;
			case 1:
				strFieldName = "MainPolNo";
				break;
			case 2:
				strFieldName = "OldSAgentCode";
				break;
			case 3:
				strFieldName = "NewSAgentCode";
				break;
			case 4:
				strFieldName = "AssignReason";
				break;
			case 5:
				strFieldName = "AssignDate";
				break;
			case 6:
				strFieldName = "ASAReceipt";
				break;
			case 7:
				strFieldName = "ASAReceivedDate";
				break;
			case 8:
				strFieldName = "Remarks";
				break;
			case 9:
				strFieldName = "Operator";
				break;
			case 10:
				strFieldName = "MakeDate";
				break;
			case 11:
				strFieldName = "MakeTime";
				break;
			case 12:
				strFieldName = "ModifyDate";
				break;
			case 13:
				strFieldName = "ModifyTime";
				break;
			case 14:
				strFieldName = "Operator1";
				break;
			case 15:
				strFieldName = "MakeDate1";
				break;
			case 16:
				strFieldName = "MakeTime1";
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
		if( strFieldName.equals("ID") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MainPolNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("OldSAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("NewSAgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AssignReason") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AssignDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ASAReceipt") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ASAReceivedDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("Remarks") ) {
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
				nFieldType = Schema.TYPE_STRING;
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
			case 12:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
