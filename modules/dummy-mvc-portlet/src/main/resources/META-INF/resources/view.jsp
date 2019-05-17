<%@ page import="com.liferay.portal.kernel.model.*" %>
<%@ page import="com.liferay.sites.kernel.util.SitesUtil" %>
<%@ page import="com.liferay.sites.kernel.util.Sites" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%--<%@ page import="com.liferay.portal.kernel.model.Group" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.model.GroupConstants" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.Map" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.util.*" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.model.GroupWrapper" %>--%>
<%--<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>--%>
<%@ include file="/init.jsp" %>

<h3>Hello from Dummy OSGI portlet</h3>
<p>
    <b>


    <%!
        private SearchContainer<Object> searchContainer;
        private GroupWrapper group;
    %>



        <liferay-ui:message key="dummymvc.caption"/></b>
</p>

<%
    boolean doConfigure;
    doConfigure = Validator.isNull(dummyField);
    System.out.println(dummyField);

    String tabs1 = ParamUtil.getString(request, "tabs1", "my-sites");

    if (!tabs1.equals("my-sites") && !tabs1.equals("available-sites")) {
        tabs1 = "my-sites";
    }

    String displayStyle = ParamUtil.getString(request, "displayStyle", "list");

    PortletURL portletURL = renderResponse.createRenderURL();

    portletURL.setParameter("tabs1", tabs1);

    request.setAttribute("view.jsp-tabs1", tabs1);



        System.out.println(renderRequest.getWindowState());
        System.out.println("Текущий урл - " + themeDisplay.getURLCurrent());
        System.out.println("Текущий юзер - " + themeDisplay.getUser().getScreenName());
        System.out.println("Текущий юзер - " + themeDisplay.getUser().getFullName());
        System.out.println("Текущий юзер - " + themeDisplay.getUserId());
        System.out.println("Текущий organisation - " + themeDisplay.getScopeGroupName());
        System.out.println("Текущий organisationId - " + scopeGroupId);
        System.out.println("Текущий plid - " + plid);
        System.out.println("Текущий regularUrl - " + layout.getRegularURL(request));
        System.out.println("Текущий target - " + layout.getTarget());
        System.out.println("Текущий friendlyUrl - " + layout.getFriendlyURL(Locale.US));
        System.out.println("layout.groupId - " + layout.getGroup().getGroupId());
        System.out.println("layout group type - " + layout.getGroup().getType());
        System.out.println("layout group typeLabel - " + layout.getGroup().getTypeLabel());
        System.out.println(" layout group type mlname - " + layout.getGroup().getName(Locale.US));
        System.out.println("layout group name - " + layout.getGroup().getName());
        System.out.println("layout group display url - " + layout.getGroup().getDisplayURL(themeDisplay));
        System.out.println("layout group display url - " + layout.getGroup().getScopeDescriptiveName(themeDisplay));
        System.out.println("layout group display url - " + layout.getGroup().getScopeLabel(themeDisplay));
        System.out.println("layout group is organization - " + layout.getGroup().isOrganization());
        System.out.println("layout group is user - " + layout.getGroup().isUser());



    GroupSearch groupSearch = new GroupSearch(renderRequest, PortletURLUtil.clone(portletURL, renderResponse));

    GroupSearchTerms searchTerms = (GroupSearchTerms) groupSearch.getSearchTerms();

    LinkedHashMap<String, Object> groupParams = new LinkedHashMap<String, Object>();

//    groupParams.put("site", Boolean.TRUE);
    groupParams.put("site", Boolean.FALSE);

    if (layout.getGroup().isUser()) {
//        groupParams.put("usersGroups", user.getUserId());
        groupParams.put("usersGroups", layout.getUserId());
        groupParams.put("active", Boolean.TRUE);

    } else if (layout.getGroup().isOrganization()) {
//        groupParams.put("organizationGroups", layout.getGroupId());
        groupParams.put("usersGroups", layout.getUserId());

        groupParams.put("active", Boolean.TRUE);

        System.out.println(GroupLocalServiceUtil.getOrganizationGroupsCount(layout.getGroupId()));
        System.out.println(layout.getGroupId());
        System.out.println(GroupLocalServiceUtil.getOrganizationGroupsCount(64543));


    } else {
        List types = new ArrayList();

        types.add(Integer.valueOf(GroupConstants.TYPE_SITE_OPEN));
        types.add(Integer.valueOf(GroupConstants.TYPE_SITE_RESTRICTED));

//        groupParams.put("types", types);
//        groupParams.put("active", Boolean.TRUE);
    }


    int groupsCount = GroupLocalServiceUtil.searchCount(company.getCompanyId(), searchTerms.getKeywords(), groupParams);


    groupSearch.setTotal(groupsCount);

    List<Group> groups = GroupLocalServiceUtil.search(company.getCompanyId(), searchTerms.getKeywords(), groupParams, groupSearch.getStart(), groupSearch.getEnd(), groupSearch.getOrderByComparator());


    Long layoutId = Long.parseLong(dummyField);
//

    if (layoutId != 0) {
        List<Group> filteredGroups = new ArrayList<>();
        for (Group group : groups) {
            if ((group.getPublicLayoutSet().getLayoutSetPrototypeId() == layoutId) ||
                    (group.getPrivateLayoutSet().getLayoutSetPrototypeId() == layoutId)){
                filteredGroups.add(group);
            }
        }
        groups = filteredGroups;
    }

//    List<Group> collect = groups.stream().filter(group1 -> {
//        try {
//            return LayoutLocalServiceUtil.getLayout(group1.getGroupId(), false, layoutId) != null;
//        } catch (PortalException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }).collect(Collectors.toList());




    groupSearch.setResults(groups);



    long[] groupIds = ListUtil.toLongArray(groups, Group.GROUP_ID_ACCESSOR);


    Map<Long, Integer> groupUsersCounts = UserLocalServiceUtil.searchCounts(company.getCompanyId(), WorkflowConstants.STATUS_APPROVED, groupIds);




%>

<%--<clay:navigation-bar navigationItems="<%= navigationItems %>" />--%>


<liferay-frontend:management-bar>
    <liferay-frontend:management-bar-buttons>
        <liferay-frontend:management-bar-display-buttons
                displayViews='<%= new String[] {"icon", "list"} %>'
                portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
                selectedDisplayStyle="<%= displayStyle %>"
        />
    </liferay-frontend:management-bar-buttons>

    <liferay-frontend:management-bar-filters>
        <liferay-frontend:management-bar-navigation
                navigationKeys='<%= new String[] {"all"} %>'
                portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
        />

        <liferay-frontend:management-bar-sort
                orderByCol="<%= groupSearch.getOrderByCol() %>"
                orderByType="<%= groupSearch.getOrderByType() %>"
                orderColumns='<%= new String[] {"name"} %>'
                portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
        />

        <li>
            <aui:form action="<%= portletURL %>" name="searchFm">
                <liferay-portlet:renderURLParams varImpl="portletURL"/>

                <liferay-ui:input-search
                        autoFocus="<%=WindowState.MAXIMIZED.equals(portletURL.getWindowState()) %>"
                        markupView="lexicon"/>
            </aui:form>
        </li>
    </liferay-frontend:management-bar-filters>
</liferay-frontend:management-bar>


<c:choose>
    <c:when test="<%= doConfigure %>">
        <liferay-ui:message
                key="dummymvc.congiguration.no-config"
        />
    </c:when>
    <c:otherwise>
        <p>
            # <%= dummyField %> #
        </p>
        <p>
            # Total sites number is - <%= groupsCount %> #
        </p>
        <p>
            <liferay-ui:message
                    key="dummymvc.congiguration.caption"
            />
        </p>
    </c:otherwise>
</c:choose>


<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="get" name="fm">
    <liferay-ui:search-container
            searchContainer="<%= groupSearch %>"
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
                } else if (tabs1.equals("my-sites") && (group.getPrivateLayoutsPageCount() > 0)) {
                    rowURL = group.getDisplayURL(themeDisplay, true);
                }
            %>

            <c:choose>
<%--                <c:when test='<%= displayStyle.equals("descriptive") %>'>--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="<%= Validator.isNotNull(siteImageURL) %>">--%>
<%--                            <liferay-ui:search-container-column-image--%>
<%--                                    src="<%= siteImageURL %>"--%>
<%--                            />--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <liferay-ui:search-container-column-icon--%>
<%--                                    icon="sites"--%>
<%--                            />--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>

<%--                    <liferay-ui:search-container-column-text--%>
<%--                            colspan="<%= 2 %>"--%>
<%--                    >--%>
<%--                        <h5>--%>
<%--                            <c:choose>--%>
<%--                                <c:when test="<%= Validator.isNotNull(rowURL) %>">--%>
<%--                                    <a href="<%= rowURL %>" target="_blank">--%>
<%--                                        <strong><%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>--%>
<%--                                        </strong>--%>
<%--                                    </a>--%>
<%--                                </c:when>--%>
<%--                                <c:otherwise>--%>
<%--                                    <strong><%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>--%>
<%--                                    </strong>--%>
<%--                                </c:otherwise>--%>
<%--                            </c:choose>--%>
<%--                        </h5>--%>

<%--                        <c:if test='<%= !tabs1.equals("my-sites") && Validator.isNotNull(group.getDescription(locale)) %>'>--%>
<%--                            <h6 class="text-default">--%>
<%--                                <%= HtmlUtil.escape(group.getDescription(locale)) %>--%>
<%--                            </h6>--%>
<%--                        </c:if>--%>

<%--                        <h6 class="text-default">--%>
<%--                            <liferay-asset:asset-tags-summary--%>
<%--                                    className="<%= Group.class.getName() %>"--%>
<%--                                    classPK="<%= group.getGroupId() %>"--%>
<%--                            />--%>
<%--                        </h6>--%>

<%--                        <h6 class="text-default">--%>
<%--                            <strong><liferay-ui:message--%>
<%--                                    key="members"/></strong>: <%= GetterUtil.getInteger(groupUsersCounts.get(group.getGroupId())) %>--%>
<%--                        </h6>--%>

<%--                        <c:if test='<%= tabs1.equals("my-sites") && PropsValues.LIVE_USERS_ENABLED %>'>--%>
<%--                            <h6 class="text-default">--%>
<%--                                <strong><liferay-ui:message--%>
<%--                                        key="online-now"/></strong>: <%= String.valueOf(LiveUsers.getGroupUsersCount(company.getCompanyId(), group.getGroupId())) %>--%>
<%--                            </h6>--%>
<%--                        </c:if>--%>
<%--                    </liferay-ui:search-container-column-text>--%>

<%--                    <liferay-ui:search-container-column-jsp--%>
<%--                            path="/site_action.jsp"--%>
<%--                    />--%>
<%--                </c:when>--%>
                <c:when test='<%= displayStyle.equals("icon") %>'>

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
                                                key="members"/></strong>: <%= String.valueOf(groupUsersCounts.get(group.getGroupId())) %>
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
                                                key="members"/></strong>: <%= String.valueOf(groupUsersCounts.get(group.getGroupId())) %>
                                    </liferay-frontend:vertical-card-footer>
                                </liferay-frontend:icon-vertical-card>
                            </c:otherwise>
                        </c:choose>
                    </liferay-ui:search-container-column-text>
                </c:when>
                <c:when test='<%= displayStyle.equals("list") %>'>
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
                                </strong>
                            </c:otherwise>
                        </c:choose>

                        <c:if test='<%= !tabs1.equals("my-sites") && Validator.isNotNull(group.getDescription(locale)) %>'>
                            <br/>

                            <em><%= HtmlUtil.escape(group.getDescription(locale)) %>
                            </em>
                        </c:if>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text
                            name="members"
                            value="<%= String.valueOf(groupUsersCounts.get(group.getGroupId())) %>"
                    />

<%--                    <c:if test='<%= tabs1.equals("my-sites")--%>
<%--//                     &&--%>
<%--//                    PropsValues.LIVE_USERS_ENABLED--%>
<%--                    %>'>--%>
<%--                        <liferay-ui:search-container-column-text--%>
<%--                                name="online-now"--%>
<%--                                value="<%=--%>
<%--                                "3"--%>
<%--//                                String.valueOf(LiveUsers.getGroupUsersCount(company.getCompanyId(), group.getGroupId()))--%>
<%--                                %>"--%>
<%--                        />--%>
<%--                    </c:if>--%>

                    <liferay-ui:search-container-column-text
                            name="tags"
                    >
                        <liferay-asset:asset-tags-summary
                                className="<%= Group.class.getName() %>"
                                classPK="<%= group.getGroupId() %>"
                        />
                    </liferay-ui:search-container-column-text>

<%--                    <liferay-ui:search-container-column-jsp--%>
<%--                            path="/site_action.jsp"--%>
<%--                    />--%>
                </c:when>
            </c:choose>
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon"/>
    </liferay-ui:search-container>
</aui:form>