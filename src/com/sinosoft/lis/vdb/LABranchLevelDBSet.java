/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import com.sinosoft.Resource.bundle;
import java.sql.*;
import com.sinosoft.lis.schema.LABranchLevelSchema;
import com.sinosoft.lis.vschema.LABranchLevelSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LABranchLevelDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: PhysicalDataModel_1
 * @CreateDate：2005-07-11
 */
public class LABranchLevelDBSet extends LABranchLevelSet
{
	// @Field
	private Connection con;
	private DBOper db;
	/**
	* flag = true: 传入Connection
	* flag = false: 不传入Connection
	**/
	private boolean mflag = false;

	public CErrors mErrors = new CErrors();			// 错误信息

	// @Constructor
	public LABranchLevelDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LABranchLevel");
		mflag = true;
	}

	public LABranchLevelDBSet()
	{
		db = new DBOper( "LABranchLevel" );
		
	}
	// @Method
	public boolean insert()
	{
		if (db.insert(this))
		{
		        return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LABranchLevelDBSet";
			tError.functionName = "insert";
			tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public boolean update()
	{
		if (db.update(this))
		{
		        return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LABranchLevelDBSet";
			tError.functionName = "update";
			tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

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
			tError.moduleName = "LABranchLevelDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public boolean delete()
	{
		if (db.delete(this))
		{
		        return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LABranchLevelDBSet";
			tError.functionName = "delete";
			tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

}
