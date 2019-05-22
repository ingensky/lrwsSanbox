<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.model.Group" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>


<%@ page import="com.liferay.portal.kernel.model.GroupWrapper" %>
<%@ page import="com.liferay.portal.kernel.model.LayoutSetPrototype" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutSetPrototypeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.liferay.portal.kernel.model.Layout" %>


<%@ page import="dummy.mvc.portlet.configuration.DummyPortletConfiguration" %>
<%@ page import="dummy.mvc.portlet.display.DummyDisplayContext" %>
<%@ page import="dummy.mvc.portlet.constants.DummyMvcPortletKeys" %>



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

//    PortletPreferences preferences = PortletPreferencesLocalServiceUtil.getPreferences(company.getCompanyId(), scopeGroupId, PortletKeys.PREFS_OWNER_TYPE_GROUP, 0, DummyMvcPortletKeys.DummyMvc, null);

    String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", StringPool.BLANK));
    long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), scopeGroupId);

%>