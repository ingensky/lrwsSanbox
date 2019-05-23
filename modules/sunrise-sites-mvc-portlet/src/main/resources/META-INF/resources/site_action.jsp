<%@ include file="/init.jsp" %>

<%
    ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Group group = (Group)row.getObject();
%>

<liferay-ui:icon-menu
        direction="left-side"
        icon="<%= StringPool.BLANK %>"
        markupView="lexicon"
        message="<%= StringPool.BLANK %>"
        showWhenSingleIcon="<%= true %>"
>
    <c:choose>
        <c:when test='<%= true %>'>
            <c:if test="<%= LayoutServiceUtil.getLayoutsCount(group.getGroupId(), false) > 0 %>">
                <liferay-ui:icon
                        message="go-to-public-pages"
                        target="_blank"
                        url="<%= group.getDisplayURL(themeDisplay, false) %>"
                />
            </c:if>

            <c:if test="<%= LayoutServiceUtil.getLayoutsCount(group.getGroupId(), true) > 0 %>">
                <liferay-ui:icon
                        message="go-to-private-pages"
                        target="_blank"
                        url="<%= group.getDisplayURL(themeDisplay, true) %>"
                />
            </c:if>
        </c:when>
    </c:choose>
</liferay-ui:icon-menu>