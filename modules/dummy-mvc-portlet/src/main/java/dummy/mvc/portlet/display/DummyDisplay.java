package dummy.mvc.portlet.display;

import com.liferay.portal.kernel.model.Layout;

public class DummyDisplay {

    public String returnSomeString() {
        return returnSomeString("No string here");
    }

    public String returnSomeString(String some) {
        return some;
    }

    public String doSomethingWithLayout(Layout layout) {
        return String.valueOf(layout.getGroup().isUser());
    }
}
