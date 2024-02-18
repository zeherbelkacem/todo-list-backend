package com.belkacem.todolistservice.business;


import com.belkacem.todolistservice.dto.PageableTasksDTO;
import com.belkacem.todolistservice.dto.StateRequestDTO;
import com.belkacem.todolistservice.dto.TaskRequestDTO;
import com.belkacem.todolistservice.dto.TaskResponseDTO;
import com.belkacem.todolistservice.entities.RelatedState;
import com.belkacem.todolistservice.entities.Task;
import com.belkacem.todolistservice.exceptions.EntityAlreadyExistsException;
import com.belkacem.todolistservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TaskBusinessLogic {

	private final TaskService taskService;

	public List<TaskResponseDTO> getAllTasks() {
		return taskService.getAllTasks();
	}

	public Task saveTask(TaskRequestDTO taskRequestDTO, long stateId) {
		Task task = taskService.findByTitle(taskRequestDTO.getTitle());
		if (task != null) {
			throw new EntityAlreadyExistsException(
					"A TASK with the same title <<" + task.getTitle() + ">> already exists");
		}
		return taskService.saveTask(taskRequestDTO, stateId);
	}

	public Task getOneTask(long id) {
		return taskService.getOneTask(id);
	}

	public void updateTask(TaskRequestDTO taskRequestDTO, long stateId) {
		taskService.updateTask(taskRequestDTO, stateId);
	}

	public void deleteTask(long id) {
		taskService.deleteTask(id);
	}

	public List<Task> getDoneTasks() {
		return taskService.getDoneTasks();
	}
	
	public List<Task> getTodoTasks() {
		return taskService.getTodoTasks();
	}

	public PageableTasksDTO getAllTasksPagePerPage(Long id, String title, String relatedState, boolean status,
												   String description, Pageable pageable) {
		return taskService.findByPagesAndFilters(id, title, relatedState, status, description, pageable);
	}

	public RelatedState saveRelatedState(StateRequestDTO stateRequestDTO) {
		return taskService.saveRelatedState(stateRequestDTO);
	}

	public Map<String, List<TaskResponseDTO>> getTasksByState() {
		return  taskService.getTasksByState();
	}
}
