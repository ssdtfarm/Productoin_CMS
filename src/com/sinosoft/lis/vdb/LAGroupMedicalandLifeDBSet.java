/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LAGroupMedicalandLifeSchema;
import com.sinosoft.lis.vschema.LAGroupMedicalandLifeSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAGroupMedicalandLifeDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAGroupMedicalandLifeDBSet extends LAGroupMedicalandLifeSet
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
	public LAGroupMedicalandLifeDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LAGroupMedicalandLife");
		mflag = true;
	}

	public LAGroupMedicalandLifeDBSet()
	{
		db = new DBOper( "LAGroupMedicalandLife" );
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
			tError.moduleName = "LAGroupMedicalandLifeDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAGroupMedicalandLife WHERE  AgentCode = ? AND POLTYPE = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getPOLTYPE() == null || this.get(i).getPOLTYPE().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPOLTYPE());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAGroupMedicalandLife");
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
			tError.moduleName = "LAGroupMedicalandLifeDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAGroupMedicalandLife SET  AgentCode = ? , ClassCode = ? , POLTYPE = ? , DependentPremium = ? , CoverageAmount = ? , NextReviewDate = ? , Noofchildren = ? , EffectiveDate = ? , Operator = ? , MAKEDATE = ? , MAKETIME = ? , MODIFYDATE = ? , MODIFYTIME = ? WHERE  AgentCode = ? AND POLTYPE = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getClassCode() == null || this.get(i).getClassCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getClassCode());
			}
			if(this.get(i).getPOLTYPE() == null || this.get(i).getPOLTYPE().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getPOLTYPE());
			}
			pstmt.setDouble(4, this.get(i).getDependentPremium());
			pstmt.setDouble(5, this.get(i).getCoverageAmount());
			if(this.get(i).getNextReviewDate() == null || this.get(i).getNextReviewDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getNextReviewDate()));
			}
			pstmt.setDouble(7, this.get(i).getNoofchildren());
			if(this.get(i).getEffectiveDate() == null || this.get(i).getEffectiveDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getEffectiveDate()));
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getOperator());
			}
			if(this.get(i).getMAKEDATE() == null || this.get(i).getMAKEDATE().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getMAKEDATE()));
			}
			if(this.get(i).getMAKETIME() == null || this.get(i).getMAKETIME().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getMAKETIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getMODIFYTIME());
			}
			// set where condition
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getAgentCode());
			}
			if(this.get(i).getPOLTYPE() == null || this.get(i).getPOLTYPE().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getPOLTYPE());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAGroupMedicalandLife");
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
			tError.moduleName = "LAGroupMedicalandLifeDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAGroupMedicalandLife VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getClassCode() == null || this.get(i).getClassCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getClassCode());
			}
			if(this.get(i).getPOLTYPE() == null || this.get(i).getPOLTYPE().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getPOLTYPE());
			}
			pstmt.setDouble(4, this.get(i).getDependentPremium());
			pstmt.setDouble(5, this.get(i).getCoverageAmount());
			if(this.get(i).getNextReviewDate() == null || this.get(i).getNextReviewDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getNextReviewDate()));
			}
			pstmt.setDouble(7, this.get(i).getNoofchildren());
			if(this.get(i).getEffectiveDate() == null || this.get(i).getEffectiveDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getEffectiveDate()));
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getOperator());
			}
			if(this.get(i).getMAKEDATE() == null || this.get(i).getMAKEDATE().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getMAKEDATE()));
			}
			if(this.get(i).getMAKETIME() == null || this.get(i).getMAKETIME().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getMAKETIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getMODIFYTIME());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAGroupMedicalandLife");
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
			tError.moduleName = "LAGroupMedicalandLifeDBSet";
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
