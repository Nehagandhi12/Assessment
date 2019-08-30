package com.example.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;
import com.example.Bean.UserBean;
import com.example.Bean.ValidateBean;
import com.example.Repositories.*;

//Dao Class For Admin
@Service
public class AdminDao {
	@Autowired
	private CrudUser crud1;
	@Autowired
	private Crud crud;
	@Autowired
	private CrudAdmin crud2;
	@Autowired
	private CrudManager crud3;

	// Admin can add new user
	public int adduser(UserBean user) {
		// TODO Auto-generated method stub
		user.setGrantedpermission(0);
		user.setFirsttimelogin(1);
		user.setStartdate(LocalDate.now().toString());
		user.setUserpassword("Hello@123");
		crud1.save(user);
		ValidateBean validate = new ValidateBean();

		validate.setId(user.getUserid());

		validate.setPassword(user.getUserpassword());
		validate.setRole("user");
		crud.save(validate);
		return 1;
	}

//Admin deletes user
	public int deleteuser(UserBean user) {
		// TODO Auto-generated method stub
		crud1.deleteById(user.getUserid());
		ValidateBean validate = new ValidateBean();
		validate.setId(user.getUserid());
		crud.deleteById(validate.getId());

		return 1;
	}

//Admin gets the list of usernames in sorted order
	public List<String> displayuser() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list = crud1.displayUsers();
		return list;
	}

//Admin grants update permission to users who have completed their 100 days
	public List<String> grantpermission() {
		List<Integer> userids = new ArrayList<>();
		userids = crud1.grantPermission();
		List<String> username = new ArrayList<>();
		for (Integer x : userids) {

			username.add(crud1.findById(x).get().getUsername());
		}
		return username;
	}

//Admin can apply leave
	public int applyleave(LeaveBean leave) {
		// TODO Auto-generated method stub
		leave.setStatus("Pending");
		Optional<AdminBean> list = crud2.findById(leave.getEmpid());
		crud2.applyleave(leave.getEmpid());
		leave.setManagerid(list.get().getReportingTo());
		crud3.save(leave);
		return 0;
	}

//Admin can check the status of leave applied
	public String checkstatusleave(AdminBean admin) {
		// TODO Auto-generated method stub
		int status = crud2.checkLeavestatus(admin.getAdminid());
		int result = crud3.checkapplied(admin.getAdminid());
		if (result == 1) {
			if (status == 1)
				return "Accepted";
			else {
				if (status == 2)
					return "Rejected";
			}
			return "Pending";
		} else
			return "Not Applied";
	}
}
