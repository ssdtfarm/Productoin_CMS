/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.DailyCMSLogSchema;
import com.sinosoft.lis.vschema.DailyCMSLogSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: DailyCMSLogDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyCMSLogDBSet extends DailyCMSLogSet
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
	public DailyCMSLogDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"DailyCMSLog");
		mflag = true;
	}

	public DailyCMSLogDBSet()
	{
		db = new DBOper( "DailyCMSLog" );
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
			tError.moduleName = "DailyCMSLogDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM DailyCMSLog WHERE  Batch_File_ID = ? AND Batch_Date = ? AND Batch_No = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBatch_File_ID() == null || this.get(i).getBatch_File_ID().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBatch_File_ID());
			}
			pstmt.setDouble(2, this.get(i).getBatch_Date());
			pstmt.setDouble(3, this.get(i).getBatch_No());

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyCMSLog");
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
			tError.moduleName = "DailyCMSLogDBSet";
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
			pstmt = con.prepareStatement("UPDATE DailyCMSLog SET  Batch_File_ID = ? , Batch_Date = ? , Batch_No = ? , No_Of_Records = ? , Complete_Status = ? WHERE  Batch_File_ID = ? AND Batch_Date = ? AND Batch_No = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBatch_File_ID() == null || this.get(i).getBatch_File_ID().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBatch_File_ID());
			}
			pstmt.setDouble(2, this.get(i).getBatch_Date());
			pstmt.setDouble(3, this.get(i).getBatch_No());
			pstmt.setDouble(4, this.get(i).getNo_Of_Records());
			if(this.get(i).getComplete_Status() == null || this.get(i).getComplete_Status().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getComplete_Status());
			}
			// set where condition
			if(this.get(i).getBatch_File_ID() == null || this.get(i).getBatch_File_ID().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getBatch_File_ID());
			}
			pstmt.setDouble(7, this.get(i).getBatch_Date());
			pstmt.setDouble(8, this.get(i).getBatch_No());

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyCMSLog");
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
			tError.moduleName = "DailyCMSLogDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO DailyCMSLog VALUES( ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBatch_File_ID() == null || this.get(i).getBatch_File_ID().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBatch_File_ID());
			}
			pstmt.setDouble(2, this.get(i).getBatch_Date());
			pstmt.setDouble(3, this.get(i).getBatch_No());
			pstmt.setDouble(4, this.get(i).getNo_Of_Records());
			if(this.get(i).getComplete_Status() == null || this.get(i).getComplete_Status().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getComplete_Status());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyCMSLog");
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
			tError.moduleName = "DailyCMSLogDBSet";
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
