package com.metadeth.taskmanager.service;

import com.metadeth.taskmanager.model.Task;
import com.metadeth.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask (Long id, Task taskDetails) {
      Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
      task.setTitle(taskDetails.getTitle());
      task.setDescription(taskDetails.getDescription());
      task.setCompleted(taskDetails.isCompleted());
      return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
      taskRepository.deleteById(id);
    }
}