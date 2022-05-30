package com.virtusa.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.emp.VO.ResponseTemplateVO;
import com.virtusa.emp.entity.Employee;
import com.virtusa.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService emService;
	
	@PostMapping("/")
	public Employee saveEmp(@RequestBody Employee emp) {
		log.info("Inside Save Employee from Employee Controller");
		return emService.saveEmp(emp);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getEmpWithDepartment(@PathVariable("id") Long empId) {
		log.info("Inside get Employee with department from Employee Controller");
		return emService.getEmpWithDepartment(empId);
	}
	
	

}
