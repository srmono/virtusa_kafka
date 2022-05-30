package com.virtusa.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.emp.VO.Department;
import com.virtusa.emp.VO.ResponseTemplateVO;
import com.virtusa.emp.entity.Employee;
import com.virtusa.emp.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Employee saveEmp(Employee emp) {
		log.info("save employee from employee service");
		return emRepository.save(emp);
	}

	public ResponseTemplateVO getEmpWithDepartment(Long empId) {
		
		log.info("Inside get getEmpWithDepartment from employee service");
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		Employee employee =  emRepository.findByEmpId(empId);
		
		Department department = 
				restTemplate.getForObject(
						"http://localhost:8081/departments/"+ employee.getDepartmentId(), 
						Department.class
						);
	
		return null;
	}

}
