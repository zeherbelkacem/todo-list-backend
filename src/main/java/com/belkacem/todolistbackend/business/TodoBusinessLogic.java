package com.belkacem.todolistbackend.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.belkacem.todolistbackend.entities.Todo;
import com.belkacem.todolistbackend.service.TodoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TodoBusinessLogic {
	
	private final TodoService todoService;
	
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

}
