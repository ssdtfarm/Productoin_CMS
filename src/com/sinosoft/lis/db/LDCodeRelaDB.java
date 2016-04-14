/*
 * <p>ClassName: LDCodeRelaDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 销售管理
 * @CreateDate：2004-12-20
 */
package com.sinosoft.lis.db;

import com.sinosoft.Resource.bundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sinosoft.lis.schema.LDCodeRelaSchema;
import com.sinosoft.lis.vschema.LDCodeRelaSet;
import com.sinosoft.utility.*;

public class LDCodeRelaDB extends LDCodeRelaSchema
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
    public LDCodeRelaDB(Connection tConnection)
    {
        con = tConnection;
        db = new DBOper(con, "LDCodeRela");
        mflag = true;
    }

    public LDCodeRelaDB()
    {
        con = null;
        db = new DBOper("LDCodeRela");
        mflag = false;
    }

    // @Method
    public boolean insert()
    {
        LDCodeRelaSchema tSchema = this.getSchema();
        if (!db.insert(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "insert";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public boolean update()
    {
        LDCodeRelaSchema tSchema = this.getSchema();
        if (!db.update(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "update";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public boolean deleteSQL()
    {
        LDCodeRelaSchema tSchema = this.getSchema();
        if (!db.deleteSQL(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "deleteSQL";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public boolean delete()
    {
        LDCodeRelaSchema tSchema = this.getSchema();
        if (!db.delete(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "delete";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public int getCount()
    {
        LDCodeRelaSchema tSchema = this.getSchema();

        int tCount = db.getCount(tSchema);
        if (tCount < 0)
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "getCount";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return -1;
        }

        return tCount;
    }

    public boolean getInfo()
    {
        Statement stmt = null;
        ResultSet rs = null;

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);
            SQLString sqlObj = new SQLString("LDCodeRela");
            LDCodeRelaSchema aSchema = this.getSchema();
            sqlObj.setSQL(6, aSchema);
            String sql = sqlObj.getSQL();

            rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next())
            {
                i++;
                if (!this.setSchema(rs, i))
                {
                    // @@错误处理
                    CError tError = new CError();
                    tError.moduleName = "LDCodeRelaDB";
                    tError.functionName = "getInfo";
                    tError.errorMessage = ""+bundle.getString("Dataextractionfailed")+"!";
                    this.mErrors.addOneError(tError);

                    try
                    {
                        rs.close();
                    }
                    catch (Exception ex)
                    {}
                    try
                    {
                        stmt.close();
                    }
                    catch (Exception ex1)
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
                break;
            }
            try
            {
                rs.close();
            }
            catch (Exception ex2)
            {}
            try
            {
                stmt.close();
            }
            catch (Exception ex3)
            {}

            if (i == 0)
            {
                // @@错误处理
                CError tError = new CError();
                tError.moduleName = "LDCodeRelaDB";
                tError.functionName = "getInfo";
                tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
                this.mErrors.addOneError(tError);

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
        }
        catch (Exception e)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "getInfo";
            tError.errorMessage = e.toString();
            this.mErrors.addOneError(tError);

            try
            {
                rs.close();
            }
            catch (Exception ex)
            {}
            try
            {
                stmt.close();
            }
            catch (Exception ex1)
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
        // 断开数据库连接
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

    public LDCodeRelaSet query()
    {
        Statement stmt = null;
        ResultSet rs = null;
        LDCodeRelaSet aLDCodeRelaSet = new LDCodeRelaSet();

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);
            SQLString sqlObj = new SQLString("LDCodeRela");
            LDCodeRelaSchema aSchema = this.getSchema();
            sqlObj.setSQL(5, aSchema);
            String sql = sqlObj.getSQL();

            rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next())
            {
                i++;
                                    if(i>10000)
                                         {
                                              CError tError = new CError();
                                              tError.moduleName = "LDCodeRelaDB";
                                              tError.functionName = "executeQuery";
                                              tError.errorMessage = "SQL"+bundle.getString("ErrorMsg")+"";
                                              this.mErrors.addOneError(tError);
                                              break;
                                         }

                LDCodeRelaSchema s1 = new LDCodeRelaSchema();
                s1.setSchema(rs, i);
                aLDCodeRelaSet.add(s1);
            }
            try
            {
                rs.close();
            }
            catch (Exception ex)
            {}
            try
            {
                stmt.close();
            }
            catch (Exception ex1)
            {}
        }
        catch (Exception e)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "query";
            tError.errorMessage = e.toString();
            this.mErrors.addOneError(tError);

            try
            {
                rs.close();
            }
            catch (Exception ex2)
            {}
            try
            {
                stmt.close();
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

        return aLDCodeRelaSet;
    }

    public LDCodeRelaSet executeQuery(String sql)
    {
        Statement stmt = null;
        ResultSet rs = null;
        LDCodeRelaSet aLDCodeRelaSet = new LDCodeRelaSet();

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);

            rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
            int i = 0;
            while (rs.next())
            {
                i++;
                                    if(i>10000)
                                         {
                                              CError tError = new CError();
                                              tError.moduleName = "LDCodeRelaDB";
                                              tError.functionName = "executeQuery";
                                              tError.errorMessage = "SQL"+bundle.getString("ErrorMsg")+"";
                                              this.mErrors.addOneError(tError);
                                              break;
                                         }

                LDCodeRelaSchema s1 = new LDCodeRelaSchema();
                if (!s1.setSchema(rs, i))
                {
                    // @@错误处理
                    CError tError = new CError();
                    tError.moduleName = "LDCodeRelaDB";
                    tError.functionName = "executeQuery";
                    tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
                    this.mErrors.addOneError(tError);
                }
                aLDCodeRelaSet.add(s1);
            }
            try
            {
                rs.close();
            }
            catch (Exception ex)
            {}
            try
            {
                stmt.close();
            }
            catch (Exception ex1)
            {}
        }
        catch (Exception e)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "executeQuery";
            tError.errorMessage = e.toString();
            this.mErrors.addOneError(tError);

            try
            {
                rs.close();
            }
            catch (Exception ex2)
            {}
            try
            {
                stmt.close();
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

        return aLDCodeRelaSet;
    }

    public LDCodeRelaSet query(int nStart, int nCount)
    {
        Statement stmt = null;
        ResultSet rs = null;
        LDCodeRelaSet aLDCodeRelaSet = new LDCodeRelaSet();

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);
            SQLString sqlObj = new SQLString("LDCodeRela");
            LDCodeRelaSchema aSchema = this.getSchema();
            sqlObj.setSQL(5, aSchema);
            String sql = sqlObj.getSQL();

            rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next())
            {
                i++;

                if (i < nStart)
                {
                    continue;
                }

                if (i >= nStart + nCount)
                {
                    break;
                }

                LDCodeRelaSchema s1 = new LDCodeRelaSchema();
                s1.setSchema(rs, i);
                aLDCodeRelaSet.add(s1);
            }
            try
            {
                rs.close();
            }
            catch (Exception ex)
            {}
            try
            {
                stmt.close();
            }
            catch (Exception ex1)
            {}
        }
        catch (Exception e)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "query";
            tError.errorMessage = e.toString();
            this.mErrors.addOneError(tError);

            try
            {
                rs.close();
            }
            catch (Exception ex2)
            {}
            try
            {
                stmt.close();
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

        return aLDCodeRelaSet;
    }

    public LDCodeRelaSet executeQuery(String sql, int nStart, int nCount)
    {
        Statement stmt = null;
        ResultSet rs = null;
        LDCodeRelaSet aLDCodeRelaSet = new LDCodeRelaSet();

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);

            rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
            int i = 0;
            while (rs.next())
            {
                i++;

                if (i < nStart)
                {
                    continue;
                }

                if (i >= nStart + nCount)
                {
                    break;
                }

                LDCodeRelaSchema s1 = new LDCodeRelaSchema();
                if (!s1.setSchema(rs, i))
                {
                    // @@错误处理
                    CError tError = new CError();
                    tError.moduleName = "LDCodeRelaDB";
                    tError.functionName = "executeQuery";
                    tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
                    this.mErrors.addOneError(tError);
                }
                aLDCodeRelaSet.add(s1);
            }
            try
            {
                rs.close();
            }
            catch (Exception ex)
            {}
            try
            {
                stmt.close();
            }
            catch (Exception ex1)
            {}
        }
        catch (Exception e)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "executeQuery";
            tError.errorMessage = e.toString();
            this.mErrors.addOneError(tError);

            try
            {
                rs.close();
            }
            catch (Exception ex2)
            {}
            try
            {
                stmt.close();
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

        return aLDCodeRelaSet;
    }

    public boolean update(String strWherePart)
    {
        Statement stmt = null;

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);
            SQLString sqlObj = new SQLString("LDCodeRela");
            LDCodeRelaSchema aSchema = this.getSchema();
            sqlObj.setSQL(2, aSchema);
            String sql = "update LDCodeRela " + sqlObj.getUpdPart() + " where " +
                         strWherePart;

            int operCount = stmt.executeUpdate(sql);
            if (operCount == 0)
            {
                // @@错误处理
                CError tError = new CError();
                tError.moduleName = "LDCodeRelaDB";
                tError.functionName = "update";
                tError.errorMessage = ""+bundle.getString("Failed to update the data!")+"!";
                this.mErrors.addOneError(tError);

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
        }
        catch (Exception e)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaDB";
            tError.functionName = "update";
            tError.errorMessage = e.toString();
            this.mErrors.addOneError(tError);

            try
            {
                stmt.close();
            }
            catch (Exception ex1)
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
        // 断开数据库连接
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

}
