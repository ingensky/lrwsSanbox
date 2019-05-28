package com.dummy.portlet;

import com.dummy.constants.ServiceDummyTestPortletKeys;

import com.dummy.model.DummyMessage;
import com.dummy.model.DummyMessageModel;
import com.dummy.model.DummyMessageWrapper;
import com.dummy.service.DummyMessageLocalService;
import com.dummy.service.DummyMessageLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sky
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ServiceDummyTestPortletKeys.ServiceDummyTest,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ServiceDummyTestPortlet extends MVCPortlet {

	@Reference
	DummyMessageLocalService service;


	public void dummyMessageSubmit(ActionRequest request, ActionResponse response) throws PortalException {
		String text = ParamUtil.getString(request, "text");
		String tag = ParamUtil.getString(request, "tag");

		long incrementedID = CounterLocalServiceUtil.increment();
		DummyMessage dummyMessage = service.createDummyMessage(incrementedID);
		dummyMessage.setText(text);
		dummyMessage.setTag(tag);
		service.addDummyMessage(dummyMessage);
		DummyMessage dummyMessage1 = DummyMessageLocalServiceUtil.getDummyMessage(incrementedID);
		System.out.println("Some data from dummy messages ==> " + dummyMessage1.getText() + " #" + dummyMessage1.getTag());
//		List<DummyMessage> dummyMessages = DummyMessageLocalServiceUtil.getDummyMessages(-1, -1);
//		System.out.println("All data messages ==> " + dummyMessages.stream().map(DummyMessageModel::getText).collect(Collectors.toList()));
//		System.out.println(text+tag);
	}


}