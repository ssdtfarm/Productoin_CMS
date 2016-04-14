/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import com.sinosoft.utility.*;

public class LRBomUI {
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    private VData mResult = new VData();
    LRBomBL mBL = new LRBomBL();

    public LRBomUI() {
    }

    /**
     * 传输数据的公共方法
     */
    public boolean submitData(VData cInputData, String cOperate) {
        if (!getInputData(cInputData)) {
            return false;
        }
        // 进行业务处理
        if (!dealData()) {
            return false;
        }
        // 准备往后台的数据
        if (!prepareOutputData()) {
            return false;
        }
        mBL.submitData(cInputData, cOperate);
        // 如果有需要处理的错误，则返回
        if (mBL.mErrors.needDealError()) {
            this.mErrors.copyAllErrors(mBL.mErrors);
            return false;
        } else {
            mResult = mBL.getResult();
        }
        return true;
    }

    /**
     * 从输入数据中得到所有对象
     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
     */
    private boolean getInputData(VData cInputData) {
        return true;
    }

    /**
     * 根据前面的输入数据，进行UI逻辑处理
     * 如果在处理过程中出错，则返回false,否则返回true
     */
    private boolean dealData() {
        return true;
    }

    /**
     * 准备往后层输出所需要的数据
     * 输出：如果准备数据时发生错误则返回false,否则返回true
     */
    private boolean prepareOutputData() {
        return true;
    }

    public VData getResult() {
        return mResult;
    }
}
