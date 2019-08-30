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
import com.example.Repositories.Crud;
import com.example.Repositories.CrudAdmin;
import com.example.Repositories.CrudManager;
import com.example.Repositories.CrudManagerInterface;
import com.example.Repositories.CrudUser;

//Dao For Manager
@Service
public class ManagerDao implements CrudManagerInterface {
	@Autowired
	private CrudManager crud;
	@Autowired
	private CrudAdmin crud1;
	@Autowired
	private CrudUser crud2;
	@Autowired
	private Crud crud3;

	// Manager can add user
	public int adduser(UserBean user) {
		// TODO Auto-generated method stub
		user.setGrantedpermission(0);
		user.setFirsttimelogin(1);
		user.setStartdate(LocalDate.now().toString());
		user.setUserpassword("Hello@123");
		crud2.save(user);
		ValidateBean validate = new ValidateBean();

		validate.setId(user.getUserid());

		validate.setPassword(user.getUserpassword());
		validate.setRole("user");
		crud3.save(validate);
		return 1;
	}

	// Manager can delete user
	public int deleteuser(UserBean user) {
		// TODO Auto-generated method stub
		crud2.deleteById(user.getUserid());
		ValidateBean validate = new ValidateBean();
		validate.setId(user.getUserid());
		crud3.deleteById(validate.getId());

		return 1;
	}

	// Manager to display usernames in sorted order
	public List<String> displayuser() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list = crud2.displayUsers();
		return list;
	}

//Manager grants update permission to users
	public List<String> grantpermission() {
		List<Integer> userids = new ArrayList<>();
		userids = crud2.grantPermission();
		List<String> username = new ArrayList<>();
		for (Integer x : userids) {

			username.add(crud2.findById(x).get().getUsername());
		}
		return username;
	}

	@Override
	// Manager can apply leave
	public int applyleave(LeaveBean leave) {
		// TODO Auto-generated method stub
		leave.setStatus("Pending");
		Optional<AdminBean> list = crud1.findById(leave.getEmpid());
		crud1.applyleave(leave.getEmpid());
		leave.setManagerid(list.get().getReportingTo());
		crud.save(leave);
		return 0;
	}

	// Manager gets a list of admins or managers under him who have applied leave
	@Override
	public List<LeaveBean> grantleave(LeaveBean leave) {
		List<LeaveBean> employees = crud.grantLeave(leave.getManagerid());
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	// Manager accepts leave
	public int acceptLeave(LeaveBean leave) {
		// TODO Auto-generated method stub
		int result = crud.acceptleave(leave.getLeaveid());
		System.out.println(leave.getLeaveid());
		Optional<LeaveBean> list = crud.findById(leave.getLeaveid());
		crud1.acceptleave(list.get().getEmpid());
		return result;
	}

	@Override
	// Manager rejects leave
	public int rejectLeave(LeaveBean leave) {
		// TODO Auto-generated method stub
		int result = crud.rejectleave(leave.getLeaveid());
		Optional<LeaveBean> list = crud.findById(leave.getLeaveid());
		crud1.rejectleave(list.get().getEmpid());
		return result;
	}

	@Override
	// Manager checks the status of leave
	public String checkstatusleave(AdminBean admin) {
		// TODO Auto-generated method stub
		int status = crud1.checkLeavestatus(admin.getAdminid());
		int result = crud.checkapplied(admin.getAdminid());
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
