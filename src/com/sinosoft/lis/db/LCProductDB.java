/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.LCProductSchema;
import com.sinosoft.lis.vschema.LCProductSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LCProductDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCProductDB extends LCProductSchema
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
	public LCProductDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LCProduct" );
		mflag = true;
	}

	public LCProductDB()
	{
		con = null;
		db = new DBOper( "LCProduct" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LCProductSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LCProductSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
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
			pstmt = con.prepareStatement("DELETE FROM LCProduct WHERE  RiskCode = ? AND RiskProp = ?");
			if(this.getRiskCode() == null || this.getRiskCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getRiskCode());
			}
			if(this.getRiskProp() == null || this.getRiskProp().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getRiskProp());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCProduct");
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
		SQLString sqlObj = new SQLString("LCProduct");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LCProduct SET  RiskCode = ? , RiskProp = ? , RiskVer = ? , RiskName = ? , SubRiskFlag = ? , KindCode = ? , StartDate = ? , EndDate = ? , RiskType = ? , RiskType1 = ? , RiskType2 = ? , RiskType3 = ? , RiskType4 = ? , RiskType5 = ? , RiskPeriod = ? , RiskFlagDetail = ? , RiskFlag = ? , PolType = ? , InvestFlag = ? , BonusFlag = ? , BonusMode = ? , ListFlag = ? , CalDigital = ? , CalChomode = ? , RiskAmntmult = ? , InsuperiodFlag = ? , MaxEndPeriod = ? , AgeLmt = ? , SignDateCalMode = ? , ProtocolFlag = ? , GetChgFlag = ? , ProtocolPayFlag = ? , EnSuplanFlag = ? , EnSuplanAdjFlag = ? , AppInterest = ? , AppPremrate = ? , InSuredFlag = ? , ShareFlag = ? , BnfFlag = ? , TempPayFlag = ? , InpPayPlan = ? , ImpartFlag = ? , InsuexpeFlag = ? , LoanFlag = ? , MortagageFlag = ? , IdifreturnFlag = ? , CutamntstopPay = ? , RinsRate = ? , SaleFlag = ? , FileAppFlag = ? , MngCom = ? , AutoPayFlag = ? , NeedPrintHospital = ? , NeedPrintGet = ? , NotPrintPol = ? , NeedGetPolDate = ? , NeedRereadBank = ? , SpecFlag = ? , InterestDifFlag = ? , MinappntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? WHERE  RiskCode = ? AND RiskProp = ?");
			if(this.getRiskCode() == null || this.getRiskCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getRiskCode());
			}
			if(this.getRiskProp() == null || this.getRiskProp().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getRiskProp());
			}
			if(this.getRiskVer() == null || this.getRiskVer().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getRiskVer());
			}
			if(this.getRiskName() == null || this.getRiskName().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getRiskName());
			}
			if(this.getSubRiskFlag() == null || this.getSubRiskFlag().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getSubRiskFlag());
			}
			if(this.getKindCode() == null || this.getKindCode().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getKindCode());
			}
			if(this.getStartDate() == null || this.getStartDate().equals("null")) {
				pstmt.setNull(7, 91);
			} else {
				pstmt.setDate(7, Date.valueOf(this.getStartDate()));
			}
			if(this.getEndDate() == null || this.getEndDate().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getEndDate()));
			}
			if(this.getRiskType() == null || this.getRiskType().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getRiskType());
			}
			if(this.getRiskType1() == null || this.getRiskType1().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getRiskType1());
			}
			if(this.getRiskType2() == null || this.getRiskType2().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getRiskType2());
			}
			if(this.getRiskType3() == null || this.getRiskType3().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getRiskType3());
			}
			if(this.getRiskType4() == null || this.getRiskType4().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getRiskType4());
			}
			if(this.getRiskType5() == null || this.getRiskType5().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getRiskType5());
			}
			if(this.getRiskPeriod() == null || this.getRiskPeriod().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getRiskPeriod());
			}
			if(this.getRiskFlagDetail() == null || this.getRiskFlagDetail().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getRiskFlagDetail());
			}
			if(this.getRiskFlag() == null || this.getRiskFlag().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getRiskFlag());
			}
			if(this.getPolType() == null || this.getPolType().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getPolType());
			}
			if(this.getInvestFlag() == null || this.getInvestFlag().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getInvestFlag());
			}
			if(this.getBonusFlag() == null || this.getBonusFlag().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getBonusFlag());
			}
			if(this.getBonusMode() == null || this.getBonusMode().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getBonusMode());
			}
			if(this.getListFlag() == null || this.getListFlag().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getListFlag());
			}
			pstmt.setInt(23, this.getCalDigital());
			if(this.getCalChomode() == null || this.getCalChomode().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getCalChomode());
			}
			pstmt.setInt(25, this.getRiskAmntmult());
			if(this.getInsuperiodFlag() == null || this.getInsuperiodFlag().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getInsuperiodFlag());
			}
			pstmt.setInt(27, this.getMaxEndPeriod());
			pstmt.setInt(28, this.getAgeLmt());
			pstmt.setInt(29, this.getSignDateCalMode());
			if(this.getProtocolFlag() == null || this.getProtocolFlag().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getProtocolFlag());
			}
			if(this.getGetChgFlag() == null || this.getGetChgFlag().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getGetChgFlag());
			}
			if(this.getProtocolPayFlag() == null || this.getProtocolPayFlag().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getProtocolPayFlag());
			}
			if(this.getEnSuplanFlag() == null || this.getEnSuplanFlag().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getEnSuplanFlag());
			}
			if(this.getEnSuplanAdjFlag() == null || this.getEnSuplanAdjFlag().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getEnSuplanAdjFlag());
			}
			pstmt.setDouble(35, this.getAppInterest());
			pstmt.setDouble(36, this.getAppPremrate());
			if(this.getInSuredFlag() == null || this.getInSuredFlag().equals("null")) {
				pstmt.setNull(37, 12);
			} else {
				pstmt.setString(37, this.getInSuredFlag());
			}
			if(this.getShareFlag() == null || this.getShareFlag().equals("null")) {
				pstmt.setNull(38, 12);
			} else {
				pstmt.setString(38, this.getShareFlag());
			}
			if(this.getBnfFlag() == null || this.getBnfFlag().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getBnfFlag());
			}
			if(this.getTempPayFlag() == null || this.getTempPayFlag().equals("null")) {
				pstmt.setNull(40, 12);
			} else {
				pstmt.setString(40, this.getTempPayFlag());
			}
			if(this.getInpPayPlan() == null || this.getInpPayPlan().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getInpPayPlan());
			}
			if(this.getImpartFlag() == null || this.getImpartFlag().equals("null")) {
				pstmt.setNull(42, 12);
			} else {
				pstmt.setString(42, this.getImpartFlag());
			}
			if(this.getInsuexpeFlag() == null || this.getInsuexpeFlag().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getInsuexpeFlag());
			}
			if(this.getLoanFlag() == null || this.getLoanFlag().equals("null")) {
				pstmt.setNull(44, 12);
			} else {
				pstmt.setString(44, this.getLoanFlag());
			}
			if(this.getMortagageFlag() == null || this.getMortagageFlag().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getMortagageFlag());
			}
			if(this.getIdifreturnFlag() == null || this.getIdifreturnFlag().equals("null")) {
				pstmt.setNull(46, 12);
			} else {
				pstmt.setString(46, this.getIdifreturnFlag());
			}
			if(this.getCutamntstopPay() == null || this.getCutamntstopPay().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getCutamntstopPay());
			}
			pstmt.setDouble(48, this.getRinsRate());
			if(this.getSaleFlag() == null || this.getSaleFlag().equals("null")) {
				pstmt.setNull(49, 12);
			} else {
				pstmt.setString(49, this.getSaleFlag());
			}
			if(this.getFileAppFlag() == null || this.getFileAppFlag().equals("null")) {
				pstmt.setNull(50, 12);
			} else {
				pstmt.setString(50, this.getFileAppFlag());
			}
			if(this.getMngCom() == null || this.getMngCom().equals("null")) {
				pstmt.setNull(51, 12);
			} else {
				pstmt.setString(51, this.getMngCom());
			}
			if(this.getAutoPayFlag() == null || this.getAutoPayFlag().equals("null")) {
				pstmt.setNull(52, 12);
			} else {
				pstmt.setString(52, this.getAutoPayFlag());
			}
			if(this.getNeedPrintHospital() == null || this.getNeedPrintHospital().equals("null")) {
				pstmt.setNull(53, 12);
			} else {
				pstmt.setString(53, this.getNeedPrintHospital());
			}
			if(this.getNeedPrintGet() == null || this.getNeedPrintGet().equals("null")) {
				pstmt.setNull(54, 12);
			} else {
				pstmt.setString(54, this.getNeedPrintGet());
			}
			if(this.getNotPrintPol() == null || this.getNotPrintPol().equals("null")) {
				pstmt.setNull(55, 12);
			} else {
				pstmt.setString(55, this.getNotPrintPol());
			}
			if(this.getNeedGetPolDate() == null || this.getNeedGetPolDate().equals("null")) {
				pstmt.setNull(56, 12);
			} else {
				pstmt.setString(56, this.getNeedGetPolDate());
			}
			if(this.getNeedRereadBank() == null || this.getNeedRereadBank().equals("null")) {
				pstmt.setNull(57, 12);
			} else {
				pstmt.setString(57, this.getNeedRereadBank());
			}
			if(this.getSpecFlag() == null || this.getSpecFlag().equals("null")) {
				pstmt.setNull(58, 12);
			} else {
				pstmt.setString(58, this.getSpecFlag());
			}
			if(this.getInterestDifFlag() == null || this.getInterestDifFlag().equals("null")) {
				pstmt.setNull(59, 12);
			} else {
				pstmt.setString(59, this.getInterestDifFlag());
			}
			pstmt.setInt(60, this.getMinappntAge());
			pstmt.setInt(61, this.getMaxAppntAge());
			pstmt.setInt(62, this.getMaxInsuredAge());
			pstmt.setInt(63, this.getMinInsuredAge());
			// set where condition
			if(this.getRiskCode() == null || this.getRiskCode().equals("null")) {
				pstmt.setNull(64, 12);
			} else {
				pstmt.setString(64, this.getRiskCode());
			}
			if(this.getRiskProp() == null || this.getRiskProp().equals("null")) {
				pstmt.setNull(65, 12);
			} else {
				pstmt.setString(65, this.getRiskProp());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
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
		SQLString sqlObj = new SQLString("LCProduct");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LCProduct VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getRiskCode() == null || this.getRiskCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getRiskCode());
			}
			if(this.getRiskProp() == null || this.getRiskProp().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getRiskProp());
			}
			if(this.getRiskVer() == null || this.getRiskVer().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getRiskVer());
			}
			if(this.getRiskName() == null || this.getRiskName().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getRiskName());
			}
			if(this.getSubRiskFlag() == null || this.getSubRiskFlag().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getSubRiskFlag());
			}
			if(this.getKindCode() == null || this.getKindCode().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getKindCode());
			}
			if(this.getStartDate() == null || this.getStartDate().equals("null")) {
				pstmt.setNull(7, 91);
			} else {
				pstmt.setDate(7, Date.valueOf(this.getStartDate()));
			}
			if(this.getEndDate() == null || this.getEndDate().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getEndDate()));
			}
			if(this.getRiskType() == null || this.getRiskType().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getRiskType());
			}
			if(this.getRiskType1() == null || this.getRiskType1().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getRiskType1());
			}
			if(this.getRiskType2() == null || this.getRiskType2().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getRiskType2());
			}
			if(this.getRiskType3() == null || this.getRiskType3().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getRiskType3());
			}
			if(this.getRiskType4() == null || this.getRiskType4().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getRiskType4());
			}
			if(this.getRiskType5() == null || this.getRiskType5().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getRiskType5());
			}
			if(this.getRiskPeriod() == null || this.getRiskPeriod().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getRiskPeriod());
			}
			if(this.getRiskFlagDetail() == null || this.getRiskFlagDetail().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getRiskFlagDetail());
			}
			if(this.getRiskFlag() == null || this.getRiskFlag().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getRiskFlag());
			}
			if(this.getPolType() == null || this.getPolType().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getPolType());
			}
			if(this.getInvestFlag() == null || this.getInvestFlag().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getInvestFlag());
			}
			if(this.getBonusFlag() == null || this.getBonusFlag().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getBonusFlag());
			}
			if(this.getBonusMode() == null || this.getBonusMode().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getBonusMode());
			}
			if(this.getListFlag() == null || this.getListFlag().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getListFlag());
			}
			pstmt.setInt(23, this.getCalDigital());
			if(this.getCalChomode() == null || this.getCalChomode().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getCalChomode());
			}
			pstmt.setInt(25, this.getRiskAmntmult());
			if(this.getInsuperiodFlag() == null || this.getInsuperiodFlag().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getInsuperiodFlag());
			}
			pstmt.setInt(27, this.getMaxEndPeriod());
			pstmt.setInt(28, this.getAgeLmt());
			pstmt.setInt(29, this.getSignDateCalMode());
			if(this.getProtocolFlag() == null || this.getProtocolFlag().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getProtocolFlag());
			}
			if(this.getGetChgFlag() == null || this.getGetChgFlag().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getGetChgFlag());
			}
			if(this.getProtocolPayFlag() == null || this.getProtocolPayFlag().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getProtocolPayFlag());
			}
			if(this.getEnSuplanFlag() == null || this.getEnSuplanFlag().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getEnSuplanFlag());
			}
			if(this.getEnSuplanAdjFlag() == null || this.getEnSuplanAdjFlag().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getEnSuplanAdjFlag());
			}
			pstmt.setDouble(35, this.getAppInterest());
			pstmt.setDouble(36, this.getAppPremrate());
			if(this.getInSuredFlag() == null || this.getInSuredFlag().equals("null")) {
				pstmt.setNull(37, 12);
			} else {
				pstmt.setString(37, this.getInSuredFlag());
			}
			if(this.getShareFlag() == null || this.getShareFlag().equals("null")) {
				pstmt.setNull(38, 12);
			} else {
				pstmt.setString(38, this.getShareFlag());
			}
			if(this.getBnfFlag() == null || this.getBnfFlag().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getBnfFlag());
			}
			if(this.getTempPayFlag() == null || this.getTempPayFlag().equals("null")) {
				pstmt.setNull(40, 12);
			} else {
				pstmt.setString(40, this.getTempPayFlag());
			}
			if(this.getInpPayPlan() == null || this.getInpPayPlan().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getInpPayPlan());
			}
			if(this.getImpartFlag() == null || this.getImpartFlag().equals("null")) {
				pstmt.setNull(42, 12);
			} else {
				pstmt.setString(42, this.getImpartFlag());
			}
			if(this.getInsuexpeFlag() == null || this.getInsuexpeFlag().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getInsuexpeFlag());
			}
			if(this.getLoanFlag() == null || this.getLoanFlag().equals("null")) {
				pstmt.setNull(44, 12);
			} else {
				pstmt.setString(44, this.getLoanFlag());
			}
			if(this.getMortagageFlag() == null || this.getMortagageFlag().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getMortagageFlag());
			}
			if(this.getIdifreturnFlag() == null || this.getIdifreturnFlag().equals("null")) {
				pstmt.setNull(46, 12);
			} else {
				pstmt.setString(46, this.getIdifreturnFlag());
			}
			if(this.getCutamntstopPay() == null || this.getCutamntstopPay().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getCutamntstopPay());
			}
			pstmt.setDouble(48, this.getRinsRate());
			if(this.getSaleFlag() == null || this.getSaleFlag().equals("null")) {
				pstmt.setNull(49, 12);
			} else {
				pstmt.setString(49, this.getSaleFlag());
			}
			if(this.getFileAppFlag() == null || this.getFileAppFlag().equals("null")) {
				pstmt.setNull(50, 12);
			} else {
				pstmt.setString(50, this.getFileAppFlag());
			}
			if(this.getMngCom() == null || this.getMngCom().equals("null")) {
				pstmt.setNull(51, 12);
			} else {
				pstmt.setString(51, this.getMngCom());
			}
			if(this.getAutoPayFlag() == null || this.getAutoPayFlag().equals("null")) {
				pstmt.setNull(52, 12);
			} else {
				pstmt.setString(52, this.getAutoPayFlag());
			}
			if(this.getNeedPrintHospital() == null || this.getNeedPrintHospital().equals("null")) {
				pstmt.setNull(53, 12);
			} else {
				pstmt.setString(53, this.getNeedPrintHospital());
			}
			if(this.getNeedPrintGet() == null || this.getNeedPrintGet().equals("null")) {
				pstmt.setNull(54, 12);
			} else {
				pstmt.setString(54, this.getNeedPrintGet());
			}
			if(this.getNotPrintPol() == null || this.getNotPrintPol().equals("null")) {
				pstmt.setNull(55, 12);
			} else {
				pstmt.setString(55, this.getNotPrintPol());
			}
			if(this.getNeedGetPolDate() == null || this.getNeedGetPolDate().equals("null")) {
				pstmt.setNull(56, 12);
			} else {
				pstmt.setString(56, this.getNeedGetPolDate());
			}
			if(this.getNeedRereadBank() == null || this.getNeedRereadBank().equals("null")) {
				pstmt.setNull(57, 12);
			} else {
				pstmt.setString(57, this.getNeedRereadBank());
			}
			if(this.getSpecFlag() == null || this.getSpecFlag().equals("null")) {
				pstmt.setNull(58, 12);
			} else {
				pstmt.setString(58, this.getSpecFlag());
			}
			if(this.getInterestDifFlag() == null || this.getInterestDifFlag().equals("null")) {
				pstmt.setNull(59, 12);
			} else {
				pstmt.setString(59, this.getInterestDifFlag());
			}
			pstmt.setInt(60, this.getMinappntAge());
			pstmt.setInt(61, this.getMaxAppntAge());
			pstmt.setInt(62, this.getMaxInsuredAge());
			pstmt.setInt(63, this.getMinInsuredAge());
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
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
			pstmt = con.prepareStatement("SELECT * FROM LCProduct WHERE  RiskCode = ? AND RiskProp = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getRiskCode() == null || this.getRiskCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getRiskCode());
			}
			if(this.getRiskProp() == null || this.getRiskProp().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getRiskProp());
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
					tError.moduleName = "LCProductDB";
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
			tError.moduleName = "LCProductDB";
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

	public LCProductSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LCProductSet aLCProductSet = new LCProductSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 LCProductSchema aSchemaNew = this.getSchema();
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
			 	throw new IllegalArgumentException("Table LCProduct is querying for all data!");
			 }
			 mSql.append("select * from LCProduct ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LCProductSchema s1 = new LCProductSchema();
				s1.setSchema(rs,i);
				aLCProductSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
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

		return aLCProductSet;
	}

	public LCProductSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LCProductSet aLCProductSet = new LCProductSet();

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
				LCProductSchema s1 = new LCProductSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LCProductDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLCProductSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
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

		return aLCProductSet;
	}

	public LCProductSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LCProductSet aLCProductSet = new LCProductSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("LCProduct");
			LCProductSchema aSchema = this.getSchema();
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

				LCProductSchema s1 = new LCProductSchema();
				s1.setSchema(rs,i);
				aLCProductSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
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

		return aLCProductSet;
	}

	public LCProductSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LCProductSet aLCProductSet = new LCProductSet();

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

				LCProductSchema s1 = new LCProductSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LCProductDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLCProductSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCProductDB";
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

		return aLCProductSet;
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
			SQLString sqlObj = new SQLString("LCProduct");
			LCProductSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LCProduct " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LCProductDB";
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
			tError.moduleName = "LCProductDB";
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
        tError.moduleName = "LCProductDB";
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
        tError.moduleName = "LCProductDB";
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
        tError.moduleName = "LCProductDB";
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
        tError.moduleName = "LCProductDB";
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
 * @return LCProductSet
 */
public LCProductSet getData()
{
    int tCount = 0;
    LCProductSet tLCProductSet = new LCProductSet();
    LCProductSchema tLCProductSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LCProductDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLCProductSchema = new LCProductSchema();
        tLCProductSchema.setSchema(mResultSet, 1);
        tLCProductSet.add(tLCProductSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLCProductSchema = new LCProductSchema();
                tLCProductSchema.setSchema(mResultSet, 1);
                tLCProductSet.add(tLCProductSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LCProductDB";
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
    return tLCProductSet;
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
            tError.moduleName = "LCProductDB";
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
        tError.moduleName = "LCProductDB";
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
            tError.moduleName = "LCProductDB";
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
        tError.moduleName = "LCProductDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
