<%@include file="../jsp/UsrCheck.jsp"%>
<%
//*******************************************************
//* 程序名称：ProposalButton.jsp
//* 程序功能：页面通用按钮
//* 创建日期：2002-05-20
//* 更新记录：  更新人    更新日期     更新原因/内容
//*             欧阳晟   2002-05-20    新建
//******************************************************
%>
<div id="operateButton">
	<table class=common align=center>
		<tr>
			<td class=button>
				&nbsp;&nbsp;
			</td>
			<td class=button width="10%">
				<img class=button alt="保存" src='../common/images/save.gif' onclick="return submitForm();" id="saveImg"></img>
			</td>
			<td class=button width="10%">
				<img class=button alt="重置" src='../common/images/reset.gif' onclick="return resetForm();"></img>
			</td>
		</tr>
	</table>
</div>