package com.example.Business;

//Business Class For Admin
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;
import com.example.Bean.UserBean;
import com.example.Dao.AdminDao;

@Service
public class AdminBusiness {
	@Autowired
	AdminDao admindao;

//Calls AdminDao Function to add user
	public int adduser(UserBean user) {
		int result = admindao.adduser(user);
		return result;

	}

//Calls AdminDao Function to delete user
	public int deleteuser(UserBean user) {
		int result = admindao.deleteuser(user);
		return result;

	}

//Calls AdminDao Function to display list of usernames
	public List<String> displayuser() {
		List<String> users = admindao.displayuser();
		return users;
	}

//Calls AdminDao Function to grant permission to users 
	public List<String> grantpermission() {
		// TODO Auto-generated method stub
		List<String> users = admindao.grantpermission();
		return users;
	}

	// Calls AdminDao Function where admin can apply leave
	public int applyleave(LeaveBean leave) {
		int result= admindao.applyleave(leave);
		return result;

	}

	// Calls AdminDao Function where admin can check leave status
	public String checkstatusleave(AdminBean admin) {
		String status = admindao.checkstatusleave(admin);
		return status;

	}
}
