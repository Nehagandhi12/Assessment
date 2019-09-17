package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.User;
import repository.RUser;
import repository.RValidation;

@Service
public class UserService {
	@Autowired
	private RUser crud1;
	@Autowired
	private RValidation crud;

	public int updateaddress(User user) {
		// TODO Auto-generated method stub
		int result = crud1.updateAddress(user.getUserid(), user.getAddress());
		return result;
	}

	public int changepassword(User user) {
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
