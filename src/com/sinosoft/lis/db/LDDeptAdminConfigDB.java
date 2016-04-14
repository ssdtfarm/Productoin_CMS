/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import com.sinosoft.Resource.bundle;
import java.sql.*;
import com.sinosoft.lis.schema.LDDeptAdminConfigSchema;
import com.sinosoft.lis.vschema.LDDeptAdminConfigSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LDDeptAdminConfigDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 核心业务系统
 * @CreateDate：2011-03-16
 */
public class LDDeptAdminConfigDB extends LDDeptAdminConfigSchema
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
	public LDDeptAdminConfigDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LDDeptAdminConfig" );
		mflag = true;
	}

	public LDDeptAdminConfigDB()
	{
		con = null;
		db = new DBOper( "LDDeptAdminConfig" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LDDeptAdminConfigSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LDDeptAdminConfigSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
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
			pstmt = con.prepareStatement("DELETE FROM LDDeptAdminConfig WHERE  DepNo = ?");
			if(this.getDepNo() == null || this.getDepNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getDepNo());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LDDeptAdminConfig");
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
		SQLString sqlObj = new SQLString("LDDeptAdminConfig");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LDDeptAdminConfig SET  DepNo = ? , DepName = ? , DepLevel = ? , UpDepNo = ? , DepManager = ? , DepManagerName = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  DepNo = ?");
			if(this.getDepNo() == null || this.getDepNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getDepNo());
			}
			if(this.getDepName() == null || this.getDepName().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getDepName());
			}
			if(this.getDepLevel() == null || this.getDepLevel().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getDepLevel());
			}
			if(this.getUpDepNo() == null || this.getUpDepNo().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getUpDepNo());
			}
			if(this.getDepManager() == null || this.getDepManager().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getDepManager());
			}
			if(this.getDepManagerName() == null || this.getDepManagerName().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getDepManagerName());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getModifyTime());
			}
			// set where condition
			if(this.getDepNo() == null || this.getDepNo().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getDepNo());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
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
		SQLString sqlObj = new SQLString("LDDeptAdminConfig");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LDDeptAdminConfig VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getDepNo() == null || this.getDepNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getDepNo());
			}
			if(this.getDepName() == null || this.getDepName().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getDepName());
			}
			if(this.getDepLevel() == null || this.getDepLevel().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getDepLevel());
			}
			if(this.getUpDepNo() == null || this.getUpDepNo().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getUpDepNo());
			}
			if(this.getDepManager() == null || this.getDepManager().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getDepManager());
			}
			if(this.getDepManagerName() == null || this.getDepManagerName().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getDepManagerName());
			}
			if(this.getOperator() == null || this.getOperator().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getOperator());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getModifyTime());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
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
			pstmt = con.prepareStatement("SELECT * FROM LDDeptAdminConfig WHERE  DepNo = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getDepNo() == null || this.getDepNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getDepNo());
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
					tError.moduleName = "LDDeptAdminConfigDB";
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
			tError.moduleName = "LDDeptAdminConfigDB";
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

	public LDDeptAdminConfigSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LDDeptAdminConfigSet aLDDeptAdminConfigSet = new LDDeptAdminConfigSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			SQLString sqlObj = new SQLString("LDDeptAdminConfig");
			LDDeptAdminConfigSchema aSchema = this.getSchema();
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
				LDDeptAdminConfigSchema s1 = new LDDeptAdminConfigSchema();
				s1.setSchema(rs,i);
				aLDDeptAdminConfigSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
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

		return aLDDeptAdminConfigSet;
	}

//	public LDDeptAdminConfigSet executeQuery(String sql)
//	{
//		Statement stmt = null;
//		ResultSet rs = null;
//		LDDeptAdminConfigSet aLDDeptAdminConfigSet = new LDDeptAdminConfigSet();
//
//	  if( !mflag ) {
//		  con = DBConnPool.getConnection();
//		}
//
//		try
//		{
//			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
//
//			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
//			int i = 0;
//			while (rs.next())
//			{
//				i++;
//				if (i == 10000) {
//                   PubFun.log4moreRecord();
//               }
//				LDDeptAdminConfigSchema s1 = new LDDeptAdminConfigSchema();
//				if (!s1.setSchema(rs,i))
//				{
//					// @@错误处理
//					CError tError = new CError();
//					tError.moduleName = "LDDeptAdminConfigDB";
//					tError.functionName = "executeQuery";
//					tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
//					this.mErrors .addOneError(tError);
//				}
//				aLDDeptAdminConfigSet.add(s1);
//			}
//			try{ rs.close(); } catch( Exception ex ) {}
//			try{ stmt.close(); } catch( Exception ex1 ) {}
//		}
//		catch(Exception e)
//	    {
//			// @@错误处理
//			CError tError = new CError();
//			tError.moduleName = "LDDeptAdminConfigDB";
//			tError.functionName = "executeQuery";
//			tError.errorMessage = e.toString();
//			this.mErrors .addOneError(tError);
//
//			try{ rs.close(); } catch( Exception ex2 ) {}
//			try{ stmt.close(); } catch( Exception ex3 ) {}
//
//			if (!mflag)
//			{
//				try
//				{
//					con.close();
//				}
//				catch(Exception et){}
//			}
//	    }
//
//		if (!mflag)
//		{
//			try
//			{
//				con.close();
//			}
//			catch(Exception e){}
//		}
//
//		return aLDDeptAdminConfigSet;
//	}

	public LDDeptAdminConfigSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LDDeptAdminConfigSet aLDDeptAdminConfigSet = new LDDeptAdminConfigSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			SQLString sqlObj = new SQLString("LDDeptAdminConfig");
			LDDeptAdminConfigSchema aSchema = this.getSchema();
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

				LDDeptAdminConfigSchema s1 = new LDDeptAdminConfigSchema();
				s1.setSchema(rs,i);
				aLDDeptAdminConfigSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
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

		return aLDDeptAdminConfigSet;
	}

	public LDDeptAdminConfigSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LDDeptAdminConfigSet aLDDeptAdminConfigSet = new LDDeptAdminConfigSet();

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

				LDDeptAdminConfigSchema s1 = new LDDeptAdminConfigSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LDDeptAdminConfigDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
					this.mErrors .addOneError(tError);
				}
				aLDDeptAdminConfigSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LDDeptAdminConfigDB";
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

		return aLDDeptAdminConfigSet;
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
			SQLString sqlObj = new SQLString("LDDeptAdminConfig");
			LDDeptAdminConfigSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LDDeptAdminConfig " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LDDeptAdminConfigDB";
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
			tError.moduleName = "LDDeptAdminConfigDB";
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
        tError.moduleName = "LDDeptAdminConfigDB";
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
        tError.moduleName = "LDDeptAdminConfigDB";
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
        tError.moduleName = "LDDeptAdminConfigDB";
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
        tError.moduleName = "LDDeptAdminConfigDB";
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
 * @return LDDeptAdminConfigSet
 */
public LDDeptAdminConfigSet getData()
{
    int tCount = 0;
    LDDeptAdminConfigSet tLDDeptAdminConfigSet = new LDDeptAdminConfigSet();
    LDDeptAdminConfigSchema tLDDeptAdminConfigSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LDDeptAdminConfigDB";
        tError.functionName = "getData";
        tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLDDeptAdminConfigSchema = new LDDeptAdminConfigSchema();
        tLDDeptAdminConfigSchema.setSchema(mResultSet, 1);
        tLDDeptAdminConfigSet.add(tLDDeptAdminConfigSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLDDeptAdminConfigSchema = new LDDeptAdminConfigSchema();
                tLDDeptAdminConfigSchema.setSchema(mResultSet, 1);
                tLDDeptAdminConfigSet.add(tLDDeptAdminConfigSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LDDeptAdminConfigDB";
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
    return tLDDeptAdminConfigSet;
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
            tError.moduleName = "LDDeptAdminConfigDB";
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
        tError.moduleName = "LDDeptAdminConfigDB";
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
            tError.moduleName = "LDDeptAdminConfigDB";
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
        tError.moduleName = "LDDeptAdminConfigDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
