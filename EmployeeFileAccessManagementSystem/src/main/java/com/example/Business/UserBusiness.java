package com.example.Business;

//Business Class For User
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bean.UserBean;
import com.example.Dao.UserDao;

@Service
public class UserBusiness {
	@Autowired
	UserDao userdao;

	// Calls UserDao Function where user can update address after getting permission
	// from admin or manager
	public int updateaddress(UserBean user) {
		int result = userdao.updateaddress(user);
		return result;

	}

//Calls UserDao Function where user can change password
	// User has to update password if he has logged in for the first time
	public int changepassword(UserBean user) {
		int result = userdao.changepassword(user);
		return result;

	}
}
