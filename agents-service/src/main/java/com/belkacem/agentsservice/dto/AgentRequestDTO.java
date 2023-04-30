package com.belkacem.agentsservice.dto;

import com.belkacem.agentsservice.entities.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
