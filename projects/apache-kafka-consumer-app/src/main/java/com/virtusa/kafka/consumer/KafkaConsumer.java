package com.virtusa.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "OrderTopic", groupId = "group_id")
	public void consumer(String message) {
		System.out.println("Message = " + message);
	}
}
