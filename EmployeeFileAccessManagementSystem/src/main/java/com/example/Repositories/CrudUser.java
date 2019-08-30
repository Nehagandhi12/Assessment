package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Bean.UserBean;

@Repository
public interface CrudUser extends JpaRepository<UserBean, Integer> {
	@Modifying
	@Transactional
	@Query("UPDATE user c SET c.address = :address WHERE c.userid = :companyId and c.firsttimelogin=0 and c.grantedpermission=1")
	int updateAddress(@Param("companyId") int userid, @Param("address") String address);

	@Modifying
	@Transactional
	@Query("UPDATE user c SET c.userpassword = :password WHERE c.userid = :companyId ")
	int changePassword(@Param("companyId") int userid, @Param("password") String userpassword);

	@Query("Select u.username from user u order by u.username")
	List<String> displayUsers();

	@Query(" SELECT u.userid from user u where DATEDIFF(CURDATE(),u.startdate)>=100 and u.grantedpermission=0")
	List<Integer> grantPermission();

	@Modifying
	@Transactional
	@Query(" UPDATE user u SET u.grantedpermission=1 WHERE u.userid=:userid")
	int updatePermission(@Param("userid") int userid);

	@Modifying
	@Transactional
	@Query(" UPDATE user u SET u.firsttimelogin=0 WHERE u.userid=:userid")
	int updatefirsttimelogin(@Param("userid") int userid);
}
