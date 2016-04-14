/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class LRRuleInforBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private String mOperate;// 数据操作字符串
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器

	private String WageCode="";
	private String IndexCode="";
	//private String mWageCode = "";
	//private String mWageName = "";
	//private String mWageType = "";
	//private String mIndexSerise = "";
	//private String mState = "";
	List mProGird = new ArrayList();// 薪资列表
	List mRuleGird = new ArrayList();// 规则列表

	private String currentDate = PubFun.getCurrentDate();
	private String currentTime = PubFun.getCurrentTime();

	public LRRuleInforBL() {
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
		//tangyj20130927
		WageCode=(String) transferData.getValueByName("WageCode");
		IndexCode=(String) transferData.getValueByName("IndexCode");

		//mWageCode = (String) transferData.getValueByName("WageCode");
		//mWageName = (String) transferData.getValueByName("WageName");
		//mWageType = (String) transferData.getValueByName("WageType");
		//mIndexSerise = (String) transferData.getValueByName("IndexSerise");
		//mState = (String)transferData.getValueByName("State");
		//mProGird = (List) transferData.getValueByName("mulProGird");// 薪资列表
		//mRuleGird = (List) transferData.getValueByName("mulRuleGird");// 规则列表

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
		if (mOperate.equals("Delete")) {
			// TODO 删除
			// CError.buildErr(this, "后台还没有实现这个方法：删除");
			// return false;
			//String s[];
			String indexcode = "";
			//for (int i = 0; i < mProGird.size(); i++) {
				//s = (String[]) mProGird.get(i);
				//if (s[0].equalsIgnoreCase("1")) {
					String sql = "delete from lrindex where WageCode='" + WageCode
							+ "'";
					String delete_sql = "delete from LRAssessIndexLibrary where wagecode = '"+WageCode+"'";
					String sech = "select indexcode from LRAssessIndexLibrary where wagecode = '"+WageCode+"'";
					SSRS ssrs = new ExeSQL().execSQL(sech);
					for(int k=1;k<=ssrs.getMaxRow();k++){
						indexcode = ssrs.GetText(k, 1);
//						if(!LRAssessIndexLibraryUtil.brforeDelete(indexcode)){
						if(beforeDetete(indexcode)){
							//CError.buildErr(this, "项目"+WageCode+"下规则（"+indexcode+"）被引用中，不能删除！");
							CError.buildErr(this, WageCode+bundle.getString("Rule_WageWageCoderuleindexcodeisbeingquoted,cannotbedeleted!")+indexcode);
							return false;
						}
					}
					mMap.put(delete_sql, "DELETE");
					mMap.put(sql, "DELETE");
				//}
			//}
		} else if (mOperate.equals("DeleteRule")) {
			// TODO 删除
			// CError.buildErr(this, "后台还没有实现这个方法：删除");
			// return false;
			//String s[];
			//String q[];
//			for (int j = 0; j < mProGird.size(); j++) {
//				q = (String[]) mProGird.get(j);
//				if (q[0].equals("1")) {
					//for (int i = 0; i < mRuleGird.size(); i++) {
						//s = (String[]) mRuleGird.get(i);
						//if (s[0].equalsIgnoreCase("1")) {
							String sql = "delete from LRAssessIndexLibrary where IndexCode='"
									+ IndexCode + "'";
//							if(!LRAssessIndexLibraryUtil.brforeDelete(WageCode)){
							if(beforeDetete(IndexCode)){
								//CError.buildErr(this, "规则（"+IndexCode+"）被引用中，不能删除！");
								CError.buildErr(this, IndexCode+bundle.getString("Rule_Ruleindexcodeisbeingquoted,cannotbedeleted!"));
								return false;
							}
							mMap.put(sql, "DELETE");
						//}
					//}

//				}
//			}

		}
		return true;
		/*if (mOperate.equals("Delete")) {
			// TODO 删除
			// CError.buildErr(this, "后台还没有实现这个方法：删除");
			// return false;
			String s[];
			String indexcode = "";
			for (int i = 0; i < mProGird.size(); i++) {
				s = (String[]) mProGird.get(i);
				if (s[0].equalsIgnoreCase("1")) {
					String sql = "delete from lrindex where WageCode='" + s[1]
							+ "'";
					String delete_sql = "delete from LRAssessIndexLibrary where wagecode = '"+s[1]+"'";
					String sech = "select indexcode from LRAssessIndexLibrary where wagecode = '"+s[1]+"'";
					SSRS ssrs = new ExeSQL().execSQL(sech);
					for(int k=1;k<=ssrs.getMaxRow();k++){
						indexcode = ssrs.GetText(k, 1);
//						if(!LRAssessIndexLibraryUtil.brforeDelete(indexcode)){
						if(beforeDetete(indexcode)){
							CError.buildErr(this, "项目"+s[1]+"下规则（"+indexcode+"）被引用中，不能删除！");
							return false;
						}
					}
					mMap.put(delete_sql, "DELETE");
					mMap.put(sql, "DELETE");
				}
			}
		} else if (mOperate.equals("DeleteRule")) {
			// TODO 删除
			// CError.buildErr(this, "后台还没有实现这个方法：删除");
			// return false;
			String s[];
			String q[];
//			for (int j = 0; j < mProGird.size(); j++) {
//				q = (String[]) mProGird.get(j);
//				if (q[0].equals("1")) {
					for (int i = 0; i < mRuleGird.size(); i++) {
						s = (String[]) mRuleGird.get(i);
						if (s[0].equalsIgnoreCase("1")) {
							String sql = "delete from LRAssessIndexLibrary where IndexCode='"
									+ s[1] + "'";
//							if(!LRAssessIndexLibraryUtil.brforeDelete(s[1])){
							if(beforeDetete(s[1])){
								CError.buildErr(this, "规则（"+s[1]+"）被引用中，不能删除！");
								return false;
							}
							mMap.put(sql, "DELETE");
						}
					}

//				}
//			}

		}
		return true;*/
	}

	/**
	 * 删除前校验
	 * @param str
	 * @return
	 */
	public boolean beforeDetete(String str){
		boolean reflag = false;
		try{
			//2、删除项目或规则时，需要校验项目或规则是否被基本法引用（不区分基本法状态）；
			//3、删除项目或规则是，需要校验项目或规则是否被其他项目或规则引用（不区分状态），若被引用不能删除。
			String sql = "select basecode,indexcode,indexname,branchtype,indexset from LRAssessIndex a where indexcode='"+str+"' " 
					+" union "
					+" select basecode,indexcode,indexname,branchtype,indexset from LRAssessIndexp a where indexcode='"+str+"' "
					+" union "		
					+" select basecode,indexcode,indexname,branchtype,indexset from LRAssessIndexb a where indexcode='"+str+"' ";
			SSRS tSSRS = new SSRS();
			ExeSQL tExeSQL = new ExeSQL();
			tSSRS = tExeSQL.execSQL(sql);	
			if(tSSRS.getMaxRow()>0){
				reflag = true;
			}
		}catch(Exception e){
			reflag = false;
			CError.buildErr(this, bundle.getString("Rule_Checkruleerror")+e.getMessage());
		}
		return reflag;
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
