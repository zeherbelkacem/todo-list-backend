package com.belkacem.todolistservice.service;

import com.belkacem.todolistservice.dto.PageableTasksDTO;
import com.belkacem.todolistservice.dto.StateRequestDTO;
import com.belkacem.todolistservice.dto.TaskRequestDTO;
import com.belkacem.todolistservice.dto.TaskResponseDTO;
import com.belkacem.todolistservice.entities.RelatedState;
import com.belkacem.todolistservice.entities.Task;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface TaskService {

	List<TaskResponseDTO> getAllTasks();

	Task saveTask(TaskRequestDTO taskRequestDTO, long stateId);

	Task getOneTask(long id);

	Task findByTitle(String title);

	void deleteTask(long id);

	List<Task> getDoneTasks();
	
	List<Task> getTodoTasks();
	
	PageableTasksDTO findByPagesAndFilters(Long id, String title, String relatedState,
										   boolean status, String description, Pageable pageable);

	RelatedState getRelatedStateById(long id);

	RelatedState saveRelatedState(StateRequestDTO stateRequestDTO);

	void updateTask(TaskRequestDTO taskRequestDTO, long stateId);

	Map<String, List<TaskResponseDTO>> getTasksByState();
}
