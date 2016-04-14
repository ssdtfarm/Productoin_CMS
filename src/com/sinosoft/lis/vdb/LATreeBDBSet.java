/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LATreeBSchema;
import com.sinosoft.lis.vschema.LATreeBSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LATreeBDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: LATreeB
 */
public class LATreeBDBSet extends LATreeBSet
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
	public LATreeBDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LATreeB");
		mflag = true;
	}

	public LATreeBDBSet()
	{
		db = new DBOper( "LATreeB" );
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
			tError.moduleName = "LATreeBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LATreeB WHERE  AgentCode = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getAgentCode());
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
		SQLString sqlObj = new SQLString("LATreeB");
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
			tError.moduleName = "LATreeBDBSet";
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
			pstmt = con.prepareStatement("UPDATE LATreeB SET  AgentCode = ? , BranchType = ? , AgentGroup = ? , ManageCom = ? , AgentGrade = ? , GradeStartDate = ? , AgentSubGrade = ? , SubGradeStartDate = ? , EffectiveDate = ? , TransferEffectiveDate = ? , RegionBranchAttr = ? , DivisionBranchAttr = ? , UnitBranchAttr = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator1 = ? , MakeDate1 = ? , MakeTime1 = ? , NextRegionBranchAttr = ? , NextDivisionBranchAttr = ? , NextUnitBranchAttr = ? , NextRepManagerCode = ? , NextRepManagerName = ? , NextAgentGrade = ? , CurrentRepManagerCode = ? , CurrentRepManagerName = ? , CurrentRepManagerGrade = ? , CurrentName = ? , NextRepManagerGrade = ? , NextEffectiveDate = ? , NextTranEffectiveDate = ? WHERE  AgentCode = ? AND Operator1 = ? AND MakeDate1 = ? AND MakeTime1 = ?");
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
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getAgentGrade());
			}
			if(this.get(i).getGradeStartDate() == null || this.get(i).getGradeStartDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getGradeStartDate()));
			}
			if(this.get(i).getAgentSubGrade() == null || this.get(i).getAgentSubGrade().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getAgentSubGrade());
			}
			if(this.get(i).getSubGradeStartDate() == null || this.get(i).getSubGradeStartDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getSubGradeStartDate()));
			}
			if(this.get(i).getEffectiveDate() == null || this.get(i).getEffectiveDate().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getEffectiveDate()));
			}
			if(this.get(i).getTransferEffectiveDate() == null || this.get(i).getTransferEffectiveDate().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getTransferEffectiveDate()));
			}
			if(this.get(i).getRegionBranchAttr() == null || this.get(i).getRegionBranchAttr().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getRegionBranchAttr());
			}
			if(this.get(i).getDivisionBranchAttr() == null || this.get(i).getDivisionBranchAttr().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getDivisionBranchAttr());
			}
			if(this.get(i).getUnitBranchAttr() == null || this.get(i).getUnitBranchAttr().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getUnitBranchAttr());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(17,null);
			} else {
				pstmt.setDate(17, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(20,null);
			} else {
				pstmt.setDate(20, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getMakeTime1());
			}
			if(this.get(i).getNextRegionBranchAttr() == null || this.get(i).getNextRegionBranchAttr().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getNextRegionBranchAttr());
			}
			if(this.get(i).getNextDivisionBranchAttr() == null || this.get(i).getNextDivisionBranchAttr().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getNextDivisionBranchAttr());
			}
			if(this.get(i).getNextUnitBranchAttr() == null || this.get(i).getNextUnitBranchAttr().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getNextUnitBranchAttr());
			}
			if(this.get(i).getNextRepManagerCode() == null || this.get(i).getNextRepManagerCode().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getNextRepManagerCode());
			}
			if(this.get(i).getNextRepManagerName() == null || this.get(i).getNextRepManagerName().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getNextRepManagerName());
			}
			if(this.get(i).getNextAgentGrade() == null || this.get(i).getNextAgentGrade().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getNextAgentGrade());
			}
			if(this.get(i).getCurrentRepManagerCode() == null || this.get(i).getCurrentRepManagerCode().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getCurrentRepManagerCode());
			}
			if(this.get(i).getCurrentRepManagerName() == null || this.get(i).getCurrentRepManagerName().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getCurrentRepManagerName());
			}
			if(this.get(i).getCurrentRepManagerGrade() == null || this.get(i).getCurrentRepManagerGrade().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getCurrentRepManagerGrade());
			}
			if(this.get(i).getCurrentName() == null || this.get(i).getCurrentName().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getCurrentName());
			}
			if(this.get(i).getNextRepManagerGrade() == null || this.get(i).getNextRepManagerGrade().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getNextRepManagerGrade());
			}
			if(this.get(i).getNextEffectiveDate() == null || this.get(i).getNextEffectiveDate().equals("null")) {
				pstmt.setDate(33,null);
			} else {
				pstmt.setDate(33, Date.valueOf(this.get(i).getNextEffectiveDate()));
			}
			if(this.get(i).getNextTranEffectiveDate() == null || this.get(i).getNextTranEffectiveDate().equals("null")) {
				pstmt.setDate(34,null);
			} else {
				pstmt.setDate(34, Date.valueOf(this.get(i).getNextTranEffectiveDate()));
			}
			// set where condition
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(35,null);
			} else {
				pstmt.setString(35, this.get(i).getAgentCode());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(36,null);
			} else {
				pstmt.setString(36, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(37,null);
			} else {
				pstmt.setDate(37, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(38,null);
			} else {
				pstmt.setString(38, this.get(i).getMakeTime1());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LATreeB");
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
			tError.moduleName = "LATreeBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LATreeB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getAgentGrade());
			}
			if(this.get(i).getGradeStartDate() == null || this.get(i).getGradeStartDate().equals("null")) {
				pstmt.setDate(6,null);
			} else {
				pstmt.setDate(6, Date.valueOf(this.get(i).getGradeStartDate()));
			}
			if(this.get(i).getAgentSubGrade() == null || this.get(i).getAgentSubGrade().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getAgentSubGrade());
			}
			if(this.get(i).getSubGradeStartDate() == null || this.get(i).getSubGradeStartDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getSubGradeStartDate()));
			}
			if(this.get(i).getEffectiveDate() == null || this.get(i).getEffectiveDate().equals("null")) {
				pstmt.setDate(9,null);
			} else {
				pstmt.setDate(9, Date.valueOf(this.get(i).getEffectiveDate()));
			}
			if(this.get(i).getTransferEffectiveDate() == null || this.get(i).getTransferEffectiveDate().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getTransferEffectiveDate()));
			}
			if(this.get(i).getRegionBranchAttr() == null || this.get(i).getRegionBranchAttr().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getRegionBranchAttr());
			}
			if(this.get(i).getDivisionBranchAttr() == null || this.get(i).getDivisionBranchAttr().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getDivisionBranchAttr());
			}
			if(this.get(i).getUnitBranchAttr() == null || this.get(i).getUnitBranchAttr().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getUnitBranchAttr());
			}
			if(this.get(i).getOperator() == null || this.get(i).getOperator().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getOperator());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(17,null);
			} else {
				pstmt.setDate(17, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getModifyTime());
			}
			if(this.get(i).getOperator1() == null || this.get(i).getOperator1().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getOperator1());
			}
			if(this.get(i).getMakeDate1() == null || this.get(i).getMakeDate1().equals("null")) {
				pstmt.setDate(20,null);
			} else {
				pstmt.setDate(20, Date.valueOf(this.get(i).getMakeDate1()));
			}
			if(this.get(i).getMakeTime1() == null || this.get(i).getMakeTime1().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getMakeTime1());
			}
			if(this.get(i).getNextRegionBranchAttr() == null || this.get(i).getNextRegionBranchAttr().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getNextRegionBranchAttr());
			}
			if(this.get(i).getNextDivisionBranchAttr() == null || this.get(i).getNextDivisionBranchAttr().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getNextDivisionBranchAttr());
			}
			if(this.get(i).getNextUnitBranchAttr() == null || this.get(i).getNextUnitBranchAttr().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getNextUnitBranchAttr());
			}
			if(this.get(i).getNextRepManagerCode() == null || this.get(i).getNextRepManagerCode().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getNextRepManagerCode());
			}
			if(this.get(i).getNextRepManagerName() == null || this.get(i).getNextRepManagerName().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getNextRepManagerName());
			}
			if(this.get(i).getNextAgentGrade() == null || this.get(i).getNextAgentGrade().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getNextAgentGrade());
			}
			if(this.get(i).getCurrentRepManagerCode() == null || this.get(i).getCurrentRepManagerCode().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getCurrentRepManagerCode());
			}
			if(this.get(i).getCurrentRepManagerName() == null || this.get(i).getCurrentRepManagerName().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getCurrentRepManagerName());
			}
			if(this.get(i).getCurrentRepManagerGrade() == null || this.get(i).getCurrentRepManagerGrade().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getCurrentRepManagerGrade());
			}
			if(this.get(i).getCurrentName() == null || this.get(i).getCurrentName().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getCurrentName());
			}
			if(this.get(i).getNextRepManagerGrade() == null || this.get(i).getNextRepManagerGrade().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getNextRepManagerGrade());
			}
			if(this.get(i).getNextEffectiveDate() == null || this.get(i).getNextEffectiveDate().equals("null")) {
				pstmt.setDate(33,null);
			} else {
				pstmt.setDate(33, Date.valueOf(this.get(i).getNextEffectiveDate()));
			}
			if(this.get(i).getNextTranEffectiveDate() == null || this.get(i).getNextTranEffectiveDate().equals("null")) {
				pstmt.setDate(34,null);
			} else {
				pstmt.setDate(34, Date.valueOf(this.get(i).getNextTranEffectiveDate()));
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LATreeB");
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
			tError.moduleName = "LATreeBDBSet";
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
