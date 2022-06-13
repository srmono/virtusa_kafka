package com.virtusa.kafka.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.kafka.api.request.OrderRequest;
import com.virtusa.kafka.command.action.OrderAction;

@Service
public class OrderService {
	
	@Autowired
	private OrderAction orderAction;

	public String saveOrder(OrderRequest request) {
		var order = orderAction.convertToOrder(request);
		orderAction.saveToDatabase(order);
		
		//Flatten message & publish
		order.getItems().forEach(orderAction::publishToKafka);
		
		return order.getOrderNumber();
	}

}
