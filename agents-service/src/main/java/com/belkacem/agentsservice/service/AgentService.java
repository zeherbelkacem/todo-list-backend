package com.belkacem.agentsservice.service;

import com.belkacem.agentsservice.dto.AgentRequestDTO;
import com.belkacem.agentsservice.dto.AgentResponseDTO;
import com.belkacem.agentsservice.entities.Agent;

import java.util.List;

public interface AgentService {
    public Agent addAgent(AgentRequestDTO agentRequestDTO);

    public List<AgentResponseDTO> getAllAgents();
}
