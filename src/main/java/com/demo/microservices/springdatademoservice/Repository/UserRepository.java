package com.demo.microservices.springdatademoservice.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.microservices.springdatademoservice.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Transactional
	@Modifying
	@Query(value="update User set home_address=?2 where id=?1", nativeQuery = true)
	void updateHomeAddress(long id, String homeAddress);
	
	@Transactional
	@Modifying
	@Query(value = "update User set gender=?2 where id=?1",nativeQuery = true)
	void updateGender(long id, String gender);
	
	@Query(value = "select * from User where gender=:gender", nativeQuery = true)
	List<User> getUsersByGender(@Param("gender")String gender);
	
	@Query(value = "select * from User where first_name=?1", nativeQuery = true)
	List<User> getUsersByFirstName(String firstName);
	
	
	
}
