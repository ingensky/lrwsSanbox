package sunrise.sites.mvc.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * Interface containing configurable portlet fields
 *
 * @author sky
 * @see <a href="https://dev.liferay.com/en/develop/tutorials/-/knowledge_base/7-1/making-applications-configurable">Liferay Docs</a>
 */
@Meta.OCD(
        id = "sunrise.sites.mvc.portlet.portlet.SitesPortlet"
)
public interface SitesPortletConfiguration {

    @Meta.AD(required = false)
    String sitesTemplateId();

}
