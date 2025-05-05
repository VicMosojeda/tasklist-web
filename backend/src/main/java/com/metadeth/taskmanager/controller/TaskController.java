package com.metadeth.taskmanager.controller;

import com.metadeth.taskmanager.model.Task;
import com.metadeth.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService) {
      this.taskService = taskService;
  }

  @GetMapping
  public List<Task> getAllTasks() {
    return taskService.getAllTasks();
  }

  @GetMapping("/{id}")
  public Task getTaskById(@PathVariable Long id) {
    return taskService.getTaskById(id)
              .orElseThrow(() -> new RuntimeException("Task not found"));
  }

  @PostMapping
  public Task createTask(@RequestBody Task task) {
    return taskService.createTask(task);
  }

  @PutMapping("/{id}")
  public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
    return taskService.updateTask(id, taskDetails);
  }

  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable Long id) {
    taskService.deleteTask(id);
  }
}