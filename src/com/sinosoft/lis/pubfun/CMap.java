package com.sinosoft.lis.pubfun;

import java.util.HashMap;
import java.util.Map;

public class CMap{
	
	private Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
	
	private int size;
	
	public CMap(){
		size = 0;
	}
	
	public CMap(Map<String, Map<String, String>> map){
		this.map = map;
		this.size = map.size();
	}
	
    
    public void put(String key1,String key2,String value){
    	if(key1 == null || key2 == null || value == null){
    		return;
    	}
    	if (containsKey1(key1)) {
    		Map<String, String> tempMap = this.map.get(key1);
    		tempMap.put(key2, value);
    		map.put(key1, tempMap);
		}else {
			Map<String, String> tempMap = new HashMap<String, String>();
			tempMap.put(key2, value);
			map.put(key1,tempMap);
			size += 1;
		}
    	
    }
    
    public boolean containsKey1(String key1){
    	if (key1 == null) {
			return false;
		}
    	if (map.containsKey(key1)) {
			return true;
		}
    	return false;
    }
    
    public boolean containsKey2(String key1,String key2){
    	if (key1 == null || key2 == null) {
			return false;
		}
    	if (map.containsKey(key1)) {
    		Map<String, String> mapTemp = map.get(key1);
    		if (mapTemp.containsKey(key2)) {
				return true;
			}
    	}    	
    	return false;
    }
    
    public String getValue(String key1,String key2){
    	
    	if (containsKey1(key1)) {
			return map.get(key1).get(key2);
		}
    	
    	return null;
    }
    
	public String get(String key1,String key2){
	    	
	    	if (containsKey1(key1)) {
				return map.get(key1).get(key2);
			}
	    	
	    	return null;
	    }

    
    public void clear(){
    	map.clear();
    	size = 0;
    }
    
    public boolean isEmpty(){
    	return map.isEmpty();
    }
    
    public void printCmap(){
    	
    	for(String key : map.keySet()){
    		System.out.println("代理人 : "+key);
			for (String key2 : map.get(key).keySet()) {
				System.out.println("\t\tindexcode : "+key2 +" " + map.get(key).get(key2));
			} 
		 }
    }
    
    public int size(){
    	return this.size;
    }

	public static void main(String[] args) {
		CMap integerMap = new CMap();
		 integerMap.put("MET01", "I001","Y");
		 integerMap.put("MET01", "I001","200.00");
		 integerMap.put("MET01", "I001","3000.001");
		 
		 integerMap.put("MET01", "I002","3000");
		 integerMap.put("MET01", "I002","123.3456123");
		 
		 integerMap.put("MET02", "I001","1000.09998");
		 integerMap.put("MET02", "I002","2340123");
		 
		 integerMap.put("MET03", "I001","123123");
		 integerMap.put("MET03", "I002","23434567.876");
		 
		 integerMap.printCmap(); 
		 
		 System.out.println("=======================");
		 System.out.println("=========containsKey1==============");
		 
		 System.out.println(integerMap.containsKey1("MET01"));
		 System.out.println(integerMap.containsKey1("MET04"));
		 
		 System.out.println("=========containsKey2==============");
		 
		 System.out.println(integerMap.containsKey2("MET01","I001"));
		 System.out.println(integerMap.containsKey2("MET02","I003"));
		 
		 System.out.println("=========getValue==============");
		 
		 System.out.println(integerMap.getValue("MET01","I001"));
		 System.out.println(integerMap.getValue("MET02","I003"));
		 
		 System.out.println("=========put(String key1,String key2,String value)==============");
		 
		 integerMap.put("MET01","I001","N");
		 integerMap.put("MET02","I003","0.000000000000");
		 System.out.println();
		 integerMap.printCmap(); 
		 
		 System.out.println("=========getValue==============");
		 
		 System.out.println(integerMap.getValue("MET01","I001"));
		 System.out.println(integerMap.getValue("MET02","I003"));
		 
		 System.out.println("========clear()==========");
		 integerMap.clear();
		 
		 System.out.println(integerMap.size());
		 integerMap.printCmap(); 
		 
	}

}
