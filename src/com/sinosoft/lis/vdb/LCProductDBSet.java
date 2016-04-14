/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LCProductSchema;
import com.sinosoft.lis.vschema.LCProductSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LCProductDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCProductDBSet extends LCProductSet
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
	public LCProductDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LCProduct");
		mflag = true;
	}

	public LCProductDBSet()
	{
		db = new DBOper( "LCProduct" );
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
			tError.moduleName = "LCProductDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LCProduct WHERE  RiskCode = ? AND RiskProp = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getRiskCode());
			}
			if(this.get(i).getRiskProp() == null || this.get(i).getRiskProp().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getRiskProp());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCProduct");
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
			tError.moduleName = "LCProductDBSet";
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
			pstmt = con.prepareStatement("UPDATE LCProduct SET  RiskCode = ? , RiskProp = ? , RiskVer = ? , RiskName = ? , SubRiskFlag = ? , KindCode = ? , StartDate = ? , EndDate = ? , RiskType = ? , RiskType1 = ? , RiskType2 = ? , RiskType3 = ? , RiskType4 = ? , RiskType5 = ? , RiskPeriod = ? , RiskFlagDetail = ? , RiskFlag = ? , PolType = ? , InvestFlag = ? , BonusFlag = ? , BonusMode = ? , ListFlag = ? , CalDigital = ? , CalChomode = ? , RiskAmntmult = ? , InsuperiodFlag = ? , MaxEndPeriod = ? , AgeLmt = ? , SignDateCalMode = ? , ProtocolFlag = ? , GetChgFlag = ? , ProtocolPayFlag = ? , EnSuplanFlag = ? , EnSuplanAdjFlag = ? , AppInterest = ? , AppPremrate = ? , InSuredFlag = ? , ShareFlag = ? , BnfFlag = ? , TempPayFlag = ? , InpPayPlan = ? , ImpartFlag = ? , InsuexpeFlag = ? , LoanFlag = ? , MortagageFlag = ? , IdifreturnFlag = ? , CutamntstopPay = ? , RinsRate = ? , SaleFlag = ? , FileAppFlag = ? , MngCom = ? , AutoPayFlag = ? , NeedPrintHospital = ? , NeedPrintGet = ? , NotPrintPol = ? , NeedGetPolDate = ? , NeedRereadBank = ? , SpecFlag = ? , InterestDifFlag = ? , MinappntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? WHERE  RiskCode = ? AND RiskProp = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getRiskCode());
			}
			if(this.get(i).getRiskProp() == null || this.get(i).getRiskProp().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getRiskProp());
			}
			if(this.get(i).getRiskVer() == null || this.get(i).getRiskVer().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getRiskVer());
			}
			if(this.get(i).getRiskName() == null || this.get(i).getRiskName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getRiskName());
			}
			if(this.get(i).getSubRiskFlag() == null || this.get(i).getSubRiskFlag().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getSubRiskFlag());
			}
			if(this.get(i).getKindCode() == null || this.get(i).getKindCode().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getKindCode());
			}
			if(this.get(i).getStartDate() == null || this.get(i).getStartDate().equals("null")) {
				pstmt.setDate(7,null);
			} else {
				pstmt.setDate(7, Date.valueOf(this.get(i).getStartDate()));
			}
			if(this.get(i).getEndDate() == null || this.get(i).getEndDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getEndDate()));
			}
			if(this.get(i).getRiskType() == null || this.get(i).getRiskType().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getRiskType());
			}
			if(this.get(i).getRiskType1() == null || this.get(i).getRiskType1().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getRiskType1());
			}
			if(this.get(i).getRiskType2() == null || this.get(i).getRiskType2().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getRiskType2());
			}
			if(this.get(i).getRiskType3() == null || this.get(i).getRiskType3().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getRiskType3());
			}
			if(this.get(i).getRiskType4() == null || this.get(i).getRiskType4().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getRiskType4());
			}
			if(this.get(i).getRiskType5() == null || this.get(i).getRiskType5().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getRiskType5());
			}
			if(this.get(i).getRiskPeriod() == null || this.get(i).getRiskPeriod().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getRiskPeriod());
			}
			if(this.get(i).getRiskFlagDetail() == null || this.get(i).getRiskFlagDetail().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getRiskFlagDetail());
			}
			if(this.get(i).getRiskFlag() == null || this.get(i).getRiskFlag().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getRiskFlag());
			}
			if(this.get(i).getPolType() == null || this.get(i).getPolType().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getPolType());
			}
			if(this.get(i).getInvestFlag() == null || this.get(i).getInvestFlag().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getInvestFlag());
			}
			if(this.get(i).getBonusFlag() == null || this.get(i).getBonusFlag().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getBonusFlag());
			}
			if(this.get(i).getBonusMode() == null || this.get(i).getBonusMode().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getBonusMode());
			}
			if(this.get(i).getListFlag() == null || this.get(i).getListFlag().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getListFlag());
			}
			pstmt.setInt(23, this.get(i).getCalDigital());
			if(this.get(i).getCalChomode() == null || this.get(i).getCalChomode().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getCalChomode());
			}
			pstmt.setInt(25, this.get(i).getRiskAmntmult());
			if(this.get(i).getInsuperiodFlag() == null || this.get(i).getInsuperiodFlag().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getInsuperiodFlag());
			}
			pstmt.setInt(27, this.get(i).getMaxEndPeriod());
			pstmt.setInt(28, this.get(i).getAgeLmt());
			pstmt.setInt(29, this.get(i).getSignDateCalMode());
			if(this.get(i).getProtocolFlag() == null || this.get(i).getProtocolFlag().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getProtocolFlag());
			}
			if(this.get(i).getGetChgFlag() == null || this.get(i).getGetChgFlag().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getGetChgFlag());
			}
			if(this.get(i).getProtocolPayFlag() == null || this.get(i).getProtocolPayFlag().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getProtocolPayFlag());
			}
			if(this.get(i).getEnSuplanFlag() == null || this.get(i).getEnSuplanFlag().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getEnSuplanFlag());
			}
			if(this.get(i).getEnSuplanAdjFlag() == null || this.get(i).getEnSuplanAdjFlag().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getEnSuplanAdjFlag());
			}
			pstmt.setDouble(35, this.get(i).getAppInterest());
			pstmt.setDouble(36, this.get(i).getAppPremrate());
			if(this.get(i).getInSuredFlag() == null || this.get(i).getInSuredFlag().equals("null")) {
				pstmt.setString(37,null);
			} else {
				pstmt.setString(37, this.get(i).getInSuredFlag());
			}
			if(this.get(i).getShareFlag() == null || this.get(i).getShareFlag().equals("null")) {
				pstmt.setString(38,null);
			} else {
				pstmt.setString(38, this.get(i).getShareFlag());
			}
			if(this.get(i).getBnfFlag() == null || this.get(i).getBnfFlag().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getBnfFlag());
			}
			if(this.get(i).getTempPayFlag() == null || this.get(i).getTempPayFlag().equals("null")) {
				pstmt.setString(40,null);
			} else {
				pstmt.setString(40, this.get(i).getTempPayFlag());
			}
			if(this.get(i).getInpPayPlan() == null || this.get(i).getInpPayPlan().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getInpPayPlan());
			}
			if(this.get(i).getImpartFlag() == null || this.get(i).getImpartFlag().equals("null")) {
				pstmt.setString(42,null);
			} else {
				pstmt.setString(42, this.get(i).getImpartFlag());
			}
			if(this.get(i).getInsuexpeFlag() == null || this.get(i).getInsuexpeFlag().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getInsuexpeFlag());
			}
			if(this.get(i).getLoanFlag() == null || this.get(i).getLoanFlag().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getLoanFlag());
			}
			if(this.get(i).getMortagageFlag() == null || this.get(i).getMortagageFlag().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getMortagageFlag());
			}
			if(this.get(i).getIdifreturnFlag() == null || this.get(i).getIdifreturnFlag().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getIdifreturnFlag());
			}
			if(this.get(i).getCutamntstopPay() == null || this.get(i).getCutamntstopPay().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getCutamntstopPay());
			}
			pstmt.setDouble(48, this.get(i).getRinsRate());
			if(this.get(i).getSaleFlag() == null || this.get(i).getSaleFlag().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getSaleFlag());
			}
			if(this.get(i).getFileAppFlag() == null || this.get(i).getFileAppFlag().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getFileAppFlag());
			}
			if(this.get(i).getMngCom() == null || this.get(i).getMngCom().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getMngCom());
			}
			if(this.get(i).getAutoPayFlag() == null || this.get(i).getAutoPayFlag().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getAutoPayFlag());
			}
			if(this.get(i).getNeedPrintHospital() == null || this.get(i).getNeedPrintHospital().equals("null")) {
				pstmt.setString(53,null);
			} else {
				pstmt.setString(53, this.get(i).getNeedPrintHospital());
			}
			if(this.get(i).getNeedPrintGet() == null || this.get(i).getNeedPrintGet().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getNeedPrintGet());
			}
			if(this.get(i).getNotPrintPol() == null || this.get(i).getNotPrintPol().equals("null")) {
				pstmt.setString(55,null);
			} else {
				pstmt.setString(55, this.get(i).getNotPrintPol());
			}
			if(this.get(i).getNeedGetPolDate() == null || this.get(i).getNeedGetPolDate().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getNeedGetPolDate());
			}
			if(this.get(i).getNeedRereadBank() == null || this.get(i).getNeedRereadBank().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getNeedRereadBank());
			}
			if(this.get(i).getSpecFlag() == null || this.get(i).getSpecFlag().equals("null")) {
				pstmt.setString(58,null);
			} else {
				pstmt.setString(58, this.get(i).getSpecFlag());
			}
			if(this.get(i).getInterestDifFlag() == null || this.get(i).getInterestDifFlag().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getInterestDifFlag());
			}
			pstmt.setInt(60, this.get(i).getMinappntAge());
			pstmt.setInt(61, this.get(i).getMaxAppntAge());
			pstmt.setInt(62, this.get(i).getMaxInsuredAge());
			pstmt.setInt(63, this.get(i).getMinInsuredAge());
			// set where condition
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(64,null);
			} else {
				pstmt.setString(64, this.get(i).getRiskCode());
			}
			if(this.get(i).getRiskProp() == null || this.get(i).getRiskProp().equals("null")) {
				pstmt.setString(65,null);
			} else {
				pstmt.setString(65, this.get(i).getRiskProp());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCProduct");
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
			tError.moduleName = "LCProductDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LCProduct VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getRiskCode() == null || this.get(i).getRiskCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getRiskCode());
			}
			if(this.get(i).getRiskProp() == null || this.get(i).getRiskProp().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getRiskProp());
			}
			if(this.get(i).getRiskVer() == null || this.get(i).getRiskVer().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getRiskVer());
			}
			if(this.get(i).getRiskName() == null || this.get(i).getRiskName().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getRiskName());
			}
			if(this.get(i).getSubRiskFlag() == null || this.get(i).getSubRiskFlag().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getSubRiskFlag());
			}
			if(this.get(i).getKindCode() == null || this.get(i).getKindCode().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getKindCode());
			}
			if(this.get(i).getStartDate() == null || this.get(i).getStartDate().equals("null")) {
				pstmt.setDate(7,null);
			} else {
				pstmt.setDate(7, Date.valueOf(this.get(i).getStartDate()));
			}
			if(this.get(i).getEndDate() == null || this.get(i).getEndDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getEndDate()));
			}
			if(this.get(i).getRiskType() == null || this.get(i).getRiskType().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getRiskType());
			}
			if(this.get(i).getRiskType1() == null || this.get(i).getRiskType1().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getRiskType1());
			}
			if(this.get(i).getRiskType2() == null || this.get(i).getRiskType2().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getRiskType2());
			}
			if(this.get(i).getRiskType3() == null || this.get(i).getRiskType3().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getRiskType3());
			}
			if(this.get(i).getRiskType4() == null || this.get(i).getRiskType4().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getRiskType4());
			}
			if(this.get(i).getRiskType5() == null || this.get(i).getRiskType5().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getRiskType5());
			}
			if(this.get(i).getRiskPeriod() == null || this.get(i).getRiskPeriod().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getRiskPeriod());
			}
			if(this.get(i).getRiskFlagDetail() == null || this.get(i).getRiskFlagDetail().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getRiskFlagDetail());
			}
			if(this.get(i).getRiskFlag() == null || this.get(i).getRiskFlag().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getRiskFlag());
			}
			if(this.get(i).getPolType() == null || this.get(i).getPolType().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getPolType());
			}
			if(this.get(i).getInvestFlag() == null || this.get(i).getInvestFlag().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getInvestFlag());
			}
			if(this.get(i).getBonusFlag() == null || this.get(i).getBonusFlag().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getBonusFlag());
			}
			if(this.get(i).getBonusMode() == null || this.get(i).getBonusMode().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getBonusMode());
			}
			if(this.get(i).getListFlag() == null || this.get(i).getListFlag().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getListFlag());
			}
			pstmt.setInt(23, this.get(i).getCalDigital());
			if(this.get(i).getCalChomode() == null || this.get(i).getCalChomode().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getCalChomode());
			}
			pstmt.setInt(25, this.get(i).getRiskAmntmult());
			if(this.get(i).getInsuperiodFlag() == null || this.get(i).getInsuperiodFlag().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getInsuperiodFlag());
			}
			pstmt.setInt(27, this.get(i).getMaxEndPeriod());
			pstmt.setInt(28, this.get(i).getAgeLmt());
			pstmt.setInt(29, this.get(i).getSignDateCalMode());
			if(this.get(i).getProtocolFlag() == null || this.get(i).getProtocolFlag().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getProtocolFlag());
			}
			if(this.get(i).getGetChgFlag() == null || this.get(i).getGetChgFlag().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getGetChgFlag());
			}
			if(this.get(i).getProtocolPayFlag() == null || this.get(i).getProtocolPayFlag().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getProtocolPayFlag());
			}
			if(this.get(i).getEnSuplanFlag() == null || this.get(i).getEnSuplanFlag().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getEnSuplanFlag());
			}
			if(this.get(i).getEnSuplanAdjFlag() == null || this.get(i).getEnSuplanAdjFlag().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getEnSuplanAdjFlag());
			}
			pstmt.setDouble(35, this.get(i).getAppInterest());
			pstmt.setDouble(36, this.get(i).getAppPremrate());
			if(this.get(i).getInSuredFlag() == null || this.get(i).getInSuredFlag().equals("null")) {
				pstmt.setString(37,null);
			} else {
				pstmt.setString(37, this.get(i).getInSuredFlag());
			}
			if(this.get(i).getShareFlag() == null || this.get(i).getShareFlag().equals("null")) {
				pstmt.setString(38,null);
			} else {
				pstmt.setString(38, this.get(i).getShareFlag());
			}
			if(this.get(i).getBnfFlag() == null || this.get(i).getBnfFlag().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getBnfFlag());
			}
			if(this.get(i).getTempPayFlag() == null || this.get(i).getTempPayFlag().equals("null")) {
				pstmt.setString(40,null);
			} else {
				pstmt.setString(40, this.get(i).getTempPayFlag());
			}
			if(this.get(i).getInpPayPlan() == null || this.get(i).getInpPayPlan().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getInpPayPlan());
			}
			if(this.get(i).getImpartFlag() == null || this.get(i).getImpartFlag().equals("null")) {
				pstmt.setString(42,null);
			} else {
				pstmt.setString(42, this.get(i).getImpartFlag());
			}
			if(this.get(i).getInsuexpeFlag() == null || this.get(i).getInsuexpeFlag().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getInsuexpeFlag());
			}
			if(this.get(i).getLoanFlag() == null || this.get(i).getLoanFlag().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getLoanFlag());
			}
			if(this.get(i).getMortagageFlag() == null || this.get(i).getMortagageFlag().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getMortagageFlag());
			}
			if(this.get(i).getIdifreturnFlag() == null || this.get(i).getIdifreturnFlag().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getIdifreturnFlag());
			}
			if(this.get(i).getCutamntstopPay() == null || this.get(i).getCutamntstopPay().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getCutamntstopPay());
			}
			pstmt.setDouble(48, this.get(i).getRinsRate());
			if(this.get(i).getSaleFlag() == null || this.get(i).getSaleFlag().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getSaleFlag());
			}
			if(this.get(i).getFileAppFlag() == null || this.get(i).getFileAppFlag().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getFileAppFlag());
			}
			if(this.get(i).getMngCom() == null || this.get(i).getMngCom().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getMngCom());
			}
			if(this.get(i).getAutoPayFlag() == null || this.get(i).getAutoPayFlag().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getAutoPayFlag());
			}
			if(this.get(i).getNeedPrintHospital() == null || this.get(i).getNeedPrintHospital().equals("null")) {
				pstmt.setString(53,null);
			} else {
				pstmt.setString(53, this.get(i).getNeedPrintHospital());
			}
			if(this.get(i).getNeedPrintGet() == null || this.get(i).getNeedPrintGet().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getNeedPrintGet());
			}
			if(this.get(i).getNotPrintPol() == null || this.get(i).getNotPrintPol().equals("null")) {
				pstmt.setString(55,null);
			} else {
				pstmt.setString(55, this.get(i).getNotPrintPol());
			}
			if(this.get(i).getNeedGetPolDate() == null || this.get(i).getNeedGetPolDate().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getNeedGetPolDate());
			}
			if(this.get(i).getNeedRereadBank() == null || this.get(i).getNeedRereadBank().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getNeedRereadBank());
			}
			if(this.get(i).getSpecFlag() == null || this.get(i).getSpecFlag().equals("null")) {
				pstmt.setString(58,null);
			} else {
				pstmt.setString(58, this.get(i).getSpecFlag());
			}
			if(this.get(i).getInterestDifFlag() == null || this.get(i).getInterestDifFlag().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getInterestDifFlag());
			}
			pstmt.setInt(60, this.get(i).getMinappntAge());
			pstmt.setInt(61, this.get(i).getMaxAppntAge());
			pstmt.setInt(62, this.get(i).getMaxInsuredAge());
			pstmt.setInt(63, this.get(i).getMinInsuredAge());

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCProduct");
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
			tError.moduleName = "LCProductDBSet";
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
