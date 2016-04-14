/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.DailyAFYCSchema;
import com.sinosoft.lis.vschema.DailyAFYCSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: DailyAFYCDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyAFYCDBSet extends DailyAFYCSet
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
	public DailyAFYCDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"DailyAFYC");
		mflag = true;
	}

	public DailyAFYCDBSet()
	{
		db = new DBOper( "DailyAFYC" );
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
			tError.moduleName = "DailyAFYCDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM DailyAFYC WHERE ");
            for (int i = 1; i <= tCount; i++)
            {

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyAFYC");
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
			tError.moduleName = "DailyAFYCDBSet";
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
			pstmt = con.prepareStatement("UPDATE DailyAFYC SET  Company_Code = ? , Policy_No = ? , Product_Code = ? , Coverage_Code = ? , Coverage_Effective_Date = ? , AFYC = ? , AFYP = ? , Trx_Code = ? , Calculation_Date = ? , Business_Date = ? , Batch_No = ? , Batch_Run_Date = ? WHERE ");
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
			pstmt.setDouble(6, this.get(i).getAFYC());
			pstmt.setDouble(7, this.get(i).getAFYP());
			if(this.get(i).getTrx_Code() == null || this.get(i).getTrx_Code().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getTrx_Code());
			}
			if(this.get(i).getCalculation_Date() == null || this.get(i).getCalculation_Date().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getCalculation_Date()));
			}
			if(this.get(i).getBusiness_Date() == null || this.get(i).getBusiness_Date().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getBusiness_Date()));
			}
			pstmt.setDouble(11, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}
			// set where condition

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyAFYC");
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
			tError.moduleName = "DailyAFYCDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO DailyAFYC VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			pstmt.setDouble(6, this.get(i).getAFYC());
			pstmt.setDouble(7, this.get(i).getAFYP());
			if(this.get(i).getTrx_Code() == null || this.get(i).getTrx_Code().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getTrx_Code());
			}
			if(this.get(i).getCalculation_Date() == null || this.get(i).getCalculation_Date().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getCalculation_Date()));
			}
			if(this.get(i).getBusiness_Date() == null || this.get(i).getBusiness_Date().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getBusiness_Date()));
			}
			pstmt.setDouble(11, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyAFYC");
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
			tError.moduleName = "DailyAFYCDBSet";
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
