package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Task;
import com.example.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

  @Autowired
  private TaskService taskService;

  // Post
  @PostMapping("/task")
  public Task saveTask(@RequestBody Task task) {
    return taskService.createTask(task);
  }

  // Read
  @GetMapping("/tasks")
  public Iterable<Task> readAllTasks() {
    return taskService.fetchTaskList();
  }

  // Get By Id
  @GetMapping("/task/{id}")
  public Task readTaskById(@PathVariable("id") Long taskId) {
    return taskService.fetchTaskById(taskId);
  }

  // Check Task
  @GetMapping("/task/{id}/check")
  public Task checkTask(@PathVariable("id") Long taskId) {
    return taskService.checkTask(taskId);
  }

  // Update
  @PutMapping("/task/{id}")
  public Task updateTask(@RequestBody Task task, @PathVariable("id") Long taskId) {
    return taskService.updateTask(taskId, task);
  }

  // Delete
  @DeleteMapping("/task/{id}")
  public void deleteTask(@PathVariable("id") Long taskId) {
    taskService.deleteTask(taskId);
  }

}
