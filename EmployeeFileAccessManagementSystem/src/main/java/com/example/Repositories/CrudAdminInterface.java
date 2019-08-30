package com.example.Repositories;

import java.util.List;

import com.example.Bean.UserBean;

public interface CrudAdminInterface {
	public abstract int adduser(UserBean user);

	public abstract int deleteuser(UserBean user);

	public abstract List<String> displayuser();

	public abstract List<String> grantpermission();
}
