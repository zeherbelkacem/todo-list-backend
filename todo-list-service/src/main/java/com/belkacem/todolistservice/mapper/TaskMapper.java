package com.belkacem.todolistservice.mapper;

import com.belkacem.todolistservice.dto.StateRequestDTO;
import com.belkacem.todolistservice.dto.TaskRequestDTO;
import com.belkacem.todolistservice.dto.TaskResponseDTO;
import com.belkacem.todolistservice.entities.RelatedState;
import com.belkacem.todolistservice.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
	
	TaskResponseDTO taskToTaskResponseDTO(Task task);
	Task taskRequestDTOToTask(TaskRequestDTO taskRequestDTO);
	RelatedState stateRequestDTOToRelatedState(StateRequestDTO stateRequestDTO);
}
