/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LAAgentFPUnApprovalSchema;
import com.sinosoft.lis.vschema.LAAgentFPUnApprovalSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAAgentFPUnApprovalDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LAAgentFP_Setting
 */
public class LAAgentFPUnApprovalDBSet extends LAAgentFPUnApprovalSet
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
	public LAAgentFPUnApprovalDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LAAgentFPUnApproval");
		mflag = true;
	}

	public LAAgentFPUnApprovalDBSet()
	{
		db = new DBOper( "LAAgentFPUnApproval" );
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
			tError.moduleName = "LAAgentFPUnApprovalDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAAgentFPUnApproval WHERE  AgentCode = ? AND FinanceStartMonth = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getFinanceStartMonth() == null || this.get(i).getFinanceStartMonth().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getFinanceStartMonth());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAgentFPUnApproval");
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
			tError.moduleName = "LAAgentFPUnApprovalDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAAgentFPUnApproval SET  AgentCode = ? , PlanType = ? , FinancePackage = ? , FinanceStartMonth = ? , MonthlyInstallment = ? , FinanceEndMonth = ? , FPAI = ? , CBPaidMonth = ? , CBInstallmentMonth = ? , ChallengeBonusAmount = ? , AchieveRewardRate = ? , AchieveRewardAmount = ? , MegaFixedBonusReq = ? , MegaFixedBonus = ? , MegaExtraBonusReq = ? , MegaExtraBonusRate = ? , MegaAwardReq = ? , MegaAward = ? , ApprovalDate = ? , ApprovalTime = ? , ApprovalOperator = ? , ApprovalReason = ? , ApprovalFlag = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  AgentCode = ? AND FinanceStartMonth = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getPlanType() == null || this.get(i).getPlanType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPlanType());
			}
			if(this.get(i).getFinancePackage() == null || this.get(i).getFinancePackage().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getFinancePackage());
			}
			if(this.get(i).getFinanceStartMonth() == null || this.get(i).getFinanceStartMonth().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getFinanceStartMonth());
			}
			pstmt.setInt(5, this.get(i).getMonthlyInstallment());
			if(this.get(i).getFinanceEndMonth() == null || this.get(i).getFinanceEndMonth().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getFinanceEndMonth());
			}
			pstmt.setDouble(7, this.get(i).getFPAI());
			if(this.get(i).getCBPaidMonth() == null || this.get(i).getCBPaidMonth().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getCBPaidMonth());
			}
			pstmt.setInt(9, this.get(i).getCBInstallmentMonth());
			pstmt.setDouble(10, this.get(i).getChallengeBonusAmount());
			pstmt.setDouble(11, this.get(i).getAchieveRewardRate());
			pstmt.setDouble(12, this.get(i).getAchieveRewardAmount());
			pstmt.setDouble(13, this.get(i).getMegaFixedBonusReq());
			pstmt.setDouble(14, this.get(i).getMegaFixedBonus());
			pstmt.setDouble(15, this.get(i).getMegaExtraBonusReq());
			pstmt.setDouble(16, this.get(i).getMegaExtraBonusRate());
			pstmt.setDouble(17, this.get(i).getMegaAwardReq());
			pstmt.setDouble(18, this.get(i).getMegaAward());
			if(this.get(i).getApprovalDate() == null || this.get(i).getApprovalDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getApprovalDate()));
			}
			if(this.get(i).getApprovalTime() == null || this.get(i).getApprovalTime().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getApprovalTime());
			}
			if(this.get(i).getApprovalOperator() == null || this.get(i).getApprovalOperator().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getApprovalOperator());
			}
			if(this.get(i).getApprovalReason() == null || this.get(i).getApprovalReason().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getApprovalReason());
			}
			if(this.get(i).getApprovalFlag() == null || this.get(i).getApprovalFlag().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getApprovalFlag());
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
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getAgentCode());
			}
			if(this.get(i).getFinanceStartMonth() == null || this.get(i).getFinanceStartMonth().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getFinanceStartMonth());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAgentFPUnApproval");
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
			tError.moduleName = "LAAgentFPUnApprovalDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAAgentFPUnApproval VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getPlanType() == null || this.get(i).getPlanType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPlanType());
			}
			if(this.get(i).getFinancePackage() == null || this.get(i).getFinancePackage().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getFinancePackage());
			}
			if(this.get(i).getFinanceStartMonth() == null || this.get(i).getFinanceStartMonth().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getFinanceStartMonth());
			}
			pstmt.setInt(5, this.get(i).getMonthlyInstallment());
			if(this.get(i).getFinanceEndMonth() == null || this.get(i).getFinanceEndMonth().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getFinanceEndMonth());
			}
			pstmt.setDouble(7, this.get(i).getFPAI());
			if(this.get(i).getCBPaidMonth() == null || this.get(i).getCBPaidMonth().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getCBPaidMonth());
			}
			pstmt.setInt(9, this.get(i).getCBInstallmentMonth());
			pstmt.setDouble(10, this.get(i).getChallengeBonusAmount());
			pstmt.setDouble(11, this.get(i).getAchieveRewardRate());
			pstmt.setDouble(12, this.get(i).getAchieveRewardAmount());
			pstmt.setDouble(13, this.get(i).getMegaFixedBonusReq());
			pstmt.setDouble(14, this.get(i).getMegaFixedBonus());
			pstmt.setDouble(15, this.get(i).getMegaExtraBonusReq());
			pstmt.setDouble(16, this.get(i).getMegaExtraBonusRate());
			pstmt.setDouble(17, this.get(i).getMegaAwardReq());
			pstmt.setDouble(18, this.get(i).getMegaAward());
			if(this.get(i).getApprovalDate() == null || this.get(i).getApprovalDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getApprovalDate()));
			}
			if(this.get(i).getApprovalTime() == null || this.get(i).getApprovalTime().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getApprovalTime());
			}
			if(this.get(i).getApprovalOperator() == null || this.get(i).getApprovalOperator().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getApprovalOperator());
			}
			if(this.get(i).getApprovalReason() == null || this.get(i).getApprovalReason().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getApprovalReason());
			}
			if(this.get(i).getApprovalFlag() == null || this.get(i).getApprovalFlag().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getApprovalFlag());
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
		SQLString sqlObj = new SQLString("LAAgentFPUnApproval");
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
			tError.moduleName = "LAAgentFPUnApprovalDBSet";
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
