package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import bean.Admin;
import bean.Leave;
import bean.User;
import bean.Validate;
import repository.*;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
@Service
public class AdminService {
	@Autowired
	private RUser crud1;
	@Autowired
	private RValidation crud;
	@Autowired
	private RAdmin crud2;
	@Autowired
	private RManager crud3;

	public int adduser(User user) {
		// TODO Auto-generated method stub
		user.setGrantedpermission(0);
		user.setFirsttimelogin(1);
		user.setStartdate(LocalDate.now().toString());
		user.setUserpassword("Hello@123");
		crud1.save(user);
		Validate validate = new Validate();

		validate.setId(user.getUserid());

		validate.setPassword(user.getUserpassword());
		validate.setRole("user");
		crud.save(validate);
		return 1;
	}

	public int deleteuser(int userid) throws Exception {
		// TODO Auto-generated method stub
		boolean exist=crud1.existsById(userid);
		crud1.deleteById(userid);
		Validate validate = new Validate();
		validate.setId(userid);
		crud.deleteById(validate.getId());
		return 1;
	}
	
	public List<String> displayuser() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list = crud1.displayUsers();
		return list;
	}

	public List<String> grantpermission() {
		List<Integer> userids = new ArrayList<>();
		userids = crud1.grantPermission();
		List<String> username = new ArrayList<>();
		for (Integer x : userids) {

			username.add(crud1.findById(x).get().getUsername());
		}
		return username;
	}

	public int applyleave(Leave leave) {
		// TODO Auto-generated method stub
		leave.setStatus("Pending");
		Optional<Admin> list = crud2.findById(leave.getEmpid());
		crud2.applyleave(leave.getEmpid());
		leave.setManagerid(list.get().getReportingTo());
		crud3.save(leave);
		return 0;
	}

	public String checkstatusleave(Admin admin) {
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
