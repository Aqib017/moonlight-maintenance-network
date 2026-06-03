package com.moonlight.mnt.controller;
import com.moonlight.mnt.dto.LoginRequest;
import com.moonlight.mnt.dto.LoginResponse;
import com.moonlight.mnt.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {

		if ("admin".equals(request.getUsername()) && "moonlight123".equals(request.getPassword())) {
			String token = jwtUtil.generateToken(request.getUsername());
			return new LoginResponse(token);
		}
		throw new RuntimeException("Invalid Credentials");
	}
}
