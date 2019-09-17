package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Admin;
import bean.Leave;
import bean.User;
import bean.Validate;
import repository.RAdmin;
import repository.RManager;
import repository.RUser;
import repository.RValidation;

@Service
public class ManagerService {
	@Autowired
	private RManager crud;
	@Autowired
	private RAdmin crud1;
	@Autowired
	private RUser crud2;
	@Autowired
	private RValidation crud3;

	public int adduser(User user) {
		// TODO Auto-generated method stub
		user.setGrantedpermission(0);
		user.setFirsttimelogin(1);
		user.setStartdate(LocalDate.now().toString());
		user.setUserpassword("Hello@123");
		crud2.save(user);
		Validate validate = new Validate();
		validate.setId(user.getUserid());
		validate.setPassword(user.getUserpassword());
		validate.setRole("user");
		crud3.save(validate);
		return 1;
	}

	public int deleteuser(int userid) {
		// TODO Auto-generated method stub
		crud2.deleteById(userid);
		Validate validate = new Validate();
		validate.setId(userid);
		crud3.deleteById(validate.getId());
        return 1;
	}

	public List<String> displayuser() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list = crud2.displayUsers();
		return list;
	}

	public List<String> grantpermission() {
		List<Integer> userids = new ArrayList<>();
		userids = crud2.grantPermission();
		List<String> username = new ArrayList<>();
		for (Integer x : userids) {

			username.add(crud2.findById(x).get().getUsername());
		}
		return username;
	}

	public int applyleave(Leave leave) {
		// TODO Auto-generated method stub
		leave.setStatus("Pending");
		Optional<Admin> list = crud1.findById(leave.getEmpid());
		crud1.applyleave(leave.getEmpid());
		leave.setManagerid(list.get().getReportingTo());
		crud.save(leave);
		return 0;
	}

	public List<Leave> grantleave(int managerid) {
		List<Leave> employees = crud.grantLeave(managerid);
		// TODO Auto-generated method stub
		return employees;
	}

	public int acceptLeave(Leave leave) {
		// TODO Auto-generated method stub
		int result = crud.acceptleave(leave.getLeaveid());
		System.out.println(leave.getLeaveid());
		Optional<Leave> list = crud.findById(leave.getLeaveid());
		crud1.acceptleave(list.get().getEmpid());
		return result;
	}

	public int rejectLeave(Leave leave) {
		// TODO Auto-generated method stub
		int result = crud.rejectleave(leave.getLeaveid());
		Optional<Leave> list = crud.findById(leave.getLeaveid());
		crud1.rejectleave(list.get().getEmpid());
		return result;
	}

	public String checkstatusleave(int  adminid) {
		// TODO Auto-generated method stub
		int status = crud1.checkLeavestatus(adminid);
		int result = crud.checkapplied(adminid);
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
