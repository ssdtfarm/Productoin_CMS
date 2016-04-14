/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.lis.schema.LAIndexInfoVTempSchema;
import com.sinosoft.lis.vschema.LAIndexInfoVTempSet;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: LAIndexInfoVTempDB </p>
 * <p>Description: DB层数据库操作类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: PhysicalDataModel_1
 */
public class LAIndexInfoVTempDB extends LAIndexInfoVTempSchema
{
	// @Field
	private Connection con;
	private DBOper db;
	/**
	* flag = true: 传入Connection
	* flag = false: 不传入Connection
	**/
	private boolean mflag = false;

	public CErrors mErrors = new CErrors();		// 错误信息

	/**
	 * 为批量操作而准备的语句和游标对象
	 */
	private ResultSet mResultSet = null;
	private Statement mStatement = null;
	// @Constructor
	public LAIndexInfoVTempDB( Connection tConnection )
	{
		con = tConnection;
		db = new DBOper( con, "LAIndexInfoVTemp" );
		mflag = true;
	}

	public LAIndexInfoVTempDB()
	{
		con = null;
		db = new DBOper( "LAIndexInfoVTemp" );
		mflag = false;
	}

	// @Method
	public boolean deleteSQL()
	{
		LAIndexInfoVTempSchema tSchema = this.getSchema();
		if (db.deleteSQL(tSchema))
		{
		     return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LAIndexInfoVTempSchema tSchema = this.getSchema();

		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			this.mErrors .addOneError(tError);

			return -1;
		}

		return tCount;
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
			pstmt = con.prepareStatement("DELETE FROM LAIndexInfoVTemp WHERE  WageNo = ? AND IndexType = ? AND AgentCode = ?");
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAIndexInfoVTemp");
		sqlObj.setSQL(4, this);
		sqlObj.getSQL();

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAIndexInfoVTemp");
		sqlObj.setSQL(2, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("UPDATE LAIndexInfoVTemp SET  WageNo = ? , BranchType = ? , IndexType = ? , AgentCode = ? , AgentGrade = ? , AgentGroup = ? , State = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , I000000001 = ? , I000000002 = ? , I000000003 = ? , I000000004 = ? , I000000005 = ? , I000000006 = ? , I000000007 = ? , I000000008 = ? , I000000009 = ? , I000000010 = ? , I000000011 = ? , I000000012 = ? , I000000013 = ? , I000000014 = ? , I000000015 = ? , I000000016 = ? , I000000017 = ? , I000000018 = ? , I000000019 = ? , I000000020 = ? , I000000021 = ? , I000000022 = ? , I000000023 = ? , I000000024 = ? , I000000025 = ? , I000000026 = ? , I000000027 = ? , I000000028 = ? , I000000029 = ? , I000000030 = ? , I000000031 = ? , I000000032 = ? , I000000033 = ? , I000000034 = ? , I000000035 = ? , I000000036 = ? , I000000037 = ? , I000000038 = ? , I000000039 = ? , I000000040 = ? , I000000041 = ? , I000000042 = ? , I000000043 = ? , I000000044 = ? , I000000045 = ? , I000000046 = ? , I000000047 = ? , I000000048 = ? , I000000049 = ? , I000000050 = ? , I000000051 = ? , I000000052 = ? , I000000053 = ? , I000000054 = ? , I000000055 = ? , I000000056 = ? , I000000057 = ? , I000000058 = ? , I000000059 = ? , I000000060 = ? , I000000061 = ? , I000000062 = ? , I000000063 = ? , I000000064 = ? , I000000065 = ? , I000000066 = ? , I000000067 = ? , I000000068 = ? , I000000069 = ? , I000000070 = ? , I000000071 = ? , I000000072 = ? , I000000073 = ? , I000000074 = ? , I000000075 = ? , I000000076 = ? , I000000077 = ? , I000000078 = ? , I000000079 = ? , I000000080 = ? , I000000081 = ? , I000000082 = ? , I000000083 = ? , I000000084 = ? , I000000085 = ? , I000000086 = ? , I000000087 = ? , I000000088 = ? , I000000089 = ? , I000000090 = ? , I000000091 = ? , I000000092 = ? , I000000093 = ? , I000000094 = ? , I000000095 = ? , I000000096 = ? , I000000097 = ? , I000000098 = ? , I000000099 = ? , I000000100 = ? , I000000101 = ? , I000000102 = ? , I000000103 = ? , I000000104 = ? , I000000105 = ? , I000000106 = ? , I000000107 = ? , I000000108 = ? , I000000109 = ? , I000000110 = ? , I000000111 = ? , I000000112 = ? , I000000113 = ? , I000000114 = ? , I000000115 = ? , I000000116 = ? , I000000117 = ? , I000000118 = ? , I000000119 = ? , I000000120 = ? , I000000121 = ? , I000000122 = ? , I000000123 = ? , I000000124 = ? , I000000125 = ? , I000000126 = ? , I000000127 = ? , I000000128 = ? , I000000129 = ? , I000000130 = ? , I000000131 = ? , I000000132 = ? , I000000133 = ? , I000000134 = ? , I000000135 = ? , I000000136 = ? , I000000137 = ? , I000000138 = ? , I000000139 = ? , I000000140 = ? , I000000141 = ? , I000000142 = ? , I000000143 = ? , I000000144 = ? , I000000145 = ? , I000000146 = ? , I000000147 = ? , I000000148 = ? , I000000149 = ? , I000000150 = ? , I000000151 = ? , I000000152 = ? , I000000153 = ? , I000000154 = ? , I000000155 = ? , I000000156 = ? , I000000157 = ? , I000000158 = ? , I000000159 = ? , I000000160 = ? , I000000161 = ? , I000000162 = ? , I000000163 = ? , I000000164 = ? , I000000165 = ? , I000000166 = ? , I000000167 = ? , I000000168 = ? , I000000169 = ? , I000000170 = ? , I000000171 = ? , I000000172 = ? , I000000173 = ? , I000000174 = ? , I000000175 = ? , I000000176 = ? , I000000177 = ? , I000000178 = ? , I000000179 = ? , I000000180 = ? , I000000181 = ? , I000000182 = ? , I000000183 = ? , I000000184 = ? , I000000185 = ? , I000000186 = ? , I000000187 = ? , I000000188 = ? , I000000189 = ? , I000000190 = ? , I000000191 = ? , I000000192 = ? , I000000193 = ? , I000000194 = ? , I000000195 = ? , I000000196 = ? , I000000197 = ? , I000000198 = ? , I000000199 = ? , I000000200 = ? , R000000001 = ? , R000000002 = ? , R000000003 = ? , R000000004 = ? , R000000005 = ? , R000000006 = ? , R000000007 = ? , R000000008 = ? , R000000009 = ? , R000000010 = ? , R000000011 = ? , R000000012 = ? , R000000013 = ? , R000000014 = ? , R000000015 = ? , R000000016 = ? , R000000017 = ? , R000000018 = ? , R000000019 = ? , R000000020 = ? , R000000021 = ? , R000000022 = ? , R000000023 = ? , R000000024 = ? , R000000025 = ? , R000000026 = ? , R000000027 = ? , R000000028 = ? , R000000029 = ? , R000000030 = ? , R000000031 = ? , R000000032 = ? , R000000033 = ? , R000000034 = ? , R000000035 = ? , R000000036 = ? , R000000037 = ? , R000000038 = ? , R000000039 = ? , R000000040 = ? , R000000041 = ? , R000000042 = ? , R000000043 = ? , R000000044 = ? , R000000045 = ? , R000000046 = ? , R000000047 = ? , R000000048 = ? , R000000049 = ? , R000000050 = ? , R000000051 = ? , R000000052 = ? , R000000053 = ? , R000000054 = ? , R000000055 = ? , R000000056 = ? , R000000057 = ? , R000000058 = ? , R000000059 = ? , R000000060 = ? , R000000061 = ? , R000000062 = ? , R000000063 = ? , R000000064 = ? , R000000065 = ? , R000000066 = ? , R000000067 = ? , R000000068 = ? , R000000069 = ? , R000000070 = ? , R000000071 = ? , R000000072 = ? , R000000073 = ? , R000000074 = ? , R000000075 = ? , R000000076 = ? , R000000077 = ? , R000000078 = ? , R000000079 = ? , R000000080 = ? , R000000081 = ? , R000000082 = ? , R000000083 = ? , R000000084 = ? , R000000085 = ? , R000000086 = ? , R000000087 = ? , R000000088 = ? , R000000089 = ? , R000000090 = ? , R000000091 = ? , R000000092 = ? , R000000093 = ? , R000000094 = ? , R000000095 = ? , R000000096 = ? , R000000097 = ? , R000000098 = ? , R000000099 = ? , R000000100 = ? , R000000101 = ? , R000000102 = ? , R000000103 = ? , R000000104 = ? , R000000105 = ? , R000000106 = ? , R000000107 = ? , R000000108 = ? , R000000109 = ? , R000000110 = ? , R000000111 = ? , R000000112 = ? , R000000113 = ? , R000000114 = ? , R000000115 = ? , R000000116 = ? , R000000117 = ? , R000000118 = ? , R000000119 = ? , R000000120 = ? , R000000121 = ? , R000000122 = ? , R000000123 = ? , R000000124 = ? , R000000125 = ? , R000000126 = ? , R000000127 = ? , R000000128 = ? , R000000129 = ? , R000000130 = ? , R000000131 = ? , R000000132 = ? , R000000133 = ? , R000000134 = ? , R000000135 = ? , R000000136 = ? , R000000137 = ? , R000000138 = ? , R000000139 = ? , R000000140 = ? , R000000141 = ? , R000000142 = ? , R000000143 = ? , R000000144 = ? , R000000145 = ? , R000000146 = ? , R000000147 = ? , R000000148 = ? , R000000149 = ? , R000000150 = ? , R000000151 = ? , R000000152 = ? , R000000153 = ? , R000000154 = ? , R000000155 = ? , R000000156 = ? , R000000157 = ? , R000000158 = ? , R000000159 = ? , R000000160 = ? , R000000161 = ? , R000000162 = ? , R000000163 = ? , R000000164 = ? , R000000165 = ? , R000000166 = ? , R000000167 = ? , R000000168 = ? , R000000169 = ? , R000000170 = ? , R000000171 = ? , R000000172 = ? , R000000173 = ? , R000000174 = ? , R000000175 = ? , R000000176 = ? , R000000177 = ? , R000000178 = ? , R000000179 = ? , R000000180 = ? , R000000181 = ? , R000000182 = ? , R000000183 = ? , R000000184 = ? , R000000185 = ? , R000000186 = ? , R000000187 = ? , R000000188 = ? , R000000189 = ? , R000000190 = ? , R000000191 = ? , R000000192 = ? , R000000193 = ? , R000000194 = ? , R000000195 = ? , R000000196 = ? , R000000197 = ? , R000000198 = ? , R000000199 = ? , R000000200 = ? , I000000201 = ? , I000000202 = ? , I000000203 = ? , I000000209 = ? , I000000210 = ? , I000000213 = ? , I000000214 = ? , I000000215 = ? , I000000216 = ? , I000000217 = ? , I000000218 = ? , I000000219 = ? , I000000220 = ? , I000000221 = ? , I000000222 = ? , I000000224 = ? , I000000225 = ? , I000000226 = ? , I000000227 = ? , I000000228 = ? , I000000229 = ? , I000000231 = ? , I000000232 = ? , I000000233 = ? , I000000234 = ? , I000000235 = ? , I000000236 = ? , I000000237 = ? , I000000240 = ? , I000000241 = ? , I000000242 = ? , I000000243 = ? , I000000244 = ? , I000000245 = ? , I000000246 = ? , I000000247 = ? , I000000248 = ? , I000000249 = ? , I000000250 = ? , I000000251 = ? , R000000201 = ? , R000000202 = ? , R000000203 = ? , R000000204 = ? , R000000205 = ? , I000000254 = ? WHERE  WageNo = ? AND IndexType = ? AND AgentCode = ?");
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getBranchType());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getIndexType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getAgentCode());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getAgentGrade());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentGroup());
			}
			if(this.getState() == null || this.getState().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getState());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getModifyTime());
			}
			if(this.getI000000001() == null || this.getI000000001().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getI000000001());
			}
			if(this.getI000000002() == null || this.getI000000002().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getI000000002());
			}
			if(this.getI000000003() == null || this.getI000000003().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getI000000003());
			}
			if(this.getI000000004() == null || this.getI000000004().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getI000000004());
			}
			if(this.getI000000005() == null || this.getI000000005().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getI000000005());
			}
			if(this.getI000000006() == null || this.getI000000006().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getI000000006());
			}
			if(this.getI000000007() == null || this.getI000000007().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getI000000007());
			}
			if(this.getI000000008() == null || this.getI000000008().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getI000000008());
			}
			if(this.getI000000009() == null || this.getI000000009().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getI000000009());
			}
			if(this.getI000000010() == null || this.getI000000010().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getI000000010());
			}
			if(this.getI000000011() == null || this.getI000000011().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getI000000011());
			}
			if(this.getI000000012() == null || this.getI000000012().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getI000000012());
			}
			if(this.getI000000013() == null || this.getI000000013().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getI000000013());
			}
			if(this.getI000000014() == null || this.getI000000014().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getI000000014());
			}
			if(this.getI000000015() == null || this.getI000000015().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getI000000015());
			}
			if(this.getI000000016() == null || this.getI000000016().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getI000000016());
			}
			if(this.getI000000017() == null || this.getI000000017().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getI000000017());
			}
			if(this.getI000000018() == null || this.getI000000018().equals("null")) {
				pstmt.setNull(29, 12);
			} else {
				pstmt.setString(29, this.getI000000018());
			}
			if(this.getI000000019() == null || this.getI000000019().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getI000000019());
			}
			if(this.getI000000020() == null || this.getI000000020().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getI000000020());
			}
			if(this.getI000000021() == null || this.getI000000021().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getI000000021());
			}
			if(this.getI000000022() == null || this.getI000000022().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getI000000022());
			}
			if(this.getI000000023() == null || this.getI000000023().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getI000000023());
			}
			if(this.getI000000024() == null || this.getI000000024().equals("null")) {
				pstmt.setNull(35, 12);
			} else {
				pstmt.setString(35, this.getI000000024());
			}
			if(this.getI000000025() == null || this.getI000000025().equals("null")) {
				pstmt.setNull(36, 12);
			} else {
				pstmt.setString(36, this.getI000000025());
			}
			if(this.getI000000026() == null || this.getI000000026().equals("null")) {
				pstmt.setNull(37, 12);
			} else {
				pstmt.setString(37, this.getI000000026());
			}
			if(this.getI000000027() == null || this.getI000000027().equals("null")) {
				pstmt.setNull(38, 12);
			} else {
				pstmt.setString(38, this.getI000000027());
			}
			if(this.getI000000028() == null || this.getI000000028().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getI000000028());
			}
			if(this.getI000000029() == null || this.getI000000029().equals("null")) {
				pstmt.setNull(40, 12);
			} else {
				pstmt.setString(40, this.getI000000029());
			}
			if(this.getI000000030() == null || this.getI000000030().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getI000000030());
			}
			if(this.getI000000031() == null || this.getI000000031().equals("null")) {
				pstmt.setNull(42, 12);
			} else {
				pstmt.setString(42, this.getI000000031());
			}
			if(this.getI000000032() == null || this.getI000000032().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getI000000032());
			}
			if(this.getI000000033() == null || this.getI000000033().equals("null")) {
				pstmt.setNull(44, 12);
			} else {
				pstmt.setString(44, this.getI000000033());
			}
			if(this.getI000000034() == null || this.getI000000034().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getI000000034());
			}
			if(this.getI000000035() == null || this.getI000000035().equals("null")) {
				pstmt.setNull(46, 12);
			} else {
				pstmt.setString(46, this.getI000000035());
			}
			if(this.getI000000036() == null || this.getI000000036().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getI000000036());
			}
			if(this.getI000000037() == null || this.getI000000037().equals("null")) {
				pstmt.setNull(48, 12);
			} else {
				pstmt.setString(48, this.getI000000037());
			}
			if(this.getI000000038() == null || this.getI000000038().equals("null")) {
				pstmt.setNull(49, 12);
			} else {
				pstmt.setString(49, this.getI000000038());
			}
			if(this.getI000000039() == null || this.getI000000039().equals("null")) {
				pstmt.setNull(50, 12);
			} else {
				pstmt.setString(50, this.getI000000039());
			}
			if(this.getI000000040() == null || this.getI000000040().equals("null")) {
				pstmt.setNull(51, 12);
			} else {
				pstmt.setString(51, this.getI000000040());
			}
			if(this.getI000000041() == null || this.getI000000041().equals("null")) {
				pstmt.setNull(52, 12);
			} else {
				pstmt.setString(52, this.getI000000041());
			}
			if(this.getI000000042() == null || this.getI000000042().equals("null")) {
				pstmt.setNull(53, 12);
			} else {
				pstmt.setString(53, this.getI000000042());
			}
			if(this.getI000000043() == null || this.getI000000043().equals("null")) {
				pstmt.setNull(54, 12);
			} else {
				pstmt.setString(54, this.getI000000043());
			}
			if(this.getI000000044() == null || this.getI000000044().equals("null")) {
				pstmt.setNull(55, 12);
			} else {
				pstmt.setString(55, this.getI000000044());
			}
			if(this.getI000000045() == null || this.getI000000045().equals("null")) {
				pstmt.setNull(56, 12);
			} else {
				pstmt.setString(56, this.getI000000045());
			}
			if(this.getI000000046() == null || this.getI000000046().equals("null")) {
				pstmt.setNull(57, 12);
			} else {
				pstmt.setString(57, this.getI000000046());
			}
			if(this.getI000000047() == null || this.getI000000047().equals("null")) {
				pstmt.setNull(58, 12);
			} else {
				pstmt.setString(58, this.getI000000047());
			}
			if(this.getI000000048() == null || this.getI000000048().equals("null")) {
				pstmt.setNull(59, 12);
			} else {
				pstmt.setString(59, this.getI000000048());
			}
			if(this.getI000000049() == null || this.getI000000049().equals("null")) {
				pstmt.setNull(60, 12);
			} else {
				pstmt.setString(60, this.getI000000049());
			}
			if(this.getI000000050() == null || this.getI000000050().equals("null")) {
				pstmt.setNull(61, 12);
			} else {
				pstmt.setString(61, this.getI000000050());
			}
			if(this.getI000000051() == null || this.getI000000051().equals("null")) {
				pstmt.setNull(62, 12);
			} else {
				pstmt.setString(62, this.getI000000051());
			}
			if(this.getI000000052() == null || this.getI000000052().equals("null")) {
				pstmt.setNull(63, 12);
			} else {
				pstmt.setString(63, this.getI000000052());
			}
			if(this.getI000000053() == null || this.getI000000053().equals("null")) {
				pstmt.setNull(64, 12);
			} else {
				pstmt.setString(64, this.getI000000053());
			}
			if(this.getI000000054() == null || this.getI000000054().equals("null")) {
				pstmt.setNull(65, 12);
			} else {
				pstmt.setString(65, this.getI000000054());
			}
			if(this.getI000000055() == null || this.getI000000055().equals("null")) {
				pstmt.setNull(66, 12);
			} else {
				pstmt.setString(66, this.getI000000055());
			}
			if(this.getI000000056() == null || this.getI000000056().equals("null")) {
				pstmt.setNull(67, 12);
			} else {
				pstmt.setString(67, this.getI000000056());
			}
			if(this.getI000000057() == null || this.getI000000057().equals("null")) {
				pstmt.setNull(68, 12);
			} else {
				pstmt.setString(68, this.getI000000057());
			}
			if(this.getI000000058() == null || this.getI000000058().equals("null")) {
				pstmt.setNull(69, 12);
			} else {
				pstmt.setString(69, this.getI000000058());
			}
			if(this.getI000000059() == null || this.getI000000059().equals("null")) {
				pstmt.setNull(70, 12);
			} else {
				pstmt.setString(70, this.getI000000059());
			}
			if(this.getI000000060() == null || this.getI000000060().equals("null")) {
				pstmt.setNull(71, 12);
			} else {
				pstmt.setString(71, this.getI000000060());
			}
			if(this.getI000000061() == null || this.getI000000061().equals("null")) {
				pstmt.setNull(72, 12);
			} else {
				pstmt.setString(72, this.getI000000061());
			}
			if(this.getI000000062() == null || this.getI000000062().equals("null")) {
				pstmt.setNull(73, 12);
			} else {
				pstmt.setString(73, this.getI000000062());
			}
			if(this.getI000000063() == null || this.getI000000063().equals("null")) {
				pstmt.setNull(74, 12);
			} else {
				pstmt.setString(74, this.getI000000063());
			}
			if(this.getI000000064() == null || this.getI000000064().equals("null")) {
				pstmt.setNull(75, 12);
			} else {
				pstmt.setString(75, this.getI000000064());
			}
			if(this.getI000000065() == null || this.getI000000065().equals("null")) {
				pstmt.setNull(76, 12);
			} else {
				pstmt.setString(76, this.getI000000065());
			}
			if(this.getI000000066() == null || this.getI000000066().equals("null")) {
				pstmt.setNull(77, 12);
			} else {
				pstmt.setString(77, this.getI000000066());
			}
			if(this.getI000000067() == null || this.getI000000067().equals("null")) {
				pstmt.setNull(78, 12);
			} else {
				pstmt.setString(78, this.getI000000067());
			}
			if(this.getI000000068() == null || this.getI000000068().equals("null")) {
				pstmt.setNull(79, 12);
			} else {
				pstmt.setString(79, this.getI000000068());
			}
			if(this.getI000000069() == null || this.getI000000069().equals("null")) {
				pstmt.setNull(80, 12);
			} else {
				pstmt.setString(80, this.getI000000069());
			}
			if(this.getI000000070() == null || this.getI000000070().equals("null")) {
				pstmt.setNull(81, 12);
			} else {
				pstmt.setString(81, this.getI000000070());
			}
			if(this.getI000000071() == null || this.getI000000071().equals("null")) {
				pstmt.setNull(82, 12);
			} else {
				pstmt.setString(82, this.getI000000071());
			}
			if(this.getI000000072() == null || this.getI000000072().equals("null")) {
				pstmt.setNull(83, 12);
			} else {
				pstmt.setString(83, this.getI000000072());
			}
			if(this.getI000000073() == null || this.getI000000073().equals("null")) {
				pstmt.setNull(84, 12);
			} else {
				pstmt.setString(84, this.getI000000073());
			}
			if(this.getI000000074() == null || this.getI000000074().equals("null")) {
				pstmt.setNull(85, 12);
			} else {
				pstmt.setString(85, this.getI000000074());
			}
			if(this.getI000000075() == null || this.getI000000075().equals("null")) {
				pstmt.setNull(86, 12);
			} else {
				pstmt.setString(86, this.getI000000075());
			}
			if(this.getI000000076() == null || this.getI000000076().equals("null")) {
				pstmt.setNull(87, 12);
			} else {
				pstmt.setString(87, this.getI000000076());
			}
			if(this.getI000000077() == null || this.getI000000077().equals("null")) {
				pstmt.setNull(88, 12);
			} else {
				pstmt.setString(88, this.getI000000077());
			}
			if(this.getI000000078() == null || this.getI000000078().equals("null")) {
				pstmt.setNull(89, 12);
			} else {
				pstmt.setString(89, this.getI000000078());
			}
			if(this.getI000000079() == null || this.getI000000079().equals("null")) {
				pstmt.setNull(90, 12);
			} else {
				pstmt.setString(90, this.getI000000079());
			}
			if(this.getI000000080() == null || this.getI000000080().equals("null")) {
				pstmt.setNull(91, 12);
			} else {
				pstmt.setString(91, this.getI000000080());
			}
			if(this.getI000000081() == null || this.getI000000081().equals("null")) {
				pstmt.setNull(92, 12);
			} else {
				pstmt.setString(92, this.getI000000081());
			}
			if(this.getI000000082() == null || this.getI000000082().equals("null")) {
				pstmt.setNull(93, 12);
			} else {
				pstmt.setString(93, this.getI000000082());
			}
			if(this.getI000000083() == null || this.getI000000083().equals("null")) {
				pstmt.setNull(94, 12);
			} else {
				pstmt.setString(94, this.getI000000083());
			}
			if(this.getI000000084() == null || this.getI000000084().equals("null")) {
				pstmt.setNull(95, 12);
			} else {
				pstmt.setString(95, this.getI000000084());
			}
			if(this.getI000000085() == null || this.getI000000085().equals("null")) {
				pstmt.setNull(96, 12);
			} else {
				pstmt.setString(96, this.getI000000085());
			}
			if(this.getI000000086() == null || this.getI000000086().equals("null")) {
				pstmt.setNull(97, 12);
			} else {
				pstmt.setString(97, this.getI000000086());
			}
			if(this.getI000000087() == null || this.getI000000087().equals("null")) {
				pstmt.setNull(98, 12);
			} else {
				pstmt.setString(98, this.getI000000087());
			}
			if(this.getI000000088() == null || this.getI000000088().equals("null")) {
				pstmt.setNull(99, 12);
			} else {
				pstmt.setString(99, this.getI000000088());
			}
			if(this.getI000000089() == null || this.getI000000089().equals("null")) {
				pstmt.setNull(100, 12);
			} else {
				pstmt.setString(100, this.getI000000089());
			}
			if(this.getI000000090() == null || this.getI000000090().equals("null")) {
				pstmt.setNull(101, 12);
			} else {
				pstmt.setString(101, this.getI000000090());
			}
			if(this.getI000000091() == null || this.getI000000091().equals("null")) {
				pstmt.setNull(102, 12);
			} else {
				pstmt.setString(102, this.getI000000091());
			}
			if(this.getI000000092() == null || this.getI000000092().equals("null")) {
				pstmt.setNull(103, 12);
			} else {
				pstmt.setString(103, this.getI000000092());
			}
			if(this.getI000000093() == null || this.getI000000093().equals("null")) {
				pstmt.setNull(104, 12);
			} else {
				pstmt.setString(104, this.getI000000093());
			}
			if(this.getI000000094() == null || this.getI000000094().equals("null")) {
				pstmt.setNull(105, 12);
			} else {
				pstmt.setString(105, this.getI000000094());
			}
			if(this.getI000000095() == null || this.getI000000095().equals("null")) {
				pstmt.setNull(106, 12);
			} else {
				pstmt.setString(106, this.getI000000095());
			}
			if(this.getI000000096() == null || this.getI000000096().equals("null")) {
				pstmt.setNull(107, 12);
			} else {
				pstmt.setString(107, this.getI000000096());
			}
			if(this.getI000000097() == null || this.getI000000097().equals("null")) {
				pstmt.setNull(108, 12);
			} else {
				pstmt.setString(108, this.getI000000097());
			}
			if(this.getI000000098() == null || this.getI000000098().equals("null")) {
				pstmt.setNull(109, 12);
			} else {
				pstmt.setString(109, this.getI000000098());
			}
			if(this.getI000000099() == null || this.getI000000099().equals("null")) {
				pstmt.setNull(110, 12);
			} else {
				pstmt.setString(110, this.getI000000099());
			}
			if(this.getI000000100() == null || this.getI000000100().equals("null")) {
				pstmt.setNull(111, 12);
			} else {
				pstmt.setString(111, this.getI000000100());
			}
			if(this.getI000000101() == null || this.getI000000101().equals("null")) {
				pstmt.setNull(112, 12);
			} else {
				pstmt.setString(112, this.getI000000101());
			}
			if(this.getI000000102() == null || this.getI000000102().equals("null")) {
				pstmt.setNull(113, 12);
			} else {
				pstmt.setString(113, this.getI000000102());
			}
			if(this.getI000000103() == null || this.getI000000103().equals("null")) {
				pstmt.setNull(114, 12);
			} else {
				pstmt.setString(114, this.getI000000103());
			}
			if(this.getI000000104() == null || this.getI000000104().equals("null")) {
				pstmt.setNull(115, 12);
			} else {
				pstmt.setString(115, this.getI000000104());
			}
			if(this.getI000000105() == null || this.getI000000105().equals("null")) {
				pstmt.setNull(116, 12);
			} else {
				pstmt.setString(116, this.getI000000105());
			}
			if(this.getI000000106() == null || this.getI000000106().equals("null")) {
				pstmt.setNull(117, 12);
			} else {
				pstmt.setString(117, this.getI000000106());
			}
			if(this.getI000000107() == null || this.getI000000107().equals("null")) {
				pstmt.setNull(118, 12);
			} else {
				pstmt.setString(118, this.getI000000107());
			}
			if(this.getI000000108() == null || this.getI000000108().equals("null")) {
				pstmt.setNull(119, 12);
			} else {
				pstmt.setString(119, this.getI000000108());
			}
			if(this.getI000000109() == null || this.getI000000109().equals("null")) {
				pstmt.setNull(120, 12);
			} else {
				pstmt.setString(120, this.getI000000109());
			}
			if(this.getI000000110() == null || this.getI000000110().equals("null")) {
				pstmt.setNull(121, 12);
			} else {
				pstmt.setString(121, this.getI000000110());
			}
			if(this.getI000000111() == null || this.getI000000111().equals("null")) {
				pstmt.setNull(122, 12);
			} else {
				pstmt.setString(122, this.getI000000111());
			}
			if(this.getI000000112() == null || this.getI000000112().equals("null")) {
				pstmt.setNull(123, 12);
			} else {
				pstmt.setString(123, this.getI000000112());
			}
			if(this.getI000000113() == null || this.getI000000113().equals("null")) {
				pstmt.setNull(124, 12);
			} else {
				pstmt.setString(124, this.getI000000113());
			}
			if(this.getI000000114() == null || this.getI000000114().equals("null")) {
				pstmt.setNull(125, 12);
			} else {
				pstmt.setString(125, this.getI000000114());
			}
			if(this.getI000000115() == null || this.getI000000115().equals("null")) {
				pstmt.setNull(126, 12);
			} else {
				pstmt.setString(126, this.getI000000115());
			}
			if(this.getI000000116() == null || this.getI000000116().equals("null")) {
				pstmt.setNull(127, 12);
			} else {
				pstmt.setString(127, this.getI000000116());
			}
			if(this.getI000000117() == null || this.getI000000117().equals("null")) {
				pstmt.setNull(128, 12);
			} else {
				pstmt.setString(128, this.getI000000117());
			}
			if(this.getI000000118() == null || this.getI000000118().equals("null")) {
				pstmt.setNull(129, 12);
			} else {
				pstmt.setString(129, this.getI000000118());
			}
			if(this.getI000000119() == null || this.getI000000119().equals("null")) {
				pstmt.setNull(130, 12);
			} else {
				pstmt.setString(130, this.getI000000119());
			}
			if(this.getI000000120() == null || this.getI000000120().equals("null")) {
				pstmt.setNull(131, 12);
			} else {
				pstmt.setString(131, this.getI000000120());
			}
			if(this.getI000000121() == null || this.getI000000121().equals("null")) {
				pstmt.setNull(132, 12);
			} else {
				pstmt.setString(132, this.getI000000121());
			}
			if(this.getI000000122() == null || this.getI000000122().equals("null")) {
				pstmt.setNull(133, 12);
			} else {
				pstmt.setString(133, this.getI000000122());
			}
			if(this.getI000000123() == null || this.getI000000123().equals("null")) {
				pstmt.setNull(134, 12);
			} else {
				pstmt.setString(134, this.getI000000123());
			}
			if(this.getI000000124() == null || this.getI000000124().equals("null")) {
				pstmt.setNull(135, 12);
			} else {
				pstmt.setString(135, this.getI000000124());
			}
			if(this.getI000000125() == null || this.getI000000125().equals("null")) {
				pstmt.setNull(136, 12);
			} else {
				pstmt.setString(136, this.getI000000125());
			}
			if(this.getI000000126() == null || this.getI000000126().equals("null")) {
				pstmt.setNull(137, 12);
			} else {
				pstmt.setString(137, this.getI000000126());
			}
			if(this.getI000000127() == null || this.getI000000127().equals("null")) {
				pstmt.setNull(138, 12);
			} else {
				pstmt.setString(138, this.getI000000127());
			}
			if(this.getI000000128() == null || this.getI000000128().equals("null")) {
				pstmt.setNull(139, 12);
			} else {
				pstmt.setString(139, this.getI000000128());
			}
			if(this.getI000000129() == null || this.getI000000129().equals("null")) {
				pstmt.setNull(140, 12);
			} else {
				pstmt.setString(140, this.getI000000129());
			}
			if(this.getI000000130() == null || this.getI000000130().equals("null")) {
				pstmt.setNull(141, 12);
			} else {
				pstmt.setString(141, this.getI000000130());
			}
			if(this.getI000000131() == null || this.getI000000131().equals("null")) {
				pstmt.setNull(142, 12);
			} else {
				pstmt.setString(142, this.getI000000131());
			}
			if(this.getI000000132() == null || this.getI000000132().equals("null")) {
				pstmt.setNull(143, 12);
			} else {
				pstmt.setString(143, this.getI000000132());
			}
			if(this.getI000000133() == null || this.getI000000133().equals("null")) {
				pstmt.setNull(144, 12);
			} else {
				pstmt.setString(144, this.getI000000133());
			}
			if(this.getI000000134() == null || this.getI000000134().equals("null")) {
				pstmt.setNull(145, 12);
			} else {
				pstmt.setString(145, this.getI000000134());
			}
			if(this.getI000000135() == null || this.getI000000135().equals("null")) {
				pstmt.setNull(146, 12);
			} else {
				pstmt.setString(146, this.getI000000135());
			}
			if(this.getI000000136() == null || this.getI000000136().equals("null")) {
				pstmt.setNull(147, 12);
			} else {
				pstmt.setString(147, this.getI000000136());
			}
			if(this.getI000000137() == null || this.getI000000137().equals("null")) {
				pstmt.setNull(148, 12);
			} else {
				pstmt.setString(148, this.getI000000137());
			}
			if(this.getI000000138() == null || this.getI000000138().equals("null")) {
				pstmt.setNull(149, 12);
			} else {
				pstmt.setString(149, this.getI000000138());
			}
			if(this.getI000000139() == null || this.getI000000139().equals("null")) {
				pstmt.setNull(150, 12);
			} else {
				pstmt.setString(150, this.getI000000139());
			}
			if(this.getI000000140() == null || this.getI000000140().equals("null")) {
				pstmt.setNull(151, 12);
			} else {
				pstmt.setString(151, this.getI000000140());
			}
			if(this.getI000000141() == null || this.getI000000141().equals("null")) {
				pstmt.setNull(152, 12);
			} else {
				pstmt.setString(152, this.getI000000141());
			}
			if(this.getI000000142() == null || this.getI000000142().equals("null")) {
				pstmt.setNull(153, 12);
			} else {
				pstmt.setString(153, this.getI000000142());
			}
			if(this.getI000000143() == null || this.getI000000143().equals("null")) {
				pstmt.setNull(154, 12);
			} else {
				pstmt.setString(154, this.getI000000143());
			}
			if(this.getI000000144() == null || this.getI000000144().equals("null")) {
				pstmt.setNull(155, 12);
			} else {
				pstmt.setString(155, this.getI000000144());
			}
			if(this.getI000000145() == null || this.getI000000145().equals("null")) {
				pstmt.setNull(156, 12);
			} else {
				pstmt.setString(156, this.getI000000145());
			}
			if(this.getI000000146() == null || this.getI000000146().equals("null")) {
				pstmt.setNull(157, 12);
			} else {
				pstmt.setString(157, this.getI000000146());
			}
			if(this.getI000000147() == null || this.getI000000147().equals("null")) {
				pstmt.setNull(158, 12);
			} else {
				pstmt.setString(158, this.getI000000147());
			}
			if(this.getI000000148() == null || this.getI000000148().equals("null")) {
				pstmt.setNull(159, 12);
			} else {
				pstmt.setString(159, this.getI000000148());
			}
			if(this.getI000000149() == null || this.getI000000149().equals("null")) {
				pstmt.setNull(160, 12);
			} else {
				pstmt.setString(160, this.getI000000149());
			}
			if(this.getI000000150() == null || this.getI000000150().equals("null")) {
				pstmt.setNull(161, 12);
			} else {
				pstmt.setString(161, this.getI000000150());
			}
			if(this.getI000000151() == null || this.getI000000151().equals("null")) {
				pstmt.setNull(162, 12);
			} else {
				pstmt.setString(162, this.getI000000151());
			}
			if(this.getI000000152() == null || this.getI000000152().equals("null")) {
				pstmt.setNull(163, 12);
			} else {
				pstmt.setString(163, this.getI000000152());
			}
			if(this.getI000000153() == null || this.getI000000153().equals("null")) {
				pstmt.setNull(164, 12);
			} else {
				pstmt.setString(164, this.getI000000153());
			}
			if(this.getI000000154() == null || this.getI000000154().equals("null")) {
				pstmt.setNull(165, 12);
			} else {
				pstmt.setString(165, this.getI000000154());
			}
			if(this.getI000000155() == null || this.getI000000155().equals("null")) {
				pstmt.setNull(166, 12);
			} else {
				pstmt.setString(166, this.getI000000155());
			}
			if(this.getI000000156() == null || this.getI000000156().equals("null")) {
				pstmt.setNull(167, 12);
			} else {
				pstmt.setString(167, this.getI000000156());
			}
			if(this.getI000000157() == null || this.getI000000157().equals("null")) {
				pstmt.setNull(168, 12);
			} else {
				pstmt.setString(168, this.getI000000157());
			}
			if(this.getI000000158() == null || this.getI000000158().equals("null")) {
				pstmt.setNull(169, 12);
			} else {
				pstmt.setString(169, this.getI000000158());
			}
			if(this.getI000000159() == null || this.getI000000159().equals("null")) {
				pstmt.setNull(170, 12);
			} else {
				pstmt.setString(170, this.getI000000159());
			}
			if(this.getI000000160() == null || this.getI000000160().equals("null")) {
				pstmt.setNull(171, 12);
			} else {
				pstmt.setString(171, this.getI000000160());
			}
			if(this.getI000000161() == null || this.getI000000161().equals("null")) {
				pstmt.setNull(172, 12);
			} else {
				pstmt.setString(172, this.getI000000161());
			}
			if(this.getI000000162() == null || this.getI000000162().equals("null")) {
				pstmt.setNull(173, 12);
			} else {
				pstmt.setString(173, this.getI000000162());
			}
			if(this.getI000000163() == null || this.getI000000163().equals("null")) {
				pstmt.setNull(174, 12);
			} else {
				pstmt.setString(174, this.getI000000163());
			}
			if(this.getI000000164() == null || this.getI000000164().equals("null")) {
				pstmt.setNull(175, 12);
			} else {
				pstmt.setString(175, this.getI000000164());
			}
			if(this.getI000000165() == null || this.getI000000165().equals("null")) {
				pstmt.setNull(176, 12);
			} else {
				pstmt.setString(176, this.getI000000165());
			}
			if(this.getI000000166() == null || this.getI000000166().equals("null")) {
				pstmt.setNull(177, 12);
			} else {
				pstmt.setString(177, this.getI000000166());
			}
			if(this.getI000000167() == null || this.getI000000167().equals("null")) {
				pstmt.setNull(178, 12);
			} else {
				pstmt.setString(178, this.getI000000167());
			}
			if(this.getI000000168() == null || this.getI000000168().equals("null")) {
				pstmt.setNull(179, 12);
			} else {
				pstmt.setString(179, this.getI000000168());
			}
			if(this.getI000000169() == null || this.getI000000169().equals("null")) {
				pstmt.setNull(180, 12);
			} else {
				pstmt.setString(180, this.getI000000169());
			}
			if(this.getI000000170() == null || this.getI000000170().equals("null")) {
				pstmt.setNull(181, 12);
			} else {
				pstmt.setString(181, this.getI000000170());
			}
			if(this.getI000000171() == null || this.getI000000171().equals("null")) {
				pstmt.setNull(182, 12);
			} else {
				pstmt.setString(182, this.getI000000171());
			}
			if(this.getI000000172() == null || this.getI000000172().equals("null")) {
				pstmt.setNull(183, 12);
			} else {
				pstmt.setString(183, this.getI000000172());
			}
			if(this.getI000000173() == null || this.getI000000173().equals("null")) {
				pstmt.setNull(184, 12);
			} else {
				pstmt.setString(184, this.getI000000173());
			}
			if(this.getI000000174() == null || this.getI000000174().equals("null")) {
				pstmt.setNull(185, 12);
			} else {
				pstmt.setString(185, this.getI000000174());
			}
			if(this.getI000000175() == null || this.getI000000175().equals("null")) {
				pstmt.setNull(186, 12);
			} else {
				pstmt.setString(186, this.getI000000175());
			}
			if(this.getI000000176() == null || this.getI000000176().equals("null")) {
				pstmt.setNull(187, 12);
			} else {
				pstmt.setString(187, this.getI000000176());
			}
			if(this.getI000000177() == null || this.getI000000177().equals("null")) {
				pstmt.setNull(188, 12);
			} else {
				pstmt.setString(188, this.getI000000177());
			}
			if(this.getI000000178() == null || this.getI000000178().equals("null")) {
				pstmt.setNull(189, 12);
			} else {
				pstmt.setString(189, this.getI000000178());
			}
			if(this.getI000000179() == null || this.getI000000179().equals("null")) {
				pstmt.setNull(190, 12);
			} else {
				pstmt.setString(190, this.getI000000179());
			}
			if(this.getI000000180() == null || this.getI000000180().equals("null")) {
				pstmt.setNull(191, 12);
			} else {
				pstmt.setString(191, this.getI000000180());
			}
			if(this.getI000000181() == null || this.getI000000181().equals("null")) {
				pstmt.setNull(192, 12);
			} else {
				pstmt.setString(192, this.getI000000181());
			}
			if(this.getI000000182() == null || this.getI000000182().equals("null")) {
				pstmt.setNull(193, 12);
			} else {
				pstmt.setString(193, this.getI000000182());
			}
			if(this.getI000000183() == null || this.getI000000183().equals("null")) {
				pstmt.setNull(194, 12);
			} else {
				pstmt.setString(194, this.getI000000183());
			}
			if(this.getI000000184() == null || this.getI000000184().equals("null")) {
				pstmt.setNull(195, 12);
			} else {
				pstmt.setString(195, this.getI000000184());
			}
			if(this.getI000000185() == null || this.getI000000185().equals("null")) {
				pstmt.setNull(196, 12);
			} else {
				pstmt.setString(196, this.getI000000185());
			}
			if(this.getI000000186() == null || this.getI000000186().equals("null")) {
				pstmt.setNull(197, 12);
			} else {
				pstmt.setString(197, this.getI000000186());
			}
			if(this.getI000000187() == null || this.getI000000187().equals("null")) {
				pstmt.setNull(198, 12);
			} else {
				pstmt.setString(198, this.getI000000187());
			}
			if(this.getI000000188() == null || this.getI000000188().equals("null")) {
				pstmt.setNull(199, 12);
			} else {
				pstmt.setString(199, this.getI000000188());
			}
			if(this.getI000000189() == null || this.getI000000189().equals("null")) {
				pstmt.setNull(200, 12);
			} else {
				pstmt.setString(200, this.getI000000189());
			}
			if(this.getI000000190() == null || this.getI000000190().equals("null")) {
				pstmt.setNull(201, 12);
			} else {
				pstmt.setString(201, this.getI000000190());
			}
			if(this.getI000000191() == null || this.getI000000191().equals("null")) {
				pstmt.setNull(202, 12);
			} else {
				pstmt.setString(202, this.getI000000191());
			}
			if(this.getI000000192() == null || this.getI000000192().equals("null")) {
				pstmt.setNull(203, 12);
			} else {
				pstmt.setString(203, this.getI000000192());
			}
			if(this.getI000000193() == null || this.getI000000193().equals("null")) {
				pstmt.setNull(204, 12);
			} else {
				pstmt.setString(204, this.getI000000193());
			}
			if(this.getI000000194() == null || this.getI000000194().equals("null")) {
				pstmt.setNull(205, 12);
			} else {
				pstmt.setString(205, this.getI000000194());
			}
			if(this.getI000000195() == null || this.getI000000195().equals("null")) {
				pstmt.setNull(206, 12);
			} else {
				pstmt.setString(206, this.getI000000195());
			}
			if(this.getI000000196() == null || this.getI000000196().equals("null")) {
				pstmt.setNull(207, 12);
			} else {
				pstmt.setString(207, this.getI000000196());
			}
			if(this.getI000000197() == null || this.getI000000197().equals("null")) {
				pstmt.setNull(208, 12);
			} else {
				pstmt.setString(208, this.getI000000197());
			}
			if(this.getI000000198() == null || this.getI000000198().equals("null")) {
				pstmt.setNull(209, 12);
			} else {
				pstmt.setString(209, this.getI000000198());
			}
			if(this.getI000000199() == null || this.getI000000199().equals("null")) {
				pstmt.setNull(210, 12);
			} else {
				pstmt.setString(210, this.getI000000199());
			}
			if(this.getI000000200() == null || this.getI000000200().equals("null")) {
				pstmt.setNull(211, 12);
			} else {
				pstmt.setString(211, this.getI000000200());
			}
			if(this.getR000000001() == null || this.getR000000001().equals("null")) {
				pstmt.setNull(212, 12);
			} else {
				pstmt.setString(212, this.getR000000001());
			}
			if(this.getR000000002() == null || this.getR000000002().equals("null")) {
				pstmt.setNull(213, 12);
			} else {
				pstmt.setString(213, this.getR000000002());
			}
			if(this.getR000000003() == null || this.getR000000003().equals("null")) {
				pstmt.setNull(214, 12);
			} else {
				pstmt.setString(214, this.getR000000003());
			}
			if(this.getR000000004() == null || this.getR000000004().equals("null")) {
				pstmt.setNull(215, 12);
			} else {
				pstmt.setString(215, this.getR000000004());
			}
			if(this.getR000000005() == null || this.getR000000005().equals("null")) {
				pstmt.setNull(216, 12);
			} else {
				pstmt.setString(216, this.getR000000005());
			}
			if(this.getR000000006() == null || this.getR000000006().equals("null")) {
				pstmt.setNull(217, 12);
			} else {
				pstmt.setString(217, this.getR000000006());
			}
			if(this.getR000000007() == null || this.getR000000007().equals("null")) {
				pstmt.setNull(218, 12);
			} else {
				pstmt.setString(218, this.getR000000007());
			}
			if(this.getR000000008() == null || this.getR000000008().equals("null")) {
				pstmt.setNull(219, 12);
			} else {
				pstmt.setString(219, this.getR000000008());
			}
			if(this.getR000000009() == null || this.getR000000009().equals("null")) {
				pstmt.setNull(220, 12);
			} else {
				pstmt.setString(220, this.getR000000009());
			}
			if(this.getR000000010() == null || this.getR000000010().equals("null")) {
				pstmt.setNull(221, 12);
			} else {
				pstmt.setString(221, this.getR000000010());
			}
			if(this.getR000000011() == null || this.getR000000011().equals("null")) {
				pstmt.setNull(222, 12);
			} else {
				pstmt.setString(222, this.getR000000011());
			}
			if(this.getR000000012() == null || this.getR000000012().equals("null")) {
				pstmt.setNull(223, 12);
			} else {
				pstmt.setString(223, this.getR000000012());
			}
			if(this.getR000000013() == null || this.getR000000013().equals("null")) {
				pstmt.setNull(224, 12);
			} else {
				pstmt.setString(224, this.getR000000013());
			}
			if(this.getR000000014() == null || this.getR000000014().equals("null")) {
				pstmt.setNull(225, 12);
			} else {
				pstmt.setString(225, this.getR000000014());
			}
			if(this.getR000000015() == null || this.getR000000015().equals("null")) {
				pstmt.setNull(226, 12);
			} else {
				pstmt.setString(226, this.getR000000015());
			}
			if(this.getR000000016() == null || this.getR000000016().equals("null")) {
				pstmt.setNull(227, 12);
			} else {
				pstmt.setString(227, this.getR000000016());
			}
			if(this.getR000000017() == null || this.getR000000017().equals("null")) {
				pstmt.setNull(228, 12);
			} else {
				pstmt.setString(228, this.getR000000017());
			}
			if(this.getR000000018() == null || this.getR000000018().equals("null")) {
				pstmt.setNull(229, 12);
			} else {
				pstmt.setString(229, this.getR000000018());
			}
			if(this.getR000000019() == null || this.getR000000019().equals("null")) {
				pstmt.setNull(230, 12);
			} else {
				pstmt.setString(230, this.getR000000019());
			}
			if(this.getR000000020() == null || this.getR000000020().equals("null")) {
				pstmt.setNull(231, 12);
			} else {
				pstmt.setString(231, this.getR000000020());
			}
			if(this.getR000000021() == null || this.getR000000021().equals("null")) {
				pstmt.setNull(232, 12);
			} else {
				pstmt.setString(232, this.getR000000021());
			}
			if(this.getR000000022() == null || this.getR000000022().equals("null")) {
				pstmt.setNull(233, 12);
			} else {
				pstmt.setString(233, this.getR000000022());
			}
			if(this.getR000000023() == null || this.getR000000023().equals("null")) {
				pstmt.setNull(234, 12);
			} else {
				pstmt.setString(234, this.getR000000023());
			}
			if(this.getR000000024() == null || this.getR000000024().equals("null")) {
				pstmt.setNull(235, 12);
			} else {
				pstmt.setString(235, this.getR000000024());
			}
			if(this.getR000000025() == null || this.getR000000025().equals("null")) {
				pstmt.setNull(236, 12);
			} else {
				pstmt.setString(236, this.getR000000025());
			}
			if(this.getR000000026() == null || this.getR000000026().equals("null")) {
				pstmt.setNull(237, 12);
			} else {
				pstmt.setString(237, this.getR000000026());
			}
			if(this.getR000000027() == null || this.getR000000027().equals("null")) {
				pstmt.setNull(238, 12);
			} else {
				pstmt.setString(238, this.getR000000027());
			}
			if(this.getR000000028() == null || this.getR000000028().equals("null")) {
				pstmt.setNull(239, 12);
			} else {
				pstmt.setString(239, this.getR000000028());
			}
			if(this.getR000000029() == null || this.getR000000029().equals("null")) {
				pstmt.setNull(240, 12);
			} else {
				pstmt.setString(240, this.getR000000029());
			}
			if(this.getR000000030() == null || this.getR000000030().equals("null")) {
				pstmt.setNull(241, 12);
			} else {
				pstmt.setString(241, this.getR000000030());
			}
			if(this.getR000000031() == null || this.getR000000031().equals("null")) {
				pstmt.setNull(242, 12);
			} else {
				pstmt.setString(242, this.getR000000031());
			}
			if(this.getR000000032() == null || this.getR000000032().equals("null")) {
				pstmt.setNull(243, 12);
			} else {
				pstmt.setString(243, this.getR000000032());
			}
			if(this.getR000000033() == null || this.getR000000033().equals("null")) {
				pstmt.setNull(244, 12);
			} else {
				pstmt.setString(244, this.getR000000033());
			}
			if(this.getR000000034() == null || this.getR000000034().equals("null")) {
				pstmt.setNull(245, 12);
			} else {
				pstmt.setString(245, this.getR000000034());
			}
			if(this.getR000000035() == null || this.getR000000035().equals("null")) {
				pstmt.setNull(246, 12);
			} else {
				pstmt.setString(246, this.getR000000035());
			}
			if(this.getR000000036() == null || this.getR000000036().equals("null")) {
				pstmt.setNull(247, 12);
			} else {
				pstmt.setString(247, this.getR000000036());
			}
			if(this.getR000000037() == null || this.getR000000037().equals("null")) {
				pstmt.setNull(248, 12);
			} else {
				pstmt.setString(248, this.getR000000037());
			}
			if(this.getR000000038() == null || this.getR000000038().equals("null")) {
				pstmt.setNull(249, 12);
			} else {
				pstmt.setString(249, this.getR000000038());
			}
			if(this.getR000000039() == null || this.getR000000039().equals("null")) {
				pstmt.setNull(250, 12);
			} else {
				pstmt.setString(250, this.getR000000039());
			}
			if(this.getR000000040() == null || this.getR000000040().equals("null")) {
				pstmt.setNull(251, 12);
			} else {
				pstmt.setString(251, this.getR000000040());
			}
			if(this.getR000000041() == null || this.getR000000041().equals("null")) {
				pstmt.setNull(252, 12);
			} else {
				pstmt.setString(252, this.getR000000041());
			}
			if(this.getR000000042() == null || this.getR000000042().equals("null")) {
				pstmt.setNull(253, 12);
			} else {
				pstmt.setString(253, this.getR000000042());
			}
			if(this.getR000000043() == null || this.getR000000043().equals("null")) {
				pstmt.setNull(254, 12);
			} else {
				pstmt.setString(254, this.getR000000043());
			}
			if(this.getR000000044() == null || this.getR000000044().equals("null")) {
				pstmt.setNull(255, 12);
			} else {
				pstmt.setString(255, this.getR000000044());
			}
			if(this.getR000000045() == null || this.getR000000045().equals("null")) {
				pstmt.setNull(256, 12);
			} else {
				pstmt.setString(256, this.getR000000045());
			}
			if(this.getR000000046() == null || this.getR000000046().equals("null")) {
				pstmt.setNull(257, 12);
			} else {
				pstmt.setString(257, this.getR000000046());
			}
			if(this.getR000000047() == null || this.getR000000047().equals("null")) {
				pstmt.setNull(258, 12);
			} else {
				pstmt.setString(258, this.getR000000047());
			}
			if(this.getR000000048() == null || this.getR000000048().equals("null")) {
				pstmt.setNull(259, 12);
			} else {
				pstmt.setString(259, this.getR000000048());
			}
			if(this.getR000000049() == null || this.getR000000049().equals("null")) {
				pstmt.setNull(260, 12);
			} else {
				pstmt.setString(260, this.getR000000049());
			}
			if(this.getR000000050() == null || this.getR000000050().equals("null")) {
				pstmt.setNull(261, 12);
			} else {
				pstmt.setString(261, this.getR000000050());
			}
			if(this.getR000000051() == null || this.getR000000051().equals("null")) {
				pstmt.setNull(262, 12);
			} else {
				pstmt.setString(262, this.getR000000051());
			}
			if(this.getR000000052() == null || this.getR000000052().equals("null")) {
				pstmt.setNull(263, 12);
			} else {
				pstmt.setString(263, this.getR000000052());
			}
			if(this.getR000000053() == null || this.getR000000053().equals("null")) {
				pstmt.setNull(264, 12);
			} else {
				pstmt.setString(264, this.getR000000053());
			}
			if(this.getR000000054() == null || this.getR000000054().equals("null")) {
				pstmt.setNull(265, 12);
			} else {
				pstmt.setString(265, this.getR000000054());
			}
			if(this.getR000000055() == null || this.getR000000055().equals("null")) {
				pstmt.setNull(266, 12);
			} else {
				pstmt.setString(266, this.getR000000055());
			}
			if(this.getR000000056() == null || this.getR000000056().equals("null")) {
				pstmt.setNull(267, 12);
			} else {
				pstmt.setString(267, this.getR000000056());
			}
			if(this.getR000000057() == null || this.getR000000057().equals("null")) {
				pstmt.setNull(268, 12);
			} else {
				pstmt.setString(268, this.getR000000057());
			}
			if(this.getR000000058() == null || this.getR000000058().equals("null")) {
				pstmt.setNull(269, 12);
			} else {
				pstmt.setString(269, this.getR000000058());
			}
			if(this.getR000000059() == null || this.getR000000059().equals("null")) {
				pstmt.setNull(270, 12);
			} else {
				pstmt.setString(270, this.getR000000059());
			}
			if(this.getR000000060() == null || this.getR000000060().equals("null")) {
				pstmt.setNull(271, 12);
			} else {
				pstmt.setString(271, this.getR000000060());
			}
			if(this.getR000000061() == null || this.getR000000061().equals("null")) {
				pstmt.setNull(272, 12);
			} else {
				pstmt.setString(272, this.getR000000061());
			}
			if(this.getR000000062() == null || this.getR000000062().equals("null")) {
				pstmt.setNull(273, 12);
			} else {
				pstmt.setString(273, this.getR000000062());
			}
			if(this.getR000000063() == null || this.getR000000063().equals("null")) {
				pstmt.setNull(274, 12);
			} else {
				pstmt.setString(274, this.getR000000063());
			}
			if(this.getR000000064() == null || this.getR000000064().equals("null")) {
				pstmt.setNull(275, 12);
			} else {
				pstmt.setString(275, this.getR000000064());
			}
			if(this.getR000000065() == null || this.getR000000065().equals("null")) {
				pstmt.setNull(276, 12);
			} else {
				pstmt.setString(276, this.getR000000065());
			}
			if(this.getR000000066() == null || this.getR000000066().equals("null")) {
				pstmt.setNull(277, 12);
			} else {
				pstmt.setString(277, this.getR000000066());
			}
			if(this.getR000000067() == null || this.getR000000067().equals("null")) {
				pstmt.setNull(278, 12);
			} else {
				pstmt.setString(278, this.getR000000067());
			}
			if(this.getR000000068() == null || this.getR000000068().equals("null")) {
				pstmt.setNull(279, 12);
			} else {
				pstmt.setString(279, this.getR000000068());
			}
			if(this.getR000000069() == null || this.getR000000069().equals("null")) {
				pstmt.setNull(280, 12);
			} else {
				pstmt.setString(280, this.getR000000069());
			}
			if(this.getR000000070() == null || this.getR000000070().equals("null")) {
				pstmt.setNull(281, 12);
			} else {
				pstmt.setString(281, this.getR000000070());
			}
			if(this.getR000000071() == null || this.getR000000071().equals("null")) {
				pstmt.setNull(282, 12);
			} else {
				pstmt.setString(282, this.getR000000071());
			}
			if(this.getR000000072() == null || this.getR000000072().equals("null")) {
				pstmt.setNull(283, 12);
			} else {
				pstmt.setString(283, this.getR000000072());
			}
			if(this.getR000000073() == null || this.getR000000073().equals("null")) {
				pstmt.setNull(284, 12);
			} else {
				pstmt.setString(284, this.getR000000073());
			}
			if(this.getR000000074() == null || this.getR000000074().equals("null")) {
				pstmt.setNull(285, 12);
			} else {
				pstmt.setString(285, this.getR000000074());
			}
			if(this.getR000000075() == null || this.getR000000075().equals("null")) {
				pstmt.setNull(286, 12);
			} else {
				pstmt.setString(286, this.getR000000075());
			}
			if(this.getR000000076() == null || this.getR000000076().equals("null")) {
				pstmt.setNull(287, 12);
			} else {
				pstmt.setString(287, this.getR000000076());
			}
			if(this.getR000000077() == null || this.getR000000077().equals("null")) {
				pstmt.setNull(288, 12);
			} else {
				pstmt.setString(288, this.getR000000077());
			}
			if(this.getR000000078() == null || this.getR000000078().equals("null")) {
				pstmt.setNull(289, 12);
			} else {
				pstmt.setString(289, this.getR000000078());
			}
			if(this.getR000000079() == null || this.getR000000079().equals("null")) {
				pstmt.setNull(290, 12);
			} else {
				pstmt.setString(290, this.getR000000079());
			}
			if(this.getR000000080() == null || this.getR000000080().equals("null")) {
				pstmt.setNull(291, 12);
			} else {
				pstmt.setString(291, this.getR000000080());
			}
			if(this.getR000000081() == null || this.getR000000081().equals("null")) {
				pstmt.setNull(292, 12);
			} else {
				pstmt.setString(292, this.getR000000081());
			}
			if(this.getR000000082() == null || this.getR000000082().equals("null")) {
				pstmt.setNull(293, 12);
			} else {
				pstmt.setString(293, this.getR000000082());
			}
			if(this.getR000000083() == null || this.getR000000083().equals("null")) {
				pstmt.setNull(294, 12);
			} else {
				pstmt.setString(294, this.getR000000083());
			}
			if(this.getR000000084() == null || this.getR000000084().equals("null")) {
				pstmt.setNull(295, 12);
			} else {
				pstmt.setString(295, this.getR000000084());
			}
			if(this.getR000000085() == null || this.getR000000085().equals("null")) {
				pstmt.setNull(296, 12);
			} else {
				pstmt.setString(296, this.getR000000085());
			}
			if(this.getR000000086() == null || this.getR000000086().equals("null")) {
				pstmt.setNull(297, 12);
			} else {
				pstmt.setString(297, this.getR000000086());
			}
			if(this.getR000000087() == null || this.getR000000087().equals("null")) {
				pstmt.setNull(298, 12);
			} else {
				pstmt.setString(298, this.getR000000087());
			}
			if(this.getR000000088() == null || this.getR000000088().equals("null")) {
				pstmt.setNull(299, 12);
			} else {
				pstmt.setString(299, this.getR000000088());
			}
			if(this.getR000000089() == null || this.getR000000089().equals("null")) {
				pstmt.setNull(300, 12);
			} else {
				pstmt.setString(300, this.getR000000089());
			}
			if(this.getR000000090() == null || this.getR000000090().equals("null")) {
				pstmt.setNull(301, 12);
			} else {
				pstmt.setString(301, this.getR000000090());
			}
			if(this.getR000000091() == null || this.getR000000091().equals("null")) {
				pstmt.setNull(302, 12);
			} else {
				pstmt.setString(302, this.getR000000091());
			}
			if(this.getR000000092() == null || this.getR000000092().equals("null")) {
				pstmt.setNull(303, 12);
			} else {
				pstmt.setString(303, this.getR000000092());
			}
			if(this.getR000000093() == null || this.getR000000093().equals("null")) {
				pstmt.setNull(304, 12);
			} else {
				pstmt.setString(304, this.getR000000093());
			}
			if(this.getR000000094() == null || this.getR000000094().equals("null")) {
				pstmt.setNull(305, 12);
			} else {
				pstmt.setString(305, this.getR000000094());
			}
			if(this.getR000000095() == null || this.getR000000095().equals("null")) {
				pstmt.setNull(306, 12);
			} else {
				pstmt.setString(306, this.getR000000095());
			}
			if(this.getR000000096() == null || this.getR000000096().equals("null")) {
				pstmt.setNull(307, 12);
			} else {
				pstmt.setString(307, this.getR000000096());
			}
			if(this.getR000000097() == null || this.getR000000097().equals("null")) {
				pstmt.setNull(308, 12);
			} else {
				pstmt.setString(308, this.getR000000097());
			}
			if(this.getR000000098() == null || this.getR000000098().equals("null")) {
				pstmt.setNull(309, 12);
			} else {
				pstmt.setString(309, this.getR000000098());
			}
			if(this.getR000000099() == null || this.getR000000099().equals("null")) {
				pstmt.setNull(310, 12);
			} else {
				pstmt.setString(310, this.getR000000099());
			}
			if(this.getR000000100() == null || this.getR000000100().equals("null")) {
				pstmt.setNull(311, 12);
			} else {
				pstmt.setString(311, this.getR000000100());
			}
			if(this.getR000000101() == null || this.getR000000101().equals("null")) {
				pstmt.setNull(312, 12);
			} else {
				pstmt.setString(312, this.getR000000101());
			}
			if(this.getR000000102() == null || this.getR000000102().equals("null")) {
				pstmt.setNull(313, 12);
			} else {
				pstmt.setString(313, this.getR000000102());
			}
			if(this.getR000000103() == null || this.getR000000103().equals("null")) {
				pstmt.setNull(314, 12);
			} else {
				pstmt.setString(314, this.getR000000103());
			}
			if(this.getR000000104() == null || this.getR000000104().equals("null")) {
				pstmt.setNull(315, 12);
			} else {
				pstmt.setString(315, this.getR000000104());
			}
			if(this.getR000000105() == null || this.getR000000105().equals("null")) {
				pstmt.setNull(316, 12);
			} else {
				pstmt.setString(316, this.getR000000105());
			}
			if(this.getR000000106() == null || this.getR000000106().equals("null")) {
				pstmt.setNull(317, 12);
			} else {
				pstmt.setString(317, this.getR000000106());
			}
			if(this.getR000000107() == null || this.getR000000107().equals("null")) {
				pstmt.setNull(318, 12);
			} else {
				pstmt.setString(318, this.getR000000107());
			}
			if(this.getR000000108() == null || this.getR000000108().equals("null")) {
				pstmt.setNull(319, 12);
			} else {
				pstmt.setString(319, this.getR000000108());
			}
			if(this.getR000000109() == null || this.getR000000109().equals("null")) {
				pstmt.setNull(320, 12);
			} else {
				pstmt.setString(320, this.getR000000109());
			}
			if(this.getR000000110() == null || this.getR000000110().equals("null")) {
				pstmt.setNull(321, 12);
			} else {
				pstmt.setString(321, this.getR000000110());
			}
			if(this.getR000000111() == null || this.getR000000111().equals("null")) {
				pstmt.setNull(322, 12);
			} else {
				pstmt.setString(322, this.getR000000111());
			}
			if(this.getR000000112() == null || this.getR000000112().equals("null")) {
				pstmt.setNull(323, 12);
			} else {
				pstmt.setString(323, this.getR000000112());
			}
			if(this.getR000000113() == null || this.getR000000113().equals("null")) {
				pstmt.setNull(324, 12);
			} else {
				pstmt.setString(324, this.getR000000113());
			}
			if(this.getR000000114() == null || this.getR000000114().equals("null")) {
				pstmt.setNull(325, 12);
			} else {
				pstmt.setString(325, this.getR000000114());
			}
			if(this.getR000000115() == null || this.getR000000115().equals("null")) {
				pstmt.setNull(326, 12);
			} else {
				pstmt.setString(326, this.getR000000115());
			}
			if(this.getR000000116() == null || this.getR000000116().equals("null")) {
				pstmt.setNull(327, 12);
			} else {
				pstmt.setString(327, this.getR000000116());
			}
			if(this.getR000000117() == null || this.getR000000117().equals("null")) {
				pstmt.setNull(328, 12);
			} else {
				pstmt.setString(328, this.getR000000117());
			}
			if(this.getR000000118() == null || this.getR000000118().equals("null")) {
				pstmt.setNull(329, 12);
			} else {
				pstmt.setString(329, this.getR000000118());
			}
			if(this.getR000000119() == null || this.getR000000119().equals("null")) {
				pstmt.setNull(330, 12);
			} else {
				pstmt.setString(330, this.getR000000119());
			}
			if(this.getR000000120() == null || this.getR000000120().equals("null")) {
				pstmt.setNull(331, 12);
			} else {
				pstmt.setString(331, this.getR000000120());
			}
			if(this.getR000000121() == null || this.getR000000121().equals("null")) {
				pstmt.setNull(332, 12);
			} else {
				pstmt.setString(332, this.getR000000121());
			}
			if(this.getR000000122() == null || this.getR000000122().equals("null")) {
				pstmt.setNull(333, 12);
			} else {
				pstmt.setString(333, this.getR000000122());
			}
			if(this.getR000000123() == null || this.getR000000123().equals("null")) {
				pstmt.setNull(334, 12);
			} else {
				pstmt.setString(334, this.getR000000123());
			}
			if(this.getR000000124() == null || this.getR000000124().equals("null")) {
				pstmt.setNull(335, 12);
			} else {
				pstmt.setString(335, this.getR000000124());
			}
			if(this.getR000000125() == null || this.getR000000125().equals("null")) {
				pstmt.setNull(336, 12);
			} else {
				pstmt.setString(336, this.getR000000125());
			}
			if(this.getR000000126() == null || this.getR000000126().equals("null")) {
				pstmt.setNull(337, 12);
			} else {
				pstmt.setString(337, this.getR000000126());
			}
			if(this.getR000000127() == null || this.getR000000127().equals("null")) {
				pstmt.setNull(338, 12);
			} else {
				pstmt.setString(338, this.getR000000127());
			}
			if(this.getR000000128() == null || this.getR000000128().equals("null")) {
				pstmt.setNull(339, 12);
			} else {
				pstmt.setString(339, this.getR000000128());
			}
			if(this.getR000000129() == null || this.getR000000129().equals("null")) {
				pstmt.setNull(340, 12);
			} else {
				pstmt.setString(340, this.getR000000129());
			}
			if(this.getR000000130() == null || this.getR000000130().equals("null")) {
				pstmt.setNull(341, 12);
			} else {
				pstmt.setString(341, this.getR000000130());
			}
			if(this.getR000000131() == null || this.getR000000131().equals("null")) {
				pstmt.setNull(342, 12);
			} else {
				pstmt.setString(342, this.getR000000131());
			}
			if(this.getR000000132() == null || this.getR000000132().equals("null")) {
				pstmt.setNull(343, 12);
			} else {
				pstmt.setString(343, this.getR000000132());
			}
			if(this.getR000000133() == null || this.getR000000133().equals("null")) {
				pstmt.setNull(344, 12);
			} else {
				pstmt.setString(344, this.getR000000133());
			}
			if(this.getR000000134() == null || this.getR000000134().equals("null")) {
				pstmt.setNull(345, 12);
			} else {
				pstmt.setString(345, this.getR000000134());
			}
			if(this.getR000000135() == null || this.getR000000135().equals("null")) {
				pstmt.setNull(346, 12);
			} else {
				pstmt.setString(346, this.getR000000135());
			}
			if(this.getR000000136() == null || this.getR000000136().equals("null")) {
				pstmt.setNull(347, 12);
			} else {
				pstmt.setString(347, this.getR000000136());
			}
			if(this.getR000000137() == null || this.getR000000137().equals("null")) {
				pstmt.setNull(348, 12);
			} else {
				pstmt.setString(348, this.getR000000137());
			}
			if(this.getR000000138() == null || this.getR000000138().equals("null")) {
				pstmt.setNull(349, 12);
			} else {
				pstmt.setString(349, this.getR000000138());
			}
			if(this.getR000000139() == null || this.getR000000139().equals("null")) {
				pstmt.setNull(350, 12);
			} else {
				pstmt.setString(350, this.getR000000139());
			}
			if(this.getR000000140() == null || this.getR000000140().equals("null")) {
				pstmt.setNull(351, 12);
			} else {
				pstmt.setString(351, this.getR000000140());
			}
			if(this.getR000000141() == null || this.getR000000141().equals("null")) {
				pstmt.setNull(352, 12);
			} else {
				pstmt.setString(352, this.getR000000141());
			}
			if(this.getR000000142() == null || this.getR000000142().equals("null")) {
				pstmt.setNull(353, 12);
			} else {
				pstmt.setString(353, this.getR000000142());
			}
			if(this.getR000000143() == null || this.getR000000143().equals("null")) {
				pstmt.setNull(354, 12);
			} else {
				pstmt.setString(354, this.getR000000143());
			}
			if(this.getR000000144() == null || this.getR000000144().equals("null")) {
				pstmt.setNull(355, 12);
			} else {
				pstmt.setString(355, this.getR000000144());
			}
			if(this.getR000000145() == null || this.getR000000145().equals("null")) {
				pstmt.setNull(356, 12);
			} else {
				pstmt.setString(356, this.getR000000145());
			}
			if(this.getR000000146() == null || this.getR000000146().equals("null")) {
				pstmt.setNull(357, 12);
			} else {
				pstmt.setString(357, this.getR000000146());
			}
			if(this.getR000000147() == null || this.getR000000147().equals("null")) {
				pstmt.setNull(358, 12);
			} else {
				pstmt.setString(358, this.getR000000147());
			}
			if(this.getR000000148() == null || this.getR000000148().equals("null")) {
				pstmt.setNull(359, 12);
			} else {
				pstmt.setString(359, this.getR000000148());
			}
			if(this.getR000000149() == null || this.getR000000149().equals("null")) {
				pstmt.setNull(360, 12);
			} else {
				pstmt.setString(360, this.getR000000149());
			}
			if(this.getR000000150() == null || this.getR000000150().equals("null")) {
				pstmt.setNull(361, 12);
			} else {
				pstmt.setString(361, this.getR000000150());
			}
			if(this.getR000000151() == null || this.getR000000151().equals("null")) {
				pstmt.setNull(362, 12);
			} else {
				pstmt.setString(362, this.getR000000151());
			}
			if(this.getR000000152() == null || this.getR000000152().equals("null")) {
				pstmt.setNull(363, 12);
			} else {
				pstmt.setString(363, this.getR000000152());
			}
			if(this.getR000000153() == null || this.getR000000153().equals("null")) {
				pstmt.setNull(364, 12);
			} else {
				pstmt.setString(364, this.getR000000153());
			}
			if(this.getR000000154() == null || this.getR000000154().equals("null")) {
				pstmt.setNull(365, 12);
			} else {
				pstmt.setString(365, this.getR000000154());
			}
			if(this.getR000000155() == null || this.getR000000155().equals("null")) {
				pstmt.setNull(366, 12);
			} else {
				pstmt.setString(366, this.getR000000155());
			}
			if(this.getR000000156() == null || this.getR000000156().equals("null")) {
				pstmt.setNull(367, 12);
			} else {
				pstmt.setString(367, this.getR000000156());
			}
			if(this.getR000000157() == null || this.getR000000157().equals("null")) {
				pstmt.setNull(368, 12);
			} else {
				pstmt.setString(368, this.getR000000157());
			}
			if(this.getR000000158() == null || this.getR000000158().equals("null")) {
				pstmt.setNull(369, 12);
			} else {
				pstmt.setString(369, this.getR000000158());
			}
			if(this.getR000000159() == null || this.getR000000159().equals("null")) {
				pstmt.setNull(370, 12);
			} else {
				pstmt.setString(370, this.getR000000159());
			}
			if(this.getR000000160() == null || this.getR000000160().equals("null")) {
				pstmt.setNull(371, 12);
			} else {
				pstmt.setString(371, this.getR000000160());
			}
			if(this.getR000000161() == null || this.getR000000161().equals("null")) {
				pstmt.setNull(372, 12);
			} else {
				pstmt.setString(372, this.getR000000161());
			}
			if(this.getR000000162() == null || this.getR000000162().equals("null")) {
				pstmt.setNull(373, 12);
			} else {
				pstmt.setString(373, this.getR000000162());
			}
			if(this.getR000000163() == null || this.getR000000163().equals("null")) {
				pstmt.setNull(374, 12);
			} else {
				pstmt.setString(374, this.getR000000163());
			}
			if(this.getR000000164() == null || this.getR000000164().equals("null")) {
				pstmt.setNull(375, 12);
			} else {
				pstmt.setString(375, this.getR000000164());
			}
			if(this.getR000000165() == null || this.getR000000165().equals("null")) {
				pstmt.setNull(376, 12);
			} else {
				pstmt.setString(376, this.getR000000165());
			}
			if(this.getR000000166() == null || this.getR000000166().equals("null")) {
				pstmt.setNull(377, 12);
			} else {
				pstmt.setString(377, this.getR000000166());
			}
			if(this.getR000000167() == null || this.getR000000167().equals("null")) {
				pstmt.setNull(378, 12);
			} else {
				pstmt.setString(378, this.getR000000167());
			}
			if(this.getR000000168() == null || this.getR000000168().equals("null")) {
				pstmt.setNull(379, 12);
			} else {
				pstmt.setString(379, this.getR000000168());
			}
			if(this.getR000000169() == null || this.getR000000169().equals("null")) {
				pstmt.setNull(380, 12);
			} else {
				pstmt.setString(380, this.getR000000169());
			}
			if(this.getR000000170() == null || this.getR000000170().equals("null")) {
				pstmt.setNull(381, 12);
			} else {
				pstmt.setString(381, this.getR000000170());
			}
			if(this.getR000000171() == null || this.getR000000171().equals("null")) {
				pstmt.setNull(382, 12);
			} else {
				pstmt.setString(382, this.getR000000171());
			}
			if(this.getR000000172() == null || this.getR000000172().equals("null")) {
				pstmt.setNull(383, 12);
			} else {
				pstmt.setString(383, this.getR000000172());
			}
			if(this.getR000000173() == null || this.getR000000173().equals("null")) {
				pstmt.setNull(384, 12);
			} else {
				pstmt.setString(384, this.getR000000173());
			}
			if(this.getR000000174() == null || this.getR000000174().equals("null")) {
				pstmt.setNull(385, 12);
			} else {
				pstmt.setString(385, this.getR000000174());
			}
			if(this.getR000000175() == null || this.getR000000175().equals("null")) {
				pstmt.setNull(386, 12);
			} else {
				pstmt.setString(386, this.getR000000175());
			}
			if(this.getR000000176() == null || this.getR000000176().equals("null")) {
				pstmt.setNull(387, 12);
			} else {
				pstmt.setString(387, this.getR000000176());
			}
			if(this.getR000000177() == null || this.getR000000177().equals("null")) {
				pstmt.setNull(388, 12);
			} else {
				pstmt.setString(388, this.getR000000177());
			}
			if(this.getR000000178() == null || this.getR000000178().equals("null")) {
				pstmt.setNull(389, 12);
			} else {
				pstmt.setString(389, this.getR000000178());
			}
			if(this.getR000000179() == null || this.getR000000179().equals("null")) {
				pstmt.setNull(390, 12);
			} else {
				pstmt.setString(390, this.getR000000179());
			}
			if(this.getR000000180() == null || this.getR000000180().equals("null")) {
				pstmt.setNull(391, 12);
			} else {
				pstmt.setString(391, this.getR000000180());
			}
			if(this.getR000000181() == null || this.getR000000181().equals("null")) {
				pstmt.setNull(392, 12);
			} else {
				pstmt.setString(392, this.getR000000181());
			}
			if(this.getR000000182() == null || this.getR000000182().equals("null")) {
				pstmt.setNull(393, 12);
			} else {
				pstmt.setString(393, this.getR000000182());
			}
			if(this.getR000000183() == null || this.getR000000183().equals("null")) {
				pstmt.setNull(394, 12);
			} else {
				pstmt.setString(394, this.getR000000183());
			}
			if(this.getR000000184() == null || this.getR000000184().equals("null")) {
				pstmt.setNull(395, 12);
			} else {
				pstmt.setString(395, this.getR000000184());
			}
			if(this.getR000000185() == null || this.getR000000185().equals("null")) {
				pstmt.setNull(396, 12);
			} else {
				pstmt.setString(396, this.getR000000185());
			}
			if(this.getR000000186() == null || this.getR000000186().equals("null")) {
				pstmt.setNull(397, 12);
			} else {
				pstmt.setString(397, this.getR000000186());
			}
			if(this.getR000000187() == null || this.getR000000187().equals("null")) {
				pstmt.setNull(398, 12);
			} else {
				pstmt.setString(398, this.getR000000187());
			}
			if(this.getR000000188() == null || this.getR000000188().equals("null")) {
				pstmt.setNull(399, 12);
			} else {
				pstmt.setString(399, this.getR000000188());
			}
			if(this.getR000000189() == null || this.getR000000189().equals("null")) {
				pstmt.setNull(400, 12);
			} else {
				pstmt.setString(400, this.getR000000189());
			}
			if(this.getR000000190() == null || this.getR000000190().equals("null")) {
				pstmt.setNull(401, 12);
			} else {
				pstmt.setString(401, this.getR000000190());
			}
			if(this.getR000000191() == null || this.getR000000191().equals("null")) {
				pstmt.setNull(402, 12);
			} else {
				pstmt.setString(402, this.getR000000191());
			}
			if(this.getR000000192() == null || this.getR000000192().equals("null")) {
				pstmt.setNull(403, 12);
			} else {
				pstmt.setString(403, this.getR000000192());
			}
			if(this.getR000000193() == null || this.getR000000193().equals("null")) {
				pstmt.setNull(404, 12);
			} else {
				pstmt.setString(404, this.getR000000193());
			}
			if(this.getR000000194() == null || this.getR000000194().equals("null")) {
				pstmt.setNull(405, 12);
			} else {
				pstmt.setString(405, this.getR000000194());
			}
			if(this.getR000000195() == null || this.getR000000195().equals("null")) {
				pstmt.setNull(406, 12);
			} else {
				pstmt.setString(406, this.getR000000195());
			}
			if(this.getR000000196() == null || this.getR000000196().equals("null")) {
				pstmt.setNull(407, 12);
			} else {
				pstmt.setString(407, this.getR000000196());
			}
			if(this.getR000000197() == null || this.getR000000197().equals("null")) {
				pstmt.setNull(408, 12);
			} else {
				pstmt.setString(408, this.getR000000197());
			}
			if(this.getR000000198() == null || this.getR000000198().equals("null")) {
				pstmt.setNull(409, 12);
			} else {
				pstmt.setString(409, this.getR000000198());
			}
			if(this.getR000000199() == null || this.getR000000199().equals("null")) {
				pstmt.setNull(410, 12);
			} else {
				pstmt.setString(410, this.getR000000199());
			}
			if(this.getR000000200() == null || this.getR000000200().equals("null")) {
				pstmt.setNull(411, 12);
			} else {
				pstmt.setString(411, this.getR000000200());
			}
			if(this.getI000000201() == null || this.getI000000201().equals("null")) {
				pstmt.setNull(412, 12);
			} else {
				pstmt.setString(412, this.getI000000201());
			}
			if(this.getI000000202() == null || this.getI000000202().equals("null")) {
				pstmt.setNull(413, 12);
			} else {
				pstmt.setString(413, this.getI000000202());
			}
			if(this.getI000000203() == null || this.getI000000203().equals("null")) {
				pstmt.setNull(414, 12);
			} else {
				pstmt.setString(414, this.getI000000203());
			}
			if(this.getI000000209() == null || this.getI000000209().equals("null")) {
				pstmt.setNull(415, 12);
			} else {
				pstmt.setString(415, this.getI000000209());
			}
			if(this.getI000000210() == null || this.getI000000210().equals("null")) {
				pstmt.setNull(416, 12);
			} else {
				pstmt.setString(416, this.getI000000210());
			}
			if(this.getI000000213() == null || this.getI000000213().equals("null")) {
				pstmt.setNull(417, 12);
			} else {
				pstmt.setString(417, this.getI000000213());
			}
			if(this.getI000000214() == null || this.getI000000214().equals("null")) {
				pstmt.setNull(418, 12);
			} else {
				pstmt.setString(418, this.getI000000214());
			}
			if(this.getI000000215() == null || this.getI000000215().equals("null")) {
				pstmt.setNull(419, 12);
			} else {
				pstmt.setString(419, this.getI000000215());
			}
			if(this.getI000000216() == null || this.getI000000216().equals("null")) {
				pstmt.setNull(420, 12);
			} else {
				pstmt.setString(420, this.getI000000216());
			}
			if(this.getI000000217() == null || this.getI000000217().equals("null")) {
				pstmt.setNull(421, 12);
			} else {
				pstmt.setString(421, this.getI000000217());
			}
			if(this.getI000000218() == null || this.getI000000218().equals("null")) {
				pstmt.setNull(422, 12);
			} else {
				pstmt.setString(422, this.getI000000218());
			}
			if(this.getI000000219() == null || this.getI000000219().equals("null")) {
				pstmt.setNull(423, 12);
			} else {
				pstmt.setString(423, this.getI000000219());
			}
			if(this.getI000000220() == null || this.getI000000220().equals("null")) {
				pstmt.setNull(424, 12);
			} else {
				pstmt.setString(424, this.getI000000220());
			}
			if(this.getI000000221() == null || this.getI000000221().equals("null")) {
				pstmt.setNull(425, 12);
			} else {
				pstmt.setString(425, this.getI000000221());
			}
			if(this.getI000000222() == null || this.getI000000222().equals("null")) {
				pstmt.setNull(426, 12);
			} else {
				pstmt.setString(426, this.getI000000222());
			}
			if(this.getI000000224() == null || this.getI000000224().equals("null")) {
				pstmt.setNull(427, 12);
			} else {
				pstmt.setString(427, this.getI000000224());
			}
			if(this.getI000000225() == null || this.getI000000225().equals("null")) {
				pstmt.setNull(428, 12);
			} else {
				pstmt.setString(428, this.getI000000225());
			}
			if(this.getI000000226() == null || this.getI000000226().equals("null")) {
				pstmt.setNull(429, 12);
			} else {
				pstmt.setString(429, this.getI000000226());
			}
			if(this.getI000000227() == null || this.getI000000227().equals("null")) {
				pstmt.setNull(430, 12);
			} else {
				pstmt.setString(430, this.getI000000227());
			}
			if(this.getI000000228() == null || this.getI000000228().equals("null")) {
				pstmt.setNull(431, 12);
			} else {
				pstmt.setString(431, this.getI000000228());
			}
			if(this.getI000000229() == null || this.getI000000229().equals("null")) {
				pstmt.setNull(432, 12);
			} else {
				pstmt.setString(432, this.getI000000229());
			}
			if(this.getI000000231() == null || this.getI000000231().equals("null")) {
				pstmt.setNull(433, 12);
			} else {
				pstmt.setString(433, this.getI000000231());
			}
			if(this.getI000000232() == null || this.getI000000232().equals("null")) {
				pstmt.setNull(434, 12);
			} else {
				pstmt.setString(434, this.getI000000232());
			}
			if(this.getI000000233() == null || this.getI000000233().equals("null")) {
				pstmt.setNull(435, 12);
			} else {
				pstmt.setString(435, this.getI000000233());
			}
			if(this.getI000000234() == null || this.getI000000234().equals("null")) {
				pstmt.setNull(436, 12);
			} else {
				pstmt.setString(436, this.getI000000234());
			}
			if(this.getI000000235() == null || this.getI000000235().equals("null")) {
				pstmt.setNull(437, 12);
			} else {
				pstmt.setString(437, this.getI000000235());
			}
			if(this.getI000000236() == null || this.getI000000236().equals("null")) {
				pstmt.setNull(438, 12);
			} else {
				pstmt.setString(438, this.getI000000236());
			}
			if(this.getI000000237() == null || this.getI000000237().equals("null")) {
				pstmt.setNull(439, 12);
			} else {
				pstmt.setString(439, this.getI000000237());
			}
			if(this.getI000000240() == null || this.getI000000240().equals("null")) {
				pstmt.setNull(440, 12);
			} else {
				pstmt.setString(440, this.getI000000240());
			}
			if(this.getI000000241() == null || this.getI000000241().equals("null")) {
				pstmt.setNull(441, 12);
			} else {
				pstmt.setString(441, this.getI000000241());
			}
			if(this.getI000000242() == null || this.getI000000242().equals("null")) {
				pstmt.setNull(442, 12);
			} else {
				pstmt.setString(442, this.getI000000242());
			}
			if(this.getI000000243() == null || this.getI000000243().equals("null")) {
				pstmt.setNull(443, 12);
			} else {
				pstmt.setString(443, this.getI000000243());
			}
			if(this.getI000000244() == null || this.getI000000244().equals("null")) {
				pstmt.setNull(444, 12);
			} else {
				pstmt.setString(444, this.getI000000244());
			}
			if(this.getI000000245() == null || this.getI000000245().equals("null")) {
				pstmt.setNull(445, 12);
			} else {
				pstmt.setString(445, this.getI000000245());
			}
			if(this.getI000000246() == null || this.getI000000246().equals("null")) {
				pstmt.setNull(446, 12);
			} else {
				pstmt.setString(446, this.getI000000246());
			}
			if(this.getI000000247() == null || this.getI000000247().equals("null")) {
				pstmt.setNull(447, 12);
			} else {
				pstmt.setString(447, this.getI000000247());
			}
			if(this.getI000000248() == null || this.getI000000248().equals("null")) {
				pstmt.setNull(448, 12);
			} else {
				pstmt.setString(448, this.getI000000248());
			}
			if(this.getI000000249() == null || this.getI000000249().equals("null")) {
				pstmt.setNull(449, 12);
			} else {
				pstmt.setString(449, this.getI000000249());
			}
			if(this.getI000000250() == null || this.getI000000250().equals("null")) {
				pstmt.setNull(450, 12);
			} else {
				pstmt.setString(450, this.getI000000250());
			}
			if(this.getI000000251() == null || this.getI000000251().equals("null")) {
				pstmt.setNull(451, 12);
			} else {
				pstmt.setString(451, this.getI000000251());
			}
			if(this.getR000000201() == null || this.getR000000201().equals("null")) {
				pstmt.setNull(452, 12);
			} else {
				pstmt.setString(452, this.getR000000201());
			}
			if(this.getR000000202() == null || this.getR000000202().equals("null")) {
				pstmt.setNull(453, 12);
			} else {
				pstmt.setString(453, this.getR000000202());
			}
			if(this.getR000000203() == null || this.getR000000203().equals("null")) {
				pstmt.setNull(454, 12);
			} else {
				pstmt.setString(454, this.getR000000203());
			}
			if(this.getR000000204() == null || this.getR000000204().equals("null")) {
				pstmt.setNull(455, 12);
			} else {
				pstmt.setString(455, this.getR000000204());
			}
			if(this.getR000000205() == null || this.getR000000205().equals("null")) {
				pstmt.setNull(456, 12);
			} else {
				pstmt.setString(456, this.getR000000205());
			}
			if(this.getI000000254() == null || this.getI000000254().equals("null")) {
				pstmt.setNull(457, 12);
			} else {
				pstmt.setString(457, this.getI000000254());
			}
			// set where condition
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(458, 12);
			} else {
				pstmt.setString(458, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(459, 12);
			} else {
				pstmt.setString(459, this.getIndexType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(460, 12);
			} else {
				pstmt.setString(460, this.getAgentCode());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		// only for debug purpose
		SQLString sqlObj = new SQLString("LAIndexInfoVTemp");
		sqlObj.setSQL(1, this);
		sqlObj.getSQL();

		try
		{
			pstmt = con.prepareStatement("INSERT INTO LAIndexInfoVTemp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getBranchType() == null || this.getBranchType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getBranchType());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getIndexType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(4, 12);
			} else {
				pstmt.setString(4, this.getAgentCode());
			}
			if(this.getAgentGrade() == null || this.getAgentGrade().equals("null")) {
				pstmt.setNull(5, 12);
			} else {
				pstmt.setString(5, this.getAgentGrade());
			}
			if(this.getAgentGroup() == null || this.getAgentGroup().equals("null")) {
				pstmt.setNull(6, 12);
			} else {
				pstmt.setString(6, this.getAgentGroup());
			}
			if(this.getState() == null || this.getState().equals("null")) {
				pstmt.setNull(7, 12);
			} else {
				pstmt.setString(7, this.getState());
			}
			if(this.getMakeDate() == null || this.getMakeDate().equals("null")) {
				pstmt.setNull(8, 91);
			} else {
				pstmt.setDate(8, Date.valueOf(this.getMakeDate()));
			}
			if(this.getMakeTime() == null || this.getMakeTime().equals("null")) {
				pstmt.setNull(9, 12);
			} else {
				pstmt.setString(9, this.getMakeTime());
			}
			if(this.getModifyDate() == null || this.getModifyDate().equals("null")) {
				pstmt.setNull(10, 91);
			} else {
				pstmt.setDate(10, Date.valueOf(this.getModifyDate()));
			}
			if(this.getModifyTime() == null || this.getModifyTime().equals("null")) {
				pstmt.setNull(11, 12);
			} else {
				pstmt.setString(11, this.getModifyTime());
			}
			if(this.getI000000001() == null || this.getI000000001().equals("null")) {
				pstmt.setNull(12, 12);
			} else {
				pstmt.setString(12, this.getI000000001());
			}
			if(this.getI000000002() == null || this.getI000000002().equals("null")) {
				pstmt.setNull(13, 12);
			} else {
				pstmt.setString(13, this.getI000000002());
			}
			if(this.getI000000003() == null || this.getI000000003().equals("null")) {
				pstmt.setNull(14, 12);
			} else {
				pstmt.setString(14, this.getI000000003());
			}
			if(this.getI000000004() == null || this.getI000000004().equals("null")) {
				pstmt.setNull(15, 12);
			} else {
				pstmt.setString(15, this.getI000000004());
			}
			if(this.getI000000005() == null || this.getI000000005().equals("null")) {
				pstmt.setNull(16, 12);
			} else {
				pstmt.setString(16, this.getI000000005());
			}
			if(this.getI000000006() == null || this.getI000000006().equals("null")) {
				pstmt.setNull(17, 12);
			} else {
				pstmt.setString(17, this.getI000000006());
			}
			if(this.getI000000007() == null || this.getI000000007().equals("null")) {
				pstmt.setNull(18, 12);
			} else {
				pstmt.setString(18, this.getI000000007());
			}
			if(this.getI000000008() == null || this.getI000000008().equals("null")) {
				pstmt.setNull(19, 12);
			} else {
				pstmt.setString(19, this.getI000000008());
			}
			if(this.getI000000009() == null || this.getI000000009().equals("null")) {
				pstmt.setNull(20, 12);
			} else {
				pstmt.setString(20, this.getI000000009());
			}
			if(this.getI000000010() == null || this.getI000000010().equals("null")) {
				pstmt.setNull(21, 12);
			} else {
				pstmt.setString(21, this.getI000000010());
			}
			if(this.getI000000011() == null || this.getI000000011().equals("null")) {
				pstmt.setNull(22, 12);
			} else {
				pstmt.setString(22, this.getI000000011());
			}
			if(this.getI000000012() == null || this.getI000000012().equals("null")) {
				pstmt.setNull(23, 12);
			} else {
				pstmt.setString(23, this.getI000000012());
			}
			if(this.getI000000013() == null || this.getI000000013().equals("null")) {
				pstmt.setNull(24, 12);
			} else {
				pstmt.setString(24, this.getI000000013());
			}
			if(this.getI000000014() == null || this.getI000000014().equals("null")) {
				pstmt.setNull(25, 12);
			} else {
				pstmt.setString(25, this.getI000000014());
			}
			if(this.getI000000015() == null || this.getI000000015().equals("null")) {
				pstmt.setNull(26, 12);
			} else {
				pstmt.setString(26, this.getI000000015());
			}
			if(this.getI000000016() == null || this.getI000000016().equals("null")) {
				pstmt.setNull(27, 12);
			} else {
				pstmt.setString(27, this.getI000000016());
			}
			if(this.getI000000017() == null || this.getI000000017().equals("null")) {
				pstmt.setNull(28, 12);
			} else {
				pstmt.setString(28, this.getI000000017());
			}
			if(this.getI000000018() == null || this.getI000000018().equals("null")) {
				pstmt.setNull(29, 12);
			} else {
				pstmt.setString(29, this.getI000000018());
			}
			if(this.getI000000019() == null || this.getI000000019().equals("null")) {
				pstmt.setNull(30, 12);
			} else {
				pstmt.setString(30, this.getI000000019());
			}
			if(this.getI000000020() == null || this.getI000000020().equals("null")) {
				pstmt.setNull(31, 12);
			} else {
				pstmt.setString(31, this.getI000000020());
			}
			if(this.getI000000021() == null || this.getI000000021().equals("null")) {
				pstmt.setNull(32, 12);
			} else {
				pstmt.setString(32, this.getI000000021());
			}
			if(this.getI000000022() == null || this.getI000000022().equals("null")) {
				pstmt.setNull(33, 12);
			} else {
				pstmt.setString(33, this.getI000000022());
			}
			if(this.getI000000023() == null || this.getI000000023().equals("null")) {
				pstmt.setNull(34, 12);
			} else {
				pstmt.setString(34, this.getI000000023());
			}
			if(this.getI000000024() == null || this.getI000000024().equals("null")) {
				pstmt.setNull(35, 12);
			} else {
				pstmt.setString(35, this.getI000000024());
			}
			if(this.getI000000025() == null || this.getI000000025().equals("null")) {
				pstmt.setNull(36, 12);
			} else {
				pstmt.setString(36, this.getI000000025());
			}
			if(this.getI000000026() == null || this.getI000000026().equals("null")) {
				pstmt.setNull(37, 12);
			} else {
				pstmt.setString(37, this.getI000000026());
			}
			if(this.getI000000027() == null || this.getI000000027().equals("null")) {
				pstmt.setNull(38, 12);
			} else {
				pstmt.setString(38, this.getI000000027());
			}
			if(this.getI000000028() == null || this.getI000000028().equals("null")) {
				pstmt.setNull(39, 12);
			} else {
				pstmt.setString(39, this.getI000000028());
			}
			if(this.getI000000029() == null || this.getI000000029().equals("null")) {
				pstmt.setNull(40, 12);
			} else {
				pstmt.setString(40, this.getI000000029());
			}
			if(this.getI000000030() == null || this.getI000000030().equals("null")) {
				pstmt.setNull(41, 12);
			} else {
				pstmt.setString(41, this.getI000000030());
			}
			if(this.getI000000031() == null || this.getI000000031().equals("null")) {
				pstmt.setNull(42, 12);
			} else {
				pstmt.setString(42, this.getI000000031());
			}
			if(this.getI000000032() == null || this.getI000000032().equals("null")) {
				pstmt.setNull(43, 12);
			} else {
				pstmt.setString(43, this.getI000000032());
			}
			if(this.getI000000033() == null || this.getI000000033().equals("null")) {
				pstmt.setNull(44, 12);
			} else {
				pstmt.setString(44, this.getI000000033());
			}
			if(this.getI000000034() == null || this.getI000000034().equals("null")) {
				pstmt.setNull(45, 12);
			} else {
				pstmt.setString(45, this.getI000000034());
			}
			if(this.getI000000035() == null || this.getI000000035().equals("null")) {
				pstmt.setNull(46, 12);
			} else {
				pstmt.setString(46, this.getI000000035());
			}
			if(this.getI000000036() == null || this.getI000000036().equals("null")) {
				pstmt.setNull(47, 12);
			} else {
				pstmt.setString(47, this.getI000000036());
			}
			if(this.getI000000037() == null || this.getI000000037().equals("null")) {
				pstmt.setNull(48, 12);
			} else {
				pstmt.setString(48, this.getI000000037());
			}
			if(this.getI000000038() == null || this.getI000000038().equals("null")) {
				pstmt.setNull(49, 12);
			} else {
				pstmt.setString(49, this.getI000000038());
			}
			if(this.getI000000039() == null || this.getI000000039().equals("null")) {
				pstmt.setNull(50, 12);
			} else {
				pstmt.setString(50, this.getI000000039());
			}
			if(this.getI000000040() == null || this.getI000000040().equals("null")) {
				pstmt.setNull(51, 12);
			} else {
				pstmt.setString(51, this.getI000000040());
			}
			if(this.getI000000041() == null || this.getI000000041().equals("null")) {
				pstmt.setNull(52, 12);
			} else {
				pstmt.setString(52, this.getI000000041());
			}
			if(this.getI000000042() == null || this.getI000000042().equals("null")) {
				pstmt.setNull(53, 12);
			} else {
				pstmt.setString(53, this.getI000000042());
			}
			if(this.getI000000043() == null || this.getI000000043().equals("null")) {
				pstmt.setNull(54, 12);
			} else {
				pstmt.setString(54, this.getI000000043());
			}
			if(this.getI000000044() == null || this.getI000000044().equals("null")) {
				pstmt.setNull(55, 12);
			} else {
				pstmt.setString(55, this.getI000000044());
			}
			if(this.getI000000045() == null || this.getI000000045().equals("null")) {
				pstmt.setNull(56, 12);
			} else {
				pstmt.setString(56, this.getI000000045());
			}
			if(this.getI000000046() == null || this.getI000000046().equals("null")) {
				pstmt.setNull(57, 12);
			} else {
				pstmt.setString(57, this.getI000000046());
			}
			if(this.getI000000047() == null || this.getI000000047().equals("null")) {
				pstmt.setNull(58, 12);
			} else {
				pstmt.setString(58, this.getI000000047());
			}
			if(this.getI000000048() == null || this.getI000000048().equals("null")) {
				pstmt.setNull(59, 12);
			} else {
				pstmt.setString(59, this.getI000000048());
			}
			if(this.getI000000049() == null || this.getI000000049().equals("null")) {
				pstmt.setNull(60, 12);
			} else {
				pstmt.setString(60, this.getI000000049());
			}
			if(this.getI000000050() == null || this.getI000000050().equals("null")) {
				pstmt.setNull(61, 12);
			} else {
				pstmt.setString(61, this.getI000000050());
			}
			if(this.getI000000051() == null || this.getI000000051().equals("null")) {
				pstmt.setNull(62, 12);
			} else {
				pstmt.setString(62, this.getI000000051());
			}
			if(this.getI000000052() == null || this.getI000000052().equals("null")) {
				pstmt.setNull(63, 12);
			} else {
				pstmt.setString(63, this.getI000000052());
			}
			if(this.getI000000053() == null || this.getI000000053().equals("null")) {
				pstmt.setNull(64, 12);
			} else {
				pstmt.setString(64, this.getI000000053());
			}
			if(this.getI000000054() == null || this.getI000000054().equals("null")) {
				pstmt.setNull(65, 12);
			} else {
				pstmt.setString(65, this.getI000000054());
			}
			if(this.getI000000055() == null || this.getI000000055().equals("null")) {
				pstmt.setNull(66, 12);
			} else {
				pstmt.setString(66, this.getI000000055());
			}
			if(this.getI000000056() == null || this.getI000000056().equals("null")) {
				pstmt.setNull(67, 12);
			} else {
				pstmt.setString(67, this.getI000000056());
			}
			if(this.getI000000057() == null || this.getI000000057().equals("null")) {
				pstmt.setNull(68, 12);
			} else {
				pstmt.setString(68, this.getI000000057());
			}
			if(this.getI000000058() == null || this.getI000000058().equals("null")) {
				pstmt.setNull(69, 12);
			} else {
				pstmt.setString(69, this.getI000000058());
			}
			if(this.getI000000059() == null || this.getI000000059().equals("null")) {
				pstmt.setNull(70, 12);
			} else {
				pstmt.setString(70, this.getI000000059());
			}
			if(this.getI000000060() == null || this.getI000000060().equals("null")) {
				pstmt.setNull(71, 12);
			} else {
				pstmt.setString(71, this.getI000000060());
			}
			if(this.getI000000061() == null || this.getI000000061().equals("null")) {
				pstmt.setNull(72, 12);
			} else {
				pstmt.setString(72, this.getI000000061());
			}
			if(this.getI000000062() == null || this.getI000000062().equals("null")) {
				pstmt.setNull(73, 12);
			} else {
				pstmt.setString(73, this.getI000000062());
			}
			if(this.getI000000063() == null || this.getI000000063().equals("null")) {
				pstmt.setNull(74, 12);
			} else {
				pstmt.setString(74, this.getI000000063());
			}
			if(this.getI000000064() == null || this.getI000000064().equals("null")) {
				pstmt.setNull(75, 12);
			} else {
				pstmt.setString(75, this.getI000000064());
			}
			if(this.getI000000065() == null || this.getI000000065().equals("null")) {
				pstmt.setNull(76, 12);
			} else {
				pstmt.setString(76, this.getI000000065());
			}
			if(this.getI000000066() == null || this.getI000000066().equals("null")) {
				pstmt.setNull(77, 12);
			} else {
				pstmt.setString(77, this.getI000000066());
			}
			if(this.getI000000067() == null || this.getI000000067().equals("null")) {
				pstmt.setNull(78, 12);
			} else {
				pstmt.setString(78, this.getI000000067());
			}
			if(this.getI000000068() == null || this.getI000000068().equals("null")) {
				pstmt.setNull(79, 12);
			} else {
				pstmt.setString(79, this.getI000000068());
			}
			if(this.getI000000069() == null || this.getI000000069().equals("null")) {
				pstmt.setNull(80, 12);
			} else {
				pstmt.setString(80, this.getI000000069());
			}
			if(this.getI000000070() == null || this.getI000000070().equals("null")) {
				pstmt.setNull(81, 12);
			} else {
				pstmt.setString(81, this.getI000000070());
			}
			if(this.getI000000071() == null || this.getI000000071().equals("null")) {
				pstmt.setNull(82, 12);
			} else {
				pstmt.setString(82, this.getI000000071());
			}
			if(this.getI000000072() == null || this.getI000000072().equals("null")) {
				pstmt.setNull(83, 12);
			} else {
				pstmt.setString(83, this.getI000000072());
			}
			if(this.getI000000073() == null || this.getI000000073().equals("null")) {
				pstmt.setNull(84, 12);
			} else {
				pstmt.setString(84, this.getI000000073());
			}
			if(this.getI000000074() == null || this.getI000000074().equals("null")) {
				pstmt.setNull(85, 12);
			} else {
				pstmt.setString(85, this.getI000000074());
			}
			if(this.getI000000075() == null || this.getI000000075().equals("null")) {
				pstmt.setNull(86, 12);
			} else {
				pstmt.setString(86, this.getI000000075());
			}
			if(this.getI000000076() == null || this.getI000000076().equals("null")) {
				pstmt.setNull(87, 12);
			} else {
				pstmt.setString(87, this.getI000000076());
			}
			if(this.getI000000077() == null || this.getI000000077().equals("null")) {
				pstmt.setNull(88, 12);
			} else {
				pstmt.setString(88, this.getI000000077());
			}
			if(this.getI000000078() == null || this.getI000000078().equals("null")) {
				pstmt.setNull(89, 12);
			} else {
				pstmt.setString(89, this.getI000000078());
			}
			if(this.getI000000079() == null || this.getI000000079().equals("null")) {
				pstmt.setNull(90, 12);
			} else {
				pstmt.setString(90, this.getI000000079());
			}
			if(this.getI000000080() == null || this.getI000000080().equals("null")) {
				pstmt.setNull(91, 12);
			} else {
				pstmt.setString(91, this.getI000000080());
			}
			if(this.getI000000081() == null || this.getI000000081().equals("null")) {
				pstmt.setNull(92, 12);
			} else {
				pstmt.setString(92, this.getI000000081());
			}
			if(this.getI000000082() == null || this.getI000000082().equals("null")) {
				pstmt.setNull(93, 12);
			} else {
				pstmt.setString(93, this.getI000000082());
			}
			if(this.getI000000083() == null || this.getI000000083().equals("null")) {
				pstmt.setNull(94, 12);
			} else {
				pstmt.setString(94, this.getI000000083());
			}
			if(this.getI000000084() == null || this.getI000000084().equals("null")) {
				pstmt.setNull(95, 12);
			} else {
				pstmt.setString(95, this.getI000000084());
			}
			if(this.getI000000085() == null || this.getI000000085().equals("null")) {
				pstmt.setNull(96, 12);
			} else {
				pstmt.setString(96, this.getI000000085());
			}
			if(this.getI000000086() == null || this.getI000000086().equals("null")) {
				pstmt.setNull(97, 12);
			} else {
				pstmt.setString(97, this.getI000000086());
			}
			if(this.getI000000087() == null || this.getI000000087().equals("null")) {
				pstmt.setNull(98, 12);
			} else {
				pstmt.setString(98, this.getI000000087());
			}
			if(this.getI000000088() == null || this.getI000000088().equals("null")) {
				pstmt.setNull(99, 12);
			} else {
				pstmt.setString(99, this.getI000000088());
			}
			if(this.getI000000089() == null || this.getI000000089().equals("null")) {
				pstmt.setNull(100, 12);
			} else {
				pstmt.setString(100, this.getI000000089());
			}
			if(this.getI000000090() == null || this.getI000000090().equals("null")) {
				pstmt.setNull(101, 12);
			} else {
				pstmt.setString(101, this.getI000000090());
			}
			if(this.getI000000091() == null || this.getI000000091().equals("null")) {
				pstmt.setNull(102, 12);
			} else {
				pstmt.setString(102, this.getI000000091());
			}
			if(this.getI000000092() == null || this.getI000000092().equals("null")) {
				pstmt.setNull(103, 12);
			} else {
				pstmt.setString(103, this.getI000000092());
			}
			if(this.getI000000093() == null || this.getI000000093().equals("null")) {
				pstmt.setNull(104, 12);
			} else {
				pstmt.setString(104, this.getI000000093());
			}
			if(this.getI000000094() == null || this.getI000000094().equals("null")) {
				pstmt.setNull(105, 12);
			} else {
				pstmt.setString(105, this.getI000000094());
			}
			if(this.getI000000095() == null || this.getI000000095().equals("null")) {
				pstmt.setNull(106, 12);
			} else {
				pstmt.setString(106, this.getI000000095());
			}
			if(this.getI000000096() == null || this.getI000000096().equals("null")) {
				pstmt.setNull(107, 12);
			} else {
				pstmt.setString(107, this.getI000000096());
			}
			if(this.getI000000097() == null || this.getI000000097().equals("null")) {
				pstmt.setNull(108, 12);
			} else {
				pstmt.setString(108, this.getI000000097());
			}
			if(this.getI000000098() == null || this.getI000000098().equals("null")) {
				pstmt.setNull(109, 12);
			} else {
				pstmt.setString(109, this.getI000000098());
			}
			if(this.getI000000099() == null || this.getI000000099().equals("null")) {
				pstmt.setNull(110, 12);
			} else {
				pstmt.setString(110, this.getI000000099());
			}
			if(this.getI000000100() == null || this.getI000000100().equals("null")) {
				pstmt.setNull(111, 12);
			} else {
				pstmt.setString(111, this.getI000000100());
			}
			if(this.getI000000101() == null || this.getI000000101().equals("null")) {
				pstmt.setNull(112, 12);
			} else {
				pstmt.setString(112, this.getI000000101());
			}
			if(this.getI000000102() == null || this.getI000000102().equals("null")) {
				pstmt.setNull(113, 12);
			} else {
				pstmt.setString(113, this.getI000000102());
			}
			if(this.getI000000103() == null || this.getI000000103().equals("null")) {
				pstmt.setNull(114, 12);
			} else {
				pstmt.setString(114, this.getI000000103());
			}
			if(this.getI000000104() == null || this.getI000000104().equals("null")) {
				pstmt.setNull(115, 12);
			} else {
				pstmt.setString(115, this.getI000000104());
			}
			if(this.getI000000105() == null || this.getI000000105().equals("null")) {
				pstmt.setNull(116, 12);
			} else {
				pstmt.setString(116, this.getI000000105());
			}
			if(this.getI000000106() == null || this.getI000000106().equals("null")) {
				pstmt.setNull(117, 12);
			} else {
				pstmt.setString(117, this.getI000000106());
			}
			if(this.getI000000107() == null || this.getI000000107().equals("null")) {
				pstmt.setNull(118, 12);
			} else {
				pstmt.setString(118, this.getI000000107());
			}
			if(this.getI000000108() == null || this.getI000000108().equals("null")) {
				pstmt.setNull(119, 12);
			} else {
				pstmt.setString(119, this.getI000000108());
			}
			if(this.getI000000109() == null || this.getI000000109().equals("null")) {
				pstmt.setNull(120, 12);
			} else {
				pstmt.setString(120, this.getI000000109());
			}
			if(this.getI000000110() == null || this.getI000000110().equals("null")) {
				pstmt.setNull(121, 12);
			} else {
				pstmt.setString(121, this.getI000000110());
			}
			if(this.getI000000111() == null || this.getI000000111().equals("null")) {
				pstmt.setNull(122, 12);
			} else {
				pstmt.setString(122, this.getI000000111());
			}
			if(this.getI000000112() == null || this.getI000000112().equals("null")) {
				pstmt.setNull(123, 12);
			} else {
				pstmt.setString(123, this.getI000000112());
			}
			if(this.getI000000113() == null || this.getI000000113().equals("null")) {
				pstmt.setNull(124, 12);
			} else {
				pstmt.setString(124, this.getI000000113());
			}
			if(this.getI000000114() == null || this.getI000000114().equals("null")) {
				pstmt.setNull(125, 12);
			} else {
				pstmt.setString(125, this.getI000000114());
			}
			if(this.getI000000115() == null || this.getI000000115().equals("null")) {
				pstmt.setNull(126, 12);
			} else {
				pstmt.setString(126, this.getI000000115());
			}
			if(this.getI000000116() == null || this.getI000000116().equals("null")) {
				pstmt.setNull(127, 12);
			} else {
				pstmt.setString(127, this.getI000000116());
			}
			if(this.getI000000117() == null || this.getI000000117().equals("null")) {
				pstmt.setNull(128, 12);
			} else {
				pstmt.setString(128, this.getI000000117());
			}
			if(this.getI000000118() == null || this.getI000000118().equals("null")) {
				pstmt.setNull(129, 12);
			} else {
				pstmt.setString(129, this.getI000000118());
			}
			if(this.getI000000119() == null || this.getI000000119().equals("null")) {
				pstmt.setNull(130, 12);
			} else {
				pstmt.setString(130, this.getI000000119());
			}
			if(this.getI000000120() == null || this.getI000000120().equals("null")) {
				pstmt.setNull(131, 12);
			} else {
				pstmt.setString(131, this.getI000000120());
			}
			if(this.getI000000121() == null || this.getI000000121().equals("null")) {
				pstmt.setNull(132, 12);
			} else {
				pstmt.setString(132, this.getI000000121());
			}
			if(this.getI000000122() == null || this.getI000000122().equals("null")) {
				pstmt.setNull(133, 12);
			} else {
				pstmt.setString(133, this.getI000000122());
			}
			if(this.getI000000123() == null || this.getI000000123().equals("null")) {
				pstmt.setNull(134, 12);
			} else {
				pstmt.setString(134, this.getI000000123());
			}
			if(this.getI000000124() == null || this.getI000000124().equals("null")) {
				pstmt.setNull(135, 12);
			} else {
				pstmt.setString(135, this.getI000000124());
			}
			if(this.getI000000125() == null || this.getI000000125().equals("null")) {
				pstmt.setNull(136, 12);
			} else {
				pstmt.setString(136, this.getI000000125());
			}
			if(this.getI000000126() == null || this.getI000000126().equals("null")) {
				pstmt.setNull(137, 12);
			} else {
				pstmt.setString(137, this.getI000000126());
			}
			if(this.getI000000127() == null || this.getI000000127().equals("null")) {
				pstmt.setNull(138, 12);
			} else {
				pstmt.setString(138, this.getI000000127());
			}
			if(this.getI000000128() == null || this.getI000000128().equals("null")) {
				pstmt.setNull(139, 12);
			} else {
				pstmt.setString(139, this.getI000000128());
			}
			if(this.getI000000129() == null || this.getI000000129().equals("null")) {
				pstmt.setNull(140, 12);
			} else {
				pstmt.setString(140, this.getI000000129());
			}
			if(this.getI000000130() == null || this.getI000000130().equals("null")) {
				pstmt.setNull(141, 12);
			} else {
				pstmt.setString(141, this.getI000000130());
			}
			if(this.getI000000131() == null || this.getI000000131().equals("null")) {
				pstmt.setNull(142, 12);
			} else {
				pstmt.setString(142, this.getI000000131());
			}
			if(this.getI000000132() == null || this.getI000000132().equals("null")) {
				pstmt.setNull(143, 12);
			} else {
				pstmt.setString(143, this.getI000000132());
			}
			if(this.getI000000133() == null || this.getI000000133().equals("null")) {
				pstmt.setNull(144, 12);
			} else {
				pstmt.setString(144, this.getI000000133());
			}
			if(this.getI000000134() == null || this.getI000000134().equals("null")) {
				pstmt.setNull(145, 12);
			} else {
				pstmt.setString(145, this.getI000000134());
			}
			if(this.getI000000135() == null || this.getI000000135().equals("null")) {
				pstmt.setNull(146, 12);
			} else {
				pstmt.setString(146, this.getI000000135());
			}
			if(this.getI000000136() == null || this.getI000000136().equals("null")) {
				pstmt.setNull(147, 12);
			} else {
				pstmt.setString(147, this.getI000000136());
			}
			if(this.getI000000137() == null || this.getI000000137().equals("null")) {
				pstmt.setNull(148, 12);
			} else {
				pstmt.setString(148, this.getI000000137());
			}
			if(this.getI000000138() == null || this.getI000000138().equals("null")) {
				pstmt.setNull(149, 12);
			} else {
				pstmt.setString(149, this.getI000000138());
			}
			if(this.getI000000139() == null || this.getI000000139().equals("null")) {
				pstmt.setNull(150, 12);
			} else {
				pstmt.setString(150, this.getI000000139());
			}
			if(this.getI000000140() == null || this.getI000000140().equals("null")) {
				pstmt.setNull(151, 12);
			} else {
				pstmt.setString(151, this.getI000000140());
			}
			if(this.getI000000141() == null || this.getI000000141().equals("null")) {
				pstmt.setNull(152, 12);
			} else {
				pstmt.setString(152, this.getI000000141());
			}
			if(this.getI000000142() == null || this.getI000000142().equals("null")) {
				pstmt.setNull(153, 12);
			} else {
				pstmt.setString(153, this.getI000000142());
			}
			if(this.getI000000143() == null || this.getI000000143().equals("null")) {
				pstmt.setNull(154, 12);
			} else {
				pstmt.setString(154, this.getI000000143());
			}
			if(this.getI000000144() == null || this.getI000000144().equals("null")) {
				pstmt.setNull(155, 12);
			} else {
				pstmt.setString(155, this.getI000000144());
			}
			if(this.getI000000145() == null || this.getI000000145().equals("null")) {
				pstmt.setNull(156, 12);
			} else {
				pstmt.setString(156, this.getI000000145());
			}
			if(this.getI000000146() == null || this.getI000000146().equals("null")) {
				pstmt.setNull(157, 12);
			} else {
				pstmt.setString(157, this.getI000000146());
			}
			if(this.getI000000147() == null || this.getI000000147().equals("null")) {
				pstmt.setNull(158, 12);
			} else {
				pstmt.setString(158, this.getI000000147());
			}
			if(this.getI000000148() == null || this.getI000000148().equals("null")) {
				pstmt.setNull(159, 12);
			} else {
				pstmt.setString(159, this.getI000000148());
			}
			if(this.getI000000149() == null || this.getI000000149().equals("null")) {
				pstmt.setNull(160, 12);
			} else {
				pstmt.setString(160, this.getI000000149());
			}
			if(this.getI000000150() == null || this.getI000000150().equals("null")) {
				pstmt.setNull(161, 12);
			} else {
				pstmt.setString(161, this.getI000000150());
			}
			if(this.getI000000151() == null || this.getI000000151().equals("null")) {
				pstmt.setNull(162, 12);
			} else {
				pstmt.setString(162, this.getI000000151());
			}
			if(this.getI000000152() == null || this.getI000000152().equals("null")) {
				pstmt.setNull(163, 12);
			} else {
				pstmt.setString(163, this.getI000000152());
			}
			if(this.getI000000153() == null || this.getI000000153().equals("null")) {
				pstmt.setNull(164, 12);
			} else {
				pstmt.setString(164, this.getI000000153());
			}
			if(this.getI000000154() == null || this.getI000000154().equals("null")) {
				pstmt.setNull(165, 12);
			} else {
				pstmt.setString(165, this.getI000000154());
			}
			if(this.getI000000155() == null || this.getI000000155().equals("null")) {
				pstmt.setNull(166, 12);
			} else {
				pstmt.setString(166, this.getI000000155());
			}
			if(this.getI000000156() == null || this.getI000000156().equals("null")) {
				pstmt.setNull(167, 12);
			} else {
				pstmt.setString(167, this.getI000000156());
			}
			if(this.getI000000157() == null || this.getI000000157().equals("null")) {
				pstmt.setNull(168, 12);
			} else {
				pstmt.setString(168, this.getI000000157());
			}
			if(this.getI000000158() == null || this.getI000000158().equals("null")) {
				pstmt.setNull(169, 12);
			} else {
				pstmt.setString(169, this.getI000000158());
			}
			if(this.getI000000159() == null || this.getI000000159().equals("null")) {
				pstmt.setNull(170, 12);
			} else {
				pstmt.setString(170, this.getI000000159());
			}
			if(this.getI000000160() == null || this.getI000000160().equals("null")) {
				pstmt.setNull(171, 12);
			} else {
				pstmt.setString(171, this.getI000000160());
			}
			if(this.getI000000161() == null || this.getI000000161().equals("null")) {
				pstmt.setNull(172, 12);
			} else {
				pstmt.setString(172, this.getI000000161());
			}
			if(this.getI000000162() == null || this.getI000000162().equals("null")) {
				pstmt.setNull(173, 12);
			} else {
				pstmt.setString(173, this.getI000000162());
			}
			if(this.getI000000163() == null || this.getI000000163().equals("null")) {
				pstmt.setNull(174, 12);
			} else {
				pstmt.setString(174, this.getI000000163());
			}
			if(this.getI000000164() == null || this.getI000000164().equals("null")) {
				pstmt.setNull(175, 12);
			} else {
				pstmt.setString(175, this.getI000000164());
			}
			if(this.getI000000165() == null || this.getI000000165().equals("null")) {
				pstmt.setNull(176, 12);
			} else {
				pstmt.setString(176, this.getI000000165());
			}
			if(this.getI000000166() == null || this.getI000000166().equals("null")) {
				pstmt.setNull(177, 12);
			} else {
				pstmt.setString(177, this.getI000000166());
			}
			if(this.getI000000167() == null || this.getI000000167().equals("null")) {
				pstmt.setNull(178, 12);
			} else {
				pstmt.setString(178, this.getI000000167());
			}
			if(this.getI000000168() == null || this.getI000000168().equals("null")) {
				pstmt.setNull(179, 12);
			} else {
				pstmt.setString(179, this.getI000000168());
			}
			if(this.getI000000169() == null || this.getI000000169().equals("null")) {
				pstmt.setNull(180, 12);
			} else {
				pstmt.setString(180, this.getI000000169());
			}
			if(this.getI000000170() == null || this.getI000000170().equals("null")) {
				pstmt.setNull(181, 12);
			} else {
				pstmt.setString(181, this.getI000000170());
			}
			if(this.getI000000171() == null || this.getI000000171().equals("null")) {
				pstmt.setNull(182, 12);
			} else {
				pstmt.setString(182, this.getI000000171());
			}
			if(this.getI000000172() == null || this.getI000000172().equals("null")) {
				pstmt.setNull(183, 12);
			} else {
				pstmt.setString(183, this.getI000000172());
			}
			if(this.getI000000173() == null || this.getI000000173().equals("null")) {
				pstmt.setNull(184, 12);
			} else {
				pstmt.setString(184, this.getI000000173());
			}
			if(this.getI000000174() == null || this.getI000000174().equals("null")) {
				pstmt.setNull(185, 12);
			} else {
				pstmt.setString(185, this.getI000000174());
			}
			if(this.getI000000175() == null || this.getI000000175().equals("null")) {
				pstmt.setNull(186, 12);
			} else {
				pstmt.setString(186, this.getI000000175());
			}
			if(this.getI000000176() == null || this.getI000000176().equals("null")) {
				pstmt.setNull(187, 12);
			} else {
				pstmt.setString(187, this.getI000000176());
			}
			if(this.getI000000177() == null || this.getI000000177().equals("null")) {
				pstmt.setNull(188, 12);
			} else {
				pstmt.setString(188, this.getI000000177());
			}
			if(this.getI000000178() == null || this.getI000000178().equals("null")) {
				pstmt.setNull(189, 12);
			} else {
				pstmt.setString(189, this.getI000000178());
			}
			if(this.getI000000179() == null || this.getI000000179().equals("null")) {
				pstmt.setNull(190, 12);
			} else {
				pstmt.setString(190, this.getI000000179());
			}
			if(this.getI000000180() == null || this.getI000000180().equals("null")) {
				pstmt.setNull(191, 12);
			} else {
				pstmt.setString(191, this.getI000000180());
			}
			if(this.getI000000181() == null || this.getI000000181().equals("null")) {
				pstmt.setNull(192, 12);
			} else {
				pstmt.setString(192, this.getI000000181());
			}
			if(this.getI000000182() == null || this.getI000000182().equals("null")) {
				pstmt.setNull(193, 12);
			} else {
				pstmt.setString(193, this.getI000000182());
			}
			if(this.getI000000183() == null || this.getI000000183().equals("null")) {
				pstmt.setNull(194, 12);
			} else {
				pstmt.setString(194, this.getI000000183());
			}
			if(this.getI000000184() == null || this.getI000000184().equals("null")) {
				pstmt.setNull(195, 12);
			} else {
				pstmt.setString(195, this.getI000000184());
			}
			if(this.getI000000185() == null || this.getI000000185().equals("null")) {
				pstmt.setNull(196, 12);
			} else {
				pstmt.setString(196, this.getI000000185());
			}
			if(this.getI000000186() == null || this.getI000000186().equals("null")) {
				pstmt.setNull(197, 12);
			} else {
				pstmt.setString(197, this.getI000000186());
			}
			if(this.getI000000187() == null || this.getI000000187().equals("null")) {
				pstmt.setNull(198, 12);
			} else {
				pstmt.setString(198, this.getI000000187());
			}
			if(this.getI000000188() == null || this.getI000000188().equals("null")) {
				pstmt.setNull(199, 12);
			} else {
				pstmt.setString(199, this.getI000000188());
			}
			if(this.getI000000189() == null || this.getI000000189().equals("null")) {
				pstmt.setNull(200, 12);
			} else {
				pstmt.setString(200, this.getI000000189());
			}
			if(this.getI000000190() == null || this.getI000000190().equals("null")) {
				pstmt.setNull(201, 12);
			} else {
				pstmt.setString(201, this.getI000000190());
			}
			if(this.getI000000191() == null || this.getI000000191().equals("null")) {
				pstmt.setNull(202, 12);
			} else {
				pstmt.setString(202, this.getI000000191());
			}
			if(this.getI000000192() == null || this.getI000000192().equals("null")) {
				pstmt.setNull(203, 12);
			} else {
				pstmt.setString(203, this.getI000000192());
			}
			if(this.getI000000193() == null || this.getI000000193().equals("null")) {
				pstmt.setNull(204, 12);
			} else {
				pstmt.setString(204, this.getI000000193());
			}
			if(this.getI000000194() == null || this.getI000000194().equals("null")) {
				pstmt.setNull(205, 12);
			} else {
				pstmt.setString(205, this.getI000000194());
			}
			if(this.getI000000195() == null || this.getI000000195().equals("null")) {
				pstmt.setNull(206, 12);
			} else {
				pstmt.setString(206, this.getI000000195());
			}
			if(this.getI000000196() == null || this.getI000000196().equals("null")) {
				pstmt.setNull(207, 12);
			} else {
				pstmt.setString(207, this.getI000000196());
			}
			if(this.getI000000197() == null || this.getI000000197().equals("null")) {
				pstmt.setNull(208, 12);
			} else {
				pstmt.setString(208, this.getI000000197());
			}
			if(this.getI000000198() == null || this.getI000000198().equals("null")) {
				pstmt.setNull(209, 12);
			} else {
				pstmt.setString(209, this.getI000000198());
			}
			if(this.getI000000199() == null || this.getI000000199().equals("null")) {
				pstmt.setNull(210, 12);
			} else {
				pstmt.setString(210, this.getI000000199());
			}
			if(this.getI000000200() == null || this.getI000000200().equals("null")) {
				pstmt.setNull(211, 12);
			} else {
				pstmt.setString(211, this.getI000000200());
			}
			if(this.getR000000001() == null || this.getR000000001().equals("null")) {
				pstmt.setNull(212, 12);
			} else {
				pstmt.setString(212, this.getR000000001());
			}
			if(this.getR000000002() == null || this.getR000000002().equals("null")) {
				pstmt.setNull(213, 12);
			} else {
				pstmt.setString(213, this.getR000000002());
			}
			if(this.getR000000003() == null || this.getR000000003().equals("null")) {
				pstmt.setNull(214, 12);
			} else {
				pstmt.setString(214, this.getR000000003());
			}
			if(this.getR000000004() == null || this.getR000000004().equals("null")) {
				pstmt.setNull(215, 12);
			} else {
				pstmt.setString(215, this.getR000000004());
			}
			if(this.getR000000005() == null || this.getR000000005().equals("null")) {
				pstmt.setNull(216, 12);
			} else {
				pstmt.setString(216, this.getR000000005());
			}
			if(this.getR000000006() == null || this.getR000000006().equals("null")) {
				pstmt.setNull(217, 12);
			} else {
				pstmt.setString(217, this.getR000000006());
			}
			if(this.getR000000007() == null || this.getR000000007().equals("null")) {
				pstmt.setNull(218, 12);
			} else {
				pstmt.setString(218, this.getR000000007());
			}
			if(this.getR000000008() == null || this.getR000000008().equals("null")) {
				pstmt.setNull(219, 12);
			} else {
				pstmt.setString(219, this.getR000000008());
			}
			if(this.getR000000009() == null || this.getR000000009().equals("null")) {
				pstmt.setNull(220, 12);
			} else {
				pstmt.setString(220, this.getR000000009());
			}
			if(this.getR000000010() == null || this.getR000000010().equals("null")) {
				pstmt.setNull(221, 12);
			} else {
				pstmt.setString(221, this.getR000000010());
			}
			if(this.getR000000011() == null || this.getR000000011().equals("null")) {
				pstmt.setNull(222, 12);
			} else {
				pstmt.setString(222, this.getR000000011());
			}
			if(this.getR000000012() == null || this.getR000000012().equals("null")) {
				pstmt.setNull(223, 12);
			} else {
				pstmt.setString(223, this.getR000000012());
			}
			if(this.getR000000013() == null || this.getR000000013().equals("null")) {
				pstmt.setNull(224, 12);
			} else {
				pstmt.setString(224, this.getR000000013());
			}
			if(this.getR000000014() == null || this.getR000000014().equals("null")) {
				pstmt.setNull(225, 12);
			} else {
				pstmt.setString(225, this.getR000000014());
			}
			if(this.getR000000015() == null || this.getR000000015().equals("null")) {
				pstmt.setNull(226, 12);
			} else {
				pstmt.setString(226, this.getR000000015());
			}
			if(this.getR000000016() == null || this.getR000000016().equals("null")) {
				pstmt.setNull(227, 12);
			} else {
				pstmt.setString(227, this.getR000000016());
			}
			if(this.getR000000017() == null || this.getR000000017().equals("null")) {
				pstmt.setNull(228, 12);
			} else {
				pstmt.setString(228, this.getR000000017());
			}
			if(this.getR000000018() == null || this.getR000000018().equals("null")) {
				pstmt.setNull(229, 12);
			} else {
				pstmt.setString(229, this.getR000000018());
			}
			if(this.getR000000019() == null || this.getR000000019().equals("null")) {
				pstmt.setNull(230, 12);
			} else {
				pstmt.setString(230, this.getR000000019());
			}
			if(this.getR000000020() == null || this.getR000000020().equals("null")) {
				pstmt.setNull(231, 12);
			} else {
				pstmt.setString(231, this.getR000000020());
			}
			if(this.getR000000021() == null || this.getR000000021().equals("null")) {
				pstmt.setNull(232, 12);
			} else {
				pstmt.setString(232, this.getR000000021());
			}
			if(this.getR000000022() == null || this.getR000000022().equals("null")) {
				pstmt.setNull(233, 12);
			} else {
				pstmt.setString(233, this.getR000000022());
			}
			if(this.getR000000023() == null || this.getR000000023().equals("null")) {
				pstmt.setNull(234, 12);
			} else {
				pstmt.setString(234, this.getR000000023());
			}
			if(this.getR000000024() == null || this.getR000000024().equals("null")) {
				pstmt.setNull(235, 12);
			} else {
				pstmt.setString(235, this.getR000000024());
			}
			if(this.getR000000025() == null || this.getR000000025().equals("null")) {
				pstmt.setNull(236, 12);
			} else {
				pstmt.setString(236, this.getR000000025());
			}
			if(this.getR000000026() == null || this.getR000000026().equals("null")) {
				pstmt.setNull(237, 12);
			} else {
				pstmt.setString(237, this.getR000000026());
			}
			if(this.getR000000027() == null || this.getR000000027().equals("null")) {
				pstmt.setNull(238, 12);
			} else {
				pstmt.setString(238, this.getR000000027());
			}
			if(this.getR000000028() == null || this.getR000000028().equals("null")) {
				pstmt.setNull(239, 12);
			} else {
				pstmt.setString(239, this.getR000000028());
			}
			if(this.getR000000029() == null || this.getR000000029().equals("null")) {
				pstmt.setNull(240, 12);
			} else {
				pstmt.setString(240, this.getR000000029());
			}
			if(this.getR000000030() == null || this.getR000000030().equals("null")) {
				pstmt.setNull(241, 12);
			} else {
				pstmt.setString(241, this.getR000000030());
			}
			if(this.getR000000031() == null || this.getR000000031().equals("null")) {
				pstmt.setNull(242, 12);
			} else {
				pstmt.setString(242, this.getR000000031());
			}
			if(this.getR000000032() == null || this.getR000000032().equals("null")) {
				pstmt.setNull(243, 12);
			} else {
				pstmt.setString(243, this.getR000000032());
			}
			if(this.getR000000033() == null || this.getR000000033().equals("null")) {
				pstmt.setNull(244, 12);
			} else {
				pstmt.setString(244, this.getR000000033());
			}
			if(this.getR000000034() == null || this.getR000000034().equals("null")) {
				pstmt.setNull(245, 12);
			} else {
				pstmt.setString(245, this.getR000000034());
			}
			if(this.getR000000035() == null || this.getR000000035().equals("null")) {
				pstmt.setNull(246, 12);
			} else {
				pstmt.setString(246, this.getR000000035());
			}
			if(this.getR000000036() == null || this.getR000000036().equals("null")) {
				pstmt.setNull(247, 12);
			} else {
				pstmt.setString(247, this.getR000000036());
			}
			if(this.getR000000037() == null || this.getR000000037().equals("null")) {
				pstmt.setNull(248, 12);
			} else {
				pstmt.setString(248, this.getR000000037());
			}
			if(this.getR000000038() == null || this.getR000000038().equals("null")) {
				pstmt.setNull(249, 12);
			} else {
				pstmt.setString(249, this.getR000000038());
			}
			if(this.getR000000039() == null || this.getR000000039().equals("null")) {
				pstmt.setNull(250, 12);
			} else {
				pstmt.setString(250, this.getR000000039());
			}
			if(this.getR000000040() == null || this.getR000000040().equals("null")) {
				pstmt.setNull(251, 12);
			} else {
				pstmt.setString(251, this.getR000000040());
			}
			if(this.getR000000041() == null || this.getR000000041().equals("null")) {
				pstmt.setNull(252, 12);
			} else {
				pstmt.setString(252, this.getR000000041());
			}
			if(this.getR000000042() == null || this.getR000000042().equals("null")) {
				pstmt.setNull(253, 12);
			} else {
				pstmt.setString(253, this.getR000000042());
			}
			if(this.getR000000043() == null || this.getR000000043().equals("null")) {
				pstmt.setNull(254, 12);
			} else {
				pstmt.setString(254, this.getR000000043());
			}
			if(this.getR000000044() == null || this.getR000000044().equals("null")) {
				pstmt.setNull(255, 12);
			} else {
				pstmt.setString(255, this.getR000000044());
			}
			if(this.getR000000045() == null || this.getR000000045().equals("null")) {
				pstmt.setNull(256, 12);
			} else {
				pstmt.setString(256, this.getR000000045());
			}
			if(this.getR000000046() == null || this.getR000000046().equals("null")) {
				pstmt.setNull(257, 12);
			} else {
				pstmt.setString(257, this.getR000000046());
			}
			if(this.getR000000047() == null || this.getR000000047().equals("null")) {
				pstmt.setNull(258, 12);
			} else {
				pstmt.setString(258, this.getR000000047());
			}
			if(this.getR000000048() == null || this.getR000000048().equals("null")) {
				pstmt.setNull(259, 12);
			} else {
				pstmt.setString(259, this.getR000000048());
			}
			if(this.getR000000049() == null || this.getR000000049().equals("null")) {
				pstmt.setNull(260, 12);
			} else {
				pstmt.setString(260, this.getR000000049());
			}
			if(this.getR000000050() == null || this.getR000000050().equals("null")) {
				pstmt.setNull(261, 12);
			} else {
				pstmt.setString(261, this.getR000000050());
			}
			if(this.getR000000051() == null || this.getR000000051().equals("null")) {
				pstmt.setNull(262, 12);
			} else {
				pstmt.setString(262, this.getR000000051());
			}
			if(this.getR000000052() == null || this.getR000000052().equals("null")) {
				pstmt.setNull(263, 12);
			} else {
				pstmt.setString(263, this.getR000000052());
			}
			if(this.getR000000053() == null || this.getR000000053().equals("null")) {
				pstmt.setNull(264, 12);
			} else {
				pstmt.setString(264, this.getR000000053());
			}
			if(this.getR000000054() == null || this.getR000000054().equals("null")) {
				pstmt.setNull(265, 12);
			} else {
				pstmt.setString(265, this.getR000000054());
			}
			if(this.getR000000055() == null || this.getR000000055().equals("null")) {
				pstmt.setNull(266, 12);
			} else {
				pstmt.setString(266, this.getR000000055());
			}
			if(this.getR000000056() == null || this.getR000000056().equals("null")) {
				pstmt.setNull(267, 12);
			} else {
				pstmt.setString(267, this.getR000000056());
			}
			if(this.getR000000057() == null || this.getR000000057().equals("null")) {
				pstmt.setNull(268, 12);
			} else {
				pstmt.setString(268, this.getR000000057());
			}
			if(this.getR000000058() == null || this.getR000000058().equals("null")) {
				pstmt.setNull(269, 12);
			} else {
				pstmt.setString(269, this.getR000000058());
			}
			if(this.getR000000059() == null || this.getR000000059().equals("null")) {
				pstmt.setNull(270, 12);
			} else {
				pstmt.setString(270, this.getR000000059());
			}
			if(this.getR000000060() == null || this.getR000000060().equals("null")) {
				pstmt.setNull(271, 12);
			} else {
				pstmt.setString(271, this.getR000000060());
			}
			if(this.getR000000061() == null || this.getR000000061().equals("null")) {
				pstmt.setNull(272, 12);
			} else {
				pstmt.setString(272, this.getR000000061());
			}
			if(this.getR000000062() == null || this.getR000000062().equals("null")) {
				pstmt.setNull(273, 12);
			} else {
				pstmt.setString(273, this.getR000000062());
			}
			if(this.getR000000063() == null || this.getR000000063().equals("null")) {
				pstmt.setNull(274, 12);
			} else {
				pstmt.setString(274, this.getR000000063());
			}
			if(this.getR000000064() == null || this.getR000000064().equals("null")) {
				pstmt.setNull(275, 12);
			} else {
				pstmt.setString(275, this.getR000000064());
			}
			if(this.getR000000065() == null || this.getR000000065().equals("null")) {
				pstmt.setNull(276, 12);
			} else {
				pstmt.setString(276, this.getR000000065());
			}
			if(this.getR000000066() == null || this.getR000000066().equals("null")) {
				pstmt.setNull(277, 12);
			} else {
				pstmt.setString(277, this.getR000000066());
			}
			if(this.getR000000067() == null || this.getR000000067().equals("null")) {
				pstmt.setNull(278, 12);
			} else {
				pstmt.setString(278, this.getR000000067());
			}
			if(this.getR000000068() == null || this.getR000000068().equals("null")) {
				pstmt.setNull(279, 12);
			} else {
				pstmt.setString(279, this.getR000000068());
			}
			if(this.getR000000069() == null || this.getR000000069().equals("null")) {
				pstmt.setNull(280, 12);
			} else {
				pstmt.setString(280, this.getR000000069());
			}
			if(this.getR000000070() == null || this.getR000000070().equals("null")) {
				pstmt.setNull(281, 12);
			} else {
				pstmt.setString(281, this.getR000000070());
			}
			if(this.getR000000071() == null || this.getR000000071().equals("null")) {
				pstmt.setNull(282, 12);
			} else {
				pstmt.setString(282, this.getR000000071());
			}
			if(this.getR000000072() == null || this.getR000000072().equals("null")) {
				pstmt.setNull(283, 12);
			} else {
				pstmt.setString(283, this.getR000000072());
			}
			if(this.getR000000073() == null || this.getR000000073().equals("null")) {
				pstmt.setNull(284, 12);
			} else {
				pstmt.setString(284, this.getR000000073());
			}
			if(this.getR000000074() == null || this.getR000000074().equals("null")) {
				pstmt.setNull(285, 12);
			} else {
				pstmt.setString(285, this.getR000000074());
			}
			if(this.getR000000075() == null || this.getR000000075().equals("null")) {
				pstmt.setNull(286, 12);
			} else {
				pstmt.setString(286, this.getR000000075());
			}
			if(this.getR000000076() == null || this.getR000000076().equals("null")) {
				pstmt.setNull(287, 12);
			} else {
				pstmt.setString(287, this.getR000000076());
			}
			if(this.getR000000077() == null || this.getR000000077().equals("null")) {
				pstmt.setNull(288, 12);
			} else {
				pstmt.setString(288, this.getR000000077());
			}
			if(this.getR000000078() == null || this.getR000000078().equals("null")) {
				pstmt.setNull(289, 12);
			} else {
				pstmt.setString(289, this.getR000000078());
			}
			if(this.getR000000079() == null || this.getR000000079().equals("null")) {
				pstmt.setNull(290, 12);
			} else {
				pstmt.setString(290, this.getR000000079());
			}
			if(this.getR000000080() == null || this.getR000000080().equals("null")) {
				pstmt.setNull(291, 12);
			} else {
				pstmt.setString(291, this.getR000000080());
			}
			if(this.getR000000081() == null || this.getR000000081().equals("null")) {
				pstmt.setNull(292, 12);
			} else {
				pstmt.setString(292, this.getR000000081());
			}
			if(this.getR000000082() == null || this.getR000000082().equals("null")) {
				pstmt.setNull(293, 12);
			} else {
				pstmt.setString(293, this.getR000000082());
			}
			if(this.getR000000083() == null || this.getR000000083().equals("null")) {
				pstmt.setNull(294, 12);
			} else {
				pstmt.setString(294, this.getR000000083());
			}
			if(this.getR000000084() == null || this.getR000000084().equals("null")) {
				pstmt.setNull(295, 12);
			} else {
				pstmt.setString(295, this.getR000000084());
			}
			if(this.getR000000085() == null || this.getR000000085().equals("null")) {
				pstmt.setNull(296, 12);
			} else {
				pstmt.setString(296, this.getR000000085());
			}
			if(this.getR000000086() == null || this.getR000000086().equals("null")) {
				pstmt.setNull(297, 12);
			} else {
				pstmt.setString(297, this.getR000000086());
			}
			if(this.getR000000087() == null || this.getR000000087().equals("null")) {
				pstmt.setNull(298, 12);
			} else {
				pstmt.setString(298, this.getR000000087());
			}
			if(this.getR000000088() == null || this.getR000000088().equals("null")) {
				pstmt.setNull(299, 12);
			} else {
				pstmt.setString(299, this.getR000000088());
			}
			if(this.getR000000089() == null || this.getR000000089().equals("null")) {
				pstmt.setNull(300, 12);
			} else {
				pstmt.setString(300, this.getR000000089());
			}
			if(this.getR000000090() == null || this.getR000000090().equals("null")) {
				pstmt.setNull(301, 12);
			} else {
				pstmt.setString(301, this.getR000000090());
			}
			if(this.getR000000091() == null || this.getR000000091().equals("null")) {
				pstmt.setNull(302, 12);
			} else {
				pstmt.setString(302, this.getR000000091());
			}
			if(this.getR000000092() == null || this.getR000000092().equals("null")) {
				pstmt.setNull(303, 12);
			} else {
				pstmt.setString(303, this.getR000000092());
			}
			if(this.getR000000093() == null || this.getR000000093().equals("null")) {
				pstmt.setNull(304, 12);
			} else {
				pstmt.setString(304, this.getR000000093());
			}
			if(this.getR000000094() == null || this.getR000000094().equals("null")) {
				pstmt.setNull(305, 12);
			} else {
				pstmt.setString(305, this.getR000000094());
			}
			if(this.getR000000095() == null || this.getR000000095().equals("null")) {
				pstmt.setNull(306, 12);
			} else {
				pstmt.setString(306, this.getR000000095());
			}
			if(this.getR000000096() == null || this.getR000000096().equals("null")) {
				pstmt.setNull(307, 12);
			} else {
				pstmt.setString(307, this.getR000000096());
			}
			if(this.getR000000097() == null || this.getR000000097().equals("null")) {
				pstmt.setNull(308, 12);
			} else {
				pstmt.setString(308, this.getR000000097());
			}
			if(this.getR000000098() == null || this.getR000000098().equals("null")) {
				pstmt.setNull(309, 12);
			} else {
				pstmt.setString(309, this.getR000000098());
			}
			if(this.getR000000099() == null || this.getR000000099().equals("null")) {
				pstmt.setNull(310, 12);
			} else {
				pstmt.setString(310, this.getR000000099());
			}
			if(this.getR000000100() == null || this.getR000000100().equals("null")) {
				pstmt.setNull(311, 12);
			} else {
				pstmt.setString(311, this.getR000000100());
			}
			if(this.getR000000101() == null || this.getR000000101().equals("null")) {
				pstmt.setNull(312, 12);
			} else {
				pstmt.setString(312, this.getR000000101());
			}
			if(this.getR000000102() == null || this.getR000000102().equals("null")) {
				pstmt.setNull(313, 12);
			} else {
				pstmt.setString(313, this.getR000000102());
			}
			if(this.getR000000103() == null || this.getR000000103().equals("null")) {
				pstmt.setNull(314, 12);
			} else {
				pstmt.setString(314, this.getR000000103());
			}
			if(this.getR000000104() == null || this.getR000000104().equals("null")) {
				pstmt.setNull(315, 12);
			} else {
				pstmt.setString(315, this.getR000000104());
			}
			if(this.getR000000105() == null || this.getR000000105().equals("null")) {
				pstmt.setNull(316, 12);
			} else {
				pstmt.setString(316, this.getR000000105());
			}
			if(this.getR000000106() == null || this.getR000000106().equals("null")) {
				pstmt.setNull(317, 12);
			} else {
				pstmt.setString(317, this.getR000000106());
			}
			if(this.getR000000107() == null || this.getR000000107().equals("null")) {
				pstmt.setNull(318, 12);
			} else {
				pstmt.setString(318, this.getR000000107());
			}
			if(this.getR000000108() == null || this.getR000000108().equals("null")) {
				pstmt.setNull(319, 12);
			} else {
				pstmt.setString(319, this.getR000000108());
			}
			if(this.getR000000109() == null || this.getR000000109().equals("null")) {
				pstmt.setNull(320, 12);
			} else {
				pstmt.setString(320, this.getR000000109());
			}
			if(this.getR000000110() == null || this.getR000000110().equals("null")) {
				pstmt.setNull(321, 12);
			} else {
				pstmt.setString(321, this.getR000000110());
			}
			if(this.getR000000111() == null || this.getR000000111().equals("null")) {
				pstmt.setNull(322, 12);
			} else {
				pstmt.setString(322, this.getR000000111());
			}
			if(this.getR000000112() == null || this.getR000000112().equals("null")) {
				pstmt.setNull(323, 12);
			} else {
				pstmt.setString(323, this.getR000000112());
			}
			if(this.getR000000113() == null || this.getR000000113().equals("null")) {
				pstmt.setNull(324, 12);
			} else {
				pstmt.setString(324, this.getR000000113());
			}
			if(this.getR000000114() == null || this.getR000000114().equals("null")) {
				pstmt.setNull(325, 12);
			} else {
				pstmt.setString(325, this.getR000000114());
			}
			if(this.getR000000115() == null || this.getR000000115().equals("null")) {
				pstmt.setNull(326, 12);
			} else {
				pstmt.setString(326, this.getR000000115());
			}
			if(this.getR000000116() == null || this.getR000000116().equals("null")) {
				pstmt.setNull(327, 12);
			} else {
				pstmt.setString(327, this.getR000000116());
			}
			if(this.getR000000117() == null || this.getR000000117().equals("null")) {
				pstmt.setNull(328, 12);
			} else {
				pstmt.setString(328, this.getR000000117());
			}
			if(this.getR000000118() == null || this.getR000000118().equals("null")) {
				pstmt.setNull(329, 12);
			} else {
				pstmt.setString(329, this.getR000000118());
			}
			if(this.getR000000119() == null || this.getR000000119().equals("null")) {
				pstmt.setNull(330, 12);
			} else {
				pstmt.setString(330, this.getR000000119());
			}
			if(this.getR000000120() == null || this.getR000000120().equals("null")) {
				pstmt.setNull(331, 12);
			} else {
				pstmt.setString(331, this.getR000000120());
			}
			if(this.getR000000121() == null || this.getR000000121().equals("null")) {
				pstmt.setNull(332, 12);
			} else {
				pstmt.setString(332, this.getR000000121());
			}
			if(this.getR000000122() == null || this.getR000000122().equals("null")) {
				pstmt.setNull(333, 12);
			} else {
				pstmt.setString(333, this.getR000000122());
			}
			if(this.getR000000123() == null || this.getR000000123().equals("null")) {
				pstmt.setNull(334, 12);
			} else {
				pstmt.setString(334, this.getR000000123());
			}
			if(this.getR000000124() == null || this.getR000000124().equals("null")) {
				pstmt.setNull(335, 12);
			} else {
				pstmt.setString(335, this.getR000000124());
			}
			if(this.getR000000125() == null || this.getR000000125().equals("null")) {
				pstmt.setNull(336, 12);
			} else {
				pstmt.setString(336, this.getR000000125());
			}
			if(this.getR000000126() == null || this.getR000000126().equals("null")) {
				pstmt.setNull(337, 12);
			} else {
				pstmt.setString(337, this.getR000000126());
			}
			if(this.getR000000127() == null || this.getR000000127().equals("null")) {
				pstmt.setNull(338, 12);
			} else {
				pstmt.setString(338, this.getR000000127());
			}
			if(this.getR000000128() == null || this.getR000000128().equals("null")) {
				pstmt.setNull(339, 12);
			} else {
				pstmt.setString(339, this.getR000000128());
			}
			if(this.getR000000129() == null || this.getR000000129().equals("null")) {
				pstmt.setNull(340, 12);
			} else {
				pstmt.setString(340, this.getR000000129());
			}
			if(this.getR000000130() == null || this.getR000000130().equals("null")) {
				pstmt.setNull(341, 12);
			} else {
				pstmt.setString(341, this.getR000000130());
			}
			if(this.getR000000131() == null || this.getR000000131().equals("null")) {
				pstmt.setNull(342, 12);
			} else {
				pstmt.setString(342, this.getR000000131());
			}
			if(this.getR000000132() == null || this.getR000000132().equals("null")) {
				pstmt.setNull(343, 12);
			} else {
				pstmt.setString(343, this.getR000000132());
			}
			if(this.getR000000133() == null || this.getR000000133().equals("null")) {
				pstmt.setNull(344, 12);
			} else {
				pstmt.setString(344, this.getR000000133());
			}
			if(this.getR000000134() == null || this.getR000000134().equals("null")) {
				pstmt.setNull(345, 12);
			} else {
				pstmt.setString(345, this.getR000000134());
			}
			if(this.getR000000135() == null || this.getR000000135().equals("null")) {
				pstmt.setNull(346, 12);
			} else {
				pstmt.setString(346, this.getR000000135());
			}
			if(this.getR000000136() == null || this.getR000000136().equals("null")) {
				pstmt.setNull(347, 12);
			} else {
				pstmt.setString(347, this.getR000000136());
			}
			if(this.getR000000137() == null || this.getR000000137().equals("null")) {
				pstmt.setNull(348, 12);
			} else {
				pstmt.setString(348, this.getR000000137());
			}
			if(this.getR000000138() == null || this.getR000000138().equals("null")) {
				pstmt.setNull(349, 12);
			} else {
				pstmt.setString(349, this.getR000000138());
			}
			if(this.getR000000139() == null || this.getR000000139().equals("null")) {
				pstmt.setNull(350, 12);
			} else {
				pstmt.setString(350, this.getR000000139());
			}
			if(this.getR000000140() == null || this.getR000000140().equals("null")) {
				pstmt.setNull(351, 12);
			} else {
				pstmt.setString(351, this.getR000000140());
			}
			if(this.getR000000141() == null || this.getR000000141().equals("null")) {
				pstmt.setNull(352, 12);
			} else {
				pstmt.setString(352, this.getR000000141());
			}
			if(this.getR000000142() == null || this.getR000000142().equals("null")) {
				pstmt.setNull(353, 12);
			} else {
				pstmt.setString(353, this.getR000000142());
			}
			if(this.getR000000143() == null || this.getR000000143().equals("null")) {
				pstmt.setNull(354, 12);
			} else {
				pstmt.setString(354, this.getR000000143());
			}
			if(this.getR000000144() == null || this.getR000000144().equals("null")) {
				pstmt.setNull(355, 12);
			} else {
				pstmt.setString(355, this.getR000000144());
			}
			if(this.getR000000145() == null || this.getR000000145().equals("null")) {
				pstmt.setNull(356, 12);
			} else {
				pstmt.setString(356, this.getR000000145());
			}
			if(this.getR000000146() == null || this.getR000000146().equals("null")) {
				pstmt.setNull(357, 12);
			} else {
				pstmt.setString(357, this.getR000000146());
			}
			if(this.getR000000147() == null || this.getR000000147().equals("null")) {
				pstmt.setNull(358, 12);
			} else {
				pstmt.setString(358, this.getR000000147());
			}
			if(this.getR000000148() == null || this.getR000000148().equals("null")) {
				pstmt.setNull(359, 12);
			} else {
				pstmt.setString(359, this.getR000000148());
			}
			if(this.getR000000149() == null || this.getR000000149().equals("null")) {
				pstmt.setNull(360, 12);
			} else {
				pstmt.setString(360, this.getR000000149());
			}
			if(this.getR000000150() == null || this.getR000000150().equals("null")) {
				pstmt.setNull(361, 12);
			} else {
				pstmt.setString(361, this.getR000000150());
			}
			if(this.getR000000151() == null || this.getR000000151().equals("null")) {
				pstmt.setNull(362, 12);
			} else {
				pstmt.setString(362, this.getR000000151());
			}
			if(this.getR000000152() == null || this.getR000000152().equals("null")) {
				pstmt.setNull(363, 12);
			} else {
				pstmt.setString(363, this.getR000000152());
			}
			if(this.getR000000153() == null || this.getR000000153().equals("null")) {
				pstmt.setNull(364, 12);
			} else {
				pstmt.setString(364, this.getR000000153());
			}
			if(this.getR000000154() == null || this.getR000000154().equals("null")) {
				pstmt.setNull(365, 12);
			} else {
				pstmt.setString(365, this.getR000000154());
			}
			if(this.getR000000155() == null || this.getR000000155().equals("null")) {
				pstmt.setNull(366, 12);
			} else {
				pstmt.setString(366, this.getR000000155());
			}
			if(this.getR000000156() == null || this.getR000000156().equals("null")) {
				pstmt.setNull(367, 12);
			} else {
				pstmt.setString(367, this.getR000000156());
			}
			if(this.getR000000157() == null || this.getR000000157().equals("null")) {
				pstmt.setNull(368, 12);
			} else {
				pstmt.setString(368, this.getR000000157());
			}
			if(this.getR000000158() == null || this.getR000000158().equals("null")) {
				pstmt.setNull(369, 12);
			} else {
				pstmt.setString(369, this.getR000000158());
			}
			if(this.getR000000159() == null || this.getR000000159().equals("null")) {
				pstmt.setNull(370, 12);
			} else {
				pstmt.setString(370, this.getR000000159());
			}
			if(this.getR000000160() == null || this.getR000000160().equals("null")) {
				pstmt.setNull(371, 12);
			} else {
				pstmt.setString(371, this.getR000000160());
			}
			if(this.getR000000161() == null || this.getR000000161().equals("null")) {
				pstmt.setNull(372, 12);
			} else {
				pstmt.setString(372, this.getR000000161());
			}
			if(this.getR000000162() == null || this.getR000000162().equals("null")) {
				pstmt.setNull(373, 12);
			} else {
				pstmt.setString(373, this.getR000000162());
			}
			if(this.getR000000163() == null || this.getR000000163().equals("null")) {
				pstmt.setNull(374, 12);
			} else {
				pstmt.setString(374, this.getR000000163());
			}
			if(this.getR000000164() == null || this.getR000000164().equals("null")) {
				pstmt.setNull(375, 12);
			} else {
				pstmt.setString(375, this.getR000000164());
			}
			if(this.getR000000165() == null || this.getR000000165().equals("null")) {
				pstmt.setNull(376, 12);
			} else {
				pstmt.setString(376, this.getR000000165());
			}
			if(this.getR000000166() == null || this.getR000000166().equals("null")) {
				pstmt.setNull(377, 12);
			} else {
				pstmt.setString(377, this.getR000000166());
			}
			if(this.getR000000167() == null || this.getR000000167().equals("null")) {
				pstmt.setNull(378, 12);
			} else {
				pstmt.setString(378, this.getR000000167());
			}
			if(this.getR000000168() == null || this.getR000000168().equals("null")) {
				pstmt.setNull(379, 12);
			} else {
				pstmt.setString(379, this.getR000000168());
			}
			if(this.getR000000169() == null || this.getR000000169().equals("null")) {
				pstmt.setNull(380, 12);
			} else {
				pstmt.setString(380, this.getR000000169());
			}
			if(this.getR000000170() == null || this.getR000000170().equals("null")) {
				pstmt.setNull(381, 12);
			} else {
				pstmt.setString(381, this.getR000000170());
			}
			if(this.getR000000171() == null || this.getR000000171().equals("null")) {
				pstmt.setNull(382, 12);
			} else {
				pstmt.setString(382, this.getR000000171());
			}
			if(this.getR000000172() == null || this.getR000000172().equals("null")) {
				pstmt.setNull(383, 12);
			} else {
				pstmt.setString(383, this.getR000000172());
			}
			if(this.getR000000173() == null || this.getR000000173().equals("null")) {
				pstmt.setNull(384, 12);
			} else {
				pstmt.setString(384, this.getR000000173());
			}
			if(this.getR000000174() == null || this.getR000000174().equals("null")) {
				pstmt.setNull(385, 12);
			} else {
				pstmt.setString(385, this.getR000000174());
			}
			if(this.getR000000175() == null || this.getR000000175().equals("null")) {
				pstmt.setNull(386, 12);
			} else {
				pstmt.setString(386, this.getR000000175());
			}
			if(this.getR000000176() == null || this.getR000000176().equals("null")) {
				pstmt.setNull(387, 12);
			} else {
				pstmt.setString(387, this.getR000000176());
			}
			if(this.getR000000177() == null || this.getR000000177().equals("null")) {
				pstmt.setNull(388, 12);
			} else {
				pstmt.setString(388, this.getR000000177());
			}
			if(this.getR000000178() == null || this.getR000000178().equals("null")) {
				pstmt.setNull(389, 12);
			} else {
				pstmt.setString(389, this.getR000000178());
			}
			if(this.getR000000179() == null || this.getR000000179().equals("null")) {
				pstmt.setNull(390, 12);
			} else {
				pstmt.setString(390, this.getR000000179());
			}
			if(this.getR000000180() == null || this.getR000000180().equals("null")) {
				pstmt.setNull(391, 12);
			} else {
				pstmt.setString(391, this.getR000000180());
			}
			if(this.getR000000181() == null || this.getR000000181().equals("null")) {
				pstmt.setNull(392, 12);
			} else {
				pstmt.setString(392, this.getR000000181());
			}
			if(this.getR000000182() == null || this.getR000000182().equals("null")) {
				pstmt.setNull(393, 12);
			} else {
				pstmt.setString(393, this.getR000000182());
			}
			if(this.getR000000183() == null || this.getR000000183().equals("null")) {
				pstmt.setNull(394, 12);
			} else {
				pstmt.setString(394, this.getR000000183());
			}
			if(this.getR000000184() == null || this.getR000000184().equals("null")) {
				pstmt.setNull(395, 12);
			} else {
				pstmt.setString(395, this.getR000000184());
			}
			if(this.getR000000185() == null || this.getR000000185().equals("null")) {
				pstmt.setNull(396, 12);
			} else {
				pstmt.setString(396, this.getR000000185());
			}
			if(this.getR000000186() == null || this.getR000000186().equals("null")) {
				pstmt.setNull(397, 12);
			} else {
				pstmt.setString(397, this.getR000000186());
			}
			if(this.getR000000187() == null || this.getR000000187().equals("null")) {
				pstmt.setNull(398, 12);
			} else {
				pstmt.setString(398, this.getR000000187());
			}
			if(this.getR000000188() == null || this.getR000000188().equals("null")) {
				pstmt.setNull(399, 12);
			} else {
				pstmt.setString(399, this.getR000000188());
			}
			if(this.getR000000189() == null || this.getR000000189().equals("null")) {
				pstmt.setNull(400, 12);
			} else {
				pstmt.setString(400, this.getR000000189());
			}
			if(this.getR000000190() == null || this.getR000000190().equals("null")) {
				pstmt.setNull(401, 12);
			} else {
				pstmt.setString(401, this.getR000000190());
			}
			if(this.getR000000191() == null || this.getR000000191().equals("null")) {
				pstmt.setNull(402, 12);
			} else {
				pstmt.setString(402, this.getR000000191());
			}
			if(this.getR000000192() == null || this.getR000000192().equals("null")) {
				pstmt.setNull(403, 12);
			} else {
				pstmt.setString(403, this.getR000000192());
			}
			if(this.getR000000193() == null || this.getR000000193().equals("null")) {
				pstmt.setNull(404, 12);
			} else {
				pstmt.setString(404, this.getR000000193());
			}
			if(this.getR000000194() == null || this.getR000000194().equals("null")) {
				pstmt.setNull(405, 12);
			} else {
				pstmt.setString(405, this.getR000000194());
			}
			if(this.getR000000195() == null || this.getR000000195().equals("null")) {
				pstmt.setNull(406, 12);
			} else {
				pstmt.setString(406, this.getR000000195());
			}
			if(this.getR000000196() == null || this.getR000000196().equals("null")) {
				pstmt.setNull(407, 12);
			} else {
				pstmt.setString(407, this.getR000000196());
			}
			if(this.getR000000197() == null || this.getR000000197().equals("null")) {
				pstmt.setNull(408, 12);
			} else {
				pstmt.setString(408, this.getR000000197());
			}
			if(this.getR000000198() == null || this.getR000000198().equals("null")) {
				pstmt.setNull(409, 12);
			} else {
				pstmt.setString(409, this.getR000000198());
			}
			if(this.getR000000199() == null || this.getR000000199().equals("null")) {
				pstmt.setNull(410, 12);
			} else {
				pstmt.setString(410, this.getR000000199());
			}
			if(this.getR000000200() == null || this.getR000000200().equals("null")) {
				pstmt.setNull(411, 12);
			} else {
				pstmt.setString(411, this.getR000000200());
			}
			if(this.getI000000201() == null || this.getI000000201().equals("null")) {
				pstmt.setNull(412, 12);
			} else {
				pstmt.setString(412, this.getI000000201());
			}
			if(this.getI000000202() == null || this.getI000000202().equals("null")) {
				pstmt.setNull(413, 12);
			} else {
				pstmt.setString(413, this.getI000000202());
			}
			if(this.getI000000203() == null || this.getI000000203().equals("null")) {
				pstmt.setNull(414, 12);
			} else {
				pstmt.setString(414, this.getI000000203());
			}
			if(this.getI000000209() == null || this.getI000000209().equals("null")) {
				pstmt.setNull(415, 12);
			} else {
				pstmt.setString(415, this.getI000000209());
			}
			if(this.getI000000210() == null || this.getI000000210().equals("null")) {
				pstmt.setNull(416, 12);
			} else {
				pstmt.setString(416, this.getI000000210());
			}
			if(this.getI000000213() == null || this.getI000000213().equals("null")) {
				pstmt.setNull(417, 12);
			} else {
				pstmt.setString(417, this.getI000000213());
			}
			if(this.getI000000214() == null || this.getI000000214().equals("null")) {
				pstmt.setNull(418, 12);
			} else {
				pstmt.setString(418, this.getI000000214());
			}
			if(this.getI000000215() == null || this.getI000000215().equals("null")) {
				pstmt.setNull(419, 12);
			} else {
				pstmt.setString(419, this.getI000000215());
			}
			if(this.getI000000216() == null || this.getI000000216().equals("null")) {
				pstmt.setNull(420, 12);
			} else {
				pstmt.setString(420, this.getI000000216());
			}
			if(this.getI000000217() == null || this.getI000000217().equals("null")) {
				pstmt.setNull(421, 12);
			} else {
				pstmt.setString(421, this.getI000000217());
			}
			if(this.getI000000218() == null || this.getI000000218().equals("null")) {
				pstmt.setNull(422, 12);
			} else {
				pstmt.setString(422, this.getI000000218());
			}
			if(this.getI000000219() == null || this.getI000000219().equals("null")) {
				pstmt.setNull(423, 12);
			} else {
				pstmt.setString(423, this.getI000000219());
			}
			if(this.getI000000220() == null || this.getI000000220().equals("null")) {
				pstmt.setNull(424, 12);
			} else {
				pstmt.setString(424, this.getI000000220());
			}
			if(this.getI000000221() == null || this.getI000000221().equals("null")) {
				pstmt.setNull(425, 12);
			} else {
				pstmt.setString(425, this.getI000000221());
			}
			if(this.getI000000222() == null || this.getI000000222().equals("null")) {
				pstmt.setNull(426, 12);
			} else {
				pstmt.setString(426, this.getI000000222());
			}
			if(this.getI000000224() == null || this.getI000000224().equals("null")) {
				pstmt.setNull(427, 12);
			} else {
				pstmt.setString(427, this.getI000000224());
			}
			if(this.getI000000225() == null || this.getI000000225().equals("null")) {
				pstmt.setNull(428, 12);
			} else {
				pstmt.setString(428, this.getI000000225());
			}
			if(this.getI000000226() == null || this.getI000000226().equals("null")) {
				pstmt.setNull(429, 12);
			} else {
				pstmt.setString(429, this.getI000000226());
			}
			if(this.getI000000227() == null || this.getI000000227().equals("null")) {
				pstmt.setNull(430, 12);
			} else {
				pstmt.setString(430, this.getI000000227());
			}
			if(this.getI000000228() == null || this.getI000000228().equals("null")) {
				pstmt.setNull(431, 12);
			} else {
				pstmt.setString(431, this.getI000000228());
			}
			if(this.getI000000229() == null || this.getI000000229().equals("null")) {
				pstmt.setNull(432, 12);
			} else {
				pstmt.setString(432, this.getI000000229());
			}
			if(this.getI000000231() == null || this.getI000000231().equals("null")) {
				pstmt.setNull(433, 12);
			} else {
				pstmt.setString(433, this.getI000000231());
			}
			if(this.getI000000232() == null || this.getI000000232().equals("null")) {
				pstmt.setNull(434, 12);
			} else {
				pstmt.setString(434, this.getI000000232());
			}
			if(this.getI000000233() == null || this.getI000000233().equals("null")) {
				pstmt.setNull(435, 12);
			} else {
				pstmt.setString(435, this.getI000000233());
			}
			if(this.getI000000234() == null || this.getI000000234().equals("null")) {
				pstmt.setNull(436, 12);
			} else {
				pstmt.setString(436, this.getI000000234());
			}
			if(this.getI000000235() == null || this.getI000000235().equals("null")) {
				pstmt.setNull(437, 12);
			} else {
				pstmt.setString(437, this.getI000000235());
			}
			if(this.getI000000236() == null || this.getI000000236().equals("null")) {
				pstmt.setNull(438, 12);
			} else {
				pstmt.setString(438, this.getI000000236());
			}
			if(this.getI000000237() == null || this.getI000000237().equals("null")) {
				pstmt.setNull(439, 12);
			} else {
				pstmt.setString(439, this.getI000000237());
			}
			if(this.getI000000240() == null || this.getI000000240().equals("null")) {
				pstmt.setNull(440, 12);
			} else {
				pstmt.setString(440, this.getI000000240());
			}
			if(this.getI000000241() == null || this.getI000000241().equals("null")) {
				pstmt.setNull(441, 12);
			} else {
				pstmt.setString(441, this.getI000000241());
			}
			if(this.getI000000242() == null || this.getI000000242().equals("null")) {
				pstmt.setNull(442, 12);
			} else {
				pstmt.setString(442, this.getI000000242());
			}
			if(this.getI000000243() == null || this.getI000000243().equals("null")) {
				pstmt.setNull(443, 12);
			} else {
				pstmt.setString(443, this.getI000000243());
			}
			if(this.getI000000244() == null || this.getI000000244().equals("null")) {
				pstmt.setNull(444, 12);
			} else {
				pstmt.setString(444, this.getI000000244());
			}
			if(this.getI000000245() == null || this.getI000000245().equals("null")) {
				pstmt.setNull(445, 12);
			} else {
				pstmt.setString(445, this.getI000000245());
			}
			if(this.getI000000246() == null || this.getI000000246().equals("null")) {
				pstmt.setNull(446, 12);
			} else {
				pstmt.setString(446, this.getI000000246());
			}
			if(this.getI000000247() == null || this.getI000000247().equals("null")) {
				pstmt.setNull(447, 12);
			} else {
				pstmt.setString(447, this.getI000000247());
			}
			if(this.getI000000248() == null || this.getI000000248().equals("null")) {
				pstmt.setNull(448, 12);
			} else {
				pstmt.setString(448, this.getI000000248());
			}
			if(this.getI000000249() == null || this.getI000000249().equals("null")) {
				pstmt.setNull(449, 12);
			} else {
				pstmt.setString(449, this.getI000000249());
			}
			if(this.getI000000250() == null || this.getI000000250().equals("null")) {
				pstmt.setNull(450, 12);
			} else {
				pstmt.setString(450, this.getI000000250());
			}
			if(this.getI000000251() == null || this.getI000000251().equals("null")) {
				pstmt.setNull(451, 12);
			} else {
				pstmt.setString(451, this.getI000000251());
			}
			if(this.getR000000201() == null || this.getR000000201().equals("null")) {
				pstmt.setNull(452, 12);
			} else {
				pstmt.setString(452, this.getR000000201());
			}
			if(this.getR000000202() == null || this.getR000000202().equals("null")) {
				pstmt.setNull(453, 12);
			} else {
				pstmt.setString(453, this.getR000000202());
			}
			if(this.getR000000203() == null || this.getR000000203().equals("null")) {
				pstmt.setNull(454, 12);
			} else {
				pstmt.setString(454, this.getR000000203());
			}
			if(this.getR000000204() == null || this.getR000000204().equals("null")) {
				pstmt.setNull(455, 12);
			} else {
				pstmt.setString(455, this.getR000000204());
			}
			if(this.getR000000205() == null || this.getR000000205().equals("null")) {
				pstmt.setNull(456, 12);
			} else {
				pstmt.setString(456, this.getR000000205());
			}
			if(this.getI000000254() == null || this.getI000000254().equals("null")) {
				pstmt.setNull(457, 12);
			} else {
				pstmt.setString(457, this.getI000000254());
			}
			// execute sql
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) {
			// @@错误处理
			this.mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			try {
				pstmt.close();
			} catch (Exception e){}

			if( !mflag ) {
				try {
					con.close();
				} catch (Exception e){}
			}

			return false;
		}

		if( !mflag ) {
			try {
				con.close();
			} catch (Exception e){}
		}

		return true;
	}

	public boolean getInfo()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		if( !mflag ) {
			con = DBConnPool.getConnection();
		}

		try
		{
			pstmt = con.prepareStatement("SELECT * FROM LAIndexInfoVTemp WHERE  WageNo = ? AND IndexType = ? AND AgentCode = ?", 
				ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			if(this.getWageNo() == null || this.getWageNo().equals("null")) {
				pstmt.setNull(1, 12);
			} else {
				pstmt.setString(1, this.getWageNo());
			}
			if(this.getIndexType() == null || this.getIndexType().equals("null")) {
				pstmt.setNull(2, 12);
			} else {
				pstmt.setString(2, this.getIndexType());
			}
			if(this.getAgentCode() == null || this.getAgentCode().equals("null")) {
				pstmt.setNull(3, 12);
			} else {
				pstmt.setString(3, this.getAgentCode());
			}
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				if (!this.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAIndexInfoVTempDB";
					tError.functionName = "getInfo";
					tError.errorMessage = "取数失败!";
					this.mErrors .addOneError(tError);

					try{ rs.close(); } catch( Exception ex ) {}
					try{ pstmt.close(); } catch( Exception ex1 ) {}

					if (!mflag)
					{
						try
						{
							con.close();
						}
						catch(Exception et){}
					}
					return false;
				}
				break;
			}
			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if( i == 0 )
			{
				if (!mflag)
				{
					try
					{
						con.close();
					}
					catch(Exception et){}
				}
				return false;
			}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "getInfo";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
			return false;
	    }
	    // 断开数据库连接
		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return true;
	}

	public LAIndexInfoVTempSet query()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAIndexInfoVTempSet aLAIndexInfoVTempSet = new LAIndexInfoVTempSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			 List mBV = new ArrayList();
			 StringBuffer mSql = new StringBuffer(256);
			 StringBuffer WherePart = new StringBuffer(256);
			 LAIndexInfoVTempSchema aSchemaNew = this.getSchema();
			 int nFieldCount = aSchemaNew.getFieldCount();
			 int j = 0;
			 String strFieldName = "";
			 StringBuffer strFieldValue = null;
			 for (int i = 0; i < nFieldCount; i++) {
			 	if(i==0){
			 		WherePart.append("where");
			 	}
			 	strFieldName = aSchemaNew.getFieldName(i);
			 	strFieldValue = new StringBuffer(100);
			 	int nFieldType = aSchemaNew.getFieldType(i);
			 	boolean bFlag = false;
			 	String[] tParams = new String[2];
			 	switch (nFieldType) {
			 	case Schema.TYPE_STRING:
			 	case Schema.TYPE_DATE:
			 		if (aSchemaNew.getV(i).equals("null")) {
			 			//为空就不准备了
			 		} else {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_DOUBLE:
			 		if (!aSchemaNew.getV(i).equals("0.0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_FLOAT:
			 		if (!aSchemaNew.getV(i).equals("0.0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	case Schema.TYPE_INT:
			 		if (!aSchemaNew.getV(i).equals("0")) {
			 			strFieldValue.append("?");
			 			tParams[0] = String.valueOf(nFieldType);
			 			tParams[1] = aSchemaNew.getV(i);
			 			bFlag = true;
			 		}
			 		break;
			 	default:
			 		bFlag = false;
			 		break;
			 	}
			 	if (bFlag) {
			 		j++;
			 		if (j != 1) {
			 			WherePart.append(" and");
			 		}
			 		WherePart.append(" ");
			 		WherePart.append(strFieldName);
			 		WherePart.append("=");
			 		WherePart.append(strFieldValue);
			 		mBV.add(tParams);
			 	}
			 }
			 if (j == 0) {
			 	WherePart.setLength(0);
			 	throw new IllegalArgumentException("Table LAIndexInfoVTemp is querying for all data!");
			 }
			 mSql.append("select * from LAIndexInfoVTemp ");
			 mSql.append(WherePart);
			 String sql = mSql.toString();
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(pstmt, mBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LAIndexInfoVTempSchema s1 = new LAIndexInfoVTempSchema();
				s1.setSchema(rs,i);
				aLAIndexInfoVTempSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAIndexInfoVTempSet;
	}

	public LAIndexInfoVTempSet executeQuery(String sql, List bv)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAIndexInfoVTempSet aLAIndexInfoVTempSet = new LAIndexInfoVTempSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(stmt, bv);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;
				LAIndexInfoVTempSchema s1 = new LAIndexInfoVTempSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAIndexInfoVTempDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAIndexInfoVTempSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ stmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAIndexInfoVTempSet;
	}

	public LAIndexInfoVTempSet query(int nStart, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LAIndexInfoVTempSet aLAIndexInfoVTempSet = new LAIndexInfoVTempSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			SQLString sqlObj = new SQLString("LAIndexInfoVTemp");
			LAIndexInfoVTempSchema aSchema = this.getSchema();
			sqlObj.setSQLNew(5,aSchema);
			String sql = sqlObj.getSQL();

			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			List tBV = sqlObj.getBV();
			db.setBV(pstmt, tBV);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;

				if( i < nStart ) {
					continue;
				}

				if( i >= nStart + nCount ) {
					break;
				}

				LAIndexInfoVTempSchema s1 = new LAIndexInfoVTempSchema();
				s1.setSchema(rs,i);
				aLAIndexInfoVTempSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ pstmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ pstmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAIndexInfoVTempSet;
	}

	public LAIndexInfoVTempSet executeQuery(String sql, List bv, int nStart, int nCount)
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LAIndexInfoVTempSet aLAIndexInfoVTempSet = new LAIndexInfoVTempSet();

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.prepareStatement(StrTool.GBKToUnicode(sql),ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			db.setBV(stmt, bv);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				i++;

				if( i < nStart ) {
					continue;
				}

				if( i >= nStart + nCount ) {
					break;
				}

				LAIndexInfoVTempSchema s1 = new LAIndexInfoVTempSchema();
				if (!s1.setSchema(rs,i))
				{
					// @@错误处理
					CError tError = new CError();
					tError.moduleName = "LAIndexInfoVTempDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					this.mErrors .addOneError(tError);
				}
				aLAIndexInfoVTempSet.add(s1);
			}
			try{ rs.close(); } catch( Exception ex ) {}
			try{ stmt.close(); } catch( Exception ex1 ) {}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ rs.close(); } catch( Exception ex2 ) {}
			try{ stmt.close(); } catch( Exception ex3 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
	    }

		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return aLAIndexInfoVTempSet;
	}

	public boolean update(String strWherePart)
	{
		Statement stmt = null;

	  if( !mflag ) {
		  con = DBConnPool.getConnection();
		}

		try
		{
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			SQLString sqlObj = new SQLString("LAIndexInfoVTemp");
			LAIndexInfoVTempSchema aSchema = this.getSchema();
			sqlObj.setSQL(2,aSchema);
			String sql = "update LAIndexInfoVTemp " + sqlObj.getUpdPart() + " where " + strWherePart;

			int operCount = stmt.executeUpdate(sql);
			if( operCount == 0 )
			{
				// @@错误处理
				CError tError = new CError();
				tError.moduleName = "LAIndexInfoVTempDB";
				tError.functionName = "update";
				tError.errorMessage = "更新数据失败!";
				this.mErrors .addOneError(tError);

				if (!mflag)
				{
					try
					{
						con.close();
					}
					catch(Exception et){}
				}
				return false;
			}
		}
		catch(Exception e)
	    {
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVTempDB";
			tError.functionName = "update";
			tError.errorMessage = e.toString();
			this.mErrors .addOneError(tError);

			try{ stmt.close(); } catch( Exception ex1 ) {}

			if (!mflag)
			{
				try
				{
					con.close();
				}
				catch(Exception et){}
			}
			return false;
	    }
	    // 断开数据库连接
		if (!mflag)
		{
			try
			{
				con.close();
			}
			catch(Exception e){}
		}

		return true;
	}

/**
 * 准备数据查询条件
 * @param strSQL String
 * @return boolean
 */
public boolean prepareData(String strSQL)
{
    if (mResultSet != null)
    {
        // @@错误处理
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "prepareData";
        tError.errorMessage = "数据集非空，程序在准备数据集之后，没有关闭！";
        this.mErrors.addOneError(tError);
        return false;
    }

    if (!mflag)
    {
        con = DBConnPool.getConnection();
    }
    try
    {
        mStatement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
    }
    catch (Exception e)
    {
        // @@错误处理
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "prepareData";
        tError.errorMessage = e.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return false;
    }

    if (!mflag)
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {}
    }
    return true;
}

/**
 * 获取数据集
 * @return boolean
 */
public boolean hasMoreData()
{
    boolean flag = true;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "hasMoreData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return false;
    }
    try
    {
        flag = mResultSet.next();
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "hasMoreData";
        tError.errorMessage = ex.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
            mResultSet = null;
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
            mStatement = null;
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return false;
    }
    return flag;
}
/**
 * 获取定量数据
 * @return LAIndexInfoVTempSet
 */
public LAIndexInfoVTempSet getData()
{
    int tCount = 0;
    LAIndexInfoVTempSet tLAIndexInfoVTempSet = new LAIndexInfoVTempSet();
    LAIndexInfoVTempSchema tLAIndexInfoVTempSchema = null;
    if (null == mResultSet)
    {
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "getData";
        tError.errorMessage = "数据集为空，请先准备数据集！";
        this.mErrors.addOneError(tError);
        return null;
    }
    try
    {
        tCount = 1;
        tLAIndexInfoVTempSchema = new LAIndexInfoVTempSchema();
        tLAIndexInfoVTempSchema.setSchema(mResultSet, 1);
        tLAIndexInfoVTempSet.add(tLAIndexInfoVTempSchema);
        //注意mResultSet.next()的作用
        while (tCount++ < SysConst.FETCHCOUNT)
        {
            if (mResultSet.next())
            {
                tLAIndexInfoVTempSchema = new LAIndexInfoVTempSchema();
                tLAIndexInfoVTempSchema.setSchema(mResultSet, 1);
                tLAIndexInfoVTempSet.add(tLAIndexInfoVTempSchema);
            }
        }
    }
    catch (Exception ex)
    {
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "getData";
        tError.errorMessage = ex.toString();
        this.mErrors.addOneError(tError);
        try
        {
            mResultSet.close();
            mResultSet = null;
        }
        catch (Exception ex2)
        {}
        try
        {
            mStatement.close();
            mStatement = null;
        }
        catch (Exception ex3)
        {}
        if (!mflag)
        {
            try
            {
                con.close();
            }
            catch (Exception et)
            {}
        }
        return null;
    }
    return tLAIndexInfoVTempSet;
}
/**
 * 关闭数据集
 * @return boolean
 */
public boolean closeData()
{
    boolean flag = true;
    try
    {
        if (null == mResultSet)
        {
            CError tError = new CError();
            tError.moduleName = "LAIndexInfoVTempDB";
            tError.functionName = "closeData";
            tError.errorMessage = "数据集已经关闭了！";
            this.mErrors.addOneError(tError);
            flag = false;
        }
        else
        {
            mResultSet.close();
            mResultSet = null;
        }
    }
    catch (Exception ex2)
    {
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex2.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    try
    {
        if (null == mStatement)
        {
            CError tError = new CError();
            tError.moduleName = "LAIndexInfoVTempDB";
            tError.functionName = "closeData";
            tError.errorMessage = "语句已经关闭了！";
            this.mErrors.addOneError(tError);
            flag = false;
        }
        else
        {
            mStatement.close();
            mStatement = null;
        }
    }
    catch (Exception ex3)
    {
        CError tError = new CError();
        tError.moduleName = "LAIndexInfoVTempDB";
        tError.functionName = "closeData";
        tError.errorMessage = ex3.toString();
        this.mErrors.addOneError(tError);
        flag = false;
    }
    return flag;
}
}
