
<%@ page import="dummy.mvc.portlet.configuration.DummyPortletConfiguration" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>



<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%--<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@--%>
<%--        taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@--%>
<%--        taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@--%>
<%--        taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>--%>


<%@
        taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
        taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
        taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
        taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
        taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
        taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
        taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>


<%@ page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portlet.usersadmin.search.GroupSearch" %>
<%@ page import="com.liferay.portlet.usersadmin.search.GroupSearchTerms" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="com.liferay.portal.kernel.model.Group" %>
<%@ page import="com.liferay.portal.kernel.model.GroupConstants" %>
<%@ page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.kernel.model.GroupWrapper" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutSetPrototypeLocalServiceUtil" %>

<%@ page import="com.liferay.portal.kernel.model.LayoutSetPrototype" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil" %>




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
%>