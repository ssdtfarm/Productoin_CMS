/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LALoanBSchema;
import com.sinosoft.lis.vschema.LALoanBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LALoanBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LALoanBDBSet extends LALoanBSet
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
	public LALoanBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LALoanB");
		mflag = true;
	}

	public LALoanBDBSet()
	{
		db = new DBOper( "LALoanB" );
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
			tError.moduleName = "LALoanBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LALoanB WHERE  ID = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getID() == null || this.get(i).getID().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getID());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LALoanB");
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
			tError.moduleName = "LALoanBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LALoanB SET  ID = ? , LeaderLiabilityAgentDivisionCode = ? , LeaderLiabilityLoanAgentCode = ? , LeaderLiabilityLoanAgentName = ? , LeaderLiabilityLoanAgentTitle = ? , LeaderLiabilityLoanAgentContractStatus = ? , AgentDivisionCode = ? , AgentCode = ? , AgentName = ? , AgentTitle = ? , AgentContractStatus = ? , LoanType = ? , LoanStatus = ? , LoanAmount = ? , InterestRate = ? , Installment = ? , MonthlyRepaymentAmount = ? , LoanFrom = ? , LoanTo = ? , WithheldReason = ? , Operator = ? , DeleteFlag = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ID = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getID() == null || this.get(i).getID().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getID());
			}
			if(this.get(i).getLeaderLiabilityAgentDivisionCode() == null || this.get(i).getLeaderLiabilityAgentDivisionCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getLeaderLiabilityAgentDivisionCode());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentCode() == null || this.get(i).getLeaderLiabilityLoanAgentCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getLeaderLiabilityLoanAgentCode());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentName() == null || this.get(i).getLeaderLiabilityLoanAgentName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getLeaderLiabilityLoanAgentName());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentTitle() == null || this.get(i).getLeaderLiabilityLoanAgentTitle().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getLeaderLiabilityLoanAgentTitle());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentContractStatus() == null || this.get(i).getLeaderLiabilityLoanAgentContractStatus().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getLeaderLiabilityLoanAgentContractStatus());
			}
			if(this.get(i).getAgentDivisionCode() == null || this.get(i).getAgentDivisionCode().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getAgentDivisionCode());
			}
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getAgentCode());
			}
			if(this.get(i).getAgentName() == null || this.get(i).getAgentName().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getAgentName());
			}
			if(this.get(i).getAgentTitle() == null || this.get(i).getAgentTitle().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getAgentTitle());
			}
			if(this.get(i).getAgentContractStatus() == null || this.get(i).getAgentContractStatus().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getAgentContractStatus());
			}
			if(this.get(i).getLoanType() == null || this.get(i).getLoanType().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getLoanType());
			}
			if(this.get(i).getLoanStatus() == null || this.get(i).getLoanStatus().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getLoanStatus());
			}
			if(this.get(i).getLoanAmount() == null || this.get(i).getLoanAmount().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getLoanAmount());
			}
			pstmt.setDouble(15, this.get(i).getInterestRate());
			if(this.get(i).getInstallment() == null || this.get(i).getInstallment().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getInstallment());
			}
			pstmt.setDouble(17, this.get(i).getMonthlyRepaymentAmount());
			if(this.get(i).getLoanFrom() == null || this.get(i).getLoanFrom().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getLoanFrom());
			}
			if(this.get(i).getLoanTo() == null || this.get(i).getLoanTo().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getLoanTo());
			}
			if(this.get(i).getWithheldReason() == null || this.get(i).getWithheldReason().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getWithheldReason());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getOperator());
			}
			if(this.get(i).getDeleteFlag() == null || this.get(i).getDeleteFlag().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getDeleteFlag());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(23,null);
			} else {
				pstmt.setDate(23, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(25,null);
			} else {
				pstmt.setDate(25, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getModifyTime());
			}
			// set where condition
			if(this.get(i).getID() == null || this.get(i).getID().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getID());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LALoanB");
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
			tError.moduleName = "LALoanBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LALoanB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getID() == null || this.get(i).getID().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getID());
			}
			if(this.get(i).getLeaderLiabilityAgentDivisionCode() == null || this.get(i).getLeaderLiabilityAgentDivisionCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getLeaderLiabilityAgentDivisionCode());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentCode() == null || this.get(i).getLeaderLiabilityLoanAgentCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getLeaderLiabilityLoanAgentCode());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentName() == null || this.get(i).getLeaderLiabilityLoanAgentName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getLeaderLiabilityLoanAgentName());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentTitle() == null || this.get(i).getLeaderLiabilityLoanAgentTitle().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getLeaderLiabilityLoanAgentTitle());
			}
			if(this.get(i).getLeaderLiabilityLoanAgentContractStatus() == null || this.get(i).getLeaderLiabilityLoanAgentContractStatus().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getLeaderLiabilityLoanAgentContractStatus());
			}
			if(this.get(i).getAgentDivisionCode() == null || this.get(i).getAgentDivisionCode().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getAgentDivisionCode());
			}
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getAgentCode());
			}
			if(this.get(i).getAgentName() == null || this.get(i).getAgentName().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getAgentName());
			}
			if(this.get(i).getAgentTitle() == null || this.get(i).getAgentTitle().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getAgentTitle());
			}
			if(this.get(i).getAgentContractStatus() == null || this.get(i).getAgentContractStatus().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getAgentContractStatus());
			}
			if(this.get(i).getLoanType() == null || this.get(i).getLoanType().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getLoanType());
			}
			if(this.get(i).getLoanStatus() == null || this.get(i).getLoanStatus().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getLoanStatus());
			}
			if(this.get(i).getLoanAmount() == null || this.get(i).getLoanAmount().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getLoanAmount());
			}
			pstmt.setDouble(15, this.get(i).getInterestRate());
			if(this.get(i).getInstallment() == null || this.get(i).getInstallment().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getInstallment());
			}
			pstmt.setDouble(17, this.get(i).getMonthlyRepaymentAmount());
			if(this.get(i).getLoanFrom() == null || this.get(i).getLoanFrom().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getLoanFrom());
			}
			if(this.get(i).getLoanTo() == null || this.get(i).getLoanTo().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getLoanTo());
			}
			if(this.get(i).getWithheldReason() == null || this.get(i).getWithheldReason().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getWithheldReason());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getOperator());
			}
			if(this.get(i).getDeleteFlag() == null || this.get(i).getDeleteFlag().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getDeleteFlag());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(23,null);
			} else {
				pstmt.setDate(23, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(25,null);
			} else {
				pstmt.setDate(25, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getModifyTime());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LALoanB");
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
			tError.moduleName = "LALoanBDBSet";
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
