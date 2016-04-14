/*
 * <p>ClassName: LDCodeRelaDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 销售管理
 * @CreateDate：2004-12-20
 */
package com.sinosoft.lis.vdb;

import com.sinosoft.Resource.bundle;
import java.sql.Connection;

import com.sinosoft.lis.schema.LDCodeRelaSchema;
import com.sinosoft.lis.vschema.LDCodeRelaSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.DBOper;

public class LDCodeRelaDBSet extends LDCodeRelaSet
{
    // @Field
    private Connection con;
    private DBOper db;
    /**
     * flag = true: 传入Connection
     * flag = false: 不传入Connection
     **/
    private boolean mflag = false;

    public CErrors mErrors = new CErrors(); // 错误信息

    // @Constructor
    public LDCodeRelaDBSet(Connection tConnection)
    {
        con = tConnection;
        db = new DBOper(con, "LDCodeRela");
        mflag = true;
    }

    public LDCodeRelaDBSet()
    {
        db = new DBOper("LDCodeRela");
        
    }

    // @Method
    public boolean insert()
    {
        int n = this.size();
        for (int i = 1; i <= n; i++)
        {
            LDCodeRelaSchema aSchema = new LDCodeRelaSchema();
            aSchema.setSchema((LDCodeRelaSchema)this.get(i));
            if (!db.insert(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LDCodeRelaDBSet";
                tError.functionName = "insert";
                tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
                this.mErrors.addOneError(tError);

                return false;
            }
        }
        return true;
    }

    public boolean update()
    {
        int n = this.size();
        for (int i = 1; i <= n; i++)
        {
            LDCodeRelaSchema aSchema = new LDCodeRelaSchema();
            aSchema.setSchema((LDCodeRelaSchema)this.get(i));
            if (!db.update(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LDCodeRelaDBSet";
                tError.functionName = "update";
                tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
                this.mErrors.addOneError(tError);

                return false;
            }
        }
        return true;
    }

    public boolean deleteSQL()
    {
        int n = this.size();
        for (int i = 1; i <= n; i++)
        {
            LDCodeRelaSchema aSchema = new LDCodeRelaSchema();
            aSchema.setSchema((LDCodeRelaSchema)this.get(i));
            if (!db.deleteSQL(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LDCodeRelaDBSet";
                tError.functionName = "deleteSQL";
                tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
                this.mErrors.addOneError(tError);

                return false;
            }
        }
        return true;
    }

    public boolean delete()
    {
        int n = this.size();
        for (int i = 1; i <= n; i++)
        {
            LDCodeRelaSchema aSchema = new LDCodeRelaSchema();
            aSchema.setSchema((LDCodeRelaSchema)this.get(i));
            if (!db.delete(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LDCodeRelaDBSet";
                tError.functionName = "delete";
                tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
                this.mErrors.addOneError(tError);

                return false;
            }
        }
        return true;
    }

}
