package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Validate;

@Repository

public interface RValidation extends JpaRepository<Validate, Integer> {
	@Modifying
	@Transactional
	@Query("UPDATE validate c SET c.password = :password WHERE c.id = :companyId ")
	int changePassword1(@Param("password") String password, @Param("companyId") int id);

}
