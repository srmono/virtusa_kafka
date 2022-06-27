package com.virtusa.kafka.broker.stream.customer.preference;

import org.apache.kafka.streams.kstream.Aggregator;

import com.virtusa.kafka.broker.message.CustomerPreferenceAggregateMessage;
import com.virtusa.kafka.broker.message.CustomerPreferenceShoppingCartMessage;

public class CustomerPreferenceShoppingCartAggregator 
		implements Aggregator<String, CustomerPreferenceShoppingCartMessage, CustomerPreferenceAggregateMessage> {

	@Override
	public CustomerPreferenceAggregateMessage apply(
			String key, CustomerPreferenceShoppingCartMessage value,
			CustomerPreferenceAggregateMessage aggregate
			) {
		aggregate.putShoppingCartItem(value.getItemName(), value.getCartDatetime());
		return aggregate;
	}
	
	

}
