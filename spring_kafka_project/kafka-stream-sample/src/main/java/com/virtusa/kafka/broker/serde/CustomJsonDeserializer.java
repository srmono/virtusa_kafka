package com.virtusa.kafka.broker.serde;

import java.io.IOException;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomJsonDeserializer<T> implements Deserializer<T> {
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private Class<T> deserializedClass;
	
	public CustomJsonDeserializer(Class<T> deserializedClass) {
		this.deserializedClass = deserializedClass;
	}

	@Override
	public T deserialize(String topic, byte[] data) {
		try {
			return objectMapper.readValue(data, deserializedClass);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			throw new SerializationException(e.getMessage());
		}
		
	}

}
