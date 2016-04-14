package com.sinosoft.lis.taskservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.VData;

public class Extr_AutoCalculation extends TaskThread {

	/** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();
    /**
     *  数据操作字符串
     */
    private String mOperate;// 数据操作字符串
    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
    private MMap mMap = new MMap();
    private VData mResult = new VData();// 存放返回数据的容器
    private ExeSQL mExeSQL = new ExeSQL();
    
    /**
     *自动计算当月薪资标志
     *	true--计算（默认）
     * 	false--不计算
     */
    private boolean CalFlag = true;
    
	/** 管理机构 */
	private String mManageCom;
	/** 渠道
	 * 1--前台默认值 --个人渠道
	 */
	private String mBranchType;
	/** 
	 * 计算年月 */
	private String mIndexCalNo;
	
	/**
	 * 保存备份的批次号
	 */
	Set<String> SNSet = new HashSet<String>();
	
	/** 计算类型
	 * 00--正式计算 */
	private String mWageType;
	
	/**
	 * 01--薪资计算
	 * 11--上月薪资重算
	 */
	private String mIndexType = "01";
	
	
	/** 构造SQL语句时使用 */
	public StringBuffer sb=new  StringBuffer();

	/**
	 * 当前日期 yyyy-MM-DD
	 */
    private String currentDate = PubFun.getCurrentDate();
    /**
	 * 当前时间hh:mm:ss
	 */
    private String currentTime = PubFun.getCurrentTime();
    

    public Extr_AutoCalculation() {
    }
    
    public void run() {
    	if(!getInputData()){
    		this.CalFlag=false;
    		System.out.println("ERROR：初始化数据失败，不计算该月薪资！");
    	}
    	if(!check()){
    		this.CalFlag=false;
    		System.out.println("ERROR：判断薪资状态出错，不计算该月薪资！");
    	}
    	if (CalFlag) {
			if(!dealData()){
				System.out.println("ERROR：处理数据时出错，不计算该月薪资！");
			}
		}
    }
    
    /**
     * 从输入数据中得到所有对象
     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
     */
    public boolean getInputData() {
        // 全局变量
        //操作类型
        this.mOperate = "Cal";
    	// 管理机构 */
    	this.mManageCom = "2";
    	// 渠道 */
    	this.mBranchType = "1";
    	// 计算年月 */
    	this.mIndexCalNo = "";
    	//薪资类型
    	this.mIndexType = "01";
    	// 计算类型 */
    	this.mWageType = "00";
    	
    	System.out.println("Info---mOperate:"+mOperate+
    						"---mManageCom:"+mManageCom+
    						"---mBranchType:"+mBranchType+
    						"---mIndexCalNo:"+mIndexCalNo+
    						"---mWageType:"+mWageType);
        
        //获取当前时间的年月
    	GregorianCalendar gc=new GregorianCalendar();
        try {
            gc.setTime(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR:获取当前时间出错！");
        }
        this.mIndexCalNo = new SimpleDateFormat("yyyyMM").format(gc.getTime());
        System.out.println(mIndexCalNo); 
        
        return true;
    }
    

    /**
     * 传输数据的公共方法
     */
    public boolean check() {
    	
    	String sql = "SELECT state FROM LAWageHistory WHERE WageNo='"+this.mIndexCalNo+"' AND BranchType = '"+this.mBranchType+"' AND ManageCom LIKE '2%'";
		String mStateString = this.mExeSQL.getOneValue(sql);
		System.out.println("Data:State---"+mStateString);
		if(mStateString==null || ("").equals(mStateString))
		{
			//System.out.println("INFO：该月还没有提奖合计，可以自动计算薪资！");
		}else if("11".equals(mStateString) ){
			//System.out.println("Not to calculate the salary of the month, do not back up!");
		}else if( "88".equals(mStateString)){
			//System.out.println("INFO：该月正在计算薪资，不用自动计算薪资！");
			//this.CalFlag=false;
		}else if("21".equals(mStateString) || "23".equals(mStateString)){
			System.out.println("INFO：该月薪资已经审核完成，不用自动计算薪资！");
			this.CalFlag=false;
		}else if("14".equals(mStateString)){
			//this.CalFlag=false;
			//System.out.println("Info---该月薪资已经计算完成，不需要自动计算该月薪资!");
		}else if("13".equals(mStateString)){
			//this.CalFlag=false;
			//System.out.println("Info---该月薪资计算失败，证明计算过薪资，也不再计算!");
		}else{
			System.out.println("Info---该月薪资状态不正确，不自动计算薪资!");
			this.CalFlag=false;
			CError.buildErr(this, bundle.getString("Compensationstatusofthismonthhasanerror,cannotcalculatetheexamination!"));
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
    	
    	Date beginDateString = new Date();
    	
		
//        //薪资计算前，将状态标志为88--准备进行薪资计算
//		if (this.mWageType.equals("00") && !setFlag())
//		{
//			resetFlag();
//			return false;
//		}
		
		Date bakWageString = new Date();
		
		if(!bakToIndexInfoBB()){
			CError.buildErr(this, bundle.getString("Errorwhileclearwagewhichbeencalculated,pleasecalculateagain!"));
            return false;
		}
		
		Date bakMonthCalculateString = new Date();
		
		
		Date AssessCalculateString = new Date();
		
		//进行薪资计算
		if (!AssessCalculate())
		{
            //resetFlag();
			return false;
		}
		
		Date endTimeString = new Date();
		
//		// 薪资计算完毕，修改状态标志为11；
//		if (this.mWageType.equals("00") && !changeFlag())
//		{
//			CError.buildErr(this, bundle.getString("Compensationcalculationhasbeencompleted"));
//			System.out.println("Error------薪资计算完毕，修改计算状态时出错，请手动修改计算状态！");
//			return false;
//		}
		
		System.out.println("Info----begin time:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(beginDateString)
				+ "\n代理人薪资项备份 end time:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(bakWageString)+"----total(minute):"+(bakWageString.getTime()-beginDateString.getTime())
				+ "\n本月和上月薪资结果备份结束时间:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(bakMonthCalculateString)+"----total(minute):"+(bakMonthCalculateString.getTime()-bakWageString.getTime())
				+"\nToal Time of The calculation of monthly wages(ms):"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(endTimeString)+"----total(minute):"+(endTimeString.getTime()-AssessCalculateString.getTime())
				+"\ntotal Time（ms）:"+(endTimeString.getTime()-beginDateString.getTime())
				);
		
		
		return true;
    }
    
    public boolean setFlag()
	{
		ExeSQL tExeSQL = new ExeSQL();
		if (!tExeSQL.execUpdateSQL("update LAWageHistory set State='88', Operator='"+this.mGlobalInput.Operator+"', ModifyDate='"+PubFun.getCurrentDate()+"', ModifyTime='"+PubFun.getCurrentTime()+"' where ManageCom like '"+ mManageCom
				+ "%' and WageNo='" + mIndexCalNo + "' and BranchType='"+ mBranchType
				+ "'"))
		{
			// @@错误处理
			this.mErrors.copyAllErrors(tExeSQL.mErrors);
			buildError("changeFlag",bundle.getString("Src_BL_dealDateErr"));
			return false;
		}
		return true;
	}
    
    
    
    /**
     * 如果计算失败，将状态重新标识为未计算状态，当此次计算没有发生过
     * 同时修改此次计算的时间。
     * @return
     */
    public boolean resetFlag()
	{

        
		ExeSQL tExeSQL = new ExeSQL();
		if (!tExeSQL.execUpdateSQL("update LAWageHistory set State='11', Operator='"+this.mGlobalInput.Operator+"', ModifyDate='"+PubFun.getCurrentDate()+"', ModifyTime='"+PubFun.getCurrentTime()+"' where ManageCom like '"+ mManageCom
				+ "%' and WageNo='" + mIndexCalNo + "' and BranchType='"+ mBranchType
				+ "'"))
           {
	          // @@错误处理
	          this.mErrors.copyAllErrors(tExeSQL.mErrors);
	          buildError("changeFlag",bundle.getString("Src_BL_dealDateErr"));
	          return false;
           }
		return true;
	}
    
    /**
	 * 薪资计算完毕后，修改薪资计算状态，恢复原来的薪资状态：修改为未计算状态
	 * @return
	 */
	public boolean changeFlag()
	{
		ExeSQL tExeSQL = new ExeSQL();
		// 薪资计算完需要修改薪资计算的状态
		if (!tExeSQL.execUpdateSQL("update LAWageHistory set State='11', Operator='"+this.mGlobalInput.Operator+"', ModifyDate='"+PubFun.getCurrentDate()+"', ModifyTime='"+PubFun.getCurrentTime()+"' where ManageCom like '"+ mManageCom
				+ "%' and WageNo='" + mIndexCalNo + "' and BranchType='"+ mBranchType
				+ "' and State='88'"))
        {
           this.mErrors.copyAllErrors(tExeSQL.mErrors);
           buildError("changeFlag",bundle.getString("Src_BL_dealDateErr"));
           return false;
        }
		
		return true;
	}
	
	
	/**
	 * 重算薪资时，删除本月薪资结果表中的数据
	 * 不备份本月薪资结果表中的实时数据（如果需要备份再添加）
	 * @return 是否执行成功
	 * 
	 * delete语句一次性删除掉
	 */
	public  boolean bakToIndexInfoBB() {

		if(!deleteLaindexinfoV(this.mIndexCalNo,this.mIndexType)){
        	System.out.println("删除结果表中的本月已经存在的薪资结果时出错，请手动删除本月已经存在的薪资结果！");
        	return false;
        }
		
		return true;
	}
	
	/**
	 * 删除LAindexinfoV表中的数据
	 * @param indexcalNo  月份
	 * @param indexType   类型
	 * @return 是否删除成功
	 */
	public boolean deleteLaindexinfoV(String indexcalNo,String indexType) {
		//删除薪资结果表中当月已经存在的的数据
		StringBuffer deleteLAindexinfoV = new StringBuffer();
		deleteLAindexinfoV.append("delete FROM LAIndexInfoVTemp WHERE IndexType='"+indexType+"'");
		ExeSQL exeSQL = new ExeSQL();
		boolean deleteFilg = exeSQL.execUpdateSQL(deleteLAindexinfoV.toString());
		return deleteFilg;
	}
	
	
    
	 /**
	  *  进行薪资计算
	  * @return
	  */
 	public boolean AssessCalculate() {
		if(!insertLaindexinfoV(this.mIndexCalNo,this.mIndexType)){
			System.out.println("薪资结果导入到薪资结果表时出错，请手动导入结果表！");
			CError.buildErr(this, bundle.getString("Errorwhileclearingwagebeencalculated,pleasecalculateagain!"));
			return false;
		}
				
 		System.out.println("===============Complete calculation!===============");
 		return true;
 	}
 	
 	public boolean insertLaindexinfoV(String indexcalNo,String indextype){
 		ExeSQL exeSQL = new ExeSQL();
 		StringBuffer insertLAindexinfoVBuffer = new StringBuffer();
 		insertLAindexinfoVBuffer.append("INSERT INTO LAIndexInfoVTemp ");
 				insertLAindexinfoVBuffer.append("(wageno,branchtype,indextype,agentcode,agentgrade,AgentGroup,State,MakeDate,MakeTime,ModifyDate,ModifyTime		");
 				insertLAindexinfoVBuffer.append(",I000000001");
 				insertLAindexinfoVBuffer.append(",I000000021");
 				insertLAindexinfoVBuffer.append(",I000000007");
 				insertLAindexinfoVBuffer.append(",I000000049");
 				insertLAindexinfoVBuffer.append(",I000000051");
 				insertLAindexinfoVBuffer.append(",I000000145");
 				insertLAindexinfoVBuffer.append(",I000000146");
 				insertLAindexinfoVBuffer.append(",I000000147");
 				insertLAindexinfoVBuffer.append(",I000000148");
 				insertLAindexinfoVBuffer.append(",I000000150");
 				insertLAindexinfoVBuffer.append(",I000000152");
 				insertLAindexinfoVBuffer.append(",I000000153");
 				insertLAindexinfoVBuffer.append(",I000000155");
 				insertLAindexinfoVBuffer.append(",I000000156");
 				insertLAindexinfoVBuffer.append(",I000000157");
 				insertLAindexinfoVBuffer.append(",I000000158");
 				insertLAindexinfoVBuffer.append(",I000000159");
 				insertLAindexinfoVBuffer.append(",I000000160");
 				insertLAindexinfoVBuffer.append(",I000000161");
 				insertLAindexinfoVBuffer.append(")(select '"+mIndexCalNo+"' AS wageno,branchtype,'"+this.mIndexType+"',agentcode,agentgrade,agentgroup,agentState,'"+currentDate+"','"+currentTime+"','"+currentDate+"','"+currentTime+"'");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_MonthFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000001");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_Persistency(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000021");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_Persistency(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000007");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_CurYearFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000049");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_CurYearFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000051");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_MonthAFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000145");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_MonthNAFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000146");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_MonthAFYP(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000147");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_MonthCASE(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000148");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_P_curYearNAFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000150");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_MonthCASE(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000152");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_MonthFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000153");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_MonthAFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000155");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_MonthNAFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000156");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_MonthAFYP(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000157");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_CurYearAFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000158");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_CurYearNAFYC(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000159");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_CurYearAFYP(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000160");
 				insertLAindexinfoVBuffer.append(" ,CAST(dbo.Item_DR_MonthActivity(agentcode,'"+mIndexCalNo+"') as VARCHAR(17)) AS I000000161");
 				insertLAindexinfoVBuffer.append(" FROM LAAgentV WHERE 1=1 and (outworkdate is null or SUBSTRING(CONVERT(varchar(100), outworkdate, 112), 1, 6)>='"+mIndexCalNo+"')");
 				insertLAindexinfoVBuffer.append(" )");
		
				boolean insertFlag = exeSQL.execUpdateSQL(insertLAindexinfoVBuffer.toString());
 		
 		return insertFlag;
 	}
 	
    
    /**
	 * 构建错误信息
	 * @param szFunc
	 * @param szErrMsg
	 */
	private void buildError(String szFunc, String szErrMsg)
	{
		CError cError = new CError();
		cError.moduleName = "AgentWageGatherBLNew";
		cError.functionName = szFunc;
		cError.errorMessage = szErrMsg;
		this.mErrors.addOneError(cError);
	}

	public CErrors getErrors()
	{
		return mErrors;
	}
	
//	public static void main(String[] args){
////		GregorianCalendar gc=new GregorianCalendar();
////	       
////        try {
////            gc.setTime( new SimpleDateFormat("yyyyMM").parse("200901"));
////            gc.add(2, -1);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        
////        String asd = new SimpleDateFormat("yyyyMM").format(gc.getTime());
////        System.out.println(asd); 
////		System.out.println("==========测试开始==================");
////		Date asDate = new Date();
////		System.out.println("==========测试时间=================="+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(asDate));
//////		CompensationCalculationBL tCompensationCalculationBL = new CompensationCalculationBL();
//////		tCompensationCalculationBL.BakWageCode();
////		System.out.println("==========测试结束==================");
//		
//		Set<String> set = new HashSet<String>();
//		set.add("123");
//		set.add("456");
//		Iterator<String> iterator = set.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//			
//		}
//		
//		
//		
//	}

}
