package com.belkacem.todolistwebservice.resource;

import com.belkacem.todolistservice.business.TaskBusinessLogic;
import com.belkacem.todolistservice.dto.PageableTasksDTO;
import com.belkacem.todolistservice.dto.StateRequestDTO;
import com.belkacem.todolistservice.dto.TaskRequestDTO;
import com.belkacem.todolistservice.dto.TaskResponseDTO;
import com.belkacem.todolistservice.entities.RelatedState;
import com.belkacem.todolistservice.entities.Task;
import io.swagger.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo-list/v1")
@RequiredArgsConstructor
public class TodosResources {

	private final TaskBusinessLogic taskBusinessLogic;

	@GetMapping("/")
	public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
		return new ResponseEntity<>(taskBusinessLogic.getAllTasks(), HttpStatus.OK);
	}

	@GetMapping("/tasks-by-state")
	public ResponseEntity<Map<String, List<TaskResponseDTO>>> getTasksByState(){
		return new ResponseEntity<>(taskBusinessLogic.getTasksByState(), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	public ResponseEntity<PageableTasksDTO> getAllTasksPagePerPage(Long id, String title, String relatedState,
																   boolean status, String description, Pageable pageable) {
		return new ResponseEntity<>(
			taskBusinessLogic.getAllTasksPagePerPage(id, title, relatedState, status, description, pageable),
				HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Task> saveTask(@RequestBody TaskRequestDTO taskRequestDTO, @RequestParam long stateId) {
		return new ResponseEntity<>(taskBusinessLogic.saveTask(taskRequestDTO, stateId), HttpStatus.CREATED);
	}

	@Operation(summary = "GET.TASK.BY.ID", description = "description test")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Not found - The product was not found")
	})
	@GetMapping("/{id}")
	public Task getOneTask(@PathVariable("id") long id) {
		return taskBusinessLogic.getOneTask(id);
	}

	@PutMapping("/")
	public void updateTask(@RequestBody TaskRequestDTO taskRequestDTO, @RequestParam long stateId) {
		taskBusinessLogic.updateTask(taskRequestDTO, stateId);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteTask(@PathVariable("id") long id) {
		try {
			taskBusinessLogic.deleteTask(id);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.NOT_FOUND;
		}
	}

	@GetMapping("/tasks-done")
	public List<Task> getDoneTask() {
		return taskBusinessLogic.getDoneTasks();
	}

	@GetMapping("/tasks-todo")
	public List<Task> getTodoTask() {
		return taskBusinessLogic.getTodoTasks();
	}

	@PostMapping("/state")
	public ResponseEntity<RelatedState> saveRelatedState(@RequestBody StateRequestDTO stateRequestDTO) {
		return new ResponseEntity<>(taskBusinessLogic.saveRelatedState(stateRequestDTO), HttpStatus.CREATED);
	}
}
