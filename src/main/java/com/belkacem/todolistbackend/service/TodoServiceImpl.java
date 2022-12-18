package com.belkacem.todolistbackend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.belkacem.todolistbackend.entities.Todo;
import com.belkacem.todolistbackend.exceptions.ResourceNotFoundID;
import com.belkacem.todolistbackend.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;

	@Override
	public List<Todo> getAllTodos() {

		List<Todo> dones = todoRepository.findAllDoneTODO();
		List<Todo> todos = todoRepository.findAllTodoTODO();
		List<Todo> allTodos = new ArrayList<>();
		List<Integer> ids = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		if (!todos.isEmpty()) {
			todos.forEach(t -> {
				map.put((int) t.getId(), todos.indexOf(t));
				ids.add((int) t.getId());
			}); 
			Collections.swap(todos, 0, map.get(Collections.max(ids)));
		}
		allTodos.addAll(todos);
		allTodos.addAll(dones);
		return allTodos;
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo getOneTodo(long id) {
		return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundID("Resource not found"));
	}

	@Override
	public Todo findByTitle(String title) {
		return todoRepository.findByTitle(title);
	}

	@Override
	public void deleteTodo(long id) {
		todoRepository.deleteById(id);
	}

	@Override
	public List<Todo> getDoneTODOs() {
		return todoRepository.findAllDoneTODO();
	}

	@Override
	public List<Todo> getTodoTODOs() {
		return todoRepository.findAllTodoTODO();
	}

}
