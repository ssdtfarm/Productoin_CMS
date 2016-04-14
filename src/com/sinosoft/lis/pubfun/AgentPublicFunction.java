package com.sinosoft.lis.pubfun;

import com.sinosoft.Resource.bundle;

/**
 * <p>Title:销售管理系统</p>
 * <p>Description:销售管理的公共业务处理函数     
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author
 * @version 1.0
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.FDate;

public class AgentPublicFunction
{

    public AgentPublicFunction()
    {
    }

    /**
     * 获得当前级别的下一级别(长城) author: xijh
     *
     * @param cAgentGrade String
     * @return String
     */
    static public String getNextGrade(String cAgentGrade)
    {
        if (cAgentGrade.substring(0, 1).equals("A"))
        {
            return "00";
        }
        if (cAgentGrade.substring(0, 1).equals("B"))
        {
            int a = Integer.parseInt(cAgentGrade.substring(1));
            a = a - 1;
            if (a == 0)
            {
                return "A02";
            }
            else
            {
                return "B0" + a;
            }
        }
        if (cAgentGrade.substring(0, 1).equals("C"))
        {
            int a = Integer.parseInt(cAgentGrade.substring(1));
            a = a - 1;
            if (a == 0)
            {
                return "A02";
            }
            else
            {
                return "C0" + a;
            }
        }
        return "00";
    }

    /**
     * 获得个险考核考核区间的止期(长城) author: xijh
     * @param tStartDate String
     * @param tAgentGrade String
     * @return String
     * @throws NumberFormatException
     */
    static public String getEndDate(String tStartDate, String tAgentGrade) throws
            NumberFormatException
    {
        String tEndDate = "";
        String StartMonth = AgentPublicFunction.formatDate(tStartDate,
                "MM");
        String StartYear = AgentPublicFunction.formatDate(tStartDate,
                "yyyy");
        //月考核
        if (tAgentGrade.equals("A01"))
        {
            tEndDate =AgentPublicFunction.parseTime(tStartDate,2,1)[1];
        }
        //季考核.
        if (tAgentGrade.equals("A02") || tAgentGrade.equals("B01"))
        {
            if (StartMonth.equals("01") || StartMonth.equals("02"))
            {
                tEndDate = StartYear + "-03-31";
            }
            else if (StartMonth.equals("03") || StartMonth.equals("04") ||
                     StartMonth.equals("05"))
            {
                tEndDate = StartYear + "-06-30";
            }
            else if (StartMonth.equals("06") || StartMonth.equals("07") ||
                     StartMonth.equals("08"))
            {
                tEndDate = StartYear + "-09-30";
            }
            else if (StartMonth.equals("09") || StartMonth.equals("10") ||
                     StartMonth.equals("11"))
            {
                tEndDate = StartYear + "-12-31";
            }
            else
            {
                tEndDate = String.valueOf(Integer.parseInt(StartYear) +
                                          1) +
                           "-03-31";
            }
        }
        //半年考核
        if (tAgentGrade.equals("B02") || tAgentGrade.equals("B03") ||
            tAgentGrade.equals("B04") || tAgentGrade.equals("C01"))
//            || tAgentGrade.equals("C02") || tAgentGrade.equals("C03"))
        {
            if (StartMonth.equals("01") || StartMonth.equals("02") ||
                StartMonth.equals("03"))
            {
                tEndDate = StartYear + "-06-30";
            }
            else if (StartMonth.equals("04") || StartMonth.equals("05") ||
                     StartMonth.equals("06") || StartMonth.equals("07") ||
                     StartMonth.equals("08") || StartMonth.equals("09"))
            {
                tEndDate = StartYear + "-12-31";
            }
            else
            {
                tEndDate = String.valueOf(Integer.parseInt(StartYear) +
                                          1) +
                           "-06-30";
            }
        }
        //年考核
//        if (tAgentGrade.equals("B05"))
//        {
//            if (StartMonth.equals("01") || StartMonth.equals("02") ||
//                StartMonth.equals("03") || StartMonth.equals("04") ||
//                StartMonth.equals("05") || StartMonth.equals("06") ||
//                StartMonth.equals("07"))
//            {
//                tEndDate = StartYear + "-12-31";
//            }
//            else
//            {
//                tEndDate = String.valueOf(Integer.parseInt(StartYear) +
//                                          1) +
//                           "-12-31";
//            }
//        }
        return tEndDate;
    }
    /**
     * 15为的身份证转换为18位 author: xijh
     * @param id String
     * @return String
     */
    public static final String getNewId(String id)
    {
        if(id.length() != 15)
            return null;
        try
        {
            double a = Double.parseDouble(id);
        }
        catch(Exception ex)
        {
            return null;
        }
        final int[] W =
                {
                7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
        //加权因子
        final String[] A =
                {
                "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        //校验码
        int i, j, s = 0;
        String newid;
        newid = id;
        newid = newid.substring(0, 6) + "19" + newid.substring(6, id.length());
        for (i = 0; i < newid.length(); i++)
        {
            j = Integer.parseInt(newid.substring(i, i + 1)) * W[i];
            s = s + j;
        }
        s = s % 11;
        newid = newid + A[s];
        return newid;
    }


    /**
     * 转换业务系统的销售渠道为销售系统的展业类型的函数 author: liujw
     * @param cSalChnl 业务系统的销售渠道
     * @return String 销售系统的展业类型(BranchType)
     */
    public static String switchSalChnltoBranchType(String cSalChnl)
    {
        String tBranchType = "";

        cSalChnl = cSalChnl.trim();
        if (cSalChnl.equals("01"))
        { //团险
            tBranchType = "2";
        }
        else if (cSalChnl.equals("02"))
        { //个险
            tBranchType = "1";
        }
        else if (cSalChnl.equals("03") || cSalChnl.equals("04")
                 || cSalChnl.equals("05") || cSalChnl.equals("06"))
        //银行保险 兼业代理 专业代理 经纪公司
        {
            tBranchType = "3";
        }

        return tBranchType;
    }

//    //xjh Add 2005/04/01
//    public static String[] switchSalChnl(String cSalChnl)
//    {
//        String[] result = new String[2];
//        LDCodeRelaSet tLDCodeRelaSet = new LDCodeRelaSet();
//        LDCodeRelaDB tLDCodeRelaDB = new LDCodeRelaDB();
//        tLDCodeRelaDB.setRelaType("salechnlvsbranchtype");
//        tLDCodeRelaDB.setCode3(cSalChnl);
//        tLDCodeRelaSet = tLDCodeRelaDB.query();
//        if (tLDCodeRelaSet.size() == 0)
//            return null;
//        else
//        {
//            result[0] = tLDCodeRelaSet.get(1).getCode1();
//            result[1] = tLDCodeRelaSet.get(1).getCode2();
//        }
//        return result;
//    }

    /**
     * parseTime
     *
     * @param endTime String
     * @param reportType String
     * @param reportCycle String
     * @return String[]
     */
    public static String[] parseTime(String endTime, int reportType,
                                     int reportCycle)
    {
        //当前时间形式,yyyy-MM-dd
//      String sourcePattern=getSessionPool().getConfig().getDefaultDateFormat();

//    int reportCycle=1;
        String sourcePattern = "yyyy-MM-dd";
        String targetPattern = "yyyy-MM-dd";

        SimpleDateFormat sdf = new SimpleDateFormat(sourcePattern); //用户定义形式
        SimpleDateFormat targetDF = new SimpleDateFormat(targetPattern); //数据库要求形式

        String reportStartTime = endTime;
        String reportEndTime = endTime;

        String settedEnd = endTime;

        Date endDate;
//        Date startDate;
        try
        {
            endDate = sdf.parse(settedEnd);

            //报表类型
            int type = reportType;
            //报表周期
            int cycle = reportCycle;

            Calendar cal = Calendar.getInstance();
            cal.setTime(endDate);
            switch (type)
            {
                case 1: //日报
                    reportEndTime = targetDF.format(endDate);
                    cal.add(Calendar.DATE, ( -1) * cycle + 1); //开始时间=结束时间-周期+1
                    reportStartTime = targetDF.format(cal.getTime());
                    break;
                case 2: //月报
                    cal.set(Calendar.DAY_OF_MONTH, 1); //月初
                    cal.add(Calendar.MONTH, ( -1) * cycle + 1); //到周期的月初
                    reportStartTime = targetDF.format(cal.getTime()); //开始时间
                    cal.add(Calendar.MONTH, cycle); //周期末的下月初
                    cal.add(Calendar.DAY_OF_MONTH, -1); //周期末
                    reportEndTime = targetDF.format(cal.getTime());
                    break;
                case 3: //季报

                    // int month=cal.get(Calendar.MONTH)+1;  //月度,需要+1
                    int month = cal.get(Calendar.MONTH);
                    int quarter = month / 3; //所在季度,0-spring;1-summer
                    cal.set(Calendar.MONTH,
                            quarter * 3 + (( -1) * cycle + 1) * 3); //季初-周期持续时间
                    cal.set(Calendar.DATE, 1); //设到1号
                    reportStartTime = targetDF.format(cal.getTime());

                    ////////////////////end time
                    cal.add(Calendar.MONTH, cycle * 3); //多了一天
                    cal.add(Calendar.DATE, -1);
                    reportEndTime = targetDF.format(cal.getTime());
                    break;
                case 4: //年报
                    cal.add(Calendar.YEAR, ( -1) * cycle + 1);
                    cal.set(Calendar.MONTH, Calendar.JANUARY);
                    cal.set(Calendar.DATE, 1); //设到年初
                    reportStartTime = targetDF.format(cal.getTime());

                    /////////
                    cal.add(Calendar.YEAR, cycle); //下一年元旦,多了一天
                    cal.add(Calendar.DATE, -1); //年末
                    reportEndTime = targetDF.format(cal.getTime());
                    break;
                default:
                    break;
            }
        }
        catch (ParseException ex)
        {

        }

        String[] result = new String[2];
        result[0] = reportStartTime;
        result[1] = reportEndTime;
        return result;
    }

    /**
     * 将日期格式化成“YYYY年MM月DD天”的格式，输入格式为“YYYY/MM/DD”，“YYYY-MM-DD”
     *
     * @param cDate String
     * @return String
     */
    public static String formatDatex(String cDate)
    {
        if (cDate.indexOf("/") != -1)
        {
            cDate = cDate.substring(0, cDate.indexOf("/")) + ""+bundle.getString("waitForTran")+""
                    +
                    cDate.substring(cDate.indexOf("/") + 1,
                                    cDate.lastIndexOf("/")) +
                    ""+bundle.getString("waitForTran")+""
                    + cDate.substring(cDate.lastIndexOf("/") + 1) + ""+bundle.getString("waitForTran")+"";
        }
        else if (cDate.indexOf("-") != -1)
        {
            cDate = cDate.substring(0, cDate.indexOf("-")) + ""+bundle.getString("waitForTran")+""
                    +
                    cDate.substring(cDate.indexOf("-") + 1,
                                    cDate.lastIndexOf("-")) +
                    ""+bundle.getString("waitForTran")+""
                    + cDate.substring(cDate.lastIndexOf("-") + 1) + ""+bundle.getString("waitForTran")+"";
        }
        return cDate;
    }

//    /**
//     * 转换业务系统的销售渠道为销售系统的展业类型的函数 author: liujw
//     *
//     * @param cBranchType 销售系统的展业类型(BranchType)
//     * @return String 业务系统的销售渠道
//     */
//    public static String switchBranchTypetoSalChnl(String cBranchType)
//    {
//        String tSalChnl = "";
////        cBranchType = cBranchType.trim();
////        if (cBranchType.equals("2"))
////        { //团险
////            tSalChnl = "01";
////        }
////        else if (cBranchType.equals("1"))
////        { //个险
////            tSalChnl = "02";
////        }
////        else if (cBranchType.equals("3"))
////        //银行保险 兼业代理 专业代理 经纪公司
////        {
////            tSalChnl = "03";
////        }
//        LDCodeRelaDB tLDCodeRelaDB = new LDCodeRelaDB();
//        LDCodeRelaSet tLDCodeRelaSet = new LDCodeRelaSet();
//        tLDCodeRelaDB.setRelaType("salechnlvsbranchtype");
//        tLDCodeRelaDB.setCode1(cBranchType);
//        tLDCodeRelaSet = tLDCodeRelaDB.query();
//        for (int i = 1; i <= tLDCodeRelaSet.size(); i++)
//        {
//            tSalChnl += tLDCodeRelaSet.get(i).getCode3();
//            if(i != tLDCodeRelaSet.size())
//            {
//                tSalChnl+= ",";
//            }
//        }
//        return tSalChnl;
//    }

    //xjh Add 2005/04/13
    //展业类型到销售渠道的转化
    public static String[] switchBranchTypetoSalChnl(String cBranchType,
            String cBranchType2)
    {
        String[] result = new String[2];
        //BranchType 1 个险,2 团险,3 银代
        //SaleChnl 01 团险销售,02 个人销售,03 银行代理
        if (cBranchType == null || cBranchType.equals(""))
        {
            result[0] = "01,02,03";
        }
        else if (cBranchType.equals("2"))
        {
            result[0] = "01";
        }
        else if (cBranchType.equals("1"))
        {
            result[0] = "02";
        }
        else if (cBranchType.equals("3"))
        {
            result[0] = "03";
        }
        //BranchType2 01 直销,02 中介,03 交叉,04 银代
        //SaleChnlDetail 01 直销团队,02 经纪公司,03 代理公司,04 兼业代理公司,05 交叉销售，06 银行代理
        if (cBranchType2 == null || cBranchType2.equals(""))
        {
            result[1] = "01,02,03,04,05,06";
        }
        else if (cBranchType2.equals("01"))
        {
            result[1] = "01";
        }
        else if (cBranchType2.equals("02"))
        {
            result[1] = "02,03,04";
        }
        else if (cBranchType2.equals("03"))
        {
            result[1] = "05";
        }
        else if (cBranchType2.equals("04"))
        {
            result[1] = "06";
        }
        return result;
    }

    //xjh Add 2005/04/14
    //销售渠道到展业类型的转化
    public static String[] switchSalChnl(String cSaleChnl,
                                         String cSaleChnlDetail)
    {
        String[] result = new String[2];
        //BranchType 1 个险,2 团险,3 银代
        //SaleChnl 01 团险销售,02 个人销售,03 银行代理
        if (cSaleChnl == null || cSaleChnl.equals(""))
        {
            result[0] = "";
        }
        else if (cSaleChnl.equals("01"))
        {
            result[0] = "2";
        }
        else if (cSaleChnl.equals("02"))
        {
            result[0] = "1";
        }
        else if (cSaleChnl.equals("03"))
        {
            result[0] = "3";
        }
        //BranchType2 01 直销,02 中介,03 交叉,04 银代
        //SaleChnlDetail 01 直销团队,02 经纪公司,03 代理公司,04 兼业代理公司,05 交叉销售，06 银行代理
        if (cSaleChnlDetail == null || cSaleChnlDetail.equals(""))
        {
            result[1] = "";
        }
        else if (cSaleChnlDetail.equals("01"))
        {
            result[1] = "01";
        }
        else if (cSaleChnlDetail.equals("02"))
        {
            result[1] = "02";
        }
        else if (cSaleChnlDetail.equals("03"))
        {
            result[1] = "02";
        }
        else if (cSaleChnlDetail.equals("04"))
        {
            result[1] = "02";
        }
        else if (cSaleChnlDetail.equals("05"))
        {
            result[1] = "03";
        }
        else if (cSaleChnlDetail.equals("06"))
        {
            result[1] = "04";
        }
        return result;
    }

    /**
     * 得到机构2468位的函数 author: zy
     *
     * @param cManagecom 销售系统的管理机构
     * @param mManagecom 登陆管理机构
     * @return SSRS 机构数
     */
    public static SSRS getbranch(String cManagecom, String mManagecom)
    {
//     GlobalInput mGlobalInput =new GlobalInput() ;
        SSRS tSSRS = new SSRS();
        int n = cManagecom.trim().length();
        System.out.println("录入机构－－－" + cManagecom);
        System.out.println("录入机构长度－－－" + n);
        String MM = "";
        switch (n)
        {
            case 2:
            {
                MM = " and length(a)=4 ";
                break;
            }
            case 4:
            {
                MM = " and length(a)=6 ";
                break;
            }
            case 6:
            {
                MM = " and length(a)=8 ";
                break;
            }
            case 8:
            {
                MM = " and length(a)=12 ";
                break;
            }
            case 12:
            {
                MM = " and length(a)=15 ";
                break;
            }
            case 15:
            {
                MM = " and length(a)=18 ";
                break;
            }
        }
        String nsql =
                "select a,b from (select trim(comcode) a,shortname b from ldcom union"
                +
                " select trim(branchattr) a,name b From labranchgroup where branchtype='1'"
                +
                " and (state<>1 or state is null) and length(trim(branchattr))<>8)"
                + " where a like '" + cManagecom + "%' and a like '" +
                mManagecom +
                "%' "
                + MM + "order by a";
//      SSRS ySSRS = new SSRS();
        ExeSQL aExeSQL = new ExeSQL();
        tSSRS = aExeSQL.execSQL(nsql);
        return tSSRS;
    }


    /**
     * 根据代理人职级查询代理人系列（只适用个险）
     * @param cAgentGrade 个险的代理人职级
     * @return String 职级对应的代理人系列
     */
    public static String getAgentSeries(String cAgentGrade)
    {
        if (cAgentGrade == null || cAgentGrade.equals(""))
        {
            return null;
        }
        String tAgentSeries = "";
        //xjh Modify 2005/3/22
//        String tSQL =
//                "select Trim(code2) from ldcodeRela where relaType = 'gradeserieslevel' "
//                + "and code1 = '" + cAgentGrade + "' ";
        String tSQL =
                "Select GradeProperty2 from LAAgentGrade where GradeCode = '" +
                cAgentGrade + "'";
        ExeSQL tExeSQL = new ExeSQL();
        tAgentSeries = tExeSQL.getOneValue(tSQL);
        if (tExeSQL.mErrors.needDealError())
        {
            return null;
        }
        return tAgentSeries;
    }


    /**
     * 根据代理人编码查询代理人入司职级
     * @param cAgentCode 代理人编码
     * @return String 代理人入司日期
     */
    public static String getAgentGrade(String cAgentCode)
    {
        if (cAgentCode == null || cAgentCode.equals(""))
        {
            return null;
        }
        String tAgentGrade = "";
        String tSQL = "select agentgrade from latreeb where agentcode='" +
                      cAgentCode + "' order by makedate,maketime";
        ExeSQL tExeSQL = new ExeSQL();
        tAgentGrade = tExeSQL.getOneValue(tSQL);
        if (tAgentGrade == null || tAgentGrade.equals(""))
        {
            String aSQL = "select agentgrade from latree where agentcode='" +
                          cAgentCode + "' ";
            ExeSQL aExeSQL = new ExeSQL();
            tAgentGrade = aExeSQL.getOneValue(aSQL);
        }
        return tAgentGrade;
    }

    public static String AdjustCommCheck(String tAgentCode, String tStartDate)
    {
        if (!tStartDate.endsWith("01")) //如果开始时间不是从1号开始，则返回错误
        {
            return ""+bundle.getString("waitForTran")+"";
        }
        String sql = "select max(indexcalno) from lawage where AgentCode='" +
                     tAgentCode + "'";
        ExeSQL tExeSQL = new ExeSQL();
        String maxIndexCalNo = tExeSQL.getOneValue(sql);
        if (maxIndexCalNo != null && !maxIndexCalNo.equals(""))
        {
            String lastDate = PubFun.calDate(tStartDate, -1, "M", null);
            lastDate = AgentPublicFunction.formatDate(lastDate, "yyyyMM");
            if (maxIndexCalNo.trim().compareTo(lastDate.trim()) > 0)
            {
                return (""+bundle.getString("waitForTran")+"" +
                        maxIndexCalNo.substring(4).trim() +
                        ""+bundle.getString("waitForTran")+"");
            }
        }
        return "00";

    }


    /**
     * 查询代理人所在组的外部编码
     *
     * @param cAgentCode 代理人代码
     * @return String 代理人所在组的外部编码
     */
    public static String getAgentBranchAttr(String cAgentCode)
    {
        String tBranchAttr = "";
        if (cAgentCode == null || cAgentCode.equals(""))
        {
            return null;
        }
        String tSQL =
                "Select Trim(BranchAttr) From LABranchGroup Where AgentGroup = ("
                + "Select BranchCode From LAAgent Where AgentCode = '" +
                cAgentCode +
                "') ";
        ExeSQL tExeSQL = new ExeSQL();
        tBranchAttr = tExeSQL.getOneValue(tSQL);
        if (tExeSQL.mErrors.needDealError())
        {
            return null;
        }
        return tBranchAttr;
    }


    /**
     * 按cFormat的格式 格式化日期类型 年月日的表示字母为 y M d
     *
     * @param cDate String
     * @param cFormat String
     * @return String
     */
    public static String formatDate(String cDate, String cFormat)
    {
        String FormatDate = "";
        Date tDate;
        SimpleDateFormat sfd = new SimpleDateFormat(cFormat);
        FDate fDate = new FDate();
        tDate = fDate.getDate(cDate.trim());
        FormatDate = sfd.format(tDate);
//       System.out.println("[--formatedate--]:"+FormatDate);
        return FormatDate;
    }


    /**
     * 从LDCodeRela表中查出ManageCom对应的地区类型
     *
     * @param cManageCom String
     * @return String
     */
    public static String getAreaType(String cManageCom)
    {
        //AreaType//长城特值
        String tSql = "Select trim(code2) From LDCodeRela Where RelaType = 'comtoareatype' and trim(code1) = '" +
                      cManageCom + "' and othersign='1'";
        ExeSQL tExeSQL = new ExeSQL();
        String tAreaType = tExeSQL.getOneValue(tSql);
        if (tExeSQL.mErrors.needDealError())
        {
            return null;
        }
        if (tAreaType == null || tAreaType.equals(""))
        {
            return null;
        }
        return tAreaType;
    }

    public static String getWageAreaType(String cManageCom)
    {
        //AreaType
        String tSql = "Select trim(code2) From LDCodeRela Where RelaType = 'wageareatype' and trim(code1) = '" +
                      cManageCom + "'";
        ExeSQL tExeSQL = new ExeSQL();
        String tAreaType = tExeSQL.getOneValue(tSql);
        if (tExeSQL.mErrors.needDealError())
        {
            return null;
        }
        if (tAreaType == null || tAreaType.equals(""))
        {
            return null;
        }
        return tAreaType;
    }


    /**
     * 转换规则：上月26号---本月25号算作本月
     *
     * @Return :格式为YYYYMM
     * @param cDate String
     * @return String
     */
    public static String ConverttoYM(String cDate)
    {
        String sYearMonth = "";
        ExeSQL tExeSQL = new ExeSQL();
        String tSql =
                "Select YearMonth From LAStatSegment Where StatType = '5' "
                + "And StartDate <= '" + cDate + "' And EndDate >= '" + cDate +
                "'";
        sYearMonth = tExeSQL.getOneValue(tSql);
        if (tExeSQL.mErrors.needDealError())
        {
            return null;
        }
        if (sYearMonth == null || sYearMonth.equals(""))
        {
            return null;
        }
        return sYearMonth;
    }

    /**
     * getManagecom 从LABranchGroup 表中由AgentGroup取得其管理机构
     *
     * @param cAgentGroup String
     * @return String
     */
    public static String getManagecom(String cAgentGroup)
    {
        if (cAgentGroup == null || cAgentGroup.equals(""))
        {
            return null;
        }
        String tSQL =
                "Select Trim(Managecom) From LABranchGroup Where AgentGroup = '" +
                cAgentGroup + "'";
        ExeSQL tExeSQL = new ExeSQL();
        String tManagecom = tExeSQL.getOneValue(tSQL);
        if (tExeSQL.mErrors.needDealError())
        {
            return null;
        }
        return tManagecom;
    }


    /**
     * 转换规则：上月26号---本月25号算作本月
     *
     * @Return :格式为YYYYMMDD
     * @param cDate String
     * @return String
     */
    public static String ConverttoYMD(String cDate)
    {
        String sYearMonth = "";
        sYearMonth = ConverttoYM(cDate);
        if (sYearMonth != null && !sYearMonth.equals(""))
        {
            sYearMonth = sYearMonth.substring(0, 4) + "-" +
                         sYearMonth.substring(4) +
                         "-01";
        }
        return sYearMonth;
    }


    /**
     * 查询机构系列号
     * @param cAgentGroup 机构内部编码
     * @return String 机构系列号
     */
    public static String getBranchSeries(String cAgentGroup)
    {
        String tBranchSeries = cAgentGroup;
        if (cAgentGroup == null || cAgentGroup.equals(""))
        {
            return "";
        }
        String tSQL =
                "Select Trim(UpBranch) From LABranchGroup Where AgentGroup = '" +
                cAgentGroup + "'";
        ExeSQL tExeSQL = new ExeSQL();
        String tUpBranch = tExeSQL.getOneValue(tSQL);
        if (tExeSQL.mErrors.needDealError())
        {
            return "";
        }
        if (tUpBranch == null || tUpBranch.compareTo("") == 0)
        {
            System.out.println("到达出口");
        }
        else
        {
            //如果发现该机构存在上级机构，则查询上级机构信息
            //xjh Modify ， 2005/02/17，机构间使用“：”分隔符
//            tBranchSeries = getBranchSeries(tUpBranch) + tBranchSeries;
            tBranchSeries = getBranchSeries(tUpBranch) + ":" + tBranchSeries;

//          System.out.println("机构序列" + tBranchSeries);
        }
        return tBranchSeries;
    }

    //获得业务员职级
    public static String getCurrGrade(String cAgentCode)
    {
        String tSQL =
                "Select agentgrade from latree where agentcode  = '" +
                cAgentCode + "'";
        ExeSQL tExeSQL = new ExeSQL();
        return tExeSQL.getOneValue(tSQL);
    }
//    public static void main(String args[])
//    {
//        String Agentcode = "000000000473";
//        System.out.println(getBranchSeries(Agentcode));
//    }
}
