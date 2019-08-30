package com.example.Repositories;

import java.util.List;

import com.example.Bean.AdminBean;
import com.example.Bean.LeaveBean;

public interface CrudManagerInterface {
	public abstract int applyleave(LeaveBean leave);

	public abstract List<LeaveBean> grantleave(LeaveBean leave);

	public abstract int acceptLeave(LeaveBean leave);

	public abstract int rejectLeave(LeaveBean leave);

	public abstract String checkstatusleave(AdminBean admin);
}
