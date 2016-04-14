package com.sinosoft.lis.taskservice;

import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;

public class Test extends TaskThread{
	 private VData mVData = new VData();
	 private GlobalInput mG = new GlobalInput();
	  private String mOperate = new String();
	@Override
	public void run() {
		 getParameters();
		System.out.println("------------->>>>lovehot's task is run!");
	}
	
//	public static void main(String[] args) {
//		new Test().run();
//	}
    private void getParameters()
    {
 		 TransferData tTransferData = new TransferData();
         mVData.add(mG);
         mVData.add(tTransferData);
         mOperate=(String) mParameters.get("CalType");
         if(!"recal".equals(mOperate)){
        	 mOperate="cal";
         }
    }
}
