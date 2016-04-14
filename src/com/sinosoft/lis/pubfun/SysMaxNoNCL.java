/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;
/**
 * <p>Title: Web业务系统</p>
 * <p>Description:系统号码管理（新华人寿核心业务系统）生成系统号码 </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author Liuqiang
 * @version 1.0
 */






import java.sql.Connection;

import com.sinosoft.lis.db.LDMaxNoDB;
import com.sinosoft.lis.schema.LDMaxNoSchema;
import com.sinosoft.lis.vschema.LDMaxNoSet;
import com.sinosoft.utility.*;

import java.math.BigInteger;


public class SysMaxNoNCL
    implements com.sinosoft.lis.pubfun.SysMaxNo {

    public SysMaxNoNCL() {
    }

    /**
     *<p>生成流水号的函数<p>
     *<p>号码规则：机构编码  日期年  校验位   类型    流水号<p>
     *<p>          1-6     7-10   11     12-13   14-20<p>
     * @param cNoType 为需要生成号码的类型
     * @param cNoLimit 为需要生成号码的限制条件（要么是SN，要么是机构编码）
     * @param cVData 为需要生成号码的业务相关限制条件
     * @return 生成的符合条件的流水号，如果生成失败，返回空字符串""
     */
    public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData) {
        //传入的参数不能为空，如果为空，则直接返回
        if ( (cNoType == null) || (cNoType.trim().length() <= 0) || (cNoLimit == null)) {
            System.out.println("NoType长度错误或者NoLimit为空");
            return null;
        }

        //默认流水号位数
        int serialLen = 10;
        String tReturn = null;
        cNoType = cNoType.toUpperCase();
//        System.out.println("-----------cNoType:"+cNoType+"  cNoLimit:"+cNoLimit);

        //cNoLimit如果是SN类型，则cNoType只能是下面类型中的一个
        if (cNoLimit.trim().toUpperCase().equals("SN")) {
            if (cNoType.equals("COMMISIONSN") ||
                cNoType.equals("GRPNO") || cNoType.equals("CUSTOMERNO") ||
                cNoType.equals("SUGDATAITEMCODE") ||
                cNoType.equals("SUGITEMCODE") ||
                cNoType.equals("SUGMODELCODE") ||
                cNoType.equals("SUGCODE") ||
                cNoType.equals("ACCNO") || cNoType.equals("RPTONLYNO")) {
                serialLen = 9;
            }
            else {
                System.out.println("错误的NoLimit");
                return null;
            }
        }

        //扫描批次号,Added by niuzj 2006-04-27,每个分公司每天一个批次号
        //前8位为机构代码,再8位为日期,再1位是业务类型,后3位为大流水号
        if (cNoType.equals("SCANNO")) {
            //cNoType为“SCANNO”
            //cNoLimit为登陆机构代码
            //cVData为业务类型
            String tStr = PubFun.getCurrentDate();
            String tMng = cNoLimit.trim(); //登录机构代码
            String tBusstype = ""; //业务类型

            if (cVData.get(0).equals(null)) {
                System.out.println("传入的业务类型cVData为空");
                return null;
            }
            else if (cVData.get(0).equals("TB")) { //新契约
                tBusstype = "1";
            }
            else if (cVData.get(0).equals("BQ")) { //保全
                tBusstype = "2";
            }
            else if (cVData.get(0).equals("LP")) { //理赔
                tBusstype = "3";
            }
            else if (cVData.get(0).equals("XQ")) { //续期
                tBusstype = "4";
            }
            else {
                System.out.println("传入的业务类型cVData错误");
                return null;
            }

            if (tMng.length() == 2) { //2位管理机构,前面补6个0
                tReturn = "000000" + tMng + tStr.substring(0, 4) +
                    tStr.substring(5, 7) + tStr.substring(8, 10) + tBusstype;
            }
            else if (tMng.length() == 4) { //4位管理机构,前面补4个0
                tReturn = "0000" + tMng + tStr.substring(0, 4) +
                    tStr.substring(5, 7) + tStr.substring(8, 10) + tBusstype;
            }
            else if (tMng.length() == 6) { //6位管理机构,前面补2个0
                tReturn = "00" + tMng + tStr.substring(0, 4) +
                    tStr.substring(5, 7) + tStr.substring(8, 10) + tBusstype;
            }
            else if (tMng.length() == 8) { //8位管理机构,前面不补0
                tReturn = tMng + tStr.substring(0, 4) + tStr.substring(5, 7) +
                    tStr.substring(8, 10) + tBusstype;
            }
            else {
                System.out.println("传入的机构代码cNoLimit错误");
                return null;
            }
            serialLen = 3; //3位为大流水号
        }
        
//        Connection conn = DBConnPool.getConnection();
//
//        if (conn == null) {
//            System.out.println("CreateMaxNo : fail to get db connection");
//            return tReturn;
//        }

        int tMaxNo = 0;
        //  tReturn=cNoLimit;
        if (cNoType.equals("CONTPLANCODE")) {
        	 tReturn = cNoLimit.trim();
        	 String ContPlanType=((TransferData)cVData.getObjectByObjectName("TransferData", 0)).getValueByName("ContPlanType").toString();
        	  if (tReturn.length() >= 4) {
        		  cNoLimit = tReturn.substring(0, 4);
                  tReturn = ContPlanType+ "0" + tReturn.substring(2, 4);
              }else {
            	 //如果为总公司登录的话，则编码规则为　销售渠道+0+00（公司代码）+四位流水
				cNoLimit=tReturn;
				tReturn = ContPlanType+ "0" + "00";
			}
            serialLen = 4;
        }else {
        	cNoLimit = tReturn;
		}
        
        //20150110 tianzf CMS_HK使用sqlserver数据库，不能直接使用createmaxno函数对数据库进行Insert/Update操作，改为使用java function操作
        tMaxNo=newCreateMaxNo(cNoType,cNoLimit);
//        try {
//            //开始事务
//            //查询结果有3个： -- added by Fanym
//            //全部采用直接执行SQL语句，只要有其他事务锁定了本行，立即返回NULL
//            //如果没有锁定，则本事务锁定，查询得到结果则UPDATE，没有则INSERT
//            conn.setAutoCommit(false);
//            
//            String tSQL=" select createmaxno('"+cNoType+"','"+cNoLimit+"') from dual "; //modify by tianwk
//            ExeSQL exeSQL = new ExeSQL(conn);
//            String result = null;
//            result = exeSQL.getOneValue(tSQL);
//            tMaxNo = Integer.parseInt(result) ;
//            conn.commit();
//            conn.close();
//        }
//        catch (Exception Ex) {
//            try {
//                conn.rollback();
//                conn.close();
//                return null;
//            }
//            catch (Exception e1) {
//                e1.printStackTrace();
//
//                return null;
//            }
//        }

        String tStr = String.valueOf(tMaxNo);
        tStr = PubFun.LCh(tStr, "0", serialLen);
        if (tReturn.equals("SN")) {
            tReturn = tStr.trim();
            //tReturn = tStr.trim() + "0";
        }
        else {
            tReturn = tReturn.trim() + tStr.trim();
        }
        System.out.println("------tReturn:" + tReturn);
        return tReturn;
    }

    /**
     *<p>生成流水号的函数<p>
     *<p>号码规则：机构编码  日期年  校验位   类型    流水号<p>
     *<p>          1-6     7-10   11     12-13   14-20<p>
     * @param cNoType 为需要生成号码的类型
     * @param cNoLimit 为需要生成号码的限制条件（要么是SN，要么是机构编码）
     * @return 生成的符合条件的流水号，如果生成失败，返回空字符串""
     */
    public String CreateMaxNo(String cNoType, String cNoLimit) {
        //传入的参数不能为空，如果为空，则直接返回
        if ( (cNoType == null) || (cNoType.trim().length() <= 0) ||
            (cNoLimit == null)) {
            System.out.println("NoType长度错误或者NoLimit为空");

            return null;
        }

        //默认流水号位数
        int serialLen = 10;
        String tReturn = null;
        cNoType = cNoType.toUpperCase();
        //System.out.println("-----------cNoType:"+cNoType+"  cNoLimit:"+cNoLimit);

        //cNoLimit如果是SN类型，则cNoType只能是下面类型中的一个
        if (cNoLimit.trim().toUpperCase().equals("SN")) { //modify by yt 2002-11-04
            // 		if (cNoType.equals("GRPNO") || cNoType.equals("CUSTOMERNO") || cNoType.equals("SugDataItemCode") || cNoType.equals("SugItemCode") || cNoType.equals("SugModelCode") || cNoType.equals("SugCode"))
            if (cNoType.equals("COMMISIONSN") ||
                cNoType.equals("GRPNO") || cNoType.equals("CUSTOMERNO") ||
                cNoType.equals("SUGDATAITEMCODE") ||
                cNoType.equals("SUGITEMCODE") ||
                cNoType.equals("SUGMODELCODE") ||
                cNoType.equals("SUGCODE") ||
                cNoType.equals("ACCNO") || cNoType.equals("RPTONLYNO")
                || cNoType.equals("IMPORTBATCHNO")
                || cNoType.equals("TRACELOGBATCHNO")
                || cNoType.equals("TRACELOGNO")
                || cNoType.equals("TASKRUNLOGNO")
                || cNoType.equals("BONUSDISKLOGNO")
                || cNoType.equals("LCURGELOGNO")
                || cNoType.equals("STOPREASONNO")
                || cNoType.equals("TASKRUNLOGSN")) {
                serialLen = 9;
            }else if(cNoType.equals("CARDGRPPRTNO")||
                   cNoType.equals("CARDBALANO") ||
		   cNoType.equals("TPASERIALNO")||
                   cNoType.equals("TPABATNO")||
                   cNoType.equals("SUBGRPSERIALNO")||
                   cNoType.equals("SUBSERIALNO")
		)
            {
            		serialLen = 12;
            }
            else {
                System.out.println("错误的NoLimit");

                return null;
            }
        }

        //航意险6位流水号
        if (cNoType.equals("AIRPOLNO")) { //modify by yt 2002-11-04
            serialLen = 6;
        }
        //特殊险种流水号长度处理
        if (cNoType.equals("AGENTCODE") || cNoType.equals("MANAGECOM")) {
            serialLen = 4;
        }

        tReturn = cNoLimit.trim();
        //System.out.println("tReturn:"+tReturn);

        String tCom = ""; //两位机构
        String tCenterCom = ""; //中支公司

        if (tReturn.length() >= 4) {
            tCom = tReturn.substring(2, 4);
            tCom = "0" + tCom; //加一位较验位
            if (tReturn.length() >= 6){
                tCenterCom = tReturn.substring(4, 6);
            }
            else{
                tCenterCom = "00";
            }
            tReturn = tReturn.substring(0, 4);
        }

        //生成各种号码
        //投保单险种号码
        if (cNoType.equals("PROPOSALNO")) {
            tReturn = "11" + tCom;
        }

        //集体投保单险种号码
        else if (cNoType.equals("GRPPROPOSALNO")) {
            tReturn = "12" + tCom;
        }

        //总单投保单号码
        else if (cNoType.equals("PROPOSALCONTNO")) {
            tReturn = "13" + tCom;
        }

        //集体投保单号码ProposalGrpContNo,LDMaxNo里最大长度为15，所以用ProGrpContNo代替
        else if (cNoType.equals("PROGRPCONTNO")) {
            tReturn = "14" + tCom;
        }
        //add by lvliye 20090326
        //卡单集体投保单号
        else if (cNoType.equals("CARDGRPPRTNO")) {
            tReturn = "15";
            serialLen = 12;
        }
        //卡单结算号
        else if (cNoType.equals("CARDBALANO")) {
            tReturn = "33" ;
            serialLen = 12;
        }
        //end

        //保单险种号码
        else if (cNoType.equals("POLNO")) {
            tReturn = "21" + tCom;
        }

        //集体保单险种号码
        else if (cNoType.equals("GRPPOLNO")) {
            tReturn = "22" + tCom;
        }

        //合同号码
        else if (cNoType.equals("CONTNO")) {
            //System.out.println("进入我的底盘");
            //tReturn = "00" + tCom;
            //tReturn = PubFun1.creatVerifyDigit(tReturn);
            tReturn = "0";
            serialLen = 9;
        }

        //集体合同号码
        else if (cNoType.equals("GRPCONTNO")) {
            tReturn = "0";
            serialLen = 9;
        }

        //交费通知书号码
        else if (cNoType.equals("PAYNOTICENO")) {
            tReturn = "31" + tCom;
            //tReturn = tCom.substring(1);
            serialLen = 8;
        }

        //交费收据号码
        else if (cNoType.equals("PAYNO")) {
            tReturn = "32" + tCom;
        }

        //给付通知书号码
        else if (cNoType.equals("GETNOTICENO")) {
            tReturn = "36" + tCom;
            serialLen = 8;
        }

        //给付通知书号码
        else if (cNoType.equals("GETNO")) {
            tReturn = "37" + tCom;
        }

        //保全受理号码
        else if (cNoType.equals("EDORACCEPTNO")) {
            String tStr = PubFun.getCurrentDate();
            tReturn = "61" + tStr.substring(0, 4) + tStr.substring(5, 7) +
                tStr.substring(8, 10);
            serialLen = 6;
        }
        //保全试算流水号
        else if (cNoType.equals("EDORTESTNO")) {
            String tStr = PubFun.getCurrentDate();
            tReturn = "64" + tStr.substring(0, 4) + tStr.substring(5, 7) +
                tStr.substring(8, 10);
            serialLen = 6;
        }
        //批改申请号码
        else if (cNoType.equals("EDORAPPNO")) { //新华申请批单号和批单号合一，批单号可以不连续
            String tStr = PubFun.getCurrentDate();
            tReturn = "60" + tStr.substring(0, 4) + tStr.substring(5, 7) +
                tStr.substring(8, 10);
            serialLen = 6;
        }

        //批单号码
        else if (cNoType.equals("EDORNO")) {
            String tStr = PubFun.getCurrentDate();
            tReturn = "60" + tStr.substring(0, 4) + tStr.substring(5, 7) +
                tStr.substring(8, 10);
            serialLen = 6;
        }

        //集体批单申请号码
        else if (cNoType.equals("EDORGRPAPPNO")) {
            String tStr = PubFun.getCurrentDate();
            tReturn = "63" + tStr.substring(0, 4) + tStr.substring(5, 7) +
                tStr.substring(8, 10);
            serialLen = 6;
        }

        //集体批单号码
        else if (cNoType.equals("EDORGRPNO")) {
            String tStr = PubFun.getCurrentDate();
            tReturn = "63" + tStr.substring(0, 4) + tStr.substring(5, 7) +
                tStr.substring(8, 10);
            serialLen = 6;
        }

        //核保测算号码
        else if (cNoType.equals("ASKPRTNO")) {
            String tStr = PubFun.getCurrentDate();
            //登录机构为86，则补两位！
            if (tReturn.length() == 2){
                tReturn = "00" + tReturn;
            }
            tReturn = tReturn + tStr.substring(2, 4) + tStr.substring(5, 7) +
                tStr.substring(8, 10);
            cNoLimit = tReturn;
            serialLen = 3;
        }
        //套餐编码
        else if (cNoType.equals("CONTPLANCODE")) {
            //登录机构为86，则补两位！
            if (tReturn.length() == 2){
                tReturn = tReturn + "00";
            }
            else{
                tReturn = tCom.substring(1,3) + tCenterCom;
            }
            cNoLimit = tReturn;
            serialLen = 4;
        }



        //单证扫描批次号,Added by niuzj 2005-10-22,每个分公司每天一个批次号
        //前8位为机构代码,再8位为日期,后4位为大流水号
       else if (cNoType.equals("SCANNO"))
       {
           String tStr = PubFun.getCurrentDate();
           String tMng = cNoLimit.trim();   //登录机构代码
           if(tMng.length() == 2)   //2位管理机构,前面补6个0
           {
              tReturn ="000000" + tMng + tStr.substring(0,4) + tStr.substring(5,7) + tStr.substring(8,10);
           }
           else if(tMng.length() == 4)   //4位管理机构,前面补4个0
           {
             tReturn ="0000" + tMng + tStr.substring(0,4) + tStr.substring(5,7) + tStr.substring(8,10);
           }
           else if(tMng.length() == 6)  //6位管理机构,前面补2个0
           {
             tReturn ="00" + tMng + tStr.substring(0,4) + tStr.substring(5,7) + tStr.substring(8,10);
           }
           else  //8位管理机构,前面不补0
           {
               tReturn = tMng + tStr.substring(0,4) + tStr.substring(5,7) + tStr.substring(8,10);
           }
           serialLen = 4;    //4位为大流水号
       }


//         //事件编号(新华)
//         else if (cNoType.equals("ACCNO"))
//        {
//            tReturn = "8" + tCom;
//        }
//
//        //赔案编号(新华)
//        else if (cNoType.equals("RPTONLYNO"))
//       {
//           tReturn = "9" + tCom;
//        }

        //报案编号
        else if (cNoType.equals("RPTNO")) {
            tReturn = "50" + tCom;
        }

        //立案编号
        else if (cNoType.equals("RGTNO")) {
            tReturn = "51" + tCom;
        }

        //赔案编号
        else if (cNoType.equals("CLMNO")) {
            tReturn = "52" + tCom;
        }

        //拒案编号
        else if (cNoType.equals("DECLINENO")) {
            tReturn = "53" + tCom;
        }

        //报案分案编号
        else if (cNoType.equals("SUBRPTNO")) {
            tReturn = "54" + tCom;
        }

        //立案分案编号
        else if (cNoType.equals("CASENO")) {
            tReturn = "55" + tCom;
        }

	 //理赔外包团体流水号（标识号）
        else if (cNoType.equals("TPASERIALNO")){
        	tReturn = "56";
            serialLen = 12;
        }
        
        //理赔外包团体批次号
        else if (cNoType.equals("TPABATNO")){
        	tReturn = "57";
            serialLen = 12;
        }
        
        //理赔外包团案轨迹表流水号
        else if (cNoType.equals("SUBGRPSERIALNO")){
        	tReturn = "58";
            serialLen = 12;
        }
        
        //理赔外包个案轨迹流水号
        else if (cNoType.equals("SUBSERIALNO")){
        	tReturn = "59";
            serialLen = 12;
        }

        //合同号
        else if (cNoType.equals("PROTOCOLNO")) {
            tReturn = "71" + tCom;
        }

        //单证印刷号码
        else if (cNoType.equals("PRTNO")) {
            tReturn = "80" + tCom;
        }

        //打印管理流水号
        else if (cNoType.equals("PRTSEQNO")) {
            tReturn = "81" + tCom;
            serialLen = 8;
        }

        //打印管理流水号
        else if (cNoType.equals("PRTSEQ2NO")) {
            tReturn = "82" + tCom;
        }
        //保单打印批次号
        else if (cNoType.equals("CONTPRTSEQ")) {
            tCom = tCom.substring(1, 3);
            tReturn = "83" + tCom;
            serialLen = 7;

        }
        //银保通对帐批次号
        else if (cNoType.equals("YBTNO")) {
            tReturn = "0";
            serialLen = 9;
        }

        //回收清算单号
        else if (cNoType.equals("TAKEBACKNO")) {
            tReturn = "61" + tCom;
        }

        //银行代扣代付批次号
        else if (cNoType.equals("BATCHNO")) {
            tReturn = "62" + tCom;
        }

        //接口凭证id号
        else if (cNoType.equals("VOUCHERIDNO")) {
            tReturn = "63" + tCom;
        }

        //佣金号码
        else if (cNoType.equals("WAGENO")) {
            tReturn = "90" + tCom;
        }

        //卡单结算号
        else if (cNoType.equals("BALANCENO"))
        {
            String tStr = PubFun.getCurrentDate();
            tReturn = tReturn + tStr.substring(2,4)+tStr.substring(5,7)+tStr.substring(8,10);
            serialLen = 4;
        }
        //流水号
        else if (cNoType.equals("SERIALNO")) {
            tReturn = "98" + tCom;
        }
      //ljspaypersonb中流水号
        else if (cNoType.equals("LJSSERIALNO")) {
            tReturn = "97" + tCom;
        }
        //生存领取审核批次号
        else if (cNoType.equals("LIVEGETAPPRBATNO")) {
            tReturn = "96" + tCom;
        }

        //凭证流水号
        else if (cNoType.equals("BILLSEQNO")) {
          serialLen = 10;
        }
       
        //失效日处理特殊日期流水号
        else if (cNoType.equals("INVALIDDEAL")) {
          serialLen = 8;
        }
        
        //对接凭证号
        else if (cNoType.equals("SAPDOCCODE")) {
          String tStr = PubFun.getCurrentDate();
          tReturn = "800" +tCom + tStr.substring(0,4)+tStr.substring(5,7)+ tStr.substring(8,10);
          serialLen = 7;

        }
        //add by lizhanwu 20110718
        //产寿交叉保单序列号
        else if(cNoType.equals("CROSSAPPCONTNO")){
        	String tStr = PubFun.getCurrentDate();
        	tReturn = tCom.substring(1, 3)+tCenterCom+tStr.substring(2, 4);
         	serialLen = 6;
        }
        //end add
//        else
//        {
//            tReturn += "99";
//        }

        //其他
//        Connection conn = DBConnPool.getConnection();
//
//        if (conn == null) {
//            System.out.println("CreateMaxNo : fail to get db connection");
//
//            return tReturn;
//        }

        int tMaxNo = 0;
        cNoLimit = tReturn;
        //System.out.println("cNoLimit:"+cNoLimit);

        //20150110 tianzf CMS_HK使用sqlserver数据库，不能直接使用createmaxno函数对数据库进行Insert/Update操作，改为使用java function操作
        tMaxNo=newCreateMaxNo(cNoType,cNoLimit);
//        try {
//            //开始事务
//            //查询结果有3个： -- added by Fanym
//            //全部采用直接执行SQL语句，只要有其他事务锁定了本行，立即返回NULL
//            //如果没有锁定，则本事务锁定，查询得到结果则UPDATE，没有则INSERT
//            conn.setAutoCommit(false);
//            
//            String tSQL=" select createmaxno('"+cNoType+"','"+cNoLimit+"') from dual "; //modify by tianwk
//            ExeSQL exeSQL = new ExeSQL(conn);
//            String result = null;
//            result = exeSQL.getOneValue(tSQL);
//            tMaxNo = Integer.parseInt(result) ;
//            conn.commit();
//            conn.close();
//
//        }
//        catch (Exception Ex) {
//            try {
//                conn.rollback();
//                conn.close();
//
//                return null;
//            }
//            catch (Exception e1) {
//                e1.printStackTrace();
//
//                return null;
//            }
//        }

        /*
               if (tReturn.length() >= 12)
               {
            tReturn = tReturn.substring(0, 10) + "0" +
                tReturn.substring(10, 12);
               }
         */
        String tStr = String.valueOf(tMaxNo);
        tStr = PubFun.LCh(tStr, "0", serialLen);
        //System.out.println("tStr:"+tStr+"   serialLen:"+serialLen);
        //System.out.println("---------tStr:"+tStr);
        if (cNoType.equals("CONTNO") && tReturn.equals("0"))
        {
            tReturn = "88";
        }
        else if (cNoType.equals("GRPCONTNO") && tReturn.equals("0"))
        {
            tReturn = "89";
        }
        if (tReturn.equals("SN")) {
            tReturn = tStr.trim() + "0";
        }
        else {
            tReturn = tReturn.trim() + tStr.trim();
        }
        //System.out.println("------tReturn:"+tReturn);
        return tReturn;
    }

    /**
     * 功能：产生指定长度的流水号，一个号码类型一个流水
     * @param cNoType String 流水号的类型
     * @param cNoLength int 流水号的长度
     * @return String 返回产生的流水号码
     */
    public String CreateMaxNo(String cNoType, int cNoLength) {
        if ( (cNoType == null) || (cNoType.trim().length() <= 0) ||
            (cNoLength <= 0)) {
            System.out.println("NoType长度错误或NoLength错误");

            return null;
        }

        cNoType = cNoType.toUpperCase();

        //System.out.println("type:"+cNoType+"   length:"+cNoLength);
//        Connection conn = DBConnPool.getConnection();
//
//        if (conn == null) {
//            System.out.println("CreateMaxNo : fail to get db connection");
//
//            return null;
//        }

        String tReturn = "";
        String cNoLimit = "SN";
        //对上面那种cNoLimit为SN的数据做一个校验，否则会导致数据干扰
        if (cNoType.equals("COMMISIONSN") ||
            cNoType.equals("GRPNO") || cNoType.equals("CUSTOMERNO") ||
            cNoType.equals("SUGDATAITEMCODE") ||
            cNoType.equals("SUGITEMCODE") ||
            cNoType.equals("SUGMODELCODE") ||
            cNoType.equals("SUGCODE")) {

            System.out.println("该类型流水号，请采用CreateMaxNo('" + cNoType +
                               "','SN')"+bundle.getString("waitForTran")+"");
            return null;
        }
        BigInteger tMaxNo = new BigInteger("0");
        tReturn = cNoLimit;

        //20150110 tianzf CMS_HK使用sqlserver数据库，不能直接使用createmaxno函数对数据库进行Insert/Update操作，改为使用java function操作
        tMaxNo=new BigInteger(String.valueOf(newCreateMaxNo(cNoType,cNoLimit)));
//        try {
//            //开始事务
//            conn.setAutoCommit(false);
//            
//            String tSQL=" select createmaxno('"+cNoType+"','"+cNoLimit+"') from dual "; // modify by tianwk
//            ExeSQL exeSQL = new ExeSQL(conn);
//            String result = null;
//            result = exeSQL.getOneValue(tSQL);
//            tMaxNo = new BigInteger(result);
//            conn.commit();
//            conn.close();
//        }
//        catch (Exception Ex) {
//            try {
//                conn.rollback();
//                conn.close();
//
//                return null;
//            }
//            catch (Exception e1) {
//                e1.printStackTrace();
//
//                return null;
//            }
//        }

        String tStr = tMaxNo.toString();
        tStr = PubFun.LCh(tStr, "0", cNoLength);
        tReturn = tStr.trim();

        return tReturn;
    }
    
    private int newCreateMaxNo(String cNoType,String cNoLimit){
    	MMap mMap = new MMap();
    	int tMaxNo=0;
    	
    	LDMaxNoSchema tLDMaxNoSchema=new LDMaxNoSchema();
    	LDMaxNoSet tLDMaxNoSet=new LDMaxNoSet();
    	LDMaxNoDB tLDMaxNoDB=new LDMaxNoDB();
    	
    	tLDMaxNoDB.setNoType(cNoType);
    	tLDMaxNoDB.setNoLimit(cNoLimit);
    	tLDMaxNoSet=tLDMaxNoDB.query();
    	
    	if(tLDMaxNoSet.size()>0){
    		tLDMaxNoSchema=tLDMaxNoSet.get(1);
    		tLDMaxNoSchema.setMaxNo(tLDMaxNoSchema.getMaxNo()+1);
        	mMap.put(tLDMaxNoSchema, "UPDATE");
    	}else{
    		tLDMaxNoSchema.setNoType(cNoType);
    		tLDMaxNoSchema.setNoLimit(cNoLimit);
    		tLDMaxNoSchema.setMaxNo(1);
        	mMap.put(tLDMaxNoSchema, "INSERT");
    	}
		tMaxNo=(int) tLDMaxNoSchema.getMaxNo();
    	
    	//开始提交
        VData tVData = new VData();
        tVData.add(mMap);
        PubSubmit tPubSubmit = new PubSubmit();
        if (!tPubSubmit.submitData(tVData, "")) {
        	CError.buildErr(this, "newCreateMaxNo");
        	tMaxNo=-1;
        }
        return tMaxNo;
    }

//    public static void main(String[] args) {
//    	SysMaxNoNCL t=new SysMaxNoNCL();
//    	int testSN=t.newCreateMaxNo("TestSN", "SN");
//    	System.out.println(testSN);
//    	
//    }
}
