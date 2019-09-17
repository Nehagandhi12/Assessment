package controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import bean.Validate;
import constants.Constants;

@Controller
@RequestMapping(value = "login")
public class ValidateController {
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String showLoginPage(Validate role, ModelMap map, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		int id=role.getId();
		String password=role.getPassword();
		String role1 = rt.getForObject(Constants.url + "/valid/request/"+id+"/"+password, String.class);
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
