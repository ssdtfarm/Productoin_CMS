/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import java.util.Hashtable;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LDUserDB;
import com.sinosoft.lis.schema.LDCodeSchema;
import com.sinosoft.lis.schema.LDUserSchema;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.StrTool;
import com.sinosoft.utility.SysConst;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

/**
 * <p>
 * Title: Web业务系统
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author Minim
 * @version 1.0
 */

public class CodeQueryBL {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();

	/** 往后面传输数据的容器 */
	private VData mInputData;

	/** 往后面传输数据的容器 */
	private VData mResult = new VData();

	/** 数据操作字符串 */
	private String mOperate;

	/** 存储查询语句 */
	private String mSQL = "";

	/**
	 * 国际化标志 true--执行国际化 false--不执行国际化 默认执行国际化
	 */
	private boolean transI18NFlag = true;

	private StringBuffer mSBql = new StringBuffer(256);

	/** 存储全局变量 */
	private GlobalInput mGlobalInput = new GlobalInput();

	/** 存储查询条件 */
	private String mCodeCondition = "";

	private String mConditionField = "";

	/** 业务处理相关变量 */
	private LDCodeSchema mLDCodeSchema = new LDCodeSchema();

	// private LDCodeSet mLDCodeSet = new LDCodeSet();
	private ExeSQL mExeSQL = new ExeSQL();

	/** 返回的数据 */
	private String mResultStr = "";

	// 表示某一个Code是否可以从缓存中取出
	private boolean m_bCanBeCached = false;

	private static Hashtable m_hashResultStr = new Hashtable();

	private static String TOO_LONG_FLAG = "Too long";

	public CodeQueryBL() {
	}

	/**
	 * 传输数据的公共方法, 本处理没有后续的BLS层，故该方法无用
	 * 
	 * @param cInputData
	 *            VData
	 * @param cOperate
	 *            String
	 * @return boolean
	 */
	public boolean submitData(VData cInputData, String cOperate) {
		// 将操作数据拷贝到本类中
		mInputData = (VData) cInputData.clone();
		mOperate = cOperate;

		// 得到外部传入的数据,将数据备份到本类中
		if (!getInputData()) {
			return false;
		}

		// 进行业务处理
		if (!queryData()) {
			return false;
		}

		return true;
	}

	/**
	 * 数据输出方法，供外界获取数据处理结果
	 * 
	 * @return 包含有数据查询结果字符串的VData对象
	 */
	public VData getResult() {
		return mResult;
	}

	/**
	 * 从输入数据中得到所有对象 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
	 * 
	 * @return boolean
	 */
	private boolean getInputData() {
		// 代码查询条件
		try {
			mLDCodeSchema.setSchema((LDCodeSchema) mInputData
					.getObjectByObjectName("LDCodeSchema", 0));
			try {
				mGlobalInput.setSchema((GlobalInput) mInputData
						.getObjectByObjectName("GlobalInput", 0));
			} catch (Exception e) {
				mGlobalInput.ComCode = "";
				mGlobalInput.ManageCom = "";
				mGlobalInput.Operator = "";
			}
			// System.out.println("GGGGGGGGGGGGGGGGG" + mGlobalInput.ManageCom);
			// System.out.println(mGlobalInput.ComCode);
			System.out.println("ManageCom : " + mGlobalInput.ManageCom);
			TransferData tTransferData = (TransferData) mInputData
					.getObjectByObjectName("TransferData", 0);
			// 暂时默认为字符串类型
			// mCodeCondition = "'" +
			// (String)tTransferData.getValueByName("codeCondition") + "'";
			mCodeCondition = (String) tTransferData
					.getValueByName("codeCondition");

			if (mCodeCondition == null) {
				this.m_bCanBeCached = true; // 没有条件列，表示Code所对应的查询语句是固定的，所以可以使用缓存。
			}

			if (mCodeCondition.indexOf('#') == -1) {
				mCodeCondition = "'" + mCodeCondition + "'";
			} else {
				mCodeCondition = mCodeCondition.replace('#', '\'');
			}
			mConditionField = (String) tTransferData
					.getValueByName("conditionField");

			if (mConditionField.equals("")) {
				mCodeCondition = "1";
				mConditionField = "1";
				this.m_bCanBeCached = true; // 没有条件列，表示Code所对应的查询语句是固定的，所以可以使用缓存。
			}
		} catch (Exception e) {
			System.out
					.println("CodeQueryBL throw Errors at getInputData: can not get GlobalInput!");
			mCodeCondition = "1";
			mConditionField = "1";
		}
		return true;
	}

	public void setGlobalInput(GlobalInput cGlobalInput) {
		mGlobalInput.setSchema(cGlobalInput);
	}

	/**
	 * 查询符合条件的保单 输出：如果准备数据时发生错误则返回false,否则返回true
	 * 
	 * @return boolean
	 */
	private boolean queryData() {
		mSQL = "";
		int executeType = 0;

		if (mGlobalInput.ManageCom == null
				|| mGlobalInput.ManageCom.trim().equals("")) {
			mGlobalInput.ManageCom = "2";
		}
		// //////////////////////////////////////工作流升级 added by hufeng
		// 2010-5-21//////////////////////
		// ///////////////start/////////////////
		// 计划流程定制选择业务流程
		if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("busiproxml") == 0) {
			mSQL = "select processid,processname from lwprocessxml   where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by processid";
		}
		//代理人编码 weirn 20150312 cms_hk
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcodenew") == 0) {
			transI18NFlag = false;
			mSQL = "select agentcode,agentName from LAAgentV WHERE 1=1 and dummygradeFlag='N' and ManageCom = '"
					+ mGlobalInput.ManageCom + "' ORDER BY AgentCode ";
			// mSQL =
			// "select agentcode,ISNULL(surname, '')+ISNULL(GivenName, '')+ISNULL(englishname, '') from LAAgent WHERE 1=1 ORDER BY AgentCode ";
		}
		
		//竞赛编码 weirn 20150312 cms_hk
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("contestcode") == 0) {
			transI18NFlag = false;
			mSQL = "select ContestCode,ContestName,ContestStartDate,ContestEndDate,Remarks FROM LAContestConfig WHERE 1=1 AND ManageCom LIKE '"
					+ mGlobalInput.ManageCom + "%' order by ContestCode DESC ";
			// mSQL =
			// "select agentcode,ISNULL(surname, '')+ISNULL(GivenName, '')+ISNULL(englishname, '') from LAAgent WHERE 1=1 ORDER BY AgentCode ";
		}
		
		//竞赛编码 weirn 20150403 cms_hk
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lasubject") == 0) {
			transI18NFlag = false;
			mSQL = "select mainsubjectcode,subjectname,CalCode,(CASE TaxFlag WHEN 'Y' THEN 'TAX' ELSE 'N' END) FROM lasubject ORDER BY mainsubjectcode ";
			// mSQL =
			// "select agentcode,ISNULL(surname, '')+ISNULL(GivenName, '')+ISNULL(englishname, '') from LAAgent WHERE 1=1 ORDER BY AgentCode ";
		}
		// by fengfei 规则引擎-考核试算-基本法
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("baseversion3") == 0) {
			mSBql.append("select basecode,name from lrbase where 1=1  and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" order by makedate desc");
			mSQL = mSBql.toString();
		}

		// by fengfei 薪资管理-薪资计算
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("wageno") == 0) {
			mSBql.append("select b.yearmonth"
					+ bundle.getString("SQLResult")
					+ "' from lastatsegment a, lastatsegment b where a.stattype = '1'");
			mSBql.append(" and b.stattype = a.stattype and a.startdate <= date'"
					+ PubFun.getCurrentDate()
					+ "' and a.enddate >= date'"
					+ PubFun.getCurrentDate() + "'");
			mSBql.append(" and b.startdate >= add_months(a.startdate, -6) and b.startdate <= add_months(a.startdate, 5) order by b.yearmonth");
			mSQL = mSBql.toString();
		}
		// by tianzf CCMS人员姓名是拆分存储的，查询的时候将其合并
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("ccmsagent") == 0) {
			mSQL = "select agentcode,replace(surname||name,' ','') from laagent where "
					+ mConditionField + " = " + mCodeCondition;
		}
		// by gp 组织级别
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("level") == 0) {
			transI18NFlag = false;
			mSQL = "select level,hierarchyname from lagrouplevel where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by level ";
		}
		// by gp f_rejoinagent
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("f_rejoinagent") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
				+ mConditionField + " = " + mCodeCondition
				+" and codetype='f_rejoinagent' order by code ";
		}
		// by gp LastJobIndustry
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lastjobindustry") == 0) {
//					transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
				+ mConditionField + " = " + mCodeCondition
				+" and codetype='lastjobindustry' order by cast(othersign as int) ";
		}
		// by by gp 报表类型
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("reporttypehk") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
					+ mConditionField + " = " + mCodeCondition
					+" and codetype='reporttypehk' order by code ";
		}
		// by zdy 职级等级
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("gradelevelhk_1") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and codetype = 'GradeLevelHK' order by Code ";
		}
		// by zdy Title Level Order职级顺序
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("titlelevelorder_1") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and codetype = 'TitleLevelOrder' order by Code ";
		}		
		// by zdy Production Type
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("producttypehk_1") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and codetype = 'ProductTypeHK' order by Code ";
		}		
		// by zdy 渠道编码对应下拉
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("organisation_1") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and codetype = 'organisation' order by Code ";
		}
		// by zdy 月度财务设置
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("hkplantype_1") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and codetype = 'hkplantype' order by Code ";
		}
		// by zdy 培训管理学历信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("degree_1") == 0) {
			transI18NFlag = false;
			mSQL = "select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)) from ldcode where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and codetype = 'degree' order by Code ";
		}

		// by gp agenttitlecode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("gradecodehk") == 0) {
			transI18NFlag = false;
			mSQL = "select GradeCode,GradeName from laagentgrade where "
					+ mConditionField + " = " + mCodeCondition
					+ " Order By GradeLevel Desc,GradeLevelOrder Desc ";
		}
		
		// by zdy lecturerthk导师编码对应的导师名字
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lecturerthk") == 0) {
			transI18NFlag = false;
			mSQL = "select LecturertCode,LecturertName from Lecturert where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by LecturertCode ";
		}		

		// 代理人编码引用AgentCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode") == 0) {
			ExeSQL tExeSQL = new ExeSQL();
			String agent = tExeSQL
					.getEncodedResult(
							"select Sysvarvalue from ldsysvar where Sysvar = 'LAAgent'",
							1);
			agent = agent.substring(agent.indexOf("^") + 1);

			// mSQL = "select AgentCode, Name, BranchCode from LAAgent where "
			// + mConditionField + " = " + mCodeCondition
			// + " and ManageCom like '" + mGlobalInput.ManageCom +
			// "%' and " +
			// agent + " order by AgentCode";
			mSBql.append("select AgentCode, Name, BranchCode from LAAgent where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and ");
			mSBql.append(agent);
			mSBql.append(" order by AgentCode");

			mSQL = mSBql.toString();

			executeType = 1;
			// mResultStr = mExeSQL.getEncodedResult(mSQL);
		}
		
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("busipro") == 0) {
			mSQL = "select processid,processname from lwprocess   where  "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and not exists (select 1 from lwprocessxml where  "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and lwprocessxml.processid=lwprocess.processid) order by processid";
		}

		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("queryactivityid") == 0) {
			mSQL = "select  a.ActivityID,a.ActivityName from LWActivity a where  "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " Order by a.ActivityID";
			executeType = 1;
		}
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("queryactivityid2") == 0) {
			mSQL = "select  a.ActivityID,a.ActivityName from LWActivity a where 1=1 and BusiType='"
					+ mConditionField + "' Order by a.ActivityID";
			executeType = 1;
		}
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("queryprocessid") == 0) {
			mSQL = "select  a.ProcessID,a.ProcessName from LWProcess a where 1=1 Order by a.ProcessID";
			executeType = 1;
		}
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("queryprocessid2") == 0) {
			mSQL = "select a.ProcessID,a.ProcessName from LWProcess a where "
					+ mConditionField + " = " + mCodeCondition
					+ " and valuedflag='1'";
		}
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("jactivityid") == 0) {
			if (null == this.mConditionField || "".equals(this.mConditionField)
					|| "1".equalsIgnoreCase(this.mConditionField)) {
				mSQL = "select  a.ActivityID,a.ActivityName from LWActivity a where 1=1 ";
				executeType = 1;
			} else {
				mSQL = "select  a.ActivityID,a.ActivityName from LWActivity a where 1=1 and a.ActivityID in (select TransitionStart from LWProcessTrans where ProcessID='"
						+ this.mConditionField
						+ "') and a.ActivityFlag='1' Order by a.ActivityID";
			}

		}
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("queryuser") == 0) {
			mSQL = "select a.UserCode,a.UserName from LDUser a where 1=1 Order by a.UserCode";
		}

		// ////////////////////////////////////////end
		// ////////////////////////////////////////////////////////

		// 报表批处理参数
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("reporttype") == 0) {
			mSQL = "select code,codename from LOReportCode";
		}

		/** 财务收付单证类型 Added by guanwei 2006-04-13 */
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("certifycode1") == 0) {
			mSQL = "select Code,CodeName from LDCode "
					+ " where CodeType = 'certifycode1' and OtherSign = '1'"
					+ " union " + "select Code,CodeName from LDCode"
					+ " where CodeType = 'cardtype' and OtherSign = '1'";
		}

		// added by lyy 外包录入时查询单证类型 2009-9-14
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("cardtype") == 0) {
			mSBql.append("select subtype,subtypename from es_doc_def where busstype='TB' and subtype like 'UA%' and subtype !='UA061' and 1=");
			mSBql.append(mCodeCondition);
			mSBql.append(" order by subtype");
			mSQL = mSBql.toString();

		}
		// added by lyy 外包录入时查询外包商 2009-9-17
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bposerver") == 0) {
			mSBql.append("select bpoid,bponame from bposerverinfo where  1=");
			mSBql.append(mCodeCondition);
			mSBql.append(" and type='BPO'");
			mSQL = mSBql.toString();
		}

		// added by lyy 根据业务员编号查询中介机构
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("mediagentcombyangetcode") == 0) {
			mSBql.append("select a.agentcom,b.name from Lacomtoagent a,lacom b where a.agentcom=b.agentcom and ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();
		}

		// added by hanxl 外包录入时查询外包商 2009年11月3日
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("tpaserver") == 0) {
			mSBql.append("select bpoid,bponame from bposerverinfo where  1=");
			mSBql.append(mCodeCondition);
			mSBql.append(" and type='TPA' and state = '1' ");
			mSQL = mSBql.toString();
		}

		// 根据收费员职级取得佣金项
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("wagecode") == 0) {
			mSQL = "select Wagecode,Wagename from laindexvscomm where "
					+ mConditionField + " = " + mCodeCondition;
		}

		// 根据收费员佣金项取得参数项
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("paracode") == 0) {
			mSQL = "select Paracode,Paraname from lawagevsparam where "
					+ mConditionField + " = " + mCodeCondition;
		}

		// 核保师查询
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("uwper") == 0) {
			mSQL = "select a.usercode,'' from LDUWUser a where 1=1 and "
					+ mConditionField + " = " + mCodeCondition
					+ " order by a.usercode";
		}

		/**
		 * 健康管理相关查询
		 */
		// 查询对应机构下的用户
		// System.out.println("come here queryData" +
		// mLDCodeSchema.getCodeType());
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("usercode") == 0) {
			mSQL = "select  Usercode,Username from LDUser where "
					+ mConditionField + " = " + mCodeCondition;
		}

		// 咨询专家
		else if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("familydoctorno") == 0) {
			mSQL = "select  DoctNo,DoctName from LDDoctor where 1=1 and CExportFlag='1' and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by DoctNo";
		}

		// 咨询专家
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lluwlevel") == 0) {
			mSQL = "select  popedomlevel,popedomname from LLClaimPopedom where popedomlevel like 'A%' or popedomlevel like 'B%' ";
		}

		// 查询对应机构下的核保师
		// System.out.println("come here queryData" +
		// mLDCodeSchema.getCodeType());
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("uwcode") == 0) {
			mSQL = " select Usercode,Username,ComCode from LDUser "
					+ " where Usercode in " +

					" (select usercode from lduwuser) ";

		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("uwcode2") == 0) {
			// mSQL = " select Usercode,Username,ComCode from LDUser " +
			// " where Usercode in " +
			// " (select usercode from lduwuser) and " +
			// mConditionField + "= substr(" + mCodeCondition + ",0,4)";
			mSQL = " select Usercode, Username, ComCode" + " from LDUser"
					+ " where Usercode in (select usercode from lduwuser)"
					+ " and (trim(comcode) = substr(" + mCodeCondition
					+ ", 0, 4) or comcode = '86')";

		}

		/**
		 * 2006-03-29 保障计划险种初始化
		 */
		// System.out.println("CodeType===" + mLDCodeSchema.getCodeType());
		if (mLDCodeSchema.getCodeType().indexOf("*") != -1
				&& mLDCodeSchema.getCodeType().substring(0, 4).equals("****")) {
			String yWay = StrTool.cTrim(mLDCodeSchema.getCodeType()).substring(
					0, 4);
			String ycontno = StrTool.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase()
					.substring(4, mLDCodeSchema.getCodeType().indexOf("&"));
			String yplancode = StrTool.cTrim(mLDCodeSchema.getCodeType())
					.substring(mLDCodeSchema.getCodeType().indexOf("&") + 1,
							mLDCodeSchema.getCodeType().length());
			String yupplancode = StrTool
					.cTrim(mLDCodeSchema.getCodeType())
					.toUpperCase()
					.substring(mLDCodeSchema.getCodeType().indexOf("&") + 1,
							mLDCodeSchema.getCodeType().length());

			if (yWay.compareTo("****") == 0) {
				System.out.println("团险保障计划险种初始化");
				mSQL = "select riskcode,riskname from lmrisk where riskcode in (select riskcode from lccontplanrisk where contplancode='"
						+ yplancode
						+ "' and grpcontno='"
						+ ycontno
						+ "') union select riskcode,riskname from lmrisk where riskcode in (select riskcode from lccontplanrisk where contplancode='"
						+ yupplancode + "' and grpcontno='" + ycontno + "')";
			}
		}

		// /////////////////附加险界面增加的功能 write by yaory////////////////
		if (mLDCodeSchema.getCodeType().indexOf("-") != -1) {
			String yWay = StrTool.cTrim(mLDCodeSchema.getCodeType()).substring(
					0, mLDCodeSchema.getCodeType().indexOf("-"));
			String yriskcode = StrTool
					.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase()
					.substring(mLDCodeSchema.getCodeType().indexOf("-") + 1,
							mLDCodeSchema.getCodeType().length());

			// System.out.println("附加险界面的标志===="+yWay);
			// System.out.println("附加险界面的主险编码===="+yriskcode);
			String yApprisk = yriskcode.substring(0, 2);
			// System.out.println("如果险种前两位是01则是险种组合查询所有01开头的险种=="+yApprisk);
			if (yWay.compareTo("***") == 0 && !yApprisk.equals("01")
					&& !yApprisk.equals("02") && !yApprisk.equals("03"))

			{
				// System.out.println("ok!");
				mSQL = "select relariskcode,b.riskname From lmriskrela a,lmrisk b where a.riskcode='"
						+ yriskcode.toUpperCase()
						+ "' and a.relariskcode=b.riskcode";

				// mSQL =
				// "select a.relariskcode,(SELECT riskname FROM lmrisk WHERE riskcode=a.relariskcode)"
				// +" from lmriskrela a ,lmriskedoritem b WHERE a.riskcode=b.riskcode "
				// +"AND b.edorcode='NS' AND a.relariskcode IN(SELECT riskcode FROM lmriskedoritem WHERE edorcode=b.edorcode )"
				// +" AND a.riskcode='"
				// + yriskcode.toUpperCase()
				// + "'";
			}
			if (yWay.compareTo("***") == 0
					&& (yApprisk.equals("01") || yApprisk.equals("02") || yApprisk
							.equals("03"))) {
				// System.out.println("ok!");
				mSQL = "select riskcode,riskname from lmrisk where riskcode like '"
						+ yApprisk + "%' and riskcode!='" + yriskcode + "'";
			}

			// add by cgn 新增附加险关联关系查询
			if (yWay.compareTo("***n") == 0) {

				mSQL = "SELECT a.relariskcode,(SELECT riskname FROM lmrisk WHERE riskcode=a.relariskcode) from lmriskrela a where a.riskcode='"
						+ yriskcode + "' and a.nsbundling='1'";
			}

			/** 团险附加险显示 */
			if (yWay.toUpperCase().compareTo("GAI") == 0
					&& !yApprisk.equals("01") && !yApprisk.equals("02")
					&& !yApprisk.equals("03"))

			{
				// System.out.println("ok!");
				mSQL = "select relariskcode,b.riskname From lmriskrela a,lmrisk b where a.riskcode='"
						+ yriskcode.toUpperCase()
						+ "' and a.relariskcode=b.riskcode  and a.relacode='01' and a.relariskcode in"
						+ "(select riskcode from lcgrppol where "
						+ mConditionField + "=" + mCodeCondition + ")";
				this.m_bCanBeCached = false;
			}
			if (yWay.toUpperCase().compareTo("GAI") == 0
					&& (yApprisk.equals("01") || yApprisk.equals("02") || yApprisk
							.equals("03"))) {
				mSQL = "select riskcode,riskname from lmrisk where riskcode like '"
						+ yApprisk
						+ "%' and riskcode!='"
						+ yriskcode
						+ "' and riskcode in"
						+ "(select riskcode from lcgrppol where "
						+ mConditionField + "=" + mCodeCondition + ")";
				this.m_bCanBeCached = false;
			}

		}
		// /////////////////卡单险种初始化//////////////////
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("cardriskcode") == 0) {
			// mSQL =
			// "select riskcode,riskname from lmriskapp where poltype='C' and
			// RiskProp<>'G' order by riskcode";
			mSQL = "select riskcode,riskname from lmriskapp where poltype='C' and (enddate is null or enddate >= (select sysdate from dual)) order by riskprop,riskcode";
		}
		// 卡单交费的险种查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("cardriskcodefin") == 0) {
			mSQL = "select riskcode aa,riskname from lmriskapp where poltype='C' and (enddate is null or enddate >= (select sysdate from dual)) "
					+ "union select contplancode aa,contplanname from ldplan "
					+ "where state = '9'  and (trim(managecom) = substr('"
					+ this.mGlobalInput.ManageCom
					+ "',0,2) or  managecom like substr('"
					+ this.mGlobalInput.ManageCom + "',0,4)||'%' ) order by aa";

		}

		// /////////////////套餐险种初始化//////////////////
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("planriskcode") == 0) {
			String tManageCom = this.mGlobalInput.ManageCom;
			// mSQL =
			// "select riskcode,riskname from lmriskapp where poltype='C' and
			// RiskProp<>'G' order by riskcode";
			// 对于分公司可以销售本公司和总公司定义的产品组合
			if (tManageCom.length() >= 4) {
				mSQL = "select contplancode,contplanname from ldplan where state='9' "
						+ "and managecom = '"
						+ tManageCom.substring(0, 4)
						+ "' "
						+ "union "
						+ "select contplancode,contplanname from ldplan where state='9' "
						+ "and managecom = '86' " + "order by contplancode";
			} else {
				mSQL = "select contplancode,contplanname from ldplan where state='9' "
						+ "and managecom like '86%' " + "order by contplancode";
			}
		}

		// /////////////////套餐投保规则计算编码//////////////////
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("planrulefactor") == 0) {
			// mSQL =
			// "select riskcode,riskname from lmriskapp where poltype='C' and
			// RiskProp<>'G' order by riskcode";
			mSQL = "select factorycode,factoryname,calremark,params,factorytype,factorysubcode from lmfactorymode "
					+ "where riskcode='000000' and factorytype='000009'";
		}

		// 可以进行产品组合的险种代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskgrpplan") == 0) {
			/*
			 * mSQL = "select a.RiskCode, a.RiskName,a.SubRiskFlag from
			 * LMRiskApp a,LMRiskSort b where " + mConditionField + " = " +
			 * mCodeCondition + " and RiskProp in ('G','A','B','D')" + " and
			 * b.riskcode=a.riskcode and b.risksorttype='22'" + " order by
			 * RiskCode";
			 */
			// 与团险定义界面
			mSQL = "select distinct a.RiskCode, a.RiskName,a.SubRiskFlag from LMRiskApp a where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ "　and RiskProp in ('G','A','B','D') and poltype='P' and (a.enddate is null or a.enddate >= (select sysdate from dual)) order by RiskCode";
		}

		// add by yanxing 2009-06-11 添加个险套餐定义用
		// 可以进行产品组合的险种代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskperplan") == 0) {
			/*
			 * mSQL = "select a.RiskCode, a.RiskName,a.SubRiskFlag from
			 * LMRiskApp a where " + mConditionField + " =
			 * " + mCodeCondition + " and RiskProp in ('I','A','C','D','Y','B')
			 * and poltype='P' order by RiskCode";
			 */
			mSQL = "select distinct a.RiskCode, a.RiskName,a.SubRiskFlag from LMRiskApp a,lmriskcomctrl b where a.Riskcode=b.Riskcode and sysdate between b.startdate and b.enddate and "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by RiskCode";
		}
		// 审核状态1
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("status1") == 0) {
			mSBql.append("select  code,codename from ldcode where codetype='status' and (code='01' or code='03'or code='05') and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" order by code asc");
			mSQL = mSBql.toString();
		}
		// 审核状态2
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("status2") == 0) {
			mSBql.append("select  code,codename from ldcode where codetype='status' and code='02'  and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" order by code asc");
			mSQL = mSBql.toString();
		}

		// add by yanxing 2009-06-11 添加银代套餐定义用
		// 可以进行产品组合的险种代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskbankplan") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName,a.SubRiskFlag from LMRiskApp a where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ "　and RiskProp in ('Y','B','C','D') and poltype='P' and (a.enddate is null or a.enddate >= (select sysdate from dual)) order by RiskCode";
		}
		// add by yanxing 2009-06-15 个险套餐编码
		// 银行网点和个险套餐匹配
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("perplancode") == 0) {
			mSQL = "select contplancode,contplanname,contplanname from ldplan where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ "　and riskprop = 'I' and state='9' order by contplancode";
		}
		// 查询银行网点和套餐的对应关系
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankcontplan") == 0) {
			mSQL = "select contplancode,(select contplanname from ldplan where ldplan.contplancode = laagentcomtoplan.contplancode) from laagentcomtoplan where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by contplancode";
		}

		// add by wuzongmei 个险套餐添加险种时险种选择
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("contplanriskcode") == 0) {
			mSBql.append("select a.riskcode,(select riskname from lmriskapp where riskcode=a.riskcode) from ldplanrisk a where exists(select * from lmriskrela where riskcode=a.riskcode) and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();
		}

		// add by lhl 远程出单套餐添加险种时险种选择
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("ycriskcode") == 0) {
			mSBql.append("select a.riskcode,(select riskname from lmriskapp where riskcode=a.riskcode) from ldplanrisk a where  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();
		}

		// add by wuzongmei 下拉选择协议银行
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankcontrast") == 0) {
			String tPolmng = mGlobalInput.ComCode;
			// if(tPolmng.length() <= 4)
			// tPolmng += "00";
			// edit by sunhongyan 2010-05-18 下拉选择协议银行修改
			int nLength = tPolmng.length();
			for (int x = 0; x < (6 - nLength); x++) {
				tPolmng = tPolmng + "0";
			}
			mSBql.append("Select distinct a.inbankcode,c.bankname From Ldprobankacc a, Ldbank c Where a.Inbankcode = c.Bankcode and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and  Substr(c.comcode, 1, 6) = Substr('");
			mSBql.append(tPolmng);
			mSBql.append("', 1, 6) order by a.inbankcode");
			mSQL = mSBql.toString();
		}

		// add by wuzongmei 下拉选择协议银行账户
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankcontrastno") == 0) {
			String tPolmng = mGlobalInput.ComCode;
			// if(tPolmng.length() <= 4)
			// tPolmng += "00";
			// edit by sunhongyan 2010-05-18 下拉选择协议银行修改
			int nLength = tPolmng.length();
			for (int x = 0; x < (6 - nLength); x++) {
				tPolmng = tPolmng + "0";
			}
			mSBql.append("Select a.inbankaccno,'' From Ldprobankacc a, Ldbank c Where a.Inbankcode = c.Bankcode and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and c.comcode = Substr('");
			mSBql.append(tPolmng);
			mSBql.append("', 1, 6) ");
			mSQL = mSBql.toString();
		}

		// add by wuzongmei 到账确认时选择协议银行
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankcontrastconfirm") == 0) {
			String ConditionField[] = PubFun.split(mConditionField, "|");
			String CodeCondition[] = PubFun.split(mCodeCondition, "|");
			mSBql.append("Select a.Inbankcode, a.Inbankaccno, a.Inaccname, a.Oacccomcode From Ldprobankacc a, Ldbank c Where a.Inbankcode = c.Bankcode and a.acctype='1' and c.bankacctype='2' and ");
			mSBql.append(ConditionField[0]);
			mSBql.append(" = ");
			mSBql.append(CodeCondition[0]);
			// mSBql.append("' And ");
			// mSBql.append(ConditionField[1]);
			// mSBql.append(" = '");
			// mSBql.append(CodeCondition[1]);
			// mSBql.append("' And ");
			// mSBql.append(ConditionField[2]);
			// mSBql.append(" = '");
			// mSBql.append(CodeCondition[2]);
			mSQL = mSBql.toString();
		}

		// 保险套餐RiskPlan
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskplan") == 0) {
			mSQL = "select ContPlanCode,ContPlanName from LDPlan"
					+ " where managecom like '" + mGlobalInput.ManageCom
					+ "%' and state='9' order by ContPlanCode";
		}

		// 产品组合定义销售渠道
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("plansalechnl") == 0) {
			mSQL = "select code,codename from ldcode where codetype='plansalechnl'";
		}

		// 产品组合保险期间单位
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("insuyearflag") == 0) {
			mSQL = "select code,codename from ldcode where codetype='insuyearflag' order by code";
		}

		// 产品组合状态
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("planstate") == 0) {
			mSQL = "select code,codename from ldcode where codetype='planstate'"
					+ " order by length(code)";
		}

		// /////////////////团险界面增加的功能 write by yaory////////////////
		if (mLDCodeSchema.getCodeType().indexOf("-") != -1) {
			String yWay = StrTool.cTrim(mLDCodeSchema.getCodeType()).substring(
					0, mLDCodeSchema.getCodeType().indexOf("-"));
			String ycontno = StrTool
					.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase()
					.substring(mLDCodeSchema.getCodeType().indexOf("-") + 1,
							mLDCodeSchema.getCodeType().length());

			// System.out.println("附加险界面的标志====" + yWay);
			// System.out.println("合同号====" + ycontno);
			if (yWay.compareTo("**") == 0) {
				// System.out.println("ok!");
				mSQL = "select riskcode,riskname from lmrisk where riskcode in (select riskcode from lcgrppol where prtno='"
						+ ycontno + "')";
			}
		}

		if (mLDCodeSchema.getCodeType().indexOf("-") != -1
				&& mLDCodeSchema.getCodeType().indexOf("*") != -1
				&& mLDCodeSchema.getCodeType().indexOf("&") != -1) {
			// /////////////////险种界面定义 write by yaory
			// System.out.println("哈哈:"+StrTool.cTrim(mLDCodeSchema.getCodeType()).substring(0,mLDCodeSchema.getCodeType().indexOf("-")));
			// /////险种参数名-payintv;payendyear等///////////
			String yWay = StrTool.cTrim(mLDCodeSchema.getCodeType()).substring(
					0, mLDCodeSchema.getCodeType().indexOf("-"));
			// ////险种编码////////////
			String yRiskcode = StrTool
					.cTrim(mLDCodeSchema.getCodeType())
					.toUpperCase()
					.substring(mLDCodeSchema.getCodeType().indexOf("-") + 1,
							mLDCodeSchema.getCodeType().indexOf("*"));
			// ///责任代码//////
			String yDutycode = StrTool
					.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase()
					.substring(mLDCodeSchema.getCodeType().indexOf("*") + 1,
							mLDCodeSchema.getCodeType().indexOf("&"));
			// System.out.println("yDutycode==="+yDutycode);
			// ////其他编码////////
			String yOthercode = StrTool
					.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase()
					.substring(mLDCodeSchema.getCodeType().indexOf("&") + 1,
							mLDCodeSchema.getCodeType().length());
			// System.out.println(Othercode==="+yOthercode);
			// ////标记-如果是“！”则是这个分支///////
			String yRemark = StrTool.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase().substring(0, 1);

			if (yRemark.compareTo("!") == 0) {
				mSQL = "select ParamsCode,ParamsName from LMRiskParamsDef where riskcode='"
						+ yRiskcode
						+ "' and ParamsType='"
						+ yWay.substring(1, yWay.length()) + "'";
				if (!yDutycode.equals("0")) {
					mSQL = mSQL + " and DutyCode='" + yDutycode + "'";
				}
				if (!yOthercode.equals("0")) {
					mSQL = mSQL + " and OtherCode='" + yOthercode + "'";
				}
				mSQL = mSQL + " order by length(ParamsCode),ParamsCode ASC";
			}
		}
		// 险种参数查询
		if (mLDCodeSchema.getCodeType().indexOf("-") != -1
				&& mLDCodeSchema.getCodeType().indexOf("*") != -1
				&& mLDCodeSchema.getCodeType().indexOf("#") != -1) {
			String SCodeType = StrTool.cTrim(mLDCodeSchema.getCodeType());
			// /////险种参数名-payintv;payendyear等///////////
			String yWay = SCodeType.substring(0, SCodeType.indexOf("-"));
			// ////险种编码////////////
			String yRiskcode = SCodeType.substring(SCodeType.indexOf("-") + 1,
					SCodeType.indexOf("*"));
			// ///责任代码//////
			String yDutycode = SCodeType.substring(SCodeType.indexOf("*") + 1,
					SCodeType.indexOf("#"));
			// ////其他编码////////
			String yOthercode = SCodeType.substring(SCodeType.indexOf("#") + 1,
					SCodeType.length());
			// ////标记-如果是“！”则是这个分支///////
			String yRemark = SCodeType.substring(0, 1);

			if (yRemark.compareTo("!") == 0) {
				mSQL = "select ParamsCode,ParamsName from LMRiskParamsDef "
						+ " where riskcode='" + yRiskcode + "' "
						+ " and ParamsType='"
						+ yWay.substring(1, yWay.length()) + "'";
				if (!yDutycode.equals("0")) {
					mSQL = mSQL + " and DutyCode='" + yDutycode + "'";
				}
				if (!yOthercode.equals("0")) {
					mSQL = mSQL + " and OtherCode='" + yOthercode + "'";
				}
			}
		}

		// 投联账户类型查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("insuacc") == 0) {
			mSQL = "select InsuAccNo, InsuAccName from LMRiskInsuAcc where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by InsuAccNo asc";
		}

		// 认证级别
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("ldattestleve") == 0) {
			mSQL = "select  AttestLevelCode,AttestLevel from LDAttestLeve where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by AttestLevelCode";
		}
		// 卫生机构类别查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("ldhealthorganclass") == 0) {
			mSQL = "select  HealthOrganClass,HealthOrganClassName from LDHealthOrganClass where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by HealthOrganClass";
		}
		// 单位隶属关系查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("ldorganisubjec") == 0) {
			mSQL = "select  SubjecCode,SubjecName from LDOrganiSubjec where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by SubjecCode";
		}
		// 业务类型代码查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("ldbusitype") == 0) {
			mSQL = "select  BusiTypeCode,BusiType from LDBusiType where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by BusiTypeCode";
		}

		/** *******************理赔相关查询*************************************** */
		// 理赔要约录入计算要素查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("clmfactorycode") == 0) {
			mSQL = "select a.factorycode,a.factoryname "
					+ "from lmfactorymode a where a.factorytype = '000004' "
					+ "and riskcode = '" + mConditionField + "'"
					+ " order by factorycode";
			executeType = 1;
		}

		// 理赔要约录入子计算要素查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("clmimpartcode") == 0) {
			mSQL = "select a.factorysubcode,a.calremark,CreateDH(a.paramsnum),FactorySubName "
					+ "from lmfactorymode a where a.factorytype = '000004' "
					+ " and riskcode = "
					+ mConditionField
					+ " = "
					+ mCodeCondition + " order by factorysubcode";
			executeType = 1;
		}

		// 单证的类型查询，es_doc_def表，2005-09-13,zw
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("busstypedetail") == 0) {
			mSQL = "select distinct busstype , busstypename from es_doc_def ";
			executeType = 1;
		}

		// 单证的具体类型查询，es_doc_def表，2005-09-13,zw
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("subtypedetail") == 0) {
			mSQL = "select SubType,SubTypeName from es_doc_def where 1=1 and "
					+ mConditionField + " = " + mCodeCondition.trim()
					+ " order by SubType";
			executeType = 1;
		}

		// 出险结果1查询,icd10表,2005-6-21,zl
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lldiseases1") == 0) {
			if (mConditionField.equals("1")) { // 意外
				mSQL = "select ICDCode,ICDName from LDDisease where "
						+ " icdlevel = 0 and ASCII(icdcode) < 86"
						+ " and ASCII(icdcode) > 82" + " order by ICDCode";
				executeType = 1;
			}
			if (mConditionField.equals("2")) { // 疾病
				mSQL = "select ICDCode,ICDName from LDDisease where "
						+ " icdlevel = 0 and (ASCII(icdcode) < 83 or ASCII(icdcode)=90 )"
						+ " order by ICDCode";
				executeType = 1;
			}
		}

		// 出险结果2查询,icd10表,2005-6-21,zl
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lldiseases2") == 0) {
			mSQL = "select  ICDCode,ICDName from LDDisease where "
					+ " icdlevel = 1 and ASCII(icdcode) <= 90 and trim("
					+ mConditionField + ") = " + mCodeCondition.trim()
					+ " order by ICDCode";
			executeType = 1;
		}

		// 出险细节查询,icd10表中V01-Z99,2005-6-21,zl
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llaccidentdetail") == 0) {
			mSQL = "select  ICDCode,ICDName from LDDisease where "
					+ " icdlevel <= 1 and ASCII(icdcode) >= 86"
					+ " order by ICDCode";
			executeType = 1;
		}

		// 医疗单证录入中推荐医院查询,2005-6-22,zl “order by hospitalcode desc”
		// ZHaoRx，2005-12-23添加
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("commendhospital") == 0) {
			mSQL = "select HospitalCode,HospitalName from LLCommendHospital order by hospitalcode desc ";
			executeType = 1;
		}

		// 医疗单证录入中伤残代码查询,2005-7-04,zl
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lldefocode") == 0) {
			mSQL = "select defocode,defoname from LLParaDeformity where 1=1 "
					+ "and DefoType = " + mCodeCondition.trim()
					+ "and defograde = '" + mConditionField.trim() + "'"
					+ " order by defocode";
			executeType = 1;
		}

		// 医疗单证录入中伤残级别查询,2005-7-07,zl Modify by zhaorx 2006-09-13
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lldefograde") == 0) {
			mSQL = "select distinct defograde,defogradename from LLParaDeformity where "
					+ mConditionField
					+ " = "
					+ mCodeCondition.trim()
					+ " order by to_number(defograde)";
			executeType = 1;
		}

		// 津贴类型查询 add by lvliye 20090813
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llallowtype") == 0) {
			mSQL = "select distinct allowtype,allowname from LLParaAllowance  "
					+ " order by allowtype";
			executeType = 1;
		}

		// 津贴类型明细查询 add by lvliye 20090813
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llallowitemcode") == 0) {
			mSQL = "select distinct AllowItemCode,AllowItemName from LLParaAllowance where "
					+ mConditionField
					+ " = "
					+ mCodeCondition.trim()
					+ " order by AllowItemCode";
			executeType = 1;
		}

		// 出险疾病查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lldiseas") == 0) {
			mSQL = "select  ICDName,ICDCode from LDDisease where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField
					+ " like '%"
					+ mCodeCondition
							.substring(1, (mCodeCondition.length() - 1)).trim()
					+ "%' order by ICDName";
			executeType = 1;
		}

		// 理赔材料名称
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llmaffix") == 0) {
			mSQL = "select  affixcode,affixname from llmaffix where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField + " = " + mCodeCondition
					+ " order by affixcode";
			executeType = 1;
		}

		// 理赔材料类型
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llmaffixtype") == 0) {
			mSQL = "select distinct affixtypecode,affixtypename from llmaffix where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by affixtypecode";
			executeType = 1;
		}

		// 理赔保单查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llclaimpolicy") == 0) {
			mSQL = "select a.contno,'' from llcasepolicy a where 1=1 and "
					// + " and a.caseno='" + mCodeCondition +"'"
					+ mConditionField + " = " + mCodeCondition
					+ " order by a.contno";
			executeType = 1;
		}

		// 查询理赔权限表中(llclaimuser)某机构及其下级机构中具有调查权限(surveyflag='1')的用户
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llclaimuser") == 0) {

			mSQL = "select usercode,username from llclaimuser where "
					+ " surveyflag='1' and " + mConditionField + " like "
					+ mCodeCondition.trim() + " order by userCode";
			executeType = 1;
		}

		// 查询理赔师权限表中(LLClaimPopedom)的理赔权限级别
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("popedomlevel") == 0) {
			mSQL = "select popedomlevel,popedomlevel from llclaimpopedom where "
					+ mConditionField
					+ " like "
					+ mCodeCondition.trim()
					+ "  group by popedomlevel";
			executeType = 1;
		}

		// （理赔）业务员品质管理-业务员品质录入-建议等级区分 zhaorx 2006-03-08
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("laagqualitysubr") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'laagqualitysub' and code "
					+ " in ('101','102','199') order by code ";
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("laagqualitysubu") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'laagqualitysub' and code "
					+ " in ('201') order by code ";
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("laagqualitysubbl") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'laagqualitysub' and code "
					+ " in ('301','302','303','304','305','306','307','308','309','399') order by code ";
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("laagqualitysubb") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'laagqualitysub' and code "
					+ " in ('401','402','403','404','405','406','407','408','409','499') order by code ";
		}

		// 险种查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llclaimrisk") == 0) {
			mSQL = "select distinct a.riskcode,a.riskname from LMRisk a where 1=1 and "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by a.riskcode";
		}
		// 续收团队查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("renewgroup") == 0) {
			mSQL = "select distinct branchattr,name from labranchgroup where branchtype='4' and "
					+ " managecom like '"
					+ mGlobalInput.ManageCom
					+ "%' and "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by branchattr";
		}

		// 责任给付类别
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llgetdutykind") == 0) {
			mSQL = "select distinct a.GetDutyKind,b.codeName from LMDutyGetClm a , ldcode b where getdutycode in (select getdutycode from lmdutygetrela where dutycode in (select dutycode from lmriskduty where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " )) and b.codetype='getdutykind' and code=a.getdutykind order by getdutykind";
		}

		// 给付类型
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llclaimdecision_1") == 0) {
			mSQL = "select a.Code, a.CodeName, a.CodeAlias, a.ComCode, a.OtherSign from ldcode a where  trim(a.codetype)=(select trim(bcodeaLias) from ldcode b where b.codetype='llclaimdecision' and b.code="
					+ mCodeCondition + ")";
		}

		// 手术
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lloperation") == 0) {
			mSQL = "select ICDOPSName, ICDOPSCode, OpsGrag from LDICDOPS order by ICDOPSCode";
		}

		// 赔案阶段
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("activityid") == 0) {
			mSQL = "select activityid,activityname from lwactivity where activityid like '00000050%' ";
			executeType = 1;
		}

		// 其它录入要素类型
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llfactor") == 0) {
			mSQL = "select a.codename, a.code from ldcode a where a.codetype =( select CODEALIAS from ldcode where codetype='llotherfactor' and code="
					+ mCodeCondition + ") order by a.code";
		}

		// 核保师编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("uwusercode") == 0) {
			mSQL = "select UserCode, trim(UserName) from LDUser order by UserCode";
		}

		// 团单客户编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("supcustomerno") == 0) {
			mSQL = "select CustomerNo, trim(GrpName) from  LDGrp order by CustomerNo";
		}

		// 健康险要素目标编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("healthfactoryno") == 0) {

			if (mCodeCondition.substring(1, 7).equals("000000")) { // 基于保单的计算
				mSQL = "select '__','" + bundle.getString("SQLResult")
						+ "' from dual";
			} else if (mCodeCondition.substring(1, 7).equals("000001")) { // 基于保单的计算
				mSQL = "select DutyCode,DutyName from LMDuty where DutyCode in(select DutyCode from LMRiskDuty "
						+ " where RiskCode='"
						+ mCodeCondition.substring(7)
						+ ") order by DutyCode";
			} else if (mCodeCondition.substring(1, 7).equals("000002")) { // 基于给付的计算
				mSQL = "select getdutycode,getdutyname from lmdutygetrela where dutycode in (select dutycode from lmriskduty where riskcode ='"
						+ mCodeCondition.substring(7)
						+ ") order by getdutycode";
			} else if (mCodeCondition.substring(1, 7).equals("000003")) { // 基于账户的计算
				mSQL = "select insuaccno,insuaccname from LMRiskToAcc where RiskCode='"
						+ mCodeCondition.substring(7) + " order by insuaccno";
			} else if (mCodeCondition.substring(1, 7).equals("000004")) { // 基于理赔责任的计算
				mSQL = "select getdutycode,getdutyname from lmdutygetrela where dutycode in (select dutycode from lmriskduty where riskcode ='"
						+ mCodeCondition.substring(7)
						+ ") order by getdutycode";
			}
		}

		// 疾病代码查询ICDCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("icdcode") == 0) {
			mSQL = "select a.icdcode, a.icdname from  lddisease a where "
					+ mConditionField
					+ " like '%"
					+ mCodeCondition
							.substring(1, (mCodeCondition.length() - 1)).trim()
					+ "%' order by a.icdcode";
			executeType = 1;
		}

		// 体检项目结果查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("itemresult") == 0) {
			String code = "";
			System.out.println(mCodeCondition.trim());
			if (mCodeCondition.trim().equals("'011'")
					|| mCodeCondition.trim().equals("'012'")
					|| mCodeCondition.trim().equals("'013'")) {
				code = "peitemc";
			} else if (mCodeCondition.trim().equals("'060'")) {
				code = "peitemb";
			} else {
				code = "peitema";
			}
			mSQL = "select code,codename from ldcode where codetype = '" + code
					+ "'";
			executeType = 1;
		}

		// 其他险种信息参数查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("queryriskother") == 0) {
			System.out.println(mCodeCondition.trim());
			mSQL = "select code,codename from ldcode where codetype = "
					+ mCodeCondition.trim().toLowerCase();
			executeType = 1;
		}

		// 疾病代码查询ICDCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("diseascode") == 0) {
			mSQL = "select icdcode, icdname from lddisease order by a.icdcode";
			executeType = 1;
		}

		// 疾病代码查询ICDCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("diseasname") == 0) {
			mSQL = "select icdname,icdcode from lddisease order by icdname";
			executeType = 1;
		}

		// 疾病代码查询ICDCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("hospital") == 0) {
			mSQL = "select a.hospitcode,a.hospitname,b.codename from  LDHospital a ,ldcode b where b.codetype='llhospiflag' and b.code=a.fixflag order by a.hospitcode";
			executeType = 1;
		}

		// 意外代码查询ICDCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llacci") == 0) {
			mSQL = "select a.accidentno, a.accname from  llaccidenttype a where "
					+ mConditionField
					+ " like '%"
					+ mCodeCondition
							.substring(1, (mCodeCondition.length() - 1)).trim()
					+ "%' order by a.accidentno";
			executeType = 1;
		}

		// 医生代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("doctor") == 0) {
			mSQL = "select a.doctname,a.doctno from  lddoctor a where  "
					+ mConditionField + " = " + mCodeCondition
					+ " order by a.doctname";
		}

		// 健康险计算要素编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("healthfactory") == 0) {
			mSQL = "select FactoryCode||to_char(FactorySubCode),CalRemark,Params from LMFactoryMode where FactoryType = '"
					+ mCodeCondition.substring(1, 7)
					+ "' and RiskCode='"
					+ mCodeCondition.substring(7)
					+ " order by FactoryCode,FactorySubCode ";
		}

		// 保监会Excel表数据信息导入配置模板相对文件名
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("circreport_config") == 0) {
			mSQL = "select code,codeName,codealias from ldcode where codetype='circreport_config' order by code";
		}

		// 保监会管理机构信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("itemcode") == 0) {
			mSQL = "select itemcode,trim(ItemName) from lfItemRela order by itemcode";
			executeType = 1;
		}
		// 保监会管理机构信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("outitemcode") == 0) {
			mSQL = "select outitemcode,trim(ItemName) from lfItemRela order by outitemcode";
			executeType = 1;
		}
		// ffffffffffffffffffffffffffeeeeeeeeeeeeeeeeeeeeeeeeeeeiiiiiiiiiiiiiii
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("stati") == 0
				|| StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
						.compareTo("allstation") == 0) {
			if (mCodeCondition.toLowerCase().indexOf("comcode") == -1) {
				mCodeCondition = mCodeCondition.toLowerCase().replaceAll(
						"code", "comcode");
			}
			mSQL = "select comcode,name from ldcom where " + mConditionField
					+ " = " + mCodeCondition + " order by comcode";

			m_bCanBeCached = false;
			executeType = 1;
		}

		// 除去86以外，本级和本级以下的管理机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecomex") == 0) {
			mSQL = "select comcode,name from ldcom where 1=1 "
					+ " and comcode like '" + mGlobalInput.ManageCom
					+ "%'  and length(comcode)<=4 order by comcode";
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("optname") == 0) {
			mSQL = "select username,usercode,claimpopedom from llclaimuser where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by claimpopedom desc";
		}

		// 本级以及本级以下的管理机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecom1") == 0) {
			mSQL = "select comcode,name from ldcom where 1=1 "
					+ " and comcode like '" + mGlobalInput.ManageCom
					+ "%' order by comcode";
			executeType = 1;
		}

		// 保监会管理机构信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comcodeisc") == 0) {
			mSQL = "select comcodeisc,trim(name) from LFComISC order by comcodeisc";
			executeType = 1;
		}

		// 保单状态导致原因PolState
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("polstate2") == 0) {
			mSQL = "select code,codename,codealias from ldcode where codetype = 'polstate' order by code";
		}

		// 保单状态导致原因PolStateReason
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("polstatereason") == 0) {
			mSQL = "select code,codename,codealias from ldcode where "
					+ mConditionField + " = " + mCodeCondition
					+ " and codetype = 'polstatereason' order by code";
		}

		// 责任领取类型DutyKind
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("dutykind") == 0) {
			mSQL = "select GetDutyKind, GetDutyName from LMDutyGetAlive where "
					+ mConditionField + " = " + mCodeCondition
					// + " and GetDutyCode in ( select GetDutyCode from
					// LMDutyGetRela where dutycode in "
					// + " ( select dutycode from LMRiskDuty where
					// riskcode='212401' ) ) "
					+ " order by GetDutyKind";
		}

		// <!-- XinYQ added on 2006-04-06 : 保全项目下拉代码 : BGN -->

		// 所有保全项目: EdorType
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("edortype") == 0) {
			mSQL = "select distinct a.EdorCode, b.EdorName "
					+ "from LMRiskEdoritem a,LMEdorItem b "
					+ "where a.edorcode=b.edorcode and " + mConditionField
					+ " = " + mCodeCondition + " " + "order by EdorCode asc";

		}

		// 个险保全项目: PEdorType
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("pedortype") == 0) {
			mSQL = "select distinct a.EdorCode, b.EdorName "
					+ "from LMRiskEdoritem a,LMEdorItem b "
					+ "where a.edorcode=b.edorcode and " + mConditionField
					+ " = " + mCodeCondition + " " + "and AppObj in ('I','B') "
					+ "order by EdorCode asc";
		}

		// 团险保全项目: GEdorType
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("gedortype") == 0) {
			mSQL = "select distinct a.EdorCode, b.EdorName "
					+ "from LMRiskEdoritem a,LMEdorItem b "
					+ "where a.edorcode=b.edorcode and " + mConditionField
					+ " = " + mCodeCondition + " " + "and AppObj = 'G' "
					+ "order by EdorCode asc";
		}

		// <!-- XinYQ added on 2006-04-06 : 保全项目下拉代码 : END -->

		// 查询各管理机构中对应的操作人
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("printoperator") == 0) {
			mSQL = "select distinct a.usercode,a.username from lduser a right join ldedoruser b "
					+ " on a.usercode = b.usercode where "
					+ mConditionField
					+ " = " + mCodeCondition + " order by usercode";
		}

		// 操作岗位OperateType
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("operatetype") == 0) {
			mSQL = "select distinct OperateType,Remark from LDRiskComOperate where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by OperateType";
		}

		// 核保上报级别UWPopedomCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("uwpopedomcode") == 0) {
			mSQL = "select usercode, username from lduser where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by usercode";
		}

		// 核保上报级别UWPopedomCode1
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("uwpopedomcode1") == 0) {
			mSQL = "select usercode, username from lduser where usercode = (select UpUserCode from LDUWUser where usercode = '"
					+ mGlobalInput.Operator.trim() + "') order by usercode";
		}

		// 银行分行渠道channel
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("channel") == 0) {
			mSQL = "select agentcom,name from lacom where " + mConditionField
					+ " = " + mCodeCondition
					+ "and  banktype ='01' order by agentcom";
		}

		// 工种代码引用StaticGroup
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("staticgroup") == 0) {
			// mSQL = "select comcode,shortname from ldcom where "
			// + mConditionField + " = " + mCodeCondition
			// + "and comcode like '"
			// + mGlobalInput.ManageCom +
			// "%' union select branchattr,name from labranchgroup where
			// ManageCom like '"
			// + mGlobalInput.ManageCom +
			// "%' and branchlevel='03' and branchtype='1'";
			mSBql.append("select comcode,shortname from ldcom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comcode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' union select branchattr,name from labranchgroup where ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and branchlevel='03' and branchtype='1'");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 工种代码引用Depart
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("depart") == 0) {
			// mSQL = "select branchattr,name from labranchgroup where "
			// + mConditionField + " = " + mCodeCondition
			// + " and ManageCom like '"
			// + mGlobalInput.ManageCom +
			// "%'and branchlevel>='02' and branchtype='1' order by branchattr";
			mSBql.append("select branchattr,name from labranchgroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'and branchlevel>='02' and branchtype='1' order by branchattr");

			mSQL = mSBql.toString();
			executeType = 1;
		}

		// 工种代码引用Occupation
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("occupation") == 0) {
			mSQL = "select code,codename from ldcode where " + mConditionField
					+ " = " + mCodeCondition + " and codetype='occupation'";
		}

		// 引用BranchAttr
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("branchattr") == 0) {
			// mSQL = "select BranchAttr, Name from LABranchGroup where "
			// + mConditionField + " = " + mCodeCondition
			// + " and ManageCom like '"
			// + mGlobalInput.ManageCom + "%' order by BranchAttr";
			mSBql.append("select BranchAttr, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by BranchAttr");

			mSQL = mSBql.toString();
		}
		// 服务机构 by yusen
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zipbranch") == 0) {
			mSBql.append("select branchattr, name, branchmanagername from labranchgroup where ");
			// mSBql.append(mConditionField);
			// mSBql.append(" = ");
			// mSBql.append(mCodeCondition);
			mSBql.append("ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and branchtype = '1' and EndFlag = 'N'");

			mSQL = mSBql.toString();
			executeType = 1;
		}

		// 服务机构 by cuiwei 20060301
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zipbankbranch") == 0) {
			mSBql.append("select branchattr, name, branchmanagername from labranchgroup where ");
			// mSBql.append(mConditionField);
			// mSBql.append(" = ");
			// mSBql.append(mCodeCondition);
			mSBql.append("ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and branchtype = '3' and EndFlag = 'N'");

			mSQL = mSBql.toString();
			executeType = 1;
		}

		// 代理人组别引用BranchCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("branchcode") == 0) {
			mSQL = "select BranchAttr, name from labranchgroup where "
					+ mConditionField + " = " + mCodeCondition
					+ " and ManageCom like '" + mGlobalInput.ManageCom
					+ "%' order by branchattr";
			executeType = 1;
		}

		// 税率细分项名称引用SerialName
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("serialname") == 0) {
			// mSQL = "SELECT ROWNUM,serialname FROM lataxtemp where "
			// + mConditionField + " = " + mCodeCondition;
			mSQL = "SELECT ROWNUM,N.SERIALNAME FROM (SELECT DISTINCT SERIALNAME FROM LATAXTEMP WHERE "
					+ mConditionField + " = " + mCodeCondition + ") N";
			executeType = 1;
		}

		// 代理人组别引用BranchCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("tollbranch") == 0) {
			mSQL = "select BranchAttr,name,AgentGroup,managecom from labranchgroup where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and endflag = 'N' order by branchattr";
			executeType = 1;
		}

		// //业务员兼职收费员的代码选择
		// if
		// (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "tollbranch2") == 0)
		// {
		// mSQL =
		// "select BranchAttr,name,AgentGroup,ManageCom from labranchgroup where
		// "
		// + mConditionField + " = " + mCodeCondition
		// + " branchtype = '4' and branchlevel = '61' and ManageCom like '"
		// + mGlobalInput.ManageCom +
		// "%' and endflag = 'N' order by branchattr";
		// executeType = 1;
		// }
		// 代理人组别引用BranchCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("allbranch") == 0) {
			// mSQL = "select comcode,name rom ldcom where "
			// + mConditionField + " = " + mCodeCondition
			// + "and comcode like '" + mGlobalInput.ManageCom + "%' union
			// select branchattr,name from labranchgroup where branchtype='1'
			// and (branchlevel='03' or branchlevel='02') and managecom like '"
			// +
			// mGlobalInput.ManageCom +
			// "%' and (state<>1 or state is null) order by comcode";

			mSBql.append("select comcode,name from ldcom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("and comcode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' union select branchattr,nae from labranchgroup where branchtype='1' and (branchlevel='03' or branchlevel='02') and managecom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and (state<>1 or state is null) order by comcode");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 员工属性引用BranchCodeType
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("branchcodetype") == 0) {
			mSQL = "select gradecode, gradename from laagentgrade where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and branchtype='1' and gradeproperty6='1' order by gradecode";
		}

		// 代理人组别引用HealthCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("healthcode") == 0) {
			mSQL = "select distinct HealthCode, HealthName from LDHealth where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by HealthCode";
		}

		// 个险契调引用RReportCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("rreportcode1") == 0) {
			mSQL = "select rreportcode, RReportName from LDRReport where "
					+ mConditionField + " = " + mCodeCondition
					+ " and rreportclass = '1' order by rreportcode";
		}

		// 团险契调引用RReportCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("rreportcode2") == 0) {
			mSQL = "select rreportcode, RReportName from LDRReport where "
					+ mConditionField + " = " + mCodeCondition
					+ " and rreportclass = '2' order by rreportcode";
		}

		// 代理人组别引用AgentGroup
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentgroup") == 0) {
			// mSQL = "select AgentGroup, Name from LABranchGroup where "
			// + mConditionField + " = " + mCodeCondition
			// + " and BranchLevel = '01' and ManageCom like '"
			// + mGlobalInput.ManageCom + "%' order by AgentGroup";

			mSBql.append("select AgentGroup, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and BranchLevel = '01' and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentGroup");

			mSQL = mSBql.toString();
		}

		/**
		 * begin lishuai 2010-11-17 学历下拉排序 end
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("degree") == 0) {
			mSBql.append("select Code, CodeName from ldcode where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype='degree' order by code ");
			mSQL = mSBql.toString();
		}

		/**
		 * begin lishuai 2010-11-05 团险职级调整 团险团队查询 end
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("txagentgroup") == 0) {
			mSBql.append("select BranchAttr, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentGroup");

			mSQL = mSBql.toString();
		}
		/**
		 * begin lishuai 2010-08-26 根据职级查询电销团队 电销人员架构 end
		 */
		// 电销架构人组别引用AgentGroup
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentgroupdx") == 0) {
			mSBql.append("select BranchAttr, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype='5'   and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentGroup");

			mSQL = mSBql.toString();
		}

		// 团体代理人组别引用AgentGroup
		// by niuzj,2006-07-18
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("grpagentgroup") == 0) {

			mSBql.append("select AgentGroup, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and BranchLevel = '11' and branchtype='2' and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentGroup");

			mSQL = mSBql.toString();
		}
		// 续收销售团队
		// add by wanglm
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("xqagentgroup") == 0) {

			mSBql.append("select branchattr, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'and Endflag='N' and branchtype!='7'");
			mSBql.append(" order by Branchattr");

			mSQL = mSBql.toString();
		}

		// 银代销售团队
		// add by chenlh
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bkagentgroup") == 0) {

			mSBql.append("select branchattr, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("  and branchtype='2' and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentGroup");

			mSQL = mSBql.toString();
		}

		// 续收手续费部
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("xqdep") == 0) {

			mSBql.append("select branchattr, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and state = '01' and branchtype='4' and branchlevel = '42' and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentGroup");

			mSQL = mSBql.toString();
		}

		// 续收手续费组
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("xqgrp") == 0) {

			mSBql.append("select branchattr, Name from LABranchGroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and state = '01' and branchtype='4' and branchlevel = '41' and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentGroup");

			mSQL = mSBql.toString();
		}

		// 续收人员
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("xsagentcode") == 0) {

			mSBql.append("select agentcode, Name from laagent where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and agentstate in ('01','02') and branchtype='7' ");
			mSBql.append(" order by AgentCode");

			mSQL = mSBql.toString();
		}

		// 退保类型引用EdorCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("edorcode") == 0) {
			LDUserSchema tLDUserSchema = new LDUserSchema();
			try {
				LDUserDB tLDUserDB = new LDUserDB();
				tLDUserDB.setUserCode(this.mGlobalInput.Operator);
				if (!tLDUserDB.getInfo()) {
					System.out.println("select error");
				}

				tLDUserSchema = tLDUserDB.getSchema();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			// if (tLDUserSchema.getEdorPopedom() == null) {
			// return false;
			// }

			mSQL = "select distinct b.EdorCode, b.EdorName from LMRiskEdoritem  a,LMEdorItem b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by EdorCode";
			while (mSQL.indexOf("@") != -1) {
				int indexAsterisk = mSQL.indexOf("@");
				String tPreStr = mSQL.substring(0, indexAsterisk);
				String tPostStr = mSQL.substring(indexAsterisk + 1);
				mSQL = tPreStr + tLDUserSchema.getEdorPopedom() + tPostStr;
			}
		}

		// 代理机构引用AgentCom
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcom") == 0) {
			// mSQL =
			// "select AgentCom, Name, UpAgentCom, AreaType, ChannelType from
			// LACom where "
			// + mConditionField + " = " + mCodeCondition
			// + " and ManageCom like '" + mGlobalInput.ManageCom + "%' order by
			// AgentCom";

			mSBql.append("select AgentCom, Name, UpAgentCom, AreaType, ChannelType from LACom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentCom");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 查询6位机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecom6") == 0) {
			// mSQL =
			// "select AgentCom, Name, UpAgentCom, AreaType, ChannelType from
			// LACom where "
			// + mConditionField + " = " + mCodeCondition
			// + " and ManageCom like '" + mGlobalInput.ManageCom + "%' order by
			// AgentCom";

			mSBql.append("select ComCode, Name from LDCom where length(trim(ComCode)) = 6 order by ComCode asc");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 根据6位机构查询8为机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecom8") == 0) {
			// mSQL =
			// "select AgentCom, Name, UpAgentCom, AreaType, ChannelType from
			// LACom where "
			// + mConditionField + " = " + mCodeCondition
			// + " and ManageCom like '" + mGlobalInput.ManageCom + "%' order by
			// AgentCom";

			mSBql.append("select ComCode, Name from LDCom where ");
			mSBql.append(mConditionField);
			mSBql.append(" like ");
			mSBql.append(mCodeCondition);
			mSBql.append("and length(trim(ComCode)) = 8  order by ComCode asc");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 根据选择managecom不同 查询agengcom
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("pragentcom") == 0) {
			// mSQL =
			// "select AgentCom, Name, UpAgentCom, AreaType, ChannelType from
			// LACom where "
			// + mConditionField + " = " + mCodeCondition
			// + " and ManageCom like '" + mGlobalInput.ManageCom + "%' order by
			// AgentCom";

			mSBql.append("select AgentCom, Name  from LACom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype='7' and  sellflag='Y' and state='N'");

			mSBql.append(" order by AgentCom");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 下拉收费组
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("shoufeizu") == 0) {
			mSBql.append("select branchattr, Name from labranchgroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 中介个险手续费加扣款查询中介机构名称引用
		// add by heyj 20100331
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zagentcom") == 0) {
			mSBql.append("select AgentCom, Name, UpAgentCom, AreaType, ChannelType from LACom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and branchtype='7' order by AgentCom");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 手续费发放代理机构引用YFagentcom
		// add by sunhongyan 20090717
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("yfagentcom") == 0) {
			mSBql.append("select distinct a.agentcom,(select distinct b.name from lacom b where b.agentcom=a.agentcom ) from lachargefoot a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and a.state='2'");
			// edit by sunhongyan 支持总公司发放手续费 2010-05-06
			if (mGlobalInput.ManageCom.equals("86")) {
				mSBql.append(" and a.ManageCom = '");
				mSBql.append(mGlobalInput.ManageCom);
				mSBql.append("' order by AgentCom");
			} else {
				mSBql.append(" and a.ManageCom like '");
				mSBql.append(mGlobalInput.ManageCom);
				mSBql.append("%' order by AgentCom");
			}
			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 手续费发放查询代理机构引用xfagentcom
		// add by sunhongyan 20100520
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("xfagentcom") == 0) {
			mSBql.append("select distinct a.agentcom,(select distinct b.name from lacom b where b.agentcom=a.agentcom ) from lachargefoot a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and a.state in ('2','3')");
			// edit by sunhongyan 支持总公司发放手续费 2010-05-06
			if (mGlobalInput.ManageCom.equals("86")) {
				mSBql.append(" and a.ManageCom = '");
				mSBql.append(mGlobalInput.ManageCom);
				mSBql.append("' order by AgentCom");
			} else {
				mSBql.append(" and a.ManageCom like '");
				mSBql.append(mGlobalInput.ManageCom);
				mSBql.append("%' order by AgentCom");
			}
			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 团险中介机构引用GrpAgentCom
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("grpagentcom") == 0) {
			mSBql.append("select AgentCom, Name, UpAgentCom, AreaType, ChannelType from LACom where ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by AgentCom");

			mSQL = mSBql.toString();

			executeType = 1;
		}

		// 中介手续费模版管理
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("chargeversion") == 0) {
			mSQL = " select chargeversionno,cvname from lachargeversion where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by chargeversionno";
		}

		// 银行分行渠道BankCharge
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("BankCharge") == 0) {
			mSQL = "select Code, CodeName, CodeAlias, ComCode, OtherSign from ldcode where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ "and codetype = 'bankcharge' order by Code";
		}

		// 险种编码引用RiskCode 不显示已停销的险种 modified by liangyy
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcode") == 0) {
			// mSQL = "select RiskCode,RiskName from LMRisk where "
			// + mConditionField + " = " + mCodeCondition
			// + " order by RiskCode";
			// mSQL = "select riskcode,riskname from lmriskapp where
			// subriskflag='M' and riskprop in ('I','C','D','A') and poltype='P'
			// order by riskcode";
			// hanxl,个险录单界面仅下拉出个险产品,此处待个险录单界面修改需求提交上来之后还需要再次修改,应与业务员所属渠道联系起来，此处是查询出来所有的个险、中介个险、中高端渠道的产品。
			mSQL = "select riskcode,riskname from lmriskapp where ";
			mSQL = mSQL + (mConditionField);
			mSQL = mSQL + (" = ");
			mSQL = mSQL + (mCodeCondition);
			mSQL = mSQL + " order by riskcode ";
		}

		// 险种编码引用RiskCode 只显示年金转换产品 modified by renzd
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("garisk") == 0) {
			mSQL = "select a.riskcode,a.riskname from lmriskapp a where a.subriskflag='M' and "
					+ "(a.enddate is null or a.enddate >= (select sysdate from dual)) "
					+ "and a.poltype='P' and exists(select * from ldcode where codetype='garisk' and code=a.riskcode) order by riskcode";
		}

		// 续期收费团队新建选择上级团队 added by liangyy
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("upteam") == 0) {
			mSQL = "select branchattr,name from labranchgroup where branchtype='4' and branchtype2='01' and branchlevel='02' and endflag='N' and ";
			mSQL += mCodeCondition;
		}

		// add by sinosoft.falcon 20070615
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("lfriskcode") == 0) {
			mSQL = "select riskcode,riskname from lfrisk order by riskcode";
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("standinsurcode") == 0) {
			mSQL = "select Code,CodeName from LDCode where codetype='standinsurcode' order by code";
		}
		// end

		// 银代险种编码引用BankRiskCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("bankriskcode") == 0) {
			// hanxl,银代险种界面下拉出在LMRiskToChnl中定义的银代销售渠道的产品
			// mSQL = "select riskcode,riskname from lmriskapp where
			// subriskflag='M' and riskprop in ('Y','B','C','D') order by
			// riskcode";
			mSQL = "select riskcode,riskname from lmriskapp where subriskflag='M' and (enddate is null or enddate>=(select sysdate from dual))and riskcode in(select riskcode from lmriskcomctrl where salechnl='3' AND SYSDATE BETWEEN startdate AND enddate) order by riskcode";
		}
		// 直销险种编码引用directriskcode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("directriskcode") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp where subriskflag='M' and riskprop in ('T','E','F','H') and (enddate is null or enddate >= (select sysdate from dual)) order by riskcode";
		}
		// 财务险种查询11111
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodefin") == 0) {
			// mSQL = "select riskcode,riskname from lmriskapp where 1=1 and
			// (PolType<>'C' or RiskProp<>'G') order by riskcode";
			mSQL = "select riskcode aa,riskname from lmriskapp union select contplancode aa,contplanname from ldplan where state = '9' and riskprop = 'G' order by aa";
			executeType = 1;
		}
		//
		// 财务险种查询 不显示已停销险种 为了避免保全部分的引用冲突 增加新的分支
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodefindnew") == 0) {
			// mSQL = "select riskcode,riskname from lmriskapp where 1=1 and
			// (PolType<>'C' or RiskProp<>'G') order by riskcode";
			mSQL = "select riskcode aa,riskname from lmriskapp where enddate is null or enddate >=(select sysdate from dual) union select contplancode aa,contplanname from ldplan where state = '9' and riskprop = 'G' order by aa";
			executeType = 1;
		}
		// add by zhaopeng
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodefindnewother") == 0) {
			// mSQL = "select riskcode,riskname from lmriskapp where 1=1 and
			// (PolType<>'C' or RiskProp<>'G') order by riskcode";
			mSQL = "select riskcode aa,riskname from lmriskapp where enddate is null or enddate >=(select sysdate from dual) order by aa";
			executeType = 1;
		}
		// begin add by wangxizhao 2010-8-30
		// 查询电销险种产品，不显示已停销险种
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("telriskcode") == 0) {
			mSQL = "select riskcode aa,riskname from lmriskapp where riskprop = 'T' and (enddate is null or enddate >='"
					+ PubFun.getCurrentDate() + "') order by aa";
			executeType = 1;
		}
		// end add by wangxizhao 2010-8-30

		// begin add by wangxizhao 2010-12-13
		// 新发票打印系统中根据机构和发票类型，下拉出版本号
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("receiptversion") == 0) {

			mSBql.append("select a.receiptversion receiptversion,'"
					+ bundle.getString("SQLResult")
					+ "' receiptversionname  from ldcomprintdef a where ");

			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);

			mSQL = mSBql.toString();
		}

		// begin add by wangxizhao 2011-03-08
		// 新契约个银通知函打印中根据选择的通知函类型下拉有待打印数据的通知函名称，不一定是所有通知函
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("qynotice") == 0) {

			mSBql.append("select distinct *  from (select case when x.code in ('XBc43','XBc44','XBc45','XBc47','XBc48') then 'XBCB' else x.code end,case when x.code='03' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "  when x.code='04' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "  when x.code='14' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "  when x.code='15' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "   when x.code='16' then '"
					+ bundle.getString("Premium")
					+ "'"
					+ "  when x.code='09' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "  when x.code='00' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "    when x.code='06' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='81' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='82' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "    when x.code='84' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='89' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='91' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='08' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='BF00' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='CB' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='18' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+

					"     when x.code='XB43' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='XB44' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='XB45' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='XB40' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "     when x.code='XB48' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "    when x.code='XB47' then '"
					+ bundle.getString("SQLResult")
					+ "'"
					+ "    when x.code in('XBc43','XBc44','XBc45','XBc47','XBc48') then '"
					+ bundle.getString("SQLResult") + "'" +

					"  end  as c from (select distinct a.code  from loprtmanager a  where ");

			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);

			mSBql.append(")");
			mSQL = mSBql.toString();
			mSQL = mSBql.toString();

		}

		// 本级以及本级以下的管理机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("receiptcom") == 0) {
			mSQL = "select comcode,name from ldcom where 1=1 "
					+ " and comcode like '"
					+ mGlobalInput.ManageCom
					+ ""
					+ "%' and comgrade in ('02') union (select comcode, name "
					+ "from ldcom"
					+ " where comcode in (select checkcomcode from lmchecktocom)) order by comcode";
		}

		// begin add by wangxizhao 2010-12-13
		// 新发票打印系统中根据发票类型，下拉出可选参数项
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("receiptparameter") == 0) {

			mSBql.append("select a.code code,a.codename codename from ldcode a where ");

			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);

			mSQL = mSBql.toString();
		}

		// begin add by liang 2009-06-04
		// 初审时险种查询，只是查询个险
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodesurvey") == 0) {
			mSQL = "select riskcode aa,riskname from lmriskapp where riskprop = 'I' and (enddate is null or enddate >= (select sysdate from dual)) order by aa";
			executeType = 1;
		}
		// end add by liang 2009-06-04

		// begin add by liang 2009-08-04
		// 核保上报时查询出上报核保员的代码和姓名
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("upuwcode") == 0) {
			mSQL = "select a.usercode,b.username from lduwuser a,lduser b where a.usercode = b.usercode and a.uwtype = '1'";
			executeType = 1;
		}
		// end add by liang 2009-08-04

		// begin added by sophia 2008-01-07
		// 险种按渠道查询riskcodechnl
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodechnl") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by riskcode";
		}
		// end added by sophia 2008-01-07

		// begin added by wuzm 2010-5-6
		// 险种按渠道查询riskcodechnl
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodechnlnew") == 0) {
			mSQL = "select distinct a.riskcode,a.riskname from lmriskapp a,lmriskcomctrl b where  "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.riskcode=b.riskcode AND SYSDATE BETWEEN b.startdate AND b.enddate order by riskcode";
		}
		// end added by wuzm 2010-5-6

		// 险种分渠道查询riskcodechnl1
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodechnl1") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp where mngcom='I' order by riskcode";
		} // 险种分渠道查询riskcodechnl2
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodechnl2") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp where mngcom='G' order by riskcode";
		} // 险种分渠道查询riskcodechnl3
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodechnl3") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp where mngcom='B' order by riskcode";
		} // 险种分渠道查询riskcodechnl5
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcodechnl5") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp where mngcom='T' order by riskcode";
		}

		// 险种编码引用RiskCode1
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcode1") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName,b.SubRiskFlag,b.SubRiskFlag from LMRisk a,LMRiskApp b where a.RiskCode=b.RiskCode order by a.RiskCode";
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.toLowerCase().compareTo("riskcode2") == 0) {
			mSQL = "select RiskCode, RiskName from LMRiskApp where RiskProp in ('I','A','C','D')"
					+ " order by RiskCode";
		}

		// 险种版本引用RiskVersion
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskversion") == 0) {
			mSQL = "select RiskVer from LMRisk where " + mConditionField
					+ " = " + mCodeCondition + " order by RiskVer";
		}
		// add by lvyanzhi 20090929 远程出单手续费产品组合查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("econtplancode") == 0) {
			mSBql.append("select distinct b.contplancode ,b.contplanname from lacharge a , ldplan b  where a.contplancode=b.contplancode and 1= ");
			mSBql.append(mConditionField);
			// mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();
		}
		// end

		// add by lvyanzhi 20090929 远程出单手续费险种组合查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskcodeechnl") == 0) {
			mSBql.append("select distinct b.riskcode,b.riskname from lacharge a,lmrisk b where a.riskcode=b.riskcode and 1= ");
			mSBql.append(mConditionField);
			// mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();
		}
		// end
		// 机构编码引用ComCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comcode") == 0) {
			// mSQL =
			// "select ComCode, Name, ShortName, Address, Sign from ldcom where
			// "
			// + mConditionField + " = " + mCodeCondition
			// + " and comcode like '"
			// + mGlobalInput.ManageCom + "%' order by comcode";
			mSBql.append("select ComCode, Name, ShortName, Address, Sign from ldcom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" order by comcode");

			mSQL = mSBql.toString();
			// System.out.println("登陆的机构============" + mGlobalInput.ManageCom);
			// System.out.println(mSQL);
			/** @todo 取消对于下拉框行数的限制 add by HYQ */
			executeType = 1;
			transI18NFlag = false;

		}
		// 英文机构编码引用EnComCode add by wmh
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("encomcode") == 0) {
			mSBql.append("select ComCode, Name, ShortName, Address, Sign from ldcom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comenname is not null ");
			mSBql.append(" and comcode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by comcode");

			mSQL = mSBql.toString();
			// System.out.println("登陆的机构============" + mGlobalInput.ManageCom);
			// System.out.println(mSQL);
			/** @todo 取消对于下拉框行数的限制 add by HYQ */
			executeType = 1;
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("indexcode") == 0) {
			mSBql.append("select indexcode,indexname from laindexvscommp where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and managecom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by indexcode");
			mSQL = mSBql.toString();
			/** @todo 取消对于下拉框行数的限制 add by HYQ */
			executeType = 1;
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("indexcodec") == 0) {
			mSBql.append("select a.indexcode,a.indexname from laindexvscommp a,laassessindexp b where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and a.managecom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and b.branchtype=a.branchtype and b.basicversion=a.basicversion and "
					+ "b.agentgrade=a.agentgrade and b.indexcode=a.indexcode and exists(select 1 from lacalmodep "
					+ "where paratype='1' and calcode=b.calcode ) order by a.indexcode");
			mSQL = mSBql.toString();
			/** @todo 取消对于下拉框行数的限制 add by HYQ */
			executeType = 1;
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("basiscode") == 0) {
			mSBql.append("select a.indexcode, a.indexname from laindexvscommz a,laassessindexz b where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and a.indexcode not like '%X%' and a.managecom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and b.branchtype=a.branchtype and b.indexcode=a.indexcode and exists (select 1 from lacalmodez where paratype='1' and calcode=b.calcode) "
					+ "order by a.indexcode");
			mSQL = mSBql.toString();
			/** @todo 取消对于下拉框行数的限制 add by HYQ */
			executeType = 1;
		}
		// 机构编码引用ShortCommCode显示短名称
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("shortcomcode") == 0) {
			// mSQL =
			// "select ComCode, Name, ShortName, Address, Sign from ldcom where
			// "
			// + mConditionField + " = " + mCodeCondition
			// + " and comcode like '"
			// + mGlobalInput.ManageCom + "%' order by comcode";
			mSBql.append("select ComCode,ShortName,name, Address, Sign from ldcom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comcode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' order by comcode");

			mSQL = mSBql.toString();
			// System.out.println("登陆的机构============" + mGlobalInput.ManageCom);
			// System.out.println(mSQL);
			/** @todo 取消对于下拉框行数的限制 add by HYQ */
			executeType = 1;
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comcode4") == 0) {
			// mSQL =
			// "select ComCode, Name, ShortName, Address, Sign from ldcom where
			// "
			// + mConditionField + " = " + mCodeCondition
			// + " and comcode like '"
			// + mGlobalInput.ManageCom + "%' and length(trim(comcode))=4 order
			// by comcode";

			mSBql.append("select ComCode, Name, ShortName, Address, Sign from ldcom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comcode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and length(trim(comcode))=4 order by comcode");

			mSQL = mSBql.toString();
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comcode8") == 0) {
			mSBql.append("select ComCode, Name, ShortName, Address, Sign from ldcom where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comcode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' and length(trim(comcode))=8 order by comcode");
			mSQL = mSBql.toString();
		}

		// 机构编码引用ComCodeAll
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comcodeall") == 0) {
			mSQL = "select ComCode, Name, ShortName, Address, Sign from ldcom where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by comcode";
		}

		// added by lulinlin 20101126 资金平台打印日结需求修改
		// 收付机构编码引用comcodeall2，当登录机构为86时，收付机构只限制为86
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comcodeall2") == 0) {
			mSQL = "select comcode, name, shortname, address, sign"
					+ " from ldcom where comcode = '86'";

		}
		// added by lulinlin 2011-3-8　精算核对报表页面险种号查询
		// 险种信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("sriskcode") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp where substr(riskcode,3,3) in(select riskcode from lirisktype where risktype4 = '1') ";
			executeType = 1;
		}

		// 管理机构编码引用comcodemanage
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comcodemanage") == 0) {
			mSQL = "select ComCode, Name, ShortName, Address, Sign from ldcom where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ "union select comcode, name, shortname, address, sign"
					+ " from ldcom where comcode = '86'" + " order by comcode";
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("grprisk2") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName,b.GrpPolNo from LMRiskApp a,LCGrpPol b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.RiskCode = b.RiskCode and b.appflag ='1' and b.RiskCode not like '%A' order by a.RiskCode";
		}

		// 银行险编码引用Riskbank
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskbank") == 0) {
			if (mCodeCondition.trim().equals("'1' and branchtype=2")) {
				mCodeCondition = "1";
				mSQL = "select RiskCode, RiskName from LMRiskApp where "
						+ mConditionField
						+ " = "
						+ mCodeCondition
						+ " and RiskProp in ('A','B','G','D') order by RiskCode";
			} else {
				mCodeCondition = "1";
				mSQL = "select RiskCode, RiskName from LMRiskApp where "
						+ mConditionField
						+ " = "
						+ mCodeCondition
						+ " and RiskProp in ('Y','B','C','D') order by RiskCode";
			}
		}

		// 团险编码引用RiskGrp
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskgrp") == 0) {
			mSQL = "select RiskCode, RiskName,SubRiskFlag from LMRiskApp where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ "and (enddate is null or enddate>=(select sysdate from dual)) and RiskProp in ('G','A','B','D') and poltype='P' "
					+ " order by RiskCode";
		}

		// 个险编码引用RiskInd
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskind") == 0) {
			mSQL = "select RiskCode, RiskName from LMRiskApp where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and RiskProp in ('I','A','C','D') and (enddate is null or enddate >= (select sysdate from dual)) order by RiskCode";
		}

		// 普通单证编码引用CertifyCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("certifycode") == 0) {
			mSQL = "SELECT CertifyCode, CertifyName FROM LMCertifyDes WHERE "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and (CertifyClass = 'P' or CertifyClass = 'D') AND State = '0' order by CertifyCode";
			m_bCanBeCached = false;
			executeType = 1;
		}

		// 定额单证编码引用CardCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("cardcode") == 0) {
			mSQL = "SELECT CertifyCode, CertifyName FROM LMCertifyDes WHERE "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and CertifyClass = 'D' AND State = '0' order by CertifyCode";
			m_bCanBeCached = false;
			executeType = 1;
		}

		// 系统单证编码引用SysCertCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("syscertcode") == 0) {
			mSQL = "SELECT CertifyCode, CertifyName FROM LMCertifyDes WHERE "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and CertifyClass = 'S' AND State = '0' order by CertifyCode";
			m_bCanBeCached = false;
			executeType = 1;
		}

		// 告知编码引用ImpartCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("impartcode") == 0) {
			mSQL = "SELECT ImpartCode, ImpartContent ,CreateDH((select count(*)"
					+ " from ldimpartparam b where b.impartcode = c.impartcode and b.impartver = c.impartver))"
					+ " FROM LDImpart c WHERE c."
					+ mConditionField
					+ " = "
					+ mCodeCondition + " order by ImpartCode";
		}

		// //告知编码引用ImpartVer
		// if
		// (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "impartver") == 0)
		// {
		// mSQL = "SELECT Code, CodeName FROM LDCode WHERE "
		// + mConditionField + " = " + mCodeCondition
		// + " order by ImpartCode";
		// }

		// 管理机构编码引用Station，已不再使用
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("station") == 0) {
			if (mCodeCondition.toLowerCase().indexOf("comcode") == -1) {
				mCodeCondition = mCodeCondition.toLowerCase().replaceAll(
						"code", "comcode");
			}
			mSQL = "select comcode,name from ldcom where " + mConditionField
					+ " = " + mCodeCondition + " and comcode like '"
					+ mGlobalInput.ManageCom + "%' order by comcode";
			executeType = 1;
		}
		// add by yaory for relatedpeople
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("insuredpeople") == 0) {
			System.out.println("被保人关系！");
			mSBql.append("select insuredno,name,sequenceno from lcinsured where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();

		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("askpricerisk") == 0) {
			System.out.println("询价询价单险种！");
			mSBql.append("select a.RiskCode,(select riskname from lmrisk where riskcode=a.RiskCode ),isnull(a.RewardRatio,0),"
					+ "isnull(a.ChargesRatio,0) from AskPriceRadio a where  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();

		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("hebaoquanxian") == 0) {
			System.out.println("核保结论代码！");
			mSBql.append("select code,codename from ldcode where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();

		}

		// 工种代码引用OccupationCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("occupationcode") == 0) {
			mSQL = "select trim(OccupationCode), trim(OccupationName), trim(OccupationType) from LDOccupation where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ "and worktype = 'GR' order by OccupationCode";

			executeType = 1;
		}

		// 交费方式代码引用PayYears
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("payyears") == 0) {
			mSQL = "select trim(PayEndYearFlag)||PayEndYear||'*'||PayIntv,ShowInfo from LMPayMode where "
					+ mConditionField + " = " + mCodeCondition;

			executeType = 1;
		}

		// 交费期限代码引用PayEndYear
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("payendyear") == 0) {
			mSQL = "select ParamsCode, ParamsName from LMRiskParamsDef where Paramstype = 'payendyear' and "
					+ mConditionField + " = " + mCodeCondition;

			executeType = 1;
		}

		// 交费期限代码引用(中介用)GrpPayEndYear
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("grppayendyear") == 0) {
			mSQL = "select ParamsCode, ParamsName from LMRiskParamsDef where Paramstype = 'payendyear' and paramscode<>'1000' and "
					+ mConditionField + " = " + mCodeCondition;

			executeType = 1;
		}

		// 领取年龄代码引用GetYear
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getyear") == 0) {
			mSQL = "select ParamsCode, ParamsName from LMRiskParamsDef where Paramstype = 'getyear' and "
					+ mConditionField + " = " + mCodeCondition;

			// executeType = 1;
			// System.out.println("mSQL=" + mSQL);
		}

		// 领取间隔代码引用GetIntv
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getintv") == 0) {
			mSQL = "select ParamsCode, ParamsName from LMRiskParamsDef where Paramstype = 'getintv' and "
					+ mConditionField + " = " + mCodeCondition;

			// executeType = 1;
			// System.out.println("mSQL=" + mSQL);
		}
		// 兼业单证作废原因查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zycancelreason") == 0) {
			String tConditionField1 = mConditionField.substring(0, 8);
			String tConditionField2 = mConditionField.substring(9);
			String tCodeCondition1 = mCodeCondition.substring(0, 15) + "'";
			String tCodeCondition2 = "'" + mCodeCondition.substring(16);
			mSQL = "select code,codename from ldcode where " + tConditionField1
					+ " = " + tCodeCondition1 + " and " + tConditionField2
					+ " = " + tCodeCondition2;
			System.out.println("mSQL=" + mSQL);
		}
		// 国家信息(中文名称，英文名称，风险类别)查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("country") == 0) {
			mSQL = "select CountryName,CountryEnName,RiskType from Country";
			System.out.println(mSQL);
		}
		// 兼业协议类型查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("protocoltype") == 0) {
			mSQL = "select Code,CodeName from ldcode where codetype='protocoltype'";
			System.out.println(mSQL);
		}
		// 离职原因查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("departrsn") == 0) {
			System.out.println("CodeType=departrsn");
			mSQL = "select Code,CodeName from ldcode where codetype ='departrsn' order by to_number(code)";
			System.out.println(mSQL);
		}

		// 批处理日志查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("taskcode") == 0) {
			mSQL = "select taskcode,taskdescribe from ldtask order by taskcode";
			System.out.println(mSQL);
		}

		// 培训类别查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("trainaclass") == 0) {
			mSQL = "select Code,CodeName from ldcode where codetype ='trainaclass' order by to_number(code)";
			System.out.println(mSQL);
		}

		// 兼业险种查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("protrisk") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName,b.ProtocolNo,a.SubRiskFlag from LMRiskApp a,LXComRiskRela b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.RiskCode = b.RiskCode order by a.RiskCode";
		}
		// 兼业险种查询ProtMainRisk主险
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("protmainrisk") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName,b.ProtocolNo from LMRiskApp a,LXComRiskRela b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.RiskCode = b.RiskCode and a.SubRiskFlag <> 'S' order by a.RiskCode";
		}

		// 团单险种查询GrpRisk
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("grprisk") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName,b.GrpPolNo,a.SubRiskFlag from LMRiskApp a,LCGrpPol b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.RiskCode = b.RiskCode order by a.RiskCode";
		}

		// 团单险种查询GrpMainRisk主险
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("grpmainrisk") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName,b.GrpPolNo from LMRiskApp a,LCGrpPol b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.RiskCode = b.RiskCode and a.SubRiskFlag <> 'S' order by a.RiskCode";
		}

		// 团单险种查询GrpMainRisk主险
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("grpmainrisk1") == 0) {
			mSQL = "select distinct a.RiskCode, a.RiskName from LMRiskApp a where a.SubRiskFlag <> 'S' order by a.RiskCode";
		}

		// 取得分红险种
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("onusrsk") == 0) {
			mSQL = "select RiskCode,RiskName from LMRiskApp where BonusFlag='Y'";
		}

		// 查询缴费规则
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("payrulecode") == 0) {
			mSQL = "select distinct PayRuleCode,PayRuleName from LCPayRuleFactory"
					+ " where " + mConditionField + " = " + mCodeCondition;
		}

		// 查询赔付比例特约,Type编码默认为000007
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getlimitrule") == 0) {
			mSQL = "select RiskCode,(select riskname from lmrisk where riskcode=lmfactorymode.riskcode) from lmfactorymode"
					+ " where factorytype='000007' and "
					+ mConditionField
					+ " = " + mCodeCondition;
		}

		// 查询赔付比例特约,Type编码默认为000007
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getlimitruledutycode") == 0) {
			mSQL = "select FactorySubName,(select DutyName from lmduty where dutycode=lmfactorymode.factorySubName) as DutyName,calRemark,Params from lmfactorymode"
					+ " where factorytype='000007' and "
					+ mConditionField
					+ " = " + mCodeCondition;
		}
		// 查询归属规则
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("ascriptionrulecode") == 0) {
			mSQL = "select distinct AscriptionRuleCode,AscriptionRuleName from LCAscriptionRuleFactory"
					+ " where " + mConditionField + " = " + mCodeCondition;
		}

		// 团单险种缴费规则查询RiskRuleFactoryType，Type编码默认为000005
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskrulefactorytype") == 0) {
			mSQL = "select distinct a.FactoryType,b.FactoryTypeName,trim(a.FactoryType)||trim(a.RiskCode) from LMFactoryMode a,LMFactoryType b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.FactoryType = b.FactoryType and a.FactoryType = '000005'";
		}

		// 团单险种归属规则查询RiskAscriptionRuleFactoryType，Type编码默认为000006
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskascriptionrulefactorytype") == 0) {
			mSQL = "select distinct a.FactoryType,b.FactoryTypeName,trim(a.FactoryType)||trim(a.RiskCode) from LMFactoryMode a,LMFactoryType b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.FactoryType = b.FactoryType and a.FactoryType = '000006'";
			// System.out.println("in mSQL:" + mSQL);
		}
		// 团单险种退保手续费及部分领取费用查询RiskchargeFactoryType，Type编码默认为000005 和 000004
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskchargefactorytype") == 0) {
			mSQL = "select distinct a.FactoryType,b.FactoryTypeName,trim(a.FactoryType)||trim(a.RiskCode) from LMFactoryMode a,LMFactoryType b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.FactoryType = b.FactoryType and a.FactoryType in('01','02')";
			// System.out.println("in mSQL:" + mSQL);
		}
		// 团单险种归属规则查询riskascriptionrulefactoryno
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskascriptionrulefactoryno") == 0) {
			if (mCodeCondition.substring(1, 7).equals("000006")) { // 没有加入任何限制条件，以后扩展
				mSQL = "select PayPlanCode,PayPlanName from LMDutyPay where "
						+ "payplancode in (select payplancode from lmdutypayrela where "
						+ "dutycode in (select dutycode from lmriskduty where "
						+ "riskcode" + " = '" + mCodeCondition.substring(7, 15)
						+ "' and SpecFlag='N'))" // 过滤掉公共帐户对应的交费项
						// caihy add 归属规则仅对单位交费有效
						// + " and payaimclass='2'";
						+ " and PubFlag='Y'";

			}
			// System.out.println("in mSQL:" + mSQL);

		}
		// 团单险种归属规则查询riskascriptionrulefactory
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskascriptionrulefactory") == 0) {
			mSQL = "select FactoryCode,CalRemark,Params,FactoryName from LMFactoryMode  "
					+ " where FactoryType = '"
					+ mCodeCondition.substring(1, 7)
					+ "' and RiskCode='"
					+ mCodeCondition.substring(7)
					+ ""
					+ " order by FactoryCode,FactorySubCode ";
			// System.out.println("in mSQL:" + mSQL);
		}
		// 团单退保手续费查询chargeratefactory
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("chargeratefactory") == 0) {
			mSQL = "select FactoryCode||to_char(FactorySubCode),CalRemark,Params,FactoryName from LMFactoryMode  "
					+ " where FactoryType = '"
					+ mCodeCondition.substring(1, 3)
					+ "' and RiskCode='"
					+ mCodeCondition.substring(3)
					+ ""
					+ " order by FactoryCode,FactorySubCode ";
			// System.out.println("in mSQL:" + mSQL);
		}

		// 团单险种缴费规则查询RiskRuleFactoryNo
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskrulefactoryno") == 0) {
			if (mCodeCondition.substring(1, 7).equals("000005")) {
				// 没有加入任何限制条件，以后扩展
				mSQL = "select PayPlanCode,PayPlanName from LMDutyPay where payplancode in (select payplancode from lmdutypayrela where dutycode in (select dutycode from lmriskduty where riskcode = '"
						+ mCodeCondition.substring(7, 13)
						+ "' and SpecFlag='N'))";
			}
		}

		// 团单险种缴费规则查询RiskRuleFactory
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskrulefactory") == 0) {
			mSQL = "select FactoryCode||to_char(FactorySubCode),CalRemark,Params,FactoryName from LMFactoryMode  "
					+ " where FactoryType = '"
					+ mCodeCondition.substring(1, 7)
					+ "' and RiskCode='"
					+ mCodeCondition.substring(7)
					+ " order by FactoryCode,FactorySubCode ";
		}

		// 查询子账户的险种账户编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("subriskacccode") == 0) {
			mSQL = "select payplancode||insuaccno RiskAccCode,RiskAccPayName from lmriskaccpay where "
					+ mConditionField + "=" + mCodeCondition;
		}
		// 查询子账户的险种账户编码,仅缴费帐户（承保帐户触发器）
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("subriskacccodepay") == 0) {
			mSQL = "select RiskAccPayName,payplancode||insuaccno RiskAccCode from lmriskaccpay where "
					+ mConditionField
					+ "="
					+ mCodeCondition
					+ " and InsuAccNo='000001'";

		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("subriskacccodepayname") == 0) {
			mSQL = "select Code,CodeName RiskAccCode from ldcode where 1=1"
			// + mConditionField + "=" + mCodeCondition

					+ " and codetype='toobjecttype'";
			System.out.println(mConditionField);
			System.out.println(mCodeCondition);
			System.out.println(mCodeCondition.length());
			if (mConditionField.toLowerCase().equals("payplancode")) {
				if ((mCodeCondition.trim().substring(1, 7).equals("692102"))
						|| (mCodeCondition.trim().substring(1, 7)
								.equals("692103"))
						|| (mCodeCondition.trim().substring(1, 7)
								.equals("692104"))) {
					mSQL = mSQL + " and code in('00','01')";
				}
			}
		}

		// 团单保险计划下险种查询ImpRiskCode
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("impriskcode") == 0) {
			String a = mCodeCondition.substring(0, 2); // 保险计划编码
			String b = mCodeCondition.substring(2); // 合同号

			mSQL = "select distinct a.RiskCode, a.RiskName, a.RiskVer,b.MainRiskCode,b.MainRiskVersion from LMRiskApp a,LCContPlanRisk b where "
					+ mConditionField
					+ " = "
					+ a
					+ "' and GrpContNo = '"
					+ b
					+ " and a.RiskCode = b.RiskCode order by a.RiskCode";
		}

		// 团单保险计划下险种对应要素类别ImpFactoryType
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("impfactorytype") == 0) {
			mSQL = "select distinct a.FactoryType,b.FactoryTypeName,trim(a.FactoryType)||trim(a.RiskCode) from LMFactoryMode a,LMFactoryType b where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and a.FactoryType = b.FactoryType and a.FactoryType < '000005'";
		}
		// 团单保险计划下险种对应要素目标编码ImHealthFactoryNo
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("imhealthfactoryno") == 0) {
			if (mCodeCondition.substring(1, 7).equals("000000")) { // 基于保单的计算
				mSQL = "select '__','" + bundle.getString("SQLResult")
						+ "' from dual";
			} else if (mCodeCondition.substring(1, 7).equals("000001")) { // 基于保单的计算
				mSQL = "select DutyCode,DutyName from LMDuty where DutyCode in(select DutyCode from LMRiskDuty where RiskCode='"
						+ mCodeCondition.substring(7) + ") order by DutyCode";
			} else if (mCodeCondition.substring(1, 7).equals("000002")) {
				// 基于给付的计算
				mSQL = "elect gedutycode,getdutyname fom lmdutygetrela where dutycode in (select dutycode from lmriskduty where riskcode ='"
						+ mCodeCondition.substring(7)
						+ ") order by getdutycode";
			} else if (mCodeCondition.substring(1, 7).equals("000003")) {
				// 基于账户的计算
				mSQL = "select insuaccno,insuaccname from LMRiskToAcc where RiskCode='"
						+ mCodeCondition.substring(7) + " order by insuaccno";
			} else if (mCodeCondition.substring(1, 7).equals("000004")) {
				// 基于理赔责任的计算
				mSQL = "select getdutycode,getdutyname from lmdutygetrela where dutycode in ( select dutycode from lmriskduty where riskcode ='"
						+ mCodeCondition.substring(7)
						+ ") order by getdutycode";
			}
		}

		// 团单保险计划下险种对应要素计算编码ImHealthFactory
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("imhealthfactory") == 0) {
			mSQL = "select FactoryCode||to_char(FactorySubCode),CalRemark,Params,FactoryName from LMFactoryMode where FactoryType = '"
					+ mCodeCondition.substring(1, 7)
					+ "' and RiskCode='"
					+ mCodeCondition.substring(7)
					+ ""
					+ " order by FactoryCode,FactorySubCode ";
		}
		
		

		// 代理人编码引用AgentCode2 --liujw
		// 修改于2005-6-02 by liuyy
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode2") == 0) {
			mSBql.append("select b.AgentCode,(select Name from laagent where agentcode = b.agentcode) name,b.AgentGroup,(select trim(BranchAttr) from laBranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) branchattr,(slect name from lABranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) ComName,b.AgentSeries,b.AgentGrade from latree b where 1=1 and exists (select agentcode from laagent a where a.agentstate in ('01','02') and a.agentcode=b.agentcode)) ");
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'");

			// +" And Branchtype = '1') And "
			// mSBql.append("+ mCodeCondition");
			// +mConditionField + " = " + mCodeCondition
			mSBql.append("ORDER BY b.AgentCode");
			mSQL = mSBql.toString();
			executeType = 1;
		}
		// 网点专管员编码AgentCode3
		// add by liuyy
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode3") == 0) {
			mSBql.append("select b.AgentCode,(select Name from laagent where agentcode = b.agentcode) name,b.AgentGroup,(select trim(BranchAttr) from laBranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) branchattr,(select name from lABranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) ComName,b.AgentSeries,b.AgentGrade from latree b where   "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and exists(select agentcode from laagent a where a.agentstate in('01','02') and a.branchtype='3' and a.agentcode=b.agentcode)");
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'");
			mSBql.append("ORDER BY b.AgentCode");
			mSQL = mSBql.toString();
			executeType = 1;
		}
		// 网点专管员编码AgentCode3
		// add by liuyy
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode31") == 0) {
			mSBql.append("select b.AgentCode,(select Name from laagent where agentcode = b.agentcode) name,b.AgentGroup,(select trim(BranchAttr) from laBranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) branchattr,(select name from lABranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) ComName,b.AgentSeries,b.AgentGrade from latree b where   "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and exists (select 'X' from laagentgrade where gradecode=b.agentgrade and gradeproperty2<='1' )"
					+ " and exists (select agentcode from laagent a where a.agentstate in('01','02') and a.branchtype='3' and a.agentcode=b.agentcode)");
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'");
			mSBql.append("ORDER BY b.AgentCode");
			mSQL = mSBql.toString();
			executeType = 1;
		}

		// 银代网点专管员编码AgentCode81--网点重新分配模块、银行代理机构维护模块
		// add by lhl 20091102
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode81") == 0) {
			mSBql.append("select b.AgentCode,(select Name from laagent where agentcode = b.agentcode) name,b.AgentGroup,(select trim(BranchAttr) from laBranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) branchattr,(select name from lABranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) ComName,b.AgentSeries,b.AgentGrade from latree b where   "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and exists (select 'X' from laagentgrade where gradecode=b.agentgrade and gradeproperty2<='1' )"
					// + " and exists (select agentcode from laagent a
					// where a.agentstate in('01','02') and
					// a.branchtype='3' and a.agentcode=b.agentcode and
					// a.salequaf='Y') ORDER BY b.AgentCode");
					+ " and exists (select agentcode from laagent a where a.agentstate in('01','02') and a.branchtype='3' and a.agentcode=b.agentcode and (a.salequaf <> 'N' or a.salequaf is null) and  a.quafno is not null) ORDER BY b.AgentCode");

			// mSBql.append(" and ManageCom like '");
			// mSBql.append(mGlobalInput.ManageCom);
			// mSBql.append("%'");
			// mSBql.append("ORDER BY b.AgentCode");
			// mSQL = mSBql.toString();
			// executeType = 1;
			mSQL = mSBql.toString();

		}

		// 中高端总行ZGBankHeadOffice added by zhangcb 2009-11-06
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zgbankheadoffice") == 0) {
			mSQL = "select AgentCom, Name, UpAgentCom, AreaType, ChannelType from LACom where "
					+ mConditionField
					+ "= "
					+ mCodeCondition
					+ " and BankType='00' and branchtype='8' order by AgentCom";
		}

		// 中介个险agentcode查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zjagentcode") == 0) {
			mSQL = "SELECT a.agentcode,(SELECT NAME FROM laagent WHERE agentcode=a.agentcode ) FROM lacomtoagent a WHERE  "
					+ mConditionField
					+ "= "
					+ mCodeCondition
					+ " and  exists(select 1 from laagent where agentcode=a.agentcode and agentstate in('01','02'))";
		}

		/**
		 * 中高端渠道专用，选择险种编码
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zgd_chnl_risk") == 0) {
			mSQL = "select riskcode,name from (select riskcode,riskname name from lmriskapp where "
					+ "riskcode in (select riskcode from lmriskcomctrl where salechnl = '8' AND SYSDATE BETWEEN startdate AND enddate)"
					// + "riskprop = 'Y'"// 正常险种
					+ " union "
					+ "select ContPlanCode riskcode,ContPlanName name from LDPlan "
					+ "where managecom like '86%' and state='9'AND EXISTS"
					+ " (SELECT 1 FROM LMCARDRISK B WHERE CONTPLANCODE = B.RISKCODE))"
					+ " order by riskcode";// 卡单计划
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zgdagentcode") == 0) {
			mSBql.append("select b.AgentCode,(select Name from laagent where agentcode = b.agentcode) name,b.AgentGroup,(select trim(BranchAttr) from laBranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) branchattr,(select name from lABranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) ComName,b.AgentSeries,b.AgentGrade from latree b where   "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and exists (select 'X' from laagentgrade where gradecode=b.agentgrade )"
					+ " and exists (select agentcode from laagent a where a.agentstate in('01','02') and a.branchtype='8' and a.agentcode=b.agentcode)");
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'");
			mSBql.append("ORDER BY b.AgentCode");
			mSQL = mSBql.toString();
			executeType = 1;
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bkagentcode22") == 0) {
			if (mCodeCondition.equals("''")) {
				return false;
			}
			String managecom = mConditionField.substring(0, 9);
			String branchattr = mConditionField.substring(10);

			String managecomValue = mCodeCondition.substring(1,
					mCodeCondition.length() - 9);
			String branchattrValue = mCodeCondition.substring(
					mCodeCondition.length() - 8, mCodeCondition.length() - 1);

			mSQL = "select l1.agentcode, l3.name from latree l1,labranchgroup l2,laagent l3"
					+ " where l1.agentgroup=l2.agentgroup and l1.agentcode=l3.agentcode"
					+ " and  l1.agentseries = '0'"
					+ " and l2."
					+ managecom
					+ " like '"
					+ managecomValue
					+ "%' and l2."
					+ branchattr
					+ " = '"
					+ branchattrValue
					+ "' and l2.branchtype = '3' and l3.agentstate in ('01','02')";

			executeType = 1;

		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bkmanagecom22") == 0) {
			mSBql.append("select comcode,name from ldcom where comcode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' ORDER BY comcode");
			mSQL = mSBql.toString();
			executeType = 1;

		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bkagentgroup22") == 0) {
			mSBql.append("select branchattr,name from labranchgroup where ");
			mSBql.append(mConditionField);
			mSBql.append(" like ");
			if (mCodeCondition.equals("''")) {
				return false;
			}
			mCodeCondition = mCodeCondition.substring(0,
					mCodeCondition.length() - 1)
					+ "%'";
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchlevel='51' ORDER BY branchattr");
			mSQL = mSBql.toString();
			executeType = 1;

		}

		// 网点专管员编码AgentCode4
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode4") == 0) {
			mSQL = "select b.AgentCode,(select Name from laagent where agentcode = b.agentcode) name,b.AgentGroup,(select trim(BranchAttr) from laBranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) branchattr,(select name from lABranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) ComName,b.AgentSeries,b.AgentGrade from latree b where b.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and exists(select agentcode from laagent a where a.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and a.agentstate in ('01','02') and a.branchtype='3' and a.agentcode=b.agentcode) order by b.agentcode";
		}
		// 网点专管员编码AgentCode4简化
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode41") == 0) {
			mSQL = "select select a.agentcode,a.name from laagent a where a.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and a.agentstate in ('01','02') and a.branchtype='3' order by a.agentcode";
		}
		// 团险AgentCode5
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode5") == 0) {
			mSQL = "select b.AgentCode,b.name,(select codename from ldcode where trim(code) = b.branchtype2 and codetype = 'branchtype2'),b.managecom,(select trim(BranchAttr) from laBranchGroup where agentgroup = b.branchcode) branchattr,(select trim(name) from labranchgroup where agentgroup=(select upbranch from labranchgroup where agentgroup=b.branchcode))||(select name from lABranchGroup where agentgroup = b.branchcode) ComName from laagent b where b.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and b.agentstate in ('01', '02') and b.branchtype = '2' order by b.agentcode";
		}

		// 团险AgentCode5中介专管员
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode51") == 0) {
			mSQL = "select b.AgentCode,b.name,(select codename from ldcode where trim(code) = b.branchtype2 and codetype = 'branchtype2'),b.managecom,(select trim(BranchAttr) from laBranchGroup where agentgroup = b.branchcode) branchattr,(select name from lABranchGroup where agentgroup = b.branchcode) ComName from laagent b where b.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and b.agentstate in ('01', '02') and b.branchtype = '2' and branchtype2 = '03' order by b.agentcode";
		}
		// 中介AgentCode7中介专管员
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode7") == 0) {
			mSQL = "select b.AgentCode,b.name,b.managecom,(select trim(BranchAttr) from laBranchGroup where agentgroup = b.branchcode) branchattr,(select name from lABranchGroup where agentgroup = b.branchcode) ComName from laagent b where b.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and b.agentstate in ('01', '02') and b.branchtype = '7' order by b.agentcode";
		}

		// 团险中介AgentCode9客户经理
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode9") == 0) {
			mSQL = "select b.AgentCode,b.name,b.managecom,(select trim(BranchAttr) from laBranchGroup where agentgroup = b.branchcode) branchattr,(select name from lABranchGroup where agentgroup = b.branchcode) ComName from laagent b where b.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and b.agentstate in ('01', '02') and b.branchtype = '9' order by b.agentcode";
		}
		/**
		 * add by lishuai 2010-12-02 团险中介 中介机构维护 客户经理 职级为客服专员的不能与中介机构关联
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode91") == 0) {
			mSQL = " select b.AgentCode,b.name   from laagent b,LATree c "
					+ "where b.ManageCom like '" + mGlobalInput.ManageCom
					+ "%' and b.agentstate in ('01', '02')"
					+ "    and b.branchtype = '9'"
					+ "	 and b.agentcode=c.agentcode"
					+ "	 and c.agentgrade!='E000'" + " order by b.agentcode";
		}
		/** end lishuai 2010-12-02 */

		// 团险中介AgentCode5 电销经理
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode55") == 0) {
			mSQL = "select b.AgentCode,b.name,b.managecom,(select trim(BranchAttr) from laBranchGroup where agentgroup = b.branchcode) branchattr,(select name from lABranchGroup where agentgroup = b.branchcode) ComName from laagent b "
					+ " left join  latree c on b.agentcode = c.agentcode  where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and b.agentstate in ('01', '02') and b.branchtype = '5'  order by b.agentcode";
		}

		// 团险AgentCode5直销
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode52") == 0) {
			mSQL = "select b.AgentCode,b.name,(select codename from ldcode where trim(code) = b.branchtype2 and codetype = 'branchtype2'),b.managecom,(select trim(BranchAttr) from laBranchGroup where agentgroup = b.branchcode) branchattr,(select name from lABranchGroup where agentgroup = b.branchcode) ComName from laagent b where b.ManageCom like '"
					+ mGlobalInput.ManageCom
					+ "%' and b.agentstate in ('01', '02') and b.branchtype = '2' and branchtype2 = '01' order by b.agentcode";
		}

		// 团险交叉销售专员代码AgentCode6
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode6") == 0) {
			mSBql.append("select b.AgentCode,(select Name from laagent where agentcode = b.agentcode) name,b.AgentGroup,(select trim(BranchAttr) from laBranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) branchattr,(select name from lABranchGroup where agentgroup = (select branchcode from laagent where agentcode = b.agentcode)) ComName,b.AgentSeries,b.managecom from latree b where   "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " and exists(select agentcode from laagent a where a.agentstate in('01','02') and a.branchtype='2' and a.branchtype2='02' and a.agentcode=b.agentcode)");
			mSBql.append(" and ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'");
			mSBql.append("ORDER BY b.AgentCode");
			mSQL = mSBql.toString();
			executeType = 1;
		}
		// 团险交叉销售专员代码AgentCode6简化
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcode61") == 0) {
			mSBql.append("select b.agentcode,b.name from laagent b where b.agentstate in('01','02') and b.branchtype='2' and b.branchtype2='02'");
			mSBql.append(" and b.ManageCom like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%'");
			mSBql.append("ORDER BY b.AgentCode");
			mSQL = mSBql.toString();
			executeType = 1;
		}

		// 员工制待遇级别查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("employeegrade") == 0) {
			mSQL = "select gradecode,gradename from laagentgrade where GradeProperty6 = '1' order by gradecode";
		}
		// 员工制待遇级别查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("employeegrade2") == 0) {
			mSQL = "select lawelfareradix.agentgrade,ldcode.codename,100 from lawelfareradix ,ldcode,laagentgrade where  ldcode.codetype = 'employeeaclass' and ldcode.code = lawelfareradix.aclass and lawelfareradix.branchtype = '1' and laagentgrade.gradecode = lawelfareradix.agentgrade and laagentgrade.gradeproperty6 = '1' and lawelfareradix.aclass = "
					+ mCodeCondition + " order by lawelfareradix.agentgrade";
		}
		// 个单合同无扫描件录入账号查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("accnum") == 0) {
			if (mCodeCondition != null && !mCodeCondition.equals("")) {
				mSQL = "select trim(BankAccNo),trim(AccName) from LCAccount where "
						+ mConditionField + " = " + mCodeCondition;
			}
		}
		// 用户地址代码条件查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getaddressno") == 0) {
			mSQL = "select AddressNo,PostalAddress from LCAddress where "
					+ mConditionField + " = " + mCodeCondition;
		}
		// 团体用户地址代码条件查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getgrpaddressno") == 0) {
			mSQL = "select AddressNo,GrpAddress from LCGrpAddress where "
					+ mConditionField + " = " + mCodeCondition;
		}
		// 团单险种查询交费间隔payintv
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskpayintv") == 0) {
			// mSQL =
			// "select a.PayIntv, b.CodeName from LMRiskPayIntv a,LDCode b where
			// "
			// + mConditionField + " = " + mCodeCondition
			// +
			// " and a.ChooseFlag = '1' and b.CodeType = 'payintv' and a.PayIntv
			// = b.Code order by a.PayIntv";
			// by niuzj,20060720, LMRiskPayIntv表已废弃不用

			if (mCodeCondition.equals("") || mCodeCondition == null) {
				mCodeCondition = "0";
			}
			mSQL = " select trim(b.code) as spayintv,b.codename as spayintvname "
					+ " from lmdutypay a, ldcode b "
					+ " where a.payintv=b.code and b.codetype='payintv' "
					+ " and a.payplancode in "
					+ " (select payplancode from lmdutypayrela where dutycode in "
					+ " (select dutycode from lmriskduty where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " ) ) "
					+ " union "
					+ " select trim(paramscode) as spayintv ,(select codename from ldcode where codetype = 'payintv' and paramscode = trim(code)) as spayintvname "
					+ " from lmriskparamsdef "
					+ " where paramstype='payintv' and "
					+ mConditionField
					+ " = " + mCodeCondition + " order by spayintv ";
		}
		// 查询险种代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("dutycode") == 0) {
			mSQL = "select DutyCode,DutyName from LMDuty where  dutycode in (select dutycode from lmriskduty where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ ") order by DutyCode";
		}

		// 查询给付类型 Nicholas modify for PU,2005/8/4
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getdutykind") == 0) {
			// mSQL = "select GetDutyKind,GetDutyName from LMDutyGetAlive where
			// getdutycode in (select getdutycode from lmdutygetrela where
			// dutycode in (select dutycode from lmriskduty where "
			// + mConditionField + " = " + mCodeCondition +
			// " )) order by getdutykind";
			mSQL = "select ParamsCode,ParamsName from LMRiskParamsDef where ParamsType = 'getdutykind' and "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by length(ParamsCode),ParamsCode";
		}

		// 查询保险期间 Nicholas modify for PU,2005/8/4
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("insuyear") == 0) {
			// mSQL = "select GetDutyKind,GetDutyName from LMDutyGetAlive where
			// getdutycode in (select getdutycode from lmdutygetrela where
			// dutycode in (select dutycode from lmriskduty where "
			// + mConditionField + " = " + mCodeCondition +
			// " )) order by getdutykind";
			mSQL = "select ParamsCode,ParamsName from LMRiskParamsDef where ParamsType = 'insuyear' and "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by length(ParamsCode),ParamsCode";
		}

		// xjh Add,2005/02/18
		// 机构级别 branchlevel
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("branchlevel") == 0) {
			mSQL = "select BranchLevelCode,BranchLevelName from LABranchLevel where "
					+ mConditionField
					+ " = "
					+ mCodeCondition
					+ " order by BranchLevelID";
		}
		// by zx 主管代码 managecodezx
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecodezx") == 0) {
			mSQL = "select agentcode,name from laagent where "
					+ mConditionField + " = " + mCodeCondition;

		}

		// songjian Modify 2011/05/09
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("getgrade") == 0) {
			try {
				String[] args = { "H100", "04" };
				String temp = mCodeCondition.replaceAll("'", "");
				int idx = temp.indexOf("|");
				String argGradeCode = temp.substring(0, idx);
				String argAssessType = temp.substring(idx + 1);
				mSQL = "select sj_func.showGradeCode('" + argGradeCode + "','"
						+ argAssessType + "') from dual";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			// System.out.println(argAssessType+"--------"+argGradeCode);
		}
		// lizhanwu Modify 2011/05/19
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskdetail") == 0) {
			mCodeCondition = mCodeCondition.substring(0,
					(mCodeCondition.length() - 1))
					+ "%'";
			mSQL = "select riskkind,riskname from lariskkind where risktype='riskdetail' and riskkind like "
					+ mCodeCondition;
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskkind") == 0) {
			mSQL = "select riskkind,riskname from lariskkind where risktype='riskkind'";
		}
		// xjh Modify 2005/3/22
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentgrade") == 0) {
			mSQL = "select GradeCode,GradeName from LAAgentGrade where "
					+ mConditionField + " = " + mCodeCondition
					// + " and trim(gradecode) > '00'"
					+ " order by GradeID";
			// " and substr(rtrim(gradecode),length(rtrim(gradecode))-1) >'00'
			// order by GradeID";
		}

		// liukun add 2007/1/26
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentgrade1") == 0) {
			mSQL = "select GradeCode,GradeName from LAAgentGrade where "
					+ mConditionField + " = " + mCodeCondition
					+ " order by GradeID";
		}

		// zxs 2006-06-16
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentgradebranchtype1") == 0) {
			// mSQL = "select GradeCode,GradeName from LAAgentGrade where "
			// + mConditionField + " = " + mCodeCondition
			// //+ " and trim(gradecode) > '00'"
			// +
			// " and substr(rtrim(gradecode),length(rtrim(gradecode))-1) >'00'
			// order by GradeID";
			mSQL = "select gradecode,gradename from laagentgrade where "
					+ mConditionField + " = "
					+ mCodeCondition
					// + " and trim(gradecode) > '00'"
					+ "and branchtype = '1' union all select '00' gradecode, '"
					+ bundle.getString("SQLResult")
					+ "' gradename from dual order by gradecode ";
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentgradebranchtype2") == 0) {
			mSQL = "select gradecode,gradename from laagentgrade where "
					+ mConditionField + " = " + mCodeCondition
					+ "and branchtype = '2' ";
		}

		// 工单管理
		// 小组机构信息编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("acceptcom") == 0) {
			mSQL = "select GroupNo, GroupName from LGGroup order by GroupNo";
		}

		// 业务分类编号
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("tasktoptypeno") == 0) { // 顶级分类
			mSQL = "select WorkTypeNo, WorkTypeName from LGWorkType where SuperTypeNo = '00' order by WorkTypeNo ";
		}

		// 业务分类编号
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("tasktypeno") == 0) { // 子分类
			mSQL = "select WorkTypeNo, WorkTypeName from LGWorkType where SuperTypeNo != '00' and "
					+ mConditionField
					+ "="
					+ mCodeCondition
					+ " order by WorkTypeNo ";
		}

		// 人员编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("taskmemberno") == 0) {
			mSQL = "select UserCode, UserName from LDUser order by UserCode";
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentdegrade") == 0) {
			mSQL = "";
			String agentGrade = mCodeCondition.substring(1, 5);
			String agentGrade1 = mCodeCondition.substring(6, 10);

			if ("A100".equals(agentGrade)) {
				if ("A102".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A100'";
				}
				if ("A100".equals(agentGrade1)) {
					mSQL = "select 'A000','" + bundle.getString("SQLResult")
							+ "' from dual";
				}
			} else if ("A101".equals(agentGrade)) {
				if ("A102".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A101'";
				}
				if ("A101".equals(agentGrade1)) {
					mSQL = "select 'A000','" + bundle.getString("SQLResult")
							+ "' from dual";
				}
			} else if ("A102".equals(agentGrade)) {
				if ("A201".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A111','A102')";
				} else if ("A111".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode = 'A102'";
				} else {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A100'";
				}
			} else if ("A111".equals(agentGrade)) {
				if ("A201".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A102','A111')";
				} else {
					mSQL = "select t2.gradecode,t2.gradename from laagentgrade t1,laagentgrade t2 "
							+ "where t1.gradeid=t2.gradeid+1 and t2.branchtype='1' and t1.branchtype='1' and t1.gradecode='"
							+ agentGrade1 + "'";
				}
			} else if ("A112".equals(agentGrade)) {
				if ("A201".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A111','A112')";
				} else {
					mSQL = "select t2.gradecode,t2.gradename from laagentgrade t1,laagentgrade t2 "
							+ "where t1.gradeid=t2.gradeid+1 and t2.branchtype='1' and t1.branchtype='1' and t1.gradecode='"
							+ agentGrade1 + "'";
				}
			} else if ("A113".equals(agentGrade)) {
				if ("A201".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A112','A113')";
				} else {
					mSQL = "select t2.gradecode,t2.gradename from laagentgrade t1,laagentgrade t2 "
							+ "where t1.gradeid=t2.gradeid+1 and t2.branchtype='1' and t1.branchtype='1' and t1.gradecode='"
							+ agentGrade1 + "'";
				}
			} else {
				mSQL = "select t2.gradecode,t2.gradename from laagentgrade t1,laagentgrade t2 "
						+ "where t1.gradeid=t2.gradeid+1 and t2.branchtype='1' and t1.branchtype='1' and t1.gradecode='"
						+ agentGrade1 + "'";
			}
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentpromotion") == 0) {
			mSQL = "";
			String agentGrade = mCodeCondition.substring(1, 5);
			String agentGrade1 = mCodeCondition.substring(6, 10);
			if ("A100".equals(agentGrade)) {
				if ("A000".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A100'";
				}
				if ("A100".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A102'";
				}
			} else if ("A101".equals(agentGrade)) {
				if ("A000".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A101'";
				}
				if ("A101".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A102'";
				}
			} else if ("A102".equals(agentGrade)) {
				if ("A100".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A102'";
				}
				if ("A102".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A111','A201')";
				}
				if ("A111".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A201'";
				}
			} else if ("A111".equals(agentGrade)) {
				if ("A102".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A111'";
				}
				if ("A111".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A112','A201')";
				}
				if ("A112".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A201'";
				}
			} else if ("A112".equals(agentGrade)) {
				if ("A111".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A112','A201')";
				}
				if ("A112".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A113','A201')";
				}
				if ("A113".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A201'";
				}
			} else if ("A113".equals(agentGrade)) {
				if ("A112".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A113','A201')";
				}
				if ("A113".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A201'";
				}
			} else if ("A201".equals(agentGrade)) {
				if ("A102".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A111','A201')";
				}
				if ("A111".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A112','A201')";
				}
				if ("A112".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode in ('A113','A201')";
				}
				if ("A113".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A201'";
				}
				if ("A201".equals(agentGrade1)) {
					mSQL = "select gradecode,gradename from laagentgrade where gradecode ='A202'";
				}
			} else {
				mSQL = "select t2.gradecode,t2.gradename from laagentgrade t1,laagentgrade t2 "
						+ "where t1.gradeid=t2.gradeid-1 and t2.branchtype='1' and t1.branchtype='1' and t1.gradecode='"
						+ agentGrade1 + "'";
			}
		}

		// xjh Add,2005/02/24
		// 特殊险种 SpecRisk
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("specrisk") == 0) {
			mSQL = "select riskcode,riskname from lmriskapp ";
		}
		// 团单客户服务需求
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("serverinfotype") == 0) {
			mSQL = "select ServKind,ServKindRemark from LDServKindInfo order by servkind";
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("serverinfocode") == 0) {
			mSQL = "select ServDetail,ServDetailRemark,trim(servkind)||'-'||trim(servdetail) from LDServDetailInfo where "
					+ mConditionField
					+ "="
					+ mCodeCondition
					+ "order by ServDetail";
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("serverinfochoosecode") == 0) {
			int c = mCodeCondition.indexOf("-");
			String a = mCodeCondition.substring(0, c); // 保险计划编码
			String b = mCodeCondition.substring(c + 1); // 合同号
			mSQL = "select ServChoose,ServChooseRemark from LDServChooseInfo where "
					+ mConditionField
					+ "= "
					+ a
					+ "' and  servdetail= '"
					+ b
					+ " order by ServChoose";

		}

		// add by lvliye 20080806
		// 在理赔中增加重大疾病分类
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("claimreasontype") == 0) {
			mSQL = "select code,codename from ldcode where codetype='claimreasontype' order by code";
		}
		// end

		// 银代总行HeadOffice --没有区分银行和中介代理
		// if
		// (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "headoffice") == 0) {
		// mSQL =
		// // "select AgentCom,Name from LACom where "
		// // + mConditionField + "= " + mCodeCondition
		// // + " and BankType='00' order by AgentCom";
		// "select code,codename from ldcode where codetype='headoffice' order
		// by code";
		// }
		// 银代总行BankHeadOffice added by zhanggl 2006-04-17
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankheadoffice") == 0) {
			mSQL = "select AgentCom, Name, UpAgentCom, AreaType, ChannelType from LACom where "
					+ mConditionField
					+ "= "
					+ mCodeCondition
					+ " and BankType='00' and branchtype='3' order by AgentCom";
		}

		// hanlin
		// 查询地址省、市、区代码
		// ////////////////////////////////////////////////////////////////////////////
		// 查询省份代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("province") == 0) {
			mSQL = "select placecode,placename from LDAddress where placetype='01' order by placecode";

		}
		// 查询省份代码针对保全授权转账
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("province1") == 0) {
			mSQL = "select placecode,placename,'','','','','' from LDAddress where placetype='01' order by placecode";

		}
		// 查询城市代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("city") == 0) {
			if (mCodeCondition != null && !mCodeCondition.equals("")) {
				mSQL = "select placecode,placename from LDAddress where placetype='02' and "
						+ mConditionField
						+ "="
						+ mCodeCondition
						+ "order by placecode";
			} else {
				mSQL = "select placecode,placename from LDAddess where placetype='2' order by placecode";
			}
		}
		// 查询城市代码针对保全授权转账
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("city1") == 0) {
			if (mCodeCondition != null && !mCodeCondition.equals("")) {
				mSQL = "select placecode,placename,'','','','' from LDAddress where placetype='02' and "
						+ mConditionField
						+ "="
						+ mCodeCondition
						+ "order by placecode";
			} else {
				mSQL = "select placecode,placename from LDAddess where placetype='2' order by placecode";
			}
		}
		// 查询区县代码
//		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
//				.compareTo("district") == 0) {
//			if (mCodeCondition != null && !mCodeCondition.equals("")) {
//				mSQL = "select placecode,placename from LDAddress where placetype='03'  and "
//						+ mConditionField
//						+ "="
//						+ mCodeCondition
//						+ "order by placecode";
//			} else {
//				mSQL = "select placecode,placename from LDAddress where placetype='03' order by placecode";
//			}
//
//		}

		// add by zyc
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("polityvisage") == 0) {
			mSQL = "select trim(Code), trim(CodeName) from ldcode where 1 = 1 and codetype = 'polityvisage' order by othersign";
		}
		// 离职原因
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("newdepartrsn") == 0) {
			mSQL = "select trim(Code), trim(CodeName) from ldcode where 1 = 1 and codetype = 'newdepartrsn' order by othersign";
		}

		// 保单对应的客户查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("customer") == 0) {
			mSQL = "select AppntNo,AppntName from lcappnt where "
					+ mConditionField + "=" + mCodeCondition
					+ "union select InsuredNo,Name from lcinsured where "
					+ mConditionField + "=" + mCodeCondition;

		}

		// 保单对应的客户查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zjgxbq") == 0) {
			mSQL = "select distinct a.edorcode,b.edorname from lmriskedoritem a,lmedoritem b "
					+ "where b.edorcode = a.edorcode and riskcode Like '1%' "
					+ " and riskcode Like '1%' "
					+ " union select 'ZC','"
					+ bundle.getString("SQLResult") + "' from dual ";
		}

		// JX银保查询险种代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bkriskcode") == 0) {
			mSBql.append("select distinct a.riskcode,a.riskname from lmriskapp a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("  and  RiskProp in('Y')  ");
			mSBql.append("  order by a.riskcode");
			mSQL = mSBql.toString();
		}

		// 查询银行代理网点代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankcode") == 0) {
			mSBql.append("select agentcom, Name, AgentCom, UpAgentCom, AreaType, ChannelType  from LACom a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("  and a.State='N' and BankType in('05','03','04') and SellFlag='Y' ");
			mSBql.append("  order by a.bankcode,a.managecom,substr(a.agentcom||substr('000000000000',1,12),1,12)");
			mSQL = mSBql.toString();

			executeType = 1; // add by oys 解决网点无法全部查出的问题
		}

		// 查询银行分行代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankbranchcode") == 0) {
			mSBql.append("select agentcom, Name, AgentCom, UpAgentCom, AreaType, ChannelType  from LACom a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("  and  BankType in('01')  ");
			mSBql.append("  order by a.bankcode,a.managecom");
			mSQL = mSBql.toString();

			executeType = 1; // add by oys 解决网点无法全部查出的问题
		}

		// 查询银行支行代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankbranchbranchcode") == 0) {
			mSBql.append("select agentcom, Name, AgentCom, UpAgentCom, AreaType, ChannelType  from LACom a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("  and  BankType in('02')  ");
			mSBql.append("  order by a.bankcode,a.managecom");
			mSQL = mSBql.toString();

			executeType = 1; // add by oys 解决网点无法全部查出的问题
		}

		// 查询银行代理网点代码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankcodeagentcom") == 0) {
			mSBql.append("select agentcom, Name, BankCode, UpAgentCom, AreaType, ChannelType  from LACom a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("  and a.State='N' and BankType in('05','03','04') and SellFlag='Y' ");
			mSBql.append("  order by a.managecom,AgentCom");
			mSQL = mSBql.toString();

			executeType = 1; // add by oys 解决网点无法全部查出的问题
		}

		// 银保职级系列
		// if
		// (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "agentseries") == 0) {
		// mSBql
		// .append("select a.code, a.codename from ldcode a where ");
		// mSBql.append(mConditionField);
		// mSBql.append(" = ");
		// mSBql.append(mCodeCondition);
		// mSBql.append("  order by a.code");
		// mSQL = mSBql.toString();
		//
		// executeType = 1; // add by oys 解决网点无法全部查出的问题
		// }

		// 银保考核状态
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("AssessStateName") == 0) {
			mSBql.append("select a.code, a.codename from ldcode a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append("  order by a.code");
			mSQL = mSBql.toString();

			executeType = 1; // add by oys 解决网点无法全部查出的问题
		}

		// 财务交费录入交费年度
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("standyear") == 0) {
			if (mCodeCondition != null && !mCodeCondition.equals("")) {
				mSQL = "select year,'' from LARateStandPrem where "
						+ mConditionField + "=" + mCodeCondition
						+ "order by year";
			}
		}

		// 查询银行专管员
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankagentcode") == 0) {
			mSQL = "select a.AgentCode , b.Name from LAComToAgent a ,LAAgent b where b.AgentCode = a.AgentCode and a.RelaType ='1' and "
					+ mConditionField + "=" + mCodeCondition;

		}
		// add by lvliye 20090325 代理卡单，通过代理业务员查询代理机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("cardagentcom") == 0) {
			mSBql.append("select a.agentcom , b.Name from  LAComToAgent a ,LACom b where a.AgentCom =b.agentcom and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' order by a.agentcom");
			mSQL = mSBql.toString();
		}
		// end

		// 查询银保通代付确认界面的银行代码
		// edit by sunhongyan 20090427 支持代付
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bank2") == 0) {

			mSBql.append("select distinct bankcode,bankname from lkbank a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comcode like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' and dealtype='F'");
			mSBql.append(" order by bankcode");
			mSQL = mSBql.toString();
		}

		// 查询银行代收付的银行编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bank1") == 0) {

			mSBql.append("select distinct bankcode,bankname from ldbank a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comcode like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' and bankcode not like 'JRL%'");

			// 如果为广东分公司，协议银行编码匹配显示银联协议银行名称 add by sunhongyan 20090715
			if (mGlobalInput.ManageCom.substring(0, 4).equals("8623")) {
				mSBql.append(" union select 'JRL','"
						+ bundle.getString("SQLResult") + "' from ldbank");
				mSBql.append(" where comcode like '");
				if (mGlobalInput.ManageCom.length() >= 6) {
					mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
				} else {
					mSBql.append(mGlobalInput.ManageCom);
				}
				mSBql.append("%' and bankcode like 'JRL%' and rownum=1 ");
			}
			// 如果为甘肃分公司，协议银行编码匹配显示广州银联协议银行名称 add by sunhongyan 20090820
			else if (mGlobalInput.ManageCom.substring(0, 4).equals("8633")) {
				mSBql.append(" union select 'JRL','"
						+ bundle.getString("SQLResult") + "' from ldbank");
				mSBql.append(" where comcode like '");
				if (mGlobalInput.ManageCom.length() >= 6) {
					mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
				} else {
					mSBql.append(mGlobalInput.ManageCom);
				}
				mSBql.append("%' and bankcode like 'JRL%' and rownum=1 ");
			} else {
				mSBql.append(" union select 'JRL','"
						+ bundle.getString("SQLResult") + "' from ldbank");
				mSBql.append(" where comcode like '");
				if (mGlobalInput.ManageCom.length() >= 6) {
					mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
				} else {
					mSBql.append(mGlobalInput.ManageCom);
				}
				mSBql.append("%' and bankcode like 'JRL%' and rownum=1 ");
			}
			mSBql.append(" order by bankcode");
			mSQL = mSBql.toString();
		}

		// 查询银行编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bank") == 0) {

			mSBql.append("select distinct bankcode,bankname from ldbank a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and comcode like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' order by bankcode");
			mSQL = mSBql.toString();
		}
		// 查询收付费银行
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("finbank") == 0) {
			mSQL = " select agentcom,name from lacom where banktype='00' order by agentcom ";

		}

		// 查询银行机构代码 add-by-wanglm 2013-3-25
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bankcom") == 0) {

			mSBql.append("select distinct agentcom,name from lacom a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and managecom like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' order by agentcom");
			mSQL = mSBql.toString();
		}

		// 查询经代机构代码 2013-07-23
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("brokercom") == 0) {

			mSBql.append("select distinct agentcom,name from lacom a where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype='6' and touliansellflag in('01','02') and actype = '02'");
			mSBql.append(" and managecom like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' order by agentcom");
			mSQL = mSBql.toString();
		}
		// 查询经代黑名单来源 2013-07-24
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("source") == 0) {
			mSQL = "select trim(Code), trim(CodeName)"
					+ " from ldcode where codetype = 'source'"
					+ " order by trim(code)";
		}

		// 显示总分支管理机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecomzfz") == 0) {
			mSQL = "select comcode,name from ldcom where 1=1 "
					+ " and comcode like '" + mGlobalInput.ManageCom
					+ "%' and length(trim(comcode))<= 6 order by comcode";
			executeType = 1;
		}
		// 显示总分管理机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecomzf") == 0) {
			mSQL = "select comcode,name from ldcom where 1=1 "
					+ " and comcode like '" + mGlobalInput.ManageCom
					+ "%' and length(trim(comcode))<= 4 order by comcode";
			executeType = 1;
		}
		// 显示分管理机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecomfen") == 0) {
			mSQL = "select comcode,name from ldcom where 1=1 "
					+ " and comcode like '" + mGlobalInput.ManageCom
					+ "%' and length(trim(comcode))= 4 order by comcode";
			executeType = 1;
		}

		// 经代公司信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcomfenpei") == 0) {
			mSBql.append("SELECT agentcom,name ");
			mSBql.append(" FROM lacom WHERE Managecom like '"
					+ mGlobalInput.ComCode + "%' and  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype = '6' and touliansellflag in('01','02') and SubscribeManDuty is not null and actype = '02' order by agentcom ");
			mSQL = mSBql.toString();
		}
		// 经代公司信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcomjianli") == 0) {
			mSBql.append("SELECT agentcom,name ");
			mSBql.append(" FROM lacom WHERE Managecom like '"
					+ mGlobalInput.ComCode + "%' and  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype = '6' and touliansellflag in('01','02') and SubscribeManDuty is null and actype in ('01','02') order by agentcom ");
			mSQL = mSBql.toString();
		}
		// 经代支公司
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcomzhi") == 0) {
			mSBql.append("SELECT agentcom,name ");
			mSBql.append(" FROM lacom WHERE Managecom like '"
					+ mGlobalInput.ComCode + "%' and  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype = '6' and touliansellflag in('01','02') and actype = '03' order by agentcom ");
			mSQL = mSBql.toString();
		}
		// 显示所有经代机构
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcomjdall") == 0) {
			mSBql.append("SELECT agentcom,name ");
			mSBql.append(" FROM lacom WHERE Managecom like '"
					+ mGlobalInput.ComCode + "%' and  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype = '6' order by  agentcom ");
			mSQL = mSBql.toString();
		}
		// 上级经代公司
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("upagentcomjd") == 0) {
			mSBql.append("SELECT agentcom,name ");
			mSBql.append(" FROM lacom WHERE Managecom like '"
					+ mGlobalInput.ComCode + "%' and  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype = '6' and touliansellflag in('01','02') and actype in ('01','02') order by  agentcom ");
			mSQL = mSBql.toString();
		}
		// 所有经代公司编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcomjd") == 0) {
			mSBql.append("SELECT agentcom,name ");
			mSBql.append(" FROM lacom WHERE Managecom like '"
					+ mGlobalInput.ComCode + "%' and  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype = '6' and touliansellflag in('01','02') order by  agentcom ");
			mSQL = mSBql.toString();
		}
		// 经代公司内勤人员编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentcodejd") == 0) {
			mSBql.append("SELECT agentcode,name ");
			mSBql.append(" FROM laagent WHERE Managecom like '"
					+ mGlobalInput.ComCode + "%' and  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and branchtype = '6' and agentstate in ('01','02') order by  agentcode ");
			mSQL = mSBql.toString();
		}

		// 查询影像资料类型。

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("imagetype") == 0) {
			mSQL = "select subtype,subtypename from es_doc_def where busstype='TB' order by subtype";

		}

		// 查询保全影像资料类型 add by renzd
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("imagebqtype") == 0) {
			mSQL = "select subtype,subtypename from es_doc_def where busstype='BQ' order by subtype";

		}
		// 结案单证打印 ------从“单证打印参数表（LLParaPrint）”中
		// 查询出“打印阶段（prtphase='50'）”的单证
		// and 在打印管理表《loprtmanager》中存在的单证
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llparaprtcode") == 0) {
			mSQL = "select t.prtcode,t.prtname from llparaprint t where t.prtphase='50'"
					+ " and t.prtcode in ( select code from loprtmanager  where "
					+ mConditionField
					+ " = "
					+ mCodeCondition.trim()
					+ ")"
					+ " order by t.prtcode";

		}

		// 收付费银行查询 ///
		/**
		 * zhoull 2009-01-20 修改为从accautomapping表中查询匹配关系
		 */
		// if
		// (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "comtobank") == 0) {
		//
		// mSBql
		// .append("select distinct bankcode,BankName from LDComToBank where ");
		// mSBql.append(mConditionField);
		// mSBql.append(" = ");
		// mSBql.append(mCodeCondition);
		// mSBql.append(" and comcode like '");
		// if (mGlobalInput.ManageCom.length() >= 6) {
		// mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
		// } else {
		// mSBql.append(mGlobalInput.ManageCom);
		// }
		// mSBql.append("%' and acctype='1' order by bankcode");
		// mSQL = mSBql.toString();
		// }
		//
		// if
		// (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "banktocom") == 0) {
		//
		// mSBql
		// .append("select distinct bankcode,BankName from LDComToBank where ");
		// mSBql.append(mConditionField);
		// mSBql.append(" = ");
		// mSBql.append(mCodeCondition);
		// mSBql.append(" and comcode like '");
		// if (mGlobalInput.ManageCom.length() >= 6) {
		// mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
		// } else {
		// mSBql.append(mGlobalInput.ManageCom);
		// }
		// mSBql.append("%' and acctype='2' order by bankcode");
		// mSQL = mSBql.toString();
		// }
		// 收费
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("comtobank") == 0) {
			mSBql.append("select distinct InBankCode,InAccName from AccAutoMapping where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' and acctype='1' order by Inbankcode");
			mSQL = mSBql.toString();
		}
		// 付费
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("banktocom") == 0) {
			mSBql.append("select distinct InBankCode,InAccName from AccAutoMapping where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' and acctype='2' order by Inbankcode");
			mSQL = mSBql.toString();
		}

		// 手续费付费 add by sunhongyan 20090717 匹配显示付款帐号
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("sxfbanktocom") == 0) {
			mSBql.append("select distinct InBankCode,InAccName from AccAutoMapping where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");

			if (mGlobalInput.ManageCom.length() < 8) {
				String tManageCom = mGlobalInput.ManageCom;
				int nLength = tManageCom.length();
				for (int x = 0; x < (8 - nLength); x++) {
					tManageCom = tManageCom + "0";
				}
				mSBql.append(tManageCom);
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' and acctype='2' and serialno ='06' order by Inbankcode");
			mSQL = mSBql.toString();
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("CertifyCode") == 0) {
			mSQL = "SELECT CertifyCode, CertifyName FROM LMCertifyDes WHERE 1 = 1"
					+ " and CertifyClass = 'P' or CertifyClass = 'D' AND State = '0'"
					+ " order by CertifyCode";
			m_bCanBeCached = false;
			executeType = 1;
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("accno") == 0) {
			mSBql.append("select distinct InBankAccNo,'' from AccAutoMapping where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' and acctype = '1' ");
			mSBql.append(" order by InBankAccNo");
			mSQL = mSBql.toString();
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("accno2") == 0) {
			mSBql.append("select distinct InBankAccNo,'' from AccAutoMapping where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and ManageCom like '");
			if (mGlobalInput.ManageCom.length() >= 6) {
				mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
			} else {
				mSBql.append(mGlobalInput.ManageCom);
			}
			mSBql.append("%' and acctype = '2' ");
			mSBql.append(" order by InBankAccNo");
			mSQL = mSBql.toString();
		}// zhoull 2009-01-20 end
		/**
		 * 
		 */

		// 理赔人工核保险种核保结论 add by wanzh 2005/12/19
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lluwstate") == 0) {
			System.out.println("mConditionField:" + mConditionField);
			if (mCodeCondition != null && !mCodeCondition.equals("")) {
				String tSql = "select subriskflag from lmriskapp where riskcode = "
						+ mCodeCondition;
				ExeSQL tExeSQL = new ExeSQL();
				String tRiskFlag = tExeSQL.getOneValue(tSql);
				System.out.println("tRiskFlag:" + tRiskFlag);
				if (tRiskFlag != null && tRiskFlag.equals("S")) {
					System.out.println("tRiskFlagjinru:" + tRiskFlag);
					mSQL = " select trim(Code), trim(CodeName) from ldcode where 1 = 1"
							+ " and codetype='lluwstate' and code in ('1','2','9','b')"
							+ " order by othersign";

				} else {
					mSQL = " select trim(Code), trim(CodeName) from ldcode where 1 = 1"
							+ " and codetype='lluwstate' and code in ('1','2','3','4','9')"
							+ " order by othersign";
				}
			}
		}

		// 理赔人工核保通知书发出 add by wanzh 2005/12/19
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lluwnoticesend") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'lluwnotice' and code "
					+ " in('LP00','LP06','LP81','LP82','LP83','LP86','LP89') order by code ";
		}
		// 理赔人工核保通知书打印 add by wanzh 2005/12/19
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lluwnoticeprint") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'lluwnotice' and code "
					+ " in('LP00','LP06','LP81','LP82','LP83','LP86','LP88','LP89') order by code ";
		}

		// /////////////////////////////////////////////////////////////////////////////

		// 承保单整单删除原因 add by chenrong 2006/07/11
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("proposaldelreason") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'proposaldelreason'"
					+ " order by length(code),code";
		}

		// 扫描件删除原因 add by chenrong 2006/07/20
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("scandelreason") == 0) {
			mSQL = "select trim(code),trim(codename) from ldcode  where codetype = 'scandelreason'"
					+ " order by length(code),code";
		}

		// 机构 add by luzheng 20070607

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lfcomfin") == 0) {
			mSQL = " select COMFIN,name from lfcomfin";

		}
		// add by wangyh 英式分红 20110125
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("engriskcode") == 0) {
			mSQL = " select riskcode,riskname from lmriskapp where bonusflag=2";

		}

		// add by wangyh 临时分红 20110215
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("tempriskcode") == 0) {
			mSQL = " select riskcode,riskname from lmriskapp where bonusflag=1 and risktype3='2' order by riskcode";

		}
		// add by wangyh 英式分红可投资额度 20110221
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskcodeengbn") == 0) {
			mSQL = " select riskname,riskcode from lmriskapp where bonusflag=2 and risktype3='2' order by riskcode";

		}

		// add by zhaopeng 20110406
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("scanquerychnl") == 0) {
			mSQL = " select code,codename from ldcode where codetype = 'salechnl' and code in ('1','3','5','7','8') order by code";

		}

		/**
		 * 银保渠道专用，选择险种编码 add by zhoull 2009-04-10
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bank_chnl_risk") == 0) {
			mSQL = "select riskcode,name from (select riskcode,riskname name from lmriskapp where "
					+ "riskcode in (select riskcode from lmriskcomctrl where salechnl = '3' AND SYSDATE BETWEEN startdate AND enddate)"// 正常险种
					+ " union "
					+ "select ContPlanCode riskcode,ContPlanName name from LDPlan "
					+ "where managecom like '86%' and state='9' AND EXISTS"
					+ " (SELECT 1 FROM LMCARDRISK B WHERE CONTPLANCODE = B.RISKCODE))"
					+ " order by riskcode";// 卡单计划
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskplan_chnl") == 0) {
			mSQL = "select ContPlanCode,ContPlanName from LDPlan"
					+ " where state='9' AND EXISTS"
					+ " (SELECT 1 FROM LMCARDRISK B WHERE CONTPLANCODE = B.RISKCODE)"
					+ " order by ContPlanCode";// 卡单计划
		}

		// add by zhaopeng 20100315 理赔结案增加外包公司选择，增加其他
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bpolist") == 0) {
			mSQL = "select bpoid,bponame from (select rownum, bpoid,bponame from bposerverinfo where type = 'TPA'"
					+ " union select 9999,'other','"
					+ bundle.getString("SQLResult") + "' from dual order by 1)";
		}

		/* 帐户自动匹配规则需要增加此sql，特殊处理 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("tempbank") == 0) {
			java.util.StringTokenizer token = new java.util.StringTokenizer(
					mCodeCondition, "|", true);
			String payMode = token.nextToken().substring(1, 2);
			token.nextToken();
			String manageCom = token.nextToken();
			token.nextToken();
			String bank = token.nextToken();
			String bankCode = bank.substring(0, bank.indexOf("'"));

			if ("4".equals(payMode) || "3".equals(payMode)) {
				mSBql.append("select code,codename from ldcode where codetype='headoffice' ");

				// mSBql.append(" and comcode like '");
				// if (mGlobalInput.ManageCom.length() >= 6) {
				// mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
				// } else {
				// mSBql.append(mGlobalInput.ManageCom);
				// }
				mSBql.append(" order by code");
			} else if ("7".equals(payMode)) {
				mSBql.append("select distinct bankcode,bankname from ldbank  where ");
				mSBql.append(" comcode like '");
				if (mGlobalInput.ManageCom.length() >= 6) {
					mSBql.append(mGlobalInput.ManageCom.substring(0, 6));
				} else {
					mSBql.append(mGlobalInput.ManageCom);
				}
				mSBql.append("%' order by bankcode");
			}

			mSQL = mSBql.toString();
		}
		// add by lvliye 20080401
		// 理赔合同处理中终止结论的选项
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("llcontpoldealtype") == 0) {
			mSBql.append("select Code1, CodeName, CodeAlias, ComCode, OtherSign from ldcode1 where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype = '");
			mSBql.append(StrTool.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase());
			mSBql.append("' order by Code1");
			mSQL = mSBql.toString();
		}
		// end
		/* by zhulin 2008-07-04 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("insuaccrisk") == 0) {
			mSBql.append("SELECT DISTINCT a.riskcode,a.riskname FROM lmriskapp a,lmrisktoacc b,lmriskinsuacc c where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and  a.riskcode=b.riskcode AND b.insuaccno=c.insuaccno AND c.acccomputeflag!='0' and accratetable is null AND a.bonusflag='0' ");
			mSBql.append(" order by a.riskcode");
			mSQL = mSBql.toString();
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskinsuacc") == 0) {
			mSBql.append("SELECT DISTINCT c.insuaccno,c.insuaccname FROM lmriskapp a,lmrisktoacc b,lmriskinsuacc c where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and  a.riskcode=b.riskcode AND b.insuaccno=c.insuaccno AND c.acccomputeflag!='0' and accratetable is null AND a.bonusflag='0' ");
			mSBql.append(" order by c.insuaccno");
			mSQL = mSBql.toString();
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("bqedorpopedom") == 0) {
			mSBql.append("select EdorPopeDom,EdorPopeDomName from LDEdorPopedomDef");
			mSQL = mSBql.toString();
		}
		// and by rzd for 万能险可投资额度
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskcodexy") == 0) {
			mSBql.append("select CodeName,code,CodeAlias, ComCode, OtherSign from ldcode1 where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype = '");
			mSBql.append(StrTool.cTrim(mLDCodeSchema.getCodeType() + "'")
					.toLowerCase());

			mSQL = mSBql.toString();
		}
		// and by rzd for 分红险可投资额度
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("riskcodebn") == 0) {
			mSBql.append("select CodeName,code,CodeAlias, ComCode, OtherSign from ldcode1 where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype = '");
			mSBql.append(StrTool.cTrim(mLDCodeSchema.getCodeType() + "'")
					.toLowerCase());

			mSQL = mSBql.toString();
		}
		// added by doulongyin 派发公司红利及利息录入时查询产品类型 2011年3月7日
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("producttype1") == 0) {
			mSQL = "select RiskCode,RiskName from LMRiskApp where BonusFlag IN ('2','1') order by RiskCode";
		}

		// and by sunhongyan for 资金平台核对报表
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("fmpbankcode") == 0) {

			mSQL = "SELECT DISTINCT bankcode,(SELECT b.codename FROM ldcode b WHERE b.codetype='headoffice' AND b.code=a.bankcode) FROM ldprobankcontrast a WHERE a.inbankcode LIKE 'FMP%' AND a.polmngcom LIKE '"
					+ mGlobalInput.ManageCom + "%' ORDER BY bankcode";
		}

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("allriskcode") == 0) {
			mSBql.append("SELECT riskcode,riskname FROM lmriskapp  where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" order by riskcode");
			mSQL = mSBql.toString();
		}

		// /////////////////套餐险种初始化//////////////////by zhangcb
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("contplan") == 0) {
			String tManageCom = this.mGlobalInput.ManageCom;
			mSBql.append("select contplancode,contplanname from ldplan where state='9' and ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			if (mCodeCondition == null || "".equals(mConditionField)) {
				mSBql.append(" 1=1 ");
			}
			mSBql.append(" order by contplancode");
			mSQL = mSBql.toString();
		}
		/**
		 * 个险渠道专用，选择险种编码 add by dingzg 2010-4-13
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("gx_chnl_risk") == 0) {
			mSQL = "select riskcode,name from (select riskcode, riskname name from lmriskapp where "
					+ " riskcode in (select riskcode from lmriskcomctrl where salechnl = '1' AND SYSDATE BETWEEN startdate AND enddate)"// 正常险种
					+ " union "
					+ "select ContPlanCode riskcode, ContPlanName name from LDPlan "
					+ "where managecom like '86%' and state = '9' AND EXISTS"
					+ " (SELECT 1 FROM LMCARDRISK B WHERE CONTPLANCODE = B.RISKCODE))"
					+ " order by riskcode";// 卡单计划
		}
		/**
		 * 中介个险渠道专用，选择险种编码 add by dingzg 2010-5-13
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("zjgx_chnl_risk") == 0) {
			mSQL = "SELECT RISKCODE, RISKNAME NAME FROM LMRISKAPP WHERE RISKCODE IN ("
					+ "SELECT RISKCODE FROM lmriskcomctrl WHERE SALECHNL = '7' AND SYSDATE BETWEEN startdate AND enddate) ORDER BY RISKCODE";
		}

		/*
		 * 注释多余代码 下面代码在两处有 modified by hufeng 2010-5-31 // 其他LDCODE表中定义的引用 if
		 * (mSQL.equals("")) { // mSBql .append("select trim(Code),
		 * trim(CodeName), trim(CodeAlias), trim(ComCode), trim(OtherSign) from
		 * ldcode where "); mSBql.append(mConditionField); mSBql.append(" = ");
		 * mSBql.append(mCodeCondition); mSBql.append(" and codetype = '");
		 * mSBql.append(StrTool.cTrim(mLDCodeSchema.getCodeType())
		 * .toLowerCase()); mSBql.append("' order by Code");
		 * 
		 * mSQL = mSBql.toString(); }
		 */

		/**
		 * 按业务员代码选择对应的销售方式 added by hufeng 2010-5-24
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("selltype2") == 0) {
			mSBql.append("select code1,codename from ldcode1 where codetype='salechnltoselltype' and code = (select branchtype from laagent where ");
			// mSBql.append(mConditionField);
			// mSBql.append("=");
			mSBql.append(mCodeCondition);
			mSBql.append(")");
			mSQL = mSBql.toString();
			executeType = 1;
		} // added by hufeng 2010-5-24
		/**
		 * 按业务员代码选择对应的销售方式 added by hufeng 2010-5-26
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("selltype1") == 0) {
			mSBql.append("select distinct code1,codename from ldcode1 where codetype='salechnltoselltype' and ");
			// mSBql.append(mConditionField);
			// mSBql.append("=");
			mSBql.append(mCodeCondition);
			// mSBql.append(")");
			mSQL = mSBql.toString();
			executeType = 1;
		} // added by hufeng 2010-5-26

		/**
		 * 保全特殊排序，将中国放在第一位 added by 2010-06-24
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("enativeplace") == 0) {
			mSBql.append("select trim(Code), trim(CodeName), trim(CodeAlias), trim(ComCode), trim(OtherSign) from ldcode where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype = 'nativeplace'");
			// tianzf 20150123 迁移sqlserver
			// mSBql.append(" order by decode(Code,'CHN','1',Code)");
			mSBql.append(" order by (case code when 'CHN' then 1 else code end)");

			mSQL = mSBql.toString();
		}
		// /**
		// * 资金管理平台，省
		// * added by 2010-10-12
		// */
		// if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "bankareap") == 0){
		// mSBql
		// .append("select distinct trim(code1), trim(codename) from ldcode1card
		// where ");
		// mSBql.append(mConditionField);
		// mSBql.append(" = ");
		// mSBql.append(mCodeCondition);
		// mSBql.append(" and codetype = 'BankArea'");
		// mSBql.append(" and CODE like substr('"
		// + this.mGlobalInput.ManageCom + "',0,4)||'%'");
		// mSQL = mSBql.toString();
		//
		// }
		// /**
		// * 资金管理平台，市
		// * added by 2010-10-12
		// */
		// if(StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase().compareTo(
		// "bankareac") == 0){
		// mSBql
		// .append("select distinct trim(comcode), trim(codealias) from ldcode1
		// where ");
		// mSBql.append("code1='"+mConditionField+"'");
		// mSBql.append(" and codetype = 'BankArea'");
		// mSBql.append(" and CODE like substr('"
		// + this.mGlobalInput.ManageCom + "',0,4)||'%'");
		// mSQL = mSBql.toString();
		//
		// }
		/**
		 * 资金管理平台，银行编码 added by 2010-10-12
		 */
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("headoffice") == 0) {
			// if(mConditionField.equals("contrast")){
			// mSBql
			// .append("SELECT code,codename FROM ldcode a WHERE EXISTS (SELECT
			// aa.bb FROM (SELECT c.bankcode bb FROM ldprobankcontrast c WHERE
			// ");
			// mSBql.append("EXISTS (SELECT 1 FROM ldbank b WHERE
			// bankacctype='1' AND b.bankcode=c.inbankcode) ");
			// mSBql.append("UNION SELECT c.bankcode bb FROM ldprobankcontrast c
			// ");
			// mSBql.append("WHERE EXISTS (SELECT 1 FROM ldbank b WHERE
			// bankacctype='5' AND b.bankcode=c.inbankcode) ");
			// mSBql.append(" UNION SELECT c.bankcode bb FROM ldprobankcontrast
			// c ");
			// mSBql.append("WHERE EXISTS (SELECT 1 FROM ldbank b WHERE
			// bankacctype='7' ");
			// mSBql.append("AND b.bankcode=c.inbankcode) ) aa WHERE
			// aa.bb=a.code) AND codetype ='headoffice'");
			// mSBql.append(" AND EXISTS (SELECT * FROM ldcode1 WHERE
			// codetype='BankAreaName' AND comcode=A.code AND
			// CODE="+mCodeCondition+")");
			// mSQL = mSBql.toString();
			// }else{
			// mSBql.append("select code,codename FROM ldcode a WHERE ");
			// mSBql.append("a.codetype ='headoffice' AND ");
			// mSBql.append("EXISTS (SELECT 1 FROM ldbank b WHERE b.bankacctype
			// ='2' AND b.bankselfcode =a.code)");
			// mSQL = mSBql.toString();
			// }
			if (mConditionField.equals("contrast")) {
				mSBql.append("SELECT code,codename FROM ldcode a WHERE EXISTS (SELECT aa.bb FROM (SELECT c.bankcode bb FROM ldprobankcontrast c WHERE ");
				mSBql.append("EXISTS  (SELECT 1 FROM ldbank b WHERE bankacctype='1' AND b.bankcode=c.inbankcode) AND c.polmngcom LIKE substr('"
						+ this.mGlobalInput.ManageCom + "',0,6)||'%' ");
				mSBql.append("UNION SELECT c.bankcode bb FROM ldprobankcontrast c ");
				mSBql.append("WHERE EXISTS  (SELECT 1 FROM ldbank b WHERE bankacctype='5' AND b.bankcode=c.inbankcode) AND c.polmngcom LIKE substr('"
						+ this.mGlobalInput.ManageCom + "',0,4)||'%' ");
				mSBql.append(" UNION SELECT c.bankcode bb FROM ldprobankcontrast c ");
				mSBql.append("WHERE EXISTS  (SELECT 1 FROM ldbank b WHERE bankacctype='7' ");
				mSBql.append("AND b.bankcode=c.inbankcode) AND c.polmngcom LIKE substr('"
						+ this.mGlobalInput.ManageCom
						+ "',0,6)||'%' ) aa WHERE aa.bb=a.code) AND codetype ='headoffice'");
				mSQL = mSBql.toString();
			} else {
				mSQL = "select code,codename from ldcode where codetype='headoffice' order by code";

			}

		}
		// 保全授权转账，银行编码
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("headoffice1") == 0) {
			mSBql.append("SELECT A.CODE, A.CODENAME,(SELECT code1 FROM ldcode1 WHERE codetype='BankAreaName' AND comcode=A.code AND CODE="
					+ mCodeCondition
					+ " AND ROWNUM=1),'','' FROM LDCODE A WHERE A.CODETYPE = 'headoffice'");
			mSBql.append(" AND EXISTS (SELECT aa.bb FROM (SELECT c.bankcode bb FROM ldprobankcontrast c WHERE EXISTS  (SELECT 1 FROM ldbank b WHERE bankacctype='1' AND b.bankcode=c.inbankcode)AND c.polmngcom LIKE substr('"
					+ this.mGlobalInput.ManageCom + "',0,6)||'%' ");
			mSBql.append("UNION SELECT c.bankcode bb FROM ldprobankcontrast c ");
			mSBql.append("WHERE EXISTS  (SELECT 1 FROM ldbank b WHERE bankacctype='5' AND b.bankcode=c.inbankcode) AND c.polmngcom LIKE substr('"
					+ this.mGlobalInput.ManageCom + "',0,4)||'%' ");
			mSBql.append(" UNION SELECT c.bankcode bb FROM ldprobankcontrast c ");
			mSBql.append("WHERE EXISTS  (SELECT 1 FROM ldbank b WHERE bankacctype='7' ");
			mSBql.append("AND b.bankcode=c.inbankcode)AND c.polmngcom LIKE substr('"
					+ this.mGlobalInput.ManageCom
					+ "',0,6)||'%' ) aa WHERE aa.bb=a.code)");
			mSQL = mSBql.toString();
		}

		// 产品管理需求显示机构组信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("managecomgrp") == 0) {
			mSBql.append("SELECT comgrpcode,comgrpname,comgrpdescription,comgrptype FROM ldcomgrp order by comgrpcode");
			mSQL = mSBql.toString();
		}
		// 个险招聘来源
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("mancource") == 0) {
			mSBql.append("select trim(Code), trim(CodeName) from ldcode where 1 = 1 and codetype = 'mancource' order by othersign");
			mSQL = mSBql.toString();
		}
		// 电销渠道代理机构信息查询
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("telsaleagentcom") == 0) {
			String telsaleManageCom = "";
			if (this.mGlobalInput.ManageCom.length() > 4) {
				telsaleManageCom = this.mGlobalInput.ManageCom.substring(0, 4);
			} else {
				telsaleManageCom = this.mGlobalInput.ManageCom;
			}
			mSBql.append("SELECT agentcom,NAME FROM lacom a WHERE a.managecom LIKE '"
					+ telsaleManageCom
					+ "%' AND a.branchtype='5' AND a.state='N' AND EXISTS (SELECT 1 FROM lacomtoagent b WHERE a.agentcom=b.agentcom)");
			mSQL = mSBql.toString();
		}

		// 查询所有的险种信息
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("allrisk") == 0) {
			mSBql.append("SELECT riskcode,riskname,subriskflag FROM lmriskapp ORDER BY riskcode");
			mSQL = mSBql.toString();
		}

		// 问题件类型查询（内部问题件和外部问题件）
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("backobj") == 0) {
			mSBql.append("SELECT CODE,codename FROM ldcode WHERE codetype='backobj'");

			if (mConditionField.equals("0000001002")) {
				mSBql.append(" and code=" + mCodeCondition);
			}
			mSQL = mSBql.toString();
		}

		// add by huoshengguo 调整续保二核核保结论显示顺序
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("contrenewalstate") == 0) {
			mSBql.append("select trim(Code), trim(CodeName), trim(CodeAlias), trim(ComCode), trim(OtherSign) from ldcode where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype = '");
			mSBql.append(StrTool.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase());
			mSBql.append("' order by CodeName");

			mSQL = mSBql.toString();
		}
		//

		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("renewalstate") == 0) {
			mSBql.append("select trim(Code), trim(CodeName), trim(CodeAlias), trim(ComCode), trim(OtherSign) from ldcode where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype = '");
			mSBql.append(StrTool.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase());
			mSBql.append("' order by CodeName");

			mSQL = mSBql.toString();
		}
		// 体检医院的下拉列表显示
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("hospitname") == 0) {
			mSBql.append("select trim(hospitcode),trim(hospitname) from ldhospital where  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and fixflag in ('1','2') ");
			mSBql.append(" and AreaCode like '");
			mSBql.append(mGlobalInput.ManageCom);
			mSBql.append("%' ");
			// mSBql.append(" and areacode like '");
			// mSBql.append(mGlobalInput.ManageCom);
			// mSBql.append("%'");
			mSBql.append(" union (select '00','"
					+ bundle.getString("SQLResult") + "' from dual) ");

			mSQL = mSBql.toString();
		}
		// 英文个人险种 add by hele
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("enriskcode") == 0) {
			mSBql.append("SELECT riskcode,riskname FROM lmriskapp  where RiskProp in ('I','Y')");
			mSBql.append(" order by riskcode");
			mSQL = mSBql.toString();
		}
		// 续收渠道收费部/组下拉列表显示
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("xqbranchattr") == 0) {
			mSBql.append("select trim(branchattr),trim(name) from labranchgroup where  ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and endflag = 'N' and length(managecom)>=6");
			mSBql.append(" and Managecom like '" + mGlobalInput.ComCode + "%'");
			mSQL = mSBql.toString();
		}
		// 锁控模块下拉列表显示
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("lockmodule") == 0) {
			mSQL = "select trim(lockmodule),trim(modulename),trim(remark) from lockbase order by lockmodule";
		}
		// 数据修改统计报表界面修改人的下拉列表显示
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("changeperson") == 0) {
			mSBql.append("SELECT DISTINCT a.usercode, (SELECT username  FROM lduser   WHERE usercode = a.usercode) ");
			mSBql.append(" FROM ldusertomenugrp a, ldmenugrptomenu b WHERE ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and a.menugrpcode = b.menugrpcode AND b.nodecode IN ('9295','9296','9297','9294') order by a.usercode");
			mSQL = mSBql.toString();
		}
		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("agentname") == 0) {
			mSBql.append("SELECT name,agentcode ");
			mSBql.append(" FROM laagent WHERE ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSQL = mSBql.toString();
		}


		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("versioncalcode") == 0) {
			transI18NFlag=false;
			mSQL = "select basecode,name from lrbase where status='04' order by basecode";
		}


		else if (StrTool.cTrim(mLDCodeSchema.getCodeType()).toLowerCase()
				.compareTo("versioncaltype") == 0) {
			transI18NFlag=false;
			mSQL = "select code,codename from ldcode where codetype='versioncaltype' order by code";
		}

		

		// 其他LDCODE表中定义的引用
		if (mSQL.equals("")) {
			//
			mSBql.append("select ltrim(rtrim(Code)), ltrim(rtrim(CodeName)), ltrim(rtrim(CodeAlias)), ltrim(rtrim(ComCode)), ltrim(rtrim(OtherSign)) from ldcode where ");
			mSBql.append(mConditionField);
			mSBql.append(" = ");
			mSBql.append(mCodeCondition);
			mSBql.append(" and codetype = '");
			mSBql.append(StrTool.cTrim(mLDCodeSchema.getCodeType())
					.toLowerCase());
			mSBql.append("' order by Code");

			mSQL = mSBql.toString();
		}

		System.out.println("CodeQueryBL SQL : " + mSQL);
		if (executeType == 0) {
			// 使用截取方式查询
			mResultStr = mExeSQL.getEncodedResult(mSQL, 1);
		} else {
			// 如果不是使用截取方式查询，并且没有其它的条件列
			if (this.m_bCanBeCached == true) {
				// 如果SQL中包含有8621%之类的语句，表示有管理机构之类的条件，也不能使用缓存
				if (mSQL.matches(".*86.*\\%.*")) {
					mResultStr = mExeSQL.getEncodedResult(mSQL);
				} else {
					mResultStr = (String) this.m_hashResultStr.get(mSQL);

					if (mResultStr == null) {
						mResultStr = mExeSQL.getEncodedResult(mSQL);

						if (mResultStr.length() > 500) {
							this.m_hashResultStr.put(mSQL, TOO_LONG_FLAG);
						} else {
							this.m_hashResultStr.put(mSQL, mResultStr);
						}
					} else if (mResultStr.equals(TOO_LONG_FLAG)) {
						mResultStr = mExeSQL.getEncodedResult(mSQL);
					}
				}
			} else {
				mResultStr = mExeSQL.getEncodedResult(mSQL);
			}

			// else if (executeType == 1)
			// 全部数据查询
			// mResultStr = mExeSQL.getEncodedResult(mSQL);
		}

		if (mExeSQL.mErrors.needDealError()) {
			// @@错误处理,在ExeSQL中已进行错误处理，这里直接返回即可。
			this.mErrors.copyAllErrors(mExeSQL.mErrors);
			// 如果sql执行错误，则返回sql描述
			System.out.println("Code Query Error Sql:" + mSQL);
		}
		mResult.clear();
		if (transI18NFlag) {
			mResultStr = transI18N(mResultStr);
		}
		mResult.add(mResultStr);
		return true;
	}

	/** 国际化翻译 */
	private String transI18N(String str) {
		StringBuffer mResult = new StringBuffer(256); // modified by liuqiang
		String[] str1 = str.split("\\" + SysConst.RECORDSPLITER); // 拆分字符串，形成返回的数组
		// Locale locale = this.mGlobalInput.locale;
		// StringManager mes = null;
		// try
		// {
		// if(locale!=null)
		// {
		// mes =StringManager.getManager("i18n",locale);
		// }
		// else
		// {
		// mes = StringManager.getManager("i18n",Locale.getDefault());
		// }
		// }
		// catch(Throwable e)
		// {
		// return str;
		// }
		String[] arrField = str1[0].split("\\" + SysConst.PACKAGESPILTER); // 拆分字符串,将每个纪录拆分为一个数组
		if (!arrField[0].equals("0")) {
			return str;
		}
		mResult.append("0" + SysConst.PACKAGESPILTER + arrField[1]);
		int length = str1.length;
		for (int i = 1; i < length; i++) {
			mResult.append(SysConst.RECORDSPLITER);
			arrField = str1[i].split("\\" + SysConst.PACKAGESPILTER); // 拆分字符串,将每个纪录拆分为一个数组
			String i18nName = null;
			for (int j = 0; j < arrField.length; j++) {
				if (j == 0) {
					// 代码
					String code = arrField[j];
					try {
						i18nName = bundle.getString("ldcode_"
								+ mLDCodeSchema.getCodeType().toLowerCase()
								+ "_" + code.toLowerCase());
					} catch (Throwable e) {
						i18nName = null;
					}
					/** 由于导出的时候把前面的0丢了，所以暂时这样处理 */
					if (i18nName == null) {
						String code2 = code.toLowerCase();
						try {
							int code3 = Integer.parseInt(code2);
							code2 = String.valueOf(code3);
							i18nName = bundle.getString("ldcode_"
									+ mLDCodeSchema.getCodeType().toLowerCase()
									+ "_" + code2);
						} catch (Throwable ex) {
							i18nName = null;
						}
					}
					if (i18nName == null || i18nName.equals("")) {
						i18nName = null;
					}
				}
				if (j == 1) {
					if (i18nName != null)
						arrField[j] = i18nName;
				}
				mResult.append(arrField[j] + SysConst.PACKAGESPILTER);
			}
		}
		return mResult.toString();
	}

	public String transI18NMenu(String str) {
		if ("".equals(str)) {
			return "";
		}
		StringBuffer mResult = new StringBuffer(256); // modified by liuqiang
		// String[] str1 = str.split("\\"+SysConst.RECORDSPLITER); //
		// ?????逸?????????????????
		// Locale locale = this.mGlobalInput.locale;
		// StringManager mes = null;
		try {
			/*
			 * if(locale!=null) { mes =StringManager.getManager("i18n",locale);
			 * } else { mes = StringManager.getManager("i18n",Locale.ENGLISH); }
			 */
		} catch (Throwable e) {
			return str;
		}
		/*
		 * String tRet =mes.getString(str); if(tRet==null||tRet.equals("")){
		 * tRet = str; }
		 */
		return str;// tRet
	}

	/**
	 * 测试函数
	 * 
	 * @param args
	 *            String[]
	 */
//	public static void main(String[] args) {
//		// CodeQueryBL codeQueryBL1 = new CodeQueryBL();
//		// codeQueryBL1.mLDCodeSchema.setCodeType("comcode");
//		// codeQueryBL1.queryData();
//		// VData tVData = codeQueryBL1.getResult();
//		// System.out.println(codeQueryBL1.mSQL);
//		// System.out.println(tVData.get(0));
//	}
}
