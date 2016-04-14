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

public class LRTermUpdateBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private String mOperate;// 数据操作字符串
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器

	private String mTermId = "";
	private String mName = "";
	private String mRemark = "";
	private String mTextArea = "";
	private String mAttribute = "";
	private String mCalculate = "";
	private String mState = "";
//	List mPhraseGird = new ArrayList();// 短语
//	List mParaGird = new ArrayList();// 参数

	private String currentDate = PubFun.getCurrentDate();
	private String currentTime = PubFun.getCurrentTime();
	
	
	public LRTermUpdateBL() {
	}

	/**
	 * 传输数据的公共方法
	 */
	public boolean check() {
		String sqlString = mTextArea.toLowerCase();
		String tempString  = "select";
		if(sqlString == null){
			CError.buildErr(this, bundle.getString("Src_BL_dealDateErr"));
			return false;
		}
		if(!sqlString.startsWith(tempString)){
			CError.buildErr(this, bundle.getString("Src_BL_dealDateErr"));
			return false;
		}
		if(sqlString.indexOf("create")!=-1 || sqlString.indexOf("delete")!=-1 
				|| sqlString.indexOf("update")!=-1 || sqlString.indexOf("delete")!=-1 
				|| sqlString.indexOf(";")!=-1 || sqlString.indexOf("\n")!=-1){
			CError.buildErr(this, bundle.getString("Src_BL_dealDateErr"));
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
//		mParaGird = (List) transferData.getValueByName("mulParaGird");// 参数TermId
		mTermId = (String) transferData.getValueByName("TermId");
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
			String template[];
//			String insert_phrase;
//			String insert_para;
//			String phrase_id = PubFun1.CreateMaxNo("lrTermphrase", 20);
//			String para_id = PubFun1.CreateMaxNo("lrTermpara", 20);
			String EdorNo = PubFun1.CreateMaxNo("LRBomb", 20);
			String EdorNo1 = PubFun1.CreateMaxNo("LRTerm", 20);
			String update_Term = "update lrTerm set CalSQL = '"
					+ mTextArea.trim().replaceAll("'", "''").replaceAll("\n", "").replaceAll("\r","") + "',name ='"
					+ mName + "',DataType ='" + mRemark + "',ModifyDate='"
					+ currentDate + "',ModifyTime='" + currentTime
					+ "',Operator='" + mGlobalInput.Operator + "',CalType='"
					+ mCalculate + "',Attribute='"+mAttribute+"',state='"+mState+"' where id= '" + mTermId + "'";
			
			String update_lrassessindexp ="update lrassessindexp set calsql = '"+mTextArea.trim().replaceAll("'", "''").replaceAll("\n", "").replaceAll("\r","")+"' ,sqltemp = '"+mTextArea.trim().replaceAll("'", "''").replaceAll("\n", "").replaceAll("\r","")+"',indexname = '"+mName+"' where   basecode in (select basecode from lrbase where status not in('02','04','06') and indexcode = '"+mTermId+"') ";
			String b_bom = "insert into lrbomb(edorno,id,name,remark,displayorder,operator,modifydate,modifytime,maketime,makedate,operator2,makedate2,maketime2,modifytime2,modifydate2,state,branchtype) select '"
					+ EdorNo
					+ "',ID,Name,Remark,DataType,CalSQL,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
					+ mGlobalInput.Operator + "','" + currentDate + "','"
					+ currentTime + "','" + currentTime + "','" + currentDate
					+ "',state,branchtype from lrbom";
//			String delete_phrase = "delete from lrTermphrase where Termid = '"
//					+ mTermId + "'";
//			String delete_para = "delete from lrTermpara where Termid = '"
//					+ mTermId + "'";
			String b_term = "insert into lrtermb(edorno,id,name,bomid,remark,displayorder,datatype,caltype,attribute,calsql,operator,modifydate,modifytime,maketime,makedate,operator2,makedate2,maketime2,modifytime2,modifydate2,state) select '"
					+ EdorNo1
					+ "',ID,Name,bomid,Remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
					+ mGlobalInput.Operator + "','" + currentDate + "','"
					+ currentTime + "','" + currentTime + "','" + currentDate
					+ "',state from lrterm where id = '" + mTermId + "'";
			;
			// mMap.put(b_bom, "INSERT");
			
			mMap.put(update_Term, "UPDATE");  
			mMap.put(update_lrassessindexp, "UPDATE");
			mMap.put(b_term, "INSERT");
//			mMap.put(delete_phrase, "DELETE");
//			mMap.put(delete_para, "DELETE");
//			for (int i = 0; i < mPhraseGird.size(); i++) {
//				template = (String[]) mPhraseGird.get(i);
//				String EdorNo2 = PubFun1.CreateMaxNo("LRphrase", 20);
//				String b_phrase = "insert into lrtermphraseb select '"
//						+ EdorNo2
//						+ "',ID,TermID,PhraseType,Discription,Template,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
//						+ mGlobalInput.Operator + "','" + currentDate + "','"
//						+ currentTime + "','" + currentTime + "','"
//						+ currentDate + "' from lrtermphrase";
//				insert_phrase = "insert into lrTermphrase values('" + phrase_id
//						+ "','" + mTermId + "','" + template[1] + "','"
//						+ template[3] + "','" + template[4] + "','"
//						+ mGlobalInput.Operator + "','" + currentDate + "','"
//						+ currentTime + "','" + currentTime + "','"
//						+ currentDate + "')";
//				mMap.put(b_phrase, "INSERT");
//				mMap.put(insert_phrase, "INSERT");
//			}
//			for (int i = 0; i < mParaGird.size(); i++) {
//				template = (String[]) mParaGird.get(i);
//				String EdorNo3 = PubFun1.CreateMaxNo("LRphrase", 20);
//				String b_para = "insert into lrtermparab select '"
//						+ EdorNo3
//						+ "',ID,TermID,ParaType,Name,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
//						+ mGlobalInput.Operator + "','" + currentDate + "','"
//						+ currentTime + "','" + currentTime + "','"
//						+ currentDate + "' from lrtermpara";
//				insert_para = "insert into lrTermpara values('" + para_id
//						+ "','" + mTermId + "','" + template[2] + "','"
//						+ template[1] + "','" + mGlobalInput.Operator + "','"
//						+ currentDate + "','" + currentTime + "','"
//						+ currentTime + "','" + currentDate + "')";
//				mMap.put(b_para, "INSERT");
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
