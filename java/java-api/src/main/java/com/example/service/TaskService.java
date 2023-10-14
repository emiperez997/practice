package com.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Task;
import com.example.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Override
  public Task createTask(Task task) {
    return taskRepository.save(task);
  }

  @Override
  public Task checkTask(Long id) {
    Task taskDB = taskRepository.findById(id).get();

    taskDB.setIsCompleted(!taskDB.getIsCompleted());

    return taskRepository.save(taskDB);
  }

  @Override
  public List<Task> fetchTaskList() {
    return (List<Task>) taskRepository.findAll();
  }

  @Override
  public Task fetchTaskById(Long id) {
    return taskRepository.findById(id).get();
  }

  @Override
  public Task updateTask(Long id, Task task) {
    Task taskDB = taskRepository.findById(id).get();

    if (Objects.nonNull(task.getTitle()) && !"".equalsIgnoreCase(task.getTitle())) {
      taskDB.setTitle(task.getTitle());
    }

    if (Objects.nonNull(task.getDescription()) && !"".equalsIgnoreCase(task.getDescription())) {
      taskDB.setDescription(task.getDescription());
    }

    return taskRepository.save(taskDB);

  }

  @Override
  public void deleteTask(Long id) {
    taskRepository.deleteById(id);
  }

}
