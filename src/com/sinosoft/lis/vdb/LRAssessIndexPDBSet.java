/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LRAssessIndexPSchema;
import com.sinosoft.lis.vschema.LRAssessIndexPSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LRAssessIndexPDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRAssessIndexPDBSet extends LRAssessIndexPSet
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
	public LRAssessIndexPDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LRAssessIndexP");
		mflag = true;
	}

	public LRAssessIndexPDBSet()
	{
		db = new DBOper( "LRAssessIndexP" );
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
			tError.moduleName = "LRAssessIndexPDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LRAssessIndexP WHERE  BaseCode = ? AND AgentGrade = ? AND IndexCode = ? AND MainIndexFlag = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexCode() == null || this.get(i).getIndexCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getIndexCode());
			}
			if(this.get(i).getMainIndexFlag() == null || this.get(i).getMainIndexFlag().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getMainIndexFlag());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRAssessIndexP");
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
			tError.moduleName = "LRAssessIndexPDBSet";
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
			pstmt = con.prepareStatement("UPDATE LRAssessIndexP SET  BaseCode = ? , AgentGrade = ? , IndexCode = ? , IndexName = ? , IndexSet = ? , MainIndexFlag = ? , IndexType = ? , IndexSerise = ? , CalType = ? , CalCode = ? , DataType = ? , ResultType = ? , CalPrpty = ? , DefaultValue = ? , Description = ? , AllSet = ? , CalSql = ? , SqlTemp = ? , Json = ? , BranchType = ? , BranchType2 = ? , ITableName = ? , IColName = ? WHERE  BaseCode = ? AND AgentGrade = ? AND IndexCode = ? AND MainIndexFlag = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexCode() == null || this.get(i).getIndexCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getIndexCode());
			}
			if(this.get(i).getIndexName() == null || this.get(i).getIndexName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getIndexName());
			}
			if(this.get(i).getIndexSet() == null || this.get(i).getIndexSet().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getIndexSet());
			}
			if(this.get(i).getMainIndexFlag() == null || this.get(i).getMainIndexFlag().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getMainIndexFlag());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getIndexType());
			}
			if(this.get(i).getIndexSerise() == null || this.get(i).getIndexSerise().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getIndexSerise());
			}
			if(this.get(i).getCalType() == null || this.get(i).getCalType().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getCalType());
			}
			if(this.get(i).getCalCode() == null || this.get(i).getCalCode().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getCalCode());
			}
			if(this.get(i).getDataType() == null || this.get(i).getDataType().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getDataType());
			}
			if(this.get(i).getResultType() == null || this.get(i).getResultType().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getResultType());
			}
			if(this.get(i).getCalPrpty() == null || this.get(i).getCalPrpty().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getCalPrpty());
			}
			if(this.get(i).getDefaultValue() == null || this.get(i).getDefaultValue().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getDefaultValue());
			}
			if(this.get(i).getDescription() == null || this.get(i).getDescription().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getDescription());
			}
			if(this.get(i).getAllSet() == null || this.get(i).getAllSet().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getAllSet());
			}
			if(this.get(i).getCalSql() == null || this.get(i).getCalSql().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getCalSql());
			}
			if(this.get(i).getSqlTemp() == null || this.get(i).getSqlTemp().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getSqlTemp());
			}
			if(this.get(i).getJson() == null || this.get(i).getJson().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getJson());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getBranchType());
			}
			if(this.get(i).getBranchType2() == null || this.get(i).getBranchType2().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getBranchType2());
			}
			if(this.get(i).getITableName() == null || this.get(i).getITableName().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getITableName());
			}
			if(this.get(i).getIColName() == null || this.get(i).getIColName().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getIColName());
			}
			// set where condition
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getBaseCode());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexCode() == null || this.get(i).getIndexCode().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getIndexCode());
			}
			if(this.get(i).getMainIndexFlag() == null || this.get(i).getMainIndexFlag().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getMainIndexFlag());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRAssessIndexP");
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
			tError.moduleName = "LRAssessIndexPDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LRAssessIndexP VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getBaseCode() == null || this.get(i).getBaseCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getBaseCode());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getAgentGrade());
			}
			if(this.get(i).getIndexCode() == null || this.get(i).getIndexCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getIndexCode());
			}
			if(this.get(i).getIndexName() == null || this.get(i).getIndexName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getIndexName());
			}
			if(this.get(i).getIndexSet() == null || this.get(i).getIndexSet().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getIndexSet());
			}
			if(this.get(i).getMainIndexFlag() == null || this.get(i).getMainIndexFlag().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getMainIndexFlag());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getIndexType());
			}
			if(this.get(i).getIndexSerise() == null || this.get(i).getIndexSerise().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getIndexSerise());
			}
			if(this.get(i).getCalType() == null || this.get(i).getCalType().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getCalType());
			}
			if(this.get(i).getCalCode() == null || this.get(i).getCalCode().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getCalCode());
			}
			if(this.get(i).getDataType() == null || this.get(i).getDataType().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getDataType());
			}
			if(this.get(i).getResultType() == null || this.get(i).getResultType().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getResultType());
			}
			if(this.get(i).getCalPrpty() == null || this.get(i).getCalPrpty().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getCalPrpty());
			}
			if(this.get(i).getDefaultValue() == null || this.get(i).getDefaultValue().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getDefaultValue());
			}
			if(this.get(i).getDescription() == null || this.get(i).getDescription().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getDescription());
			}
			if(this.get(i).getAllSet() == null || this.get(i).getAllSet().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getAllSet());
			}
			if(this.get(i).getCalSql() == null || this.get(i).getCalSql().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getCalSql());
			}
			if(this.get(i).getSqlTemp() == null || this.get(i).getSqlTemp().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getSqlTemp());
			}
			if(this.get(i).getJson() == null || this.get(i).getJson().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getJson());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getBranchType());
			}
			if(this.get(i).getBranchType2() == null || this.get(i).getBranchType2().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getBranchType2());
			}
			if(this.get(i).getITableName() == null || this.get(i).getITableName().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getITableName());
			}
			if(this.get(i).getIColName() == null || this.get(i).getIColName().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getIColName());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRAssessIndexP");
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
			tError.moduleName = "LRAssessIndexPDBSet";
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
