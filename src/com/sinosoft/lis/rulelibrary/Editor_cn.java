package com.sinosoft.lis.rulelibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sinosoft.utility.DBConn;
import com.sinosoft.utility.DBConnPool;
import com.sinosoft.utility.DBOper;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;

public class Editor_cn {
	/**
	 * 参数不再存放到LRRadix表了，也就没必要创建视图了
	 * @param indexCode
	 * @param ths
	 * @return
	 */
	@Deprecated
	public static boolean createView(String indexCode, String ths) {
		ExeSQL exe = new ExeSQL();
		StringBuffer sb = new StringBuffer();
		sb.append("create or replace view "+indexCode+" as ");
		sb.append("select BaseCode,MainIndexCode,RadixRow");
		String[] split = ths.split(",");
		for(int i = 0; i < split.length; i++) {
			String id = split[i];
			String sql = null;
			if(id.startsWith("I")){
				sql = "select datatype from lrterm where id='"+id+"'";
			} else {
				sql = "select datatype from LRAssessIndexLibrary where IndexCode='"+id+"'"; 
			}
			SSRS ssrs = exe.execSQL(sql);
			if(ssrs.MaxRow > 0) {
				String dataType = ssrs.GetText(1, 1);
				//sb.append(",max(case datatype when '"+dataType+"' then " + dataType + " end) "+id + "_" + i);
				if("D".equals(dataType)){
					sb.append(",max(case RadixCol when "+i+" then D end) "+id + "_" + i);
				} else if("N0".equals(dataType)) {
					sb.append(",max(case RadixCol when "+i+" then N0 end) "+id + "_" + i);
				} else if("N2".equals(dataType)) {
					sb.append(",max(case RadixCol when "+i+" then N2 end) "+id + "_" + i);
				} else if("N4".equals(dataType)) {
					sb.append(",max(case RadixCol when "+i+" then N4 end) "+id + "_" + i);
				} else if("N6".equals(dataType)) {
					sb.append(",max(case RadixCol when "+i+" then N6 end) "+id + "_" + i);
				} else if("S".equals(dataType)) {
					sb.append(",max(case RadixCol when "+i+" then S end) "+id + "_" + i);
				}
			}
		}
		sb.append(" from LRRadix ");
		sb.append("group by BaseCode,MainIndexCode,RadixRow ");
		sb.append("having MainIndexCode='").append(indexCode).append("' ");
		sb.append("order by radixrow");
		return exe.execUpdateSQL(sb.toString().toUpperCase());
	}
	
	public static boolean saveRule(String indexcode, String indexset, String json, String calsql){
		System.out.println("rule保存参数");
		System.out.println("indexcode:" + indexcode);
		System.out.println("indexset:" + indexset);
		System.out.println("json:" + json);
		System.out.println("calsql:" + calsql);
		
		List list = new ArrayList();
		StringBuffer sb = new StringBuffer();
		String[] split = indexset.split(",");
		for(int i = 0; i < split.length; i++){
			String index = split[i];
			if(!list.contains(index) && !indexcode.equals(index)) {
				list.add(index);
				if(sb.length() > 0) {
					sb.append(",");
				}
				sb.append(index);
			}
		}
		//calsql = calsql.replaceAll("请选择", "").replaceAll("并且", "and").replaceAll("或者", "or").replaceAll("  ", " ").replaceAll("输入值", "Value").replaceAll("輸入值", "Value").replaceAll("@"+indexcode+"@ =", "");
		calsql = calsql.replaceAll("请选择", "").replaceAll("請選擇", "").replaceAll("并且", "And").replaceAll("並且", "And").replaceAll("或者", "Or").replaceAll("  ", " ").replaceAll("输入值", "Value").replaceAll("輸入值", "Value").replaceAll("@"+indexcode+"@ =", "");
		calsql = calsql.replaceAll("字符串", "String").replaceAll("數字", "Number").replaceAll("日期", "Date").replaceAll("数字", "Number");
		
		System.out.println("calsql:" + calsql);
		
		json = replaceJson(json);
//		//英文替换简体中文
//		json = json.replaceAll("\\\\u5982\\\\u679c", "if");
//		json = json.replaceAll("\\\\u8f93\\\\u5165\\\\u503c", "Value");
//		json = json.replaceAll("\\\\u6570\\\\u5b57", "Number");
//		json = json.replaceAll("\\\\u5b57\\\\u7b26\\\\u4e32", "String");
//		json = json.replaceAll("\\\\u5426\\\\u5219", "Else");
//		json = json.replaceAll("\\\\u90a3\\\\u4e48", "Then");
//		System.out.println("json:" + json);
//		
//		//英文替换繁体中文
//		json = json.replaceAll("\\\\u8f38\\\\u5165\\\\u503c", "Value");
//		json = json.replaceAll("\\\\u6578\\\\u5b57", "Number");
//		json = json.replaceAll("\\\\u5426\\\\u5247", "Else");
//		json = json.replaceAll("\\\\u90a3\\\\u9ebc", "Then");
//		
//		System.out.println("json:" + json);
//		
//		json = json.replaceAll("请选择", "").replaceAll("請選擇", "").replaceAll("  ", " ").replaceAll("ture", "false");
		String sql = "update LRAssessIndexLibrary set calsql='"+calsql+"',sqltemp = '"+calsql+"', indexset='"+sb.toString()+"' where indexcode='"+indexcode+"'";
	    ExeSQL exe = new ExeSQL();
		boolean succ = exe.execUpdateSQL(sql);
		
		//更新Json
		if(succ) {
			//1.如果保存CalSql和SqlTemp成功，先判断规则中是否存在输入值，如果存在输入值，
			//2.则需走参数定制流程，如果不存在输入值，则在规则定制这块默认通过参数定制
			if(calsql.indexOf("Value")==-1){
				//@不存在输入值情况
				//@savePara参数ifthenpara、elsepara这两个参数是editor_cn.js页面参数输入值
				succ = savePara(indexcode, "", "", json);
			}else{
				//@存在输入值情况
				DBConn conn = null;
				PreparedStatement stmt = null;
				BufferedWriter out = null;
				BufferedReader in = null;
				try {
					System.out.println("开始更新json");
					conn = DBConnPool.getConnection();
					//DBOper db = new DBOper( conn, "LRAssessIndexLibrary" );
					conn.setAutoCommit(false);
//					stmt = conn.createStatement();//tatement("insert into LRAssessIndexLibrary(indexcode,json) values ('"+indexcode+"',?)");
					//modify by tianzf 20150227 sqlserver没有Clob对象
//					stmt.executeUpdate("UPDATE LRAssessIndexLibrary SET json='"+json.replace("'", "''")+"' WHERE indexcode='"+indexcode+"'");
					stmt = conn.prepareStatement("UPDATE LRAssessIndexLibrary SET json=? WHERE indexcode=? ");
					stmt.setString(1, json);
					stmt.setString(2, indexcode);
//					stmt.executeUpdate("UPDATE LRAssessIndexLibrary SET json=EMPTY_CLOB() WHERE indexcode='"+indexcode+"'");
//					ResultSet rs = stmt.executeQuery("SELECT json FROM LRAssessIndexLibrary WHERE indexcode='"+indexcode+"' FOR UPDATE");
//					while (rs.next()) {
//						oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("json");
//						System.out.println("json --------->"+clob.toString());
//						out = new BufferedWriter(clob.getCharacterOutputStream());
//						in = new BufferedReader(new StringReader(json));
//						int c;
//						while ((c = in.read()) != -1) {
//							out.write(c);
//						}
//						try { out.close(); } catch (Exception e) { succ = false;e.printStackTrace(); }
//						try { in.close(); } catch (Exception e) { succ = false;e.printStackTrace(); }
//					}
					stmt.executeUpdate();
					conn.commit();
				}catch (Exception e) {
					succ = false;
					e.printStackTrace();
					try {conn.rollback();} catch (SQLException e1) {succ = false;e1.printStackTrace();}
				} finally {
					if(stmt != null)try { stmt.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
					if(conn != null)try { conn.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
				}
				if(succ){
					String update_sql = "update lrassessindexp set calsql = '"+calsql+"',json = (SELECT json from LRAssessIndexLibrary WHERE  indexcode='"+indexcode+"'),indexset = '"+sb.toString()+"',sqltemp = '"+calsql+"',calprpty='N'  where basecode in (select basecode from lrbase where status not in('02','04','06')) and indexcode = '"+indexcode+"'";
					succ = exe.execUpdateSQL(update_sql);	
				}
			}
		}
		return succ;
	}

	public static boolean savePara(String indexcode, String ifthenpara, String elsepara, String json){
		System.out.println("rule保存参数");
		System.out.println("indexcode:" + indexcode);
		System.out.println("ifthenpara:" + ifthenpara);
		System.out.println("elsepara:" + elsepara);
		System.out.println("json:" + json);
		boolean succ = false;
		//更新Json 
		json = replaceJson(json);
		DBConn conn = null;
		PreparedStatement stmt = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		
		try {
			conn = DBConnPool.getConnection();
			conn.setAutoCommit(false);
//			stmt = conn.createStatement();//tatement("insert into LRAssessIndexLibrary(indexcode,json) values ('"+indexcode+"',?)");
//			//modify by tianzf 20150227 sqlserver没有Clob对象
//			stmt.executeUpdate("UPDATE LRAssessIndexLibrary SET json='"+json.replace("'", "''")+"' WHERE  indexcode='"+indexcode+"'");
			stmt = conn.prepareStatement("UPDATE LRAssessIndexLibrary SET json=? WHERE indexcode=? ");
			stmt.setString(1, json);
			stmt.setString(2, indexcode);
//			stmt.executeUpdate("UPDATE LRAssessIndexLibrary SET json=EMPTY_CLOB() WHERE  indexcode='"+indexcode+"'");
//			ResultSet rs = stmt.executeQuery("SELECT json FROM LRAssessIndexLibrary WHERE  indexcode='"+indexcode+"' FOR UPDATE");
//			while (rs.next()) {
//				oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("json");
//				out = new BufferedWriter(clob.getCharacterOutputStream());
//				in = new BufferedReader(new StringReader(json));
//				int c;
//				while ((c = in.read()) != -1) {
//					out.write(c);
//				}
//				try { out.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
//				try { in.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
//			}
			stmt.executeUpdate();
			conn.commit();
			succ = true;
		}catch (Exception e) {
			succ = false;
			e.printStackTrace();
			try {conn.rollback();} catch (SQLException e1) {succ = false;e1.printStackTrace();}
		} finally {
			if(stmt != null)try { stmt.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
			if(conn != null)try { conn.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
		}
		
		if(!succ){
			return succ;
		}
		ExeSQL exe = new ExeSQL();
//		String delete = "delete from LRRadix where basecode='"+basecode+"' and mainIndexCode='"+indexcode+"'";
//		exe.execUpdateSQL(delete);
//		String sql = "select id,datatype from lrterm where id in("+ths+") union all select indexcode,datatype from LRAssessIndexLibrary where indexcode in("+ths+")";
//		SSRS ssrs = exe.execSQL(sql);
//		Map<String, String> tMap = new HashMap<String, String>();
//		for(int i = 1; i <= ssrs.MaxRow; i++) {
//			tMap.put(ssrs.GetText(i, 1), ssrs.GetText(i, 2));
//		}
//		String[] titles = ths.split(",");
//		for(int i = 0; i < titles.length; i++) {
//			titles[i] = titles[i].replaceAll("'", "");
//		}
//		String[] rows = para.split("@");
//		for(int i = 0; i < rows.length&&succ; i++){
//			String[] inputs = rows[i].split(",");
//			for(int j = 0; j < inputs.length&&succ; j++) {
//				String insert = "insert into LRRadix (BaseCode,MainIndexCode,RadixRow,RadixCol,IndexCode,DataType,"+tMap.get(titles[j])+") " +
//						"values('"+basecode+"','"+indexcode+"',"+i+","+j+",'"+titles[j]+"','"+tMap.get(titles[j])+"',"+getData(inputs[j], tMap.get(titles[j]))+")";
//				succ = exe.execUpdateSQL(insert);
//			}
//		}
		//参数化sql
		StringBuffer resultSql = new StringBuffer("select case ");
		String query = "select isnull(sqltemp,'null') from LRAssessIndexLibrary where  indexcode='"+indexcode+"'";
		SSRS tSSRS = exe.execSQL(query);
		if(tSSRS.MaxRow > 0) {
			String calsql = tSSRS.GetText(1, 1);
			if(calsql == null || calsql.trim().equals("")||calsql.trim().equals("null")){
				calsql = "";
			}
			int ifthenbegin = calsql.indexOf("#IFTHEN#");
			int ifthenend = calsql.indexOf("#/IFTHEN#");
			int elsebegin = calsql.indexOf("#ELSE#");
			int elseend = calsql.indexOf("#/ELSE#");
			System.out.println("ifthenbegin:" + ifthenbegin);
			System.out.println("ifthenend:" + ifthenend);
			System.out.println("elsebegin:" + elsebegin);
			System.out.println("elseend:" + elseend);
			String elseblock = "";
			if(elsebegin > -1 && elseend > -1){
				elseblock = calsql.substring(elsebegin+6, elseend);
			}
			System.out.println("elseblock:" + elseblock);
			
			String[] tables = ifthenpara.split("@");
			System.out.println("tables.length:" + tables.length);
			int currTableIndex = 0;
			while(ifthenbegin > -1 && ifthenbegin > -1) {
				String ifthen = calsql.substring(ifthenbegin+8, ifthenend);
				String p = "";
//				currTableIndex++;
				if(tables.length > currTableIndex){
					p = tables[currTableIndex++];
				}
				String ifthencode = parseIfThen(ifthen, p);
				resultSql.append(ifthencode);
				calsql = calsql.substring(ifthenend+9);
				ifthenbegin = calsql.indexOf("#IFTHEN#");
				ifthenend = calsql.indexOf("#/IFTHEN#");
			}
			if(tables.length != currTableIndex) {
				System.out.println("####:参数表个数与ifthen代码块不相同，请检查是否正确");
				System.out.println("tables.length=" + tables.length);
				System.out.println("currTableIndex=" + currTableIndex);
			}
			//else
			String[] elseTable = elsepara.split(",");
			int currIndex = 0;
			String dataType = "";
			int index = elseblock.indexOf("Value");
			while(index > -1) {
				dataType = elseblock.split("Value\\(")[1].split("\\)")[0];
				elseblock = elseblock.replaceFirst("Value\\("+dataType+"\\)", getTypedData(dataType,elseTable[currIndex++]));
				index = elseblock.indexOf("Value");
				if(elseblock.indexOf("Value\\(")>-1){
					dataType = elseblock.split("Value\\(")[1].split("\\)")[0];
				}
			}
			if(elseblock != null && !elseblock.trim().equals("")){
				resultSql.append(" else ");
				resultSql.append(elseblock);
			}
			resultSql.append(" end from dual");
			
//			String update = "update LRAssessIndexLibrary set calsql='"+resultSql.toString().trim().replaceAll("  ", " ")+"' where basecode='"+basecode+"' and indexcode='"+indexcode+"'";
//			succ = exe.execUpdateSQL(update);
			try {
				conn = DBConnPool.getConnection();
				conn.setAutoCommit(false);
//				stmt = conn.createStatement();//tatement("insert into LRAssessIndexLibrary(indexcode,json) values ('"+indexcode+"',?)");
				//modify by tianzf 20150227 sqlserver没有Clob对象
				String resultS = resultSql.toString().trim();
				System.out.println("resultS------>"+resultS);
				if(resultS.contains("select case  else")){
					resultS = resultS.replace("case", "").replace("else", "").replace("end", " ");
				}
				System.out.println("resultS-----2->"+resultS);
				resultS=resultS.replaceAll("  ", " ");
//				stmt.executeUpdate("UPDATE LRAssessIndexLibrary SET calsql='"+resultS.replace("'", "''")+"' WHERE  indexcode='"+indexcode+"'");
				stmt = conn.prepareStatement("UPDATE LRAssessIndexLibrary SET calsql=? WHERE  indexcode=? ");
				stmt.setString(1, resultS);
				stmt.setString(2, indexcode);
//				stmt.executeUpdate("UPDATE LRAssessIndexLibrary SET calsql=EMPTY_CLOB() WHERE  indexcode='"+indexcode+"'");
//				ResultSet rs = stmt.executeQuery("SELECT calsql from LRAssessIndexLibrary WHERE  indexcode='"+indexcode+"' FOR UPDATE");
//				while (rs.next()) {
//					oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("calsql");
//					out = new BufferedWriter(clob.getCharacterOutputStream());
//					String resultS = resultSql.toString().trim();
//					System.out.println("resultS------>"+resultS);
//					if(resultS.contains("select case  else")){
//						resultS = resultS.replace("case", "").replace("else", "").replace("end", " ");
//					}
//					System.out.println("resultS-----2->"+resultS);
//					in = new BufferedReader(new StringReader(resultS.replaceAll("  ", " ")));
//					int c;
//					while ((c = in.read()) != -1) {
//						out.write(c);
//					}
//					try { out.close(); } catch (Exception e) { succ = false;e.printStackTrace(); }
//					try { in.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
//				}
				stmt.executeUpdate();
				conn.commit();
				succ = true;
			}catch (Exception e) {
				succ = false;
				e.printStackTrace();
				try {conn.rollback();} catch (SQLException e1) {succ = false;e1.printStackTrace();}
			} finally {
				if(stmt != null)try { stmt.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
				if(conn != null)try { conn.close(); } catch (Exception e) {succ = false; e.printStackTrace(); }
			}
			//成功后才将基本法未提取申请、审核发布、停用所使用的规则更新
			if(succ){
				String update_sql = "update lrassessindexp set calsql = (SELECT calsql from LRAssessIndexLibrary WHERE  indexcode='"+indexcode+"'),json = (SELECT json from LRAssessIndexLibrary WHERE  indexcode='"+indexcode+"'),indexset = (SELECT indexset from LRAssessIndexLibrary WHERE  indexcode='"+indexcode+"')  where basecode in (select basecode from lrbase where status not in('02','04','06')) and indexcode = '"+indexcode+"' and CalPrpty = 'N' ";
				succ = exe.execUpdateSQL(update_sql);	
			}
		}
		return succ;
	}
	
	
	public static boolean savePara(String basecode, String indexcode, String ifthenpara, String elsepara, String json,String agentgrade,String indextype){
		System.out.println("rule保存个性化参数");
		System.out.println("basecode:" + basecode);
		System.out.println("indexcode:" + indexcode);
		System.out.println("ifthenpara:" + ifthenpara);
		System.out.println("elsepara:" + elsepara);
		System.out.println("json:" + json);
		System.out.println("agentgrade:" + agentgrade);
		boolean succ = false;
		//更新Json
		json = replaceJson(json);
		DBConn conn = null;
		PreparedStatement stmt = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		try {
			conn = DBConnPool.getConnection();
			conn.setAutoCommit(false);
//			stmt = conn.createStatement();//tatement("insert into LRAssessIndexLibrary(indexcode,json) values ('"+indexcode+"',?)");
//			//modify by tianzf 20150227 sqlserver没有Clob对象
//			stmt.executeUpdate("UPDATE LRAssessIndexP SET json='"+json.replace("'", "''")+"' WHERE basecode='"+basecode+"' and indexcode='"+indexcode+"' and agentgrade = '"+agentgrade+"' and indextype = '"+indextype+"' ");
			stmt = conn.prepareStatement("UPDATE LRAssessIndexP SET json=? WHERE basecode=? and indexcode=? and agentgrade =? and indextype =? ");
			stmt.setString(1, json);
			stmt.setString(2, basecode);
			stmt.setString(3, indexcode);
			stmt.setString(4, agentgrade);
			stmt.setString(5, indextype);
//			stmt.executeUpdate("UPDATE LRAssessIndexP SET json=EMPTY_CLOB() WHERE basecode='"+basecode+"' and indexcode='"+indexcode+"' and agentgrade = '"+agentgrade+"' and indextype = '"+indextype+"' ");
//			ResultSet rs = stmt.executeQuery("SELECT json FROM LRAssessIndexP WHERE basecode='"+basecode+"' and indexcode='"+indexcode+"' and agentgrade = '"+agentgrade+"' and indextype = '"+indextype+"'  FOR UPDATE");
//			while (rs.next()) {
//				oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("json");
//				out = new BufferedWriter(clob.getCharacterOutputStream());
//				in = new BufferedReader(new StringReader(json));
//				int c;
//				while ((c = in.read()) != -1) {
//					out.write(c);
//				}
//				try { out.close(); } catch (Exception e) { e.printStackTrace(); }
//				try { in.close(); } catch (Exception e) { e.printStackTrace(); }
//			}
			stmt.executeUpdate();
			conn.commit();
			succ = true;
		}catch (Exception e) {
			e.printStackTrace();
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
		} finally {
			if(stmt != null)try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if(conn != null)try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
		if(!succ){
			return succ;
		}
		ExeSQL exe = new ExeSQL();
		StringBuffer resultSql = new StringBuffer("select case ");
		String query = "select sqltemp from lrassessindexP where basecode='"+basecode+"' and indexcode='"+indexcode+"' and agentgrade = '"+agentgrade+"' and indextype = '"+indextype+"' ";
		SSRS tSSRS = exe.execSQL(query);
		if(tSSRS.MaxRow > 0) {
			String calsql = tSSRS.GetText(1, 1);
			int ifthenbegin = calsql.indexOf("#IFTHEN#");
			int ifthenend = calsql.indexOf("#/IFTHEN#");
			int elsebegin = calsql.indexOf("#ELSE#");
			int elseend = calsql.indexOf("#/ELSE#");
			System.out.println("ifthenbegin:" + ifthenbegin);
			System.out.println("ifthenend:" + ifthenend);
			System.out.println("elsebegin:" + elsebegin);
			System.out.println("elseend:" + elseend);
			String elseblock = "";
			if(elsebegin > -1 && elseend > -1){
				elseblock = calsql.substring(elsebegin+6, elseend);
			}
			System.out.println("elseblock:" + elseblock);
			
			String[] tables = ifthenpara.split("@");
			System.out.println("tables.length:" + tables.length);
			int currTableIndex = 0;
			while(ifthenbegin > -1 && ifthenbegin > -1) {
				String ifthen = calsql.substring(ifthenbegin+8, ifthenend);
				String p = "";
//				currTableIndex++;
				if(tables.length > currTableIndex){
					p = tables[currTableIndex++];
				}
				String ifthencode = parseIfThen(ifthen, p);
				resultSql.append(ifthencode);
				calsql = calsql.substring(ifthenend+9);
				ifthenbegin = calsql.indexOf("#IFTHEN#");
				ifthenend = calsql.indexOf("#/IFTHEN#");
			}
			if(tables.length != currTableIndex) {
				System.out.println("####:参数表个数与ifthen代码块不相同，请检查是否正确");
				System.out.println("tables.length=" + tables.length);
				System.out.println("currTableIndex=" + currTableIndex);
			}
			//else
			String[] elseTable = elsepara.split(",");
			int currIndex = 0;
			String dataType = "";
			int index = elseblock.indexOf("Value");
			while(index > -1) {

				dataType = elseblock.split("Value\\(")[1].split("\\)")[0];
				elseblock = elseblock.replaceFirst("Value\\("+dataType+"\\)", getTypedData(dataType,elseTable[currIndex++]));
				index = elseblock.indexOf("Value");
				if(elseblock.indexOf("Value\\(")>-1){
					dataType = elseblock.split("Value\\(")[1].split("\\)")[0];
				}
			}
			if(elseblock != null && !elseblock.trim().equals("")){
				resultSql.append(" else ");
				resultSql.append(elseblock);
			}
			resultSql.append(" end from dual");
			
//			String update = "update lrassessindexp set calsql='"+resultSql.toString().trim().replaceAll("  ", " ")+"' where basecode='"+basecode+"' and indexcode='"+indexcode+"'";
//			succ = exe.execUpdateSQL(update);
			try {
				conn = DBConnPool.getConnection();
				conn.setAutoCommit(false);
//				stmt = conn.createStatement();//tatement("insert into LRAssessIndexLibrary(indexcode,json) values ('"+indexcode+"',?)");
				//modify by tianzf 20150227 sqlserver没有Clob对象
				String resultS = resultSql.toString().trim();
				System.out.println("resultS------>"+resultS);
				if(resultS.contains("select case  else")){
					resultS = resultS.replace("case", "").replace("else", "").replace("end", " ");
				}
				System.out.println("resultS-----2->"+resultS);
				resultS=resultSql.toString().trim().replaceAll("  ", " ");
//				stmt.executeUpdate("UPDATE lrassessindexp SET calsql='"+resultS.replace("'", "''")+"',CalPrpty = 'Y' WHERE basecode='"+basecode+"' and indexcode='"+indexcode+"' and indextype = '"+indextype+"'  and agentgrade = '"+agentgrade+"'");
				stmt = conn.prepareStatement("UPDATE lrassessindexp SET calsql=?,CalPrpty = 'Y' WHERE basecode=? and indexcode=? and indextype =?  and agentgrade =? ");
				stmt.setString(1, resultS);
				stmt.setString(2, basecode);
				stmt.setString(3, indexcode);
				stmt.setString(4, indextype);
				stmt.setString(5, agentgrade);
//				stmt.executeUpdate("UPDATE lrassessindexp SET calsql=EMPTY_CLOB(),CalPrpty = 'Y' WHERE basecode='"+basecode+"' and indexcode='"+indexcode+"' and indextype = '"+indextype+"'  and agentgrade = '"+agentgrade+"'");
//				ResultSet rs = stmt.executeQuery("SELECT calsql from LRAssessIndexP WHERE basecode='"+basecode+"' and indexcode='"+indexcode+"' and agentgrade = '"+agentgrade+"' and indextype = '"+indextype+"'  FOR UPDATE");
//				while (rs.next()) {
//					oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("calsql");
//					out = new BufferedWriter(clob.getCharacterOutputStream());
//					String resultS = resultSql.toString().trim();
//					System.out.println("resultS------>"+resultS);
//					if(resultS.contains("select case  else")){
//						resultS = resultS.replace("case", "").replace("else", "").replace("end", " ");
//					}
//					System.out.println("resultS-----2->"+resultS);
//					in = new BufferedReader(new StringReader(resultSql.toString().trim().replaceAll("  ", " ")));
//					int c;
//					while ((c = in.read()) != -1) {
//						out.write(c);
//					}
//					try { out.close(); } catch (Exception e) { e.printStackTrace(); }
//					try { in.close(); } catch (Exception e) { e.printStackTrace(); }
//				}
				stmt.executeUpdate();
				conn.commit();
				succ = true;
			}catch (Exception e) {
				e.printStackTrace();
				try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			} finally {
				if(stmt != null)try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
				if(conn != null)try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
			}
		}
		return succ;
	}

	private static String parseIfThen(String ifthen, String paraTable) {
		System.out.println("ifthen:" + ifthen);
		int ifbegin = ifthen.indexOf("#IF#");
		int ifend = ifthen.indexOf("#/IF#");
		String dataType = "";
		String ifblock = ifthen.substring(ifbegin+4, ifend);
		System.out.println("ifbegin:" + ifbegin);
		System.out.println("ifend:" + ifend);
		System.out.println("ifblock:" + ifblock);
		int thenbegin = ifthen.indexOf("#THEN#");
		int thenend = ifthen.indexOf("#/THEN#");
		String thenblock = ifthen.substring(thenbegin+6, thenend);
		System.out.println("thenbegin:" + thenbegin);
		System.out.println("thenend:" + thenend);
		System.out.println("thenblock:" + thenblock);
		System.out.println("paraTable:"+paraTable);
		String[] paraRows = paraTable.split("\\|");
		int currRowIndex = 0;
		System.out.println("ifthen:" + ifthen);
		StringBuffer resultSql = new StringBuffer();
		try{
			for(int i = 0; i < paraRows.length; i++){
				String tifblock = ifblock;
				String tthenblock = thenblock;
				String[] inputs = paraRows[i].split(",");
				System.out.println("paraRows["+i+"]:"+paraRows[i]);
				for(int j  = 0; j < inputs.length; j++) {
					System.out.print("inputs["+j+"]:"+inputs[j]);
				}
				System.out.println();
				int currColIndex = 0;
				int index = tifblock.indexOf("Value");
				System.out.println("tifblock:" + tifblock);
				while(index > -1) {
					dataType = tifblock.split("Value\\(")[1].split("\\)")[0];
					tifblock = tifblock.replaceFirst("Value\\("+dataType+"\\)", getTypedData(dataType,inputs[currColIndex++]));
					index = tifblock.indexOf("Value");
					System.out.println("tifblock:--"+tifblock);
					if(tifblock.indexOf("Value\\(")>-1){
						dataType = tifblock.split("Value\\(")[1].split("\\)")[0];
					}
				}
				System.out.println("tifblock:" + tifblock);
				int index2 = tthenblock.indexOf("Value");
				System.out.println("tthenblock:" + tthenblock);
				while(index2 > -1) {
					dataType = tthenblock.split("Value\\(")[1].split("\\)")[0];
					tthenblock = tthenblock.replaceFirst("Value\\("+dataType+"\\)", getTypedData(dataType,inputs[currColIndex++]));
					index2 = tthenblock.indexOf("Value");
					if(tthenblock.indexOf("Value\\(")>-1){
						dataType = tthenblock.split("Value\\(")[1].split("\\)")[0];
					}
					
				}
				System.out.println("tthenblock:" + tthenblock);
				
				resultSql.append(" when ");
				resultSql.append(tifblock);
				resultSql.append(" then ");
				resultSql.append(tthenblock);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return resultSql.toString();
	}

	private static String getTypedData(String data) {
		System.out.println("getTypedData:" + data);
		Pattern pattern = Pattern.compile("([\\+\\-])?([0-9])+(.[0-9])?([0-9])*");
		Matcher isNum = pattern.matcher(data);
        if(isNum.matches()) {
              return data;
        } else {
        	return "'" + data + "'";
        }
        
	}
	
	private static String getTypedData(String dataType,String data) {
		System.out.println("dataType--->"+dataType);
		if("数字".equals(dataType) || "數字".equals(dataType) || "Number".equals(dataType)){
			return data;
		}else if("日期".equals(dataType) || "Date".equals(dataType)){
			return "to_date('" + data + "','YYYY-MM-DD')";
		}else if("字符串".equals(dataType) || "String".equals(dataType)){
			return "'" + data + "'";
		}
        return data;
	}
	
	private static String getData(String data, String dataType) {
		String result = "";
		if("D".equals(dataType)){
			result = "data'" + data + "'";
		} else if(dataType.startsWith("N")) {
			result = data;
		} else if(dataType.equals("S")) {
			result = "'" + data + "'";
		}
		return result;
	}
	
	public static boolean setFlag(String basecode,String indexcode,String agentgrade,String indextype,String oper){
		String calprpty = "N";
		if(oper.equals("sflag")){
			calprpty = "Y";
		}
		String  calprpty_sql="update lrassessindexp set calprpty = '"+calprpty+"' where basecode = '"+basecode+"' and agentgrade='"+agentgrade+"' and indexcode = '"+indexcode+"' and indextype = '"+indextype+"'";
		try{
			new ExeSQL().execUpdateSQL(calprpty_sql);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
//	public static void main(String[] args) {
//		System.out.println(getTypedData(".3"));
//		
//		String object;
//		String lang = "zh_CN";
//		if("zh_CN".equals(lang)){
//			object = "Editor_cn";
//		}else if("zh_TW".equals(lang)){
//			object = "Editor_tr";
//		}else if("en".equals(lang)){
//			object = "Editor";
//		}else {
//			object = "Editor";
//		}
//		System.out.print("打印导入失败信息object："+object);
//		
//		Class<?> demo=null;
//        try{
//            demo=Class.forName("com.sinosoft.lis.rulelibrary."+object);
//            Object obj1 = demo.newInstance();
//            Method m = demo.getMethod("setFlag",java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class);
//            boolean asd = (Boolean)m.invoke(obj1, "","","","","");
//            System.out.println(asd);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
////        (demo.getName())demo.setFlag("","","","","");
////        per.setAge(20);
////        System.out.println(per);
//		
//		
//	}
	
	public static String replaceJson(String json){
		
		//英文替换簡體中文
		json = json.replaceAll("\\\\u5982\\\\u679c", "If");
		json = json.replaceAll("\\\\u8f93\\\\u5165\\\\u503c", "Value");
		json = json.replaceAll("\\\\u6570\\\\u5b57", "Number");
		json = json.replaceAll("\\\\u5b57\\\\u7b26\\\\u4e32", "String");
		json = json.replaceAll("\\\\u5426\\\\u5219", "Else");
		json = json.replaceAll("\\\\u90a3\\\\u4e48", "Then");
		json = json.replaceAll("\\\\u5e76\\\\u4e14", "And");
		json = json.replaceAll("\\\\u6216\\\\u8005", "Or");
		json = json.replaceAll("或者", "Or");
		json = json.replaceAll("并且", "And");
		
		
		//英文替换繁体中文
		json = json.replaceAll("\\\\u8f38\\\\u5165\\\\u503c", "Value");
		json = json.replaceAll("\\\\u6578\\\\u5b57", "Number");
		json = json.replaceAll("\\\\u5426\\\\u5247", "Else");
		json = json.replaceAll("\\\\u90a3\\\\u9ebc", "Then");
		json = json.replaceAll("\\\\u4e26\\\\u4e14", "And");
		json = json.replaceAll("並且", "And");
		
		json = json.replaceAll("请选择", "").replaceAll("請選擇", "").replaceAll("  ", " ").replaceAll("ture", "false");
		
		System.out.println("json:" + json);
		return json;
	}
}
