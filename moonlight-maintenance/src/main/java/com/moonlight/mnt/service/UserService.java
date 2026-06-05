package com.moonlight.mnt.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.dto.UserRequest;
import com.moonlight.mnt.dto.UserResponse;
import com.moonlight.mnt.entity.User;
import com.moonlight.mnt.repository.UserRepository;
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	public UserResponse createUser(UserRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		User savedUser = userRepository.save(user);
		return new UserResponse(savedUser.getId(), savedUser.getUsername());
	}
	public List<UserResponse> getAllUsers() {
		return userRepository.findAll().stream()
										.map(user ->new UserResponse(user.getId(), user.getUsername()))
										.collect(Collectors.toList());
	}
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		if ("admin".equalsIgnoreCase(user.getUsername())) {
			throw new RuntimeException("Admin user cannot be deleted");
		}
		userRepository.delete(user);
	}
}
