package com.sinosoft.utility;

import com.sinosoft.Resource.bundle;
import com.sinosoft.lis.pubfun.PubSubmit;

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
public abstract class AbstractBLF
    extends Abstract
{
  public AbstractBLF()
  {
  }

  private boolean pubSubmit()
  {
    PubSubmit tPubSubmit = new PubSubmit();
    if (tPubSubmit.submitData(InputData, Operate))
    {
      return true;
    }
    else
    {
      // @@错误处理
      this.Errors.copyAllErrors(tPubSubmit.mErrors);
      this.buildError("AbstractBL", "pubSubmit", ""+bundle.getString("DatasubmitFaild")+"");
      return false;
    }
  }

  //重载父类的submitData
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

    //这个地方是否要设置成自动提交，还要权衡一下。
    //因为如果没有数据需要去提交给数据库的话，PubSubmit也会创建数据库连接，会造成资源浪费
    //　数据提交、保存
    if (!pubSubmit())
    {
      return false;
    }
    return true;
  }

}
