/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.taskservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.sinosoft.lis.db.LDTaskPlanDB;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.schema.LDTaskParamSchema;
import com.sinosoft.lis.schema.LDTaskPlanSchema;
import com.sinosoft.lis.vschema.LDTaskParamSet;
import com.sinosoft.lis.vschema.LDTaskPlanSet;
import com.sinosoft.lis.vschema.LDTaskRunLogSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.VData;


/**
 * <p>Title: 后台任务处理主控模块</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: SinoSoft</p>
 * @author ZhangRong
 * @version 1.0
 */
public class TaskService
{
    private static TaskServiceEngine mTaskServiceEngine;
    private static Timer mTaskServiceTimer;
    private static boolean mTimerRunning;
    private String mOperator;
    private LDTaskPlanSchema mLDTaskPlanSchema;
    private LDTaskParamSet mLDTaskParamSet;
    private VData mResult = new VData();
//        private MMap mMap = new MMap();
    public CErrors mErrors = new CErrors();
    private String mTaskPlanCode; 

    public TaskService()
    {
        /*		if (mTaskServiceEngine == null)
                        {
                                mTaskServiceEngine = new TaskServiceEngine();
                        }

                        if (mTaskServiceTimer == null)
                        {
                                mTaskServiceTimer = new Timer();
                        }*/
    }

    /**
     * 后台服务提交
     * @param aInputData VData
     * @param aOperate String
     * @return int
     * return 0:正常 -1:异常且timer未启动 其他:部分异常，timer启动
     */
    public int submitData(VData aInputData, String aOperate)
    {
        int tOperateResult = 0;
        mResult.clear();

        if (aOperate == null)
        {
            tOperateResult = -1;
        }
        if (aOperate.toUpperCase().equals("START"))
        {
            tOperateResult = serviceStart();
        }
        else if (aOperate.toUpperCase().equals("STOP"))
        {
            tOperateResult = serviceStop();
        }
        else if (aOperate.toUpperCase().equals("GETSTATE"))
        {
            tOperateResult = getServiceState();
        }
        else if (aOperate.toUpperCase().equals("INSERTTASK")
                || aOperate.toUpperCase().equals("DELETETASK"))
        {
            TaskSet tTaskSet = new TaskSet();
            if (!tTaskSet.submitData(aInputData, aOperate))
            {
                tOperateResult = -1;
            }
            tOperateResult = 0;
        }
        else
        {
            if (!mTimerRunning)
            {
                mErrors.addOneError(new CError("任务服务引擎尚未启动！"));
                tOperateResult = -1;
            }
            else
            {
                boolean tResultFlag = true;

                if (!getInputData(aInputData))
                {
                    tOperateResult = -1;
                }
                else if (aOperate.toUpperCase().equals("INSERT"))
                {
                    tResultFlag = insertTask();
                }
                else if (aOperate.toUpperCase().equals("DELETE"))
                {
                    tResultFlag = deleteTask();
                }
                else if (aOperate.toUpperCase().equals("DELETE&INSERT"))
                {
                    tResultFlag = insertTask();
                    tResultFlag = deleteTask2();
                }
                else if (aOperate.toUpperCase().equals("ACTIVATE"))
                {
                    tResultFlag = activateTask();
                }
                else if (aOperate.toUpperCase().equals("DEACTIVATE"))
                {
                    tResultFlag = deactivateTask();
                }

                if (!tResultFlag)
                {
                    tOperateResult = -1;
                }
            }
        }

        System.out.println("return: " + Integer.toString(tOperateResult));

        return tOperateResult;
    }

    private int serviceStart()
    {
        int tResult = 0;
        if (mTimerRunning)
        {
            mErrors.addOneError(new CError("任务引擎已经启动!"));
            return -2;
        }
        
        LDTaskPlanDB tLDTaskPlanDB = new LDTaskPlanDB();
        LDTaskPlanSchema kLDTaskPlanSchema = new LDTaskPlanSchema();
        kLDTaskPlanSchema.setTaskPlanCode("000000");
        tLDTaskPlanDB.setSchema(kLDTaskPlanSchema);
        LDTaskPlanSet tLDTaskPlanSet = tLDTaskPlanDB.query();

        if ((tLDTaskPlanSet == null) || (tLDTaskPlanSet.size() <= 0))
        {
            mErrors.copyAllErrors(tLDTaskPlanDB.mErrors);
            mErrors.addOneError(new CError("无法取得任务引擎信息!"));
            tResult = -1;
        }

        LDTaskPlanSchema tLDTaskPlanSchema = tLDTaskPlanSet.get(1);

        try
        {
            mTaskServiceEngine = new TaskServiceEngine();
            if (!mTaskServiceEngine.startEngine())
            {
                mErrors.copyAllErrors(TaskServiceEngine.mErrors);
                mErrors.addOneError(new CError("任务引擎启动中出现异常，部分任务未能启动！"));
                tResult = 1;
            }

            long l = new Double(tLDTaskPlanSchema.getInterval()).longValue();
            mTaskServiceTimer = new Timer();
            mTaskServiceTimer.schedule(mTaskServiceEngine, l, l);
            mTimerRunning = true;
            System.out.println("后台任务服务引擎启动！");
        }
        catch (IllegalArgumentException iex)
        {
            mErrors.addOneError(new CError("间隔时间时间有误!"));
            tResult = -1;
        }
        catch (Exception ex)
        {
            mErrors.addOneError(new CError("任务起动异常!"));
            tResult = -1;
        }

        return tResult;
    }

    private int serviceStop()
    {
        int tResult = 0;

        if (!mTimerRunning)
        {
            mErrors.addOneError(new CError("任务引擎尚未启动!"));
            tResult = -1;
        }
        else if (!mTaskServiceEngine.stopEngine())
        {
        	mTaskServiceTimer.cancel();
            mErrors.copyAllErrors(TaskServiceEngine.mErrors);
            mErrors.addOneError(new CError("任务引擎终止中出现异常，部分任务未能终止！"));
            tResult = 1;
            mTaskServiceEngine = null;
            mTaskServiceTimer = null;
            mTimerRunning = false;
        }
        return tResult;
    }

    private int getServiceState()
    {
        if (mTimerRunning)
        {
            mResult.add(new String("RUNNING"));
        }
        else
        {
            mResult.add(new String("SLEEPING"));
        }

        return 0;
    }

    private boolean getInputData(VData aInputData)
    {
        GlobalInput tGI = (GlobalInput) aInputData.getObjectByObjectName("GlobalInput", 0);
        LDTaskPlanSet tLDTaskPlanSet = (LDTaskPlanSet) aInputData.getObjectByObjectName(
                "LDTaskPlanSet", 0);
        LDTaskParamSet tLDTaskParamSet = (LDTaskParamSet) aInputData.getObjectByObjectName(
                "LDTaskParamSet", 0);

        if ((tGI == null) || (tLDTaskPlanSet == null) || (tLDTaskPlanSet.size() <= 0))
        {
            mErrors.addOneError(new CError("传入数据不完全！"));
            return false;
        }

        mLDTaskParamSet = tLDTaskParamSet;
        mLDTaskPlanSchema = tLDTaskPlanSet.get(1);
        mOperator = tGI.Operator;
        //modified by wl 20080529:在修改任务功能是用到此任务号
        mTaskPlanCode = mLDTaskPlanSchema.getTaskPlanCode();

        return true;
    }

    /**
     * 增加任务操作
     * @return boolean
     */
    private boolean insertTask()
    {
        if ((mLDTaskPlanSchema.getTaskCode() == null) || mLDTaskPlanSchema.getTaskCode().equals(""))
        {
            mErrors.addOneError(new CError("缺少任务信息!")); 
            return false;
        }

        int tCodeInt = 0;
        String tCodeString = "000000";
        LDTaskPlanDB tLDTaskPlanDB = new LDTaskPlanDB();
//        LDTaskPlanSet tLDTaskPlanSet = tLDTaskPlanDB.executeQuery(
//                "select * from LDTaskPlan where TaskPlanCode = (select MAX(TaskPlanCode) from LDTaskPlan)"); //取最大序列号
        
        String powerSql = "select * from LDTaskPlan where TaskPlanCode = (select MAX(TaskPlanCode) from LDTaskPlan) "; 
        List paraList =new ArrayList(); 
        LDTaskPlanSet tLDTaskPlanSet = tLDTaskPlanDB.executeQuery(powerSql,PubFun.getFormatBV(paraList)); 
        
        if ((tLDTaskPlanSet != null) && (tLDTaskPlanSet.size() > 0))
        {
            tCodeString = tLDTaskPlanSet.get(1).getTaskPlanCode();
        }

        try
        {
            tCodeInt = Integer.parseInt(tCodeString);
            tCodeInt++;
            tCodeString = Integer.toString(tCodeInt);
            tCodeString = "000000".substring(1, 6 - tCodeString.length() + 1) + tCodeString; //生成新任务计划编码
        }
        catch (Exception ex)
        {
            return false;
        }

        mLDTaskPlanSchema.setTaskPlanCode(tCodeString);

        if ((mLDTaskPlanSchema.getRunFlag() == null) || mLDTaskPlanSchema.getRunFlag().equals(""))
        {
            mLDTaskPlanSchema.setRunFlag("1"); //未指明是否启动时默认为启动
        }

        mLDTaskPlanSchema.setRunState("0"); //初始状态为等待
        mLDTaskPlanSchema.setOperator(mOperator);
        mLDTaskPlanSchema.setMakeDate(PubFun.getCurrentDate());
        mLDTaskPlanSchema.setMakeTime(PubFun.getCurrentTime());
        mLDTaskPlanSchema.setModifyDate(PubFun.getCurrentDate());
        mLDTaskPlanSchema.setModifyTime(PubFun.getCurrentTime());

        if (mLDTaskParamSet != null) //如果有参数
        {
            int n = mLDTaskParamSet.size();

            for (int i = 1; i <= n; i++)
            {
                LDTaskParamSchema tLDTaskParamSchema = mLDTaskParamSet.get(i);

                if ((tLDTaskParamSchema.getParamName() == null)
                        || tLDTaskParamSchema.getParamName().equals("")
                        || (tLDTaskParamSchema.getParamValue() == null)
                        || tLDTaskParamSchema.getParamValue().equals(""))
                {
                    mErrors.addOneError(new CError("参数信息不完全!"));
                    return false;
                }
                for (int j = 1; (j != i) && (j <= n); j++)
                {

                    if (tLDTaskParamSchema.getParamName().equals(mLDTaskParamSet.get(j).
                            getParamName())) //判断参数名是否有重复
                    {
                        mErrors.addOneError(new CError("参数名重复!"));
                        return false;
                    }
                }

                tLDTaskParamSchema.setTaskPlanCode(mLDTaskPlanSchema.getTaskPlanCode());
                tLDTaskParamSchema.setTaskCode(mLDTaskPlanSchema.getTaskCode());
                tLDTaskParamSchema.setOperator(mOperator);
                tLDTaskParamSchema.setMakeDate(PubFun.getCurrentDate());
                tLDTaskParamSchema.setMakeTime(PubFun.getCurrentTime());
                tLDTaskParamSchema.setModifyDate(PubFun.getCurrentDate());
                tLDTaskParamSchema.setModifyTime(PubFun.getCurrentTime());
            }
        }

        return mTaskServiceEngine.addTask(mLDTaskPlanSchema, mLDTaskParamSet);
    }

    /**
     * 删除任务操作
     * @return boolean
     */
    private boolean deleteTask()
    {
        LDTaskPlanDB tLDTaskPlanDB = new LDTaskPlanDB();
        tLDTaskPlanDB.setTaskPlanCode(mLDTaskPlanSchema.getTaskPlanCode());

        LDTaskPlanSet tLDTaskPlanSet = tLDTaskPlanDB.query();

        if ((tLDTaskPlanSet == null) || (tLDTaskPlanSet.size() <= 0))
        {
            mErrors.addOneError(new CError("未查到相应的任务计划！"));
            return false;
        }

        mLDTaskPlanSchema = tLDTaskPlanSet.get(1);

        return mTaskServiceEngine.removeTask(mLDTaskPlanSchema);
    }
    
    //modified by wl20080529:添加修改功能
    /**
     * 删除任务操作
     * @return boolean
     */
    private boolean deleteTask2()
    {
        LDTaskPlanDB tLDTaskPlanDB = new LDTaskPlanDB();
        tLDTaskPlanDB.setTaskPlanCode(mTaskPlanCode);

        LDTaskPlanSet tLDTaskPlanSet = tLDTaskPlanDB.query();

        if ((tLDTaskPlanSet == null) || (tLDTaskPlanSet.size() <= 0))
        {
            mErrors.addOneError(new CError("未查到相应的任务计划！"));
            return false;
        }

        mLDTaskPlanSchema = tLDTaskPlanSet.get(1);

        return mTaskServiceEngine.removeTask(mLDTaskPlanSchema);
    }

    private boolean activateTask()
    {
        LDTaskPlanDB tLDTaskPlanDB = new LDTaskPlanDB();
        tLDTaskPlanDB.setTaskPlanCode(mLDTaskPlanSchema.getTaskPlanCode());

        LDTaskPlanSet tLDTaskPlanSet = tLDTaskPlanDB.query();

        if ((tLDTaskPlanSet == null) || (tLDTaskPlanSet.size() <= 0))
        {
            mErrors.addOneError(new CError("未查到相应的任务计划！"));
            return false;
        }

        mLDTaskPlanSchema = tLDTaskPlanSet.get(1);
        mLDTaskPlanSchema.setRunFlag("1");

        return mTaskServiceEngine.activateTask(mLDTaskPlanSchema);
    }

    private boolean deactivateTask()
    {
        LDTaskPlanDB tLDTaskPlanDB = new LDTaskPlanDB();
        tLDTaskPlanDB.setTaskPlanCode(mLDTaskPlanSchema.getTaskPlanCode());

        LDTaskPlanSet tLDTaskPlanSet = tLDTaskPlanDB.query();

        if ((tLDTaskPlanSet == null) || (tLDTaskPlanSet.size() <= 0))
        {
            mErrors.addOneError(new CError("未查到相应的任务计划！"));
            return false;
        }

        mLDTaskPlanSchema = tLDTaskPlanSet.get(1);
        mLDTaskPlanSchema.setRunFlag("0");

        return mTaskServiceEngine.deactivateTask(mLDTaskPlanSchema);
    }

    /**
     * 测试函数
     * @param args String[]
     */
//    public static void main(String[] args)
//    {
//        TaskService taskService = new TaskService();
//        VData tData = new VData();
//        taskService.submitData(tData, "START");
//    }
}
