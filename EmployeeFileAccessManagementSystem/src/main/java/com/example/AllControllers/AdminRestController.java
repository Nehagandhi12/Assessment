package com.example.AllControllers;

//AdminController calls AdminRestController to perform various admin functionalities
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;
import com.example.Bean.UserBean;
import com.example.Business.AdminBusiness;

@RestController
@RequestMapping("admin")
//RestController for Admin Functionalities
public class AdminRestController {
	@Autowired
	AdminBusiness adminbusiness;

	@RequestMapping("/add")
	// Calls AdminBusiness Function to add new user
	public int adduser(@RequestBody UserBean user) {
		int result = adminbusiness.adduser(user);
		return result;
	}

	// Calls AdminBusiness Function to delete user
	@RequestMapping("/delete")
	public int deleteuser(@RequestBody UserBean user) {
		int result = adminbusiness.deleteuser(user);
		return result;
	}

	// Calls AdminBusiness Function to display usernames in sorted order
	@RequestMapping("/display")
	public List<String> displayuser() {
		List<String> result = adminbusiness.displayuser();
		return result;
	}

	// Calls AdminBusiness Function to grant update permission to users who have completed
	// their 100 days after being added be admin
	@RequestMapping("/grantpermission")
	public List<String> grantpermission() {
		List<String> users = adminbusiness.grantpermission();
		return users;
	}

	// Calls AdminBusiness function where admin can apply leave
	@RequestMapping("/leave")
	public int applyleave(@RequestBody LeaveBean leave) {
		int result = adminbusiness.applyleave(leave);
		return result;
	}

	// Calls AdminBusiness function where admin can check status of leave
	@RequestMapping("/checkstatusleave")
	public String checkstatusleave(@RequestBody AdminBean admin) {
		String result = adminbusiness.checkstatusleave(admin);
		return result;
	}
}
