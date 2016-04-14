package com.sinosoft.lis.rulelibrary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.sinosoft.utility.*;

public class Load {
	
	private static Map map = new HashMap();
//	public static void main(String args[]) {
//		load("B00063", "", "01");
//	}

	public static String load(String basecode, String indexcode,String indextype) {
		int k = 0;
		SSRS ssrs;
		ExeSQL exe = new ExeSQL();
		StringBuffer result = new StringBuffer();
		result.append("[");
		String strSQL = "select indexcode from lrindexvscommp a where basecode = '"
				+ basecode
				+ "' and indextype='"
				+ indextype
				+ "' and indexcode  is not null group by indexcode,wagename,wagecode";
		if(indextype.startsWith("2")){
			strSQL = "select indexcode from lrindexvscommp a where basecode = '"
					+ basecode
					+ "' and indextype in ('"+ indextype + "','23') and indexcode  is not null group by indexcode,wagename,wagecode";
		}
		SSRS tssrs = exe.execSQL(strSQL);
		for (int j = 1; j <= tssrs.getMaxRow(); j++) {
			indexcode = tssrs.GetText(j, 1);
			System.out.println(indexcode);
			if (!indexcode.substring(0, 1).equals("R")) {
				return "";
			}
			fun(result,indexcode,indextype,basecode);
		}
		Iterator it = (Iterator) map.keySet().iterator(); 
		while(it.hasNext()){
			if(k++>0){
				result.append(",");     
			}
			String code = (String) it.next();
			String name  = (String)map.get(code);
			result.append("{name:'" + name + "',code:'"	+ code+ "'}");
		}
		result.append("]");
		System.out.println("sb-------------------------->"+result.toString());
		return result.toString();
	}

	public static void fun(StringBuffer result, String indexcode,String indextype,String basecode) {
		String[] result1 = LRAssessIndexLibraryUtil.getChildren(indexcode);
		if(indextype.startsWith("2")){
			indextype = "02";
		}
		for (int i = 0; i < result1.length; i++)
			if (result1[i].startsWith("R") || result1[i].startsWith("I")) {
				String sql = "select max(indexname) from LRAssessIndexP where indexcode='"
						+ result1[i] + "'  and basecode = '"+basecode+"' and (indextype = '00' or indextype ='"+indextype+"')";
				ExeSQL exe = new ExeSQL();
				SSRS ssrs = exe.execSQL(sql);
				if(!result1[i].startsWith("I")){
					map.put(result1[i],ssrs.GetText(1, 1));
				}
				
//				result.append("{");
//				result.append("code:'").append(result1[i]).append("',");
//				String sql = "select max(indexname) from LRAssessIndexP where indexcode='"
//						+ result1[i] + "'";
//				ExeSQL exe = new ExeSQL();
//				SSRS ssrs = exe.execSQL(sql);
//				result.append("name:'").append(ssrs.GetText(1, 1)).append("'");
//				result.append("}");
				if(result1[i].startsWith("R")){
					fun(result,result1[i],indextype,basecode);
				}
			}
	}
}
