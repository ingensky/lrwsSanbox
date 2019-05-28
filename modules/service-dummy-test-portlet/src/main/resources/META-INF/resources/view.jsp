<%@ include file="/init.jsp" %>
<portlet:actionURL name="dummyMessageSubmit" var="dummyMessageSubmit"/>

<h3>Dummy message Submit</h3>
<aui:form action="<%=dummyMessageSubmit%>" method="post">
	<aui:input name="text" label="Text" type="text" autoFocus="true" required="true"/>
	<aui:input name="tag" label="Tag" type="text" value="void"/>
	<aui:button type="submit"/>
</aui:form>

<p>
	<b><liferay-ui:message key="servicedummytest.caption"/></b>
</p>