/*
 *************************************************************************
 * Copyright (C) 2010-2015, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.SystemConfiguration;

import java.util.*;
import com.sinosoft.lis.schema.*;
import com.sinosoft.lis.vschema.*;
import com.sinosoft.lis.db.*;
import com.sinosoft.lis.vdb.*;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

public class PullDownListSettingBL {
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    private String mOperate;// 数据操作字符串
    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
    private MMap mMap = new MMap();
    private VData mResult = new VData();// 存放返回数据的容器

    LDCodeSchema mLDCodeSchema = new LDCodeSchema();
    Msg_InfoSchema mMsg_InfoSchema = new Msg_InfoSchema();
    List mDataGrid = new ArrayList();//查询结果

    private String currentDate = PubFun.getCurrentDate();
    private String currentTime = PubFun.getCurrentTime();

    public PullDownListSettingBL() {
    }

    /**
     * 传输数据的公共方法
     */
    public boolean check() {
        return true;
    }

    public boolean submitData(VData cInputData, String cOperate) {
        // 将操作数据拷贝到本类中
        this.mOperate = cOperate;
        // 得到外部传入的数据,将数据备份到本类中
        if (!getInputData(cInputData)) {
            return false;
        }
        if (!check()) {
            return false;
        }
        // 进行业务处理
        if (!dealData()) {
            if(!mErrors.needDealError()) {
                CError.buildErr(this, "后台处理失败！");
            }
            return false;
        }

        //开始提交
        VData tVData = new VData();
        tVData.add(mMap);
        PubSubmit tPubSubmit = new PubSubmit();
        if (!tPubSubmit.submitData(tVData, "")) {
            // @@错误处理
            CError.buildErr(this, "数据提交失败!");
            return false;
        }
        return true;
    }

    /**
     * 从输入数据中得到所有对象
     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
     */
    public boolean getInputData(VData cInputData) {
        // 全局变量
        mGlobalInput = (GlobalInput) cInputData.get(0);
        TransferData transferData = (TransferData) cInputData.get(1);
        mLDCodeSchema = (LDCodeSchema)transferData.getValueByName("LDCodeSchema");
        mMsg_InfoSchema = (Msg_InfoSchema)transferData.getValueByName("Msg_InfoSchema");
        mDataGrid = (List)transferData.getValueByName("mulDataGrid");//查询结果

        if (mGlobalInput == null) {
            CError.buildErr(this, "没有得到足够的信息！");
            return false;
        }
        return true;
    }

    /**
     * 业务处理主函数
     *
     * @return boolean
     */
    public boolean dealData() {
        if (mOperate.equals("Save")) {
            //TODO 保存
            CError.buildErr(this, "后台还没有实现这个方法：保存");
            return false;
        }
        return true;
    }

    /**
     * 这个方法返回的结果中存放程序执行后的结果
     * 如果程序需要返回数据，可以通过这个方法实现
     *
     * @return 返回一个VData容器
     */
    public VData getResult() {
        return mResult;
    }

}
