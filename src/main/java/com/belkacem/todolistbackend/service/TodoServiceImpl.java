package com.belkacem.todolistbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belkacem.todolistbackend.entities.Todo;
import com.belkacem.todolistbackend.exceptions.ResourceNotFoundID;
import com.belkacem.todolistbackend.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findByOrderByDoneAsc();
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo getOneTodo(long id) {
		return todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundID("Resource not found"));
	}

	@Override
	public Todo findByTitle(String title) {
		return todoRepository.findByTitle(title);
	}

}
