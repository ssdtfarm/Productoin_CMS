/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LRBASEHSchema;
import com.sinosoft.lis.vschema.LRBASEHSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LRBASEHDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRBASEHDBSet extends LRBASEHSet
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
	public LRBASEHDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LRBASEH");
		mflag = true;
	}

	public LRBASEHDBSet()
	{
		db = new DBOper( "LRBASEH" );
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
			tError.moduleName = "LRBASEHDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LRBASEH WHERE ");
            for (int i = 1; i <= tCount; i++)
            {

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRBASEH");
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
			tError.moduleName = "LRBASEHDBSet";
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
			pstmt = con.prepareStatement("UPDATE LRBASEH SET  BASECODE = ? , NAME = ? , STATUS = ? , BRANCHTYPE = ? , REMARK = ? , OPERATOR = ? , MODIFYTIME = ? , MODIFYDATE = ? , STARTDATE = ? , ENDDATE = ? WHERE ");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBASECODE() == null || this.get(i).getBASECODE().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBASECODE());
			}
			if(this.get(i).getNAME() == null || this.get(i).getNAME().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getNAME());
			}
			if(this.get(i).getSTATUS() == null || this.get(i).getSTATUS().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getSTATUS());
			}
			if(this.get(i).getBRANCHTYPE() == null || this.get(i).getBRANCHTYPE().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getBRANCHTYPE());
			}
			if(this.get(i).getREMARK() == null || this.get(i).getREMARK().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getREMARK());
			}
			if(this.get(i).getOPERATOR() == null || this.get(i).getOPERATOR().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getOPERATOR());
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getMODIFYTIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getSTARTDATE() == null || this.get(i).getSTARTDATE().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getSTARTDATE()));
			}
			if(this.get(i).getENDDATE() == null || this.get(i).getENDDATE().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getENDDATE()));
			}
			// set where condition

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRBASEH");
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
			tError.moduleName = "LRBASEHDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LRBASEH VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBASECODE() == null || this.get(i).getBASECODE().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBASECODE());
			}
			if(this.get(i).getNAME() == null || this.get(i).getNAME().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getNAME());
			}
			if(this.get(i).getSTATUS() == null || this.get(i).getSTATUS().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getSTATUS());
			}
			if(this.get(i).getBRANCHTYPE() == null || this.get(i).getBRANCHTYPE().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getBRANCHTYPE());
			}
			if(this.get(i).getREMARK() == null || this.get(i).getREMARK().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getREMARK());
			}
			if(this.get(i).getOPERATOR() == null || this.get(i).getOPERATOR().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getOPERATOR());
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getMODIFYTIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getSTARTDATE() == null || this.get(i).getSTARTDATE().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getSTARTDATE()));
			}
			if(this.get(i).getENDDATE() == null || this.get(i).getENDDATE().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getENDDATE()));
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRBASEH");
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
			tError.moduleName = "LRBASEHDBSet";
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
