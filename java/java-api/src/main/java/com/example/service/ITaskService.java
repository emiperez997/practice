package com.example.service;

import java.util.List;

import com.example.entity.Task;

public interface ITaskService {

  // Save a new task
  Task createTask(Task task);

  // Read operation
  List<Task> fetchTaskList();

  // By Id
  Task fetchTaskById(Long id);

  // Check task
  Task checkTask(Long id);

  // Update operation
  Task updateTask(Long id, Task task);

  // Delete operation
  void deleteTask(Long id);

}
