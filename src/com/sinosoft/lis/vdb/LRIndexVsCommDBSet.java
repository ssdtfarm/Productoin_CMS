/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LRIndexVsCommSchema;
import com.sinosoft.lis.vschema.LRIndexVsCommSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LRIndexVsCommDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRIndexVsCommDBSet extends LRIndexVsCommSet
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
	public LRIndexVsCommDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LRIndexVsComm");
		mflag = true;
	}

	public LRIndexVsCommDBSet()
	{
		db = new DBOper( "LRIndexVsComm" );
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
			tError.moduleName = "LRIndexVsCommDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LRIndexVsComm WHERE  BaseCode = ? AND ManageCom = ? AND AgentGrade = ? AND IndexType = ? AND WageCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getManageCom() == null || this.get(i).getManageCom().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getManageCom());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getIndexType());
			}
			if(this.get(i).getWageCode() == null || this.get(i).getWageCode().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getWageCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRIndexVsComm");
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
			tError.moduleName = "LRIndexVsCommDBSet";
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
			pstmt = con.prepareStatement("UPDATE LRIndexVsComm SET  BaseCode = ? , ManageCom = ? , AgentGrade = ? , IndexType = ? , IndexSerise = ? , WageCode = ? , WageName = ? , IndexCode = ? , Description = ? , WageOrder = ? , BranchType = ? , BranchType2 = ? WHERE  BaseCode = ? AND ManageCom = ? AND AgentGrade = ? AND IndexType = ? AND WageCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getManageCom() == null || this.get(i).getManageCom().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getManageCom());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getIndexType());
			}
			if(this.get(i).getIndexSerise() == null || this.get(i).getIndexSerise().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getIndexSerise());
			}
			if(this.get(i).getWageCode() == null || this.get(i).getWageCode().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getWageCode());
			}
			if(this.get(i).getWageName() == null || this.get(i).getWageName().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getWageName());
			}
			if(this.get(i).getIndexCode() == null || this.get(i).getIndexCode().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getIndexCode());
			}
			if(this.get(i).getDescription() == null || this.get(i).getDescription().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getDescription());
			}
			pstmt.setInt(10, this.get(i).getWageOrder());
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getBranchType());
			}
			if(this.get(i).getBranchType2() == null || this.get(i).getBranchType2().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getBranchType2());
			}
			// set where condition
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getBaseCode());
			}
			if(this.get(i).getManageCom() == null || this.get(i).getManageCom().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getManageCom());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getIndexType());
			}
			if(this.get(i).getWageCode() == null || this.get(i).getWageCode().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getWageCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRIndexVsComm");
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
			tError.moduleName = "LRIndexVsCommDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LRIndexVsComm VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getManageCom() == null || this.get(i).getManageCom().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getManageCom());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getIndexType());
			}
			if(this.get(i).getIndexSerise() == null || this.get(i).getIndexSerise().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getIndexSerise());
			}
			if(this.get(i).getWageCode() == null || this.get(i).getWageCode().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getWageCode());
			}
			if(this.get(i).getWageName() == null || this.get(i).getWageName().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getWageName());
			}
			if(this.get(i).getIndexCode() == null || this.get(i).getIndexCode().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getIndexCode());
			}
			if(this.get(i).getDescription() == null || this.get(i).getDescription().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getDescription());
			}
			pstmt.setInt(10, this.get(i).getWageOrder());
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getBranchType());
			}
			if(this.get(i).getBranchType2() == null || this.get(i).getBranchType2().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getBranchType2());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRIndexVsComm");
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
			tError.moduleName = "LRIndexVsCommDBSet";
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
