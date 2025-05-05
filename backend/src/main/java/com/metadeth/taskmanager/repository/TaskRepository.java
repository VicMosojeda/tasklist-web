package com.metadeth.taskmanager.repository;

import com.metadeth.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByTitle(String title);
}