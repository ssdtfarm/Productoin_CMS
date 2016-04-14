/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vdb;

import java.sql.*;
import com.sinosoft.lis.schema.LAIndexInfoVSchema;
import com.sinosoft.lis.vschema.LAIndexInfoVSet;
import com.sinosoft.lis.pubfun.*;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAIndexInfoVDBSet </p>
 * <p>Description: DB层多记录数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: PhysicalDataModel_1
 */
public class LAIndexInfoVDBSet extends LAIndexInfoVSet
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
	public LAIndexInfoVDBSet(Connection tConnection)
	{
		con = tConnection;
		db = new DBOper(con,"LAIndexInfoV");
		mflag = true;
	}

	public LAIndexInfoVDBSet()
	{
		db = new DBOper( "LAIndexInfoV" );
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
			tError.moduleName = "LAIndexInfoVDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LAIndexInfoV WHERE  WageNo = ? AND IndexType = ? AND AgentCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getWageNo() == null || this.get(i).getWageNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getWageNo());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getIndexType());
			}
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getAgentCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAIndexInfoV");
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
			tError.moduleName = "LAIndexInfoVDBSet";
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
			pstmt = con.prepareStatement("UPDATE LAIndexInfoV SET  WageNo = ? , BranchType = ? , IndexType = ? , AgentCode = ? , AgentGrade = ? , AgentGroup = ? , State = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , I000000001 = ? , I000000002 = ? , I000000003 = ? , I000000004 = ? , I000000005 = ? , I000000006 = ? , I000000007 = ? , I000000008 = ? , I000000009 = ? , I000000010 = ? , I000000011 = ? , I000000012 = ? , I000000013 = ? , I000000014 = ? , I000000015 = ? , I000000016 = ? , I000000017 = ? , I000000018 = ? , I000000019 = ? , I000000020 = ? , I000000021 = ? , I000000022 = ? , I000000023 = ? , I000000024 = ? , I000000025 = ? , I000000026 = ? , I000000027 = ? , I000000028 = ? , I000000029 = ? , I000000030 = ? , I000000031 = ? , I000000032 = ? , I000000033 = ? , I000000034 = ? , I000000035 = ? , I000000036 = ? , I000000037 = ? , I000000038 = ? , I000000039 = ? , I000000040 = ? , I000000041 = ? , I000000042 = ? , I000000043 = ? , I000000044 = ? , I000000045 = ? , I000000046 = ? , I000000047 = ? , I000000048 = ? , I000000049 = ? , I000000050 = ? , I000000051 = ? , I000000052 = ? , I000000053 = ? , I000000054 = ? , I000000055 = ? , I000000056 = ? , I000000057 = ? , I000000058 = ? , I000000059 = ? , I000000060 = ? , I000000061 = ? , I000000062 = ? , I000000063 = ? , I000000064 = ? , I000000065 = ? , I000000066 = ? , I000000067 = ? , I000000068 = ? , I000000069 = ? , I000000070 = ? , I000000071 = ? , I000000072 = ? , I000000073 = ? , I000000074 = ? , I000000075 = ? , I000000076 = ? , I000000077 = ? , I000000078 = ? , I000000079 = ? , I000000080 = ? , I000000081 = ? , I000000082 = ? , I000000083 = ? , I000000084 = ? , I000000085 = ? , I000000086 = ? , I000000087 = ? , I000000088 = ? , I000000089 = ? , I000000090 = ? , I000000091 = ? , I000000092 = ? , I000000093 = ? , I000000094 = ? , I000000095 = ? , I000000096 = ? , I000000097 = ? , I000000098 = ? , I000000099 = ? , I000000100 = ? , I000000101 = ? , I000000102 = ? , I000000103 = ? , I000000104 = ? , I000000105 = ? , I000000106 = ? , I000000107 = ? , I000000108 = ? , I000000109 = ? , I000000110 = ? , I000000111 = ? , I000000112 = ? , I000000113 = ? , I000000114 = ? , I000000115 = ? , I000000116 = ? , I000000117 = ? , I000000118 = ? , I000000119 = ? , I000000120 = ? , I000000121 = ? , I000000122 = ? , I000000123 = ? , I000000124 = ? , I000000125 = ? , I000000126 = ? , I000000127 = ? , I000000128 = ? , I000000129 = ? , I000000130 = ? , I000000131 = ? , I000000132 = ? , I000000133 = ? , I000000134 = ? , I000000135 = ? , I000000136 = ? , I000000137 = ? , I000000138 = ? , I000000139 = ? , I000000140 = ? , I000000141 = ? , I000000142 = ? , I000000143 = ? , I000000144 = ? , I000000145 = ? , I000000146 = ? , I000000147 = ? , I000000148 = ? , I000000149 = ? , I000000150 = ? , I000000151 = ? , I000000152 = ? , I000000153 = ? , I000000154 = ? , I000000155 = ? , I000000156 = ? , I000000157 = ? , I000000158 = ? , I000000159 = ? , I000000160 = ? , I000000161 = ? , I000000162 = ? , I000000163 = ? , I000000164 = ? , I000000165 = ? , I000000166 = ? , I000000167 = ? , I000000168 = ? , I000000169 = ? , I000000170 = ? , I000000171 = ? , I000000172 = ? , I000000173 = ? , I000000174 = ? , I000000175 = ? , I000000176 = ? , I000000177 = ? , I000000178 = ? , I000000179 = ? , I000000180 = ? , I000000181 = ? , I000000182 = ? , I000000183 = ? , I000000184 = ? , I000000185 = ? , I000000186 = ? , I000000187 = ? , I000000188 = ? , I000000189 = ? , I000000190 = ? , I000000191 = ? , I000000192 = ? , I000000193 = ? , I000000194 = ? , I000000195 = ? , I000000196 = ? , I000000197 = ? , I000000198 = ? , I000000199 = ? , I000000200 = ? , R000000001 = ? , R000000002 = ? , R000000003 = ? , R000000004 = ? , R000000005 = ? , R000000006 = ? , R000000007 = ? , R000000008 = ? , R000000009 = ? , R000000010 = ? , R000000011 = ? , R000000012 = ? , R000000013 = ? , R000000014 = ? , R000000015 = ? , R000000016 = ? , R000000017 = ? , R000000018 = ? , R000000019 = ? , R000000020 = ? , R000000021 = ? , R000000022 = ? , R000000023 = ? , R000000024 = ? , R000000025 = ? , R000000026 = ? , R000000027 = ? , R000000028 = ? , R000000029 = ? , R000000030 = ? , R000000031 = ? , R000000032 = ? , R000000033 = ? , R000000034 = ? , R000000035 = ? , R000000036 = ? , R000000037 = ? , R000000038 = ? , R000000039 = ? , R000000040 = ? , R000000041 = ? , R000000042 = ? , R000000043 = ? , R000000044 = ? , R000000045 = ? , R000000046 = ? , R000000047 = ? , R000000048 = ? , R000000049 = ? , R000000050 = ? , R000000051 = ? , R000000052 = ? , R000000053 = ? , R000000054 = ? , R000000055 = ? , R000000056 = ? , R000000057 = ? , R000000058 = ? , R000000059 = ? , R000000060 = ? , R000000061 = ? , R000000062 = ? , R000000063 = ? , R000000064 = ? , R000000065 = ? , R000000066 = ? , R000000067 = ? , R000000068 = ? , R000000069 = ? , R000000070 = ? , R000000071 = ? , R000000072 = ? , R000000073 = ? , R000000074 = ? , R000000075 = ? , R000000076 = ? , R000000077 = ? , R000000078 = ? , R000000079 = ? , R000000080 = ? , R000000081 = ? , R000000082 = ? , R000000083 = ? , R000000084 = ? , R000000085 = ? , R000000086 = ? , R000000087 = ? , R000000088 = ? , R000000089 = ? , R000000090 = ? , R000000091 = ? , R000000092 = ? , R000000093 = ? , R000000094 = ? , R000000095 = ? , R000000096 = ? , R000000097 = ? , R000000098 = ? , R000000099 = ? , R000000100 = ? , R000000101 = ? , R000000102 = ? , R000000103 = ? , R000000104 = ? , R000000105 = ? , R000000106 = ? , R000000107 = ? , R000000108 = ? , R000000109 = ? , R000000110 = ? , R000000111 = ? , R000000112 = ? , R000000113 = ? , R000000114 = ? , R000000115 = ? , R000000116 = ? , R000000117 = ? , R000000118 = ? , R000000119 = ? , R000000120 = ? , R000000121 = ? , R000000122 = ? , R000000123 = ? , R000000124 = ? , R000000125 = ? , R000000126 = ? , R000000127 = ? , R000000128 = ? , R000000129 = ? , R000000130 = ? , R000000131 = ? , R000000132 = ? , R000000133 = ? , R000000134 = ? , R000000135 = ? , R000000136 = ? , R000000137 = ? , R000000138 = ? , R000000139 = ? , R000000140 = ? , R000000141 = ? , R000000142 = ? , R000000143 = ? , R000000144 = ? , R000000145 = ? , R000000146 = ? , R000000147 = ? , R000000148 = ? , R000000149 = ? , R000000150 = ? , R000000151 = ? , R000000152 = ? , R000000153 = ? , R000000154 = ? , R000000155 = ? , R000000156 = ? , R000000157 = ? , R000000158 = ? , R000000159 = ? , R000000160 = ? , R000000161 = ? , R000000162 = ? , R000000163 = ? , R000000164 = ? , R000000165 = ? , R000000166 = ? , R000000167 = ? , R000000168 = ? , R000000169 = ? , R000000170 = ? , R000000171 = ? , R000000172 = ? , R000000173 = ? , R000000174 = ? , R000000175 = ? , R000000176 = ? , R000000177 = ? , R000000178 = ? , R000000179 = ? , R000000180 = ? , R000000181 = ? , R000000182 = ? , R000000183 = ? , R000000184 = ? , R000000185 = ? , R000000186 = ? , R000000187 = ? , R000000188 = ? , R000000189 = ? , R000000190 = ? , R000000191 = ? , R000000192 = ? , R000000193 = ? , R000000194 = ? , R000000195 = ? , R000000196 = ? , R000000197 = ? , R000000198 = ? , R000000199 = ? , R000000200 = ? , I000000201 = ? , I000000202 = ? , I000000203 = ? , I000000209 = ? , I000000210 = ? , I000000213 = ? , I000000214 = ? , I000000215 = ? , I000000216 = ? , I000000217 = ? , I000000218 = ? , I000000219 = ? , I000000220 = ? , I000000221 = ? , I000000222 = ? , I000000224 = ? , I000000225 = ? , I000000226 = ? , I000000227 = ? , I000000228 = ? , I000000229 = ? , I000000231 = ? , I000000232 = ? , I000000233 = ? , I000000234 = ? , I000000235 = ? , I000000236 = ? , I000000237 = ? , I000000240 = ? , I000000241 = ? , I000000242 = ? , I000000243 = ? , I000000244 = ? , I000000245 = ? , I000000246 = ? , I000000247 = ? , I000000248 = ? , I000000249 = ? , I000000250 = ? , I000000251 = ? , R000000201 = ? , R000000202 = ? , R000000203 = ? , R000000204 = ? , R000000205 = ? , I000000254 = ? WHERE  WageNo = ? AND IndexType = ? AND AgentCode = ?");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getWageNo() == null || this.get(i).getWageNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getWageNo());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getBranchType());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getIndexType());
			}
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getAgentCode());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getAgentGrade());
			}
			if(this.get(i).getAgentGroup() == null || this.get(i).getAgentGroup().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getAgentGroup());
			}
			if(this.get(i).getState() == null || this.get(i).getState().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getState());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getModifyTime());
			}
			if(this.get(i).getI000000001() == null || this.get(i).getI000000001().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getI000000001());
			}
			if(this.get(i).getI000000002() == null || this.get(i).getI000000002().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getI000000002());
			}
			if(this.get(i).getI000000003() == null || this.get(i).getI000000003().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getI000000003());
			}
			if(this.get(i).getI000000004() == null || this.get(i).getI000000004().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getI000000004());
			}
			if(this.get(i).getI000000005() == null || this.get(i).getI000000005().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getI000000005());
			}
			if(this.get(i).getI000000006() == null || this.get(i).getI000000006().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getI000000006());
			}
			if(this.get(i).getI000000007() == null || this.get(i).getI000000007().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getI000000007());
			}
			if(this.get(i).getI000000008() == null || this.get(i).getI000000008().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getI000000008());
			}
			if(this.get(i).getI000000009() == null || this.get(i).getI000000009().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getI000000009());
			}
			if(this.get(i).getI000000010() == null || this.get(i).getI000000010().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getI000000010());
			}
			if(this.get(i).getI000000011() == null || this.get(i).getI000000011().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getI000000011());
			}
			if(this.get(i).getI000000012() == null || this.get(i).getI000000012().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getI000000012());
			}
			if(this.get(i).getI000000013() == null || this.get(i).getI000000013().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getI000000013());
			}
			if(this.get(i).getI000000014() == null || this.get(i).getI000000014().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getI000000014());
			}
			if(this.get(i).getI000000015() == null || this.get(i).getI000000015().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getI000000015());
			}
			if(this.get(i).getI000000016() == null || this.get(i).getI000000016().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getI000000016());
			}
			if(this.get(i).getI000000017() == null || this.get(i).getI000000017().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getI000000017());
			}
			if(this.get(i).getI000000018() == null || this.get(i).getI000000018().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getI000000018());
			}
			if(this.get(i).getI000000019() == null || this.get(i).getI000000019().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getI000000019());
			}
			if(this.get(i).getI000000020() == null || this.get(i).getI000000020().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getI000000020());
			}
			if(this.get(i).getI000000021() == null || this.get(i).getI000000021().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getI000000021());
			}
			if(this.get(i).getI000000022() == null || this.get(i).getI000000022().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getI000000022());
			}
			if(this.get(i).getI000000023() == null || this.get(i).getI000000023().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getI000000023());
			}
			if(this.get(i).getI000000024() == null || this.get(i).getI000000024().equals("null")) {
				pstmt.setString(35,null);
			} else {
				pstmt.setString(35, this.get(i).getI000000024());
			}
			if(this.get(i).getI000000025() == null || this.get(i).getI000000025().equals("null")) {
				pstmt.setString(36,null);
			} else {
				pstmt.setString(36, this.get(i).getI000000025());
			}
			if(this.get(i).getI000000026() == null || this.get(i).getI000000026().equals("null")) {
				pstmt.setString(37,null);
			} else {
				pstmt.setString(37, this.get(i).getI000000026());
			}
			if(this.get(i).getI000000027() == null || this.get(i).getI000000027().equals("null")) {
				pstmt.setString(38,null);
			} else {
				pstmt.setString(38, this.get(i).getI000000027());
			}
			if(this.get(i).getI000000028() == null || this.get(i).getI000000028().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getI000000028());
			}
			if(this.get(i).getI000000029() == null || this.get(i).getI000000029().equals("null")) {
				pstmt.setString(40,null);
			} else {
				pstmt.setString(40, this.get(i).getI000000029());
			}
			if(this.get(i).getI000000030() == null || this.get(i).getI000000030().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getI000000030());
			}
			if(this.get(i).getI000000031() == null || this.get(i).getI000000031().equals("null")) {
				pstmt.setString(42,null);
			} else {
				pstmt.setString(42, this.get(i).getI000000031());
			}
			if(this.get(i).getI000000032() == null || this.get(i).getI000000032().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getI000000032());
			}
			if(this.get(i).getI000000033() == null || this.get(i).getI000000033().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getI000000033());
			}
			if(this.get(i).getI000000034() == null || this.get(i).getI000000034().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getI000000034());
			}
			if(this.get(i).getI000000035() == null || this.get(i).getI000000035().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getI000000035());
			}
			if(this.get(i).getI000000036() == null || this.get(i).getI000000036().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getI000000036());
			}
			if(this.get(i).getI000000037() == null || this.get(i).getI000000037().equals("null")) {
				pstmt.setString(48,null);
			} else {
				pstmt.setString(48, this.get(i).getI000000037());
			}
			if(this.get(i).getI000000038() == null || this.get(i).getI000000038().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getI000000038());
			}
			if(this.get(i).getI000000039() == null || this.get(i).getI000000039().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getI000000039());
			}
			if(this.get(i).getI000000040() == null || this.get(i).getI000000040().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getI000000040());
			}
			if(this.get(i).getI000000041() == null || this.get(i).getI000000041().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getI000000041());
			}
			if(this.get(i).getI000000042() == null || this.get(i).getI000000042().equals("null")) {
				pstmt.setString(53,null);
			} else {
				pstmt.setString(53, this.get(i).getI000000042());
			}
			if(this.get(i).getI000000043() == null || this.get(i).getI000000043().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getI000000043());
			}
			if(this.get(i).getI000000044() == null || this.get(i).getI000000044().equals("null")) {
				pstmt.setString(55,null);
			} else {
				pstmt.setString(55, this.get(i).getI000000044());
			}
			if(this.get(i).getI000000045() == null || this.get(i).getI000000045().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getI000000045());
			}
			if(this.get(i).getI000000046() == null || this.get(i).getI000000046().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getI000000046());
			}
			if(this.get(i).getI000000047() == null || this.get(i).getI000000047().equals("null")) {
				pstmt.setString(58,null);
			} else {
				pstmt.setString(58, this.get(i).getI000000047());
			}
			if(this.get(i).getI000000048() == null || this.get(i).getI000000048().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getI000000048());
			}
			if(this.get(i).getI000000049() == null || this.get(i).getI000000049().equals("null")) {
				pstmt.setString(60,null);
			} else {
				pstmt.setString(60, this.get(i).getI000000049());
			}
			if(this.get(i).getI000000050() == null || this.get(i).getI000000050().equals("null")) {
				pstmt.setString(61,null);
			} else {
				pstmt.setString(61, this.get(i).getI000000050());
			}
			if(this.get(i).getI000000051() == null || this.get(i).getI000000051().equals("null")) {
				pstmt.setString(62,null);
			} else {
				pstmt.setString(62, this.get(i).getI000000051());
			}
			if(this.get(i).getI000000052() == null || this.get(i).getI000000052().equals("null")) {
				pstmt.setString(63,null);
			} else {
				pstmt.setString(63, this.get(i).getI000000052());
			}
			if(this.get(i).getI000000053() == null || this.get(i).getI000000053().equals("null")) {
				pstmt.setString(64,null);
			} else {
				pstmt.setString(64, this.get(i).getI000000053());
			}
			if(this.get(i).getI000000054() == null || this.get(i).getI000000054().equals("null")) {
				pstmt.setString(65,null);
			} else {
				pstmt.setString(65, this.get(i).getI000000054());
			}
			if(this.get(i).getI000000055() == null || this.get(i).getI000000055().equals("null")) {
				pstmt.setString(66,null);
			} else {
				pstmt.setString(66, this.get(i).getI000000055());
			}
			if(this.get(i).getI000000056() == null || this.get(i).getI000000056().equals("null")) {
				pstmt.setString(67,null);
			} else {
				pstmt.setString(67, this.get(i).getI000000056());
			}
			if(this.get(i).getI000000057() == null || this.get(i).getI000000057().equals("null")) {
				pstmt.setString(68,null);
			} else {
				pstmt.setString(68, this.get(i).getI000000057());
			}
			if(this.get(i).getI000000058() == null || this.get(i).getI000000058().equals("null")) {
				pstmt.setString(69,null);
			} else {
				pstmt.setString(69, this.get(i).getI000000058());
			}
			if(this.get(i).getI000000059() == null || this.get(i).getI000000059().equals("null")) {
				pstmt.setString(70,null);
			} else {
				pstmt.setString(70, this.get(i).getI000000059());
			}
			if(this.get(i).getI000000060() == null || this.get(i).getI000000060().equals("null")) {
				pstmt.setString(71,null);
			} else {
				pstmt.setString(71, this.get(i).getI000000060());
			}
			if(this.get(i).getI000000061() == null || this.get(i).getI000000061().equals("null")) {
				pstmt.setString(72,null);
			} else {
				pstmt.setString(72, this.get(i).getI000000061());
			}
			if(this.get(i).getI000000062() == null || this.get(i).getI000000062().equals("null")) {
				pstmt.setString(73,null);
			} else {
				pstmt.setString(73, this.get(i).getI000000062());
			}
			if(this.get(i).getI000000063() == null || this.get(i).getI000000063().equals("null")) {
				pstmt.setString(74,null);
			} else {
				pstmt.setString(74, this.get(i).getI000000063());
			}
			if(this.get(i).getI000000064() == null || this.get(i).getI000000064().equals("null")) {
				pstmt.setString(75,null);
			} else {
				pstmt.setString(75, this.get(i).getI000000064());
			}
			if(this.get(i).getI000000065() == null || this.get(i).getI000000065().equals("null")) {
				pstmt.setString(76,null);
			} else {
				pstmt.setString(76, this.get(i).getI000000065());
			}
			if(this.get(i).getI000000066() == null || this.get(i).getI000000066().equals("null")) {
				pstmt.setString(77,null);
			} else {
				pstmt.setString(77, this.get(i).getI000000066());
			}
			if(this.get(i).getI000000067() == null || this.get(i).getI000000067().equals("null")) {
				pstmt.setString(78,null);
			} else {
				pstmt.setString(78, this.get(i).getI000000067());
			}
			if(this.get(i).getI000000068() == null || this.get(i).getI000000068().equals("null")) {
				pstmt.setString(79,null);
			} else {
				pstmt.setString(79, this.get(i).getI000000068());
			}
			if(this.get(i).getI000000069() == null || this.get(i).getI000000069().equals("null")) {
				pstmt.setString(80,null);
			} else {
				pstmt.setString(80, this.get(i).getI000000069());
			}
			if(this.get(i).getI000000070() == null || this.get(i).getI000000070().equals("null")) {
				pstmt.setString(81,null);
			} else {
				pstmt.setString(81, this.get(i).getI000000070());
			}
			if(this.get(i).getI000000071() == null || this.get(i).getI000000071().equals("null")) {
				pstmt.setString(82,null);
			} else {
				pstmt.setString(82, this.get(i).getI000000071());
			}
			if(this.get(i).getI000000072() == null || this.get(i).getI000000072().equals("null")) {
				pstmt.setString(83,null);
			} else {
				pstmt.setString(83, this.get(i).getI000000072());
			}
			if(this.get(i).getI000000073() == null || this.get(i).getI000000073().equals("null")) {
				pstmt.setString(84,null);
			} else {
				pstmt.setString(84, this.get(i).getI000000073());
			}
			if(this.get(i).getI000000074() == null || this.get(i).getI000000074().equals("null")) {
				pstmt.setString(85,null);
			} else {
				pstmt.setString(85, this.get(i).getI000000074());
			}
			if(this.get(i).getI000000075() == null || this.get(i).getI000000075().equals("null")) {
				pstmt.setString(86,null);
			} else {
				pstmt.setString(86, this.get(i).getI000000075());
			}
			if(this.get(i).getI000000076() == null || this.get(i).getI000000076().equals("null")) {
				pstmt.setString(87,null);
			} else {
				pstmt.setString(87, this.get(i).getI000000076());
			}
			if(this.get(i).getI000000077() == null || this.get(i).getI000000077().equals("null")) {
				pstmt.setString(88,null);
			} else {
				pstmt.setString(88, this.get(i).getI000000077());
			}
			if(this.get(i).getI000000078() == null || this.get(i).getI000000078().equals("null")) {
				pstmt.setString(89,null);
			} else {
				pstmt.setString(89, this.get(i).getI000000078());
			}
			if(this.get(i).getI000000079() == null || this.get(i).getI000000079().equals("null")) {
				pstmt.setString(90,null);
			} else {
				pstmt.setString(90, this.get(i).getI000000079());
			}
			if(this.get(i).getI000000080() == null || this.get(i).getI000000080().equals("null")) {
				pstmt.setString(91,null);
			} else {
				pstmt.setString(91, this.get(i).getI000000080());
			}
			if(this.get(i).getI000000081() == null || this.get(i).getI000000081().equals("null")) {
				pstmt.setString(92,null);
			} else {
				pstmt.setString(92, this.get(i).getI000000081());
			}
			if(this.get(i).getI000000082() == null || this.get(i).getI000000082().equals("null")) {
				pstmt.setString(93,null);
			} else {
				pstmt.setString(93, this.get(i).getI000000082());
			}
			if(this.get(i).getI000000083() == null || this.get(i).getI000000083().equals("null")) {
				pstmt.setString(94,null);
			} else {
				pstmt.setString(94, this.get(i).getI000000083());
			}
			if(this.get(i).getI000000084() == null || this.get(i).getI000000084().equals("null")) {
				pstmt.setString(95,null);
			} else {
				pstmt.setString(95, this.get(i).getI000000084());
			}
			if(this.get(i).getI000000085() == null || this.get(i).getI000000085().equals("null")) {
				pstmt.setString(96,null);
			} else {
				pstmt.setString(96, this.get(i).getI000000085());
			}
			if(this.get(i).getI000000086() == null || this.get(i).getI000000086().equals("null")) {
				pstmt.setString(97,null);
			} else {
				pstmt.setString(97, this.get(i).getI000000086());
			}
			if(this.get(i).getI000000087() == null || this.get(i).getI000000087().equals("null")) {
				pstmt.setString(98,null);
			} else {
				pstmt.setString(98, this.get(i).getI000000087());
			}
			if(this.get(i).getI000000088() == null || this.get(i).getI000000088().equals("null")) {
				pstmt.setString(99,null);
			} else {
				pstmt.setString(99, this.get(i).getI000000088());
			}
			if(this.get(i).getI000000089() == null || this.get(i).getI000000089().equals("null")) {
				pstmt.setString(100,null);
			} else {
				pstmt.setString(100, this.get(i).getI000000089());
			}
			if(this.get(i).getI000000090() == null || this.get(i).getI000000090().equals("null")) {
				pstmt.setString(101,null);
			} else {
				pstmt.setString(101, this.get(i).getI000000090());
			}
			if(this.get(i).getI000000091() == null || this.get(i).getI000000091().equals("null")) {
				pstmt.setString(102,null);
			} else {
				pstmt.setString(102, this.get(i).getI000000091());
			}
			if(this.get(i).getI000000092() == null || this.get(i).getI000000092().equals("null")) {
				pstmt.setString(103,null);
			} else {
				pstmt.setString(103, this.get(i).getI000000092());
			}
			if(this.get(i).getI000000093() == null || this.get(i).getI000000093().equals("null")) {
				pstmt.setString(104,null);
			} else {
				pstmt.setString(104, this.get(i).getI000000093());
			}
			if(this.get(i).getI000000094() == null || this.get(i).getI000000094().equals("null")) {
				pstmt.setString(105,null);
			} else {
				pstmt.setString(105, this.get(i).getI000000094());
			}
			if(this.get(i).getI000000095() == null || this.get(i).getI000000095().equals("null")) {
				pstmt.setString(106,null);
			} else {
				pstmt.setString(106, this.get(i).getI000000095());
			}
			if(this.get(i).getI000000096() == null || this.get(i).getI000000096().equals("null")) {
				pstmt.setString(107,null);
			} else {
				pstmt.setString(107, this.get(i).getI000000096());
			}
			if(this.get(i).getI000000097() == null || this.get(i).getI000000097().equals("null")) {
				pstmt.setString(108,null);
			} else {
				pstmt.setString(108, this.get(i).getI000000097());
			}
			if(this.get(i).getI000000098() == null || this.get(i).getI000000098().equals("null")) {
				pstmt.setString(109,null);
			} else {
				pstmt.setString(109, this.get(i).getI000000098());
			}
			if(this.get(i).getI000000099() == null || this.get(i).getI000000099().equals("null")) {
				pstmt.setString(110,null);
			} else {
				pstmt.setString(110, this.get(i).getI000000099());
			}
			if(this.get(i).getI000000100() == null || this.get(i).getI000000100().equals("null")) {
				pstmt.setString(111,null);
			} else {
				pstmt.setString(111, this.get(i).getI000000100());
			}
			if(this.get(i).getI000000101() == null || this.get(i).getI000000101().equals("null")) {
				pstmt.setString(112,null);
			} else {
				pstmt.setString(112, this.get(i).getI000000101());
			}
			if(this.get(i).getI000000102() == null || this.get(i).getI000000102().equals("null")) {
				pstmt.setString(113,null);
			} else {
				pstmt.setString(113, this.get(i).getI000000102());
			}
			if(this.get(i).getI000000103() == null || this.get(i).getI000000103().equals("null")) {
				pstmt.setString(114,null);
			} else {
				pstmt.setString(114, this.get(i).getI000000103());
			}
			if(this.get(i).getI000000104() == null || this.get(i).getI000000104().equals("null")) {
				pstmt.setString(115,null);
			} else {
				pstmt.setString(115, this.get(i).getI000000104());
			}
			if(this.get(i).getI000000105() == null || this.get(i).getI000000105().equals("null")) {
				pstmt.setString(116,null);
			} else {
				pstmt.setString(116, this.get(i).getI000000105());
			}
			if(this.get(i).getI000000106() == null || this.get(i).getI000000106().equals("null")) {
				pstmt.setString(117,null);
			} else {
				pstmt.setString(117, this.get(i).getI000000106());
			}
			if(this.get(i).getI000000107() == null || this.get(i).getI000000107().equals("null")) {
				pstmt.setString(118,null);
			} else {
				pstmt.setString(118, this.get(i).getI000000107());
			}
			if(this.get(i).getI000000108() == null || this.get(i).getI000000108().equals("null")) {
				pstmt.setString(119,null);
			} else {
				pstmt.setString(119, this.get(i).getI000000108());
			}
			if(this.get(i).getI000000109() == null || this.get(i).getI000000109().equals("null")) {
				pstmt.setString(120,null);
			} else {
				pstmt.setString(120, this.get(i).getI000000109());
			}
			if(this.get(i).getI000000110() == null || this.get(i).getI000000110().equals("null")) {
				pstmt.setString(121,null);
			} else {
				pstmt.setString(121, this.get(i).getI000000110());
			}
			if(this.get(i).getI000000111() == null || this.get(i).getI000000111().equals("null")) {
				pstmt.setString(122,null);
			} else {
				pstmt.setString(122, this.get(i).getI000000111());
			}
			if(this.get(i).getI000000112() == null || this.get(i).getI000000112().equals("null")) {
				pstmt.setString(123,null);
			} else {
				pstmt.setString(123, this.get(i).getI000000112());
			}
			if(this.get(i).getI000000113() == null || this.get(i).getI000000113().equals("null")) {
				pstmt.setString(124,null);
			} else {
				pstmt.setString(124, this.get(i).getI000000113());
			}
			if(this.get(i).getI000000114() == null || this.get(i).getI000000114().equals("null")) {
				pstmt.setString(125,null);
			} else {
				pstmt.setString(125, this.get(i).getI000000114());
			}
			if(this.get(i).getI000000115() == null || this.get(i).getI000000115().equals("null")) {
				pstmt.setString(126,null);
			} else {
				pstmt.setString(126, this.get(i).getI000000115());
			}
			if(this.get(i).getI000000116() == null || this.get(i).getI000000116().equals("null")) {
				pstmt.setString(127,null);
			} else {
				pstmt.setString(127, this.get(i).getI000000116());
			}
			if(this.get(i).getI000000117() == null || this.get(i).getI000000117().equals("null")) {
				pstmt.setString(128,null);
			} else {
				pstmt.setString(128, this.get(i).getI000000117());
			}
			if(this.get(i).getI000000118() == null || this.get(i).getI000000118().equals("null")) {
				pstmt.setString(129,null);
			} else {
				pstmt.setString(129, this.get(i).getI000000118());
			}
			if(this.get(i).getI000000119() == null || this.get(i).getI000000119().equals("null")) {
				pstmt.setString(130,null);
			} else {
				pstmt.setString(130, this.get(i).getI000000119());
			}
			if(this.get(i).getI000000120() == null || this.get(i).getI000000120().equals("null")) {
				pstmt.setString(131,null);
			} else {
				pstmt.setString(131, this.get(i).getI000000120());
			}
			if(this.get(i).getI000000121() == null || this.get(i).getI000000121().equals("null")) {
				pstmt.setString(132,null);
			} else {
				pstmt.setString(132, this.get(i).getI000000121());
			}
			if(this.get(i).getI000000122() == null || this.get(i).getI000000122().equals("null")) {
				pstmt.setString(133,null);
			} else {
				pstmt.setString(133, this.get(i).getI000000122());
			}
			if(this.get(i).getI000000123() == null || this.get(i).getI000000123().equals("null")) {
				pstmt.setString(134,null);
			} else {
				pstmt.setString(134, this.get(i).getI000000123());
			}
			if(this.get(i).getI000000124() == null || this.get(i).getI000000124().equals("null")) {
				pstmt.setString(135,null);
			} else {
				pstmt.setString(135, this.get(i).getI000000124());
			}
			if(this.get(i).getI000000125() == null || this.get(i).getI000000125().equals("null")) {
				pstmt.setString(136,null);
			} else {
				pstmt.setString(136, this.get(i).getI000000125());
			}
			if(this.get(i).getI000000126() == null || this.get(i).getI000000126().equals("null")) {
				pstmt.setString(137,null);
			} else {
				pstmt.setString(137, this.get(i).getI000000126());
			}
			if(this.get(i).getI000000127() == null || this.get(i).getI000000127().equals("null")) {
				pstmt.setString(138,null);
			} else {
				pstmt.setString(138, this.get(i).getI000000127());
			}
			if(this.get(i).getI000000128() == null || this.get(i).getI000000128().equals("null")) {
				pstmt.setString(139,null);
			} else {
				pstmt.setString(139, this.get(i).getI000000128());
			}
			if(this.get(i).getI000000129() == null || this.get(i).getI000000129().equals("null")) {
				pstmt.setString(140,null);
			} else {
				pstmt.setString(140, this.get(i).getI000000129());
			}
			if(this.get(i).getI000000130() == null || this.get(i).getI000000130().equals("null")) {
				pstmt.setString(141,null);
			} else {
				pstmt.setString(141, this.get(i).getI000000130());
			}
			if(this.get(i).getI000000131() == null || this.get(i).getI000000131().equals("null")) {
				pstmt.setString(142,null);
			} else {
				pstmt.setString(142, this.get(i).getI000000131());
			}
			if(this.get(i).getI000000132() == null || this.get(i).getI000000132().equals("null")) {
				pstmt.setString(143,null);
			} else {
				pstmt.setString(143, this.get(i).getI000000132());
			}
			if(this.get(i).getI000000133() == null || this.get(i).getI000000133().equals("null")) {
				pstmt.setString(144,null);
			} else {
				pstmt.setString(144, this.get(i).getI000000133());
			}
			if(this.get(i).getI000000134() == null || this.get(i).getI000000134().equals("null")) {
				pstmt.setString(145,null);
			} else {
				pstmt.setString(145, this.get(i).getI000000134());
			}
			if(this.get(i).getI000000135() == null || this.get(i).getI000000135().equals("null")) {
				pstmt.setString(146,null);
			} else {
				pstmt.setString(146, this.get(i).getI000000135());
			}
			if(this.get(i).getI000000136() == null || this.get(i).getI000000136().equals("null")) {
				pstmt.setString(147,null);
			} else {
				pstmt.setString(147, this.get(i).getI000000136());
			}
			if(this.get(i).getI000000137() == null || this.get(i).getI000000137().equals("null")) {
				pstmt.setString(148,null);
			} else {
				pstmt.setString(148, this.get(i).getI000000137());
			}
			if(this.get(i).getI000000138() == null || this.get(i).getI000000138().equals("null")) {
				pstmt.setString(149,null);
			} else {
				pstmt.setString(149, this.get(i).getI000000138());
			}
			if(this.get(i).getI000000139() == null || this.get(i).getI000000139().equals("null")) {
				pstmt.setString(150,null);
			} else {
				pstmt.setString(150, this.get(i).getI000000139());
			}
			if(this.get(i).getI000000140() == null || this.get(i).getI000000140().equals("null")) {
				pstmt.setString(151,null);
			} else {
				pstmt.setString(151, this.get(i).getI000000140());
			}
			if(this.get(i).getI000000141() == null || this.get(i).getI000000141().equals("null")) {
				pstmt.setString(152,null);
			} else {
				pstmt.setString(152, this.get(i).getI000000141());
			}
			if(this.get(i).getI000000142() == null || this.get(i).getI000000142().equals("null")) {
				pstmt.setString(153,null);
			} else {
				pstmt.setString(153, this.get(i).getI000000142());
			}
			if(this.get(i).getI000000143() == null || this.get(i).getI000000143().equals("null")) {
				pstmt.setString(154,null);
			} else {
				pstmt.setString(154, this.get(i).getI000000143());
			}
			if(this.get(i).getI000000144() == null || this.get(i).getI000000144().equals("null")) {
				pstmt.setString(155,null);
			} else {
				pstmt.setString(155, this.get(i).getI000000144());
			}
			if(this.get(i).getI000000145() == null || this.get(i).getI000000145().equals("null")) {
				pstmt.setString(156,null);
			} else {
				pstmt.setString(156, this.get(i).getI000000145());
			}
			if(this.get(i).getI000000146() == null || this.get(i).getI000000146().equals("null")) {
				pstmt.setString(157,null);
			} else {
				pstmt.setString(157, this.get(i).getI000000146());
			}
			if(this.get(i).getI000000147() == null || this.get(i).getI000000147().equals("null")) {
				pstmt.setString(158,null);
			} else {
				pstmt.setString(158, this.get(i).getI000000147());
			}
			if(this.get(i).getI000000148() == null || this.get(i).getI000000148().equals("null")) {
				pstmt.setString(159,null);
			} else {
				pstmt.setString(159, this.get(i).getI000000148());
			}
			if(this.get(i).getI000000149() == null || this.get(i).getI000000149().equals("null")) {
				pstmt.setString(160,null);
			} else {
				pstmt.setString(160, this.get(i).getI000000149());
			}
			if(this.get(i).getI000000150() == null || this.get(i).getI000000150().equals("null")) {
				pstmt.setString(161,null);
			} else {
				pstmt.setString(161, this.get(i).getI000000150());
			}
			if(this.get(i).getI000000151() == null || this.get(i).getI000000151().equals("null")) {
				pstmt.setString(162,null);
			} else {
				pstmt.setString(162, this.get(i).getI000000151());
			}
			if(this.get(i).getI000000152() == null || this.get(i).getI000000152().equals("null")) {
				pstmt.setString(163,null);
			} else {
				pstmt.setString(163, this.get(i).getI000000152());
			}
			if(this.get(i).getI000000153() == null || this.get(i).getI000000153().equals("null")) {
				pstmt.setString(164,null);
			} else {
				pstmt.setString(164, this.get(i).getI000000153());
			}
			if(this.get(i).getI000000154() == null || this.get(i).getI000000154().equals("null")) {
				pstmt.setString(165,null);
			} else {
				pstmt.setString(165, this.get(i).getI000000154());
			}
			if(this.get(i).getI000000155() == null || this.get(i).getI000000155().equals("null")) {
				pstmt.setString(166,null);
			} else {
				pstmt.setString(166, this.get(i).getI000000155());
			}
			if(this.get(i).getI000000156() == null || this.get(i).getI000000156().equals("null")) {
				pstmt.setString(167,null);
			} else {
				pstmt.setString(167, this.get(i).getI000000156());
			}
			if(this.get(i).getI000000157() == null || this.get(i).getI000000157().equals("null")) {
				pstmt.setString(168,null);
			} else {
				pstmt.setString(168, this.get(i).getI000000157());
			}
			if(this.get(i).getI000000158() == null || this.get(i).getI000000158().equals("null")) {
				pstmt.setString(169,null);
			} else {
				pstmt.setString(169, this.get(i).getI000000158());
			}
			if(this.get(i).getI000000159() == null || this.get(i).getI000000159().equals("null")) {
				pstmt.setString(170,null);
			} else {
				pstmt.setString(170, this.get(i).getI000000159());
			}
			if(this.get(i).getI000000160() == null || this.get(i).getI000000160().equals("null")) {
				pstmt.setString(171,null);
			} else {
				pstmt.setString(171, this.get(i).getI000000160());
			}
			if(this.get(i).getI000000161() == null || this.get(i).getI000000161().equals("null")) {
				pstmt.setString(172,null);
			} else {
				pstmt.setString(172, this.get(i).getI000000161());
			}
			if(this.get(i).getI000000162() == null || this.get(i).getI000000162().equals("null")) {
				pstmt.setString(173,null);
			} else {
				pstmt.setString(173, this.get(i).getI000000162());
			}
			if(this.get(i).getI000000163() == null || this.get(i).getI000000163().equals("null")) {
				pstmt.setString(174,null);
			} else {
				pstmt.setString(174, this.get(i).getI000000163());
			}
			if(this.get(i).getI000000164() == null || this.get(i).getI000000164().equals("null")) {
				pstmt.setString(175,null);
			} else {
				pstmt.setString(175, this.get(i).getI000000164());
			}
			if(this.get(i).getI000000165() == null || this.get(i).getI000000165().equals("null")) {
				pstmt.setString(176,null);
			} else {
				pstmt.setString(176, this.get(i).getI000000165());
			}
			if(this.get(i).getI000000166() == null || this.get(i).getI000000166().equals("null")) {
				pstmt.setString(177,null);
			} else {
				pstmt.setString(177, this.get(i).getI000000166());
			}
			if(this.get(i).getI000000167() == null || this.get(i).getI000000167().equals("null")) {
				pstmt.setString(178,null);
			} else {
				pstmt.setString(178, this.get(i).getI000000167());
			}
			if(this.get(i).getI000000168() == null || this.get(i).getI000000168().equals("null")) {
				pstmt.setString(179,null);
			} else {
				pstmt.setString(179, this.get(i).getI000000168());
			}
			if(this.get(i).getI000000169() == null || this.get(i).getI000000169().equals("null")) {
				pstmt.setString(180,null);
			} else {
				pstmt.setString(180, this.get(i).getI000000169());
			}
			if(this.get(i).getI000000170() == null || this.get(i).getI000000170().equals("null")) {
				pstmt.setString(181,null);
			} else {
				pstmt.setString(181, this.get(i).getI000000170());
			}
			if(this.get(i).getI000000171() == null || this.get(i).getI000000171().equals("null")) {
				pstmt.setString(182,null);
			} else {
				pstmt.setString(182, this.get(i).getI000000171());
			}
			if(this.get(i).getI000000172() == null || this.get(i).getI000000172().equals("null")) {
				pstmt.setString(183,null);
			} else {
				pstmt.setString(183, this.get(i).getI000000172());
			}
			if(this.get(i).getI000000173() == null || this.get(i).getI000000173().equals("null")) {
				pstmt.setString(184,null);
			} else {
				pstmt.setString(184, this.get(i).getI000000173());
			}
			if(this.get(i).getI000000174() == null || this.get(i).getI000000174().equals("null")) {
				pstmt.setString(185,null);
			} else {
				pstmt.setString(185, this.get(i).getI000000174());
			}
			if(this.get(i).getI000000175() == null || this.get(i).getI000000175().equals("null")) {
				pstmt.setString(186,null);
			} else {
				pstmt.setString(186, this.get(i).getI000000175());
			}
			if(this.get(i).getI000000176() == null || this.get(i).getI000000176().equals("null")) {
				pstmt.setString(187,null);
			} else {
				pstmt.setString(187, this.get(i).getI000000176());
			}
			if(this.get(i).getI000000177() == null || this.get(i).getI000000177().equals("null")) {
				pstmt.setString(188,null);
			} else {
				pstmt.setString(188, this.get(i).getI000000177());
			}
			if(this.get(i).getI000000178() == null || this.get(i).getI000000178().equals("null")) {
				pstmt.setString(189,null);
			} else {
				pstmt.setString(189, this.get(i).getI000000178());
			}
			if(this.get(i).getI000000179() == null || this.get(i).getI000000179().equals("null")) {
				pstmt.setString(190,null);
			} else {
				pstmt.setString(190, this.get(i).getI000000179());
			}
			if(this.get(i).getI000000180() == null || this.get(i).getI000000180().equals("null")) {
				pstmt.setString(191,null);
			} else {
				pstmt.setString(191, this.get(i).getI000000180());
			}
			if(this.get(i).getI000000181() == null || this.get(i).getI000000181().equals("null")) {
				pstmt.setString(192,null);
			} else {
				pstmt.setString(192, this.get(i).getI000000181());
			}
			if(this.get(i).getI000000182() == null || this.get(i).getI000000182().equals("null")) {
				pstmt.setString(193,null);
			} else {
				pstmt.setString(193, this.get(i).getI000000182());
			}
			if(this.get(i).getI000000183() == null || this.get(i).getI000000183().equals("null")) {
				pstmt.setString(194,null);
			} else {
				pstmt.setString(194, this.get(i).getI000000183());
			}
			if(this.get(i).getI000000184() == null || this.get(i).getI000000184().equals("null")) {
				pstmt.setString(195,null);
			} else {
				pstmt.setString(195, this.get(i).getI000000184());
			}
			if(this.get(i).getI000000185() == null || this.get(i).getI000000185().equals("null")) {
				pstmt.setString(196,null);
			} else {
				pstmt.setString(196, this.get(i).getI000000185());
			}
			if(this.get(i).getI000000186() == null || this.get(i).getI000000186().equals("null")) {
				pstmt.setString(197,null);
			} else {
				pstmt.setString(197, this.get(i).getI000000186());
			}
			if(this.get(i).getI000000187() == null || this.get(i).getI000000187().equals("null")) {
				pstmt.setString(198,null);
			} else {
				pstmt.setString(198, this.get(i).getI000000187());
			}
			if(this.get(i).getI000000188() == null || this.get(i).getI000000188().equals("null")) {
				pstmt.setString(199,null);
			} else {
				pstmt.setString(199, this.get(i).getI000000188());
			}
			if(this.get(i).getI000000189() == null || this.get(i).getI000000189().equals("null")) {
				pstmt.setString(200,null);
			} else {
				pstmt.setString(200, this.get(i).getI000000189());
			}
			if(this.get(i).getI000000190() == null || this.get(i).getI000000190().equals("null")) {
				pstmt.setString(201,null);
			} else {
				pstmt.setString(201, this.get(i).getI000000190());
			}
			if(this.get(i).getI000000191() == null || this.get(i).getI000000191().equals("null")) {
				pstmt.setString(202,null);
			} else {
				pstmt.setString(202, this.get(i).getI000000191());
			}
			if(this.get(i).getI000000192() == null || this.get(i).getI000000192().equals("null")) {
				pstmt.setString(203,null);
			} else {
				pstmt.setString(203, this.get(i).getI000000192());
			}
			if(this.get(i).getI000000193() == null || this.get(i).getI000000193().equals("null")) {
				pstmt.setString(204,null);
			} else {
				pstmt.setString(204, this.get(i).getI000000193());
			}
			if(this.get(i).getI000000194() == null || this.get(i).getI000000194().equals("null")) {
				pstmt.setString(205,null);
			} else {
				pstmt.setString(205, this.get(i).getI000000194());
			}
			if(this.get(i).getI000000195() == null || this.get(i).getI000000195().equals("null")) {
				pstmt.setString(206,null);
			} else {
				pstmt.setString(206, this.get(i).getI000000195());
			}
			if(this.get(i).getI000000196() == null || this.get(i).getI000000196().equals("null")) {
				pstmt.setString(207,null);
			} else {
				pstmt.setString(207, this.get(i).getI000000196());
			}
			if(this.get(i).getI000000197() == null || this.get(i).getI000000197().equals("null")) {
				pstmt.setString(208,null);
			} else {
				pstmt.setString(208, this.get(i).getI000000197());
			}
			if(this.get(i).getI000000198() == null || this.get(i).getI000000198().equals("null")) {
				pstmt.setString(209,null);
			} else {
				pstmt.setString(209, this.get(i).getI000000198());
			}
			if(this.get(i).getI000000199() == null || this.get(i).getI000000199().equals("null")) {
				pstmt.setString(210,null);
			} else {
				pstmt.setString(210, this.get(i).getI000000199());
			}
			if(this.get(i).getI000000200() == null || this.get(i).getI000000200().equals("null")) {
				pstmt.setString(211,null);
			} else {
				pstmt.setString(211, this.get(i).getI000000200());
			}
			if(this.get(i).getR000000001() == null || this.get(i).getR000000001().equals("null")) {
				pstmt.setString(212,null);
			} else {
				pstmt.setString(212, this.get(i).getR000000001());
			}
			if(this.get(i).getR000000002() == null || this.get(i).getR000000002().equals("null")) {
				pstmt.setString(213,null);
			} else {
				pstmt.setString(213, this.get(i).getR000000002());
			}
			if(this.get(i).getR000000003() == null || this.get(i).getR000000003().equals("null")) {
				pstmt.setString(214,null);
			} else {
				pstmt.setString(214, this.get(i).getR000000003());
			}
			if(this.get(i).getR000000004() == null || this.get(i).getR000000004().equals("null")) {
				pstmt.setString(215,null);
			} else {
				pstmt.setString(215, this.get(i).getR000000004());
			}
			if(this.get(i).getR000000005() == null || this.get(i).getR000000005().equals("null")) {
				pstmt.setString(216,null);
			} else {
				pstmt.setString(216, this.get(i).getR000000005());
			}
			if(this.get(i).getR000000006() == null || this.get(i).getR000000006().equals("null")) {
				pstmt.setString(217,null);
			} else {
				pstmt.setString(217, this.get(i).getR000000006());
			}
			if(this.get(i).getR000000007() == null || this.get(i).getR000000007().equals("null")) {
				pstmt.setString(218,null);
			} else {
				pstmt.setString(218, this.get(i).getR000000007());
			}
			if(this.get(i).getR000000008() == null || this.get(i).getR000000008().equals("null")) {
				pstmt.setString(219,null);
			} else {
				pstmt.setString(219, this.get(i).getR000000008());
			}
			if(this.get(i).getR000000009() == null || this.get(i).getR000000009().equals("null")) {
				pstmt.setString(220,null);
			} else {
				pstmt.setString(220, this.get(i).getR000000009());
			}
			if(this.get(i).getR000000010() == null || this.get(i).getR000000010().equals("null")) {
				pstmt.setString(221,null);
			} else {
				pstmt.setString(221, this.get(i).getR000000010());
			}
			if(this.get(i).getR000000011() == null || this.get(i).getR000000011().equals("null")) {
				pstmt.setString(222,null);
			} else {
				pstmt.setString(222, this.get(i).getR000000011());
			}
			if(this.get(i).getR000000012() == null || this.get(i).getR000000012().equals("null")) {
				pstmt.setString(223,null);
			} else {
				pstmt.setString(223, this.get(i).getR000000012());
			}
			if(this.get(i).getR000000013() == null || this.get(i).getR000000013().equals("null")) {
				pstmt.setString(224,null);
			} else {
				pstmt.setString(224, this.get(i).getR000000013());
			}
			if(this.get(i).getR000000014() == null || this.get(i).getR000000014().equals("null")) {
				pstmt.setString(225,null);
			} else {
				pstmt.setString(225, this.get(i).getR000000014());
			}
			if(this.get(i).getR000000015() == null || this.get(i).getR000000015().equals("null")) {
				pstmt.setString(226,null);
			} else {
				pstmt.setString(226, this.get(i).getR000000015());
			}
			if(this.get(i).getR000000016() == null || this.get(i).getR000000016().equals("null")) {
				pstmt.setString(227,null);
			} else {
				pstmt.setString(227, this.get(i).getR000000016());
			}
			if(this.get(i).getR000000017() == null || this.get(i).getR000000017().equals("null")) {
				pstmt.setString(228,null);
			} else {
				pstmt.setString(228, this.get(i).getR000000017());
			}
			if(this.get(i).getR000000018() == null || this.get(i).getR000000018().equals("null")) {
				pstmt.setString(229,null);
			} else {
				pstmt.setString(229, this.get(i).getR000000018());
			}
			if(this.get(i).getR000000019() == null || this.get(i).getR000000019().equals("null")) {
				pstmt.setString(230,null);
			} else {
				pstmt.setString(230, this.get(i).getR000000019());
			}
			if(this.get(i).getR000000020() == null || this.get(i).getR000000020().equals("null")) {
				pstmt.setString(231,null);
			} else {
				pstmt.setString(231, this.get(i).getR000000020());
			}
			if(this.get(i).getR000000021() == null || this.get(i).getR000000021().equals("null")) {
				pstmt.setString(232,null);
			} else {
				pstmt.setString(232, this.get(i).getR000000021());
			}
			if(this.get(i).getR000000022() == null || this.get(i).getR000000022().equals("null")) {
				pstmt.setString(233,null);
			} else {
				pstmt.setString(233, this.get(i).getR000000022());
			}
			if(this.get(i).getR000000023() == null || this.get(i).getR000000023().equals("null")) {
				pstmt.setString(234,null);
			} else {
				pstmt.setString(234, this.get(i).getR000000023());
			}
			if(this.get(i).getR000000024() == null || this.get(i).getR000000024().equals("null")) {
				pstmt.setString(235,null);
			} else {
				pstmt.setString(235, this.get(i).getR000000024());
			}
			if(this.get(i).getR000000025() == null || this.get(i).getR000000025().equals("null")) {
				pstmt.setString(236,null);
			} else {
				pstmt.setString(236, this.get(i).getR000000025());
			}
			if(this.get(i).getR000000026() == null || this.get(i).getR000000026().equals("null")) {
				pstmt.setString(237,null);
			} else {
				pstmt.setString(237, this.get(i).getR000000026());
			}
			if(this.get(i).getR000000027() == null || this.get(i).getR000000027().equals("null")) {
				pstmt.setString(238,null);
			} else {
				pstmt.setString(238, this.get(i).getR000000027());
			}
			if(this.get(i).getR000000028() == null || this.get(i).getR000000028().equals("null")) {
				pstmt.setString(239,null);
			} else {
				pstmt.setString(239, this.get(i).getR000000028());
			}
			if(this.get(i).getR000000029() == null || this.get(i).getR000000029().equals("null")) {
				pstmt.setString(240,null);
			} else {
				pstmt.setString(240, this.get(i).getR000000029());
			}
			if(this.get(i).getR000000030() == null || this.get(i).getR000000030().equals("null")) {
				pstmt.setString(241,null);
			} else {
				pstmt.setString(241, this.get(i).getR000000030());
			}
			if(this.get(i).getR000000031() == null || this.get(i).getR000000031().equals("null")) {
				pstmt.setString(242,null);
			} else {
				pstmt.setString(242, this.get(i).getR000000031());
			}
			if(this.get(i).getR000000032() == null || this.get(i).getR000000032().equals("null")) {
				pstmt.setString(243,null);
			} else {
				pstmt.setString(243, this.get(i).getR000000032());
			}
			if(this.get(i).getR000000033() == null || this.get(i).getR000000033().equals("null")) {
				pstmt.setString(244,null);
			} else {
				pstmt.setString(244, this.get(i).getR000000033());
			}
			if(this.get(i).getR000000034() == null || this.get(i).getR000000034().equals("null")) {
				pstmt.setString(245,null);
			} else {
				pstmt.setString(245, this.get(i).getR000000034());
			}
			if(this.get(i).getR000000035() == null || this.get(i).getR000000035().equals("null")) {
				pstmt.setString(246,null);
			} else {
				pstmt.setString(246, this.get(i).getR000000035());
			}
			if(this.get(i).getR000000036() == null || this.get(i).getR000000036().equals("null")) {
				pstmt.setString(247,null);
			} else {
				pstmt.setString(247, this.get(i).getR000000036());
			}
			if(this.get(i).getR000000037() == null || this.get(i).getR000000037().equals("null")) {
				pstmt.setString(248,null);
			} else {
				pstmt.setString(248, this.get(i).getR000000037());
			}
			if(this.get(i).getR000000038() == null || this.get(i).getR000000038().equals("null")) {
				pstmt.setString(249,null);
			} else {
				pstmt.setString(249, this.get(i).getR000000038());
			}
			if(this.get(i).getR000000039() == null || this.get(i).getR000000039().equals("null")) {
				pstmt.setString(250,null);
			} else {
				pstmt.setString(250, this.get(i).getR000000039());
			}
			if(this.get(i).getR000000040() == null || this.get(i).getR000000040().equals("null")) {
				pstmt.setString(251,null);
			} else {
				pstmt.setString(251, this.get(i).getR000000040());
			}
			if(this.get(i).getR000000041() == null || this.get(i).getR000000041().equals("null")) {
				pstmt.setString(252,null);
			} else {
				pstmt.setString(252, this.get(i).getR000000041());
			}
			if(this.get(i).getR000000042() == null || this.get(i).getR000000042().equals("null")) {
				pstmt.setString(253,null);
			} else {
				pstmt.setString(253, this.get(i).getR000000042());
			}
			if(this.get(i).getR000000043() == null || this.get(i).getR000000043().equals("null")) {
				pstmt.setString(254,null);
			} else {
				pstmt.setString(254, this.get(i).getR000000043());
			}
			if(this.get(i).getR000000044() == null || this.get(i).getR000000044().equals("null")) {
				pstmt.setString(255,null);
			} else {
				pstmt.setString(255, this.get(i).getR000000044());
			}
			if(this.get(i).getR000000045() == null || this.get(i).getR000000045().equals("null")) {
				pstmt.setString(256,null);
			} else {
				pstmt.setString(256, this.get(i).getR000000045());
			}
			if(this.get(i).getR000000046() == null || this.get(i).getR000000046().equals("null")) {
				pstmt.setString(257,null);
			} else {
				pstmt.setString(257, this.get(i).getR000000046());
			}
			if(this.get(i).getR000000047() == null || this.get(i).getR000000047().equals("null")) {
				pstmt.setString(258,null);
			} else {
				pstmt.setString(258, this.get(i).getR000000047());
			}
			if(this.get(i).getR000000048() == null || this.get(i).getR000000048().equals("null")) {
				pstmt.setString(259,null);
			} else {
				pstmt.setString(259, this.get(i).getR000000048());
			}
			if(this.get(i).getR000000049() == null || this.get(i).getR000000049().equals("null")) {
				pstmt.setString(260,null);
			} else {
				pstmt.setString(260, this.get(i).getR000000049());
			}
			if(this.get(i).getR000000050() == null || this.get(i).getR000000050().equals("null")) {
				pstmt.setString(261,null);
			} else {
				pstmt.setString(261, this.get(i).getR000000050());
			}
			if(this.get(i).getR000000051() == null || this.get(i).getR000000051().equals("null")) {
				pstmt.setString(262,null);
			} else {
				pstmt.setString(262, this.get(i).getR000000051());
			}
			if(this.get(i).getR000000052() == null || this.get(i).getR000000052().equals("null")) {
				pstmt.setString(263,null);
			} else {
				pstmt.setString(263, this.get(i).getR000000052());
			}
			if(this.get(i).getR000000053() == null || this.get(i).getR000000053().equals("null")) {
				pstmt.setString(264,null);
			} else {
				pstmt.setString(264, this.get(i).getR000000053());
			}
			if(this.get(i).getR000000054() == null || this.get(i).getR000000054().equals("null")) {
				pstmt.setString(265,null);
			} else {
				pstmt.setString(265, this.get(i).getR000000054());
			}
			if(this.get(i).getR000000055() == null || this.get(i).getR000000055().equals("null")) {
				pstmt.setString(266,null);
			} else {
				pstmt.setString(266, this.get(i).getR000000055());
			}
			if(this.get(i).getR000000056() == null || this.get(i).getR000000056().equals("null")) {
				pstmt.setString(267,null);
			} else {
				pstmt.setString(267, this.get(i).getR000000056());
			}
			if(this.get(i).getR000000057() == null || this.get(i).getR000000057().equals("null")) {
				pstmt.setString(268,null);
			} else {
				pstmt.setString(268, this.get(i).getR000000057());
			}
			if(this.get(i).getR000000058() == null || this.get(i).getR000000058().equals("null")) {
				pstmt.setString(269,null);
			} else {
				pstmt.setString(269, this.get(i).getR000000058());
			}
			if(this.get(i).getR000000059() == null || this.get(i).getR000000059().equals("null")) {
				pstmt.setString(270,null);
			} else {
				pstmt.setString(270, this.get(i).getR000000059());
			}
			if(this.get(i).getR000000060() == null || this.get(i).getR000000060().equals("null")) {
				pstmt.setString(271,null);
			} else {
				pstmt.setString(271, this.get(i).getR000000060());
			}
			if(this.get(i).getR000000061() == null || this.get(i).getR000000061().equals("null")) {
				pstmt.setString(272,null);
			} else {
				pstmt.setString(272, this.get(i).getR000000061());
			}
			if(this.get(i).getR000000062() == null || this.get(i).getR000000062().equals("null")) {
				pstmt.setString(273,null);
			} else {
				pstmt.setString(273, this.get(i).getR000000062());
			}
			if(this.get(i).getR000000063() == null || this.get(i).getR000000063().equals("null")) {
				pstmt.setString(274,null);
			} else {
				pstmt.setString(274, this.get(i).getR000000063());
			}
			if(this.get(i).getR000000064() == null || this.get(i).getR000000064().equals("null")) {
				pstmt.setString(275,null);
			} else {
				pstmt.setString(275, this.get(i).getR000000064());
			}
			if(this.get(i).getR000000065() == null || this.get(i).getR000000065().equals("null")) {
				pstmt.setString(276,null);
			} else {
				pstmt.setString(276, this.get(i).getR000000065());
			}
			if(this.get(i).getR000000066() == null || this.get(i).getR000000066().equals("null")) {
				pstmt.setString(277,null);
			} else {
				pstmt.setString(277, this.get(i).getR000000066());
			}
			if(this.get(i).getR000000067() == null || this.get(i).getR000000067().equals("null")) {
				pstmt.setString(278,null);
			} else {
				pstmt.setString(278, this.get(i).getR000000067());
			}
			if(this.get(i).getR000000068() == null || this.get(i).getR000000068().equals("null")) {
				pstmt.setString(279,null);
			} else {
				pstmt.setString(279, this.get(i).getR000000068());
			}
			if(this.get(i).getR000000069() == null || this.get(i).getR000000069().equals("null")) {
				pstmt.setString(280,null);
			} else {
				pstmt.setString(280, this.get(i).getR000000069());
			}
			if(this.get(i).getR000000070() == null || this.get(i).getR000000070().equals("null")) {
				pstmt.setString(281,null);
			} else {
				pstmt.setString(281, this.get(i).getR000000070());
			}
			if(this.get(i).getR000000071() == null || this.get(i).getR000000071().equals("null")) {
				pstmt.setString(282,null);
			} else {
				pstmt.setString(282, this.get(i).getR000000071());
			}
			if(this.get(i).getR000000072() == null || this.get(i).getR000000072().equals("null")) {
				pstmt.setString(283,null);
			} else {
				pstmt.setString(283, this.get(i).getR000000072());
			}
			if(this.get(i).getR000000073() == null || this.get(i).getR000000073().equals("null")) {
				pstmt.setString(284,null);
			} else {
				pstmt.setString(284, this.get(i).getR000000073());
			}
			if(this.get(i).getR000000074() == null || this.get(i).getR000000074().equals("null")) {
				pstmt.setString(285,null);
			} else {
				pstmt.setString(285, this.get(i).getR000000074());
			}
			if(this.get(i).getR000000075() == null || this.get(i).getR000000075().equals("null")) {
				pstmt.setString(286,null);
			} else {
				pstmt.setString(286, this.get(i).getR000000075());
			}
			if(this.get(i).getR000000076() == null || this.get(i).getR000000076().equals("null")) {
				pstmt.setString(287,null);
			} else {
				pstmt.setString(287, this.get(i).getR000000076());
			}
			if(this.get(i).getR000000077() == null || this.get(i).getR000000077().equals("null")) {
				pstmt.setString(288,null);
			} else {
				pstmt.setString(288, this.get(i).getR000000077());
			}
			if(this.get(i).getR000000078() == null || this.get(i).getR000000078().equals("null")) {
				pstmt.setString(289,null);
			} else {
				pstmt.setString(289, this.get(i).getR000000078());
			}
			if(this.get(i).getR000000079() == null || this.get(i).getR000000079().equals("null")) {
				pstmt.setString(290,null);
			} else {
				pstmt.setString(290, this.get(i).getR000000079());
			}
			if(this.get(i).getR000000080() == null || this.get(i).getR000000080().equals("null")) {
				pstmt.setString(291,null);
			} else {
				pstmt.setString(291, this.get(i).getR000000080());
			}
			if(this.get(i).getR000000081() == null || this.get(i).getR000000081().equals("null")) {
				pstmt.setString(292,null);
			} else {
				pstmt.setString(292, this.get(i).getR000000081());
			}
			if(this.get(i).getR000000082() == null || this.get(i).getR000000082().equals("null")) {
				pstmt.setString(293,null);
			} else {
				pstmt.setString(293, this.get(i).getR000000082());
			}
			if(this.get(i).getR000000083() == null || this.get(i).getR000000083().equals("null")) {
				pstmt.setString(294,null);
			} else {
				pstmt.setString(294, this.get(i).getR000000083());
			}
			if(this.get(i).getR000000084() == null || this.get(i).getR000000084().equals("null")) {
				pstmt.setString(295,null);
			} else {
				pstmt.setString(295, this.get(i).getR000000084());
			}
			if(this.get(i).getR000000085() == null || this.get(i).getR000000085().equals("null")) {
				pstmt.setString(296,null);
			} else {
				pstmt.setString(296, this.get(i).getR000000085());
			}
			if(this.get(i).getR000000086() == null || this.get(i).getR000000086().equals("null")) {
				pstmt.setString(297,null);
			} else {
				pstmt.setString(297, this.get(i).getR000000086());
			}
			if(this.get(i).getR000000087() == null || this.get(i).getR000000087().equals("null")) {
				pstmt.setString(298,null);
			} else {
				pstmt.setString(298, this.get(i).getR000000087());
			}
			if(this.get(i).getR000000088() == null || this.get(i).getR000000088().equals("null")) {
				pstmt.setString(299,null);
			} else {
				pstmt.setString(299, this.get(i).getR000000088());
			}
			if(this.get(i).getR000000089() == null || this.get(i).getR000000089().equals("null")) {
				pstmt.setString(300,null);
			} else {
				pstmt.setString(300, this.get(i).getR000000089());
			}
			if(this.get(i).getR000000090() == null || this.get(i).getR000000090().equals("null")) {
				pstmt.setString(301,null);
			} else {
				pstmt.setString(301, this.get(i).getR000000090());
			}
			if(this.get(i).getR000000091() == null || this.get(i).getR000000091().equals("null")) {
				pstmt.setString(302,null);
			} else {
				pstmt.setString(302, this.get(i).getR000000091());
			}
			if(this.get(i).getR000000092() == null || this.get(i).getR000000092().equals("null")) {
				pstmt.setString(303,null);
			} else {
				pstmt.setString(303, this.get(i).getR000000092());
			}
			if(this.get(i).getR000000093() == null || this.get(i).getR000000093().equals("null")) {
				pstmt.setString(304,null);
			} else {
				pstmt.setString(304, this.get(i).getR000000093());
			}
			if(this.get(i).getR000000094() == null || this.get(i).getR000000094().equals("null")) {
				pstmt.setString(305,null);
			} else {
				pstmt.setString(305, this.get(i).getR000000094());
			}
			if(this.get(i).getR000000095() == null || this.get(i).getR000000095().equals("null")) {
				pstmt.setString(306,null);
			} else {
				pstmt.setString(306, this.get(i).getR000000095());
			}
			if(this.get(i).getR000000096() == null || this.get(i).getR000000096().equals("null")) {
				pstmt.setString(307,null);
			} else {
				pstmt.setString(307, this.get(i).getR000000096());
			}
			if(this.get(i).getR000000097() == null || this.get(i).getR000000097().equals("null")) {
				pstmt.setString(308,null);
			} else {
				pstmt.setString(308, this.get(i).getR000000097());
			}
			if(this.get(i).getR000000098() == null || this.get(i).getR000000098().equals("null")) {
				pstmt.setString(309,null);
			} else {
				pstmt.setString(309, this.get(i).getR000000098());
			}
			if(this.get(i).getR000000099() == null || this.get(i).getR000000099().equals("null")) {
				pstmt.setString(310,null);
			} else {
				pstmt.setString(310, this.get(i).getR000000099());
			}
			if(this.get(i).getR000000100() == null || this.get(i).getR000000100().equals("null")) {
				pstmt.setString(311,null);
			} else {
				pstmt.setString(311, this.get(i).getR000000100());
			}
			if(this.get(i).getR000000101() == null || this.get(i).getR000000101().equals("null")) {
				pstmt.setString(312,null);
			} else {
				pstmt.setString(312, this.get(i).getR000000101());
			}
			if(this.get(i).getR000000102() == null || this.get(i).getR000000102().equals("null")) {
				pstmt.setString(313,null);
			} else {
				pstmt.setString(313, this.get(i).getR000000102());
			}
			if(this.get(i).getR000000103() == null || this.get(i).getR000000103().equals("null")) {
				pstmt.setString(314,null);
			} else {
				pstmt.setString(314, this.get(i).getR000000103());
			}
			if(this.get(i).getR000000104() == null || this.get(i).getR000000104().equals("null")) {
				pstmt.setString(315,null);
			} else {
				pstmt.setString(315, this.get(i).getR000000104());
			}
			if(this.get(i).getR000000105() == null || this.get(i).getR000000105().equals("null")) {
				pstmt.setString(316,null);
			} else {
				pstmt.setString(316, this.get(i).getR000000105());
			}
			if(this.get(i).getR000000106() == null || this.get(i).getR000000106().equals("null")) {
				pstmt.setString(317,null);
			} else {
				pstmt.setString(317, this.get(i).getR000000106());
			}
			if(this.get(i).getR000000107() == null || this.get(i).getR000000107().equals("null")) {
				pstmt.setString(318,null);
			} else {
				pstmt.setString(318, this.get(i).getR000000107());
			}
			if(this.get(i).getR000000108() == null || this.get(i).getR000000108().equals("null")) {
				pstmt.setString(319,null);
			} else {
				pstmt.setString(319, this.get(i).getR000000108());
			}
			if(this.get(i).getR000000109() == null || this.get(i).getR000000109().equals("null")) {
				pstmt.setString(320,null);
			} else {
				pstmt.setString(320, this.get(i).getR000000109());
			}
			if(this.get(i).getR000000110() == null || this.get(i).getR000000110().equals("null")) {
				pstmt.setString(321,null);
			} else {
				pstmt.setString(321, this.get(i).getR000000110());
			}
			if(this.get(i).getR000000111() == null || this.get(i).getR000000111().equals("null")) {
				pstmt.setString(322,null);
			} else {
				pstmt.setString(322, this.get(i).getR000000111());
			}
			if(this.get(i).getR000000112() == null || this.get(i).getR000000112().equals("null")) {
				pstmt.setString(323,null);
			} else {
				pstmt.setString(323, this.get(i).getR000000112());
			}
			if(this.get(i).getR000000113() == null || this.get(i).getR000000113().equals("null")) {
				pstmt.setString(324,null);
			} else {
				pstmt.setString(324, this.get(i).getR000000113());
			}
			if(this.get(i).getR000000114() == null || this.get(i).getR000000114().equals("null")) {
				pstmt.setString(325,null);
			} else {
				pstmt.setString(325, this.get(i).getR000000114());
			}
			if(this.get(i).getR000000115() == null || this.get(i).getR000000115().equals("null")) {
				pstmt.setString(326,null);
			} else {
				pstmt.setString(326, this.get(i).getR000000115());
			}
			if(this.get(i).getR000000116() == null || this.get(i).getR000000116().equals("null")) {
				pstmt.setString(327,null);
			} else {
				pstmt.setString(327, this.get(i).getR000000116());
			}
			if(this.get(i).getR000000117() == null || this.get(i).getR000000117().equals("null")) {
				pstmt.setString(328,null);
			} else {
				pstmt.setString(328, this.get(i).getR000000117());
			}
			if(this.get(i).getR000000118() == null || this.get(i).getR000000118().equals("null")) {
				pstmt.setString(329,null);
			} else {
				pstmt.setString(329, this.get(i).getR000000118());
			}
			if(this.get(i).getR000000119() == null || this.get(i).getR000000119().equals("null")) {
				pstmt.setString(330,null);
			} else {
				pstmt.setString(330, this.get(i).getR000000119());
			}
			if(this.get(i).getR000000120() == null || this.get(i).getR000000120().equals("null")) {
				pstmt.setString(331,null);
			} else {
				pstmt.setString(331, this.get(i).getR000000120());
			}
			if(this.get(i).getR000000121() == null || this.get(i).getR000000121().equals("null")) {
				pstmt.setString(332,null);
			} else {
				pstmt.setString(332, this.get(i).getR000000121());
			}
			if(this.get(i).getR000000122() == null || this.get(i).getR000000122().equals("null")) {
				pstmt.setString(333,null);
			} else {
				pstmt.setString(333, this.get(i).getR000000122());
			}
			if(this.get(i).getR000000123() == null || this.get(i).getR000000123().equals("null")) {
				pstmt.setString(334,null);
			} else {
				pstmt.setString(334, this.get(i).getR000000123());
			}
			if(this.get(i).getR000000124() == null || this.get(i).getR000000124().equals("null")) {
				pstmt.setString(335,null);
			} else {
				pstmt.setString(335, this.get(i).getR000000124());
			}
			if(this.get(i).getR000000125() == null || this.get(i).getR000000125().equals("null")) {
				pstmt.setString(336,null);
			} else {
				pstmt.setString(336, this.get(i).getR000000125());
			}
			if(this.get(i).getR000000126() == null || this.get(i).getR000000126().equals("null")) {
				pstmt.setString(337,null);
			} else {
				pstmt.setString(337, this.get(i).getR000000126());
			}
			if(this.get(i).getR000000127() == null || this.get(i).getR000000127().equals("null")) {
				pstmt.setString(338,null);
			} else {
				pstmt.setString(338, this.get(i).getR000000127());
			}
			if(this.get(i).getR000000128() == null || this.get(i).getR000000128().equals("null")) {
				pstmt.setString(339,null);
			} else {
				pstmt.setString(339, this.get(i).getR000000128());
			}
			if(this.get(i).getR000000129() == null || this.get(i).getR000000129().equals("null")) {
				pstmt.setString(340,null);
			} else {
				pstmt.setString(340, this.get(i).getR000000129());
			}
			if(this.get(i).getR000000130() == null || this.get(i).getR000000130().equals("null")) {
				pstmt.setString(341,null);
			} else {
				pstmt.setString(341, this.get(i).getR000000130());
			}
			if(this.get(i).getR000000131() == null || this.get(i).getR000000131().equals("null")) {
				pstmt.setString(342,null);
			} else {
				pstmt.setString(342, this.get(i).getR000000131());
			}
			if(this.get(i).getR000000132() == null || this.get(i).getR000000132().equals("null")) {
				pstmt.setString(343,null);
			} else {
				pstmt.setString(343, this.get(i).getR000000132());
			}
			if(this.get(i).getR000000133() == null || this.get(i).getR000000133().equals("null")) {
				pstmt.setString(344,null);
			} else {
				pstmt.setString(344, this.get(i).getR000000133());
			}
			if(this.get(i).getR000000134() == null || this.get(i).getR000000134().equals("null")) {
				pstmt.setString(345,null);
			} else {
				pstmt.setString(345, this.get(i).getR000000134());
			}
			if(this.get(i).getR000000135() == null || this.get(i).getR000000135().equals("null")) {
				pstmt.setString(346,null);
			} else {
				pstmt.setString(346, this.get(i).getR000000135());
			}
			if(this.get(i).getR000000136() == null || this.get(i).getR000000136().equals("null")) {
				pstmt.setString(347,null);
			} else {
				pstmt.setString(347, this.get(i).getR000000136());
			}
			if(this.get(i).getR000000137() == null || this.get(i).getR000000137().equals("null")) {
				pstmt.setString(348,null);
			} else {
				pstmt.setString(348, this.get(i).getR000000137());
			}
			if(this.get(i).getR000000138() == null || this.get(i).getR000000138().equals("null")) {
				pstmt.setString(349,null);
			} else {
				pstmt.setString(349, this.get(i).getR000000138());
			}
			if(this.get(i).getR000000139() == null || this.get(i).getR000000139().equals("null")) {
				pstmt.setString(350,null);
			} else {
				pstmt.setString(350, this.get(i).getR000000139());
			}
			if(this.get(i).getR000000140() == null || this.get(i).getR000000140().equals("null")) {
				pstmt.setString(351,null);
			} else {
				pstmt.setString(351, this.get(i).getR000000140());
			}
			if(this.get(i).getR000000141() == null || this.get(i).getR000000141().equals("null")) {
				pstmt.setString(352,null);
			} else {
				pstmt.setString(352, this.get(i).getR000000141());
			}
			if(this.get(i).getR000000142() == null || this.get(i).getR000000142().equals("null")) {
				pstmt.setString(353,null);
			} else {
				pstmt.setString(353, this.get(i).getR000000142());
			}
			if(this.get(i).getR000000143() == null || this.get(i).getR000000143().equals("null")) {
				pstmt.setString(354,null);
			} else {
				pstmt.setString(354, this.get(i).getR000000143());
			}
			if(this.get(i).getR000000144() == null || this.get(i).getR000000144().equals("null")) {
				pstmt.setString(355,null);
			} else {
				pstmt.setString(355, this.get(i).getR000000144());
			}
			if(this.get(i).getR000000145() == null || this.get(i).getR000000145().equals("null")) {
				pstmt.setString(356,null);
			} else {
				pstmt.setString(356, this.get(i).getR000000145());
			}
			if(this.get(i).getR000000146() == null || this.get(i).getR000000146().equals("null")) {
				pstmt.setString(357,null);
			} else {
				pstmt.setString(357, this.get(i).getR000000146());
			}
			if(this.get(i).getR000000147() == null || this.get(i).getR000000147().equals("null")) {
				pstmt.setString(358,null);
			} else {
				pstmt.setString(358, this.get(i).getR000000147());
			}
			if(this.get(i).getR000000148() == null || this.get(i).getR000000148().equals("null")) {
				pstmt.setString(359,null);
			} else {
				pstmt.setString(359, this.get(i).getR000000148());
			}
			if(this.get(i).getR000000149() == null || this.get(i).getR000000149().equals("null")) {
				pstmt.setString(360,null);
			} else {
				pstmt.setString(360, this.get(i).getR000000149());
			}
			if(this.get(i).getR000000150() == null || this.get(i).getR000000150().equals("null")) {
				pstmt.setString(361,null);
			} else {
				pstmt.setString(361, this.get(i).getR000000150());
			}
			if(this.get(i).getR000000151() == null || this.get(i).getR000000151().equals("null")) {
				pstmt.setString(362,null);
			} else {
				pstmt.setString(362, this.get(i).getR000000151());
			}
			if(this.get(i).getR000000152() == null || this.get(i).getR000000152().equals("null")) {
				pstmt.setString(363,null);
			} else {
				pstmt.setString(363, this.get(i).getR000000152());
			}
			if(this.get(i).getR000000153() == null || this.get(i).getR000000153().equals("null")) {
				pstmt.setString(364,null);
			} else {
				pstmt.setString(364, this.get(i).getR000000153());
			}
			if(this.get(i).getR000000154() == null || this.get(i).getR000000154().equals("null")) {
				pstmt.setString(365,null);
			} else {
				pstmt.setString(365, this.get(i).getR000000154());
			}
			if(this.get(i).getR000000155() == null || this.get(i).getR000000155().equals("null")) {
				pstmt.setString(366,null);
			} else {
				pstmt.setString(366, this.get(i).getR000000155());
			}
			if(this.get(i).getR000000156() == null || this.get(i).getR000000156().equals("null")) {
				pstmt.setString(367,null);
			} else {
				pstmt.setString(367, this.get(i).getR000000156());
			}
			if(this.get(i).getR000000157() == null || this.get(i).getR000000157().equals("null")) {
				pstmt.setString(368,null);
			} else {
				pstmt.setString(368, this.get(i).getR000000157());
			}
			if(this.get(i).getR000000158() == null || this.get(i).getR000000158().equals("null")) {
				pstmt.setString(369,null);
			} else {
				pstmt.setString(369, this.get(i).getR000000158());
			}
			if(this.get(i).getR000000159() == null || this.get(i).getR000000159().equals("null")) {
				pstmt.setString(370,null);
			} else {
				pstmt.setString(370, this.get(i).getR000000159());
			}
			if(this.get(i).getR000000160() == null || this.get(i).getR000000160().equals("null")) {
				pstmt.setString(371,null);
			} else {
				pstmt.setString(371, this.get(i).getR000000160());
			}
			if(this.get(i).getR000000161() == null || this.get(i).getR000000161().equals("null")) {
				pstmt.setString(372,null);
			} else {
				pstmt.setString(372, this.get(i).getR000000161());
			}
			if(this.get(i).getR000000162() == null || this.get(i).getR000000162().equals("null")) {
				pstmt.setString(373,null);
			} else {
				pstmt.setString(373, this.get(i).getR000000162());
			}
			if(this.get(i).getR000000163() == null || this.get(i).getR000000163().equals("null")) {
				pstmt.setString(374,null);
			} else {
				pstmt.setString(374, this.get(i).getR000000163());
			}
			if(this.get(i).getR000000164() == null || this.get(i).getR000000164().equals("null")) {
				pstmt.setString(375,null);
			} else {
				pstmt.setString(375, this.get(i).getR000000164());
			}
			if(this.get(i).getR000000165() == null || this.get(i).getR000000165().equals("null")) {
				pstmt.setString(376,null);
			} else {
				pstmt.setString(376, this.get(i).getR000000165());
			}
			if(this.get(i).getR000000166() == null || this.get(i).getR000000166().equals("null")) {
				pstmt.setString(377,null);
			} else {
				pstmt.setString(377, this.get(i).getR000000166());
			}
			if(this.get(i).getR000000167() == null || this.get(i).getR000000167().equals("null")) {
				pstmt.setString(378,null);
			} else {
				pstmt.setString(378, this.get(i).getR000000167());
			}
			if(this.get(i).getR000000168() == null || this.get(i).getR000000168().equals("null")) {
				pstmt.setString(379,null);
			} else {
				pstmt.setString(379, this.get(i).getR000000168());
			}
			if(this.get(i).getR000000169() == null || this.get(i).getR000000169().equals("null")) {
				pstmt.setString(380,null);
			} else {
				pstmt.setString(380, this.get(i).getR000000169());
			}
			if(this.get(i).getR000000170() == null || this.get(i).getR000000170().equals("null")) {
				pstmt.setString(381,null);
			} else {
				pstmt.setString(381, this.get(i).getR000000170());
			}
			if(this.get(i).getR000000171() == null || this.get(i).getR000000171().equals("null")) {
				pstmt.setString(382,null);
			} else {
				pstmt.setString(382, this.get(i).getR000000171());
			}
			if(this.get(i).getR000000172() == null || this.get(i).getR000000172().equals("null")) {
				pstmt.setString(383,null);
			} else {
				pstmt.setString(383, this.get(i).getR000000172());
			}
			if(this.get(i).getR000000173() == null || this.get(i).getR000000173().equals("null")) {
				pstmt.setString(384,null);
			} else {
				pstmt.setString(384, this.get(i).getR000000173());
			}
			if(this.get(i).getR000000174() == null || this.get(i).getR000000174().equals("null")) {
				pstmt.setString(385,null);
			} else {
				pstmt.setString(385, this.get(i).getR000000174());
			}
			if(this.get(i).getR000000175() == null || this.get(i).getR000000175().equals("null")) {
				pstmt.setString(386,null);
			} else {
				pstmt.setString(386, this.get(i).getR000000175());
			}
			if(this.get(i).getR000000176() == null || this.get(i).getR000000176().equals("null")) {
				pstmt.setString(387,null);
			} else {
				pstmt.setString(387, this.get(i).getR000000176());
			}
			if(this.get(i).getR000000177() == null || this.get(i).getR000000177().equals("null")) {
				pstmt.setString(388,null);
			} else {
				pstmt.setString(388, this.get(i).getR000000177());
			}
			if(this.get(i).getR000000178() == null || this.get(i).getR000000178().equals("null")) {
				pstmt.setString(389,null);
			} else {
				pstmt.setString(389, this.get(i).getR000000178());
			}
			if(this.get(i).getR000000179() == null || this.get(i).getR000000179().equals("null")) {
				pstmt.setString(390,null);
			} else {
				pstmt.setString(390, this.get(i).getR000000179());
			}
			if(this.get(i).getR000000180() == null || this.get(i).getR000000180().equals("null")) {
				pstmt.setString(391,null);
			} else {
				pstmt.setString(391, this.get(i).getR000000180());
			}
			if(this.get(i).getR000000181() == null || this.get(i).getR000000181().equals("null")) {
				pstmt.setString(392,null);
			} else {
				pstmt.setString(392, this.get(i).getR000000181());
			}
			if(this.get(i).getR000000182() == null || this.get(i).getR000000182().equals("null")) {
				pstmt.setString(393,null);
			} else {
				pstmt.setString(393, this.get(i).getR000000182());
			}
			if(this.get(i).getR000000183() == null || this.get(i).getR000000183().equals("null")) {
				pstmt.setString(394,null);
			} else {
				pstmt.setString(394, this.get(i).getR000000183());
			}
			if(this.get(i).getR000000184() == null || this.get(i).getR000000184().equals("null")) {
				pstmt.setString(395,null);
			} else {
				pstmt.setString(395, this.get(i).getR000000184());
			}
			if(this.get(i).getR000000185() == null || this.get(i).getR000000185().equals("null")) {
				pstmt.setString(396,null);
			} else {
				pstmt.setString(396, this.get(i).getR000000185());
			}
			if(this.get(i).getR000000186() == null || this.get(i).getR000000186().equals("null")) {
				pstmt.setString(397,null);
			} else {
				pstmt.setString(397, this.get(i).getR000000186());
			}
			if(this.get(i).getR000000187() == null || this.get(i).getR000000187().equals("null")) {
				pstmt.setString(398,null);
			} else {
				pstmt.setString(398, this.get(i).getR000000187());
			}
			if(this.get(i).getR000000188() == null || this.get(i).getR000000188().equals("null")) {
				pstmt.setString(399,null);
			} else {
				pstmt.setString(399, this.get(i).getR000000188());
			}
			if(this.get(i).getR000000189() == null || this.get(i).getR000000189().equals("null")) {
				pstmt.setString(400,null);
			} else {
				pstmt.setString(400, this.get(i).getR000000189());
			}
			if(this.get(i).getR000000190() == null || this.get(i).getR000000190().equals("null")) {
				pstmt.setString(401,null);
			} else {
				pstmt.setString(401, this.get(i).getR000000190());
			}
			if(this.get(i).getR000000191() == null || this.get(i).getR000000191().equals("null")) {
				pstmt.setString(402,null);
			} else {
				pstmt.setString(402, this.get(i).getR000000191());
			}
			if(this.get(i).getR000000192() == null || this.get(i).getR000000192().equals("null")) {
				pstmt.setString(403,null);
			} else {
				pstmt.setString(403, this.get(i).getR000000192());
			}
			if(this.get(i).getR000000193() == null || this.get(i).getR000000193().equals("null")) {
				pstmt.setString(404,null);
			} else {
				pstmt.setString(404, this.get(i).getR000000193());
			}
			if(this.get(i).getR000000194() == null || this.get(i).getR000000194().equals("null")) {
				pstmt.setString(405,null);
			} else {
				pstmt.setString(405, this.get(i).getR000000194());
			}
			if(this.get(i).getR000000195() == null || this.get(i).getR000000195().equals("null")) {
				pstmt.setString(406,null);
			} else {
				pstmt.setString(406, this.get(i).getR000000195());
			}
			if(this.get(i).getR000000196() == null || this.get(i).getR000000196().equals("null")) {
				pstmt.setString(407,null);
			} else {
				pstmt.setString(407, this.get(i).getR000000196());
			}
			if(this.get(i).getR000000197() == null || this.get(i).getR000000197().equals("null")) {
				pstmt.setString(408,null);
			} else {
				pstmt.setString(408, this.get(i).getR000000197());
			}
			if(this.get(i).getR000000198() == null || this.get(i).getR000000198().equals("null")) {
				pstmt.setString(409,null);
			} else {
				pstmt.setString(409, this.get(i).getR000000198());
			}
			if(this.get(i).getR000000199() == null || this.get(i).getR000000199().equals("null")) {
				pstmt.setString(410,null);
			} else {
				pstmt.setString(410, this.get(i).getR000000199());
			}
			if(this.get(i).getR000000200() == null || this.get(i).getR000000200().equals("null")) {
				pstmt.setString(411,null);
			} else {
				pstmt.setString(411, this.get(i).getR000000200());
			}
			if(this.get(i).getI000000201() == null || this.get(i).getI000000201().equals("null")) {
				pstmt.setString(412,null);
			} else {
				pstmt.setString(412, this.get(i).getI000000201());
			}
			if(this.get(i).getI000000202() == null || this.get(i).getI000000202().equals("null")) {
				pstmt.setString(413,null);
			} else {
				pstmt.setString(413, this.get(i).getI000000202());
			}
			if(this.get(i).getI000000203() == null || this.get(i).getI000000203().equals("null")) {
				pstmt.setString(414,null);
			} else {
				pstmt.setString(414, this.get(i).getI000000203());
			}
			if(this.get(i).getI000000209() == null || this.get(i).getI000000209().equals("null")) {
				pstmt.setString(415,null);
			} else {
				pstmt.setString(415, this.get(i).getI000000209());
			}
			if(this.get(i).getI000000210() == null || this.get(i).getI000000210().equals("null")) {
				pstmt.setString(416,null);
			} else {
				pstmt.setString(416, this.get(i).getI000000210());
			}
			if(this.get(i).getI000000213() == null || this.get(i).getI000000213().equals("null")) {
				pstmt.setString(417,null);
			} else {
				pstmt.setString(417, this.get(i).getI000000213());
			}
			if(this.get(i).getI000000214() == null || this.get(i).getI000000214().equals("null")) {
				pstmt.setString(418,null);
			} else {
				pstmt.setString(418, this.get(i).getI000000214());
			}
			if(this.get(i).getI000000215() == null || this.get(i).getI000000215().equals("null")) {
				pstmt.setString(419,null);
			} else {
				pstmt.setString(419, this.get(i).getI000000215());
			}
			if(this.get(i).getI000000216() == null || this.get(i).getI000000216().equals("null")) {
				pstmt.setString(420,null);
			} else {
				pstmt.setString(420, this.get(i).getI000000216());
			}
			if(this.get(i).getI000000217() == null || this.get(i).getI000000217().equals("null")) {
				pstmt.setString(421,null);
			} else {
				pstmt.setString(421, this.get(i).getI000000217());
			}
			if(this.get(i).getI000000218() == null || this.get(i).getI000000218().equals("null")) {
				pstmt.setString(422,null);
			} else {
				pstmt.setString(422, this.get(i).getI000000218());
			}
			if(this.get(i).getI000000219() == null || this.get(i).getI000000219().equals("null")) {
				pstmt.setString(423,null);
			} else {
				pstmt.setString(423, this.get(i).getI000000219());
			}
			if(this.get(i).getI000000220() == null || this.get(i).getI000000220().equals("null")) {
				pstmt.setString(424,null);
			} else {
				pstmt.setString(424, this.get(i).getI000000220());
			}
			if(this.get(i).getI000000221() == null || this.get(i).getI000000221().equals("null")) {
				pstmt.setString(425,null);
			} else {
				pstmt.setString(425, this.get(i).getI000000221());
			}
			if(this.get(i).getI000000222() == null || this.get(i).getI000000222().equals("null")) {
				pstmt.setString(426,null);
			} else {
				pstmt.setString(426, this.get(i).getI000000222());
			}
			if(this.get(i).getI000000224() == null || this.get(i).getI000000224().equals("null")) {
				pstmt.setString(427,null);
			} else {
				pstmt.setString(427, this.get(i).getI000000224());
			}
			if(this.get(i).getI000000225() == null || this.get(i).getI000000225().equals("null")) {
				pstmt.setString(428,null);
			} else {
				pstmt.setString(428, this.get(i).getI000000225());
			}
			if(this.get(i).getI000000226() == null || this.get(i).getI000000226().equals("null")) {
				pstmt.setString(429,null);
			} else {
				pstmt.setString(429, this.get(i).getI000000226());
			}
			if(this.get(i).getI000000227() == null || this.get(i).getI000000227().equals("null")) {
				pstmt.setString(430,null);
			} else {
				pstmt.setString(430, this.get(i).getI000000227());
			}
			if(this.get(i).getI000000228() == null || this.get(i).getI000000228().equals("null")) {
				pstmt.setString(431,null);
			} else {
				pstmt.setString(431, this.get(i).getI000000228());
			}
			if(this.get(i).getI000000229() == null || this.get(i).getI000000229().equals("null")) {
				pstmt.setString(432,null);
			} else {
				pstmt.setString(432, this.get(i).getI000000229());
			}
			if(this.get(i).getI000000231() == null || this.get(i).getI000000231().equals("null")) {
				pstmt.setString(433,null);
			} else {
				pstmt.setString(433, this.get(i).getI000000231());
			}
			if(this.get(i).getI000000232() == null || this.get(i).getI000000232().equals("null")) {
				pstmt.setString(434,null);
			} else {
				pstmt.setString(434, this.get(i).getI000000232());
			}
			if(this.get(i).getI000000233() == null || this.get(i).getI000000233().equals("null")) {
				pstmt.setString(435,null);
			} else {
				pstmt.setString(435, this.get(i).getI000000233());
			}
			if(this.get(i).getI000000234() == null || this.get(i).getI000000234().equals("null")) {
				pstmt.setString(436,null);
			} else {
				pstmt.setString(436, this.get(i).getI000000234());
			}
			if(this.get(i).getI000000235() == null || this.get(i).getI000000235().equals("null")) {
				pstmt.setString(437,null);
			} else {
				pstmt.setString(437, this.get(i).getI000000235());
			}
			if(this.get(i).getI000000236() == null || this.get(i).getI000000236().equals("null")) {
				pstmt.setString(438,null);
			} else {
				pstmt.setString(438, this.get(i).getI000000236());
			}
			if(this.get(i).getI000000237() == null || this.get(i).getI000000237().equals("null")) {
				pstmt.setString(439,null);
			} else {
				pstmt.setString(439, this.get(i).getI000000237());
			}
			if(this.get(i).getI000000240() == null || this.get(i).getI000000240().equals("null")) {
				pstmt.setString(440,null);
			} else {
				pstmt.setString(440, this.get(i).getI000000240());
			}
			if(this.get(i).getI000000241() == null || this.get(i).getI000000241().equals("null")) {
				pstmt.setString(441,null);
			} else {
				pstmt.setString(441, this.get(i).getI000000241());
			}
			if(this.get(i).getI000000242() == null || this.get(i).getI000000242().equals("null")) {
				pstmt.setString(442,null);
			} else {
				pstmt.setString(442, this.get(i).getI000000242());
			}
			if(this.get(i).getI000000243() == null || this.get(i).getI000000243().equals("null")) {
				pstmt.setString(443,null);
			} else {
				pstmt.setString(443, this.get(i).getI000000243());
			}
			if(this.get(i).getI000000244() == null || this.get(i).getI000000244().equals("null")) {
				pstmt.setString(444,null);
			} else {
				pstmt.setString(444, this.get(i).getI000000244());
			}
			if(this.get(i).getI000000245() == null || this.get(i).getI000000245().equals("null")) {
				pstmt.setString(445,null);
			} else {
				pstmt.setString(445, this.get(i).getI000000245());
			}
			if(this.get(i).getI000000246() == null || this.get(i).getI000000246().equals("null")) {
				pstmt.setString(446,null);
			} else {
				pstmt.setString(446, this.get(i).getI000000246());
			}
			if(this.get(i).getI000000247() == null || this.get(i).getI000000247().equals("null")) {
				pstmt.setString(447,null);
			} else {
				pstmt.setString(447, this.get(i).getI000000247());
			}
			if(this.get(i).getI000000248() == null || this.get(i).getI000000248().equals("null")) {
				pstmt.setString(448,null);
			} else {
				pstmt.setString(448, this.get(i).getI000000248());
			}
			if(this.get(i).getI000000249() == null || this.get(i).getI000000249().equals("null")) {
				pstmt.setString(449,null);
			} else {
				pstmt.setString(449, this.get(i).getI000000249());
			}
			if(this.get(i).getI000000250() == null || this.get(i).getI000000250().equals("null")) {
				pstmt.setString(450,null);
			} else {
				pstmt.setString(450, this.get(i).getI000000250());
			}
			if(this.get(i).getI000000251() == null || this.get(i).getI000000251().equals("null")) {
				pstmt.setString(451,null);
			} else {
				pstmt.setString(451, this.get(i).getI000000251());
			}
			if(this.get(i).getR000000201() == null || this.get(i).getR000000201().equals("null")) {
				pstmt.setString(452,null);
			} else {
				pstmt.setString(452, this.get(i).getR000000201());
			}
			if(this.get(i).getR000000202() == null || this.get(i).getR000000202().equals("null")) {
				pstmt.setString(453,null);
			} else {
				pstmt.setString(453, this.get(i).getR000000202());
			}
			if(this.get(i).getR000000203() == null || this.get(i).getR000000203().equals("null")) {
				pstmt.setString(454,null);
			} else {
				pstmt.setString(454, this.get(i).getR000000203());
			}
			if(this.get(i).getR000000204() == null || this.get(i).getR000000204().equals("null")) {
				pstmt.setString(455,null);
			} else {
				pstmt.setString(455, this.get(i).getR000000204());
			}
			if(this.get(i).getR000000205() == null || this.get(i).getR000000205().equals("null")) {
				pstmt.setString(456,null);
			} else {
				pstmt.setString(456, this.get(i).getR000000205());
			}
			if(this.get(i).getI000000254() == null || this.get(i).getI000000254().equals("null")) {
				pstmt.setString(457,null);
			} else {
				pstmt.setString(457, this.get(i).getI000000254());
			}
			// set where condition
			if(this.get(i).getWageNo() == null || this.get(i).getWageNo().equals("null")) {
				pstmt.setString(458,null);
			} else {
				pstmt.setString(458, this.get(i).getWageNo());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(459,null);
			} else {
				pstmt.setString(459, this.get(i).getIndexType());
			}
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(460,null);
			} else {
				pstmt.setString(460, this.get(i).getAgentCode());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAIndexInfoV");
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
			tError.moduleName = "LAIndexInfoVDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LAIndexInfoV VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
            for (int i = 1; i <= tCount; i++)
            {
			if(this.get(i).getWageNo() == null || this.get(i).getWageNo().equals("null")) {
				pstmt.setString(1,null);
			} else {
				pstmt.setString(1, this.get(i).getWageNo());
			}
			if(this.get(i).getBranchType() == null || this.get(i).getBranchType().equals("null")) {
				pstmt.setString(2,null);
			} else {
				pstmt.setString(2, this.get(i).getBranchType());
			}
			if(this.get(i).getIndexType() == null || this.get(i).getIndexType().equals("null")) {
				pstmt.setString(3,null);
			} else {
				pstmt.setString(3, this.get(i).getIndexType());
			}
			if(this.get(i).getAgentCode() == null || this.get(i).getAgentCode().equals("null")) {
				pstmt.setString(4,null);
			} else {
				pstmt.setString(4, this.get(i).getAgentCode());
			}
			if(this.get(i).getAgentGrade() == null || this.get(i).getAgentGrade().equals("null")) {
				pstmt.setString(5,null);
			} else {
				pstmt.setString(5, this.get(i).getAgentGrade());
			}
			if(this.get(i).getAgentGroup() == null || this.get(i).getAgentGroup().equals("null")) {
				pstmt.setString(6,null);
			} else {
				pstmt.setString(6, this.get(i).getAgentGroup());
			}
			if(this.get(i).getState() == null || this.get(i).getState().equals("null")) {
				pstmt.setString(7,null);
			} else {
				pstmt.setString(7, this.get(i).getState());
			}
			if(this.get(i).getMakeDate() == null || this.get(i).getMakeDate().equals("null")) {
				pstmt.setDate(8,null);
			} else {
				pstmt.setDate(8, Date.valueOf(this.get(i).getMakeDate()));
			}
			if(this.get(i).getMakeTime() == null || this.get(i).getMakeTime().equals("null")) {
				pstmt.setString(9,null);
			} else {
				pstmt.setString(9, this.get(i).getMakeTime());
			}
			if(this.get(i).getModifyDate() == null || this.get(i).getModifyDate().equals("null")) {
				pstmt.setDate(10,null);
			} else {
				pstmt.setDate(10, Date.valueOf(this.get(i).getModifyDate()));
			}
			if(this.get(i).getModifyTime() == null || this.get(i).getModifyTime().equals("null")) {
				pstmt.setString(11,null);
			} else {
				pstmt.setString(11, this.get(i).getModifyTime());
			}
			if(this.get(i).getI000000001() == null || this.get(i).getI000000001().equals("null")) {
				pstmt.setString(12,null);
			} else {
				pstmt.setString(12, this.get(i).getI000000001());
			}
			if(this.get(i).getI000000002() == null || this.get(i).getI000000002().equals("null")) {
				pstmt.setString(13,null);
			} else {
				pstmt.setString(13, this.get(i).getI000000002());
			}
			if(this.get(i).getI000000003() == null || this.get(i).getI000000003().equals("null")) {
				pstmt.setString(14,null);
			} else {
				pstmt.setString(14, this.get(i).getI000000003());
			}
			if(this.get(i).getI000000004() == null || this.get(i).getI000000004().equals("null")) {
				pstmt.setString(15,null);
			} else {
				pstmt.setString(15, this.get(i).getI000000004());
			}
			if(this.get(i).getI000000005() == null || this.get(i).getI000000005().equals("null")) {
				pstmt.setString(16,null);
			} else {
				pstmt.setString(16, this.get(i).getI000000005());
			}
			if(this.get(i).getI000000006() == null || this.get(i).getI000000006().equals("null")) {
				pstmt.setString(17,null);
			} else {
				pstmt.setString(17, this.get(i).getI000000006());
			}
			if(this.get(i).getI000000007() == null || this.get(i).getI000000007().equals("null")) {
				pstmt.setString(18,null);
			} else {
				pstmt.setString(18, this.get(i).getI000000007());
			}
			if(this.get(i).getI000000008() == null || this.get(i).getI000000008().equals("null")) {
				pstmt.setString(19,null);
			} else {
				pstmt.setString(19, this.get(i).getI000000008());
			}
			if(this.get(i).getI000000009() == null || this.get(i).getI000000009().equals("null")) {
				pstmt.setString(20,null);
			} else {
				pstmt.setString(20, this.get(i).getI000000009());
			}
			if(this.get(i).getI000000010() == null || this.get(i).getI000000010().equals("null")) {
				pstmt.setString(21,null);
			} else {
				pstmt.setString(21, this.get(i).getI000000010());
			}
			if(this.get(i).getI000000011() == null || this.get(i).getI000000011().equals("null")) {
				pstmt.setString(22,null);
			} else {
				pstmt.setString(22, this.get(i).getI000000011());
			}
			if(this.get(i).getI000000012() == null || this.get(i).getI000000012().equals("null")) {
				pstmt.setString(23,null);
			} else {
				pstmt.setString(23, this.get(i).getI000000012());
			}
			if(this.get(i).getI000000013() == null || this.get(i).getI000000013().equals("null")) {
				pstmt.setString(24,null);
			} else {
				pstmt.setString(24, this.get(i).getI000000013());
			}
			if(this.get(i).getI000000014() == null || this.get(i).getI000000014().equals("null")) {
				pstmt.setString(25,null);
			} else {
				pstmt.setString(25, this.get(i).getI000000014());
			}
			if(this.get(i).getI000000015() == null || this.get(i).getI000000015().equals("null")) {
				pstmt.setString(26,null);
			} else {
				pstmt.setString(26, this.get(i).getI000000015());
			}
			if(this.get(i).getI000000016() == null || this.get(i).getI000000016().equals("null")) {
				pstmt.setString(27,null);
			} else {
				pstmt.setString(27, this.get(i).getI000000016());
			}
			if(this.get(i).getI000000017() == null || this.get(i).getI000000017().equals("null")) {
				pstmt.setString(28,null);
			} else {
				pstmt.setString(28, this.get(i).getI000000017());
			}
			if(this.get(i).getI000000018() == null || this.get(i).getI000000018().equals("null")) {
				pstmt.setString(29,null);
			} else {
				pstmt.setString(29, this.get(i).getI000000018());
			}
			if(this.get(i).getI000000019() == null || this.get(i).getI000000019().equals("null")) {
				pstmt.setString(30,null);
			} else {
				pstmt.setString(30, this.get(i).getI000000019());
			}
			if(this.get(i).getI000000020() == null || this.get(i).getI000000020().equals("null")) {
				pstmt.setString(31,null);
			} else {
				pstmt.setString(31, this.get(i).getI000000020());
			}
			if(this.get(i).getI000000021() == null || this.get(i).getI000000021().equals("null")) {
				pstmt.setString(32,null);
			} else {
				pstmt.setString(32, this.get(i).getI000000021());
			}
			if(this.get(i).getI000000022() == null || this.get(i).getI000000022().equals("null")) {
				pstmt.setString(33,null);
			} else {
				pstmt.setString(33, this.get(i).getI000000022());
			}
			if(this.get(i).getI000000023() == null || this.get(i).getI000000023().equals("null")) {
				pstmt.setString(34,null);
			} else {
				pstmt.setString(34, this.get(i).getI000000023());
			}
			if(this.get(i).getI000000024() == null || this.get(i).getI000000024().equals("null")) {
				pstmt.setString(35,null);
			} else {
				pstmt.setString(35, this.get(i).getI000000024());
			}
			if(this.get(i).getI000000025() == null || this.get(i).getI000000025().equals("null")) {
				pstmt.setString(36,null);
			} else {
				pstmt.setString(36, this.get(i).getI000000025());
			}
			if(this.get(i).getI000000026() == null || this.get(i).getI000000026().equals("null")) {
				pstmt.setString(37,null);
			} else {
				pstmt.setString(37, this.get(i).getI000000026());
			}
			if(this.get(i).getI000000027() == null || this.get(i).getI000000027().equals("null")) {
				pstmt.setString(38,null);
			} else {
				pstmt.setString(38, this.get(i).getI000000027());
			}
			if(this.get(i).getI000000028() == null || this.get(i).getI000000028().equals("null")) {
				pstmt.setString(39,null);
			} else {
				pstmt.setString(39, this.get(i).getI000000028());
			}
			if(this.get(i).getI000000029() == null || this.get(i).getI000000029().equals("null")) {
				pstmt.setString(40,null);
			} else {
				pstmt.setString(40, this.get(i).getI000000029());
			}
			if(this.get(i).getI000000030() == null || this.get(i).getI000000030().equals("null")) {
				pstmt.setString(41,null);
			} else {
				pstmt.setString(41, this.get(i).getI000000030());
			}
			if(this.get(i).getI000000031() == null || this.get(i).getI000000031().equals("null")) {
				pstmt.setString(42,null);
			} else {
				pstmt.setString(42, this.get(i).getI000000031());
			}
			if(this.get(i).getI000000032() == null || this.get(i).getI000000032().equals("null")) {
				pstmt.setString(43,null);
			} else {
				pstmt.setString(43, this.get(i).getI000000032());
			}
			if(this.get(i).getI000000033() == null || this.get(i).getI000000033().equals("null")) {
				pstmt.setString(44,null);
			} else {
				pstmt.setString(44, this.get(i).getI000000033());
			}
			if(this.get(i).getI000000034() == null || this.get(i).getI000000034().equals("null")) {
				pstmt.setString(45,null);
			} else {
				pstmt.setString(45, this.get(i).getI000000034());
			}
			if(this.get(i).getI000000035() == null || this.get(i).getI000000035().equals("null")) {
				pstmt.setString(46,null);
			} else {
				pstmt.setString(46, this.get(i).getI000000035());
			}
			if(this.get(i).getI000000036() == null || this.get(i).getI000000036().equals("null")) {
				pstmt.setString(47,null);
			} else {
				pstmt.setString(47, this.get(i).getI000000036());
			}
			if(this.get(i).getI000000037() == null || this.get(i).getI000000037().equals("null")) {
				pstmt.setString(48,null);
			} else {
				pstmt.setString(48, this.get(i).getI000000037());
			}
			if(this.get(i).getI000000038() == null || this.get(i).getI000000038().equals("null")) {
				pstmt.setString(49,null);
			} else {
				pstmt.setString(49, this.get(i).getI000000038());
			}
			if(this.get(i).getI000000039() == null || this.get(i).getI000000039().equals("null")) {
				pstmt.setString(50,null);
			} else {
				pstmt.setString(50, this.get(i).getI000000039());
			}
			if(this.get(i).getI000000040() == null || this.get(i).getI000000040().equals("null")) {
				pstmt.setString(51,null);
			} else {
				pstmt.setString(51, this.get(i).getI000000040());
			}
			if(this.get(i).getI000000041() == null || this.get(i).getI000000041().equals("null")) {
				pstmt.setString(52,null);
			} else {
				pstmt.setString(52, this.get(i).getI000000041());
			}
			if(this.get(i).getI000000042() == null || this.get(i).getI000000042().equals("null")) {
				pstmt.setString(53,null);
			} else {
				pstmt.setString(53, this.get(i).getI000000042());
			}
			if(this.get(i).getI000000043() == null || this.get(i).getI000000043().equals("null")) {
				pstmt.setString(54,null);
			} else {
				pstmt.setString(54, this.get(i).getI000000043());
			}
			if(this.get(i).getI000000044() == null || this.get(i).getI000000044().equals("null")) {
				pstmt.setString(55,null);
			} else {
				pstmt.setString(55, this.get(i).getI000000044());
			}
			if(this.get(i).getI000000045() == null || this.get(i).getI000000045().equals("null")) {
				pstmt.setString(56,null);
			} else {
				pstmt.setString(56, this.get(i).getI000000045());
			}
			if(this.get(i).getI000000046() == null || this.get(i).getI000000046().equals("null")) {
				pstmt.setString(57,null);
			} else {
				pstmt.setString(57, this.get(i).getI000000046());
			}
			if(this.get(i).getI000000047() == null || this.get(i).getI000000047().equals("null")) {
				pstmt.setString(58,null);
			} else {
				pstmt.setString(58, this.get(i).getI000000047());
			}
			if(this.get(i).getI000000048() == null || this.get(i).getI000000048().equals("null")) {
				pstmt.setString(59,null);
			} else {
				pstmt.setString(59, this.get(i).getI000000048());
			}
			if(this.get(i).getI000000049() == null || this.get(i).getI000000049().equals("null")) {
				pstmt.setString(60,null);
			} else {
				pstmt.setString(60, this.get(i).getI000000049());
			}
			if(this.get(i).getI000000050() == null || this.get(i).getI000000050().equals("null")) {
				pstmt.setString(61,null);
			} else {
				pstmt.setString(61, this.get(i).getI000000050());
			}
			if(this.get(i).getI000000051() == null || this.get(i).getI000000051().equals("null")) {
				pstmt.setString(62,null);
			} else {
				pstmt.setString(62, this.get(i).getI000000051());
			}
			if(this.get(i).getI000000052() == null || this.get(i).getI000000052().equals("null")) {
				pstmt.setString(63,null);
			} else {
				pstmt.setString(63, this.get(i).getI000000052());
			}
			if(this.get(i).getI000000053() == null || this.get(i).getI000000053().equals("null")) {
				pstmt.setString(64,null);
			} else {
				pstmt.setString(64, this.get(i).getI000000053());
			}
			if(this.get(i).getI000000054() == null || this.get(i).getI000000054().equals("null")) {
				pstmt.setString(65,null);
			} else {
				pstmt.setString(65, this.get(i).getI000000054());
			}
			if(this.get(i).getI000000055() == null || this.get(i).getI000000055().equals("null")) {
				pstmt.setString(66,null);
			} else {
				pstmt.setString(66, this.get(i).getI000000055());
			}
			if(this.get(i).getI000000056() == null || this.get(i).getI000000056().equals("null")) {
				pstmt.setString(67,null);
			} else {
				pstmt.setString(67, this.get(i).getI000000056());
			}
			if(this.get(i).getI000000057() == null || this.get(i).getI000000057().equals("null")) {
				pstmt.setString(68,null);
			} else {
				pstmt.setString(68, this.get(i).getI000000057());
			}
			if(this.get(i).getI000000058() == null || this.get(i).getI000000058().equals("null")) {
				pstmt.setString(69,null);
			} else {
				pstmt.setString(69, this.get(i).getI000000058());
			}
			if(this.get(i).getI000000059() == null || this.get(i).getI000000059().equals("null")) {
				pstmt.setString(70,null);
			} else {
				pstmt.setString(70, this.get(i).getI000000059());
			}
			if(this.get(i).getI000000060() == null || this.get(i).getI000000060().equals("null")) {
				pstmt.setString(71,null);
			} else {
				pstmt.setString(71, this.get(i).getI000000060());
			}
			if(this.get(i).getI000000061() == null || this.get(i).getI000000061().equals("null")) {
				pstmt.setString(72,null);
			} else {
				pstmt.setString(72, this.get(i).getI000000061());
			}
			if(this.get(i).getI000000062() == null || this.get(i).getI000000062().equals("null")) {
				pstmt.setString(73,null);
			} else {
				pstmt.setString(73, this.get(i).getI000000062());
			}
			if(this.get(i).getI000000063() == null || this.get(i).getI000000063().equals("null")) {
				pstmt.setString(74,null);
			} else {
				pstmt.setString(74, this.get(i).getI000000063());
			}
			if(this.get(i).getI000000064() == null || this.get(i).getI000000064().equals("null")) {
				pstmt.setString(75,null);
			} else {
				pstmt.setString(75, this.get(i).getI000000064());
			}
			if(this.get(i).getI000000065() == null || this.get(i).getI000000065().equals("null")) {
				pstmt.setString(76,null);
			} else {
				pstmt.setString(76, this.get(i).getI000000065());
			}
			if(this.get(i).getI000000066() == null || this.get(i).getI000000066().equals("null")) {
				pstmt.setString(77,null);
			} else {
				pstmt.setString(77, this.get(i).getI000000066());
			}
			if(this.get(i).getI000000067() == null || this.get(i).getI000000067().equals("null")) {
				pstmt.setString(78,null);
			} else {
				pstmt.setString(78, this.get(i).getI000000067());
			}
			if(this.get(i).getI000000068() == null || this.get(i).getI000000068().equals("null")) {
				pstmt.setString(79,null);
			} else {
				pstmt.setString(79, this.get(i).getI000000068());
			}
			if(this.get(i).getI000000069() == null || this.get(i).getI000000069().equals("null")) {
				pstmt.setString(80,null);
			} else {
				pstmt.setString(80, this.get(i).getI000000069());
			}
			if(this.get(i).getI000000070() == null || this.get(i).getI000000070().equals("null")) {
				pstmt.setString(81,null);
			} else {
				pstmt.setString(81, this.get(i).getI000000070());
			}
			if(this.get(i).getI000000071() == null || this.get(i).getI000000071().equals("null")) {
				pstmt.setString(82,null);
			} else {
				pstmt.setString(82, this.get(i).getI000000071());
			}
			if(this.get(i).getI000000072() == null || this.get(i).getI000000072().equals("null")) {
				pstmt.setString(83,null);
			} else {
				pstmt.setString(83, this.get(i).getI000000072());
			}
			if(this.get(i).getI000000073() == null || this.get(i).getI000000073().equals("null")) {
				pstmt.setString(84,null);
			} else {
				pstmt.setString(84, this.get(i).getI000000073());
			}
			if(this.get(i).getI000000074() == null || this.get(i).getI000000074().equals("null")) {
				pstmt.setString(85,null);
			} else {
				pstmt.setString(85, this.get(i).getI000000074());
			}
			if(this.get(i).getI000000075() == null || this.get(i).getI000000075().equals("null")) {
				pstmt.setString(86,null);
			} else {
				pstmt.setString(86, this.get(i).getI000000075());
			}
			if(this.get(i).getI000000076() == null || this.get(i).getI000000076().equals("null")) {
				pstmt.setString(87,null);
			} else {
				pstmt.setString(87, this.get(i).getI000000076());
			}
			if(this.get(i).getI000000077() == null || this.get(i).getI000000077().equals("null")) {
				pstmt.setString(88,null);
			} else {
				pstmt.setString(88, this.get(i).getI000000077());
			}
			if(this.get(i).getI000000078() == null || this.get(i).getI000000078().equals("null")) {
				pstmt.setString(89,null);
			} else {
				pstmt.setString(89, this.get(i).getI000000078());
			}
			if(this.get(i).getI000000079() == null || this.get(i).getI000000079().equals("null")) {
				pstmt.setString(90,null);
			} else {
				pstmt.setString(90, this.get(i).getI000000079());
			}
			if(this.get(i).getI000000080() == null || this.get(i).getI000000080().equals("null")) {
				pstmt.setString(91,null);
			} else {
				pstmt.setString(91, this.get(i).getI000000080());
			}
			if(this.get(i).getI000000081() == null || this.get(i).getI000000081().equals("null")) {
				pstmt.setString(92,null);
			} else {
				pstmt.setString(92, this.get(i).getI000000081());
			}
			if(this.get(i).getI000000082() == null || this.get(i).getI000000082().equals("null")) {
				pstmt.setString(93,null);
			} else {
				pstmt.setString(93, this.get(i).getI000000082());
			}
			if(this.get(i).getI000000083() == null || this.get(i).getI000000083().equals("null")) {
				pstmt.setString(94,null);
			} else {
				pstmt.setString(94, this.get(i).getI000000083());
			}
			if(this.get(i).getI000000084() == null || this.get(i).getI000000084().equals("null")) {
				pstmt.setString(95,null);
			} else {
				pstmt.setString(95, this.get(i).getI000000084());
			}
			if(this.get(i).getI000000085() == null || this.get(i).getI000000085().equals("null")) {
				pstmt.setString(96,null);
			} else {
				pstmt.setString(96, this.get(i).getI000000085());
			}
			if(this.get(i).getI000000086() == null || this.get(i).getI000000086().equals("null")) {
				pstmt.setString(97,null);
			} else {
				pstmt.setString(97, this.get(i).getI000000086());
			}
			if(this.get(i).getI000000087() == null || this.get(i).getI000000087().equals("null")) {
				pstmt.setString(98,null);
			} else {
				pstmt.setString(98, this.get(i).getI000000087());
			}
			if(this.get(i).getI000000088() == null || this.get(i).getI000000088().equals("null")) {
				pstmt.setString(99,null);
			} else {
				pstmt.setString(99, this.get(i).getI000000088());
			}
			if(this.get(i).getI000000089() == null || this.get(i).getI000000089().equals("null")) {
				pstmt.setString(100,null);
			} else {
				pstmt.setString(100, this.get(i).getI000000089());
			}
			if(this.get(i).getI000000090() == null || this.get(i).getI000000090().equals("null")) {
				pstmt.setString(101,null);
			} else {
				pstmt.setString(101, this.get(i).getI000000090());
			}
			if(this.get(i).getI000000091() == null || this.get(i).getI000000091().equals("null")) {
				pstmt.setString(102,null);
			} else {
				pstmt.setString(102, this.get(i).getI000000091());
			}
			if(this.get(i).getI000000092() == null || this.get(i).getI000000092().equals("null")) {
				pstmt.setString(103,null);
			} else {
				pstmt.setString(103, this.get(i).getI000000092());
			}
			if(this.get(i).getI000000093() == null || this.get(i).getI000000093().equals("null")) {
				pstmt.setString(104,null);
			} else {
				pstmt.setString(104, this.get(i).getI000000093());
			}
			if(this.get(i).getI000000094() == null || this.get(i).getI000000094().equals("null")) {
				pstmt.setString(105,null);
			} else {
				pstmt.setString(105, this.get(i).getI000000094());
			}
			if(this.get(i).getI000000095() == null || this.get(i).getI000000095().equals("null")) {
				pstmt.setString(106,null);
			} else {
				pstmt.setString(106, this.get(i).getI000000095());
			}
			if(this.get(i).getI000000096() == null || this.get(i).getI000000096().equals("null")) {
				pstmt.setString(107,null);
			} else {
				pstmt.setString(107, this.get(i).getI000000096());
			}
			if(this.get(i).getI000000097() == null || this.get(i).getI000000097().equals("null")) {
				pstmt.setString(108,null);
			} else {
				pstmt.setString(108, this.get(i).getI000000097());
			}
			if(this.get(i).getI000000098() == null || this.get(i).getI000000098().equals("null")) {
				pstmt.setString(109,null);
			} else {
				pstmt.setString(109, this.get(i).getI000000098());
			}
			if(this.get(i).getI000000099() == null || this.get(i).getI000000099().equals("null")) {
				pstmt.setString(110,null);
			} else {
				pstmt.setString(110, this.get(i).getI000000099());
			}
			if(this.get(i).getI000000100() == null || this.get(i).getI000000100().equals("null")) {
				pstmt.setString(111,null);
			} else {
				pstmt.setString(111, this.get(i).getI000000100());
			}
			if(this.get(i).getI000000101() == null || this.get(i).getI000000101().equals("null")) {
				pstmt.setString(112,null);
			} else {
				pstmt.setString(112, this.get(i).getI000000101());
			}
			if(this.get(i).getI000000102() == null || this.get(i).getI000000102().equals("null")) {
				pstmt.setString(113,null);
			} else {
				pstmt.setString(113, this.get(i).getI000000102());
			}
			if(this.get(i).getI000000103() == null || this.get(i).getI000000103().equals("null")) {
				pstmt.setString(114,null);
			} else {
				pstmt.setString(114, this.get(i).getI000000103());
			}
			if(this.get(i).getI000000104() == null || this.get(i).getI000000104().equals("null")) {
				pstmt.setString(115,null);
			} else {
				pstmt.setString(115, this.get(i).getI000000104());
			}
			if(this.get(i).getI000000105() == null || this.get(i).getI000000105().equals("null")) {
				pstmt.setString(116,null);
			} else {
				pstmt.setString(116, this.get(i).getI000000105());
			}
			if(this.get(i).getI000000106() == null || this.get(i).getI000000106().equals("null")) {
				pstmt.setString(117,null);
			} else {
				pstmt.setString(117, this.get(i).getI000000106());
			}
			if(this.get(i).getI000000107() == null || this.get(i).getI000000107().equals("null")) {
				pstmt.setString(118,null);
			} else {
				pstmt.setString(118, this.get(i).getI000000107());
			}
			if(this.get(i).getI000000108() == null || this.get(i).getI000000108().equals("null")) {
				pstmt.setString(119,null);
			} else {
				pstmt.setString(119, this.get(i).getI000000108());
			}
			if(this.get(i).getI000000109() == null || this.get(i).getI000000109().equals("null")) {
				pstmt.setString(120,null);
			} else {
				pstmt.setString(120, this.get(i).getI000000109());
			}
			if(this.get(i).getI000000110() == null || this.get(i).getI000000110().equals("null")) {
				pstmt.setString(121,null);
			} else {
				pstmt.setString(121, this.get(i).getI000000110());
			}
			if(this.get(i).getI000000111() == null || this.get(i).getI000000111().equals("null")) {
				pstmt.setString(122,null);
			} else {
				pstmt.setString(122, this.get(i).getI000000111());
			}
			if(this.get(i).getI000000112() == null || this.get(i).getI000000112().equals("null")) {
				pstmt.setString(123,null);
			} else {
				pstmt.setString(123, this.get(i).getI000000112());
			}
			if(this.get(i).getI000000113() == null || this.get(i).getI000000113().equals("null")) {
				pstmt.setString(124,null);
			} else {
				pstmt.setString(124, this.get(i).getI000000113());
			}
			if(this.get(i).getI000000114() == null || this.get(i).getI000000114().equals("null")) {
				pstmt.setString(125,null);
			} else {
				pstmt.setString(125, this.get(i).getI000000114());
			}
			if(this.get(i).getI000000115() == null || this.get(i).getI000000115().equals("null")) {
				pstmt.setString(126,null);
			} else {
				pstmt.setString(126, this.get(i).getI000000115());
			}
			if(this.get(i).getI000000116() == null || this.get(i).getI000000116().equals("null")) {
				pstmt.setString(127,null);
			} else {
				pstmt.setString(127, this.get(i).getI000000116());
			}
			if(this.get(i).getI000000117() == null || this.get(i).getI000000117().equals("null")) {
				pstmt.setString(128,null);
			} else {
				pstmt.setString(128, this.get(i).getI000000117());
			}
			if(this.get(i).getI000000118() == null || this.get(i).getI000000118().equals("null")) {
				pstmt.setString(129,null);
			} else {
				pstmt.setString(129, this.get(i).getI000000118());
			}
			if(this.get(i).getI000000119() == null || this.get(i).getI000000119().equals("null")) {
				pstmt.setString(130,null);
			} else {
				pstmt.setString(130, this.get(i).getI000000119());
			}
			if(this.get(i).getI000000120() == null || this.get(i).getI000000120().equals("null")) {
				pstmt.setString(131,null);
			} else {
				pstmt.setString(131, this.get(i).getI000000120());
			}
			if(this.get(i).getI000000121() == null || this.get(i).getI000000121().equals("null")) {
				pstmt.setString(132,null);
			} else {
				pstmt.setString(132, this.get(i).getI000000121());
			}
			if(this.get(i).getI000000122() == null || this.get(i).getI000000122().equals("null")) {
				pstmt.setString(133,null);
			} else {
				pstmt.setString(133, this.get(i).getI000000122());
			}
			if(this.get(i).getI000000123() == null || this.get(i).getI000000123().equals("null")) {
				pstmt.setString(134,null);
			} else {
				pstmt.setString(134, this.get(i).getI000000123());
			}
			if(this.get(i).getI000000124() == null || this.get(i).getI000000124().equals("null")) {
				pstmt.setString(135,null);
			} else {
				pstmt.setString(135, this.get(i).getI000000124());
			}
			if(this.get(i).getI000000125() == null || this.get(i).getI000000125().equals("null")) {
				pstmt.setString(136,null);
			} else {
				pstmt.setString(136, this.get(i).getI000000125());
			}
			if(this.get(i).getI000000126() == null || this.get(i).getI000000126().equals("null")) {
				pstmt.setString(137,null);
			} else {
				pstmt.setString(137, this.get(i).getI000000126());
			}
			if(this.get(i).getI000000127() == null || this.get(i).getI000000127().equals("null")) {
				pstmt.setString(138,null);
			} else {
				pstmt.setString(138, this.get(i).getI000000127());
			}
			if(this.get(i).getI000000128() == null || this.get(i).getI000000128().equals("null")) {
				pstmt.setString(139,null);
			} else {
				pstmt.setString(139, this.get(i).getI000000128());
			}
			if(this.get(i).getI000000129() == null || this.get(i).getI000000129().equals("null")) {
				pstmt.setString(140,null);
			} else {
				pstmt.setString(140, this.get(i).getI000000129());
			}
			if(this.get(i).getI000000130() == null || this.get(i).getI000000130().equals("null")) {
				pstmt.setString(141,null);
			} else {
				pstmt.setString(141, this.get(i).getI000000130());
			}
			if(this.get(i).getI000000131() == null || this.get(i).getI000000131().equals("null")) {
				pstmt.setString(142,null);
			} else {
				pstmt.setString(142, this.get(i).getI000000131());
			}
			if(this.get(i).getI000000132() == null || this.get(i).getI000000132().equals("null")) {
				pstmt.setString(143,null);
			} else {
				pstmt.setString(143, this.get(i).getI000000132());
			}
			if(this.get(i).getI000000133() == null || this.get(i).getI000000133().equals("null")) {
				pstmt.setString(144,null);
			} else {
				pstmt.setString(144, this.get(i).getI000000133());
			}
			if(this.get(i).getI000000134() == null || this.get(i).getI000000134().equals("null")) {
				pstmt.setString(145,null);
			} else {
				pstmt.setString(145, this.get(i).getI000000134());
			}
			if(this.get(i).getI000000135() == null || this.get(i).getI000000135().equals("null")) {
				pstmt.setString(146,null);
			} else {
				pstmt.setString(146, this.get(i).getI000000135());
			}
			if(this.get(i).getI000000136() == null || this.get(i).getI000000136().equals("null")) {
				pstmt.setString(147,null);
			} else {
				pstmt.setString(147, this.get(i).getI000000136());
			}
			if(this.get(i).getI000000137() == null || this.get(i).getI000000137().equals("null")) {
				pstmt.setString(148,null);
			} else {
				pstmt.setString(148, this.get(i).getI000000137());
			}
			if(this.get(i).getI000000138() == null || this.get(i).getI000000138().equals("null")) {
				pstmt.setString(149,null);
			} else {
				pstmt.setString(149, this.get(i).getI000000138());
			}
			if(this.get(i).getI000000139() == null || this.get(i).getI000000139().equals("null")) {
				pstmt.setString(150,null);
			} else {
				pstmt.setString(150, this.get(i).getI000000139());
			}
			if(this.get(i).getI000000140() == null || this.get(i).getI000000140().equals("null")) {
				pstmt.setString(151,null);
			} else {
				pstmt.setString(151, this.get(i).getI000000140());
			}
			if(this.get(i).getI000000141() == null || this.get(i).getI000000141().equals("null")) {
				pstmt.setString(152,null);
			} else {
				pstmt.setString(152, this.get(i).getI000000141());
			}
			if(this.get(i).getI000000142() == null || this.get(i).getI000000142().equals("null")) {
				pstmt.setString(153,null);
			} else {
				pstmt.setString(153, this.get(i).getI000000142());
			}
			if(this.get(i).getI000000143() == null || this.get(i).getI000000143().equals("null")) {
				pstmt.setString(154,null);
			} else {
				pstmt.setString(154, this.get(i).getI000000143());
			}
			if(this.get(i).getI000000144() == null || this.get(i).getI000000144().equals("null")) {
				pstmt.setString(155,null);
			} else {
				pstmt.setString(155, this.get(i).getI000000144());
			}
			if(this.get(i).getI000000145() == null || this.get(i).getI000000145().equals("null")) {
				pstmt.setString(156,null);
			} else {
				pstmt.setString(156, this.get(i).getI000000145());
			}
			if(this.get(i).getI000000146() == null || this.get(i).getI000000146().equals("null")) {
				pstmt.setString(157,null);
			} else {
				pstmt.setString(157, this.get(i).getI000000146());
			}
			if(this.get(i).getI000000147() == null || this.get(i).getI000000147().equals("null")) {
				pstmt.setString(158,null);
			} else {
				pstmt.setString(158, this.get(i).getI000000147());
			}
			if(this.get(i).getI000000148() == null || this.get(i).getI000000148().equals("null")) {
				pstmt.setString(159,null);
			} else {
				pstmt.setString(159, this.get(i).getI000000148());
			}
			if(this.get(i).getI000000149() == null || this.get(i).getI000000149().equals("null")) {
				pstmt.setString(160,null);
			} else {
				pstmt.setString(160, this.get(i).getI000000149());
			}
			if(this.get(i).getI000000150() == null || this.get(i).getI000000150().equals("null")) {
				pstmt.setString(161,null);
			} else {
				pstmt.setString(161, this.get(i).getI000000150());
			}
			if(this.get(i).getI000000151() == null || this.get(i).getI000000151().equals("null")) {
				pstmt.setString(162,null);
			} else {
				pstmt.setString(162, this.get(i).getI000000151());
			}
			if(this.get(i).getI000000152() == null || this.get(i).getI000000152().equals("null")) {
				pstmt.setString(163,null);
			} else {
				pstmt.setString(163, this.get(i).getI000000152());
			}
			if(this.get(i).getI000000153() == null || this.get(i).getI000000153().equals("null")) {
				pstmt.setString(164,null);
			} else {
				pstmt.setString(164, this.get(i).getI000000153());
			}
			if(this.get(i).getI000000154() == null || this.get(i).getI000000154().equals("null")) {
				pstmt.setString(165,null);
			} else {
				pstmt.setString(165, this.get(i).getI000000154());
			}
			if(this.get(i).getI000000155() == null || this.get(i).getI000000155().equals("null")) {
				pstmt.setString(166,null);
			} else {
				pstmt.setString(166, this.get(i).getI000000155());
			}
			if(this.get(i).getI000000156() == null || this.get(i).getI000000156().equals("null")) {
				pstmt.setString(167,null);
			} else {
				pstmt.setString(167, this.get(i).getI000000156());
			}
			if(this.get(i).getI000000157() == null || this.get(i).getI000000157().equals("null")) {
				pstmt.setString(168,null);
			} else {
				pstmt.setString(168, this.get(i).getI000000157());
			}
			if(this.get(i).getI000000158() == null || this.get(i).getI000000158().equals("null")) {
				pstmt.setString(169,null);
			} else {
				pstmt.setString(169, this.get(i).getI000000158());
			}
			if(this.get(i).getI000000159() == null || this.get(i).getI000000159().equals("null")) {
				pstmt.setString(170,null);
			} else {
				pstmt.setString(170, this.get(i).getI000000159());
			}
			if(this.get(i).getI000000160() == null || this.get(i).getI000000160().equals("null")) {
				pstmt.setString(171,null);
			} else {
				pstmt.setString(171, this.get(i).getI000000160());
			}
			if(this.get(i).getI000000161() == null || this.get(i).getI000000161().equals("null")) {
				pstmt.setString(172,null);
			} else {
				pstmt.setString(172, this.get(i).getI000000161());
			}
			if(this.get(i).getI000000162() == null || this.get(i).getI000000162().equals("null")) {
				pstmt.setString(173,null);
			} else {
				pstmt.setString(173, this.get(i).getI000000162());
			}
			if(this.get(i).getI000000163() == null || this.get(i).getI000000163().equals("null")) {
				pstmt.setString(174,null);
			} else {
				pstmt.setString(174, this.get(i).getI000000163());
			}
			if(this.get(i).getI000000164() == null || this.get(i).getI000000164().equals("null")) {
				pstmt.setString(175,null);
			} else {
				pstmt.setString(175, this.get(i).getI000000164());
			}
			if(this.get(i).getI000000165() == null || this.get(i).getI000000165().equals("null")) {
				pstmt.setString(176,null);
			} else {
				pstmt.setString(176, this.get(i).getI000000165());
			}
			if(this.get(i).getI000000166() == null || this.get(i).getI000000166().equals("null")) {
				pstmt.setString(177,null);
			} else {
				pstmt.setString(177, this.get(i).getI000000166());
			}
			if(this.get(i).getI000000167() == null || this.get(i).getI000000167().equals("null")) {
				pstmt.setString(178,null);
			} else {
				pstmt.setString(178, this.get(i).getI000000167());
			}
			if(this.get(i).getI000000168() == null || this.get(i).getI000000168().equals("null")) {
				pstmt.setString(179,null);
			} else {
				pstmt.setString(179, this.get(i).getI000000168());
			}
			if(this.get(i).getI000000169() == null || this.get(i).getI000000169().equals("null")) {
				pstmt.setString(180,null);
			} else {
				pstmt.setString(180, this.get(i).getI000000169());
			}
			if(this.get(i).getI000000170() == null || this.get(i).getI000000170().equals("null")) {
				pstmt.setString(181,null);
			} else {
				pstmt.setString(181, this.get(i).getI000000170());
			}
			if(this.get(i).getI000000171() == null || this.get(i).getI000000171().equals("null")) {
				pstmt.setString(182,null);
			} else {
				pstmt.setString(182, this.get(i).getI000000171());
			}
			if(this.get(i).getI000000172() == null || this.get(i).getI000000172().equals("null")) {
				pstmt.setString(183,null);
			} else {
				pstmt.setString(183, this.get(i).getI000000172());
			}
			if(this.get(i).getI000000173() == null || this.get(i).getI000000173().equals("null")) {
				pstmt.setString(184,null);
			} else {
				pstmt.setString(184, this.get(i).getI000000173());
			}
			if(this.get(i).getI000000174() == null || this.get(i).getI000000174().equals("null")) {
				pstmt.setString(185,null);
			} else {
				pstmt.setString(185, this.get(i).getI000000174());
			}
			if(this.get(i).getI000000175() == null || this.get(i).getI000000175().equals("null")) {
				pstmt.setString(186,null);
			} else {
				pstmt.setString(186, this.get(i).getI000000175());
			}
			if(this.get(i).getI000000176() == null || this.get(i).getI000000176().equals("null")) {
				pstmt.setString(187,null);
			} else {
				pstmt.setString(187, this.get(i).getI000000176());
			}
			if(this.get(i).getI000000177() == null || this.get(i).getI000000177().equals("null")) {
				pstmt.setString(188,null);
			} else {
				pstmt.setString(188, this.get(i).getI000000177());
			}
			if(this.get(i).getI000000178() == null || this.get(i).getI000000178().equals("null")) {
				pstmt.setString(189,null);
			} else {
				pstmt.setString(189, this.get(i).getI000000178());
			}
			if(this.get(i).getI000000179() == null || this.get(i).getI000000179().equals("null")) {
				pstmt.setString(190,null);
			} else {
				pstmt.setString(190, this.get(i).getI000000179());
			}
			if(this.get(i).getI000000180() == null || this.get(i).getI000000180().equals("null")) {
				pstmt.setString(191,null);
			} else {
				pstmt.setString(191, this.get(i).getI000000180());
			}
			if(this.get(i).getI000000181() == null || this.get(i).getI000000181().equals("null")) {
				pstmt.setString(192,null);
			} else {
				pstmt.setString(192, this.get(i).getI000000181());
			}
			if(this.get(i).getI000000182() == null || this.get(i).getI000000182().equals("null")) {
				pstmt.setString(193,null);
			} else {
				pstmt.setString(193, this.get(i).getI000000182());
			}
			if(this.get(i).getI000000183() == null || this.get(i).getI000000183().equals("null")) {
				pstmt.setString(194,null);
			} else {
				pstmt.setString(194, this.get(i).getI000000183());
			}
			if(this.get(i).getI000000184() == null || this.get(i).getI000000184().equals("null")) {
				pstmt.setString(195,null);
			} else {
				pstmt.setString(195, this.get(i).getI000000184());
			}
			if(this.get(i).getI000000185() == null || this.get(i).getI000000185().equals("null")) {
				pstmt.setString(196,null);
			} else {
				pstmt.setString(196, this.get(i).getI000000185());
			}
			if(this.get(i).getI000000186() == null || this.get(i).getI000000186().equals("null")) {
				pstmt.setString(197,null);
			} else {
				pstmt.setString(197, this.get(i).getI000000186());
			}
			if(this.get(i).getI000000187() == null || this.get(i).getI000000187().equals("null")) {
				pstmt.setString(198,null);
			} else {
				pstmt.setString(198, this.get(i).getI000000187());
			}
			if(this.get(i).getI000000188() == null || this.get(i).getI000000188().equals("null")) {
				pstmt.setString(199,null);
			} else {
				pstmt.setString(199, this.get(i).getI000000188());
			}
			if(this.get(i).getI000000189() == null || this.get(i).getI000000189().equals("null")) {
				pstmt.setString(200,null);
			} else {
				pstmt.setString(200, this.get(i).getI000000189());
			}
			if(this.get(i).getI000000190() == null || this.get(i).getI000000190().equals("null")) {
				pstmt.setString(201,null);
			} else {
				pstmt.setString(201, this.get(i).getI000000190());
			}
			if(this.get(i).getI000000191() == null || this.get(i).getI000000191().equals("null")) {
				pstmt.setString(202,null);
			} else {
				pstmt.setString(202, this.get(i).getI000000191());
			}
			if(this.get(i).getI000000192() == null || this.get(i).getI000000192().equals("null")) {
				pstmt.setString(203,null);
			} else {
				pstmt.setString(203, this.get(i).getI000000192());
			}
			if(this.get(i).getI000000193() == null || this.get(i).getI000000193().equals("null")) {
				pstmt.setString(204,null);
			} else {
				pstmt.setString(204, this.get(i).getI000000193());
			}
			if(this.get(i).getI000000194() == null || this.get(i).getI000000194().equals("null")) {
				pstmt.setString(205,null);
			} else {
				pstmt.setString(205, this.get(i).getI000000194());
			}
			if(this.get(i).getI000000195() == null || this.get(i).getI000000195().equals("null")) {
				pstmt.setString(206,null);
			} else {
				pstmt.setString(206, this.get(i).getI000000195());
			}
			if(this.get(i).getI000000196() == null || this.get(i).getI000000196().equals("null")) {
				pstmt.setString(207,null);
			} else {
				pstmt.setString(207, this.get(i).getI000000196());
			}
			if(this.get(i).getI000000197() == null || this.get(i).getI000000197().equals("null")) {
				pstmt.setString(208,null);
			} else {
				pstmt.setString(208, this.get(i).getI000000197());
			}
			if(this.get(i).getI000000198() == null || this.get(i).getI000000198().equals("null")) {
				pstmt.setString(209,null);
			} else {
				pstmt.setString(209, this.get(i).getI000000198());
			}
			if(this.get(i).getI000000199() == null || this.get(i).getI000000199().equals("null")) {
				pstmt.setString(210,null);
			} else {
				pstmt.setString(210, this.get(i).getI000000199());
			}
			if(this.get(i).getI000000200() == null || this.get(i).getI000000200().equals("null")) {
				pstmt.setString(211,null);
			} else {
				pstmt.setString(211, this.get(i).getI000000200());
			}
			if(this.get(i).getR000000001() == null || this.get(i).getR000000001().equals("null")) {
				pstmt.setString(212,null);
			} else {
				pstmt.setString(212, this.get(i).getR000000001());
			}
			if(this.get(i).getR000000002() == null || this.get(i).getR000000002().equals("null")) {
				pstmt.setString(213,null);
			} else {
				pstmt.setString(213, this.get(i).getR000000002());
			}
			if(this.get(i).getR000000003() == null || this.get(i).getR000000003().equals("null")) {
				pstmt.setString(214,null);
			} else {
				pstmt.setString(214, this.get(i).getR000000003());
			}
			if(this.get(i).getR000000004() == null || this.get(i).getR000000004().equals("null")) {
				pstmt.setString(215,null);
			} else {
				pstmt.setString(215, this.get(i).getR000000004());
			}
			if(this.get(i).getR000000005() == null || this.get(i).getR000000005().equals("null")) {
				pstmt.setString(216,null);
			} else {
				pstmt.setString(216, this.get(i).getR000000005());
			}
			if(this.get(i).getR000000006() == null || this.get(i).getR000000006().equals("null")) {
				pstmt.setString(217,null);
			} else {
				pstmt.setString(217, this.get(i).getR000000006());
			}
			if(this.get(i).getR000000007() == null || this.get(i).getR000000007().equals("null")) {
				pstmt.setString(218,null);
			} else {
				pstmt.setString(218, this.get(i).getR000000007());
			}
			if(this.get(i).getR000000008() == null || this.get(i).getR000000008().equals("null")) {
				pstmt.setString(219,null);
			} else {
				pstmt.setString(219, this.get(i).getR000000008());
			}
			if(this.get(i).getR000000009() == null || this.get(i).getR000000009().equals("null")) {
				pstmt.setString(220,null);
			} else {
				pstmt.setString(220, this.get(i).getR000000009());
			}
			if(this.get(i).getR000000010() == null || this.get(i).getR000000010().equals("null")) {
				pstmt.setString(221,null);
			} else {
				pstmt.setString(221, this.get(i).getR000000010());
			}
			if(this.get(i).getR000000011() == null || this.get(i).getR000000011().equals("null")) {
				pstmt.setString(222,null);
			} else {
				pstmt.setString(222, this.get(i).getR000000011());
			}
			if(this.get(i).getR000000012() == null || this.get(i).getR000000012().equals("null")) {
				pstmt.setString(223,null);
			} else {
				pstmt.setString(223, this.get(i).getR000000012());
			}
			if(this.get(i).getR000000013() == null || this.get(i).getR000000013().equals("null")) {
				pstmt.setString(224,null);
			} else {
				pstmt.setString(224, this.get(i).getR000000013());
			}
			if(this.get(i).getR000000014() == null || this.get(i).getR000000014().equals("null")) {
				pstmt.setString(225,null);
			} else {
				pstmt.setString(225, this.get(i).getR000000014());
			}
			if(this.get(i).getR000000015() == null || this.get(i).getR000000015().equals("null")) {
				pstmt.setString(226,null);
			} else {
				pstmt.setString(226, this.get(i).getR000000015());
			}
			if(this.get(i).getR000000016() == null || this.get(i).getR000000016().equals("null")) {
				pstmt.setString(227,null);
			} else {
				pstmt.setString(227, this.get(i).getR000000016());
			}
			if(this.get(i).getR000000017() == null || this.get(i).getR000000017().equals("null")) {
				pstmt.setString(228,null);
			} else {
				pstmt.setString(228, this.get(i).getR000000017());
			}
			if(this.get(i).getR000000018() == null || this.get(i).getR000000018().equals("null")) {
				pstmt.setString(229,null);
			} else {
				pstmt.setString(229, this.get(i).getR000000018());
			}
			if(this.get(i).getR000000019() == null || this.get(i).getR000000019().equals("null")) {
				pstmt.setString(230,null);
			} else {
				pstmt.setString(230, this.get(i).getR000000019());
			}
			if(this.get(i).getR000000020() == null || this.get(i).getR000000020().equals("null")) {
				pstmt.setString(231,null);
			} else {
				pstmt.setString(231, this.get(i).getR000000020());
			}
			if(this.get(i).getR000000021() == null || this.get(i).getR000000021().equals("null")) {
				pstmt.setString(232,null);
			} else {
				pstmt.setString(232, this.get(i).getR000000021());
			}
			if(this.get(i).getR000000022() == null || this.get(i).getR000000022().equals("null")) {
				pstmt.setString(233,null);
			} else {
				pstmt.setString(233, this.get(i).getR000000022());
			}
			if(this.get(i).getR000000023() == null || this.get(i).getR000000023().equals("null")) {
				pstmt.setString(234,null);
			} else {
				pstmt.setString(234, this.get(i).getR000000023());
			}
			if(this.get(i).getR000000024() == null || this.get(i).getR000000024().equals("null")) {
				pstmt.setString(235,null);
			} else {
				pstmt.setString(235, this.get(i).getR000000024());
			}
			if(this.get(i).getR000000025() == null || this.get(i).getR000000025().equals("null")) {
				pstmt.setString(236,null);
			} else {
				pstmt.setString(236, this.get(i).getR000000025());
			}
			if(this.get(i).getR000000026() == null || this.get(i).getR000000026().equals("null")) {
				pstmt.setString(237,null);
			} else {
				pstmt.setString(237, this.get(i).getR000000026());
			}
			if(this.get(i).getR000000027() == null || this.get(i).getR000000027().equals("null")) {
				pstmt.setString(238,null);
			} else {
				pstmt.setString(238, this.get(i).getR000000027());
			}
			if(this.get(i).getR000000028() == null || this.get(i).getR000000028().equals("null")) {
				pstmt.setString(239,null);
			} else {
				pstmt.setString(239, this.get(i).getR000000028());
			}
			if(this.get(i).getR000000029() == null || this.get(i).getR000000029().equals("null")) {
				pstmt.setString(240,null);
			} else {
				pstmt.setString(240, this.get(i).getR000000029());
			}
			if(this.get(i).getR000000030() == null || this.get(i).getR000000030().equals("null")) {
				pstmt.setString(241,null);
			} else {
				pstmt.setString(241, this.get(i).getR000000030());
			}
			if(this.get(i).getR000000031() == null || this.get(i).getR000000031().equals("null")) {
				pstmt.setString(242,null);
			} else {
				pstmt.setString(242, this.get(i).getR000000031());
			}
			if(this.get(i).getR000000032() == null || this.get(i).getR000000032().equals("null")) {
				pstmt.setString(243,null);
			} else {
				pstmt.setString(243, this.get(i).getR000000032());
			}
			if(this.get(i).getR000000033() == null || this.get(i).getR000000033().equals("null")) {
				pstmt.setString(244,null);
			} else {
				pstmt.setString(244, this.get(i).getR000000033());
			}
			if(this.get(i).getR000000034() == null || this.get(i).getR000000034().equals("null")) {
				pstmt.setString(245,null);
			} else {
				pstmt.setString(245, this.get(i).getR000000034());
			}
			if(this.get(i).getR000000035() == null || this.get(i).getR000000035().equals("null")) {
				pstmt.setString(246,null);
			} else {
				pstmt.setString(246, this.get(i).getR000000035());
			}
			if(this.get(i).getR000000036() == null || this.get(i).getR000000036().equals("null")) {
				pstmt.setString(247,null);
			} else {
				pstmt.setString(247, this.get(i).getR000000036());
			}
			if(this.get(i).getR000000037() == null || this.get(i).getR000000037().equals("null")) {
				pstmt.setString(248,null);
			} else {
				pstmt.setString(248, this.get(i).getR000000037());
			}
			if(this.get(i).getR000000038() == null || this.get(i).getR000000038().equals("null")) {
				pstmt.setString(249,null);
			} else {
				pstmt.setString(249, this.get(i).getR000000038());
			}
			if(this.get(i).getR000000039() == null || this.get(i).getR000000039().equals("null")) {
				pstmt.setString(250,null);
			} else {
				pstmt.setString(250, this.get(i).getR000000039());
			}
			if(this.get(i).getR000000040() == null || this.get(i).getR000000040().equals("null")) {
				pstmt.setString(251,null);
			} else {
				pstmt.setString(251, this.get(i).getR000000040());
			}
			if(this.get(i).getR000000041() == null || this.get(i).getR000000041().equals("null")) {
				pstmt.setString(252,null);
			} else {
				pstmt.setString(252, this.get(i).getR000000041());
			}
			if(this.get(i).getR000000042() == null || this.get(i).getR000000042().equals("null")) {
				pstmt.setString(253,null);
			} else {
				pstmt.setString(253, this.get(i).getR000000042());
			}
			if(this.get(i).getR000000043() == null || this.get(i).getR000000043().equals("null")) {
				pstmt.setString(254,null);
			} else {
				pstmt.setString(254, this.get(i).getR000000043());
			}
			if(this.get(i).getR000000044() == null || this.get(i).getR000000044().equals("null")) {
				pstmt.setString(255,null);
			} else {
				pstmt.setString(255, this.get(i).getR000000044());
			}
			if(this.get(i).getR000000045() == null || this.get(i).getR000000045().equals("null")) {
				pstmt.setString(256,null);
			} else {
				pstmt.setString(256, this.get(i).getR000000045());
			}
			if(this.get(i).getR000000046() == null || this.get(i).getR000000046().equals("null")) {
				pstmt.setString(257,null);
			} else {
				pstmt.setString(257, this.get(i).getR000000046());
			}
			if(this.get(i).getR000000047() == null || this.get(i).getR000000047().equals("null")) {
				pstmt.setString(258,null);
			} else {
				pstmt.setString(258, this.get(i).getR000000047());
			}
			if(this.get(i).getR000000048() == null || this.get(i).getR000000048().equals("null")) {
				pstmt.setString(259,null);
			} else {
				pstmt.setString(259, this.get(i).getR000000048());
			}
			if(this.get(i).getR000000049() == null || this.get(i).getR000000049().equals("null")) {
				pstmt.setString(260,null);
			} else {
				pstmt.setString(260, this.get(i).getR000000049());
			}
			if(this.get(i).getR000000050() == null || this.get(i).getR000000050().equals("null")) {
				pstmt.setString(261,null);
			} else {
				pstmt.setString(261, this.get(i).getR000000050());
			}
			if(this.get(i).getR000000051() == null || this.get(i).getR000000051().equals("null")) {
				pstmt.setString(262,null);
			} else {
				pstmt.setString(262, this.get(i).getR000000051());
			}
			if(this.get(i).getR000000052() == null || this.get(i).getR000000052().equals("null")) {
				pstmt.setString(263,null);
			} else {
				pstmt.setString(263, this.get(i).getR000000052());
			}
			if(this.get(i).getR000000053() == null || this.get(i).getR000000053().equals("null")) {
				pstmt.setString(264,null);
			} else {
				pstmt.setString(264, this.get(i).getR000000053());
			}
			if(this.get(i).getR000000054() == null || this.get(i).getR000000054().equals("null")) {
				pstmt.setString(265,null);
			} else {
				pstmt.setString(265, this.get(i).getR000000054());
			}
			if(this.get(i).getR000000055() == null || this.get(i).getR000000055().equals("null")) {
				pstmt.setString(266,null);
			} else {
				pstmt.setString(266, this.get(i).getR000000055());
			}
			if(this.get(i).getR000000056() == null || this.get(i).getR000000056().equals("null")) {
				pstmt.setString(267,null);
			} else {
				pstmt.setString(267, this.get(i).getR000000056());
			}
			if(this.get(i).getR000000057() == null || this.get(i).getR000000057().equals("null")) {
				pstmt.setString(268,null);
			} else {
				pstmt.setString(268, this.get(i).getR000000057());
			}
			if(this.get(i).getR000000058() == null || this.get(i).getR000000058().equals("null")) {
				pstmt.setString(269,null);
			} else {
				pstmt.setString(269, this.get(i).getR000000058());
			}
			if(this.get(i).getR000000059() == null || this.get(i).getR000000059().equals("null")) {
				pstmt.setString(270,null);
			} else {
				pstmt.setString(270, this.get(i).getR000000059());
			}
			if(this.get(i).getR000000060() == null || this.get(i).getR000000060().equals("null")) {
				pstmt.setString(271,null);
			} else {
				pstmt.setString(271, this.get(i).getR000000060());
			}
			if(this.get(i).getR000000061() == null || this.get(i).getR000000061().equals("null")) {
				pstmt.setString(272,null);
			} else {
				pstmt.setString(272, this.get(i).getR000000061());
			}
			if(this.get(i).getR000000062() == null || this.get(i).getR000000062().equals("null")) {
				pstmt.setString(273,null);
			} else {
				pstmt.setString(273, this.get(i).getR000000062());
			}
			if(this.get(i).getR000000063() == null || this.get(i).getR000000063().equals("null")) {
				pstmt.setString(274,null);
			} else {
				pstmt.setString(274, this.get(i).getR000000063());
			}
			if(this.get(i).getR000000064() == null || this.get(i).getR000000064().equals("null")) {
				pstmt.setString(275,null);
			} else {
				pstmt.setString(275, this.get(i).getR000000064());
			}
			if(this.get(i).getR000000065() == null || this.get(i).getR000000065().equals("null")) {
				pstmt.setString(276,null);
			} else {
				pstmt.setString(276, this.get(i).getR000000065());
			}
			if(this.get(i).getR000000066() == null || this.get(i).getR000000066().equals("null")) {
				pstmt.setString(277,null);
			} else {
				pstmt.setString(277, this.get(i).getR000000066());
			}
			if(this.get(i).getR000000067() == null || this.get(i).getR000000067().equals("null")) {
				pstmt.setString(278,null);
			} else {
				pstmt.setString(278, this.get(i).getR000000067());
			}
			if(this.get(i).getR000000068() == null || this.get(i).getR000000068().equals("null")) {
				pstmt.setString(279,null);
			} else {
				pstmt.setString(279, this.get(i).getR000000068());
			}
			if(this.get(i).getR000000069() == null || this.get(i).getR000000069().equals("null")) {
				pstmt.setString(280,null);
			} else {
				pstmt.setString(280, this.get(i).getR000000069());
			}
			if(this.get(i).getR000000070() == null || this.get(i).getR000000070().equals("null")) {
				pstmt.setString(281,null);
			} else {
				pstmt.setString(281, this.get(i).getR000000070());
			}
			if(this.get(i).getR000000071() == null || this.get(i).getR000000071().equals("null")) {
				pstmt.setString(282,null);
			} else {
				pstmt.setString(282, this.get(i).getR000000071());
			}
			if(this.get(i).getR000000072() == null || this.get(i).getR000000072().equals("null")) {
				pstmt.setString(283,null);
			} else {
				pstmt.setString(283, this.get(i).getR000000072());
			}
			if(this.get(i).getR000000073() == null || this.get(i).getR000000073().equals("null")) {
				pstmt.setString(284,null);
			} else {
				pstmt.setString(284, this.get(i).getR000000073());
			}
			if(this.get(i).getR000000074() == null || this.get(i).getR000000074().equals("null")) {
				pstmt.setString(285,null);
			} else {
				pstmt.setString(285, this.get(i).getR000000074());
			}
			if(this.get(i).getR000000075() == null || this.get(i).getR000000075().equals("null")) {
				pstmt.setString(286,null);
			} else {
				pstmt.setString(286, this.get(i).getR000000075());
			}
			if(this.get(i).getR000000076() == null || this.get(i).getR000000076().equals("null")) {
				pstmt.setString(287,null);
			} else {
				pstmt.setString(287, this.get(i).getR000000076());
			}
			if(this.get(i).getR000000077() == null || this.get(i).getR000000077().equals("null")) {
				pstmt.setString(288,null);
			} else {
				pstmt.setString(288, this.get(i).getR000000077());
			}
			if(this.get(i).getR000000078() == null || this.get(i).getR000000078().equals("null")) {
				pstmt.setString(289,null);
			} else {
				pstmt.setString(289, this.get(i).getR000000078());
			}
			if(this.get(i).getR000000079() == null || this.get(i).getR000000079().equals("null")) {
				pstmt.setString(290,null);
			} else {
				pstmt.setString(290, this.get(i).getR000000079());
			}
			if(this.get(i).getR000000080() == null || this.get(i).getR000000080().equals("null")) {
				pstmt.setString(291,null);
			} else {
				pstmt.setString(291, this.get(i).getR000000080());
			}
			if(this.get(i).getR000000081() == null || this.get(i).getR000000081().equals("null")) {
				pstmt.setString(292,null);
			} else {
				pstmt.setString(292, this.get(i).getR000000081());
			}
			if(this.get(i).getR000000082() == null || this.get(i).getR000000082().equals("null")) {
				pstmt.setString(293,null);
			} else {
				pstmt.setString(293, this.get(i).getR000000082());
			}
			if(this.get(i).getR000000083() == null || this.get(i).getR000000083().equals("null")) {
				pstmt.setString(294,null);
			} else {
				pstmt.setString(294, this.get(i).getR000000083());
			}
			if(this.get(i).getR000000084() == null || this.get(i).getR000000084().equals("null")) {
				pstmt.setString(295,null);
			} else {
				pstmt.setString(295, this.get(i).getR000000084());
			}
			if(this.get(i).getR000000085() == null || this.get(i).getR000000085().equals("null")) {
				pstmt.setString(296,null);
			} else {
				pstmt.setString(296, this.get(i).getR000000085());
			}
			if(this.get(i).getR000000086() == null || this.get(i).getR000000086().equals("null")) {
				pstmt.setString(297,null);
			} else {
				pstmt.setString(297, this.get(i).getR000000086());
			}
			if(this.get(i).getR000000087() == null || this.get(i).getR000000087().equals("null")) {
				pstmt.setString(298,null);
			} else {
				pstmt.setString(298, this.get(i).getR000000087());
			}
			if(this.get(i).getR000000088() == null || this.get(i).getR000000088().equals("null")) {
				pstmt.setString(299,null);
			} else {
				pstmt.setString(299, this.get(i).getR000000088());
			}
			if(this.get(i).getR000000089() == null || this.get(i).getR000000089().equals("null")) {
				pstmt.setString(300,null);
			} else {
				pstmt.setString(300, this.get(i).getR000000089());
			}
			if(this.get(i).getR000000090() == null || this.get(i).getR000000090().equals("null")) {
				pstmt.setString(301,null);
			} else {
				pstmt.setString(301, this.get(i).getR000000090());
			}
			if(this.get(i).getR000000091() == null || this.get(i).getR000000091().equals("null")) {
				pstmt.setString(302,null);
			} else {
				pstmt.setString(302, this.get(i).getR000000091());
			}
			if(this.get(i).getR000000092() == null || this.get(i).getR000000092().equals("null")) {
				pstmt.setString(303,null);
			} else {
				pstmt.setString(303, this.get(i).getR000000092());
			}
			if(this.get(i).getR000000093() == null || this.get(i).getR000000093().equals("null")) {
				pstmt.setString(304,null);
			} else {
				pstmt.setString(304, this.get(i).getR000000093());
			}
			if(this.get(i).getR000000094() == null || this.get(i).getR000000094().equals("null")) {
				pstmt.setString(305,null);
			} else {
				pstmt.setString(305, this.get(i).getR000000094());
			}
			if(this.get(i).getR000000095() == null || this.get(i).getR000000095().equals("null")) {
				pstmt.setString(306,null);
			} else {
				pstmt.setString(306, this.get(i).getR000000095());
			}
			if(this.get(i).getR000000096() == null || this.get(i).getR000000096().equals("null")) {
				pstmt.setString(307,null);
			} else {
				pstmt.setString(307, this.get(i).getR000000096());
			}
			if(this.get(i).getR000000097() == null || this.get(i).getR000000097().equals("null")) {
				pstmt.setString(308,null);
			} else {
				pstmt.setString(308, this.get(i).getR000000097());
			}
			if(this.get(i).getR000000098() == null || this.get(i).getR000000098().equals("null")) {
				pstmt.setString(309,null);
			} else {
				pstmt.setString(309, this.get(i).getR000000098());
			}
			if(this.get(i).getR000000099() == null || this.get(i).getR000000099().equals("null")) {
				pstmt.setString(310,null);
			} else {
				pstmt.setString(310, this.get(i).getR000000099());
			}
			if(this.get(i).getR000000100() == null || this.get(i).getR000000100().equals("null")) {
				pstmt.setString(311,null);
			} else {
				pstmt.setString(311, this.get(i).getR000000100());
			}
			if(this.get(i).getR000000101() == null || this.get(i).getR000000101().equals("null")) {
				pstmt.setString(312,null);
			} else {
				pstmt.setString(312, this.get(i).getR000000101());
			}
			if(this.get(i).getR000000102() == null || this.get(i).getR000000102().equals("null")) {
				pstmt.setString(313,null);
			} else {
				pstmt.setString(313, this.get(i).getR000000102());
			}
			if(this.get(i).getR000000103() == null || this.get(i).getR000000103().equals("null")) {
				pstmt.setString(314,null);
			} else {
				pstmt.setString(314, this.get(i).getR000000103());
			}
			if(this.get(i).getR000000104() == null || this.get(i).getR000000104().equals("null")) {
				pstmt.setString(315,null);
			} else {
				pstmt.setString(315, this.get(i).getR000000104());
			}
			if(this.get(i).getR000000105() == null || this.get(i).getR000000105().equals("null")) {
				pstmt.setString(316,null);
			} else {
				pstmt.setString(316, this.get(i).getR000000105());
			}
			if(this.get(i).getR000000106() == null || this.get(i).getR000000106().equals("null")) {
				pstmt.setString(317,null);
			} else {
				pstmt.setString(317, this.get(i).getR000000106());
			}
			if(this.get(i).getR000000107() == null || this.get(i).getR000000107().equals("null")) {
				pstmt.setString(318,null);
			} else {
				pstmt.setString(318, this.get(i).getR000000107());
			}
			if(this.get(i).getR000000108() == null || this.get(i).getR000000108().equals("null")) {
				pstmt.setString(319,null);
			} else {
				pstmt.setString(319, this.get(i).getR000000108());
			}
			if(this.get(i).getR000000109() == null || this.get(i).getR000000109().equals("null")) {
				pstmt.setString(320,null);
			} else {
				pstmt.setString(320, this.get(i).getR000000109());
			}
			if(this.get(i).getR000000110() == null || this.get(i).getR000000110().equals("null")) {
				pstmt.setString(321,null);
			} else {
				pstmt.setString(321, this.get(i).getR000000110());
			}
			if(this.get(i).getR000000111() == null || this.get(i).getR000000111().equals("null")) {
				pstmt.setString(322,null);
			} else {
				pstmt.setString(322, this.get(i).getR000000111());
			}
			if(this.get(i).getR000000112() == null || this.get(i).getR000000112().equals("null")) {
				pstmt.setString(323,null);
			} else {
				pstmt.setString(323, this.get(i).getR000000112());
			}
			if(this.get(i).getR000000113() == null || this.get(i).getR000000113().equals("null")) {
				pstmt.setString(324,null);
			} else {
				pstmt.setString(324, this.get(i).getR000000113());
			}
			if(this.get(i).getR000000114() == null || this.get(i).getR000000114().equals("null")) {
				pstmt.setString(325,null);
			} else {
				pstmt.setString(325, this.get(i).getR000000114());
			}
			if(this.get(i).getR000000115() == null || this.get(i).getR000000115().equals("null")) {
				pstmt.setString(326,null);
			} else {
				pstmt.setString(326, this.get(i).getR000000115());
			}
			if(this.get(i).getR000000116() == null || this.get(i).getR000000116().equals("null")) {
				pstmt.setString(327,null);
			} else {
				pstmt.setString(327, this.get(i).getR000000116());
			}
			if(this.get(i).getR000000117() == null || this.get(i).getR000000117().equals("null")) {
				pstmt.setString(328,null);
			} else {
				pstmt.setString(328, this.get(i).getR000000117());
			}
			if(this.get(i).getR000000118() == null || this.get(i).getR000000118().equals("null")) {
				pstmt.setString(329,null);
			} else {
				pstmt.setString(329, this.get(i).getR000000118());
			}
			if(this.get(i).getR000000119() == null || this.get(i).getR000000119().equals("null")) {
				pstmt.setString(330,null);
			} else {
				pstmt.setString(330, this.get(i).getR000000119());
			}
			if(this.get(i).getR000000120() == null || this.get(i).getR000000120().equals("null")) {
				pstmt.setString(331,null);
			} else {
				pstmt.setString(331, this.get(i).getR000000120());
			}
			if(this.get(i).getR000000121() == null || this.get(i).getR000000121().equals("null")) {
				pstmt.setString(332,null);
			} else {
				pstmt.setString(332, this.get(i).getR000000121());
			}
			if(this.get(i).getR000000122() == null || this.get(i).getR000000122().equals("null")) {
				pstmt.setString(333,null);
			} else {
				pstmt.setString(333, this.get(i).getR000000122());
			}
			if(this.get(i).getR000000123() == null || this.get(i).getR000000123().equals("null")) {
				pstmt.setString(334,null);
			} else {
				pstmt.setString(334, this.get(i).getR000000123());
			}
			if(this.get(i).getR000000124() == null || this.get(i).getR000000124().equals("null")) {
				pstmt.setString(335,null);
			} else {
				pstmt.setString(335, this.get(i).getR000000124());
			}
			if(this.get(i).getR000000125() == null || this.get(i).getR000000125().equals("null")) {
				pstmt.setString(336,null);
			} else {
				pstmt.setString(336, this.get(i).getR000000125());
			}
			if(this.get(i).getR000000126() == null || this.get(i).getR000000126().equals("null")) {
				pstmt.setString(337,null);
			} else {
				pstmt.setString(337, this.get(i).getR000000126());
			}
			if(this.get(i).getR000000127() == null || this.get(i).getR000000127().equals("null")) {
				pstmt.setString(338,null);
			} else {
				pstmt.setString(338, this.get(i).getR000000127());
			}
			if(this.get(i).getR000000128() == null || this.get(i).getR000000128().equals("null")) {
				pstmt.setString(339,null);
			} else {
				pstmt.setString(339, this.get(i).getR000000128());
			}
			if(this.get(i).getR000000129() == null || this.get(i).getR000000129().equals("null")) {
				pstmt.setString(340,null);
			} else {
				pstmt.setString(340, this.get(i).getR000000129());
			}
			if(this.get(i).getR000000130() == null || this.get(i).getR000000130().equals("null")) {
				pstmt.setString(341,null);
			} else {
				pstmt.setString(341, this.get(i).getR000000130());
			}
			if(this.get(i).getR000000131() == null || this.get(i).getR000000131().equals("null")) {
				pstmt.setString(342,null);
			} else {
				pstmt.setString(342, this.get(i).getR000000131());
			}
			if(this.get(i).getR000000132() == null || this.get(i).getR000000132().equals("null")) {
				pstmt.setString(343,null);
			} else {
				pstmt.setString(343, this.get(i).getR000000132());
			}
			if(this.get(i).getR000000133() == null || this.get(i).getR000000133().equals("null")) {
				pstmt.setString(344,null);
			} else {
				pstmt.setString(344, this.get(i).getR000000133());
			}
			if(this.get(i).getR000000134() == null || this.get(i).getR000000134().equals("null")) {
				pstmt.setString(345,null);
			} else {
				pstmt.setString(345, this.get(i).getR000000134());
			}
			if(this.get(i).getR000000135() == null || this.get(i).getR000000135().equals("null")) {
				pstmt.setString(346,null);
			} else {
				pstmt.setString(346, this.get(i).getR000000135());
			}
			if(this.get(i).getR000000136() == null || this.get(i).getR000000136().equals("null")) {
				pstmt.setString(347,null);
			} else {
				pstmt.setString(347, this.get(i).getR000000136());
			}
			if(this.get(i).getR000000137() == null || this.get(i).getR000000137().equals("null")) {
				pstmt.setString(348,null);
			} else {
				pstmt.setString(348, this.get(i).getR000000137());
			}
			if(this.get(i).getR000000138() == null || this.get(i).getR000000138().equals("null")) {
				pstmt.setString(349,null);
			} else {
				pstmt.setString(349, this.get(i).getR000000138());
			}
			if(this.get(i).getR000000139() == null || this.get(i).getR000000139().equals("null")) {
				pstmt.setString(350,null);
			} else {
				pstmt.setString(350, this.get(i).getR000000139());
			}
			if(this.get(i).getR000000140() == null || this.get(i).getR000000140().equals("null")) {
				pstmt.setString(351,null);
			} else {
				pstmt.setString(351, this.get(i).getR000000140());
			}
			if(this.get(i).getR000000141() == null || this.get(i).getR000000141().equals("null")) {
				pstmt.setString(352,null);
			} else {
				pstmt.setString(352, this.get(i).getR000000141());
			}
			if(this.get(i).getR000000142() == null || this.get(i).getR000000142().equals("null")) {
				pstmt.setString(353,null);
			} else {
				pstmt.setString(353, this.get(i).getR000000142());
			}
			if(this.get(i).getR000000143() == null || this.get(i).getR000000143().equals("null")) {
				pstmt.setString(354,null);
			} else {
				pstmt.setString(354, this.get(i).getR000000143());
			}
			if(this.get(i).getR000000144() == null || this.get(i).getR000000144().equals("null")) {
				pstmt.setString(355,null);
			} else {
				pstmt.setString(355, this.get(i).getR000000144());
			}
			if(this.get(i).getR000000145() == null || this.get(i).getR000000145().equals("null")) {
				pstmt.setString(356,null);
			} else {
				pstmt.setString(356, this.get(i).getR000000145());
			}
			if(this.get(i).getR000000146() == null || this.get(i).getR000000146().equals("null")) {
				pstmt.setString(357,null);
			} else {
				pstmt.setString(357, this.get(i).getR000000146());
			}
			if(this.get(i).getR000000147() == null || this.get(i).getR000000147().equals("null")) {
				pstmt.setString(358,null);
			} else {
				pstmt.setString(358, this.get(i).getR000000147());
			}
			if(this.get(i).getR000000148() == null || this.get(i).getR000000148().equals("null")) {
				pstmt.setString(359,null);
			} else {
				pstmt.setString(359, this.get(i).getR000000148());
			}
			if(this.get(i).getR000000149() == null || this.get(i).getR000000149().equals("null")) {
				pstmt.setString(360,null);
			} else {
				pstmt.setString(360, this.get(i).getR000000149());
			}
			if(this.get(i).getR000000150() == null || this.get(i).getR000000150().equals("null")) {
				pstmt.setString(361,null);
			} else {
				pstmt.setString(361, this.get(i).getR000000150());
			}
			if(this.get(i).getR000000151() == null || this.get(i).getR000000151().equals("null")) {
				pstmt.setString(362,null);
			} else {
				pstmt.setString(362, this.get(i).getR000000151());
			}
			if(this.get(i).getR000000152() == null || this.get(i).getR000000152().equals("null")) {
				pstmt.setString(363,null);
			} else {
				pstmt.setString(363, this.get(i).getR000000152());
			}
			if(this.get(i).getR000000153() == null || this.get(i).getR000000153().equals("null")) {
				pstmt.setString(364,null);
			} else {
				pstmt.setString(364, this.get(i).getR000000153());
			}
			if(this.get(i).getR000000154() == null || this.get(i).getR000000154().equals("null")) {
				pstmt.setString(365,null);
			} else {
				pstmt.setString(365, this.get(i).getR000000154());
			}
			if(this.get(i).getR000000155() == null || this.get(i).getR000000155().equals("null")) {
				pstmt.setString(366,null);
			} else {
				pstmt.setString(366, this.get(i).getR000000155());
			}
			if(this.get(i).getR000000156() == null || this.get(i).getR000000156().equals("null")) {
				pstmt.setString(367,null);
			} else {
				pstmt.setString(367, this.get(i).getR000000156());
			}
			if(this.get(i).getR000000157() == null || this.get(i).getR000000157().equals("null")) {
				pstmt.setString(368,null);
			} else {
				pstmt.setString(368, this.get(i).getR000000157());
			}
			if(this.get(i).getR000000158() == null || this.get(i).getR000000158().equals("null")) {
				pstmt.setString(369,null);
			} else {
				pstmt.setString(369, this.get(i).getR000000158());
			}
			if(this.get(i).getR000000159() == null || this.get(i).getR000000159().equals("null")) {
				pstmt.setString(370,null);
			} else {
				pstmt.setString(370, this.get(i).getR000000159());
			}
			if(this.get(i).getR000000160() == null || this.get(i).getR000000160().equals("null")) {
				pstmt.setString(371,null);
			} else {
				pstmt.setString(371, this.get(i).getR000000160());
			}
			if(this.get(i).getR000000161() == null || this.get(i).getR000000161().equals("null")) {
				pstmt.setString(372,null);
			} else {
				pstmt.setString(372, this.get(i).getR000000161());
			}
			if(this.get(i).getR000000162() == null || this.get(i).getR000000162().equals("null")) {
				pstmt.setString(373,null);
			} else {
				pstmt.setString(373, this.get(i).getR000000162());
			}
			if(this.get(i).getR000000163() == null || this.get(i).getR000000163().equals("null")) {
				pstmt.setString(374,null);
			} else {
				pstmt.setString(374, this.get(i).getR000000163());
			}
			if(this.get(i).getR000000164() == null || this.get(i).getR000000164().equals("null")) {
				pstmt.setString(375,null);
			} else {
				pstmt.setString(375, this.get(i).getR000000164());
			}
			if(this.get(i).getR000000165() == null || this.get(i).getR000000165().equals("null")) {
				pstmt.setString(376,null);
			} else {
				pstmt.setString(376, this.get(i).getR000000165());
			}
			if(this.get(i).getR000000166() == null || this.get(i).getR000000166().equals("null")) {
				pstmt.setString(377,null);
			} else {
				pstmt.setString(377, this.get(i).getR000000166());
			}
			if(this.get(i).getR000000167() == null || this.get(i).getR000000167().equals("null")) {
				pstmt.setString(378,null);
			} else {
				pstmt.setString(378, this.get(i).getR000000167());
			}
			if(this.get(i).getR000000168() == null || this.get(i).getR000000168().equals("null")) {
				pstmt.setString(379,null);
			} else {
				pstmt.setString(379, this.get(i).getR000000168());
			}
			if(this.get(i).getR000000169() == null || this.get(i).getR000000169().equals("null")) {
				pstmt.setString(380,null);
			} else {
				pstmt.setString(380, this.get(i).getR000000169());
			}
			if(this.get(i).getR000000170() == null || this.get(i).getR000000170().equals("null")) {
				pstmt.setString(381,null);
			} else {
				pstmt.setString(381, this.get(i).getR000000170());
			}
			if(this.get(i).getR000000171() == null || this.get(i).getR000000171().equals("null")) {
				pstmt.setString(382,null);
			} else {
				pstmt.setString(382, this.get(i).getR000000171());
			}
			if(this.get(i).getR000000172() == null || this.get(i).getR000000172().equals("null")) {
				pstmt.setString(383,null);
			} else {
				pstmt.setString(383, this.get(i).getR000000172());
			}
			if(this.get(i).getR000000173() == null || this.get(i).getR000000173().equals("null")) {
				pstmt.setString(384,null);
			} else {
				pstmt.setString(384, this.get(i).getR000000173());
			}
			if(this.get(i).getR000000174() == null || this.get(i).getR000000174().equals("null")) {
				pstmt.setString(385,null);
			} else {
				pstmt.setString(385, this.get(i).getR000000174());
			}
			if(this.get(i).getR000000175() == null || this.get(i).getR000000175().equals("null")) {
				pstmt.setString(386,null);
			} else {
				pstmt.setString(386, this.get(i).getR000000175());
			}
			if(this.get(i).getR000000176() == null || this.get(i).getR000000176().equals("null")) {
				pstmt.setString(387,null);
			} else {
				pstmt.setString(387, this.get(i).getR000000176());
			}
			if(this.get(i).getR000000177() == null || this.get(i).getR000000177().equals("null")) {
				pstmt.setString(388,null);
			} else {
				pstmt.setString(388, this.get(i).getR000000177());
			}
			if(this.get(i).getR000000178() == null || this.get(i).getR000000178().equals("null")) {
				pstmt.setString(389,null);
			} else {
				pstmt.setString(389, this.get(i).getR000000178());
			}
			if(this.get(i).getR000000179() == null || this.get(i).getR000000179().equals("null")) {
				pstmt.setString(390,null);
			} else {
				pstmt.setString(390, this.get(i).getR000000179());
			}
			if(this.get(i).getR000000180() == null || this.get(i).getR000000180().equals("null")) {
				pstmt.setString(391,null);
			} else {
				pstmt.setString(391, this.get(i).getR000000180());
			}
			if(this.get(i).getR000000181() == null || this.get(i).getR000000181().equals("null")) {
				pstmt.setString(392,null);
			} else {
				pstmt.setString(392, this.get(i).getR000000181());
			}
			if(this.get(i).getR000000182() == null || this.get(i).getR000000182().equals("null")) {
				pstmt.setString(393,null);
			} else {
				pstmt.setString(393, this.get(i).getR000000182());
			}
			if(this.get(i).getR000000183() == null || this.get(i).getR000000183().equals("null")) {
				pstmt.setString(394,null);
			} else {
				pstmt.setString(394, this.get(i).getR000000183());
			}
			if(this.get(i).getR000000184() == null || this.get(i).getR000000184().equals("null")) {
				pstmt.setString(395,null);
			} else {
				pstmt.setString(395, this.get(i).getR000000184());
			}
			if(this.get(i).getR000000185() == null || this.get(i).getR000000185().equals("null")) {
				pstmt.setString(396,null);
			} else {
				pstmt.setString(396, this.get(i).getR000000185());
			}
			if(this.get(i).getR000000186() == null || this.get(i).getR000000186().equals("null")) {
				pstmt.setString(397,null);
			} else {
				pstmt.setString(397, this.get(i).getR000000186());
			}
			if(this.get(i).getR000000187() == null || this.get(i).getR000000187().equals("null")) {
				pstmt.setString(398,null);
			} else {
				pstmt.setString(398, this.get(i).getR000000187());
			}
			if(this.get(i).getR000000188() == null || this.get(i).getR000000188().equals("null")) {
				pstmt.setString(399,null);
			} else {
				pstmt.setString(399, this.get(i).getR000000188());
			}
			if(this.get(i).getR000000189() == null || this.get(i).getR000000189().equals("null")) {
				pstmt.setString(400,null);
			} else {
				pstmt.setString(400, this.get(i).getR000000189());
			}
			if(this.get(i).getR000000190() == null || this.get(i).getR000000190().equals("null")) {
				pstmt.setString(401,null);
			} else {
				pstmt.setString(401, this.get(i).getR000000190());
			}
			if(this.get(i).getR000000191() == null || this.get(i).getR000000191().equals("null")) {
				pstmt.setString(402,null);
			} else {
				pstmt.setString(402, this.get(i).getR000000191());
			}
			if(this.get(i).getR000000192() == null || this.get(i).getR000000192().equals("null")) {
				pstmt.setString(403,null);
			} else {
				pstmt.setString(403, this.get(i).getR000000192());
			}
			if(this.get(i).getR000000193() == null || this.get(i).getR000000193().equals("null")) {
				pstmt.setString(404,null);
			} else {
				pstmt.setString(404, this.get(i).getR000000193());
			}
			if(this.get(i).getR000000194() == null || this.get(i).getR000000194().equals("null")) {
				pstmt.setString(405,null);
			} else {
				pstmt.setString(405, this.get(i).getR000000194());
			}
			if(this.get(i).getR000000195() == null || this.get(i).getR000000195().equals("null")) {
				pstmt.setString(406,null);
			} else {
				pstmt.setString(406, this.get(i).getR000000195());
			}
			if(this.get(i).getR000000196() == null || this.get(i).getR000000196().equals("null")) {
				pstmt.setString(407,null);
			} else {
				pstmt.setString(407, this.get(i).getR000000196());
			}
			if(this.get(i).getR000000197() == null || this.get(i).getR000000197().equals("null")) {
				pstmt.setString(408,null);
			} else {
				pstmt.setString(408, this.get(i).getR000000197());
			}
			if(this.get(i).getR000000198() == null || this.get(i).getR000000198().equals("null")) {
				pstmt.setString(409,null);
			} else {
				pstmt.setString(409, this.get(i).getR000000198());
			}
			if(this.get(i).getR000000199() == null || this.get(i).getR000000199().equals("null")) {
				pstmt.setString(410,null);
			} else {
				pstmt.setString(410, this.get(i).getR000000199());
			}
			if(this.get(i).getR000000200() == null || this.get(i).getR000000200().equals("null")) {
				pstmt.setString(411,null);
			} else {
				pstmt.setString(411, this.get(i).getR000000200());
			}
			if(this.get(i).getI000000201() == null || this.get(i).getI000000201().equals("null")) {
				pstmt.setString(412,null);
			} else {
				pstmt.setString(412, this.get(i).getI000000201());
			}
			if(this.get(i).getI000000202() == null || this.get(i).getI000000202().equals("null")) {
				pstmt.setString(413,null);
			} else {
				pstmt.setString(413, this.get(i).getI000000202());
			}
			if(this.get(i).getI000000203() == null || this.get(i).getI000000203().equals("null")) {
				pstmt.setString(414,null);
			} else {
				pstmt.setString(414, this.get(i).getI000000203());
			}
			if(this.get(i).getI000000209() == null || this.get(i).getI000000209().equals("null")) {
				pstmt.setString(415,null);
			} else {
				pstmt.setString(415, this.get(i).getI000000209());
			}
			if(this.get(i).getI000000210() == null || this.get(i).getI000000210().equals("null")) {
				pstmt.setString(416,null);
			} else {
				pstmt.setString(416, this.get(i).getI000000210());
			}
			if(this.get(i).getI000000213() == null || this.get(i).getI000000213().equals("null")) {
				pstmt.setString(417,null);
			} else {
				pstmt.setString(417, this.get(i).getI000000213());
			}
			if(this.get(i).getI000000214() == null || this.get(i).getI000000214().equals("null")) {
				pstmt.setString(418,null);
			} else {
				pstmt.setString(418, this.get(i).getI000000214());
			}
			if(this.get(i).getI000000215() == null || this.get(i).getI000000215().equals("null")) {
				pstmt.setString(419,null);
			} else {
				pstmt.setString(419, this.get(i).getI000000215());
			}
			if(this.get(i).getI000000216() == null || this.get(i).getI000000216().equals("null")) {
				pstmt.setString(420,null);
			} else {
				pstmt.setString(420, this.get(i).getI000000216());
			}
			if(this.get(i).getI000000217() == null || this.get(i).getI000000217().equals("null")) {
				pstmt.setString(421,null);
			} else {
				pstmt.setString(421, this.get(i).getI000000217());
			}
			if(this.get(i).getI000000218() == null || this.get(i).getI000000218().equals("null")) {
				pstmt.setString(422,null);
			} else {
				pstmt.setString(422, this.get(i).getI000000218());
			}
			if(this.get(i).getI000000219() == null || this.get(i).getI000000219().equals("null")) {
				pstmt.setString(423,null);
			} else {
				pstmt.setString(423, this.get(i).getI000000219());
			}
			if(this.get(i).getI000000220() == null || this.get(i).getI000000220().equals("null")) {
				pstmt.setString(424,null);
			} else {
				pstmt.setString(424, this.get(i).getI000000220());
			}
			if(this.get(i).getI000000221() == null || this.get(i).getI000000221().equals("null")) {
				pstmt.setString(425,null);
			} else {
				pstmt.setString(425, this.get(i).getI000000221());
			}
			if(this.get(i).getI000000222() == null || this.get(i).getI000000222().equals("null")) {
				pstmt.setString(426,null);
			} else {
				pstmt.setString(426, this.get(i).getI000000222());
			}
			if(this.get(i).getI000000224() == null || this.get(i).getI000000224().equals("null")) {
				pstmt.setString(427,null);
			} else {
				pstmt.setString(427, this.get(i).getI000000224());
			}
			if(this.get(i).getI000000225() == null || this.get(i).getI000000225().equals("null")) {
				pstmt.setString(428,null);
			} else {
				pstmt.setString(428, this.get(i).getI000000225());
			}
			if(this.get(i).getI000000226() == null || this.get(i).getI000000226().equals("null")) {
				pstmt.setString(429,null);
			} else {
				pstmt.setString(429, this.get(i).getI000000226());
			}
			if(this.get(i).getI000000227() == null || this.get(i).getI000000227().equals("null")) {
				pstmt.setString(430,null);
			} else {
				pstmt.setString(430, this.get(i).getI000000227());
			}
			if(this.get(i).getI000000228() == null || this.get(i).getI000000228().equals("null")) {
				pstmt.setString(431,null);
			} else {
				pstmt.setString(431, this.get(i).getI000000228());
			}
			if(this.get(i).getI000000229() == null || this.get(i).getI000000229().equals("null")) {
				pstmt.setString(432,null);
			} else {
				pstmt.setString(432, this.get(i).getI000000229());
			}
			if(this.get(i).getI000000231() == null || this.get(i).getI000000231().equals("null")) {
				pstmt.setString(433,null);
			} else {
				pstmt.setString(433, this.get(i).getI000000231());
			}
			if(this.get(i).getI000000232() == null || this.get(i).getI000000232().equals("null")) {
				pstmt.setString(434,null);
			} else {
				pstmt.setString(434, this.get(i).getI000000232());
			}
			if(this.get(i).getI000000233() == null || this.get(i).getI000000233().equals("null")) {
				pstmt.setString(435,null);
			} else {
				pstmt.setString(435, this.get(i).getI000000233());
			}
			if(this.get(i).getI000000234() == null || this.get(i).getI000000234().equals("null")) {
				pstmt.setString(436,null);
			} else {
				pstmt.setString(436, this.get(i).getI000000234());
			}
			if(this.get(i).getI000000235() == null || this.get(i).getI000000235().equals("null")) {
				pstmt.setString(437,null);
			} else {
				pstmt.setString(437, this.get(i).getI000000235());
			}
			if(this.get(i).getI000000236() == null || this.get(i).getI000000236().equals("null")) {
				pstmt.setString(438,null);
			} else {
				pstmt.setString(438, this.get(i).getI000000236());
			}
			if(this.get(i).getI000000237() == null || this.get(i).getI000000237().equals("null")) {
				pstmt.setString(439,null);
			} else {
				pstmt.setString(439, this.get(i).getI000000237());
			}
			if(this.get(i).getI000000240() == null || this.get(i).getI000000240().equals("null")) {
				pstmt.setString(440,null);
			} else {
				pstmt.setString(440, this.get(i).getI000000240());
			}
			if(this.get(i).getI000000241() == null || this.get(i).getI000000241().equals("null")) {
				pstmt.setString(441,null);
			} else {
				pstmt.setString(441, this.get(i).getI000000241());
			}
			if(this.get(i).getI000000242() == null || this.get(i).getI000000242().equals("null")) {
				pstmt.setString(442,null);
			} else {
				pstmt.setString(442, this.get(i).getI000000242());
			}
			if(this.get(i).getI000000243() == null || this.get(i).getI000000243().equals("null")) {
				pstmt.setString(443,null);
			} else {
				pstmt.setString(443, this.get(i).getI000000243());
			}
			if(this.get(i).getI000000244() == null || this.get(i).getI000000244().equals("null")) {
				pstmt.setString(444,null);
			} else {
				pstmt.setString(444, this.get(i).getI000000244());
			}
			if(this.get(i).getI000000245() == null || this.get(i).getI000000245().equals("null")) {
				pstmt.setString(445,null);
			} else {
				pstmt.setString(445, this.get(i).getI000000245());
			}
			if(this.get(i).getI000000246() == null || this.get(i).getI000000246().equals("null")) {
				pstmt.setString(446,null);
			} else {
				pstmt.setString(446, this.get(i).getI000000246());
			}
			if(this.get(i).getI000000247() == null || this.get(i).getI000000247().equals("null")) {
				pstmt.setString(447,null);
			} else {
				pstmt.setString(447, this.get(i).getI000000247());
			}
			if(this.get(i).getI000000248() == null || this.get(i).getI000000248().equals("null")) {
				pstmt.setString(448,null);
			} else {
				pstmt.setString(448, this.get(i).getI000000248());
			}
			if(this.get(i).getI000000249() == null || this.get(i).getI000000249().equals("null")) {
				pstmt.setString(449,null);
			} else {
				pstmt.setString(449, this.get(i).getI000000249());
			}
			if(this.get(i).getI000000250() == null || this.get(i).getI000000250().equals("null")) {
				pstmt.setString(450,null);
			} else {
				pstmt.setString(450, this.get(i).getI000000250());
			}
			if(this.get(i).getI000000251() == null || this.get(i).getI000000251().equals("null")) {
				pstmt.setString(451,null);
			} else {
				pstmt.setString(451, this.get(i).getI000000251());
			}
			if(this.get(i).getR000000201() == null || this.get(i).getR000000201().equals("null")) {
				pstmt.setString(452,null);
			} else {
				pstmt.setString(452, this.get(i).getR000000201());
			}
			if(this.get(i).getR000000202() == null || this.get(i).getR000000202().equals("null")) {
				pstmt.setString(453,null);
			} else {
				pstmt.setString(453, this.get(i).getR000000202());
			}
			if(this.get(i).getR000000203() == null || this.get(i).getR000000203().equals("null")) {
				pstmt.setString(454,null);
			} else {
				pstmt.setString(454, this.get(i).getR000000203());
			}
			if(this.get(i).getR000000204() == null || this.get(i).getR000000204().equals("null")) {
				pstmt.setString(455,null);
			} else {
				pstmt.setString(455, this.get(i).getR000000204());
			}
			if(this.get(i).getR000000205() == null || this.get(i).getR000000205().equals("null")) {
				pstmt.setString(456,null);
			} else {
				pstmt.setString(456, this.get(i).getR000000205());
			}
			if(this.get(i).getI000000254() == null || this.get(i).getI000000254().equals("null")) {
				pstmt.setString(457,null);
			} else {
				pstmt.setString(457, this.get(i).getI000000254());
			}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAIndexInfoV");
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
			tError.moduleName = "LAIndexInfoVDBSet";
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
