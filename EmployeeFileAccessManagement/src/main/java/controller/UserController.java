package controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import bean.User;
import constants.Constants;

@Controller
@RequestMapping("login")
public class UserController {
	@RequestMapping(value = "/changeaddress")
	public String changeAddress(User user, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		int userid = (int) request.getSession().getAttribute("userid");
		user.setUserid(userid);
		rt.put(Constants.url + "/update/address", user, Integer.class);
		int role=rt.getForObject(Constants.url + "/update/getaddressresult", Integer.class);
		if (role == 0) {
			return "redirect:/alert.jsp";
		}

		return "redirect:/user.jsp";
	}

	@RequestMapping(value = "/changepassword")
	public String changePassword(User user, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		int userid = (int) request.getSession().getAttribute("userid");
		user.setUserid(userid);
		rt.put(Constants.url + "/update/password", user, Integer.class);
		int role=rt.getForObject(Constants.url + "/update/getpasswordresult", Integer.class);
		if (role == 0) {
			return "redirect:/PasswordFail.jsp";
		}
		return "redirect:/user.jsp";
	}
}
