/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import java.math.BigInteger;

//import com.sinosoft.lis.db.LABranchGroupDB;
import com.sinosoft.lis.db.LMCalModeDB;
//import com.sinosoft.lis.schema.LABranchGroupSchema;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.utility.VData;

/**
 * <p>Title: Web业务系统</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author YT
 * @version 1.0
 */
public class PubFun1 {
    public PubFun1() {
    }

    /**
     *<p>生成流水号的函数<p>
     *<p>号码规则：机构编码  日期年  校验位   类型    流水号<p>
     *<p>          1-6     7-10   11     12-13   14-20<p>
     * @param cNoType 为需要生成号码的类型
     * @param cNoLimit 为需要生成号码的限制条件
     * @return 生成的符合条件的流水号，如果生成失败，返回空字符串""
     */
    public static String CreateMaxNo(String cNoType, String cNoLimit) {
        try {
            //动态载入类
            System.out.println("sysmaxnotype:" +
                               com.sinosoft.utility.SysConst.MAXNOTYPE);
            String className = "com.sinosoft.lis.pubfun.SysMaxNo" +
                com.sinosoft.utility.SysConst.MAXNOTYPE;
            Class cc = Class.forName(className);
            com.sinosoft.lis.pubfun.SysMaxNo tSysMaxNo = (com.sinosoft.lis.
                pubfun.
                SysMaxNo) (cc.newInstance());
            return tSysMaxNo.CreateMaxNo(cNoType, cNoLimit);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     *<p>MOD-10保单号校验规则的函数<p>
     *<p>校验规则：Number:			0 0 0 0 0 0 1 2 3 4 7 <p>
     *<p>(x2 alternate digits):		0   0   0   2   6  14 <p>
     *<p>(Add when double digits)	0   0       2   6   5 <p>
     *<p>Add all digits			    0 0 0 0 0 0 2 2 6 4 5 <p>
     *<p>Sum of all digits 	= 2+2+6+4+5 = 19              <p>
     *<p>Last digit 		= 9                           <p>
     *<p>Check digit = 9-9 = 0                            <p>
     *<p>Number is 000000123470                           <p>
     * @author quyang 2005.06.29
     * @version 1.0
     * @param cNoType 为需要生成号码的类型
     * @param cNoLimit 为需要生成号码的限制条件
     * @return 生成的符合条件的流水号，如果生成失败，返回空字符串""
     */
    public static String creatVerifyDigit(String originalDigit) {
        try {
            String finalDigit = null;
            String[] alterDigOdd = null;
            String[] alterDigEven = null;
            System.out.println("originalDigit" + originalDigit +
                               "originalDigit.length()" + originalDigit.length());
            if (!"".equalsIgnoreCase(originalDigit)) {
                alterDigOdd = new String[originalDigit.length()];
                alterDigEven = new String[originalDigit.length()];
                for (int i = 0; i < originalDigit.length(); i++) {
                    if (i == 0) {
                        alterDigOdd[i] = originalDigit.substring(i, i + 1);
//                        System.out.println("alterDigOdd[" + i + "]" +
//                                           alterDigOdd[i].toString());
                    }
                    if (i == 1) {
                        alterDigEven[i] = originalDigit.substring(i, i + 1);
//                        System.out.println("alterDigEven[" + i + "]" +
//                                           alterDigEven[i].toString());
                    }
                    if (i > 1 && i % 2 == 1) {
                        alterDigEven[i] = originalDigit.substring(i, i + 1);
//                        System.out.println("alterDigEven[" + i + "]" +
//                                           alterDigEven[i].toString());
                    }
                    if (i > 1 && i % 2 == 0) {
                        alterDigOdd[i] = originalDigit.substring(i, i + 1);
//                        System.out.println("alterDigOdd[" + i + "]" +
//                                           alterDigOdd[i].toString());
                    }
                }
            }
//            for (int i = alterDigOdd.length - 1; i >= 0; i--) {
//                System.out.println("alterDigOdd数组的元素[" + i + "]" +
//                                   alterDigOdd[i]);
//            }
//            for (int i = alterDigEven.length - 1; i >= 0; i--) {
//                System.out.println("alterDigEven数组的元素[" + i + "]" +
//                                   alterDigEven[i]);
//            }
//            System.out.println("alterDigOdd" + alterDigOdd.toString() +
//                               "alterDigOdd.length()" + alterDigOdd.length);
//            System.out.println("alterDigEven" + alterDigEven.toString() +
//                               "alterDigEven.length()" + alterDigEven.length);
            //x2 alternate digits
            if (!"".equals(alterDigOdd)) {

                for (int i = 0; i < alterDigOdd.length; i++) {
                    if ( (String) alterDigOdd[i] != null &&
                        (String) alterDigOdd[i] != "null" &&
                        (String) alterDigOdd[i] != "0") {
//                        System.out.println("(String)alterDigOdd[i]" +
//                                           (String) alterDigOdd[i]);
                        String tempString = null;
//                        System.out.println("alterDigOdd before double[" + i +
//                                           "]:" + alterDigOdd[i]);
                        tempString = String.valueOf(2 *
                            Integer.parseInt(alterDigOdd[i].toString()));
//                        System.out.println("alterDigOdd after double[" + i +
//                                           "]:" + alterDigOdd[i]);
                        alterDigOdd[i] = "";
                        alterDigOdd[i] = tempString;
                        //Add when double digits
                        if ( (!"".equals(alterDigOdd[i])) &&
                            alterDigOdd[i].toString().length() > 1) {
                            int tempInt = 0;
                            for (int j = 0; j < alterDigOdd[i].length(); j++) {
                                String temp = (String) alterDigOdd[i];
                                tempInt +=
                                    Integer.parseInt(String.valueOf(temp.
                                    charAt(j)));
                            }
                            alterDigOdd[i] = "";
                            alterDigOdd[i] = String.valueOf(tempInt);
                        }
//                        System.out.println("alterDigOdd after Add double" +
//                                           alterDigOdd[i].toString());
                    }
                }
//                for (int i = alterDigOdd.length - 1; i >= 0; i--) {
//                    System.out.println("alterDigOdd数组的元素 after Add double [" +
//                                       i + "]" + alterDigOdd[i]);
//                }
                //Add all digits
                //Sum of all digits
                int allDig = 0;
                for (int i = 0; i < alterDigOdd.length; i++) {
                    if (i == 0) {
                        allDig += Integer.parseInt(alterDigOdd[i]);
//                        System.out.println("alterDigOdd[" + i + "]" +
//                                           alterDigOdd[i].toString());
                    }
                    if (i == 1) {
                        allDig += Integer.parseInt(alterDigEven[i]);
//                        System.out.println("alterDigEven[" + i + "]" +
//                                           alterDigEven[i].toString());
                    }
                    if (i > 1 && i % 2 == 1) {
                        allDig += Integer.parseInt(alterDigEven[i]);
//                        System.out.println("alterDigEven[" + i + "]" +
//                                           alterDigEven[i].toString());
                    }
                    if (i > 1 && i % 2 == 0) {
                        allDig += Integer.parseInt(alterDigOdd[i]);
//                        System.out.println("alterDigOdd[" + i + "]" +
//                                           alterDigOdd[i].toString());
                    }

                }
                System.out.println("allDig" + String.valueOf(allDig));
                //Last digit
                int lastDig = 0;
                String allDigString = String.valueOf(allDig);
                if (allDig != 0) {
                    lastDig = Integer.parseInt(allDigString.substring(
                        allDigString.length() - 1, allDigString.length()));
                }
                System.out.println("lastDig" + String.valueOf(lastDig));
                //Check digit
                int checkDig = 0;
                checkDig = 9 - lastDig;
                /** @todo 校验位如果为4则转换为8*/
                if (checkDig == 4) {
                    checkDig = 8;
                }
                finalDigit = originalDigit + String.valueOf(checkDig);
                System.out.println("finalDigit" + finalDigit);
            }
            return finalDigit;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 生成流水号的函数
     * 号码规则：机构编码  日期年  校验位   类型    流水号
     *           1-6     7-10   11     12-13   14-20
     * @param cNoType String 为需要生成号码的类型
     * @param cNoLimit String 为需要生成号码的限制条件
     * @param tVData VData
     * @return String 生成的符合条件的流水号，如果生成失败，返回空字符串""
     */
    public static String CreateMaxNo(String cNoType, String cNoLimit,
                                     VData tVData) {
        try {
            //动态载入类
            System.out.println("sysmaxnotype:" +
                               com.sinosoft.utility.SysConst.MAXNOTYPE);
            String className = "com.sinosoft.lis.pubfun.SysMaxNo" +
                com.sinosoft.utility.SysConst.MAXNOTYPE;
            Class cc = Class.forName(className);
            com.sinosoft.lis.pubfun.SysMaxNo tSysMaxNo = (com.sinosoft.lis.
                pubfun.
                SysMaxNo) (cc.newInstance());
            return tSysMaxNo.CreateMaxNo(cNoType, cNoLimit, tVData);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 功能：产生指定长度的流水号，一个号码类型一个流水
     * @param cNoType String 流水号的类型
     * @param cNoLength int 流水号的长度
     * @return String 返回产生的流水号码
     */
    public synchronized static String CreateMaxNo(String cNoType, int cNoLength) {
        try {
            //动态载入类
            String className = "com.sinosoft.lis.pubfun.SysMaxNo" +
                com.sinosoft.utility.SysConst.MAXNOTYPE;
            Class cc = Class.forName(className);
            com.sinosoft.lis.pubfun.SysMaxNo tSysMaxNo = (com.sinosoft.lis.
                pubfun.
                SysMaxNo) (cc.newInstance());
            return tSysMaxNo.CreateMaxNo(cNoType, cNoLength);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 得到calculator解析过的SQL语句。原来的calculator，只能返回aCalCode所代表的SQL语句
     * 的一个执行结果。这个方法得到的是aCalCode所代表的实际的SQL语句。
     * @param strSql String 需要解析的SQL语句
     * @param calculator Calculator 已经设置了基本计算元素的calculator对象
     * @return String 解析后的SQL语句。如果发生任何错误，将会抛出异常
     * @throws Exception
     */
//    public static String getSQL(String strSql, Calculator calculator) throws
//        Exception {
//        LMCalModeDB tLMCalModeDB = new LMCalModeDB();
//
//        // 对引号进行特殊的处理
//        String strSQL = strSql.replace('\'', '@');
//        //查询临时表，不是很好的选择
//        strSQL = "select ''" + strSQL + "'' from dual";
//
//        tLMCalModeDB.setCalCode("XXX");
//        tLMCalModeDB.setRiskCode("0");
//        tLMCalModeDB.setType("F");
//        tLMCalModeDB.setCalSQL(strSQL);
//
//        if (!tLMCalModeDB.update()) {
//            throw new Exception("设置计算公式时出错");
//        }
//
//        calculator.setCalCode("XXX");
//        strSQL = calculator.calculate();
//
//        if (strSQL.equals("")) {
//            throw new Exception("解析SQL语句时出错");
//        }
//
//        return strSQL.replace('@', '\'');
//    }

    /**
     * 通过传入的日期可以得到所在月的计算第一天和计算最后一天的日期 author: LH
     * <p><b>Example: </b><p>
     * <p>calFLDate("2003-5-8") returns 2003-4-26 2003-5-25<p>
     * @param tDate String 起始日期，(String,格式："YYYY-MM-DD")
     * @return String[] 本月开始和结束日期，返回String[2]
     */
    public static String[] calFLDate(String tDate) {
        String[] MonDate = new String[2];
        String asql =
            "select startdate,enddate from LAStatSegment where stattype='5' and startdate<='" +
            tDate + "' and enddate>='" + tDate + "'";
        ExeSQL aExeSQL = new ExeSQL();
        SSRS aSSRS = new SSRS();
        aSSRS = aExeSQL.execSQL(asql);
        MonDate[0] = aSSRS.GetText(1, 1);
        MonDate[1] = aSSRS.GetText(1, 2);

        return MonDate;
    }

    /**
     * 生成本机构下新成立的机构编码：BranchAttr
     * @param tUpAttr String 新建机构的上级机构的BranchAttr编码
     * @param tLength int 编码长度(10位-区域督导部、12－督导部、15－营销服务部、18－营业组）
     * @return String 新建机构的编码BranchAttr
     */
    public static String CreateBranchAttr(String tUpAttr, int tLength) {
//        LABranchGroupDB tDB = new LABranchGroupDB();
//        LABranchGroupSchema tSch = new LABranchGroupSchema();
        ExeSQL tExeSql = new ExeSQL();

        String aNewAttr = "";

        String tSQL =
            "select max(branchattr) from labranchgroup where trim(branchattr) like '" +
            tUpAttr.trim() + "%' and (trim(state) <> '1' or state is null)" +
            " and branchtype = '1' and length(trim(branchattr)) = " +
            tLength;

        aNewAttr = tExeSql.getOneValue(tSQL);
        System.out.println("---maximum = " + aNewAttr);

        BigInteger tInt = null;
        BigInteger tAdd = null;

        try {
            tInt = new BigInteger(aNewAttr.trim());
            tAdd = new BigInteger("1");
        }
        catch (Exception ex) {
            ex.printStackTrace();

            return "";
        }

        tInt = tInt.add(tAdd);

        aNewAttr = tInt.toString();
        System.out.println("---aNewAttr = " + aNewAttr);

        return aNewAttr;
    }

    /**
     * 调试函数
     * @param args String[]
     */
//    public static void main(String[] args) {
////    PubFun1 tPF1 = new PubFun1();
////    System.out.println(PubFun1.CreateMaxNo("TAKEBACKNO", 2));
//    }
}
