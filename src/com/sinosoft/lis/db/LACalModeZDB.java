/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import com.sinosoft.Resource.bundle;
import java.sql.*;
import com.sinosoft.lis.schema.LACalModeZSchema;
import com.sinosoft.lis.vschema.LACalModeZSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LACalModeZDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: PhysicalDataModel_1
 * @CreateDate：2011-01-04
 */
public class LACalModeZDB extends LACalModeZSchema
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
	public LACalModeZDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LACalModeZ" );
		mflag = true;
	}

	public LACalModeZDB()
	{
		con = null;
		db = new DBOper( "LACalModeZ" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LACalModeZSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LACalModeZSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
			tError.functionName = "getCount";
			tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
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
			pstmt = con.prepareStatement("DELETE FROM LACalModeZ WHERE  CalCode = ?");
			if(this.getCalCode() == null || this.getCalCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCalCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LACalModeZ");
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
		SQLString sqlObj = new SQLString("LACalModeZ");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LACalModeZ SET  CalCode = ? , IndexSeries = ? , EIntroduce = ? , CalSql = ? , ParaType = ? , Introduce = ? , CalRule = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Version = ? , Batch = ? , T1 = ? , T2 = ? , T3 = ? , T4 = ? , T5 = ? , Flag = ? WHERE  CalCode = ?");
			if(this.getCalCode() == null || this.getCalCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCalCode());
			}
			if(this.getIndexSeries() == null || this.getIndexSeries().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexSeries());
			}
			if(this.getEIntroduce() == null || this.getEIntroduce().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getEIntroduce());
			}
			if(this.getCalSql() == null || this.getCalSql().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getCalSql());
			}
			if(this.getParaType() == null || this.getParaType().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getParaType());
			}
			if(this.getIntroduce() == null || this.getIntroduce().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getIntroduce());
			}
			if(this.getCalRule() == null || this.getCalRule().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getCalRule());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(9, 91);
			} else {
				pstmt.setDate(9, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(11, 91);
			} else {
				pstmt.setDate(11, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getModifyTime());
			}
			if(this.getVersion() == null || this.getVersion().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getVersion());
			}
			if(this.getBatch() == null || this.getBatch().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getBatch());
			}
			if(this.getT1() == null || this.getT1().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getT1());
			}
			if(this.getT2() == null || this.getT2().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getT2());
			}
			if(this.getT3() == null || this.getT3().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getT3());
			}
			if(this.getT4() == null || this.getT4().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getT4());
			}
			pstmt.setDouble(19, this.getT5());
			if(this.getFlag() == null || this.getFlag().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getFlag());
			}
			// set where condition
			if(this.getCalCode() == null || this.getCalCode().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getCalCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
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
		SQLString sqlObj = new SQLString("LACalModeZ");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LACalModeZ VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getCalCode() == null || this.getCalCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCalCode());
			}
			if(this.getIndexSeries() == null || this.getIndexSeries().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexSeries());
			}
			if(this.getEIntroduce() == null || this.getEIntroduce().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getEIntroduce());
			}
			if(this.getCalSql() == null || this.getCalSql().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getCalSql());
			}
			if(this.getParaType() == null || this.getParaType().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getParaType());
			}
			if(this.getIntroduce() == null || this.getIntroduce().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getIntroduce());
			}
			if(this.getCalRule() == null || this.getCalRule().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getCalRule());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(8, 12);
			} else {
				pstmt.setString(8, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(9, 91);
			} else {
				pstmt.setDate(9, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(10, 12);
			} else {
				pstmt.setString(10, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(11, 91);
			} else {
				pstmt.setDate(11, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getModifyTime());
			}
			if(this.getVersion() == null || this.getVersion().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getVersion());
			}
			if(this.getBatch() == null || this.getBatch().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getBatch());
			}
			if(this.getT1() == null || this.getT1().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getT1());
			}
			if(this.getT2() == null || this.getT2().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getT2());
			}
			if(this.getT3() == null || this.getT3().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getT3());
			}
			if(this.getT4() == null || this.getT4().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getT4());
			}
			pstmt.setDouble(19, this.getT5());
			if(this.getFlag() == null || this.getFlag().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getFlag());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
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
			pstmt = con.prepareStatement("SELECT * FROM LACalModeZ WHERE  CalCode = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getCalCode() == null || this.getCalCode().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getCalCode());
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
					tError.moduleName = "LACalModeZDB";
					tError.functionName = "getInfo";
					tError.errorMessage = ""+bundle.getString("Dataextractionfailed")+"!";
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
			tError.moduleName = "LACalModeZDB";
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

	public LACalModeZSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LACalModeZSet aLACalModeZSet = new LACalModeZSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			SQLString sqlObj = new SQLString("LACalModeZ");
			LACalModeZSchema aSchema = this.getSchema();
			sqlObj.setSQL(5,aSchema);
			String sql = sqlObj.getSQL();

			rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next())
			{
				i++;
				if (i == 10000) {
                   PubFun.log4moreRecord();
               }
				LACalModeZSchema s1 = new LACalModeZSchema();
				s1.setSchema(rs,i);
				aLACalModeZSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
			tError.functionName = "query";
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

		return aLACalModeZSet;
	}

	public LACalModeZSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LACalModeZSet aLACalModeZSet = new LACalModeZSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			while (rs.next())
			{
				i++;
				if (i == 10000) {
                   PubFun.log4moreRecord();
               }
				LACalModeZSchema s1 = new LACalModeZSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LACalModeZDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
					this.mErrors .addOneError(tError);
				}
				aLACalModeZSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
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

		return aLACalModeZSet;
	}

	public LACalModeZSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LACalModeZSet aLACalModeZSet = new LACalModeZSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			SQLString sqlObj = new SQLString("LACalModeZ");
			LACalModeZSchema aSchema = this.getSchema();
			sqlObj.setSQL(5,aSchema);
			String sql = sqlObj.getSQL();

			rs = stmt.executeQuery(sql);
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

				LACalModeZSchema s1 = new LACalModeZSchema();
				s1.setSchema(rs,i);
				aLACalModeZSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
			tError.functionName = "query";
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

		return aLACalModeZSet;
	}

	public LACalModeZSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LACalModeZSet aLACalModeZSet = new LACalModeZSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
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

				LACalModeZSchema s1 = new LACalModeZSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LACalModeZDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
					this.mErrors .addOneError(tError);
				}
				aLACalModeZSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LACalModeZDB";
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

		return aLACalModeZSet;
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
			SQLString sqlObj = new SQLString("LACalModeZ");
			LACalModeZSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LACalModeZ " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LACalModeZDB";
				tError.functionName = "update";
				tError.errorMessage = ""+bundle.getString("Failed to update the data!")+"!";
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
			tError.moduleName = "LACalModeZDB";
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
        tError.moduleName = "LACalModeZDB";
        tError.functionName = "prepareData";
        tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
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
        tError.moduleName = "LACalModeZDB";
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
        tError.moduleName = "LACalModeZDB";
        tError.functionName = "hasMoreData";
        tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
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
        tError.moduleName = "LACalModeZDB";
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
 * @return LACalModeZSet
 */
public LACalModeZSet getData()
{
    int tCount = 0;
    LACalModeZSet tLACalModeZSet = new LACalModeZSet();
    LACalModeZSchema tLACalModeZSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LACalModeZDB";
        tError.functionName = "getData";
        tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLACalModeZSchema = new LACalModeZSchema();
        tLACalModeZSchema.setSchema(mResultSet, 1);
        tLACalModeZSet.add(tLACalModeZSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLACalModeZSchema = new LACalModeZSchema();
                tLACalModeZSchema.setSchema(mResultSet, 1);
                tLACalModeZSet.add(tLACalModeZSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LACalModeZDB";
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
    return tLACalModeZSet;
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
            tError.moduleName = "LACalModeZDB";
            tError.functionName = "closeData";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
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
        tError.moduleName = "LACalModeZDB";
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
            tError.moduleName = "LACalModeZDB";
            tError.functionName = "closeData";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
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
        tError.moduleName = "LACalModeZDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
