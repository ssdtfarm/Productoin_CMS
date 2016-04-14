/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubFun1;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class LRProAddBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private String mOperate;// 数据操作字符串
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器

	private String mWageCode = "";
	private String mWageName = "";
	private String mBranchType = "";
	private String mBranchType2 = "";
	private String mDescription = "";
	private String mIndexSerise = "";
	private String mWageType = "";
	private String mState = "";

	private String currentDate = PubFun.getCurrentDate();
	private String currentTime = PubFun.getCurrentTime();

	public LRProAddBL() {
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
			if (!mErrors.needDealError()) {
				CError.buildErr(this, bundle.getString("Src_BL_dealDateErr"));
			}
			return false;
		}

		// 开始提交
		VData tVData = new VData();
		tVData.add(mMap);
		PubSubmit tPubSubmit = new PubSubmit();
		if (!tPubSubmit.submitData(tVData, "")) {
			// @@错误处理
			CError.buildErr(this, bundle.getString("Src_pubSubmitErr"));
			return false;
		}
		return true;
	}

	/**
	 * 从输入数据中得到所有对象 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
	 */
	public boolean getInputData(VData cInputData) {
		// 全局变量
		mGlobalInput = (GlobalInput) cInputData.get(0);
		TransferData transferData = (TransferData) cInputData.get(1);
		mWageCode = (String) transferData.getValueByName("WageCode");
		mWageName = (String) transferData.getValueByName("WageName");
		mBranchType = (String) transferData.getValueByName("BranchType");
		mBranchType2 = (String) transferData.getValueByName("BranchType2");
		mDescription = (String) transferData.getValueByName("Description");
		mIndexSerise = (String) transferData.getValueByName("IndexSerise");
		mWageType = (String) transferData.getValueByName("WageType");
		mState = (String)transferData.getValueByName("State");
		if (mGlobalInput == null) {
			CError.buildErr(this, bundle.getString("Src_UI_getInputDataErr"));
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
		if (mOperate.equals("saveButton")) {
			// TODO 保存
			// CError.buildErr(this, "后台还没有实现这个方法：保存");
			// return false;
			System.out.println("hello");
			String id = PubFun1.CreateMaxNo("LRIndex", 9);
			int count = 0;
			while("null".equalsIgnoreCase(id)&&count<5)
			{
				count++;
				id = PubFun1.CreateMaxNo("LRIndex", 9);
			}
			id="W"+id;
			String sql = "insert into LRIndex(wagecode,wagename,branchtype,branchtype2,description,indexserise,wagetype,operator,makedate,maketime,modifydate,modifytime,state) values('" + id + "','"
					+ mWageName + "','" + mBranchType + "','" + mBranchType2
					+ "','" + mDescription + "','" + mIndexSerise + "','"
					+ mWageType + "','" + mGlobalInput.Operator + "','"+currentDate+"','"+currentTime+"','"+currentDate+"','"+currentTime+"','"+mState+"')";
			mMap.put(sql, "INSERT");
		}
		return true;
	}

	/**
	 * 这个方法返回的结果中存放程序执行后的结果 如果程序需要返回数据，可以通过这个方法实现
	 * 
	 * @return 返回一个VData容器
	 */
	public VData getResult() {
		return mResult;
	}

}
