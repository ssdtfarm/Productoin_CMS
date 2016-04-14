/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LACommisionBSchema;
import com.sinosoft.lis.vschema.LACommisionBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LACommisionBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LACommisionBDBSet extends LACommisionBSet
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
	public LACommisionBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LACommisionB");
		mflag = true;
	}

	public LACommisionBDBSet()
	{
		db = new DBOper( "LACommisionB" );
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
			tError.moduleName = "LACommisionBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LACommisionB WHERE  CommisionSN = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCommisionSN() == null || this.get(i).getCommisionSN().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCommisionSN());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getOperator1());
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

		// only for debug purpose
		SQLString sqlObj = new SQLString("LACommisionB");
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
			tError.moduleName = "LACommisionBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LACommisionB SET  CommisionSN = ? , CompanyCode = ? , MainPolNo = ? , ProductCode = ? , RiskCode = ? , CvaliDate = ? , Currency = ? , TransMoney = ? , Commision = ? , CommissionType = ? , Portion = ? , InstalmentNo = ? , PayIntv = ? , RiskMark = ? , TrxCode = ? , CalculationDate = ? , BusinessDate = ? , BatchNo = ? , BatchDate = ? , ASAReceivedDate = ? , CommisionType = ? , TopUpSign = ? , CalDate = ? , SplitRate1 = ? , Agentcode1 = ? , UMCode1 = ? , UnitCode1 = ? , DMCode1 = ? , DivisionCode1 = ? , RMCode1 = ? , RegionCode1 = ? , DRCode1 = ? , IDRCode1 = ? , RCCode1 = ? , RFCode1 = ? , AssessMonth1 = ? , WageMonth1 = ? , SplitRate2 = ? , Agentcode2 = ? , UMCode2 = ? , UnitCode2 = ? , DMCode2 = ? , DivisionCode2 = ? , RMCode2 = ? , RegionCode2 = ? , DRCode2 = ? , IDRCode2 = ? , RCCode2 = ? , RFCode2 = ? , AssessMonth2 = ? , WageMonth2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator1 = ? , MakeDate1 = ? , MakeTime1 = ? WHERE  CommisionSN = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCommisionSN() == null || this.get(i).getCommisionSN().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCommisionSN());
			}
			if(this.get(i).getCompanyCode() == null || this.get(i).getCompanyCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getCompanyCode());
			}
			if(this.get(i).getMainPolNo() == null || this.get(i).getMainPolNo().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getMainPolNo());
			}
			if(this.get(i).getProductCode() == null || this.get(i).getProductCode().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getProductCode());
			}
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRiskCode());
			}
			if(this.get(i).getCvaliDate() == null || this.get(i).getCvaliDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getCvaliDate()));
			}
			if(this.get(i).getCurrency() == null || this.get(i).getCurrency().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getCurrency());
			}
			pstmt.setDouble(8, this.get(i).getTransMoney());
			pstmt.setDouble(9, this.get(i).getCommision());
			if(this.get(i).getCommissionType() == null || this.get(i).getCommissionType().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getCommissionType());
			}
			if(this.get(i).getPortion() == null || this.get(i).getPortion().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getPortion());
			}
			pstmt.setDouble(12, this.get(i).getInstalmentNo());
			if(this.get(i).getPayIntv() == null || this.get(i).getPayIntv().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getPayIntv());
			}
			if(this.get(i).getRiskMark() == null || this.get(i).getRiskMark().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getRiskMark());
			}
			if(this.get(i).getTrxCode() == null || this.get(i).getTrxCode().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getTrxCode());
			}
			if(this.get(i).getCalculationDate() == null || this.get(i).getCalculationDate().equals("null")) {
				pstmt.setDate(16,null);
			} else {
				pstmt.setDate(16, Date.valueOf(this.get(i).getCalculationDate()));
			}
			if(this.get(i).getBusinessDate() == null || this.get(i).getBusinessDate().equals("null")) {
				pstmt.setDate(17,null);
			} else {
				pstmt.setDate(17, Date.valueOf(this.get(i).getBusinessDate()));
			}
			pstmt.setDouble(18, this.get(i).getBatchNo());
			if(this.get(i).getBatchDate() == null || this.get(i).getBatchDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getBatchDate()));
			}
			if(this.get(i).getASAReceivedDate() == null || this.get(i).getASAReceivedDate().equals("null")) {
				pstmt.setDate(20,null);
			} else {
				pstmt.setDate(20, Date.valueOf(this.get(i).getASAReceivedDate()));
			}
			if(this.get(i).getCommisionType() == null || this.get(i).getCommisionType().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getCommisionType());
			}
			if(this.get(i).getTopUpSign() == null || this.get(i).getTopUpSign().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getTopUpSign());
			}
			if(this.get(i).getCalDate() == null || this.get(i).getCalDate().equals("null")) {
				pstmt.setDate(23,null);
			} else {
				pstmt.setDate(23, Date.valueOf(this.get(i).getCalDate()));
			}
			pstmt.setDouble(24, this.get(i).getSplitRate1());
			if(this.get(i).getAgentcode1() == null || this.get(i).getAgentcode1().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getAgentcode1());
			}
			if(this.get(i).getUMCode1() == null || this.get(i).getUMCode1().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getUMCode1());
			}
			if(this.get(i).getUnitCode1() == null || this.get(i).getUnitCode1().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getUnitCode1());
			}
			if(this.get(i).getDMCode1() == null || this.get(i).getDMCode1().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getDMCode1());
			}
			if(this.get(i).getDivisionCode1() == null || this.get(i).getDivisionCode1().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getDivisionCode1());
			}
			if(this.get(i).getRMCode1() == null || this.get(i).getRMCode1().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getRMCode1());
			}
			if(this.get(i).getRegionCode1() == null || this.get(i).getRegionCode1().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getRegionCode1());
			}
			if(this.get(i).getDRCode1() == null || this.get(i).getDRCode1().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getDRCode1());
			}
			if(this.get(i).getIDRCode1() == null || this.get(i).getIDRCode1().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getIDRCode1());
			}
			if(this.get(i).getRCCode1() == null || this.get(i).getRCCode1().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getRCCode1());
			}
			if(this.get(i).getRFCode1() == null || this.get(i).getRFCode1().equals("null")) {
				pstmt.setString(35,null);
			} else {
				pstmt.setString(35, this.get(i).getRFCode1());
			}
			if(this.get(i).getAssessMonth1() == null || this.get(i).getAssessMonth1().equals("null")) {
				pstmt.setString(36,null);
			} else {
				pstmt.setString(36, this.get(i).getAssessMonth1());
			}
			if(this.get(i).getWageMonth1() == null || this.get(i).getWageMonth1().equals("null")) {
				pstmt.setString(37,null);
			} else {
				pstmt.setString(37, this.get(i).getWageMonth1());
			}
			pstmt.setDouble(38, this.get(i).getSplitRate2());
			if(this.get(i).getAgentcode2() == null || this.get(i).getAgentcode2().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getAgentcode2());
			}
			if(this.get(i).getUMCode2() == null || this.get(i).getUMCode2().equals("null")) {
				pstmt.setString(40,null);
			} else {
				pstmt.setString(40, this.get(i).getUMCode2());
			}
			if(this.get(i).getUnitCode2() == null || this.get(i).getUnitCode2().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getUnitCode2());
			}
			if(this.get(i).getDMCode2() == null || this.get(i).getDMCode2().equals("null")) {
				pstmt.setString(42,null);
			} else {
				pstmt.setString(42, this.get(i).getDMCode2());
			}
			if(this.get(i).getDivisionCode2() == null || this.get(i).getDivisionCode2().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getDivisionCode2());
			}
			if(this.get(i).getRMCode2() == null || this.get(i).getRMCode2().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getRMCode2());
			}
			if(this.get(i).getRegionCode2() == null || this.get(i).getRegionCode2().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getRegionCode2());
			}
			if(this.get(i).getDRCode2() == null || this.get(i).getDRCode2().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getDRCode2());
			}
			if(this.get(i).getIDRCode2() == null || this.get(i).getIDRCode2().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getIDRCode2());
			}
			if(this.get(i).getRCCode2() == null || this.get(i).getRCCode2().equals("null")) {
				pstmt.setString(48,null);
			} else {
				pstmt.setString(48, this.get(i).getRCCode2());
			}
			if(this.get(i).getRFCode2() == null || this.get(i).getRFCode2().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getRFCode2());
			}
			if(this.get(i).getAssessMonth2() == null || this.get(i).getAssessMonth2().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getAssessMonth2());
			}
			if(this.get(i).getWageMonth2() == null || this.get(i).getWageMonth2().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getWageMonth2());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(53,null);
			} else {
				pstmt.setDate(53, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(55,null);
			} else {
				pstmt.setDate(55, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(58,null);
			} else {
				pstmt.setDate(58, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getMakeTime1());
			}
			// set where condition
			if(this.get(i).getCommisionSN() == null || this.get(i).getCommisionSN().equals("null")) {
				pstmt.setString(60,null);
			} else {
				pstmt.setString(60, this.get(i).getCommisionSN());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(61,null);
			} else {
				pstmt.setString(61, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(62,null);
			} else {
				pstmt.setDate(62, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(63,null);
			} else {
				pstmt.setString(63, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LACommisionB");
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
			tError.moduleName = "LACommisionBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LACommisionB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCommisionSN() == null || this.get(i).getCommisionSN().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCommisionSN());
			}
			if(this.get(i).getCompanyCode() == null || this.get(i).getCompanyCode().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getCompanyCode());
			}
			if(this.get(i).getMainPolNo() == null || this.get(i).getMainPolNo().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getMainPolNo());
			}
			if(this.get(i).getProductCode() == null || this.get(i).getProductCode().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getProductCode());
			}
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getRiskCode());
			}
			if(this.get(i).getCvaliDate() == null || this.get(i).getCvaliDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getCvaliDate()));
			}
			if(this.get(i).getCurrency() == null || this.get(i).getCurrency().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getCurrency());
			}
			pstmt.setDouble(8, this.get(i).getTransMoney());
			pstmt.setDouble(9, this.get(i).getCommision());
			if(this.get(i).getCommissionType() == null || this.get(i).getCommissionType().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getCommissionType());
			}
			if(this.get(i).getPortion() == null || this.get(i).getPortion().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getPortion());
			}
			pstmt.setDouble(12, this.get(i).getInstalmentNo());
			if(this.get(i).getPayIntv() == null || this.get(i).getPayIntv().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getPayIntv());
			}
			if(this.get(i).getRiskMark() == null || this.get(i).getRiskMark().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getRiskMark());
			}
			if(this.get(i).getTrxCode() == null || this.get(i).getTrxCode().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getTrxCode());
			}
			if(this.get(i).getCalculationDate() == null || this.get(i).getCalculationDate().equals("null")) {
				pstmt.setDate(16,null);
			} else {
				pstmt.setDate(16, Date.valueOf(this.get(i).getCalculationDate()));
			}
			if(this.get(i).getBusinessDate() == null || this.get(i).getBusinessDate().equals("null")) {
				pstmt.setDate(17,null);
			} else {
				pstmt.setDate(17, Date.valueOf(this.get(i).getBusinessDate()));
			}
			pstmt.setDouble(18, this.get(i).getBatchNo());
			if(this.get(i).getBatchDate() == null || this.get(i).getBatchDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getBatchDate()));
			}
			if(this.get(i).getASAReceivedDate() == null || this.get(i).getASAReceivedDate().equals("null")) {
				pstmt.setDate(20,null);
			} else {
				pstmt.setDate(20, Date.valueOf(this.get(i).getASAReceivedDate()));
			}
			if(this.get(i).getCommisionType() == null || this.get(i).getCommisionType().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getCommisionType());
			}
			if(this.get(i).getTopUpSign() == null || this.get(i).getTopUpSign().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getTopUpSign());
			}
			if(this.get(i).getCalDate() == null || this.get(i).getCalDate().equals("null")) {
				pstmt.setDate(23,null);
			} else {
				pstmt.setDate(23, Date.valueOf(this.get(i).getCalDate()));
			}
			pstmt.setDouble(24, this.get(i).getSplitRate1());
			if(this.get(i).getAgentcode1() == null || this.get(i).getAgentcode1().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getAgentcode1());
			}
			if(this.get(i).getUMCode1() == null || this.get(i).getUMCode1().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getUMCode1());
			}
			if(this.get(i).getUnitCode1() == null || this.get(i).getUnitCode1().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getUnitCode1());
			}
			if(this.get(i).getDMCode1() == null || this.get(i).getDMCode1().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getDMCode1());
			}
			if(this.get(i).getDivisionCode1() == null || this.get(i).getDivisionCode1().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getDivisionCode1());
			}
			if(this.get(i).getRMCode1() == null || this.get(i).getRMCode1().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getRMCode1());
			}
			if(this.get(i).getRegionCode1() == null || this.get(i).getRegionCode1().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getRegionCode1());
			}
			if(this.get(i).getDRCode1() == null || this.get(i).getDRCode1().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getDRCode1());
			}
			if(this.get(i).getIDRCode1() == null || this.get(i).getIDRCode1().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getIDRCode1());
			}
			if(this.get(i).getRCCode1() == null || this.get(i).getRCCode1().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getRCCode1());
			}
			if(this.get(i).getRFCode1() == null || this.get(i).getRFCode1().equals("null")) {
				pstmt.setString(35,null);
			} else {
				pstmt.setString(35, this.get(i).getRFCode1());
			}
			if(this.get(i).getAssessMonth1() == null || this.get(i).getAssessMonth1().equals("null")) {
				pstmt.setString(36,null);
			} else {
				pstmt.setString(36, this.get(i).getAssessMonth1());
			}
			if(this.get(i).getWageMonth1() == null || this.get(i).getWageMonth1().equals("null")) {
				pstmt.setString(37,null);
			} else {
				pstmt.setString(37, this.get(i).getWageMonth1());
			}
			pstmt.setDouble(38, this.get(i).getSplitRate2());
			if(this.get(i).getAgentcode2() == null || this.get(i).getAgentcode2().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getAgentcode2());
			}
			if(this.get(i).getUMCode2() == null || this.get(i).getUMCode2().equals("null")) {
				pstmt.setString(40,null);
			} else {
				pstmt.setString(40, this.get(i).getUMCode2());
			}
			if(this.get(i).getUnitCode2() == null || this.get(i).getUnitCode2().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getUnitCode2());
			}
			if(this.get(i).getDMCode2() == null || this.get(i).getDMCode2().equals("null")) {
				pstmt.setString(42,null);
			} else {
				pstmt.setString(42, this.get(i).getDMCode2());
			}
			if(this.get(i).getDivisionCode2() == null || this.get(i).getDivisionCode2().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getDivisionCode2());
			}
			if(this.get(i).getRMCode2() == null || this.get(i).getRMCode2().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getRMCode2());
			}
			if(this.get(i).getRegionCode2() == null || this.get(i).getRegionCode2().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getRegionCode2());
			}
			if(this.get(i).getDRCode2() == null || this.get(i).getDRCode2().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getDRCode2());
			}
			if(this.get(i).getIDRCode2() == null || this.get(i).getIDRCode2().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getIDRCode2());
			}
			if(this.get(i).getRCCode2() == null || this.get(i).getRCCode2().equals("null")) {
				pstmt.setString(48,null);
			} else {
				pstmt.setString(48, this.get(i).getRCCode2());
			}
			if(this.get(i).getRFCode2() == null || this.get(i).getRFCode2().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getRFCode2());
			}
			if(this.get(i).getAssessMonth2() == null || this.get(i).getAssessMonth2().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getAssessMonth2());
			}
			if(this.get(i).getWageMonth2() == null || this.get(i).getWageMonth2().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getWageMonth2());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(53,null);
			} else {
				pstmt.setDate(53, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(55,null);
			} else {
				pstmt.setDate(55, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(58,null);
			} else {
				pstmt.setDate(58, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LACommisionB");
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
			tError.moduleName = "LACommisionBDBSet";
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
