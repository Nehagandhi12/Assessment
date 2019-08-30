package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Bean.ValidateBean;

@Repository

public interface Crud extends JpaRepository<ValidateBean, Integer> {
	@Modifying
	@Transactional
	@Query("UPDATE validate c SET c.password = :password WHERE c.id = :companyId ")
	int changePassword1(@Param("password") String password, @Param("companyId") int id);

}
