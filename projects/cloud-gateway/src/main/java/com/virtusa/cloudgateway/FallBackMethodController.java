package com.virtusa.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public Class FallBackMethodController{
	
	@GetMapping("/empServiceFallback")
	public String empServiceFallBackMethod() {
		return "Employee Service is taking longer than expected. Please try again later";
	}
	
	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallBackMethod() {
		return "Department Service is taking longer than expected. Please try again later";
	}
	
} 