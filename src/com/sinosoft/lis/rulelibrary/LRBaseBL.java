/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

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


public class LRBaseBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器
	private String NodeInfo = "";
	private ExeSQL exe = new ExeSQL();
	private StringBuffer indexcodeSet = new StringBuffer("(''");
	private String path="";
	private HashMap<String, Element> map = new HashMap();
	private String key;

	// 定义一个root作为xml文档的根元素
	private Element root = new Element("base");
	// 生成一个文档
	private Document Doc = new Document(root);
	private Element lrindexvscomm = new Element("lrindexvscomm");
	private Element lrassessindex = new Element("lrassessindex");
	private Element lrbom = new Element("lrbom");
	private Element lrterm = new Element("lrterm");	
//	private Element lrtermpara = new Element("lrtermpara");
//	private Element lrtermphrase = new Element("lrtermphrase");
	private Element lrindex = new Element("lrindex");
	private Element lrassessindexlibrary = new Element("lrassessindexlibrary");
	
	public LRBaseBL() { 
	}

	/**
	 * 传输数据的公共方法
	 */
	public boolean check() {
		return true;
	}

	public boolean submitData(VData cInputData, String cOperate) {
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
		path = (String) transferData.getValueByName("path");
		NodeInfo = (String) transferData.getValueByName("NodeInfo");
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
		String[] node = NodeInfo.split("\\|");
		root.addContent(lrassessindex);
		root.addContent(lrindexvscomm);
		root.addContent(lrbom);
		root.addContent(lrterm);
		root.addContent(lrindex);
		root.addContent(lrassessindexlibrary);
//		root.addContent(lrtermpara);
//		root.addContent(lrtermphrase);	
		
		for (int i = 0; i < node.length; i++) {
			String Condition = "";
			String Cond = "";
			String[] info = node[i].split(",");
			switch (info.length) {
			case 4:
				Condition += "and wagecode='" + info[3] + "' ";
			case 3:
				Condition += "and agentgrade='" + info[2] + "' ";
				Cond += "and agentgrade='" + info[2] + "' ";
			case 2:
				Condition += "and indextype='" + info[1] + "' ";
				Cond += "and indextype='" + info[1] + "' ";
			case 1:
				Condition += "and basecode='" + info[0] + "' ";
				Cond += "and basecode='" + info[0] + "' ";
			}
			try {
				String sql1 = "select BASECODE,MANAGECOM,INDEXTYPE,AGENTGRADE,WAGECODE,WAGENAME,BRANCHTYPE,INDEXCODE,WAGEORDER,BRANCHTYPE2,INDEXSERISE,DESCRIPTION from LRIndexVsCommP where 1=1 and managecom like '"
						+ mGlobalInput.ManageCom + "%'" + Condition;
				SSRS ssrs1 = exe.execSQL(sql1);
				System.out.println("sql1----------->"+sql1);
				System.out.println("ssrs1.getMaxRow--"+ssrs1.getMaxRow());
				for (int k = 1; k <=ssrs1.getMaxRow(); k++) {
					Element p = new Element("lrindexvscommnode");
//					lrindexvscomm.addContent(p); 
					p.addContent(new Element("basecode").setText(ssrs1.GetText(k, 1)));
					p.addContent(new Element("managecom").setText(ssrs1.GetText(k, 2)));
					p.addContent(new Element("indextype").setText(ssrs1.GetText(k, 3)));
					p.addContent(new Element("agentgrade").setText(ssrs1.GetText(k, 4)));
					p.addContent(new Element("wagecode").setText(ssrs1.GetText(k, 5)));
					p.addContent(new Element("wagename").setText(ssrs1.GetText(k, 6)));
					p.addContent(new Element("branchtype").setText(ssrs1.GetText(k, 7)));
					p.addContent(new Element("indexcode").setText(ssrs1.GetText(k, 8)));
					p.addContent(new Element("wageorder").setText(ssrs1.GetText(k, 9)));
					p.addContent(new Element("branchtype2").setText(ssrs1.GetText(k, 10)));
					p.addContent(new Element("indexserise").setText(ssrs1.GetText(k, 11)));
					p.addContent(new Element("description").setText(ssrs1.GetText(k, 12)));
					String key = "vscomm"+ssrs1.GetText(k, 1)+ssrs1.GetText(k, 5) +ssrs1.GetText(k, 3)+ssrs1.GetText(k, 2)+ssrs1.GetText(k, 4);
					System.out.println(key);
					 map.put("1",new Element("hello"));
					System.out.println(p);
					map.put(key, p);
					getIndexCode(ssrs1.GetText(k, 8), ssrs1.GetText(k, 1),ssrs1.GetText(k, 3),ssrs1.GetText(k, 4));
					String sql_index = "select WAGECODE,WAGENAME,BRANCHTYPE,BRANCHTYPE2,DESCRIPTION,INDEXSERISE,WAGETYPE,OPERATOR,MODIFYDATE,MODIFYTIME,MAKETIME,MAKEDATE,STATE from lrindex where wagecode = '"+ssrs1.GetText(k, 5)+"'";
					SSRS ssrs11 = exe.execSQL(sql_index);
					if(ssrs11.getMaxRow()>0){
						Element in = new Element("indexnode");
//						lrindex.addContent(in);
						in.addContent(new Element("wagecode").setText(ssrs11.GetText(1, 1)));
						in.addContent(new Element("wagename").setText(ssrs11.GetText(1, 2)));
						in.addContent(new Element("branchtype").setText(ssrs11.GetText(1, 3)));
						in.addContent(new Element("branchtype2").setText(ssrs11.GetText(1, 4)));
						in.addContent(new Element("description").setText(ssrs11.GetText(1, 5)));
						in.addContent(new Element("indexserise").setText(ssrs11.GetText(1, 6)));
						in.addContent(new Element("wagetype").setText(ssrs11.GetText(1, 7)));
						in.addContent(new Element("operator").setText(ssrs11.GetText(1, 8)));
						in.addContent(new Element("modifydate").setText(ssrs11.GetText(1, 9)));
						in.addContent(new Element("modifytime").setText(ssrs11.GetText(1, 10)));
						in.addContent(new Element("maketime").setText(ssrs11.GetText(1, 11)));
						in.addContent(new Element("makedate").setText(ssrs11.GetText(1, 12)));
						in.addContent(new Element("state").setText(ssrs11.GetText(1, 13)));
						key = "index"+ssrs11.GetText(1, 1);
						map.put(key, in);
					}
					
					
					String sql_lrassesindexlibrary = "select INDEXCODE,INDEXNAME,BRANCHTYPE,INDEXTYPE,INDEXSET,CALTYPE,CALCODE,DEFAULTVALUE,RESULTTYPE,CALPRPTY,BRANCHTYPE2,WAGECODE,DESCRIPTION,INDEXSERISE,DATATYPE,CALSQL,KIND,JSON,SQLTEMP,STATE from lrassessindexlibrary where wagecode = '"+ssrs1.GetText(k, 5)+"'";
					SSRS ssrs12 = exe.execSQL(sql_lrassesindexlibrary);
					for(int z=1;z<=ssrs12.getMaxRow();z++){
						Element in = new Element("lrassesindexlibrarynode"); 
//						lrassesindexlibrary.addContent(in);
						in.addContent(new Element("indexcode").setText(ssrs12.GetText(z, 1)));
						in.addContent(new Element("indexname").setText(ssrs12.GetText(z, 2)));
						in.addContent(new Element("branchtype").setText(ssrs12.GetText(z, 3)));
						in.addContent(new Element("indextype").setText(ssrs12.GetText(z, 4)));
						in.addContent(new Element("indexset").setText(ssrs12.GetText(z, 5)));
						in.addContent(new Element("caltype").setText(ssrs12.GetText(z, 6)));
						in.addContent(new Element("calcode").setText(ssrs12.GetText(z, 7)));
						in.addContent(new Element("defaultvalue").setText(ssrs12.GetText(z, 8)));
						in.addContent(new Element("resulttype").setText(ssrs12.GetText(z, 9))); 
						in.addContent(new Element("calprpty").setText(ssrs12.GetText(z, 10)));
						in.addContent(new Element("branchtype2").setText(ssrs12.GetText(z, 11)));
						in.addContent(new Element("wagecode").setText(ssrs12.GetText(z, 12)));
						System.out.println("-------------------------"+ssrs12.GetText(z, 12));
						in.addContent(new Element("description").setText(ssrs12.GetText(z, 13)));
						in.addContent(new Element("indexserise").setText(ssrs12.GetText(z, 14)));
						in.addContent(new Element("datatype").setText(ssrs12.GetText(z, 15)));
						in.addContent(new Element("calsql").setText(ssrs12.GetText(z, 16)));
						in.addContent(new Element("kind").setText(ssrs12.GetText(z, 17)));
						in.addContent(new Element("json").setText(ssrs12.GetText(z, 18)));
						in.addContent(new Element("sqltemp").setText(ssrs12.GetText(z, 19)));
						in.addContent(new Element("state").setText(ssrs12.GetText(z, 20)));
						key = "assesslibrary"+ssrs12.GetText(z, 1);
						map.put(key, in);
					}
				}
				String sql2 = "select BASECODE,INDEXCODE,INDEXNAME,INDEXTYPE,BRANCHTYPE,INDEXSET,CALTYPE,CALCODE,DATATYPE,DEFAULTVALUE,RESULTTYPE,CALPRPTY,BRANCHTYPE2,INDEXSERISE,isnull(CALSQL,' '),isnull(SQLTEMP,' '),MAININDEXFLAG,DESCRIPTION,isnull(ALLSET,' '),isnull(JSON,' '),AGENTGRADE from Lrassessindexp where 1=1  and indexcode in "
						+ indexcodeSet+") "+ Cond;
				SSRS ssrs2 = exe.execSQL(sql2);
				for(int j=1;j<=ssrs2.getMaxRow();j++){
					Element p = new Element("lrassessindexnode");
//					lrassessindex.addContent(p);
					p.addContent(new Element("basecode").setText(ssrs2.GetText(j, 1)));
					p.addContent(new Element("indexcode").setText(ssrs2.GetText(j, 2)));
					p.addContent(new Element("indexname").setText(ssrs2.GetText(j, 3)));
					p.addContent(new Element("indextype").setText(ssrs2.GetText(j, 4)));
					p.addContent(new Element("branchtype").setText(ssrs2.GetText(j, 5)));
					p.addContent(new Element("indexset").setText(ssrs2.GetText(j, 6)));
					p.addContent(new Element("caltype").setText(ssrs2.GetText(j, 7)));
					p.addContent(new Element("calcode").setText(ssrs2.GetText(j, 8)));
					p.addContent(new Element("datatype").setText(ssrs2.GetText(j, 9)));
					p.addContent(new Element("defaultvalue").setText(ssrs2.GetText(j, 10)));
					p.addContent(new Element("resulttype").setText(ssrs2.GetText(j, 11)));
					p.addContent(new Element("calprpty").setText(ssrs2.GetText(j, 12)));
					p.addContent(new Element("branchtype2").setText(ssrs2.GetText(j, 13)));
					p.addContent(new Element("indexserise").setText(ssrs2.GetText(j, 14)));
					p.addContent(new Element("calsql").setText(ssrs2.GetText(j, 15)));
					p.addContent(new Element("sqltemp").setText(ssrs2.GetText(j, 16)));
					p.addContent(new Element("mainindexflag").setText(ssrs2.GetText(j, 17)));
					p.addContent(new Element("description").setText(ssrs2.GetText(j, 18)));
					p.addContent(new Element("allset").setText(ssrs2.GetText(j, 19)));
					p.addContent(new Element("json").setText(ssrs2.GetText(j, 20)));
					p.addContent(new Element("agentgrade").setText(ssrs2.GetText(j, 21)));
				    key = "assses"+ssrs2.GetText(j, 2)+ssrs2.GetText(j, 1);
					map.put(key,p);
				}		
				for(Iterator it = map.entrySet().iterator(); it.hasNext();){
					Map.Entry e = (Map.Entry) it.next();  
					String key = e.getKey().toString();
					Element element = (Element) e.getValue();
					if(key.startsWith("bom")){ 
						lrbom.addContent(element);
//					}else if(key.startsWith("termphrase")){
//						lrtermphrase.addContent(element);	
//					}
//					else if(key.startsWith("termpara")){
//						lrtermpara.addContent(element);
					}else if(key.startsWith("term")){
						lrterm.addContent(element);
					}else if(key.startsWith("assses")){
						lrassessindex.addContent(element);
					}else if(key.startsWith("assesslibrary")){
						lrassessindexlibrary.addContent(element);
					}else if(key.startsWith("index")){
						lrindex.addContent(element);
					}else if(key.startsWith("vscomm")){
						lrindexvscomm.addContent(element);
					}
				}
					
				// 定义一个用于输出xml文档的类
				XMLOutputter XMLOut = new XMLOutputter(Format.getPrettyFormat());
				// 将生成的xml文档Doc输出到c盘的test.xml文档中
				XMLOut.output(Doc, PubFun.createFileOutputStream(path+"/Base.xml"));
			} catch (Exception e) {
				System.out.println("error :" + e.toString());
				e.printStackTrace();
			}

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

	public StringBuffer getIndexCode(String IndexCode, String BaseCode,String IndexType,String AgentGrade) {
		String sql = "select IndexSet from LRAssessIndexP where 1=1 and indexcode = '"
				+ IndexCode
				+ "' and BaseCode = '"
				+ BaseCode
				+ "' and indextype = '" + IndexType + "' and branchtype='1' and agentgrade = '"+AgentGrade+"'";
		if(IndexCode.startsWith("I")){
			String term = "select ID,NAME,BOMID,REMARK,DISPLAYORDER,DATATYPE,CALTYPE,ATTRIBUTE,CALSQL,OPERATOR,MODIFYDATE,MODIFYTIME,MAKETIME,MAKEDATE,STATE from  lrterm where id = '"+IndexCode+"'";
			SSRS s= exe.execSQL(term);
			if(s.getMaxRow()>0){
				Element p = new Element("lrtermnode");
//				lrterm.addContent(p);
				p.addContent(new Element("id").setText(s.GetText(1, 1)));
				p.addContent(new Element("name").setText(s.GetText(1, 2)));
				p.addContent(new Element("bomid").setText(s.GetText(1, 3)));
				p.addContent(new Element("remark").setText(s.GetText(1, 4)));
				p.addContent(new Element("displayorder").setText(s.GetText(1, 5)));
				p.addContent(new Element("datatype").setText(s.GetText(1, 6)));
				p.addContent(new Element("CalType").setText(s.GetText(1, 7)));
				p.addContent(new Element("attribute").setText(s.GetText(1, 8)));
				p.addContent(new Element("calsql").setText(s.GetText(1, 9)));
				p.addContent(new Element("operator").setText(s.GetText(1, 10)));
				p.addContent(new Element("modifydate").setText(s.GetText(1, 11)));
				p.addContent(new Element("modifytime").setText(s.GetText(1, 12)));
				p.addContent(new Element("maketime").setText(s.GetText(1, 13)));
				p.addContent(new Element("makedate").setText(s.GetText(1, 14)));
				p.addContent(new Element("state").setText(s.GetText(1, 15)));
				key = "term"+s.GetText(1, 1);
				map.put(key,p);
				SSRS ss;
//				String sql_termp = "select * from LRTERMPARA where termid = '"+s.GetText(1, 1)+"'";
//				ss = exe.execSQL(sql_termp);
//				for(int i=1;i<=ss.getMaxRow();i++){
//					Element e = new Element("lrtermparanode");
////					lrtermpara.addContent(e);
//					e.addContent(new Element("id").setText(ss.GetText(i, 1)));
//					e.addContent(new Element("termid").setText(ss.GetText(i, 2)));
//					e.addContent(new Element("paratype").setText(ss.GetText(i, 3)));
//					e.addContent(new Element("name").setText(ss.GetText(i, 4)));
//					e.addContent(new Element("operator").setText(ss.GetText(i, 5)));
//					e.addContent(new Element("modifydate").setText(ss.GetText(i, 6)));
//					e.addContent(new Element("modifytime").setText(ss.GetText(i, 7)));
//					e.addContent(new Element("maketime").setText(ss.GetText(i, 8)));
//					e.addContent(new Element("makedate").setText(ss.GetText(i, 9)));
//					key = "termpara"+ss.GetText(i, 1);
//					map.put(key, e);
//							
//				}				
//				String sql_lrtermphrase = "select * from lrtermphrase where termid = '"+s.GetText(1, 1)+"'";
//				ss = exe.execSQL(sql_lrtermphrase);
//				for(int i=1;i<=ss.getMaxRow();i++){
//					Element e = new Element("lrtermphrasenode");
////					lrtermphrase.addContent(e);
//					e.addContent(new Element("id").setText(ss.GetText(i, 1)));
//					e.addContent(new Element("termid").setText(ss.GetText(i, 2)));
//					e.addContent(new Element("phrasetype").setText(ss.GetText(i, 3)));
//					e.addContent(new Element("discription").setText(ss.GetText(i, 4)));
//					e.addContent(new Element("template").setText(ss.GetText(i, 5)));
//					e.addContent(new Element("operator").setText(ss.GetText(i, 6)));
//					e.addContent(new Element("modifydate").setText(ss.GetText(i, 7)));
//					e.addContent(new Element("modifytime").setText(ss.GetText(i, 8)));
//					e.addContent(new Element("maketime").setText(ss.GetText(i, 9)));
//					e.addContent(new Element("makedate").setText(ss.GetText(i, 10)));
//					key = "termphrase"+ss.GetText(i, 1);
//					map.put(key, e);
//				}
				
				String sql_lrbom = "select ID,NAME,REMARK,DISPLAYORDER,OPERATOR,MODIFYDATE,MODIFYTIME,MAKETIME,MAKEDATE,BRANCHTYPE,STATE from lrbom where id = '"+s.GetText(1, 3)+"'";
				ss = exe.execSQL(sql_lrbom);
				if(ss.getMaxRow()>0){
					Element e = new Element("lrbomnode");
//					lrbom.addContent(e);
					e.addContent(new Element("id").setText(ss.GetText(1, 1)));
					e.addContent(new Element("name").setText(ss.GetText(1, 2)));
					e.addContent(new Element("remark").setText(ss.GetText(1, 3)));
					e.addContent(new Element("discription").setText(ss.GetText(1, 4)));
					e.addContent(new Element("operator").setText(ss.GetText(1, 5)));
					e.addContent(new Element("modifydate").setText(ss.GetText(1, 6)));
					e.addContent(new Element("modifytime").setText(ss.GetText(1, 7)));
					e.addContent(new Element("maketime").setText(ss.GetText(1, 8)));
					e.addContent(new Element("makedate").setText(ss.GetText(1, 9)));
					e.addContent(new Element("branchtype").setText(ss.GetText(1, 10)));
					e.addContent(new Element("state").setText(ss.GetText(1, 11)));
					key = "bom"+ss.GetText(1, 1);
					map.put(key, e);
				}
			}
		}
		indexcodeSet.append(",'"+IndexCode+"'");
		String IndexSet = exe.getOneValue(sql);
		if (!"".equals(IndexSet) && IndexSet != null) {
			String[] indexcode = IndexSet.split(",");
			for (int i = 0; i < indexcode.length; i++) {
				getIndexCode(indexcode[i], BaseCode, IndexType,AgentGrade);
			}
		}
		System.out.println("indexcodeSet---" + indexcodeSet);
		return indexcodeSet;
	}
}
