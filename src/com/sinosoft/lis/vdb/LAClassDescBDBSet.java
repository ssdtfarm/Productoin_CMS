/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LAClassDescBSchema;
import com.sinosoft.lis.vschema.LAClassDescBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAClassDescBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAClassDescBDBSet extends LAClassDescBSet
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
	public LAClassDescBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LAClassDescB");
		mflag = true;
	}

	public LAClassDescBDBSet()
	{
		db = new DBOper( "LAClassDescB" );
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
			tError.moduleName = "LAClassDescBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAClassDescB WHERE  ClassNo = ? AND ChannelCode = ? AND MakeDate1 = ? AND MakeTime1 = ? AND Operator1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getClassNo() == null || this.get(i).getClassNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getClassNo());
			}
			if(this.get(i).getChannelCode() == null || this.get(i).getChannelCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getChannelCode());
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
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getOperator1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAClassDescB");
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
			tError.moduleName = "LAClassDescBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAClassDescB SET  ClassNo = ? , ChannelCode = ? , ClassName = ? , ReceiGrade = ? , ClassSeries = ? , StopFlag = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator = ? , MakeDate1 = ? , MakeTime1 = ? , Operator1 = ? WHERE  ClassNo = ? AND ChannelCode = ? AND MakeDate1 = ? AND MakeTime1 = ? AND Operator1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getClassNo() == null || this.get(i).getClassNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getClassNo());
			}
			if(this.get(i).getChannelCode() == null || this.get(i).getChannelCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getChannelCode());
			}
			if(this.get(i).getClassName() == null || this.get(i).getClassName().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getClassName());
			}
			if(this.get(i).getReceiGrade() == null || this.get(i).getReceiGrade().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getReceiGrade());
			}
			if(this.get(i).getClassSeries() == null || this.get(i).getClassSeries().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getClassSeries());
			}
			if(this.get(i).getStopFlag() == null || this.get(i).getStopFlag().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getStopFlag());
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
			if(this.get(i).getClassNo() == null || this.get(i).getClassNo().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getClassNo());
			}
			if(this.get(i).getChannelCode() == null || this.get(i).getChannelCode().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getChannelCode());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(17,null);
			} else {
				pstmt.setDate(17, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getMakeTime1());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getOperator1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAClassDescB");
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
			tError.moduleName = "LAClassDescBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAClassDescB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getClassNo() == null || this.get(i).getClassNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getClassNo());
			}
			if(this.get(i).getChannelCode() == null || this.get(i).getChannelCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getChannelCode());
			}
			if(this.get(i).getClassName() == null || this.get(i).getClassName().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getClassName());
			}
			if(this.get(i).getReceiGrade() == null || this.get(i).getReceiGrade().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getReceiGrade());
			}
			if(this.get(i).getClassSeries() == null || this.get(i).getClassSeries().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getClassSeries());
			}
			if(this.get(i).getStopFlag() == null || this.get(i).getStopFlag().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getStopFlag());
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
		SQLString sqlObj = new SQLString("LAClassDescB");
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
			tError.moduleName = "LAClassDescBDBSet";
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
