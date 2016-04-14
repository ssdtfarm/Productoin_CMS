/*
 * <p>ClassName: LMCalModeDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 险种定义
 * @CreateDate：2004-11-08
 */
package com.sinosoft.lis.vdb;

import com.sinosoft.Resource.bundle;
import java.sql.Connection;

import com.sinosoft.lis.schema.LMCalModeSchema;
import com.sinosoft.lis.vschema.LMCalModeSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.DBOper;

public class LMCalModeDBSet extends LMCalModeSet
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
    public LMCalModeDBSet(Connection tConnection)
    {
        con = tConnection;
        db = new DBOper(con, "LMCalMode");
        mflag = true;
    }

    public LMCalModeDBSet()
    {
        db = new DBOper("LMCalMode");
        // 
    }

    // @Method
    public boolean insert()
    {
        int n = this.size();
        for (int i = 1; i <= n; i++)
        {
            LMCalModeSchema aSchema = new LMCalModeSchema();
            aSchema.setSchema((LMCalModeSchema)this.get(i));
            if (!db.insert(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LMCalModeDBSet";
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
            LMCalModeSchema aSchema = new LMCalModeSchema();
            aSchema.setSchema((LMCalModeSchema)this.get(i));
            if (!db.update(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LMCalModeDBSet";
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
            LMCalModeSchema aSchema = new LMCalModeSchema();
            aSchema.setSchema((LMCalModeSchema)this.get(i));
            if (!db.deleteSQL(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LMCalModeDBSet";
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
            LMCalModeSchema aSchema = new LMCalModeSchema();
            aSchema.setSchema((LMCalModeSchema)this.get(i));
            if (!db.delete(aSchema))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(db.mErrors);
                CError tError = new CError();
                tError.moduleName = "LMCalModeDBSet";
                tError.functionName = "delete";
                tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
                this.mErrors.addOneError(tError);

                return false;
            }
        }
        return true;
    }

}
