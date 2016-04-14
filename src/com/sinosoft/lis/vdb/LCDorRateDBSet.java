/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LCDorRateSchema;
import com.sinosoft.lis.vschema.LCDorRateSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LCDorRateDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCDorRateDBSet extends LCDorRateSet
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
	public LCDorRateDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LCDorRate");
		mflag = true;
	}

	public LCDorRateDBSet()
	{
		db = new DBOper( "LCDorRate" );
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
			tError.moduleName = "LCDorRateDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LCDorRate WHERE  ProductCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getProductCode() == null || this.get(i).getProductCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getProductCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCDorRate");
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
			tError.moduleName = "LCDorRateDBSet";
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
			pstmt = con.prepareStatement("UPDATE LCDorRate SET  ProductCode = ? , DorRate = ? , EffectiveYM = ? , EffectiveEndYM = ? , DeleteFlag = ? , OperationDate = ? , OPERATOR = ? , MAKEDATE = ? , MAKETIME = ? , MODIFYDATE = ? , MODIFYTIME = ? WHERE  ProductCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getProductCode() == null || this.get(i).getProductCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getProductCode());
			}
			if(this.get(i).getDorRate() == null || this.get(i).getDorRate().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getDorRate());
			}
			if(this.get(i).getEffectiveYM() == null || this.get(i).getEffectiveYM().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getEffectiveYM());
			}
			if(this.get(i).getEffectiveEndYM() == null || this.get(i).getEffectiveEndYM().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getEffectiveEndYM());
			}
			if(this.get(i).getDeleteFlag() == null || this.get(i).getDeleteFlag().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getDeleteFlag());
			}
			if(this.get(i).getOperationDate() == null || this.get(i).getOperationDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getOperationDate()));
			}
			if(this.get(i).getOPERATOR() == null || this.get(i).getOPERATOR().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getOPERATOR());
			}
			if(this.get(i).getMAKEDATE() == null || this.get(i).getMAKEDATE().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getMAKEDATE()));
			}
			if(this.get(i).getMAKETIME() == null || this.get(i).getMAKETIME().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getMAKETIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getMODIFYTIME());
			}
			// set where condition
			if(this.get(i).getProductCode() == null || this.get(i).getProductCode().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getProductCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCDorRate");
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
			tError.moduleName = "LCDorRateDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LCDorRate VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getProductCode() == null || this.get(i).getProductCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getProductCode());
			}
			if(this.get(i).getDorRate() == null || this.get(i).getDorRate().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getDorRate());
			}
			if(this.get(i).getEffectiveYM() == null || this.get(i).getEffectiveYM().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getEffectiveYM());
			}
			if(this.get(i).getEffectiveEndYM() == null || this.get(i).getEffectiveEndYM().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getEffectiveEndYM());
			}
			if(this.get(i).getDeleteFlag() == null || this.get(i).getDeleteFlag().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getDeleteFlag());
			}
			if(this.get(i).getOperationDate() == null || this.get(i).getOperationDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getOperationDate()));
			}
			if(this.get(i).getOPERATOR() == null || this.get(i).getOPERATOR().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getOPERATOR());
			}
			if(this.get(i).getMAKEDATE() == null || this.get(i).getMAKEDATE().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getMAKEDATE()));
			}
			if(this.get(i).getMAKETIME() == null || this.get(i).getMAKETIME().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getMAKETIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getMODIFYTIME());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCDorRate");
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
			tError.moduleName = "LCDorRateDBSet";
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
