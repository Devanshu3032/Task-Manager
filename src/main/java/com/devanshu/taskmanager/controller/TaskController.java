package com.devanshu.taskmanager.controller;

import com.devanshu.taskmanager.entity.Task;
import com.devanshu.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;
import com.devanshu.taskmanager.dto.TaskRequest;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

@GetMapping
public List<Task> getAllTasks(
        @RequestParam(required = false) String status,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction) {

    if (status != null) {
        return taskService.getTasksByStatus(status, sortBy, direction);
    }

    return taskService.getAllTasks(sortBy, direction);
}
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

   @PostMapping
public Task createTask(@Valid @RequestBody TaskRequest request) {

    Task task = new Task();

    task.setTitle(request.getTitle());
    task.setDescription(request.getDescription());
    task.setStatus(request.getStatus());
    task.setPriority(request.getPriority());
    task.setDueDate(request.getDueDate());

    return taskService.createTask(task);
}

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }
}