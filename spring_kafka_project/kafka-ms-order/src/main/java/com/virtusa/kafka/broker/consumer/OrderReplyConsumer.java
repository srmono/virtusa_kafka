package com.virtusa.kafka.broker.consumer;

import org.slf4j.LoggerFactory;

import com.virtusa.kafka.broker.message.OrderReplyMessage;

import org.slf4j.Logger;

public class OrderReplyConsumer {
	
	public static final Logger LOG = LoggerFactory.getLogger(OrderReplyConsumer.class);
	
	public void listen(OrderReplyMessage message) {
		LOG.info("Reply message recieved : {}", message);
	}
	
}
