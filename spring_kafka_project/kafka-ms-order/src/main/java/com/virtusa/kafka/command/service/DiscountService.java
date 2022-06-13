package com.virtusa.kafka.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.kafka.api.request.DiscountRequest;
import com.virtusa.kafka.command.action.DiscountAction;

@Service
public class DiscountService {
	
	@Autowired
	private DiscountAction action;

	public void createDiscount(DiscountRequest request) {
		action.publishToKafa(request);
	}
}
