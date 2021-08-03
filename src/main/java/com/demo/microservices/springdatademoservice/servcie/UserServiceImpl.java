package com.demo.microservices.springdatademoservice.servcie;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.microservices.springdatademoservice.Repository.UserRepository;
import com.demo.microservices.springdatademoservice.dto.User;

@Service
public class UserServiceImpl implements UserService{
 
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
		log.info("User adde to database : "+user);
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();
		log.info("Getting all users : "+userList);
		return userList;		
	}

	@Override
	public User getUserById(Long id) {
		User user = userRepository.findById(id).get();
		log.info("Getting user details : "+user);
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		log.info("User deleted from database : id - "+id);
		
	}

	@Override
	public void updateHomeAddress(long id, String homeAddress) {
		userRepository.updateHomeAddress(id, homeAddress);
		log.info("User is updated in database");
		
	}

	@Override
	public void updateGender(long id, String gender) {
		userRepository.updateGender(id, gender);
		log.info("Gender for user with user id: "+id+"id updated");
		
	}

	@Override
	public List<User> getUsersByGender(String gender) {
		List<User> userList = userRepository.getUsersByGender(gender);
		log.info("Getting all users by gender : "+gender+"/n"+userList);
		return userList;
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		List<User> userList = userRepository.getUsersByFirstName(firstName);
		log.info("Getting all users by nirst name givem : "+firstName+"/n"+userList);
		return userList;
	}

	

	
	
}
