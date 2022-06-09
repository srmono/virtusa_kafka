package com.virtusa.kafka;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.virtusa.kafka.entity.Employee;
import com.virtusa.kafka.producer.EmployeeJsonProducer;
import com.virtusa.kafka.producer.HelloKafkaProducer;
import com.virtusa.kafka.producer.KafkaKeyProducer;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner  {
	
//	@Autowired
//	private HelloKafkaProducer producer;
	
//	@Autowired
//	private KafkaKeyProducer kafkaKeyProducer;
	
	@Autowired
	private EmployeeJsonProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//producer.sendHello("Virtusa " + ThreadLocalRandom.current().nextInt());
		
//		for( int i = 0; i < 10_000; i++ ) {
//			var key = "key - " + (i % 4);
//			var value = "value - " + i + " with key " + key;
//			kafkaKeyProducer.send(key, value);
//			TimeUnit.SECONDS.sleep(1);
//		}
		
		for( int i = 0; i < 5; i++) {
			var emp = new Employee("emp " + i, "Employee " + i, LocalDate.now());
			producer.sendMessage(emp);
		}
		
	}
	
}
