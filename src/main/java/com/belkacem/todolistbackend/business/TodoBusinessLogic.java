package com.belkacem.todolistbackend.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.belkacem.todolistbackend.entities.Todo;
import com.belkacem.todolistbackend.exceptions.EntityAlreadyExistsException;
import com.belkacem.todolistbackend.service.TodoService;

import liquibase.pro.packaged.iF;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TodoBusinessLogic {

	private final TodoService todoService;

	public List<Todo> getAllTodos() {
		List<Integer> ids = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		List<Todo> todos = todoService.getAllTodos();
		todos.forEach(t -> {
			if (t.getRelatedState().equals("TODO")) {
				map.put((int) t.getId(), todos.indexOf(t));
				ids.add((int) t.getId());
			}

		});
		Collections.swap(todos, 0, map.get(Collections.max(ids)));

		return todos;
	}

	public Todo saveTodo(Todo todo) {
		Todo t = todoService.findByTitle(todo.getTitle());
		if (todo.getId() == 0 && t != null) {
			throw new EntityAlreadyExistsException(
					"A TODO with the sane title <<" + todo.getTitle() + ">> is already exists");
		}
		return todoService.saveTodo(todo);
	}

	public Todo getOneTodo(long id) {
		return todoService.getOneTodo(id);
	}

}
