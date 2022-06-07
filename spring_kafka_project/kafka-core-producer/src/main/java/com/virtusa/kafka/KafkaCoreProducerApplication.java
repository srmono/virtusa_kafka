package com.virtusa.kafka;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtusa.kafka.producer.HelloKafkaProducer;

@SpringBootApplication
public class KafkaCoreProducerApplication implements CommandLineRunner  {
	
	@Autowired
	private HelloKafkaProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendHello("Virtusa " + ThreadLocalRandom.current().nextInt());
	}
	
}
