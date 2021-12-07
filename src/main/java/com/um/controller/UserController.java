package com.um.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.um.model.User;
import com.um.service.UserService;

@RestController()
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public String welcome() {
		return "Welcome to UserManagement API";

	}

	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);

	}

	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<User> addAllUsers(@RequestBody List<User> users) {
		users.forEach(System.out::println);
		return userService.addAllUsers(users);
	}

	@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findUserById(@PathVariable("userId") Long userId) {
		return userService.findUserById(userId);

	}

	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return userService.getAllUserr();
	}

	@PutMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return updatedUser;
	}

	@DeleteMapping(value = "/user/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		return userService.deleteUser(userId);

	}

}
