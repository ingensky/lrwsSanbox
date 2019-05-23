package sunrise.sites.mvc.portlet.template;


import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import sunrise.sites.mvc.portlet.constants.SitesPortletKeys;

import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * Class for Application Display Template handling
 *
 * @author sky
 * @see <a href="https://dev.liferay.com/en/develop/tutorials/-/knowledge_base/7-0/implementing-application-display-templates">Liferay Docs</a>
 */
@Component(
        immediate = true,
        property = "javax.portlet.name=" + SitesPortletKeys.SITES,
        service = TemplateHandler.class
)
public class SitesPortletTemplateHandler extends BasePortletDisplayTemplateHandler {

    @Reference
    private Portal portal;

    @Override
    public String getClassName() {
        return Group.class.getName();
    }

    @Override
    public String getName(Locale locale) {
        String portletTitle = portal.getPortletTitle(SitesPortletKeys.SITES, locale);
        return LanguageUtil.format(locale, "x-template", portletTitle, false);
    }

    @Override
    public String getResourceName() {
        return SitesPortletKeys.SITES;
    }

    @Override
    public Map<String, TemplateVariableGroup> getTemplateVariableGroups(long classPK, String language, Locale locale) throws Exception {
        Map<String, TemplateVariableGroup> templateVariableGroups = super.getTemplateVariableGroups(classPK, language, locale);
        TemplateVariableGroup fieldsTemplateVariableGroup = templateVariableGroups.get("fields");

        fieldsTemplateVariableGroup.empty();

        fieldsTemplateVariableGroup.addCollectionVariable(
                "sites", List.class, PortletDisplayTemplateManager.ENTRIES,
                "site", Group.class, "currentSite", "name");
        return templateVariableGroups;
    }
}
