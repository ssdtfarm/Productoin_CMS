<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<head>
  <script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
  <script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
  <script src="../common/javascript/Common.js" charset="UTF-8"></script>
  <script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
  <script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <script src="./LAIndexRuleInput.js" charset="UTF-8"></script>
  <%@include file="./LAIndexRuleInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LAIndexRuleSave.jsp" method=post name=fm target="fraSubmit">    	 
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("C_SelectedRule")%></td>
            </tr>
        </table>
        <div id='div0' style='width:100%'>            
		<table class=common>
				<tr>
                    <td class=title><%=bundle.getString("C_TitleCode")%></td>
                    <td class=input><input name='AgentGrade' class='common'  readonly/></td>
                    <td class=title><%=bundle.getString("TitleName")%></td>
                    <td class=input><input name='AgentName' class='common'  readonly/></td>                   
               </tr>
               <tr>
                <td class=title><%=bundle.getString("BOM_WageCode")%></td>
                <td class=input><input name='WageCode' class='common'  readonly/></td>
                <td class=title><%=bundle.getString("BOM_WageName")%></td>
                <td class=input><input name='WageName' class='common'  readonly/></td>
               </tr>
               <tr>
                    <td class=title><%=bundle.getString("BOM_RuleCode")%></td>
                    <td class=input><input name='IndexCode' class='common'  readonly/></td>
                    <td class=title><%=bundle.getString("BOM_RuleName")%></td>
                    <td class=input><input name='Description' class='common'  readonly/></td>
              </tr>		
		</table>
		<!-- input class="cssButton" buttonname='saveClick' value="定 制 参 数" type="button" onclick="return queryPara();"/> -->
		</div><br/>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div1);"></td>
                <td class=titleImg><%=bundle.getString("C_AlternativeRule")%></td>
            </tr>
        </table>
        <div id='div1' style='width:100%'>            
		<table class=common>
			<tr>
				<td class=titleImg><%=bundle.getString("C_RuleSuggestedRuleList")%> </td>
			</tr>
		</table>
        <div id='div4' style='width:100%'>
            <div id="divRuleGrid">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanRuleGrid" ></span>
                        </td>
                    </tr>
                </table>
                <!-- 
                <input value="<%=bundle.getString("Btn_FirstPage")%>" type=button onclick="turnPageRuleGrid.firstPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_PreviousPage")%>" type=button onclick="turnPageRuleGrid.previousPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_NextPage")%>" type=button onclick="turnPageRuleGrid.nextPage();" class="cssButton"/>
                <input value="<%=bundle.getString("Btn_LastPage")%>" type=button onclick="turnPageRuleGrid.lastPage();" class="cssButton"/>
                 -->
                <div id="DivSaveClickInfo" style= "display: ''">
                <input class="cssButton" buttonname='saveClick' value="<%=bundle.getString("C_Select")%>" type="button" onclick="return saveClick();"/>
                </div>
            </div>
        </div>
        </div>     		
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
        <input type="hidden" name="BranchType" value=''/>
        <input type="hidden" name="BaseCode" value = ''/>
        <input type="hidden" name="IndexType" value= ''/>   
        <input type="hidden" name="IndexSerise" value=''/>           
        <input type=hidden name=hideIndexCode value=''>
	    <input type=hidden name=hideWageCode value=''>
 	    <input type=hidden name=hideWageName value=''>
 	    <input type=hidden name=hideCalCode value=''> 
 	    <input type=hidden name=hideDescription value=''> 
 	    <Input type=hidden value='' name=Operater>
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>