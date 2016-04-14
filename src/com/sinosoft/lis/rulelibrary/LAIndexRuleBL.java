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
import com.sinosoft.lis.db.LRAssessIndexPDB;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class LAIndexRuleBL {
    /** 错误处理类，每个????错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    private String mOperate;// 数据操作字符??
    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
    private MMap map = new MMap();
    private VData mResult = new VData();// 存放返回数据的容??

    private String mBranchType = "";
    private String mBaseCode = "";
    private String mIndexType = "";
    private String mAgentGrade = "";
    private String mIndexSerise = "";
    private String mIndexCode = "";
    public String mDescription="";
    public String mWageCode="";
    public String mWageName="";
    public String mhideIndexCode="";
    List mRuleGrid = new ArrayList();//规则--推荐规则列表

    private String currentDate = PubFun.getCurrentDate();
    private String currentTime = PubFun.getCurrentTime();

    public LAIndexRuleBL() {
    }

    /**
     * 传输数据的公共方??
     */
    public boolean check() {
        return true;
    }

    public boolean submitData(VData cInputData, String cOperate) {
        // 将操作数据拷贝到本类??
        this.mOperate = cOperate;
        // 得到外部传入的数??将数据备份到本类??
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

        //????提交
        VData tVData = new VData();
        tVData.add(map);
        PubSubmit tPubSubmit = new PubSubmit();
        if (!tPubSubmit.submitData(tVData, "")) {
            // @@错误处理
            CError.buildErr(this, bundle.getString("Src_pubSubmitErr"));
            return false;
        }
        return true;
    }

    /**
     * 从输入数据中得到????对象
     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
     */
    public boolean getInputData(VData cInputData) {
        // 全局变量
        mGlobalInput = (GlobalInput) cInputData.get(0);
        TransferData transferData = (TransferData) cInputData.get(1);
        mBranchType = (String)transferData.getValueByName("BranchType");
        mBaseCode = (String)transferData.getValueByName("BaseCode");
        mIndexType = (String)transferData.getValueByName("IndexType");
        mAgentGrade = (String)transferData.getValueByName("AgentGrade");
        mIndexSerise = (String)transferData.getValueByName("IndexSerise");
        mIndexCode = (String)transferData.getValueByName("IndexCode");
        mhideIndexCode = (String)transferData.getValueByName("hideIndexCode");
        mDescription=(String)transferData.getValueByName("Description");
        mWageCode=(String)transferData.getValueByName("WageCode");
        mWageName=(String)transferData.getValueByName("WageName");
        mRuleGrid = (List)transferData.getValueByName("mulRuleGrid");//规则--推荐规则列表
        String sql = "select branchtype from lrbase where basecode = '"+mBaseCode+"'";
        mBranchType = new ExeSQL().getOneValue(sql);
        if(mBranchType.equals("")){
        	//CError.buildErr(this, "基本法渠道信息不完整！");
        	CError.buildErr(this, bundle.getString("Thebasiclawdoesnothavecompletechannelinformation!"));
            return false;
        }
        if (mGlobalInput == null) {
            CError.buildErr(this, bundle.getString("Src_UI_getInputDataErr"));
            return false;
        }
        return true;
    }

    /**
     * 业务处理主函??
     *
     * @return boolean
     */
    public boolean dealData() {
    	String[] s= new String[3];
    	List list= new ArrayList();
    	s=(String [])mRuleGrid.get(0);
        if (mOperate.equals("queryPara")) {
            // 定制参数
            return true;
        } else if (mOperate.equals("saveClick")) {
        	String tindexcode=s[1];
      	  	List newSets=LRAssessIndexLibraryUtil.parseIndex(tindexcode,list);
        	//删除LRAssessIndexP表中原有的规则指标
//        	String query = "select indexcode from LRIndexVsCommP where agentgrade='"+mAgentGrade+"' and branchtype='"+mBranchType+"' and  basecode='"+mBaseCode+"' and wagecode='"+mWageCode+"'";
//        	ExeSQL exe = new ExeSQL();
//        	SSRS ssrs = exe.execSQL(query);
//        	if(ssrs.MaxRow > 0) {
//        		String oldIndexcode = ssrs.GetText(1, 1);
//        		if(oldIndexcode != null && !oldIndexcode.trim().equals("")){
//        			String queryAllSet = "select allset from lrassessindexp where basecode='"+mBaseCode+"' and indexcode='"+oldIndexcode+"'";
//        			SSRS as = exe.execSQL(queryAllSet);
//        			if(as.MaxRow > 0) {
//        				String allSet = as.GetText(1, 1);
//        				String[] split = allSet.split(",");
//        				StringBuffer sb = new StringBuffer();
//        				for(int i = 0; i < split.length; i++) {
//        					if(!newSets.contains(split[i])) {
//        						if(sb.length() > 0) {
//        							sb.append(",'" + split[i] + "'");
//        						} else {
//        							sb.append("'" + split[i] + "'");
//        						}
//        						
//        					}
//        				}
//        				if(sb.length() > 0) {
//        					String deleteIndexes = "delete from LRAssessIndexP where basecode='"+mBaseCode+"' and indexcode in(" + sb.toString() + ")";
//                    		map.put(deleteIndexes,"DELETE");
//        				}
//        			}
//        		}
//        	}
        	//更新LRIndexVsCommP表中的信息
      	  	String sql = "update LRIndexVsCommP  set indexcode='"+s[1]+"' where agentgrade='"+mAgentGrade+"' and branchtype=(select branchtype from LRBase where basecode='"+mBaseCode+"') and  basecode='"+mBaseCode+"' and wagecode='"+mWageCode+"' and IndexType='"+mIndexType+"'";
      	  	map.put(sql,"UPDATE");
      	  	//将IndexSet字段从lrassessindexlibrary或lrterm表中解析出来
      	  	StringBuffer buffer = new StringBuffer();
      	  	StringBuffer buffer2 = new StringBuffer();
      	  	StringBuffer all = new StringBuffer();
      	  	for(int i = 0; i < newSets.size(); i++) {
      	  		String indexcode = (String) newSets.get(i);
      	  		if(all.length() > 0) {
      	  			all.append("," + indexcode);
      	  		}else {
      	  			all.append(indexcode);
      	  		}
      	  		
      	  		if(indexcode.startsWith("I")) {
      	  			if(buffer2.length() > 0) {
      	  				buffer2.append(",'").append(indexcode).append("'");
      	  			}else {
      	  				buffer2.append("'").append(indexcode).append("'");
      	  			}
      	  		} else {
	      	  		if(buffer.length() > 0) {
	  	  				buffer.append(",'").append(indexcode).append("'");
	  	  			}else {
	  	  				buffer.append("'").append(indexcode).append("'");
	  	  			}
      	  		}
      	  	} 
      	  	
       	 //将规则算法插入到LRAssessIndexP表中
      	  if(buffer.length() > 0) {
      		String del1 = "delete from LRAssessIndexP where basecode='"+mBaseCode+"' and agentgrade = '"+mAgentGrade+"' and indextype = '"+mIndexType+"' and indexcode in(" + buffer.toString() + ")";
      		map.put(del1, "DELETE");
      	  }
      	  if(buffer2.length() > 0) {
      		String del2 = "delete from LRAssessIndexP where basecode='"+mBaseCode+"' and agentgrade = '"+mAgentGrade+"' and indextype = '"+mIndexType+"' and indexcode in(" + buffer2.toString() + ")";
        	 map.put(del2, "DELETE");
      	  }
      	  
      	    StringBuffer ss = new StringBuffer();
      	    if(buffer.length()>0) {
      	    	ss.append("insert into LRAssessIndexP (indexcode,indexname,indextype,branchtype,basecode,calsql,sqltemp,Description,DataType,MainIndexFlag,indexset,json,agentgrade,calprpty) " +
      	    			"(select indexcode,indexname,'"+mIndexType+"',branchtype,'"+mBaseCode+"',calsql,sqltemp,'"+s[2]+"',DataType,'N',indexset,json,'"+mAgentGrade+"','N' from lrassessindexlibrary where indexcode in("+buffer.toString()+"))");
          	  	if(mIndexSerise!=null && !"".equals(mIndexSerise)) {  
          	    	ss.append("and indexserise='"+mIndexSerise+"'");
          	    }
          	    if(mIndexCode!=null && !"".equals(mIndexCode)) {
          	    	ss.append("and indexcode='"+mIndexCode+"'");
          	    }
          	  	map.put(ss.toString(),"INSERT"); 
      	    }
      	    StringBuffer st = new StringBuffer();
      	    if(buffer2.length()>0) {
          	  	st.append("insert into LRAssessIndexP (indexcode,indexname,indextype,branchtype,basecode,calsql,sqltemp,Description,DataType,MainIndexFlag,agentgrade,calprpty) " +
          	  			"(select id,name,'"+mIndexType+"','"+mBranchType+"','"+mBaseCode+"',calsql,calsql,Remark,DataType,'N','"+mAgentGrade+"','Y' from lrterm where id in("+buffer2.toString()+"))");
          	  	if(mIndexSerise!=null && !"".equals(mIndexSerise)) {
          	    	st.append("and indexserise='"+mIndexSerise+"'");
          	    }
          	    if(mIndexCode!=null && !"".equals(mIndexCode)) {
          	    	st.append("and indexcode='"+mIndexCode+"'");
          	    }
          	  	map.put(st.toString(),"INSERT"); 
      	    }
      	    if(all.length() > 0) {
      	    	String update = "update LRAssessIndexP set allSet = '"+all.toString()+"' where basecode='"+mBaseCode+"' and agentgrade = '"+mAgentGrade+"' and indexcode='"+tindexcode+"' and indextype = '"+mIndexType+"'";
      	    	map.put(update,"INSERT"); 
      	    }
	    //处理mainindexflag标记
      	    //20150226 tianzf sqlserver不能使用update table 别名 的写法
//      	    String  manindexflag= "update lrassessindexp t set mainindexflag='Y' where basecode='"+mBaseCode+"' and agentgrade = '"+mAgentGrade+"' and indextype = '"+mIndexType+"'  and  exists(select 1 from lrindexvscommp  where t.basecode=basecode and agentgrade=t.agentgrade and indexcode=t.indexcode and indextype= '"+mIndexType+"')";
      	    String  manindexflag= "update lrassessindexp set mainindexflag='Y' where basecode='"+mBaseCode+"' and agentgrade = '"+mAgentGrade+"' and indextype = '"+mIndexType+"'  and  exists(select 1 from lrindexvscommp  where lrassessindexp.basecode=basecode and agentgrade=lrassessindexp.agentgrade and indexcode=lrassessindexp.indexcode and indextype= '"+mIndexType+"')";
      	    map.put(manindexflag, "UPDATE");
        }	
        return true;
    }

    /**
     * 这个方法返回的结果中存放程序执行后的结果
     * 如果程序????返回数据，可以??过这个方法实??
     *
     * @return 返回????VData容器
     */
    public VData getResult() {
        return mResult;
    }

}
