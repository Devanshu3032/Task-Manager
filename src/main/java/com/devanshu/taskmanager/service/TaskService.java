package com.devanshu.taskmanager.service;

import com.devanshu.taskmanager.entity.Task;
import com.devanshu.taskmanager.exception.TaskNotFoundException;
import com.devanshu.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

   public Page<Task> getAllTasks(
        int page,
        int size,
        String sortBy,
        String direction) {

    Sort sort = direction.equalsIgnoreCase("desc")
            ? Sort.by(sortBy).descending()
            : Sort.by(sortBy).ascending();

    Pageable pageable = PageRequest.of(page, size, sort);

    return taskRepository.findAll(pageable);
}

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id : " + id));
    }

 public Page<Task> getTasksByStatus(
        String status,
        int page,
        int size,
        String sortBy,
        String direction) {

    Sort sort = direction.equalsIgnoreCase("desc")
            ? Sort.by(sortBy).descending()
            : Sort.by(sortBy).ascending();

    Pageable pageable = PageRequest.of(page, size, sort);

    return taskRepository.findByStatus(status, pageable);
}

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask == null) {
            return null;
        }

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setPriority(task.getPriority());
        existingTask.setDueDate(task.getDueDate());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}