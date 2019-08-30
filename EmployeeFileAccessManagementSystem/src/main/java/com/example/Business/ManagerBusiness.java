package com.example.Business;

//Business Class For Admin
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;
import com.example.Bean.UserBean;
import com.example.Dao.ManagerDao;

@Service
public class ManagerBusiness {
	@Autowired
	ManagerDao managerdao;

	// Calls ManagerDao Function where manager can apply leave
	public int applyleave(LeaveBean leave) {
		int result= managerdao.applyleave(leave);
		return result;

	}

//Calls ManagerDao Function where manager can delete user
	public int deleteuser(UserBean user) {
		int result = managerdao.deleteuser(user);
		return result;

	}

//Calls ManagerDao Function where manager gets list of admins or managers who have applied for leave
	public List<LeaveBean> grantleave(LeaveBean leave) {
		List<LeaveBean> employees = managerdao.grantleave(leave);
		return employees;

	}

//Calls ManagerDao Function where manager accepts leave
	public int acceptleave(LeaveBean leave) {
		int result = managerdao.acceptLeave(leave);
		return result;

	}

//Calls ManagerDao Function where manager rejects leave
	public int rejectleave(LeaveBean leave) {
		int i = managerdao.rejectLeave(leave);
		return i;

	}

//Calls ManagerDao Function where manager gets a list of users
	public List<String> displayuser() {
		List<String> users = managerdao.displayuser();
		return users;
	}

//Calls ManagerDao Function where manager grants update permission to users 
	public List<String> grantpermission() {
		// TODO Auto-generated method stub
		List<String> users = managerdao.grantpermission();
		return users;
	}

//Calls ManagerDao Function where manager checks leave status
	public String checkstatusleave(AdminBean admin) {
		String status = managerdao.checkstatusleave(admin);
		return status;

	}

//Calls ManagerDao Function where manager adds new user
	public int adduser(UserBean user) {
		int result = managerdao.adduser(user);
		return result;

	}
}
