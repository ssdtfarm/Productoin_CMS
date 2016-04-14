/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.LAAgentSchema;
import com.sinosoft.lis.vschema.LAAgentSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAAgentDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAgentDB extends LAAgentSchema
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
	public LAAgentDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LAAgent" );
		mflag = true;
	}

	public LAAgentDB()
	{
		con = null;
		db = new DBOper( "LAAgent" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LAAgentSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LAAgentSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
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
			pstmt = con.prepareStatement("DELETE FROM LAAgent WHERE  AgentCode = ?");
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAgentCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAgent");
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
		SQLString sqlObj = new SQLString("LAAgent");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LAAgent SET  AgentCode = ? , BranchType = ? , AgentGroup = ? , ManageCom = ? , Password = ? , AgentState = ? , SurName = ? , GivenName = ? , EnglishName = ? , HKIDName = ? , ChineseName = ? , IDType = ? , IDNo = ? , WorkingVisa = ? , WorkingVisaExpiryDate = ? , WorkingVisaType = ? , Qualification = ? , ContractType = ? , ContractEffDate = ? , ContractStatus = ? , RecruitmentProfile = ? , RecruitingAgentCode = ? , ReferringAgentCode = ? , LastTerminationDate = ? , LastTerminationReason = ? , TerminationNo = ? , PaymentMethod = ? , BankAccountName = ? , BankAccountNo = ? , WithheldReason = ? , GuarantorAgentCode = ? , GuarantorAgentRelation = ? , GuarantorType = ? , Sex = ? , Title = ? , Nationality = ? , Birthday = ? , WorkingExperience = ? , LastJob = ? , LastJobServiceYears = ? , InsuranceExperience = ? , InsuranceExperienceYears = ? , EducationLevel = ? , AddressType = ? , AddressRoom = ? , AddressFloor = ? , AddressBlock = ? , AddressBuilding = ? , AddressStreet = ? , AddressDistrict = ? , FreeAddress = ? , Phone = ? , Mobile = ? , Email = ? , CompanyEmail = ? , OfficeAddress = ? , OfficeTel = ? , OfficeFaxNo = ? , Marriage = ? , SpouseName = ? , SpouseIDNo = ? , Flag1 = ? , Flag2 = ? , Flag3 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , LastJobNature = ? WHERE  AgentCode = ?");
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAgentCode());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getBranchType());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentGroup());
			}
			if(this.getManageCom() == null || this.getManageCom().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getManageCom());
			}
			if(this.getPassword() == null || this.getPassword().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getPassword());
			}
			if(this.getAgentState() == null || this.getAgentState().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentState());
			}
			if(this.getSurName() == null || this.getSurName().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getSurName());
			}
			if(this.getGivenName() == null || this.getGivenName().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getGivenName());
			}
			if(this.getEnglishName() == null || this.getEnglishName().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getEnglishName());
			}
			if(this.getHKIDName() == null || this.getHKIDName().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getHKIDName());
			}
			if(this.getChineseName() == null || this.getChineseName().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getChineseName());
			}
			if(this.getIDType() == null || this.getIDType().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getIDType());
			}
			if(this.getIDNo() == null || this.getIDNo().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getIDNo());
			}
			if(this.getWorkingVisa() == null || this.getWorkingVisa().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getWorkingVisa());
			}
			if(this.getWorkingVisaExpiryDate() == null || this.getWorkingVisaExpiryDate().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getWorkingVisaExpiryDate()));
			}
			if(this.getWorkingVisaType() == null || this.getWorkingVisaType().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getWorkingVisaType());
			}
			if(this.getQualification() == null || this.getQualification().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getQualification());
			}
			if(this.getContractType() == null || this.getContractType().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getContractType());
			}
			if(this.getContractEffDate() == null || this.getContractEffDate().equals("null")) {
				pstmt.setNull(19, 91);
			} else {
				pstmt.setDate(19, Date.valueOf(this.getContractEffDate()));
			}
			if(this.getContractStatus() == null || this.getContractStatus().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getContractStatus());
			}
			if(this.getRecruitmentProfile() == null || this.getRecruitmentProfile().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getRecruitmentProfile());
			}
			if(this.getRecruitingAgentCode() == null || this.getRecruitingAgentCode().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getRecruitingAgentCode());
			}
			if(this.getReferringAgentCode() == null || this.getReferringAgentCode().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getReferringAgentCode());
			}
			if(this.getLastTerminationDate() == null || this.getLastTerminationDate().equals("null")) {
				pstmt.setNull(24, 91);
			} else {
				pstmt.setDate(24, Date.valueOf(this.getLastTerminationDate()));
			}
			if(this.getLastTerminationReason() == null || this.getLastTerminationReason().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getLastTerminationReason());
			}
			pstmt.setInt(26, this.getTerminationNo());
			if(this.getPaymentMethod() == null || this.getPaymentMethod().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getPaymentMethod());
			}
			if(this.getBankAccountName() == null || this.getBankAccountName().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getBankAccountName());
			}
			if(this.getBankAccountNo() == null || this.getBankAccountNo().equals("null")) {
				pstmt.setNull(29, 12);
			} else {
				pstmt.setString(29, this.getBankAccountNo());
			}
			if(this.getWithheldReason() == null || this.getWithheldReason().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getWithheldReason());
			}
			if(this.getGuarantorAgentCode() == null || this.getGuarantorAgentCode().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getGuarantorAgentCode());
			}
			if(this.getGuarantorAgentRelation() == null || this.getGuarantorAgentRelation().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getGuarantorAgentRelation());
			}
			if(this.getGuarantorType() == null || this.getGuarantorType().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getGuarantorType());
			}
			if(this.getSex() == null || this.getSex().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getSex());
			}
			if(this.getTitle() == null || this.getTitle().equals("null")) {
				pstmt.setNull(35, 12);
			} else {
				pstmt.setString(35, this.getTitle());
			}
			if(this.getNationality() == null || this.getNationality().equals("null")) {
				pstmt.setNull(36, 12);
			} else {
				pstmt.setString(36, this.getNationality());
			}
			if(this.getBirthday() == null || this.getBirthday().equals("null")) {
				pstmt.setNull(37, 91);
			} else {
				pstmt.setDate(37, Date.valueOf(this.getBirthday()));
			}
			pstmt.setInt(38, this.getWorkingExperience());
			if(this.getLastJob() == null || this.getLastJob().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getLastJob());
			}
			pstmt.setInt(40, this.getLastJobServiceYears());
			if(this.getInsuranceExperience() == null || this.getInsuranceExperience().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getInsuranceExperience());
			}
			pstmt.setInt(42, this.getInsuranceExperienceYears());
			if(this.getEducationLevel() == null || this.getEducationLevel().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getEducationLevel());
			}
			if(this.getAddressType() == null || this.getAddressType().equals("null")) {
				pstmt.setNull(44, 12);
			} else {
				pstmt.setString(44, this.getAddressType());
			}
			if(this.getAddressRoom() == null || this.getAddressRoom().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getAddressRoom());
			}
			if(this.getAddressFloor() == null || this.getAddressFloor().equals("null")) {
				pstmt.setNull(46, 12);
			} else {
				pstmt.setString(46, this.getAddressFloor());
			}
			if(this.getAddressBlock() == null || this.getAddressBlock().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getAddressBlock());
			}
			if(this.getAddressBuilding() == null || this.getAddressBuilding().equals("null")) {
				pstmt.setNull(48, 12);
			} else {
				pstmt.setString(48, this.getAddressBuilding());
			}
			if(this.getAddressStreet() == null || this.getAddressStreet().equals("null")) {
				pstmt.setNull(49, 12);
			} else {
				pstmt.setString(49, this.getAddressStreet());
			}
			if(this.getAddressDistrict() == null || this.getAddressDistrict().equals("null")) {
				pstmt.setNull(50, 12);
			} else {
				pstmt.setString(50, this.getAddressDistrict());
			}
			if(this.getFreeAddress() == null || this.getFreeAddress().equals("null")) {
				pstmt.setNull(51, 12);
			} else {
				pstmt.setString(51, this.getFreeAddress());
			}
			if(this.getPhone() == null || this.getPhone().equals("null")) {
				pstmt.setNull(52, 12);
			} else {
				pstmt.setString(52, this.getPhone());
			}
			if(this.getMobile() == null || this.getMobile().equals("null")) {
				pstmt.setNull(53, 12);
			} else {
				pstmt.setString(53, this.getMobile());
			}
			if(this.getEmail() == null || this.getEmail().equals("null")) {
				pstmt.setNull(54, 12);
			} else {
				pstmt.setString(54, this.getEmail());
			}
			if(this.getCompanyEmail() == null || this.getCompanyEmail().equals("null")) {
				pstmt.setNull(55, 12);
			} else {
				pstmt.setString(55, this.getCompanyEmail());
			}
			if(this.getOfficeAddress() == null || this.getOfficeAddress().equals("null")) {
				pstmt.setNull(56, 12);
			} else {
				pstmt.setString(56, this.getOfficeAddress());
			}
			if(this.getOfficeTel() == null || this.getOfficeTel().equals("null")) {
				pstmt.setNull(57, 12);
			} else {
				pstmt.setString(57, this.getOfficeTel());
			}
			if(this.getOfficeFaxNo() == null || this.getOfficeFaxNo().equals("null")) {
				pstmt.setNull(58, 12);
			} else {
				pstmt.setString(58, this.getOfficeFaxNo());
			}
			if(this.getMarriage() == null || this.getMarriage().equals("null")) {
				pstmt.setNull(59, 12);
			} else {
				pstmt.setString(59, this.getMarriage());
			}
			if(this.getSpouseName() == null || this.getSpouseName().equals("null")) {
				pstmt.setNull(60, 12);
			} else {
				pstmt.setString(60, this.getSpouseName());
			}
			if(this.getSpouseIDNo() == null || this.getSpouseIDNo().equals("null")) {
				pstmt.setNull(61, 12);
			} else {
				pstmt.setString(61, this.getSpouseIDNo());
			}
			if(this.getFlag1() == null || this.getFlag1().equals("null")) {
				pstmt.setNull(62, 12);
			} else {
				pstmt.setString(62, this.getFlag1());
			}
			if(this.getFlag2() == null || this.getFlag2().equals("null")) {
				pstmt.setNull(63, 12);
			} else {
				pstmt.setString(63, this.getFlag2());
			}
			if(this.getFlag3() == null || this.getFlag3().equals("null")) {
				pstmt.setNull(64, 12);
			} else {
				pstmt.setString(64, this.getFlag3());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(65, 12);
			} else {
				pstmt.setString(65, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(66, 91);
			} else {
				pstmt.setDate(66, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(67, 12);
			} else {
				pstmt.setString(67, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(68, 91);
			} else {
				pstmt.setDate(68, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(69, 12);
			} else {
				pstmt.setString(69, this.getModifyTime());
			}
			if(this.getLastJobNature() == null || this.getLastJobNature().equals("null")) {
				pstmt.setNull(70, 12);
			} else {
				pstmt.setString(70, this.getLastJobNature());
			}
			// set where condition
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(71, 12);
			} else {
				pstmt.setString(71, this.getAgentCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
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
		SQLString sqlObj = new SQLString("LAAgent");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LAAgent VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAgentCode());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getBranchType());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentGroup());
			}
			if(this.getManageCom() == null || this.getManageCom().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getManageCom());
			}
			if(this.getPassword() == null || this.getPassword().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getPassword());
			}
			if(this.getAgentState() == null || this.getAgentState().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentState());
			}
			if(this.getSurName() == null || this.getSurName().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getSurName());
			}
			if(this.getGivenName() == null || this.getGivenName().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getGivenName());
			}
			if(this.getEnglishName() == null || this.getEnglishName().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getEnglishName());
			}
			if(this.getHKIDName() == null || this.getHKIDName().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getHKIDName());
			}
			if(this.getChineseName() == null || this.getChineseName().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getChineseName());
			}
			if(this.getIDType() == null || this.getIDType().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getIDType());
			}
			if(this.getIDNo() == null || this.getIDNo().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getIDNo());
			}
			if(this.getWorkingVisa() == null || this.getWorkingVisa().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getWorkingVisa());
			}
			if(this.getWorkingVisaExpiryDate() == null || this.getWorkingVisaExpiryDate().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getWorkingVisaExpiryDate()));
			}
			if(this.getWorkingVisaType() == null || this.getWorkingVisaType().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getWorkingVisaType());
			}
			if(this.getQualification() == null || this.getQualification().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getQualification());
			}
			if(this.getContractType() == null || this.getContractType().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getContractType());
			}
			if(this.getContractEffDate() == null || this.getContractEffDate().equals("null")) {
				pstmt.setNull(19, 91);
			} else {
				pstmt.setDate(19, Date.valueOf(this.getContractEffDate()));
			}
			if(this.getContractStatus() == null || this.getContractStatus().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getContractStatus());
			}
			if(this.getRecruitmentProfile() == null || this.getRecruitmentProfile().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getRecruitmentProfile());
			}
			if(this.getRecruitingAgentCode() == null || this.getRecruitingAgentCode().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getRecruitingAgentCode());
			}
			if(this.getReferringAgentCode() == null || this.getReferringAgentCode().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getReferringAgentCode());
			}
			if(this.getLastTerminationDate() == null || this.getLastTerminationDate().equals("null")) {
				pstmt.setNull(24, 91);
			} else {
				pstmt.setDate(24, Date.valueOf(this.getLastTerminationDate()));
			}
			if(this.getLastTerminationReason() == null || this.getLastTerminationReason().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getLastTerminationReason());
			}
			pstmt.setInt(26, this.getTerminationNo());
			if(this.getPaymentMethod() == null || this.getPaymentMethod().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getPaymentMethod());
			}
			if(this.getBankAccountName() == null || this.getBankAccountName().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getBankAccountName());
			}
			if(this.getBankAccountNo() == null || this.getBankAccountNo().equals("null")) {
				pstmt.setNull(29, 12);
			} else {
				pstmt.setString(29, this.getBankAccountNo());
			}
			if(this.getWithheldReason() == null || this.getWithheldReason().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getWithheldReason());
			}
			if(this.getGuarantorAgentCode() == null || this.getGuarantorAgentCode().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getGuarantorAgentCode());
			}
			if(this.getGuarantorAgentRelation() == null || this.getGuarantorAgentRelation().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getGuarantorAgentRelation());
			}
			if(this.getGuarantorType() == null || this.getGuarantorType().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getGuarantorType());
			}
			if(this.getSex() == null || this.getSex().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getSex());
			}
			if(this.getTitle() == null || this.getTitle().equals("null")) {
				pstmt.setNull(35, 12);
			} else {
				pstmt.setString(35, this.getTitle());
			}
			if(this.getNationality() == null || this.getNationality().equals("null")) {
				pstmt.setNull(36, 12);
			} else {
				pstmt.setString(36, this.getNationality());
			}
			if(this.getBirthday() == null || this.getBirthday().equals("null")) {
				pstmt.setNull(37, 91);
			} else {
				pstmt.setDate(37, Date.valueOf(this.getBirthday()));
			}
			pstmt.setInt(38, this.getWorkingExperience());
			if(this.getLastJob() == null || this.getLastJob().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getLastJob());
			}
			pstmt.setInt(40, this.getLastJobServiceYears());
			if(this.getInsuranceExperience() == null || this.getInsuranceExperience().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getInsuranceExperience());
			}
			pstmt.setInt(42, this.getInsuranceExperienceYears());
			if(this.getEducationLevel() == null || this.getEducationLevel().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getEducationLevel());
			}
			if(this.getAddressType() == null || this.getAddressType().equals("null")) {
				pstmt.setNull(44, 12);
			} else {
				pstmt.setString(44, this.getAddressType());
			}
			if(this.getAddressRoom() == null || this.getAddressRoom().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getAddressRoom());
			}
			if(this.getAddressFloor() == null || this.getAddressFloor().equals("null")) {
				pstmt.setNull(46, 12);
			} else {
				pstmt.setString(46, this.getAddressFloor());
			}
			if(this.getAddressBlock() == null || this.getAddressBlock().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getAddressBlock());
			}
			if(this.getAddressBuilding() == null || this.getAddressBuilding().equals("null")) {
				pstmt.setNull(48, 12);
			} else {
				pstmt.setString(48, this.getAddressBuilding());
			}
			if(this.getAddressStreet() == null || this.getAddressStreet().equals("null")) {
				pstmt.setNull(49, 12);
			} else {
				pstmt.setString(49, this.getAddressStreet());
			}
			if(this.getAddressDistrict() == null || this.getAddressDistrict().equals("null")) {
				pstmt.setNull(50, 12);
			} else {
				pstmt.setString(50, this.getAddressDistrict());
			}
			if(this.getFreeAddress() == null || this.getFreeAddress().equals("null")) {
				pstmt.setNull(51, 12);
			} else {
				pstmt.setString(51, this.getFreeAddress());
			}
			if(this.getPhone() == null || this.getPhone().equals("null")) {
				pstmt.setNull(52, 12);
			} else {
				pstmt.setString(52, this.getPhone());
			}
			if(this.getMobile() == null || this.getMobile().equals("null")) {
				pstmt.setNull(53, 12);
			} else {
				pstmt.setString(53, this.getMobile());
			}
			if(this.getEmail() == null || this.getEmail().equals("null")) {
				pstmt.setNull(54, 12);
			} else {
				pstmt.setString(54, this.getEmail());
			}
			if(this.getCompanyEmail() == null || this.getCompanyEmail().equals("null")) {
				pstmt.setNull(55, 12);
			} else {
				pstmt.setString(55, this.getCompanyEmail());
			}
			if(this.getOfficeAddress() == null || this.getOfficeAddress().equals("null")) {
				pstmt.setNull(56, 12);
			} else {
				pstmt.setString(56, this.getOfficeAddress());
			}
			if(this.getOfficeTel() == null || this.getOfficeTel().equals("null")) {
				pstmt.setNull(57, 12);
			} else {
				pstmt.setString(57, this.getOfficeTel());
			}
			if(this.getOfficeFaxNo() == null || this.getOfficeFaxNo().equals("null")) {
				pstmt.setNull(58, 12);
			} else {
				pstmt.setString(58, this.getOfficeFaxNo());
			}
			if(this.getMarriage() == null || this.getMarriage().equals("null")) {
				pstmt.setNull(59, 12);
			} else {
				pstmt.setString(59, this.getMarriage());
			}
			if(this.getSpouseName() == null || this.getSpouseName().equals("null")) {
				pstmt.setNull(60, 12);
			} else {
				pstmt.setString(60, this.getSpouseName());
			}
			if(this.getSpouseIDNo() == null || this.getSpouseIDNo().equals("null")) {
				pstmt.setNull(61, 12);
			} else {
				pstmt.setString(61, this.getSpouseIDNo());
			}
			if(this.getFlag1() == null || this.getFlag1().equals("null")) {
				pstmt.setNull(62, 12);
			} else {
				pstmt.setString(62, this.getFlag1());
			}
			if(this.getFlag2() == null || this.getFlag2().equals("null")) {
				pstmt.setNull(63, 12);
			} else {
				pstmt.setString(63, this.getFlag2());
			}
			if(this.getFlag3() == null || this.getFlag3().equals("null")) {
				pstmt.setNull(64, 12);
			} else {
				pstmt.setString(64, this.getFlag3());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(65, 12);
			} else {
				pstmt.setString(65, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(66, 91);
			} else {
				pstmt.setDate(66, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(67, 12);
			} else {
				pstmt.setString(67, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(68, 91);
			} else {
				pstmt.setDate(68, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(69, 12);
			} else {
				pstmt.setString(69, this.getModifyTime());
			}
			if(this.getLastJobNature() == null || this.getLastJobNature().equals("null")) {
				pstmt.setNull(70, 12);
			} else {
				pstmt.setString(70, this.getLastJobNature());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
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
			pstmt = con.prepareStatement("SELECT * FROM LAAgent WHERE  AgentCode = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getAgentCode());
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
					tError.moduleName = "LAAgentDB";
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
			tError.moduleName = "LAAgentDB";
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

	public LAAgentSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAAgentSet aLAAgentSet = new LAAgentSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 LAAgentSchema aSchemaNew = this.getSchema();
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
			 	throw new IllegalArgumentException("Table LAAgent is querying for all data!");
			 }
			 mSql.append("select * from LAAgent ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LAAgentSchema s1 = new LAAgentSchema();
				s1.setSchema(rs,i);
				aLAAgentSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
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

		return aLAAgentSet;
	}

	public LAAgentSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAAgentSet aLAAgentSet = new LAAgentSet();

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
				LAAgentSchema s1 = new LAAgentSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAAgentDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAAgentSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
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

		return aLAAgentSet;
	}

	public LAAgentSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAAgentSet aLAAgentSet = new LAAgentSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("LAAgent");
			LAAgentSchema aSchema = this.getSchema();
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

				LAAgentSchema s1 = new LAAgentSchema();
				s1.setSchema(rs,i);
				aLAAgentSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
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

		return aLAAgentSet;
	}

	public LAAgentSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAAgentSet aLAAgentSet = new LAAgentSet();

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

				LAAgentSchema s1 = new LAAgentSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAAgentDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAAgentSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAgentDB";
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

		return aLAAgentSet;
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
			SQLString sqlObj = new SQLString("LAAgent");
			LAAgentSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LAAgent " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LAAgentDB";
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
			tError.moduleName = "LAAgentDB";
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
        tError.moduleName = "LAAgentDB";
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
        tError.moduleName = "LAAgentDB";
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
        tError.moduleName = "LAAgentDB";
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
        tError.moduleName = "LAAgentDB";
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
 * @return LAAgentSet
 */
public LAAgentSet getData()
{
    int tCount = 0;
    LAAgentSet tLAAgentSet = new LAAgentSet();
    LAAgentSchema tLAAgentSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LAAgentDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLAAgentSchema = new LAAgentSchema();
        tLAAgentSchema.setSchema(mResultSet, 1);
        tLAAgentSet.add(tLAAgentSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLAAgentSchema = new LAAgentSchema();
                tLAAgentSchema.setSchema(mResultSet, 1);
                tLAAgentSet.add(tLAAgentSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LAAgentDB";
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
    return tLAAgentSet;
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
            tError.moduleName = "LAAgentDB";
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
        tError.moduleName = "LAAgentDB";
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
            tError.moduleName = "LAAgentDB";
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
        tError.moduleName = "LAAgentDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
