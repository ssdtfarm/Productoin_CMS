/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.taskservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sinosoft.lis.db.LDTaskRunLogDB;
import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubSubmit;
import com.sinosoft.lis.schema.LDTaskPlanSchema;
import com.sinosoft.lis.schema.LDTaskRunLogSchema;
import com.sinosoft.lis.vschema.LDTaskRunLogSet;
import com.sinosoft.utility.VData;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.lis.pubfun.PubFun1;

import java.net.InetAddress;


/**
 * <p>Title: 任务基类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: SinoSoft</p>
 * @author ZhangRong
 * @version 1.0
 */
public class Task //extends Thread
{
    private Thread mTaskThread;
    private String mThreadName;
    private String mTaskID;
    private LDTaskPlanSchema mLDTaskPlanSchema;
    private LDTaskRunLogSchema mLDTaskRunLogSchema;
    private String mRunTime;
    private String mNextRunTime;
    private long mRunFrequence;
    private int mState;
    private String mTaskResult;
    private static long mSerialNo;
    private int mThreadState; //任务状态，在重载run()时根据状态进行线程的相应处理
    protected HashMap Parameters;

    private static final int THREAD_READY = 0;
    private static final int THREAD_RUNNING = 1;
    private static final int THREAD_SUSPEND = 2;
    private static final int THREAD_RESUME = 3;
    private static final int THREAD_TERMINATE = 4;

    public Task(String aThreadName)
    {
        mThreadName = aThreadName;
        mLDTaskRunLogSchema = new LDTaskRunLogSchema();
        Parameters = new HashMap();
        mRunTime = "";
        mRunFrequence = 0;
        mState = 0;
        mTaskResult = "";
        mSerialNo = 0;
        mThreadState = THREAD_READY;
    }

    public String getTaskID()
    {
        return mTaskID;
    }

    public LDTaskPlanSchema getTaskPlan()
    {
        return mLDTaskPlanSchema;
    }

    public void SetTaskPlan(LDTaskPlanSchema aLDTaskPlanSchema)
    {
        mLDTaskPlanSchema = aLDTaskPlanSchema;
        if (mLDTaskPlanSchema != null)
        {
            mTaskID = mLDTaskPlanSchema.getTaskPlanCode();
            mNextRunTime = mLDTaskPlanSchema.getStartTime();
            if (mNextRunTime == null)
            {
                mNextRunTime = "";
            }
        }
    }

    public String getNextRunTime()
    {
        return mNextRunTime;
    }

    public boolean setNextRunTime(String aNextRunTime)
    {
        mRunTime = mNextRunTime;
        mNextRunTime = aNextRunTime;
        if (mNextRunTime == null)
        {
            mNextRunTime = "";
        }
        System.out.println("Task " + mTaskID + " Set NextRunTime: " +
                           aNextRunTime);
        return true;
    }

    public long getRunFrequence()
    {
        return mRunFrequence;
    }

    public void reset()
    {
        mRunTime = "";
        mRunFrequence = 0;
        mState = 0;
        mTaskResult = "";
        mThreadState = THREAD_READY;
    }

    /**
     *
     * @throws IllegalThreadStateException
     * @throws NoTaskPlanException
     * @throws TaskLogException
     * @throws Exception
     */
    public void startTask() throws IllegalThreadStateException, NoTaskPlanException, TaskLogException, Exception
    {
        if (mLDTaskPlanSchema == null)
        {
            System.out.println("Task " + mTaskID +
                               " Error Occur: stopTask NoTaskPlanException");
            throw new NoTaskPlanException();
        }

        mThreadState = THREAD_RUNNING;
        mRunFrequence++;

        if (!logTask("1"))
        {
            throw new TaskLogException();
        }

        try
        {
            Class tTaskClass = Class.forName("com.sinosoft.lis.taskservice." +
                                             mThreadName);
            TaskThread tTaskThread = (TaskThread) tTaskClass.newInstance();
			tTaskThread.setParameter(Parameters);
            mTaskThread = new Thread(tTaskThread);
            System.out.println("任务计划" + mTaskID + "运行！ 运行次数：" + mRunFrequence +
                               " 运行时间：" + mRunTime);
            mTaskThread.start();
        }
        catch (IllegalThreadStateException ex)
        {
            throw new IllegalThreadStateException();
        }
        catch (Exception ex)
        {
            throw new Exception();
        }
    }

    /**
     *
     * @param aSeconds long
     * @throws InterruptedException
     * @throws TaskLogException
     */
    public void suspendTask(long aSeconds) throws InterruptedException, TaskLogException
    {
        mThreadState = THREAD_SUSPEND;
        try
        {
            Thread.sleep(aSeconds * 1000);
        }
        catch (InterruptedException ex)
        {
            throw new InterruptedException();
        }
        mThreadState = THREAD_RUNNING;
    }

	/**
	 *
	 * @throws SecurityException
	 * @throws TaskLogException
	 */
	public void stopTask() throws SecurityException, TaskLogException
	{
		mThreadState = THREAD_TERMINATE;
		/*    try
				{
						mTaskThread.sleep(5000);
				}
				catch (InterruptedException ex)
				{
				}
		 */
		if (mTaskThread.isAlive())
		{
			try
			{
				mTaskThread.interrupt();
			}
			catch (SecurityException ex)
			{
				System.out.println("Task " + mTaskID +
								   " Exception Occur: stopTask SecurityException");
				throw new SecurityException();
			}
		}
		if (!logTask("4"))
		{
			throw new TaskLogException();
		}
	}

	/**
	 *
	 * @throws TaskLogException
	 */
	public void taskFinish() throws TaskLogException
	{
		if (!logTask("3"))
		{
			throw new TaskLogException();
		}
	}

	/**
	 *
	 * @throws TaskLogException
	 */
	public void taskException() throws TaskLogException
	{
		if (!logTask("5"))
		{
			throw new TaskLogException();
		}
	}

    /**
     *
     * @return boolean
     */
    public boolean isAlive()
    {
		if (mTaskThread != null)
		{
            return mTaskThread.isAlive();
        }
		else
		{
			return false;
		}
    }

    /**
     *
     * @param aState String
     * @return boolean
     */
    private boolean logTask(String aState)
    {
        VData tData = new VData();
        MMap tMap = new MMap();

        if (mSerialNo == 0)
        {
            LDTaskRunLogDB tLDTaskRunLogDB = new LDTaskRunLogDB();
//            LDTaskRunLogSet tLDTaskRunLogSet = tLDTaskRunLogDB.executeQuery(
//                "select * from LDTaskRunLog where SerialNo = (select MAX(SerialNo) from LDTaskRunLog)");
            
            String powerSql = "select * from LDTaskRunLog where SerialNo = (select MAX(SerialNo) from LDTaskRunLog) "; 
            List paraList =new ArrayList(); 
            LDTaskRunLogSet tLDTaskRunLogSet = tLDTaskRunLogDB.executeQuery(powerSql,PubFun.getFormatBV(paraList)); 
            
            if (tLDTaskRunLogDB.mErrors.needDealError() ||
                tLDTaskRunLogSet.size() > 1)
            {
                System.out.println("Task " + mTaskID +
                                   " Error Occur: logTask Fail");
                return false;
            }
            else if (tLDTaskRunLogSet == null || tLDTaskRunLogSet.size() == 0)
            {
                mSerialNo = 0;
            }
            else
            {
                mSerialNo = new Double(tLDTaskRunLogSet.get(1).getSerialNo()).
                            longValue();
            }
        }

        mLDTaskRunLogSchema.setExecuteState(aState);

        if (aState.equals("1")) // 1:任务启动
        {
//            mSerialNo++;
            mSerialNo = (Long.parseLong(PubFun1.CreateMaxNo("TASKRUNLOGSN", "SN")))/10;
            mLDTaskRunLogSchema.setSerialNo(mSerialNo);
            mLDTaskRunLogSchema.setTaskCode(mLDTaskPlanSchema.getTaskCode());
            mLDTaskRunLogSchema.setTaskPlanCode(mLDTaskPlanSchema.
                                                getTaskPlanCode());
            mLDTaskRunLogSchema.setExecuteDate(PubFun.getCurrentDate());
            mLDTaskRunLogSchema.setExecuteTime(PubFun.getCurrentTime());
            mLDTaskRunLogSchema.setExecuteFrequence(mRunFrequence);
            
            //取IP
    		try
    		{
    			String tHostName = InetAddress.getLocalHost().getHostName();
    			String tIP1 = InetAddress.getByName(tHostName).getHostAddress();
    			
    			//String tSql ="select sys_context('userenv','ip_address')   from dual";
    			String tSql ="SELECT client_net_address FROM sys.dm_exec_connections WHERE session_id = @@SPID";
    			ExeSQL tExeSQL = new ExeSQL();
    			String tIP2 = tExeSQL.getOneValue(tSql);
    			System.out.println(tIP1 +"--"+tIP2);
    			mLDTaskRunLogSchema.setExecuteResult(tIP1 +"--"+tIP2);

    		} catch (Exception e)
    		{

    		}
            tMap.put(mLDTaskRunLogSchema, "INSERT");
        }

        if (aState.equals("2")) // 2:暂停
        {
            tMap.put(mLDTaskRunLogSchema, "UPDATE");
        }

        if ((aState.equals("3") || aState.equals("4") || aState.equals("5"))&& mLDTaskRunLogSchema.getSerialNo() != 0) // 3:正常终止 4:强行终止 5:异常终止
        {
            mLDTaskRunLogSchema.setFinishDate(PubFun.getCurrentDate());
            mLDTaskRunLogSchema.setFinishTime(PubFun.getCurrentTime());
            tMap.put(mLDTaskRunLogSchema, "UPDATE");
        }

        tData.add(tMap);
        PubSubmit tPubSubmit = new PubSubmit();
        if (!tPubSubmit.submitData(tData, ""))
        {
            System.out.println("Task " + mTaskID +
                               " Error Occur: logTask Data Submit Fail");
            return false;
        }
        return true;
    }

    public void addParam(String ParamName, String ParamValue)
    {
        Parameters.put(ParamName, ParamValue);
    }
}
