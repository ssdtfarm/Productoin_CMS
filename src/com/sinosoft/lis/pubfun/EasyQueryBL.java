/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
import com.sinosoft.utility.*;

/**
 * <p>Title: Web业务系统 </p>
 * <p>Description: BL层业务逻辑处理类 </p>
 * <p>Copyright: Copyright (c) 2002 </p>
 * <p>Company: Sinosoft </p>
 * @author HST
 * @version 1.0
 * @date 2002-09-03
 */
public class EasyQueryBL
{
    /** 传入数据的容器 */
    private VData mInputData = new VData();

    /** 传出数据的容器 */
    private VData mResult = new VData();

    /** 数据操作字符串 */
    private String mOperate;

    /** 错误处理类 */
    public CErrors mErrors = new CErrors();

    /** 业务处理相关变量 */
    private String mSQL = "";
    private int mStart = 1;
    private int mLargeFlag = 0;
    private int mLimitFlag = 0;
    private String mEncodedResult = "";
//    private int mTotalCount;

    // @Constructor
    public EasyQueryBL() {}

    // @Method

    /**
     * 传输数据的公共方法, 本处理没有后续的BLS层，故该方法无用
     * @param cInputData VData
     * @param cOperate String
     * @return boolean
     */
    public boolean submitData(VData cInputData, String cOperate)
    {
        //将传入的数据拷贝到本类中
        mInputData = (VData) cInputData.clone();
        mOperate = cOperate;

        //将外部传入的数据分解到本类的属性中，准备处理
        if (!getInputData())
        {
            return false;
        }

        //查询数据,查询的分支可以根据业务要求放到不同的调用级别中
        if (mOperate.equalsIgnoreCase("QUERY||MAIN"))
        {
            if (!queryData())
            {
                return false;
            }
        }

        return true;
    }


    /**
     * 将外部传入的数据分解到本类的属性中
     * @return boolean
     */
    private boolean getInputData()
    {
        mSQL = (String)mInputData.getObject(0);
        if ((mSQL == null) || mSQL.trim().equals(""))
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "EasyQueryBL";
            tError.functionName = "getInputData";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            mErrors.addOneError(tError);
            return false;
        }
        try
        {
            Object oIntStart = mInputData.getObject(1);
            if (oIntStart != null)
            {
                Integer tStart = (Integer)oIntStart;
                mStart = tStart.intValue();
            }
            Object oIntLargeFlag = mInputData.getObject(2);
            if (oIntLargeFlag != null)
            {
                Integer tLargeFlag = (Integer)oIntLargeFlag;
                mLargeFlag = tLargeFlag.intValue();
            }
            Object oIntLimitFlag = mInputData.getObject(3);
            if (oIntLimitFlag != null)
            {
                Integer tLimitFlag = (Integer)oIntLimitFlag;
                mLimitFlag = tLimitFlag.intValue();
            }
        }
        catch (Exception ex)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "EasyQueryBL";
            tError.functionName = "getInputData";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            mErrors.addOneError(tError);
            return false;
        }

        return true;
    }


    /**
     * 主要信息查询
     * @return: boolean
     */
    private boolean queryData()
    {
        ExeSQL tExeSQL = new ExeSQL();
        //XinYQ modified on 2006-09-30
        if (mLargeFlag <= 0)
        {
            if (mLimitFlag <= 0)
            {
                mEncodedResult = tExeSQL.getEncodedResult(mSQL, mStart);
            }
            else
            {
                mEncodedResult = tExeSQL.getEncodedResultEx(mSQL, mStart);
            }
        }
        else
        {
            mEncodedResult = tExeSQL.getEncodedResultLarge(mSQL, mStart);
        }
        if (tExeSQL.mErrors.needDealError())
        {
            // @@错误处理
            mErrors.copyAllErrors(tExeSQL.mErrors);
            mEncodedResult = "";
            return false;
        }
        else
        {
            mResult.add(mEncodedResult);
        }

        return true;
    }

    /**
     * 数据输出方法，供外界获取数据处理结果
     * @return 包含有数据查询结果字符串的VData对象
     */
    public VData getResult()
    {
        return mResult;
    }

    /**
     * 调试函数
     * @param args String[]
     */
//    public static void main(String[] args)
//    {
////        System.out.println(Character.digit('A', 0));
//    }
}
