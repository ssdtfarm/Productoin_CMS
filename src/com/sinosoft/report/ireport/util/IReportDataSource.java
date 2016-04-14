package com.sinosoft.report.ireport.util;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;

/**
* <p>Description:  IReportDataSource接口 </p>
*/

public interface IReportDataSource extends JRDataSource{
    public Object getParamObject();
    
    public List getDetailItems();
    
}
