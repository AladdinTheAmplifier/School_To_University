package com.s2u.admissionregistry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

	@GetMapping("/v1/healthCheck")
	public String healthCheck() {
		return "Admission Registry Service is Up";
		
	}
	
}
