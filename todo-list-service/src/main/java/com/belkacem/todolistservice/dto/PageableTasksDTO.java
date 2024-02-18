package com.belkacem.todolistservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageableTasksDTO {
	private long totalElements;
	private int numberOfElements;
	private int totalPages;
	private List<TaskResponseDTO> content;
}
