package com.todo.list.service.impl;

import com.todo.list.dao.entity.Task;
import com.todo.list.dao.entity.User;
import com.todo.list.dao.repository.TaskRepository;
import com.todo.list.dao.repository.UserRepository;
import com.todo.list.dto.request.TaskCreation;
import com.todo.list.mapper.TaskMapper;
import com.todo.list.model.TaskStatus;
import com.todo.list.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

private final UserRepository userRepository;
private final TaskRepository taskRepository;

    @Override
    public List<Task> getTasksByEmail(String email) {
        User user=userRepository.findByEmail(email);
        return user.getTasks();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task=taskRepository.findById(id);
        return task.get();
    }

    @Override
    public List<Task> getArchiveTasks(String email) {
        User user=userRepository.findByEmail(email);
        List<Task> archiveTasks=new ArrayList<>();
        for (Task task:user.getTasks()){
        if(task.getTaskStatus() == TaskStatus.ARCHIVED)
            archiveTasks.add(task);

        }
        return archiveTasks;
    }

    @Override
    public Task createTaskByEmail(String email, TaskCreation taskCreation) {
        User user=userRepository.findByEmail(email);
        Task task= TaskMapper.INSTANCE.dtoToEntity(taskCreation);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
    taskRepository.deleteById(id);
    }

    @Override
    public void archiveTask(Long id) {
        Optional<Task> taskOptional=taskRepository.findById(id);
        Task task=taskOptional.get();
        if(task.getTaskStatus()!=TaskStatus.ARCHIVED) {
            task.setTaskStatus(TaskStatus.ARCHIVED);
            taskRepository.save(task);
        }
        else throw new RuntimeException();
    }

    @Override
    public void unarchiveTask(Long id) {
        Optional<Task> taskOptional=taskRepository.findById(id);
        Task task=taskOptional.get();
        if(task.getTaskStatus()!=TaskStatus.ACTIVE) {
            task.setTaskStatus(TaskStatus.ACTIVE);
            taskRepository.save(task);
        }
       else throw new RuntimeException();
    }

    @Override
    public Task updateTask(Long id, TaskCreation taskCreation) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (taskCreation.getTaskName() != null) {
                task.setTaskName(taskCreation.getTaskName());
            }
            if (taskCreation.getTaskStatus() != null) {
                task.setTaskStatus(taskCreation.getTaskStatus());
            }
            if (taskCreation.getDescription() != null) {
                task.setDescription(taskCreation.getDescription());
            }
            if (taskCreation.getTaskDeadlineDate() != null) {
                task.setTaskDeadlineDate(taskCreation.getTaskDeadlineDate());
            }
            return taskRepository.save(task);
        } else {
            throw new RuntimeException();
        }
    }
}
