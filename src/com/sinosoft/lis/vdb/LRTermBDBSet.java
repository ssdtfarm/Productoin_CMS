/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LRTermBSchema;
import com.sinosoft.lis.vschema.LRTermBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LRTermBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRTermBDBSet extends LRTermBSet
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
	public LRTermBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LRTermB");
		mflag = true;
	}

	public LRTermBDBSet()
	{
		db = new DBOper( "LRTermB" );
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
			tError.moduleName = "LRTermBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LRTermB WHERE  EdorNo = ? AND Id = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getEdorNo() == null || this.get(i).getEdorNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getEdorNo());
			}
			if(this.get(i).getId() == null || this.get(i).getId().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getId());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRTermB");
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
			tError.moduleName = "LRTermBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LRTermB SET  EdorNo = ? , Id = ? , Name = ? , BomId = ? , Remark = ? , DisPlayOrder = ? , State = ? , DataType = ? , CalType = ? , Attribute = ? , CalSql = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ModifyDate2 = ? , ModifyTime2 = ? WHERE  EdorNo = ? AND Id = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getEdorNo() == null || this.get(i).getEdorNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getEdorNo());
			}
			if(this.get(i).getId() == null || this.get(i).getId().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getId());
			}
			if(this.get(i).getName() == null || this.get(i).getName().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getName());
			}
			if(this.get(i).getBomId() == null || this.get(i).getBomId().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getBomId());
			}
			if(this.get(i).getRemark() == null || this.get(i).getRemark().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRemark());
			}
			pstmt.setInt(6, this.get(i).getDisPlayOrder());
			if(this.get(i).getState() == null || this.get(i).getState().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getState());
			}
			if(this.get(i).getDataType() == null || this.get(i).getDataType().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getDataType());
			}
			if(this.get(i).getCalType() == null || this.get(i).getCalType().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getCalType());
			}
			if(this.get(i).getAttribute() == null || this.get(i).getAttribute().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getAttribute());
			}
			if(this.get(i).getCalSql() == null || this.get(i).getCalSql().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getCalSql());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(13,null);
			} else {
				pstmt.setDate(13, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator2() == null || this.get(i).getOperator2().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getOperator2());
			}
			if(this.get(i).getMakeDate2() == null || this.get(i).getMakeDate2().equals("null")) {
				pstmt.setDate(18,null);
			} else {
				pstmt.setDate(18, Date.valueOf(this.get(i).getMakeDate2()));
			}
			if(this.get(i).getMakeTime2() == null || this.get(i).getMakeTime2().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getMakeTime2());
			}
			if(this.get(i).getModifyDate2() == null || this.get(i).getModifyDate2().equals("null")) {
				pstmt.setDate(20,null);
			} else {
				pstmt.setDate(20, Date.valueOf(this.get(i).getModifyDate2()));
			}
			if(this.get(i).getModifyTime2() == null || this.get(i).getModifyTime2().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getModifyTime2());
			}
			// set where condition
			if(this.get(i).getEdorNo() == null || this.get(i).getEdorNo().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getEdorNo());
			}
			if(this.get(i).getId() == null || this.get(i).getId().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getId());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRTermB");
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
			tError.moduleName = "LRTermBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LRTermB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getEdorNo() == null || this.get(i).getEdorNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getEdorNo());
			}
			if(this.get(i).getId() == null || this.get(i).getId().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getId());
			}
			if(this.get(i).getName() == null || this.get(i).getName().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getName());
			}
			if(this.get(i).getBomId() == null || this.get(i).getBomId().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getBomId());
			}
			if(this.get(i).getRemark() == null || this.get(i).getRemark().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRemark());
			}
			pstmt.setInt(6, this.get(i).getDisPlayOrder());
			if(this.get(i).getState() == null || this.get(i).getState().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getState());
			}
			if(this.get(i).getDataType() == null || this.get(i).getDataType().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getDataType());
			}
			if(this.get(i).getCalType() == null || this.get(i).getCalType().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getCalType());
			}
			if(this.get(i).getAttribute() == null || this.get(i).getAttribute().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getAttribute());
			}
			if(this.get(i).getCalSql() == null || this.get(i).getCalSql().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getCalSql());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(13,null);
			} else {
				pstmt.setDate(13, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator2() == null || this.get(i).getOperator2().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getOperator2());
			}
			if(this.get(i).getMakeDate2() == null || this.get(i).getMakeDate2().equals("null")) {
				pstmt.setDate(18,null);
			} else {
				pstmt.setDate(18, Date.valueOf(this.get(i).getMakeDate2()));
			}
			if(this.get(i).getMakeTime2() == null || this.get(i).getMakeTime2().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getMakeTime2());
			}
			if(this.get(i).getModifyDate2() == null || this.get(i).getModifyDate2().equals("null")) {
				pstmt.setDate(20,null);
			} else {
				pstmt.setDate(20, Date.valueOf(this.get(i).getModifyDate2()));
			}
			if(this.get(i).getModifyTime2() == null || this.get(i).getModifyTime2().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getModifyTime2());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LRTermB");
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
			tError.moduleName = "LRTermBDBSet";
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
