package dummy.mvc.portlet.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import dummy.mvc.portlet.configuration.DummyPortletConfiguration;
import dummy.mvc.portlet.constants.DummyMvcPortletKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author sky
 */
@Component(
	configurationPid = "dummy.mvc.portlet.portlet.DummyMvcPortlet",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DummyMvcPortletKeys.DummyMvc,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DummyMvcPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DummyMvcPortlet.class);
	private volatile DummyPortletConfiguration _dummyPortletConfiguration;


	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ParamUtil.getString(renderRequest, "something");
		System.out.println("im in dummy mvcportlet");
		_log.info("dummy configuration field " + _dummyPortletConfiguration.dummyField());
		super.doView(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_log.info("##### Calling activate() method in portlet class #####");

		_dummyPortletConfiguration = ConfigurableUtil.createConfigurable(DummyPortletConfiguration.class, properties);
	}



}