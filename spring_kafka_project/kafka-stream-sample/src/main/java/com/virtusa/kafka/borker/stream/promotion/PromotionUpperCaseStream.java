package com.virtusa.kafka.borker.stream.promotion;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PromotionUpperCaseStream {

	@Bean
	public KStream<String, String> kstreamPromotionUpperCase(StreamsBuilder builder){
		var sourceStream = builder.stream("t-commodity-promotion", Consumed.with(Serdes.String(), Serdes.String()));
		
		var uppercaseStream =  sourceStream.mapValues(s -> s.toUpperCase());
		
		uppercaseStream.to("t-commodity-promotion-uppercase");
		
		sourceStream.print(Printed.<String, String>toSysOut().withLabel("original stream: "));
		uppercaseStream.print(Printed.<String, String>toSysOut().withLabel("uppercase stream: "));
		
		return sourceStream;
	}
	
}
