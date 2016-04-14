/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.schema.LMCalFactorSchema;
import com.sinosoft.lis.schema.LMCalModeSchema;
import com.sinosoft.lis.vschema.LMCalFactorSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.StrTool;
import com.sinosoft.utility.VData;
import com.sinosoft.lis.db.LMCalFactorDB;
import com.sinosoft.lis.db.LMCalModeDB;

/*
 * <p>Title: 保费计算类 </p>
 * <p>Description: 通过传入的保单信息和责任信息构建出保费信息和领取信息 </p>
 * <p>Copyright: Copyright (c) 2002</p>     
 * <p>Company: sinosoft</p>
 * @author HST
 * @version 1.0
 * @date 2002-07-01
 */
public class CalculatorAssess {
    /** 错误处理类，每个需要错误处理的类中都放置该类 */
    public CErrors mErrors = new CErrors();

    /** 计算需要用到的保单号码 */
    public String PolNo;

    /** 各种要素存放的琏表
     *  1--基本要素、和常量要素相同，但是优先级最低
     *  2--扩展要素，根据SQL语句从新计算
     *  3--常量要素（只取默认值）
     */
    private LMCalFactorSet mCalFactors1 = new LMCalFactorSet(); //存放基本要素

    public LMCalFactorSet mCalFactors = new LMCalFactorSet();

    // @Field
    //计算编码
    private String CalCode = "";
    //算法对应SQL语句所在表结构
    private LMCalModeSchema mLMCalMode = new LMCalModeSchema();

//    private CachedRiskInfo mCRI = CachedRiskInfo.getInstance();

    /**
     * 增加基本要素
     * @param cFactorCode 要素的编码
     * @param cFactorValue  要素的数据值
     */
    public void addBasicFactor1(String cFactorCode, String cFactorValue) {
        LMCalFactorSchema tS = new LMCalFactorSchema();
        tS.setFactorCode(cFactorCode);
        tS.setFactorDefault(cFactorValue);
        tS.setFactorType("1");
        mCalFactors1.add(tS);
    }
    public void addBasicFactor(String cFactorCode, String cFactorValue) {
        LMCalFactorSchema tS = new LMCalFactorSchema();
        tS.setFactorCode(cFactorCode);
        tS.setFactorDefault(cFactorValue);
        tS.setFactorType("3");
        mCalFactors1.add(tS);
    }
    // @Method
    public void setCalCode(String tCalCode) {
        CalCode = tCalCode;
    }

  	/**
  	 * 获取LMCalFactor
  	 * 
  	 * @param strCalCode
  	 * @return LMCalFactorSet
  	 */
  	private LMCalFactorSet getLMCalFactor(String strCalCode) {
  		LMCalFactorDB tLMCalFactorDB = new LMCalFactorDB();
  		tLMCalFactorDB.setCalCode(strCalCode);
  		LMCalFactorSet tLMCalFactorSet = tLMCalFactorDB.query();
  		if (tLMCalFactorDB.mErrors.needDealError()) {
  			mErrors.copyAllErrors(tLMCalFactorDB.mErrors);
  			return null;
  		}
  		return tLMCalFactorSet;
  	}
  	
  	/**
  	 * 获取LMCalModeSchema
  	 * @param strCalCode
  	 * @return LMCalModeSchema
  	 */
  	private LMCalModeSchema getLMCalMode(String strCalCode){
      LMCalModeDB tLMCalModeDB = new LMCalModeDB();
      LMCalModeSchema tSchema = new LMCalModeSchema();
      
      LMCalModeSchema kSchema = new LMCalModeSchema();
      kSchema.setCalCode(strCalCode);
      tLMCalModeDB.setSchema(kSchema);
      tSchema = tLMCalModeDB.query().get(1);
      
     /* tLMCalModeDB.setCalCode(strCalCode);

      if (!tLMCalModeDB.getInfo())
      {
          mErrors.copyAllErrors(tLMCalModeDB.mErrors);
          return null;
      }
      return tLMCalModeDB.getSchema();*/
      return tSchema;
  	}
  	
    /**
     * 公式计算函数
     * @return: String 计算的结果，只能是单值的数据（数字型的转换成字符型）
     * @author: YT
     **/
    public String calculate() {

        System.out.println("start calculate++++++++++++++");
        if (!checkCalculate()) 
        {
            return "0";
        }
        //取得数据库中计算要素
        LMCalFactorSet tLMCalFactorSet = this.getLMCalFactor(CalCode);
//                mCRI.findCalFactorByCalCodeClone(CalCode);
        System.out.println("calCode :" + CalCode);

        if (tLMCalFactorSet == null) 
        {
            return "0";
        }

        mCalFactors.add(tLMCalFactorSet);
        //增加基本要素
        mCalFactors.add(mCalFactors1);
        //解释计算要素
        if (!interpretFactors()) 
        {
            return "0";
        }

        //读取SQL语句
        if (!getSQL()) 
        {
            return "0";
        }

        //解释SQL语句中的变量--要素值
        if (!interpretFactorInSQL()) 
        {
            return "0";
        }

        //解释SQL语句中的类
        if (!interpretClassInSQL()) 
        {
            return "0";
        }

        //执行SQL语句
        System.out.println(" Interpret SQL Over.....");
        return mLMCalMode.getCalSQL();
       // return mLMCalMode.getCalSQL();
    }

    /**
     * 解释SQL语句中的变量
     * @return boolean
     */
    private boolean interpretFactorInSQL() {
        String tSql, tStr = "";
        tSql = mLMCalMode.getCalSQL();
       // tSql = mLMCalMode.getCalSQL();
//    tSql=tSql.toLowerCase() ;
        try {
            while (true) {
                tStr = PubFun.getStr(tSql, 2, "?");
                if (tStr.equals("")) {
                    break;
                }
                System.out.println("tStr--"+tStr);
                LMCalFactorSchema tLMCalFactorSchema = getValueByName(tStr);
//                System.out.println("1-------"+tLMCalFactorSchema.getCalCode());
//                System.out.println("1-------"+tLMCalFactorSchema.getFactorCalCode());
//                System.out.println("1-------"+tLMCalFactorSchema.getFactorCode());
//                System.out.println("1-------"+tLMCalFactorSchema.getFactorDefault());
//                System.out.println("1-------"+tLMCalFactorSchema.getFactorGrade());
//                System.out.println("1-------"+tLMCalFactorSchema.getFactorName());
//                System.out.println("1-------"+tLMCalFactorSchema.getFactorType());//来自于calindexnew.java
                if(!tLMCalFactorSchema.getFactorType().equals("3"))
                {
//                	String tStr1 = tStr.trim();
//                if(tStr1.equals("AgentCode")|| tStr1.equals("AgentKind")||tStr1.equals("EmployDate")||tStr1.equals("BranchCode")
//                		|| tStr1.equals("AgentGroup")||tStr1.equals("Department")||tStr1.equals("Distict") || tStr1.equals("ManageCom")){
                	//替换变量
                	tSql = StrTool.replaceEx(tSql, "'?" + tStr.trim() + "?'", tLMCalFactorSchema.getFactorDefault());
                	tSql = StrTool.replaceEx(tSql, "?" + tStr.trim() + "?", tLMCalFactorSchema.getFactorDefault());
                }
                else
                {
                		   tSql = StrTool.replaceEx(tSql, "?" + tStr.trim() + "?", tLMCalFactorSchema.getFactorDefault());
               
                	
                }
//        tSql=tSql.replace(tStr,getValueByName(tStr));
            }
        } 
        catch (Exception ex) 
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "CalculatorNew";
            tError.functionName = "interpretFactorInSQL";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            this.mErrors.addOneError(tError);
            return false;
        }
        mLMCalMode.setCalSQL(tSql);
        //mLMCalMode.setCalSQL(tSql);
        return true;
    }

    /**
     * 计算子要素的值
     * @param cF LMCalFactorSchema
     * @return String
     */
    private String calSubFactors(LMCalFactorSchema cF) {
        int i, iMax;
        String tReturn = "";
        LMCalFactorSchema tC = new LMCalFactorSchema();
        CalculatorNew tNewC = new CalculatorNew();
        iMax = mCalFactors.size();
        for (i = 1; i <= iMax; i++) {
            tC = mCalFactors.get(i);
            //如果是基本要素或常量要素，则传入下一个要素中
            if (tC.getFactorType().toUpperCase().equals("1") ||
                tC.getFactorType().toUpperCase().equals("3")) 
            {
                tNewC.mCalFactors.add(tC);
            }
        }
        tNewC.setCalCode(cF.getFactorCalCode());
        System.out.println("----SubFactor---calcode = " + cF.getFactorCalCode());
        tReturn = String.valueOf(tNewC.calculate());
        System.out.println("----SubFactor = " + tReturn);
        //如果有错误，则将错误拷贝到上一要素,并且返回"0"
        if (tNewC.mErrors.needDealError()) {
            this.mErrors.copyAllErrors(tNewC.mErrors);
            tReturn = "0";
        }
        return tReturn;
    }

    /**
     * 读取SQL语句
     * @return boolean
     */
    private boolean getSQL() {
        LMCalModeSchema tLMCalModeSchema = this.getLMCalMode(CalCode);

        if (tLMCalModeSchema == null) {
            CError tError = new CError();
            tError.moduleName = "CalculatorNew";
            tError.functionName = "getSql";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            this.mErrors.addOneError(tError);
            return false;
        }

        mLMCalMode.setSchema(tLMCalModeSchema);

        return true;
    }

    /**
     * 解释要素连表中的非变量要素
     * @return boolean
     */
    private boolean interpretFactors() {
        int i, iMax;
        LMCalFactorSchema tC = new LMCalFactorSchema();
        iMax = mCalFactors.size();
        for (i = 1; i <= iMax; i++) 
        {
            tC = mCalFactors.get(i);
            //如果是扩展要素，则解释该扩展要素
            if (tC.getFactorType().toUpperCase().equals("2")) 
            {
            	System.out.println("calSubFactors(tC)--"+calSubFactors(tC));
                tC.setFactorDefault("("+calSubFactors(tC)+")");
                //如果在计算子要素的时候发生错误，则返回false
                if (this.mErrors.needDealError()) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 校验计算的输入是否足够
     * @return boolean 如果不正确返回false
     */
    private boolean checkCalculate() {
        if (CalCode == null || CalCode.equals("")) {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "CalculatorNew";
            tError.functionName = "checkCalculate";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            this.mErrors.addOneError(tError);
            return false;
        }
        return true;
    }

    /**
     * 根据变量名得到变量的值
     * @param cVarName String
     * @return String 如果不正确返回"",否则返回变量值
     */
    private LMCalFactorSchema getValueByName(String cVarName) {
        cVarName = cVarName.toLowerCase();
        int i, iMax;
        //String tReturn = "";
        LMCalFactorSchema tC = new LMCalFactorSchema();
        iMax = mCalFactors.size();
        for (i = 1; i <= iMax; i++) {
            tC = mCalFactors.get(i);
            if (tC.getFactorCode().toLowerCase().equals(cVarName)) {
                //tReturn = tC.getFactorDefault();
                break;
            }
        }
        return tC;
    }

    private boolean interpretClassInSQL() {
        String tSql, tStr = "", tStr1 = "";
        tSql = mLMCalMode.getCalSQL();
        //tSql = mLMCalMode.getCalSQL();
//    tSql=tSql.toLowerCase() ;
        try {
            while (true) {
                tStr = PubFun.getStr(tSql, 2, "#");
                if (tStr.equals("")) {
                    break;
                }
                tStr1 = "#" + tStr.trim() + "#";
                //替换变量
                tSql = StrTool.replaceEx(tSql, tStr1, getValueByClassName(tStr));
            }
        } catch (Exception ex) {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "CalculatorNew";
            tError.functionName = "interpretFactorInSQL";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
            this.mErrors.addOneError(tError);
            return false;
        }
        mLMCalMode.setCalSQL(tSql);
        //mLMCalMode.setCalSQL(tSql);
        return true;
    }

    private String getValueByClassName(String cVarName) {
        String End = "";
        String className = cVarName.substring(0, cVarName.indexOf("("));
        String param = cVarName.substring(cVarName.indexOf("(") + 1,
                                          cVarName.indexOf(")"));

        VData tVData = new VData();
        VData rVData = new VData();
        int j = 0;
        int i = -1;
        while ((i = param.indexOf(",")) != -1) {
            tVData.add(param.substring(0, i));
            param = param.substring(i + 1);
        }
        if (param.length() != 0 && tVData.indexOf(",") == -1) {
            tVData.add(param);
        }
        try {
            Class tClass = Class.forName("com.sinosoft.lis.calclass." +
                                         className);
            CalCommon tservice = (CalCommon) tClass.newInstance();
            tservice.submitData(tVData);
            rVData = tservice.getResult();
        } catch (Exception e) {
            e.printStackTrace();
        } while (true) {
            if (rVData.getObject(j) != null) {
                if (j == 0) {
                    End = rVData.getObject(j).toString();
                } else {
                    End = End + "," + rVData.getObject(j).toString();
                }
                j++;
            } else break;
        }
        return End;
    }

    /**
     * 测试函数
     * @param args String[]
     */
//    public static void main(String[] args) {
//        CalculatorNew mCalculatorNew = new CalculatorNew();
//        mCalculatorNew.addBasicFactor("erw1", "test1");
//        mCalculatorNew.addBasicFactor("erw2", "test2");
//        mCalculatorNew.setCalCode("test");
//        System.out.println(mCalculatorNew.calculate());
////    LMCalFactorSchema tLMCalFactorSchema=new LMCalFactorSchema();
////    tC.addBasicFactor("PolNo","00000120021100000000");
////    tC.setCalCode("001001") ;
////    System.out.println(tC.calculate());
////    if(tC.mErrors.needDealError())
////    //      System.out.println(tC.mErrors.getFirstError());
//
//    }

}
