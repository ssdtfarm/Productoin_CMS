/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.MHonorSchema;
import com.sinosoft.lis.vschema.MHonorSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: MHonorDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class MHonorDB extends MHonorSchema
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
	public MHonorDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "MHonor" );
		mflag = true;
	}

	public MHonorDB()
	{
		con = null;
		db = new DBOper( "MHonor" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		MHonorSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MHonorSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
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
			pstmt = con.prepareStatement("DELETE FROM MHonor WHERE  IDX = ?");
			if(this.getIDX() == null || this.getIDX().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getIDX());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("MHonor");
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
		SQLString sqlObj = new SQLString("MHonor");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE MHonor SET  IDX = ? , StatYear = ? , StatBatch = ? , AgentCode = ? , AgentName = ? , AgentGrade = ? , BranchAttr = ? , AwardType = ? , AwardName = ? , StartDate = ? , EndDate = ? , Remarks = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  IDX = ?");
			if(this.getIDX() == null || this.getIDX().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getIDX());
			}
			if(this.getStatYear() == null || this.getStatYear().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getStatYear());
			}
			if(this.getStatBatch() == null || this.getStatBatch().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getStatBatch());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getAgentCode());
			}
			if(this.getAgentName() == null || this.getAgentName().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getAgentName());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentGrade());
			}
			if(this.getBranchAttr() == null || this.getBranchAttr().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getBranchAttr());
			}
			if(this.getAwardType() == null || this.getAwardType().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getAwardType());
			}
			if(this.getAwardName() == null || this.getAwardName().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getAwardName());
			}
			if(this.getStartDate() == null || this.getStartDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getStartDate()));
			}
			if(this.getEndDate() == null || this.getEndDate().equals("null")) {
				pstmt.setNull(11, 91);
			} else {
				pstmt.setDate(11, Date.valueOf(this.getEndDate()));
			}
			if(this.getRemarks() == null || this.getRemarks().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getRemarks());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(14, 91);
			} else {
				pstmt.setDate(14, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(16, 91);
			} else {
				pstmt.setDate(16, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getModifyTime());
			}
			// set where condition
			if(this.getIDX() == null || this.getIDX().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getIDX());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
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
		SQLString sqlObj = new SQLString("MHonor");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO MHonor VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getIDX() == null || this.getIDX().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getIDX());
			}
			if(this.getStatYear() == null || this.getStatYear().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getStatYear());
			}
			if(this.getStatBatch() == null || this.getStatBatch().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getStatBatch());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getAgentCode());
			}
			if(this.getAgentName() == null || this.getAgentName().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getAgentName());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentGrade());
			}
			if(this.getBranchAttr() == null || this.getBranchAttr().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getBranchAttr());
			}
			if(this.getAwardType() == null || this.getAwardType().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getAwardType());
			}
			if(this.getAwardName() == null || this.getAwardName().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getAwardName());
			}
			if(this.getStartDate() == null || this.getStartDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getStartDate()));
			}
			if(this.getEndDate() == null || this.getEndDate().equals("null")) {
				pstmt.setNull(11, 91);
			} else {
				pstmt.setDate(11, Date.valueOf(this.getEndDate()));
			}
			if(this.getRemarks() == null || this.getRemarks().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getRemarks());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(14, 91);
			} else {
				pstmt.setDate(14, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(16, 91);
			} else {
				pstmt.setDate(16, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getModifyTime());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
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
			pstmt = con.prepareStatement("SELECT * FROM MHonor WHERE  IDX = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getIDX() == null || this.getIDX().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getIDX());
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
					tError.moduleName = "MHonorDB";
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
			tError.moduleName = "MHonorDB";
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

	public MHonorSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MHonorSet aMHonorSet = new MHonorSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 MHonorSchema aSchemaNew = this.getSchema();
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
			 	throw new IllegalArgumentException("Table MHonor is querying for all data!");
			 }
			 mSql.append("select * from MHonor ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				MHonorSchema s1 = new MHonorSchema();
				s1.setSchema(rs,i);
				aMHonorSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
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

		return aMHonorSet;
	}

	public MHonorSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MHonorSet aMHonorSet = new MHonorSet();

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
				MHonorSchema s1 = new MHonorSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "MHonorDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aMHonorSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
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

		return aMHonorSet;
	}

	public MHonorSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MHonorSet aMHonorSet = new MHonorSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("MHonor");
			MHonorSchema aSchema = this.getSchema();
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

				MHonorSchema s1 = new MHonorSchema();
				s1.setSchema(rs,i);
				aMHonorSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
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

		return aMHonorSet;
	}

	public MHonorSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MHonorSet aMHonorSet = new MHonorSet();

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

				MHonorSchema s1 = new MHonorSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "MHonorDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aMHonorSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "MHonorDB";
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

		return aMHonorSet;
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
			SQLString sqlObj = new SQLString("MHonor");
			MHonorSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update MHonor " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "MHonorDB";
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
			tError.moduleName = "MHonorDB";
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
        tError.moduleName = "MHonorDB";
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
        tError.moduleName = "MHonorDB";
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
        tError.moduleName = "MHonorDB";
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
        tError.moduleName = "MHonorDB";
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
 * @return MHonorSet
 */
public MHonorSet getData()
{
    int tCount = 0;
    MHonorSet tMHonorSet = new MHonorSet();
    MHonorSchema tMHonorSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "MHonorDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tMHonorSchema = new MHonorSchema();
        tMHonorSchema.setSchema(mResultSet, 1);
        tMHonorSet.add(tMHonorSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tMHonorSchema = new MHonorSchema();
                tMHonorSchema.setSchema(mResultSet, 1);
                tMHonorSet.add(tMHonorSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "MHonorDB";
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
    return tMHonorSet;
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
            tError.moduleName = "MHonorDB";
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
        tError.moduleName = "MHonorDB";
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
            tError.moduleName = "MHonorDB";
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
        tError.moduleName = "MHonorDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
