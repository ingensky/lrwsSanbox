
<%@ include file="/init.jsp" %>

<%
    List<LayoutSetPrototype> layoutSetPrototypes = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypes(company.getCompanyId());
    int lengthTemplate = layoutSetPrototypes.size();

%>

<liferay-portlet:actionURL
        portletConfiguration="<%= true %>"
        var="configurationActionURL"
/>

<liferay-portlet:renderURL
        portletConfiguration="<%= true %>"
        var="configurationRenderURL"
/>

<aui:form action="<%= configurationActionURL %>" cssClass="container-fluid-1280" method="post" name="fm">
    <aui:input
            name="<%= Constants.CMD %>"
            type="hidden"
            value="<%= Constants.UPDATE %>"
    />

    <aui:input
            name="redirect"
            type="hidden"
            value="<%= configurationRenderURL %>"
    />

    <aui:fieldset-group markupView="lexicon">
    <aui:fieldset>


    <aui:select label="Dummy field" name="dummyField" value="<%= dummyField %>">
        <aui:option value="<%= "0" %>">All sites</aui:option>
        <%
            for (LayoutSetPrototype prototype : layoutSetPrototypes) {
                String name = prototype.getName(Locale.US);
                long prototypeId = prototype.getLayoutSetPrototypeId();
        %>
        <aui:option label="<%= name %>" value="<%= prototypeId %>" />
        <%
        }
        %>

    </aui:select>
    </aui:fieldset>
    </aui:fieldset-group>


    <aui:button-row>
        <aui:button type="submit"></aui:button>
<%--        <aui:button href="<%= redirect %>" type="cancel" />--%>

    </aui:button-row>
</aui:form>
