/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.LAAFYCSchema;
import com.sinosoft.lis.vschema.LAAFYCSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAAFYCDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAFYCDB extends LAAFYCSchema
{
	// @Field
	private Connection con;
	private DBOper db;
	/**
	* flag = true: 传入Connection
	* flag = false: 不传入Connection
	**/
	private boolean mflag = false;

	public CErrors mErrors = new CErrors();		// 错误信息

	/**
	 * 为批量操作而准备的语句和游标对象
	 */
	private ResultSet mResultSet = null;
	private Statement mStatement = null;
	// @Constructor
	public LAAFYCDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LAAFYC" );
		mflag = true;
	}

	public LAAFYCDB()
	{
		con = null;
		db = new DBOper( "LAAFYC" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LAAFYCSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LAAFYCSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);

			return -1;
		}

		return tCount;
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
			pstmt = con.prepareStatement("DELETE FROM LAAFYC WHERE  AFYCSN = ?");
			if(this.getAFYCSN() == null || this.getAFYCSN().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAFYCSN());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAFYC");
		sqlObj.setSQL(4, this);
		sqlObj.getSQL();

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAFYC");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LAAFYC SET  AFYCSN = ? , CompanyCode = ? , MainPolNo = ? , ProductCode = ? , RiskCode = ? , CvaliDate = ? , AFYC = ? , AFYP = ? , TrxCode = ? , CalculationDate = ? , BusinessDate = ? , BatchNo = ? , BatchDate = ? , CalDate = ? , SplitRate1 = ? , Agentcode1 = ? , UMCode1 = ? , UnitCode1 = ? , DMCode1 = ? , DivisionCode1 = ? , RMCode1 = ? , RegionCode1 = ? , DRCode1 = ? , IDRCode1 = ? , RCCode1 = ? , RFCode1 = ? , AssessMonth1 = ? , WageMonth1 = ? , SplitRate2 = ? , Agentcode2 = ? , UMCode2 = ? , UnitCode2 = ? , DMCode2 = ? , DivisionCode2 = ? , RMCode2 = ? , RegionCode2 = ? , DRCode2 = ? , IDRCode2 = ? , RCCode2 = ? , RFCode2 = ? , AssessMonth2 = ? , WageMonth2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  AFYCSN = ?");
			if(this.getAFYCSN() == null || this.getAFYCSN().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAFYCSN());
			}
			if(this.getCompanyCode() == null || this.getCompanyCode().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getCompanyCode());
			}
			if(this.getMainPolNo() == null || this.getMainPolNo().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getMainPolNo());
			}
			if(this.getProductCode() == null || this.getProductCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getProductCode());
			}
			if(this.getRiskCode() == null || this.getRiskCode().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getRiskCode());
			}
			if(this.getCvaliDate() == null || this.getCvaliDate().equals("null")) {
				pstmt.setNull(6, 91);
			} else {
				pstmt.setDate(6, Date.valueOf(this.getCvaliDate()));
			}
			pstmt.setDouble(7, this.getAFYC());
			pstmt.setDouble(8, this.getAFYP());
			if(this.getTrxCode() == null || this.getTrxCode().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getTrxCode());
			}
			if(this.getCalculationDate() == null || this.getCalculationDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getCalculationDate()));
			}
			if(this.getBusinessDate() == null || this.getBusinessDate().equals("null")) {
				pstmt.setNull(11, 91);
			} else {
				pstmt.setDate(11, Date.valueOf(this.getBusinessDate()));
			}
			pstmt.setDouble(12, this.getBatchNo());
			if(this.getBatchDate() == null || this.getBatchDate().equals("null")) {
				pstmt.setNull(13, 91);
			} else {
				pstmt.setDate(13, Date.valueOf(this.getBatchDate()));
			}
			if(this.getCalDate() == null || this.getCalDate().equals("null")) {
				pstmt.setNull(14, 91);
			} else {
				pstmt.setDate(14, Date.valueOf(this.getCalDate()));
			}
			pstmt.setDouble(15, this.getSplitRate1());
			if(this.getAgentcode1() == null || this.getAgentcode1().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getAgentcode1());
			}
			if(this.getUMCode1() == null || this.getUMCode1().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getUMCode1());
			}
			if(this.getUnitCode1() == null || this.getUnitCode1().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getUnitCode1());
			}
			if(this.getDMCode1() == null || this.getDMCode1().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getDMCode1());
			}
			if(this.getDivisionCode1() == null || this.getDivisionCode1().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getDivisionCode1());
			}
			if(this.getRMCode1() == null || this.getRMCode1().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getRMCode1());
			}
			if(this.getRegionCode1() == null || this.getRegionCode1().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getRegionCode1());
			}
			if(this.getDRCode1() == null || this.getDRCode1().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getDRCode1());
			}
			if(this.getIDRCode1() == null || this.getIDRCode1().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getIDRCode1());
			}
			if(this.getRCCode1() == null || this.getRCCode1().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getRCCode1());
			}
			if(this.getRFCode1() == null || this.getRFCode1().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getRFCode1());
			}
			if(this.getAssessMonth1() == null || this.getAssessMonth1().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getAssessMonth1());
			}
			if(this.getWageMonth1() == null || this.getWageMonth1().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getWageMonth1());
			}
			pstmt.setDouble(29, this.getSplitRate2());
			if(this.getAgentcode2() == null || this.getAgentcode2().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getAgentcode2());
			}
			if(this.getUMCode2() == null || this.getUMCode2().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getUMCode2());
			}
			if(this.getUnitCode2() == null || this.getUnitCode2().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getUnitCode2());
			}
			if(this.getDMCode2() == null || this.getDMCode2().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getDMCode2());
			}
			if(this.getDivisionCode2() == null || this.getDivisionCode2().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getDivisionCode2());
			}
			if(this.getRMCode2() == null || this.getRMCode2().equals("null")) {
				pstmt.setNull(35, 12);
			} else {
				pstmt.setString(35, this.getRMCode2());
			}
			if(this.getRegionCode2() == null || this.getRegionCode2().equals("null")) {
				pstmt.setNull(36, 12);
			} else {
				pstmt.setString(36, this.getRegionCode2());
			}
			if(this.getDRCode2() == null || this.getDRCode2().equals("null")) {
				pstmt.setNull(37, 12);
			} else {
				pstmt.setString(37, this.getDRCode2());
			}
			if(this.getIDRCode2() == null || this.getIDRCode2().equals("null")) {
				pstmt.setNull(38, 12);
			} else {
				pstmt.setString(38, this.getIDRCode2());
			}
			if(this.getRCCode2() == null || this.getRCCode2().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getRCCode2());
			}
			if(this.getRFCode2() == null || this.getRFCode2().equals("null")) {
				pstmt.setNull(40, 12);
			} else {
				pstmt.setString(40, this.getRFCode2());
			}
			if(this.getAssessMonth2() == null || this.getAssessMonth2().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getAssessMonth2());
			}
			if(this.getWageMonth2() == null || this.getWageMonth2().equals("null")) {
				pstmt.setNull(42, 12);
			} else {
				pstmt.setString(42, this.getWageMonth2());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(44, 91);
			} else {
				pstmt.setDate(44, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(46, 91);
			} else {
				pstmt.setDate(46, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getModifyTime());
			}
			// set where condition
			if(this.getAFYCSN() == null || this.getAFYCSN().equals("null")) {
				pstmt.setNull(48, 12);
			} else {
				pstmt.setString(48, this.getAFYCSN());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAFYC");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LAAFYC VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getAFYCSN() == null || this.getAFYCSN().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAFYCSN());
			}
			if(this.getCompanyCode() == null || this.getCompanyCode().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getCompanyCode());
			}
			if(this.getMainPolNo() == null || this.getMainPolNo().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getMainPolNo());
			}
			if(this.getProductCode() == null || this.getProductCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getProductCode());
			}
			if(this.getRiskCode() == null || this.getRiskCode().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getRiskCode());
			}
			if(this.getCvaliDate() == null || this.getCvaliDate().equals("null")) {
				pstmt.setNull(6, 91);
			} else {
				pstmt.setDate(6, Date.valueOf(this.getCvaliDate()));
			}
			pstmt.setDouble(7, this.getAFYC());
			pstmt.setDouble(8, this.getAFYP());
			if(this.getTrxCode() == null || this.getTrxCode().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getTrxCode());
			}
			if(this.getCalculationDate() == null || this.getCalculationDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getCalculationDate()));
			}
			if(this.getBusinessDate() == null || this.getBusinessDate().equals("null")) {
				pstmt.setNull(11, 91);
			} else {
				pstmt.setDate(11, Date.valueOf(this.getBusinessDate()));
			}
			pstmt.setDouble(12, this.getBatchNo());
			if(this.getBatchDate() == null || this.getBatchDate().equals("null")) {
				pstmt.setNull(13, 91);
			} else {
				pstmt.setDate(13, Date.valueOf(this.getBatchDate()));
			}
			if(this.getCalDate() == null || this.getCalDate().equals("null")) {
				pstmt.setNull(14, 91);
			} else {
				pstmt.setDate(14, Date.valueOf(this.getCalDate()));
			}
			pstmt.setDouble(15, this.getSplitRate1());
			if(this.getAgentcode1() == null || this.getAgentcode1().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getAgentcode1());
			}
			if(this.getUMCode1() == null || this.getUMCode1().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getUMCode1());
			}
			if(this.getUnitCode1() == null || this.getUnitCode1().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getUnitCode1());
			}
			if(this.getDMCode1() == null || this.getDMCode1().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getDMCode1());
			}
			if(this.getDivisionCode1() == null || this.getDivisionCode1().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getDivisionCode1());
			}
			if(this.getRMCode1() == null || this.getRMCode1().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getRMCode1());
			}
			if(this.getRegionCode1() == null || this.getRegionCode1().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getRegionCode1());
			}
			if(this.getDRCode1() == null || this.getDRCode1().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getDRCode1());
			}
			if(this.getIDRCode1() == null || this.getIDRCode1().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getIDRCode1());
			}
			if(this.getRCCode1() == null || this.getRCCode1().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getRCCode1());
			}
			if(this.getRFCode1() == null || this.getRFCode1().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getRFCode1());
			}
			if(this.getAssessMonth1() == null || this.getAssessMonth1().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getAssessMonth1());
			}
			if(this.getWageMonth1() == null || this.getWageMonth1().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getWageMonth1());
			}
			pstmt.setDouble(29, this.getSplitRate2());
			if(this.getAgentcode2() == null || this.getAgentcode2().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getAgentcode2());
			}
			if(this.getUMCode2() == null || this.getUMCode2().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getUMCode2());
			}
			if(this.getUnitCode2() == null || this.getUnitCode2().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getUnitCode2());
			}
			if(this.getDMCode2() == null || this.getDMCode2().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getDMCode2());
			}
			if(this.getDivisionCode2() == null || this.getDivisionCode2().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getDivisionCode2());
			}
			if(this.getRMCode2() == null || this.getRMCode2().equals("null")) {
				pstmt.setNull(35, 12);
			} else {
				pstmt.setString(35, this.getRMCode2());
			}
			if(this.getRegionCode2() == null || this.getRegionCode2().equals("null")) {
				pstmt.setNull(36, 12);
			} else {
				pstmt.setString(36, this.getRegionCode2());
			}
			if(this.getDRCode2() == null || this.getDRCode2().equals("null")) {
				pstmt.setNull(37, 12);
			} else {
				pstmt.setString(37, this.getDRCode2());
			}
			if(this.getIDRCode2() == null || this.getIDRCode2().equals("null")) {
				pstmt.setNull(38, 12);
			} else {
				pstmt.setString(38, this.getIDRCode2());
			}
			if(this.getRCCode2() == null || this.getRCCode2().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getRCCode2());
			}
			if(this.getRFCode2() == null || this.getRFCode2().equals("null")) {
				pstmt.setNull(40, 12);
			} else {
				pstmt.setString(40, this.getRFCode2());
			}
			if(this.getAssessMonth2() == null || this.getAssessMonth2().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getAssessMonth2());
			}
			if(this.getWageMonth2() == null || this.getWageMonth2().equals("null")) {
				pstmt.setNull(42, 12);
			} else {
				pstmt.setString(42, this.getWageMonth2());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(44, 91);
			} else {
				pstmt.setDate(44, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(46, 91);
			} else {
				pstmt.setDate(46, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getModifyTime());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean getInfo()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
			pstmt = con.prepareStatement("SELECT * FROM LAAFYC WHERE  AFYCSN = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getAFYCSN() == null || this.getAFYCSN().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAFYCSN());
			}
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				if (!this.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAAFYCDB";
					tError.functionName = "getInfo";
					tError.errorMessage = "取数失败!";
					this.mErrors .addOneError(tError);

					try{ rs.close(); } catch( Exception ex ) {}
					try{ pstmt.close(); } catch( Exception ex1 ) {}

					if (!mflag)
					{
						try
						{
							con.close();
						}
						catch(Exception et){}
					}
					return false;
				}
				break;
			}
			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if( i == 0 )
			{
				if (!mflag)
				{
					try
					{
						con.close();
					}
					catch(Exception et){}
				}
				return false;
			}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "getInfo";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
			return false;
	    }
	    // 断开数据库连接
		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return true;
	}

	public LAAFYCSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAAFYCSet aLAAFYCSet = new LAAFYCSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 LAAFYCSchema aSchemaNew = this.getSchema();
			 int nFieldCount = aSchemaNew.getFieldCount();
			 int j = 0;
			 String strFieldName = "";
			 StringBuffer strFieldValue = null;
			 for (int i = 0; i < nFieldCount; i++) {
			 	if(i==0){
			 		WherePart.append("where");
			 	}
			 	strFieldName = aSchemaNew.getFieldName(i);
			 	strFieldValue = new StringBuffer(100);
			 	int nFieldType = aSchemaNew.getFieldType(i);
			 	boolean bFlag = false;
			 	String[] tParams = new String[2];
			 	switch (nFieldType) {
			 	case Schema.TYPE_STRING:
			 	case Schema.TYPE_DATE:
			 		if (aSchemaNew.getV(i).equals("null")) {
			 			//为空就不准备了
			 		} else {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_DOUBLE:
			 		if (!aSchemaNew.getV(i).equals("0.0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_FLOAT:
			 		if (!aSchemaNew.getV(i).equals("0.0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_INT:
			 		if (!aSchemaNew.getV(i).equals("0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	default:
			 		bFlag = false;
			 		break;
			 	}
			 	if (bFlag) {
			 		j++;
			 		if (j != 1) {
			 			WherePart.append(" and");
			 		}
			 		WherePart.append(" ");
			 		WherePart.append(strFieldName);
			 		WherePart.append("=");
			 		WherePart.append(strFieldValue);
			 		mBV.add(tParams);
			 	}
			 }
			 if (j == 0) {
			 	WherePart.setLength(0);
			 	throw new IllegalArgumentException("Table LAAFYC is querying for all data!");
			 }
			 mSql.append("select * from LAAFYC ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LAAFYCSchema s1 = new LAAFYCSchema();
				s1.setSchema(rs,i);
				aLAAFYCSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAAFYCSet;
	}

	public LAAFYCSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAAFYCSet aLAAFYCSet = new LAAFYCSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(stmt, bv);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LAAFYCSchema s1 = new LAAFYCSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAAFYCDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAAFYCSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ stmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAAFYCSet;
	}

	public LAAFYCSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAAFYCSet aLAAFYCSet = new LAAFYCSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("LAAFYC");
			LAAFYCSchema aSchema = this.getSchema();
			sqlObj.setSQLNew(5,aSchema);
			String sql = sqlObj.getSQL();

			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			List tBV = sqlObj.getBV();
			db.setBV(pstmt, tBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;

				if( i < nStart ) {
					continue;
				}

				if( i >= nStart + nCount ) {
					break;
				}

				LAAFYCSchema s1 = new LAAFYCSchema();
				s1.setSchema(rs,i);
				aLAAFYCSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAAFYCSet;
	}

	public LAAFYCSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAAFYCSet aLAAFYCSet = new LAAFYCSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(stmt, bv);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;

				if( i < nStart ) {
					continue;
				}

				if( i >= nStart + nCount ) {
					break;
				}

				LAAFYCSchema s1 = new LAAFYCSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAAFYCDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAAFYCSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ stmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAAFYCSet;
	}

	public boolean update(String strWherePart)
	{
		Statement stmt = null;

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			SQLString sqlObj = new SQLString("LAAFYC");
			LAAFYCSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LAAFYC " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LAAFYCDB";
				tError.functionName = "update";
				tError.errorMessage = "更新数据失败!";
				this.mErrors .addOneError(tError);

				if (!mflag)
				{
					try
					{
						con.close();
					}
					catch(Exception et){}
				}
				return false;
			}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAFYCDB";
			tError.functionName = "update";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ stmt.close(); } catch( Exception ex1 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
			return false;
	    }
	    // 断开数据库连接
		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return true;
	}

/**
 * 准备数据查询条件
 * @param strSQL String
 * @return boolean
 */
public boolean prepareData(String strSQL)
{
    if (mResultSet != null)
    {
        // @@错误处理
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "prepareData";
        tError.errorMessage = "数据集非空，程序在准备数据集之后，没有关闭！";
        this.mErrors.addOneError(tError);
        return false;
    }

    if (!mflag)
    {
        con = DBConnPool.getConnection();
    }
    try
    {
        mStatement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
    }
    catch (Exception e)
    {
        // @@错误处理
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "prepareData";
        tError.errorMessage = e.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return false;
    }

    if (!mflag)
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {}
    }
    return true;
}

/**
 * 获取数据集
 * @return boolean
 */
public boolean hasMoreData()
{
    boolean flag = true;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "hasMoreData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return false;
    }
    try
    {
        flag = mResultSet.next();
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "hasMoreData";
        tError.errorMessage = ex.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
            mResultSet = null;
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
            mStatement = null;
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return false;
    }
    return flag;
}
/**
 * 获取定量数据
 * @return LAAFYCSet
 */
public LAAFYCSet getData()
{
    int tCount = 0;
    LAAFYCSet tLAAFYCSet = new LAAFYCSet();
    LAAFYCSchema tLAAFYCSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLAAFYCSchema = new LAAFYCSchema();
        tLAAFYCSchema.setSchema(mResultSet, 1);
        tLAAFYCSet.add(tLAAFYCSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLAAFYCSchema = new LAAFYCSchema();
                tLAAFYCSchema.setSchema(mResultSet, 1);
                tLAAFYCSet.add(tLAAFYCSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "getData";
        tError.errorMessage = ex.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
            mResultSet = null;
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
            mStatement = null;
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return null;
    }
    return tLAAFYCSet;
}
/**
 * 关闭数据集
 * @return boolean
 */
public boolean closeData()
{
    boolean flag = true;
    try
    {
        if (null == mResultSet)
        {
            CError tError = new CError();
            tError.moduleName = "LAAFYCDB";
            tError.functionName = "closeData";
            tError.errorMessage = "数据集已经关闭了！";
            this.mErrors.addOneError(tError);
            flag = false;
        }
        else
        {
            mResultSet.close();
            mResultSet = null;
        }
    }
    catch (Exception ex2)
    {
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex2.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    try
    {
        if (null == mStatement)
        {
            CError tError = new CError();
            tError.moduleName = "LAAFYCDB";
            tError.functionName = "closeData";
            tError.errorMessage = "语句已经关闭了！";
            this.mErrors.addOneError(tError);
            flag = false;
        }
        else
        {
            mStatement.close();
            mStatement = null;
        }
    }
    catch (Exception ex3)
    {
        CError tError = new CError();
        tError.moduleName = "LAAFYCDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
