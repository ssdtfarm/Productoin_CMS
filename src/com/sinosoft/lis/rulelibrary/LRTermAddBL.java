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
public class LRTermAddBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private String mOperate;// 数据操作字符串
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器

	private String mName = "";
	private String mRemark = "";
	private String mBomId = "";
	private String mTextArea = "";
	private String mAttribute = "";
	private String mCalculate = "";
	private String mState = "";
	
//	List mPhraseGird = new ArrayList();// 短语
//	List mParaGird = new ArrayList();// 参数

	private String currentDate = PubFun.getCurrentDate();
	private String currentTime = PubFun.getCurrentTime();

	public LRTermAddBL() {
	}

	/**
	 * 传输数据的公共方法
	 */
	public boolean check() {
		String sqlString = mTextArea.trim().toLowerCase();
		String tempString  = "select";
		if(sqlString == null){
			return false;
		}
		if(!sqlString.startsWith(tempString)){
			return false;
		}
		if(sqlString.indexOf("create")!=-1 || sqlString.indexOf("delete")!=-1 
				|| sqlString.indexOf("update")!=-1 || sqlString.indexOf("delete")!=-1 
				|| sqlString.indexOf(";")!=-1 || sqlString.indexOf("\n")!=-1){
			return false;
		}
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
		mName = (String) transferData.getValueByName("Name");
		mRemark = (String) transferData.getValueByName("Remark");
//		mPhraseGird = (List) transferData.getValueByName("mulPhraseGird");// 短语
//		mParaGird = (List) transferData.getValueByName("mulParaGird");// 参数
		mBomId = (String) transferData.getValueByName("BomId");// 参数mAttributemCalculate
		mTextArea = (String) transferData.getValueByName("TextArea");
		mAttribute = (String) transferData.getValueByName("Attribute");
		mCalculate = (String) transferData.getValueByName("Calculate");
		mState = (String) transferData.getValueByName("State");
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
		if (mOperate.equals("save")) {
			// TODO 保存
			// CError.buildErr(this, "后台还没有实现这个方法：保存");
			// return false;
			String term_id = PubFun1.CreateMaxNo("lrterm", 9);
			term_id = "I" + term_id;
//			String phrase_id = PubFun1.CreateMaxNo("lrtermphrase", 20);
//			String para_id = PubFun1.CreateMaxNo("lrtermpara", 20);
//			String insert_para;
//			String insert_phrase;
			String template[];
			String insert_term = "insert into lrterm(ID,Name,BomID,DataType,CalType,Attribute,CalSQL,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,state) values('"
					+ term_id
					+ "','"
					+ mName
					+ "','"
					+ mBomId
					+ "','"
					+ mRemark
					+ "','"
					+ mCalculate
					+ "','"
					+ mAttribute
					+ "','"
					+ mTextArea.trim().replaceAll("'", "''")
//					+ "','"
//					+ mRemark
					+ "',(select isnull(max(DisplayOrder)+1,1) from lrterm),'"
					+ mGlobalInput.Operator
					+ "','"
					+ currentDate
					+ "','"
					+ currentTime
					+ "','"
					+ currentTime
					+ "','"
					+ currentDate
					+"','"
					+mState+"')";
//			String EdorNo1 = PubFun1.CreateMaxNo("LRTerm", 20);
//			String b_term = "insert into lrtermb select '"
//					+ EdorNo1
//					+ "',ID,Name,bomid,Remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
//					+ mGlobalInput.Operator + "','" + currentDate + "','"
//					+ currentTime + "','" + currentTime + "','" + currentDate
//					+ "' from lrterm where id = '" + term_id + "'";
//			;
			mMap.put(insert_term, "INSERT");
//			mMap.put(b_term, "INSERT");
//			for (int i = 0; i < mPhraseGird.size(); i++) {
//				template = (String[]) mPhraseGird.get(i);
//				insert_phrase = "insert into lrtermphrase values('" + phrase_id
//						+ "','" + term_id + "','" + template[1] + "','"
//						+ template[3] + "','" + template[4] + "','"
//						+ mGlobalInput.Operator + "','" + currentDate + "','"
//						+ currentTime + "','" + currentTime + "','"
//						+ currentDate + "')";
//				mMap.put(insert_phrase, "INSERT");
//			}
//			for (int i = 0; i < mParaGird.size(); i++) {
//				template = (String[]) mParaGird.get(i);
//				insert_para = "insert into lrtermpara values('" + para_id
//						+ "','" + term_id + "','" + template[2] + "','"
//						+ template[1] + "','" + mGlobalInput.Operator + "','"
//						+ currentDate + "','" + currentTime + "','"
//						+ currentTime + "','" + currentDate + "')";
//				mMap.put(insert_para, "INSERT");
//			}

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
