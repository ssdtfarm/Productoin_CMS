/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LAAgentSchema;
import com.sinosoft.lis.vschema.LAAgentSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAAgentDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAgentDBSet extends LAAgentSet
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
	public LAAgentDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LAAgent");
		mflag = true;
	}

	public LAAgentDBSet()
	{
		db = new DBOper( "LAAgent" );
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
			tError.moduleName = "LAAgentDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAAgent WHERE  AgentCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAgent");
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
			tError.moduleName = "LAAgentDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAAgent SET  AgentCode = ? , BranchType = ? , AgentGroup = ? , ManageCom = ? , Password = ? , AgentState = ? , SurName = ? , GivenName = ? , EnglishName = ? , HKIDName = ? , ChineseName = ? , IDType = ? , IDNo = ? , WorkingVisa = ? , WorkingVisaExpiryDate = ? , WorkingVisaType = ? , Qualification = ? , ContractType = ? , ContractEffDate = ? , ContractStatus = ? , RecruitmentProfile = ? , RecruitingAgentCode = ? , ReferringAgentCode = ? , LastTerminationDate = ? , LastTerminationReason = ? , TerminationNo = ? , PaymentMethod = ? , BankAccountName = ? , BankAccountNo = ? , WithheldReason = ? , GuarantorAgentCode = ? , GuarantorAgentRelation = ? , GuarantorType = ? , Sex = ? , Title = ? , Nationality = ? , Birthday = ? , WorkingExperience = ? , LastJob = ? , LastJobServiceYears = ? , InsuranceExperience = ? , InsuranceExperienceYears = ? , EducationLevel = ? , AddressType = ? , AddressRoom = ? , AddressFloor = ? , AddressBlock = ? , AddressBuilding = ? , AddressStreet = ? , AddressDistrict = ? , FreeAddress = ? , Phone = ? , Mobile = ? , Email = ? , CompanyEmail = ? , OfficeAddress = ? , OfficeTel = ? , OfficeFaxNo = ? , Marriage = ? , SpouseName = ? , SpouseIDNo = ? , Flag1 = ? , Flag2 = ? , Flag3 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , LastJobNature = ? WHERE  AgentCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getBranchType());
			}
			if(this.get(i).getAgentGroup() == null || this.get(i).getAgentGroup().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getAgentGroup());
			}
			if(this.get(i).getManageCom() == null || this.get(i).getManageCom().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getManageCom());
			}
			if(this.get(i).getPassword() == null || this.get(i).getPassword().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getPassword());
			}
			if(this.get(i).getAgentState() == null || this.get(i).getAgentState().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getAgentState());
			}
			if(this.get(i).getSurName() == null || this.get(i).getSurName().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getSurName());
			}
			if(this.get(i).getGivenName() == null || this.get(i).getGivenName().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getGivenName());
			}
			if(this.get(i).getEnglishName() == null || this.get(i).getEnglishName().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getEnglishName());
			}
			if(this.get(i).getHKIDName() == null || this.get(i).getHKIDName().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getHKIDName());
			}
			if(this.get(i).getChineseName() == null || this.get(i).getChineseName().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getChineseName());
			}
			if(this.get(i).getIDType() == null || this.get(i).getIDType().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getIDType());
			}
			if(this.get(i).getIDNo() == null || this.get(i).getIDNo().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getIDNo());
			}
			if(this.get(i).getWorkingVisa() == null || this.get(i).getWorkingVisa().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getWorkingVisa());
			}
			if(this.get(i).getWorkingVisaExpiryDate() == null || this.get(i).getWorkingVisaExpiryDate().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getWorkingVisaExpiryDate()));
			}
			if(this.get(i).getWorkingVisaType() == null || this.get(i).getWorkingVisaType().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getWorkingVisaType());
			}
			if(this.get(i).getQualification() == null || this.get(i).getQualification().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getQualification());
			}
			if(this.get(i).getContractType() == null || this.get(i).getContractType().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getContractType());
			}
			if(this.get(i).getContractEffDate() == null || this.get(i).getContractEffDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getContractEffDate()));
			}
			if(this.get(i).getContractStatus() == null || this.get(i).getContractStatus().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getContractStatus());
			}
			if(this.get(i).getRecruitmentProfile() == null || this.get(i).getRecruitmentProfile().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getRecruitmentProfile());
			}
			if(this.get(i).getRecruitingAgentCode() == null || this.get(i).getRecruitingAgentCode().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getRecruitingAgentCode());
			}
			if(this.get(i).getReferringAgentCode() == null || this.get(i).getReferringAgentCode().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getReferringAgentCode());
			}
			if(this.get(i).getLastTerminationDate() == null || this.get(i).getLastTerminationDate().equals("null")) {
				pstmt.setDate(24,null);
			} else {
				pstmt.setDate(24, Date.valueOf(this.get(i).getLastTerminationDate()));
			}
			if(this.get(i).getLastTerminationReason() == null || this.get(i).getLastTerminationReason().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getLastTerminationReason());
			}
			pstmt.setInt(26, this.get(i).getTerminationNo());
			if(this.get(i).getPaymentMethod() == null || this.get(i).getPaymentMethod().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getPaymentMethod());
			}
			if(this.get(i).getBankAccountName() == null || this.get(i).getBankAccountName().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getBankAccountName());
			}
			if(this.get(i).getBankAccountNo() == null || this.get(i).getBankAccountNo().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getBankAccountNo());
			}
			if(this.get(i).getWithheldReason() == null || this.get(i).getWithheldReason().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getWithheldReason());
			}
			if(this.get(i).getGuarantorAgentCode() == null || this.get(i).getGuarantorAgentCode().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getGuarantorAgentCode());
			}
			if(this.get(i).getGuarantorAgentRelation() == null || this.get(i).getGuarantorAgentRelation().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getGuarantorAgentRelation());
			}
			if(this.get(i).getGuarantorType() == null || this.get(i).getGuarantorType().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getGuarantorType());
			}
			if(this.get(i).getSex() == null || this.get(i).getSex().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getSex());
			}
			if(this.get(i).getTitle() == null || this.get(i).getTitle().equals("null")) {
				pstmt.setString(35,null);
			} else {
				pstmt.setString(35, this.get(i).getTitle());
			}
			if(this.get(i).getNationality() == null || this.get(i).getNationality().equals("null")) {
				pstmt.setString(36,null);
			} else {
				pstmt.setString(36, this.get(i).getNationality());
			}
			if(this.get(i).getBirthday() == null || this.get(i).getBirthday().equals("null")) {
				pstmt.setDate(37,null);
			} else {
				pstmt.setDate(37, Date.valueOf(this.get(i).getBirthday()));
			}
			pstmt.setInt(38, this.get(i).getWorkingExperience());
			if(this.get(i).getLastJob() == null || this.get(i).getLastJob().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getLastJob());
			}
			pstmt.setInt(40, this.get(i).getLastJobServiceYears());
			if(this.get(i).getInsuranceExperience() == null || this.get(i).getInsuranceExperience().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getInsuranceExperience());
			}
			pstmt.setInt(42, this.get(i).getInsuranceExperienceYears());
			if(this.get(i).getEducationLevel() == null || this.get(i).getEducationLevel().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getEducationLevel());
			}
			if(this.get(i).getAddressType() == null || this.get(i).getAddressType().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getAddressType());
			}
			if(this.get(i).getAddressRoom() == null || this.get(i).getAddressRoom().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getAddressRoom());
			}
			if(this.get(i).getAddressFloor() == null || this.get(i).getAddressFloor().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getAddressFloor());
			}
			if(this.get(i).getAddressBlock() == null || this.get(i).getAddressBlock().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getAddressBlock());
			}
			if(this.get(i).getAddressBuilding() == null || this.get(i).getAddressBuilding().equals("null")) {
				pstmt.setString(48,null);
			} else {
				pstmt.setString(48, this.get(i).getAddressBuilding());
			}
			if(this.get(i).getAddressStreet() == null || this.get(i).getAddressStreet().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getAddressStreet());
			}
			if(this.get(i).getAddressDistrict() == null || this.get(i).getAddressDistrict().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getAddressDistrict());
			}
			if(this.get(i).getFreeAddress() == null || this.get(i).getFreeAddress().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getFreeAddress());
			}
			if(this.get(i).getPhone() == null || this.get(i).getPhone().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getPhone());
			}
			if(this.get(i).getMobile() == null || this.get(i).getMobile().equals("null")) {
				pstmt.setString(53,null);
			} else {
				pstmt.setString(53, this.get(i).getMobile());
			}
			if(this.get(i).getEmail() == null || this.get(i).getEmail().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getEmail());
			}
			if(this.get(i).getCompanyEmail() == null || this.get(i).getCompanyEmail().equals("null")) {
				pstmt.setString(55,null);
			} else {
				pstmt.setString(55, this.get(i).getCompanyEmail());
			}
			if(this.get(i).getOfficeAddress() == null || this.get(i).getOfficeAddress().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getOfficeAddress());
			}
			if(this.get(i).getOfficeTel() == null || this.get(i).getOfficeTel().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getOfficeTel());
			}
			if(this.get(i).getOfficeFaxNo() == null || this.get(i).getOfficeFaxNo().equals("null")) {
				pstmt.setString(58,null);
			} else {
				pstmt.setString(58, this.get(i).getOfficeFaxNo());
			}
			if(this.get(i).getMarriage() == null || this.get(i).getMarriage().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getMarriage());
			}
			if(this.get(i).getSpouseName() == null || this.get(i).getSpouseName().equals("null")) {
				pstmt.setString(60,null);
			} else {
				pstmt.setString(60, this.get(i).getSpouseName());
			}
			if(this.get(i).getSpouseIDNo() == null || this.get(i).getSpouseIDNo().equals("null")) {
				pstmt.setString(61,null);
			} else {
				pstmt.setString(61, this.get(i).getSpouseIDNo());
			}
			if(this.get(i).getFlag1() == null || this.get(i).getFlag1().equals("null")) {
				pstmt.setString(62,null);
			} else {
				pstmt.setString(62, this.get(i).getFlag1());
			}
			if(this.get(i).getFlag2() == null || this.get(i).getFlag2().equals("null")) {
				pstmt.setString(63,null);
			} else {
				pstmt.setString(63, this.get(i).getFlag2());
			}
			if(this.get(i).getFlag3() == null || this.get(i).getFlag3().equals("null")) {
				pstmt.setString(64,null);
			} else {
				pstmt.setString(64, this.get(i).getFlag3());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(65,null);
			} else {
				pstmt.setString(65, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(66,null);
			} else {
				pstmt.setDate(66, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(67,null);
			} else {
				pstmt.setString(67, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(68,null);
			} else {
				pstmt.setDate(68, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(69,null);
			} else {
				pstmt.setString(69, this.get(i).getModifyTime());
			}
			if(this.get(i).getLastJobNature() == null || this.get(i).getLastJobNature().equals("null")) {
				pstmt.setString(70,null);
			} else {
				pstmt.setString(70, this.get(i).getLastJobNature());
			}
			// set where condition
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(71,null);
			} else {
				pstmt.setString(71, this.get(i).getAgentCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAgent");
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
			tError.moduleName = "LAAgentDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAAgent VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getBranchType());
			}
			if(this.get(i).getAgentGroup() == null || this.get(i).getAgentGroup().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getAgentGroup());
			}
			if(this.get(i).getManageCom() == null || this.get(i).getManageCom().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getManageCom());
			}
			if(this.get(i).getPassword() == null || this.get(i).getPassword().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getPassword());
			}
			if(this.get(i).getAgentState() == null || this.get(i).getAgentState().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getAgentState());
			}
			if(this.get(i).getSurName() == null || this.get(i).getSurName().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getSurName());
			}
			if(this.get(i).getGivenName() == null || this.get(i).getGivenName().equals("null")) {
				pstmt.setString(8,null);
			} else {
				pstmt.setString(8, this.get(i).getGivenName());
			}
			if(this.get(i).getEnglishName() == null || this.get(i).getEnglishName().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getEnglishName());
			}
			if(this.get(i).getHKIDName() == null || this.get(i).getHKIDName().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getHKIDName());
			}
			if(this.get(i).getChineseName() == null || this.get(i).getChineseName().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getChineseName());
			}
			if(this.get(i).getIDType() == null || this.get(i).getIDType().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getIDType());
			}
			if(this.get(i).getIDNo() == null || this.get(i).getIDNo().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getIDNo());
			}
			if(this.get(i).getWorkingVisa() == null || this.get(i).getWorkingVisa().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getWorkingVisa());
			}
			if(this.get(i).getWorkingVisaExpiryDate() == null || this.get(i).getWorkingVisaExpiryDate().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getWorkingVisaExpiryDate()));
			}
			if(this.get(i).getWorkingVisaType() == null || this.get(i).getWorkingVisaType().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getWorkingVisaType());
			}
			if(this.get(i).getQualification() == null || this.get(i).getQualification().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getQualification());
			}
			if(this.get(i).getContractType() == null || this.get(i).getContractType().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getContractType());
			}
			if(this.get(i).getContractEffDate() == null || this.get(i).getContractEffDate().equals("null")) {
				pstmt.setDate(19,null);
			} else {
				pstmt.setDate(19, Date.valueOf(this.get(i).getContractEffDate()));
			}
			if(this.get(i).getContractStatus() == null || this.get(i).getContractStatus().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getContractStatus());
			}
			if(this.get(i).getRecruitmentProfile() == null || this.get(i).getRecruitmentProfile().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getRecruitmentProfile());
			}
			if(this.get(i).getRecruitingAgentCode() == null || this.get(i).getRecruitingAgentCode().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getRecruitingAgentCode());
			}
			if(this.get(i).getReferringAgentCode() == null || this.get(i).getReferringAgentCode().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getReferringAgentCode());
			}
			if(this.get(i).getLastTerminationDate() == null || this.get(i).getLastTerminationDate().equals("null")) {
				pstmt.setDate(24,null);
			} else {
				pstmt.setDate(24, Date.valueOf(this.get(i).getLastTerminationDate()));
			}
			if(this.get(i).getLastTerminationReason() == null || this.get(i).getLastTerminationReason().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getLastTerminationReason());
			}
			pstmt.setInt(26, this.get(i).getTerminationNo());
			if(this.get(i).getPaymentMethod() == null || this.get(i).getPaymentMethod().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getPaymentMethod());
			}
			if(this.get(i).getBankAccountName() == null || this.get(i).getBankAccountName().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getBankAccountName());
			}
			if(this.get(i).getBankAccountNo() == null || this.get(i).getBankAccountNo().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getBankAccountNo());
			}
			if(this.get(i).getWithheldReason() == null || this.get(i).getWithheldReason().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getWithheldReason());
			}
			if(this.get(i).getGuarantorAgentCode() == null || this.get(i).getGuarantorAgentCode().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getGuarantorAgentCode());
			}
			if(this.get(i).getGuarantorAgentRelation() == null || this.get(i).getGuarantorAgentRelation().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getGuarantorAgentRelation());
			}
			if(this.get(i).getGuarantorType() == null || this.get(i).getGuarantorType().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getGuarantorType());
			}
			if(this.get(i).getSex() == null || this.get(i).getSex().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getSex());
			}
			if(this.get(i).getTitle() == null || this.get(i).getTitle().equals("null")) {
				pstmt.setString(35,null);
			} else {
				pstmt.setString(35, this.get(i).getTitle());
			}
			if(this.get(i).getNationality() == null || this.get(i).getNationality().equals("null")) {
				pstmt.setString(36,null);
			} else {
				pstmt.setString(36, this.get(i).getNationality());
			}
			if(this.get(i).getBirthday() == null || this.get(i).getBirthday().equals("null")) {
				pstmt.setDate(37,null);
			} else {
				pstmt.setDate(37, Date.valueOf(this.get(i).getBirthday()));
			}
			pstmt.setInt(38, this.get(i).getWorkingExperience());
			if(this.get(i).getLastJob() == null || this.get(i).getLastJob().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getLastJob());
			}
			pstmt.setInt(40, this.get(i).getLastJobServiceYears());
			if(this.get(i).getInsuranceExperience() == null || this.get(i).getInsuranceExperience().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getInsuranceExperience());
			}
			pstmt.setInt(42, this.get(i).getInsuranceExperienceYears());
			if(this.get(i).getEducationLevel() == null || this.get(i).getEducationLevel().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getEducationLevel());
			}
			if(this.get(i).getAddressType() == null || this.get(i).getAddressType().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getAddressType());
			}
			if(this.get(i).getAddressRoom() == null || this.get(i).getAddressRoom().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getAddressRoom());
			}
			if(this.get(i).getAddressFloor() == null || this.get(i).getAddressFloor().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getAddressFloor());
			}
			if(this.get(i).getAddressBlock() == null || this.get(i).getAddressBlock().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getAddressBlock());
			}
			if(this.get(i).getAddressBuilding() == null || this.get(i).getAddressBuilding().equals("null")) {
				pstmt.setString(48,null);
			} else {
				pstmt.setString(48, this.get(i).getAddressBuilding());
			}
			if(this.get(i).getAddressStreet() == null || this.get(i).getAddressStreet().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getAddressStreet());
			}
			if(this.get(i).getAddressDistrict() == null || this.get(i).getAddressDistrict().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getAddressDistrict());
			}
			if(this.get(i).getFreeAddress() == null || this.get(i).getFreeAddress().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getFreeAddress());
			}
			if(this.get(i).getPhone() == null || this.get(i).getPhone().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getPhone());
			}
			if(this.get(i).getMobile() == null || this.get(i).getMobile().equals("null")) {
				pstmt.setString(53,null);
			} else {
				pstmt.setString(53, this.get(i).getMobile());
			}
			if(this.get(i).getEmail() == null || this.get(i).getEmail().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getEmail());
			}
			if(this.get(i).getCompanyEmail() == null || this.get(i).getCompanyEmail().equals("null")) {
				pstmt.setString(55,null);
			} else {
				pstmt.setString(55, this.get(i).getCompanyEmail());
			}
			if(this.get(i).getOfficeAddress() == null || this.get(i).getOfficeAddress().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getOfficeAddress());
			}
			if(this.get(i).getOfficeTel() == null || this.get(i).getOfficeTel().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getOfficeTel());
			}
			if(this.get(i).getOfficeFaxNo() == null || this.get(i).getOfficeFaxNo().equals("null")) {
				pstmt.setString(58,null);
			} else {
				pstmt.setString(58, this.get(i).getOfficeFaxNo());
			}
			if(this.get(i).getMarriage() == null || this.get(i).getMarriage().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getMarriage());
			}
			if(this.get(i).getSpouseName() == null || this.get(i).getSpouseName().equals("null")) {
				pstmt.setString(60,null);
			} else {
				pstmt.setString(60, this.get(i).getSpouseName());
			}
			if(this.get(i).getSpouseIDNo() == null || this.get(i).getSpouseIDNo().equals("null")) {
				pstmt.setString(61,null);
			} else {
				pstmt.setString(61, this.get(i).getSpouseIDNo());
			}
			if(this.get(i).getFlag1() == null || this.get(i).getFlag1().equals("null")) {
				pstmt.setString(62,null);
			} else {
				pstmt.setString(62, this.get(i).getFlag1());
			}
			if(this.get(i).getFlag2() == null || this.get(i).getFlag2().equals("null")) {
				pstmt.setString(63,null);
			} else {
				pstmt.setString(63, this.get(i).getFlag2());
			}
			if(this.get(i).getFlag3() == null || this.get(i).getFlag3().equals("null")) {
				pstmt.setString(64,null);
			} else {
				pstmt.setString(64, this.get(i).getFlag3());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(65,null);
			} else {
				pstmt.setString(65, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(66,null);
			} else {
				pstmt.setDate(66, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(67,null);
			} else {
				pstmt.setString(67, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(68,null);
			} else {
				pstmt.setDate(68, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(69,null);
			} else {
				pstmt.setString(69, this.get(i).getModifyTime());
			}
			if(this.get(i).getLastJobNature() == null || this.get(i).getLastJobNature().equals("null")) {
				pstmt.setString(70,null);
			} else {
				pstmt.setString(70, this.get(i).getLastJobNature());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAgent");
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
			tError.moduleName = "LAAgentDBSet";
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
