package com.virtusa.kafka.consumer;

import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class KafkaKeyConsumer {
	
	private static final Logger LOG =LoggerFactory.getLogger(KafkaKeyConsumer.class);
	
	@KafkaListener(topics = "t-multi-partitions", concurrency = "4")
	public void consume(ConsumerRecord<String, String> consumerRecord) throws InterruptedException {
		LOG.info(
				"key: {}, Partition: {}, Message: {}", 
				consumerRecord.key(),
				consumerRecord.partition(),
				consumerRecord.value()
				);
		TimeUnit.SECONDS.sleep(1);
	}

}
