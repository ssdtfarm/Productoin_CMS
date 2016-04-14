/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.DailyPolicyDetailsSchema;
import com.sinosoft.lis.vschema.DailyPolicyDetailsSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: DailyPolicyDetailsDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class DailyPolicyDetailsDBSet extends DailyPolicyDetailsSet
{
	// @Field
	private Connection con;
	private DBOper db;
	/**
	* flag = true: 传入Connection
	* flag = false: 不传入Connection
	**/
	private boolean mflag = false;


	// @Constructor
	public DailyPolicyDetailsDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"DailyPolicyDetails");
		mflag = true;
	}

	public DailyPolicyDetailsDBSet()
	{
		db = new DBOper( "DailyPolicyDetails" );
		con = db.getConnection();
	}
	// @Method
	public boolean deleteSQL()
	{
		if (db.deleteSQL(this))
		{
		        return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

    /**
     * 删除操作
     * 删除条件：主键
     * @return boolean
     */
	public boolean delete()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
            int tCount = this.size();
			pstmt = con.prepareStatement("DELETE FROM DailyPolicyDetails WHERE  Company_Code = ? AND Policy_No = ? AND Batch_No = ? AND Batch_Run_Date = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCompany_Code() == null || this.get(i).getCompany_Code().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCompany_Code());
			}
			if(this.get(i).getPolicy_No() == null || this.get(i).getPolicy_No().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPolicy_No());
			}
			pstmt.setDouble(3, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(4,null);
			} else {
				pstmt.setDate(4, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPolicyDetails");
		sqlObj.setSQL(4, this.get(i));
		sqlObj.getSQL();

                pstmt.addBatch();
            }
            pstmt.executeBatch();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
ex.printStackTrace();
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDBSet";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){e.printStackTrace();}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){e.printStackTrace();}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){e.printStackTrace();}
		}

		return true;
	}

    /**
     * 更新操作
     * 更新条件：主键
     * @return boolean
     */
	public boolean update()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
            int tCount = this.size();
			pstmt = con.prepareStatement("UPDATE DailyPolicyDetails SET  Company_Code = ? , Policy_No = ? , Product_Code = ? , Product_Type = ? , Link_or_No_Link_Product = ? , AgentCode1 = ? , AgentCode2 = ? , SplitRate1 = ? , SplitRate2 = ? , Servicing_Agent_Code = ? , Risk_Status = ? , Effective_Date = ? , First_Issue_Date = ? , Reissue_Issue_Date = ? , Reinstatement_Date = ? , Policy_Owner_Customer_ID = ? , Policy_Owner_Name = ? , Owner_Security_No = ? , Policy_Insured_Name = ? , Insured_Security_No = ? , Old_Policy_No = ? , Business_Date = ? , Batch_No = ? , Batch_Run_Date = ? WHERE  Company_Code = ? AND Policy_No = ? AND Batch_No = ? AND Batch_Run_Date = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCompany_Code() == null || this.get(i).getCompany_Code().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCompany_Code());
			}
			if(this.get(i).getPolicy_No() == null || this.get(i).getPolicy_No().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPolicy_No());
			}
			if(this.get(i).getProduct_Code() == null || this.get(i).getProduct_Code().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getProduct_Code());
			}
			if(this.get(i).getProduct_Type() == null || this.get(i).getProduct_Type().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getProduct_Type());
			}
			if(this.get(i).getLink_or_No_Link_Product() == null || this.get(i).getLink_or_No_Link_Product().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getLink_or_No_Link_Product());
			}
			if(this.get(i).getAgentCode1() == null || this.get(i).getAgentCode1().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getAgentCode1());
			}
			if(this.get(i).getAgentCode2() == null || this.get(i).getAgentCode2().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getAgentCode2());
			}
			pstmt.setDouble(8, this.get(i).getSplitRate1());
			pstmt.setDouble(9, this.get(i).getSplitRate2());
			if(this.get(i).getServicing_Agent_Code() == null || this.get(i).getServicing_Agent_Code().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getServicing_Agent_Code());
			}
			if(this.get(i).getRisk_Status() == null || this.get(i).getRisk_Status().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getRisk_Status());
			}
			if(this.get(i).getEffective_Date() == null || this.get(i).getEffective_Date().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getEffective_Date()));
			}
			if(this.get(i).getFirst_Issue_Date() == null || this.get(i).getFirst_Issue_Date().equals("null")) {
				pstmt.setDate(13,null);
			} else {
				pstmt.setDate(13, Date.valueOf(this.get(i).getFirst_Issue_Date()));
			}
			if(this.get(i).getReissue_Issue_Date() == null || this.get(i).getReissue_Issue_Date().equals("null")) {
				pstmt.setDate(14,null);
			} else {
				pstmt.setDate(14, Date.valueOf(this.get(i).getReissue_Issue_Date()));
			}
			if(this.get(i).getReinstatement_Date() == null || this.get(i).getReinstatement_Date().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getReinstatement_Date()));
			}
			if(this.get(i).getPolicy_Owner_Customer_ID() == null || this.get(i).getPolicy_Owner_Customer_ID().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getPolicy_Owner_Customer_ID());
			}
			if(this.get(i).getPolicy_Owner_Name() == null || this.get(i).getPolicy_Owner_Name().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getPolicy_Owner_Name());
			}
			if(this.get(i).getOwner_Security_No() == null || this.get(i).getOwner_Security_No().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getOwner_Security_No());
			}
			if(this.get(i).getPolicy_Insured_Name() == null || this.get(i).getPolicy_Insured_Name().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getPolicy_Insured_Name());
			}
			if(this.get(i).getInsured_Security_No() == null || this.get(i).getInsured_Security_No().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getInsured_Security_No());
			}
			if(this.get(i).getOld_Policy_No() == null || this.get(i).getOld_Policy_No().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getOld_Policy_No());
			}
			if(this.get(i).getBusiness_Date() == null || this.get(i).getBusiness_Date().equals("null")) {
				pstmt.setDate(22,null);
			} else {
				pstmt.setDate(22, Date.valueOf(this.get(i).getBusiness_Date()));
			}
			pstmt.setDouble(23, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(24,null);
			} else {
				pstmt.setDate(24, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}
			// set where condition
			if(this.get(i).getCompany_Code() == null || this.get(i).getCompany_Code().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getCompany_Code());
			}
			if(this.get(i).getPolicy_No() == null || this.get(i).getPolicy_No().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getPolicy_No());
			}
			pstmt.setDouble(27, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(28,null);
			} else {
				pstmt.setDate(28, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPolicyDetails");
		sqlObj.setSQL(2, this.get(i));
		sqlObj.getSQL();

                pstmt.addBatch();
            }
            pstmt.executeBatch();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
ex.printStackTrace();
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDBSet";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){e.printStackTrace();}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){e.printStackTrace();}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){e.printStackTrace();}
		}

		return true;
	}

    /**
     * 新增操作
     * @return boolean
     */
	public boolean insert()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
            int tCount = this.size();
			pstmt = con.prepareStatement("INSERT INTO DailyPolicyDetails VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getCompany_Code() == null || this.get(i).getCompany_Code().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getCompany_Code());
			}
			if(this.get(i).getPolicy_No() == null || this.get(i).getPolicy_No().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getPolicy_No());
			}
			if(this.get(i).getProduct_Code() == null || this.get(i).getProduct_Code().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getProduct_Code());
			}
			if(this.get(i).getProduct_Type() == null || this.get(i).getProduct_Type().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getProduct_Type());
			}
			if(this.get(i).getLink_or_No_Link_Product() == null || this.get(i).getLink_or_No_Link_Product().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getLink_or_No_Link_Product());
			}
			if(this.get(i).getAgentCode1() == null || this.get(i).getAgentCode1().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getAgentCode1());
			}
			if(this.get(i).getAgentCode2() == null || this.get(i).getAgentCode2().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getAgentCode2());
			}
			pstmt.setDouble(8, this.get(i).getSplitRate1());
			pstmt.setDouble(9, this.get(i).getSplitRate2());
			if(this.get(i).getServicing_Agent_Code() == null || this.get(i).getServicing_Agent_Code().equals("null")) {
				pstmt.setString(10,null);
			} else {
				pstmt.setString(10, this.get(i).getServicing_Agent_Code());
			}
			if(this.get(i).getRisk_Status() == null || this.get(i).getRisk_Status().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getRisk_Status());
			}
			if(this.get(i).getEffective_Date() == null || this.get(i).getEffective_Date().equals("null")) {
				pstmt.setDate(12,null);
			} else {
				pstmt.setDate(12, Date.valueOf(this.get(i).getEffective_Date()));
			}
			if(this.get(i).getFirst_Issue_Date() == null || this.get(i).getFirst_Issue_Date().equals("null")) {
				pstmt.setDate(13,null);
			} else {
				pstmt.setDate(13, Date.valueOf(this.get(i).getFirst_Issue_Date()));
			}
			if(this.get(i).getReissue_Issue_Date() == null || this.get(i).getReissue_Issue_Date().equals("null")) {
				pstmt.setDate(14,null);
			} else {
				pstmt.setDate(14, Date.valueOf(this.get(i).getReissue_Issue_Date()));
			}
			if(this.get(i).getReinstatement_Date() == null || this.get(i).getReinstatement_Date().equals("null")) {
				pstmt.setDate(15,null);
			} else {
				pstmt.setDate(15, Date.valueOf(this.get(i).getReinstatement_Date()));
			}
			if(this.get(i).getPolicy_Owner_Customer_ID() == null || this.get(i).getPolicy_Owner_Customer_ID().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getPolicy_Owner_Customer_ID());
			}
			if(this.get(i).getPolicy_Owner_Name() == null || this.get(i).getPolicy_Owner_Name().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getPolicy_Owner_Name());
			}
			if(this.get(i).getOwner_Security_No() == null || this.get(i).getOwner_Security_No().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getOwner_Security_No());
			}
			if(this.get(i).getPolicy_Insured_Name() == null || this.get(i).getPolicy_Insured_Name().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getPolicy_Insured_Name());
			}
			if(this.get(i).getInsured_Security_No() == null || this.get(i).getInsured_Security_No().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getInsured_Security_No());
			}
			if(this.get(i).getOld_Policy_No() == null || this.get(i).getOld_Policy_No().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getOld_Policy_No());
			}
			if(this.get(i).getBusiness_Date() == null || this.get(i).getBusiness_Date().equals("null")) {
				pstmt.setDate(22,null);
			} else {
				pstmt.setDate(22, Date.valueOf(this.get(i).getBusiness_Date()));
			}
			pstmt.setDouble(23, this.get(i).getBatch_No());
			if(this.get(i).getBatch_Run_Date() == null || this.get(i).getBatch_Run_Date().equals("null")) {
				pstmt.setDate(24,null);
			} else {
				pstmt.setDate(24, Date.valueOf(this.get(i).getBatch_Run_Date()));
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("DailyPolicyDetails");
		sqlObj.setSQL(1, this.get(i));
		sqlObj.getSQL();

                pstmt.addBatch();
            }
            pstmt.executeBatch();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
ex.printStackTrace();
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "DailyPolicyDetailsDBSet";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){e.printStackTrace();}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){e.printStackTrace();}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){e.printStackTrace();}
		}

		return true;
	}

}
