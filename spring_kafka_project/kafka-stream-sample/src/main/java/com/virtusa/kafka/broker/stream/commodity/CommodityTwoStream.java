package com.virtusa.kafka.broker.stream.commodity;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

import com.virtusa.kafka.broker.message.OrderMessage;
import com.virtusa.kafka.broker.message.OrderPatternMessage;
import com.virtusa.kafka.broker.message.OrderRewardMessage;
import com.virtusa.kafka.util.CommodityStreamUtil;

//@Configuration
public class CommodityTwoStream {

	@Bean
	public KStream<String, OrderMessage> kstreamCommodityTrading(StreamsBuilder builder) {
		var stringSerde = Serdes.String();
		var orderSerde = new JsonSerde<>(OrderMessage.class);
		var orderPatternSerde = new JsonSerde<>(OrderPatternMessage.class);
		var orderRewardSerde = new JsonSerde<>(OrderRewardMessage.class);
		
		var maskedCreditCardStream = builder
										.stream("t-commodity-order", Consumed.with(stringSerde, orderSerde))
										.mapValues(CommodityStreamUtil::maskCreditCard);
		
		var patternStreams = maskedCreditCardStream
									.mapValues(CommodityStreamUtil::mapToOrderPattern)
									.branch(CommodityStreamUtil.isPlastic(), (k, v) -> true);
		
		var plasticIndex = 0;
		var nonPlasticIndex = 1;
									
		//plastic
		patternStreams[plasticIndex]
				.to("t-commodity-pattern-two-plastic", Produced.with(stringSerde, orderPatternSerde));
		//non plastic
		patternStreams[nonPlasticIndex]
				.to("t-commodity-pattern-two-nonplastic", Produced.with(stringSerde, orderPatternSerde));
		
		var rewardStream = maskedCreditCardStream
									.filter(CommodityStreamUtil.isLargeQuantity())
									.filter(CommodityStreamUtil.isCheap())
									.mapValues(CommodityStreamUtil::mapToOrderReward);
		
		rewardStream.to("t-commodity-reward-two", Produced.with(stringSerde, orderRewardSerde));
		
		//maskedCreditCardStream.to("t-commodity-storage-two",  Produced.with(stringSerde, orderSerde));
		
		var storageStream = maskedCreditCardStream
				.selectKey(CommodityStreamUtil.generateStoragekey());
		
		storageStream.to("t-commodity-storage-two", Produced.with(stringSerde, orderSerde));
		return maskedCreditCardStream;
	}
}





