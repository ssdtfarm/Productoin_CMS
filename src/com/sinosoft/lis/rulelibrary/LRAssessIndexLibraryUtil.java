package com.sinosoft.lis.rulelibrary;

import com.sinosoft.Resource.bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;

public class LRAssessIndexLibraryUtil {
	public static List<String> parseIndex(String indexCode, List<String> list) {
		if(list == null) {
			list = new ArrayList<String>();
		}
		if(list.contains(indexCode)) {
			return list;
		}
		if(indexCode.startsWith("I")) {
			list.add(indexCode);
			return list;
		}
		String sql = "select IndexCode, IndexSet from LRAssessIndexLibrary where IndexCode='" + indexCode + "'";
		ExeSQL exe = new ExeSQL();
		SSRS ssrs = exe.execSQL(sql);
		if(ssrs.MaxRow < 1) {
			String msg = ""+bundle.getString("waitForTran")+"indexCode:"+indexCode + ")";
			throw new RuntimeException(msg);
		}
		list.add(ssrs.GetText(1, 1));
		String indexSet = ssrs.GetText(1, 2);
		if(indexSet != null && !indexSet.trim().equals("") && !indexSet.trim().equalsIgnoreCase("null")) {
			String[] split = indexSet.split(",");
			for(int i = 0; i < split.length; i++) {
				if(split[i] != null && !split[i].trim().equals("")) {
					parseIndex(split[i], list);					
				}
			}
		}
		
		return list;
	}
//	public static Result getAllRules(String basecode, String indexCode, Result result) {
//		if(result == null) {
//			result = new Result();
//		}
//		if(result.keys.contains(indexCode)) {
//			return result;
//		}
//		if(!indexCode.startsWith("R")) {
//			return result;
//		}
//		String sql = "select IndexCode,IndexName, IndexSet from LRAssessIndexP where basecode='"+basecode+"' and IndexCode='" + indexCode + "'";
//		ExeSQL exe = new ExeSQL();
//		SSRS ssrs = exe.execSQL(sql);
//		if(ssrs.MaxRow < 1) {
//			String msg = "没找到指�?indexCode:"+indexCode + ")";
//			throw new RuntimeException(msg);
//		}
//		result.keys.add(indexCode);
//		result.contaner.put(indexCode, ssrs.GetText(1, 2));
//		String indexSet = ssrs.GetText(1, 3);
//		if(indexSet != null && !indexSet.trim().equals("") && !indexSet.trim().equalsIgnoreCase("null")) {
//			String[] split = indexSet.split(",");
//			for(int i = 0; i < split.length; i++) {
//				if(split[i] != null && !split[i].trim().equals("")) {
//					if(split[i].startsWith("R")) {
//						getAllRules(basecode, split[i], result);
//					}
//				}
//			}
//		}
//		
//		return result;
//	}
	
	public static List getAllRules(String basecode, String agentgrade,String indextype, List list) {
		String indexcodeSet = "select indexcode from lrindexvscommp where agentgrade = '"+agentgrade+"'"+indextype;
		ExeSQL exe = new ExeSQL();
		SSRS ssrs = exe.execSQL(indexcodeSet);
		String indexCode = "";
		for(int j=1;j<=ssrs.getMaxRow();j++){
			indexCode = ssrs.GetText(j, 1);
			parseIndex(indexCode,list);
		}
		return list;
	}
	
	public static Result getAllRules(String indexCode, Result result) {
		if(result == null) {
			result = new Result();
		}
		if(result.keys.contains(indexCode)) {
			return result;
		}
		if(!indexCode.startsWith("R")) {
			return result;
		}
		String sql = "select IndexCode,IndexName, IndexSet from lrassessindexlibrary where  IndexCode='" + indexCode + "'";
		ExeSQL exe = new ExeSQL();
		SSRS ssrs = exe.execSQL(sql);
		if(ssrs.MaxRow < 1) {
			String msg = ""+bundle.getString("waitForTran")+"indexCode:"+indexCode + ")";
			throw new RuntimeException(msg);
		}
		result.keys.add(indexCode);
		result.contaner.put(indexCode, ssrs.GetText(1, 2));
		String indexSet = ssrs.GetText(1, 3);
		if(indexSet != null && !indexSet.trim().equals("") && !indexSet.trim().equalsIgnoreCase("null")) {
			String[] split = indexSet.split(",");
			for(int i = 0; i < split.length; i++) {
				if(split[i] != null && !split[i].trim().equals("")) {
					if(split[i].startsWith("R")) {
						getAllRules(split[i], result);
					}
				}
			}
		}
		
		return result;
	}
	/**
	 * 
	 * @param indexCode 目标编码
	 * @param result    结果
	 * @return
	 */
	public static  String getRefRules(String amIndexCode) {
		Result result= new Result();
		StringBuffer sb = new StringBuffer();
		String sql = "select IndexCode,IndexName, IndexSet from lrassessindexlibrary where  IndexCode!='" + amIndexCode + "'";
		ExeSQL exe = new ExeSQL();
		SSRS ssrs = exe.execSQL(sql);
		for(int k=1;k<=ssrs.getMaxRow();k++){
			String indexcode = ssrs.GetText(k, 1);
			String IndexName = ssrs.GetText(k, 2);
			String indexSet = ssrs.GetText(1, 3);
			if(indexSet != null && !indexSet.trim().equals("") && !indexSet.trim().equalsIgnoreCase("null")) {
				String[] split = indexSet.split(",");
				for(int i = 0; i < split.length; i++) {
					if(split[i].equals(amIndexCode)) {
						result.keys.add(indexcode);
						result.contaner.put(indexcode, IndexName);
						break;
					}
				}
			}
		}
		List list = result.keys;
		for (int i =0;i<list.size(); i++) {
//			if(i>0){
				sb.append(",");
//			}
			sb.append("'"+list.get(i)+"'"); 
		} 
		return sb.toString();
	}
	
	public static boolean brforeDelete(String indexCode){
		List list = new ArrayList();
		String sql = "select indexcode from lrassessindexlibrary ";
		SSRS ssrs = new ExeSQL().execSQL(sql);
		for(int i = 1;i<ssrs.getMaxRow();i++){
			parseIndex(ssrs.GetText(i, 1), list);
		}
		if(list.contains(indexCode)){
			return false;
		}
		return true;
	}
	
	public static String[] getChildren(String indexCode) {
		String sql = "select IndexCode, IndexSet from LRAssessIndexLibrary where IndexCode='" + indexCode + "'";
		ExeSQL exe = new ExeSQL();
		SSRS ssrs = exe.execSQL(sql);
		if(ssrs.MaxRow < 1) {
			String msg = ""+bundle.getString("waitForTran")+"indexCode:"+indexCode + ")";
			throw new RuntimeException(msg);
		}
		String indexSet = ssrs.GetText(1, 2);
		if(indexSet != null && !indexSet.trim().equals("") && !indexSet.trim().equalsIgnoreCase("null")) {
			return  indexSet.split(",");
		}
		
		return new String[]{};
	}
	public static class Result {
		public List<String> keys = new ArrayList();
		public Map<String,String> contaner = new HashMap<String,String>();
	}
//	public static void main(String[] args) {
//		
////		brforeDelete("R000000012");
////		String s = getRefRules("R000000012");
////		System.out.println("223--"+s);
////		Result result = getAllRules(null, null, null);
////		Iterator<String> keys = result.keys.iterator();
////		while(keys.hasNext()) {
////			String code = keys.next();
////			String name = result.contaner.get(code);
////		}
//		
//		
//		
//	}
}
