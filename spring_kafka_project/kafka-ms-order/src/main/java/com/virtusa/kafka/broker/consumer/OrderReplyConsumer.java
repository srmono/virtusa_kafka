package com.virtusa.kafka.broker.consumer;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.virtusa.kafka.broker.message.OrderReplyMessage;

import org.slf4j.Logger;

@Service
public class OrderReplyConsumer {
	
	public static final Logger LOG = LoggerFactory.getLogger(OrderReplyConsumer.class);
	
	@KafkaListener(topics = "t-commodity-order-reply")
	public void listen(OrderReplyMessage message) {
		LOG.info("Reply message recieved : {}", message);
	}
	
}
