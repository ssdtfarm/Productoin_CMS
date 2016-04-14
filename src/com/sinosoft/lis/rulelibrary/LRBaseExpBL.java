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
import java.util.LinkedHashMap;
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


public class LRBaseExpBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器
	private String NodeInfo = "";
	private ExeSQL exe = new ExeSQL();
	private StringBuffer indexcodeSet = new StringBuffer("(''");
	private String path="";
	private LinkedHashMap<String, Element> map = new LinkedHashMap();
	private String key;
	private String mBaseCode="";

	// 定义一个root作为xml文档的根元素
	private Element root = new Element("base");
	// 生成一个文档
	private Document Doc = new Document(root);
	private Element lrindexvscomm = new Element("lrindexvscomm");
	private Element lrassessindex = new Element("lrassessindex");
	private Element lrbom = new Element("lrbom");
	private Element lrterm = new Element("lrterm");
	private Element lrbase = new Element("lrbase");	
	private Element lrindex = new Element("lrindex");
	private Element lrassessindexlibrary = new Element("lrassessindexlibrary");
	
	public LRBaseExpBL() { 
	}

	/**
	 * 传输数据的公共方法
	 */
	public boolean check() {
		System.out.println("0------------check");
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
		mBaseCode  = (String) transferData.getValueByName("BaseCode");
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
		root.addContent(lrbom);
		root.addContent(lrterm);
		root.addContent(lrindex);
		root.addContent(lrassessindexlibrary);
		root.addContent(lrassessindex);
		root.addContent(lrindexvscomm);
			try {
				int k;
//				String sql_index = "select a.WAGECODE,a.WAGENAME,a.BRANCHTYPE,a.BRANCHTYPE2,a.DESCRIPTION,a.INDEXSERISE,a.WAGETYPE,a.OPERATOR,a.MODIFYDATE,a.MODIFYTIME,a.MAKETIME,a.MAKEDATE,a.STATE from lrindex a where exists (select 1 from lrassessindexlibrary b where a.wagecode = b.wagecode and exists (select 1 from lrassessindex c where c.basecode = '"+mBaseCode+"' and substring(c.indexcode, 1, 1) = 'R' and c.indexcode = b.indexcode))";
				String sql_index = "select a.WAGECODE,a.WAGENAME,a.BRANCHTYPE,a.BRANCHTYPE2,a.DESCRIPTION,a.INDEXSERISE,a.WAGETYPE,a.OPERATOR,a.MODIFYDATE,a.MODIFYTIME,a.MAKETIME,a.MAKEDATE,a.STATE from lrindex a where exists (select 1 from lrassessindexlibrary b where a.wagecode = b.wagecode and exists (select 1 from lrassessindex c where c.basecode = '"+mBaseCode+"' and substring(c.indexcode, 1, 1) = 'R' and c.indexcode = b.indexcode)) order by WageCode";
//				String sql_IndexVsComm = "select BASECODE,MANAGECOM,INDEXTYPE,AGENTGRADE,WAGECODE,WAGENAME,BRANCHTYPE,INDEXCODE,WAGEORDER,BRANCHTYPE2,INDEXSERISE,DESCRIPTION from LRIndexVsComm where 1=1  and basecode = '"+mBaseCode+"'";
				String sql_IndexVsComm = "select BASECODE,MANAGECOM,INDEXTYPE,AGENTGRADE,WAGECODE,WAGENAME,BRANCHTYPE,INDEXCODE,WAGEORDER,BRANCHTYPE2,INDEXSERISE,DESCRIPTION from LRIndexVsComm where 1=1  and basecode = '"+mBaseCode+"' order by BaseCode,ManageCom,AgentGrade,IndexType,WageCode";
//				String sql_lrassesindexlibrary = "select INDEXCODE,INDEXNAME,BRANCHTYPE,INDEXTYPE,INDEXSET,CALTYPE,CALCODE,DEFAULTVALUE,RESULTTYPE,CALPRPTY,BRANCHTYPE2,WAGECODE,DESCRIPTION,INDEXSERISE,DATATYPE,CALSQL,KIND,JSON,SQLTEMP,STATE from lrassessindexlibrary where  indexcode in (select distinct(indexcode) from lrassessindex where basecode = '"+mBaseCode+"' and substring(indexcode,1,1) ='R')";
				String sql_lrassesindexlibrary = "select INDEXCODE,INDEXNAME,BRANCHTYPE,INDEXTYPE,INDEXSET,CALTYPE,CALCODE,DEFAULTVALUE,RESULTTYPE,CALPRPTY,BRANCHTYPE2,WAGECODE,DESCRIPTION,INDEXSERISE,DATATYPE,CALSQL,KIND,JSON,SQLTEMP,STATE from lrassessindexlibrary where  indexcode in (select distinct(indexcode) from lrassessindex where basecode = '"+mBaseCode+"' and substring(indexcode,1,1) ='R') order by IndexCode";
//				String sql_assessindex = "select a.BASECODE,a.INDEXCODE,a.INDEXNAME,a.INDEXTYPE,a.BRANCHTYPE,a.INDEXSET,a.CALTYPE,a.CALCODE,a.DATATYPE,a.DEFAULTVALUE,a.RESULTTYPE,a.CALPRPTY,a.BRANCHTYPE2,a.INDEXSERISE,isnull(a.CALSQL,' '),isnull(a.SQLTEMP,' '),a.MAININDEXFLAG,a.DESCRIPTION,isnull(a.ALLSET,' '),isnull(a.JSON,' '),a.AGENTGRADE,a.ITableName,a.IColName from lrassessindex a where 1=1 and a.basecode = '"+mBaseCode+"'";
				String sql_assessindex = "select a.BASECODE,a.INDEXCODE,a.INDEXNAME,a.INDEXTYPE,a.BRANCHTYPE,a.INDEXSET,a.CALTYPE,a.CALCODE,a.DATATYPE,a.DEFAULTVALUE,a.RESULTTYPE,a.CALPRPTY,a.BRANCHTYPE2,a.INDEXSERISE,isnull(a.CALSQL,' '),isnull(a.SQLTEMP,' '),a.MAININDEXFLAG,a.DESCRIPTION,isnull(a.ALLSET,' '),isnull(a.JSON,' '),a.AGENTGRADE,a.ITableName,a.IColName from lrassessindex a where 1=1 and a.basecode = '"+mBaseCode+"' order by BaseCode,AgentGrade,IndexCode,IndexType";
//				String sql_base ="select basecode ,name ,status ,remark ,reason ,branchtype , branchtype2 , operator ,makedate ,maketime ,modifydate ,modifytime  from lrbase where basecode = '"+mBaseCode+"'";
				String sql_base ="select basecode ,name ,status ,remark ,reason ,branchtype , branchtype2 , operator ,makedate ,maketime ,modifydate ,modifytime  from lrbase where basecode = '"+mBaseCode+"' order by BaseCode";
				SSRS ssrs_IndexVsComm = exe.execSQL(sql_IndexVsComm);
				SSRS ssrs_index = exe.execSQL(sql_index);
				SSRS ssrs_lrassesindexlibrary = exe.execSQL(sql_lrassesindexlibrary);
				SSRS ssrs_assessindex = exe.execSQL(sql_assessindex);
				SSRS ssrs_base = exe.execSQL(sql_base);
				for ( k = 1; k <=ssrs_base.getMaxRow(); k++) {
				    Element p = new Element("lrbasenode");
					p.addContent(new Element("basecode").setText(ssrs_base.GetText(k, 1)));
					p.addContent(new Element("name").setText(ssrs_base.GetText(k, 2)));
					p.addContent(new Element("status").setText(ssrs_base.GetText(k, 3)));
					p.addContent(new Element("remark").setText(ssrs_base.GetText(k, 4)));
					p.addContent(new Element("reason").setText(ssrs_base.GetText(k, 5)));
					p.addContent(new Element("branchtype").setText(ssrs_base.GetText(k, 6)));
					p.addContent(new Element("branchtype2").setText(ssrs_base.GetText(k, 7)));
					p.addContent(new Element("operator").setText(ssrs_base.GetText(k, 8)));
					p.addContent(new Element("makedate").setText(ssrs_base.GetText(k, 9)));
					p.addContent(new Element("maketime").setText(ssrs_base.GetText(k, 10)));
					p.addContent(new Element("modifydate").setText(ssrs_base.GetText(k, 11)));
					p.addContent(new Element("modifytime").setText(ssrs_base.GetText(k, 12)));
					String key = "base"+mBaseCode;
					map.put(key, p);
				}
				for ( k = 1; k <=ssrs_IndexVsComm.getMaxRow(); k++) {
					Element p = new Element("lrindexvscommnode");
//					lrindexvscomm.addContent(p); 
					p.addContent(new Element("basecode").setText(ssrs_IndexVsComm.GetText(k, 1)));
					p.addContent(new Element("managecom").setText(ssrs_IndexVsComm.GetText(k, 2)));
					p.addContent(new Element("indextype").setText(ssrs_IndexVsComm.GetText(k, 3)));
					p.addContent(new Element("agentgrade").setText(ssrs_IndexVsComm.GetText(k, 4)));
					p.addContent(new Element("wagecode").setText(ssrs_IndexVsComm.GetText(k, 5)));
					p.addContent(new Element("wagename").setText(ssrs_IndexVsComm.GetText(k, 6)));
					p.addContent(new Element("branchtype").setText(ssrs_IndexVsComm.GetText(k, 7)));
					p.addContent(new Element("indexcode").setText(ssrs_IndexVsComm.GetText(k, 8)));
					p.addContent(new Element("wageorder").setText(ssrs_IndexVsComm.GetText(k, 9)));
					p.addContent(new Element("branchtype2").setText(ssrs_IndexVsComm.GetText(k, 10)));
					p.addContent(new Element("indexserise").setText(ssrs_IndexVsComm.GetText(k, 11)));
					p.addContent(new Element("description").setText(ssrs_IndexVsComm.GetText(k, 12)));
					String key = "vscomm"+ssrs_IndexVsComm.GetText(k, 1)
							+ssrs_IndexVsComm.GetText(k, 5) 
							+ssrs_IndexVsComm.GetText(k, 3)
							+ssrs_IndexVsComm.GetText(k, 2)
							+ssrs_IndexVsComm.GetText(k, 4);
					map.put(key, p);
				}
					for ( k = 1; k <=ssrs_index.getMaxRow(); k++) {
						Element in = new Element("lrindexnode");
//						lrindex.addContent(in);
						in.addContent(new Element("wagecode").setText(ssrs_index.GetText(k, 1)));
						in.addContent(new Element("wagename").setText(ssrs_index.GetText(k, 2)));
						in.addContent(new Element("branchtype").setText(ssrs_index.GetText(k, 3)));
						in.addContent(new Element("branchtype2").setText(ssrs_index.GetText(k, 4)));
						in.addContent(new Element("description").setText(ssrs_index.GetText(k, 5)));
						in.addContent(new Element("indexserise").setText(ssrs_index.GetText(k, 6)));
						in.addContent(new Element("wagetype").setText(ssrs_index.GetText(k, 7)));
						in.addContent(new Element("operator").setText(ssrs_index.GetText(k, 8)));
						in.addContent(new Element("modifydate").setText(ssrs_index.GetText(k, 9)));
						in.addContent(new Element("modifytime").setText(ssrs_index.GetText(k, 10)));
						in.addContent(new Element("maketime").setText(ssrs_index.GetText(k, 11)));
						in.addContent(new Element("makedate").setText(ssrs_index.GetText(k, 12)));
						in.addContent(new Element("state").setText(ssrs_index.GetText(k, 13)));
						key = "index"+ssrs_index.GetText(k, 1);
						map.put(key, in);
					}
					
					
					
					for(int z=1;z<=ssrs_lrassesindexlibrary.getMaxRow();z++){
						Element in = new Element("lrassessindexlibrarynode"); 
//						lrassesindexlibrary.addContent(in);
						in.addContent(new Element("indexcode").setText(ssrs_lrassesindexlibrary.GetText(z, 1)));
						in.addContent(new Element("indexname").setText(ssrs_lrassesindexlibrary.GetText(z, 2)));
						in.addContent(new Element("branchtype").setText(ssrs_lrassesindexlibrary.GetText(z, 3)));
						in.addContent(new Element("indextype").setText(ssrs_lrassesindexlibrary.GetText(z, 4)));
						in.addContent(new Element("indexset").setText(ssrs_lrassesindexlibrary.GetText(z, 5)));
						in.addContent(new Element("caltype").setText(ssrs_lrassesindexlibrary.GetText(z, 6)));
						in.addContent(new Element("calcode").setText(ssrs_lrassesindexlibrary.GetText(z, 7)));
						in.addContent(new Element("defaultvalue").setText(ssrs_lrassesindexlibrary.GetText(z, 8)));
						in.addContent(new Element("resulttype").setText(ssrs_lrassesindexlibrary.GetText(z, 9))); 
						in.addContent(new Element("calprpty").setText(ssrs_lrassesindexlibrary.GetText(z, 10)));
						in.addContent(new Element("branchtype2").setText(ssrs_lrassesindexlibrary.GetText(z, 11)));
						in.addContent(new Element("wagecode").setText(ssrs_lrassesindexlibrary.GetText(z, 12)));
						in.addContent(new Element("description").setText(ssrs_lrassesindexlibrary.GetText(z, 13)));
						in.addContent(new Element("indexserise").setText(ssrs_lrassesindexlibrary.GetText(z, 14)));
						in.addContent(new Element("datatype").setText(ssrs_lrassesindexlibrary.GetText(z, 15)));
						in.addContent(new Element("calsql").setText(ssrs_lrassesindexlibrary.GetText(z, 16)));
						in.addContent(new Element("kind").setText(ssrs_lrassesindexlibrary.GetText(z, 17)));
						in.addContent(new Element("json").setText(ssrs_lrassesindexlibrary.GetText(z, 18)));
						in.addContent(new Element("sqltemp").setText(ssrs_lrassesindexlibrary.GetText(z, 19)));
						in.addContent(new Element("state").setText(ssrs_lrassesindexlibrary.GetText(z, 20)));
						key = "assesslibrary"+ssrs_lrassesindexlibrary.GetText(z, 1);
						map.put(key, in);
					}
				
				for(int j=1;j<=ssrs_assessindex.getMaxRow();j++){
					Element p = new Element("lrassessindexnode");
//					lrassessindex.addContent(p);
					p.addContent(new Element("basecode").setText(ssrs_assessindex.GetText(j, 1)));
					p.addContent(new Element("indexcode").setText(ssrs_assessindex.GetText(j, 2)));
					p.addContent(new Element("indexname").setText(ssrs_assessindex.GetText(j, 3)));
					p.addContent(new Element("indextype").setText(ssrs_assessindex.GetText(j, 4)));
					p.addContent(new Element("branchtype").setText(ssrs_assessindex.GetText(j, 5)));
					p.addContent(new Element("indexset").setText(ssrs_assessindex.GetText(j, 6)));
					p.addContent(new Element("caltype").setText(ssrs_assessindex.GetText(j, 7)));
					p.addContent(new Element("calcode").setText(ssrs_assessindex.GetText(j, 8)));
					p.addContent(new Element("datatype").setText(ssrs_assessindex.GetText(j, 9)));
					p.addContent(new Element("defaultvalue").setText(ssrs_assessindex.GetText(j, 10)));
					p.addContent(new Element("resulttype").setText(ssrs_assessindex.GetText(j, 11)));
					p.addContent(new Element("calprpty").setText(ssrs_assessindex.GetText(j, 12)));
					p.addContent(new Element("branchtype2").setText(ssrs_assessindex.GetText(j, 13)));
					p.addContent(new Element("indexserise").setText(ssrs_assessindex.GetText(j, 14)));
					p.addContent(new Element("calsql").setText(ssrs_assessindex.GetText(j, 15)));
					p.addContent(new Element("sqltemp").setText(ssrs_assessindex.GetText(j, 16)));
					p.addContent(new Element("mainindexflag").setText(ssrs_assessindex.GetText(j, 17)));
					p.addContent(new Element("description").setText(ssrs_assessindex.GetText(j, 18)));
					p.addContent(new Element("allset").setText(ssrs_assessindex.GetText(j, 19)));
					p.addContent(new Element("json").setText(ssrs_assessindex.GetText(j, 20)));
					p.addContent(new Element("agentgrade").setText(ssrs_assessindex.GetText(j, 21)));
					p.addContent(new Element("itablename").setText(ssrs_assessindex.GetText(j, 22)));
					p.addContent(new Element("icolname").setText(ssrs_assessindex.GetText(j, 23)));
				    key = "assses"+ssrs_assessindex.GetText(j, 2)
				    		+ssrs_assessindex.GetText(j, 1)
				    		+ssrs_assessindex.GetText(j, 21)
				    		+ssrs_assessindex.GetText(j, 4);
					map.put(key,p);
				}		
				getIndexCode(mBaseCode);
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
					}else if(key.startsWith("assesslibrary")){
						lrassessindexlibrary.addContent(element);
					}else if(key.startsWith("assses")){
						lrassessindex.addContent(element);
					}else if(key.startsWith("index")){
						lrindex.addContent(element);
					}else if(key.startsWith("vscomm")){
						lrindexvscomm.addContent(element);
					}else if(key.startsWith("base")){
						root.addContent(element);
					}
				}
					
				// 定义一个用于输出xml文档的类
				XMLOutputter XMLOut = new XMLOutputter(Format.getPrettyFormat());
				// 将生成的xml文档Doc输出到c盘的test.xml文档中
				XMLOut.output(Doc, PubFun.createFileOutputStream(path+"/Base-"+mBaseCode+".xml"));
			} catch (Exception e) {
				System.out.println("error :" + e.toString());
				e.printStackTrace();
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

	public void getIndexCode( String BaseCode) {
				String term = "select ID,NAME,BOMID,REMARK,DISPLAYORDER,DATATYPE,CALTYPE,ATTRIBUTE,CALSQL,OPERATOR,MODIFYDATE,MODIFYTIME,MAKETIME,MAKEDATE,STATE from  lrterm where id in (select distinct(indexcode) from LRAssessIndex where 1=1 and BaseCode = '"+ BaseCode+"' and substring(indexcode,1,1) ='I') order by Id";
				String sql_lrbom = "select ID,NAME,REMARK,DISPLAYORDER,OPERATOR,MODIFYDATE,MODIFYTIME,MAKETIME,MAKEDATE,BRANCHTYPE,STATE from lrbom a where exists (select 1 from lrterm b where a.id = b.bomid and exists (select 1 from lrassessindex c where c.basecode = '"+ BaseCode+"' and substring(c.indexcode, 1, 1) = 'I' and c.indexcode = b.id)) order by Id";
				SSRS s= exe.execSQL(term);
				SSRS ss = exe.execSQL(sql_lrbom);
				for(int i=1;i<=s.getMaxRow();i++){
					Element p = new Element("lrtermnode");
					//lrterm.addContent(p);
					p.addContent(new Element("id").setText(s.GetText(i, 1)));
					p.addContent(new Element("name").setText(s.GetText(i, 2)));
					p.addContent(new Element("bomid").setText(s.GetText(i, 3)));
					p.addContent(new Element("remark").setText(s.GetText(i, 4)));
					p.addContent(new Element("displayorder").setText(s.GetText(i, 5)));
					p.addContent(new Element("datatype").setText(s.GetText(i, 6)));
					p.addContent(new Element("caltype").setText(s.GetText(i, 7)));
					p.addContent(new Element("attribute").setText(s.GetText(i, 8)));
					p.addContent(new Element("calsql").setText(s.GetText(i, 9)));
					p.addContent(new Element("operator").setText(s.GetText(i, 10)));
					p.addContent(new Element("modifydate").setText(s.GetText(i, 11)));
					p.addContent(new Element("modifytime").setText(s.GetText(i, 12)));
					p.addContent(new Element("maketime").setText(s.GetText(i, 13)));
					p.addContent(new Element("makedate").setText(s.GetText(i, 14)));
					p.addContent(new Element("state").setText(s.GetText(i, 15)));
					key = "term"+s.GetText(i, 1);
					map.put(key,p);
			}
			 for(int i=1;i<=ss.getMaxRow();i++){
						Element e = new Element("lrbomnode");
//						lrbom.addContent(e);
						e.addContent(new Element("id").setText(ss.GetText(i, 1)));
						e.addContent(new Element("name").setText(ss.GetText(i, 2)));
						e.addContent(new Element("remark").setText(ss.GetText(i, 3)));
						e.addContent(new Element("discription").setText(ss.GetText(i, 4)));
						e.addContent(new Element("operator").setText(ss.GetText(i, 5)));
						e.addContent(new Element("modifydate").setText(ss.GetText(i, 6)));
						e.addContent(new Element("modifytime").setText(ss.GetText(i, 7)));
						e.addContent(new Element("maketime").setText(ss.GetText(i, 8)));
						e.addContent(new Element("makedate").setText(ss.GetText(i, 9)));
						e.addContent(new Element("branchtype").setText(ss.GetText(i, 10)));
						e.addContent(new Element("state").setText(ss.GetText(i, 11)));
						key = "bom"+ss.GetText(i, 1);
						map.put(key, e);
			 }
	}
}
