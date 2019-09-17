package restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.Admin;
import bean.Leave;
import bean.User;
import service.AdminService;
@RestController
@RequestMapping("admin")
public class AdminRestController {
	@Autowired
	AdminService admindao;

	@PostMapping("/add")
	public int adduser(@RequestBody User user) {
		int result = admindao.adduser(user);
		return result;
	}

	@DeleteMapping("/delete/{userid}")
	public int deleteuser(@PathVariable("userid") int userid) throws Exception {
		int result = admindao.deleteuser(userid);
		return result;
	}

	@GetMapping("/display")
	public List<String> displayuser() {
		List<String> result = admindao.displayuser();
		return result;
	}

	@GetMapping("/grantpermission")
	public List<String> grantpermission() {
		List<String> users = admindao.grantpermission();
		return users;
	}

	@PutMapping("/leave")
	public int applyleave(@RequestBody Leave leave) {
		int result = admindao.applyleave(leave);
		return result;
	}

	@GetMapping("/checkstatus/{id}")
	public String checkstatusleave(@PathVariable("id") int adminid) {
		Admin admin=new Admin();
		admin.setAdminid(adminid);
		String result = admindao.checkstatusleave(admin);
		return result;
	}
}
