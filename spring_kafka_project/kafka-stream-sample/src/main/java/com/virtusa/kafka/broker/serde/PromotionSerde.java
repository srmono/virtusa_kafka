package com.virtusa.kafka.broker.serde;

import com.virtusa.kafka.broker.message.PromotionMessage;

public class PromotionSerde extends CustomJsonSerde<PromotionMessage> {
	
	public PromotionSerde() {
		super(
				new CustomJsonSerializer<PromotionMessage>(),
				new CustomJsonDeserializer<PromotionMessage>(PromotionMessage.class)
			);
		
		
	}

}
