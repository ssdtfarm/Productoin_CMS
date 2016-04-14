/*
 *************************************************************************
 * Copyright (C) 2010-2012, Sinosoft Corporation and others.             *
 * All Rights Reserved.                                                  *
 *************************************************************************
 */
package com.sinosoft.lis.rulelibrary;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.excel.ExcelInfo;
import com.sinosoft.lis.excel.ReportHelper;
import com.sinosoft.lis.excel.SimpleWorkbook;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.ListTable;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class LRBomBLReport {
	/** 错误处理类，每个需要错误处理的类中都放置该类 */
	public CErrors mErrors = new CErrors();
	private String mOperate;// 数据操作字符串
	private GlobalInput mGlobalInput = new GlobalInput();// 全局数据
	//private MMap mMap = new MMap();
	private VData mResult = new VData();// 存放返回数据的容器

	 //   LRBomBLReport mBL = new LRBomBLReport();

    private String BranchType = "";
    private String State = "";
    private String ID = "";
    private String Name = "";
    private String IDTerm = "";
    private String NameTerm = "";
    private String StateTerm = "";
	
	
    private String filePathString="LRBomReport";
    private String sysvar = "OnwerExportFilePath";
    
	private String currentDate = PubFun.getCurrentDate();
	//private String currentTime = PubFun.getCurrentTime();

	public LRBomBLReport() {
	}
	  SSRS tSSRS = new SSRS();

		ExeSQL aExeSQL = new ExeSQL();


		String strArr[] = null;

		
	/**
	 * 传输数据的公共方法
	 */
	public boolean check() {
		return true;
	}

	public boolean submitData(VData cInputData, String cOperate) {
		if (!cOperate.equals("PRINT")) {
			buildError("submitData", bundle.getString("Rule_Uselesscontrolcharacterstring"));
			return false;
		}
		// 将操作数据拷贝到本类中
		this.mOperate = cOperate;
		// 得到外部传入的数据,将数据备份到本类中
		if (!getInputData(cInputData)) {
			return false;
		}
		mResult.clear();
		if (!check()) {
			return false;
		}
		/** 准备所有要打印的数据 */
		long t1 = System.currentTimeMillis();
		if (!printReport()) {
			return false;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Your program has executed for "
				+ (int) ((t2 - t1) / 1000) + " seconds " + ((t2 - t1) % 1000)
				+ " micro seconds");
		return true;
	}
	private void buildError(String szFunc, String szErrMsg) {
		CError cError = new CError();
		cError.moduleName = "LRBomBLReport";
		cError.functionName = szFunc;
		cError.errorMessage = szErrMsg;
		this.mErrors.addOneError(cError);
	}

	/**
	 * 从输入数据中得到所有对象 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true
	 */
	public boolean getInputData(VData cInputData) {
		
		  // 全局变量
        mGlobalInput = (GlobalInput) cInputData.get(0);
        TransferData transferData = (TransferData) cInputData.get(1);
        BranchType = (String)transferData.getValueByName("BranchType");
        State = (String)transferData.getValueByName("State");
        ID = (String)transferData.getValueByName("ID");
        Name = (String)transferData.getValueByName("Name");
        IDTerm = (String)transferData.getValueByName("IDTerm");
        NameTerm = (String)transferData.getValueByName("NameTerm");
        StateTerm = (String)transferData.getValueByName("StateTerm");

        if (mGlobalInput == null) {
            CError.buildErr(this, bundle.getString("Src_UI_getInputDataErr"));
            return false;
        }
        return true;
		
	
	}
	private boolean printReport() {
		boolean flag = true;
		String reportTime = PubFun.getCurrentTime().substring(0, 2)
				+ PubFun.getCurrentTime().substring(3, 5)
				+ PubFun.getCurrentTime().substring(6, 8);
		String templetFileName = null;
		String reportFileName = null;
		String rvFNStartWith = null;
		templetFileName="LRBomReport.xls";// 模板名字
		reportFileName="LRBomReport_" + this.mGlobalInput.Operator.trim() + "_" + currentDate + reportTime + ".xls";// 要生成的报表的名字,不支持中文
		rvFNStartWith="LRBomReport_" + this.mGlobalInput.Operator.trim() + "_" + currentDate;// 删除服务器上缓存的文件名以rvFNStartWith开头的报表
		long usefullLifeSec = 0; // usefullLifeSec
		// 秒钟之前(小于usefullLifeSec秒)生成的同名报表为有效报表,无须查数据库重新生成

		// String rvFNStartWith = ManageCom + "_" + "WeekSalesQuery_"; //
		// 删除服务器上缓存的文件名以rvFNStartWith开头的报表
		long invalidationSec = usefullLifeSec * 2; // 删除报表时,
		// invalidationSec秒钟之内生成的报表不能删,该参数值必须比usefullLifeSec参数值大

		// -----------------------------------------------------------------

		ReportHelper helper = new ReportHelper(templetFileName, reportFileName,
				usefullLifeSec, rvFNStartWith, invalidationSec,sysvar,filePathString);
		ExcelInfo info = helper.getInfo();
		if (!info.exists()) {
			flag = getPrintData(helper);
		}
		mResult.add(0, info);
		return flag;
	}
	/**
	 * 打印方法
	 * 
	 * @return boolean
	 */
	private boolean getPrintData(ReportHelper helper) {

		//String ManageCom = (this.mGlobalInput.ManageCom).trim();
		/** 新建一个ListTable的实例 */
		ListTable tlistTable = new ListTable();
		tlistTable.setName("#default#");
		try {
			//tangyj0912
			
//			String strSQL="select (select codename from ldcode where codetype = 'branchtype' and code =bom.BranchType ),bom.id,bom.name,decode(bom.state, 'N', '无效', 'Y', '有效'),term.id,term.name,decode(term.state, 'N', '无效', 'Y', '有效'),(select codename from ldcode where codetype = 'ibrmscommandtype' and code =term.datatype ),(select codename from ldcode where codetype = 'calculate' and code =term.caltype ),term.calsql from lrbom bom,lrterm term where bom.id=term.bomid and 1=1";
//			String strSQL="select (select codename from ldcode where codetype = 'branchtype' and code =bom.BranchType ),bom.id,bom.name,(case bom.state when 'N' then '无效' when 'Y' then '有效' end),term.id,term.name,(case term.state when 'N' then '无效' when 'Y' then '有效' end),(select codename from ldcode where codetype = 'ibrmscommandtype' and code =term.datatype ),(select codename from ldcode where codetype = 'calculate' and code =term.caltype ),term.calsql from lrbom bom,lrterm term where bom.id=term.bomid and 1=1";
			String strSQL="select (select codename from ldcode where codetype = 'branchtype' and code =bom.BranchType ),bom.id,bom.name,bom.state,term.id,term.name,term.state,(select codename from ldcode where codetype = 'ibrmscommandtype' and code =term.datatype ),(select codename from ldcode where codetype = 'calculate' and code =term.caltype ),term.calsql from lrbom bom,lrterm term where bom.id=term.bomid and 1=1";
			
			String strParam="and bom.ID like'"+ID+"%'"+" "+"and bom.name like'"+Name+"%'"+" "+"and bom.BranchType like'"+BranchType+"%'"+" "+"and bom.state like'"+State+"%'"+" "+"and term.ID like'"+IDTerm+"%'"+" "+"and term.name like'"+NameTerm+"%'"+" "+"and term.state like'"+StateTerm+"%'"+" order by bom.id,term.id";
			
			strSQL = strSQL +strParam;

				System.out.println(strSQL);
				tSSRS = this.aExeSQL.execSQL(strSQL);
				int tRow = tSSRS.getMaxRow();
				if(tRow!=0){
					int order=1;
					for(int i = 1; i <= tRow; i++){
						
						strArr = new String[11];
						strArr[0] = ""+order++;
						strArr[1] = tSSRS.GetText(i, 1);
						strArr[2] = tSSRS.GetText(i, 2);
						strArr[3] = tSSRS.GetText(i, 3);
						strArr[4] = tSSRS.GetText(i, 4);
						strArr[5] = tSSRS.GetText(i, 5);
						strArr[6] = tSSRS.GetText(i, 6);
						strArr[7] = tSSRS.GetText(i, 7);
						strArr[8] = tSSRS.GetText(i, 8);
						strArr[9] = tSSRS.GetText(i, 9);
						strArr[10] = tSSRS.GetText(i, 10);
						tlistTable.add(strArr);
					}
					
				} else {
					strArr = new String[11];
					strArr[0] = " ";
					strArr[1] = " ";
					strArr[2] = " ";
					strArr[3] = " ";
					strArr[4] = " ";
					strArr[5] = " ";
					strArr[6] = " ";
					strArr[7] = " ";
					strArr[8] = " ";
					strArr[9] = " ";
					strArr[10] = " ";
					tlistTable.add(strArr);
				}
				

			System.out.println("tlistTable.size---" + tlistTable.size());
			if (tlistTable.size() == 0) {
				CError tError = new CError();
				tError.moduleName = "LAAgentDetailBL";
				tError.functionName = "getPrintData";
				tError.errorMessage = bundle.getString("Rule_Enquirycompleted,thesystemdoesnothaverelevantdataforthisprint!");
				this.mErrors.addOneError(tError);
				return false;
			}
		} catch (Exception ex) {
			/** @@错误处理 */
			CError tError = new CError();
			tError.moduleName = "LAAgentDetailBL";
			tError.functionName = "getPrintData";
			tError.errorMessage = ex.toString();
			this.mErrors.addOneError(tError);
			return false;
		}

		SimpleWorkbook workbook = null;
		try {
			workbook = helper.createWorkbook();
			/** 制表时间 */
			workbook.set("ExportDate", currentDate);
//			workbook._add(tlistTable);
			workbook._addListTable(tlistTable);
			workbook.write();
//			tlistTable = null;
//			workbook = null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (workbook != null)
				try {
					workbook.close();
					workbook = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return true;
	}
	

	/**
	 * 这个方法返回的结果中存放程序执行后的结果 如果程序需要返回数据，可以通过这个方法实现
	 * 
	 * @return 返回一个VData容器
	 */
	public VData getResult() {
		return mResult;
	}


}
