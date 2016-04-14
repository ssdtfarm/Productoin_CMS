/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LASubjectSchema;
import com.sinosoft.lis.vschema.LASubjectSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LASubjectDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LASubjectDBSet extends LASubjectSet
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
	public LASubjectDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LASubject");
		mflag = true;
	}

	public LASubjectDBSet()
	{
		db = new DBOper( "LASubject" );
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
			tError.moduleName = "LASubjectDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LASubject WHERE  MainSubjectCode = ? AND Subbranch = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getMainSubjectCode() == null || this.get(i).getMainSubjectCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getMainSubjectCode());
			}
			if(this.get(i).getSubbranch() == null || this.get(i).getSubbranch().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getSubbranch());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LASubject");
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
			tError.moduleName = "LASubjectDBSet";
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
			pstmt = con.prepareStatement("UPDATE LASubject SET  Managecom = ? , BranchType = ? , SubjectCode = ? , SubjectName = ? , RiskCode = ? , Status = ? , CalType = ? , ReflectFiled = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , TaxFlag = ? , OfferFlag = ? , FirstYearFlag = ? , MainSubjectCode = ? , Subbranch = ? , FinanceType = ? , AdjustFlag = ? , CalCode = ? , F1 = ? , F2 = ? , F3 = ? , F4 = ? , F5 = ? , F6 = ? WHERE  MainSubjectCode = ? AND Subbranch = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getManagecom() == null || this.get(i).getManagecom().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getManagecom());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getBranchType());
			}
			if(this.get(i).getSubjectCode() == null || this.get(i).getSubjectCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getSubjectCode());
			}
			if(this.get(i).getSubjectName() == null || this.get(i).getSubjectName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getSubjectName());
			}
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRiskCode());
			}
			if(this.get(i).getStatus() == null || this.get(i).getStatus().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getStatus());
			}
			if(this.get(i).getCalType() == null || this.get(i).getCalType().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getCalType());
			}
			if(this.get(i).getReflectFiled() == null || this.get(i).getReflectFiled().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getReflectFiled());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getModifyTime());
			}
			if(this.get(i).getTaxFlag() == null || this.get(i).getTaxFlag().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getTaxFlag());
			}
			if(this.get(i).getOfferFlag() == null || this.get(i).getOfferFlag().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getOfferFlag());
			}
			if(this.get(i).getFirstYearFlag() == null || this.get(i).getFirstYearFlag().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getFirstYearFlag());
			}
			if(this.get(i).getMainSubjectCode() == null || this.get(i).getMainSubjectCode().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getMainSubjectCode());
			}
			if(this.get(i).getSubbranch() == null || this.get(i).getSubbranch().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getSubbranch());
			}
			if(this.get(i).getFinanceType() == null || this.get(i).getFinanceType().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getFinanceType());
			}
			if(this.get(i).getAdjustFlag() == null || this.get(i).getAdjustFlag().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getAdjustFlag());
			}
			if(this.get(i).getCalCode() == null || this.get(i).getCalCode().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getCalCode());
			}
			pstmt.setDouble(22, this.get(i).getF1());
			pstmt.setDouble(23, this.get(i).getF2());
			pstmt.setDouble(24, this.get(i).getF3());
			pstmt.setDouble(25, this.get(i).getF4());
			pstmt.setDouble(26, this.get(i).getF5());
			pstmt.setDouble(27, this.get(i).getF6());
			// set where condition
			if(this.get(i).getMainSubjectCode() == null || this.get(i).getMainSubjectCode().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getMainSubjectCode());
			}
			if(this.get(i).getSubbranch() == null || this.get(i).getSubbranch().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getSubbranch());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LASubject");
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
			tError.moduleName = "LASubjectDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LASubject VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getManagecom() == null || this.get(i).getManagecom().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getManagecom());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getBranchType());
			}
			if(this.get(i).getSubjectCode() == null || this.get(i).getSubjectCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getSubjectCode());
			}
			if(this.get(i).getSubjectName() == null || this.get(i).getSubjectName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getSubjectName());
			}
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRiskCode());
			}
			if(this.get(i).getStatus() == null || this.get(i).getStatus().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getStatus());
			}
			if(this.get(i).getCalType() == null || this.get(i).getCalType().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getCalType());
			}
			if(this.get(i).getReflectFiled() == null || this.get(i).getReflectFiled().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getReflectFiled());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getModifyTime());
			}
			if(this.get(i).getTaxFlag() == null || this.get(i).getTaxFlag().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getTaxFlag());
			}
			if(this.get(i).getOfferFlag() == null || this.get(i).getOfferFlag().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getOfferFlag());
			}
			if(this.get(i).getFirstYearFlag() == null || this.get(i).getFirstYearFlag().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getFirstYearFlag());
			}
			if(this.get(i).getMainSubjectCode() == null || this.get(i).getMainSubjectCode().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getMainSubjectCode());
			}
			if(this.get(i).getSubbranch() == null || this.get(i).getSubbranch().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getSubbranch());
			}
			if(this.get(i).getFinanceType() == null || this.get(i).getFinanceType().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getFinanceType());
			}
			if(this.get(i).getAdjustFlag() == null || this.get(i).getAdjustFlag().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getAdjustFlag());
			}
			if(this.get(i).getCalCode() == null || this.get(i).getCalCode().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getCalCode());
			}
			pstmt.setDouble(22, this.get(i).getF1());
			pstmt.setDouble(23, this.get(i).getF2());
			pstmt.setDouble(24, this.get(i).getF3());
			pstmt.setDouble(25, this.get(i).getF4());
			pstmt.setDouble(26, this.get(i).getF5());
			pstmt.setDouble(27, this.get(i).getF6());

		// only for debug purpose
		SQLString sqlObj = new SQLString("LASubject");
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
			tError.moduleName = "LASubjectDBSet";
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
