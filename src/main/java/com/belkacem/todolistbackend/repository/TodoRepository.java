package com.belkacem.todolistbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.belkacem.todolistbackend.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	public List<Todo> findByOrderByDoneAsc();

	public List<Todo> findByOrderByDoneDesc(); 
	
	public Todo findByTitle(String title);

	@Query(value = "SELECT * FROM todo t WHERE t.is_done = false", nativeQuery = true)
	List<Todo> findAllTodoTODO();

	@Query(value = "SELECT * FROM todo t WHERE t.is_done = true", nativeQuery = true)
	List<Todo> findAllDoneTODO();

}
