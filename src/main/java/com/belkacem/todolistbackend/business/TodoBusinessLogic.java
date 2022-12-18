package com.belkacem.todolistbackend.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.belkacem.todolistbackend.entities.Todo;
import com.belkacem.todolistbackend.exceptions.EntityAlreadyExistsException;
import com.belkacem.todolistbackend.service.TodoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TodoBusinessLogic {

	private final TodoService todoService;

	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
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

	public void update(Todo todo) {
		if (!todo.isDone()) {
			todo.setDone(true);
			todo.setRelatedState("DONE");
			todoService.saveTodo(todo);
		}else {
			todo.setDone(false);
			todo.setRelatedState("TODO");
			todoService.saveTodo(todo);
		}
	}

	public void deleteTodo(long id) {
		todoService.deleteTodo(id);
	}

	public List<Todo> getDoneTODOs() {
		return todoService.getDoneTODOs();
	}
	
	public List<Todo> getTodoTODOs() {
		return todoService.getTodoTODOs();
	}

}
