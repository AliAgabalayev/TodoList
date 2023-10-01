package com.todo.list.service;

import com.todo.list.dao.entity.Task;
import com.todo.list.dto.request.TaskCreation;

import java.util.List;

public interface TaskService {
List<Task> getTasksByEmail(String email);
Task getTaskById(Long id);
List<Task> getArchiveTasks(String email);
Task updateTask(Long id,TaskCreation taskCreation);
Task createTaskByEmail(String email, TaskCreation taskCreation);
void deleteTask(Long id);
void archiveTask(Long id);
void unarchiveTask(Long id);
}
