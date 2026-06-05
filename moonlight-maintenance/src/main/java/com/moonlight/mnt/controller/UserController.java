package com.moonlight.mnt.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moonlight.mnt.dto.UserRequest;
import com.moonlight.mnt.dto.UserResponse;
import com.moonlight.mnt.service.UserService;
@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest request) {
		return userService.createUser(request);
	}
	@GetMapping
	public List<UserResponse> getAllUsers() {
		return userService.getAllUsers();
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
