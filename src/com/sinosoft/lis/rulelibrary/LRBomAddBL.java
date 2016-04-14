/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import java.util.*;
import com.sinosoft.lis.schema.*;
import com.sinosoft.lis.vschema.*;
import com.sinosoft.lis.db.*;
import com.sinosoft.lis.vdb.*;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

public class LRBomAddBL {
	public CErrors mErrors = new CErrors();
	private String mOperate;
	private GlobalInput mGlobalInput = new GlobalInput();
	private MMap mMap = new MMap();
	private VData mResult = new VData();

	private String mName = "";
	private String mRemark = "";
	private String mBranchType = "";
	private String mState = "";

	private String currentDate = PubFun.getCurrentDate();
	private String currentTime = PubFun.getCurrentTime();

	public LRBomAddBL() {
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
		if (!dealData()) {
			if (!mErrors.needDealError()) {
				CError.buildErr(this, "");
			}
			return false;
		}

		VData tVData = new VData();
		tVData.add(mMap);
		PubSubmit tPubSubmit = new PubSubmit();
		if (!tPubSubmit.submitData(tVData, "")) {
			CError.buildErr(this, "");
			return false;
		}
		return true;
	}

	/**
	 */
	public boolean getInputData(VData cInputData) {
		mGlobalInput = (GlobalInput) cInputData.get(0);
		TransferData transferData = (TransferData) cInputData.get(1);
		mName = (String) transferData.getValueByName("Name");
		mRemark = (String) transferData.getValueByName("Remark");
		mBranchType = (String) transferData.getValueByName("BranchType");
		mState = (String) transferData.getValueByName("State");
		if (mGlobalInput == null) {
			CError.buildErr(this, " ");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean dealData() {
		if (mOperate.equals("saveButton")) {
			// return false;
			
			String id = PubFun1.CreateMaxNo("LRBom", 9);
			int count = 0;
			while("null".equalsIgnoreCase(id)&&count<5)
			{
				count++;
				id = PubFun1.CreateMaxNo("LRBom", 9);
			}
			id="B"+id;
			String sql = "insert into LRBom(ID,Name,Remark,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,branchType,state) values('"
					+ id
					+ "','"
					+ mName
					+ "','"
					+ mRemark
					+ "',(select isnull(max(DisplayOrder)+1,1) from LRBom),'"
					+ mGlobalInput.Operator
					+ "','"
					+ currentDate
					+ "','"
					+ currentTime
					+ "','"
					+ currentTime
					+ "','"
					+ currentDate
					+ "','"+mBranchType
					+"','" 
					+mState+
							"')";
			mMap.put(sql, "INSERT");
		}
		return true;
	}

	/**
	 * 
	 */
	public VData getResult() {
		return mResult;
	}

}
