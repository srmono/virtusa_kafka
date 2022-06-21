package com.virtusa.kafka.command.action;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtusa.kafka.api.request.CustomerPurchaseMobileRequest;
import com.virtusa.kafka.api.request.CustomerPurchaseWebRequest;
import com.virtusa.kafka.broker.message.CustomerPurchaseMobileMessage;
import com.virtusa.kafka.broker.message.CustomerPurchaseWebMessage;
import com.virtusa.kafka.broker.producer.CustomerPurchaseProducer;

@Component
public class CustomerPurchaseAction {
	
	@Autowired
	private CustomerPurchaseProducer producer;

	public String publishMobileToKafka(CustomerPurchaseMobileRequest request) {
		var purchaseNUmber = "CP-MOBILE - " + RandomStringUtils.randomAlphanumeric(6).toUpperCase();
		var location = new CustomerPurchaseMobileMessage.Location(
				request.getLocation().getLatitude(),
				request.getLocation().getLongitude()
				);
		var message = new CustomerPurchaseMobileMessage(
					purchaseNUmber,
					request.getPurchaseAmount(),
					request.getMobileAppVersion(),
					request.getOperationSystem(),
					location
				);
		
		producer.publishPurchaseMobile(message);
		
		return purchaseNUmber;
	}

	public String publishWebToKafka(CustomerPurchaseWebRequest request) {
		var purchaseNUmber = "CP-WEB - " + RandomStringUtils.randomAlphanumeric(6).toUpperCase();
		
		var message = new CustomerPurchaseWebMessage(
					purchaseNUmber,
					request.getPurchaseAmount(),
					request.getBrowser(),
					request.getOperationSystem()
				);
		producer.publishPurchaseWeb(message);
		return purchaseNUmber;
	}

}
