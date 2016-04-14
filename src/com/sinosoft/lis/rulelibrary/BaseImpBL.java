/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LRAssessIndexDB;
import com.sinosoft.lis.db.LRAssessIndexLibraryDB;
import com.sinosoft.lis.db.LRAssessIndexPDB;
import com.sinosoft.lis.db.LRBaseDB;
import com.sinosoft.lis.db.LRBomDB;
import com.sinosoft.lis.db.LRIndexDB;
import com.sinosoft.lis.db.LRTermDB;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.schema.LRAssessIndexLibrarySchema;
import com.sinosoft.lis.schema.LRAssessIndexPSchema;
import com.sinosoft.lis.schema.LRAssessIndexSchema;
import com.sinosoft.lis.schema.LRBaseSchema;
import com.sinosoft.lis.schema.LRBomSchema;
import com.sinosoft.lis.schema.LRIndexSchema;
//import com.sinosoft.lis.schema.LRTermParaSchema;
//import com.sinosoft.lis.schema.LRTermPhraseSchema;
import com.sinosoft.lis.schema.LRTermSchema;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.DBConnPool;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class BaseImpBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器
	private String mFileName = "";
	private String mFilePath = "";

	public BaseImpBL() {
	}

	/**
	 * 传输数据的公共方法
	 */
	public boolean check() {
		return true;
	}

	public boolean submitData(VData cInputData, String cOperate) {
		System.out.println("BaseImpBl");
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
//		VData tVData = new VData();
//		tVData.add(mMap);
//		PubSubmit tPubSubmit = new PubSubmit();
//		if (!tPubSubmit.submitData(tVData, "")) {
//			// @@错误处理
//			CError.buildErr(this, "数据提交失败!");
//			return false;
//		}
		return true;
	}

	/**
	 * 从输入数据中得到所有对象 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
	 */
	public boolean getInputData(VData cInputData) {
		// 全局变量
		mGlobalInput = (GlobalInput) cInputData.getObjectByObjectName(
				"GlobalInput", 0);
		TransferData transferData = (TransferData) cInputData
				.getObjectByObjectName("TransferData", 0);
		mFileName = (String) transferData.getValueByName("FileName");
		mFilePath = (String) transferData.getValueByName("FilePath");
		System.out.println("mFileName--->" + mFileName);
		System.out.println("mFilePath--->" + mFilePath);
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
	    Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		try {
		    /** 数据库连接  **/
			conn = DBConnPool.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ExeSQL exeSQL = new ExeSQL(conn);
	        
			System.out.println(mFilePath + "/upload/" + mFileName);
			InputStream file = PubFun.createFileInputStream(mFilePath + "/upload/"+ mFileName);
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(file);// 获得文档对象
			Element root = document.getRootElement();// 获得根节点
			
			String base = "";
			List<Element> list = root.getChildren("lrbasenode");
			Element e_base = list.get(0);
			base = e_base.getChildText("basecode");
			System.out.println("base----->"+base);
			LRBaseSchema tLRBaseSchema = new LRBaseSchema();
			tLRBaseSchema.setBaseCode(base);
			tLRBaseSchema.setName(e_base.getChildText("name"));
			tLRBaseSchema.setStatus(e_base.getChildText("status"));
			tLRBaseSchema.setRemark(e_base.getChildText("remark"));
			tLRBaseSchema.setReason(e_base.getChildText("reason"));
			tLRBaseSchema.setBranchType(e_base.getChildText("branchtype"));
			tLRBaseSchema.setBranchType2(e_base.getChildText("branchtype2"));
			tLRBaseSchema.setOperator(e_base.getChildText("operator"));
			tLRBaseSchema.setMakeDate(e_base.getChildText("makedate"));
			tLRBaseSchema.setMakeTime(e_base.getChildText("maketime"));
			tLRBaseSchema.setModifyDate(e_base.getChildText("modifydate"));
			tLRBaseSchema.setModifyTime(e_base.getChildText("modifytime"));
			LRBaseDB tLRBaseDB = new LRBaseDB(conn);
			tLRBaseDB.setSchema(tLRBaseSchema);
			if(!tLRBaseDB.delete()) {this.mErrors.copyAllErrors(tLRBaseDB.mErrors);return false;}
			if(!tLRBaseDB.insert()) {this.mErrors.copyAllErrors(tLRBaseDB.mErrors);return false;}
			
			String delete1 = "delete from lrassessindexp where basecode = '"+base+"'";
			String delete2 = "delete from lrassessindex  where basecode = '"+base+"'";
			String delete3 = "delete from lrindexvscommp where basecode = '"+base+"'";
			String delete4 = "delete from lrindexvscomm  where basecode = '"+base+"'";
//			mMap.put(delete1, "DELETE");
//			mMap.put(delete2, "DELETE");
//			mMap.put(delete3, "DELETE");
//			mMap.put(delete4, "DELETE");
			if(!exeSQL.execUpdateSQL(delete1)) {this.mErrors.copyAllErrors(exeSQL.mErrors);return false;}
			if(!exeSQL.execUpdateSQL(delete2)) {this.mErrors.copyAllErrors(exeSQL.mErrors);return false;}
			if(!exeSQL.execUpdateSQL(delete3)) {this.mErrors.copyAllErrors(exeSQL.mErrors);return false;}
			if(!exeSQL.execUpdateSQL(delete4)) {this.mErrors.copyAllErrors(exeSQL.mErrors);return false;}
			
			List<Element> list_assessindex = root.getChildren("lrassessindex");
			for (Element e : list_assessindex) {
				List<Element> x = e.getChildren("lrassessindexnode");
				for (Element em : x) {
					String basecode = em.getChildText("basecode");
					String indexcode = em.getChildText("indexcode");
					String indexname = em.getChildText("indexname");
					String indextype = em.getChildText("indextype");
					String branchtype = em.getChildText("branchtype");
					String indexset = em.getChildText("indexset");
					String caltype = em.getChildText("caltype");
					String calcode = em.getChildText("calcode");
					String datatype = em.getChildText("datatype");
					String defaultvalue = em.getChildText("defaultvalue");
					String resulttype = em.getChildText("resulttype");
					String calprpty = em.getChildText("calprpty");
					String branchtype2 = em.getChildText("branchtype2");
					String indexserise = em.getChildText("indexserise");
					String calsql = em.getChildText("calsql") ;
					String sqltemp = em.getChildText("sqltemp") ;
					String mainindexflag = em.getChildText("mainindexflag");
					String description = em.getChildText("description");
					String allset = em.getChildText("allset") ;
					String json = em.getChildText("json") ;
					String agentgrade = em.getChildText("agentgrade") ;
					String itablename = em.getChildText("itablename") ;
					String icolname = em.getChildText("icolname") ;
					LRAssessIndexPSchema tLRAssessIndexPSchema = new LRAssessIndexPSchema();
					LRAssessIndexSchema tLRAssessIndexSchema = new LRAssessIndexSchema();
					tLRAssessIndexSchema.setAllSet(allset);
					tLRAssessIndexSchema.setBaseCode(basecode);
					tLRAssessIndexSchema.setBranchType(branchtype);
					tLRAssessIndexSchema.setBranchType2(branchtype2);
					tLRAssessIndexSchema.setCalCode(calcode);
					tLRAssessIndexSchema.setCalPrpty(calprpty);
					tLRAssessIndexSchema.setCalSql(calsql);
					tLRAssessIndexSchema.setCalType(caltype);
					tLRAssessIndexSchema.setDataType(datatype);
					tLRAssessIndexSchema.setDefaultValue(defaultvalue);
					tLRAssessIndexSchema.setDescription(description);
					tLRAssessIndexSchema.setIndexCode(indexcode);
					tLRAssessIndexSchema.setIndexName(indexname);
					tLRAssessIndexSchema.setIndexSerise(indexserise);
					tLRAssessIndexSchema.setIndexSet(indexset);
					tLRAssessIndexSchema.setIndexType(indextype);
					tLRAssessIndexSchema.setMainIndexFlag(mainindexflag);
					tLRAssessIndexSchema.setResultType(resulttype);
					tLRAssessIndexSchema.setAgentGrade(agentgrade);
					tLRAssessIndexSchema.setITableName(itablename);
					tLRAssessIndexSchema.setIColName(icolname);
					tLRAssessIndexSchema.setSqlTemp(sqltemp);
//					tLRAssessIndexSchema.setJson(json);
					
					tLRAssessIndexPSchema.setAllSet(allset);
					tLRAssessIndexPSchema.setBaseCode(basecode);
					tLRAssessIndexPSchema.setBranchType(branchtype);
					tLRAssessIndexPSchema.setBranchType2(branchtype2);
					tLRAssessIndexPSchema.setCalCode(calcode);
					tLRAssessIndexPSchema.setCalPrpty(calprpty);
					tLRAssessIndexPSchema.setCalSql(calsql);
					tLRAssessIndexPSchema.setCalType(caltype);
					tLRAssessIndexPSchema.setDataType(datatype);
					tLRAssessIndexPSchema.setDefaultValue(defaultvalue);
					tLRAssessIndexPSchema.setDescription(description);
					tLRAssessIndexPSchema.setIndexCode(indexcode);
					tLRAssessIndexPSchema.setIndexName(indexname);
					tLRAssessIndexPSchema.setIndexSerise(indexserise);
					tLRAssessIndexPSchema.setIndexSet(indexset);
					tLRAssessIndexPSchema.setIndexType(indextype);
					tLRAssessIndexPSchema.setMainIndexFlag(mainindexflag);
					tLRAssessIndexPSchema.setResultType(resulttype);
					tLRAssessIndexPSchema.setAgentGrade(agentgrade);
					tLRAssessIndexPSchema.setSqlTemp(sqltemp);
//					tLRAssessIndexPSchema.setJson(json);
//					mMap.put(tLRAssessIndexSchema, "INSERT");
//					mMap.put(tLRAssessIndexPSchema, "INSERT");

					LRAssessIndexPDB tLRAssessIndexPDB = new LRAssessIndexPDB(conn);
					tLRAssessIndexPDB.setSchema(tLRAssessIndexPSchema);
					if(!tLRAssessIndexPDB.insert()) {this.mErrors.copyAllErrors(tLRAssessIndexPDB.mErrors);return false;}
					
//					System.out.println("开始更新json");
					stmt.executeUpdate("UPDATE LRAssessIndexP SET json='"+json +"' WHERE indexcode='"+indexcode+"' and indextype='"+indextype+"' and agentgrade='"+agentgrade+"' and basecode='"+basecode+"'");
//					rs = stmt.executeQuery("SELECT json FROM LRAssessIndexP WHERE indexcode='"+indexcode+"' and indextype='"+indextype+"' and agentgrade='"+agentgrade+"' and basecode='"+basecode+"' FOR UPDATE");
//					while (rs.next()) {
//						oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("json");
////						System.out.println("json --------->"+clob.toString());
//						out = new BufferedWriter(clob.getCharacterOutputStream());
//						in = new BufferedReader(new StringReader(json));
//						int c;
//						while ((c = in.read()) != -1) {
//							out.write(c);
//						}
//						try { out.close(); } catch (Exception ecp) { ecp.printStackTrace(); }
//						try { in.close(); } catch (Exception ecp) { ecp.printStackTrace(); }
//					}

					LRAssessIndexDB tLRAssessIndexDB = new LRAssessIndexDB(conn);
					tLRAssessIndexDB.setSchema(tLRAssessIndexSchema);
					if(!tLRAssessIndexDB.insert()) {this.mErrors.copyAllErrors(tLRAssessIndexDB.mErrors);return false;}
					
					stmt.executeUpdate("UPDATE LRAssessIndex SET json='"+json +"' WHERE indexcode='"+indexcode+"' and indextype='"+indextype+"' and agentgrade='"+agentgrade+"' and basecode='"+basecode+"'");
//					rs = stmt.executeQuery("SELECT json FROM LRAssessIndex WHERE indexcode='"+indexcode+"' and indextype='"+indextype+"' and agentgrade='"+agentgrade+"' and basecode='"+basecode+"' FOR UPDATE");
//					while (rs.next()) {
//						oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("json");
//						out = new BufferedWriter(clob.getCharacterOutputStream());
//						in = new BufferedReader(new StringReader(json));
//						int c;
//						while ((c = in.read()) != -1) {
//							out.write(c);
//						}
//						try { out.close(); } catch (Exception ecp) { ecp.printStackTrace(); }
//						try { in.close(); } catch (Exception ecp) { ecp.printStackTrace(); }
//					}
					
				}
			}
			List<Element> list_indexvscomm = root.getChildren("lrindexvscomm");
			for (Element e1 : list_indexvscomm) {
				List<Element> x1 = e1.getChildren("lrindexvscommnode");
				for (Element em : x1) {
					String basecode = em.getChildText("basecode");
					String branchtype = em.getChildText("branchtype");
					String branchtype2 = em.getChildText("branchtype2");
					String description = em.getChildText("description");
					String indexcode = em.getChildText("indexcode");
					String indexserise = em.getChildText("indexserise");
					String managecom = em.getChildText("managecom");
					String indextype = em.getChildText("indextype");
					String agentgrade = em.getChildText("agentgrade");
					String wagecode = em.getChildText("wagecode");
					String wagename = em.getChildText("wagename");
					String wageorder = em.getChildText("wageorder");
					String sql = "insert into LRIndexVsCommP ( BaseCode,ManageCom,AgentGrade,WageCode,WageName,BranchType,IndexCode,WageOrder,BranchType2,IndexSerise,Description,indextype ) "
							+ "values ( '"
							+ basecode
							+ "','"
							+ managecom
							+ "','"
							+ agentgrade
							+ "','"
							+ wagecode
							+ "','"
							+ wagename
							+ "','"
							+ branchtype
							+ "','"
							+ indexcode
							+ "','"
							+ wageorder
							+ "','"
							+ branchtype2
							+ "','"
							+ indexserise
							+ "','"
							+ description
							+ "','"
							+ indextype + "' ) ";
					String sql1 = "insert into LRIndexVsComm ( BaseCode,ManageCom,AgentGrade,WageCode,WageName,BranchType,IndexCode,WageOrder,BranchType2,IndexSerise,Description,indextype ) "
							+ "values ( '"
							+ basecode
							+ "','"
							+ managecom
							+ "','"
							+ agentgrade
							+ "','"
							+ wagecode
							+ "','"
							+ wagename
							+ "','"
							+ branchtype
							+ "','"
							+ indexcode
							+ "','"
							+ wageorder
							+ "','"
							+ branchtype2
							+ "','"
							+ indexserise
							+ "','"
							+ description
							+ "','"
							+ indextype + "' ) ";
//					System.out.println("sql------------------"+sql);
//					mMap.put(sql, "INSERT");
//					mMap.put(sql1, "INSERT");
					if(!exeSQL.execUpdateSQL(sql)) {this.mErrors.copyAllErrors(exeSQL.mErrors);return false;}
					if(!exeSQL.execUpdateSQL(sql1)) {this.mErrors.copyAllErrors(exeSQL.mErrors);return false;}

				}
			}

			List<Element> list_bom = root.getChildren("lrbom");
			for (Element e : list_bom) {
				List<Element> x = e.getChildren("lrbomnode");
				for (Element em : x) {
					String id = em.getChildText("id");
					String name = em.getChildText("name");
					String remark = em.getChildText("remark");
					String displayorder = em.getChildText("displayorder");
					String operator = em.getChildText("operator");
					String modifydate = em.getChildText("modifydate");
					String modifytime = em.getChildText("modifytime");
					String maketime = em.getChildText("maketime");
					String makedate = em.getChildText("makedate");
					String branchtype = em.getChildText("branchtype");
					String state = em.getChildText("state");
					LRBomSchema tLRBomSchema = new LRBomSchema();
					tLRBomSchema.setId(id);
					tLRBomSchema.setName(name);
					tLRBomSchema.setRemark(remark);
					tLRBomSchema.setDisPlayOrder(displayorder);
					tLRBomSchema.setOperator(operator);
					tLRBomSchema.setMakeDate(makedate);
					tLRBomSchema.setMakeTime(maketime);
					tLRBomSchema.setModifyDate(modifydate);
					tLRBomSchema.setModifyTime(modifytime);
					tLRBomSchema.setBranchType(branchtype);
					tLRBomSchema.setState(state);
//					mMap.put(tLRBomSchema, "DELETE&INSERT");

					LRBomDB tLRBomDB = new LRBomDB(conn);
					tLRBomDB.setSchema(tLRBomSchema);
					if(!tLRBomDB.delete()) {this.mErrors.copyAllErrors(tLRBomDB.mErrors);return false;}
					if(!tLRBomDB.insert()) {this.mErrors.copyAllErrors(tLRBomDB.mErrors);return false;}
				}
			}

			List<Element> list_lrterm = root.getChildren("lrterm");
			for (Element e : list_lrterm) {
				List<Element> x = e.getChildren("lrtermnode");
				for (Element em : x) {
					String id = em.getChildText("id");
					String name = em.getChildText("name");
					String bomid = em.getChildText("bomid");
					String remark = em.getChildText("remark");
					String displayorder = em.getChildText("displayorder");
					String datatype = em.getChildText("datatype");
					String caltype = em.getChildText("caltype");
					String attribute = em.getChildText("attribute");
					String calsql = em.getChildText("calsql") ;
					String operator = em.getChildText("operator");
					String modifydate = em.getChildText("modifydate");
					String modifytime = em.getChildText("modifytime");
					String maketime = em.getChildText("maketime");
					String makedate = em.getChildText("makedate");
					String state  = em.getChildText("state");
					LRTermSchema tLRTermSchema = new LRTermSchema();
					tLRTermSchema.setId(id);
					tLRTermSchema.setName(name);
					tLRTermSchema.setBomId(bomid);
					tLRTermSchema.setRemark(remark);
					tLRTermSchema.setDisPlayOrder(displayorder);
					tLRTermSchema.setDataType(datatype);
					tLRTermSchema.setCalType(caltype);
					tLRTermSchema.setAttribute(attribute);
					tLRTermSchema.setCalSql(calsql);
					tLRTermSchema.setOperator(operator);
					tLRTermSchema.setMakeDate(makedate);
					tLRTermSchema.setMakeTime(maketime);
					tLRTermSchema.setModifyDate(modifydate);
					tLRTermSchema.setModifyTime(modifytime);
					tLRTermSchema.setState(state);
//					mMap.put(tLRTermSchema, "DELETE&INSERT");

					LRTermDB tLRTermDB = new LRTermDB(conn);
					tLRTermDB.setSchema(tLRTermSchema);
					if(!tLRTermDB.delete()) {this.mErrors.copyAllErrors(tLRTermDB.mErrors);return false;}
					if(!tLRTermDB.insert()) {this.mErrors.copyAllErrors(tLRTermDB.mErrors);return false;}
				}
			}

			List<Element> list_lrindex = root.getChildren("lrindex");
			for (Element e : list_lrindex) {
				List<Element> x = e.getChildren("lrindexnode");
				for (Element em : x) {
					String wagecode = em.getChildText("wagecode");
					String wagename = em.getChildText("wagename");
					String branchtype = em.getChildText("branchtype");
					String branchtype2 = em.getChildText("branchtype2");
					String description = em.getChildText("description");
					String indexserise = em.getChildText("indexserise");
					String wagetype = em.getChildText("wagetype");
					String operator = em.getChildText("operator");
					String modifydate = em.getChildText("modifydate");
					String modifytime = em.getChildText("modifytime");
					String maketime = em.getChildText("maketime");
					String makedate = em.getChildText("makedate");
					String state = em.getChildText("state");
					LRIndexSchema tLRIndexSchema = new LRIndexSchema();
					tLRIndexSchema.setWageCode(wagecode);
					tLRIndexSchema.setWageName(wagename);
					tLRIndexSchema.setBranchType(branchtype);
					tLRIndexSchema.setBranchType2(branchtype2);
					tLRIndexSchema.setDescription(description);
					tLRIndexSchema.setIndexSerise(indexserise);
					tLRIndexSchema.setWageType(wagetype);
					tLRIndexSchema.setOperator(operator);
					tLRIndexSchema.setMakeDate(makedate);
					tLRIndexSchema.setMakeTime(maketime);
					tLRIndexSchema.setModifyDate(modifydate);
					tLRIndexSchema.setModifyTime(modifytime);
					tLRIndexSchema.setState(state);
//					mMap.put(tLRIndexSchema, "DELETE&INSERT");

					LRIndexDB tLRIndexDB = new LRIndexDB(conn);
					tLRIndexDB.setSchema(tLRIndexSchema);
					if(!tLRIndexDB.delete()) {this.mErrors.copyAllErrors(tLRIndexDB.mErrors);return false;}
					if(!tLRIndexDB.insert()) {this.mErrors.copyAllErrors(tLRIndexDB.mErrors);return false;}
				}
			}

			List<Element> list_libr = root.getChildren("lrassessindexlibrary");
			for (Element e : list_libr) {
				List<Element> x = e.getChildren("lrassessindexlibrarynode");
				for (Element em : x) {
					String indexcode = em.getChildText("indexcode");
					String indexname = em.getChildText("indexname");
					String branchtype = em.getChildText("branchtype");
					String indextype = em.getChildText("indextype");
					String indexset = em.getChildText("indexset") ;;
					String caltype = em.getChildText("caltype");
					String calcode = em.getChildText("calcode");
					String defaultvalue = em.getChildText("defaultvalue");
					String resulttype = em.getChildText("resulttype");
					String calprpty = em.getChildText("calprpty");
					String branchtype2 = em.getChildText("branchtype2 ");
					String wagecode = em.getChildText("wagecode");
					String description = em.getChildText("description ");
					String indexserise = em.getChildText("indexserise ");
					String datatype = em.getChildText("datatype");
					String calsql = em.getChildText("calsql") ;;
					String kind = em.getChildText("kind");
					String json = em.getChildText("json") ;
					String state = em.getChildText("state") ;
					LRAssessIndexLibrarySchema tLRAssessIndexLibrarySchema = new LRAssessIndexLibrarySchema();
					tLRAssessIndexLibrarySchema.setIndexCode(indexcode);
					tLRAssessIndexLibrarySchema.setIndexName(indexname);
					tLRAssessIndexLibrarySchema.setBranchType(branchtype);
					tLRAssessIndexLibrarySchema.setIndexType(indextype);
					tLRAssessIndexLibrarySchema.setIndexSet(indexset);
					tLRAssessIndexLibrarySchema.setCalType(caltype);
					tLRAssessIndexLibrarySchema.setCalCode(calcode);
					tLRAssessIndexLibrarySchema.setDefaultValue(defaultvalue);
					tLRAssessIndexLibrarySchema.setResultType(resulttype);
					tLRAssessIndexLibrarySchema.setCalPrpty(calprpty);
					tLRAssessIndexLibrarySchema.setBranchType2(branchtype2);
					tLRAssessIndexLibrarySchema.setWageCode(wagecode);
					tLRAssessIndexLibrarySchema.setDescription(description);
					tLRAssessIndexLibrarySchema.setIndexSerise(indexserise);
					tLRAssessIndexLibrarySchema.setDataType(datatype);
					tLRAssessIndexLibrarySchema.setCalSql(calsql);
					tLRAssessIndexLibrarySchema.setKind(kind);
//					tLRAssessIndexLibrarySchema.setJson(json);
					tLRAssessIndexLibrarySchema.setState(state);

//					mMap.put(tLRAssessIndexLibrarySchema, "DELETE&INSERT");

					LRAssessIndexLibraryDB tLRAssessIndexLibraryDB = new LRAssessIndexLibraryDB(conn);
					tLRAssessIndexLibraryDB.setSchema(tLRAssessIndexLibrarySchema);
					if(!tLRAssessIndexLibraryDB.delete()) {this.mErrors.copyAllErrors(tLRAssessIndexLibraryDB.mErrors);return false;}
					if(!tLRAssessIndexLibraryDB.insert()) {this.mErrors.copyAllErrors(tLRAssessIndexLibraryDB.mErrors);return false;}
					
					stmt.executeUpdate("UPDATE LRAssessIndexLibrary SET json='"+json +"' WHERE indexcode='"+indexcode+"'");
//					rs = stmt.executeQuery("SELECT json FROM LRAssessIndexLibrary WHERE indexcode='"+indexcode+"' FOR UPDATE");
//					while (rs.next()) {
//						oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("json");
//						out = new BufferedWriter(clob.getCharacterOutputStream());
//						in = new BufferedReader(new StringReader(json));
//						int c;
//						while ((c = in.read()) != -1) {
//							out.write(c);
//						}
//						try { out.close(); } catch (Exception ecp) { ecp.printStackTrace(); }
//						try { in.close(); } catch (Exception ecp) { ecp.printStackTrace(); }
//					}
					//导入基本法成功后，执行更新LDMAXNO表中的MAXNO值  执行存储过程
					stmt.executeUpdate("exec proc_UpdateMAXNO");
					
				}
			}

            conn.commit();
            conn.close();
            conn = null;
		} catch (Exception e) { 
			e.printStackTrace();
            // @@错误处理
            CError.buildErr(this, e.toString());
            try {
                conn.rollback();
            } catch (Exception ex) { }

            try {
                conn.close();
            } catch (Exception ex) { }
            conn = null;
            return false;
		} finally {
			if(stmt != null)try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if(conn != null)try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
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

//	public static void main(String args[]) {
//		String s = "select doneflag from LAQualityAssess where	agentCode='?AgentCode?'";
//		System.out.println(s);
//		System.out.println(s);
//	}
}
