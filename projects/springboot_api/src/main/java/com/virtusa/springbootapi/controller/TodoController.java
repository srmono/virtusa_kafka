package com.virtusa.springbootapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.springbootapi.model.TodoDTO;
import com.virtusa.springbootapi.repository.TodoRepository;
import com.virtusa.springbootapi.service.TodoService;


@RestController
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepo;
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public ResponseEntity<?> getAllTodos() { 
		List<TodoDTO> todos =  todoRepo.findAll();
		if (todos.size() > 0) {
			return new ResponseEntity<List<TodoDTO>>(todos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No todos available", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/todos")
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO todo) {
		try {
			
			todo.setCreatedAt(new Date(System.currentTimeMillis()));
			todoRepo.save(todo);
			return new ResponseEntity<TodoDTO>(todo, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/todos/{id}")
	public ResponseEntity<?> getSingletodo(@PathVariable("id") String id) {
		Optional<TodoDTO> todoOptional = todoRepo.findById(id);
		if(todoOptional.isPresent()) {
			return new ResponseEntity<>(todoOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Todo not Found with id: " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<?> updateById(
				@PathVariable("id") String id, 
				@RequestBody TodoDTO todo
			) {
		Optional<TodoDTO> todoOptional = todoRepo.findById(id);
		if(todoOptional.isPresent()) {
			TodoDTO todoToSave = todoOptional.get();
			todoToSave.setCompleted(
						todo.getCompleted() != null ?
								todo.getCompleted() : 
								todoToSave.getCompleted()
					);
			todoToSave.setTodo(
						todo.getTodo() != null ?
								todo.getTodo() :
								todoToSave.getTodo()
					);
			todoToSave.setDescription(
					todo.getDescription() != null ?
							todo.getDescription() :
							todoToSave.getDescription()
				);
			todoToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
			todoRepo.save(todoToSave);
			return new ResponseEntity<>(todoToSave, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Todo not Found with id: " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		try {
			todoRepo.deleteById(id);
			return new ResponseEntity<>("Successfully Delete: " + id, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}








