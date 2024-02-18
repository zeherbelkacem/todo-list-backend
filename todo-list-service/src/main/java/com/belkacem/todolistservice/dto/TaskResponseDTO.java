package com.belkacem.todolistservice.dto;

import com.belkacem.todolistservice.entities.RelatedState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDTO {

	private long id;
	private String title;
	private RelatedState relatedState;
	private boolean status;
	private String description;
}
