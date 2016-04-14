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
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class LRBomBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private String mOperate;// 数据操作字符串
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器

	//private String mID = "";
	//private String mName = "";
	//tangyj 增加
	private String BomId="";
	private String TermId="";
	//List mBOMGird = new ArrayList();// BOM列表
	//List mTermGird = new ArrayList();// Term列表

	private String currentDate = PubFun.getCurrentDate();
	private String currentTime = PubFun.getCurrentTime();

	public LRBomBL() {
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
//
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
		//mID = (String) transferData.getValueByName("ID");
		//增加tangyj
		BomId = (String) transferData.getValueByName("BomId");
		TermId = (String) transferData.getValueByName("TermId");
		//mName = (String) transferData.getValueByName("Name");
		///mBOMGird = (List) transferData.getValueByName("mulBOMGird");// BOM列表
		//mTermGird = (List) transferData.getValueByName("mulTermGird");// Term列表

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
		//tangyj修改删除方式
		if (mOperate.equals("Delete")) {
			String id[];
			String indexcode = "";
			System.out.println("++++++++++++++++++=" + mOperate);
			
			
				String delete_bom = "delete from LRBom where id = '"
						+ BomId + "'";
				String delete_Term = "delete from lrTerm where bomid ='"
						+ BomId + "'";

				//			校验是否BOM下的词条别引用到，如果被引用到，则该BOM不能被删除
				String sech = "select id from lrterm where bomid = '"+BomId+"'";
				SSRS ssrs = new ExeSQL().execSQL(sech);
				for(int k=1;k<=ssrs.getMaxRow();k++){
					indexcode = ssrs.GetText(k, 1);

					if(beforeDetete(indexcode)){
						//CError.buildErr(this, "BOM编码"+BomId+"下的词条（"+indexcode+"）被引用中，不能删除");
						CError.buildErr(this, BomId+bundle.getString("Rule_BOMcodeBomIditemindexcodeisbeingquoted,cannotbedeleted")+indexcode);
						return false;
					} 
				}
				String EdorNo = PubFun1.CreateMaxNo("LRBomb", 20);

				String EdorNo3 = PubFun1.CreateMaxNo("LRtermb", 20);

				String b_bom = "insert into lrbomb(edorno,id,name,Remark,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,operator2,makedate2,maketime2,modifytime2,modifydate2,state,branchtype) select '"
						+ EdorNo
						+ "',ID,Name,Remark,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
						+ mGlobalInput.Operator + "','" + currentDate
						+ "','" + currentTime + "','" + currentTime + "','"
						+ currentDate + "',state,branchtype from lrbom where id='"+BomId+"'";
				String b_term = "insert into lrtermb(edorno,id,name,bomid,remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,operator2,makedate2,maketime2,modifytime2,modifydate2,state) select '"
						+ EdorNo3
						+ "',ID,Name,BomID,Remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
						+ mGlobalInput.Operator + "','" + currentDate
						+ "','" + currentTime + "','" + currentTime + "','"
						+ currentDate + "',state from lrterm where bomid='"+BomId+"'";
//
				
				mMap.put(b_bom, "INSERT");
				mMap.put(b_term, "INSERT");

				mMap.put(delete_Term, "DELETE");
				mMap.put(delete_bom, "DELETE");

			
		}
		else if (mOperate.equals("DeleteTerm")) {
			//for (int i = 0; i < mBOMGird.size(); i++) {
				//String[] temp = (String[]) mBOMGird.get(i);
				//if (temp[0].equals("1")) {
					//for (int j = 0; j < mTermGird.size(); j++) {
						//String[] s = (String[]) mTermGird.get(j);
						//if (s[0].equals("1")) {
							System.out.println("000000000000000000" + TermId+ "||" + BomId);
							String sql = "delete from lrTerm where id ='"
									+ TermId + "' and bomid = '" + BomId + "' ";
							if(beforeDetete(TermId)){
								//CError.buildErr(this, "词条（"+TermId+"）被引用中，不能删除");
								CError.buildErr(this, bundle.getString("Rule_ItemTermIdisbeingquoted,cannotbedeleted")+TermId);
								return false;
							}
							String EdorNo1 = PubFun1.CreateMaxNo("LRterm", 20);

							String b_term = "insert into lrtermb(edorno,id,name,bomid,remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,operator2,makedate2,maketime2,modifytime2,modifydate2,state) select '"
									+ EdorNo1
									+ "',ID,Name,BomID,Remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
									+ mGlobalInput.Operator + "','"
									+ currentDate + "','" + currentTime + "','"
									+ currentTime + "','" + currentDate
									+ "',state from lrterm";

							mMap.put(b_term, "INSERT");

							mMap.put(sql, "DELETE");
						//}
						//;

					//}
				//}

			//}
		}
		return true;
			
			
			/*//之前的处理删除方式
			for (int i = 0; i < mBOMGird.size(); i++) {
				id = (String[]) mBOMGird.get(i);
				if (id[0].equals("1")) {
					String delete_bom = "delete from LRBom where id = '"
							+ id[1] + "'";
					String delete_Term = "delete from lrTerm where bomid ='"
							+ id[1] + "'";
//					String delete_phrase = "delete from lrTermphrase where Termid in (select id from lrTerm where bomid = '"
//							+ id[1] + "')";
//					String delte_para = "delete from lrTermpara where Termid in (select id from lrTerm where bomid = '"
//							+ id[1] + "')";
					//			校验是否BOM下的词条别引用到，如果被引用到，则该BOM不能被删除
					String sech = "select id from lrterm where bomid = '"+id[1]+"'";
					SSRS ssrs = new ExeSQL().execSQL(sech);
					for(int k=1;k<=ssrs.getMaxRow();k++){
						indexcode = ssrs.GetText(k, 1);
//						if(!LRAssessIndexLibraryUtil.brforeDelete(indexcode)){
						if(beforeDetete(indexcode)){
							CError.buildErr(this, "BOM编码"+id[1]+"下的词条（"+indexcode+"）被引用中，不能删除");
							return false;
						} 
					}
					String EdorNo = PubFun1.CreateMaxNo("LRBomb", 20);
//					String EdorNo1 = PubFun1.CreateMaxNo("LRpara", 20);
//					String EdorNo2 = PubFun1.CreateMaxNo("LRphrase", 20);
					String EdorNo3 = PubFun1.CreateMaxNo("LRtermb", 20);

					String b_bom = "insert into lrbomb(edorno,id,name,Remark,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,operator2,makedate2,maketime2,modifytime2,modifydate2,state,branchtype) select '"
							+ EdorNo
							+ "',ID,Name,Remark,DisplayOrder,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
							+ mGlobalInput.Operator + "','" + currentDate
							+ "','" + currentTime + "','" + currentTime + "','"
							+ currentDate + "',state,branchtype from lrbom where id='"+id[1]+"'";
					String b_term = "insert into lrtermb(edorno,id,name,bomid,remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,operator2,makedate2,maketime2,modifytime2,modifydate2,state) select '"
							+ EdorNo3
							+ "',ID,Name,BomID,Remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
							+ mGlobalInput.Operator + "','" + currentDate
							+ "','" + currentTime + "','" + currentTime + "','"
							+ currentDate + "',state from lrterm where bomid='"+id[1]+"'";
//					String b_phrase = "insert into lrtermphraseb select '"
//							+ EdorNo2
//							+ "',ID,TermID,PhraseType,Discription,Template,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
//							+ mGlobalInput.Operator + "','" + currentDate
//							+ "','" + currentTime + "','" + currentTime + "','"
//							+ currentDate + "' from lrtermphrase";
//					String b_para = "insert into lrtermparab select '"
//							+ EdorNo3
//							+ "',ID,TermID,ParaType,Name,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
//							+ mGlobalInput.Operator + "','" + currentDate
//							+ "','" + currentTime + "','" + currentTime + "','"
//							+ currentDate + "' from lrtermpara";
					
					mMap.put(b_bom, "INSERT");
					mMap.put(b_term, "INSERT");
//					mMap.put(b_phrase, "INSERT");
//					mMap.put(b_para, "INSERT");
//
//					mMap.put(delte_para, "DELETE");
//					mMap.put(delete_phrase, "DELETE");
					mMap.put(delete_Term, "DELETE");
					mMap.put(delete_bom, "DELETE");

				}
			}

		} else if (mOperate.equals("DeleteTerm")) {
			for (int i = 0; i < mBOMGird.size(); i++) {
				String[] temp = (String[]) mBOMGird.get(i);
				if (temp[0].equals("1")) {
					for (int j = 0; j < mTermGird.size(); j++) {
						String[] s = (String[]) mTermGird.get(j);
						if (s[0].equals("1")) {
							System.out.println("000000000000000000" + s[1]
									+ "||" + temp[1]);
							String sql = "delete from lrTerm where id ='"
									+ s[1] + "' and bomid = '" + temp[1] + "' ";
							if(beforeDetete(s[1])){
								CError.buildErr(this, "词条（"+s[1]+"）被引用中，不能删除");
								return false;
							}
							String EdorNo1 = PubFun1.CreateMaxNo("LRterm", 20);
//							String EdorNo2 = PubFun1
//									.CreateMaxNo("LRphrase", 20);
//							String EdorNo3 = PubFun1.CreateMaxNo("LRpara", 20);
							String b_term = "insert into lrtermb(edorno,id,name,bomid,remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,operator2,makedate2,maketime2,modifytime2,modifydate2,state) select '"
									+ EdorNo1
									+ "',ID,Name,BomID,Remark,DisplayOrder,DataType,CalType,Attribute,CalSQL,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
									+ mGlobalInput.Operator + "','"
									+ currentDate + "','" + currentTime + "','"
									+ currentTime + "','" + currentDate
									+ "',state from lrterm";
//							String b_phrase = "insert into lrtermphraseb select '"
//									+ EdorNo2
//									+ "',ID,TermID,PhraseType,Discription,Template,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
//									+ mGlobalInput.Operator
//									+ "','"
//									+ currentDate
//									+ "','"
//									+ currentTime
//									+ "','"
//									+ currentTime
//									+ "','"
//									+ currentDate
//									+ "' from lrtermphrase";
//							String b_para = "insert into lrtermparab select '"
//									+ EdorNo3
//									+ "',ID,TermID,ParaType,Name,Operator,ModifyDate,ModifyTime,MakeTime,MakeDate,'"
//									+ mGlobalInput.Operator + "','"
//									+ currentDate + "','" + currentTime + "','"
//									+ currentTime + "','" + currentDate
//									+ "' from lrtermpara";
//							if(!LRAssessIndexLibraryUtil.brforeDelete(s[1])){
//								CError.buildErr(this, "词条或规则（"+s[1]+"）正在被引用，不能删除");
//								return false;
//							}
							mMap.put(b_term, "INSERT");
//							mMap.put(b_phrase, "INSERT");
//							mMap.put(b_para, "INSERT");
							mMap.put(sql, "DELETE");
						}
						;

					}
				}

			}
		}
		return true;*/
	}

	/**
	 * 这个方法返回的结果中存放程序执行后的结果 如果程序需要返回数据，可以通过这个方法实现
	 * 
	 * @return 返回一个VData容器
	 */
	public VData getResult() {
		return mResult;
	}

	/**
	 * 删除前校验
	 * @param str
	 * @return
	 */
	public boolean beforeDetete(String str){
		boolean reflag = false;
		try{
			//查询规则表，看是否词条被引用到，如果被引用不能被删除
			String sql = "select indexcode,indexname,branchtype,indexset from lrassessindexlibrary a where " 
					+"exists(select 1 from lrterm where id='"+str+"' and branchtype=a.branchtype) " 
					//modify by tianzf 20140205 instr(long,short)->charindex(short,long)
//					+"and instr(a.indexset,'"+str+"')<>0";
					+"and charindex('"+str+"',a.indexset)<>0";
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
}
