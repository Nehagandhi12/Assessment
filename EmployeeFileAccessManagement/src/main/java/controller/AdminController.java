package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import bean.Leave;
import bean.User;
import constants.Constants;

@Controller
@RequestMapping(value = "login")
public class AdminController {
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduser(User user, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		rt.postForObject(Constants.url + "/admin/add", user, Integer.class);
		return "redirect:/admin.jsp";

	}

	@RequestMapping(value = "/deleteuser")
	public String deleteuser(User user) {
		RestTemplate rt = new RestTemplate();
		int id=user.getUserid();
		rt.delete(Constants.url + "/admin/delete/"+id);
		return "redirect:/admin.jsp";

	}

	@RequestMapping(value = "/displaylist")
	public String displaylist(HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<String> users = rt.getForObject(Constants.url + "/admin/display", List.class);
		request.getSession().setAttribute("listofusers", users);
		return "redirect:/DisplayUsers.jsp";

	}

	@RequestMapping(value = "/grantpermission")
	public String grantpermission(HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<String> users = rt.getForObject(Constants.url + "/admin/grantpermission", List.class);
		request.getSession().setAttribute("listofusers", users);
		return "redirect:/DisplayUsers.jsp";

	}

	@RequestMapping(value = "/applyleave")
	public String applyleave(Leave leave, HttpServletRequest request) {
		int adminid = (int) request.getSession().getAttribute("adminid");
		leave.setEmpid(adminid);
		RestTemplate rt = new RestTemplate();
		rt.put(Constants.url + "/admin/leave", leave, Integer.class);
		return "redirect:/admin.jsp";

	}

	@RequestMapping(value = "/checkstatusleave")
	public String checkstatusleave(HttpServletRequest request) {
		int adminid = (int) request.getSession().getAttribute("adminid");
		RestTemplate rt = new RestTemplate();
		String employees = rt.getForObject(Constants.url + "/admin/checkstatus/"+adminid, String.class);
		request.getSession().setAttribute("leavestatus", employees);
		return "redirect:/displayleavestatus.jsp";
	}
	
}
