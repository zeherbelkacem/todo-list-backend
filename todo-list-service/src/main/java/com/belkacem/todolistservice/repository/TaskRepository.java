package com.belkacem.todolistservice.repository;

import com.belkacem.todolistservice.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	public List<Task> findByOrderByStatusAsc();

	public List<Task> findByOrderByStatusDesc();

	public Task findByTitle(String title);

	@Query(value = "SELECT * FROM task t WHERE t.status = false", nativeQuery = true)
	List<Task> findAllTodoTask();

	@Query(value = "SELECT * FROM task t WHERE t.status = true", nativeQuery = true)
	List<Task> findAllDoneTask();

	Page<Task> findByIdOrTitleContainsOrRelatedStateContainsOrStatusOrDescriptionContains(Long id, String title, String relatedState,
			boolean status, String description, Pageable pageable);
}
