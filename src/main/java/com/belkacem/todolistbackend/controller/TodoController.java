package com.belkacem.todolistbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belkacem.todolistbackend.business.TodoBusinessLogic;
import com.belkacem.todolistbackend.entities.Todo;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/todo/v1")
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoBusinessLogic todoBusinessLogic;
	
	@GetMapping("/todos")
	public List<Todo> getAllTodos(){
		return todoBusinessLogic.getAllTodos();
	}
	

}
