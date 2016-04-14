/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.LRIndexInfoSchema;
import com.sinosoft.lis.vschema.LRIndexInfoSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LRIndexInfoDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRIndexInfoDB extends LRIndexInfoSchema
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
	public LRIndexInfoDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LRIndexInfo" );
		mflag = true;
	}

	public LRIndexInfoDB()
	{
		con = null;
		db = new DBOper( "LRIndexInfo" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LRIndexInfoSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LRIndexInfoSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
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
			pstmt = con.prepareStatement("DELETE FROM LRIndexInfo WHERE  WageNo = ? AND IndexType = ? AND BranchType = ? AND BranchType2 = ? AND BaseCode = ? AND IndexCode = ? AND AgentCode = ?");
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexType());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBranchType2());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBaseCode());
			}
			if(this.getIndexCode() == null || this.getIndexCode().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getIndexCode());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRIndexInfo");
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
		SQLString sqlObj = new SQLString("LRIndexInfo");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LRIndexInfo SET  WageNo = ? , IndexType = ? , BranchType = ? , BranchType2 = ? , BaseCode = ? , IndexCode = ? , AgentCode = ? , AgentGrade = ? , ManageCom = ? , BranchAttr = ? , AgentGroup = ? , BranchSeries = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , DataType = ? , D = ? , N0 = ? , N2 = ? , N4 = ? , N6 = ? , S = ? , MainIndexFlag = ? , WageName = ? , WageCode = ? , CalType = ? WHERE  WageNo = ? AND IndexType = ? AND BranchType = ? AND BranchType2 = ? AND BaseCode = ? AND IndexCode = ? AND AgentCode = ?");
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexType());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBranchType2());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBaseCode());
			}
			if(this.getIndexCode() == null || this.getIndexCode().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getIndexCode());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentCode());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getAgentGrade());
			}
			if(this.getManageCom() == null || this.getManageCom().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getManageCom());
			}
			if(this.getBranchAttr() == null || this.getBranchAttr().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getBranchAttr());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getAgentGroup());
			}
			if(this.getBranchSeries() == null || this.getBranchSeries().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getBranchSeries());
			}
			if(this.getState() == null || this.getState().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getState());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(17, 91);
			} else {
				pstmt.setDate(17, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getModifyTime());
			}
			if(this.getDataType() == null || this.getDataType().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getDataType());
			}
			if(this.getD() == null || this.getD().equals("null")) {
				pstmt.setNull(20, 91);
			} else {
				pstmt.setDate(20, Date.valueOf(this.getD()));
			}
			pstmt.setInt(21, this.getN0());
			pstmt.setDouble(22, this.getN2());
			pstmt.setDouble(23, this.getN4());
			pstmt.setDouble(24, this.getN6());
			if(this.getS() == null || this.getS().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getS());
			}
			if(this.getMainIndexFlag() == null || this.getMainIndexFlag().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getMainIndexFlag());
			}
			if(this.getWageName() == null || this.getWageName().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getWageName());
			}
			if(this.getWageCode() == null || this.getWageCode().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getWageCode());
			}
			if(this.getCalType() == null || this.getCalType().equals("null")) {
				pstmt.setNull(29, 12);
			} else {
				pstmt.setString(29, this.getCalType());
			}
			// set where condition
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getIndexType());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getBranchType2());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getBaseCode());
			}
			if(this.getIndexCode() == null || this.getIndexCode().equals("null")) {
				pstmt.setNull(35, 12);
			} else {
				pstmt.setString(35, this.getIndexCode());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(36, 12);
			} else {
				pstmt.setString(36, this.getAgentCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
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
		SQLString sqlObj = new SQLString("LRIndexInfo");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LRIndexInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexType());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBranchType2());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBaseCode());
			}
			if(this.getIndexCode() == null || this.getIndexCode().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getIndexCode());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentCode());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getAgentGrade());
			}
			if(this.getManageCom() == null || this.getManageCom().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getManageCom());
			}
			if(this.getBranchAttr() == null || this.getBranchAttr().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getBranchAttr());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getAgentGroup());
			}
			if(this.getBranchSeries() == null || this.getBranchSeries().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getBranchSeries());
			}
			if(this.getState() == null || this.getState().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getState());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(17, 91);
			} else {
				pstmt.setDate(17, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getModifyTime());
			}
			if(this.getDataType() == null || this.getDataType().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getDataType());
			}
			if(this.getD() == null || this.getD().equals("null")) {
				pstmt.setNull(20, 91);
			} else {
				pstmt.setDate(20, Date.valueOf(this.getD()));
			}
			pstmt.setInt(21, this.getN0());
			pstmt.setDouble(22, this.getN2());
			pstmt.setDouble(23, this.getN4());
			pstmt.setDouble(24, this.getN6());
			if(this.getS() == null || this.getS().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getS());
			}
			if(this.getMainIndexFlag() == null || this.getMainIndexFlag().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getMainIndexFlag());
			}
			if(this.getWageName() == null || this.getWageName().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getWageName());
			}
			if(this.getWageCode() == null || this.getWageCode().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getWageCode());
			}
			if(this.getCalType() == null || this.getCalType().equals("null")) {
				pstmt.setNull(29, 12);
			} else {
				pstmt.setString(29, this.getCalType());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
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
			pstmt = con.prepareStatement("SELECT * FROM LRIndexInfo WHERE  WageNo = ? AND IndexType = ? AND BranchType = ? AND BranchType2 = ? AND BaseCode = ? AND IndexCode = ? AND AgentCode = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexType());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBranchType2());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBaseCode());
			}
			if(this.getIndexCode() == null || this.getIndexCode().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getIndexCode());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentCode());
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
					tError.moduleName = "LRIndexInfoDB";
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
			tError.moduleName = "LRIndexInfoDB";
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

	public LRIndexInfoSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LRIndexInfoSet aLRIndexInfoSet = new LRIndexInfoSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 LRIndexInfoSchema aSchemaNew = this.getSchema();
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
			 	throw new IllegalArgumentException("Table LRIndexInfo is querying for all data!");
			 }
			 mSql.append("select * from LRIndexInfo ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LRIndexInfoSchema s1 = new LRIndexInfoSchema();
				s1.setSchema(rs,i);
				aLRIndexInfoSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
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

		return aLRIndexInfoSet;
	}

	public LRIndexInfoSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LRIndexInfoSet aLRIndexInfoSet = new LRIndexInfoSet();

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
				LRIndexInfoSchema s1 = new LRIndexInfoSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LRIndexInfoDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLRIndexInfoSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
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

		return aLRIndexInfoSet;
	}

	public LRIndexInfoSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LRIndexInfoSet aLRIndexInfoSet = new LRIndexInfoSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("LRIndexInfo");
			LRIndexInfoSchema aSchema = this.getSchema();
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

				LRIndexInfoSchema s1 = new LRIndexInfoSchema();
				s1.setSchema(rs,i);
				aLRIndexInfoSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
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

		return aLRIndexInfoSet;
	}

	public LRIndexInfoSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LRIndexInfoSet aLRIndexInfoSet = new LRIndexInfoSet();

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

				LRIndexInfoSchema s1 = new LRIndexInfoSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LRIndexInfoDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLRIndexInfoSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRIndexInfoDB";
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

		return aLRIndexInfoSet;
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
			SQLString sqlObj = new SQLString("LRIndexInfo");
			LRIndexInfoSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LRIndexInfo " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LRIndexInfoDB";
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
			tError.moduleName = "LRIndexInfoDB";
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
        tError.moduleName = "LRIndexInfoDB";
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
        tError.moduleName = "LRIndexInfoDB";
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
        tError.moduleName = "LRIndexInfoDB";
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
        tError.moduleName = "LRIndexInfoDB";
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
 * @return LRIndexInfoSet
 */
public LRIndexInfoSet getData()
{
    int tCount = 0;
    LRIndexInfoSet tLRIndexInfoSet = new LRIndexInfoSet();
    LRIndexInfoSchema tLRIndexInfoSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LRIndexInfoDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLRIndexInfoSchema = new LRIndexInfoSchema();
        tLRIndexInfoSchema.setSchema(mResultSet, 1);
        tLRIndexInfoSet.add(tLRIndexInfoSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLRIndexInfoSchema = new LRIndexInfoSchema();
                tLRIndexInfoSchema.setSchema(mResultSet, 1);
                tLRIndexInfoSet.add(tLRIndexInfoSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LRIndexInfoDB";
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
    return tLRIndexInfoSet;
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
            tError.moduleName = "LRIndexInfoDB";
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
        tError.moduleName = "LRIndexInfoDB";
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
            tError.moduleName = "LRIndexInfoDB";
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
        tError.moduleName = "LRIndexInfoDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
