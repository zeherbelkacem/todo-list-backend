package com.belkacem.agentsservice.mapper;

import com.belkacem.agentsservice.dto.AgentRequestDTO;
import com.belkacem.agentsservice.dto.AgentResponseDTO;
import com.belkacem.agentsservice.entities.Agent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgentMapper {
	
	AgentResponseDTO agentToAgentResponseDTO(Agent agent);
	Agent agentRequestDTOToAgent(AgentRequestDTO agentRequestDTO);
}
