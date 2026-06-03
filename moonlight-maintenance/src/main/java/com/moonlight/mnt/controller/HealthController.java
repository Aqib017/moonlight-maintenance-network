package com.moonlight.mnt.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthController {
	
	@GetMapping("/health")
	public String healthCheck() {
		return "Moonlight Apartment Maintenance App Running Successfully!";
	}
	

}
