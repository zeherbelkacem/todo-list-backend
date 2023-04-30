package com.belkacem.agentsservice.service;

import com.belkacem.agentsservice.dto.AgentRequestDTO;
import com.belkacem.agentsservice.entities.Agent;

public interface AgentService {
    public Agent addAgent(AgentRequestDTO agentRequestDTO);
}
