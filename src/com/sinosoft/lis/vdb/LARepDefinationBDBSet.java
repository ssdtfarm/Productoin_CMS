/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LARepDefinationBSchema;
import com.sinosoft.lis.vschema.LARepDefinationBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LARepDefinationBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LARepDefinationBDBSet extends LARepDefinationBSet
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
	public LARepDefinationBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LARepDefinationB");
		mflag = true;
	}

	public LARepDefinationBDBSet()
	{
		db = new DBOper( "LARepDefinationB" );
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
			tError.moduleName = "LARepDefinationBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LARepDefinationB WHERE  ReportName = ? AND MakeDate1 = ? AND MakeTime1 = ? AND Operator1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getReportName() == null || this.get(i).getReportName().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getReportName());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(2,null);
			} else {
				pstmt.setDate(2, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getMakeTime1());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getOperator1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LARepDefinationB");
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
			tError.moduleName = "LARepDefinationBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LARepDefinationB SET  ReportName = ? , TemplateName = ? , IntDefFile = ? , Flag1 = ? , Flag2 = ? , Flag3 = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator = ? , MakeDate1 = ? , MakeTime1 = ? , Operator1 = ? WHERE  ReportName = ? AND MakeDate1 = ? AND MakeTime1 = ? AND Operator1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getReportName() == null || this.get(i).getReportName().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getReportName());
			}
			if(this.get(i).getTemplateName() == null || this.get(i).getTemplateName().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getTemplateName());
			}
			if(this.get(i).getIntDefFile() == null || this.get(i).getIntDefFile().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getIntDefFile());
			}
			if(this.get(i).getFlag1() == null || this.get(i).getFlag1().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getFlag1());
			}
			if(this.get(i).getFlag2() == null || this.get(i).getFlag2().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getFlag2());
			}
			if(this.get(i).getFlag3() == null || this.get(i).getFlag3().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getFlag3());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(7,null);
			} else {
				pstmt.setDate(7, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getMakeTime1());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getOperator1());
			}
			// set where condition
			if(this.get(i).getReportName() == null || this.get(i).getReportName().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getReportName());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(16,null);
			} else {
				pstmt.setDate(16, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getMakeTime1());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getOperator1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LARepDefinationB");
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
			tError.moduleName = "LARepDefinationBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LARepDefinationB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getReportName() == null || this.get(i).getReportName().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getReportName());
			}
			if(this.get(i).getTemplateName() == null || this.get(i).getTemplateName().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getTemplateName());
			}
			if(this.get(i).getIntDefFile() == null || this.get(i).getIntDefFile().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getIntDefFile());
			}
			if(this.get(i).getFlag1() == null || this.get(i).getFlag1().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getFlag1());
			}
			if(this.get(i).getFlag2() == null || this.get(i).getFlag2().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getFlag2());
			}
			if(this.get(i).getFlag3() == null || this.get(i).getFlag3().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getFlag3());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(7,null);
			} else {
				pstmt.setDate(7, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getMakeTime1());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getOperator1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LARepDefinationB");
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
			tError.moduleName = "LARepDefinationBDBSet";
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
