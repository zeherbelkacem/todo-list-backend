package com.belkacem.agentsservice.repository;

import com.belkacem.agentsservice.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    public Agent findByName(String name);
}
