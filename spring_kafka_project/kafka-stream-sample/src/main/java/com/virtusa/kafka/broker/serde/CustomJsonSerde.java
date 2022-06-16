package com.virtusa.kafka.broker.serde;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class CustomJsonSerde<T> implements Serde<T> {

	private CustomJsonSerializer<T> serializer;
	private CustomJsonDeserializer<T> deserializer;

	public CustomJsonSerializer<T> getSerializer() {
		return serializer;
	}

	public void setSerializer(CustomJsonSerializer<T> serializer) {
		this.serializer = serializer;
	}

	public CustomJsonDeserializer<T> getDeserializer() {
		return deserializer;
	}

	public CustomJsonSerde() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomJsonSerde(CustomJsonSerializer<T> serializer, CustomJsonDeserializer<T> deserializer) {
		super();
		this.serializer = serializer;
		this.deserializer = deserializer;
	}

	public void setDeserializer(CustomJsonDeserializer<T> deserializer) {
		this.deserializer = deserializer;
	}

	@Override
	public Serializer<T> serializer() {
		
		return serializer;
	}

	@Override
	public Deserializer<T> deserializer() {
		
		return deserializer;
	}

}
