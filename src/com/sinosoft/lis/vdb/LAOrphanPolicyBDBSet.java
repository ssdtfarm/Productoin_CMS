/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LAOrphanPolicyBSchema;
import com.sinosoft.lis.vschema.LAOrphanPolicyBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAOrphanPolicyBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAOrphanPolicyBDBSet extends LAOrphanPolicyBSet
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
	public LAOrphanPolicyBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LAOrphanPolicyB");
		mflag = true;
	}

	public LAOrphanPolicyBDBSet()
	{
		db = new DBOper( "LAOrphanPolicyB" );
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
			tError.moduleName = "LAOrphanPolicyBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAOrphanPolicyB WHERE  MainPolNo = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getMainPolNo() == null || this.get(i).getMainPolNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getMainPolNo());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(3,null);
			} else {
				pstmt.setDate(3, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAOrphanPolicyB");
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
			tError.moduleName = "LAOrphanPolicyBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAOrphanPolicyB SET  MainPolNo = ? , PrimaryAgentCode = ? , PrimaryOutWorkDate = ? , PrimaryDebitAmt = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator1 = ? , MakeDate1 = ? , MakeTime1 = ? WHERE  MainPolNo = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getMainPolNo() == null || this.get(i).getMainPolNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getMainPolNo());
			}
			if(this.get(i).getPrimaryAgentCode() == null || this.get(i).getPrimaryAgentCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPrimaryAgentCode());
			}
			if(this.get(i).getPrimaryOutWorkDate() == null || this.get(i).getPrimaryOutWorkDate().equals("null")) {
				pstmt.setDate(3,null);
			} else {
				pstmt.setDate(3, Date.valueOf(this.get(i).getPrimaryOutWorkDate()));
			}
			pstmt.setDouble(4, this.get(i).getPrimaryDebitAmt());
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(11,null);
			} else {
				pstmt.setDate(11, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getMakeTime1());
			}
			// set where condition
			if(this.get(i).getMainPolNo() == null || this.get(i).getMainPolNo().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getMainPolNo());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAOrphanPolicyB");
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
			tError.moduleName = "LAOrphanPolicyBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAOrphanPolicyB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getMainPolNo() == null || this.get(i).getMainPolNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getMainPolNo());
			}
			if(this.get(i).getPrimaryAgentCode() == null || this.get(i).getPrimaryAgentCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPrimaryAgentCode());
			}
			if(this.get(i).getPrimaryOutWorkDate() == null || this.get(i).getPrimaryOutWorkDate().equals("null")) {
				pstmt.setDate(3,null);
			} else {
				pstmt.setDate(3, Date.valueOf(this.get(i).getPrimaryOutWorkDate()));
			}
			pstmt.setDouble(4, this.get(i).getPrimaryDebitAmt());
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(11,null);
			} else {
				pstmt.setDate(11, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAOrphanPolicyB");
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
			tError.moduleName = "LAOrphanPolicyBDBSet";
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
