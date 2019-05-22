package sunrise.mvc.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
        id = "sunrise.mvc.portlet.portlet.DummyMvcPortlet"
)
public interface DummyPortletConfiguration {

    @Meta.AD(required = false)
    public String dummyField();


}
