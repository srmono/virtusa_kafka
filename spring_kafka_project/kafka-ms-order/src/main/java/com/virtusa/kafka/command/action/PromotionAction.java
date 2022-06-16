package com.virtusa.kafka.command.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtusa.kafka.api.request.PromotionRequest;
import com.virtusa.kafka.broker.message.PromotionMessage;
import com.virtusa.kafka.broker.producer.PromotionProducer;

@Component
public class PromotionAction {

	@Autowired
	private PromotionProducer producer;
	
	public void publishToKafka(PromotionRequest request) {
		var message = new PromotionMessage(request.getPromotionCode());
		
		producer.publish(message);
	}

}
