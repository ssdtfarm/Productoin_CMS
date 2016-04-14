/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.DailyPolicyDetailsSchema;
import com.sinosoft.lis.vschema.DailyPolicyDetailsSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: DailyPolicyDetailsDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyPolicyDetailsDB extends DailyPolicyDetailsSchema
{
	// @Field
	private Connection con;
	private DBOper db;
	/**
	* flag = true: 传入Connection
	* flag = false: 不传入Connection
	**/
	private boolean mflag = false;

	public CErrors mErrors = new CErrors();		// 错误信息

	/**
	 * 为批量操作而准备的语句和游标对象
	 */
	private ResultSet mResultSet = null;
	private Statement mStatement = null;
	// @Constructor
	public DailyPolicyDetailsDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "DailyPolicyDetails" );
		mflag = true;
	}

	public DailyPolicyDetailsDB()
	{
		con = null;
		db = new DBOper( "DailyPolicyDetails" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		DailyPolicyDetailsSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		DailyPolicyDetailsSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);

			return -1;
		}

		return tCount;
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
			pstmt = con.prepareStatement("DELETE FROM DailyPolicyDetails WHERE  Company_Code = ? AND Policy_No = ? AND Batch_No = ? AND Batch_Run_Date = ?");
			if(this.getCompany_Code() == null || this.getCompany_Code().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCompany_Code());
			}
			if(this.getPolicy_No() == null || this.getPolicy_No().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getPolicy_No());
			}
			pstmt.setDouble(3, this.getBatch_No());
			if(this.getBatch_Run_Date() == null || this.getBatch_Run_Date().equals("null")) {
				pstmt.setNull(4, 91);
			} else {
				pstmt.setDate(4, Date.valueOf(this.getBatch_Run_Date()));
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPolicyDetails");
		sqlObj.setSQL(4, this);
		sqlObj.getSQL();

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPolicyDetails");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE DailyPolicyDetails SET  Company_Code = ? , Policy_No = ? , Product_Code = ? , Product_Type = ? , Link_or_No_Link_Product = ? , AgentCode1 = ? , AgentCode2 = ? , SplitRate1 = ? , SplitRate2 = ? , Servicing_Agent_Code = ? , Risk_Status = ? , Effective_Date = ? , First_Issue_Date = ? , Reissue_Issue_Date = ? , Reinstatement_Date = ? , Policy_Owner_Customer_ID = ? , Policy_Owner_Name = ? , Owner_Security_No = ? , Policy_Insured_Name = ? , Insured_Security_No = ? , Old_Policy_No = ? , Business_Date = ? , Batch_No = ? , Batch_Run_Date = ? WHERE  Company_Code = ? AND Policy_No = ? AND Batch_No = ? AND Batch_Run_Date = ?");
			if(this.getCompany_Code() == null || this.getCompany_Code().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCompany_Code());
			}
			if(this.getPolicy_No() == null || this.getPolicy_No().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getPolicy_No());
			}
			if(this.getProduct_Code() == null || this.getProduct_Code().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getProduct_Code());
			}
			if(this.getProduct_Type() == null || this.getProduct_Type().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getProduct_Type());
			}
			if(this.getLink_or_No_Link_Product() == null || this.getLink_or_No_Link_Product().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getLink_or_No_Link_Product());
			}
			if(this.getAgentCode1() == null || this.getAgentCode1().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentCode1());
			}
			if(this.getAgentCode2() == null || this.getAgentCode2().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentCode2());
			}
			pstmt.setDouble(8, this.getSplitRate1());
			pstmt.setDouble(9, this.getSplitRate2());
			if(this.getServicing_Agent_Code() == null || this.getServicing_Agent_Code().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getServicing_Agent_Code());
			}
			if(this.getRisk_Status() == null || this.getRisk_Status().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getRisk_Status());
			}
			if(this.getEffective_Date() == null || this.getEffective_Date().equals("null")) {
				pstmt.setNull(12, 91);
			} else {
				pstmt.setDate(12, Date.valueOf(this.getEffective_Date()));
			}
			if(this.getFirst_Issue_Date() == null || this.getFirst_Issue_Date().equals("null")) {
				pstmt.setNull(13, 91);
			} else {
				pstmt.setDate(13, Date.valueOf(this.getFirst_Issue_Date()));
			}
			if(this.getReissue_Issue_Date() == null || this.getReissue_Issue_Date().equals("null")) {
				pstmt.setNull(14, 91);
			} else {
				pstmt.setDate(14, Date.valueOf(this.getReissue_Issue_Date()));
			}
			if(this.getReinstatement_Date() == null || this.getReinstatement_Date().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getReinstatement_Date()));
			}
			if(this.getPolicy_Owner_Customer_ID() == null || this.getPolicy_Owner_Customer_ID().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getPolicy_Owner_Customer_ID());
			}
			if(this.getPolicy_Owner_Name() == null || this.getPolicy_Owner_Name().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getPolicy_Owner_Name());
			}
			if(this.getOwner_Security_No() == null || this.getOwner_Security_No().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getOwner_Security_No());
			}
			if(this.getPolicy_Insured_Name() == null || this.getPolicy_Insured_Name().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getPolicy_Insured_Name());
			}
			if(this.getInsured_Security_No() == null || this.getInsured_Security_No().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getInsured_Security_No());
			}
			if(this.getOld_Policy_No() == null || this.getOld_Policy_No().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getOld_Policy_No());
			}
			if(this.getBusiness_Date() == null || this.getBusiness_Date().equals("null")) {
				pstmt.setNull(22, 91);
			} else {
				pstmt.setDate(22, Date.valueOf(this.getBusiness_Date()));
			}
			pstmt.setDouble(23, this.getBatch_No());
			if(this.getBatch_Run_Date() == null || this.getBatch_Run_Date().equals("null")) {
				pstmt.setNull(24, 91);
			} else {
				pstmt.setDate(24, Date.valueOf(this.getBatch_Run_Date()));
			}
			// set where condition
			if(this.getCompany_Code() == null || this.getCompany_Code().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getCompany_Code());
			}
			if(this.getPolicy_No() == null || this.getPolicy_No().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getPolicy_No());
			}
			pstmt.setDouble(27, this.getBatch_No());
			if(this.getBatch_Run_Date() == null || this.getBatch_Run_Date().equals("null")) {
				pstmt.setNull(28, 91);
			} else {
				pstmt.setDate(28, Date.valueOf(this.getBatch_Run_Date()));
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPolicyDetails");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO DailyPolicyDetails VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getCompany_Code() == null || this.getCompany_Code().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCompany_Code());
			}
			if(this.getPolicy_No() == null || this.getPolicy_No().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getPolicy_No());
			}
			if(this.getProduct_Code() == null || this.getProduct_Code().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getProduct_Code());
			}
			if(this.getProduct_Type() == null || this.getProduct_Type().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getProduct_Type());
			}
			if(this.getLink_or_No_Link_Product() == null || this.getLink_or_No_Link_Product().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getLink_or_No_Link_Product());
			}
			if(this.getAgentCode1() == null || this.getAgentCode1().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentCode1());
			}
			if(this.getAgentCode2() == null || this.getAgentCode2().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentCode2());
			}
			pstmt.setDouble(8, this.getSplitRate1());
			pstmt.setDouble(9, this.getSplitRate2());
			if(this.getServicing_Agent_Code() == null || this.getServicing_Agent_Code().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getServicing_Agent_Code());
			}
			if(this.getRisk_Status() == null || this.getRisk_Status().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getRisk_Status());
			}
			if(this.getEffective_Date() == null || this.getEffective_Date().equals("null")) {
				pstmt.setNull(12, 91);
			} else {
				pstmt.setDate(12, Date.valueOf(this.getEffective_Date()));
			}
			if(this.getFirst_Issue_Date() == null || this.getFirst_Issue_Date().equals("null")) {
				pstmt.setNull(13, 91);
			} else {
				pstmt.setDate(13, Date.valueOf(this.getFirst_Issue_Date()));
			}
			if(this.getReissue_Issue_Date() == null || this.getReissue_Issue_Date().equals("null")) {
				pstmt.setNull(14, 91);
			} else {
				pstmt.setDate(14, Date.valueOf(this.getReissue_Issue_Date()));
			}
			if(this.getReinstatement_Date() == null || this.getReinstatement_Date().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getReinstatement_Date()));
			}
			if(this.getPolicy_Owner_Customer_ID() == null || this.getPolicy_Owner_Customer_ID().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getPolicy_Owner_Customer_ID());
			}
			if(this.getPolicy_Owner_Name() == null || this.getPolicy_Owner_Name().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getPolicy_Owner_Name());
			}
			if(this.getOwner_Security_No() == null || this.getOwner_Security_No().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getOwner_Security_No());
			}
			if(this.getPolicy_Insured_Name() == null || this.getPolicy_Insured_Name().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getPolicy_Insured_Name());
			}
			if(this.getInsured_Security_No() == null || this.getInsured_Security_No().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getInsured_Security_No());
			}
			if(this.getOld_Policy_No() == null || this.getOld_Policy_No().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getOld_Policy_No());
			}
			if(this.getBusiness_Date() == null || this.getBusiness_Date().equals("null")) {
				pstmt.setNull(22, 91);
			} else {
				pstmt.setDate(22, Date.valueOf(this.getBusiness_Date()));
			}
			pstmt.setDouble(23, this.getBatch_No());
			if(this.getBatch_Run_Date() == null || this.getBatch_Run_Date().equals("null")) {
				pstmt.setNull(24, 91);
			} else {
				pstmt.setDate(24, Date.valueOf(this.getBatch_Run_Date()));
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean getInfo()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
			pstmt = con.prepareStatement("SELECT * FROM DailyPolicyDetails WHERE  Company_Code = ? AND Policy_No = ? AND Batch_No = ? AND Batch_Run_Date = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getCompany_Code() == null || this.getCompany_Code().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCompany_Code());
			}
			if(this.getPolicy_No() == null || this.getPolicy_No().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getPolicy_No());
			}
			pstmt.setDouble(3, this.getBatch_No());
			if(this.getBatch_Run_Date() == null || this.getBatch_Run_Date().equals("null")) {
				pstmt.setNull(4, 91);
			} else {
				pstmt.setDate(4, Date.valueOf(this.getBatch_Run_Date()));
			}
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				if (!this.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "DailyPolicyDetailsDB";
					tError.functionName = "getInfo";
					tError.errorMessage = "取数失败!";
					this.mErrors .addOneError(tError);

					try{ rs.close(); } catch( Exception ex ) {}
					try{ pstmt.close(); } catch( Exception ex1 ) {}

					if (!mflag)
					{
						try
						{
							con.close();
						}
						catch(Exception et){}
					}
					return false;
				}
				break;
			}
			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if( i == 0 )
			{
				if (!mflag)
				{
					try
					{
						con.close();
					}
					catch(Exception et){}
				}
				return false;
			}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "getInfo";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
			return false;
	    }
	    // 断开数据库连接
		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return true;
	}

	public DailyPolicyDetailsSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DailyPolicyDetailsSet aDailyPolicyDetailsSet = new DailyPolicyDetailsSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 DailyPolicyDetailsSchema aSchemaNew = this.getSchema();
			 int nFieldCount = aSchemaNew.getFieldCount();
			 int j = 0;
			 String strFieldName = "";
			 StringBuffer strFieldValue = null;
			 for (int i = 0; i < nFieldCount; i++) {
			 	if(i==0){
			 		WherePart.append("where");
			 	}
			 	strFieldName = aSchemaNew.getFieldName(i);
			 	strFieldValue = new StringBuffer(100);
			 	int nFieldType = aSchemaNew.getFieldType(i);
			 	boolean bFlag = false;
			 	String[] tParams = new String[2];
			 	switch (nFieldType) {
			 	case Schema.TYPE_STRING:
			 	case Schema.TYPE_DATE:
			 		if (aSchemaNew.getV(i).equals("null")) {
			 			//为空就不准备了
			 		} else {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_DOUBLE:
			 		if (!aSchemaNew.getV(i).equals("0.0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_FLOAT:
			 		if (!aSchemaNew.getV(i).equals("0.0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_INT:
			 		if (!aSchemaNew.getV(i).equals("0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	default:
			 		bFlag = false;
			 		break;
			 	}
			 	if (bFlag) {
			 		j++;
			 		if (j != 1) {
			 			WherePart.append(" and");
			 		}
			 		WherePart.append(" ");
			 		WherePart.append(strFieldName);
			 		WherePart.append("=");
			 		WherePart.append(strFieldValue);
			 		mBV.add(tParams);
			 	}
			 }
			 if (j == 0) {
			 	WherePart.setLength(0);
			 	throw new IllegalArgumentException("Table DailyPolicyDetails is querying for all data!");
			 }
			 mSql.append("select * from DailyPolicyDetails ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				DailyPolicyDetailsSchema s1 = new DailyPolicyDetailsSchema();
				s1.setSchema(rs,i);
				aDailyPolicyDetailsSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aDailyPolicyDetailsSet;
	}

	public DailyPolicyDetailsSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DailyPolicyDetailsSet aDailyPolicyDetailsSet = new DailyPolicyDetailsSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(stmt, bv);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				DailyPolicyDetailsSchema s1 = new DailyPolicyDetailsSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "DailyPolicyDetailsDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aDailyPolicyDetailsSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ stmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aDailyPolicyDetailsSet;
	}

	public DailyPolicyDetailsSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DailyPolicyDetailsSet aDailyPolicyDetailsSet = new DailyPolicyDetailsSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("DailyPolicyDetails");
			DailyPolicyDetailsSchema aSchema = this.getSchema();
			sqlObj.setSQLNew(5,aSchema);
			String sql = sqlObj.getSQL();

			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			List tBV = sqlObj.getBV();
			db.setBV(pstmt, tBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;

				if( i < nStart ) {
					continue;
				}

				if( i >= nStart + nCount ) {
					break;
				}

				DailyPolicyDetailsSchema s1 = new DailyPolicyDetailsSchema();
				s1.setSchema(rs,i);
				aDailyPolicyDetailsSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aDailyPolicyDetailsSet;
	}

	public DailyPolicyDetailsSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DailyPolicyDetailsSet aDailyPolicyDetailsSet = new DailyPolicyDetailsSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(stmt, bv);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;

				if( i < nStart ) {
					continue;
				}

				if( i >= nStart + nCount ) {
					break;
				}

				DailyPolicyDetailsSchema s1 = new DailyPolicyDetailsSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "DailyPolicyDetailsDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aDailyPolicyDetailsSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ stmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aDailyPolicyDetailsSet;
	}

	public boolean update(String strWherePart)
	{
		Statement stmt = null;

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			SQLString sqlObj = new SQLString("DailyPolicyDetails");
			DailyPolicyDetailsSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update DailyPolicyDetails " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "DailyPolicyDetailsDB";
				tError.functionName = "update";
				tError.errorMessage = "更新数据失败!";
				this.mErrors .addOneError(tError);

				if (!mflag)
				{
					try
					{
						con.close();
					}
					catch(Exception et){}
				}
				return false;
			}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDB";
			tError.functionName = "update";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ stmt.close(); } catch( Exception ex1 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
			return false;
	    }
	    // 断开数据库连接
		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return true;
	}

/**
 * 准备数据查询条件
 * @param strSQL String
 * @return boolean
 */
public boolean prepareData(String strSQL)
{
    if (mResultSet != null)
    {
        // @@错误处理
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "prepareData";
        tError.errorMessage = "数据集非空，程序在准备数据集之后，没有关闭！";
        this.mErrors.addOneError(tError);
        return false;
    }

    if (!mflag)
    {
        con = DBConnPool.getConnection();
    }
    try
    {
        mStatement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
    }
    catch (Exception e)
    {
        // @@错误处理
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "prepareData";
        tError.errorMessage = e.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return false;
    }

    if (!mflag)
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {}
    }
    return true;
}

/**
 * 获取数据集
 * @return boolean
 */
public boolean hasMoreData()
{
    boolean flag = true;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "hasMoreData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return false;
    }
    try
    {
        flag = mResultSet.next();
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "hasMoreData";
        tError.errorMessage = ex.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
            mResultSet = null;
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
            mStatement = null;
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return false;
    }
    return flag;
}
/**
 * 获取定量数据
 * @return DailyPolicyDetailsSet
 */
public DailyPolicyDetailsSet getData()
{
    int tCount = 0;
    DailyPolicyDetailsSet tDailyPolicyDetailsSet = new DailyPolicyDetailsSet();
    DailyPolicyDetailsSchema tDailyPolicyDetailsSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tDailyPolicyDetailsSchema = new DailyPolicyDetailsSchema();
        tDailyPolicyDetailsSchema.setSchema(mResultSet, 1);
        tDailyPolicyDetailsSet.add(tDailyPolicyDetailsSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tDailyPolicyDetailsSchema = new DailyPolicyDetailsSchema();
                tDailyPolicyDetailsSchema.setSchema(mResultSet, 1);
                tDailyPolicyDetailsSet.add(tDailyPolicyDetailsSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "getData";
        tError.errorMessage = ex.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
            mResultSet = null;
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
            mStatement = null;
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return null;
    }
    return tDailyPolicyDetailsSet;
}
/**
 * 关闭数据集
 * @return boolean
 */
public boolean closeData()
{
    boolean flag = true;
    try
    {
        if (null == mResultSet)
        {
            CError tError = new CError();
            tError.moduleName = "DailyPolicyDetailsDB";
            tError.functionName = "closeData";
            tError.errorMessage = "数据集已经关闭了！";
            this.mErrors.addOneError(tError);
            flag = false;
        }
        else
        {
            mResultSet.close();
            mResultSet = null;
        }
    }
    catch (Exception ex2)
    {
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex2.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    try
    {
        if (null == mStatement)
        {
            CError tError = new CError();
            tError.moduleName = "DailyPolicyDetailsDB";
            tError.functionName = "closeData";
            tError.errorMessage = "语句已经关闭了！";
            this.mErrors.addOneError(tError);
            flag = false;
        }
        else
        {
            mStatement.close();
            mStatement = null;
        }
    }
    catch (Exception ex3)
    {
        CError tError = new CError();
        tError.moduleName = "DailyPolicyDetailsDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
