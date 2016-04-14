<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="../common/easyQueryVer3/EasyQueryFunc.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%
	//SQL Here			
	System.out.println("ExcSQL");
	//search BOM
	if(SQLID.equals("BOMObjectiveManagement_Enquiry")){
		SQL = "select id,name,dbo.getCodeName('branchtype',branchtype, 'en'),dbo.getCodeName('yesno',state, 'en'),remark from LRBom where 1=1"
				+ getWherePart(request, "ID", "p_ID")
				+ getWherePart(request, "name", "p_name","like")
				+ getWherePart(request, "BranchType", "p_BranchType")
				+ getWherePart(request, "state", "p_state")
			    +" order by id";
	}else if(SQLID.equals("BOMObjectiveManagement_SearchItem")){
		SQL = "select id,name,(select codename from ldcode where codetype='ibrmscommandtype' and code =a.datatype),(case state when 'N' then 'Y' when 'Y' then 'N' else state end) from lrTerm a where 1=1 "
				+ getWherePart(request, "bomid", "p_bomid")
		    	+"order by id";
	}else if(SQLID.equals("LRBomAddInput.js_SearchBomName")){
		SQL = "select count(1) from lrbom where 1=1 "
				+ getWherePart(request, "name", "p_name")
				+ getWherePart(request, "branchtype", "p_branch")
		    	;
	}else if(SQLID.equals("LRTermAddInput.js_SearchItemName")){
		SQL = "select count(1) from lrterm where 1=1 "
				+ getWherePart(request, "name", "p_name")
				+ getWherePart(request, "bomid", "p_bomid")
		    	;
	}else if(SQLID.equals("LRBomUpdateInput.js_ModifyBomName")){
		SQL = "select count(1) from lrbom where 1=1 "
				+ getWherePart(request, "name", "p_name")
				+ getWherePart(request, "branchtype", "p_branchtype")
				+ getWherePart(request, "id", "p_id","<>")
		    	;
	}else if(SQLID.equals("LRTermUpdateInput.js_ModifyItemName")){
		SQL = "select count(1) from lrterm where 1=1 "
				+ getWherePart(request, "name", "p_name")
				+ getWherePart(request, "bomid", "p_bomid")
				+ getWherePart(request, "id", "p_id","<>")
		    	;
	}else if(SQLID.equals("LRTermUpdateInput.js_Save1")){
		SQL = "select datatype from lrassessindexp where 1=1 "
				+ getWherePart(request, "indexcode", "p_indexcode")
		    	;
	}else if(SQLID.equals("LRRuleInforInput.js_SearchWage")){
		SQL = " select WageCode,WageName,(select codename from ldcode where LRIndex.WageType=code and codetype = 'indexflg'),(select codename from ldcode where LRIndex.IndexSerise=code and codetype = 'serise' ),(select codename from ldcode where LRIndex.BranchType=code and codetype = 'branchtype' ),(case state when 'N' then 'N' when 'Y' then 'Y' else state end) from LRIndex where 1=1 "
				+ getWherePart(request, "WageCode", "p_WageCode")
				+ getWherePart(request, "WageName", "p_WageName","like")
				+ getWherePart(request, "WageType", "p_WageType")
				+ getWherePart(request, "BranchType", "p_BranchType")
				+ getWherePart(request, "State", "p_State")
			    + "order by WageCode"
		    	;
				
	}else if(SQLID.equals("LRRuleInforInput.js_SearchRule")){
		SQL = " select IndexCode,IndexName,(case state when 'N' then 'N' when 'Y' then 'Y' else state end),Description from LRAssessIndexLibrary where 1=1 "
				+ getWherePart(request, "WageCode", "p_WageCode")
			    + " order by indexcode "
		    	;
				
	}else if(SQLID.equals("LRProAddInput.js_SearchWageName")){
		SQL = " select count(1) from lrindex where 1=1 "
				+ getWherePart(request, "WageName", "p_WageName")
				+ getWherePart(request, "branchtype", "p_branchtype")
				+ getWherePart(request, "WageType", "p_WageType")
		    	;
				
	}else if(SQLID.equals("LRProUpdateInput.js_SearchWageName")){
		//var sql="select count(1) from lrindex where 1=1 and WageName='"+name+"'"+" and branchtype='"+branch+"'"+" and WageType='"+WageType+"'"+"and wagecode not in ('"+wagecode+"')";
		SQL = " select count(1) from lrindex where 1=1 "
				+ getWherePart(request, "WageName", "p_WageName")
				+ getWherePart(request, "branchtype", "p_branchtype")
				+ getWherePart(request, "WageType", "p_WageType")
				+ getWherePart(request, "wagecode", "p_wagecode","<>")
		    	;
				
	}else if(SQLID.equals("LRRuleAddInput.js_SearchWageName")){
		//var sql="select count(1) from lrassessindexlibrary where 1=1 and indexname='"+name+"'"+"and wagecode='"+wagecode+"'";
		SQL = " select count(1) from lrassessindexlibrary where 1=1 "
				+ getWherePart(request, "indexname", "p_indexname")
				+ getWherePart(request, "wagecode", "p_wagecode")
		    	;
				
	}else if(SQLID.equals("LRRuleUpdateInput.js_SearchWageName")){
		//var sql="select count(1) from lrassessindexlibrary where 1=1 and indexname='"+name+"'"+"and wagecode='"+wagecode+"'"+"and indexcode not in ('"+indexcode+"')";
		SQL = " select count(1) from lrassessindexlibrary where 1=1 "
				+ getWherePart(request, "indexname", "p_indexname")
				+ getWherePart(request, "wagecode", "p_wagecode")
				+ getWherePart(request, "indexcode", "p_indexcode","<>")
		    	;
				
	}else if(SQLID.equals("LRRuleUpdateInput.js_SearchDataType")){
		//strSQL  = "select datatype from lrassessindexp where indexcode = '"+fm.all("IndexCode").value+"'";
		SQL = " select datatype from lrassessindexp where 1=1 "
				+ getWherePart(request, "indexcode", "p_indexcode")
		    	;
				
	}else if(SQLID.equals("LRBomInputQuery.js_SearchBOM")){
		//var strSQL="select (select codename from ldcode where codetype = 'branchtype' and code =bom.BranchType ),bom.id,bom.name,(case bom.state when 'N' then '无效' when 'Y' then '有效' end),term.id,term.name,(case term.state when 'N' then '无效' when 'Y' then '有效' end),(select codename from ldcode where codetype = 'ibrmscommandtype' and code =term.datatype ),(select codename from ldcode where codetype = 'calculate' and code =term.caltype ),Convert(Text,term.calsql) from lrbom bom left join lrterm term on bom.id=term.bomid where 1=1 "
		SQL = " select (select codename from ldcode where codetype = 'branchtype' and code =bom.BranchType ),bom.id,bom.name,(case bom.state when 'N' then 'N' when 'Y' then 'Y' end),term.id,term.name,(case term.state when 'N' then 'N' when 'Y' then 'Y' end),(select codename from ldcode where codetype = 'ibrmscommandtype' and code =term.datatype ),(select codename from ldcode where codetype = 'calculate' and code =term.caltype ),Convert(Text,term.calsql) from lrbom bom left join lrterm term on bom.id=term.bomid where 1=1 "
				+ getWherePart(request, "bom.ID", "p_ID")
				+ getWherePart(request, "bom.name", "p_Name")
				+ getWherePart(request, "bom.BranchType", "p_BranchType")
				+ getWherePart(request, "bom.state", "p_State")
				+ getWherePart(request, "term.ID", "p_IDTerm")
				+ getWherePart(request, "term.name", "NameTerm")
				+ getWherePart(request, "term.state", "p_StateTerm")
   	  			+" order by bom.id,term.id" ;
				
	}else if(SQLID.equals("LRBomInputQuery.js_SearchItem")){
		//var strSQL="select Convert(Text,calsql) from lrterm where id='"+rowdata+"'";
		SQL = " select Convert(Text,calsql) from lrterm where 1=1 "
				+ getWherePart(request, "id", "p_id")
   	  			;
				
	}else if(SQLID.equals("LRRuleInforInputQuery.js_SearchWage")){
		//var strSQL="select (select codename from ldcode where codetype = 'branchtype' and code =bom.BranchType ),bom.wagecode,bom.wagename,(case bom.state when 'N' then '无效' when 'Y' then '有效' end),assess.indexcode,assess.indexname,(case assess.state when 'N' then '无效' when 'Y' then '有效' end),(select codename from ldcode where codetype = 'ibrmscommandtype' and code =assess.datatype),(select codename from ldcode where codetype = 'logic' and code =assess.caltype ),assess.description from lrindex bom LEFT JOIN lrassessindexlibrary assess on bom.wagecode=assess.wagecode where 1=1 "
		SQL = " select (select codename from ldcode where codetype = 'branchtype' and code =bom.BranchType ),bom.wagecode,bom.wagename,(case bom.state when 'N' then 'N' when 'Y' then 'Y' end),assess.indexcode,assess.indexname,(case assess.state when 'N' then 'N' when 'Y' then 'Y' end),(select codename from ldcode where codetype = 'ibrmscommandtype' and code =assess.datatype),(select codename from ldcode where codetype = 'logic' and code =assess.caltype ),assess.description from lrindex bom LEFT JOIN lrassessindexlibrary assess on bom.wagecode=assess.wagecode where 1=1 "
				+ getWherePart(request, "bom.WageCode", "p_WageCode")
				+ getWherePart(request, "bom.WageName", "p_WageName")
				+ getWherePart(request, "bom.BranchType", "p_BranchType")
				+ getWherePart(request, "assess.IndexCode", "p_IndexCode")
				+ getWherePart(request, "assess.IndexName", "p_IndexName")
				+ getWherePart(request, "bom.State", "p_WageState")
				+ getWherePart(request, "assess.State", "p_RuleState")
			  	+" order by bom.wagecode" ;
				
	}else if(SQLID.equals("LRRuleInforInputQuery.js_ruleparam")){
		//var strSQL="select to_char(CalSQL)||to_char(json) from lrassessindexlibrary where indexcode='"+rowdata+"'";
		SQL = " select to_char(CalSQL)||to_char(json) from lrassessindexlibrary where 1=1 "
				+ getWherePart(request, "indexcode", "p_indexcode")
			  	;
	}else if(SQLID.equals("LABaseRuleInput.js_SearchBase")){
		//strSQL = "select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),reason,Remark,branchtype,Status  from LRBase where 1=1"
		SQL = " select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),reason,Remark,branchtype,Status  from LRBase where 1=1 "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
				+ getWherePart(request, "Name", "p_Name")
				+ getWherePart(request, "BranchType", "p_BranchType")
				+ getWherePart(request, "Status", "p_Status")
        		+" order by basecode desc";
			  	;
	}else if(SQLID.equals("LABaseRuleInput.js_updateClick")){
		//strSQL = "select * from LRBase where BaseCode = '" + fm.all('RuleCode').value + "'";
		SQL = " select * from LRBase where 1=1 "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
			  	;
	}else if(SQLID.equals("LABaseRuleInput.js_myShowCodeList")){
		//strSQL = "select a.status from lrbase a where a.basecode='"+fm.all('RuleCode').value+"'";
		SQL = " select a.status from lrbase a where 1=1 "
				+ getWherePart(request, "a.basecode", "p_BaseCode")
			  	;
	}else if(SQLID.equals("LARuleStatusInput.js_SearchBase1")){
		//var strSQL = "select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate from lRBase where 1=1 "
		SQL = " select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate from lRBase where 1=1 and Status in ('01','03','05') "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
				+ getWherePart(request, "Name", "p_Name")
				+ getWherePart(request, "BranchType", "p_BranchType")
			  	;
	}else if(SQLID.equals("LARuleStatusInput.js_SearchBase2")){
		//var strSQL = "select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate from lRBase where 1=1 "
		SQL = " select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate from lRBase where 1=1 "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
				+ getWherePart(request, "Name", "p_Name")
				+ getWherePart(request, "BranchType", "p_BranchType")
				+ getWherePart(request, "status", "p_status")
			  	;
	}else if(SQLID.equals("LARulePublishInput.js_SearchBase")){
		//var strSQL = "select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate from lRBase where 1=1 "
		SQL = " select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate from lRBase where 1=1 "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
				+ getWherePart(request, "Name", "p_Name")
				+ getWherePart(request, "BranchType", "p_BranchType")
				+ getWherePart(request, "status", "p_status")
			  	;
	}else if(SQLID.equals("LRExpInput.js_SearchBaseInfo")){
		//strSQL = "select BaseCode,Name,BranchType,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),Remark,status  from LRBase where 1=1"
		SQL = " select BaseCode,Name,BranchType,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),Remark,status  from LRBase where 1=1 "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
			  	;
	}else if(SQLID.equals("LRExpInput.js_SearchBase")){
		//strSQL = "select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate  from LRBase where 1=1 and status = '04' "
		SQL = " select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),Remark,operator,makedate  from LRBase where 1=1 and status = '04' "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
				+ getWherePart(request, "Name", "p_Name")
				+ getWherePart(request, "BranchType", "p_BranchType")
				+" order by basecode desc"
			  	;
	}else if(SQLID.equals("LABaseRuleQueryR.js_SearchBaseInfo")){
		//strSQL = "select BaseCode,Name,BranchType,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),Remark,status  from LRBase where 1=1"
		SQL = " select BaseCode,Name,BranchType,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),Remark,status  from LRBase where 1=1 "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
			  	;
	}else if(SQLID.equals("LABaseRuleQueryR.js_SearchBase")){
		//strSQL = "select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),reason,Remark,branchtype,Status  from LRBase where 1=1"
		SQL = " select BaseCode,Name,(select a.codename from ldcode a where a.codetype='branchtype' and branchtype=a.code),(select a.codename from ldcode a where a.codetype='status' and Status=a.code),reason,Remark,branchtype,Status  from LRBase where 1=1  "
				+ getWherePart(request, "BaseCode", "p_BaseCode")
				+ getWherePart(request, "Name", "p_Name")
				+ getWherePart(request, "BranchType", "p_BranchType")
				+ getWherePart(request, "Status", "p_Status")
				+" order by basecode desc"
			  	;
	}
	
%>
<%
	System.out.println("InputSQL===:" + SQL);
	request.setAttribute("EASYQUERYSQL", SQL);
%>
