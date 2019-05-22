package dummy.mvc.portlet.template;


import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.Portal;
import dummy.mvc.portlet.constants.DummyMvcPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;
import java.util.Map;

@Component(
        immediate = true,
        property = "javax.portlet.name=" + DummyMvcPortletKeys.DummyMvc,
        service = TemplateHandler.class
)
public class DummyMvcPortletTemplateHandler extends BasePortletDisplayTemplateHandler {

    @Reference
    private Portal portal;

    @Override
    public String getClassName() {
        return Group.class.getName();
    }

    @Override
    public String getName(Locale locale) {
        String portletTitle = portal.getPortletTitle(
                DummyMvcPortletKeys.DummyMvc, locale);

        return LanguageUtil.format(locale, "x-template", portletTitle, false);
    }

    @Override
    public String getResourceName() {
        return DummyMvcPortletKeys.DummyMvc;
    }

    @Override
    public Map<String, TemplateVariableGroup> getTemplateVariableGroups(long classPK, String language, Locale locale) throws Exception {
        Map<String, TemplateVariableGroup> templateVariableGroups = super.getTemplateVariableGroups(classPK, language, locale);
        return templateVariableGroups;
    }
}
