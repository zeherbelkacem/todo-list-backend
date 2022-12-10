package com.belkacem.todolistbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belkacem.todolistbackend.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
}
