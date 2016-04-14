/*
 * <p>ClassName: LDCodeRelaSet </p>
 * <p>Description: LDCodeRelaSchemaSet类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 销售管理
 * @CreateDate：2004-12-20
 */
package com.sinosoft.lis.vschema;

import com.sinosoft.lis.schema.LDCodeRelaSchema;
import com.sinosoft.utility.SchemaSet;
import com.sinosoft.utility.SysConst;

public class LDCodeRelaSet extends SchemaSet
{
    // @Method
    public boolean add(LDCodeRelaSchema aSchema)
    {
        return super.add(aSchema);
    }

    public boolean add(LDCodeRelaSet aSet)
    {
        return super.add(aSet);
    }

    public boolean remove(LDCodeRelaSchema aSchema)
    {
        return super.remove(aSchema);
    }

    public LDCodeRelaSchema get(int index)
    {
        LDCodeRelaSchema tSchema = (LDCodeRelaSchema)super.getObj(index);
        return tSchema;
    }

    public boolean set(int index, LDCodeRelaSchema aSchema)
    {
        return super.set(index, aSchema);
    }

    public boolean set(LDCodeRelaSet aSet)
    {
        return super.set(aSet);
    }

    /**
     * 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCodeRela描述/A>表字段
     * @param: 无
     * @return: 返回打包后字符串
     **/
    public String encode()
    {
        String strReturn = "";
        int n = this.size();
        for (int i = 1; i <= n; i++)
        {
            LDCodeRelaSchema aSchema = (LDCodeRelaSchema)this.get(i);
            strReturn += aSchema.encode();
            if (i != n)
            {
                strReturn += SysConst.RECORDSPLITER;
            }
        }

        return strReturn;
    }

    /**
     * 数据解包
     * @param: 打包后字符串
     * @return: boolean
     **/
    public boolean decode(String str)
    {
        int nBeginPos = 0;
        int nEndPos = str.indexOf('^');
        this.clear();

        while (nEndPos != -1)
        {
            LDCodeRelaSchema aSchema = new LDCodeRelaSchema();
            if (!aSchema.decode(str.substring(nBeginPos, nEndPos)))
            {
                // @@错误处理
                this.mErrors.copyAllErrors(aSchema.mErrors);
                return false;
            }
            this.add(aSchema);
            nBeginPos = nEndPos + 1;
            nEndPos = str.indexOf('^', nEndPos + 1);
        }
        LDCodeRelaSchema tSchema = new LDCodeRelaSchema();
        if (!tSchema.decode(str.substring(nBeginPos)))
        {
            // @@错误处理
            this.mErrors.copyAllErrors(tSchema.mErrors);
            return false;
        }
        this.add(tSchema);

        return true;
    }

}
