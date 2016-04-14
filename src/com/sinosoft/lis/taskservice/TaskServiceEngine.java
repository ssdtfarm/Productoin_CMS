/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.taskservice;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimerTask;
import java.util.Vector;

import com.sinosoft.lis.db.LDTaskDB;
import com.sinosoft.lis.db.LDTaskParamDB;
import com.sinosoft.lis.db.LDTaskPlanDB;
import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.lis.schema.LDTaskParamSchema;
import com.sinosoft.lis.schema.LDTaskPlanSchema;
import com.sinosoft.lis.vschema.LDTaskParamSet;
import com.sinosoft.lis.vschema.LDTaskPlanSet;
import com.sinosoft.lis.vschema.LDTaskRunLogSet;
import com.sinosoft.lis.vschema.LDTaskSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.VData;


/**
 * <p>Title: 任务启动引擎</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: SinoSoft</p>
 * @author ZhangRong
 * @version 1.0
 */
public class TaskServiceEngine extends TimerTask
{  
    private static Vector mTaskWaitList; //等待队列
    private static Vector mTaskRunList; //运行队列
    private static Vector mTaskReadyList; //就绪队列
    private static LDTaskPlanDB mLDTaskPlanDB;
    private static LDTaskPlanSet mLDTaskPlanSet;
    private static VData mData;
    private static MMap mMap;
    private static Object lock;
    private static boolean mDataChanged = false;
    private static SimpleDateFormat tSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static CErrors mErrors = new CErrors();
    private static String tIP;//服务器IP added by zhanggl 2007-11-09 

    public TaskServiceEngine()
    { 
        if (mTaskWaitList == null)
        {
            mTaskWaitList = new Vector();
        }

        if (mTaskRunList == null)
        {
            mTaskRunList = new Vector();
        }

        if (mTaskReadyList == null)
        {
            mTaskReadyList = new Vector();
        }

        mLDTaskPlanDB = new LDTaskPlanDB();
        mData = new VData();
        mMap = new MMap();
        lock = new Object();
    }

    private boolean scanTaskPlan()
    {
//        mLDTaskPlanSet = mLDTaskPlanDB.executeQuery(
//            "select * from LDTaskPlan where TaskPlanCode <> '000000'");
        
        String powerSql = "select * from LDTaskPlan where TaskPlanCode <> ? "; 
        List paraList =new ArrayList(); 
        paraList.add("000000");
        mLDTaskPlanSet = mLDTaskPlanDB.executeQuery(powerSql,PubFun.getFormatBV(paraList)); 
        

        if ((mLDTaskPlanSet != null) && (mLDTaskPlanSet.size() > 0))
        {
        	mDataChanged = true;
            int n = mLDTaskPlanSet.size();
            LDTaskPlanSchema tLDTaskPlanSchema = null;

            for (int i = 1; i <= n; i++)
            {
                tLDTaskPlanSchema = mLDTaskPlanSet.get(i);
                tLDTaskPlanSchema.setRunState("0");      //初始化运行状态
                mMap.put(tLDTaskPlanSchema.getSchema(), "UPDATE");

                if (!isExist(tLDTaskPlanSchema.getTaskPlanCode()))
                {
                    LDTaskDB tLDTaskDB = new LDTaskDB();
                    tLDTaskDB.setTaskCode(tLDTaskPlanSchema.getTaskCode());

                    LDTaskSet tLDTaskSet = tLDTaskDB.query();

                    if ((tLDTaskSet == null) || (tLDTaskSet.size() <= 0))
                    {
                        mErrors.addOneError(new CError("任务计划" + tLDTaskPlanSchema.getTaskPlanCode()
                            + "中的任务" + tLDTaskPlanSchema.getTaskCode() + "不存在！"));
                        continue;
                    }

                    String tClassName = tLDTaskSet.get(1).getTaskClass().trim();

                    try
                    {
                        Task tTask = new Task(tClassName);
                        tTask.SetTaskPlan(tLDTaskPlanSchema);

                        if (tTask.getNextRunTime().equals(""))
                        {
                            tTask.setNextRunTime(tSDF.format(Calendar.getInstance().getTime()));
                        }

                        LDTaskParamDB tLDTaskParamDB = new LDTaskParamDB();
                        tLDTaskParamDB.setTaskCode(tLDTaskPlanSchema.getTaskCode());
                        tLDTaskParamDB.setTaskPlanCode(tLDTaskPlanSchema.getTaskPlanCode());

                        LDTaskParamSet tLDTaskParamSet = tLDTaskParamDB.query();

                        if ((tLDTaskParamSet != null) && (tLDTaskParamSet.size() > 0))
                        {
                            LDTaskParamSchema tLDTaskParamSchema = null;
                            int m = tLDTaskParamSet.size();

                            for (int j = 1; j <= m; j++)
                            {
                                tLDTaskParamSchema = tLDTaskParamSet.get(j);
                                tTask.addParam(tLDTaskParamSchema.getParamName()
                                               , tLDTaskParamSchema.getParamValue());
                            }
                        }

                        mTaskWaitList.add(tTask);
                    }
                    catch (Exception ex)
                    {
                        mErrors.addOneError(new CError("创建任务实例失败！异常类型：" + ex.getClass().getName()));
                    }
                }
           }
        }

        return true;
    }

    private boolean searchReadyTask()
    { 
        int n = mTaskWaitList.size();
        String tCurrentTime = PubFun.getCurrentDate() + " " + PubFun.getCurrentTime();
        
        //招商数据库日期格式为yyyy/mm/dd
        //CMS数据库格式为YYYY-MM-DD
//        tCurrentTime = tCurrentTime.replaceAll("-", "/");

        for (int i = 0; i < n; i++)
        {
            Task tTask = (Task) mTaskWaitList.get(i);
            LDTaskPlanSchema tLDTaskPlanSchema = tTask.getTaskPlan();

            //只选择指定到本服务器的任务 added by zhanggl 2007-11-09
//            if ((tLDTaskPlanSchema.getIPAddress()==null || !tIP.equals(tLDTaskPlanSchema.getIPAddress()))&& !tLDTaskPlanSchema.getTaskPlanCode().equals("000000"))
//            {
//                continue;
//            }

            if (!tLDTaskPlanSchema.getRunFlag().equals("1"))
            {
                continue;
            }

            if (!(tLDTaskPlanSchema.getRunState().equals("0") || tLDTaskPlanSchema.getRunState().equals("3")))
            {
                continue;
            }

            if ((tTask.getNextRunTime() == null) || tTask.getNextRunTime().equals(""))
            {
                try
                {
                    tTask.taskFinish();
                }
                catch (Exception ex)
                {
                }
                tLDTaskPlanSchema.setRunFlag("0");
                tLDTaskPlanSchema.setRunState("3");
                mMap.put(tLDTaskPlanSchema, "UPDATE");
                mDataChanged = true;
                continue;
            }
            
            if (tCurrentTime.compareTo(tTask.getNextRunTime()) >= 0)
            {
                // kevin 2005-11-02
                // specile process for daily task
                //
                if (tLDTaskPlanSchema.getRecycleType().equals("31")||tLDTaskPlanSchema.getRecycleType().equals("51"))
                {
                    Date dateCurrent = new Date();
                    Date dateNextRunTime = null;
                    
                    try
                    {
                        dateNextRunTime = tSDF.parse(tTask.getNextRunTime());

                        // if NextRunTime is 2005-10-01 08:30:00,
                        // and CurrentTime between 2005-10-02 08:29:50 and 2005-10-02 08:30:10 will be ok
                        double dTimeDiff = Math.abs(dateCurrent.getTime() -
                            dateNextRunTime.getTime()) / 1000;
                        long tInterval = new Double(tLDTaskPlanSchema.
                            getInterval()).longValue();

                        if (tLDTaskPlanSchema.getRecycleType().equals("11"))
                        {
                            tInterval = 60;
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "12"))
                        {
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "21"))
                        {
                            tInterval = 60 * 60;
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "22"))
                        {
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "31"))
                        {
                            tInterval = 24 * 60 * 60;
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "32"))
                        {
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "41"))
                        {
                            tInterval = 7 * 24 * 60 * 60;
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "42"))
                        {
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "51"))
                        {
                            /*
                             * 取当前系统时间所在月应该的批处理时间和第一次设的批处理时间的差值为时间间隔WL2008-03-07改动
                             */
                            tInterval =
                                            Math.abs(PubFun.calInterval(PubFun.getCurrentDate().substring(0, 8)
                                                + tTask.getNextRunTime().substring(8, 10), tTask.getNextRunTime().substring(0, 10), "D") * 24 * 60 * 60);
                            
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "52"))
                        {
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "61"))
                        {
                            tInterval = 365 * 24 * 60 * 60;
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "62"))
                        {
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "71"))
                        {
                        }
                        else if (tLDTaskPlanSchema.getRecycleType().equals(
                            "72"))
                        {
                        }

                        double dLeft = dTimeDiff % tInterval;
                        if (dLeft > 10 && dLeft < tInterval - 10)
                        {
                            continue;
                        }
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
                // kevin 2005-11-02
                // specile process for daily task
                //

                if ((tLDTaskPlanSchema.getEndTime() != null)
                    && !tLDTaskPlanSchema.getEndTime().equals(""))
                {
                    if (tCurrentTime.compareTo(tLDTaskPlanSchema.getEndTime()) < 0)
                    {
                        mTaskReadyList.add(tTask);
                    }
                }
                else
                {
                    mTaskReadyList.add(tTask);
                }
            }
        }

        return true;
    }

    private void startTask()
    {
        int i = 0;
        int n = mTaskRunList.size();

        for (i = n - 1; i >= 0; i--) //将运行结束的任务线程移出运行队列
        {
            Task tTask = (Task) mTaskRunList.get(i);

            if (!tTask.isAlive())
            {
				try
				{
                    tTask.taskFinish();
                }
				catch (Exception ex)
				{
				}
                LDTaskPlanSchema tLDTaskPlanSchema = tTask.getTaskPlan();
                tLDTaskPlanSchema.setRunState("0");
                mMap.put(tLDTaskPlanSchema, "UPDATE");
                mDataChanged = true;
                mTaskRunList.remove(i);
            }
        }

        n = mTaskReadyList.size();

        for (i = 0; i < n; i++) //运行就绪队列众中的任务并添加倒运行队列中
        {
            Task tTask = (Task) mTaskReadyList.get(i);

            try
            {
                tTask.startTask();
                mTaskRunList.add(tTask);

                LDTaskPlanSchema tLDTaskPlanSchema = tTask.getTaskPlan();
                tLDTaskPlanSchema.setRunState("1");
                mMap.put(tLDTaskPlanSchema, "UPDATE");
                mDataChanged = true;

                if (!CalculateNextRunTime(tTask))
                {
                    mErrors.addOneError(new CError("任务" + tTask.getTaskID() + "启动异常，原因： 执行时间计算异常！"));
                    continue;
                }
            }
            catch (Exception ex)
            {
                String tEx = "";

                if (ex.getClass().getName().equals("NoTaskPlanException"))
                {
                    tEx = "无任务计划!";
                }
                else if (ex.getClass().getName().equals("TaskLogException"))
                {
                    tEx = "记录日志失败!";
                }
                else if (ex.getClass().getName().equals("IllegalThreadStateException"))
                {
                    tEx = "任务线程已经启动!";
                }
                else if (ex.getClass().getName().equals("Exception"))
                {
                    tEx = "任务线程实例创建异常";
                }
                mErrors.addOneError(new CError("任务" + tTask.getTaskID() + "启动异常，原因：" + tEx));

                try
                {
                    tTask.taskException();
                }
                catch (Exception e)
                {
                }
                LDTaskPlanSchema tLDTaskPlanSchema = tTask.getTaskPlan();
                tLDTaskPlanSchema.setRunFlag("0");
                tLDTaskPlanSchema.setRunState("5");
                mMap.put(tLDTaskPlanSchema, "UPDATE");
                mDataChanged = true;
            }
        }

        mTaskReadyList.removeAllElements();
    }

    private void stopTask()
    {
        int i = 0;
        int n = mTaskRunList.size();

        for (i = n - 1; i >= 0; i--) //结束运行队列中正在运行的线程
        {
            Task tTask = (Task) mTaskRunList.get(i);
            LDTaskPlanSchema tLDTaskPlanSchema = tTask.getTaskPlan();

            if (tTask.isAlive())
            {
                try
                {
                    tTask.stopTask();
                    tLDTaskPlanSchema.setRunFlag("0");
                    tLDTaskPlanSchema.setRunState("4");
                    mTaskRunList.remove(i);
                }
                catch (Exception ex)
                {
                    String tEx = "";

                    if (ex.getClass().getName().equals("SecurityException"))
                    {
                        tEx = "任务安全性限制强行终止!";
                    }
                    else if (ex.getClass().getName().equals("TaskLogException"))
                    {
                        tEx = "记录日志失败!";
                    }
                    mErrors.addOneError(new CError("任务" + tTask.getTaskID() + "停止异常，原因：" + tEx));
                }
            }
            else
            {
                tLDTaskPlanSchema.setRunState("3");
                mTaskRunList.remove(i);
            }

            mMap.put(tLDTaskPlanSchema, "UPDATE");
            mDataChanged = true;
        }
    }

    private boolean CalculateNextRunTime(Task aTask)
    {
        LDTaskPlanSchema tLDTaskPlanSchema = aTask.getTaskPlan();

        if ((tLDTaskPlanSchema.getTimes() > 0)
            && (aTask.getRunFrequence() >= tLDTaskPlanSchema.getTimes()))
        {
            aTask.setNextRunTime("");

            return true;
        }

        String tNextTime = "";

        try
        {
            Date tTime = Calendar.getInstance().getTime();
            long tInterval = new Double(tLDTaskPlanSchema.getInterval()).longValue();

            if (tLDTaskPlanSchema.getRecycleType().equals("11"))
            {
                tInterval = 60;
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("12"))
            {
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("21"))
            {
                tInterval = 60 * 60;
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("22"))
            {
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("31"))
            {
                tInterval = 24 * 60 * 60;
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("32"))
            {
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("41"))
            {
                tInterval = 7 * 24 * 60 * 60;
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("42"))
            {
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("51"))
            {
                /*
                 * java中对日期的加减操作 java中对日期的加减操作 gc.add(1,-1)表示年份减一. gc.add(2,-1)表示月份减一. gc.add(3.-1)表示周减一.
                 * gc.add(5,-1)表示天减一WL2008-03-07增加
                 * 计算下一次按月循环的批处理起期的话，在系统当前月批处理起期基础上加一个月得到下一个月批处理起期，然后下一个月起期和第一次起期相减得计算下一个月批处理起期的时间间隔
                 */
                GregorianCalendar gc = new GregorianCalendar();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                FDate fDate = new FDate();
                String tCurRunDate = tLDTaskPlanSchema.getStartTime().substring(0, 10);
                //得系统时间的年月
                String CurrentDate = PubFun.getCurrentDate().substring(0, 8);
                //得第一次批处理起期的日
                String tDay = tCurRunDate.substring(8, 10);
                String CurrentStartDate = CurrentDate + tDay;
                Date curStartDate =
                                fDate.getDate(CurrentStartDate);
                gc.setTime(curStartDate);
                gc.add(2, +1);
                gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
                String NextDate = sf.format(gc.getTime());
                tInterval = PubFun.calInterval(tCurRunDate,NextDate,"D") * 24 * 60 * 60;
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("52"))
            {
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("61"))
            {
                tInterval = 365 * 24 * 60 * 60;
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("62"))
            {
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("71"))
            {
                aTask.setNextRunTime("");

                return true;
            }
            else if (tLDTaskPlanSchema.getRecycleType().equals("72"))
            {
            }

            tTime.setTime(tTime.getTime() + tInterval * 1000);
            tNextTime = tSDF.format(tTime);

            String tEndTime = tLDTaskPlanSchema.getEndTime();

            if (!tNextTime.equals("") && ((tEndTime == null) || tEndTime.equals("")
                                          || ((tEndTime != null) && !tEndTime.equals("")
                                              && (tNextTime.compareTo(tLDTaskPlanSchema.getEndTime()) < 0))))
            {
                aTask.setNextRunTime(tNextTime);
            }
            else
            {
                aTask.setNextRunTime("");
            }
        }
        catch (Exception ex)
        {
            mErrors.addOneError(new CError("计算任务执行时间异常！"));
            return false;
        }

        return true;
    }

    private boolean isExist(String tTaskPlanCode)
    {
        int i = 0;
        int n = mTaskWaitList.size();

        for (i = 0; i < n; i++)
        {
            if (tTaskPlanCode.equals(((Task) mTaskWaitList.get(i)).getTaskID()))
            {
                return true;
            }
        }

        return false;
    }

    private int indexOf(String tTaskPlanCode)
    {
        int i = 0;
        int n = mTaskWaitList.size();

        for (i = 0; i < n; i++)
        {
            if (tTaskPlanCode.equals(((Task) mTaskWaitList.get(i)).getTaskID()))
            {
                return i;
            }
        }

        return -1;
    }

    public boolean startEngine()
    {
        synchronized (lock)
        {
            //获取服务器IP added by zhanggl 2007-11-09
            try {
            	String tHostName = InetAddress.getLocalHost().getHostName();
                tIP = InetAddress.getByName(tHostName).getHostAddress(); 
                System.out.println("服务器的ip=" + tIP);
////下面的方法是网上介绍在linux获取ip的方法，未验证
//            Enumeration netInterfaces=NetworkInterface.getNetworkInterfaces();
//            InetAddress ip = null;
//            while (netInterfaces.hasMoreElements()) {
//                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
//                System.out.println(ni.getName());
//                ip = (InetAddress) ni.getInetAddresses().nextElement();
//                System.out.println("本机的ip=" + ip.getHostAddress());
//                boolean t1=ip.isSiteLocalAddress();
//                boolean t2=ip.isLoopbackAddress();
//                boolean t3=ip.getHostAddress().indexOf(":") == -1;
//                if (!ip.isSiteLocalAddress()
//                    && !ip.isLoopbackAddress()
//                    && ip.getHostAddress().indexOf(":") == -1) {
//                    System.out.println("本机的ip=" + ip.getHostAddress());
//                    break;
//                } else {
//                    ip = null;
//                }
//            }

            } catch(Exception   e) {
                System.out.println(e);
            }

            mMap = new MMap();
            mErrors.clearErrors();
            mData.clear();
            scanTaskPlan();
            searchReadyTask();
            startTask();

            if (mDataChanged)
            {
                mData.clear();
                mData.add(mMap);

                PubSubmit tPubSubmit = new PubSubmit();

                if (!tPubSubmit.submitData(mData, ""))
                {
                    mErrors.addOneError(new CError("任务计划数据更新失败！"));
                    return false;
                }

                mDataChanged = false;
            }

            return!mErrors.needDealError();
        }
    }

    public boolean stopEngine()
    {
        synchronized (lock)
        {
            mMap = new MMap();
            mErrors.clearErrors();
            mData.clear();
            stopTask();
            mTaskRunList.removeAllElements();
            mTaskReadyList.removeAllElements();
            mTaskWaitList.removeAllElements();

            if (mDataChanged)
            {
                mData.clear();
                mData.add(mMap);

                PubSubmit tPubSubmit = new PubSubmit();

                if (!tPubSubmit.submitData(mData, ""))
                {
                    mErrors.addOneError(new CError("任务计划数据更新失败！"));
//                    System.out.println("任务计划数据更新失败！");

                    return false;
                }

                mDataChanged = false;
            }

            return mErrors.needDealError();
        }
    }

    public boolean addTask(LDTaskPlanSchema tLDTaskPlanSchema, LDTaskParamSet tLDTaskParamSet)
    {
        synchronized (lock)
        {
            mMap = new MMap();

            if (isExist(tLDTaskPlanSchema.getTaskPlanCode()))
            {
                mErrors.addOneError(new CError("任务计划" + tLDTaskPlanSchema.getTaskPlanCode()
                                               + "已经存在！"));
                return false;
            }

            LDTaskDB tLDTaskDB = new LDTaskDB();
            tLDTaskDB.setTaskCode(tLDTaskPlanSchema.getTaskCode());

            LDTaskSet tLDTaskSet = tLDTaskDB.query();

            if ((tLDTaskSet == null) || (tLDTaskSet.size() <= 0))
            {
                mErrors.addOneError(new CError("任务计划" + tLDTaskPlanSchema.getTaskPlanCode()
                                               + "中的任务" + tLDTaskPlanSchema.getTaskCode() + "不存在！"));
                return false;
            }

            String tClassName = tLDTaskSet.get(1).getTaskClass().trim();

            try
            {
                Task tTask = new Task(tClassName);
                tTask.SetTaskPlan(tLDTaskPlanSchema);

                if (tTask.getNextRunTime().equals(""))
                {
                    tTask.setNextRunTime(tSDF.format(Calendar.getInstance().getTime()));
                }

                if ((tLDTaskParamSet != null) && (tLDTaskParamSet.size() > 0))
                {
                    LDTaskParamSchema tLDTaskParamSchema = null;
                    int n = tLDTaskParamSet.size();

                    for (int i = 1; i <= n; i++)
                    {
                        tLDTaskParamSchema = tLDTaskParamSet.get(i);
                        tTask.addParam(tLDTaskParamSchema.getParamName()
                                       , tLDTaskParamSchema.getParamValue());
                    }
                }

                mTaskWaitList.add(tTask);
            }
            catch (Exception ex)
            {
                mErrors.addOneError(new CError("创建任务实例失败！异常类型：" + ex.getClass().getName()));
            }

            mMap.put(tLDTaskPlanSchema, "INSERT");

            if ((tLDTaskParamSet != null) && (tLDTaskParamSet.size() > 0))
            {
                mMap.put(tLDTaskParamSet, "INSERT");
            }

            mData.clear();
            mData.add(mMap);

            PubSubmit tPubSubmit = new PubSubmit();

            return tPubSubmit.submitData(mData, "");
        }
    }

    public boolean removeTask(LDTaskPlanSchema tLDTaskPlanSchema)
    {
        synchronized (lock)
        {
            mMap = new MMap();

            int i = indexOf(tLDTaskPlanSchema.getTaskPlanCode());

            if (i < 0)
            {
                mErrors.addOneError(new CError("任务计划" + tLDTaskPlanSchema.getTaskPlanCode()
                                               + "不存在！"));
                return false;
            }

            mTaskWaitList.remove(i);

            mMap.put(tLDTaskPlanSchema, "DELETE");

            LDTaskParamDB tLDTaskParamDB = new LDTaskParamDB();
            tLDTaskParamDB.setTaskCode(tLDTaskPlanSchema.getTaskCode());
            tLDTaskParamDB.setTaskPlanCode(tLDTaskPlanSchema.getTaskPlanCode());

            LDTaskParamSet tLDTaskParamSet = tLDTaskParamDB.query();

            if ((tLDTaskParamSet != null) && (tLDTaskParamSet.size() > 0))
            {
                mMap.put(tLDTaskParamSet, "DELETE");
            }

            mData.clear();
            mData.add(mMap);

            PubSubmit tPubSubmit = new PubSubmit();

            return tPubSubmit.submitData(mData, "");
        }
    }

    public boolean activateTask(LDTaskPlanSchema tLDTaskPlanSchema)
    {
        synchronized (lock)
        {
            mMap = new MMap();

            int i = indexOf(tLDTaskPlanSchema.getTaskPlanCode());

            if (i < 0)
            {
                mErrors.addOneError(new CError("任务计划" + tLDTaskPlanSchema.getTaskPlanCode()
                                               + "不存在！"));
//                System.out.println("任务计划" + tLDTaskPlanSchema.getTaskPlanCode() + "不存在！");

                return false;
            }

            Task tTask = (Task) mTaskWaitList.get(i);
            tTask.reset();
            tLDTaskPlanSchema = tTask.getTaskPlan();
            tLDTaskPlanSchema.setRunFlag("1");
            tLDTaskPlanSchema.setRunState("0");

            if (tTask.getNextRunTime().equals(""))
            {
                tTask.setNextRunTime(tSDF.format(Calendar.getInstance().getTime()));
            }

            mMap.put(tLDTaskPlanSchema, "UPDATE");
            mData.clear();
            mData.add(mMap);

            PubSubmit tPubSubmit = new PubSubmit();

            return tPubSubmit.submitData(mData, "");
        }
    }

    public boolean deactivateTask(LDTaskPlanSchema tLDTaskPlanSchema)
    {
        synchronized (lock)
        {
            mMap = new MMap();

            int i = indexOf(tLDTaskPlanSchema.getTaskPlanCode());

            if (i < 0)
            {
                mErrors.addOneError(new CError("任务计划" + tLDTaskPlanSchema.getTaskPlanCode()
                                               + "不存在！"));
                return false;
            }

            Task tTask = (Task) mTaskWaitList.get(i);
            tLDTaskPlanSchema = tTask.getTaskPlan();
            tLDTaskPlanSchema.setRunFlag("0");

            mMap.put(tLDTaskPlanSchema, "UPDATE");
            mData.clear();
            mData.add(mMap);

            PubSubmit tPubSubmit = new PubSubmit();

            return tPubSubmit.submitData(mData, "");
        }
    }

    public void run()
    {
        synchronized (lock)
        {
            mMap = new MMap();
            mData.clear();
            searchReadyTask();
            startTask();

            if (mDataChanged)
            {
                mData.clear();
                mData.add(mMap);

                PubSubmit tPubSubmit = new PubSubmit();
                tPubSubmit.submitData(mData, "");
                mDataChanged = false;
            }
        }
    }
}
