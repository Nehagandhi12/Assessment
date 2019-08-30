package com.example.AllControllers;

//UserController calls UserRestController to perform various user functionalities
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bean.UserBean;
import com.example.Business.UserBusiness;

@RestController
@RequestMapping("update")
//RestController for User Functionalities
public class UserRestController {
	@Autowired
	UserBusiness userbusiness;

	@RequestMapping("/request")
	// Calls UserBusiness Function to change address
	public int changeaddress(@RequestBody UserBean user) {
		int result = userbusiness.updateaddress(user);
		return result;
	}

	// Calls UserBusiness Function to change password
	@RequestMapping("/request1")
	public int changepassword(@RequestBody UserBean user) {
		int result = userbusiness.changepassword(user);
		return result;
	}
}
