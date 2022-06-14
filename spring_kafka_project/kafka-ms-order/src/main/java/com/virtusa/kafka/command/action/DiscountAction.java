package com.virtusa.kafka.command.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtusa.kafka.api.request.DiscountRequest;
import com.virtusa.kafka.broker.message.DiscountMessage;
import com.virtusa.kafka.broker.producer.DiscountProducer;

@Component
public class DiscountAction {
	
	@Autowired
	private DiscountProducer producer;
	
	public void publishToKafa(DiscountRequest request) {
		var message = new DiscountMessage(
					request.getDiscountCode(),
					request.getDiscountPercentage()
				);
		producer.publish(message);
	}

}
