package sunrise.sites.mvc.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
        id = "sunrise.sites.mvc.portlet.portlet.SitesPortlet"
)
public interface SitesPortletConfiguration {

    @Meta.AD(required = false)
    public String dummyField();


}
