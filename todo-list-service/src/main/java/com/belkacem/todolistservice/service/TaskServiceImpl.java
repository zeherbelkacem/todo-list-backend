package com.belkacem.todolistservice.service;

import com.belkacem.todolistservice.dto.PageableTasksDTO;
import com.belkacem.todolistservice.dto.StateRequestDTO;
import com.belkacem.todolistservice.dto.TaskRequestDTO;
import com.belkacem.todolistservice.dto.TaskResponseDTO;
import com.belkacem.todolistservice.entities.RelatedState;
import com.belkacem.todolistservice.entities.Task;
import com.belkacem.todolistservice.exceptions.ResourceNotFoundID;
import com.belkacem.todolistservice.mapper.TaskMapper;
import com.belkacem.todolistservice.repository.RelatedStateRepository;
import com.belkacem.todolistservice.repository.TaskRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Builder
public class TaskServiceImpl implements TaskService {

    static final String RESOURCE_NOT_FOUND = "Resource not found";
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RelatedStateRepository stateRepository;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<TaskResponseDTO> getAllTasks() {

        List<Task> doneTaskList = taskRepository.findAllDoneTask();
        List<Task> todoTaskList = taskRepository.findAllTodoTask();
        List<Task> allTasks = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        if (!todoTaskList.isEmpty()) {
            todoTaskList.forEach(t -> {
                map.put((int) t.getId(), todoTaskList.indexOf(t));
                ids.add((int) t.getId());
            });
            Collections.swap(todoTaskList, 0, map.get(Collections.max(ids)));
        }
        allTasks.addAll(todoTaskList);
        allTasks.addAll(doneTaskList);
        List<TaskResponseDTO> responseDTOs = new ArrayList<>();
        allTasks.forEach(t -> responseDTOs.add(taskMapper.taskToTaskResponseDTO(t)));
        return responseDTOs;
    }

    @Override
    public Task saveTask(TaskRequestDTO taskRequestDTO, long stateId) {
        Task task = taskMapper.taskRequestDTOToTask(taskRequestDTO);
        RelatedState relatedStateTemp = stateRepository.findById(stateId)
                .orElseThrow(() -> new ResourceNotFoundID(RESOURCE_NOT_FOUND));
        task.setRelatedState(relatedStateTemp);
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task getOneTask(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundID(RESOURCE_NOT_FOUND));
    }

    @Override
    public Task findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getDoneTasks() {
        return taskRepository.findAllDoneTask();
    }

    @Override
    public List<Task> getTodoTasks() {
        return taskRepository.findAllTodoTask();
    }

    @Override
    public PageableTasksDTO findByPagesAndFilters(Long id, String title, String relatedState, boolean status,
                                                  String description, Pageable pageable) {

        Page<Task> pageables = taskRepository.findByIdOrTitleContainsOrRelatedStateContainsOrStatusOrDescriptionContains(
                id, title, relatedState, status, description, pageable);

        List<TaskResponseDTO> taskResponseDTOs = new ArrayList<>();
        pageables.getContent().forEach(p -> taskResponseDTOs.add(taskMapper.taskToTaskResponseDTO(p)));
        return null;
    }

    @Override
    public RelatedState getRelatedStateById(long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundID(RESOURCE_NOT_FOUND));
    }

    @Override
    public RelatedState saveRelatedState(StateRequestDTO stateRequestDTO) {
        RelatedState relatedState = taskMapper.stateRequestDTOToRelatedState(stateRequestDTO);
        return stateRepository.save(relatedState);
    }

    @Override
    @Transactional
    public void updateTask(TaskRequestDTO taskRequestDTO, long stateId) {
        Task task = taskMapper.taskRequestDTOToTask(taskRequestDTO);
        RelatedState relatedState = stateRepository.findById(stateId)
                .orElseThrow(() -> new ResourceNotFoundID(RESOURCE_NOT_FOUND));
        if (!task.isStatus()) {
            task.setStatus(true);
            relatedState.setState("DONE");
        }else {
            task.setStatus(false);
            relatedState.setState("TO DO");
        }
        stateRepository.save(relatedState);
        task.setRelatedState(relatedState);
        taskRepository.save(task);
    }

    @Override
    public Map<String, List<TaskResponseDTO>> getTasksByState() {
        Map<String, List<TaskResponseDTO>> taskMap = new HashMap<>();
        List<RelatedState> relatedStateList = stateRepository.findAll();
        List<Task> taskList = taskRepository.findAll();
        relatedStateList.forEach(state -> {
            List<TaskResponseDTO> responseDTOs = new ArrayList<>();
            List<Task> taskListTemp = new ArrayList<>();
            taskList.forEach(task -> {
                if(task.getRelatedState().getId() == state.getId()) {
                    taskListTemp.add(task);
                }
            });
            taskListTemp.forEach(t -> responseDTOs.add(taskMapper.taskToTaskResponseDTO(t)));
            taskMap.put(state.getState(), responseDTOs);
        });
        return taskMap;
    }

}
