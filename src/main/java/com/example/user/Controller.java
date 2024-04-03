package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller
 */
@RestController
public class Controller {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			return "Username already exists";
		}

		userRepository.save(user);
		return "User registered successfully";
	}

	@PostMapping("/login")
	public String userLogin(@RequestBody User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());

		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			return "Successful logging in";
		} else {
			return "Invalid username or password";
		}
	}

	public static class User {

		private String id;
		private String username;
		private String password;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
