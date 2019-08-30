package com.example.AllControllers;

//ManagerController calls ManagerRestController to perform various manager functionalities
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;
import com.example.Bean.UserBean;
import com.example.Business.ManagerBusiness;

@RestController
@RequestMapping("apply")
//RestController for Manager Functionalities
public class ManagerRestController {
	@Autowired
	ManagerBusiness manager;

	@RequestMapping("/leave")
	// Calls ManagerBusiness function where manager can apply leave
	public int applyleave(@RequestBody LeaveBean leave) {
		int result= manager.applyleave(leave);
		return result;
	}

	// Calls ManagerBusiness function where manager can grant leave
	@RequestMapping("/grantleave")
	public List<LeaveBean> grantleave(@RequestBody LeaveBean leave) {
		List<LeaveBean> employees = manager.grantleave(leave);
		return employees;
	}

	// Calls ManagerBusiness function where manager can accept leave
	@RequestMapping("/acceptleave")
	public int acceptleave(@RequestBody LeaveBean leave) {
		manager.acceptleave(leave);
		return 1;
	}

	// Calls ManagerBusiness function where manager can reject leave
	@RequestMapping("/rejectleave")
	public int rejectleave(@RequestBody LeaveBean leave) {
		manager.rejectleave(leave);
		return 0;
	}

	// Calls ManagerBusiness function where manager can check status of leave
	@RequestMapping("/checkstatusleave")
	public String checkstatusleave(@RequestBody AdminBean admin) {
		String result = manager.checkstatusleave(admin);
		return result;
	}

	@RequestMapping("/add")
	// Calls ManagerBusiness Function to add new user
	public int adduser(@RequestBody UserBean user) {
		int result = manager.adduser(user);
		return result;
	}

	// Calls ManagerBusiness Function to delete user
	@RequestMapping("/delete")
	public int deleteuser(@RequestBody UserBean user) {
		int result = manager.deleteuser(user);
		return result;
	}

	// Calls ManagerBusiness Function to display list of users in sorted order
	@RequestMapping("/display")
	public List<String> displayuser() {
		List<String> result = manager.displayuser();
		return result;
	}

	// Calls ManagerBusiness Function to grant update permission to users who have
	// completed
	// their 100 days after being added by admin
	@RequestMapping("/grantpermission")
	public List<String> grantpermission() {
		List<String> users = manager.grantpermission();
		return users;
	}
}
