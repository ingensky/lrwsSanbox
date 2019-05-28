package com.dummy.portlet;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.dummy.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * @author sky
 */
@Controller
@RequestMapping("VIEW")
public class SpringMvcPortletViewController {

	@Autowired
	MessageRepo messageRepo;

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		System.out.println(messageRepo.count());
		messageRepo.findAll().forEach(dummyMessage -> System.out.println(dummyMessage.getText()));
		return "view";
	}
}