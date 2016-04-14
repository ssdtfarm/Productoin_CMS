<%@include file="../../common/jsp/UsrCheck.jsp"%>
<%@include file="/i18n/language.jsp"%>
<%@page import="org.owasp.esapi.ESAPI"%>
?<!DOCTYPE html>
<%
	String mEditMode = request.getParameter("EditMode");
	String mBaseCode = request.getParameter("BaseCode");
	String mWageCode = request.getParameter("WageCode");
	String mIndexCode = request.getParameter("IndexCode");
	if(mEditMode == null || mEditMode.trim().equals("")){
		mEditMode = "edit";
	}
	if(mWageCode == null || mWageCode.trim().equals("")){
		mWageCode = "";
	}
	if(mIndexCode == null || mIndexCode.trim().equals("")){
		mIndexCode = "";
	}
	mEditMode = ESAPI.encoder().encodeForJavaScript(mEditMode);
	mBaseCode = ESAPI.encoder().encodeForJavaScript(mBaseCode);
	mWageCode = ESAPI.encoder().encodeForJavaScript(mWageCode);
	mIndexCode = ESAPI.encoder().encodeForJavaScript(mIndexCode);
	
%>
<html>

<head>
  <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
  <title>editor</title>
  <script src="../../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="jquery.json.js" type="text/javascript" charset="UTF-8"></script>
  <script src="ember.js" type="text/javascript" charset="UTF-8"></script>
  <script type="text/javascript">
  	var editMode = '<%=mEditMode%>';
  	var baseCode = '<%=mBaseCode%>';
  	var wageCode = '<%=mWageCode%>';
  	var indexCode = '<%=mIndexCode%>';
  	var ruleType = 'common';//common,deci,expr
  </script>
</head>

<body>
  <script type="text/javascript" src="ruleeditor.js"></script>
  <div id="container">
      <script type="text/x-handlebars">
      	//{{#if App.testController.content}}
	      	{{bom App.testController.content}}
				//{{/if}}
      </script>
  </div>

    <script type="text/x-handlebars" data-template-name="edit-field">
#if isEditing}}
      {{        {{view App.TextField valueBinding="value" propagatesEvents=true}}
      {{else}}
#if value}}
        {{          {{value}}
        {{else}}
          <span class="no-name">empty</span>
        {{/if}}
      {{/if}}
    </script>
    <script type="text/x-handlebars" data-template-name="bom">
    	xXXXXXX
    </script>
    <script type="text/x-handlebars" data-template-name="bom2">
    	<table><tr><td>
#if name}}
    		{{    			<a href="#" {{action "showBoms"}}>{{name}}</a>
    		{{else}}
    			<a href="#" {{action "showBoms"}}><%=bundle.getString("G0000031353")%></a>
    		{{/if}}
#if showBoms}}
    		{{    			<ul>
#each boms}}
#view App.ItemView contentBinding="this"}}
    				{{    					{{    					<li><a href="#" {{action "selectBom"}}>{{name}}</a></li>
    					{{/view}}
    				{{/each}}
    			</ul>
    		{{/if}}
    	</td><td>
#if name}}
#if itemName}}
    		{{    			{{  					{{itemName}}
  				{{else}}
<%=bundle.getString("G0000036924")%>
  				{{/if}}
    		{{/if}}
    	</td>
#if itemName}}
    	{{				{{itemName}}
			{{else}}
<%=bundle.getString("G0000036924")%>
			{{/if}}
    	
#if name}}
    	{{    		<a href="#" {{action "showBoms"}}>{{name}}</a>
    			<a href="#" {{action "showitems"}}>
#if itemName}}
    				{{    					{{itemName}}
    				{{else}}
<%=bundle.getString("G0000036924")%>
    				{{/if}}
    			</a>
    	{{else}}
    		<a href="#" {{action "showBoms"}}><%=bundle.getString("G0000031353")%></a>
    	{{/if}}
    	
    	
#if isEditing}}
      {{        {{view App.TextField valueBinding="value" propagatesEvents=true}}
      {{else}}
#if value}}
        {{          {{value}}
        {{else}}
          <span class="no-name">empty</span>
        {{/if}}
      {{/if}}
    </script>
</body>

</html>
