package com.belkacem.todolistbackend.service;

import java.util.List;

import com.belkacem.todolistbackend.entities.Todo;

public interface TodoService {

	List<Todo> getAllTodos();

	Todo saveTodo(Todo todo);

	Todo getOneTodo(long id);

	Todo findByTitle(String title);

	void deleteTodo(long id);

	List<Todo> getDoneTODOs();
	
	List<Todo> getTodoTODOs();

}
