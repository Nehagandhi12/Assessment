package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import bean.Leave;
import bean.User;
import constants.Constants;

@Controller
@RequestMapping("managerlogin")

public class ManagerController {

	@RequestMapping(value = "/applyleave")
	public String applyleave(Leave leave, HttpServletRequest request) {
		int adminid = (int) request.getSession().getAttribute("managerid");
		leave.setEmpid(adminid);
		RestTemplate rt = new RestTemplate();
		rt.postForObject(Constants.url + "/apply/leave", leave, Integer.class);
		return "redirect:/manager.jsp";

	}

	@RequestMapping(value = "/grantleave")
	public ModelAndView grantleave(HttpServletRequest request, Leave leave) {
		int managerid = (int) request.getSession().getAttribute("managerid");
		RestTemplate rest = new RestTemplate();
		HttpEntity<Leave> requestEntity = new HttpEntity<>(leave);
		String location = Constants.url + "/apply/grantleave/"+managerid;
		ResponseEntity<List<Leave>> x = rest.exchange(location, HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<List<Leave>>() {
				});
		List<Leave> list = x.getBody();
		ModelAndView mv = new ModelAndView("grantleave");
		mv.addObject("object", list);
		return mv;

	}

	@RequestMapping(value = "/acceptleave")
	public String acceptleave(@RequestParam("status") String result, @RequestParam("id") int id,
			HttpServletRequest request) {
		Leave leave = new Leave();
		int empid = (int) request.getSession().getAttribute("managerid");
		leave.setLeaveid(id);
		leave.setManagerid(empid);
		RestTemplate rt = new RestTemplate();
		rt.put(Constants.url + "/apply/acceptleave", leave, Integer.class);
		return "redirect:/managerlogin/grantleave";
	}

	@RequestMapping(value = "/rejectleave")
	public String rejectleave(@RequestParam("status") String result, @RequestParam("id") int id,
			HttpServletRequest request) {
		Leave leave = new Leave();
		int empid = (int) request.getSession().getAttribute("managerid");
		leave.setManagerid(empid);
		leave.setLeaveid(id);
		RestTemplate rt = new RestTemplate();
		rt.put(Constants.url + "/apply/rejectleave", leave, Integer.class);
		return "redirect:/managerlogin/grantleave";
	}

	@RequestMapping(value = "/checkstatusleave")
	public String checkstatusleave(HttpServletRequest request) {
		int managerid = (int) request.getSession().getAttribute("managerid");
		RestTemplate rt = new RestTemplate();
		String employees = rt.getForObject(Constants.url + "/apply/checkstatusleave/"+managerid, String.class);
		request.getSession().setAttribute("status", employees);
		return "redirect:/displaystatusleave.jsp";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduser(User user, HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		rt.postForObject(Constants.url + "/apply/add", user, Integer.class);
		return "redirect:/manager.jsp";

	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public String deleteuser(User user) {
		RestTemplate rt = new RestTemplate();
		rt.delete(Constants.url + "/apply/delete/"+user.getUserid(),Integer.class);
		return "redirect:/manager.jsp";

	}

	@RequestMapping(value = "/displaylist")
	public String displaylist(HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<String> users = rt.getForObject(Constants.url + "/apply/display", List.class);
		request.getSession().setAttribute("managerlistofusers", users);
		return "redirect:/DisplayUsers1.jsp";

	}

	@RequestMapping(value = "/grantpermission")
	public String grantpermission(HttpServletRequest request) {
		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<String> users = rt.getForObject(Constants.url + "/apply/grantpermission", List.class);
		request.getSession().setAttribute("managerlistofusers", users);
		return "redirect:/DisplayUsers1.jsp";

	}
}
