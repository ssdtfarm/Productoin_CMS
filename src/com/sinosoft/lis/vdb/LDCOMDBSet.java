/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LDCOMSchema;
import com.sinosoft.lis.vschema.LDCOMSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LDCOMDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LDCOMDBSet extends LDCOMSet
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
	public LDCOMDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LDCOM");
		mflag = true;
	}

	public LDCOMDBSet()
	{
		db = new DBOper( "LDCOM" );
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
			tError.moduleName = "LDCOMDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LDCOM WHERE  COMCODE = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCOMCODE() == null || this.get(i).getCOMCODE().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCOMCODE());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LDCOM");
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
			tError.moduleName = "LDCOMDBSet";
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
			pstmt = con.prepareStatement("UPDATE LDCOM SET  COMCODE = ? , NAME = ? , SHORTNAME = ? , COMGRADE = ? , UPCOMCODE = ? , CITYCODE = ? , CITYTYPE = ? , AREACODE = ? , FOUNDDATE = ? , ADDRESS = ? , ZIPCODE = ? , PHONE = ? , FAX = ? , EMAIL = ? , SIGN = ? , OPERATOR = ? , MAKEDATE = ? , MAKETIME = ? , MODIFYDATE = ? , MODIFYTIME = ? WHERE  COMCODE = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCOMCODE() == null || this.get(i).getCOMCODE().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCOMCODE());
			}
			if(this.get(i).getNAME() == null || this.get(i).getNAME().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getNAME());
			}
			if(this.get(i).getSHORTNAME() == null || this.get(i).getSHORTNAME().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getSHORTNAME());
			}
			if(this.get(i).getCOMGRADE() == null || this.get(i).getCOMGRADE().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getCOMGRADE());
			}
			if(this.get(i).getUPCOMCODE() == null || this.get(i).getUPCOMCODE().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getUPCOMCODE());
			}
			if(this.get(i).getCITYCODE() == null || this.get(i).getCITYCODE().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getCITYCODE());
			}
			if(this.get(i).getCITYTYPE() == null || this.get(i).getCITYTYPE().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getCITYTYPE());
			}
			if(this.get(i).getAREACODE() == null || this.get(i).getAREACODE().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getAREACODE());
			}
			if(this.get(i).getFOUNDDATE() == null || this.get(i).getFOUNDDATE().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getFOUNDDATE()));
			}
			if(this.get(i).getADDRESS() == null || this.get(i).getADDRESS().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getADDRESS());
			}
			if(this.get(i).getZIPCODE() == null || this.get(i).getZIPCODE().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getZIPCODE());
			}
			if(this.get(i).getPHONE() == null || this.get(i).getPHONE().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getPHONE());
			}
			if(this.get(i).getFAX() == null || this.get(i).getFAX().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getFAX());
			}
			if(this.get(i).getEMAIL() == null || this.get(i).getEMAIL().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getEMAIL());
			}
			if(this.get(i).getSIGN() == null || this.get(i).getSIGN().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getSIGN());
			}
			if(this.get(i).getOPERATOR() == null || this.get(i).getOPERATOR().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getOPERATOR());
			}
			if(this.get(i).getMAKEDATE() == null || this.get(i).getMAKEDATE().equals("null")) {
				pstmt.setDate(17,null);
			} else {
				pstmt.setDate(17, Date.valueOf(this.get(i).getMAKEDATE()));
			}
			if(this.get(i).getMAKETIME() == null || this.get(i).getMAKETIME().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getMAKETIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getMODIFYTIME());
			}
			// set where condition
			if(this.get(i).getCOMCODE() == null || this.get(i).getCOMCODE().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getCOMCODE());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LDCOM");
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
			tError.moduleName = "LDCOMDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LDCOM VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCOMCODE() == null || this.get(i).getCOMCODE().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCOMCODE());
			}
			if(this.get(i).getNAME() == null || this.get(i).getNAME().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getNAME());
			}
			if(this.get(i).getSHORTNAME() == null || this.get(i).getSHORTNAME().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getSHORTNAME());
			}
			if(this.get(i).getCOMGRADE() == null || this.get(i).getCOMGRADE().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getCOMGRADE());
			}
			if(this.get(i).getUPCOMCODE() == null || this.get(i).getUPCOMCODE().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getUPCOMCODE());
			}
			if(this.get(i).getCITYCODE() == null || this.get(i).getCITYCODE().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getCITYCODE());
			}
			if(this.get(i).getCITYTYPE() == null || this.get(i).getCITYTYPE().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getCITYTYPE());
			}
			if(this.get(i).getAREACODE() == null || this.get(i).getAREACODE().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getAREACODE());
			}
			if(this.get(i).getFOUNDDATE() == null || this.get(i).getFOUNDDATE().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getFOUNDDATE()));
			}
			if(this.get(i).getADDRESS() == null || this.get(i).getADDRESS().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getADDRESS());
			}
			if(this.get(i).getZIPCODE() == null || this.get(i).getZIPCODE().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getZIPCODE());
			}
			if(this.get(i).getPHONE() == null || this.get(i).getPHONE().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getPHONE());
			}
			if(this.get(i).getFAX() == null || this.get(i).getFAX().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getFAX());
			}
			if(this.get(i).getEMAIL() == null || this.get(i).getEMAIL().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getEMAIL());
			}
			if(this.get(i).getSIGN() == null || this.get(i).getSIGN().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getSIGN());
			}
			if(this.get(i).getOPERATOR() == null || this.get(i).getOPERATOR().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getOPERATOR());
			}
			if(this.get(i).getMAKEDATE() == null || this.get(i).getMAKEDATE().equals("null")) {
				pstmt.setDate(17,null);
			} else {
				pstmt.setDate(17, Date.valueOf(this.get(i).getMAKEDATE()));
			}
			if(this.get(i).getMAKETIME() == null || this.get(i).getMAKETIME().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getMAKETIME());
			}
			if(this.get(i).getMODIFYDATE() == null || this.get(i).getMODIFYDATE().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getMODIFYDATE()));
			}
			if(this.get(i).getMODIFYTIME() == null || this.get(i).getMODIFYTIME().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getMODIFYTIME());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LDCOM");
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
			tError.moduleName = "LDCOMDBSet";
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
