package com.virtusa.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
	
//	@Autowired
//	KafkaTemplate<String, String> kakfaTemplate;
	
	@Autowired
	KafkaTemplate<String, Order> kakfaTemplate;

	private static final String TOPIC = "OrderTopic";
	
//	@GetMapping("/publish/{message}")
//	public String publishOrderInfo(@PathVariable("message") final String message) {
//		
//		kakfaTemplate.send(TOPIC, message);
//		return "Published Successfully";
//	}
	
	@PostMapping("/publish")
	public String publishOrderInfo(@RequestBody Order order) {
		kakfaTemplate.send(TOPIC, order);
		return "Published Successfully";
	}
	
	
}
