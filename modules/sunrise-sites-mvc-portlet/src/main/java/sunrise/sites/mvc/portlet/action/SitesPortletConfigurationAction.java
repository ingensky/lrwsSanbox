package sunrise.sites.mvc.portlet.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import sunrise.sites.mvc.portlet.configuration.SitesPortletConfiguration;
import sunrise.sites.mvc.portlet.constants.SitesPortletKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component(
        configurationPid = "sunrise.sites.mvc.portlet.portlet.SitesPortlet",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = "javax.portlet.name="+ SitesPortletKeys.SITES,
        service = ConfigurationAction.class

)
public class SitesPortletConfigurationAction extends DefaultConfigurationAction {

    private static final Log _log = LogFactoryUtil.getLog(SitesPortletConfigurationAction.class);

    private volatile SitesPortletConfiguration sitesPortletConfiguration;

    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setAttribute(SitesPortletConfiguration.class.getName(), sitesPortletConfiguration);

        super.include(portletConfig, request, response);

    }


    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String dummyField = ParamUtil.getString(actionRequest, "dummyField");

        setPreference(actionRequest, "dummyField", dummyField);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _log.info("#####  Calling activate in action class #####");

//        sitesPortletConfiguration = Configurable.createConfigurable(SitesPortletConfiguration.class, properties);
        sitesPortletConfiguration = ConfigurableUtil.createConfigurable(SitesPortletConfiguration.class, properties);
    }
}
