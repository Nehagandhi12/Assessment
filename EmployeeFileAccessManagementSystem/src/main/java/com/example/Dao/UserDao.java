package com.example.Dao;

//Dao For User
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bean.UserBean;
import com.example.Repositories.Crud;
import com.example.Repositories.CrudUser;
import com.example.Repositories.CrudUserInterface;

@Service
public class UserDao implements CrudUserInterface {
	@Autowired
	private CrudUser crud1;
	@Autowired
	private Crud crud;

	@Override
	/* User can update address if he gets update permission */
	public int updateaddress(UserBean user) {
		// TODO Auto-generated method stub
		int result = crud1.updateAddress(user.getUserid(), user.getAddress());
		return result;
	}

	/*
	 * User can change password according to the regular expression and it is
	 * compulsory for the users who have logged in for the first time
	 */
	public int changepassword(UserBean user) {
		// TODO Auto-generated method stu

		if (user.getUserpassword().matches("((?=[A-Za-z])(?=.*\\d)(?=.*\\W)(?=.*[a-zA-Z])).{8,}")) {
			crud1.changePassword(user.getUserid(), user.getUserpassword());

			crud.changePassword1(user.getUserpassword(), user.getUserid());
			crud1.updatefirsttimelogin(user.getUserid());
			return 1;
		}
		return 0;
	}
}
