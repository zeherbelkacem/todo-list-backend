package com.belkacem.agentsws.restController;

import com.belkacem.agentsservice.dto.AgentRequestDTO;
import com.belkacem.agentsservice.entities.Agent;
import com.belkacem.agentsservice.exceptions.AgentAlreadyExistsException;
import com.belkacem.agentsservice.service.AgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1")
@Slf4j
public class AgentResource {

    private final AgentService agentServiceImpl;

    @PostMapping("/agents")
    public ResponseEntity<Agent> addAgent(@RequestBody AgentRequestDTO agentRequestDTO) {
        log.info("Resource: Save Agent {} ", agentRequestDTO);
        return new ResponseEntity<>(agentServiceImpl.addAgent(agentRequestDTO), HttpStatus.CREATED);
    }
}
