package com.demo.microservices.springdatademoservice.servcie;

import java.util.List;

import com.demo.microservices.springdatademoservice.dto.User;

public interface UserService {

	void addUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(Long id);
	
	void deleteUserById(Long id);
	
	void updateHomeAddress(long id, String homeAddress);
	
	void updateGender(long id, String gender);
	
	List<User> getUsersByGender(String gender);
	
	List<User> getUsersByFirstName(String firstName);
}
