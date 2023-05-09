package com.belkacem.agentsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentRequestDTO {

	private String os;
	private String ip;
	private String name;
	private String version;

}
