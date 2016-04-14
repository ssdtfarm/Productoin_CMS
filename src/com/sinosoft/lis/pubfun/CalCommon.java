package com.sinosoft.lis.pubfun;

import com.sinosoft.utility.VData;

/**
 * <p>Title: 业务系统</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: sinosoft</p>
 *
 * @author Tuqiang
 * @version 1.0
 */
public interface CalCommon {
    public boolean submitData(VData data);

    public VData getResult();
}
