package com.sinosoft.service.exception;
import org.apache.log4j.Logger;

import java.io.PrintStream;
/**
 * service对应异常处理
 *  * <p>Description: 转发设计</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: sinosoft</p>
 *
 * @author litao
 * @version 1.0
 * */
public class ServiceException extends RuntimeException {
private static Logger logger = Logger.getLogger(ServiceException.class);
	public ServiceException(String msg)
	{
		super(msg);
	}
	public ServiceException(String msg,Throwable tExcep)
	{
		super(msg,tExcep);
	}
}
