package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
import java.text.ParseException;

import com.sinosoft.utility.CError;
import com.sinosoft.utility.VData;
import com.sinosoft.utility.CErrors;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2013</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class ExcelDataImportUI
{
    public CErrors mErrors = new CErrors();
    private VData mResult = new VData();
    public String tPath = ""; 

    public ExcelDataImportUI()
    {
    }
    /**
         "+bundle.getString("waitForTran")+"
         */
    public boolean submitData(VData cInputData,String tPathName){
    	System.out.println(tPathName);
    	Class uiClass = null;
		String className = tPathName;
        try {
			uiClass = Class.forName(className);
			Object obj = uiClass.newInstance();
			uiClass.getMethod("submitData", new Class[]{VData.class});
			Method method = uiClass.getMethod("submitData", new Class[]{VData.class}); //方法名，参数数组
			mErrors=(CErrors)method.invoke(obj, new Object[]{cInputData});

			System.out.print("打印导入失败信息：");
			for(int j=0;j<mErrors.getErrorCount();j++){
				CError ttError=mErrors.getError(j);
				System.out.println(ttError.errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        return true;
    }
    public VData getResult() {
		System.out.print("打印导入失败信息：");
		for(int j=0;j<mErrors.getErrorCount();j++){
			CError ttError=mErrors.getError(j);
			System.out.println(ttError.errorMessage);
		}
        return mResult;
    }

//    public static void main(String[] args){
//    	ExcelDataImportUI tui=new ExcelDataImportUI();
//    	GlobalInput gb=new GlobalInput();
//    	gb.Operator="001";
//    	VData vd=new VData();
//    	vd.add(gb);
//    	vd.add("D:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/CCMS/upload/LACampaignImport_templet.xls");
////    	String ttpath="com.sinosoft.lis.aademo.Test";
//    	String ttpath="com.sinosoft.lis.sys.LACampaignCfgImportBL";
//    	tui.submitData(vd, ttpath);
//
//    }
}
