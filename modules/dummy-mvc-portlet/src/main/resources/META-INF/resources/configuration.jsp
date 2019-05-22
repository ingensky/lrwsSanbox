<%@ page import="com.liferay.portal.kernel.model.Layout" %>
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
    <div class="lfr-form-content">
        <div class="sheet sheet-lg">

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset>


                    <aui:select label="Dummy field" name="dummyField" value="<%= dummyField %>">
                        <aui:option value="<%= "0" %>">All sites</aui:option>
                        <%
                            for (LayoutSetPrototype prototype : layoutSetPrototypes) {
                                String name = prototype.getName(Locale.US);
                                long prototypeId = prototype.getLayoutSetPrototypeId();
                        %>
                        <aui:option label="<%= name %>" value="<%= prototypeId %>"/>
                        <%
                            }
                        %>

                    </aui:select>

                    <div class="display-template">
                        <liferay-ddm:template-selector
                                className="<%= Group.class.getName() %>"
                                displayStyle="<%= displayStyle %>"
                                displayStyleGroupId="<%= displayStyleGroupId %>"
                                refreshURL="<%= configurationRenderURL %>"
                                showEmptyOption="<%= true %>"
                        />
                    </div>
                </aui:fieldset>
            </aui:fieldset-group>
        </div>
    </div>


    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" />


    </aui:button-row>
</aui:form>
