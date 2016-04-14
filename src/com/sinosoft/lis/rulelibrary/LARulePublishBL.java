/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubFun1;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;
public class LARulePublishBL {
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    private String mOperate;// 数据操作字符串
    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
    private MMap mMap = new MMap();
    private VData mResult = new VData();// 存放返回数据的容器

    private String mBaseCode = "";
    private String mName = "";
    private String mBranchType = "";
    private String mStatus = "";
    private String mReason="";
    List mRuleGrid = new ArrayList();//查询结果

    private String currentDate = PubFun.getCurrentDate();
    private String currentTime = PubFun.getCurrentTime();

    public LARulePublishBL() {
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
            if(!mErrors.needDealError()) {
                CError.buildErr(this, bundle.getString("Src_BL_dealDateErr"));
            }
            return false;
        }

        //开始提交
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
     * 从输入数据中得到所有对象
     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
     */
    public boolean getInputData(VData cInputData) {
        // 全局变量
        mGlobalInput = (GlobalInput) cInputData.get(0);
        TransferData transferData = (TransferData) cInputData.get(1);
        mBaseCode = (String)transferData.getValueByName("BaseCode");
        mName = (String)transferData.getValueByName("Name");
        mBranchType = (String)transferData.getValueByName("BranchType");
        mStatus = (String)transferData.getValueByName("Status");
        mReason = (String)transferData.getValueByName("Reason");
        mRuleGrid = (List)transferData.getValueByName("mulRuleGrid");//查询结果

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
    	String[] str= new String[8]; 
    	str=(String[])mRuleGrid.get(0);
    	String EdorNo=PubFun1.CreateMaxNo("LRBaseB", 20);
    	//String EdorNo1=PubFun1.CreateMaxNo("LRIndexVsCommB", 20);
    	//String EdorNo2=PubFun1.CreateMaxNo("LRAssessIndexB", 20);
		String Operator2= mGlobalInput.Operator;
		String MakeTime2=currentTime;
		String MakeDate2=currentDate;
		String ModifyTime2=currentTime;
		String ModifyDate2=currentDate;
        if (mOperate.equals("RulePublish")) {
        	
            //审核通过
        	String tem="insert into LRBaseB(EdorNo,Operator2,MakeTime2,MakeDate2,ModifyTime2,ModifyDate2,BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,EDORTYPE) select '"+EdorNo+"','"+Operator2+"','"+MakeTime2+"','"+MakeDate2+"','"+ModifyTime2+"','"+ModifyDate2+"',BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,'01' from LRBase where BaseCode='"+str[1]+"'";
        	String tem1="insert into LRIndexVsCommB (EdorNo,BASECODE, MANAGECOM, INDEXTYPE, AGENTGRADE, WAGECODE, WAGENAME, BRANCHTYPE, INDEXCODE, WAGEORDER, BRANCHTYPE2, INDEXSERISE, DESCRIPTION) select '"+EdorNo+"',BASECODE, MANAGECOM, INDEXTYPE, AGENTGRADE, WAGECODE, WAGENAME, BRANCHTYPE, INDEXCODE, WAGEORDER, BRANCHTYPE2, INDEXSERISE, DESCRIPTION  from lrindexvscomm where BaseCode='"+str[1]+"'";
        	String tem2="insert into LRAssessIndexB (EdorNo,BASECODE, INDEXCODE, INDEXNAME, INDEXTYPE, BRANCHTYPE, INDEXSET, CALTYPE, CALCODE, DATATYPE, DEFAULTVALUE, ITABLENAME, ICOLNAME, RESULTTYPE, CALPRPTY, BRANCHTYPE2, INDEXSERISE, CALSQL, MAININDEXFLAG, DESCRIPTION, ALLSET,agentgrade,json,sqltemp) select '"+EdorNo+"',BASECODE, INDEXCODE, INDEXNAME, INDEXTYPE, BRANCHTYPE, INDEXSET, CALTYPE, CALCODE, DATATYPE, DEFAULTVALUE, ITABLENAME, ICOLNAME, RESULTTYPE, CALPRPTY, BRANCHTYPE2, INDEXSERISE, CALSQL, MAININDEXFLAG, DESCRIPTION, ALLSET,agentgrade,json,sqltemp from LRAssessIndex where BaseCode='"+str[1]+"'";
        	String sql="update LRBase set status='"+mStatus+"',reason=''  where baseCode='"+str[1]+"'";
        	String delvs="delete from LRIndexVsComm where basecode='"+str[1]+"'";
        	String delin="delete from LRAssessIndex where basecode='"+str[1]+"'";
        	String vscom="insert into LRIndexVsComm (agentgrade,wagecode,wagename,branchtype,indexcode,wageorder,branchtype2,managecom,basecode,indextype,indexserise,description) select a.agentgrade,a.wagecode,a.wagename,a.branchtype,a.indexcode,a.wageorder,a.branchtype2,a.managecom,a.basecode,a.indextype,a.indexserise,a.description from LRIndexVsCommP a where a.basecode='"+str[1]+"'";
        	String index="insert into LRAssessIndex (indexcode,indexname,indextype,branchtype,indexset,caltype,calcode,defaultValue,resulttype,calprpty,branchtype2,basecode,indexserise,calsql,description,DataType,mainindexflag,agentgrade, ITABLENAME, ICOLNAME,json,sqltemp) select a.indexcode,a.indexname,a.indextype,a.branchtype,a.indexset,a.caltype,a.calcode,a.defaultValue,a.resulttype,a.calprpty,a.branchtype2,a.basecode,a.indexserise,a.calsql,a.description,a.DataType,a.mainindexflag,agentgrade ,ITABLENAME, ICOLNAME,json,sqltemp from LRAssessIndexP a where a.basecode='"+str[1]+"' ";
        	mMap.put(tem,"INSERT"); 
        	mMap.put(tem1,"INSERT"); 
        	mMap.put(tem2,"INSERT"); 
        	mMap.put(sql,"UPDATE"); 
        	mMap.put(delvs,"DELETE");
        	mMap.put(delin,"DELETE");
        	mMap.put(vscom,"INSERT");
        	mMap.put(index,"INSERT");
//        	mMap.put(createView(str[1]), "UPDATE");
        } else if (mOperate.equals("RuleNPublish")) {
        	String tem="insert into LRBaseB(EdorNo,EDORTYPE,Operator2,MakeTime2,MakeDate2,ModifyTime2,ModifyDate2,BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime) select '"+EdorNo+"','05','"+Operator2+"','"+MakeTime2+"','"+MakeDate2+"','"+ModifyTime2+"','"+ModifyDate2+"',BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime from LRBase where BaseCode='"+str[1]+"'";
        	String sql="update LRBase set status='"+mStatus+"',reason='"+mReason+"' where baseCode='"+str[1]+"'";
        	mMap.put(tem,"INSERT"); 
        	mMap.put(sql,"UPDATE");

        }
        return true;
    }
    public String createView(String baseCode) {
    	String sql = "select IndexCode,DataType from LRAssessIndexP where BaseCode='"+baseCode+"' order by MainIndexFlag desc";
    	ExeSQL exe = new ExeSQL();
    	SSRS ssrs = exe.execSQL(sql);
		StringBuffer sb = new StringBuffer();
		sb.append("create or replace view "+baseCode+" as ");
		sb.append("select WageNo");
		sb.append(",IndexType");
		sb.append(",BranchType");
		sb.append(",BranchType2");
		sb.append(",BaseCode");
		sb.append(",AgentCode");
		sb.append(",AgentGrade");
		sb.append(",ManageCom");
		sb.append(",BranchAttr");
//		sb.append(",IndexCode");
//		sb.append(",DataType");
		for(int i = 1; i <= ssrs.MaxRow; i++) {
			String tIndexCode = ssrs.GetText(i, 1);
			String tDataType = ssrs.GetText(i, 2);
			if("D".equals(tDataType)){
				tDataType = "to_char("+tDataType+",'YYYY-MM-DD')";
			}
			sb.append(",max(case IndexCode when '"+tIndexCode+"' then "+tDataType+" end) "+tIndexCode);
		}
		sb.append(" from LRIndexInfo where BaseCode='").append(baseCode).append("' ");
		sb.append("group by WageNo,IndexType,BranchType,BranchType2,BaseCode,AgentCode,AgentGrade,ManageCom,BranchAttr ");
		System.out.println(sb);
		return sb.toString();
	}

    /**
     * 这个方法返回的结果中存放程序执行后的结果
     * 如果程序需要返回数据，可以通过这个方法实现
     *
     * @return 返回一个VData容器
     */
    public VData getResult() {
        return mResult;
    }
//    public static void main(String args[]){
//    	new LARulePublishBL().createView("B00033");
//    }

}
