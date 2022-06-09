package com.virtusa.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.kafka.entity.Employee;

@Service
public class EmployeeJsonProducer {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(Employee employee) throws JsonProcessingException {
		var empJson = objectMapper.writeValueAsString(employee);
		kafkaTemplate.send("t-employee", empJson);
	}
}




