/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LAFinanceDataCfgSchema;
import com.sinosoft.lis.vschema.LAFinanceDataCfgSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAFinanceDataCfgDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAFinanceDataCfgDBSet extends LAFinanceDataCfgSet
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
	public LAFinanceDataCfgDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LAFinanceDataCfg");
		mflag = true;
	}

	public LAFinanceDataCfgDBSet()
	{
		db = new DBOper( "LAFinanceDataCfg" );
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
			tError.moduleName = "LAFinanceDataCfgDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAFinanceDataCfg WHERE  SMonth = ? AND EMonth = ? AND ReportCode = ? AND TitleCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getSMonth() == null || this.get(i).getSMonth().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getSMonth());
			}
			if(this.get(i).getEMonth() == null || this.get(i).getEMonth().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getEMonth());
			}
			if(this.get(i).getReportCode() == null || this.get(i).getReportCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getReportCode());
			}
			if(this.get(i).getTitleCode() == null || this.get(i).getTitleCode().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getTitleCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAFinanceDataCfg");
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
			tError.moduleName = "LAFinanceDataCfgDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAFinanceDataCfg SET  SMonth = ? , EMonth = ? , ReportCode = ? , ReportName = ? , TitleCode = ? , TitleName = ? , DCFlag = ? , Description = ? , B1 = ? , B2 = ? , B3 = ? , B4 = ? , B5 = ? , B6 = ? , B7 = ? , B8 = ? , B9 = ? , B10 = ? , B11 = ? , B12 = ? , B13 = ? , B14 = ? , B15 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  SMonth = ? AND EMonth = ? AND ReportCode = ? AND TitleCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getSMonth() == null || this.get(i).getSMonth().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getSMonth());
			}
			if(this.get(i).getEMonth() == null || this.get(i).getEMonth().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getEMonth());
			}
			if(this.get(i).getReportCode() == null || this.get(i).getReportCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getReportCode());
			}
			if(this.get(i).getReportName() == null || this.get(i).getReportName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getReportName());
			}
			if(this.get(i).getTitleCode() == null || this.get(i).getTitleCode().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getTitleCode());
			}
			if(this.get(i).getTitleName() == null || this.get(i).getTitleName().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getTitleName());
			}
			if(this.get(i).getDCFlag() == null || this.get(i).getDCFlag().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getDCFlag());
			}
			if(this.get(i).getDescription() == null || this.get(i).getDescription().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getDescription());
			}
			if(this.get(i).getB1() == null || this.get(i).getB1().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getB1());
			}
			if(this.get(i).getB2() == null || this.get(i).getB2().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getB2());
			}
			if(this.get(i).getB3() == null || this.get(i).getB3().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getB3());
			}
			if(this.get(i).getB4() == null || this.get(i).getB4().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getB4());
			}
			if(this.get(i).getB5() == null || this.get(i).getB5().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getB5());
			}
			if(this.get(i).getB6() == null || this.get(i).getB6().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getB6());
			}
			if(this.get(i).getB7() == null || this.get(i).getB7().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getB7());
			}
			if(this.get(i).getB8() == null || this.get(i).getB8().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getB8());
			}
			if(this.get(i).getB9() == null || this.get(i).getB9().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getB9());
			}
			if(this.get(i).getB10() == null || this.get(i).getB10().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getB10());
			}
			if(this.get(i).getB11() == null || this.get(i).getB11().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getB11());
			}
			if(this.get(i).getB12() == null || this.get(i).getB12().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getB12());
			}
			if(this.get(i).getB13() == null || this.get(i).getB13().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getB13());
			}
			if(this.get(i).getB14() == null || this.get(i).getB14().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getB14());
			}
			if(this.get(i).getB15() == null || this.get(i).getB15().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getB15());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(25,null);
			} else {
				pstmt.setDate(25, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(27,null);
			} else {
				pstmt.setDate(27, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getModifyTime());
			}
			// set where condition
			if(this.get(i).getSMonth() == null || this.get(i).getSMonth().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getSMonth());
			}
			if(this.get(i).getEMonth() == null || this.get(i).getEMonth().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getEMonth());
			}
			if(this.get(i).getReportCode() == null || this.get(i).getReportCode().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getReportCode());
			}
			if(this.get(i).getTitleCode() == null || this.get(i).getTitleCode().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getTitleCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAFinanceDataCfg");
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
			tError.moduleName = "LAFinanceDataCfgDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAFinanceDataCfg VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getSMonth() == null || this.get(i).getSMonth().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getSMonth());
			}
			if(this.get(i).getEMonth() == null || this.get(i).getEMonth().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getEMonth());
			}
			if(this.get(i).getReportCode() == null || this.get(i).getReportCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getReportCode());
			}
			if(this.get(i).getReportName() == null || this.get(i).getReportName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getReportName());
			}
			if(this.get(i).getTitleCode() == null || this.get(i).getTitleCode().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getTitleCode());
			}
			if(this.get(i).getTitleName() == null || this.get(i).getTitleName().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getTitleName());
			}
			if(this.get(i).getDCFlag() == null || this.get(i).getDCFlag().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getDCFlag());
			}
			if(this.get(i).getDescription() == null || this.get(i).getDescription().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getDescription());
			}
			if(this.get(i).getB1() == null || this.get(i).getB1().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getB1());
			}
			if(this.get(i).getB2() == null || this.get(i).getB2().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getB2());
			}
			if(this.get(i).getB3() == null || this.get(i).getB3().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getB3());
			}
			if(this.get(i).getB4() == null || this.get(i).getB4().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getB4());
			}
			if(this.get(i).getB5() == null || this.get(i).getB5().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getB5());
			}
			if(this.get(i).getB6() == null || this.get(i).getB6().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getB6());
			}
			if(this.get(i).getB7() == null || this.get(i).getB7().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getB7());
			}
			if(this.get(i).getB8() == null || this.get(i).getB8().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getB8());
			}
			if(this.get(i).getB9() == null || this.get(i).getB9().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getB9());
			}
			if(this.get(i).getB10() == null || this.get(i).getB10().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getB10());
			}
			if(this.get(i).getB11() == null || this.get(i).getB11().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getB11());
			}
			if(this.get(i).getB12() == null || this.get(i).getB12().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getB12());
			}
			if(this.get(i).getB13() == null || this.get(i).getB13().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getB13());
			}
			if(this.get(i).getB14() == null || this.get(i).getB14().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getB14());
			}
			if(this.get(i).getB15() == null || this.get(i).getB15().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getB15());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(25,null);
			} else {
				pstmt.setDate(25, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(27,null);
			} else {
				pstmt.setDate(27, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getModifyTime());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAFinanceDataCfg");
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
			tError.moduleName = "LAFinanceDataCfgDBSet";
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
