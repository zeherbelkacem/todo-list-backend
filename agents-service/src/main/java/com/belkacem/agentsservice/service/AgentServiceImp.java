package com.belkacem.agentsservice.service;

import com.belkacem.agentsservice.dto.AgentDTO;
import com.belkacem.agentsservice.dto.AgentRequestDTO;
import com.belkacem.agentsservice.dto.AgentResponseDTO;
import com.belkacem.agentsservice.entities.Agent;
import com.belkacem.agentsservice.entities.StatusEnum;
import com.belkacem.agentsservice.exceptions.AgentAlreadyExistsException;
import com.belkacem.agentsservice.exceptions.ResourceNotFoundException;
import com.belkacem.agentsservice.mapper.AgentMapper;
import com.belkacem.agentsservice.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgentServiceImp implements AgentService{

    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;

    @Override
    public Agent addAgent(AgentRequestDTO agentRequestDTO) {
        log.info("Service: Save Agent {} ", agentRequestDTO);
        Agent agent;

        Agent agentByName = agentRepository.findByName(agentRequestDTO.getName());

        if (agentByName == null) {
            agent = agentMapper.agentRequestDTOToAgent(agentRequestDTO);
            agent.setDateAdd(new Date());
            agent.setLastKeepAlive(null);
            agent.setStatus(StatusEnum.never_connected);
        }
        else {
            log.info("Service: Agent with the same name already exists {} ", agentByName);
            throw new AgentAlreadyExistsException("Agent already exists!!");
        }

        return agentRepository.save(agent);
    }

    @Override
    public List<AgentResponseDTO> getAllAgents() {
        List<Agent> agents = agentRepository.findAll();
        List<AgentResponseDTO> agentResponseDTOS = new ArrayList<>();
        agents.forEach(agent -> {
            agentResponseDTOS.add(agentMapper.agentToAgentResponseDTO(agent));
        });
        log.info("Service: Retrieve All Agents");
        return agentResponseDTOS;
    }

    @Override
    public Agent updateAgent(AgentDTO agentDTO, String name) {
        log.info("Service: Update Agent {} ", agentDTO);
        Agent agent;

        Agent agentByName = agentRepository.findByName(name);

        if (agentByName != null) {
            agent = agentMapper.agentDTOToAgent(agentDTO);
        }
        else {
            log.info("Service: Resource Agent not found using name {} ", agentByName);
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND ,"No Such Agent exists!!");
        }

        return agentRepository.save(agent);
    }

    @Override
    public HttpStatus deleteAgent(Long id) {
        log.info("Service: delete agent with resourceId {}", id);
        try {
            agentRepository.deleteById(id);
            return HttpStatus.NO_CONTENT;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
