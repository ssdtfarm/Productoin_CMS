/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.taskservice;

import java.util.HashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: SinoSoft</p>
 * @author ZhangRong
 * @version 1.0
 */

public class TaskThread implements Runnable
{
    protected HashMap mParameters = new HashMap();

    public TaskThread()
    {
    }

    public void setParameter(HashMap aParameters)
    {
        mParameters = aParameters;
    }

    public void run()
    {

    }

}
