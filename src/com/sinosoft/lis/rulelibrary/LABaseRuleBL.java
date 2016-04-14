/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

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

public class LABaseRuleBL {
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    private String mOperate;// 数据操作字符串
    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
    private MMap mMap = new MMap();
    private VData mResult = new VData();// 存放返回数据的容器

    private String BaseCode = "";
    private String Name = "";
    private String BranchType = "";
    private String BranchTypeName = "";
    private String Remark = "";
    private String Status = "";


    private String currentDate = PubFun.getCurrentDate();
    private String currentTime = PubFun.getCurrentTime();

    public LABaseRuleBL() {
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
        BaseCode = (String)transferData.getValueByName("BaseCode");
        Name = (String)transferData.getValueByName("Name");
        BranchType = (String)transferData.getValueByName("BranchType");
        BranchTypeName = (String)transferData.getValueByName("BranchTypeName");
        Remark = (String)transferData.getValueByName("Remark");
        Status = (String)transferData.getValueByName("Status");

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
        if (mOperate.equals("INSERT||MAIN")) {
            // 增加
           String  mBaseCode="B"+PubFun1.CreateMaxNo("LRBase", 5);
        	String temp_sql = "select * from LRBase where BaseCode='"+mBaseCode+"'";
        	SSRS ssrs = exe.execSQL(temp_sql);
        	if(ssrs.MaxRow>=1){
        		CError.buildErr(this, bundle.getString("ThisBasicLawhasbeenexisted!"));
        		System.out.println("该基本发已经存在！");
        		return false;
        	}else{       	 
       	 String sql = "insert into LRBase(BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime)"+
       	    	" values('"+mBaseCode+"','"+Name+"','"+BranchType+"','01','"+Remark+"','"+mGlobalInput.Operator+"','"+currentDate+"','"+currentTime+"','"+currentDate+"','"+currentTime+"')";        	    	
       	 exe.execUpdateSQL(sql);
       	return true; 
        	}
        } else if (mOperate.equals("UPDATE||MAIN")) {
        	String temp_sql = "select * from LRBase where BaseCode='"+BaseCode+"'";
        	SSRS ssrs = exe.execSQL(temp_sql);
        	if(ssrs.MaxRow>=1){
        		String EdorNo=PubFun1.CreateMaxNo("LRBaseB", 20);
        		String Operator2= mGlobalInput.Operator;
        		String MakeTime2=currentTime;
        		String MakeDate2=currentDate;
        		String ModifyTime2=currentTime;
        		String ModifyDate2=currentDate;
        		
        		String sql = "insert into LRBaseB(EdorNo,Operator2,MakeTime2,MakeDate2,ModifyTime2,ModifyDate2,BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,EDORTYPE) select '"+EdorNo+"','"+Operator2+"','"+MakeTime2+"','"+MakeDate2+"','"+ModifyTime2+"','"+ModifyDate2+"',BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,'02' from LRBase where BaseCode='"+BaseCode+"'";
        		exe.execUpdateSQL(sql);
        	}else{
        		CError.buildErr(ssrs, bundle.getString("BOM_Thisbasiccodedoesnotexist!"));
        		return false;
        	}
          	 String sql = "update LRBase set BaseCode='"+BaseCode+"',Name='"+Name+"',status='"+Status+"',BranchType='"+BranchType+"',Remark='"+Remark+"',Operator='"+mGlobalInput.Operator+"',ModifyDate='"+currentDate+"',ModifyTime='"+currentTime+"' where BaseCode='"+BaseCode+"'";
          	 exe.execUpdateSQL(sql);
        	return true;
        } else if (mOperate.equals("MODIFY||MAIN")) {
        	String temp_sql = "select * from LRBase where BaseCode='"+BaseCode+"'";
        	SSRS ssrs = exe.execSQL(temp_sql);
        	if(ssrs.MaxRow>=1){
        		String EdorNo=PubFun1.CreateMaxNo("LRBaseB", 20);
        		String Operator2= mGlobalInput.Operator;
        		String MakeTime2=currentTime;
        		String MakeDate2=currentDate;
        		String ModifyTime2=currentTime;
        		String ModifyDate2=currentDate;
        		String sql = "insert into LRBaseB(EdorNo,Operator2,MakeTime2,MakeDate2,ModifyTime2,ModifyDate2,BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,EDORTYPE) select '"+EdorNo+"','"+Operator2+"','"+MakeTime2+"','"+MakeDate2+"','"+ModifyTime2+"','"+ModifyDate2+"',BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,'02' from LRBase where BaseCode='"+BaseCode+"'";
        		exe.execUpdateSQL(sql);
        	}else{
        		CError.buildErr(ssrs, bundle.getString("BOM_Thisbasiccodedoesnotexist!"));
        		return false;
        	}
          	 String sql = "update LRBase set BaseCode='"+BaseCode+"',Name='"+Name+"',BranchType='"+BranchType+"',Status='05',Remark='"+Remark+"',Operator='"+mGlobalInput.Operator+"',ModifyDate='"+currentDate+"',ModifyTime='"+currentTime+"' where BaseCode='"+BaseCode+"'";
          	 exe.execUpdateSQL(sql);
        	
        	return true;
        }else if (mOperate.equals("DELETE||MAIN")) {
            // 删除
        	String temp_sql = "select * from LRBase where BaseCode ='"+BaseCode+"'";
        	SSRS ssrs = exe.execSQL(temp_sql);
        	if(ssrs.MaxRow>=1){
        		String EdorNo=PubFun1.CreateMaxNo("LRBaseB", 20);
        		String Operator2= mGlobalInput.Operator;
        		String MakeTime2=currentTime;
        		String MakeDate2=currentDate;
        		String ModifyTime2=currentTime;
        		String ModifyDate2=currentDate;
        		String sql = "insert into LRBaseB(EdorNo,Operator2,MakeTime2,MakeDate2,ModifyTime2,ModifyDate2,BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,EDORTYPE) select '"+EdorNo+"','"+Operator2+"','"+MakeTime2+"','"+MakeDate2+"','"+ModifyTime2+"','"+ModifyDate2+"',BaseCode,Name,BranchType,Status,Remark,Operator,MakeDate,MakeTime,ModifyDate,ModifyTime,'03' from LRBase where BaseCode='"+BaseCode+"'";
        		exe.execUpdateSQL(sql);
        	}else{
        		CError.buildErr(ssrs, bundle.getString("BOM_Thisbasiccodedoesnotexist!"));
        		return false;
        	}
          	 String sql = "delete from  LRBase where BaseCode='"+BaseCode+"'";
          	 exe.execSQL(sql);
        	
        	return true;
        }
        return true;
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

}
