package com.example.AllControllers;

/*If the person logged in is manager,the manager functionalities page(manager.jsp) 
 * redirects to ManagerController to perform required function*/
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;
import com.example.Bean.UserBean;

@Controller
@RequestMapping("managerlogin")
//Controller for admin functionalities

public class ManagerController {
	// Calls ManagerRestController function where manager can apply leave
	@Autowired
	Environment environment;

	@RequestMapping(value = "/applyleave")
	public String applyleave(LeaveBean leave, HttpServletRequest request) {
		int adminid = (int) request.getSession().getAttribute("managerid");
		String port = environment.getProperty("local.server.port");
		leave.setEmpid(adminid);
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:" + port + "/apply/leave", leave, Integer.class);
		return "redirect:/manager.jsp";

	}

	// Calls ManagerRestController function where manager can grant leave
	@RequestMapping(value = "/grantleave")
	public ModelAndView grantleave(HttpServletRequest request, LeaveBean leave) {
		int managerid = (int) request.getSession().getAttribute("managerid");
		String port = environment.getProperty("local.server.port");
		leave.setManagerid(managerid);
		RestTemplate rest = new RestTemplate();
		HttpEntity<LeaveBean> requestEntity = new HttpEntity<>(leave);
		String location = "http://localhost:" + port + "/apply/grantleave";
		ResponseEntity<List<LeaveBean>> x = rest.exchange(location, HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<LeaveBean>>() {
				});
		List<LeaveBean> list = x.getBody();
		ModelAndView mv = new ModelAndView("grantleave");
		mv.addObject("object", list);
		return mv;

	}

	// Calls ManagerRestController function where manager can accept leave
	@RequestMapping(value = "/acceptleave")
	public String acceptleave(@RequestParam("status") String result, @RequestParam("id") int id,
			HttpServletRequest request) {
		LeaveBean leave = new LeaveBean();
		int empid = (int) request.getSession().getAttribute("managerid");
		leave.setLeaveid(id);
		leave.setManagerid(empid);
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		rt.postForObject("http://localhost:" + port + "/apply/acceptleave", leave, Integer.class);
		return "redirect:/managerlogin/grantleave";
	}

	// Calls ManagerRestController function where manager can reject leave
	@RequestMapping(value = "/rejectleave")
	public String rejectleave(@RequestParam("status") String result, @RequestParam("id") int id,
			HttpServletRequest request) {
		LeaveBean leave = new LeaveBean();
		String port = environment.getProperty("local.server.port");
		int empid = (int) request.getSession().getAttribute("managerid");
		leave.setManagerid(empid);
		leave.setLeaveid(id);
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:" + port + "/apply/rejectleave", leave, Integer.class);
		return "redirect:/managerlogin/grantleave";
	}

	// Calls MangerRestController function where manager can check the status of
	// leave
	@RequestMapping(value = "/checkstatusleave")
	public String checkstatusleave(HttpServletRequest request) {
		AdminBean admin = new AdminBean();
		int managerid = (int) request.getSession().getAttribute("managerid");
		admin.setAdminid(managerid);
		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();
		String employees = rt.postForObject("http://localhost:" + port + "/apply/checkstatusleave", admin,
				String.class);
		request.getSession().setAttribute("status", employees);
		return "redirect:/displaystatusleave.jsp";
	}

	// Calls MangerRestController function to add new user
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduser(UserBean user, HttpServletRequest request) {
		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:" + port + "/apply/add", user, Integer.class);
		return "redirect:/manager.jsp";

	}

	// Calls MangerRestController function to delete user
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public String deleteuser(UserBean user) {
		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:" + port + "/apply/delete", user, Integer.class);
		return "redirect:/manager.jsp";

	}

	// Calls MangerRestController function to display list of usernames in sorted
	// order
	@RequestMapping(value = "/displaylist")
	public String displaylist(HttpServletRequest request) {
		String port = environment.getProperty("local.server.port");
		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<String> users = rt.getForObject("http://localhost:" + port + "/apply/display", List.class);
		request.getSession().setAttribute("managerlistofusers", users);
		return "redirect:/DisplayUsers1.jsp";

	}

//Calls ManagerRestController Function to grant update permission to users who have completed their 100 days after being added by admin
	@RequestMapping(value = "/grantpermission")
	public String grantpermission(HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		String port = environment.getProperty("local.server.port");
		@SuppressWarnings("unchecked")
		List<String> users = rt.getForObject("http://localhost:" + port + "/apply/grantpermission", List.class);
		request.getSession().setAttribute("managerlistofusers", users);
		return "redirect:/DisplayUsers1.jsp";

	}
}
