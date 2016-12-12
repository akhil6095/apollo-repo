package org.ion.springjpa.controller;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.ion.springjpa.domain.User;
import org.ion.springjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller
public class UserWebController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getAllUser() {
		ModelAndView mav = new ModelAndView("users");
		mav.addObject("users", userService.getAll());
		return mav;
	}

	@RequestMapping(value = "/stream", method = RequestMethod.GET)
	public void getUserStream(HttpServletResponse response) throws Exception {

		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", "user.csv");
		response.setHeader(headerKey, headerValue);

		String[] header = { "firstName", "lastName", "age" };

		try (Stream<User> userStream = userService.getUserStream();
				ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
						CsvPreference.STANDARD_PREFERENCE);) {
			userStream.forEach(user -> {
				try {
					csvWriter.write(user, header);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

}
