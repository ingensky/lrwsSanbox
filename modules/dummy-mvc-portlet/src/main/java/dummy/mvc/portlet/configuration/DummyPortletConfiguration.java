package dummy.mvc.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
        id = "dummy.mvc.portlet.portlet.DummyMvcPortlet"
)
public interface DummyPortletConfiguration {

    @Meta.AD(required = false)
    public String dummyField();


}
