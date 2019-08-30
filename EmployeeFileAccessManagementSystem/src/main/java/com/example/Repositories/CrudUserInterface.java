package com.example.Repositories;

import com.example.Bean.UserBean;

public interface CrudUserInterface {
	public abstract int updateaddress(UserBean user);

	public abstract int changepassword(UserBean user);
}
