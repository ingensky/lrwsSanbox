<%@ include file="/init.jsp" %>

<%!
    private SearchContainer<Object> searchContainer;
    private GroupWrapper group;
    private ResultRow row;
%>

<%
    HashMap<String, Object> contextObjects = new HashMap<>();
%>

<liferay-ddm:template-renderer
        className="<%= Group.class.getName() %>"
        contextObjects="<%= contextObjects %>"
        displayStyle="<%= displayStyle %>"
        displayStyleGroupId="<%= displayStyleGroupId %>"
        entries="<%= sitesDisplayContext.getGroupSearchContainer().getResults() %>"
>

    <clay:management-toolbar
            componentId="siteDummyWebManagementToolbar"
            showSearch="false"
            itemsTotal="<%= sitesDisplayContext.getTotalItems() %>"
            selectable="<%= false %>"
            viewTypeItems="<%= sitesDisplayContext.getViewTypeItems() %>"
    />

    <aui:form action="<%= sitesDisplayContext.getPortletURL() %>" cssClass="container-fluid-1280" method="get"
              name="fm">
        <liferay-ui:search-container
                searchContainer="<%= sitesDisplayContext.getGroupSearchContainer() %>"
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
                    <c:when test='<%= Objects.equals(sitesDisplayContext.getDisplayStyle(), "icon") %>'>

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
                                                    key="members"/></strong>: <%= String.valueOf(sitesDisplayContext.getGroupUsersCounts(group.getGroupId())) %>
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
                                                    key="members"/></strong>: <%= String.valueOf(sitesDisplayContext.getGroupUsersCounts(group.getGroupId())) %>
                                        </liferay-frontend:vertical-card-footer>
                                    </liferay-frontend:icon-vertical-card>
                                </c:otherwise>
                            </c:choose>
                        </liferay-ui:search-container-column-text>
                    </c:when>
                    <c:when test='<%= Objects.equals(sitesDisplayContext.getDisplayStyle(), "list") %>'>

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
                                value="<%= String.valueOf(sitesDisplayContext.getGroupUsersCounts(group.getGroupId())) %>"
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

            <liferay-ui:search-iterator displayStyle="<%= sitesDisplayContext.getDisplayStyle() %>"
                                        markupView="lexicon"/>
        </liferay-ui:search-container>
    </aui:form>

</liferay-ddm:template-renderer>
