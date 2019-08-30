package com.example.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Bean class for leavedetails table
@Entity(name = "leavedetails")
@Table(name = "leavedetails")
public class LeaveBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int leaveid;
	String reason;
	String status;
	int numberofdays;
	String startdate;
	int empid;
	int managerid;

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public int getNumberofdays() {
		return numberofdays;
	}

	public void setNumberofdays(int numberofdays) {
		this.numberofdays = numberofdays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LeaveBean [leaveid=" + leaveid + ", reason=" + reason + ", status=" + status + ", numberofdays="
				+ numberofdays + ", startdate=" + startdate + ", empid=" + empid + "]";
	}

}
