package com.virtusa.kafka.borker.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.virtusa.kafka.broker.message.PromotionMessage;

@Service
public class PromotionUppercaseListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(PromotionUppercaseListener.class);
	
	@KafkaListener(topics = "t-commodity-promotion-uppercase")
	public void listenPromotionUpperCase(PromotionMessage message) {
		LOG.info("Processing uppercase promotion: {}", message);
	}

}
