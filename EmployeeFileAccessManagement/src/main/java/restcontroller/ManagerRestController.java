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

import bean.Leave;
import bean.User;
import service.ManagerService;

@RestController
@RequestMapping("apply")
public class ManagerRestController {
	@Autowired
	ManagerService managerdao;

	@PostMapping("/leave")
	public int applyleave(@RequestBody Leave leave) {
		int result = managerdao.applyleave(leave);
		return result;
	}

	@GetMapping("/grantleave/{managerid}")
	public List<Leave> grantleave(@PathVariable("managerid") int managerid) {
		List<Leave> employees = managerdao.grantleave(managerid);
		return employees;
	}

	@PutMapping("/acceptleave")
	public int acceptleave(@RequestBody Leave leave) {
		managerdao.acceptLeave(leave);
		return 1;
	}

	@PutMapping("/rejectleave")
	public int rejectleave(@RequestBody Leave leave) {
		managerdao.rejectLeave(leave);
		return 0;
	}

	@GetMapping("/checkstatusleave/{managerid}")
	public String checkstatusleave(@PathVariable("managerid") int managerid) {
		String result = managerdao.checkstatusleave(managerid);
		return result;
	}

	@PostMapping("/add")
	public int adduser(@RequestBody User user) {
		int result = managerdao.adduser(user);
		return result;
	}

	@DeleteMapping("/delete/{userid}")
	public int deleteuser(@PathVariable("userid") int id) {
		int result = managerdao.deleteuser(id);
		return result;
	}

	@GetMapping("/display")
	public List<String> displayuser() {
		List<String> result = managerdao.displayuser();
		return result;
	}

	@GetMapping("/grantpermission")
	public List<String> grantpermission() {
		List<String> users = managerdao.grantpermission();
		return users;
	}
}
