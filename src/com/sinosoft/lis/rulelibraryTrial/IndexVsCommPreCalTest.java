package com.sinosoft.lis.rulelibraryTrial;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.f1j.swing.tools.va;
import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LRIndexVsCommPDB;
import com.sinosoft.lis.pubfun.CMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.schema.LRIndexVsCommPSchema;
import com.sinosoft.lis.vschema.LRIndexVsCommPSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;

import examples.newsgroups;

public class IndexVsCommPreCalTest {
	private String t = "薪资配置中";
	public CErrors mErrors = new CErrors();

	//表名，不同的表用于不同场景
	//lrindexinfo_test 规则引擎配置完基本法后试算
	//lrindexinfo 薪资考核正式计算
	//lrindexinfo_temp 薪资考核预算
	private String lrindexinfo;
	private String lrindexvscomm;
	private String lrassessindex;
	
	private CMap cMap = new CMap();
	
	private CMap cMap1 = null;
	
	public IndexVsCommPreCalTest(){
		
	}
	
	

	//试算
	public boolean cal(String basecode, String managecom, String agentgrade, String branchtype, 
			String mWageNo, String indexType,String mcalType,String lastatsegment,CMap cmap) 
	{
		return cal(basecode, managecom, agentgrade, branchtype, 
				mWageNo, indexType,mcalType,lastatsegment,"02",cmap) ;
	}
	//caltype字段：00-正式计算 01-预算
	//vsComm.cal(bBaseCode, mManageCom, agentgrade,mBranchType, bakMonth, typeWage, "unCal",	monthEnd,this.mWageType);
	public boolean cal(String basecode, String managecom, String agentgrade, String branchtype, 
			String mWageNo, String indexType,String mcalType,String lastatsegment,String caltype,CMap cmap) 
	{
		cMap1 = cmap;
		String indexType1 = "";
		String indexType2 = "";
		System.out.println("============================================");
		System.out.println("basecode:" + basecode);
		System.out.println("managecom:" + managecom);
		System.out.println("agentgrade:" + agentgrade);
		System.out.println("branchtype:" + branchtype);
		System.out.println("mWageNo:" + mWageNo);
		System.out.println("indexType:" + indexType);
		System.out.println("mcalType:" + mcalType);
		System.out.println("lastatsegment:" + lastatsegment);
		System.out.println("caltype:（00-正式计算 01-预算 -02-试算   11-重算上月薪资 试算）--" + caltype);
		System.out.println("============================================");
		
		if("11".equals(indexType)){
			indexType1 = "11";
			indexType2 = "01";
		}else{
			indexType1 = indexType;
			indexType2 = indexType;
		}
		
		//确定表名
		if("00".equals(caltype))
		{
			lrindexinfo = "lrindexinfo";//正式计算
			lrindexvscomm = "lrindexvscomm";
			lrassessindex = "lrassessindex";
		}
		else if("01".equals(caltype))
		{
			lrindexinfo = "lrindexinfo_temp";//预警计算
			lrindexvscomm = "lrindexvscomm";
			lrassessindex = "lrassessindex";
		}
		else if("11".equals(caltype))
		{
			lrindexinfo = "lrindexinfo";//重算上个月薪资
			lrindexvscomm = "lrindexvscommC";
			lrassessindex = "lrassessindexC";
		}
		else
		{
			lrindexinfo = "lrindexinfo_test";//试算
			lrindexvscomm = "lrindexvscommp";
			lrassessindex = "lrassessindexp";
		}
		
		//判断是否有人需要计算，没有则返回，节省效率
		ExeSQL exeSQL = new ExeSQL();
		String checkSql = "";
		if(indexType.equals("02"))
		{
			checkSql = "select count(*) from "+lrindexinfo+" a where a.wageno='"+mWageNo+
					"' and a.managecom like '"+managecom+"%' and a.agentgrade='"+agentgrade+"' and a.indextype in ('21','22','23')"+
					" and a.branchtype='"+branchtype+"' and a.basecode='"+basecode+"'";
		}
		else
		{
			checkSql = "select count(*) from "+lrindexinfo+" a where a.wageno='"+mWageNo+
					"' and a.managecom like '"+managecom+"%' and a.agentgrade='"+agentgrade+"' and a.indextype='"+indexType1+
					"' and a.branchtype='"+branchtype+"' and a.basecode='"+basecode+"'";
		}
		String s = exeSQL.getOneValue(checkSql);
		if("0".equals(s))
		{
			System.out.println("没有需要计算的人员，返回！");
			return true;
		}
		
		System.out.println(agentgrade+"职级需要计算薪资的人数：--"+s);
		
		//初始化计算参数
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("lrindexinfo", lrindexinfo);
		paras.put("lrindexvscomm", lrindexvscomm);
		paras.put("lrassessindex", lrassessindex);
		paras.put("BaseCode", basecode);
		paras.put("ManageCom", managecom);
		paras.put("IndexCalNo", mWageNo);
		paras.put("WageNo", mWageNo);//两个年月一样使用
		paras.put("AgentGrade", agentgrade);
		paras.put("BranchType", branchtype);
		paras.put("BranchType2", "1");
		paras.put("AgentCode", "X.AgentCode");
		paras.put("IndexType", indexType);
		paras.put("IndexType1", indexType1);
		paras.put("IndexType2", indexType2);
		paras.put("AgentGroup", "X.AgentGroup");
		paras.put("BranchAttr", "X.BranchAttr");
		paras.put("CalType", mcalType);
		paras.put("CalType2", caltype);
		System.out.println("CalType2--->"+caltype);
		paras.put("MonthEnd", lastatsegment);
		
		switch(Integer.parseInt(indexType))
		{
		    case 1:
			    t = "薪资配置中";
			    break;
			case 2:
				t = "考核配置中";
				break;
		}
		paras.put("t", t);
		
		LRIndexVsCommPSchema tLRIndexVsCommPSchema = new LRIndexVsCommPSchema();
		LRIndexVsCommPDB db = new LRIndexVsCommPDB();
		LRIndexVsCommPSet commSet = new LRIndexVsCommPSet();
		
		String sql = "select * from "+lrindexvscomm+" where basecode=? and agentgrade=? and indexType=? order by wageorder";
		
		List paraList =new ArrayList(); 
		paraList.add(basecode); 
		paraList.add(agentgrade); 
		paraList.add(indexType2); 
		if ("11".equals(indexType)) {
			sql = "select * from "+lrindexvscomm+" where basecode=? and agentgrade=? and indexType=? and bakemonth=? order by wageorder";
			paraList.add(mWageNo);
		}
		if(indexType.startsWith("02")){
			sql = "select * from "+lrindexvscomm+" where basecode=? and agentgrade=? and indexType in('21','22','23') order by wageorder";
			paraList =new ArrayList(); 
			paraList.add(basecode); 
			paraList.add(agentgrade); 
		}
		commSet = db.executeQuery(sql,PubFun.getFormatBV(paraList)); 

		
		for(int i = 1; i <= commSet.size(); i++) {
			LRIndexVsCommPSchema commSchema = commSet.get(i);
			String indexCode = commSchema.getIndexCode();
			String tIndexType = commSchema.getIndexType();
			System.out.println("[*****计算项目*****]" + commSchema.getWageName() + ":(WageCode=" + commSchema.getWageCode() + ")");
			//查询具体对应rule
			String pk_sql = "";
			if ("11".equals(indexType)) {
				pk_sql = "select indexcode,indexname,basecode,agentgrade,datatype,indexset,indextype from "+lrassessindex+" where basecode='"+basecode+"' and indexcode='"+indexCode+"' and agentgrade='"+agentgrade+"' and indextype = '"+tIndexType+"' and bakmonth='"+mWageNo+"' ";
			}else {
				pk_sql = "select indexcode,indexname,basecode,agentgrade,datatype,indexset,indextype from "+lrassessindex+" where basecode='"+basecode+"' and indexcode='"+indexCode+"' and agentgrade='"+agentgrade+"' and indextype = '"+tIndexType+"' ";
			}
			SSRS indexSSRS = new SSRS();
			ExeSQL indexExeSQL = new ExeSQL();
			indexSSRS = indexExeSQL.execSQL(pk_sql);
			if(indexSSRS.getMaxRow()<=0){
				System.out.println("[*****计算项目*****]" + commSchema.getWageName() + ":(WageCode=" + commSchema.getWageCode() + ")");
				if(indexCode == null || indexCode.trim().equals("")){
					CError.buildErr(this, bundle.getString("Rule_01_1")+t+"【"+commSchema.getAgentGrade()+"】-"+bundle.getString("Title")+"【"+commSchema.getWageCode()+commSchema.getWageName()+"】"+bundle.getString("Rule_01_3"));
				}else{
					CError.buildErr(this, bundle.getString("Rule_02_1")+t+"【"+commSchema.getAgentGrade()+"】-"+bundle.getString("Title")+"【"+commSchema.getWageCode()+commSchema.getWageName()+"】"+bundle.getString("Rule_02_3")+"【"+commSchema.getIndexCode()+"】"+bundle.getString("Rule_02_4"));
				}
				return false;
			}
			AssessIndexCal indexCal = new AssessIndexCal();
			paras.put("WageCode", commSchema.getWageCode());
			indexCal.cal(indexSSRS, paras);
			if(indexCal.mErrors.needDealError()) {
    			mErrors.copyAllErrors(indexCal.mErrors);
    			return false;
    		}
		}
		cMap.printCmap();
		return true;
		
	}
	
	/**
	 * 规则计算类
	 * @author fxfeng
	 *
	 */
	public class AssessIndexCal
	{
		public CErrors mErrors = new CErrors();
		private String lrindexinfo;
		private String lrindexvscomm;
		private String lrassessindex;
		
		private String basecode;
		
		private String indextype;
		
		public boolean cal(SSRS indexSSRS, Map<String, String> paras) 
		{
			//获取SSRSS中的值
			String tIndexCode = indexSSRS.GetText(1, 1);
			String tIndexName = indexSSRS.GetText(1, 2);
			String tBaseCode = indexSSRS.GetText(1, 3);
			String tAgentGrade = indexSSRS.GetText(1, 4);
			String tDataType = indexSSRS.GetText(1, 5);
			String tIndexSet = indexSSRS.GetText(1, 6);
			String tIndexType = indexSSRS.GetText(1, 7);
			lrindexinfo = paras.get("lrindexinfo");
			lrindexvscomm = paras.get("lrindexvscomm");
			lrassessindex = paras.get("lrassessindex");
			//判断是否计算过，不应该重复计算
			ExeSQL exe = new ExeSQL();
			String query = "select min(state) from "+lrindexinfo+" where WageNo= '"+paras.get("IndexCalNo")+"' and IndexType='"+paras.get("IndexType")+"' and BranchType='"+paras.get("BranchType")+"' and BaseCode='"+paras.get("BaseCode")+"' and IndexCode='"+tIndexCode+"' and managecom like '"+paras.get("ManageCom")+"%' and AgentGrade='"+paras.get("AgentGrade")+"'";
			if(paras.get("IndexType").equals("02")){
				query = "select min(state) from "+lrindexinfo+" where WageNo= '"+paras.get("IndexCalNo")+"' and IndexType in ('21','22','23') and BranchType='"+paras.get("BranchType")+"' and BaseCode='"+paras.get("BaseCode")+"' and IndexCode='"+tIndexCode+"' and managecom like '"+paras.get("ManageCom")+"%' and AgentGrade='"+paras.get("AgentGrade")+"'";
			}
			SSRS ss = exe.execSQL(query);
			if(ss.MaxRow <= 0) {
				CError.buildErr(this, bundle.getString("Rule_06_1")+paras.get("t")+"【"+paras.get("AgentGrade")+"】-"+bundle.getString("Rule_06_2")+"【"+paras.get("WageCode")+"】-"+bundle.getString("Rule_06_3")+"【"+paras.get("IndexCode")+"】"+bundle.getString("Rule_06_4"));
				return false;
			}
			String state = ss.GetText(1, 1);
			System.out.println(paras.get("CalType").trim().equals("CalMain")+"--------"+paras.get("CalType"));
			if(state != null && state.trim().startsWith("C")) {//已计算则不计算	已经计算的不再计算，这样的话，重算薪资的意义已经不大了。 
				return true;
			}

			if( paras.get("CalType").trim().equals("CalMain")) {//存在C开头计算过
				//by fengfei 里面的内容发现不可能走到，已删除，如发现错误，可以通过svn查询第一版本进行恢复
				System.out.println("里面的内容发现不可能走到，已删除，如发现错误，可以通过svn查询第一版本进行恢复");
				return true;
			}
			
			String indexSet = tIndexSet;
			//计算子指标
			if(indexSet != null && !indexSet.trim().equals("")) 
			{
				System.out.println("[计算子指标]" + tIndexName + ":(IndexSet=" + indexSet + ")");
				String[] sets = indexSet.trim().split(",");
				for(int i = 0; i < sets.length; i++) 
				{
					System.out.println("[计算子指标]" + tIndexName + ":(indexcode=" + sets[i] + ")");
					String pk_sql = "";
					if ("11".equals(paras.get("IndexType"))) {
						pk_sql = "select indexcode,indexname,basecode,agentgrade,datatype,indexset,indextype from "+lrassessindex+" where basecode='"+tBaseCode+"' and indexcode='"+sets[i]+"' and indextype = '"+tIndexType+"' and agentgrade='"+tAgentGrade+"' and bakmonth='"+paras.get("IndexCalNo")+"'  ";
					}else {
						pk_sql = "select indexcode,indexname,basecode,agentgrade,datatype,indexset,indextype from "+lrassessindex+" where basecode='"+tBaseCode+"' and indexcode='"+sets[i]+"' and indextype = '"+tIndexType+"' and agentgrade='"+tAgentGrade+"'";
					}
					SSRS indexSSRS1 = new SSRS();
					ExeSQL indexExeSQL1 = new ExeSQL();
					indexSSRS1 = indexExeSQL1.execSQL(pk_sql);
					if(indexSSRS1.getMaxRow()<=0){
						System.out.println("[计算子指标]" + tIndexName + ":(IndexSet=" + indexSet + ")");
						System.out.println("[计算子指标]" + tIndexName + ":(indexcode=" + sets[i] + ")");
						CError.buildErr(this, bundle.getString("Rule_07_1")+paras.get("t")+"【"+paras.get("AgentGrade")+"】-"+bundle.getString("Rule_07_2")+"【"+paras.get("WageCode")+"】"+bundle.getString("Rule_07_3")+"【"+paras.get("IndexCode")+"】");
						return false;
					}
					//准备变量
					Map<String, String> tParas = new HashMap<String, String>();
					Iterator<String> it = paras.keySet().iterator();
					while(it.hasNext()) {
						String key = it.next();
						tParas.put(key, paras.get(key));
					}
					if(!cal(indexSSRS1, tParas)){
						return false;
					}
				}
			}
			
			//计算自己
			System.out.println("[计算指标]" + tIndexName + ":(IndexCode=" + tIndexCode + ")");
			paras.put("IndexCode", tIndexCode);
			String querySql = "";//计算基础指标
			if ("11".equals(paras.get("IndexType"))) {
				querySql = "select isnull(calsql,'') from "+lrassessindex+" where BaseCode='"+tBaseCode+"' and agentgrade='"+tAgentGrade+"' and indextype = '"+tIndexType+"' and IndexCode='"+tIndexCode+"' and bakmonth='"+paras.get("IndexCalNo")+"'  ";//计算基础指标
			}else {
				querySql = "select isnull(calsql,'') from "+lrassessindex+" where BaseCode='"+tBaseCode+"' and agentgrade='"+tAgentGrade+"' and indextype = '"+tIndexType+"' and IndexCode='"+tIndexCode+"'";//计算基础指标
			}
			SSRS sqlrs = exe.execSQL(querySql);
			if(sqlrs.MaxRow < 1) {
				System.out.println("[计算指标]" + tIndexName + ":(IndexCode=" + tIndexCode + ")");
				return false;
			}
			String calSQL = sqlrs.GetText(1, 1);
			if(calSQL == null || calSQL.trim().equals("")) {
				System.out.println("calsql ---->"+ calSQL);
				CError.buildErr(this, "sql "+bundle.getString("Rule_isblank")+"(BaseCode:" + tBaseCode + ",IndexCode:" +tIndexCode+ ")");
				return false;
			}
			//start 解析sql
			//解析变量
			calSQL = calSQL.replaceAll("'\\?BranchAttr\\?%'", "X.BranchAttr||'%'");
			calSQL = calSQL.replaceAll("'\\?ManageCom\\?'", "X.ManageCom");
			while(calSQL.indexOf("?") != -1) {
				int begin = calSQL.indexOf("?");
				int end = calSQL.indexOf("?", begin+1);
				String paraName = calSQL.substring(begin+1, end);
				String value = paras.get(paraName);
				if(value == null) {
					CError.buildErr(this, bundle.getString("Rule_08_1")+paras.get("t")+"【"+paras.get("AgentGrade")+"】-"+bundle.getString("Rule_08_2")+"【"+paras.get("WageCode")+"】"+bundle.getString("Rule_08_3")+"【"+paras.get("IndexCode")+"】"+bundle.getString("Rule_08_4") + paraName);
					return false;
				}
				calSQL = calSQL.replaceAll("\\?"+paraName+"\\?", value);
			}
			//参数
			if(calSQL.indexOf("#") > -1) {
				CError.buildErr(this, bundle.getString("Rule_01_1")+paras.get("t")+"【"+paras.get("AgentGrade")+"】-"+bundle.getString("Rule_01_2")+"【"+paras.get("WageCode")+"】-"+bundle.getString("Rule_06_3")+"【"+paras.get("IndexCode")+"】"+bundle.getString("Rule_09_4"));
				return false;
			}
			//解析指标
			String calSQL1 = calSQL;
//			while(calSQL.indexOf("@") != -1) {
//				int begin = calSQL.indexOf("@");
//				int end = calSQL.indexOf("@", begin+1);
//				String indexcode = calSQL.substring(begin+1, end);
//				String sql = "";
//				
//				String datatype = cMap1.get(tAgentGrade, indexcode);
//				
//				if(datatype == null || datatype.trim().equals("")){
//					continue;
//				}
//				if(datatype.equals("S")) {
//					datatype = "isnull("+datatype+",' ')";
//				}else if(datatype.equals("D")) {
//					datatype = "isnull("+datatype+",'1900-01-01')";
//				} else {
//					datatype = "isnull("+datatype+", 0)";
//				}
//				String sql2 = "select "+datatype+" from "+lrindexinfo+" where WageNo=X.WageNo and IndexType=X.IndexType and BranchType=X.BranchType  and BaseCode=X.BaseCode and AgentCode=X.AgentCode and IndexCode='"+indexcode+"'";
//				calSQL = calSQL.replaceAll("@"+indexcode+"@", "(" + sql2 + ")");
//			}
			
//			calSQL = calSQL.replaceAll("'X.AgentCode'", "X.AgentCode");
//			calSQL = calSQL.replaceAll("'X.AgentGroup'", "X.AgentGroup");
//			calSQL = calSQL.replaceAll("'X.BranchAttr'", "X.BranchAttr");
			
			System.out.println("==================start=========================");
			
			String agentcodeString = "select DISTINCT AgentCode FROM LRIndexInfo WHERE AgentGrade='"+paras.get("AgentGrade")+"' AND BranchType='1' AND IndexType='"+paras.get("IndexType")+"' AND WageNo='" + paras.get("IndexCalNo") + "' ";
			
			SSRS rSsrs = new ExeSQL().execSQL(agentcodeString);
			String sql = null;
			if (paras.get("IndexCode").startsWith("I")) {
				
				for(int i = 1 ; i <= rSsrs.getMaxRow() ; i++){
					String calSQLTemp = calSQL1.replaceAll("X.AgentCode",rSsrs.GetText(i, 1));
					SSRS rsSsrs1 = new ExeSQL().execSQL(calSQLTemp);
					String dataValueString = null;
					if (rsSsrs1.getMaxRow() > 0) {
						dataValueString  = rsSsrs1.GetText(1, 1);
					}
					
					System.out.println("dataValueString:"+dataValueString);
					cMap.put(rSsrs.GetText(i, 1), paras.get("IndexCode"), dataValueString);
					System.out.println(rSsrs.GetText(i, 1)+" : "+paras.get("IndexCode") +" : " +cMap.getValue(rSsrs.GetText(i, 1), paras.get("IndexCode")));
					
					sql = "update X set " + tDataType + "=( " + convert(cMap.getValue(rSsrs.GetText(i, 1), paras.get("IndexCode")),tDataType) + " ),state='CalBase',modifydate=cast('"+PubFun.getCurrentDate()+"' as datetime),modifytime='"+PubFun.getCurrentTime()+"' from "+lrindexinfo+" X where agentcode = '" + rSsrs.GetText(i, 1) + "' and WageNo='" + paras.get("IndexCalNo") + "' and managecom like '" + paras.get("ManageCom") + "%' and AgentGrade='"+paras.get("AgentGrade")+"' and state='unCal' and IndexCode='"+paras.get("IndexCode")+"' and indextype='"+paras.get("IndexType")+"'" ;
					System.out.println(sql);
					boolean succed = exe.execUpdateSQL(sql);
					if(!succed) {
						CError.buildErr(this, bundle.getString("SQLprocessingfailed!"));
						return false;
					}		
				}
				
			}else if (paras.get("IndexCode").startsWith("R")) {
				
				for(int i = 1 ; i <= rSsrs.getMaxRow() ; i++){
					
					while(calSQL1.indexOf("@") != -1) {
						int begin = calSQL1.indexOf("@");
						int end = calSQL1.indexOf("@", begin+1);
						String indexcode = calSQL1.substring(begin+1, end);
						
						String datatype = cMap1.get(tAgentGrade, indexcode);
						
						calSQL1 = calSQL1.replaceAll("@"+indexcode+"@", "(" + convert(cMap.getValue(rSsrs.GetText(i, 1), indexcode ),datatype) + ")");
					}
					
					System.out.println(calSQL1);
					SSRS rsSsrs2 = new ExeSQL().execSQL(calSQL1);
					String dataValueString = null;
					if (rsSsrs2.getMaxRow() > 0) {
						dataValueString  = rsSsrs2.GetText(1, 1);
					}
					System.out.println("dataValueString:"+dataValueString);
					cMap.put(rSsrs.GetText(i, 1), paras.get("IndexCode"), dataValueString);
					System.out.println(rSsrs.GetText(i, 1)+" : "+paras.get("IndexCode") +" : " +cMap.getValue(rSsrs.GetText(i, 1), paras.get("IndexCode")));
					
					sql = "update X set " + tDataType + "=( " + convert(cMap.getValue(rSsrs.GetText(i, 1), paras.get("IndexCode")),tDataType) + " ),state='CalBase',modifydate=cast('"+PubFun.getCurrentDate()+"' as datetime),modifytime='"+PubFun.getCurrentTime()+"' from "+lrindexinfo+" X where agentcode = '" + rSsrs.GetText(i, 1) + "' and WageNo='" + paras.get("IndexCalNo") + "' and managecom like '" + paras.get("ManageCom") + "%' and AgentGrade='"+paras.get("AgentGrade")+"' and state='unCal' and IndexCode='"+paras.get("IndexCode")+"' and indextype='"+paras.get("IndexType")+"'" ;
					System.out.println(sql);
					boolean succed = exe.execUpdateSQL(sql);
					if(!succed) {
						CError.buildErr(this, bundle.getString("SQLprocessingfailed!"));
						return false;
					}		
				}
				
			}
			
			System.out.println("==================end=========================");
			
			return true;
		}
		
	}
	
	public String convert(String value,String dataType){
		if (value == null || "null".equals(value) ) {
			if("N0".equals(dataType)){
				return "CONVERT(NUMERIC(17,6),'0')";
			}else if("N2".equals(dataType)){
				return "CONVERT(NUMERIC(17,6),'0')";
			}else if("N4".equals(dataType)){
				return "CONVERT(NUMERIC(17,6),'0')";
			}else if("N6".equals(dataType)){
				return "CONVERT(NUMERIC(17,6),'0')";
			}else if("D".equals(dataType)){
				return "CONVERT(DATE,'1900-01-01')";
			}else if("S".equals(dataType)){
				return "''";
			}else {
				return null;
			}
		}
		if("N0".equals(dataType)){
			return "CONVERT(NUMERIC(17,0),isnull('"+value+"',0))";
		}else if("N2".equals(dataType)){
			return "CONVERT(NUMERIC(17,2),isnull('"+value+"',0))";
		}else if("N4".equals(dataType)){
			return "CONVERT(NUMERIC(17,4),isnull('"+value+"',0))";
		}else if("N6".equals(dataType)){
			return "CONVERT(NUMERIC(17,6),isnull('"+value+"',0))";
		}else if("D".equals(dataType)){
			return "CONVERT(DATE,isnull('"+value+"','1900-01-01'))";
		}else if("S".equals(dataType)){
			return "isnull('"+value+"','')";
		}else {
			return null;
		}
	}
	
	
	public static void main(String[] args) {  
		  
        
        String sqlString = "select case when  ('Y') = 'Y'  then   (CONVERT(NUMERIC(17,6),'0.000000')) *  (CONVERT(NUMERIC(17,6),'0.000'))  else  0  end from dual";
        
        ExeSQL exeSQL = new ExeSQL();
        
        SSRS rs = exeSQL.execSQL(sqlString);
        
        System.out.println(rs.GetText(1, 1));
        
  
    }  
	
}
