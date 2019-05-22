<%@ page import="javax.portlet.PortletURL" %>
<%@ include file="/init.jsp" %>

<%!
    private SearchContainer<Object> searchContainer;
    private GroupWrapper group;
    private ResultRow row;

%>

<%
    boolean doConfigure;
    doConfigure = Validator.isNull(dummyField);
    System.out.println(dummyField);

    HashMap<String, Object> contextObjects = new HashMap<>();

%>

<liferay-ddm:template-renderer
        className="<%= Group.class.getName() %>"
        contextObjects="<%= contextObjects %>"
        displayStyle="<%= displayStyle %>"
        displayStyleGroupId="<%= displayStyleGroupId %>"
        entries="<%= dummyDisplayContext.getGroupSearchContainer().getResults() %>"
>

<div class="container-fluid container-fluid-max-xl container-view">
    <%--    <span class="sticker sticker-primary sticker-sm">ID of template filter is <%= dummyField %></span>--%>
    <span class="label label-lg label-info">
	    <span class="label-item label-item-expand">ID of template filter is: <%= dummyField %></span>
    </span>
</div>
<div class="container-fluid">
    <%--    <span class="sticker sticker-primary sticker-lg">Total sites number is <%= dummyDisplayContext.getTotalItems() %></span>--%>
    <span class="label label-lg label-info">
	    <span class="label-item label-item-expand">Total sites number is: <%= dummyDisplayContext.getTotalItems() %></span>
    </span>
</div>


<clay:management-toolbar
        componentId="siteDummyWebManagementToolbar"
        showSearch="false"
        itemsTotal="<%= dummyDisplayContext.getTotalItems() %>"
        selectable="<%= false %>"
        viewTypeItems="<%= dummyDisplayContext.getViewTypeItems() %>"
/>

<aui:form action="<%= dummyDisplayContext.getPortletURL() %>" cssClass="container-fluid-1280" method="get" name="fm">
    <liferay-ui:search-container
            searchContainer="<%= dummyDisplayContext.getGroupSearchContainer() %>"
    >


        <liferay-ui:search-container-row
                className="com.liferay.portal.kernel.model.Group"
                keyProperty="groupId"
                modelVar="group"
                rowIdProperty="friendlyURL"
        >

            <%
                String siteImageURL = group.getLogoURL(themeDisplay, false);

                String rowURL = StringPool.BLANK;

                if (group.getPublicLayoutsPageCount() > 0) {
                    rowURL = group.getDisplayURL(themeDisplay, false);
                } else if (group.getPrivateLayoutsPageCount() > 0) {
                    rowURL = group.getDisplayURL(themeDisplay, true);
                }
            %>


            <c:choose>
                <c:when test='<%= Objects.equals(dummyDisplayContext.getDisplayStyle(), "adt") %>'>
                    <div class="sheet">
                    <h4>
                        <%= group.getName() %>
                    </h4>
                    </div>

                </c:when>
                <c:when test='<%= Objects.equals(dummyDisplayContext.getDisplayStyle(), "icon") %>'>

                    <%
                        row.setCssClass("entry-card lfr-asset-item");
                    %>

                    <liferay-ui:search-container-column-text>
                        <c:choose>
                            <c:when test="<%= Validator.isNotNull(siteImageURL) %>">
                                <liferay-frontend:vertical-card
                                        actionJsp="/site_action.jsp"
                                        actionJspServletContext="<%= application %>"
                                        imageUrl="<%= siteImageURL %>"
                                        resultRow="<%= row %>"
                                        rowChecker="<%= searchContainer.getRowChecker() %>"
                                        title="<%= group.getDescriptiveName(locale) %>"
                                        url="<%= rowURL %>"
                                >
                                    <liferay-frontend:vertical-card-footer>
                                        <strong><liferay-ui:message
                                                key="members"/></strong>: <%= String.valueOf(dummyDisplayContext.getGroupUsersCounts(group.getGroupId())) %>
                                    </liferay-frontend:vertical-card-footer>
                                </liferay-frontend:vertical-card>
                            </c:when>
                            <c:otherwise>
                                <liferay-frontend:icon-vertical-card
                                        actionJsp="/site_action.jsp"
                                        actionJspServletContext="<%= application %>"
                                        icon="sites"
                                        resultRow="<%= row %>"
                                        rowChecker="<%= searchContainer.getRowChecker() %>"
                                        title="<%= group.getDescriptiveName(locale) %>"
                                        url="<%= rowURL %>"
                                >
                                    <liferay-frontend:vertical-card-footer>
                                        <strong><liferay-ui:message
                                                key="members"/></strong>: <%= String.valueOf(dummyDisplayContext.getGroupUsersCounts(group.getGroupId())) %>
                                    </liferay-frontend:vertical-card-footer>
                                </liferay-frontend:icon-vertical-card>
                            </c:otherwise>
                        </c:choose>
                    </liferay-ui:search-container-column-text>
                </c:when>
                <c:when test='<%= Objects.equals(dummyDisplayContext.getDisplayStyle(), "list") %>'>

                    <liferay-ui:search-container-column-text
                            name="name"
                            orderable="<%= true %>"
                            truncate="<%= true %>"
                    >
                        <c:choose>
                            <c:when test="<%= Validator.isNotNull(rowURL) %>">
                                <a href="<%= rowURL %>" target="_blank">
                                    <strong><%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
                                    </strong>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <strong><%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
                                    <%= group.getName(Locale.US)%>
                                </strong>
                            </c:otherwise>
                        </c:choose>

                        <c:if test='<%= Validator.isNotNull(group.getDescription(locale)) %>'>
                            <br/>

                            <em><%= HtmlUtil.escape(group.getDescription(locale)) %>
                            </em>
                        </c:if>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text
                            name="members"
                            value="<%= String.valueOf(dummyDisplayContext.getGroupUsersCounts(group.getGroupId())) %>"
                    />



                    <liferay-ui:search-container-column-text
                            name="tags"
                    >
                        <liferay-asset:asset-tags-summary
                                className="<%= Group.class.getName() %>"
                                classPK="<%= group.getGroupId() %>"
                        />
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-jsp
                            path="/site_action.jsp"
                    />
                </c:when>
            </c:choose>
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator displayStyle="<%= dummyDisplayContext.getDisplayStyle() %>" markupView="lexicon"/>
    </liferay-ui:search-container>
</aui:form>

</liferay-ddm:template-renderer>
