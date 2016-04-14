/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.DailyPersistencySchema;
import com.sinosoft.lis.vschema.DailyPersistencySet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: DailyPersistencyDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyPersistencyDBSet extends DailyPersistencySet
{
	// @Field
	private Connection con;
	private DBOper db;
	/**
	* flag = true: 传入Connection
	* flag = false: 不传入Connection
	**/
	private boolean mflag = false;


	// @Constructor
	public DailyPersistencyDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"DailyPersistency");
		mflag = true;
	}

	public DailyPersistencyDBSet()
	{
		db = new DBOper( "DailyPersistency" );
		con = db.getConnection();
	}
	// @Method
	public boolean deleteSQL()
	{
		if (db.deleteSQL(this))
		{
		        return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPersistencyDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

    /**
     * 删除操作
     * 删除条件：主键
     * @return boolean
     */
	public boolean delete()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
            int tCount = this.size();
			pstmt = con.prepareStatement("DELETE FROM DailyPersistency WHERE ");
            for (int i = 1; i <= tCount; i++)
            {

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPersistency");
		sqlObj.setSQL(4, this.get(i));
		sqlObj.getSQL();

                pstmt.addBatch();
            }
            pstmt.executeBatch();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
ex.printStackTrace();
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPersistencyDBSet";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){e.printStackTrace();}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){e.printStackTrace();}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){e.printStackTrace();}
		}

		return true;
	}

    /**
     * 更新操作
     * 更新条件：主键
     * @return boolean
     */
	public boolean update()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
            int tCount = this.size();
			pstmt = con.prepareStatement("UPDATE DailyPersistency SET  Company_Code = ? , Policy_No = ? , Product_Code = ? , Coverage_Code = ? , Coverage_Effective_Date = ? , Lapse__ANP_At_Issue = ? , Exposure__ANP_At_Issue = ? , Calculation_Date = ? , Business_Date = ? , Batch_No = ? , Batch_Run_Date = ? WHERE ");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCompany_Code() == null || this.get(i).getCompany_Code().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCompany_Code());
			}
			if(this.get(i).getPolicy_No() == null || this.get(i).getPolicy_No().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPolicy_No());
			}
			if(this.get(i).getProduct_Code() == null || this.get(i).getProduct_Code().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getProduct_Code());
			}
			if(this.get(i).getCoverage_Code() == null || this.get(i).getCoverage_Code().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getCoverage_Code());
			}
			if(this.get(i).getCoverage_Effective_Date() == null || this.get(i).getCoverage_Effective_Date().equals("null")) {
				pstmt.setDate(5,null);
			} else {
				pstmt.setDate(5, Date.valueOf(this.get(i).getCoverage_Effective_Date()));
			}
			pstmt.setDouble(6, this.get(i).getLapse__ANP_At_Issue());
			pstmt.setDouble(7, this.get(i).getExposure__ANP_At_Issue());
			if(this.get(i).getCalculation_Date() == null || this.get(i).getCalculation_Date().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getCalculation_Date()));
			}
			if(this.get(i).getBusiness_Date() == null || this.get(i).getBusiness_Date().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getBusiness_Date()));
			}
			pstmt.setDouble(10, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(11,null);
			} else {
				pstmt.setDate(11, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}
			// set where condition

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPersistency");
		sqlObj.setSQL(2, this.get(i));
		sqlObj.getSQL();

                pstmt.addBatch();
            }
            pstmt.executeBatch();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
ex.printStackTrace();
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPersistencyDBSet";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){e.printStackTrace();}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){e.printStackTrace();}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){e.printStackTrace();}
		}

		return true;
	}

    /**
     * 新增操作
     * @return boolean
     */
	public boolean insert()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
            int tCount = this.size();
			pstmt = con.prepareStatement("INSERT INTO DailyPersistency VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCompany_Code() == null || this.get(i).getCompany_Code().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCompany_Code());
			}
			if(this.get(i).getPolicy_No() == null || this.get(i).getPolicy_No().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPolicy_No());
			}
			if(this.get(i).getProduct_Code() == null || this.get(i).getProduct_Code().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getProduct_Code());
			}
			if(this.get(i).getCoverage_Code() == null || this.get(i).getCoverage_Code().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getCoverage_Code());
			}
			if(this.get(i).getCoverage_Effective_Date() == null || this.get(i).getCoverage_Effective_Date().equals("null")) {
				pstmt.setDate(5,null);
			} else {
				pstmt.setDate(5, Date.valueOf(this.get(i).getCoverage_Effective_Date()));
			}
			pstmt.setDouble(6, this.get(i).getLapse__ANP_At_Issue());
			pstmt.setDouble(7, this.get(i).getExposure__ANP_At_Issue());
			if(this.get(i).getCalculation_Date() == null || this.get(i).getCalculation_Date().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getCalculation_Date()));
			}
			if(this.get(i).getBusiness_Date() == null || this.get(i).getBusiness_Date().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getBusiness_Date()));
			}
			pstmt.setDouble(10, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(11,null);
			} else {
				pstmt.setDate(11, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPersistency");
		sqlObj.setSQL(1, this.get(i));
		sqlObj.getSQL();

                pstmt.addBatch();
            }
            pstmt.executeBatch();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
ex.printStackTrace();
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPersistencyDBSet";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){e.printStackTrace();}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){e.printStackTrace();}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){e.printStackTrace();}
		}

		return true;
	}

}
