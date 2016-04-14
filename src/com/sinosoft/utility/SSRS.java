
package com.sinosoft.utility;

import com.sinosoft.Resource.bundle;
/*******************************************************************************
 * <p>Title: Lis 6.0</p>
 * <p>Description: 中科软人寿保险核心业务管理系统</p>
 * <p>Copyright: Copyright (c) 2005 Sinosoft, Co.Ltd. All Rights Reserved</p>
 * <p>Company: 中科软科技股份有限公司</p>
 * <p>WebSite: http://www.sinosoft.com.cn</p>
 *
 * @author   : sinosoft
 * @version  : 1.00
 * @date     : 2006-11-21
 * @direction: 核心业务管理系统查询数据结果集
 ******************************************************************************/

import java.util.*;

//******************************************************************************


public class SSRS
{
    private Vector RData = new Vector();
    public int MaxCol = 0;
    public int MaxRow = 0;
    public int MaxNumber = 0;
    public CErrors mErrors = new CErrors(); //错误信息
    public boolean ErrorFlag = false;    //false: 无错; true: 有错

    public SSRS() {}

    public SSRS(int nMaxCol)
    {
        MaxCol = nMaxCol;
    }

    public void SetText(String strValue)
    {
        RData.addElement(strValue);
        MaxNumber = RData.size();
        if ((MaxNumber % MaxCol) == 0)
        {
            MaxRow = MaxNumber / MaxCol;
        }
        else
        {
            MaxRow = MaxNumber / MaxCol + 1;
        }

    }

    public String GetText(int cRow, int cCol)
    {
        String Result = new String("");
        int Number = (cRow - 1) * MaxCol + cCol - 1;
        if (Number <= MaxNumber)
        {
            Result = (String)RData.get(Number);
        }
        else
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "SSRS";
            tError.functionName = "GetText";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            this.mErrors.addOneError(tError);
            this.ErrorFlag = true;
        }
        return Result;
    }

    public int getMaxCol()
    {
        return MaxCol;
    }

    public int getMaxRow()
    {
        return MaxRow;
    }

    public int getMaxNumber()
    {
        return MaxNumber;
    }

    public void setMaxCol(int aMaxCol)
    {
        MaxCol = aMaxCol;
    }

    public void setMaxRow(int aMaxRow)
    {
        MaxRow = aMaxRow;
    }

    public void setMaxNumber(int aMaxNumber)
    {
        MaxNumber = aMaxNumber;
    }

    public void Clear()
    {
        RData.clear();
        MaxRow = 0;
        MaxCol = 0;
        MaxNumber = 0;
    }

    public String[] getRowData(int cRow)
    {
        String StrArr[] = new String[MaxCol];
        for (int i = 0; i < MaxCol; i++)
        {
            StrArr[i] = this.GetText(cRow, i + 1);
        }
        return StrArr;
    }

    public String[][] getAllData()
    {
        String StrArr[][] = new String[MaxRow][MaxCol];
        for (int j = 0; j < MaxRow; j++)
        {
            StrArr[j] = this.getRowData(j + 1);
        }
        return StrArr;
    }

    public String encode()
    {
        //XinYQ Modified on 2006-11-21 : 将 String 改造为 StringBuffer, 提高效率
        StringBuffer bufEncodeResult = new StringBuffer();
        if (MaxNumber != 0)
        {
            bufEncodeResult.append("0");
            bufEncodeResult.append(SysConst.PACKAGESPILTER);
            bufEncodeResult.append(String.valueOf(MaxRow));
            bufEncodeResult.append(SysConst.RECORDSPLITER);
            for (int i = 1; i <= MaxRow; i++)
            {
                for (int j = 1; j <= MaxCol; j++)
                {
                    bufEncodeResult.append(GetText(i, j));
                    if (j != MaxCol)
                    {
                        bufEncodeResult.append(SysConst.PACKAGESPILTER);
                    }
                }
                if (i != MaxRow)
                {
                    bufEncodeResult.append(SysConst.RECORDSPLITER);
                }
            }
        }
        return bufEncodeResult.toString();
    }

    public boolean addCol(SSRS aSSRS)
    {
        if (!(this.MaxRow == aSSRS.getMaxRow()))
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "SSRS";
            tError.functionName = "addCol";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            this.mErrors.addOneError(tError);
            return false;
        }
        else
        {
            SSRS bSSRS = null;
            try
            {
                bSSRS = (SSRS)this.clone();
            }
            catch (Exception ex)
            {
                // @@错误处理
                ex.printStackTrace();
                CError tError = new CError();
                tError.moduleName = "SSRS";
                tError.functionName = "addCol";
                tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
                this.mErrors.addOneError(tError);
                return false;
            }
            this.Clear();
            this.setMaxCol(bSSRS.getMaxCol() + aSSRS.getMaxCol());
            //this.setMaxRow(bSSRS.getMaxRow());
            //this.setMaxNumber(bSSRS.getMaxNumber()+aSSRS.getMaxNumber());
            for (int row = 1; row <= aSSRS.getMaxRow(); row++)
            {
                for (int bcol = 1; bcol <= bSSRS.getMaxCol(); bcol++)
                {
                    this.SetText(StrTool.cTrim(bSSRS.GetText(row, bcol)));
                }
                for (int acol = 1; acol <= aSSRS.getMaxCol(); acol++)
                {
                    this.SetText(StrTool.cTrim(aSSRS.GetText(row, acol)));
                }
            }

            return true;
        }
    }

    public boolean addRow(SSRS aSSRS)
    {
        if (!(this.MaxCol == aSSRS.getMaxCol()))
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "SSRS";
            tError.functionName = "addRow";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            this.mErrors.addOneError(tError);
            return false;
        }
        else
        {
            SSRS bSSRS = null;
            try
            {
                bSSRS = (SSRS)this.clone();
            }
            catch (Exception ex)
            {
                // @@错误处理
                ex.printStackTrace();
                CError tError = new CError();
                tError.moduleName = "SSRS";
                tError.functionName = "addRow";
                tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
                this.mErrors.addOneError(tError);
                return false;
            }
            this.Clear();
            this.setMaxCol(bSSRS.getMaxCol());
            //this.setMaxRow(bSSRS.getMaxRow());
            //this.setMaxNumber(bSSRS.getMaxNumber()+aSSRS.getMaxNumber());
            //int totalRow = bSSRS.getMaxRow()+aSSRS.getMaxRow();
            for (int row = 1; row <= bSSRS.getMaxRow(); row++)
            {
                for (int col = 1; col <= bSSRS.getMaxCol(); col++)
                {
                    this.SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
                }
            }
            for (int row = 1; row <= aSSRS.getMaxRow(); row++)
            {
                for (int col = 1; col <= aSSRS.getMaxCol(); col++)
                {
                    this.SetText(StrTool.cTrim(aSSRS.GetText(row, col)));
                }
            }
            return true;
        }
    }

    public Object clone() throws CloneNotSupportedException
    {
        Object tObj = null;
        SSRS tSSRS = new SSRS();
        tSSRS.setMaxCol(this.getMaxCol());
        tSSRS.setMaxNumber(this.getMaxNumber());
        tSSRS.setMaxRow(this.getMaxRow());
        tSSRS.ErrorFlag = this.ErrorFlag;
        tSSRS.mErrors = this.mErrors;
        tSSRS.RData = (Vector)this.RData.clone();
        tObj = tSSRS;
        return tObj;
    }

}
