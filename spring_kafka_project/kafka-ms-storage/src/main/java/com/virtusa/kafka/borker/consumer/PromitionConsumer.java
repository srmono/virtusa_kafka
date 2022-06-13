package com.virtusa.kafka.borker.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.virtusa.kafka.broker.message.DiscountMessage;
import com.virtusa.kafka.broker.message.PromotionMessage;

@Service
@KafkaListener(topics = "t-commodity-promotion")
public class PromitionConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(PromitionConsumer.class);
	
	@KafkaHandler
	public void listenPromotion(PromotionMessage message) {
		LOG.info("Processing Promotion: {}", message);
	}
	
	@KafkaHandler
	public void listenDiscount(DiscountMessage message) {
		LOG.info("Processing Discount: {}", message);
	}

}
