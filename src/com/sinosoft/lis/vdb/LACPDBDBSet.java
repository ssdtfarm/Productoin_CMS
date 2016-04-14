/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LACPDBSchema;
import com.sinosoft.lis.vschema.LACPDBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LACPDBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LACPDBDBSet extends LACPDBSet
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
	public LACPDBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LACPDB");
		mflag = true;
	}

	public LACPDBDBSet()
	{
		db = new DBOper( "LACPDB" );
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
			tError.moduleName = "LACPDBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LACPDB WHERE  AgentCode = ? AND HKCAAVQCode = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getHKCAAVQCode() == null || this.get(i).getHKCAAVQCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getHKCAAVQCode());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(4,null);
			} else {
				pstmt.setDate(4, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LACPDB");
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
			tError.moduleName = "LACPDBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LACPDB SET  AgentCode = ? , CourseName = ? , HKCAAVQCode = ? , CourseDate = ? , RegulatoryType1 = ? , RegulatoryType2 = ? , RegulatoryType3 = ? , CPDHourType1 = ? , CPDHourType2 = ? , CPDHourType3 = ? , CPDHour1 = ? , CPDHour2 = ? , CPDHour3 = ? , ReportingPeriod = ? , Remark = ? , EligibleAmounts = ? , ReimbursedAmount = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator1 = ? , MakeDate1 = ? , MakeTime1 = ? WHERE  AgentCode = ? AND HKCAAVQCode = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getCourseName() == null || this.get(i).getCourseName().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getCourseName());
			}
			if(this.get(i).getHKCAAVQCode() == null || this.get(i).getHKCAAVQCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getHKCAAVQCode());
			}
			if(this.get(i).getCourseDate() == null || this.get(i).getCourseDate().equals("null")) {
				pstmt.setDate(4,null);
			} else {
				pstmt.setDate(4, Date.valueOf(this.get(i).getCourseDate()));
			}
			if(this.get(i).getRegulatoryType1() == null || this.get(i).getRegulatoryType1().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRegulatoryType1());
			}
			if(this.get(i).getRegulatoryType2() == null || this.get(i).getRegulatoryType2().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getRegulatoryType2());
			}
			if(this.get(i).getRegulatoryType3() == null || this.get(i).getRegulatoryType3().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getRegulatoryType3());
			}
			if(this.get(i).getCPDHourType1() == null || this.get(i).getCPDHourType1().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getCPDHourType1());
			}
			if(this.get(i).getCPDHourType2() == null || this.get(i).getCPDHourType2().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getCPDHourType2());
			}
			if(this.get(i).getCPDHourType3() == null || this.get(i).getCPDHourType3().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getCPDHourType3());
			}
			if(this.get(i).getCPDHour1() == null || this.get(i).getCPDHour1().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getCPDHour1());
			}
			if(this.get(i).getCPDHour2() == null || this.get(i).getCPDHour2().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getCPDHour2());
			}
			if(this.get(i).getCPDHour3() == null || this.get(i).getCPDHour3().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getCPDHour3());
			}
			if(this.get(i).getReportingPeriod() == null || this.get(i).getReportingPeriod().equals("null")) {
				pstmt.setDate(14,null);
			} else {
				pstmt.setDate(14, Date.valueOf(this.get(i).getReportingPeriod()));
			}
			if(this.get(i).getRemark() == null || this.get(i).getRemark().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getRemark());
			}
			pstmt.setDouble(16, this.get(i).getEligibleAmounts());
			pstmt.setDouble(17, this.get(i).getReimbursedAmount());
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(21,null);
			} else {
				pstmt.setDate(21, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(24,null);
			} else {
				pstmt.setDate(24, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getMakeTime1());
			}
			// set where condition
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getAgentCode());
			}
			if(this.get(i).getHKCAAVQCode() == null || this.get(i).getHKCAAVQCode().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getHKCAAVQCode());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(29,null);
			} else {
				pstmt.setDate(29, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LACPDB");
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
			tError.moduleName = "LACPDBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LACPDB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getCourseName() == null || this.get(i).getCourseName().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getCourseName());
			}
			if(this.get(i).getHKCAAVQCode() == null || this.get(i).getHKCAAVQCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getHKCAAVQCode());
			}
			if(this.get(i).getCourseDate() == null || this.get(i).getCourseDate().equals("null")) {
				pstmt.setDate(4,null);
			} else {
				pstmt.setDate(4, Date.valueOf(this.get(i).getCourseDate()));
			}
			if(this.get(i).getRegulatoryType1() == null || this.get(i).getRegulatoryType1().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRegulatoryType1());
			}
			if(this.get(i).getRegulatoryType2() == null || this.get(i).getRegulatoryType2().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getRegulatoryType2());
			}
			if(this.get(i).getRegulatoryType3() == null || this.get(i).getRegulatoryType3().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getRegulatoryType3());
			}
			if(this.get(i).getCPDHourType1() == null || this.get(i).getCPDHourType1().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getCPDHourType1());
			}
			if(this.get(i).getCPDHourType2() == null || this.get(i).getCPDHourType2().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getCPDHourType2());
			}
			if(this.get(i).getCPDHourType3() == null || this.get(i).getCPDHourType3().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getCPDHourType3());
			}
			if(this.get(i).getCPDHour1() == null || this.get(i).getCPDHour1().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getCPDHour1());
			}
			if(this.get(i).getCPDHour2() == null || this.get(i).getCPDHour2().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getCPDHour2());
			}
			if(this.get(i).getCPDHour3() == null || this.get(i).getCPDHour3().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getCPDHour3());
			}
			if(this.get(i).getReportingPeriod() == null || this.get(i).getReportingPeriod().equals("null")) {
				pstmt.setDate(14,null);
			} else {
				pstmt.setDate(14, Date.valueOf(this.get(i).getReportingPeriod()));
			}
			if(this.get(i).getRemark() == null || this.get(i).getRemark().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getRemark());
			}
			pstmt.setDouble(16, this.get(i).getEligibleAmounts());
			pstmt.setDouble(17, this.get(i).getReimbursedAmount());
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(21,null);
			} else {
				pstmt.setDate(21, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(24,null);
			} else {
				pstmt.setDate(24, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LACPDB");
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
			tError.moduleName = "LACPDBDBSet";
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
