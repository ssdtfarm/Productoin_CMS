package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.db.LABranchLevelDB;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;

public class LABranchInterfaceBL 
{
    //全局变量
    public CErrors mErrors = new CErrors(); //错误处理类
    
    private ExeSQL mExeSQL = new ExeSQL();

    private String mBranchAttr;
    private String mUpBranchAttr;
    private String mBranchLevel;
    private String mBranchType;
    private String mBranchType2;
    
	/**
	 * 错误处理方法
	 * @param cFName 方法名
	 * @param cMsg 错误信息
	 */
	private void buildError(String cFName, String cMsg)
    {
        CError tCError = new CError();
        tCError.moduleName = "LAIndexCalStateDeal";
        tCError.functionName = cFName;
        tCError.errorMessage = cMsg;
        System.out.println("LAIndexCalStateDeal--"+cFName+"--"+cMsg);
        this.mErrors.addOneError(tCError);
    }
	
	/**
	 * 自动生成销售机构外部号BranchAttr
     * @param tUpBranchAttr 上级机构的外部编码
     *        tBranchLevel  被生成机构的级别
     *        tBranchType   渠道
     *        tBranchType2  子渠道
	 * @return 如果返回""，则是有错
	 */
	public String createAttr(String tUpBranchAttr,
				             String tBranchLevel,
				             String tBranchType,
				             String tBranchType2)
	{
        System.out.println("CreateBranchAttr...");
		
		//保存相关信息
		this.mUpBranchAttr = tUpBranchAttr.trim();
		this.mBranchLevel = tBranchLevel.trim();
		this.mBranchType = tBranchType.trim();
		this.mBranchType2 = tBranchType2.trim();
		
        System.out.println("tUpBranchAttr..."+mUpBranchAttr);
        System.out.println("tBranchLevel..."+mBranchLevel);
        System.out.println("tBranchType..."+mBranchType);
        System.out.println("tBranchType2..."+mBranchType2);
        
		//校验上级机构与生成机构级别的正确性
        LABranchLevelDB tLABranchLevelDB = new LABranchLevelDB();
        tLABranchLevelDB.setBranchLevelCode(mBranchLevel);
        tLABranchLevelDB.setBranchType(mBranchType);
        tLABranchLevelDB.setBranchType2(mBranchType2);
        if (!tLABranchLevelDB.getInfo())
        {
        	this.buildError("createAttr", ""+bundle.getString("ErrorMsg")+"");
            return "";
        }
        
		if(mUpBranchAttr==null || "".equals(mUpBranchAttr)) 
		{
			mUpBranchAttr="Area";
		}
		
		//新建机构号
		String sql = "select CreateBranchAttr('"+mUpBranchAttr+"','"+mBranchLevel+"','"+mBranchType+"') from ldsysvar where sysvar='onerow'";
		this.mBranchAttr = this.mExeSQL.getOneValue(sql);

		if(this.mBranchAttr==null) 
		{
			this.mBranchAttr = "";
		}
		
		if(this.mBranchAttr.indexOf("End")!=-1)
		{
			this.buildError("createAttr", ""+bundle.getString("ErrorMsg")+"");
            return "";
		}
		
		System.out.println("新生成外部编码为--->"+this.mBranchAttr);
		
		return this.mBranchAttr;
	}
	
	/**
	 * 向latempno临时表中插入新建团队失败后未被使用的attr编码，以备下次使用，
	 * 避免BranchAttr编码使用率过低、迅速达到最大值
	 * @return
	 */
	public boolean insertAttr()
	{
		if(this.mBranchAttr==null || "".equals(this.mBranchAttr)) return true;
		
		String sql = "declare begin update latempno set usedflag = 'N' where branchattr = '"+this.mBranchAttr+"' and branchtype = '"+this.mBranchType+
						"' and upbranchattr = '"+this.mUpBranchAttr+"' and usedflag = 'Y'; " +
						"If (Sql%Notfound) then insert into latempno(SerialNo,BranchType,BranchType2,UpBranchAttr,BranchAttr,UsedFlag) " +
						"values (to_char(createmaxno('SerialNo', 'SN'),'FM00000000000000000000'),'"+this.mBranchType+"','"+this.mBranchType2+
						"','"+this.mUpBranchAttr+"','"+this.mBranchAttr+"','N'); end if; end;";
		return this.mExeSQL.execUpdateSQL(sql);
	}
	
	/**
	 * 删除latempno临时表中存储的已经使用过的attr编码，以免重复使用
	 * @return
	 */
	public boolean deleteAttr()
	{
		if(this.mBranchAttr==null || "".equals(this.mBranchAttr)) return true;
		
		String sql = "delete from latempno where branchattr='"+this.mBranchAttr+"' and branchtype='"+this.mBranchType+"' and usedflag='Y'";
		return this.mExeSQL.execUpdateSQL(sql);
	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) 
//	{
//		LABranchInterfaceBL bl = new LABranchInterfaceBL();
//		System.out.println(bl.createAttr("86470101", "03", "1", "01"));
//		System.out.println(AgentPubFun.CreateBranchAttr("86470101", "03", "1", "01"));
////		if(bl.mErrors.needDealError())
////		{
////			bl.mErrors.copyAllErrors(bl.mErrors);
////		}
////		bl.insertAttr();
////
////		System.out.println(bl.createAttr("", "03", "1", "01"));
////		bl.deleteAttr();
//	}

}
