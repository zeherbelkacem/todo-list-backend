package com.belkacem.todolistbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belkacem.todolistbackend.business.TodoBusinessLogic;
import com.belkacem.todolistbackend.entities.Todo;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo/v1")
@RequiredArgsConstructor
public class TodoController {

	private final TodoBusinessLogic todoBusinessLogic;

	@GetMapping("/")
	public List<Todo> getAllTodos() {
		return todoBusinessLogic.getAllTodos();
	}

	@PostMapping("/")
	public Todo saveTodo(@RequestBody Todo todo) {
		return todoBusinessLogic.saveTodo(todo);
	}

	@GetMapping("/{id}")
	public Todo getOneTodo(@PathVariable("id") long id) {
		return todoBusinessLogic.getOneTodo(id);
	}

	@PutMapping("/{id}")
	public void updateTodo(@PathVariable("id") long id, @RequestBody Todo todo) {
		todoBusinessLogic.update(todo);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") long id) {
		todoBusinessLogic.deleteTodo(id);
	}

	@GetMapping("/dones")
	public List<Todo> getDoneTODO() {
		return todoBusinessLogic.getDoneTODOs();
	}

	@GetMapping("/todos")
	public List<Todo> getTodoTODO() {
		return todoBusinessLogic.getTodoTODOs();
	}
}
