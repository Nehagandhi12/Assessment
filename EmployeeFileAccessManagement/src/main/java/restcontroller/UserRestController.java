package restcontroller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.User;
import service.UserService;

@RestController
@RequestMapping("update")
public class UserRestController {
	@Autowired
	UserService userdao;
    static int addressresult;
    static int passwordresult;
	@PutMapping("/address")
	public void changeaddress(@RequestBody User user,HttpServletRequest request) {
		 addressresult = userdao.updateaddress(user);
	}
	@GetMapping("/getaddressresult")
	public int getaddressresult() {
		return addressresult;
	}
	@GetMapping("/getpasswordresult")
	public int getpasswordresult() {
		return passwordresult;
	}
	@PutMapping("/password")
	public void changepassword(@RequestBody User user,HttpServletRequest request) {
		passwordresult = userdao.changepassword(user);
	}
}
