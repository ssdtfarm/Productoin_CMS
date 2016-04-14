/*
 * <p>ClassName: LMCalFactorDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 险种定义
 * @CreateDate：2004-11-08
 */
package com.sinosoft.lis.db;

import com.sinosoft.Resource.bundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sinosoft.lis.schema.LMCalFactorSchema;
import com.sinosoft.lis.vschema.LMCalFactorSet;
import com.sinosoft.utility.*;

public class LMCalFactorDB extends LMCalFactorSchema
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
    public LMCalFactorDB(Connection tConnection)
    {
        con = tConnection;
        db = new DBOper(con, "LMCalFactor");
        mflag = true;
    }

    public LMCalFactorDB()
    {
        con = null;
        db = new DBOper("LMCalFactor");
        mflag = false;
    }

    // @Method
    public boolean insert()
    {
        LMCalFactorSchema tSchema = this.getSchema();
        if (!db.insert(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LMCalFactorDB";
            tError.functionName = "insert";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public boolean update()
    {
        LMCalFactorSchema tSchema = this.getSchema();
        if (!db.update(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LMCalFactorDB";
            tError.functionName = "update";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public boolean deleteSQL()
    {
        LMCalFactorSchema tSchema = this.getSchema();
        if (!db.deleteSQL(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LMCalFactorDB";
            tError.functionName = "deleteSQL";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public boolean delete()
    {
        LMCalFactorSchema tSchema = this.getSchema();
        if (!db.delete(tSchema))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LMCalFactorDB";
            tError.functionName = "delete";
            tError.errorMessage = ""+bundle.getString("operatorFaild")+"!";
            this.mErrors.addOneError(tError);

            return false;
        }

        return true;
    }

    public int getCount()
    {
        LMCalFactorSchema tSchema = this.getSchema();

        int tCount = db.getCount(tSchema);
        if (tCount < 0)
        {
            // @@错误处理
            this.mErrors.copyAllErrors(db.mErrors);
            CError tError = new CError();
            tError.moduleName = "LMCalFactorDB";
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
            SQLString sqlObj = new SQLString("LMCalFactor");
            LMCalFactorSchema aSchema = this.getSchema();
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
                    tError.moduleName = "LMCalFactorDB";
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
                tError.moduleName = "LMCalFactorDB";
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
            tError.moduleName = "LMCalFactorDB";
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

    public LMCalFactorSet query()
    {
        Statement stmt = null;
        ResultSet rs = null;
        LMCalFactorSet aLMCalFactorSet = new LMCalFactorSet();

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);
            SQLString sqlObj = new SQLString("LMCalFactor");
            LMCalFactorSchema aSchema = this.getSchema();
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
                                              tError.moduleName = "LMCalFactorDB";
                                              tError.functionName = "executeQuery";
                                              tError.errorMessage = "SQL"+bundle.getString("ErrorMsg")+"";
                                              this.mErrors.addOneError(tError);
                                              break;
                                         }

                LMCalFactorSchema s1 = new LMCalFactorSchema();
                s1.setSchema(rs, i);
                aLMCalFactorSet.add(s1);
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
            tError.moduleName = "LMCalFactorDB";
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

        return aLMCalFactorSet;
    }

    public LMCalFactorSet executeQuery(String sql)
    {
        Statement stmt = null;
        ResultSet rs = null;
        LMCalFactorSet aLMCalFactorSet = new LMCalFactorSet();

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
                                              tError.moduleName = "LMCalFactorDB";
                                              tError.functionName = "executeQuery";
                                              tError.errorMessage = "SQL"+bundle.getString("ErrorMsg")+"";
                                              this.mErrors.addOneError(tError);
                                              break;
                                         }

                LMCalFactorSchema s1 = new LMCalFactorSchema();
                if (!s1.setSchema(rs, i))
                {
                    // @@错误处理
                    CError tError = new CError();
                    tError.moduleName = "LMCalFactorDB";
                    tError.functionName = "executeQuery";
                    tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
                    this.mErrors.addOneError(tError);
                }
                aLMCalFactorSet.add(s1);
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
            tError.moduleName = "LMCalFactorDB";
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

        return aLMCalFactorSet;
    }

    public LMCalFactorSet query(int nStart, int nCount)
    {
        Statement stmt = null;
        ResultSet rs = null;
        LMCalFactorSet aLMCalFactorSet = new LMCalFactorSet();

        if (!mflag)
        {
            con = DBConnPool.getConnection();
        }

        try
        {
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                       ResultSet.CONCUR_READ_ONLY);
            SQLString sqlObj = new SQLString("LMCalFactor");
            LMCalFactorSchema aSchema = this.getSchema();
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

                LMCalFactorSchema s1 = new LMCalFactorSchema();
                s1.setSchema(rs, i);
                aLMCalFactorSet.add(s1);
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
            tError.moduleName = "LMCalFactorDB";
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

        return aLMCalFactorSet;
    }

    public LMCalFactorSet executeQuery(String sql, int nStart, int nCount)
    {
        Statement stmt = null;
        ResultSet rs = null;
        LMCalFactorSet aLMCalFactorSet = new LMCalFactorSet();

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

                LMCalFactorSchema s1 = new LMCalFactorSchema();
                if (!s1.setSchema(rs, i))
                {
                    // @@错误处理
                    CError tError = new CError();
                    tError.moduleName = "LMCalFactorDB";
                    tError.functionName = "executeQuery";
                    tError.errorMessage = "sql"+bundle.getString("ErrorMsg")+"!";
                    this.mErrors.addOneError(tError);
                }
                aLMCalFactorSet.add(s1);
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
            tError.moduleName = "LMCalFactorDB";
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

        return aLMCalFactorSet;
    }

}
