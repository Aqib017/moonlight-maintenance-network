package com.moonlight.mnt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.dto.ResidentSummaryResponse;
import com.moonlight.mnt.service.ResidentService;
@RestController
public class ResidentController {
	
	@Autowired
	private ResidentService residentService;

	@GetMapping("/resident/{flatNumber}")
	public ResidentSummaryResponse getResidentSummary(@PathVariable String flatNumber) {
		return residentService.getResidentSummary(flatNumber);
	}

}
