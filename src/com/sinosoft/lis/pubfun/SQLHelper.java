package com.sinosoft.lis.pubfun;

import com.sinosoft.utility.ExeSQL;

public class SQLHelper {

	ExeSQL tExeSQL=new ExeSQL();
	
	public static String getWherePart(String condition, String value, String symbol, int dataType) {
		if (value == null || value.trim().length() == 0 || condition == null || condition.trim().length() == 0) {
			return "";
		}
		String tCondition="";
		String tValue="";
		
		symbol = (symbol == null ? "=" : symbol);
		if(dataType==1){//数字/boolean 类型，value不加''
			tCondition=condition;
			tValue=value;
		}else if(dataType==2){//oracle日期类型
			tCondition="to_char("+condition+",'yyyy-mm-dd')";
			tValue="to_char(to_date('"+value+"','yyyy-mm-dd'),'yyyy-mm-dd')";
			//转成这种格式可避免时间的比较，另外支持传入字符型日期2014-1-1，而不是一定要为2014-01-01
		}else{//正常字符类型
			tCondition=condition;
			tValue += symbol.trim().equalsIgnoreCase("LIKE") ? ("'%" + value + "%' "): ("'" + value + "' ");
		}
		String str = " and " + tCondition + " " + symbol + " " + tValue + " ";
		return str;
	}

	// 拼接为SQL中的and条件
	public String getWherePart(String condition, String value) {
		return getWherePart(condition,value,"=",0);
	}
	
	public String getWherePart(String condition, String value,String operator) {
		return getWherePart(condition,value,operator,0);
	}
	
	public String getWherePart(String condition, String value,int dataType) {
		return getWherePart(condition,value,"=",dataType);
	}
	
//	public static void main(String[] args){
//		SQLHelper a=new SQLHelper();
//		String powerSql="select * from laagent a where 1=1 ";
////		powerSql+=a.getWherePart("a.agentcode", "BAAAA00009");
//		powerSql+=a.getWherePart("a.name", "   ");
//		powerSql+=a.getWherePart("a.makedate", "2014-8-17",2);
//		System.out.println(powerSql);
//		System.out.println(a.tExeSQL.execSQL(powerSql).getMaxRow()+"----"+a.tExeSQL.execSQL(powerSql).getMaxCol());
//	}
	
}
