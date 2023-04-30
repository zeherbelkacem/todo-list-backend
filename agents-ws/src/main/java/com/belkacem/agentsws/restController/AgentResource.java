package com.belkacem.agentsws.restController;

import com.belkacem.agentsservice.dto.AgentDTO;
import com.belkacem.agentsservice.dto.AgentRequestDTO;
import com.belkacem.agentsservice.dto.AgentResponseDTO;
import com.belkacem.agentsservice.entities.Agent;
import com.belkacem.agentsservice.service.AgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/agents")
    public ResponseEntity<List<AgentResponseDTO>> getAllAgents(){
        log.info("Service: Retrieve All Agents");
        return new ResponseEntity<>(agentServiceImpl.getAllAgents(), HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Agent> updateAgent(@RequestBody AgentDTO agentDTO, @PathVariable String name){
        log.info("Service: Update Agent {}", agentDTO);
        return new ResponseEntity<>(agentServiceImpl.updateAgent(agentDTO, name), HttpStatus.OK);
    }
}
