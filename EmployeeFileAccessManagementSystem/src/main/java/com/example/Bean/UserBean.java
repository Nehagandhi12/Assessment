package com.example.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "user")
//Bean for user table
public class UserBean {
	@Id
	int userid;
	String username;
	String userpassword;
	String address;
	String startdate;
	int firsttimelogin;
	int grantedpermission;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public int getFirsttimelogin() {
		return firsttimelogin;
	}

	public void setFirsttimelogin(int firsttimelogin) {
		this.firsttimelogin = firsttimelogin;
	}

	public int getGrantedpermission() {
		return grantedpermission;
	}

	public void setGrantedpermission(int grantedpermission) {
		this.grantedpermission = grantedpermission;
	}
}
