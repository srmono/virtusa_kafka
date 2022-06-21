package com.virtusa.kafka.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.kafka.api.request.CustomerPurchaseMobileRequest;
import com.virtusa.kafka.api.request.CustomerPurchaseWebRequest;
import com.virtusa.kafka.command.action.CustomerPurchaseAction;

@Service
public class CustomerPurchaseService {
	
	@Autowired
	private CustomerPurchaseAction action;
	
	public String createPurchaseMobile(CustomerPurchaseMobileRequest request) {
		return action.publishMobileToKafka(request);
	}
	
	public String createPurchaseWeb(CustomerPurchaseWebRequest request) {
		return action.publishWebToKafka(request);
	}
	

}
