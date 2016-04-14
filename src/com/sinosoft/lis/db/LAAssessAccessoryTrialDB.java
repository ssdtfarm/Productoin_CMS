/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.LAAssessAccessoryTrialSchema;
import com.sinosoft.lis.vschema.LAAssessAccessoryTrialSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAAssessAccessoryTrialDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LAAssessAccessoryTrialDB extends LAAssessAccessoryTrialSchema
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
	public LAAssessAccessoryTrialDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LAAssessAccessoryTrial" );
		mflag = true;
	}

	public LAAssessAccessoryTrialDB()
	{
		con = null;
		db = new DBOper( "LAAssessAccessoryTrial" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LAAssessAccessoryTrialSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LAAssessAccessoryTrialSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
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
			pstmt = con.prepareStatement("DELETE FROM LAAssessAccessoryTrial WHERE  IndexCalNo = ? AND AssessType = ? AND AgentCode = ? AND BaseCode = ? AND BranchType = ? AND BranchType2 = ?");
			if(this.getIndexCalNo() == null || this.getIndexCalNo().equals("null")) {
				pstmt.setNull(1, 1);
			} else {
				pstmt.setString(1, StrTool.space(this.getIndexCalNo(), 10));
			}
			if(this.getAssessType() == null || this.getAssessType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getAssessType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentCode());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBaseCode());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getBranchType2());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAAssessAccessoryTrial");
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
		SQLString sqlObj = new SQLString("LAAssessAccessoryTrial");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LAAssessAccessoryTrial SET  IndexCalNo = ? , AssessType = ? , AgentCode = ? , BaseCode = ? , BranchType = ? , BranchAttr = ? , AgentGroup = ? , ManageCom = ? , Result = ? , ModifyFlag = ? , AgentGrade = ? , CalAgentGrade = ? , AgentGrade1 = ? , ConFirmer = ? , ConFirmDate = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , BranchType2 = ? , CurrEdorNo = ? , ModifyReason = ? , IsJoin = ? , Salary_Old = ? , Salary_New = ? WHERE  IndexCalNo = ? AND AssessType = ? AND AgentCode = ? AND BaseCode = ? AND BranchType = ? AND BranchType2 = ?");
			if(this.getIndexCalNo() == null || this.getIndexCalNo().equals("null")) {
				pstmt.setNull(1, 1);
			} else {
				pstmt.setString(1, this.getIndexCalNo());
			}
			if(this.getAssessType() == null || this.getAssessType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getAssessType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentCode());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBaseCode());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBranchType());
			}
			if(this.getBranchAttr() == null || this.getBranchAttr().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getBranchAttr());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentGroup());
			}
			if(this.getManageCom() == null || this.getManageCom().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getManageCom());
			}
			if(this.getResult() == null || this.getResult().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getResult());
			}
			if(this.getModifyFlag() == null || this.getModifyFlag().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getModifyFlag());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getAgentGrade());
			}
			if(this.getCalAgentGrade() == null || this.getCalAgentGrade().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getCalAgentGrade());
			}
			if(this.getAgentGrade1() == null || this.getAgentGrade1().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getAgentGrade1());
			}
			if(this.getConFirmer() == null || this.getConFirmer().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getConFirmer());
			}
			if(this.getConFirmDate() == null || this.getConFirmDate().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getConFirmDate()));
			}
			if(this.getState() == null || this.getState().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getState());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(18, 91);
			} else {
				pstmt.setDate(18, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(20, 91);
			} else {
				pstmt.setDate(20, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getModifyTime());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getBranchType2());
			}
			if(this.getCurrEdorNo() == null || this.getCurrEdorNo().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getCurrEdorNo());
			}
			if(this.getModifyReason() == null || this.getModifyReason().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getModifyReason());
			}
			if(this.getIsJoin() == null || this.getIsJoin().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getIsJoin());
			}
			pstmt.setDouble(26, this.getSalary_Old());
			pstmt.setDouble(27, this.getSalary_New());
			// set where condition
			if(this.getIndexCalNo() == null || this.getIndexCalNo().equals("null")) {
				pstmt.setNull(28, 1);
			} else {
				pstmt.setString(28, StrTool.space(this.getIndexCalNo(), 10));
			}
			if(this.getAssessType() == null || this.getAssessType().equals("null")) {
				pstmt.setNull(29, 12);
			} else {
				pstmt.setString(29, this.getAssessType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getAgentCode());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getBaseCode());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getBranchType2());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
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
		SQLString sqlObj = new SQLString("LAAssessAccessoryTrial");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LAAssessAccessoryTrial VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getIndexCalNo() == null || this.getIndexCalNo().equals("null")) {
				pstmt.setNull(1, 1);
			} else {
				pstmt.setString(1, this.getIndexCalNo());
			}
			if(this.getAssessType() == null || this.getAssessType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getAssessType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentCode());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBaseCode());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBranchType());
			}
			if(this.getBranchAttr() == null || this.getBranchAttr().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getBranchAttr());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getAgentGroup());
			}
			if(this.getManageCom() == null || this.getManageCom().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getManageCom());
			}
			if(this.getResult() == null || this.getResult().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getResult());
			}
			if(this.getModifyFlag() == null || this.getModifyFlag().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getModifyFlag());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getAgentGrade());
			}
			if(this.getCalAgentGrade() == null || this.getCalAgentGrade().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getCalAgentGrade());
			}
			if(this.getAgentGrade1() == null || this.getAgentGrade1().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getAgentGrade1());
			}
			if(this.getConFirmer() == null || this.getConFirmer().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getConFirmer());
			}
			if(this.getConFirmDate() == null || this.getConFirmDate().equals("null")) {
				pstmt.setNull(15, 91);
			} else {
				pstmt.setDate(15, Date.valueOf(this.getConFirmDate()));
			}
			if(this.getState() == null || this.getState().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getState());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(18, 91);
			} else {
				pstmt.setDate(18, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(20, 91);
			} else {
				pstmt.setDate(20, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getModifyTime());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getBranchType2());
			}
			if(this.getCurrEdorNo() == null || this.getCurrEdorNo().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getCurrEdorNo());
			}
			if(this.getModifyReason() == null || this.getModifyReason().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getModifyReason());
			}
			if(this.getIsJoin() == null || this.getIsJoin().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getIsJoin());
			}
			pstmt.setDouble(26, this.getSalary_Old());
			pstmt.setDouble(27, this.getSalary_New());
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
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
			pstmt = con.prepareStatement("SELECT * FROM LAAssessAccessoryTrial WHERE  IndexCalNo = ? AND AssessType = ? AND AgentCode = ? AND BaseCode = ? AND BranchType = ? AND BranchType2 = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getIndexCalNo() == null || this.getIndexCalNo().equals("null")) {
				pstmt.setNull(1, 1);
			} else {
				pstmt.setString(1, StrTool.space(this.getIndexCalNo(), 10));
			}
			if(this.getAssessType() == null || this.getAssessType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getAssessType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentCode());
			}
			if(this.getBaseCode() == null || this.getBaseCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getBaseCode());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getBranchType());
			}
			if(this.getBranchType2() == null || this.getBranchType2().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getBranchType2());
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
					tError.moduleName = "LAAssessAccessoryTrialDB";
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
			tError.moduleName = "LAAssessAccessoryTrialDB";
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

	public LAAssessAccessoryTrialSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAAssessAccessoryTrialSet aLAAssessAccessoryTrialSet = new LAAssessAccessoryTrialSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 LAAssessAccessoryTrialSchema aSchemaNew = this.getSchema();
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
			 	throw new IllegalArgumentException("Table LAAssessAccessoryTrial is querying for all data!");
			 }
			 mSql.append("select * from LAAssessAccessoryTrial ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LAAssessAccessoryTrialSchema s1 = new LAAssessAccessoryTrialSchema();
				s1.setSchema(rs,i);
				aLAAssessAccessoryTrialSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
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

		return aLAAssessAccessoryTrialSet;
	}

	public LAAssessAccessoryTrialSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAAssessAccessoryTrialSet aLAAssessAccessoryTrialSet = new LAAssessAccessoryTrialSet();

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
				LAAssessAccessoryTrialSchema s1 = new LAAssessAccessoryTrialSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAAssessAccessoryTrialDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAAssessAccessoryTrialSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
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

		return aLAAssessAccessoryTrialSet;
	}

	public LAAssessAccessoryTrialSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAAssessAccessoryTrialSet aLAAssessAccessoryTrialSet = new LAAssessAccessoryTrialSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("LAAssessAccessoryTrial");
			LAAssessAccessoryTrialSchema aSchema = this.getSchema();
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

				LAAssessAccessoryTrialSchema s1 = new LAAssessAccessoryTrialSchema();
				s1.setSchema(rs,i);
				aLAAssessAccessoryTrialSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
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

		return aLAAssessAccessoryTrialSet;
	}

	public LAAssessAccessoryTrialSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAAssessAccessoryTrialSet aLAAssessAccessoryTrialSet = new LAAssessAccessoryTrialSet();

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

				LAAssessAccessoryTrialSchema s1 = new LAAssessAccessoryTrialSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAAssessAccessoryTrialDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAAssessAccessoryTrialSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAAssessAccessoryTrialDB";
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

		return aLAAssessAccessoryTrialSet;
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
			SQLString sqlObj = new SQLString("LAAssessAccessoryTrial");
			LAAssessAccessoryTrialSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LAAssessAccessoryTrial " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LAAssessAccessoryTrialDB";
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
			tError.moduleName = "LAAssessAccessoryTrialDB";
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
        tError.moduleName = "LAAssessAccessoryTrialDB";
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
        tError.moduleName = "LAAssessAccessoryTrialDB";
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
        tError.moduleName = "LAAssessAccessoryTrialDB";
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
        tError.moduleName = "LAAssessAccessoryTrialDB";
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
 * @return LAAssessAccessoryTrialSet
 */
public LAAssessAccessoryTrialSet getData()
{
    int tCount = 0;
    LAAssessAccessoryTrialSet tLAAssessAccessoryTrialSet = new LAAssessAccessoryTrialSet();
    LAAssessAccessoryTrialSchema tLAAssessAccessoryTrialSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LAAssessAccessoryTrialDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLAAssessAccessoryTrialSchema = new LAAssessAccessoryTrialSchema();
        tLAAssessAccessoryTrialSchema.setSchema(mResultSet, 1);
        tLAAssessAccessoryTrialSet.add(tLAAssessAccessoryTrialSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLAAssessAccessoryTrialSchema = new LAAssessAccessoryTrialSchema();
                tLAAssessAccessoryTrialSchema.setSchema(mResultSet, 1);
                tLAAssessAccessoryTrialSet.add(tLAAssessAccessoryTrialSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LAAssessAccessoryTrialDB";
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
    return tLAAssessAccessoryTrialSet;
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
            tError.moduleName = "LAAssessAccessoryTrialDB";
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
        tError.moduleName = "LAAssessAccessoryTrialDB";
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
            tError.moduleName = "LAAssessAccessoryTrialDB";
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
        tError.moduleName = "LAAssessAccessoryTrialDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
