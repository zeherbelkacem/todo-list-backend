package com.belkacem.todolistbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belkacem.todolistbackend.entities.Todo;
import com.belkacem.todolistbackend.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;
	
	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

}
