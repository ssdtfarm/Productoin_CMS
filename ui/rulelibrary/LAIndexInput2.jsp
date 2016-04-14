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
  <script src="./LAIndexInput.js" charset="UTF-8"></script>
  <%@include file="./LAIndexInit.jsp"%>
</head>
<title><%=bundle.getString("C_WageCustomisation")%></title>
<body  onload="initForms();initElementtype();">
    <form action="./LAIndexSave.jsp" method=post name=fm target="fraSubmit">     
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("C_WageCustomisation")%></td>
            </tr>
        </table>
      <div id='div0' style='width:100%'>           
        <table>
            <tr class=common>
            <td style="width: 10%; float: right; margin: 5px;" valign="top">
				<div>
					<div style="margin: 5px;font-weight: bold;text-align: left;font-size: 9pt;color: #000000"><%=bundle.getString("C_ExistentWageListofCurrentTitle")%></div>
						<div id="spanIndexGrid"></div>
							
						</div>
			</td>
		 <td class=common style="width: 10%;">		
            <div style="margin: 50px, 50px;">
            <input class="cssButton" id='remove' name='remove' buttonname='remove' value=" >> " type="button" onclick="return removeClick();"/><br>
            <input class="cssButton" id='add' name='add' buttonname='add' value=" << " type="button" onclick="return addClick();"/>

            </div>
         </td>	
         <td style="width: 40%; float: right; margin: 5px;" valign="top">
 	      	<div style="margin: 5px;">
 	        	<span style="font-weight: bold;text-align: left;font-size: 9pt;color: #000000"><%=bundle.getString("C_NonexistentWageListofCurrentTitle")%> </span>
				   <Input type=hidden name=IndexSerise />
									</div>
									<div id="spanRuleGrid"></div>
									
				</div>
			</td>
		</tr>
	</table>	
	<!-- <input class="cssButton" buttonname='saveClick' value="返 回" type="button" onclick="return returnParent();"/> -->
	</div>
	
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="BranchType" value=''/>
        <input type="hidden" name="BaseCode" value = ''/>
        <input type="hidden" name="IndexType" />
        <input type="hidden" name="AgentGrade" value=''/>
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>