package com.virtusa.kafka.broker.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.virtusa.kafka.broker.message.OrderMessage;

@Service
public class OrderProducer {

	private static final Logger LOG = LoggerFactory.getLogger(OrderProducer.class);

	@Autowired
	private KafkaTemplate<String, OrderMessage> kafkaTemplate;

	public void publish(OrderMessage message) {

		kafkaTemplate.send("t-commodity-order", message.getCreditCardNumber(), message)
				.addCallback(new ListenableFutureCallback<SendResult<String, OrderMessage>>() {

					@Override
					public void onSuccess(SendResult<String, OrderMessage> result) {
						LOG.info("Order {}, item {} published succesfully", message.getOrderNumber(),
								message.getItemName());
					}

					@Override
					public void onFailure(Throwable ex) {
						LOG.warn("Order {}, item {} failed to publish because {}", message.getOrderNumber(),
								message.getItemName(), ex.getMessage());
					}
				});

		LOG.info("Just a dummy message for order {}, item {}", message.getOrderNumber(), message.getItemName());
		//LOG.info("Just a dummy message for order {}, item {}", message.getOrderNumber(), message.getItemName());
	}
}
