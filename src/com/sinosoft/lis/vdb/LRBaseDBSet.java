/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LRBaseSchema;
import com.sinosoft.lis.vschema.LRBaseSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LRBaseDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRBaseDBSet extends LRBaseSet
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
	public LRBaseDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LRBase");
		mflag = true;
	}

	public LRBaseDBSet()
	{
		db = new DBOper( "LRBase" );
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
			tError.moduleName = "LRBaseDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LRBase WHERE  BaseCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRBase");
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
			tError.moduleName = "LRBaseDBSet";
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
			pstmt = con.prepareStatement("UPDATE LRBase SET  BaseCode = ? , Name = ? , Status = ? , Remark = ? , Reason = ? , BranchType = ? , BranchType2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  BaseCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getName() == null || this.get(i).getName().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getName());
			}
			if(this.get(i).getStatus() == null || this.get(i).getStatus().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getStatus());
			}
			if(this.get(i).getRemark() == null || this.get(i).getRemark().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getRemark());
			}
			if(this.get(i).getReason() == null || this.get(i).getReason().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getReason());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getBranchType());
			}
			if(this.get(i).getBranchType2() == null || this.get(i).getBranchType2().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getBranchType2());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(11,null);
			} else {
				pstmt.setDate(11, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getModifyTime());
			}
			// set where condition
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getBaseCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRBase");
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
			tError.moduleName = "LRBaseDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LRBase VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getName() == null || this.get(i).getName().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getName());
			}
			if(this.get(i).getStatus() == null || this.get(i).getStatus().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getStatus());
			}
			if(this.get(i).getRemark() == null || this.get(i).getRemark().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getRemark());
			}
			if(this.get(i).getReason() == null || this.get(i).getReason().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getReason());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getBranchType());
			}
			if(this.get(i).getBranchType2() == null || this.get(i).getBranchType2().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getBranchType2());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(11,null);
			} else {
				pstmt.setDate(11, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getModifyTime());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRBase");
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
			tError.moduleName = "LRBaseDBSet";
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
