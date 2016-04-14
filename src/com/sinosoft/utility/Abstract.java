package com.sinosoft.utility;

import com.sinosoft.lis.pubfun.MMap;
import com.sinosoft.lis.pubfun.GlobalInput;
import com.sinosoft.utility.VData;

/**
 * <p>Title: </p>
 *
 * <p>Description: 是AbstractUI、AbstractBL和AbstractBLF的父类，
 *                 提供了数据提交流程中常用的一些公用函数；
 *  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: Sinosoft </p>
 *
 * @author wellhi
 * @version 1.0
 */
public abstract class Abstract
{
  public Abstract()
  {
  }

  /** 往前面传输数据的容器 */
  public VData Results=new VData();
  /** 传入数据的容器 */
  protected VData InputData;
  /** 数据操作字符串 */
  protected String Operate;
  /** 错误处理类 */
  public CErrors Errors = new CErrors();
  /** 全局数据*/
  protected GlobalInput GlobalInput = new GlobalInput();
  /** 数据库提交容器*/
  protected MMap MMap = new MMap();

  //获取传入参数
  protected abstract boolean getInputData();

  //校验传入参数的合法性
  protected abstract boolean checkInputData();

  //进行业务处理
  protected abstract boolean dealData();

  //准备输出处理结果
  protected abstract boolean prepareOutData();

  //提交业务处理
  public boolean submitData(VData cInputData, String cOperate)
  {
    //获取并备份传入参数
    InputData = (VData) cInputData.clone();
    Operate = cOperate;

    //获取传入参数
    if (!getInputData())
    {
      return false;
    }

    //校验传入参数的合法性
    if (!checkInputData())
    {
      return false;
    }

    //进行业务处理
    if (!dealData())
    {
      return false;
    }

    //准备输出处理结果
    if (!prepareOutData())
    {
      return false;
    }

    return true;
  }

//  //设置返回结果
//  public void setResults(VData results)
//  {
//    this.Results = results;
//  }
//
//  //获取返回结果集
//  public VData getResults()
//  {
//    return Results;
//  }

  /**
   * 错误构建
   * @param moduleName String
   * @param szFunc String
   * @param szErrMsg String
   */
  protected void buildError(String moduleName, String szFunc, String szErrMsg)
  {
    CError cError = new CError();
    cError.moduleName = moduleName;
    cError.functionName = szFunc;
    cError.errorMessage = szErrMsg;
    this.Errors.addOneError(cError);
  }

}
