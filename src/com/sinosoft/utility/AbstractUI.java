package com.sinosoft.utility;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author wellhi
 * @version 1.0
 */
import com.sinosoft.lis.pubfun.*;

public abstract class AbstractUI
    extends Abstract
{
  private AbstractBLF nAbstractBLF;
  private String Package = "";
  private String ClassName = "";
  //获取传入参数
  protected abstract boolean getInputData();

  //进行业务处理
  protected abstract boolean dealData();

  //准备输出处理结果
  protected abstract boolean prepareOutData();

  //设置BLF类的包名和类名,统一到PubFun动态加载类和错误处理
  //在子类中调用setPackage和setClassName
  public abstract void setBLFClass();

  //设置包名
  public void setPackage(String sPackage)
  {
    this.Package=sPackage;
  }

  //设置类名
  public void setClassName(String sClassName)
  {
    this.ClassName=sClassName;
  }

  //获取BLF的动态加载类
  private boolean getBLFClass(String sPackage, String sClassName)
  {
    nAbstractBLF = (AbstractBLF) PubFun.getClassForName(sPackage, sClassName);
    boolean blnRet = (nAbstractBLF != null) ? true : false;
    return blnRet;
  }

  //重载父类的submitData,提交到BLF进行业务处理
  public boolean submitData(VData cInputData, String cOperate)
  {
    this.InputData = (VData) cInputData.clone();
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

    //设置BLF类，动态加载
    setBLFClass();

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

    //获取动态加载的BLF类
    if (!getBLFClass(this.Package, this.ClassName))
    {
      return false;
    }

    //提交BLF，调用需要处理的BL类
    if (!nAbstractBLF.submitData(cInputData, cOperate))
    {
      this.Errors.copyAllErrors(nAbstractBLF.Errors);
      return false;
    }
    else
    {
       this.Results = nAbstractBLF.Results;
    }

    return true;
  }
}
