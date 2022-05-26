package com.virtusa.springbootapi.service;

import java.sql.Date;
import java.util.Optional;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.springbootapi.exception.TodoException;
import com.virtusa.springbootapi.model.TodoDTO;
import com.virtusa.springbootapi.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepo;

	@Override
	public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoException {		
		Optional<TodoDTO> todoOptional = todoRepo.findByTodo(todo.getTodo());
		if(todoOptional.isPresent()) {
			throw new TodoException(TodoException.TodoAlreadyExists());
		}else {
			todo.setCreatedAt(new Date(System.currentTimeMillis()));
			todoRepo.save(todo);
		}
	}
}





