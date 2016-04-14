/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 * 修改人：周磊
 * 修改日期：2005-5-4
 * 修改内容1：增加根据菜单标志（NodeSign）进行相应菜单添加删除的逻辑判断
 */
package com.sinosoft.lis.menumang;

import com.sinosoft.Resource.bundle;
import java.sql.Connection;
import java.sql.SQLException;

import com.sinosoft.lis.db.LDMenuDB;
import com.sinosoft.lis.db.LDMenuGrpToMenuDB;
import com.sinosoft.lis.schema.LDMenuGrpToMenuSchema;
import com.sinosoft.lis.schema.LDMenuSchema;
import com.sinosoft.lis.vschema.LDMenuGrpToMenuSet;
import com.sinosoft.lis.vschema.LDMenuSet;
import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;
import com.sinosoft.utility.DBConnPool;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.TransferData;
import com.sinosoft.utility.VData;


/**
 * <p>Title: Web业务系统</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author Fanym
 * @version 1.0
 */

public class LDMenuFunBLS
{
    //错误处理类，每个需要错误处理的类中都放置该类
    public CErrors mErrors = new CErrors();

    /** 数据操作字符串 */
    private String mOperate = null;
    private VData mInputData = new VData();

    public LDMenuFunBLS()
    {
    }

    public boolean submitData(VData cInputData, String cOperate)
    {
        boolean tReturn = false;
        //将操作数据拷贝到本类中
        this.mOperate = cOperate;
        this.mInputData = (VData) cInputData.clone();
//        System.out.println("Start LDMenu BLS Submit...");
        //菜单插入
        if (this.mOperate.equals("insert"))
        {
            tReturn = insertCode(this.mInputData);
        }

        //菜单删除
        if (this.mOperate.equals("delete"))
        {
            tReturn = deleteCode(this.mInputData);
        }

//        System.out.println("End LDMenu BLS Submit...");

        return tReturn;
    }


//删除操作
    private boolean deleteCode(VData mInputData)
    {
        boolean tReturn = true;
//        System.out.println("start delete...");
        Connection conn = DBConnPool.getConnection();
        if (conn == null)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDMenuFunBLS";
            tError.functionName = "saveData";
            tError.errorMessage = ""+bundle.getString("connFaild")+"!";
            this.mErrors.addOneError(tError);
            return false;
        }
        try
        {
            conn.setAutoCommit(false);
            LDMenuSchema tLDMenuSchema = (LDMenuSchema) mInputData.
                                         getObjectByObjectName("LDMenuSchema",
                    0);
            if(!delete(tLDMenuSchema,conn))
            	return false;
            conn.commit();
            conn.close();
//            System.out.println("commit end");
        }
        catch (Exception ex)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDMenuFunBLS";
            tError.functionName = "submitData";
            tError.errorMessage = ex.toString();
            this.mErrors.addOneError(tError);
            try
            {
                conn.rollback();
                conn.close();
            }
            catch (Exception e)
            {}
            tReturn = false;
        }
        return tReturn;
    }
    
    private boolean delete(LDMenuSchema tLDMenuSchema,Connection conn) throws SQLException
    {
    	String ChildFlag = tLDMenuSchema.getChildFlag();
        String NodeCode = tLDMenuSchema.getNodeCode();
        String ParentNodeCode = tLDMenuSchema.getParentNodeCode();
        String NodeSign = tLDMenuSchema.getNodeSign();
        if (!ChildFlag.equals("0"))
        {
            CError tError = new CError();
            tError.moduleName = "LDMenuFunBLS";
            tError.functionName = "deleteCode";
            tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
            this.mErrors.addOneError(tError);
            conn.close();
            return false;
        }
        else
        {
//            System.out.println("Start 删除菜单...");
            //处理父菜单
//            System.out.println("BLS insert inputdata...childflag:" +
//                               ChildFlag);
//            System.out.println("BLS insert inputdata...NodeCode" + NodeCode);
//            System.out.println("BLS insert inputdata...ParentNodeCode" +
//                               ParentNodeCode);
            LDMenuDB tLDMenuDB = new LDMenuDB(conn);
            tLDMenuDB.setSchema(tLDMenuSchema);
            if (!tLDMenuDB.deleteSQL())
            {
                // @@错误处理
                CError tError = new CError();
                tError.moduleName = "LDMenuFunBLS";
                tError.functionName = "deleteCode";
                tError.errorMessage = ""+bundle.getString("deleteFaild")+"!";
                this.mErrors.addOneError(tError);
                conn.rollback();
                conn.close();
                return false;
            }
            //处理菜单分组和关联表
            System.out.println("Start 处理菜单分组和菜单关联表...");
            ExeSQL tExeSQL = new ExeSQL(conn);
            String sql = "delete from LDMenuGrpToMenu where NodeCode = '"
                         + NodeCode + "'";
            //删除末级菜单的页面权限菜单
            String sql2 ="delete from LDMenu where NodeCode = '" + NodeCode + "'"
                         + " or (ParentNodeCode = '" + NodeCode + "' and NodeSign = 2)";
            if (!tExeSQL.execUpdateSQL(sql) || !tExeSQL.execUpdateSQL(sql2))
            {
                CError tError = new CError();
                tError.moduleName = "LDMenuFunBLS";
                tError.functionName = "deleteCode";
                tError.errorMessage = ""+bundle.getString("deleteFaild")+"!";
                this.mErrors.addOneError(tError);
                conn.rollback();
                conn.close();
                return false;
            }
            if (ParentNodeCode.equals("0") || NodeSign.equals("2"))
            {
            }
            else
            {
//                System.out.println("Start 处理父菜单...");
                tExeSQL = new ExeSQL(conn);
                sql =
                        "update LDMenu set ChildFlag = to_char(to_number(ChildFlag) - 1) "
                        + "Where NodeCode = '"
                        + ParentNodeCode + "'";
                if (!tExeSQL.execUpdateSQL(sql))
                {
                    CError tError = new CError();
                    tError.moduleName = "LDMenuFunBLS";
                    tError.functionName = "deleteCode";
                    tError.errorMessage = ""+bundle.getString("Dataprocessingfailed")+"!";
                    this.mErrors.addOneError(tError);
                    conn.rollback();
                    conn.close();
                    return false;
                }
                //如果在权限组中的父菜单下再无其他菜单，则在权限组中删除父菜单。
                if(!this.dealParent(ParentNodeCode,conn))
                	return false;
            }
        }
		return true;
    }

    private boolean dealParent(String nodeCode,Connection conn) throws SQLException
    {
    	if(nodeCode.equals("0"))
    		return true;
    		
    	LDMenuGrpToMenuSet ldgtmSet = new LDMenuGrpToMenuSet();
    	LDMenuGrpToMenuDB ldgtmDB = new LDMenuGrpToMenuDB(conn);
    	ldgtmDB.setNodeCode(nodeCode);
    	//查询菜单所在的菜单组
    	ldgtmSet = ldgtmDB.query();
    	//菜单没有被分在权限组中,返回不处理
    	int num = ldgtmSet.size();
    	if(num==0)
    		return true;
    	//依次查询各菜单组中是否有菜单的子菜单， 没有则删除。
    	for(int i=1;i<=num;i++)
    	{
    		LDMenuGrpToMenuSchema ldgtm = ldgtmSet.get(i);
        	ldgtmDB = new LDMenuGrpToMenuDB(conn);
        	//查询子菜单在该权限组中的记录
        	ExeSQL tExeSQL = new ExeSQL(conn);
        	String count = tExeSQL.getOneValue("select count(1) from ldmenugrptomenu where nodecode in (select b.nodecode from ldmenu b where b.nodecode<>'"+ldgtm.getNodeCode()+"' start with b.nodecode='"+ldgtm.getNodeCode()+"' connect by prior b.nodecode=parentnodecode) and menugrpcode='"+ldgtm.getMenuGrpCode()+"'");
        	//如果没有子菜单，则在该权限组中删除父菜单
        	if(count==null || count.equals("0"))
        	{
            	ldgtmDB = new LDMenuGrpToMenuDB(conn);
            	ldgtmDB.setSchema(ldgtm);
            	if (!ldgtmDB.delete())
                {
                    // @@错误处理
                    CError tError = new CError();
                    tError.moduleName = "LDMenuFunBLS";
                    tError.functionName = "deleteCode";
                    tError.errorMessage = ""+bundle.getString("deleteFaild")+"!";
                    this.mErrors.addOneError(tError);
                    conn.rollback();
                    conn.close();
                    return false;
                }
        	}
    	}
    	
    	//递归处理菜单的父菜单
    	LDMenuSet ldmSet = new LDMenuSet();
    	LDMenuDB ldmDB = new LDMenuDB(conn);
    	ldmDB.setNodeCode(nodeCode);
    	ldmSet = ldmDB.query();
    	if(ldmSet.size()>=1)
    		dealParent(ldmSet.get(1).getParentNodeCode(),conn);
    		
    	return true;
    }

	private boolean insertCode(VData mInputData)
    {
        boolean tReturn = true;
//        System.out.println("start insert...");
        Connection conn = DBConnPool.getConnection();
        if (conn == null)
        {
            // @@错误处理
//            System.out.println("#####Conn error");
            CError tError = new CError();
            tError.moduleName = "LDMenuFunBLS";
            tError.functionName = "saveData";
            tError.errorMessage = ""+bundle.getString("connFaild")+"!";
            this.mErrors.addOneError(tError);
            return false;
        }
        try
        {
            conn.setAutoCommit(false);
            LDMenuSchema tLDMenuSchema = (LDMenuSchema) mInputData.
                                         getObjectByObjectName("LDMenuSchema",
                    0);
            TransferData t = (TransferData) mInputData.getObjectByObjectName(
                    "TransferData", 0);
            String ischild = (String) t.getValueByName("ischild");
            String ischild2 = (String) t.getValueByName("ischild2");
            String Node = (String) t.getValueByName("NodeCode");
            String RunScript = (String) t.getValueByName("RunScript");

            //作为页面权限菜单插入时,RunScript必须唯一
            if (ischild2.equalsIgnoreCase("true")){
                ExeSQL tExeSQL = new ExeSQL(conn);
                String sql = "select RunScript from LDMenu ";
                sql = sql + "where NodeSign = 2 and RunScript='"+RunScript+"'";
                String isgetnull = tExeSQL.getOneValue(sql);
                if (isgetnull != null){
                    System.out.println("作为页面权限菜单插入时,RunScript(映射文件)必须唯一!");
                    return false;
                }
            }

            //取NodeCode，NodeOrder
            ExeSQL tExeSQL = new ExeSQL(conn);
            String sql = "select max(to_number(NodeCode))+1 from LDMenu";
            String MaxCode = tExeSQL.getOneValue(sql);
//            System.out.println("Maxcode::" + MaxCode);
            sql = "select NodeOrder from LDMenu where NodeCode = '"
                  + Node + "'";
            int NodeOrder = Integer.parseInt(tExeSQL.getOneValue(sql));
//            System.out.println("NodeOrder::" + NodeOrder);
            //tLDMenuSchema.setChildFlag("0");
            tLDMenuSchema.setNodeCode(MaxCode);
            //更新菜单表的NodeOrder
            if (ischild.equalsIgnoreCase("true"))
            {
                sql = "update LDMenu set NodeOrder = NodeOrder+1 "
                      + "Where NodeOrder > "
                      + NodeOrder;
                tLDMenuSchema.setNodeOrder(NodeOrder + 1);
            }
            else
            {
                sql = "update LDMenu set NodeOrder = NodeOrder+1 "
                      + "Where NodeOrder >= "
                      + NodeOrder;
                tLDMenuSchema.setNodeOrder(NodeOrder);
            }
            if (!tExeSQL.execUpdateSQL(sql))
            {
                CError tError = new CError();
                tError.moduleName = "LDMenuFunBLS";
                tError.functionName = "insertCode";
                tError.errorMessage = ""+bundle.getString("Dataprocessingfailed")+"!";
                this.mErrors.addOneError(tError);
                conn.rollback();
                conn.close();
                return false;
            }
            LDMenuDB tLDMenuDB = new LDMenuDB(conn);
            tLDMenuDB.setSchema(tLDMenuSchema);
            if (ischild.equalsIgnoreCase("true"))
            {
                //按照子菜单插入
                //tLDMenuSchema.setParentNodeCode(Node);
                if (!tLDMenuDB.insert())
                {
                    CError tError = new CError();
                    tError.moduleName = "LDMenuFunBLS";
                    tError.functionName = "insertCode";
                    tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
                    this.mErrors.addOneError(tError);
                    conn.rollback();
                    conn.close();
                    return false;
                }
                //是否为页面功能菜单2005
                if (ischild2.equalsIgnoreCase("false"))
                {
                    sql =
                            "update LDMenu set ChildFlag = to_char(to_number(ChildFlag) +1) "
                            + "Where NodeCode = '" + Node + "'";
                    if (!tExeSQL.execUpdateSQL(sql)) {
                    CError tError = new CError();
                    tError.moduleName = "LDMenuFunBLS";
                    tError.functionName = "insertCode";
                    tError.errorMessage = ""+bundle.getString("Dataprocessingfailed")+"!";
                    this.mErrors.addOneError(tError);
                    conn.rollback();
                    conn.close();
                    return false;
                  }
                }
                else
                {
                    sql =
                            "update LDMenu set NodeSign = '1' "
                            + "Where NodeCode = '" + Node + "'";
                    if (!tExeSQL.execUpdateSQL(sql)) {
                    CError tError = new CError();
                    tError.moduleName = "LDMenuFunBLS";
                    tError.functionName = "insertCode";
                    tError.errorMessage = ""+bundle.getString("Dataprocessingfailed")+"!";
                    this.mErrors.addOneError(tError);
                    conn.rollback();
                    conn.close();
                    return false;
                  }
                }
            }
            else
            {
                //按照同级菜单插入
                //tLDMenuSchema.setParentNodeCode("0");
                //tLDMenuDB.setSchema(tLDMenuSchema);
                if (!tLDMenuDB.insert())
                {
                    CError tError = new CError();
                    tError.moduleName = "LDMenuFunBLS";
                    tError.functionName = "insertCode";
                    tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
                    this.mErrors.addOneError(tError);
                    conn.rollback();
                    conn.close();
                    return false;
                }
                //是否为页面功能菜单2005
                if (ischild2.equalsIgnoreCase("false"))
                {
                    sql =
                            "update LDMenu set ChildFlag = to_char(to_number(ChildFlag) +1)" +
                            "Where NodeCode = '" +
                            tLDMenuSchema.getParentNodeCode() +
                            "'";
                    if (!tExeSQL.execUpdateSQL(sql)) {
                        CError tError = new CError();
                        tError.moduleName = "LDMenuFunBLS";
                        tError.functionName = "insertCode";
                        tError.errorMessage = ""+bundle.getString("Dataprocessingfailed")+"!";
                        this.mErrors.addOneError(tError);
                        conn.rollback();
                        conn.close();
                        return false;
                    }
                }
//                else
//                {
//                    sql =
//                            "update LDMenu set NodeSign = '1' "
//                            + "Where NodeCode = '" + Node + "'";
//                    if (!tExeSQL.execUpdateSQL(sql))
//                    {
//                    CError tError = new CError();
//                    tError.moduleName = "LDMenuFunBLS";
//                    tError.functionName = "insertCode";
//                    tError.errorMessage = "更新父菜单标志位失败!";
//                    this.mErrors.addOneError(tError);
//                    conn.rollback();
//                    conn.close();
//                    return false;
//                    }
//                }
            }
            //插入菜单分组关联表：新菜单默认仅仅分配给8080菜单组
            LDMenuGrpToMenuSchema tLDMenuGrpToMenuSchema = new
                    LDMenuGrpToMenuSchema();
            tLDMenuGrpToMenuSchema.setMenuGrpCode("8080");
            tLDMenuGrpToMenuSchema.setNodeCode(MaxCode);
            LDMenuGrpToMenuDB tLDMenuGrpToMenuDB = new LDMenuGrpToMenuDB(conn);
            tLDMenuGrpToMenuDB.setSchema(tLDMenuGrpToMenuSchema);
            if (!tLDMenuGrpToMenuDB.insert())
            {
                CError tError = new CError();
                tError.moduleName = "LDMenuFunBLS";
                tError.functionName = "insertCode";
                tError.errorMessage = ""+bundle.getString("ErrorMsg")+"!";
                this.mErrors.addOneError(tError);
                conn.rollback();
                conn.close();
                return false;
            }
            conn.commit();
            conn.close();
        }
        catch (Exception ex)
        {
            // @@错误处理
            CError tError = new CError();
            tError.moduleName = "LDMenuFunBLS";
            tError.functionName = "submitData";
            tError.errorMessage = ex.toString();
            this.mErrors.addOneError(tError);
            try
            {
                conn.rollback();
                conn.close();
            }
            catch (Exception e)
            {}
            tReturn = false;
        }
        return tReturn;
    }
}
