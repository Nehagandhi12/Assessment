package com.example.AllControllers;

/*If the person logged in is admin,the admin functionalities page(admin.jsp)
 *  redirects to AdminController to perform required function*/
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;
import com.example.Bean.UserBean;

@Controller
@RequestMapping(value = "login")
//Controller for admin functionalities
public class AdminController {
//Calls AdminRestController Function to add new user
	@Autowired
	Environment environment;

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduser(UserBean user, HttpServletRequest request) {
		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:" + port + "/admin/add", user, Integer.class);
		return "redirect:/admin.jsp";

	}

//Calls AdminRestController Function to delete  user
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public String deleteuser(UserBean user) {
		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:" + port + "/admin/delete", user, Integer.class);
		return "redirect:/admin.jsp";

	}

//Calls AdminRestController Function to display usernames in sorted order
	@RequestMapping(value = "/displaylist")
	public String displaylist(HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		List<String> users = rt.getForObject("http://localhost:" + port + "/admin/display", List.class);
		request.getSession().setAttribute("listofusers", users);
		return "redirect:/DisplayUsers.jsp";

	}

//Calls AdminRestController Function to grant update permission to users who have completed their 100 days after being added by admin
	@RequestMapping(value = "/grantpermission")
	public String grantpermission(HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		@SuppressWarnings("unchecked")
		List<String> users = rt.getForObject("http://localhost:" + port + "/admin/grantpermission", List.class);
		request.getSession().setAttribute("listofusers", users);
		return "redirect:/DisplayUsers.jsp";

	}

//Calls AdminRestController function where admin can apply leave
	@RequestMapping(value = "/applyleave")
	public String applyleave(LeaveBean leave, HttpServletRequest request) {
		int adminid = (int) request.getSession().getAttribute("adminid");
		leave.setEmpid(adminid);
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		rt.postForObject("http://localhost:" + port + "/admin/leave", leave, Integer.class);
		return "redirect:/admin.jsp";

	}

	// Calls AdminRestController function where admin can check status of leave
	@RequestMapping(value = "/checkstatusleave")
	public String checkstatusleave(HttpServletRequest request) {
		AdminBean admin = new AdminBean();
		int adminid = (int) request.getSession().getAttribute("adminid");
		admin.setAdminid(adminid);
		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();
		String employees = rt.postForObject("http://localhost:" + port + "/admin/checkstatusleave", admin,
				String.class);
		request.getSession().setAttribute("leavestatus", employees);
		return "redirect:/displayleavestatus.jsp";
	}
}
