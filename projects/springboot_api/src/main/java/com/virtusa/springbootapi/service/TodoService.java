package com.virtusa.springbootapi.service;

import javax.validation.ConstraintViolationException;

import com.virtusa.springbootapi.exception.TodoException;
import com.virtusa.springbootapi.model.TodoDTO;

public interface TodoService {
	public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoException;
}
