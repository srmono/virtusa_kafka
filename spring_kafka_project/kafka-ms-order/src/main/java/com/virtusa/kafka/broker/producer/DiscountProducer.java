package com.virtusa.kafka.broker.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.virtusa.kafka.broker.message.DiscountMessage;

public class DiscountProducer {

	@Autowired
	private KafkaTemplate<String, DiscountMessage> kafkaTemplate;
	
	public void publish(DiscountMessage message) {
		
		kafkaTemplate.send("t-commodity-promotion", message);
		
	}

}
