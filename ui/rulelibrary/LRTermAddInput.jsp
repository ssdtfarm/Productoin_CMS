<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<%@include file="/i18n/language.jsp"%>
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
  <script src="./LRTermAddInput.js" charset="UTF-8"></script>
  <%@include file="./LRTermAddInit.jsp"%>
    <style>
  	.att{display:none;}
  	.sql{display:none;}
  	</style>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./LRTermAddSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg><%=bundle.getString("BOM_Additem")%></td>
            </tr>
        </table>
        <div id='div0' style='display:'''>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title><%=bundle.getString("BOM_ItemName")%></td>
                    <td class=input><input name='Name' class='common'  verify='<%=bundle.getString("BOM_ItemName")%>|notnull' elementtype=nacessary/></td>
                    <td class=title><%=bundle.getString("BOM_DataType")%></td>
                    <td class=input><input class='codeno' name='Remark' verify='<%=bundle.getString("BOM_DataType")%>|notnull&code:ibrmscommandtype' ondblclick="return showCodeList('ibrmscommandtype',[this,RemarkName],[0,1],null,null,null,null,null,1);" onkeyup="return showCodeListKey('ibrmscommandtype',[this,RemarkName],[0,1],null,null,null,null,null,1)" /><input class=codename name='RemarkName'  readonly elementtype=nacessary /></td>
                </tr>
                <tr>
                    <td class=title><%=bundle.getString("BOM_CalculationType")%></td>
                    <td class=input><input class='codeno' name='Calculate' verify='<%=bundle.getString("BOM_CalculationType")%>|notnull&code:calculate' ondblclick="return showCodeList('calculate',[this,CalculateName],[0,1],null,null,null,null,null,1);" /><input class=codename name='CalculateName'  readonly elementtype=nacessary /></td>     
                    <td class=title><%=bundle.getString("BOM_Status")%></td>
                    <td><input name="State" class="codeno" onkeyup="return showCodeListKey('yesno',[this,EndFlagName],[0,1],null,null,null,null,null,1)" ondblclick="return showCodeList('yesno',[this,EndFlagName],[0,1],null,null,null,1);" verify="<%=bundle.getString("BOM_Status")%>|notnull&code:yesno" value="Y"/><input name="EndFlagName" class="codename" readOnly="" elementtype="nacessary" value="是"/></td>
                </tr> 
                <tr>
                  <td class='title att'>Property</td>
                  <td class='input att' ><input name='Attribute' class='common'  /></td>   
                  <td class='title sql'>SQL</td>
               	  <td colspan="3" class='sql'><textarea name="textarea"  rows="5" style='width:90%;'></textarea> </td>
              	</tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='save' value="<%=bundle.getString("C_Save")%>" type="button" onclick="return save();"/>
            </div>
        </div><!-- 
        <table>
        	<br>
        	  <td valign=top> <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg>短语</td>
            </tr>
        </table>
        <div id='div2' style='width:100%'>
            <div id="divPhraseGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanPhraseGird" ></span>
                        </td>
                    </tr>
                </table>                
            </div>
        </div><td>
        		<td valign=top><table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div3);"></td>
                <td class=titleImg>参数</td>
            </tr>
        </table>
        <div id='div3' style='width:100%'>
            <div id="divParaGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanParaGird" ></span>
                        </td>
                    </tr>
                </table>                
            </div>
        </div>
        <td>
        </table> -->
       
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="BomId">
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>