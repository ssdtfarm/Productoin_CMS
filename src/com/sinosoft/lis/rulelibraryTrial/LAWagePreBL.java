// * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
// * All Rights Reserved.    
package com.sinosoft.lis.rulelibraryTrial;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LDCOMDB;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.vschema.LDCOMSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class LAWagePreBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private String mOperate;// 数据操作字符串
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	private VData mResult = new VData();// 存放返回数据的容器
	private String mManageCom = "";
	private String mBranchType = "";
	private String mBaseCode = "";
	private String mWageNo = "";
	private String mIndexType = "01";
	private String mIndexTypeSet = " in  ('21','22','23')";
	private String tIndexType = "01";
	private String currentDate = PubFun.getCurrentDate();
	private String currentTime = PubFun.getCurrentTime();
	
	LDCOMSet tLDComSet = new LDCOMSet();
	LDCOMDB tLDComDB = new LDCOMDB();

	public LAWagePreBL() {
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
		return true;
	}

	/**
	 * 从输入数据中得到所有对象 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
	 */
	public boolean getInputData(VData cInputData) {
		// 全局变量
		mGlobalInput = (GlobalInput) cInputData.get(0);
		TransferData transferData = (TransferData) cInputData.get(1);
		mManageCom = (String) transferData.getValueByName("ManageCom");
		mBranchType = (String) transferData.getValueByName("BranchType");
		mBaseCode = (String) transferData.getValueByName("BaseCode");
		mWageNo = (String) transferData.getValueByName("WageNo");
		String tmp = (String) transferData.getValueByName("IndexType");
		if (tmp != null && !"".equals(tmp.trim())) {
			mIndexType = tmp;
		}

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
		ExeSQL exe = new ExeSQL();
		String lastatsegment_sql = "select CONVERT(VARCHAR(10),enddate,112) from lastatsegment where yearmonth = '"+ mWageNo + "' and stattype = '1'";
		String lastatsegment = exe.getOneValue(lastatsegment_sql);
		if ("".equals(lastatsegment) || null == lastatsegment) {
			CError.buildErr(this, bundle.getString("Naturalmonthinformationhasnotbeenset!"));
			return false;
		}
		if (mOperate.equals("calculate")) {
			// 基础指标计算
			System.out.println("start calculate...");
			
			//先删除上次计算数据
			String delete = "delete  from lrindexinfo_Test where basecode='"
							+ mBaseCode + "' and managecom like '" + mManageCom	+ "%' and branchtype='" + mBranchType 
							+ "' and wageno='"+ mWageNo + "' and IndexType='" + mIndexType + "'";
			String delete_LAAssessAccessoryTrial = "delete from LAAssessAccessoryTrial where INDEXCALNO = '"
											+mWageNo+"' and ASSESSTYPE= '02' and BRANCHTYPE = '"+mBranchType+"' and BRANCHTYPE2 = '1' and managecom like '"
											+mManageCom+"%' and basecode = '"+mBaseCode+"'";
			if(mIndexType.equals("02")){
				delete = "delete  from lrindexinfo_Test where basecode='"+ mBaseCode + "' and managecom like '" 
							+ mManageCom + "%' and branchtype='" + mBranchType + "' and wageno='"
							+ mWageNo + "' and IndexType " + mIndexTypeSet + "";
				exe.execUpdateSQL(delete_LAAssessAccessoryTrial);
			}
			exe.execUpdateSQL(delete);
			
			//校验是否有人
			String currDate = mWageNo.substring(0, 4) + "-" + mWageNo.substring(4) + "-" + "01";
			String monthEnd = PubFun.calDateIntev(PubFun.calDateIntev(currDate, 1, "M"), -1, "D");
			StringBuffer str1 = new StringBuffer();
			str1.append("select count(1) from laagent a where managecom like '"	+ mManageCom + "%' and branchtype='" + mBranchType + "'");
			str1.append(" and agentstate in ('01','02') and not exists(select 1 from lrindexinfo_Test ");
			str1.append("where managecom=a.managecom and branchtype=a.branchtype ");
			str1.append("and basecode='" + mBaseCode + "' and wageno='"	+ mWageNo + "' ");
			str1.append("and a.agentcode=agentcode and a.agentgroup=agentgroup");
			if(mIndexType.equals("02")){
				str1.append(" and IndexType "+ mIndexTypeSet + ")");
			}else{
				str1.append(" and IndexType='"+ mIndexType + "')");
			}
			int count = Integer.parseInt(exe.getOneValue(str1.toString()));
			if (count == 0) {
				//CError.buildErr(this, "管理机构:" + mManageCom + " 没有人员需要计算，请确认计算条件是否正确！");
				CError.buildErr(this, mManageCom +bundle.getString("Rule_10"));
				return false;
			}

			//通过base-index关系表获得需要计算的所有职级
			String grade = "select gradecode from laagentgrade a where branchtype='"+ mBranchType
						+ "'  and exists(select 1 from lrindexvscommp where branchtype='"+ mBranchType	;
			if(mIndexType.equals("02")){
				grade += "' and IndexType "+ mIndexTypeSet ;
			}else{
				grade += "' and IndexType='"+ mIndexType + "'";
			}
			grade +=  " and basecode='" + mBaseCode + "' and agentgrade=a.gradecode) order by gradeid ";
			
//			String WageName = "";
//			String WageCode = "";
//			String indexcode = "";
//			String datatype = "";
//			String mainindexflag = "";
//			String W_sql  = "";
			SSRS grades = exe.execSQL(grade);
			for (int i = 1; i <= grades.MaxRow; i++) {
				//通过base-rule关系表获得需要计算的规则
				String agentgrade = grades.GetText(i, 1);
				System.out.println("start calculate..."+agentgrade);
				String temp = "('01')";
				//初始化lrindexinfo_test
//				String sql = "select indexcode,datatype,mainindexflag,indextype from lrassessindexp  where  basecode='"+ mBaseCode+ "'  and agentgrade='"+agentgrade+"' and indextype in ('01')  order by MainIndexFlag desc";
				if(mIndexType.equals("02")){
//					sql = "select indexcode,datatype,mainindexflag,indextype from lrassessindexp  where  basecode='"+ mBaseCode+ "'  and agentgrade='"+agentgrade+"' and indextype in ('21','22','23')  order by MainIndexFlag desc";
					temp = "('21','22','23')";
				}
				
//				SSRS indexcodes = exe.execSQL(sql);
//				for (int j = 1; j <= indexcodes.MaxRow; j++) {
//					indexcode = indexcodes.GetText(j, 1);
//					datatype = indexcodes.GetText(j, 2);
//					mainindexflag = indexcodes.GetText(j, 3);
//					tIndexType = indexcodes.GetText(j, 4);
//					System.out.println("start init..."+indexcode);
//					W_sql = "select (select WageName from lrindex where wagecode = a.wagecode),wageCode from lrassessindexlibrary  a where indexcode = '"+indexcode+"' "
//							+ "union select (select name from lrbom where id = bomid),bomid from lrterm a where id = '"+indexcode+"'";
//					SSRS ssrs = exe.execSQL(W_sql);
//					WageName = ssrs.GetText(1, 1);
//					WageCode = ssrs.GetText(1, 2);
					StringBuffer str = new StringBuffer();
					str.append("insert into lrindexinfo_test (");
					str.append("WageNo,IndexType,BranchType,BranchType2,BaseCode");
					str.append(",AgentCode,AgentGrade,ManageCom,BranchAttr,AgentGroup");
					str.append(",State,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime");
					str.append(",IndexCode,DataType,WageName,WageCode,mainindexflag");
					str.append(",caltype");
					str.append(") ");
					
					str.append("(select '").append(mWageNo).append("',c.indextype,a.branchtype,'1',c.basecode");
					str.append(",a.agentcode,c.agentgrade,a.ManageCom,");
					str.append("(select branchattr from labranchgroup where agentgroup=a.agentgroup),a.AgentGroup,'");
					str.append("unCal','");
					str.append(mGlobalInput.Operator).append("','").append(currentDate).append("','").append(currentTime);
					str.append("','").append(currentDate).append("','").append(currentTime);
					str.append("',c.indexcode").append(",c.datatype");
					str.append(",(select indexname from lrassessindexlibrary where indexcode = c.indexcode union select name from lrterm where id = c.indexcode)");
					str.append(",(select wagecode from lrassessindexlibrary where indexcode = c.indexcode union select bomid from lrterm where id = c.indexcode)");
					str.append(",c.mainindexflag,'02'");
					
					str.append(" from laagent a, lrassessindexp c where 1=1 and a.agentstate in ('01','02') ");
					str.append(" and a.managecom like '"+this.mManageCom+"%'  and a.branchtype='"+this.mBranchType+"'");
					str.append(" and exists (select 1 from latree where agentcode=a.agentcode and agentgrade=c.agentgrade) ");
					str.append(" and c.basecode = '"+ mBaseCode+ "' and c.agentgrade = '"+agentgrade+"' and c.indextype in "+temp);
					str.append(" and exists(select 1 from latree where agentcode=a.agentcode and agentgrade=c.agentgrade) ");
					str.append(" and not exists(select 1 from lrindexinfo_Test where managecom=a.managecom and branchtype=a.branchtype");
					str.append(" and basecode=c.basecode and wageno='"+ mWageNo + "' and a.agentcode=agentcode ");
					str.append(" and a.agentgroup=agentgroup and indexcode=c.indexcode and indextype = c.indextype) )");
					
					exe.execUpdateSQL(str.toString());
//				}	
				// 计算
				IndexVsCommPreCal vsComm = new IndexVsCommPreCal();
				try {
					vsComm.cal(mBaseCode, mManageCom, agentgrade,mBranchType, mWageNo, mIndexType, "unCal",	lastatsegment);
					if (vsComm.mErrors.needDealError()) {
						mErrors.copyAllErrors(vsComm.mErrors);
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
//		System.out.println("开始进行薪资项目计算");
//		// 真正的薪资计算
//		String grade = "select gradecode from laagentgrade a where branchtype='"+ mBranchType+ 
//				"'  and exists(select 1 from lrindexvscommp where branchtype='"	+ mBranchType+ "' and agentgrade=a.gradecode) order by gradeid ";
//		SSRS grades = exe.execSQL(grade);
//		for (int i = 1; i <= grades.MaxRow; i++) {
//			String agentgrade = grades.GetText(i, 1);
//			IndexVsCommPreCal vsComm = new IndexVsCommPreCal();
//			try {
//				vsComm.cal(mBaseCode, mManageCom, agentgrade, mBranchType,mWageNo, mIndexType, "CalMain", lastatsegment);
//				if (vsComm.mErrors.needDealError()) {
//					mErrors.copyAllErrors(vsComm.mErrors);
//					return false;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//			}
//		}
		System.out.println("===============计算完成===============");
		return true;
	}

	/**
	 * 这个方法返回的结果中存放程序执行后的结果 如果程序需要返回数据，可以通过这个方法实现
	 * 
	 * @return 返回一个VData容器
	 */
	public VData getResult() {
		
		try{
		ExeSQL exe = new ExeSQL();
		String deluncal = "delete from lrindexinfo_test where state = 'unCal' and basecode='"+ mBaseCode + "' and managecom like '" + mManageCom + "%' and branchtype='" + mBranchType + "' and wageno='"+ mWageNo + "' and IndexType ='01'";
//		String Asses = "insert into LAAssessAccessoryTrial (indexcalno,assesstype,agentcode,branchtype,agentgroup,managecom,agentseries,agentgrade,calagentseries,calagentgrade,agentseries1,agentgrade1,state,standassessflag,operator,makedate,maketime,modifydate,modifytime,branchtype2,basecode) "
//				+ "select wageno,'02',agentcode,branchtype,agentgroup,managecom,(select gradeproperty2 from laagentgrade where gradecode = a.agentgrade),agentgrade,(select gradeproperty2 from laagentgrade where gradecode = a.s),s,(select gradeproperty2 from laagentgrade where gradecode = a.s),s,'0','0','"+mGlobalInput.Operator+"','"+currentDate+"','"+currentTime+"','"+currentDate+"','"+currentTime+"','01','"+mBaseCode+"'  "
//				+ "from lrindexinfo_test a where  1=1    and wageno = '"+mWageNo+"'   and managecom like '" + mManageCom + "%'   and basecode = '"+mBaseCode+"'   and mainindexflag = 'Y'   and indextype = '23' ";
		if(mIndexType.equals("02")){
		   deluncal = "delete from lrindexinfo_test where state = 'unCal' and basecode='"+ mBaseCode + "' and managecom like '" + mManageCom + "%' and branchtype='" + mBranchType + "' and wageno='"+ mWageNo + "' and IndexType " + mIndexTypeSet + "";

			//写入考核结果表
			StringBuffer rs = new StringBuffer();
			rs.append("insert into laassessaccessorytrial");
			rs.append(" (INDEXCALNO,ASSESSTYPE,AGENTCODE,BASECODE,BRANCHTYPE,BRANCHATTR,AGENTGROUP,MANAGECOM");
			rs.append(",RESULT,MODIFYFLAG,AGENTGRADE,CALAGENTGRADE,STATE");
			rs.append(",OPERATOR,MAKEDATE,MAKETIME,MODIFYDATE,MODIFYTIME,BRANCHTYPE2,IsJoin,Salary_Old)");
			rs.append(" select a.wageno,a.caltype,a.agentcode,a.basecode,a.branchtype,a.branchattr,a.agentgroup,a.managecom,");
			rs.append("a.s,'N',a.agentgrade");
			//考核结果职级
			rs.append(",(select (case when lag_old.gradeproperty2 < lag_new.gradeproperty2 then (select gradecode from laagentgrade where branchtype = lag_old.branchtype and gradeid = (select max(gradeid) from laagentgrade where branchtype = lag_old.branchtype and gradeproperty2 = lag_old.gradeproperty2)) else lag_new.gradecode end) from laagentgrade lag_old, laagentgrade lag_new where lag_new.gradeid = lag_old.gradeid + a.s and lag_old.gradecode = a.agentgrade and a.s >= '1' union select a.agentgrade from dual where a.s = '0' union select lag_new.gradecode from laagentgrade lag_old, laagentgrade lag_new where lag_new.branchtype = lag_old.branchtype and lag_new.gradeid = lag_old.gradeid - 1 and lag_new.gradecode <> 'IAM000' and lag_old.gradeid >= 2 and lag_old.branchtype = a.branchtype and lag_old.gradecode = a.agentgrade and a.s = '-1' union select 'IA0006' from laagentgrade lag_old, laagentgrade lag_new where lag_new.branchtype = lag_old.branchtype and lag_new.gradeid = lag_old.gradeid - 1 and lag_new.gradecode = 'IAM000' and lag_old.branchtype = a.branchtype and lag_old.gradecode = a.agentgrade and a.s = '-1' union select '无法胜任' from laagentgrade lag_old where lag_old.gradeid = 1 and lag_old.branchtype = a.branchtype and lag_old.gradecode = a.agentgrade and a.s = '-1' union select lag_new.gradecode from laagentgrade lag_old, laagentgrade lag_new where lag_new.branchtype = lag_old.branchtype and lag_new.gradeid = lag_old.gradeid - 2 and lag_old.gradecode not in ('IAM001', 'IAM002') and lag_old.gradeid >= 3 and lag_old.branchtype = a.branchtype and lag_old.gradecode = a.agentgrade and a.s = '-2' union select 'IA0006' from laagentgrade lag_old where lag_old.gradecode in ('IAM001', 'IAM002') and lag_old.branchtype = a.branchtype and lag_old.gradecode = a.agentgrade and a.s = '-2' union select '无法胜任' from laagentgrade lag_old where lag_old.gradeid <= 2 and lag_old.branchtype = a.branchtype and lag_old.gradecode = a.agentgrade and a.s = '-2')");
			rs.append(",'1','");
			rs.append(mGlobalInput.Operator).append("','");
			rs.append(PubFun.getCurrentDate()).append("','");
			rs.append(PubFun.getCurrentTime()).append("','");
			rs.append(PubFun.getCurrentDate()).append("','");
			rs.append(PubFun.getCurrentTime());
			rs.append("','1',(select (case when lac.indueformdate < lss.startdate then 'Y' else 'N' end) from laagentc lac, lastatsegment lss where lss.stattype = '2' and lss.yearmonth = lac.bakmonth and lac.bakmonth = a.wageno and lac.baktype = '1' and lac.agentcode = a.agentcode and a.agentgrade like 'IA0%' union select 'Y' from dual where a.agentgrade like 'IAM%' )");
			rs.append(",(select Basesalary from laagentc where baktype='1' and bakmonth=a.wageno and agentcode=a.agentcode)");
			rs.append(" from lrindexinfo_test a where a.indextype='23' and a.mainindexflag='Y'  and a.branchtype='");
			rs.append(this.mBranchType).append("' and a.wageno='");
			rs.append(mWageNo).append("' and a.managecom like '");
			rs.append(mManageCom).append("%' and a.basecode='");
			rs.append(this.mBaseCode).append("' and a.caltype='02'");
			//exe.execUpdateSQL(rs.toString());
			System.out.println(rs.toString());
			
			//以下字段的值，需要用到考核计算结果，所以需要单独提交
			String update_sql = "update laassessaccessorytrial a"
					+" set AGENTGRADE1=CALAGENTGRADE"
					+",Salary_New=(select basesalary from labasesalarycfg where citytype=(select citytype from ldcom where comcode=a.managecom) and agentgrade=a.CALAGENTGRADE)"
					+" where indexcalno='"+mWageNo
					+"' and assesstype='02' and basecode='"+mBaseCode
					+"' and branchtype='"+mBranchType
					+"' and managecom like '"+mManageCom 
					+"%'"
					;
			//exe.execUpdateSQL(update_sql);
			System.out.println(update_sql);
		}
	    //exe.execUpdateSQL(deluncal);	
		System.out.println(deluncal);
		}catch(Exception e){
		   CError.buildErr(this, "向考核结果表LAAssessAccessoryTrial写数据失败！");
		}
		return mResult;
	}

	public String createView(String baseCode) {
		String sql = "select distinct IndexCode,DataType from LRAssessIndexP where BaseCode='"+ baseCode + "'";
		ExeSQL exe = new ExeSQL();
		SSRS ssrs = exe.execSQL(sql);
		StringBuffer sb = new StringBuffer();
		sb.append("create or replace view " + baseCode + "_Test as ");
		sb.append("select WageNo");
		sb.append(",IndexType");
		sb.append(",BranchType");
		sb.append(",BranchType2");
		sb.append(",BaseCode");
		sb.append(",AgentCode");
		sb.append(",AgentGrade");
		sb.append(",ManageCom");
		sb.append(",BranchAttr");
		// sb.append(",IndexCode");
		// sb.append(",DataType");
		for (int i = 1; i <= ssrs.MaxRow; i++) {
			String tIndexCode = ssrs.GetText(i, 1);
			String tDataType = ssrs.GetText(i, 2);
			if("D".equals(tDataType)){
				//tDataType = "to_char("+tDataType+",'YYYY-MM-DD')";
				tDataType = "Select CONVERT(varchar(100), "+tDataType+", 23)";
			}
			sb.append(",max(case IndexCode when '" + tIndexCode + "' then "
					+ tDataType + " end) " + tIndexCode);
		}
		sb.append(" from LRIndexInfo_Test where BaseCode='").append(baseCode)
				.append("' ");
		sb.append("group by WageNo,IndexType,BranchType,BranchType2,BaseCode,AgentCode,AgentGrade,ManageCom,BranchAttr ");
		return sb.toString();
	}

//	public static void main(String[] args) {
//		GlobalInput tG = new GlobalInput();
//		tG.Operator = "lovehot";
//		tG.ComCode = "2";
//		TransferData transferData = new TransferData();
//		VData tVData = new VData();
//		LAWagePreBL tLAWagePreBL = new LAWagePreBL();
//
//		String tOperate = "calculate";
//		transferData.setNameAndValue("ManageCom", "2");
//		transferData.setNameAndValue("BranchType", "2");
//		transferData.setNameAndValue("BaseCode", "B00001");
//		transferData.setNameAndValue("WageNo", "201407");
//		transferData.setNameAndValue("IndexType", "01");
//		// 开始提交
//		tVData.add(tG);
//		tVData.add(transferData);
//		tLAWagePreBL.submitData(tVData, tOperate);
//		
//	}
}
