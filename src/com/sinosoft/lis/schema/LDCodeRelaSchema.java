/*
 * <p>ClassName: LDCodeRelaSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: sinosoft </p>
 * @Database: 销售管理
 * @CreateDate：2004-12-20
 */
package com.sinosoft.lis.schema;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sinosoft.lis.db.LDCodeRelaDB;
import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.Schema;
import com.sinosoft.utility.StrTool;
import com.sinosoft.utility.SysConst;

public class LDCodeRelaSchema implements Schema
{
    // @Field
    /** 控制编码 */
    private String RelaType;
    /** 代码1 */
    private String Code1;
    /** 代码2 */
    private String Code2;
    /** 代码3 */
    private String Code3;
    /** 控制说明 */
    private String Description;
    /** 其它标志 */
    private String OtherSign;

    public static final int FIELDNUM = 6; // 数据库表的字段个数

    private static String[] PK; // 主键

    private FDate fDate = new FDate(); // 处理日期

    public CErrors mErrors; // 错误信息

    // @Constructor
    public LDCodeRelaSchema()
    {
        mErrors = new CErrors();

        String[] pk = new String[4];
        pk[0] = "RelaType";
        pk[1] = "Code1";
        pk[2] = "Code2";
        pk[3] = "Code3";

        PK = pk;
    }

    // @Method
    public String[] getPK()
    {
        return PK;
    }

    public String getRelaType()
    {
        if (RelaType != null && !RelaType.equals("") && SysConst.CHANGECHARSET)
        {
            RelaType = StrTool.unicodeToGBK(RelaType);
        }
        return RelaType;
    }

    public void setRelaType(String aRelaType)
    {
        RelaType = aRelaType;
    }

    public String getCode1()
    {
        if (Code1 != null && !Code1.equals("") && SysConst.CHANGECHARSET)
        {
            Code1 = StrTool.unicodeToGBK(Code1);
        }
        return Code1;
    }

    public void setCode1(String aCode1)
    {
        Code1 = aCode1;
    }

    public String getCode2()
    {
        if (Code2 != null && !Code2.equals("") && SysConst.CHANGECHARSET)
        {
            Code2 = StrTool.unicodeToGBK(Code2);
        }
        return Code2;
    }

    public void setCode2(String aCode2)
    {
        Code2 = aCode2;
    }

    public String getCode3()
    {
        if (Code3 != null && !Code3.equals("") && SysConst.CHANGECHARSET)
        {
            Code3 = StrTool.unicodeToGBK(Code3);
        }
        return Code3;
    }

    public void setCode3(String aCode3)
    {
        Code3 = aCode3;
    }

    public String getDescription()
    {
        if (Description != null && !Description.equals("") &&
            SysConst.CHANGECHARSET)
        {
            Description = StrTool.unicodeToGBK(Description);
        }
        return Description;
    }

    public void setDescription(String aDescription)
    {
        Description = aDescription;
    }

    public String getOtherSign()
    {
        if (OtherSign != null && !OtherSign.equals("") &&
            SysConst.CHANGECHARSET)
        {
            OtherSign = StrTool.unicodeToGBK(OtherSign);
        }
        return OtherSign;
    }

    public void setOtherSign(String aOtherSign)
    {
        OtherSign = aOtherSign;
    }

    /**
     * 使用另外一个 LDCodeRelaSchema 对象给 Schema 赋值
     * @param: Schema 对象
     * @return: 无
     **/
    public void setSchema(LDCodeRelaSchema aLDCodeRelaSchema)
    {
        this.RelaType = aLDCodeRelaSchema.getRelaType();
        this.Code1 = aLDCodeRelaSchema.getCode1();
        this.Code2 = aLDCodeRelaSchema.getCode2();
        this.Code3 = aLDCodeRelaSchema.getCode3();
        this.Description = aLDCodeRelaSchema.getDescription();
        this.OtherSign = aLDCodeRelaSchema.getOtherSign();
    }

    /**
     * 使用 ResultSet 中的第 i 行给 Schema 赋值
     * @param: ResultSet 对象; i 行数
     * @return: boolean
     **/
    public boolean setSchema(ResultSet rs, int i)
    {
        try
        {
            //rs.absolute(i);		// 非滚动游标
            if (rs.getString("RelaType") == null)
            {
                this.RelaType = null;
            }
            else
            {
                this.RelaType = rs.getString("RelaType").trim();
            }

            if (rs.getString("Code1") == null)
            {
                this.Code1 = null;
            }
            else
            {
                this.Code1 = rs.getString("Code1").trim();
            }

            if (rs.getString("Code2") == null)
            {
                this.Code2 = null;
            }
            else
            {
                this.Code2 = rs.getString("Code2").trim();
            }

            if (rs.getString("Code3") == null)
            {
                this.Code3 = null;
            }
            else
            {
                this.Code3 = rs.getString("Code3").trim();
            }

            if (rs.getString("Description") == null)
            {
                this.Description = null;
            }
            else
            {
                this.Description = rs.getString("Description").trim();
            }

            if (rs.getString("OtherSign") == null)
            {
                this.OtherSign = null;
            }
            else
            {
                this.OtherSign = rs.getString("OtherSign").trim();
            }

        }
        catch (SQLException sqle)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaSchema";
            tError.functionName = "setSchema";
            tError.errorMessage = sqle.toString();
            this.mErrors.addOneError(tError);

            return false;
        }
        return true;
    }

    public LDCodeRelaSchema getSchema()
    {
        LDCodeRelaSchema aLDCodeRelaSchema = new LDCodeRelaSchema();
        aLDCodeRelaSchema.setSchema(this);
        return aLDCodeRelaSchema;
    }

    public LDCodeRelaDB getDB()
    {
        LDCodeRelaDB aDBOper = new LDCodeRelaDB();
        aDBOper.setSchema(this);
        return aDBOper;
    }


    /**
     * 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCodeRela描述/A>表字段
     * @param: 无
     * @return: 返回打包后字符串
     **/
    public String encode()
    {
        String strReturn = "";
        strReturn = StrTool.cTrim(StrTool.unicodeToGBK(RelaType)) +
                    SysConst.PACKAGESPILTER
                    + StrTool.cTrim(StrTool.unicodeToGBK(Code1)) +
                    SysConst.PACKAGESPILTER
                    + StrTool.cTrim(StrTool.unicodeToGBK(Code2)) +
                    SysConst.PACKAGESPILTER
                    + StrTool.cTrim(StrTool.unicodeToGBK(Code3)) +
                    SysConst.PACKAGESPILTER
                    + StrTool.cTrim(StrTool.unicodeToGBK(Description)) +
                    SysConst.PACKAGESPILTER
                    + StrTool.cTrim(StrTool.unicodeToGBK(OtherSign));
        return strReturn;
    }

    /**
     * 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLDCodeRela>历史记账凭证主表信息</A>表字段
     * @param: strMessage：包含一条纪录数据的字符串
     * @return: boolean
     **/
    public boolean decode(String strMessage)
    {
        try
        {
            RelaType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1,
                                      SysConst.PACKAGESPILTER);
            Code1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2,
                                   SysConst.PACKAGESPILTER);
            Code2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3,
                                   SysConst.PACKAGESPILTER);
            Code3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4,
                                   SysConst.PACKAGESPILTER);
            Description = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5,
                                         SysConst.PACKAGESPILTER);
            OtherSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6,
                                       SysConst.PACKAGESPILTER);
        }
        catch (NumberFormatException ex)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDCodeRelaSchema";
            tError.functionName = "decode";
            tError.errorMessage = ex.toString();
            this.mErrors.addOneError(tError);

            return false;
        }
        return true;
    }

    /**
     * 取得对应传入参数的String形式的字段值
     * @param: FCode 希望取得的字段名
     * @return: FValue String形式的字段值
     *			FValue = ""		没有匹配的字段
     *			FValue = "null"	字段值为null
     **/
    public String getV(String FCode)
    {
        String strReturn = "";
        if (FCode.equals("RelaType"))
        {
            strReturn = StrTool.GBKToUnicode(String.valueOf(RelaType));
        }
        if (FCode.equals("Code1"))
        {
            strReturn = StrTool.GBKToUnicode(String.valueOf(Code1));
        }
        if (FCode.equals("Code2"))
        {
            strReturn = StrTool.GBKToUnicode(String.valueOf(Code2));
        }
        if (FCode.equals("Code3"))
        {
            strReturn = StrTool.GBKToUnicode(String.valueOf(Code3));
        }
        if (FCode.equals("Description"))
        {
            strReturn = StrTool.GBKToUnicode(String.valueOf(Description));
        }
        if (FCode.equals("OtherSign"))
        {
            strReturn = StrTool.GBKToUnicode(String.valueOf(OtherSign));
        }
        if (strReturn.equals(""))
        {
            strReturn = "null";
        }

        return strReturn;
    }


    /**
     * 取得Schema中指定索引值所对应的字段值
     * @param: nFieldIndex 指定的字段索引值
     * @return: 字段值。
     *          如果没有对应的字段，返回""
     *          如果字段值为空，返回"null"
     **/
    public String getV(int nFieldIndex)
    {
        String strFieldValue = "";
        switch (nFieldIndex)
        {
            case 0:
                strFieldValue = StrTool.GBKToUnicode(RelaType);
                break;
            case 1:
                strFieldValue = StrTool.GBKToUnicode(Code1);
                break;
            case 2:
                strFieldValue = StrTool.GBKToUnicode(Code2);
                break;
            case 3:
                strFieldValue = StrTool.GBKToUnicode(Code3);
                break;
            case 4:
                strFieldValue = StrTool.GBKToUnicode(Description);
                break;
            case 5:
                strFieldValue = StrTool.GBKToUnicode(OtherSign);
                break;
            default:
                strFieldValue = "";
        }
        ;
        if (strFieldValue.equals(""))
        {
            strFieldValue = "null";
        }
        return strFieldValue;
    }

    /**
     * 设置对应传入参数的String形式的字段值
     * @param: FCode 希望取得的字段名
     * @return: FValue String形式的字段值
     *			FValue = ""		没有匹配的字段
     *			FValue = "null"	字段值为null
     **/
    public boolean setV(String FCode, String FValue)
    {
        if (StrTool.cTrim(FCode).equals(""))
        {
            return false;
        }

        if (FCode.equals("RelaType"))
        {
            if (FValue != null && !FValue.equals(""))
            {
                RelaType = FValue.trim();
            }
            else
            {
                RelaType = null;
            }
        }
        if (FCode.equals("Code1"))
        {
            if (FValue != null && !FValue.equals(""))
            {
                Code1 = FValue.trim();
            }
            else
            {
                Code1 = null;
            }
        }
        if (FCode.equals("Code2"))
        {
            if (FValue != null && !FValue.equals(""))
            {
                Code2 = FValue.trim();
            }
            else
            {
                Code2 = null;
            }
        }
        if (FCode.equals("Code3"))
        {
            if (FValue != null && !FValue.equals(""))
            {
                Code3 = FValue.trim();
            }
            else
            {
                Code3 = null;
            }
        }
        if (FCode.equals("Description"))
        {
            if (FValue != null && !FValue.equals(""))
            {
                Description = FValue.trim();
            }
            else
            {
                Description = null;
            }
        }
        if (FCode.equals("OtherSign"))
        {
            if (FValue != null && !FValue.equals(""))
            {
                OtherSign = FValue.trim();
            }
            else
            {
                OtherSign = null;
            }
        }
        return true;
    }

    public boolean equals(Object otherObject)
    {
        if (this == otherObject)
        {
            return true;
        }
        if (otherObject == null)
        {
            return false;
        }
        if (getClass() != otherObject.getClass())
        {
            return false;
        }
        LDCodeRelaSchema other = (LDCodeRelaSchema) otherObject;
        return
                RelaType.equals(other.getRelaType())
                && Code1.equals(other.getCode1())
                && Code2.equals(other.getCode2())
                && Code3.equals(other.getCode3())
                && Description.equals(other.getDescription())
                && OtherSign.equals(other.getOtherSign());
    }

    /**
     * 取得Schema拥有字段的数量
     **/
    public int getFieldCount()
    {
        return FIELDNUM;
    }

    /**
     * 取得Schema中指定字段名所对应的索引值
     * 如果没有对应的字段，返回-1
     **/
    public int getFieldIndex(String strFieldName)
    {
        if (strFieldName.equals("RelaType"))
        {
            return 0;
        }
        if (strFieldName.equals("Code1"))
        {
            return 1;
        }
        if (strFieldName.equals("Code2"))
        {
            return 2;
        }
        if (strFieldName.equals("Code3"))
        {
            return 3;
        }
        if (strFieldName.equals("Description"))
        {
            return 4;
        }
        if (strFieldName.equals("OtherSign"))
        {
            return 5;
        }
        return -1;
    }

    /**
     * 取得Schema中指定索引值所对应的字段名
     * 如果没有对应的字段，返回""
     **/
    public String getFieldName(int nFieldIndex)
    {
        String strFieldName = "";
        switch (nFieldIndex)
        {
            case 0:
                strFieldName = "RelaType";
                break;
            case 1:
                strFieldName = "Code1";
                break;
            case 2:
                strFieldName = "Code2";
                break;
            case 3:
                strFieldName = "Code3";
                break;
            case 4:
                strFieldName = "Description";
                break;
            case 5:
                strFieldName = "OtherSign";
                break;
            default:
                strFieldName = "";
        }
        ;
        return strFieldName;
    }

    /**
     * 取得Schema中指定字段名所对应的字段类型
     * 如果没有对应的字段，返回Schema.TYPE_NOFOUND
     **/
    public int getFieldType(String strFieldName)
    {
        if (strFieldName.equals("RelaType"))
        {
            return Schema.TYPE_STRING;
        }
        if (strFieldName.equals("Code1"))
        {
            return Schema.TYPE_STRING;
        }
        if (strFieldName.equals("Code2"))
        {
            return Schema.TYPE_STRING;
        }
        if (strFieldName.equals("Code3"))
        {
            return Schema.TYPE_STRING;
        }
        if (strFieldName.equals("Description"))
        {
            return Schema.TYPE_STRING;
        }
        if (strFieldName.equals("OtherSign"))
        {
            return Schema.TYPE_STRING;
        }
        return Schema.TYPE_NOFOUND;
    }

    /**
     * 取得Schema中指定索引值所对应的字段类型
     * 如果没有对应的字段，返回Schema.TYPE_NOFOUND
     **/
    public int getFieldType(int nFieldIndex)
    {
        int nFieldType = Schema.TYPE_NOFOUND;
        switch (nFieldIndex)
        {
            case 0:
                nFieldType = Schema.TYPE_STRING;
                break;
            case 1:
                nFieldType = Schema.TYPE_STRING;
                break;
            case 2:
                nFieldType = Schema.TYPE_STRING;
                break;
            case 3:
                nFieldType = Schema.TYPE_STRING;
                break;
            case 4:
                nFieldType = Schema.TYPE_STRING;
                break;
            case 5:
                nFieldType = Schema.TYPE_STRING;
                break;
            default:
                nFieldType = Schema.TYPE_NOFOUND;
        }
        ;
        return nFieldType;
    }
}
