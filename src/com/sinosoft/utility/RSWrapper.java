package com.sinosoft.utility;

import com.sinosoft.Resource.bundle;
import java.sql.ResultSet;

import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
//import com.sinosoft.lis.vschema.LMRiskSet;

/**
 * ResultSet包裹类 完成类似4GL的游标的FETCH功能,主要用于大数据量的问题.
 * 
 * @author Yang Yalin
 * @version 1.0 
 */
public class RSWrapper {

	// @Field
	private Connection con;
	private DBOper db;
	/**
	 * flag = true: 传入Connection flag = false: 不传入Connection
	 */
	private boolean useOutterConnection = false;

	public CErrors mErrors = new CErrors(); // 错误信息

	/**
	 * 为批量操作而准备的语句和游标对象
	 */
	private ResultSet mResultSet = null;
	private Statement mStatement = null;

	private SchemaSet container = null;
	
	private SSRS containerSSRS = null;
	
	private ResultSetMetaData rsmd = null;

	// @Constructor
	public RSWrapper(Connection tConnection) {
		con = tConnection;
		useOutterConnection = true;
	}

	public RSWrapper() {
		con = null;
		useOutterConnection = false;
	}
	/**
	 * 支持SSRS查询的重载方法
	 * @param strSQL
	 * @return
	 */
	public boolean prepareData(String strSQL) {
		System.out.println("prepareData:" + strSQL);
		
		if (mResultSet != null) {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LMDutyDB";
			tError.functionName = "prepareData";
			tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
			this.mErrors.addOneError(tError);
			return false;
		}

		if (!useOutterConnection) {
			con = DBConnPool.getConnection();
		}
		try {
			mStatement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
		} catch (Exception e) {
			e.printStackTrace();
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "prepareData";
			tError.errorMessage = e.toString();
			this.mErrors.addOneError(tError);
			try {
				mResultSet.close();
			} catch (Exception ex2) {
			}
			try {
				mStatement.close();
			} catch (Exception ex3) {
			}
			if (!useOutterConnection) {
				try {
					con.close();
					con = null;
				} catch (Exception et) {
				}
			}
			return false;
		}

		System.out.println("success prepared...");
		return true;
	}
	
	/**
	 * 支持SSRS的重载方法
	 * 
	 * @return SchemaSet
	 */
	public SSRS getSSRSData() {
		if(containerSSRS != null)
			containerSSRS.Clear();

		if (null == mResultSet) {
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "getData";
			tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
			this.mErrors.addOneError(tError);
			return null;
		}
		try {
			int tCount = 0;
			
			ExeSQL es = new ExeSQL();
			rsmd = mResultSet.getMetaData();
			int n = rsmd.getColumnCount();
			containerSSRS = new SSRS(n);
			while (tCount++ < SysConst.FETCHCOUNT && mResultSet.next())
            {
                for (int j = 1; j <= n; j++)
                {
                	containerSSRS.SetText(es.getDataValue(rsmd, mResultSet, j));
                }
            }
			
			// add by sunhongyan
			// 20090316判断每次返回查询结果集条数是否小于5000条，如果小于5000条，则关闭数据库链接，否则不关闭。
			if (containerSSRS.getMaxRow() < SysConst.FETCHCOUNT) {
				close();
			}

			System.out.println("RSWrapper Actual Fetched Row:" + (tCount-1));
		} catch (Exception ex) {
			ex.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "getData";
			tError.errorMessage = ex.toString();
			this.mErrors.addOneError(tError);
			try {
				mResultSet.close();
				mResultSet = null;
			} catch (Exception ex2) {
			}
			try {
				mStatement.close();
				mStatement = null;
			} catch (Exception ex3) {
			}
			if (!useOutterConnection) {
				try {
					con.close();
					con = null;
				} catch (Exception et) {
				}
			}
			return null;
		}
		return containerSSRS;
	}
	
	/**
	 * 准备数据查询条件
	 * 
	 * @param strSQL
	 *            String
	 * @return boolean
	 */
	public boolean prepareData(SchemaSet container, String strSQL) {
		this.container = container;

		System.out.println("prepareData:" + strSQL);

		if (mResultSet != null) {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LMDutyDB";
			tError.functionName = "prepareData";
			tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
			this.mErrors.addOneError(tError);
			return false;
		}

		if (!useOutterConnection) {
			con = DBConnPool.getConnection();
		}
		try {
			mStatement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
		} catch (Exception e) {
			e.printStackTrace();
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "prepareData";
			tError.errorMessage = e.toString();
			this.mErrors.addOneError(tError);
			try {
				mResultSet.close();
			} catch (Exception ex2) {
			}
			try {
				mStatement.close();
			} catch (Exception ex3) {
			}
			if (!useOutterConnection) {
				try {
					con.close();
					con = null;
				} catch (Exception et) {
				}
			}
			return false;
		}

		System.out.println("success prepared...");
		return true;
	}

	/**
	 * 获取数据集
	 * 
	 * @return boolean
	 */
	private boolean next() {
		boolean flag = true;
		if (null == mResultSet) {
			CError tError = new CError();
			tError.moduleName = "LMDutyDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
			this.mErrors.addOneError(tError);
			return false;
		}
		try {
			flag = mResultSet.next();
		} catch (Exception ex) {
			CError tError = new CError();
			tError.moduleName = "LMDutyDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = ex.toString();
			this.mErrors.addOneError(tError);
			try {
				mResultSet.close();
				mResultSet = null;
			} catch (Exception ex2) {
			}
			try {
				mStatement.close();
				mStatement = null;
			} catch (Exception ex3) {
			}
			if (!useOutterConnection) {
				try {
					con.close();
					con = null;
				} catch (Exception et) {
				}
			}
			return false;
		}
		return flag;
	}

	/**
	 * 获取定量数据
	 * 
	 * @return SchemaSet
	 */
	public SchemaSet getData() {
		container.clear();

		if (null == mResultSet) {
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "getData";
			tError.errorMessage = ""+bundle.getString("ErrorMsg")+"";
			this.mErrors.addOneError(tError);
			return null;
		}
		try {
			int tCount = 0;
			String clzName = container.getClass().getName();
			clzName = clzName.substring(clzName.lastIndexOf(".") + 1, clzName
					.length() - 3)
					+ "Schema";

			// 注意mResultSet.next()的作用
			while (tCount++ < SysConst.FETCHCOUNT && mResultSet.next()) {
				Schema schema = (Schema) Class.forName(
						"com.sinosoft.lis.schema." + clzName).newInstance();
				schema.setSchema(mResultSet, 1);
				container.add(schema);
			}

			// add by sunhongyan
			// 20090316判断每次返回查询结果集条数是否小于5000条，如果小于5000条，则关闭数据库链接，否则不关闭。
			if (container.size() < SysConst.FETCHCOUNT) {
				close();
			}

			System.out.println("RSWrapper Actual Fetched Row:" + tCount);
		} catch (Exception ex) {
			ex.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "getData";
			tError.errorMessage = ex.toString();
			this.mErrors.addOneError(tError);
			try {
				mResultSet.close();
				mResultSet = null;
			} catch (Exception ex2) {
			}
			try {
				mStatement.close();
				mStatement = null;
			} catch (Exception ex3) {
			}
			if (!useOutterConnection) {
				try {
					con.close();
					con = null;
				} catch (Exception et) {
				}
			}
			return null;
		}
		return container;
	}

	/**
	 * 关闭数据集
	 * 
	 * @return boolean
	 */
	public boolean close() {
		boolean flag = true;
		try {
			if (null == mResultSet) {
				// 如果结果集为空，不做任何处理 edit by sunhongyan 20090318
				// CError tError = new CError();
				// tError.moduleName = "RSWrapper";
				// tError.functionName = "closeData";
				// tError.errorMessage = "数据集已经关闭了！";
				// this.mErrors.addOneError(tError);
				// flag = false;
			} else {
				mResultSet.close();
				mResultSet = null;
			}
		} catch (Exception ex2) {
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "closeData";
			tError.errorMessage = ex2.toString();
			this.mErrors.addOneError(tError);
			flag = false;
		}
		try {
			if (null == mStatement) {
				// 如果实例为空，不做任何处理 edit by sunhongyan 20090318
				// CError tError = new CError();
				// tError.moduleName = "RSWrapper";
				// tError.functionName = "closeData";
				// tError.errorMessage = "语句已经关闭了！";
				// this.mErrors.addOneError(tError);
				// flag = false;
			} else {
				mStatement.close();
				mStatement = null;
			}
		} catch (Exception ex3) {
			CError tError = new CError();
			tError.moduleName = "RSWrapper";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			this.mErrors.addOneError(tError);
			flag = false;
		}

		System.out.println("use out connection:" + useOutterConnection);

		if (!useOutterConnection) {
			try {
				// 判断数据库链接状态 add by sunhongyan 20090318
				if(con != null)
					con.close();
				con = null;
				System.out.println("inner connection closed");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return flag;
	}

//	public static void main(String[] args) {
////		RSWrapper rswrapper = new RSWrapper();
////		LMRiskSet lmRiskSet = new LMRiskSet();
////		rswrapper.prepareData(lmRiskSet, "select * from lmrisk");
////		do {
////			rswrapper.getData();
////			System.out.println("get data count:" + lmRiskSet.size());
////		} while (lmRiskSet.size() > 0);
////		rswrapper.close();
//		System.out.println("commplete");
//
//	}
}
