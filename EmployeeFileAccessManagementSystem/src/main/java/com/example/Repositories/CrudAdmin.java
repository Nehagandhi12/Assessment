package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Bean.AdminBean;

@Repository
public interface CrudAdmin extends JpaRepository<AdminBean, Integer> {
	@Query(value = "SELECT EXISTS(SELECT * FROM admin  WHERE reporting_to = ?1)", nativeQuery = true)
	int validateperson(int adminid);

	@Modifying
	@Transactional
	@Query(value = "Update admin a set a.leavestatus=0 where a.adminid=:id")
	int applyleave(@Param("id") int adminid);

	@Modifying
	@Transactional
	@Query(value = "Update admin a set a.leavestatus=1 where a.adminid=:id")
	int acceptleave(@Param("id") int adminid);

	@Modifying
	@Transactional
	@Query(value = "Update admin a set a.leavestatus=2 where a.adminid=:id")
	int rejectleave(@Param("id") int adminid);

	@Query("Select a.leavestatus from admin a where a.adminid=:id ")
	int checkLeavestatus(@Param("id") int adminid);
}
