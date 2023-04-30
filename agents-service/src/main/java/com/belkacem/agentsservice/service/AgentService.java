package com.belkacem.agentsservice.service;

import com.belkacem.agentsservice.dto.AgentDTO;
import com.belkacem.agentsservice.dto.AgentRequestDTO;
import com.belkacem.agentsservice.dto.AgentResponseDTO;
import com.belkacem.agentsservice.entities.Agent;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface AgentService {
    public Agent addAgent(AgentRequestDTO agentRequestDTO);

    public List<AgentResponseDTO> getAllAgents();

    public Agent updateAgent(AgentDTO agentDTO, String name);

    HttpStatus deleteAgent(Long id);
}
