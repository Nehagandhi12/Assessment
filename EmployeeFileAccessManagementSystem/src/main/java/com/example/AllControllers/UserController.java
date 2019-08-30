package com.example.AllControllers;

/*If the person logged in is user,the user functionalities page(user.jsp)
 *  redirects to UserController to perform required function*/
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.Bean.UserBean;

@Controller
@RequestMapping("login")
//Controller for user functionalities
public class UserController {
	// Calls UserRestController Function to change address of user based on certain
	// conditions
	@Autowired
	Environment environment;

	@RequestMapping(value = "/changeaddress")
	public String changeAddress(UserBean user, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		int userid = (int) request.getSession().getAttribute("userid");
		user.setUserid(userid);
		String port = environment.getProperty("local.server.port");
		int role1 = rt.postForObject("http://localhost:" + port + "/update/request", user, Integer.class);
		if (role1 == 0) {
			return "redirect:/alert.jsp";
		}
		if (role1 == 1) {
			return "redirect:/user.jsp";
		}
		return "error";
	}

	// Calls UserRestController Function to change password
	@RequestMapping(value = "/changepassword")
	public String changePassword(UserBean user, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		int userid = (int) request.getSession().getAttribute("userid");
		user.setUserid(userid);
		String port = environment.getProperty("local.server.port");
		int role1 = rt.postForObject("http://localhost:" + port + "/update/request1", user, Integer.class);
		if (role1 == 0) {
			return "redirect:/PasswordFail.jsp";
		}
		if (role1 == 1) {
			return "redirect:/user.jsp";
		}
		return "error";
	}
}
