package com.virtusa.kafka.broker.stream.promotion;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

import com.virtusa.kafka.broker.message.PromotionMessage;
import com.virtusa.kafka.broker.serde.PromotionSerde;

@Configuration
public class PromotionUppercaseCustomJsonStream {
	
	@Bean
	public KStream<String, PromotionMessage> kStreamPromotionUppercase(StreamsBuilder builder){
		var stringSerde = Serdes.String();
		var jsonSerde = new PromotionSerde();
		var sourceStream = builder.stream("t-commodity-promotion", Consumed.with(stringSerde, jsonSerde));
		
		var uppercaseStream = sourceStream.mapValues(this::uppercasePromotionCode);
		
		uppercaseStream.to("t-commodity-promotion-uppercase", Produced.with(stringSerde, jsonSerde));
		
		sourceStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("Custom JSON serde Original Stream"));
		uppercaseStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("Custom Json serde Original Stream"));
		
		return sourceStream;
	}
	
	public PromotionMessage uppercasePromotionCode(PromotionMessage message) {
		return new PromotionMessage(message.getPromotionCode().toUpperCase());
	}

}





