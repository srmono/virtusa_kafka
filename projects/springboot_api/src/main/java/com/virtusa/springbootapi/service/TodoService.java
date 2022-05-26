package com.virtusa.springbootapi.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.virtusa.springbootapi.exception.TodoException;
import com.virtusa.springbootapi.model.TodoDTO;

public interface TodoService {
	public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoException;
	
	public List<TodoDTO> getAllTodos();
	
	public TodoDTO getSingleTodo(String id) throws TodoException;
	
	public void updateTodo(String id, TodoDTO todo) throws TodoException;
	
	public void deleteTodoById(String id) throws TodoException;
}
