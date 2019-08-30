package com.example.Bean;

//Bean class for admin table
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "admin")
@Table(name = "admin")
public class AdminBean {

	@Id
	int adminid;
	String adminname;
	String password;
	int reporting_to;
	int leavestatus;

	public int getLeavestatus() {
		return leavestatus;
	}

	public void setLeavestatus(int leavestatus) {
		this.leavestatus = leavestatus;
	}

	public int getReportingTo() {
		return reporting_to;
	}

	public void setReportingTo(int reportingTo) {
		reporting_to = reportingTo;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
