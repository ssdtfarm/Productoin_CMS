/*
 * <p>ClassName: LMCalFactorSet </p>
 * <p>Description: LMCalFactorSchemaSet类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 险种定义
 * @CreateDate：2004-11-08
 */
package com.sinosoft.lis.vschema;

import com.sinosoft.lis.schema.LMCalFactorSchema;
import com.sinosoft.utility.SchemaSet;
import com.sinosoft.utility.SysConst;

public class LMCalFactorSet extends SchemaSet
{
    // @Method
    public boolean add(LMCalFactorSchema aSchema)
    {
        return super.add(aSchema);
    }

    public boolean add(LMCalFactorSet aSet)
    {
        return super.add(aSet);
    }

    public boolean remove(LMCalFactorSchema aSchema)
    {
        return super.remove(aSchema);
    }

    public LMCalFactorSchema get(int index)
    {
        LMCalFactorSchema tSchema = (LMCalFactorSchema)super.getObj(index);
        return tSchema;
    }

    public boolean set(int index, LMCalFactorSchema aSchema)
    {
        return super.set(index, aSchema);
    }

    public boolean set(LMCalFactorSet aSet)
    {
        return super.set(aSet);
    }

    /**
     * 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLMCalFactor描述/A>表字段
     * @param: 无
     * @return: 返回打包后字符串
     **/
    public String encode()
    {
        String strReturn = "";
        int n = this.size();
        for (int i = 1; i <= n; i++)
        {
            LMCalFactorSchema aSchema = (LMCalFactorSchema)this.get(i);
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
            LMCalFactorSchema aSchema = new LMCalFactorSchema();
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
        LMCalFactorSchema tSchema = new LMCalFactorSchema();
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
