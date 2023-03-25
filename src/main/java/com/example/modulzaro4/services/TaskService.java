package com.example.modulzaro4.services;

import com.example.modulzaro4.dtos.TaskDTO;
import com.example.modulzaro4.exceptions.ResourceNotFoundException;
import com.example.modulzaro4.models.Task;
import com.example.modulzaro4.repositories.TaskRepositoryI;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepositoryI taskRepository;

    @Autowired
    public TaskService(TaskRepositoryI taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByID(Long id) {
        Optional<Task> result = taskRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResourceNotFoundException("Task with id: " + id + " is not found.");
    }

    public TaskDTO getTaskDTOByTaskID(Long id) {
        Task task = getTaskByID(id);
        return new TaskDTO(task.getId(), task.getDetail(), task.getDeadLine(), task.getNameId(), task.getUser().getName());
    }

    @Transactional
    public void deleteTaskById(Long id) {
            taskRepository.deleteById(id);
    }
}
