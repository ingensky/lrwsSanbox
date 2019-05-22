package sunrise.mvc.portlet.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import sunrise.mvc.portlet.configuration.DummyPortletConfiguration;
import sunrise.mvc.portlet.constants.DummyMvcPortletKeys;
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
        configurationPid = "sunrise.mvc.portlet.portlet.DummyMvcPortlet",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = "javax.portlet.name="+ DummyMvcPortletKeys.DummyMvc,
        service = ConfigurationAction.class

)
public class DummyPortletConfigurationAction extends DefaultConfigurationAction {

    private static final Log _log = LogFactoryUtil.getLog(DummyPortletConfigurationAction.class);

    private volatile DummyPortletConfiguration _dummyPortletConfiguration;

    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setAttribute(DummyPortletConfiguration.class.getName(), _dummyPortletConfiguration);

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

//        _dummyPortletConfiguration = Configurable.createConfigurable(DummyPortletConfiguration.class, properties);
        _dummyPortletConfiguration = ConfigurableUtil.createConfigurable(DummyPortletConfiguration.class, properties);
    }
}
