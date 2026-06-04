package com.moonlight.mnt.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.dto.LoginRequest;
import com.moonlight.mnt.dto.LoginResponse;
import com.moonlight.mnt.entity.User;
import com.moonlight.mnt.repository.UserRepository;
import com.moonlight.mnt.security.JwtUtil;
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {

		Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

		if (userOpt.isPresent() && passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
			String token = jwtUtil.generateToken(request.getUsername());
			return new LoginResponse(token);
		}
		throw new RuntimeException("Invalid Credentials");
	}
}
