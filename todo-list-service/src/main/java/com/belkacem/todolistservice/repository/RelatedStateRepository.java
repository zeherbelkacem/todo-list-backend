package com.belkacem.todolistservice.repository;

import com.belkacem.todolistservice.entities.RelatedState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatedStateRepository extends JpaRepository<RelatedState, Long> {
    public RelatedState findByState(String state);
}
