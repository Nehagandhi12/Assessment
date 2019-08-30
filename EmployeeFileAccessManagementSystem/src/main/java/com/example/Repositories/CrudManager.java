package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Bean.LeaveBean;

@Repository
public interface CrudManager extends JpaRepository<LeaveBean, Integer> {

	@Query("Select x from leavedetails x where x.managerid=:id  and x.status='Pending'")
	List<LeaveBean> grantLeave(@Param("id") int managerid);

	@Transactional
	@Modifying
	@Query("Update leavedetails l set l.status='Accepted' where l.leaveid=:id")
	int acceptleave(@Param("id") int id);

	@Transactional
	@Modifying
	@Query("Update leavedetails l set l.status='Rejected' where l.leaveid=:id")
	int rejectleave(@Param("id") int id);

	@Query(value = "SELECT EXISTS(SELECT * FROM leavedetails  WHERE empid = ?1 )", nativeQuery = true)
	int checkapplied(int adminid);
}
