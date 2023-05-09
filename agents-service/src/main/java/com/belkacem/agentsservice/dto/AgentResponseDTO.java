package com.belkacem.agentsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentResponseDTO {

	private long id;
	private String os;
	private Date lastKeepAlive;
	private Date dateAdd;
	private String ip;
	private String name;
	private String version;
	private String status;

}
