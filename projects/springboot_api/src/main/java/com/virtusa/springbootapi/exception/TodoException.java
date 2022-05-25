package com.virtusa.springbootapi.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class TodoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TodoException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Todo with " + id + "not found";
	}
	
	public static String TodoAlreadyExists() {
		return "Todo with given name already exists";
	}
	
}






