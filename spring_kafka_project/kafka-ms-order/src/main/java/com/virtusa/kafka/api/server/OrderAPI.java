package com.virtusa.kafka.api.server;


import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.kafka.api.request.OrderRequest;
import com.virtusa.kafka.api.response.OrderResponse;
import com.virtusa.kafka.command.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderAPI {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
		//1. save order using service
		var orderNumber = orderService.saveOrder(request);
		
		//2. create a response
		var orderResponse = new OrderResponse(orderNumber);
		
		//3. Return response
		return ResponseEntity.ok().body(orderResponse);
		
	}
}









