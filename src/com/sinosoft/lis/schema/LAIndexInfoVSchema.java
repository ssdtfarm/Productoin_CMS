/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.schema;

import org.apache.log4j.Logger;
import java.sql.*;
import java.io.*;
import java.util.Date;
import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.utility.*;
import com.sinosoft.lis.db.LAIndexInfoVDB;

/*
 * <p>ClassName: LAIndexInfoVSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: PhysicalDataModel_1
 */
public class LAIndexInfoVSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LAIndexInfoVSchema.class);
	// @Field
	/** Wageno */
	private String WageNo;
	/** Branchtype */
	private String BranchType;
	/** Indextype */
	private String IndexType;
	/** Agentcode */
	private String AgentCode;
	/** Agentgrade */
	private String AgentGrade;
	/** Agentgroup */
	private String AgentGroup;
	/** State */
	private String State;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;
	/** I000000001 */
	private String I000000001;
	/** I000000002 */
	private String I000000002;
	/** I000000003 */
	private String I000000003;
	/** I000000004 */
	private String I000000004;
	/** I000000005 */
	private String I000000005;
	/** I000000006 */
	private String I000000006;
	/** I000000007 */
	private String I000000007;
	/** I000000008 */
	private String I000000008;
	/** I000000009 */
	private String I000000009;
	/** I000000010 */
	private String I000000010;
	/** I000000011 */
	private String I000000011;
	/** I000000012 */
	private String I000000012;
	/** I000000013 */
	private String I000000013;
	/** I000000014 */
	private String I000000014;
	/** I000000015 */
	private String I000000015;
	/** I000000016 */
	private String I000000016;
	/** I000000017 */
	private String I000000017;
	/** I000000018 */
	private String I000000018;
	/** I000000019 */
	private String I000000019;
	/** I000000020 */
	private String I000000020;
	/** I000000021 */
	private String I000000021;
	/** I000000022 */
	private String I000000022;
	/** I000000023 */
	private String I000000023;
	/** I000000024 */
	private String I000000024;
	/** I000000025 */
	private String I000000025;
	/** I000000026 */
	private String I000000026;
	/** I000000027 */
	private String I000000027;
	/** I000000028 */
	private String I000000028;
	/** I000000029 */
	private String I000000029;
	/** I000000030 */
	private String I000000030;
	/** I000000031 */
	private String I000000031;
	/** I000000032 */
	private String I000000032;
	/** I000000033 */
	private String I000000033;
	/** I000000034 */
	private String I000000034;
	/** I000000035 */
	private String I000000035;
	/** I000000036 */
	private String I000000036;
	/** I000000037 */
	private String I000000037;
	/** I000000038 */
	private String I000000038;
	/** I000000039 */
	private String I000000039;
	/** I000000040 */
	private String I000000040;
	/** I000000041 */
	private String I000000041;
	/** I000000042 */
	private String I000000042;
	/** I000000043 */
	private String I000000043;
	/** I000000044 */
	private String I000000044;
	/** I000000045 */
	private String I000000045;
	/** I000000046 */
	private String I000000046;
	/** I000000047 */
	private String I000000047;
	/** I000000048 */
	private String I000000048;
	/** I000000049 */
	private String I000000049;
	/** I000000050 */
	private String I000000050;
	/** I000000051 */
	private String I000000051;
	/** I000000052 */
	private String I000000052;
	/** I000000053 */
	private String I000000053;
	/** I000000054 */
	private String I000000054;
	/** I000000055 */
	private String I000000055;
	/** I000000056 */
	private String I000000056;
	/** I000000057 */
	private String I000000057;
	/** I000000058 */
	private String I000000058;
	/** I000000059 */
	private String I000000059;
	/** I000000060 */
	private String I000000060;
	/** I000000061 */
	private String I000000061;
	/** I000000062 */
	private String I000000062;
	/** I000000063 */
	private String I000000063;
	/** I000000064 */
	private String I000000064;
	/** I000000065 */
	private String I000000065;
	/** I000000066 */
	private String I000000066;
	/** I000000067 */
	private String I000000067;
	/** I000000068 */
	private String I000000068;
	/** I000000069 */
	private String I000000069;
	/** I000000070 */
	private String I000000070;
	/** I000000071 */
	private String I000000071;
	/** I000000072 */
	private String I000000072;
	/** I000000073 */
	private String I000000073;
	/** I000000074 */
	private String I000000074;
	/** I000000075 */
	private String I000000075;
	/** I000000076 */
	private String I000000076;
	/** I000000077 */
	private String I000000077;
	/** I000000078 */
	private String I000000078;
	/** I000000079 */
	private String I000000079;
	/** I000000080 */
	private String I000000080;
	/** I000000081 */
	private String I000000081;
	/** I000000082 */
	private String I000000082;
	/** I000000083 */
	private String I000000083;
	/** I000000084 */
	private String I000000084;
	/** I000000085 */
	private String I000000085;
	/** I000000086 */
	private String I000000086;
	/** I000000087 */
	private String I000000087;
	/** I000000088 */
	private String I000000088;
	/** I000000089 */
	private String I000000089;
	/** I000000090 */
	private String I000000090;
	/** I000000091 */
	private String I000000091;
	/** I000000092 */
	private String I000000092;
	/** I000000093 */
	private String I000000093;
	/** I000000094 */
	private String I000000094;
	/** I000000095 */
	private String I000000095;
	/** I000000096 */
	private String I000000096;
	/** I000000097 */
	private String I000000097;
	/** I000000098 */
	private String I000000098;
	/** I000000099 */
	private String I000000099;
	/** I000000100 */
	private String I000000100;
	/** I000000101 */
	private String I000000101;
	/** I000000102 */
	private String I000000102;
	/** I000000103 */
	private String I000000103;
	/** I000000104 */
	private String I000000104;
	/** I000000105 */
	private String I000000105;
	/** I000000106 */
	private String I000000106;
	/** I000000107 */
	private String I000000107;
	/** I000000108 */
	private String I000000108;
	/** I000000109 */
	private String I000000109;
	/** I000000110 */
	private String I000000110;
	/** I000000111 */
	private String I000000111;
	/** I000000112 */
	private String I000000112;
	/** I000000113 */
	private String I000000113;
	/** I000000114 */
	private String I000000114;
	/** I000000115 */
	private String I000000115;
	/** I000000116 */
	private String I000000116;
	/** I000000117 */
	private String I000000117;
	/** I000000118 */
	private String I000000118;
	/** I000000119 */
	private String I000000119;
	/** I000000120 */
	private String I000000120;
	/** I000000121 */
	private String I000000121;
	/** I000000122 */
	private String I000000122;
	/** I000000123 */
	private String I000000123;
	/** I000000124 */
	private String I000000124;
	/** I000000125 */
	private String I000000125;
	/** I000000126 */
	private String I000000126;
	/** I000000127 */
	private String I000000127;
	/** I000000128 */
	private String I000000128;
	/** I000000129 */
	private String I000000129;
	/** I000000130 */
	private String I000000130;
	/** I000000131 */
	private String I000000131;
	/** I000000132 */
	private String I000000132;
	/** I000000133 */
	private String I000000133;
	/** I000000134 */
	private String I000000134;
	/** I000000135 */
	private String I000000135;
	/** I000000136 */
	private String I000000136;
	/** I000000137 */
	private String I000000137;
	/** I000000138 */
	private String I000000138;
	/** I000000139 */
	private String I000000139;
	/** I000000140 */
	private String I000000140;
	/** I000000141 */
	private String I000000141;
	/** I000000142 */
	private String I000000142;
	/** I000000143 */
	private String I000000143;
	/** I000000144 */
	private String I000000144;
	/** I000000145 */
	private String I000000145;
	/** I000000146 */
	private String I000000146;
	/** I000000147 */
	private String I000000147;
	/** I000000148 */
	private String I000000148;
	/** I000000149 */
	private String I000000149;
	/** I000000150 */
	private String I000000150;
	/** I000000151 */
	private String I000000151;
	/** I000000152 */
	private String I000000152;
	/** I000000153 */
	private String I000000153;
	/** I000000154 */
	private String I000000154;
	/** I000000155 */
	private String I000000155;
	/** I000000156 */
	private String I000000156;
	/** I000000157 */
	private String I000000157;
	/** I000000158 */
	private String I000000158;
	/** I000000159 */
	private String I000000159;
	/** I000000160 */
	private String I000000160;
	/** I000000161 */
	private String I000000161;
	/** I000000162 */
	private String I000000162;
	/** I000000163 */
	private String I000000163;
	/** I000000164 */
	private String I000000164;
	/** I000000165 */
	private String I000000165;
	/** I000000166 */
	private String I000000166;
	/** I000000167 */
	private String I000000167;
	/** I000000168 */
	private String I000000168;
	/** I000000169 */
	private String I000000169;
	/** I000000170 */
	private String I000000170;
	/** I000000171 */
	private String I000000171;
	/** I000000172 */
	private String I000000172;
	/** I000000173 */
	private String I000000173;
	/** I000000174 */
	private String I000000174;
	/** I000000175 */
	private String I000000175;
	/** I000000176 */
	private String I000000176;
	/** I000000177 */
	private String I000000177;
	/** I000000178 */
	private String I000000178;
	/** I000000179 */
	private String I000000179;
	/** I000000180 */
	private String I000000180;
	/** I000000181 */
	private String I000000181;
	/** I000000182 */
	private String I000000182;
	/** I000000183 */
	private String I000000183;
	/** I000000184 */
	private String I000000184;
	/** I000000185 */
	private String I000000185;
	/** I000000186 */
	private String I000000186;
	/** I000000187 */
	private String I000000187;
	/** I000000188 */
	private String I000000188;
	/** I000000189 */
	private String I000000189;
	/** I000000190 */
	private String I000000190;
	/** I000000191 */
	private String I000000191;
	/** I000000192 */
	private String I000000192;
	/** I000000193 */
	private String I000000193;
	/** I000000194 */
	private String I000000194;
	/** I000000195 */
	private String I000000195;
	/** I000000196 */
	private String I000000196;
	/** I000000197 */
	private String I000000197;
	/** I000000198 */
	private String I000000198;
	/** I000000199 */
	private String I000000199;
	/** I000000200 */
	private String I000000200;
	/** R000000001 */
	private String R000000001;
	/** R000000002 */
	private String R000000002;
	/** R000000003 */
	private String R000000003;
	/** R000000004 */
	private String R000000004;
	/** R000000005 */
	private String R000000005;
	/** R000000006 */
	private String R000000006;
	/** R000000007 */
	private String R000000007;
	/** R000000008 */
	private String R000000008;
	/** R000000009 */
	private String R000000009;
	/** R000000010 */
	private String R000000010;
	/** R000000011 */
	private String R000000011;
	/** R000000012 */
	private String R000000012;
	/** R000000013 */
	private String R000000013;
	/** R000000014 */
	private String R000000014;
	/** R000000015 */
	private String R000000015;
	/** R000000016 */
	private String R000000016;
	/** R000000017 */
	private String R000000017;
	/** R000000018 */
	private String R000000018;
	/** R000000019 */
	private String R000000019;
	/** R000000020 */
	private String R000000020;
	/** R000000021 */
	private String R000000021;
	/** R000000022 */
	private String R000000022;
	/** R000000023 */
	private String R000000023;
	/** R000000024 */
	private String R000000024;
	/** R000000025 */
	private String R000000025;
	/** R000000026 */
	private String R000000026;
	/** R000000027 */
	private String R000000027;
	/** R000000028 */
	private String R000000028;
	/** R000000029 */
	private String R000000029;
	/** R000000030 */
	private String R000000030;
	/** R000000031 */
	private String R000000031;
	/** R000000032 */
	private String R000000032;
	/** R000000033 */
	private String R000000033;
	/** R000000034 */
	private String R000000034;
	/** R000000035 */
	private String R000000035;
	/** R000000036 */
	private String R000000036;
	/** R000000037 */
	private String R000000037;
	/** R000000038 */
	private String R000000038;
	/** R000000039 */
	private String R000000039;
	/** R000000040 */
	private String R000000040;
	/** R000000041 */
	private String R000000041;
	/** R000000042 */
	private String R000000042;
	/** R000000043 */
	private String R000000043;
	/** R000000044 */
	private String R000000044;
	/** R000000045 */
	private String R000000045;
	/** R000000046 */
	private String R000000046;
	/** R000000047 */
	private String R000000047;
	/** R000000048 */
	private String R000000048;
	/** R000000049 */
	private String R000000049;
	/** R000000050 */
	private String R000000050;
	/** R000000051 */
	private String R000000051;
	/** R000000052 */
	private String R000000052;
	/** R000000053 */
	private String R000000053;
	/** R000000054 */
	private String R000000054;
	/** R000000055 */
	private String R000000055;
	/** R000000056 */
	private String R000000056;
	/** R000000057 */
	private String R000000057;
	/** R000000058 */
	private String R000000058;
	/** R000000059 */
	private String R000000059;
	/** R000000060 */
	private String R000000060;
	/** R000000061 */
	private String R000000061;
	/** R000000062 */
	private String R000000062;
	/** R000000063 */
	private String R000000063;
	/** R000000064 */
	private String R000000064;
	/** R000000065 */
	private String R000000065;
	/** R000000066 */
	private String R000000066;
	/** R000000067 */
	private String R000000067;
	/** R000000068 */
	private String R000000068;
	/** R000000069 */
	private String R000000069;
	/** R000000070 */
	private String R000000070;
	/** R000000071 */
	private String R000000071;
	/** R000000072 */
	private String R000000072;
	/** R000000073 */
	private String R000000073;
	/** R000000074 */
	private String R000000074;
	/** R000000075 */
	private String R000000075;
	/** R000000076 */
	private String R000000076;
	/** R000000077 */
	private String R000000077;
	/** R000000078 */
	private String R000000078;
	/** R000000079 */
	private String R000000079;
	/** R000000080 */
	private String R000000080;
	/** R000000081 */
	private String R000000081;
	/** R000000082 */
	private String R000000082;
	/** R000000083 */
	private String R000000083;
	/** R000000084 */
	private String R000000084;
	/** R000000085 */
	private String R000000085;
	/** R000000086 */
	private String R000000086;
	/** R000000087 */
	private String R000000087;
	/** R000000088 */
	private String R000000088;
	/** R000000089 */
	private String R000000089;
	/** R000000090 */
	private String R000000090;
	/** R000000091 */
	private String R000000091;
	/** R000000092 */
	private String R000000092;
	/** R000000093 */
	private String R000000093;
	/** R000000094 */
	private String R000000094;
	/** R000000095 */
	private String R000000095;
	/** R000000096 */
	private String R000000096;
	/** R000000097 */
	private String R000000097;
	/** R000000098 */
	private String R000000098;
	/** R000000099 */
	private String R000000099;
	/** R000000100 */
	private String R000000100;
	/** R000000101 */
	private String R000000101;
	/** R000000102 */
	private String R000000102;
	/** R000000103 */
	private String R000000103;
	/** R000000104 */
	private String R000000104;
	/** R000000105 */
	private String R000000105;
	/** R000000106 */
	private String R000000106;
	/** R000000107 */
	private String R000000107;
	/** R000000108 */
	private String R000000108;
	/** R000000109 */
	private String R000000109;
	/** R000000110 */
	private String R000000110;
	/** R000000111 */
	private String R000000111;
	/** R000000112 */
	private String R000000112;
	/** R000000113 */
	private String R000000113;
	/** R000000114 */
	private String R000000114;
	/** R000000115 */
	private String R000000115;
	/** R000000116 */
	private String R000000116;
	/** R000000117 */
	private String R000000117;
	/** R000000118 */
	private String R000000118;
	/** R000000119 */
	private String R000000119;
	/** R000000120 */
	private String R000000120;
	/** R000000121 */
	private String R000000121;
	/** R000000122 */
	private String R000000122;
	/** R000000123 */
	private String R000000123;
	/** R000000124 */
	private String R000000124;
	/** R000000125 */
	private String R000000125;
	/** R000000126 */
	private String R000000126;
	/** R000000127 */
	private String R000000127;
	/** R000000128 */
	private String R000000128;
	/** R000000129 */
	private String R000000129;
	/** R000000130 */
	private String R000000130;
	/** R000000131 */
	private String R000000131;
	/** R000000132 */
	private String R000000132;
	/** R000000133 */
	private String R000000133;
	/** R000000134 */
	private String R000000134;
	/** R000000135 */
	private String R000000135;
	/** R000000136 */
	private String R000000136;
	/** R000000137 */
	private String R000000137;
	/** R000000138 */
	private String R000000138;
	/** R000000139 */
	private String R000000139;
	/** R000000140 */
	private String R000000140;
	/** R000000141 */
	private String R000000141;
	/** R000000142 */
	private String R000000142;
	/** R000000143 */
	private String R000000143;
	/** R000000144 */
	private String R000000144;
	/** R000000145 */
	private String R000000145;
	/** R000000146 */
	private String R000000146;
	/** R000000147 */
	private String R000000147;
	/** R000000148 */
	private String R000000148;
	/** R000000149 */
	private String R000000149;
	/** R000000150 */
	private String R000000150;
	/** R000000151 */
	private String R000000151;
	/** R000000152 */
	private String R000000152;
	/** R000000153 */
	private String R000000153;
	/** R000000154 */
	private String R000000154;
	/** R000000155 */
	private String R000000155;
	/** R000000156 */
	private String R000000156;
	/** R000000157 */
	private String R000000157;
	/** R000000158 */
	private String R000000158;
	/** R000000159 */
	private String R000000159;
	/** R000000160 */
	private String R000000160;
	/** R000000161 */
	private String R000000161;
	/** R000000162 */
	private String R000000162;
	/** R000000163 */
	private String R000000163;
	/** R000000164 */
	private String R000000164;
	/** R000000165 */
	private String R000000165;
	/** R000000166 */
	private String R000000166;
	/** R000000167 */
	private String R000000167;
	/** R000000168 */
	private String R000000168;
	/** R000000169 */
	private String R000000169;
	/** R000000170 */
	private String R000000170;
	/** R000000171 */
	private String R000000171;
	/** R000000172 */
	private String R000000172;
	/** R000000173 */
	private String R000000173;
	/** R000000174 */
	private String R000000174;
	/** R000000175 */
	private String R000000175;
	/** R000000176 */
	private String R000000176;
	/** R000000177 */
	private String R000000177;
	/** R000000178 */
	private String R000000178;
	/** R000000179 */
	private String R000000179;
	/** R000000180 */
	private String R000000180;
	/** R000000181 */
	private String R000000181;
	/** R000000182 */
	private String R000000182;
	/** R000000183 */
	private String R000000183;
	/** R000000184 */
	private String R000000184;
	/** R000000185 */
	private String R000000185;
	/** R000000186 */
	private String R000000186;
	/** R000000187 */
	private String R000000187;
	/** R000000188 */
	private String R000000188;
	/** R000000189 */
	private String R000000189;
	/** R000000190 */
	private String R000000190;
	/** R000000191 */
	private String R000000191;
	/** R000000192 */
	private String R000000192;
	/** R000000193 */
	private String R000000193;
	/** R000000194 */
	private String R000000194;
	/** R000000195 */
	private String R000000195;
	/** R000000196 */
	private String R000000196;
	/** R000000197 */
	private String R000000197;
	/** R000000198 */
	private String R000000198;
	/** R000000199 */
	private String R000000199;
	/** R000000200 */
	private String R000000200;
	/** I000000201 */
	private String I000000201;
	/** I000000202 */
	private String I000000202;
	/** I000000203 */
	private String I000000203;
	/** I000000209 */
	private String I000000209;
	/** I000000210 */
	private String I000000210;
	/** I000000213 */
	private String I000000213;
	/** I000000214 */
	private String I000000214;
	/** I000000215 */
	private String I000000215;
	/** I000000216 */
	private String I000000216;
	/** I000000217 */
	private String I000000217;
	/** I000000218 */
	private String I000000218;
	/** I000000219 */
	private String I000000219;
	/** I000000220 */
	private String I000000220;
	/** I000000221 */
	private String I000000221;
	/** I000000222 */
	private String I000000222;
	/** I000000224 */
	private String I000000224;
	/** I000000225 */
	private String I000000225;
	/** I000000226 */
	private String I000000226;
	/** I000000227 */
	private String I000000227;
	/** I000000228 */
	private String I000000228;
	/** I000000229 */
	private String I000000229;
	/** I000000231 */
	private String I000000231;
	/** I000000232 */
	private String I000000232;
	/** I000000233 */
	private String I000000233;
	/** I000000234 */
	private String I000000234;
	/** I000000235 */
	private String I000000235;
	/** I000000236 */
	private String I000000236;
	/** I000000237 */
	private String I000000237;
	/** I000000240 */
	private String I000000240;
	/** I000000241 */
	private String I000000241;
	/** I000000242 */
	private String I000000242;
	/** I000000243 */
	private String I000000243;
	/** I000000244 */
	private String I000000244;
	/** I000000245 */
	private String I000000245;
	/** I000000246 */
	private String I000000246;
	/** I000000247 */
	private String I000000247;
	/** I000000248 */
	private String I000000248;
	/** I000000249 */
	private String I000000249;
	/** I000000250 */
	private String I000000250;
	/** I000000251 */
	private String I000000251;
	/** R000000201 */
	private String R000000201;
	/** R000000202 */
	private String R000000202;
	/** R000000203 */
	private String R000000203;
	/** R000000204 */
	private String R000000204;
	/** R000000205 */
	private String R000000205;
	/** I000000254 */
	private String I000000254;

	public static final int FIELDNUM = 457;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LAIndexInfoVSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[3];
		pk[0] = "WageNo";
		pk[1] = "IndexType";
		pk[2] = "AgentCode";

		PK = pk;
	}

	/**
	* Schema克隆
	* @return Object
	* @throws CloneNotSupportedException
	*/
	public Object clone()
		throws CloneNotSupportedException
	{
		LAIndexInfoVSchema cloned = (LAIndexInfoVSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	public String getWageNo()
	{
		return WageNo;
	}
	public void setWageNo(String aWageNo)
	{
		if(aWageNo!=null && aWageNo.length()>10)
			throw new IllegalArgumentException("WagenoWageNo值"+aWageNo+"的长度"+aWageNo.length()+"大于最大值10");
		WageNo = aWageNo;
	}
	public String getBranchType()
	{
		return BranchType;
	}
	public void setBranchType(String aBranchType)
	{
		if(aBranchType!=null && aBranchType.length()>2)
			throw new IllegalArgumentException("BranchtypeBranchType值"+aBranchType+"的长度"+aBranchType.length()+"大于最大值2");
		BranchType = aBranchType;
	}
	public String getIndexType()
	{
		return IndexType;
	}
	public void setIndexType(String aIndexType)
	{
		if(aIndexType!=null && aIndexType.length()>2)
			throw new IllegalArgumentException("IndextypeIndexType值"+aIndexType+"的长度"+aIndexType.length()+"大于最大值2");
		IndexType = aIndexType;
	}
	public String getAgentCode()
	{
		return AgentCode;
	}
	public void setAgentCode(String aAgentCode)
	{
		if(aAgentCode!=null && aAgentCode.length()>20)
			throw new IllegalArgumentException("AgentcodeAgentCode值"+aAgentCode+"的长度"+aAgentCode.length()+"大于最大值20");
		AgentCode = aAgentCode;
	}
	public String getAgentGrade()
	{
		return AgentGrade;
	}
	public void setAgentGrade(String aAgentGrade)
	{
		if(aAgentGrade!=null && aAgentGrade.length()>6)
			throw new IllegalArgumentException("AgentgradeAgentGrade值"+aAgentGrade+"的长度"+aAgentGrade.length()+"大于最大值6");
		AgentGrade = aAgentGrade;
	}
	public String getAgentGroup()
	{
		return AgentGroup;
	}
	public void setAgentGroup(String aAgentGroup)
	{
		if(aAgentGroup!=null && aAgentGroup.length()>20)
			throw new IllegalArgumentException("AgentgroupAgentGroup值"+aAgentGroup+"的长度"+aAgentGroup.length()+"大于最大值20");
		AgentGroup = aAgentGroup;
	}
	public String getState()
	{
		return State;
	}
	public void setState(String aState)
	{
		if(aState!=null && aState.length()>20)
			throw new IllegalArgumentException("StateState值"+aState+"的长度"+aState.length()+"大于最大值20");
		State = aState;
	}
	public String getMakeDate()
	{
		if( MakeDate != null )
			return fDate.getString(MakeDate);
		else
			return null;
	}
	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}
	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals("") )
		{
			MakeDate = fDate.getDate( aMakeDate );
		}
		else
			MakeDate = null;
	}

	public String getMakeTime()
	{
		return MakeTime;
	}
	public void setMakeTime(String aMakeTime)
	{
		if(aMakeTime!=null && aMakeTime.length()>8)
			throw new IllegalArgumentException("MaketimeMakeTime值"+aMakeTime+"的长度"+aMakeTime.length()+"大于最大值8");
		MakeTime = aMakeTime;
	}
	public String getModifyDate()
	{
		if( ModifyDate != null )
			return fDate.getString(ModifyDate);
		else
			return null;
	}
	public void setModifyDate(Date aModifyDate)
	{
		ModifyDate = aModifyDate;
	}
	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals("") )
		{
			ModifyDate = fDate.getDate( aModifyDate );
		}
		else
			ModifyDate = null;
	}

	public String getModifyTime()
	{
		return ModifyTime;
	}
	public void setModifyTime(String aModifyTime)
	{
		if(aModifyTime!=null && aModifyTime.length()>8)
			throw new IllegalArgumentException("ModifytimeModifyTime值"+aModifyTime+"的长度"+aModifyTime.length()+"大于最大值8");
		ModifyTime = aModifyTime;
	}
	public String getI000000001()
	{
		return I000000001;
	}
	public void setI000000001(String aI000000001)
	{
		if(aI000000001!=null && aI000000001.length()>17)
			throw new IllegalArgumentException("I000000001I000000001值"+aI000000001+"的长度"+aI000000001.length()+"大于最大值17");
		I000000001 = aI000000001;
	}
	public String getI000000002()
	{
		return I000000002;
	}
	public void setI000000002(String aI000000002)
	{
		if(aI000000002!=null && aI000000002.length()>17)
			throw new IllegalArgumentException("I000000002I000000002值"+aI000000002+"的长度"+aI000000002.length()+"大于最大值17");
		I000000002 = aI000000002;
	}
	public String getI000000003()
	{
		return I000000003;
	}
	public void setI000000003(String aI000000003)
	{
		if(aI000000003!=null && aI000000003.length()>17)
			throw new IllegalArgumentException("I000000003I000000003值"+aI000000003+"的长度"+aI000000003.length()+"大于最大值17");
		I000000003 = aI000000003;
	}
	public String getI000000004()
	{
		return I000000004;
	}
	public void setI000000004(String aI000000004)
	{
		if(aI000000004!=null && aI000000004.length()>17)
			throw new IllegalArgumentException("I000000004I000000004值"+aI000000004+"的长度"+aI000000004.length()+"大于最大值17");
		I000000004 = aI000000004;
	}
	public String getI000000005()
	{
		return I000000005;
	}
	public void setI000000005(String aI000000005)
	{
		if(aI000000005!=null && aI000000005.length()>17)
			throw new IllegalArgumentException("I000000005I000000005值"+aI000000005+"的长度"+aI000000005.length()+"大于最大值17");
		I000000005 = aI000000005;
	}
	public String getI000000006()
	{
		return I000000006;
	}
	public void setI000000006(String aI000000006)
	{
		if(aI000000006!=null && aI000000006.length()>17)
			throw new IllegalArgumentException("I000000006I000000006值"+aI000000006+"的长度"+aI000000006.length()+"大于最大值17");
		I000000006 = aI000000006;
	}
	public String getI000000007()
	{
		return I000000007;
	}
	public void setI000000007(String aI000000007)
	{
		if(aI000000007!=null && aI000000007.length()>17)
			throw new IllegalArgumentException("I000000007I000000007值"+aI000000007+"的长度"+aI000000007.length()+"大于最大值17");
		I000000007 = aI000000007;
	}
	public String getI000000008()
	{
		return I000000008;
	}
	public void setI000000008(String aI000000008)
	{
		if(aI000000008!=null && aI000000008.length()>17)
			throw new IllegalArgumentException("I000000008I000000008值"+aI000000008+"的长度"+aI000000008.length()+"大于最大值17");
		I000000008 = aI000000008;
	}
	public String getI000000009()
	{
		return I000000009;
	}
	public void setI000000009(String aI000000009)
	{
		if(aI000000009!=null && aI000000009.length()>17)
			throw new IllegalArgumentException("I000000009I000000009值"+aI000000009+"的长度"+aI000000009.length()+"大于最大值17");
		I000000009 = aI000000009;
	}
	public String getI000000010()
	{
		return I000000010;
	}
	public void setI000000010(String aI000000010)
	{
		if(aI000000010!=null && aI000000010.length()>17)
			throw new IllegalArgumentException("I000000010I000000010值"+aI000000010+"的长度"+aI000000010.length()+"大于最大值17");
		I000000010 = aI000000010;
	}
	public String getI000000011()
	{
		return I000000011;
	}
	public void setI000000011(String aI000000011)
	{
		if(aI000000011!=null && aI000000011.length()>17)
			throw new IllegalArgumentException("I000000011I000000011值"+aI000000011+"的长度"+aI000000011.length()+"大于最大值17");
		I000000011 = aI000000011;
	}
	public String getI000000012()
	{
		return I000000012;
	}
	public void setI000000012(String aI000000012)
	{
		if(aI000000012!=null && aI000000012.length()>17)
			throw new IllegalArgumentException("I000000012I000000012值"+aI000000012+"的长度"+aI000000012.length()+"大于最大值17");
		I000000012 = aI000000012;
	}
	public String getI000000013()
	{
		return I000000013;
	}
	public void setI000000013(String aI000000013)
	{
		if(aI000000013!=null && aI000000013.length()>17)
			throw new IllegalArgumentException("I000000013I000000013值"+aI000000013+"的长度"+aI000000013.length()+"大于最大值17");
		I000000013 = aI000000013;
	}
	public String getI000000014()
	{
		return I000000014;
	}
	public void setI000000014(String aI000000014)
	{
		if(aI000000014!=null && aI000000014.length()>17)
			throw new IllegalArgumentException("I000000014I000000014值"+aI000000014+"的长度"+aI000000014.length()+"大于最大值17");
		I000000014 = aI000000014;
	}
	public String getI000000015()
	{
		return I000000015;
	}
	public void setI000000015(String aI000000015)
	{
		if(aI000000015!=null && aI000000015.length()>17)
			throw new IllegalArgumentException("I000000015I000000015值"+aI000000015+"的长度"+aI000000015.length()+"大于最大值17");
		I000000015 = aI000000015;
	}
	public String getI000000016()
	{
		return I000000016;
	}
	public void setI000000016(String aI000000016)
	{
		if(aI000000016!=null && aI000000016.length()>17)
			throw new IllegalArgumentException("I000000016I000000016值"+aI000000016+"的长度"+aI000000016.length()+"大于最大值17");
		I000000016 = aI000000016;
	}
	public String getI000000017()
	{
		return I000000017;
	}
	public void setI000000017(String aI000000017)
	{
		if(aI000000017!=null && aI000000017.length()>17)
			throw new IllegalArgumentException("I000000017I000000017值"+aI000000017+"的长度"+aI000000017.length()+"大于最大值17");
		I000000017 = aI000000017;
	}
	public String getI000000018()
	{
		return I000000018;
	}
	public void setI000000018(String aI000000018)
	{
		if(aI000000018!=null && aI000000018.length()>17)
			throw new IllegalArgumentException("I000000018I000000018值"+aI000000018+"的长度"+aI000000018.length()+"大于最大值17");
		I000000018 = aI000000018;
	}
	public String getI000000019()
	{
		return I000000019;
	}
	public void setI000000019(String aI000000019)
	{
		if(aI000000019!=null && aI000000019.length()>17)
			throw new IllegalArgumentException("I000000019I000000019值"+aI000000019+"的长度"+aI000000019.length()+"大于最大值17");
		I000000019 = aI000000019;
	}
	public String getI000000020()
	{
		return I000000020;
	}
	public void setI000000020(String aI000000020)
	{
		if(aI000000020!=null && aI000000020.length()>17)
			throw new IllegalArgumentException("I000000020I000000020值"+aI000000020+"的长度"+aI000000020.length()+"大于最大值17");
		I000000020 = aI000000020;
	}
	public String getI000000021()
	{
		return I000000021;
	}
	public void setI000000021(String aI000000021)
	{
		if(aI000000021!=null && aI000000021.length()>17)
			throw new IllegalArgumentException("I000000021I000000021值"+aI000000021+"的长度"+aI000000021.length()+"大于最大值17");
		I000000021 = aI000000021;
	}
	public String getI000000022()
	{
		return I000000022;
	}
	public void setI000000022(String aI000000022)
	{
		if(aI000000022!=null && aI000000022.length()>17)
			throw new IllegalArgumentException("I000000022I000000022值"+aI000000022+"的长度"+aI000000022.length()+"大于最大值17");
		I000000022 = aI000000022;
	}
	public String getI000000023()
	{
		return I000000023;
	}
	public void setI000000023(String aI000000023)
	{
		if(aI000000023!=null && aI000000023.length()>17)
			throw new IllegalArgumentException("I000000023I000000023值"+aI000000023+"的长度"+aI000000023.length()+"大于最大值17");
		I000000023 = aI000000023;
	}
	public String getI000000024()
	{
		return I000000024;
	}
	public void setI000000024(String aI000000024)
	{
		if(aI000000024!=null && aI000000024.length()>17)
			throw new IllegalArgumentException("I000000024I000000024值"+aI000000024+"的长度"+aI000000024.length()+"大于最大值17");
		I000000024 = aI000000024;
	}
	public String getI000000025()
	{
		return I000000025;
	}
	public void setI000000025(String aI000000025)
	{
		if(aI000000025!=null && aI000000025.length()>17)
			throw new IllegalArgumentException("I000000025I000000025值"+aI000000025+"的长度"+aI000000025.length()+"大于最大值17");
		I000000025 = aI000000025;
	}
	public String getI000000026()
	{
		return I000000026;
	}
	public void setI000000026(String aI000000026)
	{
		if(aI000000026!=null && aI000000026.length()>17)
			throw new IllegalArgumentException("I000000026I000000026值"+aI000000026+"的长度"+aI000000026.length()+"大于最大值17");
		I000000026 = aI000000026;
	}
	public String getI000000027()
	{
		return I000000027;
	}
	public void setI000000027(String aI000000027)
	{
		if(aI000000027!=null && aI000000027.length()>17)
			throw new IllegalArgumentException("I000000027I000000027值"+aI000000027+"的长度"+aI000000027.length()+"大于最大值17");
		I000000027 = aI000000027;
	}
	public String getI000000028()
	{
		return I000000028;
	}
	public void setI000000028(String aI000000028)
	{
		if(aI000000028!=null && aI000000028.length()>17)
			throw new IllegalArgumentException("I000000028I000000028值"+aI000000028+"的长度"+aI000000028.length()+"大于最大值17");
		I000000028 = aI000000028;
	}
	public String getI000000029()
	{
		return I000000029;
	}
	public void setI000000029(String aI000000029)
	{
		if(aI000000029!=null && aI000000029.length()>17)
			throw new IllegalArgumentException("I000000029I000000029值"+aI000000029+"的长度"+aI000000029.length()+"大于最大值17");
		I000000029 = aI000000029;
	}
	public String getI000000030()
	{
		return I000000030;
	}
	public void setI000000030(String aI000000030)
	{
		if(aI000000030!=null && aI000000030.length()>17)
			throw new IllegalArgumentException("I000000030I000000030值"+aI000000030+"的长度"+aI000000030.length()+"大于最大值17");
		I000000030 = aI000000030;
	}
	public String getI000000031()
	{
		return I000000031;
	}
	public void setI000000031(String aI000000031)
	{
		if(aI000000031!=null && aI000000031.length()>17)
			throw new IllegalArgumentException("I000000031I000000031值"+aI000000031+"的长度"+aI000000031.length()+"大于最大值17");
		I000000031 = aI000000031;
	}
	public String getI000000032()
	{
		return I000000032;
	}
	public void setI000000032(String aI000000032)
	{
		if(aI000000032!=null && aI000000032.length()>17)
			throw new IllegalArgumentException("I000000032I000000032值"+aI000000032+"的长度"+aI000000032.length()+"大于最大值17");
		I000000032 = aI000000032;
	}
	public String getI000000033()
	{
		return I000000033;
	}
	public void setI000000033(String aI000000033)
	{
		if(aI000000033!=null && aI000000033.length()>17)
			throw new IllegalArgumentException("I000000033I000000033值"+aI000000033+"的长度"+aI000000033.length()+"大于最大值17");
		I000000033 = aI000000033;
	}
	public String getI000000034()
	{
		return I000000034;
	}
	public void setI000000034(String aI000000034)
	{
		if(aI000000034!=null && aI000000034.length()>17)
			throw new IllegalArgumentException("I000000034I000000034值"+aI000000034+"的长度"+aI000000034.length()+"大于最大值17");
		I000000034 = aI000000034;
	}
	public String getI000000035()
	{
		return I000000035;
	}
	public void setI000000035(String aI000000035)
	{
		if(aI000000035!=null && aI000000035.length()>17)
			throw new IllegalArgumentException("I000000035I000000035值"+aI000000035+"的长度"+aI000000035.length()+"大于最大值17");
		I000000035 = aI000000035;
	}
	public String getI000000036()
	{
		return I000000036;
	}
	public void setI000000036(String aI000000036)
	{
		if(aI000000036!=null && aI000000036.length()>17)
			throw new IllegalArgumentException("I000000036I000000036值"+aI000000036+"的长度"+aI000000036.length()+"大于最大值17");
		I000000036 = aI000000036;
	}
	public String getI000000037()
	{
		return I000000037;
	}
	public void setI000000037(String aI000000037)
	{
		if(aI000000037!=null && aI000000037.length()>17)
			throw new IllegalArgumentException("I000000037I000000037值"+aI000000037+"的长度"+aI000000037.length()+"大于最大值17");
		I000000037 = aI000000037;
	}
	public String getI000000038()
	{
		return I000000038;
	}
	public void setI000000038(String aI000000038)
	{
		if(aI000000038!=null && aI000000038.length()>17)
			throw new IllegalArgumentException("I000000038I000000038值"+aI000000038+"的长度"+aI000000038.length()+"大于最大值17");
		I000000038 = aI000000038;
	}
	public String getI000000039()
	{
		return I000000039;
	}
	public void setI000000039(String aI000000039)
	{
		if(aI000000039!=null && aI000000039.length()>17)
			throw new IllegalArgumentException("I000000039I000000039值"+aI000000039+"的长度"+aI000000039.length()+"大于最大值17");
		I000000039 = aI000000039;
	}
	public String getI000000040()
	{
		return I000000040;
	}
	public void setI000000040(String aI000000040)
	{
		if(aI000000040!=null && aI000000040.length()>17)
			throw new IllegalArgumentException("I000000040I000000040值"+aI000000040+"的长度"+aI000000040.length()+"大于最大值17");
		I000000040 = aI000000040;
	}
	public String getI000000041()
	{
		return I000000041;
	}
	public void setI000000041(String aI000000041)
	{
		if(aI000000041!=null && aI000000041.length()>17)
			throw new IllegalArgumentException("I000000041I000000041值"+aI000000041+"的长度"+aI000000041.length()+"大于最大值17");
		I000000041 = aI000000041;
	}
	public String getI000000042()
	{
		return I000000042;
	}
	public void setI000000042(String aI000000042)
	{
		if(aI000000042!=null && aI000000042.length()>17)
			throw new IllegalArgumentException("I000000042I000000042值"+aI000000042+"的长度"+aI000000042.length()+"大于最大值17");
		I000000042 = aI000000042;
	}
	public String getI000000043()
	{
		return I000000043;
	}
	public void setI000000043(String aI000000043)
	{
		if(aI000000043!=null && aI000000043.length()>17)
			throw new IllegalArgumentException("I000000043I000000043值"+aI000000043+"的长度"+aI000000043.length()+"大于最大值17");
		I000000043 = aI000000043;
	}
	public String getI000000044()
	{
		return I000000044;
	}
	public void setI000000044(String aI000000044)
	{
		if(aI000000044!=null && aI000000044.length()>17)
			throw new IllegalArgumentException("I000000044I000000044值"+aI000000044+"的长度"+aI000000044.length()+"大于最大值17");
		I000000044 = aI000000044;
	}
	public String getI000000045()
	{
		return I000000045;
	}
	public void setI000000045(String aI000000045)
	{
		if(aI000000045!=null && aI000000045.length()>17)
			throw new IllegalArgumentException("I000000045I000000045值"+aI000000045+"的长度"+aI000000045.length()+"大于最大值17");
		I000000045 = aI000000045;
	}
	public String getI000000046()
	{
		return I000000046;
	}
	public void setI000000046(String aI000000046)
	{
		if(aI000000046!=null && aI000000046.length()>17)
			throw new IllegalArgumentException("I000000046I000000046值"+aI000000046+"的长度"+aI000000046.length()+"大于最大值17");
		I000000046 = aI000000046;
	}
	public String getI000000047()
	{
		return I000000047;
	}
	public void setI000000047(String aI000000047)
	{
		if(aI000000047!=null && aI000000047.length()>17)
			throw new IllegalArgumentException("I000000047I000000047值"+aI000000047+"的长度"+aI000000047.length()+"大于最大值17");
		I000000047 = aI000000047;
	}
	public String getI000000048()
	{
		return I000000048;
	}
	public void setI000000048(String aI000000048)
	{
		if(aI000000048!=null && aI000000048.length()>17)
			throw new IllegalArgumentException("I000000048I000000048值"+aI000000048+"的长度"+aI000000048.length()+"大于最大值17");
		I000000048 = aI000000048;
	}
	public String getI000000049()
	{
		return I000000049;
	}
	public void setI000000049(String aI000000049)
	{
		if(aI000000049!=null && aI000000049.length()>17)
			throw new IllegalArgumentException("I000000049I000000049值"+aI000000049+"的长度"+aI000000049.length()+"大于最大值17");
		I000000049 = aI000000049;
	}
	public String getI000000050()
	{
		return I000000050;
	}
	public void setI000000050(String aI000000050)
	{
		if(aI000000050!=null && aI000000050.length()>17)
			throw new IllegalArgumentException("I000000050I000000050值"+aI000000050+"的长度"+aI000000050.length()+"大于最大值17");
		I000000050 = aI000000050;
	}
	public String getI000000051()
	{
		return I000000051;
	}
	public void setI000000051(String aI000000051)
	{
		if(aI000000051!=null && aI000000051.length()>17)
			throw new IllegalArgumentException("I000000051I000000051值"+aI000000051+"的长度"+aI000000051.length()+"大于最大值17");
		I000000051 = aI000000051;
	}
	public String getI000000052()
	{
		return I000000052;
	}
	public void setI000000052(String aI000000052)
	{
		if(aI000000052!=null && aI000000052.length()>17)
			throw new IllegalArgumentException("I000000052I000000052值"+aI000000052+"的长度"+aI000000052.length()+"大于最大值17");
		I000000052 = aI000000052;
	}
	public String getI000000053()
	{
		return I000000053;
	}
	public void setI000000053(String aI000000053)
	{
		if(aI000000053!=null && aI000000053.length()>17)
			throw new IllegalArgumentException("I000000053I000000053值"+aI000000053+"的长度"+aI000000053.length()+"大于最大值17");
		I000000053 = aI000000053;
	}
	public String getI000000054()
	{
		return I000000054;
	}
	public void setI000000054(String aI000000054)
	{
		if(aI000000054!=null && aI000000054.length()>17)
			throw new IllegalArgumentException("I000000054I000000054值"+aI000000054+"的长度"+aI000000054.length()+"大于最大值17");
		I000000054 = aI000000054;
	}
	public String getI000000055()
	{
		return I000000055;
	}
	public void setI000000055(String aI000000055)
	{
		if(aI000000055!=null && aI000000055.length()>17)
			throw new IllegalArgumentException("I000000055I000000055值"+aI000000055+"的长度"+aI000000055.length()+"大于最大值17");
		I000000055 = aI000000055;
	}
	public String getI000000056()
	{
		return I000000056;
	}
	public void setI000000056(String aI000000056)
	{
		if(aI000000056!=null && aI000000056.length()>17)
			throw new IllegalArgumentException("I000000056I000000056值"+aI000000056+"的长度"+aI000000056.length()+"大于最大值17");
		I000000056 = aI000000056;
	}
	public String getI000000057()
	{
		return I000000057;
	}
	public void setI000000057(String aI000000057)
	{
		if(aI000000057!=null && aI000000057.length()>17)
			throw new IllegalArgumentException("I000000057I000000057值"+aI000000057+"的长度"+aI000000057.length()+"大于最大值17");
		I000000057 = aI000000057;
	}
	public String getI000000058()
	{
		return I000000058;
	}
	public void setI000000058(String aI000000058)
	{
		if(aI000000058!=null && aI000000058.length()>17)
			throw new IllegalArgumentException("I000000058I000000058值"+aI000000058+"的长度"+aI000000058.length()+"大于最大值17");
		I000000058 = aI000000058;
	}
	public String getI000000059()
	{
		return I000000059;
	}
	public void setI000000059(String aI000000059)
	{
		if(aI000000059!=null && aI000000059.length()>17)
			throw new IllegalArgumentException("I000000059I000000059值"+aI000000059+"的长度"+aI000000059.length()+"大于最大值17");
		I000000059 = aI000000059;
	}
	public String getI000000060()
	{
		return I000000060;
	}
	public void setI000000060(String aI000000060)
	{
		if(aI000000060!=null && aI000000060.length()>17)
			throw new IllegalArgumentException("I000000060I000000060值"+aI000000060+"的长度"+aI000000060.length()+"大于最大值17");
		I000000060 = aI000000060;
	}
	public String getI000000061()
	{
		return I000000061;
	}
	public void setI000000061(String aI000000061)
	{
		if(aI000000061!=null && aI000000061.length()>17)
			throw new IllegalArgumentException("I000000061I000000061值"+aI000000061+"的长度"+aI000000061.length()+"大于最大值17");
		I000000061 = aI000000061;
	}
	public String getI000000062()
	{
		return I000000062;
	}
	public void setI000000062(String aI000000062)
	{
		if(aI000000062!=null && aI000000062.length()>17)
			throw new IllegalArgumentException("I000000062I000000062值"+aI000000062+"的长度"+aI000000062.length()+"大于最大值17");
		I000000062 = aI000000062;
	}
	public String getI000000063()
	{
		return I000000063;
	}
	public void setI000000063(String aI000000063)
	{
		if(aI000000063!=null && aI000000063.length()>17)
			throw new IllegalArgumentException("I000000063I000000063值"+aI000000063+"的长度"+aI000000063.length()+"大于最大值17");
		I000000063 = aI000000063;
	}
	public String getI000000064()
	{
		return I000000064;
	}
	public void setI000000064(String aI000000064)
	{
		if(aI000000064!=null && aI000000064.length()>17)
			throw new IllegalArgumentException("I000000064I000000064值"+aI000000064+"的长度"+aI000000064.length()+"大于最大值17");
		I000000064 = aI000000064;
	}
	public String getI000000065()
	{
		return I000000065;
	}
	public void setI000000065(String aI000000065)
	{
		if(aI000000065!=null && aI000000065.length()>17)
			throw new IllegalArgumentException("I000000065I000000065值"+aI000000065+"的长度"+aI000000065.length()+"大于最大值17");
		I000000065 = aI000000065;
	}
	public String getI000000066()
	{
		return I000000066;
	}
	public void setI000000066(String aI000000066)
	{
		if(aI000000066!=null && aI000000066.length()>17)
			throw new IllegalArgumentException("I000000066I000000066值"+aI000000066+"的长度"+aI000000066.length()+"大于最大值17");
		I000000066 = aI000000066;
	}
	public String getI000000067()
	{
		return I000000067;
	}
	public void setI000000067(String aI000000067)
	{
		if(aI000000067!=null && aI000000067.length()>17)
			throw new IllegalArgumentException("I000000067I000000067值"+aI000000067+"的长度"+aI000000067.length()+"大于最大值17");
		I000000067 = aI000000067;
	}
	public String getI000000068()
	{
		return I000000068;
	}
	public void setI000000068(String aI000000068)
	{
		if(aI000000068!=null && aI000000068.length()>17)
			throw new IllegalArgumentException("I000000068I000000068值"+aI000000068+"的长度"+aI000000068.length()+"大于最大值17");
		I000000068 = aI000000068;
	}
	public String getI000000069()
	{
		return I000000069;
	}
	public void setI000000069(String aI000000069)
	{
		if(aI000000069!=null && aI000000069.length()>17)
			throw new IllegalArgumentException("I000000069I000000069值"+aI000000069+"的长度"+aI000000069.length()+"大于最大值17");
		I000000069 = aI000000069;
	}
	public String getI000000070()
	{
		return I000000070;
	}
	public void setI000000070(String aI000000070)
	{
		if(aI000000070!=null && aI000000070.length()>17)
			throw new IllegalArgumentException("I000000070I000000070值"+aI000000070+"的长度"+aI000000070.length()+"大于最大值17");
		I000000070 = aI000000070;
	}
	public String getI000000071()
	{
		return I000000071;
	}
	public void setI000000071(String aI000000071)
	{
		if(aI000000071!=null && aI000000071.length()>17)
			throw new IllegalArgumentException("I000000071I000000071值"+aI000000071+"的长度"+aI000000071.length()+"大于最大值17");
		I000000071 = aI000000071;
	}
	public String getI000000072()
	{
		return I000000072;
	}
	public void setI000000072(String aI000000072)
	{
		if(aI000000072!=null && aI000000072.length()>17)
			throw new IllegalArgumentException("I000000072I000000072值"+aI000000072+"的长度"+aI000000072.length()+"大于最大值17");
		I000000072 = aI000000072;
	}
	public String getI000000073()
	{
		return I000000073;
	}
	public void setI000000073(String aI000000073)
	{
		if(aI000000073!=null && aI000000073.length()>17)
			throw new IllegalArgumentException("I000000073I000000073值"+aI000000073+"的长度"+aI000000073.length()+"大于最大值17");
		I000000073 = aI000000073;
	}
	public String getI000000074()
	{
		return I000000074;
	}
	public void setI000000074(String aI000000074)
	{
		if(aI000000074!=null && aI000000074.length()>17)
			throw new IllegalArgumentException("I000000074I000000074值"+aI000000074+"的长度"+aI000000074.length()+"大于最大值17");
		I000000074 = aI000000074;
	}
	public String getI000000075()
	{
		return I000000075;
	}
	public void setI000000075(String aI000000075)
	{
		if(aI000000075!=null && aI000000075.length()>17)
			throw new IllegalArgumentException("I000000075I000000075值"+aI000000075+"的长度"+aI000000075.length()+"大于最大值17");
		I000000075 = aI000000075;
	}
	public String getI000000076()
	{
		return I000000076;
	}
	public void setI000000076(String aI000000076)
	{
		if(aI000000076!=null && aI000000076.length()>17)
			throw new IllegalArgumentException("I000000076I000000076值"+aI000000076+"的长度"+aI000000076.length()+"大于最大值17");
		I000000076 = aI000000076;
	}
	public String getI000000077()
	{
		return I000000077;
	}
	public void setI000000077(String aI000000077)
	{
		if(aI000000077!=null && aI000000077.length()>17)
			throw new IllegalArgumentException("I000000077I000000077值"+aI000000077+"的长度"+aI000000077.length()+"大于最大值17");
		I000000077 = aI000000077;
	}
	public String getI000000078()
	{
		return I000000078;
	}
	public void setI000000078(String aI000000078)
	{
		if(aI000000078!=null && aI000000078.length()>17)
			throw new IllegalArgumentException("I000000078I000000078值"+aI000000078+"的长度"+aI000000078.length()+"大于最大值17");
		I000000078 = aI000000078;
	}
	public String getI000000079()
	{
		return I000000079;
	}
	public void setI000000079(String aI000000079)
	{
		if(aI000000079!=null && aI000000079.length()>17)
			throw new IllegalArgumentException("I000000079I000000079值"+aI000000079+"的长度"+aI000000079.length()+"大于最大值17");
		I000000079 = aI000000079;
	}
	public String getI000000080()
	{
		return I000000080;
	}
	public void setI000000080(String aI000000080)
	{
		if(aI000000080!=null && aI000000080.length()>17)
			throw new IllegalArgumentException("I000000080I000000080值"+aI000000080+"的长度"+aI000000080.length()+"大于最大值17");
		I000000080 = aI000000080;
	}
	public String getI000000081()
	{
		return I000000081;
	}
	public void setI000000081(String aI000000081)
	{
		if(aI000000081!=null && aI000000081.length()>17)
			throw new IllegalArgumentException("I000000081I000000081值"+aI000000081+"的长度"+aI000000081.length()+"大于最大值17");
		I000000081 = aI000000081;
	}
	public String getI000000082()
	{
		return I000000082;
	}
	public void setI000000082(String aI000000082)
	{
		if(aI000000082!=null && aI000000082.length()>17)
			throw new IllegalArgumentException("I000000082I000000082值"+aI000000082+"的长度"+aI000000082.length()+"大于最大值17");
		I000000082 = aI000000082;
	}
	public String getI000000083()
	{
		return I000000083;
	}
	public void setI000000083(String aI000000083)
	{
		if(aI000000083!=null && aI000000083.length()>17)
			throw new IllegalArgumentException("I000000083I000000083值"+aI000000083+"的长度"+aI000000083.length()+"大于最大值17");
		I000000083 = aI000000083;
	}
	public String getI000000084()
	{
		return I000000084;
	}
	public void setI000000084(String aI000000084)
	{
		if(aI000000084!=null && aI000000084.length()>17)
			throw new IllegalArgumentException("I000000084I000000084值"+aI000000084+"的长度"+aI000000084.length()+"大于最大值17");
		I000000084 = aI000000084;
	}
	public String getI000000085()
	{
		return I000000085;
	}
	public void setI000000085(String aI000000085)
	{
		if(aI000000085!=null && aI000000085.length()>17)
			throw new IllegalArgumentException("I000000085I000000085值"+aI000000085+"的长度"+aI000000085.length()+"大于最大值17");
		I000000085 = aI000000085;
	}
	public String getI000000086()
	{
		return I000000086;
	}
	public void setI000000086(String aI000000086)
	{
		if(aI000000086!=null && aI000000086.length()>17)
			throw new IllegalArgumentException("I000000086I000000086值"+aI000000086+"的长度"+aI000000086.length()+"大于最大值17");
		I000000086 = aI000000086;
	}
	public String getI000000087()
	{
		return I000000087;
	}
	public void setI000000087(String aI000000087)
	{
		if(aI000000087!=null && aI000000087.length()>17)
			throw new IllegalArgumentException("I000000087I000000087值"+aI000000087+"的长度"+aI000000087.length()+"大于最大值17");
		I000000087 = aI000000087;
	}
	public String getI000000088()
	{
		return I000000088;
	}
	public void setI000000088(String aI000000088)
	{
		if(aI000000088!=null && aI000000088.length()>17)
			throw new IllegalArgumentException("I000000088I000000088值"+aI000000088+"的长度"+aI000000088.length()+"大于最大值17");
		I000000088 = aI000000088;
	}
	public String getI000000089()
	{
		return I000000089;
	}
	public void setI000000089(String aI000000089)
	{
		if(aI000000089!=null && aI000000089.length()>17)
			throw new IllegalArgumentException("I000000089I000000089值"+aI000000089+"的长度"+aI000000089.length()+"大于最大值17");
		I000000089 = aI000000089;
	}
	public String getI000000090()
	{
		return I000000090;
	}
	public void setI000000090(String aI000000090)
	{
		if(aI000000090!=null && aI000000090.length()>17)
			throw new IllegalArgumentException("I000000090I000000090值"+aI000000090+"的长度"+aI000000090.length()+"大于最大值17");
		I000000090 = aI000000090;
	}
	public String getI000000091()
	{
		return I000000091;
	}
	public void setI000000091(String aI000000091)
	{
		if(aI000000091!=null && aI000000091.length()>17)
			throw new IllegalArgumentException("I000000091I000000091值"+aI000000091+"的长度"+aI000000091.length()+"大于最大值17");
		I000000091 = aI000000091;
	}
	public String getI000000092()
	{
		return I000000092;
	}
	public void setI000000092(String aI000000092)
	{
		if(aI000000092!=null && aI000000092.length()>17)
			throw new IllegalArgumentException("I000000092I000000092值"+aI000000092+"的长度"+aI000000092.length()+"大于最大值17");
		I000000092 = aI000000092;
	}
	public String getI000000093()
	{
		return I000000093;
	}
	public void setI000000093(String aI000000093)
	{
		if(aI000000093!=null && aI000000093.length()>17)
			throw new IllegalArgumentException("I000000093I000000093值"+aI000000093+"的长度"+aI000000093.length()+"大于最大值17");
		I000000093 = aI000000093;
	}
	public String getI000000094()
	{
		return I000000094;
	}
	public void setI000000094(String aI000000094)
	{
		if(aI000000094!=null && aI000000094.length()>17)
			throw new IllegalArgumentException("I000000094I000000094值"+aI000000094+"的长度"+aI000000094.length()+"大于最大值17");
		I000000094 = aI000000094;
	}
	public String getI000000095()
	{
		return I000000095;
	}
	public void setI000000095(String aI000000095)
	{
		if(aI000000095!=null && aI000000095.length()>17)
			throw new IllegalArgumentException("I000000095I000000095值"+aI000000095+"的长度"+aI000000095.length()+"大于最大值17");
		I000000095 = aI000000095;
	}
	public String getI000000096()
	{
		return I000000096;
	}
	public void setI000000096(String aI000000096)
	{
		if(aI000000096!=null && aI000000096.length()>17)
			throw new IllegalArgumentException("I000000096I000000096值"+aI000000096+"的长度"+aI000000096.length()+"大于最大值17");
		I000000096 = aI000000096;
	}
	public String getI000000097()
	{
		return I000000097;
	}
	public void setI000000097(String aI000000097)
	{
		if(aI000000097!=null && aI000000097.length()>17)
			throw new IllegalArgumentException("I000000097I000000097值"+aI000000097+"的长度"+aI000000097.length()+"大于最大值17");
		I000000097 = aI000000097;
	}
	public String getI000000098()
	{
		return I000000098;
	}
	public void setI000000098(String aI000000098)
	{
		if(aI000000098!=null && aI000000098.length()>17)
			throw new IllegalArgumentException("I000000098I000000098值"+aI000000098+"的长度"+aI000000098.length()+"大于最大值17");
		I000000098 = aI000000098;
	}
	public String getI000000099()
	{
		return I000000099;
	}
	public void setI000000099(String aI000000099)
	{
		if(aI000000099!=null && aI000000099.length()>17)
			throw new IllegalArgumentException("I000000099I000000099值"+aI000000099+"的长度"+aI000000099.length()+"大于最大值17");
		I000000099 = aI000000099;
	}
	public String getI000000100()
	{
		return I000000100;
	}
	public void setI000000100(String aI000000100)
	{
		if(aI000000100!=null && aI000000100.length()>17)
			throw new IllegalArgumentException("I000000100I000000100值"+aI000000100+"的长度"+aI000000100.length()+"大于最大值17");
		I000000100 = aI000000100;
	}
	public String getI000000101()
	{
		return I000000101;
	}
	public void setI000000101(String aI000000101)
	{
		if(aI000000101!=null && aI000000101.length()>17)
			throw new IllegalArgumentException("I000000101I000000101值"+aI000000101+"的长度"+aI000000101.length()+"大于最大值17");
		I000000101 = aI000000101;
	}
	public String getI000000102()
	{
		return I000000102;
	}
	public void setI000000102(String aI000000102)
	{
		if(aI000000102!=null && aI000000102.length()>17)
			throw new IllegalArgumentException("I000000102I000000102值"+aI000000102+"的长度"+aI000000102.length()+"大于最大值17");
		I000000102 = aI000000102;
	}
	public String getI000000103()
	{
		return I000000103;
	}
	public void setI000000103(String aI000000103)
	{
		if(aI000000103!=null && aI000000103.length()>17)
			throw new IllegalArgumentException("I000000103I000000103值"+aI000000103+"的长度"+aI000000103.length()+"大于最大值17");
		I000000103 = aI000000103;
	}
	public String getI000000104()
	{
		return I000000104;
	}
	public void setI000000104(String aI000000104)
	{
		if(aI000000104!=null && aI000000104.length()>17)
			throw new IllegalArgumentException("I000000104I000000104值"+aI000000104+"的长度"+aI000000104.length()+"大于最大值17");
		I000000104 = aI000000104;
	}
	public String getI000000105()
	{
		return I000000105;
	}
	public void setI000000105(String aI000000105)
	{
		if(aI000000105!=null && aI000000105.length()>17)
			throw new IllegalArgumentException("I000000105I000000105值"+aI000000105+"的长度"+aI000000105.length()+"大于最大值17");
		I000000105 = aI000000105;
	}
	public String getI000000106()
	{
		return I000000106;
	}
	public void setI000000106(String aI000000106)
	{
		if(aI000000106!=null && aI000000106.length()>17)
			throw new IllegalArgumentException("I000000106I000000106值"+aI000000106+"的长度"+aI000000106.length()+"大于最大值17");
		I000000106 = aI000000106;
	}
	public String getI000000107()
	{
		return I000000107;
	}
	public void setI000000107(String aI000000107)
	{
		if(aI000000107!=null && aI000000107.length()>17)
			throw new IllegalArgumentException("I000000107I000000107值"+aI000000107+"的长度"+aI000000107.length()+"大于最大值17");
		I000000107 = aI000000107;
	}
	public String getI000000108()
	{
		return I000000108;
	}
	public void setI000000108(String aI000000108)
	{
		if(aI000000108!=null && aI000000108.length()>17)
			throw new IllegalArgumentException("I000000108I000000108值"+aI000000108+"的长度"+aI000000108.length()+"大于最大值17");
		I000000108 = aI000000108;
	}
	public String getI000000109()
	{
		return I000000109;
	}
	public void setI000000109(String aI000000109)
	{
		if(aI000000109!=null && aI000000109.length()>17)
			throw new IllegalArgumentException("I000000109I000000109值"+aI000000109+"的长度"+aI000000109.length()+"大于最大值17");
		I000000109 = aI000000109;
	}
	public String getI000000110()
	{
		return I000000110;
	}
	public void setI000000110(String aI000000110)
	{
		if(aI000000110!=null && aI000000110.length()>17)
			throw new IllegalArgumentException("I000000110I000000110值"+aI000000110+"的长度"+aI000000110.length()+"大于最大值17");
		I000000110 = aI000000110;
	}
	public String getI000000111()
	{
		return I000000111;
	}
	public void setI000000111(String aI000000111)
	{
		if(aI000000111!=null && aI000000111.length()>17)
			throw new IllegalArgumentException("I000000111I000000111值"+aI000000111+"的长度"+aI000000111.length()+"大于最大值17");
		I000000111 = aI000000111;
	}
	public String getI000000112()
	{
		return I000000112;
	}
	public void setI000000112(String aI000000112)
	{
		if(aI000000112!=null && aI000000112.length()>17)
			throw new IllegalArgumentException("I000000112I000000112值"+aI000000112+"的长度"+aI000000112.length()+"大于最大值17");
		I000000112 = aI000000112;
	}
	public String getI000000113()
	{
		return I000000113;
	}
	public void setI000000113(String aI000000113)
	{
		if(aI000000113!=null && aI000000113.length()>17)
			throw new IllegalArgumentException("I000000113I000000113值"+aI000000113+"的长度"+aI000000113.length()+"大于最大值17");
		I000000113 = aI000000113;
	}
	public String getI000000114()
	{
		return I000000114;
	}
	public void setI000000114(String aI000000114)
	{
		if(aI000000114!=null && aI000000114.length()>17)
			throw new IllegalArgumentException("I000000114I000000114值"+aI000000114+"的长度"+aI000000114.length()+"大于最大值17");
		I000000114 = aI000000114;
	}
	public String getI000000115()
	{
		return I000000115;
	}
	public void setI000000115(String aI000000115)
	{
		if(aI000000115!=null && aI000000115.length()>17)
			throw new IllegalArgumentException("I000000115I000000115值"+aI000000115+"的长度"+aI000000115.length()+"大于最大值17");
		I000000115 = aI000000115;
	}
	public String getI000000116()
	{
		return I000000116;
	}
	public void setI000000116(String aI000000116)
	{
		if(aI000000116!=null && aI000000116.length()>17)
			throw new IllegalArgumentException("I000000116I000000116值"+aI000000116+"的长度"+aI000000116.length()+"大于最大值17");
		I000000116 = aI000000116;
	}
	public String getI000000117()
	{
		return I000000117;
	}
	public void setI000000117(String aI000000117)
	{
		if(aI000000117!=null && aI000000117.length()>17)
			throw new IllegalArgumentException("I000000117I000000117值"+aI000000117+"的长度"+aI000000117.length()+"大于最大值17");
		I000000117 = aI000000117;
	}
	public String getI000000118()
	{
		return I000000118;
	}
	public void setI000000118(String aI000000118)
	{
		if(aI000000118!=null && aI000000118.length()>17)
			throw new IllegalArgumentException("I000000118I000000118值"+aI000000118+"的长度"+aI000000118.length()+"大于最大值17");
		I000000118 = aI000000118;
	}
	public String getI000000119()
	{
		return I000000119;
	}
	public void setI000000119(String aI000000119)
	{
		if(aI000000119!=null && aI000000119.length()>17)
			throw new IllegalArgumentException("I000000119I000000119值"+aI000000119+"的长度"+aI000000119.length()+"大于最大值17");
		I000000119 = aI000000119;
	}
	public String getI000000120()
	{
		return I000000120;
	}
	public void setI000000120(String aI000000120)
	{
		if(aI000000120!=null && aI000000120.length()>17)
			throw new IllegalArgumentException("I000000120I000000120值"+aI000000120+"的长度"+aI000000120.length()+"大于最大值17");
		I000000120 = aI000000120;
	}
	public String getI000000121()
	{
		return I000000121;
	}
	public void setI000000121(String aI000000121)
	{
		if(aI000000121!=null && aI000000121.length()>17)
			throw new IllegalArgumentException("I000000121I000000121值"+aI000000121+"的长度"+aI000000121.length()+"大于最大值17");
		I000000121 = aI000000121;
	}
	public String getI000000122()
	{
		return I000000122;
	}
	public void setI000000122(String aI000000122)
	{
		if(aI000000122!=null && aI000000122.length()>17)
			throw new IllegalArgumentException("I000000122I000000122值"+aI000000122+"的长度"+aI000000122.length()+"大于最大值17");
		I000000122 = aI000000122;
	}
	public String getI000000123()
	{
		return I000000123;
	}
	public void setI000000123(String aI000000123)
	{
		if(aI000000123!=null && aI000000123.length()>17)
			throw new IllegalArgumentException("I000000123I000000123值"+aI000000123+"的长度"+aI000000123.length()+"大于最大值17");
		I000000123 = aI000000123;
	}
	public String getI000000124()
	{
		return I000000124;
	}
	public void setI000000124(String aI000000124)
	{
		if(aI000000124!=null && aI000000124.length()>17)
			throw new IllegalArgumentException("I000000124I000000124值"+aI000000124+"的长度"+aI000000124.length()+"大于最大值17");
		I000000124 = aI000000124;
	}
	public String getI000000125()
	{
		return I000000125;
	}
	public void setI000000125(String aI000000125)
	{
		if(aI000000125!=null && aI000000125.length()>17)
			throw new IllegalArgumentException("I000000125I000000125值"+aI000000125+"的长度"+aI000000125.length()+"大于最大值17");
		I000000125 = aI000000125;
	}
	public String getI000000126()
	{
		return I000000126;
	}
	public void setI000000126(String aI000000126)
	{
		if(aI000000126!=null && aI000000126.length()>17)
			throw new IllegalArgumentException("I000000126I000000126值"+aI000000126+"的长度"+aI000000126.length()+"大于最大值17");
		I000000126 = aI000000126;
	}
	public String getI000000127()
	{
		return I000000127;
	}
	public void setI000000127(String aI000000127)
	{
		if(aI000000127!=null && aI000000127.length()>17)
			throw new IllegalArgumentException("I000000127I000000127值"+aI000000127+"的长度"+aI000000127.length()+"大于最大值17");
		I000000127 = aI000000127;
	}
	public String getI000000128()
	{
		return I000000128;
	}
	public void setI000000128(String aI000000128)
	{
		if(aI000000128!=null && aI000000128.length()>17)
			throw new IllegalArgumentException("I000000128I000000128值"+aI000000128+"的长度"+aI000000128.length()+"大于最大值17");
		I000000128 = aI000000128;
	}
	public String getI000000129()
	{
		return I000000129;
	}
	public void setI000000129(String aI000000129)
	{
		if(aI000000129!=null && aI000000129.length()>17)
			throw new IllegalArgumentException("I000000129I000000129值"+aI000000129+"的长度"+aI000000129.length()+"大于最大值17");
		I000000129 = aI000000129;
	}
	public String getI000000130()
	{
		return I000000130;
	}
	public void setI000000130(String aI000000130)
	{
		if(aI000000130!=null && aI000000130.length()>17)
			throw new IllegalArgumentException("I000000130I000000130值"+aI000000130+"的长度"+aI000000130.length()+"大于最大值17");
		I000000130 = aI000000130;
	}
	public String getI000000131()
	{
		return I000000131;
	}
	public void setI000000131(String aI000000131)
	{
		if(aI000000131!=null && aI000000131.length()>17)
			throw new IllegalArgumentException("I000000131I000000131值"+aI000000131+"的长度"+aI000000131.length()+"大于最大值17");
		I000000131 = aI000000131;
	}
	public String getI000000132()
	{
		return I000000132;
	}
	public void setI000000132(String aI000000132)
	{
		if(aI000000132!=null && aI000000132.length()>17)
			throw new IllegalArgumentException("I000000132I000000132值"+aI000000132+"的长度"+aI000000132.length()+"大于最大值17");
		I000000132 = aI000000132;
	}
	public String getI000000133()
	{
		return I000000133;
	}
	public void setI000000133(String aI000000133)
	{
		if(aI000000133!=null && aI000000133.length()>17)
			throw new IllegalArgumentException("I000000133I000000133值"+aI000000133+"的长度"+aI000000133.length()+"大于最大值17");
		I000000133 = aI000000133;
	}
	public String getI000000134()
	{
		return I000000134;
	}
	public void setI000000134(String aI000000134)
	{
		if(aI000000134!=null && aI000000134.length()>17)
			throw new IllegalArgumentException("I000000134I000000134值"+aI000000134+"的长度"+aI000000134.length()+"大于最大值17");
		I000000134 = aI000000134;
	}
	public String getI000000135()
	{
		return I000000135;
	}
	public void setI000000135(String aI000000135)
	{
		if(aI000000135!=null && aI000000135.length()>17)
			throw new IllegalArgumentException("I000000135I000000135值"+aI000000135+"的长度"+aI000000135.length()+"大于最大值17");
		I000000135 = aI000000135;
	}
	public String getI000000136()
	{
		return I000000136;
	}
	public void setI000000136(String aI000000136)
	{
		if(aI000000136!=null && aI000000136.length()>17)
			throw new IllegalArgumentException("I000000136I000000136值"+aI000000136+"的长度"+aI000000136.length()+"大于最大值17");
		I000000136 = aI000000136;
	}
	public String getI000000137()
	{
		return I000000137;
	}
	public void setI000000137(String aI000000137)
	{
		if(aI000000137!=null && aI000000137.length()>17)
			throw new IllegalArgumentException("I000000137I000000137值"+aI000000137+"的长度"+aI000000137.length()+"大于最大值17");
		I000000137 = aI000000137;
	}
	public String getI000000138()
	{
		return I000000138;
	}
	public void setI000000138(String aI000000138)
	{
		if(aI000000138!=null && aI000000138.length()>17)
			throw new IllegalArgumentException("I000000138I000000138值"+aI000000138+"的长度"+aI000000138.length()+"大于最大值17");
		I000000138 = aI000000138;
	}
	public String getI000000139()
	{
		return I000000139;
	}
	public void setI000000139(String aI000000139)
	{
		if(aI000000139!=null && aI000000139.length()>17)
			throw new IllegalArgumentException("I000000139I000000139值"+aI000000139+"的长度"+aI000000139.length()+"大于最大值17");
		I000000139 = aI000000139;
	}
	public String getI000000140()
	{
		return I000000140;
	}
	public void setI000000140(String aI000000140)
	{
		if(aI000000140!=null && aI000000140.length()>17)
			throw new IllegalArgumentException("I000000140I000000140值"+aI000000140+"的长度"+aI000000140.length()+"大于最大值17");
		I000000140 = aI000000140;
	}
	public String getI000000141()
	{
		return I000000141;
	}
	public void setI000000141(String aI000000141)
	{
		if(aI000000141!=null && aI000000141.length()>17)
			throw new IllegalArgumentException("I000000141I000000141值"+aI000000141+"的长度"+aI000000141.length()+"大于最大值17");
		I000000141 = aI000000141;
	}
	public String getI000000142()
	{
		return I000000142;
	}
	public void setI000000142(String aI000000142)
	{
		if(aI000000142!=null && aI000000142.length()>17)
			throw new IllegalArgumentException("I000000142I000000142值"+aI000000142+"的长度"+aI000000142.length()+"大于最大值17");
		I000000142 = aI000000142;
	}
	public String getI000000143()
	{
		return I000000143;
	}
	public void setI000000143(String aI000000143)
	{
		if(aI000000143!=null && aI000000143.length()>17)
			throw new IllegalArgumentException("I000000143I000000143值"+aI000000143+"的长度"+aI000000143.length()+"大于最大值17");
		I000000143 = aI000000143;
	}
	public String getI000000144()
	{
		return I000000144;
	}
	public void setI000000144(String aI000000144)
	{
		if(aI000000144!=null && aI000000144.length()>17)
			throw new IllegalArgumentException("I000000144I000000144值"+aI000000144+"的长度"+aI000000144.length()+"大于最大值17");
		I000000144 = aI000000144;
	}
	public String getI000000145()
	{
		return I000000145;
	}
	public void setI000000145(String aI000000145)
	{
		if(aI000000145!=null && aI000000145.length()>17)
			throw new IllegalArgumentException("I000000145I000000145值"+aI000000145+"的长度"+aI000000145.length()+"大于最大值17");
		I000000145 = aI000000145;
	}
	public String getI000000146()
	{
		return I000000146;
	}
	public void setI000000146(String aI000000146)
	{
		if(aI000000146!=null && aI000000146.length()>17)
			throw new IllegalArgumentException("I000000146I000000146值"+aI000000146+"的长度"+aI000000146.length()+"大于最大值17");
		I000000146 = aI000000146;
	}
	public String getI000000147()
	{
		return I000000147;
	}
	public void setI000000147(String aI000000147)
	{
		if(aI000000147!=null && aI000000147.length()>17)
			throw new IllegalArgumentException("I000000147I000000147值"+aI000000147+"的长度"+aI000000147.length()+"大于最大值17");
		I000000147 = aI000000147;
	}
	public String getI000000148()
	{
		return I000000148;
	}
	public void setI000000148(String aI000000148)
	{
		if(aI000000148!=null && aI000000148.length()>17)
			throw new IllegalArgumentException("I000000148I000000148值"+aI000000148+"的长度"+aI000000148.length()+"大于最大值17");
		I000000148 = aI000000148;
	}
	public String getI000000149()
	{
		return I000000149;
	}
	public void setI000000149(String aI000000149)
	{
		if(aI000000149!=null && aI000000149.length()>17)
			throw new IllegalArgumentException("I000000149I000000149值"+aI000000149+"的长度"+aI000000149.length()+"大于最大值17");
		I000000149 = aI000000149;
	}
	public String getI000000150()
	{
		return I000000150;
	}
	public void setI000000150(String aI000000150)
	{
		if(aI000000150!=null && aI000000150.length()>17)
			throw new IllegalArgumentException("I000000150I000000150值"+aI000000150+"的长度"+aI000000150.length()+"大于最大值17");
		I000000150 = aI000000150;
	}
	public String getI000000151()
	{
		return I000000151;
	}
	public void setI000000151(String aI000000151)
	{
		if(aI000000151!=null && aI000000151.length()>17)
			throw new IllegalArgumentException("I000000151I000000151值"+aI000000151+"的长度"+aI000000151.length()+"大于最大值17");
		I000000151 = aI000000151;
	}
	public String getI000000152()
	{
		return I000000152;
	}
	public void setI000000152(String aI000000152)
	{
		if(aI000000152!=null && aI000000152.length()>17)
			throw new IllegalArgumentException("I000000152I000000152值"+aI000000152+"的长度"+aI000000152.length()+"大于最大值17");
		I000000152 = aI000000152;
	}
	public String getI000000153()
	{
		return I000000153;
	}
	public void setI000000153(String aI000000153)
	{
		if(aI000000153!=null && aI000000153.length()>17)
			throw new IllegalArgumentException("I000000153I000000153值"+aI000000153+"的长度"+aI000000153.length()+"大于最大值17");
		I000000153 = aI000000153;
	}
	public String getI000000154()
	{
		return I000000154;
	}
	public void setI000000154(String aI000000154)
	{
		if(aI000000154!=null && aI000000154.length()>17)
			throw new IllegalArgumentException("I000000154I000000154值"+aI000000154+"的长度"+aI000000154.length()+"大于最大值17");
		I000000154 = aI000000154;
	}
	public String getI000000155()
	{
		return I000000155;
	}
	public void setI000000155(String aI000000155)
	{
		if(aI000000155!=null && aI000000155.length()>17)
			throw new IllegalArgumentException("I000000155I000000155值"+aI000000155+"的长度"+aI000000155.length()+"大于最大值17");
		I000000155 = aI000000155;
	}
	public String getI000000156()
	{
		return I000000156;
	}
	public void setI000000156(String aI000000156)
	{
		if(aI000000156!=null && aI000000156.length()>17)
			throw new IllegalArgumentException("I000000156I000000156值"+aI000000156+"的长度"+aI000000156.length()+"大于最大值17");
		I000000156 = aI000000156;
	}
	public String getI000000157()
	{
		return I000000157;
	}
	public void setI000000157(String aI000000157)
	{
		if(aI000000157!=null && aI000000157.length()>17)
			throw new IllegalArgumentException("I000000157I000000157值"+aI000000157+"的长度"+aI000000157.length()+"大于最大值17");
		I000000157 = aI000000157;
	}
	public String getI000000158()
	{
		return I000000158;
	}
	public void setI000000158(String aI000000158)
	{
		if(aI000000158!=null && aI000000158.length()>17)
			throw new IllegalArgumentException("I000000158I000000158值"+aI000000158+"的长度"+aI000000158.length()+"大于最大值17");
		I000000158 = aI000000158;
	}
	public String getI000000159()
	{
		return I000000159;
	}
	public void setI000000159(String aI000000159)
	{
		if(aI000000159!=null && aI000000159.length()>17)
			throw new IllegalArgumentException("I000000159I000000159值"+aI000000159+"的长度"+aI000000159.length()+"大于最大值17");
		I000000159 = aI000000159;
	}
	public String getI000000160()
	{
		return I000000160;
	}
	public void setI000000160(String aI000000160)
	{
		if(aI000000160!=null && aI000000160.length()>17)
			throw new IllegalArgumentException("I000000160I000000160值"+aI000000160+"的长度"+aI000000160.length()+"大于最大值17");
		I000000160 = aI000000160;
	}
	public String getI000000161()
	{
		return I000000161;
	}
	public void setI000000161(String aI000000161)
	{
		if(aI000000161!=null && aI000000161.length()>17)
			throw new IllegalArgumentException("I000000161I000000161值"+aI000000161+"的长度"+aI000000161.length()+"大于最大值17");
		I000000161 = aI000000161;
	}
	public String getI000000162()
	{
		return I000000162;
	}
	public void setI000000162(String aI000000162)
	{
		if(aI000000162!=null && aI000000162.length()>17)
			throw new IllegalArgumentException("I000000162I000000162值"+aI000000162+"的长度"+aI000000162.length()+"大于最大值17");
		I000000162 = aI000000162;
	}
	public String getI000000163()
	{
		return I000000163;
	}
	public void setI000000163(String aI000000163)
	{
		if(aI000000163!=null && aI000000163.length()>17)
			throw new IllegalArgumentException("I000000163I000000163值"+aI000000163+"的长度"+aI000000163.length()+"大于最大值17");
		I000000163 = aI000000163;
	}
	public String getI000000164()
	{
		return I000000164;
	}
	public void setI000000164(String aI000000164)
	{
		if(aI000000164!=null && aI000000164.length()>17)
			throw new IllegalArgumentException("I000000164I000000164值"+aI000000164+"的长度"+aI000000164.length()+"大于最大值17");
		I000000164 = aI000000164;
	}
	public String getI000000165()
	{
		return I000000165;
	}
	public void setI000000165(String aI000000165)
	{
		if(aI000000165!=null && aI000000165.length()>17)
			throw new IllegalArgumentException("I000000165I000000165值"+aI000000165+"的长度"+aI000000165.length()+"大于最大值17");
		I000000165 = aI000000165;
	}
	public String getI000000166()
	{
		return I000000166;
	}
	public void setI000000166(String aI000000166)
	{
		if(aI000000166!=null && aI000000166.length()>17)
			throw new IllegalArgumentException("I000000166I000000166值"+aI000000166+"的长度"+aI000000166.length()+"大于最大值17");
		I000000166 = aI000000166;
	}
	public String getI000000167()
	{
		return I000000167;
	}
	public void setI000000167(String aI000000167)
	{
		if(aI000000167!=null && aI000000167.length()>17)
			throw new IllegalArgumentException("I000000167I000000167值"+aI000000167+"的长度"+aI000000167.length()+"大于最大值17");
		I000000167 = aI000000167;
	}
	public String getI000000168()
	{
		return I000000168;
	}
	public void setI000000168(String aI000000168)
	{
		if(aI000000168!=null && aI000000168.length()>17)
			throw new IllegalArgumentException("I000000168I000000168值"+aI000000168+"的长度"+aI000000168.length()+"大于最大值17");
		I000000168 = aI000000168;
	}
	public String getI000000169()
	{
		return I000000169;
	}
	public void setI000000169(String aI000000169)
	{
		if(aI000000169!=null && aI000000169.length()>17)
			throw new IllegalArgumentException("I000000169I000000169值"+aI000000169+"的长度"+aI000000169.length()+"大于最大值17");
		I000000169 = aI000000169;
	}
	public String getI000000170()
	{
		return I000000170;
	}
	public void setI000000170(String aI000000170)
	{
		if(aI000000170!=null && aI000000170.length()>17)
			throw new IllegalArgumentException("I000000170I000000170值"+aI000000170+"的长度"+aI000000170.length()+"大于最大值17");
		I000000170 = aI000000170;
	}
	public String getI000000171()
	{
		return I000000171;
	}
	public void setI000000171(String aI000000171)
	{
		if(aI000000171!=null && aI000000171.length()>17)
			throw new IllegalArgumentException("I000000171I000000171值"+aI000000171+"的长度"+aI000000171.length()+"大于最大值17");
		I000000171 = aI000000171;
	}
	public String getI000000172()
	{
		return I000000172;
	}
	public void setI000000172(String aI000000172)
	{
		if(aI000000172!=null && aI000000172.length()>17)
			throw new IllegalArgumentException("I000000172I000000172值"+aI000000172+"的长度"+aI000000172.length()+"大于最大值17");
		I000000172 = aI000000172;
	}
	public String getI000000173()
	{
		return I000000173;
	}
	public void setI000000173(String aI000000173)
	{
		if(aI000000173!=null && aI000000173.length()>17)
			throw new IllegalArgumentException("I000000173I000000173值"+aI000000173+"的长度"+aI000000173.length()+"大于最大值17");
		I000000173 = aI000000173;
	}
	public String getI000000174()
	{
		return I000000174;
	}
	public void setI000000174(String aI000000174)
	{
		if(aI000000174!=null && aI000000174.length()>17)
			throw new IllegalArgumentException("I000000174I000000174值"+aI000000174+"的长度"+aI000000174.length()+"大于最大值17");
		I000000174 = aI000000174;
	}
	public String getI000000175()
	{
		return I000000175;
	}
	public void setI000000175(String aI000000175)
	{
		if(aI000000175!=null && aI000000175.length()>17)
			throw new IllegalArgumentException("I000000175I000000175值"+aI000000175+"的长度"+aI000000175.length()+"大于最大值17");
		I000000175 = aI000000175;
	}
	public String getI000000176()
	{
		return I000000176;
	}
	public void setI000000176(String aI000000176)
	{
		if(aI000000176!=null && aI000000176.length()>17)
			throw new IllegalArgumentException("I000000176I000000176值"+aI000000176+"的长度"+aI000000176.length()+"大于最大值17");
		I000000176 = aI000000176;
	}
	public String getI000000177()
	{
		return I000000177;
	}
	public void setI000000177(String aI000000177)
	{
		if(aI000000177!=null && aI000000177.length()>17)
			throw new IllegalArgumentException("I000000177I000000177值"+aI000000177+"的长度"+aI000000177.length()+"大于最大值17");
		I000000177 = aI000000177;
	}
	public String getI000000178()
	{
		return I000000178;
	}
	public void setI000000178(String aI000000178)
	{
		if(aI000000178!=null && aI000000178.length()>17)
			throw new IllegalArgumentException("I000000178I000000178值"+aI000000178+"的长度"+aI000000178.length()+"大于最大值17");
		I000000178 = aI000000178;
	}
	public String getI000000179()
	{
		return I000000179;
	}
	public void setI000000179(String aI000000179)
	{
		if(aI000000179!=null && aI000000179.length()>17)
			throw new IllegalArgumentException("I000000179I000000179值"+aI000000179+"的长度"+aI000000179.length()+"大于最大值17");
		I000000179 = aI000000179;
	}
	public String getI000000180()
	{
		return I000000180;
	}
	public void setI000000180(String aI000000180)
	{
		if(aI000000180!=null && aI000000180.length()>17)
			throw new IllegalArgumentException("I000000180I000000180值"+aI000000180+"的长度"+aI000000180.length()+"大于最大值17");
		I000000180 = aI000000180;
	}
	public String getI000000181()
	{
		return I000000181;
	}
	public void setI000000181(String aI000000181)
	{
		if(aI000000181!=null && aI000000181.length()>17)
			throw new IllegalArgumentException("I000000181I000000181值"+aI000000181+"的长度"+aI000000181.length()+"大于最大值17");
		I000000181 = aI000000181;
	}
	public String getI000000182()
	{
		return I000000182;
	}
	public void setI000000182(String aI000000182)
	{
		if(aI000000182!=null && aI000000182.length()>17)
			throw new IllegalArgumentException("I000000182I000000182值"+aI000000182+"的长度"+aI000000182.length()+"大于最大值17");
		I000000182 = aI000000182;
	}
	public String getI000000183()
	{
		return I000000183;
	}
	public void setI000000183(String aI000000183)
	{
		if(aI000000183!=null && aI000000183.length()>17)
			throw new IllegalArgumentException("I000000183I000000183值"+aI000000183+"的长度"+aI000000183.length()+"大于最大值17");
		I000000183 = aI000000183;
	}
	public String getI000000184()
	{
		return I000000184;
	}
	public void setI000000184(String aI000000184)
	{
		if(aI000000184!=null && aI000000184.length()>17)
			throw new IllegalArgumentException("I000000184I000000184值"+aI000000184+"的长度"+aI000000184.length()+"大于最大值17");
		I000000184 = aI000000184;
	}
	public String getI000000185()
	{
		return I000000185;
	}
	public void setI000000185(String aI000000185)
	{
		if(aI000000185!=null && aI000000185.length()>17)
			throw new IllegalArgumentException("I000000185I000000185值"+aI000000185+"的长度"+aI000000185.length()+"大于最大值17");
		I000000185 = aI000000185;
	}
	public String getI000000186()
	{
		return I000000186;
	}
	public void setI000000186(String aI000000186)
	{
		if(aI000000186!=null && aI000000186.length()>17)
			throw new IllegalArgumentException("I000000186I000000186值"+aI000000186+"的长度"+aI000000186.length()+"大于最大值17");
		I000000186 = aI000000186;
	}
	public String getI000000187()
	{
		return I000000187;
	}
	public void setI000000187(String aI000000187)
	{
		if(aI000000187!=null && aI000000187.length()>17)
			throw new IllegalArgumentException("I000000187I000000187值"+aI000000187+"的长度"+aI000000187.length()+"大于最大值17");
		I000000187 = aI000000187;
	}
	public String getI000000188()
	{
		return I000000188;
	}
	public void setI000000188(String aI000000188)
	{
		if(aI000000188!=null && aI000000188.length()>17)
			throw new IllegalArgumentException("I000000188I000000188值"+aI000000188+"的长度"+aI000000188.length()+"大于最大值17");
		I000000188 = aI000000188;
	}
	public String getI000000189()
	{
		return I000000189;
	}
	public void setI000000189(String aI000000189)
	{
		if(aI000000189!=null && aI000000189.length()>17)
			throw new IllegalArgumentException("I000000189I000000189值"+aI000000189+"的长度"+aI000000189.length()+"大于最大值17");
		I000000189 = aI000000189;
	}
	public String getI000000190()
	{
		return I000000190;
	}
	public void setI000000190(String aI000000190)
	{
		if(aI000000190!=null && aI000000190.length()>17)
			throw new IllegalArgumentException("I000000190I000000190值"+aI000000190+"的长度"+aI000000190.length()+"大于最大值17");
		I000000190 = aI000000190;
	}
	public String getI000000191()
	{
		return I000000191;
	}
	public void setI000000191(String aI000000191)
	{
		if(aI000000191!=null && aI000000191.length()>17)
			throw new IllegalArgumentException("I000000191I000000191值"+aI000000191+"的长度"+aI000000191.length()+"大于最大值17");
		I000000191 = aI000000191;
	}
	public String getI000000192()
	{
		return I000000192;
	}
	public void setI000000192(String aI000000192)
	{
		if(aI000000192!=null && aI000000192.length()>17)
			throw new IllegalArgumentException("I000000192I000000192值"+aI000000192+"的长度"+aI000000192.length()+"大于最大值17");
		I000000192 = aI000000192;
	}
	public String getI000000193()
	{
		return I000000193;
	}
	public void setI000000193(String aI000000193)
	{
		if(aI000000193!=null && aI000000193.length()>17)
			throw new IllegalArgumentException("I000000193I000000193值"+aI000000193+"的长度"+aI000000193.length()+"大于最大值17");
		I000000193 = aI000000193;
	}
	public String getI000000194()
	{
		return I000000194;
	}
	public void setI000000194(String aI000000194)
	{
		if(aI000000194!=null && aI000000194.length()>17)
			throw new IllegalArgumentException("I000000194I000000194值"+aI000000194+"的长度"+aI000000194.length()+"大于最大值17");
		I000000194 = aI000000194;
	}
	public String getI000000195()
	{
		return I000000195;
	}
	public void setI000000195(String aI000000195)
	{
		if(aI000000195!=null && aI000000195.length()>17)
			throw new IllegalArgumentException("I000000195I000000195值"+aI000000195+"的长度"+aI000000195.length()+"大于最大值17");
		I000000195 = aI000000195;
	}
	public String getI000000196()
	{
		return I000000196;
	}
	public void setI000000196(String aI000000196)
	{
		if(aI000000196!=null && aI000000196.length()>17)
			throw new IllegalArgumentException("I000000196I000000196值"+aI000000196+"的长度"+aI000000196.length()+"大于最大值17");
		I000000196 = aI000000196;
	}
	public String getI000000197()
	{
		return I000000197;
	}
	public void setI000000197(String aI000000197)
	{
		if(aI000000197!=null && aI000000197.length()>17)
			throw new IllegalArgumentException("I000000197I000000197值"+aI000000197+"的长度"+aI000000197.length()+"大于最大值17");
		I000000197 = aI000000197;
	}
	public String getI000000198()
	{
		return I000000198;
	}
	public void setI000000198(String aI000000198)
	{
		if(aI000000198!=null && aI000000198.length()>17)
			throw new IllegalArgumentException("I000000198I000000198值"+aI000000198+"的长度"+aI000000198.length()+"大于最大值17");
		I000000198 = aI000000198;
	}
	public String getI000000199()
	{
		return I000000199;
	}
	public void setI000000199(String aI000000199)
	{
		if(aI000000199!=null && aI000000199.length()>17)
			throw new IllegalArgumentException("I000000199I000000199值"+aI000000199+"的长度"+aI000000199.length()+"大于最大值17");
		I000000199 = aI000000199;
	}
	public String getI000000200()
	{
		return I000000200;
	}
	public void setI000000200(String aI000000200)
	{
		if(aI000000200!=null && aI000000200.length()>17)
			throw new IllegalArgumentException("I000000200I000000200值"+aI000000200+"的长度"+aI000000200.length()+"大于最大值17");
		I000000200 = aI000000200;
	}
	public String getR000000001()
	{
		return R000000001;
	}
	public void setR000000001(String aR000000001)
	{
		if(aR000000001!=null && aR000000001.length()>17)
			throw new IllegalArgumentException("R000000001R000000001值"+aR000000001+"的长度"+aR000000001.length()+"大于最大值17");
		R000000001 = aR000000001;
	}
	public String getR000000002()
	{
		return R000000002;
	}
	public void setR000000002(String aR000000002)
	{
		if(aR000000002!=null && aR000000002.length()>17)
			throw new IllegalArgumentException("R000000002R000000002值"+aR000000002+"的长度"+aR000000002.length()+"大于最大值17");
		R000000002 = aR000000002;
	}
	public String getR000000003()
	{
		return R000000003;
	}
	public void setR000000003(String aR000000003)
	{
		if(aR000000003!=null && aR000000003.length()>17)
			throw new IllegalArgumentException("R000000003R000000003值"+aR000000003+"的长度"+aR000000003.length()+"大于最大值17");
		R000000003 = aR000000003;
	}
	public String getR000000004()
	{
		return R000000004;
	}
	public void setR000000004(String aR000000004)
	{
		if(aR000000004!=null && aR000000004.length()>17)
			throw new IllegalArgumentException("R000000004R000000004值"+aR000000004+"的长度"+aR000000004.length()+"大于最大值17");
		R000000004 = aR000000004;
	}
	public String getR000000005()
	{
		return R000000005;
	}
	public void setR000000005(String aR000000005)
	{
		if(aR000000005!=null && aR000000005.length()>17)
			throw new IllegalArgumentException("R000000005R000000005值"+aR000000005+"的长度"+aR000000005.length()+"大于最大值17");
		R000000005 = aR000000005;
	}
	public String getR000000006()
	{
		return R000000006;
	}
	public void setR000000006(String aR000000006)
	{
		if(aR000000006!=null && aR000000006.length()>17)
			throw new IllegalArgumentException("R000000006R000000006值"+aR000000006+"的长度"+aR000000006.length()+"大于最大值17");
		R000000006 = aR000000006;
	}
	public String getR000000007()
	{
		return R000000007;
	}
	public void setR000000007(String aR000000007)
	{
		if(aR000000007!=null && aR000000007.length()>17)
			throw new IllegalArgumentException("R000000007R000000007值"+aR000000007+"的长度"+aR000000007.length()+"大于最大值17");
		R000000007 = aR000000007;
	}
	public String getR000000008()
	{
		return R000000008;
	}
	public void setR000000008(String aR000000008)
	{
		if(aR000000008!=null && aR000000008.length()>17)
			throw new IllegalArgumentException("R000000008R000000008值"+aR000000008+"的长度"+aR000000008.length()+"大于最大值17");
		R000000008 = aR000000008;
	}
	public String getR000000009()
	{
		return R000000009;
	}
	public void setR000000009(String aR000000009)
	{
		if(aR000000009!=null && aR000000009.length()>17)
			throw new IllegalArgumentException("R000000009R000000009值"+aR000000009+"的长度"+aR000000009.length()+"大于最大值17");
		R000000009 = aR000000009;
	}
	public String getR000000010()
	{
		return R000000010;
	}
	public void setR000000010(String aR000000010)
	{
		if(aR000000010!=null && aR000000010.length()>17)
			throw new IllegalArgumentException("R000000010R000000010值"+aR000000010+"的长度"+aR000000010.length()+"大于最大值17");
		R000000010 = aR000000010;
	}
	public String getR000000011()
	{
		return R000000011;
	}
	public void setR000000011(String aR000000011)
	{
		if(aR000000011!=null && aR000000011.length()>17)
			throw new IllegalArgumentException("R000000011R000000011值"+aR000000011+"的长度"+aR000000011.length()+"大于最大值17");
		R000000011 = aR000000011;
	}
	public String getR000000012()
	{
		return R000000012;
	}
	public void setR000000012(String aR000000012)
	{
		if(aR000000012!=null && aR000000012.length()>17)
			throw new IllegalArgumentException("R000000012R000000012值"+aR000000012+"的长度"+aR000000012.length()+"大于最大值17");
		R000000012 = aR000000012;
	}
	public String getR000000013()
	{
		return R000000013;
	}
	public void setR000000013(String aR000000013)
	{
		if(aR000000013!=null && aR000000013.length()>17)
			throw new IllegalArgumentException("R000000013R000000013值"+aR000000013+"的长度"+aR000000013.length()+"大于最大值17");
		R000000013 = aR000000013;
	}
	public String getR000000014()
	{
		return R000000014;
	}
	public void setR000000014(String aR000000014)
	{
		if(aR000000014!=null && aR000000014.length()>17)
			throw new IllegalArgumentException("R000000014R000000014值"+aR000000014+"的长度"+aR000000014.length()+"大于最大值17");
		R000000014 = aR000000014;
	}
	public String getR000000015()
	{
		return R000000015;
	}
	public void setR000000015(String aR000000015)
	{
		if(aR000000015!=null && aR000000015.length()>17)
			throw new IllegalArgumentException("R000000015R000000015值"+aR000000015+"的长度"+aR000000015.length()+"大于最大值17");
		R000000015 = aR000000015;
	}
	public String getR000000016()
	{
		return R000000016;
	}
	public void setR000000016(String aR000000016)
	{
		if(aR000000016!=null && aR000000016.length()>17)
			throw new IllegalArgumentException("R000000016R000000016值"+aR000000016+"的长度"+aR000000016.length()+"大于最大值17");
		R000000016 = aR000000016;
	}
	public String getR000000017()
	{
		return R000000017;
	}
	public void setR000000017(String aR000000017)
	{
		if(aR000000017!=null && aR000000017.length()>17)
			throw new IllegalArgumentException("R000000017R000000017值"+aR000000017+"的长度"+aR000000017.length()+"大于最大值17");
		R000000017 = aR000000017;
	}
	public String getR000000018()
	{
		return R000000018;
	}
	public void setR000000018(String aR000000018)
	{
		if(aR000000018!=null && aR000000018.length()>17)
			throw new IllegalArgumentException("R000000018R000000018值"+aR000000018+"的长度"+aR000000018.length()+"大于最大值17");
		R000000018 = aR000000018;
	}
	public String getR000000019()
	{
		return R000000019;
	}
	public void setR000000019(String aR000000019)
	{
		if(aR000000019!=null && aR000000019.length()>17)
			throw new IllegalArgumentException("R000000019R000000019值"+aR000000019+"的长度"+aR000000019.length()+"大于最大值17");
		R000000019 = aR000000019;
	}
	public String getR000000020()
	{
		return R000000020;
	}
	public void setR000000020(String aR000000020)
	{
		if(aR000000020!=null && aR000000020.length()>17)
			throw new IllegalArgumentException("R000000020R000000020值"+aR000000020+"的长度"+aR000000020.length()+"大于最大值17");
		R000000020 = aR000000020;
	}
	public String getR000000021()
	{
		return R000000021;
	}
	public void setR000000021(String aR000000021)
	{
		if(aR000000021!=null && aR000000021.length()>17)
			throw new IllegalArgumentException("R000000021R000000021值"+aR000000021+"的长度"+aR000000021.length()+"大于最大值17");
		R000000021 = aR000000021;
	}
	public String getR000000022()
	{
		return R000000022;
	}
	public void setR000000022(String aR000000022)
	{
		if(aR000000022!=null && aR000000022.length()>17)
			throw new IllegalArgumentException("R000000022R000000022值"+aR000000022+"的长度"+aR000000022.length()+"大于最大值17");
		R000000022 = aR000000022;
	}
	public String getR000000023()
	{
		return R000000023;
	}
	public void setR000000023(String aR000000023)
	{
		if(aR000000023!=null && aR000000023.length()>17)
			throw new IllegalArgumentException("R000000023R000000023值"+aR000000023+"的长度"+aR000000023.length()+"大于最大值17");
		R000000023 = aR000000023;
	}
	public String getR000000024()
	{
		return R000000024;
	}
	public void setR000000024(String aR000000024)
	{
		if(aR000000024!=null && aR000000024.length()>17)
			throw new IllegalArgumentException("R000000024R000000024值"+aR000000024+"的长度"+aR000000024.length()+"大于最大值17");
		R000000024 = aR000000024;
	}
	public String getR000000025()
	{
		return R000000025;
	}
	public void setR000000025(String aR000000025)
	{
		if(aR000000025!=null && aR000000025.length()>17)
			throw new IllegalArgumentException("R000000025R000000025值"+aR000000025+"的长度"+aR000000025.length()+"大于最大值17");
		R000000025 = aR000000025;
	}
	public String getR000000026()
	{
		return R000000026;
	}
	public void setR000000026(String aR000000026)
	{
		if(aR000000026!=null && aR000000026.length()>17)
			throw new IllegalArgumentException("R000000026R000000026值"+aR000000026+"的长度"+aR000000026.length()+"大于最大值17");
		R000000026 = aR000000026;
	}
	public String getR000000027()
	{
		return R000000027;
	}
	public void setR000000027(String aR000000027)
	{
		if(aR000000027!=null && aR000000027.length()>17)
			throw new IllegalArgumentException("R000000027R000000027值"+aR000000027+"的长度"+aR000000027.length()+"大于最大值17");
		R000000027 = aR000000027;
	}
	public String getR000000028()
	{
		return R000000028;
	}
	public void setR000000028(String aR000000028)
	{
		if(aR000000028!=null && aR000000028.length()>17)
			throw new IllegalArgumentException("R000000028R000000028值"+aR000000028+"的长度"+aR000000028.length()+"大于最大值17");
		R000000028 = aR000000028;
	}
	public String getR000000029()
	{
		return R000000029;
	}
	public void setR000000029(String aR000000029)
	{
		if(aR000000029!=null && aR000000029.length()>17)
			throw new IllegalArgumentException("R000000029R000000029值"+aR000000029+"的长度"+aR000000029.length()+"大于最大值17");
		R000000029 = aR000000029;
	}
	public String getR000000030()
	{
		return R000000030;
	}
	public void setR000000030(String aR000000030)
	{
		if(aR000000030!=null && aR000000030.length()>17)
			throw new IllegalArgumentException("R000000030R000000030值"+aR000000030+"的长度"+aR000000030.length()+"大于最大值17");
		R000000030 = aR000000030;
	}
	public String getR000000031()
	{
		return R000000031;
	}
	public void setR000000031(String aR000000031)
	{
		if(aR000000031!=null && aR000000031.length()>17)
			throw new IllegalArgumentException("R000000031R000000031值"+aR000000031+"的长度"+aR000000031.length()+"大于最大值17");
		R000000031 = aR000000031;
	}
	public String getR000000032()
	{
		return R000000032;
	}
	public void setR000000032(String aR000000032)
	{
		if(aR000000032!=null && aR000000032.length()>17)
			throw new IllegalArgumentException("R000000032R000000032值"+aR000000032+"的长度"+aR000000032.length()+"大于最大值17");
		R000000032 = aR000000032;
	}
	public String getR000000033()
	{
		return R000000033;
	}
	public void setR000000033(String aR000000033)
	{
		if(aR000000033!=null && aR000000033.length()>17)
			throw new IllegalArgumentException("R000000033R000000033值"+aR000000033+"的长度"+aR000000033.length()+"大于最大值17");
		R000000033 = aR000000033;
	}
	public String getR000000034()
	{
		return R000000034;
	}
	public void setR000000034(String aR000000034)
	{
		if(aR000000034!=null && aR000000034.length()>17)
			throw new IllegalArgumentException("R000000034R000000034值"+aR000000034+"的长度"+aR000000034.length()+"大于最大值17");
		R000000034 = aR000000034;
	}
	public String getR000000035()
	{
		return R000000035;
	}
	public void setR000000035(String aR000000035)
	{
		if(aR000000035!=null && aR000000035.length()>17)
			throw new IllegalArgumentException("R000000035R000000035值"+aR000000035+"的长度"+aR000000035.length()+"大于最大值17");
		R000000035 = aR000000035;
	}
	public String getR000000036()
	{
		return R000000036;
	}
	public void setR000000036(String aR000000036)
	{
		if(aR000000036!=null && aR000000036.length()>17)
			throw new IllegalArgumentException("R000000036R000000036值"+aR000000036+"的长度"+aR000000036.length()+"大于最大值17");
		R000000036 = aR000000036;
	}
	public String getR000000037()
	{
		return R000000037;
	}
	public void setR000000037(String aR000000037)
	{
		if(aR000000037!=null && aR000000037.length()>17)
			throw new IllegalArgumentException("R000000037R000000037值"+aR000000037+"的长度"+aR000000037.length()+"大于最大值17");
		R000000037 = aR000000037;
	}
	public String getR000000038()
	{
		return R000000038;
	}
	public void setR000000038(String aR000000038)
	{
		if(aR000000038!=null && aR000000038.length()>17)
			throw new IllegalArgumentException("R000000038R000000038值"+aR000000038+"的长度"+aR000000038.length()+"大于最大值17");
		R000000038 = aR000000038;
	}
	public String getR000000039()
	{
		return R000000039;
	}
	public void setR000000039(String aR000000039)
	{
		if(aR000000039!=null && aR000000039.length()>17)
			throw new IllegalArgumentException("R000000039R000000039值"+aR000000039+"的长度"+aR000000039.length()+"大于最大值17");
		R000000039 = aR000000039;
	}
	public String getR000000040()
	{
		return R000000040;
	}
	public void setR000000040(String aR000000040)
	{
		if(aR000000040!=null && aR000000040.length()>17)
			throw new IllegalArgumentException("R000000040R000000040值"+aR000000040+"的长度"+aR000000040.length()+"大于最大值17");
		R000000040 = aR000000040;
	}
	public String getR000000041()
	{
		return R000000041;
	}
	public void setR000000041(String aR000000041)
	{
		if(aR000000041!=null && aR000000041.length()>17)
			throw new IllegalArgumentException("R000000041R000000041值"+aR000000041+"的长度"+aR000000041.length()+"大于最大值17");
		R000000041 = aR000000041;
	}
	public String getR000000042()
	{
		return R000000042;
	}
	public void setR000000042(String aR000000042)
	{
		if(aR000000042!=null && aR000000042.length()>17)
			throw new IllegalArgumentException("R000000042R000000042值"+aR000000042+"的长度"+aR000000042.length()+"大于最大值17");
		R000000042 = aR000000042;
	}
	public String getR000000043()
	{
		return R000000043;
	}
	public void setR000000043(String aR000000043)
	{
		if(aR000000043!=null && aR000000043.length()>17)
			throw new IllegalArgumentException("R000000043R000000043值"+aR000000043+"的长度"+aR000000043.length()+"大于最大值17");
		R000000043 = aR000000043;
	}
	public String getR000000044()
	{
		return R000000044;
	}
	public void setR000000044(String aR000000044)
	{
		if(aR000000044!=null && aR000000044.length()>17)
			throw new IllegalArgumentException("R000000044R000000044值"+aR000000044+"的长度"+aR000000044.length()+"大于最大值17");
		R000000044 = aR000000044;
	}
	public String getR000000045()
	{
		return R000000045;
	}
	public void setR000000045(String aR000000045)
	{
		if(aR000000045!=null && aR000000045.length()>17)
			throw new IllegalArgumentException("R000000045R000000045值"+aR000000045+"的长度"+aR000000045.length()+"大于最大值17");
		R000000045 = aR000000045;
	}
	public String getR000000046()
	{
		return R000000046;
	}
	public void setR000000046(String aR000000046)
	{
		if(aR000000046!=null && aR000000046.length()>17)
			throw new IllegalArgumentException("R000000046R000000046值"+aR000000046+"的长度"+aR000000046.length()+"大于最大值17");
		R000000046 = aR000000046;
	}
	public String getR000000047()
	{
		return R000000047;
	}
	public void setR000000047(String aR000000047)
	{
		if(aR000000047!=null && aR000000047.length()>17)
			throw new IllegalArgumentException("R000000047R000000047值"+aR000000047+"的长度"+aR000000047.length()+"大于最大值17");
		R000000047 = aR000000047;
	}
	public String getR000000048()
	{
		return R000000048;
	}
	public void setR000000048(String aR000000048)
	{
		if(aR000000048!=null && aR000000048.length()>17)
			throw new IllegalArgumentException("R000000048R000000048值"+aR000000048+"的长度"+aR000000048.length()+"大于最大值17");
		R000000048 = aR000000048;
	}
	public String getR000000049()
	{
		return R000000049;
	}
	public void setR000000049(String aR000000049)
	{
		if(aR000000049!=null && aR000000049.length()>17)
			throw new IllegalArgumentException("R000000049R000000049值"+aR000000049+"的长度"+aR000000049.length()+"大于最大值17");
		R000000049 = aR000000049;
	}
	public String getR000000050()
	{
		return R000000050;
	}
	public void setR000000050(String aR000000050)
	{
		if(aR000000050!=null && aR000000050.length()>17)
			throw new IllegalArgumentException("R000000050R000000050值"+aR000000050+"的长度"+aR000000050.length()+"大于最大值17");
		R000000050 = aR000000050;
	}
	public String getR000000051()
	{
		return R000000051;
	}
	public void setR000000051(String aR000000051)
	{
		if(aR000000051!=null && aR000000051.length()>17)
			throw new IllegalArgumentException("R000000051R000000051值"+aR000000051+"的长度"+aR000000051.length()+"大于最大值17");
		R000000051 = aR000000051;
	}
	public String getR000000052()
	{
		return R000000052;
	}
	public void setR000000052(String aR000000052)
	{
		if(aR000000052!=null && aR000000052.length()>17)
			throw new IllegalArgumentException("R000000052R000000052值"+aR000000052+"的长度"+aR000000052.length()+"大于最大值17");
		R000000052 = aR000000052;
	}
	public String getR000000053()
	{
		return R000000053;
	}
	public void setR000000053(String aR000000053)
	{
		if(aR000000053!=null && aR000000053.length()>17)
			throw new IllegalArgumentException("R000000053R000000053值"+aR000000053+"的长度"+aR000000053.length()+"大于最大值17");
		R000000053 = aR000000053;
	}
	public String getR000000054()
	{
		return R000000054;
	}
	public void setR000000054(String aR000000054)
	{
		if(aR000000054!=null && aR000000054.length()>17)
			throw new IllegalArgumentException("R000000054R000000054值"+aR000000054+"的长度"+aR000000054.length()+"大于最大值17");
		R000000054 = aR000000054;
	}
	public String getR000000055()
	{
		return R000000055;
	}
	public void setR000000055(String aR000000055)
	{
		if(aR000000055!=null && aR000000055.length()>17)
			throw new IllegalArgumentException("R000000055R000000055值"+aR000000055+"的长度"+aR000000055.length()+"大于最大值17");
		R000000055 = aR000000055;
	}
	public String getR000000056()
	{
		return R000000056;
	}
	public void setR000000056(String aR000000056)
	{
		if(aR000000056!=null && aR000000056.length()>17)
			throw new IllegalArgumentException("R000000056R000000056值"+aR000000056+"的长度"+aR000000056.length()+"大于最大值17");
		R000000056 = aR000000056;
	}
	public String getR000000057()
	{
		return R000000057;
	}
	public void setR000000057(String aR000000057)
	{
		if(aR000000057!=null && aR000000057.length()>17)
			throw new IllegalArgumentException("R000000057R000000057值"+aR000000057+"的长度"+aR000000057.length()+"大于最大值17");
		R000000057 = aR000000057;
	}
	public String getR000000058()
	{
		return R000000058;
	}
	public void setR000000058(String aR000000058)
	{
		if(aR000000058!=null && aR000000058.length()>17)
			throw new IllegalArgumentException("R000000058R000000058值"+aR000000058+"的长度"+aR000000058.length()+"大于最大值17");
		R000000058 = aR000000058;
	}
	public String getR000000059()
	{
		return R000000059;
	}
	public void setR000000059(String aR000000059)
	{
		if(aR000000059!=null && aR000000059.length()>17)
			throw new IllegalArgumentException("R000000059R000000059值"+aR000000059+"的长度"+aR000000059.length()+"大于最大值17");
		R000000059 = aR000000059;
	}
	public String getR000000060()
	{
		return R000000060;
	}
	public void setR000000060(String aR000000060)
	{
		if(aR000000060!=null && aR000000060.length()>17)
			throw new IllegalArgumentException("R000000060R000000060值"+aR000000060+"的长度"+aR000000060.length()+"大于最大值17");
		R000000060 = aR000000060;
	}
	public String getR000000061()
	{
		return R000000061;
	}
	public void setR000000061(String aR000000061)
	{
		if(aR000000061!=null && aR000000061.length()>17)
			throw new IllegalArgumentException("R000000061R000000061值"+aR000000061+"的长度"+aR000000061.length()+"大于最大值17");
		R000000061 = aR000000061;
	}
	public String getR000000062()
	{
		return R000000062;
	}
	public void setR000000062(String aR000000062)
	{
		if(aR000000062!=null && aR000000062.length()>17)
			throw new IllegalArgumentException("R000000062R000000062值"+aR000000062+"的长度"+aR000000062.length()+"大于最大值17");
		R000000062 = aR000000062;
	}
	public String getR000000063()
	{
		return R000000063;
	}
	public void setR000000063(String aR000000063)
	{
		if(aR000000063!=null && aR000000063.length()>17)
			throw new IllegalArgumentException("R000000063R000000063值"+aR000000063+"的长度"+aR000000063.length()+"大于最大值17");
		R000000063 = aR000000063;
	}
	public String getR000000064()
	{
		return R000000064;
	}
	public void setR000000064(String aR000000064)
	{
		if(aR000000064!=null && aR000000064.length()>17)
			throw new IllegalArgumentException("R000000064R000000064值"+aR000000064+"的长度"+aR000000064.length()+"大于最大值17");
		R000000064 = aR000000064;
	}
	public String getR000000065()
	{
		return R000000065;
	}
	public void setR000000065(String aR000000065)
	{
		if(aR000000065!=null && aR000000065.length()>17)
			throw new IllegalArgumentException("R000000065R000000065值"+aR000000065+"的长度"+aR000000065.length()+"大于最大值17");
		R000000065 = aR000000065;
	}
	public String getR000000066()
	{
		return R000000066;
	}
	public void setR000000066(String aR000000066)
	{
		if(aR000000066!=null && aR000000066.length()>17)
			throw new IllegalArgumentException("R000000066R000000066值"+aR000000066+"的长度"+aR000000066.length()+"大于最大值17");
		R000000066 = aR000000066;
	}
	public String getR000000067()
	{
		return R000000067;
	}
	public void setR000000067(String aR000000067)
	{
		if(aR000000067!=null && aR000000067.length()>17)
			throw new IllegalArgumentException("R000000067R000000067值"+aR000000067+"的长度"+aR000000067.length()+"大于最大值17");
		R000000067 = aR000000067;
	}
	public String getR000000068()
	{
		return R000000068;
	}
	public void setR000000068(String aR000000068)
	{
		if(aR000000068!=null && aR000000068.length()>17)
			throw new IllegalArgumentException("R000000068R000000068值"+aR000000068+"的长度"+aR000000068.length()+"大于最大值17");
		R000000068 = aR000000068;
	}
	public String getR000000069()
	{
		return R000000069;
	}
	public void setR000000069(String aR000000069)
	{
		if(aR000000069!=null && aR000000069.length()>17)
			throw new IllegalArgumentException("R000000069R000000069值"+aR000000069+"的长度"+aR000000069.length()+"大于最大值17");
		R000000069 = aR000000069;
	}
	public String getR000000070()
	{
		return R000000070;
	}
	public void setR000000070(String aR000000070)
	{
		if(aR000000070!=null && aR000000070.length()>17)
			throw new IllegalArgumentException("R000000070R000000070值"+aR000000070+"的长度"+aR000000070.length()+"大于最大值17");
		R000000070 = aR000000070;
	}
	public String getR000000071()
	{
		return R000000071;
	}
	public void setR000000071(String aR000000071)
	{
		if(aR000000071!=null && aR000000071.length()>17)
			throw new IllegalArgumentException("R000000071R000000071值"+aR000000071+"的长度"+aR000000071.length()+"大于最大值17");
		R000000071 = aR000000071;
	}
	public String getR000000072()
	{
		return R000000072;
	}
	public void setR000000072(String aR000000072)
	{
		if(aR000000072!=null && aR000000072.length()>17)
			throw new IllegalArgumentException("R000000072R000000072值"+aR000000072+"的长度"+aR000000072.length()+"大于最大值17");
		R000000072 = aR000000072;
	}
	public String getR000000073()
	{
		return R000000073;
	}
	public void setR000000073(String aR000000073)
	{
		if(aR000000073!=null && aR000000073.length()>17)
			throw new IllegalArgumentException("R000000073R000000073值"+aR000000073+"的长度"+aR000000073.length()+"大于最大值17");
		R000000073 = aR000000073;
	}
	public String getR000000074()
	{
		return R000000074;
	}
	public void setR000000074(String aR000000074)
	{
		if(aR000000074!=null && aR000000074.length()>17)
			throw new IllegalArgumentException("R000000074R000000074值"+aR000000074+"的长度"+aR000000074.length()+"大于最大值17");
		R000000074 = aR000000074;
	}
	public String getR000000075()
	{
		return R000000075;
	}
	public void setR000000075(String aR000000075)
	{
		if(aR000000075!=null && aR000000075.length()>17)
			throw new IllegalArgumentException("R000000075R000000075值"+aR000000075+"的长度"+aR000000075.length()+"大于最大值17");
		R000000075 = aR000000075;
	}
	public String getR000000076()
	{
		return R000000076;
	}
	public void setR000000076(String aR000000076)
	{
		if(aR000000076!=null && aR000000076.length()>17)
			throw new IllegalArgumentException("R000000076R000000076值"+aR000000076+"的长度"+aR000000076.length()+"大于最大值17");
		R000000076 = aR000000076;
	}
	public String getR000000077()
	{
		return R000000077;
	}
	public void setR000000077(String aR000000077)
	{
		if(aR000000077!=null && aR000000077.length()>17)
			throw new IllegalArgumentException("R000000077R000000077值"+aR000000077+"的长度"+aR000000077.length()+"大于最大值17");
		R000000077 = aR000000077;
	}
	public String getR000000078()
	{
		return R000000078;
	}
	public void setR000000078(String aR000000078)
	{
		if(aR000000078!=null && aR000000078.length()>17)
			throw new IllegalArgumentException("R000000078R000000078值"+aR000000078+"的长度"+aR000000078.length()+"大于最大值17");
		R000000078 = aR000000078;
	}
	public String getR000000079()
	{
		return R000000079;
	}
	public void setR000000079(String aR000000079)
	{
		if(aR000000079!=null && aR000000079.length()>17)
			throw new IllegalArgumentException("R000000079R000000079值"+aR000000079+"的长度"+aR000000079.length()+"大于最大值17");
		R000000079 = aR000000079;
	}
	public String getR000000080()
	{
		return R000000080;
	}
	public void setR000000080(String aR000000080)
	{
		if(aR000000080!=null && aR000000080.length()>17)
			throw new IllegalArgumentException("R000000080R000000080值"+aR000000080+"的长度"+aR000000080.length()+"大于最大值17");
		R000000080 = aR000000080;
	}
	public String getR000000081()
	{
		return R000000081;
	}
	public void setR000000081(String aR000000081)
	{
		if(aR000000081!=null && aR000000081.length()>17)
			throw new IllegalArgumentException("R000000081R000000081值"+aR000000081+"的长度"+aR000000081.length()+"大于最大值17");
		R000000081 = aR000000081;
	}
	public String getR000000082()
	{
		return R000000082;
	}
	public void setR000000082(String aR000000082)
	{
		if(aR000000082!=null && aR000000082.length()>17)
			throw new IllegalArgumentException("R000000082R000000082值"+aR000000082+"的长度"+aR000000082.length()+"大于最大值17");
		R000000082 = aR000000082;
	}
	public String getR000000083()
	{
		return R000000083;
	}
	public void setR000000083(String aR000000083)
	{
		if(aR000000083!=null && aR000000083.length()>17)
			throw new IllegalArgumentException("R000000083R000000083值"+aR000000083+"的长度"+aR000000083.length()+"大于最大值17");
		R000000083 = aR000000083;
	}
	public String getR000000084()
	{
		return R000000084;
	}
	public void setR000000084(String aR000000084)
	{
		if(aR000000084!=null && aR000000084.length()>17)
			throw new IllegalArgumentException("R000000084R000000084值"+aR000000084+"的长度"+aR000000084.length()+"大于最大值17");
		R000000084 = aR000000084;
	}
	public String getR000000085()
	{
		return R000000085;
	}
	public void setR000000085(String aR000000085)
	{
		if(aR000000085!=null && aR000000085.length()>17)
			throw new IllegalArgumentException("R000000085R000000085值"+aR000000085+"的长度"+aR000000085.length()+"大于最大值17");
		R000000085 = aR000000085;
	}
	public String getR000000086()
	{
		return R000000086;
	}
	public void setR000000086(String aR000000086)
	{
		if(aR000000086!=null && aR000000086.length()>17)
			throw new IllegalArgumentException("R000000086R000000086值"+aR000000086+"的长度"+aR000000086.length()+"大于最大值17");
		R000000086 = aR000000086;
	}
	public String getR000000087()
	{
		return R000000087;
	}
	public void setR000000087(String aR000000087)
	{
		if(aR000000087!=null && aR000000087.length()>17)
			throw new IllegalArgumentException("R000000087R000000087值"+aR000000087+"的长度"+aR000000087.length()+"大于最大值17");
		R000000087 = aR000000087;
	}
	public String getR000000088()
	{
		return R000000088;
	}
	public void setR000000088(String aR000000088)
	{
		if(aR000000088!=null && aR000000088.length()>17)
			throw new IllegalArgumentException("R000000088R000000088值"+aR000000088+"的长度"+aR000000088.length()+"大于最大值17");
		R000000088 = aR000000088;
	}
	public String getR000000089()
	{
		return R000000089;
	}
	public void setR000000089(String aR000000089)
	{
		if(aR000000089!=null && aR000000089.length()>17)
			throw new IllegalArgumentException("R000000089R000000089值"+aR000000089+"的长度"+aR000000089.length()+"大于最大值17");
		R000000089 = aR000000089;
	}
	public String getR000000090()
	{
		return R000000090;
	}
	public void setR000000090(String aR000000090)
	{
		if(aR000000090!=null && aR000000090.length()>17)
			throw new IllegalArgumentException("R000000090R000000090值"+aR000000090+"的长度"+aR000000090.length()+"大于最大值17");
		R000000090 = aR000000090;
	}
	public String getR000000091()
	{
		return R000000091;
	}
	public void setR000000091(String aR000000091)
	{
		if(aR000000091!=null && aR000000091.length()>17)
			throw new IllegalArgumentException("R000000091R000000091值"+aR000000091+"的长度"+aR000000091.length()+"大于最大值17");
		R000000091 = aR000000091;
	}
	public String getR000000092()
	{
		return R000000092;
	}
	public void setR000000092(String aR000000092)
	{
		if(aR000000092!=null && aR000000092.length()>17)
			throw new IllegalArgumentException("R000000092R000000092值"+aR000000092+"的长度"+aR000000092.length()+"大于最大值17");
		R000000092 = aR000000092;
	}
	public String getR000000093()
	{
		return R000000093;
	}
	public void setR000000093(String aR000000093)
	{
		if(aR000000093!=null && aR000000093.length()>17)
			throw new IllegalArgumentException("R000000093R000000093值"+aR000000093+"的长度"+aR000000093.length()+"大于最大值17");
		R000000093 = aR000000093;
	}
	public String getR000000094()
	{
		return R000000094;
	}
	public void setR000000094(String aR000000094)
	{
		if(aR000000094!=null && aR000000094.length()>17)
			throw new IllegalArgumentException("R000000094R000000094值"+aR000000094+"的长度"+aR000000094.length()+"大于最大值17");
		R000000094 = aR000000094;
	}
	public String getR000000095()
	{
		return R000000095;
	}
	public void setR000000095(String aR000000095)
	{
		if(aR000000095!=null && aR000000095.length()>17)
			throw new IllegalArgumentException("R000000095R000000095值"+aR000000095+"的长度"+aR000000095.length()+"大于最大值17");
		R000000095 = aR000000095;
	}
	public String getR000000096()
	{
		return R000000096;
	}
	public void setR000000096(String aR000000096)
	{
		if(aR000000096!=null && aR000000096.length()>17)
			throw new IllegalArgumentException("R000000096R000000096值"+aR000000096+"的长度"+aR000000096.length()+"大于最大值17");
		R000000096 = aR000000096;
	}
	public String getR000000097()
	{
		return R000000097;
	}
	public void setR000000097(String aR000000097)
	{
		if(aR000000097!=null && aR000000097.length()>17)
			throw new IllegalArgumentException("R000000097R000000097值"+aR000000097+"的长度"+aR000000097.length()+"大于最大值17");
		R000000097 = aR000000097;
	}
	public String getR000000098()
	{
		return R000000098;
	}
	public void setR000000098(String aR000000098)
	{
		if(aR000000098!=null && aR000000098.length()>17)
			throw new IllegalArgumentException("R000000098R000000098值"+aR000000098+"的长度"+aR000000098.length()+"大于最大值17");
		R000000098 = aR000000098;
	}
	public String getR000000099()
	{
		return R000000099;
	}
	public void setR000000099(String aR000000099)
	{
		if(aR000000099!=null && aR000000099.length()>17)
			throw new IllegalArgumentException("R000000099R000000099值"+aR000000099+"的长度"+aR000000099.length()+"大于最大值17");
		R000000099 = aR000000099;
	}
	public String getR000000100()
	{
		return R000000100;
	}
	public void setR000000100(String aR000000100)
	{
		if(aR000000100!=null && aR000000100.length()>17)
			throw new IllegalArgumentException("R000000100R000000100值"+aR000000100+"的长度"+aR000000100.length()+"大于最大值17");
		R000000100 = aR000000100;
	}
	public String getR000000101()
	{
		return R000000101;
	}
	public void setR000000101(String aR000000101)
	{
		if(aR000000101!=null && aR000000101.length()>17)
			throw new IllegalArgumentException("R000000101R000000101值"+aR000000101+"的长度"+aR000000101.length()+"大于最大值17");
		R000000101 = aR000000101;
	}
	public String getR000000102()
	{
		return R000000102;
	}
	public void setR000000102(String aR000000102)
	{
		if(aR000000102!=null && aR000000102.length()>17)
			throw new IllegalArgumentException("R000000102R000000102值"+aR000000102+"的长度"+aR000000102.length()+"大于最大值17");
		R000000102 = aR000000102;
	}
	public String getR000000103()
	{
		return R000000103;
	}
	public void setR000000103(String aR000000103)
	{
		if(aR000000103!=null && aR000000103.length()>17)
			throw new IllegalArgumentException("R000000103R000000103值"+aR000000103+"的长度"+aR000000103.length()+"大于最大值17");
		R000000103 = aR000000103;
	}
	public String getR000000104()
	{
		return R000000104;
	}
	public void setR000000104(String aR000000104)
	{
		if(aR000000104!=null && aR000000104.length()>17)
			throw new IllegalArgumentException("R000000104R000000104值"+aR000000104+"的长度"+aR000000104.length()+"大于最大值17");
		R000000104 = aR000000104;
	}
	public String getR000000105()
	{
		return R000000105;
	}
	public void setR000000105(String aR000000105)
	{
		if(aR000000105!=null && aR000000105.length()>17)
			throw new IllegalArgumentException("R000000105R000000105值"+aR000000105+"的长度"+aR000000105.length()+"大于最大值17");
		R000000105 = aR000000105;
	}
	public String getR000000106()
	{
		return R000000106;
	}
	public void setR000000106(String aR000000106)
	{
		if(aR000000106!=null && aR000000106.length()>17)
			throw new IllegalArgumentException("R000000106R000000106值"+aR000000106+"的长度"+aR000000106.length()+"大于最大值17");
		R000000106 = aR000000106;
	}
	public String getR000000107()
	{
		return R000000107;
	}
	public void setR000000107(String aR000000107)
	{
		if(aR000000107!=null && aR000000107.length()>17)
			throw new IllegalArgumentException("R000000107R000000107值"+aR000000107+"的长度"+aR000000107.length()+"大于最大值17");
		R000000107 = aR000000107;
	}
	public String getR000000108()
	{
		return R000000108;
	}
	public void setR000000108(String aR000000108)
	{
		if(aR000000108!=null && aR000000108.length()>17)
			throw new IllegalArgumentException("R000000108R000000108值"+aR000000108+"的长度"+aR000000108.length()+"大于最大值17");
		R000000108 = aR000000108;
	}
	public String getR000000109()
	{
		return R000000109;
	}
	public void setR000000109(String aR000000109)
	{
		if(aR000000109!=null && aR000000109.length()>17)
			throw new IllegalArgumentException("R000000109R000000109值"+aR000000109+"的长度"+aR000000109.length()+"大于最大值17");
		R000000109 = aR000000109;
	}
	public String getR000000110()
	{
		return R000000110;
	}
	public void setR000000110(String aR000000110)
	{
		if(aR000000110!=null && aR000000110.length()>17)
			throw new IllegalArgumentException("R000000110R000000110值"+aR000000110+"的长度"+aR000000110.length()+"大于最大值17");
		R000000110 = aR000000110;
	}
	public String getR000000111()
	{
		return R000000111;
	}
	public void setR000000111(String aR000000111)
	{
		if(aR000000111!=null && aR000000111.length()>17)
			throw new IllegalArgumentException("R000000111R000000111值"+aR000000111+"的长度"+aR000000111.length()+"大于最大值17");
		R000000111 = aR000000111;
	}
	public String getR000000112()
	{
		return R000000112;
	}
	public void setR000000112(String aR000000112)
	{
		if(aR000000112!=null && aR000000112.length()>17)
			throw new IllegalArgumentException("R000000112R000000112值"+aR000000112+"的长度"+aR000000112.length()+"大于最大值17");
		R000000112 = aR000000112;
	}
	public String getR000000113()
	{
		return R000000113;
	}
	public void setR000000113(String aR000000113)
	{
		if(aR000000113!=null && aR000000113.length()>17)
			throw new IllegalArgumentException("R000000113R000000113值"+aR000000113+"的长度"+aR000000113.length()+"大于最大值17");
		R000000113 = aR000000113;
	}
	public String getR000000114()
	{
		return R000000114;
	}
	public void setR000000114(String aR000000114)
	{
		if(aR000000114!=null && aR000000114.length()>17)
			throw new IllegalArgumentException("R000000114R000000114值"+aR000000114+"的长度"+aR000000114.length()+"大于最大值17");
		R000000114 = aR000000114;
	}
	public String getR000000115()
	{
		return R000000115;
	}
	public void setR000000115(String aR000000115)
	{
		if(aR000000115!=null && aR000000115.length()>17)
			throw new IllegalArgumentException("R000000115R000000115值"+aR000000115+"的长度"+aR000000115.length()+"大于最大值17");
		R000000115 = aR000000115;
	}
	public String getR000000116()
	{
		return R000000116;
	}
	public void setR000000116(String aR000000116)
	{
		if(aR000000116!=null && aR000000116.length()>17)
			throw new IllegalArgumentException("R000000116R000000116值"+aR000000116+"的长度"+aR000000116.length()+"大于最大值17");
		R000000116 = aR000000116;
	}
	public String getR000000117()
	{
		return R000000117;
	}
	public void setR000000117(String aR000000117)
	{
		if(aR000000117!=null && aR000000117.length()>17)
			throw new IllegalArgumentException("R000000117R000000117值"+aR000000117+"的长度"+aR000000117.length()+"大于最大值17");
		R000000117 = aR000000117;
	}
	public String getR000000118()
	{
		return R000000118;
	}
	public void setR000000118(String aR000000118)
	{
		if(aR000000118!=null && aR000000118.length()>17)
			throw new IllegalArgumentException("R000000118R000000118值"+aR000000118+"的长度"+aR000000118.length()+"大于最大值17");
		R000000118 = aR000000118;
	}
	public String getR000000119()
	{
		return R000000119;
	}
	public void setR000000119(String aR000000119)
	{
		if(aR000000119!=null && aR000000119.length()>17)
			throw new IllegalArgumentException("R000000119R000000119值"+aR000000119+"的长度"+aR000000119.length()+"大于最大值17");
		R000000119 = aR000000119;
	}
	public String getR000000120()
	{
		return R000000120;
	}
	public void setR000000120(String aR000000120)
	{
		if(aR000000120!=null && aR000000120.length()>17)
			throw new IllegalArgumentException("R000000120R000000120值"+aR000000120+"的长度"+aR000000120.length()+"大于最大值17");
		R000000120 = aR000000120;
	}
	public String getR000000121()
	{
		return R000000121;
	}
	public void setR000000121(String aR000000121)
	{
		if(aR000000121!=null && aR000000121.length()>17)
			throw new IllegalArgumentException("R000000121R000000121值"+aR000000121+"的长度"+aR000000121.length()+"大于最大值17");
		R000000121 = aR000000121;
	}
	public String getR000000122()
	{
		return R000000122;
	}
	public void setR000000122(String aR000000122)
	{
		if(aR000000122!=null && aR000000122.length()>17)
			throw new IllegalArgumentException("R000000122R000000122值"+aR000000122+"的长度"+aR000000122.length()+"大于最大值17");
		R000000122 = aR000000122;
	}
	public String getR000000123()
	{
		return R000000123;
	}
	public void setR000000123(String aR000000123)
	{
		if(aR000000123!=null && aR000000123.length()>17)
			throw new IllegalArgumentException("R000000123R000000123值"+aR000000123+"的长度"+aR000000123.length()+"大于最大值17");
		R000000123 = aR000000123;
	}
	public String getR000000124()
	{
		return R000000124;
	}
	public void setR000000124(String aR000000124)
	{
		if(aR000000124!=null && aR000000124.length()>17)
			throw new IllegalArgumentException("R000000124R000000124值"+aR000000124+"的长度"+aR000000124.length()+"大于最大值17");
		R000000124 = aR000000124;
	}
	public String getR000000125()
	{
		return R000000125;
	}
	public void setR000000125(String aR000000125)
	{
		if(aR000000125!=null && aR000000125.length()>17)
			throw new IllegalArgumentException("R000000125R000000125值"+aR000000125+"的长度"+aR000000125.length()+"大于最大值17");
		R000000125 = aR000000125;
	}
	public String getR000000126()
	{
		return R000000126;
	}
	public void setR000000126(String aR000000126)
	{
		if(aR000000126!=null && aR000000126.length()>17)
			throw new IllegalArgumentException("R000000126R000000126值"+aR000000126+"的长度"+aR000000126.length()+"大于最大值17");
		R000000126 = aR000000126;
	}
	public String getR000000127()
	{
		return R000000127;
	}
	public void setR000000127(String aR000000127)
	{
		if(aR000000127!=null && aR000000127.length()>17)
			throw new IllegalArgumentException("R000000127R000000127值"+aR000000127+"的长度"+aR000000127.length()+"大于最大值17");
		R000000127 = aR000000127;
	}
	public String getR000000128()
	{
		return R000000128;
	}
	public void setR000000128(String aR000000128)
	{
		if(aR000000128!=null && aR000000128.length()>17)
			throw new IllegalArgumentException("R000000128R000000128值"+aR000000128+"的长度"+aR000000128.length()+"大于最大值17");
		R000000128 = aR000000128;
	}
	public String getR000000129()
	{
		return R000000129;
	}
	public void setR000000129(String aR000000129)
	{
		if(aR000000129!=null && aR000000129.length()>17)
			throw new IllegalArgumentException("R000000129R000000129值"+aR000000129+"的长度"+aR000000129.length()+"大于最大值17");
		R000000129 = aR000000129;
	}
	public String getR000000130()
	{
		return R000000130;
	}
	public void setR000000130(String aR000000130)
	{
		if(aR000000130!=null && aR000000130.length()>17)
			throw new IllegalArgumentException("R000000130R000000130值"+aR000000130+"的长度"+aR000000130.length()+"大于最大值17");
		R000000130 = aR000000130;
	}
	public String getR000000131()
	{
		return R000000131;
	}
	public void setR000000131(String aR000000131)
	{
		if(aR000000131!=null && aR000000131.length()>17)
			throw new IllegalArgumentException("R000000131R000000131值"+aR000000131+"的长度"+aR000000131.length()+"大于最大值17");
		R000000131 = aR000000131;
	}
	public String getR000000132()
	{
		return R000000132;
	}
	public void setR000000132(String aR000000132)
	{
		if(aR000000132!=null && aR000000132.length()>17)
			throw new IllegalArgumentException("R000000132R000000132值"+aR000000132+"的长度"+aR000000132.length()+"大于最大值17");
		R000000132 = aR000000132;
	}
	public String getR000000133()
	{
		return R000000133;
	}
	public void setR000000133(String aR000000133)
	{
		if(aR000000133!=null && aR000000133.length()>17)
			throw new IllegalArgumentException("R000000133R000000133值"+aR000000133+"的长度"+aR000000133.length()+"大于最大值17");
		R000000133 = aR000000133;
	}
	public String getR000000134()
	{
		return R000000134;
	}
	public void setR000000134(String aR000000134)
	{
		if(aR000000134!=null && aR000000134.length()>17)
			throw new IllegalArgumentException("R000000134R000000134值"+aR000000134+"的长度"+aR000000134.length()+"大于最大值17");
		R000000134 = aR000000134;
	}
	public String getR000000135()
	{
		return R000000135;
	}
	public void setR000000135(String aR000000135)
	{
		if(aR000000135!=null && aR000000135.length()>17)
			throw new IllegalArgumentException("R000000135R000000135值"+aR000000135+"的长度"+aR000000135.length()+"大于最大值17");
		R000000135 = aR000000135;
	}
	public String getR000000136()
	{
		return R000000136;
	}
	public void setR000000136(String aR000000136)
	{
		if(aR000000136!=null && aR000000136.length()>17)
			throw new IllegalArgumentException("R000000136R000000136值"+aR000000136+"的长度"+aR000000136.length()+"大于最大值17");
		R000000136 = aR000000136;
	}
	public String getR000000137()
	{
		return R000000137;
	}
	public void setR000000137(String aR000000137)
	{
		if(aR000000137!=null && aR000000137.length()>17)
			throw new IllegalArgumentException("R000000137R000000137值"+aR000000137+"的长度"+aR000000137.length()+"大于最大值17");
		R000000137 = aR000000137;
	}
	public String getR000000138()
	{
		return R000000138;
	}
	public void setR000000138(String aR000000138)
	{
		if(aR000000138!=null && aR000000138.length()>17)
			throw new IllegalArgumentException("R000000138R000000138值"+aR000000138+"的长度"+aR000000138.length()+"大于最大值17");
		R000000138 = aR000000138;
	}
	public String getR000000139()
	{
		return R000000139;
	}
	public void setR000000139(String aR000000139)
	{
		if(aR000000139!=null && aR000000139.length()>17)
			throw new IllegalArgumentException("R000000139R000000139值"+aR000000139+"的长度"+aR000000139.length()+"大于最大值17");
		R000000139 = aR000000139;
	}
	public String getR000000140()
	{
		return R000000140;
	}
	public void setR000000140(String aR000000140)
	{
		if(aR000000140!=null && aR000000140.length()>17)
			throw new IllegalArgumentException("R000000140R000000140值"+aR000000140+"的长度"+aR000000140.length()+"大于最大值17");
		R000000140 = aR000000140;
	}
	public String getR000000141()
	{
		return R000000141;
	}
	public void setR000000141(String aR000000141)
	{
		if(aR000000141!=null && aR000000141.length()>17)
			throw new IllegalArgumentException("R000000141R000000141值"+aR000000141+"的长度"+aR000000141.length()+"大于最大值17");
		R000000141 = aR000000141;
	}
	public String getR000000142()
	{
		return R000000142;
	}
	public void setR000000142(String aR000000142)
	{
		if(aR000000142!=null && aR000000142.length()>17)
			throw new IllegalArgumentException("R000000142R000000142值"+aR000000142+"的长度"+aR000000142.length()+"大于最大值17");
		R000000142 = aR000000142;
	}
	public String getR000000143()
	{
		return R000000143;
	}
	public void setR000000143(String aR000000143)
	{
		if(aR000000143!=null && aR000000143.length()>17)
			throw new IllegalArgumentException("R000000143R000000143值"+aR000000143+"的长度"+aR000000143.length()+"大于最大值17");
		R000000143 = aR000000143;
	}
	public String getR000000144()
	{
		return R000000144;
	}
	public void setR000000144(String aR000000144)
	{
		if(aR000000144!=null && aR000000144.length()>17)
			throw new IllegalArgumentException("R000000144R000000144值"+aR000000144+"的长度"+aR000000144.length()+"大于最大值17");
		R000000144 = aR000000144;
	}
	public String getR000000145()
	{
		return R000000145;
	}
	public void setR000000145(String aR000000145)
	{
		if(aR000000145!=null && aR000000145.length()>17)
			throw new IllegalArgumentException("R000000145R000000145值"+aR000000145+"的长度"+aR000000145.length()+"大于最大值17");
		R000000145 = aR000000145;
	}
	public String getR000000146()
	{
		return R000000146;
	}
	public void setR000000146(String aR000000146)
	{
		if(aR000000146!=null && aR000000146.length()>17)
			throw new IllegalArgumentException("R000000146R000000146值"+aR000000146+"的长度"+aR000000146.length()+"大于最大值17");
		R000000146 = aR000000146;
	}
	public String getR000000147()
	{
		return R000000147;
	}
	public void setR000000147(String aR000000147)
	{
		if(aR000000147!=null && aR000000147.length()>17)
			throw new IllegalArgumentException("R000000147R000000147值"+aR000000147+"的长度"+aR000000147.length()+"大于最大值17");
		R000000147 = aR000000147;
	}
	public String getR000000148()
	{
		return R000000148;
	}
	public void setR000000148(String aR000000148)
	{
		if(aR000000148!=null && aR000000148.length()>17)
			throw new IllegalArgumentException("R000000148R000000148值"+aR000000148+"的长度"+aR000000148.length()+"大于最大值17");
		R000000148 = aR000000148;
	}
	public String getR000000149()
	{
		return R000000149;
	}
	public void setR000000149(String aR000000149)
	{
		if(aR000000149!=null && aR000000149.length()>17)
			throw new IllegalArgumentException("R000000149R000000149值"+aR000000149+"的长度"+aR000000149.length()+"大于最大值17");
		R000000149 = aR000000149;
	}
	public String getR000000150()
	{
		return R000000150;
	}
	public void setR000000150(String aR000000150)
	{
		if(aR000000150!=null && aR000000150.length()>17)
			throw new IllegalArgumentException("R000000150R000000150值"+aR000000150+"的长度"+aR000000150.length()+"大于最大值17");
		R000000150 = aR000000150;
	}
	public String getR000000151()
	{
		return R000000151;
	}
	public void setR000000151(String aR000000151)
	{
		if(aR000000151!=null && aR000000151.length()>17)
			throw new IllegalArgumentException("R000000151R000000151值"+aR000000151+"的长度"+aR000000151.length()+"大于最大值17");
		R000000151 = aR000000151;
	}
	public String getR000000152()
	{
		return R000000152;
	}
	public void setR000000152(String aR000000152)
	{
		if(aR000000152!=null && aR000000152.length()>17)
			throw new IllegalArgumentException("R000000152R000000152值"+aR000000152+"的长度"+aR000000152.length()+"大于最大值17");
		R000000152 = aR000000152;
	}
	public String getR000000153()
	{
		return R000000153;
	}
	public void setR000000153(String aR000000153)
	{
		if(aR000000153!=null && aR000000153.length()>17)
			throw new IllegalArgumentException("R000000153R000000153值"+aR000000153+"的长度"+aR000000153.length()+"大于最大值17");
		R000000153 = aR000000153;
	}
	public String getR000000154()
	{
		return R000000154;
	}
	public void setR000000154(String aR000000154)
	{
		if(aR000000154!=null && aR000000154.length()>17)
			throw new IllegalArgumentException("R000000154R000000154值"+aR000000154+"的长度"+aR000000154.length()+"大于最大值17");
		R000000154 = aR000000154;
	}
	public String getR000000155()
	{
		return R000000155;
	}
	public void setR000000155(String aR000000155)
	{
		if(aR000000155!=null && aR000000155.length()>17)
			throw new IllegalArgumentException("R000000155R000000155值"+aR000000155+"的长度"+aR000000155.length()+"大于最大值17");
		R000000155 = aR000000155;
	}
	public String getR000000156()
	{
		return R000000156;
	}
	public void setR000000156(String aR000000156)
	{
		if(aR000000156!=null && aR000000156.length()>17)
			throw new IllegalArgumentException("R000000156R000000156值"+aR000000156+"的长度"+aR000000156.length()+"大于最大值17");
		R000000156 = aR000000156;
	}
	public String getR000000157()
	{
		return R000000157;
	}
	public void setR000000157(String aR000000157)
	{
		if(aR000000157!=null && aR000000157.length()>17)
			throw new IllegalArgumentException("R000000157R000000157值"+aR000000157+"的长度"+aR000000157.length()+"大于最大值17");
		R000000157 = aR000000157;
	}
	public String getR000000158()
	{
		return R000000158;
	}
	public void setR000000158(String aR000000158)
	{
		if(aR000000158!=null && aR000000158.length()>17)
			throw new IllegalArgumentException("R000000158R000000158值"+aR000000158+"的长度"+aR000000158.length()+"大于最大值17");
		R000000158 = aR000000158;
	}
	public String getR000000159()
	{
		return R000000159;
	}
	public void setR000000159(String aR000000159)
	{
		if(aR000000159!=null && aR000000159.length()>17)
			throw new IllegalArgumentException("R000000159R000000159值"+aR000000159+"的长度"+aR000000159.length()+"大于最大值17");
		R000000159 = aR000000159;
	}
	public String getR000000160()
	{
		return R000000160;
	}
	public void setR000000160(String aR000000160)
	{
		if(aR000000160!=null && aR000000160.length()>17)
			throw new IllegalArgumentException("R000000160R000000160值"+aR000000160+"的长度"+aR000000160.length()+"大于最大值17");
		R000000160 = aR000000160;
	}
	public String getR000000161()
	{
		return R000000161;
	}
	public void setR000000161(String aR000000161)
	{
		if(aR000000161!=null && aR000000161.length()>17)
			throw new IllegalArgumentException("R000000161R000000161值"+aR000000161+"的长度"+aR000000161.length()+"大于最大值17");
		R000000161 = aR000000161;
	}
	public String getR000000162()
	{
		return R000000162;
	}
	public void setR000000162(String aR000000162)
	{
		if(aR000000162!=null && aR000000162.length()>17)
			throw new IllegalArgumentException("R000000162R000000162值"+aR000000162+"的长度"+aR000000162.length()+"大于最大值17");
		R000000162 = aR000000162;
	}
	public String getR000000163()
	{
		return R000000163;
	}
	public void setR000000163(String aR000000163)
	{
		if(aR000000163!=null && aR000000163.length()>17)
			throw new IllegalArgumentException("R000000163R000000163值"+aR000000163+"的长度"+aR000000163.length()+"大于最大值17");
		R000000163 = aR000000163;
	}
	public String getR000000164()
	{
		return R000000164;
	}
	public void setR000000164(String aR000000164)
	{
		if(aR000000164!=null && aR000000164.length()>17)
			throw new IllegalArgumentException("R000000164R000000164值"+aR000000164+"的长度"+aR000000164.length()+"大于最大值17");
		R000000164 = aR000000164;
	}
	public String getR000000165()
	{
		return R000000165;
	}
	public void setR000000165(String aR000000165)
	{
		if(aR000000165!=null && aR000000165.length()>17)
			throw new IllegalArgumentException("R000000165R000000165值"+aR000000165+"的长度"+aR000000165.length()+"大于最大值17");
		R000000165 = aR000000165;
	}
	public String getR000000166()
	{
		return R000000166;
	}
	public void setR000000166(String aR000000166)
	{
		if(aR000000166!=null && aR000000166.length()>17)
			throw new IllegalArgumentException("R000000166R000000166值"+aR000000166+"的长度"+aR000000166.length()+"大于最大值17");
		R000000166 = aR000000166;
	}
	public String getR000000167()
	{
		return R000000167;
	}
	public void setR000000167(String aR000000167)
	{
		if(aR000000167!=null && aR000000167.length()>17)
			throw new IllegalArgumentException("R000000167R000000167值"+aR000000167+"的长度"+aR000000167.length()+"大于最大值17");
		R000000167 = aR000000167;
	}
	public String getR000000168()
	{
		return R000000168;
	}
	public void setR000000168(String aR000000168)
	{
		if(aR000000168!=null && aR000000168.length()>17)
			throw new IllegalArgumentException("R000000168R000000168值"+aR000000168+"的长度"+aR000000168.length()+"大于最大值17");
		R000000168 = aR000000168;
	}
	public String getR000000169()
	{
		return R000000169;
	}
	public void setR000000169(String aR000000169)
	{
		if(aR000000169!=null && aR000000169.length()>17)
			throw new IllegalArgumentException("R000000169R000000169值"+aR000000169+"的长度"+aR000000169.length()+"大于最大值17");
		R000000169 = aR000000169;
	}
	public String getR000000170()
	{
		return R000000170;
	}
	public void setR000000170(String aR000000170)
	{
		if(aR000000170!=null && aR000000170.length()>17)
			throw new IllegalArgumentException("R000000170R000000170值"+aR000000170+"的长度"+aR000000170.length()+"大于最大值17");
		R000000170 = aR000000170;
	}
	public String getR000000171()
	{
		return R000000171;
	}
	public void setR000000171(String aR000000171)
	{
		if(aR000000171!=null && aR000000171.length()>17)
			throw new IllegalArgumentException("R000000171R000000171值"+aR000000171+"的长度"+aR000000171.length()+"大于最大值17");
		R000000171 = aR000000171;
	}
	public String getR000000172()
	{
		return R000000172;
	}
	public void setR000000172(String aR000000172)
	{
		if(aR000000172!=null && aR000000172.length()>17)
			throw new IllegalArgumentException("R000000172R000000172值"+aR000000172+"的长度"+aR000000172.length()+"大于最大值17");
		R000000172 = aR000000172;
	}
	public String getR000000173()
	{
		return R000000173;
	}
	public void setR000000173(String aR000000173)
	{
		if(aR000000173!=null && aR000000173.length()>17)
			throw new IllegalArgumentException("R000000173R000000173值"+aR000000173+"的长度"+aR000000173.length()+"大于最大值17");
		R000000173 = aR000000173;
	}
	public String getR000000174()
	{
		return R000000174;
	}
	public void setR000000174(String aR000000174)
	{
		if(aR000000174!=null && aR000000174.length()>17)
			throw new IllegalArgumentException("R000000174R000000174值"+aR000000174+"的长度"+aR000000174.length()+"大于最大值17");
		R000000174 = aR000000174;
	}
	public String getR000000175()
	{
		return R000000175;
	}
	public void setR000000175(String aR000000175)
	{
		if(aR000000175!=null && aR000000175.length()>17)
			throw new IllegalArgumentException("R000000175R000000175值"+aR000000175+"的长度"+aR000000175.length()+"大于最大值17");
		R000000175 = aR000000175;
	}
	public String getR000000176()
	{
		return R000000176;
	}
	public void setR000000176(String aR000000176)
	{
		if(aR000000176!=null && aR000000176.length()>17)
			throw new IllegalArgumentException("R000000176R000000176值"+aR000000176+"的长度"+aR000000176.length()+"大于最大值17");
		R000000176 = aR000000176;
	}
	public String getR000000177()
	{
		return R000000177;
	}
	public void setR000000177(String aR000000177)
	{
		if(aR000000177!=null && aR000000177.length()>17)
			throw new IllegalArgumentException("R000000177R000000177值"+aR000000177+"的长度"+aR000000177.length()+"大于最大值17");
		R000000177 = aR000000177;
	}
	public String getR000000178()
	{
		return R000000178;
	}
	public void setR000000178(String aR000000178)
	{
		if(aR000000178!=null && aR000000178.length()>17)
			throw new IllegalArgumentException("R000000178R000000178值"+aR000000178+"的长度"+aR000000178.length()+"大于最大值17");
		R000000178 = aR000000178;
	}
	public String getR000000179()
	{
		return R000000179;
	}
	public void setR000000179(String aR000000179)
	{
		if(aR000000179!=null && aR000000179.length()>17)
			throw new IllegalArgumentException("R000000179R000000179值"+aR000000179+"的长度"+aR000000179.length()+"大于最大值17");
		R000000179 = aR000000179;
	}
	public String getR000000180()
	{
		return R000000180;
	}
	public void setR000000180(String aR000000180)
	{
		if(aR000000180!=null && aR000000180.length()>17)
			throw new IllegalArgumentException("R000000180R000000180值"+aR000000180+"的长度"+aR000000180.length()+"大于最大值17");
		R000000180 = aR000000180;
	}
	public String getR000000181()
	{
		return R000000181;
	}
	public void setR000000181(String aR000000181)
	{
		if(aR000000181!=null && aR000000181.length()>17)
			throw new IllegalArgumentException("R000000181R000000181值"+aR000000181+"的长度"+aR000000181.length()+"大于最大值17");
		R000000181 = aR000000181;
	}
	public String getR000000182()
	{
		return R000000182;
	}
	public void setR000000182(String aR000000182)
	{
		if(aR000000182!=null && aR000000182.length()>17)
			throw new IllegalArgumentException("R000000182R000000182值"+aR000000182+"的长度"+aR000000182.length()+"大于最大值17");
		R000000182 = aR000000182;
	}
	public String getR000000183()
	{
		return R000000183;
	}
	public void setR000000183(String aR000000183)
	{
		if(aR000000183!=null && aR000000183.length()>17)
			throw new IllegalArgumentException("R000000183R000000183值"+aR000000183+"的长度"+aR000000183.length()+"大于最大值17");
		R000000183 = aR000000183;
	}
	public String getR000000184()
	{
		return R000000184;
	}
	public void setR000000184(String aR000000184)
	{
		if(aR000000184!=null && aR000000184.length()>17)
			throw new IllegalArgumentException("R000000184R000000184值"+aR000000184+"的长度"+aR000000184.length()+"大于最大值17");
		R000000184 = aR000000184;
	}
	public String getR000000185()
	{
		return R000000185;
	}
	public void setR000000185(String aR000000185)
	{
		if(aR000000185!=null && aR000000185.length()>17)
			throw new IllegalArgumentException("R000000185R000000185值"+aR000000185+"的长度"+aR000000185.length()+"大于最大值17");
		R000000185 = aR000000185;
	}
	public String getR000000186()
	{
		return R000000186;
	}
	public void setR000000186(String aR000000186)
	{
		if(aR000000186!=null && aR000000186.length()>17)
			throw new IllegalArgumentException("R000000186R000000186值"+aR000000186+"的长度"+aR000000186.length()+"大于最大值17");
		R000000186 = aR000000186;
	}
	public String getR000000187()
	{
		return R000000187;
	}
	public void setR000000187(String aR000000187)
	{
		if(aR000000187!=null && aR000000187.length()>17)
			throw new IllegalArgumentException("R000000187R000000187值"+aR000000187+"的长度"+aR000000187.length()+"大于最大值17");
		R000000187 = aR000000187;
	}
	public String getR000000188()
	{
		return R000000188;
	}
	public void setR000000188(String aR000000188)
	{
		if(aR000000188!=null && aR000000188.length()>17)
			throw new IllegalArgumentException("R000000188R000000188值"+aR000000188+"的长度"+aR000000188.length()+"大于最大值17");
		R000000188 = aR000000188;
	}
	public String getR000000189()
	{
		return R000000189;
	}
	public void setR000000189(String aR000000189)
	{
		if(aR000000189!=null && aR000000189.length()>17)
			throw new IllegalArgumentException("R000000189R000000189值"+aR000000189+"的长度"+aR000000189.length()+"大于最大值17");
		R000000189 = aR000000189;
	}
	public String getR000000190()
	{
		return R000000190;
	}
	public void setR000000190(String aR000000190)
	{
		if(aR000000190!=null && aR000000190.length()>17)
			throw new IllegalArgumentException("R000000190R000000190值"+aR000000190+"的长度"+aR000000190.length()+"大于最大值17");
		R000000190 = aR000000190;
	}
	public String getR000000191()
	{
		return R000000191;
	}
	public void setR000000191(String aR000000191)
	{
		if(aR000000191!=null && aR000000191.length()>17)
			throw new IllegalArgumentException("R000000191R000000191值"+aR000000191+"的长度"+aR000000191.length()+"大于最大值17");
		R000000191 = aR000000191;
	}
	public String getR000000192()
	{
		return R000000192;
	}
	public void setR000000192(String aR000000192)
	{
		if(aR000000192!=null && aR000000192.length()>17)
			throw new IllegalArgumentException("R000000192R000000192值"+aR000000192+"的长度"+aR000000192.length()+"大于最大值17");
		R000000192 = aR000000192;
	}
	public String getR000000193()
	{
		return R000000193;
	}
	public void setR000000193(String aR000000193)
	{
		if(aR000000193!=null && aR000000193.length()>17)
			throw new IllegalArgumentException("R000000193R000000193值"+aR000000193+"的长度"+aR000000193.length()+"大于最大值17");
		R000000193 = aR000000193;
	}
	public String getR000000194()
	{
		return R000000194;
	}
	public void setR000000194(String aR000000194)
	{
		if(aR000000194!=null && aR000000194.length()>17)
			throw new IllegalArgumentException("R000000194R000000194值"+aR000000194+"的长度"+aR000000194.length()+"大于最大值17");
		R000000194 = aR000000194;
	}
	public String getR000000195()
	{
		return R000000195;
	}
	public void setR000000195(String aR000000195)
	{
		if(aR000000195!=null && aR000000195.length()>17)
			throw new IllegalArgumentException("R000000195R000000195值"+aR000000195+"的长度"+aR000000195.length()+"大于最大值17");
		R000000195 = aR000000195;
	}
	public String getR000000196()
	{
		return R000000196;
	}
	public void setR000000196(String aR000000196)
	{
		if(aR000000196!=null && aR000000196.length()>17)
			throw new IllegalArgumentException("R000000196R000000196值"+aR000000196+"的长度"+aR000000196.length()+"大于最大值17");
		R000000196 = aR000000196;
	}
	public String getR000000197()
	{
		return R000000197;
	}
	public void setR000000197(String aR000000197)
	{
		if(aR000000197!=null && aR000000197.length()>17)
			throw new IllegalArgumentException("R000000197R000000197值"+aR000000197+"的长度"+aR000000197.length()+"大于最大值17");
		R000000197 = aR000000197;
	}
	public String getR000000198()
	{
		return R000000198;
	}
	public void setR000000198(String aR000000198)
	{
		if(aR000000198!=null && aR000000198.length()>17)
			throw new IllegalArgumentException("R000000198R000000198值"+aR000000198+"的长度"+aR000000198.length()+"大于最大值17");
		R000000198 = aR000000198;
	}
	public String getR000000199()
	{
		return R000000199;
	}
	public void setR000000199(String aR000000199)
	{
		if(aR000000199!=null && aR000000199.length()>17)
			throw new IllegalArgumentException("R000000199R000000199值"+aR000000199+"的长度"+aR000000199.length()+"大于最大值17");
		R000000199 = aR000000199;
	}
	public String getR000000200()
	{
		return R000000200;
	}
	public void setR000000200(String aR000000200)
	{
		if(aR000000200!=null && aR000000200.length()>17)
			throw new IllegalArgumentException("R000000200R000000200值"+aR000000200+"的长度"+aR000000200.length()+"大于最大值17");
		R000000200 = aR000000200;
	}
	public String getI000000201()
	{
		return I000000201;
	}
	public void setI000000201(String aI000000201)
	{
		if(aI000000201!=null && aI000000201.length()>17)
			throw new IllegalArgumentException("I000000201I000000201值"+aI000000201+"的长度"+aI000000201.length()+"大于最大值17");
		I000000201 = aI000000201;
	}
	public String getI000000202()
	{
		return I000000202;
	}
	public void setI000000202(String aI000000202)
	{
		if(aI000000202!=null && aI000000202.length()>17)
			throw new IllegalArgumentException("I000000202I000000202值"+aI000000202+"的长度"+aI000000202.length()+"大于最大值17");
		I000000202 = aI000000202;
	}
	public String getI000000203()
	{
		return I000000203;
	}
	public void setI000000203(String aI000000203)
	{
		if(aI000000203!=null && aI000000203.length()>17)
			throw new IllegalArgumentException("I000000203I000000203值"+aI000000203+"的长度"+aI000000203.length()+"大于最大值17");
		I000000203 = aI000000203;
	}
	public String getI000000209()
	{
		return I000000209;
	}
	public void setI000000209(String aI000000209)
	{
		if(aI000000209!=null && aI000000209.length()>17)
			throw new IllegalArgumentException("I000000209I000000209值"+aI000000209+"的长度"+aI000000209.length()+"大于最大值17");
		I000000209 = aI000000209;
	}
	public String getI000000210()
	{
		return I000000210;
	}
	public void setI000000210(String aI000000210)
	{
		if(aI000000210!=null && aI000000210.length()>17)
			throw new IllegalArgumentException("I000000210I000000210值"+aI000000210+"的长度"+aI000000210.length()+"大于最大值17");
		I000000210 = aI000000210;
	}
	public String getI000000213()
	{
		return I000000213;
	}
	public void setI000000213(String aI000000213)
	{
		if(aI000000213!=null && aI000000213.length()>17)
			throw new IllegalArgumentException("I000000213I000000213值"+aI000000213+"的长度"+aI000000213.length()+"大于最大值17");
		I000000213 = aI000000213;
	}
	public String getI000000214()
	{
		return I000000214;
	}
	public void setI000000214(String aI000000214)
	{
		if(aI000000214!=null && aI000000214.length()>17)
			throw new IllegalArgumentException("I000000214I000000214值"+aI000000214+"的长度"+aI000000214.length()+"大于最大值17");
		I000000214 = aI000000214;
	}
	public String getI000000215()
	{
		return I000000215;
	}
	public void setI000000215(String aI000000215)
	{
		if(aI000000215!=null && aI000000215.length()>17)
			throw new IllegalArgumentException("I000000215I000000215值"+aI000000215+"的长度"+aI000000215.length()+"大于最大值17");
		I000000215 = aI000000215;
	}
	public String getI000000216()
	{
		return I000000216;
	}
	public void setI000000216(String aI000000216)
	{
		if(aI000000216!=null && aI000000216.length()>17)
			throw new IllegalArgumentException("I000000216I000000216值"+aI000000216+"的长度"+aI000000216.length()+"大于最大值17");
		I000000216 = aI000000216;
	}
	public String getI000000217()
	{
		return I000000217;
	}
	public void setI000000217(String aI000000217)
	{
		if(aI000000217!=null && aI000000217.length()>17)
			throw new IllegalArgumentException("I000000217I000000217值"+aI000000217+"的长度"+aI000000217.length()+"大于最大值17");
		I000000217 = aI000000217;
	}
	public String getI000000218()
	{
		return I000000218;
	}
	public void setI000000218(String aI000000218)
	{
		if(aI000000218!=null && aI000000218.length()>17)
			throw new IllegalArgumentException("I000000218I000000218值"+aI000000218+"的长度"+aI000000218.length()+"大于最大值17");
		I000000218 = aI000000218;
	}
	public String getI000000219()
	{
		return I000000219;
	}
	public void setI000000219(String aI000000219)
	{
		if(aI000000219!=null && aI000000219.length()>17)
			throw new IllegalArgumentException("I000000219I000000219值"+aI000000219+"的长度"+aI000000219.length()+"大于最大值17");
		I000000219 = aI000000219;
	}
	public String getI000000220()
	{
		return I000000220;
	}
	public void setI000000220(String aI000000220)
	{
		if(aI000000220!=null && aI000000220.length()>17)
			throw new IllegalArgumentException("I000000220I000000220值"+aI000000220+"的长度"+aI000000220.length()+"大于最大值17");
		I000000220 = aI000000220;
	}
	public String getI000000221()
	{
		return I000000221;
	}
	public void setI000000221(String aI000000221)
	{
		if(aI000000221!=null && aI000000221.length()>17)
			throw new IllegalArgumentException("I000000221I000000221值"+aI000000221+"的长度"+aI000000221.length()+"大于最大值17");
		I000000221 = aI000000221;
	}
	public String getI000000222()
	{
		return I000000222;
	}
	public void setI000000222(String aI000000222)
	{
		if(aI000000222!=null && aI000000222.length()>17)
			throw new IllegalArgumentException("I000000222I000000222值"+aI000000222+"的长度"+aI000000222.length()+"大于最大值17");
		I000000222 = aI000000222;
	}
	public String getI000000224()
	{
		return I000000224;
	}
	public void setI000000224(String aI000000224)
	{
		if(aI000000224!=null && aI000000224.length()>17)
			throw new IllegalArgumentException("I000000224I000000224值"+aI000000224+"的长度"+aI000000224.length()+"大于最大值17");
		I000000224 = aI000000224;
	}
	public String getI000000225()
	{
		return I000000225;
	}
	public void setI000000225(String aI000000225)
	{
		if(aI000000225!=null && aI000000225.length()>17)
			throw new IllegalArgumentException("I000000225I000000225值"+aI000000225+"的长度"+aI000000225.length()+"大于最大值17");
		I000000225 = aI000000225;
	}
	public String getI000000226()
	{
		return I000000226;
	}
	public void setI000000226(String aI000000226)
	{
		if(aI000000226!=null && aI000000226.length()>17)
			throw new IllegalArgumentException("I000000226I000000226值"+aI000000226+"的长度"+aI000000226.length()+"大于最大值17");
		I000000226 = aI000000226;
	}
	public String getI000000227()
	{
		return I000000227;
	}
	public void setI000000227(String aI000000227)
	{
		if(aI000000227!=null && aI000000227.length()>17)
			throw new IllegalArgumentException("I000000227I000000227值"+aI000000227+"的长度"+aI000000227.length()+"大于最大值17");
		I000000227 = aI000000227;
	}
	public String getI000000228()
	{
		return I000000228;
	}
	public void setI000000228(String aI000000228)
	{
		if(aI000000228!=null && aI000000228.length()>17)
			throw new IllegalArgumentException("I000000228I000000228值"+aI000000228+"的长度"+aI000000228.length()+"大于最大值17");
		I000000228 = aI000000228;
	}
	public String getI000000229()
	{
		return I000000229;
	}
	public void setI000000229(String aI000000229)
	{
		if(aI000000229!=null && aI000000229.length()>17)
			throw new IllegalArgumentException("I000000229I000000229值"+aI000000229+"的长度"+aI000000229.length()+"大于最大值17");
		I000000229 = aI000000229;
	}
	public String getI000000231()
	{
		return I000000231;
	}
	public void setI000000231(String aI000000231)
	{
		if(aI000000231!=null && aI000000231.length()>17)
			throw new IllegalArgumentException("I000000231I000000231值"+aI000000231+"的长度"+aI000000231.length()+"大于最大值17");
		I000000231 = aI000000231;
	}
	public String getI000000232()
	{
		return I000000232;
	}
	public void setI000000232(String aI000000232)
	{
		if(aI000000232!=null && aI000000232.length()>17)
			throw new IllegalArgumentException("I000000232I000000232值"+aI000000232+"的长度"+aI000000232.length()+"大于最大值17");
		I000000232 = aI000000232;
	}
	public String getI000000233()
	{
		return I000000233;
	}
	public void setI000000233(String aI000000233)
	{
		if(aI000000233!=null && aI000000233.length()>17)
			throw new IllegalArgumentException("I000000233I000000233值"+aI000000233+"的长度"+aI000000233.length()+"大于最大值17");
		I000000233 = aI000000233;
	}
	public String getI000000234()
	{
		return I000000234;
	}
	public void setI000000234(String aI000000234)
	{
		if(aI000000234!=null && aI000000234.length()>17)
			throw new IllegalArgumentException("I000000234I000000234值"+aI000000234+"的长度"+aI000000234.length()+"大于最大值17");
		I000000234 = aI000000234;
	}
	public String getI000000235()
	{
		return I000000235;
	}
	public void setI000000235(String aI000000235)
	{
		if(aI000000235!=null && aI000000235.length()>17)
			throw new IllegalArgumentException("I000000235I000000235值"+aI000000235+"的长度"+aI000000235.length()+"大于最大值17");
		I000000235 = aI000000235;
	}
	public String getI000000236()
	{
		return I000000236;
	}
	public void setI000000236(String aI000000236)
	{
		if(aI000000236!=null && aI000000236.length()>17)
			throw new IllegalArgumentException("I000000236I000000236值"+aI000000236+"的长度"+aI000000236.length()+"大于最大值17");
		I000000236 = aI000000236;
	}
	public String getI000000237()
	{
		return I000000237;
	}
	public void setI000000237(String aI000000237)
	{
		if(aI000000237!=null && aI000000237.length()>17)
			throw new IllegalArgumentException("I000000237I000000237值"+aI000000237+"的长度"+aI000000237.length()+"大于最大值17");
		I000000237 = aI000000237;
	}
	public String getI000000240()
	{
		return I000000240;
	}
	public void setI000000240(String aI000000240)
	{
		if(aI000000240!=null && aI000000240.length()>17)
			throw new IllegalArgumentException("I000000240I000000240值"+aI000000240+"的长度"+aI000000240.length()+"大于最大值17");
		I000000240 = aI000000240;
	}
	public String getI000000241()
	{
		return I000000241;
	}
	public void setI000000241(String aI000000241)
	{
		if(aI000000241!=null && aI000000241.length()>17)
			throw new IllegalArgumentException("I000000241I000000241值"+aI000000241+"的长度"+aI000000241.length()+"大于最大值17");
		I000000241 = aI000000241;
	}
	public String getI000000242()
	{
		return I000000242;
	}
	public void setI000000242(String aI000000242)
	{
		if(aI000000242!=null && aI000000242.length()>17)
			throw new IllegalArgumentException("I000000242I000000242值"+aI000000242+"的长度"+aI000000242.length()+"大于最大值17");
		I000000242 = aI000000242;
	}
	public String getI000000243()
	{
		return I000000243;
	}
	public void setI000000243(String aI000000243)
	{
		if(aI000000243!=null && aI000000243.length()>17)
			throw new IllegalArgumentException("I000000243I000000243值"+aI000000243+"的长度"+aI000000243.length()+"大于最大值17");
		I000000243 = aI000000243;
	}
	public String getI000000244()
	{
		return I000000244;
	}
	public void setI000000244(String aI000000244)
	{
		if(aI000000244!=null && aI000000244.length()>17)
			throw new IllegalArgumentException("I000000244I000000244值"+aI000000244+"的长度"+aI000000244.length()+"大于最大值17");
		I000000244 = aI000000244;
	}
	public String getI000000245()
	{
		return I000000245;
	}
	public void setI000000245(String aI000000245)
	{
		if(aI000000245!=null && aI000000245.length()>17)
			throw new IllegalArgumentException("I000000245I000000245值"+aI000000245+"的长度"+aI000000245.length()+"大于最大值17");
		I000000245 = aI000000245;
	}
	public String getI000000246()
	{
		return I000000246;
	}
	public void setI000000246(String aI000000246)
	{
		if(aI000000246!=null && aI000000246.length()>17)
			throw new IllegalArgumentException("I000000246I000000246值"+aI000000246+"的长度"+aI000000246.length()+"大于最大值17");
		I000000246 = aI000000246;
	}
	public String getI000000247()
	{
		return I000000247;
	}
	public void setI000000247(String aI000000247)
	{
		if(aI000000247!=null && aI000000247.length()>17)
			throw new IllegalArgumentException("I000000247I000000247值"+aI000000247+"的长度"+aI000000247.length()+"大于最大值17");
		I000000247 = aI000000247;
	}
	public String getI000000248()
	{
		return I000000248;
	}
	public void setI000000248(String aI000000248)
	{
		if(aI000000248!=null && aI000000248.length()>17)
			throw new IllegalArgumentException("I000000248I000000248值"+aI000000248+"的长度"+aI000000248.length()+"大于最大值17");
		I000000248 = aI000000248;
	}
	public String getI000000249()
	{
		return I000000249;
	}
	public void setI000000249(String aI000000249)
	{
		if(aI000000249!=null && aI000000249.length()>17)
			throw new IllegalArgumentException("I000000249I000000249值"+aI000000249+"的长度"+aI000000249.length()+"大于最大值17");
		I000000249 = aI000000249;
	}
	public String getI000000250()
	{
		return I000000250;
	}
	public void setI000000250(String aI000000250)
	{
		if(aI000000250!=null && aI000000250.length()>17)
			throw new IllegalArgumentException("I000000250I000000250值"+aI000000250+"的长度"+aI000000250.length()+"大于最大值17");
		I000000250 = aI000000250;
	}
	public String getI000000251()
	{
		return I000000251;
	}
	public void setI000000251(String aI000000251)
	{
		if(aI000000251!=null && aI000000251.length()>17)
			throw new IllegalArgumentException("I000000251I000000251值"+aI000000251+"的长度"+aI000000251.length()+"大于最大值17");
		I000000251 = aI000000251;
	}
	public String getR000000201()
	{
		return R000000201;
	}
	public void setR000000201(String aR000000201)
	{
		if(aR000000201!=null && aR000000201.length()>17)
			throw new IllegalArgumentException("R000000201R000000201值"+aR000000201+"的长度"+aR000000201.length()+"大于最大值17");
		R000000201 = aR000000201;
	}
	public String getR000000202()
	{
		return R000000202;
	}
	public void setR000000202(String aR000000202)
	{
		if(aR000000202!=null && aR000000202.length()>17)
			throw new IllegalArgumentException("R000000202R000000202值"+aR000000202+"的长度"+aR000000202.length()+"大于最大值17");
		R000000202 = aR000000202;
	}
	public String getR000000203()
	{
		return R000000203;
	}
	public void setR000000203(String aR000000203)
	{
		if(aR000000203!=null && aR000000203.length()>17)
			throw new IllegalArgumentException("R000000203R000000203值"+aR000000203+"的长度"+aR000000203.length()+"大于最大值17");
		R000000203 = aR000000203;
	}
	public String getR000000204()
	{
		return R000000204;
	}
	public void setR000000204(String aR000000204)
	{
		if(aR000000204!=null && aR000000204.length()>17)
			throw new IllegalArgumentException("R000000204R000000204值"+aR000000204+"的长度"+aR000000204.length()+"大于最大值17");
		R000000204 = aR000000204;
	}
	public String getR000000205()
	{
		return R000000205;
	}
	public void setR000000205(String aR000000205)
	{
		if(aR000000205!=null && aR000000205.length()>17)
			throw new IllegalArgumentException("R000000205R000000205值"+aR000000205+"的长度"+aR000000205.length()+"大于最大值17");
		R000000205 = aR000000205;
	}
	public String getI000000254()
	{
		return I000000254;
	}
	public void setI000000254(String aI000000254)
	{
		if(aI000000254!=null && aI000000254.length()>17)
			throw new IllegalArgumentException("I000000254I000000254值"+aI000000254+"的长度"+aI000000254.length()+"大于最大值17");
		I000000254 = aI000000254;
	}

	/**
	* 使用另外一个 LAIndexInfoVSchema 对象给 Schema 赋值
	* @param: aLAIndexInfoVSchema LAIndexInfoVSchema
	**/
	public void setSchema(LAIndexInfoVSchema aLAIndexInfoVSchema)
	{
		this.WageNo = aLAIndexInfoVSchema.getWageNo();
		this.BranchType = aLAIndexInfoVSchema.getBranchType();
		this.IndexType = aLAIndexInfoVSchema.getIndexType();
		this.AgentCode = aLAIndexInfoVSchema.getAgentCode();
		this.AgentGrade = aLAIndexInfoVSchema.getAgentGrade();
		this.AgentGroup = aLAIndexInfoVSchema.getAgentGroup();
		this.State = aLAIndexInfoVSchema.getState();
		this.MakeDate = fDate.getDate( aLAIndexInfoVSchema.getMakeDate());
		this.MakeTime = aLAIndexInfoVSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLAIndexInfoVSchema.getModifyDate());
		this.ModifyTime = aLAIndexInfoVSchema.getModifyTime();
		this.I000000001 = aLAIndexInfoVSchema.getI000000001();
		this.I000000002 = aLAIndexInfoVSchema.getI000000002();
		this.I000000003 = aLAIndexInfoVSchema.getI000000003();
		this.I000000004 = aLAIndexInfoVSchema.getI000000004();
		this.I000000005 = aLAIndexInfoVSchema.getI000000005();
		this.I000000006 = aLAIndexInfoVSchema.getI000000006();
		this.I000000007 = aLAIndexInfoVSchema.getI000000007();
		this.I000000008 = aLAIndexInfoVSchema.getI000000008();
		this.I000000009 = aLAIndexInfoVSchema.getI000000009();
		this.I000000010 = aLAIndexInfoVSchema.getI000000010();
		this.I000000011 = aLAIndexInfoVSchema.getI000000011();
		this.I000000012 = aLAIndexInfoVSchema.getI000000012();
		this.I000000013 = aLAIndexInfoVSchema.getI000000013();
		this.I000000014 = aLAIndexInfoVSchema.getI000000014();
		this.I000000015 = aLAIndexInfoVSchema.getI000000015();
		this.I000000016 = aLAIndexInfoVSchema.getI000000016();
		this.I000000017 = aLAIndexInfoVSchema.getI000000017();
		this.I000000018 = aLAIndexInfoVSchema.getI000000018();
		this.I000000019 = aLAIndexInfoVSchema.getI000000019();
		this.I000000020 = aLAIndexInfoVSchema.getI000000020();
		this.I000000021 = aLAIndexInfoVSchema.getI000000021();
		this.I000000022 = aLAIndexInfoVSchema.getI000000022();
		this.I000000023 = aLAIndexInfoVSchema.getI000000023();
		this.I000000024 = aLAIndexInfoVSchema.getI000000024();
		this.I000000025 = aLAIndexInfoVSchema.getI000000025();
		this.I000000026 = aLAIndexInfoVSchema.getI000000026();
		this.I000000027 = aLAIndexInfoVSchema.getI000000027();
		this.I000000028 = aLAIndexInfoVSchema.getI000000028();
		this.I000000029 = aLAIndexInfoVSchema.getI000000029();
		this.I000000030 = aLAIndexInfoVSchema.getI000000030();
		this.I000000031 = aLAIndexInfoVSchema.getI000000031();
		this.I000000032 = aLAIndexInfoVSchema.getI000000032();
		this.I000000033 = aLAIndexInfoVSchema.getI000000033();
		this.I000000034 = aLAIndexInfoVSchema.getI000000034();
		this.I000000035 = aLAIndexInfoVSchema.getI000000035();
		this.I000000036 = aLAIndexInfoVSchema.getI000000036();
		this.I000000037 = aLAIndexInfoVSchema.getI000000037();
		this.I000000038 = aLAIndexInfoVSchema.getI000000038();
		this.I000000039 = aLAIndexInfoVSchema.getI000000039();
		this.I000000040 = aLAIndexInfoVSchema.getI000000040();
		this.I000000041 = aLAIndexInfoVSchema.getI000000041();
		this.I000000042 = aLAIndexInfoVSchema.getI000000042();
		this.I000000043 = aLAIndexInfoVSchema.getI000000043();
		this.I000000044 = aLAIndexInfoVSchema.getI000000044();
		this.I000000045 = aLAIndexInfoVSchema.getI000000045();
		this.I000000046 = aLAIndexInfoVSchema.getI000000046();
		this.I000000047 = aLAIndexInfoVSchema.getI000000047();
		this.I000000048 = aLAIndexInfoVSchema.getI000000048();
		this.I000000049 = aLAIndexInfoVSchema.getI000000049();
		this.I000000050 = aLAIndexInfoVSchema.getI000000050();
		this.I000000051 = aLAIndexInfoVSchema.getI000000051();
		this.I000000052 = aLAIndexInfoVSchema.getI000000052();
		this.I000000053 = aLAIndexInfoVSchema.getI000000053();
		this.I000000054 = aLAIndexInfoVSchema.getI000000054();
		this.I000000055 = aLAIndexInfoVSchema.getI000000055();
		this.I000000056 = aLAIndexInfoVSchema.getI000000056();
		this.I000000057 = aLAIndexInfoVSchema.getI000000057();
		this.I000000058 = aLAIndexInfoVSchema.getI000000058();
		this.I000000059 = aLAIndexInfoVSchema.getI000000059();
		this.I000000060 = aLAIndexInfoVSchema.getI000000060();
		this.I000000061 = aLAIndexInfoVSchema.getI000000061();
		this.I000000062 = aLAIndexInfoVSchema.getI000000062();
		this.I000000063 = aLAIndexInfoVSchema.getI000000063();
		this.I000000064 = aLAIndexInfoVSchema.getI000000064();
		this.I000000065 = aLAIndexInfoVSchema.getI000000065();
		this.I000000066 = aLAIndexInfoVSchema.getI000000066();
		this.I000000067 = aLAIndexInfoVSchema.getI000000067();
		this.I000000068 = aLAIndexInfoVSchema.getI000000068();
		this.I000000069 = aLAIndexInfoVSchema.getI000000069();
		this.I000000070 = aLAIndexInfoVSchema.getI000000070();
		this.I000000071 = aLAIndexInfoVSchema.getI000000071();
		this.I000000072 = aLAIndexInfoVSchema.getI000000072();
		this.I000000073 = aLAIndexInfoVSchema.getI000000073();
		this.I000000074 = aLAIndexInfoVSchema.getI000000074();
		this.I000000075 = aLAIndexInfoVSchema.getI000000075();
		this.I000000076 = aLAIndexInfoVSchema.getI000000076();
		this.I000000077 = aLAIndexInfoVSchema.getI000000077();
		this.I000000078 = aLAIndexInfoVSchema.getI000000078();
		this.I000000079 = aLAIndexInfoVSchema.getI000000079();
		this.I000000080 = aLAIndexInfoVSchema.getI000000080();
		this.I000000081 = aLAIndexInfoVSchema.getI000000081();
		this.I000000082 = aLAIndexInfoVSchema.getI000000082();
		this.I000000083 = aLAIndexInfoVSchema.getI000000083();
		this.I000000084 = aLAIndexInfoVSchema.getI000000084();
		this.I000000085 = aLAIndexInfoVSchema.getI000000085();
		this.I000000086 = aLAIndexInfoVSchema.getI000000086();
		this.I000000087 = aLAIndexInfoVSchema.getI000000087();
		this.I000000088 = aLAIndexInfoVSchema.getI000000088();
		this.I000000089 = aLAIndexInfoVSchema.getI000000089();
		this.I000000090 = aLAIndexInfoVSchema.getI000000090();
		this.I000000091 = aLAIndexInfoVSchema.getI000000091();
		this.I000000092 = aLAIndexInfoVSchema.getI000000092();
		this.I000000093 = aLAIndexInfoVSchema.getI000000093();
		this.I000000094 = aLAIndexInfoVSchema.getI000000094();
		this.I000000095 = aLAIndexInfoVSchema.getI000000095();
		this.I000000096 = aLAIndexInfoVSchema.getI000000096();
		this.I000000097 = aLAIndexInfoVSchema.getI000000097();
		this.I000000098 = aLAIndexInfoVSchema.getI000000098();
		this.I000000099 = aLAIndexInfoVSchema.getI000000099();
		this.I000000100 = aLAIndexInfoVSchema.getI000000100();
		this.I000000101 = aLAIndexInfoVSchema.getI000000101();
		this.I000000102 = aLAIndexInfoVSchema.getI000000102();
		this.I000000103 = aLAIndexInfoVSchema.getI000000103();
		this.I000000104 = aLAIndexInfoVSchema.getI000000104();
		this.I000000105 = aLAIndexInfoVSchema.getI000000105();
		this.I000000106 = aLAIndexInfoVSchema.getI000000106();
		this.I000000107 = aLAIndexInfoVSchema.getI000000107();
		this.I000000108 = aLAIndexInfoVSchema.getI000000108();
		this.I000000109 = aLAIndexInfoVSchema.getI000000109();
		this.I000000110 = aLAIndexInfoVSchema.getI000000110();
		this.I000000111 = aLAIndexInfoVSchema.getI000000111();
		this.I000000112 = aLAIndexInfoVSchema.getI000000112();
		this.I000000113 = aLAIndexInfoVSchema.getI000000113();
		this.I000000114 = aLAIndexInfoVSchema.getI000000114();
		this.I000000115 = aLAIndexInfoVSchema.getI000000115();
		this.I000000116 = aLAIndexInfoVSchema.getI000000116();
		this.I000000117 = aLAIndexInfoVSchema.getI000000117();
		this.I000000118 = aLAIndexInfoVSchema.getI000000118();
		this.I000000119 = aLAIndexInfoVSchema.getI000000119();
		this.I000000120 = aLAIndexInfoVSchema.getI000000120();
		this.I000000121 = aLAIndexInfoVSchema.getI000000121();
		this.I000000122 = aLAIndexInfoVSchema.getI000000122();
		this.I000000123 = aLAIndexInfoVSchema.getI000000123();
		this.I000000124 = aLAIndexInfoVSchema.getI000000124();
		this.I000000125 = aLAIndexInfoVSchema.getI000000125();
		this.I000000126 = aLAIndexInfoVSchema.getI000000126();
		this.I000000127 = aLAIndexInfoVSchema.getI000000127();
		this.I000000128 = aLAIndexInfoVSchema.getI000000128();
		this.I000000129 = aLAIndexInfoVSchema.getI000000129();
		this.I000000130 = aLAIndexInfoVSchema.getI000000130();
		this.I000000131 = aLAIndexInfoVSchema.getI000000131();
		this.I000000132 = aLAIndexInfoVSchema.getI000000132();
		this.I000000133 = aLAIndexInfoVSchema.getI000000133();
		this.I000000134 = aLAIndexInfoVSchema.getI000000134();
		this.I000000135 = aLAIndexInfoVSchema.getI000000135();
		this.I000000136 = aLAIndexInfoVSchema.getI000000136();
		this.I000000137 = aLAIndexInfoVSchema.getI000000137();
		this.I000000138 = aLAIndexInfoVSchema.getI000000138();
		this.I000000139 = aLAIndexInfoVSchema.getI000000139();
		this.I000000140 = aLAIndexInfoVSchema.getI000000140();
		this.I000000141 = aLAIndexInfoVSchema.getI000000141();
		this.I000000142 = aLAIndexInfoVSchema.getI000000142();
		this.I000000143 = aLAIndexInfoVSchema.getI000000143();
		this.I000000144 = aLAIndexInfoVSchema.getI000000144();
		this.I000000145 = aLAIndexInfoVSchema.getI000000145();
		this.I000000146 = aLAIndexInfoVSchema.getI000000146();
		this.I000000147 = aLAIndexInfoVSchema.getI000000147();
		this.I000000148 = aLAIndexInfoVSchema.getI000000148();
		this.I000000149 = aLAIndexInfoVSchema.getI000000149();
		this.I000000150 = aLAIndexInfoVSchema.getI000000150();
		this.I000000151 = aLAIndexInfoVSchema.getI000000151();
		this.I000000152 = aLAIndexInfoVSchema.getI000000152();
		this.I000000153 = aLAIndexInfoVSchema.getI000000153();
		this.I000000154 = aLAIndexInfoVSchema.getI000000154();
		this.I000000155 = aLAIndexInfoVSchema.getI000000155();
		this.I000000156 = aLAIndexInfoVSchema.getI000000156();
		this.I000000157 = aLAIndexInfoVSchema.getI000000157();
		this.I000000158 = aLAIndexInfoVSchema.getI000000158();
		this.I000000159 = aLAIndexInfoVSchema.getI000000159();
		this.I000000160 = aLAIndexInfoVSchema.getI000000160();
		this.I000000161 = aLAIndexInfoVSchema.getI000000161();
		this.I000000162 = aLAIndexInfoVSchema.getI000000162();
		this.I000000163 = aLAIndexInfoVSchema.getI000000163();
		this.I000000164 = aLAIndexInfoVSchema.getI000000164();
		this.I000000165 = aLAIndexInfoVSchema.getI000000165();
		this.I000000166 = aLAIndexInfoVSchema.getI000000166();
		this.I000000167 = aLAIndexInfoVSchema.getI000000167();
		this.I000000168 = aLAIndexInfoVSchema.getI000000168();
		this.I000000169 = aLAIndexInfoVSchema.getI000000169();
		this.I000000170 = aLAIndexInfoVSchema.getI000000170();
		this.I000000171 = aLAIndexInfoVSchema.getI000000171();
		this.I000000172 = aLAIndexInfoVSchema.getI000000172();
		this.I000000173 = aLAIndexInfoVSchema.getI000000173();
		this.I000000174 = aLAIndexInfoVSchema.getI000000174();
		this.I000000175 = aLAIndexInfoVSchema.getI000000175();
		this.I000000176 = aLAIndexInfoVSchema.getI000000176();
		this.I000000177 = aLAIndexInfoVSchema.getI000000177();
		this.I000000178 = aLAIndexInfoVSchema.getI000000178();
		this.I000000179 = aLAIndexInfoVSchema.getI000000179();
		this.I000000180 = aLAIndexInfoVSchema.getI000000180();
		this.I000000181 = aLAIndexInfoVSchema.getI000000181();
		this.I000000182 = aLAIndexInfoVSchema.getI000000182();
		this.I000000183 = aLAIndexInfoVSchema.getI000000183();
		this.I000000184 = aLAIndexInfoVSchema.getI000000184();
		this.I000000185 = aLAIndexInfoVSchema.getI000000185();
		this.I000000186 = aLAIndexInfoVSchema.getI000000186();
		this.I000000187 = aLAIndexInfoVSchema.getI000000187();
		this.I000000188 = aLAIndexInfoVSchema.getI000000188();
		this.I000000189 = aLAIndexInfoVSchema.getI000000189();
		this.I000000190 = aLAIndexInfoVSchema.getI000000190();
		this.I000000191 = aLAIndexInfoVSchema.getI000000191();
		this.I000000192 = aLAIndexInfoVSchema.getI000000192();
		this.I000000193 = aLAIndexInfoVSchema.getI000000193();
		this.I000000194 = aLAIndexInfoVSchema.getI000000194();
		this.I000000195 = aLAIndexInfoVSchema.getI000000195();
		this.I000000196 = aLAIndexInfoVSchema.getI000000196();
		this.I000000197 = aLAIndexInfoVSchema.getI000000197();
		this.I000000198 = aLAIndexInfoVSchema.getI000000198();
		this.I000000199 = aLAIndexInfoVSchema.getI000000199();
		this.I000000200 = aLAIndexInfoVSchema.getI000000200();
		this.R000000001 = aLAIndexInfoVSchema.getR000000001();
		this.R000000002 = aLAIndexInfoVSchema.getR000000002();
		this.R000000003 = aLAIndexInfoVSchema.getR000000003();
		this.R000000004 = aLAIndexInfoVSchema.getR000000004();
		this.R000000005 = aLAIndexInfoVSchema.getR000000005();
		this.R000000006 = aLAIndexInfoVSchema.getR000000006();
		this.R000000007 = aLAIndexInfoVSchema.getR000000007();
		this.R000000008 = aLAIndexInfoVSchema.getR000000008();
		this.R000000009 = aLAIndexInfoVSchema.getR000000009();
		this.R000000010 = aLAIndexInfoVSchema.getR000000010();
		this.R000000011 = aLAIndexInfoVSchema.getR000000011();
		this.R000000012 = aLAIndexInfoVSchema.getR000000012();
		this.R000000013 = aLAIndexInfoVSchema.getR000000013();
		this.R000000014 = aLAIndexInfoVSchema.getR000000014();
		this.R000000015 = aLAIndexInfoVSchema.getR000000015();
		this.R000000016 = aLAIndexInfoVSchema.getR000000016();
		this.R000000017 = aLAIndexInfoVSchema.getR000000017();
		this.R000000018 = aLAIndexInfoVSchema.getR000000018();
		this.R000000019 = aLAIndexInfoVSchema.getR000000019();
		this.R000000020 = aLAIndexInfoVSchema.getR000000020();
		this.R000000021 = aLAIndexInfoVSchema.getR000000021();
		this.R000000022 = aLAIndexInfoVSchema.getR000000022();
		this.R000000023 = aLAIndexInfoVSchema.getR000000023();
		this.R000000024 = aLAIndexInfoVSchema.getR000000024();
		this.R000000025 = aLAIndexInfoVSchema.getR000000025();
		this.R000000026 = aLAIndexInfoVSchema.getR000000026();
		this.R000000027 = aLAIndexInfoVSchema.getR000000027();
		this.R000000028 = aLAIndexInfoVSchema.getR000000028();
		this.R000000029 = aLAIndexInfoVSchema.getR000000029();
		this.R000000030 = aLAIndexInfoVSchema.getR000000030();
		this.R000000031 = aLAIndexInfoVSchema.getR000000031();
		this.R000000032 = aLAIndexInfoVSchema.getR000000032();
		this.R000000033 = aLAIndexInfoVSchema.getR000000033();
		this.R000000034 = aLAIndexInfoVSchema.getR000000034();
		this.R000000035 = aLAIndexInfoVSchema.getR000000035();
		this.R000000036 = aLAIndexInfoVSchema.getR000000036();
		this.R000000037 = aLAIndexInfoVSchema.getR000000037();
		this.R000000038 = aLAIndexInfoVSchema.getR000000038();
		this.R000000039 = aLAIndexInfoVSchema.getR000000039();
		this.R000000040 = aLAIndexInfoVSchema.getR000000040();
		this.R000000041 = aLAIndexInfoVSchema.getR000000041();
		this.R000000042 = aLAIndexInfoVSchema.getR000000042();
		this.R000000043 = aLAIndexInfoVSchema.getR000000043();
		this.R000000044 = aLAIndexInfoVSchema.getR000000044();
		this.R000000045 = aLAIndexInfoVSchema.getR000000045();
		this.R000000046 = aLAIndexInfoVSchema.getR000000046();
		this.R000000047 = aLAIndexInfoVSchema.getR000000047();
		this.R000000048 = aLAIndexInfoVSchema.getR000000048();
		this.R000000049 = aLAIndexInfoVSchema.getR000000049();
		this.R000000050 = aLAIndexInfoVSchema.getR000000050();
		this.R000000051 = aLAIndexInfoVSchema.getR000000051();
		this.R000000052 = aLAIndexInfoVSchema.getR000000052();
		this.R000000053 = aLAIndexInfoVSchema.getR000000053();
		this.R000000054 = aLAIndexInfoVSchema.getR000000054();
		this.R000000055 = aLAIndexInfoVSchema.getR000000055();
		this.R000000056 = aLAIndexInfoVSchema.getR000000056();
		this.R000000057 = aLAIndexInfoVSchema.getR000000057();
		this.R000000058 = aLAIndexInfoVSchema.getR000000058();
		this.R000000059 = aLAIndexInfoVSchema.getR000000059();
		this.R000000060 = aLAIndexInfoVSchema.getR000000060();
		this.R000000061 = aLAIndexInfoVSchema.getR000000061();
		this.R000000062 = aLAIndexInfoVSchema.getR000000062();
		this.R000000063 = aLAIndexInfoVSchema.getR000000063();
		this.R000000064 = aLAIndexInfoVSchema.getR000000064();
		this.R000000065 = aLAIndexInfoVSchema.getR000000065();
		this.R000000066 = aLAIndexInfoVSchema.getR000000066();
		this.R000000067 = aLAIndexInfoVSchema.getR000000067();
		this.R000000068 = aLAIndexInfoVSchema.getR000000068();
		this.R000000069 = aLAIndexInfoVSchema.getR000000069();
		this.R000000070 = aLAIndexInfoVSchema.getR000000070();
		this.R000000071 = aLAIndexInfoVSchema.getR000000071();
		this.R000000072 = aLAIndexInfoVSchema.getR000000072();
		this.R000000073 = aLAIndexInfoVSchema.getR000000073();
		this.R000000074 = aLAIndexInfoVSchema.getR000000074();
		this.R000000075 = aLAIndexInfoVSchema.getR000000075();
		this.R000000076 = aLAIndexInfoVSchema.getR000000076();
		this.R000000077 = aLAIndexInfoVSchema.getR000000077();
		this.R000000078 = aLAIndexInfoVSchema.getR000000078();
		this.R000000079 = aLAIndexInfoVSchema.getR000000079();
		this.R000000080 = aLAIndexInfoVSchema.getR000000080();
		this.R000000081 = aLAIndexInfoVSchema.getR000000081();
		this.R000000082 = aLAIndexInfoVSchema.getR000000082();
		this.R000000083 = aLAIndexInfoVSchema.getR000000083();
		this.R000000084 = aLAIndexInfoVSchema.getR000000084();
		this.R000000085 = aLAIndexInfoVSchema.getR000000085();
		this.R000000086 = aLAIndexInfoVSchema.getR000000086();
		this.R000000087 = aLAIndexInfoVSchema.getR000000087();
		this.R000000088 = aLAIndexInfoVSchema.getR000000088();
		this.R000000089 = aLAIndexInfoVSchema.getR000000089();
		this.R000000090 = aLAIndexInfoVSchema.getR000000090();
		this.R000000091 = aLAIndexInfoVSchema.getR000000091();
		this.R000000092 = aLAIndexInfoVSchema.getR000000092();
		this.R000000093 = aLAIndexInfoVSchema.getR000000093();
		this.R000000094 = aLAIndexInfoVSchema.getR000000094();
		this.R000000095 = aLAIndexInfoVSchema.getR000000095();
		this.R000000096 = aLAIndexInfoVSchema.getR000000096();
		this.R000000097 = aLAIndexInfoVSchema.getR000000097();
		this.R000000098 = aLAIndexInfoVSchema.getR000000098();
		this.R000000099 = aLAIndexInfoVSchema.getR000000099();
		this.R000000100 = aLAIndexInfoVSchema.getR000000100();
		this.R000000101 = aLAIndexInfoVSchema.getR000000101();
		this.R000000102 = aLAIndexInfoVSchema.getR000000102();
		this.R000000103 = aLAIndexInfoVSchema.getR000000103();
		this.R000000104 = aLAIndexInfoVSchema.getR000000104();
		this.R000000105 = aLAIndexInfoVSchema.getR000000105();
		this.R000000106 = aLAIndexInfoVSchema.getR000000106();
		this.R000000107 = aLAIndexInfoVSchema.getR000000107();
		this.R000000108 = aLAIndexInfoVSchema.getR000000108();
		this.R000000109 = aLAIndexInfoVSchema.getR000000109();
		this.R000000110 = aLAIndexInfoVSchema.getR000000110();
		this.R000000111 = aLAIndexInfoVSchema.getR000000111();
		this.R000000112 = aLAIndexInfoVSchema.getR000000112();
		this.R000000113 = aLAIndexInfoVSchema.getR000000113();
		this.R000000114 = aLAIndexInfoVSchema.getR000000114();
		this.R000000115 = aLAIndexInfoVSchema.getR000000115();
		this.R000000116 = aLAIndexInfoVSchema.getR000000116();
		this.R000000117 = aLAIndexInfoVSchema.getR000000117();
		this.R000000118 = aLAIndexInfoVSchema.getR000000118();
		this.R000000119 = aLAIndexInfoVSchema.getR000000119();
		this.R000000120 = aLAIndexInfoVSchema.getR000000120();
		this.R000000121 = aLAIndexInfoVSchema.getR000000121();
		this.R000000122 = aLAIndexInfoVSchema.getR000000122();
		this.R000000123 = aLAIndexInfoVSchema.getR000000123();
		this.R000000124 = aLAIndexInfoVSchema.getR000000124();
		this.R000000125 = aLAIndexInfoVSchema.getR000000125();
		this.R000000126 = aLAIndexInfoVSchema.getR000000126();
		this.R000000127 = aLAIndexInfoVSchema.getR000000127();
		this.R000000128 = aLAIndexInfoVSchema.getR000000128();
		this.R000000129 = aLAIndexInfoVSchema.getR000000129();
		this.R000000130 = aLAIndexInfoVSchema.getR000000130();
		this.R000000131 = aLAIndexInfoVSchema.getR000000131();
		this.R000000132 = aLAIndexInfoVSchema.getR000000132();
		this.R000000133 = aLAIndexInfoVSchema.getR000000133();
		this.R000000134 = aLAIndexInfoVSchema.getR000000134();
		this.R000000135 = aLAIndexInfoVSchema.getR000000135();
		this.R000000136 = aLAIndexInfoVSchema.getR000000136();
		this.R000000137 = aLAIndexInfoVSchema.getR000000137();
		this.R000000138 = aLAIndexInfoVSchema.getR000000138();
		this.R000000139 = aLAIndexInfoVSchema.getR000000139();
		this.R000000140 = aLAIndexInfoVSchema.getR000000140();
		this.R000000141 = aLAIndexInfoVSchema.getR000000141();
		this.R000000142 = aLAIndexInfoVSchema.getR000000142();
		this.R000000143 = aLAIndexInfoVSchema.getR000000143();
		this.R000000144 = aLAIndexInfoVSchema.getR000000144();
		this.R000000145 = aLAIndexInfoVSchema.getR000000145();
		this.R000000146 = aLAIndexInfoVSchema.getR000000146();
		this.R000000147 = aLAIndexInfoVSchema.getR000000147();
		this.R000000148 = aLAIndexInfoVSchema.getR000000148();
		this.R000000149 = aLAIndexInfoVSchema.getR000000149();
		this.R000000150 = aLAIndexInfoVSchema.getR000000150();
		this.R000000151 = aLAIndexInfoVSchema.getR000000151();
		this.R000000152 = aLAIndexInfoVSchema.getR000000152();
		this.R000000153 = aLAIndexInfoVSchema.getR000000153();
		this.R000000154 = aLAIndexInfoVSchema.getR000000154();
		this.R000000155 = aLAIndexInfoVSchema.getR000000155();
		this.R000000156 = aLAIndexInfoVSchema.getR000000156();
		this.R000000157 = aLAIndexInfoVSchema.getR000000157();
		this.R000000158 = aLAIndexInfoVSchema.getR000000158();
		this.R000000159 = aLAIndexInfoVSchema.getR000000159();
		this.R000000160 = aLAIndexInfoVSchema.getR000000160();
		this.R000000161 = aLAIndexInfoVSchema.getR000000161();
		this.R000000162 = aLAIndexInfoVSchema.getR000000162();
		this.R000000163 = aLAIndexInfoVSchema.getR000000163();
		this.R000000164 = aLAIndexInfoVSchema.getR000000164();
		this.R000000165 = aLAIndexInfoVSchema.getR000000165();
		this.R000000166 = aLAIndexInfoVSchema.getR000000166();
		this.R000000167 = aLAIndexInfoVSchema.getR000000167();
		this.R000000168 = aLAIndexInfoVSchema.getR000000168();
		this.R000000169 = aLAIndexInfoVSchema.getR000000169();
		this.R000000170 = aLAIndexInfoVSchema.getR000000170();
		this.R000000171 = aLAIndexInfoVSchema.getR000000171();
		this.R000000172 = aLAIndexInfoVSchema.getR000000172();
		this.R000000173 = aLAIndexInfoVSchema.getR000000173();
		this.R000000174 = aLAIndexInfoVSchema.getR000000174();
		this.R000000175 = aLAIndexInfoVSchema.getR000000175();
		this.R000000176 = aLAIndexInfoVSchema.getR000000176();
		this.R000000177 = aLAIndexInfoVSchema.getR000000177();
		this.R000000178 = aLAIndexInfoVSchema.getR000000178();
		this.R000000179 = aLAIndexInfoVSchema.getR000000179();
		this.R000000180 = aLAIndexInfoVSchema.getR000000180();
		this.R000000181 = aLAIndexInfoVSchema.getR000000181();
		this.R000000182 = aLAIndexInfoVSchema.getR000000182();
		this.R000000183 = aLAIndexInfoVSchema.getR000000183();
		this.R000000184 = aLAIndexInfoVSchema.getR000000184();
		this.R000000185 = aLAIndexInfoVSchema.getR000000185();
		this.R000000186 = aLAIndexInfoVSchema.getR000000186();
		this.R000000187 = aLAIndexInfoVSchema.getR000000187();
		this.R000000188 = aLAIndexInfoVSchema.getR000000188();
		this.R000000189 = aLAIndexInfoVSchema.getR000000189();
		this.R000000190 = aLAIndexInfoVSchema.getR000000190();
		this.R000000191 = aLAIndexInfoVSchema.getR000000191();
		this.R000000192 = aLAIndexInfoVSchema.getR000000192();
		this.R000000193 = aLAIndexInfoVSchema.getR000000193();
		this.R000000194 = aLAIndexInfoVSchema.getR000000194();
		this.R000000195 = aLAIndexInfoVSchema.getR000000195();
		this.R000000196 = aLAIndexInfoVSchema.getR000000196();
		this.R000000197 = aLAIndexInfoVSchema.getR000000197();
		this.R000000198 = aLAIndexInfoVSchema.getR000000198();
		this.R000000199 = aLAIndexInfoVSchema.getR000000199();
		this.R000000200 = aLAIndexInfoVSchema.getR000000200();
		this.I000000201 = aLAIndexInfoVSchema.getI000000201();
		this.I000000202 = aLAIndexInfoVSchema.getI000000202();
		this.I000000203 = aLAIndexInfoVSchema.getI000000203();
		this.I000000209 = aLAIndexInfoVSchema.getI000000209();
		this.I000000210 = aLAIndexInfoVSchema.getI000000210();
		this.I000000213 = aLAIndexInfoVSchema.getI000000213();
		this.I000000214 = aLAIndexInfoVSchema.getI000000214();
		this.I000000215 = aLAIndexInfoVSchema.getI000000215();
		this.I000000216 = aLAIndexInfoVSchema.getI000000216();
		this.I000000217 = aLAIndexInfoVSchema.getI000000217();
		this.I000000218 = aLAIndexInfoVSchema.getI000000218();
		this.I000000219 = aLAIndexInfoVSchema.getI000000219();
		this.I000000220 = aLAIndexInfoVSchema.getI000000220();
		this.I000000221 = aLAIndexInfoVSchema.getI000000221();
		this.I000000222 = aLAIndexInfoVSchema.getI000000222();
		this.I000000224 = aLAIndexInfoVSchema.getI000000224();
		this.I000000225 = aLAIndexInfoVSchema.getI000000225();
		this.I000000226 = aLAIndexInfoVSchema.getI000000226();
		this.I000000227 = aLAIndexInfoVSchema.getI000000227();
		this.I000000228 = aLAIndexInfoVSchema.getI000000228();
		this.I000000229 = aLAIndexInfoVSchema.getI000000229();
		this.I000000231 = aLAIndexInfoVSchema.getI000000231();
		this.I000000232 = aLAIndexInfoVSchema.getI000000232();
		this.I000000233 = aLAIndexInfoVSchema.getI000000233();
		this.I000000234 = aLAIndexInfoVSchema.getI000000234();
		this.I000000235 = aLAIndexInfoVSchema.getI000000235();
		this.I000000236 = aLAIndexInfoVSchema.getI000000236();
		this.I000000237 = aLAIndexInfoVSchema.getI000000237();
		this.I000000240 = aLAIndexInfoVSchema.getI000000240();
		this.I000000241 = aLAIndexInfoVSchema.getI000000241();
		this.I000000242 = aLAIndexInfoVSchema.getI000000242();
		this.I000000243 = aLAIndexInfoVSchema.getI000000243();
		this.I000000244 = aLAIndexInfoVSchema.getI000000244();
		this.I000000245 = aLAIndexInfoVSchema.getI000000245();
		this.I000000246 = aLAIndexInfoVSchema.getI000000246();
		this.I000000247 = aLAIndexInfoVSchema.getI000000247();
		this.I000000248 = aLAIndexInfoVSchema.getI000000248();
		this.I000000249 = aLAIndexInfoVSchema.getI000000249();
		this.I000000250 = aLAIndexInfoVSchema.getI000000250();
		this.I000000251 = aLAIndexInfoVSchema.getI000000251();
		this.R000000201 = aLAIndexInfoVSchema.getR000000201();
		this.R000000202 = aLAIndexInfoVSchema.getR000000202();
		this.R000000203 = aLAIndexInfoVSchema.getR000000203();
		this.R000000204 = aLAIndexInfoVSchema.getR000000204();
		this.R000000205 = aLAIndexInfoVSchema.getR000000205();
		this.I000000254 = aLAIndexInfoVSchema.getI000000254();
	}

	/**
	* 使用 ResultSet 中的第 i 行给 Schema 赋值
	* @param: rs ResultSet
	* @param: i int
	* @return: boolean
	**/
	public boolean setSchema(ResultSet rs,int i)
	{
		try
		{
			//rs.absolute(i);		// 非滚动游标
			if( rs.getString("WageNo") == null )
				this.WageNo = null;
			else
				this.WageNo = rs.getString("WageNo").trim();

			if( rs.getString("BranchType") == null )
				this.BranchType = null;
			else
				this.BranchType = rs.getString("BranchType").trim();

			if( rs.getString("IndexType") == null )
				this.IndexType = null;
			else
				this.IndexType = rs.getString("IndexType").trim();

			if( rs.getString("AgentCode") == null )
				this.AgentCode = null;
			else
				this.AgentCode = rs.getString("AgentCode").trim();

			if( rs.getString("AgentGrade") == null )
				this.AgentGrade = null;
			else
				this.AgentGrade = rs.getString("AgentGrade").trim();

			if( rs.getString("AgentGroup") == null )
				this.AgentGroup = null;
			else
				this.AgentGroup = rs.getString("AgentGroup").trim();

			if( rs.getString("State") == null )
				this.State = null;
			else
				this.State = rs.getString("State").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

			this.ModifyDate = rs.getDate("ModifyDate");
			if( rs.getString("ModifyTime") == null )
				this.ModifyTime = null;
			else
				this.ModifyTime = rs.getString("ModifyTime").trim();

			if( rs.getString("I000000001") == null )
				this.I000000001 = null;
			else
				this.I000000001 = rs.getString("I000000001").trim();

			if( rs.getString("I000000002") == null )
				this.I000000002 = null;
			else
				this.I000000002 = rs.getString("I000000002").trim();

			if( rs.getString("I000000003") == null )
				this.I000000003 = null;
			else
				this.I000000003 = rs.getString("I000000003").trim();

			if( rs.getString("I000000004") == null )
				this.I000000004 = null;
			else
				this.I000000004 = rs.getString("I000000004").trim();

			if( rs.getString("I000000005") == null )
				this.I000000005 = null;
			else
				this.I000000005 = rs.getString("I000000005").trim();

			if( rs.getString("I000000006") == null )
				this.I000000006 = null;
			else
				this.I000000006 = rs.getString("I000000006").trim();

			if( rs.getString("I000000007") == null )
				this.I000000007 = null;
			else
				this.I000000007 = rs.getString("I000000007").trim();

			if( rs.getString("I000000008") == null )
				this.I000000008 = null;
			else
				this.I000000008 = rs.getString("I000000008").trim();

			if( rs.getString("I000000009") == null )
				this.I000000009 = null;
			else
				this.I000000009 = rs.getString("I000000009").trim();

			if( rs.getString("I000000010") == null )
				this.I000000010 = null;
			else
				this.I000000010 = rs.getString("I000000010").trim();

			if( rs.getString("I000000011") == null )
				this.I000000011 = null;
			else
				this.I000000011 = rs.getString("I000000011").trim();

			if( rs.getString("I000000012") == null )
				this.I000000012 = null;
			else
				this.I000000012 = rs.getString("I000000012").trim();

			if( rs.getString("I000000013") == null )
				this.I000000013 = null;
			else
				this.I000000013 = rs.getString("I000000013").trim();

			if( rs.getString("I000000014") == null )
				this.I000000014 = null;
			else
				this.I000000014 = rs.getString("I000000014").trim();

			if( rs.getString("I000000015") == null )
				this.I000000015 = null;
			else
				this.I000000015 = rs.getString("I000000015").trim();

			if( rs.getString("I000000016") == null )
				this.I000000016 = null;
			else
				this.I000000016 = rs.getString("I000000016").trim();

			if( rs.getString("I000000017") == null )
				this.I000000017 = null;
			else
				this.I000000017 = rs.getString("I000000017").trim();

			if( rs.getString("I000000018") == null )
				this.I000000018 = null;
			else
				this.I000000018 = rs.getString("I000000018").trim();

			if( rs.getString("I000000019") == null )
				this.I000000019 = null;
			else
				this.I000000019 = rs.getString("I000000019").trim();

			if( rs.getString("I000000020") == null )
				this.I000000020 = null;
			else
				this.I000000020 = rs.getString("I000000020").trim();

			if( rs.getString("I000000021") == null )
				this.I000000021 = null;
			else
				this.I000000021 = rs.getString("I000000021").trim();

			if( rs.getString("I000000022") == null )
				this.I000000022 = null;
			else
				this.I000000022 = rs.getString("I000000022").trim();

			if( rs.getString("I000000023") == null )
				this.I000000023 = null;
			else
				this.I000000023 = rs.getString("I000000023").trim();

			if( rs.getString("I000000024") == null )
				this.I000000024 = null;
			else
				this.I000000024 = rs.getString("I000000024").trim();

			if( rs.getString("I000000025") == null )
				this.I000000025 = null;
			else
				this.I000000025 = rs.getString("I000000025").trim();

			if( rs.getString("I000000026") == null )
				this.I000000026 = null;
			else
				this.I000000026 = rs.getString("I000000026").trim();

			if( rs.getString("I000000027") == null )
				this.I000000027 = null;
			else
				this.I000000027 = rs.getString("I000000027").trim();

			if( rs.getString("I000000028") == null )
				this.I000000028 = null;
			else
				this.I000000028 = rs.getString("I000000028").trim();

			if( rs.getString("I000000029") == null )
				this.I000000029 = null;
			else
				this.I000000029 = rs.getString("I000000029").trim();

			if( rs.getString("I000000030") == null )
				this.I000000030 = null;
			else
				this.I000000030 = rs.getString("I000000030").trim();

			if( rs.getString("I000000031") == null )
				this.I000000031 = null;
			else
				this.I000000031 = rs.getString("I000000031").trim();

			if( rs.getString("I000000032") == null )
				this.I000000032 = null;
			else
				this.I000000032 = rs.getString("I000000032").trim();

			if( rs.getString("I000000033") == null )
				this.I000000033 = null;
			else
				this.I000000033 = rs.getString("I000000033").trim();

			if( rs.getString("I000000034") == null )
				this.I000000034 = null;
			else
				this.I000000034 = rs.getString("I000000034").trim();

			if( rs.getString("I000000035") == null )
				this.I000000035 = null;
			else
				this.I000000035 = rs.getString("I000000035").trim();

			if( rs.getString("I000000036") == null )
				this.I000000036 = null;
			else
				this.I000000036 = rs.getString("I000000036").trim();

			if( rs.getString("I000000037") == null )
				this.I000000037 = null;
			else
				this.I000000037 = rs.getString("I000000037").trim();

			if( rs.getString("I000000038") == null )
				this.I000000038 = null;
			else
				this.I000000038 = rs.getString("I000000038").trim();

			if( rs.getString("I000000039") == null )
				this.I000000039 = null;
			else
				this.I000000039 = rs.getString("I000000039").trim();

			if( rs.getString("I000000040") == null )
				this.I000000040 = null;
			else
				this.I000000040 = rs.getString("I000000040").trim();

			if( rs.getString("I000000041") == null )
				this.I000000041 = null;
			else
				this.I000000041 = rs.getString("I000000041").trim();

			if( rs.getString("I000000042") == null )
				this.I000000042 = null;
			else
				this.I000000042 = rs.getString("I000000042").trim();

			if( rs.getString("I000000043") == null )
				this.I000000043 = null;
			else
				this.I000000043 = rs.getString("I000000043").trim();

			if( rs.getString("I000000044") == null )
				this.I000000044 = null;
			else
				this.I000000044 = rs.getString("I000000044").trim();

			if( rs.getString("I000000045") == null )
				this.I000000045 = null;
			else
				this.I000000045 = rs.getString("I000000045").trim();

			if( rs.getString("I000000046") == null )
				this.I000000046 = null;
			else
				this.I000000046 = rs.getString("I000000046").trim();

			if( rs.getString("I000000047") == null )
				this.I000000047 = null;
			else
				this.I000000047 = rs.getString("I000000047").trim();

			if( rs.getString("I000000048") == null )
				this.I000000048 = null;
			else
				this.I000000048 = rs.getString("I000000048").trim();

			if( rs.getString("I000000049") == null )
				this.I000000049 = null;
			else
				this.I000000049 = rs.getString("I000000049").trim();

			if( rs.getString("I000000050") == null )
				this.I000000050 = null;
			else
				this.I000000050 = rs.getString("I000000050").trim();

			if( rs.getString("I000000051") == null )
				this.I000000051 = null;
			else
				this.I000000051 = rs.getString("I000000051").trim();

			if( rs.getString("I000000052") == null )
				this.I000000052 = null;
			else
				this.I000000052 = rs.getString("I000000052").trim();

			if( rs.getString("I000000053") == null )
				this.I000000053 = null;
			else
				this.I000000053 = rs.getString("I000000053").trim();

			if( rs.getString("I000000054") == null )
				this.I000000054 = null;
			else
				this.I000000054 = rs.getString("I000000054").trim();

			if( rs.getString("I000000055") == null )
				this.I000000055 = null;
			else
				this.I000000055 = rs.getString("I000000055").trim();

			if( rs.getString("I000000056") == null )
				this.I000000056 = null;
			else
				this.I000000056 = rs.getString("I000000056").trim();

			if( rs.getString("I000000057") == null )
				this.I000000057 = null;
			else
				this.I000000057 = rs.getString("I000000057").trim();

			if( rs.getString("I000000058") == null )
				this.I000000058 = null;
			else
				this.I000000058 = rs.getString("I000000058").trim();

			if( rs.getString("I000000059") == null )
				this.I000000059 = null;
			else
				this.I000000059 = rs.getString("I000000059").trim();

			if( rs.getString("I000000060") == null )
				this.I000000060 = null;
			else
				this.I000000060 = rs.getString("I000000060").trim();

			if( rs.getString("I000000061") == null )
				this.I000000061 = null;
			else
				this.I000000061 = rs.getString("I000000061").trim();

			if( rs.getString("I000000062") == null )
				this.I000000062 = null;
			else
				this.I000000062 = rs.getString("I000000062").trim();

			if( rs.getString("I000000063") == null )
				this.I000000063 = null;
			else
				this.I000000063 = rs.getString("I000000063").trim();

			if( rs.getString("I000000064") == null )
				this.I000000064 = null;
			else
				this.I000000064 = rs.getString("I000000064").trim();

			if( rs.getString("I000000065") == null )
				this.I000000065 = null;
			else
				this.I000000065 = rs.getString("I000000065").trim();

			if( rs.getString("I000000066") == null )
				this.I000000066 = null;
			else
				this.I000000066 = rs.getString("I000000066").trim();

			if( rs.getString("I000000067") == null )
				this.I000000067 = null;
			else
				this.I000000067 = rs.getString("I000000067").trim();

			if( rs.getString("I000000068") == null )
				this.I000000068 = null;
			else
				this.I000000068 = rs.getString("I000000068").trim();

			if( rs.getString("I000000069") == null )
				this.I000000069 = null;
			else
				this.I000000069 = rs.getString("I000000069").trim();

			if( rs.getString("I000000070") == null )
				this.I000000070 = null;
			else
				this.I000000070 = rs.getString("I000000070").trim();

			if( rs.getString("I000000071") == null )
				this.I000000071 = null;
			else
				this.I000000071 = rs.getString("I000000071").trim();

			if( rs.getString("I000000072") == null )
				this.I000000072 = null;
			else
				this.I000000072 = rs.getString("I000000072").trim();

			if( rs.getString("I000000073") == null )
				this.I000000073 = null;
			else
				this.I000000073 = rs.getString("I000000073").trim();

			if( rs.getString("I000000074") == null )
				this.I000000074 = null;
			else
				this.I000000074 = rs.getString("I000000074").trim();

			if( rs.getString("I000000075") == null )
				this.I000000075 = null;
			else
				this.I000000075 = rs.getString("I000000075").trim();

			if( rs.getString("I000000076") == null )
				this.I000000076 = null;
			else
				this.I000000076 = rs.getString("I000000076").trim();

			if( rs.getString("I000000077") == null )
				this.I000000077 = null;
			else
				this.I000000077 = rs.getString("I000000077").trim();

			if( rs.getString("I000000078") == null )
				this.I000000078 = null;
			else
				this.I000000078 = rs.getString("I000000078").trim();

			if( rs.getString("I000000079") == null )
				this.I000000079 = null;
			else
				this.I000000079 = rs.getString("I000000079").trim();

			if( rs.getString("I000000080") == null )
				this.I000000080 = null;
			else
				this.I000000080 = rs.getString("I000000080").trim();

			if( rs.getString("I000000081") == null )
				this.I000000081 = null;
			else
				this.I000000081 = rs.getString("I000000081").trim();

			if( rs.getString("I000000082") == null )
				this.I000000082 = null;
			else
				this.I000000082 = rs.getString("I000000082").trim();

			if( rs.getString("I000000083") == null )
				this.I000000083 = null;
			else
				this.I000000083 = rs.getString("I000000083").trim();

			if( rs.getString("I000000084") == null )
				this.I000000084 = null;
			else
				this.I000000084 = rs.getString("I000000084").trim();

			if( rs.getString("I000000085") == null )
				this.I000000085 = null;
			else
				this.I000000085 = rs.getString("I000000085").trim();

			if( rs.getString("I000000086") == null )
				this.I000000086 = null;
			else
				this.I000000086 = rs.getString("I000000086").trim();

			if( rs.getString("I000000087") == null )
				this.I000000087 = null;
			else
				this.I000000087 = rs.getString("I000000087").trim();

			if( rs.getString("I000000088") == null )
				this.I000000088 = null;
			else
				this.I000000088 = rs.getString("I000000088").trim();

			if( rs.getString("I000000089") == null )
				this.I000000089 = null;
			else
				this.I000000089 = rs.getString("I000000089").trim();

			if( rs.getString("I000000090") == null )
				this.I000000090 = null;
			else
				this.I000000090 = rs.getString("I000000090").trim();

			if( rs.getString("I000000091") == null )
				this.I000000091 = null;
			else
				this.I000000091 = rs.getString("I000000091").trim();

			if( rs.getString("I000000092") == null )
				this.I000000092 = null;
			else
				this.I000000092 = rs.getString("I000000092").trim();

			if( rs.getString("I000000093") == null )
				this.I000000093 = null;
			else
				this.I000000093 = rs.getString("I000000093").trim();

			if( rs.getString("I000000094") == null )
				this.I000000094 = null;
			else
				this.I000000094 = rs.getString("I000000094").trim();

			if( rs.getString("I000000095") == null )
				this.I000000095 = null;
			else
				this.I000000095 = rs.getString("I000000095").trim();

			if( rs.getString("I000000096") == null )
				this.I000000096 = null;
			else
				this.I000000096 = rs.getString("I000000096").trim();

			if( rs.getString("I000000097") == null )
				this.I000000097 = null;
			else
				this.I000000097 = rs.getString("I000000097").trim();

			if( rs.getString("I000000098") == null )
				this.I000000098 = null;
			else
				this.I000000098 = rs.getString("I000000098").trim();

			if( rs.getString("I000000099") == null )
				this.I000000099 = null;
			else
				this.I000000099 = rs.getString("I000000099").trim();

			if( rs.getString("I000000100") == null )
				this.I000000100 = null;
			else
				this.I000000100 = rs.getString("I000000100").trim();

			if( rs.getString("I000000101") == null )
				this.I000000101 = null;
			else
				this.I000000101 = rs.getString("I000000101").trim();

			if( rs.getString("I000000102") == null )
				this.I000000102 = null;
			else
				this.I000000102 = rs.getString("I000000102").trim();

			if( rs.getString("I000000103") == null )
				this.I000000103 = null;
			else
				this.I000000103 = rs.getString("I000000103").trim();

			if( rs.getString("I000000104") == null )
				this.I000000104 = null;
			else
				this.I000000104 = rs.getString("I000000104").trim();

			if( rs.getString("I000000105") == null )
				this.I000000105 = null;
			else
				this.I000000105 = rs.getString("I000000105").trim();

			if( rs.getString("I000000106") == null )
				this.I000000106 = null;
			else
				this.I000000106 = rs.getString("I000000106").trim();

			if( rs.getString("I000000107") == null )
				this.I000000107 = null;
			else
				this.I000000107 = rs.getString("I000000107").trim();

			if( rs.getString("I000000108") == null )
				this.I000000108 = null;
			else
				this.I000000108 = rs.getString("I000000108").trim();

			if( rs.getString("I000000109") == null )
				this.I000000109 = null;
			else
				this.I000000109 = rs.getString("I000000109").trim();

			if( rs.getString("I000000110") == null )
				this.I000000110 = null;
			else
				this.I000000110 = rs.getString("I000000110").trim();

			if( rs.getString("I000000111") == null )
				this.I000000111 = null;
			else
				this.I000000111 = rs.getString("I000000111").trim();

			if( rs.getString("I000000112") == null )
				this.I000000112 = null;
			else
				this.I000000112 = rs.getString("I000000112").trim();

			if( rs.getString("I000000113") == null )
				this.I000000113 = null;
			else
				this.I000000113 = rs.getString("I000000113").trim();

			if( rs.getString("I000000114") == null )
				this.I000000114 = null;
			else
				this.I000000114 = rs.getString("I000000114").trim();

			if( rs.getString("I000000115") == null )
				this.I000000115 = null;
			else
				this.I000000115 = rs.getString("I000000115").trim();

			if( rs.getString("I000000116") == null )
				this.I000000116 = null;
			else
				this.I000000116 = rs.getString("I000000116").trim();

			if( rs.getString("I000000117") == null )
				this.I000000117 = null;
			else
				this.I000000117 = rs.getString("I000000117").trim();

			if( rs.getString("I000000118") == null )
				this.I000000118 = null;
			else
				this.I000000118 = rs.getString("I000000118").trim();

			if( rs.getString("I000000119") == null )
				this.I000000119 = null;
			else
				this.I000000119 = rs.getString("I000000119").trim();

			if( rs.getString("I000000120") == null )
				this.I000000120 = null;
			else
				this.I000000120 = rs.getString("I000000120").trim();

			if( rs.getString("I000000121") == null )
				this.I000000121 = null;
			else
				this.I000000121 = rs.getString("I000000121").trim();

			if( rs.getString("I000000122") == null )
				this.I000000122 = null;
			else
				this.I000000122 = rs.getString("I000000122").trim();

			if( rs.getString("I000000123") == null )
				this.I000000123 = null;
			else
				this.I000000123 = rs.getString("I000000123").trim();

			if( rs.getString("I000000124") == null )
				this.I000000124 = null;
			else
				this.I000000124 = rs.getString("I000000124").trim();

			if( rs.getString("I000000125") == null )
				this.I000000125 = null;
			else
				this.I000000125 = rs.getString("I000000125").trim();

			if( rs.getString("I000000126") == null )
				this.I000000126 = null;
			else
				this.I000000126 = rs.getString("I000000126").trim();

			if( rs.getString("I000000127") == null )
				this.I000000127 = null;
			else
				this.I000000127 = rs.getString("I000000127").trim();

			if( rs.getString("I000000128") == null )
				this.I000000128 = null;
			else
				this.I000000128 = rs.getString("I000000128").trim();

			if( rs.getString("I000000129") == null )
				this.I000000129 = null;
			else
				this.I000000129 = rs.getString("I000000129").trim();

			if( rs.getString("I000000130") == null )
				this.I000000130 = null;
			else
				this.I000000130 = rs.getString("I000000130").trim();

			if( rs.getString("I000000131") == null )
				this.I000000131 = null;
			else
				this.I000000131 = rs.getString("I000000131").trim();

			if( rs.getString("I000000132") == null )
				this.I000000132 = null;
			else
				this.I000000132 = rs.getString("I000000132").trim();

			if( rs.getString("I000000133") == null )
				this.I000000133 = null;
			else
				this.I000000133 = rs.getString("I000000133").trim();

			if( rs.getString("I000000134") == null )
				this.I000000134 = null;
			else
				this.I000000134 = rs.getString("I000000134").trim();

			if( rs.getString("I000000135") == null )
				this.I000000135 = null;
			else
				this.I000000135 = rs.getString("I000000135").trim();

			if( rs.getString("I000000136") == null )
				this.I000000136 = null;
			else
				this.I000000136 = rs.getString("I000000136").trim();

			if( rs.getString("I000000137") == null )
				this.I000000137 = null;
			else
				this.I000000137 = rs.getString("I000000137").trim();

			if( rs.getString("I000000138") == null )
				this.I000000138 = null;
			else
				this.I000000138 = rs.getString("I000000138").trim();

			if( rs.getString("I000000139") == null )
				this.I000000139 = null;
			else
				this.I000000139 = rs.getString("I000000139").trim();

			if( rs.getString("I000000140") == null )
				this.I000000140 = null;
			else
				this.I000000140 = rs.getString("I000000140").trim();

			if( rs.getString("I000000141") == null )
				this.I000000141 = null;
			else
				this.I000000141 = rs.getString("I000000141").trim();

			if( rs.getString("I000000142") == null )
				this.I000000142 = null;
			else
				this.I000000142 = rs.getString("I000000142").trim();

			if( rs.getString("I000000143") == null )
				this.I000000143 = null;
			else
				this.I000000143 = rs.getString("I000000143").trim();

			if( rs.getString("I000000144") == null )
				this.I000000144 = null;
			else
				this.I000000144 = rs.getString("I000000144").trim();

			if( rs.getString("I000000145") == null )
				this.I000000145 = null;
			else
				this.I000000145 = rs.getString("I000000145").trim();

			if( rs.getString("I000000146") == null )
				this.I000000146 = null;
			else
				this.I000000146 = rs.getString("I000000146").trim();

			if( rs.getString("I000000147") == null )
				this.I000000147 = null;
			else
				this.I000000147 = rs.getString("I000000147").trim();

			if( rs.getString("I000000148") == null )
				this.I000000148 = null;
			else
				this.I000000148 = rs.getString("I000000148").trim();

			if( rs.getString("I000000149") == null )
				this.I000000149 = null;
			else
				this.I000000149 = rs.getString("I000000149").trim();

			if( rs.getString("I000000150") == null )
				this.I000000150 = null;
			else
				this.I000000150 = rs.getString("I000000150").trim();

			if( rs.getString("I000000151") == null )
				this.I000000151 = null;
			else
				this.I000000151 = rs.getString("I000000151").trim();

			if( rs.getString("I000000152") == null )
				this.I000000152 = null;
			else
				this.I000000152 = rs.getString("I000000152").trim();

			if( rs.getString("I000000153") == null )
				this.I000000153 = null;
			else
				this.I000000153 = rs.getString("I000000153").trim();

			if( rs.getString("I000000154") == null )
				this.I000000154 = null;
			else
				this.I000000154 = rs.getString("I000000154").trim();

			if( rs.getString("I000000155") == null )
				this.I000000155 = null;
			else
				this.I000000155 = rs.getString("I000000155").trim();

			if( rs.getString("I000000156") == null )
				this.I000000156 = null;
			else
				this.I000000156 = rs.getString("I000000156").trim();

			if( rs.getString("I000000157") == null )
				this.I000000157 = null;
			else
				this.I000000157 = rs.getString("I000000157").trim();

			if( rs.getString("I000000158") == null )
				this.I000000158 = null;
			else
				this.I000000158 = rs.getString("I000000158").trim();

			if( rs.getString("I000000159") == null )
				this.I000000159 = null;
			else
				this.I000000159 = rs.getString("I000000159").trim();

			if( rs.getString("I000000160") == null )
				this.I000000160 = null;
			else
				this.I000000160 = rs.getString("I000000160").trim();

			if( rs.getString("I000000161") == null )
				this.I000000161 = null;
			else
				this.I000000161 = rs.getString("I000000161").trim();

			if( rs.getString("I000000162") == null )
				this.I000000162 = null;
			else
				this.I000000162 = rs.getString("I000000162").trim();

			if( rs.getString("I000000163") == null )
				this.I000000163 = null;
			else
				this.I000000163 = rs.getString("I000000163").trim();

			if( rs.getString("I000000164") == null )
				this.I000000164 = null;
			else
				this.I000000164 = rs.getString("I000000164").trim();

			if( rs.getString("I000000165") == null )
				this.I000000165 = null;
			else
				this.I000000165 = rs.getString("I000000165").trim();

			if( rs.getString("I000000166") == null )
				this.I000000166 = null;
			else
				this.I000000166 = rs.getString("I000000166").trim();

			if( rs.getString("I000000167") == null )
				this.I000000167 = null;
			else
				this.I000000167 = rs.getString("I000000167").trim();

			if( rs.getString("I000000168") == null )
				this.I000000168 = null;
			else
				this.I000000168 = rs.getString("I000000168").trim();

			if( rs.getString("I000000169") == null )
				this.I000000169 = null;
			else
				this.I000000169 = rs.getString("I000000169").trim();

			if( rs.getString("I000000170") == null )
				this.I000000170 = null;
			else
				this.I000000170 = rs.getString("I000000170").trim();

			if( rs.getString("I000000171") == null )
				this.I000000171 = null;
			else
				this.I000000171 = rs.getString("I000000171").trim();

			if( rs.getString("I000000172") == null )
				this.I000000172 = null;
			else
				this.I000000172 = rs.getString("I000000172").trim();

			if( rs.getString("I000000173") == null )
				this.I000000173 = null;
			else
				this.I000000173 = rs.getString("I000000173").trim();

			if( rs.getString("I000000174") == null )
				this.I000000174 = null;
			else
				this.I000000174 = rs.getString("I000000174").trim();

			if( rs.getString("I000000175") == null )
				this.I000000175 = null;
			else
				this.I000000175 = rs.getString("I000000175").trim();

			if( rs.getString("I000000176") == null )
				this.I000000176 = null;
			else
				this.I000000176 = rs.getString("I000000176").trim();

			if( rs.getString("I000000177") == null )
				this.I000000177 = null;
			else
				this.I000000177 = rs.getString("I000000177").trim();

			if( rs.getString("I000000178") == null )
				this.I000000178 = null;
			else
				this.I000000178 = rs.getString("I000000178").trim();

			if( rs.getString("I000000179") == null )
				this.I000000179 = null;
			else
				this.I000000179 = rs.getString("I000000179").trim();

			if( rs.getString("I000000180") == null )
				this.I000000180 = null;
			else
				this.I000000180 = rs.getString("I000000180").trim();

			if( rs.getString("I000000181") == null )
				this.I000000181 = null;
			else
				this.I000000181 = rs.getString("I000000181").trim();

			if( rs.getString("I000000182") == null )
				this.I000000182 = null;
			else
				this.I000000182 = rs.getString("I000000182").trim();

			if( rs.getString("I000000183") == null )
				this.I000000183 = null;
			else
				this.I000000183 = rs.getString("I000000183").trim();

			if( rs.getString("I000000184") == null )
				this.I000000184 = null;
			else
				this.I000000184 = rs.getString("I000000184").trim();

			if( rs.getString("I000000185") == null )
				this.I000000185 = null;
			else
				this.I000000185 = rs.getString("I000000185").trim();

			if( rs.getString("I000000186") == null )
				this.I000000186 = null;
			else
				this.I000000186 = rs.getString("I000000186").trim();

			if( rs.getString("I000000187") == null )
				this.I000000187 = null;
			else
				this.I000000187 = rs.getString("I000000187").trim();

			if( rs.getString("I000000188") == null )
				this.I000000188 = null;
			else
				this.I000000188 = rs.getString("I000000188").trim();

			if( rs.getString("I000000189") == null )
				this.I000000189 = null;
			else
				this.I000000189 = rs.getString("I000000189").trim();

			if( rs.getString("I000000190") == null )
				this.I000000190 = null;
			else
				this.I000000190 = rs.getString("I000000190").trim();

			if( rs.getString("I000000191") == null )
				this.I000000191 = null;
			else
				this.I000000191 = rs.getString("I000000191").trim();

			if( rs.getString("I000000192") == null )
				this.I000000192 = null;
			else
				this.I000000192 = rs.getString("I000000192").trim();

			if( rs.getString("I000000193") == null )
				this.I000000193 = null;
			else
				this.I000000193 = rs.getString("I000000193").trim();

			if( rs.getString("I000000194") == null )
				this.I000000194 = null;
			else
				this.I000000194 = rs.getString("I000000194").trim();

			if( rs.getString("I000000195") == null )
				this.I000000195 = null;
			else
				this.I000000195 = rs.getString("I000000195").trim();

			if( rs.getString("I000000196") == null )
				this.I000000196 = null;
			else
				this.I000000196 = rs.getString("I000000196").trim();

			if( rs.getString("I000000197") == null )
				this.I000000197 = null;
			else
				this.I000000197 = rs.getString("I000000197").trim();

			if( rs.getString("I000000198") == null )
				this.I000000198 = null;
			else
				this.I000000198 = rs.getString("I000000198").trim();

			if( rs.getString("I000000199") == null )
				this.I000000199 = null;
			else
				this.I000000199 = rs.getString("I000000199").trim();

			if( rs.getString("I000000200") == null )
				this.I000000200 = null;
			else
				this.I000000200 = rs.getString("I000000200").trim();

			if( rs.getString("R000000001") == null )
				this.R000000001 = null;
			else
				this.R000000001 = rs.getString("R000000001").trim();

			if( rs.getString("R000000002") == null )
				this.R000000002 = null;
			else
				this.R000000002 = rs.getString("R000000002").trim();

			if( rs.getString("R000000003") == null )
				this.R000000003 = null;
			else
				this.R000000003 = rs.getString("R000000003").trim();

			if( rs.getString("R000000004") == null )
				this.R000000004 = null;
			else
				this.R000000004 = rs.getString("R000000004").trim();

			if( rs.getString("R000000005") == null )
				this.R000000005 = null;
			else
				this.R000000005 = rs.getString("R000000005").trim();

			if( rs.getString("R000000006") == null )
				this.R000000006 = null;
			else
				this.R000000006 = rs.getString("R000000006").trim();

			if( rs.getString("R000000007") == null )
				this.R000000007 = null;
			else
				this.R000000007 = rs.getString("R000000007").trim();

			if( rs.getString("R000000008") == null )
				this.R000000008 = null;
			else
				this.R000000008 = rs.getString("R000000008").trim();

			if( rs.getString("R000000009") == null )
				this.R000000009 = null;
			else
				this.R000000009 = rs.getString("R000000009").trim();

			if( rs.getString("R000000010") == null )
				this.R000000010 = null;
			else
				this.R000000010 = rs.getString("R000000010").trim();

			if( rs.getString("R000000011") == null )
				this.R000000011 = null;
			else
				this.R000000011 = rs.getString("R000000011").trim();

			if( rs.getString("R000000012") == null )
				this.R000000012 = null;
			else
				this.R000000012 = rs.getString("R000000012").trim();

			if( rs.getString("R000000013") == null )
				this.R000000013 = null;
			else
				this.R000000013 = rs.getString("R000000013").trim();

			if( rs.getString("R000000014") == null )
				this.R000000014 = null;
			else
				this.R000000014 = rs.getString("R000000014").trim();

			if( rs.getString("R000000015") == null )
				this.R000000015 = null;
			else
				this.R000000015 = rs.getString("R000000015").trim();

			if( rs.getString("R000000016") == null )
				this.R000000016 = null;
			else
				this.R000000016 = rs.getString("R000000016").trim();

			if( rs.getString("R000000017") == null )
				this.R000000017 = null;
			else
				this.R000000017 = rs.getString("R000000017").trim();

			if( rs.getString("R000000018") == null )
				this.R000000018 = null;
			else
				this.R000000018 = rs.getString("R000000018").trim();

			if( rs.getString("R000000019") == null )
				this.R000000019 = null;
			else
				this.R000000019 = rs.getString("R000000019").trim();

			if( rs.getString("R000000020") == null )
				this.R000000020 = null;
			else
				this.R000000020 = rs.getString("R000000020").trim();

			if( rs.getString("R000000021") == null )
				this.R000000021 = null;
			else
				this.R000000021 = rs.getString("R000000021").trim();

			if( rs.getString("R000000022") == null )
				this.R000000022 = null;
			else
				this.R000000022 = rs.getString("R000000022").trim();

			if( rs.getString("R000000023") == null )
				this.R000000023 = null;
			else
				this.R000000023 = rs.getString("R000000023").trim();

			if( rs.getString("R000000024") == null )
				this.R000000024 = null;
			else
				this.R000000024 = rs.getString("R000000024").trim();

			if( rs.getString("R000000025") == null )
				this.R000000025 = null;
			else
				this.R000000025 = rs.getString("R000000025").trim();

			if( rs.getString("R000000026") == null )
				this.R000000026 = null;
			else
				this.R000000026 = rs.getString("R000000026").trim();

			if( rs.getString("R000000027") == null )
				this.R000000027 = null;
			else
				this.R000000027 = rs.getString("R000000027").trim();

			if( rs.getString("R000000028") == null )
				this.R000000028 = null;
			else
				this.R000000028 = rs.getString("R000000028").trim();

			if( rs.getString("R000000029") == null )
				this.R000000029 = null;
			else
				this.R000000029 = rs.getString("R000000029").trim();

			if( rs.getString("R000000030") == null )
				this.R000000030 = null;
			else
				this.R000000030 = rs.getString("R000000030").trim();

			if( rs.getString("R000000031") == null )
				this.R000000031 = null;
			else
				this.R000000031 = rs.getString("R000000031").trim();

			if( rs.getString("R000000032") == null )
				this.R000000032 = null;
			else
				this.R000000032 = rs.getString("R000000032").trim();

			if( rs.getString("R000000033") == null )
				this.R000000033 = null;
			else
				this.R000000033 = rs.getString("R000000033").trim();

			if( rs.getString("R000000034") == null )
				this.R000000034 = null;
			else
				this.R000000034 = rs.getString("R000000034").trim();

			if( rs.getString("R000000035") == null )
				this.R000000035 = null;
			else
				this.R000000035 = rs.getString("R000000035").trim();

			if( rs.getString("R000000036") == null )
				this.R000000036 = null;
			else
				this.R000000036 = rs.getString("R000000036").trim();

			if( rs.getString("R000000037") == null )
				this.R000000037 = null;
			else
				this.R000000037 = rs.getString("R000000037").trim();

			if( rs.getString("R000000038") == null )
				this.R000000038 = null;
			else
				this.R000000038 = rs.getString("R000000038").trim();

			if( rs.getString("R000000039") == null )
				this.R000000039 = null;
			else
				this.R000000039 = rs.getString("R000000039").trim();

			if( rs.getString("R000000040") == null )
				this.R000000040 = null;
			else
				this.R000000040 = rs.getString("R000000040").trim();

			if( rs.getString("R000000041") == null )
				this.R000000041 = null;
			else
				this.R000000041 = rs.getString("R000000041").trim();

			if( rs.getString("R000000042") == null )
				this.R000000042 = null;
			else
				this.R000000042 = rs.getString("R000000042").trim();

			if( rs.getString("R000000043") == null )
				this.R000000043 = null;
			else
				this.R000000043 = rs.getString("R000000043").trim();

			if( rs.getString("R000000044") == null )
				this.R000000044 = null;
			else
				this.R000000044 = rs.getString("R000000044").trim();

			if( rs.getString("R000000045") == null )
				this.R000000045 = null;
			else
				this.R000000045 = rs.getString("R000000045").trim();

			if( rs.getString("R000000046") == null )
				this.R000000046 = null;
			else
				this.R000000046 = rs.getString("R000000046").trim();

			if( rs.getString("R000000047") == null )
				this.R000000047 = null;
			else
				this.R000000047 = rs.getString("R000000047").trim();

			if( rs.getString("R000000048") == null )
				this.R000000048 = null;
			else
				this.R000000048 = rs.getString("R000000048").trim();

			if( rs.getString("R000000049") == null )
				this.R000000049 = null;
			else
				this.R000000049 = rs.getString("R000000049").trim();

			if( rs.getString("R000000050") == null )
				this.R000000050 = null;
			else
				this.R000000050 = rs.getString("R000000050").trim();

			if( rs.getString("R000000051") == null )
				this.R000000051 = null;
			else
				this.R000000051 = rs.getString("R000000051").trim();

			if( rs.getString("R000000052") == null )
				this.R000000052 = null;
			else
				this.R000000052 = rs.getString("R000000052").trim();

			if( rs.getString("R000000053") == null )
				this.R000000053 = null;
			else
				this.R000000053 = rs.getString("R000000053").trim();

			if( rs.getString("R000000054") == null )
				this.R000000054 = null;
			else
				this.R000000054 = rs.getString("R000000054").trim();

			if( rs.getString("R000000055") == null )
				this.R000000055 = null;
			else
				this.R000000055 = rs.getString("R000000055").trim();

			if( rs.getString("R000000056") == null )
				this.R000000056 = null;
			else
				this.R000000056 = rs.getString("R000000056").trim();

			if( rs.getString("R000000057") == null )
				this.R000000057 = null;
			else
				this.R000000057 = rs.getString("R000000057").trim();

			if( rs.getString("R000000058") == null )
				this.R000000058 = null;
			else
				this.R000000058 = rs.getString("R000000058").trim();

			if( rs.getString("R000000059") == null )
				this.R000000059 = null;
			else
				this.R000000059 = rs.getString("R000000059").trim();

			if( rs.getString("R000000060") == null )
				this.R000000060 = null;
			else
				this.R000000060 = rs.getString("R000000060").trim();

			if( rs.getString("R000000061") == null )
				this.R000000061 = null;
			else
				this.R000000061 = rs.getString("R000000061").trim();

			if( rs.getString("R000000062") == null )
				this.R000000062 = null;
			else
				this.R000000062 = rs.getString("R000000062").trim();

			if( rs.getString("R000000063") == null )
				this.R000000063 = null;
			else
				this.R000000063 = rs.getString("R000000063").trim();

			if( rs.getString("R000000064") == null )
				this.R000000064 = null;
			else
				this.R000000064 = rs.getString("R000000064").trim();

			if( rs.getString("R000000065") == null )
				this.R000000065 = null;
			else
				this.R000000065 = rs.getString("R000000065").trim();

			if( rs.getString("R000000066") == null )
				this.R000000066 = null;
			else
				this.R000000066 = rs.getString("R000000066").trim();

			if( rs.getString("R000000067") == null )
				this.R000000067 = null;
			else
				this.R000000067 = rs.getString("R000000067").trim();

			if( rs.getString("R000000068") == null )
				this.R000000068 = null;
			else
				this.R000000068 = rs.getString("R000000068").trim();

			if( rs.getString("R000000069") == null )
				this.R000000069 = null;
			else
				this.R000000069 = rs.getString("R000000069").trim();

			if( rs.getString("R000000070") == null )
				this.R000000070 = null;
			else
				this.R000000070 = rs.getString("R000000070").trim();

			if( rs.getString("R000000071") == null )
				this.R000000071 = null;
			else
				this.R000000071 = rs.getString("R000000071").trim();

			if( rs.getString("R000000072") == null )
				this.R000000072 = null;
			else
				this.R000000072 = rs.getString("R000000072").trim();

			if( rs.getString("R000000073") == null )
				this.R000000073 = null;
			else
				this.R000000073 = rs.getString("R000000073").trim();

			if( rs.getString("R000000074") == null )
				this.R000000074 = null;
			else
				this.R000000074 = rs.getString("R000000074").trim();

			if( rs.getString("R000000075") == null )
				this.R000000075 = null;
			else
				this.R000000075 = rs.getString("R000000075").trim();

			if( rs.getString("R000000076") == null )
				this.R000000076 = null;
			else
				this.R000000076 = rs.getString("R000000076").trim();

			if( rs.getString("R000000077") == null )
				this.R000000077 = null;
			else
				this.R000000077 = rs.getString("R000000077").trim();

			if( rs.getString("R000000078") == null )
				this.R000000078 = null;
			else
				this.R000000078 = rs.getString("R000000078").trim();

			if( rs.getString("R000000079") == null )
				this.R000000079 = null;
			else
				this.R000000079 = rs.getString("R000000079").trim();

			if( rs.getString("R000000080") == null )
				this.R000000080 = null;
			else
				this.R000000080 = rs.getString("R000000080").trim();

			if( rs.getString("R000000081") == null )
				this.R000000081 = null;
			else
				this.R000000081 = rs.getString("R000000081").trim();

			if( rs.getString("R000000082") == null )
				this.R000000082 = null;
			else
				this.R000000082 = rs.getString("R000000082").trim();

			if( rs.getString("R000000083") == null )
				this.R000000083 = null;
			else
				this.R000000083 = rs.getString("R000000083").trim();

			if( rs.getString("R000000084") == null )
				this.R000000084 = null;
			else
				this.R000000084 = rs.getString("R000000084").trim();

			if( rs.getString("R000000085") == null )
				this.R000000085 = null;
			else
				this.R000000085 = rs.getString("R000000085").trim();

			if( rs.getString("R000000086") == null )
				this.R000000086 = null;
			else
				this.R000000086 = rs.getString("R000000086").trim();

			if( rs.getString("R000000087") == null )
				this.R000000087 = null;
			else
				this.R000000087 = rs.getString("R000000087").trim();

			if( rs.getString("R000000088") == null )
				this.R000000088 = null;
			else
				this.R000000088 = rs.getString("R000000088").trim();

			if( rs.getString("R000000089") == null )
				this.R000000089 = null;
			else
				this.R000000089 = rs.getString("R000000089").trim();

			if( rs.getString("R000000090") == null )
				this.R000000090 = null;
			else
				this.R000000090 = rs.getString("R000000090").trim();

			if( rs.getString("R000000091") == null )
				this.R000000091 = null;
			else
				this.R000000091 = rs.getString("R000000091").trim();

			if( rs.getString("R000000092") == null )
				this.R000000092 = null;
			else
				this.R000000092 = rs.getString("R000000092").trim();

			if( rs.getString("R000000093") == null )
				this.R000000093 = null;
			else
				this.R000000093 = rs.getString("R000000093").trim();

			if( rs.getString("R000000094") == null )
				this.R000000094 = null;
			else
				this.R000000094 = rs.getString("R000000094").trim();

			if( rs.getString("R000000095") == null )
				this.R000000095 = null;
			else
				this.R000000095 = rs.getString("R000000095").trim();

			if( rs.getString("R000000096") == null )
				this.R000000096 = null;
			else
				this.R000000096 = rs.getString("R000000096").trim();

			if( rs.getString("R000000097") == null )
				this.R000000097 = null;
			else
				this.R000000097 = rs.getString("R000000097").trim();

			if( rs.getString("R000000098") == null )
				this.R000000098 = null;
			else
				this.R000000098 = rs.getString("R000000098").trim();

			if( rs.getString("R000000099") == null )
				this.R000000099 = null;
			else
				this.R000000099 = rs.getString("R000000099").trim();

			if( rs.getString("R000000100") == null )
				this.R000000100 = null;
			else
				this.R000000100 = rs.getString("R000000100").trim();

			if( rs.getString("R000000101") == null )
				this.R000000101 = null;
			else
				this.R000000101 = rs.getString("R000000101").trim();

			if( rs.getString("R000000102") == null )
				this.R000000102 = null;
			else
				this.R000000102 = rs.getString("R000000102").trim();

			if( rs.getString("R000000103") == null )
				this.R000000103 = null;
			else
				this.R000000103 = rs.getString("R000000103").trim();

			if( rs.getString("R000000104") == null )
				this.R000000104 = null;
			else
				this.R000000104 = rs.getString("R000000104").trim();

			if( rs.getString("R000000105") == null )
				this.R000000105 = null;
			else
				this.R000000105 = rs.getString("R000000105").trim();

			if( rs.getString("R000000106") == null )
				this.R000000106 = null;
			else
				this.R000000106 = rs.getString("R000000106").trim();

			if( rs.getString("R000000107") == null )
				this.R000000107 = null;
			else
				this.R000000107 = rs.getString("R000000107").trim();

			if( rs.getString("R000000108") == null )
				this.R000000108 = null;
			else
				this.R000000108 = rs.getString("R000000108").trim();

			if( rs.getString("R000000109") == null )
				this.R000000109 = null;
			else
				this.R000000109 = rs.getString("R000000109").trim();

			if( rs.getString("R000000110") == null )
				this.R000000110 = null;
			else
				this.R000000110 = rs.getString("R000000110").trim();

			if( rs.getString("R000000111") == null )
				this.R000000111 = null;
			else
				this.R000000111 = rs.getString("R000000111").trim();

			if( rs.getString("R000000112") == null )
				this.R000000112 = null;
			else
				this.R000000112 = rs.getString("R000000112").trim();

			if( rs.getString("R000000113") == null )
				this.R000000113 = null;
			else
				this.R000000113 = rs.getString("R000000113").trim();

			if( rs.getString("R000000114") == null )
				this.R000000114 = null;
			else
				this.R000000114 = rs.getString("R000000114").trim();

			if( rs.getString("R000000115") == null )
				this.R000000115 = null;
			else
				this.R000000115 = rs.getString("R000000115").trim();

			if( rs.getString("R000000116") == null )
				this.R000000116 = null;
			else
				this.R000000116 = rs.getString("R000000116").trim();

			if( rs.getString("R000000117") == null )
				this.R000000117 = null;
			else
				this.R000000117 = rs.getString("R000000117").trim();

			if( rs.getString("R000000118") == null )
				this.R000000118 = null;
			else
				this.R000000118 = rs.getString("R000000118").trim();

			if( rs.getString("R000000119") == null )
				this.R000000119 = null;
			else
				this.R000000119 = rs.getString("R000000119").trim();

			if( rs.getString("R000000120") == null )
				this.R000000120 = null;
			else
				this.R000000120 = rs.getString("R000000120").trim();

			if( rs.getString("R000000121") == null )
				this.R000000121 = null;
			else
				this.R000000121 = rs.getString("R000000121").trim();

			if( rs.getString("R000000122") == null )
				this.R000000122 = null;
			else
				this.R000000122 = rs.getString("R000000122").trim();

			if( rs.getString("R000000123") == null )
				this.R000000123 = null;
			else
				this.R000000123 = rs.getString("R000000123").trim();

			if( rs.getString("R000000124") == null )
				this.R000000124 = null;
			else
				this.R000000124 = rs.getString("R000000124").trim();

			if( rs.getString("R000000125") == null )
				this.R000000125 = null;
			else
				this.R000000125 = rs.getString("R000000125").trim();

			if( rs.getString("R000000126") == null )
				this.R000000126 = null;
			else
				this.R000000126 = rs.getString("R000000126").trim();

			if( rs.getString("R000000127") == null )
				this.R000000127 = null;
			else
				this.R000000127 = rs.getString("R000000127").trim();

			if( rs.getString("R000000128") == null )
				this.R000000128 = null;
			else
				this.R000000128 = rs.getString("R000000128").trim();

			if( rs.getString("R000000129") == null )
				this.R000000129 = null;
			else
				this.R000000129 = rs.getString("R000000129").trim();

			if( rs.getString("R000000130") == null )
				this.R000000130 = null;
			else
				this.R000000130 = rs.getString("R000000130").trim();

			if( rs.getString("R000000131") == null )
				this.R000000131 = null;
			else
				this.R000000131 = rs.getString("R000000131").trim();

			if( rs.getString("R000000132") == null )
				this.R000000132 = null;
			else
				this.R000000132 = rs.getString("R000000132").trim();

			if( rs.getString("R000000133") == null )
				this.R000000133 = null;
			else
				this.R000000133 = rs.getString("R000000133").trim();

			if( rs.getString("R000000134") == null )
				this.R000000134 = null;
			else
				this.R000000134 = rs.getString("R000000134").trim();

			if( rs.getString("R000000135") == null )
				this.R000000135 = null;
			else
				this.R000000135 = rs.getString("R000000135").trim();

			if( rs.getString("R000000136") == null )
				this.R000000136 = null;
			else
				this.R000000136 = rs.getString("R000000136").trim();

			if( rs.getString("R000000137") == null )
				this.R000000137 = null;
			else
				this.R000000137 = rs.getString("R000000137").trim();

			if( rs.getString("R000000138") == null )
				this.R000000138 = null;
			else
				this.R000000138 = rs.getString("R000000138").trim();

			if( rs.getString("R000000139") == null )
				this.R000000139 = null;
			else
				this.R000000139 = rs.getString("R000000139").trim();

			if( rs.getString("R000000140") == null )
				this.R000000140 = null;
			else
				this.R000000140 = rs.getString("R000000140").trim();

			if( rs.getString("R000000141") == null )
				this.R000000141 = null;
			else
				this.R000000141 = rs.getString("R000000141").trim();

			if( rs.getString("R000000142") == null )
				this.R000000142 = null;
			else
				this.R000000142 = rs.getString("R000000142").trim();

			if( rs.getString("R000000143") == null )
				this.R000000143 = null;
			else
				this.R000000143 = rs.getString("R000000143").trim();

			if( rs.getString("R000000144") == null )
				this.R000000144 = null;
			else
				this.R000000144 = rs.getString("R000000144").trim();

			if( rs.getString("R000000145") == null )
				this.R000000145 = null;
			else
				this.R000000145 = rs.getString("R000000145").trim();

			if( rs.getString("R000000146") == null )
				this.R000000146 = null;
			else
				this.R000000146 = rs.getString("R000000146").trim();

			if( rs.getString("R000000147") == null )
				this.R000000147 = null;
			else
				this.R000000147 = rs.getString("R000000147").trim();

			if( rs.getString("R000000148") == null )
				this.R000000148 = null;
			else
				this.R000000148 = rs.getString("R000000148").trim();

			if( rs.getString("R000000149") == null )
				this.R000000149 = null;
			else
				this.R000000149 = rs.getString("R000000149").trim();

			if( rs.getString("R000000150") == null )
				this.R000000150 = null;
			else
				this.R000000150 = rs.getString("R000000150").trim();

			if( rs.getString("R000000151") == null )
				this.R000000151 = null;
			else
				this.R000000151 = rs.getString("R000000151").trim();

			if( rs.getString("R000000152") == null )
				this.R000000152 = null;
			else
				this.R000000152 = rs.getString("R000000152").trim();

			if( rs.getString("R000000153") == null )
				this.R000000153 = null;
			else
				this.R000000153 = rs.getString("R000000153").trim();

			if( rs.getString("R000000154") == null )
				this.R000000154 = null;
			else
				this.R000000154 = rs.getString("R000000154").trim();

			if( rs.getString("R000000155") == null )
				this.R000000155 = null;
			else
				this.R000000155 = rs.getString("R000000155").trim();

			if( rs.getString("R000000156") == null )
				this.R000000156 = null;
			else
				this.R000000156 = rs.getString("R000000156").trim();

			if( rs.getString("R000000157") == null )
				this.R000000157 = null;
			else
				this.R000000157 = rs.getString("R000000157").trim();

			if( rs.getString("R000000158") == null )
				this.R000000158 = null;
			else
				this.R000000158 = rs.getString("R000000158").trim();

			if( rs.getString("R000000159") == null )
				this.R000000159 = null;
			else
				this.R000000159 = rs.getString("R000000159").trim();

			if( rs.getString("R000000160") == null )
				this.R000000160 = null;
			else
				this.R000000160 = rs.getString("R000000160").trim();

			if( rs.getString("R000000161") == null )
				this.R000000161 = null;
			else
				this.R000000161 = rs.getString("R000000161").trim();

			if( rs.getString("R000000162") == null )
				this.R000000162 = null;
			else
				this.R000000162 = rs.getString("R000000162").trim();

			if( rs.getString("R000000163") == null )
				this.R000000163 = null;
			else
				this.R000000163 = rs.getString("R000000163").trim();

			if( rs.getString("R000000164") == null )
				this.R000000164 = null;
			else
				this.R000000164 = rs.getString("R000000164").trim();

			if( rs.getString("R000000165") == null )
				this.R000000165 = null;
			else
				this.R000000165 = rs.getString("R000000165").trim();

			if( rs.getString("R000000166") == null )
				this.R000000166 = null;
			else
				this.R000000166 = rs.getString("R000000166").trim();

			if( rs.getString("R000000167") == null )
				this.R000000167 = null;
			else
				this.R000000167 = rs.getString("R000000167").trim();

			if( rs.getString("R000000168") == null )
				this.R000000168 = null;
			else
				this.R000000168 = rs.getString("R000000168").trim();

			if( rs.getString("R000000169") == null )
				this.R000000169 = null;
			else
				this.R000000169 = rs.getString("R000000169").trim();

			if( rs.getString("R000000170") == null )
				this.R000000170 = null;
			else
				this.R000000170 = rs.getString("R000000170").trim();

			if( rs.getString("R000000171") == null )
				this.R000000171 = null;
			else
				this.R000000171 = rs.getString("R000000171").trim();

			if( rs.getString("R000000172") == null )
				this.R000000172 = null;
			else
				this.R000000172 = rs.getString("R000000172").trim();

			if( rs.getString("R000000173") == null )
				this.R000000173 = null;
			else
				this.R000000173 = rs.getString("R000000173").trim();

			if( rs.getString("R000000174") == null )
				this.R000000174 = null;
			else
				this.R000000174 = rs.getString("R000000174").trim();

			if( rs.getString("R000000175") == null )
				this.R000000175 = null;
			else
				this.R000000175 = rs.getString("R000000175").trim();

			if( rs.getString("R000000176") == null )
				this.R000000176 = null;
			else
				this.R000000176 = rs.getString("R000000176").trim();

			if( rs.getString("R000000177") == null )
				this.R000000177 = null;
			else
				this.R000000177 = rs.getString("R000000177").trim();

			if( rs.getString("R000000178") == null )
				this.R000000178 = null;
			else
				this.R000000178 = rs.getString("R000000178").trim();

			if( rs.getString("R000000179") == null )
				this.R000000179 = null;
			else
				this.R000000179 = rs.getString("R000000179").trim();

			if( rs.getString("R000000180") == null )
				this.R000000180 = null;
			else
				this.R000000180 = rs.getString("R000000180").trim();

			if( rs.getString("R000000181") == null )
				this.R000000181 = null;
			else
				this.R000000181 = rs.getString("R000000181").trim();

			if( rs.getString("R000000182") == null )
				this.R000000182 = null;
			else
				this.R000000182 = rs.getString("R000000182").trim();

			if( rs.getString("R000000183") == null )
				this.R000000183 = null;
			else
				this.R000000183 = rs.getString("R000000183").trim();

			if( rs.getString("R000000184") == null )
				this.R000000184 = null;
			else
				this.R000000184 = rs.getString("R000000184").trim();

			if( rs.getString("R000000185") == null )
				this.R000000185 = null;
			else
				this.R000000185 = rs.getString("R000000185").trim();

			if( rs.getString("R000000186") == null )
				this.R000000186 = null;
			else
				this.R000000186 = rs.getString("R000000186").trim();

			if( rs.getString("R000000187") == null )
				this.R000000187 = null;
			else
				this.R000000187 = rs.getString("R000000187").trim();

			if( rs.getString("R000000188") == null )
				this.R000000188 = null;
			else
				this.R000000188 = rs.getString("R000000188").trim();

			if( rs.getString("R000000189") == null )
				this.R000000189 = null;
			else
				this.R000000189 = rs.getString("R000000189").trim();

			if( rs.getString("R000000190") == null )
				this.R000000190 = null;
			else
				this.R000000190 = rs.getString("R000000190").trim();

			if( rs.getString("R000000191") == null )
				this.R000000191 = null;
			else
				this.R000000191 = rs.getString("R000000191").trim();

			if( rs.getString("R000000192") == null )
				this.R000000192 = null;
			else
				this.R000000192 = rs.getString("R000000192").trim();

			if( rs.getString("R000000193") == null )
				this.R000000193 = null;
			else
				this.R000000193 = rs.getString("R000000193").trim();

			if( rs.getString("R000000194") == null )
				this.R000000194 = null;
			else
				this.R000000194 = rs.getString("R000000194").trim();

			if( rs.getString("R000000195") == null )
				this.R000000195 = null;
			else
				this.R000000195 = rs.getString("R000000195").trim();

			if( rs.getString("R000000196") == null )
				this.R000000196 = null;
			else
				this.R000000196 = rs.getString("R000000196").trim();

			if( rs.getString("R000000197") == null )
				this.R000000197 = null;
			else
				this.R000000197 = rs.getString("R000000197").trim();

			if( rs.getString("R000000198") == null )
				this.R000000198 = null;
			else
				this.R000000198 = rs.getString("R000000198").trim();

			if( rs.getString("R000000199") == null )
				this.R000000199 = null;
			else
				this.R000000199 = rs.getString("R000000199").trim();

			if( rs.getString("R000000200") == null )
				this.R000000200 = null;
			else
				this.R000000200 = rs.getString("R000000200").trim();

			if( rs.getString("I000000201") == null )
				this.I000000201 = null;
			else
				this.I000000201 = rs.getString("I000000201").trim();

			if( rs.getString("I000000202") == null )
				this.I000000202 = null;
			else
				this.I000000202 = rs.getString("I000000202").trim();

			if( rs.getString("I000000203") == null )
				this.I000000203 = null;
			else
				this.I000000203 = rs.getString("I000000203").trim();

			if( rs.getString("I000000209") == null )
				this.I000000209 = null;
			else
				this.I000000209 = rs.getString("I000000209").trim();

			if( rs.getString("I000000210") == null )
				this.I000000210 = null;
			else
				this.I000000210 = rs.getString("I000000210").trim();

			if( rs.getString("I000000213") == null )
				this.I000000213 = null;
			else
				this.I000000213 = rs.getString("I000000213").trim();

			if( rs.getString("I000000214") == null )
				this.I000000214 = null;
			else
				this.I000000214 = rs.getString("I000000214").trim();

			if( rs.getString("I000000215") == null )
				this.I000000215 = null;
			else
				this.I000000215 = rs.getString("I000000215").trim();

			if( rs.getString("I000000216") == null )
				this.I000000216 = null;
			else
				this.I000000216 = rs.getString("I000000216").trim();

			if( rs.getString("I000000217") == null )
				this.I000000217 = null;
			else
				this.I000000217 = rs.getString("I000000217").trim();

			if( rs.getString("I000000218") == null )
				this.I000000218 = null;
			else
				this.I000000218 = rs.getString("I000000218").trim();

			if( rs.getString("I000000219") == null )
				this.I000000219 = null;
			else
				this.I000000219 = rs.getString("I000000219").trim();

			if( rs.getString("I000000220") == null )
				this.I000000220 = null;
			else
				this.I000000220 = rs.getString("I000000220").trim();

			if( rs.getString("I000000221") == null )
				this.I000000221 = null;
			else
				this.I000000221 = rs.getString("I000000221").trim();

			if( rs.getString("I000000222") == null )
				this.I000000222 = null;
			else
				this.I000000222 = rs.getString("I000000222").trim();

			if( rs.getString("I000000224") == null )
				this.I000000224 = null;
			else
				this.I000000224 = rs.getString("I000000224").trim();

			if( rs.getString("I000000225") == null )
				this.I000000225 = null;
			else
				this.I000000225 = rs.getString("I000000225").trim();

			if( rs.getString("I000000226") == null )
				this.I000000226 = null;
			else
				this.I000000226 = rs.getString("I000000226").trim();

			if( rs.getString("I000000227") == null )
				this.I000000227 = null;
			else
				this.I000000227 = rs.getString("I000000227").trim();

			if( rs.getString("I000000228") == null )
				this.I000000228 = null;
			else
				this.I000000228 = rs.getString("I000000228").trim();

			if( rs.getString("I000000229") == null )
				this.I000000229 = null;
			else
				this.I000000229 = rs.getString("I000000229").trim();

			if( rs.getString("I000000231") == null )
				this.I000000231 = null;
			else
				this.I000000231 = rs.getString("I000000231").trim();

			if( rs.getString("I000000232") == null )
				this.I000000232 = null;
			else
				this.I000000232 = rs.getString("I000000232").trim();

			if( rs.getString("I000000233") == null )
				this.I000000233 = null;
			else
				this.I000000233 = rs.getString("I000000233").trim();

			if( rs.getString("I000000234") == null )
				this.I000000234 = null;
			else
				this.I000000234 = rs.getString("I000000234").trim();

			if( rs.getString("I000000235") == null )
				this.I000000235 = null;
			else
				this.I000000235 = rs.getString("I000000235").trim();

			if( rs.getString("I000000236") == null )
				this.I000000236 = null;
			else
				this.I000000236 = rs.getString("I000000236").trim();

			if( rs.getString("I000000237") == null )
				this.I000000237 = null;
			else
				this.I000000237 = rs.getString("I000000237").trim();

			if( rs.getString("I000000240") == null )
				this.I000000240 = null;
			else
				this.I000000240 = rs.getString("I000000240").trim();

			if( rs.getString("I000000241") == null )
				this.I000000241 = null;
			else
				this.I000000241 = rs.getString("I000000241").trim();

			if( rs.getString("I000000242") == null )
				this.I000000242 = null;
			else
				this.I000000242 = rs.getString("I000000242").trim();

			if( rs.getString("I000000243") == null )
				this.I000000243 = null;
			else
				this.I000000243 = rs.getString("I000000243").trim();

			if( rs.getString("I000000244") == null )
				this.I000000244 = null;
			else
				this.I000000244 = rs.getString("I000000244").trim();

			if( rs.getString("I000000245") == null )
				this.I000000245 = null;
			else
				this.I000000245 = rs.getString("I000000245").trim();

			if( rs.getString("I000000246") == null )
				this.I000000246 = null;
			else
				this.I000000246 = rs.getString("I000000246").trim();

			if( rs.getString("I000000247") == null )
				this.I000000247 = null;
			else
				this.I000000247 = rs.getString("I000000247").trim();

			if( rs.getString("I000000248") == null )
				this.I000000248 = null;
			else
				this.I000000248 = rs.getString("I000000248").trim();

			if( rs.getString("I000000249") == null )
				this.I000000249 = null;
			else
				this.I000000249 = rs.getString("I000000249").trim();

			if( rs.getString("I000000250") == null )
				this.I000000250 = null;
			else
				this.I000000250 = rs.getString("I000000250").trim();

			if( rs.getString("I000000251") == null )
				this.I000000251 = null;
			else
				this.I000000251 = rs.getString("I000000251").trim();

			if( rs.getString("R000000201") == null )
				this.R000000201 = null;
			else
				this.R000000201 = rs.getString("R000000201").trim();

			if( rs.getString("R000000202") == null )
				this.R000000202 = null;
			else
				this.R000000202 = rs.getString("R000000202").trim();

			if( rs.getString("R000000203") == null )
				this.R000000203 = null;
			else
				this.R000000203 = rs.getString("R000000203").trim();

			if( rs.getString("R000000204") == null )
				this.R000000204 = null;
			else
				this.R000000204 = rs.getString("R000000204").trim();

			if( rs.getString("R000000205") == null )
				this.R000000205 = null;
			else
				this.R000000205 = rs.getString("R000000205").trim();

			if( rs.getString("I000000254") == null )
				this.I000000254 = null;
			else
				this.I000000254 = rs.getString("I000000254").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LAIndexInfoV表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LAIndexInfoVSchema getSchema()
	{
		LAIndexInfoVSchema aLAIndexInfoVSchema = new LAIndexInfoVSchema();
		aLAIndexInfoVSchema.setSchema(this);
		return aLAIndexInfoVSchema;
	}

	public LAIndexInfoVDB getDB()
	{
		LAIndexInfoVDB aDBOper = new LAIndexInfoVDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAIndexInfoV描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(WageNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BranchType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(IndexType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentCode)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGrade)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(AgentGroup)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(State)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000001)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000002)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000003)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000004)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000005)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000006)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000007)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000008)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000009)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000010)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000011)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000012)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000013)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000014)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000015)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000016)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000017)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000018)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000019)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000020)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000021)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000022)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000023)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000024)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000025)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000026)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000027)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000028)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000029)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000030)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000031)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000032)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000033)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000034)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000035)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000036)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000037)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000038)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000039)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000040)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000041)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000042)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000043)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000044)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000045)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000046)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000047)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000048)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000049)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000050)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000051)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000052)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000053)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000054)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000055)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000056)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000057)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000058)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000059)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000060)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000061)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000062)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000063)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000064)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000065)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000066)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000067)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000068)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000069)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000070)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000071)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000072)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000073)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000074)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000075)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000076)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000077)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000078)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000079)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000080)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000081)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000082)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000083)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000084)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000085)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000086)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000087)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000088)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000089)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000090)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000091)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000092)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000093)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000094)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000095)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000096)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000097)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000098)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000099)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000100)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000101)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000102)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000103)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000104)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000105)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000106)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000107)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000108)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000109)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000110)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000111)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000112)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000113)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000114)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000115)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000116)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000117)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000118)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000119)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000120)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000121)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000122)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000123)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000124)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000125)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000126)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000127)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000128)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000129)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000130)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000131)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000132)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000133)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000134)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000135)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000136)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000137)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000138)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000139)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000140)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000141)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000142)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000143)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000144)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000145)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000146)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000147)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000148)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000149)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000150)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000151)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000152)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000153)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000154)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000155)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000156)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000157)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000158)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000159)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000160)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000161)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000162)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000163)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000164)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000165)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000166)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000167)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000168)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000169)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000170)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000171)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000172)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000173)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000174)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000175)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000176)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000177)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000178)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000179)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000180)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000181)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000182)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000183)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000184)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000185)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000186)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000187)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000188)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000189)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000190)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000191)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000192)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000193)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000194)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000195)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000196)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000197)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000198)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000199)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000200)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000001)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000002)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000003)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000004)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000005)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000006)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000007)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000008)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000009)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000010)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000011)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000012)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000013)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000014)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000015)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000016)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000017)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000018)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000019)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000020)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000021)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000022)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000023)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000024)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000025)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000026)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000027)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000028)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000029)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000030)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000031)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000032)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000033)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000034)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000035)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000036)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000037)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000038)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000039)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000040)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000041)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000042)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000043)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000044)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000045)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000046)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000047)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000048)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000049)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000050)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000051)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000052)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000053)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000054)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000055)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000056)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000057)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000058)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000059)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000060)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000061)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000062)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000063)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000064)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000065)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000066)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000067)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000068)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000069)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000070)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000071)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000072)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000073)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000074)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000075)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000076)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000077)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000078)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000079)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000080)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000081)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000082)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000083)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000084)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000085)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000086)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000087)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000088)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000089)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000090)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000091)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000092)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000093)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000094)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000095)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000096)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000097)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000098)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000099)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000100)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000101)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000102)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000103)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000104)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000105)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000106)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000107)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000108)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000109)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000110)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000111)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000112)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000113)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000114)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000115)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000116)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000117)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000118)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000119)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000120)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000121)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000122)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000123)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000124)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000125)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000126)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000127)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000128)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000129)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000130)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000131)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000132)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000133)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000134)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000135)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000136)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000137)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000138)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000139)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000140)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000141)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000142)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000143)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000144)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000145)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000146)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000147)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000148)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000149)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000150)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000151)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000152)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000153)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000154)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000155)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000156)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000157)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000158)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000159)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000160)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000161)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000162)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000163)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000164)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000165)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000166)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000167)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000168)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000169)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000170)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000171)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000172)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000173)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000174)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000175)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000176)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000177)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000178)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000179)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000180)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000181)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000182)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000183)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000184)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000185)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000186)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000187)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000188)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000189)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000190)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000191)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000192)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000193)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000194)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000195)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000196)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000197)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000198)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000199)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000200)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000201)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000202)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000203)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000209)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000210)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000213)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000214)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000215)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000216)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000217)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000218)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000219)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000220)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000221)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000222)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000224)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000225)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000226)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000227)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000228)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000229)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000231)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000232)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000233)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000234)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000235)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000236)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000237)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000240)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000241)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000242)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000243)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000244)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000245)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000246)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000247)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000248)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000249)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000250)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000251)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000201)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000202)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000203)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000204)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(R000000205)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(I000000254));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLAIndexInfoV>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			WageNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			BranchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			IndexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			AgentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			AgentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			AgentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, SysConst.PACKAGESPILTER );
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			I000000001 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			I000000002 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, SysConst.PACKAGESPILTER );
			I000000003 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			I000000004 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, SysConst.PACKAGESPILTER );
			I000000005 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			I000000006 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			I000000007 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, SysConst.PACKAGESPILTER );
			I000000008 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			I000000009 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, SysConst.PACKAGESPILTER );
			I000000010 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
			I000000011 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, SysConst.PACKAGESPILTER );
			I000000012 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, SysConst.PACKAGESPILTER );
			I000000013 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, SysConst.PACKAGESPILTER );
			I000000014 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, SysConst.PACKAGESPILTER );
			I000000015 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, SysConst.PACKAGESPILTER );
			I000000016 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, SysConst.PACKAGESPILTER );
			I000000017 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, SysConst.PACKAGESPILTER );
			I000000018 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, SysConst.PACKAGESPILTER );
			I000000019 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, SysConst.PACKAGESPILTER );
			I000000020 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, SysConst.PACKAGESPILTER );
			I000000021 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, SysConst.PACKAGESPILTER );
			I000000022 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, SysConst.PACKAGESPILTER );
			I000000023 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, SysConst.PACKAGESPILTER );
			I000000024 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, SysConst.PACKAGESPILTER );
			I000000025 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, SysConst.PACKAGESPILTER );
			I000000026 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, SysConst.PACKAGESPILTER );
			I000000027 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, SysConst.PACKAGESPILTER );
			I000000028 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, SysConst.PACKAGESPILTER );
			I000000029 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, SysConst.PACKAGESPILTER );
			I000000030 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, SysConst.PACKAGESPILTER );
			I000000031 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, SysConst.PACKAGESPILTER );
			I000000032 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, SysConst.PACKAGESPILTER );
			I000000033 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, SysConst.PACKAGESPILTER );
			I000000034 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, SysConst.PACKAGESPILTER );
			I000000035 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, SysConst.PACKAGESPILTER );
			I000000036 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, SysConst.PACKAGESPILTER );
			I000000037 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, SysConst.PACKAGESPILTER );
			I000000038 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, SysConst.PACKAGESPILTER );
			I000000039 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, SysConst.PACKAGESPILTER );
			I000000040 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, SysConst.PACKAGESPILTER );
			I000000041 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, SysConst.PACKAGESPILTER );
			I000000042 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, SysConst.PACKAGESPILTER );
			I000000043 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 54, SysConst.PACKAGESPILTER );
			I000000044 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 55, SysConst.PACKAGESPILTER );
			I000000045 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 56, SysConst.PACKAGESPILTER );
			I000000046 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 57, SysConst.PACKAGESPILTER );
			I000000047 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 58, SysConst.PACKAGESPILTER );
			I000000048 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 59, SysConst.PACKAGESPILTER );
			I000000049 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 60, SysConst.PACKAGESPILTER );
			I000000050 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 61, SysConst.PACKAGESPILTER );
			I000000051 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 62, SysConst.PACKAGESPILTER );
			I000000052 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 63, SysConst.PACKAGESPILTER );
			I000000053 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 64, SysConst.PACKAGESPILTER );
			I000000054 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 65, SysConst.PACKAGESPILTER );
			I000000055 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 66, SysConst.PACKAGESPILTER );
			I000000056 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 67, SysConst.PACKAGESPILTER );
			I000000057 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 68, SysConst.PACKAGESPILTER );
			I000000058 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 69, SysConst.PACKAGESPILTER );
			I000000059 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 70, SysConst.PACKAGESPILTER );
			I000000060 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 71, SysConst.PACKAGESPILTER );
			I000000061 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 72, SysConst.PACKAGESPILTER );
			I000000062 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 73, SysConst.PACKAGESPILTER );
			I000000063 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 74, SysConst.PACKAGESPILTER );
			I000000064 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 75, SysConst.PACKAGESPILTER );
			I000000065 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 76, SysConst.PACKAGESPILTER );
			I000000066 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 77, SysConst.PACKAGESPILTER );
			I000000067 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 78, SysConst.PACKAGESPILTER );
			I000000068 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 79, SysConst.PACKAGESPILTER );
			I000000069 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 80, SysConst.PACKAGESPILTER );
			I000000070 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 81, SysConst.PACKAGESPILTER );
			I000000071 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 82, SysConst.PACKAGESPILTER );
			I000000072 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 83, SysConst.PACKAGESPILTER );
			I000000073 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 84, SysConst.PACKAGESPILTER );
			I000000074 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 85, SysConst.PACKAGESPILTER );
			I000000075 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 86, SysConst.PACKAGESPILTER );
			I000000076 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 87, SysConst.PACKAGESPILTER );
			I000000077 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 88, SysConst.PACKAGESPILTER );
			I000000078 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 89, SysConst.PACKAGESPILTER );
			I000000079 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 90, SysConst.PACKAGESPILTER );
			I000000080 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 91, SysConst.PACKAGESPILTER );
			I000000081 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 92, SysConst.PACKAGESPILTER );
			I000000082 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 93, SysConst.PACKAGESPILTER );
			I000000083 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 94, SysConst.PACKAGESPILTER );
			I000000084 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 95, SysConst.PACKAGESPILTER );
			I000000085 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 96, SysConst.PACKAGESPILTER );
			I000000086 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 97, SysConst.PACKAGESPILTER );
			I000000087 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 98, SysConst.PACKAGESPILTER );
			I000000088 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 99, SysConst.PACKAGESPILTER );
			I000000089 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 100, SysConst.PACKAGESPILTER );
			I000000090 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 101, SysConst.PACKAGESPILTER );
			I000000091 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 102, SysConst.PACKAGESPILTER );
			I000000092 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 103, SysConst.PACKAGESPILTER );
			I000000093 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 104, SysConst.PACKAGESPILTER );
			I000000094 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 105, SysConst.PACKAGESPILTER );
			I000000095 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 106, SysConst.PACKAGESPILTER );
			I000000096 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 107, SysConst.PACKAGESPILTER );
			I000000097 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 108, SysConst.PACKAGESPILTER );
			I000000098 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 109, SysConst.PACKAGESPILTER );
			I000000099 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 110, SysConst.PACKAGESPILTER );
			I000000100 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 111, SysConst.PACKAGESPILTER );
			I000000101 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 112, SysConst.PACKAGESPILTER );
			I000000102 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 113, SysConst.PACKAGESPILTER );
			I000000103 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 114, SysConst.PACKAGESPILTER );
			I000000104 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 115, SysConst.PACKAGESPILTER );
			I000000105 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 116, SysConst.PACKAGESPILTER );
			I000000106 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 117, SysConst.PACKAGESPILTER );
			I000000107 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 118, SysConst.PACKAGESPILTER );
			I000000108 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 119, SysConst.PACKAGESPILTER );
			I000000109 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 120, SysConst.PACKAGESPILTER );
			I000000110 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 121, SysConst.PACKAGESPILTER );
			I000000111 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 122, SysConst.PACKAGESPILTER );
			I000000112 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 123, SysConst.PACKAGESPILTER );
			I000000113 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 124, SysConst.PACKAGESPILTER );
			I000000114 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 125, SysConst.PACKAGESPILTER );
			I000000115 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 126, SysConst.PACKAGESPILTER );
			I000000116 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 127, SysConst.PACKAGESPILTER );
			I000000117 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 128, SysConst.PACKAGESPILTER );
			I000000118 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 129, SysConst.PACKAGESPILTER );
			I000000119 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 130, SysConst.PACKAGESPILTER );
			I000000120 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 131, SysConst.PACKAGESPILTER );
			I000000121 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 132, SysConst.PACKAGESPILTER );
			I000000122 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 133, SysConst.PACKAGESPILTER );
			I000000123 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 134, SysConst.PACKAGESPILTER );
			I000000124 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 135, SysConst.PACKAGESPILTER );
			I000000125 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 136, SysConst.PACKAGESPILTER );
			I000000126 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 137, SysConst.PACKAGESPILTER );
			I000000127 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 138, SysConst.PACKAGESPILTER );
			I000000128 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 139, SysConst.PACKAGESPILTER );
			I000000129 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 140, SysConst.PACKAGESPILTER );
			I000000130 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 141, SysConst.PACKAGESPILTER );
			I000000131 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 142, SysConst.PACKAGESPILTER );
			I000000132 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 143, SysConst.PACKAGESPILTER );
			I000000133 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 144, SysConst.PACKAGESPILTER );
			I000000134 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 145, SysConst.PACKAGESPILTER );
			I000000135 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 146, SysConst.PACKAGESPILTER );
			I000000136 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 147, SysConst.PACKAGESPILTER );
			I000000137 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 148, SysConst.PACKAGESPILTER );
			I000000138 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 149, SysConst.PACKAGESPILTER );
			I000000139 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 150, SysConst.PACKAGESPILTER );
			I000000140 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 151, SysConst.PACKAGESPILTER );
			I000000141 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 152, SysConst.PACKAGESPILTER );
			I000000142 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 153, SysConst.PACKAGESPILTER );
			I000000143 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 154, SysConst.PACKAGESPILTER );
			I000000144 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 155, SysConst.PACKAGESPILTER );
			I000000145 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 156, SysConst.PACKAGESPILTER );
			I000000146 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 157, SysConst.PACKAGESPILTER );
			I000000147 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 158, SysConst.PACKAGESPILTER );
			I000000148 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 159, SysConst.PACKAGESPILTER );
			I000000149 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 160, SysConst.PACKAGESPILTER );
			I000000150 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 161, SysConst.PACKAGESPILTER );
			I000000151 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 162, SysConst.PACKAGESPILTER );
			I000000152 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 163, SysConst.PACKAGESPILTER );
			I000000153 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 164, SysConst.PACKAGESPILTER );
			I000000154 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 165, SysConst.PACKAGESPILTER );
			I000000155 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 166, SysConst.PACKAGESPILTER );
			I000000156 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 167, SysConst.PACKAGESPILTER );
			I000000157 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 168, SysConst.PACKAGESPILTER );
			I000000158 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 169, SysConst.PACKAGESPILTER );
			I000000159 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 170, SysConst.PACKAGESPILTER );
			I000000160 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 171, SysConst.PACKAGESPILTER );
			I000000161 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 172, SysConst.PACKAGESPILTER );
			I000000162 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 173, SysConst.PACKAGESPILTER );
			I000000163 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 174, SysConst.PACKAGESPILTER );
			I000000164 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 175, SysConst.PACKAGESPILTER );
			I000000165 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 176, SysConst.PACKAGESPILTER );
			I000000166 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 177, SysConst.PACKAGESPILTER );
			I000000167 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 178, SysConst.PACKAGESPILTER );
			I000000168 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 179, SysConst.PACKAGESPILTER );
			I000000169 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 180, SysConst.PACKAGESPILTER );
			I000000170 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 181, SysConst.PACKAGESPILTER );
			I000000171 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 182, SysConst.PACKAGESPILTER );
			I000000172 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 183, SysConst.PACKAGESPILTER );
			I000000173 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 184, SysConst.PACKAGESPILTER );
			I000000174 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 185, SysConst.PACKAGESPILTER );
			I000000175 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 186, SysConst.PACKAGESPILTER );
			I000000176 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 187, SysConst.PACKAGESPILTER );
			I000000177 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 188, SysConst.PACKAGESPILTER );
			I000000178 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 189, SysConst.PACKAGESPILTER );
			I000000179 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 190, SysConst.PACKAGESPILTER );
			I000000180 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 191, SysConst.PACKAGESPILTER );
			I000000181 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 192, SysConst.PACKAGESPILTER );
			I000000182 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 193, SysConst.PACKAGESPILTER );
			I000000183 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 194, SysConst.PACKAGESPILTER );
			I000000184 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 195, SysConst.PACKAGESPILTER );
			I000000185 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 196, SysConst.PACKAGESPILTER );
			I000000186 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 197, SysConst.PACKAGESPILTER );
			I000000187 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 198, SysConst.PACKAGESPILTER );
			I000000188 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 199, SysConst.PACKAGESPILTER );
			I000000189 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 200, SysConst.PACKAGESPILTER );
			I000000190 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 201, SysConst.PACKAGESPILTER );
			I000000191 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 202, SysConst.PACKAGESPILTER );
			I000000192 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 203, SysConst.PACKAGESPILTER );
			I000000193 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 204, SysConst.PACKAGESPILTER );
			I000000194 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 205, SysConst.PACKAGESPILTER );
			I000000195 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 206, SysConst.PACKAGESPILTER );
			I000000196 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 207, SysConst.PACKAGESPILTER );
			I000000197 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 208, SysConst.PACKAGESPILTER );
			I000000198 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 209, SysConst.PACKAGESPILTER );
			I000000199 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 210, SysConst.PACKAGESPILTER );
			I000000200 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 211, SysConst.PACKAGESPILTER );
			R000000001 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 212, SysConst.PACKAGESPILTER );
			R000000002 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 213, SysConst.PACKAGESPILTER );
			R000000003 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 214, SysConst.PACKAGESPILTER );
			R000000004 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 215, SysConst.PACKAGESPILTER );
			R000000005 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 216, SysConst.PACKAGESPILTER );
			R000000006 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 217, SysConst.PACKAGESPILTER );
			R000000007 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 218, SysConst.PACKAGESPILTER );
			R000000008 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 219, SysConst.PACKAGESPILTER );
			R000000009 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 220, SysConst.PACKAGESPILTER );
			R000000010 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 221, SysConst.PACKAGESPILTER );
			R000000011 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 222, SysConst.PACKAGESPILTER );
			R000000012 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 223, SysConst.PACKAGESPILTER );
			R000000013 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 224, SysConst.PACKAGESPILTER );
			R000000014 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 225, SysConst.PACKAGESPILTER );
			R000000015 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 226, SysConst.PACKAGESPILTER );
			R000000016 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 227, SysConst.PACKAGESPILTER );
			R000000017 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 228, SysConst.PACKAGESPILTER );
			R000000018 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 229, SysConst.PACKAGESPILTER );
			R000000019 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 230, SysConst.PACKAGESPILTER );
			R000000020 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 231, SysConst.PACKAGESPILTER );
			R000000021 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 232, SysConst.PACKAGESPILTER );
			R000000022 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 233, SysConst.PACKAGESPILTER );
			R000000023 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 234, SysConst.PACKAGESPILTER );
			R000000024 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 235, SysConst.PACKAGESPILTER );
			R000000025 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 236, SysConst.PACKAGESPILTER );
			R000000026 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 237, SysConst.PACKAGESPILTER );
			R000000027 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 238, SysConst.PACKAGESPILTER );
			R000000028 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 239, SysConst.PACKAGESPILTER );
			R000000029 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 240, SysConst.PACKAGESPILTER );
			R000000030 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 241, SysConst.PACKAGESPILTER );
			R000000031 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 242, SysConst.PACKAGESPILTER );
			R000000032 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 243, SysConst.PACKAGESPILTER );
			R000000033 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 244, SysConst.PACKAGESPILTER );
			R000000034 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 245, SysConst.PACKAGESPILTER );
			R000000035 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 246, SysConst.PACKAGESPILTER );
			R000000036 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 247, SysConst.PACKAGESPILTER );
			R000000037 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 248, SysConst.PACKAGESPILTER );
			R000000038 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 249, SysConst.PACKAGESPILTER );
			R000000039 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 250, SysConst.PACKAGESPILTER );
			R000000040 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 251, SysConst.PACKAGESPILTER );
			R000000041 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 252, SysConst.PACKAGESPILTER );
			R000000042 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 253, SysConst.PACKAGESPILTER );
			R000000043 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 254, SysConst.PACKAGESPILTER );
			R000000044 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 255, SysConst.PACKAGESPILTER );
			R000000045 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 256, SysConst.PACKAGESPILTER );
			R000000046 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 257, SysConst.PACKAGESPILTER );
			R000000047 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 258, SysConst.PACKAGESPILTER );
			R000000048 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 259, SysConst.PACKAGESPILTER );
			R000000049 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 260, SysConst.PACKAGESPILTER );
			R000000050 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 261, SysConst.PACKAGESPILTER );
			R000000051 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 262, SysConst.PACKAGESPILTER );
			R000000052 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 263, SysConst.PACKAGESPILTER );
			R000000053 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 264, SysConst.PACKAGESPILTER );
			R000000054 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 265, SysConst.PACKAGESPILTER );
			R000000055 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 266, SysConst.PACKAGESPILTER );
			R000000056 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 267, SysConst.PACKAGESPILTER );
			R000000057 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 268, SysConst.PACKAGESPILTER );
			R000000058 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 269, SysConst.PACKAGESPILTER );
			R000000059 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 270, SysConst.PACKAGESPILTER );
			R000000060 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 271, SysConst.PACKAGESPILTER );
			R000000061 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 272, SysConst.PACKAGESPILTER );
			R000000062 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 273, SysConst.PACKAGESPILTER );
			R000000063 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 274, SysConst.PACKAGESPILTER );
			R000000064 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 275, SysConst.PACKAGESPILTER );
			R000000065 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 276, SysConst.PACKAGESPILTER );
			R000000066 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 277, SysConst.PACKAGESPILTER );
			R000000067 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 278, SysConst.PACKAGESPILTER );
			R000000068 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 279, SysConst.PACKAGESPILTER );
			R000000069 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 280, SysConst.PACKAGESPILTER );
			R000000070 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 281, SysConst.PACKAGESPILTER );
			R000000071 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 282, SysConst.PACKAGESPILTER );
			R000000072 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 283, SysConst.PACKAGESPILTER );
			R000000073 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 284, SysConst.PACKAGESPILTER );
			R000000074 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 285, SysConst.PACKAGESPILTER );
			R000000075 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 286, SysConst.PACKAGESPILTER );
			R000000076 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 287, SysConst.PACKAGESPILTER );
			R000000077 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 288, SysConst.PACKAGESPILTER );
			R000000078 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 289, SysConst.PACKAGESPILTER );
			R000000079 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 290, SysConst.PACKAGESPILTER );
			R000000080 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 291, SysConst.PACKAGESPILTER );
			R000000081 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 292, SysConst.PACKAGESPILTER );
			R000000082 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 293, SysConst.PACKAGESPILTER );
			R000000083 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 294, SysConst.PACKAGESPILTER );
			R000000084 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 295, SysConst.PACKAGESPILTER );
			R000000085 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 296, SysConst.PACKAGESPILTER );
			R000000086 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 297, SysConst.PACKAGESPILTER );
			R000000087 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 298, SysConst.PACKAGESPILTER );
			R000000088 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 299, SysConst.PACKAGESPILTER );
			R000000089 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 300, SysConst.PACKAGESPILTER );
			R000000090 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 301, SysConst.PACKAGESPILTER );
			R000000091 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 302, SysConst.PACKAGESPILTER );
			R000000092 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 303, SysConst.PACKAGESPILTER );
			R000000093 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 304, SysConst.PACKAGESPILTER );
			R000000094 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 305, SysConst.PACKAGESPILTER );
			R000000095 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 306, SysConst.PACKAGESPILTER );
			R000000096 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 307, SysConst.PACKAGESPILTER );
			R000000097 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 308, SysConst.PACKAGESPILTER );
			R000000098 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 309, SysConst.PACKAGESPILTER );
			R000000099 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 310, SysConst.PACKAGESPILTER );
			R000000100 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 311, SysConst.PACKAGESPILTER );
			R000000101 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 312, SysConst.PACKAGESPILTER );
			R000000102 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 313, SysConst.PACKAGESPILTER );
			R000000103 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 314, SysConst.PACKAGESPILTER );
			R000000104 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 315, SysConst.PACKAGESPILTER );
			R000000105 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 316, SysConst.PACKAGESPILTER );
			R000000106 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 317, SysConst.PACKAGESPILTER );
			R000000107 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 318, SysConst.PACKAGESPILTER );
			R000000108 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 319, SysConst.PACKAGESPILTER );
			R000000109 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 320, SysConst.PACKAGESPILTER );
			R000000110 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 321, SysConst.PACKAGESPILTER );
			R000000111 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 322, SysConst.PACKAGESPILTER );
			R000000112 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 323, SysConst.PACKAGESPILTER );
			R000000113 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 324, SysConst.PACKAGESPILTER );
			R000000114 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 325, SysConst.PACKAGESPILTER );
			R000000115 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 326, SysConst.PACKAGESPILTER );
			R000000116 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 327, SysConst.PACKAGESPILTER );
			R000000117 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 328, SysConst.PACKAGESPILTER );
			R000000118 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 329, SysConst.PACKAGESPILTER );
			R000000119 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 330, SysConst.PACKAGESPILTER );
			R000000120 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 331, SysConst.PACKAGESPILTER );
			R000000121 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 332, SysConst.PACKAGESPILTER );
			R000000122 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 333, SysConst.PACKAGESPILTER );
			R000000123 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 334, SysConst.PACKAGESPILTER );
			R000000124 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 335, SysConst.PACKAGESPILTER );
			R000000125 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 336, SysConst.PACKAGESPILTER );
			R000000126 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 337, SysConst.PACKAGESPILTER );
			R000000127 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 338, SysConst.PACKAGESPILTER );
			R000000128 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 339, SysConst.PACKAGESPILTER );
			R000000129 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 340, SysConst.PACKAGESPILTER );
			R000000130 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 341, SysConst.PACKAGESPILTER );
			R000000131 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 342, SysConst.PACKAGESPILTER );
			R000000132 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 343, SysConst.PACKAGESPILTER );
			R000000133 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 344, SysConst.PACKAGESPILTER );
			R000000134 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 345, SysConst.PACKAGESPILTER );
			R000000135 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 346, SysConst.PACKAGESPILTER );
			R000000136 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 347, SysConst.PACKAGESPILTER );
			R000000137 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 348, SysConst.PACKAGESPILTER );
			R000000138 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 349, SysConst.PACKAGESPILTER );
			R000000139 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 350, SysConst.PACKAGESPILTER );
			R000000140 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 351, SysConst.PACKAGESPILTER );
			R000000141 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 352, SysConst.PACKAGESPILTER );
			R000000142 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 353, SysConst.PACKAGESPILTER );
			R000000143 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 354, SysConst.PACKAGESPILTER );
			R000000144 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 355, SysConst.PACKAGESPILTER );
			R000000145 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 356, SysConst.PACKAGESPILTER );
			R000000146 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 357, SysConst.PACKAGESPILTER );
			R000000147 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 358, SysConst.PACKAGESPILTER );
			R000000148 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 359, SysConst.PACKAGESPILTER );
			R000000149 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 360, SysConst.PACKAGESPILTER );
			R000000150 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 361, SysConst.PACKAGESPILTER );
			R000000151 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 362, SysConst.PACKAGESPILTER );
			R000000152 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 363, SysConst.PACKAGESPILTER );
			R000000153 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 364, SysConst.PACKAGESPILTER );
			R000000154 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 365, SysConst.PACKAGESPILTER );
			R000000155 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 366, SysConst.PACKAGESPILTER );
			R000000156 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 367, SysConst.PACKAGESPILTER );
			R000000157 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 368, SysConst.PACKAGESPILTER );
			R000000158 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 369, SysConst.PACKAGESPILTER );
			R000000159 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 370, SysConst.PACKAGESPILTER );
			R000000160 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 371, SysConst.PACKAGESPILTER );
			R000000161 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 372, SysConst.PACKAGESPILTER );
			R000000162 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 373, SysConst.PACKAGESPILTER );
			R000000163 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 374, SysConst.PACKAGESPILTER );
			R000000164 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 375, SysConst.PACKAGESPILTER );
			R000000165 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 376, SysConst.PACKAGESPILTER );
			R000000166 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 377, SysConst.PACKAGESPILTER );
			R000000167 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 378, SysConst.PACKAGESPILTER );
			R000000168 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 379, SysConst.PACKAGESPILTER );
			R000000169 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 380, SysConst.PACKAGESPILTER );
			R000000170 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 381, SysConst.PACKAGESPILTER );
			R000000171 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 382, SysConst.PACKAGESPILTER );
			R000000172 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 383, SysConst.PACKAGESPILTER );
			R000000173 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 384, SysConst.PACKAGESPILTER );
			R000000174 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 385, SysConst.PACKAGESPILTER );
			R000000175 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 386, SysConst.PACKAGESPILTER );
			R000000176 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 387, SysConst.PACKAGESPILTER );
			R000000177 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 388, SysConst.PACKAGESPILTER );
			R000000178 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 389, SysConst.PACKAGESPILTER );
			R000000179 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 390, SysConst.PACKAGESPILTER );
			R000000180 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 391, SysConst.PACKAGESPILTER );
			R000000181 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 392, SysConst.PACKAGESPILTER );
			R000000182 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 393, SysConst.PACKAGESPILTER );
			R000000183 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 394, SysConst.PACKAGESPILTER );
			R000000184 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 395, SysConst.PACKAGESPILTER );
			R000000185 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 396, SysConst.PACKAGESPILTER );
			R000000186 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 397, SysConst.PACKAGESPILTER );
			R000000187 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 398, SysConst.PACKAGESPILTER );
			R000000188 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 399, SysConst.PACKAGESPILTER );
			R000000189 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 400, SysConst.PACKAGESPILTER );
			R000000190 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 401, SysConst.PACKAGESPILTER );
			R000000191 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 402, SysConst.PACKAGESPILTER );
			R000000192 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 403, SysConst.PACKAGESPILTER );
			R000000193 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 404, SysConst.PACKAGESPILTER );
			R000000194 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 405, SysConst.PACKAGESPILTER );
			R000000195 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 406, SysConst.PACKAGESPILTER );
			R000000196 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 407, SysConst.PACKAGESPILTER );
			R000000197 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 408, SysConst.PACKAGESPILTER );
			R000000198 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 409, SysConst.PACKAGESPILTER );
			R000000199 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 410, SysConst.PACKAGESPILTER );
			R000000200 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 411, SysConst.PACKAGESPILTER );
			I000000201 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 412, SysConst.PACKAGESPILTER );
			I000000202 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 413, SysConst.PACKAGESPILTER );
			I000000203 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 414, SysConst.PACKAGESPILTER );
			I000000209 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 415, SysConst.PACKAGESPILTER );
			I000000210 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 416, SysConst.PACKAGESPILTER );
			I000000213 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 417, SysConst.PACKAGESPILTER );
			I000000214 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 418, SysConst.PACKAGESPILTER );
			I000000215 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 419, SysConst.PACKAGESPILTER );
			I000000216 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 420, SysConst.PACKAGESPILTER );
			I000000217 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 421, SysConst.PACKAGESPILTER );
			I000000218 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 422, SysConst.PACKAGESPILTER );
			I000000219 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 423, SysConst.PACKAGESPILTER );
			I000000220 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 424, SysConst.PACKAGESPILTER );
			I000000221 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 425, SysConst.PACKAGESPILTER );
			I000000222 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 426, SysConst.PACKAGESPILTER );
			I000000224 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 427, SysConst.PACKAGESPILTER );
			I000000225 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 428, SysConst.PACKAGESPILTER );
			I000000226 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 429, SysConst.PACKAGESPILTER );
			I000000227 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 430, SysConst.PACKAGESPILTER );
			I000000228 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 431, SysConst.PACKAGESPILTER );
			I000000229 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 432, SysConst.PACKAGESPILTER );
			I000000231 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 433, SysConst.PACKAGESPILTER );
			I000000232 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 434, SysConst.PACKAGESPILTER );
			I000000233 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 435, SysConst.PACKAGESPILTER );
			I000000234 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 436, SysConst.PACKAGESPILTER );
			I000000235 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 437, SysConst.PACKAGESPILTER );
			I000000236 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 438, SysConst.PACKAGESPILTER );
			I000000237 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 439, SysConst.PACKAGESPILTER );
			I000000240 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 440, SysConst.PACKAGESPILTER );
			I000000241 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 441, SysConst.PACKAGESPILTER );
			I000000242 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 442, SysConst.PACKAGESPILTER );
			I000000243 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 443, SysConst.PACKAGESPILTER );
			I000000244 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 444, SysConst.PACKAGESPILTER );
			I000000245 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 445, SysConst.PACKAGESPILTER );
			I000000246 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 446, SysConst.PACKAGESPILTER );
			I000000247 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 447, SysConst.PACKAGESPILTER );
			I000000248 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 448, SysConst.PACKAGESPILTER );
			I000000249 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 449, SysConst.PACKAGESPILTER );
			I000000250 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 450, SysConst.PACKAGESPILTER );
			I000000251 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 451, SysConst.PACKAGESPILTER );
			R000000201 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 452, SysConst.PACKAGESPILTER );
			R000000202 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 453, SysConst.PACKAGESPILTER );
			R000000203 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 454, SysConst.PACKAGESPILTER );
			R000000204 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 455, SysConst.PACKAGESPILTER );
			R000000205 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 456, SysConst.PACKAGESPILTER );
			I000000254 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 457, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoVSchema";
			tError.functionName = "decode";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			return false;
		}
		return true;
	}

	/**
	* 取得对应传入参数的String形式的字段值
	* @param: FCode String 希望取得的字段名
	* @return: String
	* 如果没有对应的字段，返回""
	* 如果字段值为空，返回"null"
	**/
	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equalsIgnoreCase("WageNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(WageNo));
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BranchType));
		}
		if (FCode.equalsIgnoreCase("IndexType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(IndexType));
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentCode));
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGrade));
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(AgentGroup));
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(State));
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		}
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		}
		if (FCode.equalsIgnoreCase("I000000001"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000001));
		}
		if (FCode.equalsIgnoreCase("I000000002"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000002));
		}
		if (FCode.equalsIgnoreCase("I000000003"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000003));
		}
		if (FCode.equalsIgnoreCase("I000000004"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000004));
		}
		if (FCode.equalsIgnoreCase("I000000005"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000005));
		}
		if (FCode.equalsIgnoreCase("I000000006"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000006));
		}
		if (FCode.equalsIgnoreCase("I000000007"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000007));
		}
		if (FCode.equalsIgnoreCase("I000000008"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000008));
		}
		if (FCode.equalsIgnoreCase("I000000009"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000009));
		}
		if (FCode.equalsIgnoreCase("I000000010"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000010));
		}
		if (FCode.equalsIgnoreCase("I000000011"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000011));
		}
		if (FCode.equalsIgnoreCase("I000000012"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000012));
		}
		if (FCode.equalsIgnoreCase("I000000013"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000013));
		}
		if (FCode.equalsIgnoreCase("I000000014"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000014));
		}
		if (FCode.equalsIgnoreCase("I000000015"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000015));
		}
		if (FCode.equalsIgnoreCase("I000000016"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000016));
		}
		if (FCode.equalsIgnoreCase("I000000017"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000017));
		}
		if (FCode.equalsIgnoreCase("I000000018"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000018));
		}
		if (FCode.equalsIgnoreCase("I000000019"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000019));
		}
		if (FCode.equalsIgnoreCase("I000000020"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000020));
		}
		if (FCode.equalsIgnoreCase("I000000021"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000021));
		}
		if (FCode.equalsIgnoreCase("I000000022"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000022));
		}
		if (FCode.equalsIgnoreCase("I000000023"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000023));
		}
		if (FCode.equalsIgnoreCase("I000000024"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000024));
		}
		if (FCode.equalsIgnoreCase("I000000025"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000025));
		}
		if (FCode.equalsIgnoreCase("I000000026"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000026));
		}
		if (FCode.equalsIgnoreCase("I000000027"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000027));
		}
		if (FCode.equalsIgnoreCase("I000000028"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000028));
		}
		if (FCode.equalsIgnoreCase("I000000029"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000029));
		}
		if (FCode.equalsIgnoreCase("I000000030"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000030));
		}
		if (FCode.equalsIgnoreCase("I000000031"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000031));
		}
		if (FCode.equalsIgnoreCase("I000000032"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000032));
		}
		if (FCode.equalsIgnoreCase("I000000033"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000033));
		}
		if (FCode.equalsIgnoreCase("I000000034"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000034));
		}
		if (FCode.equalsIgnoreCase("I000000035"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000035));
		}
		if (FCode.equalsIgnoreCase("I000000036"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000036));
		}
		if (FCode.equalsIgnoreCase("I000000037"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000037));
		}
		if (FCode.equalsIgnoreCase("I000000038"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000038));
		}
		if (FCode.equalsIgnoreCase("I000000039"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000039));
		}
		if (FCode.equalsIgnoreCase("I000000040"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000040));
		}
		if (FCode.equalsIgnoreCase("I000000041"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000041));
		}
		if (FCode.equalsIgnoreCase("I000000042"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000042));
		}
		if (FCode.equalsIgnoreCase("I000000043"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000043));
		}
		if (FCode.equalsIgnoreCase("I000000044"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000044));
		}
		if (FCode.equalsIgnoreCase("I000000045"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000045));
		}
		if (FCode.equalsIgnoreCase("I000000046"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000046));
		}
		if (FCode.equalsIgnoreCase("I000000047"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000047));
		}
		if (FCode.equalsIgnoreCase("I000000048"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000048));
		}
		if (FCode.equalsIgnoreCase("I000000049"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000049));
		}
		if (FCode.equalsIgnoreCase("I000000050"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000050));
		}
		if (FCode.equalsIgnoreCase("I000000051"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000051));
		}
		if (FCode.equalsIgnoreCase("I000000052"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000052));
		}
		if (FCode.equalsIgnoreCase("I000000053"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000053));
		}
		if (FCode.equalsIgnoreCase("I000000054"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000054));
		}
		if (FCode.equalsIgnoreCase("I000000055"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000055));
		}
		if (FCode.equalsIgnoreCase("I000000056"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000056));
		}
		if (FCode.equalsIgnoreCase("I000000057"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000057));
		}
		if (FCode.equalsIgnoreCase("I000000058"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000058));
		}
		if (FCode.equalsIgnoreCase("I000000059"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000059));
		}
		if (FCode.equalsIgnoreCase("I000000060"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000060));
		}
		if (FCode.equalsIgnoreCase("I000000061"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000061));
		}
		if (FCode.equalsIgnoreCase("I000000062"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000062));
		}
		if (FCode.equalsIgnoreCase("I000000063"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000063));
		}
		if (FCode.equalsIgnoreCase("I000000064"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000064));
		}
		if (FCode.equalsIgnoreCase("I000000065"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000065));
		}
		if (FCode.equalsIgnoreCase("I000000066"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000066));
		}
		if (FCode.equalsIgnoreCase("I000000067"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000067));
		}
		if (FCode.equalsIgnoreCase("I000000068"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000068));
		}
		if (FCode.equalsIgnoreCase("I000000069"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000069));
		}
		if (FCode.equalsIgnoreCase("I000000070"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000070));
		}
		if (FCode.equalsIgnoreCase("I000000071"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000071));
		}
		if (FCode.equalsIgnoreCase("I000000072"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000072));
		}
		if (FCode.equalsIgnoreCase("I000000073"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000073));
		}
		if (FCode.equalsIgnoreCase("I000000074"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000074));
		}
		if (FCode.equalsIgnoreCase("I000000075"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000075));
		}
		if (FCode.equalsIgnoreCase("I000000076"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000076));
		}
		if (FCode.equalsIgnoreCase("I000000077"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000077));
		}
		if (FCode.equalsIgnoreCase("I000000078"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000078));
		}
		if (FCode.equalsIgnoreCase("I000000079"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000079));
		}
		if (FCode.equalsIgnoreCase("I000000080"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000080));
		}
		if (FCode.equalsIgnoreCase("I000000081"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000081));
		}
		if (FCode.equalsIgnoreCase("I000000082"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000082));
		}
		if (FCode.equalsIgnoreCase("I000000083"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000083));
		}
		if (FCode.equalsIgnoreCase("I000000084"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000084));
		}
		if (FCode.equalsIgnoreCase("I000000085"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000085));
		}
		if (FCode.equalsIgnoreCase("I000000086"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000086));
		}
		if (FCode.equalsIgnoreCase("I000000087"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000087));
		}
		if (FCode.equalsIgnoreCase("I000000088"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000088));
		}
		if (FCode.equalsIgnoreCase("I000000089"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000089));
		}
		if (FCode.equalsIgnoreCase("I000000090"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000090));
		}
		if (FCode.equalsIgnoreCase("I000000091"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000091));
		}
		if (FCode.equalsIgnoreCase("I000000092"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000092));
		}
		if (FCode.equalsIgnoreCase("I000000093"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000093));
		}
		if (FCode.equalsIgnoreCase("I000000094"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000094));
		}
		if (FCode.equalsIgnoreCase("I000000095"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000095));
		}
		if (FCode.equalsIgnoreCase("I000000096"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000096));
		}
		if (FCode.equalsIgnoreCase("I000000097"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000097));
		}
		if (FCode.equalsIgnoreCase("I000000098"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000098));
		}
		if (FCode.equalsIgnoreCase("I000000099"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000099));
		}
		if (FCode.equalsIgnoreCase("I000000100"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000100));
		}
		if (FCode.equalsIgnoreCase("I000000101"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000101));
		}
		if (FCode.equalsIgnoreCase("I000000102"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000102));
		}
		if (FCode.equalsIgnoreCase("I000000103"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000103));
		}
		if (FCode.equalsIgnoreCase("I000000104"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000104));
		}
		if (FCode.equalsIgnoreCase("I000000105"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000105));
		}
		if (FCode.equalsIgnoreCase("I000000106"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000106));
		}
		if (FCode.equalsIgnoreCase("I000000107"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000107));
		}
		if (FCode.equalsIgnoreCase("I000000108"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000108));
		}
		if (FCode.equalsIgnoreCase("I000000109"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000109));
		}
		if (FCode.equalsIgnoreCase("I000000110"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000110));
		}
		if (FCode.equalsIgnoreCase("I000000111"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000111));
		}
		if (FCode.equalsIgnoreCase("I000000112"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000112));
		}
		if (FCode.equalsIgnoreCase("I000000113"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000113));
		}
		if (FCode.equalsIgnoreCase("I000000114"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000114));
		}
		if (FCode.equalsIgnoreCase("I000000115"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000115));
		}
		if (FCode.equalsIgnoreCase("I000000116"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000116));
		}
		if (FCode.equalsIgnoreCase("I000000117"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000117));
		}
		if (FCode.equalsIgnoreCase("I000000118"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000118));
		}
		if (FCode.equalsIgnoreCase("I000000119"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000119));
		}
		if (FCode.equalsIgnoreCase("I000000120"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000120));
		}
		if (FCode.equalsIgnoreCase("I000000121"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000121));
		}
		if (FCode.equalsIgnoreCase("I000000122"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000122));
		}
		if (FCode.equalsIgnoreCase("I000000123"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000123));
		}
		if (FCode.equalsIgnoreCase("I000000124"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000124));
		}
		if (FCode.equalsIgnoreCase("I000000125"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000125));
		}
		if (FCode.equalsIgnoreCase("I000000126"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000126));
		}
		if (FCode.equalsIgnoreCase("I000000127"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000127));
		}
		if (FCode.equalsIgnoreCase("I000000128"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000128));
		}
		if (FCode.equalsIgnoreCase("I000000129"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000129));
		}
		if (FCode.equalsIgnoreCase("I000000130"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000130));
		}
		if (FCode.equalsIgnoreCase("I000000131"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000131));
		}
		if (FCode.equalsIgnoreCase("I000000132"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000132));
		}
		if (FCode.equalsIgnoreCase("I000000133"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000133));
		}
		if (FCode.equalsIgnoreCase("I000000134"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000134));
		}
		if (FCode.equalsIgnoreCase("I000000135"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000135));
		}
		if (FCode.equalsIgnoreCase("I000000136"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000136));
		}
		if (FCode.equalsIgnoreCase("I000000137"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000137));
		}
		if (FCode.equalsIgnoreCase("I000000138"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000138));
		}
		if (FCode.equalsIgnoreCase("I000000139"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000139));
		}
		if (FCode.equalsIgnoreCase("I000000140"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000140));
		}
		if (FCode.equalsIgnoreCase("I000000141"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000141));
		}
		if (FCode.equalsIgnoreCase("I000000142"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000142));
		}
		if (FCode.equalsIgnoreCase("I000000143"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000143));
		}
		if (FCode.equalsIgnoreCase("I000000144"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000144));
		}
		if (FCode.equalsIgnoreCase("I000000145"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000145));
		}
		if (FCode.equalsIgnoreCase("I000000146"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000146));
		}
		if (FCode.equalsIgnoreCase("I000000147"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000147));
		}
		if (FCode.equalsIgnoreCase("I000000148"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000148));
		}
		if (FCode.equalsIgnoreCase("I000000149"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000149));
		}
		if (FCode.equalsIgnoreCase("I000000150"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000150));
		}
		if (FCode.equalsIgnoreCase("I000000151"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000151));
		}
		if (FCode.equalsIgnoreCase("I000000152"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000152));
		}
		if (FCode.equalsIgnoreCase("I000000153"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000153));
		}
		if (FCode.equalsIgnoreCase("I000000154"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000154));
		}
		if (FCode.equalsIgnoreCase("I000000155"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000155));
		}
		if (FCode.equalsIgnoreCase("I000000156"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000156));
		}
		if (FCode.equalsIgnoreCase("I000000157"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000157));
		}
		if (FCode.equalsIgnoreCase("I000000158"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000158));
		}
		if (FCode.equalsIgnoreCase("I000000159"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000159));
		}
		if (FCode.equalsIgnoreCase("I000000160"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000160));
		}
		if (FCode.equalsIgnoreCase("I000000161"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000161));
		}
		if (FCode.equalsIgnoreCase("I000000162"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000162));
		}
		if (FCode.equalsIgnoreCase("I000000163"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000163));
		}
		if (FCode.equalsIgnoreCase("I000000164"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000164));
		}
		if (FCode.equalsIgnoreCase("I000000165"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000165));
		}
		if (FCode.equalsIgnoreCase("I000000166"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000166));
		}
		if (FCode.equalsIgnoreCase("I000000167"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000167));
		}
		if (FCode.equalsIgnoreCase("I000000168"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000168));
		}
		if (FCode.equalsIgnoreCase("I000000169"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000169));
		}
		if (FCode.equalsIgnoreCase("I000000170"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000170));
		}
		if (FCode.equalsIgnoreCase("I000000171"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000171));
		}
		if (FCode.equalsIgnoreCase("I000000172"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000172));
		}
		if (FCode.equalsIgnoreCase("I000000173"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000173));
		}
		if (FCode.equalsIgnoreCase("I000000174"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000174));
		}
		if (FCode.equalsIgnoreCase("I000000175"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000175));
		}
		if (FCode.equalsIgnoreCase("I000000176"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000176));
		}
		if (FCode.equalsIgnoreCase("I000000177"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000177));
		}
		if (FCode.equalsIgnoreCase("I000000178"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000178));
		}
		if (FCode.equalsIgnoreCase("I000000179"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000179));
		}
		if (FCode.equalsIgnoreCase("I000000180"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000180));
		}
		if (FCode.equalsIgnoreCase("I000000181"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000181));
		}
		if (FCode.equalsIgnoreCase("I000000182"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000182));
		}
		if (FCode.equalsIgnoreCase("I000000183"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000183));
		}
		if (FCode.equalsIgnoreCase("I000000184"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000184));
		}
		if (FCode.equalsIgnoreCase("I000000185"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000185));
		}
		if (FCode.equalsIgnoreCase("I000000186"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000186));
		}
		if (FCode.equalsIgnoreCase("I000000187"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000187));
		}
		if (FCode.equalsIgnoreCase("I000000188"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000188));
		}
		if (FCode.equalsIgnoreCase("I000000189"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000189));
		}
		if (FCode.equalsIgnoreCase("I000000190"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000190));
		}
		if (FCode.equalsIgnoreCase("I000000191"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000191));
		}
		if (FCode.equalsIgnoreCase("I000000192"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000192));
		}
		if (FCode.equalsIgnoreCase("I000000193"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000193));
		}
		if (FCode.equalsIgnoreCase("I000000194"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000194));
		}
		if (FCode.equalsIgnoreCase("I000000195"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000195));
		}
		if (FCode.equalsIgnoreCase("I000000196"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000196));
		}
		if (FCode.equalsIgnoreCase("I000000197"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000197));
		}
		if (FCode.equalsIgnoreCase("I000000198"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000198));
		}
		if (FCode.equalsIgnoreCase("I000000199"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000199));
		}
		if (FCode.equalsIgnoreCase("I000000200"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000200));
		}
		if (FCode.equalsIgnoreCase("R000000001"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000001));
		}
		if (FCode.equalsIgnoreCase("R000000002"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000002));
		}
		if (FCode.equalsIgnoreCase("R000000003"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000003));
		}
		if (FCode.equalsIgnoreCase("R000000004"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000004));
		}
		if (FCode.equalsIgnoreCase("R000000005"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000005));
		}
		if (FCode.equalsIgnoreCase("R000000006"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000006));
		}
		if (FCode.equalsIgnoreCase("R000000007"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000007));
		}
		if (FCode.equalsIgnoreCase("R000000008"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000008));
		}
		if (FCode.equalsIgnoreCase("R000000009"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000009));
		}
		if (FCode.equalsIgnoreCase("R000000010"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000010));
		}
		if (FCode.equalsIgnoreCase("R000000011"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000011));
		}
		if (FCode.equalsIgnoreCase("R000000012"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000012));
		}
		if (FCode.equalsIgnoreCase("R000000013"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000013));
		}
		if (FCode.equalsIgnoreCase("R000000014"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000014));
		}
		if (FCode.equalsIgnoreCase("R000000015"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000015));
		}
		if (FCode.equalsIgnoreCase("R000000016"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000016));
		}
		if (FCode.equalsIgnoreCase("R000000017"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000017));
		}
		if (FCode.equalsIgnoreCase("R000000018"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000018));
		}
		if (FCode.equalsIgnoreCase("R000000019"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000019));
		}
		if (FCode.equalsIgnoreCase("R000000020"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000020));
		}
		if (FCode.equalsIgnoreCase("R000000021"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000021));
		}
		if (FCode.equalsIgnoreCase("R000000022"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000022));
		}
		if (FCode.equalsIgnoreCase("R000000023"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000023));
		}
		if (FCode.equalsIgnoreCase("R000000024"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000024));
		}
		if (FCode.equalsIgnoreCase("R000000025"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000025));
		}
		if (FCode.equalsIgnoreCase("R000000026"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000026));
		}
		if (FCode.equalsIgnoreCase("R000000027"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000027));
		}
		if (FCode.equalsIgnoreCase("R000000028"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000028));
		}
		if (FCode.equalsIgnoreCase("R000000029"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000029));
		}
		if (FCode.equalsIgnoreCase("R000000030"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000030));
		}
		if (FCode.equalsIgnoreCase("R000000031"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000031));
		}
		if (FCode.equalsIgnoreCase("R000000032"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000032));
		}
		if (FCode.equalsIgnoreCase("R000000033"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000033));
		}
		if (FCode.equalsIgnoreCase("R000000034"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000034));
		}
		if (FCode.equalsIgnoreCase("R000000035"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000035));
		}
		if (FCode.equalsIgnoreCase("R000000036"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000036));
		}
		if (FCode.equalsIgnoreCase("R000000037"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000037));
		}
		if (FCode.equalsIgnoreCase("R000000038"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000038));
		}
		if (FCode.equalsIgnoreCase("R000000039"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000039));
		}
		if (FCode.equalsIgnoreCase("R000000040"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000040));
		}
		if (FCode.equalsIgnoreCase("R000000041"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000041));
		}
		if (FCode.equalsIgnoreCase("R000000042"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000042));
		}
		if (FCode.equalsIgnoreCase("R000000043"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000043));
		}
		if (FCode.equalsIgnoreCase("R000000044"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000044));
		}
		if (FCode.equalsIgnoreCase("R000000045"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000045));
		}
		if (FCode.equalsIgnoreCase("R000000046"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000046));
		}
		if (FCode.equalsIgnoreCase("R000000047"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000047));
		}
		if (FCode.equalsIgnoreCase("R000000048"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000048));
		}
		if (FCode.equalsIgnoreCase("R000000049"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000049));
		}
		if (FCode.equalsIgnoreCase("R000000050"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000050));
		}
		if (FCode.equalsIgnoreCase("R000000051"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000051));
		}
		if (FCode.equalsIgnoreCase("R000000052"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000052));
		}
		if (FCode.equalsIgnoreCase("R000000053"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000053));
		}
		if (FCode.equalsIgnoreCase("R000000054"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000054));
		}
		if (FCode.equalsIgnoreCase("R000000055"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000055));
		}
		if (FCode.equalsIgnoreCase("R000000056"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000056));
		}
		if (FCode.equalsIgnoreCase("R000000057"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000057));
		}
		if (FCode.equalsIgnoreCase("R000000058"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000058));
		}
		if (FCode.equalsIgnoreCase("R000000059"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000059));
		}
		if (FCode.equalsIgnoreCase("R000000060"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000060));
		}
		if (FCode.equalsIgnoreCase("R000000061"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000061));
		}
		if (FCode.equalsIgnoreCase("R000000062"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000062));
		}
		if (FCode.equalsIgnoreCase("R000000063"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000063));
		}
		if (FCode.equalsIgnoreCase("R000000064"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000064));
		}
		if (FCode.equalsIgnoreCase("R000000065"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000065));
		}
		if (FCode.equalsIgnoreCase("R000000066"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000066));
		}
		if (FCode.equalsIgnoreCase("R000000067"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000067));
		}
		if (FCode.equalsIgnoreCase("R000000068"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000068));
		}
		if (FCode.equalsIgnoreCase("R000000069"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000069));
		}
		if (FCode.equalsIgnoreCase("R000000070"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000070));
		}
		if (FCode.equalsIgnoreCase("R000000071"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000071));
		}
		if (FCode.equalsIgnoreCase("R000000072"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000072));
		}
		if (FCode.equalsIgnoreCase("R000000073"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000073));
		}
		if (FCode.equalsIgnoreCase("R000000074"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000074));
		}
		if (FCode.equalsIgnoreCase("R000000075"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000075));
		}
		if (FCode.equalsIgnoreCase("R000000076"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000076));
		}
		if (FCode.equalsIgnoreCase("R000000077"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000077));
		}
		if (FCode.equalsIgnoreCase("R000000078"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000078));
		}
		if (FCode.equalsIgnoreCase("R000000079"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000079));
		}
		if (FCode.equalsIgnoreCase("R000000080"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000080));
		}
		if (FCode.equalsIgnoreCase("R000000081"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000081));
		}
		if (FCode.equalsIgnoreCase("R000000082"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000082));
		}
		if (FCode.equalsIgnoreCase("R000000083"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000083));
		}
		if (FCode.equalsIgnoreCase("R000000084"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000084));
		}
		if (FCode.equalsIgnoreCase("R000000085"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000085));
		}
		if (FCode.equalsIgnoreCase("R000000086"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000086));
		}
		if (FCode.equalsIgnoreCase("R000000087"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000087));
		}
		if (FCode.equalsIgnoreCase("R000000088"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000088));
		}
		if (FCode.equalsIgnoreCase("R000000089"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000089));
		}
		if (FCode.equalsIgnoreCase("R000000090"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000090));
		}
		if (FCode.equalsIgnoreCase("R000000091"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000091));
		}
		if (FCode.equalsIgnoreCase("R000000092"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000092));
		}
		if (FCode.equalsIgnoreCase("R000000093"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000093));
		}
		if (FCode.equalsIgnoreCase("R000000094"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000094));
		}
		if (FCode.equalsIgnoreCase("R000000095"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000095));
		}
		if (FCode.equalsIgnoreCase("R000000096"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000096));
		}
		if (FCode.equalsIgnoreCase("R000000097"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000097));
		}
		if (FCode.equalsIgnoreCase("R000000098"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000098));
		}
		if (FCode.equalsIgnoreCase("R000000099"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000099));
		}
		if (FCode.equalsIgnoreCase("R000000100"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000100));
		}
		if (FCode.equalsIgnoreCase("R000000101"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000101));
		}
		if (FCode.equalsIgnoreCase("R000000102"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000102));
		}
		if (FCode.equalsIgnoreCase("R000000103"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000103));
		}
		if (FCode.equalsIgnoreCase("R000000104"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000104));
		}
		if (FCode.equalsIgnoreCase("R000000105"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000105));
		}
		if (FCode.equalsIgnoreCase("R000000106"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000106));
		}
		if (FCode.equalsIgnoreCase("R000000107"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000107));
		}
		if (FCode.equalsIgnoreCase("R000000108"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000108));
		}
		if (FCode.equalsIgnoreCase("R000000109"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000109));
		}
		if (FCode.equalsIgnoreCase("R000000110"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000110));
		}
		if (FCode.equalsIgnoreCase("R000000111"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000111));
		}
		if (FCode.equalsIgnoreCase("R000000112"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000112));
		}
		if (FCode.equalsIgnoreCase("R000000113"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000113));
		}
		if (FCode.equalsIgnoreCase("R000000114"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000114));
		}
		if (FCode.equalsIgnoreCase("R000000115"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000115));
		}
		if (FCode.equalsIgnoreCase("R000000116"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000116));
		}
		if (FCode.equalsIgnoreCase("R000000117"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000117));
		}
		if (FCode.equalsIgnoreCase("R000000118"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000118));
		}
		if (FCode.equalsIgnoreCase("R000000119"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000119));
		}
		if (FCode.equalsIgnoreCase("R000000120"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000120));
		}
		if (FCode.equalsIgnoreCase("R000000121"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000121));
		}
		if (FCode.equalsIgnoreCase("R000000122"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000122));
		}
		if (FCode.equalsIgnoreCase("R000000123"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000123));
		}
		if (FCode.equalsIgnoreCase("R000000124"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000124));
		}
		if (FCode.equalsIgnoreCase("R000000125"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000125));
		}
		if (FCode.equalsIgnoreCase("R000000126"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000126));
		}
		if (FCode.equalsIgnoreCase("R000000127"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000127));
		}
		if (FCode.equalsIgnoreCase("R000000128"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000128));
		}
		if (FCode.equalsIgnoreCase("R000000129"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000129));
		}
		if (FCode.equalsIgnoreCase("R000000130"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000130));
		}
		if (FCode.equalsIgnoreCase("R000000131"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000131));
		}
		if (FCode.equalsIgnoreCase("R000000132"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000132));
		}
		if (FCode.equalsIgnoreCase("R000000133"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000133));
		}
		if (FCode.equalsIgnoreCase("R000000134"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000134));
		}
		if (FCode.equalsIgnoreCase("R000000135"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000135));
		}
		if (FCode.equalsIgnoreCase("R000000136"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000136));
		}
		if (FCode.equalsIgnoreCase("R000000137"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000137));
		}
		if (FCode.equalsIgnoreCase("R000000138"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000138));
		}
		if (FCode.equalsIgnoreCase("R000000139"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000139));
		}
		if (FCode.equalsIgnoreCase("R000000140"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000140));
		}
		if (FCode.equalsIgnoreCase("R000000141"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000141));
		}
		if (FCode.equalsIgnoreCase("R000000142"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000142));
		}
		if (FCode.equalsIgnoreCase("R000000143"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000143));
		}
		if (FCode.equalsIgnoreCase("R000000144"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000144));
		}
		if (FCode.equalsIgnoreCase("R000000145"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000145));
		}
		if (FCode.equalsIgnoreCase("R000000146"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000146));
		}
		if (FCode.equalsIgnoreCase("R000000147"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000147));
		}
		if (FCode.equalsIgnoreCase("R000000148"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000148));
		}
		if (FCode.equalsIgnoreCase("R000000149"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000149));
		}
		if (FCode.equalsIgnoreCase("R000000150"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000150));
		}
		if (FCode.equalsIgnoreCase("R000000151"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000151));
		}
		if (FCode.equalsIgnoreCase("R000000152"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000152));
		}
		if (FCode.equalsIgnoreCase("R000000153"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000153));
		}
		if (FCode.equalsIgnoreCase("R000000154"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000154));
		}
		if (FCode.equalsIgnoreCase("R000000155"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000155));
		}
		if (FCode.equalsIgnoreCase("R000000156"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000156));
		}
		if (FCode.equalsIgnoreCase("R000000157"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000157));
		}
		if (FCode.equalsIgnoreCase("R000000158"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000158));
		}
		if (FCode.equalsIgnoreCase("R000000159"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000159));
		}
		if (FCode.equalsIgnoreCase("R000000160"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000160));
		}
		if (FCode.equalsIgnoreCase("R000000161"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000161));
		}
		if (FCode.equalsIgnoreCase("R000000162"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000162));
		}
		if (FCode.equalsIgnoreCase("R000000163"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000163));
		}
		if (FCode.equalsIgnoreCase("R000000164"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000164));
		}
		if (FCode.equalsIgnoreCase("R000000165"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000165));
		}
		if (FCode.equalsIgnoreCase("R000000166"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000166));
		}
		if (FCode.equalsIgnoreCase("R000000167"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000167));
		}
		if (FCode.equalsIgnoreCase("R000000168"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000168));
		}
		if (FCode.equalsIgnoreCase("R000000169"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000169));
		}
		if (FCode.equalsIgnoreCase("R000000170"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000170));
		}
		if (FCode.equalsIgnoreCase("R000000171"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000171));
		}
		if (FCode.equalsIgnoreCase("R000000172"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000172));
		}
		if (FCode.equalsIgnoreCase("R000000173"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000173));
		}
		if (FCode.equalsIgnoreCase("R000000174"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000174));
		}
		if (FCode.equalsIgnoreCase("R000000175"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000175));
		}
		if (FCode.equalsIgnoreCase("R000000176"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000176));
		}
		if (FCode.equalsIgnoreCase("R000000177"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000177));
		}
		if (FCode.equalsIgnoreCase("R000000178"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000178));
		}
		if (FCode.equalsIgnoreCase("R000000179"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000179));
		}
		if (FCode.equalsIgnoreCase("R000000180"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000180));
		}
		if (FCode.equalsIgnoreCase("R000000181"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000181));
		}
		if (FCode.equalsIgnoreCase("R000000182"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000182));
		}
		if (FCode.equalsIgnoreCase("R000000183"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000183));
		}
		if (FCode.equalsIgnoreCase("R000000184"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000184));
		}
		if (FCode.equalsIgnoreCase("R000000185"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000185));
		}
		if (FCode.equalsIgnoreCase("R000000186"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000186));
		}
		if (FCode.equalsIgnoreCase("R000000187"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000187));
		}
		if (FCode.equalsIgnoreCase("R000000188"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000188));
		}
		if (FCode.equalsIgnoreCase("R000000189"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000189));
		}
		if (FCode.equalsIgnoreCase("R000000190"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000190));
		}
		if (FCode.equalsIgnoreCase("R000000191"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000191));
		}
		if (FCode.equalsIgnoreCase("R000000192"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000192));
		}
		if (FCode.equalsIgnoreCase("R000000193"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000193));
		}
		if (FCode.equalsIgnoreCase("R000000194"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000194));
		}
		if (FCode.equalsIgnoreCase("R000000195"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000195));
		}
		if (FCode.equalsIgnoreCase("R000000196"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000196));
		}
		if (FCode.equalsIgnoreCase("R000000197"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000197));
		}
		if (FCode.equalsIgnoreCase("R000000198"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000198));
		}
		if (FCode.equalsIgnoreCase("R000000199"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000199));
		}
		if (FCode.equalsIgnoreCase("R000000200"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000200));
		}
		if (FCode.equalsIgnoreCase("I000000201"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000201));
		}
		if (FCode.equalsIgnoreCase("I000000202"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000202));
		}
		if (FCode.equalsIgnoreCase("I000000203"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000203));
		}
		if (FCode.equalsIgnoreCase("I000000209"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000209));
		}
		if (FCode.equalsIgnoreCase("I000000210"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000210));
		}
		if (FCode.equalsIgnoreCase("I000000213"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000213));
		}
		if (FCode.equalsIgnoreCase("I000000214"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000214));
		}
		if (FCode.equalsIgnoreCase("I000000215"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000215));
		}
		if (FCode.equalsIgnoreCase("I000000216"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000216));
		}
		if (FCode.equalsIgnoreCase("I000000217"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000217));
		}
		if (FCode.equalsIgnoreCase("I000000218"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000218));
		}
		if (FCode.equalsIgnoreCase("I000000219"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000219));
		}
		if (FCode.equalsIgnoreCase("I000000220"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000220));
		}
		if (FCode.equalsIgnoreCase("I000000221"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000221));
		}
		if (FCode.equalsIgnoreCase("I000000222"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000222));
		}
		if (FCode.equalsIgnoreCase("I000000224"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000224));
		}
		if (FCode.equalsIgnoreCase("I000000225"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000225));
		}
		if (FCode.equalsIgnoreCase("I000000226"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000226));
		}
		if (FCode.equalsIgnoreCase("I000000227"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000227));
		}
		if (FCode.equalsIgnoreCase("I000000228"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000228));
		}
		if (FCode.equalsIgnoreCase("I000000229"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000229));
		}
		if (FCode.equalsIgnoreCase("I000000231"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000231));
		}
		if (FCode.equalsIgnoreCase("I000000232"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000232));
		}
		if (FCode.equalsIgnoreCase("I000000233"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000233));
		}
		if (FCode.equalsIgnoreCase("I000000234"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000234));
		}
		if (FCode.equalsIgnoreCase("I000000235"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000235));
		}
		if (FCode.equalsIgnoreCase("I000000236"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000236));
		}
		if (FCode.equalsIgnoreCase("I000000237"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000237));
		}
		if (FCode.equalsIgnoreCase("I000000240"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000240));
		}
		if (FCode.equalsIgnoreCase("I000000241"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000241));
		}
		if (FCode.equalsIgnoreCase("I000000242"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000242));
		}
		if (FCode.equalsIgnoreCase("I000000243"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000243));
		}
		if (FCode.equalsIgnoreCase("I000000244"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000244));
		}
		if (FCode.equalsIgnoreCase("I000000245"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000245));
		}
		if (FCode.equalsIgnoreCase("I000000246"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000246));
		}
		if (FCode.equalsIgnoreCase("I000000247"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000247));
		}
		if (FCode.equalsIgnoreCase("I000000248"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000248));
		}
		if (FCode.equalsIgnoreCase("I000000249"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000249));
		}
		if (FCode.equalsIgnoreCase("I000000250"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000250));
		}
		if (FCode.equalsIgnoreCase("I000000251"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000251));
		}
		if (FCode.equalsIgnoreCase("R000000201"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000201));
		}
		if (FCode.equalsIgnoreCase("R000000202"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000202));
		}
		if (FCode.equalsIgnoreCase("R000000203"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000203));
		}
		if (FCode.equalsIgnoreCase("R000000204"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000204));
		}
		if (FCode.equalsIgnoreCase("R000000205"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(R000000205));
		}
		if (FCode.equalsIgnoreCase("I000000254"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(I000000254));
		}
		if (strReturn.equals(""))
		{
			strReturn = "null";
		}

		return strReturn;
	}


	/**
	* 取得Schema中指定索引值所对应的字段值
	* @param: nFieldIndex int 指定的字段索引值
	* @return: String
	* 如果没有对应的字段，返回""
	* 如果字段值为空，返回"null"
	**/
	public String getV(int nFieldIndex)
	{
		String strFieldValue = "";
		switch(nFieldIndex) {
			case 0:
				strFieldValue = StrTool.GBKToUnicode(WageNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(BranchType);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(IndexType);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(AgentCode);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(AgentGrade);
				break;
			case 5:
				strFieldValue = StrTool.GBKToUnicode(AgentGroup);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(State);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(I000000001);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(I000000002);
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(I000000003);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(I000000004);
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(I000000005);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(I000000006);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(I000000007);
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(I000000008);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(I000000009);
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(I000000010);
				break;
			case 21:
				strFieldValue = StrTool.GBKToUnicode(I000000011);
				break;
			case 22:
				strFieldValue = StrTool.GBKToUnicode(I000000012);
				break;
			case 23:
				strFieldValue = StrTool.GBKToUnicode(I000000013);
				break;
			case 24:
				strFieldValue = StrTool.GBKToUnicode(I000000014);
				break;
			case 25:
				strFieldValue = StrTool.GBKToUnicode(I000000015);
				break;
			case 26:
				strFieldValue = StrTool.GBKToUnicode(I000000016);
				break;
			case 27:
				strFieldValue = StrTool.GBKToUnicode(I000000017);
				break;
			case 28:
				strFieldValue = StrTool.GBKToUnicode(I000000018);
				break;
			case 29:
				strFieldValue = StrTool.GBKToUnicode(I000000019);
				break;
			case 30:
				strFieldValue = StrTool.GBKToUnicode(I000000020);
				break;
			case 31:
				strFieldValue = StrTool.GBKToUnicode(I000000021);
				break;
			case 32:
				strFieldValue = StrTool.GBKToUnicode(I000000022);
				break;
			case 33:
				strFieldValue = StrTool.GBKToUnicode(I000000023);
				break;
			case 34:
				strFieldValue = StrTool.GBKToUnicode(I000000024);
				break;
			case 35:
				strFieldValue = StrTool.GBKToUnicode(I000000025);
				break;
			case 36:
				strFieldValue = StrTool.GBKToUnicode(I000000026);
				break;
			case 37:
				strFieldValue = StrTool.GBKToUnicode(I000000027);
				break;
			case 38:
				strFieldValue = StrTool.GBKToUnicode(I000000028);
				break;
			case 39:
				strFieldValue = StrTool.GBKToUnicode(I000000029);
				break;
			case 40:
				strFieldValue = StrTool.GBKToUnicode(I000000030);
				break;
			case 41:
				strFieldValue = StrTool.GBKToUnicode(I000000031);
				break;
			case 42:
				strFieldValue = StrTool.GBKToUnicode(I000000032);
				break;
			case 43:
				strFieldValue = StrTool.GBKToUnicode(I000000033);
				break;
			case 44:
				strFieldValue = StrTool.GBKToUnicode(I000000034);
				break;
			case 45:
				strFieldValue = StrTool.GBKToUnicode(I000000035);
				break;
			case 46:
				strFieldValue = StrTool.GBKToUnicode(I000000036);
				break;
			case 47:
				strFieldValue = StrTool.GBKToUnicode(I000000037);
				break;
			case 48:
				strFieldValue = StrTool.GBKToUnicode(I000000038);
				break;
			case 49:
				strFieldValue = StrTool.GBKToUnicode(I000000039);
				break;
			case 50:
				strFieldValue = StrTool.GBKToUnicode(I000000040);
				break;
			case 51:
				strFieldValue = StrTool.GBKToUnicode(I000000041);
				break;
			case 52:
				strFieldValue = StrTool.GBKToUnicode(I000000042);
				break;
			case 53:
				strFieldValue = StrTool.GBKToUnicode(I000000043);
				break;
			case 54:
				strFieldValue = StrTool.GBKToUnicode(I000000044);
				break;
			case 55:
				strFieldValue = StrTool.GBKToUnicode(I000000045);
				break;
			case 56:
				strFieldValue = StrTool.GBKToUnicode(I000000046);
				break;
			case 57:
				strFieldValue = StrTool.GBKToUnicode(I000000047);
				break;
			case 58:
				strFieldValue = StrTool.GBKToUnicode(I000000048);
				break;
			case 59:
				strFieldValue = StrTool.GBKToUnicode(I000000049);
				break;
			case 60:
				strFieldValue = StrTool.GBKToUnicode(I000000050);
				break;
			case 61:
				strFieldValue = StrTool.GBKToUnicode(I000000051);
				break;
			case 62:
				strFieldValue = StrTool.GBKToUnicode(I000000052);
				break;
			case 63:
				strFieldValue = StrTool.GBKToUnicode(I000000053);
				break;
			case 64:
				strFieldValue = StrTool.GBKToUnicode(I000000054);
				break;
			case 65:
				strFieldValue = StrTool.GBKToUnicode(I000000055);
				break;
			case 66:
				strFieldValue = StrTool.GBKToUnicode(I000000056);
				break;
			case 67:
				strFieldValue = StrTool.GBKToUnicode(I000000057);
				break;
			case 68:
				strFieldValue = StrTool.GBKToUnicode(I000000058);
				break;
			case 69:
				strFieldValue = StrTool.GBKToUnicode(I000000059);
				break;
			case 70:
				strFieldValue = StrTool.GBKToUnicode(I000000060);
				break;
			case 71:
				strFieldValue = StrTool.GBKToUnicode(I000000061);
				break;
			case 72:
				strFieldValue = StrTool.GBKToUnicode(I000000062);
				break;
			case 73:
				strFieldValue = StrTool.GBKToUnicode(I000000063);
				break;
			case 74:
				strFieldValue = StrTool.GBKToUnicode(I000000064);
				break;
			case 75:
				strFieldValue = StrTool.GBKToUnicode(I000000065);
				break;
			case 76:
				strFieldValue = StrTool.GBKToUnicode(I000000066);
				break;
			case 77:
				strFieldValue = StrTool.GBKToUnicode(I000000067);
				break;
			case 78:
				strFieldValue = StrTool.GBKToUnicode(I000000068);
				break;
			case 79:
				strFieldValue = StrTool.GBKToUnicode(I000000069);
				break;
			case 80:
				strFieldValue = StrTool.GBKToUnicode(I000000070);
				break;
			case 81:
				strFieldValue = StrTool.GBKToUnicode(I000000071);
				break;
			case 82:
				strFieldValue = StrTool.GBKToUnicode(I000000072);
				break;
			case 83:
				strFieldValue = StrTool.GBKToUnicode(I000000073);
				break;
			case 84:
				strFieldValue = StrTool.GBKToUnicode(I000000074);
				break;
			case 85:
				strFieldValue = StrTool.GBKToUnicode(I000000075);
				break;
			case 86:
				strFieldValue = StrTool.GBKToUnicode(I000000076);
				break;
			case 87:
				strFieldValue = StrTool.GBKToUnicode(I000000077);
				break;
			case 88:
				strFieldValue = StrTool.GBKToUnicode(I000000078);
				break;
			case 89:
				strFieldValue = StrTool.GBKToUnicode(I000000079);
				break;
			case 90:
				strFieldValue = StrTool.GBKToUnicode(I000000080);
				break;
			case 91:
				strFieldValue = StrTool.GBKToUnicode(I000000081);
				break;
			case 92:
				strFieldValue = StrTool.GBKToUnicode(I000000082);
				break;
			case 93:
				strFieldValue = StrTool.GBKToUnicode(I000000083);
				break;
			case 94:
				strFieldValue = StrTool.GBKToUnicode(I000000084);
				break;
			case 95:
				strFieldValue = StrTool.GBKToUnicode(I000000085);
				break;
			case 96:
				strFieldValue = StrTool.GBKToUnicode(I000000086);
				break;
			case 97:
				strFieldValue = StrTool.GBKToUnicode(I000000087);
				break;
			case 98:
				strFieldValue = StrTool.GBKToUnicode(I000000088);
				break;
			case 99:
				strFieldValue = StrTool.GBKToUnicode(I000000089);
				break;
			case 100:
				strFieldValue = StrTool.GBKToUnicode(I000000090);
				break;
			case 101:
				strFieldValue = StrTool.GBKToUnicode(I000000091);
				break;
			case 102:
				strFieldValue = StrTool.GBKToUnicode(I000000092);
				break;
			case 103:
				strFieldValue = StrTool.GBKToUnicode(I000000093);
				break;
			case 104:
				strFieldValue = StrTool.GBKToUnicode(I000000094);
				break;
			case 105:
				strFieldValue = StrTool.GBKToUnicode(I000000095);
				break;
			case 106:
				strFieldValue = StrTool.GBKToUnicode(I000000096);
				break;
			case 107:
				strFieldValue = StrTool.GBKToUnicode(I000000097);
				break;
			case 108:
				strFieldValue = StrTool.GBKToUnicode(I000000098);
				break;
			case 109:
				strFieldValue = StrTool.GBKToUnicode(I000000099);
				break;
			case 110:
				strFieldValue = StrTool.GBKToUnicode(I000000100);
				break;
			case 111:
				strFieldValue = StrTool.GBKToUnicode(I000000101);
				break;
			case 112:
				strFieldValue = StrTool.GBKToUnicode(I000000102);
				break;
			case 113:
				strFieldValue = StrTool.GBKToUnicode(I000000103);
				break;
			case 114:
				strFieldValue = StrTool.GBKToUnicode(I000000104);
				break;
			case 115:
				strFieldValue = StrTool.GBKToUnicode(I000000105);
				break;
			case 116:
				strFieldValue = StrTool.GBKToUnicode(I000000106);
				break;
			case 117:
				strFieldValue = StrTool.GBKToUnicode(I000000107);
				break;
			case 118:
				strFieldValue = StrTool.GBKToUnicode(I000000108);
				break;
			case 119:
				strFieldValue = StrTool.GBKToUnicode(I000000109);
				break;
			case 120:
				strFieldValue = StrTool.GBKToUnicode(I000000110);
				break;
			case 121:
				strFieldValue = StrTool.GBKToUnicode(I000000111);
				break;
			case 122:
				strFieldValue = StrTool.GBKToUnicode(I000000112);
				break;
			case 123:
				strFieldValue = StrTool.GBKToUnicode(I000000113);
				break;
			case 124:
				strFieldValue = StrTool.GBKToUnicode(I000000114);
				break;
			case 125:
				strFieldValue = StrTool.GBKToUnicode(I000000115);
				break;
			case 126:
				strFieldValue = StrTool.GBKToUnicode(I000000116);
				break;
			case 127:
				strFieldValue = StrTool.GBKToUnicode(I000000117);
				break;
			case 128:
				strFieldValue = StrTool.GBKToUnicode(I000000118);
				break;
			case 129:
				strFieldValue = StrTool.GBKToUnicode(I000000119);
				break;
			case 130:
				strFieldValue = StrTool.GBKToUnicode(I000000120);
				break;
			case 131:
				strFieldValue = StrTool.GBKToUnicode(I000000121);
				break;
			case 132:
				strFieldValue = StrTool.GBKToUnicode(I000000122);
				break;
			case 133:
				strFieldValue = StrTool.GBKToUnicode(I000000123);
				break;
			case 134:
				strFieldValue = StrTool.GBKToUnicode(I000000124);
				break;
			case 135:
				strFieldValue = StrTool.GBKToUnicode(I000000125);
				break;
			case 136:
				strFieldValue = StrTool.GBKToUnicode(I000000126);
				break;
			case 137:
				strFieldValue = StrTool.GBKToUnicode(I000000127);
				break;
			case 138:
				strFieldValue = StrTool.GBKToUnicode(I000000128);
				break;
			case 139:
				strFieldValue = StrTool.GBKToUnicode(I000000129);
				break;
			case 140:
				strFieldValue = StrTool.GBKToUnicode(I000000130);
				break;
			case 141:
				strFieldValue = StrTool.GBKToUnicode(I000000131);
				break;
			case 142:
				strFieldValue = StrTool.GBKToUnicode(I000000132);
				break;
			case 143:
				strFieldValue = StrTool.GBKToUnicode(I000000133);
				break;
			case 144:
				strFieldValue = StrTool.GBKToUnicode(I000000134);
				break;
			case 145:
				strFieldValue = StrTool.GBKToUnicode(I000000135);
				break;
			case 146:
				strFieldValue = StrTool.GBKToUnicode(I000000136);
				break;
			case 147:
				strFieldValue = StrTool.GBKToUnicode(I000000137);
				break;
			case 148:
				strFieldValue = StrTool.GBKToUnicode(I000000138);
				break;
			case 149:
				strFieldValue = StrTool.GBKToUnicode(I000000139);
				break;
			case 150:
				strFieldValue = StrTool.GBKToUnicode(I000000140);
				break;
			case 151:
				strFieldValue = StrTool.GBKToUnicode(I000000141);
				break;
			case 152:
				strFieldValue = StrTool.GBKToUnicode(I000000142);
				break;
			case 153:
				strFieldValue = StrTool.GBKToUnicode(I000000143);
				break;
			case 154:
				strFieldValue = StrTool.GBKToUnicode(I000000144);
				break;
			case 155:
				strFieldValue = StrTool.GBKToUnicode(I000000145);
				break;
			case 156:
				strFieldValue = StrTool.GBKToUnicode(I000000146);
				break;
			case 157:
				strFieldValue = StrTool.GBKToUnicode(I000000147);
				break;
			case 158:
				strFieldValue = StrTool.GBKToUnicode(I000000148);
				break;
			case 159:
				strFieldValue = StrTool.GBKToUnicode(I000000149);
				break;
			case 160:
				strFieldValue = StrTool.GBKToUnicode(I000000150);
				break;
			case 161:
				strFieldValue = StrTool.GBKToUnicode(I000000151);
				break;
			case 162:
				strFieldValue = StrTool.GBKToUnicode(I000000152);
				break;
			case 163:
				strFieldValue = StrTool.GBKToUnicode(I000000153);
				break;
			case 164:
				strFieldValue = StrTool.GBKToUnicode(I000000154);
				break;
			case 165:
				strFieldValue = StrTool.GBKToUnicode(I000000155);
				break;
			case 166:
				strFieldValue = StrTool.GBKToUnicode(I000000156);
				break;
			case 167:
				strFieldValue = StrTool.GBKToUnicode(I000000157);
				break;
			case 168:
				strFieldValue = StrTool.GBKToUnicode(I000000158);
				break;
			case 169:
				strFieldValue = StrTool.GBKToUnicode(I000000159);
				break;
			case 170:
				strFieldValue = StrTool.GBKToUnicode(I000000160);
				break;
			case 171:
				strFieldValue = StrTool.GBKToUnicode(I000000161);
				break;
			case 172:
				strFieldValue = StrTool.GBKToUnicode(I000000162);
				break;
			case 173:
				strFieldValue = StrTool.GBKToUnicode(I000000163);
				break;
			case 174:
				strFieldValue = StrTool.GBKToUnicode(I000000164);
				break;
			case 175:
				strFieldValue = StrTool.GBKToUnicode(I000000165);
				break;
			case 176:
				strFieldValue = StrTool.GBKToUnicode(I000000166);
				break;
			case 177:
				strFieldValue = StrTool.GBKToUnicode(I000000167);
				break;
			case 178:
				strFieldValue = StrTool.GBKToUnicode(I000000168);
				break;
			case 179:
				strFieldValue = StrTool.GBKToUnicode(I000000169);
				break;
			case 180:
				strFieldValue = StrTool.GBKToUnicode(I000000170);
				break;
			case 181:
				strFieldValue = StrTool.GBKToUnicode(I000000171);
				break;
			case 182:
				strFieldValue = StrTool.GBKToUnicode(I000000172);
				break;
			case 183:
				strFieldValue = StrTool.GBKToUnicode(I000000173);
				break;
			case 184:
				strFieldValue = StrTool.GBKToUnicode(I000000174);
				break;
			case 185:
				strFieldValue = StrTool.GBKToUnicode(I000000175);
				break;
			case 186:
				strFieldValue = StrTool.GBKToUnicode(I000000176);
				break;
			case 187:
				strFieldValue = StrTool.GBKToUnicode(I000000177);
				break;
			case 188:
				strFieldValue = StrTool.GBKToUnicode(I000000178);
				break;
			case 189:
				strFieldValue = StrTool.GBKToUnicode(I000000179);
				break;
			case 190:
				strFieldValue = StrTool.GBKToUnicode(I000000180);
				break;
			case 191:
				strFieldValue = StrTool.GBKToUnicode(I000000181);
				break;
			case 192:
				strFieldValue = StrTool.GBKToUnicode(I000000182);
				break;
			case 193:
				strFieldValue = StrTool.GBKToUnicode(I000000183);
				break;
			case 194:
				strFieldValue = StrTool.GBKToUnicode(I000000184);
				break;
			case 195:
				strFieldValue = StrTool.GBKToUnicode(I000000185);
				break;
			case 196:
				strFieldValue = StrTool.GBKToUnicode(I000000186);
				break;
			case 197:
				strFieldValue = StrTool.GBKToUnicode(I000000187);
				break;
			case 198:
				strFieldValue = StrTool.GBKToUnicode(I000000188);
				break;
			case 199:
				strFieldValue = StrTool.GBKToUnicode(I000000189);
				break;
			case 200:
				strFieldValue = StrTool.GBKToUnicode(I000000190);
				break;
			case 201:
				strFieldValue = StrTool.GBKToUnicode(I000000191);
				break;
			case 202:
				strFieldValue = StrTool.GBKToUnicode(I000000192);
				break;
			case 203:
				strFieldValue = StrTool.GBKToUnicode(I000000193);
				break;
			case 204:
				strFieldValue = StrTool.GBKToUnicode(I000000194);
				break;
			case 205:
				strFieldValue = StrTool.GBKToUnicode(I000000195);
				break;
			case 206:
				strFieldValue = StrTool.GBKToUnicode(I000000196);
				break;
			case 207:
				strFieldValue = StrTool.GBKToUnicode(I000000197);
				break;
			case 208:
				strFieldValue = StrTool.GBKToUnicode(I000000198);
				break;
			case 209:
				strFieldValue = StrTool.GBKToUnicode(I000000199);
				break;
			case 210:
				strFieldValue = StrTool.GBKToUnicode(I000000200);
				break;
			case 211:
				strFieldValue = StrTool.GBKToUnicode(R000000001);
				break;
			case 212:
				strFieldValue = StrTool.GBKToUnicode(R000000002);
				break;
			case 213:
				strFieldValue = StrTool.GBKToUnicode(R000000003);
				break;
			case 214:
				strFieldValue = StrTool.GBKToUnicode(R000000004);
				break;
			case 215:
				strFieldValue = StrTool.GBKToUnicode(R000000005);
				break;
			case 216:
				strFieldValue = StrTool.GBKToUnicode(R000000006);
				break;
			case 217:
				strFieldValue = StrTool.GBKToUnicode(R000000007);
				break;
			case 218:
				strFieldValue = StrTool.GBKToUnicode(R000000008);
				break;
			case 219:
				strFieldValue = StrTool.GBKToUnicode(R000000009);
				break;
			case 220:
				strFieldValue = StrTool.GBKToUnicode(R000000010);
				break;
			case 221:
				strFieldValue = StrTool.GBKToUnicode(R000000011);
				break;
			case 222:
				strFieldValue = StrTool.GBKToUnicode(R000000012);
				break;
			case 223:
				strFieldValue = StrTool.GBKToUnicode(R000000013);
				break;
			case 224:
				strFieldValue = StrTool.GBKToUnicode(R000000014);
				break;
			case 225:
				strFieldValue = StrTool.GBKToUnicode(R000000015);
				break;
			case 226:
				strFieldValue = StrTool.GBKToUnicode(R000000016);
				break;
			case 227:
				strFieldValue = StrTool.GBKToUnicode(R000000017);
				break;
			case 228:
				strFieldValue = StrTool.GBKToUnicode(R000000018);
				break;
			case 229:
				strFieldValue = StrTool.GBKToUnicode(R000000019);
				break;
			case 230:
				strFieldValue = StrTool.GBKToUnicode(R000000020);
				break;
			case 231:
				strFieldValue = StrTool.GBKToUnicode(R000000021);
				break;
			case 232:
				strFieldValue = StrTool.GBKToUnicode(R000000022);
				break;
			case 233:
				strFieldValue = StrTool.GBKToUnicode(R000000023);
				break;
			case 234:
				strFieldValue = StrTool.GBKToUnicode(R000000024);
				break;
			case 235:
				strFieldValue = StrTool.GBKToUnicode(R000000025);
				break;
			case 236:
				strFieldValue = StrTool.GBKToUnicode(R000000026);
				break;
			case 237:
				strFieldValue = StrTool.GBKToUnicode(R000000027);
				break;
			case 238:
				strFieldValue = StrTool.GBKToUnicode(R000000028);
				break;
			case 239:
				strFieldValue = StrTool.GBKToUnicode(R000000029);
				break;
			case 240:
				strFieldValue = StrTool.GBKToUnicode(R000000030);
				break;
			case 241:
				strFieldValue = StrTool.GBKToUnicode(R000000031);
				break;
			case 242:
				strFieldValue = StrTool.GBKToUnicode(R000000032);
				break;
			case 243:
				strFieldValue = StrTool.GBKToUnicode(R000000033);
				break;
			case 244:
				strFieldValue = StrTool.GBKToUnicode(R000000034);
				break;
			case 245:
				strFieldValue = StrTool.GBKToUnicode(R000000035);
				break;
			case 246:
				strFieldValue = StrTool.GBKToUnicode(R000000036);
				break;
			case 247:
				strFieldValue = StrTool.GBKToUnicode(R000000037);
				break;
			case 248:
				strFieldValue = StrTool.GBKToUnicode(R000000038);
				break;
			case 249:
				strFieldValue = StrTool.GBKToUnicode(R000000039);
				break;
			case 250:
				strFieldValue = StrTool.GBKToUnicode(R000000040);
				break;
			case 251:
				strFieldValue = StrTool.GBKToUnicode(R000000041);
				break;
			case 252:
				strFieldValue = StrTool.GBKToUnicode(R000000042);
				break;
			case 253:
				strFieldValue = StrTool.GBKToUnicode(R000000043);
				break;
			case 254:
				strFieldValue = StrTool.GBKToUnicode(R000000044);
				break;
			case 255:
				strFieldValue = StrTool.GBKToUnicode(R000000045);
				break;
			case 256:
				strFieldValue = StrTool.GBKToUnicode(R000000046);
				break;
			case 257:
				strFieldValue = StrTool.GBKToUnicode(R000000047);
				break;
			case 258:
				strFieldValue = StrTool.GBKToUnicode(R000000048);
				break;
			case 259:
				strFieldValue = StrTool.GBKToUnicode(R000000049);
				break;
			case 260:
				strFieldValue = StrTool.GBKToUnicode(R000000050);
				break;
			case 261:
				strFieldValue = StrTool.GBKToUnicode(R000000051);
				break;
			case 262:
				strFieldValue = StrTool.GBKToUnicode(R000000052);
				break;
			case 263:
				strFieldValue = StrTool.GBKToUnicode(R000000053);
				break;
			case 264:
				strFieldValue = StrTool.GBKToUnicode(R000000054);
				break;
			case 265:
				strFieldValue = StrTool.GBKToUnicode(R000000055);
				break;
			case 266:
				strFieldValue = StrTool.GBKToUnicode(R000000056);
				break;
			case 267:
				strFieldValue = StrTool.GBKToUnicode(R000000057);
				break;
			case 268:
				strFieldValue = StrTool.GBKToUnicode(R000000058);
				break;
			case 269:
				strFieldValue = StrTool.GBKToUnicode(R000000059);
				break;
			case 270:
				strFieldValue = StrTool.GBKToUnicode(R000000060);
				break;
			case 271:
				strFieldValue = StrTool.GBKToUnicode(R000000061);
				break;
			case 272:
				strFieldValue = StrTool.GBKToUnicode(R000000062);
				break;
			case 273:
				strFieldValue = StrTool.GBKToUnicode(R000000063);
				break;
			case 274:
				strFieldValue = StrTool.GBKToUnicode(R000000064);
				break;
			case 275:
				strFieldValue = StrTool.GBKToUnicode(R000000065);
				break;
			case 276:
				strFieldValue = StrTool.GBKToUnicode(R000000066);
				break;
			case 277:
				strFieldValue = StrTool.GBKToUnicode(R000000067);
				break;
			case 278:
				strFieldValue = StrTool.GBKToUnicode(R000000068);
				break;
			case 279:
				strFieldValue = StrTool.GBKToUnicode(R000000069);
				break;
			case 280:
				strFieldValue = StrTool.GBKToUnicode(R000000070);
				break;
			case 281:
				strFieldValue = StrTool.GBKToUnicode(R000000071);
				break;
			case 282:
				strFieldValue = StrTool.GBKToUnicode(R000000072);
				break;
			case 283:
				strFieldValue = StrTool.GBKToUnicode(R000000073);
				break;
			case 284:
				strFieldValue = StrTool.GBKToUnicode(R000000074);
				break;
			case 285:
				strFieldValue = StrTool.GBKToUnicode(R000000075);
				break;
			case 286:
				strFieldValue = StrTool.GBKToUnicode(R000000076);
				break;
			case 287:
				strFieldValue = StrTool.GBKToUnicode(R000000077);
				break;
			case 288:
				strFieldValue = StrTool.GBKToUnicode(R000000078);
				break;
			case 289:
				strFieldValue = StrTool.GBKToUnicode(R000000079);
				break;
			case 290:
				strFieldValue = StrTool.GBKToUnicode(R000000080);
				break;
			case 291:
				strFieldValue = StrTool.GBKToUnicode(R000000081);
				break;
			case 292:
				strFieldValue = StrTool.GBKToUnicode(R000000082);
				break;
			case 293:
				strFieldValue = StrTool.GBKToUnicode(R000000083);
				break;
			case 294:
				strFieldValue = StrTool.GBKToUnicode(R000000084);
				break;
			case 295:
				strFieldValue = StrTool.GBKToUnicode(R000000085);
				break;
			case 296:
				strFieldValue = StrTool.GBKToUnicode(R000000086);
				break;
			case 297:
				strFieldValue = StrTool.GBKToUnicode(R000000087);
				break;
			case 298:
				strFieldValue = StrTool.GBKToUnicode(R000000088);
				break;
			case 299:
				strFieldValue = StrTool.GBKToUnicode(R000000089);
				break;
			case 300:
				strFieldValue = StrTool.GBKToUnicode(R000000090);
				break;
			case 301:
				strFieldValue = StrTool.GBKToUnicode(R000000091);
				break;
			case 302:
				strFieldValue = StrTool.GBKToUnicode(R000000092);
				break;
			case 303:
				strFieldValue = StrTool.GBKToUnicode(R000000093);
				break;
			case 304:
				strFieldValue = StrTool.GBKToUnicode(R000000094);
				break;
			case 305:
				strFieldValue = StrTool.GBKToUnicode(R000000095);
				break;
			case 306:
				strFieldValue = StrTool.GBKToUnicode(R000000096);
				break;
			case 307:
				strFieldValue = StrTool.GBKToUnicode(R000000097);
				break;
			case 308:
				strFieldValue = StrTool.GBKToUnicode(R000000098);
				break;
			case 309:
				strFieldValue = StrTool.GBKToUnicode(R000000099);
				break;
			case 310:
				strFieldValue = StrTool.GBKToUnicode(R000000100);
				break;
			case 311:
				strFieldValue = StrTool.GBKToUnicode(R000000101);
				break;
			case 312:
				strFieldValue = StrTool.GBKToUnicode(R000000102);
				break;
			case 313:
				strFieldValue = StrTool.GBKToUnicode(R000000103);
				break;
			case 314:
				strFieldValue = StrTool.GBKToUnicode(R000000104);
				break;
			case 315:
				strFieldValue = StrTool.GBKToUnicode(R000000105);
				break;
			case 316:
				strFieldValue = StrTool.GBKToUnicode(R000000106);
				break;
			case 317:
				strFieldValue = StrTool.GBKToUnicode(R000000107);
				break;
			case 318:
				strFieldValue = StrTool.GBKToUnicode(R000000108);
				break;
			case 319:
				strFieldValue = StrTool.GBKToUnicode(R000000109);
				break;
			case 320:
				strFieldValue = StrTool.GBKToUnicode(R000000110);
				break;
			case 321:
				strFieldValue = StrTool.GBKToUnicode(R000000111);
				break;
			case 322:
				strFieldValue = StrTool.GBKToUnicode(R000000112);
				break;
			case 323:
				strFieldValue = StrTool.GBKToUnicode(R000000113);
				break;
			case 324:
				strFieldValue = StrTool.GBKToUnicode(R000000114);
				break;
			case 325:
				strFieldValue = StrTool.GBKToUnicode(R000000115);
				break;
			case 326:
				strFieldValue = StrTool.GBKToUnicode(R000000116);
				break;
			case 327:
				strFieldValue = StrTool.GBKToUnicode(R000000117);
				break;
			case 328:
				strFieldValue = StrTool.GBKToUnicode(R000000118);
				break;
			case 329:
				strFieldValue = StrTool.GBKToUnicode(R000000119);
				break;
			case 330:
				strFieldValue = StrTool.GBKToUnicode(R000000120);
				break;
			case 331:
				strFieldValue = StrTool.GBKToUnicode(R000000121);
				break;
			case 332:
				strFieldValue = StrTool.GBKToUnicode(R000000122);
				break;
			case 333:
				strFieldValue = StrTool.GBKToUnicode(R000000123);
				break;
			case 334:
				strFieldValue = StrTool.GBKToUnicode(R000000124);
				break;
			case 335:
				strFieldValue = StrTool.GBKToUnicode(R000000125);
				break;
			case 336:
				strFieldValue = StrTool.GBKToUnicode(R000000126);
				break;
			case 337:
				strFieldValue = StrTool.GBKToUnicode(R000000127);
				break;
			case 338:
				strFieldValue = StrTool.GBKToUnicode(R000000128);
				break;
			case 339:
				strFieldValue = StrTool.GBKToUnicode(R000000129);
				break;
			case 340:
				strFieldValue = StrTool.GBKToUnicode(R000000130);
				break;
			case 341:
				strFieldValue = StrTool.GBKToUnicode(R000000131);
				break;
			case 342:
				strFieldValue = StrTool.GBKToUnicode(R000000132);
				break;
			case 343:
				strFieldValue = StrTool.GBKToUnicode(R000000133);
				break;
			case 344:
				strFieldValue = StrTool.GBKToUnicode(R000000134);
				break;
			case 345:
				strFieldValue = StrTool.GBKToUnicode(R000000135);
				break;
			case 346:
				strFieldValue = StrTool.GBKToUnicode(R000000136);
				break;
			case 347:
				strFieldValue = StrTool.GBKToUnicode(R000000137);
				break;
			case 348:
				strFieldValue = StrTool.GBKToUnicode(R000000138);
				break;
			case 349:
				strFieldValue = StrTool.GBKToUnicode(R000000139);
				break;
			case 350:
				strFieldValue = StrTool.GBKToUnicode(R000000140);
				break;
			case 351:
				strFieldValue = StrTool.GBKToUnicode(R000000141);
				break;
			case 352:
				strFieldValue = StrTool.GBKToUnicode(R000000142);
				break;
			case 353:
				strFieldValue = StrTool.GBKToUnicode(R000000143);
				break;
			case 354:
				strFieldValue = StrTool.GBKToUnicode(R000000144);
				break;
			case 355:
				strFieldValue = StrTool.GBKToUnicode(R000000145);
				break;
			case 356:
				strFieldValue = StrTool.GBKToUnicode(R000000146);
				break;
			case 357:
				strFieldValue = StrTool.GBKToUnicode(R000000147);
				break;
			case 358:
				strFieldValue = StrTool.GBKToUnicode(R000000148);
				break;
			case 359:
				strFieldValue = StrTool.GBKToUnicode(R000000149);
				break;
			case 360:
				strFieldValue = StrTool.GBKToUnicode(R000000150);
				break;
			case 361:
				strFieldValue = StrTool.GBKToUnicode(R000000151);
				break;
			case 362:
				strFieldValue = StrTool.GBKToUnicode(R000000152);
				break;
			case 363:
				strFieldValue = StrTool.GBKToUnicode(R000000153);
				break;
			case 364:
				strFieldValue = StrTool.GBKToUnicode(R000000154);
				break;
			case 365:
				strFieldValue = StrTool.GBKToUnicode(R000000155);
				break;
			case 366:
				strFieldValue = StrTool.GBKToUnicode(R000000156);
				break;
			case 367:
				strFieldValue = StrTool.GBKToUnicode(R000000157);
				break;
			case 368:
				strFieldValue = StrTool.GBKToUnicode(R000000158);
				break;
			case 369:
				strFieldValue = StrTool.GBKToUnicode(R000000159);
				break;
			case 370:
				strFieldValue = StrTool.GBKToUnicode(R000000160);
				break;
			case 371:
				strFieldValue = StrTool.GBKToUnicode(R000000161);
				break;
			case 372:
				strFieldValue = StrTool.GBKToUnicode(R000000162);
				break;
			case 373:
				strFieldValue = StrTool.GBKToUnicode(R000000163);
				break;
			case 374:
				strFieldValue = StrTool.GBKToUnicode(R000000164);
				break;
			case 375:
				strFieldValue = StrTool.GBKToUnicode(R000000165);
				break;
			case 376:
				strFieldValue = StrTool.GBKToUnicode(R000000166);
				break;
			case 377:
				strFieldValue = StrTool.GBKToUnicode(R000000167);
				break;
			case 378:
				strFieldValue = StrTool.GBKToUnicode(R000000168);
				break;
			case 379:
				strFieldValue = StrTool.GBKToUnicode(R000000169);
				break;
			case 380:
				strFieldValue = StrTool.GBKToUnicode(R000000170);
				break;
			case 381:
				strFieldValue = StrTool.GBKToUnicode(R000000171);
				break;
			case 382:
				strFieldValue = StrTool.GBKToUnicode(R000000172);
				break;
			case 383:
				strFieldValue = StrTool.GBKToUnicode(R000000173);
				break;
			case 384:
				strFieldValue = StrTool.GBKToUnicode(R000000174);
				break;
			case 385:
				strFieldValue = StrTool.GBKToUnicode(R000000175);
				break;
			case 386:
				strFieldValue = StrTool.GBKToUnicode(R000000176);
				break;
			case 387:
				strFieldValue = StrTool.GBKToUnicode(R000000177);
				break;
			case 388:
				strFieldValue = StrTool.GBKToUnicode(R000000178);
				break;
			case 389:
				strFieldValue = StrTool.GBKToUnicode(R000000179);
				break;
			case 390:
				strFieldValue = StrTool.GBKToUnicode(R000000180);
				break;
			case 391:
				strFieldValue = StrTool.GBKToUnicode(R000000181);
				break;
			case 392:
				strFieldValue = StrTool.GBKToUnicode(R000000182);
				break;
			case 393:
				strFieldValue = StrTool.GBKToUnicode(R000000183);
				break;
			case 394:
				strFieldValue = StrTool.GBKToUnicode(R000000184);
				break;
			case 395:
				strFieldValue = StrTool.GBKToUnicode(R000000185);
				break;
			case 396:
				strFieldValue = StrTool.GBKToUnicode(R000000186);
				break;
			case 397:
				strFieldValue = StrTool.GBKToUnicode(R000000187);
				break;
			case 398:
				strFieldValue = StrTool.GBKToUnicode(R000000188);
				break;
			case 399:
				strFieldValue = StrTool.GBKToUnicode(R000000189);
				break;
			case 400:
				strFieldValue = StrTool.GBKToUnicode(R000000190);
				break;
			case 401:
				strFieldValue = StrTool.GBKToUnicode(R000000191);
				break;
			case 402:
				strFieldValue = StrTool.GBKToUnicode(R000000192);
				break;
			case 403:
				strFieldValue = StrTool.GBKToUnicode(R000000193);
				break;
			case 404:
				strFieldValue = StrTool.GBKToUnicode(R000000194);
				break;
			case 405:
				strFieldValue = StrTool.GBKToUnicode(R000000195);
				break;
			case 406:
				strFieldValue = StrTool.GBKToUnicode(R000000196);
				break;
			case 407:
				strFieldValue = StrTool.GBKToUnicode(R000000197);
				break;
			case 408:
				strFieldValue = StrTool.GBKToUnicode(R000000198);
				break;
			case 409:
				strFieldValue = StrTool.GBKToUnicode(R000000199);
				break;
			case 410:
				strFieldValue = StrTool.GBKToUnicode(R000000200);
				break;
			case 411:
				strFieldValue = StrTool.GBKToUnicode(I000000201);
				break;
			case 412:
				strFieldValue = StrTool.GBKToUnicode(I000000202);
				break;
			case 413:
				strFieldValue = StrTool.GBKToUnicode(I000000203);
				break;
			case 414:
				strFieldValue = StrTool.GBKToUnicode(I000000209);
				break;
			case 415:
				strFieldValue = StrTool.GBKToUnicode(I000000210);
				break;
			case 416:
				strFieldValue = StrTool.GBKToUnicode(I000000213);
				break;
			case 417:
				strFieldValue = StrTool.GBKToUnicode(I000000214);
				break;
			case 418:
				strFieldValue = StrTool.GBKToUnicode(I000000215);
				break;
			case 419:
				strFieldValue = StrTool.GBKToUnicode(I000000216);
				break;
			case 420:
				strFieldValue = StrTool.GBKToUnicode(I000000217);
				break;
			case 421:
				strFieldValue = StrTool.GBKToUnicode(I000000218);
				break;
			case 422:
				strFieldValue = StrTool.GBKToUnicode(I000000219);
				break;
			case 423:
				strFieldValue = StrTool.GBKToUnicode(I000000220);
				break;
			case 424:
				strFieldValue = StrTool.GBKToUnicode(I000000221);
				break;
			case 425:
				strFieldValue = StrTool.GBKToUnicode(I000000222);
				break;
			case 426:
				strFieldValue = StrTool.GBKToUnicode(I000000224);
				break;
			case 427:
				strFieldValue = StrTool.GBKToUnicode(I000000225);
				break;
			case 428:
				strFieldValue = StrTool.GBKToUnicode(I000000226);
				break;
			case 429:
				strFieldValue = StrTool.GBKToUnicode(I000000227);
				break;
			case 430:
				strFieldValue = StrTool.GBKToUnicode(I000000228);
				break;
			case 431:
				strFieldValue = StrTool.GBKToUnicode(I000000229);
				break;
			case 432:
				strFieldValue = StrTool.GBKToUnicode(I000000231);
				break;
			case 433:
				strFieldValue = StrTool.GBKToUnicode(I000000232);
				break;
			case 434:
				strFieldValue = StrTool.GBKToUnicode(I000000233);
				break;
			case 435:
				strFieldValue = StrTool.GBKToUnicode(I000000234);
				break;
			case 436:
				strFieldValue = StrTool.GBKToUnicode(I000000235);
				break;
			case 437:
				strFieldValue = StrTool.GBKToUnicode(I000000236);
				break;
			case 438:
				strFieldValue = StrTool.GBKToUnicode(I000000237);
				break;
			case 439:
				strFieldValue = StrTool.GBKToUnicode(I000000240);
				break;
			case 440:
				strFieldValue = StrTool.GBKToUnicode(I000000241);
				break;
			case 441:
				strFieldValue = StrTool.GBKToUnicode(I000000242);
				break;
			case 442:
				strFieldValue = StrTool.GBKToUnicode(I000000243);
				break;
			case 443:
				strFieldValue = StrTool.GBKToUnicode(I000000244);
				break;
			case 444:
				strFieldValue = StrTool.GBKToUnicode(I000000245);
				break;
			case 445:
				strFieldValue = StrTool.GBKToUnicode(I000000246);
				break;
			case 446:
				strFieldValue = StrTool.GBKToUnicode(I000000247);
				break;
			case 447:
				strFieldValue = StrTool.GBKToUnicode(I000000248);
				break;
			case 448:
				strFieldValue = StrTool.GBKToUnicode(I000000249);
				break;
			case 449:
				strFieldValue = StrTool.GBKToUnicode(I000000250);
				break;
			case 450:
				strFieldValue = StrTool.GBKToUnicode(I000000251);
				break;
			case 451:
				strFieldValue = StrTool.GBKToUnicode(R000000201);
				break;
			case 452:
				strFieldValue = StrTool.GBKToUnicode(R000000202);
				break;
			case 453:
				strFieldValue = StrTool.GBKToUnicode(R000000203);
				break;
			case 454:
				strFieldValue = StrTool.GBKToUnicode(R000000204);
				break;
			case 455:
				strFieldValue = StrTool.GBKToUnicode(R000000205);
				break;
			case 456:
				strFieldValue = StrTool.GBKToUnicode(I000000254);
				break;
			default:
				strFieldValue = "";
		};
		if( strFieldValue.equals("") ) {
			strFieldValue = "null";
		}
		return strFieldValue;
	}

	/**
	* 设置对应传入参数的String形式的字段值
	* @param: FCode String 需要赋值的对象
	* @param: FValue String 要赋的值
	* @return: boolean
	**/
	public boolean setV(String FCode ,String FValue)
	{
		if( StrTool.cTrim( FCode ).equals( "" ))
			return false;

		if (FCode.equalsIgnoreCase("WageNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				WageNo = FValue.trim();
			}
			else
				WageNo = null;
		}
		if (FCode.equalsIgnoreCase("BranchType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BranchType = FValue.trim();
			}
			else
				BranchType = null;
		}
		if (FCode.equalsIgnoreCase("IndexType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				IndexType = FValue.trim();
			}
			else
				IndexType = null;
		}
		if (FCode.equalsIgnoreCase("AgentCode"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentCode = FValue.trim();
			}
			else
				AgentCode = null;
		}
		if (FCode.equalsIgnoreCase("AgentGrade"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGrade = FValue.trim();
			}
			else
				AgentGrade = null;
		}
		if (FCode.equalsIgnoreCase("AgentGroup"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				AgentGroup = FValue.trim();
			}
			else
				AgentGroup = null;
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				State = FValue.trim();
			}
			else
				State = null;
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MakeDate = fDate.getDate( FValue );
			}
			else
				MakeDate = null;
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MakeTime = FValue.trim();
			}
			else
				MakeTime = null;
		}
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ModifyDate = fDate.getDate( FValue );
			}
			else
				ModifyDate = null;
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyTime = FValue.trim();
			}
			else
				ModifyTime = null;
		}
		if (FCode.equalsIgnoreCase("I000000001"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000001 = FValue.trim();
			}
			else
				I000000001 = null;
		}
		if (FCode.equalsIgnoreCase("I000000002"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000002 = FValue.trim();
			}
			else
				I000000002 = null;
		}
		if (FCode.equalsIgnoreCase("I000000003"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000003 = FValue.trim();
			}
			else
				I000000003 = null;
		}
		if (FCode.equalsIgnoreCase("I000000004"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000004 = FValue.trim();
			}
			else
				I000000004 = null;
		}
		if (FCode.equalsIgnoreCase("I000000005"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000005 = FValue.trim();
			}
			else
				I000000005 = null;
		}
		if (FCode.equalsIgnoreCase("I000000006"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000006 = FValue.trim();
			}
			else
				I000000006 = null;
		}
		if (FCode.equalsIgnoreCase("I000000007"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000007 = FValue.trim();
			}
			else
				I000000007 = null;
		}
		if (FCode.equalsIgnoreCase("I000000008"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000008 = FValue.trim();
			}
			else
				I000000008 = null;
		}
		if (FCode.equalsIgnoreCase("I000000009"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000009 = FValue.trim();
			}
			else
				I000000009 = null;
		}
		if (FCode.equalsIgnoreCase("I000000010"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000010 = FValue.trim();
			}
			else
				I000000010 = null;
		}
		if (FCode.equalsIgnoreCase("I000000011"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000011 = FValue.trim();
			}
			else
				I000000011 = null;
		}
		if (FCode.equalsIgnoreCase("I000000012"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000012 = FValue.trim();
			}
			else
				I000000012 = null;
		}
		if (FCode.equalsIgnoreCase("I000000013"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000013 = FValue.trim();
			}
			else
				I000000013 = null;
		}
		if (FCode.equalsIgnoreCase("I000000014"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000014 = FValue.trim();
			}
			else
				I000000014 = null;
		}
		if (FCode.equalsIgnoreCase("I000000015"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000015 = FValue.trim();
			}
			else
				I000000015 = null;
		}
		if (FCode.equalsIgnoreCase("I000000016"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000016 = FValue.trim();
			}
			else
				I000000016 = null;
		}
		if (FCode.equalsIgnoreCase("I000000017"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000017 = FValue.trim();
			}
			else
				I000000017 = null;
		}
		if (FCode.equalsIgnoreCase("I000000018"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000018 = FValue.trim();
			}
			else
				I000000018 = null;
		}
		if (FCode.equalsIgnoreCase("I000000019"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000019 = FValue.trim();
			}
			else
				I000000019 = null;
		}
		if (FCode.equalsIgnoreCase("I000000020"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000020 = FValue.trim();
			}
			else
				I000000020 = null;
		}
		if (FCode.equalsIgnoreCase("I000000021"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000021 = FValue.trim();
			}
			else
				I000000021 = null;
		}
		if (FCode.equalsIgnoreCase("I000000022"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000022 = FValue.trim();
			}
			else
				I000000022 = null;
		}
		if (FCode.equalsIgnoreCase("I000000023"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000023 = FValue.trim();
			}
			else
				I000000023 = null;
		}
		if (FCode.equalsIgnoreCase("I000000024"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000024 = FValue.trim();
			}
			else
				I000000024 = null;
		}
		if (FCode.equalsIgnoreCase("I000000025"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000025 = FValue.trim();
			}
			else
				I000000025 = null;
		}
		if (FCode.equalsIgnoreCase("I000000026"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000026 = FValue.trim();
			}
			else
				I000000026 = null;
		}
		if (FCode.equalsIgnoreCase("I000000027"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000027 = FValue.trim();
			}
			else
				I000000027 = null;
		}
		if (FCode.equalsIgnoreCase("I000000028"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000028 = FValue.trim();
			}
			else
				I000000028 = null;
		}
		if (FCode.equalsIgnoreCase("I000000029"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000029 = FValue.trim();
			}
			else
				I000000029 = null;
		}
		if (FCode.equalsIgnoreCase("I000000030"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000030 = FValue.trim();
			}
			else
				I000000030 = null;
		}
		if (FCode.equalsIgnoreCase("I000000031"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000031 = FValue.trim();
			}
			else
				I000000031 = null;
		}
		if (FCode.equalsIgnoreCase("I000000032"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000032 = FValue.trim();
			}
			else
				I000000032 = null;
		}
		if (FCode.equalsIgnoreCase("I000000033"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000033 = FValue.trim();
			}
			else
				I000000033 = null;
		}
		if (FCode.equalsIgnoreCase("I000000034"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000034 = FValue.trim();
			}
			else
				I000000034 = null;
		}
		if (FCode.equalsIgnoreCase("I000000035"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000035 = FValue.trim();
			}
			else
				I000000035 = null;
		}
		if (FCode.equalsIgnoreCase("I000000036"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000036 = FValue.trim();
			}
			else
				I000000036 = null;
		}
		if (FCode.equalsIgnoreCase("I000000037"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000037 = FValue.trim();
			}
			else
				I000000037 = null;
		}
		if (FCode.equalsIgnoreCase("I000000038"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000038 = FValue.trim();
			}
			else
				I000000038 = null;
		}
		if (FCode.equalsIgnoreCase("I000000039"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000039 = FValue.trim();
			}
			else
				I000000039 = null;
		}
		if (FCode.equalsIgnoreCase("I000000040"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000040 = FValue.trim();
			}
			else
				I000000040 = null;
		}
		if (FCode.equalsIgnoreCase("I000000041"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000041 = FValue.trim();
			}
			else
				I000000041 = null;
		}
		if (FCode.equalsIgnoreCase("I000000042"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000042 = FValue.trim();
			}
			else
				I000000042 = null;
		}
		if (FCode.equalsIgnoreCase("I000000043"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000043 = FValue.trim();
			}
			else
				I000000043 = null;
		}
		if (FCode.equalsIgnoreCase("I000000044"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000044 = FValue.trim();
			}
			else
				I000000044 = null;
		}
		if (FCode.equalsIgnoreCase("I000000045"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000045 = FValue.trim();
			}
			else
				I000000045 = null;
		}
		if (FCode.equalsIgnoreCase("I000000046"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000046 = FValue.trim();
			}
			else
				I000000046 = null;
		}
		if (FCode.equalsIgnoreCase("I000000047"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000047 = FValue.trim();
			}
			else
				I000000047 = null;
		}
		if (FCode.equalsIgnoreCase("I000000048"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000048 = FValue.trim();
			}
			else
				I000000048 = null;
		}
		if (FCode.equalsIgnoreCase("I000000049"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000049 = FValue.trim();
			}
			else
				I000000049 = null;
		}
		if (FCode.equalsIgnoreCase("I000000050"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000050 = FValue.trim();
			}
			else
				I000000050 = null;
		}
		if (FCode.equalsIgnoreCase("I000000051"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000051 = FValue.trim();
			}
			else
				I000000051 = null;
		}
		if (FCode.equalsIgnoreCase("I000000052"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000052 = FValue.trim();
			}
			else
				I000000052 = null;
		}
		if (FCode.equalsIgnoreCase("I000000053"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000053 = FValue.trim();
			}
			else
				I000000053 = null;
		}
		if (FCode.equalsIgnoreCase("I000000054"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000054 = FValue.trim();
			}
			else
				I000000054 = null;
		}
		if (FCode.equalsIgnoreCase("I000000055"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000055 = FValue.trim();
			}
			else
				I000000055 = null;
		}
		if (FCode.equalsIgnoreCase("I000000056"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000056 = FValue.trim();
			}
			else
				I000000056 = null;
		}
		if (FCode.equalsIgnoreCase("I000000057"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000057 = FValue.trim();
			}
			else
				I000000057 = null;
		}
		if (FCode.equalsIgnoreCase("I000000058"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000058 = FValue.trim();
			}
			else
				I000000058 = null;
		}
		if (FCode.equalsIgnoreCase("I000000059"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000059 = FValue.trim();
			}
			else
				I000000059 = null;
		}
		if (FCode.equalsIgnoreCase("I000000060"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000060 = FValue.trim();
			}
			else
				I000000060 = null;
		}
		if (FCode.equalsIgnoreCase("I000000061"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000061 = FValue.trim();
			}
			else
				I000000061 = null;
		}
		if (FCode.equalsIgnoreCase("I000000062"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000062 = FValue.trim();
			}
			else
				I000000062 = null;
		}
		if (FCode.equalsIgnoreCase("I000000063"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000063 = FValue.trim();
			}
			else
				I000000063 = null;
		}
		if (FCode.equalsIgnoreCase("I000000064"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000064 = FValue.trim();
			}
			else
				I000000064 = null;
		}
		if (FCode.equalsIgnoreCase("I000000065"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000065 = FValue.trim();
			}
			else
				I000000065 = null;
		}
		if (FCode.equalsIgnoreCase("I000000066"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000066 = FValue.trim();
			}
			else
				I000000066 = null;
		}
		if (FCode.equalsIgnoreCase("I000000067"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000067 = FValue.trim();
			}
			else
				I000000067 = null;
		}
		if (FCode.equalsIgnoreCase("I000000068"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000068 = FValue.trim();
			}
			else
				I000000068 = null;
		}
		if (FCode.equalsIgnoreCase("I000000069"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000069 = FValue.trim();
			}
			else
				I000000069 = null;
		}
		if (FCode.equalsIgnoreCase("I000000070"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000070 = FValue.trim();
			}
			else
				I000000070 = null;
		}
		if (FCode.equalsIgnoreCase("I000000071"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000071 = FValue.trim();
			}
			else
				I000000071 = null;
		}
		if (FCode.equalsIgnoreCase("I000000072"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000072 = FValue.trim();
			}
			else
				I000000072 = null;
		}
		if (FCode.equalsIgnoreCase("I000000073"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000073 = FValue.trim();
			}
			else
				I000000073 = null;
		}
		if (FCode.equalsIgnoreCase("I000000074"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000074 = FValue.trim();
			}
			else
				I000000074 = null;
		}
		if (FCode.equalsIgnoreCase("I000000075"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000075 = FValue.trim();
			}
			else
				I000000075 = null;
		}
		if (FCode.equalsIgnoreCase("I000000076"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000076 = FValue.trim();
			}
			else
				I000000076 = null;
		}
		if (FCode.equalsIgnoreCase("I000000077"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000077 = FValue.trim();
			}
			else
				I000000077 = null;
		}
		if (FCode.equalsIgnoreCase("I000000078"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000078 = FValue.trim();
			}
			else
				I000000078 = null;
		}
		if (FCode.equalsIgnoreCase("I000000079"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000079 = FValue.trim();
			}
			else
				I000000079 = null;
		}
		if (FCode.equalsIgnoreCase("I000000080"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000080 = FValue.trim();
			}
			else
				I000000080 = null;
		}
		if (FCode.equalsIgnoreCase("I000000081"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000081 = FValue.trim();
			}
			else
				I000000081 = null;
		}
		if (FCode.equalsIgnoreCase("I000000082"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000082 = FValue.trim();
			}
			else
				I000000082 = null;
		}
		if (FCode.equalsIgnoreCase("I000000083"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000083 = FValue.trim();
			}
			else
				I000000083 = null;
		}
		if (FCode.equalsIgnoreCase("I000000084"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000084 = FValue.trim();
			}
			else
				I000000084 = null;
		}
		if (FCode.equalsIgnoreCase("I000000085"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000085 = FValue.trim();
			}
			else
				I000000085 = null;
		}
		if (FCode.equalsIgnoreCase("I000000086"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000086 = FValue.trim();
			}
			else
				I000000086 = null;
		}
		if (FCode.equalsIgnoreCase("I000000087"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000087 = FValue.trim();
			}
			else
				I000000087 = null;
		}
		if (FCode.equalsIgnoreCase("I000000088"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000088 = FValue.trim();
			}
			else
				I000000088 = null;
		}
		if (FCode.equalsIgnoreCase("I000000089"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000089 = FValue.trim();
			}
			else
				I000000089 = null;
		}
		if (FCode.equalsIgnoreCase("I000000090"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000090 = FValue.trim();
			}
			else
				I000000090 = null;
		}
		if (FCode.equalsIgnoreCase("I000000091"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000091 = FValue.trim();
			}
			else
				I000000091 = null;
		}
		if (FCode.equalsIgnoreCase("I000000092"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000092 = FValue.trim();
			}
			else
				I000000092 = null;
		}
		if (FCode.equalsIgnoreCase("I000000093"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000093 = FValue.trim();
			}
			else
				I000000093 = null;
		}
		if (FCode.equalsIgnoreCase("I000000094"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000094 = FValue.trim();
			}
			else
				I000000094 = null;
		}
		if (FCode.equalsIgnoreCase("I000000095"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000095 = FValue.trim();
			}
			else
				I000000095 = null;
		}
		if (FCode.equalsIgnoreCase("I000000096"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000096 = FValue.trim();
			}
			else
				I000000096 = null;
		}
		if (FCode.equalsIgnoreCase("I000000097"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000097 = FValue.trim();
			}
			else
				I000000097 = null;
		}
		if (FCode.equalsIgnoreCase("I000000098"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000098 = FValue.trim();
			}
			else
				I000000098 = null;
		}
		if (FCode.equalsIgnoreCase("I000000099"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000099 = FValue.trim();
			}
			else
				I000000099 = null;
		}
		if (FCode.equalsIgnoreCase("I000000100"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000100 = FValue.trim();
			}
			else
				I000000100 = null;
		}
		if (FCode.equalsIgnoreCase("I000000101"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000101 = FValue.trim();
			}
			else
				I000000101 = null;
		}
		if (FCode.equalsIgnoreCase("I000000102"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000102 = FValue.trim();
			}
			else
				I000000102 = null;
		}
		if (FCode.equalsIgnoreCase("I000000103"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000103 = FValue.trim();
			}
			else
				I000000103 = null;
		}
		if (FCode.equalsIgnoreCase("I000000104"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000104 = FValue.trim();
			}
			else
				I000000104 = null;
		}
		if (FCode.equalsIgnoreCase("I000000105"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000105 = FValue.trim();
			}
			else
				I000000105 = null;
		}
		if (FCode.equalsIgnoreCase("I000000106"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000106 = FValue.trim();
			}
			else
				I000000106 = null;
		}
		if (FCode.equalsIgnoreCase("I000000107"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000107 = FValue.trim();
			}
			else
				I000000107 = null;
		}
		if (FCode.equalsIgnoreCase("I000000108"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000108 = FValue.trim();
			}
			else
				I000000108 = null;
		}
		if (FCode.equalsIgnoreCase("I000000109"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000109 = FValue.trim();
			}
			else
				I000000109 = null;
		}
		if (FCode.equalsIgnoreCase("I000000110"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000110 = FValue.trim();
			}
			else
				I000000110 = null;
		}
		if (FCode.equalsIgnoreCase("I000000111"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000111 = FValue.trim();
			}
			else
				I000000111 = null;
		}
		if (FCode.equalsIgnoreCase("I000000112"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000112 = FValue.trim();
			}
			else
				I000000112 = null;
		}
		if (FCode.equalsIgnoreCase("I000000113"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000113 = FValue.trim();
			}
			else
				I000000113 = null;
		}
		if (FCode.equalsIgnoreCase("I000000114"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000114 = FValue.trim();
			}
			else
				I000000114 = null;
		}
		if (FCode.equalsIgnoreCase("I000000115"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000115 = FValue.trim();
			}
			else
				I000000115 = null;
		}
		if (FCode.equalsIgnoreCase("I000000116"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000116 = FValue.trim();
			}
			else
				I000000116 = null;
		}
		if (FCode.equalsIgnoreCase("I000000117"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000117 = FValue.trim();
			}
			else
				I000000117 = null;
		}
		if (FCode.equalsIgnoreCase("I000000118"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000118 = FValue.trim();
			}
			else
				I000000118 = null;
		}
		if (FCode.equalsIgnoreCase("I000000119"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000119 = FValue.trim();
			}
			else
				I000000119 = null;
		}
		if (FCode.equalsIgnoreCase("I000000120"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000120 = FValue.trim();
			}
			else
				I000000120 = null;
		}
		if (FCode.equalsIgnoreCase("I000000121"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000121 = FValue.trim();
			}
			else
				I000000121 = null;
		}
		if (FCode.equalsIgnoreCase("I000000122"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000122 = FValue.trim();
			}
			else
				I000000122 = null;
		}
		if (FCode.equalsIgnoreCase("I000000123"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000123 = FValue.trim();
			}
			else
				I000000123 = null;
		}
		if (FCode.equalsIgnoreCase("I000000124"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000124 = FValue.trim();
			}
			else
				I000000124 = null;
		}
		if (FCode.equalsIgnoreCase("I000000125"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000125 = FValue.trim();
			}
			else
				I000000125 = null;
		}
		if (FCode.equalsIgnoreCase("I000000126"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000126 = FValue.trim();
			}
			else
				I000000126 = null;
		}
		if (FCode.equalsIgnoreCase("I000000127"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000127 = FValue.trim();
			}
			else
				I000000127 = null;
		}
		if (FCode.equalsIgnoreCase("I000000128"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000128 = FValue.trim();
			}
			else
				I000000128 = null;
		}
		if (FCode.equalsIgnoreCase("I000000129"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000129 = FValue.trim();
			}
			else
				I000000129 = null;
		}
		if (FCode.equalsIgnoreCase("I000000130"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000130 = FValue.trim();
			}
			else
				I000000130 = null;
		}
		if (FCode.equalsIgnoreCase("I000000131"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000131 = FValue.trim();
			}
			else
				I000000131 = null;
		}
		if (FCode.equalsIgnoreCase("I000000132"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000132 = FValue.trim();
			}
			else
				I000000132 = null;
		}
		if (FCode.equalsIgnoreCase("I000000133"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000133 = FValue.trim();
			}
			else
				I000000133 = null;
		}
		if (FCode.equalsIgnoreCase("I000000134"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000134 = FValue.trim();
			}
			else
				I000000134 = null;
		}
		if (FCode.equalsIgnoreCase("I000000135"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000135 = FValue.trim();
			}
			else
				I000000135 = null;
		}
		if (FCode.equalsIgnoreCase("I000000136"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000136 = FValue.trim();
			}
			else
				I000000136 = null;
		}
		if (FCode.equalsIgnoreCase("I000000137"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000137 = FValue.trim();
			}
			else
				I000000137 = null;
		}
		if (FCode.equalsIgnoreCase("I000000138"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000138 = FValue.trim();
			}
			else
				I000000138 = null;
		}
		if (FCode.equalsIgnoreCase("I000000139"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000139 = FValue.trim();
			}
			else
				I000000139 = null;
		}
		if (FCode.equalsIgnoreCase("I000000140"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000140 = FValue.trim();
			}
			else
				I000000140 = null;
		}
		if (FCode.equalsIgnoreCase("I000000141"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000141 = FValue.trim();
			}
			else
				I000000141 = null;
		}
		if (FCode.equalsIgnoreCase("I000000142"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000142 = FValue.trim();
			}
			else
				I000000142 = null;
		}
		if (FCode.equalsIgnoreCase("I000000143"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000143 = FValue.trim();
			}
			else
				I000000143 = null;
		}
		if (FCode.equalsIgnoreCase("I000000144"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000144 = FValue.trim();
			}
			else
				I000000144 = null;
		}
		if (FCode.equalsIgnoreCase("I000000145"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000145 = FValue.trim();
			}
			else
				I000000145 = null;
		}
		if (FCode.equalsIgnoreCase("I000000146"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000146 = FValue.trim();
			}
			else
				I000000146 = null;
		}
		if (FCode.equalsIgnoreCase("I000000147"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000147 = FValue.trim();
			}
			else
				I000000147 = null;
		}
		if (FCode.equalsIgnoreCase("I000000148"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000148 = FValue.trim();
			}
			else
				I000000148 = null;
		}
		if (FCode.equalsIgnoreCase("I000000149"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000149 = FValue.trim();
			}
			else
				I000000149 = null;
		}
		if (FCode.equalsIgnoreCase("I000000150"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000150 = FValue.trim();
			}
			else
				I000000150 = null;
		}
		if (FCode.equalsIgnoreCase("I000000151"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000151 = FValue.trim();
			}
			else
				I000000151 = null;
		}
		if (FCode.equalsIgnoreCase("I000000152"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000152 = FValue.trim();
			}
			else
				I000000152 = null;
		}
		if (FCode.equalsIgnoreCase("I000000153"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000153 = FValue.trim();
			}
			else
				I000000153 = null;
		}
		if (FCode.equalsIgnoreCase("I000000154"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000154 = FValue.trim();
			}
			else
				I000000154 = null;
		}
		if (FCode.equalsIgnoreCase("I000000155"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000155 = FValue.trim();
			}
			else
				I000000155 = null;
		}
		if (FCode.equalsIgnoreCase("I000000156"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000156 = FValue.trim();
			}
			else
				I000000156 = null;
		}
		if (FCode.equalsIgnoreCase("I000000157"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000157 = FValue.trim();
			}
			else
				I000000157 = null;
		}
		if (FCode.equalsIgnoreCase("I000000158"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000158 = FValue.trim();
			}
			else
				I000000158 = null;
		}
		if (FCode.equalsIgnoreCase("I000000159"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000159 = FValue.trim();
			}
			else
				I000000159 = null;
		}
		if (FCode.equalsIgnoreCase("I000000160"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000160 = FValue.trim();
			}
			else
				I000000160 = null;
		}
		if (FCode.equalsIgnoreCase("I000000161"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000161 = FValue.trim();
			}
			else
				I000000161 = null;
		}
		if (FCode.equalsIgnoreCase("I000000162"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000162 = FValue.trim();
			}
			else
				I000000162 = null;
		}
		if (FCode.equalsIgnoreCase("I000000163"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000163 = FValue.trim();
			}
			else
				I000000163 = null;
		}
		if (FCode.equalsIgnoreCase("I000000164"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000164 = FValue.trim();
			}
			else
				I000000164 = null;
		}
		if (FCode.equalsIgnoreCase("I000000165"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000165 = FValue.trim();
			}
			else
				I000000165 = null;
		}
		if (FCode.equalsIgnoreCase("I000000166"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000166 = FValue.trim();
			}
			else
				I000000166 = null;
		}
		if (FCode.equalsIgnoreCase("I000000167"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000167 = FValue.trim();
			}
			else
				I000000167 = null;
		}
		if (FCode.equalsIgnoreCase("I000000168"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000168 = FValue.trim();
			}
			else
				I000000168 = null;
		}
		if (FCode.equalsIgnoreCase("I000000169"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000169 = FValue.trim();
			}
			else
				I000000169 = null;
		}
		if (FCode.equalsIgnoreCase("I000000170"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000170 = FValue.trim();
			}
			else
				I000000170 = null;
		}
		if (FCode.equalsIgnoreCase("I000000171"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000171 = FValue.trim();
			}
			else
				I000000171 = null;
		}
		if (FCode.equalsIgnoreCase("I000000172"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000172 = FValue.trim();
			}
			else
				I000000172 = null;
		}
		if (FCode.equalsIgnoreCase("I000000173"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000173 = FValue.trim();
			}
			else
				I000000173 = null;
		}
		if (FCode.equalsIgnoreCase("I000000174"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000174 = FValue.trim();
			}
			else
				I000000174 = null;
		}
		if (FCode.equalsIgnoreCase("I000000175"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000175 = FValue.trim();
			}
			else
				I000000175 = null;
		}
		if (FCode.equalsIgnoreCase("I000000176"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000176 = FValue.trim();
			}
			else
				I000000176 = null;
		}
		if (FCode.equalsIgnoreCase("I000000177"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000177 = FValue.trim();
			}
			else
				I000000177 = null;
		}
		if (FCode.equalsIgnoreCase("I000000178"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000178 = FValue.trim();
			}
			else
				I000000178 = null;
		}
		if (FCode.equalsIgnoreCase("I000000179"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000179 = FValue.trim();
			}
			else
				I000000179 = null;
		}
		if (FCode.equalsIgnoreCase("I000000180"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000180 = FValue.trim();
			}
			else
				I000000180 = null;
		}
		if (FCode.equalsIgnoreCase("I000000181"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000181 = FValue.trim();
			}
			else
				I000000181 = null;
		}
		if (FCode.equalsIgnoreCase("I000000182"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000182 = FValue.trim();
			}
			else
				I000000182 = null;
		}
		if (FCode.equalsIgnoreCase("I000000183"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000183 = FValue.trim();
			}
			else
				I000000183 = null;
		}
		if (FCode.equalsIgnoreCase("I000000184"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000184 = FValue.trim();
			}
			else
				I000000184 = null;
		}
		if (FCode.equalsIgnoreCase("I000000185"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000185 = FValue.trim();
			}
			else
				I000000185 = null;
		}
		if (FCode.equalsIgnoreCase("I000000186"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000186 = FValue.trim();
			}
			else
				I000000186 = null;
		}
		if (FCode.equalsIgnoreCase("I000000187"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000187 = FValue.trim();
			}
			else
				I000000187 = null;
		}
		if (FCode.equalsIgnoreCase("I000000188"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000188 = FValue.trim();
			}
			else
				I000000188 = null;
		}
		if (FCode.equalsIgnoreCase("I000000189"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000189 = FValue.trim();
			}
			else
				I000000189 = null;
		}
		if (FCode.equalsIgnoreCase("I000000190"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000190 = FValue.trim();
			}
			else
				I000000190 = null;
		}
		if (FCode.equalsIgnoreCase("I000000191"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000191 = FValue.trim();
			}
			else
				I000000191 = null;
		}
		if (FCode.equalsIgnoreCase("I000000192"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000192 = FValue.trim();
			}
			else
				I000000192 = null;
		}
		if (FCode.equalsIgnoreCase("I000000193"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000193 = FValue.trim();
			}
			else
				I000000193 = null;
		}
		if (FCode.equalsIgnoreCase("I000000194"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000194 = FValue.trim();
			}
			else
				I000000194 = null;
		}
		if (FCode.equalsIgnoreCase("I000000195"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000195 = FValue.trim();
			}
			else
				I000000195 = null;
		}
		if (FCode.equalsIgnoreCase("I000000196"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000196 = FValue.trim();
			}
			else
				I000000196 = null;
		}
		if (FCode.equalsIgnoreCase("I000000197"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000197 = FValue.trim();
			}
			else
				I000000197 = null;
		}
		if (FCode.equalsIgnoreCase("I000000198"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000198 = FValue.trim();
			}
			else
				I000000198 = null;
		}
		if (FCode.equalsIgnoreCase("I000000199"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000199 = FValue.trim();
			}
			else
				I000000199 = null;
		}
		if (FCode.equalsIgnoreCase("I000000200"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000200 = FValue.trim();
			}
			else
				I000000200 = null;
		}
		if (FCode.equalsIgnoreCase("R000000001"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000001 = FValue.trim();
			}
			else
				R000000001 = null;
		}
		if (FCode.equalsIgnoreCase("R000000002"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000002 = FValue.trim();
			}
			else
				R000000002 = null;
		}
		if (FCode.equalsIgnoreCase("R000000003"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000003 = FValue.trim();
			}
			else
				R000000003 = null;
		}
		if (FCode.equalsIgnoreCase("R000000004"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000004 = FValue.trim();
			}
			else
				R000000004 = null;
		}
		if (FCode.equalsIgnoreCase("R000000005"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000005 = FValue.trim();
			}
			else
				R000000005 = null;
		}
		if (FCode.equalsIgnoreCase("R000000006"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000006 = FValue.trim();
			}
			else
				R000000006 = null;
		}
		if (FCode.equalsIgnoreCase("R000000007"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000007 = FValue.trim();
			}
			else
				R000000007 = null;
		}
		if (FCode.equalsIgnoreCase("R000000008"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000008 = FValue.trim();
			}
			else
				R000000008 = null;
		}
		if (FCode.equalsIgnoreCase("R000000009"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000009 = FValue.trim();
			}
			else
				R000000009 = null;
		}
		if (FCode.equalsIgnoreCase("R000000010"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000010 = FValue.trim();
			}
			else
				R000000010 = null;
		}
		if (FCode.equalsIgnoreCase("R000000011"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000011 = FValue.trim();
			}
			else
				R000000011 = null;
		}
		if (FCode.equalsIgnoreCase("R000000012"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000012 = FValue.trim();
			}
			else
				R000000012 = null;
		}
		if (FCode.equalsIgnoreCase("R000000013"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000013 = FValue.trim();
			}
			else
				R000000013 = null;
		}
		if (FCode.equalsIgnoreCase("R000000014"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000014 = FValue.trim();
			}
			else
				R000000014 = null;
		}
		if (FCode.equalsIgnoreCase("R000000015"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000015 = FValue.trim();
			}
			else
				R000000015 = null;
		}
		if (FCode.equalsIgnoreCase("R000000016"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000016 = FValue.trim();
			}
			else
				R000000016 = null;
		}
		if (FCode.equalsIgnoreCase("R000000017"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000017 = FValue.trim();
			}
			else
				R000000017 = null;
		}
		if (FCode.equalsIgnoreCase("R000000018"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000018 = FValue.trim();
			}
			else
				R000000018 = null;
		}
		if (FCode.equalsIgnoreCase("R000000019"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000019 = FValue.trim();
			}
			else
				R000000019 = null;
		}
		if (FCode.equalsIgnoreCase("R000000020"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000020 = FValue.trim();
			}
			else
				R000000020 = null;
		}
		if (FCode.equalsIgnoreCase("R000000021"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000021 = FValue.trim();
			}
			else
				R000000021 = null;
		}
		if (FCode.equalsIgnoreCase("R000000022"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000022 = FValue.trim();
			}
			else
				R000000022 = null;
		}
		if (FCode.equalsIgnoreCase("R000000023"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000023 = FValue.trim();
			}
			else
				R000000023 = null;
		}
		if (FCode.equalsIgnoreCase("R000000024"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000024 = FValue.trim();
			}
			else
				R000000024 = null;
		}
		if (FCode.equalsIgnoreCase("R000000025"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000025 = FValue.trim();
			}
			else
				R000000025 = null;
		}
		if (FCode.equalsIgnoreCase("R000000026"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000026 = FValue.trim();
			}
			else
				R000000026 = null;
		}
		if (FCode.equalsIgnoreCase("R000000027"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000027 = FValue.trim();
			}
			else
				R000000027 = null;
		}
		if (FCode.equalsIgnoreCase("R000000028"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000028 = FValue.trim();
			}
			else
				R000000028 = null;
		}
		if (FCode.equalsIgnoreCase("R000000029"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000029 = FValue.trim();
			}
			else
				R000000029 = null;
		}
		if (FCode.equalsIgnoreCase("R000000030"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000030 = FValue.trim();
			}
			else
				R000000030 = null;
		}
		if (FCode.equalsIgnoreCase("R000000031"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000031 = FValue.trim();
			}
			else
				R000000031 = null;
		}
		if (FCode.equalsIgnoreCase("R000000032"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000032 = FValue.trim();
			}
			else
				R000000032 = null;
		}
		if (FCode.equalsIgnoreCase("R000000033"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000033 = FValue.trim();
			}
			else
				R000000033 = null;
		}
		if (FCode.equalsIgnoreCase("R000000034"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000034 = FValue.trim();
			}
			else
				R000000034 = null;
		}
		if (FCode.equalsIgnoreCase("R000000035"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000035 = FValue.trim();
			}
			else
				R000000035 = null;
		}
		if (FCode.equalsIgnoreCase("R000000036"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000036 = FValue.trim();
			}
			else
				R000000036 = null;
		}
		if (FCode.equalsIgnoreCase("R000000037"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000037 = FValue.trim();
			}
			else
				R000000037 = null;
		}
		if (FCode.equalsIgnoreCase("R000000038"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000038 = FValue.trim();
			}
			else
				R000000038 = null;
		}
		if (FCode.equalsIgnoreCase("R000000039"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000039 = FValue.trim();
			}
			else
				R000000039 = null;
		}
		if (FCode.equalsIgnoreCase("R000000040"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000040 = FValue.trim();
			}
			else
				R000000040 = null;
		}
		if (FCode.equalsIgnoreCase("R000000041"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000041 = FValue.trim();
			}
			else
				R000000041 = null;
		}
		if (FCode.equalsIgnoreCase("R000000042"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000042 = FValue.trim();
			}
			else
				R000000042 = null;
		}
		if (FCode.equalsIgnoreCase("R000000043"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000043 = FValue.trim();
			}
			else
				R000000043 = null;
		}
		if (FCode.equalsIgnoreCase("R000000044"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000044 = FValue.trim();
			}
			else
				R000000044 = null;
		}
		if (FCode.equalsIgnoreCase("R000000045"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000045 = FValue.trim();
			}
			else
				R000000045 = null;
		}
		if (FCode.equalsIgnoreCase("R000000046"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000046 = FValue.trim();
			}
			else
				R000000046 = null;
		}
		if (FCode.equalsIgnoreCase("R000000047"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000047 = FValue.trim();
			}
			else
				R000000047 = null;
		}
		if (FCode.equalsIgnoreCase("R000000048"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000048 = FValue.trim();
			}
			else
				R000000048 = null;
		}
		if (FCode.equalsIgnoreCase("R000000049"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000049 = FValue.trim();
			}
			else
				R000000049 = null;
		}
		if (FCode.equalsIgnoreCase("R000000050"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000050 = FValue.trim();
			}
			else
				R000000050 = null;
		}
		if (FCode.equalsIgnoreCase("R000000051"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000051 = FValue.trim();
			}
			else
				R000000051 = null;
		}
		if (FCode.equalsIgnoreCase("R000000052"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000052 = FValue.trim();
			}
			else
				R000000052 = null;
		}
		if (FCode.equalsIgnoreCase("R000000053"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000053 = FValue.trim();
			}
			else
				R000000053 = null;
		}
		if (FCode.equalsIgnoreCase("R000000054"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000054 = FValue.trim();
			}
			else
				R000000054 = null;
		}
		if (FCode.equalsIgnoreCase("R000000055"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000055 = FValue.trim();
			}
			else
				R000000055 = null;
		}
		if (FCode.equalsIgnoreCase("R000000056"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000056 = FValue.trim();
			}
			else
				R000000056 = null;
		}
		if (FCode.equalsIgnoreCase("R000000057"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000057 = FValue.trim();
			}
			else
				R000000057 = null;
		}
		if (FCode.equalsIgnoreCase("R000000058"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000058 = FValue.trim();
			}
			else
				R000000058 = null;
		}
		if (FCode.equalsIgnoreCase("R000000059"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000059 = FValue.trim();
			}
			else
				R000000059 = null;
		}
		if (FCode.equalsIgnoreCase("R000000060"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000060 = FValue.trim();
			}
			else
				R000000060 = null;
		}
		if (FCode.equalsIgnoreCase("R000000061"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000061 = FValue.trim();
			}
			else
				R000000061 = null;
		}
		if (FCode.equalsIgnoreCase("R000000062"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000062 = FValue.trim();
			}
			else
				R000000062 = null;
		}
		if (FCode.equalsIgnoreCase("R000000063"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000063 = FValue.trim();
			}
			else
				R000000063 = null;
		}
		if (FCode.equalsIgnoreCase("R000000064"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000064 = FValue.trim();
			}
			else
				R000000064 = null;
		}
		if (FCode.equalsIgnoreCase("R000000065"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000065 = FValue.trim();
			}
			else
				R000000065 = null;
		}
		if (FCode.equalsIgnoreCase("R000000066"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000066 = FValue.trim();
			}
			else
				R000000066 = null;
		}
		if (FCode.equalsIgnoreCase("R000000067"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000067 = FValue.trim();
			}
			else
				R000000067 = null;
		}
		if (FCode.equalsIgnoreCase("R000000068"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000068 = FValue.trim();
			}
			else
				R000000068 = null;
		}
		if (FCode.equalsIgnoreCase("R000000069"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000069 = FValue.trim();
			}
			else
				R000000069 = null;
		}
		if (FCode.equalsIgnoreCase("R000000070"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000070 = FValue.trim();
			}
			else
				R000000070 = null;
		}
		if (FCode.equalsIgnoreCase("R000000071"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000071 = FValue.trim();
			}
			else
				R000000071 = null;
		}
		if (FCode.equalsIgnoreCase("R000000072"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000072 = FValue.trim();
			}
			else
				R000000072 = null;
		}
		if (FCode.equalsIgnoreCase("R000000073"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000073 = FValue.trim();
			}
			else
				R000000073 = null;
		}
		if (FCode.equalsIgnoreCase("R000000074"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000074 = FValue.trim();
			}
			else
				R000000074 = null;
		}
		if (FCode.equalsIgnoreCase("R000000075"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000075 = FValue.trim();
			}
			else
				R000000075 = null;
		}
		if (FCode.equalsIgnoreCase("R000000076"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000076 = FValue.trim();
			}
			else
				R000000076 = null;
		}
		if (FCode.equalsIgnoreCase("R000000077"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000077 = FValue.trim();
			}
			else
				R000000077 = null;
		}
		if (FCode.equalsIgnoreCase("R000000078"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000078 = FValue.trim();
			}
			else
				R000000078 = null;
		}
		if (FCode.equalsIgnoreCase("R000000079"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000079 = FValue.trim();
			}
			else
				R000000079 = null;
		}
		if (FCode.equalsIgnoreCase("R000000080"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000080 = FValue.trim();
			}
			else
				R000000080 = null;
		}
		if (FCode.equalsIgnoreCase("R000000081"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000081 = FValue.trim();
			}
			else
				R000000081 = null;
		}
		if (FCode.equalsIgnoreCase("R000000082"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000082 = FValue.trim();
			}
			else
				R000000082 = null;
		}
		if (FCode.equalsIgnoreCase("R000000083"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000083 = FValue.trim();
			}
			else
				R000000083 = null;
		}
		if (FCode.equalsIgnoreCase("R000000084"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000084 = FValue.trim();
			}
			else
				R000000084 = null;
		}
		if (FCode.equalsIgnoreCase("R000000085"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000085 = FValue.trim();
			}
			else
				R000000085 = null;
		}
		if (FCode.equalsIgnoreCase("R000000086"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000086 = FValue.trim();
			}
			else
				R000000086 = null;
		}
		if (FCode.equalsIgnoreCase("R000000087"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000087 = FValue.trim();
			}
			else
				R000000087 = null;
		}
		if (FCode.equalsIgnoreCase("R000000088"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000088 = FValue.trim();
			}
			else
				R000000088 = null;
		}
		if (FCode.equalsIgnoreCase("R000000089"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000089 = FValue.trim();
			}
			else
				R000000089 = null;
		}
		if (FCode.equalsIgnoreCase("R000000090"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000090 = FValue.trim();
			}
			else
				R000000090 = null;
		}
		if (FCode.equalsIgnoreCase("R000000091"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000091 = FValue.trim();
			}
			else
				R000000091 = null;
		}
		if (FCode.equalsIgnoreCase("R000000092"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000092 = FValue.trim();
			}
			else
				R000000092 = null;
		}
		if (FCode.equalsIgnoreCase("R000000093"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000093 = FValue.trim();
			}
			else
				R000000093 = null;
		}
		if (FCode.equalsIgnoreCase("R000000094"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000094 = FValue.trim();
			}
			else
				R000000094 = null;
		}
		if (FCode.equalsIgnoreCase("R000000095"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000095 = FValue.trim();
			}
			else
				R000000095 = null;
		}
		if (FCode.equalsIgnoreCase("R000000096"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000096 = FValue.trim();
			}
			else
				R000000096 = null;
		}
		if (FCode.equalsIgnoreCase("R000000097"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000097 = FValue.trim();
			}
			else
				R000000097 = null;
		}
		if (FCode.equalsIgnoreCase("R000000098"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000098 = FValue.trim();
			}
			else
				R000000098 = null;
		}
		if (FCode.equalsIgnoreCase("R000000099"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000099 = FValue.trim();
			}
			else
				R000000099 = null;
		}
		if (FCode.equalsIgnoreCase("R000000100"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000100 = FValue.trim();
			}
			else
				R000000100 = null;
		}
		if (FCode.equalsIgnoreCase("R000000101"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000101 = FValue.trim();
			}
			else
				R000000101 = null;
		}
		if (FCode.equalsIgnoreCase("R000000102"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000102 = FValue.trim();
			}
			else
				R000000102 = null;
		}
		if (FCode.equalsIgnoreCase("R000000103"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000103 = FValue.trim();
			}
			else
				R000000103 = null;
		}
		if (FCode.equalsIgnoreCase("R000000104"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000104 = FValue.trim();
			}
			else
				R000000104 = null;
		}
		if (FCode.equalsIgnoreCase("R000000105"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000105 = FValue.trim();
			}
			else
				R000000105 = null;
		}
		if (FCode.equalsIgnoreCase("R000000106"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000106 = FValue.trim();
			}
			else
				R000000106 = null;
		}
		if (FCode.equalsIgnoreCase("R000000107"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000107 = FValue.trim();
			}
			else
				R000000107 = null;
		}
		if (FCode.equalsIgnoreCase("R000000108"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000108 = FValue.trim();
			}
			else
				R000000108 = null;
		}
		if (FCode.equalsIgnoreCase("R000000109"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000109 = FValue.trim();
			}
			else
				R000000109 = null;
		}
		if (FCode.equalsIgnoreCase("R000000110"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000110 = FValue.trim();
			}
			else
				R000000110 = null;
		}
		if (FCode.equalsIgnoreCase("R000000111"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000111 = FValue.trim();
			}
			else
				R000000111 = null;
		}
		if (FCode.equalsIgnoreCase("R000000112"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000112 = FValue.trim();
			}
			else
				R000000112 = null;
		}
		if (FCode.equalsIgnoreCase("R000000113"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000113 = FValue.trim();
			}
			else
				R000000113 = null;
		}
		if (FCode.equalsIgnoreCase("R000000114"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000114 = FValue.trim();
			}
			else
				R000000114 = null;
		}
		if (FCode.equalsIgnoreCase("R000000115"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000115 = FValue.trim();
			}
			else
				R000000115 = null;
		}
		if (FCode.equalsIgnoreCase("R000000116"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000116 = FValue.trim();
			}
			else
				R000000116 = null;
		}
		if (FCode.equalsIgnoreCase("R000000117"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000117 = FValue.trim();
			}
			else
				R000000117 = null;
		}
		if (FCode.equalsIgnoreCase("R000000118"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000118 = FValue.trim();
			}
			else
				R000000118 = null;
		}
		if (FCode.equalsIgnoreCase("R000000119"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000119 = FValue.trim();
			}
			else
				R000000119 = null;
		}
		if (FCode.equalsIgnoreCase("R000000120"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000120 = FValue.trim();
			}
			else
				R000000120 = null;
		}
		if (FCode.equalsIgnoreCase("R000000121"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000121 = FValue.trim();
			}
			else
				R000000121 = null;
		}
		if (FCode.equalsIgnoreCase("R000000122"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000122 = FValue.trim();
			}
			else
				R000000122 = null;
		}
		if (FCode.equalsIgnoreCase("R000000123"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000123 = FValue.trim();
			}
			else
				R000000123 = null;
		}
		if (FCode.equalsIgnoreCase("R000000124"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000124 = FValue.trim();
			}
			else
				R000000124 = null;
		}
		if (FCode.equalsIgnoreCase("R000000125"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000125 = FValue.trim();
			}
			else
				R000000125 = null;
		}
		if (FCode.equalsIgnoreCase("R000000126"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000126 = FValue.trim();
			}
			else
				R000000126 = null;
		}
		if (FCode.equalsIgnoreCase("R000000127"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000127 = FValue.trim();
			}
			else
				R000000127 = null;
		}
		if (FCode.equalsIgnoreCase("R000000128"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000128 = FValue.trim();
			}
			else
				R000000128 = null;
		}
		if (FCode.equalsIgnoreCase("R000000129"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000129 = FValue.trim();
			}
			else
				R000000129 = null;
		}
		if (FCode.equalsIgnoreCase("R000000130"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000130 = FValue.trim();
			}
			else
				R000000130 = null;
		}
		if (FCode.equalsIgnoreCase("R000000131"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000131 = FValue.trim();
			}
			else
				R000000131 = null;
		}
		if (FCode.equalsIgnoreCase("R000000132"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000132 = FValue.trim();
			}
			else
				R000000132 = null;
		}
		if (FCode.equalsIgnoreCase("R000000133"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000133 = FValue.trim();
			}
			else
				R000000133 = null;
		}
		if (FCode.equalsIgnoreCase("R000000134"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000134 = FValue.trim();
			}
			else
				R000000134 = null;
		}
		if (FCode.equalsIgnoreCase("R000000135"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000135 = FValue.trim();
			}
			else
				R000000135 = null;
		}
		if (FCode.equalsIgnoreCase("R000000136"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000136 = FValue.trim();
			}
			else
				R000000136 = null;
		}
		if (FCode.equalsIgnoreCase("R000000137"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000137 = FValue.trim();
			}
			else
				R000000137 = null;
		}
		if (FCode.equalsIgnoreCase("R000000138"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000138 = FValue.trim();
			}
			else
				R000000138 = null;
		}
		if (FCode.equalsIgnoreCase("R000000139"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000139 = FValue.trim();
			}
			else
				R000000139 = null;
		}
		if (FCode.equalsIgnoreCase("R000000140"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000140 = FValue.trim();
			}
			else
				R000000140 = null;
		}
		if (FCode.equalsIgnoreCase("R000000141"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000141 = FValue.trim();
			}
			else
				R000000141 = null;
		}
		if (FCode.equalsIgnoreCase("R000000142"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000142 = FValue.trim();
			}
			else
				R000000142 = null;
		}
		if (FCode.equalsIgnoreCase("R000000143"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000143 = FValue.trim();
			}
			else
				R000000143 = null;
		}
		if (FCode.equalsIgnoreCase("R000000144"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000144 = FValue.trim();
			}
			else
				R000000144 = null;
		}
		if (FCode.equalsIgnoreCase("R000000145"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000145 = FValue.trim();
			}
			else
				R000000145 = null;
		}
		if (FCode.equalsIgnoreCase("R000000146"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000146 = FValue.trim();
			}
			else
				R000000146 = null;
		}
		if (FCode.equalsIgnoreCase("R000000147"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000147 = FValue.trim();
			}
			else
				R000000147 = null;
		}
		if (FCode.equalsIgnoreCase("R000000148"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000148 = FValue.trim();
			}
			else
				R000000148 = null;
		}
		if (FCode.equalsIgnoreCase("R000000149"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000149 = FValue.trim();
			}
			else
				R000000149 = null;
		}
		if (FCode.equalsIgnoreCase("R000000150"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000150 = FValue.trim();
			}
			else
				R000000150 = null;
		}
		if (FCode.equalsIgnoreCase("R000000151"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000151 = FValue.trim();
			}
			else
				R000000151 = null;
		}
		if (FCode.equalsIgnoreCase("R000000152"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000152 = FValue.trim();
			}
			else
				R000000152 = null;
		}
		if (FCode.equalsIgnoreCase("R000000153"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000153 = FValue.trim();
			}
			else
				R000000153 = null;
		}
		if (FCode.equalsIgnoreCase("R000000154"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000154 = FValue.trim();
			}
			else
				R000000154 = null;
		}
		if (FCode.equalsIgnoreCase("R000000155"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000155 = FValue.trim();
			}
			else
				R000000155 = null;
		}
		if (FCode.equalsIgnoreCase("R000000156"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000156 = FValue.trim();
			}
			else
				R000000156 = null;
		}
		if (FCode.equalsIgnoreCase("R000000157"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000157 = FValue.trim();
			}
			else
				R000000157 = null;
		}
		if (FCode.equalsIgnoreCase("R000000158"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000158 = FValue.trim();
			}
			else
				R000000158 = null;
		}
		if (FCode.equalsIgnoreCase("R000000159"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000159 = FValue.trim();
			}
			else
				R000000159 = null;
		}
		if (FCode.equalsIgnoreCase("R000000160"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000160 = FValue.trim();
			}
			else
				R000000160 = null;
		}
		if (FCode.equalsIgnoreCase("R000000161"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000161 = FValue.trim();
			}
			else
				R000000161 = null;
		}
		if (FCode.equalsIgnoreCase("R000000162"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000162 = FValue.trim();
			}
			else
				R000000162 = null;
		}
		if (FCode.equalsIgnoreCase("R000000163"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000163 = FValue.trim();
			}
			else
				R000000163 = null;
		}
		if (FCode.equalsIgnoreCase("R000000164"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000164 = FValue.trim();
			}
			else
				R000000164 = null;
		}
		if (FCode.equalsIgnoreCase("R000000165"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000165 = FValue.trim();
			}
			else
				R000000165 = null;
		}
		if (FCode.equalsIgnoreCase("R000000166"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000166 = FValue.trim();
			}
			else
				R000000166 = null;
		}
		if (FCode.equalsIgnoreCase("R000000167"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000167 = FValue.trim();
			}
			else
				R000000167 = null;
		}
		if (FCode.equalsIgnoreCase("R000000168"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000168 = FValue.trim();
			}
			else
				R000000168 = null;
		}
		if (FCode.equalsIgnoreCase("R000000169"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000169 = FValue.trim();
			}
			else
				R000000169 = null;
		}
		if (FCode.equalsIgnoreCase("R000000170"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000170 = FValue.trim();
			}
			else
				R000000170 = null;
		}
		if (FCode.equalsIgnoreCase("R000000171"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000171 = FValue.trim();
			}
			else
				R000000171 = null;
		}
		if (FCode.equalsIgnoreCase("R000000172"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000172 = FValue.trim();
			}
			else
				R000000172 = null;
		}
		if (FCode.equalsIgnoreCase("R000000173"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000173 = FValue.trim();
			}
			else
				R000000173 = null;
		}
		if (FCode.equalsIgnoreCase("R000000174"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000174 = FValue.trim();
			}
			else
				R000000174 = null;
		}
		if (FCode.equalsIgnoreCase("R000000175"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000175 = FValue.trim();
			}
			else
				R000000175 = null;
		}
		if (FCode.equalsIgnoreCase("R000000176"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000176 = FValue.trim();
			}
			else
				R000000176 = null;
		}
		if (FCode.equalsIgnoreCase("R000000177"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000177 = FValue.trim();
			}
			else
				R000000177 = null;
		}
		if (FCode.equalsIgnoreCase("R000000178"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000178 = FValue.trim();
			}
			else
				R000000178 = null;
		}
		if (FCode.equalsIgnoreCase("R000000179"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000179 = FValue.trim();
			}
			else
				R000000179 = null;
		}
		if (FCode.equalsIgnoreCase("R000000180"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000180 = FValue.trim();
			}
			else
				R000000180 = null;
		}
		if (FCode.equalsIgnoreCase("R000000181"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000181 = FValue.trim();
			}
			else
				R000000181 = null;
		}
		if (FCode.equalsIgnoreCase("R000000182"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000182 = FValue.trim();
			}
			else
				R000000182 = null;
		}
		if (FCode.equalsIgnoreCase("R000000183"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000183 = FValue.trim();
			}
			else
				R000000183 = null;
		}
		if (FCode.equalsIgnoreCase("R000000184"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000184 = FValue.trim();
			}
			else
				R000000184 = null;
		}
		if (FCode.equalsIgnoreCase("R000000185"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000185 = FValue.trim();
			}
			else
				R000000185 = null;
		}
		if (FCode.equalsIgnoreCase("R000000186"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000186 = FValue.trim();
			}
			else
				R000000186 = null;
		}
		if (FCode.equalsIgnoreCase("R000000187"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000187 = FValue.trim();
			}
			else
				R000000187 = null;
		}
		if (FCode.equalsIgnoreCase("R000000188"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000188 = FValue.trim();
			}
			else
				R000000188 = null;
		}
		if (FCode.equalsIgnoreCase("R000000189"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000189 = FValue.trim();
			}
			else
				R000000189 = null;
		}
		if (FCode.equalsIgnoreCase("R000000190"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000190 = FValue.trim();
			}
			else
				R000000190 = null;
		}
		if (FCode.equalsIgnoreCase("R000000191"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000191 = FValue.trim();
			}
			else
				R000000191 = null;
		}
		if (FCode.equalsIgnoreCase("R000000192"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000192 = FValue.trim();
			}
			else
				R000000192 = null;
		}
		if (FCode.equalsIgnoreCase("R000000193"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000193 = FValue.trim();
			}
			else
				R000000193 = null;
		}
		if (FCode.equalsIgnoreCase("R000000194"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000194 = FValue.trim();
			}
			else
				R000000194 = null;
		}
		if (FCode.equalsIgnoreCase("R000000195"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000195 = FValue.trim();
			}
			else
				R000000195 = null;
		}
		if (FCode.equalsIgnoreCase("R000000196"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000196 = FValue.trim();
			}
			else
				R000000196 = null;
		}
		if (FCode.equalsIgnoreCase("R000000197"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000197 = FValue.trim();
			}
			else
				R000000197 = null;
		}
		if (FCode.equalsIgnoreCase("R000000198"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000198 = FValue.trim();
			}
			else
				R000000198 = null;
		}
		if (FCode.equalsIgnoreCase("R000000199"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000199 = FValue.trim();
			}
			else
				R000000199 = null;
		}
		if (FCode.equalsIgnoreCase("R000000200"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000200 = FValue.trim();
			}
			else
				R000000200 = null;
		}
		if (FCode.equalsIgnoreCase("I000000201"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000201 = FValue.trim();
			}
			else
				I000000201 = null;
		}
		if (FCode.equalsIgnoreCase("I000000202"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000202 = FValue.trim();
			}
			else
				I000000202 = null;
		}
		if (FCode.equalsIgnoreCase("I000000203"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000203 = FValue.trim();
			}
			else
				I000000203 = null;
		}
		if (FCode.equalsIgnoreCase("I000000209"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000209 = FValue.trim();
			}
			else
				I000000209 = null;
		}
		if (FCode.equalsIgnoreCase("I000000210"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000210 = FValue.trim();
			}
			else
				I000000210 = null;
		}
		if (FCode.equalsIgnoreCase("I000000213"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000213 = FValue.trim();
			}
			else
				I000000213 = null;
		}
		if (FCode.equalsIgnoreCase("I000000214"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000214 = FValue.trim();
			}
			else
				I000000214 = null;
		}
		if (FCode.equalsIgnoreCase("I000000215"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000215 = FValue.trim();
			}
			else
				I000000215 = null;
		}
		if (FCode.equalsIgnoreCase("I000000216"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000216 = FValue.trim();
			}
			else
				I000000216 = null;
		}
		if (FCode.equalsIgnoreCase("I000000217"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000217 = FValue.trim();
			}
			else
				I000000217 = null;
		}
		if (FCode.equalsIgnoreCase("I000000218"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000218 = FValue.trim();
			}
			else
				I000000218 = null;
		}
		if (FCode.equalsIgnoreCase("I000000219"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000219 = FValue.trim();
			}
			else
				I000000219 = null;
		}
		if (FCode.equalsIgnoreCase("I000000220"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000220 = FValue.trim();
			}
			else
				I000000220 = null;
		}
		if (FCode.equalsIgnoreCase("I000000221"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000221 = FValue.trim();
			}
			else
				I000000221 = null;
		}
		if (FCode.equalsIgnoreCase("I000000222"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000222 = FValue.trim();
			}
			else
				I000000222 = null;
		}
		if (FCode.equalsIgnoreCase("I000000224"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000224 = FValue.trim();
			}
			else
				I000000224 = null;
		}
		if (FCode.equalsIgnoreCase("I000000225"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000225 = FValue.trim();
			}
			else
				I000000225 = null;
		}
		if (FCode.equalsIgnoreCase("I000000226"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000226 = FValue.trim();
			}
			else
				I000000226 = null;
		}
		if (FCode.equalsIgnoreCase("I000000227"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000227 = FValue.trim();
			}
			else
				I000000227 = null;
		}
		if (FCode.equalsIgnoreCase("I000000228"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000228 = FValue.trim();
			}
			else
				I000000228 = null;
		}
		if (FCode.equalsIgnoreCase("I000000229"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000229 = FValue.trim();
			}
			else
				I000000229 = null;
		}
		if (FCode.equalsIgnoreCase("I000000231"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000231 = FValue.trim();
			}
			else
				I000000231 = null;
		}
		if (FCode.equalsIgnoreCase("I000000232"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000232 = FValue.trim();
			}
			else
				I000000232 = null;
		}
		if (FCode.equalsIgnoreCase("I000000233"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000233 = FValue.trim();
			}
			else
				I000000233 = null;
		}
		if (FCode.equalsIgnoreCase("I000000234"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000234 = FValue.trim();
			}
			else
				I000000234 = null;
		}
		if (FCode.equalsIgnoreCase("I000000235"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000235 = FValue.trim();
			}
			else
				I000000235 = null;
		}
		if (FCode.equalsIgnoreCase("I000000236"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000236 = FValue.trim();
			}
			else
				I000000236 = null;
		}
		if (FCode.equalsIgnoreCase("I000000237"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000237 = FValue.trim();
			}
			else
				I000000237 = null;
		}
		if (FCode.equalsIgnoreCase("I000000240"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000240 = FValue.trim();
			}
			else
				I000000240 = null;
		}
		if (FCode.equalsIgnoreCase("I000000241"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000241 = FValue.trim();
			}
			else
				I000000241 = null;
		}
		if (FCode.equalsIgnoreCase("I000000242"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000242 = FValue.trim();
			}
			else
				I000000242 = null;
		}
		if (FCode.equalsIgnoreCase("I000000243"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000243 = FValue.trim();
			}
			else
				I000000243 = null;
		}
		if (FCode.equalsIgnoreCase("I000000244"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000244 = FValue.trim();
			}
			else
				I000000244 = null;
		}
		if (FCode.equalsIgnoreCase("I000000245"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000245 = FValue.trim();
			}
			else
				I000000245 = null;
		}
		if (FCode.equalsIgnoreCase("I000000246"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000246 = FValue.trim();
			}
			else
				I000000246 = null;
		}
		if (FCode.equalsIgnoreCase("I000000247"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000247 = FValue.trim();
			}
			else
				I000000247 = null;
		}
		if (FCode.equalsIgnoreCase("I000000248"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000248 = FValue.trim();
			}
			else
				I000000248 = null;
		}
		if (FCode.equalsIgnoreCase("I000000249"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000249 = FValue.trim();
			}
			else
				I000000249 = null;
		}
		if (FCode.equalsIgnoreCase("I000000250"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000250 = FValue.trim();
			}
			else
				I000000250 = null;
		}
		if (FCode.equalsIgnoreCase("I000000251"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000251 = FValue.trim();
			}
			else
				I000000251 = null;
		}
		if (FCode.equalsIgnoreCase("R000000201"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000201 = FValue.trim();
			}
			else
				R000000201 = null;
		}
		if (FCode.equalsIgnoreCase("R000000202"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000202 = FValue.trim();
			}
			else
				R000000202 = null;
		}
		if (FCode.equalsIgnoreCase("R000000203"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000203 = FValue.trim();
			}
			else
				R000000203 = null;
		}
		if (FCode.equalsIgnoreCase("R000000204"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000204 = FValue.trim();
			}
			else
				R000000204 = null;
		}
		if (FCode.equalsIgnoreCase("R000000205"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				R000000205 = FValue.trim();
			}
			else
				R000000205 = null;
		}
		if (FCode.equalsIgnoreCase("I000000254"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				I000000254 = FValue.trim();
			}
			else
				I000000254 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LAIndexInfoVSchema other = (LAIndexInfoVSchema)otherObject;
		return
			WageNo.equals(other.getWageNo())
			&& BranchType.equals(other.getBranchType())
			&& IndexType.equals(other.getIndexType())
			&& AgentCode.equals(other.getAgentCode())
			&& AgentGrade.equals(other.getAgentGrade())
			&& AgentGroup.equals(other.getAgentGroup())
			&& State.equals(other.getState())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& I000000001.equals(other.getI000000001())
			&& I000000002.equals(other.getI000000002())
			&& I000000003.equals(other.getI000000003())
			&& I000000004.equals(other.getI000000004())
			&& I000000005.equals(other.getI000000005())
			&& I000000006.equals(other.getI000000006())
			&& I000000007.equals(other.getI000000007())
			&& I000000008.equals(other.getI000000008())
			&& I000000009.equals(other.getI000000009())
			&& I000000010.equals(other.getI000000010())
			&& I000000011.equals(other.getI000000011())
			&& I000000012.equals(other.getI000000012())
			&& I000000013.equals(other.getI000000013())
			&& I000000014.equals(other.getI000000014())
			&& I000000015.equals(other.getI000000015())
			&& I000000016.equals(other.getI000000016())
			&& I000000017.equals(other.getI000000017())
			&& I000000018.equals(other.getI000000018())
			&& I000000019.equals(other.getI000000019())
			&& I000000020.equals(other.getI000000020())
			&& I000000021.equals(other.getI000000021())
			&& I000000022.equals(other.getI000000022())
			&& I000000023.equals(other.getI000000023())
			&& I000000024.equals(other.getI000000024())
			&& I000000025.equals(other.getI000000025())
			&& I000000026.equals(other.getI000000026())
			&& I000000027.equals(other.getI000000027())
			&& I000000028.equals(other.getI000000028())
			&& I000000029.equals(other.getI000000029())
			&& I000000030.equals(other.getI000000030())
			&& I000000031.equals(other.getI000000031())
			&& I000000032.equals(other.getI000000032())
			&& I000000033.equals(other.getI000000033())
			&& I000000034.equals(other.getI000000034())
			&& I000000035.equals(other.getI000000035())
			&& I000000036.equals(other.getI000000036())
			&& I000000037.equals(other.getI000000037())
			&& I000000038.equals(other.getI000000038())
			&& I000000039.equals(other.getI000000039())
			&& I000000040.equals(other.getI000000040())
			&& I000000041.equals(other.getI000000041())
			&& I000000042.equals(other.getI000000042())
			&& I000000043.equals(other.getI000000043())
			&& I000000044.equals(other.getI000000044())
			&& I000000045.equals(other.getI000000045())
			&& I000000046.equals(other.getI000000046())
			&& I000000047.equals(other.getI000000047())
			&& I000000048.equals(other.getI000000048())
			&& I000000049.equals(other.getI000000049())
			&& I000000050.equals(other.getI000000050())
			&& I000000051.equals(other.getI000000051())
			&& I000000052.equals(other.getI000000052())
			&& I000000053.equals(other.getI000000053())
			&& I000000054.equals(other.getI000000054())
			&& I000000055.equals(other.getI000000055())
			&& I000000056.equals(other.getI000000056())
			&& I000000057.equals(other.getI000000057())
			&& I000000058.equals(other.getI000000058())
			&& I000000059.equals(other.getI000000059())
			&& I000000060.equals(other.getI000000060())
			&& I000000061.equals(other.getI000000061())
			&& I000000062.equals(other.getI000000062())
			&& I000000063.equals(other.getI000000063())
			&& I000000064.equals(other.getI000000064())
			&& I000000065.equals(other.getI000000065())
			&& I000000066.equals(other.getI000000066())
			&& I000000067.equals(other.getI000000067())
			&& I000000068.equals(other.getI000000068())
			&& I000000069.equals(other.getI000000069())
			&& I000000070.equals(other.getI000000070())
			&& I000000071.equals(other.getI000000071())
			&& I000000072.equals(other.getI000000072())
			&& I000000073.equals(other.getI000000073())
			&& I000000074.equals(other.getI000000074())
			&& I000000075.equals(other.getI000000075())
			&& I000000076.equals(other.getI000000076())
			&& I000000077.equals(other.getI000000077())
			&& I000000078.equals(other.getI000000078())
			&& I000000079.equals(other.getI000000079())
			&& I000000080.equals(other.getI000000080())
			&& I000000081.equals(other.getI000000081())
			&& I000000082.equals(other.getI000000082())
			&& I000000083.equals(other.getI000000083())
			&& I000000084.equals(other.getI000000084())
			&& I000000085.equals(other.getI000000085())
			&& I000000086.equals(other.getI000000086())
			&& I000000087.equals(other.getI000000087())
			&& I000000088.equals(other.getI000000088())
			&& I000000089.equals(other.getI000000089())
			&& I000000090.equals(other.getI000000090())
			&& I000000091.equals(other.getI000000091())
			&& I000000092.equals(other.getI000000092())
			&& I000000093.equals(other.getI000000093())
			&& I000000094.equals(other.getI000000094())
			&& I000000095.equals(other.getI000000095())
			&& I000000096.equals(other.getI000000096())
			&& I000000097.equals(other.getI000000097())
			&& I000000098.equals(other.getI000000098())
			&& I000000099.equals(other.getI000000099())
			&& I000000100.equals(other.getI000000100())
			&& I000000101.equals(other.getI000000101())
			&& I000000102.equals(other.getI000000102())
			&& I000000103.equals(other.getI000000103())
			&& I000000104.equals(other.getI000000104())
			&& I000000105.equals(other.getI000000105())
			&& I000000106.equals(other.getI000000106())
			&& I000000107.equals(other.getI000000107())
			&& I000000108.equals(other.getI000000108())
			&& I000000109.equals(other.getI000000109())
			&& I000000110.equals(other.getI000000110())
			&& I000000111.equals(other.getI000000111())
			&& I000000112.equals(other.getI000000112())
			&& I000000113.equals(other.getI000000113())
			&& I000000114.equals(other.getI000000114())
			&& I000000115.equals(other.getI000000115())
			&& I000000116.equals(other.getI000000116())
			&& I000000117.equals(other.getI000000117())
			&& I000000118.equals(other.getI000000118())
			&& I000000119.equals(other.getI000000119())
			&& I000000120.equals(other.getI000000120())
			&& I000000121.equals(other.getI000000121())
			&& I000000122.equals(other.getI000000122())
			&& I000000123.equals(other.getI000000123())
			&& I000000124.equals(other.getI000000124())
			&& I000000125.equals(other.getI000000125())
			&& I000000126.equals(other.getI000000126())
			&& I000000127.equals(other.getI000000127())
			&& I000000128.equals(other.getI000000128())
			&& I000000129.equals(other.getI000000129())
			&& I000000130.equals(other.getI000000130())
			&& I000000131.equals(other.getI000000131())
			&& I000000132.equals(other.getI000000132())
			&& I000000133.equals(other.getI000000133())
			&& I000000134.equals(other.getI000000134())
			&& I000000135.equals(other.getI000000135())
			&& I000000136.equals(other.getI000000136())
			&& I000000137.equals(other.getI000000137())
			&& I000000138.equals(other.getI000000138())
			&& I000000139.equals(other.getI000000139())
			&& I000000140.equals(other.getI000000140())
			&& I000000141.equals(other.getI000000141())
			&& I000000142.equals(other.getI000000142())
			&& I000000143.equals(other.getI000000143())
			&& I000000144.equals(other.getI000000144())
			&& I000000145.equals(other.getI000000145())
			&& I000000146.equals(other.getI000000146())
			&& I000000147.equals(other.getI000000147())
			&& I000000148.equals(other.getI000000148())
			&& I000000149.equals(other.getI000000149())
			&& I000000150.equals(other.getI000000150())
			&& I000000151.equals(other.getI000000151())
			&& I000000152.equals(other.getI000000152())
			&& I000000153.equals(other.getI000000153())
			&& I000000154.equals(other.getI000000154())
			&& I000000155.equals(other.getI000000155())
			&& I000000156.equals(other.getI000000156())
			&& I000000157.equals(other.getI000000157())
			&& I000000158.equals(other.getI000000158())
			&& I000000159.equals(other.getI000000159())
			&& I000000160.equals(other.getI000000160())
			&& I000000161.equals(other.getI000000161())
			&& I000000162.equals(other.getI000000162())
			&& I000000163.equals(other.getI000000163())
			&& I000000164.equals(other.getI000000164())
			&& I000000165.equals(other.getI000000165())
			&& I000000166.equals(other.getI000000166())
			&& I000000167.equals(other.getI000000167())
			&& I000000168.equals(other.getI000000168())
			&& I000000169.equals(other.getI000000169())
			&& I000000170.equals(other.getI000000170())
			&& I000000171.equals(other.getI000000171())
			&& I000000172.equals(other.getI000000172())
			&& I000000173.equals(other.getI000000173())
			&& I000000174.equals(other.getI000000174())
			&& I000000175.equals(other.getI000000175())
			&& I000000176.equals(other.getI000000176())
			&& I000000177.equals(other.getI000000177())
			&& I000000178.equals(other.getI000000178())
			&& I000000179.equals(other.getI000000179())
			&& I000000180.equals(other.getI000000180())
			&& I000000181.equals(other.getI000000181())
			&& I000000182.equals(other.getI000000182())
			&& I000000183.equals(other.getI000000183())
			&& I000000184.equals(other.getI000000184())
			&& I000000185.equals(other.getI000000185())
			&& I000000186.equals(other.getI000000186())
			&& I000000187.equals(other.getI000000187())
			&& I000000188.equals(other.getI000000188())
			&& I000000189.equals(other.getI000000189())
			&& I000000190.equals(other.getI000000190())
			&& I000000191.equals(other.getI000000191())
			&& I000000192.equals(other.getI000000192())
			&& I000000193.equals(other.getI000000193())
			&& I000000194.equals(other.getI000000194())
			&& I000000195.equals(other.getI000000195())
			&& I000000196.equals(other.getI000000196())
			&& I000000197.equals(other.getI000000197())
			&& I000000198.equals(other.getI000000198())
			&& I000000199.equals(other.getI000000199())
			&& I000000200.equals(other.getI000000200())
			&& R000000001.equals(other.getR000000001())
			&& R000000002.equals(other.getR000000002())
			&& R000000003.equals(other.getR000000003())
			&& R000000004.equals(other.getR000000004())
			&& R000000005.equals(other.getR000000005())
			&& R000000006.equals(other.getR000000006())
			&& R000000007.equals(other.getR000000007())
			&& R000000008.equals(other.getR000000008())
			&& R000000009.equals(other.getR000000009())
			&& R000000010.equals(other.getR000000010())
			&& R000000011.equals(other.getR000000011())
			&& R000000012.equals(other.getR000000012())
			&& R000000013.equals(other.getR000000013())
			&& R000000014.equals(other.getR000000014())
			&& R000000015.equals(other.getR000000015())
			&& R000000016.equals(other.getR000000016())
			&& R000000017.equals(other.getR000000017())
			&& R000000018.equals(other.getR000000018())
			&& R000000019.equals(other.getR000000019())
			&& R000000020.equals(other.getR000000020())
			&& R000000021.equals(other.getR000000021())
			&& R000000022.equals(other.getR000000022())
			&& R000000023.equals(other.getR000000023())
			&& R000000024.equals(other.getR000000024())
			&& R000000025.equals(other.getR000000025())
			&& R000000026.equals(other.getR000000026())
			&& R000000027.equals(other.getR000000027())
			&& R000000028.equals(other.getR000000028())
			&& R000000029.equals(other.getR000000029())
			&& R000000030.equals(other.getR000000030())
			&& R000000031.equals(other.getR000000031())
			&& R000000032.equals(other.getR000000032())
			&& R000000033.equals(other.getR000000033())
			&& R000000034.equals(other.getR000000034())
			&& R000000035.equals(other.getR000000035())
			&& R000000036.equals(other.getR000000036())
			&& R000000037.equals(other.getR000000037())
			&& R000000038.equals(other.getR000000038())
			&& R000000039.equals(other.getR000000039())
			&& R000000040.equals(other.getR000000040())
			&& R000000041.equals(other.getR000000041())
			&& R000000042.equals(other.getR000000042())
			&& R000000043.equals(other.getR000000043())
			&& R000000044.equals(other.getR000000044())
			&& R000000045.equals(other.getR000000045())
			&& R000000046.equals(other.getR000000046())
			&& R000000047.equals(other.getR000000047())
			&& R000000048.equals(other.getR000000048())
			&& R000000049.equals(other.getR000000049())
			&& R000000050.equals(other.getR000000050())
			&& R000000051.equals(other.getR000000051())
			&& R000000052.equals(other.getR000000052())
			&& R000000053.equals(other.getR000000053())
			&& R000000054.equals(other.getR000000054())
			&& R000000055.equals(other.getR000000055())
			&& R000000056.equals(other.getR000000056())
			&& R000000057.equals(other.getR000000057())
			&& R000000058.equals(other.getR000000058())
			&& R000000059.equals(other.getR000000059())
			&& R000000060.equals(other.getR000000060())
			&& R000000061.equals(other.getR000000061())
			&& R000000062.equals(other.getR000000062())
			&& R000000063.equals(other.getR000000063())
			&& R000000064.equals(other.getR000000064())
			&& R000000065.equals(other.getR000000065())
			&& R000000066.equals(other.getR000000066())
			&& R000000067.equals(other.getR000000067())
			&& R000000068.equals(other.getR000000068())
			&& R000000069.equals(other.getR000000069())
			&& R000000070.equals(other.getR000000070())
			&& R000000071.equals(other.getR000000071())
			&& R000000072.equals(other.getR000000072())
			&& R000000073.equals(other.getR000000073())
			&& R000000074.equals(other.getR000000074())
			&& R000000075.equals(other.getR000000075())
			&& R000000076.equals(other.getR000000076())
			&& R000000077.equals(other.getR000000077())
			&& R000000078.equals(other.getR000000078())
			&& R000000079.equals(other.getR000000079())
			&& R000000080.equals(other.getR000000080())
			&& R000000081.equals(other.getR000000081())
			&& R000000082.equals(other.getR000000082())
			&& R000000083.equals(other.getR000000083())
			&& R000000084.equals(other.getR000000084())
			&& R000000085.equals(other.getR000000085())
			&& R000000086.equals(other.getR000000086())
			&& R000000087.equals(other.getR000000087())
			&& R000000088.equals(other.getR000000088())
			&& R000000089.equals(other.getR000000089())
			&& R000000090.equals(other.getR000000090())
			&& R000000091.equals(other.getR000000091())
			&& R000000092.equals(other.getR000000092())
			&& R000000093.equals(other.getR000000093())
			&& R000000094.equals(other.getR000000094())
			&& R000000095.equals(other.getR000000095())
			&& R000000096.equals(other.getR000000096())
			&& R000000097.equals(other.getR000000097())
			&& R000000098.equals(other.getR000000098())
			&& R000000099.equals(other.getR000000099())
			&& R000000100.equals(other.getR000000100())
			&& R000000101.equals(other.getR000000101())
			&& R000000102.equals(other.getR000000102())
			&& R000000103.equals(other.getR000000103())
			&& R000000104.equals(other.getR000000104())
			&& R000000105.equals(other.getR000000105())
			&& R000000106.equals(other.getR000000106())
			&& R000000107.equals(other.getR000000107())
			&& R000000108.equals(other.getR000000108())
			&& R000000109.equals(other.getR000000109())
			&& R000000110.equals(other.getR000000110())
			&& R000000111.equals(other.getR000000111())
			&& R000000112.equals(other.getR000000112())
			&& R000000113.equals(other.getR000000113())
			&& R000000114.equals(other.getR000000114())
			&& R000000115.equals(other.getR000000115())
			&& R000000116.equals(other.getR000000116())
			&& R000000117.equals(other.getR000000117())
			&& R000000118.equals(other.getR000000118())
			&& R000000119.equals(other.getR000000119())
			&& R000000120.equals(other.getR000000120())
			&& R000000121.equals(other.getR000000121())
			&& R000000122.equals(other.getR000000122())
			&& R000000123.equals(other.getR000000123())
			&& R000000124.equals(other.getR000000124())
			&& R000000125.equals(other.getR000000125())
			&& R000000126.equals(other.getR000000126())
			&& R000000127.equals(other.getR000000127())
			&& R000000128.equals(other.getR000000128())
			&& R000000129.equals(other.getR000000129())
			&& R000000130.equals(other.getR000000130())
			&& R000000131.equals(other.getR000000131())
			&& R000000132.equals(other.getR000000132())
			&& R000000133.equals(other.getR000000133())
			&& R000000134.equals(other.getR000000134())
			&& R000000135.equals(other.getR000000135())
			&& R000000136.equals(other.getR000000136())
			&& R000000137.equals(other.getR000000137())
			&& R000000138.equals(other.getR000000138())
			&& R000000139.equals(other.getR000000139())
			&& R000000140.equals(other.getR000000140())
			&& R000000141.equals(other.getR000000141())
			&& R000000142.equals(other.getR000000142())
			&& R000000143.equals(other.getR000000143())
			&& R000000144.equals(other.getR000000144())
			&& R000000145.equals(other.getR000000145())
			&& R000000146.equals(other.getR000000146())
			&& R000000147.equals(other.getR000000147())
			&& R000000148.equals(other.getR000000148())
			&& R000000149.equals(other.getR000000149())
			&& R000000150.equals(other.getR000000150())
			&& R000000151.equals(other.getR000000151())
			&& R000000152.equals(other.getR000000152())
			&& R000000153.equals(other.getR000000153())
			&& R000000154.equals(other.getR000000154())
			&& R000000155.equals(other.getR000000155())
			&& R000000156.equals(other.getR000000156())
			&& R000000157.equals(other.getR000000157())
			&& R000000158.equals(other.getR000000158())
			&& R000000159.equals(other.getR000000159())
			&& R000000160.equals(other.getR000000160())
			&& R000000161.equals(other.getR000000161())
			&& R000000162.equals(other.getR000000162())
			&& R000000163.equals(other.getR000000163())
			&& R000000164.equals(other.getR000000164())
			&& R000000165.equals(other.getR000000165())
			&& R000000166.equals(other.getR000000166())
			&& R000000167.equals(other.getR000000167())
			&& R000000168.equals(other.getR000000168())
			&& R000000169.equals(other.getR000000169())
			&& R000000170.equals(other.getR000000170())
			&& R000000171.equals(other.getR000000171())
			&& R000000172.equals(other.getR000000172())
			&& R000000173.equals(other.getR000000173())
			&& R000000174.equals(other.getR000000174())
			&& R000000175.equals(other.getR000000175())
			&& R000000176.equals(other.getR000000176())
			&& R000000177.equals(other.getR000000177())
			&& R000000178.equals(other.getR000000178())
			&& R000000179.equals(other.getR000000179())
			&& R000000180.equals(other.getR000000180())
			&& R000000181.equals(other.getR000000181())
			&& R000000182.equals(other.getR000000182())
			&& R000000183.equals(other.getR000000183())
			&& R000000184.equals(other.getR000000184())
			&& R000000185.equals(other.getR000000185())
			&& R000000186.equals(other.getR000000186())
			&& R000000187.equals(other.getR000000187())
			&& R000000188.equals(other.getR000000188())
			&& R000000189.equals(other.getR000000189())
			&& R000000190.equals(other.getR000000190())
			&& R000000191.equals(other.getR000000191())
			&& R000000192.equals(other.getR000000192())
			&& R000000193.equals(other.getR000000193())
			&& R000000194.equals(other.getR000000194())
			&& R000000195.equals(other.getR000000195())
			&& R000000196.equals(other.getR000000196())
			&& R000000197.equals(other.getR000000197())
			&& R000000198.equals(other.getR000000198())
			&& R000000199.equals(other.getR000000199())
			&& R000000200.equals(other.getR000000200())
			&& I000000201.equals(other.getI000000201())
			&& I000000202.equals(other.getI000000202())
			&& I000000203.equals(other.getI000000203())
			&& I000000209.equals(other.getI000000209())
			&& I000000210.equals(other.getI000000210())
			&& I000000213.equals(other.getI000000213())
			&& I000000214.equals(other.getI000000214())
			&& I000000215.equals(other.getI000000215())
			&& I000000216.equals(other.getI000000216())
			&& I000000217.equals(other.getI000000217())
			&& I000000218.equals(other.getI000000218())
			&& I000000219.equals(other.getI000000219())
			&& I000000220.equals(other.getI000000220())
			&& I000000221.equals(other.getI000000221())
			&& I000000222.equals(other.getI000000222())
			&& I000000224.equals(other.getI000000224())
			&& I000000225.equals(other.getI000000225())
			&& I000000226.equals(other.getI000000226())
			&& I000000227.equals(other.getI000000227())
			&& I000000228.equals(other.getI000000228())
			&& I000000229.equals(other.getI000000229())
			&& I000000231.equals(other.getI000000231())
			&& I000000232.equals(other.getI000000232())
			&& I000000233.equals(other.getI000000233())
			&& I000000234.equals(other.getI000000234())
			&& I000000235.equals(other.getI000000235())
			&& I000000236.equals(other.getI000000236())
			&& I000000237.equals(other.getI000000237())
			&& I000000240.equals(other.getI000000240())
			&& I000000241.equals(other.getI000000241())
			&& I000000242.equals(other.getI000000242())
			&& I000000243.equals(other.getI000000243())
			&& I000000244.equals(other.getI000000244())
			&& I000000245.equals(other.getI000000245())
			&& I000000246.equals(other.getI000000246())
			&& I000000247.equals(other.getI000000247())
			&& I000000248.equals(other.getI000000248())
			&& I000000249.equals(other.getI000000249())
			&& I000000250.equals(other.getI000000250())
			&& I000000251.equals(other.getI000000251())
			&& R000000201.equals(other.getR000000201())
			&& R000000202.equals(other.getR000000202())
			&& R000000203.equals(other.getR000000203())
			&& R000000204.equals(other.getR000000204())
			&& R000000205.equals(other.getR000000205())
			&& I000000254.equals(other.getI000000254());
	}

	/**
	* 取得Schema拥有字段的数量
       * @return: int
	**/
	public int getFieldCount()
	{
 		return FIELDNUM;
	}

	/**
	* 取得Schema中指定字段名所对应的索引值
	* 如果没有对应的字段，返回-1
       * @param: strFieldName String
       * @return: int
	**/
	public int getFieldIndex(String strFieldName)
	{
		if( strFieldName.equals("WageNo") ) {
			return 0;
		}
		if( strFieldName.equals("BranchType") ) {
			return 1;
		}
		if( strFieldName.equals("IndexType") ) {
			return 2;
		}
		if( strFieldName.equals("AgentCode") ) {
			return 3;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return 4;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return 5;
		}
		if( strFieldName.equals("State") ) {
			return 6;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 7;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 8;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 9;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 10;
		}
		if( strFieldName.equals("I000000001") ) {
			return 11;
		}
		if( strFieldName.equals("I000000002") ) {
			return 12;
		}
		if( strFieldName.equals("I000000003") ) {
			return 13;
		}
		if( strFieldName.equals("I000000004") ) {
			return 14;
		}
		if( strFieldName.equals("I000000005") ) {
			return 15;
		}
		if( strFieldName.equals("I000000006") ) {
			return 16;
		}
		if( strFieldName.equals("I000000007") ) {
			return 17;
		}
		if( strFieldName.equals("I000000008") ) {
			return 18;
		}
		if( strFieldName.equals("I000000009") ) {
			return 19;
		}
		if( strFieldName.equals("I000000010") ) {
			return 20;
		}
		if( strFieldName.equals("I000000011") ) {
			return 21;
		}
		if( strFieldName.equals("I000000012") ) {
			return 22;
		}
		if( strFieldName.equals("I000000013") ) {
			return 23;
		}
		if( strFieldName.equals("I000000014") ) {
			return 24;
		}
		if( strFieldName.equals("I000000015") ) {
			return 25;
		}
		if( strFieldName.equals("I000000016") ) {
			return 26;
		}
		if( strFieldName.equals("I000000017") ) {
			return 27;
		}
		if( strFieldName.equals("I000000018") ) {
			return 28;
		}
		if( strFieldName.equals("I000000019") ) {
			return 29;
		}
		if( strFieldName.equals("I000000020") ) {
			return 30;
		}
		if( strFieldName.equals("I000000021") ) {
			return 31;
		}
		if( strFieldName.equals("I000000022") ) {
			return 32;
		}
		if( strFieldName.equals("I000000023") ) {
			return 33;
		}
		if( strFieldName.equals("I000000024") ) {
			return 34;
		}
		if( strFieldName.equals("I000000025") ) {
			return 35;
		}
		if( strFieldName.equals("I000000026") ) {
			return 36;
		}
		if( strFieldName.equals("I000000027") ) {
			return 37;
		}
		if( strFieldName.equals("I000000028") ) {
			return 38;
		}
		if( strFieldName.equals("I000000029") ) {
			return 39;
		}
		if( strFieldName.equals("I000000030") ) {
			return 40;
		}
		if( strFieldName.equals("I000000031") ) {
			return 41;
		}
		if( strFieldName.equals("I000000032") ) {
			return 42;
		}
		if( strFieldName.equals("I000000033") ) {
			return 43;
		}
		if( strFieldName.equals("I000000034") ) {
			return 44;
		}
		if( strFieldName.equals("I000000035") ) {
			return 45;
		}
		if( strFieldName.equals("I000000036") ) {
			return 46;
		}
		if( strFieldName.equals("I000000037") ) {
			return 47;
		}
		if( strFieldName.equals("I000000038") ) {
			return 48;
		}
		if( strFieldName.equals("I000000039") ) {
			return 49;
		}
		if( strFieldName.equals("I000000040") ) {
			return 50;
		}
		if( strFieldName.equals("I000000041") ) {
			return 51;
		}
		if( strFieldName.equals("I000000042") ) {
			return 52;
		}
		if( strFieldName.equals("I000000043") ) {
			return 53;
		}
		if( strFieldName.equals("I000000044") ) {
			return 54;
		}
		if( strFieldName.equals("I000000045") ) {
			return 55;
		}
		if( strFieldName.equals("I000000046") ) {
			return 56;
		}
		if( strFieldName.equals("I000000047") ) {
			return 57;
		}
		if( strFieldName.equals("I000000048") ) {
			return 58;
		}
		if( strFieldName.equals("I000000049") ) {
			return 59;
		}
		if( strFieldName.equals("I000000050") ) {
			return 60;
		}
		if( strFieldName.equals("I000000051") ) {
			return 61;
		}
		if( strFieldName.equals("I000000052") ) {
			return 62;
		}
		if( strFieldName.equals("I000000053") ) {
			return 63;
		}
		if( strFieldName.equals("I000000054") ) {
			return 64;
		}
		if( strFieldName.equals("I000000055") ) {
			return 65;
		}
		if( strFieldName.equals("I000000056") ) {
			return 66;
		}
		if( strFieldName.equals("I000000057") ) {
			return 67;
		}
		if( strFieldName.equals("I000000058") ) {
			return 68;
		}
		if( strFieldName.equals("I000000059") ) {
			return 69;
		}
		if( strFieldName.equals("I000000060") ) {
			return 70;
		}
		if( strFieldName.equals("I000000061") ) {
			return 71;
		}
		if( strFieldName.equals("I000000062") ) {
			return 72;
		}
		if( strFieldName.equals("I000000063") ) {
			return 73;
		}
		if( strFieldName.equals("I000000064") ) {
			return 74;
		}
		if( strFieldName.equals("I000000065") ) {
			return 75;
		}
		if( strFieldName.equals("I000000066") ) {
			return 76;
		}
		if( strFieldName.equals("I000000067") ) {
			return 77;
		}
		if( strFieldName.equals("I000000068") ) {
			return 78;
		}
		if( strFieldName.equals("I000000069") ) {
			return 79;
		}
		if( strFieldName.equals("I000000070") ) {
			return 80;
		}
		if( strFieldName.equals("I000000071") ) {
			return 81;
		}
		if( strFieldName.equals("I000000072") ) {
			return 82;
		}
		if( strFieldName.equals("I000000073") ) {
			return 83;
		}
		if( strFieldName.equals("I000000074") ) {
			return 84;
		}
		if( strFieldName.equals("I000000075") ) {
			return 85;
		}
		if( strFieldName.equals("I000000076") ) {
			return 86;
		}
		if( strFieldName.equals("I000000077") ) {
			return 87;
		}
		if( strFieldName.equals("I000000078") ) {
			return 88;
		}
		if( strFieldName.equals("I000000079") ) {
			return 89;
		}
		if( strFieldName.equals("I000000080") ) {
			return 90;
		}
		if( strFieldName.equals("I000000081") ) {
			return 91;
		}
		if( strFieldName.equals("I000000082") ) {
			return 92;
		}
		if( strFieldName.equals("I000000083") ) {
			return 93;
		}
		if( strFieldName.equals("I000000084") ) {
			return 94;
		}
		if( strFieldName.equals("I000000085") ) {
			return 95;
		}
		if( strFieldName.equals("I000000086") ) {
			return 96;
		}
		if( strFieldName.equals("I000000087") ) {
			return 97;
		}
		if( strFieldName.equals("I000000088") ) {
			return 98;
		}
		if( strFieldName.equals("I000000089") ) {
			return 99;
		}
		if( strFieldName.equals("I000000090") ) {
			return 100;
		}
		if( strFieldName.equals("I000000091") ) {
			return 101;
		}
		if( strFieldName.equals("I000000092") ) {
			return 102;
		}
		if( strFieldName.equals("I000000093") ) {
			return 103;
		}
		if( strFieldName.equals("I000000094") ) {
			return 104;
		}
		if( strFieldName.equals("I000000095") ) {
			return 105;
		}
		if( strFieldName.equals("I000000096") ) {
			return 106;
		}
		if( strFieldName.equals("I000000097") ) {
			return 107;
		}
		if( strFieldName.equals("I000000098") ) {
			return 108;
		}
		if( strFieldName.equals("I000000099") ) {
			return 109;
		}
		if( strFieldName.equals("I000000100") ) {
			return 110;
		}
		if( strFieldName.equals("I000000101") ) {
			return 111;
		}
		if( strFieldName.equals("I000000102") ) {
			return 112;
		}
		if( strFieldName.equals("I000000103") ) {
			return 113;
		}
		if( strFieldName.equals("I000000104") ) {
			return 114;
		}
		if( strFieldName.equals("I000000105") ) {
			return 115;
		}
		if( strFieldName.equals("I000000106") ) {
			return 116;
		}
		if( strFieldName.equals("I000000107") ) {
			return 117;
		}
		if( strFieldName.equals("I000000108") ) {
			return 118;
		}
		if( strFieldName.equals("I000000109") ) {
			return 119;
		}
		if( strFieldName.equals("I000000110") ) {
			return 120;
		}
		if( strFieldName.equals("I000000111") ) {
			return 121;
		}
		if( strFieldName.equals("I000000112") ) {
			return 122;
		}
		if( strFieldName.equals("I000000113") ) {
			return 123;
		}
		if( strFieldName.equals("I000000114") ) {
			return 124;
		}
		if( strFieldName.equals("I000000115") ) {
			return 125;
		}
		if( strFieldName.equals("I000000116") ) {
			return 126;
		}
		if( strFieldName.equals("I000000117") ) {
			return 127;
		}
		if( strFieldName.equals("I000000118") ) {
			return 128;
		}
		if( strFieldName.equals("I000000119") ) {
			return 129;
		}
		if( strFieldName.equals("I000000120") ) {
			return 130;
		}
		if( strFieldName.equals("I000000121") ) {
			return 131;
		}
		if( strFieldName.equals("I000000122") ) {
			return 132;
		}
		if( strFieldName.equals("I000000123") ) {
			return 133;
		}
		if( strFieldName.equals("I000000124") ) {
			return 134;
		}
		if( strFieldName.equals("I000000125") ) {
			return 135;
		}
		if( strFieldName.equals("I000000126") ) {
			return 136;
		}
		if( strFieldName.equals("I000000127") ) {
			return 137;
		}
		if( strFieldName.equals("I000000128") ) {
			return 138;
		}
		if( strFieldName.equals("I000000129") ) {
			return 139;
		}
		if( strFieldName.equals("I000000130") ) {
			return 140;
		}
		if( strFieldName.equals("I000000131") ) {
			return 141;
		}
		if( strFieldName.equals("I000000132") ) {
			return 142;
		}
		if( strFieldName.equals("I000000133") ) {
			return 143;
		}
		if( strFieldName.equals("I000000134") ) {
			return 144;
		}
		if( strFieldName.equals("I000000135") ) {
			return 145;
		}
		if( strFieldName.equals("I000000136") ) {
			return 146;
		}
		if( strFieldName.equals("I000000137") ) {
			return 147;
		}
		if( strFieldName.equals("I000000138") ) {
			return 148;
		}
		if( strFieldName.equals("I000000139") ) {
			return 149;
		}
		if( strFieldName.equals("I000000140") ) {
			return 150;
		}
		if( strFieldName.equals("I000000141") ) {
			return 151;
		}
		if( strFieldName.equals("I000000142") ) {
			return 152;
		}
		if( strFieldName.equals("I000000143") ) {
			return 153;
		}
		if( strFieldName.equals("I000000144") ) {
			return 154;
		}
		if( strFieldName.equals("I000000145") ) {
			return 155;
		}
		if( strFieldName.equals("I000000146") ) {
			return 156;
		}
		if( strFieldName.equals("I000000147") ) {
			return 157;
		}
		if( strFieldName.equals("I000000148") ) {
			return 158;
		}
		if( strFieldName.equals("I000000149") ) {
			return 159;
		}
		if( strFieldName.equals("I000000150") ) {
			return 160;
		}
		if( strFieldName.equals("I000000151") ) {
			return 161;
		}
		if( strFieldName.equals("I000000152") ) {
			return 162;
		}
		if( strFieldName.equals("I000000153") ) {
			return 163;
		}
		if( strFieldName.equals("I000000154") ) {
			return 164;
		}
		if( strFieldName.equals("I000000155") ) {
			return 165;
		}
		if( strFieldName.equals("I000000156") ) {
			return 166;
		}
		if( strFieldName.equals("I000000157") ) {
			return 167;
		}
		if( strFieldName.equals("I000000158") ) {
			return 168;
		}
		if( strFieldName.equals("I000000159") ) {
			return 169;
		}
		if( strFieldName.equals("I000000160") ) {
			return 170;
		}
		if( strFieldName.equals("I000000161") ) {
			return 171;
		}
		if( strFieldName.equals("I000000162") ) {
			return 172;
		}
		if( strFieldName.equals("I000000163") ) {
			return 173;
		}
		if( strFieldName.equals("I000000164") ) {
			return 174;
		}
		if( strFieldName.equals("I000000165") ) {
			return 175;
		}
		if( strFieldName.equals("I000000166") ) {
			return 176;
		}
		if( strFieldName.equals("I000000167") ) {
			return 177;
		}
		if( strFieldName.equals("I000000168") ) {
			return 178;
		}
		if( strFieldName.equals("I000000169") ) {
			return 179;
		}
		if( strFieldName.equals("I000000170") ) {
			return 180;
		}
		if( strFieldName.equals("I000000171") ) {
			return 181;
		}
		if( strFieldName.equals("I000000172") ) {
			return 182;
		}
		if( strFieldName.equals("I000000173") ) {
			return 183;
		}
		if( strFieldName.equals("I000000174") ) {
			return 184;
		}
		if( strFieldName.equals("I000000175") ) {
			return 185;
		}
		if( strFieldName.equals("I000000176") ) {
			return 186;
		}
		if( strFieldName.equals("I000000177") ) {
			return 187;
		}
		if( strFieldName.equals("I000000178") ) {
			return 188;
		}
		if( strFieldName.equals("I000000179") ) {
			return 189;
		}
		if( strFieldName.equals("I000000180") ) {
			return 190;
		}
		if( strFieldName.equals("I000000181") ) {
			return 191;
		}
		if( strFieldName.equals("I000000182") ) {
			return 192;
		}
		if( strFieldName.equals("I000000183") ) {
			return 193;
		}
		if( strFieldName.equals("I000000184") ) {
			return 194;
		}
		if( strFieldName.equals("I000000185") ) {
			return 195;
		}
		if( strFieldName.equals("I000000186") ) {
			return 196;
		}
		if( strFieldName.equals("I000000187") ) {
			return 197;
		}
		if( strFieldName.equals("I000000188") ) {
			return 198;
		}
		if( strFieldName.equals("I000000189") ) {
			return 199;
		}
		if( strFieldName.equals("I000000190") ) {
			return 200;
		}
		if( strFieldName.equals("I000000191") ) {
			return 201;
		}
		if( strFieldName.equals("I000000192") ) {
			return 202;
		}
		if( strFieldName.equals("I000000193") ) {
			return 203;
		}
		if( strFieldName.equals("I000000194") ) {
			return 204;
		}
		if( strFieldName.equals("I000000195") ) {
			return 205;
		}
		if( strFieldName.equals("I000000196") ) {
			return 206;
		}
		if( strFieldName.equals("I000000197") ) {
			return 207;
		}
		if( strFieldName.equals("I000000198") ) {
			return 208;
		}
		if( strFieldName.equals("I000000199") ) {
			return 209;
		}
		if( strFieldName.equals("I000000200") ) {
			return 210;
		}
		if( strFieldName.equals("R000000001") ) {
			return 211;
		}
		if( strFieldName.equals("R000000002") ) {
			return 212;
		}
		if( strFieldName.equals("R000000003") ) {
			return 213;
		}
		if( strFieldName.equals("R000000004") ) {
			return 214;
		}
		if( strFieldName.equals("R000000005") ) {
			return 215;
		}
		if( strFieldName.equals("R000000006") ) {
			return 216;
		}
		if( strFieldName.equals("R000000007") ) {
			return 217;
		}
		if( strFieldName.equals("R000000008") ) {
			return 218;
		}
		if( strFieldName.equals("R000000009") ) {
			return 219;
		}
		if( strFieldName.equals("R000000010") ) {
			return 220;
		}
		if( strFieldName.equals("R000000011") ) {
			return 221;
		}
		if( strFieldName.equals("R000000012") ) {
			return 222;
		}
		if( strFieldName.equals("R000000013") ) {
			return 223;
		}
		if( strFieldName.equals("R000000014") ) {
			return 224;
		}
		if( strFieldName.equals("R000000015") ) {
			return 225;
		}
		if( strFieldName.equals("R000000016") ) {
			return 226;
		}
		if( strFieldName.equals("R000000017") ) {
			return 227;
		}
		if( strFieldName.equals("R000000018") ) {
			return 228;
		}
		if( strFieldName.equals("R000000019") ) {
			return 229;
		}
		if( strFieldName.equals("R000000020") ) {
			return 230;
		}
		if( strFieldName.equals("R000000021") ) {
			return 231;
		}
		if( strFieldName.equals("R000000022") ) {
			return 232;
		}
		if( strFieldName.equals("R000000023") ) {
			return 233;
		}
		if( strFieldName.equals("R000000024") ) {
			return 234;
		}
		if( strFieldName.equals("R000000025") ) {
			return 235;
		}
		if( strFieldName.equals("R000000026") ) {
			return 236;
		}
		if( strFieldName.equals("R000000027") ) {
			return 237;
		}
		if( strFieldName.equals("R000000028") ) {
			return 238;
		}
		if( strFieldName.equals("R000000029") ) {
			return 239;
		}
		if( strFieldName.equals("R000000030") ) {
			return 240;
		}
		if( strFieldName.equals("R000000031") ) {
			return 241;
		}
		if( strFieldName.equals("R000000032") ) {
			return 242;
		}
		if( strFieldName.equals("R000000033") ) {
			return 243;
		}
		if( strFieldName.equals("R000000034") ) {
			return 244;
		}
		if( strFieldName.equals("R000000035") ) {
			return 245;
		}
		if( strFieldName.equals("R000000036") ) {
			return 246;
		}
		if( strFieldName.equals("R000000037") ) {
			return 247;
		}
		if( strFieldName.equals("R000000038") ) {
			return 248;
		}
		if( strFieldName.equals("R000000039") ) {
			return 249;
		}
		if( strFieldName.equals("R000000040") ) {
			return 250;
		}
		if( strFieldName.equals("R000000041") ) {
			return 251;
		}
		if( strFieldName.equals("R000000042") ) {
			return 252;
		}
		if( strFieldName.equals("R000000043") ) {
			return 253;
		}
		if( strFieldName.equals("R000000044") ) {
			return 254;
		}
		if( strFieldName.equals("R000000045") ) {
			return 255;
		}
		if( strFieldName.equals("R000000046") ) {
			return 256;
		}
		if( strFieldName.equals("R000000047") ) {
			return 257;
		}
		if( strFieldName.equals("R000000048") ) {
			return 258;
		}
		if( strFieldName.equals("R000000049") ) {
			return 259;
		}
		if( strFieldName.equals("R000000050") ) {
			return 260;
		}
		if( strFieldName.equals("R000000051") ) {
			return 261;
		}
		if( strFieldName.equals("R000000052") ) {
			return 262;
		}
		if( strFieldName.equals("R000000053") ) {
			return 263;
		}
		if( strFieldName.equals("R000000054") ) {
			return 264;
		}
		if( strFieldName.equals("R000000055") ) {
			return 265;
		}
		if( strFieldName.equals("R000000056") ) {
			return 266;
		}
		if( strFieldName.equals("R000000057") ) {
			return 267;
		}
		if( strFieldName.equals("R000000058") ) {
			return 268;
		}
		if( strFieldName.equals("R000000059") ) {
			return 269;
		}
		if( strFieldName.equals("R000000060") ) {
			return 270;
		}
		if( strFieldName.equals("R000000061") ) {
			return 271;
		}
		if( strFieldName.equals("R000000062") ) {
			return 272;
		}
		if( strFieldName.equals("R000000063") ) {
			return 273;
		}
		if( strFieldName.equals("R000000064") ) {
			return 274;
		}
		if( strFieldName.equals("R000000065") ) {
			return 275;
		}
		if( strFieldName.equals("R000000066") ) {
			return 276;
		}
		if( strFieldName.equals("R000000067") ) {
			return 277;
		}
		if( strFieldName.equals("R000000068") ) {
			return 278;
		}
		if( strFieldName.equals("R000000069") ) {
			return 279;
		}
		if( strFieldName.equals("R000000070") ) {
			return 280;
		}
		if( strFieldName.equals("R000000071") ) {
			return 281;
		}
		if( strFieldName.equals("R000000072") ) {
			return 282;
		}
		if( strFieldName.equals("R000000073") ) {
			return 283;
		}
		if( strFieldName.equals("R000000074") ) {
			return 284;
		}
		if( strFieldName.equals("R000000075") ) {
			return 285;
		}
		if( strFieldName.equals("R000000076") ) {
			return 286;
		}
		if( strFieldName.equals("R000000077") ) {
			return 287;
		}
		if( strFieldName.equals("R000000078") ) {
			return 288;
		}
		if( strFieldName.equals("R000000079") ) {
			return 289;
		}
		if( strFieldName.equals("R000000080") ) {
			return 290;
		}
		if( strFieldName.equals("R000000081") ) {
			return 291;
		}
		if( strFieldName.equals("R000000082") ) {
			return 292;
		}
		if( strFieldName.equals("R000000083") ) {
			return 293;
		}
		if( strFieldName.equals("R000000084") ) {
			return 294;
		}
		if( strFieldName.equals("R000000085") ) {
			return 295;
		}
		if( strFieldName.equals("R000000086") ) {
			return 296;
		}
		if( strFieldName.equals("R000000087") ) {
			return 297;
		}
		if( strFieldName.equals("R000000088") ) {
			return 298;
		}
		if( strFieldName.equals("R000000089") ) {
			return 299;
		}
		if( strFieldName.equals("R000000090") ) {
			return 300;
		}
		if( strFieldName.equals("R000000091") ) {
			return 301;
		}
		if( strFieldName.equals("R000000092") ) {
			return 302;
		}
		if( strFieldName.equals("R000000093") ) {
			return 303;
		}
		if( strFieldName.equals("R000000094") ) {
			return 304;
		}
		if( strFieldName.equals("R000000095") ) {
			return 305;
		}
		if( strFieldName.equals("R000000096") ) {
			return 306;
		}
		if( strFieldName.equals("R000000097") ) {
			return 307;
		}
		if( strFieldName.equals("R000000098") ) {
			return 308;
		}
		if( strFieldName.equals("R000000099") ) {
			return 309;
		}
		if( strFieldName.equals("R000000100") ) {
			return 310;
		}
		if( strFieldName.equals("R000000101") ) {
			return 311;
		}
		if( strFieldName.equals("R000000102") ) {
			return 312;
		}
		if( strFieldName.equals("R000000103") ) {
			return 313;
		}
		if( strFieldName.equals("R000000104") ) {
			return 314;
		}
		if( strFieldName.equals("R000000105") ) {
			return 315;
		}
		if( strFieldName.equals("R000000106") ) {
			return 316;
		}
		if( strFieldName.equals("R000000107") ) {
			return 317;
		}
		if( strFieldName.equals("R000000108") ) {
			return 318;
		}
		if( strFieldName.equals("R000000109") ) {
			return 319;
		}
		if( strFieldName.equals("R000000110") ) {
			return 320;
		}
		if( strFieldName.equals("R000000111") ) {
			return 321;
		}
		if( strFieldName.equals("R000000112") ) {
			return 322;
		}
		if( strFieldName.equals("R000000113") ) {
			return 323;
		}
		if( strFieldName.equals("R000000114") ) {
			return 324;
		}
		if( strFieldName.equals("R000000115") ) {
			return 325;
		}
		if( strFieldName.equals("R000000116") ) {
			return 326;
		}
		if( strFieldName.equals("R000000117") ) {
			return 327;
		}
		if( strFieldName.equals("R000000118") ) {
			return 328;
		}
		if( strFieldName.equals("R000000119") ) {
			return 329;
		}
		if( strFieldName.equals("R000000120") ) {
			return 330;
		}
		if( strFieldName.equals("R000000121") ) {
			return 331;
		}
		if( strFieldName.equals("R000000122") ) {
			return 332;
		}
		if( strFieldName.equals("R000000123") ) {
			return 333;
		}
		if( strFieldName.equals("R000000124") ) {
			return 334;
		}
		if( strFieldName.equals("R000000125") ) {
			return 335;
		}
		if( strFieldName.equals("R000000126") ) {
			return 336;
		}
		if( strFieldName.equals("R000000127") ) {
			return 337;
		}
		if( strFieldName.equals("R000000128") ) {
			return 338;
		}
		if( strFieldName.equals("R000000129") ) {
			return 339;
		}
		if( strFieldName.equals("R000000130") ) {
			return 340;
		}
		if( strFieldName.equals("R000000131") ) {
			return 341;
		}
		if( strFieldName.equals("R000000132") ) {
			return 342;
		}
		if( strFieldName.equals("R000000133") ) {
			return 343;
		}
		if( strFieldName.equals("R000000134") ) {
			return 344;
		}
		if( strFieldName.equals("R000000135") ) {
			return 345;
		}
		if( strFieldName.equals("R000000136") ) {
			return 346;
		}
		if( strFieldName.equals("R000000137") ) {
			return 347;
		}
		if( strFieldName.equals("R000000138") ) {
			return 348;
		}
		if( strFieldName.equals("R000000139") ) {
			return 349;
		}
		if( strFieldName.equals("R000000140") ) {
			return 350;
		}
		if( strFieldName.equals("R000000141") ) {
			return 351;
		}
		if( strFieldName.equals("R000000142") ) {
			return 352;
		}
		if( strFieldName.equals("R000000143") ) {
			return 353;
		}
		if( strFieldName.equals("R000000144") ) {
			return 354;
		}
		if( strFieldName.equals("R000000145") ) {
			return 355;
		}
		if( strFieldName.equals("R000000146") ) {
			return 356;
		}
		if( strFieldName.equals("R000000147") ) {
			return 357;
		}
		if( strFieldName.equals("R000000148") ) {
			return 358;
		}
		if( strFieldName.equals("R000000149") ) {
			return 359;
		}
		if( strFieldName.equals("R000000150") ) {
			return 360;
		}
		if( strFieldName.equals("R000000151") ) {
			return 361;
		}
		if( strFieldName.equals("R000000152") ) {
			return 362;
		}
		if( strFieldName.equals("R000000153") ) {
			return 363;
		}
		if( strFieldName.equals("R000000154") ) {
			return 364;
		}
		if( strFieldName.equals("R000000155") ) {
			return 365;
		}
		if( strFieldName.equals("R000000156") ) {
			return 366;
		}
		if( strFieldName.equals("R000000157") ) {
			return 367;
		}
		if( strFieldName.equals("R000000158") ) {
			return 368;
		}
		if( strFieldName.equals("R000000159") ) {
			return 369;
		}
		if( strFieldName.equals("R000000160") ) {
			return 370;
		}
		if( strFieldName.equals("R000000161") ) {
			return 371;
		}
		if( strFieldName.equals("R000000162") ) {
			return 372;
		}
		if( strFieldName.equals("R000000163") ) {
			return 373;
		}
		if( strFieldName.equals("R000000164") ) {
			return 374;
		}
		if( strFieldName.equals("R000000165") ) {
			return 375;
		}
		if( strFieldName.equals("R000000166") ) {
			return 376;
		}
		if( strFieldName.equals("R000000167") ) {
			return 377;
		}
		if( strFieldName.equals("R000000168") ) {
			return 378;
		}
		if( strFieldName.equals("R000000169") ) {
			return 379;
		}
		if( strFieldName.equals("R000000170") ) {
			return 380;
		}
		if( strFieldName.equals("R000000171") ) {
			return 381;
		}
		if( strFieldName.equals("R000000172") ) {
			return 382;
		}
		if( strFieldName.equals("R000000173") ) {
			return 383;
		}
		if( strFieldName.equals("R000000174") ) {
			return 384;
		}
		if( strFieldName.equals("R000000175") ) {
			return 385;
		}
		if( strFieldName.equals("R000000176") ) {
			return 386;
		}
		if( strFieldName.equals("R000000177") ) {
			return 387;
		}
		if( strFieldName.equals("R000000178") ) {
			return 388;
		}
		if( strFieldName.equals("R000000179") ) {
			return 389;
		}
		if( strFieldName.equals("R000000180") ) {
			return 390;
		}
		if( strFieldName.equals("R000000181") ) {
			return 391;
		}
		if( strFieldName.equals("R000000182") ) {
			return 392;
		}
		if( strFieldName.equals("R000000183") ) {
			return 393;
		}
		if( strFieldName.equals("R000000184") ) {
			return 394;
		}
		if( strFieldName.equals("R000000185") ) {
			return 395;
		}
		if( strFieldName.equals("R000000186") ) {
			return 396;
		}
		if( strFieldName.equals("R000000187") ) {
			return 397;
		}
		if( strFieldName.equals("R000000188") ) {
			return 398;
		}
		if( strFieldName.equals("R000000189") ) {
			return 399;
		}
		if( strFieldName.equals("R000000190") ) {
			return 400;
		}
		if( strFieldName.equals("R000000191") ) {
			return 401;
		}
		if( strFieldName.equals("R000000192") ) {
			return 402;
		}
		if( strFieldName.equals("R000000193") ) {
			return 403;
		}
		if( strFieldName.equals("R000000194") ) {
			return 404;
		}
		if( strFieldName.equals("R000000195") ) {
			return 405;
		}
		if( strFieldName.equals("R000000196") ) {
			return 406;
		}
		if( strFieldName.equals("R000000197") ) {
			return 407;
		}
		if( strFieldName.equals("R000000198") ) {
			return 408;
		}
		if( strFieldName.equals("R000000199") ) {
			return 409;
		}
		if( strFieldName.equals("R000000200") ) {
			return 410;
		}
		if( strFieldName.equals("I000000201") ) {
			return 411;
		}
		if( strFieldName.equals("I000000202") ) {
			return 412;
		}
		if( strFieldName.equals("I000000203") ) {
			return 413;
		}
		if( strFieldName.equals("I000000209") ) {
			return 414;
		}
		if( strFieldName.equals("I000000210") ) {
			return 415;
		}
		if( strFieldName.equals("I000000213") ) {
			return 416;
		}
		if( strFieldName.equals("I000000214") ) {
			return 417;
		}
		if( strFieldName.equals("I000000215") ) {
			return 418;
		}
		if( strFieldName.equals("I000000216") ) {
			return 419;
		}
		if( strFieldName.equals("I000000217") ) {
			return 420;
		}
		if( strFieldName.equals("I000000218") ) {
			return 421;
		}
		if( strFieldName.equals("I000000219") ) {
			return 422;
		}
		if( strFieldName.equals("I000000220") ) {
			return 423;
		}
		if( strFieldName.equals("I000000221") ) {
			return 424;
		}
		if( strFieldName.equals("I000000222") ) {
			return 425;
		}
		if( strFieldName.equals("I000000224") ) {
			return 426;
		}
		if( strFieldName.equals("I000000225") ) {
			return 427;
		}
		if( strFieldName.equals("I000000226") ) {
			return 428;
		}
		if( strFieldName.equals("I000000227") ) {
			return 429;
		}
		if( strFieldName.equals("I000000228") ) {
			return 430;
		}
		if( strFieldName.equals("I000000229") ) {
			return 431;
		}
		if( strFieldName.equals("I000000231") ) {
			return 432;
		}
		if( strFieldName.equals("I000000232") ) {
			return 433;
		}
		if( strFieldName.equals("I000000233") ) {
			return 434;
		}
		if( strFieldName.equals("I000000234") ) {
			return 435;
		}
		if( strFieldName.equals("I000000235") ) {
			return 436;
		}
		if( strFieldName.equals("I000000236") ) {
			return 437;
		}
		if( strFieldName.equals("I000000237") ) {
			return 438;
		}
		if( strFieldName.equals("I000000240") ) {
			return 439;
		}
		if( strFieldName.equals("I000000241") ) {
			return 440;
		}
		if( strFieldName.equals("I000000242") ) {
			return 441;
		}
		if( strFieldName.equals("I000000243") ) {
			return 442;
		}
		if( strFieldName.equals("I000000244") ) {
			return 443;
		}
		if( strFieldName.equals("I000000245") ) {
			return 444;
		}
		if( strFieldName.equals("I000000246") ) {
			return 445;
		}
		if( strFieldName.equals("I000000247") ) {
			return 446;
		}
		if( strFieldName.equals("I000000248") ) {
			return 447;
		}
		if( strFieldName.equals("I000000249") ) {
			return 448;
		}
		if( strFieldName.equals("I000000250") ) {
			return 449;
		}
		if( strFieldName.equals("I000000251") ) {
			return 450;
		}
		if( strFieldName.equals("R000000201") ) {
			return 451;
		}
		if( strFieldName.equals("R000000202") ) {
			return 452;
		}
		if( strFieldName.equals("R000000203") ) {
			return 453;
		}
		if( strFieldName.equals("R000000204") ) {
			return 454;
		}
		if( strFieldName.equals("R000000205") ) {
			return 455;
		}
		if( strFieldName.equals("I000000254") ) {
			return 456;
		}
		return -1;
	}

	/**
	* 取得Schema中指定索引值所对应的字段名
	* 如果没有对应的字段，返回""
       * @param: nFieldIndex int
       * @return: String
	**/
	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch(nFieldIndex) {
			case 0:
				strFieldName = "WageNo";
				break;
			case 1:
				strFieldName = "BranchType";
				break;
			case 2:
				strFieldName = "IndexType";
				break;
			case 3:
				strFieldName = "AgentCode";
				break;
			case 4:
				strFieldName = "AgentGrade";
				break;
			case 5:
				strFieldName = "AgentGroup";
				break;
			case 6:
				strFieldName = "State";
				break;
			case 7:
				strFieldName = "MakeDate";
				break;
			case 8:
				strFieldName = "MakeTime";
				break;
			case 9:
				strFieldName = "ModifyDate";
				break;
			case 10:
				strFieldName = "ModifyTime";
				break;
			case 11:
				strFieldName = "I000000001";
				break;
			case 12:
				strFieldName = "I000000002";
				break;
			case 13:
				strFieldName = "I000000003";
				break;
			case 14:
				strFieldName = "I000000004";
				break;
			case 15:
				strFieldName = "I000000005";
				break;
			case 16:
				strFieldName = "I000000006";
				break;
			case 17:
				strFieldName = "I000000007";
				break;
			case 18:
				strFieldName = "I000000008";
				break;
			case 19:
				strFieldName = "I000000009";
				break;
			case 20:
				strFieldName = "I000000010";
				break;
			case 21:
				strFieldName = "I000000011";
				break;
			case 22:
				strFieldName = "I000000012";
				break;
			case 23:
				strFieldName = "I000000013";
				break;
			case 24:
				strFieldName = "I000000014";
				break;
			case 25:
				strFieldName = "I000000015";
				break;
			case 26:
				strFieldName = "I000000016";
				break;
			case 27:
				strFieldName = "I000000017";
				break;
			case 28:
				strFieldName = "I000000018";
				break;
			case 29:
				strFieldName = "I000000019";
				break;
			case 30:
				strFieldName = "I000000020";
				break;
			case 31:
				strFieldName = "I000000021";
				break;
			case 32:
				strFieldName = "I000000022";
				break;
			case 33:
				strFieldName = "I000000023";
				break;
			case 34:
				strFieldName = "I000000024";
				break;
			case 35:
				strFieldName = "I000000025";
				break;
			case 36:
				strFieldName = "I000000026";
				break;
			case 37:
				strFieldName = "I000000027";
				break;
			case 38:
				strFieldName = "I000000028";
				break;
			case 39:
				strFieldName = "I000000029";
				break;
			case 40:
				strFieldName = "I000000030";
				break;
			case 41:
				strFieldName = "I000000031";
				break;
			case 42:
				strFieldName = "I000000032";
				break;
			case 43:
				strFieldName = "I000000033";
				break;
			case 44:
				strFieldName = "I000000034";
				break;
			case 45:
				strFieldName = "I000000035";
				break;
			case 46:
				strFieldName = "I000000036";
				break;
			case 47:
				strFieldName = "I000000037";
				break;
			case 48:
				strFieldName = "I000000038";
				break;
			case 49:
				strFieldName = "I000000039";
				break;
			case 50:
				strFieldName = "I000000040";
				break;
			case 51:
				strFieldName = "I000000041";
				break;
			case 52:
				strFieldName = "I000000042";
				break;
			case 53:
				strFieldName = "I000000043";
				break;
			case 54:
				strFieldName = "I000000044";
				break;
			case 55:
				strFieldName = "I000000045";
				break;
			case 56:
				strFieldName = "I000000046";
				break;
			case 57:
				strFieldName = "I000000047";
				break;
			case 58:
				strFieldName = "I000000048";
				break;
			case 59:
				strFieldName = "I000000049";
				break;
			case 60:
				strFieldName = "I000000050";
				break;
			case 61:
				strFieldName = "I000000051";
				break;
			case 62:
				strFieldName = "I000000052";
				break;
			case 63:
				strFieldName = "I000000053";
				break;
			case 64:
				strFieldName = "I000000054";
				break;
			case 65:
				strFieldName = "I000000055";
				break;
			case 66:
				strFieldName = "I000000056";
				break;
			case 67:
				strFieldName = "I000000057";
				break;
			case 68:
				strFieldName = "I000000058";
				break;
			case 69:
				strFieldName = "I000000059";
				break;
			case 70:
				strFieldName = "I000000060";
				break;
			case 71:
				strFieldName = "I000000061";
				break;
			case 72:
				strFieldName = "I000000062";
				break;
			case 73:
				strFieldName = "I000000063";
				break;
			case 74:
				strFieldName = "I000000064";
				break;
			case 75:
				strFieldName = "I000000065";
				break;
			case 76:
				strFieldName = "I000000066";
				break;
			case 77:
				strFieldName = "I000000067";
				break;
			case 78:
				strFieldName = "I000000068";
				break;
			case 79:
				strFieldName = "I000000069";
				break;
			case 80:
				strFieldName = "I000000070";
				break;
			case 81:
				strFieldName = "I000000071";
				break;
			case 82:
				strFieldName = "I000000072";
				break;
			case 83:
				strFieldName = "I000000073";
				break;
			case 84:
				strFieldName = "I000000074";
				break;
			case 85:
				strFieldName = "I000000075";
				break;
			case 86:
				strFieldName = "I000000076";
				break;
			case 87:
				strFieldName = "I000000077";
				break;
			case 88:
				strFieldName = "I000000078";
				break;
			case 89:
				strFieldName = "I000000079";
				break;
			case 90:
				strFieldName = "I000000080";
				break;
			case 91:
				strFieldName = "I000000081";
				break;
			case 92:
				strFieldName = "I000000082";
				break;
			case 93:
				strFieldName = "I000000083";
				break;
			case 94:
				strFieldName = "I000000084";
				break;
			case 95:
				strFieldName = "I000000085";
				break;
			case 96:
				strFieldName = "I000000086";
				break;
			case 97:
				strFieldName = "I000000087";
				break;
			case 98:
				strFieldName = "I000000088";
				break;
			case 99:
				strFieldName = "I000000089";
				break;
			case 100:
				strFieldName = "I000000090";
				break;
			case 101:
				strFieldName = "I000000091";
				break;
			case 102:
				strFieldName = "I000000092";
				break;
			case 103:
				strFieldName = "I000000093";
				break;
			case 104:
				strFieldName = "I000000094";
				break;
			case 105:
				strFieldName = "I000000095";
				break;
			case 106:
				strFieldName = "I000000096";
				break;
			case 107:
				strFieldName = "I000000097";
				break;
			case 108:
				strFieldName = "I000000098";
				break;
			case 109:
				strFieldName = "I000000099";
				break;
			case 110:
				strFieldName = "I000000100";
				break;
			case 111:
				strFieldName = "I000000101";
				break;
			case 112:
				strFieldName = "I000000102";
				break;
			case 113:
				strFieldName = "I000000103";
				break;
			case 114:
				strFieldName = "I000000104";
				break;
			case 115:
				strFieldName = "I000000105";
				break;
			case 116:
				strFieldName = "I000000106";
				break;
			case 117:
				strFieldName = "I000000107";
				break;
			case 118:
				strFieldName = "I000000108";
				break;
			case 119:
				strFieldName = "I000000109";
				break;
			case 120:
				strFieldName = "I000000110";
				break;
			case 121:
				strFieldName = "I000000111";
				break;
			case 122:
				strFieldName = "I000000112";
				break;
			case 123:
				strFieldName = "I000000113";
				break;
			case 124:
				strFieldName = "I000000114";
				break;
			case 125:
				strFieldName = "I000000115";
				break;
			case 126:
				strFieldName = "I000000116";
				break;
			case 127:
				strFieldName = "I000000117";
				break;
			case 128:
				strFieldName = "I000000118";
				break;
			case 129:
				strFieldName = "I000000119";
				break;
			case 130:
				strFieldName = "I000000120";
				break;
			case 131:
				strFieldName = "I000000121";
				break;
			case 132:
				strFieldName = "I000000122";
				break;
			case 133:
				strFieldName = "I000000123";
				break;
			case 134:
				strFieldName = "I000000124";
				break;
			case 135:
				strFieldName = "I000000125";
				break;
			case 136:
				strFieldName = "I000000126";
				break;
			case 137:
				strFieldName = "I000000127";
				break;
			case 138:
				strFieldName = "I000000128";
				break;
			case 139:
				strFieldName = "I000000129";
				break;
			case 140:
				strFieldName = "I000000130";
				break;
			case 141:
				strFieldName = "I000000131";
				break;
			case 142:
				strFieldName = "I000000132";
				break;
			case 143:
				strFieldName = "I000000133";
				break;
			case 144:
				strFieldName = "I000000134";
				break;
			case 145:
				strFieldName = "I000000135";
				break;
			case 146:
				strFieldName = "I000000136";
				break;
			case 147:
				strFieldName = "I000000137";
				break;
			case 148:
				strFieldName = "I000000138";
				break;
			case 149:
				strFieldName = "I000000139";
				break;
			case 150:
				strFieldName = "I000000140";
				break;
			case 151:
				strFieldName = "I000000141";
				break;
			case 152:
				strFieldName = "I000000142";
				break;
			case 153:
				strFieldName = "I000000143";
				break;
			case 154:
				strFieldName = "I000000144";
				break;
			case 155:
				strFieldName = "I000000145";
				break;
			case 156:
				strFieldName = "I000000146";
				break;
			case 157:
				strFieldName = "I000000147";
				break;
			case 158:
				strFieldName = "I000000148";
				break;
			case 159:
				strFieldName = "I000000149";
				break;
			case 160:
				strFieldName = "I000000150";
				break;
			case 161:
				strFieldName = "I000000151";
				break;
			case 162:
				strFieldName = "I000000152";
				break;
			case 163:
				strFieldName = "I000000153";
				break;
			case 164:
				strFieldName = "I000000154";
				break;
			case 165:
				strFieldName = "I000000155";
				break;
			case 166:
				strFieldName = "I000000156";
				break;
			case 167:
				strFieldName = "I000000157";
				break;
			case 168:
				strFieldName = "I000000158";
				break;
			case 169:
				strFieldName = "I000000159";
				break;
			case 170:
				strFieldName = "I000000160";
				break;
			case 171:
				strFieldName = "I000000161";
				break;
			case 172:
				strFieldName = "I000000162";
				break;
			case 173:
				strFieldName = "I000000163";
				break;
			case 174:
				strFieldName = "I000000164";
				break;
			case 175:
				strFieldName = "I000000165";
				break;
			case 176:
				strFieldName = "I000000166";
				break;
			case 177:
				strFieldName = "I000000167";
				break;
			case 178:
				strFieldName = "I000000168";
				break;
			case 179:
				strFieldName = "I000000169";
				break;
			case 180:
				strFieldName = "I000000170";
				break;
			case 181:
				strFieldName = "I000000171";
				break;
			case 182:
				strFieldName = "I000000172";
				break;
			case 183:
				strFieldName = "I000000173";
				break;
			case 184:
				strFieldName = "I000000174";
				break;
			case 185:
				strFieldName = "I000000175";
				break;
			case 186:
				strFieldName = "I000000176";
				break;
			case 187:
				strFieldName = "I000000177";
				break;
			case 188:
				strFieldName = "I000000178";
				break;
			case 189:
				strFieldName = "I000000179";
				break;
			case 190:
				strFieldName = "I000000180";
				break;
			case 191:
				strFieldName = "I000000181";
				break;
			case 192:
				strFieldName = "I000000182";
				break;
			case 193:
				strFieldName = "I000000183";
				break;
			case 194:
				strFieldName = "I000000184";
				break;
			case 195:
				strFieldName = "I000000185";
				break;
			case 196:
				strFieldName = "I000000186";
				break;
			case 197:
				strFieldName = "I000000187";
				break;
			case 198:
				strFieldName = "I000000188";
				break;
			case 199:
				strFieldName = "I000000189";
				break;
			case 200:
				strFieldName = "I000000190";
				break;
			case 201:
				strFieldName = "I000000191";
				break;
			case 202:
				strFieldName = "I000000192";
				break;
			case 203:
				strFieldName = "I000000193";
				break;
			case 204:
				strFieldName = "I000000194";
				break;
			case 205:
				strFieldName = "I000000195";
				break;
			case 206:
				strFieldName = "I000000196";
				break;
			case 207:
				strFieldName = "I000000197";
				break;
			case 208:
				strFieldName = "I000000198";
				break;
			case 209:
				strFieldName = "I000000199";
				break;
			case 210:
				strFieldName = "I000000200";
				break;
			case 211:
				strFieldName = "R000000001";
				break;
			case 212:
				strFieldName = "R000000002";
				break;
			case 213:
				strFieldName = "R000000003";
				break;
			case 214:
				strFieldName = "R000000004";
				break;
			case 215:
				strFieldName = "R000000005";
				break;
			case 216:
				strFieldName = "R000000006";
				break;
			case 217:
				strFieldName = "R000000007";
				break;
			case 218:
				strFieldName = "R000000008";
				break;
			case 219:
				strFieldName = "R000000009";
				break;
			case 220:
				strFieldName = "R000000010";
				break;
			case 221:
				strFieldName = "R000000011";
				break;
			case 222:
				strFieldName = "R000000012";
				break;
			case 223:
				strFieldName = "R000000013";
				break;
			case 224:
				strFieldName = "R000000014";
				break;
			case 225:
				strFieldName = "R000000015";
				break;
			case 226:
				strFieldName = "R000000016";
				break;
			case 227:
				strFieldName = "R000000017";
				break;
			case 228:
				strFieldName = "R000000018";
				break;
			case 229:
				strFieldName = "R000000019";
				break;
			case 230:
				strFieldName = "R000000020";
				break;
			case 231:
				strFieldName = "R000000021";
				break;
			case 232:
				strFieldName = "R000000022";
				break;
			case 233:
				strFieldName = "R000000023";
				break;
			case 234:
				strFieldName = "R000000024";
				break;
			case 235:
				strFieldName = "R000000025";
				break;
			case 236:
				strFieldName = "R000000026";
				break;
			case 237:
				strFieldName = "R000000027";
				break;
			case 238:
				strFieldName = "R000000028";
				break;
			case 239:
				strFieldName = "R000000029";
				break;
			case 240:
				strFieldName = "R000000030";
				break;
			case 241:
				strFieldName = "R000000031";
				break;
			case 242:
				strFieldName = "R000000032";
				break;
			case 243:
				strFieldName = "R000000033";
				break;
			case 244:
				strFieldName = "R000000034";
				break;
			case 245:
				strFieldName = "R000000035";
				break;
			case 246:
				strFieldName = "R000000036";
				break;
			case 247:
				strFieldName = "R000000037";
				break;
			case 248:
				strFieldName = "R000000038";
				break;
			case 249:
				strFieldName = "R000000039";
				break;
			case 250:
				strFieldName = "R000000040";
				break;
			case 251:
				strFieldName = "R000000041";
				break;
			case 252:
				strFieldName = "R000000042";
				break;
			case 253:
				strFieldName = "R000000043";
				break;
			case 254:
				strFieldName = "R000000044";
				break;
			case 255:
				strFieldName = "R000000045";
				break;
			case 256:
				strFieldName = "R000000046";
				break;
			case 257:
				strFieldName = "R000000047";
				break;
			case 258:
				strFieldName = "R000000048";
				break;
			case 259:
				strFieldName = "R000000049";
				break;
			case 260:
				strFieldName = "R000000050";
				break;
			case 261:
				strFieldName = "R000000051";
				break;
			case 262:
				strFieldName = "R000000052";
				break;
			case 263:
				strFieldName = "R000000053";
				break;
			case 264:
				strFieldName = "R000000054";
				break;
			case 265:
				strFieldName = "R000000055";
				break;
			case 266:
				strFieldName = "R000000056";
				break;
			case 267:
				strFieldName = "R000000057";
				break;
			case 268:
				strFieldName = "R000000058";
				break;
			case 269:
				strFieldName = "R000000059";
				break;
			case 270:
				strFieldName = "R000000060";
				break;
			case 271:
				strFieldName = "R000000061";
				break;
			case 272:
				strFieldName = "R000000062";
				break;
			case 273:
				strFieldName = "R000000063";
				break;
			case 274:
				strFieldName = "R000000064";
				break;
			case 275:
				strFieldName = "R000000065";
				break;
			case 276:
				strFieldName = "R000000066";
				break;
			case 277:
				strFieldName = "R000000067";
				break;
			case 278:
				strFieldName = "R000000068";
				break;
			case 279:
				strFieldName = "R000000069";
				break;
			case 280:
				strFieldName = "R000000070";
				break;
			case 281:
				strFieldName = "R000000071";
				break;
			case 282:
				strFieldName = "R000000072";
				break;
			case 283:
				strFieldName = "R000000073";
				break;
			case 284:
				strFieldName = "R000000074";
				break;
			case 285:
				strFieldName = "R000000075";
				break;
			case 286:
				strFieldName = "R000000076";
				break;
			case 287:
				strFieldName = "R000000077";
				break;
			case 288:
				strFieldName = "R000000078";
				break;
			case 289:
				strFieldName = "R000000079";
				break;
			case 290:
				strFieldName = "R000000080";
				break;
			case 291:
				strFieldName = "R000000081";
				break;
			case 292:
				strFieldName = "R000000082";
				break;
			case 293:
				strFieldName = "R000000083";
				break;
			case 294:
				strFieldName = "R000000084";
				break;
			case 295:
				strFieldName = "R000000085";
				break;
			case 296:
				strFieldName = "R000000086";
				break;
			case 297:
				strFieldName = "R000000087";
				break;
			case 298:
				strFieldName = "R000000088";
				break;
			case 299:
				strFieldName = "R000000089";
				break;
			case 300:
				strFieldName = "R000000090";
				break;
			case 301:
				strFieldName = "R000000091";
				break;
			case 302:
				strFieldName = "R000000092";
				break;
			case 303:
				strFieldName = "R000000093";
				break;
			case 304:
				strFieldName = "R000000094";
				break;
			case 305:
				strFieldName = "R000000095";
				break;
			case 306:
				strFieldName = "R000000096";
				break;
			case 307:
				strFieldName = "R000000097";
				break;
			case 308:
				strFieldName = "R000000098";
				break;
			case 309:
				strFieldName = "R000000099";
				break;
			case 310:
				strFieldName = "R000000100";
				break;
			case 311:
				strFieldName = "R000000101";
				break;
			case 312:
				strFieldName = "R000000102";
				break;
			case 313:
				strFieldName = "R000000103";
				break;
			case 314:
				strFieldName = "R000000104";
				break;
			case 315:
				strFieldName = "R000000105";
				break;
			case 316:
				strFieldName = "R000000106";
				break;
			case 317:
				strFieldName = "R000000107";
				break;
			case 318:
				strFieldName = "R000000108";
				break;
			case 319:
				strFieldName = "R000000109";
				break;
			case 320:
				strFieldName = "R000000110";
				break;
			case 321:
				strFieldName = "R000000111";
				break;
			case 322:
				strFieldName = "R000000112";
				break;
			case 323:
				strFieldName = "R000000113";
				break;
			case 324:
				strFieldName = "R000000114";
				break;
			case 325:
				strFieldName = "R000000115";
				break;
			case 326:
				strFieldName = "R000000116";
				break;
			case 327:
				strFieldName = "R000000117";
				break;
			case 328:
				strFieldName = "R000000118";
				break;
			case 329:
				strFieldName = "R000000119";
				break;
			case 330:
				strFieldName = "R000000120";
				break;
			case 331:
				strFieldName = "R000000121";
				break;
			case 332:
				strFieldName = "R000000122";
				break;
			case 333:
				strFieldName = "R000000123";
				break;
			case 334:
				strFieldName = "R000000124";
				break;
			case 335:
				strFieldName = "R000000125";
				break;
			case 336:
				strFieldName = "R000000126";
				break;
			case 337:
				strFieldName = "R000000127";
				break;
			case 338:
				strFieldName = "R000000128";
				break;
			case 339:
				strFieldName = "R000000129";
				break;
			case 340:
				strFieldName = "R000000130";
				break;
			case 341:
				strFieldName = "R000000131";
				break;
			case 342:
				strFieldName = "R000000132";
				break;
			case 343:
				strFieldName = "R000000133";
				break;
			case 344:
				strFieldName = "R000000134";
				break;
			case 345:
				strFieldName = "R000000135";
				break;
			case 346:
				strFieldName = "R000000136";
				break;
			case 347:
				strFieldName = "R000000137";
				break;
			case 348:
				strFieldName = "R000000138";
				break;
			case 349:
				strFieldName = "R000000139";
				break;
			case 350:
				strFieldName = "R000000140";
				break;
			case 351:
				strFieldName = "R000000141";
				break;
			case 352:
				strFieldName = "R000000142";
				break;
			case 353:
				strFieldName = "R000000143";
				break;
			case 354:
				strFieldName = "R000000144";
				break;
			case 355:
				strFieldName = "R000000145";
				break;
			case 356:
				strFieldName = "R000000146";
				break;
			case 357:
				strFieldName = "R000000147";
				break;
			case 358:
				strFieldName = "R000000148";
				break;
			case 359:
				strFieldName = "R000000149";
				break;
			case 360:
				strFieldName = "R000000150";
				break;
			case 361:
				strFieldName = "R000000151";
				break;
			case 362:
				strFieldName = "R000000152";
				break;
			case 363:
				strFieldName = "R000000153";
				break;
			case 364:
				strFieldName = "R000000154";
				break;
			case 365:
				strFieldName = "R000000155";
				break;
			case 366:
				strFieldName = "R000000156";
				break;
			case 367:
				strFieldName = "R000000157";
				break;
			case 368:
				strFieldName = "R000000158";
				break;
			case 369:
				strFieldName = "R000000159";
				break;
			case 370:
				strFieldName = "R000000160";
				break;
			case 371:
				strFieldName = "R000000161";
				break;
			case 372:
				strFieldName = "R000000162";
				break;
			case 373:
				strFieldName = "R000000163";
				break;
			case 374:
				strFieldName = "R000000164";
				break;
			case 375:
				strFieldName = "R000000165";
				break;
			case 376:
				strFieldName = "R000000166";
				break;
			case 377:
				strFieldName = "R000000167";
				break;
			case 378:
				strFieldName = "R000000168";
				break;
			case 379:
				strFieldName = "R000000169";
				break;
			case 380:
				strFieldName = "R000000170";
				break;
			case 381:
				strFieldName = "R000000171";
				break;
			case 382:
				strFieldName = "R000000172";
				break;
			case 383:
				strFieldName = "R000000173";
				break;
			case 384:
				strFieldName = "R000000174";
				break;
			case 385:
				strFieldName = "R000000175";
				break;
			case 386:
				strFieldName = "R000000176";
				break;
			case 387:
				strFieldName = "R000000177";
				break;
			case 388:
				strFieldName = "R000000178";
				break;
			case 389:
				strFieldName = "R000000179";
				break;
			case 390:
				strFieldName = "R000000180";
				break;
			case 391:
				strFieldName = "R000000181";
				break;
			case 392:
				strFieldName = "R000000182";
				break;
			case 393:
				strFieldName = "R000000183";
				break;
			case 394:
				strFieldName = "R000000184";
				break;
			case 395:
				strFieldName = "R000000185";
				break;
			case 396:
				strFieldName = "R000000186";
				break;
			case 397:
				strFieldName = "R000000187";
				break;
			case 398:
				strFieldName = "R000000188";
				break;
			case 399:
				strFieldName = "R000000189";
				break;
			case 400:
				strFieldName = "R000000190";
				break;
			case 401:
				strFieldName = "R000000191";
				break;
			case 402:
				strFieldName = "R000000192";
				break;
			case 403:
				strFieldName = "R000000193";
				break;
			case 404:
				strFieldName = "R000000194";
				break;
			case 405:
				strFieldName = "R000000195";
				break;
			case 406:
				strFieldName = "R000000196";
				break;
			case 407:
				strFieldName = "R000000197";
				break;
			case 408:
				strFieldName = "R000000198";
				break;
			case 409:
				strFieldName = "R000000199";
				break;
			case 410:
				strFieldName = "R000000200";
				break;
			case 411:
				strFieldName = "I000000201";
				break;
			case 412:
				strFieldName = "I000000202";
				break;
			case 413:
				strFieldName = "I000000203";
				break;
			case 414:
				strFieldName = "I000000209";
				break;
			case 415:
				strFieldName = "I000000210";
				break;
			case 416:
				strFieldName = "I000000213";
				break;
			case 417:
				strFieldName = "I000000214";
				break;
			case 418:
				strFieldName = "I000000215";
				break;
			case 419:
				strFieldName = "I000000216";
				break;
			case 420:
				strFieldName = "I000000217";
				break;
			case 421:
				strFieldName = "I000000218";
				break;
			case 422:
				strFieldName = "I000000219";
				break;
			case 423:
				strFieldName = "I000000220";
				break;
			case 424:
				strFieldName = "I000000221";
				break;
			case 425:
				strFieldName = "I000000222";
				break;
			case 426:
				strFieldName = "I000000224";
				break;
			case 427:
				strFieldName = "I000000225";
				break;
			case 428:
				strFieldName = "I000000226";
				break;
			case 429:
				strFieldName = "I000000227";
				break;
			case 430:
				strFieldName = "I000000228";
				break;
			case 431:
				strFieldName = "I000000229";
				break;
			case 432:
				strFieldName = "I000000231";
				break;
			case 433:
				strFieldName = "I000000232";
				break;
			case 434:
				strFieldName = "I000000233";
				break;
			case 435:
				strFieldName = "I000000234";
				break;
			case 436:
				strFieldName = "I000000235";
				break;
			case 437:
				strFieldName = "I000000236";
				break;
			case 438:
				strFieldName = "I000000237";
				break;
			case 439:
				strFieldName = "I000000240";
				break;
			case 440:
				strFieldName = "I000000241";
				break;
			case 441:
				strFieldName = "I000000242";
				break;
			case 442:
				strFieldName = "I000000243";
				break;
			case 443:
				strFieldName = "I000000244";
				break;
			case 444:
				strFieldName = "I000000245";
				break;
			case 445:
				strFieldName = "I000000246";
				break;
			case 446:
				strFieldName = "I000000247";
				break;
			case 447:
				strFieldName = "I000000248";
				break;
			case 448:
				strFieldName = "I000000249";
				break;
			case 449:
				strFieldName = "I000000250";
				break;
			case 450:
				strFieldName = "I000000251";
				break;
			case 451:
				strFieldName = "R000000201";
				break;
			case 452:
				strFieldName = "R000000202";
				break;
			case 453:
				strFieldName = "R000000203";
				break;
			case 454:
				strFieldName = "R000000204";
				break;
			case 455:
				strFieldName = "R000000205";
				break;
			case 456:
				strFieldName = "I000000254";
				break;
			default:
				strFieldName = "";
		};
		return strFieldName;
	}

	/**
	* 取得Schema中指定字段名所对应的字段类型
	* 如果没有对应的字段，返回Schema.TYPE_NOFOUND
       * @param: strFieldName String
       * @return: int
	**/
	public int getFieldType(String strFieldName)
	{
		if( strFieldName.equals("WageNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BranchType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("IndexType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentCode") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGrade") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("AgentGroup") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("State") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000001") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000002") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000003") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000004") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000005") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000006") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000007") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000008") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000009") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000010") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000011") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000012") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000013") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000014") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000015") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000016") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000017") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000018") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000019") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000020") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000021") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000022") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000023") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000024") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000025") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000026") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000027") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000028") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000029") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000030") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000031") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000032") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000033") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000034") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000035") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000036") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000037") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000038") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000039") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000040") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000041") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000042") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000043") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000044") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000045") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000046") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000047") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000048") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000049") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000050") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000051") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000052") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000053") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000054") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000055") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000056") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000057") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000058") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000059") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000060") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000061") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000062") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000063") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000064") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000065") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000066") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000067") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000068") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000069") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000070") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000071") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000072") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000073") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000074") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000075") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000076") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000077") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000078") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000079") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000080") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000081") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000082") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000083") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000084") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000085") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000086") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000087") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000088") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000089") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000090") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000091") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000092") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000093") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000094") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000095") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000096") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000097") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000098") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000099") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000100") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000101") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000102") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000103") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000104") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000105") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000106") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000107") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000108") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000109") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000110") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000111") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000112") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000113") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000114") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000115") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000116") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000117") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000118") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000119") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000120") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000121") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000122") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000123") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000124") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000125") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000126") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000127") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000128") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000129") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000130") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000131") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000132") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000133") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000134") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000135") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000136") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000137") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000138") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000139") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000140") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000141") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000142") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000143") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000144") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000145") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000146") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000147") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000148") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000149") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000150") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000151") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000152") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000153") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000154") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000155") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000156") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000157") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000158") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000159") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000160") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000161") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000162") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000163") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000164") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000165") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000166") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000167") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000168") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000169") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000170") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000171") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000172") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000173") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000174") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000175") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000176") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000177") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000178") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000179") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000180") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000181") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000182") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000183") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000184") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000185") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000186") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000187") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000188") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000189") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000190") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000191") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000192") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000193") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000194") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000195") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000196") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000197") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000198") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000199") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000200") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000001") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000002") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000003") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000004") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000005") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000006") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000007") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000008") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000009") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000010") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000011") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000012") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000013") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000014") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000015") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000016") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000017") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000018") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000019") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000020") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000021") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000022") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000023") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000024") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000025") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000026") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000027") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000028") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000029") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000030") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000031") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000032") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000033") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000034") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000035") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000036") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000037") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000038") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000039") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000040") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000041") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000042") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000043") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000044") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000045") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000046") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000047") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000048") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000049") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000050") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000051") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000052") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000053") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000054") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000055") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000056") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000057") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000058") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000059") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000060") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000061") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000062") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000063") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000064") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000065") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000066") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000067") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000068") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000069") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000070") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000071") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000072") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000073") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000074") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000075") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000076") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000077") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000078") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000079") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000080") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000081") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000082") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000083") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000084") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000085") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000086") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000087") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000088") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000089") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000090") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000091") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000092") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000093") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000094") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000095") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000096") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000097") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000098") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000099") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000100") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000101") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000102") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000103") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000104") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000105") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000106") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000107") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000108") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000109") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000110") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000111") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000112") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000113") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000114") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000115") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000116") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000117") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000118") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000119") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000120") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000121") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000122") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000123") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000124") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000125") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000126") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000127") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000128") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000129") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000130") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000131") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000132") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000133") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000134") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000135") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000136") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000137") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000138") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000139") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000140") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000141") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000142") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000143") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000144") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000145") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000146") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000147") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000148") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000149") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000150") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000151") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000152") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000153") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000154") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000155") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000156") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000157") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000158") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000159") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000160") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000161") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000162") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000163") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000164") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000165") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000166") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000167") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000168") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000169") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000170") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000171") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000172") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000173") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000174") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000175") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000176") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000177") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000178") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000179") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000180") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000181") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000182") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000183") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000184") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000185") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000186") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000187") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000188") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000189") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000190") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000191") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000192") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000193") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000194") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000195") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000196") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000197") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000198") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000199") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000200") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000201") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000202") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000203") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000209") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000210") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000213") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000214") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000215") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000216") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000217") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000218") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000219") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000220") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000221") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000222") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000224") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000225") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000226") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000227") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000228") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000229") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000231") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000232") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000233") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000234") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000235") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000236") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000237") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000240") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000241") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000242") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000243") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000244") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000245") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000246") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000247") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000248") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000249") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000250") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000251") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000201") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000202") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000203") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000204") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("R000000205") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("I000000254") ) {
			return Schema.TYPE_STRING;
		}
		return Schema.TYPE_NOFOUND;
	}

	/**
	* 取得Schema中指定索引值所对应的字段类型
	* 如果没有对应的字段，返回Schema.TYPE_NOFOUND
       * @param: nFieldIndex int
       * @return: int
	**/
	public int getFieldType(int nFieldIndex)
	{
		int nFieldType = Schema.TYPE_NOFOUND;
		switch(nFieldIndex) {
			case 0:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 1:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 2:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 3:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 4:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 5:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 17:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 18:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 19:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 20:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 21:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 22:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 23:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 24:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 25:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 26:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 27:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 28:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 29:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 30:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 31:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 32:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 33:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 34:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 35:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 36:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 37:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 38:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 39:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 40:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 41:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 42:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 43:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 44:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 45:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 46:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 47:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 48:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 49:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 50:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 51:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 52:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 53:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 54:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 55:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 56:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 57:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 58:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 59:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 60:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 61:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 62:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 63:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 64:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 65:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 66:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 67:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 68:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 69:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 70:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 71:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 72:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 73:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 74:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 75:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 76:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 77:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 78:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 79:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 80:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 81:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 82:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 83:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 84:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 85:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 86:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 87:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 88:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 89:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 90:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 91:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 92:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 93:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 94:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 95:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 96:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 97:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 98:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 99:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 100:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 101:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 102:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 103:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 104:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 105:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 106:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 107:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 108:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 109:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 110:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 111:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 112:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 113:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 114:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 115:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 116:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 117:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 118:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 119:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 120:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 121:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 122:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 123:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 124:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 125:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 126:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 127:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 128:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 129:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 130:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 131:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 132:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 133:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 134:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 135:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 136:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 137:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 138:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 139:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 140:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 141:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 142:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 143:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 144:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 145:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 146:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 147:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 148:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 149:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 150:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 151:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 152:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 153:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 154:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 155:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 156:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 157:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 158:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 159:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 160:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 161:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 162:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 163:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 164:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 165:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 166:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 167:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 168:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 169:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 170:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 171:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 172:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 173:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 174:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 175:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 176:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 177:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 178:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 179:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 180:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 181:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 182:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 183:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 184:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 185:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 186:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 187:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 188:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 189:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 190:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 191:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 192:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 193:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 194:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 195:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 196:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 197:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 198:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 199:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 200:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 201:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 202:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 203:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 204:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 205:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 206:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 207:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 208:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 209:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 210:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 211:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 212:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 213:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 214:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 215:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 216:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 217:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 218:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 219:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 220:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 221:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 222:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 223:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 224:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 225:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 226:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 227:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 228:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 229:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 230:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 231:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 232:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 233:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 234:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 235:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 236:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 237:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 238:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 239:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 240:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 241:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 242:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 243:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 244:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 245:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 246:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 247:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 248:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 249:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 250:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 251:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 252:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 253:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 254:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 255:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 256:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 257:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 258:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 259:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 260:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 261:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 262:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 263:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 264:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 265:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 266:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 267:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 268:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 269:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 270:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 271:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 272:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 273:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 274:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 275:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 276:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 277:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 278:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 279:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 280:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 281:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 282:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 283:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 284:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 285:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 286:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 287:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 288:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 289:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 290:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 291:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 292:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 293:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 294:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 295:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 296:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 297:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 298:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 299:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 300:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 301:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 302:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 303:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 304:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 305:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 306:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 307:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 308:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 309:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 310:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 311:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 312:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 313:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 314:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 315:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 316:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 317:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 318:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 319:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 320:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 321:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 322:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 323:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 324:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 325:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 326:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 327:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 328:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 329:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 330:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 331:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 332:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 333:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 334:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 335:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 336:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 337:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 338:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 339:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 340:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 341:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 342:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 343:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 344:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 345:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 346:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 347:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 348:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 349:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 350:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 351:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 352:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 353:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 354:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 355:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 356:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 357:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 358:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 359:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 360:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 361:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 362:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 363:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 364:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 365:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 366:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 367:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 368:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 369:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 370:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 371:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 372:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 373:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 374:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 375:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 376:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 377:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 378:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 379:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 380:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 381:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 382:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 383:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 384:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 385:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 386:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 387:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 388:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 389:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 390:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 391:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 392:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 393:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 394:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 395:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 396:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 397:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 398:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 399:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 400:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 401:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 402:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 403:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 404:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 405:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 406:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 407:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 408:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 409:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 410:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 411:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 412:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 413:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 414:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 415:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 416:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 417:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 418:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 419:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 420:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 421:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 422:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 423:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 424:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 425:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 426:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 427:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 428:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 429:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 430:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 431:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 432:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 433:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 434:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 435:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 436:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 437:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 438:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 439:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 440:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 441:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 442:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 443:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 444:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 445:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 446:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 447:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 448:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 449:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 450:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 451:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 452:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 453:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 454:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 455:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 456:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
