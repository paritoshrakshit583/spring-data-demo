package com.demo.microservices.springdatademoservice.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.microservices.springdatademoservice.dto.User;
import com.demo.microservices.springdatademoservice.servcie.UserService;
import com.demo.microservices.springdatademoservice.servcie.UserServiceImpl;

@RestController
@RequestMapping("/user-management-api")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user/add")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		 userService.addUser(user);
		 log.info("User added");
		 URI path = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(path).build(); 
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		log.info("Getting all users from User table : ");
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable String id) {
		log.info("User details with the given id");
		return userService.getUserById(new Long(id));
	}
	
	@DeleteMapping("/user/delete/{id}")
	public String deleteUserById(@PathVariable String id) {
		userService.deleteUserById(new Long(id));
		log.info("User "+id+"deleted from database");
		return "User user_id: "+id+" deleted from database";
	}
	
	@PutMapping("/user/updatedHomeAddress/{id}/{newHomeAddress}")
	public String updateHomeAddress(@PathVariable long id, @PathVariable String newHomeAddress) {
		userService.updateHomeAddress(id, newHomeAddress);
		log.info("User updated");
		return "User with user_id: "+id+" is updated with new home_address";
	}
	
	@PutMapping("/user/updateGender/{id}/{newGender}")
	public String updateGender(@PathVariable long id, @PathVariable String newGender ) {
		userService.updateGender(id, newGender);
		log.info("Gender for user id updated in database");
		return "Gender for user_id: "+id+" is updated with new gender";
	}
	
	@GetMapping("/getAllUsersByGender/{gender}")
	public List<User> getAllUsersByGender(@PathVariable String gender){
		log.info("Fetching all users with given gender");
		return userService.getUsersByGender(gender);
	}
	
	@GetMapping("/getAllUsersByFirstName/{firstName}")
	public List<User> getAllUsersByFirstName(@PathVariable String firstName){
		log.info("Fetching all users with given first name");
		return userService.getUsersByFirstName(firstName);
	}
}
