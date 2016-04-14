/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import java.util.*;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.schema.*;
import com.sinosoft.lis.vschema.*;
import com.sinosoft.lis.db.*;
import com.sinosoft.lis.vdb.*;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

public class LRBomUpdateBL {
    public CErrors mErrors = new CErrors();
    private String mOperate;
    private GlobalInput mGlobalInput = new GlobalInput();
    private MMap mMap = new MMap();
    private VData mResult = new VData();

    private String mName = "";
    private String mRemark = "";
    private String mID = "";
    private String mbranchtype = "";
    private String mState = "";
    private String currentDate = PubFun.getCurrentDate();
    private String currentTime = PubFun.getCurrentTime();

    public LRBomUpdateBL() {
    }

    /**
     */
    public boolean check() {
        return true;
    }

    public boolean submitData(VData cInputData, String cOperate) {
        this.mOperate = cOperate;
        if (!getInputData(cInputData)) {
            return false;
        }
        if (!check()) {
            return false;
        }
        // ����ҵ����
        if (!dealData()) {
            if(!mErrors.needDealError()) {
                CError.buildErr(this, bundle.getString("Src_BL_dealDateErr"));
            }
            return false;
        }

        //��ʼ�ύ
        VData tVData = new VData();
        tVData.add(mMap);
        PubSubmit tPubSubmit = new PubSubmit();
        if (!tPubSubmit.submitData(tVData, "")) {
            // @@������
            CError.buildErr(this, bundle.getString("Src_pubSubmitErr"));
            return false;
        }
        return true;
    }

    /**
     * ����������еõ����ж���
     * ��������û�еõ��㹻��ҵ����ݶ����򷵻�false,���򷵻�true
     */
    public boolean getInputData(VData cInputData) {
        // ȫ�ֱ���
        mGlobalInput = (GlobalInput) cInputData.get(0);
        TransferData transferData = (TransferData) cInputData.get(1);
        mName = (String)transferData.getValueByName("Name");
        mRemark = (String)transferData.getValueByName("Remark");
        mID = (String)transferData.getValueByName("ID");
        mState = (String)transferData.getValueByName("State");
        mbranchtype = (String)transferData.getValueByName("BranchType");

        if (mGlobalInput == null) {
            CError.buildErr(this, bundle.getString("Src_UI_getInputDataErr"));
            return false;
        }
        return true;
    }

    /**
     * ҵ����������
     *
     * @return boolean
     */
    public boolean dealData() {
        if (mOperate.equals("saveButton")) {
//            //TODO ����
//            CError.buildErr(this, "��̨��û��ʵ���������������);
//            return false;
        	String EdorNo = PubFun1.CreateMaxNo("LRBomb", 20);
        	String b_bom ="insert into lrbomb(edorno,id,name,remark,displayorder,operator,modifydate,modifytime,maketime,makedate,operator2,makedate2,maketime2,modifytime2,modifydate2,state,branchtype) select '"+EdorNo+"',ID,Name,Remark,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"+mGlobalInput.Operator+"','"+currentDate+"','"+currentTime+"','"+currentTime+"','"+currentDate+"',state,branchtype from lrbom";
        	String sql ="update LRBom set name ='"+mName+"',remark ='"+mRemark+"',branchtype = '"+mbranchtype+"',state='"+mState+"',ModifyDate='"+currentDate+"',ModifyTime='"+currentTime+"',Operator='"+mGlobalInput.Operator+"' where id ='"+mID+"'";
        	String sql_lrassessindexp ="update lrassessindexp set indexname = '"+mName+"' where indexcode = '"+mID+"' and basecode in (select basecode from lrbase where status not in('02','04','06')) ";
        	mMap.put(sql_lrassessindexp, "UPDATE");
        	mMap.put(b_bom, "INSERT");
        	mMap.put(sql, "UPDATE");
        }
        return true;
    }

    /**
     * ����������صĽ���д�ų���ִ�к�Ľ��
     * ��������Ҫ������ݣ�����ͨ���������ʵ��
     *
     * @return ����һ��VData����
     */
    public VData getResult() {
        return mResult;
    }

}
