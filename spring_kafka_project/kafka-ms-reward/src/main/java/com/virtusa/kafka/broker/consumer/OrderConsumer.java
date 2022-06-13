package com.virtusa.kafka.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.virtusa.kafka.broker.message.OrderMessage;

@Service
public class OrderConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics = "t-commodity-order")
	public void listen(ConsumerRecord<String, OrderMessage> consumerRecord) {
		var headers = consumerRecord.headers();
		var orderMessage = consumerRecord.value();
		
		LOG.info(
				"Processing order {} , item {}, credit card number {}",
				orderMessage.getOrderNumber(),
				orderMessage.getItemName(),
				orderMessage.getCreditCardNumber()
				);
		LOG.info("Headers : ");
		headers.forEach(h -> LOG.info("key: {}, value: {}", h.key(), new String(h.value())));
		
		var bonusPrecentage = Integer.parseInt(new String(headers.lastHeader("surpriseBonus").value()));
		
		var bonusAmount = (bonusPrecentage / 100) * orderMessage.getPrice() * orderMessage.getQuantity();
		
		LOG.info("Bonus amount is : {}", bonusAmount);
	}
}
