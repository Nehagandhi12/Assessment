package com.example.AllControllers;

/* This Controller validates the logged in person(user or admin or manager) by calling ValidateRestController functions and
 *  redirects accordingly*/

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.Bean.ValidateBean;

@Controller
@RequestMapping(value = "login")
//Controller For Validating
public class ValidateController {

	@Autowired
	Environment environment;
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	// Calls ValidateRestController function to validate logged in person
	
	public String showLoginPage(ValidateBean role, ModelMap map, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		String role1 = rt.postForObject("http://localhost:"+port+"/valid/request", role, String.class);
		if (role1.equals("user")) {
			request.getSession().setAttribute("userid", role.getId());
			return "redirect:/user.jsp";
		}
		if (role1.equals("admin")) {
			request.getSession().setAttribute("adminid", role.getId());
			return "redirect:/admin.jsp";
		}
		if (role1.equals("manager")) {
			request.getSession().setAttribute("managerid", role.getId());
			return "redirect:/manager.jsp";
		}
		request.getSession().setAttribute("errormsg", "Sorry!! you have entered a worng id or password");
		return "redirect:/index.jsp";
	}
}
