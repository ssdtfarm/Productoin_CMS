/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.LCDorRateSchema;
import com.sinosoft.lis.vschema.LCDorRateSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LCDorRateDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LCDorRateDB extends LCDorRateSchema
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
	public LCDorRateDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LCDorRate" );
		mflag = true;
	}

	public LCDorRateDB()
	{
		con = null;
		db = new DBOper( "LCDorRate" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LCDorRateSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LCDorRateSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
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
			pstmt = con.prepareStatement("DELETE FROM LCDorRate WHERE  ProductCode = ?");
			if(this.getProductCode() == null || this.getProductCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getProductCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LCDorRate");
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
		SQLString sqlObj = new SQLString("LCDorRate");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LCDorRate SET  ProductCode = ? , DorRate = ? , EffectiveYM = ? , EffectiveEndYM = ? , DeleteFlag = ? , OperationDate = ? , OPERATOR = ? , MAKEDATE = ? , MAKETIME = ? , MODIFYDATE = ? , MODIFYTIME = ? WHERE  ProductCode = ?");
			if(this.getProductCode() == null || this.getProductCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getProductCode());
			}
			if(this.getDorRate() == null || this.getDorRate().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getDorRate());
			}
			if(this.getEffectiveYM() == null || this.getEffectiveYM().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getEffectiveYM());
			}
			if(this.getEffectiveEndYM() == null || this.getEffectiveEndYM().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getEffectiveEndYM());
			}
			if(this.getDeleteFlag() == null || this.getDeleteFlag().equals("null")) {
				pstmt.setNull(5, 1);
			} else {
				pstmt.setString(5, this.getDeleteFlag());
			}
			if(this.getOperationDate() == null || this.getOperationDate().equals("null")) {
				pstmt.setNull(6, 91);
			} else {
				pstmt.setDate(6, Date.valueOf(this.getOperationDate()));
			}
			if(this.getOPERATOR() == null || this.getOPERATOR().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getOPERATOR());
			}
			if(this.getMAKEDATE() == null || this.getMAKEDATE().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getMAKEDATE()));
			}
			if(this.getMAKETIME() == null || this.getMAKETIME().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getMAKETIME());
			}
			if(this.getMODIFYDATE() == null || this.getMODIFYDATE().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getMODIFYDATE()));
			}
			if(this.getMODIFYTIME() == null || this.getMODIFYTIME().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getMODIFYTIME());
			}
			// set where condition
			if(this.getProductCode() == null || this.getProductCode().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getProductCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
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
		SQLString sqlObj = new SQLString("LCDorRate");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LCDorRate VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getProductCode() == null || this.getProductCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getProductCode());
			}
			if(this.getDorRate() == null || this.getDorRate().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getDorRate());
			}
			if(this.getEffectiveYM() == null || this.getEffectiveYM().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getEffectiveYM());
			}
			if(this.getEffectiveEndYM() == null || this.getEffectiveEndYM().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getEffectiveEndYM());
			}
			if(this.getDeleteFlag() == null || this.getDeleteFlag().equals("null")) {
				pstmt.setNull(5, 1);
			} else {
				pstmt.setString(5, this.getDeleteFlag());
			}
			if(this.getOperationDate() == null || this.getOperationDate().equals("null")) {
				pstmt.setNull(6, 91);
			} else {
				pstmt.setDate(6, Date.valueOf(this.getOperationDate()));
			}
			if(this.getOPERATOR() == null || this.getOPERATOR().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getOPERATOR());
			}
			if(this.getMAKEDATE() == null || this.getMAKEDATE().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getMAKEDATE()));
			}
			if(this.getMAKETIME() == null || this.getMAKETIME().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getMAKETIME());
			}
			if(this.getMODIFYDATE() == null || this.getMODIFYDATE().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getMODIFYDATE()));
			}
			if(this.getMODIFYTIME() == null || this.getMODIFYTIME().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getMODIFYTIME());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
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
			pstmt = con.prepareStatement("SELECT * FROM LCDorRate WHERE  ProductCode = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getProductCode() == null || this.getProductCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getProductCode());
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
					tError.moduleName = "LCDorRateDB";
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
			tError.moduleName = "LCDorRateDB";
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

	public LCDorRateSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LCDorRateSet aLCDorRateSet = new LCDorRateSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 LCDorRateSchema aSchemaNew = this.getSchema();
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
			 	throw new IllegalArgumentException("Table LCDorRate is querying for all data!");
			 }
			 mSql.append("select * from LCDorRate ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LCDorRateSchema s1 = new LCDorRateSchema();
				s1.setSchema(rs,i);
				aLCDorRateSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
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

		return aLCDorRateSet;
	}

	public LCDorRateSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LCDorRateSet aLCDorRateSet = new LCDorRateSet();

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
				LCDorRateSchema s1 = new LCDorRateSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LCDorRateDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLCDorRateSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
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

		return aLCDorRateSet;
	}

	public LCDorRateSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LCDorRateSet aLCDorRateSet = new LCDorRateSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("LCDorRate");
			LCDorRateSchema aSchema = this.getSchema();
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

				LCDorRateSchema s1 = new LCDorRateSchema();
				s1.setSchema(rs,i);
				aLCDorRateSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
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

		return aLCDorRateSet;
	}

	public LCDorRateSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LCDorRateSet aLCDorRateSet = new LCDorRateSet();

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

				LCDorRateSchema s1 = new LCDorRateSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LCDorRateDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLCDorRateSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LCDorRateDB";
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

		return aLCDorRateSet;
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
			SQLString sqlObj = new SQLString("LCDorRate");
			LCDorRateSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LCDorRate " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LCDorRateDB";
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
			tError.moduleName = "LCDorRateDB";
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
        tError.moduleName = "LCDorRateDB";
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
        tError.moduleName = "LCDorRateDB";
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
        tError.moduleName = "LCDorRateDB";
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
        tError.moduleName = "LCDorRateDB";
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
 * @return LCDorRateSet
 */
public LCDorRateSet getData()
{
    int tCount = 0;
    LCDorRateSet tLCDorRateSet = new LCDorRateSet();
    LCDorRateSchema tLCDorRateSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LCDorRateDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLCDorRateSchema = new LCDorRateSchema();
        tLCDorRateSchema.setSchema(mResultSet, 1);
        tLCDorRateSet.add(tLCDorRateSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLCDorRateSchema = new LCDorRateSchema();
                tLCDorRateSchema.setSchema(mResultSet, 1);
                tLCDorRateSet.add(tLCDorRateSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LCDorRateDB";
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
    return tLCDorRateSet;
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
            tError.moduleName = "LCDorRateDB";
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
        tError.moduleName = "LCDorRateDB";
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
            tError.moduleName = "LCDorRateDB";
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
        tError.moduleName = "LCDorRateDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
