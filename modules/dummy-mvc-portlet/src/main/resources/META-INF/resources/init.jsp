
<%@ page import="dummy.mvc.portlet.configuration.DummyPortletConfiguration" %>
<%@ page import="dummy.mvc.portlet.display.DummyDisplayContext" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@
taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>


<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.kernel.model.GroupWrapper" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.model.*" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.service.*" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%


    DummyPortletConfiguration demoConfiguration = (DummyPortletConfiguration)
            renderRequest.getAttribute(DummyPortletConfiguration.class.getName());

    String dummyField = StringPool.BLANK;


    if (Validator.isNotNull(demoConfiguration)) {
        dummyField = portletPreferences.getValue(
                        "dummyField", demoConfiguration.dummyField());

    }else{
        dummyField =	portletPreferences.getValue("dummyField", "0");

    }

    DummyDisplayContext dummyDisplayContext = new DummyDisplayContext(renderRequest,
            renderResponse,
            themeDisplay,
            layout,
            company,
            dummyField);
%>